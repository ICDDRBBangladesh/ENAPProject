package org.icddrb.enap;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import Common.Connection;
import Common.Global;
import Common.ProjectSetting;
import Utility.MySharedPreferences;

/**
 * Created by thossain on 06/03/2017.
 */

public class PatientList extends AppCompatActivity {
    //Disabled Back/Home key
    //--------------------------------------------------------------------------------------------------
    @Override
    public boolean onKeyDown(int iKeyCode, KeyEvent event)
    {
        if(iKeyCode == KeyEvent.KEYCODE_BACK || iKeyCode == KeyEvent.KEYCODE_HOME)
        { return false; }
        else { return true;  }
    }
    String VariableID;
    private int hour;
    private int minute;
    private int mDay;
    private int mMonth;
    private int mYear;
    static final int DATE_DIALOG = 1;
    static final int TIME_DIALOG = 2;

    //private List<PatientList.Movie> movieList = new ArrayList<>();
    private List<Patient> patientList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PatientList.MoviesAdapter mAdapter;
    LinearLayout secDateSearch;
    EditText dtpFDate;
    EditText dtpTDate;

    static String DEVICEID  = "";
    static String ENTRYUSER = "";
    static String COUNTRYCODE = "";
    static String FACICODE = "";
    //static String LOCATIONID = "";
    MySharedPreferences sp;
    TextView lblCountPatient;
    LinearLayout secStatusSearch;
    Spinner spnStatusSearch;
    EditText txtSearch;
    Bundle IDbundle;
    //static String LOCATION = "";
    //static String ROLE     = "";

