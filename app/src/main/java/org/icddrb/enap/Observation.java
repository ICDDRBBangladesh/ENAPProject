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
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

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

    TabActivity parent;
    TabHost tabhost;

    static Boolean OB  = false;
    static Boolean MRS = false;
    static Boolean DE  = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.observation);

        DEVICEID    = sp.getValue(this, "deviceid");
        ENTRYUSER   = sp.getValue(this, "userid");
        COUNTRYCODE = sp.getValue(this, "countrycode");
        FACICODE    = sp.getValue(this, "facicode");

        IDbundle = getIntent().getExtras();
        DATAID   = IDbundle.getString("dataid");
        TABLEID  = IDbundle.getString("tableid");

        OB = IDbundle.getString("ob").equals("1") ? true : false;
        //MRS = IDbundle.getString("ob").equals("1")?true:false;
        //DE = IDbundle.getString("ob").equals("1")?true:false;

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

        final ProgressDialog progDailog = ProgressDialog.show(Observation.this, "", "Please Wait . . .", true);
        progDailog.show();
        PopulateTab(LOCATION, DATAID,TABLEID);
        progDailog.dismiss();

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

    private void PopulateTab(String LocationID, String DataID, String TableID)
    {
        tabHost1 = getTabHost();
        tabHost1.clearAllTabs();
        tabHost1.setOnTabChangedListener(new TabHost.OnTabChangeListener(){
            @Override
            public void onTabChanged(final String tabId) {
                if(tabId.equals("finalOut")) {
                    setTabColor(tabHost1);
                }else {
                    setTabColor(tabHost1);
                    Observation_Time activity = (Observation_Time) getLocalActivityManager().getActivity(tabId);

                    if (tabId.equals("BirthObj")) {
                        activity.prepareVariableListData("1", DATAID);
                        activity.refreshAdapter();
                    } else if (tabId.equals("Newborn")) {
                        activity.prepareVariableListData("2", DATAID);
                        activity.refreshAdapter();
                    } else if (tabId.equals("BirthAsph")) {
                        activity.prepareVariableListData("3", DATAID);
                        activity.refreshAdapter();
                    } else if (tabId.equals("PPH")) {
                        activity.prepareVariableListData("4", DATAID);
                        activity.refreshAdapter();
                    }else if (tabId.equals("finalOut")){
                        LD_Outcome activity1 = (LD_Outcome) getLocalActivityManager().getActivity(tabId);
                        activity1.COUNTRYCODE = COUNTRYCODE;
                        activity1.FACICODE = FACICODE;
                        activity1.DATAID = DATAID;
                        activity1.ClearForm();
                        activity1.DataSearch(COUNTRYCODE, FACICODE, DATAID);
                    }
                }

            }});

        Bundle IDbundleTab = new Bundle();
        if(LOCATION.equals(ProjectSetting.LABOR_AND_DELIVERY_ID)){
            //Labour and Delivery Observe
            TabHost.TabSpec birthObj = tabHost1.newTabSpec("BirthObj");
            birthObj.setIndicator("Labour and Birth");

            IDbundleTab.putString("dataid",DATAID);
            IDbundleTab.putString("tableid","1");
            Intent intbirthObj = new Intent(this, Observation_Time.class);
            intbirthObj.putExtras(IDbundleTab);

            birthObj.setContent(intbirthObj);
            tabHost1.addTab(birthObj);

            //Newborn Observe
            TabHost.TabSpec newbornObj = tabHost1.newTabSpec("Newborn");
            newbornObj.setIndicator("Newborn");

            IDbundleTab.putString("dataid",DATAID);
            IDbundleTab.putString("tableid","2");
            Intent intnewbornObj = new Intent(this, Observation_Time.class);
            intnewbornObj.putExtras(IDbundleTab);

            newbornObj.setContent(intbirthObj);
            tabHost1.addTab(newbornObj);

            //Birth Asphyxia and Resuscitation Observe
            TabHost.TabSpec birthAsph = tabHost1.newTabSpec("BirthAsph");
            birthAsph.setIndicator("Birth Asphyxia and Resuscitation");
            IDbundleTab.putString("dataid",DATAID);
            IDbundleTab.putString("tableid","3");
            Intent intbirthAsph = new Intent(this, Observation_Time.class);
            intbirthAsph.putExtras(IDbundleTab);
            birthAsph.setContent(intbirthAsph);
            tabHost1.addTab(birthAsph);

            //PPH Observe
            TabHost.TabSpec pph = tabHost1.newTabSpec("PPH");
            pph.setIndicator("PPH");
            IDbundleTab.putString("dataid",DATAID);
            IDbundleTab.putString("tableid","4");
            Intent intPPH = new Intent(this, Observation_Time.class);
            intPPH.putExtras(IDbundleTab);
            pph.setContent(intPPH);
            tabHost1.addTab(pph);

            //Final Outcome
            TabHost.TabSpec finalOut = tabHost1.newTabSpec("finalOut");
            finalOut.setIndicator("Final Outcome");
            IDbundleTab.putString("CountryCode",COUNTRYCODE);
            IDbundleTab.putString("FaciCode",FACICODE);
            IDbundleTab.putString("DataID",DATAID);

            Intent intfinalOut = new Intent(this, LD_Outcome.class);
            intfinalOut.putExtras(IDbundleTab);
            finalOut.setContent(intfinalOut);
            tabHost1.addTab(finalOut);

        }
        else if(LOCATION.equals(ProjectSetting.KMC_ID)){
            TabHost.TabSpec birthObj = tabHost1.newTabSpec("KmcObj");
            birthObj.setIndicator("KMC");

            IDbundleTab.putString("dataid",DATAID);
            IDbundleTab.putString("tableid","6");
            Intent intbirthObj = new Intent(this, Observation_Time.class);
            intbirthObj.putExtras(IDbundleTab);

            birthObj.setContent(intbirthObj);
            tabHost1.addTab(birthObj);
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
                String SQL = "Select * from Registration r Where r.CountryCode='"+ COUNTRYCODE +"' and r.FaciCode='"+ FACICODE +"' and r.Consent='1' and r.RegisType='"+ Location +"' order by r.EnDt desc limit 40";

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
                        activity.prepareVariableListData("1", DATAID);
                        activity.refreshAdapter();

                        activity1 = (LD_Outcome) getLocalActivityManager().getActivity("finalOut");
                        activity1.COUNTRYCODE = COUNTRYCODE;
                        activity1.FACICODE = FACICODE;
                        activity1.DATAID = DATAID;
                        activity1.ClearForm();
                        activity1.DataSearch(COUNTRYCODE, FACICODE, DATAID);

                    }else if(LOCATION.equals(ProjectSetting.LABOR_AND_DELIVERY_ID)) {
                        activity = (Observation_Time) getLocalActivityManager().getActivity("KmcObj");
                        activity.prepareVariableListData("6", DATAID);
                        activity.refreshAdapter();
                    }



                    dialog.dismiss();
                }
            });

            return convertView;
        }
    }
}
