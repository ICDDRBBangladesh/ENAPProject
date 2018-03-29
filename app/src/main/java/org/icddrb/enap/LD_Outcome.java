
 package org.icddrb.enap;


 //Android Manifest Code
 //<activity android:name=".LD_Outcome" android:label="LD_Outcome" />
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
 import android.text.Html;
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

 public class LD_Outcome extends Activity {
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
         LinearLayout secmotcond;
         View linemotcond;
         TextView Vlblmotcond;
         RadioGroup rdogrpmotcond;
         
         RadioButton rdomotcond1;
         RadioButton rdomotcond2;
         RadioButton rdomotcond3;
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
         LinearLayout secdiscto;
         View linediscto;
         TextView Vlbldiscto;
         RadioGroup rdogrpdiscto;
         
         RadioButton rdodiscto1;
         RadioButton rdodiscto2;
         RadioButton rdodiscto3;
         RadioButton rdodiscto4;
         RadioButton rdodiscto5;
         LinearLayout secdisctooth;
         View linedisctooth;
         TextView Vlbldisctooth;
         EditText txtdisctooth;
         LinearLayout seclblc1;
         View linelblc1;
         LinearLayout secc1cond;
         View linec1cond;
         TextView Vlblc1cond;
         RadioGroup rdogrpc1cond;
         
         RadioButton rdoc1cond1;
         RadioButton rdoc1cond2;
         RadioButton rdoc1cond3;
         RadioButton rdoc1cond4;
         RadioButton rdoc1cond5;
         RadioButton rdoc1cond6;

         LinearLayout secc1deathdt;
         View linec1deathdt;
         TextView Vlblc1deathdt;
         EditText dtpc1deathdt;
         LinearLayout secc1deathtm;
         View linec1deathtm;
         TextView Vlblc1deathtm;
         EditText txtc1deathtm;
         LinearLayout secc1deathdk;
         View linec1deathdk;
         TextView Vlblc1deathdk;
         CheckBox chkc1deathdk;
         LinearLayout secc1transto;
         View linec1transto;
         TextView Vlblc1transto;
         RadioGroup rdogrpc1transto;
         
         RadioButton rdoc1transto1;
         RadioButton rdoc1transto2;
         RadioButton rdoc1transto3;
         RadioButton rdoc1transto4;
         LinearLayout secc1transtooth;
         View linec1transtooth;
         TextView Vlblc1transtooth;
         EditText txtc1transtooth;
         LinearLayout secc1hospregno;
         View linec1hospregno;
         TextView Vlblc1hospregno;
         EditText txtc1hospregno;
         LinearLayout seclblc2;
         View linelblc2;
         LinearLayout secc2cond;
         View linec2cond;
         TextView Vlblc2cond;
         RadioGroup rdogrpc2cond;
         
         RadioButton rdoc2cond1;
         RadioButton rdoc2cond2;
         RadioButton rdoc2cond3;
         RadioButton rdoc2cond4;
         RadioButton rdoc2cond5;
     RadioButton rdoc2cond6;
         LinearLayout secc2deathdt;
         View linec2deathdt;
         TextView Vlblc2deathdt;
         EditText dtpc2deathdt;
         LinearLayout secc2deathtm;
         View linec2deathtm;
         TextView Vlblc2deathtm;
         EditText txtc2deathtm;
         LinearLayout secc2deathdk;
         View linec2deathdk;
         TextView Vlblc2deathdk;
         CheckBox chkc2deathdk;
         LinearLayout secc2transto;
         View linec2transto;
         TextView Vlblc2transto;
         RadioGroup rdogrpc2transto;
         
         RadioButton rdoc2transto1;
         RadioButton rdoc2transto2;
         RadioButton rdoc2transto3;
         RadioButton rdoc2transto4;
         LinearLayout secc2transtooth;
         View linec2transtooth;
         TextView Vlblc2transtooth;
         EditText txtc2transtooth;
         LinearLayout secc2hospregno;
         View linec2hospregno;
         TextView Vlblc2hospregno;
         EditText txtc2hospregno;
         LinearLayout seclblc3;
         View linelblc3;
         LinearLayout secc3cond;
         View linec3cond;
         TextView Vlblc3cond;
         RadioGroup rdogrpc3cond;
         
         RadioButton rdoc3cond1;
         RadioButton rdoc3cond2;
         RadioButton rdoc3cond3;
         RadioButton rdoc3cond4;
         RadioButton rdoc3cond5;
     RadioButton rdoc3cond6;
         LinearLayout secc3deathdt;
         View linec3deathdt;
         TextView Vlblc3deathdt;
         EditText dtpc3deathdt;
         LinearLayout secc3deathtm;
         View linec3deathtm;
         TextView Vlblc3deathtm;
         EditText txtc3deathtm;
         LinearLayout secc3deathdk;
         View linec3deathdk;
         TextView Vlblc3deathdk;
         CheckBox chkc3deathdk;
         LinearLayout secc3transto;
         View linec3transto;
         TextView Vlblc3transto;
         RadioGroup rdogrpc3transto;
         
         RadioButton rdoc3transto1;
         RadioButton rdoc3transto2;
         RadioButton rdoc3transto3;
         RadioButton rdoc3transto4;
         LinearLayout secc3transtooth;
         View linec3transtooth;
         TextView Vlblc3transtooth;
         EditText txtc3transtooth;
         LinearLayout secc3hospregno;
         View linec3hospregno;
         TextView Vlblc3hospregno;
         EditText txtc3hospregno;
         LinearLayout seclblh1;
         View linelblh1;
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
    static int totalChild = 1;

 public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
   try
     {
         setContentView(R.layout.ld_outcome);
         C = new Connection(this);
         g = Global.getInstance();

         STARTTIME = g.CurrentTime24();
         DEVICEID  = sp.getValue(this, "deviceid");
         ENTRYUSER = sp.getValue(this, "userid");

         IDbundle = getIntent().getExtras();
         COUNTRYCODE = IDbundle.getString("CountryCode");
         FACICODE = IDbundle.getString("FaciCode");
         DATAID = IDbundle.getString("DataID");

         TableName = "LD_Outcome";

         String CH = C.ReturnSingleValue("Select VarData from Observation where DataId='"+ DATAID +"' and VarName='Numbirth'");
         totalChild = Integer.parseInt(CH.length()==0?"1":CH);

         //turnGPSOn();

         //GPS Location
         //FindLocation();
         // Double.toString(currentLatitude);
         // Double.toString(currentLongitude);
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(LD_Outcome.this);
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
         secmotcond=(LinearLayout)findViewById(R.id.secmotcond);
         linemotcond=(View)findViewById(R.id.linemotcond);
         Vlblmotcond = (TextView) findViewById(R.id.Vlblmotcond);
         rdogrpmotcond = (RadioGroup) findViewById(R.id.rdogrpmotcond);
         
         rdomotcond1 = (RadioButton) findViewById(R.id.rdomotcond1);
         rdomotcond2 = (RadioButton) findViewById(R.id.rdomotcond2);
         rdomotcond3 = (RadioButton) findViewById(R.id.rdomotcond3);
         rdogrpmotcond.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpmotcond = new String[] {"1","2","3"};
             for (int i = 0; i < rdogrpmotcond.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpmotcond.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpmotcond[i];
             }

             if(rbData.equalsIgnoreCase("3"))
             {
                    secdiscdt.setVisibility(View.GONE);
                    linediscdt.setVisibility(View.GONE);
                    dtpdiscdt.setText("");
                    secdisctm.setVisibility(View.GONE);
                    linedisctm.setVisibility(View.GONE);
                    txtdisctm.setText("");
                    secdisctmdk.setVisibility(View.GONE);
                    linedisctmdk.setVisibility(View.GONE);
                    chkdisctmdk.setChecked(false);

                    secdiscto.setVisibility(View.GONE);
                    linediscto.setVisibility(View.GONE);
                    rdogrpdiscto.clearCheck();
                    secdisctooth.setVisibility(View.GONE);
                    linedisctooth.setVisibility(View.GONE);
                    txtdisctooth.setText("");

                    seclblc1.setVisibility(View.GONE);
                    linelblc1.setVisibility(View.GONE);
                    secc1cond.setVisibility(View.GONE);
                    linec1cond.setVisibility(View.GONE);
                    rdogrpc1cond.clearCheck();
                    secc1deathdt.setVisibility(View.GONE);
                    linec1deathdt.setVisibility(View.GONE);
                    dtpc1deathdt.setText("");
                    secc1deathtm.setVisibility(View.GONE);
                    linec1deathtm.setVisibility(View.GONE);
                    txtc1deathtm.setText("");
                    secc1deathdk.setVisibility(View.GONE);
                    //linec1deathdk.setVisibility(View.GONE);
                    chkc1deathdk.setChecked(false);
                    secc1transto.setVisibility(View.GONE);
                    //linec1transto.setVisibility(View.GONE);
                    rdogrpc1transto.clearCheck();
                    secc1transtooth.setVisibility(View.GONE);
                    linec1transtooth.setVisibility(View.GONE);
                    txtc1transtooth.setText("");
                    secc1hospregno.setVisibility(View.GONE);
                    linec1hospregno.setVisibility(View.GONE);
                    txtc1hospregno.setText("");

                    seclblc2.setVisibility(View.GONE);
                    linelblc2.setVisibility(View.GONE);
                    secc2cond.setVisibility(View.GONE);
                    linec2cond.setVisibility(View.GONE);
                    //rdogrpc2cond.clearCheck();
                    secc2deathdt.setVisibility(View.GONE);
                    linec2deathdt.setVisibility(View.GONE);
                    dtpc2deathdt.setText("");
                    secc2deathtm.setVisibility(View.GONE);
                    linec2deathtm.setVisibility(View.GONE);
                    txtc2deathtm.setText("");
                    secc2deathdk.setVisibility(View.GONE);
                    linec2deathdk.setVisibility(View.GONE);
                    chkc2deathdk.setChecked(false);
                    secc2transto.setVisibility(View.GONE);
                    linec2transto.setVisibility(View.GONE);
                    rdogrpc2transto.clearCheck();
                    secc2transtooth.setVisibility(View.GONE);
                    linec2transtooth.setVisibility(View.GONE);
                    txtc2transtooth.setText("");
                    secc2hospregno.setVisibility(View.GONE);
                    linec2hospregno.setVisibility(View.GONE);
                    txtc2hospregno.setText("");

                    seclblc3.setVisibility(View.GONE);
                    linelblc3.setVisibility(View.GONE);
                    secc3cond.setVisibility(View.GONE);
                    linec3cond.setVisibility(View.GONE);
                    rdogrpc3cond.clearCheck();
                    secc3deathdt.setVisibility(View.GONE);
                    linec3deathdt.setVisibility(View.GONE);
                    dtpc3deathdt.setText("");
                    secc3deathtm.setVisibility(View.GONE);
                    linec3deathtm.setVisibility(View.GONE);
                    txtc3deathtm.setText("");
                    secc3deathdk.setVisibility(View.GONE);
                    linec3deathdk.setVisibility(View.GONE);
                    chkc3deathdk.setChecked(false);
                    secc3transto.setVisibility(View.GONE);
                    linec3transto.setVisibility(View.GONE);
                    rdogrpc3transto.clearCheck();
                    secc3transtooth.setVisibility(View.GONE);
                    linec3transtooth.setVisibility(View.GONE);
                    txtc3transtooth.setText("");
                    secc3hospregno.setVisibility(View.GONE);
                    linec3hospregno.setVisibility(View.GONE);
                    txtc3hospregno.setText("");
             }
             else if(rbData.equalsIgnoreCase("2"))
             {
                 secdiscdt.setVisibility(View.GONE);
                 linediscdt.setVisibility(View.GONE);
                 dtpdiscdt.setText("");
                 secdisctm.setVisibility(View.GONE);
                 txtdisctm.setText("");
                 //linedisctm.setVisibility(View.VISIBLE);
                 secdisctmdk.setVisibility(View.GONE);
                 linedisctmdk.setVisibility(View.GONE);

                 secdiscto.setVisibility(View.GONE);
                 linediscto.setVisibility(View.GONE);
                 rdogrpdiscto.clearCheck();
                 //secdisctooth.setVisibility(View.VISIBLE);
                 //linedisctooth.setVisibility(View.VISIBLE);

                 //Child 1
                 seclblc1.setVisibility(View.VISIBLE);
                 linelblc1.setVisibility(View.VISIBLE);
                 secc1cond.setVisibility(View.VISIBLE);
                 linec1cond.setVisibility(View.VISIBLE);
                 secc1deathdt.setVisibility(View.VISIBLE);
                 linec1deathdt.setVisibility(View.VISIBLE);
                 secc1deathtm.setVisibility(View.VISIBLE);
                 linec1deathtm.setVisibility(View.VISIBLE);
                 secc1deathdk.setVisibility(View.VISIBLE);
                 linec1deathdk.setVisibility(View.VISIBLE);
                 secc1transto.setVisibility(View.VISIBLE);
                 linec1transto.setVisibility(View.VISIBLE);
                 linec1hospregno.setVisibility(View.VISIBLE);

                 //Child 2
                 if(totalChild >= 2) {
                     seclblc2.setVisibility(View.VISIBLE);
                     linelblc2.setVisibility(View.VISIBLE);
                     secc2cond.setVisibility(View.VISIBLE);
                     linec2cond.setVisibility(View.VISIBLE);
                     secc2deathdt.setVisibility(View.VISIBLE);
                     linec2deathdt.setVisibility(View.VISIBLE);
                     secc2deathtm.setVisibility(View.VISIBLE);
                     linec2deathtm.setVisibility(View.VISIBLE);
                     secc2deathdk.setVisibility(View.VISIBLE);
                     linec2deathdk.setVisibility(View.VISIBLE);
                     secc2transto.setVisibility(View.VISIBLE);
                     linec2transto.setVisibility(View.VISIBLE);
                     linec2hospregno.setVisibility(View.VISIBLE);
                 }

                 //Child 3
                 if(totalChild==3) {
                     seclblc3.setVisibility(View.VISIBLE);
                     linelblc3.setVisibility(View.VISIBLE);
                     secc3cond.setVisibility(View.VISIBLE);
                     linec3cond.setVisibility(View.VISIBLE);
                     secc3deathdt.setVisibility(View.VISIBLE);
                     linec3deathdt.setVisibility(View.VISIBLE);
                     secc3deathtm.setVisibility(View.VISIBLE);
                     linec3deathtm.setVisibility(View.VISIBLE);
                     secc3deathdk.setVisibility(View.VISIBLE);
                     linec3deathdk.setVisibility(View.VISIBLE);
                     secc3transto.setVisibility(View.VISIBLE);
                     linec3transto.setVisibility(View.VISIBLE);
                     linec3hospregno.setVisibility(View.VISIBLE);
                 }
             }
             else if(rbData.equalsIgnoreCase("1"))
             {
                 //Child 1
                 secdiscdt.setVisibility(View.VISIBLE);
                 linediscdt.setVisibility(View.VISIBLE);
                 secdisctm.setVisibility(View.VISIBLE);
                 secdisctmdk.setVisibility(View.VISIBLE);
                 linedisctmdk.setVisibility(View.VISIBLE);

                 secdiscto.setVisibility(View.VISIBLE);
                 linediscto.setVisibility(View.VISIBLE);
                 seclblc1.setVisibility(View.VISIBLE);
                 linelblc1.setVisibility(View.VISIBLE);
                 secc1cond.setVisibility(View.VISIBLE);

                 //Child 2
                 if(totalChild >= 2) {
                     seclblc2.setVisibility(View.VISIBLE);
                     linelblc2.setVisibility(View.VISIBLE);
                     secc2cond.setVisibility(View.VISIBLE);
                     /*linec2cond.setVisibility(View.VISIBLE);
                     secc2deathdt.setVisibility(View.VISIBLE);
                     linec2deathdt.setVisibility(View.VISIBLE);
                     secc2deathtm.setVisibility(View.VISIBLE);
                     linec2deathtm.setVisibility(View.VISIBLE);
                     secc2deathdk.setVisibility(View.VISIBLE);
                     linec2deathdk.setVisibility(View.VISIBLE);
                     secc2transto.setVisibility(View.VISIBLE);
                     linec2transto.setVisibility(View.VISIBLE);
                     linec2hospregno.setVisibility(View.VISIBLE);*/
                 }

                 //Child 3
                 if(totalChild==3) {
                     seclblc3.setVisibility(View.VISIBLE);
                     linelblc3.setVisibility(View.VISIBLE);
                     secc3cond.setVisibility(View.VISIBLE);
                     linec3cond.setVisibility(View.VISIBLE);
                     /*secc3deathdt.setVisibility(View.VISIBLE);
                     linec3deathdt.setVisibility(View.VISIBLE);
                     secc3deathtm.setVisibility(View.VISIBLE);
                     linec3deathtm.setVisibility(View.VISIBLE);
                     secc3deathdk.setVisibility(View.VISIBLE);
                     linec3deathdk.setVisibility(View.VISIBLE);
                     secc3transto.setVisibility(View.VISIBLE);
                     linec3transto.setVisibility(View.VISIBLE);
                     linec3hospregno.setVisibility(View.VISIBLE);*/
                 }
             }
             else
             {
                    secdiscdt.setVisibility(View.VISIBLE);
                    linediscdt.setVisibility(View.VISIBLE);
                    secdisctm.setVisibility(View.VISIBLE);
                    secdisctmdk.setVisibility(View.VISIBLE);
                    linedisctmdk.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         });

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
         secdiscto=(LinearLayout)findViewById(R.id.secdiscto);
         linediscto=(View)findViewById(R.id.linediscto);
         Vlbldiscto = (TextView) findViewById(R.id.Vlbldiscto);
         rdogrpdiscto = (RadioGroup) findViewById(R.id.rdogrpdiscto);
         
         rdodiscto1 = (RadioButton) findViewById(R.id.rdodiscto1);
         rdodiscto2 = (RadioButton) findViewById(R.id.rdodiscto2);
         rdodiscto3 = (RadioButton) findViewById(R.id.rdodiscto3);
         rdodiscto4 = (RadioButton) findViewById(R.id.rdodiscto4);
         rdodiscto5 = (RadioButton) findViewById(R.id.rdodiscto5);
         secdisctooth=(LinearLayout)findViewById(R.id.secdisctooth);
         linedisctooth=(View)findViewById(R.id.linedisctooth);
         Vlbldisctooth=(TextView) findViewById(R.id.Vlbldisctooth);
         txtdisctooth=(EditText) findViewById(R.id.txtdisctooth);
         seclblc1=(LinearLayout)findViewById(R.id.seclblc1);
         linelblc1=(View)findViewById(R.id.linelblc1);
         secc1cond=(LinearLayout)findViewById(R.id.secc1cond);
         linec1cond=(View)findViewById(R.id.linec1cond);
         Vlblc1cond = (TextView) findViewById(R.id.Vlblc1cond);
         rdogrpc1cond = (RadioGroup) findViewById(R.id.rdogrpc1cond);
         
         rdoc1cond1 = (RadioButton) findViewById(R.id.rdoc1cond1);
         rdoc1cond2 = (RadioButton) findViewById(R.id.rdoc1cond2);
         rdoc1cond3 = (RadioButton) findViewById(R.id.rdoc1cond3);
         rdoc1cond4 = (RadioButton) findViewById(R.id.rdoc1cond4);
         rdoc1cond5 = (RadioButton) findViewById(R.id.rdoc1cond5);
         rdoc1cond6 = (RadioButton) findViewById(R.id.rdoc1cond6);
         rdogrpc1cond.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpc1cond = new String[] {"1","2","3","4","5","6"};
             for (int i = 0; i < rdogrpc1cond.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpc1cond.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpc1cond[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                    secc1deathdt.setVisibility(View.GONE);
                    linec1deathdt.setVisibility(View.GONE);
                    dtpc1deathdt.setText("");
                    secc1deathtm.setVisibility(View.GONE);
                    linec1deathtm.setVisibility(View.GONE);
                    txtc1deathtm.setText("");
                    secc1deathdk.setVisibility(View.GONE);
                    //linec1deathdk.setVisibility(View.GONE);
                    chkc1deathdk.setChecked(false);

                 secc1transto.setVisibility(View.VISIBLE);
                 linec1transto.setVisibility(View.VISIBLE);
                 //secc1hospregno.setVisibility(View.VISIBLE);
                 //linec1hospregno.setVisibility(View.VISIBLE);
             }
             else if(rbData.equalsIgnoreCase("5"))
             {
                 secc1deathdt.setVisibility(View.VISIBLE);
                 linec1deathdt.setVisibility(View.VISIBLE);

                 secc1deathtm.setVisibility(View.VISIBLE);
                 linec1deathtm.setVisibility(View.VISIBLE);

                 secc1deathdk.setVisibility(View.VISIBLE);
                 linec1deathdk.setVisibility(View.VISIBLE);

                 secc1transto.setVisibility(View.GONE);
                 linec1transto.setVisibility(View.GONE);
                 //secc1hospregno.setVisibility(View.VISIBLE);
                 //linec1hospregno.setVisibility(View.VISIBLE);
             }
             else if(rbData.equalsIgnoreCase("2"))
             {
                    secc1deathdt.setVisibility(View.GONE);
                    linec1deathdt.setVisibility(View.GONE);
                    dtpc1deathdt.setText("");
                    secc1deathtm.setVisibility(View.GONE);
                    linec1deathtm.setVisibility(View.GONE);
                    txtc1deathtm.setText("");
                    secc1deathdk.setVisibility(View.GONE);
                    //linec1deathdk.setVisibility(View.GONE);
                    chkc1deathdk.setChecked(false);
                    secc1transto.setVisibility(View.GONE);
                    linec1transto.setVisibility(View.GONE);
                    rdogrpc1transto.clearCheck();

                    secc1transtooth.setVisibility(View.GONE);
                    linec1transtooth.setVisibility(View.GONE);
                    txtc1transtooth.setText("");
                    secc1hospregno.setVisibility(View.GONE);
                    linec1hospregno.setVisibility(View.GONE);
                    txtc1hospregno.setText("");
                    /*seclblc2.setVisibility(View.GONE);
                    linelblc2.setVisibility(View.GONE);
                    secc2cond.setVisibility(View.GONE);
                    linec2cond.setVisibility(View.GONE);
                    rdogrpc2cond.clearCheck();
                    secc2deathdt.setVisibility(View.GONE);
                    linec2deathdt.setVisibility(View.GONE);
                    dtpc2deathdt.setText("");
                    secc2deathtm.setVisibility(View.GONE);
                    linec2deathtm.setVisibility(View.GONE);
                    txtc2deathtm.setText("");
                    secc2deathdk.setVisibility(View.GONE);
                    linec2deathdk.setVisibility(View.GONE);
                    chkc2deathdk.setChecked(false);
                    secc2transto.setVisibility(View.GONE);
                    linec2transto.setVisibility(View.GONE);
                    rdogrpc2transto.clearCheck();
                    secc2transtooth.setVisibility(View.GONE);
                    linec2transtooth.setVisibility(View.GONE);
                    txtc2transtooth.setText("");
                    secc2hospregno.setVisibility(View.GONE);
                    linec2hospregno.setVisibility(View.GONE);
                    txtc2hospregno.setText("");
                    seclblc3.setVisibility(View.GONE);
                    linelblc3.setVisibility(View.GONE);
                    secc3cond.setVisibility(View.GONE);
                    linec3cond.setVisibility(View.GONE);
                    rdogrpc3cond.clearCheck();
                    secc3deathdt.setVisibility(View.GONE);
                    linec3deathdt.setVisibility(View.GONE);
                    dtpc3deathdt.setText("");
                    secc3deathtm.setVisibility(View.GONE);
                    linec3deathtm.setVisibility(View.GONE);
                    txtc3deathtm.setText("");
                    secc3deathdk.setVisibility(View.GONE);
                    linec3deathdk.setVisibility(View.GONE);
                    chkc3deathdk.setChecked(false);
                    secc3transto.setVisibility(View.GONE);
                    linec3transto.setVisibility(View.GONE);
                    rdogrpc3transto.clearCheck();
                    secc3transtooth.setVisibility(View.GONE);
                    linec3transtooth.setVisibility(View.GONE);
                    txtc3transtooth.setText("");
                    secc3hospregno.setVisibility(View.GONE);
                    linec3hospregno.setVisibility(View.GONE);
                    txtc3hospregno.setText("");*/
             }
             else if(rbData.equalsIgnoreCase("3"))
             {
                    secc1deathdt.setVisibility(View.GONE);
                    linec1deathdt.setVisibility(View.GONE);
                    dtpc1deathdt.setText("");
                    secc1deathtm.setVisibility(View.GONE);
                    linec1deathtm.setVisibility(View.GONE);
                    txtc1deathtm.setText("");
                    secc1deathdk.setVisibility(View.GONE);
                    //linec1deathdk.setVisibility(View.GONE);
                    chkc1deathdk.setChecked(false);
                    secc1transto.setVisibility(View.GONE);
                    linec1transto.setVisibility(View.GONE);
                    rdogrpc1transto.clearCheck();
                    secc1transtooth.setVisibility(View.GONE);
                    linec1transtooth.setVisibility(View.GONE);
                    txtc1transtooth.setText("");
                    secc1hospregno.setVisibility(View.GONE);
                    linec1hospregno.setVisibility(View.GONE);
                    txtc1hospregno.setText("");
                    /*seclblc2.setVisibility(View.GONE);
                    linelblc2.setVisibility(View.GONE);
                    secc2cond.setVisibility(View.GONE);
                    linec2cond.setVisibility(View.GONE);
                    rdogrpc2cond.clearCheck();
                    secc2deathdt.setVisibility(View.GONE);
                    linec2deathdt.setVisibility(View.GONE);
                    dtpc2deathdt.setText("");
                    secc2deathtm.setVisibility(View.GONE);
                    linec2deathtm.setVisibility(View.GONE);
                    txtc2deathtm.setText("");
                    secc2deathdk.setVisibility(View.GONE);
                    linec2deathdk.setVisibility(View.GONE);
                    chkc2deathdk.setChecked(false);
                    secc2transto.setVisibility(View.GONE);
                    linec2transto.setVisibility(View.GONE);
                    rdogrpc2transto.clearCheck();
                    secc2transtooth.setVisibility(View.GONE);
                    linec2transtooth.setVisibility(View.GONE);
                    txtc2transtooth.setText("");
                    secc2hospregno.setVisibility(View.GONE);
                    linec2hospregno.setVisibility(View.GONE);
                    txtc2hospregno.setText("");
                    seclblc3.setVisibility(View.GONE);
                    linelblc3.setVisibility(View.GONE);
                    secc3cond.setVisibility(View.GONE);
                    linec3cond.setVisibility(View.GONE);
                    rdogrpc3cond.clearCheck();
                    secc3deathdt.setVisibility(View.GONE);
                    linec3deathdt.setVisibility(View.GONE);
                    dtpc3deathdt.setText("");
                    secc3deathtm.setVisibility(View.GONE);
                    linec3deathtm.setVisibility(View.GONE);
                    txtc3deathtm.setText("");
                    secc3deathdk.setVisibility(View.GONE);
                    linec3deathdk.setVisibility(View.GONE);
                    chkc3deathdk.setChecked(false);
                    secc3transto.setVisibility(View.GONE);
                    linec3transto.setVisibility(View.GONE);
                    rdogrpc3transto.clearCheck();
                    secc3transtooth.setVisibility(View.GONE);
                    linec3transtooth.setVisibility(View.GONE);
                    txtc3transtooth.setText("");
                    secc3hospregno.setVisibility(View.GONE);
                    linec3hospregno.setVisibility(View.GONE);
                    txtc3hospregno.setText("");*/
             }
             else if(rbData.equalsIgnoreCase("6"))
             {
                    secc1deathdt.setVisibility(View.GONE);
                    linec1deathdt.setVisibility(View.GONE);
                    dtpc1deathdt.setText("");
                    secc1deathtm.setVisibility(View.GONE);
                    linec1deathtm.setVisibility(View.GONE);
                    txtc1deathtm.setText("");
                    secc1deathdk.setVisibility(View.GONE);
                    //linec1deathdk.setVisibility(View.GONE);
                    chkc1deathdk.setChecked(false);
                    secc1transto.setVisibility(View.GONE);
                    linec1transto.setVisibility(View.GONE);
                    rdogrpc1transto.clearCheck();
                    secc1transtooth.setVisibility(View.GONE);
                    linec1transtooth.setVisibility(View.GONE);
                    txtc1transtooth.setText("");
                    secc1hospregno.setVisibility(View.GONE);
                    linec1hospregno.setVisibility(View.GONE);
                    txtc1hospregno.setText("");
                    /*seclblc2.setVisibility(View.GONE);
                    linelblc2.setVisibility(View.GONE);
                    secc2cond.setVisibility(View.GONE);
                    linec2cond.setVisibility(View.GONE);
                    rdogrpc2cond.clearCheck();
                    secc2deathdt.setVisibility(View.GONE);
                    linec2deathdt.setVisibility(View.GONE);
                    dtpc2deathdt.setText("");
                    secc2deathtm.setVisibility(View.GONE);
                    linec2deathtm.setVisibility(View.GONE);
                    txtc2deathtm.setText("");
                    secc2deathdk.setVisibility(View.GONE);
                    linec2deathdk.setVisibility(View.GONE);
                    chkc2deathdk.setChecked(false);
                    secc2transto.setVisibility(View.GONE);
                    linec2transto.setVisibility(View.GONE);
                    rdogrpc2transto.clearCheck();
                    secc2transtooth.setVisibility(View.GONE);
                    linec2transtooth.setVisibility(View.GONE);
                    txtc2transtooth.setText("");
                    secc2hospregno.setVisibility(View.GONE);
                    linec2hospregno.setVisibility(View.GONE);
                    txtc2hospregno.setText("");
                    seclblc3.setVisibility(View.GONE);
                    linelblc3.setVisibility(View.GONE);
                    secc3cond.setVisibility(View.GONE);
                    linec3cond.setVisibility(View.GONE);
                    rdogrpc3cond.clearCheck();
                    secc3deathdt.setVisibility(View.GONE);
                    linec3deathdt.setVisibility(View.GONE);
                    dtpc3deathdt.setText("");
                    secc3deathtm.setVisibility(View.GONE);
                    linec3deathtm.setVisibility(View.GONE);
                    txtc3deathtm.setText("");
                    secc3deathdk.setVisibility(View.GONE);
                    linec3deathdk.setVisibility(View.GONE);
                    chkc3deathdk.setChecked(false);
                    secc3transto.setVisibility(View.GONE);
                    linec3transto.setVisibility(View.GONE);
                    rdogrpc3transto.clearCheck();
                    secc3transtooth.setVisibility(View.GONE);
                    linec3transtooth.setVisibility(View.GONE);
                    txtc3transtooth.setText("");
                    secc3hospregno.setVisibility(View.GONE);
                    linec3hospregno.setVisibility(View.GONE);
                    txtc3hospregno.setText("");*/
             }
             else
             {
                    /*secc1deathdt.setVisibility(View.VISIBLE);
                    linec1deathdt.setVisibility(View.VISIBLE);
                    secc1deathtm.setVisibility(View.VISIBLE);
                    //linec1deathtm.setVisibility(View.VISIBLE);
                    secc1deathdk.setVisibility(View.VISIBLE);
                    linec1deathdk.setVisibility(View.VISIBLE);
                    secc1transto.setVisibility(View.VISIBLE);
                    linec1transto.setVisibility(View.VISIBLE);
                    secc1transtooth.setVisibility(View.VISIBLE);
                    linec1transtooth.setVisibility(View.VISIBLE);
                    secc1hospregno.setVisibility(View.VISIBLE);
                    linec1hospregno.setVisibility(View.VISIBLE);
                    seclblc2.setVisibility(View.VISIBLE);
                    linelblc2.setVisibility(View.VISIBLE);
                    secc2cond.setVisibility(View.VISIBLE);
                    linec2cond.setVisibility(View.VISIBLE);
                    secc2deathdt.setVisibility(View.VISIBLE);
                    linec2deathdt.setVisibility(View.VISIBLE);
                    secc2deathtm.setVisibility(View.VISIBLE);
                    linec2deathtm.setVisibility(View.VISIBLE);
                    secc2deathdk.setVisibility(View.VISIBLE);
                    linec2deathdk.setVisibility(View.VISIBLE);
                    secc2transto.setVisibility(View.VISIBLE);
                    linec2transto.setVisibility(View.VISIBLE);
                    secc2transtooth.setVisibility(View.VISIBLE);
                    linec2transtooth.setVisibility(View.VISIBLE);
                    secc2hospregno.setVisibility(View.VISIBLE);
                    linec2hospregno.setVisibility(View.VISIBLE);
                    seclblc3.setVisibility(View.VISIBLE);
                    linelblc3.setVisibility(View.VISIBLE);
                    secc3cond.setVisibility(View.VISIBLE);
                    linec3cond.setVisibility(View.VISIBLE);*/

                 secc1deathdt.setVisibility(View.GONE);
                 linec1deathdt.setVisibility(View.GONE);
                 dtpc1deathdt.setText("");
                 secc1deathtm.setVisibility(View.GONE);
                 linec1deathtm.setVisibility(View.GONE);
                 txtc1deathtm.setText("");
                 secc1deathdk.setVisibility(View.GONE);
                 //linec1deathdk.setVisibility(View.GONE);
                 chkc1deathdk.setChecked(false);
                 secc1transto.setVisibility(View.GONE);
                 linec1transto.setVisibility(View.GONE);
                 rdogrpc1transto.clearCheck();
                 secc1transtooth.setVisibility(View.GONE);
                 linec1transtooth.setVisibility(View.GONE);
                 txtc1transtooth.setText("");
                 secc1hospregno.setVisibility(View.GONE);
                 linec1hospregno.setVisibility(View.GONE);
                 txtc1hospregno.setText("");
                 /*seclblc2.setVisibility(View.GONE);
                 linelblc2.setVisibility(View.GONE);
                 secc2cond.setVisibility(View.GONE);
                 linec2cond.setVisibility(View.GONE);
                 rdogrpc2cond.clearCheck();
                 secc2deathdt.setVisibility(View.GONE);
                 linec2deathdt.setVisibility(View.GONE);
                 dtpc2deathdt.setText("");
                 secc2deathtm.setVisibility(View.GONE);
                 linec2deathtm.setVisibility(View.GONE);
                 txtc2deathtm.setText("");
                 secc2deathdk.setVisibility(View.GONE);
                 linec2deathdk.setVisibility(View.GONE);
                 chkc2deathdk.setChecked(false);
                 secc2transto.setVisibility(View.GONE);
                 linec2transto.setVisibility(View.GONE);
                 rdogrpc2transto.clearCheck();
                 secc2transtooth.setVisibility(View.GONE);
                 linec2transtooth.setVisibility(View.GONE);
                 txtc2transtooth.setText("");
                 secc2hospregno.setVisibility(View.GONE);
                 linec2hospregno.setVisibility(View.GONE);
                 txtc2hospregno.setText("");
                 seclblc3.setVisibility(View.GONE);
                 linelblc3.setVisibility(View.GONE);
                 secc3cond.setVisibility(View.GONE);
                 linec3cond.setVisibility(View.GONE);
                 rdogrpc3cond.clearCheck();
                 secc3deathdt.setVisibility(View.GONE);
                 linec3deathdt.setVisibility(View.GONE);
                 dtpc3deathdt.setText("");
                 secc3deathtm.setVisibility(View.GONE);
                 linec3deathtm.setVisibility(View.GONE);
                 txtc3deathtm.setText("");
                 secc3deathdk.setVisibility(View.GONE);
                 linec3deathdk.setVisibility(View.GONE);
                 chkc3deathdk.setChecked(false);
                 secc3transto.setVisibility(View.GONE);
                 linec3transto.setVisibility(View.GONE);
                 rdogrpc3transto.clearCheck();
                 secc3transtooth.setVisibility(View.GONE);
                 linec3transtooth.setVisibility(View.GONE);
                 txtc3transtooth.setText("");
                 secc3hospregno.setVisibility(View.GONE);
                 linec3hospregno.setVisibility(View.GONE);
                 txtc3hospregno.setText("");*/
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secc1deathdt=(LinearLayout)findViewById(R.id.secc1deathdt);
         linec1deathdt=(View)findViewById(R.id.linec1deathdt);
         Vlblc1deathdt=(TextView) findViewById(R.id.Vlblc1deathdt);
         dtpc1deathdt=(EditText) findViewById(R.id.dtpc1deathdt);
         secc1deathtm=(LinearLayout)findViewById(R.id.secc1deathtm);
         linec1deathtm=(View)findViewById(R.id.linec1deathtm);
         Vlblc1deathtm=(TextView) findViewById(R.id.Vlblc1deathtm);
         txtc1deathtm=(EditText) findViewById(R.id.txtc1deathtm);
         secc1deathdk=(LinearLayout)findViewById(R.id.secc1deathdk);
         linec1deathdk=(View)findViewById(R.id.linec1deathdk);
         Vlblc1deathdk=(TextView) findViewById(R.id.Vlblc1deathdk);
         chkc1deathdk=(CheckBox) findViewById(R.id.chkc1deathdk);
         secc1transto=(LinearLayout)findViewById(R.id.secc1transto);
         linec1transto=(View)findViewById(R.id.linec1transto);
         Vlblc1transto = (TextView) findViewById(R.id.Vlblc1transto);
         rdogrpc1transto = (RadioGroup) findViewById(R.id.rdogrpc1transto);
         
         rdoc1transto1 = (RadioButton) findViewById(R.id.rdoc1transto1);
         rdoc1transto2 = (RadioButton) findViewById(R.id.rdoc1transto2);
         rdoc1transto3 = (RadioButton) findViewById(R.id.rdoc1transto3);
         rdoc1transto4 = (RadioButton) findViewById(R.id.rdoc1transto4);
         secc1transtooth=(LinearLayout)findViewById(R.id.secc1transtooth);
         linec1transtooth=(View)findViewById(R.id.linec1transtooth);
         Vlblc1transtooth=(TextView) findViewById(R.id.Vlblc1transtooth);
         txtc1transtooth=(EditText) findViewById(R.id.txtc1transtooth);
         secc1hospregno=(LinearLayout)findViewById(R.id.secc1hospregno);
         linec1hospregno=(View)findViewById(R.id.linec1hospregno);
         Vlblc1hospregno=(TextView) findViewById(R.id.Vlblc1hospregno);
         txtc1hospregno=(EditText) findViewById(R.id.txtc1hospregno);
         seclblc2=(LinearLayout)findViewById(R.id.seclblc2);
         linelblc2=(View)findViewById(R.id.linelblc2);
         secc2cond=(LinearLayout)findViewById(R.id.secc2cond);
         linec2cond=(View)findViewById(R.id.linec2cond);
         Vlblc2cond = (TextView) findViewById(R.id.Vlblc2cond);
         rdogrpc2cond = (RadioGroup) findViewById(R.id.rdogrpc2cond);
         
         rdoc2cond1 = (RadioButton) findViewById(R.id.rdoc2cond1);
         rdoc2cond2 = (RadioButton) findViewById(R.id.rdoc2cond2);
         rdoc2cond3 = (RadioButton) findViewById(R.id.rdoc2cond3);
         rdoc2cond4 = (RadioButton) findViewById(R.id.rdoc2cond4);
         rdoc2cond5 = (RadioButton) findViewById(R.id.rdoc2cond5);
         rdoc2cond6 = (RadioButton) findViewById(R.id.rdoc2cond6);
         rdogrpc2cond.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpc2cond = new String[] {"1","2","3","4","5","6"};
             for (int i = 0; i < rdogrpc2cond.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpc2cond.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpc2cond[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                 secc2deathdt.setVisibility(View.GONE);
                 linec2deathdt.setVisibility(View.GONE);
                 dtpc2deathdt.setText("");
                 secc2deathtm.setVisibility(View.GONE);
                 linec2deathtm.setVisibility(View.GONE);
                 txtc2deathtm.setText("");
                 secc2deathdk.setVisibility(View.GONE);
                 linec2deathdk.setVisibility(View.GONE);
                 chkc2deathdk.setChecked(false);

                 linec2deathdk.setVisibility(View.VISIBLE);
                 secc2transto.setVisibility(View.VISIBLE);
                 linec2transto.setVisibility(View.VISIBLE);
             }
             else if(rbData.equalsIgnoreCase("2"))
             {
                    secc2deathdt.setVisibility(View.GONE);
                    linec2deathdt.setVisibility(View.GONE);
                    dtpc2deathdt.setText("");
                    secc2deathtm.setVisibility(View.GONE);
                    linec2deathtm.setVisibility(View.GONE);
                    txtc2deathtm.setText("");
                    secc2deathdk.setVisibility(View.GONE);
                    linec2deathdk.setVisibility(View.GONE);
                    chkc2deathdk.setChecked(false);
                    secc2transto.setVisibility(View.GONE);
                    linec2transto.setVisibility(View.GONE);
                    rdogrpc2transto.clearCheck();

                    secc2transtooth.setVisibility(View.GONE);
                    linec2transtooth.setVisibility(View.GONE);
                    txtc2transtooth.setText("");
                    secc2hospregno.setVisibility(View.GONE);
                    linec2hospregno.setVisibility(View.GONE);
                    txtc2hospregno.setText("");
                    /*seclblc3.setVisibility(View.GONE);
                    linelblc3.setVisibility(View.GONE);
                    secc3cond.setVisibility(View.GONE);
                    linec3cond.setVisibility(View.GONE);
                    rdogrpc3cond.clearCheck();
                    secc3deathdt.setVisibility(View.GONE);
                    linec3deathdt.setVisibility(View.GONE);
                    dtpc3deathdt.setText("");
                    secc3deathtm.setVisibility(View.GONE);
                    linec3deathtm.setVisibility(View.GONE);
                    txtc3deathtm.setText("");
                    secc3deathdk.setVisibility(View.GONE);
                    linec3deathdk.setVisibility(View.GONE);
                    chkc3deathdk.setChecked(false);
                    secc3transto.setVisibility(View.GONE);
                    linec3transto.setVisibility(View.GONE);
                    rdogrpc3transto.clearCheck();
                    secc3transtooth.setVisibility(View.GONE);
                    linec3transtooth.setVisibility(View.GONE);
                    txtc3transtooth.setText("");
                    secc3hospregno.setVisibility(View.GONE);
                    linec3hospregno.setVisibility(View.GONE);
                    txtc3hospregno.setText("");*/
             }
             else if(rbData.equalsIgnoreCase("3"))
             {
                    secc2deathdt.setVisibility(View.GONE);
                    linec2deathdt.setVisibility(View.GONE);
                    dtpc2deathdt.setText("");
                    secc2deathtm.setVisibility(View.GONE);
                    linec2deathtm.setVisibility(View.GONE);
                    txtc2deathtm.setText("");
                    secc2deathdk.setVisibility(View.GONE);
                    linec2deathdk.setVisibility(View.GONE);
                    chkc2deathdk.setChecked(false);

                    secc2transto.setVisibility(View.GONE);
                    linec2transto.setVisibility(View.GONE);
                    rdogrpc2transto.clearCheck();
                    secc2transtooth.setVisibility(View.GONE);
                    linec2transtooth.setVisibility(View.GONE);
                    txtc2transtooth.setText("");
                    secc2hospregno.setVisibility(View.GONE);
                    linec2hospregno.setVisibility(View.GONE);
                    txtc2hospregno.setText("");
                    /*seclblc3.setVisibility(View.GONE);
                    linelblc3.setVisibility(View.GONE);
                    secc3cond.setVisibility(View.GONE);
                    linec3cond.setVisibility(View.GONE);
                    rdogrpc3cond.clearCheck();
                    secc3deathdt.setVisibility(View.GONE);
                    linec3deathdt.setVisibility(View.GONE);
                    dtpc3deathdt.setText("");
                    secc3deathtm.setVisibility(View.GONE);
                    linec3deathtm.setVisibility(View.GONE);
                    txtc3deathtm.setText("");
                    secc3deathdk.setVisibility(View.GONE);
                    linec3deathdk.setVisibility(View.GONE);
                    chkc3deathdk.setChecked(false);
                    secc3transto.setVisibility(View.GONE);
                    linec3transto.setVisibility(View.GONE);
                    rdogrpc3transto.clearCheck();
                    secc3transtooth.setVisibility(View.GONE);
                    linec3transtooth.setVisibility(View.GONE);
                    txtc3transtooth.setText("");
                    secc3hospregno.setVisibility(View.GONE);
                    linec3hospregno.setVisibility(View.GONE);
                    txtc3hospregno.setText("");*/
             }else if(rbData.equalsIgnoreCase("5")){
                 secc2deathdt.setVisibility(View.VISIBLE);
                 linec2deathdt.setVisibility(View.VISIBLE);

                 secc2deathtm.setVisibility(View.VISIBLE);
                 linec2deathtm.setVisibility(View.VISIBLE);

                 secc2deathdk.setVisibility(View.VISIBLE);
                 linec2deathdk.setVisibility(View.VISIBLE);

                 secc2transto.setVisibility(View.GONE);
                 linec2transto.setVisibility(View.GONE);
             }
             else if(rbData.equalsIgnoreCase("6"))
             {
                    secc2deathdt.setVisibility(View.GONE);
                    linec2deathdt.setVisibility(View.GONE);
                    dtpc2deathdt.setText("");
                    secc2deathtm.setVisibility(View.GONE);
                    linec2deathtm.setVisibility(View.GONE);
                    txtc2deathtm.setText("");
                    secc2deathdk.setVisibility(View.GONE);
                    linec2deathdk.setVisibility(View.GONE);
                    chkc2deathdk.setChecked(false);
                    secc2transto.setVisibility(View.GONE);
                    linec2transto.setVisibility(View.GONE);
                    rdogrpc2transto.clearCheck();
                    secc2transtooth.setVisibility(View.GONE);
                    linec2transtooth.setVisibility(View.GONE);
                    txtc2transtooth.setText("");
                    secc2hospregno.setVisibility(View.GONE);
                    linec2hospregno.setVisibility(View.GONE);
                    txtc2hospregno.setText("");
                    /*seclblc3.setVisibility(View.GONE);
                    linelblc3.setVisibility(View.GONE);
                    secc3cond.setVisibility(View.GONE);
                    linec3cond.setVisibility(View.GONE);
                    rdogrpc3cond.clearCheck();
                    secc3deathdt.setVisibility(View.GONE);
                    linec3deathdt.setVisibility(View.GONE);
                    dtpc3deathdt.setText("");
                    secc3deathtm.setVisibility(View.GONE);
                    linec3deathtm.setVisibility(View.GONE);
                    txtc3deathtm.setText("");
                    secc3deathdk.setVisibility(View.GONE);
                    linec3deathdk.setVisibility(View.GONE);
                    chkc3deathdk.setChecked(false);
                    secc3transto.setVisibility(View.GONE);
                    linec3transto.setVisibility(View.GONE);
                    rdogrpc3transto.clearCheck();
                    secc3transtooth.setVisibility(View.GONE);
                    linec3transtooth.setVisibility(View.GONE);
                    txtc3transtooth.setText("");
                    secc3hospregno.setVisibility(View.GONE);
                    linec3hospregno.setVisibility(View.GONE);
                    txtc3hospregno.setText("");*/
             }
             else
             {
                    secc2deathdt.setVisibility(View.GONE);
                    linec2deathdt.setVisibility(View.GONE);
                    secc2deathtm.setVisibility(View.GONE);
                    linec2deathtm.setVisibility(View.GONE);
                    secc2deathdk.setVisibility(View.GONE);
                    linec2deathdk.setVisibility(View.GONE);
                    /*secc2transto.setVisibility(View.VISIBLE);
                    linec2transto.setVisibility(View.VISIBLE);
                    secc2transtooth.setVisibility(View.VISIBLE);
                    linec2transtooth.setVisibility(View.VISIBLE);
                    secc2hospregno.setVisibility(View.VISIBLE);
                    linec2hospregno.setVisibility(View.VISIBLE);*/

                    /*seclblc3.setVisibility(View.VISIBLE);
                    linelblc3.setVisibility(View.VISIBLE);
                    secc3cond.setVisibility(View.VISIBLE);
                    linec3cond.setVisibility(View.VISIBLE);*/
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         });


         secc2deathdt=(LinearLayout)findViewById(R.id.secc2deathdt);
         linec2deathdt=(View)findViewById(R.id.linec2deathdt);
         Vlblc2deathdt=(TextView) findViewById(R.id.Vlblc2deathdt);
         dtpc2deathdt=(EditText) findViewById(R.id.dtpc2deathdt);
         secc2deathtm=(LinearLayout)findViewById(R.id.secc2deathtm);
         linec2deathtm=(View)findViewById(R.id.linec2deathtm);
         Vlblc2deathtm=(TextView) findViewById(R.id.Vlblc2deathtm);
         txtc2deathtm=(EditText) findViewById(R.id.txtc2deathtm);
         secc2deathdk=(LinearLayout)findViewById(R.id.secc2deathdk);
         linec2deathdk=(View)findViewById(R.id.linec2deathdk);
         Vlblc2deathdk=(TextView) findViewById(R.id.Vlblc2deathdk);
         chkc2deathdk=(CheckBox) findViewById(R.id.chkc2deathdk);
         secc2transto=(LinearLayout)findViewById(R.id.secc2transto);
         linec2transto=(View)findViewById(R.id.linec2transto);
         Vlblc2transto = (TextView) findViewById(R.id.Vlblc2transto);
         rdogrpc2transto = (RadioGroup) findViewById(R.id.rdogrpc2transto);
         
         rdoc2transto1 = (RadioButton) findViewById(R.id.rdoc2transto1);
         rdoc2transto2 = (RadioButton) findViewById(R.id.rdoc2transto2);
         rdoc2transto3 = (RadioButton) findViewById(R.id.rdoc2transto3);
         rdoc2transto4 = (RadioButton) findViewById(R.id.rdoc2transto4);
         secc2transtooth=(LinearLayout)findViewById(R.id.secc2transtooth);
         linec2transtooth=(View)findViewById(R.id.linec2transtooth);
         Vlblc2transtooth=(TextView) findViewById(R.id.Vlblc2transtooth);
         txtc2transtooth=(EditText) findViewById(R.id.txtc2transtooth);
         secc2hospregno=(LinearLayout)findViewById(R.id.secc2hospregno);
         linec2hospregno=(View)findViewById(R.id.linec2hospregno);
         Vlblc2hospregno=(TextView) findViewById(R.id.Vlblc2hospregno);
         txtc2hospregno=(EditText) findViewById(R.id.txtc2hospregno);
         seclblc3=(LinearLayout)findViewById(R.id.seclblc3);
         linelblc3=(View)findViewById(R.id.linelblc3);
         secc3cond=(LinearLayout)findViewById(R.id.secc3cond);
         linec3cond=(View)findViewById(R.id.linec3cond);
         Vlblc3cond = (TextView) findViewById(R.id.Vlblc3cond);
         rdogrpc3cond = (RadioGroup) findViewById(R.id.rdogrpc3cond);
         
         rdoc3cond1 = (RadioButton) findViewById(R.id.rdoc3cond1);
         rdoc3cond2 = (RadioButton) findViewById(R.id.rdoc3cond2);
         rdoc3cond3 = (RadioButton) findViewById(R.id.rdoc3cond3);
         rdoc3cond4 = (RadioButton) findViewById(R.id.rdoc3cond4);
         rdoc3cond5 = (RadioButton) findViewById(R.id.rdoc3cond5);
         rdoc3cond6 = (RadioButton) findViewById(R.id.rdoc3cond6);
         rdogrpc3cond.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpc3cond = new String[] {"1","2","3","4","5","6"};
             for (int i = 0; i < rdogrpc3cond.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpc3cond.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpc3cond[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                    secc3deathdt.setVisibility(View.GONE);
                    linec3deathdt.setVisibility(View.GONE);
                    dtpc3deathdt.setText("");
                    secc3deathtm.setVisibility(View.GONE);
                    linec3deathtm.setVisibility(View.GONE);
                    txtc3deathtm.setText("");
                    secc3deathdk.setVisibility(View.GONE);
                    linec3deathdk.setVisibility(View.GONE);
                    chkc3deathdk.setChecked(false);
                 linec3deathdk.setVisibility(View.VISIBLE);
                 secc3transto.setVisibility(View.VISIBLE);
             }
             else if(rbData.equalsIgnoreCase("2"))
             {
                    secc3deathdt.setVisibility(View.GONE);
                    linec3deathdt.setVisibility(View.GONE);
                    dtpc3deathdt.setText("");
                    secc3deathtm.setVisibility(View.GONE);
                    linec3deathtm.setVisibility(View.GONE);
                    txtc3deathtm.setText("");
                    secc3deathdk.setVisibility(View.GONE);
                    linec3deathdk.setVisibility(View.GONE);
                    chkc3deathdk.setChecked(false);
                    secc3transto.setVisibility(View.GONE);
                    linec3transto.setVisibility(View.GONE);
                    rdogrpc3transto.clearCheck();
                    secc3transtooth.setVisibility(View.GONE);
                    linec3transtooth.setVisibility(View.GONE);
                    txtc3transtooth.setText("");
                    secc3hospregno.setVisibility(View.GONE);
                    linec3hospregno.setVisibility(View.GONE);
                    txtc3hospregno.setText("");
             }
             else if(rbData.equalsIgnoreCase("3"))
             {
                    secc3deathdt.setVisibility(View.GONE);
                    linec3deathdt.setVisibility(View.GONE);
                    dtpc3deathdt.setText("");
                    secc3deathtm.setVisibility(View.GONE);
                    linec3deathtm.setVisibility(View.GONE);
                    txtc3deathtm.setText("");
                    secc3deathdk.setVisibility(View.GONE);
                    linec3deathdk.setVisibility(View.GONE);
                    chkc3deathdk.setChecked(false);
                    secc3transto.setVisibility(View.GONE);
                    linec3transto.setVisibility(View.GONE);
                    rdogrpc3transto.clearCheck();
                    secc3transtooth.setVisibility(View.GONE);
                    linec3transtooth.setVisibility(View.GONE);
                    txtc3transtooth.setText("");
                    secc3hospregno.setVisibility(View.GONE);
                    linec3hospregno.setVisibility(View.GONE);
                    txtc3hospregno.setText("");
             }
             else if(rbData.equalsIgnoreCase("5"))
             {
                 secc3deathdt.setVisibility(View.VISIBLE);
                 linec3deathdt.setVisibility(View.VISIBLE);

                 secc3deathtm.setVisibility(View.VISIBLE);
                 linec3deathtm.setVisibility(View.VISIBLE);

                 secc3deathdk.setVisibility(View.VISIBLE);
                 linec3deathdk.setVisibility(View.VISIBLE);

                 secc3transto.setVisibility(View.GONE);
                 linec3transto.setVisibility(View.GONE);
                 //secc1hospregno.setVisibility(View.VISIBLE);
                 //linec1hospregno.setVisibility(View.VISIBLE);
             }
             else if(rbData.equalsIgnoreCase("6"))
             {
                    secc3deathdt.setVisibility(View.GONE);
                    linec3deathdt.setVisibility(View.GONE);
                    dtpc3deathdt.setText("");
                    secc3deathtm.setVisibility(View.GONE);
                    linec3deathtm.setVisibility(View.GONE);
                    txtc3deathtm.setText("");
                    secc3deathdk.setVisibility(View.GONE);
                    linec3deathdk.setVisibility(View.GONE);
                    chkc3deathdk.setChecked(false);
                    secc3transto.setVisibility(View.GONE);
                    linec3transto.setVisibility(View.GONE);
                    rdogrpc3transto.clearCheck();
                    secc3transtooth.setVisibility(View.GONE);
                    linec3transtooth.setVisibility(View.GONE);
                    txtc3transtooth.setText("");
                    secc3hospregno.setVisibility(View.GONE);
                    linec3hospregno.setVisibility(View.GONE);
                    txtc3hospregno.setText("");
             }
             else
             {
                    secc3deathdt.setVisibility(View.GONE);
                    linec3deathdt.setVisibility(View.GONE);
                    secc3deathtm.setVisibility(View.GONE);
                    linec3deathtm.setVisibility(View.GONE);
                    secc3deathdk.setVisibility(View.GONE);
                    linec3deathdk.setVisibility(View.GONE);
                    /*secc3transto.setVisibility(View.VISIBLE);
                    linec3transto.setVisibility(View.VISIBLE);
                    secc3transtooth.setVisibility(View.VISIBLE);
                    linec3transtooth.setVisibility(View.VISIBLE);
                    secc3hospregno.setVisibility(View.VISIBLE);
                    linec3hospregno.setVisibility(View.VISIBLE);*/
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secc3deathdt=(LinearLayout)findViewById(R.id.secc3deathdt);
         linec3deathdt=(View)findViewById(R.id.linec3deathdt);
         Vlblc3deathdt=(TextView) findViewById(R.id.Vlblc3deathdt);
         dtpc3deathdt=(EditText) findViewById(R.id.dtpc3deathdt);
         secc3deathtm=(LinearLayout)findViewById(R.id.secc3deathtm);
         linec3deathtm=(View)findViewById(R.id.linec3deathtm);
         Vlblc3deathtm=(TextView) findViewById(R.id.Vlblc3deathtm);
         txtc3deathtm=(EditText) findViewById(R.id.txtc3deathtm);
         secc3deathdk=(LinearLayout)findViewById(R.id.secc3deathdk);
         linec3deathdk=(View)findViewById(R.id.linec3deathdk);
         Vlblc3deathdk=(TextView) findViewById(R.id.Vlblc3deathdk);
         chkc3deathdk=(CheckBox) findViewById(R.id.chkc3deathdk);
         secc3transto=(LinearLayout)findViewById(R.id.secc3transto);
         linec3transto=(View)findViewById(R.id.linec3transto);
         Vlblc3transto = (TextView) findViewById(R.id.Vlblc3transto);
         rdogrpc3transto = (RadioGroup) findViewById(R.id.rdogrpc3transto);
         
         rdoc3transto1 = (RadioButton) findViewById(R.id.rdoc3transto1);
         rdoc3transto2 = (RadioButton) findViewById(R.id.rdoc3transto2);
         rdoc3transto3 = (RadioButton) findViewById(R.id.rdoc3transto3);
         rdoc3transto4 = (RadioButton) findViewById(R.id.rdoc3transto4);
         secc3transtooth=(LinearLayout)findViewById(R.id.secc3transtooth);
         linec3transtooth=(View)findViewById(R.id.linec3transtooth);
         Vlblc3transtooth=(TextView) findViewById(R.id.Vlblc3transtooth);
         txtc3transtooth=(EditText) findViewById(R.id.txtc3transtooth);
         secc3hospregno=(LinearLayout)findViewById(R.id.secc3hospregno);
         linec3hospregno=(View)findViewById(R.id.linec3hospregno);
         Vlblc3hospregno=(TextView) findViewById(R.id.Vlblc3hospregno);
         txtc3hospregno=(EditText) findViewById(R.id.txtc3hospregno);
         seclblh1=(LinearLayout)findViewById(R.id.seclblh1);
         linelblh1=(View)findViewById(R.id.linelblh1);
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
                    secincirep.setVisibility(View.VISIBLE);
                 //secincident.setVisibility(View.VISIBLE);
                 //secinciformsl.setVisibility(View.VISIBLE);
             }else if(rbData.equalsIgnoreCase("2")|rbData.equalsIgnoreCase("3")){
                 secwhyincom.setVisibility(View.VISIBLE);
                 linewhyincom.setVisibility(View.VISIBLE);
                 secreason.setVisibility(View.VISIBLE);
                 linereason.setVisibility(View.VISIBLE);
                 secincirep.setVisibility(View.VISIBLE);
             }
             else
             {
                 secwhyincom.setVisibility(View.GONE);
                 linewhyincom.setVisibility(View.GONE);
                 rdogrpwhyincom.clearCheck();
                 secreason.setVisibility(View.GONE);
                 linereason.setVisibility(View.GONE);
                 txtreason.setText("");
                 secincirep.setVisibility(View.VISIBLE);
                 /*
                    secwhyincom.setVisibility(View.VISIBLE);
                    linewhyincom.setVisibility(View.VISIBLE);
                    secreason.setVisibility(View.VISIBLE);
                    linereason.setVisibility(View.VISIBLE);
                 secincirep.setVisibility(View.VISIBLE);*/
                 //secincident.setVisibility(View.VISIBLE);
                 //secinciformsl.setVisibility(View.VISIBLE);
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
             }else if(rbData.equalsIgnoreCase("1"))
             {
                 secincident.setVisibility(View.VISIBLE);
                 lineincident.setVisibility(View.VISIBLE);
                 secinciformsl.setVisibility(View.VISIBLE);
                 lineinciformsl.setVisibility(View.VISIBLE);
             }
             else
             {
                 secincident.setVisibility(View.GONE);
                 lineincident.setVisibility(View.GONE);
                 txtincident.setText("");
                 secinciformsl.setVisibility(View.GONE);
                 lineinciformsl.setVisibility(View.GONE);
                 txtinciformsl.setText("");
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
         dtpc1deathdt.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpc1deathdt.getRight() - dtpc1deathdt.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnc1deathdt"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });
         dtpc2deathdt.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpc2deathdt.getRight() - dtpc2deathdt.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnc2deathdt"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });
         dtpc3deathdt.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpc3deathdt.getRight() - dtpc3deathdt.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnc3deathdt"; showDialog(DATE_DIALOG);
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
         txtc1deathtm.setOnTouchListener(new View.OnTouchListener() {
         @Override
         public boolean onTouch(View v, MotionEvent event) {
             final int DRAWABLE_RIGHT = 2;
             if(event.getAction() == MotionEvent.ACTION_UP) {
                 if(event.getRawX() >= (txtc1deathtm.getRight() - txtc1deathtm.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                     VariableID = "btnc1deathtm"; showDialog(TIME_DIALOG);
                  return true;
                 }
             }
             return false;
           }
         });
         txtc2deathtm.setOnTouchListener(new View.OnTouchListener() {
         @Override
         public boolean onTouch(View v, MotionEvent event) {
             final int DRAWABLE_RIGHT = 2;
             if(event.getAction() == MotionEvent.ACTION_UP) {
                 if(event.getRawX() >= (txtc2deathtm.getRight() - txtc2deathtm.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                     VariableID = "btnc2deathtm"; showDialog(TIME_DIALOG);
                  return true;
                 }
             }
             return false;
           }
         });
         txtc3deathtm.setOnTouchListener(new View.OnTouchListener() {
         @Override
         public boolean onTouch(View v, MotionEvent event) {
             final int DRAWABLE_RIGHT = 2;
             if(event.getAction() == MotionEvent.ACTION_UP) {
                 if(event.getRawX() >= (txtc3deathtm.getRight() - txtc3deathtm.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                     VariableID = "btnc3deathtm"; showDialog(TIME_DIALOG);
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
                 if(checkedId==R.id.rdodiscto5)
                     secdisctooth.setVisibility(View.VISIBLE);
                 else
                    secdisctooth.setVisibility(View.GONE);
             }
         });

         rdogrpc1transto.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(checkedId==R.id.rdoc1transto4) {
                     secc1transtooth.setVisibility(View.VISIBLE);
                     secc1hospregno.setVisibility(View.GONE);
                     txtc1hospregno.setText("");
                 }
                 else if(checkedId==R.id.rdoc1transto3) {
                     secc1hospregno.setVisibility(View.VISIBLE);
                     secc1transtooth.setVisibility(View.GONE);
                     txtc1transtooth.setText("");
                 }
                 else {
                     secc1transtooth.setVisibility(View.GONE);
                     txtc1transtooth.setText("");
                     secc1hospregno.setVisibility(View.GONE);
                     txtc1hospregno.setText("");
                 }
             }
         });

         rdogrpc2transto.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(checkedId==R.id.rdoc2transto4) {
                     secc2transtooth.setVisibility(View.VISIBLE);
                     secc2hospregno.setVisibility(View.GONE);
                     txtc2hospregno.setText("");
                 }
                 else if(checkedId==R.id.rdoc2transto3) {
                     secc2hospregno.setVisibility(View.VISIBLE);
                     secc2transtooth.setVisibility(View.GONE);
                     txtc2transtooth.setText("");
                 }
                 else {
                     secc2transtooth.setVisibility(View.GONE);
                     txtc2transtooth.setText("");
                     secc2hospregno.setVisibility(View.GONE);
                     txtc2hospregno.setText("");
                 }
             }
         });

         rdogrpc3transto.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(checkedId==R.id.rdoc3transto4) {
                     linec3transto.setVisibility(View.VISIBLE);
                     secc3transtooth.setVisibility(View.VISIBLE);
                     secc3hospregno.setVisibility(View.GONE);
                     txtc3hospregno.setText("");
                 }
                 else if(checkedId==R.id.rdoc3transto3) {
                     linec3transto.setVisibility(View.VISIBLE);
                     secc3hospregno.setVisibility(View.VISIBLE);
                     secc3transtooth.setVisibility(View.GONE);
                     txtc3transtooth.setText("");
                 }
                 else {
                     secc3transtooth.setVisibility(View.GONE);
                     txtc3transtooth.setText("");
                     secc3hospregno.setVisibility(View.GONE);
                     txtc3hospregno.setText("");
                 }
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


         chkc1deathdk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if ( isChecked )
                 {
                     txtc1deathtm.setText("");
                 }

             }
         });
         txtc1deathtm.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {
             }

             public void beforeTextChanged(CharSequence s, int start, int count, int after) {
             }

             public void afterTextChanged(Editable s) {
                 if(txtc1deathtm.getText().toString().length()>0) chkc1deathdk.setChecked(false);
             }
         });

         chkc2deathdk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if ( isChecked )
                 {
                     txtc2deathtm.setText("");
                 }

             }
         });
         txtc2deathtm.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {
             }

             public void beforeTextChanged(CharSequence s, int start, int count, int after) {
             }

             public void afterTextChanged(Editable s) {
                 if(txtc2deathtm.getText().toString().length()>0) chkc2deathdk.setChecked(false);
             }
         });

         chkc3deathdk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if ( isChecked )
                 {
                     txtc3deathtm.setText("");
                 }

             }
         });
         txtc3deathtm.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {
             }

             public void beforeTextChanged(CharSequence s, int start, int count, int after) {
             }

             public void afterTextChanged(Editable s) {
                 if(txtc3deathtm.getText().toString().length()>0) chkc3deathdk.setChecked(false);
             }
         });


         //Hide all skip variables
         secc1transtooth.setVisibility(View.GONE);
         secdiscdt.setVisibility(View.GONE);
         linediscdt.setVisibility(View.GONE);
         secdisctm.setVisibility(View.GONE);
         linedisctm.setVisibility(View.GONE);
         secdisctmdk.setVisibility(View.GONE);
         linedisctmdk.setVisibility(View.GONE);
         secdiscto.setVisibility(View.GONE);
         linediscto.setVisibility(View.GONE);
         secdisctooth.setVisibility(View.GONE);
         linedisctooth.setVisibility(View.GONE);
         seclblc1.setVisibility(View.GONE);
         linelblc1.setVisibility(View.GONE);
         secc1cond.setVisibility(View.GONE);
         linec1cond.setVisibility(View.GONE);
         secc1deathdt.setVisibility(View.GONE);
         linec1deathdt.setVisibility(View.GONE);
         secc1deathtm.setVisibility(View.GONE);
         linec1deathtm.setVisibility(View.GONE);
         secc1deathdk.setVisibility(View.GONE);
         //linec1deathdk.setVisibility(View.GONE);
         secc1transto.setVisibility(View.GONE);
         linec1transto.setVisibility(View.GONE);
         secc1transtooth.setVisibility(View.GONE);
         linec1transtooth.setVisibility(View.GONE);
         secc1hospregno.setVisibility(View.GONE);
         linec1hospregno.setVisibility(View.GONE);
         seclblc2.setVisibility(View.GONE);
         linelblc2.setVisibility(View.GONE);
         secc2cond.setVisibility(View.GONE);
         linec2cond.setVisibility(View.GONE);
         secc2deathdt.setVisibility(View.GONE);
         linec2deathdt.setVisibility(View.GONE);
         secc2deathtm.setVisibility(View.GONE);
         linec2deathtm.setVisibility(View.GONE);
         secc2deathdk.setVisibility(View.GONE);
         linec2deathdk.setVisibility(View.GONE);
         secc2transto.setVisibility(View.GONE);
         linec2transto.setVisibility(View.GONE);
         secc2transtooth.setVisibility(View.GONE);
         linec2transtooth.setVisibility(View.GONE);
         secc2hospregno.setVisibility(View.GONE);
         linec2hospregno.setVisibility(View.GONE);
         seclblc3.setVisibility(View.GONE);
         linelblc3.setVisibility(View.GONE);
         secc3cond.setVisibility(View.GONE);
         linec3cond.setVisibility(View.GONE);
         secc3deathdt.setVisibility(View.GONE);
         linec3deathdt.setVisibility(View.GONE);
         secc3deathtm.setVisibility(View.GONE);
         linec3deathtm.setVisibility(View.GONE);
         secc3deathdk.setVisibility(View.GONE);
         linec3deathdk.setVisibility(View.GONE);
         secc3transto.setVisibility(View.GONE);
         linec3transto.setVisibility(View.GONE);
         secc3transtooth.setVisibility(View.GONE);
         linec3transtooth.setVisibility(View.GONE);
         secc3hospregno.setVisibility(View.GONE);
         linec3hospregno.setVisibility(View.GONE);
         secdiscdt.setVisibility(View.GONE);
         linediscdt.setVisibility(View.GONE);
         secdisctm.setVisibility(View.GONE);
         linedisctm.setVisibility(View.GONE);
         secdisctmdk.setVisibility(View.GONE);
         linedisctmdk.setVisibility(View.GONE);
         secc1deathdt.setVisibility(View.GONE);
         linec1deathdt.setVisibility(View.GONE);
         secc1deathtm.setVisibility(View.GONE);
         linec1deathtm.setVisibility(View.GONE);
         secc1deathdk.setVisibility(View.GONE);
         //linec1deathdk.setVisibility(View.GONE);
         secc1deathdt.setVisibility(View.GONE);
         linec1deathdt.setVisibility(View.GONE);
         secc1deathtm.setVisibility(View.GONE);
         linec1deathtm.setVisibility(View.GONE);
         secc1deathdk.setVisibility(View.GONE);
         //linec1deathdk.setVisibility(View.GONE);
         secc1transto.setVisibility(View.GONE);
         linec1transto.setVisibility(View.GONE);
         secc1transtooth.setVisibility(View.GONE);
         linec1transtooth.setVisibility(View.GONE);
         secc1hospregno.setVisibility(View.GONE);
         linec1hospregno.setVisibility(View.GONE);
         seclblc2.setVisibility(View.GONE);
         linelblc2.setVisibility(View.GONE);
         secc2cond.setVisibility(View.GONE);
         linec2cond.setVisibility(View.GONE);
         secc2deathdt.setVisibility(View.GONE);
         linec2deathdt.setVisibility(View.GONE);
         secc2deathtm.setVisibility(View.GONE);
         linec2deathtm.setVisibility(View.GONE);
         secc2deathdk.setVisibility(View.GONE);
         linec2deathdk.setVisibility(View.GONE);
         secc2transto.setVisibility(View.GONE);
         linec2transto.setVisibility(View.GONE);
         secc2transtooth.setVisibility(View.GONE);
         linec2transtooth.setVisibility(View.GONE);
         secc2hospregno.setVisibility(View.GONE);
         linec2hospregno.setVisibility(View.GONE);
         seclblc3.setVisibility(View.GONE);
         linelblc3.setVisibility(View.GONE);
         secc3cond.setVisibility(View.GONE);
         linec3cond.setVisibility(View.GONE);
         secc3deathdt.setVisibility(View.GONE);
         linec3deathdt.setVisibility(View.GONE);
         secc3deathtm.setVisibility(View.GONE);
         linec3deathtm.setVisibility(View.GONE);
         secc3deathdk.setVisibility(View.GONE);
         linec3deathdk.setVisibility(View.GONE);
         secc3transto.setVisibility(View.GONE);
         linec3transto.setVisibility(View.GONE);
         secc3transtooth.setVisibility(View.GONE);
         linec3transtooth.setVisibility(View.GONE);
         secc3hospregno.setVisibility(View.GONE);
         linec3hospregno.setVisibility(View.GONE);
         secc1deathdt.setVisibility(View.GONE);
         linec1deathdt.setVisibility(View.GONE);
         secc1deathtm.setVisibility(View.GONE);
         linec1deathtm.setVisibility(View.GONE);
         secc1deathdk.setVisibility(View.GONE);
         //linec1deathdk.setVisibility(View.GONE);
         secc1transto.setVisibility(View.GONE);
         linec1transto.setVisibility(View.GONE);
         secc1transtooth.setVisibility(View.GONE);
         linec1transtooth.setVisibility(View.GONE);
         secc1hospregno.setVisibility(View.GONE);
         linec1hospregno.setVisibility(View.GONE);
         seclblc2.setVisibility(View.GONE);
         linelblc2.setVisibility(View.GONE);
         secc2cond.setVisibility(View.GONE);
         linec2cond.setVisibility(View.GONE);
         secc2deathdt.setVisibility(View.GONE);
         linec2deathdt.setVisibility(View.GONE);
         secc2deathtm.setVisibility(View.GONE);
         linec2deathtm.setVisibility(View.GONE);
         secc2deathdk.setVisibility(View.GONE);
         linec2deathdk.setVisibility(View.GONE);
         secc2transto.setVisibility(View.GONE);
         linec2transto.setVisibility(View.GONE);
         secc2transtooth.setVisibility(View.GONE);
         linec2transtooth.setVisibility(View.GONE);
         secc2hospregno.setVisibility(View.GONE);
         linec2hospregno.setVisibility(View.GONE);
         seclblc3.setVisibility(View.GONE);
         linelblc3.setVisibility(View.GONE);
         secc3cond.setVisibility(View.GONE);
         linec3cond.setVisibility(View.GONE);
         secc3deathdt.setVisibility(View.GONE);
         linec3deathdt.setVisibility(View.GONE);
         secc3deathtm.setVisibility(View.GONE);
         linec3deathtm.setVisibility(View.GONE);
         secc3deathdk.setVisibility(View.GONE);
         linec3deathdk.setVisibility(View.GONE);
         secc3transto.setVisibility(View.GONE);
         linec3transto.setVisibility(View.GONE);
         secc3transtooth.setVisibility(View.GONE);
         linec3transtooth.setVisibility(View.GONE);
         secc3hospregno.setVisibility(View.GONE);
         linec3hospregno.setVisibility(View.GONE);
         secc1deathdt.setVisibility(View.GONE);
         linec1deathdt.setVisibility(View.GONE);
         secc1deathtm.setVisibility(View.GONE);
         linec1deathtm.setVisibility(View.GONE);
         secc1deathdk.setVisibility(View.GONE);
         //linec1deathdk.setVisibility(View.GONE);
         secc1transto.setVisibility(View.GONE);
         linec1transto.setVisibility(View.GONE);
         secc1transtooth.setVisibility(View.GONE);
         linec1transtooth.setVisibility(View.GONE);
         secc1hospregno.setVisibility(View.GONE);
         linec1hospregno.setVisibility(View.GONE);
         seclblc2.setVisibility(View.GONE);
         linelblc2.setVisibility(View.GONE);
         secc2cond.setVisibility(View.GONE);
         linec2cond.setVisibility(View.GONE);
         secc2deathdt.setVisibility(View.GONE);
         linec2deathdt.setVisibility(View.GONE);
         secc2deathtm.setVisibility(View.GONE);
         linec2deathtm.setVisibility(View.GONE);
         secc2deathdk.setVisibility(View.GONE);
         linec2deathdk.setVisibility(View.GONE);
         secc2transto.setVisibility(View.GONE);
         linec2transto.setVisibility(View.GONE);
         secc2transtooth.setVisibility(View.GONE);
         linec2transtooth.setVisibility(View.GONE);
         secc2hospregno.setVisibility(View.GONE);
         linec2hospregno.setVisibility(View.GONE);
         seclblc3.setVisibility(View.GONE);
         linelblc3.setVisibility(View.GONE);
         secc3cond.setVisibility(View.GONE);
         linec3cond.setVisibility(View.GONE);
         secc3deathdt.setVisibility(View.GONE);
         linec3deathdt.setVisibility(View.GONE);
         secc3deathtm.setVisibility(View.GONE);
         linec3deathtm.setVisibility(View.GONE);
         secc3deathdk.setVisibility(View.GONE);
         linec3deathdk.setVisibility(View.GONE);
         secc3transto.setVisibility(View.GONE);
         linec3transto.setVisibility(View.GONE);
         secc3transtooth.setVisibility(View.GONE);
         linec3transtooth.setVisibility(View.GONE);
         secc3hospregno.setVisibility(View.GONE);
         linec3hospregno.setVisibility(View.GONE);
         secc2deathdt.setVisibility(View.GONE);
         linec2deathdt.setVisibility(View.GONE);
         secc2deathtm.setVisibility(View.GONE);
         linec2deathtm.setVisibility(View.GONE);
         secc2deathdk.setVisibility(View.GONE);
         linec2deathdk.setVisibility(View.GONE);
         secc2deathdt.setVisibility(View.GONE);
         linec2deathdt.setVisibility(View.GONE);
         secc2deathtm.setVisibility(View.GONE);
         linec2deathtm.setVisibility(View.GONE);
         secc2deathdk.setVisibility(View.GONE);
         linec2deathdk.setVisibility(View.GONE);
         secc2transto.setVisibility(View.GONE);
         linec2transto.setVisibility(View.GONE);
         secc2transtooth.setVisibility(View.GONE);
         linec2transtooth.setVisibility(View.GONE);
         secc2hospregno.setVisibility(View.GONE);
         linec2hospregno.setVisibility(View.GONE);
         seclblc3.setVisibility(View.GONE);
         linelblc3.setVisibility(View.GONE);
         secc3cond.setVisibility(View.GONE);
         linec3cond.setVisibility(View.GONE);
         secc3deathdt.setVisibility(View.GONE);
         linec3deathdt.setVisibility(View.GONE);
         secc3deathtm.setVisibility(View.GONE);
         linec3deathtm.setVisibility(View.GONE);
         secc3deathdk.setVisibility(View.GONE);
         linec3deathdk.setVisibility(View.GONE);
         secc3transto.setVisibility(View.GONE);
         linec3transto.setVisibility(View.GONE);
         secc3transtooth.setVisibility(View.GONE);
         linec3transtooth.setVisibility(View.GONE);
         secc3hospregno.setVisibility(View.GONE);
         linec3hospregno.setVisibility(View.GONE);
         secc2deathdt.setVisibility(View.GONE);
         linec2deathdt.setVisibility(View.GONE);
         secc2deathtm.setVisibility(View.GONE);
         linec2deathtm.setVisibility(View.GONE);
         secc2deathdk.setVisibility(View.GONE);
         linec2deathdk.setVisibility(View.GONE);
         secc2transto.setVisibility(View.GONE);
         linec2transto.setVisibility(View.GONE);
         secc2transtooth.setVisibility(View.GONE);
         linec2transtooth.setVisibility(View.GONE);
         secc2hospregno.setVisibility(View.GONE);
         linec2hospregno.setVisibility(View.GONE);
         seclblc3.setVisibility(View.GONE);
         linelblc3.setVisibility(View.GONE);
         secc3cond.setVisibility(View.GONE);
         linec3cond.setVisibility(View.GONE);
         secc3deathdt.setVisibility(View.GONE);
         linec3deathdt.setVisibility(View.GONE);
         secc3deathtm.setVisibility(View.GONE);
         linec3deathtm.setVisibility(View.GONE);
         secc3deathdk.setVisibility(View.GONE);
         linec3deathdk.setVisibility(View.GONE);
         secc3transto.setVisibility(View.GONE);
         linec3transto.setVisibility(View.GONE);
         secc3transtooth.setVisibility(View.GONE);
         linec3transtooth.setVisibility(View.GONE);
         secc3hospregno.setVisibility(View.GONE);
         linec3hospregno.setVisibility(View.GONE);
         secc2deathdt.setVisibility(View.GONE);
         linec2deathdt.setVisibility(View.GONE);
         secc2deathtm.setVisibility(View.GONE);
         linec2deathtm.setVisibility(View.GONE);
         secc2deathdk.setVisibility(View.GONE);
         linec2deathdk.setVisibility(View.GONE);
         secc2transto.setVisibility(View.GONE);
         linec2transto.setVisibility(View.GONE);
         secc2transtooth.setVisibility(View.GONE);
         linec2transtooth.setVisibility(View.GONE);
         secc2hospregno.setVisibility(View.GONE);
         linec2hospregno.setVisibility(View.GONE);
         seclblc3.setVisibility(View.GONE);
         linelblc3.setVisibility(View.GONE);
         secc3cond.setVisibility(View.GONE);
         linec3cond.setVisibility(View.GONE);
         secc3deathdt.setVisibility(View.GONE);
         linec3deathdt.setVisibility(View.GONE);
         secc3deathtm.setVisibility(View.GONE);
         linec3deathtm.setVisibility(View.GONE);
         secc3deathdk.setVisibility(View.GONE);
         linec3deathdk.setVisibility(View.GONE);
         secc3transto.setVisibility(View.GONE);
         linec3transto.setVisibility(View.GONE);
         secc3transtooth.setVisibility(View.GONE);
         linec3transtooth.setVisibility(View.GONE);
         secc3hospregno.setVisibility(View.GONE);
         linec3hospregno.setVisibility(View.GONE);
         secc3deathdt.setVisibility(View.GONE);
         linec3deathdt.setVisibility(View.GONE);
         secc3deathtm.setVisibility(View.GONE);
         linec3deathtm.setVisibility(View.GONE);
         secc3deathdk.setVisibility(View.GONE);
         linec3deathdk.setVisibility(View.GONE);
         secc3deathdt.setVisibility(View.GONE);
         linec3deathdt.setVisibility(View.GONE);
         secc3deathtm.setVisibility(View.GONE);
         linec3deathtm.setVisibility(View.GONE);
         secc3deathdk.setVisibility(View.GONE);
         linec3deathdk.setVisibility(View.GONE);
         secc3transto.setVisibility(View.GONE);
         linec3transto.setVisibility(View.GONE);
         secc3transtooth.setVisibility(View.GONE);
         linec3transtooth.setVisibility(View.GONE);
         secc3hospregno.setVisibility(View.GONE);
         linec3hospregno.setVisibility(View.GONE);
         secc3deathdt.setVisibility(View.GONE);
         linec3deathdt.setVisibility(View.GONE);
         secc3deathtm.setVisibility(View.GONE);
         linec3deathtm.setVisibility(View.GONE);
         secc3deathdk.setVisibility(View.GONE);
         linec3deathdk.setVisibility(View.GONE);
         secc3transto.setVisibility(View.GONE);
         linec3transto.setVisibility(View.GONE);
         secc3transtooth.setVisibility(View.GONE);
         linec3transtooth.setVisibility(View.GONE);
         secc3hospregno.setVisibility(View.GONE);
         linec3hospregno.setVisibility(View.GONE);
         secc3deathdt.setVisibility(View.GONE);
         linec3deathdt.setVisibility(View.GONE);
         secc3deathtm.setVisibility(View.GONE);
         linec3deathtm.setVisibility(View.GONE);
         secc3deathdk.setVisibility(View.GONE);
         linec3deathdk.setVisibility(View.GONE);
         secc3transto.setVisibility(View.GONE);
         linec3transto.setVisibility(View.GONE);
         secc3transtooth.setVisibility(View.GONE);
         linec3transtooth.setVisibility(View.GONE);
         secc3hospregno.setVisibility(View.GONE);
         linec3hospregno.setVisibility(View.GONE);
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
         Connection.MessageBox(LD_Outcome.this, e.getMessage());
         return;
     }
 }


 public void ClearForm()
 {
     rdogrpmotcond.clearCheck();
     rdogrpobjstatus.clearCheck();
     secdiscdt.setVisibility(View.GONE);
     linediscdt.setVisibility(View.GONE);
     dtpdiscdt.setText("");
     secdisctm.setVisibility(View.GONE);
     linedisctm.setVisibility(View.GONE);
     txtdisctm.setText("");
     secdisctmdk.setVisibility(View.GONE);
     linedisctmdk.setVisibility(View.GONE);
     chkdisctmdk.setChecked(false);
     secdiscto.setVisibility(View.GONE);
     linediscto.setVisibility(View.GONE);
     rdogrpdiscto.clearCheck();
     secdisctooth.setVisibility(View.GONE);
     linedisctooth.setVisibility(View.GONE);
     txtdisctooth.setText("");
     seclblc1.setVisibility(View.GONE);
     linelblc1.setVisibility(View.GONE);
     secc1cond.setVisibility(View.GONE);
     linec1cond.setVisibility(View.GONE);
     rdogrpc1cond.clearCheck();
     secc1deathdt.setVisibility(View.GONE);
     linec1deathdt.setVisibility(View.GONE);
     dtpc1deathdt.setText("");
     secc1deathtm.setVisibility(View.GONE);
     linec1deathtm.setVisibility(View.GONE);
     txtc1deathtm.setText("");
     secc1deathdk.setVisibility(View.GONE);
     //linec1deathdk.setVisibility(View.GONE);
     chkc1deathdk.setChecked(false);
     secc1transto.setVisibility(View.GONE);
     linec1transto.setVisibility(View.GONE);
     rdogrpc1transto.clearCheck();
     secc1transtooth.setVisibility(View.GONE);
     linec1transtooth.setVisibility(View.GONE);
     txtc1transtooth.setText("");
     secc1hospregno.setVisibility(View.GONE);
     linec1hospregno.setVisibility(View.GONE);
     txtc1hospregno.setText("");
     seclblc2.setVisibility(View.GONE);
     linelblc2.setVisibility(View.GONE);
     secc2cond.setVisibility(View.GONE);
     linec2cond.setVisibility(View.GONE);
     rdogrpc2cond.clearCheck();
     secc2deathdt.setVisibility(View.GONE);
     linec2deathdt.setVisibility(View.GONE);
     dtpc2deathdt.setText("");
     secc2deathtm.setVisibility(View.GONE);
     linec2deathtm.setVisibility(View.GONE);
     txtc2deathtm.setText("");
     secc2deathdk.setVisibility(View.GONE);
     linec2deathdk.setVisibility(View.GONE);
     chkc2deathdk.setChecked(false);
     secc2transto.setVisibility(View.GONE);
     linec2transto.setVisibility(View.GONE);
     rdogrpc2transto.clearCheck();
     secc2transtooth.setVisibility(View.GONE);
     linec2transtooth.setVisibility(View.GONE);
     txtc2transtooth.setText("");
     secc2hospregno.setVisibility(View.GONE);
     linec2hospregno.setVisibility(View.GONE);
     txtc2hospregno.setText("");
     seclblc3.setVisibility(View.GONE);
     linelblc3.setVisibility(View.GONE);
     secc3cond.setVisibility(View.GONE);
     linec3cond.setVisibility(View.GONE);
     rdogrpc3cond.clearCheck();
     secc3deathdt.setVisibility(View.GONE);
     linec3deathdt.setVisibility(View.GONE);
     dtpc3deathdt.setText("");
     secc3deathtm.setVisibility(View.GONE);
     linec3deathtm.setVisibility(View.GONE);
     txtc3deathtm.setText("");
     secc3deathdk.setVisibility(View.GONE);
     linec3deathdk.setVisibility(View.GONE);
     chkc3deathdk.setChecked(false);
     secc3transto.setVisibility(View.GONE);
     linec3transto.setVisibility(View.GONE);
     rdogrpc3transto.clearCheck();
     secc3transtooth.setVisibility(View.GONE);
     linec3transtooth.setVisibility(View.GONE);
     txtc3transtooth.setText("");
     secc3hospregno.setVisibility(View.GONE);
     linec3hospregno.setVisibility(View.GONE);
     txtc3hospregno.setText("");
     secwhyincom.setVisibility(View.GONE);
     secreason.setVisibility(View.GONE);
     secincident.setVisibility(View.GONE);
     secinciformsl.setVisibility(View.GONE);

     rdogrpobjstatus.clearCheck();
     rdogrpwhyincom.clearCheck();
     txtreason.setText("");
     rdogrpincirep.clearCheck();
     txtincident.setText("");
     txtinciformsl.setText("");

 }


 private void DataSave()
 {
   try
     {
 
         String DV="";

         if(txtCountryCode.getText().toString().length()==0 & secCountryCode.isShown())
           {
             Connection.MessageBox(LD_Outcome.this, "Required field: Country Code.");
             txtCountryCode.requestFocus(); 
             return;	
           }
         else if(txtFaciCode.getText().toString().length()==0 & secFaciCode.isShown())
           {
             Connection.MessageBox(LD_Outcome.this, "Required field: Facility Code.");
             txtFaciCode.requestFocus(); 
             return;	
           }
         else if(txtDataID.getText().toString().length()==0 & secDataID.isShown())
           {
             Connection.MessageBox(LD_Outcome.this, "Required field: Data ID.");
             txtDataID.requestFocus(); 
             return;	
           }
         
         else if(!rdomotcond1.isChecked() & !rdomotcond2.isChecked() & !rdomotcond3.isChecked() & secmotcond.isShown())
           {
              Connection.MessageBox(LD_Outcome.this, "Select anyone options from (Mothers condition at discharge).");
              rdomotcond1.requestFocus();
              return;
           }
         DV = Global.DateValidate(dtpdiscdt.getText().toString());
         if(DV.length()!=0 & secdiscdt.isShown())
           {
             Connection.MessageBox(LD_Outcome.this, DV);
             dtpdiscdt.requestFocus(); 
             return;	
           }
         else if(!chkdisctmdk.isChecked() & txtdisctm.getText().length()==0 & secdisctm.isShown())
           {
             Connection.MessageBox(LD_Outcome.this, "Required field: Time of discharge.");
             txtdisctm.requestFocus(); 
             return;	
           }
         
         else if(!rdodiscto1.isChecked() & !rdodiscto2.isChecked() & !rdodiscto3.isChecked() & !rdodiscto4.isChecked() & !rdodiscto5.isChecked() & secdiscto.isShown())
           {
              Connection.MessageBox(LD_Outcome.this, "Select anyone options from (Mother discharge to).");
              rdodiscto1.requestFocus();
              return;
           }
         else if(txtdisctooth.getText().toString().length()==0 & secdisctooth.isShown())
           {
             Connection.MessageBox(LD_Outcome.this, "Required field: Others.");
             txtdisctooth.requestFocus(); 
             return;	
           }
         
         else if(!rdoc1cond1.isChecked() & !rdoc1cond2.isChecked() & !rdoc1cond3.isChecked() & !rdoc1cond4.isChecked() & !rdoc1cond5.isChecked() & !rdoc1cond6.isChecked() & secc1cond.isShown())
           {
              Connection.MessageBox(LD_Outcome.this, "Select anyone options from (Baby1s condition at discharge).");
              rdoc1cond1.requestFocus();
              return;
           }
         DV = Global.DateValidate(dtpc1deathdt.getText().toString());
         if(DV.length()!=0 & secc1deathdt.isShown())
           {
             Connection.MessageBox(LD_Outcome.this, DV);
             dtpc1deathdt.requestFocus(); 
             return;	
           }
         else if(!chkc1deathdk.isChecked() & txtc1deathtm.getText().length()==0 & secc1deathtm.isShown())
           {
             Connection.MessageBox(LD_Outcome.this, "Required field: Time of baby-1 death.");
             txtc1deathtm.requestFocus(); 
             return;	
           }
         
         else if(!rdoc1transto1.isChecked() & !rdoc1transto2.isChecked() & !rdoc1transto3.isChecked() & !rdoc1transto4.isChecked() & secc1transto.isShown())
           {
              Connection.MessageBox(LD_Outcome.this, "Select anyone options from (Baby-1 discharged/tranasfered to).");
              rdoc1transto1.requestFocus();
              return;
           }
         else if(txtc1transtooth.getText().toString().length()==0 & secc1transtooth.isShown())
           {
             Connection.MessageBox(LD_Outcome.this, "Required field: Others.");
             txtc1transtooth.requestFocus(); 
             return;	
           }
         else if(txtc1hospregno.getText().toString().length()==0 & secc1hospregno.isShown())
           {
             Connection.MessageBox(LD_Outcome.this, "Required field: KMC Hospital Registration no.");
             txtc1hospregno.requestFocus(); 
             return;	
           }
         
         else if(!rdoc2cond1.isChecked() & !rdoc2cond2.isChecked() & !rdoc2cond3.isChecked() & !rdoc2cond4.isChecked() & !rdoc2cond5.isChecked() & secc2cond.isShown())
           {
              Connection.MessageBox(LD_Outcome.this, "Select anyone options from (Baby1s condition at discharge).");
              rdoc2cond1.requestFocus();
              return;
           }
         DV = Global.DateValidate(dtpc2deathdt.getText().toString());
         if(DV.length()!=0 & secc2deathdt.isShown())
           {
             Connection.MessageBox(LD_Outcome.this, DV);
             dtpc2deathdt.requestFocus(); 
             return;	
           }
         else if(!chkc2deathdk.isChecked() & txtc2deathtm.getText().length()==0 & secc2deathtm.isShown())
           {
             Connection.MessageBox(LD_Outcome.this, "Required field: Time of baby-1 death.");
             txtc2deathtm.requestFocus(); 
             return;	
           }
         
         else if(!rdoc2transto1.isChecked() & !rdoc2transto2.isChecked() & !rdoc2transto3.isChecked() & !rdoc2transto4.isChecked() & secc2transto.isShown())
           {
              Connection.MessageBox(LD_Outcome.this, "Select anyone options from (Baby-1 discharged/tranasfered to).");
              rdoc2transto1.requestFocus();
              return;
           }
         else if(txtc2transtooth.getText().toString().length()==0 & secc2transtooth.isShown())
           {
             Connection.MessageBox(LD_Outcome.this, "Required field: Others.");
             txtc2transtooth.requestFocus(); 
             return;	
           }
         else if(txtc2hospregno.getText().toString().length()==0 & secc2hospregno.isShown())
           {
             Connection.MessageBox(LD_Outcome.this, "Required field: KMC Hospital Registration no.");
             txtc2hospregno.requestFocus(); 
             return;	
           }
         
         else if(!rdoc3cond1.isChecked() & !rdoc3cond2.isChecked() & !rdoc3cond3.isChecked() & !rdoc3cond4.isChecked() & !rdoc3cond5.isChecked() & secc3cond.isShown())
           {
              Connection.MessageBox(LD_Outcome.this, "Select anyone options from (Baby1s condition at discharge).");
              rdoc3cond1.requestFocus();
              return;
           }
         DV = Global.DateValidate(dtpc3deathdt.getText().toString());
         if(DV.length()!=0 & secc3deathdt.isShown())
           {
             Connection.MessageBox(LD_Outcome.this, DV);
             dtpc3deathdt.requestFocus(); 
             return;	
           }
         else if(!chkc3deathdk.isChecked() & txtc3deathtm.getText().length()==0 & secc3deathtm.isShown())
           {
             Connection.MessageBox(LD_Outcome.this, "Required field: Time of baby-1 death.");
             txtc3deathtm.requestFocus(); 
             return;	
           }
         
         else if(!rdoc3transto1.isChecked() & !rdoc3transto2.isChecked() & !rdoc3transto3.isChecked() & !rdoc3transto4.isChecked() & secc3transto.isShown())
           {
              Connection.MessageBox(LD_Outcome.this, "Select anyone options from (Baby-1 discharged/tranasfered to).");
              rdoc3transto1.requestFocus();
              return;
           }
         else if(txtc3transtooth.getText().toString().length()==0 & secc3transtooth.isShown())
           {
             Connection.MessageBox(LD_Outcome.this, "Required field: Others.");
             txtc3transtooth.requestFocus(); 
             return;	
           }
         else if(txtc3hospregno.getText().toString().length()==0 & secc3hospregno.isShown())
           {
             Connection.MessageBox(LD_Outcome.this, "Required field: KMC Hospital Registration no.");
             txtc3hospregno.requestFocus(); 
             return;	
           }
         
         else if(!rdoobjstatus1.isChecked() & !rdoobjstatus2.isChecked() & !rdoobjstatus3.isChecked() & secobjstatus.isShown())
           {
              Connection.MessageBox(LD_Outcome.this, "Select anyone options from (What is the status of the observation?).");
              rdoobjstatus1.requestFocus();
              return;
           }
         
         else if(!rdowhyincom1.isChecked() & !rdowhyincom2.isChecked() & !rdowhyincom3.isChecked() & !rdowhyincom4.isChecked() & secwhyincom.isShown())
           {
              Connection.MessageBox(LD_Outcome.this, "Select anyone options from (Why partially complete or incomplete?).");
              rdowhyincom1.requestFocus();
              return;
           }
         else if(txtreason.getText().toString().length()==0 & secreason.isShown())
           {
             Connection.MessageBox(LD_Outcome.this, "Required field: Please mention.");
             txtreason.requestFocus(); 
             return;	
           }
         
         else if(!rdoincirep1.isChecked() & !rdoincirep2.isChecked() & secincirep.isShown())
           {
              Connection.MessageBox(LD_Outcome.this, "Select anyone options from (Do you want to report any incident?).");
              rdoincirep1.requestFocus();
              return;
           }
         else if(txtincident.getText().toString().length()==0 & secincident.isShown())
           {
             Connection.MessageBox(LD_Outcome.this, "Required field: If yes, then what is the incident?.");
             txtincident.requestFocus(); 
             return;	
           }
         else if(txtinciformsl.getText().toString().length()==0 & secinciformsl.isShown())
           {
             Connection.MessageBox(LD_Outcome.this, "Required field: Write down the serial number of the incident form..");
             txtinciformsl.requestFocus(); 
             return;	
           }


         //Force Variable Need to be completed before final outcome
         String SQL = "";
         String TID = "";
         String Desc = "";
         SQL = "Select v.TableId,v.VarName,v.Description,ifnull(o.SL,'') sl from ObjVarList v";
         SQL += " left outer join Observation o on v.TableId=o.TableId and v.VarName=o.VarName and o.CountryCode='" + COUNTRYCODE + "' and o.FaciCode='" + FACICODE + "' and o.DataID='"+ DATAID +"'";
         SQL += " where v.ForceVar='1' and o.Observ not in('Y','C') and o.Active='1'";
         SQL += " order by v.TableId,o.sl,v.ObjSeq1";

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
             if(cur.getString(cur.getColumnIndex("sl")).length()==0)
                Desc = Desc + (Desc.length()==0? cur.getString(cur.getColumnIndex("Description")):"<br/>"+cur.getString(cur.getColumnIndex("Description")));
             else
                Desc = Desc + "<br/>Child "+ cur.getString(cur.getColumnIndex("sl")) +": "+(Desc.length()==0? cur.getString(cur.getColumnIndex("Description")):""+cur.getString(cur.getColumnIndex("Description")));

             cur.moveToNext();
         }
         cur.close();

         if(!C.Existence("Select DataID from Registration where CountryCode='" + COUNTRYCODE + "' and FaciCode='" + FACICODE + "' and DataID='"+ DATAID +"' and CompleteStatus='stop'") &
                 C.Existence("Select DataID from Observation where VarName='ObjStart' and Observ='Y' and CountryCode='" + COUNTRYCODE + "' and FaciCode='" + FACICODE + "' and DataID='"+ DATAID +"'")) {
             if (Desc.length() == 0) {
                 //dialog.dismiss();
             } else {
                 AlertDialog.Builder adb = new AlertDialog.Builder(LD_Outcome.this);
                 adb.setTitle(Html.fromHtml("<b>Before you continue stop, please check whether you have filled up the following variables.</b>"));
                 adb.setMessage(Html.fromHtml(Desc + "<br/><br/><b>Go Back to Observation then try again.</b>"));
                 adb.setNegativeButton("Back to Observation", null);
                 adb.show();
                 return;
             }
         }


         //String SQL = "";
         RadioButton rb;

         LD_Outcome_DataModel objSave = new LD_Outcome_DataModel();
         objSave.setCountryCode(txtCountryCode.getText().toString());
         objSave.setFaciCode(txtFaciCode.getText().toString());
         objSave.setDataID(txtDataID.getText().toString());
         String[] d_rdogrpmotcond = new String[] {"1","2","3"};
         objSave.setmotcond("");
         for (int i = 0; i < rdogrpmotcond.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpmotcond.getChildAt(i);
             if (rb.isChecked()) objSave.setmotcond(d_rdogrpmotcond[i]);
         }

         objSave.setdiscdt(dtpdiscdt.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpdiscdt.getText().toString()) : dtpdiscdt.getText().toString());
         objSave.setdisctm(txtdisctm.getText().toString());
         objSave.setdisctmdk((chkdisctmdk.isChecked()?"1":(secdisctmdk.isShown()?"2":"")));
         String[] d_rdogrpdiscto = new String[] {"1","2","3","4","5"};
         objSave.setdiscto("");
         for (int i = 0; i < rdogrpdiscto.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpdiscto.getChildAt(i);
             if (rb.isChecked()) objSave.setdiscto(d_rdogrpdiscto[i]);
         }

         objSave.setdisctooth(txtdisctooth.getText().toString());
         String[] d_rdogrpc1cond = new String[] {"1","2","3","4","5","6"};
         objSave.setc1cond("");
         for (int i = 0; i < rdogrpc1cond.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpc1cond.getChildAt(i);
             if (rb.isChecked()) objSave.setc1cond(d_rdogrpc1cond[i]);
         }

         objSave.setc1deathdt(dtpc1deathdt.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpc1deathdt.getText().toString()) : dtpc1deathdt.getText().toString());
         objSave.setc1deathtm(txtc1deathtm.getText().toString());
         objSave.setc1deathdk((chkc1deathdk.isChecked()?"1":(secc1deathdk.isShown()?"2":"")));
         String[] d_rdogrpc1transto = new String[] {"1","2","3","4"};
         objSave.setc1transto("");
         for (int i = 0; i < rdogrpc1transto.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpc1transto.getChildAt(i);
             if (rb.isChecked()) objSave.setc1transto(d_rdogrpc1transto[i]);
         }

         objSave.setc1transtooth(txtc1transtooth.getText().toString());
         objSave.setc1hospregno(txtc1hospregno.getText().toString());
         String[] d_rdogrpc2cond = new String[] {"1","2","3","4","5","6"};
         objSave.setc2cond("");
         for (int i = 0; i < rdogrpc2cond.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpc2cond.getChildAt(i);
             if (rb.isChecked()) objSave.setc2cond(d_rdogrpc2cond[i]);
         }

         objSave.setc2deathdt(dtpc2deathdt.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpc2deathdt.getText().toString()) : dtpc2deathdt.getText().toString());
         objSave.setc2deathtm(txtc2deathtm.getText().toString());
         objSave.setc2deathdk((chkc2deathdk.isChecked()?"1":(secc2deathdk.isShown()?"2":"")));
         String[] d_rdogrpc2transto = new String[] {"1","2","3","4"};
         objSave.setc2transto("");
         for (int i = 0; i < rdogrpc2transto.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpc2transto.getChildAt(i);
             if (rb.isChecked()) objSave.setc2transto(d_rdogrpc2transto[i]);
         }

         objSave.setc2transtooth(txtc2transtooth.getText().toString());
         objSave.setc2hospregno(txtc2hospregno.getText().toString());
         String[] d_rdogrpc3cond = new String[] {"1","2","3","4","5","6"};
         objSave.setc3cond("");
         for (int i = 0; i < rdogrpc3cond.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpc3cond.getChildAt(i);
             if (rb.isChecked()) objSave.setc3cond(d_rdogrpc3cond[i]);
         }

         objSave.setc3deathdt(dtpc3deathdt.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpc3deathdt.getText().toString()) : dtpc3deathdt.getText().toString());
         objSave.setc3deathtm(txtc3deathtm.getText().toString());
         objSave.setc3deathdk((chkc3deathdk.isChecked()?"1":(secc3deathdk.isShown()?"2":"")));
         String[] d_rdogrpc3transto = new String[] {"1","2","3","4"};
         objSave.setc3transto("");
         for (int i = 0; i < rdogrpc3transto.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpc3transto.getChildAt(i);
             if (rb.isChecked()) objSave.setc3transto(d_rdogrpc3transto[i]);
         }

         objSave.setc3transtooth(txtc3transtooth.getText().toString());
         objSave.setc3hospregno(txtc3hospregno.getText().toString());
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

             Connection.MessageBox(LD_Outcome.this, "Saved Successfully");
         }
         else{
             Connection.MessageBox(LD_Outcome.this, status);
             return;
         }
     }
     catch(Exception  e)
     {
         Connection.MessageBox(LD_Outcome.this, e.getMessage());
         return;
     }
 }

 public void DataSearch(String CountryCode, String FaciCode, String DataID)
     {
       try
        {
     
           RadioButton rb;
           LD_Outcome_DataModel d = new LD_Outcome_DataModel();
           String SQL = "Select * from "+ TableName +"  Where CountryCode='"+ CountryCode +"' and FaciCode='"+ FaciCode +"' and DataID='"+ DataID +"'";
           List<LD_Outcome_DataModel> data = d.SelectAll(this, SQL);
           for(LD_Outcome_DataModel item : data){
             txtCountryCode.setText(item.getCountryCode());
             txtFaciCode.setText(item.getFaciCode());
             txtDataID.setText(item.getDataID());
             String[] d_rdogrpmotcond = new String[] {"1","2","3"};
             for (int i = 0; i < d_rdogrpmotcond.length; i++)
             {
                 if (item.getmotcond().equals(String.valueOf(d_rdogrpmotcond[i])))
                 {
                     rb = (RadioButton)rdogrpmotcond.getChildAt(i);
                     rb.setChecked(true);
                 }
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
             String[] d_rdogrpdiscto = new String[] {"1","2","3","4","5"};
             for (int i = 0; i < d_rdogrpdiscto.length; i++)
             {
                 if (item.getdiscto().equals(String.valueOf(d_rdogrpdiscto[i])))
                 {
                     rb = (RadioButton)rdogrpdiscto.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtdisctooth.setText(item.getdisctooth());
             String[] d_rdogrpc1cond = new String[] {"1","2","3","4","5","6"};
             for (int i = 0; i < d_rdogrpc1cond.length; i++)
             {
                 if (item.getc1cond().equals(String.valueOf(d_rdogrpc1cond[i])))
                 {
                     rb = (RadioButton)rdogrpc1cond.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             dtpc1deathdt.setText(item.getc1deathdt().toString().length()==0 ? "" : Global.DateConvertDMY(item.getc1deathdt()));
             txtc1deathtm.setText(item.getc1deathtm());
             if(item.getc1deathdk().equals("1"))
             {
                chkc1deathdk.setChecked(true);
             }
             else if(item.getc1deathdk().equals("2"))
             {
                chkc1deathdk.setChecked(false);
             }
             String[] d_rdogrpc1transto = new String[] {"1","2","3","4"};
             for (int i = 0; i < d_rdogrpc1transto.length; i++)
             {
                 if (item.getc1transto().equals(String.valueOf(d_rdogrpc1transto[i])))
                 {
                     rb = (RadioButton)rdogrpc1transto.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtc1transtooth.setText(item.getc1transtooth());
             txtc1hospregno.setText(item.getc1hospregno());
             String[] d_rdogrpc2cond = new String[] {"1","2","3","4","5","6"};
             for (int i = 0; i < d_rdogrpc2cond.length; i++)
             {
                 if (item.getc2cond().equals(String.valueOf(d_rdogrpc2cond[i])))
                 {
                     rb = (RadioButton)rdogrpc2cond.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             dtpc2deathdt.setText(item.getc2deathdt().toString().length()==0 ? "" : Global.DateConvertDMY(item.getc2deathdt()));
             txtc2deathtm.setText(item.getc2deathtm());
             if(item.getc2deathdk().equals("1"))
             {
                chkc2deathdk.setChecked(true);
             }
             else if(item.getc2deathdk().equals("2"))
             {
                chkc2deathdk.setChecked(false);
             }
             String[] d_rdogrpc2transto = new String[] {"1","2","3","4"};
             for (int i = 0; i < d_rdogrpc2transto.length; i++)
             {
                 if (item.getc2transto().equals(String.valueOf(d_rdogrpc2transto[i])))
                 {
                     rb = (RadioButton)rdogrpc2transto.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtc2transtooth.setText(item.getc2transtooth());
             txtc2hospregno.setText(item.getc2hospregno());
             String[] d_rdogrpc3cond = new String[] {"1","2","3","4","5","6"};
             for (int i = 0; i < d_rdogrpc3cond.length; i++)
             {
                 if (item.getc3cond().equals(String.valueOf(d_rdogrpc3cond[i])))
                 {
                     rb = (RadioButton)rdogrpc3cond.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             dtpc3deathdt.setText(item.getc3deathdt().toString().length()==0 ? "" : Global.DateConvertDMY(item.getc3deathdt()));
             txtc3deathtm.setText(item.getc3deathtm());
             if(item.getc3deathdk().equals("1"))
             {
                chkc3deathdk.setChecked(true);
             }
             else if(item.getc3deathdk().equals("2"))
             {
                chkc3deathdk.setChecked(false);
             }
             String[] d_rdogrpc3transto = new String[] {"1","2","3","4"};
             for (int i = 0; i < d_rdogrpc3transto.length; i++)
             {
                 if (item.getc3transto().equals(String.valueOf(d_rdogrpc3transto[i])))
                 {
                     rb = (RadioButton)rdogrpc3transto.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtc3transtooth.setText(item.getc3transtooth());
             txtc3hospregno.setText(item.getc3hospregno());
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
            Connection.MessageBox(LD_Outcome.this, e.getMessage());
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


              dtpDate = (EditText)findViewById(R.id.dtpdiscdt);
             if (VariableID.equals("btndiscdt"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpdiscdt);
              }
             else if (VariableID.equals("btnc1deathdt"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpc1deathdt);
              }
             else if (VariableID.equals("btnc2deathdt"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpc2deathdt);
              }
             else if (VariableID.equals("btnc3deathdt"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpc3deathdt);
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


              tpTime = (EditText)findViewById(R.id.txtdisctm);
             if (VariableID.equals("btndisctm"))
              {
                  tpTime = (EditText)findViewById(R.id.txtdisctm);
              }
             else if (VariableID.equals("btnc1deathtm"))
              {
                  tpTime = (EditText)findViewById(R.id.txtc1deathtm);
              }
             else if (VariableID.equals("btnc2deathtm"))
              {
                  tpTime = (EditText)findViewById(R.id.txtc2deathtm);
              }
             else if (VariableID.equals("btnc3deathtm"))
              {
                  tpTime = (EditText)findViewById(R.id.txtc3deathtm);
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