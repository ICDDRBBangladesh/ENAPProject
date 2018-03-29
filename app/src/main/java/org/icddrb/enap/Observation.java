package org.icddrb.enap;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TabActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.Html;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Common.Connection;
import Common.Global;
import Common.ProjectSetting;
import Utility.MySharedPreferences;

/**
 * Created by thossain on 10/03/2017.
 */


public class Observation extends TabActivity{
    @Override
    public boolean onKeyDown(int iKeyCode, KeyEvent event)
    {
        if(iKeyCode == KeyEvent.KEYCODE_BACK || iKeyCode == KeyEvent.KEYCODE_HOME)
        { return false; }
        else { return true;  }
    }


    SimpleAdapter dataAdapter;
    ArrayList<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();

    static String DEVICEID  = "";
    static String ENTRYUSER = "";
    static String COUNTRYCODE = "";
    static String FACICODE = "";
    static String LOCATION = "";
    static String ROLE     = "";
    static String TABLEID  = "";
    static String DATAID   = "";

    Bundle IDbundle;
    MySharedPreferences sp;

    TextView lblTitle;
    TextView studyId;
    TextView hospitalId;
    TextView patientName;
    TextView patientAge;
    TextView patientAddress;
    TextView location;
    Button cmdPatientList;
    Button cmdObj;
    Button cmdRS;
    Button cmdDE;
    TabHost tabHost1;
    Button cmdStop;
    Button cmdPause;
    LinearLayout secTab;
    TextView lblHeading;

    TabActivity parent;
    TabHost tabhost;

    static Boolean OB  = false;
    static Boolean MRS = false;
    static Boolean DE  = false;
    static String TYPE = "";
    static String PATNAME = "";
    static String PATAGE  = "";
    String Desc = "";

