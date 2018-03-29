
 package org.icddrb.enap;


 //Android Manifest Code
 //<activity android:name=".MRS_FinalStatus" android:label="MRS_FinalStatus" />
 import java.text.ParseException;
 import java.text.SimpleDateFormat;
 import java.util.ArrayList;
 import java.util.Calendar;
 import java.util.Date;
 import java.util.HashMap;
 import java.util.List;
 import android.app.*;
 import android.app.AlertDialog;
 import android.app.DatePickerDialog;
 import android.app.Dialog;
 import android.app.TimePickerDialog;
 import android.content.Context;
 import android.content.DialogInterface;
 import android.content.Intent;
 import android.database.Cursor;
 import android.location.Location;
 import android.location.LocationListener;
 import android.location.LocationManager;
 import android.net.Uri;
 import android.provider.Settings;
 import android.view.KeyEvent;
 import android.os.Bundle;
 import android.view.Menu;
 import android.view.MenuInflater;
 import android.view.MenuItem;
 import android.view.View;
 import android.view.MotionEvent;
 import android.view.View.OnFocusChangeListener;
 import android.view.ViewGroup;
 import android.view.LayoutInflater;
 import android.widget.AdapterView;
 import android.widget.Button;
 import android.widget.CheckBox;
 import android.widget.DatePicker;
 import android.widget.EditText;
 import android.widget.ImageButton;
 import android.widget.LinearLayout;
 import android.widget.RadioButton;
 import android.widget.RadioGroup;
 import android.widget.ListView;
 import android.widget.SimpleAdapter;
 import android.widget.BaseAdapter;
 import android.widget.Spinner;
 import android.widget.TextView;
 import android.widget.TimePicker;
 import android.widget.ArrayAdapter;
 import android.widget.CompoundButton;
 import android.graphics.Color;
 import Utility.*;
 import Common.*;

 public class MRS_FinalStatus extends Activity {
    boolean networkAvailable=false;
    Location currentLocation; 
    double currentLatitude,currentLongitude; 
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

    Connection C;
    Global g;
    SimpleAdapter dataAdapter;
    ArrayList<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();
         TextView lblHeading;
         LinearLayout secCountryCode;
         View lineCountryCode;
         TextView VlblCountryCode;
         EditText txtCountryCode;
         LinearLayout secFaciCode;
         View lineFaciCode;
         TextView VlblFaciCode;
         EditText txtFaciCode;
         LinearLayout secDataID;
         View lineDataID;
         TextView VlblDataID;
         EditText txtDataID;
         LinearLayout secstatus;
         View linestatus;
         TextView Vlblstatus;
         RadioGroup rdogrpstatus;
         
         RadioButton rdostatus1;
         RadioButton rdostatus2;
         RadioButton rdostatus3;
         LinearLayout secreason;
         View linereason;
         TextView Vlblreason;
         RadioGroup rdogrpreason;
         
         RadioButton rdoreason1;
         RadioButton rdoreason2;
         RadioButton rdoreason3;
         RadioButton rdoreason4;
         LinearLayout secreasmention;
         View linereasmention;
         TextView Vlblreasmention;
         EditText txtreasmention;

    static String TableName;

    static String STARTTIME = "";
    static String DEVICEID  = "";
    static String ENTRYUSER = "";
    MySharedPreferences sp;

    Bundle IDbundle;
    static String COUNTRYCODE = "";
    static String FACICODE = "";
    static String DATAID = "";

 public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
   try
     {
         setContentView(R.layout.mrs_finalstatus);
         C = new Connection(this);
         g = Global.getInstance();

         STARTTIME = g.CurrentTime24();
         DEVICEID  = sp.getValue(this, "deviceid");
         ENTRYUSER = sp.getValue(this, "userid");

         IDbundle = getIntent().getExtras();
         COUNTRYCODE = sp.getValue(this, "countrycode");
         FACICODE    = sp.getValue(this, "facicode");
         DATAID = IDbundle.getString("dataid");
         //STUDYID = IDbundle.getString("studyid");

         TableName = "MRS_FinalStatus";

         //turnGPSOn();

         //GPS Location
         //FindLocation();
         // Double.toString(currentLatitude);
         // Double.toString(currentLongitude);
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(MRS_FinalStatus.this);
                 adb.setTitle("Close");
                 adb.setMessage("Do you want to close this form[Yes/No]?");
                 adb.setNegativeButton("No", null);
                 adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                     public void onClick(DialogInterface dialog, int which) {
                         finish();
                     }});
                 adb.show();
             }});


         secCountryCode=(LinearLayout)findViewById(R.id.secCountryCode);
         lineCountryCode=(View)findViewById(R.id.lineCountryCode);
         VlblCountryCode=(TextView) findViewById(R.id.VlblCountryCode);
         txtCountryCode=(EditText) findViewById(R.id.txtCountryCode);
         txtCountryCode.setText(COUNTRYCODE);
         secFaciCode=(LinearLayout)findViewById(R.id.secFaciCode);
         lineFaciCode=(View)findViewById(R.id.lineFaciCode);
         VlblFaciCode=(TextView) findViewById(R.id.VlblFaciCode);
         txtFaciCode=(EditText) findViewById(R.id.txtFaciCode);
         txtFaciCode.setText(FACICODE);
         secDataID=(LinearLayout)findViewById(R.id.secDataID);
         lineDataID=(View)findViewById(R.id.lineDataID);
         VlblDataID=(TextView) findViewById(R.id.VlblDataID);
         txtDataID=(EditText) findViewById(R.id.txtDataID);
         txtDataID.setText(DATAID);
         secstatus=(LinearLayout)findViewById(R.id.secstatus);
         linestatus=(View)findViewById(R.id.linestatus);
         Vlblstatus = (TextView) findViewById(R.id.Vlblstatus);
         rdogrpstatus = (RadioGroup) findViewById(R.id.rdogrpstatus);
         
         rdostatus1 = (RadioButton) findViewById(R.id.rdostatus1);
         rdostatus2 = (RadioButton) findViewById(R.id.rdostatus2);
         rdostatus3 = (RadioButton) findViewById(R.id.rdostatus3);
         rdogrpstatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpstatus = new String[] {"1","2","3"};
             for (int i = 0; i < rdogrpstatus.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpstatus.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpstatus[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                    secreason.setVisibility(View.GONE);
                    linereason.setVisibility(View.GONE);
                    rdogrpreason.clearCheck();
                    secreasmention.setVisibility(View.GONE);
                    linereasmention.setVisibility(View.GONE);
                    txtreasmention.setText("");
             }
             else
             {
                 secreason.setVisibility(View.VISIBLE);
                 linereason.setVisibility(View.VISIBLE);
                 secreasmention.setVisibility(View.VISIBLE);
                 linereasmention.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secreason=(LinearLayout)findViewById(R.id.secreason);
         linereason=(View)findViewById(R.id.linereason);
         Vlblreason = (TextView) findViewById(R.id.Vlblreason);
         rdogrpreason = (RadioGroup) findViewById(R.id.rdogrpreason);
         
         rdoreason1 = (RadioButton) findViewById(R.id.rdoreason1);
         rdoreason2 = (RadioButton) findViewById(R.id.rdoreason2);
         rdoreason3 = (RadioButton) findViewById(R.id.rdoreason3);
         rdoreason4 = (RadioButton) findViewById(R.id.rdoreason4);
         secreasmention=(LinearLayout)findViewById(R.id.secreasmention);
         linereasmention=(View)findViewById(R.id.linereasmention);
         Vlblreasmention=(TextView) findViewById(R.id.Vlblreasmention);
         txtreasmention=(EditText) findViewById(R.id.txtreasmention);





         //Hide all skip variables
         secreason.setVisibility(View.GONE);
         linereason.setVisibility(View.GONE);
         secreasmention.setVisibility(View.GONE);
         linereasmention.setVisibility(View.GONE);
         /*sec.setVisibility(View.GONE);
         line.setVisibility(View.GONE);
         sec.setVisibility(View.GONE);
         line.setVisibility(View.GONE);*/


         DataSearch(COUNTRYCODE,FACICODE,DATAID);
        Button cmdSave = (Button) findViewById(R.id.cmdSave);
        cmdSave.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) { 
            DataSave();
        }});
     }
     catch(Exception  e)
     {
         Connection.MessageBox(MRS_FinalStatus.this, e.getMessage());
         return;
     }
 }

 private void DataSave()
 {
   try
     {
 
         String DV="";

         if(txtCountryCode.getText().toString().length()==0 & secCountryCode.isShown())
           {
             Connection.MessageBox(MRS_FinalStatus.this, "Required field: Country Code.");
             txtCountryCode.requestFocus(); 
             return;	
           }
         else if(txtFaciCode.getText().toString().length()==0 & secFaciCode.isShown())
           {
             Connection.MessageBox(MRS_FinalStatus.this, "Required field: Faci Code.");
             txtFaciCode.requestFocus(); 
             return;	
           }
         else if(txtDataID.getText().toString().length()==0 & secDataID.isShown())
           {
             Connection.MessageBox(MRS_FinalStatus.this, "Required field: Data Id.");
             txtDataID.requestFocus(); 
             return;	
           }
         
         else if(!rdostatus1.isChecked() & !rdostatus2.isChecked() & !rdostatus3.isChecked() & secstatus.isShown())
           {
              Connection.MessageBox(MRS_FinalStatus.this, "Select anyone options from (What is the final status of the Recall Survey for this patient).");
              rdostatus1.requestFocus();
              return;
           }
         
         else if(!rdoreason1.isChecked() & !rdoreason2.isChecked() & !rdoreason3.isChecked() & !rdoreason4.isChecked() & secreason.isShown())
           {
              Connection.MessageBox(MRS_FinalStatus.this, "Select anyone options from (Why partially complete or incomplete?).");
              rdoreason1.requestFocus();
              return;
           }
         else if(txtreasmention.getText().toString().length()==0 & secreasmention.isShown())
           {
             Connection.MessageBox(MRS_FinalStatus.this, "Required field: Please mention.");
             txtreasmention.requestFocus(); 
             return;	
           }
 
         String SQL = "";
         RadioButton rb;

         MRS_FinalStatus_DataModel objSave = new MRS_FinalStatus_DataModel();
         objSave.setCountryCode(txtCountryCode.getText().toString());
         objSave.setFaciCode(txtFaciCode.getText().toString());
         objSave.setDataID(txtDataID.getText().toString());
         String[] d_rdogrpstatus = new String[] {"1","2","3"};
         objSave.setstatus("");
         for (int i = 0; i < rdogrpstatus.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpstatus.getChildAt(i);
             if (rb.isChecked()) objSave.setstatus(d_rdogrpstatus[i]);
         }

         String[] d_rdogrpreason = new String[] {"1","2","3","4"};
         objSave.setreason("");
         for (int i = 0; i < rdogrpreason.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpreason.getChildAt(i);
             if (rb.isChecked()) objSave.setreason(d_rdogrpreason[i]);
         }

         objSave.setreasmention(txtreasmention.getText().toString());
         objSave.setEnDt(Global.DateTimeNowYMDHMS());
         objSave.setStartTime(STARTTIME);
         objSave.setEndTime(g.CurrentTime24());
         objSave.setDeviceID(DEVICEID);
         objSave.setEntryUser(ENTRYUSER); //from data entry user list
         objSave.setmodifyDate(Global.DateTimeNowYMDHMS());
         //objSave.setLat(Double.toString(currentLatitude));
         //objSave.setLon(Double.toString(currentLongitude));

         String status = objSave.SaveUpdateData(this);
         if(status.length()==0) {
             C.SaveDT("Update Registration set StatusRS='1',Upload='2',modifyDate='"+ Global.DateTimeNowYMDHMS() +"' where CountryCode='" + COUNTRYCODE + "' and FaciCode='" + FACICODE + "' and DataId='" + DATAID + "'");

             /*Intent returnIntent = new Intent();
             returnIntent.putExtra("res", "");
             setResult(Activity.RESULT_OK, returnIntent);
            */
             Connection.MessageBoxNotClose(MRS_FinalStatus.this, "Saved Successfully");
         }
         else{
             Connection.MessageBox(MRS_FinalStatus.this, status);
             return;
         }
     }
     catch(Exception  e)
     {
         Connection.MessageBox(MRS_FinalStatus.this, e.getMessage());
         return;
     }
 }

 private void DataSearch(String CountryCode, String FaciCode, String DataID)
     {
       try
        {
     
           RadioButton rb;
           MRS_FinalStatus_DataModel d = new MRS_FinalStatus_DataModel();
           String SQL = "Select * from "+ TableName +"  Where CountryCode='"+ CountryCode +"' and FaciCode='"+ FaciCode +"' and DataID='"+ DataID +"'";
           List<MRS_FinalStatus_DataModel> data = d.SelectAll(this, SQL);
           for(MRS_FinalStatus_DataModel item : data){
             txtCountryCode.setText(item.getCountryCode());
             txtFaciCode.setText(item.getFaciCode());
             txtDataID.setText(item.getDataID());
             String[] d_rdogrpstatus = new String[] {"1","2","3"};
             for (int i = 0; i < d_rdogrpstatus.length; i++)
             {
                 if (item.getstatus().equals(String.valueOf(d_rdogrpstatus[i])))
                 {
                     rb = (RadioButton)rdogrpstatus.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpreason = new String[] {"1","2","3","4"};
             for (int i = 0; i < d_rdogrpreason.length; i++)
             {
                 if (item.getreason().equals(String.valueOf(d_rdogrpreason[i])))
                 {
                     rb = (RadioButton)rdogrpreason.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtreasmention.setText(item.getreasmention());
           }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(MRS_FinalStatus.this, e.getMessage());
            return;
        }
     }



 protected Dialog onCreateDialog(int id) {
   final Calendar c = Calendar.getInstance();
   hour = c.get(Calendar.HOUR_OF_DAY);
   minute = c.get(Calendar.MINUTE);
   switch (id) {
       case DATE_DIALOG:
           return new DatePickerDialog(this, mDateSetListener,g.mYear,g.mMonth-1,g.mDay);
       case TIME_DIALOG:
           return new TimePickerDialog(this, timePickerListener, hour, minute,false);
       }
     return null;
 }

 private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
      mYear = year; mMonth = monthOfYear+1; mDay = dayOfMonth;
      EditText dtpDate;

      /*dtpDate.setText(new StringBuilder()
      .append(Global.Right("00"+mDay,2)).append("/")
      .append(Global.Right("00"+mMonth,2)).append("/")
      .append(mYear));*/
      }
  };

 private TimePickerDialog.OnTimeSetListener timePickerListener = new TimePickerDialog.OnTimeSetListener() {
    public void onTimeSet(TimePicker view, int selectedHour, int selectedMinute) {
       hour = selectedHour; minute = selectedMinute;
       EditText tpTime;

       //tpTime.setText(new StringBuilder().append(Global.Right("00"+hour,2)).append(":").append(Global.Right("00"+minute,2)));

    }
  };


 //GPS Reading
 //.....................................................................................................
 public void FindLocation() {
 LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

 LocationListener locationListener = new LocationListener() {
     public void onLocationChanged(Location location) {
         updateLocation(location);
     }
     public void onStatusChanged(String provider, int status, Bundle extras) {
     }
     public void onProviderEnabled(String provider) {
     }
     public void onProviderDisabled(String provider) {
     }
   };
  locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
 }

 void updateLocation(Location location) {
     currentLocation  = location;
     currentLatitude  = currentLocation.getLatitude();
     currentLongitude = currentLocation.getLongitude();
 }


 // Method to turn on GPS
 public void turnGPSOn(){
     try
     {
         String provider = Settings.Secure.getString(getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
         if(!provider.contains("gps")){ //if gps is disabled
             final Intent poke = new Intent();
             poke.setClassName("com.android.settings", "com.android.settings.widget.SettingsAppWidgetProvider");
             poke.addCategory(Intent.CATEGORY_ALTERNATIVE);
             poke.setData(Uri.parse("3"));
             sendBroadcast(poke);
         }
     }
     catch (Exception e) {
     }
 }
 
 // Method to turn off the GPS
 public void turnGPSOff(){
     String provider = Settings.Secure.getString(getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
 
     if(provider.contains("gps")){ //if gps is enabled
         final Intent poke = new Intent();
         poke.setClassName("com.android.settings", "com.android.settings.widget.SettingsAppWidgetProvider");
         poke.addCategory(Intent.CATEGORY_ALTERNATIVE);
         poke.setData(Uri.parse("3"));
         sendBroadcast(poke);
     }
 }
 
 // turning off the GPS if its in on state. to avoid the battery drain.
 @Override
 protected void onDestroy() {
     // TODO Auto-generated method stub
     super.onDestroy();
     turnGPSOff();
 }
}