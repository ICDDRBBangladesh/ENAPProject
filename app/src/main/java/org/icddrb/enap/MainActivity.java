package org.icddrb.enap;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import Common.Connection;
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
    static String LOCATIONID  = "";

    //-------------------------
    static String JOBTYPE     = "";
    static String JOBLOCATION = "";

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
        JOBLOCATION = sp.getValue(this, "jobloc");

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
        Button cmdRegistration = (Button) findViewById(R.id.cmdRegistration);
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

        //Observation
        //------------------------------------------------------------------------------------------
        //Labour and delivery
        Button cmdLDObj = (Button) findViewById(R.id.cmdLDObj);
        cmdLDObj.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //finish();
                Bundle b = new Bundle();
                b.putString("location","2"); //labour and delivery
                b.putString("role","2"); //Observation
                Intent f1 = new Intent(getApplicationContext(),PatientList.class);
                f1.putExtras(b);
                startActivity(f1);
            }
        });

        //kmc
        Button cmdKMCObj = (Button) findViewById(R.id.cmdKMCObj);
        cmdKMCObj.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //finish();
                Bundle b = new Bundle();
                b.putString("location","3"); //kmc
                b.putString("role","2"); //Observation
                Intent f1 = new Intent(getApplicationContext(),PatientList.class);
                f1.putExtras(b);
                startActivity(f1);
            }
        });

        //Exit Interview
        //------------------------------------------------------------------------------------------
        //Maternal Recall
        Button cmdMRecall = (Button) findViewById(R.id.cmdMRecall);
        cmdMRecall.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //finish();
                Bundle b = new Bundle();
                b.putString("location","2"); //labour and delivery
                b.putString("role","3"); //exit interview
                Intent f1 = new Intent(getApplicationContext(),PatientList.class);
                f1.putExtras(b);
                startActivity(f1);
            }
        });


        //Data Extraction
        //------------------------------------------------------------------------------------------
        //Labour and delivery
        Button cmdLDDataExt = (Button) findViewById(R.id.cmdLDDataExt);
        cmdLDDataExt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //finish();
                Bundle b = new Bundle();
                b.putString("location","2"); //labour and delivery
                b.putString("role","4"); //data extraction
                Intent f1 = new Intent(getApplicationContext(),PatientList.class);
                f1.putExtras(b);
                startActivity(f1);
            }
        });
        //kmc
        Button cmdKMCDataExt = (Button) findViewById(R.id.cmdKMCDataExt);
        cmdKMCDataExt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //finish();
                Bundle b = new Bundle();
                b.putString("location","3"); //kmc
                b.putString("role","4"); //data extraction
                Intent f1 = new Intent(getApplicationContext(),PatientList.class);
                f1.putExtras(b);
                startActivity(f1);
            }
        });


        //Verification
        //------------------------------------------------------------------------------------------
        //Sepsis
        Button cmdSepsis = (Button) findViewById(R.id.cmdSepsis);
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

        //ACS
        Button cmdACS = (Button) findViewById(R.id.cmdACS);
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


        Button cmdDataSync = (Button) findViewById(R.id.cmdDataSync);
        cmdDataSync.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (Connection.haveNetworkConnection(MainActivity.this)) {
                } else {
                    Connection.MessageBox(MainActivity.this,"Internet connection is not available for Data Sync.");
                    return;
                }

                AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
                adb.setTitle("Data Sync");
                adb.setMessage("Do you want to Sync Data[Yes/No]?");
                adb.setNegativeButton("No", null);
                adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //new DataSync().execute();

                        //C = new Connection(MainMenu.this);
                        final ProgressDialog progDailog = ProgressDialog.show(MainActivity.this, "", "Please Wait . . .", true);

                        new Thread() {
                            public void run() {
                                try {
                                    List<String> tableList = new ArrayList<String>();
                                    tableList.add("Registration");
                                    tableList.add("KmcPreObs");
                                    tableList.add("ObsHisCurPreg");
                                    tableList.add("Observation");
                                    tableList.add("LD_Outcome");

                                    C.Sync_Upload(tableList);

                                    C.Sync_Download("DataCollector",DEVICEID,"FaciCode='"+ FACICODE +"'");
                                    C.Sync_Download("LocationDC",DEVICEID,"FaciCode='"+ FACICODE +"'");
                                    C.Sync_Download("DCJobType",DEVICEID,"");
                                    C.Sync_Download("ObjTableList",DEVICEID,"");
                                    C.Sync_Download("ObjVarList",DEVICEID,"");

                                    C.Sync_Download("Registration",DEVICEID,"FaciCode='"+ FACICODE +"'");
                                    C.Sync_Download("KmcPreObs",DEVICEID,"FaciCode='"+ FACICODE +"'");
                                    C.Sync_Download("ObsHisCurPreg",DEVICEID,"FaciCode='"+ FACICODE +"'");

                                    C.Sync_Download("Observation",DEVICEID,"FaciCode='"+ FACICODE +"'");
                                    C.Sync_Download("LD_Outcome",DEVICEID,"FaciCode='"+ FACICODE +"'");

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

                                    SQL = "Select d.JobType||'-'||l.LocCode from DataCollector d";
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
                                    sp.save(MainActivity.this,"jobloc", jobloc.toString());

                                } catch (Exception e) {

                                }
                                progDailog.dismiss();
                            }
                        }.start();

                    }});
                adb.show();
            }
        });

        Button cmdExit = (Button)findViewById(R.id.cmdExit);
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

        Button cmdFollowup = (Button)findViewById(R.id.cmdFollowup);

        cmdRegistration.setVisibility(View.GONE);
        cmdLDObj.setVisibility(View.GONE);
        cmdKMCObj.setVisibility(View.GONE);
        cmdMRecall.setVisibility(View.GONE);
        cmdLDDataExt.setVisibility(View.GONE);
        cmdKMCDataExt.setVisibility(View.GONE);
        cmdSepsis.setVisibility(View.GONE);
        cmdACS.setVisibility(View.GONE);
        cmdFollowup.setVisibility(View.GONE);

        if(JOBTYPE.equals(ProjectSetting.JT_REGISTRATION)){
            cmdRegistration.setVisibility(View.VISIBLE);
        }else if(JOBTYPE.equals(ProjectSetting.JT_OBSERVATION)){
            cmdLDObj.setVisibility(View.VISIBLE);
            cmdKMCObj.setVisibility(View.VISIBLE);
        }else if(JOBTYPE.equals(ProjectSetting.JT_EXIT_INTERVIEW)){
            cmdMRecall.setVisibility(View.VISIBLE);
            cmdLDDataExt.setVisibility(View.VISIBLE);
            cmdKMCDataExt.setVisibility(View.VISIBLE);
            cmdSepsis.setVisibility(View.VISIBLE);
            cmdACS.setVisibility(View.VISIBLE);
            cmdFollowup.setVisibility(View.VISIBLE);
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
            // Handle the camera action
        } else if (id == R.id.nav_Exit) {

        }

        /*else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {
        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