    LinearLayout secRegisType;
    LinearLayout secTitle;
    TextView lblTitle;
    Global g;
    Connection C;
    //-------------------------
    static String JOBTYPE     = "";
    static String JOBLOCATION = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_list);
        C = new Connection(this);
        g = Global.getInstance();
        IDbundle = getIntent().getExtras();

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        DEVICEID    = sp.getValue(this, "deviceid");
        ENTRYUSER   = sp.getValue(this, "userid");
        COUNTRYCODE = sp.getValue(this, "countrycode");
        FACICODE    = sp.getValue(this, "facicode");

        JOBTYPE     = sp.getValue(this, "jobtype");
        JOBLOCATION = IDbundle.getString("location");

        Button cmdSyncData = (Button) findViewById(R.id.cmdSyncData);
        cmdSyncData.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    //Connection.DataSync(COUNTRYCODE,FACICODE,DEVICEID,ENTRYUSER);
                    if (Connection.haveNetworkConnection(PatientList.this)) {
                    } else {
                        Connection.MessageBox(PatientList.this,"Internet connection is not available for Data Sync.");
                        return;
                    }
                    String Response = "";
                    //DataSync(MainActivity.this);
                    new PatientList.DataSyncTask().execute(COUNTRYCODE +"-"+ FACICODE +"-"+ DEVICEID +"-"+ ENTRYUSER);

                    //preparePatientList();
                }catch(Exception ex)
                {
                    Connection.MessageBox(PatientList.this, ex.getMessage().toString());
                    return;
                }
            }
        });

        Button cmdAssign = (Button) findViewById(R.id.cmdAssign);
        cmdAssign.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    Patient_List_Form_Assignment(ProjectSetting.LABOR_AND_DELIVERY_ID);
                }catch(Exception ex)
                {
                    Connection.MessageBox(PatientList.this, ex.getMessage().toString());
                    return;
                }
            }
        });

        secRegisType = (LinearLayout)findViewById(R.id.secRegisType);

        secTitle = (LinearLayout)findViewById(R.id.secTitle);
        lblTitle = (TextView)findViewById(R.id.lblTitle);

        lblCountPatient = (TextView)findViewById(R.id.lblCountPatient);
        txtSearch = (EditText)findViewById(R.id.txtSearch);
        secDateSearch = (LinearLayout)findViewById(R.id.secDateSearch) ;
        secStatusSearch=(LinearLayout)findViewById(R.id.secStatusSearch) ;
        spnStatusSearch=(Spinner)findViewById(R.id.spnStatusSearch) ;



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new MoviesAdapter(this, patientList);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new PatientList.DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        /*
        recyclerView.addOnItemTouchListener(new PatientList.RecyclerTouchListener(getApplicationContext(), recyclerView, new PatientList.RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Patient patient = patientList.get(position);
                Toast.makeText(getApplicationContext(), patient.getpatName() + " is selected!", Toast.LENGTH_SHORT).show();

                Bundle IDbundle = new Bundle();
                IDbundle.putString("locationid", patient.getLocation());
                IDbundle.putString("dataid", patient.getDataID());
                Intent intent = new Intent(getApplicationContext(), Registration.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtras(IDbundle);
                getApplicationContext().startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));*/

        ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
        cmdBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder adb = new AlertDialog.Builder(PatientList.this);
                adb.setTitle("Close");
                adb.setMessage("Do you want to close this form[Yes/No]?");
                adb.setNegativeButton("No", null);
                adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }});
                adb.show();
            }});

        Button cmdLD = (Button) findViewById(R.id.cmdLD);
        cmdLD.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Bundle IDbundle = new Bundle();
                IDbundle.putString("locationid", ProjectSetting.LABOR_AND_DELIVERY_ID);
                IDbundle.putString("dataid", "");
                IDbundle.putString("sid", "");
                /*Intent intent = new Intent(getApplicationContext(), Registration.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtras(IDbundle);
                getApplicationContext().startActivity(intent);*/

                Intent intent = new Intent(getApplicationContext(), Registration.class);
                intent.putExtras(IDbundle);
                startActivityForResult(intent, 1);

            }
        });

        Button cmdKMC = (Button) findViewById(R.id.cmdKMC);
        cmdKMC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Bundle IDbundle = new Bundle();
                IDbundle.putString("locationid", ProjectSetting.KMC_ID);
                IDbundle.putString("dataid", "");
                IDbundle.putString("sid", "");
                /*Intent intent = new Intent(getApplicationContext(), Registration.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtras(IDbundle);
                getApplicationContext().startActivity(intent);*/

                Intent intent = new Intent(getApplicationContext(), Registration.class);
                intent.putExtras(IDbundle);
                startActivityForResult(intent, 1);
            }
        });

        Button cmdSepsis = (Button) findViewById(R.id.cmdSepsis);
        cmdSepsis.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Bundle IDbundle = new Bundle();
                IDbundle.putString("locationid", ProjectSetting.SEPSIS_ID);
                IDbundle.putString("dataid", "");
                IDbundle.putString("sid", "");
                /*Intent intent = new Intent(getApplicationContext(), Registration.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtras(IDbundle);
                getApplicationContext().startActivity(intent);*/

                Intent intent = new Intent(getApplicationContext(), Registration.class);
                intent.putExtras(IDbundle);
                startActivityForResult(intent, 1);
            }
        });


        Button btnSearch = (Button) findViewById(R.id.btnSearch);
        final ImageButton dateSearch = (ImageButton) findViewById(R.id.dateSearch);
        secDateSearch = (LinearLayout) findViewById(R.id.secDateSearch);
        dateSearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (secDateSearch.isShown()) {
                    secDateSearch.setVisibility(View.GONE);
                    dateSearch.setImageResource(R.drawable.plus);

                    secStatusSearch.setVisibility(View.GONE);
                    spnStatusSearch.setSelection(0);
                    //DataSearch(LOCATIONTYPE);
                } else {
                    secDateSearch.setVisibility(View.VISIBLE);
                    dateSearch.setImageResource(R.drawable.minus);
                    dtpFDate.setText(Global.DateNowDMY());
                    dtpTDate.setText(Global.DateNowDMY());

                    secStatusSearch.setVisibility(View.VISIBLE);
                    //DataSearch(LOCATIONTYPE);
                }
            }
        });

        dtpFDate = (EditText) findViewById(R.id.dtpFDate);
        dtpTDate = (EditText) findViewById(R.id.dtpTDate);


        dtpFDate.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_RIGHT  = 2;
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    if(event.getRawX() >= (dtpFDate.getRight() - dtpFDate.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        VariableID = "dtpFDate"; showDialog(DATE_DIALOG);
                        return true;
                    }
                }
                return false;
            }
        });


        dtpTDate.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_RIGHT  = 2;
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    if(event.getRawX() >= (dtpTDate.getRight() - dtpTDate.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        VariableID = "dtpTDate"; showDialog(DATE_DIALOG);
                        return true;
                    }
                }
                return false;
            }
        });


        btnSearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                preparePatientList();
            }
        });
        secDateSearch.setVisibility(View.GONE);

        //DataSearch(LOCATIONTYPE);

        List<String> listStatusSearch = new ArrayList<String>();
        listStatusSearch.add("");
        listStatusSearch.add("1-All Patient");
        listStatusSearch.add("2-Completed");
        listStatusSearch.add("3-Incomplete");


        //Tracker and Super user
        //******************************************************************************************
        if(JOBTYPE.equals(ProjectSetting.JT_REGISTRATION) | JOBTYPE.equals(ProjectSetting.SUPERUSER_ID)){
            secRegisType.setVisibility(View.VISIBLE);
            secTitle.setVisibility(View.GONE);
            cmdSyncData.setVisibility(View.GONE);
            cmdAssign.setVisibility(View.GONE);

            listStatusSearch.add("4-Labour and Delivery Patient");
            listStatusSearch.add("5-KMC Patient");
            listStatusSearch.add("6-Infection Patient");
            listStatusSearch.add("9-Consent Not Given");
        }

        //Observation
        //******************************************************************************************
        else if(JOBTYPE.equals(ProjectSetting.JT_OBSERVATION)){
            if(JOBLOCATION.equals(ProjectSetting.LABOR_AND_DELIVERY_ID)){
                secRegisType.setVisibility(View.GONE);
                secTitle.setVisibility(View.VISIBLE);

                listStatusSearch.add("4-Labour and Delivery Patient");
                lblTitle.setText(ProjectSetting.LABOR_AND_DELIVERY_NAME);
            }else if(JOBLOCATION.equals(ProjectSetting.KMC_ID)){
                secRegisType.setVisibility(View.GONE);
                secTitle.setVisibility(View.VISIBLE);
                lblTitle.setText(ProjectSetting.KMC_NAME);

                listStatusSearch.add("5-KMC Patient");
            }else if(JOBLOCATION.equals(ProjectSetting.SEPSIS_ID)){
                secRegisType.setVisibility(View.GONE);
                secTitle.setVisibility(View.VISIBLE);
                lblTitle.setText(ProjectSetting.SEPSIS_NAME);

                listStatusSearch.add("6-Infection Patient");
            }
        }

        //Recall Survey
        //******************************************************************************************
        else if((JOBTYPE.equals(ProjectSetting.JT_EXIT_INTERVIEW)) & JOBLOCATION.equals(ProjectSetting.EXIT_INTERVIEW_ID)){
            secRegisType.setVisibility(View.GONE);
            secTitle.setVisibility(View.VISIBLE);
            cmdSyncData.setVisibility(View.GONE);
            cmdAssign.setVisibility(View.GONE);

            listStatusSearch.add("4-Labour and Delivery Patient");
            listStatusSearch.add("5-KMC Patient");
            listStatusSearch.add("6-Infection Patient");

            lblTitle.setText(ProjectSetting.RECALLSURVEY_NAME);
        }

        //Data Extraction
        //******************************************************************************************
        else if((JOBTYPE.equals(ProjectSetting.JT_DATA_EXTRACTION)) & JOBLOCATION.equals(ProjectSetting.DATA_EXTRACTION_ID)){
            secRegisType.setVisibility(View.GONE);
            secTitle.setVisibility(View.VISIBLE);
            cmdSyncData.setVisibility(View.GONE);
            cmdAssign.setVisibility(View.GONE);

            listStatusSearch.add("4-Labour and Delivery Patient");
            listStatusSearch.add("5-KMC Patient");
            //listStatusSearch.add("6-Infection Patient");

            lblTitle.setText(ProjectSetting.DATAEXTRACTION_NAME);
        }
        else if((JOBTYPE.equals(ProjectSetting.JT_DATA_EXTRACTION)) & JOBLOCATION.equals(ProjectSetting.SEPSIS_ID)){
            secRegisType.setVisibility(View.GONE);
            secTitle.setVisibility(View.VISIBLE);
            cmdSyncData.setVisibility(View.GONE);
            cmdAssign.setVisibility(View.GONE);

            listStatusSearch.add("6-Infection Patient");

            lblTitle.setText(ProjectSetting.SEPSIS_NAME);
        }
        ArrayAdapter<String> adptrMotReligion= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listStatusSearch);
        spnStatusSearch.setAdapter(adptrMotReligion);

        secDateSearch.setVisibility(View.GONE);
        secStatusSearch.setVisibility(View.GONE);

        preparePatientList();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_CANCELED) {
            //Write your code if there's no result
        } else {
            //preparePatientList();
        }
        preparePatientList();
    }

    private void preparePatientList() {
        Registration_DataModel d = new Registration_DataModel();
        //String param = "";
        String SQL = "Select  r.CountryCode,r.FaciCode,r.RegisType,r.DataID,r.RegDate,r.RegTime,r.HospID,r.Consent,r.StudyID,r.MotRegis,r.MotStudyID,r.MotStudyIDReType,r.MotHospID,r.MotName,r.MotDOB,r.MotDOBDK,r.MotAge,r.MotEthnicity,r.MotReligion,r.Address1,r.Address2,r.Address3,r.Address4,r.AddressDetail,r.MotContact,r.AltContact,r.NameNewBorn,r.DOBNewborn,r.AgeNewborn,r.AgeNewbornDMY,r.Sex,r.FatherName,r.CompleteAdd,";
        SQL += " (case when r.StatusObj='1' then '1' else '2' end)Observe,";
        SQL += " (case when r.StatusRS ='1' then '1' else '2' end)RS,";
        SQL += " (case when r.StatusDE ='1' then '1' else '2' end)DE,";
        SQL += " (case when r.StatusACS ='1' then '1' else '2' end)ACSStatus,";
        SQL += " (case when r.StatusINFXN ='1' then '1' else '2' end)INFXNStatus,";
        SQL += " (case when h.bb4expect is null then '2' else h.bb4expect end)ACS";
        SQL += " from Registration r";
        SQL += " left outer join ObsHisCurPreg h on r.CountryCode=h.CountryCode and r.FaciCode=h.FaciCode and r.DataID=h.DataID";
        //SQL += " left outer join (Select CountryCode,FaciCode,DataID,sum(case when TableId='1' then 1 else 0 end)LD from Observation group by CountryCode,FaciCode,DataID)o on r.CountryCode=o.CountryCode and r.FaciCode=o.FaciCode and r.DataID=o.DataID";
        //SQL += " left outer join RecallSurvS1 rs1 on r.CountryCode=rs1.CountryCode and r.FaciCode=rs1.FaciCode and r.DataID=rs1.DataID";
        SQL += " Where r.CountryCode='"+ COUNTRYCODE +"' and r.FaciCode='"+ FACICODE +"'";//and r.Consent='1'";

        //Criteria for Observer
        if(JOBTYPE.equals(ProjectSetting.JT_OBSERVATION)){
            SQL += " and r.ObserverId='"+ ENTRYUSER +"'";
        }
        /*if(secStatusSearch.isShown() & spnStatusSearch.getSelectedItemPosition()>0) {
            String[] p = spnStatusSearch.getSelectedItem().toString().split("-");
            param = p[0];

            if (param.equals("4")) {
                SQL += " and r.RegisType = '2'";
            } else if (param.equals("5")) {
                SQL += " and r.RegisType = '3'";
            } else if (param.equals("6")) {
                SQL += " and r.RegisType = '4'";
            }
        }*/


        String SearchType = spnStatusSearch.getSelectedItemPosition()==0?"":spnStatusSearch.getSelectedItem().toString().split("-")[0];
        if(JOBTYPE.equals(ProjectSetting.JT_REGISTRATION)) {
            //All patient
            if (SearchType.equals("1")) {
                SQL += " and r.RegisType in('2','3','4') and r.Consent in('1','5')";
            }
            //Completed
            else if (SearchType.equals("2")) {
                SQL += " and r.RegisType in('2','3','4') and r.Consent in('1','5') and (ifnull(StatusObj,'')='1' & ifnull(StatusRS,'')='1' & ifnull(StatusDE,'')='1')";
            }
            //Incomplete
            else if (SearchType.equals("3")) {
                SQL += " and r.RegisType in('2','3','4') and r.Consent in('1','5') and (ifnull(StatusObj,'')<>'1' or ifnull(StatusRS,'')<>'1' or ifnull(StatusDE,'')<>'1')";
            } else if (SearchType.equals("4")) {
                SQL += " and r.RegisType = '2' and r.Consent in('1','5')";
            } else if (SearchType.equals("5")) {
                SQL += " and r.RegisType = '3' and r.Consent in('1','5')";
            } else if (SearchType.equals("6")) {
                SQL += " and r.RegisType = '4' and r.Consent in('1','5')";
            } else if (SearchType.equals("9")) {
                SQL += " and r.RegisType in('2','3','4') and r.Consent in('2','3','4')";
            } else {
                SQL += " and r.RegisType in('2','3','4') and r.Consent in('1','5') and (ifnull(StatusObj,'')<>'1' or ifnull(StatusRS,'')<>'1' or ifnull(StatusDE,'')<>'1')";
            }
        }else if(JOBTYPE.equals(ProjectSetting.JT_OBSERVATION) & JOBLOCATION.equals(ProjectSetting.LABOR_AND_DELIVERY_ID)){
            SQL += " and r.RegisType = '2' and r.Consent in('1','5')";

            //All Patient
            if (SearchType.equals("1")) {

            }
            //Completed
            else if (SearchType.equals("2")) {
                SQL += " and (ifnull(StatusObj,'')='1' & ifnull(StatusRS,'')='1' & ifnull(StatusDE,'')='1')";
            }
            //Incomplete
            else if (SearchType.equals("3")) {
                SQL += " and (ifnull(StatusObj,'')<>'1' or ifnull(StatusRS,'')<>'1' or ifnull(StatusDE,'')<>'1')";
            }

            //L & D Paient Only
            else if (SearchType.equals("4")) {
                SQL += " and (ifnull(StatusObj,'')<>'1' or ifnull(StatusRS,'')<>'1' or ifnull(StatusDE,'')<>'1')";
            }
        }else if(JOBTYPE.equals(ProjectSetting.JT_OBSERVATION) & JOBLOCATION.equals(ProjectSetting.KMC_ID)){
            SQL += " and r.RegisType = '3' and r.Consent in('1','5')";

            //All Patient
            if (SearchType.equals("1")) {

            }
            //Completed
            else if (SearchType.equals("2")) {
                SQL += " and (ifnull(StatusObj,'')='1' & ifnull(StatusRS,'')='1' & ifnull(StatusDE,'')='1')";
            }
            //Incomplete
            else if (SearchType.equals("3")) {
                SQL += " and (ifnull(StatusObj,'')<>'1' or ifnull(StatusRS,'')<>'1' or ifnull(StatusDE,'')<>'1')";
            }

            //KMC Paient Only
            else if (SearchType.equals("5")) {
                SQL += " and (ifnull(StatusObj,'')<>'1' or ifnull(StatusRS,'')<>'1' or ifnull(StatusDE,'')<>'1')";
            }
        }else if(JOBTYPE.equals(ProjectSetting.JT_OBSERVATION) & JOBLOCATION.equals(ProjectSetting.SEPSIS_ID)){
            SQL += " and r.RegisType = '4' and r.Consent in('1','5')";

            //All Patient
            if (SearchType.equals("1")) {

            }
            //Completed
            else if (SearchType.equals("2")) {
                SQL += " and (ifnull(StatusObj,'')='1' & ifnull(StatusRS,'')='1' & ifnull(StatusDE,'')='1')";
            }
            //Incomplete
            else if (SearchType.equals("3")) {
                SQL += " and (ifnull(StatusObj,'')<>'1' or ifnull(StatusRS,'')<>'1' or ifnull(StatusDE,'')<>'1')";
            }

            //Infection Paient Only
            else if (SearchType.equals("6")) {
                SQL += " and (ifnull(StatusObj,'')<>'1' or ifnull(StatusRS,'')<>'1' or ifnull(StatusDE,'')<>'1')";
            }
        }else if(JOBTYPE.equals(ProjectSetting.JT_EXIT_INTERVIEW)){
            if (SearchType.equals("4")) {
                SQL += " and r.RegisType = '2' and r.Consent in('1','5')";
            } else if (SearchType.equals("5")) {
                SQL += " and r.RegisType = '3' and r.Consent in('1','5')";
            } else if (SearchType.equals("6")) {
                SQL += " and r.RegisType = '4' and r.Consent in('1','5')";
            }
        }else if(JOBTYPE.equals(ProjectSetting.JT_DATA_EXTRACTION) & JOBLOCATION.equals(ProjectSetting.DATA_EXTRACTION_ID)){
            if (SearchType.equals("4")) {
                SQL += " and r.RegisType = '2' and r.Consent in('1','5')";
            } else if (SearchType.equals("5")) {
                SQL += " and r.RegisType = '3' and r.Consent in('1','5')";
            } else if (SearchType.equals("6")) {
                SQL += " and r.RegisType = '4' and r.Consent in('1','5')";
            }else{
                SQL += " and r.RegisType in('2','3') and r.Consent in('1','5')";
            }
        }else if(JOBTYPE.equals(ProjectSetting.JT_DATA_EXTRACTION) & JOBLOCATION.equals(ProjectSetting.SEPSIS_ID)){
            SQL += " and r.RegisType = '4' and r.Consent in('1','5')";
        }else if(JOBTYPE.equals(ProjectSetting.SUPERUSER_ID)){
            //All patient
            if (SearchType.equals("1")) {
                SQL += " and r.RegisType in('2','3','4') and r.Consent in('1','5')";
            }
            //Completed
            else if (SearchType.equals("2")) {
                SQL += " and r.RegisType in('2','3','4') and r.Consent in('1','5') and (ifnull(StatusObj,'')='1' & ifnull(StatusRS,'')='1' & ifnull(StatusDE,'')='1')";
            }
            //Incomplete
            else if (SearchType.equals("3")) {
                SQL += " and r.RegisType in('2','3','4') and r.Consent in('1','5') and (ifnull(StatusObj,'')<>'1' or ifnull(StatusRS,'')<>'1' or ifnull(StatusDE,'')<>'1')";
            } else if (SearchType.equals("4")) {
                SQL += " and r.RegisType = '2' and r.Consent in('1','5')";
            } else if (SearchType.equals("5")) {
                SQL += " and r.RegisType = '3' and r.Consent in('1','5')";
            } else if (SearchType.equals("6")) {
                SQL += " and r.RegisType = '4' and r.Consent in('1','5')";
            } else if (SearchType.equals("9")) {
                SQL += " and r.RegisType in('2','3','4') and r.Consent in('2','3','4')";
            } else {
                SQL += " and r.RegisType in('2','3','4') and r.Consent in('1','5') and (ifnull(StatusObj,'')<>'1' or ifnull(StatusRS,'')<>'1' or ifnull(StatusDE,'')<>'1')";
            }
        }


        if(txtSearch.getText().toString().length()>0) {
            SQL += " and (";
            SQL += " r.StudyID like('%"+ txtSearch.getText().toString() +"%')";
            SQL += " or r.MotName like('%"+ txtSearch.getText().toString() +"%')";
            SQL += " or r.NameNewBorn like('%"+ txtSearch.getText().toString() +"%')";
            SQL += " or r.MotContact like('%"+ txtSearch.getText().toString() +"%')";
            SQL += " or r.AltContact like('%"+ txtSearch.getText().toString() +"%')";
            SQL += " or r.HospID like('%"+ txtSearch.getText().toString() +"%')";
            SQL += " )";
        }

        if(secDateSearch.isShown()){
            SQL += " and (date(r.RegDate) between '"+ Global.DateConvertYMD(dtpFDate.getText().toString()) +"' and '"+ Global.DateConvertYMD(dtpTDate.getText().toString()) +"')";
        }

        SQL += " Order by r.EnDt desc,r.RegisType asc";


        List<Registration_DataModel> data = d.SelectPatientList(this, SQL);

        patientList.clear();
        int count = 0;
        for(Registration_DataModel item : data){
            //Movie movie = new Movie(String.valueOf(count)+": "+ item.getpatName(), item.getPatAge(), item.getDataID());
            //movieList.add(movie);

            Patient p = new Patient();
            p.setLocation(item.getRegisType());
            p.setDataID(item.getDataID());
            p.setHospitalID(item.getHospID());
            p.setStudyID(item.getStudyID());
            p.setpatName(item.getRegisType().equals(ProjectSetting.LABOR_AND_DELIVERY_ID)?item.getMotName():item.getNameNewBorn());

            p.setPatAge("Age: "+ (item.getRegisType().equals(ProjectSetting.LABOR_AND_DELIVERY_ID)? item.getMotAge()+ " years" : item.getAgeNewborn()+" "+ (item.getAgeNewbornDMY().equals("1")?"days":(item.getAgeNewbornDMY().equals("2")?"month":"years"))));

            p.setPatAgeDMY(item.getAgeNewbornDMY());
            p.setPatSex(item.getRegisType().equals(ProjectSetting.LABOR_AND_DELIVERY_ID)?"": item.getSex().equals("1")?"Male":(item.getSex().equals("2")?"Female":"Ambiguous"));
            p.setPatDOB(item.getRegisType().equals(ProjectSetting.LABOR_AND_DELIVERY_ID)?item.getMotDOB():item.getDOBNewborn());
            p.setRegDate(item.getRegDate());
            p.setRegTime(item.getRegTime());
            p.setMainAddress(item.getCompleteAdd());
            //p.setMainAddress(item.getAddress1());
            p.setPhone1(item.getMotContact());
            p.setPhone2(item.getAltContact());
            p.setSerial(String.valueOf(count));

            p.setObserve(item.getObserve());
            p.setRS(item.getRS());
            p.setDE(item.getDE());
            p.setACSStatus(item.getACSStatus());
            p.setINFXNStatus(item.getINFXNStatus());
            //----------------------
            p.setACS(item.getACS());

            count +=1;

            patientList.add(p);
        }

        lblCountPatient.setText("(Total: "+ String.valueOf(count) +")");
        mAdapter.notifyDataSetChanged();

        //recyclerView.setAdapter(mAdapter);
        //recyclerView.getAdapter().notifyItemChanged(1);
        //recyclerView.invalidate();
    }

    public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {
        private Context context;
        private List<Patient> patientList;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            //public TextView title, year, genre;
            public TextView studyId,hospitalId,patientName,patientAge,patientAddress,location,regDate;
            public Button cmdObj,cmdRS,cmdDE,cmdVER,cmdACS;
            public RelativeLayout secRow;
            public ImageView imgPatient;

            public MyViewHolder(View view) {
                super(view);
                secRow = (RelativeLayout) view.findViewById(R.id.secRow);
                studyId = (TextView) view.findViewById(R.id.txtStudyID);
                hospitalId = (TextView) view.findViewById(R.id.txtHospID);
                patientName = (TextView) view.findViewById(R.id.txtName);
                patientAge = (TextView) view.findViewById(R.id.txtAge);
                patientAddress = (TextView) view.findViewById(R.id.txtAddress);
                regDate = (TextView) view.findViewById(R.id.txtRegDate);

                location = (TextView) view.findViewById(R.id.lblType);
                imgPatient = (ImageView) view.findViewById(R.id.imgPatient);
                cmdObj = (Button)view.findViewById(R.id.cmdObj);
                cmdRS = (Button)view.findViewById(R.id.cmdRS);
                cmdDE = (Button)view.findViewById(R.id.cmdDE);
                cmdVER = (Button)view.findViewById(R.id.cmdVER);
                cmdACS = (Button)view.findViewById(R.id.cmdACS);
            }
        }


        public MoviesAdapter(Context context, List<Patient> patientlist) {
            this.context = context;
            this.patientList = patientlist;
        }

        @Override
        public PatientList.MoviesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.patient_list_row1, parent, false);

            return new PatientList.MoviesAdapter.MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(PatientList.MoviesAdapter.MyViewHolder holder, int position) {
            final Patient patient = patientList.get(position);
            holder.studyId.setText(patient.getStudyID());
            holder.hospitalId.setText(patient.getHospitalID());

            holder.patientName.setText(patient.getpatName());
            holder.patientAge.setText(patient.getPatAge() + (patient.getLocation().equals(ProjectSetting.LABOR_AND_DELIVERY_ID)?"": "   "+ patient.getPatSex()));
            holder.patientAddress.setText(patient.getMainAddress());
            holder.regDate.setText("Reg. Date: "+ Global.DateConvertDMY(patient.getRegDate())+"  Time: "+patient.getRegTime());
            if(patient.getLocation().equals(ProjectSetting.LABOR_AND_DELIVERY_ID)) {
                holder.location.setText(ProjectSetting.LABOR_AND_DELIVERY_SHORT_NAME);
                holder.cmdObj.setVisibility(View.VISIBLE);
                holder.cmdDE.setVisibility(View.VISIBLE);
                holder.cmdVER.setVisibility(View.GONE);
                //holder.imgPatient.setBackgroundResource(R.drawable.ic_action_person);
            }
            else if(patient.getLocation().equals(ProjectSetting.KMC_ID)) {
                holder.location.setText(ProjectSetting.KMC_SHORT_NAME);
                holder.cmdObj.setVisibility(View.VISIBLE);
                holder.cmdDE.setVisibility(View.VISIBLE);
                holder.cmdVER.setVisibility(View.GONE);
                //holder.imgPatient.setBackgroundResource(R.drawable.ic_action_group);
            }
            else if(patient.getLocation().equals(ProjectSetting.SEPSIS_ID)) {
                holder.location.setText(ProjectSetting.SEPSIS_SHORT_NAME);
                holder.cmdObj.setVisibility(View.GONE);
                holder.cmdDE.setVisibility(View.GONE);
                holder.cmdVER.setVisibility(View.VISIBLE);
                //holder.imgPatient.setBackgroundResource(R.drawable.ic_action_group);
            }

            if(Integer.valueOf(patient.getSerial())%2==0){
                holder.secRow.setBackgroundColor(Color.parseColor("#FFFFFF"));
            }else
            {
                holder.secRow.setBackgroundColor(Color.parseColor("#F3F3F3"));
            }


            holder.cmdObj.setEnabled(false);
            holder.cmdRS.setEnabled(false);
            holder.cmdDE.setEnabled(false);
            holder.cmdVER.setEnabled(false);
            holder.cmdACS.setEnabled(false);

            holder.cmdACS.setVisibility(View.GONE);

            if(patient.getACS().equals("1")){
                holder.cmdACS.setVisibility(View.VISIBLE);
            }

            //Observation
            if(JOBTYPE.equals(ProjectSetting.JT_OBSERVATION)){
                holder.cmdObj.setEnabled(true);
                holder.cmdRS.setEnabled(false);
                holder.cmdDE.setEnabled(false);
            }
            //Recall Survey
            else if(JOBTYPE.equals(ProjectSetting.JT_EXIT_INTERVIEW)){
                holder.cmdObj.setEnabled(false);
                //holder.cmdRS.setEnabled(true);
                holder.cmdDE.setEnabled(false);
                if(patient.getLocation().equals(ProjectSetting.SEPSIS_ID)) {
                    holder.cmdRS.setEnabled(true);
                }
                else if(patient.getObserve().equals("1")){
                    holder.cmdObj.setBackgroundResource(R.drawable.button_style_green);
                    holder.cmdRS.setEnabled(true);
                }else{
                    holder.cmdObj.setBackgroundResource(R.drawable.button_style_red);
                }
            }
            //Data Extraction
            else if(JOBTYPE.equals(ProjectSetting.JT_DATA_EXTRACTION)){
                holder.cmdObj.setEnabled(false);
                holder.cmdRS.setEnabled(false);
                holder.cmdDE.setEnabled(true);
                holder.cmdACS.setEnabled(true);
                holder.cmdVER.setEnabled(true);
            }

            //Super user : 22 Jul 2017
            else if(JOBTYPE.equals(ProjectSetting.SUPERUSER_ID)){
                holder.cmdObj.setEnabled(true);
                holder.cmdRS.setEnabled(true);
                holder.cmdDE.setEnabled(true);
                holder.cmdACS.setEnabled(true);
                holder.cmdVER.setEnabled(true);
            }



            if(patient.getObserve().equals("1")){
                holder.cmdObj.setBackgroundResource(R.drawable.button_style_green);
            }else{
                holder.cmdObj.setBackgroundResource(R.drawable.button_style_red);
            }

            if(patient.getRS().equals("1")){
                holder.cmdRS.setBackgroundResource(R.drawable.button_style_green);
            }else{
                holder.cmdRS.setBackgroundResource(R.drawable.button_style_red);
            }
            if(patient.getDE().equals("1")){
                holder.cmdDE.setBackgroundResource(R.drawable.button_style_green);
            }else{
                holder.cmdDE.setBackgroundResource(R.drawable.button_style_red);
            }
            if(patient.getACSStatus().equals("1")){
                holder.cmdACS.setBackgroundResource(R.drawable.button_style_green);
            }else{
                holder.cmdACS.setBackgroundResource(R.drawable.button_style_red);
            }
            if(patient.getINFXNStatus().equals("1")){
                holder.cmdVER.setBackgroundResource(R.drawable.button_style_green);
            }else{
                holder.cmdVER.setBackgroundResource(R.drawable.button_style_red);
            }

            holder.cmdObj.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Bundle IDbundle = new Bundle();
                    String TABLEID = "";
                    if(patient.getLocation().equals(ProjectSetting.LABOR_AND_DELIVERY_ID)){
                        TABLEID = "1";
                    }else if(patient.getLocation().equals(ProjectSetting.KMC_ID)){
                        TABLEID = "6";
                    }

                    IDbundle.putString("location", patient.getLocation());
                    IDbundle.putString("dataid", patient.getDataID());
                    IDbundle.putString("tableid", TABLEID);
                    IDbundle.putString("studyid", patient.getStudyID());
                    IDbundle.putString("hospitalid", patient.getHospitalID());
                    IDbundle.putString("name",patient.getpatName());
                    IDbundle.putString("address",patient.getMainAddress());
                    IDbundle.putString("age", patient.getPatAge() + (patient.getLocation().equals(ProjectSetting.LABOR_AND_DELIVERY_ID)?"": "   "+ patient.getPatSex()));

                    IDbundle.putString("ob", patient.getObserve());
                    IDbundle.putString("mrs", patient.getRS());
                    IDbundle.putString("de", patient.getDE());

                    IDbundle.putString("type", "obj");
                    Intent intent = new Intent(getApplicationContext(), Observation.class);
                    //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtras(IDbundle);
                    startActivityForResult(intent, 1);
                    //startActivity(intent);
                    //getApplicationContext().startActivity(intent);
                }
            });


            holder.cmdRS.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Bundle IDbundle = new Bundle();
                    if(!patient.getObserve().equals("1") & !patient.getLocation().equals(ProjectSetting.SEPSIS_ID)){
                        Connection.MessageBox(PatientList.this,"Please complete the observation, then try for Recall Survey.");
                        return;
                    }
                    //String TABLEID = "";
                    //if(patient.getLocation().equals(ProjectSetting.LABOR_AND_DELIVERY_ID)) TABLEID = "1";
                    //else if(patient.getLocation().equals(ProjectSetting.KMC_ID)) TABLEID = "6";

                    IDbundle.putString("location", patient.getLocation());
                    IDbundle.putString("dataid", patient.getDataID());
                    //IDbundle.putString("tableid", TABLEID);
                    IDbundle.putString("studyid", patient.getStudyID());
                    IDbundle.putString("hospitalid", patient.getHospitalID());
                    IDbundle.putString("name",patient.getpatName());
                    IDbundle.putString("address",patient.getMainAddress());
                    IDbundle.putString("age", patient.getPatAge() + (patient.getLocation().equals(ProjectSetting.LABOR_AND_DELIVERY_ID)?"": "   "+ patient.getPatSex()));

                    IDbundle.putString("ob", patient.getObserve());
                    IDbundle.putString("mrs", patient.getRS());
                    IDbundle.putString("de", patient.getDE());

                    IDbundle.putString("type", "rs");

                    Intent intent = new Intent(getApplicationContext(), Observation.class);
                    //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtras(IDbundle);
                    startActivityForResult(intent, 1);
                    //startActivity(intent);
                    //getApplicationContext().startActivity(intent);
                }
            });

            holder.cmdDE.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Bundle IDbundle = new Bundle();
                    IDbundle.putString("CountryCode", COUNTRYCODE);
                    IDbundle.putString("FaciCode", FACICODE);
                    IDbundle.putString("DataID", patient.getDataID());

                    IDbundle.putString("location", patient.getLocation());
                    //IDbundle.putString("tableid", TABLEID);
                    IDbundle.putString("studyid", patient.getStudyID());
                    IDbundle.putString("hospitalid", patient.getHospitalID());
                    IDbundle.putString("name",patient.getpatName());
                    IDbundle.putString("address",patient.getMainAddress());
                    IDbundle.putString("age", patient.getPatAge() + (patient.getLocation().equals(ProjectSetting.LABOR_AND_DELIVERY_ID)?"": "   "+ patient.getPatSex()));

                    IDbundle.putString("ob", patient.getObserve());
                    IDbundle.putString("mrs", patient.getRS());
                    IDbundle.putString("de", patient.getDE());

                    IDbundle.putString("type", "de");
                    Intent intent = null;
                    if(patient.getLocation().equals(ProjectSetting.LABOR_AND_DELIVERY_ID)) {
                        intent = new Intent(getApplicationContext(), LD_DataExt.class);
                    }else if(patient.getLocation().equals(ProjectSetting.KMC_ID)) {
                        intent = new Intent(getApplicationContext(), KMC_DataExt.class);
                    }
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtras(IDbundle);
                    //startActivity(intent);
                    startActivityForResult(intent, 1);
                    //getApplicationContext().startActivity(intent);
                }
            });

            holder.cmdACS.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Bundle IDbundle = new Bundle();
                    IDbundle.putString("CountryCode", COUNTRYCODE);
                    IDbundle.putString("FaciCode", FACICODE);
                    IDbundle.putString("DataID", patient.getDataID());

                    IDbundle.putString("location", patient.getLocation());
                    //IDbundle.putString("tableid", TABLEID);
                    IDbundle.putString("studyid", patient.getStudyID());
                    IDbundle.putString("hospitalid", patient.getHospitalID());
                    IDbundle.putString("name",patient.getpatName());
                    IDbundle.putString("address",patient.getMainAddress());
                    IDbundle.putString("age", patient.getPatAge() + (patient.getLocation().equals(ProjectSetting.LABOR_AND_DELIVERY_ID)?"": "   "+ patient.getPatSex()));
                    IDbundle.putString("agey", patient.getPatAge());
                    IDbundle.putString("ob", patient.getObserve());
                    IDbundle.putString("mrs", patient.getRS());
                    IDbundle.putString("de", patient.getDE());

                    IDbundle.putString("type", "de");
                    Intent intent = null;
                    intent = new Intent(getApplicationContext(), Acs_Veri.class);

                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtras(IDbundle);
                    //startActivity(intent);
                    startActivityForResult(intent, 1);
                    //getApplicationContext().startActivity(intent);
                }
            });

            holder.cmdVER.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Bundle IDbundle = new Bundle();
                    String TABLEID = "";

                    IDbundle.putString("location", patient.getLocation());
                    IDbundle.putString("dataid", patient.getDataID());
                    IDbundle.putString("tableid", TABLEID);
                    IDbundle.putString("studyid", patient.getStudyID());
                    IDbundle.putString("hospitalid", patient.getHospitalID());
                    IDbundle.putString("name",patient.getpatName());
                    IDbundle.putString("address",patient.getMainAddress());
                    IDbundle.putString("age", patient.getPatAge() + (patient.getLocation().equals(ProjectSetting.LABOR_AND_DELIVERY_ID)?"": "   "+ patient.getPatSex()));

                    IDbundle.putString("ob", patient.getObserve());
                    IDbundle.putString("mrs", patient.getRS());
                    IDbundle.putString("de", patient.getDE());

                    IDbundle.putString("type", "inf");
                    Intent intent = new Intent(getApplicationContext(), Observation.class);
                    //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtras(IDbundle);
                    //startActivity(intent);
                    startActivityForResult(intent, 1);
                    //getApplicationContext().startActivity(intent);
                }
            });

            holder.secRow.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    //Write your code here
                    Bundle IDbundle = new Bundle();
                    IDbundle.putString("locationid", patient.getLocation());
                    IDbundle.putString("dataid", patient.getDataID());
                    IDbundle.putString("sid", patient.getStudyID());
                    Intent intent = new Intent(getApplicationContext(), Registration.class);
                    //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtras(IDbundle);
                    //getApplicationContext().startActivity(intent);

                    startActivityForResult(intent, 1);
                }
            });

        }

        @Override
        public int getItemCount() {
            return patientList.size();
        }
    }


    public class Patient {
        private String _Serial = "";
        public String getSerial(){
            return _Serial;
        }
        public void setSerial(String newValue){
            _Serial = newValue;
        }

        private String _Location = "";
        public String getLocation(){
            return _Location;
        }
        public void setLocation(String newValue){
            _Location = newValue;
        }
        private String _DataID = "";
        public String getDataID(){
            return _DataID;
        }
        public void setDataID(String newValue){
            _DataID = newValue;
        }
        private String _HospitalID = "";
        public String getHospitalID(){
            return _HospitalID;
        }
        public void setHospitalID(String newValue){
            _HospitalID = newValue;
        }

        private String _RegDate = "";
        public String getRegDate(){
            return _RegDate;
        }
        public void setRegDate(String newValue){
            _RegDate = newValue;
        }
        private String _RegTime = "";
        public String getRegTime(){
            return _RegTime;
        }
        public void setRegTime(String newValue){
            _RegTime = newValue;
        }
        private String _patName = "";
        public String getpatName(){
            return _patName;
        }
        public void setpatName(String newValue){
            _patName = newValue;
        }
        private String _PatAge = "";
        public String getPatAge(){
            return _PatAge;
        }
        public void setPatAge(String newValue){
            _PatAge = newValue;
        }
        private String _PatSex = "";
        public String getPatSex(){
            return _PatSex;
        }
        public void setPatSex(String newValue){
            _PatSex = newValue;
        }

        private String _PatAgeDMY = "";
        public String getPatAgeDMY(){
            return _PatAgeDMY;
        }
        public void setPatAgeDMY(String newValue){
            _PatAgeDMY = newValue;
        }
        private String _PatDOB = "";
        public String getPatDOB(){
            return _PatDOB;
        }
        public void setPatDOB(String newValue){
            _PatDOB = newValue;
        }
        private String _MainAddress = "";
        public String getMainAddress(){
            return _MainAddress;
        }
        public void setMainAddress(String newValue){
            _MainAddress = newValue;
        }
        private String _StudyID = "";
        public String getStudyID(){
            return _StudyID;
        }
        public void setStudyID(String newValue){
            _StudyID = newValue;
        }
        private String _Phone1 = "";
        public String getPhone1(){
            return _Phone1;
        }
        public void setPhone1(String newValue){
            _Phone1 = newValue;
        }
        private String _Phone2 = "";
        public String getPhone2(){
            return _Phone2;
        }
        public void setPhone2(String newValue){
            _Phone2 = newValue;
        }

        private String _Observe = "";
        public String getObserve(){
            return _Observe;
        }
        public void setObserve(String newValue){
            _Observe = newValue;
        }

        private String _RS = "";
        public String getRS(){
            return _RS;
        }
        public void setRS(String newValue){
            _RS = newValue;
        }

        private String _DE = "";
        public String getDE(){
            return _DE;
        }
        public void setDE(String newValue){
            _DE = newValue;
        }

        private String _INFXNStatus = "";
        public String getINFXNStatus(){
            return _INFXNStatus;
        }
        public void setINFXNStatus(String newValue){
            _INFXNStatus = newValue;
        }

        private String _ACSStatus = "";
        public String getACSStatus(){
            return _ACSStatus;
        }
        public void setACSStatus(String newValue){
            _ACSStatus = newValue;
        }
        //------------------------------------------------------------------------------------------
        private String _ACS = "";
        public String getACS(){
            return _ACS;
        }
        public void setACS(String newValue){
            _ACS = newValue;
        }
    }


    public class DividerItemDecoration extends RecyclerView.ItemDecoration {
        private final int[] ATTRS = new int[]{
                android.R.attr.listDivider
        };

        public static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;

        public static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;

        private Drawable mDivider;

        private int mOrientation;

        public DividerItemDecoration(Context context, int orientation) {
            final TypedArray a = context.obtainStyledAttributes(ATTRS);
            mDivider = a.getDrawable(0);
            a.recycle();
            setOrientation(orientation);
        }

        public void setOrientation(int orientation) {
            if (orientation != HORIZONTAL_LIST && orientation != VERTICAL_LIST) {
                throw new IllegalArgumentException("invalid orientation");
            }
            mOrientation = orientation;
        }

        @Override
        public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
            if (mOrientation == VERTICAL_LIST) {
                drawVertical(c, parent);
            } else {
                drawHorizontal(c, parent);
            }
        }

        public void drawVertical(Canvas c, RecyclerView parent) {
            final int left = parent.getPaddingLeft();
            final int right = parent.getWidth() - parent.getPaddingRight();

            final int childCount = parent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                final View child = parent.getChildAt(i);
                final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                        .getLayoutParams();
                final int top = child.getBottom() + params.bottomMargin;
                final int bottom = top + mDivider.getIntrinsicHeight();
                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(c);
            }
        }

        public void drawHorizontal(Canvas c, RecyclerView parent) {
            final int top = parent.getPaddingTop();
            final int bottom = parent.getHeight() - parent.getPaddingBottom();

            final int childCount = parent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                final View child = parent.getChildAt(i);
                final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                        .getLayoutParams();
                final int left = child.getRight() + params.rightMargin;
                final int right = left + mDivider.getIntrinsicHeight();
                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(c);
            }
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            if (mOrientation == VERTICAL_LIST) {
                outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
            } else {
                outRect.set(0, 0, mDivider.getIntrinsicWidth(), 0);
            }
        }
    }



    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {
        private GestureDetector gestureDetector;
        private PatientList.RecyclerTouchListener.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final PatientList.RecyclerTouchListener.ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }

        interface ClickListener {
            void onClick(View view, int position);
            void onLongClick(View view, int position);
        }
    }



    protected Dialog onCreateDialog(int id) {
        final Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);
        switch (id) {
            case DATE_DIALOG:
                return new DatePickerDialog(this, mDateSetListener,g.mYear,g.mMonth-1,g.mDay);

        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mYear = year; mMonth = monthOfYear+1; mDay = dayOfMonth;
            EditText dtpDate;


            dtpDate = (EditText)findViewById(R.id.dtpFDate);
            if (VariableID.equals("dtpFDate"))
            {
                dtpDate = (EditText)findViewById(R.id.dtpFDate);
            }
            else if (VariableID.equals("dtpTDate"))
            {
                dtpDate = (EditText)findViewById(R.id.dtpTDate);
            }
            dtpDate.setText(new StringBuilder()
                    .append(Global.Right("00"+mDay,2)).append("/")
                    .append(Global.Right("00"+mMonth,2)).append("/")
                    .append(mYear));
        }
    };







    Dialog dialog;
    SimpleAdapter dataAdapter;
    ArrayList<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();
    public void Patient_List_Form_Assignment(String Location) {
        try {
            dialog = new Dialog(PatientList.this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.trac_ld_patient_list);
            dialog.setCanceledOnTouchOutside(true);
            dialog.setCancelable(true);

            /*Window window = dialog.getWindow();
            WindowManager.LayoutParams wlp = window.getAttributes();

            wlp.gravity = Gravity.TOP;
            wlp.flags &= ~WindowManager.LayoutParams.FLAG_DIM_BEHIND;
            window.setAttributes(wlp);*/
            final RadioButton rdoLocation1=(RadioButton)dialog.findViewById(R.id.rdoLocation1);
            final RadioButton rdoLocation2=(RadioButton)dialog.findViewById(R.id.rdoLocation2);

            Button cmdClose = (Button) dialog.findViewById(R.id.cmdClose);
            cmdClose.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    dialog.dismiss();
                }});
            final Spinner spnObserver = (Spinner)dialog.findViewById(R.id.spnObserver);
            spnObserver.setAdapter(C.getArrayAdapter("Select '' union Select UserId||'-'||UserName from DataCollector where FaciCode='"+ FACICODE +"' and JobType='2'"));

            Button cmdAssign = (Button) dialog.findViewById(R.id.cmdAssign);
            cmdAssign.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if(spnObserver.getSelectedItemPosition()==0){
                        Connection.MessageBox(PatientList.this,"Select observer name from the list.");
                        return;
                    }
                    AlertDialog.Builder adb = new AlertDialog.Builder(PatientList.this);
                    adb.setTitle("Patient Assign");
                    adb.setMessage("Do you want to assign selected patient for this observer[Yes/No]?");
                    adb.setNegativeButton("No", null);
                    adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            String DID = "";
                            String OBJID = spnObserver.getSelectedItem().toString().split("-")[0];
                            for(int i=0;i<DataIdList.size();i++) {
                                DID = DataIdList.get(i);
                                C.Save("Update Registration set ObserverId='"+ OBJID +"',modifyDate='"+ Global.DateTimeNowYMDHMS() +"',Upload='2' where CountryCode='" + COUNTRYCODE + "' and FaciCode='" + FACICODE + "' and DataId='" + DID + "'");
                            }

                            //RegistrationDataSync(PatientList.this);
                            Connection.RegistrationDataSync(PatientList.this);
                            if(rdoLocation1.isChecked())
                                PatientList(ProjectSetting.LABOR_AND_DELIVERY_ID);
                            else if(rdoLocation2.isChecked())
                                PatientList(ProjectSetting.KMC_ID);

                            preparePatientList();
                            dialog.dismiss();
                        }});
                    adb.show();


                }
            });

            C.Save("Update Registration set SelectPat='2'");
            PatientList(ProjectSetting.LABOR_AND_DELIVERY_ID);

            RadioGroup rdogrpLocation = (RadioGroup) dialog.findViewById(R.id.rdogrpLocation);
            rdogrpLocation.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
            {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId)
                {
                    switch(checkedId)
                    {
                        case R.id.rdoLocation1:
                            PatientList(ProjectSetting.LABOR_AND_DELIVERY_ID);
                            break;
                        case R.id.rdoLocation2:
                            PatientList(ProjectSetting.KMC_ID);
                            break;
                    }
                }
            });

            dialog.show();
        } catch (Exception e) {
            Connection.MessageBox(PatientList.this, e.getMessage());
            return;
        }
    }

    public  void RegistrationDataSync(final Context cont)
    {
        if (Connection.haveNetworkConnection(cont)) {
            List<String> tableList = new ArrayList<String>();
            tableList.add("Registration");
            C.Sync_Upload(tableList);
        }
    }

    public void PatientList(String Loc)
    {
        try
        {
            Registration_DataModel d = new Registration_DataModel();
            String param = "";
            /*String SQL = "Select * from Registration r ";
            SQL += " left outer join DataCollector d on r.ObserverId=d.UserId";
            SQL += " Where r.CountryCode='"+ COUNTRYCODE +"' and r.FaciCode='"+ FACICODE +"' and r.Consent in('1','5') and r.RegisType='"+ Loc +"'";
            SQL += " and ifnull(StatusObj,'')<>'1' and ifnull(ObserverId,'')='"+ ENTRYUSER +"' order by r.EnDt desc";*/

            String SQL = "Select r.CountryCode, r.FaciCode, r.RegisType, r.DataID, r.RegDate, r.RegTime, r.HospID, r.HospIDReTyp, r.Consent, r.StudyID, r.MotRegis, r.MotDataID, r.MotStudyID, r.MotStudyIDReType, r.MotHospID, r.MotName, r.MotDOB, r.MotDOBDK, r.MotAge, r.MotEdu, r.MotEduDK, r.Parity, r.MotEthnicity, r.MotEthnicityOth, r.MotReligion, r.MotReligionOth, r.Address1, r.Address2, r.Address3, r.Address4, r.AddressDetail, r.MotContact, r.AltContact, r.NameNewBorn, r.DOBNewborn, r.DOBNewbornDK, r.TOBNewborn, r.TOBNewbornDK, r.AgeNewborn, r.AgeNewbornDMY, r.Sex, r.FatherName, r.CompleteAdd, r.CompleteStatus, r.ObjPause, r.ObserverId, r.StatusObj, r.StatusRS, r.StatusDE, r.StatusACS, r.StatusINFXN, r.SelectPat,d.UserId, d.UserName, d.JobType, d.Active,ifnull(o.ObservDT,'')as deldt from Registration r ";
            SQL += " left outer join DataCollector d on r.ObserverId=d.UserId";
            SQL += " left outer join Observation o on r.CountryCode=o.CountryCode and r.FaciCode=o.FaciCode and r.DataID=o.DataID and VarName='BabyDel' and SL='1'";
            SQL += " Where r.CountryCode='"+ COUNTRYCODE +"' and r.FaciCode='"+ FACICODE +"' and r.Consent in('1','5') and r.RegisType='"+ Loc +"'";
            SQL += " and ifnull(StatusObj,'')<>'1' and ifnull(ObserverId,'')='"+ ENTRYUSER +"' order by r.EnDt desc";

            List<Registration_DataModel> data = d.SelectAll_Assign(this, SQL);
            dataList.clear();
            dataAdapter = null;

            ListView list = (ListView)dialog.findViewById(R.id.lstData);

            HashMap<String, String> map;
            Integer i = 0;
            for(Registration_DataModel item : data){
                map = new HashMap<String, String>();
                map.put("countrycode", item.getCountryCode());
                map.put("facicode", item.getFaciCode());

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
                map.put("objname", item.getObserverName());
                map.put("sl",String.valueOf(i));
                map.put("select",item.getSelectPat());
                map.put("deldt",item.getdelDt());

                i+=1;
                dataList.add(map);
            }

            dataAdapter = new SimpleAdapter(PatientList.this, dataList, R.layout.trac_ld_patient_list,new String[] {"rowsec"},
                    new int[] {R.id.secRow});
            list.setAdapter(new PatientList.DataListAdapter(this, dataAdapter));

        }
        catch(Exception  e)
        {
            Connection.MessageBox(PatientList.this, e.getMessage());
            return;
        }
    }

    public void PatientListDataAdapter(String Loc)
    {
        try
        {
            Registration_DataModel d = new Registration_DataModel();
            String param = "";
            /*String SQL = "Select * from Registration r ";
            SQL += " left outer join DataCollector d on r.ObserverId=d.UserId";
            SQL += " Where r.CountryCode='"+ COUNTRYCODE +"' and r.FaciCode='"+ FACICODE +"' and r.Consent in('1','5') and r.RegisType='"+ Loc +"'";
            SQL += " and ifnull(StatusObj,'')<>'1' and ifnull(ObserverId,'')='"+ ENTRYUSER +"' order by r.EnDt desc";*/

            String SQL = "Select r.CountryCode, r.FaciCode, r.RegisType, r.DataID, r.RegDate, r.RegTime, r.HospID, r.HospIDReTyp, r.Consent, r.StudyID, r.MotRegis, r.MotDataID, r.MotStudyID, r.MotStudyIDReType, r.MotHospID, r.MotName, r.MotDOB, r.MotDOBDK, r.MotAge, r.MotEdu, r.MotEduDK, r.Parity, r.MotEthnicity, r.MotEthnicityOth, r.MotReligion, r.MotReligionOth, r.Address1, r.Address2, r.Address3, r.Address4, r.AddressDetail, r.MotContact, r.AltContact, r.NameNewBorn, r.DOBNewborn, r.DOBNewbornDK, r.TOBNewborn, r.TOBNewbornDK, r.AgeNewborn, r.AgeNewbornDMY, r.Sex, r.FatherName, r.CompleteAdd, r.CompleteStatus, r.ObjPause, r.ObserverId, r.StatusObj, r.StatusRS, r.StatusDE, r.StatusACS, r.StatusINFXN, r.SelectPat,d.UserId, d.UserName, d.JobType, d.Active,ifnull(o.ObservDT,'')as deldt from Registration r ";
            SQL += " left outer join DataCollector d on r.ObserverId=d.UserId";
            SQL += " left outer join Observation o on r.CountryCode=o.CountryCode and r.FaciCode=o.FaciCode and r.DataID=o.DataID and VarName='BabyDel' and SL='1'";
            SQL += " Where r.CountryCode='"+ COUNTRYCODE +"' and r.FaciCode='"+ FACICODE +"' and r.Consent in('1','5') and r.RegisType='"+ Loc +"'";
            SQL += " and ifnull(StatusObj,'')<>'1' and ifnull(ObserverId,'')='"+ ENTRYUSER +"' order by r.EnDt desc";

            List<Registration_DataModel> data = d.SelectAll_Assign(this, SQL);
            dataList.clear();
            dataAdapter = null;

            ListView list = (ListView)dialog.findViewById(R.id.lstData);

            HashMap<String, String> map;
            Integer i = 0;
            for(Registration_DataModel item : data){
                map = new HashMap<String, String>();
                map.put("countrycode", item.getCountryCode());
                map.put("facicode", item.getFaciCode());

                map.put("dataid", item.getDataID());
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
                map.put("objname", item.getObserverName());
                map.put("sl",String.valueOf(i));
                map.put("select",item.getSelectPat());
                map.put("deldt",item.getdelDt());

                i+=1;
                dataList.add(map);
            }

            dataAdapter = new SimpleAdapter(PatientList.this, dataList, R.layout.trac_ld_patient_list,new String[] {"rowsec"},
                    new int[] {R.id.secRow});

        }
        catch(Exception  e)
        {
            Connection.MessageBox(PatientList.this, e.getMessage());
            return;
        }
    }

    ArrayList<String> DataIdList = new ArrayList<String>();
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
                convertView = inflater.inflate(R.layout.trac_ld_patient_list_row, null);
            }
            //LinearLayout   secListRow = (LinearLayout)convertView.findViewById(R.id.secListRow);
            final RelativeLayout secRow = (RelativeLayout) convertView.findViewById(R.id.secRow);
            final TextView studyId1 = (TextView) convertView.findViewById(R.id.txtStudyID);
            final TextView hospitalId1 = (TextView) convertView.findViewById(R.id.txtHospID);
            final TextView patientName1 = (TextView) convertView.findViewById(R.id.txtName);
            final TextView patientAge1 = (TextView) convertView.findViewById(R.id.txtAge);
            final TextView patientAddress1 = (TextView) convertView.findViewById(R.id.txtAddress);
            final TextView location1 = (TextView) convertView.findViewById(R.id.lblType);
            final TextView txtObserver = (TextView) convertView.findViewById(R.id.txtObserver);
            final TextView txtDelDate = (TextView) convertView.findViewById(R.id.txtDelDate);
            final CheckBox chkSelect = (CheckBox) convertView.findViewById(R.id.chkSelect);

            final HashMap<String, String> o = (HashMap<String, String>) dataAdap.getItem(position);
            studyId1.setText(o.get("studyid"));
            hospitalId1.setText(o.get("hospitalid"));
            patientName1.setText(o.get("patname"));
            patientAge1.setText(o.get("patage"));
            patientAddress1.setText(o.get("mainaddress"));
            txtDelDate.setText("Delivery DT: "+ Global.DateConvertDMY(o.get("deldt")));
            if(o.get("objname")!=null) {
                txtObserver.setVisibility(View.VISIBLE);
                txtObserver.setText("Observer: " + o.get("objname"));
            }else{
                txtObserver.setVisibility(View.GONE);
            }

            /*if(Integer.valueOf(o.get("sl"))%2==0)
                secRow.setBackgroundColor(Color.parseColor("#F3F3F3"));
            else
                secRow.setBackgroundColor(Color.parseColor("#FFFFFF"));*/

            chkSelect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(chkSelect.isChecked()){
                        C.Save("Update Registration set SelectPat='1' where CountryCode='"+ o.get("countrycode") +"' and FaciCode='"+ o.get("facicode") +"' and DataID='"+ o.get("dataid") +"'");
                        PatientListDataAdapter(ProjectSetting.LABOR_AND_DELIVERY_ID);
                        dataAdap = dataAdapter;
                        dataAdap.notifyDataSetChanged();

                        //PatientListDataAdapter(ProjectSetting.LABOR_AND_DELIVERY_ID);
                        //dataAdapter.notifyDataSetChanged();
                        DataIdList.add(o.get("dataid"));
                        secRow.setBackgroundColor(Color.GREEN);
                    }else{
                        C.Save("Update Registration set SelectPat='2' where CountryCode='"+ o.get("countrycode") +"' and FaciCode='"+ o.get("facicode") +"' and DataID='"+ o.get("dataid") +"'");
                        PatientListDataAdapter(ProjectSetting.LABOR_AND_DELIVERY_ID);
                        dataAdap = dataAdapter;
                        dataAdap.notifyDataSetChanged();

                        //PatientListDataAdapter(ProjectSetting.LABOR_AND_DELIVERY_ID);
                        //dataAdapter.notifyDataSetChanged();
                        for(int i=0;i<DataIdList.size();i++)
                        {
                            if(DataIdList.get(i).equals(o.get("dataid")))
                            {
                                DataIdList.remove(i);
                            }
                        }
                        secRow.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    }
                }
            });

            if(o.get("select").equals("1")) {
                chkSelect.setChecked(true);
                secRow.setBackgroundColor(Color.GREEN);
            }else{
                chkSelect.setChecked(false);
                secRow.setBackgroundColor(Color.parseColor("#FFFFFF"));
            }


            return convertView;
        }
    }


    private class DataSyncTask extends AsyncTask<String, Void, Void> {
        ProgressDialog dialog;
        private Context context;
        String resp = "";
        public void setContext(Context contextf){
            context = contextf;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(PatientList.this);
            dialog.setMessage("Data Sync in Progress, Please wait ...");
            dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            dialog.setCancelable(false);
            dialog.show();
        }

        //@Override
        protected void onProgressUpdate(String... values) {
            //super.onProgressUpdate(values);
            //dialog.setMessage("Syncing Table "+ values[0].toString().split(",")[0] +" ...");
            dialog.setProgress(Integer.parseInt(values[0].toString().split(",")[1]));
        }

        @Override
        protected Void doInBackground(String... params) {
            final String[] ID = params[0].toString().split("-");
            final String COUNTRYCODE = ID[0].toString();
            final String FACICODE    = ID[1].toString();
            final String DEVICEID    = ID[2].toString();
            final String ENTRYUSER   = ID[3].toString();

            //Connection.DataSync(COUNTRYCODE, FACICODE, DEVICEID, ENTRYUSER);

            try {
                 new Thread() {
                    public void run() {
                        try {
                            //Upload
                            List<String> tableList = new ArrayList<String>();
                            tableList.add("Registration");
                            tableList.add("ObsHisCurPreg");
                            tableList.add("KmcPreObs");
                            tableList.add("InfPreObs");

                            tableList.add("KMC_DataExt");
                            tableList.add("LD_DataExt");

                            tableList.add("KMC_Feed");
                            tableList.add("KMC_Init");
                            tableList.add("KMC_Pos");
                            tableList.add("KMC_Treat");
                            tableList.add("KMC_Outcome");

                            tableList.add("Observation");
                            tableList.add("LD_Outcome");
                            tableList.add("ObjPauseLog");

                            tableList.add("RecallSurvS1");
                            tableList.add("RecallSurvS2");
                            tableList.add("RecallSurvS3");
                            tableList.add("RecallSurvS4");
                            tableList.add("RecallSurvS5");
                            tableList.add("MRS_FinalStatus");
                            tableList.add("MRS_FollowUp");
                            tableList.add("Acs_Veri");

                            tableList.add("Infver_Pdetail");
                            tableList.add("Infver_Denomin");
                            tableList.add("Infver_SupCare");
                            tableList.add("Infver_Anti");
                            tableList.add("Infver_labInv");
                            tableList.add("Infver_Outcome");

                            int progressCount = 50/tableList.size();
                            int count = 0;
                            //C.Sync_Upload(tableList);
                            for (int i = 0; i < tableList.size(); i++) {
                                try {
                                    C.Sync_Upload_Process(tableList.get(i).toString());
                                    count +=progressCount;
                                    onProgressUpdate(tableList.get(i).toString()+","+String.valueOf(count));
                                }catch(Exception ex){

                                }
                            }

                            //Download
                            C.Sync_Download("DataCollector",DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");
                            C.Sync_Download("DCJobType",   DEVICEID,"");
                            C.Sync_Download("ObjTableList",DEVICEID,"");
                            C.Sync_Download("ObjVarList",  DEVICEID,"");

                            //count = 0;
                            List<String> pdata = new ArrayList<String>();
                            for (int i = 0; i < tableList.size(); i++) {
                                try {
                                    C.Sync_Download(tableList.get(i).toString(), DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");
                                    count +=progressCount;
                                    onProgressUpdate(tableList.get(i).toString()+","+String.valueOf(count));
                                }catch(Exception ex){

                                }
                            }

                            preparePatientList();
                            //mAdapter.notifyDataSetChanged();
                            /*resp = Connection.DataSync(COUNTRYCODE, FACICODE, DEVICEID, ENTRYUSER);
                            //dialog.dismiss();
                            if(resp.equals("done")) {
                                //Toast.makeText(MainActivity.this, "Data Sync successfully completed.",Toast.LENGTH_LONG).show();
                                //Connection.MessageBox(MainActivity.this, "Data Sync successfully completed.");
                                dialog.dismiss();

                            }else{
                                //Toast.makeText(MainActivity.this, resp,Toast.LENGTH_LONG).show();
                                dialog.dismiss();
                            }*/
                        } catch (Exception e) {
                            resp = e.getMessage();
                            dialog.dismiss();
                        }finally {
                            dialog.dismiss();
                        }
                    }
                }.start();

            } catch (Exception e) {

            }
            // do stuff!
            return null;
        }

        //@Override
        protected void onPostExecute(String result) {
            if(result.length()!=0) {
                Connection.MessageBox(PatientList.this, "Data Sync successfully completed.");
                dialog.dismiss();
            }
        }
    }
}
