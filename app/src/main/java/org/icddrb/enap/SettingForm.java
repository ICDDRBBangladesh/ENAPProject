package org.icddrb.enap;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Common.Connection;
import Common.Global;
import Common.ProjectSetting;


public class SettingForm extends Activity {
    Connection C;
    Global g;
    static String COUNTRYCODE = "";
    static String DeviceID    = "";
    static String FACOCODE    = "";
    TextView lblTitle;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            setContentView(R.layout.devicesetting);
            C = new Connection(this);
            g = Global.getInstance();

            if (!Connection.haveNetworkConnection(SettingForm.this)) {
                Connection.MessageBox(SettingForm.this, "Inernet connection is not available for device setting.");
                return;
            }

            lblTitle = (TextView)findViewById(R.id.lblTitle);
            lblTitle.setTextColor(Color.parseColor("#006699"));

            final Spinner spnCountry = (Spinner)findViewById(R.id.spnCountry);
            final Spinner spnFacility = (Spinner)findViewById(R.id.spnFacility);
            SpinnerItem(spnCountry, "select CountryCode+'-'+CountryName from Country where CountryCode='"+ ProjectSetting.Country +"' order by CountryCode");
            spnCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                    String[] C = spnCountry.getSelectedItem().toString().split("-");
                    SpinnerItem(spnFacility, "select FaciCode+'-'+FaciName from Facility where CountryCode='"+ C[0] +"' order by FaciCode");
                }

                @Override
                public void onNothingSelected(AdapterView<?> parentView) {
                    // your code here
                }

            });




            final Spinner spnUser = (Spinner)findViewById(R.id.spnUser);
            SpinnerItem(spnUser, "select DeviceId+'-'+DeviceName from DeviceList order by DeviceId");

            Button cmdSave = (Button)findViewById(R.id.cmdSave);
            cmdSave.setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0) {
                    try {
                        String SQLStr   = "";

                        String[] Country = spnCountry.getSelectedItem().toString().split("-");
                        COUNTRYCODE = Country[0];

                        String[] User = spnUser.getSelectedItem().toString().split("-");
                        DeviceID = User[0];

                        String[] FCode = spnFacility.getSelectedItem().toString().split("-");
                        FACOCODE = FCode[0];

                        String Setting = C.ReturnResult("Existence", "Select DeviceId from DeviceList where DeviceId='"+ Connection.SelectedSpinnerValue(spnUser.getSelectedItem().toString(),"-") +"' and Setting='1'");
                        if (Setting.equals("2")) {
                            Connection.MessageBox(SettingForm.this, "Device ID :"+ spnUser.getSelectedItem().toString() +" is not allowed to configure a mobile device, contact with administrator.");
                            return;
                        }

                        String ResponseString="Status:";

                        final ProgressDialog progDailog = ProgressDialog.show(SettingForm.this, "", "Please Wait . . .", true);

                        new Thread() {
                            public void run() {
                                try {
                                    C.RebuildDatabase(COUNTRYCODE, FACOCODE, DeviceID);
                                } catch (Exception e) {

                                }
                                progDailog.dismiss();

                                //Call Login Form
                                finish();
                                Intent f1 = new Intent(getApplicationContext(), Login.class);
                                startActivity(f1);

                            }
                        }.start();
                    }
                    catch(Exception ex)
                    {
                        Connection.MessageBox(SettingForm.this, ex.getMessage());
                        return;
                    }
                }
            });
        }
        catch(Exception ex)
        {
            Connection.MessageBox(SettingForm.this, ex.getMessage());
            return;
        }
    }

    private void SpinnerItem(Spinner SpinnerName, String SQL)
    {
        List<String> listItem = new ArrayList<String>();
        listItem = C.DataListJSON(SQL);
        ArrayAdapter<String> adptrList= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listItem);
        SpinnerName.setAdapter(adptrList);
    }
}