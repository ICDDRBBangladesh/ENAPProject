
 package org.icddrb.enap;


 //Android Manifest Code
 //<activity android:name=".KMC_Outcome" android:label="KMC_Outcome" />
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
 import android.text.Editable;
 import android.text.TextWatcher;
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

 public class KMC_Outcome extends Activity {
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
         LinearLayout secbabycond;
         View linebabycond;
         TextView Vlblbabycond;
         RadioGroup rdogrpbabycond;
         
         RadioButton rdobabycond1;
         RadioButton rdobabycond2;
         RadioButton rdobabycond3;
         LinearLayout secdeathdt;
         View linedeathdt;
         TextView Vlbldeathdt;
         EditText dtpdeathdt;
         LinearLayout secdeathtm;
         View linedeathtm;
         TextView Vlbldeathtm;
         EditText txtdeathtm;
         LinearLayout secdeathtmdk;
         View linedeathtmdk;
         TextView Vlbldeathtmdk;
         CheckBox chkdeathtmdk;
         LinearLayout secdiscdt;
         View linediscdt;
         TextView Vlbldiscdt;
         EditText dtpdiscdt;
         LinearLayout secdisctm;
         View linedisctm;
         TextView Vlbldisctm;
         EditText txtdisctm;
         LinearLayout secdisctmdk;
         View linedisctmdk;
         TextView Vlbldisctmdk;
         CheckBox chkdisctmdk;
         LinearLayout secdiscweight;
         View linediscweight;
         TextView Vlbldiscweight;
         EditText txtdiscweight;
         LinearLayout secdiscweightdk;
         View linediscweightdk;
         TextView Vlbldiscweightdk;
         CheckBox chkdiscweightdk;
         LinearLayout secdiscto;
         View linediscto;
         TextView Vlbldiscto;
         RadioGroup rdogrpdiscto;
         
         RadioButton rdodiscto1;
         RadioButton rdodiscto2;
         RadioButton rdodiscto3;
         RadioButton rdodiscto4;
         LinearLayout secdisctooth;
         View linedisctooth;
         TextView Vlbldisctooth;
         EditText txtdisctooth;
         LinearLayout secmotcond;
         View linemotcond;
         TextView Vlblmotcond;
         RadioGroup rdogrpmotcond;
         
         RadioButton rdomotcond1;
         RadioButton rdomotcond2;
         LinearLayout secmotdiscto;
         View linemotdiscto;
         TextView Vlblmotdiscto;
         RadioGroup rdogrpmotdiscto;
         
         RadioButton rdomotdiscto1;
         RadioButton rdomotdiscto2;
         RadioButton rdomotdiscto3;
         RadioButton rdomotdiscto4;
         LinearLayout secmotdisctooth;
         View linemotdisctooth;
         TextView Vlblmotdisctooth;
         EditText txtmotdisctooth;
         LinearLayout seclbl1;
         View linelbl1;
         LinearLayout secobjstatus;
         View lineobjstatus;
         TextView Vlblobjstatus;
         RadioGroup rdogrpobjstatus;
         
         RadioButton rdoobjstatus1;
         RadioButton rdoobjstatus2;
         RadioButton rdoobjstatus3;
         LinearLayout secwhyincom;
         View linewhyincom;
         TextView Vlblwhyincom;
         RadioGroup rdogrpwhyincom;
         
         RadioButton rdowhyincom1;
         RadioButton rdowhyincom2;
         RadioButton rdowhyincom3;
         RadioButton rdowhyincom4;
         LinearLayout secreason;
         View linereason;
         TextView Vlblreason;
         EditText txtreason;
         LinearLayout secincirep;
         View lineincirep;
         TextView Vlblincirep;
         RadioGroup rdogrpincirep;
         
         RadioButton rdoincirep1;
         RadioButton rdoincirep2;
         LinearLayout secincident;
         View lineincident;
         TextView Vlblincident;
         EditText txtincident;
         LinearLayout secinciformsl;
         View lineinciformsl;
         TextView Vlblinciformsl;
         EditText txtinciformsl;

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
         setContentView(R.layout.kmc_outcome);
         C = new Connection(this);
         g = Global.getInstance();

         STARTTIME = g.CurrentTime24();
         DEVICEID  = sp.getValue(this, "deviceid");
         ENTRYUSER = sp.getValue(this, "userid");

         IDbundle = getIntent().getExtras();
         COUNTRYCODE = IDbundle.getString("CountryCode");
         FACICODE = IDbundle.getString("FaciCode");
         DATAID = IDbundle.getString("DataID");

         TableName = "KMC_Outcome";

         //turnGPSOn();

         //GPS Location
         //FindLocation();
         // Double.toString(currentLatitude);
         // Double.toString(currentLongitude);
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(KMC_Outcome.this);
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
         secbabycond=(LinearLayout)findViewById(R.id.secbabycond);
         linebabycond=(View)findViewById(R.id.linebabycond);
         Vlblbabycond = (TextView) findViewById(R.id.Vlblbabycond);
         rdogrpbabycond = (RadioGroup) findViewById(R.id.rdogrpbabycond);
         
         rdobabycond1 = (RadioButton) findViewById(R.id.rdobabycond1);
         rdobabycond2 = (RadioButton) findViewById(R.id.rdobabycond2);
         rdobabycond3 = (RadioButton) findViewById(R.id.rdobabycond3);
         rdogrpbabycond.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpbabycond = new String[] {"1","2","3"};
             for (int i = 0; i < rdogrpbabycond.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpbabycond.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpbabycond[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                    secdeathdt.setVisibility(View.GONE);
                    linedeathdt.setVisibility(View.GONE);
                    dtpdeathdt.setText("");
                    secdeathtm.setVisibility(View.GONE);
                    linedeathtm.setVisibility(View.GONE);
                    txtdeathtm.setText("");
                    secdeathtmdk.setVisibility(View.GONE);
                    linedeathtmdk.setVisibility(View.GONE);
                    chkdeathtmdk.setChecked(false);

                 secdiscdt.setVisibility(View.VISIBLE);
                 linediscdt.setVisibility(View.VISIBLE);
                 secdisctm.setVisibility(View.VISIBLE);
                 linedisctm.setVisibility(View.VISIBLE);
                 secdisctmdk.setVisibility(View.VISIBLE);
                 linedisctmdk.setVisibility(View.VISIBLE);
                 secdiscweight.setVisibility(View.VISIBLE);
                 //linediscweight.setVisibility(View.VISIBLE);
                 secdiscweightdk.setVisibility(View.VISIBLE);
                 linediscweightdk.setVisibility(View.VISIBLE);
                 secdiscto.setVisibility(View.VISIBLE);
                 linediscto.setVisibility(View.VISIBLE);
                 //secdisctooth.setVisibility(View.VISIBLE);
                 //linedisctooth.setVisibility(View.VISIBLE);
                 secmotcond.setVisibility(View.VISIBLE);
                 linemotcond.setVisibility(View.VISIBLE);
             }
             else if(rbData.equalsIgnoreCase("2")){
                 secdeathdt.setVisibility(View.VISIBLE);
                 linedeathdt.setVisibility(View.VISIBLE);
                 secdeathtm.setVisibility(View.VISIBLE);
                 //linedeathtm.setVisibility(View.VISIBLE);
                 secdeathtmdk.setVisibility(View.VISIBLE);
                 linedeathtmdk.setVisibility(View.VISIBLE);

                 secdiscdt.setVisibility(View.GONE);
                 dtpdiscdt.setText("");
                 linediscdt.setVisibility(View.GONE);
                 secdisctm.setVisibility(View.GONE);
                 linedisctm.setVisibility(View.GONE);
                 txtdisctm.setText("");
                 secdisctmdk.setVisibility(View.GONE);
                 linedisctmdk.setVisibility(View.GONE);
                 chkdisctmdk.setChecked(false);
                 secdiscweight.setVisibility(View.GONE);
                 //linediscweight.setVisibility(View.VISIBLE);
                 secdiscweightdk.setVisibility(View.GONE);
                 linediscweightdk.setVisibility(View.GONE);
                 txtdiscweight.setText("");
                 chkdiscweightdk.setChecked(false);
                 secdiscto.setVisibility(View.GONE);
                 rdogrpdiscto.clearCheck();
                 linediscto.setVisibility(View.GONE);
                 //secdisctooth.setVisibility(View.VISIBLE);
                 //linedisctooth.setVisibility(View.VISIBLE);
                 secmotcond.setVisibility(View.VISIBLE);
                 linemotcond.setVisibility(View.VISIBLE);
             }
             else if(rbData.equalsIgnoreCase("3"))
             {
                    secdeathdt.setVisibility(View.GONE);
                    linedeathdt.setVisibility(View.GONE);
                    dtpdeathdt.setText("");
                    secdeathtm.setVisibility(View.GONE);
                    linedeathtm.setVisibility(View.GONE);
                    txtdeathtm.setText("");
                    secdeathtmdk.setVisibility(View.GONE);
                    linedeathtmdk.setVisibility(View.GONE);
                    chkdeathtmdk.setChecked(false);
                    secdiscdt.setVisibility(View.GONE);
                    linediscdt.setVisibility(View.GONE);
                    dtpdiscdt.setText("");
                    secdisctm.setVisibility(View.GONE);
                    linedisctm.setVisibility(View.GONE);
                    txtdisctm.setText("");
                    secdisctmdk.setVisibility(View.GONE);
                    linedisctmdk.setVisibility(View.GONE);
                    chkdisctmdk.setChecked(false);
                    secdiscweight.setVisibility(View.GONE);
                    linediscweight.setVisibility(View.GONE);
                    txtdiscweight.setText("");
                    secdiscweightdk.setVisibility(View.GONE);
                    linediscweightdk.setVisibility(View.GONE);
                    chkdiscweightdk.setChecked(false);
                    secdiscto.setVisibility(View.GONE);
                    linediscto.setVisibility(View.GONE);
                    rdogrpdiscto.clearCheck();
                    secdisctooth.setVisibility(View.GONE);
                    linedisctooth.setVisibility(View.GONE);
                    txtdisctooth.setText("");
                    secmotcond.setVisibility(View.GONE);
                    linemotcond.setVisibility(View.GONE);
                    rdogrpmotcond.clearCheck();
                    secmotdiscto.setVisibility(View.GONE);
                    linemotdiscto.setVisibility(View.GONE);
                    rdogrpmotdiscto.clearCheck();
                    secmotdisctooth.setVisibility(View.GONE);
                    linemotdisctooth.setVisibility(View.GONE);
                    txtmotdisctooth.setText("");
             }
             else
             {
                    secdeathdt.setVisibility(View.VISIBLE);
                    linedeathdt.setVisibility(View.VISIBLE);
                    secdeathtm.setVisibility(View.VISIBLE);
                    //linedeathtm.setVisibility(View.VISIBLE);
                    secdeathtmdk.setVisibility(View.VISIBLE);
                    linedeathtmdk.setVisibility(View.VISIBLE);
                    secdiscdt.setVisibility(View.VISIBLE);
                    linediscdt.setVisibility(View.VISIBLE);
                    secdisctm.setVisibility(View.VISIBLE);
                    linedisctm.setVisibility(View.VISIBLE);
                    secdisctmdk.setVisibility(View.VISIBLE);
                    linedisctmdk.setVisibility(View.VISIBLE);
                    secdiscweight.setVisibility(View.VISIBLE);
                    //linediscweight.setVisibility(View.VISIBLE);
                    secdiscweightdk.setVisibility(View.VISIBLE);
                    linediscweightdk.setVisibility(View.VISIBLE);
                    secdiscto.setVisibility(View.VISIBLE);
                    linediscto.setVisibility(View.VISIBLE);
                    //secdisctooth.setVisibility(View.VISIBLE);
                    //linedisctooth.setVisibility(View.VISIBLE);
                    secmotcond.setVisibility(View.VISIBLE);
                    linemotcond.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secdeathdt=(LinearLayout)findViewById(R.id.secdeathdt);
         linedeathdt=(View)findViewById(R.id.linedeathdt);
         Vlbldeathdt=(TextView) findViewById(R.id.Vlbldeathdt);
         dtpdeathdt=(EditText) findViewById(R.id.dtpdeathdt);
         secdeathtm=(LinearLayout)findViewById(R.id.secdeathtm);
         linedeathtm=(View)findViewById(R.id.linedeathtm);
         Vlbldeathtm=(TextView) findViewById(R.id.Vlbldeathtm);
         txtdeathtm=(EditText) findViewById(R.id.txtdeathtm);
         secdeathtmdk=(LinearLayout)findViewById(R.id.secdeathtmdk);
         linedeathtmdk=(View)findViewById(R.id.linedeathtmdk);
         Vlbldeathtmdk=(TextView) findViewById(R.id.Vlbldeathtmdk);
         chkdeathtmdk=(CheckBox) findViewById(R.id.chkdeathtmdk);
         secdiscdt=(LinearLayout)findViewById(R.id.secdiscdt);
         linediscdt=(View)findViewById(R.id.linediscdt);
         Vlbldiscdt=(TextView) findViewById(R.id.Vlbldiscdt);
         dtpdiscdt=(EditText) findViewById(R.id.dtpdiscdt);
         secdisctm=(LinearLayout)findViewById(R.id.secdisctm);
         linedisctm=(View)findViewById(R.id.linedisctm);
         Vlbldisctm=(TextView) findViewById(R.id.Vlbldisctm);
         txtdisctm=(EditText) findViewById(R.id.txtdisctm);
         secdisctmdk=(LinearLayout)findViewById(R.id.secdisctmdk);
         linedisctmdk=(View)findViewById(R.id.linedisctmdk);
         Vlbldisctmdk=(TextView) findViewById(R.id.Vlbldisctmdk);
         chkdisctmdk=(CheckBox) findViewById(R.id.chkdisctmdk);
         secdiscweight=(LinearLayout)findViewById(R.id.secdiscweight);
         linediscweight=(View)findViewById(R.id.linediscweight);
         Vlbldiscweight=(TextView) findViewById(R.id.Vlbldiscweight);
         txtdiscweight=(EditText) findViewById(R.id.txtdiscweight);
         secdiscweightdk=(LinearLayout)findViewById(R.id.secdiscweightdk);
         linediscweightdk=(View)findViewById(R.id.linediscweightdk);
         Vlbldiscweightdk=(TextView) findViewById(R.id.Vlbldiscweightdk);
         chkdiscweightdk=(CheckBox) findViewById(R.id.chkdiscweightdk);
         secdiscto=(LinearLayout)findViewById(R.id.secdiscto);
         linediscto=(View)findViewById(R.id.linediscto);
         Vlbldiscto = (TextView) findViewById(R.id.Vlbldiscto);
         rdogrpdiscto = (RadioGroup) findViewById(R.id.rdogrpdiscto);
         
         rdodiscto1 = (RadioButton) findViewById(R.id.rdodiscto1);
         rdodiscto2 = (RadioButton) findViewById(R.id.rdodiscto2);
         rdodiscto3 = (RadioButton) findViewById(R.id.rdodiscto3);
         rdodiscto4 = (RadioButton) findViewById(R.id.rdodiscto4);
         secdisctooth=(LinearLayout)findViewById(R.id.secdisctooth);
         linedisctooth=(View)findViewById(R.id.linedisctooth);
         Vlbldisctooth=(TextView) findViewById(R.id.Vlbldisctooth);
         txtdisctooth=(EditText) findViewById(R.id.txtdisctooth);
         secmotcond=(LinearLayout)findViewById(R.id.secmotcond);
         linemotcond=(View)findViewById(R.id.linemotcond);
         Vlblmotcond = (TextView) findViewById(R.id.Vlblmotcond);
         rdogrpmotcond = (RadioGroup) findViewById(R.id.rdogrpmotcond);
         
         rdomotcond1 = (RadioButton) findViewById(R.id.rdomotcond1);
         rdomotcond2 = (RadioButton) findViewById(R.id.rdomotcond2);
         rdogrpmotcond.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpmotcond = new String[] {"1","2"};
             for (int i = 0; i < rdogrpmotcond.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpmotcond.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpmotcond[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secmotdiscto.setVisibility(View.GONE);
                    linemotdiscto.setVisibility(View.GONE);
                    rdogrpmotdiscto.clearCheck();
                    secmotdisctooth.setVisibility(View.GONE);
                    linemotdisctooth.setVisibility(View.GONE);
                    txtmotdisctooth.setText("");
             }
             else
             {
                    secmotdiscto.setVisibility(View.VISIBLE);
                    linemotdiscto.setVisibility(View.VISIBLE);
                    //secmotdisctooth.setVisibility(View.VISIBLE);
                    //linemotdisctooth.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secmotdiscto=(LinearLayout)findViewById(R.id.secmotdiscto);
         linemotdiscto=(View)findViewById(R.id.linemotdiscto);
         Vlblmotdiscto = (TextView) findViewById(R.id.Vlblmotdiscto);
         rdogrpmotdiscto = (RadioGroup) findViewById(R.id.rdogrpmotdiscto);
         
         rdomotdiscto1 = (RadioButton) findViewById(R.id.rdomotdiscto1);
         rdomotdiscto2 = (RadioButton) findViewById(R.id.rdomotdiscto2);
         rdomotdiscto3 = (RadioButton) findViewById(R.id.rdomotdiscto3);
         rdomotdiscto4 = (RadioButton) findViewById(R.id.rdomotdiscto4);
         secmotdisctooth=(LinearLayout)findViewById(R.id.secmotdisctooth);
         linemotdisctooth=(View)findViewById(R.id.linemotdisctooth);
         Vlblmotdisctooth=(TextView) findViewById(R.id.Vlblmotdisctooth);
         txtmotdisctooth=(EditText) findViewById(R.id.txtmotdisctooth);
         seclbl1=(LinearLayout)findViewById(R.id.seclbl1);
         linelbl1=(View)findViewById(R.id.linelbl1);
         secobjstatus=(LinearLayout)findViewById(R.id.secobjstatus);
         lineobjstatus=(View)findViewById(R.id.lineobjstatus);
         Vlblobjstatus = (TextView) findViewById(R.id.Vlblobjstatus);
         rdogrpobjstatus = (RadioGroup) findViewById(R.id.rdogrpobjstatus);
         
         rdoobjstatus1 = (RadioButton) findViewById(R.id.rdoobjstatus1);
         rdoobjstatus2 = (RadioButton) findViewById(R.id.rdoobjstatus2);
         rdoobjstatus3 = (RadioButton) findViewById(R.id.rdoobjstatus3);
         rdogrpobjstatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpobjstatus = new String[] {"1","2","3"};
             for (int i = 0; i < rdogrpobjstatus.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpobjstatus.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpobjstatus[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                    secwhyincom.setVisibility(View.GONE);
                    linewhyincom.setVisibility(View.GONE);
                    rdogrpwhyincom.clearCheck();
                    secreason.setVisibility(View.GONE);
                    linereason.setVisibility(View.GONE);
                    txtreason.setText("");
             }
             else
             {
                    secwhyincom.setVisibility(View.VISIBLE);
                    linewhyincom.setVisibility(View.VISIBLE);
                    secreason.setVisibility(View.VISIBLE);
                    linereason.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secwhyincom=(LinearLayout)findViewById(R.id.secwhyincom);
         linewhyincom=(View)findViewById(R.id.linewhyincom);
         Vlblwhyincom = (TextView) findViewById(R.id.Vlblwhyincom);
         rdogrpwhyincom = (RadioGroup) findViewById(R.id.rdogrpwhyincom);
         
         rdowhyincom1 = (RadioButton) findViewById(R.id.rdowhyincom1);
         rdowhyincom2 = (RadioButton) findViewById(R.id.rdowhyincom2);
         rdowhyincom3 = (RadioButton) findViewById(R.id.rdowhyincom3);
         rdowhyincom4 = (RadioButton) findViewById(R.id.rdowhyincom4);
         secreason=(LinearLayout)findViewById(R.id.secreason);
         linereason=(View)findViewById(R.id.linereason);
         Vlblreason=(TextView) findViewById(R.id.Vlblreason);
         txtreason=(EditText) findViewById(R.id.txtreason);
         secincirep=(LinearLayout)findViewById(R.id.secincirep);
         lineincirep=(View)findViewById(R.id.lineincirep);
         Vlblincirep = (TextView) findViewById(R.id.Vlblincirep);
         rdogrpincirep = (RadioGroup) findViewById(R.id.rdogrpincirep);
         
         rdoincirep1 = (RadioButton) findViewById(R.id.rdoincirep1);
         rdoincirep2 = (RadioButton) findViewById(R.id.rdoincirep2);
         rdogrpincirep.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpincirep = new String[] {"1","2"};
             for (int i = 0; i < rdogrpincirep.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpincirep.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpincirep[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secincident.setVisibility(View.GONE);
                    lineincident.setVisibility(View.GONE);
                    txtincident.setText("");
                    secinciformsl.setVisibility(View.GONE);
                    lineinciformsl.setVisibility(View.GONE);
                    txtinciformsl.setText("");
             }
             else
             {
                    secincident.setVisibility(View.VISIBLE);
                    lineincident.setVisibility(View.VISIBLE);
                    secinciformsl.setVisibility(View.VISIBLE);
                    lineinciformsl.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secincident=(LinearLayout)findViewById(R.id.secincident);
         lineincident=(View)findViewById(R.id.lineincident);
         Vlblincident=(TextView) findViewById(R.id.Vlblincident);
         txtincident=(EditText) findViewById(R.id.txtincident);
         secinciformsl=(LinearLayout)findViewById(R.id.secinciformsl);
         lineinciformsl=(View)findViewById(R.id.lineinciformsl);
         Vlblinciformsl=(TextView) findViewById(R.id.Vlblinciformsl);
         txtinciformsl=(EditText) findViewById(R.id.txtinciformsl);


         dtpdeathdt.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpdeathdt.getRight() - dtpdeathdt.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btndeathdt"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });
         dtpdiscdt.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpdiscdt.getRight() - dtpdiscdt.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btndiscdt"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });


         txtdeathtm.setOnTouchListener(new View.OnTouchListener() {
         @Override
         public boolean onTouch(View v, MotionEvent event) {
             final int DRAWABLE_RIGHT = 2;
             if(event.getAction() == MotionEvent.ACTION_UP) {
                 if(event.getRawX() >= (txtdeathtm.getRight() - txtdeathtm.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                     VariableID = "btndeathtm"; showDialog(TIME_DIALOG);
                  return true;
                 }
             }
             return false;
           }
         });
         txtdisctm.setOnTouchListener(new View.OnTouchListener() {
         @Override
         public boolean onTouch(View v, MotionEvent event) {
             final int DRAWABLE_RIGHT = 2;
             if(event.getAction() == MotionEvent.ACTION_UP) {
                 if(event.getRawX() >= (txtdisctm.getRight() - txtdisctm.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                     VariableID = "btndisctm"; showDialog(TIME_DIALOG);
                  return true;
                 }
             }
             return false;
           }
         });


         rdogrpdiscto.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(checkedId==R.id.rdodiscto4)
                     secdisctooth.setVisibility(View.VISIBLE);
                 else
                     secdisctooth.setVisibility(View.GONE);
             }
         });

         rdogrpmotdiscto.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(checkedId==R.id.rdomotdiscto4)
                     secmotdisctooth.setVisibility(View.VISIBLE);
                 else
                     secmotdisctooth.setVisibility(View.GONE);
             }
         });



         chkdisctmdk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if ( isChecked )
                 {
                     txtdisctm.setText("");
                 }

             }
         });
         txtdisctm.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {
             }

             public void beforeTextChanged(CharSequence s, int start, int count, int after) {
             }

             public void afterTextChanged(Editable s) {
                 if(txtdisctm.getText().toString().length()>0) chkdisctmdk.setChecked(false);
             }
         });

         chkdiscweightdk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if ( isChecked )
                 {
                     txtdiscweight.setText("");
                 }

             }
         });
         txtdiscweight.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {
             }

             public void beforeTextChanged(CharSequence s, int start, int count, int after) {
             }

             public void afterTextChanged(Editable s) {
                 if(txtdiscweight.getText().toString().length()>0) chkdiscweightdk.setChecked(false);
             }
         });


         txtdeathtm.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,
                                       int count) {
             }

             public void beforeTextChanged(CharSequence s, int start, int count,
                                           int after) {
             }

             public void afterTextChanged(Editable s) {
                if(txtdeathtm.getText().toString().length()>0) chkdeathtmdk.setChecked(false);
             }
         });

         chkdeathtmdk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if ( isChecked )
                 {
                     txtdeathtm.setText("");
                 }

             }
         });

         //Hide all skip variables
         secmotdisctooth.setVisibility(View.GONE);
         secdisctooth.setVisibility(View.GONE);
         secdeathdt.setVisibility(View.GONE);
         linedeathdt.setVisibility(View.GONE);
         secdeathtm.setVisibility(View.GONE);
         linedeathtm.setVisibility(View.GONE);
         secdeathtmdk.setVisibility(View.GONE);
         linedeathtmdk.setVisibility(View.GONE);
         secdeathdt.setVisibility(View.GONE);
         linedeathdt.setVisibility(View.GONE);
         secdeathtm.setVisibility(View.GONE);
         linedeathtm.setVisibility(View.GONE);
         secdeathtmdk.setVisibility(View.GONE);
         linedeathtmdk.setVisibility(View.GONE);
         secdiscdt.setVisibility(View.GONE);
         linediscdt.setVisibility(View.GONE);
         secdisctm.setVisibility(View.GONE);
         linedisctm.setVisibility(View.GONE);
         secdisctmdk.setVisibility(View.GONE);
         linedisctmdk.setVisibility(View.GONE);
         secdiscweight.setVisibility(View.GONE);
         linediscweight.setVisibility(View.GONE);
         secdiscweightdk.setVisibility(View.GONE);
         linediscweightdk.setVisibility(View.GONE);
         secdiscto.setVisibility(View.GONE);
         linediscto.setVisibility(View.GONE);
         secdisctooth.setVisibility(View.GONE);
         linedisctooth.setVisibility(View.GONE);
         secmotcond.setVisibility(View.GONE);
         linemotcond.setVisibility(View.GONE);
         secmotdiscto.setVisibility(View.GONE);
         linemotdiscto.setVisibility(View.GONE);
         secmotdisctooth.setVisibility(View.GONE);
         linemotdisctooth.setVisibility(View.GONE);
         secmotdiscto.setVisibility(View.GONE);
         linemotdiscto.setVisibility(View.GONE);
         secmotdisctooth.setVisibility(View.GONE);
         linemotdisctooth.setVisibility(View.GONE);
         secwhyincom.setVisibility(View.GONE);
         linewhyincom.setVisibility(View.GONE);
         secreason.setVisibility(View.GONE);
         linereason.setVisibility(View.GONE);
         secincident.setVisibility(View.GONE);
         lineincident.setVisibility(View.GONE);
         secinciformsl.setVisibility(View.GONE);
         lineinciformsl.setVisibility(View.GONE);

        DataSearch(COUNTRYCODE,FACICODE,DATAID);
        Button cmdSave = (Button) findViewById(R.id.cmdSave);
        cmdSave.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) { 
            DataSave();
        }});
     }
     catch(Exception  e)
     {
         Connection.MessageBox(KMC_Outcome.this, e.getMessage());
         return;
     }
 }

 public void ClearForm()
 {
     rdogrpbabycond.clearCheck();
     secdeathdt.setVisibility(View.GONE);
     linedeathdt.setVisibility(View.GONE);
     dtpdeathdt.setText("");
     secdeathtm.setVisibility(View.GONE);
     linedeathtm.setVisibility(View.GONE);
     txtdeathtm.setText("");
     secdeathtmdk.setVisibility(View.GONE);
     linedeathtmdk.setVisibility(View.GONE);
     chkdeathtmdk.setChecked(false);
     secdiscdt.setVisibility(View.GONE);
     linediscdt.setVisibility(View.GONE);
     dtpdiscdt.setText("");
     secdisctm.setVisibility(View.GONE);
     linedisctm.setVisibility(View.GONE);
     txtdisctm.setText("");
     secdisctmdk.setVisibility(View.GONE);
     linedisctmdk.setVisibility(View.GONE);
     chkdisctmdk.setChecked(false);
     secdiscweight.setVisibility(View.GONE);
     linediscweight.setVisibility(View.GONE);
     txtdiscweight.setText("");
     secdiscweightdk.setVisibility(View.GONE);
     linediscweightdk.setVisibility(View.GONE);
     chkdiscweightdk.setChecked(false);
     secdiscto.setVisibility(View.GONE);
     linediscto.setVisibility(View.GONE);
     rdogrpdiscto.clearCheck();
     secdisctooth.setVisibility(View.GONE);
     linedisctooth.setVisibility(View.GONE);
     txtdisctooth.setText("");
     secmotcond.setVisibility(View.GONE);
     linemotcond.setVisibility(View.GONE);
     rdogrpmotcond.clearCheck();
     secmotdiscto.setVisibility(View.GONE);
     linemotdiscto.setVisibility(View.GONE);
     rdogrpmotdiscto.clearCheck();
     secmotdisctooth.setVisibility(View.GONE);
     linemotdisctooth.setVisibility(View.GONE);
     txtmotdisctooth.setText("");
     rdogrpobjstatus.clearCheck();
     secwhyincom.setVisibility(View.GONE);
     rdogrpwhyincom.clearCheck();
     secwhyincom.setVisibility(View.GONE);
     txtreason.setText("");
     secreason.setVisibility(View.GONE);
     rdogrpincirep.clearCheck();
     secincident.setVisibility(View.GONE);
     txtincident.setText("");
     secinciformsl.setVisibility(View.GONE);
     txtinciformsl.setText("");
 }


 private void DataSave()
 {
   try
     {
 
         String DV="";

         if(txtCountryCode.getText().toString().length()==0 & secCountryCode.isShown())
           {
             Connection.MessageBox(KMC_Outcome.this, "Required field: Country Code.");
             txtCountryCode.requestFocus(); 
             return;	
           }
         else if(txtFaciCode.getText().toString().length()==0 & secFaciCode.isShown())
           {
             Connection.MessageBox(KMC_Outcome.this, "Required field: Facility Code.");
             txtFaciCode.requestFocus(); 
             return;	
           }
         else if(txtDataID.getText().toString().length()==0 & secDataID.isShown())
           {
             Connection.MessageBox(KMC_Outcome.this, "Required field: Data ID.");
             txtDataID.requestFocus(); 
             return;	
           }
         
         else if(!rdobabycond1.isChecked() & !rdobabycond2.isChecked() & !rdobabycond3.isChecked() & secbabycond.isShown())
           {
              Connection.MessageBox(KMC_Outcome.this, "Select anyone options from (Babys condition at discharge).");
              rdobabycond1.requestFocus();
              return;
           }
         DV = Global.DateValidate(dtpdeathdt.getText().toString());
         if(DV.length()!=0 & secdeathdt.isShown())
           {
             Connection.MessageBox(KMC_Outcome.this, DV);
             dtpdeathdt.requestFocus(); 
             return;	
           }
         else if(!chkdeathtmdk.isChecked() & txtdeathtm.getText().length()==0 & secdeathtm.isShown())
           {
             Connection.MessageBox(KMC_Outcome.this, "Required field: Time of baby death.");
             txtdeathtm.requestFocus(); 
             return;	
           }
         DV = Global.DateValidate(dtpdiscdt.getText().toString());
         if(DV.length()!=0 & secdiscdt.isShown())
           {
             Connection.MessageBox(KMC_Outcome.this, DV);
             dtpdiscdt.requestFocus(); 
             return;	
           }
         else if(!chkdisctmdk.isChecked() & txtdisctm.getText().length()==0 & secdisctm.isShown())
           {
             Connection.MessageBox(KMC_Outcome.this, "Required field: Time of discharge(24 Hours clock).");
             txtdisctm.requestFocus(); 
             return;	
           }
         else if(!chkdiscweightdk.isChecked() & txtdiscweight.getText().toString().length()==0 & secdiscweight.isShown())
           {
             Connection.MessageBox(KMC_Outcome.this, "Required field: Babys weight at discharge(in gram).");
             txtdiscweight.requestFocus(); 
             return;	
           }
         else if(!chkdiscweightdk.isChecked() & (Integer.valueOf(txtdiscweight.getText().toString().length()==0 ? "400" : txtdiscweight.getText().toString()) < 400 || Integer.valueOf(txtdiscweight.getText().toString().length()==0 ? "9999" : txtdiscweight.getText().toString()) > 9999))
           {
             Connection.MessageBox(KMC_Outcome.this, "Value should be between 400 and 9999(Babys weight at discharge(in Gram)).");
             txtdiscweight.requestFocus(); 
             return;	
           }
         
         else if(!rdodiscto1.isChecked() & !rdodiscto2.isChecked() & !rdodiscto3.isChecked() & !rdodiscto4.isChecked() & secdiscto.isShown())
           {
              Connection.MessageBox(KMC_Outcome.this, "Select anyone options from (Baby discharge/transferred to).");
              rdodiscto1.requestFocus();
              return;
           }
         else if(txtdisctooth.getText().toString().length()==0 & secdisctooth.isShown())
           {
             Connection.MessageBox(KMC_Outcome.this, "Required field: Others.");
             txtdisctooth.requestFocus(); 
             return;	
           }
         
         else if(!rdomotcond1.isChecked() & !rdomotcond2.isChecked() & secmotcond.isShown())
           {
              Connection.MessageBox(KMC_Outcome.this, "Select anyone options from (Mothers condition at discharge from KMC ward).");
              rdomotcond1.requestFocus();
              return;
           }
         
         else if(!rdomotdiscto1.isChecked() & !rdomotdiscto2.isChecked() & !rdomotdiscto3.isChecked() & !rdomotdiscto4.isChecked() & secmotdiscto.isShown())
           {
              Connection.MessageBox(KMC_Outcome.this, "Select anyone options from (Mother discharged to).");
              rdomotdiscto1.requestFocus();
              return;
           }
         else if(txtmotdisctooth.getText().toString().length()==0 & secmotdisctooth.isShown())
           {
             Connection.MessageBox(KMC_Outcome.this, "Required field: Others.");
             txtmotdisctooth.requestFocus(); 
             return;	
           }
         
         else if(!rdoobjstatus1.isChecked() & !rdoobjstatus2.isChecked() & !rdoobjstatus3.isChecked() & secobjstatus.isShown())
           {
              Connection.MessageBox(KMC_Outcome.this, "Select anyone options from (What is the status of the observation?).");
              rdoobjstatus1.requestFocus();
              return;
           }
         
         else if(!rdowhyincom1.isChecked() & !rdowhyincom2.isChecked() & !rdowhyincom3.isChecked() & !rdowhyincom4.isChecked() & secwhyincom.isShown())
           {
              Connection.MessageBox(KMC_Outcome.this, "Select anyone options from (Why partially complete or incomplete?).");
              rdowhyincom1.requestFocus();
              return;
           }
         else if(txtreason.getText().toString().length()==0 & secreason.isShown())
           {
             Connection.MessageBox(KMC_Outcome.this, "Required field: Please mention.");
             txtreason.requestFocus(); 
             return;	
           }
         
         else if(!rdoincirep1.isChecked() & !rdoincirep2.isChecked() & secincirep.isShown())
           {
              Connection.MessageBox(KMC_Outcome.this, "Select anyone options from (Do you want to report any incident?).");
              rdoincirep1.requestFocus();
              return;
           }
         else if(txtincident.getText().toString().length()==0 & secincident.isShown())
           {
             Connection.MessageBox(KMC_Outcome.this, "Required field: If yes, then what is the incident?.");
             txtincident.requestFocus(); 
             return;	
           }
         else if(txtinciformsl.getText().toString().length()==0 & secinciformsl.isShown())
           {
             Connection.MessageBox(KMC_Outcome.this, "Required field: Write down the serial number of the incident form..");
             txtinciformsl.requestFocus(); 
             return;	
           }
 
         String SQL = "";
         RadioButton rb;

         KMC_Outcome_DataModel objSave = new KMC_Outcome_DataModel();
         objSave.setCountryCode(txtCountryCode.getText().toString());
         objSave.setFaciCode(txtFaciCode.getText().toString());
         objSave.setDataID(txtDataID.getText().toString());
         String[] d_rdogrpbabycond = new String[] {"1","2","3"};
         objSave.setbabycond("");
         for (int i = 0; i < rdogrpbabycond.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpbabycond.getChildAt(i);
             if (rb.isChecked()) objSave.setbabycond(d_rdogrpbabycond[i]);
         }

         objSave.setdeathdt(dtpdeathdt.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpdeathdt.getText().toString()) : dtpdeathdt.getText().toString());
         objSave.setdeathtm(txtdeathtm.getText().toString());
         objSave.setdeathtmdk((chkdeathtmdk.isChecked()?"1":(secdeathtmdk.isShown()?"2":"")));
         objSave.setdiscdt(dtpdiscdt.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpdiscdt.getText().toString()) : dtpdiscdt.getText().toString());
         objSave.setdisctm(txtdisctm.getText().toString());
         objSave.setdisctmdk((chkdisctmdk.isChecked()?"1":(secdisctmdk.isShown()?"2":"")));
         objSave.setdiscweight(txtdiscweight.getText().toString());
         objSave.setdiscweightdk((chkdiscweightdk.isChecked()?"1":(secdiscweightdk.isShown()?"2":"")));
         String[] d_rdogrpdiscto = new String[] {"1","2","3","4"};
         objSave.setdiscto("");
         for (int i = 0; i < rdogrpdiscto.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpdiscto.getChildAt(i);
             if (rb.isChecked()) objSave.setdiscto(d_rdogrpdiscto[i]);
         }

         objSave.setdisctooth(txtdisctooth.getText().toString());
         String[] d_rdogrpmotcond = new String[] {"1","2"};
         objSave.setmotcond("");
         for (int i = 0; i < rdogrpmotcond.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpmotcond.getChildAt(i);
             if (rb.isChecked()) objSave.setmotcond(d_rdogrpmotcond[i]);
         }

         String[] d_rdogrpmotdiscto = new String[] {"1","2","3","4"};
         objSave.setmotdiscto("");
         for (int i = 0; i < rdogrpmotdiscto.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpmotdiscto.getChildAt(i);
             if (rb.isChecked()) objSave.setmotdiscto(d_rdogrpmotdiscto[i]);
         }

         objSave.setmotdisctooth(txtmotdisctooth.getText().toString());
         String[] d_rdogrpobjstatus = new String[] {"1","2","3"};
         objSave.setobjstatus("");
         for (int i = 0; i < rdogrpobjstatus.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpobjstatus.getChildAt(i);
             if (rb.isChecked()) objSave.setobjstatus(d_rdogrpobjstatus[i]);
         }

         String[] d_rdogrpwhyincom = new String[] {"1","2","3","4"};
         objSave.setwhyincom("");
         for (int i = 0; i < rdogrpwhyincom.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpwhyincom.getChildAt(i);
             if (rb.isChecked()) objSave.setwhyincom(d_rdogrpwhyincom[i]);
         }

         objSave.setreason(txtreason.getText().toString());
         String[] d_rdogrpincirep = new String[] {"1","2"};
         objSave.setincirep("");
         for (int i = 0; i < rdogrpincirep.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpincirep.getChildAt(i);
             if (rb.isChecked()) objSave.setincirep(d_rdogrpincirep[i]);
         }

         objSave.setincident(txtincident.getText().toString());
         objSave.setinciformsl(txtinciformsl.getText().toString());
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
             C.SaveDT("Update Registration set StatusObj='1',Upload='2',modifyDate='"+ Global.DateTimeNowYMDHMS() +"' where CountryCode='" + COUNTRYCODE + "' and FaciCode='" + FACICODE + "' and DataId='" + DATAID + "'");

             Intent returnIntent = new Intent();
             returnIntent.putExtra("res", "");
             setResult(Activity.RESULT_OK, returnIntent);

             Connection.MessageBox(KMC_Outcome.this, "Saved Successfully");
         }
         else{
             Connection.MessageBox(KMC_Outcome.this, status);
             return;
         }
     }
     catch(Exception  e)
     {
         Connection.MessageBox(KMC_Outcome.this, e.getMessage());
         return;
     }
 }

 public void DataSearch(String CountryCode, String FaciCode, String DataID)
     {
       try
        {
     
           RadioButton rb;
           KMC_Outcome_DataModel d = new KMC_Outcome_DataModel();
           String SQL = "Select * from "+ TableName +"  Where CountryCode='"+ CountryCode +"' and FaciCode='"+ FaciCode +"' and DataID='"+ DataID +"'";
           List<KMC_Outcome_DataModel> data = d.SelectAll(this, SQL);
           for(KMC_Outcome_DataModel item : data){
             txtCountryCode.setText(item.getCountryCode());
             txtFaciCode.setText(item.getFaciCode());
             txtDataID.setText(item.getDataID());
             String[] d_rdogrpbabycond = new String[] {"1","2","3"};
             for (int i = 0; i < d_rdogrpbabycond.length; i++)
             {
                 if (item.getbabycond().equals(String.valueOf(d_rdogrpbabycond[i])))
                 {
                     rb = (RadioButton)rdogrpbabycond.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             dtpdeathdt.setText(item.getdeathdt().toString().length()==0 ? "" : Global.DateConvertDMY(item.getdeathdt()));
             txtdeathtm.setText(item.getdeathtm());
             if(item.getdeathtmdk().equals("1"))
             {
                chkdeathtmdk.setChecked(true);
             }
             else if(item.getdeathtmdk().equals("2"))
             {
                chkdeathtmdk.setChecked(false);
             }
             dtpdiscdt.setText(item.getdiscdt().toString().length()==0 ? "" : Global.DateConvertDMY(item.getdiscdt()));
             txtdisctm.setText(item.getdisctm());
             if(item.getdisctmdk().equals("1"))
             {
                chkdisctmdk.setChecked(true);
             }
             else if(item.getdisctmdk().equals("2"))
             {
                chkdisctmdk.setChecked(false);
             }
             txtdiscweight.setText(item.getdiscweight());
             if(item.getdiscweightdk().equals("1"))
             {
                chkdiscweightdk.setChecked(true);
             }
             else if(item.getdiscweightdk().equals("2"))
             {
                chkdiscweightdk.setChecked(false);
             }
             String[] d_rdogrpdiscto = new String[] {"1","2","3","4"};
             for (int i = 0; i < d_rdogrpdiscto.length; i++)
             {
                 if (item.getdiscto().equals(String.valueOf(d_rdogrpdiscto[i])))
                 {
                     rb = (RadioButton)rdogrpdiscto.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtdisctooth.setText(item.getdisctooth());
             String[] d_rdogrpmotcond = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpmotcond.length; i++)
             {
                 if (item.getmotcond().equals(String.valueOf(d_rdogrpmotcond[i])))
                 {
                     rb = (RadioButton)rdogrpmotcond.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpmotdiscto = new String[] {"1","2","3","4"};
             for (int i = 0; i < d_rdogrpmotdiscto.length; i++)
             {
                 if (item.getmotdiscto().equals(String.valueOf(d_rdogrpmotdiscto[i])))
                 {
                     rb = (RadioButton)rdogrpmotdiscto.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtmotdisctooth.setText(item.getmotdisctooth());
             String[] d_rdogrpobjstatus = new String[] {"1","2","3"};
             for (int i = 0; i < d_rdogrpobjstatus.length; i++)
             {
                 if (item.getobjstatus().equals(String.valueOf(d_rdogrpobjstatus[i])))
                 {
                     rb = (RadioButton)rdogrpobjstatus.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpwhyincom = new String[] {"1","2","3","4"};
             for (int i = 0; i < d_rdogrpwhyincom.length; i++)
             {
                 if (item.getwhyincom().equals(String.valueOf(d_rdogrpwhyincom[i])))
                 {
                     rb = (RadioButton)rdogrpwhyincom.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtreason.setText(item.getreason());
             String[] d_rdogrpincirep = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpincirep.length; i++)
             {
                 if (item.getincirep().equals(String.valueOf(d_rdogrpincirep[i])))
                 {
                     rb = (RadioButton)rdogrpincirep.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtincident.setText(item.getincident());
             txtinciformsl.setText(item.getinciformsl());
           }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(KMC_Outcome.this, e.getMessage());
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


              dtpDate = (EditText)findViewById(R.id.dtpdeathdt);
             if (VariableID.equals("btndeathdt"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpdeathdt);
              }
             else if (VariableID.equals("btndiscdt"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpdiscdt);
              }
      dtpDate.setText(new StringBuilder()
      .append(Global.Right("00"+mDay,2)).append("/")
      .append(Global.Right("00"+mMonth,2)).append("/")
      .append(mYear));
      }
  };

 private TimePickerDialog.OnTimeSetListener timePickerListener = new TimePickerDialog.OnTimeSetListener() {
    public void onTimeSet(TimePicker view, int selectedHour, int selectedMinute) {
       hour = selectedHour; minute = selectedMinute;
       EditText tpTime;


              tpTime = (EditText)findViewById(R.id.txtdeathtm);
             if (VariableID.equals("btndeathtm"))
              {
                  tpTime = (EditText)findViewById(R.id.txtdeathtm);
              }
             else if (VariableID.equals("btndisctm"))
              {
                  tpTime = (EditText)findViewById(R.id.txtdisctm);
              }
          tpTime.setText(new StringBuilder().append(Global.Right("00"+hour,2)).append(":").append(Global.Right("00"+minute,2)));

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