
 package org.icddrb.enap;


 //Android Manifest Code
 //<activity android:name=".Acs_Veri" android:label="Acs_Veri" />

 import android.app.Activity;
 import android.app.AlertDialog;
 import android.app.DatePickerDialog;
 import android.app.Dialog;
 import android.app.TimePickerDialog;
 import android.content.Context;
 import android.content.DialogInterface;
 import android.content.Intent;
 import android.location.Location;
 import android.location.LocationListener;
 import android.location.LocationManager;
 import android.net.Uri;
 import android.os.Bundle;
 import android.provider.Settings;
 import android.text.Editable;
 import android.text.TextWatcher;
 import android.view.KeyEvent;
 import android.view.MotionEvent;
 import android.view.View;
 import android.view.WindowManager;
 import android.widget.AdapterView;
 import android.widget.ArrayAdapter;
 import android.widget.Button;
 import android.widget.CheckBox;
 import android.widget.CompoundButton;
 import android.widget.DatePicker;
 import android.widget.EditText;
 import android.widget.ImageButton;
 import android.widget.LinearLayout;
 import android.widget.RadioButton;
 import android.widget.RadioGroup;
 import android.widget.SimpleAdapter;
 import android.widget.Spinner;
 import android.widget.TextView;
 import android.widget.TimePicker;

 import java.util.ArrayList;
 import java.util.Calendar;
 import java.util.HashMap;
 import java.util.List;

 import Common.Connection;
 import Common.Global;
 import Utility.MySharedPreferences;

 public class Acs_Veri1 extends Activity {
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
         LinearLayout seclblSectionI;
         View linelblSectionI;
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
         LinearLayout secParticipantID;
         View lineParticipantID;
         TextView VlblParticipantID;
         EditText txtParticipantID;
         LinearLayout secmatobsv;
         View linematobsv;
         TextView Vlblmatobsv;
         RadioGroup rdogrpmatobsv;
         RadioButton rdomatobsv1;
         RadioButton rdomatobsv2;
         LinearLayout secmatname;
         View linematname;
         TextView Vlblmatname;
         EditText txtmatname;

      RadioGroup rdogrpcrform;
      RadioButton rdocrform1;
      RadioButton rdocrform2;


         LinearLayout secMoAge;
         View lineMoAge;
         TextView VlblMoAge;
         EditText txtMoAge;

      RadioGroup rdogrpMoAgeNot;
      RadioButton rdoMoAgeNot1;
      RadioButton rdoMoAgeNot2;

         LinearLayout secmatbdate;
         View linematbdate;
         TextView Vlblmatbdate;
         EditText dtpmatbdate;

    RadioGroup rdogrpmatbdateNot;
    RadioButton rdomatbdateNot1;
    RadioButton rdomatbdateNot2;


         LinearLayout seclblSectionII;
         View linelblSectionII;
         LinearLayout secgafirstds;
         View linegafirstds;
         TextView Vlblgafirstds;
         Spinner spngafirstds;
         LinearLayout seclblmatcondprem;
         View linelblmatcondprem;
         LinearLayout secmatcondpremA;
         View linematcondpremA;
         TextView VlblmatcondpremA;
         CheckBox chkmatcondpremA;
         LinearLayout secdtdgnmatcondA;
         View linedtdgnmatcondA;
         TextView VlbldtdgnmatcondA;
         EditText dtpdtdgnmatcondA;
         LinearLayout sectmdgnmatcondA;
         View linetmdgnmatcondA;
         TextView VlbltmdgnmatcondA;
         EditText txttmdgnmatcondA;
         LinearLayout secmatcondpremB;
         View linematcondpremB;
         TextView VlblmatcondpremB;
         CheckBox chkmatcondpremB;
         LinearLayout secdtdgnmatcondB;
         View linedtdgnmatcondB;
         TextView VlbldtdgnmatcondB;
         EditText dtpdtdgnmatcondB;
         LinearLayout sectmdgnmatcondB;
         View linetmdgnmatcondB;
         TextView VlbltmdgnmatcondB;
         EditText txttmdgnmatcondB;
         LinearLayout secmatcondpremC;
         View linematcondpremC;
         TextView VlblmatcondpremC;
         CheckBox chkmatcondpremC;
         LinearLayout secdtdgnmatcondC;
         View linedtdgnmatcondC;
         TextView VlbldtdgnmatcondC;
         EditText dtpdtdgnmatcondC;
         LinearLayout sectmdgnmatcondC;
         View linetmdgnmatcondC;
         TextView VlbltmdgnmatcondC;
         EditText txttmdgnmatcondC;
         LinearLayout secmatcondpremD;
         View linematcondpremD;
         TextView VlblmatcondpremD;
         CheckBox chkmatcondpremD;
         LinearLayout secdtdgnmatcondD;
         View linedtdgnmatcondD;
         TextView VlbldtdgnmatcondD;
         EditText dtpdtdgnmatcondD;
         LinearLayout sectmdgnmatcondD;
         View linetmdgnmatcondD;
         TextView VlbltmdgnmatcondD;
         EditText txttmdgnmatcondD;
         LinearLayout secmatcondpremE;
         View linematcondpremE;
         TextView VlblmatcondpremE;
         CheckBox chkmatcondpremE;
         LinearLayout secdtdgnmatcondE;
         View linedtdgnmatcondE;
         TextView VlbldtdgnmatcondE;
         EditText dtpdtdgnmatcondE;
         LinearLayout sectmdgnmatcondE;
         View linetmdgnmatcondE;
         TextView VlbltmdgnmatcondE;
         EditText txttmdgnmatcondE;
         LinearLayout secmatcondpremF;
         View linematcondpremF;
         TextView VlblmatcondpremF;
         CheckBox chkmatcondpremF;
         LinearLayout secmatcondpremOth;
         View linematcondpremOth;
         TextView VlblmatcondpremOth;
         EditText txtmatcondpremOth;
         LinearLayout secdtdgnmatcondF;
         View linedtdgnmatcondF;
         TextView VlbldtdgnmatcondF;
         EditText dtpdtdgnmatcondF;
         LinearLayout sectmdgnmatcondF;
         View linetmdgnmatcondF;
         TextView VlbltmdgnmatcondF;
         EditText txttmdgnmatcondF;
         LinearLayout secmatcondpremG;
         View linematcondpremG;
         TextView VlblmatcondpremG;
         CheckBox chkmatcondpremG;
         LinearLayout secmatcondpremH;
         View linematcondpremH;
         TextView VlblmatcondpremH;
         CheckBox chkmatcondpremH;
         LinearLayout seclblmatinf;
         View linelblmatinf;
         LinearLayout secmatinfA;
         View linematinfA;
         TextView VlblmatinfA;
         CheckBox chkmatinfA;
         LinearLayout secmatinfB;
         View linematinfB;
         TextView VlblmatinfB;
         CheckBox chkmatinfB;
         LinearLayout secmatinfC;
         View linematinfC;
         TextView VlblmatinfC;
         CheckBox chkmatinfC;
         LinearLayout secmatinfD;
         View linematinfD;
         TextView VlblmatinfD;
         CheckBox chkmatinfD;
         LinearLayout secmatinfE;
         View linematinfE;
         TextView VlblmatinfE;
         CheckBox chkmatinfE;
         LinearLayout secmatinfF;
         View linematinfF;
         TextView VlblmatinfF;
         CheckBox chkmatinfF;
         LinearLayout secmatinfG;
         View linematinfG;
         TextView VlblmatinfG;
         CheckBox chkmatinfG;
         LinearLayout secmatinfH;
         View linematinfH;
         TextView VlblmatinfH;
         CheckBox chkmatinfH;
         LinearLayout secmatinfI;
         View linematinfI;
         TextView VlblmatinfI;
         CheckBox chkmatinfI;
         LinearLayout secmatinfJ;
         View linematinfJ;
         TextView VlblmatinfJ;
         CheckBox chkmatinfJ;
         LinearLayout secmatinfOth;
         View linematinfOth;
         TextView VlblmatinfOth;
         EditText txtmatinfOth;
         LinearLayout secdtdgnmatinf;
         View linedtdgnmatinf;
         TextView Vlbldtdgnmatinf;
         EditText dtpdtdgnmatinf;
         LinearLayout sectmdgnmatinf;
         View linetmdgnmatinf;
         TextView Vlbltmdgnmatinf;
         EditText txttmdgnmatinf;
         LinearLayout seclblmatcoinf;
         View linelblmatcoinf;
         LinearLayout secmatcoinfA;
         View linematcoinfA;
         TextView VlblmatcoinfA;
         CheckBox chkmatcoinfA;
         LinearLayout secmatcoinfB;
         View linematcoinfB;
         TextView VlblmatcoinfB;
         CheckBox chkmatcoinfB;
         LinearLayout secmatcoinfC;
         View linematcoinfC;
         TextView VlblmatcoinfC;
         CheckBox chkmatcoinfC;
         LinearLayout secmatcoinfD;
         View linematcoinfD;
         TextView VlblmatcoinfD;
         CheckBox chkmatcoinfD;
         LinearLayout secmatcoinfE;
         View linematcoinfE;
         TextView VlblmatcoinfE;
         CheckBox chkmatcoinfE;
         LinearLayout secmatcoinfF;
         View linematcoinfF;
         TextView VlblmatcoinfF;
         CheckBox chkmatcoinfF;
         LinearLayout secmatcoinfOth;
         View linematcoinfOth;
         TextView VlblmatcoinfOth;
         EditText txtmatcoinfOth;
         LinearLayout secmatcoinftrtmnt;
         View linematcoinftrtmnt;
         TextView Vlblmatcoinftrtmnt;
         RadioGroup rdogrpmatcoinftrtmnt;
         
         RadioButton rdomatcoinftrtmnt1;
         RadioButton rdomatcoinftrtmnt2;
         RadioButton rdomatcoinftrtmnt3;
         RadioButton rdomatcoinftrtmnt4;
         LinearLayout secfetalaus;
         View linefetalaus;
         TextView Vlblfetalaus;
         RadioGroup rdogrpfetalaus;
         
         RadioButton rdofetalaus1;
         RadioButton rdofetalaus2;
         RadioButton rdofetalaus3;
         RadioButton rdofetalaus4;
         RadioButton rdofetalaus5;
         RadioButton rdofetalaus6;
         LinearLayout secfetalausrate;
         View linefetalausrate;
         TextView Vlblfetalausrate;
         EditText txtfetalausrate;
         LinearLayout secfetalausOth;
         View linefetalausOth;
         TextView VlblfetalausOth;
         EditText txtfetalausOth;
         LinearLayout seclblSectionIII;
         View linelblSectionIII;
         LinearLayout secacsadm1;
         View lineacsadm1;
         TextView Vlblacsadm1;

         RadioGroup rdogrpacsadm1;
         RadioButton rdoacsadm11;
         RadioButton rdoacsadm12;
         RadioButton rdoacsadm13;
         RadioButton rdoacsadm14;

         LinearLayout secdtacs1;
         View linedtacs1;
         TextView Vlbldtacs1;
         EditText dtpdtacs1;
    RadioGroup rdogrpdtacs1Not;
    RadioButton rdodtacs1Not1;
    RadioButton rdodtacs1Not2;

         LinearLayout sectmdtacs1;
         View linetmdtacs1;
         TextView Vlbltmdtacs1;
         EditText txttmdtacs1;
      RadioGroup rdogrptmdtacs1Not;
      RadioButton rdotmdtacs1Not1;
      RadioButton rdotmdtacs1Not2;

         LinearLayout secnameacs1;
         View linenameacs1;
         TextView Vlblnameacs1;
         RadioGroup rdogrpnameacs1;
         
         RadioButton rdonameacs11;
         RadioButton rdonameacs12;
         RadioButton rdonameacs13;
         RadioButton rdonameacs14;
         RadioButton rdonameacs15;
         RadioButton rdonameacs16;
         LinearLayout secnameacs1Oth;
         View linenameacs1Oth;
         TextView Vlblnameacs1Oth;
         EditText txtnameacs1Oth;
         LinearLayout secacsdose1;
         View lineacsdose1;
         TextView Vlblacsdose1;
         RadioGroup rdogrpacsdose1;
         
         RadioButton rdoacsdose11;
         RadioButton rdoacsdose12;
         RadioButton rdoacsdose13;
         RadioButton rdoacsdose14;
         RadioButton rdoacsdose15;
         LinearLayout secacsdose1Oth;
         View lineacsdose1Oth;
         TextView Vlblacsdose1Oth;
         EditText txtacsdose1Oth;
         LinearLayout secacsadm2;
         View lineacsadm2;
         TextView Vlblacsadm2;
         RadioGroup rdogrpacsadm2;
         
         RadioButton rdoacsadm21;
         RadioButton rdoacsadm22;
         RadioButton rdoacsadm23;
         RadioButton rdoacsadm24;
         LinearLayout secdtacsm2;
         View linedtacsm2;
         TextView Vlbldtacsm2;
         EditText dtpdtacsm2;
     RadioGroup rdogrpdtacsm2Not;
     RadioButton rdodtacsm2Not1;
     RadioButton rdodtacsm2Not2;

         LinearLayout sectmacsm2;
         View linetmacsm2;
         TextView Vlbltmacsm2;
         EditText txttmacsm2;
     RadioGroup rdogrptmacsm2Not;
     RadioButton rdotmacsm2Not1;
     RadioButton rdotmacsm2Not2;

         LinearLayout secacsdose2;
         View lineacsdose2;
         TextView Vlblacsdose2;
         RadioGroup rdogrpacsdose2;
         
         RadioButton rdoacsdose21;
         RadioButton rdoacsdose22;
         RadioButton rdoacsdose23;
         RadioButton rdoacsdose24;
         RadioButton rdoacsdose25;
         LinearLayout secacsdose2Oth;
         View lineacsdose2Oth;
         TextView Vlblacsdose2Oth;
         EditText txtacsdose2Oth;
         LinearLayout secacsadm3;
         View lineacsadm3;
         TextView Vlblacsadm3;
         RadioGroup rdogrpacsadm3;
         RadioButton rdoacsadm31;
         RadioButton rdoacsadm32;
         RadioButton rdoacsadm33;
         RadioButton rdoacsadm34;
         LinearLayout secdtacsadm3;
         View linedtacsadm3;
         TextView Vlbldtacsadm3;
         EditText dtpdtacsadm3;
     RadioGroup rdogrpdtacsadm3Not;
     RadioButton rdodtacsadm3Not1;
     RadioButton rdodtacsadm3Not2;

         LinearLayout sectmacsadm3;
         View linetmacsadm3;
         TextView Vlbltmacsadm3;
         EditText txttmacsadm3;
     RadioGroup rdogrptmacsadm3Not;
     RadioButton rdotmacsadm3Not1;
     RadioButton rdotmacsadm3Not2;

         LinearLayout secacsdose3;
         View lineacsdose3;
         TextView Vlblacsdose3;
         RadioGroup rdogrpacsdose3;
         
         RadioButton rdoacsdose31;
         RadioButton rdoacsdose32;
         RadioButton rdoacsdose33;
         RadioButton rdoacsdose34;
         RadioButton rdoacsdose35;
         LinearLayout secacsdose3Oth;
         View lineacsdose3Oth;
         TextView Vlblacsdose3Oth;
         EditText txtacsdose3Oth;
         LinearLayout secacsadm4;
         View lineacsadm4;
         TextView Vlblacsadm4;
         RadioGroup rdogrpacsadm4;
         RadioButton rdoacsadm41;
         RadioButton rdoacsadm42;
         RadioButton rdoacsadm43;
         RadioButton rdoacsadm44;
         LinearLayout secdtacsadm4;
         View linedtacsadm4;
         TextView Vlbldtacsadm4;
         EditText dtpdtacsadm4;
     RadioGroup rdogrpdtacsadm4Not;
     RadioButton rdodtacsadm4Not1;
     RadioButton rdodtacsadm4Not2;

         LinearLayout sectmacsadm4;
         View linetmacsadm4;
         TextView Vlbltmacsadm4;
         EditText txttmacsadm4;
     RadioGroup rdogrptmacsadm4Not;
     RadioButton rdotmacsadm4Not1;
     RadioButton rdotmacsadm4Not2;


         LinearLayout secacsdose4;
         View lineacsdose4;
         TextView Vlblacsdose4;
         RadioGroup rdogrpacsdose4;
         
         RadioButton rdoacsdose41;
         RadioButton rdoacsdose42;
         RadioButton rdoacsdose43;
         RadioButton rdoacsdose44;
         RadioButton rdoacsdose45;
         LinearLayout secacsdose4Oth;
         View lineacsdose4Oth;
         TextView Vlblacsdose4Oth;
         EditText txtacsdose4Oth;
         LinearLayout secacsfurther;
         View lineacsfurther;
         TextView Vlblacsfurther;
         RadioGroup rdogrpacsfurther;
         
         RadioButton rdoacsfurther1;
         RadioButton rdoacsfurther2;
         RadioButton rdoacsfurther3;
         RadioButton rdoacsfurther4;
         LinearLayout secdtacsfurther;
         View linedtacsfurther;
         TextView Vlbldtacsfurther;
         EditText dtpdtacsfurther;
     RadioGroup rdogrpdtacsfurtherNot;
     RadioButton rdodtacsfurtherNot1;
     RadioButton rdodtacsfurtherNot2;


         LinearLayout sectmacsfurther;
         View linetmacsfurther;
         TextView Vlbltmacsfurther;
         EditText txttmacsfurther;
     RadioGroup rdogrptmacsfurtherNot;
     RadioButton rdotmacsfurtherNot1;
     RadioButton rdotmacsfurtherNot2;

         LinearLayout secacsdosefurther;
         View lineacsdosefurther;
         TextView Vlblacsdosefurther;
         RadioGroup rdogrpacsdosefurther;
         
         RadioButton rdoacsdosefurther1;
         RadioButton rdoacsdosefurther2;
         RadioButton rdoacsdosefurther3;
         RadioButton rdoacsdosefurther4;
         RadioButton rdoacsdosefurther5;
         LinearLayout secacsdosefurtherOth;
         View lineacsdosefurtherOth;
         TextView VlblacsdosefurtherOth;
         EditText txtacsdosefurtherOth;
         LinearLayout seclblSectionIV;
         View linelblSectionIV;
         LinearLayout secga;
         View linega;
         TextView Vlblga;
         EditText txtga;
         LinearLayout secgar;
         View linegar;
         TextView Vlblgar;
         RadioGroup rdogrpgar;
         
         RadioButton rdogar1;
         RadioButton rdogar2;
         LinearLayout secgamethod;
         View linegamethod;
         TextView Vlblgamethod;
         EditText txtgamethod;
         LinearLayout secgamethodr;
         View linegamethodr;
         TextView Vlblgamethodr;
         RadioGroup rdogrpgamethodr;
         
         RadioButton rdogamethodr1;
         RadioButton rdogamethodr2;
         LinearLayout secbwt;
         View linebwt;
         TextView Vlblbwt;
         EditText txtbwt;
         LinearLayout secbwtr;
         View linebwtr;
         TextView Vlblbwtr;
         RadioGroup rdogrpbwtr;
         
         RadioButton rdobwtr1;
         RadioButton rdobwtr2;
         LinearLayout secmatcond;
         View linematcond;
         TextView Vlblmatcond;
         RadioGroup rdogrpmatcond;
         
         RadioButton rdomatcond1;
         RadioButton rdomatcond2;
         RadioButton rdomatcond3;
         RadioButton rdomatcond4;
         LinearLayout secbadm;
         View linebadm;
         TextView Vlblbadm;
         RadioGroup rdogrpbadm;
         
         RadioButton rdobadm1;
         RadioButton rdobadm2;
         RadioButton rdobadm3;
         RadioButton rdobadm4;
         RadioButton rdobadm5;
         RadioButton rdobadm6;
         LinearLayout secbcond;
         View linebcond;
         TextView Vlblbcond;
         RadioGroup rdogrpbcond;
         
         RadioButton rdobcond1;
         RadioButton rdobcond2;
         RadioButton rdobcond3;
         RadioButton rdobcond4;
     RadioButton rdobcond5;
     RadioButton rdobcond6;
     RadioButton rdobcond7;

         LinearLayout secstillbirthSp;
         View linestillbirthSp;
         TextView VlblstillbirthSp;
         RadioGroup rdogrpstillbirthSp;
         
         RadioButton rdostillbirthSp1;
         RadioButton rdostillbirthSp2;
         RadioButton rdostillbirthSp3;
         LinearLayout secdod;
         View linedod;
         TextView Vlbldod;
         EditText dtpdod;
     RadioGroup rdogrpdodNot;
     RadioButton rdododNot1;
     RadioButton rdododNot2;

         LinearLayout secdeathtime;
         View linedeathtime;
         TextView Vlbldeathtime;
         EditText txtdeathtime;
     RadioGroup rdogrpdeathtimeNot;
     RadioButton rdodeathtimeNot1;
     RadioButton rdodeathtimeNot2;

         LinearLayout seclblStatus;
         View linelblStatus;
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


      LinearLayout secdtdgnmatcondANot;
      RadioGroup rdogrpdtdgnmatcondANot;
      RadioButton rdodtdgnmatcondANot1;
      RadioButton rdodtdgnmatcondANot2;

      LinearLayout sectmdgnmatcondANot;
      RadioGroup rdogrptmdgnmatcondANot;
      RadioButton rdotmdgnmatcondANot1;
      RadioButton rdotmdgnmatcondANot2;


      LinearLayout secdtdgnmatcondBNot;
      RadioGroup rdogrpdtdgnmatcondBNot;
      RadioButton rdodtdgnmatcondBNot1;
      RadioButton rdodtdgnmatcondBNot2;

      LinearLayout sectmdgnmatcondBNot;
      RadioGroup rdogrptmdgnmatcondBNot;
      RadioButton rdotmdgnmatcondBNot1;
      RadioButton rdotmdgnmatcondBNot2;

     LinearLayout secdtdgnmatcondCNot;
     RadioGroup rdogrpdtdgnmatcondCNot;
     RadioButton rdodtdgnmatcondCNot1;
     RadioButton rdodtdgnmatcondCNot2;

     LinearLayout sectmdgnmatcondCNot;
     RadioGroup rdogrptmdgnmatcondCNot;
     RadioButton rdotmdgnmatcondCNot1;
     RadioButton rdotmdgnmatcondCNot2;

     LinearLayout secdtdgnmatcondDNot;
     RadioGroup rdogrpdtdgnmatcondDNot;
     RadioButton rdodtdgnmatcondDNot1;
     RadioButton rdodtdgnmatcondDNot2;
     LinearLayout sectmdgnmatcondDNot;
     RadioGroup rdogrptmdgnmatcondDNot;
     RadioButton rdotmdgnmatcondDNot1;
     RadioButton rdotmdgnmatcondDNot2;


      LinearLayout secdtdgnmatinfNot;
      RadioGroup rdogrpdtdgnmatinfNot;
      RadioButton rdodtdgnmatinfNot1;
      RadioButton rdodtdgnmatinfNot2;

      LinearLayout sectmdgnmatinfNot;
      RadioGroup rdogrptmdgnmatinfNot;
      RadioButton rdotmdgnmatinfNot1;
      RadioButton rdotmdgnmatinfNot2;

      LinearLayout secdtdgnmatcondFNot;
      RadioGroup rdogrpdtdgnmatcondFNot;
      RadioButton rdodtdgnmatcondFNot1;
      RadioButton rdodtdgnmatcondFNot2;

      LinearLayout sectmdgnmatcondFNot;
      RadioGroup rdogrptmdgnmatcondFNot;
      RadioButton rdotmdgnmatcondFNot1;
      RadioButton rdotmdgnmatcondFNot2;


     LinearLayout secdtacs1Not;
     LinearLayout sectmdtacs1Not;
     LinearLayout secdtacsm2Not;
     LinearLayout sectmacsm2Not;
     LinearLayout secdtacsadm3Not;
     LinearLayout sectmacsadm3Not;
     LinearLayout secdtacsadm4Not;
     LinearLayout sectmacsadm4Not;
     LinearLayout secdtacsfurtherNot;
     LinearLayout sectmacsfurtherNot;
     //LinearLayout secbwtr;
     LinearLayout secdodNot;
     LinearLayout secdeathtimeNot;

     LinearLayout secMoAgeNot;
     LinearLayout secmatbdateNot;

    static String TableName;

    static String STARTTIME = "";
    static String DEVICEID  = "";
    static String ENTRYUSER = "";
    MySharedPreferences sp;

    Bundle IDbundle;
    static String COUNTRYCODE = "";
    static String FACICODE = "";
    static String DATAID = "";
      static String AGE = "";
      static String NAME = "";

 public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
   try
     {
         setContentView(R.layout.acs_veri1);
         getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

         C = new Connection(this);
         g = Global.getInstance();

         STARTTIME = g.CurrentTime24();
         DEVICEID  = sp.getValue(this, "deviceid");
         ENTRYUSER = sp.getValue(this, "userid");

         IDbundle = getIntent().getExtras();
         COUNTRYCODE = IDbundle.getString("CountryCode");
         FACICODE = IDbundle.getString("FaciCode");
         DATAID = IDbundle.getString("DataID");
          //AGE = IDbundle.getString("agey");
          NAME = IDbundle.getString("name");

         TableName = "Acs_Veri";

         //turnGPSOn();

         //GPS Location
         //FindLocation();
         // Double.toString(currentLatitude);
         // Double.toString(currentLongitude);
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(Acs_Veri1.this);
                 adb.setTitle("Close");
                 adb.setMessage("Do you want to close this form[Yes/No]?");
                 adb.setNegativeButton("No", null);
                 adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                     public void onClick(DialogInterface dialog, int which) {
                         finish();
                     }});
                 adb.show();
             }});

         secMoAgeNot=(LinearLayout)findViewById(R.id.secMoAgeNot) ;
         secmatbdateNot=(LinearLayout)findViewById(R.id.secmatbdateNot) ;

          secdtacs1Not=(LinearLayout)findViewById(R.id.secdtacs1Not) ;
          sectmdtacs1Not=(LinearLayout)findViewById(R.id.sectmdtacs1Not) ;
          secdtacsm2Not=(LinearLayout)findViewById(R.id.secdtacsm2Not) ;
          sectmacsm2Not=(LinearLayout)findViewById(R.id.sectmacsm2Not) ;
          secdtacsadm3Not=(LinearLayout)findViewById(R.id.secdtacsadm3Not) ;
          sectmacsadm3Not=(LinearLayout)findViewById(R.id.sectmacsadm3Not) ;
          secdtacsadm4Not=(LinearLayout)findViewById(R.id.secdtacsadm4Not) ;
          sectmacsadm4Not=(LinearLayout)findViewById(R.id.sectmacsadm4Not) ;
          secdtacsfurtherNot=(LinearLayout)findViewById(R.id.secdtacsfurtherNot) ;
          sectmacsfurtherNot=(LinearLayout)findViewById(R.id.sectmacsfurtherNot) ;
          //secbwtr=(LinearLayout)findViewById(R.id.secbwtr) ;
          secdodNot=(LinearLayout)findViewById(R.id.secdodNot) ;
          secdeathtimeNot=(LinearLayout)findViewById(R.id.secdeathtimeNot) ;


          secdtdgnmatcondFNot=(LinearLayout)findViewById(R.id.secdtdgnmatcondFNot) ;
          rdogrpdtdgnmatcondFNot=(RadioGroup)findViewById(R.id.rdogrpdtdgnmatcondFNot) ;
          rdodtdgnmatcondFNot1=(RadioButton)findViewById(R.id.rdodtdgnmatcondFNot1) ;
          rdodtdgnmatcondFNot2=(RadioButton)findViewById(R.id.rdodtdgnmatcondFNot2) ;

          sectmdgnmatcondFNot=(LinearLayout)findViewById(R.id.sectmdgnmatcondFNot) ;
          rdogrptmdgnmatcondFNot=(RadioGroup)findViewById(R.id.rdogrptmdgnmatcondFNot) ;
          rdotmdgnmatcondFNot1=(RadioButton)findViewById(R.id.rdotmdgnmatcondFNot1) ;
          rdotmdgnmatcondFNot2=(RadioButton)findViewById(R.id.rdotmdgnmatcondFNot2) ;

          secdtdgnmatinfNot=(LinearLayout)findViewById(R.id.secdtdgnmatinfNot) ;
          rdogrpdtdgnmatinfNot=(RadioGroup)findViewById(R.id.rdogrpdtdgnmatinfNot) ;
          rdodtdgnmatinfNot1=(RadioButton)findViewById(R.id.rdodtdgnmatinfNot1) ;
          rdodtdgnmatinfNot2=(RadioButton)findViewById(R.id.rdodtdgnmatinfNot2) ;

          sectmdgnmatinfNot=(LinearLayout)findViewById(R.id.sectmdgnmatinfNot) ;
          rdogrptmdgnmatinfNot=(RadioGroup)findViewById(R.id.rdogrptmdgnmatinfNot) ;
          rdotmdgnmatinfNot1=(RadioButton)findViewById(R.id.rdotmdgnmatinfNot1) ;
          rdotmdgnmatinfNot2=(RadioButton)findViewById(R.id.rdotmdgnmatinfNot2) ;


         secdtdgnmatcondDNot=(LinearLayout)findViewById(R.id.secdtdgnmatcondDNot) ;
         rdogrpdtdgnmatcondDNot=(RadioGroup)findViewById(R.id.rdogrpdtdgnmatcondDNot) ;
         rdodtdgnmatcondDNot1=(RadioButton)findViewById(R.id.rdodtdgnmatcondDNot1) ;
         rdodtdgnmatcondDNot2=(RadioButton)findViewById(R.id.rdodtdgnmatcondDNot2) ;
         sectmdgnmatcondDNot=(LinearLayout)findViewById(R.id.sectmdgnmatcondDNot) ;
         rdogrptmdgnmatcondDNot=(RadioGroup)findViewById(R.id.rdogrptmdgnmatcondDNot) ;
         rdotmdgnmatcondDNot1=(RadioButton)findViewById(R.id.rdotmdgnmatcondDNot1) ;
         rdotmdgnmatcondDNot2=(RadioButton)findViewById(R.id.rdotmdgnmatcondDNot2) ;


         secdtdgnmatcondCNot=(LinearLayout)findViewById(R.id.secdtpdtdgnmatcondCNot) ;
         rdogrpdtdgnmatcondCNot=(RadioGroup)findViewById(R.id.rdogrpdtdgnmatcondCNot) ;
         rdodtdgnmatcondCNot1=(RadioButton)findViewById(R.id.rdodtdgnmatcondCNot1) ;
         rdodtdgnmatcondCNot2=(RadioButton)findViewById(R.id.rdodtdgnmatcondCNot2) ;

         sectmdgnmatcondCNot=(LinearLayout)findViewById(R.id.sectmdgnmatcondCNot) ;
         rdogrptmdgnmatcondCNot=(RadioGroup)findViewById(R.id.rdogrptmdgnmatcondCNot) ;
         rdotmdgnmatcondCNot1=(RadioButton)findViewById(R.id.rdotmdgnmatcondCNot1) ;
         rdotmdgnmatcondCNot2=(RadioButton)findViewById(R.id.rdotmdgnmatcondCNot2) ;


          secdtdgnmatcondANot=(LinearLayout)findViewById(R.id.secdtdgnmatcondANot) ;
          sectmdgnmatcondANot=(LinearLayout)findViewById(R.id.sectmdgnmatcondANot) ;

          rdogrpdtdgnmatcondANot=(RadioGroup)findViewById(R.id.rdogrpdtdgnmatcondANot) ;
          rdodtdgnmatcondANot1=(RadioButton)findViewById(R.id.rdodtdgnmatcondANot1) ;
          rdodtdgnmatcondANot2=(RadioButton)findViewById(R.id.rdodtdgnmatcondANot2) ;
          rdogrptmdgnmatcondANot=(RadioGroup)findViewById(R.id.rdogrptmdgnmatcondANot) ;
          rdotmdgnmatcondANot1=(RadioButton)findViewById(R.id.rdotmdgnmatcondANot1) ;
          rdotmdgnmatcondANot2=(RadioButton)findViewById(R.id.rdotmdgnmatcondANot2) ;

          secdtdgnmatcondBNot=(LinearLayout)findViewById(R.id.secdtdgnmatcondBNot) ;
          rdogrpdtdgnmatcondBNot=(RadioGroup)findViewById(R.id.rdogrpdtdgnmatcondBNot) ;
          rdodtdgnmatcondBNot1=(RadioButton)findViewById(R.id.rdodtdgnmatcondBNot1) ;
          rdodtdgnmatcondBNot2=(RadioButton)findViewById(R.id.rdodtdgnmatcondBNot2) ;

          sectmdgnmatcondBNot=(LinearLayout)findViewById(R.id.sectmdgnmatcondBNot) ;
          rdogrptmdgnmatcondBNot=(RadioGroup)findViewById(R.id.rdogrptmdgnmatcondBNot) ;
          rdotmdgnmatcondBNot1=(RadioButton)findViewById(R.id.rdotmdgnmatcondBNot1) ;
          rdotmdgnmatcondBNot2=(RadioButton)findViewById(R.id.rdotmdgnmatcondBNot2) ;

         seclblSectionI=(LinearLayout)findViewById(R.id.seclblSectionI);
         linelblSectionI=(View)findViewById(R.id.linelblSectionI);
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
         secParticipantID=(LinearLayout)findViewById(R.id.secParticipantID);
         lineParticipantID=(View)findViewById(R.id.lineParticipantID);
         VlblParticipantID=(TextView) findViewById(R.id.VlblParticipantID);
         txtParticipantID=(EditText) findViewById(R.id.txtParticipantID);
         secmatobsv=(LinearLayout)findViewById(R.id.secmatobsv);
         linematobsv=(View)findViewById(R.id.linematobsv);
         Vlblmatobsv = (TextView) findViewById(R.id.Vlblmatobsv);
         rdogrpmatobsv = (RadioGroup) findViewById(R.id.rdogrpmatobsv);

         rdomatobsv1 = (RadioButton) findViewById(R.id.rdomatobsv1);
         rdomatobsv2 = (RadioButton) findViewById(R.id.rdomatobsv2);
         secmatname=(LinearLayout)findViewById(R.id.secmatname);
         linematname=(View)findViewById(R.id.linematname);
         Vlblmatname=(TextView) findViewById(R.id.Vlblmatname);
         txtmatname=(EditText) findViewById(R.id.txtmatname);
          txtmatname.setText(NAME);

          rdogrpcrform=(RadioGroup)findViewById(R.id.rdogrpcrform) ;
          rdocrform1=(RadioButton)findViewById(R.id.rdocrform1) ;
          rdocrform2=(RadioButton)findViewById(R.id.rdocrform2) ;

         secMoAge=(LinearLayout)findViewById(R.id.secMoAge);
         lineMoAge=(View)findViewById(R.id.lineMoAge);
         VlblMoAge=(TextView) findViewById(R.id.VlblMoAge);
         txtMoAge=(EditText) findViewById(R.id.txtMoAge);
          txtMoAge.setText(AGE);

          rdogrpMoAgeNot=(RadioGroup)findViewById(R.id.rdogrpMoAgeNot) ;
          rdoMoAgeNot1=(RadioButton)findViewById(R.id.rdoMoAgeNot1) ;
          rdoMoAgeNot2=(RadioButton)findViewById(R.id.rdoMoAgeNot2) ;

         secmatbdate=(LinearLayout)findViewById(R.id.secmatbdate);
         linematbdate=(View)findViewById(R.id.linematbdate);
         Vlblmatbdate=(TextView) findViewById(R.id.Vlblmatbdate);
         dtpmatbdate=(EditText) findViewById(R.id.dtpmatbdate);

        rdogrpmatbdateNot=(RadioGroup)findViewById(R.id.rdogrpmatbdateNot) ;
        rdomatbdateNot1=(RadioButton)findViewById(R.id.rdomatbdateNot1) ;
        rdomatbdateNot2=(RadioButton)findViewById(R.id.rdomatbdateNot2) ;

         seclblSectionII=(LinearLayout)findViewById(R.id.seclblSectionII);
         linelblSectionII=(View)findViewById(R.id.linelblSectionII);
         secgafirstds=(LinearLayout)findViewById(R.id.secgafirstds);
         linegafirstds=(View)findViewById(R.id.linegafirstds);
         Vlblgafirstds=(TextView) findViewById(R.id.Vlblgafirstds);
         spngafirstds=(Spinner) findViewById(R.id.spngafirstds);
         List<String> listgafirstds = new ArrayList<String>();

         listgafirstds.add("");
         listgafirstds.add("1-≤24 completed week");
         listgafirstds.add("2-From 24 ≤ 34 completed week");
         listgafirstds.add("3->34 completed weeks");
         listgafirstds.add("8-Not readable");
         listgafirstds.add("9-Not recorded");
         ArrayAdapter<String> adptrgafirstds= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listgafirstds);
         spngafirstds.setAdapter(adptrgafirstds);

         seclblmatcondprem=(LinearLayout)findViewById(R.id.seclblmatcondprem);
         linelblmatcondprem=(View)findViewById(R.id.linelblmatcondprem);
         secmatcondpremA=(LinearLayout)findViewById(R.id.secmatcondpremA);
         linematcondpremA=(View)findViewById(R.id.linematcondpremA);
         VlblmatcondpremA=(TextView) findViewById(R.id.VlblmatcondpremA);
         chkmatcondpremA=(CheckBox) findViewById(R.id.chkmatcondpremA);
         chkmatcondpremA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if (!isChecked) {
                    secdtdgnmatcondA.setVisibility(View.GONE);
                    linedtdgnmatcondA.setVisibility(View.GONE);
                    dtpdtdgnmatcondA.setText("");
                    secdtdgnmatcondANot.setVisibility(View.GONE);
                    rdogrpdtdgnmatcondANot.clearCheck();

                      sectmdgnmatcondANot.setVisibility(View.GONE);
                      rdogrptmdgnmatcondANot.clearCheck();
                    sectmdgnmatcondA.setVisibility(View.GONE);
                    linetmdgnmatcondA.setVisibility(View.GONE);
                    txttmdgnmatcondA.setText("");
                 }
                 else
                 {
                    secdtdgnmatcondA.setVisibility(View.VISIBLE);
                    linedtdgnmatcondA.setVisibility(View.VISIBLE);
                    sectmdgnmatcondA.setVisibility(View.VISIBLE);
                    linetmdgnmatcondA.setVisibility(View.VISIBLE);
                      secdtdgnmatcondANot.setVisibility(View.VISIBLE);
                      sectmdgnmatcondANot.setVisibility(View.VISIBLE);

                      chkmatcondpremE.setChecked(false);
                      chkmatcondpremG.setChecked(false);
                      chkmatcondpremH.setChecked(false);
                 }
                 }
         });
         secdtdgnmatcondA=(LinearLayout)findViewById(R.id.secdtdgnmatcondA);
         linedtdgnmatcondA=(View)findViewById(R.id.linedtdgnmatcondA);
         VlbldtdgnmatcondA=(TextView) findViewById(R.id.VlbldtdgnmatcondA);
         dtpdtdgnmatcondA=(EditText) findViewById(R.id.dtpdtdgnmatcondA);
         sectmdgnmatcondA=(LinearLayout)findViewById(R.id.sectmdgnmatcondA);
         linetmdgnmatcondA=(View)findViewById(R.id.linetmdgnmatcondA);
         VlbltmdgnmatcondA=(TextView) findViewById(R.id.VlbltmdgnmatcondA);
         txttmdgnmatcondA=(EditText) findViewById(R.id.txttmdgnmatcondA);
         secmatcondpremB=(LinearLayout)findViewById(R.id.secmatcondpremB);
         linematcondpremB=(View)findViewById(R.id.linematcondpremB);
         VlblmatcondpremB=(TextView) findViewById(R.id.VlblmatcondpremB);
         chkmatcondpremB=(CheckBox) findViewById(R.id.chkmatcondpremB);
         chkmatcondpremB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if (!isChecked) {
                    secdtdgnmatcondB.setVisibility(View.GONE);
                    linedtdgnmatcondB.setVisibility(View.GONE);
                    dtpdtdgnmatcondB.setText("");
                      secdtdgnmatcondBNot.setVisibility(View.GONE);
                      rdogrpdtdgnmatcondBNot.clearCheck();
                    sectmdgnmatcondB.setVisibility(View.GONE);
                    linetmdgnmatcondB.setVisibility(View.GONE);
                    txttmdgnmatcondB.setText("");
                      sectmdgnmatcondBNot.setVisibility(View.GONE);
                      rdogrptmdgnmatcondBNot.clearCheck();
                 }
                 else
                 {
                    secdtdgnmatcondB.setVisibility(View.VISIBLE);
                    linedtdgnmatcondB.setVisibility(View.VISIBLE);
                      secdtdgnmatcondBNot.setVisibility(View.VISIBLE);
                    sectmdgnmatcondB.setVisibility(View.VISIBLE);
                    linetmdgnmatcondB.setVisibility(View.VISIBLE);
                      sectmdgnmatcondBNot.setVisibility(View.VISIBLE);
                      chkmatcondpremE.setChecked(false);
                      chkmatcondpremG.setChecked(false);
                      chkmatcondpremH.setChecked(false);
                 }
                 }
         });
         secdtdgnmatcondB=(LinearLayout)findViewById(R.id.secdtdgnmatcondB);
         linedtdgnmatcondB=(View)findViewById(R.id.linedtdgnmatcondB);
         VlbldtdgnmatcondB=(TextView) findViewById(R.id.VlbldtdgnmatcondB);
         dtpdtdgnmatcondB=(EditText) findViewById(R.id.dtpdtdgnmatcondB);
         sectmdgnmatcondB=(LinearLayout)findViewById(R.id.sectmdgnmatcondB);
         linetmdgnmatcondB=(View)findViewById(R.id.linetmdgnmatcondB);
         VlbltmdgnmatcondB=(TextView) findViewById(R.id.VlbltmdgnmatcondB);
         txttmdgnmatcondB=(EditText) findViewById(R.id.txttmdgnmatcondB);
         secmatcondpremC=(LinearLayout)findViewById(R.id.secmatcondpremC);
         linematcondpremC=(View)findViewById(R.id.linematcondpremC);
         VlblmatcondpremC=(TextView) findViewById(R.id.VlblmatcondpremC);
         chkmatcondpremC=(CheckBox) findViewById(R.id.chkmatcondpremC);
         chkmatcondpremC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if (!isChecked) {
                    secdtdgnmatcondC.setVisibility(View.GONE);
                    linedtdgnmatcondC.setVisibility(View.GONE);
                    dtpdtdgnmatcondC.setText("");
                     secdtdgnmatcondCNot.setVisibility(View.GONE);
                     rdogrpdtdgnmatcondCNot.clearCheck();
                    sectmdgnmatcondC.setVisibility(View.GONE);
                    linetmdgnmatcondC.setVisibility(View.GONE);
                    txttmdgnmatcondC.setText("");
                     sectmdgnmatcondCNot.setVisibility(View.GONE);
                      rdogrptmdgnmatcondCNot.clearCheck();
                 }
                 else
                 {
                    secdtdgnmatcondC.setVisibility(View.VISIBLE);
                    linedtdgnmatcondC.setVisibility(View.VISIBLE);
                    sectmdgnmatcondC.setVisibility(View.VISIBLE);
                    linetmdgnmatcondC.setVisibility(View.VISIBLE);
                     secdtdgnmatcondCNot.setVisibility(View.VISIBLE);
                     sectmdgnmatcondCNot.setVisibility(View.VISIBLE);
                      chkmatcondpremE.setChecked(false);
                      chkmatcondpremG.setChecked(false);
                      chkmatcondpremH.setChecked(false);
                 }
                 }
         });
         secdtdgnmatcondC=(LinearLayout)findViewById(R.id.secdtdgnmatcondC);
         linedtdgnmatcondC=(View)findViewById(R.id.linedtdgnmatcondC);
         VlbldtdgnmatcondC=(TextView) findViewById(R.id.VlbldtdgnmatcondC);
         dtpdtdgnmatcondC=(EditText) findViewById(R.id.dtpdtdgnmatcondC);
         sectmdgnmatcondC=(LinearLayout)findViewById(R.id.sectmdgnmatcondC);
         linetmdgnmatcondC=(View)findViewById(R.id.linetmdgnmatcondC);
         VlbltmdgnmatcondC=(TextView) findViewById(R.id.VlbltmdgnmatcondC);
         txttmdgnmatcondC=(EditText) findViewById(R.id.txttmdgnmatcondC);
         secmatcondpremD=(LinearLayout)findViewById(R.id.secmatcondpremD);
         linematcondpremD=(View)findViewById(R.id.linematcondpremD);
         VlblmatcondpremD=(TextView) findViewById(R.id.VlblmatcondpremD);
         chkmatcondpremD=(CheckBox) findViewById(R.id.chkmatcondpremD);
         chkmatcondpremD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if (!isChecked) {
                    secdtdgnmatcondD.setVisibility(View.GONE);
                    linedtdgnmatcondD.setVisibility(View.GONE);
                    dtpdtdgnmatcondD.setText("");
                     secdtdgnmatcondDNot.setVisibility(View.GONE);
                     rdogrpdtdgnmatcondDNot.clearCheck();
                    sectmdgnmatcondD.setVisibility(View.GONE);
                    linetmdgnmatcondD.setVisibility(View.GONE);
                    txttmdgnmatcondD.setText("");
                     sectmdgnmatcondDNot.setVisibility(View.GONE);
                      rdogrptmdgnmatcondDNot.clearCheck();
                 }
                 else
                 {
                    secdtdgnmatcondD.setVisibility(View.VISIBLE);
                    linedtdgnmatcondD.setVisibility(View.VISIBLE);
                    sectmdgnmatcondD.setVisibility(View.VISIBLE);
                    linetmdgnmatcondD.setVisibility(View.VISIBLE);
                     secdtdgnmatcondDNot.setVisibility(View.VISIBLE);
                     sectmdgnmatcondDNot.setVisibility(View.VISIBLE);
                      chkmatcondpremE.setChecked(false);
                      chkmatcondpremG.setChecked(false);
                      chkmatcondpremH.setChecked(false);
                 }
                 }
         });
         secdtdgnmatcondD=(LinearLayout)findViewById(R.id.secdtdgnmatcondD);
         linedtdgnmatcondD=(View)findViewById(R.id.linedtdgnmatcondD);
         VlbldtdgnmatcondD=(TextView) findViewById(R.id.VlbldtdgnmatcondD);
         dtpdtdgnmatcondD=(EditText) findViewById(R.id.dtpdtdgnmatcondD);
         sectmdgnmatcondD=(LinearLayout)findViewById(R.id.sectmdgnmatcondD);
         linetmdgnmatcondD=(View)findViewById(R.id.linetmdgnmatcondD);
         VlbltmdgnmatcondD=(TextView) findViewById(R.id.VlbltmdgnmatcondD);
         txttmdgnmatcondD=(EditText) findViewById(R.id.txttmdgnmatcondD);
         secmatcondpremE=(LinearLayout)findViewById(R.id.secmatcondpremE);
         linematcondpremE=(View)findViewById(R.id.linematcondpremE);
         VlblmatcondpremE=(TextView) findViewById(R.id.VlblmatcondpremE);
         chkmatcondpremE=(CheckBox) findViewById(R.id.chkmatcondpremE);
         chkmatcondpremE.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if (!isChecked) {
                    secdtdgnmatcondE.setVisibility(View.GONE);
                    linedtdgnmatcondE.setVisibility(View.GONE);
                    dtpdtdgnmatcondE.setText("");
                    sectmdgnmatcondE.setVisibility(View.GONE);
                    linetmdgnmatcondE.setVisibility(View.GONE);
                    txttmdgnmatcondE.setText("");
                 }
                 else
                 {
                      secdtdgnmatcondE.setVisibility(View.GONE);
                      linedtdgnmatcondE.setVisibility(View.GONE);
                      dtpdtdgnmatcondE.setText("");
                      sectmdgnmatcondE.setVisibility(View.GONE);
                      linetmdgnmatcondE.setVisibility(View.GONE);
                      txttmdgnmatcondE.setText("");

                      chkmatcondpremA.setChecked(false);
                      chkmatcondpremB.setChecked(false);
                      chkmatcondpremC.setChecked(false);
                      chkmatcondpremD.setChecked(false);
                      chkmatcondpremF.setChecked(false);
                      chkmatcondpremG.setChecked(false);
                      chkmatcondpremH.setChecked(false);
                    /*secdtdgnmatcondE.setVisibility(View.VISIBLE);
                    linedtdgnmatcondE.setVisibility(View.VISIBLE);
                    sectmdgnmatcondE.setVisibility(View.VISIBLE);
                    linetmdgnmatcondE.setVisibility(View.VISIBLE);*/
                 }
                 }
         });
         secdtdgnmatcondE=(LinearLayout)findViewById(R.id.secdtdgnmatcondE);
         linedtdgnmatcondE=(View)findViewById(R.id.linedtdgnmatcondE);
         VlbldtdgnmatcondE=(TextView) findViewById(R.id.VlbldtdgnmatcondE);
         dtpdtdgnmatcondE=(EditText) findViewById(R.id.dtpdtdgnmatcondE);
         sectmdgnmatcondE=(LinearLayout)findViewById(R.id.sectmdgnmatcondE);
         linetmdgnmatcondE=(View)findViewById(R.id.linetmdgnmatcondE);
         VlbltmdgnmatcondE=(TextView) findViewById(R.id.VlbltmdgnmatcondE);
         txttmdgnmatcondE=(EditText) findViewById(R.id.txttmdgnmatcondE);
         secmatcondpremF=(LinearLayout)findViewById(R.id.secmatcondpremF);
         linematcondpremF=(View)findViewById(R.id.linematcondpremF);
         VlblmatcondpremF=(TextView) findViewById(R.id.VlblmatcondpremF);
         chkmatcondpremF=(CheckBox) findViewById(R.id.chkmatcondpremF);
         chkmatcondpremF.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if (!isChecked) {
                    secmatcondpremOth.setVisibility(View.GONE);
                    linematcondpremOth.setVisibility(View.GONE);
                    txtmatcondpremOth.setText("");
                    secdtdgnmatcondF.setVisibility(View.GONE);
                    linedtdgnmatcondF.setVisibility(View.GONE);
                    dtpdtdgnmatcondF.setText("");
                      secdtdgnmatcondFNot.setVisibility(View.GONE);
                      rdogrpdtdgnmatcondANot.clearCheck();
                    sectmdgnmatcondF.setVisibility(View.GONE);
                    linetmdgnmatcondF.setVisibility(View.GONE);
                    txttmdgnmatcondF.setText("");
                      sectmdgnmatcondFNot.setVisibility(View.GONE);
                      rdogrptmdgnmatcondFNot.clearCheck();
                 }
                 else
                 {
                    secmatcondpremOth.setVisibility(View.VISIBLE);
                    linematcondpremOth.setVisibility(View.VISIBLE);
                    secdtdgnmatcondF.setVisibility(View.VISIBLE);
                    linedtdgnmatcondF.setVisibility(View.VISIBLE);
                    sectmdgnmatcondF.setVisibility(View.VISIBLE);
                    linetmdgnmatcondF.setVisibility(View.VISIBLE);
                      secdtdgnmatcondFNot.setVisibility(View.VISIBLE);
                      sectmdgnmatcondFNot.setVisibility(View.VISIBLE);
                      chkmatcondpremE.setChecked(false);
                      chkmatcondpremG.setChecked(false);
                      chkmatcondpremH.setChecked(false);
                 }
                 }
         });
         secmatcondpremOth=(LinearLayout)findViewById(R.id.secmatcondpremOth);
         linematcondpremOth=(View)findViewById(R.id.linematcondpremOth);
         VlblmatcondpremOth=(TextView) findViewById(R.id.VlblmatcondpremOth);
         txtmatcondpremOth=(EditText) findViewById(R.id.txtmatcondpremOth);
         secdtdgnmatcondF=(LinearLayout)findViewById(R.id.secdtdgnmatcondF);
         linedtdgnmatcondF=(View)findViewById(R.id.linedtdgnmatcondF);
         VlbldtdgnmatcondF=(TextView) findViewById(R.id.VlbldtdgnmatcondF);
         dtpdtdgnmatcondF=(EditText) findViewById(R.id.dtpdtdgnmatcondF);
         sectmdgnmatcondF=(LinearLayout)findViewById(R.id.sectmdgnmatcondF);
         linetmdgnmatcondF=(View)findViewById(R.id.linetmdgnmatcondF);
         VlbltmdgnmatcondF=(TextView) findViewById(R.id.VlbltmdgnmatcondF);
         txttmdgnmatcondF=(EditText) findViewById(R.id.txttmdgnmatcondF);
         secmatcondpremG=(LinearLayout)findViewById(R.id.secmatcondpremG);
         linematcondpremG=(View)findViewById(R.id.linematcondpremG);
         VlblmatcondpremG=(TextView) findViewById(R.id.VlblmatcondpremG);
         chkmatcondpremG=(CheckBox) findViewById(R.id.chkmatcondpremG);
         secmatcondpremH=(LinearLayout)findViewById(R.id.secmatcondpremH);
         linematcondpremH=(View)findViewById(R.id.linematcondpremH);
         VlblmatcondpremH=(TextView) findViewById(R.id.VlblmatcondpremH);
         chkmatcondpremH=(CheckBox) findViewById(R.id.chkmatcondpremH);
         seclblmatinf=(LinearLayout)findViewById(R.id.seclblmatinf);
         linelblmatinf=(View)findViewById(R.id.linelblmatinf);
         secmatinfA=(LinearLayout)findViewById(R.id.secmatinfA);
         linematinfA=(View)findViewById(R.id.linematinfA);
         VlblmatinfA=(TextView) findViewById(R.id.VlblmatinfA);
         chkmatinfA=(CheckBox) findViewById(R.id.chkmatinfA);
         secmatinfB=(LinearLayout)findViewById(R.id.secmatinfB);
         linematinfB=(View)findViewById(R.id.linematinfB);
         VlblmatinfB=(TextView) findViewById(R.id.VlblmatinfB);
         chkmatinfB=(CheckBox) findViewById(R.id.chkmatinfB);
         secmatinfC=(LinearLayout)findViewById(R.id.secmatinfC);
         linematinfC=(View)findViewById(R.id.linematinfC);
         VlblmatinfC=(TextView) findViewById(R.id.VlblmatinfC);
         chkmatinfC=(CheckBox) findViewById(R.id.chkmatinfC);
         secmatinfD=(LinearLayout)findViewById(R.id.secmatinfD);
         linematinfD=(View)findViewById(R.id.linematinfD);
         VlblmatinfD=(TextView) findViewById(R.id.VlblmatinfD);
         chkmatinfD=(CheckBox) findViewById(R.id.chkmatinfD);
         secmatinfE=(LinearLayout)findViewById(R.id.secmatinfE);
         linematinfE=(View)findViewById(R.id.linematinfE);
         VlblmatinfE=(TextView) findViewById(R.id.VlblmatinfE);
         chkmatinfE=(CheckBox) findViewById(R.id.chkmatinfE);
         secmatinfF=(LinearLayout)findViewById(R.id.secmatinfF);
         linematinfF=(View)findViewById(R.id.linematinfF);
         VlblmatinfF=(TextView) findViewById(R.id.VlblmatinfF);
         chkmatinfF=(CheckBox) findViewById(R.id.chkmatinfF);
         secmatinfG=(LinearLayout)findViewById(R.id.secmatinfG);
         linematinfG=(View)findViewById(R.id.linematinfG);
         VlblmatinfG=(TextView) findViewById(R.id.VlblmatinfG);
         chkmatinfG=(CheckBox) findViewById(R.id.chkmatinfG);
         secmatinfH=(LinearLayout)findViewById(R.id.secmatinfH);
         linematinfH=(View)findViewById(R.id.linematinfH);
         VlblmatinfH=(TextView) findViewById(R.id.VlblmatinfH);
         chkmatinfH=(CheckBox) findViewById(R.id.chkmatinfH);
         secmatinfI=(LinearLayout)findViewById(R.id.secmatinfI);
         linematinfI=(View)findViewById(R.id.linematinfI);
         VlblmatinfI=(TextView) findViewById(R.id.VlblmatinfI);
         chkmatinfI=(CheckBox) findViewById(R.id.chkmatinfI);
         secmatinfJ=(LinearLayout)findViewById(R.id.secmatinfJ);
         linematinfJ=(View)findViewById(R.id.linematinfJ);
         VlblmatinfJ=(TextView) findViewById(R.id.VlblmatinfJ);
         chkmatinfJ=(CheckBox) findViewById(R.id.chkmatinfJ);
         chkmatinfJ.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if (!isChecked) {
                    secmatinfOth.setVisibility(View.GONE);
                    linematinfOth.setVisibility(View.GONE);
                    txtmatinfOth.setText("");
                 }
                 else
                 {
                    secmatinfOth.setVisibility(View.VISIBLE);
                    linematinfOth.setVisibility(View.VISIBLE);
                 }
                 }
         });
         secmatinfOth=(LinearLayout)findViewById(R.id.secmatinfOth);
         linematinfOth=(View)findViewById(R.id.linematinfOth);
         VlblmatinfOth=(TextView) findViewById(R.id.VlblmatinfOth);
         txtmatinfOth=(EditText) findViewById(R.id.txtmatinfOth);
         secdtdgnmatinf=(LinearLayout)findViewById(R.id.secdtdgnmatinf);
         linedtdgnmatinf=(View)findViewById(R.id.linedtdgnmatinf);
         Vlbldtdgnmatinf=(TextView) findViewById(R.id.Vlbldtdgnmatinf);
         dtpdtdgnmatinf=(EditText) findViewById(R.id.dtpdtdgnmatinf);
         sectmdgnmatinf=(LinearLayout)findViewById(R.id.sectmdgnmatinf);
         linetmdgnmatinf=(View)findViewById(R.id.linetmdgnmatinf);
         Vlbltmdgnmatinf=(TextView) findViewById(R.id.Vlbltmdgnmatinf);
         txttmdgnmatinf=(EditText) findViewById(R.id.txttmdgnmatinf);
         seclblmatcoinf=(LinearLayout)findViewById(R.id.seclblmatcoinf);
         linelblmatcoinf=(View)findViewById(R.id.linelblmatcoinf);
         secmatcoinfA=(LinearLayout)findViewById(R.id.secmatcoinfA);
         linematcoinfA=(View)findViewById(R.id.linematcoinfA);
         VlblmatcoinfA=(TextView) findViewById(R.id.VlblmatcoinfA);
         chkmatcoinfA=(CheckBox) findViewById(R.id.chkmatcoinfA);
         secmatcoinfB=(LinearLayout)findViewById(R.id.secmatcoinfB);
         linematcoinfB=(View)findViewById(R.id.linematcoinfB);
         VlblmatcoinfB=(TextView) findViewById(R.id.VlblmatcoinfB);
         chkmatcoinfB=(CheckBox) findViewById(R.id.chkmatcoinfB);
         secmatcoinfC=(LinearLayout)findViewById(R.id.secmatcoinfC);
         linematcoinfC=(View)findViewById(R.id.linematcoinfC);
         VlblmatcoinfC=(TextView) findViewById(R.id.VlblmatcoinfC);
         chkmatcoinfC=(CheckBox) findViewById(R.id.chkmatcoinfC);
         secmatcoinfD=(LinearLayout)findViewById(R.id.secmatcoinfD);
         linematcoinfD=(View)findViewById(R.id.linematcoinfD);
         VlblmatcoinfD=(TextView) findViewById(R.id.VlblmatcoinfD);
         chkmatcoinfD=(CheckBox) findViewById(R.id.chkmatcoinfD);
         secmatcoinfE=(LinearLayout)findViewById(R.id.secmatcoinfE);
         linematcoinfE=(View)findViewById(R.id.linematcoinfE);
         VlblmatcoinfE=(TextView) findViewById(R.id.VlblmatcoinfE);
         chkmatcoinfE=(CheckBox) findViewById(R.id.chkmatcoinfE);
         secmatcoinfF=(LinearLayout)findViewById(R.id.secmatcoinfF);
         linematcoinfF=(View)findViewById(R.id.linematcoinfF);
         VlblmatcoinfF=(TextView) findViewById(R.id.VlblmatcoinfF);
         chkmatcoinfF=(CheckBox) findViewById(R.id.chkmatcoinfF);
         chkmatcoinfF.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if (!isChecked) {
                    secmatcoinfOth.setVisibility(View.GONE);
                    linematcoinfOth.setVisibility(View.GONE);
                    txtmatcoinfOth.setText("");
                 }
                 else
                 {
                    secmatcoinfOth.setVisibility(View.VISIBLE);
                    linematcoinfOth.setVisibility(View.VISIBLE);
                 }
                 }
         });
         secmatcoinfOth=(LinearLayout)findViewById(R.id.secmatcoinfOth);
         linematcoinfOth=(View)findViewById(R.id.linematcoinfOth);
         VlblmatcoinfOth=(TextView) findViewById(R.id.VlblmatcoinfOth);
         txtmatcoinfOth=(EditText) findViewById(R.id.txtmatcoinfOth);
         secmatcoinftrtmnt=(LinearLayout)findViewById(R.id.secmatcoinftrtmnt);
         linematcoinftrtmnt=(View)findViewById(R.id.linematcoinftrtmnt);
         Vlblmatcoinftrtmnt = (TextView) findViewById(R.id.Vlblmatcoinftrtmnt);
         rdogrpmatcoinftrtmnt = (RadioGroup) findViewById(R.id.rdogrpmatcoinftrtmnt);

         rdomatcoinftrtmnt1 = (RadioButton) findViewById(R.id.rdomatcoinftrtmnt1);
         rdomatcoinftrtmnt2 = (RadioButton) findViewById(R.id.rdomatcoinftrtmnt2);
         rdomatcoinftrtmnt3 = (RadioButton) findViewById(R.id.rdomatcoinftrtmnt3);
         rdomatcoinftrtmnt4 = (RadioButton) findViewById(R.id.rdomatcoinftrtmnt4);
         secfetalaus=(LinearLayout)findViewById(R.id.secfetalaus);
         linefetalaus=(View)findViewById(R.id.linefetalaus);
         Vlblfetalaus = (TextView) findViewById(R.id.Vlblfetalaus);
         rdogrpfetalaus = (RadioGroup) findViewById(R.id.rdogrpfetalaus);

         rdofetalaus1 = (RadioButton) findViewById(R.id.rdofetalaus1);
         rdofetalaus2 = (RadioButton) findViewById(R.id.rdofetalaus2);
         rdofetalaus3 = (RadioButton) findViewById(R.id.rdofetalaus3);
         rdofetalaus4 = (RadioButton) findViewById(R.id.rdofetalaus4);
         rdofetalaus5 = (RadioButton) findViewById(R.id.rdofetalaus5);
         rdofetalaus6 = (RadioButton) findViewById(R.id.rdofetalaus6);
         rdogrpfetalaus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpfetalaus = new String[] {"1","2","3","8","9","7"};
             for (int i = 0; i < rdogrpfetalaus.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpfetalaus.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpfetalaus[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secfetalausrate.setVisibility(View.GONE);
                    linefetalausrate.setVisibility(View.GONE);
                    txtfetalausrate.setText("");
                    secfetalausOth.setVisibility(View.GONE);
                    linefetalausOth.setVisibility(View.GONE);
                    txtfetalausOth.setText("");
             }
             else if(rbData.equalsIgnoreCase("3"))
             {
                    secfetalausrate.setVisibility(View.GONE);
                    linefetalausrate.setVisibility(View.GONE);
                    txtfetalausrate.setText("");
                    secfetalausOth.setVisibility(View.GONE);
                    linefetalausOth.setVisibility(View.GONE);
                    txtfetalausOth.setText("");
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secfetalausrate.setVisibility(View.GONE);
                    linefetalausrate.setVisibility(View.GONE);
                    txtfetalausrate.setText("");
                    secfetalausOth.setVisibility(View.GONE);
                    linefetalausOth.setVisibility(View.GONE);
                    txtfetalausOth.setText("");
             }
             else if(rbData.equalsIgnoreCase("9"))
             {
                    secfetalausrate.setVisibility(View.GONE);
                    linefetalausrate.setVisibility(View.GONE);
                    txtfetalausrate.setText("");
                    secfetalausOth.setVisibility(View.GONE);
                    linefetalausOth.setVisibility(View.GONE);
                    txtfetalausOth.setText("");
             }
             else if(rbData.equalsIgnoreCase("1"))
             {
                    secfetalausrate.setVisibility(View.VISIBLE);
                    linefetalausrate.setVisibility(View.VISIBLE);
                    secfetalausOth.setVisibility(View.GONE);
                    linefetalausOth.setVisibility(View.GONE);
                    txtfetalausOth.setText("");
             }
             else if(rbData.equalsIgnoreCase("7"))
             {
                  secfetalausrate.setVisibility(View.GONE);
                  linefetalausrate.setVisibility(View.GONE);
                  txtfetalausrate.setText("");
                  secfetalausOth.setVisibility(View.VISIBLE);
                  linefetalausOth.setVisibility(View.VISIBLE);
             }
             else
             {
                  secfetalausrate.setVisibility(View.VISIBLE);
                  linefetalausrate.setVisibility(View.VISIBLE);
                  secfetalausOth.setVisibility(View.VISIBLE);
                  linefetalausOth.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            }
         });
         secfetalausrate=(LinearLayout)findViewById(R.id.secfetalausrate);
         linefetalausrate=(View)findViewById(R.id.linefetalausrate);
         Vlblfetalausrate=(TextView) findViewById(R.id.Vlblfetalausrate);
         txtfetalausrate=(EditText) findViewById(R.id.txtfetalausrate);
         secfetalausOth=(LinearLayout)findViewById(R.id.secfetalausOth);
         linefetalausOth=(View)findViewById(R.id.linefetalausOth);
         VlblfetalausOth=(TextView) findViewById(R.id.VlblfetalausOth);
         txtfetalausOth=(EditText) findViewById(R.id.txtfetalausOth);
         seclblSectionIII=(LinearLayout)findViewById(R.id.seclblSectionIII);
         linelblSectionIII=(View)findViewById(R.id.linelblSectionIII);
         secacsadm1=(LinearLayout)findViewById(R.id.secacsadm1);
         lineacsadm1=(View)findViewById(R.id.lineacsadm1);
         Vlblacsadm1 = (TextView) findViewById(R.id.Vlblacsadm1);
         rdogrpacsadm1 = (RadioGroup) findViewById(R.id.rdogrpacsadm1);

         rdoacsadm11 = (RadioButton) findViewById(R.id.rdoacsadm11);
         rdoacsadm12 = (RadioButton) findViewById(R.id.rdoacsadm12);
         rdoacsadm13 = (RadioButton) findViewById(R.id.rdoacsadm13);
         rdoacsadm14 = (RadioButton) findViewById(R.id.rdoacsadm14);
         rdogrpacsadm1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpacsadm1 = new String[] {"1","2","8","9"};
             for (int i = 0; i < rdogrpacsadm1.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpacsadm1.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpacsadm1[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secdtacs1.setVisibility(View.GONE);
                    linedtacs1.setVisibility(View.GONE);
                    dtpdtacs1.setText("");
                    sectmdtacs1.setVisibility(View.GONE);
                    linetmdtacs1.setVisibility(View.GONE);
                    txttmdtacs1.setText("");
                    secnameacs1.setVisibility(View.GONE);
                    linenameacs1.setVisibility(View.GONE);
                    rdogrpnameacs1.clearCheck();
                    secnameacs1Oth.setVisibility(View.GONE);
                    linenameacs1Oth.setVisibility(View.GONE);
                    txtnameacs1Oth.setText("");
                    secacsdose1.setVisibility(View.GONE);
                    lineacsdose1.setVisibility(View.GONE);
                    rdogrpacsdose1.clearCheck();
                    secacsdose1Oth.setVisibility(View.GONE);
                    lineacsdose1Oth.setVisibility(View.GONE);
                    txtacsdose1Oth.setText("");
                    secacsadm2.setVisibility(View.GONE);
                    lineacsadm2.setVisibility(View.GONE);
                    rdogrpacsadm2.clearCheck();
                    secdtacsm2.setVisibility(View.GONE);
                    linedtacsm2.setVisibility(View.GONE);
                    dtpdtacsm2.setText("");
                    sectmacsm2.setVisibility(View.GONE);
                    linetmacsm2.setVisibility(View.GONE);
                    txttmacsm2.setText("");
                    secacsdose2.setVisibility(View.GONE);
                    lineacsdose2.setVisibility(View.GONE);
                    rdogrpacsdose2.clearCheck();
                    secacsdose2Oth.setVisibility(View.GONE);
                    lineacsdose2Oth.setVisibility(View.GONE);
                    txtacsdose2Oth.setText("");
                    secacsadm3.setVisibility(View.GONE);
                    lineacsadm3.setVisibility(View.GONE);
                    rdogrpacsadm3.clearCheck();
                    secdtacsadm3.setVisibility(View.GONE);
                    linedtacsadm3.setVisibility(View.GONE);
                    dtpdtacsadm3.setText("");
                    sectmacsadm3.setVisibility(View.GONE);
                    linetmacsadm3.setVisibility(View.GONE);
                    txttmacsadm3.setText("");
                    secacsdose3.setVisibility(View.GONE);
                    lineacsdose3.setVisibility(View.GONE);
                    rdogrpacsdose3.clearCheck();
                    secacsdose3Oth.setVisibility(View.GONE);
                    lineacsdose3Oth.setVisibility(View.GONE);
                    txtacsdose3Oth.setText("");
                    secacsadm4.setVisibility(View.GONE);
                    lineacsadm4.setVisibility(View.GONE);
                    rdogrpacsadm4.clearCheck();
                    secdtacsadm4.setVisibility(View.GONE);
                    linedtacsadm4.setVisibility(View.GONE);
                    dtpdtacsadm4.setText("");
                    sectmacsadm4.setVisibility(View.GONE);
                    linetmacsadm4.setVisibility(View.GONE);
                    txttmacsadm4.setText("");
                    secacsdose4.setVisibility(View.GONE);
                    lineacsdose4.setVisibility(View.GONE);
                    rdogrpacsdose4.clearCheck();
                    secacsdose4Oth.setVisibility(View.GONE);
                    lineacsdose4Oth.setVisibility(View.GONE);
                    txtacsdose4Oth.setText("");
                    secacsfurther.setVisibility(View.GONE);
                    lineacsfurther.setVisibility(View.GONE);
                    rdogrpacsfurther.clearCheck();
                    secdtacsfurther.setVisibility(View.GONE);
                    linedtacsfurther.setVisibility(View.GONE);
                    dtpdtacsfurther.setText("");
                    sectmacsfurther.setVisibility(View.GONE);
                    linetmacsfurther.setVisibility(View.GONE);
                    txttmacsfurther.setText("");
                    secacsdosefurther.setVisibility(View.GONE);
                    lineacsdosefurther.setVisibility(View.GONE);
                    rdogrpacsdosefurther.clearCheck();
                    secacsdosefurtherOth.setVisibility(View.GONE);
                    lineacsdosefurtherOth.setVisibility(View.GONE);
                    txtacsdosefurtherOth.setText("");

                 secdtacs1Not.setVisibility(View.GONE);
                 rdogrpdtacs1Not.clearCheck();
                 sectmdtacs1Not.setVisibility(View.GONE);
                 rdogrptmdtacs1Not.clearCheck();
                 secdtacsm2Not.setVisibility(View.GONE);
                 rdogrpdtacsm2Not.clearCheck();
                 sectmacsm2Not.setVisibility(View.GONE);
                 rdogrptmacsm2Not.clearCheck();
                 secdtacsadm3Not.setVisibility(View.GONE);
                 rdogrpdtacsadm3Not.clearCheck();
                 sectmacsadm3Not.setVisibility(View.GONE);
                 rdogrptmacsadm3Not.clearCheck();
                 secdtacsadm4Not.setVisibility(View.GONE);
                 rdogrpdtacsadm4Not.clearCheck();
                 sectmacsadm4Not.setVisibility(View.GONE);
                 rdogrptmacsadm4Not.clearCheck();
                 secdtacsfurtherNot.setVisibility(View.GONE);
                 rdogrpdtacsfurtherNot.clearCheck();
                 sectmacsfurtherNot.setVisibility(View.GONE);
                 rdogrptmacsfurtherNot.clearCheck();
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secdtacs1.setVisibility(View.GONE);
                    linedtacs1.setVisibility(View.GONE);
                    dtpdtacs1.setText("");
                    sectmdtacs1.setVisibility(View.GONE);
                    linetmdtacs1.setVisibility(View.GONE);
                    txttmdtacs1.setText("");
                    secnameacs1.setVisibility(View.GONE);
                    linenameacs1.setVisibility(View.GONE);
                    rdogrpnameacs1.clearCheck();
                    secnameacs1Oth.setVisibility(View.GONE);
                    linenameacs1Oth.setVisibility(View.GONE);
                    txtnameacs1Oth.setText("");
                    secacsdose1.setVisibility(View.GONE);
                    lineacsdose1.setVisibility(View.GONE);
                    rdogrpacsdose1.clearCheck();
                    secacsdose1Oth.setVisibility(View.GONE);
                    lineacsdose1Oth.setVisibility(View.GONE);
                    txtacsdose1Oth.setText("");
                    secacsadm2.setVisibility(View.GONE);
                    lineacsadm2.setVisibility(View.GONE);
                    rdogrpacsadm2.clearCheck();
                    secdtacsm2.setVisibility(View.GONE);
                    linedtacsm2.setVisibility(View.GONE);
                    dtpdtacsm2.setText("");
                    sectmacsm2.setVisibility(View.GONE);
                    linetmacsm2.setVisibility(View.GONE);
                    txttmacsm2.setText("");
                    secacsdose2.setVisibility(View.GONE);
                    lineacsdose2.setVisibility(View.GONE);
                    rdogrpacsdose2.clearCheck();
                    secacsdose2Oth.setVisibility(View.GONE);
                    lineacsdose2Oth.setVisibility(View.GONE);
                    txtacsdose2Oth.setText("");
                    secacsadm3.setVisibility(View.GONE);
                    lineacsadm3.setVisibility(View.GONE);
                    rdogrpacsadm3.clearCheck();
                    secdtacsadm3.setVisibility(View.GONE);
                    linedtacsadm3.setVisibility(View.GONE);
                    dtpdtacsadm3.setText("");
                    sectmacsadm3.setVisibility(View.GONE);
                    linetmacsadm3.setVisibility(View.GONE);
                    txttmacsadm3.setText("");
                    secacsdose3.setVisibility(View.GONE);
                    lineacsdose3.setVisibility(View.GONE);
                    rdogrpacsdose3.clearCheck();
                    secacsdose3Oth.setVisibility(View.GONE);
                    lineacsdose3Oth.setVisibility(View.GONE);
                    txtacsdose3Oth.setText("");
                    secacsadm4.setVisibility(View.GONE);
                    lineacsadm4.setVisibility(View.GONE);
                    rdogrpacsadm4.clearCheck();
                    secdtacsadm4.setVisibility(View.GONE);
                    linedtacsadm4.setVisibility(View.GONE);
                    dtpdtacsadm4.setText("");
                    sectmacsadm4.setVisibility(View.GONE);
                    linetmacsadm4.setVisibility(View.GONE);
                    txttmacsadm4.setText("");
                    secacsdose4.setVisibility(View.GONE);
                    lineacsdose4.setVisibility(View.GONE);
                    rdogrpacsdose4.clearCheck();
                    secacsdose4Oth.setVisibility(View.GONE);
                    lineacsdose4Oth.setVisibility(View.GONE);
                    txtacsdose4Oth.setText("");
                    secacsfurther.setVisibility(View.GONE);
                    lineacsfurther.setVisibility(View.GONE);
                    rdogrpacsfurther.clearCheck();
                    secdtacsfurther.setVisibility(View.GONE);
                    linedtacsfurther.setVisibility(View.GONE);
                    dtpdtacsfurther.setText("");
                    sectmacsfurther.setVisibility(View.GONE);
                    linetmacsfurther.setVisibility(View.GONE);
                    txttmacsfurther.setText("");
                    secacsdosefurther.setVisibility(View.GONE);
                    lineacsdosefurther.setVisibility(View.GONE);
                    rdogrpacsdosefurther.clearCheck();
                    secacsdosefurtherOth.setVisibility(View.GONE);
                    lineacsdosefurtherOth.setVisibility(View.GONE);
                    txtacsdosefurtherOth.setText("");

                 secdtacs1Not.setVisibility(View.GONE);
                 rdogrpdtacs1Not.clearCheck();
                 sectmdtacs1Not.setVisibility(View.GONE);
                 rdogrptmdtacs1Not.clearCheck();
                 secdtacsm2Not.setVisibility(View.GONE);
                 rdogrpdtacsm2Not.clearCheck();
                 sectmacsm2Not.setVisibility(View.GONE);
                 rdogrptmacsm2Not.clearCheck();
                 secdtacsadm3Not.setVisibility(View.GONE);
                 rdogrpdtacsadm3Not.clearCheck();
                 sectmacsadm3Not.setVisibility(View.GONE);
                 rdogrptmacsadm3Not.clearCheck();
                 secdtacsadm4Not.setVisibility(View.GONE);
                 rdogrpdtacsadm4Not.clearCheck();
                 sectmacsadm4Not.setVisibility(View.GONE);
                 rdogrptmacsadm4Not.clearCheck();
                 secdtacsfurtherNot.setVisibility(View.GONE);
                 rdogrpdtacsfurtherNot.clearCheck();
                 sectmacsfurtherNot.setVisibility(View.GONE);
                 rdogrptmacsfurtherNot.clearCheck();
             }
             else if(rbData.equalsIgnoreCase("9"))
             {
                    secdtacs1.setVisibility(View.GONE);
                    linedtacs1.setVisibility(View.GONE);
                    dtpdtacs1.setText("");
                    sectmdtacs1.setVisibility(View.GONE);
                    linetmdtacs1.setVisibility(View.GONE);
                    txttmdtacs1.setText("");
                    secnameacs1.setVisibility(View.GONE);
                    linenameacs1.setVisibility(View.GONE);
                    rdogrpnameacs1.clearCheck();
                    secnameacs1Oth.setVisibility(View.GONE);
                    linenameacs1Oth.setVisibility(View.GONE);
                    txtnameacs1Oth.setText("");
                    secacsdose1.setVisibility(View.GONE);
                    lineacsdose1.setVisibility(View.GONE);
                    rdogrpacsdose1.clearCheck();
                    secacsdose1Oth.setVisibility(View.GONE);
                    lineacsdose1Oth.setVisibility(View.GONE);
                    txtacsdose1Oth.setText("");
                    secacsadm2.setVisibility(View.GONE);
                    lineacsadm2.setVisibility(View.GONE);
                    rdogrpacsadm2.clearCheck();
                    secdtacsm2.setVisibility(View.GONE);
                    linedtacsm2.setVisibility(View.GONE);
                    dtpdtacsm2.setText("");
                    sectmacsm2.setVisibility(View.GONE);
                    linetmacsm2.setVisibility(View.GONE);
                    txttmacsm2.setText("");
                    secacsdose2.setVisibility(View.GONE);
                    lineacsdose2.setVisibility(View.GONE);
                    rdogrpacsdose2.clearCheck();
                    secacsdose2Oth.setVisibility(View.GONE);
                    lineacsdose2Oth.setVisibility(View.GONE);
                    txtacsdose2Oth.setText("");
                    secacsadm3.setVisibility(View.GONE);
                    lineacsadm3.setVisibility(View.GONE);
                    rdogrpacsadm3.clearCheck();
                    secdtacsadm3.setVisibility(View.GONE);
                    linedtacsadm3.setVisibility(View.GONE);
                    dtpdtacsadm3.setText("");
                    sectmacsadm3.setVisibility(View.GONE);
                    linetmacsadm3.setVisibility(View.GONE);
                    txttmacsadm3.setText("");
                    secacsdose3.setVisibility(View.GONE);
                    lineacsdose3.setVisibility(View.GONE);
                    rdogrpacsdose3.clearCheck();
                    secacsdose3Oth.setVisibility(View.GONE);
                    lineacsdose3Oth.setVisibility(View.GONE);
                    txtacsdose3Oth.setText("");
                    secacsadm4.setVisibility(View.GONE);
                    lineacsadm4.setVisibility(View.GONE);
                    rdogrpacsadm4.clearCheck();
                    secdtacsadm4.setVisibility(View.GONE);
                    linedtacsadm4.setVisibility(View.GONE);
                    dtpdtacsadm4.setText("");
                    sectmacsadm4.setVisibility(View.GONE);
                    linetmacsadm4.setVisibility(View.GONE);
                    txttmacsadm4.setText("");
                    secacsdose4.setVisibility(View.GONE);
                    lineacsdose4.setVisibility(View.GONE);
                    rdogrpacsdose4.clearCheck();
                    secacsdose4Oth.setVisibility(View.GONE);
                    lineacsdose4Oth.setVisibility(View.GONE);
                    txtacsdose4Oth.setText("");
                    secacsfurther.setVisibility(View.GONE);
                    lineacsfurther.setVisibility(View.GONE);
                    rdogrpacsfurther.clearCheck();
                    secdtacsfurther.setVisibility(View.GONE);
                    linedtacsfurther.setVisibility(View.GONE);
                    dtpdtacsfurther.setText("");
                    sectmacsfurther.setVisibility(View.GONE);
                    linetmacsfurther.setVisibility(View.GONE);
                    txttmacsfurther.setText("");
                    secacsdosefurther.setVisibility(View.GONE);
                    lineacsdosefurther.setVisibility(View.GONE);
                    rdogrpacsdosefurther.clearCheck();
                    secacsdosefurtherOth.setVisibility(View.GONE);
                    lineacsdosefurtherOth.setVisibility(View.GONE);
                    txtacsdosefurtherOth.setText("");

                 secdtacs1Not.setVisibility(View.GONE);
                 rdogrpdtacs1Not.clearCheck();
                 sectmdtacs1Not.setVisibility(View.GONE);
                 rdogrptmdtacs1Not.clearCheck();
                 secdtacsm2Not.setVisibility(View.GONE);
                 rdogrpdtacsm2Not.clearCheck();
                 sectmacsm2Not.setVisibility(View.GONE);
                 rdogrptmacsm2Not.clearCheck();
                 secdtacsadm3Not.setVisibility(View.GONE);
                 rdogrpdtacsadm3Not.clearCheck();
                 sectmacsadm3Not.setVisibility(View.GONE);
                 rdogrptmacsadm3Not.clearCheck();
                 secdtacsadm4Not.setVisibility(View.GONE);
                 rdogrpdtacsadm4Not.clearCheck();
                 sectmacsadm4Not.setVisibility(View.GONE);
                 rdogrptmacsadm4Not.clearCheck();
                 secdtacsfurtherNot.setVisibility(View.GONE);
                 rdogrpdtacsfurtherNot.clearCheck();
                 sectmacsfurtherNot.setVisibility(View.GONE);
                 rdogrptmacsfurtherNot.clearCheck();
             }
             else
             {
                    secdtacs1.setVisibility(View.VISIBLE);
                    linedtacs1.setVisibility(View.VISIBLE);
                    sectmdtacs1.setVisibility(View.VISIBLE);
                    linetmdtacs1.setVisibility(View.VISIBLE);
                    secnameacs1.setVisibility(View.VISIBLE);
                    linenameacs1.setVisibility(View.VISIBLE);
                    //secnameacs1Oth.setVisibility(View.VISIBLE);
                    //linenameacs1Oth.setVisibility(View.VISIBLE);
                    secacsdose1.setVisibility(View.VISIBLE);
                    lineacsdose1.setVisibility(View.VISIBLE);
                    //secacsdose1Oth.setVisibility(View.VISIBLE);
                    //lineacsdose1Oth.setVisibility(View.VISIBLE);
                    secacsadm2.setVisibility(View.VISIBLE);
                    lineacsadm2.setVisibility(View.VISIBLE);
                    secdtacsm2.setVisibility(View.VISIBLE);
                    linedtacsm2.setVisibility(View.VISIBLE);
                    sectmacsm2.setVisibility(View.VISIBLE);
                    linetmacsm2.setVisibility(View.VISIBLE);
                    secacsdose2.setVisibility(View.VISIBLE);
                    lineacsdose2.setVisibility(View.VISIBLE);
                    //secacsdose2Oth.setVisibility(View.VISIBLE);
                    //lineacsdose2Oth.setVisibility(View.VISIBLE);
                    secacsadm3.setVisibility(View.VISIBLE);
                    lineacsadm3.setVisibility(View.VISIBLE);
                    secdtacsadm3.setVisibility(View.VISIBLE);
                    linedtacsadm3.setVisibility(View.VISIBLE);
                    sectmacsadm3.setVisibility(View.VISIBLE);
                    linetmacsadm3.setVisibility(View.VISIBLE);
                    secacsdose3.setVisibility(View.VISIBLE);
                    lineacsdose3.setVisibility(View.VISIBLE);
                    //secacsdose3Oth.setVisibility(View.VISIBLE);
                    //lineacsdose3Oth.setVisibility(View.VISIBLE);
                    secacsadm4.setVisibility(View.VISIBLE);
                    lineacsadm4.setVisibility(View.VISIBLE);
                    secdtacsadm4.setVisibility(View.VISIBLE);
                    linedtacsadm4.setVisibility(View.VISIBLE);
                    sectmacsadm4.setVisibility(View.VISIBLE);
                    linetmacsadm4.setVisibility(View.VISIBLE);
                    secacsdose4.setVisibility(View.VISIBLE);
                    lineacsdose4.setVisibility(View.VISIBLE);
                    //secacsdose4Oth.setVisibility(View.VISIBLE);
                    //lineacsdose4Oth.setVisibility(View.VISIBLE);
                    secacsfurther.setVisibility(View.VISIBLE);
                    lineacsfurther.setVisibility(View.VISIBLE);
                    secdtacsfurther.setVisibility(View.VISIBLE);
                    linedtacsfurther.setVisibility(View.VISIBLE);
                    sectmacsfurther.setVisibility(View.VISIBLE);
                    linetmacsfurther.setVisibility(View.VISIBLE);
                    secacsdosefurther.setVisibility(View.VISIBLE);
                    lineacsdosefurther.setVisibility(View.VISIBLE);

                 secdtacs1Not.setVisibility(View.VISIBLE);
                 sectmdtacs1Not.setVisibility(View.VISIBLE);
                 secdtacsm2Not.setVisibility(View.VISIBLE);
                 sectmacsm2Not.setVisibility(View.VISIBLE);
                 secdtacsadm3Not.setVisibility(View.VISIBLE);
                 sectmacsadm3Not.setVisibility(View.VISIBLE);
                 secdtacsadm4Not.setVisibility(View.VISIBLE);
                 sectmacsadm4Not.setVisibility(View.VISIBLE);
                 secdtacsfurtherNot.setVisibility(View.VISIBLE);
                 sectmacsfurtherNot.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            }
         });
         secdtacs1=(LinearLayout)findViewById(R.id.secdtacs1);
         linedtacs1=(View)findViewById(R.id.linedtacs1);
         Vlbldtacs1=(TextView) findViewById(R.id.Vlbldtacs1);
         dtpdtacs1=(EditText) findViewById(R.id.dtpdtacs1);

        rdogrpdtacs1Not=(RadioGroup)findViewById(R.id.rdogrpdtacs1Not) ;
        rdodtacs1Not1=(RadioButton)findViewById(R.id.rdodtacs1Not1) ;
        rdodtacs1Not2=(RadioButton)findViewById(R.id.rdodtacs1Not2) ;

         sectmdtacs1=(LinearLayout)findViewById(R.id.sectmdtacs1);
         linetmdtacs1=(View)findViewById(R.id.linetmdtacs1);
         Vlbltmdtacs1=(TextView) findViewById(R.id.Vlbltmdtacs1);
         txttmdtacs1=(EditText) findViewById(R.id.txttmdtacs1);
          rdogrptmdtacs1Not=(RadioGroup)findViewById(R.id.rdogrptmdtacs1Not) ;
          rdotmdtacs1Not1=(RadioButton)findViewById(R.id.rdotmdtacs1Not1);
          rdotmdtacs1Not2=(RadioButton)findViewById(R.id.rdotmdtacs1Not2);

         secnameacs1=(LinearLayout)findViewById(R.id.secnameacs1);
         linenameacs1=(View)findViewById(R.id.linenameacs1);
         Vlblnameacs1 = (TextView) findViewById(R.id.Vlblnameacs1);
         rdogrpnameacs1 = (RadioGroup) findViewById(R.id.rdogrpnameacs1);

         rdonameacs11 = (RadioButton) findViewById(R.id.rdonameacs11);
         rdonameacs12 = (RadioButton) findViewById(R.id.rdonameacs12);
         rdonameacs13 = (RadioButton) findViewById(R.id.rdonameacs13);
         rdonameacs14 = (RadioButton) findViewById(R.id.rdonameacs14);
         rdonameacs15 = (RadioButton) findViewById(R.id.rdonameacs15);
         rdonameacs16 = (RadioButton) findViewById(R.id.rdonameacs16);
         rdogrpnameacs1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpnameacs1 = new String[] {"1","2","3","8","9","7"};
             for (int i = 0; i < rdogrpnameacs1.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpnameacs1.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpnameacs1[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                    secnameacs1Oth.setVisibility(View.GONE);
                    linenameacs1Oth.setVisibility(View.GONE);
                    txtnameacs1Oth.setText("");
             }
             else if(rbData.equalsIgnoreCase("2"))
             {
                    secnameacs1Oth.setVisibility(View.GONE);
                    linenameacs1Oth.setVisibility(View.GONE);
                    txtnameacs1Oth.setText("");
             }
             else if(rbData.equalsIgnoreCase("3"))
             {
                    secnameacs1Oth.setVisibility(View.GONE);
                    linenameacs1Oth.setVisibility(View.GONE);
                    txtnameacs1Oth.setText("");
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secnameacs1Oth.setVisibility(View.GONE);
                    linenameacs1Oth.setVisibility(View.GONE);
                    txtnameacs1Oth.setText("");
             }
             else if(rbData.equalsIgnoreCase("9"))
             {
                    secnameacs1Oth.setVisibility(View.GONE);
                    linenameacs1Oth.setVisibility(View.GONE);
                    txtnameacs1Oth.setText("");
             }
             else
             {
                    secnameacs1Oth.setVisibility(View.VISIBLE);
                    linenameacs1Oth.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            }
         });
         secnameacs1Oth=(LinearLayout)findViewById(R.id.secnameacs1Oth);
         linenameacs1Oth=(View)findViewById(R.id.linenameacs1Oth);
         Vlblnameacs1Oth=(TextView) findViewById(R.id.Vlblnameacs1Oth);
         txtnameacs1Oth=(EditText) findViewById(R.id.txtnameacs1Oth);
         secacsdose1=(LinearLayout)findViewById(R.id.secacsdose1);
         lineacsdose1=(View)findViewById(R.id.lineacsdose1);
         Vlblacsdose1 = (TextView) findViewById(R.id.Vlblacsdose1);
         rdogrpacsdose1 = (RadioGroup) findViewById(R.id.rdogrpacsdose1);

         rdoacsdose11 = (RadioButton) findViewById(R.id.rdoacsdose11);
         rdoacsdose12 = (RadioButton) findViewById(R.id.rdoacsdose12);
         rdoacsdose13 = (RadioButton) findViewById(R.id.rdoacsdose13);
         rdoacsdose14 = (RadioButton) findViewById(R.id.rdoacsdose14);
         rdoacsdose15 = (RadioButton) findViewById(R.id.rdoacsdose15);
         rdogrpacsdose1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpacsdose1 = new String[] {"1","2","8","9","7"};
             for (int i = 0; i < rdogrpacsdose1.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpacsdose1.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpacsdose1[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                    secacsdose1Oth.setVisibility(View.GONE);
                    lineacsdose1Oth.setVisibility(View.GONE);
                    txtacsdose1Oth.setText("");
             }
             else if(rbData.equalsIgnoreCase("2"))
             {
                    secacsdose1Oth.setVisibility(View.GONE);
                    lineacsdose1Oth.setVisibility(View.GONE);
                    txtacsdose1Oth.setText("");
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secacsdose1Oth.setVisibility(View.GONE);
                    lineacsdose1Oth.setVisibility(View.GONE);
                    txtacsdose1Oth.setText("");
             }
             else if(rbData.equalsIgnoreCase("9"))
             {
                    secacsdose1Oth.setVisibility(View.GONE);
                    lineacsdose1Oth.setVisibility(View.GONE);
                    txtacsdose1Oth.setText("");
             }
             else
             {
                    secacsdose1Oth.setVisibility(View.VISIBLE);
                    lineacsdose1Oth.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            }
         });
         secacsdose1Oth=(LinearLayout)findViewById(R.id.secacsdose1Oth);
         lineacsdose1Oth=(View)findViewById(R.id.lineacsdose1Oth);
         Vlblacsdose1Oth=(TextView) findViewById(R.id.Vlblacsdose1Oth);
         txtacsdose1Oth=(EditText) findViewById(R.id.txtacsdose1Oth);
         secacsadm2=(LinearLayout)findViewById(R.id.secacsadm2);
         lineacsadm2=(View)findViewById(R.id.lineacsadm2);
         Vlblacsadm2 = (TextView) findViewById(R.id.Vlblacsadm2);
         rdogrpacsadm2 = (RadioGroup) findViewById(R.id.rdogrpacsadm2);

         rdoacsadm21 = (RadioButton) findViewById(R.id.rdoacsadm21);
         rdoacsadm22 = (RadioButton) findViewById(R.id.rdoacsadm22);
         rdoacsadm23 = (RadioButton) findViewById(R.id.rdoacsadm23);
         rdoacsadm24 = (RadioButton) findViewById(R.id.rdoacsadm24);
         rdogrpacsadm2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpacsadm2 = new String[] {"1","2","8","9"};
             for (int i = 0; i < rdogrpacsadm2.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpacsadm2.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpacsadm2[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secdtacsm2.setVisibility(View.GONE);
                    linedtacsm2.setVisibility(View.GONE);
                    dtpdtacsm2.setText("");
                    sectmacsm2.setVisibility(View.GONE);
                    linetmacsm2.setVisibility(View.GONE);
                    txttmacsm2.setText("");
                    secacsdose2.setVisibility(View.GONE);
                    lineacsdose2.setVisibility(View.GONE);
                    rdogrpacsdose2.clearCheck();
                    secacsdose2Oth.setVisibility(View.GONE);
                    lineacsdose2Oth.setVisibility(View.GONE);
                    txtacsdose2Oth.setText("");
                    secacsadm3.setVisibility(View.GONE);
                    lineacsadm3.setVisibility(View.GONE);
                    rdogrpacsadm3.clearCheck();
                    secdtacsadm3.setVisibility(View.GONE);
                    linedtacsadm3.setVisibility(View.GONE);
                    dtpdtacsadm3.setText("");
                    sectmacsadm3.setVisibility(View.GONE);
                    linetmacsadm3.setVisibility(View.GONE);
                    txttmacsadm3.setText("");
                    secacsdose3.setVisibility(View.GONE);
                    lineacsdose3.setVisibility(View.GONE);
                    rdogrpacsdose3.clearCheck();
                    secacsdose3Oth.setVisibility(View.GONE);
                    lineacsdose3Oth.setVisibility(View.GONE);
                    txtacsdose3Oth.setText("");
                    secacsadm4.setVisibility(View.GONE);
                    lineacsadm4.setVisibility(View.GONE);
                    rdogrpacsadm4.clearCheck();
                    secdtacsadm4.setVisibility(View.GONE);
                    linedtacsadm4.setVisibility(View.GONE);
                    dtpdtacsadm4.setText("");
                    sectmacsadm4.setVisibility(View.GONE);
                    linetmacsadm4.setVisibility(View.GONE);
                    txttmacsadm4.setText("");
                    secacsdose4.setVisibility(View.GONE);
                    lineacsdose4.setVisibility(View.GONE);
                    rdogrpacsdose4.clearCheck();
                    secacsdose4Oth.setVisibility(View.GONE);
                    lineacsdose4Oth.setVisibility(View.GONE);
                    txtacsdose4Oth.setText("");
                    secacsfurther.setVisibility(View.GONE);
                    lineacsfurther.setVisibility(View.GONE);
                    rdogrpacsfurther.clearCheck();
                    secdtacsfurther.setVisibility(View.GONE);
                    linedtacsfurther.setVisibility(View.GONE);
                    dtpdtacsfurther.setText("");
                    sectmacsfurther.setVisibility(View.GONE);
                    linetmacsfurther.setVisibility(View.GONE);
                    txttmacsfurther.setText("");
                    secacsdosefurther.setVisibility(View.GONE);
                    lineacsdosefurther.setVisibility(View.GONE);
                    rdogrpacsdosefurther.clearCheck();
                    secacsdosefurtherOth.setVisibility(View.GONE);
                    lineacsdosefurtherOth.setVisibility(View.GONE);
                    txtacsdosefurtherOth.setText("");

                    secdtacsm2Not.setVisibility(View.GONE);
                    rdogrpdtacsm2Not.clearCheck();
                    sectmacsm2Not.setVisibility(View.GONE);
                    rdogrptmacsm2Not.clearCheck();
                    secdtacsadm3Not.setVisibility(View.GONE);
                    rdogrpdtacsadm3Not.clearCheck();
                    sectmacsadm3Not.setVisibility(View.GONE);
                    rdogrptmacsadm3Not.clearCheck();
                    secdtacsadm4Not.setVisibility(View.GONE);
                    rdogrpdtacsadm4Not.clearCheck();
                    sectmacsadm4Not.setVisibility(View.GONE);
                    rdogrptmacsadm4Not.clearCheck();
                    secdtacsfurtherNot.setVisibility(View.GONE);
                    rdogrpdtacsfurtherNot.clearCheck();
                 sectmacsfurtherNot.setVisibility(View.GONE);
                 rdogrptmacsfurtherNot.clearCheck();
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secdtacsm2.setVisibility(View.GONE);
                    linedtacsm2.setVisibility(View.GONE);
                    dtpdtacsm2.setText("");
                    sectmacsm2.setVisibility(View.GONE);
                    linetmacsm2.setVisibility(View.GONE);
                    txttmacsm2.setText("");
                    secacsdose2.setVisibility(View.GONE);
                    lineacsdose2.setVisibility(View.GONE);
                    rdogrpacsdose2.clearCheck();
                    secacsdose2Oth.setVisibility(View.GONE);
                    lineacsdose2Oth.setVisibility(View.GONE);
                    txtacsdose2Oth.setText("");
                    secacsadm3.setVisibility(View.GONE);
                    lineacsadm3.setVisibility(View.GONE);
                    rdogrpacsadm3.clearCheck();
                    secdtacsadm3.setVisibility(View.GONE);
                    linedtacsadm3.setVisibility(View.GONE);
                    dtpdtacsadm3.setText("");
                    sectmacsadm3.setVisibility(View.GONE);
                    linetmacsadm3.setVisibility(View.GONE);
                    txttmacsadm3.setText("");
                    secacsdose3.setVisibility(View.GONE);
                    lineacsdose3.setVisibility(View.GONE);
                    rdogrpacsdose3.clearCheck();
                    secacsdose3Oth.setVisibility(View.GONE);
                    lineacsdose3Oth.setVisibility(View.GONE);
                    txtacsdose3Oth.setText("");
                    secacsadm4.setVisibility(View.GONE);
                    lineacsadm4.setVisibility(View.GONE);
                    rdogrpacsadm4.clearCheck();
                    secdtacsadm4.setVisibility(View.GONE);
                    linedtacsadm4.setVisibility(View.GONE);
                    dtpdtacsadm4.setText("");
                    sectmacsadm4.setVisibility(View.GONE);
                    linetmacsadm4.setVisibility(View.GONE);
                    txttmacsadm4.setText("");
                    secacsdose4.setVisibility(View.GONE);
                    lineacsdose4.setVisibility(View.GONE);
                    rdogrpacsdose4.clearCheck();
                    secacsdose4Oth.setVisibility(View.GONE);
                    lineacsdose4Oth.setVisibility(View.GONE);
                    txtacsdose4Oth.setText("");
                    secacsfurther.setVisibility(View.GONE);
                    lineacsfurther.setVisibility(View.GONE);
                    rdogrpacsfurther.clearCheck();
                    secdtacsfurther.setVisibility(View.GONE);
                    linedtacsfurther.setVisibility(View.GONE);
                    dtpdtacsfurther.setText("");
                    sectmacsfurther.setVisibility(View.GONE);
                    linetmacsfurther.setVisibility(View.GONE);
                    txttmacsfurther.setText("");
                    secacsdosefurther.setVisibility(View.GONE);
                    lineacsdosefurther.setVisibility(View.GONE);
                    rdogrpacsdosefurther.clearCheck();
                    secacsdosefurtherOth.setVisibility(View.GONE);
                    lineacsdosefurtherOth.setVisibility(View.GONE);
                    txtacsdosefurtherOth.setText("");

                 secdtacsm2Not.setVisibility(View.GONE);
                 rdogrpdtacsm2Not.clearCheck();
                 sectmacsm2Not.setVisibility(View.GONE);
                 rdogrptmacsm2Not.clearCheck();
                 secdtacsadm3Not.setVisibility(View.GONE);
                 rdogrpdtacsadm3Not.clearCheck();
                 sectmacsadm3Not.setVisibility(View.GONE);
                 rdogrptmacsadm3Not.clearCheck();
                 secdtacsadm4Not.setVisibility(View.GONE);
                 rdogrpdtacsadm4Not.clearCheck();
                 sectmacsadm4Not.setVisibility(View.GONE);
                 rdogrptmacsadm4Not.clearCheck();
                 secdtacsfurtherNot.setVisibility(View.GONE);
                 rdogrpdtacsfurtherNot.clearCheck();
                 sectmacsfurtherNot.setVisibility(View.GONE);
                 rdogrptmacsfurtherNot.clearCheck();
             }
             else if(rbData.equalsIgnoreCase("9"))
             {
                    secdtacsm2.setVisibility(View.GONE);
                    linedtacsm2.setVisibility(View.GONE);
                    dtpdtacsm2.setText("");
                    sectmacsm2.setVisibility(View.GONE);
                    linetmacsm2.setVisibility(View.GONE);
                    txttmacsm2.setText("");
                    secacsdose2.setVisibility(View.GONE);
                    lineacsdose2.setVisibility(View.GONE);
                    rdogrpacsdose2.clearCheck();
                    secacsdose2Oth.setVisibility(View.GONE);
                    lineacsdose2Oth.setVisibility(View.GONE);
                    txtacsdose2Oth.setText("");
                    secacsadm3.setVisibility(View.GONE);
                    lineacsadm3.setVisibility(View.GONE);
                    rdogrpacsadm3.clearCheck();
                    secdtacsadm3.setVisibility(View.GONE);
                    linedtacsadm3.setVisibility(View.GONE);
                    dtpdtacsadm3.setText("");
                    sectmacsadm3.setVisibility(View.GONE);
                    linetmacsadm3.setVisibility(View.GONE);
                    txttmacsadm3.setText("");
                    secacsdose3.setVisibility(View.GONE);
                    lineacsdose3.setVisibility(View.GONE);
                    rdogrpacsdose3.clearCheck();
                    secacsdose3Oth.setVisibility(View.GONE);
                    lineacsdose3Oth.setVisibility(View.GONE);
                    txtacsdose3Oth.setText("");
                    secacsadm4.setVisibility(View.GONE);
                    lineacsadm4.setVisibility(View.GONE);
                    rdogrpacsadm4.clearCheck();
                    secdtacsadm4.setVisibility(View.GONE);
                    linedtacsadm4.setVisibility(View.GONE);
                    dtpdtacsadm4.setText("");
                    sectmacsadm4.setVisibility(View.GONE);
                    linetmacsadm4.setVisibility(View.GONE);
                    txttmacsadm4.setText("");
                    secacsdose4.setVisibility(View.GONE);
                    lineacsdose4.setVisibility(View.GONE);
                    rdogrpacsdose4.clearCheck();
                    secacsdose4Oth.setVisibility(View.GONE);
                    lineacsdose4Oth.setVisibility(View.GONE);
                    txtacsdose4Oth.setText("");
                    secacsfurther.setVisibility(View.GONE);
                    lineacsfurther.setVisibility(View.GONE);
                    rdogrpacsfurther.clearCheck();
                    secdtacsfurther.setVisibility(View.GONE);
                    linedtacsfurther.setVisibility(View.GONE);
                    dtpdtacsfurther.setText("");
                    sectmacsfurther.setVisibility(View.GONE);
                    linetmacsfurther.setVisibility(View.GONE);
                    txttmacsfurther.setText("");
                    secacsdosefurther.setVisibility(View.GONE);
                    lineacsdosefurther.setVisibility(View.GONE);
                    rdogrpacsdosefurther.clearCheck();
                    secacsdosefurtherOth.setVisibility(View.GONE);
                    lineacsdosefurtherOth.setVisibility(View.GONE);
                    txtacsdosefurtherOth.setText("");

                 secdtacsm2Not.setVisibility(View.GONE);
                 rdogrpdtacsm2Not.clearCheck();
                 sectmacsm2Not.setVisibility(View.GONE);
                 rdogrptmacsm2Not.clearCheck();
                 secdtacsadm3Not.setVisibility(View.GONE);
                 rdogrpdtacsadm3Not.clearCheck();
                 sectmacsadm3Not.setVisibility(View.GONE);
                 rdogrptmacsadm3Not.clearCheck();
                 secdtacsadm4Not.setVisibility(View.GONE);
                 rdogrpdtacsadm4Not.clearCheck();
                 sectmacsadm4Not.setVisibility(View.GONE);
                 rdogrptmacsadm4Not.clearCheck();
                 secdtacsfurtherNot.setVisibility(View.GONE);
                 rdogrpdtacsfurtherNot.clearCheck();
                 sectmacsfurtherNot.setVisibility(View.GONE);
                 rdogrptmacsfurtherNot.clearCheck();
             }
             else
             {
                    secdtacsm2.setVisibility(View.VISIBLE);
                    linedtacsm2.setVisibility(View.VISIBLE);
                    sectmacsm2.setVisibility(View.VISIBLE);
                    linetmacsm2.setVisibility(View.VISIBLE);
                    secacsdose2.setVisibility(View.VISIBLE);
                    lineacsdose2.setVisibility(View.VISIBLE);
                    secacsdose2Oth.setVisibility(View.VISIBLE);
                    lineacsdose2Oth.setVisibility(View.VISIBLE);
                    secacsadm3.setVisibility(View.VISIBLE);
                    lineacsadm3.setVisibility(View.VISIBLE);
                    secdtacsadm3.setVisibility(View.VISIBLE);
                    linedtacsadm3.setVisibility(View.VISIBLE);
                    sectmacsadm3.setVisibility(View.VISIBLE);
                    linetmacsadm3.setVisibility(View.VISIBLE);
                    secacsdose3.setVisibility(View.VISIBLE);
                    lineacsdose3.setVisibility(View.VISIBLE);
                    secacsdose3Oth.setVisibility(View.VISIBLE);
                    lineacsdose3Oth.setVisibility(View.VISIBLE);
                    secacsadm4.setVisibility(View.VISIBLE);
                    lineacsadm4.setVisibility(View.VISIBLE);
                    secdtacsadm4.setVisibility(View.VISIBLE);
                    linedtacsadm4.setVisibility(View.VISIBLE);
                    sectmacsadm4.setVisibility(View.VISIBLE);
                    linetmacsadm4.setVisibility(View.VISIBLE);
                    secacsdose4.setVisibility(View.VISIBLE);
                    lineacsdose4.setVisibility(View.VISIBLE);
                    secacsdose4Oth.setVisibility(View.VISIBLE);
                    lineacsdose4Oth.setVisibility(View.VISIBLE);
                    secacsfurther.setVisibility(View.VISIBLE);
                    lineacsfurther.setVisibility(View.VISIBLE);
                    secdtacsfurther.setVisibility(View.VISIBLE);
                    linedtacsfurther.setVisibility(View.VISIBLE);
                    sectmacsfurther.setVisibility(View.VISIBLE);
                    linetmacsfurther.setVisibility(View.VISIBLE);
                    secacsdosefurther.setVisibility(View.VISIBLE);
                    lineacsdosefurther.setVisibility(View.VISIBLE);

                 secdtacsm2Not.setVisibility(View.VISIBLE);
                 sectmacsm2Not.setVisibility(View.VISIBLE);
                 secdtacsadm3Not.setVisibility(View.VISIBLE);
                 sectmacsadm3Not.setVisibility(View.VISIBLE);
                 secdtacsadm4Not.setVisibility(View.VISIBLE);
                 sectmacsadm4Not.setVisibility(View.VISIBLE);
                 secdtacsfurtherNot.setVisibility(View.VISIBLE);
                 sectmacsfurtherNot.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            }
         });
         secdtacsm2=(LinearLayout)findViewById(R.id.secdtacsm2);
         linedtacsm2=(View)findViewById(R.id.linedtacsm2);
         Vlbldtacsm2=(TextView) findViewById(R.id.Vlbldtacsm2);
         dtpdtacsm2=(EditText) findViewById(R.id.dtpdtacsm2);
         rdogrpdtacsm2Not=(RadioGroup)findViewById(R.id.rdogrpdtacsm2Not) ;
         rdodtacsm2Not1=(RadioButton)findViewById(R.id.rdodtacsm2Not1);
         rdodtacsm2Not2=(RadioButton)findViewById(R.id.rdodtacsm2Not2);

         sectmacsm2=(LinearLayout)findViewById(R.id.sectmacsm2);
         linetmacsm2=(View)findViewById(R.id.linetmacsm2);
         Vlbltmacsm2=(TextView) findViewById(R.id.Vlbltmacsm2);
         txttmacsm2=(EditText) findViewById(R.id.txttmacsm2);

         rdogrptmacsm2Not=(RadioGroup)findViewById(R.id.rdogrptmacsm2Not) ;
         rdotmacsm2Not1=(RadioButton)findViewById(R.id.rdotmacsm2Not1);
         rdotmacsm2Not2=(RadioButton)findViewById(R.id.rdotmacsm2Not2);

         secacsdose2=(LinearLayout)findViewById(R.id.secacsdose2);
         lineacsdose2=(View)findViewById(R.id.lineacsdose2);
         Vlblacsdose2 = (TextView) findViewById(R.id.Vlblacsdose2);
         rdogrpacsdose2 = (RadioGroup) findViewById(R.id.rdogrpacsdose2);

         rdoacsdose21 = (RadioButton) findViewById(R.id.rdoacsdose21);
         rdoacsdose22 = (RadioButton) findViewById(R.id.rdoacsdose22);
         rdoacsdose23 = (RadioButton) findViewById(R.id.rdoacsdose23);
         rdoacsdose24 = (RadioButton) findViewById(R.id.rdoacsdose24);
         rdoacsdose25 = (RadioButton) findViewById(R.id.rdoacsdose25);
         rdogrpacsdose2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpacsdose2 = new String[] {"1","2","8","9","7"};
             for (int i = 0; i < rdogrpacsdose2.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpacsdose2.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpacsdose2[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                    secacsdose2Oth.setVisibility(View.GONE);
                    lineacsdose2Oth.setVisibility(View.GONE);
                    txtacsdose2Oth.setText("");
             }
             else if(rbData.equalsIgnoreCase("2"))
             {
                    secacsdose2Oth.setVisibility(View.GONE);
                    lineacsdose2Oth.setVisibility(View.GONE);
                    txtacsdose2Oth.setText("");
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secacsdose2Oth.setVisibility(View.GONE);
                    lineacsdose2Oth.setVisibility(View.GONE);
                    txtacsdose2Oth.setText("");
             }
             else if(rbData.equalsIgnoreCase("9"))
             {
                    secacsdose2Oth.setVisibility(View.GONE);
                    lineacsdose2Oth.setVisibility(View.GONE);
                    txtacsdose2Oth.setText("");
             }
             else
             {
                    secacsdose2Oth.setVisibility(View.VISIBLE);
                    lineacsdose2Oth.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            }
         });
         secacsdose2Oth=(LinearLayout)findViewById(R.id.secacsdose2Oth);
         lineacsdose2Oth=(View)findViewById(R.id.lineacsdose2Oth);
         Vlblacsdose2Oth=(TextView) findViewById(R.id.Vlblacsdose2Oth);
         txtacsdose2Oth=(EditText) findViewById(R.id.txtacsdose2Oth);
         secacsadm3=(LinearLayout)findViewById(R.id.secacsadm3);
         lineacsadm3=(View)findViewById(R.id.lineacsadm3);
         Vlblacsadm3 = (TextView) findViewById(R.id.Vlblacsadm3);
         rdogrpacsadm3 = (RadioGroup) findViewById(R.id.rdogrpacsadm3);

         rdoacsadm31 = (RadioButton) findViewById(R.id.rdoacsadm31);
         rdoacsadm32 = (RadioButton) findViewById(R.id.rdoacsadm32);
         rdoacsadm33 = (RadioButton) findViewById(R.id.rdoacsadm33);
         rdoacsadm34 = (RadioButton) findViewById(R.id.rdoacsadm34);
         rdogrpacsadm3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpacsadm3 = new String[] {"1","2","8","9"};
             for (int i = 0; i < rdogrpacsadm3.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpacsadm3.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpacsadm3[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secdtacsadm3.setVisibility(View.GONE);
                    linedtacsadm3.setVisibility(View.GONE);
                    dtpdtacsadm3.setText("");
                    sectmacsadm3.setVisibility(View.GONE);
                    linetmacsadm3.setVisibility(View.GONE);
                    txttmacsadm3.setText("");
                    secacsdose3.setVisibility(View.GONE);
                    lineacsdose3.setVisibility(View.GONE);
                    rdogrpacsdose3.clearCheck();
                    secacsdose3Oth.setVisibility(View.GONE);
                    lineacsdose3Oth.setVisibility(View.GONE);
                    txtacsdose3Oth.setText("");
                    secacsadm4.setVisibility(View.GONE);
                    lineacsadm4.setVisibility(View.GONE);
                    rdogrpacsadm4.clearCheck();
                    secdtacsadm4.setVisibility(View.GONE);
                    linedtacsadm4.setVisibility(View.GONE);
                    dtpdtacsadm4.setText("");
                    sectmacsadm4.setVisibility(View.GONE);
                    linetmacsadm4.setVisibility(View.GONE);
                    txttmacsadm4.setText("");
                    secacsdose4.setVisibility(View.GONE);
                    lineacsdose4.setVisibility(View.GONE);
                    rdogrpacsdose4.clearCheck();
                    secacsdose4Oth.setVisibility(View.GONE);
                    lineacsdose4Oth.setVisibility(View.GONE);
                    txtacsdose4Oth.setText("");
                    secacsfurther.setVisibility(View.GONE);
                    lineacsfurther.setVisibility(View.GONE);
                    rdogrpacsfurther.clearCheck();
                    secdtacsfurther.setVisibility(View.GONE);
                    linedtacsfurther.setVisibility(View.GONE);
                    dtpdtacsfurther.setText("");
                    sectmacsfurther.setVisibility(View.GONE);
                    linetmacsfurther.setVisibility(View.GONE);
                    txttmacsfurther.setText("");
                    secacsdosefurther.setVisibility(View.GONE);
                    lineacsdosefurther.setVisibility(View.GONE);
                    rdogrpacsdosefurther.clearCheck();
                    secacsdosefurtherOth.setVisibility(View.GONE);
                    lineacsdosefurtherOth.setVisibility(View.GONE);
                    txtacsdosefurtherOth.setText("");
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secdtacsadm3.setVisibility(View.GONE);
                    linedtacsadm3.setVisibility(View.GONE);
                    dtpdtacsadm3.setText("");
                    sectmacsadm3.setVisibility(View.GONE);
                    linetmacsadm3.setVisibility(View.GONE);
                    txttmacsadm3.setText("");
                    secacsdose3.setVisibility(View.GONE);
                    lineacsdose3.setVisibility(View.GONE);
                    rdogrpacsdose3.clearCheck();
                    secacsdose3Oth.setVisibility(View.GONE);
                    lineacsdose3Oth.setVisibility(View.GONE);
                    txtacsdose3Oth.setText("");
                    secacsadm4.setVisibility(View.GONE);
                    lineacsadm4.setVisibility(View.GONE);
                    rdogrpacsadm4.clearCheck();
                    secdtacsadm4.setVisibility(View.GONE);
                    linedtacsadm4.setVisibility(View.GONE);
                    dtpdtacsadm4.setText("");
                    sectmacsadm4.setVisibility(View.GONE);
                    linetmacsadm4.setVisibility(View.GONE);
                    txttmacsadm4.setText("");
                    secacsdose4.setVisibility(View.GONE);
                    lineacsdose4.setVisibility(View.GONE);
                    rdogrpacsdose4.clearCheck();
                    secacsdose4Oth.setVisibility(View.GONE);
                    lineacsdose4Oth.setVisibility(View.GONE);
                    txtacsdose4Oth.setText("");
                    secacsfurther.setVisibility(View.GONE);
                    lineacsfurther.setVisibility(View.GONE);
                    rdogrpacsfurther.clearCheck();
                    secdtacsfurther.setVisibility(View.GONE);
                    linedtacsfurther.setVisibility(View.GONE);
                    dtpdtacsfurther.setText("");
                    sectmacsfurther.setVisibility(View.GONE);
                    linetmacsfurther.setVisibility(View.GONE);
                    txttmacsfurther.setText("");
                    secacsdosefurther.setVisibility(View.GONE);
                    lineacsdosefurther.setVisibility(View.GONE);
                    rdogrpacsdosefurther.clearCheck();
                    secacsdosefurtherOth.setVisibility(View.GONE);
                    lineacsdosefurtherOth.setVisibility(View.GONE);
                    txtacsdosefurtherOth.setText("");
             }
             else if(rbData.equalsIgnoreCase("9"))
             {
                    secdtacsadm3.setVisibility(View.GONE);
                    linedtacsadm3.setVisibility(View.GONE);
                    dtpdtacsadm3.setText("");
                    sectmacsadm3.setVisibility(View.GONE);
                    linetmacsadm3.setVisibility(View.GONE);
                    txttmacsadm3.setText("");
                    secacsdose3.setVisibility(View.GONE);
                    lineacsdose3.setVisibility(View.GONE);
                    rdogrpacsdose3.clearCheck();
                    secacsdose3Oth.setVisibility(View.GONE);
                    lineacsdose3Oth.setVisibility(View.GONE);
                    txtacsdose3Oth.setText("");
                    secacsadm4.setVisibility(View.GONE);
                    lineacsadm4.setVisibility(View.GONE);
                    rdogrpacsadm4.clearCheck();
                    secdtacsadm4.setVisibility(View.GONE);
                    linedtacsadm4.setVisibility(View.GONE);
                    dtpdtacsadm4.setText("");
                    sectmacsadm4.setVisibility(View.GONE);
                    linetmacsadm4.setVisibility(View.GONE);
                    txttmacsadm4.setText("");
                    secacsdose4.setVisibility(View.GONE);
                    lineacsdose4.setVisibility(View.GONE);
                    rdogrpacsdose4.clearCheck();
                    secacsdose4Oth.setVisibility(View.GONE);
                    lineacsdose4Oth.setVisibility(View.GONE);
                    txtacsdose4Oth.setText("");
                    secacsfurther.setVisibility(View.GONE);
                    lineacsfurther.setVisibility(View.GONE);
                    rdogrpacsfurther.clearCheck();
                    secdtacsfurther.setVisibility(View.GONE);
                    linedtacsfurther.setVisibility(View.GONE);
                    dtpdtacsfurther.setText("");
                    sectmacsfurther.setVisibility(View.GONE);
                    linetmacsfurther.setVisibility(View.GONE);
                    txttmacsfurther.setText("");
                    secacsdosefurther.setVisibility(View.GONE);
                    lineacsdosefurther.setVisibility(View.GONE);
                    rdogrpacsdosefurther.clearCheck();
                    secacsdosefurtherOth.setVisibility(View.GONE);
                    lineacsdosefurtherOth.setVisibility(View.GONE);
                    txtacsdosefurtherOth.setText("");
             }
             else
             {
                    secdtacsadm3.setVisibility(View.VISIBLE);
                    linedtacsadm3.setVisibility(View.VISIBLE);
                    sectmacsadm3.setVisibility(View.VISIBLE);
                    linetmacsadm3.setVisibility(View.VISIBLE);
                    secacsdose3.setVisibility(View.VISIBLE);
                    lineacsdose3.setVisibility(View.VISIBLE);
                    secacsdose3Oth.setVisibility(View.VISIBLE);
                    lineacsdose3Oth.setVisibility(View.VISIBLE);
                    secacsadm4.setVisibility(View.VISIBLE);
                    lineacsadm4.setVisibility(View.VISIBLE);
                    secdtacsadm4.setVisibility(View.VISIBLE);
                    linedtacsadm4.setVisibility(View.VISIBLE);
                    sectmacsadm4.setVisibility(View.VISIBLE);
                    linetmacsadm4.setVisibility(View.VISIBLE);
                    secacsdose4.setVisibility(View.VISIBLE);
                    lineacsdose4.setVisibility(View.VISIBLE);
                    secacsdose4Oth.setVisibility(View.VISIBLE);
                    lineacsdose4Oth.setVisibility(View.VISIBLE);
                    secacsfurther.setVisibility(View.VISIBLE);
                    lineacsfurther.setVisibility(View.VISIBLE);
                    secdtacsfurther.setVisibility(View.VISIBLE);
                    linedtacsfurther.setVisibility(View.VISIBLE);
                    sectmacsfurther.setVisibility(View.VISIBLE);
                    linetmacsfurther.setVisibility(View.VISIBLE);
                    secacsdosefurther.setVisibility(View.VISIBLE);
                    lineacsdosefurther.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            }
         });
         secdtacsadm3=(LinearLayout)findViewById(R.id.secdtacsadm3);
         linedtacsadm3=(View)findViewById(R.id.linedtacsadm3);
         Vlbldtacsadm3=(TextView) findViewById(R.id.Vlbldtacsadm3);
         dtpdtacsadm3=(EditText) findViewById(R.id.dtpdtacsadm3);
         rdogrpdtacsadm3Not=(RadioGroup)findViewById(R.id.rdogrpdtacsadm3Not) ;
         rdodtacsadm3Not1=(RadioButton)findViewById(R.id.rdodtacsadm3Not1) ;
         rdodtacsadm3Not2=(RadioButton)findViewById(R.id.rdodtacsadm3Not2) ;

         sectmacsadm3=(LinearLayout)findViewById(R.id.sectmacsadm3);
         linetmacsadm3=(View)findViewById(R.id.linetmacsadm3);
         Vlbltmacsadm3=(TextView) findViewById(R.id.Vlbltmacsadm3);
         txttmacsadm3=(EditText) findViewById(R.id.txttmacsadm3);
         rdogrptmacsadm3Not=(RadioGroup)findViewById(R.id.rdogrptmacsadm3Not) ;
         rdotmacsadm3Not1=(RadioButton)findViewById(R.id.rdotmacsadm3Not1) ;
         rdotmacsadm3Not2=(RadioButton)findViewById(R.id.rdotmacsadm3Not2) ;

         secacsdose3=(LinearLayout)findViewById(R.id.secacsdose3);
         lineacsdose3=(View)findViewById(R.id.lineacsdose3);
         Vlblacsdose3 = (TextView) findViewById(R.id.Vlblacsdose3);
         rdogrpacsdose3 = (RadioGroup) findViewById(R.id.rdogrpacsdose3);

         rdoacsdose31 = (RadioButton) findViewById(R.id.rdoacsdose31);
         rdoacsdose32 = (RadioButton) findViewById(R.id.rdoacsdose32);
         rdoacsdose33 = (RadioButton) findViewById(R.id.rdoacsdose33);
         rdoacsdose34 = (RadioButton) findViewById(R.id.rdoacsdose34);
         rdoacsdose35 = (RadioButton) findViewById(R.id.rdoacsdose35);
         rdogrpacsdose3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpacsdose3 = new String[] {"1","2","8","9","7"};
             for (int i = 0; i < rdogrpacsdose3.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpacsdose3.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpacsdose3[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                    secacsdose3Oth.setVisibility(View.GONE);
                    lineacsdose3Oth.setVisibility(View.GONE);
                    txtacsdose3Oth.setText("");
             }
             else if(rbData.equalsIgnoreCase("2"))
             {
                    secacsdose3Oth.setVisibility(View.GONE);
                    lineacsdose3Oth.setVisibility(View.GONE);
                    txtacsdose3Oth.setText("");
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secacsdose3Oth.setVisibility(View.GONE);
                    lineacsdose3Oth.setVisibility(View.GONE);
                    txtacsdose3Oth.setText("");
             }
             else if(rbData.equalsIgnoreCase("9"))
             {
                    secacsdose3Oth.setVisibility(View.GONE);
                    lineacsdose3Oth.setVisibility(View.GONE);
                    txtacsdose3Oth.setText("");
             }
             else
             {
                    secacsdose3Oth.setVisibility(View.VISIBLE);
                    lineacsdose3Oth.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            }
         });
         secacsdose3Oth=(LinearLayout)findViewById(R.id.secacsdose3Oth);
         lineacsdose3Oth=(View)findViewById(R.id.lineacsdose3Oth);
         Vlblacsdose3Oth=(TextView) findViewById(R.id.Vlblacsdose3Oth);
         txtacsdose3Oth=(EditText) findViewById(R.id.txtacsdose3Oth);
         secacsadm4=(LinearLayout)findViewById(R.id.secacsadm4);
         lineacsadm4=(View)findViewById(R.id.lineacsadm4);
         Vlblacsadm4 = (TextView) findViewById(R.id.Vlblacsadm4);
         rdogrpacsadm4 = (RadioGroup) findViewById(R.id.rdogrpacsadm4);

         rdoacsadm41 = (RadioButton) findViewById(R.id.rdoacsadm41);
         rdoacsadm42 = (RadioButton) findViewById(R.id.rdoacsadm42);
         rdoacsadm43 = (RadioButton) findViewById(R.id.rdoacsadm43);
         rdoacsadm44 = (RadioButton) findViewById(R.id.rdoacsadm44);
         rdogrpacsadm4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpacsadm4 = new String[] {"1","2","8","9"};
             for (int i = 0; i < rdogrpacsadm4.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpacsadm4.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpacsadm4[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secdtacsadm4.setVisibility(View.GONE);
                    linedtacsadm4.setVisibility(View.GONE);
                    dtpdtacsadm4.setText("");
                    sectmacsadm4.setVisibility(View.GONE);
                    linetmacsadm4.setVisibility(View.GONE);
                    txttmacsadm4.setText("");
                    secacsdose4.setVisibility(View.GONE);
                    lineacsdose4.setVisibility(View.GONE);
                    rdogrpacsdose4.clearCheck();
                    secacsdose4Oth.setVisibility(View.GONE);
                    lineacsdose4Oth.setVisibility(View.GONE);
                    txtacsdose4Oth.setText("");
                    secacsfurther.setVisibility(View.GONE);
                    lineacsfurther.setVisibility(View.GONE);
                    rdogrpacsfurther.clearCheck();
                    secdtacsfurther.setVisibility(View.GONE);
                    linedtacsfurther.setVisibility(View.GONE);
                    dtpdtacsfurther.setText("");
                    sectmacsfurther.setVisibility(View.GONE);
                    linetmacsfurther.setVisibility(View.GONE);
                    txttmacsfurther.setText("");
                    secacsdosefurther.setVisibility(View.GONE);
                    lineacsdosefurther.setVisibility(View.GONE);
                    rdogrpacsdosefurther.clearCheck();
                    secacsdosefurtherOth.setVisibility(View.GONE);
                    lineacsdosefurtherOth.setVisibility(View.GONE);
                    txtacsdosefurtherOth.setText("");
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secdtacsadm4.setVisibility(View.GONE);
                    linedtacsadm4.setVisibility(View.GONE);
                    dtpdtacsadm4.setText("");
                    sectmacsadm4.setVisibility(View.GONE);
                    linetmacsadm4.setVisibility(View.GONE);
                    txttmacsadm4.setText("");
                    secacsdose4.setVisibility(View.GONE);
                    lineacsdose4.setVisibility(View.GONE);
                    rdogrpacsdose4.clearCheck();
                    secacsdose4Oth.setVisibility(View.GONE);
                    lineacsdose4Oth.setVisibility(View.GONE);
                    txtacsdose4Oth.setText("");
                    secacsfurther.setVisibility(View.GONE);
                    lineacsfurther.setVisibility(View.GONE);
                    rdogrpacsfurther.clearCheck();
                    secdtacsfurther.setVisibility(View.GONE);
                    linedtacsfurther.setVisibility(View.GONE);
                    dtpdtacsfurther.setText("");
                    sectmacsfurther.setVisibility(View.GONE);
                    linetmacsfurther.setVisibility(View.GONE);
                    txttmacsfurther.setText("");
                    secacsdosefurther.setVisibility(View.GONE);
                    lineacsdosefurther.setVisibility(View.GONE);
                    rdogrpacsdosefurther.clearCheck();
                    secacsdosefurtherOth.setVisibility(View.GONE);
                    lineacsdosefurtherOth.setVisibility(View.GONE);
                    txtacsdosefurtherOth.setText("");
             }
             else if(rbData.equalsIgnoreCase("9"))
             {
                    secdtacsadm4.setVisibility(View.GONE);
                    linedtacsadm4.setVisibility(View.GONE);
                    dtpdtacsadm4.setText("");
                    sectmacsadm4.setVisibility(View.GONE);
                    linetmacsadm4.setVisibility(View.GONE);
                    txttmacsadm4.setText("");
                    secacsdose4.setVisibility(View.GONE);
                    lineacsdose4.setVisibility(View.GONE);
                    rdogrpacsdose4.clearCheck();
                    secacsdose4Oth.setVisibility(View.GONE);
                    lineacsdose4Oth.setVisibility(View.GONE);
                    txtacsdose4Oth.setText("");
                    secacsfurther.setVisibility(View.GONE);
                    lineacsfurther.setVisibility(View.GONE);
                    rdogrpacsfurther.clearCheck();
                    secdtacsfurther.setVisibility(View.GONE);
                    linedtacsfurther.setVisibility(View.GONE);
                    dtpdtacsfurther.setText("");
                    sectmacsfurther.setVisibility(View.GONE);
                    linetmacsfurther.setVisibility(View.GONE);
                    txttmacsfurther.setText("");
                    secacsdosefurther.setVisibility(View.GONE);
                    lineacsdosefurther.setVisibility(View.GONE);
                    rdogrpacsdosefurther.clearCheck();
                    secacsdosefurtherOth.setVisibility(View.GONE);
                    lineacsdosefurtherOth.setVisibility(View.GONE);
                    txtacsdosefurtherOth.setText("");
             }
             else
             {
                    secdtacsadm4.setVisibility(View.VISIBLE);
                    linedtacsadm4.setVisibility(View.VISIBLE);
                    sectmacsadm4.setVisibility(View.VISIBLE);
                    linetmacsadm4.setVisibility(View.VISIBLE);
                    secacsdose4.setVisibility(View.VISIBLE);
                    lineacsdose4.setVisibility(View.VISIBLE);
                    secacsdose4Oth.setVisibility(View.VISIBLE);
                    lineacsdose4Oth.setVisibility(View.VISIBLE);
                    secacsfurther.setVisibility(View.VISIBLE);
                    lineacsfurther.setVisibility(View.VISIBLE);
                    secdtacsfurther.setVisibility(View.VISIBLE);
                    linedtacsfurther.setVisibility(View.VISIBLE);
                    sectmacsfurther.setVisibility(View.VISIBLE);
                    linetmacsfurther.setVisibility(View.VISIBLE);
                    secacsdosefurther.setVisibility(View.VISIBLE);
                    lineacsdosefurther.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            }
         });
         secdtacsadm4=(LinearLayout)findViewById(R.id.secdtacsadm4);
         linedtacsadm4=(View)findViewById(R.id.linedtacsadm4);
         Vlbldtacsadm4=(TextView) findViewById(R.id.Vlbldtacsadm4);
         dtpdtacsadm4=(EditText) findViewById(R.id.dtpdtacsadm4);
         rdogrpdtacsadm4Not=(RadioGroup)findViewById(R.id.rdogrpdtacsadm4Not) ;
         rdodtacsadm4Not1=(RadioButton)findViewById(R.id.rdodtacsadm4Not1) ;
         rdodtacsadm4Not2=(RadioButton)findViewById(R.id.rdodtacsadm4Not2) ;

         sectmacsadm4=(LinearLayout)findViewById(R.id.sectmacsadm4);
         linetmacsadm4=(View)findViewById(R.id.linetmacsadm4);
         Vlbltmacsadm4=(TextView) findViewById(R.id.Vlbltmacsadm4);
         txttmacsadm4=(EditText) findViewById(R.id.txttmacsadm4);
         rdogrptmacsadm4Not=(RadioGroup)findViewById(R.id.rdogrptmacsadm4Not) ;
         rdotmacsadm4Not1=(RadioButton)findViewById(R.id.rdotmacsadm4Not1) ;
         rdotmacsadm4Not2=(RadioButton)findViewById(R.id.rdotmacsadm4Not2) ;

         secacsdose4=(LinearLayout)findViewById(R.id.secacsdose4);
         lineacsdose4=(View)findViewById(R.id.lineacsdose4);
         Vlblacsdose4 = (TextView) findViewById(R.id.Vlblacsdose4);
         rdogrpacsdose4 = (RadioGroup) findViewById(R.id.rdogrpacsdose4);

         rdoacsdose41 = (RadioButton) findViewById(R.id.rdoacsdose41);
         rdoacsdose42 = (RadioButton) findViewById(R.id.rdoacsdose42);
         rdoacsdose43 = (RadioButton) findViewById(R.id.rdoacsdose43);
         rdoacsdose44 = (RadioButton) findViewById(R.id.rdoacsdose44);
         rdoacsdose45 = (RadioButton) findViewById(R.id.rdoacsdose45);
         rdogrpacsdose4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpacsdose4 = new String[] {"1","2","8","9","7"};
             for (int i = 0; i < rdogrpacsdose4.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpacsdose4.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpacsdose4[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                    secacsdose4Oth.setVisibility(View.GONE);
                    lineacsdose4Oth.setVisibility(View.GONE);
                    txtacsdose4Oth.setText("");
             }
             else if(rbData.equalsIgnoreCase("2"))
             {
                    secacsdose4Oth.setVisibility(View.GONE);
                    lineacsdose4Oth.setVisibility(View.GONE);
                    txtacsdose4Oth.setText("");
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secacsdose4Oth.setVisibility(View.GONE);
                    lineacsdose4Oth.setVisibility(View.GONE);
                    txtacsdose4Oth.setText("");
             }
             else if(rbData.equalsIgnoreCase("9"))
             {
                    secacsdose4Oth.setVisibility(View.GONE);
                    lineacsdose4Oth.setVisibility(View.GONE);
                    txtacsdose4Oth.setText("");
             }
             else
             {
                    secacsdose4Oth.setVisibility(View.VISIBLE);
                    lineacsdose4Oth.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            }
         });
         secacsdose4Oth=(LinearLayout)findViewById(R.id.secacsdose4Oth);
         lineacsdose4Oth=(View)findViewById(R.id.lineacsdose4Oth);
         Vlblacsdose4Oth=(TextView) findViewById(R.id.Vlblacsdose4Oth);
         txtacsdose4Oth=(EditText) findViewById(R.id.txtacsdose4Oth);
         secacsfurther=(LinearLayout)findViewById(R.id.secacsfurther);
         lineacsfurther=(View)findViewById(R.id.lineacsfurther);
         Vlblacsfurther = (TextView) findViewById(R.id.Vlblacsfurther);
         rdogrpacsfurther = (RadioGroup) findViewById(R.id.rdogrpacsfurther);

         rdoacsfurther1 = (RadioButton) findViewById(R.id.rdoacsfurther1);
         rdoacsfurther2 = (RadioButton) findViewById(R.id.rdoacsfurther2);
         rdoacsfurther3 = (RadioButton) findViewById(R.id.rdoacsfurther3);
         rdoacsfurther4 = (RadioButton) findViewById(R.id.rdoacsfurther4);
         secdtacsfurther=(LinearLayout)findViewById(R.id.secdtacsfurther);
         linedtacsfurther=(View)findViewById(R.id.linedtacsfurther);
         Vlbldtacsfurther=(TextView) findViewById(R.id.Vlbldtacsfurther);
         dtpdtacsfurther=(EditText) findViewById(R.id.dtpdtacsfurther);
         rdogrpdtacsfurtherNot=(RadioGroup)findViewById(R.id.rdogrpdtacsfurtherNot) ;
         rdodtacsfurtherNot1=(RadioButton)findViewById(R.id.rdodtacsfurtherNot1) ;
         rdodtacsfurtherNot2=(RadioButton)findViewById(R.id.rdodtacsfurtherNot2) ;

         sectmacsfurther=(LinearLayout)findViewById(R.id.sectmacsfurther);
         linetmacsfurther=(View)findViewById(R.id.linetmacsfurther);
         Vlbltmacsfurther=(TextView) findViewById(R.id.Vlbltmacsfurther);
         txttmacsfurther=(EditText) findViewById(R.id.txttmacsfurther);
         rdogrptmacsfurtherNot=(RadioGroup)findViewById(R.id.rdogrptmacsfurtherNot) ;
         rdotmacsfurtherNot1=(RadioButton)findViewById(R.id.rdotmacsfurtherNot1) ;
         rdotmacsfurtherNot2=(RadioButton)findViewById(R.id.rdotmacsfurtherNot2) ;

         secacsdosefurther=(LinearLayout)findViewById(R.id.secacsdosefurther);
         lineacsdosefurther=(View)findViewById(R.id.lineacsdosefurther);
         Vlblacsdosefurther = (TextView) findViewById(R.id.Vlblacsdosefurther);
         rdogrpacsdosefurther = (RadioGroup) findViewById(R.id.rdogrpacsdosefurther);

         rdoacsdosefurther1 = (RadioButton) findViewById(R.id.rdoacsdosefurther1);
         rdoacsdosefurther2 = (RadioButton) findViewById(R.id.rdoacsdosefurther2);
         rdoacsdosefurther3 = (RadioButton) findViewById(R.id.rdoacsdosefurther3);
         rdoacsdosefurther4 = (RadioButton) findViewById(R.id.rdoacsdosefurther4);
         rdoacsdosefurther5 = (RadioButton) findViewById(R.id.rdoacsdosefurther5);
         rdogrpacsdosefurther.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpacsdosefurther = new String[] {"1","2","8","9","7"};
             for (int i = 0; i < rdogrpacsdosefurther.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpacsdosefurther.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpacsdosefurther[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                    secacsdosefurtherOth.setVisibility(View.GONE);
                    lineacsdosefurtherOth.setVisibility(View.GONE);
                    txtacsdosefurtherOth.setText("");
                    //seclblSectionIV.setVisibility(View.GONE);
                    //linelblSectionIV.setVisibility(View.GONE);
             }
             else if(rbData.equalsIgnoreCase("2"))
             {
                    secacsdosefurtherOth.setVisibility(View.GONE);
                    lineacsdosefurtherOth.setVisibility(View.GONE);
                    txtacsdosefurtherOth.setText("");
                    //seclblSectionIV.setVisibility(View.GONE);
                    //linelblSectionIV.setVisibility(View.GONE);
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secacsdosefurtherOth.setVisibility(View.GONE);
                    lineacsdosefurtherOth.setVisibility(View.GONE);
                    txtacsdosefurtherOth.setText("");
                    //seclblSectionIV.setVisibility(View.GONE);
                    //linelblSectionIV.setVisibility(View.GONE);
             }
             else if(rbData.equalsIgnoreCase("9"))
             {
                    secacsdosefurtherOth.setVisibility(View.GONE);
                    lineacsdosefurtherOth.setVisibility(View.GONE);
                    txtacsdosefurtherOth.setText("");
                    //seclblSectionIV.setVisibility(View.GONE);
                    //linelblSectionIV.setVisibility(View.GONE);
             }
             else
             {
                    secacsdosefurtherOth.setVisibility(View.VISIBLE);
                    lineacsdosefurtherOth.setVisibility(View.VISIBLE);
                    //seclblSectionIV.setVisibility(View.VISIBLE);
                    //linelblSectionIV.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            }
         });
         secacsdosefurtherOth=(LinearLayout)findViewById(R.id.secacsdosefurtherOth);
         lineacsdosefurtherOth=(View)findViewById(R.id.lineacsdosefurtherOth);
         VlblacsdosefurtherOth=(TextView) findViewById(R.id.VlblacsdosefurtherOth);
         txtacsdosefurtherOth=(EditText) findViewById(R.id.txtacsdosefurtherOth);
         seclblSectionIV=(LinearLayout)findViewById(R.id.seclblSectionIV);
         linelblSectionIV=(View)findViewById(R.id.linelblSectionIV);
         secga=(LinearLayout)findViewById(R.id.secga);
         linega=(View)findViewById(R.id.linega);
         Vlblga=(TextView) findViewById(R.id.Vlblga);
         txtga=(EditText) findViewById(R.id.txtga);
         secgar=(LinearLayout)findViewById(R.id.secgar);
         linegar=(View)findViewById(R.id.linegar);
         Vlblgar = (TextView) findViewById(R.id.Vlblgar);
         rdogrpgar = (RadioGroup) findViewById(R.id.rdogrpgar);

         rdogar1 = (RadioButton) findViewById(R.id.rdogar1);
         rdogar2 = (RadioButton) findViewById(R.id.rdogar2);
         secgamethod=(LinearLayout)findViewById(R.id.secgamethod);
         linegamethod=(View)findViewById(R.id.linegamethod);
         Vlblgamethod=(TextView) findViewById(R.id.Vlblgamethod);
         txtgamethod=(EditText) findViewById(R.id.txtgamethod);
         secgamethodr=(LinearLayout)findViewById(R.id.secgamethodr);
         linegamethodr=(View)findViewById(R.id.linegamethodr);
         Vlblgamethodr = (TextView) findViewById(R.id.Vlblgamethodr);
         rdogrpgamethodr = (RadioGroup) findViewById(R.id.rdogrpgamethodr);

         rdogamethodr1 = (RadioButton) findViewById(R.id.rdogamethodr1);
         rdogamethodr2 = (RadioButton) findViewById(R.id.rdogamethodr2);
         secbwt=(LinearLayout)findViewById(R.id.secbwt);
         linebwt=(View)findViewById(R.id.linebwt);
         Vlblbwt=(TextView) findViewById(R.id.Vlblbwt);
         txtbwt=(EditText) findViewById(R.id.txtbwt);
         secbwtr=(LinearLayout)findViewById(R.id.secbwtr);
         linebwtr=(View)findViewById(R.id.linebwtr);
         Vlblbwtr = (TextView) findViewById(R.id.Vlblbwtr);
         rdogrpbwtr = (RadioGroup) findViewById(R.id.rdogrpbwtr);

         rdobwtr1 = (RadioButton) findViewById(R.id.rdobwtr1);
         rdobwtr2 = (RadioButton) findViewById(R.id.rdobwtr2);
         secmatcond=(LinearLayout)findViewById(R.id.secmatcond);
         linematcond=(View)findViewById(R.id.linematcond);
         Vlblmatcond = (TextView) findViewById(R.id.Vlblmatcond);
         rdogrpmatcond = (RadioGroup) findViewById(R.id.rdogrpmatcond);

         rdomatcond1 = (RadioButton) findViewById(R.id.rdomatcond1);
         rdomatcond2 = (RadioButton) findViewById(R.id.rdomatcond2);
         rdomatcond3 = (RadioButton) findViewById(R.id.rdomatcond3);
         rdomatcond4 = (RadioButton) findViewById(R.id.rdomatcond4);
         secbadm=(LinearLayout)findViewById(R.id.secbadm);
         linebadm=(View)findViewById(R.id.linebadm);
         Vlblbadm = (TextView) findViewById(R.id.Vlblbadm);
         rdogrpbadm = (RadioGroup) findViewById(R.id.rdogrpbadm);

         rdobadm1 = (RadioButton) findViewById(R.id.rdobadm1);
         rdobadm2 = (RadioButton) findViewById(R.id.rdobadm2);
         rdobadm3 = (RadioButton) findViewById(R.id.rdobadm3);
         rdobadm4 = (RadioButton) findViewById(R.id.rdobadm4);
         rdobadm5 = (RadioButton) findViewById(R.id.rdobadm5);
         rdobadm6 = (RadioButton) findViewById(R.id.rdobadm6);
         secbcond=(LinearLayout)findViewById(R.id.secbcond);
         linebcond=(View)findViewById(R.id.linebcond);
         Vlblbcond = (TextView) findViewById(R.id.Vlblbcond);
         rdogrpbcond = (RadioGroup) findViewById(R.id.rdogrpbcond);

         rdobcond1 = (RadioButton) findViewById(R.id.rdobcond1);
         rdobcond2 = (RadioButton) findViewById(R.id.rdobcond2);
         rdobcond3 = (RadioButton) findViewById(R.id.rdobcond3);
         rdobcond4 = (RadioButton) findViewById(R.id.rdobcond4);

         rdobcond5 = (RadioButton) findViewById(R.id.rdobcond5);
         rdobcond6 = (RadioButton) findViewById(R.id.rdobcond6);
         rdobcond7 = (RadioButton) findViewById(R.id.rdobcond7);

         rdogrpbcond.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpbcond = new String[] {"1","2","3","4","5","8","9"};
             for (int i = 0; i < rdogrpbcond.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpbcond.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpbcond[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                    secstillbirthSp.setVisibility(View.GONE);
                    linestillbirthSp.setVisibility(View.GONE);
                    rdogrpstillbirthSp.clearCheck();
                    secdod.setVisibility(View.GONE);
                    linedod.setVisibility(View.GONE);
                    dtpdod.setText("");
                    secdeathtime.setVisibility(View.GONE);
                    linedeathtime.setVisibility(View.GONE);
                    txtdeathtime.setText("");
                    /*seclblStatus.setVisibility(View.GONE);
                    linelblStatus.setVisibility(View.GONE);
                    secstatus.setVisibility(View.GONE);
                    linestatus.setVisibility(View.GONE);
                    rdogrpstatus.clearCheck();
                    secreason.setVisibility(View.GONE);
                    linereason.setVisibility(View.GONE);
                    rdogrpreason.clearCheck();
                    secreasmention.setVisibility(View.GONE);
                    linereasmention.setVisibility(View.GONE);
                    txtreasmention.setText("");*/
                 secdodNot.setVisibility(View.GONE);
                 rdogrpdodNot.clearCheck();
                 secdeathtimeNot.setVisibility(View.GONE);
                 rdogrpdeathtimeNot.clearCheck();
             }
             else if(rbData.equalsIgnoreCase("2"))
             {
                    secstillbirthSp.setVisibility(View.GONE);
                    linestillbirthSp.setVisibility(View.GONE);
                    rdogrpstillbirthSp.clearCheck();
                    secdod.setVisibility(View.GONE);
                    linedod.setVisibility(View.GONE);
                    dtpdod.setText("");
                    secdeathtime.setVisibility(View.GONE);
                    linedeathtime.setVisibility(View.GONE);
                    txtdeathtime.setText("");
                    /*seclblStatus.setVisibility(View.GONE);
                    linelblStatus.setVisibility(View.GONE);
                    secstatus.setVisibility(View.GONE);
                    linestatus.setVisibility(View.GONE);
                    rdogrpstatus.clearCheck();
                    secreason.setVisibility(View.GONE);
                    linereason.setVisibility(View.GONE);
                    rdogrpreason.clearCheck();
                    secreasmention.setVisibility(View.GONE);
                    linereasmention.setVisibility(View.GONE);
                    txtreasmention.setText("");*/
                 secdodNot.setVisibility(View.GONE);
                 rdogrpdodNot.clearCheck();
                 secdeathtimeNot.setVisibility(View.GONE);
                 rdogrpdeathtimeNot.clearCheck();
             }
             else if(rbData.equalsIgnoreCase("3"))
             {
                  secstillbirthSp.setVisibility(View.VISIBLE);
                  linestillbirthSp.setVisibility(View.VISIBLE);
                  secdod.setVisibility(View.GONE);
                  dtpdod.setText("");
                  linedod.setVisibility(View.GONE);
                  secdeathtime.setVisibility(View.GONE);
                  linedeathtime.setVisibility(View.GONE);
                  txtdeathtime.setText("");
                 secdodNot.setVisibility(View.GONE);
                 rdogrpdodNot.clearCheck();
                 secdeathtimeNot.setVisibility(View.GONE);
                 rdogrpdeathtimeNot.clearCheck();
             }
             else if(rbData.equalsIgnoreCase("4"))
             {
                  secstillbirthSp.setVisibility(View.GONE);
                  linestillbirthSp.setVisibility(View.GONE);
                  rdogrpstillbirthSp.clearCheck();
                  secdod.setVisibility(View.VISIBLE);
                  linedod.setVisibility(View.VISIBLE);
                 secdodNot.setVisibility(View.VISIBLE);
                  secdeathtime.setVisibility(View.VISIBLE);
                 secdeathtimeNot.setVisibility(View.VISIBLE);
                  linedeathtime.setVisibility(View.VISIBLE);
             }
             /*else if(rbData.equalsIgnoreCase("4"))
             {
                  secstillbirthSp.setVisibility(View.GONE);
                  linestillbirthSp.setVisibility(View.GONE);
                  rdogrpstillbirthSp.clearCheck();
                  secdod.setVisibility(View.GONE);
                  linedod.setVisibility(View.GONE);
                  dtpdod.setText("");
                  secdeathtime.setVisibility(View.GONE);
                  linedeathtime.setVisibility(View.GONE);
                  txtdeathtime.setText("");
                  *//*seclblStatus.setVisibility(View.GONE);
                  linelblStatus.setVisibility(View.GONE);
                  secstatus.setVisibility(View.GONE);
                  linestatus.setVisibility(View.GONE);
                  rdogrpstatus.clearCheck();
                  secreason.setVisibility(View.GONE);
                  linereason.setVisibility(View.GONE);
                  rdogrpreason.clearCheck();
                  secreasmention.setVisibility(View.GONE);
                  linereasmention.setVisibility(View.GONE);
                  txtreasmention.setText("");*//*
             }*/
             else
             {
                  secstillbirthSp.setVisibility(View.GONE);
                  linestillbirthSp.setVisibility(View.GONE);
                  rdogrpstillbirthSp.clearCheck();
                  secdod.setVisibility(View.GONE);
                  linedod.setVisibility(View.GONE);
                  dtpdod.setText("");
                  secdeathtime.setVisibility(View.GONE);
                  linedeathtime.setVisibility(View.GONE);
                  txtdeathtime.setText("");
                 secdodNot.setVisibility(View.GONE);
                 rdogrpdodNot.clearCheck();
                 secdeathtimeNot.setVisibility(View.GONE);
                 rdogrpdeathtimeNot.clearCheck();
                  /*
                    secstillbirthSp.setVisibility(View.VISIBLE);
                    linestillbirthSp.setVisibility(View.VISIBLE);
                    secdod.setVisibility(View.VISIBLE);
                    linedod.setVisibility(View.VISIBLE);
                    secdeathtime.setVisibility(View.VISIBLE);
                    linedeathtime.setVisibility(View.VISIBLE);*/
                    /*seclblStatus.setVisibility(View.VISIBLE);
                    linelblStatus.setVisibility(View.VISIBLE);
                    secstatus.setVisibility(View.VISIBLE);
                    linestatus.setVisibility(View.VISIBLE);*/
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            }
         });
         secstillbirthSp=(LinearLayout)findViewById(R.id.secstillbirthSp);
         linestillbirthSp=(View)findViewById(R.id.linestillbirthSp);
         VlblstillbirthSp = (TextView) findViewById(R.id.VlblstillbirthSp);
         rdogrpstillbirthSp = (RadioGroup) findViewById(R.id.rdogrpstillbirthSp);

         rdostillbirthSp1 = (RadioButton) findViewById(R.id.rdostillbirthSp1);
         rdostillbirthSp2 = (RadioButton) findViewById(R.id.rdostillbirthSp2);
         rdostillbirthSp3 = (RadioButton) findViewById(R.id.rdostillbirthSp3);
         secdod=(LinearLayout)findViewById(R.id.secdod);
         linedod=(View)findViewById(R.id.linedod);
         Vlbldod=(TextView) findViewById(R.id.Vlbldod);
         dtpdod=(EditText) findViewById(R.id.dtpdod);
         rdogrpdodNot=(RadioGroup)findViewById(R.id.rdogrpdodNot) ;
         rdododNot1=(RadioButton)findViewById(R.id.rdododNot1) ;
         rdododNot2=(RadioButton)findViewById(R.id.rdododNot2) ;

         secdeathtime=(LinearLayout)findViewById(R.id.secdeathtime);
         linedeathtime=(View)findViewById(R.id.linedeathtime);
         Vlbldeathtime=(TextView) findViewById(R.id.Vlbldeathtime);
         txtdeathtime=(EditText) findViewById(R.id.txtdeathtime);
         rdogrpdeathtimeNot=(RadioGroup)findViewById(R.id.rdogrpdeathtimeNot) ;
         rdodeathtimeNot1=(RadioButton)findViewById(R.id.rdodeathtimeNot1) ;
         rdodeathtimeNot2=(RadioButton)findViewById(R.id.rdodeathtimeNot2) ;

         seclblStatus=(LinearLayout)findViewById(R.id.seclblStatus);
         linelblStatus=(View)findViewById(R.id.linelblStatus);
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


         dtpmatbdate.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpmatbdate.getRight() - dtpmatbdate.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnmatbdate"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });
         dtpdtdgnmatcondA.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpdtdgnmatcondA.getRight() - dtpdtdgnmatcondA.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btndtdgnmatcondA"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });
         dtpdtdgnmatcondB.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpdtdgnmatcondB.getRight() - dtpdtdgnmatcondB.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btndtdgnmatcondB"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });
         dtpdtdgnmatcondC.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpdtdgnmatcondC.getRight() - dtpdtdgnmatcondC.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btndtdgnmatcondC"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });
         dtpdtdgnmatcondD.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpdtdgnmatcondD.getRight() - dtpdtdgnmatcondD.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btndtdgnmatcondD"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });
         dtpdtdgnmatcondE.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpdtdgnmatcondE.getRight() - dtpdtdgnmatcondE.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btndtdgnmatcondE"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });
         dtpdtdgnmatcondF.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpdtdgnmatcondF.getRight() - dtpdtdgnmatcondF.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btndtdgnmatcondF"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });
         dtpdtdgnmatinf.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpdtdgnmatinf.getRight() - dtpdtdgnmatinf.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btndtdgnmatinf"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });
         dtpdtacs1.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpdtacs1.getRight() - dtpdtacs1.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btndtacs1"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });
         dtpdtacsm2.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpdtacsm2.getRight() - dtpdtacsm2.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btndtacsm2"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });
         dtpdtacsadm3.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpdtacsadm3.getRight() - dtpdtacsadm3.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btndtacsadm3"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });
         dtpdtacsadm4.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpdtacsadm4.getRight() - dtpdtacsadm4.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btndtacsadm4"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });
         dtpdtacsfurther.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpdtacsfurther.getRight() - dtpdtacsfurther.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btndtacsfurther"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });
         dtpdod.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpdod.getRight() - dtpdod.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btndod"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });


         txttmdgnmatcondA.setOnTouchListener(new View.OnTouchListener() {
         @Override
         public boolean onTouch(View v, MotionEvent event) {
             final int DRAWABLE_RIGHT = 2;
             if(event.getAction() == MotionEvent.ACTION_UP) {
                 if(event.getRawX() >= (txttmdgnmatcondA.getRight() - txttmdgnmatcondA.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                     VariableID = "btntmdgnmatcondA"; showDialog(TIME_DIALOG);
                  return true;
                 }
             }
             return false;
           }
         });
         txttmdgnmatcondB.setOnTouchListener(new View.OnTouchListener() {
         @Override
         public boolean onTouch(View v, MotionEvent event) {
             final int DRAWABLE_RIGHT = 2;
             if(event.getAction() == MotionEvent.ACTION_UP) {
                 if(event.getRawX() >= (txttmdgnmatcondB.getRight() - txttmdgnmatcondB.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                     VariableID = "btntmdgnmatcondB"; showDialog(TIME_DIALOG);
                  return true;
                 }
             }
             return false;
           }
         });
         txttmdgnmatcondC.setOnTouchListener(new View.OnTouchListener() {
         @Override
         public boolean onTouch(View v, MotionEvent event) {
             final int DRAWABLE_RIGHT = 2;
             if(event.getAction() == MotionEvent.ACTION_UP) {
                 if(event.getRawX() >= (txttmdgnmatcondC.getRight() - txttmdgnmatcondC.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                     VariableID = "btntmdgnmatcondC"; showDialog(TIME_DIALOG);
                  return true;
                 }
             }
             return false;
           }
         });
         txttmdgnmatcondD.setOnTouchListener(new View.OnTouchListener() {
         @Override
         public boolean onTouch(View v, MotionEvent event) {
             final int DRAWABLE_RIGHT = 2;
             if(event.getAction() == MotionEvent.ACTION_UP) {
                 if(event.getRawX() >= (txttmdgnmatcondD.getRight() - txttmdgnmatcondD.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                     VariableID = "btntmdgnmatcondD"; showDialog(TIME_DIALOG);
                  return true;
                 }
             }
             return false;
           }
         });
         txttmdgnmatcondE.setOnTouchListener(new View.OnTouchListener() {
         @Override
         public boolean onTouch(View v, MotionEvent event) {
             final int DRAWABLE_RIGHT = 2;
             if(event.getAction() == MotionEvent.ACTION_UP) {
                 if(event.getRawX() >= (txttmdgnmatcondE.getRight() - txttmdgnmatcondE.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                     VariableID = "btntmdgnmatcondE"; showDialog(TIME_DIALOG);
                  return true;
                 }
             }
             return false;
           }
         });
         txttmdgnmatcondF.setOnTouchListener(new View.OnTouchListener() {
         @Override
         public boolean onTouch(View v, MotionEvent event) {
             final int DRAWABLE_RIGHT = 2;
             if(event.getAction() == MotionEvent.ACTION_UP) {
                 if(event.getRawX() >= (txttmdgnmatcondF.getRight() - txttmdgnmatcondF.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                     VariableID = "btntmdgnmatcondF"; showDialog(TIME_DIALOG);
                  return true;
                 }
             }
             return false;
           }
         });
         txttmdgnmatinf.setOnTouchListener(new View.OnTouchListener() {
         @Override
         public boolean onTouch(View v, MotionEvent event) {
             final int DRAWABLE_RIGHT = 2;
             if(event.getAction() == MotionEvent.ACTION_UP) {
                 if(event.getRawX() >= (txttmdgnmatinf.getRight() - txttmdgnmatinf.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                     VariableID = "btntmdgnmatinf"; showDialog(TIME_DIALOG);
                  return true;
                 }
             }
             return false;
           }
         });
         txttmdtacs1.setOnTouchListener(new View.OnTouchListener() {
         @Override
         public boolean onTouch(View v, MotionEvent event) {
             final int DRAWABLE_RIGHT = 2;
             if(event.getAction() == MotionEvent.ACTION_UP) {
                 if(event.getRawX() >= (txttmdtacs1.getRight() - txttmdtacs1.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                     VariableID = "btntmdtacs1"; showDialog(TIME_DIALOG);
                  return true;
                 }
             }
             return false;
           }
         });
         txttmacsm2.setOnTouchListener(new View.OnTouchListener() {
         @Override
         public boolean onTouch(View v, MotionEvent event) {
             final int DRAWABLE_RIGHT = 2;
             if(event.getAction() == MotionEvent.ACTION_UP) {
                 if(event.getRawX() >= (txttmacsm2.getRight() - txttmacsm2.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                     VariableID = "btntmacsm2"; showDialog(TIME_DIALOG);
                  return true;
                 }
             }
             return false;
           }
         });
         txttmacsadm3.setOnTouchListener(new View.OnTouchListener() {
         @Override
         public boolean onTouch(View v, MotionEvent event) {
             final int DRAWABLE_RIGHT = 2;
             if(event.getAction() == MotionEvent.ACTION_UP) {
                 if(event.getRawX() >= (txttmacsadm3.getRight() - txttmacsadm3.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                     VariableID = "btntmacsadm3"; showDialog(TIME_DIALOG);
                  return true;
                 }
             }
             return false;
           }
         });
         txttmacsadm4.setOnTouchListener(new View.OnTouchListener() {
         @Override
         public boolean onTouch(View v, MotionEvent event) {
             final int DRAWABLE_RIGHT = 2;
             if(event.getAction() == MotionEvent.ACTION_UP) {
                 if(event.getRawX() >= (txttmacsadm4.getRight() - txttmacsadm4.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                     VariableID = "btntmacsadm4"; showDialog(TIME_DIALOG);
                  return true;
                 }
             }
             return false;
           }
         });
         txttmacsfurther.setOnTouchListener(new View.OnTouchListener() {
         @Override
         public boolean onTouch(View v, MotionEvent event) {
             final int DRAWABLE_RIGHT = 2;
             if(event.getAction() == MotionEvent.ACTION_UP) {
                 if(event.getRawX() >= (txttmacsfurther.getRight() - txttmacsfurther.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                     VariableID = "btntmacsfurther"; showDialog(TIME_DIALOG);
                  return true;
                 }
             }
             return false;
           }
         });
         txtdeathtime.setOnTouchListener(new View.OnTouchListener() {
         @Override
         public boolean onTouch(View v, MotionEvent event) {
             final int DRAWABLE_RIGHT = 2;
             if(event.getAction() == MotionEvent.ACTION_UP) {
                 if(event.getRawX() >= (txtdeathtime.getRight() - txtdeathtime.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                     VariableID = "btndeathtime"; showDialog(TIME_DIALOG);
                  return true;
                 }
             }
             return false;
           }
         });


          //----
          txtga.addTextChangedListener(new TextWatcher() {
               public void onTextChanged(CharSequence s, int start, int before,int count) {
               }
               public void beforeTextChanged(CharSequence s, int start, int count,int after) {
               }
               public void afterTextChanged(Editable s) {
                    if(txtga.getText().toString().length()>0) rdogrpgar.clearCheck();
               }
          });
          rdogrpgar.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
          {
               @Override
               public void onCheckedChanged(RadioGroup group, int checkedId)
               {
                    if(rdogar1.isChecked() | rdogar2.isChecked()) txtga.setText("");
               }
          });
          //----
          txtgamethod.addTextChangedListener(new TextWatcher() {
               public void onTextChanged(CharSequence s, int start, int before,int count) {
               }
               public void beforeTextChanged(CharSequence s, int start, int count,int after) {
               }
               public void afterTextChanged(Editable s) {
                    if(txtgamethod.getText().toString().length()>0) rdogrpgamethodr.clearCheck();
               }
          });
          rdogrpgamethodr.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
          {
               @Override
               public void onCheckedChanged(RadioGroup group, int checkedId)
               {
                    if(rdogamethodr1.isChecked() | rdogamethodr2.isChecked()) txtgamethod.setText("");
               }
          });



         chkmatcondpremG.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if ( isChecked )
                 {
                      chkmatcondpremA.setChecked(false);
                      chkmatcondpremB.setChecked(false);
                      chkmatcondpremC.setChecked(false);
                      chkmatcondpremD.setChecked(false);
                      chkmatcondpremE.setChecked(false);
                      chkmatcondpremF.setChecked(false);
                     chkmatcondpremH.setChecked(false);
                 }

             }
         });
         chkmatcondpremH.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if ( isChecked )
                 {
                      chkmatcondpremA.setChecked(false);
                      chkmatcondpremB.setChecked(false);
                      chkmatcondpremC.setChecked(false);
                      chkmatcondpremD.setChecked(false);
                      chkmatcondpremE.setChecked(false);
                      chkmatcondpremG.setChecked(false);
                 }

             }
         });

         /*chkmatcondpremA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if ( isChecked )
                 {
                     chkmatcondpremG.setChecked(false);
                     chkmatcondpremH.setChecked(false);
                 }

             }
         });*/
         /*chkmatcondpremB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if ( isChecked )
                 {
                     chkmatcondpremG.setChecked(false);
                     chkmatcondpremH.setChecked(false);
                 }

             }
         });*/
         /*chkmatcondpremC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if ( isChecked )
                 {
                     chkmatcondpremG.setChecked(false);
                     chkmatcondpremH.setChecked(false);
                 }

             }
         });*/
         /*chkmatcondpremD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if ( isChecked )
                 {
                     chkmatcondpremG.setChecked(false);
                     chkmatcondpremH.setChecked(false);
                 }

             }
         });*/
          /*chkmatcondpremE.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
          {
               @Override
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
               {
                    if ( isChecked )
                    {

                         chkmatcondpremA.setChecked(false);
                         chkmatcondpremB.setChecked(false);
                         chkmatcondpremC.setChecked(false);
                         chkmatcondpremD.setChecked(false);
                         chkmatcondpremF.setChecked(false);
                    }

               }
          });*/

          /*chkmatcondpremF.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
          {
               @Override
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
               {
                    if ( isChecked )
                    {
                         chkmatcondpremG.setChecked(false);
                         chkmatcondpremH.setChecked(false);
                    }

               }
          });*/

          //10

          chkmatinfA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
          {
               @Override
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
               {
                    if ( isChecked )
                    {
                         chkmatinfG.setChecked(false);
                         chkmatinfH.setChecked(false);
                         chkmatinfI.setChecked(false);
                    }

               }
          });
          chkmatinfB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
          {
               @Override
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
               {
                    if ( isChecked )
                    {
                         chkmatinfG.setChecked(false);
                         chkmatinfH.setChecked(false);
                         chkmatinfI.setChecked(false);
                    }

               }
          });
          chkmatinfC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
          {
               @Override
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
               {
                    if ( isChecked )
                    {
                         chkmatinfG.setChecked(false);
                         chkmatinfH.setChecked(false);
                         chkmatinfI.setChecked(false);
                    }

               }
          });
          chkmatinfD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
          {
               @Override
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
               {
                    if ( isChecked )
                    {
                         chkmatinfG.setChecked(false);
                         chkmatinfH.setChecked(false);
                         chkmatinfI.setChecked(false);
                    }

               }
          });
          chkmatinfE.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
          {
               @Override
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
               {
                    if ( isChecked )
                    {
                         chkmatinfG.setChecked(false);
                         chkmatinfH.setChecked(false);
                         chkmatinfI.setChecked(false);
                    }

               }
          });
          chkmatinfF.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
          {
               @Override
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
               {
                    if ( isChecked )
                    {
                         chkmatinfG.setChecked(false);
                         chkmatinfH.setChecked(false);
                         chkmatinfI.setChecked(false);
                    }

               }
          });
          chkmatinfJ.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
          {
               @Override
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
               {
                    if ( isChecked )
                    {
                         chkmatinfG.setChecked(false);
                         chkmatinfH.setChecked(false);
                         chkmatinfI.setChecked(false);
                         secmatinfOth.setVisibility(View.VISIBLE);
                    }else{
                         secmatinfOth.setVisibility(View.GONE);
                         txtmatinfOth.setText("");
                    }

               }
          });

          chkmatinfG.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
          {
               @Override
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
               {
                    if ( isChecked )
                    {
                         chkmatinfA.setChecked(false);
                         chkmatinfB.setChecked(false);
                         chkmatinfC.setChecked(false);
                         chkmatinfD.setChecked(false);
                         chkmatinfE.setChecked(false);
                         chkmatinfF.setChecked(false);

                         chkmatinfH.setChecked(false);
                         chkmatinfI.setChecked(false);
                         chkmatinfJ.setChecked(false);

                         secdtdgnmatinf.setVisibility(View.GONE);
                         dtpdtdgnmatinf.setText("");
                         secdtdgnmatinfNot.setVisibility(View.GONE);
                         rdogrpdtdgnmatinfNot.clearCheck();
                         sectmdgnmatinf.setVisibility(View.GONE);
                         txttmdgnmatinf.setText("");
                         sectmdgnmatinfNot.setVisibility(View.GONE);
                         rdogrptmdgnmatinfNot.clearCheck();
                    }else{
                         secdtdgnmatinf.setVisibility(View.VISIBLE);
                         secdtdgnmatinfNot.setVisibility(View.VISIBLE);
                         sectmdgnmatinf.setVisibility(View.VISIBLE);
                         sectmdgnmatinfNot.setVisibility(View.VISIBLE);
                    }

               }
          });

          chkmatinfH.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
          {
               @Override
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
               {
                    if ( isChecked )
                    {
                         chkmatinfA.setChecked(false);
                         chkmatinfB.setChecked(false);
                         chkmatinfC.setChecked(false);
                         chkmatinfD.setChecked(false);
                         chkmatinfE.setChecked(false);
                         chkmatinfF.setChecked(false);
                         chkmatinfG.setChecked(false);
                         chkmatinfI.setChecked(false);
                         chkmatinfJ.setChecked(false);
                    }

               }
          });

          chkmatinfI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
          {
               @Override
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
               {
                    if ( isChecked )
                    {
                         chkmatinfA.setChecked(false);
                         chkmatinfB.setChecked(false);
                         chkmatinfC.setChecked(false);
                         chkmatinfD.setChecked(false);
                         chkmatinfE.setChecked(false);
                         chkmatinfF.setChecked(false);
                         chkmatinfG.setChecked(false);
                         chkmatinfH.setChecked(false);
                         chkmatinfJ.setChecked(false);
                    }

               }
          });

          //12
          chkmatcoinfC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
          {
               @Override
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
               {
                    if ( isChecked )
                    {
                         chkmatcoinfA.setChecked(false);
                         chkmatcoinfB.setChecked(false);
                         chkmatcoinfD.setChecked(false);
                         chkmatcoinfE.setChecked(false);
                         chkmatcoinfF.setChecked(false);

                         secmatcoinftrtmnt.setVisibility(View.GONE);
                         rdogrpmatcoinftrtmnt.clearCheck();
                    }else{
                         secmatcoinftrtmnt.setVisibility(View.VISIBLE);
                    }

               }
          });
          chkmatcoinfD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
          {
               @Override
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
               {
                    if ( isChecked )
                    {
                         chkmatcoinfA.setChecked(false);
                         chkmatcoinfB.setChecked(false);
                         chkmatcoinfC.setChecked(false);
                         chkmatcoinfE.setChecked(false);
                         chkmatcoinfF.setChecked(false);
                    }

               }
          });
          chkmatcoinfE.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
          {
               @Override
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
               {
                    if ( isChecked )
                    {
                         chkmatcoinfA.setChecked(false);
                         chkmatcoinfB.setChecked(false);
                         chkmatcoinfC.setChecked(false);
                         chkmatcoinfD.setChecked(false);
                         chkmatcoinfF.setChecked(false);
                    }

               }
          });

          chkmatcoinfA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
          {
               @Override
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
               {
                    if ( isChecked )
                    {
                         chkmatcoinfC.setChecked(false);
                         chkmatcoinfD.setChecked(false);
                         chkmatcoinfE.setChecked(false);
                    }

               }
          });
          chkmatcoinfB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
          {
               @Override
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
               {
                    if ( isChecked )
                    {
                         chkmatcoinfC.setChecked(false);
                         chkmatcoinfD.setChecked(false);
                         chkmatcoinfE.setChecked(false);
                    }

               }
          });
          chkmatcoinfF.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
          {
               @Override
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
               {
                    if ( isChecked )
                    {
                         chkmatcoinfC.setChecked(false);
                         chkmatcoinfD.setChecked(false);
                         chkmatcoinfE.setChecked(false);
                         secmatcoinfOth.setVisibility(View.VISIBLE);
                    }else{
                         secmatcoinfOth.setVisibility(View.GONE);
                         txtmatcoinfOth.setText("");
                    }

               }
          });


          rdogrpacsfurther.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
          {
               @Override
               public void onCheckedChanged(RadioGroup group, int checkedId)
               {
                    if(rdoacsfurther1.isChecked()){
                         secdtacsfurther.setVisibility(View.VISIBLE);
                         sectmacsfurther.setVisibility(View.VISIBLE);
                         secacsdosefurther.setVisibility(View.VISIBLE);
                        secdtacsfurtherNot.setVisibility(View.VISIBLE);
                        sectmacsfurtherNot.setVisibility(View.VISIBLE);
                    }else{
                         secdtacsfurther.setVisibility(View.GONE);
                         dtpdtacsfurther.setText("");
                         sectmacsfurther.setVisibility(View.GONE);
                         txttmacsfurther.setText("");
                         secacsdosefurther.setVisibility(View.GONE);
                         rdogrpacsdosefurther.clearCheck();
                         secacsdosefurtherOth.setVisibility(View.GONE);
                         txtacsdosefurtherOth.setText("");
                        secdtacsfurtherNot.setVisibility(View.GONE);
                        rdogrpdtacsfurtherNot.clearCheck();
                        sectmacsfurtherNot.setVisibility(View.GONE);
                        rdogrptmacsfurtherNot.clearCheck();

                    }
               }
          });



          //11 08 2017
          dtpdtdgnmatcondA.addTextChangedListener(new TextWatcher() {
               public void onTextChanged(CharSequence s, int start, int before,int count) {
               }
               public void beforeTextChanged(CharSequence s, int start, int count,int after) {
               }
               public void afterTextChanged(Editable s) {
                    if(dtpdtdgnmatcondA.getText().toString().length()>0) rdogrpdtdgnmatcondANot.clearCheck();
               }
          });
          rdogrpdtdgnmatcondANot.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
          {
               @Override
               public void onCheckedChanged(RadioGroup group, int checkedId)
               {
                    if(rdodtdgnmatcondANot1.isChecked() | rdodtdgnmatcondANot2.isChecked()) dtpdtdgnmatcondA.setText("");
               }
          });

          txttmdgnmatcondA.addTextChangedListener(new TextWatcher() {
               public void onTextChanged(CharSequence s, int start, int before,int count) {
               }
               public void beforeTextChanged(CharSequence s, int start, int count,int after) {
               }
               public void afterTextChanged(Editable s) {
                    if(txttmdgnmatcondA.getText().toString().length()>0) rdogrptmdgnmatcondANot.clearCheck();
               }
          });
          rdogrptmdgnmatcondANot.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
          {
               @Override
               public void onCheckedChanged(RadioGroup group, int checkedId)
               {
                    if(rdotmdgnmatcondANot1.isChecked() | rdotmdgnmatcondANot2.isChecked()) txttmdgnmatcondA.setText("");
               }
          });

         dtpdtdgnmatcondB.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {
             }
             public void beforeTextChanged(CharSequence s, int start, int count,int after) {
             }
             public void afterTextChanged(Editable s) {
                 if(dtpdtdgnmatcondB.getText().toString().length()>0) rdogrpdtdgnmatcondBNot.clearCheck();
             }
         });
         rdogrpdtdgnmatcondBNot.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(rdodtdgnmatcondBNot1.isChecked() | rdodtdgnmatcondBNot2.isChecked()) dtpdtdgnmatcondB.setText("");
             }
         });

         txttmdgnmatcondB.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {
             }
             public void beforeTextChanged(CharSequence s, int start, int count,int after) {
             }
             public void afterTextChanged(Editable s) {
                 if(txttmdgnmatcondB.getText().toString().length()>0) rdogrptmdgnmatcondBNot.clearCheck();
             }
         });
         rdogrptmdgnmatcondBNot.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(rdotmdgnmatcondBNot1.isChecked() | rdotmdgnmatcondBNot2.isChecked()) txttmdgnmatcondB.setText("");
             }
         });

         dtpdtdgnmatcondC.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {
             }
             public void beforeTextChanged(CharSequence s, int start, int count,int after) {
             }
             public void afterTextChanged(Editable s) {
                 if(dtpdtdgnmatcondC.getText().toString().length()>0) rdogrpdtdgnmatcondCNot.clearCheck();
             }
         });
         rdogrpdtdgnmatcondCNot.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(rdodtdgnmatcondCNot1.isChecked() | rdodtdgnmatcondCNot2.isChecked()) dtpdtdgnmatcondC.setText("");
             }
         });

         txttmdgnmatcondC.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {
             }
             public void beforeTextChanged(CharSequence s, int start, int count,int after) {
             }
             public void afterTextChanged(Editable s) {
                 if(txttmdgnmatcondC.getText().toString().length()>0) rdogrptmdgnmatcondCNot.clearCheck();
             }
         });
         rdogrptmdgnmatcondCNot.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(rdotmdgnmatcondCNot1.isChecked() | rdotmdgnmatcondCNot2.isChecked()) txttmdgnmatcondC.setText("");
             }
         });


         dtpdtdgnmatcondD.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {
             }
             public void beforeTextChanged(CharSequence s, int start, int count,int after) {
             }
             public void afterTextChanged(Editable s) {
                 if(dtpdtdgnmatcondD.getText().toString().length()>0) rdogrpdtdgnmatcondDNot.clearCheck();
             }
         });
         rdogrpdtdgnmatcondDNot.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(rdodtdgnmatcondDNot1.isChecked() | rdodtdgnmatcondDNot2.isChecked()) dtpdtdgnmatcondD.setText("");
             }
         });

         txttmdgnmatcondD.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {
             }
             public void beforeTextChanged(CharSequence s, int start, int count,int after) {
             }
             public void afterTextChanged(Editable s) {
                 if(txttmdgnmatcondD.getText().toString().length()>0) rdogrptmdgnmatcondDNot.clearCheck();
             }
         });
         rdogrptmdgnmatcondDNot.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(rdotmdgnmatcondDNot1.isChecked() | rdotmdgnmatcondDNot2.isChecked()) txttmdgnmatcondD.setText("");
             }
         });


          dtpdtdgnmatcondF.addTextChangedListener(new TextWatcher() {
               public void onTextChanged(CharSequence s, int start, int before,int count) {
               }
               public void beforeTextChanged(CharSequence s, int start, int count,int after) {
               }
               public void afterTextChanged(Editable s) {
                    if(dtpdtdgnmatcondF.getText().toString().length()>0) rdogrpdtdgnmatcondFNot.clearCheck();
               }
          });
          rdogrpdtdgnmatcondFNot.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
          {
               @Override
               public void onCheckedChanged(RadioGroup group, int checkedId)
               {
                    if(rdodtdgnmatcondFNot1.isChecked() | rdodtdgnmatcondFNot2.isChecked()) dtpdtdgnmatcondF.setText("");
               }
          });

          txttmdgnmatcondF.addTextChangedListener(new TextWatcher() {
               public void onTextChanged(CharSequence s, int start, int before,int count) {
               }
               public void beforeTextChanged(CharSequence s, int start, int count,int after) {
               }
               public void afterTextChanged(Editable s) {
                    if(txttmdgnmatcondF.getText().toString().length()>0) rdogrptmdgnmatcondFNot.clearCheck();
               }
          });
          rdogrptmdgnmatcondFNot.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
          {
               @Override
               public void onCheckedChanged(RadioGroup group, int checkedId)
               {
                    if(rdotmdgnmatcondFNot1.isChecked() | rdotmdgnmatcondFNot2.isChecked()) txttmdgnmatcondF.setText("");
               }
          });


          //11
          dtpdtdgnmatinf.addTextChangedListener(new TextWatcher() {
               public void onTextChanged(CharSequence s, int start, int before,int count) {
               }
               public void beforeTextChanged(CharSequence s, int start, int count,int after) {
               }
               public void afterTextChanged(Editable s) {
                    if(dtpdtdgnmatinf.getText().toString().length()>0) rdogrpdtdgnmatinfNot.clearCheck();
               }
          });
          rdogrpdtdgnmatinfNot.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
          {
               @Override
               public void onCheckedChanged(RadioGroup group, int checkedId)
               {
                    if(rdodtdgnmatinfNot1.isChecked() | rdodtdgnmatinfNot2.isChecked()) dtpdtdgnmatinf.setText("");
               }
          });

          txttmdgnmatinf.addTextChangedListener(new TextWatcher() {
               public void onTextChanged(CharSequence s, int start, int before,int count) {
               }
               public void beforeTextChanged(CharSequence s, int start, int count,int after) {
               }
               public void afterTextChanged(Editable s) {
                    if(txttmdgnmatinf.getText().toString().length()>0) rdogrptmdgnmatinfNot.clearCheck();
               }
          });
          rdogrptmdgnmatinfNot.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
          {
               @Override
               public void onCheckedChanged(RadioGroup group, int checkedId)
               {
                    if(rdotmdgnmatinfNot1.isChecked() | rdotmdgnmatinfNot2.isChecked()) txttmdgnmatinf.setText("");
               }
          });


          //02 Dec 2017
         //6
         txtMoAge.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {}
             public void beforeTextChanged(CharSequence s, int start, int count,int after) {}
             public void afterTextChanged(Editable s) {
                 if(txtMoAge.getText().toString().length()>0) rdogrpMoAgeNot.clearCheck();
             }
         });
         rdogrpMoAgeNot.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(rdoMoAgeNot1.isChecked() | rdoMoAgeNot2.isChecked()) txtMoAge.setText("");
             }
         });
         //7
         dtpmatbdate.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {}
             public void beforeTextChanged(CharSequence s, int start, int count,int after) {}
             public void afterTextChanged(Editable s) {
                 if(dtpmatbdate.getText().toString().length()>0) rdogrpmatbdateNot.clearCheck();
             }
         });
         rdogrpmatbdateNot.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(rdomatbdateNot1.isChecked() | rdomatbdateNot2.isChecked()) dtpmatbdate.setText("");
             }
         });
         //16
         dtpdtacs1.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {}
             public void beforeTextChanged(CharSequence s, int start, int count,int after) {}
             public void afterTextChanged(Editable s) {
                 if(dtpdtacs1.getText().toString().length()>0) rdogrpdtacs1Not.clearCheck();
             }
         });
         rdogrpdtacs1Not.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(rdodtacs1Not1.isChecked() | rdodtacs1Not2.isChecked()) dtpdtacs1.setText("");
             }
         });
         txttmdtacs1.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {}
             public void beforeTextChanged(CharSequence s, int start, int count,int after) {}
             public void afterTextChanged(Editable s) {
                 if(txttmdtacs1.getText().toString().length()>0) rdogrptmdtacs1Not.clearCheck();
             }
         });
         rdogrptmdtacs1Not.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(rdotmdtacs1Not1.isChecked() | rdotmdtacs1Not2.isChecked()) txttmdtacs1.setText("");
             }
         });
         //20
         dtpdtacsm2.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {}
             public void beforeTextChanged(CharSequence s, int start, int count,int after) {}
             public void afterTextChanged(Editable s) {
                 if(dtpdtacsm2.getText().toString().length()>0) rdogrpdtacsm2Not.clearCheck();
             }
         });
         rdogrpdtacsm2Not.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(rdodtacsm2Not1.isChecked() | rdodtacsm2Not2.isChecked()) dtpdtacsm2.setText("");
             }
         });

         txttmacsm2.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {}
             public void beforeTextChanged(CharSequence s, int start, int count,int after) {}
             public void afterTextChanged(Editable s) {
                 if(txttmacsm2.getText().toString().length()>0) rdogrptmacsm2Not.clearCheck();
             }
         });
         rdogrptmacsm2Not.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(rdotmacsm2Not1.isChecked() | rdotmacsm2Not2.isChecked()) txttmacsm2.setText("");
             }
         });

         //23
         dtpdtacsadm3.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {}
             public void beforeTextChanged(CharSequence s, int start, int count,int after) {}
             public void afterTextChanged(Editable s) {
                 if(dtpdtacsadm3.getText().toString().length()>0) rdogrpdtacsadm3Not.clearCheck();
             }
         });
         rdogrpdtacsadm3Not.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(rdodtacsadm3Not1.isChecked() | rdodtacsadm3Not2.isChecked()) dtpdtacsadm3.setText("");
             }
         });

         txttmacsadm3.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {}
             public void beforeTextChanged(CharSequence s, int start, int count,int after) {}
             public void afterTextChanged(Editable s) {
                 if(txttmacsadm3.getText().toString().length()>0) rdogrptmacsadm3Not.clearCheck();
             }
         });
         rdogrptmacsadm3Not.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(rdotmacsadm3Not1.isChecked() | rdotmacsadm3Not2.isChecked()) txttmacsadm3.setText("");
             }
         });
         //26
         dtpdtacsadm4.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {}
             public void beforeTextChanged(CharSequence s, int start, int count,int after) {}
             public void afterTextChanged(Editable s) {
                 if(dtpdtacsadm4.getText().toString().length()>0) rdogrpdtacsadm4Not.clearCheck();
             }
         });
         rdogrpdtacsadm4Not.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(rdodtacsadm4Not1.isChecked() | rdodtacsadm4Not2.isChecked()) dtpdtacsadm4.setText("");
             }
         });

         txttmacsadm4.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {}
             public void beforeTextChanged(CharSequence s, int start, int count,int after) {}
             public void afterTextChanged(Editable s) {
                 if(txttmacsadm4.getText().toString().length()>0) rdogrptmacsadm4Not.clearCheck();
             }
         });
         rdogrptmacsadm4Not.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(rdotmacsadm4Not1.isChecked() | rdotmacsadm4Not2.isChecked()) txttmacsadm4.setText("");
             }
         });
         //29
         dtpdtacsfurther.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {}
             public void beforeTextChanged(CharSequence s, int start, int count,int after) {}
             public void afterTextChanged(Editable s) {
                 if(dtpdtacsfurther.getText().toString().length()>0) rdogrpdtacsfurtherNot.clearCheck();
             }
         });
         rdogrpdtacsfurtherNot.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(rdodtacsfurtherNot1.isChecked() | rdodtacsfurtherNot2.isChecked()) dtpdtacsfurther.setText("");
             }
         });

         txttmacsfurther.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {}
             public void beforeTextChanged(CharSequence s, int start, int count,int after) {}
             public void afterTextChanged(Editable s) {
                 if(txttmacsfurther.getText().toString().length()>0) rdogrptmacsfurtherNot.clearCheck();
             }
         });
         rdogrptmacsfurtherNot.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(rdotmacsfurtherNot1.isChecked() | rdotmacsfurtherNot2.isChecked()) txttmacsfurther.setText("");
             }
         });
         //32
         txtbwt.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {}
             public void beforeTextChanged(CharSequence s, int start, int count,int after) {}
             public void afterTextChanged(Editable s) {
                 if(txtbwt.getText().toString().length()>0) rdogrpbwtr.clearCheck();
             }
         });
         rdogrpbwtr.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(rdobwtr1.isChecked() | rdobwtr2.isChecked()) txtbwt.setText("");
             }
         });

         //35
         dtpdod.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {}
             public void beforeTextChanged(CharSequence s, int start, int count,int after) {}
             public void afterTextChanged(Editable s) {
                 if(dtpdod.getText().toString().length()>0) rdogrpdodNot.clearCheck();
             }
         });
         rdogrpdodNot.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(rdododNot1.isChecked() | rdododNot2.isChecked()) dtpdod.setText("");
             }
         });

         txtdeathtime.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {}
             public void beforeTextChanged(CharSequence s, int start, int count,int after) {}
             public void afterTextChanged(Editable s) {
                 if(txtdeathtime.getText().toString().length()>0) rdogrpdeathtimeNot.clearCheck();
             }
         });
         rdogrpdeathtimeNot.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(rdodeathtimeNot1.isChecked() | rdodeathtimeNot2.isChecked()) txtdeathtime.setText("");
             }
         });


         rdogrpcrform.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
             @Override
             public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
                 String rbData = "";
                 RadioButton rb;
                 String[] d_rdogrpcrform = new String[] {"1","2"};
                 for (int i = 0; i < rdogrpcrform.getChildCount(); i++)
                 {
                     rb = (RadioButton)rdogrpcrform.getChildAt(i);
                     if (rb.isChecked()) rbData = d_rdogrpcrform[i];
                 }

                 if(rbData.equalsIgnoreCase("2"))
                 {
                     secMoAge.setVisibility(View.GONE);
                     lineMoAge.setVisibility(View.GONE);
                     txtMoAge.setText("");
                     seclblSectionII.setVisibility(View.GONE);
                     linelblSectionII.setVisibility(View.GONE);
                     secgafirstds.setVisibility(View.GONE);
                     linegafirstds.setVisibility(View.GONE);
                     spngafirstds.setSelection(0);
                     seclblmatcondprem.setVisibility(View.GONE);
                     linelblmatcondprem.setVisibility(View.GONE);
                     secmatcondpremA.setVisibility(View.GONE);
                     linematcondpremA.setVisibility(View.GONE);
                     chkmatcondpremA.setChecked(false);
                     secdtdgnmatcondA.setVisibility(View.GONE);
                     linedtdgnmatcondA.setVisibility(View.GONE);
                     dtpdtdgnmatcondA.setText("");
                     sectmdgnmatcondA.setVisibility(View.GONE);
                     linetmdgnmatcondA.setVisibility(View.GONE);
                     txttmdgnmatcondA.setText("");
                     secmatcondpremB.setVisibility(View.GONE);
                     linematcondpremB.setVisibility(View.GONE);
                     chkmatcondpremB.setChecked(false);
                     secdtdgnmatcondB.setVisibility(View.GONE);
                     linedtdgnmatcondB.setVisibility(View.GONE);
                     dtpdtdgnmatcondB.setText("");
                     sectmdgnmatcondB.setVisibility(View.GONE);
                     linetmdgnmatcondB.setVisibility(View.GONE);
                     txttmdgnmatcondB.setText("");
                     secmatcondpremC.setVisibility(View.GONE);
                     linematcondpremC.setVisibility(View.GONE);
                     chkmatcondpremC.setChecked(false);
                     secdtdgnmatcondC.setVisibility(View.GONE);
                     linedtdgnmatcondC.setVisibility(View.GONE);
                     dtpdtdgnmatcondC.setText("");
                     sectmdgnmatcondC.setVisibility(View.GONE);
                     linetmdgnmatcondC.setVisibility(View.GONE);
                     txttmdgnmatcondC.setText("");
                     secmatcondpremD.setVisibility(View.GONE);
                     linematcondpremD.setVisibility(View.GONE);
                     chkmatcondpremD.setChecked(false);
                     secdtdgnmatcondD.setVisibility(View.GONE);
                     linedtdgnmatcondD.setVisibility(View.GONE);
                     dtpdtdgnmatcondD.setText("");
                     sectmdgnmatcondD.setVisibility(View.GONE);
                     linetmdgnmatcondD.setVisibility(View.GONE);
                     txttmdgnmatcondD.setText("");
                     secmatcondpremE.setVisibility(View.GONE);
                     linematcondpremE.setVisibility(View.GONE);
                     chkmatcondpremE.setChecked(false);
                     secdtdgnmatcondE.setVisibility(View.GONE);
                     linedtdgnmatcondE.setVisibility(View.GONE);
                     dtpdtdgnmatcondE.setText("");
                     sectmdgnmatcondE.setVisibility(View.GONE);
                     linetmdgnmatcondE.setVisibility(View.GONE);
                     txttmdgnmatcondE.setText("");
                     secmatcondpremF.setVisibility(View.GONE);
                     linematcondpremF.setVisibility(View.GONE);
                     chkmatcondpremF.setChecked(false);
                     secmatcondpremOth.setVisibility(View.GONE);
                     linematcondpremOth.setVisibility(View.GONE);
                     txtmatcondpremOth.setText("");
                     secdtdgnmatcondF.setVisibility(View.GONE);
                     linedtdgnmatcondF.setVisibility(View.GONE);
                     dtpdtdgnmatcondF.setText("");
                     sectmdgnmatcondF.setVisibility(View.GONE);
                     linetmdgnmatcondF.setVisibility(View.GONE);
                     txttmdgnmatcondF.setText("");
                     secmatcondpremG.setVisibility(View.GONE);
                     linematcondpremG.setVisibility(View.GONE);
                     chkmatcondpremG.setChecked(false);
                     secmatcondpremH.setVisibility(View.GONE);
                     linematcondpremH.setVisibility(View.GONE);
                     chkmatcondpremH.setChecked(false);
                     seclblmatinf.setVisibility(View.GONE);
                     linelblmatinf.setVisibility(View.GONE);
                     secmatinfA.setVisibility(View.GONE);
                     linematinfA.setVisibility(View.GONE);
                     chkmatinfA.setChecked(false);
                     secmatinfB.setVisibility(View.GONE);
                     linematinfB.setVisibility(View.GONE);
                     chkmatinfB.setChecked(false);
                     secmatinfC.setVisibility(View.GONE);
                     linematinfC.setVisibility(View.GONE);
                     chkmatinfC.setChecked(false);
                     secmatinfD.setVisibility(View.GONE);
                     linematinfD.setVisibility(View.GONE);
                     chkmatinfD.setChecked(false);
                     secmatinfE.setVisibility(View.GONE);
                     linematinfE.setVisibility(View.GONE);
                     chkmatinfE.setChecked(false);
                     secmatinfF.setVisibility(View.GONE);
                     linematinfF.setVisibility(View.GONE);
                     chkmatinfF.setChecked(false);
                     secmatinfG.setVisibility(View.GONE);
                     linematinfG.setVisibility(View.GONE);
                     chkmatinfG.setChecked(false);
                     secmatinfH.setVisibility(View.GONE);
                     linematinfH.setVisibility(View.GONE);
                     chkmatinfH.setChecked(false);
                     secmatinfI.setVisibility(View.GONE);
                     linematinfI.setVisibility(View.GONE);
                     chkmatinfI.setChecked(false);
                     secmatinfJ.setVisibility(View.GONE);
                     linematinfJ.setVisibility(View.GONE);
                     chkmatinfJ.setChecked(false);
                     secmatinfOth.setVisibility(View.GONE);
                     linematinfOth.setVisibility(View.GONE);
                     txtmatinfOth.setText("");
                     secdtdgnmatinf.setVisibility(View.GONE);
                     linedtdgnmatinf.setVisibility(View.GONE);
                     dtpdtdgnmatinf.setText("");
                     sectmdgnmatinf.setVisibility(View.GONE);
                     linetmdgnmatinf.setVisibility(View.GONE);
                     txttmdgnmatinf.setText("");
                     seclblmatcoinf.setVisibility(View.GONE);
                     linelblmatcoinf.setVisibility(View.GONE);
                     secmatcoinfA.setVisibility(View.GONE);
                     linematcoinfA.setVisibility(View.GONE);
                     chkmatcoinfA.setChecked(false);
                     secmatcoinfB.setVisibility(View.GONE);
                     linematcoinfB.setVisibility(View.GONE);
                     chkmatcoinfB.setChecked(false);
                     secmatcoinfC.setVisibility(View.GONE);
                     linematcoinfC.setVisibility(View.GONE);
                     chkmatcoinfC.setChecked(false);
                     secmatcoinfD.setVisibility(View.GONE);
                     linematcoinfD.setVisibility(View.GONE);
                     chkmatcoinfD.setChecked(false);
                     secmatcoinfE.setVisibility(View.GONE);
                     linematcoinfE.setVisibility(View.GONE);
                     chkmatcoinfE.setChecked(false);
                     secmatcoinfF.setVisibility(View.GONE);
                     linematcoinfF.setVisibility(View.GONE);
                     chkmatcoinfF.setChecked(false);
                     secmatcoinfOth.setVisibility(View.GONE);
                     linematcoinfOth.setVisibility(View.GONE);
                     txtmatcoinfOth.setText("");
                     secmatcoinftrtmnt.setVisibility(View.GONE);
                     linematcoinftrtmnt.setVisibility(View.GONE);
                     rdogrpmatcoinftrtmnt.clearCheck();
                     secfetalaus.setVisibility(View.GONE);
                     linefetalaus.setVisibility(View.GONE);
                     rdogrpfetalaus.clearCheck();
                     secfetalausrate.setVisibility(View.GONE);
                     linefetalausrate.setVisibility(View.GONE);
                     txtfetalausrate.setText("");
                     secfetalausOth.setVisibility(View.GONE);
                     linefetalausOth.setVisibility(View.GONE);
                     txtfetalausOth.setText("");
                     seclblSectionIII.setVisibility(View.GONE);
                     linelblSectionIII.setVisibility(View.GONE);
                     secacsadm1.setVisibility(View.GONE);
                     lineacsadm1.setVisibility(View.GONE);
                     rdogrpacsadm1.clearCheck();
                     secdtacs1.setVisibility(View.GONE);
                     linedtacs1.setVisibility(View.GONE);
                     dtpdtacs1.setText("");
                     sectmdtacs1.setVisibility(View.GONE);
                     linetmdtacs1.setVisibility(View.GONE);
                     txttmdtacs1.setText("");
                     secnameacs1.setVisibility(View.GONE);
                     linenameacs1.setVisibility(View.GONE);
                     rdogrpnameacs1.clearCheck();
                     secnameacs1Oth.setVisibility(View.GONE);
                     linenameacs1Oth.setVisibility(View.GONE);
                     txtnameacs1Oth.setText("");
                     secacsdose1.setVisibility(View.GONE);
                     lineacsdose1.setVisibility(View.GONE);
                     rdogrpacsdose1.clearCheck();
                     secacsdose1Oth.setVisibility(View.GONE);
                     lineacsdose1Oth.setVisibility(View.GONE);
                     txtacsdose1Oth.setText("");
                     secacsadm2.setVisibility(View.GONE);
                     lineacsadm2.setVisibility(View.GONE);
                     rdogrpacsadm2.clearCheck();
                     secdtacsm2.setVisibility(View.GONE);
                     linedtacsm2.setVisibility(View.GONE);
                     dtpdtacsm2.setText("");
                     sectmacsm2.setVisibility(View.GONE);
                     linetmacsm2.setVisibility(View.GONE);
                     txttmacsm2.setText("");
                     secacsdose2.setVisibility(View.GONE);
                     lineacsdose2.setVisibility(View.GONE);
                     rdogrpacsdose2.clearCheck();
                     secacsdose2Oth.setVisibility(View.GONE);
                     lineacsdose2Oth.setVisibility(View.GONE);
                     txtacsdose2Oth.setText("");
                     secacsadm3.setVisibility(View.GONE);
                     lineacsadm3.setVisibility(View.GONE);
                     rdogrpacsadm3.clearCheck();
                     secdtacsadm3.setVisibility(View.GONE);
                     linedtacsadm3.setVisibility(View.GONE);
                     dtpdtacsadm3.setText("");
                     sectmacsadm3.setVisibility(View.GONE);
                     linetmacsadm3.setVisibility(View.GONE);
                     txttmacsadm3.setText("");
                     secacsdose3.setVisibility(View.GONE);
                     lineacsdose3.setVisibility(View.GONE);
                     rdogrpacsdose3.clearCheck();
                     secacsdose3Oth.setVisibility(View.GONE);
                     lineacsdose3Oth.setVisibility(View.GONE);
                     txtacsdose3Oth.setText("");
                     secacsadm4.setVisibility(View.GONE);
                     lineacsadm4.setVisibility(View.GONE);
                     rdogrpacsadm4.clearCheck();
                     secdtacsadm4.setVisibility(View.GONE);
                     linedtacsadm4.setVisibility(View.GONE);
                     dtpdtacsadm4.setText("");
                     sectmacsadm4.setVisibility(View.GONE);
                     linetmacsadm4.setVisibility(View.GONE);
                     txttmacsadm4.setText("");
                     secacsdose4.setVisibility(View.GONE);
                     lineacsdose4.setVisibility(View.GONE);
                     rdogrpacsdose4.clearCheck();
                     secacsdose4Oth.setVisibility(View.GONE);
                     lineacsdose4Oth.setVisibility(View.GONE);
                     txtacsdose4Oth.setText("");
                     secacsfurther.setVisibility(View.GONE);
                     lineacsfurther.setVisibility(View.GONE);
                     rdogrpacsfurther.clearCheck();
                     secdtacsfurther.setVisibility(View.GONE);
                     linedtacsfurther.setVisibility(View.GONE);
                     dtpdtacsfurther.setText("");
                     sectmacsfurther.setVisibility(View.GONE);
                     linetmacsfurther.setVisibility(View.GONE);
                     txttmacsfurther.setText("");
                     secacsdosefurther.setVisibility(View.GONE);
                     lineacsdosefurther.setVisibility(View.GONE);
                     rdogrpacsdosefurther.clearCheck();
                     secacsdosefurtherOth.setVisibility(View.GONE);
                     lineacsdosefurtherOth.setVisibility(View.GONE);
                     txtacsdosefurtherOth.setText("");
                     seclblSectionIV.setVisibility(View.GONE);
                     linelblSectionIV.setVisibility(View.GONE);
                     secga.setVisibility(View.GONE);
                     linega.setVisibility(View.GONE);
                     txtga.setText("");
                     secgar.setVisibility(View.GONE);
                     linegar.setVisibility(View.GONE);
                     rdogrpgar.clearCheck();
                     secgamethod.setVisibility(View.GONE);
                     linegamethod.setVisibility(View.GONE);
                     txtgamethod.setText("");
                     secgamethodr.setVisibility(View.GONE);
                     linegamethodr.setVisibility(View.GONE);
                     rdogrpgamethodr.clearCheck();
                     secbwt.setVisibility(View.GONE);
                     linebwt.setVisibility(View.GONE);
                     txtbwt.setText("");
                     secbwtr.setVisibility(View.GONE);
                     linebwtr.setVisibility(View.GONE);
                     rdogrpbwtr.clearCheck();
                     secmatcond.setVisibility(View.GONE);
                     linematcond.setVisibility(View.GONE);
                     rdogrpmatcond.clearCheck();
                     secbadm.setVisibility(View.GONE);
                     linebadm.setVisibility(View.GONE);
                     rdogrpbadm.clearCheck();
                     secbcond.setVisibility(View.GONE);
                     linebcond.setVisibility(View.GONE);
                     rdogrpbcond.clearCheck();
                     secstillbirthSp.setVisibility(View.GONE);
                     linestillbirthSp.setVisibility(View.GONE);
                     rdogrpstillbirthSp.clearCheck();
                     secdod.setVisibility(View.GONE);
                     linedod.setVisibility(View.GONE);
                     dtpdod.setText("");
                     secdeathtime.setVisibility(View.GONE);
                     linedeathtime.setVisibility(View.GONE);
                     txtdeathtime.setText("");
                     /*seclblStatus.setVisibility(View.GONE);
                     linelblStatus.setVisibility(View.GONE);
                     secstatus.setVisibility(View.GONE);
                     linestatus.setVisibility(View.GONE);
                     rdogrpstatus.clearCheck();
                     secreason.setVisibility(View.GONE);
                     linereason.setVisibility(View.GONE);
                     rdogrpreason.clearCheck();
                     secreasmention.setVisibility(View.GONE);
                     linereasmention.setVisibility(View.GONE);
                     txtreasmention.setText("");*/


                     secdtacs1Not.setVisibility(View.GONE);
                     rdogrpdtacs1Not.clearCheck();
                     sectmdtacs1Not.setVisibility(View.GONE);
                     rdogrptmdtacs1Not.clearCheck();
                     secdtacsm2Not.setVisibility(View.GONE);
                     rdogrpdtacsm2Not.clearCheck();
                     sectmacsm2Not.setVisibility(View.GONE);
                     rdogrptmacsm2Not.clearCheck();
                     secdtacsadm3Not.setVisibility(View.GONE);
                     rdogrpdtacsadm3Not.clearCheck();
                     sectmacsadm3Not.setVisibility(View.GONE);
                     rdogrptmacsadm3Not.clearCheck();
                     secdtacsadm4Not.setVisibility(View.GONE);
                     rdogrpdtacsadm4Not.clearCheck();
                     sectmacsadm4Not.setVisibility(View.GONE);
                     rdogrptmacsadm4Not.clearCheck();
                     secdtacsfurtherNot.setVisibility(View.GONE);
                     rdogrpdtacsfurtherNot.clearCheck();
                     sectmacsfurtherNot.setVisibility(View.GONE);
                     rdogrptmacsfurtherNot.clearCheck();

                     secMoAgeNot.setVisibility(View.GONE);
                     rdogrpMoAgeNot.clearCheck();
                     secmatbdateNot.setVisibility(View.GONE);
                     rdogrpmatbdateNot.clearCheck();
                     secmatbdate.setVisibility(View.GONE);
                     dtpmatbdate.setText("");

                     secdtdgnmatinfNot.setVisibility(View.GONE);
                     rdogrpdtdgnmatinfNot.clearCheck();
                     sectmdgnmatinfNot.setVisibility(View.GONE);
                     rdogrptmdgnmatinfNot.clearCheck();

                     secdodNot.setVisibility(View.GONE);
                     rdogrpdodNot.clearCheck();
                     secdeathtimeNot.setVisibility(View.GONE);
                     rdogrpdeathtimeNot.clearCheck();
                 }
                 else
                 {
                     secMoAgeNot.setVisibility(View.VISIBLE);
                     secmatbdate.setVisibility(View.VISIBLE);
                     secmatbdateNot.setVisibility(View.VISIBLE);

                     secMoAge.setVisibility(View.VISIBLE);
                     lineMoAge.setVisibility(View.VISIBLE);
                     seclblSectionII.setVisibility(View.VISIBLE);
                     linelblSectionII.setVisibility(View.VISIBLE);
                     secgafirstds.setVisibility(View.VISIBLE);
                     linegafirstds.setVisibility(View.VISIBLE);
                     seclblmatcondprem.setVisibility(View.VISIBLE);
                     linelblmatcondprem.setVisibility(View.VISIBLE);
                     secmatcondpremA.setVisibility(View.VISIBLE);
                     linematcondpremA.setVisibility(View.VISIBLE);
                     //secdtdgnmatcondA.setVisibility(View.VISIBLE);
                     linedtdgnmatcondA.setVisibility(View.VISIBLE);
                     //sectmdgnmatcondA.setVisibility(View.VISIBLE);
                     linetmdgnmatcondA.setVisibility(View.VISIBLE);
                     secmatcondpremB.setVisibility(View.VISIBLE);
                     linematcondpremB.setVisibility(View.VISIBLE);
                     //secdtdgnmatcondB.setVisibility(View.VISIBLE);
                     linedtdgnmatcondB.setVisibility(View.VISIBLE);
                     //sectmdgnmatcondB.setVisibility(View.VISIBLE);
                     linetmdgnmatcondB.setVisibility(View.VISIBLE);
                     secmatcondpremC.setVisibility(View.VISIBLE);
                     linematcondpremC.setVisibility(View.VISIBLE);
                     //secdtdgnmatcondC.setVisibility(View.VISIBLE);
                     linedtdgnmatcondC.setVisibility(View.VISIBLE);
                     //sectmdgnmatcondC.setVisibility(View.VISIBLE);
                     linetmdgnmatcondC.setVisibility(View.VISIBLE);
                     secmatcondpremD.setVisibility(View.VISIBLE);
                     linematcondpremD.setVisibility(View.VISIBLE);
                     //secdtdgnmatcondD.setVisibility(View.VISIBLE);
                     linedtdgnmatcondD.setVisibility(View.VISIBLE);
                     //sectmdgnmatcondD.setVisibility(View.VISIBLE);
                     linetmdgnmatcondD.setVisibility(View.VISIBLE);
                     secmatcondpremE.setVisibility(View.VISIBLE);
                     linematcondpremE.setVisibility(View.VISIBLE);
                     //secdtdgnmatcondE.setVisibility(View.VISIBLE);
                     linedtdgnmatcondE.setVisibility(View.VISIBLE);
                     //sectmdgnmatcondE.setVisibility(View.VISIBLE);
                     linetmdgnmatcondE.setVisibility(View.VISIBLE);
                     secmatcondpremF.setVisibility(View.VISIBLE);
                     linematcondpremF.setVisibility(View.VISIBLE);
                     //secmatcondpremOth.setVisibility(View.VISIBLE);
                     linematcondpremOth.setVisibility(View.VISIBLE);
                     //secdtdgnmatcondF.setVisibility(View.VISIBLE);
                     linedtdgnmatcondF.setVisibility(View.VISIBLE);
                     //sectmdgnmatcondF.setVisibility(View.VISIBLE);
                     linetmdgnmatcondF.setVisibility(View.VISIBLE);
                     secmatcondpremG.setVisibility(View.VISIBLE);
                     linematcondpremG.setVisibility(View.VISIBLE);
                     secmatcondpremH.setVisibility(View.VISIBLE);
                     linematcondpremH.setVisibility(View.VISIBLE);
                     seclblmatinf.setVisibility(View.VISIBLE);
                     linelblmatinf.setVisibility(View.VISIBLE);
                     secmatinfA.setVisibility(View.VISIBLE);
                     linematinfA.setVisibility(View.VISIBLE);
                     secmatinfB.setVisibility(View.VISIBLE);
                     linematinfB.setVisibility(View.VISIBLE);
                     secmatinfC.setVisibility(View.VISIBLE);
                     linematinfC.setVisibility(View.VISIBLE);
                     secmatinfD.setVisibility(View.VISIBLE);
                     linematinfD.setVisibility(View.VISIBLE);
                     secmatinfE.setVisibility(View.VISIBLE);
                     linematinfE.setVisibility(View.VISIBLE);
                     secmatinfF.setVisibility(View.VISIBLE);
                     linematinfF.setVisibility(View.VISIBLE);
                     secmatinfG.setVisibility(View.VISIBLE);
                     linematinfG.setVisibility(View.VISIBLE);
                     secmatinfH.setVisibility(View.VISIBLE);
                     linematinfH.setVisibility(View.VISIBLE);
                     secmatinfI.setVisibility(View.VISIBLE);
                     linematinfI.setVisibility(View.VISIBLE);
                     secmatinfJ.setVisibility(View.VISIBLE);
                     linematinfJ.setVisibility(View.VISIBLE);
                     //secmatinfOth.setVisibility(View.VISIBLE);
                     linematinfOth.setVisibility(View.VISIBLE);
                     secdtdgnmatinf.setVisibility(View.VISIBLE);
                     linedtdgnmatinf.setVisibility(View.VISIBLE);
                     sectmdgnmatinf.setVisibility(View.VISIBLE);
                     linetmdgnmatinf.setVisibility(View.VISIBLE);
                     seclblmatcoinf.setVisibility(View.VISIBLE);
                     linelblmatcoinf.setVisibility(View.VISIBLE);
                     secmatcoinfA.setVisibility(View.VISIBLE);
                     linematcoinfA.setVisibility(View.VISIBLE);
                     secmatcoinfB.setVisibility(View.VISIBLE);
                     linematcoinfB.setVisibility(View.VISIBLE);
                     secmatcoinfC.setVisibility(View.VISIBLE);
                     linematcoinfC.setVisibility(View.VISIBLE);
                     secmatcoinfD.setVisibility(View.VISIBLE);
                     linematcoinfD.setVisibility(View.VISIBLE);
                     secmatcoinfE.setVisibility(View.VISIBLE);
                     linematcoinfE.setVisibility(View.VISIBLE);
                     secmatcoinfF.setVisibility(View.VISIBLE);
                     linematcoinfF.setVisibility(View.VISIBLE);
                     //secmatcoinfOth.setVisibility(View.VISIBLE);
                     linematcoinfOth.setVisibility(View.VISIBLE);
                     secmatcoinftrtmnt.setVisibility(View.VISIBLE);
                     linematcoinftrtmnt.setVisibility(View.VISIBLE);
                     secfetalaus.setVisibility(View.VISIBLE);
                     linefetalaus.setVisibility(View.VISIBLE);
                     secfetalausrate.setVisibility(View.VISIBLE);
                     linefetalausrate.setVisibility(View.VISIBLE);
                     //secfetalausOth.setVisibility(View.VISIBLE);
                     linefetalausOth.setVisibility(View.VISIBLE);
                     seclblSectionIII.setVisibility(View.VISIBLE);
                     linelblSectionIII.setVisibility(View.VISIBLE);
                     secacsadm1.setVisibility(View.VISIBLE);
                     lineacsadm1.setVisibility(View.VISIBLE);

                     /*
                     secdtacs1.setVisibility(View.VISIBLE);
                     linedtacs1.setVisibility(View.VISIBLE);
                     sectmdtacs1.setVisibility(View.VISIBLE);
                     linetmdtacs1.setVisibility(View.VISIBLE);
                     secnameacs1.setVisibility(View.VISIBLE);
                     linenameacs1.setVisibility(View.VISIBLE);
                     secnameacs1Oth.setVisibility(View.VISIBLE);
                     linenameacs1Oth.setVisibility(View.VISIBLE);
                     secacsdose1.setVisibility(View.VISIBLE);
                     lineacsdose1.setVisibility(View.VISIBLE);
                     secacsdose1Oth.setVisibility(View.VISIBLE);
                     lineacsdose1Oth.setVisibility(View.VISIBLE);
                     secacsadm2.setVisibility(View.VISIBLE);
                     lineacsadm2.setVisibility(View.VISIBLE);
                     secdtacsm2.setVisibility(View.VISIBLE);
                     linedtacsm2.setVisibility(View.VISIBLE);
                     sectmacsm2.setVisibility(View.VISIBLE);
                     linetmacsm2.setVisibility(View.VISIBLE);
                     secacsdose2.setVisibility(View.VISIBLE);
                     lineacsdose2.setVisibility(View.VISIBLE);
                     secacsdose2Oth.setVisibility(View.VISIBLE);
                     lineacsdose2Oth.setVisibility(View.VISIBLE);
                     secacsadm3.setVisibility(View.VISIBLE);
                     lineacsadm3.setVisibility(View.VISIBLE);
                     secdtacsadm3.setVisibility(View.VISIBLE);
                     linedtacsadm3.setVisibility(View.VISIBLE);
                     sectmacsadm3.setVisibility(View.VISIBLE);
                     linetmacsadm3.setVisibility(View.VISIBLE);
                     secacsdose3.setVisibility(View.VISIBLE);
                     lineacsdose3.setVisibility(View.VISIBLE);
                     secacsdose3Oth.setVisibility(View.VISIBLE);
                     lineacsdose3Oth.setVisibility(View.VISIBLE);
                     secacsadm4.setVisibility(View.VISIBLE);
                     lineacsadm4.setVisibility(View.VISIBLE);
                     secdtacsadm4.setVisibility(View.VISIBLE);
                     linedtacsadm4.setVisibility(View.VISIBLE);
                     sectmacsadm4.setVisibility(View.VISIBLE);
                     linetmacsadm4.setVisibility(View.VISIBLE);
                     secacsdose4.setVisibility(View.VISIBLE);
                     lineacsdose4.setVisibility(View.VISIBLE);
                     secacsdose4Oth.setVisibility(View.VISIBLE);
                     lineacsdose4Oth.setVisibility(View.VISIBLE);
                     secacsfurther.setVisibility(View.VISIBLE);
                     lineacsfurther.setVisibility(View.VISIBLE);
                     secdtacsfurther.setVisibility(View.VISIBLE);
                     linedtacsfurther.setVisibility(View.VISIBLE);
                     sectmacsfurther.setVisibility(View.VISIBLE);
                     linetmacsfurther.setVisibility(View.VISIBLE);
                     secacsdosefurther.setVisibility(View.VISIBLE);
                     lineacsdosefurther.setVisibility(View.VISIBLE);
                     secacsdosefurtherOth.setVisibility(View.VISIBLE);
                     lineacsdosefurtherOth.setVisibility(View.VISIBLE);
                     */
                     seclblSectionIV.setVisibility(View.VISIBLE);
                     linelblSectionIV.setVisibility(View.VISIBLE);
                     secga.setVisibility(View.VISIBLE);
                     linega.setVisibility(View.VISIBLE);
                     secgar.setVisibility(View.VISIBLE);
                     linegar.setVisibility(View.VISIBLE);
                     secgamethod.setVisibility(View.VISIBLE);
                     linegamethod.setVisibility(View.VISIBLE);
                     secgamethodr.setVisibility(View.VISIBLE);
                     linegamethodr.setVisibility(View.VISIBLE);
                     secbwt.setVisibility(View.VISIBLE);
                     linebwt.setVisibility(View.VISIBLE);
                     secbwtr.setVisibility(View.VISIBLE);
                     linebwtr.setVisibility(View.VISIBLE);
                     secmatcond.setVisibility(View.VISIBLE);
                     linematcond.setVisibility(View.VISIBLE);
                     secbadm.setVisibility(View.VISIBLE);
                     linebadm.setVisibility(View.VISIBLE);
                     secbcond.setVisibility(View.VISIBLE);
                     linebcond.setVisibility(View.VISIBLE);
                     //secstillbirthSp.setVisibility(View.VISIBLE);
                     linestillbirthSp.setVisibility(View.VISIBLE);
                     //secdod.setVisibility(View.VISIBLE);
                     linedod.setVisibility(View.VISIBLE);
                     //secdeathtime.setVisibility(View.VISIBLE);
                     linedeathtime.setVisibility(View.VISIBLE);
                     seclblStatus.setVisibility(View.VISIBLE);
                     linelblStatus.setVisibility(View.VISIBLE);
                     secstatus.setVisibility(View.VISIBLE);
                     linestatus.setVisibility(View.VISIBLE);

                     secdtdgnmatinfNot.setVisibility(View.VISIBLE);
                     sectmdgnmatinfNot.setVisibility(View.VISIBLE);

                     //secdodNot.setVisibility(View.VISIBLE);
                     //secdeathtimeNot.setVisibility(View.VISIBLE);
                 }
             }
             public void onNothingSelected(AdapterView<?> adapterView) {
                 return;
             }
         });


         //Hide all skip variables
          secdtdgnmatcondANot.setVisibility(View.GONE);
          sectmdgnmatcondANot.setVisibility(View.GONE);

          secdtdgnmatcondBNot.setVisibility(View.GONE);
          sectmdgnmatcondBNot.setVisibility(View.GONE);

         secdtdgnmatcondCNot.setVisibility(View.GONE);
         sectmdgnmatcondCNot.setVisibility(View.GONE);

         secdtdgnmatcondDNot.setVisibility(View.GONE);
         sectmdgnmatcondDNot.setVisibility(View.GONE);

          secdtdgnmatcondFNot.setVisibility(View.GONE);
          sectmdgnmatcondFNot.setVisibility(View.GONE);

         secdtdgnmatcondA.setVisibility(View.GONE);
         linedtdgnmatcondA.setVisibility(View.GONE);
         sectmdgnmatcondA.setVisibility(View.GONE);
         linetmdgnmatcondA.setVisibility(View.GONE);
         secdtdgnmatcondB.setVisibility(View.GONE);
         linedtdgnmatcondB.setVisibility(View.GONE);
         sectmdgnmatcondB.setVisibility(View.GONE);
         linetmdgnmatcondB.setVisibility(View.GONE);
         secdtdgnmatcondC.setVisibility(View.GONE);
         linedtdgnmatcondC.setVisibility(View.GONE);
         sectmdgnmatcondC.setVisibility(View.GONE);
         linetmdgnmatcondC.setVisibility(View.GONE);
         secdtdgnmatcondD.setVisibility(View.GONE);
         linedtdgnmatcondD.setVisibility(View.GONE);
         sectmdgnmatcondD.setVisibility(View.GONE);
         linetmdgnmatcondD.setVisibility(View.GONE);
         secdtdgnmatcondE.setVisibility(View.GONE);
         linedtdgnmatcondE.setVisibility(View.GONE);
         sectmdgnmatcondE.setVisibility(View.GONE);
         linetmdgnmatcondE.setVisibility(View.GONE);
         secmatcondpremOth.setVisibility(View.GONE);
         linematcondpremOth.setVisibility(View.GONE);
         secdtdgnmatcondF.setVisibility(View.GONE);
         linedtdgnmatcondF.setVisibility(View.GONE);
         sectmdgnmatcondF.setVisibility(View.GONE);
         linetmdgnmatcondF.setVisibility(View.GONE);
         secmatinfOth.setVisibility(View.GONE);
         linematinfOth.setVisibility(View.GONE);
         secmatcoinfOth.setVisibility(View.GONE);
         linematcoinfOth.setVisibility(View.GONE);
         secfetalausrate.setVisibility(View.GONE);
         linefetalausrate.setVisibility(View.GONE);
         secfetalausOth.setVisibility(View.GONE);
         linefetalausOth.setVisibility(View.GONE);
         //seclblSectionIII.setVisibility(View.GONE);
         linelblSectionIII.setVisibility(View.GONE);
         secfetalausrate.setVisibility(View.GONE);
         linefetalausrate.setVisibility(View.GONE);
         secfetalausOth.setVisibility(View.GONE);
         linefetalausOth.setVisibility(View.GONE);
         //seclblSectionIII.setVisibility(View.GONE);
         linelblSectionIII.setVisibility(View.GONE);
         secfetalausrate.setVisibility(View.GONE);
         linefetalausrate.setVisibility(View.GONE);
         secfetalausOth.setVisibility(View.GONE);
         linefetalausOth.setVisibility(View.GONE);
         //seclblSectionIII.setVisibility(View.GONE);
         linelblSectionIII.setVisibility(View.GONE);
         secfetalausrate.setVisibility(View.GONE);
         linefetalausrate.setVisibility(View.GONE);
         secfetalausOth.setVisibility(View.GONE);
         linefetalausOth.setVisibility(View.GONE);
         //seclblSectionIII.setVisibility(View.GONE);
         linelblSectionIII.setVisibility(View.GONE);
         secdtacs1.setVisibility(View.GONE);
         linedtacs1.setVisibility(View.GONE);
         sectmdtacs1.setVisibility(View.GONE);
         linetmdtacs1.setVisibility(View.GONE);
         secnameacs1.setVisibility(View.GONE);
         linenameacs1.setVisibility(View.GONE);
         secnameacs1Oth.setVisibility(View.GONE);
         linenameacs1Oth.setVisibility(View.GONE);
         secacsdose1.setVisibility(View.GONE);
         lineacsdose1.setVisibility(View.GONE);
         secacsdose1Oth.setVisibility(View.GONE);
         lineacsdose1Oth.setVisibility(View.GONE);
         secacsadm2.setVisibility(View.GONE);
         lineacsadm2.setVisibility(View.GONE);
         secdtacsm2.setVisibility(View.GONE);
         linedtacsm2.setVisibility(View.GONE);
         sectmacsm2.setVisibility(View.GONE);
         linetmacsm2.setVisibility(View.GONE);
         secacsdose2.setVisibility(View.GONE);
         lineacsdose2.setVisibility(View.GONE);
         secacsdose2Oth.setVisibility(View.GONE);
         lineacsdose2Oth.setVisibility(View.GONE);
         secacsadm3.setVisibility(View.GONE);
         lineacsadm3.setVisibility(View.GONE);
         secdtacsadm3.setVisibility(View.GONE);
         linedtacsadm3.setVisibility(View.GONE);
         sectmacsadm3.setVisibility(View.GONE);
         linetmacsadm3.setVisibility(View.GONE);
         secacsdose3.setVisibility(View.GONE);
         lineacsdose3.setVisibility(View.GONE);
         secacsdose3Oth.setVisibility(View.GONE);
         lineacsdose3Oth.setVisibility(View.GONE);
         secacsadm4.setVisibility(View.GONE);
         lineacsadm4.setVisibility(View.GONE);
         secdtacsadm4.setVisibility(View.GONE);
         linedtacsadm4.setVisibility(View.GONE);
         sectmacsadm4.setVisibility(View.GONE);
         linetmacsadm4.setVisibility(View.GONE);
         secacsdose4.setVisibility(View.GONE);
         lineacsdose4.setVisibility(View.GONE);
         secacsdose4Oth.setVisibility(View.GONE);
         lineacsdose4Oth.setVisibility(View.GONE);
         secacsfurther.setVisibility(View.GONE);
         lineacsfurther.setVisibility(View.GONE);
         secdtacsfurther.setVisibility(View.GONE);
         linedtacsfurther.setVisibility(View.GONE);
         sectmacsfurther.setVisibility(View.GONE);
         linetmacsfurther.setVisibility(View.GONE);
         secacsdosefurther.setVisibility(View.GONE);
         lineacsdosefurther.setVisibility(View.GONE);
         secacsdosefurtherOth.setVisibility(View.GONE);
         lineacsdosefurtherOth.setVisibility(View.GONE);
         secdtacs1.setVisibility(View.GONE);
         linedtacs1.setVisibility(View.GONE);
         sectmdtacs1.setVisibility(View.GONE);
         linetmdtacs1.setVisibility(View.GONE);
         secnameacs1.setVisibility(View.GONE);
         linenameacs1.setVisibility(View.GONE);
         secnameacs1Oth.setVisibility(View.GONE);
         linenameacs1Oth.setVisibility(View.GONE);
         secacsdose1.setVisibility(View.GONE);
         lineacsdose1.setVisibility(View.GONE);
         secacsdose1Oth.setVisibility(View.GONE);
         lineacsdose1Oth.setVisibility(View.GONE);
         secacsadm2.setVisibility(View.GONE);
         lineacsadm2.setVisibility(View.GONE);
         secdtacsm2.setVisibility(View.GONE);
         linedtacsm2.setVisibility(View.GONE);
         sectmacsm2.setVisibility(View.GONE);
         linetmacsm2.setVisibility(View.GONE);
         secacsdose2.setVisibility(View.GONE);
         lineacsdose2.setVisibility(View.GONE);
         secacsdose2Oth.setVisibility(View.GONE);
         lineacsdose2Oth.setVisibility(View.GONE);
         secacsadm3.setVisibility(View.GONE);
         lineacsadm3.setVisibility(View.GONE);
         secdtacsadm3.setVisibility(View.GONE);
         linedtacsadm3.setVisibility(View.GONE);
         sectmacsadm3.setVisibility(View.GONE);
         linetmacsadm3.setVisibility(View.GONE);
         secacsdose3.setVisibility(View.GONE);
         lineacsdose3.setVisibility(View.GONE);
         secacsdose3Oth.setVisibility(View.GONE);
         lineacsdose3Oth.setVisibility(View.GONE);
         secacsadm4.setVisibility(View.GONE);
         lineacsadm4.setVisibility(View.GONE);
         secdtacsadm4.setVisibility(View.GONE);
         linedtacsadm4.setVisibility(View.GONE);
         sectmacsadm4.setVisibility(View.GONE);
         linetmacsadm4.setVisibility(View.GONE);
         secacsdose4.setVisibility(View.GONE);
         lineacsdose4.setVisibility(View.GONE);
         secacsdose4Oth.setVisibility(View.GONE);
         lineacsdose4Oth.setVisibility(View.GONE);
         secacsfurther.setVisibility(View.GONE);
         lineacsfurther.setVisibility(View.GONE);
         secdtacsfurther.setVisibility(View.GONE);
         linedtacsfurther.setVisibility(View.GONE);
         sectmacsfurther.setVisibility(View.GONE);
         linetmacsfurther.setVisibility(View.GONE);
         secacsdosefurther.setVisibility(View.GONE);
         lineacsdosefurther.setVisibility(View.GONE);
         secacsdosefurtherOth.setVisibility(View.GONE);
         lineacsdosefurtherOth.setVisibility(View.GONE);
         secdtacs1.setVisibility(View.GONE);
         linedtacs1.setVisibility(View.GONE);
         sectmdtacs1.setVisibility(View.GONE);
         linetmdtacs1.setVisibility(View.GONE);
         secnameacs1.setVisibility(View.GONE);
         linenameacs1.setVisibility(View.GONE);
         secnameacs1Oth.setVisibility(View.GONE);
         linenameacs1Oth.setVisibility(View.GONE);
         secacsdose1.setVisibility(View.GONE);
         lineacsdose1.setVisibility(View.GONE);
         secacsdose1Oth.setVisibility(View.GONE);
         lineacsdose1Oth.setVisibility(View.GONE);
         secacsadm2.setVisibility(View.GONE);
         lineacsadm2.setVisibility(View.GONE);
         secdtacsm2.setVisibility(View.GONE);
         linedtacsm2.setVisibility(View.GONE);
         sectmacsm2.setVisibility(View.GONE);
         linetmacsm2.setVisibility(View.GONE);
         secacsdose2.setVisibility(View.GONE);
         lineacsdose2.setVisibility(View.GONE);
         secacsdose2Oth.setVisibility(View.GONE);
         lineacsdose2Oth.setVisibility(View.GONE);
         secacsadm3.setVisibility(View.GONE);
         lineacsadm3.setVisibility(View.GONE);
         secdtacsadm3.setVisibility(View.GONE);
         linedtacsadm3.setVisibility(View.GONE);
         sectmacsadm3.setVisibility(View.GONE);
         linetmacsadm3.setVisibility(View.GONE);
         secacsdose3.setVisibility(View.GONE);
         lineacsdose3.setVisibility(View.GONE);
         secacsdose3Oth.setVisibility(View.GONE);
         lineacsdose3Oth.setVisibility(View.GONE);
         secacsadm4.setVisibility(View.GONE);
         lineacsadm4.setVisibility(View.GONE);
         secdtacsadm4.setVisibility(View.GONE);
         linedtacsadm4.setVisibility(View.GONE);
         sectmacsadm4.setVisibility(View.GONE);
         linetmacsadm4.setVisibility(View.GONE);
         secacsdose4.setVisibility(View.GONE);
         lineacsdose4.setVisibility(View.GONE);
         secacsdose4Oth.setVisibility(View.GONE);
         lineacsdose4Oth.setVisibility(View.GONE);
         secacsfurther.setVisibility(View.GONE);
         lineacsfurther.setVisibility(View.GONE);
         secdtacsfurther.setVisibility(View.GONE);
         linedtacsfurther.setVisibility(View.GONE);
         sectmacsfurther.setVisibility(View.GONE);
         linetmacsfurther.setVisibility(View.GONE);
         secacsdosefurther.setVisibility(View.GONE);
         lineacsdosefurther.setVisibility(View.GONE);
         secacsdosefurtherOth.setVisibility(View.GONE);
         lineacsdosefurtherOth.setVisibility(View.GONE);
         secnameacs1Oth.setVisibility(View.GONE);
         linenameacs1Oth.setVisibility(View.GONE);
         secnameacs1Oth.setVisibility(View.GONE);
         linenameacs1Oth.setVisibility(View.GONE);
         secnameacs1Oth.setVisibility(View.GONE);
         linenameacs1Oth.setVisibility(View.GONE);
         secnameacs1Oth.setVisibility(View.GONE);
         linenameacs1Oth.setVisibility(View.GONE);
         secnameacs1Oth.setVisibility(View.GONE);
         linenameacs1Oth.setVisibility(View.GONE);
         secacsdose1Oth.setVisibility(View.GONE);
         lineacsdose1Oth.setVisibility(View.GONE);
         secacsdose1Oth.setVisibility(View.GONE);
         lineacsdose1Oth.setVisibility(View.GONE);
         secacsdose1Oth.setVisibility(View.GONE);
         lineacsdose1Oth.setVisibility(View.GONE);
         secacsdose1Oth.setVisibility(View.GONE);
         lineacsdose1Oth.setVisibility(View.GONE);
         secdtacsm2.setVisibility(View.GONE);
         linedtacsm2.setVisibility(View.GONE);
         sectmacsm2.setVisibility(View.GONE);
         linetmacsm2.setVisibility(View.GONE);
         secacsdose2.setVisibility(View.GONE);
         lineacsdose2.setVisibility(View.GONE);
         secacsdose2Oth.setVisibility(View.GONE);
         lineacsdose2Oth.setVisibility(View.GONE);
         secacsadm3.setVisibility(View.GONE);
         lineacsadm3.setVisibility(View.GONE);
         secdtacsadm3.setVisibility(View.GONE);
         linedtacsadm3.setVisibility(View.GONE);
         sectmacsadm3.setVisibility(View.GONE);
         linetmacsadm3.setVisibility(View.GONE);
         secacsdose3.setVisibility(View.GONE);
         lineacsdose3.setVisibility(View.GONE);
         secacsdose3Oth.setVisibility(View.GONE);
         lineacsdose3Oth.setVisibility(View.GONE);
         secacsadm4.setVisibility(View.GONE);
         lineacsadm4.setVisibility(View.GONE);
         secdtacsadm4.setVisibility(View.GONE);
         linedtacsadm4.setVisibility(View.GONE);
         sectmacsadm4.setVisibility(View.GONE);
         linetmacsadm4.setVisibility(View.GONE);
         secacsdose4.setVisibility(View.GONE);
         lineacsdose4.setVisibility(View.GONE);
         secacsdose4Oth.setVisibility(View.GONE);
         lineacsdose4Oth.setVisibility(View.GONE);
         secacsfurther.setVisibility(View.GONE);
         lineacsfurther.setVisibility(View.GONE);
         secdtacsfurther.setVisibility(View.GONE);
         linedtacsfurther.setVisibility(View.GONE);
         sectmacsfurther.setVisibility(View.GONE);
         linetmacsfurther.setVisibility(View.GONE);
         secacsdosefurther.setVisibility(View.GONE);
         lineacsdosefurther.setVisibility(View.GONE);
         secacsdosefurtherOth.setVisibility(View.GONE);
         lineacsdosefurtherOth.setVisibility(View.GONE);
         secdtacsm2.setVisibility(View.GONE);
         linedtacsm2.setVisibility(View.GONE);
         sectmacsm2.setVisibility(View.GONE);
         linetmacsm2.setVisibility(View.GONE);
         secacsdose2.setVisibility(View.GONE);
         lineacsdose2.setVisibility(View.GONE);
         secacsdose2Oth.setVisibility(View.GONE);
         lineacsdose2Oth.setVisibility(View.GONE);
         secacsadm3.setVisibility(View.GONE);
         lineacsadm3.setVisibility(View.GONE);
         secdtacsadm3.setVisibility(View.GONE);
         linedtacsadm3.setVisibility(View.GONE);
         sectmacsadm3.setVisibility(View.GONE);
         linetmacsadm3.setVisibility(View.GONE);
         secacsdose3.setVisibility(View.GONE);
         lineacsdose3.setVisibility(View.GONE);
         secacsdose3Oth.setVisibility(View.GONE);
         lineacsdose3Oth.setVisibility(View.GONE);
         secacsadm4.setVisibility(View.GONE);
         lineacsadm4.setVisibility(View.GONE);
         secdtacsadm4.setVisibility(View.GONE);
         linedtacsadm4.setVisibility(View.GONE);
         sectmacsadm4.setVisibility(View.GONE);
         linetmacsadm4.setVisibility(View.GONE);
         secacsdose4.setVisibility(View.GONE);
         lineacsdose4.setVisibility(View.GONE);
         secacsdose4Oth.setVisibility(View.GONE);
         lineacsdose4Oth.setVisibility(View.GONE);
         secacsfurther.setVisibility(View.GONE);
         lineacsfurther.setVisibility(View.GONE);
         secdtacsfurther.setVisibility(View.GONE);
         linedtacsfurther.setVisibility(View.GONE);
         sectmacsfurther.setVisibility(View.GONE);
         linetmacsfurther.setVisibility(View.GONE);
         secacsdosefurther.setVisibility(View.GONE);
         lineacsdosefurther.setVisibility(View.GONE);
         secacsdosefurtherOth.setVisibility(View.GONE);
         lineacsdosefurtherOth.setVisibility(View.GONE);
         secdtacsm2.setVisibility(View.GONE);
         linedtacsm2.setVisibility(View.GONE);
         sectmacsm2.setVisibility(View.GONE);
         linetmacsm2.setVisibility(View.GONE);
         secacsdose2.setVisibility(View.GONE);
         lineacsdose2.setVisibility(View.GONE);
         secacsdose2Oth.setVisibility(View.GONE);
         lineacsdose2Oth.setVisibility(View.GONE);
         secacsadm3.setVisibility(View.GONE);
         lineacsadm3.setVisibility(View.GONE);
         secdtacsadm3.setVisibility(View.GONE);
         linedtacsadm3.setVisibility(View.GONE);
         sectmacsadm3.setVisibility(View.GONE);
         linetmacsadm3.setVisibility(View.GONE);
         secacsdose3.setVisibility(View.GONE);
         lineacsdose3.setVisibility(View.GONE);
         secacsdose3Oth.setVisibility(View.GONE);
         lineacsdose3Oth.setVisibility(View.GONE);
         secacsadm4.setVisibility(View.GONE);
         lineacsadm4.setVisibility(View.GONE);
         secdtacsadm4.setVisibility(View.GONE);
         linedtacsadm4.setVisibility(View.GONE);
         sectmacsadm4.setVisibility(View.GONE);
         linetmacsadm4.setVisibility(View.GONE);
         secacsdose4.setVisibility(View.GONE);
         lineacsdose4.setVisibility(View.GONE);
         secacsdose4Oth.setVisibility(View.GONE);
         lineacsdose4Oth.setVisibility(View.GONE);
         secacsfurther.setVisibility(View.GONE);
         lineacsfurther.setVisibility(View.GONE);
         secdtacsfurther.setVisibility(View.GONE);
         linedtacsfurther.setVisibility(View.GONE);
         sectmacsfurther.setVisibility(View.GONE);
         linetmacsfurther.setVisibility(View.GONE);
         secacsdosefurther.setVisibility(View.GONE);
         lineacsdosefurther.setVisibility(View.GONE);
         secacsdosefurtherOth.setVisibility(View.GONE);
         lineacsdosefurtherOth.setVisibility(View.GONE);
         secacsdose2Oth.setVisibility(View.GONE);
         lineacsdose2Oth.setVisibility(View.GONE);
         secacsdose2Oth.setVisibility(View.GONE);
         lineacsdose2Oth.setVisibility(View.GONE);
         secacsdose2Oth.setVisibility(View.GONE);
         lineacsdose2Oth.setVisibility(View.GONE);
         secacsdose2Oth.setVisibility(View.GONE);
         lineacsdose2Oth.setVisibility(View.GONE);
         secdtacsadm3.setVisibility(View.GONE);
         linedtacsadm3.setVisibility(View.GONE);
         sectmacsadm3.setVisibility(View.GONE);
         linetmacsadm3.setVisibility(View.GONE);
         secacsdose3.setVisibility(View.GONE);
         lineacsdose3.setVisibility(View.GONE);
         secacsdose3Oth.setVisibility(View.GONE);
         lineacsdose3Oth.setVisibility(View.GONE);
         secacsadm4.setVisibility(View.GONE);
         lineacsadm4.setVisibility(View.GONE);
         secdtacsadm4.setVisibility(View.GONE);
         linedtacsadm4.setVisibility(View.GONE);
         sectmacsadm4.setVisibility(View.GONE);
         linetmacsadm4.setVisibility(View.GONE);
         secacsdose4.setVisibility(View.GONE);
         lineacsdose4.setVisibility(View.GONE);
         secacsdose4Oth.setVisibility(View.GONE);
         lineacsdose4Oth.setVisibility(View.GONE);
         secacsfurther.setVisibility(View.GONE);
         lineacsfurther.setVisibility(View.GONE);
         secdtacsfurther.setVisibility(View.GONE);
         linedtacsfurther.setVisibility(View.GONE);
         sectmacsfurther.setVisibility(View.GONE);
         linetmacsfurther.setVisibility(View.GONE);
         secacsdosefurther.setVisibility(View.GONE);
         lineacsdosefurther.setVisibility(View.GONE);
         secacsdosefurtherOth.setVisibility(View.GONE);
         lineacsdosefurtherOth.setVisibility(View.GONE);
         secdtacsadm3.setVisibility(View.GONE);
         linedtacsadm3.setVisibility(View.GONE);
         sectmacsadm3.setVisibility(View.GONE);
         linetmacsadm3.setVisibility(View.GONE);
         secacsdose3.setVisibility(View.GONE);
         lineacsdose3.setVisibility(View.GONE);
         secacsdose3Oth.setVisibility(View.GONE);
         lineacsdose3Oth.setVisibility(View.GONE);
         secacsadm4.setVisibility(View.GONE);
         lineacsadm4.setVisibility(View.GONE);
         secdtacsadm4.setVisibility(View.GONE);
         linedtacsadm4.setVisibility(View.GONE);
         sectmacsadm4.setVisibility(View.GONE);
         linetmacsadm4.setVisibility(View.GONE);
         secacsdose4.setVisibility(View.GONE);
         lineacsdose4.setVisibility(View.GONE);
         secacsdose4Oth.setVisibility(View.GONE);
         lineacsdose4Oth.setVisibility(View.GONE);
         secacsfurther.setVisibility(View.GONE);
         lineacsfurther.setVisibility(View.GONE);
         secdtacsfurther.setVisibility(View.GONE);
         linedtacsfurther.setVisibility(View.GONE);
         sectmacsfurther.setVisibility(View.GONE);
         linetmacsfurther.setVisibility(View.GONE);
         secacsdosefurther.setVisibility(View.GONE);
         lineacsdosefurther.setVisibility(View.GONE);
         secacsdosefurtherOth.setVisibility(View.GONE);
         lineacsdosefurtherOth.setVisibility(View.GONE);
         secdtacsadm3.setVisibility(View.GONE);
         linedtacsadm3.setVisibility(View.GONE);
         sectmacsadm3.setVisibility(View.GONE);
         linetmacsadm3.setVisibility(View.GONE);
         secacsdose3.setVisibility(View.GONE);
         lineacsdose3.setVisibility(View.GONE);
         secacsdose3Oth.setVisibility(View.GONE);
         lineacsdose3Oth.setVisibility(View.GONE);
         secacsadm4.setVisibility(View.GONE);
         lineacsadm4.setVisibility(View.GONE);
         secdtacsadm4.setVisibility(View.GONE);
         linedtacsadm4.setVisibility(View.GONE);
         sectmacsadm4.setVisibility(View.GONE);
         linetmacsadm4.setVisibility(View.GONE);
         secacsdose4.setVisibility(View.GONE);
         lineacsdose4.setVisibility(View.GONE);
         secacsdose4Oth.setVisibility(View.GONE);
         lineacsdose4Oth.setVisibility(View.GONE);
         secacsfurther.setVisibility(View.GONE);
         lineacsfurther.setVisibility(View.GONE);
         secdtacsfurther.setVisibility(View.GONE);
         linedtacsfurther.setVisibility(View.GONE);
         sectmacsfurther.setVisibility(View.GONE);
         linetmacsfurther.setVisibility(View.GONE);
         secacsdosefurther.setVisibility(View.GONE);
         lineacsdosefurther.setVisibility(View.GONE);
         secacsdosefurtherOth.setVisibility(View.GONE);
         lineacsdosefurtherOth.setVisibility(View.GONE);
         secacsdose3Oth.setVisibility(View.GONE);
         lineacsdose3Oth.setVisibility(View.GONE);
         secacsdose3Oth.setVisibility(View.GONE);
         lineacsdose3Oth.setVisibility(View.GONE);
         secacsdose3Oth.setVisibility(View.GONE);
         lineacsdose3Oth.setVisibility(View.GONE);
         secacsdose3Oth.setVisibility(View.GONE);
         lineacsdose3Oth.setVisibility(View.GONE);
         secdtacsadm4.setVisibility(View.GONE);
         linedtacsadm4.setVisibility(View.GONE);
         sectmacsadm4.setVisibility(View.GONE);
         linetmacsadm4.setVisibility(View.GONE);
         secacsdose4.setVisibility(View.GONE);
         lineacsdose4.setVisibility(View.GONE);
         secacsdose4Oth.setVisibility(View.GONE);
         lineacsdose4Oth.setVisibility(View.GONE);
         secacsfurther.setVisibility(View.GONE);
         lineacsfurther.setVisibility(View.GONE);
         secdtacsfurther.setVisibility(View.GONE);
         linedtacsfurther.setVisibility(View.GONE);
         sectmacsfurther.setVisibility(View.GONE);
         linetmacsfurther.setVisibility(View.GONE);
         secacsdosefurther.setVisibility(View.GONE);
         lineacsdosefurther.setVisibility(View.GONE);
         secacsdosefurtherOth.setVisibility(View.GONE);
         lineacsdosefurtherOth.setVisibility(View.GONE);
         secdtacsadm4.setVisibility(View.GONE);
         linedtacsadm4.setVisibility(View.GONE);
         sectmacsadm4.setVisibility(View.GONE);
         linetmacsadm4.setVisibility(View.GONE);
         secacsdose4.setVisibility(View.GONE);
         lineacsdose4.setVisibility(View.GONE);
         secacsdose4Oth.setVisibility(View.GONE);
         lineacsdose4Oth.setVisibility(View.GONE);
         secacsfurther.setVisibility(View.GONE);
         lineacsfurther.setVisibility(View.GONE);
         secdtacsfurther.setVisibility(View.GONE);
         linedtacsfurther.setVisibility(View.GONE);
         sectmacsfurther.setVisibility(View.GONE);
         linetmacsfurther.setVisibility(View.GONE);
         secacsdosefurther.setVisibility(View.GONE);
         lineacsdosefurther.setVisibility(View.GONE);
         secacsdosefurtherOth.setVisibility(View.GONE);
         lineacsdosefurtherOth.setVisibility(View.GONE);
         secdtacsadm4.setVisibility(View.GONE);
         linedtacsadm4.setVisibility(View.GONE);
         sectmacsadm4.setVisibility(View.GONE);
         linetmacsadm4.setVisibility(View.GONE);
         secacsdose4.setVisibility(View.GONE);
         lineacsdose4.setVisibility(View.GONE);
         secacsdose4Oth.setVisibility(View.GONE);
         lineacsdose4Oth.setVisibility(View.GONE);
         secacsfurther.setVisibility(View.GONE);
         lineacsfurther.setVisibility(View.GONE);
         secdtacsfurther.setVisibility(View.GONE);
         linedtacsfurther.setVisibility(View.GONE);
         sectmacsfurther.setVisibility(View.GONE);
         linetmacsfurther.setVisibility(View.GONE);
         secacsdosefurther.setVisibility(View.GONE);
         lineacsdosefurther.setVisibility(View.GONE);
         secacsdosefurtherOth.setVisibility(View.GONE);
         lineacsdosefurtherOth.setVisibility(View.GONE);
         secacsdose4Oth.setVisibility(View.GONE);
         lineacsdose4Oth.setVisibility(View.GONE);
         secacsdose4Oth.setVisibility(View.GONE);
         lineacsdose4Oth.setVisibility(View.GONE);
         secacsdose4Oth.setVisibility(View.GONE);
         lineacsdose4Oth.setVisibility(View.GONE);
         secacsdose4Oth.setVisibility(View.GONE);
         lineacsdose4Oth.setVisibility(View.GONE);
         secacsdosefurtherOth.setVisibility(View.GONE);
         lineacsdosefurtherOth.setVisibility(View.GONE);
         //seclblSectionIV.setVisibility(View.GONE);
         //linelblSectionIV.setVisibility(View.GONE);
         secacsdosefurtherOth.setVisibility(View.GONE);
         lineacsdosefurtherOth.setVisibility(View.GONE);
         //seclblSectionIV.setVisibility(View.GONE);
         //linelblSectionIV.setVisibility(View.GONE);
         secacsdosefurtherOth.setVisibility(View.GONE);
         lineacsdosefurtherOth.setVisibility(View.GONE);
         //seclblSectionIV.setVisibility(View.GONE);
         //linelblSectionIV.setVisibility(View.GONE);
         secacsdosefurtherOth.setVisibility(View.GONE);
         lineacsdosefurtherOth.setVisibility(View.GONE);
         //seclblSectionIV.setVisibility(View.GONE);
         //linelblSectionIV.setVisibility(View.GONE);
         secstillbirthSp.setVisibility(View.GONE);
         linestillbirthSp.setVisibility(View.GONE);
         secdod.setVisibility(View.GONE);
         linedod.setVisibility(View.GONE);
         secdeathtime.setVisibility(View.GONE);
         linedeathtime.setVisibility(View.GONE);
         /*seclblStatus.setVisibility(View.GONE);
         linelblStatus.setVisibility(View.GONE);
         secstatus.setVisibility(View.GONE);
         linestatus.setVisibility(View.GONE);*/
         secreason.setVisibility(View.GONE);
         linereason.setVisibility(View.GONE);
         secreasmention.setVisibility(View.GONE);
         linereasmention.setVisibility(View.GONE);
         secstillbirthSp.setVisibility(View.GONE);
         linestillbirthSp.setVisibility(View.GONE);
         secdod.setVisibility(View.GONE);
         linedod.setVisibility(View.GONE);
         secdeathtime.setVisibility(View.GONE);
         linedeathtime.setVisibility(View.GONE);
         /*seclblStatus.setVisibility(View.GONE);
         linelblStatus.setVisibility(View.GONE);
         secstatus.setVisibility(View.GONE);
         linestatus.setVisibility(View.GONE);
         secreason.setVisibility(View.GONE);
         linereason.setVisibility(View.GONE);
         secreasmention.setVisibility(View.GONE);
         linereasmention.setVisibility(View.GONE);
         secreason.setVisibility(View.GONE);
         linereason.setVisibility(View.GONE);
         secreasmention.setVisibility(View.GONE);
         linereasmention.setVisibility(View.GONE);*/
         secdtacs1Not.setVisibility(View.GONE);
         sectmdtacs1Not.setVisibility(View.GONE);
         secdtacsm2Not.setVisibility(View.GONE);
         sectmacsm2Not.setVisibility(View.GONE);
         secdtacsadm3Not.setVisibility(View.GONE);
         sectmacsadm3Not.setVisibility(View.GONE);
         secdtacsadm4Not.setVisibility(View.GONE);
         sectmacsadm4Not.setVisibility(View.GONE);
         secdtacsfurtherNot.setVisibility(View.GONE);
         sectmacsfurtherNot.setVisibility(View.GONE);

         //secbwtr.setVisibility(View.GONE);
         secdodNot.setVisibility(View.GONE);
         secdeathtimeNot.setVisibility(View.GONE);


          DataSearch(COUNTRYCODE, FACICODE, DATAID);
        Button cmdSave = (Button) findViewById(R.id.cmdSave);
        cmdSave.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            DataSave();
        }});
     }
     catch(Exception  e)
     {
         Connection.MessageBox(Acs_Veri1.this, e.getMessage());
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
             Connection.MessageBox(Acs_Veri1.this, "Required field: CountryCode.");
             txtCountryCode.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtCountryCode.getText().toString().length()==0 ? "1" : txtCountryCode.getText().toString()) < 1 || Integer.valueOf(txtCountryCode.getText().toString().length()==0 ? "3" : txtCountryCode.getText().toString()) > 3)
           {
             Connection.MessageBox(Acs_Veri1.this, "Value should be between 1 and 3(CountryCode).");
             txtCountryCode.requestFocus(); 
             return;	
           }
         else if(txtFaciCode.getText().toString().length()==0 & secFaciCode.isShown())
           {
             Connection.MessageBox(Acs_Veri1.this, "Required field: Facility.");
             txtFaciCode.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtFaciCode.getText().toString().length()==0 ? "1" : txtFaciCode.getText().toString()) < 1 || Integer.valueOf(txtFaciCode.getText().toString().length()==0 ? "9" : txtFaciCode.getText().toString()) > 9)
           {
             Connection.MessageBox(Acs_Veri1.this, "Value should be between 1 and 9(Facility).");
             txtFaciCode.requestFocus(); 
             return;	
           }
         else if(txtDataID.getText().toString().length()==0 & secDataID.isShown())
           {
             Connection.MessageBox(Acs_Veri1.this, "Required field: Data ID.");
             txtDataID.requestFocus(); 
             return;	
           }
         else if(txtParticipantID.getText().toString().length()==0 & secParticipantID.isShown())
           {
             Connection.MessageBox(Acs_Veri1.this, "Required field: Participant ID.");
             txtParticipantID.requestFocus(); 
             return;	
           }
         
         else if(!rdomatobsv1.isChecked() & !rdomatobsv2.isChecked() & secmatobsv.isShown())
           {
              Connection.MessageBox(Acs_Veri1.this, "Select anyone options from (Mother observed during labour & Delivery).");
              rdomatobsv1.requestFocus();
              return;
           }
         else if(txtmatname.getText().toString().length()==0 & !rdocrform1.isChecked() & !rdocrform2.isChecked() & secmatname.isShown())
           {
             Connection.MessageBox(Acs_Veri1.this, "Required field: Mother Name.");
             txtmatname.requestFocus(); 
             return;	
           }
         else if(txtMoAge.getText().toString().length()==0 & !rdoMoAgeNot1.isChecked() & !rdoMoAgeNot2.isChecked() & secMoAge.isShown())
           {
             Connection.MessageBox(Acs_Veri1.this, "Required field: Mother Age (Years).");
             txtMoAge.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtMoAge.getText().toString().length()==0 ? "15" : txtMoAge.getText().toString()) < 15 || Integer.valueOf(txtMoAge.getText().toString().length()==0 ? "49" : txtMoAge.getText().toString()) > 49)
           {
             Connection.MessageBox(Acs_Veri1.this, "Value should be between 15 and 49(Mother Age (Years)).");
             txtMoAge.requestFocus(); 
             return;	
           }
         DV = Global.DateValidate(dtpmatbdate.getText().toString());
         if(DV.length()!=0 & !rdomatbdateNot1.isChecked() & !rdomatbdateNot2.isChecked() & secmatbdate.isShown())
           {
             Connection.MessageBox(Acs_Veri1.this, "Invalid Date: 7. Mother Date of birth.");
             dtpmatbdate.requestFocus(); 
             return;	
           }
         else if(spngafirstds.getSelectedItemPosition()==0  & secgafirstds.isShown())
           {
             Connection.MessageBox(Acs_Veri1.this, "Required field: Gestational age on Administration of first dose.");
             spngafirstds.requestFocus(); 
             return;	
           }
         DV = Global.DateValidate(dtpdtdgnmatcondA.getText().toString());
         if(DV.length()!=0 & secdtdgnmatcondA.isShown() & !rdodtdgnmatcondANot1.isChecked() & !rdodtdgnmatcondANot2.isChecked())
           {
             Connection.MessageBox(Acs_Veri1.this, "Invalid Date: 9.a Date of Diagnosis");
             dtpdtdgnmatcondA.requestFocus(); 
             return;	
           }
         else if(txttmdgnmatcondA.getText().length()==0 & sectmdgnmatcondA.isShown() & !rdotmdgnmatcondANot1.isChecked() & !rdotmdgnmatcondANot2.isChecked())
           {
             Connection.MessageBox(Acs_Veri1.this, "Required field:    Time of Diagnosis.");
             txttmdgnmatcondA.requestFocus(); 
             return;	
           }
         DV = Global.DateValidate(dtpdtdgnmatcondB.getText().toString());
         if(DV.length()!=0 & secdtdgnmatcondB.isShown() & !rdodtdgnmatcondBNot1.isChecked() & !rdodtdgnmatcondBNot2.isChecked())
           {
             Connection.MessageBox(Acs_Veri1.this, "Invalid Date: 9.b Date of Diagnosis");
             dtpdtdgnmatcondB.requestFocus(); 
             return;	
           }
         else if(txttmdgnmatcondB.getText().length()==0 & sectmdgnmatcondB.isShown() & !rdotmdgnmatcondBNot1.isChecked() & !rdotmdgnmatcondBNot2.isChecked())
           {
             Connection.MessageBox(Acs_Veri1.this, "Required field:    Time of Diagnosis.");
             txttmdgnmatcondB.requestFocus(); 
             return;	
           }
         DV = Global.DateValidate(dtpdtdgnmatcondC.getText().toString());
         if(DV.length()!=0 & secdtdgnmatcondC.isShown() & !rdodtdgnmatcondCNot1.isChecked() & !rdodtdgnmatcondCNot2.isChecked())
           {
             Connection.MessageBox(Acs_Veri1.this, "Invalid Date: 9.c Date of Diagnosis");
             dtpdtdgnmatcondC.requestFocus(); 
             return;	
           }
         else if(txttmdgnmatcondC.getText().length()==0 & sectmdgnmatcondC.isShown() & !rdotmdgnmatcondCNot1.isChecked() & !rdotmdgnmatcondCNot2.isChecked())
           {
             Connection.MessageBox(Acs_Veri1.this, "Required field:    Time of Diagnosis.");
             txttmdgnmatcondC.requestFocus(); 
             return;	
           }
         DV = Global.DateValidate(dtpdtdgnmatcondD.getText().toString());
         if(DV.length()!=0 & secdtdgnmatcondD.isShown() & !rdodtdgnmatcondDNot1.isChecked() & !rdodtdgnmatcondDNot2.isChecked())
           {
             Connection.MessageBox(Acs_Veri1.this, "Invalid Date: 9.d Date of Diagnosis");
             dtpdtdgnmatcondD.requestFocus(); 
             return;	
           }
         else if(txttmdgnmatcondD.getText().length()==0 & sectmdgnmatcondD.isShown() & !rdotmdgnmatcondDNot1.isChecked() & !rdotmdgnmatcondDNot2.isChecked())
           {
             Connection.MessageBox(Acs_Veri1.this, "Required field:    Time of Diagnosis.");
             txttmdgnmatcondD.requestFocus(); 
             return;	
           }
         /*DV = Global.DateValidate(dtpdtdgnmatcondE.getText().toString());
         if(DV.length()!=0 & secdtdgnmatcondE.isShown())
           {
             Connection.MessageBox(Acs_Veri.this, "Invalid Date: 9.e Date of Diagnosis");
             dtpdtdgnmatcondE.requestFocus(); 
             return;	
           }
         else if(txttmdgnmatcondE.getText().length()==0 & sectmdgnmatcondE.isShown())
           {
             Connection.MessageBox(Acs_Veri.this, "Required field:    Time of Diagnosis.");
             txttmdgnmatcondE.requestFocus(); 
             return;	
           }*/
         else if(txtmatcondpremOth.getText().toString().length()==0 & secmatcondpremOth.isShown())
           {
             Connection.MessageBox(Acs_Veri1.this, "Required field:    Other Specify.");
             txtmatcondpremOth.requestFocus(); 
             return;	
           }
         DV = Global.DateValidate(dtpdtdgnmatcondF.getText().toString());
         if(DV.length()!=0 & secdtdgnmatcondF.isShown()  & !rdodtdgnmatcondFNot1.isChecked() & !rdodtdgnmatcondFNot2.isChecked())
           {
             Connection.MessageBox(Acs_Veri1.this, "Invalid Date: 9.f Date of Diagnosis");
             dtpdtdgnmatcondF.requestFocus();
             return;	
           }
         else if(txttmdgnmatcondF.getText().length()==0 & sectmdgnmatcondF.isShown() & !rdotmdgnmatcondFNot1.isChecked() & !rdotmdgnmatcondFNot2.isChecked())
           {
             Connection.MessageBox(Acs_Veri1.this, "Required field:    Time of Diagnosis.");
             txttmdgnmatcondF.requestFocus(); 
             return;	
           }
         else if(txtmatinfOth.getText().toString().length()==0 & secmatinfOth.isShown())
           {
             Connection.MessageBox(Acs_Veri1.this, "Required field:    Other specify.");
             txtmatinfOth.requestFocus(); 
             return;	
           }
         DV = Global.DateValidate(dtpdtdgnmatinf.getText().toString());
         if(DV.length()!=0 & secdtdgnmatinf.isShown() & !rdodtdgnmatinfNot1.isChecked() & !rdodtdgnmatinfNot2.isChecked())
           {
             Connection.MessageBox(Acs_Veri1.this, "Invalid Date: 11.Date of Symptom documented in maternal notes.");
             dtpdtdgnmatinf.requestFocus(); 
             return;	
           }
         else if(txttmdgnmatinf.getText().length()==0 & sectmdgnmatinf.isShown() & !rdotmdgnmatinfNot1.isChecked() & !rdotmdgnmatinfNot2.isChecked())
           {
             Connection.MessageBox(Acs_Veri1.this, "Required field: Time of Symptom documented in maternal notes.");
             txttmdgnmatinf.requestFocus(); 
             return;	
           }
         else if(txtmatcoinfOth.getText().toString().length()==0 & secmatcoinfOth.isShown())
           {
             Connection.MessageBox(Acs_Veri1.this, "Required field:    Other Specify.");
             txtmatcoinfOth.requestFocus(); 
             return;	
           }
         
         else if(!rdomatcoinftrtmnt1.isChecked() & !rdomatcoinftrtmnt2.isChecked() & !rdomatcoinftrtmnt3.isChecked() & !rdomatcoinftrtmnt4.isChecked() & secmatcoinftrtmnt.isShown())
           {
              Connection.MessageBox(Acs_Veri1.this, "Select anyone options from (If co-infection has been identified in above question is the participant currently receiving treatment).");
              rdomatcoinftrtmnt1.requestFocus();
              return;
           }
         
         else if(!rdofetalaus1.isChecked() & !rdofetalaus2.isChecked() & !rdofetalaus3.isChecked() & !rdofetalaus4.isChecked() & !rdofetalaus5.isChecked() & !rdofetalaus6.isChecked() & secfetalaus.isShown())
           {
              Connection.MessageBox(Acs_Veri1.this, "Select anyone options from (Fetal Heart tone auscultated prior to administering ACS?).");
              rdofetalaus1.requestFocus();
              return;
           }
         else if(txtfetalausrate.getText().toString().length()==0 & secfetalausrate.isShown())
           {
             Connection.MessageBox(Acs_Veri1.this, "Required field: If documented what was the rate.");
             txtfetalausrate.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtfetalausrate.getText().toString().length()==0 ? "1" : txtfetalausrate.getText().toString()) < 1 || Integer.valueOf(txtfetalausrate.getText().toString().length()==0 ? "999" : txtfetalausrate.getText().toString()) > 999)
           {
             Connection.MessageBox(Acs_Veri1.this, "Value should be between 1 and 999(If documented what was the rate).");
             txtfetalausrate.requestFocus(); 
             return;	
           }
         else if(txtfetalausOth.getText().toString().length()==0 & secfetalausOth.isShown())
           {
             Connection.MessageBox(Acs_Veri1.this, "Required field:    Other Specify.");
             txtfetalausOth.requestFocus(); 
             return;	
           }
         
         else if(!rdoacsadm11.isChecked() & !rdoacsadm12.isChecked() & !rdoacsadm13.isChecked() & !rdoacsadm14.isChecked() & secacsadm1.isShown())
           {
              Connection.MessageBox(Acs_Veri1.this, "Select anyone options from (ACS documented as administered ?).");
              rdoacsadm11.requestFocus();
              return;
           }
         DV = Global.DateValidate(dtpdtacs1.getText().toString());
         if(DV.length()!=0 & !rdodtacs1Not1.isChecked() & !rdodtacs1Not2.isChecked() & secdtacs1.isShown())
           {
             Connection.MessageBox(Acs_Veri1.this, "Invalid Date: 16. Date of Administrator of first dose (as documented in the maternal medical record)");
             dtpdtacs1.requestFocus(); 
             return;	
           }
         else if(txttmdtacs1.getText().length()==0 & !rdotmdtacs1Not1.isChecked() & !rdotmdtacs1Not2.isChecked() & sectmdtacs1.isShown())
           {
             Connection.MessageBox(Acs_Veri1.this, "Required field: Time of Administrator of first dose.");
             txttmdtacs1.requestFocus(); 
             return;	
           }
         
         else if(!rdonameacs11.isChecked() & !rdonameacs12.isChecked() & !rdonameacs13.isChecked() & !rdonameacs14.isChecked() & !rdonameacs15.isChecked() & !rdonameacs16.isChecked() & secnameacs1.isShown())
           {
              Connection.MessageBox(Acs_Veri1.this, "Select anyone options from (Name of drug Administered).");
              rdonameacs11.requestFocus();
              return;
           }
         else if(txtnameacs1Oth.getText().toString().length()==0 & secnameacs1Oth.isShown())
           {
             Connection.MessageBox(Acs_Veri1.this, "Required field:    Other Specify.");
             txtnameacs1Oth.requestFocus(); 
             return;	
           }
         
         else if(!rdoacsdose11.isChecked() & !rdoacsdose12.isChecked() & !rdoacsdose13.isChecked() & !rdoacsdose14.isChecked() & !rdoacsdose15.isChecked() & secacsdose1.isShown())
           {
              Connection.MessageBox(Acs_Veri1.this, "Select anyone options from (Documented dose administered ?).");
              rdoacsdose11.requestFocus();
              return;
           }
         else if(txtacsdose1Oth.getText().toString().length()==0 & secacsdose1Oth.isShown())
           {
             Connection.MessageBox(Acs_Veri1.this, "Required field:    Other Specify.");
             txtacsdose1Oth.requestFocus(); 
             return;	
           }
         
         else if(!rdoacsadm21.isChecked() & !rdoacsadm22.isChecked() & !rdoacsadm23.isChecked() & !rdoacsadm24.isChecked() & secacsadm2.isShown())
           {
              Connection.MessageBox(Acs_Veri1.this, "Select anyone options from (2nd dose of ACS administered ?).");
              rdoacsadm21.requestFocus();
              return;
           }
         DV = Global.DateValidate(dtpdtacsm2.getText().toString());
         if(DV.length()!=0 & !rdodtacsm2Not1.isChecked() & !rdodtacsm2Not2.isChecked() & secdtacsm2.isShown())
           {
             Connection.MessageBox(Acs_Veri1.this, "Invalid Date: 20. Date Administrator 2nd dose (As documented in the maternal medical record)");
             dtpdtacsm2.requestFocus(); 
             return;	
           }
         else if(txttmacsm2.getText().length()==0 & !rdotmacsm2Not1.isChecked() & !rdotmacsm2Not2.isChecked() & sectmacsm2.isShown())
           {
             Connection.MessageBox(Acs_Veri1.this, "Required field: Time of administrator.");
             txttmacsm2.requestFocus(); 
             return;	
           }
         
         else if(!rdoacsdose21.isChecked() & !rdoacsdose22.isChecked() & !rdoacsdose23.isChecked() & !rdoacsdose24.isChecked() & !rdoacsdose25.isChecked() & secacsdose2.isShown())
           {
              Connection.MessageBox(Acs_Veri1.this, "Select anyone options from (Documented dose administerd).");
              rdoacsdose21.requestFocus();
              return;
           }
         else if(txtacsdose2Oth.getText().toString().length()==0 & secacsdose2Oth.isShown())
           {
             Connection.MessageBox(Acs_Veri1.this, "Required field:    Other Specify.");
             txtacsdose2Oth.requestFocus(); 
             return;	
           }
         
         else if(!rdoacsadm31.isChecked() & !rdoacsadm32.isChecked() & !rdoacsadm33.isChecked() & !rdoacsadm34.isChecked() & secacsadm3.isShown())
           {
              Connection.MessageBox(Acs_Veri1.this, "Select anyone options from (3rd dose of ACS administrator ?).");
              rdoacsadm31.requestFocus();
              return;
           }
         DV = Global.DateValidate(dtpdtacsadm3.getText().toString());
         if(DV.length()!=0 & !rdodtacsadm3Not1.isChecked() & !rdodtacsadm3Not2.isChecked() & secdtacsadm3.isShown())
           {
             Connection.MessageBox(Acs_Veri1.this, "Invalid Date: 23. Date of administrator 3rd dose (As documented in the maternal medical record)");
             dtpdtacsadm3.requestFocus(); 
             return;	
           }
         else if(txttmacsadm3.getText().length()==0 & !rdotmacsadm3Not1.isChecked() & !rdotmacsadm3Not2.isChecked() & sectmacsadm3.isShown())
           {
             Connection.MessageBox(Acs_Veri1.this, "Required field: Time of administration of 3rd dose.");
             txttmacsadm3.requestFocus(); 
             return;	
           }
         
         else if(!rdoacsdose31.isChecked() & !rdoacsdose32.isChecked() & !rdoacsdose33.isChecked() & !rdoacsdose34.isChecked() & !rdoacsdose35.isChecked() & secacsdose3.isShown())
           {
              Connection.MessageBox(Acs_Veri1.this, "Select anyone options from (Documented dose administered ?).");
              rdoacsdose31.requestFocus();
              return;
           }
         else if(txtacsdose3Oth.getText().toString().length()==0 & secacsdose3Oth.isShown())
           {
             Connection.MessageBox(Acs_Veri1.this, "Required field:    Other specify.");
             txtacsdose3Oth.requestFocus(); 
             return;	
           }
         
         else if(!rdoacsadm41.isChecked() & !rdoacsadm42.isChecked() & !rdoacsadm43.isChecked() & !rdoacsadm44.isChecked() & secacsadm4.isShown())
           {
              Connection.MessageBox(Acs_Veri1.this, "Select anyone options from (4th dose of ACS administered ?).");
              rdoacsadm41.requestFocus();
              return;
           }
         DV = Global.DateValidate(dtpdtacsadm4.getText().toString());
         if(DV.length()!=0 & !rdodtacsadm4Not1.isChecked() & !rdodtacsadm4Not2.isChecked() & secdtacsadm4.isShown())
           {
             Connection.MessageBox(Acs_Veri1.this, "Invalid Date: 26. Date of administration 4th dose");
             dtpdtacsadm4.requestFocus(); 
             return;	
           }
         else if(txttmacsadm4.getText().length()==0 & !rdotmacsadm4Not1.isChecked() & !rdotmacsadm4Not2.isChecked() & sectmacsadm4.isShown())
           {
             Connection.MessageBox(Acs_Veri1.this, "Required field: Time of administration 4th dose.");
             txttmacsadm4.requestFocus(); 
             return;	
           }
         
         else if(!rdoacsdose41.isChecked() & !rdoacsdose42.isChecked() & !rdoacsdose43.isChecked() & !rdoacsdose44.isChecked() & !rdoacsdose45.isChecked() & secacsdose4.isShown())
           {
              Connection.MessageBox(Acs_Veri1.this, "Select anyone options from (Documented dose administered).");
              rdoacsdose41.requestFocus();
              return;
           }
         else if(txtacsdose4Oth.getText().toString().length()==0 & secacsdose4Oth.isShown())
           {
             Connection.MessageBox(Acs_Veri1.this, "Required field:    Other Specify.");
             txtacsdose4Oth.requestFocus(); 
             return;	
           }
         
         else if(!rdoacsfurther1.isChecked() & !rdoacsfurther2.isChecked() & !rdoacsfurther3.isChecked() & !rdoacsfurther4.isChecked() & secacsfurther.isShown())
           {
              Connection.MessageBox(Acs_Veri1.this, "Select anyone options from (Further dose of ACS administered ?).");
              rdoacsfurther1.requestFocus();
              return;
           }
         DV = Global.DateValidate(dtpdtacsfurther.getText().toString());
         if(DV.length()!=0 & !rdodtacsfurtherNot1.isChecked() & !rdodtacsfurtherNot2.isChecked() & secdtacsfurther.isShown())
           {
             Connection.MessageBox(Acs_Veri1.this, "Invalid Date: Date of administration further dose (As documented in the maternal medical record)");
             dtpdtacsfurther.requestFocus(); 
             return;	
           }
         else if(txttmacsfurther.getText().length()==0 & !rdotmacsfurtherNot1.isChecked() & !rdotmacsfurtherNot2.isChecked() & sectmacsfurther.isShown())
           {
             Connection.MessageBox(Acs_Veri1.this, "Required field: Time of administration further dose.");
             txttmacsfurther.requestFocus(); 
             return;	
           }
         
         else if(!rdoacsdosefurther1.isChecked() & !rdoacsdosefurther2.isChecked() & !rdoacsdosefurther3.isChecked() & !rdoacsdosefurther4.isChecked() & !rdoacsdosefurther5.isChecked() & secacsdosefurther.isShown())
           {
              Connection.MessageBox(Acs_Veri1.this, "Select anyone options from (Document dose administered ?).");
              rdoacsdosefurther1.requestFocus();
              return;
           }
         else if(txtacsdosefurtherOth.getText().toString().length()==0 & secacsdosefurtherOth.isShown())
           {
             Connection.MessageBox(Acs_Veri1.this, "Required field:    Other Specify.");
             txtacsdosefurtherOth.requestFocus(); 
             return;	
           }
         else if(!rdogar1.isChecked() & !rdogar2.isChecked() & txtga.getText().toString().length()==0 & secga.isShown())
           {
             Connection.MessageBox(Acs_Veri1.this, "Required field: GA at time birth.");
             txtga.requestFocus(); 
             return;	
           }
         else if(!rdogar1.isChecked() & !rdogar2.isChecked() & (Integer.valueOf(txtga.getText().toString().length()==0 ? "0" : txtga.getText().toString()) < 0 || Integer.valueOf(txtga.getText().toString().length()==0 ? "45" : txtga.getText().toString()) > 45))
           {
             Connection.MessageBox(Acs_Veri1.this, "Value should be between 0 and 45(GA at time birth).");
             txtga.requestFocus(); 
             return;	
           }
         
         /*else if(!rdogar1.isChecked() & !rdogar2.isChecked() & secgar.isShown())
           {
              Connection.MessageBox(Acs_Veri.this, "Select anyone options from (Not readable and recorded).");
              rdogar1.requestFocus();
              return;
           }*/
         else if(!rdogamethodr1.isChecked() & !rdogamethodr2.isChecked() & txtgamethod.getText().toString().length()==0 & secgamethod.isShown())
           {
             Connection.MessageBox(Acs_Veri1.this, "Required field: If clinical assessment of GA done what meathod was it ? Eg. Dubowitz or other.");
             txtgamethod.requestFocus(); 
             return;	
           }
         else if(!rdogamethodr1.isChecked() & !rdogamethodr2.isChecked() & (Integer.valueOf(txtgamethod.getText().toString().length()==0 ? "0" : txtgamethod.getText().toString()) < 0 || Integer.valueOf(txtgamethod.getText().toString().length()==0 ? "45" : txtgamethod.getText().toString()) > 45))
           {
             Connection.MessageBox(Acs_Veri1.this, "Value should be between 0 and 45(If clinical assessment of GA done what meathod was it ? Eg. Dubowitz or other).");
             txtgamethod.requestFocus(); 
             return;	
           }
         
         /*else if(!rdogamethodr1.isChecked() & !rdogamethodr2.isChecked() & secgamethodr.isShown())
           {
              Connection.MessageBox(Acs_Veri.this, "Select anyone options from (Not readable and recorded).");
              rdogamethodr1.requestFocus();
              return;
           }*/
         else if(txtbwt.getText().toString().length()==0 & !rdobwtr1.isChecked() & !rdobwtr2.isChecked() & secbwt.isShown())
           {
             Connection.MessageBox(Acs_Veri1.this, "Required field: Baby birth weight.");
             txtbwt.requestFocus(); 
             return;	
           }
         else if((Integer.valueOf(txtbwt.getText().toString().length()==0 ? "400" : txtbwt.getText().toString()) < 400 || Integer.valueOf(txtbwt.getText().toString().length()==0 ? "9999" : txtbwt.getText().toString()) > 9999) & !rdobwtr1.isChecked() & !rdobwtr2.isChecked() & secbwt.isShown())
           {
             Connection.MessageBox(Acs_Veri1.this, "Value should be between 400 and 9999(Baby birth weight).");
             txtbwt.requestFocus(); 
             return;	
           }
         
         /*else if(!rdobwtr1.isChecked() & !rdobwtr2.isChecked() & secbwtr.isShown())
           {
              Connection.MessageBox(Acs_Veri1.this, "Select anyone options from (Not readable and recorded).");
              rdobwtr1.requestFocus();
              return;
           }*/
         
         else if(!rdomatcond1.isChecked() & !rdomatcond2.isChecked() & !rdomatcond3.isChecked() & !rdomatcond4.isChecked() & secmatcond.isShown())
           {
              Connection.MessageBox(Acs_Veri1.this, "Select anyone options from (Mother condition at discharg from  hospital).");
              rdomatcond1.requestFocus();
              return;
           }
         
         else if(!rdobadm1.isChecked() & !rdobadm2.isChecked() & !rdobadm3.isChecked() & !rdobadm4.isChecked() & !rdobadm5.isChecked() & !rdobadm6.isChecked() & secbadm.isShown())
           {
              Connection.MessageBox(Acs_Veri1.this, "Select anyone options from (Was the baby admitted ?).");
              rdobadm1.requestFocus();
              return;
           }
         
         else if(!rdobcond1.isChecked() & !rdobcond2.isChecked() & !rdobcond3.isChecked() & !rdobcond4.isChecked() & !rdobcond5.isChecked() & !rdobcond6.isChecked() & !rdobcond7.isChecked() & secbcond.isShown())
           {
              Connection.MessageBox(Acs_Veri1.this, "Select anyone options from (Baby condition at discharge from hospital).");
              rdobcond1.requestFocus();
              return;
           }
         
         else if(!rdostillbirthSp1.isChecked() & !rdostillbirthSp2.isChecked() & !rdostillbirthSp3.isChecked() & secstillbirthSp.isShown())
           {
              Connection.MessageBox(Acs_Veri1.this, "Select anyone options from (If Stillbirth Specify).");
              rdostillbirthSp1.requestFocus();
              return;
           }
         DV = Global.DateValidate(dtpdod.getText().toString());
         if(DV.length()!=0 & !rdododNot1.isChecked() & !rdododNot2.isChecked() & secdod.isShown())
           {
             Connection.MessageBox(Acs_Veri1.this, "Invalid Date: 35. Date of baby death");
             dtpdod.requestFocus(); 
             return;	
           }
         else if(txtdeathtime.getText().length()==0 & !rdodeathtimeNot1.isChecked() & !rdodeathtimeNot2.isChecked() & secdeathtime.isShown())
           {
             Connection.MessageBox(Acs_Veri1.this, "Required field: Time of baby death.");
             txtdeathtime.requestFocus(); 
             return;	
           }
         
         else if(!rdostatus1.isChecked() & !rdostatus2.isChecked() & !rdostatus3.isChecked() & secstatus.isShown())
           {
              Connection.MessageBox(Acs_Veri1.this, "Select anyone options from (What is the final status of the verification for this patient?” ).");
              rdostatus1.requestFocus();
              return;
           }
         
         else if(!rdoreason1.isChecked() & !rdoreason2.isChecked() & !rdoreason3.isChecked() & !rdoreason4.isChecked() & secreason.isShown())
           {
              Connection.MessageBox(Acs_Veri1.this, "Select anyone options from (Why partially incomplete or totally incomplete?).");
              rdoreason1.requestFocus();
              return;
           }
         else if(txtreasmention.getText().toString().length()==0 & secreasmention.isShown())
           {
             Connection.MessageBox(Acs_Veri1.this, "Required field: Please mention.");
             txtreasmention.requestFocus(); 
             return;	
           }
 
         String SQL = "";
         RadioButton rb;

         Acs_Veri1_DataModel objSave = new Acs_Veri1_DataModel();
         objSave.setCountryCode(txtCountryCode.getText().toString());
         objSave.setFaciCode(txtFaciCode.getText().toString());
         objSave.setDataID(txtDataID.getText().toString());
         objSave.setParticipantID(txtParticipantID.getText().toString());
         String[] d_rdogrpmatobsv = new String[] {"1","2"};
         objSave.setmatobsv("");
         for (int i = 0; i < rdogrpmatobsv.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpmatobsv.getChildAt(i);
             if (rb.isChecked()) objSave.setmatobsv(d_rdogrpmatobsv[i]);
         }

         objSave.setmatname(txtmatname.getText().toString());

          String[] d_rdogrpcrform = new String[] {"1","2"};
          objSave.setcrform("");
          for (int i = 0; i < rdogrpcrform.getChildCount(); i++)
          {
               rb = (RadioButton)rdogrpcrform.getChildAt(i);
               if (rb.isChecked()) objSave.setcrform(d_rdogrpcrform[i]);
          }


         objSave.setMoAge(txtMoAge.getText().toString());
          String[] d_rdogrpMoAgeNot = new String[] {"8","9"};
          objSave.setMoAgeNot("");
          for (int i = 0; i < rdogrpMoAgeNot.getChildCount(); i++)
          {
               rb = (RadioButton)rdogrpMoAgeNot.getChildAt(i);
               if (rb.isChecked()) objSave.setMoAgeNot(d_rdogrpMoAgeNot[i]);
          }


         objSave.setmatbdate(dtpmatbdate.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpmatbdate.getText().toString()) : dtpmatbdate.getText().toString());

        String[] d_rdogrpmatbdateNot = new String[] {"8","9"};
        objSave.setmatbdateNot("");
        for (int i = 0; i < rdogrpmatbdateNot.getChildCount(); i++)
        {
           rb = (RadioButton)rdogrpmatbdateNot.getChildAt(i);
           if (rb.isChecked()) objSave.setmatbdateNot(d_rdogrpmatbdateNot[i]);
        }


         objSave.setgafirstds((spngafirstds.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spngafirstds.getSelectedItem().toString(), "-")));
         objSave.setmatcondpremA((chkmatcondpremA.isChecked()?"1":(secmatcondpremA.isShown()?"2":"")));

          objSave.setdtdgnmatcondA(dtpdtdgnmatcondA.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpdtdgnmatcondA.getText().toString()) : dtpdtdgnmatcondA.getText().toString());
          if(rdodtdgnmatcondANot1.isChecked()) objSave.setdtdgnmatcondANot("1");
          else if(rdodtdgnmatcondANot2.isChecked()) objSave.setdtdgnmatcondANot("2");
          else objSave.setdtdgnmatcondANot("");

          objSave.settmdgnmatcondA(txttmdgnmatcondA.getText().toString());
          if(rdotmdgnmatcondANot1.isChecked()) objSave.settmdgnmatcondANot("1");
          else if(rdotmdgnmatcondANot2.isChecked()) objSave.settmdgnmatcondANot("2");
          else objSave.settmdgnmatcondANot("");

          objSave.setmatcondpremB((chkmatcondpremB.isChecked()?"1":(secmatcondpremB.isShown()?"2":"")));
         objSave.setdtdgnmatcondB(dtpdtdgnmatcondB.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpdtdgnmatcondB.getText().toString()) : dtpdtdgnmatcondB.getText().toString());
         if(rdodtdgnmatcondBNot1.isChecked()) objSave.setdtdgnmatcondBNot("1");
          else if(rdodtdgnmatcondBNot2.isChecked()) objSave.setdtdgnmatcondBNot("2");
          else objSave.setdtdgnmatcondBNot("");

          objSave.settmdgnmatcondB(txttmdgnmatcondB.getText().toString());
          if(rdotmdgnmatcondBNot1.isChecked()) objSave.settmdgnmatcondBNot("1");
          else if(rdotmdgnmatcondBNot2.isChecked()) objSave.settmdgnmatcondBNot("2");
          else objSave.settmdgnmatcondBNot("");

         objSave.setmatcondpremC((chkmatcondpremC.isChecked()?"1":(secmatcondpremC.isShown()?"2":"")));
         objSave.setdtdgnmatcondC(dtpdtdgnmatcondC.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpdtdgnmatcondC.getText().toString()) : dtpdtdgnmatcondC.getText().toString());
         if(rdodtdgnmatcondCNot1.isChecked()) objSave.setdtdgnmatcondCNot("1");
         else if(rdodtdgnmatcondCNot2.isChecked()) objSave.setdtdgnmatcondCNot("2");
         else objSave.setdtdgnmatcondCNot("");

         objSave.settmdgnmatcondC(txttmdgnmatcondC.getText().toString());
         if(rdotmdgnmatcondCNot1.isChecked()) objSave.settmdgnmatcondCNot("1");
         else if(rdotmdgnmatcondCNot2.isChecked()) objSave.settmdgnmatcondCNot("2");
         else objSave.settmdgnmatcondCNot("");

         objSave.setmatcondpremD((chkmatcondpremD.isChecked()?"1":(secmatcondpremD.isShown()?"2":"")));
         objSave.setdtdgnmatcondD(dtpdtdgnmatcondD.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpdtdgnmatcondD.getText().toString()) : dtpdtdgnmatcondD.getText().toString());
         if(rdodtdgnmatcondDNot1.isChecked()) objSave.setdtdgnmatcondDNot("1");
         else if(rdodtdgnmatcondDNot2.isChecked()) objSave.setdtdgnmatcondDNot("2");
         else objSave.setdtdgnmatcondDNot("");

         objSave.settmdgnmatcondD(txttmdgnmatcondD.getText().toString());
         if(rdotmdgnmatcondDNot1.isChecked()) objSave.settmdgnmatcondDNot("1");
         else if(rdotmdgnmatcondDNot2.isChecked()) objSave.settmdgnmatcondDNot("2");
         else objSave.settmdgnmatcondDNot("");

         objSave.setmatcondpremE((chkmatcondpremE.isChecked()?"1":(secmatcondpremE.isShown()?"2":"")));
         objSave.setdtdgnmatcondE(dtpdtdgnmatcondE.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpdtdgnmatcondE.getText().toString()) : dtpdtdgnmatcondE.getText().toString());
         objSave.settmdgnmatcondE(txttmdgnmatcondE.getText().toString());
         objSave.setmatcondpremF((chkmatcondpremF.isChecked()?"1":(secmatcondpremF.isShown()?"2":"")));
         objSave.setmatcondpremOth(txtmatcondpremOth.getText().toString());
         objSave.setdtdgnmatcondF(dtpdtdgnmatcondF.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpdtdgnmatcondF.getText().toString()) : dtpdtdgnmatcondF.getText().toString());
          if(rdodtdgnmatcondFNot1.isChecked()) objSave.setdtdgnmatcondFNot("1");
          else if(rdodtdgnmatcondFNot2.isChecked()) objSave.setdtdgnmatcondFNot("2");
          else objSave.setdtdgnmatcondFNot("");


          objSave.settmdgnmatcondF(txttmdgnmatcondF.getText().toString());
          if(rdotmdgnmatcondFNot1.isChecked()) objSave.settmdgnmatcondFNot("1");
          else if(rdotmdgnmatcondFNot2.isChecked()) objSave.settmdgnmatcondFNot("2");
          else objSave.settmdgnmatcondFNot("");

         objSave.setmatcondpremG((chkmatcondpremG.isChecked()?"1":(secmatcondpremG.isShown()?"2":"")));
         objSave.setmatcondpremH((chkmatcondpremH.isChecked()?"1":(secmatcondpremH.isShown()?"2":"")));
         objSave.setmatinfA((chkmatinfA.isChecked()?"1":(secmatinfA.isShown()?"2":"")));
         objSave.setmatinfB((chkmatinfB.isChecked()?"1":(secmatinfB.isShown()?"2":"")));
         objSave.setmatinfC((chkmatinfC.isChecked()?"1":(secmatinfC.isShown()?"2":"")));
         objSave.setmatinfD((chkmatinfD.isChecked()?"1":(secmatinfD.isShown()?"2":"")));
         objSave.setmatinfE((chkmatinfE.isChecked()?"1":(secmatinfE.isShown()?"2":"")));
         objSave.setmatinfF((chkmatinfF.isChecked()?"1":(secmatinfF.isShown()?"2":"")));
         objSave.setmatinfG((chkmatinfG.isChecked()?"1":(secmatinfG.isShown()?"2":"")));
         objSave.setmatinfH((chkmatinfH.isChecked()?"1":(secmatinfH.isShown()?"2":"")));
         objSave.setmatinfI((chkmatinfI.isChecked()?"1":(secmatinfI.isShown()?"2":"")));
         objSave.setmatinfJ((chkmatinfJ.isChecked()?"1":(secmatinfJ.isShown()?"2":"")));
         objSave.setmatinfOth(txtmatinfOth.getText().toString());
         objSave.setdtdgnmatinf(dtpdtdgnmatinf.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpdtdgnmatinf.getText().toString()) : dtpdtdgnmatinf.getText().toString());
         if(rdodtdgnmatinfNot1.isChecked()) objSave.setdtdgnmatinfNot("1");
          else if(rdodtdgnmatinfNot2.isChecked()) objSave.setdtdgnmatinfNot("2");
          else  objSave.setdtdgnmatinfNot("");

         objSave.settmdgnmatinf(txttmdgnmatinf.getText().toString());
          if(rdotmdgnmatinfNot1.isChecked()) objSave.settmdgnmatinfNot("1");
          else if(rdotmdgnmatinfNot2.isChecked()) objSave.settmdgnmatinfNot("2");
          else objSave.settmdgnmatinfNot("");

         objSave.setmatcoinfA((chkmatcoinfA.isChecked()?"1":(secmatcoinfA.isShown()?"2":"")));
         objSave.setmatcoinfB((chkmatcoinfB.isChecked()?"1":(secmatcoinfB.isShown()?"2":"")));
         objSave.setmatcoinfC((chkmatcoinfC.isChecked()?"1":(secmatcoinfC.isShown()?"2":"")));
         objSave.setmatcoinfD((chkmatcoinfD.isChecked()?"1":(secmatcoinfD.isShown()?"2":"")));
         objSave.setmatcoinfE((chkmatcoinfE.isChecked()?"1":(secmatcoinfE.isShown()?"2":"")));
         objSave.setmatcoinfF((chkmatcoinfF.isChecked()?"1":(secmatcoinfF.isShown()?"2":"")));
         objSave.setmatcoinfOth(txtmatcoinfOth.getText().toString());
         String[] d_rdogrpmatcoinftrtmnt = new String[] {"1","2","8","9"};
         objSave.setmatcoinftrtmnt("");
         for (int i = 0; i < rdogrpmatcoinftrtmnt.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpmatcoinftrtmnt.getChildAt(i);
             if (rb.isChecked()) objSave.setmatcoinftrtmnt(d_rdogrpmatcoinftrtmnt[i]);
         }

         String[] d_rdogrpfetalaus = new String[] {"1","2","3","8","9","7"};
         objSave.setfetalaus("");
         for (int i = 0; i < rdogrpfetalaus.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpfetalaus.getChildAt(i);
             if (rb.isChecked()) objSave.setfetalaus(d_rdogrpfetalaus[i]);
         }

         objSave.setfetalausrate(txtfetalausrate.getText().toString());
         objSave.setfetalausOth(txtfetalausOth.getText().toString());
         String[] d_rdogrpacsadm1 = new String[] {"1","2","8","9"};
         objSave.setacsadm1("");
         for (int i = 0; i < rdogrpacsadm1.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpacsadm1.getChildAt(i);
             if (rb.isChecked()) objSave.setacsadm1(d_rdogrpacsadm1[i]);
         }

         objSave.setdtacs1(dtpdtacs1.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpdtacs1.getText().toString()) : dtpdtacs1.getText().toString());

        String[] d_rdogrpdtacs1Not = new String[] {"8","9"};
        objSave.setdtacs1Not("");
        for (int i = 0; i < rdogrpdtacs1Not.getChildCount(); i++)
        {
           rb = (RadioButton)rdogrpdtacs1Not.getChildAt(i);
           if (rb.isChecked()) objSave.setdtacs1Not(d_rdogrpdtacs1Not[i]);
        }



        objSave.settmdtacs1(txttmdtacs1.getText().toString());
          String[] d_rdogrptmdtacs1Not = new String[] {"8","9"};
          objSave.settmdtacs1Not("");
          for (int i = 0; i < rdogrptmdtacs1Not.getChildCount(); i++)
          {
               rb = (RadioButton)rdogrptmdtacs1Not.getChildAt(i);
               if (rb.isChecked()) objSave.settmdtacs1Not(d_rdogrptmdtacs1Not[i]);
          }


         String[] d_rdogrpnameacs1 = new String[] {"1","2","3","8","9","7"};
         objSave.setnameacs1("");
         for (int i = 0; i < rdogrpnameacs1.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpnameacs1.getChildAt(i);
             if (rb.isChecked()) objSave.setnameacs1(d_rdogrpnameacs1[i]);
         }

         objSave.setnameacs1Oth(txtnameacs1Oth.getText().toString());
         String[] d_rdogrpacsdose1 = new String[] {"1","2","8","9","7"};
         objSave.setacsdose1("");
         for (int i = 0; i < rdogrpacsdose1.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpacsdose1.getChildAt(i);
             if (rb.isChecked()) objSave.setacsdose1(d_rdogrpacsdose1[i]);
         }

         objSave.setacsdose1Oth(txtacsdose1Oth.getText().toString());
         String[] d_rdogrpacsadm2 = new String[] {"1","2","8","9"};
         objSave.setacsadm2("");
         for (int i = 0; i < rdogrpacsadm2.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpacsadm2.getChildAt(i);
             if (rb.isChecked()) objSave.setacsadm2(d_rdogrpacsadm2[i]);
         }

         objSave.setdtacsm2(dtpdtacsm2.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpdtacsm2.getText().toString()) : dtpdtacsm2.getText().toString());
         String[] d_rdogrpdtacsm2Not = new String[] {"8","9"};
         objSave.setdtacsm2Not("");
         for (int i = 0; i < rdogrpdtacsm2Not.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpdtacsm2Not.getChildAt(i);
             if (rb.isChecked()) objSave.setdtacsm2Not(d_rdogrpdtacsm2Not[i]);
         }

         objSave.settmacsm2(txttmacsm2.getText().toString());
         String[] d_rdogrptmacsm2Not = new String[] {"8","9"};
         objSave.settmacsm2Not("");
         for (int i = 0; i < rdogrptmacsm2Not.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrptmacsm2Not.getChildAt(i);
             if (rb.isChecked()) objSave.settmacsm2Not(d_rdogrptmacsm2Not[i]);
         }

         String[] d_rdogrpacsdose2 = new String[] {"1","2","8","9","7"};
         objSave.setacsdose2("");
         for (int i = 0; i < rdogrpacsdose2.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpacsdose2.getChildAt(i);
             if (rb.isChecked()) objSave.setacsdose2(d_rdogrpacsdose2[i]);
         }

         objSave.setacsdose2Oth(txtacsdose2Oth.getText().toString());
         String[] d_rdogrpacsadm3 = new String[] {"1","2","8","9"};
         objSave.setacsadm3("");
         for (int i = 0; i < rdogrpacsadm3.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpacsadm3.getChildAt(i);
             if (rb.isChecked()) objSave.setacsadm3(d_rdogrpacsadm3[i]);
         }

         objSave.setdtacsadm3(dtpdtacsadm3.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpdtacsadm3.getText().toString()) : dtpdtacsadm3.getText().toString());
         String[] d_rdogrpdtacsadm3Not = new String[] {"8","9"};
         objSave.setdtacsadm3Not("");
         for (int i = 0; i < rdogrpdtacsadm3Not.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpdtacsadm3Not.getChildAt(i);
             if (rb.isChecked()) objSave.setdtacsadm3Not(d_rdogrpdtacsadm3Not[i]);
         }

         objSave.settmacsadm3(txttmacsadm3.getText().toString());
         String[] d_rdogrptmacsadm3Not = new String[] {"8","9"};
         objSave.settmacsadm3Not("");
         for (int i = 0; i < rdogrptmacsadm3Not.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrptmacsadm3Not.getChildAt(i);
             if (rb.isChecked()) objSave.settmacsadm3Not(d_rdogrptmacsadm3Not[i]);
         }

         String[] d_rdogrpacsdose3 = new String[] {"1","2","8","9","7"};
         objSave.setacsdose3("");
         for (int i = 0; i < rdogrpacsdose3.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpacsdose3.getChildAt(i);
             if (rb.isChecked()) objSave.setacsdose3(d_rdogrpacsdose3[i]);
         }

         objSave.setacsdose3Oth(txtacsdose3Oth.getText().toString());
         String[] d_rdogrpacsadm4 = new String[] {"1","2","8","9"};
         objSave.setacsadm4("");
         for (int i = 0; i < rdogrpacsadm4.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpacsadm4.getChildAt(i);
             if (rb.isChecked()) objSave.setacsadm4(d_rdogrpacsadm4[i]);
         }

         objSave.setdtacsadm4(dtpdtacsadm4.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpdtacsadm4.getText().toString()) : dtpdtacsadm4.getText().toString());
         String[] d_rdogrpdtacsadm4Not = new String[] {"8","9"};
         objSave.setdtacsadm4Not("");
         for (int i = 0; i < rdogrpdtacsadm4Not.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpdtacsadm4Not.getChildAt(i);
             if (rb.isChecked()) objSave.setdtacsadm4Not(d_rdogrpdtacsadm4Not[i]);
         }

         objSave.settmacsadm4(txttmacsadm4.getText().toString());
         String[] d_rdogrptmacsadm4Not = new String[] {"8","9"};
         objSave.settmacsadm4Not("");
         for (int i = 0; i < rdogrptmacsadm4Not.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrptmacsadm4Not.getChildAt(i);
             if (rb.isChecked()) objSave.settmacsadm4Not(d_rdogrptmacsadm4Not[i]);
         }


         String[] d_rdogrpacsdose4 = new String[] {"1","2","8","9","7"};
         objSave.setacsdose4("");
         for (int i = 0; i < rdogrpacsdose4.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpacsdose4.getChildAt(i);
             if (rb.isChecked()) objSave.setacsdose4(d_rdogrpacsdose4[i]);
         }

         objSave.setacsdose4Oth(txtacsdose4Oth.getText().toString());
         String[] d_rdogrpacsfurther = new String[] {"1","2","8","9"};
         objSave.setacsfurther("");
         for (int i = 0; i < rdogrpacsfurther.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpacsfurther.getChildAt(i);
             if (rb.isChecked()) objSave.setacsfurther(d_rdogrpacsfurther[i]);
         }

         objSave.setdtacsfurther(dtpdtacsfurther.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpdtacsfurther.getText().toString()) : dtpdtacsfurther.getText().toString());
         String[] d_rdogrpdtacsfurtherNot = new String[] {"8","9"};
         objSave.setdtacsfurtherNot("");
         for (int i = 0; i < rdogrpdtacsfurtherNot.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpdtacsfurtherNot.getChildAt(i);
             if (rb.isChecked()) objSave.setdtacsfurtherNot(d_rdogrpdtacsfurtherNot[i]);
         }


         objSave.settmacsfurther(txttmacsfurther.getText().toString());
         String[] d_rdogrptmacsfurtherNot = new String[] {"8","9"};
         objSave.settmacsfurtherNot("");
         for (int i = 0; i < rdogrptmacsfurtherNot.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrptmacsfurtherNot.getChildAt(i);
             if (rb.isChecked()) objSave.settmacsfurtherNot(d_rdogrptmacsfurtherNot[i]);
         }

         String[] d_rdogrpacsdosefurther = new String[] {"1","2","8","9","7"};
         objSave.setacsdosefurther("");
         for (int i = 0; i < rdogrpacsdosefurther.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpacsdosefurther.getChildAt(i);
             if (rb.isChecked()) objSave.setacsdosefurther(d_rdogrpacsdosefurther[i]);
         }

         objSave.setacsdosefurtherOth(txtacsdosefurtherOth.getText().toString());
         objSave.setga(txtga.getText().toString());
         String[] d_rdogrpgar = new String[] {"8","9"};
         objSave.setgar("");
         for (int i = 0; i < rdogrpgar.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpgar.getChildAt(i);
             if (rb.isChecked()) objSave.setgar(d_rdogrpgar[i]);
         }

         objSave.setgamethod(txtgamethod.getText().toString());
         String[] d_rdogrpgamethodr = new String[] {"8","9"};
         objSave.setgamethodr("");
         for (int i = 0; i < rdogrpgamethodr.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpgamethodr.getChildAt(i);
             if (rb.isChecked()) objSave.setgamethodr(d_rdogrpgamethodr[i]);
         }

         objSave.setbwt(txtbwt.getText().toString());
         String[] d_rdogrpbwtr = new String[] {"8","9"};
         objSave.setbwtr("");
         for (int i = 0; i < rdogrpbwtr.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpbwtr.getChildAt(i);
             if (rb.isChecked()) objSave.setbwtr(d_rdogrpbwtr[i]);
         }

         String[] d_rdogrpmatcond = new String[] {"1","2","8","9"};
         objSave.setmatcond("");
         for (int i = 0; i < rdogrpmatcond.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpmatcond.getChildAt(i);
             if (rb.isChecked()) objSave.setmatcond(d_rdogrpmatcond[i]);
         }

         String[] d_rdogrpbadm = new String[] {"1","2","3","4","8","9"};
         objSave.setbadm("");
         for (int i = 0; i < rdogrpbadm.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpbadm.getChildAt(i);
             if (rb.isChecked()) objSave.setbadm(d_rdogrpbadm[i]);
         }

         String[] d_rdogrpbcond = new String[] {"1","2","3","4","5","8","9"};
         objSave.setbcond("");
         for (int i = 0; i < rdogrpbcond.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpbcond.getChildAt(i);
             if (rb.isChecked()) objSave.setbcond(d_rdogrpbcond[i]);
         }

         String[] d_rdogrpstillbirthSp = new String[] {"1","2","3"};
         objSave.setstillbirthSp("");
         for (int i = 0; i < rdogrpstillbirthSp.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpstillbirthSp.getChildAt(i);
             if (rb.isChecked()) objSave.setstillbirthSp(d_rdogrpstillbirthSp[i]);
         }

         objSave.setdod(dtpdod.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpdod.getText().toString()) : dtpdod.getText().toString());
         String[] d_rdogrpdodNot = new String[] {"8","9"};
         objSave.setdodNot("");
         for (int i = 0; i < rdogrpdodNot.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpdodNot.getChildAt(i);
             if (rb.isChecked()) objSave.setdodNot(d_rdogrpdodNot[i]);
         }


         objSave.setdeathtime(txtdeathtime.getText().toString());
         String[] d_rdogrpdeathtimeNot = new String[] {"8","9"};
         objSave.setdeathtimeNot("");
         for (int i = 0; i < rdogrpdeathtimeNot.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpdeathtimeNot.getChildAt(i);
             if (rb.isChecked()) objSave.setdeathtimeNot(d_rdogrpdeathtimeNot[i]);
         }


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
              C.SaveDT("Update Registration set StatusACS='1',Upload='2',modifyDate='"+ Global.DateTimeNowYMDHMS() +"' where CountryCode='" + COUNTRYCODE + "' and FaciCode='" + FACICODE + "' and DataId='" + DATAID + "'");

             Intent returnIntent = new Intent();
             returnIntent.putExtra("res", "");
             setResult(Activity.RESULT_OK, returnIntent);

             Connection.MessageBox(Acs_Veri1.this, "Saved Successfully");
         }
         else{
             Connection.MessageBox(Acs_Veri1.this, status);
             return;
         }
     }
     catch(Exception  e)
     {
         Connection.MessageBox(Acs_Veri1.this, e.getMessage());
         return;
     }
 }

 private void DataSearch(String CountryCode, String FaciCode, String DataID)
     {
       try
        {
     
           RadioButton rb;
           Acs_Veri1_DataModel d = new Acs_Veri1_DataModel();
           String SQL = "Select * from "+ TableName +"  Where CountryCode='"+ CountryCode +"' and FaciCode='"+ FaciCode +"' and DataID='"+ DataID +"'";
           List<Acs_Veri1_DataModel> data = d.SelectAll(this, SQL);
           for(Acs_Veri1_DataModel item : data){
             txtCountryCode.setText(item.getCountryCode());
             txtFaciCode.setText(item.getFaciCode());
             txtDataID.setText(item.getDataID());
             txtParticipantID.setText(item.getParticipantID());
             String[] d_rdogrpmatobsv = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpmatobsv.length; i++)
             {
                 if (item.getmatobsv().equals(String.valueOf(d_rdogrpmatobsv[i])))
                 {
                     rb = (RadioButton)rdogrpmatobsv.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtmatname.setText(item.getmatname());
             if(item.getcrform().equals("1")) rdocrform1.setChecked(true); else if(item.getcrform().equals("2")) rdocrform2.setChecked(true);

             txtMoAge.setText(item.getMoAge());
             if(item.getMoAgeNot().equals("8")) rdoMoAgeNot1.setChecked(true); else if(item.getMoAgeNot().equals("9")) rdoMoAgeNot2.setChecked(true);

             dtpmatbdate.setText(item.getmatbdate().toString().length()==0 ? "" : Global.DateConvertDMY(item.getmatbdate()));

             if(item.getmatbdateNot().equals("8")) rdomatbdateNot1.setChecked(true); else if(item.getmatbdateNot().equals("9")) rdomatbdateNot2.setChecked(true);

             spngafirstds.setSelection(Global.SpinnerItemPositionAnyLength(spngafirstds, item.getgafirstds()));
             if(item.getmatcondpremA().equals("1"))
             {
                chkmatcondpremA.setChecked(true);
             }
             else if(item.getmatcondpremA().equals("2"))
             {
                chkmatcondpremA.setChecked(false);
             }
             dtpdtdgnmatcondA.setText(item.getdtdgnmatcondA().toString().length()==0 ? "" : Global.DateConvertDMY(item.getdtdgnmatcondA()));
             if(item.getdtdgnmatcondANot().equals("1")) rdodtdgnmatcondANot1.setChecked(true);
             else if(item.getdtdgnmatcondANot().equals("2")) rdodtdgnmatcondANot2.setChecked(true);

                txttmdgnmatcondA.setText(item.gettmdgnmatcondA());
                if(item.gettmdgnmatcondANot().equals("1")) rdotmdgnmatcondANot1.setChecked(true);
                else if(item.gettmdgnmatcondANot().equals("2")) rdotmdgnmatcondANot2.setChecked(true);

             if(item.getmatcondpremB().equals("1"))
             {
                chkmatcondpremB.setChecked(true);
             }
             else if(item.getmatcondpremB().equals("2"))
             {
                chkmatcondpremB.setChecked(false);
             }
             dtpdtdgnmatcondB.setText(item.getdtdgnmatcondB().toString().length()==0 ? "" : Global.DateConvertDMY(item.getdtdgnmatcondB()));
             if(item.getdtdgnmatcondBNot().equals("1")) rdodtdgnmatcondBNot1.setChecked(true);
                else if(item.getdtdgnmatcondBNot().equals("2")) rdodtdgnmatcondBNot2.setChecked(true);

                txttmdgnmatcondB.setText(item.gettmdgnmatcondB());
                if(item.gettmdgnmatcondBNot().equals("1")) rdotmdgnmatcondBNot1.setChecked(true);
                else if(item.gettmdgnmatcondBNot().equals("2")) rdotmdgnmatcondBNot2.setChecked(true);


                if(item.getmatcondpremC().equals("1"))
             {
                chkmatcondpremC.setChecked(true);
             }
             else if(item.getmatcondpremC().equals("2"))
             {
                chkmatcondpremC.setChecked(false);
             }
             dtpdtdgnmatcondC.setText(item.getdtdgnmatcondC().toString().length()==0 ? "" : Global.DateConvertDMY(item.getdtdgnmatcondC()));
               if(item.getdtdgnmatcondCNot().equals("1")) rdodtdgnmatcondCNot1.setChecked(true);
               else if(item.getdtdgnmatcondCNot().equals("2")) rdodtdgnmatcondCNot2.setChecked(true);


               txttmdgnmatcondC.setText(item.gettmdgnmatcondC());
               if(item.gettmdgnmatcondCNot().equals("1")) rdotmdgnmatcondCNot1.setChecked(true);
               else if(item.gettmdgnmatcondCNot().equals("2")) rdotmdgnmatcondCNot2.setChecked(true);


             if(item.getmatcondpremD().equals("1"))
             {
                chkmatcondpremD.setChecked(true);
             }
             else if(item.getmatcondpremD().equals("2"))
             {
                chkmatcondpremD.setChecked(false);
             }
             dtpdtdgnmatcondD.setText(item.getdtdgnmatcondD().toString().length()==0 ? "" : Global.DateConvertDMY(item.getdtdgnmatcondD()));
               if(item.getdtdgnmatcondDNot().equals("1")) rdodtdgnmatcondDNot1.setChecked(true);
               else if(item.getdtdgnmatcondDNot().equals("2")) rdodtdgnmatcondDNot2.setChecked(true);


               txttmdgnmatcondD.setText(item.gettmdgnmatcondD());
               if(item.gettmdgnmatcondDNot().equals("1")) rdotmdgnmatcondDNot1.setChecked(true);
               else if(item.gettmdgnmatcondDNot().equals("2")) rdotmdgnmatcondDNot2.setChecked(true);

               if(item.getmatcondpremE().equals("1"))
             {
                chkmatcondpremE.setChecked(true);
             }
             else if(item.getmatcondpremE().equals("2"))
             {
                chkmatcondpremE.setChecked(false);
             }
             dtpdtdgnmatcondE.setText(item.getdtdgnmatcondE().toString().length()==0 ? "" : Global.DateConvertDMY(item.getdtdgnmatcondE()));
             txttmdgnmatcondE.setText(item.gettmdgnmatcondE());
             if(item.getmatcondpremF().equals("1"))
             {
                chkmatcondpremF.setChecked(true);
             }
             else if(item.getmatcondpremF().equals("2"))
             {
                chkmatcondpremF.setChecked(false);
             }
             txtmatcondpremOth.setText(item.getmatcondpremOth());
             dtpdtdgnmatcondF.setText(item.getdtdgnmatcondF().toString().length()==0 ? "" : Global.DateConvertDMY(item.getdtdgnmatcondF()));
                if(item.getdtdgnmatcondFNot().equals("1")) rdodtdgnmatcondFNot1.setChecked(true);
                else if(item.getdtdgnmatcondFNot().equals("2")) rdodtdgnmatcondFNot2.setChecked(true);


                txttmdgnmatcondF.setText(item.gettmdgnmatcondF());
                if(item.gettmdgnmatcondFNot().equals("1")) rdotmdgnmatcondFNot1.setChecked(true);
                else if(item.gettmdgnmatcondFNot().equals("2")) rdotmdgnmatcondFNot2.setChecked(true);


             if(item.getmatcondpremG().equals("1"))
             {
                chkmatcondpremG.setChecked(true);
             }
             else if(item.getmatcondpremG().equals("2"))
             {
                chkmatcondpremG.setChecked(false);
             }
             if(item.getmatcondpremH().equals("1"))
             {
                chkmatcondpremH.setChecked(true);
             }
             else if(item.getmatcondpremH().equals("2"))
             {
                chkmatcondpremH.setChecked(false);
             }
             if(item.getmatinfA().equals("1"))
             {
                chkmatinfA.setChecked(true);
             }
             else if(item.getmatinfA().equals("2"))
             {
                chkmatinfA.setChecked(false);
             }
             if(item.getmatinfB().equals("1"))
             {
                chkmatinfB.setChecked(true);
             }
             else if(item.getmatinfB().equals("2"))
             {
                chkmatinfB.setChecked(false);
             }
             if(item.getmatinfC().equals("1"))
             {
                chkmatinfC.setChecked(true);
             }
             else if(item.getmatinfC().equals("2"))
             {
                chkmatinfC.setChecked(false);
             }
             if(item.getmatinfD().equals("1"))
             {
                chkmatinfD.setChecked(true);
             }
             else if(item.getmatinfD().equals("2"))
             {
                chkmatinfD.setChecked(false);
             }
             if(item.getmatinfE().equals("1"))
             {
                chkmatinfE.setChecked(true);
             }
             else if(item.getmatinfE().equals("2"))
             {
                chkmatinfE.setChecked(false);
             }
             if(item.getmatinfF().equals("1"))
             {
                chkmatinfF.setChecked(true);
             }
             else if(item.getmatinfF().equals("2"))
             {
                chkmatinfF.setChecked(false);
             }
             if(item.getmatinfG().equals("1"))
             {
                chkmatinfG.setChecked(true);
             }
             else if(item.getmatinfG().equals("2"))
             {
                chkmatinfG.setChecked(false);
             }
             if(item.getmatinfH().equals("1"))
             {
                chkmatinfH.setChecked(true);
             }
             else if(item.getmatinfH().equals("2"))
             {
                chkmatinfH.setChecked(false);
             }
             if(item.getmatinfI().equals("1"))
             {
                chkmatinfI.setChecked(true);
             }
             else if(item.getmatinfI().equals("2"))
             {
                chkmatinfI.setChecked(false);
             }
             if(item.getmatinfJ().equals("1"))
             {
                chkmatinfJ.setChecked(true);
             }
             else if(item.getmatinfJ().equals("2"))
             {
                chkmatinfJ.setChecked(false);
             }
             txtmatinfOth.setText(item.getmatinfOth());
             dtpdtdgnmatinf.setText(item.getdtdgnmatinf().toString().length()==0 ? "" : Global.DateConvertDMY(item.getdtdgnmatinf()));
             if(item.getdtdgnmatinfNot().equals("1")) rdodtdgnmatinfNot1.setChecked(true);
                else if(item.getdtdgnmatinfNot().equals("2")) rdodtdgnmatinfNot2.setChecked(true);

                txttmdgnmatinf.setText(item.gettmdgnmatinf());
             if(item.gettmdgnmatinfNot().equals("1")) rdotmdgnmatinfNot1.setChecked(true);
              else if(item.gettmdgnmatinfNot().equals("2")) rdotmdgnmatinfNot2.setChecked(true);

             if(item.getmatcoinfA().equals("1"))
             {
                chkmatcoinfA.setChecked(true);
             }
             else if(item.getmatcoinfA().equals("2"))
             {
                chkmatcoinfA.setChecked(false);
             }
             if(item.getmatcoinfB().equals("1"))
             {
                chkmatcoinfB.setChecked(true);
             }
             else if(item.getmatcoinfB().equals("2"))
             {
                chkmatcoinfB.setChecked(false);
             }
             if(item.getmatcoinfC().equals("1"))
             {
                chkmatcoinfC.setChecked(true);
             }
             else if(item.getmatcoinfC().equals("2"))
             {
                chkmatcoinfC.setChecked(false);
             }
             if(item.getmatcoinfD().equals("1"))
             {
                chkmatcoinfD.setChecked(true);
             }
             else if(item.getmatcoinfD().equals("2"))
             {
                chkmatcoinfD.setChecked(false);
             }
             if(item.getmatcoinfE().equals("1"))
             {
                chkmatcoinfE.setChecked(true);
             }
             else if(item.getmatcoinfE().equals("2"))
             {
                chkmatcoinfE.setChecked(false);
             }
             if(item.getmatcoinfF().equals("1"))
             {
                chkmatcoinfF.setChecked(true);
             }
             else if(item.getmatcoinfF().equals("2"))
             {
                chkmatcoinfF.setChecked(false);
             }
             txtmatcoinfOth.setText(item.getmatcoinfOth());
             String[] d_rdogrpmatcoinftrtmnt = new String[] {"1","2","8","9"};
             for (int i = 0; i < d_rdogrpmatcoinftrtmnt.length; i++)
             {
                 if (item.getmatcoinftrtmnt().equals(String.valueOf(d_rdogrpmatcoinftrtmnt[i])))
                 {
                     rb = (RadioButton)rdogrpmatcoinftrtmnt.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpfetalaus = new String[] {"1","2","3","8","9","7"};
             for (int i = 0; i < d_rdogrpfetalaus.length; i++)
             {
                 if (item.getfetalaus().equals(String.valueOf(d_rdogrpfetalaus[i])))
                 {
                     rb = (RadioButton)rdogrpfetalaus.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtfetalausrate.setText(item.getfetalausrate());
             txtfetalausOth.setText(item.getfetalausOth());
             String[] d_rdogrpacsadm1 = new String[] {"1","2","8","9"};
             for (int i = 0; i < d_rdogrpacsadm1.length; i++)
             {
                 if (item.getacsadm1().equals(String.valueOf(d_rdogrpacsadm1[i])))
                 {
                     rb = (RadioButton)rdogrpacsadm1.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             dtpdtacs1.setText(item.getdtacs1().toString().length()==0 ? "" : Global.DateConvertDMY(item.getdtacs1()));
             if(item.getdtacs1Not().equals("8")) rdodtacs1Not1.setChecked(true); else if(item.getdtacs1Not().equals("9")) rdodtacs1Not2.setChecked(true);

             txttmdtacs1.setText(item.gettmdtacs1());
             if(item.gettmdtacs1Not().equals("8")) rdotmdtacs1Not1.setChecked(true); else if(item.gettmdtacs1Not().equals("9")) rdotmdtacs1Not2.setChecked(true);

             String[] d_rdogrpnameacs1 = new String[] {"1","2","3","8","9","7"};
             for (int i = 0; i < d_rdogrpnameacs1.length; i++)
             {
                 if (item.getnameacs1().equals(String.valueOf(d_rdogrpnameacs1[i])))
                 {
                     rb = (RadioButton)rdogrpnameacs1.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtnameacs1Oth.setText(item.getnameacs1Oth());
             String[] d_rdogrpacsdose1 = new String[] {"1","2","8","9","7"};
             for (int i = 0; i < d_rdogrpacsdose1.length; i++)
             {
                 if (item.getacsdose1().equals(String.valueOf(d_rdogrpacsdose1[i])))
                 {
                     rb = (RadioButton)rdogrpacsdose1.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtacsdose1Oth.setText(item.getacsdose1Oth());
             String[] d_rdogrpacsadm2 = new String[] {"1","2","8","9"};
             for (int i = 0; i < d_rdogrpacsadm2.length; i++)
             {
                 if (item.getacsadm2().equals(String.valueOf(d_rdogrpacsadm2[i])))
                 {
                     rb = (RadioButton)rdogrpacsadm2.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             dtpdtacsm2.setText(item.getdtacsm2().toString().length()==0 ? "" : Global.DateConvertDMY(item.getdtacsm2()));
             if(item.getdtacsm2Not().equals("8")) rdodtacsm2Not1.setChecked(true); else if(item.getdtacsm2Not().equals("9")) rdodtacsm2Not2.setChecked(true);

             txttmacsm2.setText(item.gettmacsm2());
             if(item.gettmacsm2Not().equals("8")) rdotmacsm2Not1.setChecked(true); else if(item.gettmacsm2Not().equals("9")) rdotmacsm2Not2.setChecked(true);

             String[] d_rdogrpacsdose2 = new String[] {"1","2","8","9","7"};
             for (int i = 0; i < d_rdogrpacsdose2.length; i++)
             {
                 if (item.getacsdose2().equals(String.valueOf(d_rdogrpacsdose2[i])))
                 {
                     rb = (RadioButton)rdogrpacsdose2.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtacsdose2Oth.setText(item.getacsdose2Oth());
             String[] d_rdogrpacsadm3 = new String[] {"1","2","8","9"};
             for (int i = 0; i < d_rdogrpacsadm3.length; i++)
             {
                 if (item.getacsadm3().equals(String.valueOf(d_rdogrpacsadm3[i])))
                 {
                     rb = (RadioButton)rdogrpacsadm3.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             dtpdtacsadm3.setText(item.getdtacsadm3().toString().length()==0 ? "" : Global.DateConvertDMY(item.getdtacsadm3()));
             if(item.getdtacsadm3Not().equals("8")) rdodtacsadm3Not1.setChecked(true); else if(item.getdtacsadm3Not().equals("9")) rdodtacsadm3Not2.setChecked(true);

             txttmacsadm3.setText(item.gettmacsadm3());
             if(item.gettmacsadm3Not().equals("8")) rdotmacsadm3Not1.setChecked(true); else if(item.gettmacsadm3Not().equals("9")) rdotmacsadm3Not2.setChecked(true);

              String[] d_rdogrpacsdose3 = new String[] {"1","2","8","9","7"};
             for (int i = 0; i < d_rdogrpacsdose3.length; i++)
             {
                 if (item.getacsdose3().equals(String.valueOf(d_rdogrpacsdose3[i])))
                 {
                     rb = (RadioButton)rdogrpacsdose3.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtacsdose3Oth.setText(item.getacsdose3Oth());
             String[] d_rdogrpacsadm4 = new String[] {"1","2","8","9"};
             for (int i = 0; i < d_rdogrpacsadm4.length; i++)
             {
                 if (item.getacsadm4().equals(String.valueOf(d_rdogrpacsadm4[i])))
                 {
                     rb = (RadioButton)rdogrpacsadm4.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             dtpdtacsadm4.setText(item.getdtacsadm4().toString().length()==0 ? "" : Global.DateConvertDMY(item.getdtacsadm4()));
             if(item.getdtacsadm4Not().equals("8")) rdodtacsadm4Not1.setChecked(true); else if(item.getdtacsadm4Not().equals("9")) rdodtacsadm4Not2.setChecked(true);

             txttmacsadm4.setText(item.gettmacsadm4());
             if(item.gettmacsadm4Not().equals("8")) rdotmacsadm4Not1.setChecked(true); else if(item.gettmacsadm4Not().equals("9")) rdotmacsadm4Not2.setChecked(true);

               String[] d_rdogrpacsdose4 = new String[] {"1","2","8","9","7"};
             for (int i = 0; i < d_rdogrpacsdose4.length; i++)
             {
                 if (item.getacsdose4().equals(String.valueOf(d_rdogrpacsdose4[i])))
                 {
                     rb = (RadioButton)rdogrpacsdose4.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtacsdose4Oth.setText(item.getacsdose4Oth());
             String[] d_rdogrpacsfurther = new String[] {"1","2","8","9"};
             for (int i = 0; i < d_rdogrpacsfurther.length; i++)
             {
                 if (item.getacsfurther().equals(String.valueOf(d_rdogrpacsfurther[i])))
                 {
                     rb = (RadioButton)rdogrpacsfurther.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             dtpdtacsfurther.setText(item.getdtacsfurther().toString().length()==0 ? "" : Global.DateConvertDMY(item.getdtacsfurther()));
             if(item.getdtacsfurtherNot().equals("8")) rdodtacsfurtherNot1.setChecked(true); else if(item.getdtacsfurtherNot().equals("9")) rdodtacsfurtherNot2.setChecked(true);

             txttmacsfurther.setText(item.gettmacsfurther());
             if(item.gettmacsfurtherNot().equals("8")) rdotmacsfurtherNot1.setChecked(true); else if(item.gettmacsfurtherNot().equals("9")) rdotmacsfurtherNot2.setChecked(true);

             String[] d_rdogrpacsdosefurther = new String[] {"1","2","8","9","7"};
             for (int i = 0; i < d_rdogrpacsdosefurther.length; i++)
             {
                 if (item.getacsdosefurther().equals(String.valueOf(d_rdogrpacsdosefurther[i])))
                 {
                     rb = (RadioButton)rdogrpacsdosefurther.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtacsdosefurtherOth.setText(item.getacsdosefurtherOth());
             txtga.setText(item.getga());
             String[] d_rdogrpgar = new String[] {"8","9"};
             for (int i = 0; i < d_rdogrpgar.length; i++)
             {
                 if (item.getgar().equals(String.valueOf(d_rdogrpgar[i])))
                 {
                     rb = (RadioButton)rdogrpgar.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtgamethod.setText(item.getgamethod());
             String[] d_rdogrpgamethodr = new String[] {"8","9"};
             for (int i = 0; i < d_rdogrpgamethodr.length; i++)
             {
                 if (item.getgamethodr().equals(String.valueOf(d_rdogrpgamethodr[i])))
                 {
                     rb = (RadioButton)rdogrpgamethodr.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtbwt.setText(item.getbwt());
             String[] d_rdogrpbwtr = new String[] {"8","9"};
             for (int i = 0; i < d_rdogrpbwtr.length; i++)
             {
                 if (item.getbwtr().equals(String.valueOf(d_rdogrpbwtr[i])))
                 {
                     rb = (RadioButton)rdogrpbwtr.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpmatcond = new String[] {"1","2","8","9"};
             for (int i = 0; i < d_rdogrpmatcond.length; i++)
             {
                 if (item.getmatcond().equals(String.valueOf(d_rdogrpmatcond[i])))
                 {
                     rb = (RadioButton)rdogrpmatcond.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpbadm = new String[] {"1","2","3","4","8","9"};
             for (int i = 0; i < d_rdogrpbadm.length; i++)
             {
                 if (item.getbadm().equals(String.valueOf(d_rdogrpbadm[i])))
                 {
                     rb = (RadioButton)rdogrpbadm.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpbcond = new String[] {"1","2","3","4","5","8","9"};
             for (int i = 0; i < d_rdogrpbcond.length; i++)
             {
                 if (item.getbcond().equals(String.valueOf(d_rdogrpbcond[i])))
                 {
                     rb = (RadioButton)rdogrpbcond.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpstillbirthSp = new String[] {"1","2","3"};
             for (int i = 0; i < d_rdogrpstillbirthSp.length; i++)
             {
                 if (item.getstillbirthSp().equals(String.valueOf(d_rdogrpstillbirthSp[i])))
                 {
                     rb = (RadioButton)rdogrpstillbirthSp.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             dtpdod.setText(item.getdod().toString().length()==0 ? "" : Global.DateConvertDMY(item.getdod()));
             if(item.getdodNot().equals("8")) rdododNot1.setChecked(true); else if(item.getdodNot().equals("9")) rdododNot2.setChecked(true);

             txtdeathtime.setText(item.getdeathtime());
             if(item.getdeathtimeNot().equals("8")) rdodeathtimeNot1.setChecked(true); else if(item.getdeathtimeNot().equals("9")) rdodeathtimeNot2.setChecked(true);

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
            Connection.MessageBox(Acs_Veri1.this, e.getMessage());
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


              dtpDate = (EditText)findViewById(R.id.dtpmatbdate);
             if (VariableID.equals("btnmatbdate"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpmatbdate);
              }
             else if (VariableID.equals("btndtdgnmatcondA"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpdtdgnmatcondA);
              }
             else if (VariableID.equals("btndtdgnmatcondB"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpdtdgnmatcondB);
              }
             else if (VariableID.equals("btndtdgnmatcondC"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpdtdgnmatcondC);
              }
             else if (VariableID.equals("btndtdgnmatcondD"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpdtdgnmatcondD);
              }
             else if (VariableID.equals("btndtdgnmatcondE"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpdtdgnmatcondE);
              }
             else if (VariableID.equals("btndtdgnmatcondF"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpdtdgnmatcondF);
              }
             else if (VariableID.equals("btndtdgnmatinf"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpdtdgnmatinf);
              }
             else if (VariableID.equals("btndtacs1"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpdtacs1);
              }
             else if (VariableID.equals("btndtacsm2"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpdtacsm2);
              }
             else if (VariableID.equals("btndtacsadm3"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpdtacsadm3);
              }
             else if (VariableID.equals("btndtacsadm4"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpdtacsadm4);
              }
             else if (VariableID.equals("btndtacsfurther"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpdtacsfurther);
              }
             else if (VariableID.equals("btndod"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpdod);
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


              tpTime = (EditText)findViewById(R.id.txttmdgnmatcondA);
             if (VariableID.equals("btntmdgnmatcondA"))
              {
                  tpTime = (EditText)findViewById(R.id.txttmdgnmatcondA);
              }
             else if (VariableID.equals("btntmdgnmatcondB"))
              {
                  tpTime = (EditText)findViewById(R.id.txttmdgnmatcondB);
              }
             else if (VariableID.equals("btntmdgnmatcondC"))
              {
                  tpTime = (EditText)findViewById(R.id.txttmdgnmatcondC);
              }
             else if (VariableID.equals("btntmdgnmatcondD"))
              {
                  tpTime = (EditText)findViewById(R.id.txttmdgnmatcondD);
              }
             else if (VariableID.equals("btntmdgnmatcondE"))
              {
                  tpTime = (EditText)findViewById(R.id.txttmdgnmatcondE);
              }
             else if (VariableID.equals("btntmdgnmatcondF"))
              {
                  tpTime = (EditText)findViewById(R.id.txttmdgnmatcondF);
              }
             else if (VariableID.equals("btntmdgnmatinf"))
              {
                  tpTime = (EditText)findViewById(R.id.txttmdgnmatinf);
              }
             else if (VariableID.equals("btntmdtacs1"))
              {
                  tpTime = (EditText)findViewById(R.id.txttmdtacs1);
              }
             else if (VariableID.equals("btntmacsm2"))
              {
                  tpTime = (EditText)findViewById(R.id.txttmacsm2);
              }
             else if (VariableID.equals("btntmacsadm3"))
              {
                  tpTime = (EditText)findViewById(R.id.txttmacsadm3);
              }
             else if (VariableID.equals("btntmacsadm4"))
              {
                  tpTime = (EditText)findViewById(R.id.txttmacsadm4);
              }
             else if (VariableID.equals("btntmacsfurther"))
              {
                  tpTime = (EditText)findViewById(R.id.txttmacsfurther);
              }
             else if (VariableID.equals("btndeathtime"))
              {
                  tpTime = (EditText)findViewById(R.id.txtdeathtime);
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