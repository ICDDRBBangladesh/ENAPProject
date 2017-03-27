
 package org.icddrb.enap;


 //Android Manifest Code
 //<activity android:name=".RecallSurvS3" android:label="RecallSurvS3" />
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

 public class RecallSurvS3 extends Activity {
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
         LinearLayout secStudyID;
         View lineStudyID;
         TextView VlblStudyID;
         EditText txtStudyID;
         LinearLayout seclblsec1;
         View linelblsec1;
         LinearLayout secbneoward;
         View linebneoward;
         TextView Vlblbneoward;
         RadioGroup rdogrpbneoward;
         
         RadioButton rdobneoward1;
         RadioButton rdobneoward2;
         RadioButton rdobneoward3;
         LinearLayout secbprobknow;
         View linebprobknow;
         TextView Vlblbprobknow;
         RadioGroup rdogrpbprobknow;
         
         RadioButton rdobprobknow1;
         RadioButton rdobprobknow2;
         RadioButton rdobprobknow3;
         LinearLayout secbprob;
         View linebprob;
         TextView Vlblbprob;
         Spinner spnbprob;
         LinearLayout secbprobOth;
         View linebprobOth;
         TextView VlblbprobOth;
         EditText txtbprobOth;
         LinearLayout secbinfxn;
         View linebinfxn;
         TextView Vlblbinfxn;
         Spinner spnbinfxn;
         LinearLayout secbinfxnOth;
         View linebinfxnOth;
         TextView VlblbinfxnOth;
         EditText txtbinfxnOth;
         LinearLayout secknowadwgtni;
         View lineknowadwgtni;
         TextView Vlblknowadwgtni;
         Spinner spnknowadwgtni;
         LinearLayout secadwgtni;
         View lineadwgtni;
         TextView Vlbladwgtni;
         EditText txtadwgtni;
         LinearLayout secadwgtniDK;
         View lineadwgtniDK;
         TextView VlbladwgtniDK;
         CheckBox chkadwgtniDK;
         LinearLayout secbseiz;
         View linebseiz;
         TextView Vlblbseiz;
         Spinner spnbseiz;
         LinearLayout secbseizdays;
         View linebseizdays;
         TextView Vlblbseizdays;
         EditText txtbseizdays;
         LinearLayout secbseizdaysDK;
         View linebseizdaysDK;
         TextView VlblbseizdaysDK;
         CheckBox chkbseizdaysDK;
         LinearLayout secbantiknow;
         View linebantiknow;
         TextView Vlblbantiknow;
         RadioGroup rdogrpbantiknow;
         
         RadioButton rdobantiknow1;
         RadioButton rdobantiknow2;
         RadioButton rdobantiknow3;
         LinearLayout seclblAntibiotics;
         View linelblAntibiotics;
         LinearLayout secbantiname1;
         View linebantiname1;
         TextView Vlblbantiname1;
         EditText txtbantiname1;
         LinearLayout secbantiname2;
         View linebantiname2;
         TextView Vlblbantiname2;
         EditText txtbantiname2;
         LinearLayout secbantiname3;
         View linebantiname3;
         TextView Vlblbantiname3;
         EditText txtbantiname3;
         LinearLayout secbantinameDK;
         View linebantinameDK;
         TextView VlblbantinameDK;
         CheckBox chkbantinameDK;
         LinearLayout secbantitime;
         View linebantitime;
         TextView Vlblbantitime;
         RadioGroup rdogrpbantitime;
         
         RadioButton rdobantitime1;
         RadioButton rdobantitime2;
         RadioButton rdobantitime3;
         LinearLayout secbantitimeDur;
         View linebantitimeDur;
         TextView VlblbantitimeDur;
         EditText txtbantitimeDur;
         LinearLayout secbantihome;
         View linebantihome;
         TextView Vlblbantihome;
         Spinner spnbantihome;
         LinearLayout secboxy;
         View lineboxy;
         TextView Vlblboxy;
         Spinner spnboxy;
         LinearLayout secbdiagtestknow;
         View linebdiagtestknow;
         TextView Vlblbdiagtestknow;
         RadioGroup rdogrpbdiagtestknow;
         
         RadioButton rdobdiagtestknow1;
         RadioButton rdobdiagtestknow2;
         RadioButton rdobdiagtestknow3;
         LinearLayout seclbl08a;
         View linelbl08a;
         LinearLayout secbdiagtestA;
         View linebdiagtestA;
         TextView VlblbdiagtestA;
         CheckBox chkbdiagtestA;
         LinearLayout secbdiagtestB;
         View linebdiagtestB;
         TextView VlblbdiagtestB;
         CheckBox chkbdiagtestB;
         LinearLayout secbdiagtestC;
         View linebdiagtestC;
         TextView VlblbdiagtestC;
         CheckBox chkbdiagtestC;
         LinearLayout secbdiagtestD;
         View linebdiagtestD;
         TextView VlblbdiagtestD;
         CheckBox chkbdiagtestD;
         LinearLayout secbdiagtestDOth;
         View linebdiagtestDOth;
         TextView VlblbdiagtestDOth;
         EditText txtbdiagtestDOth;
         LinearLayout secbdiagtestE;
         View linebdiagtestE;
         TextView VlblbdiagtestE;
         CheckBox chkbdiagtestE;
         LinearLayout seclbl09;
         View linelbl09;
         LinearLayout secbfsupA;
         View linebfsupA;
         TextView VlblbfsupA;
         CheckBox chkbfsupA;
         LinearLayout secbfsupB;
         View linebfsupB;
         TextView VlblbfsupB;
         CheckBox chkbfsupB;
         LinearLayout secbfsupC;
         View linebfsupC;
         TextView VlblbfsupC;
         CheckBox chkbfsupC;
         LinearLayout secbfsupD;
         View linebfsupD;
         TextView VlblbfsupD;
         CheckBox chkbfsupD;
         LinearLayout secbfsupE;
         View linebfsupE;
         TextView VlblbfsupE;
         CheckBox chkbfsupE;
         LinearLayout secbphoto;
         View linebphoto;
         TextView Vlblbphoto;
         RadioGroup rdogrpbphoto;
         
         RadioButton rdobphoto1;
         RadioButton rdobphoto2;
         RadioButton rdobphoto3;
         LinearLayout secblos;
         View lineblos;
         TextView Vlblblos;
         EditText txtblos;
         LinearLayout secblosDK;
         View lineblosDK;
         TextView VlblblosDK;
         CheckBox chkblosDK;
         LinearLayout secbref;
         View linebref;
         TextView Vlblbref;
         Spinner spnbref;
         LinearLayout secknowdiswgtni;
         View lineknowdiswgtni;
         TextView Vlblknowdiswgtni;
         Spinner spnknowdiswgtni;
         LinearLayout secdiswgtni;
         View linediswgtni;
         TextView Vlbldiswgtni;
         EditText txtdiswgtni;
         LinearLayout secdiswgtniDK;
         View linediswgtniDK;
         TextView VlbldiswgtniDK;
         CheckBox chkdiswgtniDK;

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
         setContentView(R.layout.recallsurvs3);
         C = new Connection(this);
         g = Global.getInstance();

         STARTTIME = g.CurrentTime24();
         DEVICEID  = sp.getValue(this, "deviceid");
         ENTRYUSER = sp.getValue(this, "userid");

         IDbundle = getIntent().getExtras();
         COUNTRYCODE = IDbundle.getString("CountryCode");
         FACICODE = IDbundle.getString("FaciCode");
         DATAID = IDbundle.getString("DataID");

         TableName = "RecallSurvS3";

         //turnGPSOn();

         //GPS Location
         //FindLocation();
         // Double.toString(currentLatitude);
         // Double.toString(currentLongitude);
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(RecallSurvS3.this);
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
         secFaciCode=(LinearLayout)findViewById(R.id.secFaciCode);
         lineFaciCode=(View)findViewById(R.id.lineFaciCode);
         VlblFaciCode=(TextView) findViewById(R.id.VlblFaciCode);
         txtFaciCode=(EditText) findViewById(R.id.txtFaciCode);
         secDataID=(LinearLayout)findViewById(R.id.secDataID);
         lineDataID=(View)findViewById(R.id.lineDataID);
         VlblDataID=(TextView) findViewById(R.id.VlblDataID);
         txtDataID=(EditText) findViewById(R.id.txtDataID);
         secStudyID=(LinearLayout)findViewById(R.id.secStudyID);
         lineStudyID=(View)findViewById(R.id.lineStudyID);
         VlblStudyID=(TextView) findViewById(R.id.VlblStudyID);
         txtStudyID=(EditText) findViewById(R.id.txtStudyID);
         seclblsec1=(LinearLayout)findViewById(R.id.seclblsec1);
         linelblsec1=(View)findViewById(R.id.linelblsec1);
         secbneoward=(LinearLayout)findViewById(R.id.secbneoward);
         linebneoward=(View)findViewById(R.id.linebneoward);
         Vlblbneoward = (TextView) findViewById(R.id.Vlblbneoward);
         rdogrpbneoward = (RadioGroup) findViewById(R.id.rdogrpbneoward);
         
         rdobneoward1 = (RadioButton) findViewById(R.id.rdobneoward1);
         rdobneoward2 = (RadioButton) findViewById(R.id.rdobneoward2);
         rdobneoward3 = (RadioButton) findViewById(R.id.rdobneoward3);
         rdogrpbneoward.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpbneoward = new String[] {"01","02","98"};
             for (int i = 0; i < rdogrpbneoward.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpbneoward.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpbneoward[i];
             }

             if(rbData.equalsIgnoreCase("02"))
             {
                    secbprobknow.setVisibility(View.GONE);
                    linebprobknow.setVisibility(View.GONE);
                    rdogrpbprobknow.clearCheck();
                    secbprob.setVisibility(View.GONE);
                    linebprob.setVisibility(View.GONE);
                    spnbprob.setSelection(0);
                    secbprobOth.setVisibility(View.GONE);
                    linebprobOth.setVisibility(View.GONE);
                    txtbprobOth.setText("");
                    secbinfxn.setVisibility(View.GONE);
                    linebinfxn.setVisibility(View.GONE);
                    spnbinfxn.setSelection(0);
                    secbinfxnOth.setVisibility(View.GONE);
                    linebinfxnOth.setVisibility(View.GONE);
                    txtbinfxnOth.setText("");
                    secknowadwgtni.setVisibility(View.GONE);
                    lineknowadwgtni.setVisibility(View.GONE);
                    spnknowadwgtni.setSelection(0);
                    secadwgtni.setVisibility(View.GONE);
                    lineadwgtni.setVisibility(View.GONE);
                    txtadwgtni.setText("");
                    secadwgtniDK.setVisibility(View.GONE);
                    lineadwgtniDK.setVisibility(View.GONE);
                    chkadwgtniDK.setChecked(false);
                    secbseiz.setVisibility(View.GONE);
                    linebseiz.setVisibility(View.GONE);
                    spnbseiz.setSelection(0);
                    secbseizdays.setVisibility(View.GONE);
                    linebseizdays.setVisibility(View.GONE);
                    txtbseizdays.setText("");
                    secbseizdaysDK.setVisibility(View.GONE);
                    linebseizdaysDK.setVisibility(View.GONE);
                    chkbseizdaysDK.setChecked(false);
                    secbantiknow.setVisibility(View.GONE);
                    linebantiknow.setVisibility(View.GONE);
                    rdogrpbantiknow.clearCheck();
                    seclblAntibiotics.setVisibility(View.GONE);
                    linelblAntibiotics.setVisibility(View.GONE);
                    secbantiname1.setVisibility(View.GONE);
                    linebantiname1.setVisibility(View.GONE);
                    txtbantiname1.setText("");
                    secbantiname2.setVisibility(View.GONE);
                    linebantiname2.setVisibility(View.GONE);
                    txtbantiname2.setText("");
                    secbantiname3.setVisibility(View.GONE);
                    linebantiname3.setVisibility(View.GONE);
                    txtbantiname3.setText("");
                    secbantinameDK.setVisibility(View.GONE);
                    linebantinameDK.setVisibility(View.GONE);
                    chkbantinameDK.setChecked(false);
                    secbantitime.setVisibility(View.GONE);
                    linebantitime.setVisibility(View.GONE);
                    rdogrpbantitime.clearCheck();
                    secbantitimeDur.setVisibility(View.GONE);
                    linebantitimeDur.setVisibility(View.GONE);
                    txtbantitimeDur.setText("");
                    secbantihome.setVisibility(View.GONE);
                    linebantihome.setVisibility(View.GONE);
                    spnbantihome.setSelection(0);
                    secboxy.setVisibility(View.GONE);
                    lineboxy.setVisibility(View.GONE);
                    spnboxy.setSelection(0);
                    secbdiagtestknow.setVisibility(View.GONE);
                    linebdiagtestknow.setVisibility(View.GONE);
                    rdogrpbdiagtestknow.clearCheck();
                    seclbl08a.setVisibility(View.GONE);
                    linelbl08a.setVisibility(View.GONE);
                    secbdiagtestA.setVisibility(View.GONE);
                    linebdiagtestA.setVisibility(View.GONE);
                    chkbdiagtestA.setChecked(false);
                    secbdiagtestB.setVisibility(View.GONE);
                    linebdiagtestB.setVisibility(View.GONE);
                    chkbdiagtestB.setChecked(false);
                    secbdiagtestC.setVisibility(View.GONE);
                    linebdiagtestC.setVisibility(View.GONE);
                    chkbdiagtestC.setChecked(false);
                    secbdiagtestD.setVisibility(View.GONE);
                    linebdiagtestD.setVisibility(View.GONE);
                    chkbdiagtestD.setChecked(false);
                    secbdiagtestDOth.setVisibility(View.GONE);
                    linebdiagtestDOth.setVisibility(View.GONE);
                    txtbdiagtestDOth.setText("");
                    secbdiagtestE.setVisibility(View.GONE);
                    linebdiagtestE.setVisibility(View.GONE);
                    chkbdiagtestE.setChecked(false);
                    seclbl09.setVisibility(View.GONE);
                    linelbl09.setVisibility(View.GONE);
                    secbfsupA.setVisibility(View.GONE);
                    linebfsupA.setVisibility(View.GONE);
                    chkbfsupA.setChecked(false);
                    secbfsupB.setVisibility(View.GONE);
                    linebfsupB.setVisibility(View.GONE);
                    chkbfsupB.setChecked(false);
                    secbfsupC.setVisibility(View.GONE);
                    linebfsupC.setVisibility(View.GONE);
                    chkbfsupC.setChecked(false);
                    secbfsupD.setVisibility(View.GONE);
                    linebfsupD.setVisibility(View.GONE);
                    chkbfsupD.setChecked(false);
                    secbfsupE.setVisibility(View.GONE);
                    linebfsupE.setVisibility(View.GONE);
                    chkbfsupE.setChecked(false);
                    secbphoto.setVisibility(View.GONE);
                    linebphoto.setVisibility(View.GONE);
                    rdogrpbphoto.clearCheck();
                    secblos.setVisibility(View.GONE);
                    lineblos.setVisibility(View.GONE);
                    txtblos.setText("");
                    secblosDK.setVisibility(View.GONE);
                    lineblosDK.setVisibility(View.GONE);
                    chkblosDK.setChecked(false);
                    secbref.setVisibility(View.GONE);
                    linebref.setVisibility(View.GONE);
                    spnbref.setSelection(0);
                    secknowdiswgtni.setVisibility(View.GONE);
                    lineknowdiswgtni.setVisibility(View.GONE);
                    spnknowdiswgtni.setSelection(0);
                    secdiswgtni.setVisibility(View.GONE);
                    linediswgtni.setVisibility(View.GONE);
                    txtdiswgtni.setText("");
                    secdiswgtniDK.setVisibility(View.GONE);
                    linediswgtniDK.setVisibility(View.GONE);
                    chkdiswgtniDK.setChecked(false);
             }
             else if(rbData.equalsIgnoreCase("98"))
             {
                    secbprobknow.setVisibility(View.GONE);
                    linebprobknow.setVisibility(View.GONE);
                    rdogrpbprobknow.clearCheck();
                    secbprob.setVisibility(View.GONE);
                    linebprob.setVisibility(View.GONE);
                    spnbprob.setSelection(0);
                    secbprobOth.setVisibility(View.GONE);
                    linebprobOth.setVisibility(View.GONE);
                    txtbprobOth.setText("");
                    secbinfxn.setVisibility(View.GONE);
                    linebinfxn.setVisibility(View.GONE);
                    spnbinfxn.setSelection(0);
                    secbinfxnOth.setVisibility(View.GONE);
                    linebinfxnOth.setVisibility(View.GONE);
                    txtbinfxnOth.setText("");
                    secknowadwgtni.setVisibility(View.GONE);
                    lineknowadwgtni.setVisibility(View.GONE);
                    spnknowadwgtni.setSelection(0);
                    secadwgtni.setVisibility(View.GONE);
                    lineadwgtni.setVisibility(View.GONE);
                    txtadwgtni.setText("");
                    secadwgtniDK.setVisibility(View.GONE);
                    lineadwgtniDK.setVisibility(View.GONE);
                    chkadwgtniDK.setChecked(false);
                    secbseiz.setVisibility(View.GONE);
                    linebseiz.setVisibility(View.GONE);
                    spnbseiz.setSelection(0);
                    secbseizdays.setVisibility(View.GONE);
                    linebseizdays.setVisibility(View.GONE);
                    txtbseizdays.setText("");
                    secbseizdaysDK.setVisibility(View.GONE);
                    linebseizdaysDK.setVisibility(View.GONE);
                    chkbseizdaysDK.setChecked(false);
                    secbantiknow.setVisibility(View.GONE);
                    linebantiknow.setVisibility(View.GONE);
                    rdogrpbantiknow.clearCheck();
                    seclblAntibiotics.setVisibility(View.GONE);
                    linelblAntibiotics.setVisibility(View.GONE);
                    secbantiname1.setVisibility(View.GONE);
                    linebantiname1.setVisibility(View.GONE);
                    txtbantiname1.setText("");
                    secbantiname2.setVisibility(View.GONE);
                    linebantiname2.setVisibility(View.GONE);
                    txtbantiname2.setText("");
                    secbantiname3.setVisibility(View.GONE);
                    linebantiname3.setVisibility(View.GONE);
                    txtbantiname3.setText("");
                    secbantinameDK.setVisibility(View.GONE);
                    linebantinameDK.setVisibility(View.GONE);
                    chkbantinameDK.setChecked(false);
                    secbantitime.setVisibility(View.GONE);
                    linebantitime.setVisibility(View.GONE);
                    rdogrpbantitime.clearCheck();
                    secbantitimeDur.setVisibility(View.GONE);
                    linebantitimeDur.setVisibility(View.GONE);
                    txtbantitimeDur.setText("");
                    secbantihome.setVisibility(View.GONE);
                    linebantihome.setVisibility(View.GONE);
                    spnbantihome.setSelection(0);
                    secboxy.setVisibility(View.GONE);
                    lineboxy.setVisibility(View.GONE);
                    spnboxy.setSelection(0);
                    secbdiagtestknow.setVisibility(View.GONE);
                    linebdiagtestknow.setVisibility(View.GONE);
                    rdogrpbdiagtestknow.clearCheck();
                    seclbl08a.setVisibility(View.GONE);
                    linelbl08a.setVisibility(View.GONE);
                    secbdiagtestA.setVisibility(View.GONE);
                    linebdiagtestA.setVisibility(View.GONE);
                    chkbdiagtestA.setChecked(false);
                    secbdiagtestB.setVisibility(View.GONE);
                    linebdiagtestB.setVisibility(View.GONE);
                    chkbdiagtestB.setChecked(false);
                    secbdiagtestC.setVisibility(View.GONE);
                    linebdiagtestC.setVisibility(View.GONE);
                    chkbdiagtestC.setChecked(false);
                    secbdiagtestD.setVisibility(View.GONE);
                    linebdiagtestD.setVisibility(View.GONE);
                    chkbdiagtestD.setChecked(false);
                    secbdiagtestDOth.setVisibility(View.GONE);
                    linebdiagtestDOth.setVisibility(View.GONE);
                    txtbdiagtestDOth.setText("");
                    secbdiagtestE.setVisibility(View.GONE);
                    linebdiagtestE.setVisibility(View.GONE);
                    chkbdiagtestE.setChecked(false);
                    seclbl09.setVisibility(View.GONE);
                    linelbl09.setVisibility(View.GONE);
                    secbfsupA.setVisibility(View.GONE);
                    linebfsupA.setVisibility(View.GONE);
                    chkbfsupA.setChecked(false);
                    secbfsupB.setVisibility(View.GONE);
                    linebfsupB.setVisibility(View.GONE);
                    chkbfsupB.setChecked(false);
                    secbfsupC.setVisibility(View.GONE);
                    linebfsupC.setVisibility(View.GONE);
                    chkbfsupC.setChecked(false);
                    secbfsupD.setVisibility(View.GONE);
                    linebfsupD.setVisibility(View.GONE);
                    chkbfsupD.setChecked(false);
                    secbfsupE.setVisibility(View.GONE);
                    linebfsupE.setVisibility(View.GONE);
                    chkbfsupE.setChecked(false);
                    secbphoto.setVisibility(View.GONE);
                    linebphoto.setVisibility(View.GONE);
                    rdogrpbphoto.clearCheck();
                    secblos.setVisibility(View.GONE);
                    lineblos.setVisibility(View.GONE);
                    txtblos.setText("");
                    secblosDK.setVisibility(View.GONE);
                    lineblosDK.setVisibility(View.GONE);
                    chkblosDK.setChecked(false);
                    secbref.setVisibility(View.GONE);
                    linebref.setVisibility(View.GONE);
                    spnbref.setSelection(0);
                    secknowdiswgtni.setVisibility(View.GONE);
                    lineknowdiswgtni.setVisibility(View.GONE);
                    spnknowdiswgtni.setSelection(0);
                    secdiswgtni.setVisibility(View.GONE);
                    linediswgtni.setVisibility(View.GONE);
                    txtdiswgtni.setText("");
                    secdiswgtniDK.setVisibility(View.GONE);
                    linediswgtniDK.setVisibility(View.GONE);
                    chkdiswgtniDK.setChecked(false);
             }
             else
             {
                    secbprobknow.setVisibility(View.VISIBLE);
                    linebprobknow.setVisibility(View.VISIBLE);
                    secbprob.setVisibility(View.VISIBLE);
                    linebprob.setVisibility(View.VISIBLE);
                    secbprobOth.setVisibility(View.VISIBLE);
                    linebprobOth.setVisibility(View.VISIBLE);
                    secbinfxn.setVisibility(View.VISIBLE);
                    linebinfxn.setVisibility(View.VISIBLE);
                    secbinfxnOth.setVisibility(View.VISIBLE);
                    linebinfxnOth.setVisibility(View.VISIBLE);
                    secknowadwgtni.setVisibility(View.VISIBLE);
                    lineknowadwgtni.setVisibility(View.VISIBLE);
                    secadwgtni.setVisibility(View.VISIBLE);
                    lineadwgtni.setVisibility(View.VISIBLE);
                    secadwgtniDK.setVisibility(View.VISIBLE);
                    lineadwgtniDK.setVisibility(View.VISIBLE);
                    secbseiz.setVisibility(View.VISIBLE);
                    linebseiz.setVisibility(View.VISIBLE);
                    secbseizdays.setVisibility(View.VISIBLE);
                    linebseizdays.setVisibility(View.VISIBLE);
                    secbseizdaysDK.setVisibility(View.VISIBLE);
                    linebseizdaysDK.setVisibility(View.VISIBLE);
                    secbantiknow.setVisibility(View.VISIBLE);
                    linebantiknow.setVisibility(View.VISIBLE);
                    seclblAntibiotics.setVisibility(View.VISIBLE);
                    linelblAntibiotics.setVisibility(View.VISIBLE);
                    secbantiname1.setVisibility(View.VISIBLE);
                    linebantiname1.setVisibility(View.VISIBLE);
                    secbantiname2.setVisibility(View.VISIBLE);
                    linebantiname2.setVisibility(View.VISIBLE);
                    secbantiname3.setVisibility(View.VISIBLE);
                    linebantiname3.setVisibility(View.VISIBLE);
                    secbantinameDK.setVisibility(View.VISIBLE);
                    linebantinameDK.setVisibility(View.VISIBLE);
                    secbantitime.setVisibility(View.VISIBLE);
                    linebantitime.setVisibility(View.VISIBLE);
                    secbantitimeDur.setVisibility(View.VISIBLE);
                    linebantitimeDur.setVisibility(View.VISIBLE);
                    secbantihome.setVisibility(View.VISIBLE);
                    linebantihome.setVisibility(View.VISIBLE);
                    secboxy.setVisibility(View.VISIBLE);
                    lineboxy.setVisibility(View.VISIBLE);
                    secbdiagtestknow.setVisibility(View.VISIBLE);
                    linebdiagtestknow.setVisibility(View.VISIBLE);
                    seclbl08a.setVisibility(View.VISIBLE);
                    linelbl08a.setVisibility(View.VISIBLE);
                    secbdiagtestA.setVisibility(View.VISIBLE);
                    linebdiagtestA.setVisibility(View.VISIBLE);
                    secbdiagtestB.setVisibility(View.VISIBLE);
                    linebdiagtestB.setVisibility(View.VISIBLE);
                    secbdiagtestC.setVisibility(View.VISIBLE);
                    linebdiagtestC.setVisibility(View.VISIBLE);
                    secbdiagtestD.setVisibility(View.VISIBLE);
                    linebdiagtestD.setVisibility(View.VISIBLE);
                    secbdiagtestE.setVisibility(View.VISIBLE);
                    linebdiagtestE.setVisibility(View.VISIBLE);
                    seclbl09.setVisibility(View.VISIBLE);
                    linelbl09.setVisibility(View.VISIBLE);
                    secbfsupA.setVisibility(View.VISIBLE);
                    linebfsupA.setVisibility(View.VISIBLE);
                    secbfsupB.setVisibility(View.VISIBLE);
                    linebfsupB.setVisibility(View.VISIBLE);
                    secbfsupC.setVisibility(View.VISIBLE);
                    linebfsupC.setVisibility(View.VISIBLE);
                    secbfsupD.setVisibility(View.VISIBLE);
                    linebfsupD.setVisibility(View.VISIBLE);
                    secbfsupE.setVisibility(View.VISIBLE);
                    linebfsupE.setVisibility(View.VISIBLE);
                    secbphoto.setVisibility(View.VISIBLE);
                    linebphoto.setVisibility(View.VISIBLE);
                    secblos.setVisibility(View.VISIBLE);
                    lineblos.setVisibility(View.VISIBLE);
                    secblosDK.setVisibility(View.VISIBLE);
                    lineblosDK.setVisibility(View.VISIBLE);
                    secbref.setVisibility(View.VISIBLE);
                    linebref.setVisibility(View.VISIBLE);
                    secknowdiswgtni.setVisibility(View.VISIBLE);
                    lineknowdiswgtni.setVisibility(View.VISIBLE);
                    secdiswgtni.setVisibility(View.VISIBLE);
                    linediswgtni.setVisibility(View.VISIBLE);
                    secdiswgtniDK.setVisibility(View.VISIBLE);
                    linediswgtniDK.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secbprobknow=(LinearLayout)findViewById(R.id.secbprobknow);
         linebprobknow=(View)findViewById(R.id.linebprobknow);
         Vlblbprobknow = (TextView) findViewById(R.id.Vlblbprobknow);
         rdogrpbprobknow = (RadioGroup) findViewById(R.id.rdogrpbprobknow);
         
         rdobprobknow1 = (RadioButton) findViewById(R.id.rdobprobknow1);
         rdobprobknow2 = (RadioButton) findViewById(R.id.rdobprobknow2);
         rdobprobknow3 = (RadioButton) findViewById(R.id.rdobprobknow3);
         rdogrpbprobknow.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpbprobknow = new String[] {"01","02","98"};
             for (int i = 0; i < rdogrpbprobknow.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpbprobknow.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpbprobknow[i];
             }

             if(rbData.equalsIgnoreCase("02"))
             {
                    secbprob.setVisibility(View.GONE);
                    linebprob.setVisibility(View.GONE);
                    spnbprob.setSelection(0);
                    secbprobOth.setVisibility(View.GONE);
                    linebprobOth.setVisibility(View.GONE);
                    txtbprobOth.setText("");
                    secbinfxn.setVisibility(View.GONE);
                    linebinfxn.setVisibility(View.GONE);
                    spnbinfxn.setSelection(0);
                    secbinfxnOth.setVisibility(View.GONE);
                    linebinfxnOth.setVisibility(View.GONE);
                    txtbinfxnOth.setText("");
             }
             else if(rbData.equalsIgnoreCase("98"))
             {
                    secbprob.setVisibility(View.GONE);
                    linebprob.setVisibility(View.GONE);
                    spnbprob.setSelection(0);
                    secbprobOth.setVisibility(View.GONE);
                    linebprobOth.setVisibility(View.GONE);
                    txtbprobOth.setText("");
                    secbinfxn.setVisibility(View.GONE);
                    linebinfxn.setVisibility(View.GONE);
                    spnbinfxn.setSelection(0);
                    secbinfxnOth.setVisibility(View.GONE);
                    linebinfxnOth.setVisibility(View.GONE);
                    txtbinfxnOth.setText("");
             }
             else
             {
                    secbprob.setVisibility(View.VISIBLE);
                    linebprob.setVisibility(View.VISIBLE);
                    secbprobOth.setVisibility(View.VISIBLE);
                    linebprobOth.setVisibility(View.VISIBLE);
                    secbinfxn.setVisibility(View.VISIBLE);
                    linebinfxn.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secbprob=(LinearLayout)findViewById(R.id.secbprob);
         linebprob=(View)findViewById(R.id.linebprob);
         Vlblbprob=(TextView) findViewById(R.id.Vlblbprob);
         spnbprob=(Spinner) findViewById(R.id.spnbprob);
         List<String> listbprob = new ArrayList<String>();
         
         listbprob.add("");
         listbprob.add("01-Infection");
         listbprob.add("02-Other");
         listbprob.add("98-Dont know/dont remember");
         ArrayAdapter<String> adptrbprob= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listbprob);
         spnbprob.setAdapter(adptrbprob);

         spnbprob.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             if (spnbprob.getSelectedItem().toString().length() == 0) return;
             String spnData = Connection.SelectedSpinnerValue(spnbprob.getSelectedItem().toString(),"-");
                 if(spnData.equalsIgnoreCase("01"))
                 {
                    secbprobOth.setVisibility(View.GONE);
                    linebprobOth.setVisibility(View.GONE);
                    txtbprobOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("98"))
                 {
                    secbprobOth.setVisibility(View.GONE);
                    linebprobOth.setVisibility(View.GONE);
                    txtbprobOth.setText("");
                 }
                 else
                 {
                    secbprobOth.setVisibility(View.VISIBLE);
                    linebprobOth.setVisibility(View.VISIBLE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secbprobOth=(LinearLayout)findViewById(R.id.secbprobOth);
         linebprobOth=(View)findViewById(R.id.linebprobOth);
         VlblbprobOth=(TextView) findViewById(R.id.VlblbprobOth);
         txtbprobOth=(EditText) findViewById(R.id.txtbprobOth);
         secbinfxn=(LinearLayout)findViewById(R.id.secbinfxn);
         linebinfxn=(View)findViewById(R.id.linebinfxn);
         Vlblbinfxn=(TextView) findViewById(R.id.Vlblbinfxn);
         spnbinfxn=(Spinner) findViewById(R.id.spnbinfxn);
         List<String> listbinfxn = new ArrayList<String>();
         
         listbinfxn.add("");
         listbinfxn.add("01-Chest infection/pneumonia");
         listbinfxn.add("02-Sepsis or infection of blood");
         listbinfxn.add("03-Meningitis");
         listbinfxn.add("04-Other");
         listbinfxn.add("98-Dont know/dont remember");
         ArrayAdapter<String> adptrbinfxn= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listbinfxn);
         spnbinfxn.setAdapter(adptrbinfxn);

         spnbinfxn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             if (spnbinfxn.getSelectedItem().toString().length() == 0) return;
             String spnData = Connection.SelectedSpinnerValue(spnbinfxn.getSelectedItem().toString(),"-");
                 if(spnData.equalsIgnoreCase("01"))
                 {
                    secbinfxnOth.setVisibility(View.GONE);
                    linebinfxnOth.setVisibility(View.GONE);
                    txtbinfxnOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("02"))
                 {
                    secbinfxnOth.setVisibility(View.GONE);
                    linebinfxnOth.setVisibility(View.GONE);
                    txtbinfxnOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("03"))
                 {
                    secbinfxnOth.setVisibility(View.GONE);
                    linebinfxnOth.setVisibility(View.GONE);
                    txtbinfxnOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("98"))
                 {
                    secbinfxnOth.setVisibility(View.GONE);
                    linebinfxnOth.setVisibility(View.GONE);
                    txtbinfxnOth.setText("");
                 }
                 else
                 {
                    secbinfxnOth.setVisibility(View.VISIBLE);
                    linebinfxnOth.setVisibility(View.VISIBLE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secbinfxnOth=(LinearLayout)findViewById(R.id.secbinfxnOth);
         linebinfxnOth=(View)findViewById(R.id.linebinfxnOth);
         VlblbinfxnOth=(TextView) findViewById(R.id.VlblbinfxnOth);
         txtbinfxnOth=(EditText) findViewById(R.id.txtbinfxnOth);
         secknowadwgtni=(LinearLayout)findViewById(R.id.secknowadwgtni);
         lineknowadwgtni=(View)findViewById(R.id.lineknowadwgtni);
         Vlblknowadwgtni=(TextView) findViewById(R.id.Vlblknowadwgtni);
         spnknowadwgtni=(Spinner) findViewById(R.id.spnknowadwgtni);
         List<String> listknowadwgtni = new ArrayList<String>();
         
         listknowadwgtni.add("");
         listknowadwgtni.add("01-Yes");
         listknowadwgtni.add("02-No");
         listknowadwgtni.add("03-Dont know/dont remember");
         ArrayAdapter<String> adptrknowadwgtni= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listknowadwgtni);
         spnknowadwgtni.setAdapter(adptrknowadwgtni);

         secadwgtni=(LinearLayout)findViewById(R.id.secadwgtni);
         lineadwgtni=(View)findViewById(R.id.lineadwgtni);
         Vlbladwgtni=(TextView) findViewById(R.id.Vlbladwgtni);
         txtadwgtni=(EditText) findViewById(R.id.txtadwgtni);
         secadwgtniDK=(LinearLayout)findViewById(R.id.secadwgtniDK);
         lineadwgtniDK=(View)findViewById(R.id.lineadwgtniDK);
         VlbladwgtniDK=(TextView) findViewById(R.id.VlbladwgtniDK);
         chkadwgtniDK=(CheckBox) findViewById(R.id.chkadwgtniDK);
         secbseiz=(LinearLayout)findViewById(R.id.secbseiz);
         linebseiz=(View)findViewById(R.id.linebseiz);
         Vlblbseiz=(TextView) findViewById(R.id.Vlblbseiz);
         spnbseiz=(Spinner) findViewById(R.id.spnbseiz);
         List<String> listbseiz = new ArrayList<String>();
         
         listbseiz.add("");
         listbseiz.add("01-Yes");
         listbseiz.add("02-No");
         listbseiz.add("98-Dont know/dont remember");
         ArrayAdapter<String> adptrbseiz= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listbseiz);
         spnbseiz.setAdapter(adptrbseiz);

         spnbseiz.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             if (spnbseiz.getSelectedItem().toString().length() == 0) return;
             String spnData = Connection.SelectedSpinnerValue(spnbseiz.getSelectedItem().toString(),"-");
                 if(spnData.equalsIgnoreCase("02"))
                 {
                    secbseizdays.setVisibility(View.GONE);
                    linebseizdays.setVisibility(View.GONE);
                    txtbseizdays.setText("");
                    secbseizdaysDK.setVisibility(View.GONE);
                    linebseizdaysDK.setVisibility(View.GONE);
                    chkbseizdaysDK.setChecked(false);
                 }
                 else if(spnData.equalsIgnoreCase("98"))
                 {
                    secbseizdays.setVisibility(View.GONE);
                    linebseizdays.setVisibility(View.GONE);
                    txtbseizdays.setText("");
                    secbseizdaysDK.setVisibility(View.GONE);
                    linebseizdaysDK.setVisibility(View.GONE);
                    chkbseizdaysDK.setChecked(false);
                 }
                 else
                 {
                    secbseizdays.setVisibility(View.VISIBLE);
                    linebseizdays.setVisibility(View.VISIBLE);
                    secbseizdaysDK.setVisibility(View.VISIBLE);
                    linebseizdaysDK.setVisibility(View.VISIBLE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secbseizdays=(LinearLayout)findViewById(R.id.secbseizdays);
         linebseizdays=(View)findViewById(R.id.linebseizdays);
         Vlblbseizdays=(TextView) findViewById(R.id.Vlblbseizdays);
         txtbseizdays=(EditText) findViewById(R.id.txtbseizdays);
         secbseizdaysDK=(LinearLayout)findViewById(R.id.secbseizdaysDK);
         linebseizdaysDK=(View)findViewById(R.id.linebseizdaysDK);
         VlblbseizdaysDK=(TextView) findViewById(R.id.VlblbseizdaysDK);
         chkbseizdaysDK=(CheckBox) findViewById(R.id.chkbseizdaysDK);
         secbantiknow=(LinearLayout)findViewById(R.id.secbantiknow);
         linebantiknow=(View)findViewById(R.id.linebantiknow);
         Vlblbantiknow = (TextView) findViewById(R.id.Vlblbantiknow);
         rdogrpbantiknow = (RadioGroup) findViewById(R.id.rdogrpbantiknow);
         
         rdobantiknow1 = (RadioButton) findViewById(R.id.rdobantiknow1);
         rdobantiknow2 = (RadioButton) findViewById(R.id.rdobantiknow2);
         rdobantiknow3 = (RadioButton) findViewById(R.id.rdobantiknow3);
         rdogrpbantiknow.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpbantiknow = new String[] {"01","02","98"};
             for (int i = 0; i < rdogrpbantiknow.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpbantiknow.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpbantiknow[i];
             }

             if(rbData.equalsIgnoreCase("02"))
             {
                    seclblAntibiotics.setVisibility(View.GONE);
                    linelblAntibiotics.setVisibility(View.GONE);
                    secbantiname1.setVisibility(View.GONE);
                    linebantiname1.setVisibility(View.GONE);
                    txtbantiname1.setText("");
                    secbantiname2.setVisibility(View.GONE);
                    linebantiname2.setVisibility(View.GONE);
                    txtbantiname2.setText("");
                    secbantiname3.setVisibility(View.GONE);
                    linebantiname3.setVisibility(View.GONE);
                    txtbantiname3.setText("");
                    secbantinameDK.setVisibility(View.GONE);
                    linebantinameDK.setVisibility(View.GONE);
                    chkbantinameDK.setChecked(false);
                    secbantitime.setVisibility(View.GONE);
                    linebantitime.setVisibility(View.GONE);
                    rdogrpbantitime.clearCheck();
                    secbantitimeDur.setVisibility(View.GONE);
                    linebantitimeDur.setVisibility(View.GONE);
                    txtbantitimeDur.setText("");
             }
             else if(rbData.equalsIgnoreCase("98"))
             {
                    seclblAntibiotics.setVisibility(View.GONE);
                    linelblAntibiotics.setVisibility(View.GONE);
                    secbantiname1.setVisibility(View.GONE);
                    linebantiname1.setVisibility(View.GONE);
                    txtbantiname1.setText("");
                    secbantiname2.setVisibility(View.GONE);
                    linebantiname2.setVisibility(View.GONE);
                    txtbantiname2.setText("");
                    secbantiname3.setVisibility(View.GONE);
                    linebantiname3.setVisibility(View.GONE);
                    txtbantiname3.setText("");
                    secbantinameDK.setVisibility(View.GONE);
                    linebantinameDK.setVisibility(View.GONE);
                    chkbantinameDK.setChecked(false);
                    secbantitime.setVisibility(View.GONE);
                    linebantitime.setVisibility(View.GONE);
                    rdogrpbantitime.clearCheck();
                    secbantitimeDur.setVisibility(View.GONE);
                    linebantitimeDur.setVisibility(View.GONE);
                    txtbantitimeDur.setText("");
             }
             else
             {
                    seclblAntibiotics.setVisibility(View.VISIBLE);
                    linelblAntibiotics.setVisibility(View.VISIBLE);
                    secbantiname1.setVisibility(View.VISIBLE);
                    linebantiname1.setVisibility(View.VISIBLE);
                    secbantiname2.setVisibility(View.VISIBLE);
                    linebantiname2.setVisibility(View.VISIBLE);
                    secbantiname3.setVisibility(View.VISIBLE);
                    linebantiname3.setVisibility(View.VISIBLE);
                    secbantinameDK.setVisibility(View.VISIBLE);
                    linebantinameDK.setVisibility(View.VISIBLE);
                    secbantitime.setVisibility(View.VISIBLE);
                    linebantitime.setVisibility(View.VISIBLE);
                    secbantitimeDur.setVisibility(View.VISIBLE);
                    linebantitimeDur.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         seclblAntibiotics=(LinearLayout)findViewById(R.id.seclblAntibiotics);
         linelblAntibiotics=(View)findViewById(R.id.linelblAntibiotics);
         secbantiname1=(LinearLayout)findViewById(R.id.secbantiname1);
         linebantiname1=(View)findViewById(R.id.linebantiname1);
         Vlblbantiname1=(TextView) findViewById(R.id.Vlblbantiname1);
         txtbantiname1=(EditText) findViewById(R.id.txtbantiname1);
         secbantiname2=(LinearLayout)findViewById(R.id.secbantiname2);
         linebantiname2=(View)findViewById(R.id.linebantiname2);
         Vlblbantiname2=(TextView) findViewById(R.id.Vlblbantiname2);
         txtbantiname2=(EditText) findViewById(R.id.txtbantiname2);
         secbantiname3=(LinearLayout)findViewById(R.id.secbantiname3);
         linebantiname3=(View)findViewById(R.id.linebantiname3);
         Vlblbantiname3=(TextView) findViewById(R.id.Vlblbantiname3);
         txtbantiname3=(EditText) findViewById(R.id.txtbantiname3);
         secbantinameDK=(LinearLayout)findViewById(R.id.secbantinameDK);
         linebantinameDK=(View)findViewById(R.id.linebantinameDK);
         VlblbantinameDK=(TextView) findViewById(R.id.VlblbantinameDK);
         chkbantinameDK=(CheckBox) findViewById(R.id.chkbantinameDK);
         secbantitime=(LinearLayout)findViewById(R.id.secbantitime);
         linebantitime=(View)findViewById(R.id.linebantitime);
         Vlblbantitime = (TextView) findViewById(R.id.Vlblbantitime);
         rdogrpbantitime = (RadioGroup) findViewById(R.id.rdogrpbantitime);
         
         rdobantitime1 = (RadioButton) findViewById(R.id.rdobantitime1);
         rdobantitime2 = (RadioButton) findViewById(R.id.rdobantitime2);
         rdobantitime3 = (RadioButton) findViewById(R.id.rdobantitime3);
         secbantitimeDur=(LinearLayout)findViewById(R.id.secbantitimeDur);
         linebantitimeDur=(View)findViewById(R.id.linebantitimeDur);
         VlblbantitimeDur=(TextView) findViewById(R.id.VlblbantitimeDur);
         txtbantitimeDur=(EditText) findViewById(R.id.txtbantitimeDur);
         secbantihome=(LinearLayout)findViewById(R.id.secbantihome);
         linebantihome=(View)findViewById(R.id.linebantihome);
         Vlblbantihome=(TextView) findViewById(R.id.Vlblbantihome);
         spnbantihome=(Spinner) findViewById(R.id.spnbantihome);
         List<String> listbantihome = new ArrayList<String>();
         
         listbantihome.add("");
         listbantihome.add("01-Yes");
         listbantihome.add("02-No");
         listbantihome.add("98-Dont know/dont remember");
         ArrayAdapter<String> adptrbantihome= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listbantihome);
         spnbantihome.setAdapter(adptrbantihome);

         secboxy=(LinearLayout)findViewById(R.id.secboxy);
         lineboxy=(View)findViewById(R.id.lineboxy);
         Vlblboxy=(TextView) findViewById(R.id.Vlblboxy);
         spnboxy=(Spinner) findViewById(R.id.spnboxy);
         List<String> listboxy = new ArrayList<String>();
         
         listboxy.add("");
         listboxy.add("01-Yes");
         listboxy.add("02-No");
         listboxy.add("98-Dont know/dont remember");
         ArrayAdapter<String> adptrboxy= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listboxy);
         spnboxy.setAdapter(adptrboxy);

         secbdiagtestknow=(LinearLayout)findViewById(R.id.secbdiagtestknow);
         linebdiagtestknow=(View)findViewById(R.id.linebdiagtestknow);
         Vlblbdiagtestknow = (TextView) findViewById(R.id.Vlblbdiagtestknow);
         rdogrpbdiagtestknow = (RadioGroup) findViewById(R.id.rdogrpbdiagtestknow);
         
         rdobdiagtestknow1 = (RadioButton) findViewById(R.id.rdobdiagtestknow1);
         rdobdiagtestknow2 = (RadioButton) findViewById(R.id.rdobdiagtestknow2);
         rdobdiagtestknow3 = (RadioButton) findViewById(R.id.rdobdiagtestknow3);
         rdogrpbdiagtestknow.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpbdiagtestknow = new String[] {"01","02","98"};
             for (int i = 0; i < rdogrpbdiagtestknow.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpbdiagtestknow.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpbdiagtestknow[i];
             }

             if(rbData.equalsIgnoreCase("02"))
             {
                    seclbl08a.setVisibility(View.GONE);
                    linelbl08a.setVisibility(View.GONE);
                    secbdiagtestA.setVisibility(View.GONE);
                    linebdiagtestA.setVisibility(View.GONE);
                    chkbdiagtestA.setChecked(false);
                    secbdiagtestB.setVisibility(View.GONE);
                    linebdiagtestB.setVisibility(View.GONE);
                    chkbdiagtestB.setChecked(false);
                    secbdiagtestC.setVisibility(View.GONE);
                    linebdiagtestC.setVisibility(View.GONE);
                    chkbdiagtestC.setChecked(false);
                    secbdiagtestD.setVisibility(View.GONE);
                    linebdiagtestD.setVisibility(View.GONE);
                    chkbdiagtestD.setChecked(false);
                    secbdiagtestDOth.setVisibility(View.GONE);
                    linebdiagtestDOth.setVisibility(View.GONE);
                    txtbdiagtestDOth.setText("");
                    secbdiagtestE.setVisibility(View.GONE);
                    linebdiagtestE.setVisibility(View.GONE);
                    chkbdiagtestE.setChecked(false);
                    seclbl09.setVisibility(View.GONE);
                    linelbl09.setVisibility(View.GONE);
             }
             else if(rbData.equalsIgnoreCase("98"))
             {
                    seclbl08a.setVisibility(View.GONE);
                    linelbl08a.setVisibility(View.GONE);
                    secbdiagtestA.setVisibility(View.GONE);
                    linebdiagtestA.setVisibility(View.GONE);
                    chkbdiagtestA.setChecked(false);
                    secbdiagtestB.setVisibility(View.GONE);
                    linebdiagtestB.setVisibility(View.GONE);
                    chkbdiagtestB.setChecked(false);
                    secbdiagtestC.setVisibility(View.GONE);
                    linebdiagtestC.setVisibility(View.GONE);
                    chkbdiagtestC.setChecked(false);
                    secbdiagtestD.setVisibility(View.GONE);
                    linebdiagtestD.setVisibility(View.GONE);
                    chkbdiagtestD.setChecked(false);
                    secbdiagtestDOth.setVisibility(View.GONE);
                    linebdiagtestDOth.setVisibility(View.GONE);
                    txtbdiagtestDOth.setText("");
                    secbdiagtestE.setVisibility(View.GONE);
                    linebdiagtestE.setVisibility(View.GONE);
                    chkbdiagtestE.setChecked(false);
                    seclbl09.setVisibility(View.GONE);
                    linelbl09.setVisibility(View.GONE);
             }
             else
             {
                    seclbl08a.setVisibility(View.VISIBLE);
                    linelbl08a.setVisibility(View.VISIBLE);
                    secbdiagtestA.setVisibility(View.VISIBLE);
                    linebdiagtestA.setVisibility(View.VISIBLE);
                    secbdiagtestB.setVisibility(View.VISIBLE);
                    linebdiagtestB.setVisibility(View.VISIBLE);
                    secbdiagtestC.setVisibility(View.VISIBLE);
                    linebdiagtestC.setVisibility(View.VISIBLE);
                    secbdiagtestD.setVisibility(View.VISIBLE);
                    linebdiagtestD.setVisibility(View.VISIBLE);
                    secbdiagtestE.setVisibility(View.VISIBLE);
                    linebdiagtestE.setVisibility(View.VISIBLE);
                    seclbl09.setVisibility(View.VISIBLE);
                    linelbl09.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         seclbl08a=(LinearLayout)findViewById(R.id.seclbl08a);
         linelbl08a=(View)findViewById(R.id.linelbl08a);
         secbdiagtestA=(LinearLayout)findViewById(R.id.secbdiagtestA);
         linebdiagtestA=(View)findViewById(R.id.linebdiagtestA);
         VlblbdiagtestA=(TextView) findViewById(R.id.VlblbdiagtestA);
         chkbdiagtestA=(CheckBox) findViewById(R.id.chkbdiagtestA);
         secbdiagtestB=(LinearLayout)findViewById(R.id.secbdiagtestB);
         linebdiagtestB=(View)findViewById(R.id.linebdiagtestB);
         VlblbdiagtestB=(TextView) findViewById(R.id.VlblbdiagtestB);
         chkbdiagtestB=(CheckBox) findViewById(R.id.chkbdiagtestB);
         secbdiagtestC=(LinearLayout)findViewById(R.id.secbdiagtestC);
         linebdiagtestC=(View)findViewById(R.id.linebdiagtestC);
         VlblbdiagtestC=(TextView) findViewById(R.id.VlblbdiagtestC);
         chkbdiagtestC=(CheckBox) findViewById(R.id.chkbdiagtestC);
         secbdiagtestD=(LinearLayout)findViewById(R.id.secbdiagtestD);
         linebdiagtestD=(View)findViewById(R.id.linebdiagtestD);
         VlblbdiagtestD=(TextView) findViewById(R.id.VlblbdiagtestD);
         chkbdiagtestD=(CheckBox) findViewById(R.id.chkbdiagtestD);
         chkbdiagtestD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if (!isChecked) {
                    secbdiagtestDOth.setVisibility(View.GONE);
                    linebdiagtestDOth.setVisibility(View.GONE);
                    txtbdiagtestDOth.setText("");
                 }
                 else
                 {
                    secbdiagtestDOth.setVisibility(View.VISIBLE);
                    linebdiagtestDOth.setVisibility(View.VISIBLE);
                 }
                 }
         });
         secbdiagtestDOth=(LinearLayout)findViewById(R.id.secbdiagtestDOth);
         linebdiagtestDOth=(View)findViewById(R.id.linebdiagtestDOth);
         VlblbdiagtestDOth=(TextView) findViewById(R.id.VlblbdiagtestDOth);
         txtbdiagtestDOth=(EditText) findViewById(R.id.txtbdiagtestDOth);
         secbdiagtestE=(LinearLayout)findViewById(R.id.secbdiagtestE);
         linebdiagtestE=(View)findViewById(R.id.linebdiagtestE);
         VlblbdiagtestE=(TextView) findViewById(R.id.VlblbdiagtestE);
         chkbdiagtestE=(CheckBox) findViewById(R.id.chkbdiagtestE);
         seclbl09=(LinearLayout)findViewById(R.id.seclbl09);
         linelbl09=(View)findViewById(R.id.linelbl09);
         secbfsupA=(LinearLayout)findViewById(R.id.secbfsupA);
         linebfsupA=(View)findViewById(R.id.linebfsupA);
         VlblbfsupA=(TextView) findViewById(R.id.VlblbfsupA);
         chkbfsupA=(CheckBox) findViewById(R.id.chkbfsupA);
         secbfsupB=(LinearLayout)findViewById(R.id.secbfsupB);
         linebfsupB=(View)findViewById(R.id.linebfsupB);
         VlblbfsupB=(TextView) findViewById(R.id.VlblbfsupB);
         chkbfsupB=(CheckBox) findViewById(R.id.chkbfsupB);
         secbfsupC=(LinearLayout)findViewById(R.id.secbfsupC);
         linebfsupC=(View)findViewById(R.id.linebfsupC);
         VlblbfsupC=(TextView) findViewById(R.id.VlblbfsupC);
         chkbfsupC=(CheckBox) findViewById(R.id.chkbfsupC);
         secbfsupD=(LinearLayout)findViewById(R.id.secbfsupD);
         linebfsupD=(View)findViewById(R.id.linebfsupD);
         VlblbfsupD=(TextView) findViewById(R.id.VlblbfsupD);
         chkbfsupD=(CheckBox) findViewById(R.id.chkbfsupD);
         secbfsupE=(LinearLayout)findViewById(R.id.secbfsupE);
         linebfsupE=(View)findViewById(R.id.linebfsupE);
         VlblbfsupE=(TextView) findViewById(R.id.VlblbfsupE);
         chkbfsupE=(CheckBox) findViewById(R.id.chkbfsupE);
         secbphoto=(LinearLayout)findViewById(R.id.secbphoto);
         linebphoto=(View)findViewById(R.id.linebphoto);
         Vlblbphoto = (TextView) findViewById(R.id.Vlblbphoto);
         rdogrpbphoto = (RadioGroup) findViewById(R.id.rdogrpbphoto);
         
         rdobphoto1 = (RadioButton) findViewById(R.id.rdobphoto1);
         rdobphoto2 = (RadioButton) findViewById(R.id.rdobphoto2);
         rdobphoto3 = (RadioButton) findViewById(R.id.rdobphoto3);
         secblos=(LinearLayout)findViewById(R.id.secblos);
         lineblos=(View)findViewById(R.id.lineblos);
         Vlblblos=(TextView) findViewById(R.id.Vlblblos);
         txtblos=(EditText) findViewById(R.id.txtblos);
         secblosDK=(LinearLayout)findViewById(R.id.secblosDK);
         lineblosDK=(View)findViewById(R.id.lineblosDK);
         VlblblosDK=(TextView) findViewById(R.id.VlblblosDK);
         chkblosDK=(CheckBox) findViewById(R.id.chkblosDK);
         secbref=(LinearLayout)findViewById(R.id.secbref);
         linebref=(View)findViewById(R.id.linebref);
         Vlblbref=(TextView) findViewById(R.id.Vlblbref);
         spnbref=(Spinner) findViewById(R.id.spnbref);
         List<String> listbref = new ArrayList<String>();
         
         listbref.add("");
         listbref.add("01-Yes");
         listbref.add("02-No");
         listbref.add("98-Dont know/dont remember");
         ArrayAdapter<String> adptrbref= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listbref);
         spnbref.setAdapter(adptrbref);

         secknowdiswgtni=(LinearLayout)findViewById(R.id.secknowdiswgtni);
         lineknowdiswgtni=(View)findViewById(R.id.lineknowdiswgtni);
         Vlblknowdiswgtni=(TextView) findViewById(R.id.Vlblknowdiswgtni);
         spnknowdiswgtni=(Spinner) findViewById(R.id.spnknowdiswgtni);
         List<String> listknowdiswgtni = new ArrayList<String>();
         
         listknowdiswgtni.add("");
         listknowdiswgtni.add("01-Yes");
         listknowdiswgtni.add("02-No");
         listknowdiswgtni.add("98-Dont know/dont remember");
         ArrayAdapter<String> adptrknowdiswgtni= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listknowdiswgtni);
         spnknowdiswgtni.setAdapter(adptrknowdiswgtni);

         secdiswgtni=(LinearLayout)findViewById(R.id.secdiswgtni);
         linediswgtni=(View)findViewById(R.id.linediswgtni);
         Vlbldiswgtni=(TextView) findViewById(R.id.Vlbldiswgtni);
         txtdiswgtni=(EditText) findViewById(R.id.txtdiswgtni);
         secdiswgtniDK=(LinearLayout)findViewById(R.id.secdiswgtniDK);
         linediswgtniDK=(View)findViewById(R.id.linediswgtniDK);
         VlbldiswgtniDK=(TextView) findViewById(R.id.VlbldiswgtniDK);
         chkdiswgtniDK=(CheckBox) findViewById(R.id.chkdiswgtniDK);





         //Hide all skip variables
         secbprobknow.setVisibility(View.GONE);
         linebprobknow.setVisibility(View.GONE);
         secbprob.setVisibility(View.GONE);
         linebprob.setVisibility(View.GONE);
         secbprobOth.setVisibility(View.GONE);
         linebprobOth.setVisibility(View.GONE);
         secbinfxn.setVisibility(View.GONE);
         linebinfxn.setVisibility(View.GONE);
         secbinfxnOth.setVisibility(View.GONE);
         linebinfxnOth.setVisibility(View.GONE);
         secknowadwgtni.setVisibility(View.GONE);
         lineknowadwgtni.setVisibility(View.GONE);
         secadwgtni.setVisibility(View.GONE);
         lineadwgtni.setVisibility(View.GONE);
         secadwgtniDK.setVisibility(View.GONE);
         lineadwgtniDK.setVisibility(View.GONE);
         secbseiz.setVisibility(View.GONE);
         linebseiz.setVisibility(View.GONE);
         secbseizdays.setVisibility(View.GONE);
         linebseizdays.setVisibility(View.GONE);
         secbseizdaysDK.setVisibility(View.GONE);
         linebseizdaysDK.setVisibility(View.GONE);
         secbantiknow.setVisibility(View.GONE);
         linebantiknow.setVisibility(View.GONE);
         seclblAntibiotics.setVisibility(View.GONE);
         linelblAntibiotics.setVisibility(View.GONE);
         secbantiname1.setVisibility(View.GONE);
         linebantiname1.setVisibility(View.GONE);
         secbantiname2.setVisibility(View.GONE);
         linebantiname2.setVisibility(View.GONE);
         secbantiname3.setVisibility(View.GONE);
         linebantiname3.setVisibility(View.GONE);
         secbantinameDK.setVisibility(View.GONE);
         linebantinameDK.setVisibility(View.GONE);
         secbantitime.setVisibility(View.GONE);
         linebantitime.setVisibility(View.GONE);
         secbantitimeDur.setVisibility(View.GONE);
         linebantitimeDur.setVisibility(View.GONE);
         secbantihome.setVisibility(View.GONE);
         linebantihome.setVisibility(View.GONE);
         secboxy.setVisibility(View.GONE);
         lineboxy.setVisibility(View.GONE);
         secbdiagtestknow.setVisibility(View.GONE);
         linebdiagtestknow.setVisibility(View.GONE);
         seclbl08a.setVisibility(View.GONE);
         linelbl08a.setVisibility(View.GONE);
         secbdiagtestA.setVisibility(View.GONE);
         linebdiagtestA.setVisibility(View.GONE);
         secbdiagtestB.setVisibility(View.GONE);
         linebdiagtestB.setVisibility(View.GONE);
         secbdiagtestC.setVisibility(View.GONE);
         linebdiagtestC.setVisibility(View.GONE);
         secbdiagtestD.setVisibility(View.GONE);
         linebdiagtestD.setVisibility(View.GONE);
         secbdiagtestDOth.setVisibility(View.GONE);
         linebdiagtestDOth.setVisibility(View.GONE);
         secbdiagtestE.setVisibility(View.GONE);
         linebdiagtestE.setVisibility(View.GONE);
         seclbl09.setVisibility(View.GONE);
         linelbl09.setVisibility(View.GONE);
         secbfsupA.setVisibility(View.GONE);
         linebfsupA.setVisibility(View.GONE);
         secbfsupB.setVisibility(View.GONE);
         linebfsupB.setVisibility(View.GONE);
         secbfsupC.setVisibility(View.GONE);
         linebfsupC.setVisibility(View.GONE);
         secbfsupD.setVisibility(View.GONE);
         linebfsupD.setVisibility(View.GONE);
         secbfsupE.setVisibility(View.GONE);
         linebfsupE.setVisibility(View.GONE);
         secbphoto.setVisibility(View.GONE);
         linebphoto.setVisibility(View.GONE);
         secblos.setVisibility(View.GONE);
         lineblos.setVisibility(View.GONE);
         secblosDK.setVisibility(View.GONE);
         lineblosDK.setVisibility(View.GONE);
         secbref.setVisibility(View.GONE);
         linebref.setVisibility(View.GONE);
         secknowdiswgtni.setVisibility(View.GONE);
         lineknowdiswgtni.setVisibility(View.GONE);
         secdiswgtni.setVisibility(View.GONE);
         linediswgtni.setVisibility(View.GONE);
         secdiswgtniDK.setVisibility(View.GONE);
         linediswgtniDK.setVisibility(View.GONE);
         secbprobknow.setVisibility(View.GONE);
         linebprobknow.setVisibility(View.GONE);
         secbprob.setVisibility(View.GONE);
         linebprob.setVisibility(View.GONE);
         secbprobOth.setVisibility(View.GONE);
         linebprobOth.setVisibility(View.GONE);
         secbinfxn.setVisibility(View.GONE);
         linebinfxn.setVisibility(View.GONE);
         secbinfxnOth.setVisibility(View.GONE);
         linebinfxnOth.setVisibility(View.GONE);
         secknowadwgtni.setVisibility(View.GONE);
         lineknowadwgtni.setVisibility(View.GONE);
         secadwgtni.setVisibility(View.GONE);
         lineadwgtni.setVisibility(View.GONE);
         secadwgtniDK.setVisibility(View.GONE);
         lineadwgtniDK.setVisibility(View.GONE);
         secbseiz.setVisibility(View.GONE);
         linebseiz.setVisibility(View.GONE);
         secbseizdays.setVisibility(View.GONE);
         linebseizdays.setVisibility(View.GONE);
         secbseizdaysDK.setVisibility(View.GONE);
         linebseizdaysDK.setVisibility(View.GONE);
         secbantiknow.setVisibility(View.GONE);
         linebantiknow.setVisibility(View.GONE);
         seclblAntibiotics.setVisibility(View.GONE);
         linelblAntibiotics.setVisibility(View.GONE);
         secbantiname1.setVisibility(View.GONE);
         linebantiname1.setVisibility(View.GONE);
         secbantiname2.setVisibility(View.GONE);
         linebantiname2.setVisibility(View.GONE);
         secbantiname3.setVisibility(View.GONE);
         linebantiname3.setVisibility(View.GONE);
         secbantinameDK.setVisibility(View.GONE);
         linebantinameDK.setVisibility(View.GONE);
         secbantitime.setVisibility(View.GONE);
         linebantitime.setVisibility(View.GONE);
         secbantitimeDur.setVisibility(View.GONE);
         linebantitimeDur.setVisibility(View.GONE);
         secbantihome.setVisibility(View.GONE);
         linebantihome.setVisibility(View.GONE);
         secboxy.setVisibility(View.GONE);
         lineboxy.setVisibility(View.GONE);
         secbdiagtestknow.setVisibility(View.GONE);
         linebdiagtestknow.setVisibility(View.GONE);
         seclbl08a.setVisibility(View.GONE);
         linelbl08a.setVisibility(View.GONE);
         secbdiagtestA.setVisibility(View.GONE);
         linebdiagtestA.setVisibility(View.GONE);
         secbdiagtestB.setVisibility(View.GONE);
         linebdiagtestB.setVisibility(View.GONE);
         secbdiagtestC.setVisibility(View.GONE);
         linebdiagtestC.setVisibility(View.GONE);
         secbdiagtestD.setVisibility(View.GONE);
         linebdiagtestD.setVisibility(View.GONE);
         secbdiagtestDOth.setVisibility(View.GONE);
         linebdiagtestDOth.setVisibility(View.GONE);
         secbdiagtestE.setVisibility(View.GONE);
         linebdiagtestE.setVisibility(View.GONE);
         seclbl09.setVisibility(View.GONE);
         linelbl09.setVisibility(View.GONE);
         secbfsupA.setVisibility(View.GONE);
         linebfsupA.setVisibility(View.GONE);
         secbfsupB.setVisibility(View.GONE);
         linebfsupB.setVisibility(View.GONE);
         secbfsupC.setVisibility(View.GONE);
         linebfsupC.setVisibility(View.GONE);
         secbfsupD.setVisibility(View.GONE);
         linebfsupD.setVisibility(View.GONE);
         secbfsupE.setVisibility(View.GONE);
         linebfsupE.setVisibility(View.GONE);
         secbphoto.setVisibility(View.GONE);
         linebphoto.setVisibility(View.GONE);
         secblos.setVisibility(View.GONE);
         lineblos.setVisibility(View.GONE);
         secblosDK.setVisibility(View.GONE);
         lineblosDK.setVisibility(View.GONE);
         secbref.setVisibility(View.GONE);
         linebref.setVisibility(View.GONE);
         secknowdiswgtni.setVisibility(View.GONE);
         lineknowdiswgtni.setVisibility(View.GONE);
         secdiswgtni.setVisibility(View.GONE);
         linediswgtni.setVisibility(View.GONE);
         secdiswgtniDK.setVisibility(View.GONE);
         linediswgtniDK.setVisibility(View.GONE);
         secbprob.setVisibility(View.GONE);
         linebprob.setVisibility(View.GONE);
         secbprobOth.setVisibility(View.GONE);
         linebprobOth.setVisibility(View.GONE);
         secbinfxn.setVisibility(View.GONE);
         linebinfxn.setVisibility(View.GONE);
         secbinfxnOth.setVisibility(View.GONE);
         linebinfxnOth.setVisibility(View.GONE);
         secbprob.setVisibility(View.GONE);
         linebprob.setVisibility(View.GONE);
         secbprobOth.setVisibility(View.GONE);
         linebprobOth.setVisibility(View.GONE);
         secbinfxn.setVisibility(View.GONE);
         linebinfxn.setVisibility(View.GONE);
         secbinfxnOth.setVisibility(View.GONE);
         linebinfxnOth.setVisibility(View.GONE);
         secbprobOth.setVisibility(View.GONE);
         linebprobOth.setVisibility(View.GONE);
         secbprobOth.setVisibility(View.GONE);
         linebprobOth.setVisibility(View.GONE);
         secbinfxnOth.setVisibility(View.GONE);
         linebinfxnOth.setVisibility(View.GONE);
         secbinfxnOth.setVisibility(View.GONE);
         linebinfxnOth.setVisibility(View.GONE);
         secbinfxnOth.setVisibility(View.GONE);
         linebinfxnOth.setVisibility(View.GONE);
         secbinfxnOth.setVisibility(View.GONE);
         linebinfxnOth.setVisibility(View.GONE);
         secbseizdays.setVisibility(View.GONE);
         linebseizdays.setVisibility(View.GONE);
         secbseizdaysDK.setVisibility(View.GONE);
         linebseizdaysDK.setVisibility(View.GONE);
         secbseizdays.setVisibility(View.GONE);
         linebseizdays.setVisibility(View.GONE);
         secbseizdaysDK.setVisibility(View.GONE);
         linebseizdaysDK.setVisibility(View.GONE);
         seclblAntibiotics.setVisibility(View.GONE);
         linelblAntibiotics.setVisibility(View.GONE);
         secbantiname1.setVisibility(View.GONE);
         linebantiname1.setVisibility(View.GONE);
         secbantiname2.setVisibility(View.GONE);
         linebantiname2.setVisibility(View.GONE);
         secbantiname3.setVisibility(View.GONE);
         linebantiname3.setVisibility(View.GONE);
         secbantinameDK.setVisibility(View.GONE);
         linebantinameDK.setVisibility(View.GONE);
         secbantitime.setVisibility(View.GONE);
         linebantitime.setVisibility(View.GONE);
         secbantitimeDur.setVisibility(View.GONE);
         linebantitimeDur.setVisibility(View.GONE);
         seclblAntibiotics.setVisibility(View.GONE);
         linelblAntibiotics.setVisibility(View.GONE);
         secbantiname1.setVisibility(View.GONE);
         linebantiname1.setVisibility(View.GONE);
         secbantiname2.setVisibility(View.GONE);
         linebantiname2.setVisibility(View.GONE);
         secbantiname3.setVisibility(View.GONE);
         linebantiname3.setVisibility(View.GONE);
         secbantinameDK.setVisibility(View.GONE);
         linebantinameDK.setVisibility(View.GONE);
         secbantitime.setVisibility(View.GONE);
         linebantitime.setVisibility(View.GONE);
         secbantitimeDur.setVisibility(View.GONE);
         linebantitimeDur.setVisibility(View.GONE);
         seclbl08a.setVisibility(View.GONE);
         linelbl08a.setVisibility(View.GONE);
         secbdiagtestA.setVisibility(View.GONE);
         linebdiagtestA.setVisibility(View.GONE);
         secbdiagtestB.setVisibility(View.GONE);
         linebdiagtestB.setVisibility(View.GONE);
         secbdiagtestC.setVisibility(View.GONE);
         linebdiagtestC.setVisibility(View.GONE);
         secbdiagtestD.setVisibility(View.GONE);
         linebdiagtestD.setVisibility(View.GONE);
         secbdiagtestDOth.setVisibility(View.GONE);
         linebdiagtestDOth.setVisibility(View.GONE);
         secbdiagtestE.setVisibility(View.GONE);
         linebdiagtestE.setVisibility(View.GONE);
         seclbl09.setVisibility(View.GONE);
         linelbl09.setVisibility(View.GONE);
         seclbl08a.setVisibility(View.GONE);
         linelbl08a.setVisibility(View.GONE);
         secbdiagtestA.setVisibility(View.GONE);
         linebdiagtestA.setVisibility(View.GONE);
         secbdiagtestB.setVisibility(View.GONE);
         linebdiagtestB.setVisibility(View.GONE);
         secbdiagtestC.setVisibility(View.GONE);
         linebdiagtestC.setVisibility(View.GONE);
         secbdiagtestD.setVisibility(View.GONE);
         linebdiagtestD.setVisibility(View.GONE);
         secbdiagtestDOth.setVisibility(View.GONE);
         linebdiagtestDOth.setVisibility(View.GONE);
         secbdiagtestE.setVisibility(View.GONE);
         linebdiagtestE.setVisibility(View.GONE);
         seclbl09.setVisibility(View.GONE);
         linelbl09.setVisibility(View.GONE);
         secbdiagtestDOth.setVisibility(View.GONE);
         linebdiagtestDOth.setVisibility(View.GONE);


        Button cmdSave = (Button) findViewById(R.id.cmdSave);
        cmdSave.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) { 
            DataSave();
        }});
     }
     catch(Exception  e)
     {
         Connection.MessageBox(RecallSurvS3.this, e.getMessage());
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
             Connection.MessageBox(RecallSurvS3.this, "Required field: CountryCode.");
             txtCountryCode.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtCountryCode.getText().toString().length()==0 ? "1" : txtCountryCode.getText().toString()) < 1 || Integer.valueOf(txtCountryCode.getText().toString().length()==0 ? "3" : txtCountryCode.getText().toString()) > 3)
           {
             Connection.MessageBox(RecallSurvS3.this, "Value should be between 1 and 3(CountryCode).");
             txtCountryCode.requestFocus(); 
             return;	
           }
         else if(txtFaciCode.getText().toString().length()==0 & secFaciCode.isShown())
           {
             Connection.MessageBox(RecallSurvS3.this, "Required field: FaciCode.");
             txtFaciCode.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtFaciCode.getText().toString().length()==0 ? "1" : txtFaciCode.getText().toString()) < 1 || Integer.valueOf(txtFaciCode.getText().toString().length()==0 ? "9" : txtFaciCode.getText().toString()) > 9)
           {
             Connection.MessageBox(RecallSurvS3.this, "Value should be between 1 and 9(FaciCode).");
             txtFaciCode.requestFocus(); 
             return;	
           }
         else if(txtDataID.getText().toString().length()==0 & secDataID.isShown())
           {
             Connection.MessageBox(RecallSurvS3.this, "Required field: DataID.");
             txtDataID.requestFocus(); 
             return;	
           }
         else if(txtStudyID.getText().toString().length()==0 & secStudyID.isShown())
           {
             Connection.MessageBox(RecallSurvS3.this, "Required field: ParticipantID.");
             txtStudyID.requestFocus(); 
             return;	
           }
         
         else if(!rdobneoward1.isChecked() & !rdobneoward2.isChecked() & !rdobneoward3.isChecked() & secbneoward.isShown())
           {
              Connection.MessageBox(RecallSurvS3.this, "Select anyone options from (Was your baby admitted to neonatal care unit/paediatric ward  for a problem?).");
              rdobneoward1.requestFocus();
              return;
           }
         
         else if(!rdobprobknow1.isChecked() & !rdobprobknow2.isChecked() & !rdobprobknow3.isChecked() & secbprobknow.isShown())
           {
              Connection.MessageBox(RecallSurvS3.this, "Select anyone options from (Do you know your baby’s problem?).");
              rdobprobknow1.requestFocus();
              return;
           }
         else if(spnbprob.getSelectedItemPosition()==0  & secbprob.isShown())
           {
             Connection.MessageBox(RecallSurvS3.this, "Required field: What is your baby’s problem?.");
             spnbprob.requestFocus(); 
             return;	
           }
         else if(txtbprobOth.getText().toString().length()==0 & secbprobOth.isShown())
           {
             Connection.MessageBox(RecallSurvS3.this, "Required field: specify.");
             txtbprobOth.requestFocus(); 
             return;	
           }
         else if(spnbinfxn.getSelectedItemPosition()==0  & secbinfxn.isShown())
           {
             Connection.MessageBox(RecallSurvS3.this, "Required field: If you were you told your baby had an infection, what type of infection did they have?.");
             spnbinfxn.requestFocus(); 
             return;	
           }
         else if(txtbinfxnOth.getText().toString().length()==0 & secbinfxnOth.isShown())
           {
             Connection.MessageBox(RecallSurvS3.this, "Required field: Specify.");
             txtbinfxnOth.requestFocus(); 
             return;	
           }
         else if(spnknowadwgtni.getSelectedItemPosition()==0  & secknowadwgtni.isShown())
           {
             Connection.MessageBox(RecallSurvS3.this, "Required field: Do you know your baby’s weight at time of admission to this unit?.");
             spnknowadwgtni.requestFocus(); 
             return;	
           }
         else if(txtadwgtni.getText().toString().length()==0 & secadwgtni.isShown())
           {
             Connection.MessageBox(RecallSurvS3.this, "Required field: How much did your baby weigh? (grams).");
             txtadwgtni.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtadwgtni.getText().toString().length()==0 ? "1" : txtadwgtni.getText().toString()) < 1 || Integer.valueOf(txtadwgtni.getText().toString().length()==0 ? "9999" : txtadwgtni.getText().toString()) > 9999)
           {
             Connection.MessageBox(RecallSurvS3.this, "Value should be between 1 and 9999(How much did your baby weigh? (grams)).");
             txtadwgtni.requestFocus(); 
             return;	
           }
         else if(spnbseiz.getSelectedItemPosition()==0  & secbseiz.isShown())
           {
             Connection.MessageBox(RecallSurvS3.this, "Required field: Did your baby have any seizures during the hospital stay?.");
             spnbseiz.requestFocus(); 
             return;	
           }
         else if(txtbseizdays.getText().toString().length()==0 & secbseizdays.isShown())
           {
             Connection.MessageBox(RecallSurvS3.this, "Required field: How many days did your baby have the seizure/s?.");
             txtbseizdays.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtbseizdays.getText().toString().length()==0 ? "1" : txtbseizdays.getText().toString()) < 1 || Integer.valueOf(txtbseizdays.getText().toString().length()==0 ? "99" : txtbseizdays.getText().toString()) > 99)
           {
             Connection.MessageBox(RecallSurvS3.this, "Value should be between 1 and 99(How many days did your baby have the seizure/s?).");
             txtbseizdays.requestFocus(); 
             return;	
           }
         
         else if(!rdobantiknow1.isChecked() & !rdobantiknow2.isChecked() & !rdobantiknow3.isChecked() & secbantiknow.isShown())
           {
              Connection.MessageBox(RecallSurvS3.this, "Select anyone options from (Do you know if your baby received any injection/antibiotics?).");
              rdobantiknow1.requestFocus();
              return;
           }
         else if(txtbantiname1.getText().toString().length()==0 & secbantiname1.isShown())
           {
             Connection.MessageBox(RecallSurvS3.this, "Required field: Specify 1.");
             txtbantiname1.requestFocus(); 
             return;	
           }
         else if(txtbantiname2.getText().toString().length()==0 & secbantiname2.isShown())
           {
             Connection.MessageBox(RecallSurvS3.this, "Required field: Specify 2.");
             txtbantiname2.requestFocus(); 
             return;	
           }
         else if(txtbantiname3.getText().toString().length()==0 & secbantiname3.isShown())
           {
             Connection.MessageBox(RecallSurvS3.this, "Required field: Specify 3.");
             txtbantiname3.requestFocus(); 
             return;	
           }
         
         else if(!rdobantitime1.isChecked() & !rdobantitime2.isChecked() & !rdobantitime3.isChecked() & secbantitime.isShown())
           {
              Connection.MessageBox(RecallSurvS3.this, "Select anyone options from (How many days in total did your baby receive injection antibiotics?).");
              rdobantitime1.requestFocus();
              return;
           }
         else if(txtbantitimeDur.getText().toString().length()==0 & secbantitimeDur.isShown())
           {
             Connection.MessageBox(RecallSurvS3.this, "Required field: Days.");
             txtbantitimeDur.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtbantitimeDur.getText().toString().length()==0 ? "1" : txtbantitimeDur.getText().toString()) < 1 || Integer.valueOf(txtbantitimeDur.getText().toString().length()==0 ? "99" : txtbantitimeDur.getText().toString()) > 99)
           {
             Connection.MessageBox(RecallSurvS3.this, "Value should be between 1 and 99(Days).");
             txtbantitimeDur.requestFocus(); 
             return;	
           }
         else if(spnbantihome.getSelectedItemPosition()==0  & secbantihome.isShown())
           {
             Connection.MessageBox(RecallSurvS3.this, "Required field: Do you have any antibiotics to give your baby when you go home?.");
             spnbantihome.requestFocus(); 
             return;	
           }
         else if(spnboxy.getSelectedItemPosition()==0  & secboxy.isShown())
           {
             Connection.MessageBox(RecallSurvS3.this, "Required field: Did your baby receive oxygen during hospital stay ? PROMPT SHOW PICTURE IF NECESSARY.");
             spnboxy.requestFocus(); 
             return;	
           }
         
         else if(!rdobdiagtestknow1.isChecked() & !rdobdiagtestknow2.isChecked() & !rdobdiagtestknow3.isChecked() & secbdiagtestknow.isShown())
           {
              Connection.MessageBox(RecallSurvS3.this, "Select anyone options from (Were diagnostic tests completed with your baby?).");
              rdobdiagtestknow1.requestFocus();
              return;
           }
         else if(txtbdiagtestDOth.getText().toString().length()==0 & secbdiagtestDOth.isShown())
           {
             Connection.MessageBox(RecallSurvS3.this, "Required field: Specify.");
             txtbdiagtestDOth.requestFocus(); 
             return;	
           }
         
         else if(!rdobphoto1.isChecked() & !rdobphoto2.isChecked() & !rdobphoto3.isChecked() & secbphoto.isShown())
           {
              Connection.MessageBox(RecallSurvS3.this, "Select anyone options from (Did your baby receive any phototherapy during the hospital stay? for example, was your baby yellow and put underneath lights?).");
              rdobphoto1.requestFocus();
              return;
           }
         else if(txtblos.getText().toString().length()==0 & secblos.isShown())
           {
             Connection.MessageBox(RecallSurvS3.this, "Required field: How many nights has your baby been admitted in inpatient care?.");
             txtblos.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtblos.getText().toString().length()==0 ? "1" : txtblos.getText().toString()) < 1 || Integer.valueOf(txtblos.getText().toString().length()==0 ? "99" : txtblos.getText().toString()) > 99)
           {
             Connection.MessageBox(RecallSurvS3.this, "Value should be between 1 and 99(How many nights has your baby been admitted in inpatient care?).");
             txtblos.requestFocus(); 
             return;	
           }
         else if(spnbref.getSelectedItemPosition()==0  & secbref.isShown())
           {
             Connection.MessageBox(RecallSurvS3.this, "Required field: Did the health worker refer your baby to another place or health facility?.");
             spnbref.requestFocus(); 
             return;	
           }
         else if(spnknowdiswgtni.getSelectedItemPosition()==0  & secknowdiswgtni.isShown())
           {
             Connection.MessageBox(RecallSurvS3.this, "Required field: Do you know your baby’s weight at time of discharge to this unit?.");
             spnknowdiswgtni.requestFocus(); 
             return;	
           }
         else if(txtdiswgtni.getText().toString().length()==0 & secdiswgtni.isShown())
           {
             Connection.MessageBox(RecallSurvS3.this, "Required field: How much did your baby weigh? (grams).");
             txtdiswgtni.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtdiswgtni.getText().toString().length()==0 ? "1" : txtdiswgtni.getText().toString()) < 1 || Integer.valueOf(txtdiswgtni.getText().toString().length()==0 ? "9999" : txtdiswgtni.getText().toString()) > 9999)
           {
             Connection.MessageBox(RecallSurvS3.this, "Value should be between 1 and 9999(How much did your baby weigh? (grams)).");
             txtdiswgtni.requestFocus(); 
             return;	
           }
 
         String SQL = "";
         RadioButton rb;

         RecallSurvS3_DataModel objSave = new RecallSurvS3_DataModel();
         objSave.setCountryCode(txtCountryCode.getText().toString());
         objSave.setFaciCode(txtFaciCode.getText().toString());
         objSave.setDataID(txtDataID.getText().toString());
         objSave.setStudyID(txtStudyID.getText().toString());
         String[] d_rdogrpbneoward = new String[] {"01","02","98"};
         objSave.setbneoward("");
         for (int i = 0; i < rdogrpbneoward.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpbneoward.getChildAt(i);
             if (rb.isChecked()) objSave.setbneoward(d_rdogrpbneoward[i]);
         }

         String[] d_rdogrpbprobknow = new String[] {"01","02","98"};
         objSave.setbprobknow("");
         for (int i = 0; i < rdogrpbprobknow.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpbprobknow.getChildAt(i);
             if (rb.isChecked()) objSave.setbprobknow(d_rdogrpbprobknow[i]);
         }

         objSave.setbprob((spnbprob.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnbprob.getSelectedItem().toString(), "-")));
         objSave.setbprobOth(txtbprobOth.getText().toString());
         objSave.setbinfxn((spnbinfxn.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnbinfxn.getSelectedItem().toString(), "-")));
         objSave.setbinfxnOth(txtbinfxnOth.getText().toString());
         objSave.setknowadwgtni((spnknowadwgtni.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnknowadwgtni.getSelectedItem().toString(), "-")));
         objSave.setadwgtni(txtadwgtni.getText().toString());
         objSave.setadwgtniDK((chkadwgtniDK.isChecked()?"1":(secadwgtniDK.isShown()?"2":"")));
         objSave.setbseiz((spnbseiz.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnbseiz.getSelectedItem().toString(), "-")));
         objSave.setbseizdays(txtbseizdays.getText().toString());
         objSave.setbseizdaysDK((chkbseizdaysDK.isChecked()?"1":(secbseizdaysDK.isShown()?"2":"")));
         String[] d_rdogrpbantiknow = new String[] {"01","02","98"};
         objSave.setbantiknow("");
         for (int i = 0; i < rdogrpbantiknow.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpbantiknow.getChildAt(i);
             if (rb.isChecked()) objSave.setbantiknow(d_rdogrpbantiknow[i]);
         }

         objSave.setbantiname1(txtbantiname1.getText().toString());
         objSave.setbantiname2(txtbantiname2.getText().toString());
         objSave.setbantiname3(txtbantiname3.getText().toString());
         objSave.setbantinameDK((chkbantinameDK.isChecked()?"1":(secbantinameDK.isShown()?"2":"")));
         String[] d_rdogrpbantitime = new String[] {"01","02","98"};
         objSave.setbantitime("");
         for (int i = 0; i < rdogrpbantitime.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpbantitime.getChildAt(i);
             if (rb.isChecked()) objSave.setbantitime(d_rdogrpbantitime[i]);
         }

         objSave.setbantitimeDur(txtbantitimeDur.getText().toString());
         objSave.setbantihome((spnbantihome.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnbantihome.getSelectedItem().toString(), "-")));
         objSave.setboxy((spnboxy.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnboxy.getSelectedItem().toString(), "-")));
         String[] d_rdogrpbdiagtestknow = new String[] {"01","02","98"};
         objSave.setbdiagtestknow("");
         for (int i = 0; i < rdogrpbdiagtestknow.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpbdiagtestknow.getChildAt(i);
             if (rb.isChecked()) objSave.setbdiagtestknow(d_rdogrpbdiagtestknow[i]);
         }

         objSave.setbdiagtestA((chkbdiagtestA.isChecked()?"1":(secbdiagtestA.isShown()?"2":"")));
         objSave.setbdiagtestB((chkbdiagtestB.isChecked()?"1":(secbdiagtestB.isShown()?"2":"")));
         objSave.setbdiagtestC((chkbdiagtestC.isChecked()?"1":(secbdiagtestC.isShown()?"2":"")));
         objSave.setbdiagtestD((chkbdiagtestD.isChecked()?"1":(secbdiagtestD.isShown()?"2":"")));
         objSave.setbdiagtestDOth(txtbdiagtestDOth.getText().toString());
         objSave.setbdiagtestE((chkbdiagtestE.isChecked()?"1":(secbdiagtestE.isShown()?"2":"")));
         objSave.setbfsupA((chkbfsupA.isChecked()?"1":(secbfsupA.isShown()?"2":"")));
         objSave.setbfsupB((chkbfsupB.isChecked()?"1":(secbfsupB.isShown()?"2":"")));
         objSave.setbfsupC((chkbfsupC.isChecked()?"1":(secbfsupC.isShown()?"2":"")));
         objSave.setbfsupD((chkbfsupD.isChecked()?"1":(secbfsupD.isShown()?"2":"")));
         objSave.setbfsupE((chkbfsupE.isChecked()?"1":(secbfsupE.isShown()?"2":"")));
         String[] d_rdogrpbphoto = new String[] {"01","02","98"};
         objSave.setbphoto("");
         for (int i = 0; i < rdogrpbphoto.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpbphoto.getChildAt(i);
             if (rb.isChecked()) objSave.setbphoto(d_rdogrpbphoto[i]);
         }

         objSave.setblos(txtblos.getText().toString());
         objSave.setblosDK((chkblosDK.isChecked()?"1":(secblosDK.isShown()?"2":"")));
         objSave.setbref((spnbref.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnbref.getSelectedItem().toString(), "-")));
         objSave.setknowdiswgtni((spnknowdiswgtni.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnknowdiswgtni.getSelectedItem().toString(), "-")));
         objSave.setdiswgtni(txtdiswgtni.getText().toString());
         objSave.setdiswgtniDK((chkdiswgtniDK.isChecked()?"1":(secdiswgtniDK.isShown()?"2":"")));
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

             Connection.MessageBox(RecallSurvS3.this, "Saved Successfully");
         }
         else{
             Connection.MessageBox(RecallSurvS3.this, status);
             return;
         }
     }
     catch(Exception  e)
     {
         Connection.MessageBox(RecallSurvS3.this, e.getMessage());
         return;
     }
 }

 private void DataSearch(String CountryCode, String FaciCode, String DataID)
     {
       try
        {
     
           RadioButton rb;
           RecallSurvS3_DataModel d = new RecallSurvS3_DataModel();
           String SQL = "Select * from "+ TableName +"  Where CountryCode='"+ CountryCode +"' and FaciCode='"+ FaciCode +"' and DataID='"+ DataID +"'";
           List<RecallSurvS3_DataModel> data = d.SelectAll(this, SQL);
           for(RecallSurvS3_DataModel item : data){
             txtCountryCode.setText(item.getCountryCode());
             txtFaciCode.setText(item.getFaciCode());
             txtDataID.setText(item.getDataID());
             txtStudyID.setText(item.getStudyID());
             String[] d_rdogrpbneoward = new String[] {"01","02","98"};
             for (int i = 0; i < d_rdogrpbneoward.length; i++)
             {
                 if (item.getbneoward().equals(String.valueOf(d_rdogrpbneoward[i])))
                 {
                     rb = (RadioButton)rdogrpbneoward.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpbprobknow = new String[] {"01","02","98"};
             for (int i = 0; i < d_rdogrpbprobknow.length; i++)
             {
                 if (item.getbprobknow().equals(String.valueOf(d_rdogrpbprobknow[i])))
                 {
                     rb = (RadioButton)rdogrpbprobknow.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             spnbprob.setSelection(Global.SpinnerItemPositionAnyLength(spnbprob, item.getbprob()));
             txtbprobOth.setText(item.getbprobOth());
             spnbinfxn.setSelection(Global.SpinnerItemPositionAnyLength(spnbinfxn, item.getbinfxn()));
             txtbinfxnOth.setText(item.getbinfxnOth());
             spnknowadwgtni.setSelection(Global.SpinnerItemPositionAnyLength(spnknowadwgtni, item.getknowadwgtni()));
             txtadwgtni.setText(item.getadwgtni());
             if(item.getadwgtniDK().equals("1"))
             {
                chkadwgtniDK.setChecked(true);
             }
             else if(item.getadwgtniDK().equals("2"))
             {
                chkadwgtniDK.setChecked(false);
             }
             spnbseiz.setSelection(Global.SpinnerItemPositionAnyLength(spnbseiz, item.getbseiz()));
             txtbseizdays.setText(item.getbseizdays());
             if(item.getbseizdaysDK().equals("1"))
             {
                chkbseizdaysDK.setChecked(true);
             }
             else if(item.getbseizdaysDK().equals("2"))
             {
                chkbseizdaysDK.setChecked(false);
             }
             String[] d_rdogrpbantiknow = new String[] {"01","02","98"};
             for (int i = 0; i < d_rdogrpbantiknow.length; i++)
             {
                 if (item.getbantiknow().equals(String.valueOf(d_rdogrpbantiknow[i])))
                 {
                     rb = (RadioButton)rdogrpbantiknow.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtbantiname1.setText(item.getbantiname1());
             txtbantiname2.setText(item.getbantiname2());
             txtbantiname3.setText(item.getbantiname3());
             if(item.getbantinameDK().equals("1"))
             {
                chkbantinameDK.setChecked(true);
             }
             else if(item.getbantinameDK().equals("2"))
             {
                chkbantinameDK.setChecked(false);
             }
             String[] d_rdogrpbantitime = new String[] {"01","02","98"};
             for (int i = 0; i < d_rdogrpbantitime.length; i++)
             {
                 if (item.getbantitime().equals(String.valueOf(d_rdogrpbantitime[i])))
                 {
                     rb = (RadioButton)rdogrpbantitime.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtbantitimeDur.setText(item.getbantitimeDur());
             spnbantihome.setSelection(Global.SpinnerItemPositionAnyLength(spnbantihome, item.getbantihome()));
             spnboxy.setSelection(Global.SpinnerItemPositionAnyLength(spnboxy, item.getboxy()));
             String[] d_rdogrpbdiagtestknow = new String[] {"01","02","98"};
             for (int i = 0; i < d_rdogrpbdiagtestknow.length; i++)
             {
                 if (item.getbdiagtestknow().equals(String.valueOf(d_rdogrpbdiagtestknow[i])))
                 {
                     rb = (RadioButton)rdogrpbdiagtestknow.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             if(item.getbdiagtestA().equals("1"))
             {
                chkbdiagtestA.setChecked(true);
             }
             else if(item.getbdiagtestA().equals("2"))
             {
                chkbdiagtestA.setChecked(false);
             }
             if(item.getbdiagtestB().equals("1"))
             {
                chkbdiagtestB.setChecked(true);
             }
             else if(item.getbdiagtestB().equals("2"))
             {
                chkbdiagtestB.setChecked(false);
             }
             if(item.getbdiagtestC().equals("1"))
             {
                chkbdiagtestC.setChecked(true);
             }
             else if(item.getbdiagtestC().equals("2"))
             {
                chkbdiagtestC.setChecked(false);
             }
             if(item.getbdiagtestD().equals("1"))
             {
                chkbdiagtestD.setChecked(true);
             }
             else if(item.getbdiagtestD().equals("2"))
             {
                chkbdiagtestD.setChecked(false);
             }
             txtbdiagtestDOth.setText(item.getbdiagtestDOth());
             if(item.getbdiagtestE().equals("1"))
             {
                chkbdiagtestE.setChecked(true);
             }
             else if(item.getbdiagtestE().equals("2"))
             {
                chkbdiagtestE.setChecked(false);
             }
             if(item.getbfsupA().equals("1"))
             {
                chkbfsupA.setChecked(true);
             }
             else if(item.getbfsupA().equals("2"))
             {
                chkbfsupA.setChecked(false);
             }
             if(item.getbfsupB().equals("1"))
             {
                chkbfsupB.setChecked(true);
             }
             else if(item.getbfsupB().equals("2"))
             {
                chkbfsupB.setChecked(false);
             }
             if(item.getbfsupC().equals("1"))
             {
                chkbfsupC.setChecked(true);
             }
             else if(item.getbfsupC().equals("2"))
             {
                chkbfsupC.setChecked(false);
             }
             if(item.getbfsupD().equals("1"))
             {
                chkbfsupD.setChecked(true);
             }
             else if(item.getbfsupD().equals("2"))
             {
                chkbfsupD.setChecked(false);
             }
             if(item.getbfsupE().equals("1"))
             {
                chkbfsupE.setChecked(true);
             }
             else if(item.getbfsupE().equals("2"))
             {
                chkbfsupE.setChecked(false);
             }
             String[] d_rdogrpbphoto = new String[] {"01","02","98"};
             for (int i = 0; i < d_rdogrpbphoto.length; i++)
             {
                 if (item.getbphoto().equals(String.valueOf(d_rdogrpbphoto[i])))
                 {
                     rb = (RadioButton)rdogrpbphoto.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtblos.setText(item.getblos());
             if(item.getblosDK().equals("1"))
             {
                chkblosDK.setChecked(true);
             }
             else if(item.getblosDK().equals("2"))
             {
                chkblosDK.setChecked(false);
             }
             spnbref.setSelection(Global.SpinnerItemPositionAnyLength(spnbref, item.getbref()));
             spnknowdiswgtni.setSelection(Global.SpinnerItemPositionAnyLength(spnknowdiswgtni, item.getknowdiswgtni()));
             txtdiswgtni.setText(item.getdiswgtni());
             if(item.getdiswgtniDK().equals("1"))
             {
                chkdiswgtniDK.setChecked(true);
             }
             else if(item.getdiswgtniDK().equals("2"))
             {
                chkdiswgtniDK.setChecked(false);
             }
           }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(RecallSurvS3.this, e.getMessage());
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