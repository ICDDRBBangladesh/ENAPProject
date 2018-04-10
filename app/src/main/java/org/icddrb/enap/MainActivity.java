package org.icddrb.enap;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Common.Connection;
import Common.Global;
import Common.ProjectSetting;
import Utility.MySharedPreferences;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Connection C;
    MySharedPreferences sp;

    static String DEVICEID    = "";
    static String ENTRYUSER   = "";
    static String COUNTRYCODE = "";
    static String FACICODE    = "";
    //-------------------------
    static String JOBTYPE     = "";

    Button cmdRegistration;
    Button cmdPatientAssign;
    Button cmdLDObj;
    Button cmdKMCObj;
    Button cmdMRecall;
    Button cmdLDDataExt;
    Button cmdSepsis;
    Button cmdACS;
    Button cmdFollowup;
    Button cmdDataSync;
    Button cmdExit;
    TextView txtUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        C = new Connection(this);
        DEVICEID    = sp.getValue(this, "deviceid");
        ENTRYUSER   = sp.getValue(this, "userid");
        COUNTRYCODE = sp.getValue(this, "countrycode");
        FACICODE    = sp.getValue(this, "facicode");

        JOBTYPE     = sp.getValue(this, "jobtype");

        TextView lblProjectTitle = (TextView)findViewById(R.id.lblProjectTitle);
        if(ProjectSetting.ProjectTitle.length()==0){
            lblProjectTitle.setVisibility(View.GONE);
        }else{
            lblProjectTitle.setVisibility(View.VISIBLE);
            lblProjectTitle.setText(ProjectSetting.ProjectTitle);
        }

        txtUserName = (TextView)findViewById(R.id.txtUserName);
        txtUserName.setText(C.ReturnSingleValue("Select 'Login User: '|| UserId||'-'||UserName from DataCollector where UserId='"+ ENTRYUSER +"'"));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //Registration
        //------------------------------------------------------------------------------------------
        cmdRegistration = (Button) findViewById(R.id.cmdRegistration);
        cmdRegistration.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //finish();
                Bundle b = new Bundle();
                b.putString("location","1");
                b.putString("role","1"); //Registration
                Intent f1 = new Intent(getApplicationContext(),PatientList.class);
                f1.putExtras(b);
                startActivity(f1);
            }
        });

        //Patient Assign
        //------------------------------------------------------------------------------------------
        cmdPatientAssign = (Button) findViewById(R.id.cmdPatientAssign);
        cmdPatientAssign.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Patient_List_Form_Assignment(ProjectSetting.LABOR_AND_DELIVERY_ID);
            }
        });



        //Observation
        //------------------------------------------------------------------------------------------
        //Labour and delivery
        cmdLDObj = (Button) findViewById(R.id.cmdLDObj);
        cmdLDObj.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //finish();
                Bundle b = new Bundle();
                b.putString("location",ProjectSetting.LABOR_AND_DELIVERY_ID);
                b.putString("role","2"); //Observation
                Intent f1 = new Intent(getApplicationContext(),PatientList.class);
                f1.putExtras(b);
                startActivity(f1);
            }
        });

        //kmc
        cmdKMCObj = (Button) findViewById(R.id.cmdKMCObj);
        cmdKMCObj.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //finish();
                Bundle b = new Bundle();
                b.putString("location",ProjectSetting.KMC_ID);
                b.putString("role","2"); //Observation
                Intent f1 = new Intent(getApplicationContext(),PatientList.class);
                f1.putExtras(b);
                startActivity(f1);
            }
        });

        //Exit Interview
        //------------------------------------------------------------------------------------------
        //Maternal Recall
        cmdMRecall = (Button) findViewById(R.id.cmdMRecall);
        cmdMRecall.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //finish();
                Bundle b = new Bundle();
                b.putString("location",ProjectSetting.EXIT_INTERVIEW_ID);
                b.putString("role","3"); //exit interview
                Intent f1 = new Intent(getApplicationContext(),PatientList.class);
                f1.putExtras(b);
                startActivity(f1);
            }
        });


        //Data Extraction
        //------------------------------------------------------------------------------------------
        //Labour and delivery
        cmdLDDataExt = (Button) findViewById(R.id.cmdLDDataExt);
        cmdLDDataExt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //finish();
                Bundle b = new Bundle();
                b.putString("location",ProjectSetting.DATA_EXTRACTION_ID);
                b.putString("role","4"); //data extraction
                Intent f1 = new Intent(getApplicationContext(),PatientList.class);
                f1.putExtras(b);
                startActivity(f1);
            }
        });


        //Verification
        //------------------------------------------------------------------------------------------
        //ACS
        cmdACS = (Button) findViewById(R.id.cmdACS);
        cmdACS.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //finish();
                Bundle b = new Bundle();
                b.putString("location","5"); //acs
                b.putString("role","5"); //Verification
                Intent f1 = new Intent(getApplicationContext(),PatientList.class);
                f1.putExtras(b);
                startActivity(f1);
            }
        });

        //Sepsis
        cmdSepsis = (Button) findViewById(R.id.cmdSepsis);
        cmdSepsis.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //finish();
                Bundle b = new Bundle();
                b.putString("location","4"); //Sepsis
                b.putString("role","5"); //Verification
                Intent f1 = new Intent(getApplicationContext(),PatientList.class);
                f1.putExtras(b);
                startActivity(f1);
            }
        });


        cmdDataSync = (Button) findViewById(R.id.cmdDataSync);
        cmdDataSync.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (Connection.haveNetworkConnection(MainActivity.this)) {
                } else {
                    Connection.MessageBox(MainActivity.this,"Internet connection is not available for Data Sync.");
                    return;
                }
                String Response = "";
                //DataSync(MainActivity.this);
                new DataSyncTask().execute(COUNTRYCODE +"-"+ FACICODE +"-"+ DEVICEID +"-"+ ENTRYUSER);
                String Response1 = "";

            }
        });

        cmdExit = (Button)findViewById(R.id.cmdExit);
        cmdExit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
                adb.setTitle("Exit");
                adb.setMessage("Do you want to exit from the system[Yes/No]?");
                adb.setNegativeButton("No", null);
                adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            finishAffinity();
                        }
                        System.exit(0);
                    }});
                adb.show();
            }
        });

        cmdFollowup = (Button)findViewById(R.id.cmdFollowup);

        cmdRegistration.setVisibility(View.GONE);
        cmdPatientAssign.setVisibility(View.GONE);
        cmdLDObj.setVisibility(View.GONE);
        cmdKMCObj.setVisibility(View.GONE);
        cmdMRecall.setVisibility(View.GONE);
        cmdLDDataExt.setVisibility(View.GONE);
        cmdSepsis.setVisibility(View.GONE);
        cmdACS.setVisibility(View.GONE);
        cmdFollowup.setVisibility(View.GONE);

        UserAccess();
    }

