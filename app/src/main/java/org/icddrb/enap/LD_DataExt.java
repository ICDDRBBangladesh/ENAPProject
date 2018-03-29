
 package org.icddrb.enap;


 //Android Manifest Code
 //<activity android:name=".LD_DataExt" android:label="LD_DataExt" />
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

 public class LD_DataExt extends Activity {
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

     LinearLayout secrefdodldnot;
     RadioGroup rdogrprefdodldnot;
     RadioButton rdorefdodldnot1;
     RadioButton rdorefdodldnot2;

     LinearLayout secreftodldnot;
     RadioGroup rdogrpreftodldnot;
     RadioButton rdoreftodldnot1;
     RadioButton rdoreftodldnot2;

     LinearLayout secstatus;
     RadioGroup rdogrpstatus;
     RadioButton rdostatus1;
     RadioButton rdostatus2;
     RadioButton rdostatus3;
     LinearLayout secreason;
     RadioGroup rdogrpreason;
     RadioButton rdoreason1;
     RadioButton rdoreason2;
     RadioButton rdoreason3;
     RadioButton rdoreason4;
     LinearLayout secreasmention;
     EditText txtreasmention;


         TextView lblHeading;
         LinearLayout seclbl01;
         View linelbl01;
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
         LinearLayout secrefdoe;
         View linerefdoe;
         TextView Vlblrefdoe;
         EditText dtprefdoe;
         LinearLayout secrefgald;
         View linerefgald;
         TextView Vlblrefgald;
         EditText txtrefgald;
         LinearLayout secrefgaldnot;
         View linerefgaldnot;
         TextView Vlblrefgaldnot;
         RadioGroup rdogrprefgaldnot;
         
         RadioButton rdorefgaldnot1;
         RadioButton rdorefgaldnot2;
         LinearLayout secrefacsgiven;
         View linerefacsgiven;
         TextView Vlblrefacsgiven;
         RadioGroup rdogrprefacsgiven;
         
         RadioButton rdorefacsgiven1;
         RadioButton rdorefacsgiven2;
         RadioButton rdorefacsgiven3;
         RadioButton rdorefacsgiven4;
         RadioButton rdorefacsgiven5;
         LinearLayout secrefgacalc;
         View linerefgacalc;
         TextView Vlblrefgacalc;
         EditText dtprefgacalc;
         LinearLayout secrefgacalcnot;
         View linerefgacalcnot;
         TextView Vlblrefgacalcnot;
         RadioGroup rdogrprefgacalcnot;
         
         RadioButton rdorefgacalcnot1;
         RadioButton rdorefgacalcnot2;
         LinearLayout secrefmedadeliv;
         View linerefmedadeliv;
         TextView Vlblrefmedadeliv;
         RadioGroup rdogrprefmedadeliv;
         
         RadioButton rdorefmedadeliv1;
         RadioButton rdorefmedadeliv2;
         RadioButton rdorefmedadeliv3;
         RadioButton rdorefmedadeliv4;
         LinearLayout secnumofbirth;
         View linenumofbirth;
         TextView Vlblnumofbirth;
         RadioGroup rdogrpnumofbirth;
         
         RadioButton rdonumofbirth1;
         RadioButton rdonumofbirth2;
         RadioButton rdonumofbirth3;
         LinearLayout seclbl2;
         View linelbl2;
         LinearLayout secreftypebirth1;
         View linereftypebirth1;
         TextView Vlblreftypebirth1;
         RadioGroup rdogrpreftypebirth1;
         
         RadioButton rdoreftypebirth11;
         RadioButton rdoreftypebirth12;
         RadioButton rdoreftypebirth13;
         RadioButton rdoreftypebirth14;
         RadioButton rdoreftypebirth15;
         //RadioButton rdoreftypebirth16;
         LinearLayout secrefdelivdate1;
         View linerefdelivdate1;
         TextView Vlblrefdelivdate1;
         EditText dtprefdelivdate1;

      LinearLayout secrefdelivdate1not;
      RadioGroup rdogrprefdelivdate1not;
      RadioButton rdorefdelivdate1not1;
      RadioButton rdorefdelivdate1not2;

      LinearLayout secrefdelivtime1not;
      RadioGroup rdogrprefdelivtime1not;
      RadioButton rdorefdelivtime1not1;
      RadioButton rdorefdelivtime1not2;

         LinearLayout secrefdelivtime1;
         View linerefdelivtime1;
         TextView Vlblrefdelivtime1;
         EditText txtrefdelivtime1;
         LinearLayout secrefbStatus1;
         View linerefbStatus1;
         TextView VlblrefbStatus1;
         RadioGroup rdogrprefbStatus1;
         
         RadioButton rdorefbStatus11;
         RadioButton rdorefbStatus12;
         RadioButton rdorefbStatus13;
         RadioButton rdorefbStatus14;
         LinearLayout secRefsbtype1;
         View lineRefsbtype1;
         TextView VlblRefsbtype1;
         RadioGroup rdogrpRefsbtype1;
         
         RadioButton rdoRefsbtype11;
         RadioButton rdoRefsbtype12;
         RadioButton rdoRefsbtype13;
         RadioButton rdoRefsbtype14;
         LinearLayout secrefbsex1;
         View linerefbsex1;
         TextView Vlblrefbsex1;
         RadioGroup rdogrprefbsex1;
         
         RadioButton rdorefbsex11;
         RadioButton rdorefbsex12;
         RadioButton rdorefbsex13;
         RadioButton rdorefbsex14;
         RadioButton rdorefbsex15;
         LinearLayout secrefbwgt1;
         View linerefbwgt1;
         TextView Vlblrefbwgt1;
         EditText txtrefbwgt1;
         LinearLayout secrefbwgtnot1;
         View linerefbwgtnot1;
         TextView Vlblrefbwgtnot1;
         RadioGroup rdogrprefbwgtnot1;
         
         RadioButton rdorefbwgtnot11;
         RadioButton rdorefbwgtnot12;
         LinearLayout secrefbstim1;
         View linerefbstim1;
         TextView Vlblrefbstim1;
         RadioGroup rdogrprefbstim1;
         
         RadioButton rdorefbstim11;
         RadioButton rdorefbstim12;
         RadioButton rdorefbstim13;
         RadioButton rdorefbstim14;
         LinearLayout secrefbplast1;
         View linerefbplast1;
         TextView Vlblrefbplast1;
         RadioGroup rdogrprefbplast1;
         
         RadioButton rdorefbplast11;
         RadioButton rdorefbplast12;
         RadioButton rdorefbplast13;
         RadioButton rdorefbplast14;
         LinearLayout secrefappcord1;
         View linerefappcord1;
         TextView Vlblrefappcord1;
         RadioGroup rdogrprefappcord1;
         
         RadioButton rdorefappcord11;
         RadioButton rdorefappcord12;
         RadioButton rdorefappcord13;
         RadioButton rdorefappcord14;
         LinearLayout secrefbbfd1;
         View linerefbbfd1;
         TextView Vlblrefbbfd1;
         RadioGroup rdogrprefbbfd1;
         
         RadioButton rdorefbbfd11;
         RadioButton rdorefbbfd12;
         RadioButton rdorefbbfd13;
         RadioButton rdorefbbfd14;
         RadioButton rdorefbbfd15;
         LinearLayout secrefbcond1;
         View linerefbcond1;
         TextView Vlblrefbcond1;
         RadioGroup rdogrprefbcond1;
         
         RadioButton rdorefbcond11;
         RadioButton rdorefbcond12;
         RadioButton rdorefbcond13;
         RadioButton rdorefbcond14;
         LinearLayout secrefdisoutld1;
         View linerefdisoutld1;
         TextView Vlblrefdisoutld1;
         RadioGroup rdogrprefdisoutld1;
         
         RadioButton rdorefdisoutld11;
         RadioButton rdorefdisoutld12;
         RadioButton rdorefdisoutld13;
         RadioButton rdorefdisoutld14;
         RadioButton rdorefdisoutld15;
        RadioButton rdorefdisoutld16;
         LinearLayout secrefTransPlace1;
         View linerefTransPlace1;
         TextView VlblrefTransPlace1;
         EditText txtrefTransPlace1;
         LinearLayout seclbl3;
         View linelbl3;
         LinearLayout secreftypebirth2;
         View linereftypebirth2;
         TextView Vlblreftypebirth2;
         RadioGroup rdogrpreftypebirth2;
         
         RadioButton rdoreftypebirth21;
         RadioButton rdoreftypebirth22;
         RadioButton rdoreftypebirth23;
         RadioButton rdoreftypebirth24;
         RadioButton rdoreftypebirth25;
         //RadioButton rdoreftypebirth26;
         LinearLayout secrefdelivdate2;
         View linerefdelivdate2;
         TextView Vlblrefdelivdate2;
         EditText dtprefdelivdate2;

     LinearLayout secrefdelivdate2not;
     RadioGroup rdogrprefdelivdate2not;
     RadioButton rdorefdelivdate2not1;
     RadioButton rdorefdelivdate2not2;

     LinearLayout secrefdelivtime2not;
     RadioGroup rdogrprefdelivtime2not;
     RadioButton rdorefdelivtime2not1;
     RadioButton rdorefdelivtime2not2;


         LinearLayout secrefdelivtime2;
         View linerefdelivtime2;
         TextView Vlblrefdelivtime2;
         EditText txtrefdelivtime2;
         LinearLayout secrefbStatus2;
         View linerefbStatus2;
         TextView VlblrefbStatus2;
         RadioGroup rdogrprefbStatus2;
         
         RadioButton rdorefbStatus21;
         RadioButton rdorefbStatus22;
         RadioButton rdorefbStatus23;
         RadioButton rdorefbStatus24;
         LinearLayout secRefsbtype2;
         View lineRefsbtype2;
         TextView VlblRefsbtype2;
         RadioGroup rdogrpRefsbtype2;
         
         RadioButton rdoRefsbtype21;
         RadioButton rdoRefsbtype22;
         RadioButton rdoRefsbtype23;
         RadioButton rdoRefsbtype24;
         LinearLayout secrefbsex2;
         View linerefbsex2;
         TextView Vlblrefbsex2;
         RadioGroup rdogrprefbsex2;
         
         RadioButton rdorefbsex21;
         RadioButton rdorefbsex22;
         RadioButton rdorefbsex23;
         RadioButton rdorefbsex24;
         RadioButton rdorefbsex25;
         LinearLayout secrefbwgt2;
         View linerefbwgt2;
         TextView Vlblrefbwgt2;
         EditText txtrefbwgt2;
         LinearLayout secrefbwgtnot2;
         View linerefbwgtnot2;
         TextView Vlblrefbwgtnot2;
         RadioGroup rdogrprefbwgtnot2;
         
         RadioButton rdorefbwgtnot21;
         RadioButton rdorefbwgtnot22;
         LinearLayout secrefbstim2;
         View linerefbstim2;
         TextView Vlblrefbstim2;
         RadioGroup rdogrprefbstim2;
         
         RadioButton rdorefbstim21;
         RadioButton rdorefbstim22;
         RadioButton rdorefbstim23;
         RadioButton rdorefbstim24;
         LinearLayout secrefbplast2;
         View linerefbplast2;
         TextView Vlblrefbplast2;
         RadioGroup rdogrprefbplast2;
         
         RadioButton rdorefbplast21;
         RadioButton rdorefbplast22;
         RadioButton rdorefbplast23;
         RadioButton rdorefbplast24;
         LinearLayout secrefappcord2;
         View linerefappcord2;
         TextView Vlblrefappcord2;
         RadioGroup rdogrprefappcord2;
         
         RadioButton rdorefappcord21;
         RadioButton rdorefappcord22;
         RadioButton rdorefappcord23;
         RadioButton rdorefappcord24;
         LinearLayout secrefbbfd2;
         View linerefbbfd2;
         TextView Vlblrefbbfd2;
         RadioGroup rdogrprefbbfd2;
         
         RadioButton rdorefbbfd21;
         RadioButton rdorefbbfd22;
         RadioButton rdorefbbfd23;
         RadioButton rdorefbbfd24;
         RadioButton rdorefbbfd25;
         LinearLayout secrefbcond2;
         View linerefbcond2;
         TextView Vlblrefbcond2;
         RadioGroup rdogrprefbcond2;
         
         RadioButton rdorefbcond21;
         RadioButton rdorefbcond22;
         RadioButton rdorefbcond23;
         RadioButton rdorefbcond24;
         LinearLayout secrefdisoutld2;
         View linerefdisoutld2;
         TextView Vlblrefdisoutld2;
         RadioGroup rdogrprefdisoutld2;
         
         RadioButton rdorefdisoutld21;
         RadioButton rdorefdisoutld22;
         RadioButton rdorefdisoutld23;
         RadioButton rdorefdisoutld24;
         RadioButton rdorefdisoutld25;
     RadioButton rdorefdisoutld26;
         LinearLayout secrefTransPlace2;
         View linerefTransPlace2;
         TextView VlblrefTransPlace2;
         EditText txtrefTransPlace2;
         LinearLayout seclbl4;
         View linelbl4;
         LinearLayout secreftypebirth3;
         View linereftypebirth3;
         TextView Vlblreftypebirth3;
         RadioGroup rdogrpreftypebirth3;
         
         RadioButton rdoreftypebirth31;
         RadioButton rdoreftypebirth32;
         RadioButton rdoreftypebirth33;
         RadioButton rdoreftypebirth34;
         RadioButton rdoreftypebirth35;
         //RadioButton rdoreftypebirth36;
         LinearLayout secrefdelivdate3;
         View linerefdelivdate3;
         TextView Vlblrefdelivdate3;
         EditText dtprefdelivdate3;

     LinearLayout secrefdelivdate3not;
     RadioGroup rdogrprefdelivdate3not;
     RadioButton rdorefdelivdate3not1;
     RadioButton rdorefdelivdate3not2;
     LinearLayout secrefdelivtime3not;
     RadioGroup rdogrprefdelivtime3not;
     RadioButton rdorefdelivtime3not1;
     RadioButton rdorefdelivtime3not2;



         LinearLayout secrefdelivtime3;
         View linerefdelivtime3;
         TextView Vlblrefdelivtime3;
         EditText txtrefdelivtime3;
         LinearLayout secrefbStatus3;
         View linerefbStatus3;
         TextView VlblrefbStatus3;
         RadioGroup rdogrprefbStatus3;
         
         RadioButton rdorefbStatus31;
         RadioButton rdorefbStatus32;
         RadioButton rdorefbStatus33;
         RadioButton rdorefbStatus34;
         LinearLayout secRefsbtype3;
         View lineRefsbtype3;
         TextView VlblRefsbtype3;
         RadioGroup rdogrpRefsbtype3;
         
         RadioButton rdoRefsbtype31;
         RadioButton rdoRefsbtype32;
         RadioButton rdoRefsbtype33;
         RadioButton rdoRefsbtype34;
         LinearLayout secrefbsex3;
         View linerefbsex3;
         TextView Vlblrefbsex3;
         RadioGroup rdogrprefbsex3;
         
         RadioButton rdorefbsex31;
         RadioButton rdorefbsex32;
         RadioButton rdorefbsex33;
         RadioButton rdorefbsex34;
         RadioButton rdorefbsex35;
         LinearLayout secrefbwgt3;
         View linerefbwgt3;
         TextView Vlblrefbwgt3;
         EditText txtrefbwgt3;
         LinearLayout secrefbwgtnot3;
         View linerefbwgtnot3;
         TextView Vlblrefbwgtnot3;
         RadioGroup rdogrprefbwgtnot3;
         
         RadioButton rdorefbwgtnot31;
         RadioButton rdorefbwgtnot32;
         LinearLayout secrefbstim3;
         View linerefbstim3;
         TextView Vlblrefbstim3;
         RadioGroup rdogrprefbstim3;
         
         RadioButton rdorefbstim31;
         RadioButton rdorefbstim32;
         RadioButton rdorefbstim33;
         RadioButton rdorefbstim34;
         LinearLayout secrefbplast3;
         View linerefbplast3;
         TextView Vlblrefbplast3;
         RadioGroup rdogrprefbplast3;
         
         RadioButton rdorefbplast31;
         RadioButton rdorefbplast32;
         RadioButton rdorefbplast33;
         RadioButton rdorefbplast34;
         LinearLayout secrefappcord3;
         View linerefappcord3;
         TextView Vlblrefappcord3;
         RadioGroup rdogrprefappcord3;
         
         RadioButton rdorefappcord31;
         RadioButton rdorefappcord32;
         RadioButton rdorefappcord33;
         RadioButton rdorefappcord34;
         LinearLayout secrefbbfd3;
         View linerefbbfd3;
         TextView Vlblrefbbfd3;
         RadioGroup rdogrprefbbfd3;
         
         RadioButton rdorefbbfd31;
         RadioButton rdorefbbfd32;
         RadioButton rdorefbbfd33;
         RadioButton rdorefbbfd34;
         RadioButton rdorefbbfd35;
         LinearLayout secrefbcond3;
         View linerefbcond3;
         TextView Vlblrefbcond3;
         RadioGroup rdogrprefbcond3;
         
         RadioButton rdorefbcond31;
         RadioButton rdorefbcond32;
         RadioButton rdorefbcond33;
         RadioButton rdorefbcond34;
         LinearLayout secrefdisoutld3;
         View linerefdisoutld3;
         TextView Vlblrefdisoutld3;
         RadioGroup rdogrprefdisoutld3;
         
         RadioButton rdorefdisoutld31;
         RadioButton rdorefdisoutld32;
         RadioButton rdorefdisoutld33;
         RadioButton rdorefdisoutld34;
         RadioButton rdorefdisoutld35;
     RadioButton rdorefdisoutld36;
         LinearLayout secrefTransPlace3;
         View linerefTransPlace3;
         TextView VlblrefTransPlace3;
         EditText txtrefTransPlace3;
         LinearLayout secrefpph;
         View linerefpph;
         TextView Vlblrefpph;
         EditText txtrefpph;
         LinearLayout secrefpphnot;
         View linerefpphnot;
         TextView Vlblrefpphnot;
         RadioGroup rdogrprefpphnot;
         
         RadioButton rdorefpphnot1;
         RadioButton rdorefpphnot2;
         LinearLayout secrefretainplac;
         View linerefretainplac;
         TextView Vlblrefretainplac;
         RadioGroup rdogrprefretainplac;
         
         RadioButton rdorefretainplac1;
         RadioButton rdorefretainplac2;
         RadioButton rdorefretainplac3;
         RadioButton rdorefretainplac4;
         RadioButton rdorefretainplac5;
      RadioButton rdorefretainplac6;
         LinearLayout secrefdodld;
         View linerefdodld;
         TextView Vlblrefdodld;
         EditText dtprefdodld;
         LinearLayout secreftodld;
         View linereftodld;
         TextView Vlblreftodld;
         EditText txtreftodld;
         LinearLayout secrefmatcond;
         View linerefmatcond;
         TextView Vlblrefmatcond;
         RadioGroup rdogrprefmatcond;
         
         RadioButton rdorefmatcond1;
         RadioButton rdorefmatcond2;
         RadioButton rdorefmatcond3;
         RadioButton rdorefmatcond4;
         RadioButton rdorefmatcond5;
         RadioButton rdorefmatcond6;
         LinearLayout secrefTransPlaceM;
         View linerefTransPlaceM;
         TextView VlblrefTransPlaceM;
         EditText txtrefTransPlaceM;

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
         setContentView(R.layout.ld_dataext);
         C = new Connection(this);
         g = Global.getInstance();

         STARTTIME = g.CurrentTime24();
         DEVICEID  = sp.getValue(this, "deviceid");
         ENTRYUSER = sp.getValue(this, "userid");

         IDbundle = getIntent().getExtras();
         COUNTRYCODE = IDbundle.getString("CountryCode");
         FACICODE = IDbundle.getString("FaciCode");
         DATAID = IDbundle.getString("DataID");

         TableName = "LD_DataExt";

         //turnGPSOn();

         //GPS Location
         //FindLocation();
         // Double.toString(currentLatitude);
         // Double.toString(currentLongitude);
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(LD_DataExt.this);
                 adb.setTitle("Close");
                 adb.setMessage("Do you want to close this form[Yes/No]?");
                 adb.setNegativeButton("No", null);
                 adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                     public void onClick(DialogInterface dialog, int which) {
                         finish();
                     }});
                 adb.show();
             }});

         secrefdodldnot=(LinearLayout)findViewById(R.id.secrefdodldnot) ;
         rdogrprefdodldnot=(RadioGroup)findViewById(R.id.rdogrprefdodldnot) ;
         rdorefdodldnot1=(RadioButton)findViewById(R.id.rdorefdodldnot1) ;
         rdorefdodldnot2=(RadioButton)findViewById(R.id.rdorefdodldnot2) ;

         secreftodldnot=(LinearLayout)findViewById(R.id.secreftodldnot) ;
         rdogrpreftodldnot=(RadioGroup)findViewById(R.id.rdogrpreftodldnot) ;
         rdoreftodldnot1=(RadioButton)findViewById(R.id.rdoreftodldnot1) ;
         rdoreftodldnot2=(RadioButton)findViewById(R.id.rdoreftodldnot2) ;

         secstatus=(LinearLayout)findViewById(R.id.secstatus) ;
         rdogrpstatus=(RadioGroup)findViewById(R.id.rdogrpstatus) ;
         rdostatus1=(RadioButton)findViewById(R.id.rdostatus1) ;
         rdostatus2=(RadioButton)findViewById(R.id.rdostatus2) ;
         rdostatus3=(RadioButton)findViewById(R.id.rdostatus3) ;
         secreason=(LinearLayout)findViewById(R.id.secreason) ;
         rdogrpreason=(RadioGroup)findViewById(R.id.rdogrpreason) ;
         rdoreason1=(RadioButton)findViewById(R.id.rdoreason1) ;
         rdoreason2=(RadioButton)findViewById(R.id.rdoreason2) ;
         rdoreason3=(RadioButton)findViewById(R.id.rdoreason3) ;
         rdoreason4=(RadioButton)findViewById(R.id.rdoreason4) ;
         secreasmention=(LinearLayout)findViewById(R.id.secreasmention) ;
         txtreasmention=(EditText)findViewById(R.id.txtreasmention) ;


         seclbl01=(LinearLayout)findViewById(R.id.seclbl01);
         linelbl01=(View)findViewById(R.id.linelbl01);
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
         secrefdoe=(LinearLayout)findViewById(R.id.secrefdoe);
         linerefdoe=(View)findViewById(R.id.linerefdoe);
         Vlblrefdoe=(TextView) findViewById(R.id.Vlblrefdoe);
         dtprefdoe=(EditText) findViewById(R.id.dtprefdoe);
         dtprefdoe.setText(Global.DateNowDMY());
         secrefgald=(LinearLayout)findViewById(R.id.secrefgald);
         linerefgald=(View)findViewById(R.id.linerefgald);
         Vlblrefgald=(TextView) findViewById(R.id.Vlblrefgald);
         txtrefgald=(EditText) findViewById(R.id.txtrefgald);
         secrefgaldnot=(LinearLayout)findViewById(R.id.secrefgaldnot);
         linerefgaldnot=(View)findViewById(R.id.linerefgaldnot);
         Vlblrefgaldnot = (TextView) findViewById(R.id.Vlblrefgaldnot);
         rdogrprefgaldnot = (RadioGroup) findViewById(R.id.rdogrprefgaldnot);
         
         rdorefgaldnot1 = (RadioButton) findViewById(R.id.rdorefgaldnot1);
         rdorefgaldnot2 = (RadioButton) findViewById(R.id.rdorefgaldnot2);
         secrefacsgiven=(LinearLayout)findViewById(R.id.secrefacsgiven);
         linerefacsgiven=(View)findViewById(R.id.linerefacsgiven);
         Vlblrefacsgiven = (TextView) findViewById(R.id.Vlblrefacsgiven);
         rdogrprefacsgiven = (RadioGroup) findViewById(R.id.rdogrprefacsgiven);
         
         rdorefacsgiven1 = (RadioButton) findViewById(R.id.rdorefacsgiven1);
         rdorefacsgiven2 = (RadioButton) findViewById(R.id.rdorefacsgiven2);
         rdorefacsgiven3 = (RadioButton) findViewById(R.id.rdorefacsgiven3);
         rdorefacsgiven4 = (RadioButton) findViewById(R.id.rdorefacsgiven4);
         rdorefacsgiven5 = (RadioButton) findViewById(R.id.rdorefacsgiven5);
         secrefgacalc=(LinearLayout)findViewById(R.id.secrefgacalc);
         linerefgacalc=(View)findViewById(R.id.linerefgacalc);
         Vlblrefgacalc=(TextView) findViewById(R.id.Vlblrefgacalc);
         dtprefgacalc=(EditText) findViewById(R.id.dtprefgacalc);
         secrefgacalcnot=(LinearLayout)findViewById(R.id.secrefgacalcnot);
         linerefgacalcnot=(View)findViewById(R.id.linerefgacalcnot);
         Vlblrefgacalcnot = (TextView) findViewById(R.id.Vlblrefgacalcnot);
         rdogrprefgacalcnot = (RadioGroup) findViewById(R.id.rdogrprefgacalcnot);
         
         rdorefgacalcnot1 = (RadioButton) findViewById(R.id.rdorefgacalcnot1);
         rdorefgacalcnot2 = (RadioButton) findViewById(R.id.rdorefgacalcnot2);
         secrefmedadeliv=(LinearLayout)findViewById(R.id.secrefmedadeliv);
         linerefmedadeliv=(View)findViewById(R.id.linerefmedadeliv);
         Vlblrefmedadeliv = (TextView) findViewById(R.id.Vlblrefmedadeliv);
         rdogrprefmedadeliv = (RadioGroup) findViewById(R.id.rdogrprefmedadeliv);
         
         rdorefmedadeliv1 = (RadioButton) findViewById(R.id.rdorefmedadeliv1);
         rdorefmedadeliv2 = (RadioButton) findViewById(R.id.rdorefmedadeliv2);
         rdorefmedadeliv3 = (RadioButton) findViewById(R.id.rdorefmedadeliv3);
         rdorefmedadeliv4 = (RadioButton) findViewById(R.id.rdorefmedadeliv4);
         secnumofbirth=(LinearLayout)findViewById(R.id.secnumofbirth);
         linenumofbirth=(View)findViewById(R.id.linenumofbirth);
         Vlblnumofbirth = (TextView) findViewById(R.id.Vlblnumofbirth);
         rdogrpnumofbirth = (RadioGroup) findViewById(R.id.rdogrpnumofbirth);
         
         rdonumofbirth1 = (RadioButton) findViewById(R.id.rdonumofbirth1);
         rdonumofbirth2 = (RadioButton) findViewById(R.id.rdonumofbirth2);
         rdonumofbirth3 = (RadioButton) findViewById(R.id.rdonumofbirth3);
         rdogrpnumofbirth.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpnumofbirth = new String[] {"1","2","3"};
             for (int i = 0; i < rdogrpnumofbirth.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpnumofbirth.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpnumofbirth[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                    seclbl2.setVisibility(View.VISIBLE);
                    linelbl2.setVisibility(View.VISIBLE);
                    secreftypebirth1.setVisibility(View.VISIBLE);
                    linereftypebirth1.setVisibility(View.VISIBLE);
                    secrefdelivdate1.setVisibility(View.VISIBLE);
                  secrefdelivdate1not.setVisibility(View.VISIBLE);
                    linerefdelivdate1.setVisibility(View.VISIBLE);
                    secrefdelivtime1.setVisibility(View.VISIBLE);
                  secrefdelivtime1not.setVisibility(View.VISIBLE);
                    linerefdelivtime1.setVisibility(View.VISIBLE);
                    secrefbStatus1.setVisibility(View.VISIBLE);
                    linerefbStatus1.setVisibility(View.VISIBLE);
                    secRefsbtype1.setVisibility(View.VISIBLE);
                    lineRefsbtype1.setVisibility(View.VISIBLE);
                    secrefbsex1.setVisibility(View.VISIBLE);
                    linerefbsex1.setVisibility(View.VISIBLE);
                    secrefbwgt1.setVisibility(View.VISIBLE);
                    linerefbwgt1.setVisibility(View.VISIBLE);
                    secrefbwgtnot1.setVisibility(View.VISIBLE);
                    linerefbwgtnot1.setVisibility(View.VISIBLE);
                    secrefbstim1.setVisibility(View.VISIBLE);
                    linerefbstim1.setVisibility(View.VISIBLE);
                    secrefbplast1.setVisibility(View.VISIBLE);
                    linerefbplast1.setVisibility(View.VISIBLE);
                    secrefappcord1.setVisibility(View.VISIBLE);
                    linerefappcord1.setVisibility(View.VISIBLE);
                    secrefbbfd1.setVisibility(View.VISIBLE);
                    linerefbbfd1.setVisibility(View.VISIBLE);

                 if(rdorefbStatus12.isChecked()) {
                     secrefbcond1.setVisibility(View.GONE);
                     linerefbcond1.setVisibility(View.GONE);
                     secrefdisoutld1.setVisibility(View.GONE);
                     linerefdisoutld1.setVisibility(View.GONE);
                 }else{
                     secrefbcond1.setVisibility(View.VISIBLE);
                     linerefbcond1.setVisibility(View.VISIBLE);
                     secrefdisoutld1.setVisibility(View.VISIBLE);
                     linerefdisoutld1.setVisibility(View.VISIBLE);
                 }

                    secrefTransPlace1.setVisibility(View.GONE);
                    linerefTransPlace1.setVisibility(View.GONE);
                    txtrefTransPlace1.setText("");
                    seclbl3.setVisibility(View.GONE);
                    linelbl3.setVisibility(View.GONE);
                    secreftypebirth2.setVisibility(View.GONE);
                    linereftypebirth2.setVisibility(View.GONE);
                    rdogrpreftypebirth2.clearCheck();
                    secrefdelivdate2.setVisibility(View.GONE);
                 secrefdelivdate2not.setVisibility(View.GONE);
                    linerefdelivdate2.setVisibility(View.GONE);
                    dtprefdelivdate2.setText("");
                    secrefdelivtime2.setVisibility(View.GONE);
                 secrefdelivtime2not.setVisibility(View.GONE);
                    linerefdelivtime2.setVisibility(View.GONE);
                    txtrefdelivtime2.setText("");
                    secrefbStatus2.setVisibility(View.GONE);
                    linerefbStatus2.setVisibility(View.GONE);
                    rdogrprefbStatus2.clearCheck();
                    secRefsbtype2.setVisibility(View.GONE);
                    lineRefsbtype2.setVisibility(View.GONE);
                    rdogrpRefsbtype2.clearCheck();
                    secrefbsex2.setVisibility(View.GONE);
                    linerefbsex2.setVisibility(View.GONE);
                    rdogrprefbsex2.clearCheck();
                    secrefbwgt2.setVisibility(View.GONE);
                    linerefbwgt2.setVisibility(View.GONE);
                    txtrefbwgt2.setText("");
                    secrefbwgtnot2.setVisibility(View.GONE);
                    linerefbwgtnot2.setVisibility(View.GONE);
                    rdogrprefbwgtnot2.clearCheck();
                    secrefbstim2.setVisibility(View.GONE);
                    linerefbstim2.setVisibility(View.GONE);
                    rdogrprefbstim2.clearCheck();
                    secrefbplast2.setVisibility(View.GONE);
                    linerefbplast2.setVisibility(View.GONE);
                    rdogrprefbplast2.clearCheck();
                    secrefappcord2.setVisibility(View.GONE);
                    linerefappcord2.setVisibility(View.GONE);
                    rdogrprefappcord2.clearCheck();
                    secrefbbfd2.setVisibility(View.GONE);
                    linerefbbfd2.setVisibility(View.GONE);
                    rdogrprefbbfd2.clearCheck();
                    secrefbcond2.setVisibility(View.GONE);
                    linerefbcond2.setVisibility(View.GONE);
                    rdogrprefbcond2.clearCheck();
                    secrefdisoutld2.setVisibility(View.GONE);
                    linerefdisoutld2.setVisibility(View.GONE);
                    rdogrprefdisoutld2.clearCheck();
                    secrefTransPlace2.setVisibility(View.GONE);
                    linerefTransPlace2.setVisibility(View.GONE);
                    txtrefTransPlace2.setText("");
                    seclbl4.setVisibility(View.GONE);
                    linelbl4.setVisibility(View.GONE);
                    secreftypebirth3.setVisibility(View.GONE);
                    linereftypebirth3.setVisibility(View.GONE);
                    rdogrpreftypebirth3.clearCheck();
                    secrefdelivdate3.setVisibility(View.GONE);
                 secrefdelivdate3not.setVisibility(View.GONE);
                    linerefdelivdate3.setVisibility(View.GONE);
                    dtprefdelivdate3.setText("");
                    secrefdelivtime3.setVisibility(View.GONE);
                 secrefdelivtime3not.setVisibility(View.GONE);
                    linerefdelivtime3.setVisibility(View.GONE);
                    txtrefdelivtime3.setText("");
                    secrefbStatus3.setVisibility(View.GONE);
                    linerefbStatus3.setVisibility(View.GONE);
                    rdogrprefbStatus3.clearCheck();
                    secRefsbtype3.setVisibility(View.GONE);
                    lineRefsbtype3.setVisibility(View.GONE);
                    rdogrpRefsbtype3.clearCheck();
                    secrefbsex3.setVisibility(View.GONE);
                    linerefbsex3.setVisibility(View.GONE);
                    rdogrprefbsex3.clearCheck();
                    secrefbwgt3.setVisibility(View.GONE);
                    linerefbwgt3.setVisibility(View.GONE);
                    txtrefbwgt3.setText("");
                    secrefbwgtnot3.setVisibility(View.GONE);
                    linerefbwgtnot3.setVisibility(View.GONE);
                    rdogrprefbwgtnot3.clearCheck();
                    secrefbstim3.setVisibility(View.GONE);
                    linerefbstim3.setVisibility(View.GONE);
                    rdogrprefbstim3.clearCheck();
                    secrefbplast3.setVisibility(View.GONE);
                    linerefbplast3.setVisibility(View.GONE);
                    rdogrprefbplast3.clearCheck();
                    secrefappcord3.setVisibility(View.GONE);
                    linerefappcord3.setVisibility(View.GONE);
                    rdogrprefappcord3.clearCheck();
                    secrefbbfd3.setVisibility(View.GONE);
                    linerefbbfd3.setVisibility(View.GONE);
                    rdogrprefbbfd3.clearCheck();
                    secrefbcond3.setVisibility(View.GONE);
                    linerefbcond3.setVisibility(View.GONE);
                    rdogrprefbcond3.clearCheck();
                    secrefdisoutld3.setVisibility(View.GONE);
                    linerefdisoutld3.setVisibility(View.GONE);
                    rdogrprefdisoutld3.clearCheck();
                    secrefTransPlace3.setVisibility(View.GONE);
                    linerefTransPlace3.setVisibility(View.GONE);
                    txtrefTransPlace3.setText("");
             }
             else if(rbData.equalsIgnoreCase("2"))
             {
                 seclbl2.setVisibility(View.VISIBLE);
                 linelbl2.setVisibility(View.VISIBLE);
                 secreftypebirth1.setVisibility(View.VISIBLE);
                 linereftypebirth1.setVisibility(View.VISIBLE);
                 secrefdelivdate1.setVisibility(View.VISIBLE);
                  secrefdelivdate1not.setVisibility(View.VISIBLE);
                 linerefdelivdate1.setVisibility(View.VISIBLE);
                 secrefdelivtime1.setVisibility(View.VISIBLE);
                  secrefdelivtime1not.setVisibility(View.VISIBLE);
                 linerefdelivtime1.setVisibility(View.VISIBLE);
                 secrefbStatus1.setVisibility(View.VISIBLE);
                 linerefbStatus1.setVisibility(View.VISIBLE);
                 secRefsbtype1.setVisibility(View.VISIBLE);
                 lineRefsbtype1.setVisibility(View.VISIBLE);
                 secrefbsex1.setVisibility(View.VISIBLE);
                 linerefbsex1.setVisibility(View.VISIBLE);
                 secrefbwgt1.setVisibility(View.VISIBLE);
                 linerefbwgt1.setVisibility(View.VISIBLE);
                 secrefbwgtnot1.setVisibility(View.VISIBLE);
                 linerefbwgtnot1.setVisibility(View.VISIBLE);
                 secrefbstim1.setVisibility(View.VISIBLE);
                 linerefbstim1.setVisibility(View.VISIBLE);
                 secrefbplast1.setVisibility(View.VISIBLE);
                 linerefbplast1.setVisibility(View.VISIBLE);
                 secrefappcord1.setVisibility(View.VISIBLE);
                 linerefappcord1.setVisibility(View.VISIBLE);
                 secrefbbfd1.setVisibility(View.VISIBLE);
                 linerefbbfd1.setVisibility(View.VISIBLE);
                 if(rdorefbStatus12.isChecked()) {
                     secrefbcond1.setVisibility(View.GONE);
                     linerefbcond1.setVisibility(View.GONE);
                     secrefdisoutld1.setVisibility(View.GONE);
                     linerefdisoutld1.setVisibility(View.GONE);
                 }else{
                     secrefbcond1.setVisibility(View.VISIBLE);
                     linerefbcond1.setVisibility(View.VISIBLE);
                     secrefdisoutld1.setVisibility(View.VISIBLE);
                     linerefdisoutld1.setVisibility(View.VISIBLE);
                 }
                 rdogrprefdisoutld1.clearCheck();
                 secrefTransPlace1.setVisibility(View.GONE);
                 linerefTransPlace1.setVisibility(View.GONE);

                 seclbl3.setVisibility(View.VISIBLE);
                 linelbl3.setVisibility(View.VISIBLE);
                 secreftypebirth2.setVisibility(View.VISIBLE);
                 linereftypebirth2.setVisibility(View.VISIBLE);
                 secrefdelivdate2.setVisibility(View.VISIBLE);
                 secrefdelivdate2not.setVisibility(View.VISIBLE);
                 linerefdelivdate2.setVisibility(View.VISIBLE);
                 secrefdelivtime2.setVisibility(View.VISIBLE);
                 secrefdelivtime2not.setVisibility(View.VISIBLE);
                 linerefdelivtime2.setVisibility(View.VISIBLE);
                 secrefbStatus2.setVisibility(View.VISIBLE);
                 linerefbStatus2.setVisibility(View.VISIBLE);
                 secRefsbtype2.setVisibility(View.VISIBLE);
                 lineRefsbtype2.setVisibility(View.VISIBLE);
                 secrefbsex2.setVisibility(View.VISIBLE);
                 linerefbsex2.setVisibility(View.VISIBLE);
                 secrefbwgt2.setVisibility(View.VISIBLE);
                 linerefbwgt2.setVisibility(View.VISIBLE);
                 secrefbwgtnot2.setVisibility(View.VISIBLE);
                 linerefbwgtnot2.setVisibility(View.VISIBLE);
                 secrefbstim2.setVisibility(View.VISIBLE);
                 linerefbstim2.setVisibility(View.VISIBLE);
                 secrefbplast2.setVisibility(View.VISIBLE);
                 linerefbplast2.setVisibility(View.VISIBLE);
                 secrefappcord2.setVisibility(View.VISIBLE);
                 linerefappcord2.setVisibility(View.VISIBLE);
                 secrefbbfd2.setVisibility(View.VISIBLE);
                 linerefbbfd2.setVisibility(View.VISIBLE);
                 secrefbcond2.setVisibility(View.VISIBLE);
                 linerefbcond2.setVisibility(View.VISIBLE);
                 secrefdisoutld2.setVisibility(View.VISIBLE);
                 linerefdisoutld2.setVisibility(View.VISIBLE);
                 rdogrprefdisoutld2.clearCheck();
                 secrefTransPlace2.setVisibility(View.GONE);
                 linerefTransPlace2.setVisibility(View.GONE);

                 seclbl4.setVisibility(View.GONE);
                 linelbl4.setVisibility(View.GONE);
                 secreftypebirth3.setVisibility(View.GONE);
                 linereftypebirth3.setVisibility(View.GONE);
                 rdogrpreftypebirth3.clearCheck();
                 secrefdelivdate3.setVisibility(View.GONE);
                 secrefdelivdate3not.setVisibility(View.GONE);
                 linerefdelivdate3.setVisibility(View.GONE);
                 dtprefdelivdate3.setText("");
                 secrefdelivtime3.setVisibility(View.GONE);
                 secrefdelivtime3not.setVisibility(View.GONE);
                 linerefdelivtime3.setVisibility(View.GONE);
                 txtrefdelivtime3.setText("");
                 secrefbStatus3.setVisibility(View.GONE);
                 linerefbStatus3.setVisibility(View.GONE);
                 rdogrprefbStatus3.clearCheck();
                 secRefsbtype3.setVisibility(View.GONE);
                 lineRefsbtype3.setVisibility(View.GONE);
                 rdogrpRefsbtype3.clearCheck();
                 secrefbsex3.setVisibility(View.GONE);
                 linerefbsex3.setVisibility(View.GONE);
                 rdogrprefbsex3.clearCheck();
                 secrefbwgt3.setVisibility(View.GONE);
                 linerefbwgt3.setVisibility(View.GONE);
                 txtrefbwgt3.setText("");
                 secrefbwgtnot3.setVisibility(View.GONE);
                 linerefbwgtnot3.setVisibility(View.GONE);
                 rdogrprefbwgtnot3.clearCheck();
                 secrefbstim3.setVisibility(View.GONE);
                 linerefbstim3.setVisibility(View.GONE);
                 rdogrprefbstim3.clearCheck();
                 secrefbplast3.setVisibility(View.GONE);
                 linerefbplast3.setVisibility(View.GONE);
                 rdogrprefbplast3.clearCheck();
                 secrefappcord3.setVisibility(View.GONE);
                 linerefappcord3.setVisibility(View.GONE);
                 rdogrprefappcord3.clearCheck();
                 secrefbbfd3.setVisibility(View.GONE);
                 linerefbbfd3.setVisibility(View.GONE);
                 rdogrprefbbfd3.clearCheck();
                 secrefbcond3.setVisibility(View.GONE);
                 linerefbcond3.setVisibility(View.GONE);
                 rdogrprefbcond3.clearCheck();
                 secrefdisoutld3.setVisibility(View.GONE);
                 linerefdisoutld3.setVisibility(View.GONE);
                 rdogrprefdisoutld3.clearCheck();
                 secrefTransPlace3.setVisibility(View.GONE);
                 linerefTransPlace3.setVisibility(View.GONE);
                 txtrefTransPlace3.setText("");
             }
             else if(rbData.equalsIgnoreCase("3"))
             {
                 seclbl2.setVisibility(View.VISIBLE);
                 linelbl2.setVisibility(View.VISIBLE);
                 secreftypebirth1.setVisibility(View.VISIBLE);
                 linereftypebirth1.setVisibility(View.VISIBLE);
                 secrefdelivdate1.setVisibility(View.VISIBLE);
                  secrefdelivdate1not.setVisibility(View.VISIBLE);
                 linerefdelivdate1.setVisibility(View.VISIBLE);
                 secrefdelivtime1.setVisibility(View.VISIBLE);
                  secrefdelivtime1not.setVisibility(View.VISIBLE);
                 linerefdelivtime1.setVisibility(View.VISIBLE);
                 secrefbStatus1.setVisibility(View.VISIBLE);
                 linerefbStatus1.setVisibility(View.VISIBLE);
                 secRefsbtype1.setVisibility(View.VISIBLE);
                 lineRefsbtype1.setVisibility(View.VISIBLE);
                 secrefbsex1.setVisibility(View.VISIBLE);
                 linerefbsex1.setVisibility(View.VISIBLE);
                 secrefbwgt1.setVisibility(View.VISIBLE);
                 linerefbwgt1.setVisibility(View.VISIBLE);
                 secrefbwgtnot1.setVisibility(View.VISIBLE);
                 linerefbwgtnot1.setVisibility(View.VISIBLE);
                 secrefbstim1.setVisibility(View.VISIBLE);
                 linerefbstim1.setVisibility(View.VISIBLE);
                 secrefbplast1.setVisibility(View.VISIBLE);
                 linerefbplast1.setVisibility(View.VISIBLE);

                 secrefappcord1.setVisibility(View.VISIBLE);
                 linerefappcord1.setVisibility(View.VISIBLE);
                 secrefbbfd1.setVisibility(View.VISIBLE);
                 linerefbbfd1.setVisibility(View.VISIBLE);

                 if(rdorefbStatus12.isChecked()) {
                     secrefbcond1.setVisibility(View.GONE);
                     linerefbcond1.setVisibility(View.GONE);
                     secrefdisoutld1.setVisibility(View.GONE);
                     linerefdisoutld1.setVisibility(View.GONE);
                 }else{
                     secrefbcond1.setVisibility(View.VISIBLE);
                     linerefbcond1.setVisibility(View.VISIBLE);
                     secrefdisoutld1.setVisibility(View.VISIBLE);
                     linerefdisoutld1.setVisibility(View.VISIBLE);
                 }

                 secrefTransPlace1.setVisibility(View.GONE);
                 linerefTransPlace1.setVisibility(View.GONE);
                 seclbl3.setVisibility(View.VISIBLE);
                 linelbl3.setVisibility(View.VISIBLE);
                 secreftypebirth2.setVisibility(View.VISIBLE);
                 linereftypebirth2.setVisibility(View.VISIBLE);
                 secrefdelivdate2.setVisibility(View.VISIBLE);
                 secrefdelivdate2not.setVisibility(View.VISIBLE);
                 linerefdelivdate2.setVisibility(View.VISIBLE);
                 secrefdelivtime2.setVisibility(View.VISIBLE);
                 secrefdelivtime2not.setVisibility(View.VISIBLE);
                 linerefdelivtime2.setVisibility(View.VISIBLE);
                 secrefbStatus2.setVisibility(View.VISIBLE);
                 linerefbStatus2.setVisibility(View.VISIBLE);
                 secRefsbtype2.setVisibility(View.VISIBLE);
                 lineRefsbtype2.setVisibility(View.VISIBLE);
                 secrefbsex2.setVisibility(View.VISIBLE);
                 linerefbsex2.setVisibility(View.VISIBLE);
                 secrefbwgt2.setVisibility(View.VISIBLE);
                 linerefbwgt2.setVisibility(View.VISIBLE);
                 secrefbwgtnot2.setVisibility(View.VISIBLE);
                 linerefbwgtnot2.setVisibility(View.VISIBLE);
                 secrefbstim2.setVisibility(View.VISIBLE);
                 linerefbstim2.setVisibility(View.VISIBLE);
                 secrefbplast2.setVisibility(View.VISIBLE);
                 linerefbplast2.setVisibility(View.VISIBLE);
                 secrefappcord2.setVisibility(View.VISIBLE);
                 linerefappcord2.setVisibility(View.VISIBLE);
                 secrefbbfd2.setVisibility(View.VISIBLE);
                 linerefbbfd2.setVisibility(View.VISIBLE);
                 secrefbcond2.setVisibility(View.VISIBLE);
                 linerefbcond2.setVisibility(View.VISIBLE);
                 secrefdisoutld2.setVisibility(View.VISIBLE);
                 linerefdisoutld2.setVisibility(View.VISIBLE);

                 secrefTransPlace2.setVisibility(View.GONE);
                 linerefTransPlace2.setVisibility(View.GONE);

                 seclbl4.setVisibility(View.VISIBLE);
                 linelbl4.setVisibility(View.VISIBLE);
                 secreftypebirth3.setVisibility(View.VISIBLE);
                 linereftypebirth3.setVisibility(View.VISIBLE);
                 secrefdelivdate3.setVisibility(View.VISIBLE);
                 secrefdelivdate3not.setVisibility(View.VISIBLE);
                 linerefdelivdate3.setVisibility(View.VISIBLE);
                 secrefdelivtime3.setVisibility(View.VISIBLE);
                 secrefdelivtime3not.setVisibility(View.VISIBLE);
                 linerefdelivtime3.setVisibility(View.VISIBLE);
                 secrefbStatus3.setVisibility(View.VISIBLE);
                 linerefbStatus3.setVisibility(View.VISIBLE);
                 secRefsbtype3.setVisibility(View.VISIBLE);
                 lineRefsbtype3.setVisibility(View.VISIBLE);
                 secrefbsex3.setVisibility(View.VISIBLE);
                 linerefbsex3.setVisibility(View.VISIBLE);
                 secrefbwgt3.setVisibility(View.VISIBLE);
                 linerefbwgt3.setVisibility(View.VISIBLE);
                 secrefbwgtnot3.setVisibility(View.VISIBLE);
                 linerefbwgtnot3.setVisibility(View.VISIBLE);
                 secrefbstim3.setVisibility(View.VISIBLE);
                 linerefbstim3.setVisibility(View.VISIBLE);
                 secrefbplast3.setVisibility(View.VISIBLE);
                 linerefbplast3.setVisibility(View.VISIBLE);
                 secrefappcord3.setVisibility(View.VISIBLE);
                 linerefappcord3.setVisibility(View.VISIBLE);
                 secrefbbfd3.setVisibility(View.VISIBLE);
                 linerefbbfd3.setVisibility(View.VISIBLE);
                 secrefbcond3.setVisibility(View.VISIBLE);
                 linerefbcond3.setVisibility(View.VISIBLE);
                 secrefdisoutld3.setVisibility(View.VISIBLE);
                 linerefdisoutld3.setVisibility(View.VISIBLE);
                 secrefTransPlace3.setVisibility(View.GONE);
                 linerefTransPlace3.setVisibility(View.GONE);


             }
             else
             {
                    seclbl2.setVisibility(View.VISIBLE);
                    linelbl2.setVisibility(View.VISIBLE);
                    secreftypebirth1.setVisibility(View.VISIBLE);
                    linereftypebirth1.setVisibility(View.VISIBLE);
                    secrefdelivdate1.setVisibility(View.VISIBLE);
                  secrefdelivdate1not.setVisibility(View.VISIBLE);
                    linerefdelivdate1.setVisibility(View.VISIBLE);
                    secrefdelivtime1.setVisibility(View.VISIBLE);
                  secrefdelivtime1not.setVisibility(View.VISIBLE);
                    linerefdelivtime1.setVisibility(View.VISIBLE);
                    secrefbStatus1.setVisibility(View.VISIBLE);
                    linerefbStatus1.setVisibility(View.VISIBLE);
                    secRefsbtype1.setVisibility(View.VISIBLE);
                    lineRefsbtype1.setVisibility(View.VISIBLE);
                    secrefbsex1.setVisibility(View.VISIBLE);
                    linerefbsex1.setVisibility(View.VISIBLE);
                    secrefbwgt1.setVisibility(View.VISIBLE);
                    linerefbwgt1.setVisibility(View.VISIBLE);
                    secrefbwgtnot1.setVisibility(View.VISIBLE);
                    linerefbwgtnot1.setVisibility(View.VISIBLE);
                    secrefbstim1.setVisibility(View.VISIBLE);
                    linerefbstim1.setVisibility(View.VISIBLE);
                    secrefbplast1.setVisibility(View.VISIBLE);
                    linerefbplast1.setVisibility(View.VISIBLE);
                    secrefappcord1.setVisibility(View.VISIBLE);
                    linerefappcord1.setVisibility(View.VISIBLE);
                    secrefbbfd1.setVisibility(View.VISIBLE);
                    linerefbbfd1.setVisibility(View.VISIBLE);
                    secrefbcond1.setVisibility(View.VISIBLE);
                    linerefbcond1.setVisibility(View.VISIBLE);
                    secrefdisoutld1.setVisibility(View.VISIBLE);
                    linerefdisoutld1.setVisibility(View.VISIBLE);
                    secrefTransPlace1.setVisibility(View.VISIBLE);
                    linerefTransPlace1.setVisibility(View.VISIBLE);
                    seclbl3.setVisibility(View.VISIBLE);
                    linelbl3.setVisibility(View.VISIBLE);
                    secreftypebirth2.setVisibility(View.VISIBLE);
                    linereftypebirth2.setVisibility(View.VISIBLE);
                    secrefdelivdate2.setVisibility(View.VISIBLE);
                 secrefdelivdate2not.setVisibility(View.VISIBLE);
                    linerefdelivdate2.setVisibility(View.VISIBLE);
                    secrefdelivtime2.setVisibility(View.VISIBLE);
                 secrefdelivtime2not.setVisibility(View.VISIBLE);
                    linerefdelivtime2.setVisibility(View.VISIBLE);
                    secrefbStatus2.setVisibility(View.VISIBLE);
                    linerefbStatus2.setVisibility(View.VISIBLE);
                    secRefsbtype2.setVisibility(View.VISIBLE);
                    lineRefsbtype2.setVisibility(View.VISIBLE);
                    secrefbsex2.setVisibility(View.VISIBLE);
                    linerefbsex2.setVisibility(View.VISIBLE);
                    secrefbwgt2.setVisibility(View.VISIBLE);
                    linerefbwgt2.setVisibility(View.VISIBLE);
                    secrefbwgtnot2.setVisibility(View.VISIBLE);
                    linerefbwgtnot2.setVisibility(View.VISIBLE);
                    secrefbstim2.setVisibility(View.VISIBLE);
                    linerefbstim2.setVisibility(View.VISIBLE);
                    secrefbplast2.setVisibility(View.VISIBLE);
                    linerefbplast2.setVisibility(View.VISIBLE);
                    secrefappcord2.setVisibility(View.VISIBLE);
                    linerefappcord2.setVisibility(View.VISIBLE);
                    secrefbbfd2.setVisibility(View.VISIBLE);
                    linerefbbfd2.setVisibility(View.VISIBLE);
                    secrefbcond2.setVisibility(View.VISIBLE);
                    linerefbcond2.setVisibility(View.VISIBLE);
                    secrefdisoutld2.setVisibility(View.VISIBLE);
                    linerefdisoutld2.setVisibility(View.VISIBLE);
                    secrefTransPlace2.setVisibility(View.VISIBLE);
                    linerefTransPlace2.setVisibility(View.VISIBLE);
                    seclbl4.setVisibility(View.VISIBLE);
                    linelbl4.setVisibility(View.VISIBLE);
                    secreftypebirth3.setVisibility(View.VISIBLE);
                    linereftypebirth3.setVisibility(View.VISIBLE);
                    secrefdelivdate3.setVisibility(View.VISIBLE);
                 secrefdelivdate3not.setVisibility(View.VISIBLE);
                    linerefdelivdate3.setVisibility(View.VISIBLE);
                    secrefdelivtime3.setVisibility(View.VISIBLE);
                 secrefdelivtime3not.setVisibility(View.VISIBLE);
                    linerefdelivtime3.setVisibility(View.VISIBLE);
                    secrefbStatus3.setVisibility(View.VISIBLE);
                    linerefbStatus3.setVisibility(View.VISIBLE);
                    secRefsbtype3.setVisibility(View.VISIBLE);
                    lineRefsbtype3.setVisibility(View.VISIBLE);
                    secrefbsex3.setVisibility(View.VISIBLE);
                    linerefbsex3.setVisibility(View.VISIBLE);
                    secrefbwgt3.setVisibility(View.VISIBLE);
                    linerefbwgt3.setVisibility(View.VISIBLE);
                    secrefbwgtnot3.setVisibility(View.VISIBLE);
                    linerefbwgtnot3.setVisibility(View.VISIBLE);
                    secrefbstim3.setVisibility(View.VISIBLE);
                    linerefbstim3.setVisibility(View.VISIBLE);
                    secrefbplast3.setVisibility(View.VISIBLE);
                    linerefbplast3.setVisibility(View.VISIBLE);
                    secrefappcord3.setVisibility(View.VISIBLE);
                    linerefappcord3.setVisibility(View.VISIBLE);
                    secrefbbfd3.setVisibility(View.VISIBLE);
                    linerefbbfd3.setVisibility(View.VISIBLE);
                    secrefbcond3.setVisibility(View.VISIBLE);
                    linerefbcond3.setVisibility(View.VISIBLE);
                    secrefdisoutld3.setVisibility(View.VISIBLE);
                    linerefdisoutld3.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         seclbl2=(LinearLayout)findViewById(R.id.seclbl2);
         linelbl2=(View)findViewById(R.id.linelbl2);
         secreftypebirth1=(LinearLayout)findViewById(R.id.secreftypebirth1);
         linereftypebirth1=(View)findViewById(R.id.linereftypebirth1);
         Vlblreftypebirth1 = (TextView) findViewById(R.id.Vlblreftypebirth1);
         rdogrpreftypebirth1 = (RadioGroup) findViewById(R.id.rdogrpreftypebirth1);
         
         rdoreftypebirth11 = (RadioButton) findViewById(R.id.rdoreftypebirth11);
         rdoreftypebirth12 = (RadioButton) findViewById(R.id.rdoreftypebirth12);
         rdoreftypebirth13 = (RadioButton) findViewById(R.id.rdoreftypebirth13);
         rdoreftypebirth14 = (RadioButton) findViewById(R.id.rdoreftypebirth14);
         rdoreftypebirth15 = (RadioButton) findViewById(R.id.rdoreftypebirth15);
         //rdoreftypebirth16 = (RadioButton) findViewById(R.id.rdoreftypebirth16);
         secrefdelivdate1=(LinearLayout)findViewById(R.id.secrefdelivdate1);
         linerefdelivdate1=(View)findViewById(R.id.linerefdelivdate1);
         Vlblrefdelivdate1=(TextView) findViewById(R.id.Vlblrefdelivdate1);
         dtprefdelivdate1=(EditText) findViewById(R.id.dtprefdelivdate1);

          secrefdelivdate1not=(LinearLayout)findViewById(R.id.secrefdelivdate1not) ;
          rdogrprefdelivdate1not=(RadioGroup)findViewById(R.id.rdogrprefdelivdate1not) ;
          rdorefdelivdate1not1=(RadioButton)findViewById(R.id.rdorefdelivdate1not1) ;
          rdorefdelivdate1not2=(RadioButton)findViewById(R.id.rdorefdelivdate1not2) ;

          secrefdelivtime1not=(LinearLayout)findViewById(R.id.secrefdelivtime1not) ;
          rdogrprefdelivtime1not=(RadioGroup)findViewById(R.id.rdogrprefdelivtime1not) ;
          rdorefdelivtime1not1=(RadioButton)findViewById(R.id.rdorefdelivtime1not1) ;
          rdorefdelivtime1not2=(RadioButton)findViewById(R.id.rdorefdelivtime1not2) ;

         secrefdelivtime1=(LinearLayout)findViewById(R.id.secrefdelivtime1);
         linerefdelivtime1=(View)findViewById(R.id.linerefdelivtime1);
         Vlblrefdelivtime1=(TextView) findViewById(R.id.Vlblrefdelivtime1);
         txtrefdelivtime1=(EditText) findViewById(R.id.txtrefdelivtime1);
         secrefbStatus1=(LinearLayout)findViewById(R.id.secrefbStatus1);
         linerefbStatus1=(View)findViewById(R.id.linerefbStatus1);
         VlblrefbStatus1 = (TextView) findViewById(R.id.VlblrefbStatus1);
         rdogrprefbStatus1 = (RadioGroup) findViewById(R.id.rdogrprefbStatus1);
         
         rdorefbStatus11 = (RadioButton) findViewById(R.id.rdorefbStatus11);
         rdorefbStatus12 = (RadioButton) findViewById(R.id.rdorefbStatus12);
         rdorefbStatus13 = (RadioButton) findViewById(R.id.rdorefbStatus13);
         rdorefbStatus14 = (RadioButton) findViewById(R.id.rdorefbStatus14);
         rdogrprefbStatus1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrprefbStatus1 = new String[] {"1","2","8","9"};
             for (int i = 0; i < rdogrprefbStatus1.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrprefbStatus1.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrprefbStatus1[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                 secRefsbtype1.setVisibility(View.GONE);
                 lineRefsbtype1.setVisibility(View.GONE);
                 rdogrpRefsbtype1.clearCheck();
                 secrefbcond1.setVisibility(View.VISIBLE);
                 secrefdisoutld1.setVisibility(View.VISIBLE);
             }else if(rbData.equalsIgnoreCase("2")){
                 secRefsbtype1.setVisibility(View.VISIBLE);
                 lineRefsbtype1.setVisibility(View.VISIBLE);
                 secrefbcond1.setVisibility(View.GONE);
                 rdogrprefbcond1.clearCheck();
                 secrefdisoutld1.setVisibility(View.GONE);
                 rdogrprefdisoutld1.clearCheck();
                 secrefTransPlace1.setVisibility(View.GONE);
                 txtrefTransPlace1.setText("");
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secRefsbtype1.setVisibility(View.GONE);
                    lineRefsbtype1.setVisibility(View.GONE);
                    rdogrpRefsbtype1.clearCheck();
                 secrefbcond1.setVisibility(View.VISIBLE);
                 secrefdisoutld1.setVisibility(View.VISIBLE);

             }
             else if(rbData.equalsIgnoreCase("9"))
             {
                    secRefsbtype1.setVisibility(View.GONE);
                    lineRefsbtype1.setVisibility(View.GONE);
                    rdogrpRefsbtype1.clearCheck();
                 secrefbcond1.setVisibility(View.VISIBLE);
                 secrefdisoutld1.setVisibility(View.VISIBLE);

             }
             else
             {
                 secRefsbtype1.setVisibility(View.VISIBLE);
                 lineRefsbtype1.setVisibility(View.VISIBLE);
                 secrefbcond1.setVisibility(View.VISIBLE);
                 secrefdisoutld1.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secRefsbtype1=(LinearLayout)findViewById(R.id.secRefsbtype1);
         lineRefsbtype1=(View)findViewById(R.id.lineRefsbtype1);
         VlblRefsbtype1 = (TextView) findViewById(R.id.VlblRefsbtype1);
         rdogrpRefsbtype1 = (RadioGroup) findViewById(R.id.rdogrpRefsbtype1);
         
         rdoRefsbtype11 = (RadioButton) findViewById(R.id.rdoRefsbtype11);
         rdoRefsbtype12 = (RadioButton) findViewById(R.id.rdoRefsbtype12);
         rdoRefsbtype13 = (RadioButton) findViewById(R.id.rdoRefsbtype13);
         rdoRefsbtype14 = (RadioButton) findViewById(R.id.rdoRefsbtype14);
         secrefbsex1=(LinearLayout)findViewById(R.id.secrefbsex1);
         linerefbsex1=(View)findViewById(R.id.linerefbsex1);
         Vlblrefbsex1 = (TextView) findViewById(R.id.Vlblrefbsex1);
         rdogrprefbsex1 = (RadioGroup) findViewById(R.id.rdogrprefbsex1);
         
         rdorefbsex11 = (RadioButton) findViewById(R.id.rdorefbsex11);
         rdorefbsex12 = (RadioButton) findViewById(R.id.rdorefbsex12);
         rdorefbsex13 = (RadioButton) findViewById(R.id.rdorefbsex13);
         rdorefbsex14 = (RadioButton) findViewById(R.id.rdorefbsex14);
         rdorefbsex15 = (RadioButton) findViewById(R.id.rdorefbsex15);
         secrefbwgt1=(LinearLayout)findViewById(R.id.secrefbwgt1);
         linerefbwgt1=(View)findViewById(R.id.linerefbwgt1);
         Vlblrefbwgt1=(TextView) findViewById(R.id.Vlblrefbwgt1);
         txtrefbwgt1=(EditText) findViewById(R.id.txtrefbwgt1);
         secrefbwgtnot1=(LinearLayout)findViewById(R.id.secrefbwgtnot1);
         linerefbwgtnot1=(View)findViewById(R.id.linerefbwgtnot1);
         Vlblrefbwgtnot1 = (TextView) findViewById(R.id.Vlblrefbwgtnot1);
         rdogrprefbwgtnot1 = (RadioGroup) findViewById(R.id.rdogrprefbwgtnot1);
         
         rdorefbwgtnot11 = (RadioButton) findViewById(R.id.rdorefbwgtnot11);
         rdorefbwgtnot12 = (RadioButton) findViewById(R.id.rdorefbwgtnot12);
         secrefbstim1=(LinearLayout)findViewById(R.id.secrefbstim1);
         linerefbstim1=(View)findViewById(R.id.linerefbstim1);
         Vlblrefbstim1 = (TextView) findViewById(R.id.Vlblrefbstim1);
         rdogrprefbstim1 = (RadioGroup) findViewById(R.id.rdogrprefbstim1);
         
         rdorefbstim11 = (RadioButton) findViewById(R.id.rdorefbstim11);
         rdorefbstim12 = (RadioButton) findViewById(R.id.rdorefbstim12);
         rdorefbstim13 = (RadioButton) findViewById(R.id.rdorefbstim13);
         rdorefbstim14 = (RadioButton) findViewById(R.id.rdorefbstim14);
         secrefbplast1=(LinearLayout)findViewById(R.id.secrefbplast1);
         linerefbplast1=(View)findViewById(R.id.linerefbplast1);
         Vlblrefbplast1 = (TextView) findViewById(R.id.Vlblrefbplast1);
         rdogrprefbplast1 = (RadioGroup) findViewById(R.id.rdogrprefbplast1);
         
         rdorefbplast11 = (RadioButton) findViewById(R.id.rdorefbplast11);
         rdorefbplast12 = (RadioButton) findViewById(R.id.rdorefbplast12);
         rdorefbplast13 = (RadioButton) findViewById(R.id.rdorefbplast13);
         rdorefbplast14 = (RadioButton) findViewById(R.id.rdorefbplast14);
         secrefappcord1=(LinearLayout)findViewById(R.id.secrefappcord1);
         linerefappcord1=(View)findViewById(R.id.linerefappcord1);
         Vlblrefappcord1 = (TextView) findViewById(R.id.Vlblrefappcord1);
         rdogrprefappcord1 = (RadioGroup) findViewById(R.id.rdogrprefappcord1);
         
         rdorefappcord11 = (RadioButton) findViewById(R.id.rdorefappcord11);
         rdorefappcord12 = (RadioButton) findViewById(R.id.rdorefappcord12);
         rdorefappcord13 = (RadioButton) findViewById(R.id.rdorefappcord13);
         rdorefappcord14 = (RadioButton) findViewById(R.id.rdorefappcord14);
         secrefbbfd1=(LinearLayout)findViewById(R.id.secrefbbfd1);
         linerefbbfd1=(View)findViewById(R.id.linerefbbfd1);
         Vlblrefbbfd1 = (TextView) findViewById(R.id.Vlblrefbbfd1);
         rdogrprefbbfd1 = (RadioGroup) findViewById(R.id.rdogrprefbbfd1);
         
         rdorefbbfd11 = (RadioButton) findViewById(R.id.rdorefbbfd11);
         rdorefbbfd12 = (RadioButton) findViewById(R.id.rdorefbbfd12);
         rdorefbbfd13 = (RadioButton) findViewById(R.id.rdorefbbfd13);
         rdorefbbfd14 = (RadioButton) findViewById(R.id.rdorefbbfd14);
         rdorefbbfd15 = (RadioButton) findViewById(R.id.rdorefbbfd15);
         secrefbcond1=(LinearLayout)findViewById(R.id.secrefbcond1);
         linerefbcond1=(View)findViewById(R.id.linerefbcond1);
         Vlblrefbcond1 = (TextView) findViewById(R.id.Vlblrefbcond1);
         rdogrprefbcond1 = (RadioGroup) findViewById(R.id.rdogrprefbcond1);
         
         rdorefbcond11 = (RadioButton) findViewById(R.id.rdorefbcond11);
         rdorefbcond12 = (RadioButton) findViewById(R.id.rdorefbcond12);
         rdorefbcond13 = (RadioButton) findViewById(R.id.rdorefbcond13);
         rdorefbcond14 = (RadioButton) findViewById(R.id.rdorefbcond14);
         secrefdisoutld1=(LinearLayout)findViewById(R.id.secrefdisoutld1);
         linerefdisoutld1=(View)findViewById(R.id.linerefdisoutld1);
         Vlblrefdisoutld1 = (TextView) findViewById(R.id.Vlblrefdisoutld1);
         rdogrprefdisoutld1 = (RadioGroup) findViewById(R.id.rdogrprefdisoutld1);
         
         rdorefdisoutld11 = (RadioButton) findViewById(R.id.rdorefdisoutld11);
         rdorefdisoutld12 = (RadioButton) findViewById(R.id.rdorefdisoutld12);
         rdorefdisoutld13 = (RadioButton) findViewById(R.id.rdorefdisoutld13);
         rdorefdisoutld14 = (RadioButton) findViewById(R.id.rdorefdisoutld14);
         rdorefdisoutld15 = (RadioButton) findViewById(R.id.rdorefdisoutld15);
         rdorefdisoutld16 = (RadioButton) findViewById(R.id.rdorefdisoutld16);
         rdogrprefdisoutld1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrprefdisoutld1 = new String[] {"1","2","3","4","8","9"};
             for (int i = 0; i < rdogrprefdisoutld1.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrprefdisoutld1.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrprefdisoutld1[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                    secrefTransPlace1.setVisibility(View.GONE);
                    linerefTransPlace1.setVisibility(View.GONE);
                    txtrefTransPlace1.setText("");
             }
             else if(rbData.equalsIgnoreCase("2"))
             {
                    secrefTransPlace1.setVisibility(View.GONE);
                    linerefTransPlace1.setVisibility(View.GONE);
                    txtrefTransPlace1.setText("");
             }
             else if(rbData.equalsIgnoreCase("4"))
             {
                 secrefTransPlace1.setVisibility(View.GONE);
                 linerefTransPlace1.setVisibility(View.GONE);
                 txtrefTransPlace1.setText("");
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secrefTransPlace1.setVisibility(View.GONE);
                    linerefTransPlace1.setVisibility(View.GONE);
                    txtrefTransPlace1.setText("");
             }
             else if(rbData.equalsIgnoreCase("9"))
             {
                    secrefTransPlace1.setVisibility(View.GONE);
                    linerefTransPlace1.setVisibility(View.GONE);
                    txtrefTransPlace1.setText("");
             }
             else
             {
                    secrefTransPlace1.setVisibility(View.VISIBLE);
                    linerefTransPlace1.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secrefTransPlace1=(LinearLayout)findViewById(R.id.secrefTransPlace1);
         linerefTransPlace1=(View)findViewById(R.id.linerefTransPlace1);
         VlblrefTransPlace1=(TextView) findViewById(R.id.VlblrefTransPlace1);
         txtrefTransPlace1=(EditText) findViewById(R.id.txtrefTransPlace1);
         seclbl3=(LinearLayout)findViewById(R.id.seclbl3);
         linelbl3=(View)findViewById(R.id.linelbl3);
         secreftypebirth2=(LinearLayout)findViewById(R.id.secreftypebirth2);
         linereftypebirth2=(View)findViewById(R.id.linereftypebirth2);
         Vlblreftypebirth2 = (TextView) findViewById(R.id.Vlblreftypebirth2);
         rdogrpreftypebirth2 = (RadioGroup) findViewById(R.id.rdogrpreftypebirth2);
         
         rdoreftypebirth21 = (RadioButton) findViewById(R.id.rdoreftypebirth21);
         rdoreftypebirth22 = (RadioButton) findViewById(R.id.rdoreftypebirth22);
         rdoreftypebirth23 = (RadioButton) findViewById(R.id.rdoreftypebirth23);
         rdoreftypebirth24 = (RadioButton) findViewById(R.id.rdoreftypebirth24);
         rdoreftypebirth25 = (RadioButton) findViewById(R.id.rdoreftypebirth25);
         //rdoreftypebirth26 = (RadioButton) findViewById(R.id.rdoreftypebirth26);
         secrefdelivdate2=(LinearLayout)findViewById(R.id.secrefdelivdate2);
         linerefdelivdate2=(View)findViewById(R.id.linerefdelivdate2);
         Vlblrefdelivdate2=(TextView) findViewById(R.id.Vlblrefdelivdate2);
         dtprefdelivdate2=(EditText) findViewById(R.id.dtprefdelivdate2);

         secrefdelivdate2not=(LinearLayout)findViewById(R.id.secrefdelivdate2not) ;
         rdogrprefdelivdate2not=(RadioGroup)findViewById(R.id.rdogrprefdelivdate2not) ;
         rdorefdelivdate2not1=(RadioButton)findViewById(R.id.rdorefdelivdate2not1) ;
         rdorefdelivdate2not2=(RadioButton)findViewById(R.id.rdorefdelivdate2not2) ;

         secrefdelivtime2not=(LinearLayout)findViewById(R.id.secrefdelivtime2not) ;
         rdogrprefdelivtime2not=(RadioGroup)findViewById(R.id.rdogrprefdelivtime2not) ;
         rdorefdelivtime2not1=(RadioButton)findViewById(R.id.rdorefdelivtime2not1) ;
         rdorefdelivtime2not2=(RadioButton)findViewById(R.id.rdorefdelivtime2not2) ;

         secrefdelivtime2=(LinearLayout)findViewById(R.id.secrefdelivtime2);
         linerefdelivtime2=(View)findViewById(R.id.linerefdelivtime2);
         Vlblrefdelivtime2=(TextView) findViewById(R.id.Vlblrefdelivtime2);
         txtrefdelivtime2=(EditText) findViewById(R.id.txtrefdelivtime2);
         secrefbStatus2=(LinearLayout)findViewById(R.id.secrefbStatus2);
         linerefbStatus2=(View)findViewById(R.id.linerefbStatus2);
         VlblrefbStatus2 = (TextView) findViewById(R.id.VlblrefbStatus2);
         rdogrprefbStatus2 = (RadioGroup) findViewById(R.id.rdogrprefbStatus2);
         
         rdorefbStatus21 = (RadioButton) findViewById(R.id.rdorefbStatus21);
         rdorefbStatus22 = (RadioButton) findViewById(R.id.rdorefbStatus22);
         rdorefbStatus23 = (RadioButton) findViewById(R.id.rdorefbStatus23);
         rdorefbStatus24 = (RadioButton) findViewById(R.id.rdorefbStatus24);
         rdogrprefbStatus2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrprefbStatus2 = new String[] {"1","2","8","9"};
             for (int i = 0; i < rdogrprefbStatus2.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrprefbStatus2.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrprefbStatus2[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                    secRefsbtype2.setVisibility(View.GONE);
                    lineRefsbtype2.setVisibility(View.GONE);
                    rdogrpRefsbtype2.clearCheck();
                 secrefbcond2.setVisibility(View.VISIBLE);
                 secrefdisoutld2.setVisibility(View.VISIBLE);
             }else if(rbData.equalsIgnoreCase("2")) {
                 secRefsbtype2.setVisibility(View.VISIBLE);
                 lineRefsbtype2.setVisibility(View.VISIBLE);
                 secrefbcond2.setVisibility(View.GONE);
                 rdogrprefbcond2.clearCheck();
                 secrefdisoutld2.setVisibility(View.GONE);
                 rdogrprefdisoutld2.clearCheck();
                 secrefTransPlace2.setVisibility(View.GONE);
                 txtrefTransPlace2.setText("");
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secRefsbtype2.setVisibility(View.GONE);
                    lineRefsbtype2.setVisibility(View.GONE);
                    rdogrpRefsbtype2.clearCheck();
                 secrefbcond2.setVisibility(View.VISIBLE);
                 secrefdisoutld2.setVisibility(View.VISIBLE);
             }
             else if(rbData.equalsIgnoreCase("9"))
             {
                    secRefsbtype2.setVisibility(View.GONE);
                    lineRefsbtype2.setVisibility(View.GONE);
                    rdogrpRefsbtype2.clearCheck();
                 secrefbcond2.setVisibility(View.VISIBLE);
                 secrefdisoutld2.setVisibility(View.VISIBLE);
             }
             else
             {
                    secRefsbtype2.setVisibility(View.VISIBLE);
                    lineRefsbtype2.setVisibility(View.VISIBLE);
                 secrefbcond2.setVisibility(View.VISIBLE);
                 secrefdisoutld2.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secRefsbtype2=(LinearLayout)findViewById(R.id.secRefsbtype2);
         lineRefsbtype2=(View)findViewById(R.id.lineRefsbtype2);
         VlblRefsbtype2 = (TextView) findViewById(R.id.VlblRefsbtype2);
         rdogrpRefsbtype2 = (RadioGroup) findViewById(R.id.rdogrpRefsbtype2);
         
         rdoRefsbtype21 = (RadioButton) findViewById(R.id.rdoRefsbtype21);
         rdoRefsbtype22 = (RadioButton) findViewById(R.id.rdoRefsbtype22);
         rdoRefsbtype23 = (RadioButton) findViewById(R.id.rdoRefsbtype23);
         rdoRefsbtype24 = (RadioButton) findViewById(R.id.rdoRefsbtype24);
         secrefbsex2=(LinearLayout)findViewById(R.id.secrefbsex2);
         linerefbsex2=(View)findViewById(R.id.linerefbsex2);
         Vlblrefbsex2 = (TextView) findViewById(R.id.Vlblrefbsex2);
         rdogrprefbsex2 = (RadioGroup) findViewById(R.id.rdogrprefbsex2);
         
         rdorefbsex21 = (RadioButton) findViewById(R.id.rdorefbsex21);
         rdorefbsex22 = (RadioButton) findViewById(R.id.rdorefbsex22);
         rdorefbsex23 = (RadioButton) findViewById(R.id.rdorefbsex23);
         rdorefbsex24 = (RadioButton) findViewById(R.id.rdorefbsex24);
         rdorefbsex25 = (RadioButton) findViewById(R.id.rdorefbsex25);
         secrefbwgt2=(LinearLayout)findViewById(R.id.secrefbwgt2);
         linerefbwgt2=(View)findViewById(R.id.linerefbwgt2);
         Vlblrefbwgt2=(TextView) findViewById(R.id.Vlblrefbwgt2);
         txtrefbwgt2=(EditText) findViewById(R.id.txtrefbwgt2);
         secrefbwgtnot2=(LinearLayout)findViewById(R.id.secrefbwgtnot2);
         linerefbwgtnot2=(View)findViewById(R.id.linerefbwgtnot2);
         Vlblrefbwgtnot2 = (TextView) findViewById(R.id.Vlblrefbwgtnot2);
         rdogrprefbwgtnot2 = (RadioGroup) findViewById(R.id.rdogrprefbwgtnot2);
         
         rdorefbwgtnot21 = (RadioButton) findViewById(R.id.rdorefbwgtnot21);
         rdorefbwgtnot22 = (RadioButton) findViewById(R.id.rdorefbwgtnot22);
         secrefbstim2=(LinearLayout)findViewById(R.id.secrefbstim2);
         linerefbstim2=(View)findViewById(R.id.linerefbstim2);
         Vlblrefbstim2 = (TextView) findViewById(R.id.Vlblrefbstim2);
         rdogrprefbstim2 = (RadioGroup) findViewById(R.id.rdogrprefbstim2);
         
         rdorefbstim21 = (RadioButton) findViewById(R.id.rdorefbstim21);
         rdorefbstim22 = (RadioButton) findViewById(R.id.rdorefbstim22);
         rdorefbstim23 = (RadioButton) findViewById(R.id.rdorefbstim23);
         rdorefbstim24 = (RadioButton) findViewById(R.id.rdorefbstim24);
         secrefbplast2=(LinearLayout)findViewById(R.id.secrefbplast2);
         linerefbplast2=(View)findViewById(R.id.linerefbplast2);
         Vlblrefbplast2 = (TextView) findViewById(R.id.Vlblrefbplast2);
         rdogrprefbplast2 = (RadioGroup) findViewById(R.id.rdogrprefbplast2);
         
         rdorefbplast21 = (RadioButton) findViewById(R.id.rdorefbplast21);
         rdorefbplast22 = (RadioButton) findViewById(R.id.rdorefbplast22);
         rdorefbplast23 = (RadioButton) findViewById(R.id.rdorefbplast23);
         rdorefbplast24 = (RadioButton) findViewById(R.id.rdorefbplast24);
         secrefappcord2=(LinearLayout)findViewById(R.id.secrefappcord2);
         linerefappcord2=(View)findViewById(R.id.linerefappcord2);
         Vlblrefappcord2 = (TextView) findViewById(R.id.Vlblrefappcord2);
         rdogrprefappcord2 = (RadioGroup) findViewById(R.id.rdogrprefappcord2);
         
         rdorefappcord21 = (RadioButton) findViewById(R.id.rdorefappcord21);
         rdorefappcord22 = (RadioButton) findViewById(R.id.rdorefappcord22);
         rdorefappcord23 = (RadioButton) findViewById(R.id.rdorefappcord23);
         rdorefappcord24 = (RadioButton) findViewById(R.id.rdorefappcord24);
         secrefbbfd2=(LinearLayout)findViewById(R.id.secrefbbfd2);
         linerefbbfd2=(View)findViewById(R.id.linerefbbfd2);
         Vlblrefbbfd2 = (TextView) findViewById(R.id.Vlblrefbbfd2);
         rdogrprefbbfd2 = (RadioGroup) findViewById(R.id.rdogrprefbbfd2);
         
         rdorefbbfd21 = (RadioButton) findViewById(R.id.rdorefbbfd21);
         rdorefbbfd22 = (RadioButton) findViewById(R.id.rdorefbbfd22);
         rdorefbbfd23 = (RadioButton) findViewById(R.id.rdorefbbfd23);
         rdorefbbfd24 = (RadioButton) findViewById(R.id.rdorefbbfd24);
         rdorefbbfd25 = (RadioButton) findViewById(R.id.rdorefbbfd25);
         secrefbcond2=(LinearLayout)findViewById(R.id.secrefbcond2);
         linerefbcond2=(View)findViewById(R.id.linerefbcond2);
         Vlblrefbcond2 = (TextView) findViewById(R.id.Vlblrefbcond2);
         rdogrprefbcond2 = (RadioGroup) findViewById(R.id.rdogrprefbcond2);
         
         rdorefbcond21 = (RadioButton) findViewById(R.id.rdorefbcond21);
         rdorefbcond22 = (RadioButton) findViewById(R.id.rdorefbcond22);
         rdorefbcond23 = (RadioButton) findViewById(R.id.rdorefbcond23);
         rdorefbcond24 = (RadioButton) findViewById(R.id.rdorefbcond24);
         secrefdisoutld2=(LinearLayout)findViewById(R.id.secrefdisoutld2);
         linerefdisoutld2=(View)findViewById(R.id.linerefdisoutld2);
         Vlblrefdisoutld2 = (TextView) findViewById(R.id.Vlblrefdisoutld2);
         rdogrprefdisoutld2 = (RadioGroup) findViewById(R.id.rdogrprefdisoutld2);
         
         rdorefdisoutld21 = (RadioButton) findViewById(R.id.rdorefdisoutld21);
         rdorefdisoutld22 = (RadioButton) findViewById(R.id.rdorefdisoutld22);
         rdorefdisoutld23 = (RadioButton) findViewById(R.id.rdorefdisoutld23);
         rdorefdisoutld24 = (RadioButton) findViewById(R.id.rdorefdisoutld24);
         rdorefdisoutld25 = (RadioButton) findViewById(R.id.rdorefdisoutld25);
         rdorefdisoutld26 = (RadioButton) findViewById(R.id.rdorefdisoutld26);
         rdogrprefdisoutld2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrprefdisoutld2 = new String[] {"1","2","3","4","8","9"};
             for (int i = 0; i < rdogrprefdisoutld2.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrprefdisoutld2.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrprefdisoutld2[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                    secrefTransPlace2.setVisibility(View.GONE);
                    linerefTransPlace2.setVisibility(View.GONE);
                    txtrefTransPlace2.setText("");
             }
             else if(rbData.equalsIgnoreCase("2"))
             {
                    secrefTransPlace2.setVisibility(View.GONE);
                    linerefTransPlace2.setVisibility(View.GONE);
                    txtrefTransPlace2.setText("");
             }
             else if(rbData.equalsIgnoreCase("4"))
             {
                 secrefTransPlace2.setVisibility(View.GONE);
                 linerefTransPlace2.setVisibility(View.GONE);
                 txtrefTransPlace2.setText("");
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secrefTransPlace2.setVisibility(View.GONE);
                    linerefTransPlace2.setVisibility(View.GONE);
                    txtrefTransPlace2.setText("");
             }
             else if(rbData.equalsIgnoreCase("9"))
             {
                    secrefTransPlace2.setVisibility(View.GONE);
                    linerefTransPlace2.setVisibility(View.GONE);
                    txtrefTransPlace2.setText("");
             }
             else
             {
                    secrefTransPlace2.setVisibility(View.VISIBLE);
                    linerefTransPlace2.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secrefTransPlace2=(LinearLayout)findViewById(R.id.secrefTransPlace2);
         linerefTransPlace2=(View)findViewById(R.id.linerefTransPlace2);
         VlblrefTransPlace2=(TextView) findViewById(R.id.VlblrefTransPlace2);
         txtrefTransPlace2=(EditText) findViewById(R.id.txtrefTransPlace2);
         seclbl4=(LinearLayout)findViewById(R.id.seclbl4);
         linelbl4=(View)findViewById(R.id.linelbl4);
         secreftypebirth3=(LinearLayout)findViewById(R.id.secreftypebirth3);
         linereftypebirth3=(View)findViewById(R.id.linereftypebirth3);
         Vlblreftypebirth3 = (TextView) findViewById(R.id.Vlblreftypebirth3);
         rdogrpreftypebirth3 = (RadioGroup) findViewById(R.id.rdogrpreftypebirth3);
         
         rdoreftypebirth31 = (RadioButton) findViewById(R.id.rdoreftypebirth31);
         rdoreftypebirth32 = (RadioButton) findViewById(R.id.rdoreftypebirth32);
         rdoreftypebirth33 = (RadioButton) findViewById(R.id.rdoreftypebirth33);
         rdoreftypebirth34 = (RadioButton) findViewById(R.id.rdoreftypebirth34);
         rdoreftypebirth35 = (RadioButton) findViewById(R.id.rdoreftypebirth35);
         //rdoreftypebirth36 = (RadioButton) findViewById(R.id.rdoreftypebirth36);
         secrefdelivdate3=(LinearLayout)findViewById(R.id.secrefdelivdate3);
         linerefdelivdate3=(View)findViewById(R.id.linerefdelivdate3);
         Vlblrefdelivdate3=(TextView) findViewById(R.id.Vlblrefdelivdate3);
         dtprefdelivdate3=(EditText) findViewById(R.id.dtprefdelivdate3);

         secrefdelivdate3not=(LinearLayout)findViewById(R.id.secrefdelivdate3not) ;
         rdogrprefdelivdate3not=(RadioGroup)findViewById(R.id.rdogrprefdelivdate3not) ;
         rdorefdelivdate3not1=(RadioButton)findViewById(R.id.rdorefdelivdate3not1) ;
         rdorefdelivdate3not2=(RadioButton)findViewById(R.id.rdorefdelivdate3not2) ;
         secrefdelivtime3not=(LinearLayout)findViewById(R.id.secrefdelivtime3not) ;
         rdogrprefdelivtime3not=(RadioGroup)findViewById(R.id.rdogrprefdelivtime3not) ;
         rdorefdelivtime3not1=(RadioButton)findViewById(R.id.rdorefdelivtime3not1) ;
         rdorefdelivtime3not2=(RadioButton)findViewById(R.id.rdorefdelivtime3not2) ;


         secrefdelivtime3=(LinearLayout)findViewById(R.id.secrefdelivtime3);
         linerefdelivtime3=(View)findViewById(R.id.linerefdelivtime3);
         Vlblrefdelivtime3=(TextView) findViewById(R.id.Vlblrefdelivtime3);
         txtrefdelivtime3=(EditText) findViewById(R.id.txtrefdelivtime3);
         secrefbStatus3=(LinearLayout)findViewById(R.id.secrefbStatus3);
         linerefbStatus3=(View)findViewById(R.id.linerefbStatus3);
         VlblrefbStatus3 = (TextView) findViewById(R.id.VlblrefbStatus3);
         rdogrprefbStatus3 = (RadioGroup) findViewById(R.id.rdogrprefbStatus3);
         
         rdorefbStatus31 = (RadioButton) findViewById(R.id.rdorefbStatus31);
         rdorefbStatus32 = (RadioButton) findViewById(R.id.rdorefbStatus32);
         rdorefbStatus33 = (RadioButton) findViewById(R.id.rdorefbStatus33);
         rdorefbStatus34 = (RadioButton) findViewById(R.id.rdorefbStatus34);
         rdogrprefbStatus3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrprefbStatus3 = new String[] {"1","2","8","9"};
             for (int i = 0; i < rdogrprefbStatus3.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrprefbStatus3.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrprefbStatus3[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                    secRefsbtype3.setVisibility(View.GONE);
                    lineRefsbtype3.setVisibility(View.GONE);
                    rdogrpRefsbtype3.clearCheck();
                 secrefbcond3.setVisibility(View.VISIBLE);
                 secrefdisoutld3.setVisibility(View.VISIBLE);
             }else if(rbData.equalsIgnoreCase("2")) {
                 secRefsbtype3.setVisibility(View.VISIBLE);
                 lineRefsbtype3.setVisibility(View.VISIBLE);
                 secrefbcond3.setVisibility(View.GONE);
                 rdogrprefbcond3.clearCheck();
                 secrefdisoutld3.setVisibility(View.GONE);
                 rdogrprefdisoutld3.clearCheck();
                 secrefTransPlace3.setVisibility(View.GONE);
                 txtrefTransPlace3.setText("");
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secRefsbtype3.setVisibility(View.GONE);
                    lineRefsbtype3.setVisibility(View.GONE);
                    rdogrpRefsbtype3.clearCheck();
                 secrefbcond3.setVisibility(View.VISIBLE);
                 secrefdisoutld3.setVisibility(View.VISIBLE);
             }
             else if(rbData.equalsIgnoreCase("9"))
             {
                    secRefsbtype3.setVisibility(View.GONE);
                    lineRefsbtype3.setVisibility(View.GONE);
                    rdogrpRefsbtype3.clearCheck();
                 secrefbcond3.setVisibility(View.VISIBLE);
                 secrefdisoutld3.setVisibility(View.VISIBLE);
             }
             else
             {
                    secRefsbtype3.setVisibility(View.VISIBLE);
                    lineRefsbtype3.setVisibility(View.VISIBLE);
                 secrefbcond3.setVisibility(View.VISIBLE);
                 secrefdisoutld3.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secRefsbtype3=(LinearLayout)findViewById(R.id.secRefsbtype3);
         lineRefsbtype3=(View)findViewById(R.id.lineRefsbtype3);
         VlblRefsbtype3 = (TextView) findViewById(R.id.VlblRefsbtype3);
         rdogrpRefsbtype3 = (RadioGroup) findViewById(R.id.rdogrpRefsbtype3);
         
         rdoRefsbtype31 = (RadioButton) findViewById(R.id.rdoRefsbtype31);
         rdoRefsbtype32 = (RadioButton) findViewById(R.id.rdoRefsbtype32);
         rdoRefsbtype33 = (RadioButton) findViewById(R.id.rdoRefsbtype33);
         rdoRefsbtype34 = (RadioButton) findViewById(R.id.rdoRefsbtype34);
         secrefbsex3=(LinearLayout)findViewById(R.id.secrefbsex3);
         linerefbsex3=(View)findViewById(R.id.linerefbsex3);
         Vlblrefbsex3 = (TextView) findViewById(R.id.Vlblrefbsex3);
         rdogrprefbsex3 = (RadioGroup) findViewById(R.id.rdogrprefbsex3);
         
         rdorefbsex31 = (RadioButton) findViewById(R.id.rdorefbsex31);
         rdorefbsex32 = (RadioButton) findViewById(R.id.rdorefbsex32);
         rdorefbsex33 = (RadioButton) findViewById(R.id.rdorefbsex33);
         rdorefbsex34 = (RadioButton) findViewById(R.id.rdorefbsex34);
         rdorefbsex35 = (RadioButton) findViewById(R.id.rdorefbsex35);
         secrefbwgt3=(LinearLayout)findViewById(R.id.secrefbwgt3);
         linerefbwgt3=(View)findViewById(R.id.linerefbwgt3);
         Vlblrefbwgt3=(TextView) findViewById(R.id.Vlblrefbwgt3);
         txtrefbwgt3=(EditText) findViewById(R.id.txtrefbwgt3);
         secrefbwgtnot3=(LinearLayout)findViewById(R.id.secrefbwgtnot3);
         linerefbwgtnot3=(View)findViewById(R.id.linerefbwgtnot3);
         Vlblrefbwgtnot3 = (TextView) findViewById(R.id.Vlblrefbwgtnot3);
         rdogrprefbwgtnot3 = (RadioGroup) findViewById(R.id.rdogrprefbwgtnot3);
         
         rdorefbwgtnot31 = (RadioButton) findViewById(R.id.rdorefbwgtnot31);
         rdorefbwgtnot32 = (RadioButton) findViewById(R.id.rdorefbwgtnot32);
         secrefbstim3=(LinearLayout)findViewById(R.id.secrefbstim3);
         linerefbstim3=(View)findViewById(R.id.linerefbstim3);
         Vlblrefbstim3 = (TextView) findViewById(R.id.Vlblrefbstim3);
         rdogrprefbstim3 = (RadioGroup) findViewById(R.id.rdogrprefbstim3);
         
         rdorefbstim31 = (RadioButton) findViewById(R.id.rdorefbstim31);
         rdorefbstim32 = (RadioButton) findViewById(R.id.rdorefbstim32);
         rdorefbstim33 = (RadioButton) findViewById(R.id.rdorefbstim33);
         rdorefbstim34 = (RadioButton) findViewById(R.id.rdorefbstim34);
         secrefbplast3=(LinearLayout)findViewById(R.id.secrefbplast3);
         linerefbplast3=(View)findViewById(R.id.linerefbplast3);
         Vlblrefbplast3 = (TextView) findViewById(R.id.Vlblrefbplast3);
         rdogrprefbplast3 = (RadioGroup) findViewById(R.id.rdogrprefbplast3);
         
         rdorefbplast31 = (RadioButton) findViewById(R.id.rdorefbplast31);
         rdorefbplast32 = (RadioButton) findViewById(R.id.rdorefbplast32);
         rdorefbplast33 = (RadioButton) findViewById(R.id.rdorefbplast33);
         rdorefbplast34 = (RadioButton) findViewById(R.id.rdorefbplast34);
         secrefappcord3=(LinearLayout)findViewById(R.id.secrefappcord3);
         linerefappcord3=(View)findViewById(R.id.linerefappcord3);
         Vlblrefappcord3 = (TextView) findViewById(R.id.Vlblrefappcord3);
         rdogrprefappcord3 = (RadioGroup) findViewById(R.id.rdogrprefappcord3);
         
         rdorefappcord31 = (RadioButton) findViewById(R.id.rdorefappcord31);
         rdorefappcord32 = (RadioButton) findViewById(R.id.rdorefappcord32);
         rdorefappcord33 = (RadioButton) findViewById(R.id.rdorefappcord33);
         rdorefappcord34 = (RadioButton) findViewById(R.id.rdorefappcord34);
         secrefbbfd3=(LinearLayout)findViewById(R.id.secrefbbfd3);
         linerefbbfd3=(View)findViewById(R.id.linerefbbfd3);
         Vlblrefbbfd3 = (TextView) findViewById(R.id.Vlblrefbbfd3);
         rdogrprefbbfd3 = (RadioGroup) findViewById(R.id.rdogrprefbbfd3);
         
         rdorefbbfd31 = (RadioButton) findViewById(R.id.rdorefbbfd31);
         rdorefbbfd32 = (RadioButton) findViewById(R.id.rdorefbbfd32);
         rdorefbbfd33 = (RadioButton) findViewById(R.id.rdorefbbfd33);
         rdorefbbfd34 = (RadioButton) findViewById(R.id.rdorefbbfd34);
         rdorefbbfd35 = (RadioButton) findViewById(R.id.rdorefbbfd35);
         secrefbcond3=(LinearLayout)findViewById(R.id.secrefbcond3);
         linerefbcond3=(View)findViewById(R.id.linerefbcond3);
         Vlblrefbcond3 = (TextView) findViewById(R.id.Vlblrefbcond3);
         rdogrprefbcond3 = (RadioGroup) findViewById(R.id.rdogrprefbcond3);
         
         rdorefbcond31 = (RadioButton) findViewById(R.id.rdorefbcond31);
         rdorefbcond32 = (RadioButton) findViewById(R.id.rdorefbcond32);
         rdorefbcond33 = (RadioButton) findViewById(R.id.rdorefbcond33);
         rdorefbcond34 = (RadioButton) findViewById(R.id.rdorefbcond34);
         secrefdisoutld3=(LinearLayout)findViewById(R.id.secrefdisoutld3);
         linerefdisoutld3=(View)findViewById(R.id.linerefdisoutld3);
         Vlblrefdisoutld3 = (TextView) findViewById(R.id.Vlblrefdisoutld3);
         rdogrprefdisoutld3 = (RadioGroup) findViewById(R.id.rdogrprefdisoutld3);
         
         rdorefdisoutld31 = (RadioButton) findViewById(R.id.rdorefdisoutld31);
         rdorefdisoutld32 = (RadioButton) findViewById(R.id.rdorefdisoutld32);
         rdorefdisoutld33 = (RadioButton) findViewById(R.id.rdorefdisoutld33);
         rdorefdisoutld34 = (RadioButton) findViewById(R.id.rdorefdisoutld34);
         rdorefdisoutld35 = (RadioButton) findViewById(R.id.rdorefdisoutld35);
         rdorefdisoutld36 = (RadioButton) findViewById(R.id.rdorefdisoutld36);
         rdogrprefdisoutld3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrprefdisoutld3 = new String[] {"1","2","3","4","8","9"};
             for (int i = 0; i < rdogrprefdisoutld3.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrprefdisoutld3.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrprefdisoutld3[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                    secrefTransPlace3.setVisibility(View.GONE);
                    linerefTransPlace3.setVisibility(View.GONE);
                    txtrefTransPlace3.setText("");
             }
             else if(rbData.equalsIgnoreCase("2"))
             {
                    secrefTransPlace3.setVisibility(View.GONE);
                    linerefTransPlace3.setVisibility(View.GONE);
                    txtrefTransPlace3.setText("");
             }
             else if(rbData.equalsIgnoreCase("4"))
             {
                 secrefTransPlace3.setVisibility(View.GONE);
                 linerefTransPlace3.setVisibility(View.GONE);
                 txtrefTransPlace3.setText("");
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secrefTransPlace3.setVisibility(View.GONE);
                    linerefTransPlace3.setVisibility(View.GONE);
                    txtrefTransPlace3.setText("");
             }
             else if(rbData.equalsIgnoreCase("9"))
             {
                    secrefTransPlace3.setVisibility(View.GONE);
                    linerefTransPlace3.setVisibility(View.GONE);
                    txtrefTransPlace3.setText("");
             }
             else
             {
                    secrefTransPlace3.setVisibility(View.VISIBLE);
                    linerefTransPlace3.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secrefTransPlace3=(LinearLayout)findViewById(R.id.secrefTransPlace3);
         linerefTransPlace3=(View)findViewById(R.id.linerefTransPlace3);
         VlblrefTransPlace3=(TextView) findViewById(R.id.VlblrefTransPlace3);
         txtrefTransPlace3=(EditText) findViewById(R.id.txtrefTransPlace3);
         secrefpph=(LinearLayout)findViewById(R.id.secrefpph);
         linerefpph=(View)findViewById(R.id.linerefpph);
         Vlblrefpph=(TextView) findViewById(R.id.Vlblrefpph);
         txtrefpph=(EditText) findViewById(R.id.txtrefpph);
         secrefpphnot=(LinearLayout)findViewById(R.id.secrefpphnot);
         linerefpphnot=(View)findViewById(R.id.linerefpphnot);
         Vlblrefpphnot = (TextView) findViewById(R.id.Vlblrefpphnot);
         rdogrprefpphnot = (RadioGroup) findViewById(R.id.rdogrprefpphnot);
         
         rdorefpphnot1 = (RadioButton) findViewById(R.id.rdorefpphnot1);
         rdorefpphnot2 = (RadioButton) findViewById(R.id.rdorefpphnot2);
         secrefretainplac=(LinearLayout)findViewById(R.id.secrefretainplac);
         linerefretainplac=(View)findViewById(R.id.linerefretainplac);
         Vlblrefretainplac = (TextView) findViewById(R.id.Vlblrefretainplac);
         rdogrprefretainplac = (RadioGroup) findViewById(R.id.rdogrprefretainplac);
         
         rdorefretainplac1 = (RadioButton) findViewById(R.id.rdorefretainplac1);
         rdorefretainplac2 = (RadioButton) findViewById(R.id.rdorefretainplac2);
         rdorefretainplac3 = (RadioButton) findViewById(R.id.rdorefretainplac3);
         rdorefretainplac4 = (RadioButton) findViewById(R.id.rdorefretainplac4);
         rdorefretainplac5 = (RadioButton) findViewById(R.id.rdorefretainplac5);
         rdorefretainplac6 = (RadioButton) findViewById(R.id.rdorefretainplac6);

         secrefdodld=(LinearLayout)findViewById(R.id.secrefdodld);
         linerefdodld=(View)findViewById(R.id.linerefdodld);
         Vlblrefdodld=(TextView) findViewById(R.id.Vlblrefdodld);
         dtprefdodld=(EditText) findViewById(R.id.dtprefdodld);
         secreftodld=(LinearLayout)findViewById(R.id.secreftodld);
         linereftodld=(View)findViewById(R.id.linereftodld);
         Vlblreftodld=(TextView) findViewById(R.id.Vlblreftodld);
         txtreftodld=(EditText) findViewById(R.id.txtreftodld);
         secrefmatcond=(LinearLayout)findViewById(R.id.secrefmatcond);
         linerefmatcond=(View)findViewById(R.id.linerefmatcond);
         Vlblrefmatcond = (TextView) findViewById(R.id.Vlblrefmatcond);
         rdogrprefmatcond = (RadioGroup) findViewById(R.id.rdogrprefmatcond);
         
         rdorefmatcond1 = (RadioButton) findViewById(R.id.rdorefmatcond1);
         rdorefmatcond2 = (RadioButton) findViewById(R.id.rdorefmatcond2);
         rdorefmatcond3 = (RadioButton) findViewById(R.id.rdorefmatcond3);
         rdorefmatcond4 = (RadioButton) findViewById(R.id.rdorefmatcond4);
         rdorefmatcond5 = (RadioButton) findViewById(R.id.rdorefmatcond5);
         rdorefmatcond6 = (RadioButton) findViewById(R.id.rdorefmatcond6);
         rdogrprefmatcond.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrprefmatcond = new String[] {"1","2","3","4","8","9"};
             for (int i = 0; i < rdogrprefmatcond.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrprefmatcond.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrprefmatcond[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                    secrefTransPlaceM.setVisibility(View.GONE);
                    linerefTransPlaceM.setVisibility(View.GONE);
                    txtrefTransPlaceM.setText("");
             }
             else if(rbData.equalsIgnoreCase("2"))
             {
                    secrefTransPlaceM.setVisibility(View.GONE);
                    linerefTransPlaceM.setVisibility(View.GONE);
                    txtrefTransPlaceM.setText("");
             }
             else if(rbData.equalsIgnoreCase("4"))
             {
                    secrefTransPlaceM.setVisibility(View.GONE);
                    linerefTransPlaceM.setVisibility(View.GONE);
                    txtrefTransPlaceM.setText("");
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secrefTransPlaceM.setVisibility(View.GONE);
                    linerefTransPlaceM.setVisibility(View.GONE);
                    txtrefTransPlaceM.setText("");
             }
             else if(rbData.equalsIgnoreCase("9"))
             {
                    secrefTransPlaceM.setVisibility(View.GONE);
                    linerefTransPlaceM.setVisibility(View.GONE);
                    txtrefTransPlaceM.setText("");
             }
             else
             {
                    secrefTransPlaceM.setVisibility(View.VISIBLE);
                    linerefTransPlaceM.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secrefTransPlaceM=(LinearLayout)findViewById(R.id.secrefTransPlaceM);
         linerefTransPlaceM=(View)findViewById(R.id.linerefTransPlaceM);
         VlblrefTransPlaceM=(TextView) findViewById(R.id.VlblrefTransPlaceM);
         txtrefTransPlaceM=(EditText) findViewById(R.id.txtrefTransPlaceM);


         dtprefdoe.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtprefdoe.getRight() - dtprefdoe.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnrefdoe"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });
         dtprefgacalc.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtprefgacalc.getRight() - dtprefgacalc.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnrefgacalc"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });
         dtprefdelivdate1.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtprefdelivdate1.getRight() - dtprefdelivdate1.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnrefdelivdate1"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });
         dtprefdelivdate2.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtprefdelivdate2.getRight() - dtprefdelivdate2.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnrefdelivdate2"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });
         dtprefdelivdate3.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtprefdelivdate3.getRight() - dtprefdelivdate3.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnrefdelivdate3"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });
         dtprefdodld.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtprefdodld.getRight() - dtprefdodld.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnrefdodld"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });


         txtrefdelivtime1.setOnTouchListener(new View.OnTouchListener() {
         @Override
         public boolean onTouch(View v, MotionEvent event) {
             final int DRAWABLE_RIGHT = 2;
             if(event.getAction() == MotionEvent.ACTION_UP) {
                 if(event.getRawX() >= (txtrefdelivtime1.getRight() - txtrefdelivtime1.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                     VariableID = "btnrefdelivtime1"; showDialog(TIME_DIALOG);
                  return true;
                 }
             }
             return false;
           }
         });
         txtrefdelivtime2.setOnTouchListener(new View.OnTouchListener() {
         @Override
         public boolean onTouch(View v, MotionEvent event) {
             final int DRAWABLE_RIGHT = 2;
             if(event.getAction() == MotionEvent.ACTION_UP) {
                 if(event.getRawX() >= (txtrefdelivtime2.getRight() - txtrefdelivtime2.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                     VariableID = "btnrefdelivtime2"; showDialog(TIME_DIALOG);
                  return true;
                 }
             }
             return false;
           }
         });
         txtrefdelivtime3.setOnTouchListener(new View.OnTouchListener() {
         @Override
         public boolean onTouch(View v, MotionEvent event) {
             final int DRAWABLE_RIGHT = 2;
             if(event.getAction() == MotionEvent.ACTION_UP) {
                 if(event.getRawX() >= (txtrefdelivtime3.getRight() - txtrefdelivtime3.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                     VariableID = "btnrefdelivtime3"; showDialog(TIME_DIALOG);
                  return true;
                 }
             }
             return false;
           }
         });
         txtreftodld.setOnTouchListener(new View.OnTouchListener() {
         @Override
         public boolean onTouch(View v, MotionEvent event) {
             final int DRAWABLE_RIGHT = 2;
             if(event.getAction() == MotionEvent.ACTION_UP) {
                 if(event.getRawX() >= (txtreftodld.getRight() - txtreftodld.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                     VariableID = "btnreftodld"; showDialog(TIME_DIALOG);
                  return true;
                 }
             }
             return false;
           }
         });




         //----------------
         txtrefgald.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {
             }

             public void beforeTextChanged(CharSequence s, int start, int count,int after) {
             }
             public void afterTextChanged(Editable s) {
                 if(txtrefgald.getText().toString().length()>0) rdogrprefgaldnot.clearCheck();
             }
         });
         rdogrprefgaldnot.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(checkedId==R.id.rdorefgaldnot1|checkedId==R.id.rdorefgaldnot1) txtrefgald.setText("");
             }
         });

         dtprefgacalc.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {
             }

             public void beforeTextChanged(CharSequence s, int start, int count,int after) {
             }
             public void afterTextChanged(Editable s) {
                 if(dtprefgacalc.getText().toString().length()>0) rdogrprefgacalcnot.clearCheck();
             }
         });
         rdogrprefgacalcnot.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(checkedId==R.id.rdorefgacalcnot1|checkedId==R.id.rdorefgacalcnot1) dtprefgacalc.setText("");
             }
         });

         txtrefbwgt1.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {
             }

             public void beforeTextChanged(CharSequence s, int start, int count,int after) {
             }
             public void afterTextChanged(Editable s) {
                 if(txtrefbwgt1.getText().toString().length()>0) rdogrprefbwgtnot1.clearCheck();
             }
         });
         rdogrprefbwgtnot1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(checkedId==R.id.rdorefbwgtnot11|checkedId==R.id.rdorefbwgtnot11) txtrefbwgt1.setText("");
             }
         });

         txtrefbwgt2.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {
             }

             public void beforeTextChanged(CharSequence s, int start, int count,int after) {
             }
             public void afterTextChanged(Editable s) {
                 if(txtrefbwgt2.getText().toString().length()>0) rdogrprefbwgtnot2.clearCheck();
             }
         });
         rdogrprefbwgtnot2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(checkedId==R.id.rdorefbwgtnot21|checkedId==R.id.rdorefbwgtnot22) txtrefbwgt2.setText("");
             }
         });

         txtrefbwgt3.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {
             }

             public void beforeTextChanged(CharSequence s, int start, int count,int after) {
             }
             public void afterTextChanged(Editable s) {
                 if(txtrefbwgt3.getText().toString().length()>0) rdogrprefbwgtnot3.clearCheck();
             }
         });
         rdogrprefbwgtnot3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(checkedId==R.id.rdorefbwgtnot31|checkedId==R.id.rdorefbwgtnot32) txtrefbwgt3.setText("");
             }
         });

         txtrefpph.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {
             }

             public void beforeTextChanged(CharSequence s, int start, int count,int after) {
             }
             public void afterTextChanged(Editable s) {
                 if(txtrefpph.getText().toString().length()>0) rdogrprefpphnot.clearCheck();
             }
         });
         rdogrprefpphnot.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(checkedId==R.id.rdorefpphnot1|checkedId==R.id.rdorefpphnot1) txtrefpph.setText("");
             }
         });



         rdogrprefdelivdate1not.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(rdorefdelivdate1not1.isChecked() | rdorefdelivdate1not2.isChecked()){
                     dtprefdelivdate1.setText("");
                 }
             }
         });
         dtprefdelivdate1.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {
             }

             public void beforeTextChanged(CharSequence s, int start, int count,int after) {
             }
             public void afterTextChanged(Editable s) {
                 if(dtprefdelivdate1.getText().toString().length()>0)
                 {
                     rdogrprefdelivdate1not.clearCheck();
                 }
             }
         });

         rdogrprefdelivtime1not.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(rdorefdelivtime1not1.isChecked() | rdorefdelivtime1not2.isChecked()){
                     txtrefdelivtime1.setText("");
                 }
             }

         });
         txtrefdelivtime1.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {
             }

             public void beforeTextChanged(CharSequence s, int start, int count,int after) {
             }
             public void afterTextChanged(Editable s) {
                 if(txtrefdelivtime1.getText().toString().length()>0) rdogrprefdelivtime1not.clearCheck();
             }
         });
         //--------------
         rdogrprefdelivdate2not.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(rdorefdelivdate2not1.isChecked() | rdorefdelivdate2not2.isChecked()){
                     dtprefdelivdate2.setText("");
                 }
             }

         });
         dtprefdelivdate2.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {
             }

             public void beforeTextChanged(CharSequence s, int start, int count,int after) {
             }
             public void afterTextChanged(Editable s) {
                 if(dtprefdelivdate2.getText().toString().length()>0) rdogrprefdelivdate2not.clearCheck();
             }
         });
         rdogrprefdelivtime2not.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(rdorefdelivtime2not1.isChecked() | rdorefdelivtime2not2.isChecked()){
                     txtrefdelivtime2.setText("");
                 }
             }

         });
         txtrefdelivtime2.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {
             }

             public void beforeTextChanged(CharSequence s, int start, int count,int after) {
             }
             public void afterTextChanged(Editable s) {
                 if(txtrefdelivtime2.getText().toString().length()>0) rdogrprefdelivtime2not.clearCheck();
             }
         });
        //----------------------
         rdogrprefdelivdate3not.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(rdorefdelivdate3not1.isChecked() | rdorefdelivdate3not2.isChecked()){
                     dtprefdelivdate3.setText("");
                 }
             }

         });
         dtprefdelivdate3.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {
             }

             public void beforeTextChanged(CharSequence s, int start, int count,int after) {
             }
             public void afterTextChanged(Editable s) {
                 if(dtprefdelivdate3.getText().toString().length()>0) rdogrprefdelivdate3not.clearCheck();
             }
         });
         rdogrprefdelivtime3not.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(rdorefdelivtime3not1.isChecked() | rdorefdelivtime3not2.isChecked()){
                     txtrefdelivtime3.setText("");
                 }
             }

         });
         txtrefdelivtime3.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {
             }

             public void beforeTextChanged(CharSequence s, int start, int count,int after) {
             }
             public void afterTextChanged(Editable s) {
                 if(txtrefdelivtime3.getText().toString().length()>0) rdogrprefdelivtime3not.clearCheck();
             }
         });


         rdogrpstatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(rdostatus1.isChecked()){
                     secreason.setVisibility(View.GONE);
                     rdogrpreason.clearCheck();
                     secreasmention.setVisibility(View.GONE);
                     txtreasmention.setText("");
                 }else{
                     secreason.setVisibility(View.VISIBLE);
                     secreasmention.setVisibility(View.VISIBLE);
                 }
             }

         });


         //---------
         rdogrprefdodldnot.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(rdorefdodldnot1.isChecked() | rdorefdodldnot2.isChecked()){
                     dtprefdodld.setText("");
                 }
             }

         });
         dtprefdodld.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {
             }

             public void beforeTextChanged(CharSequence s, int start, int count,int after) {
             }
             public void afterTextChanged(Editable s) {
                 if(dtprefdodld.getText().toString().length()>0) rdogrprefdodldnot.clearCheck();
             }
         });
         //---------
         rdogrpreftodldnot.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(rdoreftodldnot1.isChecked() | rdoreftodldnot2.isChecked()){
                     txtreftodld.setText("");
                 }
             }

         });
         txtreftodld.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {
             }

             public void beforeTextChanged(CharSequence s, int start, int count,int after) {
             }
             public void afterTextChanged(Editable s) {
                 if(txtreftodld.getText().toString().length()>0) rdogrpreftodldnot.clearCheck();
             }
         });



         //Hide all skip variables
         secreason.setVisibility(View.GONE);
         secreasmention.setVisibility(View.GONE);
         seclbl2.setVisibility(View.GONE);
         linelbl2.setVisibility(View.GONE);
         secreftypebirth1.setVisibility(View.GONE);
         linereftypebirth1.setVisibility(View.GONE);
         secrefdelivdate1.setVisibility(View.GONE);
          secrefdelivdate1not.setVisibility(View.GONE);
         linerefdelivdate1.setVisibility(View.GONE);
         secrefdelivtime1.setVisibility(View.GONE);
          secrefdelivtime1not.setVisibility(View.GONE);
         linerefdelivtime1.setVisibility(View.GONE);
         secrefbStatus1.setVisibility(View.GONE);
         linerefbStatus1.setVisibility(View.GONE);
         secRefsbtype1.setVisibility(View.GONE);
         lineRefsbtype1.setVisibility(View.GONE);
         secrefbsex1.setVisibility(View.GONE);
         linerefbsex1.setVisibility(View.GONE);
         secrefbwgt1.setVisibility(View.GONE);
         linerefbwgt1.setVisibility(View.GONE);
         secrefbwgtnot1.setVisibility(View.GONE);
         linerefbwgtnot1.setVisibility(View.GONE);
         secrefbstim1.setVisibility(View.GONE);
         linerefbstim1.setVisibility(View.GONE);
         secrefbplast1.setVisibility(View.GONE);
         linerefbplast1.setVisibility(View.GONE);
         secrefappcord1.setVisibility(View.GONE);
         linerefappcord1.setVisibility(View.GONE);
         secrefbbfd1.setVisibility(View.GONE);
         linerefbbfd1.setVisibility(View.GONE);
         secrefbcond1.setVisibility(View.GONE);
         linerefbcond1.setVisibility(View.GONE);
         secrefdisoutld1.setVisibility(View.GONE);
         linerefdisoutld1.setVisibility(View.GONE);
         secrefTransPlace1.setVisibility(View.GONE);
         linerefTransPlace1.setVisibility(View.GONE);
         seclbl3.setVisibility(View.GONE);
         linelbl3.setVisibility(View.GONE);
         secreftypebirth2.setVisibility(View.GONE);
         linereftypebirth2.setVisibility(View.GONE);
         secrefdelivdate2.setVisibility(View.GONE);
         secrefdelivdate2not.setVisibility(View.GONE);
         linerefdelivdate2.setVisibility(View.GONE);
         secrefdelivtime2.setVisibility(View.GONE);
         secrefdelivtime2not.setVisibility(View.GONE);
         linerefdelivtime2.setVisibility(View.GONE);
         secrefbStatus2.setVisibility(View.GONE);
         linerefbStatus2.setVisibility(View.GONE);
         secRefsbtype2.setVisibility(View.GONE);
         lineRefsbtype2.setVisibility(View.GONE);
         secrefbsex2.setVisibility(View.GONE);
         linerefbsex2.setVisibility(View.GONE);
         secrefbwgt2.setVisibility(View.GONE);
         linerefbwgt2.setVisibility(View.GONE);
         secrefbwgtnot2.setVisibility(View.GONE);
         linerefbwgtnot2.setVisibility(View.GONE);
         secrefbstim2.setVisibility(View.GONE);
         linerefbstim2.setVisibility(View.GONE);
         secrefbplast2.setVisibility(View.GONE);
         linerefbplast2.setVisibility(View.GONE);
         secrefappcord2.setVisibility(View.GONE);
         linerefappcord2.setVisibility(View.GONE);
         secrefbbfd2.setVisibility(View.GONE);
         linerefbbfd2.setVisibility(View.GONE);
         secrefbcond2.setVisibility(View.GONE);
         linerefbcond2.setVisibility(View.GONE);
         secrefdisoutld2.setVisibility(View.GONE);
         linerefdisoutld2.setVisibility(View.GONE);
         secrefTransPlace2.setVisibility(View.GONE);
         linerefTransPlace2.setVisibility(View.GONE);
         seclbl4.setVisibility(View.GONE);
         linelbl4.setVisibility(View.GONE);
         secreftypebirth3.setVisibility(View.GONE);
         linereftypebirth3.setVisibility(View.GONE);
         secrefdelivdate3.setVisibility(View.GONE);
         secrefdelivdate3not.setVisibility(View.GONE);
         linerefdelivdate3.setVisibility(View.GONE);
         secrefdelivtime3.setVisibility(View.GONE);
         secrefdelivtime3not.setVisibility(View.GONE);
         linerefdelivtime3.setVisibility(View.GONE);
         secrefbStatus3.setVisibility(View.GONE);
         linerefbStatus3.setVisibility(View.GONE);
         secRefsbtype3.setVisibility(View.GONE);
         lineRefsbtype3.setVisibility(View.GONE);
         secrefbsex3.setVisibility(View.GONE);
         linerefbsex3.setVisibility(View.GONE);
         secrefbwgt3.setVisibility(View.GONE);
         linerefbwgt3.setVisibility(View.GONE);
         secrefbwgtnot3.setVisibility(View.GONE);
         linerefbwgtnot3.setVisibility(View.GONE);
         secrefbstim3.setVisibility(View.GONE);
         linerefbstim3.setVisibility(View.GONE);
         secrefbplast3.setVisibility(View.GONE);
         linerefbplast3.setVisibility(View.GONE);
         secrefappcord3.setVisibility(View.GONE);
         linerefappcord3.setVisibility(View.GONE);
         secrefbbfd3.setVisibility(View.GONE);
         linerefbbfd3.setVisibility(View.GONE);
         secrefbcond3.setVisibility(View.GONE);
         linerefbcond3.setVisibility(View.GONE);
         secrefdisoutld3.setVisibility(View.GONE);
         linerefdisoutld3.setVisibility(View.GONE);
         secrefTransPlace3.setVisibility(View.GONE);
         linerefTransPlace3.setVisibility(View.GONE);
         secRefsbtype1.setVisibility(View.GONE);
         lineRefsbtype1.setVisibility(View.GONE);
         secRefsbtype1.setVisibility(View.GONE);
         lineRefsbtype1.setVisibility(View.GONE);
         secRefsbtype1.setVisibility(View.GONE);
         lineRefsbtype1.setVisibility(View.GONE);
         secrefTransPlace1.setVisibility(View.GONE);
         linerefTransPlace1.setVisibility(View.GONE);
         secrefTransPlace1.setVisibility(View.GONE);
         linerefTransPlace1.setVisibility(View.GONE);
         secrefTransPlace1.setVisibility(View.GONE);
         linerefTransPlace1.setVisibility(View.GONE);
         secrefTransPlace1.setVisibility(View.GONE);
         linerefTransPlace1.setVisibility(View.GONE);
         secRefsbtype2.setVisibility(View.GONE);
         lineRefsbtype2.setVisibility(View.GONE);
         secRefsbtype2.setVisibility(View.GONE);
         lineRefsbtype2.setVisibility(View.GONE);
         secRefsbtype2.setVisibility(View.GONE);
         lineRefsbtype2.setVisibility(View.GONE);
         secrefTransPlace2.setVisibility(View.GONE);
         linerefTransPlace2.setVisibility(View.GONE);
         secrefTransPlace2.setVisibility(View.GONE);
         linerefTransPlace2.setVisibility(View.GONE);
         secrefTransPlace2.setVisibility(View.GONE);
         linerefTransPlace2.setVisibility(View.GONE);
         secrefTransPlace2.setVisibility(View.GONE);
         linerefTransPlace2.setVisibility(View.GONE);
         secRefsbtype3.setVisibility(View.GONE);
         lineRefsbtype3.setVisibility(View.GONE);
         secRefsbtype3.setVisibility(View.GONE);
         lineRefsbtype3.setVisibility(View.GONE);
         secRefsbtype3.setVisibility(View.GONE);
         lineRefsbtype3.setVisibility(View.GONE);
         secrefTransPlace3.setVisibility(View.GONE);
         linerefTransPlace3.setVisibility(View.GONE);
         secrefTransPlace3.setVisibility(View.GONE);
         linerefTransPlace3.setVisibility(View.GONE);
         secrefTransPlace3.setVisibility(View.GONE);
         linerefTransPlace3.setVisibility(View.GONE);
         secrefTransPlace3.setVisibility(View.GONE);
         linerefTransPlace3.setVisibility(View.GONE);
         secrefTransPlaceM.setVisibility(View.GONE);
         linerefTransPlaceM.setVisibility(View.GONE);
         secrefTransPlaceM.setVisibility(View.GONE);
         linerefTransPlaceM.setVisibility(View.GONE);
         secrefTransPlaceM.setVisibility(View.GONE);
         linerefTransPlaceM.setVisibility(View.GONE);
         secrefTransPlaceM.setVisibility(View.GONE);
         linerefTransPlaceM.setVisibility(View.GONE);
         secrefTransPlaceM.setVisibility(View.GONE);
         linerefTransPlaceM.setVisibility(View.GONE);

        DataSearch(COUNTRYCODE,FACICODE,DATAID);
        Button cmdSave = (Button) findViewById(R.id.cmdSave);
        cmdSave.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) { 
            DataSave();
        }});
     }
     catch(Exception  e)
     {
         Connection.MessageBox(LD_DataExt.this, e.getMessage());
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
             Connection.MessageBox(LD_DataExt.this, "Required field: CountryCode.");
             txtCountryCode.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtCountryCode.getText().toString().length()==0 ? "1" : txtCountryCode.getText().toString()) < 1 || Integer.valueOf(txtCountryCode.getText().toString().length()==0 ? "3" : txtCountryCode.getText().toString()) > 3)
           {
             Connection.MessageBox(LD_DataExt.this, "Value should be between 1 and 3(CountryCode).");
             txtCountryCode.requestFocus(); 
             return;	
           }
         else if(txtFaciCode.getText().toString().length()==0 & secFaciCode.isShown())
           {
             Connection.MessageBox(LD_DataExt.this, "Required field: Facility.");
             txtFaciCode.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtFaciCode.getText().toString().length()==0 ? "1" : txtFaciCode.getText().toString()) < 1 || Integer.valueOf(txtFaciCode.getText().toString().length()==0 ? "9" : txtFaciCode.getText().toString()) > 9)
           {
             Connection.MessageBox(LD_DataExt.this, "Value should be between 1 and 9(Facility).");
             txtFaciCode.requestFocus(); 
             return;	
           }
         else if(txtDataID.getText().toString().length()==0 & secDataID.isShown())
           {
             Connection.MessageBox(LD_DataExt.this, "Required field: Data ID.");
             txtDataID.requestFocus(); 
             return;	
           }
         DV = Global.DateValidate(dtprefdoe.getText().toString());
         if(DV.length()!=0 & secrefdoe.isShown())
           {
             Connection.MessageBox(LD_DataExt.this, DV);
             dtprefdoe.requestFocus(); 
             return;	
           }
         else if(!rdorefgaldnot1.isChecked() & !rdorefgaldnot2.isChecked() & txtrefgald.getText().toString().length()==0 & secrefgald.isShown())
           {
             Connection.MessageBox(LD_DataExt.this, "Required field: Gestational age  (completed weeks).");
             txtrefgald.requestFocus(); 
             return;	
           }
         else if(!rdorefgaldnot1.isChecked() & !rdorefgaldnot2.isChecked() & (Integer.valueOf(txtrefgald.getText().toString().length()==0 ? "1" : txtrefgald.getText().toString()) < 1 || Integer.valueOf(txtrefgald.getText().toString().length()==0 ? "99" : txtrefgald.getText().toString()) > 99))
           {
             Connection.MessageBox(LD_DataExt.this, "Value should be between 1 and 99(Gestational age  (completed weeks)).");
             txtrefgald.requestFocus(); 
             return;	
           }
         
         else if(txtrefgald.getText().toString().length()==0 & !rdorefgaldnot1.isChecked() & !rdorefgaldnot2.isChecked() & secrefgaldnot.isShown())
           {
              Connection.MessageBox(LD_DataExt.this, "Select anyone options from (2.Gestational age  (completed weeks)).");
              rdorefgaldnot1.requestFocus();
              return;
           }
         
         else if(!rdorefacsgiven1.isChecked() & !rdorefacsgiven2.isChecked() & !rdorefacsgiven3.isChecked() & !rdorefacsgiven4.isChecked() & !rdorefacsgiven5.isChecked() & secrefacsgiven.isShown())
           {
              Connection.MessageBox(LD_DataExt.this, "Select anyone options from (Antenatal corticosteroids use documented as administered?).");
              rdorefacsgiven1.requestFocus();
              return;
           }
         /*DV = Global.DateValidate(dtprefgacalc.getText().toString());
         if(!rdorefgacalcnot1.isChecked() & !rdorefgacalcnot2.isChecked() & DV.length()!=0 & secrefgacalc.isShown())
           {
             Connection.MessageBox(LD_DataExt.this, DV);
             dtprefgacalc.requestFocus(); 
             return;	
           }*/
         
         else if(dtprefgacalc.getText().toString().length()==0 & !rdorefgacalcnot1.isChecked() & !rdorefgacalcnot2.isChecked() & secrefgacalcnot.isShown())
           {
              Connection.MessageBox(LD_DataExt.this, "Select anyone options from (4.Estimated date of delivery (solar calendar)).");
              rdorefgacalcnot1.requestFocus();
              return;
           }
         
         else if(!rdorefmedadeliv1.isChecked() & !rdorefmedadeliv2.isChecked() & !rdorefmedadeliv3.isChecked() & !rdorefmedadeliv4.isChecked() & secrefmedadeliv.isShown())
           {
              Connection.MessageBox(LD_DataExt.this, "Select anyone options from (Uterotonic administered for active management of the 3rd stage of labour?).");
              rdorefmedadeliv1.requestFocus();
              return;
           }
         
         else if(!rdonumofbirth1.isChecked() & !rdonumofbirth2.isChecked() & !rdonumofbirth3.isChecked() & secnumofbirth.isShown())
           {
              Connection.MessageBox(LD_DataExt.this, "Select anyone options from (Number of Birth).");
              rdonumofbirth1.requestFocus();
              return;
           }
         
         else if(!rdoreftypebirth11.isChecked() & !rdoreftypebirth12.isChecked() & !rdoreftypebirth13.isChecked() & !rdoreftypebirth14.isChecked() & !rdoreftypebirth15.isChecked()  & secreftypebirth1.isShown())
           {
              Connection.MessageBox(LD_DataExt.this, "Select anyone options from (a. Mode of birth/delivery).");
              rdoreftypebirth11.requestFocus();
              return;
           }
         DV = Global.DateValidate(dtprefdelivdate1.getText().toString());
         if(!rdorefdelivdate1not1.isChecked() & !rdorefdelivdate1not2.isChecked() &  DV.length()!=0 & secrefdelivdate1.isShown())
           {
             Connection.MessageBox(LD_DataExt.this, DV);
             dtprefdelivdate1.requestFocus(); 
             return;	
           }
         else if(!rdorefdelivtime1not1.isChecked() & !rdorefdelivtime1not2.isChecked() & txtrefdelivtime1.getText().length()==0 & secrefdelivtime1.isShown())
           {
             Connection.MessageBox(LD_DataExt.this, "Required field: c. Time of Delivery.");
             txtrefdelivtime1.requestFocus(); 
             return;	
           }
         
         else if(!rdorefbStatus11.isChecked() & !rdorefbStatus12.isChecked() & !rdorefbStatus13.isChecked() & !rdorefbStatus14.isChecked() & secrefbStatus1.isShown())
           {
              Connection.MessageBox(LD_DataExt.this, "Select anyone options from (d. Birth Outcome).");
              rdorefbStatus11.requestFocus();
              return;
           }
         
         else if(!rdoRefsbtype11.isChecked() & !rdoRefsbtype12.isChecked() & !rdoRefsbtype13.isChecked() & !rdoRefsbtype14.isChecked() & secRefsbtype1.isShown())
           {
              Connection.MessageBox(LD_DataExt.this, "Select anyone options from (e. Still birth type).");
              rdoRefsbtype11.requestFocus();
              return;
           }
         
         else if(!rdorefbsex11.isChecked() & !rdorefbsex12.isChecked() & !rdorefbsex13.isChecked() & !rdorefbsex14.isChecked() & !rdorefbsex15.isChecked() & secrefbsex1.isShown())
           {
              Connection.MessageBox(LD_DataExt.this, "Select anyone options from (f. Sex of Child).");
              rdorefbsex11.requestFocus();
              return;
           }
         else if(!rdorefbwgtnot11.isChecked() & !rdorefbwgtnot12.isChecked() & txtrefbwgt1.getText().toString().length()==0 & secrefbwgt1.isShown())
           {
             Connection.MessageBox(LD_DataExt.this, "Required field: g. Birth weight (grams).");
             txtrefbwgt1.requestFocus(); 
             return;	
           }
         else if(!rdorefbwgtnot11.isChecked() & !rdorefbwgtnot12.isChecked() & (Integer.valueOf(txtrefbwgt1.getText().toString().length()==0 ? "400" : txtrefbwgt1.getText().toString()) < 400 || Integer.valueOf(txtrefbwgt1.getText().toString().length()==0 ? "9999" : txtrefbwgt1.getText().toString()) > 9999))
           {
             Connection.MessageBox(LD_DataExt.this, "Value should be between 400 and 9999(g. Birth weight (grams)).");
             txtrefbwgt1.requestFocus(); 
             return;	
           }
         
         else if(txtrefbwgt1.getText().toString().length()==0 & !rdorefbwgtnot11.isChecked() & !rdorefbwgtnot12.isChecked() & secrefbwgtnot1.isShown())
           {
              Connection.MessageBox(LD_DataExt.this, "Select anyone options from (Child 1: g. Birth weight (grams)).");
              rdorefbwgtnot11.requestFocus();
              return;
           }
         
         else if(!rdorefbstim11.isChecked() & !rdorefbstim12.isChecked() & !rdorefbstim13.isChecked() & !rdorefbstim14.isChecked() & secrefbstim1.isShown())
           {
              Connection.MessageBox(LD_DataExt.this, "Select anyone options from (h. Was baby stimulated?).");
              rdorefbstim11.requestFocus();
              return;
           }
         
         else if(!rdorefbplast11.isChecked() & !rdorefbplast12.isChecked() & !rdorefbplast13.isChecked() & !rdorefbplast14.isChecked() & secrefbplast1.isShown())
           {
              Connection.MessageBox(LD_DataExt.this, "Select anyone options from (i. Baby resuscitated with bag and mask?).");
              rdorefbplast11.requestFocus();
              return;
           }
         
         else if(!rdorefappcord11.isChecked() & !rdorefappcord12.isChecked() & !rdorefappcord13.isChecked() & !rdorefappcord14.isChecked() & secrefappcord1.isShown())
           {
              Connection.MessageBox(LD_DataExt.this, "Select anyone options from (j. Chlorhexidine applied to cord for cleansing? ).");
              rdorefappcord11.requestFocus();
              return;
           }
         
         else if(!rdorefbbfd11.isChecked() & !rdorefbbfd12.isChecked() & !rdorefbbfd13.isChecked() & !rdorefbbfd14.isChecked() & !rdorefbbfd15.isChecked() & secrefbbfd1.isShown())
           {
              Connection.MessageBox(LD_DataExt.this, "Select anyone options from (k. Breast feeding initiated).");
              rdorefbbfd11.requestFocus();
              return;
           }
         
         else if(!rdorefbcond11.isChecked() & !rdorefbcond12.isChecked() & !rdorefbcond13.isChecked() & !rdorefbcond14.isChecked() & secrefbcond1.isShown())
           {
              Connection.MessageBox(LD_DataExt.this, "Select anyone options from (l. Condition of baby at discharge?).");
              rdorefbcond11.requestFocus();
              return;
           }
         
         else if(!rdorefdisoutld11.isChecked() & !rdorefdisoutld12.isChecked() & !rdorefdisoutld13.isChecked() & !rdorefdisoutld14.isChecked() & !rdorefdisoutld15.isChecked() & !rdorefdisoutld16.isChecked() & secrefdisoutld1.isShown())
           {
              Connection.MessageBox(LD_DataExt.this, "Select anyone options from (m. Outcome at discharge (baby) ).");
              rdorefdisoutld11.requestFocus();
              return;
           }
         else if(txtrefTransPlace1.getText().toString().length()==0 & secrefTransPlace1.isShown())
           {
             Connection.MessageBox(LD_DataExt.this, "Required field:       Transferred where.");
             txtrefTransPlace1.requestFocus(); 
             return;	
           }
         
         else if(!rdoreftypebirth21.isChecked() & !rdoreftypebirth22.isChecked() & !rdoreftypebirth23.isChecked() & !rdoreftypebirth24.isChecked() & !rdoreftypebirth25.isChecked() & secreftypebirth2.isShown())
           {
              Connection.MessageBox(LD_DataExt.this, "Select anyone options from (a. Mode of birth/delivery).");
              rdoreftypebirth21.requestFocus();
              return;
           }
         DV = Global.DateValidate(dtprefdelivdate2.getText().toString());
         if(!rdorefdelivdate2not1.isChecked() & !rdorefdelivdate2not2.isChecked() & DV.length()!=0 & secrefdelivdate2.isShown())
           {
             Connection.MessageBox(LD_DataExt.this, DV);
             dtprefdelivdate2.requestFocus(); 
             return;	
           }
         else if(!rdorefdelivtime2not1.isChecked() & !rdorefdelivtime2not2.isChecked() & txtrefdelivtime2.getText().length()==0 & secrefdelivtime2.isShown())
           {
             Connection.MessageBox(LD_DataExt.this, "Required field: c. Time of Delivery.");
             txtrefdelivtime2.requestFocus(); 
             return;	
           }
         
         else if(!rdorefbStatus21.isChecked() & !rdorefbStatus22.isChecked() & !rdorefbStatus23.isChecked() & !rdorefbStatus24.isChecked() & secrefbStatus2.isShown())
           {
              Connection.MessageBox(LD_DataExt.this, "Select anyone options from (d. Birth Outcome).");
              rdorefbStatus21.requestFocus();
              return;
           }
         
         else if(!rdoRefsbtype21.isChecked() & !rdoRefsbtype22.isChecked() & !rdoRefsbtype23.isChecked() & !rdoRefsbtype24.isChecked() & secRefsbtype2.isShown())
           {
              Connection.MessageBox(LD_DataExt.this, "Select anyone options from (e. Still birth type).");
              rdoRefsbtype21.requestFocus();
              return;
           }
         
         else if(!rdorefbsex21.isChecked() & !rdorefbsex22.isChecked() & !rdorefbsex23.isChecked() & !rdorefbsex24.isChecked() & !rdorefbsex25.isChecked() & secrefbsex2.isShown())
           {
              Connection.MessageBox(LD_DataExt.this, "Select anyone options from (f. Sex of Child).");
              rdorefbsex21.requestFocus();
              return;
           }
         else if(!rdorefbwgtnot21.isChecked() & !rdorefbwgtnot22.isChecked() & txtrefbwgt2.getText().toString().length()==0 & secrefbwgt2.isShown())
           {
             Connection.MessageBox(LD_DataExt.this, "Required field: g. Birth weight (grams).");
             txtrefbwgt2.requestFocus(); 
             return;	
           }
         else if(!rdorefbwgtnot21.isChecked() & !rdorefbwgtnot22.isChecked() & (Integer.valueOf(txtrefbwgt2.getText().toString().length()==0 ? "400" : txtrefbwgt2.getText().toString()) < 400 || Integer.valueOf(txtrefbwgt2.getText().toString().length()==0 ? "9999" : txtrefbwgt2.getText().toString()) > 9999))
           {
             Connection.MessageBox(LD_DataExt.this, "Value should be between 400 and 9999(g. Birth weight (grams)).");
             txtrefbwgt2.requestFocus(); 
             return;	
           }
         
         else if(txtrefbwgt2.getText().toString().length()==0 & !rdorefbwgtnot21.isChecked() & !rdorefbwgtnot22.isChecked() & secrefbwgtnot2.isShown())
           {
              Connection.MessageBox(LD_DataExt.this, "Select anyone options from (Child 2: g. Birth weight (grams)).");
              rdorefbwgtnot21.requestFocus();
              return;
           }
         
         else if(!rdorefbstim21.isChecked() & !rdorefbstim22.isChecked() & !rdorefbstim23.isChecked() & !rdorefbstim24.isChecked() & secrefbstim2.isShown())
           {
              Connection.MessageBox(LD_DataExt.this, "Select anyone options from (h. Was baby stimulated?).");
              rdorefbstim21.requestFocus();
              return;
           }
         
         else if(!rdorefbplast21.isChecked() & !rdorefbplast22.isChecked() & !rdorefbplast23.isChecked() & !rdorefbplast24.isChecked() & secrefbplast2.isShown())
           {
              Connection.MessageBox(LD_DataExt.this, "Select anyone options from (i. Baby resuscitated with bag and mask?).");
              rdorefbplast21.requestFocus();
              return;
           }
         
         else if(!rdorefappcord21.isChecked() & !rdorefappcord22.isChecked() & !rdorefappcord23.isChecked() & !rdorefappcord24.isChecked() & secrefappcord2.isShown())
           {
              Connection.MessageBox(LD_DataExt.this, "Select anyone options from (j. Chlorhexidine applied to cord for cleansing? ).");
              rdorefappcord21.requestFocus();
              return;
           }
         
         else if(!rdorefbbfd21.isChecked() & !rdorefbbfd22.isChecked() & !rdorefbbfd23.isChecked() & !rdorefbbfd24.isChecked() & !rdorefbbfd25.isChecked() & secrefbbfd2.isShown())
           {
              Connection.MessageBox(LD_DataExt.this, "Select anyone options from (k. Breast feeding initiated).");
              rdorefbbfd21.requestFocus();
              return;
           }
         
         else if(!rdorefbcond21.isChecked() & !rdorefbcond22.isChecked() & !rdorefbcond23.isChecked() & !rdorefbcond24.isChecked() & secrefbcond2.isShown())
           {
              Connection.MessageBox(LD_DataExt.this, "Select anyone options from (l. Condition of baby at discharge?).");
              rdorefbcond21.requestFocus();
              return;
           }
         
         else if(!rdorefdisoutld21.isChecked() & !rdorefdisoutld22.isChecked() & !rdorefdisoutld23.isChecked() & !rdorefdisoutld24.isChecked() & !rdorefdisoutld25.isChecked() & !rdorefdisoutld26.isChecked() & secrefdisoutld2.isShown())
           {
              Connection.MessageBox(LD_DataExt.this, "Select anyone options from (m. Outcome at discharge (baby) ).");
              rdorefdisoutld21.requestFocus();
              return;
           }
         else if(txtrefTransPlace2.getText().toString().length()==0 & secrefTransPlace2.isShown())
           {
             Connection.MessageBox(LD_DataExt.this, "Required field:       Transferred where.");
             txtrefTransPlace2.requestFocus(); 
             return;	
           }
         
         else if(!rdoreftypebirth31.isChecked() & !rdoreftypebirth32.isChecked() & !rdoreftypebirth33.isChecked() & !rdoreftypebirth34.isChecked() & !rdoreftypebirth35.isChecked() & secreftypebirth3.isShown())
           {
              Connection.MessageBox(LD_DataExt.this, "Select anyone options from (a. Mode of birth/delivery).");
              rdoreftypebirth31.requestFocus();
              return;
           }
         DV = Global.DateValidate(dtprefdelivdate3.getText().toString());
         if(!rdorefdelivdate3not1.isChecked() & !rdorefdelivdate3not2.isChecked() & DV.length()!=0 & secrefdelivdate3.isShown())
           {
             Connection.MessageBox(LD_DataExt.this, DV);
             dtprefdelivdate3.requestFocus(); 
             return;	
           }
         else if(!rdorefdelivtime3not1.isChecked() & !rdorefdelivtime3not2.isChecked() & txtrefdelivtime3.getText().length()==0 & secrefdelivtime3.isShown())
           {
             Connection.MessageBox(LD_DataExt.this, "Required field: c. Time of Delivery.");
             txtrefdelivtime3.requestFocus(); 
             return;	
           }
         
         else if(!rdorefbStatus31.isChecked() & !rdorefbStatus32.isChecked() & !rdorefbStatus33.isChecked() & !rdorefbStatus34.isChecked() & secrefbStatus3.isShown())
           {
              Connection.MessageBox(LD_DataExt.this, "Select anyone options from (d. Birth Outcome).");
              rdorefbStatus31.requestFocus();
              return;
           }
         
         else if(!rdoRefsbtype31.isChecked() & !rdoRefsbtype32.isChecked() & !rdoRefsbtype33.isChecked() & !rdoRefsbtype34.isChecked() & secRefsbtype3.isShown())
           {
              Connection.MessageBox(LD_DataExt.this, "Select anyone options from (e. Still birth type).");
              rdoRefsbtype31.requestFocus();
              return;
           }
         
         else if(!rdorefbsex31.isChecked() & !rdorefbsex32.isChecked() & !rdorefbsex33.isChecked() & !rdorefbsex34.isChecked() & !rdorefbsex35.isChecked() & secrefbsex3.isShown())
           {
              Connection.MessageBox(LD_DataExt.this, "Select anyone options from (f. Sex of Child).");
              rdorefbsex31.requestFocus();
              return;
           }
         else if(!rdorefbwgtnot31.isChecked() & !rdorefbwgtnot32.isChecked() & txtrefbwgt3.getText().toString().length()==0 & secrefbwgt3.isShown())
           {
             Connection.MessageBox(LD_DataExt.this, "Required field: g. Birth weight (grams).");
             txtrefbwgt3.requestFocus(); 
             return;	
           }
         else if(!rdorefbwgtnot31.isChecked() & !rdorefbwgtnot32.isChecked() & (Integer.valueOf(txtrefbwgt3.getText().toString().length()==0 ? "400" : txtrefbwgt3.getText().toString()) < 400 || Integer.valueOf(txtrefbwgt3.getText().toString().length()==0 ? "9999" : txtrefbwgt3.getText().toString()) > 9999))
           {
             Connection.MessageBox(LD_DataExt.this, "Value should be between 400 and 9999(g. Birth weight (grams)).");
             txtrefbwgt3.requestFocus(); 
             return;	
           }
         
         else if(txtrefbwgt3.getText().toString().length()==0 & !rdorefbwgtnot31.isChecked() & !rdorefbwgtnot32.isChecked() & secrefbwgtnot3.isShown())
           {
              Connection.MessageBox(LD_DataExt.this, "Select anyone options from (Child 3: g. Birth weight (grams)).");
              rdorefbwgtnot31.requestFocus();
              return;
           }
         
         else if(!rdorefbstim31.isChecked() & !rdorefbstim32.isChecked() & !rdorefbstim33.isChecked() & !rdorefbstim34.isChecked() & secrefbstim3.isShown())
           {
              Connection.MessageBox(LD_DataExt.this, "Select anyone options from (h. Was baby stimulated?).");
              rdorefbstim31.requestFocus();
              return;
           }
         
         else if(!rdorefbplast31.isChecked() & !rdorefbplast32.isChecked() & !rdorefbplast33.isChecked() & !rdorefbplast34.isChecked() & secrefbplast3.isShown())
           {
              Connection.MessageBox(LD_DataExt.this, "Select anyone options from (i. Baby resuscitated with bag and mask?).");
              rdorefbplast31.requestFocus();
              return;
           }
         
         else if(!rdorefappcord31.isChecked() & !rdorefappcord32.isChecked() & !rdorefappcord33.isChecked() & !rdorefappcord34.isChecked() & secrefappcord3.isShown())
           {
              Connection.MessageBox(LD_DataExt.this, "Select anyone options from (j. Chlorhexidine applied to cord for cleansing? ).");
              rdorefappcord31.requestFocus();
              return;
           }
         
         else if(!rdorefbbfd31.isChecked() & !rdorefbbfd32.isChecked() & !rdorefbbfd33.isChecked() & !rdorefbbfd34.isChecked() & !rdorefbbfd35.isChecked() & secrefbbfd3.isShown())
           {
              Connection.MessageBox(LD_DataExt.this, "Select anyone options from (k. Breast feeding initiated).");
              rdorefbbfd31.requestFocus();
              return;
           }
         
         else if(!rdorefbcond31.isChecked() & !rdorefbcond32.isChecked() & !rdorefbcond33.isChecked() & !rdorefbcond34.isChecked() & secrefbcond3.isShown())
           {
              Connection.MessageBox(LD_DataExt.this, "Select anyone options from (l. Condition of baby at discharge?).");
              rdorefbcond31.requestFocus();
              return;
           }
         
         else if(!rdorefdisoutld31.isChecked() & !rdorefdisoutld32.isChecked() & !rdorefdisoutld33.isChecked() & !rdorefdisoutld34.isChecked() & !rdorefdisoutld35.isChecked() & !rdorefdisoutld36.isChecked() & secrefdisoutld3.isShown())
           {
              Connection.MessageBox(LD_DataExt.this, "Select anyone options from (m. Outcome at discharge (baby) ).");
              rdorefdisoutld31.requestFocus();
              return;
           }
         else if(txtrefTransPlace3.getText().toString().length()==0 & secrefTransPlace3.isShown())
           {
             Connection.MessageBox(LD_DataExt.this, "Required field:       Transferred where.");
             txtrefTransPlace3.requestFocus(); 
             return;	
           }
         else if(!rdorefpphnot1.isChecked() & !rdorefpphnot2.isChecked() & txtrefpph.getText().toString().length()==0 & secrefpph.isShown())
           {
             Connection.MessageBox(LD_DataExt.this, "Required field: Estimated blood loss in ml.");
             txtrefpph.requestFocus(); 
             return;	
           }
         else if(!rdorefpphnot1.isChecked() & !rdorefpphnot2.isChecked() & (Integer.valueOf(txtrefpph.getText().toString().length()==0 ? "1" : txtrefpph.getText().toString()) < 1 || Integer.valueOf(txtrefpph.getText().toString().length()==0 ? "9999" : txtrefpph.getText().toString()) > 9999))
           {
             Connection.MessageBox(LD_DataExt.this, "Value should be between 1 and 9999(Estimated blood loss in ml).");
             txtrefpph.requestFocus();
             return;
           }
         
         else if(txtrefpph.getText().toString().length()==0 & !rdorefpphnot1.isChecked() & !rdorefpphnot2.isChecked() & secrefpphnot.isShown())
           {
              Connection.MessageBox(LD_DataExt.this, "Select anyone options from (8.Estimated blood loss in ml).");
              rdorefpphnot1.requestFocus();
              return;
           }

         else if(!rdorefretainplac1.isChecked() & !rdorefretainplac2.isChecked() & !rdorefretainplac3.isChecked() & !rdorefretainplac4.isChecked() & !rdorefretainplac5.isChecked() & !rdorefretainplac6.isChecked() & secrefretainplac.isShown())
           {
              Connection.MessageBox(LD_DataExt.this, "Select anyone options from (Mother experienced a retained placenta).");
              rdorefretainplac1.requestFocus();
              return;
           }
         DV = Global.DateValidate(dtprefdodld.getText().toString());
         if(!rdorefdodldnot1.isChecked() & !rdorefdodldnot2.isChecked() & DV.length()!=0 & secrefdodld.isShown())
           {
             Connection.MessageBox(LD_DataExt.this, DV);
             dtprefdodld.requestFocus(); 
             return;	
           }
         else if(!rdoreftodldnot1.isChecked() & !rdoreftodldnot2.isChecked() & txtreftodld.getText().length()==0 & secreftodld.isShown())
           {
             Connection.MessageBox(LD_DataExt.this, "Required field: Time of discharge from labour ward.");
             txtreftodld.requestFocus(); 
             return;	
           }
         
         else if(!rdorefmatcond1.isChecked() & !rdorefmatcond2.isChecked() & !rdorefmatcond3.isChecked() & !rdorefmatcond4.isChecked() & !rdorefmatcond5.isChecked() & !rdorefmatcond6.isChecked() & secrefmatcond.isShown())
           {
              Connection.MessageBox(LD_DataExt.this, "Select anyone options from (Outcome at discharge (mother)).");
              rdorefmatcond1.requestFocus();
              return;
           }
         else if(txtrefTransPlaceM.getText().toString().length()==0 & secrefTransPlaceM.isShown())
           {
             Connection.MessageBox(LD_DataExt.this, "Required field: Transferred alive where.");
             txtrefTransPlaceM.requestFocus(); 
             return;	
           }



         else if(!rdostatus1.isChecked() & !rdostatus2.isChecked() & !rdostatus3.isChecked() & secstatus.isShown())
         {
             Connection.MessageBox(LD_DataExt.this, "Required field: 12. What is the final status of the Recall Survey for this patient");
             rdostatus1.requestFocus();
             return;
         }
         else if(!rdoreason1.isChecked() & !rdoreason2.isChecked() & !rdoreason3.isChecked() & !rdoreason4.isChecked() & secreason.isShown())
         {
             Connection.MessageBox(LD_DataExt.this, "Required field: 13. Why partially incomplete or totally incomplete?");
             rdoreason1.requestFocus();
             return;
         }


         String SQL = "";
         RadioButton rb;

         LD_DataExt_DataModel objSave = new LD_DataExt_DataModel();
         objSave.setCountryCode(txtCountryCode.getText().toString());
         objSave.setFaciCode(txtFaciCode.getText().toString());
         objSave.setDataID(txtDataID.getText().toString());
         objSave.setrefdoe(dtprefdoe.getText().toString().length() > 0 ? Global.DateConvertYMD(dtprefdoe.getText().toString()) : dtprefdoe.getText().toString());
         objSave.setrefgald(txtrefgald.getText().toString());
         String[] d_rdogrprefgaldnot = new String[] {"1","2"};
         objSave.setrefgaldnot("");
         for (int i = 0; i < rdogrprefgaldnot.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefgaldnot.getChildAt(i);
             if (rb.isChecked()) objSave.setrefgaldnot(d_rdogrprefgaldnot[i]);
         }

         String[] d_rdogrprefacsgiven = new String[] {"1","2","8","9","5"};
         objSave.setrefacsgiven("");
         for (int i = 0; i < rdogrprefacsgiven.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefacsgiven.getChildAt(i);
             if (rb.isChecked()) objSave.setrefacsgiven(d_rdogrprefacsgiven[i]);
         }

         objSave.setrefgacalc(dtprefgacalc.getText().toString().length() > 0 ? Global.DateConvertYMD(dtprefgacalc.getText().toString()) : dtprefgacalc.getText().toString());
         String[] d_rdogrprefgacalcnot = new String[] {"1","2"};
         objSave.setrefgacalcnot("");
         for (int i = 0; i < rdogrprefgacalcnot.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefgacalcnot.getChildAt(i);
             if (rb.isChecked()) objSave.setrefgacalcnot(d_rdogrprefgacalcnot[i]);
         }

         String[] d_rdogrprefmedadeliv = new String[] {"1","2","8","9"};
         objSave.setrefmedadeliv("");
         for (int i = 0; i < rdogrprefmedadeliv.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefmedadeliv.getChildAt(i);
             if (rb.isChecked()) objSave.setrefmedadeliv(d_rdogrprefmedadeliv[i]);
         }

         String[] d_rdogrpnumofbirth = new String[] {"1","2","3"};
         objSave.setnumofbirth("");
         for (int i = 0; i < rdogrpnumofbirth.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpnumofbirth.getChildAt(i);
             if (rb.isChecked()) objSave.setnumofbirth(d_rdogrpnumofbirth[i]);
         }

         String[] d_rdogrpreftypebirth1 = new String[] {"1","2","3","8","9"};
         objSave.setreftypebirth1("");
         for (int i = 0; i < rdogrpreftypebirth1.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpreftypebirth1.getChildAt(i);
             if (rb.isChecked()) objSave.setreftypebirth1(d_rdogrpreftypebirth1[i]);
         }

         objSave.setrefdelivdate1(dtprefdelivdate1.getText().toString().length() > 0 ? Global.DateConvertYMD(dtprefdelivdate1.getText().toString()) : dtprefdelivdate1.getText().toString());
         if(rdorefdelivdate1not1.isChecked()) objSave.setrefdelivdate1not("1");
         else if(rdorefdelivdate1not2.isChecked()) objSave.setrefdelivdate1not("2");
         else objSave.setrefdelivdate1not("");

         objSave.setrefdelivtime1(txtrefdelivtime1.getText().toString());
         if(rdorefdelivtime1not1.isChecked()) objSave.setrefdelivtime1not("1");
         else if(rdorefdelivtime1not2.isChecked()) objSave.setrefdelivtime1not("2");
         else objSave.setrefdelivtime1not("");

         String[] d_rdogrprefbStatus1 = new String[] {"1","2","8","9"};
         objSave.setrefbStatus1("");
         for (int i = 0; i < rdogrprefbStatus1.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefbStatus1.getChildAt(i);
             if (rb.isChecked()) objSave.setrefbStatus1(d_rdogrprefbStatus1[i]);
         }

         String[] d_rdogrpRefsbtype1 = new String[] {"1","2","8","9"};
         objSave.setRefsbtype1("");
         for (int i = 0; i < rdogrpRefsbtype1.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpRefsbtype1.getChildAt(i);
             if (rb.isChecked()) objSave.setRefsbtype1(d_rdogrpRefsbtype1[i]);
         }

         String[] d_rdogrprefbsex1 = new String[] {"1","2","3","8","9"};
         objSave.setrefbsex1("");
         for (int i = 0; i < rdogrprefbsex1.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefbsex1.getChildAt(i);
             if (rb.isChecked()) objSave.setrefbsex1(d_rdogrprefbsex1[i]);
         }

         objSave.setrefbwgt1(txtrefbwgt1.getText().toString());
         String[] d_rdogrprefbwgtnot1 = new String[] {"1","2"};
         objSave.setrefbwgtnot1("");
         for (int i = 0; i < rdogrprefbwgtnot1.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefbwgtnot1.getChildAt(i);
             if (rb.isChecked()) objSave.setrefbwgtnot1(d_rdogrprefbwgtnot1[i]);
         }

         String[] d_rdogrprefbstim1 = new String[] {"1","2","8","9"};
         objSave.setrefbstim1("");
         for (int i = 0; i < rdogrprefbstim1.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefbstim1.getChildAt(i);
             if (rb.isChecked()) objSave.setrefbstim1(d_rdogrprefbstim1[i]);
         }

         String[] d_rdogrprefbplast1 = new String[] {"1","2","8","9"};
         objSave.setrefbplast1("");
         for (int i = 0; i < rdogrprefbplast1.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefbplast1.getChildAt(i);
             if (rb.isChecked()) objSave.setrefbplast1(d_rdogrprefbplast1[i]);
         }

         String[] d_rdogrprefappcord1 = new String[] {"1","2","8","9"};
         objSave.setrefappcord1("");
         for (int i = 0; i < rdogrprefappcord1.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefappcord1.getChildAt(i);
             if (rb.isChecked()) objSave.setrefappcord1(d_rdogrprefappcord1[i]);
         }

         String[] d_rdogrprefbbfd1 = new String[] {"1","2","8","9","5"};
         objSave.setrefbbfd1("");
         for (int i = 0; i < rdogrprefbbfd1.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefbbfd1.getChildAt(i);
             if (rb.isChecked()) objSave.setrefbbfd1(d_rdogrprefbbfd1[i]);
         }

         String[] d_rdogrprefbcond1 = new String[] {"1","3","8","9"};
         objSave.setrefbcond1("");
         for (int i = 0; i < rdogrprefbcond1.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefbcond1.getChildAt(i);
             if (rb.isChecked()) objSave.setrefbcond1(d_rdogrprefbcond1[i]);
         }

         String[] d_rdogrprefdisoutld1 = new String[] {"1","2","3","4","8","9"};
         objSave.setrefdisoutld1("");
         for (int i = 0; i < rdogrprefdisoutld1.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefdisoutld1.getChildAt(i);
             if (rb.isChecked()) objSave.setrefdisoutld1(d_rdogrprefdisoutld1[i]);
         }

         objSave.setrefTransPlace1(txtrefTransPlace1.getText().toString());
         String[] d_rdogrpreftypebirth2 = new String[] {"1","2","3","8","9"};
         objSave.setreftypebirth2("");
         for (int i = 0; i < rdogrpreftypebirth2.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpreftypebirth2.getChildAt(i);
             if (rb.isChecked()) objSave.setreftypebirth2(d_rdogrpreftypebirth2[i]);
         }

         objSave.setrefdelivdate2(dtprefdelivdate2.getText().toString().length() > 0 ? Global.DateConvertYMD(dtprefdelivdate2.getText().toString()) : dtprefdelivdate2.getText().toString());
         if(rdorefdelivdate2not1.isChecked()) objSave.setrefdelivdate2not("1");
         else if(rdorefdelivdate2not2.isChecked()) objSave.setrefdelivdate2not("2");
         else objSave.setrefdelivdate2not("");

         objSave.setrefdelivtime2(txtrefdelivtime2.getText().toString());
         if(rdorefdelivtime2not1.isChecked()) objSave.setrefdelivtime2not("1");
         else if(rdorefdelivtime2not2.isChecked()) objSave.setrefdelivtime2not("2");
         else objSave.setrefdelivtime2not("");

         String[] d_rdogrprefbStatus2 = new String[] {"1","2","8","9"};
         objSave.setrefbStatus2("");
         for (int i = 0; i < rdogrprefbStatus2.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefbStatus2.getChildAt(i);
             if (rb.isChecked()) objSave.setrefbStatus2(d_rdogrprefbStatus2[i]);
         }

         String[] d_rdogrpRefsbtype2 = new String[] {"1","2","8","9"};
         objSave.setRefsbtype2("");
         for (int i = 0; i < rdogrpRefsbtype2.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpRefsbtype2.getChildAt(i);
             if (rb.isChecked()) objSave.setRefsbtype2(d_rdogrpRefsbtype2[i]);
         }

         String[] d_rdogrprefbsex2 = new String[] {"1","2","3","8","9"};
         objSave.setrefbsex2("");
         for (int i = 0; i < rdogrprefbsex2.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefbsex2.getChildAt(i);
             if (rb.isChecked()) objSave.setrefbsex2(d_rdogrprefbsex2[i]);
         }

         objSave.setrefbwgt2(txtrefbwgt2.getText().toString());
         String[] d_rdogrprefbwgtnot2 = new String[] {"1","2"};
         objSave.setrefbwgtnot2("");
         for (int i = 0; i < rdogrprefbwgtnot2.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefbwgtnot2.getChildAt(i);
             if (rb.isChecked()) objSave.setrefbwgtnot2(d_rdogrprefbwgtnot2[i]);
         }

         String[] d_rdogrprefbstim2 = new String[] {"1","2","8","9"};
         objSave.setrefbstim2("");
         for (int i = 0; i < rdogrprefbstim2.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefbstim2.getChildAt(i);
             if (rb.isChecked()) objSave.setrefbstim2(d_rdogrprefbstim2[i]);
         }

         String[] d_rdogrprefbplast2 = new String[] {"1","2","8","9"};
         objSave.setrefbplast2("");
         for (int i = 0; i < rdogrprefbplast2.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefbplast2.getChildAt(i);
             if (rb.isChecked()) objSave.setrefbplast2(d_rdogrprefbplast2[i]);
         }

         String[] d_rdogrprefappcord2 = new String[] {"1","2","8","9"};
         objSave.setrefappcord2("");
         for (int i = 0; i < rdogrprefappcord2.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefappcord2.getChildAt(i);
             if (rb.isChecked()) objSave.setrefappcord2(d_rdogrprefappcord2[i]);
         }

         String[] d_rdogrprefbbfd2 = new String[] {"1","2","8","9","5"};
         objSave.setrefbbfd2("");
         for (int i = 0; i < rdogrprefbbfd2.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefbbfd2.getChildAt(i);
             if (rb.isChecked()) objSave.setrefbbfd2(d_rdogrprefbbfd2[i]);
         }

         String[] d_rdogrprefbcond2 = new String[] {"1","3","8","9"};
         objSave.setrefbcond2("");
         for (int i = 0; i < rdogrprefbcond2.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefbcond2.getChildAt(i);
             if (rb.isChecked()) objSave.setrefbcond2(d_rdogrprefbcond2[i]);
         }

         String[] d_rdogrprefdisoutld2 = new String[] {"1","2","3","4","8","9"};
         objSave.setrefdisoutld2("");
         for (int i = 0; i < rdogrprefdisoutld2.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefdisoutld2.getChildAt(i);
             if (rb.isChecked()) objSave.setrefdisoutld2(d_rdogrprefdisoutld2[i]);
         }

         objSave.setrefTransPlace2(txtrefTransPlace2.getText().toString());
         String[] d_rdogrpreftypebirth3 = new String[] {"1","2","3","8","9"};
         objSave.setreftypebirth3("");
         for (int i = 0; i < rdogrpreftypebirth3.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpreftypebirth3.getChildAt(i);
             if (rb.isChecked()) objSave.setreftypebirth3(d_rdogrpreftypebirth3[i]);
         }

         objSave.setrefdelivdate3(dtprefdelivdate3.getText().toString().length() > 0 ? Global.DateConvertYMD(dtprefdelivdate3.getText().toString()) : dtprefdelivdate3.getText().toString());
         if(rdorefdelivdate3not1.isChecked()) objSave.setrefdelivdate3not("1");
         else if(rdorefdelivdate3not2.isChecked()) objSave.setrefdelivdate3not("2");
         else objSave.setrefdelivdate3not("");

         objSave.setrefdelivtime3(txtrefdelivtime3.getText().toString());
         if(rdorefdelivtime3not1.isChecked()) objSave.setrefdelivtime3not("1");
         else if(rdorefdelivtime3not2.isChecked()) objSave.setrefdelivtime3not("2");
         else objSave.setrefdelivtime3not("");

         String[] d_rdogrprefbStatus3 = new String[] {"1","2","8","9"};
         objSave.setrefbStatus3("");
         for (int i = 0; i < rdogrprefbStatus3.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefbStatus3.getChildAt(i);
             if (rb.isChecked()) objSave.setrefbStatus3(d_rdogrprefbStatus3[i]);
         }

         String[] d_rdogrpRefsbtype3 = new String[] {"1","2","8","9"};
         objSave.setRefsbtype3("");
         for (int i = 0; i < rdogrpRefsbtype3.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpRefsbtype3.getChildAt(i);
             if (rb.isChecked()) objSave.setRefsbtype3(d_rdogrpRefsbtype3[i]);
         }

         String[] d_rdogrprefbsex3 = new String[] {"1","2","3","8","9"};
         objSave.setrefbsex3("");
         for (int i = 0; i < rdogrprefbsex3.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefbsex3.getChildAt(i);
             if (rb.isChecked()) objSave.setrefbsex3(d_rdogrprefbsex3[i]);
         }

         objSave.setrefbwgt3(txtrefbwgt3.getText().toString());
         String[] d_rdogrprefbwgtnot3 = new String[] {"1","2"};
         objSave.setrefbwgtnot3("");
         for (int i = 0; i < rdogrprefbwgtnot3.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefbwgtnot3.getChildAt(i);
             if (rb.isChecked()) objSave.setrefbwgtnot3(d_rdogrprefbwgtnot3[i]);
         }

         String[] d_rdogrprefbstim3 = new String[] {"1","2","8","9"};
         objSave.setrefbstim3("");
         for (int i = 0; i < rdogrprefbstim3.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefbstim3.getChildAt(i);
             if (rb.isChecked()) objSave.setrefbstim3(d_rdogrprefbstim3[i]);
         }

         String[] d_rdogrprefbplast3 = new String[] {"1","2","8","9"};
         objSave.setrefbplast3("");
         for (int i = 0; i < rdogrprefbplast3.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefbplast3.getChildAt(i);
             if (rb.isChecked()) objSave.setrefbplast3(d_rdogrprefbplast3[i]);
         }

         String[] d_rdogrprefappcord3 = new String[] {"1","2","8","9"};
         objSave.setrefappcord3("");
         for (int i = 0; i < rdogrprefappcord3.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefappcord3.getChildAt(i);
             if (rb.isChecked()) objSave.setrefappcord3(d_rdogrprefappcord3[i]);
         }

         String[] d_rdogrprefbbfd3 = new String[] {"1","2","8","9","5"};
         objSave.setrefbbfd3("");
         for (int i = 0; i < rdogrprefbbfd3.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefbbfd3.getChildAt(i);
             if (rb.isChecked()) objSave.setrefbbfd3(d_rdogrprefbbfd3[i]);
         }

         String[] d_rdogrprefbcond3 = new String[] {"1","3","8","9"};
         objSave.setrefbcond3("");
         for (int i = 0; i < rdogrprefbcond3.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefbcond3.getChildAt(i);
             if (rb.isChecked()) objSave.setrefbcond3(d_rdogrprefbcond3[i]);
         }

         String[] d_rdogrprefdisoutld3 = new String[] {"1","2","3","4","8","9"};
         objSave.setrefdisoutld3("");
         for (int i = 0; i < rdogrprefdisoutld3.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefdisoutld3.getChildAt(i);
             if (rb.isChecked()) objSave.setrefdisoutld3(d_rdogrprefdisoutld3[i]);
         }

         objSave.setrefTransPlace3(txtrefTransPlace3.getText().toString());
         objSave.setrefpph(txtrefpph.getText().toString());
         String[] d_rdogrprefpphnot = new String[] {"1","2"};
         objSave.setrefpphnot("");
         for (int i = 0; i < rdogrprefpphnot.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefpphnot.getChildAt(i);
             if (rb.isChecked()) objSave.setrefpphnot(d_rdogrprefpphnot[i]);
         }

         String[] d_rdogrprefretainplac = new String[] {"1","2","3","4","8","9"};
         objSave.setrefretainplac("");
         for (int i = 0; i < rdogrprefretainplac.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefretainplac.getChildAt(i);
             if (rb.isChecked()) objSave.setrefretainplac(d_rdogrprefretainplac[i]);
         }

         objSave.setrefdodld(dtprefdodld.getText().toString().length() > 0 ? Global.DateConvertYMD(dtprefdodld.getText().toString()) : dtprefdodld.getText().toString());
         if(rdorefdodldnot1.isChecked()) objSave.setrefdodldnot("1");
         else if(rdorefdodldnot2.isChecked()) objSave.setrefdodldnot("2");
         else objSave.setrefdodldnot("");

         objSave.setreftodld(txtreftodld.getText().toString());
         if(rdoreftodldnot1.isChecked()) objSave.setreftodldnot("1");
         else if(rdoreftodldnot2.isChecked()) objSave.setreftodldnot("2");
         else objSave.setreftodldnot("");


         String[] d_rdogrprefmatcond = new String[] {"1","2","3","4","8","9"};
         objSave.setrefmatcond("");
         for (int i = 0; i < rdogrprefmatcond.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefmatcond.getChildAt(i);
             if (rb.isChecked()) objSave.setrefmatcond(d_rdogrprefmatcond[i]);
         }

         //Status
         String[] d_rdogrpstatus = new String[] {"1","2","3"};
         objSave.setStatus("");
         for (int i = 0; i < rdogrpstatus.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpstatus.getChildAt(i);
             if (rb.isChecked()) objSave.setStatus(d_rdogrpstatus[i]);
         }

         String[] d_rdogrpreason = new String[] {"1","2","3","4"};
         objSave.setReason("");
         for (int i = 0; i < rdogrpreason.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpreason.getChildAt(i);
             if (rb.isChecked()) objSave.setReason(d_rdogrpreason[i]);
         }

         objSave.setReasmention(txtreasmention.getText().toString());

         objSave.setrefTransPlaceM(txtrefTransPlaceM.getText().toString());
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
             C.SaveDT("Update Registration set StatusDE='1',Upload='2',modifyDate='"+ Global.DateTimeNowYMDHMS() +"' where CountryCode='" + COUNTRYCODE + "' and FaciCode='" + FACICODE + "' and DataId='" + DATAID + "'");
             Intent returnIntent = new Intent();
             returnIntent.putExtra("res", "");
             setResult(Activity.RESULT_OK, returnIntent);

             Connection.MessageBox(LD_DataExt.this, "Saved Successfully");
         }
         else{
             Connection.MessageBox(LD_DataExt.this, status);
             return;
         }
     }
     catch(Exception  e)
     {
         Connection.MessageBox(LD_DataExt.this, e.getMessage());
         return;
     }
 }

 private void DataSearch(String CountryCode, String FaciCode, String DataID)
     {
       try
        {
     
           RadioButton rb;
           LD_DataExt_DataModel d = new LD_DataExt_DataModel();
           String SQL = "Select * from "+ TableName +"  Where CountryCode='"+ CountryCode +"' and FaciCode='"+ FaciCode +"' and DataID='"+ DataID +"'";
           List<LD_DataExt_DataModel> data = d.SelectAll(this, SQL);
           for(LD_DataExt_DataModel item : data){
             txtCountryCode.setText(item.getCountryCode());
             txtFaciCode.setText(item.getFaciCode());
             txtDataID.setText(item.getDataID());
             dtprefdoe.setText(item.getrefdoe().toString().length()==0 ? "" : Global.DateConvertDMY(item.getrefdoe()));
             txtrefgald.setText(item.getrefgald());
             String[] d_rdogrprefgaldnot = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrprefgaldnot.length; i++)
             {
                 if (item.getrefgaldnot().equals(String.valueOf(d_rdogrprefgaldnot[i])))
                 {
                     rb = (RadioButton)rdogrprefgaldnot.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrprefacsgiven = new String[] {"1","2","8","9","5"};
             for (int i = 0; i < d_rdogrprefacsgiven.length; i++)
             {
                 if (item.getrefacsgiven().equals(String.valueOf(d_rdogrprefacsgiven[i])))
                 {
                     rb = (RadioButton)rdogrprefacsgiven.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             dtprefgacalc.setText(item.getrefgacalc().toString().length()==0 ? "" : Global.DateConvertDMY(item.getrefgacalc()));
             String[] d_rdogrprefgacalcnot = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrprefgacalcnot.length; i++)
             {
                 if (item.getrefgacalcnot().equals(String.valueOf(d_rdogrprefgacalcnot[i])))
                 {
                     rb = (RadioButton)rdogrprefgacalcnot.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrprefmedadeliv = new String[] {"1","2","8","9"};
             for (int i = 0; i < d_rdogrprefmedadeliv.length; i++)
             {
                 if (item.getrefmedadeliv().equals(String.valueOf(d_rdogrprefmedadeliv[i])))
                 {
                     rb = (RadioButton)rdogrprefmedadeliv.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpnumofbirth = new String[] {"1","2","3"};
             for (int i = 0; i < d_rdogrpnumofbirth.length; i++)
             {
                 if (item.getnumofbirth().equals(String.valueOf(d_rdogrpnumofbirth[i])))
                 {
                     rb = (RadioButton)rdogrpnumofbirth.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpreftypebirth1 = new String[] {"1","2","3","8","9"};
             for (int i = 0; i < d_rdogrpreftypebirth1.length; i++)
             {
                 if (item.getreftypebirth1().equals(String.valueOf(d_rdogrpreftypebirth1[i])))
                 {
                     rb = (RadioButton)rdogrpreftypebirth1.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             dtprefdelivdate1.setText(item.getrefdelivdate1().toString().length()==0 ? "" : Global.DateConvertDMY(item.getrefdelivdate1()));
             if(item.getrefdelivdate1not().equals("1")) rdorefdelivdate1not1.setChecked(true);
             if(item.getrefdelivdate1not().equals("2")) rdorefdelivdate1not2.setChecked(true);

             txtrefdelivtime1.setText(item.getrefdelivtime1());
             if(item.getrefdelivtime1not().equals("1"))  rdorefdelivtime1not1.setChecked(true);
             else if(item.getrefdelivtime1not().equals("2"))  rdorefdelivtime1not2.setChecked(true);

             String[] d_rdogrprefbStatus1 = new String[] {"1","2","8","9"};
             for (int i = 0; i < d_rdogrprefbStatus1.length; i++)
             {
                 if (item.getrefbStatus1().equals(String.valueOf(d_rdogrprefbStatus1[i])))
                 {
                     rb = (RadioButton)rdogrprefbStatus1.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpRefsbtype1 = new String[] {"1","2","8","9"};
             for (int i = 0; i < d_rdogrpRefsbtype1.length; i++)
             {
                 if (item.getRefsbtype1().equals(String.valueOf(d_rdogrpRefsbtype1[i])))
                 {
                     rb = (RadioButton)rdogrpRefsbtype1.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrprefbsex1 = new String[] {"1","2","3","8","9"};
             for (int i = 0; i < d_rdogrprefbsex1.length; i++)
             {
                 if (item.getrefbsex1().equals(String.valueOf(d_rdogrprefbsex1[i])))
                 {
                     rb = (RadioButton)rdogrprefbsex1.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtrefbwgt1.setText(item.getrefbwgt1());
             String[] d_rdogrprefbwgtnot1 = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrprefbwgtnot1.length; i++)
             {
                 if (item.getrefbwgtnot1().equals(String.valueOf(d_rdogrprefbwgtnot1[i])))
                 {
                     rb = (RadioButton)rdogrprefbwgtnot1.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrprefbstim1 = new String[] {"1","2","8","9"};
             for (int i = 0; i < d_rdogrprefbstim1.length; i++)
             {
                 if (item.getrefbstim1().equals(String.valueOf(d_rdogrprefbstim1[i])))
                 {
                     rb = (RadioButton)rdogrprefbstim1.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrprefbplast1 = new String[] {"1","2","8","9"};
             for (int i = 0; i < d_rdogrprefbplast1.length; i++)
             {
                 if (item.getrefbplast1().equals(String.valueOf(d_rdogrprefbplast1[i])))
                 {
                     rb = (RadioButton)rdogrprefbplast1.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrprefappcord1 = new String[] {"1","2","8","9"};
             for (int i = 0; i < d_rdogrprefappcord1.length; i++)
             {
                 if (item.getrefappcord1().equals(String.valueOf(d_rdogrprefappcord1[i])))
                 {
                     rb = (RadioButton)rdogrprefappcord1.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrprefbbfd1 = new String[] {"1","2","8","9","5"};
             for (int i = 0; i < d_rdogrprefbbfd1.length; i++)
             {
                 if (item.getrefbbfd1().equals(String.valueOf(d_rdogrprefbbfd1[i])))
                 {
                     rb = (RadioButton)rdogrprefbbfd1.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrprefbcond1 = new String[] {"1","3","8","9"};
             for (int i = 0; i < d_rdogrprefbcond1.length; i++)
             {
                 if (item.getrefbcond1().equals(String.valueOf(d_rdogrprefbcond1[i])))
                 {
                     rb = (RadioButton)rdogrprefbcond1.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrprefdisoutld1 = new String[] {"1","2","3","4","8","9"};
             for (int i = 0; i < d_rdogrprefdisoutld1.length; i++)
             {
                 if (item.getrefdisoutld1().equals(String.valueOf(d_rdogrprefdisoutld1[i])))
                 {
                     rb = (RadioButton)rdogrprefdisoutld1.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtrefTransPlace1.setText(item.getrefTransPlace1());
             String[] d_rdogrpreftypebirth2 = new String[] {"1","2","3","8","9"};
             for (int i = 0; i < d_rdogrpreftypebirth2.length; i++)
             {
                 if (item.getreftypebirth2().equals(String.valueOf(d_rdogrpreftypebirth2[i])))
                 {
                     rb = (RadioButton)rdogrpreftypebirth2.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             dtprefdelivdate2.setText(item.getrefdelivdate2().toString().length()==0 ? "" : Global.DateConvertDMY(item.getrefdelivdate2()));
             if(item.getrefdelivdate2not().equals("1")) rdorefdelivdate2not1.setChecked(true);
               else if(item.getrefdelivdate2not().equals("2")) rdorefdelivdate2not2.setChecked(true);


               txtrefdelivtime2.setText(item.getrefdelivtime2());
               if(item.getrefdelivtime2not().equals("1")) rdorefdelivtime2not1.setChecked(true);
               else if(item.getrefdelivtime2not().equals("2")) rdorefdelivtime2not2.setChecked(true);

             String[] d_rdogrprefbStatus2 = new String[] {"1","2","8","9"};
             for (int i = 0; i < d_rdogrprefbStatus2.length; i++)
             {
                 if (item.getrefbStatus2().equals(String.valueOf(d_rdogrprefbStatus2[i])))
                 {
                     rb = (RadioButton)rdogrprefbStatus2.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpRefsbtype2 = new String[] {"1","2","8","9"};
             for (int i = 0; i < d_rdogrpRefsbtype2.length; i++)
             {
                 if (item.getRefsbtype2().equals(String.valueOf(d_rdogrpRefsbtype2[i])))
                 {
                     rb = (RadioButton)rdogrpRefsbtype2.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrprefbsex2 = new String[] {"1","2","3","8","9"};
             for (int i = 0; i < d_rdogrprefbsex2.length; i++)
             {
                 if (item.getrefbsex2().equals(String.valueOf(d_rdogrprefbsex2[i])))
                 {
                     rb = (RadioButton)rdogrprefbsex2.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtrefbwgt2.setText(item.getrefbwgt2());
             String[] d_rdogrprefbwgtnot2 = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrprefbwgtnot2.length; i++)
             {
                 if (item.getrefbwgtnot2().equals(String.valueOf(d_rdogrprefbwgtnot2[i])))
                 {
                     rb = (RadioButton)rdogrprefbwgtnot2.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrprefbstim2 = new String[] {"1","2","8","9"};
             for (int i = 0; i < d_rdogrprefbstim2.length; i++)
             {
                 if (item.getrefbstim2().equals(String.valueOf(d_rdogrprefbstim2[i])))
                 {
                     rb = (RadioButton)rdogrprefbstim2.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrprefbplast2 = new String[] {"1","2","8","9"};
             for (int i = 0; i < d_rdogrprefbplast2.length; i++)
             {
                 if (item.getrefbplast2().equals(String.valueOf(d_rdogrprefbplast2[i])))
                 {
                     rb = (RadioButton)rdogrprefbplast2.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrprefappcord2 = new String[] {"1","2","8","9"};
             for (int i = 0; i < d_rdogrprefappcord2.length; i++)
             {
                 if (item.getrefappcord2().equals(String.valueOf(d_rdogrprefappcord2[i])))
                 {
                     rb = (RadioButton)rdogrprefappcord2.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrprefbbfd2 = new String[] {"1","2","8","9","5"};
             for (int i = 0; i < d_rdogrprefbbfd2.length; i++)
             {
                 if (item.getrefbbfd2().equals(String.valueOf(d_rdogrprefbbfd2[i])))
                 {
                     rb = (RadioButton)rdogrprefbbfd2.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrprefbcond2 = new String[] {"1","3","8","9"};
             for (int i = 0; i < d_rdogrprefbcond2.length; i++)
             {
                 if (item.getrefbcond2().equals(String.valueOf(d_rdogrprefbcond2[i])))
                 {
                     rb = (RadioButton)rdogrprefbcond2.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrprefdisoutld2 = new String[] {"1","2","3","4","8","9"};
             for (int i = 0; i < d_rdogrprefdisoutld2.length; i++)
             {
                 if (item.getrefdisoutld2().equals(String.valueOf(d_rdogrprefdisoutld2[i])))
                 {
                     rb = (RadioButton)rdogrprefdisoutld2.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtrefTransPlace2.setText(item.getrefTransPlace2());
             String[] d_rdogrpreftypebirth3 = new String[] {"1","2","3","8","9"};
             for (int i = 0; i < d_rdogrpreftypebirth3.length; i++)
             {
                 if (item.getreftypebirth3().equals(String.valueOf(d_rdogrpreftypebirth3[i])))
                 {
                     rb = (RadioButton)rdogrpreftypebirth3.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             dtprefdelivdate3.setText(item.getrefdelivdate3().toString().length()==0 ? "" : Global.DateConvertDMY(item.getrefdelivdate3()));
             if(item.getrefdelivdate3not().equals("1")) rdorefdelivdate3not1.setChecked(true);
               else if(item.getrefdelivdate3not().equals("2")) rdorefdelivdate3not2.setChecked(true);

               txtrefdelivtime3.setText(item.getrefdelivtime3());
               if(item.getrefdelivtime3not().equals("1")) rdorefdelivtime3not1.setChecked(true);
               else if(item.getrefdelivtime3not().equals("2")) rdorefdelivtime3not2.setChecked(true);

             String[] d_rdogrprefbStatus3 = new String[] {"1","2","8","9"};
             for (int i = 0; i < d_rdogrprefbStatus3.length; i++)
             {
                 if (item.getrefbStatus3().equals(String.valueOf(d_rdogrprefbStatus3[i])))
                 {
                     rb = (RadioButton)rdogrprefbStatus3.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpRefsbtype3 = new String[] {"1","2","8","9"};
             for (int i = 0; i < d_rdogrpRefsbtype3.length; i++)
             {
                 if (item.getRefsbtype3().equals(String.valueOf(d_rdogrpRefsbtype3[i])))
                 {
                     rb = (RadioButton)rdogrpRefsbtype3.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrprefbsex3 = new String[] {"1","2","3","8","9"};
             for (int i = 0; i < d_rdogrprefbsex3.length; i++)
             {
                 if (item.getrefbsex3().equals(String.valueOf(d_rdogrprefbsex3[i])))
                 {
                     rb = (RadioButton)rdogrprefbsex3.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtrefbwgt3.setText(item.getrefbwgt3());
             String[] d_rdogrprefbwgtnot3 = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrprefbwgtnot3.length; i++)
             {
                 if (item.getrefbwgtnot3().equals(String.valueOf(d_rdogrprefbwgtnot3[i])))
                 {
                     rb = (RadioButton)rdogrprefbwgtnot3.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrprefbstim3 = new String[] {"1","2","8","9"};
             for (int i = 0; i < d_rdogrprefbstim3.length; i++)
             {
                 if (item.getrefbstim3().equals(String.valueOf(d_rdogrprefbstim3[i])))
                 {
                     rb = (RadioButton)rdogrprefbstim3.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrprefbplast3 = new String[] {"1","2","8","9"};
             for (int i = 0; i < d_rdogrprefbplast3.length; i++)
             {
                 if (item.getrefbplast3().equals(String.valueOf(d_rdogrprefbplast3[i])))
                 {
                     rb = (RadioButton)rdogrprefbplast3.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrprefappcord3 = new String[] {"1","2","8","9"};
             for (int i = 0; i < d_rdogrprefappcord3.length; i++)
             {
                 if (item.getrefappcord3().equals(String.valueOf(d_rdogrprefappcord3[i])))
                 {
                     rb = (RadioButton)rdogrprefappcord3.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrprefbbfd3 = new String[] {"1","2","8","9","5"};
             for (int i = 0; i < d_rdogrprefbbfd3.length; i++)
             {
                 if (item.getrefbbfd3().equals(String.valueOf(d_rdogrprefbbfd3[i])))
                 {
                     rb = (RadioButton)rdogrprefbbfd3.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrprefbcond3 = new String[] {"1","3","8","9"};
             for (int i = 0; i < d_rdogrprefbcond3.length; i++)
             {
                 if (item.getrefbcond3().equals(String.valueOf(d_rdogrprefbcond3[i])))
                 {
                     rb = (RadioButton)rdogrprefbcond3.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrprefdisoutld3 = new String[] {"1","2","3","4","8","9"};
             for (int i = 0; i < d_rdogrprefdisoutld3.length; i++)
             {
                 if (item.getrefdisoutld3().equals(String.valueOf(d_rdogrprefdisoutld3[i])))
                 {
                     rb = (RadioButton)rdogrprefdisoutld3.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtrefTransPlace3.setText(item.getrefTransPlace3());
             txtrefpph.setText(item.getrefpph());
             String[] d_rdogrprefpphnot = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrprefpphnot.length; i++)
             {
                 if (item.getrefpphnot().equals(String.valueOf(d_rdogrprefpphnot[i])))
                 {
                     rb = (RadioButton)rdogrprefpphnot.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrprefretainplac = new String[] {"1","2","3","4","8","9"};
             for (int i = 0; i < d_rdogrprefretainplac.length; i++)
             {
                 if (item.getrefretainplac().equals(String.valueOf(d_rdogrprefretainplac[i])))
                 {
                     rb = (RadioButton)rdogrprefretainplac.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             dtprefdodld.setText(item.getrefdodld().toString().length()==0 ? "" : Global.DateConvertDMY(item.getrefdodld()));
             if(item.getrefdodldnot().equals("1")) rdorefdodldnot1.setChecked(true);
               else if(item.getrefdodldnot().equals("2")) rdorefdodldnot2.setChecked(true);

             txtreftodld.setText(item.getreftodld());
               if(item.getreftodldnot().equals("1")) rdoreftodldnot1.setChecked(true);
               else if(item.getreftodldnot().equals("2")) rdoreftodldnot2.setChecked(true);

             String[] d_rdogrprefmatcond = new String[] {"1","2","3","4","8","9"};
             for (int i = 0; i < d_rdogrprefmatcond.length; i++)
             {
                 if (item.getrefmatcond().equals(String.valueOf(d_rdogrprefmatcond[i])))
                 {
                     rb = (RadioButton)rdogrprefmatcond.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtrefTransPlaceM.setText(item.getrefTransPlaceM());


               //Status
               String[] d_rdogrpstatus = new String[] {"1","2","3"};
               for (int i = 0; i < d_rdogrpstatus.length; i++)
               {
                   if (item.getStatus().equals(String.valueOf(d_rdogrpstatus[i])))
                   {
                       rb = (RadioButton)rdogrpstatus.getChildAt(i);
                       rb.setChecked(true);
                   }
               }

               String[] d_rdogrpreason = new String[] {"1","2","3","4"};
               for (int i = 0; i < d_rdogrpreason.length; i++)
               {
                   if (item.getReason().equals(String.valueOf(d_rdogrpreason[i])))
                   {
                       rb = (RadioButton)rdogrpreason.getChildAt(i);
                       rb.setChecked(true);
                   }
               }
               txtreasmention.setText(item.getReasmention());

           }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(LD_DataExt.this, e.getMessage());
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


              dtpDate = (EditText)findViewById(R.id.dtprefdoe);
             if (VariableID.equals("btnrefdoe"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtprefdoe);
              }
             else if (VariableID.equals("btnrefgacalc"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtprefgacalc);
              }
             else if (VariableID.equals("btnrefdelivdate1"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtprefdelivdate1);
              }
             else if (VariableID.equals("btnrefdelivdate2"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtprefdelivdate2);
              }
             else if (VariableID.equals("btnrefdelivdate3"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtprefdelivdate3);
              }
             else if (VariableID.equals("btnrefdodld"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtprefdodld);
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


              tpTime = (EditText)findViewById(R.id.txtrefdelivtime1);
             if (VariableID.equals("btnrefdelivtime1"))
              {
                  tpTime = (EditText)findViewById(R.id.txtrefdelivtime1);
              }
             else if (VariableID.equals("btnrefdelivtime2"))
              {
                  tpTime = (EditText)findViewById(R.id.txtrefdelivtime2);
              }
             else if (VariableID.equals("btnrefdelivtime3"))
              {
                  tpTime = (EditText)findViewById(R.id.txtrefdelivtime3);
              }
             else if (VariableID.equals("btnreftodld"))
              {
                  tpTime = (EditText)findViewById(R.id.txtreftodld);
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