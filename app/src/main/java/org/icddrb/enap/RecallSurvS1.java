
 package org.icddrb.enap;


 //Android Manifest Code
 //<activity android:name=".RecallSurvS1" android:label="RecallSurvS1" />
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
 import android.support.annotation.IdRes;
 import android.text.Editable;
 import android.text.InputType;
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
 import android.view.WindowManager;
 import android.widget.AdapterView;
 import android.widget.AutoCompleteTextView;
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
 import android.widget.Toast;

 import Utility.*;
 import Common.*;

 public class RecallSurvS1 extends Activity {
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
         LinearLayout seclblsec1;
         View linelblsec1;
         LinearLayout secDataID;
         View lineDataID;
         TextView VlblDataID;
         EditText txtDataID;
         LinearLayout secStudyID;
         View lineStudyID;
         TextView VlblStudyID;
         EditText txtStudyID;
         LinearLayout secConsentMRS;
         View lineConsentMRS;
         TextView VlblConsentMRS;
         RadioGroup rdogrpConsentMRS;
         
         RadioButton rdoConsentMRS1;
         RadioButton rdoConsentMRS2;
         LinearLayout secConsentFollo;
         View lineConsentFollo;
         TextView VlblConsentFollo;
         RadioGroup rdogrpConsentFollo;
         
         RadioButton rdoConsentFollo1;
         RadioButton rdoConsentFollo2;
         LinearLayout seclblsec11;
         View linelblsec11;
         LinearLayout secdoi;
         View linedoi;
         TextView Vlbldoi;
         EditText dtpdoi;
         LinearLayout sectoi;
         View linetoi;
         TextView Vlbltoi;
         EditText txttoi;
         LinearLayout seclang;
         View linelang;
         TextView Vlbllang;
         Spinner spnlang;
         LinearLayout seccconditionb;
         View linecconditionb;
         TextView Vlblcconditionb;
         Spinner spncconditionb;
         LinearLayout seclblsec12;
     LinearLayout seclblsec121;
         View linelblsec12;
         LinearLayout secmatconsent;
         View linematconsent;
         TextView Vlblmatconsent;
         RadioGroup rdogrpmatconsent;
         
         RadioButton rdomatconsent1;
         RadioButton rdomatconsent2;
         LinearLayout secMatbdateM;
      LinearLayout secMatbdateM1;
         View lineMatbdateM;
         TextView VlblMatbdateM;
         Spinner spnMatbdateM;
         LinearLayout secMatbdateY;
         View lineMatbdateY;
         TextView VlblMatbdateY;
         EditText txtMatbdateY;
         LinearLayout secMatbdateDK;
         View lineMatbdateDK;
         TextView VlblMatbdateDK;
         CheckBox chkMatbdateDK;
         LinearLayout secMatage;
         View lineMatage;
         TextView VlblMatage;
         EditText txtMatage;
         LinearLayout seclblsec16;
         View linelblsec16;
         LinearLayout secMatageDK;
         View lineMatageDK;
         TextView VlblMatageDK;
         CheckBox chkMatageDK;
         LinearLayout secaddr1;
         View lineaddr1;
         TextView Vlbladdr1;
         Spinner spnaddr1;
         LinearLayout secaddr2;
         View lineaddr2;
         TextView Vlbladdr2;
         AutoCompleteTextView txtaddr2;
         LinearLayout secaddr3;
         View lineaddr3;
         TextView Vlbladdr3;
     AutoCompleteTextView txtaddr3;
         LinearLayout secaddr4;
         View lineaddr4;
         TextView Vlbladdr4;
     AutoCompleteTextView txtaddr4;
         LinearLayout secAddressDetail;
         View lineAddressDetail;
         TextView VlblAddressDetail;
         EditText txtAddressDetail;
         LinearLayout secmatmobile;
         View linematmobile;
         TextView Vlblmatmobile;
         RadioGroup rdogrpmatmobile;
         
         RadioButton rdomatmobile1;
         RadioButton rdomatmobile2;
         LinearLayout secMatmobnum;
         View lineMatmobnum;
         TextView VlblMatmobnum;
         EditText txtMatmobnum;
         LinearLayout secMatmobnumDK;
         View lineMatmobnumDK;
         TextView VlblMatmobnumDK;
         CheckBox chkMatmobnumDK;
         LinearLayout secMatmobnum1;
         View lineMatmobnum1;
         TextView VlblMatmobnum1;
         EditText txtMatmobnum1;
         LinearLayout secMatmobnum1DK;
         View lineMatmobnum1DK;
         TextView VlblMatmobnum1DK;
         CheckBox chkMatmobnum1DK;
         LinearLayout sechusmob;
         View linehusmob;
         TextView Vlblhusmob;
         RadioGroup rdogrphusmob;
         
         RadioButton rdohusmob1;
         RadioButton rdohusmob2;
         LinearLayout secHusmobnum;
         View lineHusmobnum;
         TextView VlblHusmobnum;
         EditText txtHusmobnum;
         LinearLayout secHusmobnumDK;
         View lineHusmobnumDK;
         TextView VlblHusmobnumDK;
         CheckBox chkHusmobnumDK;
         LinearLayout secHusmobnum2;
         View lineHusmobnum2;
         TextView VlblHusmobnum2;
         EditText txtHusmobnum2;
         LinearLayout secHusmobnum2DK;
         View lineHusmobnum2DK;
         TextView VlblHusmobnum2DK;
         CheckBox chkHusmobnum2DK;
         LinearLayout seccontact1;
         View linecontact1;
         TextView Vlblcontact1;
         EditText txtcontact1;
         LinearLayout seclblsec13;
         View linelblsec13;
         LinearLayout seceddknown;
         View lineeddknown;
         TextView Vlbleddknown;
         RadioGroup rdogrpeddknown;
         
         RadioButton rdoeddknown1;
         RadioButton rdoeddknown2;
         RadioButton rdoeddknown3;
         LinearLayout secEdd;
         View lineEdd;
         TextView VlblEdd;
         EditText dtpEdd;
         LinearLayout secEddDK;
         View lineEddDK;
         TextView VlblEddDK;
         //CheckBox chkEddDK;
         LinearLayout seclblsec17;
         View linelblsec17;
         LinearLayout secGameth;
         //View lineGameth;
         //TextView VlblGameth;
         //Spinner spnGameth;
         //LinearLayout secGamethOth;
         //View lineGamethOth;
         //TextView VlblGamethOth;
         //EditText txtGamethOth;
         LinearLayout secga1anc;
         View linega1anc;
         TextView Vlblga1anc;
         EditText txtga1anc;
         LinearLayout secga1ancWM;
         View linega1ancWM;
         TextView Vlblga1ancWM;
         RadioGroup rdogrpga1ancWM;
         
         RadioButton rdoga1ancWM1;
         RadioButton rdoga1ancWM2;
         RadioButton rdoga1ancWM3;
         LinearLayout secantcarenum;
         View lineantcarenum;
         TextView Vlblantcarenum;
         Spinner spnantcarenum;
         LinearLayout secga;
         View linega;
         TextView Vlblga;
         EditText txtga;
         LinearLayout secgaWM;
         View linegaWM;
         TextView VlblgaWM;
         RadioGroup rdogrpgaWM;
         
         RadioButton rdogaWM1;
         RadioButton rdogaWM2;
         RadioButton rdogaWM3;
         LinearLayout seclblsec14;
         View linelblsec14;
         LinearLayout secbheart;
         View linebheart;
         TextView Vlblbheart;
         RadioGroup rdogrpbheart;
         
         RadioButton rdobheart1;
         RadioButton rdobheart2;
         RadioButton rdobheart3;
         RadioButton rdobheart4;
         LinearLayout secbcondition;
         View linebcondition;
         TextView Vlblbcondition;
         //Spinner spnbcondition;

         RadioGroup rdogrpbcondition;
         RadioButton rdobcondition1;
         RadioButton rdobcondition2;
         RadioButton rdobcondition3;

         LinearLayout secplacedeliv;
         View lineplacedeliv;
         TextView Vlblplacedeliv;
         RadioGroup rdogrpplacedeliv;
         
         RadioButton rdoplacedeliv1;
         RadioButton rdoplacedeliv2;
         RadioButton rdoplacedeliv3;
         RadioButton rdoplacedeliv4;
         RadioButton rdoplacedeliv5;

         LinearLayout secplacedelivOth;
         View lineplacedelivOth;
         TextView VlblplacedelivOth;
         EditText txtplacedelivOth;
         LinearLayout secdelivdate;
         View linedelivdate;
         TextView Vlbldelivdate;
         EditText dtpdelivdate;
         LinearLayout secdelivdateDK;
         View linedelivdateDK;
         TextView VlbldelivdateDK;
         CheckBox chkdelivdateDK;
         LinearLayout secdelivtime;
         View linedelivtime;
         TextView Vlbldelivtime;
         EditText txtdelivtime;
         LinearLayout secdelivtimeDK;
         View linedelivtimeDK;
         TextView VlbldelivtimeDK;
         CheckBox chkdelivtimeDK;
         LinearLayout sectypebirth;
         View linetypebirth;
         TextView Vlbltypebirth;
         Spinner spntypebirth;
         LinearLayout seclblsec18;
         View linelblsec18;
         LinearLayout secTimecsec;
         View lineTimecsec;
         TextView VlblTimecsec;
         Spinner spnTimecsec;
         LinearLayout secToldcsecreas;
         View lineToldcsecreas;
         TextView VlblToldcsecreas;
         RadioGroup rdogrpToldcsecreas;
         
         RadioButton rdoToldcsecreas1;
         RadioButton rdoToldcsecreas2;
         RadioButton rdoToldcsecreas3;
         LinearLayout secCsecreas;
         View lineCsecreas;
         TextView VlblCsecreas;
         Spinner spnCsecreas;
         LinearLayout secOthReason;
         View lineOthReason;
         TextView VlblOthReason;
         EditText txtOthReason;
         LinearLayout secBwgted;
         View lineBwgted;
         TextView VlblBwgted;
         RadioGroup rdogrpBwgted;
         
         RadioButton rdoBwgted1;
         RadioButton rdoBwgted2;
         RadioButton rdoBwgted3;
         LinearLayout secBwgt;
         View lineBwgt;
         TextView VlblBwgt;
         EditText txtBwgt;
         LinearLayout secBwgtDK;
         View lineBwgtDK;
         TextView VlblBwgtDK;
         RadioGroup rdogrpBwgtDK;
         
         RadioButton rdoBwgtDK1;
         RadioButton rdoBwgtDK2;
         LinearLayout secbwgtmeth;
         View linebwgtmeth;
         TextView Vlblbwgtmeth;
         RadioGroup rdogrpbwgtmeth;
         
         RadioButton rdobwgtmeth1;
         RadioButton rdobwgtmeth2;
         RadioButton rdobwgtmeth3;
         LinearLayout secBsex;
         View lineBsex;
         TextView VlblBsex;
         Spinner spnBsex;
         LinearLayout secperceivesize;
         View lineperceivesize;
         TextView Vlblperceivesize;
         Spinner spnperceivesize;
         LinearLayout secanybcomp;
         View lineanybcomp;
         TextView Vlblanybcomp;
         RadioGroup rdogrpanybcomp;
         
         RadioButton rdoanybcomp1;
         RadioButton rdoanybcomp2;
         RadioButton rdoanybcomp3;
         LinearLayout seclblsec15;
         View linelblsec15;
         LinearLayout secbcompA;
         View linebcompA;
         TextView VlblbcompA;
         CheckBox chkbcompA;
         LinearLayout secbcompB;
         View linebcompB;
         TextView VlblbcompB;
         CheckBox chkbcompB;
         LinearLayout secbcompC;
         View linebcompC;
         TextView VlblbcompC;
         CheckBox chkbcompC;
         LinearLayout secbcompD;
         View linebcompD;
         TextView VlblbcompD;
         CheckBox chkbcompD;
         LinearLayout secbcompE;
         View linebcompE;
         TextView VlblbcompE;
         CheckBox chkbcompE;
         LinearLayout secbcompF;
         View linebcompF;
         TextView VlblbcompF;
         CheckBox chkbcompF;
         LinearLayout secbcompG;
         View linebcompG;
         TextView VlblbcompG;
         CheckBox chkbcompG;
         LinearLayout secbcompH;
         View linebcompH;
         TextView VlblbcompH;
         CheckBox chkbcompH;
         LinearLayout secbcompI;
         View linebcompI;
         TextView VlblbcompI;
         CheckBox chkbcompI;
         LinearLayout secbcompIOth;
         View linebcompIOth;
         TextView VlblbcompIOth;
         EditText txtbcompIOth;
         LinearLayout secbcompJ;
         View linebcompJ;
         TextView VlblbcompJ;
         CheckBox chkbcompJ;
         LinearLayout secnightsnum;
         View linenightsnum;
         TextView Vlblnightsnum;
         EditText txtnightsnum;
         LinearLayout secnightsnumDK;
         View linenightsnumDK;
         TextView VlblnightsnumDK;
         CheckBox chknightsnumDK;
         LinearLayout secbnotif;
         View linebnotif;
         TextView Vlblbnotif;
         RadioGroup rdogrpbnotif;
         
         RadioButton rdobnotif1;
         RadioButton rdobnotif2;
         RadioButton rdobnotif3;
         RadioButton rdobnotif4;
         LinearLayout secbcert;
         View linebcert;
         TextView Vlblbcert;
         RadioGroup rdogrpbcert;
         
         RadioButton rdobcert1;
         RadioButton rdobcert2;
         RadioButton rdobcert3;
         LinearLayout secbcertknow;
         View linebcertknow;
         TextView Vlblbcertknow;
         RadioGroup rdogrpbcertknow;
         
         RadioButton rdobcertknow1;
         RadioButton rdobcertknow2;
         RadioButton rdobcertknow3;
         LinearLayout secbcerttime;
         View linebcerttime;
         TextView Vlblbcerttime;
         EditText txtbcerttime;
         LinearLayout secbcerttimeWM;
         View linebcerttimeWM;
         TextView VlblbcerttimeWM;
         RadioGroup rdogrpbcerttimeWM;
         
         RadioButton rdobcerttimeWM1;
         RadioButton rdobcerttimeWM2;
         RadioButton rdobcerttimeWM3;
         LinearLayout secanybcertcon;
         View lineanybcertcon;
         TextView Vlblanybcertcon;
         //Spinner spnanybcertcon;
     RadioGroup rdogrpanybcertcon;

     RadioButton rdoanybcertcon1;
     RadioButton rdoanybcertcon2;
     RadioButton rdoanybcertcon3;



         LinearLayout secbcertcon;
         View linebcertcon;
         TextView Vlblbcertcon;
         //Spinner spnbcertcon;
     CheckBox chkbcertcona;
     CheckBox chkbcertconb;
     CheckBox chkbcertconc;
     CheckBox chkbcertcond;
     CheckBox chkbcertcone;

         LinearLayout secbcertconOth;
         View linebcertconOth;
         TextView VlblbcertconOth;
         EditText txtbcertconOth;
    EditText txtcomments;

      LinearLayout secEddDKOth;
      EditText txtEddDKOth;
      RadioGroup rdogrpEddDK;
      RadioButton rdoEddDK1;
      RadioButton rdoEddDK2;

      LinearLayout secGametha;
      CheckBox chkGametha;
      LinearLayout secGamethb;
      CheckBox chkGamethb;
      LinearLayout secGamethc;
      CheckBox chkGamethc;
      LinearLayout secGamethd;
      CheckBox chkGamethd;
      LinearLayout secGamethe;
      CheckBox chkGamethe;
      LinearLayout secGametheOth;
      EditText txtGametheOth;
      LinearLayout secGamethf;
      CheckBox chkGamethf;
     LinearLayout seclangOth;
     EditText txtlangOth;

     LinearLayout secinterp;
     RadioGroup rdogrpinterp;
     RadioButton rdointerp1;
     RadioButton rdointerp2;
     LinearLayout secinterpName;
     EditText txtinterpName;

     LinearLayout secFormEdu;
     LinearLayout secFormEduDK;
     EditText txtFormEdu;
     CheckBox chkFormEduDK;

    static String TableName;

    static String STARTTIME = "";
    static String DEVICEID  = "";
    static String ENTRYUSER = "";
    MySharedPreferences sp;

    Bundle IDbundle;
    static String COUNTRYCODE = "";
    static String FACICODE = "";
    static String DATAID = "";
      static String STUDYID = "";

 public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
   try
     {
         C = new Connection(this);
         g = Global.getInstance();

         getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

         COUNTRYCODE = sp.getValue(this, "countrycode");

         if(ProjectSetting.MRS_Language_English == true){
             setContentView(R.layout.recallsurvs1);
         }else {
             if (COUNTRYCODE.equals(ProjectSetting.BANGLADESH))
                 setContentView(R.layout.recallsurvs1_bd);
             else if (COUNTRYCODE.equals(ProjectSetting.NEPAL))
                 setContentView(R.layout.recallsurvs1_np);
             else if (COUNTRYCODE.equals(ProjectSetting.TANZANIA))
                 setContentView(R.layout.recallsurvs1_tz);
             else
                 setContentView(R.layout.recallsurvs1);
         }



         STARTTIME = g.CurrentTime24();
         DEVICEID  = sp.getValue(this, "deviceid");
         ENTRYUSER = sp.getValue(this, "userid");

         IDbundle = getIntent().getExtras();

         FACICODE    = sp.getValue(this, "facicode");
         DATAID = IDbundle.getString("dataid");
         STUDYID = IDbundle.getString("studyid");

         TableName = "RecallSurvS1";

         //turnGPSOn();

         //GPS Location
         //FindLocation();
         // Double.toString(currentLatitude);
         // Double.toString(currentLongitude);
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         txtcomments = (EditText)findViewById(R.id.txtcomments);
         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(RecallSurvS1.this);
                 adb.setTitle("Close");
                 adb.setMessage("Do you want to close this form[Yes/No]?");
                 adb.setNegativeButton("No", null);
                 adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                     public void onClick(DialogInterface dialog, int which) {
                         finish();
                     }});
                 adb.show();
             }});

         Button btnQ18 = (Button)findViewById(R.id.btnQ18);
         btnQ18.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 IDbundle.putString("varname", "q18");
                 Intent f1 = new Intent(getApplicationContext(),MRS_Photo.class);
                 f1.putExtras(IDbundle);
                 startActivity(f1);
             }});
         Button btnQ22 = (Button)findViewById(R.id.btnQ22);
         btnQ22.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 IDbundle.putString("varname", "q22");
                 Intent f1 = new Intent(getApplicationContext(),MRS_Photo.class);
                 f1.putExtras(IDbundle);
                 startActivity(f1);
             }});
         Button btnQ27 = (Button)findViewById(R.id.btnQ27);
         btnQ27.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 IDbundle.putString("varname", "q27");
                 Intent f1 = new Intent(getApplicationContext(),MRS_Photo.class);
                 f1.putExtras(IDbundle);
                 startActivity(f1);
             }});
         Button btnQ31 = (Button)findViewById(R.id.btnQ31);
         btnQ31.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 IDbundle.putString("varname", "q31");
                 Intent f1 = new Intent(getApplicationContext(),MRS_Photo.class);
                 f1.putExtras(IDbundle);
                 startActivity(f1);
             }});

         secFormEdu = (LinearLayout)findViewById(R.id.secFormEdu);
         secFormEduDK = (LinearLayout)findViewById(R.id.secFormEduDK);
         txtFormEdu=(EditText)findViewById(R.id.txtFormEdu) ;
         chkFormEduDK=(CheckBox)findViewById(R.id.chkFormEduDK) ;


         secinterp=(LinearLayout)findViewById(R.id.secinterp) ;
         rdogrpinterp=(RadioGroup)findViewById(R.id.rdogrpinterp) ;
         rdointerp1=(RadioButton)findViewById(R.id.rdointerp1) ;
         rdointerp2=(RadioButton)findViewById(R.id.rdointerp2) ;
         secinterpName=(LinearLayout)findViewById(R.id.secinterpName) ;
         txtinterpName=(EditText)findViewById(R.id.txtinterpName) ;


         seclangOth=(LinearLayout)findViewById(R.id.seclangOth) ;
         txtlangOth=(EditText)findViewById(R.id.txtlangOth) ;

          secGametha=(LinearLayout)findViewById(R.id.secGametha) ;
          chkGametha=(CheckBox)findViewById(R.id.chkGametha) ;
          secGamethb=(LinearLayout)findViewById(R.id.secGamethb) ;
          chkGamethb=(CheckBox)findViewById(R.id.chkGamethb) ;
          secGamethc=(LinearLayout)findViewById(R.id.secGamethc);
          chkGamethc=(CheckBox)findViewById(R.id.chkGamethc) ;
          secGamethd=(LinearLayout)findViewById(R.id.secGamethd) ;
          chkGamethd=(CheckBox)findViewById(R.id.chkGamethd) ;
          secGamethe=(LinearLayout)findViewById(R.id.secGamethe) ;
          chkGamethe=(CheckBox)findViewById(R.id.chkGamethe) ;
          secGametheOth=(LinearLayout)findViewById(R.id.secGametheOth) ;
          txtGametheOth=(EditText)findViewById(R.id.txtGametheOth) ;
          secGamethf=(LinearLayout)findViewById(R.id.secGamethf) ;
          chkGamethf=(CheckBox)findViewById(R.id.chkGamethf) ;

          secEddDKOth=(LinearLayout)findViewById(R.id.secEddDKOth) ;
          txtEddDKOth=(EditText)findViewById(R.id.txtEddDKOth) ;
          rdogrpEddDK=(RadioGroup)findViewById(R.id.rdogrpEddDK) ;
          rdoEddDK1=(RadioButton)findViewById(R.id.rdoEddDK1) ;
          rdoEddDK2=(RadioButton)findViewById(R.id.rdoEddDK2) ;

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
         seclblsec1=(LinearLayout)findViewById(R.id.seclblsec1);
         linelblsec1=(View)findViewById(R.id.linelblsec1);
         secDataID=(LinearLayout)findViewById(R.id.secDataID);
         lineDataID=(View)findViewById(R.id.lineDataID);
         VlblDataID=(TextView) findViewById(R.id.VlblDataID);
         txtDataID=(EditText) findViewById(R.id.txtDataID);
         txtDataID.setText(DATAID);
         txtDataID.setEnabled(false);
         secStudyID=(LinearLayout)findViewById(R.id.secStudyID);
         lineStudyID=(View)findViewById(R.id.lineStudyID);
         VlblStudyID=(TextView) findViewById(R.id.VlblStudyID);
         txtStudyID=(EditText) findViewById(R.id.txtStudyID);
         txtStudyID.setText(STUDYID);
         txtStudyID.setEnabled(false);
         secConsentMRS=(LinearLayout)findViewById(R.id.secConsentMRS);
         lineConsentMRS=(View)findViewById(R.id.lineConsentMRS);
         VlblConsentMRS = (TextView) findViewById(R.id.VlblConsentMRS);
         rdogrpConsentMRS = (RadioGroup) findViewById(R.id.rdogrpConsentMRS);
         
         rdoConsentMRS1 = (RadioButton) findViewById(R.id.rdoConsentMRS1);
         rdoConsentMRS2 = (RadioButton) findViewById(R.id.rdoConsentMRS2);
         rdogrpConsentMRS.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpConsentMRS = new String[] {"1","2"};
             for (int i = 0; i < rdogrpConsentMRS.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpConsentMRS.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpConsentMRS[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                 seclangOth.setVisibility(View.GONE);
                 secinterp.setVisibility(View.GONE);
                 secinterpName.setVisibility(View.GONE);

                    secConsentFollo.setVisibility(View.GONE);
                    lineConsentFollo.setVisibility(View.GONE);
                    rdogrpConsentFollo.clearCheck();
                    seclblsec11.setVisibility(View.GONE);
                    linelblsec11.setVisibility(View.GONE);
                    secdoi.setVisibility(View.GONE);
                    linedoi.setVisibility(View.GONE);
                    dtpdoi.setText("");
                    sectoi.setVisibility(View.GONE);
                    linetoi.setVisibility(View.GONE);
                    txttoi.setText("");
                    seclang.setVisibility(View.GONE);
                    linelang.setVisibility(View.GONE);
                    spnlang.setSelection(0);
                    seccconditionb.setVisibility(View.GONE);
                    linecconditionb.setVisibility(View.GONE);
                    spncconditionb.setSelection(0);
                    seclblsec12.setVisibility(View.GONE);
                 seclblsec121.setVisibility(View.GONE);
                    linelblsec12.setVisibility(View.GONE);
                    secmatconsent.setVisibility(View.GONE);
                    linematconsent.setVisibility(View.GONE);
                    rdogrpmatconsent.clearCheck();
                    secMatbdateM.setVisibility(View.GONE);
                  secMatbdateM1.setVisibility(View.GONE);
                    lineMatbdateM.setVisibility(View.GONE);
                    spnMatbdateM.setSelection(0);
                    secMatbdateY.setVisibility(View.GONE);
                    lineMatbdateY.setVisibility(View.GONE);
                    txtMatbdateY.setText("");
                    secMatbdateDK.setVisibility(View.GONE);
                    lineMatbdateDK.setVisibility(View.GONE);
                    chkMatbdateDK.setChecked(false);
                    secMatage.setVisibility(View.GONE);
                    lineMatage.setVisibility(View.GONE);
                    txtMatage.setText("");
                    seclblsec16.setVisibility(View.GONE);
                    linelblsec16.setVisibility(View.GONE);
                    secMatageDK.setVisibility(View.GONE);
                    lineMatageDK.setVisibility(View.GONE);
                    chkMatageDK.setChecked(false);
                 secFormEdu.setVisibility(View.GONE);
                 txtFormEdu.setText("");
                 secFormEduDK.setVisibility(View.GONE);
                 chkFormEduDK.setChecked(false);


                 secaddr1.setVisibility(View.GONE);
                    lineaddr1.setVisibility(View.GONE);
                    spnaddr1.setSelection(0);
                    secaddr2.setVisibility(View.GONE);
                    lineaddr2.setVisibility(View.GONE);
                    txtaddr2.setText("");
                    secaddr3.setVisibility(View.GONE);
                    lineaddr3.setVisibility(View.GONE);
                    txtaddr3.setText("");
                    secaddr4.setVisibility(View.GONE);
                    lineaddr4.setVisibility(View.GONE);
                    txtaddr4.setText("");
                    secAddressDetail.setVisibility(View.GONE);
                    lineAddressDetail.setVisibility(View.GONE);
                    txtAddressDetail.setText("");
                    secmatmobile.setVisibility(View.GONE);
                    linematmobile.setVisibility(View.GONE);
                    rdogrpmatmobile.clearCheck();
                    secMatmobnum.setVisibility(View.GONE);
                    lineMatmobnum.setVisibility(View.GONE);
                    txtMatmobnum.setText("");
                    secMatmobnumDK.setVisibility(View.GONE);
                    lineMatmobnumDK.setVisibility(View.GONE);
                    chkMatmobnumDK.setChecked(false);
                    secMatmobnum1.setVisibility(View.GONE);
                    lineMatmobnum1.setVisibility(View.GONE);
                    txtMatmobnum1.setText("");
                    secMatmobnum1DK.setVisibility(View.GONE);
                    lineMatmobnum1DK.setVisibility(View.GONE);
                    chkMatmobnum1DK.setChecked(false);
                    sechusmob.setVisibility(View.GONE);
                    linehusmob.setVisibility(View.GONE);
                    rdogrphusmob.clearCheck();
                    secHusmobnum.setVisibility(View.GONE);
                    lineHusmobnum.setVisibility(View.GONE);
                    txtHusmobnum.setText("");
                    secHusmobnumDK.setVisibility(View.GONE);
                    lineHusmobnumDK.setVisibility(View.GONE);
                    chkHusmobnumDK.setChecked(false);
                    secHusmobnum2.setVisibility(View.GONE);
                    lineHusmobnum2.setVisibility(View.GONE);
                    txtHusmobnum2.setText("");
                    secHusmobnum2DK.setVisibility(View.GONE);
                    lineHusmobnum2DK.setVisibility(View.GONE);
                    chkHusmobnum2DK.setChecked(false);
                    seccontact1.setVisibility(View.GONE);
                    linecontact1.setVisibility(View.GONE);
                    txtcontact1.setText("");
                    seclblsec13.setVisibility(View.GONE);
                    linelblsec13.setVisibility(View.GONE);
                    seceddknown.setVisibility(View.GONE);
                    lineeddknown.setVisibility(View.GONE);
                    rdogrpeddknown.clearCheck();
                    secEdd.setVisibility(View.GONE);
                    lineEdd.setVisibility(View.GONE);
                    dtpEdd.setText("");
                    secEddDK.setVisibility(View.GONE);
                    lineEddDK.setVisibility(View.GONE);
                    //chkEddDK.setChecked(false);
                    secEddDKOth.setVisibility(View.GONE);
                    seclblsec17.setVisibility(View.GONE);
                    linelblsec17.setVisibility(View.GONE);
                    secGameth.setVisibility(View.GONE);
                  secGametha.setVisibility(View.GONE);
                  chkGametha.setChecked(false);
                  secGamethb.setVisibility(View.GONE);
                  chkGamethb.setChecked(false);
                  secGamethc.setVisibility(View.GONE);
                  chkGamethc.setChecked(false);
                  secGamethd.setVisibility(View.GONE);
                  chkGamethd.setChecked(false);
                  secGamethe.setVisibility(View.GONE);
                  chkGamethe.setChecked(false);
                  txtGametheOth.setText("");
                  secGamethf.setVisibility(View.GONE);
                  chkGamethf.setChecked(false);

                    //lineGameth.setVisibility(View.GONE);
                    //spnGameth.setSelection(0);
                    //secGamethOth.setVisibility(View.GONE);
                    //lineGamethOth.setVisibility(View.GONE);
                    //txtGamethOth.setText("");
                    secga1anc.setVisibility(View.GONE);
                    linega1anc.setVisibility(View.GONE);
                    txtga1anc.setText("");
                    secga1ancWM.setVisibility(View.GONE);
                    linega1ancWM.setVisibility(View.GONE);
                    rdogrpga1ancWM.clearCheck();
                    secantcarenum.setVisibility(View.GONE);
                    lineantcarenum.setVisibility(View.GONE);
                    spnantcarenum.setSelection(0);
                    secga.setVisibility(View.GONE);
                    linega.setVisibility(View.GONE);
                    txtga.setText("");
                    secgaWM.setVisibility(View.GONE);
                    linegaWM.setVisibility(View.GONE);
                    rdogrpgaWM.clearCheck();
                    seclblsec14.setVisibility(View.GONE);
                    linelblsec14.setVisibility(View.GONE);
                    secbheart.setVisibility(View.GONE);
                    linebheart.setVisibility(View.GONE);
                    rdogrpbheart.clearCheck();
                    secbcondition.setVisibility(View.GONE);
                    linebcondition.setVisibility(View.GONE);
                    //spnbcondition.setSelection(0);
                 rdogrpbcondition.clearCheck();
                    secplacedeliv.setVisibility(View.GONE);
                    lineplacedeliv.setVisibility(View.GONE);
                    rdogrpplacedeliv.clearCheck();
                    secplacedelivOth.setVisibility(View.GONE);
                    lineplacedelivOth.setVisibility(View.GONE);
                    txtplacedelivOth.setText("");
                    secdelivdate.setVisibility(View.GONE);
                    linedelivdate.setVisibility(View.GONE);
                    dtpdelivdate.setText("");
                    secdelivdateDK.setVisibility(View.GONE);
                    linedelivdateDK.setVisibility(View.GONE);
                    chkdelivdateDK.setChecked(false);
                    secdelivtime.setVisibility(View.GONE);
                    linedelivtime.setVisibility(View.GONE);
                    txtdelivtime.setText("");
                    secdelivtimeDK.setVisibility(View.GONE);
                    linedelivtimeDK.setVisibility(View.GONE);
                    chkdelivtimeDK.setChecked(false);
                    sectypebirth.setVisibility(View.GONE);
                    linetypebirth.setVisibility(View.GONE);
                    spntypebirth.setSelection(0);
                    seclblsec18.setVisibility(View.GONE);
                    linelblsec18.setVisibility(View.GONE);
                    secTimecsec.setVisibility(View.GONE);
                    lineTimecsec.setVisibility(View.GONE);
                    spnTimecsec.setSelection(0);
                    secToldcsecreas.setVisibility(View.GONE);
                    lineToldcsecreas.setVisibility(View.GONE);
                    rdogrpToldcsecreas.clearCheck();
                    secCsecreas.setVisibility(View.GONE);
                    lineCsecreas.setVisibility(View.GONE);
                    spnCsecreas.setSelection(0);
                    secOthReason.setVisibility(View.GONE);
                    lineOthReason.setVisibility(View.GONE);
                    txtOthReason.setText("");
                    secBwgted.setVisibility(View.GONE);
                    lineBwgted.setVisibility(View.GONE);
                    rdogrpBwgted.clearCheck();
                    secBwgt.setVisibility(View.GONE);
                    lineBwgt.setVisibility(View.GONE);
                    txtBwgt.setText("");
                    secBwgtDK.setVisibility(View.GONE);
                    lineBwgtDK.setVisibility(View.GONE);
                    rdogrpBwgtDK.clearCheck();
                    secbwgtmeth.setVisibility(View.GONE);
                    linebwgtmeth.setVisibility(View.GONE);
                    rdogrpbwgtmeth.clearCheck();
                    secBsex.setVisibility(View.GONE);
                    lineBsex.setVisibility(View.GONE);
                    spnBsex.setSelection(0);
                    secperceivesize.setVisibility(View.GONE);
                    lineperceivesize.setVisibility(View.GONE);
                    spnperceivesize.setSelection(0);
                    secanybcomp.setVisibility(View.GONE);
                    lineanybcomp.setVisibility(View.GONE);
                    rdogrpanybcomp.clearCheck();
                    seclblsec15.setVisibility(View.GONE);
                    linelblsec15.setVisibility(View.GONE);
                    secbcompA.setVisibility(View.GONE);
                    linebcompA.setVisibility(View.GONE);
                    chkbcompA.setChecked(false);
                    secbcompB.setVisibility(View.GONE);
                    linebcompB.setVisibility(View.GONE);
                    chkbcompB.setChecked(false);
                    secbcompC.setVisibility(View.GONE);
                    linebcompC.setVisibility(View.GONE);
                    chkbcompC.setChecked(false);
                    secbcompD.setVisibility(View.GONE);
                    linebcompD.setVisibility(View.GONE);
                    chkbcompD.setChecked(false);
                    secbcompE.setVisibility(View.GONE);
                    linebcompE.setVisibility(View.GONE);
                    chkbcompE.setChecked(false);
                    secbcompF.setVisibility(View.GONE);
                    linebcompF.setVisibility(View.GONE);
                    chkbcompF.setChecked(false);
                    secbcompG.setVisibility(View.GONE);
                    linebcompG.setVisibility(View.GONE);
                    chkbcompG.setChecked(false);
                    secbcompH.setVisibility(View.GONE);
                    linebcompH.setVisibility(View.GONE);
                    chkbcompH.setChecked(false);
                    secbcompI.setVisibility(View.GONE);
                    linebcompI.setVisibility(View.GONE);
                    chkbcompI.setChecked(false);
                    secbcompIOth.setVisibility(View.GONE);
                    linebcompIOth.setVisibility(View.GONE);
                    txtbcompIOth.setText("");
                    secbcompJ.setVisibility(View.GONE);
                    linebcompJ.setVisibility(View.GONE);
                    chkbcompJ.setChecked(false);
                    secnightsnum.setVisibility(View.GONE);
                    linenightsnum.setVisibility(View.GONE);
                    txtnightsnum.setText("");
                    secnightsnumDK.setVisibility(View.GONE);
                    linenightsnumDK.setVisibility(View.GONE);
                    chknightsnumDK.setChecked(false);
                    secbnotif.setVisibility(View.GONE);
                    linebnotif.setVisibility(View.GONE);
                    rdogrpbnotif.clearCheck();
                    secbcert.setVisibility(View.GONE);
                    linebcert.setVisibility(View.GONE);
                    rdogrpbcert.clearCheck();
                    secbcertknow.setVisibility(View.GONE);
                    linebcertknow.setVisibility(View.GONE);
                    rdogrpbcertknow.clearCheck();
                    secbcerttime.setVisibility(View.GONE);
                    linebcerttime.setVisibility(View.GONE);
                    txtbcerttime.setText("");
                    secbcerttimeWM.setVisibility(View.GONE);
                    linebcerttimeWM.setVisibility(View.GONE);
                    rdogrpbcerttimeWM.clearCheck();
                    secanybcertcon.setVisibility(View.GONE);
                    lineanybcertcon.setVisibility(View.GONE);
                 //   spnanybcertcon.setSelection(0);
                 rdogrpanybcertcon.clearCheck();
                    secbcertcon.setVisibility(View.GONE);
                    linebcertcon.setVisibility(View.GONE);
                    //spnbcertcon.setSelection(0);
                 chkbcertcona.setChecked(false);
                 chkbcertconb.setChecked(false);
                 chkbcertconc.setChecked(false);
                 chkbcertcond.setChecked(false);
                 chkbcertcone.setChecked(false);
                    secbcertconOth.setVisibility(View.GONE);
                    linebcertconOth.setVisibility(View.GONE);
                    txtbcertconOth.setText("");
             }
             else
             {
                 seclangOth.setVisibility(View.GONE);
                 secinterp.setVisibility(View.GONE);

                    secConsentFollo.setVisibility(View.VISIBLE);
                    lineConsentFollo.setVisibility(View.VISIBLE);
                    seclblsec11.setVisibility(View.VISIBLE);
                    linelblsec11.setVisibility(View.VISIBLE);
                    secdoi.setVisibility(View.VISIBLE);
                  dtpdoi.setText(Global.DateNowDMY());
                    linedoi.setVisibility(View.VISIBLE);
                    sectoi.setVisibility(View.VISIBLE);
                  txttoi.setText(g.CurrentTime24());
                    linetoi.setVisibility(View.VISIBLE);
                    seclang.setVisibility(View.VISIBLE);
                    linelang.setVisibility(View.VISIBLE);
                    seccconditionb.setVisibility(View.VISIBLE);
                    linecconditionb.setVisibility(View.VISIBLE);
                    seclblsec12.setVisibility(View.VISIBLE);
                 seclblsec121.setVisibility(View.VISIBLE);
                    linelblsec12.setVisibility(View.VISIBLE);
                    secmatconsent.setVisibility(View.VISIBLE);
                    linematconsent.setVisibility(View.VISIBLE);

                    /*secMatbdateM.setVisibility(View.VISIBLE);
                    lineMatbdateM.setVisibility(View.VISIBLE);
                    secMatbdateY.setVisibility(View.VISIBLE);
                    lineMatbdateY.setVisibility(View.VISIBLE);
                    secMatbdateDK.setVisibility(View.VISIBLE);
                    lineMatbdateDK.setVisibility(View.VISIBLE);
                    secMatage.setVisibility(View.VISIBLE);
                    lineMatage.setVisibility(View.VISIBLE);
                    seclblsec16.setVisibility(View.VISIBLE);
                    linelblsec16.setVisibility(View.VISIBLE);
                    secMatageDK.setVisibility(View.VISIBLE);
                    lineMatageDK.setVisibility(View.VISIBLE);
                    secaddr1.setVisibility(View.VISIBLE);
                    lineaddr1.setVisibility(View.VISIBLE);
                    secaddr2.setVisibility(View.VISIBLE);
                    lineaddr2.setVisibility(View.VISIBLE);
                    secaddr3.setVisibility(View.VISIBLE);
                    lineaddr3.setVisibility(View.VISIBLE);
                    secaddr4.setVisibility(View.VISIBLE);
                    lineaddr4.setVisibility(View.VISIBLE);
                    secAddressDetail.setVisibility(View.VISIBLE);
                    lineAddressDetail.setVisibility(View.VISIBLE);
                    secmatmobile.setVisibility(View.VISIBLE);
                    linematmobile.setVisibility(View.VISIBLE);
                    secMatmobnum.setVisibility(View.VISIBLE);
                    lineMatmobnum.setVisibility(View.VISIBLE);
                    secMatmobnumDK.setVisibility(View.VISIBLE);
                    lineMatmobnumDK.setVisibility(View.VISIBLE);
                    secMatmobnum1.setVisibility(View.VISIBLE);
                    lineMatmobnum1.setVisibility(View.VISIBLE);
                    secMatmobnum1DK.setVisibility(View.VISIBLE);
                    lineMatmobnum1DK.setVisibility(View.VISIBLE);
                    sechusmob.setVisibility(View.VISIBLE);
                    linehusmob.setVisibility(View.VISIBLE);
                    secHusmobnum.setVisibility(View.VISIBLE);
                    lineHusmobnum.setVisibility(View.VISIBLE);
                    secHusmobnumDK.setVisibility(View.VISIBLE);
                    lineHusmobnumDK.setVisibility(View.VISIBLE);
                    secHusmobnum2.setVisibility(View.VISIBLE);
                    lineHusmobnum2.setVisibility(View.VISIBLE);
                    secHusmobnum2DK.setVisibility(View.VISIBLE);
                    lineHusmobnum2DK.setVisibility(View.VISIBLE);
                    seccontact1.setVisibility(View.VISIBLE);
                    linecontact1.setVisibility(View.VISIBLE);
                    seclblsec13.setVisibility(View.VISIBLE);
                    linelblsec13.setVisibility(View.VISIBLE);
                    seceddknown.setVisibility(View.VISIBLE);
                    lineeddknown.setVisibility(View.VISIBLE);
                    secEdd.setVisibility(View.VISIBLE);
                    lineEdd.setVisibility(View.VISIBLE);
                    secEddDK.setVisibility(View.VISIBLE);
                    lineEddDK.setVisibility(View.VISIBLE);
                    seclblsec17.setVisibility(View.VISIBLE);
                    linelblsec17.setVisibility(View.VISIBLE);
                    secGameth.setVisibility(View.VISIBLE);
                    lineGameth.setVisibility(View.VISIBLE);
                    secGamethOth.setVisibility(View.VISIBLE);
                    lineGamethOth.setVisibility(View.VISIBLE);
                    secga1anc.setVisibility(View.VISIBLE);
                    linega1anc.setVisibility(View.VISIBLE);
                    secga1ancWM.setVisibility(View.VISIBLE);
                    linega1ancWM.setVisibility(View.VISIBLE);
                    secantcarenum.setVisibility(View.VISIBLE);
                    lineantcarenum.setVisibility(View.VISIBLE);
                    secga.setVisibility(View.VISIBLE);
                    linega.setVisibility(View.VISIBLE);
                    secgaWM.setVisibility(View.VISIBLE);
                    linegaWM.setVisibility(View.VISIBLE);
                    seclblsec14.setVisibility(View.VISIBLE);
                    linelblsec14.setVisibility(View.VISIBLE);
                    secbheart.setVisibility(View.VISIBLE);
                    linebheart.setVisibility(View.VISIBLE);
                    secbcondition.setVisibility(View.VISIBLE);
                    linebcondition.setVisibility(View.VISIBLE);
                    secplacedeliv.setVisibility(View.VISIBLE);
                    lineplacedeliv.setVisibility(View.VISIBLE);
                    secplacedelivOth.setVisibility(View.VISIBLE);
                    lineplacedelivOth.setVisibility(View.VISIBLE);
                    secdelivdate.setVisibility(View.VISIBLE);
                    linedelivdate.setVisibility(View.VISIBLE);
                    secdelivdateDK.setVisibility(View.VISIBLE);
                    linedelivdateDK.setVisibility(View.VISIBLE);
                    secdelivtime.setVisibility(View.VISIBLE);
                    linedelivtime.setVisibility(View.VISIBLE);
                    secdelivtimeDK.setVisibility(View.VISIBLE);
                    linedelivtimeDK.setVisibility(View.VISIBLE);
                    sectypebirth.setVisibility(View.VISIBLE);
                    linetypebirth.setVisibility(View.VISIBLE);
                    seclblsec18.setVisibility(View.VISIBLE);
                    linelblsec18.setVisibility(View.VISIBLE);
                    secTimecsec.setVisibility(View.VISIBLE);
                    lineTimecsec.setVisibility(View.VISIBLE);
                    secToldcsecreas.setVisibility(View.VISIBLE);
                    lineToldcsecreas.setVisibility(View.VISIBLE);
                    secCsecreas.setVisibility(View.VISIBLE);
                    lineCsecreas.setVisibility(View.VISIBLE);
                    secOthReason.setVisibility(View.VISIBLE);
                    lineOthReason.setVisibility(View.VISIBLE);
                    secBwgted.setVisibility(View.VISIBLE);
                    lineBwgted.setVisibility(View.VISIBLE);
                    secBwgt.setVisibility(View.VISIBLE);
                    lineBwgt.setVisibility(View.VISIBLE);
                    secBwgtDK.setVisibility(View.VISIBLE);
                    lineBwgtDK.setVisibility(View.VISIBLE);
                    secbwgtmeth.setVisibility(View.VISIBLE);
                    linebwgtmeth.setVisibility(View.VISIBLE);
                    secBsex.setVisibility(View.VISIBLE);
                    lineBsex.setVisibility(View.VISIBLE);
                    secperceivesize.setVisibility(View.VISIBLE);
                    lineperceivesize.setVisibility(View.VISIBLE);
                    secanybcomp.setVisibility(View.VISIBLE);
                    lineanybcomp.setVisibility(View.VISIBLE);
                    seclblsec15.setVisibility(View.VISIBLE);
                    linelblsec15.setVisibility(View.VISIBLE);
                    secbcompA.setVisibility(View.VISIBLE);
                    linebcompA.setVisibility(View.VISIBLE);
                    secbcompB.setVisibility(View.VISIBLE);
                    linebcompB.setVisibility(View.VISIBLE);
                    secbcompC.setVisibility(View.VISIBLE);
                    linebcompC.setVisibility(View.VISIBLE);
                    secbcompD.setVisibility(View.VISIBLE);
                    linebcompD.setVisibility(View.VISIBLE);
                    secbcompE.setVisibility(View.VISIBLE);
                    linebcompE.setVisibility(View.VISIBLE);
                    secbcompF.setVisibility(View.VISIBLE);
                    linebcompF.setVisibility(View.VISIBLE);
                    secbcompG.setVisibility(View.VISIBLE);
                    linebcompG.setVisibility(View.VISIBLE);
                    secbcompH.setVisibility(View.VISIBLE);
                    linebcompH.setVisibility(View.VISIBLE);
                    secbcompI.setVisibility(View.VISIBLE);
                    linebcompI.setVisibility(View.VISIBLE);
                    secbcompIOth.setVisibility(View.VISIBLE);
                    linebcompIOth.setVisibility(View.VISIBLE);
                    secbcompJ.setVisibility(View.VISIBLE);
                    linebcompJ.setVisibility(View.VISIBLE);
                    secnightsnum.setVisibility(View.VISIBLE);
                    linenightsnum.setVisibility(View.VISIBLE);
                    secnightsnumDK.setVisibility(View.VISIBLE);
                    linenightsnumDK.setVisibility(View.VISIBLE);
                    secbnotif.setVisibility(View.VISIBLE);
                    linebnotif.setVisibility(View.VISIBLE);
                    secbcert.setVisibility(View.VISIBLE);
                    linebcert.setVisibility(View.VISIBLE);
                    secbcertknow.setVisibility(View.VISIBLE);
                    linebcertknow.setVisibility(View.VISIBLE);
                    secbcerttime.setVisibility(View.VISIBLE);
                    linebcerttime.setVisibility(View.VISIBLE);
                    secbcerttimeWM.setVisibility(View.VISIBLE);
                    linebcerttimeWM.setVisibility(View.VISIBLE);
                    secanybcertcon.setVisibility(View.VISIBLE);
                    lineanybcertcon.setVisibility(View.VISIBLE);
                    secbcertcon.setVisibility(View.VISIBLE);
                    linebcertcon.setVisibility(View.VISIBLE);*/
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secConsentFollo=(LinearLayout)findViewById(R.id.secConsentFollo);
         lineConsentFollo=(View)findViewById(R.id.lineConsentFollo);
         VlblConsentFollo = (TextView) findViewById(R.id.VlblConsentFollo);
         rdogrpConsentFollo = (RadioGroup) findViewById(R.id.rdogrpConsentFollo);
         
         rdoConsentFollo1 = (RadioButton) findViewById(R.id.rdoConsentFollo1);
         rdoConsentFollo2 = (RadioButton) findViewById(R.id.rdoConsentFollo2);
         seclblsec11=(LinearLayout)findViewById(R.id.seclblsec11);
         linelblsec11=(View)findViewById(R.id.linelblsec11);
         secdoi=(LinearLayout)findViewById(R.id.secdoi);
         linedoi=(View)findViewById(R.id.linedoi);
         Vlbldoi=(TextView) findViewById(R.id.Vlbldoi);
         dtpdoi=(EditText) findViewById(R.id.dtpdoi);



          sectoi=(LinearLayout)findViewById(R.id.sectoi);
         linetoi=(View)findViewById(R.id.linetoi);
         Vlbltoi=(TextView) findViewById(R.id.Vlbltoi);
         txttoi=(EditText) findViewById(R.id.txttoi);

         seclang=(LinearLayout)findViewById(R.id.seclang);
         linelang=(View)findViewById(R.id.linelang);
         Vlbllang=(TextView) findViewById(R.id.Vlbllang);
         spnlang=(Spinner) findViewById(R.id.spnlang);
         List<String> listlang = new ArrayList<String>();
         
         listlang.add("");
         if(COUNTRYCODE.equals(ProjectSetting.BANGLADESH)){
             listlang.add("1-ইংরেজি");
             listlang.add("2-স্থানীয় ভাষা (বাংলা, সোয়াহিলি, নেপালি)");
             listlang.add("7-অন্যান্য");
         }else {
             listlang.add("1-English");
             listlang.add("2-Local language (Bangla, Swahili, Nepali)");
             listlang.add("3-Others");
         }

         ArrayAdapter<String> adptrlang= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listlang);
         spnlang.setAdapter(adptrlang);
         spnlang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                 if (spnlang.getSelectedItem().toString().length() == 0) return;
                 String spnData = Connection.SelectedSpinnerValue(spnlang.getSelectedItem().toString(),"-");
                 if(spnData.equalsIgnoreCase("7"))
                 {
                     seclangOth.setVisibility(View.VISIBLE);
                     secinterp.setVisibility(View.VISIBLE);
                 }
                 else
                 {
                     seclangOth.setVisibility(View.GONE);
                     txtlangOth.setText("");
                     secinterp.setVisibility(View.GONE);
                     rdogrpinterp.clearCheck();
                     secinterpName.setVisibility(View.GONE);
                     txtinterpName.setText("");
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });

         seccconditionb=(LinearLayout)findViewById(R.id.seccconditionb);
         linecconditionb=(View)findViewById(R.id.linecconditionb);
         Vlblcconditionb=(TextView) findViewById(R.id.Vlblcconditionb);
         spncconditionb=(Spinner) findViewById(R.id.spncconditionb);
         List<String> listcconditionb = new ArrayList<String>();
         
         listcconditionb.add("");
         if(COUNTRYCODE.equals(ProjectSetting.BANGLADESH)){
             listcconditionb.add("1-জীবিত");
             listcconditionb.add("2-সদ্য মৃতজন্ম (ফ্রেস)");
             listcconditionb.add("3-পচে বা গলে যাওয়া মৃতজন্ম (ম্যাসেরেটেড)");
             listcconditionb.add("4-মৃতজন্মঃ অবস্থা অনির্ধারিত");
             listcconditionb.add("5-নবজাতকের মৃত্যু");
         }else if(COUNTRYCODE.equals(ProjectSetting.NEPAL)){
             listcconditionb.add("1-जीवितबच्चा");
             listcconditionb.add("2-फ्रेस मृतजन्म");
             listcconditionb.add("3-म्यासीरेटेड मृतजन्म");
             listcconditionb.add("4-Baby dead: stillbirth: condition unknown");
             listcconditionb.add("5-नवजात शिशुकोमृत्यु");
         }else if(COUNTRYCODE.equals(ProjectSetting.TANZANIA)){
             listcconditionb.add("1-Mtoto hai");
             listcconditionb.add("2-Mtoto amefariki – fresh stillbirth");
             listcconditionb.add("3-Mtoto amefariki – macerated stillbirth");
             listcconditionb.add("4-Baby dead: stillbirth: condition unknown");
             listcconditionb.add("5-Mtoto amefariki – kifo cha mtoto mchanga");
         }else {
             listcconditionb.add("1-Baby alive");
             listcconditionb.add("2-Baby dead: fresh stillbirth");
             listcconditionb.add("3-Baby dead: macerated stillbirth");
             listcconditionb.add("4-Baby dead: neonatal death");
         }
         ArrayAdapter<String> adptrcconditionb= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listcconditionb);
         spncconditionb.setAdapter(adptrcconditionb);

         seclblsec12=(LinearLayout)findViewById(R.id.seclblsec12);
         seclblsec121=(LinearLayout)findViewById(R.id.seclblsec121);
         linelblsec12=(View)findViewById(R.id.linelblsec12);
         secmatconsent=(LinearLayout)findViewById(R.id.secmatconsent);
         linematconsent=(View)findViewById(R.id.linematconsent);
         Vlblmatconsent = (TextView) findViewById(R.id.Vlblmatconsent);
         rdogrpmatconsent = (RadioGroup) findViewById(R.id.rdogrpmatconsent);
         
         rdomatconsent1 = (RadioButton) findViewById(R.id.rdomatconsent1);
         rdomatconsent2 = (RadioButton) findViewById(R.id.rdomatconsent2);
         rdogrpmatconsent.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpmatconsent = new String[] {"1","2"};
             for (int i = 0; i < rdogrpmatconsent.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpmatconsent.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpmatconsent[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secMatbdateM.setVisibility(View.GONE);
                  secMatbdateM1.setVisibility(View.GONE);
                    lineMatbdateM.setVisibility(View.GONE);
                    spnMatbdateM.setSelection(0);
                    secMatbdateY.setVisibility(View.GONE);
                    lineMatbdateY.setVisibility(View.GONE);
                    txtMatbdateY.setText("");
                    secMatbdateDK.setVisibility(View.GONE);
                    lineMatbdateDK.setVisibility(View.GONE);
                    chkMatbdateDK.setChecked(false);
                    secMatage.setVisibility(View.GONE);
                    lineMatage.setVisibility(View.GONE);
                    txtMatage.setText("");
                    seclblsec16.setVisibility(View.GONE);
                    linelblsec16.setVisibility(View.GONE);
                    secMatageDK.setVisibility(View.GONE);
                    lineMatageDK.setVisibility(View.GONE);
                    chkMatageDK.setChecked(false);
                 secFormEdu.setVisibility(View.GONE);
                 txtFormEdu.setText("");
                 secFormEduDK.setVisibility(View.GONE);
                 chkFormEduDK.setChecked(false);

                 secaddr1.setVisibility(View.GONE);
                    lineaddr1.setVisibility(View.GONE);
                    spnaddr1.setSelection(0);
                    secaddr2.setVisibility(View.GONE);
                    lineaddr2.setVisibility(View.GONE);
                    txtaddr2.setText("");
                    secaddr3.setVisibility(View.GONE);
                    lineaddr3.setVisibility(View.GONE);
                    txtaddr3.setText("");
                    secaddr4.setVisibility(View.GONE);
                    lineaddr4.setVisibility(View.GONE);
                    txtaddr4.setText("");
                    secAddressDetail.setVisibility(View.GONE);
                    lineAddressDetail.setVisibility(View.GONE);
                    txtAddressDetail.setText("");
                    secmatmobile.setVisibility(View.GONE);
                    linematmobile.setVisibility(View.GONE);
                    rdogrpmatmobile.clearCheck();
                    secMatmobnum.setVisibility(View.GONE);
                    lineMatmobnum.setVisibility(View.GONE);
                    txtMatmobnum.setText("");
                    secMatmobnumDK.setVisibility(View.GONE);
                    lineMatmobnumDK.setVisibility(View.GONE);
                    chkMatmobnumDK.setChecked(false);
                    secMatmobnum1.setVisibility(View.GONE);
                    lineMatmobnum1.setVisibility(View.GONE);
                    txtMatmobnum1.setText("");
                    secMatmobnum1DK.setVisibility(View.GONE);
                    lineMatmobnum1DK.setVisibility(View.GONE);
                    chkMatmobnum1DK.setChecked(false);
                    sechusmob.setVisibility(View.GONE);
                    linehusmob.setVisibility(View.GONE);
                    rdogrphusmob.clearCheck();
                    secHusmobnum.setVisibility(View.GONE);
                    lineHusmobnum.setVisibility(View.GONE);
                    txtHusmobnum.setText("");
                    secHusmobnumDK.setVisibility(View.GONE);
                    lineHusmobnumDK.setVisibility(View.GONE);
                    chkHusmobnumDK.setChecked(false);
                    secHusmobnum2.setVisibility(View.GONE);
                    lineHusmobnum2.setVisibility(View.GONE);
                    txtHusmobnum2.setText("");
                    secHusmobnum2DK.setVisibility(View.GONE);
                    lineHusmobnum2DK.setVisibility(View.GONE);
                    chkHusmobnum2DK.setChecked(false);
                    seccontact1.setVisibility(View.GONE);
                    linecontact1.setVisibility(View.GONE);
                    txtcontact1.setText("");
                    seclblsec13.setVisibility(View.GONE);
                    linelblsec13.setVisibility(View.GONE);
                    seceddknown.setVisibility(View.GONE);
                    lineeddknown.setVisibility(View.GONE);
                    rdogrpeddknown.clearCheck();
                    secEdd.setVisibility(View.GONE);
                    lineEdd.setVisibility(View.GONE);
                    dtpEdd.setText("");
                    secEddDK.setVisibility(View.GONE);
                    lineEddDK.setVisibility(View.GONE);
                    //chkEddDK.setChecked(false);
                    seclblsec17.setVisibility(View.GONE);
                    linelblsec17.setVisibility(View.GONE);
                    secGameth.setVisibility(View.GONE);
                  secGametha.setVisibility(View.GONE);
                  chkGametha.setChecked(false);
                  secGamethb.setVisibility(View.GONE);
                  chkGamethb.setChecked(false);
                  secGamethc.setVisibility(View.GONE);
                  chkGamethc.setChecked(false);
                  secGamethd.setVisibility(View.GONE);
                  chkGamethd.setChecked(false);
                  secGamethe.setVisibility(View.GONE);
                  chkGamethe.setChecked(false);
                  txtGametheOth.setText("");
                  secGamethf.setVisibility(View.GONE);
                  chkGamethf.setChecked(false);
                    //lineGameth.setVisibility(View.GONE);
                    //spnGameth.setSelection(0);
                    //secGamethOth.setVisibility(View.GONE);
                    //lineGamethOth.setVisibility(View.GONE);
                    //txtGamethOth.setText("");
                    secga1anc.setVisibility(View.GONE);
                    linega1anc.setVisibility(View.GONE);
                    txtga1anc.setText("");
                    secga1ancWM.setVisibility(View.GONE);
                    linega1ancWM.setVisibility(View.GONE);
                    rdogrpga1ancWM.clearCheck();
                    secantcarenum.setVisibility(View.GONE);
                    lineantcarenum.setVisibility(View.GONE);
                    spnantcarenum.setSelection(0);
                    secga.setVisibility(View.GONE);
                    linega.setVisibility(View.GONE);
                    txtga.setText("");
                    secgaWM.setVisibility(View.GONE);
                    linegaWM.setVisibility(View.GONE);
                    rdogrpgaWM.clearCheck();
                    seclblsec14.setVisibility(View.GONE);
                    linelblsec14.setVisibility(View.GONE);
                    secbheart.setVisibility(View.GONE);
                    linebheart.setVisibility(View.GONE);
                    rdogrpbheart.clearCheck();
                    secbcondition.setVisibility(View.GONE);
                    linebcondition.setVisibility(View.GONE);
                    //spnbcondition.setSelection(0);
                 rdogrpbcondition.clearCheck();
                    secplacedeliv.setVisibility(View.GONE);
                    lineplacedeliv.setVisibility(View.GONE);
                    rdogrpplacedeliv.clearCheck();
                    secplacedelivOth.setVisibility(View.GONE);
                    lineplacedelivOth.setVisibility(View.GONE);
                    txtplacedelivOth.setText("");
                    secdelivdate.setVisibility(View.GONE);
                    linedelivdate.setVisibility(View.GONE);
                    dtpdelivdate.setText("");
                    secdelivdateDK.setVisibility(View.GONE);
                    linedelivdateDK.setVisibility(View.GONE);
                    chkdelivdateDK.setChecked(false);
                    secdelivtime.setVisibility(View.GONE);
                    linedelivtime.setVisibility(View.GONE);
                    txtdelivtime.setText("");
                    secdelivtimeDK.setVisibility(View.GONE);
                    linedelivtimeDK.setVisibility(View.GONE);
                    chkdelivtimeDK.setChecked(false);
                    sectypebirth.setVisibility(View.GONE);
                    linetypebirth.setVisibility(View.GONE);
                    spntypebirth.setSelection(0);
                    seclblsec18.setVisibility(View.GONE);
                    linelblsec18.setVisibility(View.GONE);
                    secTimecsec.setVisibility(View.GONE);
                    lineTimecsec.setVisibility(View.GONE);
                    spnTimecsec.setSelection(0);
                    secToldcsecreas.setVisibility(View.GONE);
                    lineToldcsecreas.setVisibility(View.GONE);
                    rdogrpToldcsecreas.clearCheck();
                    secCsecreas.setVisibility(View.GONE);
                    lineCsecreas.setVisibility(View.GONE);
                    spnCsecreas.setSelection(0);
                    secOthReason.setVisibility(View.GONE);
                    lineOthReason.setVisibility(View.GONE);
                    txtOthReason.setText("");
                    secBwgted.setVisibility(View.GONE);
                    lineBwgted.setVisibility(View.GONE);
                    rdogrpBwgted.clearCheck();
                    secBwgt.setVisibility(View.GONE);
                    lineBwgt.setVisibility(View.GONE);
                    txtBwgt.setText("");
                    secBwgtDK.setVisibility(View.GONE);
                    lineBwgtDK.setVisibility(View.GONE);
                    rdogrpBwgtDK.clearCheck();
                    secbwgtmeth.setVisibility(View.GONE);
                    linebwgtmeth.setVisibility(View.GONE);
                    rdogrpbwgtmeth.clearCheck();
                    secBsex.setVisibility(View.GONE);
                    lineBsex.setVisibility(View.GONE);
                    spnBsex.setSelection(0);
                    secperceivesize.setVisibility(View.GONE);
                    lineperceivesize.setVisibility(View.GONE);
                    spnperceivesize.setSelection(0);
                    secanybcomp.setVisibility(View.GONE);
                    lineanybcomp.setVisibility(View.GONE);
                    rdogrpanybcomp.clearCheck();
                    seclblsec15.setVisibility(View.GONE);
                    linelblsec15.setVisibility(View.GONE);
                    secbcompA.setVisibility(View.GONE);
                    linebcompA.setVisibility(View.GONE);
                    chkbcompA.setChecked(false);
                    secbcompB.setVisibility(View.GONE);
                    linebcompB.setVisibility(View.GONE);
                    chkbcompB.setChecked(false);
                    secbcompC.setVisibility(View.GONE);
                    linebcompC.setVisibility(View.GONE);
                    chkbcompC.setChecked(false);
                    secbcompD.setVisibility(View.GONE);
                    linebcompD.setVisibility(View.GONE);
                    chkbcompD.setChecked(false);
                    secbcompE.setVisibility(View.GONE);
                    linebcompE.setVisibility(View.GONE);
                    chkbcompE.setChecked(false);
                    secbcompF.setVisibility(View.GONE);
                    linebcompF.setVisibility(View.GONE);
                    chkbcompF.setChecked(false);
                    secbcompG.setVisibility(View.GONE);
                    linebcompG.setVisibility(View.GONE);
                    chkbcompG.setChecked(false);
                    secbcompH.setVisibility(View.GONE);
                    linebcompH.setVisibility(View.GONE);
                    chkbcompH.setChecked(false);
                    secbcompI.setVisibility(View.GONE);
                    linebcompI.setVisibility(View.GONE);
                    chkbcompI.setChecked(false);
                    secbcompIOth.setVisibility(View.GONE);
                    linebcompIOth.setVisibility(View.GONE);
                    txtbcompIOth.setText("");
                    secbcompJ.setVisibility(View.GONE);
                    linebcompJ.setVisibility(View.GONE);
                    chkbcompJ.setChecked(false);
                    secnightsnum.setVisibility(View.GONE);
                    linenightsnum.setVisibility(View.GONE);
                    txtnightsnum.setText("");
                    secnightsnumDK.setVisibility(View.GONE);
                    linenightsnumDK.setVisibility(View.GONE);
                    chknightsnumDK.setChecked(false);
                    secbnotif.setVisibility(View.GONE);
                    linebnotif.setVisibility(View.GONE);
                    rdogrpbnotif.clearCheck();
                    secbcert.setVisibility(View.GONE);
                    linebcert.setVisibility(View.GONE);
                    rdogrpbcert.clearCheck();
                    secbcertknow.setVisibility(View.GONE);
                    linebcertknow.setVisibility(View.GONE);
                    rdogrpbcertknow.clearCheck();
                    secbcerttime.setVisibility(View.GONE);
                    linebcerttime.setVisibility(View.GONE);
                    txtbcerttime.setText("");
                    secbcerttimeWM.setVisibility(View.GONE);
                    linebcerttimeWM.setVisibility(View.GONE);
                    rdogrpbcerttimeWM.clearCheck();
                    secanybcertcon.setVisibility(View.GONE);
                    lineanybcertcon.setVisibility(View.GONE);
                 //   spnanybcertcon.setSelection(0);
                 rdogrpanybcertcon.clearCheck();
                    secbcertcon.setVisibility(View.GONE);
                    linebcertcon.setVisibility(View.GONE);
                    //spnbcertcon.setSelection(0);
                 chkbcertcona.setChecked(false);
                 chkbcertconb.setChecked(false);
                 chkbcertconc.setChecked(false);
                 chkbcertcond.setChecked(false);
                 chkbcertcone.setChecked(false);
                    secbcertconOth.setVisibility(View.GONE);
                    linebcertconOth.setVisibility(View.GONE);
                    txtbcertconOth.setText("");
             }
             else
             {
                    secMatbdateM.setVisibility(View.VISIBLE);
                  secMatbdateM1.setVisibility(View.VISIBLE);
                    lineMatbdateM.setVisibility(View.VISIBLE);
                    secMatbdateY.setVisibility(View.VISIBLE);
                    lineMatbdateY.setVisibility(View.VISIBLE);
                    secMatbdateDK.setVisibility(View.VISIBLE);
                    lineMatbdateDK.setVisibility(View.VISIBLE);
                    secMatage.setVisibility(View.VISIBLE);
                    lineMatage.setVisibility(View.VISIBLE);
                    //seclblsec16.setVisibility(View.VISIBLE);
                    linelblsec16.setVisibility(View.VISIBLE);
                    secMatageDK.setVisibility(View.VISIBLE);
                 secFormEdu.setVisibility(View.VISIBLE);
                 secFormEduDK.setVisibility(View.VISIBLE);

                    lineMatageDK.setVisibility(View.VISIBLE);
                    secaddr1.setVisibility(View.VISIBLE);
                    lineaddr1.setVisibility(View.VISIBLE);
                    secaddr2.setVisibility(View.VISIBLE);
                    lineaddr2.setVisibility(View.VISIBLE);
                    secaddr3.setVisibility(View.VISIBLE);
                    lineaddr3.setVisibility(View.VISIBLE);
                     if(!COUNTRYCODE.equals(ProjectSetting.TANZANIA)) {
                         secaddr4.setVisibility(View.VISIBLE);
                         lineaddr4.setVisibility(View.VISIBLE);
                     }
                    secAddressDetail.setVisibility(View.VISIBLE);
                    lineAddressDetail.setVisibility(View.VISIBLE);
                    secmatmobile.setVisibility(View.VISIBLE);
                    linematmobile.setVisibility(View.VISIBLE);
                    secMatmobnum.setVisibility(View.VISIBLE);
                    lineMatmobnum.setVisibility(View.VISIBLE);
                    secMatmobnumDK.setVisibility(View.VISIBLE);
                    lineMatmobnumDK.setVisibility(View.VISIBLE);
                    //secMatmobnum1.setVisibility(View.VISIBLE);
                    lineMatmobnum1.setVisibility(View.VISIBLE);
                    //secMatmobnum1DK.setVisibility(View.VISIBLE);
                    lineMatmobnum1DK.setVisibility(View.VISIBLE);
                    sechusmob.setVisibility(View.VISIBLE);
                    linehusmob.setVisibility(View.VISIBLE);
                    secHusmobnum.setVisibility(View.VISIBLE);
                    lineHusmobnum.setVisibility(View.VISIBLE);
                    secHusmobnumDK.setVisibility(View.VISIBLE);
                    lineHusmobnumDK.setVisibility(View.VISIBLE);
                    //secHusmobnum2.setVisibility(View.VISIBLE);
                    lineHusmobnum2.setVisibility(View.VISIBLE);
                    //secHusmobnum2DK.setVisibility(View.VISIBLE);
                    lineHusmobnum2DK.setVisibility(View.VISIBLE);
                    seccontact1.setVisibility(View.VISIBLE);
                    linecontact1.setVisibility(View.VISIBLE);
                    seclblsec13.setVisibility(View.VISIBLE);
                    linelblsec13.setVisibility(View.VISIBLE);
                    seceddknown.setVisibility(View.VISIBLE);
                    lineeddknown.setVisibility(View.VISIBLE);
                    secEdd.setVisibility(View.VISIBLE);
                    lineEdd.setVisibility(View.VISIBLE);
                    secEddDK.setVisibility(View.VISIBLE);
                 //secEddDKOth.setVisibility(View.VISIBLE);
                    lineEddDK.setVisibility(View.VISIBLE);
                    //seclblsec17.setVisibility(View.VISIBLE);
                    linelblsec17.setVisibility(View.VISIBLE);
                    secGameth.setVisibility(View.VISIBLE);
                  secGametha.setVisibility(View.VISIBLE);
                  secGamethb.setVisibility(View.VISIBLE);
                  secGamethc.setVisibility(View.VISIBLE);
                  secGamethd.setVisibility(View.VISIBLE);
                  secGamethe.setVisibility(View.VISIBLE);
                  secGamethf.setVisibility(View.VISIBLE);
                    //lineGameth.setVisibility(View.VISIBLE);
                    //secGamethOth.setVisibility(View.VISIBLE);
                    //lineGamethOth.setVisibility(View.VISIBLE);
                    secga1anc.setVisibility(View.VISIBLE);
                    linega1anc.setVisibility(View.VISIBLE);
                    secga1ancWM.setVisibility(View.VISIBLE);
                    linega1ancWM.setVisibility(View.VISIBLE);
                    secantcarenum.setVisibility(View.VISIBLE);
                    lineantcarenum.setVisibility(View.VISIBLE);
                    secga.setVisibility(View.VISIBLE);
                    linega.setVisibility(View.VISIBLE);
                    secgaWM.setVisibility(View.VISIBLE);
                    linegaWM.setVisibility(View.VISIBLE);
                    seclblsec14.setVisibility(View.VISIBLE);
                    linelblsec14.setVisibility(View.VISIBLE);
                    secbheart.setVisibility(View.VISIBLE);
                    linebheart.setVisibility(View.VISIBLE);
                    secbcondition.setVisibility(View.VISIBLE);
                    linebcondition.setVisibility(View.VISIBLE);
                    secplacedeliv.setVisibility(View.VISIBLE);
                    lineplacedeliv.setVisibility(View.VISIBLE);
                    //secplacedelivOth.setVisibility(View.VISIBLE);
                    lineplacedelivOth.setVisibility(View.VISIBLE);
                    secdelivdate.setVisibility(View.VISIBLE);
                    linedelivdate.setVisibility(View.VISIBLE);
                    secdelivdateDK.setVisibility(View.VISIBLE);
                    linedelivdateDK.setVisibility(View.VISIBLE);
                    secdelivtime.setVisibility(View.VISIBLE);
                    linedelivtime.setVisibility(View.VISIBLE);
                    secdelivtimeDK.setVisibility(View.VISIBLE);
                    linedelivtimeDK.setVisibility(View.VISIBLE);
                    sectypebirth.setVisibility(View.VISIBLE);
                    linetypebirth.setVisibility(View.VISIBLE);
                    //seclblsec18.setVisibility(View.VISIBLE);
                    linelblsec18.setVisibility(View.VISIBLE);
                    secTimecsec.setVisibility(View.VISIBLE);
                    lineTimecsec.setVisibility(View.VISIBLE);
                    secToldcsecreas.setVisibility(View.VISIBLE);
                    lineToldcsecreas.setVisibility(View.VISIBLE);
                    secCsecreas.setVisibility(View.VISIBLE);
                    lineCsecreas.setVisibility(View.VISIBLE);
                    //secOthReason.setVisibility(View.VISIBLE);
                    lineOthReason.setVisibility(View.VISIBLE);
                    secBwgted.setVisibility(View.VISIBLE);
                    lineBwgted.setVisibility(View.VISIBLE);
                    secBwgt.setVisibility(View.VISIBLE);
                    lineBwgt.setVisibility(View.VISIBLE);
                    secBwgtDK.setVisibility(View.VISIBLE);
                    lineBwgtDK.setVisibility(View.VISIBLE);
                    secbwgtmeth.setVisibility(View.VISIBLE);
                    linebwgtmeth.setVisibility(View.VISIBLE);
                    secBsex.setVisibility(View.VISIBLE);
                    lineBsex.setVisibility(View.VISIBLE);
                    secperceivesize.setVisibility(View.VISIBLE);
                    lineperceivesize.setVisibility(View.VISIBLE);
                    secanybcomp.setVisibility(View.VISIBLE);
                    lineanybcomp.setVisibility(View.VISIBLE);
                    seclblsec15.setVisibility(View.VISIBLE);
                    linelblsec15.setVisibility(View.VISIBLE);
                    secbcompA.setVisibility(View.VISIBLE);
                    linebcompA.setVisibility(View.VISIBLE);
                    secbcompB.setVisibility(View.VISIBLE);
                    linebcompB.setVisibility(View.VISIBLE);
                    secbcompC.setVisibility(View.VISIBLE);
                    linebcompC.setVisibility(View.VISIBLE);
                    secbcompD.setVisibility(View.VISIBLE);
                    linebcompD.setVisibility(View.VISIBLE);
                    secbcompE.setVisibility(View.VISIBLE);
                    linebcompE.setVisibility(View.VISIBLE);
                    secbcompF.setVisibility(View.VISIBLE);
                    linebcompF.setVisibility(View.VISIBLE);
                    secbcompG.setVisibility(View.VISIBLE);
                    linebcompG.setVisibility(View.VISIBLE);
                    secbcompH.setVisibility(View.VISIBLE);
                    linebcompH.setVisibility(View.VISIBLE);
                    secbcompI.setVisibility(View.VISIBLE);
                    linebcompI.setVisibility(View.VISIBLE);
                    //secbcompIOth.setVisibility(View.VISIBLE);
                    linebcompIOth.setVisibility(View.VISIBLE);
                    secbcompJ.setVisibility(View.VISIBLE);
                    linebcompJ.setVisibility(View.VISIBLE);
                    secnightsnum.setVisibility(View.VISIBLE);
                    linenightsnum.setVisibility(View.VISIBLE);
                    secnightsnumDK.setVisibility(View.VISIBLE);
                    linenightsnumDK.setVisibility(View.VISIBLE);
                    secbnotif.setVisibility(View.VISIBLE);
                    linebnotif.setVisibility(View.VISIBLE);
                    secbcert.setVisibility(View.VISIBLE);
                    linebcert.setVisibility(View.VISIBLE);
                    secbcertknow.setVisibility(View.VISIBLE);
                    linebcertknow.setVisibility(View.VISIBLE);
                    secbcerttime.setVisibility(View.VISIBLE);
                    linebcerttime.setVisibility(View.VISIBLE);
                    secbcerttimeWM.setVisibility(View.VISIBLE);
                    linebcerttimeWM.setVisibility(View.VISIBLE);
                    secanybcertcon.setVisibility(View.VISIBLE);
                    lineanybcertcon.setVisibility(View.VISIBLE);
                    //secbcertcon.setVisibility(View.VISIBLE);
                    linebcertcon.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secMatbdateM=(LinearLayout)findViewById(R.id.secMatbdateM);
          secMatbdateM1=(LinearLayout)findViewById(R.id.secMatbdateM1);
         lineMatbdateM=(View)findViewById(R.id.lineMatbdateM);
         VlblMatbdateM=(TextView) findViewById(R.id.VlblMatbdateM);
         spnMatbdateM=(Spinner) findViewById(R.id.spnMatbdateM);
         List<String> listMatbdateM = new ArrayList<String>();
         
         listMatbdateM.add("");
         if(COUNTRYCODE.equals(ProjectSetting.BANGLADESH)){
             listMatbdateM.add("01-জানুয়ারী");
             listMatbdateM.add("02-ফেব্রুয়ারী");
             listMatbdateM.add("03-মার্চ");
             listMatbdateM.add("04-এপ্রিল");
             listMatbdateM.add("05-মে");
             listMatbdateM.add("06-জুন");
             listMatbdateM.add("07-জুলাই");
             listMatbdateM.add("08-আগস্ট");
             listMatbdateM.add("09-সেপ্টেম্বর");
             listMatbdateM.add("10-অক্টোবর");
             listMatbdateM.add("11-নভেম্বর");
             listMatbdateM.add("12-ডিসেম্বর");
             listMatbdateM.add("99-জানিনা");
         }else {
             listMatbdateM.add("01-January");
             listMatbdateM.add("02-February");
             listMatbdateM.add("03-March");
             listMatbdateM.add("04-April");
             listMatbdateM.add("05-May");
             listMatbdateM.add("06-June");
             listMatbdateM.add("07-July");
             listMatbdateM.add("08-August");
             listMatbdateM.add("09-September");
             listMatbdateM.add("10-October");
             listMatbdateM.add("11-November");
             listMatbdateM.add("12-December");
             listMatbdateM.add("98-Don't know");
         }
         ArrayAdapter<String> adptrMatbdateM= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listMatbdateM);
         spnMatbdateM.setAdapter(adptrMatbdateM);

         secMatbdateY=(LinearLayout)findViewById(R.id.secMatbdateY);
         lineMatbdateY=(View)findViewById(R.id.lineMatbdateY);
         VlblMatbdateY=(TextView) findViewById(R.id.VlblMatbdateY);
         txtMatbdateY=(EditText) findViewById(R.id.txtMatbdateY);
         secMatbdateDK=(LinearLayout)findViewById(R.id.secMatbdateDK);
         lineMatbdateDK=(View)findViewById(R.id.lineMatbdateDK);
         VlblMatbdateDK=(TextView) findViewById(R.id.VlblMatbdateDK);
         chkMatbdateDK=(CheckBox) findViewById(R.id.chkMatbdateDK);
         secMatage=(LinearLayout)findViewById(R.id.secMatage);
         lineMatage=(View)findViewById(R.id.lineMatage);
         VlblMatage=(TextView) findViewById(R.id.VlblMatage);
         txtMatage=(EditText) findViewById(R.id.txtMatage);
         seclblsec16=(LinearLayout)findViewById(R.id.seclblsec16);
         linelblsec16=(View)findViewById(R.id.linelblsec16);
         secMatageDK=(LinearLayout)findViewById(R.id.secMatageDK);
         lineMatageDK=(View)findViewById(R.id.lineMatageDK);
         VlblMatageDK=(TextView) findViewById(R.id.VlblMatageDK);
         chkMatageDK=(CheckBox) findViewById(R.id.chkMatageDK);
         secaddr1=(LinearLayout)findViewById(R.id.secaddr1);
         lineaddr1=(View)findViewById(R.id.lineaddr1);
         Vlbladdr1=(TextView) findViewById(R.id.Vlbladdr1);
         spnaddr1=(Spinner) findViewById(R.id.spnaddr1);
         spnaddr1.setAdapter(C.getArrayAdapter("Select '' union Select distinct District||'-'||DistName from AreaDB where CCode='"+ COUNTRYCODE +"'"));

         /*List<String> listaddr1 = new ArrayList<String>();
         
         listaddr1.add("");
         listaddr1.add("01- Level 1");
         ArrayAdapter<String> adptraddr1= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listaddr1);
         spnaddr1.setAdapter(adptraddr1);*/

         secaddr2=(LinearLayout)findViewById(R.id.secaddr2);
         lineaddr2=(View)findViewById(R.id.lineaddr2);
         Vlbladdr2=(TextView) findViewById(R.id.Vlbladdr2);
         txtaddr2=(AutoCompleteTextView) findViewById(R.id.txtaddr2);
         txtaddr2.setAdapter(C.getArrayAdapter("Select distinct UpName Address2 from AreaDB union Select distinct Address2 from Registration order by Address2"));
         txtaddr2.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (txtaddr2.getRight() - txtaddr2.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         ((EditText)v).setText("");
                         txtaddr2.setText("");
                         return true;
                     }
                 }
                 return false;
             }
         });

         secaddr3=(LinearLayout)findViewById(R.id.secaddr3);
         lineaddr3=(View)findViewById(R.id.lineaddr3);
         Vlbladdr3=(TextView) findViewById(R.id.Vlbladdr3);
         txtaddr3=(AutoCompleteTextView) findViewById(R.id.txtaddr3);
         txtaddr3.setAdapter(C.getArrayAdapter("Select distinct UnName Address3 from AreaDB union Select distinct Address3 from Registration order by Address3"));
         txtaddr3.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (txtaddr3.getRight() - txtaddr3.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         ((EditText)v).setText("");
                         txtaddr3.setText("");
                         return true;
                     }
                 }
                 return false;
             }
         });


         if(COUNTRYCODE.equals(ProjectSetting.NEPAL)){
             txtaddr3.setInputType(InputType.TYPE_CLASS_NUMBER);
         }

         secaddr4=(LinearLayout)findViewById(R.id.secaddr4);
         lineaddr4=(View)findViewById(R.id.lineaddr4);
         Vlbladdr4=(TextView) findViewById(R.id.Vlbladdr4);
         txtaddr4=(AutoCompleteTextView) findViewById(R.id.txtaddr4);
         txtaddr4.setAdapter(C.getArrayAdapter("Select distinct VillName Address4 from AreaDB union Select distinct Address4 from Registration order by Address4"));
         txtaddr4.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (txtaddr4.getRight() - txtaddr4.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         ((EditText)v).setText("");
                         txtaddr4.setText("");
                         return true;
                     }
                 }
                 return false;
             }
         });

         secAddressDetail=(LinearLayout)findViewById(R.id.secAddressDetail);
         lineAddressDetail=(View)findViewById(R.id.lineAddressDetail);
         VlblAddressDetail=(TextView) findViewById(R.id.VlblAddressDetail);
         txtAddressDetail=(EditText) findViewById(R.id.txtAddressDetail);
         secmatmobile=(LinearLayout)findViewById(R.id.secmatmobile);
         linematmobile=(View)findViewById(R.id.linematmobile);
         Vlblmatmobile = (TextView) findViewById(R.id.Vlblmatmobile);
         rdogrpmatmobile = (RadioGroup) findViewById(R.id.rdogrpmatmobile);
         
         rdomatmobile1 = (RadioButton) findViewById(R.id.rdomatmobile1);
         rdomatmobile2 = (RadioButton) findViewById(R.id.rdomatmobile2);
         rdogrpmatmobile.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpmatmobile = new String[] {"1","2"};
             for (int i = 0; i < rdogrpmatmobile.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpmatmobile.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpmatmobile[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secMatmobnum.setVisibility(View.GONE);
                    lineMatmobnum.setVisibility(View.GONE);
                    txtMatmobnum.setText("");
                    secMatmobnumDK.setVisibility(View.GONE);
                    lineMatmobnumDK.setVisibility(View.GONE);
                    chkMatmobnumDK.setChecked(false);
                    secMatmobnum1.setVisibility(View.GONE);
                    lineMatmobnum1.setVisibility(View.GONE);
                    txtMatmobnum1.setText("");
                    secMatmobnum1DK.setVisibility(View.GONE);
                    lineMatmobnum1DK.setVisibility(View.GONE);
                    chkMatmobnum1DK.setChecked(false);
             }
             else
             {
                    secMatmobnum.setVisibility(View.VISIBLE);
                    lineMatmobnum.setVisibility(View.VISIBLE);
                    secMatmobnumDK.setVisibility(View.VISIBLE);
                    lineMatmobnumDK.setVisibility(View.VISIBLE);
                    //secMatmobnum1.setVisibility(View.VISIBLE);
                    lineMatmobnum1.setVisibility(View.VISIBLE);
                    //secMatmobnum1DK.setVisibility(View.VISIBLE);
                    lineMatmobnum1DK.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secMatmobnum=(LinearLayout)findViewById(R.id.secMatmobnum);
         lineMatmobnum=(View)findViewById(R.id.lineMatmobnum);
         VlblMatmobnum=(TextView) findViewById(R.id.VlblMatmobnum);
         txtMatmobnum=(EditText) findViewById(R.id.txtMatmobnum);
         secMatmobnumDK=(LinearLayout)findViewById(R.id.secMatmobnumDK);
         lineMatmobnumDK=(View)findViewById(R.id.lineMatmobnumDK);
         VlblMatmobnumDK=(TextView) findViewById(R.id.VlblMatmobnumDK);
         chkMatmobnumDK=(CheckBox) findViewById(R.id.chkMatmobnumDK);
         secMatmobnum1=(LinearLayout)findViewById(R.id.secMatmobnum1);
         lineMatmobnum1=(View)findViewById(R.id.lineMatmobnum1);
         VlblMatmobnum1=(TextView) findViewById(R.id.VlblMatmobnum1);
         txtMatmobnum1=(EditText) findViewById(R.id.txtMatmobnum1);
         secMatmobnum1DK=(LinearLayout)findViewById(R.id.secMatmobnum1DK);
         lineMatmobnum1DK=(View)findViewById(R.id.lineMatmobnum1DK);
         VlblMatmobnum1DK=(TextView) findViewById(R.id.VlblMatmobnum1DK);
         chkMatmobnum1DK=(CheckBox) findViewById(R.id.chkMatmobnum1DK);
         sechusmob=(LinearLayout)findViewById(R.id.sechusmob);
         linehusmob=(View)findViewById(R.id.linehusmob);
         Vlblhusmob = (TextView) findViewById(R.id.Vlblhusmob);
         rdogrphusmob = (RadioGroup) findViewById(R.id.rdogrphusmob);
         
         rdohusmob1 = (RadioButton) findViewById(R.id.rdohusmob1);
         rdohusmob2 = (RadioButton) findViewById(R.id.rdohusmob2);
         rdogrphusmob.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrphusmob = new String[] {"1","2"};
             for (int i = 0; i < rdogrphusmob.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrphusmob.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrphusmob[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secHusmobnum.setVisibility(View.GONE);
                    lineHusmobnum.setVisibility(View.GONE);
                    txtHusmobnum.setText("");
                    secHusmobnumDK.setVisibility(View.GONE);
                    lineHusmobnumDK.setVisibility(View.GONE);
                    chkHusmobnumDK.setChecked(false);
                    secHusmobnum2.setVisibility(View.GONE);
                    lineHusmobnum2.setVisibility(View.GONE);
                    txtHusmobnum2.setText("");
                    secHusmobnum2DK.setVisibility(View.GONE);
                    lineHusmobnum2DK.setVisibility(View.GONE);
                    chkHusmobnum2DK.setChecked(false);
             }
             else
             {
                    secHusmobnum.setVisibility(View.VISIBLE);
                    lineHusmobnum.setVisibility(View.VISIBLE);
                    secHusmobnumDK.setVisibility(View.VISIBLE);
                    lineHusmobnumDK.setVisibility(View.VISIBLE);
                    //secHusmobnum2.setVisibility(View.VISIBLE);
                    lineHusmobnum2.setVisibility(View.VISIBLE);
                    //secHusmobnum2DK.setVisibility(View.VISIBLE);
                    lineHusmobnum2DK.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secHusmobnum=(LinearLayout)findViewById(R.id.secHusmobnum);
         lineHusmobnum=(View)findViewById(R.id.lineHusmobnum);
         VlblHusmobnum=(TextView) findViewById(R.id.VlblHusmobnum);
         txtHusmobnum=(EditText) findViewById(R.id.txtHusmobnum);
         secHusmobnumDK=(LinearLayout)findViewById(R.id.secHusmobnumDK);
         lineHusmobnumDK=(View)findViewById(R.id.lineHusmobnumDK);
         VlblHusmobnumDK=(TextView) findViewById(R.id.VlblHusmobnumDK);
         chkHusmobnumDK=(CheckBox) findViewById(R.id.chkHusmobnumDK);
         secHusmobnum2=(LinearLayout)findViewById(R.id.secHusmobnum2);
         lineHusmobnum2=(View)findViewById(R.id.lineHusmobnum2);
         VlblHusmobnum2=(TextView) findViewById(R.id.VlblHusmobnum2);
         txtHusmobnum2=(EditText) findViewById(R.id.txtHusmobnum2);
         secHusmobnum2DK=(LinearLayout)findViewById(R.id.secHusmobnum2DK);
         lineHusmobnum2DK=(View)findViewById(R.id.lineHusmobnum2DK);
         VlblHusmobnum2DK=(TextView) findViewById(R.id.VlblHusmobnum2DK);
         chkHusmobnum2DK=(CheckBox) findViewById(R.id.chkHusmobnum2DK);
         seccontact1=(LinearLayout)findViewById(R.id.seccontact1);
         linecontact1=(View)findViewById(R.id.linecontact1);
         Vlblcontact1=(TextView) findViewById(R.id.Vlblcontact1);
         txtcontact1=(EditText) findViewById(R.id.txtcontact1);
         seclblsec13=(LinearLayout)findViewById(R.id.seclblsec13);
         linelblsec13=(View)findViewById(R.id.linelblsec13);
         seceddknown=(LinearLayout)findViewById(R.id.seceddknown);
         lineeddknown=(View)findViewById(R.id.lineeddknown);
         Vlbleddknown = (TextView) findViewById(R.id.Vlbleddknown);
         rdogrpeddknown = (RadioGroup) findViewById(R.id.rdogrpeddknown);
         
         rdoeddknown1 = (RadioButton) findViewById(R.id.rdoeddknown1);
         rdoeddknown2 = (RadioButton) findViewById(R.id.rdoeddknown2);
         rdoeddknown3 = (RadioButton) findViewById(R.id.rdoeddknown3);
         rdogrpeddknown.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpeddknown = new String[] {"1","2","9"};
             for (int i = 0; i < rdogrpeddknown.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpeddknown.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpeddknown[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secEdd.setVisibility(View.GONE);
                    lineEdd.setVisibility(View.GONE);
                    dtpEdd.setText("");
                    secEddDK.setVisibility(View.GONE);
                    lineEddDK.setVisibility(View.GONE);
                    //chkEddDK.setChecked(false);
                  rdogrpEddDK.clearCheck();
                  secEddDKOth.setVisibility(View.GONE);
                  txtEddDKOth.setText("");
                    seclblsec17.setVisibility(View.GONE);
                    linelblsec17.setVisibility(View.GONE);
             }
             else if(rbData.equalsIgnoreCase("9"))
             {
                    secEdd.setVisibility(View.GONE);
                    lineEdd.setVisibility(View.GONE);
                    dtpEdd.setText("");
                    secEddDK.setVisibility(View.GONE);
                    lineEddDK.setVisibility(View.GONE);
                    //chkEddDK.setChecked(false);
                  rdogrpEddDK.clearCheck();
                  secEddDKOth.setVisibility(View.GONE);
                  txtEddDKOth.setText("");
                    seclblsec17.setVisibility(View.GONE);
                    linelblsec17.setVisibility(View.GONE);
             }
             else
             {
                    secEdd.setVisibility(View.VISIBLE);
                    lineEdd.setVisibility(View.VISIBLE);
                    secEddDK.setVisibility(View.VISIBLE);
                    lineEddDK.setVisibility(View.VISIBLE);
                    //seclblsec17.setVisibility(View.VISIBLE);
                    linelblsec17.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secEdd=(LinearLayout)findViewById(R.id.secEdd);
         lineEdd=(View)findViewById(R.id.lineEdd);
         VlblEdd=(TextView) findViewById(R.id.VlblEdd);
         dtpEdd=(EditText) findViewById(R.id.dtpEdd);
         secEddDK=(LinearLayout)findViewById(R.id.secEddDK);
         lineEddDK=(View)findViewById(R.id.lineEddDK);
         VlblEddDK=(TextView) findViewById(R.id.VlblEddDK);
         //chkEddDK=(CheckBox) findViewById(R.id.chkEddDK);
         seclblsec17=(LinearLayout)findViewById(R.id.seclblsec17);
         linelblsec17=(View)findViewById(R.id.linelblsec17);
         secGameth=(LinearLayout)findViewById(R.id.secGameth);
         //lineGameth=(View)findViewById(R.id.lineGameth);
         //VlblGameth=(TextView) findViewById(R.id.VlblGameth);

         //secGamethOth=(LinearLayout)findViewById(R.id.secGamethOth);
         //lineGamethOth=(View)findViewById(R.id.lineGamethOth);
         //VlblGamethOth=(TextView) findViewById(R.id.VlblGamethOth);
         //txtGamethOth=(EditText) findViewById(R.id.txtGamethOth);
         secga1anc=(LinearLayout)findViewById(R.id.secga1anc);
         linega1anc=(View)findViewById(R.id.linega1anc);
         Vlblga1anc=(TextView) findViewById(R.id.Vlblga1anc);
         txtga1anc=(EditText) findViewById(R.id.txtga1anc);
         secga1ancWM=(LinearLayout)findViewById(R.id.secga1ancWM);
         linega1ancWM=(View)findViewById(R.id.linega1ancWM);
         Vlblga1ancWM = (TextView) findViewById(R.id.Vlblga1ancWM);
         rdogrpga1ancWM = (RadioGroup) findViewById(R.id.rdogrpga1ancWM);
         
         rdoga1ancWM1 = (RadioButton) findViewById(R.id.rdoga1ancWM1);
         rdoga1ancWM2 = (RadioButton) findViewById(R.id.rdoga1ancWM2);
         rdoga1ancWM3 = (RadioButton) findViewById(R.id.rdoga1ancWM3);
         secantcarenum=(LinearLayout)findViewById(R.id.secantcarenum);
         lineantcarenum=(View)findViewById(R.id.lineantcarenum);
         Vlblantcarenum=(TextView) findViewById(R.id.Vlblantcarenum);
         spnantcarenum=(Spinner) findViewById(R.id.spnantcarenum);
         List<String> listantcarenum = new ArrayList<String>();
         
         listantcarenum.add("");
         if(COUNTRYCODE.equals(ProjectSetting.BANGLADESH)){
             listantcarenum.add("1-১বার");
             listantcarenum.add("2-২ থেকে ৪বার");
             listantcarenum.add("3-৪ এর অধিকবার");
             listantcarenum.add("9-জানিনা/মনে নাই");
         }else if(COUNTRYCODE.equals(ProjectSetting.NEPAL)){
             listantcarenum.add("1-१ पटक");
             listantcarenum.add("2-२-४ पटक");
             listantcarenum.add("3-४ पटकभन्दा माथि");
             listantcarenum.add("9-थाहा छैन/ याद छैन");
         }else if(COUNTRYCODE.equals(ProjectSetting.TANZANIA)){
             listantcarenum.add("1-Kipimo mara moja");
             listantcarenum.add("2-Vipimo mara 2-4");
             listantcarenum.add("3-Zaidi ya mara nne");
             listantcarenum.add("9-Sijui / Sikumbuki ");
         }else {
             listantcarenum.add("1-1 Check-up");
             listantcarenum.add("2-2-4 Check-up");
             listantcarenum.add("3-More then 4");
             listantcarenum.add("9-Don’t know/don’t remember");
         }
         ArrayAdapter<String> adptrantcarenum= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listantcarenum);
         spnantcarenum.setAdapter(adptrantcarenum);

         secga=(LinearLayout)findViewById(R.id.secga);
         linega=(View)findViewById(R.id.linega);
         Vlblga=(TextView) findViewById(R.id.Vlblga);
         txtga=(EditText) findViewById(R.id.txtga);
         secgaWM=(LinearLayout)findViewById(R.id.secgaWM);
         linegaWM=(View)findViewById(R.id.linegaWM);
         VlblgaWM = (TextView) findViewById(R.id.VlblgaWM);
         rdogrpgaWM = (RadioGroup) findViewById(R.id.rdogrpgaWM);
         
         rdogaWM1 = (RadioButton) findViewById(R.id.rdogaWM1);
         rdogaWM2 = (RadioButton) findViewById(R.id.rdogaWM2);
         rdogaWM3 = (RadioButton) findViewById(R.id.rdogaWM3);
         seclblsec14=(LinearLayout)findViewById(R.id.seclblsec14);
         linelblsec14=(View)findViewById(R.id.linelblsec14);
         secbheart=(LinearLayout)findViewById(R.id.secbheart);
         linebheart=(View)findViewById(R.id.linebheart);
         Vlblbheart = (TextView) findViewById(R.id.Vlblbheart);
         rdogrpbheart = (RadioGroup) findViewById(R.id.rdogrpbheart);
         
         rdobheart1 = (RadioButton) findViewById(R.id.rdobheart1);
         rdobheart2 = (RadioButton) findViewById(R.id.rdobheart2);
         rdobheart3 = (RadioButton) findViewById(R.id.rdobheart3);
         rdobheart4 = (RadioButton) findViewById(R.id.rdobheart4);
         rdogrpbheart.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpbheart = new String[] {"1","2","3","9"};
             for (int i = 0; i < rdogrpbheart.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpbheart.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpbheart[i];
             }

             if(rbData.equalsIgnoreCase("3"))
             {
                    secbcondition.setVisibility(View.GONE);
                    linebcondition.setVisibility(View.GONE);
                    //spnbcondition.setSelection(0);
                 rdogrpbcondition.clearCheck();
             }
             else if(rbData.equalsIgnoreCase("9"))
             {
                    secbcondition.setVisibility(View.GONE);
                    linebcondition.setVisibility(View.GONE);
                    //spnbcondition.setSelection(0);
                 rdogrpbcondition.clearCheck();
             }
             else
             {
                    secbcondition.setVisibility(View.VISIBLE);
                    linebcondition.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secbcondition=(LinearLayout)findViewById(R.id.secbcondition);
         linebcondition=(View)findViewById(R.id.linebcondition);
         Vlblbcondition=(TextView) findViewById(R.id.Vlblbcondition);
         //spnbcondition=(Spinner) findViewById(R.id.spnbcondition);
         /*List<String> listbcondition = new ArrayList<String>();
         
         listbcondition.add("");
         listbcondition.add("01-Yes");
         listbcondition.add("02-No");
         listbcondition.add("03-Don’t know/don’t remember");
         ArrayAdapter<String> adptrbcondition= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listbcondition);
         spnbcondition.setAdapter(adptrbcondition);*/

         rdogrpbcondition=(RadioGroup)findViewById(R.id.rdogrpbcondition) ;
         rdobcondition1=(RadioButton)findViewById(R.id.rdobcondition1) ;
         rdobcondition2=(RadioButton)findViewById(R.id.rdobcondition2) ;
         rdobcondition3=(RadioButton)findViewById(R.id.rdobcondition3) ;

         secplacedeliv=(LinearLayout)findViewById(R.id.secplacedeliv);
         lineplacedeliv=(View)findViewById(R.id.lineplacedeliv);
         Vlblplacedeliv = (TextView) findViewById(R.id.Vlblplacedeliv);
         rdogrpplacedeliv = (RadioGroup) findViewById(R.id.rdogrpplacedeliv);
         
         rdoplacedeliv1 = (RadioButton) findViewById(R.id.rdoplacedeliv1);
         rdoplacedeliv2 = (RadioButton) findViewById(R.id.rdoplacedeliv2);
         rdoplacedeliv3 = (RadioButton) findViewById(R.id.rdoplacedeliv3);
         rdoplacedeliv4 = (RadioButton) findViewById(R.id.rdoplacedeliv4);
         rdoplacedeliv5 = (RadioButton) findViewById(R.id.rdoplacedeliv5);

         rdogrpplacedeliv.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpplacedeliv = new String[] {"1","2","3","4","5"};
             for (int i = 0; i < rdogrpplacedeliv.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpplacedeliv.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpplacedeliv[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                    secplacedelivOth.setVisibility(View.GONE);
                    lineplacedelivOth.setVisibility(View.GONE);
                    txtplacedelivOth.setText("");
             }
             else if(rbData.equalsIgnoreCase("2"))
             {
                    secplacedelivOth.setVisibility(View.GONE);
                    lineplacedelivOth.setVisibility(View.GONE);
                    txtplacedelivOth.setText("");
             }
             else if(rbData.equalsIgnoreCase("3"))
             {
                    secplacedelivOth.setVisibility(View.GONE);
                    lineplacedelivOth.setVisibility(View.GONE);
                    txtplacedelivOth.setText("");
             }
             else if(rbData.equalsIgnoreCase("4"))
             {
                 secplacedelivOth.setVisibility(View.GONE);
                 lineplacedelivOth.setVisibility(View.GONE);
                 txtplacedelivOth.setText("");
             }
             else
             {
                    secplacedelivOth.setVisibility(View.VISIBLE);
                    lineplacedelivOth.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secplacedelivOth=(LinearLayout)findViewById(R.id.secplacedelivOth);
         lineplacedelivOth=(View)findViewById(R.id.lineplacedelivOth);
         VlblplacedelivOth=(TextView) findViewById(R.id.VlblplacedelivOth);
         txtplacedelivOth=(EditText) findViewById(R.id.txtplacedelivOth);
         secdelivdate=(LinearLayout)findViewById(R.id.secdelivdate);
         linedelivdate=(View)findViewById(R.id.linedelivdate);
         Vlbldelivdate=(TextView) findViewById(R.id.Vlbldelivdate);
         dtpdelivdate=(EditText) findViewById(R.id.dtpdelivdate);
         secdelivdateDK=(LinearLayout)findViewById(R.id.secdelivdateDK);
         linedelivdateDK=(View)findViewById(R.id.linedelivdateDK);
         VlbldelivdateDK=(TextView) findViewById(R.id.VlbldelivdateDK);
         chkdelivdateDK=(CheckBox) findViewById(R.id.chkdelivdateDK);
         secdelivtime=(LinearLayout)findViewById(R.id.secdelivtime);
         linedelivtime=(View)findViewById(R.id.linedelivtime);
         Vlbldelivtime=(TextView) findViewById(R.id.Vlbldelivtime);
         txtdelivtime=(EditText) findViewById(R.id.txtdelivtime);
         secdelivtimeDK=(LinearLayout)findViewById(R.id.secdelivtimeDK);
         linedelivtimeDK=(View)findViewById(R.id.linedelivtimeDK);
         VlbldelivtimeDK=(TextView) findViewById(R.id.VlbldelivtimeDK);
         chkdelivtimeDK=(CheckBox) findViewById(R.id.chkdelivtimeDK);
         sectypebirth=(LinearLayout)findViewById(R.id.sectypebirth);
         linetypebirth=(View)findViewById(R.id.linetypebirth);
         Vlbltypebirth=(TextView) findViewById(R.id.Vlbltypebirth);
         spntypebirth=(Spinner) findViewById(R.id.spntypebirth);
         List<String> listtypebirth = new ArrayList<String>();
         
         listtypebirth.add("");
         if(COUNTRYCODE.equals(ProjectSetting.BANGLADESH)){
             listtypebirth.add("1-নরমাল ডেলিভারী");
             listtypebirth.add("2-ব্রীচ(নিতম্ব)ডেলিভারী");
             listtypebirth.add("3-ভেকুয়াম ডেলিভারী");
             listtypebirth.add("4-ফরসেপ ডেলিভারী");
             listtypebirth.add("5-সিজারিয়ান সেকশন");
             listtypebirth.add("9-জানিনা/মনে নাই");
         }else if(COUNTRYCODE.equals(ProjectSetting.NEPAL)){
             listtypebirth.add("1-साधारण प्रकृया");
             listtypebirth.add("2-साधारण breech");
             listtypebirth.add("3-भ्याक्युम");
             listtypebirth.add("4-फोर्सेप");
             listtypebirth.add("5-शल्यकृया प्रकृया");
             listtypebirth.add("9-थाहा छैन / याद छैन");
         }else if(COUNTRYCODE.equals(ProjectSetting.TANZANIA)){
             listtypebirth.add("1-Kwa njia ya kawaida");
             listtypebirth.add("2-Vagina breech");
             listtypebirth.add("3-Vacuum Extraction");
             listtypebirth.add("4-Forceps (yoyote)");
             listtypebirth.add("5-kwa upereshen");
             listtypebirth.add("9-Sijui/Sikumbuki");
         }else {
             listtypebirth.add("1-Normal vaginal delivery");
             listtypebirth.add("2-Vaginal breech");
             listtypebirth.add("3-Vacuum Extraction");
             listtypebirth.add("4-Forceps (any)");
             listtypebirth.add("5-Caesarean section");
             listtypebirth.add("9-Don’t know/don’t remember");
         }
         ArrayAdapter<String> adptrtypebirth= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listtypebirth);
         spntypebirth.setAdapter(adptrtypebirth);

         spntypebirth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             if (spntypebirth.getSelectedItem().toString().length() == 0) return;
             String spnData = Connection.SelectedSpinnerValue(spntypebirth.getSelectedItem().toString(),"-");
                 if(spnData.equalsIgnoreCase("1"))
                 {
                    seclblsec18.setVisibility(View.GONE);
                    linelblsec18.setVisibility(View.GONE);
                    secTimecsec.setVisibility(View.GONE);
                    lineTimecsec.setVisibility(View.GONE);
                    spnTimecsec.setSelection(0);
                    secToldcsecreas.setVisibility(View.GONE);
                    lineToldcsecreas.setVisibility(View.GONE);
                    rdogrpToldcsecreas.clearCheck();
                    secCsecreas.setVisibility(View.GONE);
                    lineCsecreas.setVisibility(View.GONE);
                    spnCsecreas.setSelection(0);
                    secOthReason.setVisibility(View.GONE);
                    lineOthReason.setVisibility(View.GONE);
                    txtOthReason.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                    seclblsec18.setVisibility(View.GONE);
                    linelblsec18.setVisibility(View.GONE);
                    secTimecsec.setVisibility(View.GONE);
                    lineTimecsec.setVisibility(View.GONE);
                    spnTimecsec.setSelection(0);
                    secToldcsecreas.setVisibility(View.GONE);
                    lineToldcsecreas.setVisibility(View.GONE);
                    rdogrpToldcsecreas.clearCheck();
                    secCsecreas.setVisibility(View.GONE);
                    lineCsecreas.setVisibility(View.GONE);
                    spnCsecreas.setSelection(0);
                    secOthReason.setVisibility(View.GONE);
                    lineOthReason.setVisibility(View.GONE);
                    txtOthReason.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("3"))
                 {
                    seclblsec18.setVisibility(View.GONE);
                    linelblsec18.setVisibility(View.GONE);
                    secTimecsec.setVisibility(View.GONE);
                    lineTimecsec.setVisibility(View.GONE);
                    spnTimecsec.setSelection(0);
                    secToldcsecreas.setVisibility(View.GONE);
                    lineToldcsecreas.setVisibility(View.GONE);
                    rdogrpToldcsecreas.clearCheck();
                    secCsecreas.setVisibility(View.GONE);
                    lineCsecreas.setVisibility(View.GONE);
                    spnCsecreas.setSelection(0);
                    secOthReason.setVisibility(View.GONE);
                    lineOthReason.setVisibility(View.GONE);
                    txtOthReason.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("4"))
                 {
                    seclblsec18.setVisibility(View.GONE);
                    linelblsec18.setVisibility(View.GONE);
                    secTimecsec.setVisibility(View.GONE);
                    lineTimecsec.setVisibility(View.GONE);
                    spnTimecsec.setSelection(0);
                    secToldcsecreas.setVisibility(View.GONE);
                    lineToldcsecreas.setVisibility(View.GONE);
                    rdogrpToldcsecreas.clearCheck();
                    secCsecreas.setVisibility(View.GONE);
                    lineCsecreas.setVisibility(View.GONE);
                    spnCsecreas.setSelection(0);
                    secOthReason.setVisibility(View.GONE);
                    lineOthReason.setVisibility(View.GONE);
                    txtOthReason.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("9"))
                 {
                    seclblsec18.setVisibility(View.GONE);
                    linelblsec18.setVisibility(View.GONE);
                    secTimecsec.setVisibility(View.GONE);
                    lineTimecsec.setVisibility(View.GONE);
                    spnTimecsec.setSelection(0);
                    secToldcsecreas.setVisibility(View.GONE);
                    lineToldcsecreas.setVisibility(View.GONE);
                    rdogrpToldcsecreas.clearCheck();
                    secCsecreas.setVisibility(View.GONE);
                    lineCsecreas.setVisibility(View.GONE);
                    spnCsecreas.setSelection(0);
                    secOthReason.setVisibility(View.GONE);
                    lineOthReason.setVisibility(View.GONE);
                    txtOthReason.setText("");
                 }
                 else
                 {
                    //seclblsec18.setVisibility(View.VISIBLE);
                    linelblsec18.setVisibility(View.VISIBLE);
                    secTimecsec.setVisibility(View.VISIBLE);
                    lineTimecsec.setVisibility(View.VISIBLE);
                    secToldcsecreas.setVisibility(View.VISIBLE);
                    lineToldcsecreas.setVisibility(View.VISIBLE);
                    secCsecreas.setVisibility(View.VISIBLE);
                    lineCsecreas.setVisibility(View.VISIBLE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         seclblsec18=(LinearLayout)findViewById(R.id.seclblsec18);
         linelblsec18=(View)findViewById(R.id.linelblsec18);
         secTimecsec=(LinearLayout)findViewById(R.id.secTimecsec);
         lineTimecsec=(View)findViewById(R.id.lineTimecsec);
         VlblTimecsec=(TextView) findViewById(R.id.VlblTimecsec);
         spnTimecsec=(Spinner) findViewById(R.id.spnTimecsec);
         List<String> listTimecsec = new ArrayList<String>();
         
         listTimecsec.add("");
         if(COUNTRYCODE.equals(ProjectSetting.BANGLADESH)){
             listTimecsec.add("1-প্রসববেদনা শুরুর আগে");
             listTimecsec.add("2-প্রসববেদনা শুরুর পর");
             listTimecsec.add("9-জানিনা/মনে নাই");
         }else if(COUNTRYCODE.equals(ProjectSetting.NEPAL)){
             listTimecsec.add("1-व्यथा सुरूहुनु अघि");
             listTimecsec.add("2-व्यथा सुरू भएपछि");
             listTimecsec.add("9-थाहा छैन / याद छैन");
         }else if(COUNTRYCODE.equals(ProjectSetting.TANZANIA)){
             listTimecsec.add("1-Kabla ya uchungu kuanza");
             listTimecsec.add("2-Baada ya uchungu kuanza");
             listTimecsec.add("9-Sijui/Sikumbuki");
         }else {
             listTimecsec.add("1-Before labour pains");
             listTimecsec.add("2-After labour pains");
             listTimecsec.add("9-Don’t know/don’t remember");
         }
         ArrayAdapter<String> adptrTimecsec= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listTimecsec);
         spnTimecsec.setAdapter(adptrTimecsec);

         secToldcsecreas=(LinearLayout)findViewById(R.id.secToldcsecreas);
         lineToldcsecreas=(View)findViewById(R.id.lineToldcsecreas);
         VlblToldcsecreas = (TextView) findViewById(R.id.VlblToldcsecreas);
         rdogrpToldcsecreas = (RadioGroup) findViewById(R.id.rdogrpToldcsecreas);
         
         rdoToldcsecreas1 = (RadioButton) findViewById(R.id.rdoToldcsecreas1);
         rdoToldcsecreas2 = (RadioButton) findViewById(R.id.rdoToldcsecreas2);
         rdoToldcsecreas3 = (RadioButton) findViewById(R.id.rdoToldcsecreas3);
         rdogrpToldcsecreas.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpToldcsecreas = new String[] {"1","2","9"};
             for (int i = 0; i < rdogrpToldcsecreas.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpToldcsecreas.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpToldcsecreas[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secCsecreas.setVisibility(View.GONE);
                    lineCsecreas.setVisibility(View.GONE);
                    spnCsecreas.setSelection(0);
                    secOthReason.setVisibility(View.GONE);
                    lineOthReason.setVisibility(View.GONE);
                    txtOthReason.setText("");
             }
             else if(rbData.equalsIgnoreCase("9"))
             {
                    secCsecreas.setVisibility(View.GONE);
                    lineCsecreas.setVisibility(View.GONE);
                    spnCsecreas.setSelection(0);
                    secOthReason.setVisibility(View.GONE);
                    lineOthReason.setVisibility(View.GONE);
                    txtOthReason.setText("");
             }
             else
             {
                    secCsecreas.setVisibility(View.VISIBLE);
                    lineCsecreas.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secCsecreas=(LinearLayout)findViewById(R.id.secCsecreas);
         lineCsecreas=(View)findViewById(R.id.lineCsecreas);
         VlblCsecreas=(TextView) findViewById(R.id.VlblCsecreas);
         spnCsecreas=(Spinner) findViewById(R.id.spnCsecreas);
         List<String> listCsecreas = new ArrayList<String>();
         
         listCsecreas.add("");
         if(COUNTRYCODE.equals(ProjectSetting.BANGLADESH)){
             listCsecreas.add("01-বাচ্চা অনেক বড়");
             listCsecreas.add("02-বাচ্চার অস্বাভাবিক অবস্থান");
             listCsecreas.add("03-বাচ্চাকে বাচানোর জন্য");
             listCsecreas.add("04- প্রলম্বিত প্রসব");
             listCsecreas.add("05-অতিরিক্ত রক্তক্ষরণ");
             listCsecreas.add("06-পূর্বে সিজারিয়ান সেকশনের অভিজ্ঞতা");
             listCsecreas.add("07-সিজার করার জন্য অনুরোধ");
             listCsecreas.add("97-অন্যান্য");
             listCsecreas.add("99-জানিনা/মনে নাই");

         }else if(COUNTRYCODE.equals(ProjectSetting.NEPAL)){
             listCsecreas.add("01-बच्चा ठूलो भएर");
             listCsecreas.add("02-बच्चा उल्टो भएर(breech)");
             listCsecreas.add("03-बच्चालाईगार्होभएर");
             listCsecreas.add("04-व्यथालम्बिएकोभएर");
             listCsecreas.add("05-बच्चाजन्मिसकेपछीधेरैरगतबगेर");
             listCsecreas.add("06-पहिलेशल्यकृया भएकोले");
             listCsecreas.add("07-आफ्नै इच्छाले");
             listCsecreas.add("97-अन्य");
             listCsecreas.add("99-थाहा छैन / याद छैन");

         }else if(COUNTRYCODE.equals(ProjectSetting.TANZANIA)){
             listCsecreas.add("01-Mtoto mkubwa sana");
             listCsecreas.add("02-Mtoto alikaa vibaya");
             listCsecreas.add("03-Kumuokoa mtoto, kwasababu mtoto alianza kuumwa");
             listCsecreas.add("04-Uchungu wa muda mrefu");
             listCsecreas.add("05-Kutokwa kwa damu nyingi");
             listCsecreas.add("06-Kwasababu ya operesheni iliyopita");
             listCsecreas.add("07-Niliomba nifanyiwe");
             listCsecreas.add("97-Nyingine, Taja");
             listCsecreas.add("99-Sijui/Sikumbuki");

         }else {
             listCsecreas.add("01-Baby too big");
             listCsecreas.add("02-Malpresentation/breech");
             listCsecreas.add("03-To save the baby, i.e.baby started to suffer");
             listCsecreas.add("04-Prolonged labour");
             listCsecreas.add("05-Obstetric haemorrhage");
             listCsecreas.add("06-Previous c section");
             listCsecreas.add("07-On request");
             listCsecreas.add("97-Other");
             listCsecreas.add("99-Don’t know/don’t remember");
         }
         ArrayAdapter<String> adptrCsecreas= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listCsecreas);
         spnCsecreas.setAdapter(adptrCsecreas);

         spnCsecreas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             if (spnCsecreas.getSelectedItem().toString().length() == 0) return;
             String spnData = Connection.SelectedSpinnerValue(spnCsecreas.getSelectedItem().toString(),"-");
                 if(spnData.equalsIgnoreCase("01"))
                 {
                    secOthReason.setVisibility(View.GONE);
                    lineOthReason.setVisibility(View.GONE);
                    txtOthReason.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("02"))
                 {
                    secOthReason.setVisibility(View.GONE);
                    lineOthReason.setVisibility(View.GONE);
                    txtOthReason.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("03"))
                 {
                    secOthReason.setVisibility(View.GONE);
                    lineOthReason.setVisibility(View.GONE);
                    txtOthReason.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("04"))
                 {
                    secOthReason.setVisibility(View.GONE);
                    lineOthReason.setVisibility(View.GONE);
                    txtOthReason.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("05"))
                 {
                    secOthReason.setVisibility(View.GONE);
                    lineOthReason.setVisibility(View.GONE);
                    txtOthReason.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("06"))
                 {
                    secOthReason.setVisibility(View.GONE);
                    lineOthReason.setVisibility(View.GONE);
                    txtOthReason.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("07"))
                 {
                    secOthReason.setVisibility(View.GONE);
                    lineOthReason.setVisibility(View.GONE);
                    txtOthReason.setText("");
                 }else if(spnData.equalsIgnoreCase("98"))
                 {
                      secOthReason.setVisibility(View.GONE);
                      lineOthReason.setVisibility(View.GONE);
                      txtOthReason.setText("");
                 }
                 else
                 {
                    secOthReason.setVisibility(View.VISIBLE);
                    lineOthReason.setVisibility(View.VISIBLE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secOthReason=(LinearLayout)findViewById(R.id.secOthReason);
         lineOthReason=(View)findViewById(R.id.lineOthReason);
         VlblOthReason=(TextView) findViewById(R.id.VlblOthReason);
         txtOthReason=(EditText) findViewById(R.id.txtOthReason);
         secBwgted=(LinearLayout)findViewById(R.id.secBwgted);
         lineBwgted=(View)findViewById(R.id.lineBwgted);
         VlblBwgted = (TextView) findViewById(R.id.VlblBwgted);
         rdogrpBwgted = (RadioGroup) findViewById(R.id.rdogrpBwgted);
         
         rdoBwgted1 = (RadioButton) findViewById(R.id.rdoBwgted1);
         rdoBwgted2 = (RadioButton) findViewById(R.id.rdoBwgted2);
         rdoBwgted3 = (RadioButton) findViewById(R.id.rdoBwgted3);
         rdogrpBwgted.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpBwgted = new String[] {"1","2","9"};
             for (int i = 0; i < rdogrpBwgted.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpBwgted.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpBwgted[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secBwgt.setVisibility(View.GONE);
                    lineBwgt.setVisibility(View.GONE);
                    txtBwgt.setText("");
                    secBwgtDK.setVisibility(View.GONE);
                    lineBwgtDK.setVisibility(View.GONE);
                    rdogrpBwgtDK.clearCheck();
                    lineBwgtDK.setVisibility(View.GONE);
                 secbwgtmeth.setVisibility(View.GONE);
                 rdogrpbwgtmeth.clearCheck();
             }
             else if(rbData.equalsIgnoreCase("9"))
             {
                    secBwgt.setVisibility(View.GONE);
                    lineBwgt.setVisibility(View.GONE);
                    txtBwgt.setText("");
                    secBwgtDK.setVisibility(View.GONE);
                    lineBwgtDK.setVisibility(View.GONE);
                    rdogrpBwgtDK.clearCheck();
                 lineBwgtDK.setVisibility(View.GONE);
                 secbwgtmeth.setVisibility(View.GONE);
                 rdogrpbwgtmeth.clearCheck();
             }
             else
             {
                    secBwgt.setVisibility(View.VISIBLE);
                    lineBwgt.setVisibility(View.VISIBLE);
                    secBwgtDK.setVisibility(View.VISIBLE);
                    lineBwgtDK.setVisibility(View.VISIBLE);
                 lineBwgtDK.setVisibility(View.VISIBLE);
                 secbwgtmeth.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secBwgt=(LinearLayout)findViewById(R.id.secBwgt);
         lineBwgt=(View)findViewById(R.id.lineBwgt);
         VlblBwgt=(TextView) findViewById(R.id.VlblBwgt);
         txtBwgt=(EditText) findViewById(R.id.txtBwgt);
         secBwgtDK=(LinearLayout)findViewById(R.id.secBwgtDK);
         lineBwgtDK=(View)findViewById(R.id.lineBwgtDK);
         VlblBwgtDK = (TextView) findViewById(R.id.VlblBwgtDK);
         rdogrpBwgtDK = (RadioGroup) findViewById(R.id.rdogrpBwgtDK);
         
         rdoBwgtDK1 = (RadioButton) findViewById(R.id.rdoBwgtDK1);
         rdoBwgtDK2 = (RadioButton) findViewById(R.id.rdoBwgtDK2);
         secbwgtmeth=(LinearLayout)findViewById(R.id.secbwgtmeth);
         linebwgtmeth=(View)findViewById(R.id.linebwgtmeth);
         Vlblbwgtmeth = (TextView) findViewById(R.id.Vlblbwgtmeth);
         rdogrpbwgtmeth = (RadioGroup) findViewById(R.id.rdogrpbwgtmeth);
         
         rdobwgtmeth1 = (RadioButton) findViewById(R.id.rdobwgtmeth1);
         rdobwgtmeth2 = (RadioButton) findViewById(R.id.rdobwgtmeth2);
         rdobwgtmeth3 = (RadioButton) findViewById(R.id.rdobwgtmeth3);
         secBsex=(LinearLayout)findViewById(R.id.secBsex);
         lineBsex=(View)findViewById(R.id.lineBsex);
         VlblBsex=(TextView) findViewById(R.id.VlblBsex);
         spnBsex=(Spinner) findViewById(R.id.spnBsex);
         List<String> listBsex = new ArrayList<String>();
         
         listBsex.add("");
         if(COUNTRYCODE.equals(ProjectSetting.BANGLADESH)){
             listBsex.add("1-ছেলে");
             listBsex.add("2-মেয়ে");
             listBsex.add("3-তৃতীয় লিঙ্গ");
             listBsex.add("9-জানিনা/মনে নাই");
         }else if(COUNTRYCODE.equals(ProjectSetting.NEPAL)){
             listBsex.add("1-छोरा");
             listBsex.add("2-छोरी");
             listBsex.add("3-छुट्याउन नसकेको");
             listBsex.add("9-थाहा छैन / यादछैन");
         }else if(COUNTRYCODE.equals(ProjectSetting.TANZANIA)){
             listBsex.add("1-Wa kiume");
             listBsex.add("2-Wa kike");
             listBsex.add("3-Mchanganyiko");
             listBsex.add("9-Sijui/Sikumbuki");
         }else {
             listBsex.add("1-Boy");
             listBsex.add("2-Girl");
             listBsex.add("3-Ambiguous");
             listBsex.add("9-Don’t know/don’t remember");
         }
         ArrayAdapter<String> adptrBsex= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listBsex);
         spnBsex.setAdapter(adptrBsex);

         secperceivesize=(LinearLayout)findViewById(R.id.secperceivesize);
         lineperceivesize=(View)findViewById(R.id.lineperceivesize);
         Vlblperceivesize=(TextView) findViewById(R.id.Vlblperceivesize);
         spnperceivesize=(Spinner) findViewById(R.id.spnperceivesize);
         List<String> listperceivesize = new ArrayList<String>();
         
         listperceivesize.add("");
         if(COUNTRYCODE.equals(ProjectSetting.BANGLADESH)){
             listperceivesize.add("1-খুব বড়");
             listperceivesize.add("2-স্বাভাবিকের চেয়ে বড়");
             listperceivesize.add("3-স্বাভাবিক");
             listperceivesize.add("4-স্বাভাবিকের চেয়ে ছোট");
             listperceivesize.add("5-খুব ছোট");
             listperceivesize.add("9-জানিনা/মনে নাই");
         }else if(COUNTRYCODE.equals(ProjectSetting.NEPAL)){
             listperceivesize.add("1-धैरै ठूलो");
             listperceivesize.add("2-ठूलो");
             listperceivesize.add("3-ठिक्कको");
             listperceivesize.add("4-सानो");
             listperceivesize.add("5-धेरै सानो");
             listperceivesize.add("9-थाहाछैन/ यादछैन");
         }else if(COUNTRYCODE.equals(ProjectSetting.TANZANIA)){
             listperceivesize.add("1-Mkubwa sana");
             listperceivesize.add("2-Mkubwa kuliko kawaida");
             listperceivesize.add("3-Kawaida");
             listperceivesize.add("4-Mdogo kuliko kawaida");
             listperceivesize.add("5-Mdogo sana");
             listperceivesize.add("9-Sijui/Sikumbuki");
         }else {
             listperceivesize.add("1-Very large");
             listperceivesize.add("2-Larger than average");
             listperceivesize.add("3-Average");
             listperceivesize.add("4-Smaller than average");
             listperceivesize.add("5-Very small");
             listperceivesize.add("9-Don’t know/don’t remember");
         }
         ArrayAdapter<String> adptrperceivesize= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listperceivesize);
         spnperceivesize.setAdapter(adptrperceivesize);

         secanybcomp=(LinearLayout)findViewById(R.id.secanybcomp);
         lineanybcomp=(View)findViewById(R.id.lineanybcomp);
         Vlblanybcomp = (TextView) findViewById(R.id.Vlblanybcomp);
         rdogrpanybcomp = (RadioGroup) findViewById(R.id.rdogrpanybcomp);
         
         rdoanybcomp1 = (RadioButton) findViewById(R.id.rdoanybcomp1);
         rdoanybcomp2 = (RadioButton) findViewById(R.id.rdoanybcomp2);
         rdoanybcomp3 = (RadioButton) findViewById(R.id.rdoanybcomp3);
         rdogrpanybcomp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpanybcomp = new String[] {"1","2","9"};
             for (int i = 0; i < rdogrpanybcomp.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpanybcomp.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpanybcomp[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    seclblsec15.setVisibility(View.GONE);
                    linelblsec15.setVisibility(View.GONE);
                    secbcompA.setVisibility(View.GONE);
                    linebcompA.setVisibility(View.GONE);
                    chkbcompA.setChecked(false);
                    secbcompB.setVisibility(View.GONE);
                    linebcompB.setVisibility(View.GONE);
                    chkbcompB.setChecked(false);
                    secbcompC.setVisibility(View.GONE);
                    linebcompC.setVisibility(View.GONE);
                    chkbcompC.setChecked(false);
                    secbcompD.setVisibility(View.GONE);
                    linebcompD.setVisibility(View.GONE);
                    chkbcompD.setChecked(false);
                    secbcompE.setVisibility(View.GONE);
                    linebcompE.setVisibility(View.GONE);
                    chkbcompE.setChecked(false);
                    secbcompF.setVisibility(View.GONE);
                    linebcompF.setVisibility(View.GONE);
                    chkbcompF.setChecked(false);
                    secbcompG.setVisibility(View.GONE);
                    linebcompG.setVisibility(View.GONE);
                    chkbcompG.setChecked(false);
                    secbcompH.setVisibility(View.GONE);
                    linebcompH.setVisibility(View.GONE);
                    chkbcompH.setChecked(false);
                    secbcompI.setVisibility(View.GONE);
                    linebcompI.setVisibility(View.GONE);
                    chkbcompI.setChecked(false);
                    secbcompIOth.setVisibility(View.GONE);
                    linebcompIOth.setVisibility(View.GONE);
                    txtbcompIOth.setText("");
                    secbcompJ.setVisibility(View.GONE);
                    linebcompJ.setVisibility(View.GONE);
                    chkbcompJ.setChecked(false);
             }
             else if(rbData.equalsIgnoreCase("9"))
             {
                    seclblsec15.setVisibility(View.GONE);
                    linelblsec15.setVisibility(View.GONE);
                    secbcompA.setVisibility(View.GONE);
                    linebcompA.setVisibility(View.GONE);
                    chkbcompA.setChecked(false);
                    secbcompB.setVisibility(View.GONE);
                    linebcompB.setVisibility(View.GONE);
                    chkbcompB.setChecked(false);
                    secbcompC.setVisibility(View.GONE);
                    linebcompC.setVisibility(View.GONE);
                    chkbcompC.setChecked(false);
                    secbcompD.setVisibility(View.GONE);
                    linebcompD.setVisibility(View.GONE);
                    chkbcompD.setChecked(false);
                    secbcompE.setVisibility(View.GONE);
                    linebcompE.setVisibility(View.GONE);
                    chkbcompE.setChecked(false);
                    secbcompF.setVisibility(View.GONE);
                    linebcompF.setVisibility(View.GONE);
                    chkbcompF.setChecked(false);
                    secbcompG.setVisibility(View.GONE);
                    linebcompG.setVisibility(View.GONE);
                    chkbcompG.setChecked(false);
                    secbcompH.setVisibility(View.GONE);
                    linebcompH.setVisibility(View.GONE);
                    chkbcompH.setChecked(false);
                    secbcompI.setVisibility(View.GONE);
                    linebcompI.setVisibility(View.GONE);
                    chkbcompI.setChecked(false);
                    secbcompIOth.setVisibility(View.GONE);
                    linebcompIOth.setVisibility(View.GONE);
                    txtbcompIOth.setText("");
                    secbcompJ.setVisibility(View.GONE);
                    linebcompJ.setVisibility(View.GONE);
                    chkbcompJ.setChecked(false);
             }
             else
             {
                    seclblsec15.setVisibility(View.VISIBLE);
                    linelblsec15.setVisibility(View.VISIBLE);
                    secbcompA.setVisibility(View.VISIBLE);
                    linebcompA.setVisibility(View.VISIBLE);
                    secbcompB.setVisibility(View.VISIBLE);
                    linebcompB.setVisibility(View.VISIBLE);
                    secbcompC.setVisibility(View.VISIBLE);
                    linebcompC.setVisibility(View.VISIBLE);
                    secbcompD.setVisibility(View.VISIBLE);
                    linebcompD.setVisibility(View.VISIBLE);
                    secbcompE.setVisibility(View.VISIBLE);
                    linebcompE.setVisibility(View.VISIBLE);
                    secbcompF.setVisibility(View.VISIBLE);
                    linebcompF.setVisibility(View.VISIBLE);
                    secbcompG.setVisibility(View.VISIBLE);
                    linebcompG.setVisibility(View.VISIBLE);
                    secbcompH.setVisibility(View.VISIBLE);
                    linebcompH.setVisibility(View.VISIBLE);
                    secbcompI.setVisibility(View.VISIBLE);
                    linebcompI.setVisibility(View.VISIBLE);
                    secbcompJ.setVisibility(View.VISIBLE);
                    linebcompJ.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         seclblsec15=(LinearLayout)findViewById(R.id.seclblsec15);
         linelblsec15=(View)findViewById(R.id.linelblsec15);
         secbcompA=(LinearLayout)findViewById(R.id.secbcompA);
         linebcompA=(View)findViewById(R.id.linebcompA);
         VlblbcompA=(TextView) findViewById(R.id.VlblbcompA);
         chkbcompA=(CheckBox) findViewById(R.id.chkbcompA);
         secbcompB=(LinearLayout)findViewById(R.id.secbcompB);
         linebcompB=(View)findViewById(R.id.linebcompB);
         VlblbcompB=(TextView) findViewById(R.id.VlblbcompB);
         chkbcompB=(CheckBox) findViewById(R.id.chkbcompB);
         secbcompC=(LinearLayout)findViewById(R.id.secbcompC);
         linebcompC=(View)findViewById(R.id.linebcompC);
         VlblbcompC=(TextView) findViewById(R.id.VlblbcompC);
         chkbcompC=(CheckBox) findViewById(R.id.chkbcompC);
         secbcompD=(LinearLayout)findViewById(R.id.secbcompD);
         linebcompD=(View)findViewById(R.id.linebcompD);
         VlblbcompD=(TextView) findViewById(R.id.VlblbcompD);
         chkbcompD=(CheckBox) findViewById(R.id.chkbcompD);
         secbcompE=(LinearLayout)findViewById(R.id.secbcompE);
         linebcompE=(View)findViewById(R.id.linebcompE);
         VlblbcompE=(TextView) findViewById(R.id.VlblbcompE);
         chkbcompE=(CheckBox) findViewById(R.id.chkbcompE);
         secbcompF=(LinearLayout)findViewById(R.id.secbcompF);
         linebcompF=(View)findViewById(R.id.linebcompF);
         VlblbcompF=(TextView) findViewById(R.id.VlblbcompF);
         chkbcompF=(CheckBox) findViewById(R.id.chkbcompF);
         secbcompG=(LinearLayout)findViewById(R.id.secbcompG);
         linebcompG=(View)findViewById(R.id.linebcompG);
         VlblbcompG=(TextView) findViewById(R.id.VlblbcompG);
         chkbcompG=(CheckBox) findViewById(R.id.chkbcompG);
         secbcompH=(LinearLayout)findViewById(R.id.secbcompH);
         linebcompH=(View)findViewById(R.id.linebcompH);
         VlblbcompH=(TextView) findViewById(R.id.VlblbcompH);
         chkbcompH=(CheckBox) findViewById(R.id.chkbcompH);
         secbcompI=(LinearLayout)findViewById(R.id.secbcompI);
         linebcompI=(View)findViewById(R.id.linebcompI);
         VlblbcompI=(TextView) findViewById(R.id.VlblbcompI);
         chkbcompI=(CheckBox) findViewById(R.id.chkbcompI);
         chkbcompI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if (!isChecked) {
                    secbcompIOth.setVisibility(View.GONE);
                    linebcompIOth.setVisibility(View.GONE);
                    txtbcompIOth.setText("");
                 }
                 else
                 {
                    secbcompIOth.setVisibility(View.VISIBLE);
                    linebcompIOth.setVisibility(View.VISIBLE);
                     chkbcompJ.setChecked(false);
                 }
                 }
         });
         secbcompIOth=(LinearLayout)findViewById(R.id.secbcompIOth);
         linebcompIOth=(View)findViewById(R.id.linebcompIOth);
         VlblbcompIOth=(TextView) findViewById(R.id.VlblbcompIOth);
         txtbcompIOth=(EditText) findViewById(R.id.txtbcompIOth);
         secbcompJ=(LinearLayout)findViewById(R.id.secbcompJ);
         linebcompJ=(View)findViewById(R.id.linebcompJ);
         VlblbcompJ=(TextView) findViewById(R.id.VlblbcompJ);
         chkbcompJ=(CheckBox) findViewById(R.id.chkbcompJ);
         secnightsnum=(LinearLayout)findViewById(R.id.secnightsnum);
         linenightsnum=(View)findViewById(R.id.linenightsnum);
         Vlblnightsnum=(TextView) findViewById(R.id.Vlblnightsnum);
         txtnightsnum=(EditText) findViewById(R.id.txtnightsnum);
         secnightsnumDK=(LinearLayout)findViewById(R.id.secnightsnumDK);
         linenightsnumDK=(View)findViewById(R.id.linenightsnumDK);
         VlblnightsnumDK=(TextView) findViewById(R.id.VlblnightsnumDK);
         chknightsnumDK=(CheckBox) findViewById(R.id.chknightsnumDK);
         secbnotif=(LinearLayout)findViewById(R.id.secbnotif);
         linebnotif=(View)findViewById(R.id.linebnotif);
         Vlblbnotif = (TextView) findViewById(R.id.Vlblbnotif);
         rdogrpbnotif = (RadioGroup) findViewById(R.id.rdogrpbnotif);
         
         rdobnotif1 = (RadioButton) findViewById(R.id.rdobnotif1);
         rdobnotif2 = (RadioButton) findViewById(R.id.rdobnotif2);
         rdobnotif3 = (RadioButton) findViewById(R.id.rdobnotif3);
         rdobnotif4 = (RadioButton) findViewById(R.id.rdobnotif4);
         rdogrpbnotif.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpbnotif = new String[] {"1","2","3","9"};
             for (int i = 0; i < rdogrpbnotif.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpbnotif.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpbnotif[i];
             }

             if(rbData.equalsIgnoreCase("3"))
             {
                    secbcert.setVisibility(View.GONE);
                    linebcert.setVisibility(View.GONE);
                    rdogrpbcert.clearCheck();
                    secbcertknow.setVisibility(View.GONE);
                    linebcertknow.setVisibility(View.GONE);
                    rdogrpbcertknow.clearCheck();
                    secbcerttime.setVisibility(View.GONE);
                    linebcerttime.setVisibility(View.GONE);
                    txtbcerttime.setText("");
                    secbcerttimeWM.setVisibility(View.GONE);
                    linebcerttimeWM.setVisibility(View.GONE);
                    rdogrpbcerttimeWM.clearCheck();
                    secanybcertcon.setVisibility(View.GONE);
                    lineanybcertcon.setVisibility(View.GONE);
                 //   spnanybcertcon.setSelection(0);
                 rdogrpanybcertcon.clearCheck();
                    secbcertcon.setVisibility(View.GONE);
                    linebcertcon.setVisibility(View.GONE);
                    //spnbcertcon.setSelection(0);
                 chkbcertcona.setChecked(false);
                 chkbcertconb.setChecked(false);
                 chkbcertconc.setChecked(false);
                 chkbcertcond.setChecked(false);
                 chkbcertcone.setChecked(false);
                    secbcertconOth.setVisibility(View.GONE);
                    linebcertconOth.setVisibility(View.GONE);
                    txtbcertconOth.setText("");
             }
             else
             {
                    secbcert.setVisibility(View.VISIBLE);
                    linebcert.setVisibility(View.VISIBLE);
                    secbcertknow.setVisibility(View.VISIBLE);
                    linebcertknow.setVisibility(View.VISIBLE);
                    secbcerttime.setVisibility(View.VISIBLE);
                    linebcerttime.setVisibility(View.VISIBLE);
                    secbcerttimeWM.setVisibility(View.VISIBLE);
                    linebcerttimeWM.setVisibility(View.VISIBLE);
                    secanybcertcon.setVisibility(View.VISIBLE);
                    lineanybcertcon.setVisibility(View.VISIBLE);
                    //secbcertcon.setVisibility(View.VISIBLE);
                    linebcertcon.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secbcert=(LinearLayout)findViewById(R.id.secbcert);
         linebcert=(View)findViewById(R.id.linebcert);
         Vlblbcert = (TextView) findViewById(R.id.Vlblbcert);
         rdogrpbcert = (RadioGroup) findViewById(R.id.rdogrpbcert);
         
         rdobcert1 = (RadioButton) findViewById(R.id.rdobcert1);
         rdobcert2 = (RadioButton) findViewById(R.id.rdobcert2);
         rdobcert3 = (RadioButton) findViewById(R.id.rdobcert3);
         rdogrpbcert.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpbcert = new String[] {"1","2","9"};
             for (int i = 0; i < rdogrpbcert.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpbcert.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpbcert[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                    secbcertknow.setVisibility(View.GONE);
                    linebcertknow.setVisibility(View.GONE);
                    rdogrpbcertknow.clearCheck();
                    secbcerttime.setVisibility(View.GONE);
                    linebcerttime.setVisibility(View.GONE);
                    txtbcerttime.setText("");
                    secbcerttimeWM.setVisibility(View.GONE);
                    linebcerttimeWM.setVisibility(View.GONE);
                    rdogrpbcerttimeWM.clearCheck();
                    secanybcertcon.setVisibility(View.GONE);
                    lineanybcertcon.setVisibility(View.GONE);
                    //spnanybcertcon.setSelection(0);
                 rdogrpanybcertcon.clearCheck();
                    secbcertcon.setVisibility(View.GONE);
                    linebcertcon.setVisibility(View.GONE);
                    //spnbcertcon.setSelection(0);
                 chkbcertcona.setChecked(false);
                 chkbcertconb.setChecked(false);
                 chkbcertconc.setChecked(false);
                 chkbcertcond.setChecked(false);
                 chkbcertcone.setChecked(false);
                    secbcertconOth.setVisibility(View.GONE);
                    linebcertconOth.setVisibility(View.GONE);
                    txtbcertconOth.setText("");
             }
             else
             {
                    secbcertknow.setVisibility(View.VISIBLE);
                    linebcertknow.setVisibility(View.VISIBLE);
                    secbcerttime.setVisibility(View.VISIBLE);
                    linebcerttime.setVisibility(View.VISIBLE);
                    secbcerttimeWM.setVisibility(View.VISIBLE);
                    linebcerttimeWM.setVisibility(View.VISIBLE);
                    secanybcertcon.setVisibility(View.VISIBLE);
                    lineanybcertcon.setVisibility(View.VISIBLE);
                    //secbcertcon.setVisibility(View.VISIBLE);
                    linebcertcon.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secbcertknow=(LinearLayout)findViewById(R.id.secbcertknow);
         linebcertknow=(View)findViewById(R.id.linebcertknow);
         Vlblbcertknow = (TextView) findViewById(R.id.Vlblbcertknow);
         rdogrpbcertknow = (RadioGroup) findViewById(R.id.rdogrpbcertknow);
         
         rdobcertknow1 = (RadioButton) findViewById(R.id.rdobcertknow1);
         rdobcertknow2 = (RadioButton) findViewById(R.id.rdobcertknow2);
         rdobcertknow3 = (RadioButton) findViewById(R.id.rdobcertknow3);
         secbcerttime=(LinearLayout)findViewById(R.id.secbcerttime);
         linebcerttime=(View)findViewById(R.id.linebcerttime);
         Vlblbcerttime=(TextView) findViewById(R.id.Vlblbcerttime);
         txtbcerttime=(EditText) findViewById(R.id.txtbcerttime);
         secbcerttimeWM=(LinearLayout)findViewById(R.id.secbcerttimeWM);
         linebcerttimeWM=(View)findViewById(R.id.linebcerttimeWM);
         VlblbcerttimeWM = (TextView) findViewById(R.id.VlblbcerttimeWM);
         rdogrpbcerttimeWM = (RadioGroup) findViewById(R.id.rdogrpbcerttimeWM);
         
         rdobcerttimeWM1 = (RadioButton) findViewById(R.id.rdobcerttimeWM1);
         rdobcerttimeWM2 = (RadioButton) findViewById(R.id.rdobcerttimeWM2);
         rdobcerttimeWM3 = (RadioButton) findViewById(R.id.rdobcerttimeWM3);
         secanybcertcon=(LinearLayout)findViewById(R.id.secanybcertcon);
         lineanybcertcon=(View)findViewById(R.id.lineanybcertcon);
         Vlblanybcertcon=(TextView) findViewById(R.id.Vlblanybcertcon);
         //spnanybcertcon=(Spinner) findViewById(R.id.spnanybcertcon);

         rdogrpanybcertcon = (RadioGroup)findViewById(R.id.rdogrpanybcertcon);
         rdoanybcertcon1 = (RadioButton)findViewById(R.id.rdoanybcertcon1);
         rdoanybcertcon2 = (RadioButton)findViewById(R.id.rdoanybcertcon2);
         rdoanybcertcon3 = (RadioButton)findViewById(R.id.rdoanybcertcon3);
         rdogrpanybcertcon.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(checkedId==R.id.rdoanybcertcon2 | checkedId==R.id.rdoanybcertcon3){
                     secbcertcon.setVisibility(View.GONE);
                     linebcertcon.setVisibility(View.GONE);
                     //spnbcertcon.setSelection(0);
                     chkbcertcona.setChecked(false);
                     chkbcertconb.setChecked(false);
                     chkbcertconc.setChecked(false);
                     chkbcertcond.setChecked(false);
                     chkbcertcone.setChecked(false);
                     secbcertconOth.setVisibility(View.GONE);
                     linebcertconOth.setVisibility(View.GONE);
                     txtbcertconOth.setText("");
                 }else
                 {
                     secbcertcon.setVisibility(View.VISIBLE);
                     linebcertcon.setVisibility(View.VISIBLE);
                 }
             }
         });



         /*List<String> listanybcertcon = new ArrayList<String>();
         
         listanybcertcon.add("");
         listanybcertcon.add("01-Yes");
         listanybcertcon.add("02-No");
         listanybcertcon.add("98-Don’t know/don’t remember");
         ArrayAdapter<String> adptranybcertcon= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listanybcertcon);
         spnanybcertcon.setAdapter(adptranybcertcon);

         spnanybcertcon.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             if (spnanybcertcon.getSelectedItem().toString().length() == 0) return;
             String spnData = Connection.SelectedSpinnerValue(spnanybcertcon.getSelectedItem().toString(),"-");
                 if(spnData.equalsIgnoreCase("02"))
                 {
                    secbcertcon.setVisibility(View.GONE);
                    linebcertcon.setVisibility(View.GONE);
                    //spnbcertcon.setSelection(0);
                     chkbcertcona.setChecked(false);
                     chkbcertconb.setChecked(false);
                     chkbcertconc.setChecked(false);
                     chkbcertcond.setChecked(false);
                     chkbcertcone.setChecked(false);
                    secbcertconOth.setVisibility(View.GONE);
                    linebcertconOth.setVisibility(View.GONE);
                    txtbcertconOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("98"))
                 {
                    secbcertcon.setVisibility(View.GONE);
                    linebcertcon.setVisibility(View.GONE);
                    //spnbcertcon.setSelection(0);
                     chkbcertcona.setChecked(false);
                     chkbcertconb.setChecked(false);
                     chkbcertconc.setChecked(false);
                     chkbcertcond.setChecked(false);
                     chkbcertcone.setChecked(false);

                    secbcertconOth.setVisibility(View.GONE);
                    linebcertconOth.setVisibility(View.GONE);
                    txtbcertconOth.setText("");
                 }
                 else
                 {
                    secbcertcon.setVisibility(View.VISIBLE);
                    linebcertcon.setVisibility(View.VISIBLE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });*/

         secbcertcon=(LinearLayout)findViewById(R.id.secbcertcon);
         linebcertcon=(View)findViewById(R.id.linebcertcon);
         Vlblbcertcon=(TextView) findViewById(R.id.Vlblbcertcon);
         //spnbcertcon=(Spinner) findViewById(R.id.spnbcertcon);
         chkbcertcona = (CheckBox)findViewById(R.id.chkbcertcona);
         chkbcertconb = (CheckBox)findViewById(R.id.chkbcertconb);
         chkbcertconc = (CheckBox)findViewById(R.id.chkbcertconc);
         chkbcertcond = (CheckBox)findViewById(R.id.chkbcertcond);
         chkbcertcone = (CheckBox)findViewById(R.id.chkbcertcone);
         chkbcertcond.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if ( isChecked )
                 {
                     secbcertconOth.setVisibility(View.VISIBLE);
                     linebcertconOth.setVisibility(View.VISIBLE);
                     chkbcertcone.setChecked(false);
                 }else{
                     secbcertconOth.setVisibility(View.GONE);
                     linebcertconOth.setVisibility(View.GONE);
                     txtbcertconOth.setText("");

                 }

             }
         });
         chkbcertcona.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if ( isChecked )
                 {
                     chkbcertcone.setChecked(false);
                 }
             }
         });
         chkbcertconb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if ( isChecked )
                 {
                     chkbcertcone.setChecked(false);
                 }
             }
         });
         chkbcertconc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if ( isChecked )
                 {
                     chkbcertcone.setChecked(false);
                 }
             }
         });
         chkbcertcone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if ( isChecked )
                 {
                     chkbcertcona.setChecked(false);
                     chkbcertconb.setChecked(false);
                     chkbcertconc.setChecked(false);
                     chkbcertcond.setChecked(false);
                 }
             }
         });


         //chkbcompJ
         chkbcompA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if ( isChecked )
                 {
                     chkbcompJ.setChecked(false);
                 }

             }
         });
         chkbcompB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if ( isChecked )
                 {
                     chkbcompJ.setChecked(false);
                 }

             }
         });
         chkbcompC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if ( isChecked )
                 {
                     chkbcompJ.setChecked(false);
                 }

             }
         });
         chkbcompD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if ( isChecked )
                 {
                     chkbcompJ.setChecked(false);
                 }

             }
         });
         chkbcompE.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if ( isChecked )
                 {
                     chkbcompJ.setChecked(false);
                 }

             }
         });
         chkbcompF.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if ( isChecked )
                 {
                     chkbcompJ.setChecked(false);
                 }

             }
         });
         chkbcompG.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if ( isChecked )
                 {
                     chkbcompJ.setChecked(false);
                 }

             }
         });
         chkbcompH.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if ( isChecked )
                 {
                     chkbcompJ.setChecked(false);
                 }

             }
         });

         chkbcompJ.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if ( isChecked )
                 {
                     chkbcompA.setChecked(false);
                     chkbcompB.setChecked(false);
                     chkbcompC.setChecked(false);
                     chkbcompD.setChecked(false);
                     chkbcompE.setChecked(false);
                     chkbcompF.setChecked(false);
                     chkbcompG.setChecked(false);
                     chkbcompH.setChecked(false);
                     chkbcompI.setChecked(false);
                 }

             }
         });






         /*List<String> listbcertcon = new ArrayList<String>();
         
         listbcertcon.add("");
         listbcertcon.add("01-Distance/too far");
         listbcertcon.add("02-Cost");
         listbcertcon.add("03-Not sure what to do");
         listbcertcon.add("04-Other");
         listbcertcon.add("98-Don’t know/don’t remember");
         ArrayAdapter<String> adptrbcertcon= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listbcertcon);
         spnbcertcon.setAdapter(adptrbcertcon);

         spnbcertcon.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             if (spnbcertcon.getSelectedItem().toString().length() == 0) return;
             String spnData = Connection.SelectedSpinnerValue(spnbcertcon.getSelectedItem().toString(),"-");
                 if(!spnData.equalsIgnoreCase("04"))
                 {
                    secbcertconOth.setVisibility(View.GONE);
                    linebcertconOth.setVisibility(View.GONE);
                    txtbcertconOth.setText("");
                 }
                 else
                 {
                    secbcertconOth.setVisibility(View.VISIBLE);
                    linebcertconOth.setVisibility(View.VISIBLE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });*/
         secbcertconOth=(LinearLayout)findViewById(R.id.secbcertconOth);
         linebcertconOth=(View)findViewById(R.id.linebcertconOth);
         VlblbcertconOth=(TextView) findViewById(R.id.VlblbcertconOth);
         txtbcertconOth=(EditText) findViewById(R.id.txtbcertconOth);


         dtpdoi.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpdoi.getRight() - dtpdoi.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btndoi"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });
         dtpEdd.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpEdd.getRight() - dtpEdd.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnEdd"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });
         dtpdelivdate.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpdelivdate.getRight() - dtpdelivdate.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btndelivdate"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });


         txttoi.setOnTouchListener(new View.OnTouchListener() {
         @Override
         public boolean onTouch(View v, MotionEvent event) {
             final int DRAWABLE_RIGHT = 2;
             if(event.getAction() == MotionEvent.ACTION_UP) {
                 if(event.getRawX() >= (txttoi.getRight() - txttoi.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                     VariableID = "btntoi"; showDialog(TIME_DIALOG);
                  return true;
                 }
             }
             return false;
           }
         });
         txtdelivtime.setOnTouchListener(new View.OnTouchListener() {
         @Override
         public boolean onTouch(View v, MotionEvent event) {
             final int DRAWABLE_RIGHT = 2;
             if(event.getAction() == MotionEvent.ACTION_UP) {
                 if(event.getRawX() >= (txtdelivtime.getRight() - txtdelivtime.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                     VariableID = "btndelivtime"; showDialog(TIME_DIALOG);
                  return true;
                 }
             }
             return false;
           }
         });

         rdogrpinterp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(rdointerp1.isChecked()){
                     secinterpName.setVisibility(View.VISIBLE);
                     seccconditionb.setVisibility(View.VISIBLE);
                     seclblsec12.setVisibility(View.VISIBLE);
                     seclblsec121.setVisibility(View.VISIBLE);
                     secmatconsent.setVisibility(View.VISIBLE);

                 }else if(rdointerp2.isChecked()){
                     secinterpName.setVisibility(View.GONE);
                     txtinterpName.setText("");

                     seccconditionb.setVisibility(View.GONE);
                     spncconditionb.setSelection(0);
                     seclblsec12.setVisibility(View.GONE);
                     seclblsec121.setVisibility(View.GONE);
                     secmatconsent.setVisibility(View.GONE);
                     rdogrpmatconsent.clearCheck();

                     secMatbdateM.setVisibility(View.GONE);
                     secMatbdateM1.setVisibility(View.GONE);
                     lineMatbdateM.setVisibility(View.GONE);
                     spnMatbdateM.setSelection(0);
                     secMatbdateY.setVisibility(View.GONE);
                     lineMatbdateY.setVisibility(View.GONE);
                     txtMatbdateY.setText("");
                     secMatbdateDK.setVisibility(View.GONE);
                     lineMatbdateDK.setVisibility(View.GONE);
                     chkMatbdateDK.setChecked(false);
                     secMatage.setVisibility(View.GONE);
                     lineMatage.setVisibility(View.GONE);
                     txtMatage.setText("");
                     seclblsec16.setVisibility(View.GONE);
                     linelblsec16.setVisibility(View.GONE);
                     secMatageDK.setVisibility(View.GONE);
                     lineMatageDK.setVisibility(View.GONE);
                     chkMatageDK.setChecked(false);

                     secFormEdu.setVisibility(View.GONE);
                     txtFormEdu.setText("");
                     secFormEduDK.setVisibility(View.GONE);
                     chkFormEduDK.setChecked(false);

                     secaddr1.setVisibility(View.GONE);
                     lineaddr1.setVisibility(View.GONE);
                     spnaddr1.setSelection(0);
                     secaddr2.setVisibility(View.GONE);
                     lineaddr2.setVisibility(View.GONE);
                     txtaddr2.setText("");
                     secaddr3.setVisibility(View.GONE);
                     lineaddr3.setVisibility(View.GONE);
                     txtaddr3.setText("");
                     secaddr4.setVisibility(View.GONE);
                     lineaddr4.setVisibility(View.GONE);
                     txtaddr4.setText("");
                     secAddressDetail.setVisibility(View.GONE);
                     lineAddressDetail.setVisibility(View.GONE);
                     txtAddressDetail.setText("");
                     secmatmobile.setVisibility(View.GONE);
                     linematmobile.setVisibility(View.GONE);
                     rdogrpmatmobile.clearCheck();
                     secMatmobnum.setVisibility(View.GONE);
                     lineMatmobnum.setVisibility(View.GONE);
                     txtMatmobnum.setText("");
                     secMatmobnumDK.setVisibility(View.GONE);
                     lineMatmobnumDK.setVisibility(View.GONE);
                     chkMatmobnumDK.setChecked(false);
                     secMatmobnum1.setVisibility(View.GONE);
                     lineMatmobnum1.setVisibility(View.GONE);
                     txtMatmobnum1.setText("");
                     secMatmobnum1DK.setVisibility(View.GONE);
                     lineMatmobnum1DK.setVisibility(View.GONE);
                     chkMatmobnum1DK.setChecked(false);
                     sechusmob.setVisibility(View.GONE);
                     linehusmob.setVisibility(View.GONE);
                     rdogrphusmob.clearCheck();
                     secHusmobnum.setVisibility(View.GONE);
                     lineHusmobnum.setVisibility(View.GONE);
                     txtHusmobnum.setText("");
                     secHusmobnumDK.setVisibility(View.GONE);
                     lineHusmobnumDK.setVisibility(View.GONE);
                     chkHusmobnumDK.setChecked(false);
                     secHusmobnum2.setVisibility(View.GONE);
                     lineHusmobnum2.setVisibility(View.GONE);
                     txtHusmobnum2.setText("");
                     secHusmobnum2DK.setVisibility(View.GONE);
                     lineHusmobnum2DK.setVisibility(View.GONE);
                     chkHusmobnum2DK.setChecked(false);
                     seccontact1.setVisibility(View.GONE);
                     linecontact1.setVisibility(View.GONE);
                     txtcontact1.setText("");
                     seclblsec13.setVisibility(View.GONE);
                     linelblsec13.setVisibility(View.GONE);
                     seceddknown.setVisibility(View.GONE);
                     lineeddknown.setVisibility(View.GONE);
                     rdogrpeddknown.clearCheck();
                     secEdd.setVisibility(View.GONE);
                     lineEdd.setVisibility(View.GONE);
                     dtpEdd.setText("");
                     secEddDK.setVisibility(View.GONE);
                     lineEddDK.setVisibility(View.GONE);
                     //chkEddDK.setChecked(false);
                     seclblsec17.setVisibility(View.GONE);
                     linelblsec17.setVisibility(View.GONE);
                     secGameth.setVisibility(View.GONE);
                     secGametha.setVisibility(View.GONE);
                     chkGametha.setChecked(false);
                     secGamethb.setVisibility(View.GONE);
                     chkGamethb.setChecked(false);
                     secGamethc.setVisibility(View.GONE);
                     chkGamethc.setChecked(false);
                     secGamethd.setVisibility(View.GONE);
                     chkGamethd.setChecked(false);
                     secGamethe.setVisibility(View.GONE);
                     chkGamethe.setChecked(false);
                     txtGametheOth.setText("");
                     secGamethf.setVisibility(View.GONE);
                     chkGamethf.setChecked(false);
                     //lineGameth.setVisibility(View.GONE);
                     //spnGameth.setSelection(0);
                     //secGamethOth.setVisibility(View.GONE);
                     //lineGamethOth.setVisibility(View.GONE);
                     //txtGamethOth.setText("");
                     secga1anc.setVisibility(View.GONE);
                     linega1anc.setVisibility(View.GONE);
                     txtga1anc.setText("");
                     secga1ancWM.setVisibility(View.GONE);
                     linega1ancWM.setVisibility(View.GONE);
                     rdogrpga1ancWM.clearCheck();
                     secantcarenum.setVisibility(View.GONE);
                     lineantcarenum.setVisibility(View.GONE);
                     spnantcarenum.setSelection(0);
                     secga.setVisibility(View.GONE);
                     linega.setVisibility(View.GONE);
                     txtga.setText("");
                     secgaWM.setVisibility(View.GONE);
                     linegaWM.setVisibility(View.GONE);
                     rdogrpgaWM.clearCheck();
                     seclblsec14.setVisibility(View.GONE);
                     linelblsec14.setVisibility(View.GONE);
                     secbheart.setVisibility(View.GONE);
                     linebheart.setVisibility(View.GONE);
                     rdogrpbheart.clearCheck();
                     secbcondition.setVisibility(View.GONE);
                     linebcondition.setVisibility(View.GONE);
                     //spnbcondition.setSelection(0);
                     rdogrpbcondition.clearCheck();
                     secplacedeliv.setVisibility(View.GONE);
                     lineplacedeliv.setVisibility(View.GONE);
                     rdogrpplacedeliv.clearCheck();
                     secplacedelivOth.setVisibility(View.GONE);
                     lineplacedelivOth.setVisibility(View.GONE);
                     txtplacedelivOth.setText("");
                     secdelivdate.setVisibility(View.GONE);
                     linedelivdate.setVisibility(View.GONE);
                     dtpdelivdate.setText("");
                     secdelivdateDK.setVisibility(View.GONE);
                     linedelivdateDK.setVisibility(View.GONE);
                     chkdelivdateDK.setChecked(false);
                     secdelivtime.setVisibility(View.GONE);
                     linedelivtime.setVisibility(View.GONE);
                     txtdelivtime.setText("");
                     secdelivtimeDK.setVisibility(View.GONE);
                     linedelivtimeDK.setVisibility(View.GONE);
                     chkdelivtimeDK.setChecked(false);
                     sectypebirth.setVisibility(View.GONE);
                     linetypebirth.setVisibility(View.GONE);
                     spntypebirth.setSelection(0);
                     seclblsec18.setVisibility(View.GONE);
                     linelblsec18.setVisibility(View.GONE);
                     secTimecsec.setVisibility(View.GONE);
                     lineTimecsec.setVisibility(View.GONE);
                     spnTimecsec.setSelection(0);
                     secToldcsecreas.setVisibility(View.GONE);
                     lineToldcsecreas.setVisibility(View.GONE);
                     rdogrpToldcsecreas.clearCheck();
                     secCsecreas.setVisibility(View.GONE);
                     lineCsecreas.setVisibility(View.GONE);
                     spnCsecreas.setSelection(0);
                     secOthReason.setVisibility(View.GONE);
                     lineOthReason.setVisibility(View.GONE);
                     txtOthReason.setText("");
                     secBwgted.setVisibility(View.GONE);
                     lineBwgted.setVisibility(View.GONE);
                     rdogrpBwgted.clearCheck();
                     secBwgt.setVisibility(View.GONE);
                     lineBwgt.setVisibility(View.GONE);
                     txtBwgt.setText("");
                     secBwgtDK.setVisibility(View.GONE);
                     lineBwgtDK.setVisibility(View.GONE);
                     rdogrpBwgtDK.clearCheck();
                     secbwgtmeth.setVisibility(View.GONE);
                     linebwgtmeth.setVisibility(View.GONE);
                     rdogrpbwgtmeth.clearCheck();
                     secBsex.setVisibility(View.GONE);
                     lineBsex.setVisibility(View.GONE);
                     spnBsex.setSelection(0);
                     secperceivesize.setVisibility(View.GONE);
                     lineperceivesize.setVisibility(View.GONE);
                     spnperceivesize.setSelection(0);
                     secanybcomp.setVisibility(View.GONE);
                     lineanybcomp.setVisibility(View.GONE);
                     rdogrpanybcomp.clearCheck();
                     seclblsec15.setVisibility(View.GONE);
                     linelblsec15.setVisibility(View.GONE);
                     secbcompA.setVisibility(View.GONE);
                     linebcompA.setVisibility(View.GONE);
                     chkbcompA.setChecked(false);
                     secbcompB.setVisibility(View.GONE);
                     linebcompB.setVisibility(View.GONE);
                     chkbcompB.setChecked(false);
                     secbcompC.setVisibility(View.GONE);
                     linebcompC.setVisibility(View.GONE);
                     chkbcompC.setChecked(false);
                     secbcompD.setVisibility(View.GONE);
                     linebcompD.setVisibility(View.GONE);
                     chkbcompD.setChecked(false);
                     secbcompE.setVisibility(View.GONE);
                     linebcompE.setVisibility(View.GONE);
                     chkbcompE.setChecked(false);
                     secbcompF.setVisibility(View.GONE);
                     linebcompF.setVisibility(View.GONE);
                     chkbcompF.setChecked(false);
                     secbcompG.setVisibility(View.GONE);
                     linebcompG.setVisibility(View.GONE);
                     chkbcompG.setChecked(false);
                     secbcompH.setVisibility(View.GONE);
                     linebcompH.setVisibility(View.GONE);
                     chkbcompH.setChecked(false);
                     secbcompI.setVisibility(View.GONE);
                     linebcompI.setVisibility(View.GONE);
                     chkbcompI.setChecked(false);
                     secbcompIOth.setVisibility(View.GONE);
                     linebcompIOth.setVisibility(View.GONE);
                     txtbcompIOth.setText("");
                     secbcompJ.setVisibility(View.GONE);
                     linebcompJ.setVisibility(View.GONE);
                     chkbcompJ.setChecked(false);
                     secnightsnum.setVisibility(View.GONE);
                     linenightsnum.setVisibility(View.GONE);
                     txtnightsnum.setText("");
                     secnightsnumDK.setVisibility(View.GONE);
                     linenightsnumDK.setVisibility(View.GONE);
                     chknightsnumDK.setChecked(false);
                     secbnotif.setVisibility(View.GONE);
                     linebnotif.setVisibility(View.GONE);
                     rdogrpbnotif.clearCheck();
                     secbcert.setVisibility(View.GONE);
                     linebcert.setVisibility(View.GONE);
                     rdogrpbcert.clearCheck();
                     secbcertknow.setVisibility(View.GONE);
                     linebcertknow.setVisibility(View.GONE);
                     rdogrpbcertknow.clearCheck();
                     secbcerttime.setVisibility(View.GONE);
                     linebcerttime.setVisibility(View.GONE);
                     txtbcerttime.setText("");
                     secbcerttimeWM.setVisibility(View.GONE);
                     linebcerttimeWM.setVisibility(View.GONE);
                     rdogrpbcerttimeWM.clearCheck();
                     secanybcertcon.setVisibility(View.GONE);
                     lineanybcertcon.setVisibility(View.GONE);
                     //   spnanybcertcon.setSelection(0);
                     rdogrpanybcertcon.clearCheck();
                     secbcertcon.setVisibility(View.GONE);
                     linebcertcon.setVisibility(View.GONE);
                     //spnbcertcon.setSelection(0);
                     chkbcertcona.setChecked(false);
                     chkbcertconb.setChecked(false);
                     chkbcertconc.setChecked(false);
                     chkbcertcond.setChecked(false);
                     chkbcertcone.setChecked(false);
                     secbcertconOth.setVisibility(View.GONE);
                     linebcertconOth.setVisibility(View.GONE);
                     txtbcertconOth.setText("");
                 }
             }
         });


         //Hide all skip variables
         secinterp.setVisibility(View.GONE);
         secinterpName.setVisibility(View.GONE);
         seclangOth.setVisibility(View.GONE);
         secbcertcon.setVisibility(View.GONE);
         secConsentFollo.setVisibility(View.GONE);
         lineConsentFollo.setVisibility(View.GONE);
         seclblsec11.setVisibility(View.GONE);
         linelblsec11.setVisibility(View.GONE);
         secdoi.setVisibility(View.GONE);
         linedoi.setVisibility(View.GONE);
         sectoi.setVisibility(View.GONE);
         linetoi.setVisibility(View.GONE);
         seclang.setVisibility(View.GONE);
         linelang.setVisibility(View.GONE);
         seccconditionb.setVisibility(View.GONE);
         linecconditionb.setVisibility(View.GONE);
         seclblsec12.setVisibility(View.GONE);
         seclblsec121.setVisibility(View.GONE);
         linelblsec12.setVisibility(View.GONE);
         secmatconsent.setVisibility(View.GONE);
         linematconsent.setVisibility(View.GONE);
         secMatbdateM.setVisibility(View.GONE);
          secMatbdateM1.setVisibility(View.GONE);
         lineMatbdateM.setVisibility(View.GONE);
         secMatbdateY.setVisibility(View.GONE);
         lineMatbdateY.setVisibility(View.GONE);
         secMatbdateDK.setVisibility(View.GONE);
         lineMatbdateDK.setVisibility(View.GONE);
         secMatage.setVisibility(View.GONE);
         lineMatage.setVisibility(View.GONE);
         seclblsec16.setVisibility(View.GONE);
         linelblsec16.setVisibility(View.GONE);
         secMatageDK.setVisibility(View.GONE);
         lineMatageDK.setVisibility(View.GONE);
         secaddr1.setVisibility(View.GONE);
         lineaddr1.setVisibility(View.GONE);
         secaddr2.setVisibility(View.GONE);
         lineaddr2.setVisibility(View.GONE);
         secaddr3.setVisibility(View.GONE);
         lineaddr3.setVisibility(View.GONE);
         secaddr4.setVisibility(View.GONE);
         lineaddr4.setVisibility(View.GONE);
         secAddressDetail.setVisibility(View.GONE);
         lineAddressDetail.setVisibility(View.GONE);
         secmatmobile.setVisibility(View.GONE);
         linematmobile.setVisibility(View.GONE);
         secMatmobnum.setVisibility(View.GONE);
         lineMatmobnum.setVisibility(View.GONE);
         secMatmobnumDK.setVisibility(View.GONE);
         lineMatmobnumDK.setVisibility(View.GONE);
         secMatmobnum1.setVisibility(View.GONE);
         lineMatmobnum1.setVisibility(View.GONE);
         secMatmobnum1DK.setVisibility(View.GONE);
         lineMatmobnum1DK.setVisibility(View.GONE);
         sechusmob.setVisibility(View.GONE);
         linehusmob.setVisibility(View.GONE);
         secHusmobnum.setVisibility(View.GONE);
         lineHusmobnum.setVisibility(View.GONE);
         secHusmobnumDK.setVisibility(View.GONE);
         lineHusmobnumDK.setVisibility(View.GONE);
         secHusmobnum2.setVisibility(View.GONE);
         lineHusmobnum2.setVisibility(View.GONE);
         secHusmobnum2DK.setVisibility(View.GONE);
         lineHusmobnum2DK.setVisibility(View.GONE);
         seccontact1.setVisibility(View.GONE);
         linecontact1.setVisibility(View.GONE);
         seclblsec13.setVisibility(View.GONE);
         linelblsec13.setVisibility(View.GONE);
         seceddknown.setVisibility(View.GONE);
         lineeddknown.setVisibility(View.GONE);
         secEdd.setVisibility(View.GONE);
         lineEdd.setVisibility(View.GONE);
         secEddDK.setVisibility(View.GONE);
         secEddDKOth.setVisibility(View.GONE);
         lineEddDK.setVisibility(View.GONE);
         seclblsec17.setVisibility(View.GONE);
         linelblsec17.setVisibility(View.GONE);
         secGameth.setVisibility(View.GONE);

          secGametha.setVisibility(View.GONE);
          chkGametha.setChecked(false);
          secGamethb.setVisibility(View.GONE);
          chkGamethb.setChecked(false);
          secGamethc.setVisibility(View.GONE);
          chkGamethc.setChecked(false);
          secGamethd.setVisibility(View.GONE);
          chkGamethd.setChecked(false);
          secGamethe.setVisibility(View.GONE);
          chkGamethe.setChecked(false);
          txtGametheOth.setText("");
          secGamethf.setVisibility(View.GONE);
          chkGamethf.setChecked(false);
         //lineGameth.setVisibility(View.GONE);
         //secGamethOth.setVisibility(View.GONE);
         //lineGamethOth.setVisibility(View.GONE);
         secga1anc.setVisibility(View.GONE);
         linega1anc.setVisibility(View.GONE);
         secga1ancWM.setVisibility(View.GONE);
         linega1ancWM.setVisibility(View.GONE);
         secantcarenum.setVisibility(View.GONE);
         lineantcarenum.setVisibility(View.GONE);
         secga.setVisibility(View.GONE);
         linega.setVisibility(View.GONE);
         secgaWM.setVisibility(View.GONE);
         linegaWM.setVisibility(View.GONE);
         seclblsec14.setVisibility(View.GONE);
         linelblsec14.setVisibility(View.GONE);
         secbheart.setVisibility(View.GONE);
         linebheart.setVisibility(View.GONE);
         secbcondition.setVisibility(View.GONE);
         linebcondition.setVisibility(View.GONE);
         secplacedeliv.setVisibility(View.GONE);
         lineplacedeliv.setVisibility(View.GONE);
         secplacedelivOth.setVisibility(View.GONE);
         lineplacedelivOth.setVisibility(View.GONE);
         secdelivdate.setVisibility(View.GONE);
         linedelivdate.setVisibility(View.GONE);
         secdelivdateDK.setVisibility(View.GONE);
         linedelivdateDK.setVisibility(View.GONE);
         secdelivtime.setVisibility(View.GONE);
         linedelivtime.setVisibility(View.GONE);
         secdelivtimeDK.setVisibility(View.GONE);
         linedelivtimeDK.setVisibility(View.GONE);
         sectypebirth.setVisibility(View.GONE);
         linetypebirth.setVisibility(View.GONE);
         seclblsec18.setVisibility(View.GONE);
         linelblsec18.setVisibility(View.GONE);
         secTimecsec.setVisibility(View.GONE);
         lineTimecsec.setVisibility(View.GONE);
         secToldcsecreas.setVisibility(View.GONE);
         lineToldcsecreas.setVisibility(View.GONE);
         secCsecreas.setVisibility(View.GONE);
         lineCsecreas.setVisibility(View.GONE);
         secOthReason.setVisibility(View.GONE);
         lineOthReason.setVisibility(View.GONE);
         secBwgted.setVisibility(View.GONE);
         lineBwgted.setVisibility(View.GONE);
         secBwgt.setVisibility(View.GONE);
         lineBwgt.setVisibility(View.GONE);
         secBwgtDK.setVisibility(View.GONE);
         lineBwgtDK.setVisibility(View.GONE);
         secbwgtmeth.setVisibility(View.GONE);
         linebwgtmeth.setVisibility(View.GONE);
         secBsex.setVisibility(View.GONE);
         lineBsex.setVisibility(View.GONE);
         secperceivesize.setVisibility(View.GONE);
         lineperceivesize.setVisibility(View.GONE);
         secanybcomp.setVisibility(View.GONE);
         lineanybcomp.setVisibility(View.GONE);
         seclblsec15.setVisibility(View.GONE);
         linelblsec15.setVisibility(View.GONE);
         secbcompA.setVisibility(View.GONE);
         linebcompA.setVisibility(View.GONE);
         secbcompB.setVisibility(View.GONE);
         linebcompB.setVisibility(View.GONE);
         secbcompC.setVisibility(View.GONE);
         linebcompC.setVisibility(View.GONE);
         secbcompD.setVisibility(View.GONE);
         linebcompD.setVisibility(View.GONE);
         secbcompE.setVisibility(View.GONE);
         linebcompE.setVisibility(View.GONE);
         secbcompF.setVisibility(View.GONE);
         linebcompF.setVisibility(View.GONE);
         secbcompG.setVisibility(View.GONE);
         linebcompG.setVisibility(View.GONE);
         secbcompH.setVisibility(View.GONE);
         linebcompH.setVisibility(View.GONE);
         secbcompI.setVisibility(View.GONE);
         linebcompI.setVisibility(View.GONE);
         secbcompIOth.setVisibility(View.GONE);
         linebcompIOth.setVisibility(View.GONE);
         secbcompJ.setVisibility(View.GONE);
         linebcompJ.setVisibility(View.GONE);
         secnightsnum.setVisibility(View.GONE);
         linenightsnum.setVisibility(View.GONE);
         secnightsnumDK.setVisibility(View.GONE);
         linenightsnumDK.setVisibility(View.GONE);
         secbnotif.setVisibility(View.GONE);
         linebnotif.setVisibility(View.GONE);
         secbcert.setVisibility(View.GONE);
         linebcert.setVisibility(View.GONE);
         secbcertknow.setVisibility(View.GONE);
         linebcertknow.setVisibility(View.GONE);
         secbcerttime.setVisibility(View.GONE);
         linebcerttime.setVisibility(View.GONE);
         secbcerttimeWM.setVisibility(View.GONE);
         linebcerttimeWM.setVisibility(View.GONE);
         secanybcertcon.setVisibility(View.GONE);
         lineanybcertcon.setVisibility(View.GONE);
         secbcertcon.setVisibility(View.GONE);
         linebcertcon.setVisibility(View.GONE);
         secbcertconOth.setVisibility(View.GONE);
         linebcertconOth.setVisibility(View.GONE);
         secMatbdateM.setVisibility(View.GONE);
         lineMatbdateM.setVisibility(View.GONE);
         secMatbdateY.setVisibility(View.GONE);
         lineMatbdateY.setVisibility(View.GONE);
         secMatbdateDK.setVisibility(View.GONE);
         lineMatbdateDK.setVisibility(View.GONE);
         secMatage.setVisibility(View.GONE);
         lineMatage.setVisibility(View.GONE);
         seclblsec16.setVisibility(View.GONE);
         linelblsec16.setVisibility(View.GONE);
         secMatageDK.setVisibility(View.GONE);
         lineMatageDK.setVisibility(View.GONE);
         secaddr1.setVisibility(View.GONE);
         lineaddr1.setVisibility(View.GONE);
         secaddr2.setVisibility(View.GONE);
         lineaddr2.setVisibility(View.GONE);
         secaddr3.setVisibility(View.GONE);
         lineaddr3.setVisibility(View.GONE);
         secaddr4.setVisibility(View.GONE);
         lineaddr4.setVisibility(View.GONE);
         secAddressDetail.setVisibility(View.GONE);
         lineAddressDetail.setVisibility(View.GONE);
         secmatmobile.setVisibility(View.GONE);
         linematmobile.setVisibility(View.GONE);
         secMatmobnum.setVisibility(View.GONE);
         lineMatmobnum.setVisibility(View.GONE);
         secMatmobnumDK.setVisibility(View.GONE);
         lineMatmobnumDK.setVisibility(View.GONE);
         secMatmobnum1.setVisibility(View.GONE);
         lineMatmobnum1.setVisibility(View.GONE);
         secMatmobnum1DK.setVisibility(View.GONE);
         lineMatmobnum1DK.setVisibility(View.GONE);
         sechusmob.setVisibility(View.GONE);
         linehusmob.setVisibility(View.GONE);
         secHusmobnum.setVisibility(View.GONE);
         lineHusmobnum.setVisibility(View.GONE);
         secHusmobnumDK.setVisibility(View.GONE);
         lineHusmobnumDK.setVisibility(View.GONE);
         secHusmobnum2.setVisibility(View.GONE);
         lineHusmobnum2.setVisibility(View.GONE);
         secHusmobnum2DK.setVisibility(View.GONE);
         lineHusmobnum2DK.setVisibility(View.GONE);
         seccontact1.setVisibility(View.GONE);
         linecontact1.setVisibility(View.GONE);
         seclblsec13.setVisibility(View.GONE);
         linelblsec13.setVisibility(View.GONE);
         seceddknown.setVisibility(View.GONE);
         lineeddknown.setVisibility(View.GONE);
         secEdd.setVisibility(View.GONE);
         lineEdd.setVisibility(View.GONE);
         secEddDK.setVisibility(View.GONE);
         secEddDKOth.setVisibility(View.GONE);
         lineEddDK.setVisibility(View.GONE);
         seclblsec17.setVisibility(View.GONE);
         linelblsec17.setVisibility(View.GONE);
         secGameth.setVisibility(View.GONE);
         //lineGameth.setVisibility(View.GONE);
         //secGamethOth.setVisibility(View.GONE);
         //lineGamethOth.setVisibility(View.GONE);
         secga1anc.setVisibility(View.GONE);
         linega1anc.setVisibility(View.GONE);
         secga1ancWM.setVisibility(View.GONE);
         linega1ancWM.setVisibility(View.GONE);
         secantcarenum.setVisibility(View.GONE);
         lineantcarenum.setVisibility(View.GONE);
         secga.setVisibility(View.GONE);
         linega.setVisibility(View.GONE);
         secgaWM.setVisibility(View.GONE);
         linegaWM.setVisibility(View.GONE);
         seclblsec14.setVisibility(View.GONE);
         linelblsec14.setVisibility(View.GONE);
         secbheart.setVisibility(View.GONE);
         linebheart.setVisibility(View.GONE);
         secbcondition.setVisibility(View.GONE);
         linebcondition.setVisibility(View.GONE);
         secplacedeliv.setVisibility(View.GONE);
         lineplacedeliv.setVisibility(View.GONE);
         secplacedelivOth.setVisibility(View.GONE);
         lineplacedelivOth.setVisibility(View.GONE);
         secdelivdate.setVisibility(View.GONE);
         linedelivdate.setVisibility(View.GONE);
         secdelivdateDK.setVisibility(View.GONE);
         linedelivdateDK.setVisibility(View.GONE);
         secdelivtime.setVisibility(View.GONE);
         linedelivtime.setVisibility(View.GONE);
         secdelivtimeDK.setVisibility(View.GONE);
         linedelivtimeDK.setVisibility(View.GONE);
         sectypebirth.setVisibility(View.GONE);
         linetypebirth.setVisibility(View.GONE);
         seclblsec18.setVisibility(View.GONE);
         linelblsec18.setVisibility(View.GONE);
         secTimecsec.setVisibility(View.GONE);
         lineTimecsec.setVisibility(View.GONE);
         secToldcsecreas.setVisibility(View.GONE);
         lineToldcsecreas.setVisibility(View.GONE);
         secCsecreas.setVisibility(View.GONE);
         lineCsecreas.setVisibility(View.GONE);
         secOthReason.setVisibility(View.GONE);
         lineOthReason.setVisibility(View.GONE);
         secBwgted.setVisibility(View.GONE);
         lineBwgted.setVisibility(View.GONE);
         secBwgt.setVisibility(View.GONE);
         lineBwgt.setVisibility(View.GONE);
         secBwgtDK.setVisibility(View.GONE);
         lineBwgtDK.setVisibility(View.GONE);
         secbwgtmeth.setVisibility(View.GONE);
         linebwgtmeth.setVisibility(View.GONE);
         secBsex.setVisibility(View.GONE);
         lineBsex.setVisibility(View.GONE);
         secperceivesize.setVisibility(View.GONE);
         lineperceivesize.setVisibility(View.GONE);
         secanybcomp.setVisibility(View.GONE);
         lineanybcomp.setVisibility(View.GONE);
         seclblsec15.setVisibility(View.GONE);
         linelblsec15.setVisibility(View.GONE);
         secbcompA.setVisibility(View.GONE);
         linebcompA.setVisibility(View.GONE);
         secbcompB.setVisibility(View.GONE);
         linebcompB.setVisibility(View.GONE);
         secbcompC.setVisibility(View.GONE);
         linebcompC.setVisibility(View.GONE);
         secbcompD.setVisibility(View.GONE);
         linebcompD.setVisibility(View.GONE);
         secbcompE.setVisibility(View.GONE);
         linebcompE.setVisibility(View.GONE);
         secbcompF.setVisibility(View.GONE);
         linebcompF.setVisibility(View.GONE);
         secbcompG.setVisibility(View.GONE);
         linebcompG.setVisibility(View.GONE);
         secbcompH.setVisibility(View.GONE);
         linebcompH.setVisibility(View.GONE);
         secbcompI.setVisibility(View.GONE);
         linebcompI.setVisibility(View.GONE);
         secbcompIOth.setVisibility(View.GONE);
         linebcompIOth.setVisibility(View.GONE);
         secbcompJ.setVisibility(View.GONE);
         linebcompJ.setVisibility(View.GONE);
         secnightsnum.setVisibility(View.GONE);
         linenightsnum.setVisibility(View.GONE);
         secnightsnumDK.setVisibility(View.GONE);
         linenightsnumDK.setVisibility(View.GONE);
         secbnotif.setVisibility(View.GONE);
         linebnotif.setVisibility(View.GONE);
         secbcert.setVisibility(View.GONE);
         linebcert.setVisibility(View.GONE);
         secbcertknow.setVisibility(View.GONE);
         linebcertknow.setVisibility(View.GONE);
         secbcerttime.setVisibility(View.GONE);
         linebcerttime.setVisibility(View.GONE);
         secbcerttimeWM.setVisibility(View.GONE);
         linebcerttimeWM.setVisibility(View.GONE);
         secanybcertcon.setVisibility(View.GONE);
         lineanybcertcon.setVisibility(View.GONE);
         secbcertcon.setVisibility(View.GONE);
         linebcertcon.setVisibility(View.GONE);
         secbcertconOth.setVisibility(View.GONE);
         linebcertconOth.setVisibility(View.GONE);
         secMatmobnum.setVisibility(View.GONE);
         lineMatmobnum.setVisibility(View.GONE);
         secMatmobnumDK.setVisibility(View.GONE);
         lineMatmobnumDK.setVisibility(View.GONE);
         secMatmobnum1.setVisibility(View.GONE);
         lineMatmobnum1.setVisibility(View.GONE);
         secMatmobnum1DK.setVisibility(View.GONE);
         lineMatmobnum1DK.setVisibility(View.GONE);
         secHusmobnum.setVisibility(View.GONE);
         lineHusmobnum.setVisibility(View.GONE);
         secHusmobnumDK.setVisibility(View.GONE);
         lineHusmobnumDK.setVisibility(View.GONE);
         secHusmobnum2.setVisibility(View.GONE);
         lineHusmobnum2.setVisibility(View.GONE);
         secHusmobnum2DK.setVisibility(View.GONE);
         lineHusmobnum2DK.setVisibility(View.GONE);
         secEdd.setVisibility(View.GONE);
         lineEdd.setVisibility(View.GONE);
         secEddDK.setVisibility(View.GONE);
         secEddDKOth.setVisibility(View.GONE);
         lineEddDK.setVisibility(View.GONE);
         seclblsec17.setVisibility(View.GONE);
         linelblsec17.setVisibility(View.GONE);
         secEdd.setVisibility(View.GONE);
         lineEdd.setVisibility(View.GONE);
         secEddDK.setVisibility(View.GONE);
         lineEddDK.setVisibility(View.GONE);
         seclblsec17.setVisibility(View.GONE);
         linelblsec17.setVisibility(View.GONE);

          secGametha.setVisibility(View.GONE);
          chkGametha.setChecked(false);
          secGamethb.setVisibility(View.GONE);
          chkGamethb.setChecked(false);
          secGamethc.setVisibility(View.GONE);
          chkGamethc.setChecked(false);
          secGamethd.setVisibility(View.GONE);
          chkGamethd.setChecked(false);
          secGamethe.setVisibility(View.GONE);
          chkGamethe.setChecked(false);
          txtGametheOth.setText("");
          secGamethf.setVisibility(View.GONE);
          chkGamethf.setChecked(false);
         /*secGamethOth.setVisibility(View.GONE);
         lineGamethOth.setVisibility(View.GONE);
         secGamethOth.setVisibility(View.GONE);
         lineGamethOth.setVisibility(View.GONE);
         secGamethOth.setVisibility(View.GONE);
         lineGamethOth.setVisibility(View.GONE);
         secGamethOth.setVisibility(View.GONE);
         lineGamethOth.setVisibility(View.GONE);
         secGamethOth.setVisibility(View.GONE);
         lineGamethOth.setVisibility(View.GONE);*/
         secbcondition.setVisibility(View.GONE);
         linebcondition.setVisibility(View.GONE);
         secbcondition.setVisibility(View.GONE);
         linebcondition.setVisibility(View.GONE);
         secplacedelivOth.setVisibility(View.GONE);
         lineplacedelivOth.setVisibility(View.GONE);
         secplacedelivOth.setVisibility(View.GONE);
         lineplacedelivOth.setVisibility(View.GONE);
         secplacedelivOth.setVisibility(View.GONE);
         lineplacedelivOth.setVisibility(View.GONE);
         seclblsec18.setVisibility(View.GONE);
         linelblsec18.setVisibility(View.GONE);
         secTimecsec.setVisibility(View.GONE);
         lineTimecsec.setVisibility(View.GONE);
         secToldcsecreas.setVisibility(View.GONE);
         lineToldcsecreas.setVisibility(View.GONE);
         secCsecreas.setVisibility(View.GONE);
         lineCsecreas.setVisibility(View.GONE);
         secOthReason.setVisibility(View.GONE);
         lineOthReason.setVisibility(View.GONE);
         seclblsec18.setVisibility(View.GONE);
         linelblsec18.setVisibility(View.GONE);
         secTimecsec.setVisibility(View.GONE);
         lineTimecsec.setVisibility(View.GONE);
         secToldcsecreas.setVisibility(View.GONE);
         lineToldcsecreas.setVisibility(View.GONE);
         secCsecreas.setVisibility(View.GONE);
         lineCsecreas.setVisibility(View.GONE);
         secOthReason.setVisibility(View.GONE);
         lineOthReason.setVisibility(View.GONE);
         seclblsec18.setVisibility(View.GONE);
         linelblsec18.setVisibility(View.GONE);
         secTimecsec.setVisibility(View.GONE);
         lineTimecsec.setVisibility(View.GONE);
         secToldcsecreas.setVisibility(View.GONE);
         lineToldcsecreas.setVisibility(View.GONE);
         secCsecreas.setVisibility(View.GONE);
         lineCsecreas.setVisibility(View.GONE);
         secOthReason.setVisibility(View.GONE);
         lineOthReason.setVisibility(View.GONE);
         seclblsec18.setVisibility(View.GONE);
         linelblsec18.setVisibility(View.GONE);
         secTimecsec.setVisibility(View.GONE);
         lineTimecsec.setVisibility(View.GONE);
         secToldcsecreas.setVisibility(View.GONE);
         lineToldcsecreas.setVisibility(View.GONE);
         secCsecreas.setVisibility(View.GONE);
         lineCsecreas.setVisibility(View.GONE);
         secOthReason.setVisibility(View.GONE);
         lineOthReason.setVisibility(View.GONE);
         seclblsec18.setVisibility(View.GONE);
         linelblsec18.setVisibility(View.GONE);
         secTimecsec.setVisibility(View.GONE);
         lineTimecsec.setVisibility(View.GONE);
         secToldcsecreas.setVisibility(View.GONE);
         lineToldcsecreas.setVisibility(View.GONE);
         secCsecreas.setVisibility(View.GONE);
         lineCsecreas.setVisibility(View.GONE);
         secOthReason.setVisibility(View.GONE);
         lineOthReason.setVisibility(View.GONE);
         secCsecreas.setVisibility(View.GONE);
         lineCsecreas.setVisibility(View.GONE);
         secOthReason.setVisibility(View.GONE);
         lineOthReason.setVisibility(View.GONE);
         secCsecreas.setVisibility(View.GONE);
         lineCsecreas.setVisibility(View.GONE);
         secOthReason.setVisibility(View.GONE);
         lineOthReason.setVisibility(View.GONE);
         secOthReason.setVisibility(View.GONE);
         lineOthReason.setVisibility(View.GONE);
         secOthReason.setVisibility(View.GONE);
         lineOthReason.setVisibility(View.GONE);
         secOthReason.setVisibility(View.GONE);
         lineOthReason.setVisibility(View.GONE);
         secOthReason.setVisibility(View.GONE);
         lineOthReason.setVisibility(View.GONE);
         secOthReason.setVisibility(View.GONE);
         lineOthReason.setVisibility(View.GONE);
         secOthReason.setVisibility(View.GONE);
         lineOthReason.setVisibility(View.GONE);
         secOthReason.setVisibility(View.GONE);
         lineOthReason.setVisibility(View.GONE);
         secBwgt.setVisibility(View.GONE);
         lineBwgt.setVisibility(View.GONE);
         secBwgtDK.setVisibility(View.GONE);
         lineBwgtDK.setVisibility(View.GONE);
         secBwgt.setVisibility(View.GONE);
         lineBwgt.setVisibility(View.GONE);
         secBwgtDK.setVisibility(View.GONE);
         lineBwgtDK.setVisibility(View.GONE);
         seclblsec15.setVisibility(View.GONE);
         linelblsec15.setVisibility(View.GONE);
         secbcompA.setVisibility(View.GONE);
         linebcompA.setVisibility(View.GONE);
         secbcompB.setVisibility(View.GONE);
         linebcompB.setVisibility(View.GONE);
         secbcompC.setVisibility(View.GONE);
         linebcompC.setVisibility(View.GONE);
         secbcompD.setVisibility(View.GONE);
         linebcompD.setVisibility(View.GONE);
         secbcompE.setVisibility(View.GONE);
         linebcompE.setVisibility(View.GONE);
         secbcompF.setVisibility(View.GONE);
         linebcompF.setVisibility(View.GONE);
         secbcompG.setVisibility(View.GONE);
         linebcompG.setVisibility(View.GONE);
         secbcompH.setVisibility(View.GONE);
         linebcompH.setVisibility(View.GONE);
         secbcompI.setVisibility(View.GONE);
         linebcompI.setVisibility(View.GONE);
         secbcompIOth.setVisibility(View.GONE);
         linebcompIOth.setVisibility(View.GONE);
         secbcompJ.setVisibility(View.GONE);
         linebcompJ.setVisibility(View.GONE);
         seclblsec15.setVisibility(View.GONE);
         linelblsec15.setVisibility(View.GONE);
         secbcompA.setVisibility(View.GONE);
         linebcompA.setVisibility(View.GONE);
         secbcompB.setVisibility(View.GONE);
         linebcompB.setVisibility(View.GONE);
         secbcompC.setVisibility(View.GONE);
         linebcompC.setVisibility(View.GONE);
         secbcompD.setVisibility(View.GONE);
         linebcompD.setVisibility(View.GONE);
         secbcompE.setVisibility(View.GONE);
         linebcompE.setVisibility(View.GONE);
         secbcompF.setVisibility(View.GONE);
         linebcompF.setVisibility(View.GONE);
         secbcompG.setVisibility(View.GONE);
         linebcompG.setVisibility(View.GONE);
         secbcompH.setVisibility(View.GONE);
         linebcompH.setVisibility(View.GONE);
         secbcompI.setVisibility(View.GONE);
         linebcompI.setVisibility(View.GONE);
         secbcompIOth.setVisibility(View.GONE);
         linebcompIOth.setVisibility(View.GONE);
         secbcompJ.setVisibility(View.GONE);
         linebcompJ.setVisibility(View.GONE);
         secbcompIOth.setVisibility(View.GONE);
         linebcompIOth.setVisibility(View.GONE);
         secbcert.setVisibility(View.GONE);
         linebcert.setVisibility(View.GONE);
         secbcertknow.setVisibility(View.GONE);
         linebcertknow.setVisibility(View.GONE);
         secbcerttime.setVisibility(View.GONE);
         linebcerttime.setVisibility(View.GONE);
         secbcerttimeWM.setVisibility(View.GONE);
         linebcerttimeWM.setVisibility(View.GONE);
         secanybcertcon.setVisibility(View.GONE);
         lineanybcertcon.setVisibility(View.GONE);
         secbcertcon.setVisibility(View.GONE);
         linebcertcon.setVisibility(View.GONE);
         secbcertconOth.setVisibility(View.GONE);
         linebcertconOth.setVisibility(View.GONE);
         secbcertknow.setVisibility(View.GONE);

         linebcertknow.setVisibility(View.GONE);
         secbcerttime.setVisibility(View.GONE);
         linebcerttime.setVisibility(View.GONE);
         secbcerttimeWM.setVisibility(View.GONE);
         linebcerttimeWM.setVisibility(View.GONE);
         secanybcertcon.setVisibility(View.GONE);
         lineanybcertcon.setVisibility(View.GONE);
         secbcertcon.setVisibility(View.GONE);
         linebcertcon.setVisibility(View.GONE);
         secbcertconOth.setVisibility(View.GONE);
         linebcertconOth.setVisibility(View.GONE);
         secbcertcon.setVisibility(View.GONE);
         linebcertcon.setVisibility(View.GONE);
         secbcertconOth.setVisibility(View.GONE);
         linebcertconOth.setVisibility(View.GONE);
         secbcertcon.setVisibility(View.GONE);
         linebcertcon.setVisibility(View.GONE);
         secbcertconOth.setVisibility(View.GONE);
         linebcertconOth.setVisibility(View.GONE);
         secbcertconOth.setVisibility(View.GONE);
         linebcertconOth.setVisibility(View.GONE);
          //secGamethOth.setVisibility(View.GONE);
         secEddDKOth.setVisibility(View.GONE);

         secFormEdu.setVisibility(View.GONE);
         secFormEduDK.setVisibility(View.GONE);

          //********************************sakib start*****************************************
          dtpdoi.setText(Global.DateNowDMY());
          txttoi.setText(g.CurrentTime24());

          txtMatbdateY.addTextChangedListener(new TextWatcher() {
               @Override
               public void beforeTextChanged(CharSequence s, int start, int count, int after) {

               }

               @Override
               public void onTextChanged(CharSequence s, int start, int before, int count) {

               }

               @Override
               public void afterTextChanged(Editable s) {
                    if(txtMatbdateY.getText().length()>0)
                    {
                         chkMatbdateDK.setChecked(false);
                    }

               }
          });

          chkMatbdateDK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked) {
                        txtMatbdateY.setText("");
                        chkMatageDK.setChecked(false);
                        secMatageDK.setVisibility(View.GONE);
                    }else{
                        secMatageDK.setVisibility(View.VISIBLE);
                    }
               }
          });

         txtMatage.addTextChangedListener(new TextWatcher() {
               @Override
               public void beforeTextChanged(CharSequence s, int start, int count, int after) {

               }

               @Override
               public void onTextChanged(CharSequence s, int start, int before, int count) {

               }

               @Override
               public void afterTextChanged(Editable s) {
                    if(txtMatage.getText().length()>0)
                    {
                         chkMatageDK.setChecked(false);
                    }
               }
          });


          chkMatageDK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked) {
                         txtMatage.setText("");
                    }
               }
          });


          rdogrpmatmobile.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                    String rbData = "";
                    RadioButton rb;
                    String[] d_rdogrpmatmobile = new String[] {"1","2"};
                    for (int i = 0; i < rdogrpmatmobile.getChildCount(); i++)
                    {
                         rb = (RadioButton)rdogrpmatmobile.getChildAt(i);
                         if (rb.isChecked()) rbData = d_rdogrpmatmobile[i];
                    }

                    if(rbData.equalsIgnoreCase("2"))
                    {
                         secMatmobnum.setVisibility(View.GONE);
                         txtMatmobnum.setVisibility(View.GONE);
                         txtMatmobnum.setText("");
                         lineMatmobnum.setVisibility(View.GONE);
                         secMatmobnumDK.setVisibility(View.GONE);
                         chkMatmobnumDK.setVisibility(View.GONE);
                         chkMatmobnumDK.setChecked(false);
                         lineMatmobnumDK.setVisibility(View.GONE);
                         secMatmobnum1.setVisibility(View.GONE);
                         txtMatmobnum1.setVisibility(View.GONE);
                         txtMatmobnum1.setText("");
                         lineMatmobnum1.setVisibility(View.GONE);
                         secMatmobnum1DK.setVisibility(View.GONE);
                         chkMatmobnum1DK.setVisibility(View.GONE);
                         chkMatmobnum1DK.setChecked(false);
                         lineMatmobnum1DK.setVisibility(View.GONE);

                    }else
                    {
                         secMatmobnum.setVisibility(View.VISIBLE);
                         txtMatmobnum.setVisibility(View.VISIBLE);
                         lineMatmobnum.setVisibility(View.VISIBLE);
                         secMatmobnumDK.setVisibility(View.VISIBLE);
                         chkMatmobnumDK.setVisibility(View.VISIBLE);
                         lineMatmobnumDK.setVisibility(View.VISIBLE);
                         //secMatmobnum1.setVisibility(View.VISIBLE);
                         txtMatmobnum1.setVisibility(View.VISIBLE);
                         lineMatmobnum1.setVisibility(View.VISIBLE);
                         //secMatmobnum1DK.setVisibility(View.VISIBLE);
                         //chkMatmobnum1DK.setVisibility(View.VISIBLE);
                         lineMatmobnum1DK.setVisibility(View.VISIBLE);

                    }
               }
          });

          txtMatmobnum.addTextChangedListener(new TextWatcher() {
              @Override
              public void beforeTextChanged(CharSequence s, int start, int count, int after) {

              }

              @Override
              public void onTextChanged(CharSequence s, int start, int before, int count) {

              }

              @Override
              public void afterTextChanged(Editable s) {
                    if(txtMatmobnum.getText().length()>0)
                    {
                        chkMatmobnumDK.setChecked(false);
                    }
              }
          });

          chkMatmobnumDK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked) {
                         txtMatmobnum.setText("");
                    }
               }
          });

          txtMatmobnum1.addTextChangedListener(new TextWatcher() {
              @Override
              public void beforeTextChanged(CharSequence s, int start, int count, int after) {

              }

              @Override
              public void onTextChanged(CharSequence s, int start, int before, int count) {

              }

              @Override
              public void afterTextChanged(Editable s) {
                  if(txtMatmobnum1.getText().length()>0)
                  {
                      chkMatmobnum1DK.setChecked(false);
                  }
              }
          });

          chkMatmobnum1DK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked) {
                         txtMatmobnum1.setText("");
                    }
               }
          });


          rdogrphusmob.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                    String rbData = "";
                    RadioButton rb;
                    String[] d_rdogrphusmob = new String[] {"1","2"};
                    for (int i = 0; i < rdogrphusmob.getChildCount(); i++)
                    {
                         rb = (RadioButton)rdogrphusmob.getChildAt(i);
                         if (rb.isChecked()) rbData = d_rdogrphusmob[i];
                    }
                    if(rbData.equalsIgnoreCase("2"))
                    {
                         secHusmobnum.setVisibility(View.GONE);
                         txtHusmobnum.setVisibility(View.GONE);
                         lineHusmobnum.setVisibility(View.GONE);
                         secHusmobnumDK.setVisibility(View.GONE);
                         chkHusmobnumDK.setVisibility(View.GONE);
                         lineHusmobnumDK.setVisibility(View.GONE);
                         secHusmobnum2.setVisibility(View.GONE);
                         txtHusmobnum2.setVisibility(View.GONE);
                         lineHusmobnum2.setVisibility(View.GONE);
                         secHusmobnum2DK.setVisibility(View.GONE);
                         chkHusmobnum2DK.setVisibility(View.GONE);
                         lineHusmobnum2DK.setVisibility(View.GONE);
                         txtcontact1.setFocusable(true);
                    }else
                    {
                         secHusmobnum.setVisibility(View.VISIBLE);
                         txtHusmobnum.setVisibility(View.VISIBLE);
                         lineHusmobnum.setVisibility(View.VISIBLE);
                         secHusmobnumDK.setVisibility(View.VISIBLE);
                         chkHusmobnumDK.setVisibility(View.VISIBLE);
                         lineHusmobnumDK.setVisibility(View.VISIBLE);
                         //secHusmobnum2.setVisibility(View.VISIBLE);
                         //txtHusmobnum2.setVisibility(View.VISIBLE);
                         lineHusmobnum2.setVisibility(View.VISIBLE);
                         //secHusmobnum2DK.setVisibility(View.VISIBLE);
                         //chkHusmobnum2DK.setVisibility(View.VISIBLE);
                         lineHusmobnum2DK.setVisibility(View.VISIBLE);
                    }
               }
          });

          txtHusmobnum.addTextChangedListener(new TextWatcher() {
               @Override
               public void beforeTextChanged(CharSequence s, int start, int count, int after) {

               }

               @Override
               public void onTextChanged(CharSequence s, int start, int before, int count) {

               }

               @Override
               public void afterTextChanged(Editable s) {
                    if(txtHusmobnum.getText().length()>0)
                    {
                         chkHusmobnumDK.setChecked(false);
                    }

               }
          });

          chkHusmobnumDK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked) {
                         txtHusmobnum.setText("");
                    }
               }
          });

          txtHusmobnum2.addTextChangedListener(new TextWatcher() {
               @Override
               public void beforeTextChanged(CharSequence s, int start, int count, int after) {

               }

               @Override
               public void onTextChanged(CharSequence s, int start, int before, int count) {

               }

               @Override
               public void afterTextChanged(Editable s) {
                    if(txtHusmobnum2.getText().length()>0)
                    {
                         chkHusmobnum2DK.setChecked(false);
                    }

               }
          });

          chkHusmobnum2DK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked) {
                         txtHusmobnum2.setText("");
                    }
               }
          });



          /*dtpEdd.addTextChangedListener(new TextWatcher() {
               @Override
               public void beforeTextChanged(CharSequence s, int start, int count, int after) {

               }

               @Override
               public void onTextChanged(CharSequence s, int start, int before, int count) {

               }

               @Override
               public void afterTextChanged(Editable s) {
                    if(dtpEdd.getText().length()>0)
                    {
                         rdogrpEddDK.clearCheck();
                    }
               }
          });*/

          rdogrpEddDK.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                       @Override
                       public void onCheckedChanged(RadioGroup group, int checkedId) {
                            dtpEdd.setText("");
                            if(checkedId==R.id.rdoEddDK1){
                              secEddDKOth.setVisibility(View.VISIBLE);
                            }else if(checkedId==R.id.rdoEddDK2){
                                 secEddDKOth.setVisibility(View.GONE);
                                 txtEddDKOth.setText("");
                            }
                       }

                  });





          txtga1anc.addTextChangedListener(new TextWatcher() {
               @Override
               public void beforeTextChanged(CharSequence s, int start, int count, int after) {

               }

               @Override
               public void onTextChanged(CharSequence s, int start, int before, int count) {

               }

               @Override
               public void afterTextChanged(Editable s) {
                    if(txtga1anc.getText().length()>0)
                    {
                         rdogrpga1ancWM.clearCheck();
                    }
               }
          });

          rdogrpga1ancWM.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                    if(checkedId==R.id.rdoga1ancWM3)
                    {
                         txtga1anc.setText("") ;
                    }
               }
          });

          txtga.addTextChangedListener(new TextWatcher() {
               @Override
               public void beforeTextChanged(CharSequence s, int start, int count, int after) {

               }

               @Override
               public void onTextChanged(CharSequence s, int start, int before, int count) {

               }

               @Override
               public void afterTextChanged(Editable s) {
                    if(txtga.getText().length()>0)
                    {
                         rdogrpgaWM.clearCheck();
                    }
               }
          });

          rdogrpgaWM.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                    if(checkedId==R.id.rdogaWM3)
                    {
                         txtga.setText("") ;
                    }
               }
          });

          dtpdelivdate.addTextChangedListener(new TextWatcher() {
               @Override
               public void beforeTextChanged(CharSequence s, int start, int count, int after) {

               }

               @Override
               public void onTextChanged(CharSequence s, int start, int before, int count) {

               }

               @Override
               public void afterTextChanged(Editable s) {
                    if(dtpdelivdate.getText().length()>0)
                    {
                         chkdelivdateDK.setChecked(false);
                    }
               }
          });

          chkdelivdateDK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked) {
                         dtpdelivdate.setText("");
                    }
               }
          });

          txtdelivtime.addTextChangedListener(new TextWatcher() {
               @Override
               public void beforeTextChanged(CharSequence s, int start, int count, int after) {

               }

               @Override
               public void onTextChanged(CharSequence s, int start, int before, int count) {

               }

               @Override
               public void afterTextChanged(Editable s) {
                    if(txtdelivtime.getText().length()>0)
                    {
                         chkdelivtimeDK.setChecked(false);
                    }
               }
          });

          chkdelivtimeDK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked)
                    {
                         txtdelivtime.setText("");
                    }
               }
          });

          txtBwgt.addTextChangedListener(new TextWatcher() {
               @Override
               public void beforeTextChanged(CharSequence s, int start, int count, int after) {

               }

               @Override
               public void onTextChanged(CharSequence s, int start, int before, int count) {

               }

               @Override
               public void afterTextChanged(Editable s) {
                    if(txtBwgt.getText().length()>0)
                    {
                         rdogrpBwgtDK.clearCheck();
                    }

               }
          });

          rdogrpBwgtDK.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                    if(checkedId==R.id.rdoBwgtDK1 ||checkedId==R.id.rdoBwgtDK2)
                    {
                        txtBwgt.setText("");
                    }

               }
          });

          txtnightsnum.addTextChangedListener(new TextWatcher() {
               @Override
               public void beforeTextChanged(CharSequence s, int start, int count, int after) {

               }

               @Override
               public void onTextChanged(CharSequence s, int start, int before, int count) {

               }

               @Override
               public void afterTextChanged(Editable s) {
                    if(txtnightsnum.getText().length()>0)
                    {
                         chknightsnumDK.setChecked(false);
                    }
               }
          });

          chknightsnumDK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked)
                    {
                         txtnightsnum.setText("");
                    }
               }
          });

          txtbcerttime.addTextChangedListener(new TextWatcher() {
               @Override
               public void beforeTextChanged(CharSequence s, int start, int count, int after) {

               }

               @Override
               public void onTextChanged(CharSequence s, int start, int before, int count) {

               }

               @Override
               public void afterTextChanged(Editable s) {
                    if(txtbcerttime.getText().length()>0)
                    {
                        // rdogrpbcerttimeWM.clearCheck();
                        rdobcerttimeWM3.setChecked(false);
                    }
               }
          });

          rdogrpbcerttimeWM.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                    if(checkedId==R.id.rdobcerttimeWM3)
                    {
                         txtbcerttime.setText("");
                    }
               }
          });




          //1-Bangladesh, 2-Nepal, 3-Tanzania
          if(COUNTRYCODE.equals(ProjectSetting.BANGLADESH))
          {
               Vlbladdr1.setText("a. District");
               Vlbladdr2.setText("b. Upazila/Thana");
               Vlbladdr3.setText("c. Union/Ward");
               Vlbladdr4.setText("d. Village/Moholla");
               //secaddr4.setVisibility(View.GONE);
          }
          else if(COUNTRYCODE.equals(ProjectSetting.NEPAL))
          {
               Vlbladdr1.setText("a. District");
               Vlbladdr2.setText("b. Municipailty/VDC");
               Vlbladdr3.setText("c. Ward Number");
               Vlbladdr4.setText("d. Street/Tole");
               //secaddr4.setVisibility(View.GONE);
          }
          else if(COUNTRYCODE.equals(ProjectSetting.TANZANIA))
          {
               Vlbladdr1.setText("a. District");
               Vlbladdr2.setText("b. Ward");
               Vlbladdr3.setText("c. Street");
               secaddr4.setVisibility(View.GONE);
          }