/*    public  void RegistrationDataSync(final Context cont)
    {
        if (Connection.haveNetworkConnection(cont)) {
            List<String> tableList = new ArrayList<String>();
            tableList.add("Registration");
            C.Sync_Upload(tableList);
        }
    }*/

    public void DataSync(final Context cont)
    {
        if (Connection.haveNetworkConnection(cont)) {
        } else {
            Connection.MessageBox(cont,"Internet connection is not available for Data Sync.");
            return;
        }

        AlertDialog.Builder adb = new AlertDialog.Builder(cont);
        adb.setTitle("Data Sync");
        adb.setMessage("Do you want to Sync Data[Yes/No]?");
        adb.setNegativeButton("No", null);
        adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                final ProgressDialog progDailog = ProgressDialog.show(cont, "", "Please Wait . . .", true);

                new Thread() {
                    public void run() {
                        try {

                            Connection.DataSync(COUNTRYCODE,FACICODE,DEVICEID,ENTRYUSER);

                            //Registration : Total 100 records download for tracker
                            //if(JOBTYPE.equals(ProjectSetting.REGISTRATION_ID)){
                            //    C.Sync_Download_Registration("Registration",DEVICEID,"","100");
                            //}

                            //Update Role assignment of DC
                            //--------------------------------------------------------------
                            String SQL = "";
                            String jobloc = "";
                            String jt = "";
                            String jl = "";

                            SQL = "Select JobType from DataCollector where UserId='"+ ENTRYUSER +"'";
                            jt = C.ReturnSingleValue(SQL);
                            sp.save(MainActivity.this,"jobtype", jt.toString());
                            JOBTYPE = jt.toString();
                            UserAccess();

                                    /*SQL = "Select d.JobType||'-'||l.LocCode from DataCollector d";
                                    SQL += " Left outer join LocationDC l on d.facicode=l.facicode and d.userid=l.userid";
                                    SQL += " where d.UserId='"+ ENTRYUSER +"' and l.Active='1'";

                                    List<String> userAccess = new ArrayList<String>();
                                    userAccess = C.getDataList(SQL);

                                    for(int i=0; i< userAccess.size(); i++) {
                                        jt = userAccess.get(i).split("-")[0];
                                        jl = userAccess.get(i).split("-")[1];
                                        jobloc += jobloc.length()==0?jl:","+jl;
                                    }
                                    sp.save(MainActivity.this,"jobtype", jt.toString());
                                    sp.save(MainActivity.this,"jobloc", jobloc.toString());*/

                        } catch (Exception e) {

                        }
                        progDailog.dismiss();
                    }
                }.start();

            }});
        adb.show();
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
            dialog = new ProgressDialog(MainActivity.this);
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
                            tableList.add("Infver_Inj");
                            tableList.add("Infver_labInv");
                            tableList.add("Infver_Outcome");

                            //For Nepal: 19 Mar 2018
                            //tableList.clear();
                            //tableList.add("Observation");
                            /*if(COUNTRYCODE.equals(ProjectSetting.NEPAL)){
                                for (int i = 0; i < tableList.size(); i++) {
                                    try {
                                        C.SaveData("Update "+ tableList.get(i).toString() +"" +
                                                " set Upload='2' where DeviceId='"+ DEVICEID +"' and endt>='2018-03-01'");
                                    }catch(Exception ex){

                                    }
                                }
                            }*/

                            int progressCount = 50/tableList.size();
                            int count = 0;
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

                            //09 Sep 2017
                            //Download from MainDB if QA/Supervisor System
                            if(ProjectSetting.ProjectTitle.length()>0) {
                                //Data pull from ENAPDB database
                                C.ExecuteCommandOnServer("sp_Data_Pull_From_ENAPDB");
                            }


                            //Downlaod from Current DB
                            for (int i = 0; i < tableList.size(); i++) {
                                try {
                                    C.Sync_Download(tableList.get(i).toString(), DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");
                                    count +=progressCount;
                                    onProgressUpdate(tableList.get(i).toString()+","+String.valueOf(count));
                                }catch(Exception ex){

                                }
                            }

                            //resp = Connection.DataSync(COUNTRYCODE, FACICODE, DEVICEID, ENTRYUSER);
                            //dialog.dismiss();
                            if(resp.equals("done")) {
                                dialog.dismiss();

                            }else{
                                dialog.dismiss();
                            }
                        } catch (Exception e) {
                            resp = e.getMessage();
                            dialog.dismiss();
                        }
                        finally {
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
                Connection.MessageBox(MainActivity.this, "Data Sync successfully completed.");
                dialog.dismiss();
            }
        }
    }


    private void UserAccess()
    {
        if(JOBTYPE.equals(ProjectSetting.JT_REGISTRATION)){
            cmdRegistration.setVisibility(View.VISIBLE);
            cmdPatientAssign.setVisibility(View.VISIBLE);
        }else if(JOBTYPE.equals(ProjectSetting.JT_OBSERVATION)){
            cmdLDObj.setVisibility(View.VISIBLE);
            cmdKMCObj.setVisibility(View.VISIBLE);
        }else if(JOBTYPE.equals(ProjectSetting.JT_EXIT_INTERVIEW)){
            cmdMRecall.setVisibility(View.VISIBLE);
            //cmdACS.setVisibility(View.VISIBLE);
        }else if(JOBTYPE.equals(ProjectSetting.JT_DATA_EXTRACTION)){
            cmdLDDataExt.setVisibility(View.VISIBLE);
            cmdSepsis.setVisibility(View.VISIBLE);
            //cmdACS.setVisibility(View.VISIBLE);
        }else if(JOBTYPE.equals(ProjectSetting.JT_VERIFICATION)){
            //cmdACS.setVisibility(View.VISIBLE);
        }else if(JOBTYPE.equals(ProjectSetting.SUPERUSER_ID)){
            cmdRegistration.setVisibility(View.VISIBLE);
            cmdPatientAssign.setVisibility(View.VISIBLE);

            cmdLDObj.setVisibility(View.VISIBLE);
            cmdKMCObj.setVisibility(View.VISIBLE);

            cmdMRecall.setVisibility(View.VISIBLE);

            cmdLDDataExt.setVisibility(View.VISIBLE);
            cmdSepsis.setVisibility(View.VISIBLE);
        }
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_DataSync) {
            DataSync(MainActivity.this);

        } else if (id == R.id.nav_Exit) {
            AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
            adb.setTitle("Exit");
            adb.setMessage("Do you want to exit from the system[Yes/No]?");
            adb.setNegativeButton("No", null);
            adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        finishAffinity();
                    }
                    System.exit(0);
                }});
            adb.show();
        }

        /*else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {
        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    Dialog dialog;
    SimpleAdapter dataAdapter;
    ArrayList<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();
    public void Patient_List_Form_Assignment(String Location) {
        try {
            dialog = new Dialog(MainActivity.this);
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
                        Connection.MessageBox(MainActivity.this,"Select observer name from the list.");
                        return;
                    }
                    AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
                    adb.setTitle("Patient Assign");
                    adb.setMessage("Do you want to assign selected patient for this observer[Yes/No]?");
                    adb.setNegativeButton("No", null);
                    adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            String DID = "";
                            String OBJID = spnObserver.getSelectedItem().toString().split("-")[0];
                            for(int i=0;i<DataIdList.size();i++) {
                                DID = DataIdList.get(i);
                                C.SaveDT("Update Registration set ObserverId='"+ OBJID +"',modifyDate='"+ Global.DateTimeNowYMDHMS() +"',Upload='2' where CountryCode='" + COUNTRYCODE + "' and FaciCode='" + FACICODE + "' and DataId='" + DID + "'");
                            }

                            new Thread() {
                                public void run() {
                                    try {
                                        Connection.RegistrationDataSync(MainActivity.this);
                                    } catch (Exception e) {
                                    }
                                }
                            }.start();

                            //Connection.RegistrationDataSync(MainActivity.this);
                            if(rdoLocation1.isChecked())
                                PatientList(ProjectSetting.LABOR_AND_DELIVERY_ID);
                            else if(rdoLocation2.isChecked())
                                PatientList(ProjectSetting.KMC_ID);

                            dialog.dismiss();
                        }});
                    adb.show();


                }
            });

            C.SaveDT("Update Registration set SelectPat='2'");
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
            Connection.MessageBox(MainActivity.this, e.getMessage());
            return;
        }
    }


    HashMap<String, String> map;
    public void PatientList(String Loc)
    {
        try
        {
            Registration_DataModel d = new Registration_DataModel();
            String param = "";
            String SQL = "Select r.CountryCode, r.FaciCode, r.RegisType, r.DataID, r.RegDate, r.RegTime, r.HospID, r.HospIDReTyp, r.Consent, r.StudyID, r.MotRegis, r.MotDataID, r.MotStudyID, r.MotStudyIDReType, r.MotHospID, r.MotName, r.MotDOB, r.MotDOBDK, r.MotAge, r.MotEdu, r.MotEduDK, r.Parity, r.MotEthnicity, r.MotEthnicityOth, r.MotReligion, r.MotReligionOth, r.Address1, r.Address2, r.Address3, r.Address4, r.AddressDetail, r.MotContact, r.AltContact, r.NameNewBorn, r.DOBNewborn, r.DOBNewbornDK, r.TOBNewborn, r.TOBNewbornDK, r.AgeNewborn, r.AgeNewbornDMY, r.Sex, r.FatherName, r.CompleteAdd, r.CompleteStatus, r.ObjPause, r.ObserverId, r.StatusObj, r.StatusRS, r.StatusDE, r.StatusACS, r.StatusINFXN, r.SelectPat,d.UserId, d.UserName, d.JobType, d.Active,ifnull(o.ObservDT,'')as deldt from Registration r ";
            SQL += " left outer join DataCollector d on r.ObserverId=d.UserId";
            SQL += " left outer join Observation o on r.CountryCode=o.CountryCode and r.FaciCode=o.FaciCode and r.DataID=o.DataID and VarName='BabyDel' and SL='1'";
            SQL += " Where r.CountryCode='"+ COUNTRYCODE +"' and r.FaciCode='"+ FACICODE +"' and r.Consent='1' and r.RegisType='"+ Loc +"'";
            SQL += " and ifnull(StatusObj,'')<>'1' order by r.EnDt desc";

            List<Registration_DataModel> data = d.SelectAll_Assign(this, SQL);
            dataList.clear();
            dataAdapter = null;

            ListView list = (ListView)dialog.findViewById(R.id.lstData);


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

            dataAdapter = new SimpleAdapter(MainActivity.this, dataList, R.layout.trac_ld_patient_list,new String[] {"rowsec"},
                    new int[] {R.id.secRow});

            list.setAdapter(new MainActivity.DataListAdapter(this, dataAdapter));

        }
        catch(Exception  e)
        {
            Connection.MessageBox(MainActivity.this, e.getMessage());
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
            //SQL += " left outer join Observation o on r.CountryCode=o.CountryCode and r.FaciCode=o.FaciCode and r.DataID=o.DataID and VarName='BabyDel' and SL='1'";
            SQL += " Where r.CountryCode='"+ COUNTRYCODE +"' and r.FaciCode='"+ FACICODE +"' and r.Consent='1' and r.RegisType='"+ Loc +"'";
            SQL += " and ifnull(StatusObj,'')<>'1' order by r.EnDt desc";*/
            String SQL = "Select r.CountryCode, r.FaciCode, r.RegisType, r.DataID, r.RegDate, r.RegTime, r.HospID, r.HospIDReTyp, r.Consent, r.StudyID, r.MotRegis, r.MotDataID, r.MotStudyID, r.MotStudyIDReType, r.MotHospID, r.MotName, r.MotDOB, r.MotDOBDK, r.MotAge, r.MotEdu, r.MotEduDK, r.Parity, r.MotEthnicity, r.MotEthnicityOth, r.MotReligion, r.MotReligionOth, r.Address1, r.Address2, r.Address3, r.Address4, r.AddressDetail, r.MotContact, r.AltContact, r.NameNewBorn, r.DOBNewborn, r.DOBNewbornDK, r.TOBNewborn, r.TOBNewbornDK, r.AgeNewborn, r.AgeNewbornDMY, r.Sex, r.FatherName, r.CompleteAdd, r.CompleteStatus, r.ObjPause, r.ObserverId, r.StatusObj, r.StatusRS, r.StatusDE, r.StatusACS, r.StatusINFXN, r.SelectPat,d.UserId, d.UserName, d.JobType, d.Active,ifnull(o.ObservDT,'')as deldt from Registration r ";
            SQL += " left outer join DataCollector d on r.ObserverId=d.UserId";
            SQL += " left outer join Observation o on r.CountryCode=o.CountryCode and r.FaciCode=o.FaciCode and r.DataID=o.DataID and VarName='BabyDel' and SL='1'";
            SQL += " Where r.CountryCode='"+ COUNTRYCODE +"' and r.FaciCode='"+ FACICODE +"' and r.Consent='1' and r.RegisType='"+ Loc +"'";
            SQL += " and ifnull(StatusObj,'')<>'1' order by r.EnDt desc";

            List<Registration_DataModel> data = d.SelectAll_Assign(this, SQL);
            dataList.clear();
            dataAdapter = null;

            ListView list = (ListView)dialog.findViewById(R.id.lstData);


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

            dataAdapter = new SimpleAdapter(MainActivity.this, dataList, R.layout.trac_ld_patient_list,new String[] {"rowsec"},
                    new int[] {R.id.secRow});

        }
        catch(Exception  e)
        {
            Connection.MessageBox(MainActivity.this, e.getMessage());
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
            patientAge1.setText(o.get("patage")); //+ ", DOB: "+ Global.DateConvertDMY(o.get("patdob")));
            patientAddress1.setText(o.get("mainaddress"));
            txtDelDate.setText("Delivery DT: "+ Global.DateConvertDMY(o.get("deldt")));

            if(o.get("objname")!=null) {
                txtObserver.setVisibility(View.VISIBLE);
                txtObserver.setText("Observer: " + o.get("objname"));
            }else{
                txtObserver.setVisibility(View.GONE);
            }


            chkSelect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(chkSelect.isChecked()){
                        C.SaveDT("Update Registration set SelectPat='1' where CountryCode='"+ o.get("countrycode") +"' and FaciCode='"+ o.get("facicode") +"' and DataID='"+ o.get("dataid") +"'");
                        //o.put("select","1");
                        //PatientListDataAdapter(ProjectSetting.LABOR_AND_DELIVERY_ID);
                        PatientListDataAdapter(ProjectSetting.LABOR_AND_DELIVERY_ID);
                        dataAdap = dataAdapter;
                        dataAdap.notifyDataSetChanged();
                        DataIdList.add(o.get("dataid"));
                        secRow.setBackgroundColor(Color.GREEN);
                    }else{
                        C.SaveDT("Update Registration set SelectPat='2' where CountryCode='"+ o.get("countrycode") +"' and FaciCode='"+ o.get("facicode") +"' and DataID='"+ o.get("dataid") +"'");
                        //o.put("select","2");
                        //PatientListDataAdapter(ProjectSetting.LABOR_AND_DELIVERY_ID);
                        PatientListDataAdapter(ProjectSetting.LABOR_AND_DELIVERY_ID);
                        dataAdap = dataAdapter;
                        dataAdap.notifyDataSetChanged();
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
}
