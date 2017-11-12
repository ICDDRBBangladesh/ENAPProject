
 package org.icddrb.enap;


 //Android Manifest Code
 //<activity android:name=".LD_DataExt_old" android:label="LD_DataExt_old" />
 import java.util.ArrayList;
 import java.util.Calendar;
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
 import android.location.Location;
 import android.location.LocationListener;
 import android.location.LocationManager;
 import android.net.Uri;
 import android.provider.Settings;
 import android.text.Editable;
 import android.text.TextWatcher;
 import android.view.KeyEvent;
 import android.os.Bundle;
 import android.view.View;
 import android.view.MotionEvent;
 import android.widget.AdapterView;
 import android.widget.Button;
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
 import android.widget.ArrayAdapter;

 import Utility.*;
 import Common.*;

 public class LD_DataExt_old extends Activity {
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
         LinearLayout secreftypebirth;
         View linereftypebirth;
         TextView Vlblreftypebirth;
         RadioGroup rdogrpreftypebirth;
         
         RadioButton rdoreftypebirth1;
         RadioButton rdoreftypebirth2;
         RadioButton rdoreftypebirth3;
         RadioButton rdoreftypebirth4;
         RadioButton rdoreftypebirth5;

         LinearLayout secrefdelivdate;
         View linerefdelivdate;
         TextView Vlblrefdelivdate;
         EditText dtprefdelivdate;
         LinearLayout secrefdelivtime;
         View linerefdelivtime;
         TextView Vlblrefdelivtime;
         EditText txtrefdelivtime;
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
         LinearLayout secrefbStatus;
         View linerefbStatus;
         TextView VlblrefbStatus;
         RadioGroup rdogrprefbStatus;
         
         RadioButton rdorefbStatus1;
         RadioButton rdorefbStatus2;
         RadioButton rdorefbStatus3;
         RadioButton rdorefbStatus4;
         LinearLayout secRefsbtype;
         View lineRefsbtype;
         TextView VlblRefsbtype;
         RadioGroup rdogrpRefsbtype;
         
         RadioButton rdoRefsbtype1;
         RadioButton rdoRefsbtype2;
         RadioButton rdoRefsbtype3;
         RadioButton rdoRefsbtype4;
         LinearLayout secrefbsex;
         View linerefbsex;
         TextView Vlblrefbsex;
         RadioGroup rdogrprefbsex;
         
         RadioButton rdorefbsex1;
         RadioButton rdorefbsex2;
         RadioButton rdorefbsex3;
         RadioButton rdorefbsex4;
         RadioButton rdorefbsex5;
         LinearLayout secrefbwgt;
         View linerefbwgt;
         TextView Vlblrefbwgt;
         EditText txtrefbwgt;
         LinearLayout secrefbwgtnot;
         View linerefbwgtnot;
         TextView Vlblrefbwgtnot;
         RadioGroup rdogrprefbwgtnot;
         
         RadioButton rdorefbwgtnot1;
         RadioButton rdorefbwgtnot2;
         LinearLayout secrefbstim;
         View linerefbstim;
         TextView Vlblrefbstim;
         RadioGroup rdogrprefbstim;
         
         RadioButton rdorefbstim1;
         RadioButton rdorefbstim2;
         RadioButton rdorefbstim3;
         RadioButton rdorefbstim4;
         LinearLayout secrefbplast;
         View linerefbplast;
         TextView Vlblrefbplast;
         RadioGroup rdogrprefbplast;
         
         RadioButton rdorefbplast1;
         RadioButton rdorefbplast2;
         RadioButton rdorefbplast3;
         RadioButton rdorefbplast4;
         LinearLayout secrefappcord;
         View linerefappcord;
         TextView Vlblrefappcord;
         RadioGroup rdogrprefappcord;
         
         RadioButton rdorefappcord1;
         RadioButton rdorefappcord2;
         RadioButton rdorefappcord3;
         RadioButton rdorefappcord4;
         LinearLayout secrefbbfd;
         View linerefbbfd;
         TextView Vlblrefbbfd;
         RadioGroup rdogrprefbbfd;
         
         RadioButton rdorefbbfd1;
         RadioButton rdorefbbfd2;
         RadioButton rdorefbbfd3;
         RadioButton rdorefbbfd4;
         RadioButton rdorefbbfd5;
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
         LinearLayout secrefbcond;
         View linerefbcond;
         TextView Vlblrefbcond;
         RadioGroup rdogrprefbcond;
         
         RadioButton rdorefbcond1;
         RadioButton rdorefbcond2;
         RadioButton rdorefbcond3;
         RadioButton rdorefbcond4;
         LinearLayout secrefdodld;
         View linerefdodld;
         TextView Vlblrefdodld;
         EditText dtprefdodld;
         LinearLayout secreftodld;
         View linereftodld;
         TextView Vlblreftodld;
         EditText txtreftodld;
         LinearLayout secrefdisoutld;
         View linerefdisoutld;
         TextView Vlblrefdisoutld;
         RadioGroup rdogrprefdisoutld;
         
         RadioButton rdorefdisoutld1;
         RadioButton rdorefdisoutld2;
         RadioButton rdorefdisoutld3;
         RadioButton rdorefdisoutld4;
         RadioButton rdorefdisoutld5;
         LinearLayout secrefTransPlace;
         View linerefTransPlace;
         TextView VlblrefTransPlace;
         EditText txtrefTransPlace;
         LinearLayout secrefmatcond;
         View linerefmatcond;
         TextView Vlblrefmatcond;
         Spinner spnrefmatcond;
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
         setContentView(R.layout.ld_dataext_old);
         C = new Connection(this);
         g = Global.getInstance();

         STARTTIME = g.CurrentTime24();
         DEVICEID  = sp.getValue(this, "deviceid");
         ENTRYUSER = sp.getValue(this, "userid");

         IDbundle = getIntent().getExtras();
         COUNTRYCODE = IDbundle.getString("CountryCode");
         FACICODE = IDbundle.getString("FaciCode");
         DATAID = IDbundle.getString("DataID");

         TableName = "LD_DataExt_old";

         //turnGPSOn();

         //GPS Location
         //FindLocation();
         // Double.toString(currentLatitude);
         // Double.toString(currentLongitude);
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(LD_DataExt_old.this);
                 adb.setTitle("Close");
                 adb.setMessage("Do you want to close this form[Yes/No]?");
                 adb.setNegativeButton("No", null);
                 adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                     public void onClick(DialogInterface dialog, int which) {
                         finish();
                     }});
                 adb.show();
             }});


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
         secreftypebirth=(LinearLayout)findViewById(R.id.secreftypebirth);
         linereftypebirth=(View)findViewById(R.id.linereftypebirth);
         Vlblreftypebirth = (TextView) findViewById(R.id.Vlblreftypebirth);
         rdogrpreftypebirth = (RadioGroup) findViewById(R.id.rdogrpreftypebirth);
         
         rdoreftypebirth1 = (RadioButton) findViewById(R.id.rdoreftypebirth1);
         rdoreftypebirth2 = (RadioButton) findViewById(R.id.rdoreftypebirth2);
         rdoreftypebirth3 = (RadioButton) findViewById(R.id.rdoreftypebirth3);
         rdoreftypebirth4 = (RadioButton) findViewById(R.id.rdoreftypebirth4);
         rdoreftypebirth5 = (RadioButton) findViewById(R.id.rdoreftypebirth5);

         secrefdelivdate=(LinearLayout)findViewById(R.id.secrefdelivdate);
         linerefdelivdate=(View)findViewById(R.id.linerefdelivdate);
         Vlblrefdelivdate=(TextView) findViewById(R.id.Vlblrefdelivdate);
         dtprefdelivdate=(EditText) findViewById(R.id.dtprefdelivdate);
         secrefdelivtime=(LinearLayout)findViewById(R.id.secrefdelivtime);
         linerefdelivtime=(View)findViewById(R.id.linerefdelivtime);
         Vlblrefdelivtime=(TextView) findViewById(R.id.Vlblrefdelivtime);
         txtrefdelivtime=(EditText) findViewById(R.id.txtrefdelivtime);
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
         secrefbStatus=(LinearLayout)findViewById(R.id.secrefbStatus);
         linerefbStatus=(View)findViewById(R.id.linerefbStatus);
         VlblrefbStatus = (TextView) findViewById(R.id.VlblrefbStatus);
         rdogrprefbStatus = (RadioGroup) findViewById(R.id.rdogrprefbStatus);
         
         rdorefbStatus1 = (RadioButton) findViewById(R.id.rdorefbStatus1);
         rdorefbStatus2 = (RadioButton) findViewById(R.id.rdorefbStatus2);
         rdorefbStatus3 = (RadioButton) findViewById(R.id.rdorefbStatus3);
         rdorefbStatus4 = (RadioButton) findViewById(R.id.rdorefbStatus4);
         rdogrprefbStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrprefbStatus = new String[] {"1","2","8","9"};
             for (int i = 0; i < rdogrprefbStatus.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrprefbStatus.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrprefbStatus[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                    secRefsbtype.setVisibility(View.GONE);
                    lineRefsbtype.setVisibility(View.GONE);
                    rdogrpRefsbtype.clearCheck();
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secRefsbtype.setVisibility(View.GONE);
                    lineRefsbtype.setVisibility(View.GONE);
                    rdogrpRefsbtype.clearCheck();
             }
             else if(rbData.equalsIgnoreCase("9"))
             {
                    secRefsbtype.setVisibility(View.GONE);
                    lineRefsbtype.setVisibility(View.GONE);
                    rdogrpRefsbtype.clearCheck();
             }
             else
             {
                    secRefsbtype.setVisibility(View.VISIBLE);
                    lineRefsbtype.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secRefsbtype=(LinearLayout)findViewById(R.id.secRefsbtype);
         lineRefsbtype=(View)findViewById(R.id.lineRefsbtype);
         VlblRefsbtype = (TextView) findViewById(R.id.VlblRefsbtype);
         rdogrpRefsbtype = (RadioGroup) findViewById(R.id.rdogrpRefsbtype);
         
         rdoRefsbtype1 = (RadioButton) findViewById(R.id.rdoRefsbtype1);
         rdoRefsbtype2 = (RadioButton) findViewById(R.id.rdoRefsbtype2);
         rdoRefsbtype3 = (RadioButton) findViewById(R.id.rdoRefsbtype3);
         rdoRefsbtype4 = (RadioButton) findViewById(R.id.rdoRefsbtype4);
         secrefbsex=(LinearLayout)findViewById(R.id.secrefbsex);
         linerefbsex=(View)findViewById(R.id.linerefbsex);
         Vlblrefbsex = (TextView) findViewById(R.id.Vlblrefbsex);
         rdogrprefbsex = (RadioGroup) findViewById(R.id.rdogrprefbsex);
         
         rdorefbsex1 = (RadioButton) findViewById(R.id.rdorefbsex1);
         rdorefbsex2 = (RadioButton) findViewById(R.id.rdorefbsex2);
         rdorefbsex3 = (RadioButton) findViewById(R.id.rdorefbsex3);
         rdorefbsex4 = (RadioButton) findViewById(R.id.rdorefbsex4);
         rdorefbsex5 = (RadioButton) findViewById(R.id.rdorefbsex5);
         secrefbwgt=(LinearLayout)findViewById(R.id.secrefbwgt);
         linerefbwgt=(View)findViewById(R.id.linerefbwgt);
         Vlblrefbwgt=(TextView) findViewById(R.id.Vlblrefbwgt);
         txtrefbwgt=(EditText) findViewById(R.id.txtrefbwgt);
         secrefbwgtnot=(LinearLayout)findViewById(R.id.secrefbwgtnot);
         linerefbwgtnot=(View)findViewById(R.id.linerefbwgtnot);
         Vlblrefbwgtnot = (TextView) findViewById(R.id.Vlblrefbwgtnot);
         rdogrprefbwgtnot = (RadioGroup) findViewById(R.id.rdogrprefbwgtnot);
         
         rdorefbwgtnot1 = (RadioButton) findViewById(R.id.rdorefbwgtnot1);
         rdorefbwgtnot2 = (RadioButton) findViewById(R.id.rdorefbwgtnot2);
         secrefbstim=(LinearLayout)findViewById(R.id.secrefbstim);
         linerefbstim=(View)findViewById(R.id.linerefbstim);
         Vlblrefbstim = (TextView) findViewById(R.id.Vlblrefbstim);
         rdogrprefbstim = (RadioGroup) findViewById(R.id.rdogrprefbstim);
         
         rdorefbstim1 = (RadioButton) findViewById(R.id.rdorefbstim1);
         rdorefbstim2 = (RadioButton) findViewById(R.id.rdorefbstim2);
         rdorefbstim3 = (RadioButton) findViewById(R.id.rdorefbstim3);
         rdorefbstim4 = (RadioButton) findViewById(R.id.rdorefbstim4);
         secrefbplast=(LinearLayout)findViewById(R.id.secrefbplast);
         linerefbplast=(View)findViewById(R.id.linerefbplast);
         Vlblrefbplast = (TextView) findViewById(R.id.Vlblrefbplast);
         rdogrprefbplast = (RadioGroup) findViewById(R.id.rdogrprefbplast);
         
         rdorefbplast1 = (RadioButton) findViewById(R.id.rdorefbplast1);
         rdorefbplast2 = (RadioButton) findViewById(R.id.rdorefbplast2);
         rdorefbplast3 = (RadioButton) findViewById(R.id.rdorefbplast3);
         rdorefbplast4 = (RadioButton) findViewById(R.id.rdorefbplast4);
         secrefappcord=(LinearLayout)findViewById(R.id.secrefappcord);
         linerefappcord=(View)findViewById(R.id.linerefappcord);
         Vlblrefappcord = (TextView) findViewById(R.id.Vlblrefappcord);
         rdogrprefappcord = (RadioGroup) findViewById(R.id.rdogrprefappcord);
         
         rdorefappcord1 = (RadioButton) findViewById(R.id.rdorefappcord1);
         rdorefappcord2 = (RadioButton) findViewById(R.id.rdorefappcord2);
         rdorefappcord3 = (RadioButton) findViewById(R.id.rdorefappcord3);
         rdorefappcord4 = (RadioButton) findViewById(R.id.rdorefappcord4);
         secrefbbfd=(LinearLayout)findViewById(R.id.secrefbbfd);
         linerefbbfd=(View)findViewById(R.id.linerefbbfd);
         Vlblrefbbfd = (TextView) findViewById(R.id.Vlblrefbbfd);
         rdogrprefbbfd = (RadioGroup) findViewById(R.id.rdogrprefbbfd);
         
         rdorefbbfd1 = (RadioButton) findViewById(R.id.rdorefbbfd1);
         rdorefbbfd2 = (RadioButton) findViewById(R.id.rdorefbbfd2);
         rdorefbbfd3 = (RadioButton) findViewById(R.id.rdorefbbfd3);
         rdorefbbfd4 = (RadioButton) findViewById(R.id.rdorefbbfd4);
         rdorefbbfd5 = (RadioButton) findViewById(R.id.rdorefbbfd5);
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
         secrefbcond=(LinearLayout)findViewById(R.id.secrefbcond);
         linerefbcond=(View)findViewById(R.id.linerefbcond);
         Vlblrefbcond = (TextView) findViewById(R.id.Vlblrefbcond);
         rdogrprefbcond = (RadioGroup) findViewById(R.id.rdogrprefbcond);
         
         rdorefbcond1 = (RadioButton) findViewById(R.id.rdorefbcond1);
         rdorefbcond2 = (RadioButton) findViewById(R.id.rdorefbcond2);
         rdorefbcond3 = (RadioButton) findViewById(R.id.rdorefbcond3);
         rdorefbcond4 = (RadioButton) findViewById(R.id.rdorefbcond4);
         secrefdodld=(LinearLayout)findViewById(R.id.secrefdodld);
         linerefdodld=(View)findViewById(R.id.linerefdodld);
         Vlblrefdodld=(TextView) findViewById(R.id.Vlblrefdodld);
         dtprefdodld=(EditText) findViewById(R.id.dtprefdodld);
         secreftodld=(LinearLayout)findViewById(R.id.secreftodld);
         linereftodld=(View)findViewById(R.id.linereftodld);
         Vlblreftodld=(TextView) findViewById(R.id.Vlblreftodld);
         txtreftodld=(EditText) findViewById(R.id.txtreftodld);
         secrefdisoutld=(LinearLayout)findViewById(R.id.secrefdisoutld);
         linerefdisoutld=(View)findViewById(R.id.linerefdisoutld);
         Vlblrefdisoutld = (TextView) findViewById(R.id.Vlblrefdisoutld);
         rdogrprefdisoutld = (RadioGroup) findViewById(R.id.rdogrprefdisoutld);
         
         rdorefdisoutld1 = (RadioButton) findViewById(R.id.rdorefdisoutld1);
         rdorefdisoutld2 = (RadioButton) findViewById(R.id.rdorefdisoutld2);
         rdorefdisoutld3 = (RadioButton) findViewById(R.id.rdorefdisoutld3);
         rdorefdisoutld4 = (RadioButton) findViewById(R.id.rdorefdisoutld4);
         rdorefdisoutld5 = (RadioButton) findViewById(R.id.rdorefdisoutld5);
         rdogrprefdisoutld.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrprefdisoutld = new String[] {"1","2","3","8","9"};
             for (int i = 0; i < rdogrprefdisoutld.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrprefdisoutld.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrprefdisoutld[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                    secrefTransPlace.setVisibility(View.GONE);
                    linerefTransPlace.setVisibility(View.GONE);
                    txtrefTransPlace.setText("");
             }
             else if(rbData.equalsIgnoreCase("2"))
             {
                    secrefTransPlace.setVisibility(View.GONE);
                    linerefTransPlace.setVisibility(View.GONE);
                    txtrefTransPlace.setText("");
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secrefTransPlace.setVisibility(View.GONE);
                    linerefTransPlace.setVisibility(View.GONE);
                    txtrefTransPlace.setText("");
             }
             else if(rbData.equalsIgnoreCase("9"))
             {
                    secrefTransPlace.setVisibility(View.GONE);
                    linerefTransPlace.setVisibility(View.GONE);
                    txtrefTransPlace.setText("");
             }
             else
             {
                    secrefTransPlace.setVisibility(View.VISIBLE);
                    linerefTransPlace.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secrefTransPlace=(LinearLayout)findViewById(R.id.secrefTransPlace);
         linerefTransPlace=(View)findViewById(R.id.linerefTransPlace);
         VlblrefTransPlace=(TextView) findViewById(R.id.VlblrefTransPlace);
         txtrefTransPlace=(EditText) findViewById(R.id.txtrefTransPlace);
         secrefmatcond=(LinearLayout)findViewById(R.id.secrefmatcond);
         linerefmatcond=(View)findViewById(R.id.linerefmatcond);
         Vlblrefmatcond=(TextView) findViewById(R.id.Vlblrefmatcond);
         spnrefmatcond=(Spinner) findViewById(R.id.spnrefmatcond);
         List<String> listrefmatcond = new ArrayList<String>();
         
         listrefmatcond.add("");
         listrefmatcond.add("1-Discharged alive");
         listrefmatcond.add("2-Discharged but need follow-up");
         listrefmatcond.add("3-Transferred alive+where");
         listrefmatcond.add("4-Death");
         listrefmatcond.add("8-Not readable");
         listrefmatcond.add("9-Not recorded");
         ArrayAdapter<String> adptrrefmatcond= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listrefmatcond);
         spnrefmatcond.setAdapter(adptrrefmatcond);

         spnrefmatcond.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             String spnData = "";
             if (spnrefmatcond.getSelectedItem().toString().length() != 0)
             {
                 spnData = Connection.SelectedSpinnerValue(spnrefmatcond.getSelectedItem().toString(), "-");
             }
                 if(spnData.equalsIgnoreCase("1"))
                 {
                    secrefTransPlaceM.setVisibility(View.GONE);
                    linerefTransPlaceM.setVisibility(View.GONE);
                    txtrefTransPlaceM.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                    secrefTransPlaceM.setVisibility(View.GONE);
                    linerefTransPlaceM.setVisibility(View.GONE);
                    txtrefTransPlaceM.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("4"))
                 {
                    secrefTransPlaceM.setVisibility(View.GONE);
                    linerefTransPlaceM.setVisibility(View.GONE);
                    txtrefTransPlaceM.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("8"))
                 {
                    secrefTransPlaceM.setVisibility(View.GONE);
                    linerefTransPlaceM.setVisibility(View.GONE);
                    txtrefTransPlaceM.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("9"))
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
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
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
         dtprefdelivdate.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtprefdelivdate.getRight() - dtprefdelivdate.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnrefdelivdate"; showDialog(DATE_DIALOG);
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


         txtrefdelivtime.setOnTouchListener(new View.OnTouchListener() {
         @Override
         public boolean onTouch(View v, MotionEvent event) {
             final int DRAWABLE_RIGHT = 2;
             if(event.getAction() == MotionEvent.ACTION_UP) {
                 if(event.getRawX() >= (txtrefdelivtime.getRight() - txtrefdelivtime.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                     VariableID = "btnrefdelivtime"; showDialog(TIME_DIALOG);
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
                 if(checkedId==R.id.rdorefgaldnot1|checkedId==R.id.rdorefgaldnot2) txtrefgald.setText("");
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
                 if(checkedId==R.id.rdorefgacalcnot1|checkedId==R.id.rdorefgacalcnot2) dtprefgacalc.setText("");
             }
         });

         txtrefbwgt.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {
             }

             public void beforeTextChanged(CharSequence s, int start, int count,int after) {
             }
             public void afterTextChanged(Editable s) {
                 if(txtrefbwgt.getText().toString().length()>0) rdogrprefbwgtnot.clearCheck();
             }
         });
         rdogrprefbwgtnot.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(checkedId==R.id.rdorefbwgtnot1|checkedId==R.id.rdorefbwgtnot2) txtrefbwgt.setText("");
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
                 if(checkedId==R.id.rdorefpphnot1|checkedId==R.id.rdorefpphnot2) txtrefpph.setText("");
             }
         });







         //Hide all skip variables
         secRefsbtype.setVisibility(View.GONE);
         lineRefsbtype.setVisibility(View.GONE);
         secRefsbtype.setVisibility(View.GONE);
         lineRefsbtype.setVisibility(View.GONE);
         secRefsbtype.setVisibility(View.GONE);
         lineRefsbtype.setVisibility(View.GONE);
         secrefTransPlace.setVisibility(View.GONE);
         linerefTransPlace.setVisibility(View.GONE);
         secrefTransPlace.setVisibility(View.GONE);
         linerefTransPlace.setVisibility(View.GONE);
         secrefTransPlace.setVisibility(View.GONE);
         linerefTransPlace.setVisibility(View.GONE);
         secrefTransPlace.setVisibility(View.GONE);
         linerefTransPlace.setVisibility(View.GONE);
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
         Connection.MessageBox(LD_DataExt_old.this, e.getMessage());
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
             Connection.MessageBox(LD_DataExt_old.this, "Required field: CountryCode.");
             txtCountryCode.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtCountryCode.getText().toString().length()==0 ? "1" : txtCountryCode.getText().toString()) < 1 || Integer.valueOf(txtCountryCode.getText().toString().length()==0 ? "3" : txtCountryCode.getText().toString()) > 3)
           {
             Connection.MessageBox(LD_DataExt_old.this, "Value should be between 1 and 3(CountryCode).");
             txtCountryCode.requestFocus(); 
             return;	
           }
         else if(txtFaciCode.getText().toString().length()==0 & secFaciCode.isShown())
           {
             Connection.MessageBox(LD_DataExt_old.this, "Required field: Facility.");
             txtFaciCode.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtFaciCode.getText().toString().length()==0 ? "1" : txtFaciCode.getText().toString()) < 1 || Integer.valueOf(txtFaciCode.getText().toString().length()==0 ? "9" : txtFaciCode.getText().toString()) > 9)
           {
             Connection.MessageBox(LD_DataExt_old.this, "Value should be between 1 and 9(Facility).");
             txtFaciCode.requestFocus(); 
             return;	
           }
         else if(txtDataID.getText().toString().length()==0 & secDataID.isShown())
           {
             Connection.MessageBox(LD_DataExt_old.this, "Required field: Data ID.");
             txtDataID.requestFocus(); 
             return;	
           }
         DV = Global.DateValidate(dtprefdoe.getText().toString());
         if(DV.length()!=0 & secrefdoe.isShown())
           {
             Connection.MessageBox(LD_DataExt_old.this, DV);
             dtprefdoe.requestFocus(); 
             return;	
           }
         else if(!rdorefgaldnot1.isChecked() & !rdorefgaldnot2.isChecked() & txtrefgald.getText().toString().length()==0 & secrefgald.isShown())
           {
             Connection.MessageBox(LD_DataExt_old.this, "Required field: Gestational age  (completed weeks).");
             txtrefgald.requestFocus(); 
             return;	
           }
         else if(!rdorefgaldnot1.isChecked() & !rdorefgaldnot2.isChecked() & (Integer.valueOf(txtrefgald.getText().toString().length()==0 ? "1" : txtrefgald.getText().toString()) < 1 || Integer.valueOf(txtrefgald.getText().toString().length()==0 ? "99" : txtrefgald.getText().toString()) > 99))
           {
             Connection.MessageBox(LD_DataExt_old.this, "Value should be between 1 and 99(Gestational age  (completed weeks)).");
             txtrefgald.requestFocus(); 
             return;	
           }
         
         /*else if(!rdorefgaldnot1.isChecked() & !rdorefgaldnot2.isChecked() & secrefgaldnot.isShown())
           {
              Connection.MessageBox(LD_DataExt_old.this, "Select anyone options from ().");
              rdorefgaldnot1.requestFocus();
              return;
           }*/
         
         else if(!rdorefacsgiven1.isChecked() & !rdorefacsgiven2.isChecked() & !rdorefacsgiven3.isChecked() & !rdorefacsgiven4.isChecked() & !rdorefacsgiven5.isChecked() & secrefacsgiven.isShown())
           {
              Connection.MessageBox(LD_DataExt_old.this, "Select anyone options from (Antenatal corticosteroids use documented as administered?).");
              rdorefacsgiven1.requestFocus();
              return;
           }
         
         else if(!rdoreftypebirth1.isChecked() & !rdoreftypebirth2.isChecked() & !rdoreftypebirth3.isChecked() & !rdoreftypebirth4.isChecked() & !rdoreftypebirth5.isChecked() & secreftypebirth.isShown())
           {
              Connection.MessageBox(LD_DataExt_old.this, "Select anyone options from (Mode of birth/delivery).");
              rdoreftypebirth1.requestFocus();
              return;
           }
         DV = Global.DateValidate(dtprefdelivdate.getText().toString());
         if(DV.length()!=0 & secrefdelivdate.isShown())
           {
             Connection.MessageBox(LD_DataExt_old.this, DV);
             dtprefdelivdate.requestFocus(); 
             return;	
           }
         else if(txtrefdelivtime.getText().length()==0 & secrefdelivtime.isShown())
           {
             Connection.MessageBox(LD_DataExt_old.this, "Required field: Time of Delivery.");
             txtrefdelivtime.requestFocus(); 
             return;	
           }
         DV = Global.DateValidate(dtprefgacalc.getText().toString());
         if(!rdorefgacalcnot1.isChecked() & !rdorefgacalcnot1.isChecked() & DV.length()!=0 & secrefgacalc.isShown())
           {
             Connection.MessageBox(LD_DataExt_old.this, DV);
             dtprefgacalc.requestFocus(); 
             return;	
           }
         
         /*else if(!rdorefgacalcnot1.isChecked() & !rdorefgacalcnot2.isChecked() & secrefgacalcnot.isShown())
           {
              Connection.MessageBox(LD_DataExt_old.this, "Select anyone options from ().");
              rdorefgacalcnot1.requestFocus();
              return;
           }*/
         
         else if(!rdorefmedadeliv1.isChecked() & !rdorefmedadeliv2.isChecked() & !rdorefmedadeliv3.isChecked() & !rdorefmedadeliv4.isChecked() & secrefmedadeliv.isShown())
           {
              Connection.MessageBox(LD_DataExt_old.this, "Select anyone options from (Uterotonic administered for active management of the 3rd stage of labour?).");
              rdorefmedadeliv1.requestFocus();
              return;
           }
         
         else if(!rdorefbStatus1.isChecked() & !rdorefbStatus2.isChecked() & !rdorefbStatus3.isChecked() & !rdorefbStatus4.isChecked() & secrefbStatus.isShown())
           {
              Connection.MessageBox(LD_DataExt_old.this, "Select anyone options from (Birth Outcome).");
              rdorefbStatus1.requestFocus();
              return;
           }
         
         else if(!rdoRefsbtype1.isChecked() & !rdoRefsbtype2.isChecked() & !rdoRefsbtype3.isChecked() & !rdoRefsbtype4.isChecked() & secRefsbtype.isShown())
           {
              Connection.MessageBox(LD_DataExt_old.this, "Select anyone options from (Still birth type).");
              rdoRefsbtype1.requestFocus();
              return;
           }
         
         else if(!rdorefbsex1.isChecked() & !rdorefbsex2.isChecked() & !rdorefbsex3.isChecked() & !rdorefbsex4.isChecked() & !rdorefbsex5.isChecked() & secrefbsex.isShown())
           {
              Connection.MessageBox(LD_DataExt_old.this, "Select anyone options from (Sex of Child).");
              rdorefbsex1.requestFocus();
              return;
           }
         else if(!rdorefbwgtnot1.isChecked() & !rdorefbwgtnot2.isChecked() & txtrefbwgt.getText().toString().length()==0 & secrefbwgt.isShown())
           {
             Connection.MessageBox(LD_DataExt_old.this, "Required field: Birth weight (grams).");
             txtrefbwgt.requestFocus(); 
             return;	
           }
         else if(!rdorefbwgtnot1.isChecked() & !rdorefbwgtnot2.isChecked() & (Integer.valueOf(txtrefbwgt.getText().toString().length()==0 ? "1000" : txtrefbwgt.getText().toString()) < 1000 || Integer.valueOf(txtrefbwgt.getText().toString().length()==0 ? "9999" : txtrefbwgt.getText().toString()) > 9999))
           {
             Connection.MessageBox(LD_DataExt_old.this, "Value should be between 1000 and 9999(Birth weight (grams)).");
             txtrefbwgt.requestFocus(); 
             return;	
           }
         
         /*else if(!rdorefbwgtnot1.isChecked() & !rdorefbwgtnot2.isChecked() & secrefbwgtnot.isShown())
           {
              Connection.MessageBox(LD_DataExt_old.this, "Select anyone options from ().");
              rdorefbwgtnot1.requestFocus();
              return;
           }*/
         
         else if(!rdorefbstim1.isChecked() & !rdorefbstim2.isChecked() & !rdorefbstim3.isChecked() & !rdorefbstim4.isChecked() & secrefbstim.isShown())
           {
              Connection.MessageBox(LD_DataExt_old.this, "Select anyone options from (Was baby stimulated?).");
              rdorefbstim1.requestFocus();
              return;
           }
         
         else if(!rdorefbplast1.isChecked() & !rdorefbplast2.isChecked() & !rdorefbplast3.isChecked() & !rdorefbplast4.isChecked() & secrefbplast.isShown())
           {
              Connection.MessageBox(LD_DataExt_old.this, "Select anyone options from (Baby resuscitated with bag and mask?).");
              rdorefbplast1.requestFocus();
              return;
           }
         
         else if(!rdorefappcord1.isChecked() & !rdorefappcord2.isChecked() & !rdorefappcord3.isChecked() & !rdorefappcord4.isChecked() & secrefappcord.isShown())
           {
              Connection.MessageBox(LD_DataExt_old.this, "Select anyone options from (Chlorhexidine applied to cord for cleansing? ).");
              rdorefappcord1.requestFocus();
              return;
           }
         
         else if(!rdorefbbfd1.isChecked() & !rdorefbbfd2.isChecked() & !rdorefbbfd3.isChecked() & !rdorefbbfd4.isChecked() & !rdorefbbfd5.isChecked() & secrefbbfd.isShown())
           {
              Connection.MessageBox(LD_DataExt_old.this, "Select anyone options from (Breast feeding initiated).");
              rdorefbbfd1.requestFocus();
              return;
           }
         else if(!rdorefpphnot1.isChecked() & !rdorefpphnot2.isChecked() & txtrefpph.getText().toString().length()==0 & secrefpph.isShown())
           {
             Connection.MessageBox(LD_DataExt_old.this, "Required field: Estimated blood loss in ml.");
             txtrefpph.requestFocus(); 
             return;	
           }
         else if(!rdorefpphnot1.isChecked() & !rdorefpphnot2.isChecked() & (Integer.valueOf(txtrefpph.getText().toString().length()==0 ? "1" : txtrefpph.getText().toString()) < 1 || Integer.valueOf(txtrefpph.getText().toString().length()==0 ? "999" : txtrefpph.getText().toString()) > 999))
           {
             Connection.MessageBox(LD_DataExt_old.this, "Value should be between 1 and 999(Estimated blood loss in ml).");
             txtrefpph.requestFocus(); 
             return;	
           }
         
         /*else if(!rdorefpphnot1.isChecked() & !rdorefpphnot2.isChecked() & secrefpphnot.isShown())
           {
              Connection.MessageBox(LD_DataExt_old.this, "Select anyone options from ().");
              rdorefpphnot1.requestFocus();
              return;
           }*/
         
         else if(!rdorefretainplac1.isChecked() & !rdorefretainplac2.isChecked() & !rdorefretainplac3.isChecked() & !rdorefretainplac4.isChecked() & !rdorefretainplac5.isChecked() & secrefretainplac.isShown())
           {
              Connection.MessageBox(LD_DataExt_old.this, "Select anyone options from (Mother experienced a retained placenta).");
              rdorefretainplac1.requestFocus();
              return;
           }
         
         else if(!rdorefbcond1.isChecked() & !rdorefbcond2.isChecked() & !rdorefbcond3.isChecked() & !rdorefbcond4.isChecked() & secrefbcond.isShown())
           {
              Connection.MessageBox(LD_DataExt_old.this, "Select anyone options from (Condition of baby at discharge?).");
              rdorefbcond1.requestFocus();
              return;
           }
         DV = Global.DateValidate(dtprefdodld.getText().toString());
         if(DV.length()!=0 & secrefdodld.isShown())
           {
             Connection.MessageBox(LD_DataExt_old.this, DV);
             dtprefdodld.requestFocus(); 
             return;	
           }
         else if(txtreftodld.getText().length()==0 & secreftodld.isShown())
           {
             Connection.MessageBox(LD_DataExt_old.this, "Required field: Time of discharge from labour ward.");
             txtreftodld.requestFocus(); 
             return;	
           }
         
         else if(!rdorefdisoutld1.isChecked() & !rdorefdisoutld2.isChecked() & !rdorefdisoutld3.isChecked() & !rdorefdisoutld4.isChecked() & !rdorefdisoutld5.isChecked() & secrefdisoutld.isShown())
           {
              Connection.MessageBox(LD_DataExt_old.this, "Select anyone options from (Outcome at discharge (baby) ).");
              rdorefdisoutld1.requestFocus();
              return;
           }
         else if(txtrefTransPlace.getText().toString().length()==0 & secrefTransPlace.isShown())
           {
             Connection.MessageBox(LD_DataExt_old.this, "Required field: Transferred where.");
             txtrefTransPlace.requestFocus(); 
             return;	
           }
         else if(spnrefmatcond.getSelectedItemPosition()==0  & secrefmatcond.isShown())
           {
             Connection.MessageBox(LD_DataExt_old.this, "Required field: Outcome at discharge (mother).");
             spnrefmatcond.requestFocus(); 
             return;	
           }
         else if(txtrefTransPlaceM.getText().toString().length()==0 & secrefTransPlaceM.isShown())
           {
             Connection.MessageBox(LD_DataExt_old.this, "Required field: Transferred alive where.");
             txtrefTransPlaceM.requestFocus(); 
             return;	
           }
 
         String SQL = "";
         RadioButton rb;

         LD_DataExt_DataModel_old objSave = new LD_DataExt_DataModel_old();
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

         String[] d_rdogrpreftypebirth = new String[] {"1","2","6","8","9"};
         objSave.setreftypebirth("");
         for (int i = 0; i < rdogrpreftypebirth.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpreftypebirth.getChildAt(i);
             if (rb.isChecked()) objSave.setreftypebirth(d_rdogrpreftypebirth[i]);
         }

         objSave.setrefdelivdate(dtprefdelivdate.getText().toString().length() > 0 ? Global.DateConvertYMD(dtprefdelivdate.getText().toString()) : dtprefdelivdate.getText().toString());
         objSave.setrefdelivtime(txtrefdelivtime.getText().toString());
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

         String[] d_rdogrprefbStatus = new String[] {"1","2","8","9"};
         objSave.setrefbStatus("");
         for (int i = 0; i < rdogrprefbStatus.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefbStatus.getChildAt(i);
             if (rb.isChecked()) objSave.setrefbStatus(d_rdogrprefbStatus[i]);
         }

         String[] d_rdogrpRefsbtype = new String[] {"1","2","8","9"};
         objSave.setRefsbtype("");
         for (int i = 0; i < rdogrpRefsbtype.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpRefsbtype.getChildAt(i);
             if (rb.isChecked()) objSave.setRefsbtype(d_rdogrpRefsbtype[i]);
         }

         String[] d_rdogrprefbsex = new String[] {"1","2","3","8","9"};
         objSave.setrefbsex("");
         for (int i = 0; i < rdogrprefbsex.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefbsex.getChildAt(i);
             if (rb.isChecked()) objSave.setrefbsex(d_rdogrprefbsex[i]);
         }

         objSave.setrefbwgt(txtrefbwgt.getText().toString());
         String[] d_rdogrprefbwgtnot = new String[] {"1","2"};
         objSave.setrefbwgtnot("");
         for (int i = 0; i < rdogrprefbwgtnot.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefbwgtnot.getChildAt(i);
             if (rb.isChecked()) objSave.setrefbwgtnot(d_rdogrprefbwgtnot[i]);
         }

         String[] d_rdogrprefbstim = new String[] {"1","2","8","9"};
         objSave.setrefbstim("");
         for (int i = 0; i < rdogrprefbstim.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefbstim.getChildAt(i);
             if (rb.isChecked()) objSave.setrefbstim(d_rdogrprefbstim[i]);
         }

         String[] d_rdogrprefbplast = new String[] {"1","2","8","9"};
         objSave.setrefbplast("");
         for (int i = 0; i < rdogrprefbplast.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefbplast.getChildAt(i);
             if (rb.isChecked()) objSave.setrefbplast(d_rdogrprefbplast[i]);
         }

         String[] d_rdogrprefappcord = new String[] {"1","2","8","9"};
         objSave.setrefappcord("");
         for (int i = 0; i < rdogrprefappcord.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefappcord.getChildAt(i);
             if (rb.isChecked()) objSave.setrefappcord(d_rdogrprefappcord[i]);
         }

         String[] d_rdogrprefbbfd = new String[] {"1","2","8","9","5"};
         objSave.setrefbbfd("");
         for (int i = 0; i < rdogrprefbbfd.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefbbfd.getChildAt(i);
             if (rb.isChecked()) objSave.setrefbbfd(d_rdogrprefbbfd[i]);
         }

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

         String[] d_rdogrprefbcond = new String[] {"1","3","8","9"};
         objSave.setrefbcond("");
         for (int i = 0; i < rdogrprefbcond.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefbcond.getChildAt(i);
             if (rb.isChecked()) objSave.setrefbcond(d_rdogrprefbcond[i]);
         }

         objSave.setrefdodld(dtprefdodld.getText().toString().length() > 0 ? Global.DateConvertYMD(dtprefdodld.getText().toString()) : dtprefdodld.getText().toString());
         objSave.setreftodld(txtreftodld.getText().toString());
         String[] d_rdogrprefdisoutld = new String[] {"1","2","3","8","9"};
         objSave.setrefdisoutld("");
         for (int i = 0; i < rdogrprefdisoutld.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefdisoutld.getChildAt(i);
             if (rb.isChecked()) objSave.setrefdisoutld(d_rdogrprefdisoutld[i]);
         }

         objSave.setrefTransPlace(txtrefTransPlace.getText().toString());
         objSave.setrefmatcond((spnrefmatcond.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnrefmatcond.getSelectedItem().toString(), "-")));
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
             Intent returnIntent = new Intent();
             returnIntent.putExtra("res", "");
             setResult(Activity.RESULT_OK, returnIntent);

             Connection.MessageBox(LD_DataExt_old.this, "Saved Successfully");
         }
         else{
             Connection.MessageBox(LD_DataExt_old.this, status);
             return;
         }
     }
     catch(Exception  e)
     {
         Connection.MessageBox(LD_DataExt_old.this, e.getMessage());
         return;
     }
 }

 private void DataSearch(String CountryCode, String FaciCode, String DataID)
     {
       try
        {
     
           RadioButton rb;
           LD_DataExt_DataModel_old d = new LD_DataExt_DataModel_old();
           String SQL = "Select * from "+ TableName +"  Where CountryCode='"+ CountryCode +"' and FaciCode='"+ FaciCode +"' and DataID='"+ DataID +"'";
           List<LD_DataExt_DataModel_old> data = d.SelectAll(this, SQL);
           for(LD_DataExt_DataModel_old item : data){
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
             String[] d_rdogrpreftypebirth = new String[] {"1","2","6","8","9"};
             for (int i = 0; i < d_rdogrpreftypebirth.length; i++)
             {
                 if (item.getreftypebirth().equals(String.valueOf(d_rdogrpreftypebirth[i])))
                 {
                     rb = (RadioButton)rdogrpreftypebirth.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             dtprefdelivdate.setText(item.getrefdelivdate().toString().length()==0 ? "" : Global.DateConvertDMY(item.getrefdelivdate()));
             txtrefdelivtime.setText(item.getrefdelivtime());
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
             String[] d_rdogrprefbStatus = new String[] {"1","2","8","9"};
             for (int i = 0; i < d_rdogrprefbStatus.length; i++)
             {
                 if (item.getrefbStatus().equals(String.valueOf(d_rdogrprefbStatus[i])))
                 {
                     rb = (RadioButton)rdogrprefbStatus.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpRefsbtype = new String[] {"1","2","8","9"};
             for (int i = 0; i < d_rdogrpRefsbtype.length; i++)
             {
                 if (item.getRefsbtype().equals(String.valueOf(d_rdogrpRefsbtype[i])))
                 {
                     rb = (RadioButton)rdogrpRefsbtype.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrprefbsex = new String[] {"1","2","3","8","9"};
             for (int i = 0; i < d_rdogrprefbsex.length; i++)
             {
                 if (item.getrefbsex().equals(String.valueOf(d_rdogrprefbsex[i])))
                 {
                     rb = (RadioButton)rdogrprefbsex.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtrefbwgt.setText(item.getrefbwgt());
             String[] d_rdogrprefbwgtnot = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrprefbwgtnot.length; i++)
             {
                 if (item.getrefbwgtnot().equals(String.valueOf(d_rdogrprefbwgtnot[i])))
                 {
                     rb = (RadioButton)rdogrprefbwgtnot.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrprefbstim = new String[] {"1","2","8","9"};
             for (int i = 0; i < d_rdogrprefbstim.length; i++)
             {
                 if (item.getrefbstim().equals(String.valueOf(d_rdogrprefbstim[i])))
                 {
                     rb = (RadioButton)rdogrprefbstim.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrprefbplast = new String[] {"1","2","8","9"};
             for (int i = 0; i < d_rdogrprefbplast.length; i++)
             {
                 if (item.getrefbplast().equals(String.valueOf(d_rdogrprefbplast[i])))
                 {
                     rb = (RadioButton)rdogrprefbplast.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrprefappcord = new String[] {"1","2","8","9"};
             for (int i = 0; i < d_rdogrprefappcord.length; i++)
             {
                 if (item.getrefappcord().equals(String.valueOf(d_rdogrprefappcord[i])))
                 {
                     rb = (RadioButton)rdogrprefappcord.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrprefbbfd = new String[] {"1","2","8","9","5"};
             for (int i = 0; i < d_rdogrprefbbfd.length; i++)
             {
                 if (item.getrefbbfd().equals(String.valueOf(d_rdogrprefbbfd[i])))
                 {
                     rb = (RadioButton)rdogrprefbbfd.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
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
             String[] d_rdogrprefbcond = new String[] {"1","3","8","9"};
             for (int i = 0; i < d_rdogrprefbcond.length; i++)
             {
                 if (item.getrefbcond().equals(String.valueOf(d_rdogrprefbcond[i])))
                 {
                     rb = (RadioButton)rdogrprefbcond.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             dtprefdodld.setText(item.getrefdodld().toString().length()==0 ? "" : Global.DateConvertDMY(item.getrefdodld()));
             txtreftodld.setText(item.getreftodld());
             String[] d_rdogrprefdisoutld = new String[] {"1","2","3","8","9"};
             for (int i = 0; i < d_rdogrprefdisoutld.length; i++)
             {
                 if (item.getrefdisoutld().equals(String.valueOf(d_rdogrprefdisoutld[i])))
                 {
                     rb = (RadioButton)rdogrprefdisoutld.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtrefTransPlace.setText(item.getrefTransPlace());
             spnrefmatcond.setSelection(Global.SpinnerItemPositionAnyLength(spnrefmatcond, item.getrefmatcond()));
             txtrefTransPlaceM.setText(item.getrefTransPlaceM());
           }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(LD_DataExt_old.this, e.getMessage());
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
             else if (VariableID.equals("btnrefdelivdate"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtprefdelivdate);
              }
             else if (VariableID.equals("btnrefgacalc"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtprefgacalc);
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


              tpTime = (EditText)findViewById(R.id.txtrefdelivtime);
             if (VariableID.equals("btnrefdelivtime"))
              {
                  tpTime = (EditText)findViewById(R.id.txtrefdelivtime);
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