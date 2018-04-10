
 package org.icddrb.enap;


 //Android Manifest Code
 //<activity android:name=".RecallSurvS2" android:label="RecallSurvS2" />
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
 import android.widget.Toast;

 import Utility.*;
 import Common.*;

 public class RecallSurvS2 extends Activity {
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
         LinearLayout seclblsecII6;
         View linelblsecII6;
         LinearLayout seclblsecII1;
         View linelblsecII1;
         LinearLayout secbb4expect;
         View linebb4expect;
         TextView Vlblbb4expect;
         RadioGroup rdogrpbb4expect;
         
         RadioButton rdobb4expect1;
         RadioButton rdobb4expect2;
         RadioButton rdobb4expect3;
         LinearLayout secredeliv;
         View lineredeliv;
         TextView Vlblredeliv;
         RadioGroup rdogrpredeliv;
         
         RadioButton rdoredeliv1;
         RadioButton rdoredeliv2;
         RadioButton rdoredeliv3;
         LinearLayout seclblsecII7;
         View linelblsecII7;
         LinearLayout secedeliv;
         View lineedeliv;
         TextView Vlbledeliv;
         RadioGroup rdogrpedeliv;
         
         RadioButton rdoedeliv1;
         RadioButton rdoedeliv2;
         RadioButton rdoedeliv3;
         RadioButton rdoedeliv4;
         LinearLayout secedelivDur;
         View lineedelivDur;
         TextView VlbledelivDur;
         EditText txtedelivDur;
         LinearLayout secacsgiven;
         View lineacsgiven;
         TextView Vlblacsgiven;
         RadioGroup rdogrpacsgiven;
         
         RadioButton rdoacsgiven1;
         RadioButton rdoacsgiven2;
         RadioButton rdoacsgiven3;
         LinearLayout secacsreason;
         View lineacsreason;
         TextView Vlblacsreason;
         Spinner spnacsreason;
         LinearLayout secacsreasonOth;
         View lineacsreasonOth;
         TextView VlblacsreasonOth;
         EditText txtacsreasonOth;
         LinearLayout secacsname;
         View lineacsname;
         TextView Vlblacsname;
         Spinner spnacsname;
         LinearLayout secacsnameOth;
         View lineacsnameOth;
         TextView VlblacsnameOth;
         EditText txtacsnameOth;
         LinearLayout secacsroute;
         View lineacsroute;
         TextView Vlblacsroute;
         Spinner spnacsroute;
         LinearLayout secacsrouteOth;
         View lineacsrouteOth;
         TextView VlblacsrouteOth;
         EditText txtacsrouteOth;
         LinearLayout secacsdoses;
         View lineacsdoses;
         TextView Vlblacsdoses;
         EditText txtacsdoses;
         LinearLayout secacsdosesDK;
         View lineacsdosesDK;
         TextView VlblacsdosesDK;
         CheckBox chkacsdosesDK;
         LinearLayout secacstime;
         View lineacstime;
         TextView Vlblacstime;
         Spinner spnacstime;
         LinearLayout seclblsecII2;
         View linelblsecII2;
         LinearLayout seclblsecII8;
         View linelblsecII8;
         LinearLayout secmedadeliv;
         View linemedadeliv;
         TextView Vlblmedadeliv;
         RadioGroup rdogrpmedadeliv;
         
         RadioButton rdomedadeliv1;
         RadioButton rdomedadeliv2;
         RadioButton rdomedadeliv3;
         LinearLayout seclblsecII9;
         View linelblsecII9;
         LinearLayout secuteroroute1;
         View lineuteroroute1;
         TextView Vlbluteroroute1;
         CheckBox chkuteroroute1;
         LinearLayout secuteroroute2;
         View lineuteroroute2;
         TextView Vlbluteroroute2;
         CheckBox chkuteroroute2;
         LinearLayout secuteroroute3;
         View lineuteroroute3;
         TextView Vlbluteroroute3;
         CheckBox chkuteroroute3;
         LinearLayout secuteroroute4;
         View lineuteroroute4;
         TextView Vlbluteroroute4;
         CheckBox chkuteroroute4;
         LinearLayout secuteroroute5;
         View lineuteroroute5;
         TextView Vlbluteroroute5;
         CheckBox chkuteroroute5;
         LinearLayout secuterotime;
         View lineuterotime;
         TextView Vlbluterotime;
         Spinner spnuterotime;
         LinearLayout secuterotold;
         View lineuterotold;
         TextView Vlbluterotold;
         RadioGroup rdogrputerotold;
         
         RadioButton rdouterotold1;
         RadioButton rdouterotold2;
         RadioButton rdouterotold3;
         LinearLayout secuteroknow;
         View lineuteroknow;
         TextView Vlbluteroknow;
         RadioGroup rdogrputeroknow;
         
         RadioButton rdouteroknow1;
         RadioButton rdouteroknow2;
         RadioButton rdouteroknow3;
         LinearLayout seclblsecII16;
         View linelblsecII16;
         LinearLayout secuteronameA;
         View lineuteronameA;
         TextView VlbluteronameA;
         CheckBox chkuteronameA;
         LinearLayout secuteronameB;
         View lineuteronameB;
         TextView VlbluteronameB;
         CheckBox chkuteronameB;
         LinearLayout secuteronameC;
         View lineuteronameC;
         TextView VlbluteronameC;
         CheckBox chkuteronameC;
         LinearLayout secuteronameD;
         View lineuteronameD;
         TextView VlbluteronameD;
         CheckBox chkuteronameD;
         LinearLayout secuteronameDOth;
         View lineuteronameDOth;
         TextView VlbluteronameDOth;
         EditText txtuteronameDOth;
         LinearLayout secuteronameE;
         View lineuteronameE;
         TextView VlbluteronameE;
         CheckBox chkuteronameE;
         LinearLayout sectolduteroreas;
         View linetolduteroreas;
         TextView Vlbltolduteroreas;
         RadioGroup rdogrptolduteroreas;
         
         RadioButton rdotolduteroreas1;
         RadioButton rdotolduteroreas2;
         RadioButton rdotolduteroreas3;
         LinearLayout seclblsecII17;
         View linelblsecII17;
         LinearLayout secuteroreasA;
         View lineuteroreasA;
         TextView VlbluteroreasA;
         CheckBox chkuteroreasA;
         LinearLayout secuteroreasB;
         View lineuteroreasB;
         TextView VlbluteroreasB;
         CheckBox chkuteroreasB;
         LinearLayout secuteroreasOth;
         View lineuteroreasOth;
         TextView VlbluteroreasOth;
         EditText txtuteroreasOth;
         LinearLayout secuteroreasC;
         View lineuteroreasC;
         TextView VlbluteroreasC;
         CheckBox chkuteroreasC;
         LinearLayout seclblsecII3;
         View linelblsecII3;
         LinearLayout secbdried;
         View linebdried;
         TextView Vlblbdried;
         RadioGroup rdogrpbdried;
         
         RadioButton rdobdried1;
         RadioButton rdobdried2;
         RadioButton rdobdried3;
         LinearLayout secbnakchest;
         View linebnakchest;
         TextView Vlblbnakchest;
         RadioGroup rdogrpbnakchest;
         
         RadioButton rdobnakchest1;
         RadioButton rdobnakchest2;
         RadioButton rdobnakchest3;
         LinearLayout secbchesttime;
         View linebchesttime;
         TextView Vlblbchesttime;
         RadioGroup rdogrpbchesttime;
         
         RadioButton rdobchesttime1;
         RadioButton rdobchesttime2;
         RadioButton rdobchesttime3;
         LinearLayout secbchesttimeM;
         View linebchesttimeM;
         TextView VlblbchesttimeM;
         EditText txtbchesttimeM;
         LinearLayout secbplaced;
         View linebplaced;
         TextView Vlblbplaced;
         Spinner spnbplaced;
         LinearLayout secbbathtime;
         View linebbathtime;
         TextView Vlblbbathtime;
         RadioGroup rdogrpbbathtime;
         
         RadioButton rdobbathtime1;
         RadioButton rdobbathtime2;
         RadioButton rdobbathtime3;
         RadioButton rdobbathtime4;
        RadioButton rdobbathtime5;
         LinearLayout secbbathtimeDur;
         View linebbathtimeDur;
         TextView VlblbbathtimeDur;
         EditText txtbbathtimeDur;
         LinearLayout seclblsecII10;
         View linelblsecII10;
         LinearLayout secbbfd;
         View linebbfd;
         TextView Vlblbbfd;
         RadioGroup rdogrpbbfd;
         
         RadioButton rdobbfd1;
         RadioButton rdobbfd2;
         RadioButton rdobbfd3;
         LinearLayout secbfdtime;
         View linebfdtime;
         TextView Vlblbfdtime;
         Spinner spnbfdtime;
         LinearLayout secbfdtimeDur;
         View linebfdtimeDur;
         TextView VlblbfdtimeDur;
         EditText txtbfdtimeDur;
         LinearLayout seclblsecII11;
         View linelblsecII11;
         LinearLayout secsupbfd;
         View linesupbfd;
         TextView Vlblsupbfd;
         RadioGroup rdogrpsupbfd;
         
         RadioButton rdosupbfd1;
         RadioButton rdosupbfd2;
         RadioButton rdosupbfd3;
         LinearLayout seclblsecII18;
         View linelblsecII18;
         LinearLayout secaltdrinkA;
         View linealtdrinkA;
         TextView VlblaltdrinkA;
         CheckBox chkaltdrinkA;
         LinearLayout secaltdrinkB;
         View linealtdrinkB;
         TextView VlblaltdrinkB;
         CheckBox chkaltdrinkB;
         LinearLayout secaltdrinkC;
         View linealtdrinkC;
         TextView VlblaltdrinkC;
         CheckBox chkaltdrinkC;
         LinearLayout secaltdrinkD;
         View linealtdrinkD;
         TextView VlblaltdrinkD;
         CheckBox chkaltdrinkD;
         LinearLayout secaltdrinkDOth;
         View linealtdrinkDOth;
         TextView VlblaltdrinkDOth;
         EditText txtaltdrinkDOth;
         LinearLayout secaltdrinkE;
         View linealtdrinkE;
         TextView VlblaltdrinkE;
         CheckBox chkaltdrinkE;
         LinearLayout secaltdrinkF;
         View linealtdrinkF;
         TextView VlblaltdrinkF;
         CheckBox chkaltdrinkF;
         LinearLayout seclblsecII4;
         View linelblsecII4;
         LinearLayout secbcry;
         View linebcry;
         TextView Vlblbcry;
         RadioGroup rdogrpbcry;
         
         RadioButton rdobcry1;
         RadioButton rdobcry2;
         RadioButton rdobcry3;
         LinearLayout secbtroubbrth;
         View linebtroubbrth;
         TextView Vlblbtroubbrth;
         RadioGroup rdogrpbtroubbrth;
         
         RadioButton rdobtroubbrth1;
         RadioButton rdobtroubbrth2;
         RadioButton rdobtroubbrth3;
         LinearLayout seclblsecII13;
         View linelblsecII13;
         LinearLayout sechelpbbrthA;
         View linehelpbbrthA;
         TextView VlblhelpbbrthA;
         CheckBox chkhelpbbrthA;
         LinearLayout sechelpbbrthB;
         View linehelpbbrthB;
         TextView VlblhelpbbrthB;
         CheckBox chkhelpbbrthB;
         LinearLayout sechelpbbrthC;
         View linehelpbbrthC;
         TextView VlblhelpbbrthC;
         CheckBox chkhelpbbrthC;
         LinearLayout sechelpbbrthD;
         View linehelpbbrthD;
         TextView VlblhelpbbrthD;
         CheckBox chkhelpbbrthD;
         LinearLayout sechelpbbrthE;
         View linehelpbbrthE;
         TextView VlblhelpbbrthE;
         CheckBox chkhelpbbrthE;
         LinearLayout secbstim;
         View linebstim;
         TextView Vlblbstim;
         RadioGroup rdogrpbstim;
         
         RadioButton rdobstim1;
         RadioButton rdobstim2;
         RadioButton rdobstim3;
         LinearLayout secbplast;
         View linebplast;
         TextView Vlblbplast;
         RadioGroup rdogrpbplast;
         
         RadioButton rdobplast1;
         RadioButton rdobplast2;
         RadioButton rdobplast3;
         LinearLayout secbresustmin;
         View linebresustmin;
         TextView Vlblbresustmin;
         RadioGroup rdogrpbresustmin;
         
         RadioButton rdobresustmin1;
         RadioButton rdobresustmin2;
         LinearLayout secbresustminDur;
         View linebresustminDur;
         TextView VlblbresustminDur;
         EditText txtbresustminDur;
         LinearLayout secbsuc;
         View linebsuc;
         TextView Vlblbsuc;
         RadioGroup rdogrpbsuc;
         
         RadioButton rdobsuc1;
         RadioButton rdobsuc2;
         RadioButton rdobsuc3;
         LinearLayout secoresusact;
         View lineoresusact;
         TextView Vlbloresusact;
         RadioGroup rdogrporesusact;
         
         RadioButton rdooresusact1;
         RadioButton rdooresusact2;
         RadioButton rdooresusact3;
         LinearLayout secoresusactOth;
         View lineoresusactOth;
         TextView VlbloresusactOth;
         EditText txtoresusactOth;
         LinearLayout secbadmward;
         View linebadmward;
         TextView Vlblbadmward;
         RadioGroup rdogrpbadmward;
         
         RadioButton rdobadmward1;
         RadioButton rdobadmward2;
         RadioButton rdobadmward3;
         LinearLayout sectoldresusexp;
         View linetoldresusexp;
         TextView Vlbltoldresusexp;
         //Spinner spntoldresusexp;
     RadioGroup rdogrptoldresusexp;
     RadioButton rdotoldresusexp1;
     RadioButton rdotoldresusexp2;
     RadioButton rdotoldresusexp3;

         LinearLayout secresusexp;
         View lineresusexp;
         TextView Vlblresusexp;
         EditText txtresusexp;
         LinearLayout secresusexpDK;
         View lineresusexpDK;
         TextView VlblresusexpDK;
         CheckBox chkresusexpDK;
         LinearLayout seclblsecII14;
         View linelblsecII14;
         LinearLayout secappcord;
         View lineappcord;
         TextView Vlblappcord;
         //Spinner spnappcord;
     RadioGroup rdogrpappcord;
     RadioButton rdoappcord1;
     RadioButton rdoappcord2;
     RadioButton rdoappcord3;

         LinearLayout secmedappcord;
         View linemedappcord;
         TextView Vlblmedappcord;
         RadioGroup rdogrpmedappcord;
         
         RadioButton rdomedappcord1;
         RadioButton rdomedappcord2;
         RadioButton rdomedappcord3;
         LinearLayout secmedappcordOth;
         View linemedappcordOth;
         TextView VlblmedappcordOth;
         EditText txtmedappcordOth;
         LinearLayout seclblsecII15;
         View linelblsecII15;
         LinearLayout sectimechl;
         View linetimechl;
         TextView Vlbltimechl;
         RadioGroup rdogrptimechl;
         
         RadioButton rdotimechl1;
         RadioButton rdotimechl2;
         RadioButton rdotimechl3;
         LinearLayout sectimechlDur;
         View linetimechlDur;
         TextView VlbltimechlDur;
         EditText txttimechlDur;
         LinearLayout seclblsecII19;
         View linelblsecII19;
         LinearLayout secwhoappchl;
         View linewhoappchl;
         TextView Vlblwhoappchl;
         Spinner spnwhoappchl;
         LinearLayout secwhoappchlOth;
         View linewhoappchlOth;
         TextView VlblwhoappchlOth;
         EditText txtwhoappchlOth;
         LinearLayout sectoldchlreas;
         View linetoldchlreas;
         TextView Vlbltoldchlreas;
         //Spinner spntoldchlreas;
     RadioGroup rdogrptoldchlreas;
     RadioButton rdotoldchlreas1;
     RadioButton rdotoldchlreas2;
     RadioButton rdotoldchlreas3;

         LinearLayout secchlreas;
         View linechlreas;
         TextView Vlblchlreas;
         EditText txtchlreas;
         LinearLayout secchlreasDK;
         View linechlreasDK;
         TextView VlblchlreasDK;
         CheckBox chkchlreasDK;
         LinearLayout secchlhome;
         View linechlhome;
         TextView Vlblchlhome;
         //Spinner spnchlhome;

     RadioGroup rdogrpchlhome;
     RadioButton rdochlhome1;
     RadioButton rdochlhome2;
     RadioButton rdochlhome3;

         LinearLayout seccomments;
         View linecomments;
         TextView Vlblcomments;
         EditText txtcomments;

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
         COUNTRYCODE = sp.getValue(this, "countrycode");

         if(ProjectSetting.MRS_Language_English = true){
             setContentView(R.layout.recallsurvs2);
         }else {
             if (COUNTRYCODE.equals(ProjectSetting.BANGLADESH))
                 setContentView(R.layout.recallsurvs2_bd);
             else if (COUNTRYCODE.equals(ProjectSetting.NEPAL))
                 setContentView(R.layout.recallsurvs2_np);
             else if (COUNTRYCODE.equals(ProjectSetting.TANZANIA))
                 setContentView(R.layout.recallsurvs2_tz);
             else
                 setContentView(R.layout.recallsurvs2);
         }

         C = new Connection(this);
         g = Global.getInstance();

         STARTTIME = g.CurrentTime24();
         DEVICEID  = sp.getValue(this, "deviceid");
         ENTRYUSER = sp.getValue(this, "userid");

         IDbundle = getIntent().getExtras();
         //top of page
         //COUNTRYCODE = sp.getValue(this, "countrycode");
         FACICODE    = sp.getValue(this, "facicode");
         STUDYID = IDbundle.getString("studyid");
         DATAID = IDbundle.getString("dataid");

         TableName = "RecallSurvS2";

         //turnGPSOn();

         //GPS Location
         //FindLocation();
         // Double.toString(currentLatitude);
         // Double.toString(currentLongitude);
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(RecallSurvS2.this);
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
          txtCountryCode.setEnabled(false);
         secFaciCode=(LinearLayout)findViewById(R.id.secFaciCode);
         lineFaciCode=(View)findViewById(R.id.lineFaciCode);
         VlblFaciCode=(TextView) findViewById(R.id.VlblFaciCode);
         txtFaciCode=(EditText) findViewById(R.id.txtFaciCode);
          txtFaciCode.setText(FACICODE);
          txtFaciCode.setEnabled(false);
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
         seclblsecII6=(LinearLayout)findViewById(R.id.seclblsecII6);
         linelblsecII6=(View)findViewById(R.id.linelblsecII6);
         seclblsecII1=(LinearLayout)findViewById(R.id.seclblsecII1);
         linelblsecII1=(View)findViewById(R.id.linelblsecII1);
         secbb4expect=(LinearLayout)findViewById(R.id.secbb4expect);
         linebb4expect=(View)findViewById(R.id.linebb4expect);
         Vlblbb4expect = (TextView) findViewById(R.id.Vlblbb4expect);
         rdogrpbb4expect = (RadioGroup) findViewById(R.id.rdogrpbb4expect);
         
         rdobb4expect1 = (RadioButton) findViewById(R.id.rdobb4expect1);
         rdobb4expect2 = (RadioButton) findViewById(R.id.rdobb4expect2);
         rdobb4expect3 = (RadioButton) findViewById(R.id.rdobb4expect3);
         rdogrpbb4expect.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpbb4expect = new String[] {"1","2","9"};
             for (int i = 0; i < rdogrpbb4expect.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpbb4expect.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpbb4expect[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                    secredeliv.setVisibility(View.GONE);
                    lineredeliv.setVisibility(View.GONE);
                    rdogrpredeliv.clearCheck();
                    seclblsecII7.setVisibility(View.GONE);
                    linelblsecII7.setVisibility(View.GONE);

                  //**************************added by sakib**************************************************

                  secacsreasonOth.setVisibility(View.GONE);
                  txtacsreasonOth.setText("");
                  lineacsreasonOth.setVisibility(View.GONE);

                  secacsnameOth.setVisibility(View.GONE);
                  txtacsnameOth.setText("");
                  lineacsnameOth.setVisibility(View.GONE);
                  //**************************added by sakib**************************************************


             }
             else
             {
                    secredeliv.setVisibility(View.VISIBLE);
                    lineredeliv.setVisibility(View.VISIBLE);

                  //**************************added by sakib**************************************************

                  secacsreasonOth.setVisibility(View.GONE);
                  txtacsreasonOth.setText("");
                  lineacsreasonOth.setVisibility(View.GONE);

                  secacsnameOth.setVisibility(View.GONE);
                  txtacsnameOth.setText("");
                  lineacsnameOth.setVisibility(View.GONE);
                  //**************************added by sakib**************************************************
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secredeliv=(LinearLayout)findViewById(R.id.secredeliv);
         lineredeliv=(View)findViewById(R.id.lineredeliv);
         Vlblredeliv = (TextView) findViewById(R.id.Vlblredeliv);
         rdogrpredeliv = (RadioGroup) findViewById(R.id.rdogrpredeliv);
         
         rdoredeliv1 = (RadioButton) findViewById(R.id.rdoredeliv1);
         rdoredeliv2 = (RadioButton) findViewById(R.id.rdoredeliv2);
         rdoredeliv3 = (RadioButton) findViewById(R.id.rdoredeliv3);
         rdogrpredeliv.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpredeliv = new String[] {"1","2","9"};
             for (int i = 0; i < rdogrpredeliv.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpredeliv.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpredeliv[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                    seclblsecII7.setVisibility(View.GONE);
                    linelblsecII7.setVisibility(View.GONE);
                    secedeliv.setVisibility(View.GONE);
                    lineedeliv.setVisibility(View.GONE);
                    rdogrpedeliv.clearCheck();
                    secedelivDur.setVisibility(View.GONE);
                    lineedelivDur.setVisibility(View.GONE);
                    txtedelivDur.setText("");

                  //*********************added by sakib*****************************
                  secacsgiven.setVisibility(View.VISIBLE);
                  lineacsgiven.setVisibility(View.VISIBLE);
                  rdogrpacsgiven.clearCheck();
                  secacsreason.setVisibility(View.VISIBLE);
                  lineacsreason.setVisibility(View.VISIBLE);
                  spnacsreason.setSelection(0);
//                  secacsreasonOth.setVisibility(View.VISIBLE);
//                  lineacsreasonOth.setVisibility(View.VISIBLE);
//                  txtacsreasonOth.setText("");
                  secacsname.setVisibility(View.VISIBLE);
                  lineacsname.setVisibility(View.VISIBLE);
                  spnacsname.setSelection(0);
//                  secacsnameOth.setVisibility(View.VISIBLE);
//                  lineacsnameOth.setVisibility(View.VISIBLE);
//                  txtacsnameOth.setText("");
                  secacsroute.setVisibility(View.VISIBLE);
                  lineacsroute.setVisibility(View.VISIBLE);
                  spnacsroute.setSelection(0);
//                  secacsrouteOth.setVisibility(View.VISIBLE);
//                  lineacsrouteOth.setVisibility(View.VISIBLE);
//                  txtacsrouteOth.setText("");
                  secacsdoses.setVisibility(View.VISIBLE);
                  lineacsdoses.setVisibility(View.VISIBLE);
                  txtacsdoses.setText("");
                  secacsdosesDK.setVisibility(View.VISIBLE);
                  lineacsdosesDK.setVisibility(View.VISIBLE);
                  chkacsdosesDK.setChecked(false);
                  secacstime.setVisibility(View.VISIBLE);
                  lineacstime.setVisibility(View.VISIBLE);
                  spnacstime.setSelection(0);
                  //*********************added by sakib***************************

             }
             else if(rbData.equalsIgnoreCase("2"))
             {

                  seclblsecII7.setVisibility(View.GONE);
                    linelblsecII7.setVisibility(View.GONE);
                    secedeliv.setVisibility(View.GONE);
                    lineedeliv.setVisibility(View.GONE);
                    rdogrpedeliv.clearCheck();
                    secedelivDur.setVisibility(View.GONE);
                    lineedelivDur.setVisibility(View.GONE);
                    txtedelivDur.setText("");
                    secacsgiven.setVisibility(View.GONE);
                    lineacsgiven.setVisibility(View.GONE);
                    rdogrpacsgiven.clearCheck();
                    secacsreason.setVisibility(View.GONE);
                    lineacsreason.setVisibility(View.GONE);
                    spnacsreason.setSelection(0);
                    secacsreasonOth.setVisibility(View.GONE);
                    lineacsreasonOth.setVisibility(View.GONE);
                    txtacsreasonOth.setText("");
                    secacsname.setVisibility(View.GONE);
                    lineacsname.setVisibility(View.GONE);
                    spnacsname.setSelection(0);
                    secacsnameOth.setVisibility(View.GONE);
                    lineacsnameOth.setVisibility(View.GONE);
                    txtacsnameOth.setText("");
                    secacsroute.setVisibility(View.GONE);
                    lineacsroute.setVisibility(View.GONE);
                    spnacsroute.setSelection(0);
                    secacsrouteOth.setVisibility(View.GONE);
                    lineacsrouteOth.setVisibility(View.GONE);
                    txtacsrouteOth.setText("");
                    secacsdoses.setVisibility(View.GONE);
                    lineacsdoses.setVisibility(View.GONE);
                    txtacsdoses.setText("");
                    secacsdosesDK.setVisibility(View.GONE);
                    lineacsdosesDK.setVisibility(View.GONE);
                    chkacsdosesDK.setChecked(false);
                    secacstime.setVisibility(View.GONE);
                    lineacstime.setVisibility(View.GONE);
                    spnacstime.setSelection(0);
                    //seclblsecII2.setVisibility(View.GONE);
                    linelblsecII2.setVisibility(View.GONE);
                    seclblsecII8.setVisibility(View.GONE);
                    linelblsecII8.setVisibility(View.GONE);
             }
             else if(rbData.equalsIgnoreCase("9"))
             {

                  seclblsecII7.setVisibility(View.GONE);
                    linelblsecII7.setVisibility(View.GONE);
                    secedeliv.setVisibility(View.GONE);
                    lineedeliv.setVisibility(View.GONE);
                    rdogrpedeliv.clearCheck();
                    secedelivDur.setVisibility(View.GONE);
                    lineedelivDur.setVisibility(View.GONE);
                    txtedelivDur.setText("");
                    secacsgiven.setVisibility(View.GONE);
                    lineacsgiven.setVisibility(View.GONE);
                    rdogrpacsgiven.clearCheck();
                    secacsreason.setVisibility(View.GONE);
                    lineacsreason.setVisibility(View.GONE);
                    spnacsreason.setSelection(0);
                    secacsreasonOth.setVisibility(View.GONE);
                    lineacsreasonOth.setVisibility(View.GONE);
                    txtacsreasonOth.setText("");
                    secacsname.setVisibility(View.GONE);
                    lineacsname.setVisibility(View.GONE);
                    spnacsname.setSelection(0);
                    secacsnameOth.setVisibility(View.GONE);
                    lineacsnameOth.setVisibility(View.GONE);
                    txtacsnameOth.setText("");
                    secacsroute.setVisibility(View.GONE);
                    lineacsroute.setVisibility(View.GONE);
                    spnacsroute.setSelection(0);
                    secacsrouteOth.setVisibility(View.GONE);
                    lineacsrouteOth.setVisibility(View.GONE);
                    txtacsrouteOth.setText("");
                    secacsdoses.setVisibility(View.GONE);
                    lineacsdoses.setVisibility(View.GONE);
                    txtacsdoses.setText("");
                    secacsdosesDK.setVisibility(View.GONE);
                    lineacsdosesDK.setVisibility(View.GONE);
                    chkacsdosesDK.setChecked(false);
                    secacstime.setVisibility(View.GONE);
                    lineacstime.setVisibility(View.GONE);
                    spnacstime.setSelection(0);
                    //seclblsecII2.setVisibility(View.GONE);
                    linelblsecII2.setVisibility(View.GONE);
                    seclblsecII8.setVisibility(View.GONE);
                    linelblsecII8.setVisibility(View.GONE);
             }
             else
             {
                    seclblsecII7.setVisibility(View.VISIBLE);
                    linelblsecII7.setVisibility(View.VISIBLE);
                    secedeliv.setVisibility(View.VISIBLE);
                    lineedeliv.setVisibility(View.VISIBLE);
                    secedelivDur.setVisibility(View.VISIBLE);
                    lineedelivDur.setVisibility(View.VISIBLE);
                    secacsgiven.setVisibility(View.VISIBLE);
                    lineacsgiven.setVisibility(View.VISIBLE);
                    secacsreason.setVisibility(View.VISIBLE);
                    lineacsreason.setVisibility(View.VISIBLE);
                    secacsreasonOth.setVisibility(View.VISIBLE);
                    lineacsreasonOth.setVisibility(View.VISIBLE);
                    secacsname.setVisibility(View.VISIBLE);
                    lineacsname.setVisibility(View.VISIBLE);
                    secacsnameOth.setVisibility(View.VISIBLE);
                    lineacsnameOth.setVisibility(View.VISIBLE);
                    secacsroute.setVisibility(View.VISIBLE);
                    lineacsroute.setVisibility(View.VISIBLE);
                    secacsdoses.setVisibility(View.VISIBLE);
                    lineacsdoses.setVisibility(View.VISIBLE);
                    secacsdosesDK.setVisibility(View.VISIBLE);
                    lineacsdosesDK.setVisibility(View.VISIBLE);
                    secacstime.setVisibility(View.VISIBLE);
                    lineacstime.setVisibility(View.VISIBLE);
                    seclblsecII2.setVisibility(View.VISIBLE);
                    linelblsecII2.setVisibility(View.VISIBLE);
                    seclblsecII8.setVisibility(View.VISIBLE);
                    linelblsecII8.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         seclblsecII7=(LinearLayout)findViewById(R.id.seclblsecII7);
         linelblsecII7=(View)findViewById(R.id.linelblsecII7);
         secedeliv=(LinearLayout)findViewById(R.id.secedeliv);
         lineedeliv=(View)findViewById(R.id.lineedeliv);
         Vlbledeliv = (TextView) findViewById(R.id.Vlbledeliv);
         rdogrpedeliv = (RadioGroup) findViewById(R.id.rdogrpedeliv);
         
         rdoedeliv1 = (RadioButton) findViewById(R.id.rdoedeliv1);
         rdoedeliv2 = (RadioButton) findViewById(R.id.rdoedeliv2);
         rdoedeliv3 = (RadioButton) findViewById(R.id.rdoedeliv3);
         rdoedeliv4 = (RadioButton) findViewById(R.id.rdoedeliv4);
         secedelivDur=(LinearLayout)findViewById(R.id.secedelivDur);
         lineedelivDur=(View)findViewById(R.id.lineedelivDur);
         VlbledelivDur=(TextView) findViewById(R.id.VlbledelivDur);
         txtedelivDur=(EditText) findViewById(R.id.txtedelivDur);
         secacsgiven=(LinearLayout)findViewById(R.id.secacsgiven);
         lineacsgiven=(View)findViewById(R.id.lineacsgiven);
         Vlblacsgiven = (TextView) findViewById(R.id.Vlblacsgiven);
         rdogrpacsgiven = (RadioGroup) findViewById(R.id.rdogrpacsgiven);
         
         rdoacsgiven1 = (RadioButton) findViewById(R.id.rdoacsgiven1);
         rdoacsgiven2 = (RadioButton) findViewById(R.id.rdoacsgiven2);
         rdoacsgiven3 = (RadioButton) findViewById(R.id.rdoacsgiven3);
         rdogrpacsgiven.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpacsgiven = new String[] {"1","2","9"};
             for (int i = 0; i < rdogrpacsgiven.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpacsgiven.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpacsgiven[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secacsreason.setVisibility(View.GONE);
                    lineacsreason.setVisibility(View.GONE);
                    spnacsreason.setSelection(0);
                    secacsreasonOth.setVisibility(View.GONE);
                    lineacsreasonOth.setVisibility(View.GONE);
                    txtacsreasonOth.setText("");
                    secacsname.setVisibility(View.GONE);
                    lineacsname.setVisibility(View.GONE);
                    spnacsname.setSelection(0);
                    secacsnameOth.setVisibility(View.GONE);
                    lineacsnameOth.setVisibility(View.GONE);
                    txtacsnameOth.setText("");
                    secacsroute.setVisibility(View.GONE);
                    lineacsroute.setVisibility(View.GONE);
                    spnacsroute.setSelection(0);
                    secacsrouteOth.setVisibility(View.GONE);
                    lineacsrouteOth.setVisibility(View.GONE);
                    txtacsrouteOth.setText("");
                    secacsdoses.setVisibility(View.GONE);
                    lineacsdoses.setVisibility(View.GONE);
                    txtacsdoses.setText("");
                    secacsdosesDK.setVisibility(View.GONE);
                    lineacsdosesDK.setVisibility(View.GONE);
                    chkacsdosesDK.setChecked(false);
                    secacstime.setVisibility(View.GONE);
                    lineacstime.setVisibility(View.GONE);
                    spnacstime.setSelection(0);
                    //seclblsecII2.setVisibility(View.GONE);
                    linelblsecII2.setVisibility(View.GONE);
                    seclblsecII8.setVisibility(View.GONE);
                    linelblsecII8.setVisibility(View.GONE);
             }
             else if(rbData.equalsIgnoreCase("9"))
             {
                    secacsreason.setVisibility(View.GONE);
                    lineacsreason.setVisibility(View.GONE);
                    spnacsreason.setSelection(0);
                    secacsreasonOth.setVisibility(View.GONE);
                    lineacsreasonOth.setVisibility(View.GONE);
                    txtacsreasonOth.setText("");
                    secacsname.setVisibility(View.GONE);
                    lineacsname.setVisibility(View.GONE);
                    spnacsname.setSelection(0);
                    secacsnameOth.setVisibility(View.GONE);
                    lineacsnameOth.setVisibility(View.GONE);
                    txtacsnameOth.setText("");
                    secacsroute.setVisibility(View.GONE);
                    lineacsroute.setVisibility(View.GONE);
                    spnacsroute.setSelection(0);
                    secacsrouteOth.setVisibility(View.GONE);
                    lineacsrouteOth.setVisibility(View.GONE);
                    txtacsrouteOth.setText("");
                    secacsdoses.setVisibility(View.GONE);
                    lineacsdoses.setVisibility(View.GONE);
                    txtacsdoses.setText("");
                    secacsdosesDK.setVisibility(View.GONE);
                    lineacsdosesDK.setVisibility(View.GONE);
                    chkacsdosesDK.setChecked(false);
                    secacstime.setVisibility(View.GONE);
                    lineacstime.setVisibility(View.GONE);
                    spnacstime.setSelection(0);
                    //seclblsecII2.setVisibility(View.GONE);
                    linelblsecII2.setVisibility(View.GONE);
                    seclblsecII8.setVisibility(View.GONE);
                    linelblsecII8.setVisibility(View.GONE);
             }
             else
             {
                    secacsreason.setVisibility(View.VISIBLE);
                    lineacsreason.setVisibility(View.VISIBLE);
                    secacsreasonOth.setVisibility(View.VISIBLE);
                    lineacsreasonOth.setVisibility(View.VISIBLE);
                    secacsname.setVisibility(View.VISIBLE);
                    lineacsname.setVisibility(View.VISIBLE);
                    secacsnameOth.setVisibility(View.VISIBLE);
                    lineacsnameOth.setVisibility(View.VISIBLE);
                    secacsroute.setVisibility(View.VISIBLE);
                    lineacsroute.setVisibility(View.VISIBLE);
                    secacsdoses.setVisibility(View.VISIBLE);
                    lineacsdoses.setVisibility(View.VISIBLE);
                    secacsdosesDK.setVisibility(View.VISIBLE);
                    lineacsdosesDK.setVisibility(View.VISIBLE);
                    secacstime.setVisibility(View.VISIBLE);
                    lineacstime.setVisibility(View.VISIBLE);
                    seclblsecII2.setVisibility(View.VISIBLE);
                    linelblsecII2.setVisibility(View.VISIBLE);
                    seclblsecII8.setVisibility(View.VISIBLE);
                    linelblsecII8.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secacsreason=(LinearLayout)findViewById(R.id.secacsreason);
         lineacsreason=(View)findViewById(R.id.lineacsreason);
         Vlblacsreason=(TextView) findViewById(R.id.Vlblacsreason);
         spnacsreason=(Spinner) findViewById(R.id.spnacsreason);
         List<String> listacsreason = new ArrayList<String>();

         if(COUNTRYCODE.equals(ProjectSetting.BANGLADESH)){
             listacsreason.add("1-নাম এর ফুসফুস যাতে পরিপক্ব হয়");
             listacsreason.add("2-বলা হয়নি");
             listacsreason.add("7-অন্যান্য");
             listacsreason.add("9-জানিনা/মনে নাই");
         }else if(COUNTRYCODE.equals(ProjectSetting.NEPAL)){
             listacsreason.add("1-बच्चाको फोक्सो बलियो बनाउन");
             listacsreason.add("2-भनेको छैन");
             listacsreason.add("7-अन्य");
             listacsreason.add("9-थाहा छैन/ याद छैन");
         }else if(COUNTRYCODE.equals(ProjectSetting.TANZANIA)){
             listacsreason.add("1-Kusaidia mapafu ya mtoto kukoma/ kuimarika");
             listacsreason.add("2-Sikujulishwa");
             listacsreason.add("7-Nyingine");
             listacsreason.add("9-Sijui/Sikumbuki");
         }else {
             listacsreason.add("");
             listacsreason.add("1-Help your babies lungs mature/get ripe");
             listacsreason.add("2-Not told");
             listacsreason.add("7-Other");
             listacsreason.add("9-Don't know/don't remember");
         }
         ArrayAdapter<String> adptracsreason= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listacsreason);
         spnacsreason.setAdapter(adptracsreason);

         spnacsreason.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             if (spnacsreason.getSelectedItem().toString().length() == 0) return;
             String spnData = Connection.SelectedSpinnerValue(spnacsreason.getSelectedItem().toString(),"-");
                 if(spnData.equalsIgnoreCase("1"))
                 {
                    secacsreasonOth.setVisibility(View.GONE);
                    lineacsreasonOth.setVisibility(View.GONE);
                    txtacsreasonOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                    secacsreasonOth.setVisibility(View.GONE);
                    lineacsreasonOth.setVisibility(View.GONE);
                    txtacsreasonOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("9"))
                 {
                    secacsreasonOth.setVisibility(View.GONE);
                    lineacsreasonOth.setVisibility(View.GONE);
                    txtacsreasonOth.setText("");
                 }
                 else
                 {
                    secacsreasonOth.setVisibility(View.VISIBLE);
                    lineacsreasonOth.setVisibility(View.VISIBLE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secacsreasonOth=(LinearLayout)findViewById(R.id.secacsreasonOth);
         lineacsreasonOth=(View)findViewById(R.id.lineacsreasonOth);
         VlblacsreasonOth=(TextView) findViewById(R.id.VlblacsreasonOth);
         txtacsreasonOth=(EditText) findViewById(R.id.txtacsreasonOth);
         secacsname=(LinearLayout)findViewById(R.id.secacsname);
         lineacsname=(View)findViewById(R.id.lineacsname);
         Vlblacsname=(TextView) findViewById(R.id.Vlblacsname);
         spnacsname=(Spinner) findViewById(R.id.spnacsname);
         List<String> listacsname = new ArrayList<String>();
         
         listacsname.add("");
         if(COUNTRYCODE.equals(ProjectSetting.BANGLADESH)){
             listacsname.add("1-ডেক্সামেথাসন");
             listacsname.add("2-বেটামেথাসন");
             listacsname.add("3-একটি স্টেরয়েড");
             listacsname.add("7-অন্যান্য");
             listacsname.add("9-জানিনা/মনে নাই");

         }else if(COUNTRYCODE.equals(ProjectSetting.NEPAL)){
             listacsname.add("1-डेक्सामेथासोन");
             listacsname.add("2-बेटामेथासोन");
             listacsname.add("3-प्रेडनिसोलोन");
             listacsname.add("7-अन्य");
             listacsname.add("9-थाहा छैन/ याद छैन.");
         }else if(COUNTRYCODE.equals(ProjectSetting.TANZANIA)){
             listacsname.add("1-Dexamethasone");
             listacsname.add("2-Betamethasone");
             listacsname.add("3-A steroid");
             listacsname.add("7-Nyingine");
             listacsname.add("9-Sijui/Sikumbuki");
         }
         else {
             listacsname.add("1-Dexamethasone");
             listacsname.add("2-Betamethasone");
             listacsname.add("3-A steroid");
             listacsname.add("7-Other");
             listacsname.add("9-Don’t know/don’t remember");
         }
         ArrayAdapter<String> adptracsname= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listacsname);
         spnacsname.setAdapter(adptracsname);

         spnacsname.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             if (spnacsname.getSelectedItem().toString().length() == 0) return;
             String spnData = Connection.SelectedSpinnerValue(spnacsname.getSelectedItem().toString(),"-");
                 if(spnData.equalsIgnoreCase("1"))
                 {
                    secacsnameOth.setVisibility(View.GONE);
                    lineacsnameOth.setVisibility(View.GONE);
                    txtacsnameOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                    secacsnameOth.setVisibility(View.GONE);
                    lineacsnameOth.setVisibility(View.GONE);
                    txtacsnameOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("3"))
                 {
                    secacsnameOth.setVisibility(View.GONE);
                    lineacsnameOth.setVisibility(View.GONE);
                    txtacsnameOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("9"))
                 {
                    secacsnameOth.setVisibility(View.GONE);
                    lineacsnameOth.setVisibility(View.GONE);
                    txtacsnameOth.setText("");
                 }
                 else
                 {
                    secacsnameOth.setVisibility(View.VISIBLE);
                    lineacsnameOth.setVisibility(View.VISIBLE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secacsnameOth=(LinearLayout)findViewById(R.id.secacsnameOth);
         lineacsnameOth=(View)findViewById(R.id.lineacsnameOth);
         VlblacsnameOth=(TextView) findViewById(R.id.VlblacsnameOth);
         txtacsnameOth=(EditText) findViewById(R.id.txtacsnameOth);
         secacsroute=(LinearLayout)findViewById(R.id.secacsroute);
         lineacsroute=(View)findViewById(R.id.lineacsroute);
         Vlblacsroute=(TextView) findViewById(R.id.Vlblacsroute);
         spnacsroute=(Spinner) findViewById(R.id.spnacsroute);
         List<String> listacsroute = new ArrayList<String>();
         
         listacsroute.add("");
         if(COUNTRYCODE.equals(ProjectSetting.BANGLADESH)){
             listacsroute.add("1-ট্যাবলেট");
             listacsroute.add("2-ইঞ্জেকশন");
             listacsroute.add("3-শিরাপথে");
             listacsroute.add("7-অন্যান্য");
             listacsroute.add("9-জানিনা/মনে নাই");
         }else if(COUNTRYCODE.equals(ProjectSetting.NEPAL)){
             listacsroute.add("1-ट्याब्लेट");
             listacsroute.add("2-सुई");
             listacsroute.add("3-नसाबाट दिने सुइ");
             listacsroute.add("7-अन्य");
             listacsroute.add("9-थाहा छैन/ यादछैन");
         }else if(COUNTRYCODE.equals(ProjectSetting.TANZANIA)){
             listacsroute.add("1-Kidonge");
             listacsroute.add("2-Sindano");
             listacsroute.add("3-Kwa njia ya mshipa");
             listacsroute.add("7-Nyingine");
             listacsroute.add("9-Sijui/Sikumbuki");
         }else {
             listacsroute.add("1-Tablet");
             listacsroute.add("2-Injection");
             listacsroute.add("3-IV");
             listacsroute.add("7-Other");
             listacsroute.add("9-Don't know/don't remember");
         }
         ArrayAdapter<String> adptracsroute= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listacsroute);
         spnacsroute.setAdapter(adptracsroute);

         spnacsroute.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             if (spnacsroute.getSelectedItem().toString().length() == 0) return;
             String spnData = Connection.SelectedSpinnerValue(spnacsroute.getSelectedItem().toString(),"-");
                 if(spnData.equalsIgnoreCase("1"))
                 {
                    secacsrouteOth.setVisibility(View.GONE);
                    lineacsrouteOth.setVisibility(View.GONE);
                    txtacsrouteOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                    secacsrouteOth.setVisibility(View.GONE);
                    lineacsrouteOth.setVisibility(View.GONE);
                    txtacsrouteOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("3"))
                 {
                    secacsrouteOth.setVisibility(View.GONE);
                    lineacsrouteOth.setVisibility(View.GONE);
                    txtacsrouteOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("9"))
                 {
                    secacsrouteOth.setVisibility(View.GONE);
                    lineacsrouteOth.setVisibility(View.GONE);
                    txtacsrouteOth.setText("");
                 }
                 else
                 {
                    secacsrouteOth.setVisibility(View.VISIBLE);
                    lineacsrouteOth.setVisibility(View.VISIBLE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secacsrouteOth=(LinearLayout)findViewById(R.id.secacsrouteOth);
         lineacsrouteOth=(View)findViewById(R.id.lineacsrouteOth);
         VlblacsrouteOth=(TextView) findViewById(R.id.VlblacsrouteOth);
         txtacsrouteOth=(EditText) findViewById(R.id.txtacsrouteOth);
         secacsdoses=(LinearLayout)findViewById(R.id.secacsdoses);
         lineacsdoses=(View)findViewById(R.id.lineacsdoses);
         Vlblacsdoses=(TextView) findViewById(R.id.Vlblacsdoses);
         txtacsdoses=(EditText) findViewById(R.id.txtacsdoses);
         secacsdosesDK=(LinearLayout)findViewById(R.id.secacsdosesDK);
         lineacsdosesDK=(View)findViewById(R.id.lineacsdosesDK);
         VlblacsdosesDK=(TextView) findViewById(R.id.VlblacsdosesDK);
         chkacsdosesDK=(CheckBox) findViewById(R.id.chkacsdosesDK);
         secacstime=(LinearLayout)findViewById(R.id.secacstime);
         lineacstime=(View)findViewById(R.id.lineacstime);
         Vlblacstime=(TextView) findViewById(R.id.Vlblacstime);
         spnacstime=(Spinner) findViewById(R.id.spnacstime);
         List<String> listacstime = new ArrayList<String>();
         
         listacstime.add("");
         if(COUNTRYCODE.equals(ProjectSetting.BANGLADESH)){
             listacstime.add("1-১২ ঘন্টার কমে");
             listacstime.add("2-১২ থেকে ২৪ ঘন্টার মধ্যে");
             listacstime.add("3-২৪ ঘন্টা থেকে ১ সপ্তাহ এর মধ্যে");
             listacstime.add("4-১ সপ্তাহ এর উপরে");
             listacstime.add("9-জানিনা/মনে নাই");
         }else if(COUNTRYCODE.equals(ProjectSetting.NEPAL)){
             listacstime.add("1-१२ घन्टा भन्दा कम");
             listacstime.add("2-१२-२४ घन्टा भित्र");
             listacstime.add("3-२४ घन्टा - १ हप्ता भित्र");
             listacstime.add("4-१ हप्ता भन्दा बढी");
             listacstime.add("9-थाहा छैन/ याद छैन");
         }else if(COUNTRYCODE.equals(ProjectSetting.TANZANIA)){
             listacstime.add("1-Chini ya masaa 12");
             listacstime.add("2-Kati ya masaa 12 na 24.");
             listacstime.add("3-Kati ya masaa 24 na wiki 1");
             listacstime.add("4-Zaidi ya wiki 1");
             listacstime.add("9-Sijui/Sikumbuki");
         }else {
             listacstime.add("1-Less than 12 hours");
             listacstime.add("2-Between 12-24 hours");
             listacstime.add("3-Between 24 hours - 1 week");
             listacstime.add("4-More than 1 week");
             listacstime.add("9-Don't know/don't remember");
         }
         ArrayAdapter<String> adptracstime= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listacstime);
         spnacstime.setAdapter(adptracstime);

         seclblsecII2=(LinearLayout)findViewById(R.id.seclblsecII2);
         linelblsecII2=(View)findViewById(R.id.linelblsecII2);
         seclblsecII8=(LinearLayout)findViewById(R.id.seclblsecII8);
         linelblsecII8=(View)findViewById(R.id.linelblsecII8);
         secmedadeliv=(LinearLayout)findViewById(R.id.secmedadeliv);
         linemedadeliv=(View)findViewById(R.id.linemedadeliv);
         Vlblmedadeliv = (TextView) findViewById(R.id.Vlblmedadeliv);
         rdogrpmedadeliv = (RadioGroup) findViewById(R.id.rdogrpmedadeliv);
         
         rdomedadeliv1 = (RadioButton) findViewById(R.id.rdomedadeliv1);
         rdomedadeliv2 = (RadioButton) findViewById(R.id.rdomedadeliv2);
         rdomedadeliv3 = (RadioButton) findViewById(R.id.rdomedadeliv3);
         rdogrpmedadeliv.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpmedadeliv = new String[] {"1","2","9"};
             for (int i = 0; i < rdogrpmedadeliv.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpmedadeliv.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpmedadeliv[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    seclblsecII9.setVisibility(View.GONE);
                    linelblsecII9.setVisibility(View.GONE);
                    secuteroroute1.setVisibility(View.GONE);
                    lineuteroroute1.setVisibility(View.GONE);
                    chkuteroroute1.setChecked(false);
                    secuteroroute2.setVisibility(View.GONE);
                    lineuteroroute2.setVisibility(View.GONE);
                    chkuteroroute2.setChecked(false);
                    secuteroroute3.setVisibility(View.GONE);
                    lineuteroroute3.setVisibility(View.GONE);
                    chkuteroroute3.setChecked(false);
                    secuteroroute4.setVisibility(View.GONE);
                    lineuteroroute4.setVisibility(View.GONE);
                    chkuteroroute4.setChecked(false);
                    secuteroroute5.setVisibility(View.GONE);
                    lineuteroroute5.setVisibility(View.GONE);
                    chkuteroroute5.setChecked(false);
                    secuterotime.setVisibility(View.GONE);
                    lineuterotime.setVisibility(View.GONE);
                    spnuterotime.setSelection(0);
                    secuterotold.setVisibility(View.GONE);
                    lineuterotold.setVisibility(View.GONE);
                    rdogrputerotold.clearCheck();
                    secuteroknow.setVisibility(View.GONE);
                    lineuteroknow.setVisibility(View.GONE);
                    rdogrputeroknow.clearCheck();
                    seclblsecII16.setVisibility(View.GONE);
                    linelblsecII16.setVisibility(View.GONE);
                    secuteronameA.setVisibility(View.GONE);
                    lineuteronameA.setVisibility(View.GONE);
                    chkuteronameA.setChecked(false);
                    secuteronameB.setVisibility(View.GONE);
                    lineuteronameB.setVisibility(View.GONE);
                    chkuteronameB.setChecked(false);
                    secuteronameC.setVisibility(View.GONE);
                    lineuteronameC.setVisibility(View.GONE);
                    chkuteronameC.setChecked(false);
                    secuteronameD.setVisibility(View.GONE);
                    lineuteronameD.setVisibility(View.GONE);
                    chkuteronameD.setChecked(false);
                    secuteronameDOth.setVisibility(View.GONE);
                    lineuteronameDOth.setVisibility(View.GONE);
                    txtuteronameDOth.setText("");
                    secuteronameE.setVisibility(View.GONE);
                    lineuteronameE.setVisibility(View.GONE);
                    chkuteronameE.setChecked(false);
                    sectolduteroreas.setVisibility(View.GONE);
                    linetolduteroreas.setVisibility(View.GONE);
                    rdogrptolduteroreas.clearCheck();
                    seclblsecII17.setVisibility(View.GONE);
                    linelblsecII17.setVisibility(View.GONE);
                    secuteroreasA.setVisibility(View.GONE);
                    lineuteroreasA.setVisibility(View.GONE);
                    chkuteroreasA.setChecked(false);
                    secuteroreasB.setVisibility(View.GONE);
                    lineuteroreasB.setVisibility(View.GONE);
                    chkuteroreasB.setChecked(false);
                    secuteroreasOth.setVisibility(View.GONE);
                    lineuteroreasOth.setVisibility(View.GONE);
                    txtuteroreasOth.setText("");
                    secuteroreasC.setVisibility(View.GONE);
                    lineuteroreasC.setVisibility(View.GONE);
                    chkuteroreasC.setChecked(false);
                    //seclblsecII3.setVisibility(View.GONE);
                    linelblsecII3.setVisibility(View.GONE);
             }
             else if(rbData.equalsIgnoreCase("9"))
             {
                    seclblsecII9.setVisibility(View.GONE);
                    linelblsecII9.setVisibility(View.GONE);
                    secuteroroute1.setVisibility(View.GONE);
                    lineuteroroute1.setVisibility(View.GONE);
                    chkuteroroute1.setChecked(false);
                    secuteroroute2.setVisibility(View.GONE);
                    lineuteroroute2.setVisibility(View.GONE);
                    chkuteroroute2.setChecked(false);
                    secuteroroute3.setVisibility(View.GONE);
                    lineuteroroute3.setVisibility(View.GONE);
                    chkuteroroute3.setChecked(false);
                    secuteroroute4.setVisibility(View.GONE);
                    lineuteroroute4.setVisibility(View.GONE);
                    chkuteroroute4.setChecked(false);
                    secuteroroute5.setVisibility(View.GONE);
                    lineuteroroute5.setVisibility(View.GONE);
                    chkuteroroute5.setChecked(false);
                    secuterotime.setVisibility(View.GONE);
                    lineuterotime.setVisibility(View.GONE);
                    spnuterotime.setSelection(0);
                    secuterotold.setVisibility(View.GONE);
                    lineuterotold.setVisibility(View.GONE);
                    rdogrputerotold.clearCheck();
                    secuteroknow.setVisibility(View.GONE);
                    lineuteroknow.setVisibility(View.GONE);
                    rdogrputeroknow.clearCheck();
                    seclblsecII16.setVisibility(View.GONE);
                    linelblsecII16.setVisibility(View.GONE);
                    secuteronameA.setVisibility(View.GONE);
                    lineuteronameA.setVisibility(View.GONE);
                    chkuteronameA.setChecked(false);
                    secuteronameB.setVisibility(View.GONE);
                    lineuteronameB.setVisibility(View.GONE);
                    chkuteronameB.setChecked(false);
                    secuteronameC.setVisibility(View.GONE);
                    lineuteronameC.setVisibility(View.GONE);
                    chkuteronameC.setChecked(false);
                    secuteronameD.setVisibility(View.GONE);
                    lineuteronameD.setVisibility(View.GONE);
                    chkuteronameD.setChecked(false);
                    secuteronameDOth.setVisibility(View.GONE);
                    lineuteronameDOth.setVisibility(View.GONE);
                    txtuteronameDOth.setText("");
                    secuteronameE.setVisibility(View.GONE);
                    lineuteronameE.setVisibility(View.GONE);
                    chkuteronameE.setChecked(false);
                    sectolduteroreas.setVisibility(View.GONE);
                    linetolduteroreas.setVisibility(View.GONE);
                    rdogrptolduteroreas.clearCheck();
                    seclblsecII17.setVisibility(View.GONE);
                    linelblsecII17.setVisibility(View.GONE);
                    secuteroreasA.setVisibility(View.GONE);
                    lineuteroreasA.setVisibility(View.GONE);
                    chkuteroreasA.setChecked(false);
                    secuteroreasB.setVisibility(View.GONE);
                    lineuteroreasB.setVisibility(View.GONE);
                    chkuteroreasB.setChecked(false);
                    secuteroreasOth.setVisibility(View.GONE);
                    lineuteroreasOth.setVisibility(View.GONE);
                    txtuteroreasOth.setText("");
                    secuteroreasC.setVisibility(View.GONE);
                    lineuteroreasC.setVisibility(View.GONE);
                    chkuteroreasC.setChecked(false);
                    //seclblsecII3.setVisibility(View.GONE);
                    linelblsecII3.setVisibility(View.GONE);
             }
             else
             {
                    seclblsecII9.setVisibility(View.VISIBLE);
                    linelblsecII9.setVisibility(View.VISIBLE);
                    secuteroroute1.setVisibility(View.VISIBLE);
                    lineuteroroute1.setVisibility(View.VISIBLE);
                    secuteroroute2.setVisibility(View.VISIBLE);
                    lineuteroroute2.setVisibility(View.VISIBLE);
                    secuteroroute3.setVisibility(View.VISIBLE);
                    lineuteroroute3.setVisibility(View.VISIBLE);
                    secuteroroute4.setVisibility(View.VISIBLE);
                    lineuteroroute4.setVisibility(View.VISIBLE);
                    secuteroroute5.setVisibility(View.VISIBLE);
                    lineuteroroute5.setVisibility(View.VISIBLE);
                    secuterotime.setVisibility(View.VISIBLE);
                    lineuterotime.setVisibility(View.VISIBLE);
                    secuterotold.setVisibility(View.VISIBLE);
                    lineuterotold.setVisibility(View.VISIBLE);
                    secuteroknow.setVisibility(View.VISIBLE);
                    lineuteroknow.setVisibility(View.VISIBLE);
                    seclblsecII16.setVisibility(View.VISIBLE);
                    linelblsecII16.setVisibility(View.VISIBLE);
                    secuteronameA.setVisibility(View.VISIBLE);
                    lineuteronameA.setVisibility(View.VISIBLE);
                    secuteronameB.setVisibility(View.VISIBLE);
                    lineuteronameB.setVisibility(View.VISIBLE);
                    secuteronameC.setVisibility(View.VISIBLE);
                    lineuteronameC.setVisibility(View.VISIBLE);
                    secuteronameD.setVisibility(View.VISIBLE);
                    lineuteronameD.setVisibility(View.VISIBLE);
                    secuteronameDOth.setVisibility(View.GONE);
                    lineuteronameDOth.setVisibility(View.GONE);
                    secuteronameE.setVisibility(View.VISIBLE);
                    lineuteronameE.setVisibility(View.VISIBLE);
                    sectolduteroreas.setVisibility(View.VISIBLE);
                    linetolduteroreas.setVisibility(View.VISIBLE);
                    seclblsecII17.setVisibility(View.VISIBLE);
                    linelblsecII17.setVisibility(View.VISIBLE);
                    secuteroreasA.setVisibility(View.VISIBLE);
                    lineuteroreasA.setVisibility(View.VISIBLE);
                    secuteroreasB.setVisibility(View.VISIBLE);
                    lineuteroreasB.setVisibility(View.VISIBLE);
                    secuteroreasC.setVisibility(View.VISIBLE);
                    lineuteroreasC.setVisibility(View.VISIBLE);
                    seclblsecII3.setVisibility(View.VISIBLE);
                    linelblsecII3.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         seclblsecII9=(LinearLayout)findViewById(R.id.seclblsecII9);
         linelblsecII9=(View)findViewById(R.id.linelblsecII9);
         secuteroroute1=(LinearLayout)findViewById(R.id.secuteroroute1);
         lineuteroroute1=(View)findViewById(R.id.lineuteroroute1);
         Vlbluteroroute1=(TextView) findViewById(R.id.Vlbluteroroute1);
         chkuteroroute1=(CheckBox) findViewById(R.id.chkuteroroute1);
         secuteroroute2=(LinearLayout)findViewById(R.id.secuteroroute2);
         lineuteroroute2=(View)findViewById(R.id.lineuteroroute2);
         Vlbluteroroute2=(TextView) findViewById(R.id.Vlbluteroroute2);
         chkuteroroute2=(CheckBox) findViewById(R.id.chkuteroroute2);
         secuteroroute3=(LinearLayout)findViewById(R.id.secuteroroute3);
         lineuteroroute3=(View)findViewById(R.id.lineuteroroute3);
         Vlbluteroroute3=(TextView) findViewById(R.id.Vlbluteroroute3);
         chkuteroroute3=(CheckBox) findViewById(R.id.chkuteroroute3);
         secuteroroute4=(LinearLayout)findViewById(R.id.secuteroroute4);
         lineuteroroute4=(View)findViewById(R.id.lineuteroroute4);
         Vlbluteroroute4=(TextView) findViewById(R.id.Vlbluteroroute4);
         chkuteroroute4=(CheckBox) findViewById(R.id.chkuteroroute4);
         secuteroroute5=(LinearLayout)findViewById(R.id.secuteroroute5);
         lineuteroroute5=(View)findViewById(R.id.lineuteroroute5);
         Vlbluteroroute5=(TextView) findViewById(R.id.Vlbluteroroute5);
         chkuteroroute5=(CheckBox) findViewById(R.id.chkuteroroute5);
         secuterotime=(LinearLayout)findViewById(R.id.secuterotime);
         lineuterotime=(View)findViewById(R.id.lineuterotime);
         Vlbluterotime=(TextView) findViewById(R.id.Vlbluterotime);
         spnuterotime=(Spinner) findViewById(R.id.spnuterotime);
         List<String> listuterotime = new ArrayList<String>();
         
         listuterotime.add("");
         if(COUNTRYCODE.equals(ProjectSetting.BANGLADESH)){
             listuterotime.add("1-নাম এর ডেলিভারীর ১ মিনিটের মধ্যে");
             listuterotime.add("2-নাম এর ডেলিভারীর ১-৩ মিনিটের মধ্যে");
             listuterotime.add("3-নাম এর ডেলিভারীর ৩ মিনিটের অধিক সময়ের পরে এবং গর্ভফুল ডেলিভারীর আগে");
             listuterotime.add("4-নাম এর ডেলিভারীর ৩ মিনিটের অধিক সময়ের পরে এবং গর্ভফুল ডেলিভারীর পরে");
             listuterotime.add("9-জানিনা/মনে নাই");
         }else if(COUNTRYCODE.equals(ProjectSetting.NEPAL)){
             listuterotime.add("1-बच्चा जन्मिएको १ मिनेट भित्र");
             listuterotime.add("2-बच्चा जन्मिएको १-३ मिनेट भित्र");
             listuterotime.add("3-बच्चा जन्मिएको ३ मिनेट भन्दा बढी र साल निस्कनु अघि");
             listuterotime.add("4-बच्चा जन्मिएको ३ मिनेट भन्दा बढी र साल निस्किए पछि");
             listuterotime.add("9-थाहा छैन/ यादछैन");
         }else if(COUNTRYCODE.equals(ProjectSetting.TANZANIA)){
             listuterotime.add("1-Ndani ya dakika moja ya kujufingua mtoto");
             listuterotime.add("2-Ndani ya dakika 1 hadi 3 za kujifungua mtoto");
             listuterotime.add("3-Zaidi ya dakika 3 za kujifungua mtoto KABLA ya kutoka kwa kondo la nyuma");
             listuterotime.add("4-Zaidi ya dakika 3 za kujifungua mtoto BAADA ya kutoka kwa kondo la nyuma");
             listuterotime.add("9-Sijui/Sikumbuki");
         }else {
             listuterotime.add("1-Within 1 minute of delivery of the baby");
             listuterotime.add("2-Within 1-3 minutes of delivery of the baby");
             listuterotime.add("3-More than 3 minutes of delivery of the baby and BEFORE delivery of the placenta");
             listuterotime.add("4-More than 3 minutes of delivery of the baby and AFTER delivery of the placenta");
             listuterotime.add("9-Don’t know/don’t remember");
         }
         ArrayAdapter<String> adptruterotime= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listuterotime);
         spnuterotime.setAdapter(adptruterotime);

         secuterotold=(LinearLayout)findViewById(R.id.secuterotold);
         lineuterotold=(View)findViewById(R.id.lineuterotold);
         Vlbluterotold = (TextView) findViewById(R.id.Vlbluterotold);
         rdogrputerotold = (RadioGroup) findViewById(R.id.rdogrputerotold);
         
         rdouterotold1 = (RadioButton) findViewById(R.id.rdouterotold1);
         rdouterotold2 = (RadioButton) findViewById(R.id.rdouterotold2);
         rdouterotold3 = (RadioButton) findViewById(R.id.rdouterotold3);
         secuteroknow=(LinearLayout)findViewById(R.id.secuteroknow);
         lineuteroknow=(View)findViewById(R.id.lineuteroknow);
         Vlbluteroknow = (TextView) findViewById(R.id.Vlbluteroknow);
         rdogrputeroknow = (RadioGroup) findViewById(R.id.rdogrputeroknow);
         
         rdouteroknow1 = (RadioButton) findViewById(R.id.rdouteroknow1);
         rdouteroknow2 = (RadioButton) findViewById(R.id.rdouteroknow2);
         rdouteroknow3 = (RadioButton) findViewById(R.id.rdouteroknow3);
         rdogrputeroknow.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrputeroknow = new String[] {"1","2","9"};
             for (int i = 0; i < rdogrputeroknow.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrputeroknow.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrputeroknow[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    seclblsecII16.setVisibility(View.GONE);
                    linelblsecII16.setVisibility(View.GONE);
                    secuteronameA.setVisibility(View.GONE);
                    lineuteronameA.setVisibility(View.GONE);
                    chkuteronameA.setChecked(false);
                    secuteronameB.setVisibility(View.GONE);
                    lineuteronameB.setVisibility(View.GONE);
                    chkuteronameB.setChecked(false);
                    secuteronameC.setVisibility(View.GONE);
                    lineuteronameC.setVisibility(View.GONE);
                    chkuteronameC.setChecked(false);
                    secuteronameD.setVisibility(View.GONE);
                    lineuteronameD.setVisibility(View.GONE);
                    chkuteronameD.setChecked(false);
                    secuteronameDOth.setVisibility(View.GONE);
                    lineuteronameDOth.setVisibility(View.GONE);
                    txtuteronameDOth.setText("");
                    secuteronameE.setVisibility(View.GONE);
                    lineuteronameE.setVisibility(View.GONE);
                    chkuteronameE.setChecked(false);
             }
             else if(rbData.equalsIgnoreCase("9"))
             {
                    seclblsecII16.setVisibility(View.GONE);
                    linelblsecII16.setVisibility(View.GONE);
                    secuteronameA.setVisibility(View.GONE);
                    lineuteronameA.setVisibility(View.GONE);
                    chkuteronameA.setChecked(false);
                    secuteronameB.setVisibility(View.GONE);
                    lineuteronameB.setVisibility(View.GONE);
                    chkuteronameB.setChecked(false);
                    secuteronameC.setVisibility(View.GONE);
                    lineuteronameC.setVisibility(View.GONE);
                    chkuteronameC.setChecked(false);
                    secuteronameD.setVisibility(View.GONE);
                    lineuteronameD.setVisibility(View.GONE);
                    chkuteronameD.setChecked(false);
                    secuteronameDOth.setVisibility(View.GONE);
                    lineuteronameDOth.setVisibility(View.GONE);
                    txtuteronameDOth.setText("");
                    secuteronameE.setVisibility(View.GONE);
                    lineuteronameE.setVisibility(View.GONE);
                    chkuteronameE.setChecked(false);
             }
             else
             {
                    seclblsecII16.setVisibility(View.VISIBLE);
                    linelblsecII16.setVisibility(View.VISIBLE);
                    secuteronameA.setVisibility(View.VISIBLE);
                    lineuteronameA.setVisibility(View.VISIBLE);
                    secuteronameB.setVisibility(View.VISIBLE);
                    lineuteronameB.setVisibility(View.VISIBLE);
                    secuteronameC.setVisibility(View.VISIBLE);
                    lineuteronameC.setVisibility(View.VISIBLE);
                    secuteronameD.setVisibility(View.VISIBLE);
                    lineuteronameD.setVisibility(View.VISIBLE);
                    secuteronameE.setVisibility(View.VISIBLE);
                    lineuteronameE.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         seclblsecII16=(LinearLayout)findViewById(R.id.seclblsecII16);
         linelblsecII16=(View)findViewById(R.id.linelblsecII16);
         secuteronameA=(LinearLayout)findViewById(R.id.secuteronameA);
         lineuteronameA=(View)findViewById(R.id.lineuteronameA);
         VlbluteronameA=(TextView) findViewById(R.id.VlbluteronameA);
         chkuteronameA=(CheckBox) findViewById(R.id.chkuteronameA);
         secuteronameB=(LinearLayout)findViewById(R.id.secuteronameB);
         lineuteronameB=(View)findViewById(R.id.lineuteronameB);
         VlbluteronameB=(TextView) findViewById(R.id.VlbluteronameB);
         chkuteronameB=(CheckBox) findViewById(R.id.chkuteronameB);
         secuteronameC=(LinearLayout)findViewById(R.id.secuteronameC);
         lineuteronameC=(View)findViewById(R.id.lineuteronameC);
         VlbluteronameC=(TextView) findViewById(R.id.VlbluteronameC);
         chkuteronameC=(CheckBox) findViewById(R.id.chkuteronameC);
         secuteronameD=(LinearLayout)findViewById(R.id.secuteronameD);
         lineuteronameD=(View)findViewById(R.id.lineuteronameD);
         VlbluteronameD=(TextView) findViewById(R.id.VlbluteronameD);
         chkuteronameD=(CheckBox) findViewById(R.id.chkuteronameD);
         secuteronameE=(LinearLayout)findViewById(R.id.secuteronameE);
         lineuteronameE=(View)findViewById(R.id.lineuteronameE);
         VlbluteronameE=(TextView) findViewById(R.id.VlbluteronameE);
         chkuteronameE=(CheckBox) findViewById(R.id.chkuteronameE);

         chkuteronameA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if (isChecked) {
                     chkuteronameE.setChecked(false);
                 }
             }
         });
         chkuteronameB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if (isChecked) {
                     chkuteronameE.setChecked(false);
                 }
             }
         });
         chkuteronameC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if (isChecked) {
                     chkuteronameE.setChecked(false);
                 }
             }
         });
         chkuteronameD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if (!isChecked) {
                     secuteronameDOth.setVisibility(View.GONE);
                     lineuteronameDOth.setVisibility(View.GONE);
                     txtuteronameDOth.setText("");
                 }
                 else
                 {
                     secuteronameDOth.setVisibility(View.VISIBLE);
                     lineuteronameDOth.setVisibility(View.VISIBLE);
                     chkuteronameE.setChecked(false);
                 }
             }
         });
         chkuteronameE.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if (isChecked) {
                     chkuteronameA.setChecked(false);
                     chkuteronameB.setChecked(false);
                     chkuteronameC.setChecked(false);
                     chkuteronameD.setChecked(false);
                 }
             }
         });

         secuteronameDOth=(LinearLayout)findViewById(R.id.secuteronameDOth);
         lineuteronameDOth=(View)findViewById(R.id.lineuteronameDOth);
         VlbluteronameDOth=(TextView) findViewById(R.id.VlbluteronameDOth);
         txtuteronameDOth=(EditText) findViewById(R.id.txtuteronameDOth);

         sectolduteroreas=(LinearLayout)findViewById(R.id.sectolduteroreas);
         linetolduteroreas=(View)findViewById(R.id.linetolduteroreas);
         Vlbltolduteroreas = (TextView) findViewById(R.id.Vlbltolduteroreas);
         rdogrptolduteroreas = (RadioGroup) findViewById(R.id.rdogrptolduteroreas);
         
         rdotolduteroreas1 = (RadioButton) findViewById(R.id.rdotolduteroreas1);
         rdotolduteroreas2 = (RadioButton) findViewById(R.id.rdotolduteroreas2);
         rdotolduteroreas3 = (RadioButton) findViewById(R.id.rdotolduteroreas3);
         rdogrptolduteroreas.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrptolduteroreas = new String[] {"1","2","9"};
             for (int i = 0; i < rdogrptolduteroreas.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrptolduteroreas.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrptolduteroreas[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    seclblsecII17.setVisibility(View.GONE);
                    linelblsecII17.setVisibility(View.GONE);
                    secuteroreasA.setVisibility(View.GONE);
                    lineuteroreasA.setVisibility(View.GONE);
                    chkuteroreasA.setChecked(false);
                    secuteroreasB.setVisibility(View.GONE);
                    lineuteroreasB.setVisibility(View.GONE);
                    chkuteroreasB.setChecked(false);
                    secuteroreasOth.setVisibility(View.GONE);
                    lineuteroreasOth.setVisibility(View.GONE);
                    txtuteroreasOth.setText("");
                    secuteroreasC.setVisibility(View.GONE);
                    lineuteroreasC.setVisibility(View.GONE);
                    chkuteroreasC.setChecked(false);
                    //seclblsecII3.setVisibility(View.GONE);
                    linelblsecII3.setVisibility(View.GONE);
             }
             else if(rbData.equalsIgnoreCase("9"))
             {
                    seclblsecII17.setVisibility(View.GONE);
                    linelblsecII17.setVisibility(View.GONE);
                    secuteroreasA.setVisibility(View.GONE);
                    lineuteroreasA.setVisibility(View.GONE);
                    chkuteroreasA.setChecked(false);
                    secuteroreasB.setVisibility(View.GONE);
                    lineuteroreasB.setVisibility(View.GONE);
                    chkuteroreasB.setChecked(false);
                    secuteroreasOth.setVisibility(View.GONE);
                    lineuteroreasOth.setVisibility(View.GONE);
                    txtuteroreasOth.setText("");
                    secuteroreasC.setVisibility(View.GONE);
                    lineuteroreasC.setVisibility(View.GONE);
                    chkuteroreasC.setChecked(false);
                    //seclblsecII3.setVisibility(View.GONE);
                    linelblsecII3.setVisibility(View.GONE);
             }
             else
             {
                    seclblsecII17.setVisibility(View.VISIBLE);
                    linelblsecII17.setVisibility(View.VISIBLE);
                    secuteroreasA.setVisibility(View.VISIBLE);
                    lineuteroreasA.setVisibility(View.VISIBLE);
                    secuteroreasB.setVisibility(View.VISIBLE);
                    lineuteroreasB.setVisibility(View.VISIBLE);
                    secuteroreasC.setVisibility(View.VISIBLE);
                    lineuteroreasC.setVisibility(View.VISIBLE);
                    seclblsecII3.setVisibility(View.VISIBLE);
                    linelblsecII3.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         seclblsecII17=(LinearLayout)findViewById(R.id.seclblsecII17);
         linelblsecII17=(View)findViewById(R.id.linelblsecII17);
         secuteroreasA=(LinearLayout)findViewById(R.id.secuteroreasA);
         lineuteroreasA=(View)findViewById(R.id.lineuteroreasA);
         VlbluteroreasA=(TextView) findViewById(R.id.VlbluteroreasA);
         chkuteroreasA=(CheckBox) findViewById(R.id.chkuteroreasA);
         secuteroreasB=(LinearLayout)findViewById(R.id.secuteroreasB);
         lineuteroreasB=(View)findViewById(R.id.lineuteroreasB);
         VlbluteroreasB=(TextView) findViewById(R.id.VlbluteroreasB);
         chkuteroreasB=(CheckBox) findViewById(R.id.chkuteroreasB);

         secuteroreasOth=(LinearLayout)findViewById(R.id.secuteroreasOth);
         lineuteroreasOth=(View)findViewById(R.id.lineuteroreasOth);
         VlbluteroreasOth=(TextView) findViewById(R.id.VlbluteroreasOth);
         txtuteroreasOth=(EditText) findViewById(R.id.txtuteroreasOth);
         secuteroreasC=(LinearLayout)findViewById(R.id.secuteroreasC);
         lineuteroreasC=(View)findViewById(R.id.lineuteroreasC);
         VlbluteroreasC=(TextView) findViewById(R.id.VlbluteroreasC);
         chkuteroreasC=(CheckBox) findViewById(R.id.chkuteroreasC);

         chkuteroreasA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if (isChecked) {
                     chkuteroreasC.setChecked(false);
                 }
             }
         });
         chkuteroreasB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if (!isChecked) {
                     secuteroreasOth.setVisibility(View.GONE);
                     lineuteroreasOth.setVisibility(View.GONE);
                     txtuteroreasOth.setText("");
                 }
                 else
                 {
                     secuteroreasOth.setVisibility(View.VISIBLE);
                     lineuteroreasOth.setVisibility(View.VISIBLE);
                     chkuteroreasC.setChecked(false);
                 }
             }
         });
         chkuteroreasC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if (isChecked) {
                     chkuteroreasA.setChecked(false);
                     chkuteroreasB.setChecked(false);
                 }
             }
         });
         seclblsecII3=(LinearLayout)findViewById(R.id.seclblsecII3);
         linelblsecII3=(View)findViewById(R.id.linelblsecII3);
         secbdried=(LinearLayout)findViewById(R.id.secbdried);
         linebdried=(View)findViewById(R.id.linebdried);
         Vlblbdried = (TextView) findViewById(R.id.Vlblbdried);
         rdogrpbdried = (RadioGroup) findViewById(R.id.rdogrpbdried);
         
         rdobdried1 = (RadioButton) findViewById(R.id.rdobdried1);
         rdobdried2 = (RadioButton) findViewById(R.id.rdobdried2);
         rdobdried3 = (RadioButton) findViewById(R.id.rdobdried3);
         secbnakchest=(LinearLayout)findViewById(R.id.secbnakchest);
         linebnakchest=(View)findViewById(R.id.linebnakchest);
         Vlblbnakchest = (TextView) findViewById(R.id.Vlblbnakchest);
         rdogrpbnakchest = (RadioGroup) findViewById(R.id.rdogrpbnakchest);
         
         rdobnakchest1 = (RadioButton) findViewById(R.id.rdobnakchest1);
         rdobnakchest2 = (RadioButton) findViewById(R.id.rdobnakchest2);
         rdobnakchest3 = (RadioButton) findViewById(R.id.rdobnakchest3);
         rdogrpbnakchest.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpbnakchest = new String[] {"1","2","9"};
             for (int i = 0; i < rdogrpbnakchest.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpbnakchest.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpbnakchest[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secbchesttime.setVisibility(View.GONE);
                    linebchesttime.setVisibility(View.GONE);
                    rdogrpbchesttime.clearCheck();
                    secbchesttimeM.setVisibility(View.GONE);
                    linebchesttimeM.setVisibility(View.GONE);
                    txtbchesttimeM.setText("");
             }
             else if(rbData.equalsIgnoreCase("9"))
             {
                    secbchesttime.setVisibility(View.GONE);
                    linebchesttime.setVisibility(View.GONE);
                    rdogrpbchesttime.clearCheck();
                    secbchesttimeM.setVisibility(View.GONE);
                    linebchesttimeM.setVisibility(View.GONE);
                    txtbchesttimeM.setText("");
             }
             else
             {
                    secbchesttime.setVisibility(View.VISIBLE);
                    linebchesttime.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secbchesttime=(LinearLayout)findViewById(R.id.secbchesttime);
         linebchesttime=(View)findViewById(R.id.linebchesttime);
         Vlblbchesttime = (TextView) findViewById(R.id.Vlblbchesttime);
         rdogrpbchesttime = (RadioGroup) findViewById(R.id.rdogrpbchesttime);
         
         rdobchesttime1 = (RadioButton) findViewById(R.id.rdobchesttime1);
         rdobchesttime2 = (RadioButton) findViewById(R.id.rdobchesttime2);
         rdobchesttime3 = (RadioButton) findViewById(R.id.rdobchesttime3);
         rdogrpbchesttime.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpbchesttime = new String[] {"1","2","9"};
             for (int i = 0; i < rdogrpbchesttime.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpbchesttime.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpbchesttime[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                    secbchesttimeM.setVisibility(View.GONE);
                    linebchesttimeM.setVisibility(View.GONE);
                    txtbchesttimeM.setText("");
                    secbplaced.setVisibility(View.GONE);
                    linebplaced.setVisibility(View.GONE);
                    spnbplaced.setSelection(0);
             }
             else if(rbData.equalsIgnoreCase("2"))
             {
                    secbchesttimeM.setVisibility(View.VISIBLE);
                    linebchesttimeM.setVisibility(View.VISIBLE);
                    txtbchesttimeM.setText("");
                    secbplaced.setVisibility(View.GONE);
                    linebplaced.setVisibility(View.GONE);
                    spnbplaced.setSelection(0);
             }
             else if(rbData.equalsIgnoreCase("9"))
             {
                    secbchesttimeM.setVisibility(View.GONE);
                    linebchesttimeM.setVisibility(View.GONE);
                    txtbchesttimeM.setText("");
                    secbplaced.setVisibility(View.GONE);
                    linebplaced.setVisibility(View.GONE);
                    spnbplaced.setSelection(0);
             }
             else
             {
                    secbchesttimeM.setVisibility(View.VISIBLE);
                    linebchesttimeM.setVisibility(View.VISIBLE);
                    secbplaced.setVisibility(View.VISIBLE);
                    linebplaced.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secbchesttimeM=(LinearLayout)findViewById(R.id.secbchesttimeM);
         linebchesttimeM=(View)findViewById(R.id.linebchesttimeM);
         VlblbchesttimeM=(TextView) findViewById(R.id.VlblbchesttimeM);
         txtbchesttimeM=(EditText) findViewById(R.id.txtbchesttimeM);
         secbplaced=(LinearLayout)findViewById(R.id.secbplaced);
         linebplaced=(View)findViewById(R.id.linebplaced);
         Vlblbplaced=(TextView) findViewById(R.id.Vlblbplaced);
         spnbplaced=(Spinner) findViewById(R.id.spnbplaced);
         List<String> listbplaced = new ArrayList<String>();
         
         listbplaced.add("");
         if(COUNTRYCODE.equals(ProjectSetting.BANGLADESH)){
             listbplaced.add("1-মায়ের পাশে কাপড় দিয়ে মুড়ানো অবস্থায়");
             listbplaced.add("2-অন্য জায়গায় কাপড় দিয়ে মুড়ানো অবস্থায়");
             listbplaced.add("3-অন্য জায়গায় অনাবৃত অবস্থায়");
             listbplaced.add("9-জানিনা/মনে নাই");
         }else if(COUNTRYCODE.equals(ProjectSetting.NEPAL)){
             listbplaced.add("1-आमा सँगै कपडाले बेरेर");
             listbplaced.add("2-कपडाले बेरेर कोक्रोमा");
             listbplaced.add("3-कपडाले नबेरिकन स्केलमा");
             listbplaced.add("9-थाहा छैन/ याद छैन");
         }else if(COUNTRYCODE.equals(ProjectSetting.TANZANIA)){
             listbplaced.add("1-Alivilingishwa nguo pamoja na mama yake");
             listbplaced.add("2-Alivilingishwa nguo na kuwekwa sehemu nyingine kama vile kwenye kitanda cha mtoto");
             listbplaced.add("3-Hakuvilingishwa na nguo, kwa mfano kwenye mzani");
             listbplaced.add("9-Sijui/Sikumbuki");
         }else {
             listbplaced.add("1-Wrapped with mother");
             listbplaced.add("2-Wrapped and placed separate eg cot");
             listbplaced.add("3-Unwrapped eg on scales");
             listbplaced.add("9-Don’t know/don’t remember");
         }
         ArrayAdapter<String> adptrbplaced= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listbplaced);
         spnbplaced.setAdapter(adptrbplaced);

         secbbathtime=(LinearLayout)findViewById(R.id.secbbathtime);
         linebbathtime=(View)findViewById(R.id.linebbathtime);
         Vlblbbathtime = (TextView) findViewById(R.id.Vlblbbathtime);
         rdogrpbbathtime = (RadioGroup) findViewById(R.id.rdogrpbbathtime);
         
         rdobbathtime1 = (RadioButton) findViewById(R.id.rdobbathtime1);
         rdobbathtime2 = (RadioButton) findViewById(R.id.rdobbathtime2);
         rdobbathtime3 = (RadioButton) findViewById(R.id.rdobbathtime3);
         rdobbathtime4 = (RadioButton) findViewById(R.id.rdobbathtime4);
         rdobbathtime5 = (RadioButton) findViewById(R.id.rdobbathtime5);
         rdogrpbbathtime.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpbbathtime = new String[] {"1","2","3","9","4"};
             for (int i = 0; i < rdogrpbbathtime.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpbbathtime.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpbbathtime[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                  secbbathtimeDur.setVisibility(View.GONE);
                    linebbathtimeDur.setVisibility(View.GONE);
                    txtbbathtimeDur.setText("");
                    seclblsecII10.setVisibility(View.GONE);
                    linelblsecII10.setVisibility(View.GONE);
             }
             else if(rbData.equalsIgnoreCase("9") | rbData.equalsIgnoreCase("4"))
             {
                  secbbathtimeDur.setVisibility(View.GONE);
                    linebbathtimeDur.setVisibility(View.GONE);
                    txtbbathtimeDur.setText("");
                    seclblsecII10.setVisibility(View.GONE);
                    linelblsecII10.setVisibility(View.GONE);
             }
             else
             {
                    secbbathtimeDur.setVisibility(View.VISIBLE);
                    linebbathtimeDur.setVisibility(View.VISIBLE);
                    seclblsecII10.setVisibility(View.VISIBLE);
                    linelblsecII10.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secbbathtimeDur=(LinearLayout)findViewById(R.id.secbbathtimeDur);
         linebbathtimeDur=(View)findViewById(R.id.linebbathtimeDur);
         VlblbbathtimeDur=(TextView) findViewById(R.id.VlblbbathtimeDur);
         txtbbathtimeDur=(EditText) findViewById(R.id.txtbbathtimeDur);
         seclblsecII10=(LinearLayout)findViewById(R.id.seclblsecII10);
         linelblsecII10=(View)findViewById(R.id.linelblsecII10);
         secbbfd=(LinearLayout)findViewById(R.id.secbbfd);
         linebbfd=(View)findViewById(R.id.linebbfd);
         Vlblbbfd = (TextView) findViewById(R.id.Vlblbbfd);
         rdogrpbbfd = (RadioGroup) findViewById(R.id.rdogrpbbfd);
         
         rdobbfd1 = (RadioButton) findViewById(R.id.rdobbfd1);
         rdobbfd2 = (RadioButton) findViewById(R.id.rdobbfd2);
         rdobbfd3 = (RadioButton) findViewById(R.id.rdobbfd3);
         rdogrpbbfd.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpbbfd = new String[] {"1","2","9"};
             for (int i = 0; i < rdogrpbbfd.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpbbfd.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpbbfd[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secbfdtime.setVisibility(View.GONE);
                    linebfdtime.setVisibility(View.GONE);
                    spnbfdtime.setSelection(0);
                    secbfdtimeDur.setVisibility(View.GONE);
                    linebfdtimeDur.setVisibility(View.GONE);
                    txtbfdtimeDur.setText("");
                    seclblsecII11.setVisibility(View.GONE);
                    linelblsecII11.setVisibility(View.GONE);
                    secsupbfd.setVisibility(View.GONE);
                    linesupbfd.setVisibility(View.GONE);
                    rdogrpsupbfd.clearCheck();
             }
             else if(rbData.equalsIgnoreCase("9"))
             {
                    secbfdtime.setVisibility(View.GONE);
                    linebfdtime.setVisibility(View.GONE);
                    spnbfdtime.setSelection(0);
                    secbfdtimeDur.setVisibility(View.GONE);
                    linebfdtimeDur.setVisibility(View.GONE);
                    txtbfdtimeDur.setText("");
                    seclblsecII11.setVisibility(View.GONE);
                    linelblsecII11.setVisibility(View.GONE);
                    secsupbfd.setVisibility(View.GONE);
                    linesupbfd.setVisibility(View.GONE);
                    rdogrpsupbfd.clearCheck();
             }
             else
             {
                    secbfdtime.setVisibility(View.VISIBLE);
                    linebfdtime.setVisibility(View.VISIBLE);
                    secsupbfd.setVisibility(View.VISIBLE);
                    linesupbfd.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secbfdtime=(LinearLayout)findViewById(R.id.secbfdtime);
         linebfdtime=(View)findViewById(R.id.linebfdtime);
         Vlblbfdtime=(TextView) findViewById(R.id.Vlblbfdtime);
         spnbfdtime=(Spinner) findViewById(R.id.spnbfdtime);
         List<String> listbfdtime = new ArrayList<String>();
         
         listbfdtime.add("");
         if(COUNTRYCODE.equals(ProjectSetting.BANGLADESH)){
             listbfdtime.add("1-জন্মের পরপরই");
             listbfdtime.add("2-ঘণ্টা");
             listbfdtime.add("3-দিন");
             listbfdtime.add("9-জানিনা/মনে নাই");

         }else if(COUNTRYCODE.equals(ProjectSetting.NEPAL)){
             listbfdtime.add("1-जन्मिने बित्तिकै ");
             listbfdtime.add("2-घण्टा");
             listbfdtime.add("3-दिन");
             listbfdtime.add("9-थाहा छैन/ याद छैन");
         }else if(COUNTRYCODE.equals(ProjectSetting.TANZANIA)){
             listbfdtime.add("1-Mara tu");
             listbfdtime.add("2-Masaa");
             listbfdtime.add("3-Siku");
             listbfdtime.add("9-Sijui/Sikumbuki");
         }else {
             listbfdtime.add("1-Immediately");
             listbfdtime.add("2-Hours");
             listbfdtime.add("3-Days");
             listbfdtime.add("9-Don’t know/don’t remember");
         }
         ArrayAdapter<String> adptrbfdtime= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listbfdtime);
         spnbfdtime.setAdapter(adptrbfdtime);

         spnbfdtime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             if (spnbfdtime.getSelectedItem().toString().length() == 0) return;
             String spnData = Connection.SelectedSpinnerValue(spnbfdtime.getSelectedItem().toString(),"-");
                 if(spnData.equalsIgnoreCase("1"))
                 {
                    secbfdtimeDur.setVisibility(View.GONE);
                    linebfdtimeDur.setVisibility(View.GONE);
                    txtbfdtimeDur.setText("");
                    seclblsecII11.setVisibility(View.GONE);
                    linelblsecII11.setVisibility(View.GONE);
                 }
                 else if(spnData.equalsIgnoreCase("9"))
                 {
                    secbfdtimeDur.setVisibility(View.GONE);
                    linebfdtimeDur.setVisibility(View.GONE);
                    txtbfdtimeDur.setText("");
                    seclblsecII11.setVisibility(View.GONE);
                    linelblsecII11.setVisibility(View.GONE);
                 }
                 else
                 {
                    secbfdtimeDur.setVisibility(View.VISIBLE);
                    linebfdtimeDur.setVisibility(View.VISIBLE);
                    seclblsecII11.setVisibility(View.VISIBLE);
                    linelblsecII11.setVisibility(View.VISIBLE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secbfdtimeDur=(LinearLayout)findViewById(R.id.secbfdtimeDur);
         linebfdtimeDur=(View)findViewById(R.id.linebfdtimeDur);
         VlblbfdtimeDur=(TextView) findViewById(R.id.VlblbfdtimeDur);
         txtbfdtimeDur=(EditText) findViewById(R.id.txtbfdtimeDur);
         seclblsecII11=(LinearLayout)findViewById(R.id.seclblsecII11);
         linelblsecII11=(View)findViewById(R.id.linelblsecII11);
         secsupbfd=(LinearLayout)findViewById(R.id.secsupbfd);
         linesupbfd=(View)findViewById(R.id.linesupbfd);
         Vlblsupbfd = (TextView) findViewById(R.id.Vlblsupbfd);
         rdogrpsupbfd = (RadioGroup) findViewById(R.id.rdogrpsupbfd);
         
         rdosupbfd1 = (RadioButton) findViewById(R.id.rdosupbfd1);
         rdosupbfd2 = (RadioButton) findViewById(R.id.rdosupbfd2);
         rdosupbfd3 = (RadioButton) findViewById(R.id.rdosupbfd3);
         seclblsecII18=(LinearLayout)findViewById(R.id.seclblsecII18);
         linelblsecII18=(View)findViewById(R.id.linelblsecII18);
         secaltdrinkA=(LinearLayout)findViewById(R.id.secaltdrinkA);
         linealtdrinkA=(View)findViewById(R.id.linealtdrinkA);
         VlblaltdrinkA=(TextView) findViewById(R.id.VlblaltdrinkA);
         chkaltdrinkA=(CheckBox) findViewById(R.id.chkaltdrinkA);
         secaltdrinkB=(LinearLayout)findViewById(R.id.secaltdrinkB);
         linealtdrinkB=(View)findViewById(R.id.linealtdrinkB);
         VlblaltdrinkB=(TextView) findViewById(R.id.VlblaltdrinkB);
         chkaltdrinkB=(CheckBox) findViewById(R.id.chkaltdrinkB);
         secaltdrinkC=(LinearLayout)findViewById(R.id.secaltdrinkC);
         linealtdrinkC=(View)findViewById(R.id.linealtdrinkC);
         VlblaltdrinkC=(TextView) findViewById(R.id.VlblaltdrinkC);
         chkaltdrinkC=(CheckBox) findViewById(R.id.chkaltdrinkC);
         secaltdrinkD=(LinearLayout)findViewById(R.id.secaltdrinkD);
         linealtdrinkD=(View)findViewById(R.id.linealtdrinkD);
         VlblaltdrinkD=(TextView) findViewById(R.id.VlblaltdrinkD);
         chkaltdrinkD=(CheckBox) findViewById(R.id.chkaltdrinkD);

         secaltdrinkDOth=(LinearLayout)findViewById(R.id.secaltdrinkDOth);
         linealtdrinkDOth=(View)findViewById(R.id.linealtdrinkDOth);
         VlblaltdrinkDOth=(TextView) findViewById(R.id.VlblaltdrinkDOth);
         txtaltdrinkDOth=(EditText) findViewById(R.id.txtaltdrinkDOth);
         secaltdrinkE=(LinearLayout)findViewById(R.id.secaltdrinkE);
         linealtdrinkE=(View)findViewById(R.id.linealtdrinkE);
         VlblaltdrinkE=(TextView) findViewById(R.id.VlblaltdrinkE);
         chkaltdrinkE=(CheckBox) findViewById(R.id.chkaltdrinkE);
         secaltdrinkF=(LinearLayout)findViewById(R.id.secaltdrinkF);
         linealtdrinkF=(View)findViewById(R.id.linealtdrinkF);
         VlblaltdrinkF=(TextView) findViewById(R.id.VlblaltdrinkF);
         chkaltdrinkF=(CheckBox) findViewById(R.id.chkaltdrinkF);

         chkaltdrinkD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if (!isChecked) {
                     secaltdrinkDOth.setVisibility(View.GONE);
                     linealtdrinkDOth.setVisibility(View.GONE);
                     txtaltdrinkDOth.setText("");
                 }
                 else
                 {
                     secaltdrinkDOth.setVisibility(View.VISIBLE);
                     linealtdrinkDOth.setVisibility(View.VISIBLE);
                     chkaltdrinkF.setChecked(false);
                 }
             }
         });
         chkaltdrinkA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if (isChecked) {
                     chkaltdrinkF.setChecked(false);
                 }
             }
         });
         chkaltdrinkB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if (isChecked) {
                     chkaltdrinkF.setChecked(false);
                 }
             }
         });
         chkaltdrinkC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if (isChecked) {
                     chkaltdrinkF.setChecked(false);
                 }
             }
         });
         chkaltdrinkE.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if (isChecked) {
                     chkaltdrinkA.setChecked(false);
                     chkaltdrinkB.setChecked(false);
                     chkaltdrinkC.setChecked(false);
                     chkaltdrinkD.setChecked(false);
                     chkaltdrinkF.setChecked(false);
                 }
             }
         });
         chkaltdrinkF.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if (isChecked) {
                     chkaltdrinkA.setChecked(false);
                     chkaltdrinkB.setChecked(false);
                     chkaltdrinkC.setChecked(false);
                     chkaltdrinkD.setChecked(false);
                     chkaltdrinkE.setChecked(false);
                 }
             }
         });
         seclblsecII4=(LinearLayout)findViewById(R.id.seclblsecII4);
         linelblsecII4=(View)findViewById(R.id.linelblsecII4);
         secbcry=(LinearLayout)findViewById(R.id.secbcry);
         linebcry=(View)findViewById(R.id.linebcry);
         Vlblbcry = (TextView) findViewById(R.id.Vlblbcry);
         rdogrpbcry = (RadioGroup) findViewById(R.id.rdogrpbcry);
         
         rdobcry1 = (RadioButton) findViewById(R.id.rdobcry1);
         rdobcry2 = (RadioButton) findViewById(R.id.rdobcry2);
         rdobcry3 = (RadioButton) findViewById(R.id.rdobcry3);
         secbtroubbrth=(LinearLayout)findViewById(R.id.secbtroubbrth);
         linebtroubbrth=(View)findViewById(R.id.linebtroubbrth);
         Vlblbtroubbrth = (TextView) findViewById(R.id.Vlblbtroubbrth);
         rdogrpbtroubbrth = (RadioGroup) findViewById(R.id.rdogrpbtroubbrth);
         
         rdobtroubbrth1 = (RadioButton) findViewById(R.id.rdobtroubbrth1);
         rdobtroubbrth2 = (RadioButton) findViewById(R.id.rdobtroubbrth2);
         rdobtroubbrth3 = (RadioButton) findViewById(R.id.rdobtroubbrth3);
         rdogrpbtroubbrth.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpbtroubbrth = new String[] {"1","2","9"};
             for (int i = 0; i < rdogrpbtroubbrth.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpbtroubbrth.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpbtroubbrth[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    seclblsecII13.setVisibility(View.GONE);
                    linelblsecII13.setVisibility(View.GONE);
                    sechelpbbrthA.setVisibility(View.GONE);
                    linehelpbbrthA.setVisibility(View.GONE);
                    chkhelpbbrthA.setChecked(false);
                    sechelpbbrthB.setVisibility(View.GONE);
                    linehelpbbrthB.setVisibility(View.GONE);
                    chkhelpbbrthB.setChecked(false);
                    sechelpbbrthC.setVisibility(View.GONE);
                    linehelpbbrthC.setVisibility(View.GONE);
                    chkhelpbbrthC.setChecked(false);
                    sechelpbbrthD.setVisibility(View.GONE);
                    linehelpbbrthD.setVisibility(View.GONE);
                    chkhelpbbrthD.setChecked(false);
                    sechelpbbrthE.setVisibility(View.GONE);
                    linehelpbbrthE.setVisibility(View.GONE);
                    chkhelpbbrthE.setChecked(false);
                    secbstim.setVisibility(View.GONE);
                    linebstim.setVisibility(View.GONE);
                    rdogrpbstim.clearCheck();
                    secbplast.setVisibility(View.GONE);
                    linebplast.setVisibility(View.GONE);
                    rdogrpbplast.clearCheck();
                    secbresustmin.setVisibility(View.GONE);
                    linebresustmin.setVisibility(View.GONE);
                    rdogrpbresustmin.clearCheck();
                    secbresustminDur.setVisibility(View.GONE);
                    linebresustminDur.setVisibility(View.GONE);
                    txtbresustminDur.setText("");
                    secbsuc.setVisibility(View.GONE);
                    linebsuc.setVisibility(View.GONE);
                    rdogrpbsuc.clearCheck();
                    secoresusact.setVisibility(View.GONE);
                    lineoresusact.setVisibility(View.GONE);
                    rdogrporesusact.clearCheck();
                    secoresusactOth.setVisibility(View.GONE);
                    lineoresusactOth.setVisibility(View.GONE);
                    txtoresusactOth.setText("");
                    secbadmward.setVisibility(View.GONE);
                    linebadmward.setVisibility(View.GONE);
                    rdogrpbadmward.clearCheck();
                    sectoldresusexp.setVisibility(View.GONE);
                    linetoldresusexp.setVisibility(View.GONE);
                    //spntoldresusexp.setSelection(0);
                 rdogrptoldresusexp.clearCheck();
                    secresusexp.setVisibility(View.GONE);
                    lineresusexp.setVisibility(View.GONE);
                    txtresusexp.setText("");
                    secresusexpDK.setVisibility(View.GONE);
                    lineresusexpDK.setVisibility(View.GONE);
                    chkresusexpDK.setChecked(false);
                    //seclblsecII14.setVisibility(View.GONE);
                    linelblsecII14.setVisibility(View.GONE);
             }
             else if(rbData.equalsIgnoreCase("9"))
             {
                    seclblsecII13.setVisibility(View.GONE);
                    linelblsecII13.setVisibility(View.GONE);
                    sechelpbbrthA.setVisibility(View.GONE);
                    linehelpbbrthA.setVisibility(View.GONE);
                    chkhelpbbrthA.setChecked(false);
                    sechelpbbrthB.setVisibility(View.GONE);
                    linehelpbbrthB.setVisibility(View.GONE);
                    chkhelpbbrthB.setChecked(false);
                    sechelpbbrthC.setVisibility(View.GONE);
                    linehelpbbrthC.setVisibility(View.GONE);
                    chkhelpbbrthC.setChecked(false);
                    sechelpbbrthD.setVisibility(View.GONE);
                    linehelpbbrthD.setVisibility(View.GONE);
                    chkhelpbbrthD.setChecked(false);
                    sechelpbbrthE.setVisibility(View.GONE);
                    linehelpbbrthE.setVisibility(View.GONE);
                    chkhelpbbrthE.setChecked(false);
                    secbstim.setVisibility(View.GONE);
                    linebstim.setVisibility(View.GONE);
                    rdogrpbstim.clearCheck();
                    secbplast.setVisibility(View.GONE);
                    linebplast.setVisibility(View.GONE);
                    rdogrpbplast.clearCheck();
                    secbresustmin.setVisibility(View.GONE);
                    linebresustmin.setVisibility(View.GONE);
                    rdogrpbresustmin.clearCheck();
                    secbresustminDur.setVisibility(View.GONE);
                    linebresustminDur.setVisibility(View.GONE);
                    txtbresustminDur.setText("");
                    secbsuc.setVisibility(View.GONE);
                    linebsuc.setVisibility(View.GONE);
                    rdogrpbsuc.clearCheck();
                    secoresusact.setVisibility(View.GONE);
                    lineoresusact.setVisibility(View.GONE);
                    rdogrporesusact.clearCheck();
                    secoresusactOth.setVisibility(View.GONE);
                    lineoresusactOth.setVisibility(View.GONE);
                    txtoresusactOth.setText("");
                    secbadmward.setVisibility(View.GONE);
                    linebadmward.setVisibility(View.GONE);
                    rdogrpbadmward.clearCheck();
                    sectoldresusexp.setVisibility(View.GONE);
                    linetoldresusexp.setVisibility(View.GONE);
                    //spntoldresusexp.setSelection(0);
                 rdogrptoldresusexp.clearCheck();
                    secresusexp.setVisibility(View.GONE);
                    lineresusexp.setVisibility(View.GONE);
                    txtresusexp.setText("");
                    secresusexpDK.setVisibility(View.GONE);
                    lineresusexpDK.setVisibility(View.GONE);
                    chkresusexpDK.setChecked(false);
                    //seclblsecII14.setVisibility(View.GONE);
                    linelblsecII14.setVisibility(View.GONE);
             }
             else
             {
                    seclblsecII13.setVisibility(View.VISIBLE);
                    linelblsecII13.setVisibility(View.VISIBLE);
                    sechelpbbrthA.setVisibility(View.VISIBLE);
                    linehelpbbrthA.setVisibility(View.VISIBLE);
                    sechelpbbrthB.setVisibility(View.VISIBLE);
                    linehelpbbrthB.setVisibility(View.VISIBLE);
                    sechelpbbrthC.setVisibility(View.VISIBLE);
                    linehelpbbrthC.setVisibility(View.VISIBLE);
                    sechelpbbrthD.setVisibility(View.VISIBLE);
                    linehelpbbrthD.setVisibility(View.VISIBLE);
                    sechelpbbrthE.setVisibility(View.VISIBLE);
                    linehelpbbrthE.setVisibility(View.VISIBLE);
                    secbstim.setVisibility(View.VISIBLE);
                    linebstim.setVisibility(View.VISIBLE);
                    secbplast.setVisibility(View.VISIBLE);
                    linebplast.setVisibility(View.VISIBLE);
                    secbresustmin.setVisibility(View.VISIBLE);
                    linebresustmin.setVisibility(View.VISIBLE);
                    secbresustminDur.setVisibility(View.VISIBLE);
                    linebresustminDur.setVisibility(View.VISIBLE);
                    secbsuc.setVisibility(View.VISIBLE);
                    linebsuc.setVisibility(View.VISIBLE);
                    secoresusact.setVisibility(View.VISIBLE);
                    lineoresusact.setVisibility(View.VISIBLE);
                    secoresusactOth.setVisibility(View.GONE);
                    lineoresusactOth.setVisibility(View.GONE);
                    secbadmward.setVisibility(View.VISIBLE);
                    linebadmward.setVisibility(View.VISIBLE);
                    sectoldresusexp.setVisibility(View.VISIBLE);
                    linetoldresusexp.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         seclblsecII13=(LinearLayout)findViewById(R.id.seclblsecII13);
         linelblsecII13=(View)findViewById(R.id.linelblsecII13);
         sechelpbbrthA=(LinearLayout)findViewById(R.id.sechelpbbrthA);
         linehelpbbrthA=(View)findViewById(R.id.linehelpbbrthA);
         VlblhelpbbrthA=(TextView) findViewById(R.id.VlblhelpbbrthA);
         chkhelpbbrthA=(CheckBox) findViewById(R.id.chkhelpbbrthA);
         sechelpbbrthB=(LinearLayout)findViewById(R.id.sechelpbbrthB);
         linehelpbbrthB=(View)findViewById(R.id.linehelpbbrthB);
         VlblhelpbbrthB=(TextView) findViewById(R.id.VlblhelpbbrthB);
         chkhelpbbrthB=(CheckBox) findViewById(R.id.chkhelpbbrthB);
         sechelpbbrthC=(LinearLayout)findViewById(R.id.sechelpbbrthC);
         linehelpbbrthC=(View)findViewById(R.id.linehelpbbrthC);
         VlblhelpbbrthC=(TextView) findViewById(R.id.VlblhelpbbrthC);
         chkhelpbbrthC=(CheckBox) findViewById(R.id.chkhelpbbrthC);
         sechelpbbrthD=(LinearLayout)findViewById(R.id.sechelpbbrthD);
         linehelpbbrthD=(View)findViewById(R.id.linehelpbbrthD);
         VlblhelpbbrthD=(TextView) findViewById(R.id.VlblhelpbbrthD);
         chkhelpbbrthD=(CheckBox) findViewById(R.id.chkhelpbbrthD);
         sechelpbbrthE=(LinearLayout)findViewById(R.id.sechelpbbrthE);
         linehelpbbrthE=(View)findViewById(R.id.linehelpbbrthE);
         VlblhelpbbrthE=(TextView) findViewById(R.id.VlblhelpbbrthE);
         chkhelpbbrthE=(CheckBox) findViewById(R.id.chkhelpbbrthE);
         secbstim=(LinearLayout)findViewById(R.id.secbstim);
         linebstim=(View)findViewById(R.id.linebstim);
         Vlblbstim = (TextView) findViewById(R.id.Vlblbstim);
         rdogrpbstim = (RadioGroup) findViewById(R.id.rdogrpbstim);
         
         rdobstim1 = (RadioButton) findViewById(R.id.rdobstim1);
         rdobstim2 = (RadioButton) findViewById(R.id.rdobstim2);
         rdobstim3 = (RadioButton) findViewById(R.id.rdobstim3);
         secbplast=(LinearLayout)findViewById(R.id.secbplast);
         linebplast=(View)findViewById(R.id.linebplast);
         Vlblbplast = (TextView) findViewById(R.id.Vlblbplast);
         rdogrpbplast = (RadioGroup) findViewById(R.id.rdogrpbplast);
         
         rdobplast1 = (RadioButton) findViewById(R.id.rdobplast1);
         rdobplast2 = (RadioButton) findViewById(R.id.rdobplast2);
         rdobplast3 = (RadioButton) findViewById(R.id.rdobplast3);
         secbresustmin=(LinearLayout)findViewById(R.id.secbresustmin);
         linebresustmin=(View)findViewById(R.id.linebresustmin);
         Vlblbresustmin = (TextView) findViewById(R.id.Vlblbresustmin);
         rdogrpbresustmin = (RadioGroup) findViewById(R.id.rdogrpbresustmin);
         
         rdobresustmin1 = (RadioButton) findViewById(R.id.rdobresustmin1);
         rdobresustmin2 = (RadioButton) findViewById(R.id.rdobresustmin2);
         secbresustminDur=(LinearLayout)findViewById(R.id.secbresustminDur);
         linebresustminDur=(View)findViewById(R.id.linebresustminDur);
         VlblbresustminDur=(TextView) findViewById(R.id.VlblbresustminDur);
         txtbresustminDur=(EditText) findViewById(R.id.txtbresustminDur);
         secbsuc=(LinearLayout)findViewById(R.id.secbsuc);
         linebsuc=(View)findViewById(R.id.linebsuc);
         Vlblbsuc = (TextView) findViewById(R.id.Vlblbsuc);
         rdogrpbsuc = (RadioGroup) findViewById(R.id.rdogrpbsuc);
         
         rdobsuc1 = (RadioButton) findViewById(R.id.rdobsuc1);
         rdobsuc2 = (RadioButton) findViewById(R.id.rdobsuc2);
         rdobsuc3 = (RadioButton) findViewById(R.id.rdobsuc3);
         secoresusact=(LinearLayout)findViewById(R.id.secoresusact);
         lineoresusact=(View)findViewById(R.id.lineoresusact);
         Vlbloresusact = (TextView) findViewById(R.id.Vlbloresusact);
         rdogrporesusact = (RadioGroup) findViewById(R.id.rdogrporesusact);
         
         rdooresusact1 = (RadioButton) findViewById(R.id.rdooresusact1);
         rdooresusact2 = (RadioButton) findViewById(R.id.rdooresusact2);
         rdooresusact3 = (RadioButton) findViewById(R.id.rdooresusact3);
         rdogrporesusact.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrporesusact = new String[] {"1","2","9"};
             for (int i = 0; i < rdogrporesusact.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrporesusact.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrporesusact[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secoresusactOth.setVisibility(View.GONE);
                    lineoresusactOth.setVisibility(View.GONE);
                    txtoresusactOth.setText("");
             }
             else if(rbData.equalsIgnoreCase("9"))
             {
                    secoresusactOth.setVisibility(View.GONE);
                    lineoresusactOth.setVisibility(View.GONE);
                    txtoresusactOth.setText("");
             }
             else
             {
                    secoresusactOth.setVisibility(View.VISIBLE);
                    lineoresusactOth.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secoresusactOth=(LinearLayout)findViewById(R.id.secoresusactOth);
         lineoresusactOth=(View)findViewById(R.id.lineoresusactOth);
         VlbloresusactOth=(TextView) findViewById(R.id.VlbloresusactOth);
         txtoresusactOth=(EditText) findViewById(R.id.txtoresusactOth);
         secbadmward=(LinearLayout)findViewById(R.id.secbadmward);
         linebadmward=(View)findViewById(R.id.linebadmward);
         Vlblbadmward = (TextView) findViewById(R.id.Vlblbadmward);
         rdogrpbadmward = (RadioGroup) findViewById(R.id.rdogrpbadmward);
         
         rdobadmward1 = (RadioButton) findViewById(R.id.rdobadmward1);
         rdobadmward2 = (RadioButton) findViewById(R.id.rdobadmward2);
         rdobadmward3 = (RadioButton) findViewById(R.id.rdobadmward3);
         sectoldresusexp=(LinearLayout)findViewById(R.id.sectoldresusexp);
         linetoldresusexp=(View)findViewById(R.id.linetoldresusexp);
         Vlbltoldresusexp=(TextView) findViewById(R.id.Vlbltoldresusexp);
         //spntoldresusexp=(Spinner) findViewById(R.id.spntoldresusexp);

         rdogrptoldresusexp=(RadioGroup)findViewById(R.id.rdogrptoldresusexp) ;
         rdotoldresusexp1=(RadioButton)findViewById(R.id.rdotoldresusexp1) ;
         rdotoldresusexp2=(RadioButton)findViewById(R.id.rdotoldresusexp2) ;
         rdotoldresusexp3=(RadioButton)findViewById(R.id.rdotoldresusexp3) ;
         rdogrptoldresusexp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 switch(checkedId)
                 {
                     case R.id.rdotoldresusexp1:
                         secresusexp.setVisibility(View.VISIBLE);
                         lineresusexp.setVisibility(View.VISIBLE);
                         secresusexpDK.setVisibility(View.VISIBLE);
                         lineresusexpDK.setVisibility(View.VISIBLE);
                         seclblsecII14.setVisibility(View.VISIBLE);
                         linelblsecII14.setVisibility(View.VISIBLE);
                         break;
                     case R.id.rdotoldresusexp2:
                         secresusexp.setVisibility(View.GONE);
                         lineresusexp.setVisibility(View.GONE);
                         txtresusexp.setText("");
                         secresusexpDK.setVisibility(View.GONE);
                         lineresusexpDK.setVisibility(View.GONE);
                         chkresusexpDK.setChecked(false);
                         //seclblsecII14.setVisibility(View.GONE);
                         linelblsecII14.setVisibility(View.GONE);
                         break;
                     case R.id.rdotoldresusexp3:
                         secresusexp.setVisibility(View.GONE);
                         lineresusexp.setVisibility(View.GONE);
                         txtresusexp.setText("");
                         secresusexpDK.setVisibility(View.GONE);
                         lineresusexpDK.setVisibility(View.GONE);
                         chkresusexpDK.setChecked(false);
                         //seclblsecII14.setVisibility(View.GONE);
                         linelblsecII14.setVisibility(View.GONE);
                         break;
                 }
             }
         });

         /*List<String> listtoldresusexp = new ArrayList<String>();
         
         listtoldresusexp.add("");
         listtoldresusexp.add("01-Yes");
         listtoldresusexp.add("02-No");
         listtoldresusexp.add("98-Don’t know/don’t remember");
         ArrayAdapter<String> adptrtoldresusexp= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listtoldresusexp);
         spntoldresusexp.setAdapter(adptrtoldresusexp);*/

         /*spntoldresusexp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             if (spntoldresusexp.getSelectedItem().toString().length() == 0) return;
             String spnData = Connection.SelectedSpinnerValue(spntoldresusexp.getSelectedItem().toString(),"-");
                 if(spnData.equalsIgnoreCase("02"))
                 {
                    secresusexp.setVisibility(View.GONE);
                    lineresusexp.setVisibility(View.GONE);
                    txtresusexp.setText("");
                    secresusexpDK.setVisibility(View.GONE);
                    lineresusexpDK.setVisibility(View.GONE);
                    chkresusexpDK.setChecked(false);
                    //seclblsecII14.setVisibility(View.GONE);
                    linelblsecII14.setVisibility(View.GONE);
                 }
                 else if(spnData.equalsIgnoreCase("98"))
                 {
                    secresusexp.setVisibility(View.GONE);
                    lineresusexp.setVisibility(View.GONE);
                    txtresusexp.setText("");
                    secresusexpDK.setVisibility(View.GONE);
                    lineresusexpDK.setVisibility(View.GONE);
                    chkresusexpDK.setChecked(false);
                    //seclblsecII14.setVisibility(View.GONE);
                    linelblsecII14.setVisibility(View.GONE);
                 }
                 else
                 {
                    secresusexp.setVisibility(View.VISIBLE);
                    lineresusexp.setVisibility(View.VISIBLE);
                    secresusexpDK.setVisibility(View.VISIBLE);
                    lineresusexpDK.setVisibility(View.VISIBLE);
                    seclblsecII14.setVisibility(View.VISIBLE);
                    linelblsecII14.setVisibility(View.VISIBLE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });*/

         secresusexp=(LinearLayout)findViewById(R.id.secresusexp);
         lineresusexp=(View)findViewById(R.id.lineresusexp);
         Vlblresusexp=(TextView) findViewById(R.id.Vlblresusexp);
         txtresusexp=(EditText) findViewById(R.id.txtresusexp);
         secresusexpDK=(LinearLayout)findViewById(R.id.secresusexpDK);
         lineresusexpDK=(View)findViewById(R.id.lineresusexpDK);
         VlblresusexpDK=(TextView) findViewById(R.id.VlblresusexpDK);
         chkresusexpDK=(CheckBox) findViewById(R.id.chkresusexpDK);
         seclblsecII14=(LinearLayout)findViewById(R.id.seclblsecII14);
         linelblsecII14=(View)findViewById(R.id.linelblsecII14);
         secappcord=(LinearLayout)findViewById(R.id.secappcord);
         lineappcord=(View)findViewById(R.id.lineappcord);
         Vlblappcord=(TextView) findViewById(R.id.Vlblappcord);
         //spnappcord=(Spinner) findViewById(R.id.spnappcord);
         rdogrpappcord=(RadioGroup)findViewById(R.id.rdogrpappcord) ;
         rdoappcord1=(RadioButton)findViewById(R.id.rdoappcord1) ;
         rdoappcord2=(RadioButton)findViewById(R.id.rdoappcord2) ;
         rdoappcord3=(RadioButton)findViewById(R.id.rdoappcord3) ;
         rdogrpappcord.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 switch(checkedId)
                 {
                     case R.id.rdoappcord1:
                         secmedappcord.setVisibility(View.VISIBLE);
                         linemedappcord.setVisibility(View.VISIBLE);
                         secmedappcordOth.setVisibility(View.GONE);
                         linemedappcordOth.setVisibility(View.GONE);
                         //seclblsecII15.setVisibility(View.VISIBLE);
                         //linelblsecII15.setVisibility(View.VISIBLE);
                         sectimechl.setVisibility(View.VISIBLE);
                         linetimechl.setVisibility(View.VISIBLE);
                         sectimechlDur.setVisibility(View.VISIBLE);
                         linetimechlDur.setVisibility(View.VISIBLE);
                         seclblsecII19.setVisibility(View.VISIBLE);
                         linelblsecII19.setVisibility(View.VISIBLE);
                         secwhoappchl.setVisibility(View.VISIBLE);
                         linewhoappchl.setVisibility(View.VISIBLE);
                         secwhoappchlOth.setVisibility(View.GONE);
                         linewhoappchlOth.setVisibility(View.GONE);
                         sectoldchlreas.setVisibility(View.VISIBLE);
                         linetoldchlreas.setVisibility(View.VISIBLE);
                         secchlhome.setVisibility(View.VISIBLE);
                         linechlhome.setVisibility(View.VISIBLE);
                         seccomments.setVisibility(View.VISIBLE);
                         linecomments.setVisibility(View.VISIBLE);
                         break;
                     case R.id.rdoappcord2:
                         secmedappcord.setVisibility(View.GONE);
                         linemedappcord.setVisibility(View.GONE);
                         rdogrpmedappcord.clearCheck();
                         secmedappcordOth.setVisibility(View.GONE);
                         linemedappcordOth.setVisibility(View.GONE);
                         txtmedappcordOth.setText("");
                         seclblsecII15.setVisibility(View.GONE);
                         linelblsecII15.setVisibility(View.GONE);
                         sectimechl.setVisibility(View.GONE);
                         linetimechl.setVisibility(View.GONE);
                         rdogrptimechl.clearCheck();
                         sectimechlDur.setVisibility(View.GONE);
                         linetimechlDur.setVisibility(View.GONE);
                         txttimechlDur.setText("");
                         seclblsecII19.setVisibility(View.GONE);
                         linelblsecII19.setVisibility(View.GONE);
                         secwhoappchl.setVisibility(View.GONE);
                         linewhoappchl.setVisibility(View.GONE);
                         spnwhoappchl.setSelection(0);
                         secwhoappchlOth.setVisibility(View.GONE);
                         linewhoappchlOth.setVisibility(View.GONE);
                         txtwhoappchlOth.setText("");
                         sectoldchlreas.setVisibility(View.GONE);
                         linetoldchlreas.setVisibility(View.GONE);
                         //spntoldchlreas.setSelection(0);
                         rdogrptoldchlreas.clearCheck();
                         secchlreas.setVisibility(View.GONE);
                         linechlreas.setVisibility(View.GONE);
                         txtchlreas.setText("");
                         secchlreasDK.setVisibility(View.GONE);
                         linechlreasDK.setVisibility(View.GONE);
                         chkchlreasDK.setChecked(false);
                         secchlhome.setVisibility(View.GONE);
                         linechlhome.setVisibility(View.GONE);
                         //spnchlhome.setSelection(0);
                         rdogrpchlhome.clearCheck();
                         seccomments.setVisibility(View.GONE);
                         linecomments.setVisibility(View.GONE);
                         txtcomments.setText("");
                         break;
                     case R.id.rdoappcord3:
                         secmedappcord.setVisibility(View.GONE);
                         linemedappcord.setVisibility(View.GONE);
                         rdogrpmedappcord.clearCheck();
                         secmedappcordOth.setVisibility(View.GONE);
                         linemedappcordOth.setVisibility(View.GONE);
                         txtmedappcordOth.setText("");
                         seclblsecII15.setVisibility(View.GONE);
                         linelblsecII15.setVisibility(View.GONE);
                         sectimechl.setVisibility(View.GONE);
                         linetimechl.setVisibility(View.GONE);
                         rdogrptimechl.clearCheck();
                         sectimechlDur.setVisibility(View.GONE);
                         linetimechlDur.setVisibility(View.GONE);
                         txttimechlDur.setText("");
                         seclblsecII19.setVisibility(View.GONE);
                         linelblsecII19.setVisibility(View.GONE);
                         secwhoappchl.setVisibility(View.GONE);
                         linewhoappchl.setVisibility(View.GONE);
                         spnwhoappchl.setSelection(0);
                         secwhoappchlOth.setVisibility(View.GONE);
                         linewhoappchlOth.setVisibility(View.GONE);
                         txtwhoappchlOth.setText("");
                         sectoldchlreas.setVisibility(View.GONE);
                         linetoldchlreas.setVisibility(View.GONE);
                         //spntoldchlreas.setSelection(0);
                         rdogrptoldchlreas.clearCheck();
                         secchlreas.setVisibility(View.GONE);
                         linechlreas.setVisibility(View.GONE);
                         txtchlreas.setText("");
                         secchlreasDK.setVisibility(View.GONE);
                         linechlreasDK.setVisibility(View.GONE);
                         chkchlreasDK.setChecked(false);
                         secchlhome.setVisibility(View.GONE);
                         linechlhome.setVisibility(View.GONE);
                         //spnchlhome.setSelection(0);
                         rdogrpchlhome.clearCheck();
                         seccomments.setVisibility(View.GONE);
                         linecomments.setVisibility(View.GONE);
                         txtcomments.setText("");
                         break;
                 }
             }
         });

         /*List<String> listappcord = new ArrayList<String>();
         
         listappcord.add("");
         listappcord.add("01-Yes");
         listappcord.add("02-No");
         listappcord.add("98-Don’t know/don’t remember");
         ArrayAdapter<String> adptrappcord= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listappcord);
         spnappcord.setAdapter(adptrappcord);

         spnappcord.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             if (spnappcord.getSelectedItem().toString().length() == 0) return;
             String spnData = Connection.SelectedSpinnerValue(spnappcord.getSelectedItem().toString(),"-");
                 if(spnData.equalsIgnoreCase("02"))
                 {
                    secmedappcord.setVisibility(View.GONE);
                    linemedappcord.setVisibility(View.GONE);
                    rdogrpmedappcord.clearCheck();
                    secmedappcordOth.setVisibility(View.GONE);
                    linemedappcordOth.setVisibility(View.GONE);
                    txtmedappcordOth.setText("");
                    seclblsecII15.setVisibility(View.GONE);
                    linelblsecII15.setVisibility(View.GONE);
                    sectimechl.setVisibility(View.GONE);
                    linetimechl.setVisibility(View.GONE);
                    rdogrptimechl.clearCheck();
                    sectimechlDur.setVisibility(View.GONE);
                    linetimechlDur.setVisibility(View.GONE);
                    txttimechlDur.setText("");
                    seclblsecII19.setVisibility(View.GONE);
                    linelblsecII19.setVisibility(View.GONE);
                    secwhoappchl.setVisibility(View.GONE);
                    linewhoappchl.setVisibility(View.GONE);
                    spnwhoappchl.setSelection(0);
                    secwhoappchlOth.setVisibility(View.GONE);
                    linewhoappchlOth.setVisibility(View.GONE);
                    txtwhoappchlOth.setText("");
                    sectoldchlreas.setVisibility(View.GONE);
                    linetoldchlreas.setVisibility(View.GONE);
                    spntoldchlreas.setSelection(0);
                    secchlreas.setVisibility(View.GONE);
                    linechlreas.setVisibility(View.GONE);
                    txtchlreas.setText("");
                    secchlreasDK.setVisibility(View.GONE);
                    linechlreasDK.setVisibility(View.GONE);
                    chkchlreasDK.setChecked(false);
                    secchlhome.setVisibility(View.GONE);
                    linechlhome.setVisibility(View.GONE);
                    spnchlhome.setSelection(0);
                    seccomments.setVisibility(View.GONE);
                    linecomments.setVisibility(View.GONE);
                    txtcomments.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("98"))
                 {
                    secmedappcord.setVisibility(View.GONE);
                    linemedappcord.setVisibility(View.GONE);
                    rdogrpmedappcord.clearCheck();
                    secmedappcordOth.setVisibility(View.GONE);
                    linemedappcordOth.setVisibility(View.GONE);
                    txtmedappcordOth.setText("");
                    seclblsecII15.setVisibility(View.GONE);
                    linelblsecII15.setVisibility(View.GONE);
                    sectimechl.setVisibility(View.GONE);
                    linetimechl.setVisibility(View.GONE);
                    rdogrptimechl.clearCheck();
                    sectimechlDur.setVisibility(View.GONE);
                    linetimechlDur.setVisibility(View.GONE);
                    txttimechlDur.setText("");
                    seclblsecII19.setVisibility(View.GONE);
                    linelblsecII19.setVisibility(View.GONE);
                    secwhoappchl.setVisibility(View.GONE);
                    linewhoappchl.setVisibility(View.GONE);
                    spnwhoappchl.setSelection(0);
                    secwhoappchlOth.setVisibility(View.GONE);
                    linewhoappchlOth.setVisibility(View.GONE);
                    txtwhoappchlOth.setText("");
                    sectoldchlreas.setVisibility(View.GONE);
                    linetoldchlreas.setVisibility(View.GONE);
                    spntoldchlreas.setSelection(0);
                    secchlreas.setVisibility(View.GONE);
                    linechlreas.setVisibility(View.GONE);
                    txtchlreas.setText("");
                    secchlreasDK.setVisibility(View.GONE);
                    linechlreasDK.setVisibility(View.GONE);
                    chkchlreasDK.setChecked(false);
                    secchlhome.setVisibility(View.GONE);
                    linechlhome.setVisibility(View.GONE);
                    spnchlhome.setSelection(0);
                    seccomments.setVisibility(View.GONE);
                    linecomments.setVisibility(View.GONE);
                    txtcomments.setText("");
                 }
                 else
                 {
                    secmedappcord.setVisibility(View.VISIBLE);
                    linemedappcord.setVisibility(View.VISIBLE);
                    secmedappcordOth.setVisibility(View.GONE);
                    linemedappcordOth.setVisibility(View.GONE);
                    seclblsecII15.setVisibility(View.VISIBLE);
                    linelblsecII15.setVisibility(View.VISIBLE);
                    sectimechl.setVisibility(View.VISIBLE);
                    linetimechl.setVisibility(View.VISIBLE);
                    sectimechlDur.setVisibility(View.VISIBLE);
                    linetimechlDur.setVisibility(View.VISIBLE);
                    seclblsecII19.setVisibility(View.VISIBLE);
                    linelblsecII19.setVisibility(View.VISIBLE);
                    secwhoappchl.setVisibility(View.VISIBLE);
                    linewhoappchl.setVisibility(View.VISIBLE);
                    secwhoappchlOth.setVisibility(View.GONE);
                    linewhoappchlOth.setVisibility(View.GONE);
                    sectoldchlreas.setVisibility(View.VISIBLE);
                    linetoldchlreas.setVisibility(View.VISIBLE);
                    secchlhome.setVisibility(View.VISIBLE);
                    linechlhome.setVisibility(View.VISIBLE);
                    seccomments.setVisibility(View.VISIBLE);
                    linecomments.setVisibility(View.VISIBLE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });*/
         secmedappcord=(LinearLayout)findViewById(R.id.secmedappcord);
         linemedappcord=(View)findViewById(R.id.linemedappcord);
         Vlblmedappcord = (TextView) findViewById(R.id.Vlblmedappcord);
         rdogrpmedappcord = (RadioGroup) findViewById(R.id.rdogrpmedappcord);
         
         rdomedappcord1 = (RadioButton) findViewById(R.id.rdomedappcord1);
         rdomedappcord2 = (RadioButton) findViewById(R.id.rdomedappcord2);
         rdomedappcord3 = (RadioButton) findViewById(R.id.rdomedappcord3);
         rdogrpmedappcord.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpmedappcord = new String[] {"1","2","9"};
             for (int i = 0; i < rdogrpmedappcord.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpmedappcord.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpmedappcord[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                    secmedappcordOth.setVisibility(View.GONE);
                    linemedappcordOth.setVisibility(View.GONE);
                    txtmedappcordOth.setText("");
                    seclblsecII15.setVisibility(View.GONE);
                    linelblsecII15.setVisibility(View.GONE);
             }
             else if(rbData.equalsIgnoreCase("9"))
             {
                    secmedappcordOth.setVisibility(View.GONE);
                    linemedappcordOth.setVisibility(View.GONE);
                    txtmedappcordOth.setText("");
                    seclblsecII15.setVisibility(View.GONE);
                    linelblsecII15.setVisibility(View.GONE);
                    sectimechl.setVisibility(View.GONE);
                    linetimechl.setVisibility(View.GONE);
                    rdogrptimechl.clearCheck();
                    sectimechlDur.setVisibility(View.GONE);
                    linetimechlDur.setVisibility(View.GONE);
                    txttimechlDur.setText("");
                    seclblsecII19.setVisibility(View.GONE);
                    linelblsecII19.setVisibility(View.GONE);
                    secwhoappchl.setVisibility(View.GONE);
                    linewhoappchl.setVisibility(View.GONE);
                    spnwhoappchl.setSelection(0);
                    secwhoappchlOth.setVisibility(View.GONE);
                    linewhoappchlOth.setVisibility(View.GONE);
                    txtwhoappchlOth.setText("");
                    sectoldchlreas.setVisibility(View.GONE);
                    linetoldchlreas.setVisibility(View.GONE);
                    //spntoldchlreas.setSelection(0);
                 rdogrptoldchlreas.clearCheck();
                    secchlreas.setVisibility(View.GONE);
                    linechlreas.setVisibility(View.GONE);
                    txtchlreas.setText("");
                    secchlreasDK.setVisibility(View.GONE);
                    linechlreasDK.setVisibility(View.GONE);
                    chkchlreasDK.setChecked(false);
                    secchlhome.setVisibility(View.GONE);
                    linechlhome.setVisibility(View.GONE);
                    //spnchlhome.setSelection(0);
                 rdogrpchlhome.clearCheck();
                    seccomments.setVisibility(View.GONE);
                    linecomments.setVisibility(View.GONE);
                    txtcomments.setText("");
             }
             else
             {
                    secmedappcordOth.setVisibility(View.VISIBLE);
                    linemedappcordOth.setVisibility(View.VISIBLE);
                    seclblsecII15.setVisibility(View.VISIBLE);
                    linelblsecII15.setVisibility(View.VISIBLE);
                    sectimechl.setVisibility(View.VISIBLE);
                    linetimechl.setVisibility(View.VISIBLE);
                    sectimechlDur.setVisibility(View.VISIBLE);
                    linetimechlDur.setVisibility(View.VISIBLE);
                    seclblsecII19.setVisibility(View.VISIBLE);
                    linelblsecII19.setVisibility(View.VISIBLE);
                    secwhoappchl.setVisibility(View.VISIBLE);
                    linewhoappchl.setVisibility(View.VISIBLE);
                    secwhoappchlOth.setVisibility(View.VISIBLE);
                    linewhoappchlOth.setVisibility(View.VISIBLE);
                    sectoldchlreas.setVisibility(View.VISIBLE);
                    linetoldchlreas.setVisibility(View.VISIBLE);
                    secchlhome.setVisibility(View.VISIBLE);
                    linechlhome.setVisibility(View.VISIBLE);
                    seccomments.setVisibility(View.VISIBLE);
                    linecomments.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secmedappcordOth=(LinearLayout)findViewById(R.id.secmedappcordOth);
         linemedappcordOth=(View)findViewById(R.id.linemedappcordOth);
         VlblmedappcordOth=(TextView) findViewById(R.id.VlblmedappcordOth);
         txtmedappcordOth=(EditText) findViewById(R.id.txtmedappcordOth);
         seclblsecII15=(LinearLayout)findViewById(R.id.seclblsecII15);
         linelblsecII15=(View)findViewById(R.id.linelblsecII15);
         sectimechl=(LinearLayout)findViewById(R.id.sectimechl);
         linetimechl=(View)findViewById(R.id.linetimechl);
         Vlbltimechl = (TextView) findViewById(R.id.Vlbltimechl);
         rdogrptimechl = (RadioGroup) findViewById(R.id.rdogrptimechl);
         
         rdotimechl1 = (RadioButton) findViewById(R.id.rdotimechl1);
         rdotimechl2 = (RadioButton) findViewById(R.id.rdotimechl2);
         rdotimechl3 = (RadioButton) findViewById(R.id.rdotimechl3);
         rdogrptimechl.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrptimechl = new String[] {"1","2","9"};
             for (int i = 0; i < rdogrptimechl.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrptimechl.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrptimechl[i];
             }

             if(rbData.equalsIgnoreCase("9"))
             {
                    sectimechlDur.setVisibility(View.GONE);
                    linetimechlDur.setVisibility(View.GONE);
                    txttimechlDur.setText("");
                    seclblsecII19.setVisibility(View.GONE);
                    linelblsecII19.setVisibility(View.GONE);
             }
             else
             {
                    sectimechlDur.setVisibility(View.VISIBLE);
                    linetimechlDur.setVisibility(View.VISIBLE);
                    seclblsecII19.setVisibility(View.VISIBLE);
                    linelblsecII19.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         sectimechlDur=(LinearLayout)findViewById(R.id.sectimechlDur);
         linetimechlDur=(View)findViewById(R.id.linetimechlDur);
         VlbltimechlDur=(TextView) findViewById(R.id.VlbltimechlDur);
         txttimechlDur=(EditText) findViewById(R.id.txttimechlDur);
         seclblsecII19=(LinearLayout)findViewById(R.id.seclblsecII19);
         linelblsecII19=(View)findViewById(R.id.linelblsecII19);
         secwhoappchl=(LinearLayout)findViewById(R.id.secwhoappchl);
         linewhoappchl=(View)findViewById(R.id.linewhoappchl);
         Vlblwhoappchl=(TextView) findViewById(R.id.Vlblwhoappchl);
         spnwhoappchl=(Spinner) findViewById(R.id.spnwhoappchl);
         List<String> listwhoappchl = new ArrayList<String>();
         
         listwhoappchl.add("");
         if(COUNTRYCODE.equals(ProjectSetting.BANGLADESH)){
             listwhoappchl.add("1-স্বাস্থ্যকর্মী");
             listwhoappchl.add("2-মা নিজে");
             listwhoappchl.add("3-নানী, পরিবারের কোন সদস্য অথবা বন্ধু");
             listwhoappchl.add("7-অন্যান্য");
             listwhoappchl.add("9-জানিনা/মনে নাই");

         }else if(COUNTRYCODE.equals(ProjectSetting.NEPAL)){
             listwhoappchl.add("1-स्वास्थ्य कार्य कर्ता");
             listwhoappchl.add("2-आफै ");
             listwhoappchl.add("3-परिवारको सदस्य वा साथी");
             listwhoappchl.add("7-अन्य");
             listwhoappchl.add("9-थाहा छैन/ याद छैन");

         }else {
             listwhoappchl.add("1-Health worker");
             listwhoappchl.add("2-Myself ");
             listwhoappchl.add("3-Mother, family member or friend");
             listwhoappchl.add("7-Other");
             listwhoappchl.add("9-Don’t know/don’t remember");
         }
         ArrayAdapter<String> adptrwhoappchl= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listwhoappchl);
         spnwhoappchl.setAdapter(adptrwhoappchl);

         spnwhoappchl.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             if (spnwhoappchl.getSelectedItem().toString().length() == 0) return;
             String spnData = Connection.SelectedSpinnerValue(spnwhoappchl.getSelectedItem().toString(),"-");
                 if(spnData.equalsIgnoreCase("1"))
                 {
                    secwhoappchlOth.setVisibility(View.GONE);
                    linewhoappchlOth.setVisibility(View.GONE);
                    txtwhoappchlOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                    secwhoappchlOth.setVisibility(View.GONE);
                    linewhoappchlOth.setVisibility(View.GONE);
                    txtwhoappchlOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("3"))
                 {
                    secwhoappchlOth.setVisibility(View.GONE);
                    linewhoappchlOth.setVisibility(View.GONE);
                    txtwhoappchlOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("9"))
                 {
                    secwhoappchlOth.setVisibility(View.GONE);
                    linewhoappchlOth.setVisibility(View.GONE);
                    txtwhoappchlOth.setText("");
                 }
                 else
                 {
                    secwhoappchlOth.setVisibility(View.VISIBLE);
                    linewhoappchlOth.setVisibility(View.VISIBLE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secwhoappchlOth=(LinearLayout)findViewById(R.id.secwhoappchlOth);
         linewhoappchlOth=(View)findViewById(R.id.linewhoappchlOth);
         VlblwhoappchlOth=(TextView) findViewById(R.id.VlblwhoappchlOth);
         txtwhoappchlOth=(EditText) findViewById(R.id.txtwhoappchlOth);
         sectoldchlreas=(LinearLayout)findViewById(R.id.sectoldchlreas);
         linetoldchlreas=(View)findViewById(R.id.linetoldchlreas);
         Vlbltoldchlreas=(TextView) findViewById(R.id.Vlbltoldchlreas);
         //spntoldchlreas=(Spinner) findViewById(R.id.spntoldchlreas);
         rdogrptoldchlreas=(RadioGroup)findViewById(R.id.rdogrptoldchlreas) ;
         rdotoldchlreas1=(RadioButton)findViewById(R.id.rdotoldchlreas1);
         rdotoldchlreas2=(RadioButton)findViewById(R.id.rdotoldchlreas2);
         rdotoldchlreas3=(RadioButton)findViewById(R.id.rdotoldchlreas3);
         rdogrptoldchlreas.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 switch(checkedId)
                 {
                     case R.id.rdotoldchlreas1:
                         secchlreas.setVisibility(View.VISIBLE);
                         linechlreas.setVisibility(View.VISIBLE);
                         secchlreasDK.setVisibility(View.VISIBLE);
                         linechlreasDK.setVisibility(View.VISIBLE);
                         break;
                     case R.id.rdotoldchlreas2:
                         secchlreas.setVisibility(View.GONE);
                         linechlreas.setVisibility(View.GONE);
                         txtchlreas.setText("");
                         secchlreasDK.setVisibility(View.GONE);
                         linechlreasDK.setVisibility(View.GONE);
                         chkchlreasDK.setChecked(false);
                         break;
                     case R.id.rdotoldchlreas3:
                         secchlreas.setVisibility(View.GONE);
                         linechlreas.setVisibility(View.GONE);
                         txtchlreas.setText("");
                         secchlreasDK.setVisibility(View.GONE);
                         linechlreasDK.setVisibility(View.GONE);
                         chkchlreasDK.setChecked(false);
                         break;
                 }
             }
         });

         /*List<String> listtoldchlreas = new ArrayList<String>();
         
         listtoldchlreas.add("");
         listtoldchlreas.add("01-Yes");
         listtoldchlreas.add("02-No");
         listtoldchlreas.add("98-Don’t know/don’t remember");
         ArrayAdapter<String> adptrtoldchlreas= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listtoldchlreas);
         spntoldchlreas.setAdapter(adptrtoldchlreas);

         spntoldchlreas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             if (spntoldchlreas.getSelectedItem().toString().length() == 0) return;
             String spnData = Connection.SelectedSpinnerValue(spntoldchlreas.getSelectedItem().toString(),"-");
                 if(spnData.equalsIgnoreCase("02"))
                 {
                    secchlreas.setVisibility(View.GONE);
                    linechlreas.setVisibility(View.GONE);
                    txtchlreas.setText("");
                    secchlreasDK.setVisibility(View.GONE);
                    linechlreasDK.setVisibility(View.GONE);
                    chkchlreasDK.setChecked(false);
                 }
                 else if(spnData.equalsIgnoreCase("98"))
                 {
                    secchlreas.setVisibility(View.GONE);
                    linechlreas.setVisibility(View.GONE);
                    txtchlreas.setText("");
                    secchlreasDK.setVisibility(View.GONE);
                    linechlreasDK.setVisibility(View.GONE);
                    chkchlreasDK.setChecked(false);
                 }
                 else
                 {
                    secchlreas.setVisibility(View.VISIBLE);
                    linechlreas.setVisibility(View.VISIBLE);
                    secchlreasDK.setVisibility(View.VISIBLE);
                    linechlreasDK.setVisibility(View.VISIBLE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });*/

         secchlreas=(LinearLayout)findViewById(R.id.secchlreas);
         linechlreas=(View)findViewById(R.id.linechlreas);
         Vlblchlreas=(TextView) findViewById(R.id.Vlblchlreas);
         txtchlreas=(EditText) findViewById(R.id.txtchlreas);
         secchlreasDK=(LinearLayout)findViewById(R.id.secchlreasDK);
         linechlreasDK=(View)findViewById(R.id.linechlreasDK);
         VlblchlreasDK=(TextView) findViewById(R.id.VlblchlreasDK);
         chkchlreasDK=(CheckBox) findViewById(R.id.chkchlreasDK);
         secchlhome=(LinearLayout)findViewById(R.id.secchlhome);
         linechlhome=(View)findViewById(R.id.linechlhome);
         Vlblchlhome=(TextView) findViewById(R.id.Vlblchlhome);
         //spnchlhome=(Spinner) findViewById(R.id.spnchlhome);
         rdogrpchlhome=(RadioGroup)findViewById(R.id.rdogrpchlhome) ;
         rdochlhome1=(RadioButton)findViewById(R.id.rdochlhome1) ;
         rdochlhome2=(RadioButton)findViewById(R.id.rdochlhome2) ;
         rdochlhome3=(RadioButton)findViewById(R.id.rdochlhome3) ;

         /*List<String> listchlhome = new ArrayList<String>();

         listchlhome.add("");
         listchlhome.add("01-Yes");
         listchlhome.add("02-No");
         listchlhome.add("98-Don’t know/don’t remember");
         ArrayAdapter<String> adptrchlhome= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listchlhome);
         spnchlhome.setAdapter(adptrchlhome);*/

         seccomments=(LinearLayout)findViewById(R.id.seccomments);
         linecomments=(View)findViewById(R.id.linecomments);
         Vlblcomments=(TextView) findViewById(R.id.Vlblcomments);
         txtcomments=(EditText) findViewById(R.id.txtcomments);



         chkuteroroute1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if(isChecked)
                 {
                     chkuteroroute5.setChecked(false);
                 }
             }
         });
         chkuteroroute2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if(isChecked)
                 {
                     chkuteroroute5.setChecked(false);
                 }
             }
         });
         chkuteroroute3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if(isChecked)
                 {
                     chkuteroroute5.setChecked(false);
                 }
             }
         });
         chkuteroroute4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if(isChecked)
                 {
                     chkuteroroute5.setChecked(false);
                 }
             }
         });
         chkuteroroute5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if(isChecked)
                 {
                     chkuteroroute1.setChecked(false);
                     chkuteroroute2.setChecked(false);
                     chkuteroroute3.setChecked(false);
                     chkuteroroute4.setChecked(false);
                 }
             }
         });


         //20.a

         chkhelpbbrthA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if (isChecked) {
                     chkhelpbbrthB.setChecked(false);
                     chkhelpbbrthC.setChecked(false);
                     chkhelpbbrthD.setChecked(false);
                     chkhelpbbrthE.setChecked(false);
                 }
             }
         });
         chkhelpbbrthB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if (isChecked) {
                     chkhelpbbrthA.setChecked(false);
                     chkhelpbbrthE.setChecked(false);
                 }
             }
         });
         chkhelpbbrthC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if (isChecked) {
                     chkhelpbbrthA.setChecked(false);
                     chkhelpbbrthE.setChecked(false);
                 }
             }
         });
         chkhelpbbrthD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if (isChecked) {
                     chkhelpbbrthA.setChecked(false);
                     chkhelpbbrthE.setChecked(false);
                 }
             }
         });
         chkhelpbbrthE.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if (isChecked) {
                     chkhelpbbrthB.setChecked(false);
                     chkhelpbbrthC.setChecked(false);
                     chkhelpbbrthD.setChecked(false);
                     chkhelpbbrthA.setChecked(false);
                 }
             }
         });


         //22
         rdogrpbplast.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(rdobplast2.isChecked() | rdobplast3.isChecked()){
                     secbresustmin.setVisibility(View.GONE);
                     rdogrpbresustmin.clearCheck();
                     secbresustminDur.setVisibility(View.GONE);
                     txtbresustminDur.setText("");
                 }else{
                     secbresustmin.setVisibility(View.VISIBLE);
                     secbresustminDur.setVisibility(View.VISIBLE);
                 }
             }
         });


         //Hide all skip variables
         secredeliv.setVisibility(View.GONE);
         lineredeliv.setVisibility(View.GONE);
         seclblsecII7.setVisibility(View.GONE);
         linelblsecII7.setVisibility(View.GONE);
         seclblsecII7.setVisibility(View.GONE);
         linelblsecII7.setVisibility(View.GONE);
         secedeliv.setVisibility(View.GONE);
         lineedeliv.setVisibility(View.GONE);
         secedelivDur.setVisibility(View.GONE);
         lineedelivDur.setVisibility(View.GONE);
         seclblsecII7.setVisibility(View.GONE);
         linelblsecII7.setVisibility(View.GONE);
         secedeliv.setVisibility(View.GONE);
         lineedeliv.setVisibility(View.GONE);
         secedelivDur.setVisibility(View.GONE);
         lineedelivDur.setVisibility(View.GONE);
         secacsgiven.setVisibility(View.GONE);
         lineacsgiven.setVisibility(View.GONE);
         secacsreason.setVisibility(View.GONE);
         lineacsreason.setVisibility(View.GONE);
         secacsreasonOth.setVisibility(View.GONE);
         lineacsreasonOth.setVisibility(View.GONE);
         secacsname.setVisibility(View.GONE);
         lineacsname.setVisibility(View.GONE);
         secacsnameOth.setVisibility(View.GONE);
         lineacsnameOth.setVisibility(View.GONE);
         secacsroute.setVisibility(View.GONE);
         lineacsroute.setVisibility(View.GONE);
         secacsrouteOth.setVisibility(View.GONE);
         lineacsrouteOth.setVisibility(View.GONE);
         secacsdoses.setVisibility(View.GONE);
         lineacsdoses.setVisibility(View.GONE);
         secacsdosesDK.setVisibility(View.GONE);
         lineacsdosesDK.setVisibility(View.GONE);
         secacstime.setVisibility(View.GONE);
         lineacstime.setVisibility(View.GONE);
         //seclblsecII2.setVisibility(View.GONE);
         linelblsecII2.setVisibility(View.GONE);
         seclblsecII8.setVisibility(View.GONE);
         linelblsecII8.setVisibility(View.GONE);
         seclblsecII7.setVisibility(View.GONE);
         linelblsecII7.setVisibility(View.GONE);
         secedeliv.setVisibility(View.GONE);
         lineedeliv.setVisibility(View.GONE);
         secedelivDur.setVisibility(View.GONE);
         lineedelivDur.setVisibility(View.GONE);
         secacsgiven.setVisibility(View.GONE);
         lineacsgiven.setVisibility(View.GONE);
         secacsreason.setVisibility(View.GONE);
         lineacsreason.setVisibility(View.GONE);
         secacsreasonOth.setVisibility(View.GONE);
         lineacsreasonOth.setVisibility(View.GONE);
         secacsname.setVisibility(View.GONE);
         lineacsname.setVisibility(View.GONE);
         secacsnameOth.setVisibility(View.GONE);
         lineacsnameOth.setVisibility(View.GONE);
         secacsroute.setVisibility(View.GONE);
         lineacsroute.setVisibility(View.GONE);
         secacsrouteOth.setVisibility(View.GONE);
         lineacsrouteOth.setVisibility(View.GONE);
         secacsdoses.setVisibility(View.GONE);
         lineacsdoses.setVisibility(View.GONE);
         secacsdosesDK.setVisibility(View.GONE);
         lineacsdosesDK.setVisibility(View.GONE);
         secacstime.setVisibility(View.GONE);
         lineacstime.setVisibility(View.GONE);
         //seclblsecII2.setVisibility(View.GONE);
         linelblsecII2.setVisibility(View.GONE);
         seclblsecII8.setVisibility(View.GONE);
         linelblsecII8.setVisibility(View.GONE);
         secacsreason.setVisibility(View.GONE);
         lineacsreason.setVisibility(View.GONE);
         secacsreasonOth.setVisibility(View.GONE);
         lineacsreasonOth.setVisibility(View.GONE);
         secacsname.setVisibility(View.GONE);
         lineacsname.setVisibility(View.GONE);
         secacsnameOth.setVisibility(View.GONE);
         lineacsnameOth.setVisibility(View.GONE);
         secacsroute.setVisibility(View.GONE);
         lineacsroute.setVisibility(View.GONE);
         secacsrouteOth.setVisibility(View.GONE);
         lineacsrouteOth.setVisibility(View.GONE);
         secacsdoses.setVisibility(View.GONE);
         lineacsdoses.setVisibility(View.GONE);
         secacsdosesDK.setVisibility(View.GONE);
         lineacsdosesDK.setVisibility(View.GONE);
         secacstime.setVisibility(View.GONE);
         lineacstime.setVisibility(View.GONE);
         //seclblsecII2.setVisibility(View.GONE);
         linelblsecII2.setVisibility(View.GONE);
         seclblsecII8.setVisibility(View.GONE);
         linelblsecII8.setVisibility(View.GONE);
         secacsreason.setVisibility(View.GONE);
         lineacsreason.setVisibility(View.GONE);
         secacsreasonOth.setVisibility(View.GONE);
         lineacsreasonOth.setVisibility(View.GONE);
         secacsname.setVisibility(View.GONE);
         lineacsname.setVisibility(View.GONE);
         secacsnameOth.setVisibility(View.GONE);
         lineacsnameOth.setVisibility(View.GONE);
         secacsroute.setVisibility(View.GONE);
         lineacsroute.setVisibility(View.GONE);
         secacsrouteOth.setVisibility(View.GONE);
         lineacsrouteOth.setVisibility(View.GONE);
         secacsdoses.setVisibility(View.GONE);
         lineacsdoses.setVisibility(View.GONE);
         secacsdosesDK.setVisibility(View.GONE);
         lineacsdosesDK.setVisibility(View.GONE);
         secacstime.setVisibility(View.GONE);
         lineacstime.setVisibility(View.GONE);
         //.setVisibility(View.GONE);
         linelblsecII2.setVisibility(View.GONE);
         seclblsecII8.setVisibility(View.GONE);
         linelblsecII8.setVisibility(View.GONE);
         secacsreasonOth.setVisibility(View.GONE);
         lineacsreasonOth.setVisibility(View.GONE);
         secacsreasonOth.setVisibility(View.GONE);
         lineacsreasonOth.setVisibility(View.GONE);
         secacsreasonOth.setVisibility(View.GONE);
         lineacsreasonOth.setVisibility(View.GONE);
         secacsnameOth.setVisibility(View.GONE);
         lineacsnameOth.setVisibility(View.GONE);
         secacsnameOth.setVisibility(View.GONE);
         lineacsnameOth.setVisibility(View.GONE);
         secacsnameOth.setVisibility(View.GONE);
         lineacsnameOth.setVisibility(View.GONE);
         secacsnameOth.setVisibility(View.GONE);
         lineacsnameOth.setVisibility(View.GONE);
         secacsrouteOth.setVisibility(View.GONE);
         lineacsrouteOth.setVisibility(View.GONE);
         secacsrouteOth.setVisibility(View.GONE);
         lineacsrouteOth.setVisibility(View.GONE);
         secacsrouteOth.setVisibility(View.GONE);
         lineacsrouteOth.setVisibility(View.GONE);
         secacsrouteOth.setVisibility(View.GONE);
         lineacsrouteOth.setVisibility(View.GONE);
         seclblsecII9.setVisibility(View.GONE);
         linelblsecII9.setVisibility(View.GONE);
         secuteroroute1.setVisibility(View.GONE);
         lineuteroroute1.setVisibility(View.GONE);
         secuteroroute2.setVisibility(View.GONE);
         lineuteroroute2.setVisibility(View.GONE);
         secuteroroute3.setVisibility(View.GONE);
         lineuteroroute3.setVisibility(View.GONE);
         secuteroroute4.setVisibility(View.GONE);
         lineuteroroute4.setVisibility(View.GONE);
         secuteroroute5.setVisibility(View.GONE);
         lineuteroroute5.setVisibility(View.GONE);
         secuterotime.setVisibility(View.GONE);
         lineuterotime.setVisibility(View.GONE);
         secuterotold.setVisibility(View.GONE);
         lineuterotold.setVisibility(View.GONE);
         secuteroknow.setVisibility(View.GONE);
         lineuteroknow.setVisibility(View.GONE);
         seclblsecII16.setVisibility(View.GONE);
         linelblsecII16.setVisibility(View.GONE);
         secuteronameA.setVisibility(View.GONE);
         lineuteronameA.setVisibility(View.GONE);
         secuteronameB.setVisibility(View.GONE);
         lineuteronameB.setVisibility(View.GONE);
         secuteronameC.setVisibility(View.GONE);
         lineuteronameC.setVisibility(View.GONE);
         secuteronameD.setVisibility(View.GONE);
         lineuteronameD.setVisibility(View.GONE);
         secuteronameDOth.setVisibility(View.GONE);
         lineuteronameDOth.setVisibility(View.GONE);
         secuteronameE.setVisibility(View.GONE);
         lineuteronameE.setVisibility(View.GONE);
         sectolduteroreas.setVisibility(View.GONE);
         linetolduteroreas.setVisibility(View.GONE);
         seclblsecII17.setVisibility(View.GONE);
         linelblsecII17.setVisibility(View.GONE);
         secuteroreasA.setVisibility(View.GONE);
         lineuteroreasA.setVisibility(View.GONE);
         secuteroreasB.setVisibility(View.GONE);
         lineuteroreasB.setVisibility(View.GONE);
         secuteroreasOth.setVisibility(View.GONE);
         lineuteroreasOth.setVisibility(View.GONE);
         secuteroreasC.setVisibility(View.GONE);
         lineuteroreasC.setVisibility(View.GONE);
         //seclblsecII3.setVisibility(View.GONE);
         linelblsecII3.setVisibility(View.GONE);
         seclblsecII9.setVisibility(View.GONE);
         linelblsecII9.setVisibility(View.GONE);
         secuteroroute1.setVisibility(View.GONE);
         lineuteroroute1.setVisibility(View.GONE);
         secuteroroute2.setVisibility(View.GONE);
         lineuteroroute2.setVisibility(View.GONE);
         secuteroroute3.setVisibility(View.GONE);
         lineuteroroute3.setVisibility(View.GONE);
         secuteroroute4.setVisibility(View.GONE);
         lineuteroroute4.setVisibility(View.GONE);
         secuteroroute5.setVisibility(View.GONE);
         lineuteroroute5.setVisibility(View.GONE);
         secuterotime.setVisibility(View.GONE);
         lineuterotime.setVisibility(View.GONE);
         secuterotold.setVisibility(View.GONE);
         lineuterotold.setVisibility(View.GONE);
         secuteroknow.setVisibility(View.GONE);
         lineuteroknow.setVisibility(View.GONE);
         seclblsecII16.setVisibility(View.GONE);
         linelblsecII16.setVisibility(View.GONE);
         secuteronameA.setVisibility(View.GONE);
         lineuteronameA.setVisibility(View.GONE);
         secuteronameB.setVisibility(View.GONE);
         lineuteronameB.setVisibility(View.GONE);
         secuteronameC.setVisibility(View.GONE);
         lineuteronameC.setVisibility(View.GONE);
         secuteronameD.setVisibility(View.GONE);
         lineuteronameD.setVisibility(View.GONE);
         secuteronameDOth.setVisibility(View.GONE);
         lineuteronameDOth.setVisibility(View.GONE);
         secuteronameE.setVisibility(View.GONE);
         lineuteronameE.setVisibility(View.GONE);
         sectolduteroreas.setVisibility(View.GONE);
         linetolduteroreas.setVisibility(View.GONE);
         seclblsecII17.setVisibility(View.GONE);
         linelblsecII17.setVisibility(View.GONE);
         secuteroreasA.setVisibility(View.GONE);
         lineuteroreasA.setVisibility(View.GONE);
         secuteroreasB.setVisibility(View.GONE);
         lineuteroreasB.setVisibility(View.GONE);
         secuteroreasOth.setVisibility(View.GONE);
         lineuteroreasOth.setVisibility(View.GONE);
         secuteroreasC.setVisibility(View.GONE);
         lineuteroreasC.setVisibility(View.GONE);
         //seclblsecII3.setVisibility(View.GONE);
         linelblsecII3.setVisibility(View.GONE);
         seclblsecII16.setVisibility(View.GONE);
         linelblsecII16.setVisibility(View.GONE);
         secuteronameA.setVisibility(View.GONE);
         lineuteronameA.setVisibility(View.GONE);
         secuteronameB.setVisibility(View.GONE);
         lineuteronameB.setVisibility(View.GONE);
         secuteronameC.setVisibility(View.GONE);
         lineuteronameC.setVisibility(View.GONE);
         secuteronameD.setVisibility(View.GONE);
         lineuteronameD.setVisibility(View.GONE);
         secuteronameDOth.setVisibility(View.GONE);
         lineuteronameDOth.setVisibility(View.GONE);
         secuteronameE.setVisibility(View.GONE);
         lineuteronameE.setVisibility(View.GONE);
         seclblsecII16.setVisibility(View.GONE);
         linelblsecII16.setVisibility(View.GONE);
         secuteronameA.setVisibility(View.GONE);
         lineuteronameA.setVisibility(View.GONE);
         secuteronameB.setVisibility(View.GONE);
         lineuteronameB.setVisibility(View.GONE);
         secuteronameC.setVisibility(View.GONE);
         lineuteronameC.setVisibility(View.GONE);
         secuteronameD.setVisibility(View.GONE);
         lineuteronameD.setVisibility(View.GONE);
         secuteronameDOth.setVisibility(View.GONE);
         lineuteronameDOth.setVisibility(View.GONE);
         secuteronameE.setVisibility(View.GONE);
         lineuteronameE.setVisibility(View.GONE);
         secuteronameDOth.setVisibility(View.GONE);
         lineuteronameDOth.setVisibility(View.GONE);
         seclblsecII17.setVisibility(View.GONE);
         linelblsecII17.setVisibility(View.GONE);
         secuteroreasA.setVisibility(View.GONE);
         lineuteroreasA.setVisibility(View.GONE);
         secuteroreasB.setVisibility(View.GONE);
         lineuteroreasB.setVisibility(View.GONE);
         secuteroreasOth.setVisibility(View.GONE);
         lineuteroreasOth.setVisibility(View.GONE);
         secuteroreasC.setVisibility(View.GONE);
         lineuteroreasC.setVisibility(View.GONE);
         //seclblsecII3.setVisibility(View.GONE);
         linelblsecII3.setVisibility(View.GONE);
         seclblsecII17.setVisibility(View.GONE);
         linelblsecII17.setVisibility(View.GONE);
         secuteroreasA.setVisibility(View.GONE);
         lineuteroreasA.setVisibility(View.GONE);
         secuteroreasB.setVisibility(View.GONE);
         lineuteroreasB.setVisibility(View.GONE);
         secuteroreasOth.setVisibility(View.GONE);
         lineuteroreasOth.setVisibility(View.GONE);
         secuteroreasC.setVisibility(View.GONE);
         lineuteroreasC.setVisibility(View.GONE);
         //seclblsecII3.setVisibility(View.GONE);
         linelblsecII3.setVisibility(View.GONE);
         secuteroreasOth.setVisibility(View.GONE);
         lineuteroreasOth.setVisibility(View.GONE);
         secbchesttime.setVisibility(View.GONE);
         linebchesttime.setVisibility(View.GONE);
         secbchesttimeM.setVisibility(View.GONE);
         linebchesttimeM.setVisibility(View.GONE);
         secbchesttime.setVisibility(View.GONE);
         linebchesttime.setVisibility(View.GONE);
         secbchesttimeM.setVisibility(View.GONE);
         linebchesttimeM.setVisibility(View.GONE);
         secbchesttimeM.setVisibility(View.GONE);
         linebchesttimeM.setVisibility(View.GONE);
         secbplaced.setVisibility(View.GONE);
         linebplaced.setVisibility(View.GONE);
         secbchesttimeM.setVisibility(View.GONE);
         linebchesttimeM.setVisibility(View.GONE);
         secbplaced.setVisibility(View.GONE);
         linebplaced.setVisibility(View.GONE);
         secbchesttimeM.setVisibility(View.GONE);
         linebchesttimeM.setVisibility(View.GONE);
         secbplaced.setVisibility(View.GONE);
         linebplaced.setVisibility(View.GONE);
         secbbathtimeDur.setVisibility(View.GONE);
         linebbathtimeDur.setVisibility(View.GONE);
         seclblsecII10.setVisibility(View.GONE);
         linelblsecII10.setVisibility(View.GONE);
         secbbathtimeDur.setVisibility(View.GONE);
         linebbathtimeDur.setVisibility(View.GONE);
         seclblsecII10.setVisibility(View.GONE);
         linelblsecII10.setVisibility(View.GONE);
         secbfdtime.setVisibility(View.GONE);
         linebfdtime.setVisibility(View.GONE);
         secbfdtimeDur.setVisibility(View.GONE);
         linebfdtimeDur.setVisibility(View.GONE);
         seclblsecII11.setVisibility(View.GONE);
         linelblsecII11.setVisibility(View.GONE);
         secsupbfd.setVisibility(View.GONE);
         linesupbfd.setVisibility(View.GONE);
         secbfdtime.setVisibility(View.GONE);
         linebfdtime.setVisibility(View.GONE);
         secbfdtimeDur.setVisibility(View.GONE);
         linebfdtimeDur.setVisibility(View.GONE);
         seclblsecII11.setVisibility(View.GONE);
         linelblsecII11.setVisibility(View.GONE);
         secsupbfd.setVisibility(View.GONE);
         linesupbfd.setVisibility(View.GONE);
         secbfdtimeDur.setVisibility(View.GONE);
         linebfdtimeDur.setVisibility(View.GONE);
         seclblsecII11.setVisibility(View.GONE);
         linelblsecII11.setVisibility(View.GONE);
         secbfdtimeDur.setVisibility(View.GONE);
         linebfdtimeDur.setVisibility(View.GONE);
         seclblsecII11.setVisibility(View.GONE);
         linelblsecII11.setVisibility(View.GONE);
         secaltdrinkDOth.setVisibility(View.GONE);
         linealtdrinkDOth.setVisibility(View.GONE);
         seclblsecII13.setVisibility(View.GONE);
         linelblsecII13.setVisibility(View.GONE);
         sechelpbbrthA.setVisibility(View.GONE);
         linehelpbbrthA.setVisibility(View.GONE);
         sechelpbbrthB.setVisibility(View.GONE);
         linehelpbbrthB.setVisibility(View.GONE);
         sechelpbbrthC.setVisibility(View.GONE);
         linehelpbbrthC.setVisibility(View.GONE);
         sechelpbbrthD.setVisibility(View.GONE);
         linehelpbbrthD.setVisibility(View.GONE);
         sechelpbbrthE.setVisibility(View.GONE);
         linehelpbbrthE.setVisibility(View.GONE);
         secbstim.setVisibility(View.GONE);
         linebstim.setVisibility(View.GONE);
         secbplast.setVisibility(View.GONE);
         linebplast.setVisibility(View.GONE);
         secbresustmin.setVisibility(View.GONE);
         linebresustmin.setVisibility(View.GONE);
         secbresustminDur.setVisibility(View.GONE);
         linebresustminDur.setVisibility(View.GONE);
         secbsuc.setVisibility(View.GONE);
         linebsuc.setVisibility(View.GONE);
         secoresusact.setVisibility(View.GONE);
         lineoresusact.setVisibility(View.GONE);
         secoresusactOth.setVisibility(View.GONE);
         lineoresusactOth.setVisibility(View.GONE);
         secbadmward.setVisibility(View.GONE);
         linebadmward.setVisibility(View.GONE);
         sectoldresusexp.setVisibility(View.GONE);
         linetoldresusexp.setVisibility(View.GONE);
         secresusexp.setVisibility(View.GONE);
         lineresusexp.setVisibility(View.GONE);
         secresusexpDK.setVisibility(View.GONE);
         lineresusexpDK.setVisibility(View.GONE);
         //seclblsecII14.setVisibility(View.GONE);
         linelblsecII14.setVisibility(View.GONE);
         seclblsecII13.setVisibility(View.GONE);
         linelblsecII13.setVisibility(View.GONE);
         sechelpbbrthA.setVisibility(View.GONE);
         linehelpbbrthA.setVisibility(View.GONE);
         sechelpbbrthB.setVisibility(View.GONE);
         linehelpbbrthB.setVisibility(View.GONE);
         sechelpbbrthC.setVisibility(View.GONE);
         linehelpbbrthC.setVisibility(View.GONE);
         sechelpbbrthD.setVisibility(View.GONE);
         linehelpbbrthD.setVisibility(View.GONE);
         sechelpbbrthE.setVisibility(View.GONE);
         linehelpbbrthE.setVisibility(View.GONE);
         secbstim.setVisibility(View.GONE);
         linebstim.setVisibility(View.GONE);
         secbplast.setVisibility(View.GONE);
         linebplast.setVisibility(View.GONE);
         secbresustmin.setVisibility(View.GONE);
         linebresustmin.setVisibility(View.GONE);
         secbresustminDur.setVisibility(View.GONE);
         linebresustminDur.setVisibility(View.GONE);
         secbsuc.setVisibility(View.GONE);
         linebsuc.setVisibility(View.GONE);
         secoresusact.setVisibility(View.GONE);
         lineoresusact.setVisibility(View.GONE);
         secoresusactOth.setVisibility(View.GONE);
         lineoresusactOth.setVisibility(View.GONE);
         secbadmward.setVisibility(View.GONE);
         linebadmward.setVisibility(View.GONE);
         sectoldresusexp.setVisibility(View.GONE);
         linetoldresusexp.setVisibility(View.GONE);
         secresusexp.setVisibility(View.GONE);
         lineresusexp.setVisibility(View.GONE);
         secresusexpDK.setVisibility(View.GONE);
         lineresusexpDK.setVisibility(View.GONE);
         //seclblsecII14.setVisibility(View.GONE);
         linelblsecII14.setVisibility(View.GONE);
         secoresusactOth.setVisibility(View.GONE);
         lineoresusactOth.setVisibility(View.GONE);
         secoresusactOth.setVisibility(View.GONE);
         lineoresusactOth.setVisibility(View.GONE);
         secresusexp.setVisibility(View.GONE);
         lineresusexp.setVisibility(View.GONE);
         secresusexpDK.setVisibility(View.GONE);
         lineresusexpDK.setVisibility(View.GONE);
         //seclblsecII14.setVisibility(View.GONE);
         linelblsecII14.setVisibility(View.GONE);
         secresusexp.setVisibility(View.GONE);
         lineresusexp.setVisibility(View.GONE);
         secresusexpDK.setVisibility(View.GONE);
         lineresusexpDK.setVisibility(View.GONE);
         //seclblsecII14.setVisibility(View.GONE);
         linelblsecII14.setVisibility(View.GONE);
         secmedappcord.setVisibility(View.GONE);
         linemedappcord.setVisibility(View.GONE);
         secmedappcordOth.setVisibility(View.GONE);
         linemedappcordOth.setVisibility(View.GONE);
         seclblsecII15.setVisibility(View.GONE);
         linelblsecII15.setVisibility(View.GONE);
         sectimechl.setVisibility(View.GONE);
         linetimechl.setVisibility(View.GONE);
         sectimechlDur.setVisibility(View.GONE);
         linetimechlDur.setVisibility(View.GONE);
         seclblsecII19.setVisibility(View.GONE);
         linelblsecII19.setVisibility(View.GONE);
         secwhoappchl.setVisibility(View.GONE);
         linewhoappchl.setVisibility(View.GONE);
         secwhoappchlOth.setVisibility(View.GONE);
         linewhoappchlOth.setVisibility(View.GONE);
         sectoldchlreas.setVisibility(View.GONE);
         linetoldchlreas.setVisibility(View.GONE);
         secchlreas.setVisibility(View.GONE);
         linechlreas.setVisibility(View.GONE);
         secchlreasDK.setVisibility(View.GONE);
         linechlreasDK.setVisibility(View.GONE);
         secchlhome.setVisibility(View.GONE);
         linechlhome.setVisibility(View.GONE);
         seccomments.setVisibility(View.GONE);
         linecomments.setVisibility(View.GONE);
         secmedappcord.setVisibility(View.GONE);
         linemedappcord.setVisibility(View.GONE);
         secmedappcordOth.setVisibility(View.GONE);
         linemedappcordOth.setVisibility(View.GONE);
         seclblsecII15.setVisibility(View.GONE);
         linelblsecII15.setVisibility(View.GONE);
         sectimechl.setVisibility(View.GONE);
         linetimechl.setVisibility(View.GONE);
         sectimechlDur.setVisibility(View.GONE);
         linetimechlDur.setVisibility(View.GONE);
         seclblsecII19.setVisibility(View.GONE);
         linelblsecII19.setVisibility(View.GONE);
         secwhoappchl.setVisibility(View.GONE);
         linewhoappchl.setVisibility(View.GONE);
         secwhoappchlOth.setVisibility(View.GONE);
         linewhoappchlOth.setVisibility(View.GONE);
         sectoldchlreas.setVisibility(View.GONE);
         linetoldchlreas.setVisibility(View.GONE);
         secchlreas.setVisibility(View.GONE);
         linechlreas.setVisibility(View.GONE);
         secchlreasDK.setVisibility(View.GONE);
         linechlreasDK.setVisibility(View.GONE);
         secchlhome.setVisibility(View.GONE);
         linechlhome.setVisibility(View.GONE);
         seccomments.setVisibility(View.GONE);
         linecomments.setVisibility(View.GONE);
         secmedappcordOth.setVisibility(View.GONE);
         linemedappcordOth.setVisibility(View.GONE);
         seclblsecII15.setVisibility(View.GONE);
         linelblsecII15.setVisibility(View.GONE);
         secmedappcordOth.setVisibility(View.GONE);
         linemedappcordOth.setVisibility(View.GONE);
         seclblsecII15.setVisibility(View.GONE);
         linelblsecII15.setVisibility(View.GONE);
         sectimechl.setVisibility(View.GONE);
         linetimechl.setVisibility(View.GONE);
         sectimechlDur.setVisibility(View.GONE);
         linetimechlDur.setVisibility(View.GONE);
         seclblsecII19.setVisibility(View.GONE);
         linelblsecII19.setVisibility(View.GONE);
         secwhoappchl.setVisibility(View.GONE);
         linewhoappchl.setVisibility(View.GONE);
         secwhoappchlOth.setVisibility(View.GONE);
         linewhoappchlOth.setVisibility(View.GONE);
         sectoldchlreas.setVisibility(View.GONE);
         linetoldchlreas.setVisibility(View.GONE);
         secchlreas.setVisibility(View.GONE);
         linechlreas.setVisibility(View.GONE);
         secchlreasDK.setVisibility(View.GONE);
         linechlreasDK.setVisibility(View.GONE);
         secchlhome.setVisibility(View.GONE);
         linechlhome.setVisibility(View.GONE);
         seccomments.setVisibility(View.GONE);
         linecomments.setVisibility(View.GONE);
         sectimechlDur.setVisibility(View.GONE);
         linetimechlDur.setVisibility(View.GONE);
         seclblsecII19.setVisibility(View.GONE);
         linelblsecII19.setVisibility(View.GONE);
         secwhoappchlOth.setVisibility(View.GONE);
         linewhoappchlOth.setVisibility(View.GONE);
         secwhoappchlOth.setVisibility(View.GONE);
         linewhoappchlOth.setVisibility(View.GONE);
         secwhoappchlOth.setVisibility(View.GONE);
         linewhoappchlOth.setVisibility(View.GONE);
         secwhoappchlOth.setVisibility(View.GONE);
         linewhoappchlOth.setVisibility(View.GONE);
         secchlreas.setVisibility(View.GONE);
         linechlreas.setVisibility(View.GONE);
         secchlreasDK.setVisibility(View.GONE);
         linechlreasDK.setVisibility(View.GONE);
         secchlreas.setVisibility(View.GONE);
         linechlreas.setVisibility(View.GONE);
         secchlreasDK.setVisibility(View.GONE);
         linechlreasDK.setVisibility(View.GONE);

         //********************************sakib start*******************************************
         txtedelivDur.addTextChangedListener(new TextWatcher() {
             @Override
             public void beforeTextChanged(CharSequence s, int start, int count, int after) {

             }

             @Override
             public void onTextChanged(CharSequence s, int start, int before, int count) {

             }

             @Override
             public void afterTextChanged(Editable s) {
                 if(txtedelivDur.getText().length()>0)
                 {
//                     rdogrpedeliv.clearCheck();
                      rdoedeliv4.setChecked(false);

                 }
             }
         });
         rdogrpedeliv.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                 if(checkedId==R.id.rdoedeliv4)
                 {
                     txtedelivDur.setText("");
                 }
             }
         });

          txtacsdoses.addTextChangedListener(new TextWatcher() {
               @Override
               public void beforeTextChanged(CharSequence s, int start, int count, int after) {

               }

               @Override
               public void onTextChanged(CharSequence s, int start, int before, int count) {

               }

               @Override
               public void afterTextChanged(Editable s) {
                    if(txtacsdoses.getText().length()>0)
                    {
                         chkacsdosesDK.setChecked(false);
                    }
               }
          });

          chkacsdosesDK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked)
                    {
                         txtacsdoses.setText("");
                    }
               }
          });

          txtbbathtimeDur.addTextChangedListener(new TextWatcher() {
               @Override
               public void beforeTextChanged(CharSequence s, int start, int count, int after) {

               }

               @Override
               public void onTextChanged(CharSequence s, int start, int before, int count) {

               }

               @Override
               public void afterTextChanged(Editable s) {
                    if(txtbbathtimeDur.getText().length()>0)
                    {
                         rdobbathtime4.setChecked(false);
                    }

               }
          });

          rdogrpbresustmin.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                    if(checkedId==R.id.rdobresustmin2)
                    {
                         txtbresustminDur.setText("");
                    }
               }
          });

          txtbresustminDur.addTextChangedListener(new TextWatcher() {
               @Override
               public void beforeTextChanged(CharSequence s, int start, int count, int after) {

               }

               @Override
               public void onTextChanged(CharSequence s, int start, int before, int count) {

               }

               @Override
               public void afterTextChanged(Editable s) {
                    if(txtbresustminDur.getText().length()>0)
                    {
                         rdobresustmin1.setChecked(true);
                         rdobresustmin2.setChecked(false);
                    }
               }
          });

          txtresusexp.addTextChangedListener(new TextWatcher() {
               @Override
               public void beforeTextChanged(CharSequence s, int start, int count, int after) {

               }

               @Override
               public void onTextChanged(CharSequence s, int start, int before, int count) {

               }

               @Override
               public void afterTextChanged(Editable s) {
                    if(txtresusexp.getText().length()>0)
                    {
                         chkresusexpDK.setChecked(false);
                    }
               }
          });

          chkresusexpDK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked)
                    {
                         txtresusexp.setText("");
                    }
               }
          });

          txtchlreas.addTextChangedListener(new TextWatcher() {
               @Override
               public void beforeTextChanged(CharSequence s, int start, int count, int after) {

               }

               @Override
               public void onTextChanged(CharSequence s, int start, int before, int count) {

               }

               @Override
               public void afterTextChanged(Editable s) {
                    if(txtchlreas.getText().length()>0)
                    {
                         chkchlreasDK.setChecked(false);
                    }
               }
          });

          chkchlreasDK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked)
                    {
                         txtchlreas.setText("");
                    }
               }
          });




         //********************************sakib end*********************************************

         Button btnQ13 = (Button)findViewById(R.id.btnQ13);
         btnQ13.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 IDbundle.putString("varname", "q13");
                 Intent f1 = new Intent(getApplicationContext(),MRS_Photo.class);
                 f1.putExtras(IDbundle);
                 startActivity(f1);
             }});
         Button btnQ22_sii = (Button)findViewById(R.id.btnQ22_sii);
         btnQ22_sii.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 IDbundle.putString("varname", "q22_sii");
                 Intent f1 = new Intent(getApplicationContext(),MRS_Photo.class);
                 f1.putExtras(IDbundle);
                 startActivity(f1);
             }});

         Button cmdSave = (Button) findViewById(R.id.cmdSave);
        cmdSave.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) { 
            DataSave();
        }});
          DataSearch(COUNTRYCODE,FACICODE,DATAID);
     }
     catch(Exception  e)
     {
         Connection.MessageBox(RecallSurvS2.this, e.getMessage());
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
             Connection.MessageBox(RecallSurvS2.this, "Required field: Country Code.");
             txtCountryCode.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtCountryCode.getText().toString().length()==0 ? "1" : txtCountryCode.getText().toString()) < 1 || Integer.valueOf(txtCountryCode.getText().toString().length()==0 ? "3" : txtCountryCode.getText().toString()) > 3)
           {
             Connection.MessageBox(RecallSurvS2.this, "Value should be between 1 and 3(Country Code).");
             txtCountryCode.requestFocus();
             return;
           }
         else if(txtFaciCode.getText().toString().length()==0 & secFaciCode.isShown())
           {
             Connection.MessageBox(RecallSurvS2.this, "Required field: FaciCode.");
             txtFaciCode.requestFocus();
             return;
           }
         else if(Integer.valueOf(txtFaciCode.getText().toString().length()==0 ? "1" : txtFaciCode.getText().toString()) < 1 || Integer.valueOf(txtFaciCode.getText().toString().length()==0 ? "9" : txtFaciCode.getText().toString()) > 9)
           {
             Connection.MessageBox(RecallSurvS2.this, "Value should be between 1 and 9(FaciCode).");
             txtFaciCode.requestFocus();
             return;
           }
         else if(txtDataID.getText().toString().length()==0 & secDataID.isShown())
           {
             Connection.MessageBox(RecallSurvS2.this, "Required field: DataId.");
             txtDataID.requestFocus();
             return;
           }
         else if(txtStudyID.getText().toString().length()==0 & secStudyID.isShown())
           {
             Connection.MessageBox(RecallSurvS2.this, "Required field: ParticipantID.");
             txtStudyID.requestFocus();
             return;
           }

         else if(!rdobb4expect1.isChecked() & !rdobb4expect2.isChecked() & !rdobb4expect3.isChecked() & secbb4expect.isShown())
           {
              Connection.MessageBox(RecallSurvS2.this, "Select anyone options from (Do you know if your baby was born too soon or too early?).");
              rdobb4expect1.requestFocus();
              return;
           }

         else if(!rdoredeliv1.isChecked() & !rdoredeliv2.isChecked() & !rdoredeliv3.isChecked() & secredeliv.isShown())
           {
              Connection.MessageBox(RecallSurvS2.this, "Select anyone options from (a) If No , were you at any point at risk of having your baby born too early?).");
              rdoredeliv1.requestFocus();
              return;
           }

         else if(!rdoedeliv1.isChecked() & !rdoedeliv2.isChecked() & !rdoedeliv3.isChecked() & !rdoedeliv4.isChecked() & secedeliv.isShown())
           {
              Connection.MessageBox(RecallSurvS2.this, "Select anyone options from (b) If YES, how many days/week/months too early?).");
              rdoedeliv1.requestFocus();
              return;
           }
         else if(!rdoedeliv4.isChecked() & secedeliv.isShown())
         {
              if(txtedelivDur.getText().toString().length()==0 & secedelivDur.isShown())
              {
                   Connection.MessageBox(RecallSurvS2.this, "Required field: How many days/week/months too early?.");
                   txtedelivDur.requestFocus();
                   return;
              }
         }
          if(Integer.valueOf(txtedelivDur.getText().toString().length()==0 ? "1" : txtedelivDur.getText().toString()) < 1 || Integer.valueOf(txtedelivDur.getText().toString().length()==0 ? "99" : txtedelivDur.getText().toString()) > 99)
           {
             Connection.MessageBox(RecallSurvS2.this, "Value should be between 1 and 99(How many days/week/months too early?).");
             txtedelivDur.requestFocus();
             return;
           }

         else if(!rdoacsgiven1.isChecked() & !rdoacsgiven2.isChecked() & !rdoacsgiven3.isChecked() & secacsgiven.isShown())
           {
              Connection.MessageBox(RecallSurvS2.this, "Select anyone options from (Were you given any madicine or injection?).");
              rdoacsgiven1.requestFocus();
              return;
           }
         else if(spnacsreason.getSelectedItemPosition()==0  & secacsreason.isShown())
           {
             Connection.MessageBox(RecallSurvS2.this, "Required field: Do you know what the medicine or injection was for?.");
             spnacsreason.requestFocus();
             return;
           }
         else if(txtacsreasonOth.getText().toString().length()==0 & secacsreasonOth.isShown())
           {
             Connection.MessageBox(RecallSurvS2.this, "Required field: Specify.");
             txtacsreasonOth.requestFocus();
             return;
           }
         else if(spnacsname.getSelectedItemPosition()==0  & secacsname.isShown())
           {
             Connection.MessageBox(RecallSurvS2.this, "Required field: What medicine were you given?.");
             spnacsname.requestFocus();
             return;
           }
         else if(txtacsnameOth.getText().toString().length()==0 & secacsnameOth.isShown())
           {
             Connection.MessageBox(RecallSurvS2.this, "Required field: Specify.");
             txtacsnameOth.requestFocus();
             return;
           }
         else if(spnacsroute.getSelectedItemPosition()==0  & secacsroute.isShown())
           {
             Connection.MessageBox(RecallSurvS2.this, "Required field: How was the medicine given?.");
             spnacsroute.requestFocus();
             return;
           }
         else if(txtacsrouteOth.getText().toString().length()==0 & secacsrouteOth.isShown())
           {
             Connection.MessageBox(RecallSurvS2.this, "Required field: Specify.");
             txtacsrouteOth.requestFocus();
             return;
           }
         else if(!chkacsdosesDK.isChecked() & secacsdosesDK.isShown() )
         {
              if(txtacsdoses.getText().toString().length()==0 & secacsdoses.isShown())
              {
                   Connection.MessageBox(RecallSurvS2.this, "Required field: How many times were you given the mdecine?.");
                   txtacsdoses.requestFocus();
                   return;
              }
         }
          if(Integer.valueOf(txtacsdoses.getText().toString().length()==0 ? "1" : txtacsdoses.getText().toString()) < 1 || Integer.valueOf(txtacsdoses.getText().toString().length()==0 ? "99" : txtacsdoses.getText().toString()) > 99)
           {
             Connection.MessageBox(RecallSurvS2.this, "Value should be between 1 and 99(How many times were you given the mdecine?).");
             txtacsdoses.requestFocus(); 
             return;	
           }
         else if(spnacstime.getSelectedItemPosition()==0  & secacstime.isShown())
           {
             Connection.MessageBox(RecallSurvS2.this, "Required field: How long before your baby was born did you receive the last dose/.");
             spnacstime.requestFocus(); 
             return;	
           }
         
         else if(!rdomedadeliv1.isChecked() & !rdomedadeliv2.isChecked() & !rdomedadeliv3.isChecked() & secmedadeliv.isShown())
           {
              Connection.MessageBox(RecallSurvS2.this, "Select anyone options from (Were you given any medicine just after the delivery of your baby?).");
              rdomedadeliv1.requestFocus();
              return;
           }
         else if(spnuterotime.getSelectedItemPosition()==0  & secuterotime.isShown())
           {
             Connection.MessageBox(RecallSurvS2.this, "Required field: When was the injection/tablets given? READ ANSWER CHOICES.");
             spnuterotime.requestFocus(); 
             return;	
           }
         
         else if(!rdouterotold1.isChecked() & !rdouterotold2.isChecked() & !rdouterotold3.isChecked() & secuterotold.isShown())
           {
              Connection.MessageBox(RecallSurvS2.this, "Select anyone options from (Did the health worker tell you that you were going to be given an injection/medication immediately after birth? ).");
              rdouterotold1.requestFocus();
              return;
           }
         
         else if(!rdouteroknow1.isChecked() & !rdouteroknow2.isChecked() & !rdouteroknow3.isChecked() & secuteroknow.isShown())
           {
              Connection.MessageBox(RecallSurvS2.this, "Select anyone options from (Do you know what medication/drug you were given?).");
              rdouteroknow1.requestFocus();
              return;
           }
         else if(txtuteronameDOth.getText().toString().length()==0 & secuteronameDOth.isShown())
           {
             Connection.MessageBox(RecallSurvS2.this, "Required field: Specify.");
             txtuteronameDOth.requestFocus(); 
             return;	
           }
         
         else if(!rdotolduteroreas1.isChecked() & !rdotolduteroreas2.isChecked() & !rdotolduteroreas3.isChecked() & sectolduteroreas.isShown())
           {
              Connection.MessageBox(RecallSurvS2.this, "Select anyone options from (Were you told the reason for the injection? ).");
              rdotolduteroreas1.requestFocus();
              return;
           }
         else if(txtuteroreasOth.getText().toString().length()==0 & secuteroreasOth.isShown())
           {
             Connection.MessageBox(RecallSurvS2.this, "Required field: Specify.");
             txtuteroreasOth.requestFocus(); 
             return;	
           }
         
         else if(!rdobdried1.isChecked() & !rdobdried2.isChecked() & !rdobdried3.isChecked() & secbdried.isShown())
           {
              Connection.MessageBox(RecallSurvS2.this, "Select anyone options from (Was your baby dried or wiped immediately after birth (within a few minutes)? ).");
              rdobdried1.requestFocus();
              return;
           }
         
         else if(!rdobnakchest1.isChecked() & !rdobnakchest2.isChecked() & !rdobnakchest3.isChecked() & secbnakchest.isShown())
           {
              Connection.MessageBox(RecallSurvS2.this, "Select anyone options from (Was your baby placed on your chest, naked against your skin?  PROMPT WITH PICTURE IF NECESSARY).");
              rdobnakchest1.requestFocus();
              return;
           }
         
         else if(!rdobchesttime1.isChecked() & !rdobchesttime2.isChecked() & !rdobchesttime3.isChecked() & secbchesttime.isShown())
           {
              Connection.MessageBox(RecallSurvS2.this, "Select anyone options from (What time was your baby placed against your chest? READ ANSWER CHOICES).");
              rdobchesttime1.requestFocus();
              return;
           }
         else if(txtbchesttimeM.getText().toString().length()==0 & secbchesttimeM.isShown())
           {
             Connection.MessageBox(RecallSurvS2.this, "Required field: Exact Minutes.");
             txtbchesttimeM.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtbchesttimeM.getText().toString().length()==0 ? "1" : txtbchesttimeM.getText().toString()) < 1 || Integer.valueOf(txtbchesttimeM.getText().toString().length()==0 ? "999" : txtbchesttimeM.getText().toString()) > 999)
           {
             Connection.MessageBox(RecallSurvS2.this, "Value should be between 1 and 999(Exact Minutes).");
             txtbchesttimeM.requestFocus(); 
             return;	
           }
         else if(spnbplaced.getSelectedItemPosition()==0  & secbplaced.isShown())
           {
             Connection.MessageBox(RecallSurvS2.this, "Required field: If not placed on your chest, where was your baby put immediately after birth?.");
             spnbplaced.requestFocus(); 
             return;	
           }
         
         else if(!rdobbathtime1.isChecked() & !rdobbathtime2.isChecked() & !rdobbathtime3.isChecked() & !rdobbathtime4.isChecked() & !rdobbathtime5.isChecked() & secbbathtime.isShown())
           {
              Connection.MessageBox(RecallSurvS2.this, "Select anyone options from (How long after the birth was your baby bathed  for the first time?).");
              rdobbathtime1.requestFocus();
              return;
           }
         else if(txtbbathtimeDur.getText().toString().length()==0 & secbbathtimeDur.isShown())
           {
             Connection.MessageBox(RecallSurvS2.this, "Required field: Hours/Days.");
             txtbbathtimeDur.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtbbathtimeDur.getText().toString().length()==0 ? "1" : txtbbathtimeDur.getText().toString()) < 1 || Integer.valueOf(txtbbathtimeDur.getText().toString().length()==0 ? "999" : txtbbathtimeDur.getText().toString()) > 999)
           {
             Connection.MessageBox(RecallSurvS2.this, "Value should be between 1 and 999(Hours/Days).");
             txtbbathtimeDur.requestFocus(); 
             return;	
           }
         
         else if(!rdobbfd1.isChecked() & !rdobbfd2.isChecked() & !rdobbfd3.isChecked() & secbbfd.isShown())
           {
              Connection.MessageBox(RecallSurvS2.this, "Select anyone options from (Did you ever breastfeed your baby?).");
              rdobbfd1.requestFocus();
              return;
           }
         else if(spnbfdtime.getSelectedItemPosition()==0  & secbfdtime.isShown())
           {
             Connection.MessageBox(RecallSurvS2.this, "Required field: How long after birth did you first put your baby to your breast?.");
             spnbfdtime.requestFocus(); 
             return;	
           }
         else if(txtbfdtimeDur.getText().toString().length()==0 & secbfdtimeDur.isShown())
           {
             Connection.MessageBox(RecallSurvS2.this, "Required field: Hours/Days.");
             txtbfdtimeDur.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtbfdtimeDur.getText().toString().length()==0 ? "1" : txtbfdtimeDur.getText().toString()) < 1 || Integer.valueOf(txtbfdtimeDur.getText().toString().length()==0 ? "999" : txtbfdtimeDur.getText().toString()) > 999)
           {
             Connection.MessageBox(RecallSurvS2.this, "Value should be between 1 and 999(Hours/Days).");
             txtbfdtimeDur.requestFocus(); 
             return;	
           }
         
         else if(!rdosupbfd1.isChecked() & !rdosupbfd2.isChecked() & !rdosupbfd3.isChecked() & secsupbfd.isShown())
           {
              Connection.MessageBox(RecallSurvS2.this, "Select anyone options from (Were you given any help to breastfeed from health workers?).");
              rdosupbfd1.requestFocus();
              return;
           }
         else if(txtaltdrinkDOth.getText().toString().length()==0 & secaltdrinkDOth.isShown())
           {
             Connection.MessageBox(RecallSurvS2.this, "Required field: Specify.");
             txtaltdrinkDOth.requestFocus(); 
             return;	
           }
         
         else if(!rdobcry1.isChecked() & !rdobcry2.isChecked() & !rdobcry3.isChecked() & secbcry.isShown())
           {
              Connection.MessageBox(RecallSurvS2.this, "Select anyone options from (Did you hear your baby cry immediately after birth?).");
              rdobcry1.requestFocus();
              return;
           }
         
         else if(!rdobtroubbrth1.isChecked() & !rdobtroubbrth2.isChecked() & !rdobtroubbrth3.isChecked() & secbtroubbrth.isShown())
           {
              Connection.MessageBox(RecallSurvS2.this, "Select anyone options from (Did your baby have trouble breathing at birth? ).");
              rdobtroubbrth1.requestFocus();
              return;
           }
         
         else if(!rdobstim1.isChecked() & !rdobstim2.isChecked() & !rdobstim3.isChecked() & secbstim.isShown())
           {
              Connection.MessageBox(RecallSurvS2.this, "Select anyone options from (Was your baby vigorously rubbed with a cloth or towel or any other stimulation to help to get your baby to breathe?).");
              rdobstim1.requestFocus();
              return;
           }
         
         else if(!rdobplast1.isChecked() & !rdobplast2.isChecked() & !rdobplast3.isChecked() & secbplast.isShown())
           {
              Connection.MessageBox(RecallSurvS2.this, "Select anyone options from (Did anyone use a plastic device to help your baby breathe? PROMPT: SHOW PICTURE OF BAG AND MASK  ).");
              rdobplast1.requestFocus();
              return;
           }
         
         else if(!rdobresustmin1.isChecked() & !rdobresustmin2.isChecked() & secbresustmin.isShown())
           {
              Connection.MessageBox(RecallSurvS2.this, "Select anyone options from (If somebody used a plastic device to help your baby breathe, how long did they use it for? ).");
              rdobresustmin1.requestFocus();
              return;
           }
         else if(!rdobresustmin2.isChecked() & secbresustmin.isShown())
         {
              if(txtbresustminDur.getText().toString().length()==0 & secbresustminDur.isShown())
              {
                   Connection.MessageBox(RecallSurvS2.this, "Required field: Minutes.");
                   txtbresustminDur.requestFocus();
                   return;
              }
         }
          if(Integer.valueOf(txtbresustminDur.getText().toString().length()==0 ? "1" : txtbresustminDur.getText().toString()) < 1 || Integer.valueOf(txtbresustminDur.getText().toString().length()==0 ? "999" : txtbresustminDur.getText().toString()) > 999)
           {
             Connection.MessageBox(RecallSurvS2.this, "Value should be between 1 and 999(Minutes).");
             txtbresustminDur.requestFocus(); 
             return;	
           }
         
         else if(!rdobsuc1.isChecked() & !rdobsuc2.isChecked() & !rdobsuc3.isChecked() & secbsuc.isShown())
           {
              Connection.MessageBox(RecallSurvS2.this, "Select anyone options from (Did anyone perform suction to your baby’s mouth or nose after birth to clean the airways?).");
              rdobsuc1.requestFocus();
              return;
           }
         
         else if(!rdooresusact1.isChecked() & !rdooresusact2.isChecked() & !rdooresusact3.isChecked() & secoresusact.isShown())
           {
              Connection.MessageBox(RecallSurvS2.this, "Select anyone options from (Were any other actions taken by the health worker to help your baby to breathe? ).");
              rdooresusact1.requestFocus();
              return;
           }
         else if(txtoresusactOth.getText().toString().length()==0 & secoresusactOth.isShown())
           {
             Connection.MessageBox(RecallSurvS2.this, "Required field: Specify.");
             txtoresusactOth.requestFocus(); 
             return;	
           }
         
         else if(!rdobadmward1.isChecked() & !rdobadmward2.isChecked() & !rdobadmward3.isChecked() & secbadmward.isShown())
           {
              Connection.MessageBox(RecallSurvS2.this, "Select anyone options from (Was your baby admitted to a neonatal ward after needing help to breathe? PROMPT: I mean to a special ward for monitoring or treatment ).");
              rdobadmward1.requestFocus();
              return;
           }
         /*else if(spntoldresusexp.getSelectedItemPosition()==0  & sectoldresusexp.isShown())
           {
             Connection.MessageBox(RecallSurvS2.this, "Required field: Did any health worker explain what happened to your baby?.");
             spntoldresusexp.requestFocus(); 
             return;	
           }*/
         else if(!rdotoldresusexp1.isChecked() & !rdotoldresusexp2.isChecked() & !rdotoldresusexp3.isChecked() & sectoldresusexp.isShown()) {
              Connection.MessageBox(RecallSurvS2.this, "Required field: Did any health worker explain what happened to your baby?.");
              rdotoldresusexp1.requestFocus();
              return;
          }
         else if(!chkresusexpDK.isChecked() & secresusexp.isShown())
         {
             if(txtresusexp.getText().toString().length()==0 & secresusexp.isShown())
             {
                 Connection.MessageBox(RecallSurvS2.this, "Required field: What were you told happened?.");
                 txtresusexp.requestFocus();
                 return;
             }
         }
         /* if(spnappcord.getSelectedItemPosition()==0  & secappcord.isShown())
           {
             Connection.MessageBox(RecallSurvS2.this, "Required field: After the cord was cut, was anything applied to the stump of the cord at any time?.");
             spnappcord.requestFocus(); 
             return;	
           }*/
         else if(!rdoappcord1.isChecked() & !rdoappcord2.isChecked() & !rdoappcord3.isChecked() & secappcord.isShown()){
              Connection.MessageBox(RecallSurvS2.this, "Required field: After the cord was cut, was anything applied to the stump of the cord at any time?.");
              rdoappcord1.requestFocus();
              return;
          }
         else if(!rdomedappcord1.isChecked() & !rdomedappcord2.isChecked() & !rdomedappcord3.isChecked() & secmedappcord.isShown())
           {
              Connection.MessageBox(RecallSurvS2.this, "Select anyone options from (What was applied to the cord? (Show tube )?).");
              rdomedappcord1.requestFocus();
              return;
           }
         else if(txtmedappcordOth.getText().toString().length()==0 & secmedappcordOth.isShown())
           {
             Connection.MessageBox(RecallSurvS2.this, "Required field: specify.");
             txtmedappcordOth.requestFocus(); 
             return;	
           }
         
         else if(!rdotimechl1.isChecked() & !rdotimechl2.isChecked() & !rdotimechl3.isChecked() & sectimechl.isShown())
           {
              Connection.MessageBox(RecallSurvS2.this, "Select anyone options from (How long after the cord was cut was chlorhexidine first applied? ).");
              rdotimechl1.requestFocus();
              return;
           }
         else if(txttimechlDur.getText().toString().length()==0 & sectimechlDur.isShown())
           {
             Connection.MessageBox(RecallSurvS2.this, "Required field: Hours/Days.");
             txttimechlDur.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txttimechlDur.getText().toString().length()==0 ? "1" : txttimechlDur.getText().toString()) < 1 || Integer.valueOf(txttimechlDur.getText().toString().length()==0 ? "99" : txttimechlDur.getText().toString()) > 99)
           {
             Connection.MessageBox(RecallSurvS2.this, "Value should be between 1 and 99(Hours/Days).");
             txttimechlDur.requestFocus(); 
             return;	
           }
         else if(spnwhoappchl.getSelectedItemPosition()==0  & secwhoappchl.isShown())
           {
             Connection.MessageBox(RecallSurvS2.this, "Required field: If chlorhexidine was applied, who applied the treatment within the last 24hours?.");
             spnwhoappchl.requestFocus(); 
             return;	
           }
         else if(txtwhoappchlOth.getText().toString().length()==0 & secwhoappchlOth.isShown())
           {
             Connection.MessageBox(RecallSurvS2.this, "Required field: Specify.");
             txtwhoappchlOth.requestFocus(); 
             return;	
           }
         /*else if(spntoldchlreas.getSelectedItemPosition()==0  & sectoldchlreas.isShown())
           {
             Connection.MessageBox(RecallSurvS2.this, "Required field: Were you told the reason why the treatment was being applied to the stump?.");
             spntoldchlreas.requestFocus(); 
             return;	
           }*/
         else if(!rdotoldchlreas1.isChecked() & !rdotoldchlreas2.isChecked() & !rdotoldchlreas3.isChecked()  & sectoldchlreas.isShown()){
              Connection.MessageBox(RecallSurvS2.this, "Required field: Were you told the reason why the treatment was being applied to the stump?.");
              rdotoldchlreas1.requestFocus();
              return;

          }
         else if(!chkchlreasDK.isChecked() & secchlreasDK.isShown())
         {
              if(txtchlreas.getText().toString().length()==0 & secchlreas.isShown())
              {
                   Connection.MessageBox(RecallSurvS2.this, "Required field: What was the reason?.");
                   txtchlreas.requestFocus();
                   return;
              }
         }
          /*if(spnchlhome.getSelectedItemPosition()==0  & secchlhome.isShown())
           {
             Connection.MessageBox(RecallSurvS2.this, "Required field: Were you given the medicine to take home?.");
             spnchlhome.requestFocus(); 
             return;	
           }*/

           if(!rdochlhome1.isChecked() & !rdochlhome2.isChecked() & !rdochlhome3.isChecked() & secchlhome.isShown()){
               Connection.MessageBox(RecallSurvS2.this, "Required field: Were you given the medicine to take home?.");
               rdochlhome1.requestFocus();
               return;
           }

         /*else if(txtcomments.getText().toString().length()==0 & seccomments.isShown())
           {
             Connection.MessageBox(RecallSurvS2.this, "Required field: INTERVIEWER COMMENTS.");
             txtcomments.requestFocus(); 
             return;	
           }*/
 
         String SQL = "";
         RadioButton rb;

         RecallSurvS2_DataModel objSave = new RecallSurvS2_DataModel();
         objSave.setCountryCode(txtCountryCode.getText().toString());
         objSave.setFaciCode(txtFaciCode.getText().toString());
         objSave.setDataID(txtDataID.getText().toString());
         objSave.setStudyID(txtStudyID.getText().toString());
         String[] d_rdogrpbb4expect = new String[] {"1","2","9"};
         objSave.setbb4expect("");
         for (int i = 0; i < rdogrpbb4expect.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpbb4expect.getChildAt(i);
             if (rb.isChecked()) objSave.setbb4expect(d_rdogrpbb4expect[i]);
         }

         String[] d_rdogrpredeliv = new String[] {"1","2","9"};
         objSave.setredeliv("");
         for (int i = 0; i < rdogrpredeliv.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpredeliv.getChildAt(i);
             if (rb.isChecked()) objSave.setredeliv(d_rdogrpredeliv[i]);
         }

         String[] d_rdogrpedeliv = new String[] {"1","2","3","9"};
         objSave.setedeliv("");
         for (int i = 0; i < rdogrpedeliv.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpedeliv.getChildAt(i);
             if (rb.isChecked()) objSave.setedeliv(d_rdogrpedeliv[i]);
         }

         objSave.setedelivDur(txtedelivDur.getText().toString());
         String[] d_rdogrpacsgiven = new String[] {"1","2","9"};
         objSave.setacsgiven("");
         for (int i = 0; i < rdogrpacsgiven.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpacsgiven.getChildAt(i);
             if (rb.isChecked()) objSave.setacsgiven(d_rdogrpacsgiven[i]);
         }

         objSave.setacsreason((spnacsreason.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnacsreason.getSelectedItem().toString(), "-")));
         objSave.setacsreasonOth(txtacsreasonOth.getText().toString());
         objSave.setacsname((spnacsname.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnacsname.getSelectedItem().toString(), "-")));
         objSave.setacsnameOth(txtacsnameOth.getText().toString());
         objSave.setacsroute((spnacsroute.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnacsroute.getSelectedItem().toString(), "-")));
         objSave.setacsrouteOth(txtacsrouteOth.getText().toString());
         objSave.setacsdoses(txtacsdoses.getText().toString());
         objSave.setacsdosesDK((chkacsdosesDK.isChecked()?"1":(secacsdosesDK.isShown()?"2":"")));
         objSave.setacstime((spnacstime.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnacstime.getSelectedItem().toString(), "-")));
         String[] d_rdogrpmedadeliv = new String[] {"1","2","9"};
         objSave.setmedadeliv("");
         for (int i = 0; i < rdogrpmedadeliv.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpmedadeliv.getChildAt(i);
             if (rb.isChecked()) objSave.setmedadeliv(d_rdogrpmedadeliv[i]);
         }

         objSave.setuteroroute1((chkuteroroute1.isChecked()?"1":(secuteroroute1.isShown()?"2":"")));
         objSave.setuteroroute2((chkuteroroute2.isChecked()?"1":(secuteroroute2.isShown()?"2":"")));
         objSave.setuteroroute3((chkuteroroute3.isChecked()?"1":(secuteroroute3.isShown()?"2":"")));
         objSave.setuteroroute4((chkuteroroute4.isChecked()?"1":(secuteroroute4.isShown()?"2":"")));
         objSave.setuteroroute5((chkuteroroute5.isChecked()?"1":(secuteroroute5.isShown()?"2":"")));
         objSave.setuterotime((spnuterotime.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnuterotime.getSelectedItem().toString(), "-")));
         String[] d_rdogrputerotold = new String[] {"1","2","9"};
         objSave.setuterotold("");
         for (int i = 0; i < rdogrputerotold.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrputerotold.getChildAt(i);
             if (rb.isChecked()) objSave.setuterotold(d_rdogrputerotold[i]);
         }

         String[] d_rdogrputeroknow = new String[] {"1","2","9"};
         objSave.setuteroknow("");
         for (int i = 0; i < rdogrputeroknow.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrputeroknow.getChildAt(i);
             if (rb.isChecked()) objSave.setuteroknow(d_rdogrputeroknow[i]);
         }

         objSave.setuteronameA((chkuteronameA.isChecked()?"1":(secuteronameA.isShown()?"2":"")));
         objSave.setuteronameB((chkuteronameB.isChecked()?"1":(secuteronameB.isShown()?"2":"")));
         objSave.setuteronameC((chkuteronameC.isChecked()?"1":(secuteronameC.isShown()?"2":"")));
         objSave.setuteronameD((chkuteronameD.isChecked()?"1":(secuteronameD.isShown()?"2":"")));
         objSave.setuteronameDOth(txtuteronameDOth.getText().toString());
         objSave.setuteronameE((chkuteronameE.isChecked()?"1":(secuteronameE.isShown()?"2":"")));
         String[] d_rdogrptolduteroreas = new String[] {"1","2","9"};
         objSave.settolduteroreas("");
         for (int i = 0; i < rdogrptolduteroreas.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrptolduteroreas.getChildAt(i);
             if (rb.isChecked()) objSave.settolduteroreas(d_rdogrptolduteroreas[i]);
         }

         objSave.setuteroreasA((chkuteroreasA.isChecked()?"1":(secuteroreasA.isShown()?"2":"")));
         objSave.setuteroreasB((chkuteroreasB.isChecked()?"1":(secuteroreasB.isShown()?"2":"")));
         objSave.setuteroreasOth(txtuteroreasOth.getText().toString());
         objSave.setuteroreasC((chkuteroreasC.isChecked()?"1":(secuteroreasC.isShown()?"2":"")));
         String[] d_rdogrpbdried = new String[] {"1","2","9"};
         objSave.setbdried("");
         for (int i = 0; i < rdogrpbdried.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpbdried.getChildAt(i);
             if (rb.isChecked()) objSave.setbdried(d_rdogrpbdried[i]);
         }

         String[] d_rdogrpbnakchest = new String[] {"1","2","9"};
         objSave.setbnakchest("");
         for (int i = 0; i < rdogrpbnakchest.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpbnakchest.getChildAt(i);
             if (rb.isChecked()) objSave.setbnakchest(d_rdogrpbnakchest[i]);
         }

         String[] d_rdogrpbchesttime = new String[] {"1","2","9"};
         objSave.setbchesttime("");
         for (int i = 0; i < rdogrpbchesttime.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpbchesttime.getChildAt(i);
             if (rb.isChecked()) objSave.setbchesttime(d_rdogrpbchesttime[i]);
         }

         objSave.setbchesttimeM(txtbchesttimeM.getText().toString());
         objSave.setbplaced((spnbplaced.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnbplaced.getSelectedItem().toString(), "-")));
         String[] d_rdogrpbbathtime = new String[] {"1","2","3","9","4"};
         objSave.setbbathtime("");
         for (int i = 0; i < rdogrpbbathtime.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpbbathtime.getChildAt(i);
             if (rb.isChecked()) objSave.setbbathtime(d_rdogrpbbathtime[i]);
         }

         objSave.setbbathtimeDur(txtbbathtimeDur.getText().toString());
         String[] d_rdogrpbbfd = new String[] {"1","2","9"};
         objSave.setbbfd("");
         for (int i = 0; i < rdogrpbbfd.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpbbfd.getChildAt(i);
             if (rb.isChecked()) objSave.setbbfd(d_rdogrpbbfd[i]);
         }

         objSave.setbfdtime((spnbfdtime.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnbfdtime.getSelectedItem().toString(), "-")));
         objSave.setbfdtimeDur(txtbfdtimeDur.getText().toString());
         String[] d_rdogrpsupbfd = new String[] {"1","2","9"};
         objSave.setsupbfd("");
         for (int i = 0; i < rdogrpsupbfd.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpsupbfd.getChildAt(i);
             if (rb.isChecked()) objSave.setsupbfd(d_rdogrpsupbfd[i]);
         }

         objSave.setaltdrinkA((chkaltdrinkA.isChecked()?"1":(secaltdrinkA.isShown()?"2":"")));
         objSave.setaltdrinkB((chkaltdrinkB.isChecked()?"1":(secaltdrinkB.isShown()?"2":"")));
         objSave.setaltdrinkC((chkaltdrinkC.isChecked()?"1":(secaltdrinkC.isShown()?"2":"")));
         objSave.setaltdrinkD((chkaltdrinkD.isChecked()?"1":(secaltdrinkD.isShown()?"2":"")));
         objSave.setaltdrinkDOth(txtaltdrinkDOth.getText().toString());
         objSave.setaltdrinkE((chkaltdrinkE.isChecked()?"1":(secaltdrinkE.isShown()?"2":"")));
         objSave.setaltdrinkF((chkaltdrinkF.isChecked()?"1":(secaltdrinkF.isShown()?"2":"")));
         String[] d_rdogrpbcry = new String[] {"1","2","9"};
         objSave.setbcry("");
         for (int i = 0; i < rdogrpbcry.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpbcry.getChildAt(i);
             if (rb.isChecked()) objSave.setbcry(d_rdogrpbcry[i]);
         }

         String[] d_rdogrpbtroubbrth = new String[] {"1","2","9"};
         objSave.setbtroubbrth("");
         for (int i = 0; i < rdogrpbtroubbrth.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpbtroubbrth.getChildAt(i);
             if (rb.isChecked()) objSave.setbtroubbrth(d_rdogrpbtroubbrth[i]);
         }

         objSave.sethelpbbrthA((chkhelpbbrthA.isChecked()?"1":(sechelpbbrthA.isShown()?"2":"")));
         objSave.sethelpbbrthB((chkhelpbbrthB.isChecked()?"1":(sechelpbbrthB.isShown()?"2":"")));
         objSave.sethelpbbrthC((chkhelpbbrthC.isChecked()?"1":(sechelpbbrthC.isShown()?"2":"")));
         objSave.sethelpbbrthD((chkhelpbbrthD.isChecked()?"1":(sechelpbbrthD.isShown()?"2":"")));
         objSave.sethelpbbrthE((chkhelpbbrthE.isChecked()?"1":(sechelpbbrthE.isShown()?"2":"")));
         String[] d_rdogrpbstim = new String[] {"1","2","9"};
         objSave.setbstim("");
         for (int i = 0; i < rdogrpbstim.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpbstim.getChildAt(i);
             if (rb.isChecked()) objSave.setbstim(d_rdogrpbstim[i]);
         }

         String[] d_rdogrpbplast = new String[] {"1","2","9"};
         objSave.setbplast("");
         for (int i = 0; i < rdogrpbplast.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpbplast.getChildAt(i);
             if (rb.isChecked()) objSave.setbplast(d_rdogrpbplast[i]);
         }

         String[] d_rdogrpbresustmin = new String[] {"1","9"};
         objSave.setbresustmin("");
         for (int i = 0; i < rdogrpbresustmin.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpbresustmin.getChildAt(i);
             if (rb.isChecked()) objSave.setbresustmin(d_rdogrpbresustmin[i]);
         }

         objSave.setbresustminDur(txtbresustminDur.getText().toString());
         String[] d_rdogrpbsuc = new String[] {"1","2","9"};
         objSave.setbsuc("");
         for (int i = 0; i < rdogrpbsuc.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpbsuc.getChildAt(i);
             if (rb.isChecked()) objSave.setbsuc(d_rdogrpbsuc[i]);
         }

         String[] d_rdogrporesusact = new String[] {"1","2","9"};
         objSave.setoresusact("");
         for (int i = 0; i < rdogrporesusact.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrporesusact.getChildAt(i);
             if (rb.isChecked()) objSave.setoresusact(d_rdogrporesusact[i]);
         }

         objSave.setoresusactOth(txtoresusactOth.getText().toString());
         String[] d_rdogrpbadmward = new String[] {"1","2","9"};
         objSave.setbadmward("");
         for (int i = 0; i < rdogrpbadmward.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpbadmward.getChildAt(i);
             if (rb.isChecked()) objSave.setbadmward(d_rdogrpbadmward[i]);
         }

        // objSave.settoldresusexp((spntoldresusexp.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spntoldresusexp.getSelectedItem().toString(), "-")));
         String[] d_rdogrptoldresusexp = new String[] {"1","2","9"};
         objSave.settoldresusexp("");
         for (int i = 0; i < rdogrptoldresusexp.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrptoldresusexp.getChildAt(i);
             if (rb.isChecked()) objSave.settoldresusexp(d_rdogrptoldresusexp[i]);
         }

         objSave.setresusexp(txtresusexp.getText().toString());
         objSave.setresusexpDK((chkresusexpDK.isChecked()?"1":(secresusexpDK.isShown()?"2":"")));
         //objSave.setappcord((spnappcord.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnappcord.getSelectedItem().toString(), "-")));
         String[] d_rdogrpappcord = new String[] {"1","2","9"};
         objSave.setappcord("");
         for (int i = 0; i < rdogrpappcord.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpappcord.getChildAt(i);
             if (rb.isChecked()) objSave.setappcord(d_rdogrpappcord[i]);
         }


         String[] d_rdogrpmedappcord = new String[] {"1","2","9"};
         objSave.setmedappcord("");
         for (int i = 0; i < rdogrpmedappcord.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpmedappcord.getChildAt(i);
             if (rb.isChecked()) objSave.setmedappcord(d_rdogrpmedappcord[i]);
         }

         objSave.setmedappcordOth(txtmedappcordOth.getText().toString());
         String[] d_rdogrptimechl = new String[] {"1","2","9"};
         objSave.settimechl("");
         for (int i = 0; i < rdogrptimechl.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrptimechl.getChildAt(i);
             if (rb.isChecked()) objSave.settimechl(d_rdogrptimechl[i]);
         }

         objSave.settimechlDur(txttimechlDur.getText().toString());
         objSave.setwhoappchl((spnwhoappchl.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnwhoappchl.getSelectedItem().toString(), "-")));
         objSave.setwhoappchlOth(txtwhoappchlOth.getText().toString());
         //objSave.settoldchlreas((spntoldchlreas.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spntoldchlreas.getSelectedItem().toString(), "-")));
         String[] d_rdogrptoldchlreas = new String[] {"1","2","9"};
         objSave.settoldchlreas("");
         for (int i = 0; i < rdogrptoldchlreas.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrptoldchlreas.getChildAt(i);
             if (rb.isChecked()) objSave.settoldchlreas(d_rdogrptoldchlreas[i]);
         }

         objSave.setchlreas(txtchlreas.getText().toString());
         objSave.setchlreasDK((chkchlreasDK.isChecked()?"1":(secchlreasDK.isShown()?"2":"")));
         //objSave.setchlhome((spnchlhome.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnchlhome.getSelectedItem().toString(), "-")));
         String[] d_rdogrpchlhome = new String[] {"1","2","9"};
         objSave.setchlhome("");
         for (int i = 0; i < rdogrpchlhome.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpchlhome.getChildAt(i);
             if (rb.isChecked()) objSave.setchlhome(d_rdogrpchlhome[i]);
         }

         objSave.setcomments(txtcomments.getText().toString());
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

             Connection.MessageBoxNotClose(RecallSurvS2.this, "Saved Successfully");
         }
         else{
             Connection.MessageBox(RecallSurvS2.this, status);
             return;
         }
     }
     catch(Exception  e)
     {
         Connection.MessageBox(RecallSurvS2.this, e.getMessage());
         return;
     }
 }

 private void DataSearch(String CountryCode, String FaciCode, String DataID)
     {
       try
        {
     
           RadioButton rb;
           RecallSurvS2_DataModel d = new RecallSurvS2_DataModel();
           String SQL = "Select * from "+ TableName +"  Where CountryCode='"+ CountryCode +"' and FaciCode='"+ FaciCode +"' and DataID='"+ DataID +"'";
           List<RecallSurvS2_DataModel> data = d.SelectAll(this, SQL);
           for(RecallSurvS2_DataModel item : data){
             txtCountryCode.setText(item.getCountryCode());
             txtFaciCode.setText(item.getFaciCode());
             txtDataID.setText(item.getDataID());
             txtStudyID.setText(item.getStudyID());
             String[] d_rdogrpbb4expect = new String[] {"1","2","9"};
             for (int i = 0; i < d_rdogrpbb4expect.length; i++)
             {
                 if (item.getbb4expect().equals(String.valueOf(d_rdogrpbb4expect[i])))
                 {
                     rb = (RadioButton)rdogrpbb4expect.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpredeliv = new String[] {"1","2","9"};
             for (int i = 0; i < d_rdogrpredeliv.length; i++)
             {
                 if (item.getredeliv().equals(String.valueOf(d_rdogrpredeliv[i])))
                 {
                     rb = (RadioButton)rdogrpredeliv.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpedeliv = new String[] {"1","2","3","9"};
             for (int i = 0; i < d_rdogrpedeliv.length; i++)
             {
                 if (item.getedeliv().equals(String.valueOf(d_rdogrpedeliv[i])))
                 {
                     rb = (RadioButton)rdogrpedeliv.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtedelivDur.setText(item.getedelivDur());
             String[] d_rdogrpacsgiven = new String[] {"1","2","9"};
             for (int i = 0; i < d_rdogrpacsgiven.length; i++)
             {
                 if (item.getacsgiven().equals(String.valueOf(d_rdogrpacsgiven[i])))
                 {
                     rb = (RadioButton)rdogrpacsgiven.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             spnacsreason.setSelection(Global.SpinnerItemPositionAnyLength(spnacsreason, item.getacsreason()));
             txtacsreasonOth.setText(item.getacsreasonOth());
             spnacsname.setSelection(Global.SpinnerItemPositionAnyLength(spnacsname, item.getacsname()));
             txtacsnameOth.setText(item.getacsnameOth());
             spnacsroute.setSelection(Global.SpinnerItemPositionAnyLength(spnacsroute, item.getacsroute()));
             txtacsrouteOth.setText(item.getacsrouteOth());
             txtacsdoses.setText(item.getacsdoses());
             if(item.getacsdosesDK().equals("1"))
             {
                chkacsdosesDK.setChecked(true);
             }
             else if(item.getacsdosesDK().equals("2"))
             {
                chkacsdosesDK.setChecked(false);
             }
             spnacstime.setSelection(Global.SpinnerItemPositionAnyLength(spnacstime, item.getacstime()));
             String[] d_rdogrpmedadeliv = new String[] {"1","2","9"};
             for (int i = 0; i < d_rdogrpmedadeliv.length; i++)
             {
                 if (item.getmedadeliv().equals(String.valueOf(d_rdogrpmedadeliv[i])))
                 {
                     rb = (RadioButton)rdogrpmedadeliv.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             if(item.getuteroroute1().equals("1"))
             {
                chkuteroroute1.setChecked(true);
             }
             else if(item.getuteroroute1().equals("2"))
             {
                chkuteroroute1.setChecked(false);
             }
             if(item.getuteroroute2().equals("1"))
             {
                chkuteroroute2.setChecked(true);
             }
             else if(item.getuteroroute2().equals("2"))
             {
                chkuteroroute2.setChecked(false);
             }
             if(item.getuteroroute3().equals("1"))
             {
                chkuteroroute3.setChecked(true);
             }
             else if(item.getuteroroute3().equals("2"))
             {
                chkuteroroute3.setChecked(false);
             }
             if(item.getuteroroute4().equals("1"))
             {
                chkuteroroute4.setChecked(true);
             }
             else if(item.getuteroroute4().equals("2"))
             {
                chkuteroroute4.setChecked(false);
             }
             if(item.getuteroroute5().equals("1"))
             {
                chkuteroroute5.setChecked(true);
             }
             else if(item.getuteroroute5().equals("2"))
             {
                chkuteroroute5.setChecked(false);
             }
             spnuterotime.setSelection(Global.SpinnerItemPositionAnyLength(spnuterotime, item.getuterotime()));
             String[] d_rdogrputerotold = new String[] {"1","2","9"};
             for (int i = 0; i < d_rdogrputerotold.length; i++)
             {
                 if (item.getuterotold().equals(String.valueOf(d_rdogrputerotold[i])))
                 {
                     rb = (RadioButton)rdogrputerotold.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrputeroknow = new String[] {"1","2","9"};
             for (int i = 0; i < d_rdogrputeroknow.length; i++)
             {
                 if (item.getuteroknow().equals(String.valueOf(d_rdogrputeroknow[i])))
                 {
                     rb = (RadioButton)rdogrputeroknow.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             if(item.getuteronameA().equals("1"))
             {
                chkuteronameA.setChecked(true);
             }
             else if(item.getuteronameA().equals("2"))
             {
                chkuteronameA.setChecked(false);
             }
             if(item.getuteronameB().equals("1"))
             {
                chkuteronameB.setChecked(true);
             }
             else if(item.getuteronameB().equals("2"))
             {
                chkuteronameB.setChecked(false);
             }
             if(item.getuteronameC().equals("1"))
             {
                chkuteronameC.setChecked(true);
             }
             else if(item.getuteronameC().equals("2"))
             {
                chkuteronameC.setChecked(false);
             }
             if(item.getuteronameD().equals("1"))
             {
                chkuteronameD.setChecked(true);
             }
             else if(item.getuteronameD().equals("2"))
             {
                chkuteronameD.setChecked(false);
             }
             txtuteronameDOth.setText(item.getuteronameDOth());
             if(item.getuteronameE().equals("1"))
             {
                chkuteronameE.setChecked(true);
             }
             else if(item.getuteronameE().equals("2"))
             {
                chkuteronameE.setChecked(false);
             }
             String[] d_rdogrptolduteroreas = new String[] {"1","2","9"};
             for (int i = 0; i < d_rdogrptolduteroreas.length; i++)
             {
                 if (item.gettolduteroreas().equals(String.valueOf(d_rdogrptolduteroreas[i])))
                 {
                     rb = (RadioButton)rdogrptolduteroreas.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             if(item.getuteroreasA().equals("1"))
             {
                chkuteroreasA.setChecked(true);
             }
             else if(item.getuteroreasA().equals("2"))
             {
                chkuteroreasA.setChecked(false);
             }
             if(item.getuteroreasB().equals("1"))
             {
                chkuteroreasB.setChecked(true);
             }
             else if(item.getuteroreasB().equals("2"))
             {
                chkuteroreasB.setChecked(false);
             }
             txtuteroreasOth.setText(item.getuteroreasOth());
             if(item.getuteroreasC().equals("1"))
             {
                chkuteroreasC.setChecked(true);
             }
             else if(item.getuteroreasC().equals("2"))
             {
                chkuteroreasC.setChecked(false);
             }
             String[] d_rdogrpbdried = new String[] {"1","2","9"};
             for (int i = 0; i < d_rdogrpbdried.length; i++)
             {
                 if (item.getbdried().equals(String.valueOf(d_rdogrpbdried[i])))
                 {
                     rb = (RadioButton)rdogrpbdried.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpbnakchest = new String[] {"1","2","9"};
             for (int i = 0; i < d_rdogrpbnakchest.length; i++)
             {
                 if (item.getbnakchest().equals(String.valueOf(d_rdogrpbnakchest[i])))
                 {
                     rb = (RadioButton)rdogrpbnakchest.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpbchesttime = new String[] {"1","2","9"};
             for (int i = 0; i < d_rdogrpbchesttime.length; i++)
             {
                 if (item.getbchesttime().equals(String.valueOf(d_rdogrpbchesttime[i])))
                 {
                     rb = (RadioButton)rdogrpbchesttime.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtbchesttimeM.setText(item.getbchesttimeM());
             spnbplaced.setSelection(Global.SpinnerItemPositionAnyLength(spnbplaced, item.getbplaced()));
             String[] d_rdogrpbbathtime = new String[] {"1","2","3","9","4"};
             for (int i = 0; i < d_rdogrpbbathtime.length; i++)
             {
                 if (item.getbbathtime().equals(String.valueOf(d_rdogrpbbathtime[i])))
                 {
                     rb = (RadioButton)rdogrpbbathtime.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtbbathtimeDur.setText(item.getbbathtimeDur());
             String[] d_rdogrpbbfd = new String[] {"1","2","9"};
             for (int i = 0; i < d_rdogrpbbfd.length; i++)
             {
                 if (item.getbbfd().equals(String.valueOf(d_rdogrpbbfd[i])))
                 {
                     rb = (RadioButton)rdogrpbbfd.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             spnbfdtime.setSelection(Global.SpinnerItemPositionAnyLength(spnbfdtime, item.getbfdtime()));
             txtbfdtimeDur.setText(item.getbfdtimeDur());
             String[] d_rdogrpsupbfd = new String[] {"1","2","9"};
             for (int i = 0; i < d_rdogrpsupbfd.length; i++)
             {
                 if (item.getsupbfd().equals(String.valueOf(d_rdogrpsupbfd[i])))
                 {
                     rb = (RadioButton)rdogrpsupbfd.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             if(item.getaltdrinkA().equals("1"))
             {
                chkaltdrinkA.setChecked(true);
             }
             else if(item.getaltdrinkA().equals("2"))
             {
                chkaltdrinkA.setChecked(false);
             }
             if(item.getaltdrinkB().equals("1"))
             {
                chkaltdrinkB.setChecked(true);
             }
             else if(item.getaltdrinkB().equals("2"))
             {
                chkaltdrinkB.setChecked(false);
             }
             if(item.getaltdrinkC().equals("1"))
             {
                chkaltdrinkC.setChecked(true);
             }
             else if(item.getaltdrinkC().equals("2"))
             {
                chkaltdrinkC.setChecked(false);
             }
             if(item.getaltdrinkD().equals("1"))
             {
                chkaltdrinkD.setChecked(true);
             }
             else if(item.getaltdrinkD().equals("2"))
             {
                chkaltdrinkD.setChecked(false);
             }
             txtaltdrinkDOth.setText(item.getaltdrinkDOth());
             if(item.getaltdrinkE().equals("1"))
             {
                chkaltdrinkE.setChecked(true);
             }
             else if(item.getaltdrinkE().equals("2"))
             {
                chkaltdrinkE.setChecked(false);
             }
             if(item.getaltdrinkF().equals("1"))
             {
                chkaltdrinkF.setChecked(true);
             }
             else if(item.getaltdrinkF().equals("2"))
             {
                chkaltdrinkF.setChecked(false);
             }
             String[] d_rdogrpbcry = new String[] {"1","2","9"};
             for (int i = 0; i < d_rdogrpbcry.length; i++)
             {
                 if (item.getbcry().equals(String.valueOf(d_rdogrpbcry[i])))
                 {
                     rb = (RadioButton)rdogrpbcry.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpbtroubbrth = new String[] {"1","2","9"};
             for (int i = 0; i < d_rdogrpbtroubbrth.length; i++)
             {
                 if (item.getbtroubbrth().equals(String.valueOf(d_rdogrpbtroubbrth[i])))
                 {
                     rb = (RadioButton)rdogrpbtroubbrth.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             if(item.gethelpbbrthA().equals("1"))
             {
                chkhelpbbrthA.setChecked(true);
             }
             else if(item.gethelpbbrthA().equals("2"))
             {
                chkhelpbbrthA.setChecked(false);
             }
             if(item.gethelpbbrthB().equals("1"))
             {
                chkhelpbbrthB.setChecked(true);
             }
             else if(item.gethelpbbrthB().equals("2"))
             {
                chkhelpbbrthB.setChecked(false);
             }
             if(item.gethelpbbrthC().equals("1"))
             {
                chkhelpbbrthC.setChecked(true);
             }
             else if(item.gethelpbbrthC().equals("2"))
             {
                chkhelpbbrthC.setChecked(false);
             }
             if(item.gethelpbbrthD().equals("1"))
             {
                chkhelpbbrthD.setChecked(true);
             }
             else if(item.gethelpbbrthD().equals("2"))
             {
                chkhelpbbrthD.setChecked(false);
             }
             if(item.gethelpbbrthE().equals("1"))
             {
                chkhelpbbrthE.setChecked(true);
             }
             else if(item.gethelpbbrthE().equals("2"))
             {
                chkhelpbbrthE.setChecked(false);
             }
             String[] d_rdogrpbstim = new String[] {"1","2","9"};
             for (int i = 0; i < d_rdogrpbstim.length; i++)
             {
                 if (item.getbstim().equals(String.valueOf(d_rdogrpbstim[i])))
                 {
                     rb = (RadioButton)rdogrpbstim.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpbplast = new String[] {"1","2","9"};
             for (int i = 0; i < d_rdogrpbplast.length; i++)
             {
                 if (item.getbplast().equals(String.valueOf(d_rdogrpbplast[i])))
                 {
                     rb = (RadioButton)rdogrpbplast.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpbresustmin = new String[] {"1","9"};
             for (int i = 0; i < d_rdogrpbresustmin.length; i++)
             {
                 if (item.getbresustmin().equals(String.valueOf(d_rdogrpbresustmin[i])))
                 {
                     rb = (RadioButton)rdogrpbresustmin.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtbresustminDur.setText(item.getbresustminDur());
             String[] d_rdogrpbsuc = new String[] {"1","2","9"};
             for (int i = 0; i < d_rdogrpbsuc.length; i++)
             {
                 if (item.getbsuc().equals(String.valueOf(d_rdogrpbsuc[i])))
                 {
                     rb = (RadioButton)rdogrpbsuc.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrporesusact = new String[] {"1","2","9"};
             for (int i = 0; i < d_rdogrporesusact.length; i++)
             {
                 if (item.getoresusact().equals(String.valueOf(d_rdogrporesusact[i])))
                 {
                     rb = (RadioButton)rdogrporesusact.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtoresusactOth.setText(item.getoresusactOth());
             String[] d_rdogrpbadmward = new String[] {"1","2","9"};
             for (int i = 0; i < d_rdogrpbadmward.length; i++)
             {
                 if (item.getbadmward().equals(String.valueOf(d_rdogrpbadmward[i])))
                 {
                     rb = (RadioButton)rdogrpbadmward.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             //spntoldresusexp.setSelection(Global.SpinnerItemPositionAnyLength(spntoldresusexp, item.gettoldresusexp()));
               String[] d_rdogrptoldresusexp = new String[] {"1","2","9"};
               for (int i = 0; i < d_rdogrptoldresusexp.length; i++)
               {
                   if (item.gettoldresusexp().equals(String.valueOf(d_rdogrptoldresusexp[i])))
                   {
                       rb = (RadioButton)rdogrptoldresusexp.getChildAt(i);
                       rb.setChecked(true);
                   }
               }

             txtresusexp.setText(item.getresusexp());
             if(item.getresusexpDK().equals("1"))
             {
                chkresusexpDK.setChecked(true);
             }
             else if(item.getresusexpDK().equals("2"))
             {
                chkresusexpDK.setChecked(false);
             }
             //spnappcord.setSelection(Global.SpinnerItemPositionAnyLength(spnappcord, item.getappcord()));
               String[] d_rdogrpappcord = new String[] {"1","2","9"};
               for (int i = 0; i < d_rdogrpappcord.length; i++)
               {
                   if (item.getappcord().equals(String.valueOf(d_rdogrpappcord[i])))
                   {
                       rb = (RadioButton)rdogrpappcord.getChildAt(i);
                       rb.setChecked(true);
                   }
               }


             String[] d_rdogrpmedappcord = new String[] {"1","2","9"};
             for (int i = 0; i < d_rdogrpmedappcord.length; i++)
             {
                 if (item.getmedappcord().equals(String.valueOf(d_rdogrpmedappcord[i])))
                 {
                     rb = (RadioButton)rdogrpmedappcord.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtmedappcordOth.setText(item.getmedappcordOth());
             String[] d_rdogrptimechl = new String[] {"1","2","9"};
             for (int i = 0; i < d_rdogrptimechl.length; i++)
             {
                 if (item.gettimechl().equals(String.valueOf(d_rdogrptimechl[i])))
                 {
                     rb = (RadioButton)rdogrptimechl.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txttimechlDur.setText(item.gettimechlDur());
             spnwhoappchl.setSelection(Global.SpinnerItemPositionAnyLength(spnwhoappchl, item.getwhoappchl()));
             txtwhoappchlOth.setText(item.getwhoappchlOth());
             //spntoldchlreas.setSelection(Global.SpinnerItemPositionAnyLength(spntoldchlreas, item.gettoldchlreas()));
               String[] d_rdogrptoldchlreas = new String[] {"1","2","9"};
               for (int i = 0; i < d_rdogrptoldchlreas.length; i++)
               {
                   if (item.gettoldchlreas().equals(String.valueOf(d_rdogrptoldchlreas[i])))
                   {
                       rb = (RadioButton)rdogrptoldchlreas.getChildAt(i);
                       rb.setChecked(true);
                   }
               }

             txtchlreas.setText(item.getchlreas());
             if(item.getchlreasDK().equals("1"))
             {
                chkchlreasDK.setChecked(true);
             }
             else if(item.getchlreasDK().equals("2"))
             {
                chkchlreasDK.setChecked(false);
             }
             //spnchlhome.setSelection(Global.SpinnerItemPositionAnyLength(spnchlhome, item.getchlhome()));
               String[] d_rdogrpchlhome = new String[] {"1","2","9"};
               for (int i = 0; i < d_rdogrpchlhome.length; i++)
               {
                   if (item.getchlhome().equals(String.valueOf(d_rdogrpchlhome[i])))
                   {
                       rb = (RadioButton)rdogrpchlhome.getChildAt(i);
                       rb.setChecked(true);
                   }
               }

             txtcomments.setText(item.getcomments());
           }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(RecallSurvS2.this, e.getMessage());
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