/*          secGametha.setVisibility(View.GONE);
          chkGametha.setChecked(false);
          secGamethb.setVisibility(View.GONE);
          chkGamethb.setChecked(false);
          secGamethc.setVisibility(View.GONE);
          chkGamethc.setChecked(false);
          secGamethd.setVisibility(View.GONE);
          chkGamethd.setChecked(false);
          secGamethe.setVisibility(View.GONE);
          chkGamethe.setChecked(false);
          txtGametheOth.setText("");
          secGamethf.setVisibility(View.GONE);
          chkGamethf.setChecked(false);*/




         chkGametha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if(isChecked)
                 {
                     chkGamethf.setChecked(false);
                 }
             }
         });
         chkGamethb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if(isChecked)
                 {
                     chkGamethf.setChecked(false);
                 }
             }
         });
         chkGamethc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if(isChecked)
                 {
                     chkGamethf.setChecked(false);
                 }
             }
         });
         chkGamethd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if(isChecked)
                 {
                     chkGamethf.setChecked(false);
                 }
             }
         });
         chkGamethe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if(isChecked)
                 {
                     secGametheOth.setVisibility(View.VISIBLE);
                     chkGamethf.setChecked(false);
                 }else{
                     secGametheOth.setVisibility(View.GONE);
                     txtGametheOth.setText("");
                 }
             }
         });
         chkGamethf.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if(isChecked)
                 {
                     chkGametha.setChecked(false);
                     chkGamethb.setChecked(false);
                     chkGamethc.setChecked(false);
                     chkGamethd.setChecked(false);
                     chkGamethe.setChecked(false);
                 }
             }
         });


         chkFormEduDK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if(isChecked)
                 {
                     txtFormEdu.setText("");
                 }
             }
         });

         txtFormEdu.addTextChangedListener(new TextWatcher() {
             @Override
             public void beforeTextChanged(CharSequence s, int start, int count, int after) {

             }

             @Override
             public void onTextChanged(CharSequence s, int start, int before, int count) {

             }

             @Override
             public void afterTextChanged(Editable s) {
                 if(txtFormEdu.getText().length()>0)
                 {
                     chkFormEduDK.setChecked(false);
                 }
             }
         });
          secGametheOth.setVisibility(View.GONE);
        //********************************sakib end*******************************************
        Button cmdSave = (Button) findViewById(R.id.cmdSave);
        cmdSave.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) { 
            DataSave();
        }});

        DataSearch(COUNTRYCODE,FACICODE,DATAID);
     }
     catch(Exception  e)
     {
         Connection.MessageBox(RecallSurvS1.this, e.getMessage());
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
             Connection.MessageBox(RecallSurvS1.this, "Required field: CountryCode.");
             txtCountryCode.requestFocus();
             return;
           }
         else if(Integer.valueOf(txtCountryCode.getText().toString().length()==0 ? "1" : txtCountryCode.getText().toString()) < 1 || Integer.valueOf(txtCountryCode.getText().toString().length()==0 ? "3" : txtCountryCode.getText().toString()) > 3)
           {
             Connection.MessageBox(RecallSurvS1.this, "Value should be between 1 and 3(CountryCode).");
             txtCountryCode.requestFocus();
             return;
           }
         else if(txtFaciCode.getText().toString().length()==0 & secFaciCode.isShown())
           {
             Connection.MessageBox(RecallSurvS1.this, "Required field: Facility.");
             txtFaciCode.requestFocus();
             return;
           }
         else if(Integer.valueOf(txtFaciCode.getText().toString().length()==0 ? "1" : txtFaciCode.getText().toString()) < 1 || Integer.valueOf(txtFaciCode.getText().toString().length()==0 ? "9" : txtFaciCode.getText().toString()) > 9)
           {
             Connection.MessageBox(RecallSurvS1.this, "Value should be between 1 and 9(Facility).");
             txtFaciCode.requestFocus();
             return;
           }
         else if(txtDataID.getText().toString().length()==0 & secDataID.isShown())
           {
             Connection.MessageBox(RecallSurvS1.this, "Required field: Data ID.");
             txtDataID.requestFocus();
             return;
           }
         else if(txtStudyID.getText().toString().length()==0 & secStudyID.isShown())
           {
             Connection.MessageBox(RecallSurvS1.this, "Required field: Participant ID.");
             txtStudyID.requestFocus();
             return;
           }

         else if(!rdoConsentMRS1.isChecked() & !rdoConsentMRS2.isChecked() & secConsentMRS.isShown())
           {
              Connection.MessageBox(RecallSurvS1.this, "Select anyone options from (Before beginning the survey please remind the mother that they previously gave informed consent to take part in this survey about her delivery experience before being discharged. ).");
              rdoConsentMRS1.requestFocus();
              return;
           }

         else if(!rdoConsentFollo1.isChecked() & !rdoConsentFollo2.isChecked() & secConsentFollo.isShown())
           {
              Connection.MessageBox(RecallSurvS1.this, "Select anyone options from (INTRODUCE ENAP FOLLOW UP STUDY WITH FOLLOW UP INFORMATION SHEET AND CONSENT FORM: Does she consent to taking part in the follow up survey?).");
              rdoConsentFollo1.requestFocus();
              return;
           }
         DV = Global.DateValidate(dtpdoi.getText().toString());
         if(DV.length()!=0 & secdoi.isShown())
           {
             Connection.MessageBox(RecallSurvS1.this, DV);
             dtpdoi.requestFocus();
             return;
           }
         else if(txttoi.getText().length()==0 & sectoi.isShown())
           {
             Connection.MessageBox(RecallSurvS1.this, "Required field: Time of interview (24 hour clock).");
             txttoi.requestFocus();
             return;
           }
         else if(spnlang.getSelectedItemPosition()==0  & seclang.isShown())
           {
             Connection.MessageBox(RecallSurvS1.this, "Required field: Language used.");
             spnlang.requestFocus();
             return;
           }
         else if(txtlangOth.getText().toString().length()==0  & seclangOth.isShown())
         {
             Connection.MessageBox(RecallSurvS1.this, "Required field: Other Language.");
             txtlangOth.requestFocus();
             return;
         }
         else if(!rdointerp1.isChecked() & !rdointerp2.isChecked() & secinterp.isShown()){
             Connection.MessageBox(RecallSurvS1.this, "Select anyone options from (08a. Was an interpreter available?).");
             rdointerp1.requestFocus();
             return;
         }
         else if(txtinterpName.getText().toString().length()==0 & secinterpName.isShown()){
             Connection.MessageBox(RecallSurvS1.this, "Required field: 08b. Interpreter’s name");
             txtinterpName.requestFocus();
             return;
         }
         else if(spncconditionb.getSelectedItemPosition()==0  & seccconditionb.isShown())
           {
             Connection.MessageBox(RecallSurvS1.this, "Required field: Current condition of baby.");
             spncconditionb.requestFocus();
             return;
           }

         else if(!rdomatconsent1.isChecked() & !rdomatconsent2.isChecked() & secmatconsent.isShown())
           {
              Connection.MessageBox(RecallSurvS1.this, "Select anyone options from (Informed and signed consent ).");
              rdomatconsent1.requestFocus();
              return;
           }
         else if(spnMatbdateM.getSelectedItemPosition()==0  & secMatbdateM.isShown())
           {
             Connection.MessageBox(RecallSurvS1.this, "Required field: What month/ year were you born - Month.");
             spnMatbdateM.requestFocus();
             return;
           }
         else if(!chkMatbdateDK.isChecked() & secMatbdateDK.isShown())
         {
               if(txtMatbdateY.getText().toString().length()==0 & secMatbdateY.isShown())
               {
                   Connection.MessageBox(RecallSurvS1.this, "Required field: Year.");
                   txtMatbdateY.requestFocus();
                   return;
               }
              else if(Integer.valueOf(txtMatbdateY.getText().toString().length()==0 ? "1970" : txtMatbdateY.getText().toString()) < 1970 || Integer.valueOf(txtMatbdateY.getText().toString().length()==0 ? "2018" : txtMatbdateY.getText().toString()) > 2018)
              {
                   Connection.MessageBox(RecallSurvS1.this, "Value should be between 1970 and 2018(Year).");
                   txtMatbdateY.requestFocus();
                   return;
              }
         }
         if(!chkMatageDK.isChecked() & secMatageDK.isShown())
         {
              if(txtMatage.getText().toString().length()==0 & secMatage.isShown())
              {
                   Connection.MessageBox(RecallSurvS1.this, "Required field: How old are you?.");
                   txtMatage.requestFocus();
                   return;
              }
         }
        if(!chkFormEduDK.isChecked() & txtFormEdu.getText().toString().length()==0 & secFormEdu.isShown()){
            Connection.MessageBox(RecallSurvS1.this, "Required field: 12a. How many years of formal education have you had?");
            txtFormEdu.requestFocus();
            return;
        }

          if(spnaddr1.getSelectedItemPosition()==0  & secaddr1.isShown())
           {
             Connection.MessageBox(RecallSurvS1.this, "Required field: Level 1.");
             spnaddr1.requestFocus();
             return;
           }
         /*else if(spnaddr2.getSelectedItemPosition()==0  & secaddr2.isShown())
           {
             Connection.MessageBox(RecallSurvS1.this, "Required field: Level 2.");
             spnaddr2.requestFocus();
             return;
           }
         else if(spnaddr3.getSelectedItemPosition()==0  & secaddr3.isShown())
           {
             Connection.MessageBox(RecallSurvS1.this, "Required field: Level 3.");
             spnaddr3.requestFocus();
             return;
           }
         else if(spnaddr4.getSelectedItemPosition()==0  & secaddr4.isShown())
           {
             Connection.MessageBox(RecallSurvS1.this, "Required field: Level 4.");
             spnaddr4.requestFocus();
             return;
           }*/
         /*else if(txtAddressDetail.getText().toString().length()==0 & secAddressDetail.isShown())
           {
             Connection.MessageBox(RecallSurvS1.this, "Required field: Detailed address.");
             txtAddressDetail.requestFocus();
             return;
           }*/

         else if(!rdomatmobile1.isChecked() & !rdomatmobile2.isChecked() & secmatmobile.isShown())
           {
              Connection.MessageBox(RecallSurvS1.this, "Select anyone options from (Do you have a mobile number?).");
              rdomatmobile1.requestFocus();
              return;
           }
         else if(!chkMatmobnumDK.isChecked() & secMatmobnumDK.isShown())
           {
              if(txtMatmobnum.getText().toString().length()==0 & secMatmobnum.isShown())
              {
                     Connection.MessageBox(RecallSurvS1.this, "Required field: a) If YES, what is your mobile1 number.");
                     txtMatmobnum.requestFocus();
                     return;
              }
           }

          if(!chkMatmobnum1DK.isChecked() & secMatmobnum1DK.isShown())
         {
              if(txtMatmobnum1.getText().toString().length()==0 & secMatmobnum1.isShown())
              {
                   Connection.MessageBox(RecallSurvS1.this, "Required field: a) If YES, what is your mobile2 number.");
                   txtMatmobnum1.requestFocus();
                   return;
              }
         }

          if(!rdohusmob1.isChecked() & !rdohusmob2.isChecked() & sechusmob.isShown())
           {
              Connection.MessageBox(RecallSurvS1.this, "Select anyone options from (Does your husband or family member have a mobile number? ).");
              rdohusmob1.requestFocus();
              return;
           }

          if(!chkHusmobnumDK.isChecked() & secHusmobnumDK.isShown())
         {
              if(txtHusmobnum.getText().toString().length()==0 & secHusmobnum.isShown())
              {
                   Connection.MessageBox(RecallSurvS1.this, "Required field: a) If YES, can I record that number.");
                   txtHusmobnum.requestFocus();
                   return;
              }
         }
          if(!chkHusmobnum2DK.isChecked() & secHusmobnum2DK.isShown())
         {
              if(txtHusmobnum2.getText().toString().length()==0 & secHusmobnum2.isShown())
              {
                   Connection.MessageBox(RecallSurvS1.this, "Required field: b) If YES, can I record that number.");
                   txtHusmobnum2.requestFocus();
                   return;
              }
         }
         /*else if(txtcontact1.getText().toString().length()==0 & seccontact1.isShown())
           {
             Connection.MessageBox(RecallSurvS1.this, "Required field: What is the best way to contact you.");
             txtcontact1.requestFocus();
             return;
           }*/

         else if(!rdoeddknown1.isChecked() & !rdoeddknown2.isChecked() & !rdoeddknown3.isChecked() & seceddknown.isShown())
           {
              Connection.MessageBox(RecallSurvS1.this, "Select anyone options from (During your pregnancy, did you know when your baby was due to be born? ).");
              rdoeddknown1.requestFocus();
              return;
           }

           if(!rdoEddDK1.isChecked() & !rdoEddDK2.isChecked() & secEddDK.isShown())
           {
                /*DV = Global.DateValidate(dtpEdd.getText().toString());
                if(DV.length()!=0 & secEdd.isShown())
                {
                     Connection.MessageBox(RecallSurvS1.this, DV);
                     dtpEdd.requestFocus();
                     return;
                }*/
           }

         if(!rdoga1ancWM3.isChecked() & secga1ancWM.isShown())
          {
              if(txtga1anc.getText().toString().length()==0 & secga1anc.isShown())
              {
                   Connection.MessageBox(RecallSurvS1.this, "Required field: How many weeks or months pregnant were you when you first received antenatal care for this pregnancy? DEPENDING ON MOTHER’S ANSWER, WRITE ANSWER IN EITHER WEEKS OR MONTHS.");
                   txtga1anc.requestFocus();
                   return;
              }
          }

          if(Integer.valueOf(txtga1anc.getText().toString().length()==0 ? "1" : txtga1anc.getText().toString()) < 1 || Integer.valueOf(txtga1anc.getText().toString().length()==0 ? "99" : txtga1anc.getText().toString()) > 99)
           {
             Connection.MessageBox(RecallSurvS1.this, "Value should be between 1 and 99(How many weeks or months pregnant were you when you first received antenatal care for this pregnancy? DEPENDING ON MOTHER’S ANSWER, WRITE ANSWER IN EITHER WEEKS OR MONTHS).");
             txtga1anc.requestFocus();
             return;
           }

         else if(!rdoga1ancWM1.isChecked() & !rdoga1ancWM2.isChecked() & !rdoga1ancWM3.isChecked() & secga1ancWM.isShown())
           {
              Connection.MessageBox(RecallSurvS1.this, "Select anyone options from (weeks/months).");
              rdoga1ancWM1.requestFocus();
              return;
           }
         else if(spnantcarenum.getSelectedItemPosition()==0  & secantcarenum.isShown())
           {
             Connection.MessageBox(RecallSurvS1.this, "Required field: How many antenatal check-ups did you have? How many times did you receive antenatal care during this pregnancy?.");
             spnantcarenum.requestFocus();
             return;
           }
         else if(!rdogaWM3.isChecked() & secgaWM.isShown())
         {
              if(txtga.getText().toString().length()==0 & secga.isShown())
              {
                   Connection.MessageBox(RecallSurvS1.this, "Required field: How many week or months pregnant were you when you delivered your baby? DEPENDING ON MOTHER’S ANSWER, WRITE ANSWER IN EITHER WEEKS OR MONTHS.");
                   txtga.requestFocus();
                   return;
              }
         }
          if(Integer.valueOf(txtga.getText().toString().length()==0 ? "1" : txtga.getText().toString()) < 1 || Integer.valueOf(txtga.getText().toString().length()==0 ? "99" : txtga.getText().toString()) > 99)
           {
             Connection.MessageBox(RecallSurvS1.this, "Value should be between 1 and 99(How many week or months pregnant were you when you delivered your baby? DEPENDING ON MOTHER’S ANSWER, WRITE ANSWER IN EITHER WEEKS OR MONTHS).");
             txtga.requestFocus();
             return;
           }

         else if(!rdogaWM1.isChecked() & !rdogaWM2.isChecked() & !rdogaWM3.isChecked() & secgaWM.isShown())
           {
              Connection.MessageBox(RecallSurvS1.this, "Select anyone options from (weeks/months).");
              rdogaWM1.requestFocus();
              return;
           }

         else if(!rdobheart1.isChecked() & !rdobheart2.isChecked() & !rdobheart3.isChecked() & !rdobheart4.isChecked() & secbheart.isShown())
           {
              Connection.MessageBox(RecallSurvS1.this, "Select anyone options from (Did a birth attendant listen for baby’s heart sounds during labour with an electric device (Doppler) or cone-shaped stethoscope placed on the abdomen ? USE VISUAL PROMPT AND  DESCRIBE THE USE OF A CONE-LIKE INSTRUMENT ).");
              rdobheart1.requestFocus();
              return;
           }

          /*else if(spnbcondition.getSelectedItemPosition()==0  & secbcondition.isShown())
           {
             Connection.MessageBox(RecallSurvS1.this, "Required field: Were you told about the condition of your baby?.");
             spnbcondition.requestFocus();
             return;
           }*/

         else if(!rdobcondition1.isChecked() & !rdobcondition2.isChecked() & !!rdobcondition3.isChecked() & secbcondition.isShown()){
              Connection.MessageBox(RecallSurvS1.this, "Select anyone options from (Were you told about the condition of your baby?).");
              rdobcondition1.requestFocus();
              return;
          }
         else if(!rdoplacedeliv1.isChecked() & !rdoplacedeliv2.isChecked() & !rdoplacedeliv3.isChecked() & !rdoplacedeliv4.isChecked() & !rdoplacedeliv5.isChecked() & secplacedeliv.isShown())
           {
              Connection.MessageBox(RecallSurvS1.this, "Select anyone options from (Where did you deliver your baby?).");
              rdoplacedeliv1.requestFocus();
              return;
           }
         else if(txtplacedelivOth.getText().toString().length()==0 & secplacedelivOth.isShown())
           {
             Connection.MessageBox(RecallSurvS1.this, "Required field: Specify.");
             txtplacedelivOth.requestFocus();
             return;
           }

           if(!chkdelivdateDK.isChecked()& secdelivdateDK.isShown())
           {
                DV = Global.DateValidate(dtpdelivdate.getText().toString());
                if(DV.length()!=0 & secdelivdate.isShown())
                {
                     Connection.MessageBox(RecallSurvS1.this, DV);
                     dtpdelivdate.requestFocus();
                     return;
                }
           }
          if(!chkdelivtimeDK.isChecked()& secdelivtimeDK.isShown())
           {
                if(txtdelivtime.getText().length()==0 & secdelivtime.isShown())
                {
                     Connection.MessageBox(RecallSurvS1.this, "Required field: What time was your baby born? (24 hrs clock).");
                     txtdelivtime.requestFocus();
                     return;
                }
           }
         else if(spntypebirth.getSelectedItemPosition()==0  & sectypebirth.isShown())
           {
             Connection.MessageBox(RecallSurvS1.this, "Required field: Was the baby born by vaginal delivery, forceps, vacuum, assisted breach or caesarean section?.");
             spntypebirth.requestFocus();
             return;
           }
         else if(spnTimecsec.getSelectedItemPosition()==0  & secTimecsec.isShown())
           {
             Connection.MessageBox(RecallSurvS1.this, "Required field: When was the decision made to have the caesarean section? PROBE IF NECESSARY: Was it before or after your labour pains started?.");
             spnTimecsec.requestFocus();
             return;
           }

         else if(!rdoToldcsecreas1.isChecked() & !rdoToldcsecreas2.isChecked() & !rdoToldcsecreas3.isChecked() & secToldcsecreas.isShown())
           {
              Connection.MessageBox(RecallSurvS1.this, "Select anyone options from (Did anyone tell you the reason for the caesarean section?).");
              rdoToldcsecreas1.requestFocus();
              return;
           }
         else if(spnCsecreas.getSelectedItemPosition()==0  & secCsecreas.isShown())
           {
             Connection.MessageBox(RecallSurvS1.this, "Required field: a) If yes, then what was the reason?.");
             spnCsecreas.requestFocus();
             return;
           }
         else if(txtOthReason.getText().toString().length()==0 & secOthReason.isShown())
           {
             Connection.MessageBox(RecallSurvS1.this, "Required field: Specify.");
             txtOthReason.requestFocus();
             return;
           }

         else if(!rdoBwgted1.isChecked() & !rdoBwgted2.isChecked() & !rdoBwgted3.isChecked() & secBwgted.isShown())
           {
              Connection.MessageBox(RecallSurvS1.this, "Select anyone options from (Was your baby weighed at birth?).");
              rdoBwgted1.requestFocus();
              return;
           }
         else if((!rdoBwgtDK1.isChecked()&!rdoBwgtDK2.isChecked()) & txtBwgt.getText().toString().length()==0 & secBwgtDK.isShown())
           {
                if(txtBwgt.getText().toString().length()==0 & secBwgt.isShown())
                {
                     Connection.MessageBox(RecallSurvS1.this, "Required field: a) How much did your baby weigh? (grams).");
                     txtBwgt.requestFocus();
                     return;
                }
           }
          if((!rdoBwgtDK1.isChecked()&!rdoBwgtDK2.isChecked()) & Integer.valueOf(txtBwgt.getText().toString().length()==0 ? "400" : txtBwgt.getText().toString()) < 400 || Integer.valueOf(txtBwgt.getText().toString().length()==0 ? "9999" : txtBwgt.getText().toString()) > 9999)
           {
             Connection.MessageBox(RecallSurvS1.this, "Value should be between 400 and 9999(a) How much did your baby weigh? (grams)).");
             txtBwgt.requestFocus();
             return;
           }

         /*else if(!rdoBwgtDK1.isChecked() & !rdoBwgtDK2.isChecked() & secBwgtDK.isShown())
           {
              Connection.MessageBox(RecallSurvS1.this, "Select anyone options from (Don’t know/don’t remember).");
              rdoBwgtDK1.requestFocus();
              return;
           }*/

         else if(!rdobwgtmeth1.isChecked() & !rdobwgtmeth2.isChecked() & !rdobwgtmeth3.isChecked() & secbwgtmeth.isShown())
           {
              Connection.MessageBox(RecallSurvS1.this, "Select anyone options from (How was your baby weighed? READ ANSWER CHOICES AND VISUAL PROMPT WITH PICTURES AS NECESSARY).");
              rdobwgtmeth1.requestFocus();
              return;
           }
         else if(spnBsex.getSelectedItemPosition()==0  & secBsex.isShown())
           {
             Connection.MessageBox(RecallSurvS1.this, "Required field: Is your baby a boy or a girl?.");
             spnBsex.requestFocus();
             return;
           }
         else if(spnperceivesize.getSelectedItemPosition()==0  & secperceivesize.isShown())
           {
             Connection.MessageBox(RecallSurvS1.this, "Required field: When your baby was born, was (he/she) very large, larger than average, average, smaller than average, or very small?.");
             spnperceivesize.requestFocus();
             return;
           }

         else if(!rdoanybcomp1.isChecked() & !rdoanybcomp2.isChecked() & !rdoanybcomp3.isChecked() & secanybcomp.isShown())
           {
              Connection.MessageBox(RecallSurvS1.this, "Select anyone options from (Did you have any complications after birth?).");
              rdoanybcomp1.requestFocus();
              return;
           }
         else if(txtbcompIOth.getText().toString().length()==0 & secbcompIOth.isShown())
           {
             Connection.MessageBox(RecallSurvS1.this, "Required field: Specify.");
             txtbcompIOth.requestFocus();
             return;
           }
         else if(!chknightsnumDK.isChecked() & secnightsnumDK.isShown())
         {
              if(txtnightsnum.getText().toString().length()==0 & secnightsnum.isShown())
              {
                   Connection.MessageBox(RecallSurvS1.this, "Required field: After your baby was born, how many nights did you stay in the hospital?.");
                   txtnightsnum.requestFocus();
                   return;
              }
         }
          if(Integer.valueOf(txtnightsnum.getText().toString().length()==0 ? "0" : txtnightsnum.getText().toString()) < 0 || Integer.valueOf(txtnightsnum.getText().toString().length()==0 ? "99" : txtnightsnum.getText().toString()) > 99)
           {
             Connection.MessageBox(RecallSurvS1.this, "Value should be between 0 and 99(After your baby was born, how many nights did you stay in the hospital?).");
             txtnightsnum.requestFocus();
             return;
           }

         else if(!rdobnotif1.isChecked() & !rdobnotif2.isChecked() & !rdobnotif3.isChecked() & !rdobnotif4.isChecked() & secbnotif.isShown())
           {
              Connection.MessageBox(RecallSurvS1.this, "Select anyone options from (Did you receive a birth notification form or other relevant documentation to provide proof of the birth for your baby? SHOW FORM).");
              rdobnotif1.requestFocus();
              return;
           }

         else if(!rdobcert1.isChecked() & !rdobcert2.isChecked() & !rdobcert3.isChecked() & secbcert.isShown())
           {
              Connection.MessageBox(RecallSurvS1.this, "Select anyone options from (In addition to this notification, a baby should also receive birth certification. Did you receive this form? ).");
              rdobcert1.requestFocus();
              return;
           }

         else if(!rdobcertknow1.isChecked() & !rdobcertknow2.isChecked() & !rdobcertknow3.isChecked() & secbcertknow.isShown())
           {
              Connection.MessageBox(RecallSurvS1.this, "Select anyone options from (Do you know how to obtain such a birth certificate for your baby?).");
              rdobcertknow1.requestFocus();
              return;
           }
         else if(!rdobcerttimeWM3.isChecked() & secbcerttimeWM.isShown())
         {
              if(txtbcerttime.getText().toString().length()==0 & secbcerttime.isShown())
              {
                   Connection.MessageBox(RecallSurvS1.this, "Required field: When are you planning to get your birth certificate? DEPENDING ON MOTHER’S ANSWER, WRITE ANSWER IN EITHER WEEKS OR MONTHS.");
                   txtbcerttime.requestFocus();
                   return;
              }
         }
          if(Integer.valueOf(txtbcerttime.getText().toString().length()==0 ? "1" : txtbcerttime.getText().toString()) < 1 || Integer.valueOf(txtbcerttime.getText().toString().length()==0 ? "999" : txtbcerttime.getText().toString()) > 999)
           {
             Connection.MessageBox(RecallSurvS1.this, "Value should be between 1 and 999(When are you planning to get your birth certificate? DEPENDING ON MOTHER’S ANSWER, WRITE ANSWER IN EITHER WEEKS OR MONTHS).");
             txtbcerttime.requestFocus();
             return;
           }

         else if(!rdobcerttimeWM1.isChecked() & !rdobcerttimeWM2.isChecked() & !rdobcerttimeWM3.isChecked() & secbcerttimeWM.isShown())
           {
              Connection.MessageBox(RecallSurvS1.this, "Select anyone options from (Week/Month).");
              rdobcerttimeWM1.requestFocus();
              return;
           }
         else if(!rdoanybcertcon1.isChecked() & !rdoanybcertcon2.isChecked() & !rdoanybcertcon3.isChecked()   & secanybcertcon.isShown())
           {
             Connection.MessageBox(RecallSurvS1.this, "Required field: Do you have any concerns about getting a birth certificate?.");
               rdoanybcertcon1.requestFocus();
             return;
           }

         else if(txtbcertconOth.getText().toString().length()==0 & secbcertconOth.isShown())
           {
             Connection.MessageBox(RecallSurvS1.this, "Required field: Other, specify.");
             txtbcertconOth.requestFocus();
             return;
           }
 
         String SQL = "";
         RadioButton rb;

         RecallSurvS1_DataModel objSave = new RecallSurvS1_DataModel();
         objSave.setCountryCode(txtCountryCode.getText().toString());
         objSave.setFaciCode(txtFaciCode.getText().toString());
         objSave.setDataID(txtDataID.getText().toString());
         objSave.setStudyID(txtStudyID.getText().toString());
         String[] d_rdogrpConsentMRS = new String[] {"1","2"};
         objSave.setConsentMRS("");
         for (int i = 0; i < rdogrpConsentMRS.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpConsentMRS.getChildAt(i);
             if (rb.isChecked()) objSave.setConsentMRS(d_rdogrpConsentMRS[i]);
         }

         String[] d_rdogrpConsentFollo = new String[] {"1","2"};
         objSave.setConsentFollo("");
         for (int i = 0; i < rdogrpConsentFollo.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpConsentFollo.getChildAt(i);
             if (rb.isChecked()) objSave.setConsentFollo(d_rdogrpConsentFollo[i]);
         }

         objSave.setdoi(dtpdoi.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpdoi.getText().toString()) : dtpdoi.getText().toString());
         objSave.settoi(txttoi.getText().toString());
         objSave.setlang((spnlang.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnlang.getSelectedItem().toString(), "-")));
         objSave.setlangOth(txtlangOth.getText().toString());

         if(rdointerp1.isChecked()) objSave.setinterp("1"); else if(rdointerp2.isChecked()) objSave.setinterp("2"); else objSave.setinterp("");
         objSave.setinterpName(txtinterpName.getText().toString());

         objSave.setcconditionb((spncconditionb.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spncconditionb.getSelectedItem().toString(), "-")));
         String[] d_rdogrpmatconsent = new String[] {"1","2"};
         objSave.setmatconsent("");
         for (int i = 0; i < rdogrpmatconsent.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpmatconsent.getChildAt(i);
             if (rb.isChecked()) objSave.setmatconsent(d_rdogrpmatconsent[i]);
         }

         objSave.setMatbdateM((spnMatbdateM.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnMatbdateM.getSelectedItem().toString(), "-")));
         objSave.setMatbdateY(txtMatbdateY.getText().toString());
         objSave.setMatbdateDK((chkMatbdateDK.isChecked()?"1":(secMatbdateDK.isShown()?"2":"")));
         objSave.setMatage(txtMatage.getText().toString());
         objSave.setMatageDK((chkMatageDK.isChecked()?"1":(secMatageDK.isShown()?"2":"")));
         objSave.setFormEdu(txtFormEdu.getText().toString());
         objSave.setFormEduDK(chkFormEduDK.isChecked()?"1":(secFormEdu.isShown()?"2":""));

         objSave.setaddr1((spnaddr1.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnaddr1.getSelectedItem().toString(), "-")));
         objSave.setaddr2(txtaddr2.getText().toString());
         objSave.setaddr3(txtaddr3.getText().toString());
         objSave.setaddr4(txtaddr4.getText().toString());
         objSave.setAddressDetail(txtAddressDetail.getText().toString());
         String[] d_rdogrpmatmobile = new String[] {"1","2"};
         objSave.setmatmobile("");
         for (int i = 0; i < rdogrpmatmobile.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpmatmobile.getChildAt(i);
             if (rb.isChecked()) objSave.setmatmobile(d_rdogrpmatmobile[i]);
         }

         objSave.setMatmobnum(txtMatmobnum.getText().toString());
         objSave.setMatmobnumDK((chkMatmobnumDK.isChecked()?"1":(secMatmobnumDK.isShown()?"2":"")));
         objSave.setMatmobnum1(txtMatmobnum1.getText().toString());
         objSave.setMatmobnum1DK((chkMatmobnum1DK.isChecked()?"1":(secMatmobnum1DK.isShown()?"2":"")));
         String[] d_rdogrphusmob = new String[] {"1","2"};
         objSave.sethusmob("");
         for (int i = 0; i < rdogrphusmob.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrphusmob.getChildAt(i);
             if (rb.isChecked()) objSave.sethusmob(d_rdogrphusmob[i]);
         }

         objSave.setHusmobnum(txtHusmobnum.getText().toString());
         objSave.setHusmobnumDK((chkHusmobnumDK.isChecked()?"1":(secHusmobnumDK.isShown()?"2":"")));
         objSave.setHusmobnum2(txtHusmobnum2.getText().toString());
         objSave.setHusmobnum2DK((chkHusmobnum2DK.isChecked()?"1":(secHusmobnum2DK.isShown()?"2":"")));
         objSave.setcontact1(txtcontact1.getText().toString());
         String[] d_rdogrpeddknown = new String[] {"1","2","9"};
         objSave.seteddknown("");
         for (int i = 0; i < rdogrpeddknown.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpeddknown.getChildAt(i);
             if (rb.isChecked()) objSave.seteddknown(d_rdogrpeddknown[i]);
         }

         objSave.setEdd(dtpEdd.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpEdd.getText().toString()) : dtpEdd.getText().toString());
         objSave.setEddDK(rdoEddDK1.isChecked()?"1": (rdoEddDK2.isChecked()?"2":""));
          objSave.setEddDKOth(txtEddDKOth.getText().toString());
         objSave.setGametha(chkGametha.isChecked()?"1":(secGametha.isShown()?"2":""));
          objSave.setGamethb(chkGamethb.isChecked()?"1":(secGamethb.isShown()?"2":""));
          objSave.setGamethc(chkGamethc.isChecked()?"1":(secGamethc.isShown()?"2":""));
          objSave.setGamethd(chkGamethd.isChecked()?"1":(secGamethd.isShown()?"2":""));
          objSave.setGamethe(chkGamethe.isChecked()?"1":(secGamethe.isShown()?"2":""));
         objSave.setGametheOth(txtGametheOth.getText().toString());
          objSave.setGamethf(chkGamethf.isChecked()?"1":(secGamethf.isShown()?"2":""));

         objSave.setga1anc(txtga1anc.getText().toString());
         String[] d_rdogrpga1ancWM = new String[] {"1","2","9"};
         objSave.setga1ancWM("");
         for (int i = 0; i < rdogrpga1ancWM.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpga1ancWM.getChildAt(i);
             if (rb.isChecked()) objSave.setga1ancWM(d_rdogrpga1ancWM[i]);
         }

         objSave.setantcarenum((spnantcarenum.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnantcarenum.getSelectedItem().toString(), "-")));
         objSave.setga(txtga.getText().toString());
         String[] d_rdogrpgaWM = new String[] {"1","2","9"};
         objSave.setgaWM("");
         for (int i = 0; i < rdogrpgaWM.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpgaWM.getChildAt(i);
             if (rb.isChecked()) objSave.setgaWM(d_rdogrpgaWM[i]);
         }

         String[] d_rdogrpbheart = new String[] {"1","2","3","9"};
         objSave.setbheart("");
         for (int i = 0; i < rdogrpbheart.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpbheart.getChildAt(i);
             if (rb.isChecked()) objSave.setbheart(d_rdogrpbheart[i]);
         }

         //objSave.setbcondition((spnbcondition.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnbcondition.getSelectedItem().toString(), "-")));
         String[] d_rdogrpbcondition = new String[] {"1","2","9"};
         objSave.setbcondition("");
         for (int i = 0; i < rdogrpbcondition.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpbcondition.getChildAt(i);
             if (rb.isChecked()) objSave.setbcondition(d_rdogrpbcondition[i]);
         }

         String[] d_rdogrpplacedeliv = new String[] {"1","2","3","4","5"};
         objSave.setplacedeliv("");
         for (int i = 0; i < rdogrpplacedeliv.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpplacedeliv.getChildAt(i);
             if (rb.isChecked()) objSave.setplacedeliv(d_rdogrpplacedeliv[i]);
         }

         objSave.setplacedelivOth(txtplacedelivOth.getText().toString());
         objSave.setdelivdate(dtpdelivdate.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpdelivdate.getText().toString()) : dtpdelivdate.getText().toString());
         objSave.setdelivdateDK((chkdelivdateDK.isChecked()?"1":(secdelivdateDK.isShown()?"2":"")));
         objSave.setdelivtime(txtdelivtime.getText().toString());
         objSave.setdelivtimeDK((chkdelivtimeDK.isChecked()?"1":(secdelivtimeDK.isShown()?"2":"")));
         objSave.settypebirth((spntypebirth.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spntypebirth.getSelectedItem().toString(), "-")));
         objSave.setTimecsec((spnTimecsec.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnTimecsec.getSelectedItem().toString(), "-")));
         String[] d_rdogrpToldcsecreas = new String[] {"1","2","9"};
         objSave.setToldcsecreas("");
         for (int i = 0; i < rdogrpToldcsecreas.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpToldcsecreas.getChildAt(i);
             if (rb.isChecked()) objSave.setToldcsecreas(d_rdogrpToldcsecreas[i]);
         }

         objSave.setCsecreas((spnCsecreas.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnCsecreas.getSelectedItem().toString(), "-")));
         objSave.setOthReason(txtOthReason.getText().toString());
         String[] d_rdogrpBwgted = new String[] {"1","2","9"};
         objSave.setBwgted("");
         for (int i = 0; i < rdogrpBwgted.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpBwgted.getChildAt(i);
             if (rb.isChecked()) objSave.setBwgted(d_rdogrpBwgted[i]);
         }

         objSave.setBwgt(txtBwgt.getText().toString());
         String[] d_rdogrpBwgtDK = new String[] {"1","9"};
         objSave.setBwgtDK("");
         for (int i = 0; i < rdogrpBwgtDK.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpBwgtDK.getChildAt(i);
             if (rb.isChecked()) objSave.setBwgtDK(d_rdogrpBwgtDK[i]);
         }

         String[] d_rdogrpbwgtmeth = new String[] {"1","2","9"};
         objSave.setbwgtmeth("");
         for (int i = 0; i < rdogrpbwgtmeth.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpbwgtmeth.getChildAt(i);
             if (rb.isChecked()) objSave.setbwgtmeth(d_rdogrpbwgtmeth[i]);
         }

         objSave.setBsex((spnBsex.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnBsex.getSelectedItem().toString(), "-")));
         objSave.setperceivesize((spnperceivesize.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnperceivesize.getSelectedItem().toString(), "-")));
         String[] d_rdogrpanybcomp = new String[] {"1","2","9"};
         objSave.setanybcomp("");
         for (int i = 0; i < rdogrpanybcomp.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpanybcomp.getChildAt(i);
             if (rb.isChecked()) objSave.setanybcomp(d_rdogrpanybcomp[i]);
         }

         objSave.setbcompA((chkbcompA.isChecked()?"1":(secbcompA.isShown()?"2":"")));
         objSave.setbcompB((chkbcompB.isChecked()?"1":(secbcompB.isShown()?"2":"")));
         objSave.setbcompC((chkbcompC.isChecked()?"1":(secbcompC.isShown()?"2":"")));
         objSave.setbcompD((chkbcompD.isChecked()?"1":(secbcompD.isShown()?"2":"")));
         objSave.setbcompE((chkbcompE.isChecked()?"1":(secbcompE.isShown()?"2":"")));
         objSave.setbcompF((chkbcompF.isChecked()?"1":(secbcompF.isShown()?"2":"")));
         objSave.setbcompG((chkbcompG.isChecked()?"1":(secbcompG.isShown()?"2":"")));
         objSave.setbcompH((chkbcompH.isChecked()?"1":(secbcompH.isShown()?"2":"")));
         objSave.setbcompI((chkbcompI.isChecked()?"1":(secbcompI.isShown()?"2":"")));
         objSave.setbcompIOth(txtbcompIOth.getText().toString());
         objSave.setbcompJ((chkbcompJ.isChecked()?"1":(secbcompJ.isShown()?"2":"")));
         objSave.setnightsnum(txtnightsnum.getText().toString());
         objSave.setnightsnumDK((chknightsnumDK.isChecked()?"1":(secnightsnumDK.isShown()?"2":"")));
         String[] d_rdogrpbnotif = new String[] {"1","2","3","9"};
         objSave.setbnotif("");
         for (int i = 0; i < rdogrpbnotif.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpbnotif.getChildAt(i);
             if (rb.isChecked()) objSave.setbnotif(d_rdogrpbnotif[i]);
         }

         String[] d_rdogrpbcert = new String[] {"1","2","9"};
         objSave.setbcert("");
         for (int i = 0; i < rdogrpbcert.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpbcert.getChildAt(i);
             if (rb.isChecked()) objSave.setbcert(d_rdogrpbcert[i]);
         }

         String[] d_rdogrpbcertknow = new String[] {"1","2","9"};
         objSave.setbcertknow("");
         for (int i = 0; i < rdogrpbcertknow.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpbcertknow.getChildAt(i);
             if (rb.isChecked()) objSave.setbcertknow(d_rdogrpbcertknow[i]);
         }

         objSave.setbcerttime(txtbcerttime.getText().toString());
         String[] d_rdogrpbcerttimeWM = new String[] {"1","2","9"};
         objSave.setbcerttimeWM("");
         for (int i = 0; i < rdogrpbcerttimeWM.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpbcerttimeWM.getChildAt(i);
             if (rb.isChecked()) objSave.setbcerttimeWM(d_rdogrpbcerttimeWM[i]);
         }

         //objSave.setanybcertcon((spnanybcertcon.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnanybcertcon.getSelectedItem().toString(), "-")));
         String[] d_rdogranybcertcon = new String[] {"1","2","9"};
         objSave.setanybcertcon("");
         for (int i = 0; i < rdogrpanybcertcon.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpanybcertcon.getChildAt(i);
             if (rb.isChecked()) objSave.setanybcertcon(d_rdogranybcertcon[i]);
         }

         //objSave.setbcertcon((spnbcertcon.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnbcertcon.getSelectedItem().toString(), "-")));

         objSave.setbcertcona(chkbcertcona.isChecked()?"1":(secbcertcon.isShown()?"2":""));
         objSave.setbcertconb(chkbcertconb.isChecked()?"1":(secbcertcon.isShown()?"2":""));
         objSave.setbcertconc(chkbcertconc.isChecked()?"1":(secbcertcon.isShown()?"2":""));
         objSave.setbcertcond(chkbcertcond.isChecked()?"1":(secbcertcon.isShown()?"2":""));
         objSave.setbcertcone(chkbcertcone.isChecked()?"1":(secbcertcon.isShown()?"2":""));

         objSave.setbcertconOth(txtbcertconOth.getText().toString());
         objSave.setComments(txtcomments.getText().toString());

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
             /*Intent returnIntent = new Intent();
             returnIntent.putExtra("res", "");
             setResult(Activity.RESULT_OK, returnIntent);*/

             Connection.MessageBoxNotClose(RecallSurvS1.this, "Saved Successfully");
         }
         else{
             Connection.MessageBox(RecallSurvS1.this, status);
             return;
         }
     }
     catch(Exception  e)
     {
         Connection.MessageBox(RecallSurvS1.this, e.getMessage());
         return;
     }
 }

 private void DataSearch(String CountryCode, String FaciCode, String DataID)
     {
       try
        {
     
           RadioButton rb;
           RecallSurvS1_DataModel d = new RecallSurvS1_DataModel();
           String SQL = "Select * from "+ TableName +"  Where CountryCode='"+ CountryCode +"' and FaciCode='"+ FaciCode +"' and DataID='"+ DataID +"'";
           List<RecallSurvS1_DataModel> data = d.SelectAll(this, SQL);
           for(RecallSurvS1_DataModel item : data){
             txtCountryCode.setText(item.getCountryCode());
             txtFaciCode.setText(item.getFaciCode());
             txtDataID.setText(item.getDataID());
             txtStudyID.setText(item.getStudyID());
             String[] d_rdogrpConsentMRS = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpConsentMRS.length; i++)
             {
                 if (item.getConsentMRS().equals(String.valueOf(d_rdogrpConsentMRS[i])))
                 {
                     rb = (RadioButton)rdogrpConsentMRS.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpConsentFollo = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpConsentFollo.length; i++)
             {
                 if (item.getConsentFollo().equals(String.valueOf(d_rdogrpConsentFollo[i])))
                 {
                     rb = (RadioButton)rdogrpConsentFollo.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             dtpdoi.setText(item.getdoi().toString().length()==0 ? "" : Global.DateConvertDMY(item.getdoi()));
             txttoi.setText(item.gettoi());
             spnlang.setSelection(Global.SpinnerItemPositionAnyLength(spnlang, item.getlang()));
               txtlangOth.setText(item.getlangOth());

             if(item.getinterp().equals("1")) rdointerp1.setChecked(true); else if(item.getinterp().equals("2")) rdointerp2.setChecked(true);
             txtinterpName.setText(item.getinterpName());

             spncconditionb.setSelection(Global.SpinnerItemPositionAnyLength(spncconditionb, item.getcconditionb()));
             String[] d_rdogrpmatconsent = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpmatconsent.length; i++)
             {
                 if (item.getmatconsent().equals(String.valueOf(d_rdogrpmatconsent[i])))
                 {
                     rb = (RadioButton)rdogrpmatconsent.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             spnMatbdateM.setSelection(Global.SpinnerItemPositionAnyLength(spnMatbdateM, item.getMatbdateM()));
             txtMatbdateY.setText(item.getMatbdateY());
             if(item.getMatbdateDK().equals("1"))
             {
                chkMatbdateDK.setChecked(true);
             }
             else if(item.getMatbdateDK().equals("2"))
             {
                chkMatbdateDK.setChecked(false);
             }
             txtMatage.setText(item.getMatage());
             if(item.getMatageDK().equals("1"))
             {
                chkMatageDK.setChecked(true);
             }
             else if(item.getMatageDK().equals("2"))
             {
                chkMatageDK.setChecked(false);
             }

             txtFormEdu.setText(item.getFormEdu());
             if(item.getFormEduDK().equals("1")) chkFormEduDK.setChecked(true); else chkFormEduDK.setChecked(false);

             spnaddr1.setSelection(Global.SpinnerItemPositionAnyLength(spnaddr1, item.getaddr1()));
             txtaddr2.setText(item.getaddr2());
               txtaddr3.setText(item.getaddr3());
               txtaddr4.setText(item.getaddr4());
             //spnaddr2.setSelection(Global.SpinnerItemPositionAnyLength(spnaddr2, item.getaddr2()));
             //spnaddr3.setSelection(Global.SpinnerItemPositionAnyLength(spnaddr3, item.getaddr3()));
             //spnaddr4.setSelection(Global.SpinnerItemPositionAnyLength(spnaddr4, item.getaddr4()));
             txtAddressDetail.setText(item.getAddressDetail());
             String[] d_rdogrpmatmobile = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpmatmobile.length; i++)
             {
                 if (item.getmatmobile().equals(String.valueOf(d_rdogrpmatmobile[i])))
                 {
                     rb = (RadioButton)rdogrpmatmobile.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtMatmobnum.setText(item.getMatmobnum());
             if(item.getMatmobnumDK().equals("1"))
             {
                chkMatmobnumDK.setChecked(true);
             }
             else if(item.getMatmobnumDK().equals("2"))
             {
                chkMatmobnumDK.setChecked(false);
             }
             txtMatmobnum1.setText(item.getMatmobnum1());
             if(item.getMatmobnum1DK().equals("1"))
             {
                chkMatmobnum1DK.setChecked(true);
             }
             else if(item.getMatmobnum1DK().equals("2"))
             {
                chkMatmobnum1DK.setChecked(false);
             }
             String[] d_rdogrphusmob = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrphusmob.length; i++)
             {
                 if (item.gethusmob().equals(String.valueOf(d_rdogrphusmob[i])))
                 {
                     rb = (RadioButton)rdogrphusmob.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtHusmobnum.setText(item.getHusmobnum());
             if(item.getHusmobnumDK().equals("1"))
             {
                chkHusmobnumDK.setChecked(true);
             }
             else if(item.getHusmobnumDK().equals("2"))
             {
                chkHusmobnumDK.setChecked(false);
             }
             txtHusmobnum2.setText(item.getHusmobnum2());
             if(item.getHusmobnum2DK().equals("1"))
             {
                chkHusmobnum2DK.setChecked(true);
             }
             else if(item.getHusmobnum2DK().equals("2"))
             {
                chkHusmobnum2DK.setChecked(false);
             }
             txtcontact1.setText(item.getcontact1());
             String[] d_rdogrpeddknown = new String[] {"1","2","9"};
             for (int i = 0; i < d_rdogrpeddknown.length; i++)
             {
                 if (item.geteddknown().equals(String.valueOf(d_rdogrpeddknown[i])))
                 {
                     rb = (RadioButton)rdogrpeddknown.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             dtpEdd.setText(item.getEdd().toString().length()==0 ? "" : Global.DateConvertDMY(item.getEdd()));
             if(item.getEddDK().equals("1"))
             {
                rdoEddDK1.setChecked(true);
             }
             else if(item.getEddDK().equals("2"))
             {
                  rdoEddDK2.setChecked(true);
             }

             txtEddDKOth.setText(item.getEddDKOth());
                if(item.getGametha().equals("1")) chkGametha.setChecked(true); else chkGametha.setChecked(false);
                if(item.getGamethb().equals("1")) chkGamethb.setChecked(true); else chkGamethb.setChecked(false);
                if(item.getGamethc().equals("1")) chkGamethc.setChecked(true); else chkGamethc.setChecked(false);
                if(item.getGamethd().equals("1")) chkGamethd.setChecked(true); else chkGamethd.setChecked(false);
                if(item.getGamethe().equals("1")) chkGamethe.setChecked(true); else chkGamethe.setChecked(false);
                txtGametheOth.setText(item.getGametheOth());
                if(item.getGamethf().equals("1")) chkGamethf.setChecked(true); else chkGamethf.setChecked(false);

             txtga1anc.setText(item.getga1anc());
             String[] d_rdogrpga1ancWM = new String[] {"1","2","9"};
             for (int i = 0; i < d_rdogrpga1ancWM.length; i++)
             {
                 if (item.getga1ancWM().equals(String.valueOf(d_rdogrpga1ancWM[i])))
                 {
                     rb = (RadioButton)rdogrpga1ancWM.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             spnantcarenum.setSelection(Global.SpinnerItemPositionAnyLength(spnantcarenum, item.getantcarenum()));
             txtga.setText(item.getga());
             String[] d_rdogrpgaWM = new String[] {"1","2","9"};
             for (int i = 0; i < d_rdogrpgaWM.length; i++)
             {
                 if (item.getgaWM().equals(String.valueOf(d_rdogrpgaWM[i])))
                 {
                     rb = (RadioButton)rdogrpgaWM.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpbheart = new String[] {"1","2","3","9"};
             for (int i = 0; i < d_rdogrpbheart.length; i++)
             {
                 if (item.getbheart().equals(String.valueOf(d_rdogrpbheart[i])))
                 {
                     rb = (RadioButton)rdogrpbheart.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             //spnbcondition.setSelection(Global.SpinnerItemPositionAnyLength(spnbcondition, item.getbcondition()));
               String[] d_rdogrpbcondition = new String[] {"1","2","9"};
               for (int i = 0; i < d_rdogrpbcondition.length; i++)
               {
                   if (item.getbcondition().equals(String.valueOf(d_rdogrpbcondition[i])))
                   {
                       rb = (RadioButton)rdogrpbcondition.getChildAt(i);
                       rb.setChecked(true);
                   }
               }

             String[] d_rdogrpplacedeliv = new String[] {"1","2","3","4","5"};
             for (int i = 0; i < d_rdogrpplacedeliv.length; i++)
             {
                 if (item.getplacedeliv().equals(String.valueOf(d_rdogrpplacedeliv[i])))
                 {
                     rb = (RadioButton)rdogrpplacedeliv.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtplacedelivOth.setText(item.getplacedelivOth());
             dtpdelivdate.setText(item.getdelivdate().toString().length()==0 ? "" : Global.DateConvertDMY(item.getdelivdate()));
             if(item.getdelivdateDK().equals("1"))
             {
                chkdelivdateDK.setChecked(true);
             }
             else if(item.getdelivdateDK().equals("2"))
             {
                chkdelivdateDK.setChecked(false);
             }
             txtdelivtime.setText(item.getdelivtime());
             if(item.getdelivtimeDK().equals("1"))
             {
                chkdelivtimeDK.setChecked(true);
             }
             else if(item.getdelivtimeDK().equals("2"))
             {
                chkdelivtimeDK.setChecked(false);
             }
             spntypebirth.setSelection(Global.SpinnerItemPositionAnyLength(spntypebirth, item.gettypebirth()));
             spnTimecsec.setSelection(Global.SpinnerItemPositionAnyLength(spnTimecsec, item.getTimecsec()));
             String[] d_rdogrpToldcsecreas = new String[] {"1","2","9"};
             for (int i = 0; i < d_rdogrpToldcsecreas.length; i++)
             {
                 if (item.getToldcsecreas().equals(String.valueOf(d_rdogrpToldcsecreas[i])))
                 {
                     rb = (RadioButton)rdogrpToldcsecreas.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             spnCsecreas.setSelection(Global.SpinnerItemPositionAnyLength(spnCsecreas, item.getCsecreas()));
             txtOthReason.setText(item.getOthReason());
             String[] d_rdogrpBwgted = new String[] {"1","2","9"};
             for (int i = 0; i < d_rdogrpBwgted.length; i++)
             {
                 if (item.getBwgted().equals(String.valueOf(d_rdogrpBwgted[i])))
                 {
                     rb = (RadioButton)rdogrpBwgted.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtBwgt.setText(item.getBwgt());
             String[] d_rdogrpBwgtDK = new String[] {"1","9"};
             for (int i = 0; i < d_rdogrpBwgtDK.length; i++)
             {
                 if (item.getBwgtDK().equals(String.valueOf(d_rdogrpBwgtDK[i])))
                 {
                     rb = (RadioButton)rdogrpBwgtDK.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpbwgtmeth = new String[] {"1","2","9"};
             for (int i = 0; i < d_rdogrpbwgtmeth.length; i++)
             {
                 if (item.getbwgtmeth().equals(String.valueOf(d_rdogrpbwgtmeth[i])))
                 {
                     rb = (RadioButton)rdogrpbwgtmeth.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             spnBsex.setSelection(Global.SpinnerItemPositionAnyLength(spnBsex, item.getBsex()));
             spnperceivesize.setSelection(Global.SpinnerItemPositionAnyLength(spnperceivesize, item.getperceivesize()));
             String[] d_rdogrpanybcomp = new String[] {"1","2","9"};
             for (int i = 0; i < d_rdogrpanybcomp.length; i++)
             {
                 if (item.getanybcomp().equals(String.valueOf(d_rdogrpanybcomp[i])))
                 {
                     rb = (RadioButton)rdogrpanybcomp.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             if(item.getbcompA().equals("1"))
             {
                chkbcompA.setChecked(true);
             }
             else if(item.getbcompA().equals("2"))
             {
                chkbcompA.setChecked(false);
             }
             if(item.getbcompB().equals("1"))
             {
                chkbcompB.setChecked(true);
             }
             else if(item.getbcompB().equals("2"))
             {
                chkbcompB.setChecked(false);
             }
             if(item.getbcompC().equals("1"))
             {
                chkbcompC.setChecked(true);
             }
             else if(item.getbcompC().equals("2"))
             {
                chkbcompC.setChecked(false);
             }
             if(item.getbcompD().equals("1"))
             {
                chkbcompD.setChecked(true);
             }
             else if(item.getbcompD().equals("2"))
             {
                chkbcompD.setChecked(false);
             }
             if(item.getbcompE().equals("1"))
             {
                chkbcompE.setChecked(true);
             }
             else if(item.getbcompE().equals("2"))
             {
                chkbcompE.setChecked(false);
             }
             if(item.getbcompF().equals("1"))
             {
                chkbcompF.setChecked(true);
             }
             else if(item.getbcompF().equals("2"))
             {
                chkbcompF.setChecked(false);
             }
             if(item.getbcompG().equals("1"))
             {
                chkbcompG.setChecked(true);
             }
             else if(item.getbcompG().equals("2"))
             {
                chkbcompG.setChecked(false);
             }
             if(item.getbcompH().equals("1"))
             {
                chkbcompH.setChecked(true);
             }
             else if(item.getbcompH().equals("2"))
             {
                chkbcompH.setChecked(false);
             }
             if(item.getbcompI().equals("1"))
             {
                chkbcompI.setChecked(true);
             }
             else if(item.getbcompI().equals("2"))
             {
                chkbcompI.setChecked(false);
             }
             txtbcompIOth.setText(item.getbcompIOth());
             if(item.getbcompJ().equals("1"))
             {
                chkbcompJ.setChecked(true);
             }
             else if(item.getbcompJ().equals("2"))
             {
                chkbcompJ.setChecked(false);
             }
             txtnightsnum.setText(item.getnightsnum());
             if(item.getnightsnumDK().equals("1"))
             {
                chknightsnumDK.setChecked(true);
             }
             else if(item.getnightsnumDK().equals("2"))
             {
                chknightsnumDK.setChecked(false);
             }
             String[] d_rdogrpbnotif = new String[] {"1","2","3","9"};
             for (int i = 0; i < d_rdogrpbnotif.length; i++)
             {
                 if (item.getbnotif().equals(String.valueOf(d_rdogrpbnotif[i])))
                 {
                     rb = (RadioButton)rdogrpbnotif.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpbcert = new String[] {"1","2","9"};
             for (int i = 0; i < d_rdogrpbcert.length; i++)
             {
                 if (item.getbcert().equals(String.valueOf(d_rdogrpbcert[i])))
                 {
                     rb = (RadioButton)rdogrpbcert.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpbcertknow = new String[] {"1","2","9"};
             for (int i = 0; i < d_rdogrpbcertknow.length; i++)
             {
                 if (item.getbcertknow().equals(String.valueOf(d_rdogrpbcertknow[i])))
                 {
                     rb = (RadioButton)rdogrpbcertknow.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtbcerttime.setText(item.getbcerttime());
             String[] d_rdogrpbcerttimeWM = new String[] {"1","2","9"};
             for (int i = 0; i < d_rdogrpbcerttimeWM.length; i++)
             {
                 if (item.getbcerttimeWM().equals(String.valueOf(d_rdogrpbcerttimeWM[i])))
                 {
                     rb = (RadioButton)rdogrpbcerttimeWM.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             //spnanybcertcon.setSelection(Global.SpinnerItemPositionAnyLength(spnanybcertcon, item.getanybcertcon()));
               String[] d_rdogrpanybcertcon = new String[] {"1","2","9"};
               for (int i = 0; i < d_rdogrpanybcertcon.length; i++)
               {
                   if (item.getanybcertcon().equals(String.valueOf(d_rdogrpanybcertcon[i])))
                   {
                       rb = (RadioButton)rdogrpanybcertcon.getChildAt(i);
                       rb.setChecked(true);
                   }
               }

             //spnbcertcon.setSelection(Global.SpinnerItemPositionAnyLength(spnbcertcon, item.getbcertcon()));
               if(item.getbcertcona().equals("1")) chkbcertcona.setChecked(true); else  chkbcertcona.setChecked(false);
               if(item.getbcertconb().equals("1")) chkbcertconb.setChecked(true); else  chkbcertconb.setChecked(false);
               if(item.getbcertconc().equals("1")) chkbcertconc.setChecked(true); else  chkbcertconc.setChecked(false);
               if(item.getbcertcond().equals("1")) chkbcertcond.setChecked(true); else  chkbcertcond.setChecked(false);
               if(item.getbcertcone().equals("1")) chkbcertcone.setChecked(true); else  chkbcertcone.setChecked(false);

             txtbcertconOth.setText(item.getbcertconOth());
               txtcomments.setText(item.getComments());
           }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(RecallSurvS1.this, e.getMessage());
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


              dtpDate = (EditText)findViewById(R.id.dtpdoi);
             if (VariableID.equals("btndoi"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpdoi);
              }
             else if (VariableID.equals("btnEdd"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpEdd);
                   rdogrpEddDK.clearCheck();
              }
             else if (VariableID.equals("btndelivdate"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpdelivdate);
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


              tpTime = (EditText)findViewById(R.id.txttoi);
             if (VariableID.equals("btntoi"))
              {
                  tpTime = (EditText)findViewById(R.id.txttoi);
              }
             else if (VariableID.equals("btndelivtime"))
              {
                  tpTime = (EditText)findViewById(R.id.txtdelivtime);
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