    Connection C;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.observation);
        C = new Connection(this);

        DEVICEID    = sp.getValue(this, "deviceid");
        ENTRYUSER   = sp.getValue(this, "userid");
        COUNTRYCODE = sp.getValue(this, "countrycode");
        FACICODE    = sp.getValue(this, "facicode");

        IDbundle = getIntent().getExtras();
        DATAID   = IDbundle.getString("dataid");
        TABLEID  = IDbundle.getString("tableid");
        TYPE     = IDbundle.getString("type");

        OB = IDbundle.getString("ob").equals("1") ? true : false;
        MRS = IDbundle.getString("mrs").equals("1") ? true : false;
        //DE = IDbundle.getString("ob").equals("1")?true:false;

        PATNAME = IDbundle.getString("name");
        PATAGE  = IDbundle.getString("age");
        /*
            1: Registration
            2: Labour and Delivery
            3: KMC
            4: Sepsis
            5: ACS
         */
        LOCATION  = IDbundle.getString("location");

        /*
        1-Registration
        2-Observation
        3-Exit Interview
        4-Data Extraction
        5-Verification
         */
        ROLE      = IDbundle.getString("role");

        lblHeading = (TextView)findViewById(R.id.lblHeading);
        secTab = (LinearLayout)findViewById(R.id.secTab);
        lblTitle = (TextView)findViewById(R.id.lblTitle);
        studyId = (TextView) findViewById(R.id.txtStudyID);
        studyId.setText(IDbundle.getString("studyid"));

        hospitalId = (TextView) findViewById(R.id.txtHospID);
        hospitalId.setText(IDbundle.getString("hospitalid"));

        patientName = (TextView) findViewById(R.id.txtName);
        patientName.setText(IDbundle.getString("name"));

        patientAge = (TextView) findViewById(R.id.txtAge);
        patientAge.setText(IDbundle.getString("age"));

        patientAddress = (TextView) findViewById(R.id.txtAddress);
        patientAddress.setText(IDbundle.getString("address"));

        location = (TextView) findViewById(R.id.lblType);
        location.setText(IDbundle.getString("location"));

        ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
        cmdBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder adb = new AlertDialog.Builder(Observation.this);
                adb.setTitle("Close");
                adb.setMessage("Do you want to close this form[Yes/No]?");
                adb.setNegativeButton("No", null);
                adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }});
                adb.show();
            }});

        location = (TextView) findViewById(R.id.lblType);
        location.setVisibility(View.INVISIBLE);
        cmdObj = (Button)findViewById(R.id.cmdObj);
        cmdRS = (Button)findViewById(R.id.cmdRS);
        cmdDE = (Button)findViewById(R.id.cmdDE);

        if(OB==true)
            cmdObj.setBackgroundResource(R.drawable.button_style_green);
        else
            cmdObj.setBackgroundResource(R.drawable.button_style_red);

        if(MRS==true)
            cmdRS.setBackgroundResource(R.drawable.button_style_green);
        else
            cmdRS.setBackgroundResource(R.drawable.button_style_red);


        if(IDbundle.getString("location").equals(ProjectSetting.LABOR_AND_DELIVERY_ID))
            lblTitle.setText(ProjectSetting.LABOR_AND_DELIVERY_NAME);
        else if(IDbundle.getString("location").equals(ProjectSetting.KMC_ID))
            lblTitle.setText(ProjectSetting.KMC_NAME);
        else if(IDbundle.getString("location").equals(ProjectSetting.SEPSIS_ID))
            lblTitle.setText(ProjectSetting.SEPSIS_NAME);

        cmdPatientList = (Button)findViewById(R.id.cmdPatientList);
        cmdPatientList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Patient_List_Form(LOCATION);
            }});

        cmdPause = (Button)findViewById(R.id.cmdPause);
        cmdPause.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder adb = new AlertDialog.Builder(Observation.this);
                adb.setTitle("Pause Observation");
                adb.setMessage("Do you want to pause/resume the current observation[Yes/No]?");
                adb.setNegativeButton("No", null);
                adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        C.SaveDT("Update Registration set ObjPause=(case when ObjPause='1' then '2' else '1' end),Upload='2',modifyDate='"+ Global.DateTimeNowYMDHMS() +"' where CountryCode='" + COUNTRYCODE + "' and FaciCode='" + FACICODE + "' and DataId='" + DATAID + "'");

                        String SQL = "";
                        SQL = "Insert into ObjPauseLog(CountryCode, FaciCode, DataID, DT, DeviceID, EntryUser, Upload, modifyDate)Values(";
                        SQL += "'"+ COUNTRYCODE +"',";
                        SQL += "'"+ FACICODE +"',";
                        SQL += "'"+ DATAID +"',";
                        SQL += "'"+ Global.DateTimeNowYMDHMS() +"',";
                        SQL += "'"+ DEVICEID +"',";
                        SQL += "'"+ ENTRYUSER +"',";
                        SQL += "'2',";
                        SQL += "'"+ Global.DateTimeNowYMDHMS() +"')";
                        C.SaveDT(SQL);

                        PauseObservation();

                        dialog.dismiss();
                    }});
                adb.show();
            }});

        cmdStop = (Button)findViewById(R.id.cmdStop);
        cmdStop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String SQL = "";
                String TID = "";
                Desc = "";
                SQL = "Select v.TableId,v.VarName,v.Description from ObjVarList v";
                SQL += " left outer join Observation o on v.TableId=o.TableId and v.VarName=o.VarName and o.CountryCode='" + COUNTRYCODE + "' and o.FaciCode='" + FACICODE + "' and o.DataID='"+ DATAID +"'";
                SQL += " where v.ForceVar='1' and o.Observ not in('Y','C') and o.Active='1'";
                SQL += " order by v.TableId,v.ObjSeq1";

                Cursor cur = C.ReadData(SQL);

                cur.moveToFirst();
                while(!cur.isAfterLast())
                {
                    if(!TID.equals(cur.getString(cur.getColumnIndex("TableId")))) {
                        //1	L & D 1st and 2nd Stage
                        //2	Newborn
                        //3	Resus
                        //4	3rd Stage of PPH
                        //5	L & D Discharge and Outcome
                        if(cur.getString(cur.getColumnIndex("TableId")).equals("1"))
                            Desc = Desc + "<font color=\"#FF0000\">L & D 1st and 2nd Stage</font>";
                        else if(cur.getString(cur.getColumnIndex("TableId")).equals("2"))
                            Desc = Desc + "<br/><br/><font color=\"#FF0000\">Newborn</font>";
                        else if(cur.getString(cur.getColumnIndex("TableId")).equals("3"))
                            Desc = Desc + "<br/><br/><font color=\"#FF0000\">Resus</font>";
                        else if(cur.getString(cur.getColumnIndex("TableId")).equals("4"))
                            Desc = Desc + "<br/><br/><font color=\"#FF0000\">3rd Stage of PPH</font>";
                        else if(cur.getString(cur.getColumnIndex("TableId")).equals("5"))
                            Desc = Desc + "<br/><br/><font color=\"#FF0000\">L & D Discharge and Outcome</font>";
                    }

                    TID = cur.getString(cur.getColumnIndex("TableId"));

                    //if(cur.getString(cur.getColumnIndex("TableId")).equals("1"))
                    Desc = Desc + (Desc.length()==0? cur.getString(cur.getColumnIndex("Description")):"<br/>"+cur.getString(cur.getColumnIndex("Description")));

                    cur.moveToNext();
                }
                cur.close();

                if(Desc.length()==0){
                    //dialog.dismiss();
                    tabHost1.setCurrentTab(4);
                }else{
                    AlertDialog.Builder adb = new AlertDialog.Builder(Observation.this);
                    adb.setTitle(Html.fromHtml("<b>Before you continue stop, please check whether you have filled up the following variables.</b>"));
                    adb.setMessage(Html.fromHtml(Desc + "<br/><br/><b>Do you want to stop observation[Back to Observation/Continue Stop]?</b>"));
                    adb.setNegativeButton("Back to Observation", null);
                    adb.setPositiveButton("Continue Stop", new AlertDialog.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            C.SaveDT("Update Registration set CompleteStatus='stop',modifyDate='"+ Global.DateTimeNowYMDHMS() +"' where CountryCode='" + COUNTRYCODE + "' and FaciCode='" + FACICODE + "' and DataId='" + DATAID + "'");
                            //dialog.dismiss();
                            tabHost1.setCurrentTab(4);
                        }});
                    adb.show();
                }


            }});

        //Hide for Recall Survey
        TextView lblOutcodeStatus = (TextView)findViewById(R.id.lblOutcodeStatus);
        lblOutcodeStatus.setVisibility(View.GONE);
        if(TYPE.equals("rs")) {
            lblHeading.setText("Recall Survey");
            cmdPatientList.setVisibility(View.GONE);
            cmdPause.setVisibility(View.GONE);
            cmdStop.setVisibility(View.GONE);

            String SQL = "";
            SQL = "select ifnull((Case";
            SQL += " when c1cond='1' then ' Alive '";
            SQL += " when c1cond='2' then ' Fresh Still Birth '";
            SQL += " when c1cond='3' then ' Macerated Still Birth '";
            SQL += " when c1cond='4' then ' Still Birth-Condition Unknown '";
            SQL += " when c1cond='5' then ' Neonatal Death '";
            SQL += " when c1cond='6' then ' Baby not delivered ' else ' Unknown ' end),'')Status";
            SQL += " from LD_Outcome Where CountryCode='" + COUNTRYCODE + "' and FaciCode='" + FACICODE + "' and DataId='" + DATAID + "'";

            String OutcomeStatus = C.ReturnSingleValue(SQL);
            lblOutcodeStatus.setText(OutcomeStatus==null?"":OutcomeStatus);
            lblOutcodeStatus.setVisibility(View.VISIBLE);
        }
        else if(TYPE.equals("obj")){
            lblHeading.setText("Observation");
        }else if(TYPE.equals("inf")) {
            lblHeading.setText("Infection Verification");
            cmdPatientList.setVisibility(View.GONE);
            cmdPause.setVisibility(View.GONE);
            cmdStop.setVisibility(View.GONE);
        }

        PopulateTab(LOCATION, DATAID,TABLEID,TYPE);
        PauseObservation();


    }

    public void PauseObservation()
    {
        TextView lblPauseMessage = (TextView)findViewById(R.id.lblPauseMessage);
        String PauseValue = C.ReturnSingleValue("Select (case when ObjPause is null then '2' else ObjPause end)ObjPause from Registration Where CountryCode='" + COUNTRYCODE + "' and FaciCode='" + FACICODE + "' and DataId='" + DATAID + "'");
        if(PauseValue.equals("1")){
            cmdPause.setText("Resume");
            cmdPause.setBackgroundResource(R.drawable.button_style_line_red);
            lblPauseMessage.setVisibility(View.VISIBLE);
            secTab.setVisibility(View.GONE);
        }else{
            cmdPause.setText("Pause");
            cmdPause.setBackgroundResource(R.drawable.button_style_line_green);
            lblPauseMessage.setVisibility(View.GONE);
            secTab.setVisibility(View.VISIBLE);
        }
    }

    public static void setTabColor(TabHost tabhost) {
        for (int i = 0; i < tabhost.getTabWidget().getChildCount(); i++) {
            tabhost.getTabWidget().getChildAt(i)
                .setBackgroundResource(R.drawable.repeat_bg); // unselected
                //.setBackgroundColor(Color.WHITE);
        }
        tabhost.getTabWidget().setCurrentTab(0);
        tabhost.getTabWidget().getChildAt(tabhost.getCurrentTab())
                //.setBackgroundResource(R.drawable.repeat_bg); // selected
                .setBackgroundColor(Color.YELLOW);
    }

    private void PopulateTab(String LocationID, String DataID, String TableID, String Type)
    {
        tabHost1 = getTabHost();
        tabHost1.clearAllTabs();
        tabHost1.setOnTabChangedListener(new TabHost.OnTabChangeListener(){
            @Override
            public void onTabChanged(final String tabId) {
                if(TYPE.equals("obj") & LOCATION.equals(ProjectSetting.LABOR_AND_DELIVERY_ID)) {
                    if (tabId.equals("finalOut")) {
                        setTabColor(tabHost1);
                    } else {
                        setTabColor(tabHost1);
                        Observation_Time activity = (Observation_Time) getLocalActivityManager().getActivity(tabId);

                        if (tabId.equals("BirthObj")) {
                            activity.prepareVariableListData("1", DATAID, "w", "");
                            activity.refreshAdapter();
                        } else if (tabId.equals("Newborn")) {
                            activity.spnChildSl.setSelection(0);
                            activity.prepareVariableListData("2", DATAID, "c", "1");
                            activity.refreshAdapter();
                        } else if (tabId.equals("BirthAsph")) {
                            activity.spnChildSl.setSelection(0);
                            activity.prepareVariableListData("3", DATAID, "r", "1");
                            activity.refreshAdapter();
                        } else if (tabId.equals("PPH")) {
                            activity.prepareVariableListData("4", DATAID, "w", "");
                            activity.refreshAdapter();
                        } else if (tabId.equals("finalOut")) {
                            LD_Outcome activity1 = (LD_Outcome) getLocalActivityManager().getActivity(tabId);
                            activity1.COUNTRYCODE = COUNTRYCODE;
                            activity1.FACICODE = FACICODE;
                            activity1.DATAID = DATAID;
                            activity1.ClearForm();
                            activity1.DataSearch(COUNTRYCODE, FACICODE, DATAID);
                        }
                    }
                }else if(TYPE.equals("obj") & LOCATION.equals(ProjectSetting.KMC_ID)){
                    setTabColor(tabHost1);
                    if (tabId.equals("KmcIni")) {
                        KMC_Init activity1 = (KMC_Init) getLocalActivityManager().getActivity(tabId);
                        activity1.COUNTRYCODE = COUNTRYCODE;
                        activity1.FACICODE = FACICODE;
                        activity1.DATAID = DATAID;
                        //activity1.ClearForm();
                        activity1.DataSearch(COUNTRYCODE, FACICODE, DATAID);
                    }
                }else if(TYPE.equals("rs")){
                    setTabColor(tabHost1);

                    if (tabId.equals("LD_rs1")) {
                        RecallSurvS1 activity1 = (RecallSurvS1) getLocalActivityManager().getActivity(tabId);
                        activity1.COUNTRYCODE = COUNTRYCODE;
                        activity1.FACICODE = FACICODE;
                        activity1.DATAID = DATAID;
                    } else if (tabId.equals("LD_rs2")) {
                        RecallSurvS2 activity1 = (RecallSurvS2) getLocalActivityManager().getActivity(tabId);
                        activity1.COUNTRYCODE = COUNTRYCODE;
                        activity1.FACICODE = FACICODE;
                        activity1.DATAID = DATAID;
                    } else if (tabId.equals("INFXN_rs3")) {
                        RecallSurvS3 activity1 = (RecallSurvS3) getLocalActivityManager().getActivity(tabId);
                        activity1.COUNTRYCODE = COUNTRYCODE;
                        activity1.FACICODE = FACICODE;
                        activity1.DATAID = DATAID;
                    } else if (tabId.equals("KMC_rs4")) {
                        RecallSurvS4 activity1 = (RecallSurvS4) getLocalActivityManager().getActivity(tabId);
                        activity1.COUNTRYCODE = COUNTRYCODE;
                        activity1.FACICODE = FACICODE;
                        activity1.DATAID = DATAID;
                    } else if (tabId.equals("LD_rs5")) {
                        RecallSurvS5 activity1 = (RecallSurvS5) getLocalActivityManager().getActivity(tabId);
                        activity1.COUNTRYCODE = COUNTRYCODE;
                        activity1.FACICODE = FACICODE;
                        activity1.DATAID = DATAID;
                    } else if (tabId.equals("LD_rs6")) {
                        MRS_FinalStatus activity1 = (MRS_FinalStatus) getLocalActivityManager().getActivity(tabId);
                        activity1.COUNTRYCODE = COUNTRYCODE;
                        activity1.FACICODE = FACICODE;
                        activity1.DATAID = DATAID;
                    } else if (tabId.equals("LD_follow")) {
                        MRS_FollowUp activity1 = (MRS_FollowUp) getLocalActivityManager().getActivity(tabId);
                        activity1.COUNTRYCODE = COUNTRYCODE;
                        activity1.FACICODE = FACICODE;
                        activity1.DATAID = DATAID;
                    }



                }
                else if(TYPE.equals("inf")){
                    setTabColor(tabHost1);

                    if (tabId.equals("Inf_1")) {
                        Infver_Pdetail activity1 = (Infver_Pdetail) getLocalActivityManager().getActivity(tabId);
                        activity1.COUNTRYCODE = COUNTRYCODE;
                        activity1.FACICODE = FACICODE;
                        activity1.DATAID = DATAID;
                    } else if (tabId.equals("Inf_2")) {
                        Infver_Denomin activity1 = (Infver_Denomin) getLocalActivityManager().getActivity(tabId);
                        activity1.COUNTRYCODE = COUNTRYCODE;
                        activity1.FACICODE = FACICODE;
                        activity1.DATAID = DATAID;
                    }else if (tabId.equals("Inf_3")) {
                        Infver_SupCare activity1 = (Infver_SupCare) getLocalActivityManager().getActivity(tabId);
                        activity1.COUNTRYCODE = COUNTRYCODE;
                        activity1.FACICODE = FACICODE;
                        activity1.DATAID = DATAID;
                    }else if (tabId.equals("Inf_4")) {
                        Infver_labInv activity1 = (Infver_labInv) getLocalActivityManager().getActivity(tabId);
                        activity1.COUNTRYCODE = COUNTRYCODE;
                        activity1.FACICODE = FACICODE;
                        activity1.DATAID = DATAID;
                    }else if (tabId.equals("Inf_5")) {
                        Infver_Outcome activity1 = (Infver_Outcome) getLocalActivityManager().getActivity(tabId);
                        activity1.COUNTRYCODE = COUNTRYCODE;
                        activity1.FACICODE = FACICODE;
                        activity1.DATAID = DATAID;
                    }


                    /*else if (tabId.equals("LD_rs2")) {
                        RecallSurvS2 activity1 = (RecallSurvS2) getLocalActivityManager().getActivity(tabId);
                        activity1.COUNTRYCODE = COUNTRYCODE;
                        activity1.FACICODE = FACICODE;
                        activity1.DATAID = DATAID;
                    } else if (tabId.equals("INFXN_rs3")) {
                        RecallSurvS3 activity1 = (RecallSurvS3) getLocalActivityManager().getActivity(tabId);
                        activity1.COUNTRYCODE = COUNTRYCODE;
                        activity1.FACICODE = FACICODE;
                        activity1.DATAID = DATAID;
                    } else if (tabId.equals("KMC_rs4")) {
                        RecallSurvS4 activity1 = (RecallSurvS4) getLocalActivityManager().getActivity(tabId);
                        activity1.COUNTRYCODE = COUNTRYCODE;
                        activity1.FACICODE = FACICODE;
                        activity1.DATAID = DATAID;
                    } else if (tabId.equals("LD_rs5")) {
                        RecallSurvS5 activity1 = (RecallSurvS5) getLocalActivityManager().getActivity(tabId);
                        activity1.COUNTRYCODE = COUNTRYCODE;
                        activity1.FACICODE = FACICODE;
                        activity1.DATAID = DATAID;
                    } else if (tabId.equals("LD_rs6")) {
                        MRS_FinalStatus activity1 = (MRS_FinalStatus) getLocalActivityManager().getActivity(tabId);
                        activity1.COUNTRYCODE = COUNTRYCODE;
                        activity1.FACICODE = FACICODE;
                        activity1.DATAID = DATAID;
                    }*/


                }

            }});

        Bundle IDbundleTab = new Bundle();

        //Observation Checklist
        //******************************************************************************************
        if(TYPE.equals("obj") & LOCATION.equals(ProjectSetting.LABOR_AND_DELIVERY_ID)){
            //Labour and Delivery Observe
            //--------------------------------------------------------------------------------------
            TabHost.TabSpec birthObj = tabHost1.newTabSpec("BirthObj");
            birthObj.setIndicator("L&D 1st & 2nd Stage");

            IDbundleTab.putString("dataid",DATAID);
            IDbundleTab.putString("tableid","1");
            Intent intbirthObj = new Intent(this, Observation_Time.class);
            intbirthObj.putExtras(IDbundleTab);

            birthObj.setContent(intbirthObj);
            tabHost1.addTab(birthObj);

            //Newborn Observe
            //--------------------------------------------------------------------------------------
            TabHost.TabSpec newbornObj = tabHost1.newTabSpec("Newborn");
            newbornObj.setIndicator("Newborn");

            IDbundleTab.putString("dataid",DATAID);
            IDbundleTab.putString("tableid","2");
            Intent intnewbornObj = new Intent(this, Observation_Time.class);
            intnewbornObj.putExtras(IDbundleTab);

            newbornObj.setContent(intbirthObj);
            tabHost1.addTab(newbornObj);

            //Birth Asphyxia and Resuscitation Observe
            //--------------------------------------------------------------------------------------
            TabHost.TabSpec birthAsph = tabHost1.newTabSpec("BirthAsph");
            birthAsph.setIndicator("Resus");
            IDbundleTab.putString("dataid",DATAID);
            IDbundleTab.putString("tableid","3");
            Intent intbirthAsph = new Intent(this, Observation_Time.class);
            intbirthAsph.putExtras(IDbundleTab);
            birthAsph.setContent(intbirthAsph);
            tabHost1.addTab(birthAsph);

            //PPH Observe
            //--------------------------------------------------------------------------------------
            TabHost.TabSpec pph = tabHost1.newTabSpec("PPH");
            pph.setIndicator("3rd Stage & PPH");
            IDbundleTab.putString("dataid",DATAID);
            IDbundleTab.putString("tableid","4");
            Intent intPPH = new Intent(this, Observation_Time.class);
            intPPH.putExtras(IDbundleTab);
            pph.setContent(intPPH);
            tabHost1.addTab(pph);

            //Final Outcome
            //--------------------------------------------------------------------------------------
            TabHost.TabSpec finalOut = tabHost1.newTabSpec("finalOut");
            finalOut.setIndicator("L & D Discharge & Outcome");
            IDbundleTab.putString("CountryCode",COUNTRYCODE);
            IDbundleTab.putString("FaciCode",FACICODE);
            IDbundleTab.putString("DataID",DATAID);

            Intent intfinalOut = new Intent(this, LD_Outcome.class);
            intfinalOut.putExtras(IDbundleTab);
            finalOut.setContent(intfinalOut);
            tabHost1.addTab(finalOut);
            setTabColor(tabHost1);
        }
        else if(TYPE.equals("obj") & LOCATION.equals(ProjectSetting.KMC_ID)){
            //KMC Initiation
            //--------------------------------------------------------------------------------------
            TabHost.TabSpec kmcIni = tabHost1.newTabSpec("KmcIni");
            kmcIni.setIndicator("KMC-Initiation");

            IDbundleTab.putString("dataid",DATAID);
            IDbundleTab.putString("tableid","");
            Intent intkmcIni = new Intent(this, KMC_Init.class);
            intkmcIni.putExtras(IDbundleTab);

            kmcIni.setContent(intkmcIni);
            tabHost1.addTab(kmcIni);

            //KMC Position
            //--------------------------------------------------------------------------------------
            TabHost.TabSpec kmcPos = tabHost1.newTabSpec("KmcPos");
            kmcPos.setIndicator("KMC-Position");

            IDbundleTab.putString("dataid",DATAID);
            IDbundleTab.putString("tableid","");
            IDbundleTab.putString("patname",PATNAME);
            IDbundleTab.putString("agesex",PATAGE);

            Intent intkmcPos = new Intent(this, KMC_Pos_list.class);
            intkmcPos.putExtras(IDbundleTab);

            kmcPos.setContent(intkmcPos);
            tabHost1.addTab(kmcPos);

            //KMC Feeding
            //--------------------------------------------------------------------------------------
            TabHost.TabSpec kmcFeed = tabHost1.newTabSpec("KmcFeed");
            kmcFeed.setIndicator("KMC-Feeding");

            IDbundleTab.putString("dataid",DATAID);
            IDbundleTab.putString("tableid","");
            IDbundleTab.putString("patname",PATNAME);
            IDbundleTab.putString("agesex",PATAGE);

            Intent intkmcFeed = new Intent(this, KMC_Feed_list.class);
            intkmcFeed.putExtras(IDbundleTab);

            kmcFeed.setContent(intkmcFeed);
            tabHost1.addTab(kmcFeed);

            //KMC Treatment
            //--------------------------------------------------------------------------------------
            TabHost.TabSpec kmcTreat = tabHost1.newTabSpec("KmcTreat");
            kmcTreat.setIndicator("Other Treatment");

            IDbundleTab.putString("dataid",DATAID);
            IDbundleTab.putString("tableid","");
            IDbundleTab.putString("patname",PATNAME);
            IDbundleTab.putString("agesex",PATAGE);

            Intent intkmcTreat = new Intent(this, KMC_Treat.class);
            intkmcTreat.putExtras(IDbundleTab);

            kmcTreat.setContent(intkmcTreat);
            tabHost1.addTab(kmcTreat);

            //KMC Outcome
            //--------------------------------------------------------------------------------------
            TabHost.TabSpec kmcOut = tabHost1.newTabSpec("KmcOut");
            kmcOut.setIndicator("KMC-Discharge & Outcome");

            IDbundleTab.putString("CountryCode",COUNTRYCODE);
            IDbundleTab.putString("FaciCode",FACICODE);
            IDbundleTab.putString("DataID",DATAID);
            Intent intkmcOut = new Intent(this, KMC_Outcome.class);
            intkmcOut.putExtras(IDbundleTab);

            kmcOut.setContent(intkmcOut);
            tabHost1.addTab(kmcOut);

            setTabColor(tabHost1);
        }

        //Recall Survey
        //******************************************************************************************
        else if(TYPE.equals("rs")){

            //--------------------------------------------------------------------------------------
            TabHost.TabSpec LD_rs1 = tabHost1.newTabSpec("LD_rs1");
            LD_rs1.setIndicator("Cover Sheet");

            IDbundleTab.putString("dataid",DATAID);
            IDbundleTab.putString("tableid","");
            Intent intLD_rs1 = new Intent(this, RecallSurvS1.class);
            intLD_rs1.putExtras(IDbundleTab);

            LD_rs1.setContent(intLD_rs1);
            tabHost1.addTab(LD_rs1);

            //L & D
            //--------------------------------------------------------------------------------------
            TabHost.TabSpec LD_rs2 = tabHost1.newTabSpec("LD_rs2");
            LD_rs2.setIndicator("L & D");

            IDbundleTab.putString("dataid",DATAID);
            IDbundleTab.putString("tableid","");
            Intent intLD_rs2 = new Intent(this, RecallSurvS2.class);
            intLD_rs2.putExtras(IDbundleTab);

            LD_rs2.setContent(intLD_rs2);
            tabHost1.addTab(LD_rs2);

            //Infection
            //--------------------------------------------------------------------------------------
            TabHost.TabSpec INFXN_rs3 = tabHost1.newTabSpec("INFXN_rs3");
            INFXN_rs3.setIndicator("Neonatal Infection");

            IDbundleTab.putString("dataid",DATAID);
            IDbundleTab.putString("tableid","");
            Intent intINFXN_rs3 = new Intent(this, RecallSurvS3.class);
            intINFXN_rs3.putExtras(IDbundleTab);

            INFXN_rs3.setContent(intINFXN_rs3);
            tabHost1.addTab(INFXN_rs3);

            //KMC
            //--------------------------------------------------------------------------------------
            TabHost.TabSpec KMC_rs4 = tabHost1.newTabSpec("KMC_rs4");
            KMC_rs4.setIndicator("KMC");

            IDbundleTab.putString("dataid",DATAID);
            IDbundleTab.putString("tableid","");
            Intent intKMC_rs4 = new Intent(this, RecallSurvS4.class);
            intKMC_rs4.putExtras(IDbundleTab);

            KMC_rs4.setContent(intKMC_rs4);
            tabHost1.addTab(KMC_rs4);

            //SES
            //--------------------------------------------------------------------------------------
            TabHost.TabSpec LD_rs5 = tabHost1.newTabSpec("LD_rs5");
            //LD_rs5.setIndicator("Socio-economic status");
            LD_rs5.setIndicator("SES");

            IDbundleTab.putString("dataid",DATAID);
            IDbundleTab.putString("tableid","");
            Intent intLD_rs5 = new Intent(this, RecallSurvS5.class);
            intLD_rs5.putExtras(IDbundleTab);

            LD_rs5.setContent(intLD_rs5);
            tabHost1.addTab(LD_rs5);

            setTabColor(tabHost1);

            //Final Status
            //--------------------------------------------------------------------------------------
            TabHost.TabSpec LD_rs6 = tabHost1.newTabSpec("LD_rs6");
            LD_rs6.setIndicator("Final Status");

            IDbundleTab.putString("dataid",DATAID);
            IDbundleTab.putString("tableid","");
            Intent intLD_rs6 = new Intent(this, MRS_FinalStatus.class);
            intLD_rs6.putExtras(IDbundleTab);

            LD_rs6.setContent(intLD_rs6);
            tabHost1.addTab(LD_rs6);

            setTabColor(tabHost1);

            //Follow up
            //--------------------------------------------------------------------------------------
            TabHost.TabSpec LD_follow = tabHost1.newTabSpec("LD_follow");
            LD_follow.setIndicator("Follow-up");

            IDbundleTab.putString("dataid",DATAID);
            IDbundleTab.putString("tableid","");
            Intent intLD_follow = new Intent(this, MRS_FollowUp.class);
            intLD_follow.putExtras(IDbundleTab);

            LD_follow.setContent(intLD_follow);
            tabHost1.addTab(LD_follow);

            setTabColor(tabHost1);
        }
        //Infection Verification
        //******************************************************************************************
        else if(TYPE.equals("inf")){

            //--------------------------------------------------------------------------------------
            TabHost.TabSpec inf_1 = tabHost1.newTabSpec("inf_1");
            inf_1.setIndicator("Patient Detail");

            IDbundleTab.putString("dataid",DATAID);
            IDbundleTab.putString("tableid","");
            Intent int_inf1 = new Intent(this, Infver_Pdetail.class);
            int_inf1.putExtras(IDbundleTab);

            inf_1.setContent(int_inf1);
            tabHost1.addTab(inf_1);


            TabHost.TabSpec inf_2 = tabHost1.newTabSpec("inf_2");
            inf_2.setIndicator("Denominators");

            IDbundleTab.putString("dataid",DATAID);
            IDbundleTab.putString("tableid","");
            Intent int_inf2 = new Intent(this, Infver_Denomin.class);
            int_inf2.putExtras(IDbundleTab);

            inf_2.setContent(int_inf2);
            tabHost1.addTab(inf_2);


            TabHost.TabSpec inf_3 = tabHost1.newTabSpec("inf_3");
            inf_3.setIndicator("Supportive Care");

            IDbundleTab.putString("dataid",DATAID);
            IDbundleTab.putString("tableid","");
            Intent int_inf3 = new Intent(this, Infver_SupCare.class);
            int_inf3.putExtras(IDbundleTab);

            inf_3.setContent(int_inf3);
            tabHost1.addTab(inf_3);


            TabHost.TabSpec inf_4 = tabHost1.newTabSpec("inf_4");
            inf_4.setIndicator("Lab Investigations");

            IDbundleTab.putString("dataid",DATAID);
            IDbundleTab.putString("tableid","");
            Intent int_inf4 = new Intent(this, Infver_labInv.class);
            int_inf4.putExtras(IDbundleTab);

            inf_4.setContent(int_inf4);
            tabHost1.addTab(inf_4);


            TabHost.TabSpec inf_5 = tabHost1.newTabSpec("inf_5");
            inf_5.setIndicator("Outcomes");

            IDbundleTab.putString("dataid",DATAID);
            IDbundleTab.putString("tableid","");
            Intent int_inf5 = new Intent(this, Infver_Outcome.class);
            int_inf5.putExtras(IDbundleTab);

            inf_5.setContent(int_inf5);
            tabHost1.addTab(inf_5);
            /*//L & D
            //--------------------------------------------------------------------------------------
            TabHost.TabSpec LD_rs2 = tabHost1.newTabSpec("LD_rs2");
            LD_rs2.setIndicator("L & D");

            IDbundleTab.putString("dataid",DATAID);
            IDbundleTab.putString("tableid","");
            Intent intLD_rs2 = new Intent(this, RecallSurvS2.class);
            intLD_rs2.putExtras(IDbundleTab);

            LD_rs2.setContent(intLD_rs2);
            tabHost1.addTab(LD_rs2);

            //Infection
            //--------------------------------------------------------------------------------------
            TabHost.TabSpec INFXN_rs3 = tabHost1.newTabSpec("INFXN_rs3");
            INFXN_rs3.setIndicator("Neonatal Infection");

            IDbundleTab.putString("dataid",DATAID);
            IDbundleTab.putString("tableid","");
            Intent intINFXN_rs3 = new Intent(this, RecallSurvS3.class);
            intINFXN_rs3.putExtras(IDbundleTab);

            INFXN_rs3.setContent(intINFXN_rs3);
            tabHost1.addTab(INFXN_rs3);

            //KMC
            //--------------------------------------------------------------------------------------
            TabHost.TabSpec KMC_rs4 = tabHost1.newTabSpec("KMC_rs4");
            KMC_rs4.setIndicator("KMC");

            IDbundleTab.putString("dataid",DATAID);
            IDbundleTab.putString("tableid","");
            Intent intKMC_rs4 = new Intent(this, RecallSurvS4.class);
            intKMC_rs4.putExtras(IDbundleTab);

            KMC_rs4.setContent(intKMC_rs4);
            tabHost1.addTab(KMC_rs4);

            //SES
            //--------------------------------------------------------------------------------------
            TabHost.TabSpec LD_rs5 = tabHost1.newTabSpec("LD_rs5");
            LD_rs5.setIndicator("Socio-economic status");

            IDbundleTab.putString("dataid",DATAID);
            IDbundleTab.putString("tableid","");
            Intent intLD_rs5 = new Intent(this, RecallSurvS5.class);
            intLD_rs5.putExtras(IDbundleTab);

            LD_rs5.setContent(intLD_rs5);
            tabHost1.addTab(LD_rs5);

            setTabColor(tabHost1);

            //Final Status
            //--------------------------------------------------------------------------------------
            TabHost.TabSpec LD_rs6 = tabHost1.newTabSpec("LD_rs6");
            LD_rs6.setIndicator("Final Status");

            IDbundleTab.putString("dataid",DATAID);
            IDbundleTab.putString("tableid","");
            Intent intLD_rs6 = new Intent(this, MRS_FinalStatus.class);
            intLD_rs6.putExtras(IDbundleTab);

            LD_rs6.setContent(intLD_rs6);
            tabHost1.addTab(LD_rs6);*/

            setTabColor(tabHost1);
        }
    }




    Dialog dialog;
    private void Patient_List_Form(String Location) {
        try {
            dialog = new Dialog(Observation.this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.ld_patient_list);
            dialog.setCanceledOnTouchOutside(true);
            dialog.setCancelable(true);

            Window window = dialog.getWindow();
            WindowManager.LayoutParams wlp = window.getAttributes();

            wlp.gravity = Gravity.TOP;
            wlp.flags &= ~WindowManager.LayoutParams.FLAG_DIM_BEHIND;
            window.setAttributes(wlp);

            Button cmdClose = (Button) dialog.findViewById(R.id.cmdClose);
            cmdClose.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    dialog.dismiss();
                }});


            try
            {
                Registration_DataModel d = new Registration_DataModel();
                String param = "";
                //String SQL = "Select * from Registration r Where r.CountryCode='"+ COUNTRYCODE +"' and r.FaciCode='"+ FACICODE +"' and r.Consent='1' and r.RegisType='"+ Location +"' order by r.EnDt desc limit 40";
                String SQL = "Select * from Registration r ";
                SQL += " left outer join DataCollector d on r.ObserverId=d.UserId";
                SQL += " Where r.CountryCode='"+ COUNTRYCODE +"' and r.FaciCode='"+ FACICODE +"' and r.Consent='1' and r.RegisType='"+ Location +"'";
                SQL += " and ifnull(CompleteStatus,'') in('2','') and ifnull(ObserverId,'')='"+ ENTRYUSER +"' order by r.EnDt desc";

                List<Registration_DataModel> data = d.SelectAll(this, SQL);
                dataList.clear();
                dataAdapter = null;

                ListView list = (ListView)dialog.findViewById(R.id.lstData);

                HashMap<String, String> map;
                Integer i = 0;
                for(Registration_DataModel item : data){
                    map = new HashMap<String, String>();

                    map.put("dataid", item.getDataID());
                    map.put("hospitalid", item.getHospID());
                    map.put("studyid", item.getStudyID());
                    map.put("patname", item.getRegisType().equals(ProjectSetting.LABOR_AND_DELIVERY_ID)?item.getMotName(): item.getNameNewBorn());
                    map.put("patage", "Age: "+ (item.getRegisType().equals(ProjectSetting.LABOR_AND_DELIVERY_ID)? item.getMotAge()+ " years" : item.getAgeNewborn()+" "+ (item.getAgeNewbornDMY().equals("1")?"days":(item.getAgeNewbornDMY().equals("2")?"month":"years"))));
                    map.put("patagedmy", item.getAgeNewbornDMY());
                    map.put("patsex", item.getRegisType().equals(ProjectSetting.LABOR_AND_DELIVERY_ID)?"": item.getSex().equals("1")?"Male":(item.getSex().equals("1")?"Female":"Ambiguous"));
                    map.put("patdob",item.getRegisType().equals(ProjectSetting.LABOR_AND_DELIVERY_ID)?item.getMotDOB():item.getDOBNewborn());
                    map.put("regdate", item.getRegDate());
                    map.put("regtime", item.getRegTime());
                    map.put("mainaddress", item.getCompleteAdd());
                    map.put("phone1", item.getMotContact());
                    map.put("phone2", item.getAltContact());
                    map.put("sl",String.valueOf(i));

                    i+=1;
                    dataList.add(map);
                }

                dataAdapter = new SimpleAdapter(Observation.this, dataList, R.layout.ld_patient_list,new String[] {"rowsec"},
                        new int[] {R.id.secRow});
                list.setAdapter(new Observation.DataListAdapter(this, dataAdapter));

            }
            catch(Exception  e)
            {
                Connection.MessageBox(Observation.this, e.getMessage());
                return;
            }

            dialog.show();
        } catch (Exception e) {
            Connection.MessageBox(Observation.this, e.getMessage());
            return;
        }
    }


    public class DataListAdapter extends BaseAdapter
    {
        private Context context;
        private SimpleAdapter dataAdap;

        public DataListAdapter(Context c, SimpleAdapter da){ context = c;  dataAdap = da; }
        public int getCount() {  return dataAdap.getCount();  }
        public Object getItem(int position) {  return position;  }
        public long getItemId(int position) {  return position;  }
        public View getView(final int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.ld_patient_list_row, null);
            }
            //LinearLayout   secListRow = (LinearLayout)convertView.findViewById(R.id.secListRow);
            final RelativeLayout secRow = (RelativeLayout) convertView.findViewById(R.id.secRow);
            final TextView studyId1 = (TextView) convertView.findViewById(R.id.txtStudyID);
            final TextView hospitalId1 = (TextView) convertView.findViewById(R.id.txtHospID);
            final TextView patientName1 = (TextView) convertView.findViewById(R.id.txtName);
            final TextView patientAge1 = (TextView) convertView.findViewById(R.id.txtAge);
            final TextView patientAddress1 = (TextView) convertView.findViewById(R.id.txtAddress);
            final TextView location1 = (TextView) convertView.findViewById(R.id.lblType);

            final HashMap<String, String> o = (HashMap<String, String>) dataAdap.getItem(position);
            studyId1.setText(o.get("studyid"));
            hospitalId1.setText(o.get("hospitalid"));
            patientName1.setText(o.get("patname"));
            patientAge1.setText(o.get("patage"));
            patientAddress1.setText(o.get("mainaddress"));
            if(Integer.valueOf(o.get("sl"))%2==0)
                secRow.setBackgroundColor(Color.parseColor("#F3F3F3"));
            else
                secRow.setBackgroundColor(Color.parseColor("#FFFFFF"));

            secRow.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    DATAID = o.get("dataid");
                    studyId.setText(o.get("studyid"));
                    hospitalId.setText(o.get("hospitalid"));
                    patientName.setText(o.get("patname"));
                    patientAge.setText(o.get("patage"));
                    patientAddress.setText(o.get("mainaddress"));

                    tabHost1.setCurrentTab(4);
                    tabHost1.setCurrentTab(0);
                    Observation_Time activity;
                    LD_Outcome activity1;
                    if(LOCATION.equals(ProjectSetting.LABOR_AND_DELIVERY_ID)) {
                        activity = (Observation_Time) getLocalActivityManager().getActivity("BirthObj");
                        activity.prepareVariableListData("1", DATAID,"w","");
                        activity.refreshAdapter();

                        tabHost1.setCurrentTab(4);
                        activity1 = (LD_Outcome) getLocalActivityManager().getActivity("finalOut");
                        activity1.COUNTRYCODE = COUNTRYCODE;
                        activity1.FACICODE = FACICODE;
                        activity1.DATAID = DATAID;
                        activity1.ClearForm();
                        activity1.DataSearch(COUNTRYCODE, FACICODE, DATAID);

                        tabHost1.setCurrentTab(0);

                    }else if(LOCATION.equals(ProjectSetting.KMC_ID)) {
                        tabHost1.setCurrentTab(0);
                        KMC_Init kmcactivity = (KMC_Init) getLocalActivityManager().getActivity("KmcIni");
                        kmcactivity.COUNTRYCODE = COUNTRYCODE;
                        kmcactivity.FACICODE = FACICODE;
                        kmcactivity.DATAID = DATAID;
                        kmcactivity.ClearForm();
                        kmcactivity.DataSearch(COUNTRYCODE, FACICODE, DATAID);

                        tabHost1.setCurrentTab(1);
                        KMC_Pos_list kmcactivity3 = (KMC_Pos_list) getLocalActivityManager().getActivity("KmcPos");
                        kmcactivity3.COUNTRYCODE = COUNTRYCODE;
                        kmcactivity3.FACICODE = FACICODE;
                        kmcactivity3.DATAID = DATAID;
                        //kmcactivity3.ClearForm();
                        kmcactivity3.DataSearch(COUNTRYCODE, FACICODE, DATAID,"");

                        tabHost1.setCurrentTab(2);
                        KMC_Feed_list kmcactivity4 = (KMC_Feed_list) getLocalActivityManager().getActivity("KmcFeed");
                        kmcactivity4.COUNTRYCODE = COUNTRYCODE;
                        kmcactivity4.FACICODE = FACICODE;
                        kmcactivity4.DATAID = DATAID;
                        //kmcactivity4.ClearForm();
                        kmcactivity4.DataSearch(COUNTRYCODE, FACICODE, DATAID,"s");

                        tabHost1.setCurrentTab(3);
                        KMC_Treat kmcactivity1 = (KMC_Treat) getLocalActivityManager().getActivity("KmcTreat");
                        kmcactivity1.COUNTRYCODE = COUNTRYCODE;
                        kmcactivity1.FACICODE = FACICODE;
                        kmcactivity1.DATAID = DATAID;
                        kmcactivity1.ClearForm();
                        kmcactivity1.DataSearch(COUNTRYCODE, FACICODE, DATAID);

                        tabHost1.setCurrentTab(4);
                        KMC_Outcome kmcactivity2 = (KMC_Outcome) getLocalActivityManager().getActivity("KmcOut");
                        kmcactivity2.COUNTRYCODE = COUNTRYCODE;
                        kmcactivity2.FACICODE = FACICODE;
                        kmcactivity2.DATAID = DATAID;
                        kmcactivity2.ClearForm();
                        kmcactivity2.DataSearch(COUNTRYCODE, FACICODE, DATAID);

                        tabHost1.setCurrentTab(0);
                    }



                    dialog.dismiss();
                }
            });

            return convertView;
        }
    }
}
