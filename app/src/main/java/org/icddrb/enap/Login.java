package org.icddrb.enap;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import Common.Connection;
import Common.Global;
import Common.ProjectSetting;
import Utility.MySharedPreferences;

public class Login extends Activity {
    public static final int DIALOG_DOWNLOAD_PROGRESS = 0;
    Connection C;
    Global g;
    boolean networkAvailable = false;
    int count = 0;
    TextView lblStaffType;
    String   SystemUpdateDT="";
    private ProgressDialog dialog;
    private  String Password="";
    MySharedPreferences sp;
    TextView Country;
    TextView Facility;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.login);
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

            C = new Connection(this);
            g = Global.getInstance();
            sp = new MySharedPreferences();
            sp.save(this,"deviceid","");
            sp.save(this,"userid","");

            TextView lblProjectTitle = (TextView)findViewById(R.id.lblProjectTitle);
            if(ProjectSetting.ProjectTitle.length()==0){
                lblProjectTitle.setVisibility(View.GONE);
            }else{
                lblProjectTitle.setVisibility(View.VISIBLE);
                lblProjectTitle.setText(ProjectSetting.ProjectTitle);
            }

            final TextView UniqueUserId      = (TextView)findViewById(R.id.UniqueUserId);
            final EditText uid      = (EditText)findViewById(R.id.userid);
            final EditText pass    = (EditText)findViewById(R.id.pass);
            TextView lblSystemDate = (TextView)findViewById(R.id.lblSystemDate);
            Country = (TextView)findViewById(R.id.Country);
            Facility = (TextView)findViewById(R.id.Facility);

            //Need to update date every time whenever shared updated system
            //*********************************************************************
            SystemUpdateDT = ProjectSetting.VersionDate;
            lblSystemDate.setText("Version: 1.0, Built on: "+ SystemUpdateDT);

            //Check for Internet connectivity
            networkAvailable = Connection.haveNetworkConnection(Login.this);

            //Rebuild Database
            String TotalTab = C.ReturnSingleValue("SELECT count(*) FROM sqlite_master WHERE type = 'table' AND name != 'android_metadata' AND name != 'sqlite_sequence'");

            if(Integer.valueOf(TotalTab) == 0)
            {
                if (networkAvailable)
                {
                    //Call Setting Form
                    finish();
                    Intent f1 = new Intent(getApplicationContext(), SettingForm.class);
                    startActivity(f1);
                    return;
                }
                else
                {
                    Connection.MessageBox(Login.this,"Internet connection is not available for building initial database.");
                    return;
                }
            }

            //Device Unique ID
            final String UniqueID = C.ReturnSingleValue("Select DeviceId from DeviceList");
            sp.save(this,"deviceid",UniqueID);
            UniqueUserId.setText("Device ID : "+ UniqueID);

            String[] CC  = C.ReturnSingleValue("Select c.CountryCode||'-'||C.CountryName||'-'||f.FaciCode||'-'||f.FaciName from Country c,Facility f where c.CountryCode=f.CountryCode").split("-");
            String CCode = CC[0];
            String CName = CC[1];
            String FCode = CC[2];
            String FName = CC[3];
            sp.save(Login.this,"countrycode",CCode);
            sp.save(Login.this,"countryname",CName);
            sp.save(Login.this,"facicode",FCode);
            sp.save(Login.this,"faciname",FName);
            Facility.setText(FName);

            if(ProjectSetting.apiName.equals("enap_dev")) {
                //Country.setText(CName + " - Development");
                Country.setText("Development");
                Country.setTextColor(Color.RED);
            }
            else {
                if(ProjectSetting.Country.equals(ProjectSetting.BANGLADESH))
                    Country.setText(ProjectSetting.COUNTRY_NAME_BANGLADESH);
                else if(ProjectSetting.Country.equals(ProjectSetting.NEPAL))
                    Country.setText(ProjectSetting.COUNTRY_NAME_Nepal);
                else if(ProjectSetting.Country.equals(ProjectSetting.TANZANIA))
                    Country.setText(ProjectSetting.COUNTRY_NAME_Tanzania);
            }

            //**************************************************************************************
            if (networkAvailable)
            {
                //C.Sync_Download("DataCollector", UniqueID, "CountryCode='"+ CCode +"' and FaciCode='"+ FCode +"'");
                Intent syncService = new Intent(this, Sync_Service.class);
                startService(syncService);
            }
            //**************************************************************************************
            String[] Access = Connection.DCLocationAccess(sp.getValue(this, "userid"));

            //uid.setAdapter(C.getArrayAdapter("select UserId||'-'||UserName User from DataCollector order by UserName"));
            //String[] CL = uid.getSelectedItem().toString().split("-");
            //uid.setSelection(Global.SpinnerItemPosition(uid,CL[0].length(),C.ReturnSingleValue("Select UserId from LastLogin")));
            uid.setText(C.ReturnSingleValue("Select UserId from LastLogin"));

            //Only for removing the data of training: 17 Nov 2015
            /*if(Global.DateNowDMY().equals("11/02/2016") & g.getDistrict().equals("12") & g.getUpazila().equals("63"))
            {
                //C.Save("Delete from BirthDeath where date(endt) <= '2016-02-10'");
            }*/


            //Execute Specific Process
            try {
                C.CreateTable("process_tab", "Create table process_tab(process_id int)");
                if (ProjectSetting.Country.equals(ProjectSetting.NEPAL) & !C.Existence("Select * from process_tab where process_id=1")) {
                    String resp = C.SaveData("Update Registration set Upload='2' where DeviceId='203' and DataId in('203002978','203002979','203002980','203002981','203002982','203002983')");
                    if (resp.length() == 0) {
                        String r = C.SaveData("Insert into process_tab(process_id)values(1)");
                    }
                }
            }catch (Exception ex){

            }


            Button btnClose=(Button)findViewById(R.id.btnClose);
            btnClose.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    finish();
                    System.exit(0);
                }
            });

            //Login -----------------------------------------------------------------------
            Button loginButton = (Button) findViewById(R.id.btnLogin);
            loginButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    try
                    {
                        String UID = uid.getText().toString();
                        if (!C.Existence("Select * from DataCollector where UserId='" + UID + "' and Pass='" + pass.getText().toString() + "'"))
                        {
                            Connection.MessageBox(Login.this,"This is not a valid user id or password");
                            return;
                        }

                        //Need JobType and Location
                        String SQL = "";
                        String jobloc = "";
                        String jt = "";
                        String jl = "";

                        SQL = "Select JobType from DataCollector where UserId='"+ UID +"'";
                        jt = C.ReturnSingleValue(SQL);
                        sp.save(Login.this,"jobtype", jt.toString());
                        sp.save(Login.this,"userid", UID);

                        /*SQL = "Select d.JobType||'-'||l.LocCode from DataCollector d";
                        SQL += " Left outer join LocationDC l on d.facicode=l.facicode and d.userid=l.userid";
                        SQL += " where d.UserId='"+ UID +"' and l.Active='1'";

                        SQL = "Select JobType from DataCollector where UserId='"+ UID +"'";

                        List<String> userAccess = new ArrayList<String>();
                        userAccess = C.getDataList(SQL);

                        for(int i=0; i< userAccess.size(); i++) {
                            jt = userAccess.get(i).split("-")[0];
                            jl = userAccess.get(i).split("-")[1];
                            jobloc += jobloc.length()==0?jl:","+jl;
                        }
                        sp.save(Login.this,"jobtype", jt.toString());
                        sp.save(Login.this,"jobloc", jobloc.toString());*/


                        //Store Last Login information
                        C.SaveDT("Delete from LastLogin");
                        C.SaveDT("Insert into LastLogin(UserId)Values('"+ UID +"')");

                        //Download Updated System
                        //...................................................................................
                        if (networkAvailable == true)
                        {
                            //Retrieve data from server for checking local device
                            String[] ServerVal  = Connection.split(C.ReturnResult("ReturnSingleValue","sp_ServerCheck '"+ UniqueID +"'"),',');
                            String ServerDate   = ServerVal[0].toString();
                            String UpdateDT     = ServerVal[1].toString();

                            //Check for New Version
                            if (!UpdateDT.equals(SystemUpdateDT)) {
                                SystemDownload d = new SystemDownload();
                                d.setContext(getApplicationContext());
                                d.execute(Global.UpdatedSystem);
                            }
                            else
                            {
                                //check for system date
                                /*if(ServerDate.equals(Global.TodaysDateforCheck())==false)
                                {
                                    Connection.MessageBox(Login.this, "আপনার ট্যাব এর তারিখ সঠিক নয় ["+ Global.DateNowDMY() +"]।");
                                    startActivity(new Intent(android.provider.Settings.ACTION_DATE_SETTINGS));
                                    return;
                                }*/

                                final ProgressDialog progDailog = ProgressDialog.show(Login.this, "", "Please Wait . . .", true);

                                new Thread() {
                                    public void run() {
                                        try {
                                            finish();
                                            Intent f1 = new Intent(getApplicationContext(),MainActivity.class);
                                            startActivity(f1);
                                        } catch (Exception e) {

                                        }
                                        progDailog.dismiss();
                                    }
                                }.start();
                            }
                        }
                        else
                        {
                            final ProgressDialog progDailog = ProgressDialog.show(Login.this, "", "Please Wait . . .", true);

                            new Thread() {
                                public void run() {
                                    try {
                                        finish();
                                        Intent f1 = new Intent(getApplicationContext(),MainActivity.class);
                                        startActivity(f1);
                                    } catch (Exception e) {

                                    }
                                    progDailog.dismiss();
                                }
                            }.start();
                        }
                    }
                    catch(Exception ex)
                    {
                        //Connection.MessageBox(LoginActivity.this, ex.getMessage());
                        //return;
                        final ProgressDialog progDailog = ProgressDialog.show(Login.this, "", "Please Wait . . .", true);

                        new Thread() {
                            public void run() {
                                try {
                                    finish();
                                    Intent f1 = new Intent(getApplicationContext(),MainActivity.class);
                                    startActivity(f1);
                                } catch (Exception e) {

                                }
                                progDailog.dismiss();
                            }
                        }.start();
                    }
                }
            });
        }
        catch(Exception ex)
        {
            Connection.MessageBox(Login.this, ex.getMessage());
        }
    }

    //Install application
    private void InstallApplication()
    {
        File apkfile = new File(Environment.getExternalStorageDirectory() + File.separator + ProjectSetting.NewVersionName +".apk");
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // without this flag android returned a intent error!
        intent.setDataAndType(Uri.parse("file://" + apkfile.toString()), "application/vnd.android.package-archive");

        startActivity(intent);
    }

    //Downloading updated system from the central server
    class SystemDownload extends AsyncTask<String, String, Void> {
        private Context context;

        public void setContext(Context contextf){
            context = contextf;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(Login.this);
            dialog.setMessage("Downloading Updated System...");
            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialog.setCancelable(false);
            dialog.show();
        }


        protected void onProgressUpdate(String... progress) {
            dialog.setProgress(Integer.parseInt(progress[0]));
            //publishProgress(progress);

        }

        //@Override
        protected void onPostExecute(String unused) {
            dialog.dismiss();
        }


        @Override
        protected Void doInBackground(String... arg0) {
            try {
                URL url = new URL(arg0[0]);
                HttpURLConnection c = (HttpURLConnection) url.openConnection();
                c.setRequestMethod("GET");
                c.connect();
                int lenghtOfFile = c.getContentLength();

                File file=Environment.getExternalStorageDirectory();

                file.mkdirs();
                File outputFile = new File(file.getAbsolutePath()+ File.separator + ProjectSetting.NewVersionName +".apk");

                if(outputFile.exists()){
                    outputFile.delete();
                }
                else
                {
                    outputFile.createNewFile();
                }

                FileOutputStream fos = new FileOutputStream(outputFile);

                InputStream is = c.getInputStream();


                byte[] buffer = new byte[1024];
                int len1 = 0;
                long total = 0;
                while ((len1 = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, len1);
                    count++;
                }
                fos.close();
                is.close();


                InstallApplication();

                dialog.dismiss();

            } catch (IOException e) {
                //Log.e("UpdateAPP", "Update error! " + e.getMessage());
            }
            return null;
        }
    }

}

