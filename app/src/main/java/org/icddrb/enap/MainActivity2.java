package org.icddrb.enap;

import android.app.AlertDialog;
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
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Common.Connection;
import Common.Global;
import Common.ProjectSetting;
import Utility.MySharedPreferences;

public class MainActivity2 extends AppCompatActivity
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
        //Sepsis
        cmdSepsis = (Button) findViewById(R.id.cmdSepsis);
        cmdSepsis.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //finish();
                Bundle b = new Bundle();
                b.putString("location","4"); //Sepsis
                b.putString("role","4"); //Verification
                Intent f1 = new Intent(getApplicationContext(),PatientList.class);
                f1.putExtras(b);
                startActivity(f1);
            }
        });

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


        cmdDataSync = (Button) findViewById(R.id.cmdDataSync);
        cmdDataSync.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (Connection.haveNetworkConnection(MainActivity2.this)) {
                } else {
                    Connection.MessageBox(MainActivity2.this,"Internet connection is not available for Data Sync.");
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
                AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity2.this);
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

                            /*//Upload
                            List<String> tableList = new ArrayList<String>();
                            tableList.add("Registration");
                            tableList.add("ObsHisCurPreg");
                            tableList.add("KmcPreObs");

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
                            C.Sync_Upload(tableList);


                            //Download
                            C.Sync_Download("DataCollector",DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");
                            C.Sync_Download("DCJobType",   DEVICEID,"");
                            C.Sync_Download("ObjTableList",DEVICEID,"");
                            C.Sync_Download("ObjVarList",  DEVICEID,"");

                            C.Sync_Download("Registration", DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");
                            C.Sync_Download("KmcPreObs",    DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");
                            C.Sync_Download("ObsHisCurPreg",DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");

                            C.Sync_Download("Observation",DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");
                            C.Sync_Download("LD_Outcome", DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");
                            C.Sync_Download("ObjPauseLog", DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");

                            C.Sync_Download("KMC_Init", DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");
                            C.Sync_Download("KMC_Pos",  DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");
                            C.Sync_Download("KMC_Feed", DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");
                            C.Sync_Download("KMC_Treat",DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");
                            C.Sync_Download("KMC_Outcome",DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");

                            C.Sync_Download("KMC_DataExt",DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");
                            C.Sync_Download("LD_DataExt",DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");

                            C.Sync_Download("RecallSurvS1",DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");
                            C.Sync_Download("RecallSurvS2",DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");
                            C.Sync_Download("RecallSurvS3",DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");
                            C.Sync_Download("RecallSurvS4",DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");
                            C.Sync_Download("RecallSurvS5",DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");
                            C.Sync_Download("MRS_FinalStatus",DEVICEID,"CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"'");
*/
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
                            sp.save(MainActivity2.this,"jobtype", jt.toString());
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
            dialog = new ProgressDialog(MainActivity2.this);
            dialog.setMessage("Data Sync in Progress, Please wait ...");
            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialog.setCancelable(false);
            dialog.show();
        }

        //@Override
        protected void onProgressUpdate(String... values) {
            //super.onProgressUpdate(values);
            dialog.setProgress(Integer.parseInt(values[0]));
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
                            resp = Connection.DataSync(COUNTRYCODE, FACICODE, DEVICEID, ENTRYUSER);
                            //dialog.dismiss();
                            if(resp.equals("done")) {
                                //Toast.makeText(MainActivity.this, "Data Sync successfully completed.",Toast.LENGTH_LONG).show();
                                //Connection.MessageBox(MainActivity.this, "Data Sync successfully completed.");
                                dialog.dismiss();

                            }else{
                                //Toast.makeText(MainActivity.this, resp,Toast.LENGTH_LONG).show();
                                dialog.dismiss();
                            }
                        } catch (Exception e) {
                            resp = e.getMessage();
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
                Connection.MessageBox(MainActivity2.this, "Data Sync successfully completed.");
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
        }else if(JOBTYPE.equals(ProjectSetting.JT_DATA_EXTRACTION)){
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
            DataSync(MainActivity2.this);

        } else if (id == R.id.nav_Exit) {
            AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity2.this);
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
            dialog = new Dialog(MainActivity2.this);
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
                        Connection.MessageBox(MainActivity2.this,"Select observer name from the list.");
                        return;
                    }
                    AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity2.this);
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

                            Connection.RegistrationDataSync(MainActivity2.this);
                            if(rdoLocation1.isChecked())
                                PatientList(ProjectSetting.LABOR_AND_DELIVERY_ID);
                            else if(rdoLocation2.isChecked())
                                PatientList(ProjectSetting.KMC_ID);

                            dialog.dismiss();
                        }});
                    adb.show();


                }
            });




            //recyclerView.setHasFixedSize(true);
            //RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
            //recyclerView.setLayoutManager(mLayoutManager);
            //recyclerView.addItemDecoration(new MainActivity2.DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
            //recyclerView.setItemAnimator(new DefaultItemAnimator());
            //recyclerView.setAdapter(mAdapter);

            //PatientList(ProjectSetting.LABOR_AND_DELIVERY_ID);
            preparePatientList(ProjectSetting.LABOR_AND_DELIVERY_ID);

            RadioGroup rdogrpLocation = (RadioGroup) dialog.findViewById(R.id.rdogrpLocation);
            rdogrpLocation.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
            {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId)
                {
                    switch(checkedId)
                    {
                        case R.id.rdoLocation1:
                            preparePatientList(ProjectSetting.LABOR_AND_DELIVERY_ID);
                            break;
                        case R.id.rdoLocation2:
                            preparePatientList(ProjectSetting.KMC_ID);
                            break;
                    }
                }
            });


            dialog.show();
        } catch (Exception e) {
            Connection.MessageBox(MainActivity2.this, e.getMessage());
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
            String SQL = "Select * from Registration r ";
            SQL += " left outer join DataCollector d on r.ObserverId=d.UserId";
            SQL += " Where r.CountryCode='"+ COUNTRYCODE +"' and r.FaciCode='"+ FACICODE +"' and r.Consent='1' and r.RegisType='"+ Loc +"'";
            SQL += " and ifnull(StatusObj,'')<>'1' order by r.EnDt desc";

            List<Registration_DataModel> data = d.SelectAll_Assign(this, SQL);
            dataList.clear();
            dataAdapter = null;

            ListView list = (ListView)dialog.findViewById(R.id.lstData);


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
                map.put("objname", item.getObserverName());
                map.put("sl",String.valueOf(i));
                map.put("select","2");

                i+=1;
                dataList.add(map);
            }

            dataAdapter = new SimpleAdapter(MainActivity2.this, dataList, R.layout.trac_ld_patient_list,new String[] {"rowsec"},
                    new int[] {R.id.secRow});
            list.setAdapter(new MainActivity2.DataListAdapter(this, dataAdapter));

        }
        catch(Exception  e)
        {
            Connection.MessageBox(MainActivity2.this, e.getMessage());
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

            final CheckBox chkSelect = (CheckBox) convertView.findViewById(R.id.chkSelect);

            final HashMap<String, String> o = (HashMap<String, String>) dataAdap.getItem(position);
            studyId1.setText(o.get("studyid"));
            hospitalId1.setText(o.get("hospitalid"));
            patientName1.setText(o.get("patname"));
            patientAge1.setText(o.get("patage"));
            patientAddress1.setText(o.get("mainaddress"));
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
                        map.put("select","1");
                        dataAdapter.notifyDataSetChanged();

                        DataIdList.add(o.get("dataid"));
                        secRow.setBackgroundColor(Color.GREEN);
                    }else{
                        map.put("select","2");
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
                secRow.setBackgroundColor(Color.GREEN);
            }else{
                secRow.setBackgroundColor(Color.parseColor("#FFFFFF"));
            }


            return convertView;
        }
    }

    //Recycle View
    //**********************************************************************************************
    private List<MainActivity2.Patient> patientList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MainActivity2.MoviesAdapter mAdapter;

    private void preparePatientList(String Loc) {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new MainActivity2.MoviesAdapter(patientList);

        Registration_DataModel d = new Registration_DataModel();
        String SQL = "Select * from Registration r ";
        SQL += " left outer join DataCollector d on r.ObserverId=d.UserId";
        SQL += " Where r.CountryCode='"+ COUNTRYCODE +"' and r.FaciCode='"+ FACICODE +"' and r.Consent='1' and r.RegisType='"+ Loc +"'";
        SQL += " and ifnull(StatusObj,'')<>'1' order by r.EnDt desc";

        List<Registration_DataModel> data = d.SelectAll_Assign(this, SQL);

        patientList.clear();
        int count = 0;
        for(Registration_DataModel item : data){
            //Movie movie = new Movie(String.valueOf(count)+": "+ item.getpatName(), item.getPatAge(), item.getDataID());
            //movieList.add(movie);

            MainActivity2.Patient p = new MainActivity2.Patient();
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
            p.setObjName(item.getObserverName());
            p.setSL(String.valueOf(count));
            p.setSelect("2");

            count +=1;

            patientList.add(p);
        }

        recyclerView.setAdapter(mAdapter);
        //mAdapter.notifyDataSetChanged();
    }

    public class MoviesAdapter extends RecyclerView.Adapter<MainActivity2.MoviesAdapter.MyViewHolder> {

        private List<MainActivity2.Patient> patientList;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            //public TextView title, year, genre;
            public TextView studyId,hospitalId,patientName,patientAge,patientAddress;
            public CheckBox chkSelect;
            public RelativeLayout secRow;
            //public ImageView imgPatient;

            public MyViewHolder(View view) {
                super(view);
                secRow = (RelativeLayout) view.findViewById(R.id.secRow);
                studyId = (TextView) view.findViewById(R.id.txtStudyID);
                hospitalId = (TextView) view.findViewById(R.id.txtHospID);
                patientName = (TextView) view.findViewById(R.id.txtName);
                patientAge = (TextView) view.findViewById(R.id.txtAge);
                patientAddress = (TextView) view.findViewById(R.id.txtAddress);
                chkSelect = (CheckBox) view.findViewById(R.id.chkSelect);
            }
        }


        public MoviesAdapter(List<MainActivity2.Patient> patientlist) {
            this.patientList = patientlist;
        }

        @Override
        public MainActivity2.MoviesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.trac_ld_patient_list_row, parent, false);

            return new MainActivity2.MoviesAdapter.MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MainActivity2.MoviesAdapter.MyViewHolder holder, int position) {
            final MainActivity2.Patient patient = patientList.get(position);
            holder.studyId.setText(patient.getStudyID());
            holder.hospitalId.setText(patient.getHospitalID());

            holder.patientName.setText(patient.getpatName());
            //holder.patientAge.setText(patient.getPatAge() + (patient.getLocation().equals(ProjectSetting.LABOR_AND_DELIVERY_ID)?"": "   "+ patient.getPatSex()));
            holder.patientAddress.setText(patient.getMainAddress());


            /*if(Integer.valueOf(patient.getSerial())%2==0){
                holder.secRow.setBackgroundColor(Color.parseColor("#FFFFFF"));
            }else
            {
                holder.secRow.setBackgroundColor(Color.parseColor("#F3F3F3"));
            }*/



            //Time stamping variable
            holder.chkSelect.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    /*Bundle IDbundle = new Bundle();
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
                    startActivity(intent);
                    //getApplicationContext().startActivity(intent);*/
                }
            });




            holder.secRow.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    //Write your code here
                    /*Bundle IDbundle = new Bundle();
                    IDbundle.putString("locationid", patient.getLocation());
                    IDbundle.putString("dataid", patient.getDataID());
                    Intent intent = new Intent(getApplicationContext(), Registration.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtras(IDbundle);
                    getApplicationContext().startActivity(intent);*/
                }
            });

        }

        @Override
        public int getItemCount() {
            return patientList.size();
        }
    }

    public class Patient {

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

        private String _StudyID = "";
        public String getStudyID(){
            return _StudyID;
        }
        public void setStudyID(String newValue){
            _StudyID = newValue;
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
        private String _PatAgeDMY = "";
        public String getPatAgeDMY(){
            return _PatAgeDMY;
        }
        public void setPatAgeDMY(String newValue){
            _PatAgeDMY = newValue;
        }

        private String _PatSex = "";
        public String getPatSex(){
            return _PatSex;
        }
        public void setPatSex(String newValue){
            _PatSex = newValue;
        }

        private String _PatDOB = "";
        public String getPatDOB(){
            return _PatDOB;
        }
        public void setPatDOB(String newValue){
            _PatDOB = newValue;
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

        private String _MainAddress = "";
        public String getMainAddress(){
            return _MainAddress;
        }
        public void setMainAddress(String newValue){
            _MainAddress = newValue;
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

        private String _ObjName = "";
        public String getObjName(){
            return _ObjName;
        }
        public void setObjName(String newValue){
            _ObjName = newValue;
        }

        private String _SL = "";
        public String getSL(){
            return _SL;
        }
        public void setSL(String newValue){
            _SL = newValue;
        }

        private String _Select = "2";
        public String getSelect(){
            return _Select;
        }
        public void setSelect(String newValue){
            _Select = newValue;
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
        private MainActivity2.RecyclerTouchListener.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final MainActivity2.RecyclerTouchListener.ClickListener clickListener) {
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


}
