
 package org.icddrb.enap;


 //Android Manifest Code
 //<activity android:name=".KMC_Init" android:label="KMC_Init" />
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
 import android.view.WindowManager;
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

 public class KMC_Init extends Activity {
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
         LinearLayout seclbl1;
         View linelbl1;
         LinearLayout seclbl2;
         View linelbl2;

        RadioGroup rdogrpkmcinit;
        RadioButton rdokmcinit1;
        RadioButton rdokmcinit2;
        RadioButton rdokmcinit3;

         LinearLayout secinitDate;
         View lineinitDate;
         TextView VlblinitDate;
         EditText dtpinitDate;
         LinearLayout secinitTime;
         View lineinitTime;
         TextView VlblinitTime;
         EditText txtinitTime;
         LinearLayout seckmced;
         View linekmced;
         TextView Vlblkmced;
         RadioGroup rdogrpkmced;
         
         RadioButton rdokmced1;
         RadioButton rdokmced2;
         RadioButton rdokmced3;
         LinearLayout seckmcpos1;
         View linekmcpos1;
         TextView Vlblkmcpos1;
         RadioGroup rdogrpkmcpos1;
         
         RadioButton rdokmcpos11;
         RadioButton rdokmcpos12;
         RadioButton rdokmcpos13;
         LinearLayout secbhat;
         View linebhat;
         TextView Vlblbhat;
         RadioGroup rdogrpbhat;
         
         RadioButton rdobhat1;
         RadioButton rdobhat2;
         RadioButton rdobhat3;
         LinearLayout secbvertcl;
         View linebvertcl;
         TextView Vlblbvertcl;
         RadioGroup rdogrpbvertcl;
         
         RadioButton rdobvertcl1;
         RadioButton rdobvertcl2;
         RadioButton rdobvertcl3;
         LinearLayout secbnakchest;
         View linebnakchest;
         TextView Vlblbnakchest;
         RadioGroup rdogrpbnakchest;
         
         RadioButton rdobnakchest1;
         RadioButton rdobnakchest2;
         RadioButton rdobnakchest3;
         LinearLayout secbfrog;
         View linebfrog;
         TextView Vlblbfrog;
         RadioGroup rdogrpbfrog;
         
         RadioButton rdobfrog1;
         RadioButton rdobfrog2;
         RadioButton rdobfrog3;
         LinearLayout secbcheek;
         View linebcheek;
         TextView Vlblbcheek;
         RadioGroup rdogrpbcheek;
         
         RadioButton rdobcheek1;
         RadioButton rdobcheek2;
         RadioButton rdobcheek3;
         LinearLayout secbnap;
         View linebnap;
         TextView Vlblbnap;
         RadioGroup rdogrpbnap;
         
         RadioButton rdobnap1;
         RadioButton rdobnap2;
         RadioButton rdobnap3;
         LinearLayout secbfixed;
         View linebfixed;
         TextView Vlblbfixed;
         RadioGroup rdogrpbfixed;
         
         RadioButton rdobfixed1;
         RadioButton rdobfixed2;
         RadioButton rdobfixed3;
         LinearLayout secbfixedOth;
         View linebfixedOth;
         TextView VlblbfixedOth;
         EditText txtbfixedOth;

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
         setContentView(R.layout.kmc_init);
         C = new Connection(this);
         g = Global.getInstance();
         getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

         STARTTIME = g.CurrentTime24();
         DEVICEID    = sp.getValue(this, "deviceid");
         ENTRYUSER   = sp.getValue(this, "userid");
         COUNTRYCODE = sp.getValue(this, "countrycode");
         FACICODE    = sp.getValue(this, "facicode");

         IDbundle = getIntent().getExtras();
         DATAID = IDbundle.getString("dataid");

         TableName = "KMC_Init";

         //turnGPSOn();

         //GPS Location
         //FindLocation();
         // Double.toString(currentLatitude);
         // Double.toString(currentLongitude);
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(KMC_Init.this);
                 adb.setTitle("Close");
                 adb.setMessage("Do you want to close this form[Yes/No]?");
                 adb.setNegativeButton("No", null);
                 adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                     public void onClick(DialogInterface dialog, int which) {
                         finish();
                     }});
                 adb.show();
             }});

         rdogrpkmcinit=(RadioGroup)findViewById(R.id.rdogrpkmcinit) ;
         rdokmcinit1=(RadioButton)findViewById(R.id.rdokmcinit1) ;
         rdokmcinit2=(RadioButton)findViewById(R.id.rdokmcinit2) ;
         rdokmcinit3=(RadioButton)findViewById(R.id.rdokmcinit3) ;

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
         secStudyID=(LinearLayout)findViewById(R.id.secStudyID);
         lineStudyID=(View)findViewById(R.id.lineStudyID);
         VlblStudyID=(TextView) findViewById(R.id.VlblStudyID);
         txtStudyID=(EditText) findViewById(R.id.txtStudyID);
         seclbl1=(LinearLayout)findViewById(R.id.seclbl1);
         linelbl1=(View)findViewById(R.id.linelbl1);
         seclbl2=(LinearLayout)findViewById(R.id.seclbl2);
         linelbl2=(View)findViewById(R.id.linelbl2);
         secinitDate=(LinearLayout)findViewById(R.id.secinitDate);
         lineinitDate=(View)findViewById(R.id.lineinitDate);
         VlblinitDate=(TextView) findViewById(R.id.VlblinitDate);
         dtpinitDate=(EditText) findViewById(R.id.dtpinitDate);
         dtpinitDate.setText(Global.DateNowDMY());
         secinitTime=(LinearLayout)findViewById(R.id.secinitTime);
         lineinitTime=(View)findViewById(R.id.lineinitTime);
         VlblinitTime=(TextView) findViewById(R.id.VlblinitTime);
         txtinitTime=(EditText) findViewById(R.id.txtinitTime);
         txtinitTime.setText(g.CurrentTime24());
         seckmced=(LinearLayout)findViewById(R.id.seckmced);
         linekmced=(View)findViewById(R.id.linekmced);
         Vlblkmced = (TextView) findViewById(R.id.Vlblkmced);
         rdogrpkmced = (RadioGroup) findViewById(R.id.rdogrpkmced);
         
         rdokmced1 = (RadioButton) findViewById(R.id.rdokmced1);
         rdokmced2 = (RadioButton) findViewById(R.id.rdokmced2);
         rdokmced3 = (RadioButton) findViewById(R.id.rdokmced3);
         seckmcpos1=(LinearLayout)findViewById(R.id.seckmcpos1);
         linekmcpos1=(View)findViewById(R.id.linekmcpos1);
         Vlblkmcpos1 = (TextView) findViewById(R.id.Vlblkmcpos1);
         rdogrpkmcpos1 = (RadioGroup) findViewById(R.id.rdogrpkmcpos1);
         
         rdokmcpos11 = (RadioButton) findViewById(R.id.rdokmcpos11);
         rdokmcpos12 = (RadioButton) findViewById(R.id.rdokmcpos12);
         rdokmcpos13 = (RadioButton) findViewById(R.id.rdokmcpos13);
         secbhat=(LinearLayout)findViewById(R.id.secbhat);
         linebhat=(View)findViewById(R.id.linebhat);
         Vlblbhat = (TextView) findViewById(R.id.Vlblbhat);
         rdogrpbhat = (RadioGroup) findViewById(R.id.rdogrpbhat);
         
         rdobhat1 = (RadioButton) findViewById(R.id.rdobhat1);
         rdobhat2 = (RadioButton) findViewById(R.id.rdobhat2);
         rdobhat3 = (RadioButton) findViewById(R.id.rdobhat3);
         secbvertcl=(LinearLayout)findViewById(R.id.secbvertcl);
         linebvertcl=(View)findViewById(R.id.linebvertcl);
         Vlblbvertcl = (TextView) findViewById(R.id.Vlblbvertcl);
         rdogrpbvertcl = (RadioGroup) findViewById(R.id.rdogrpbvertcl);
         
         rdobvertcl1 = (RadioButton) findViewById(R.id.rdobvertcl1);
         rdobvertcl2 = (RadioButton) findViewById(R.id.rdobvertcl2);
         rdobvertcl3 = (RadioButton) findViewById(R.id.rdobvertcl3);
         secbnakchest=(LinearLayout)findViewById(R.id.secbnakchest);
         linebnakchest=(View)findViewById(R.id.linebnakchest);
         Vlblbnakchest = (TextView) findViewById(R.id.Vlblbnakchest);
         rdogrpbnakchest = (RadioGroup) findViewById(R.id.rdogrpbnakchest);
         
         rdobnakchest1 = (RadioButton) findViewById(R.id.rdobnakchest1);
         rdobnakchest2 = (RadioButton) findViewById(R.id.rdobnakchest2);
         rdobnakchest3 = (RadioButton) findViewById(R.id.rdobnakchest3);
         secbfrog=(LinearLayout)findViewById(R.id.secbfrog);
         linebfrog=(View)findViewById(R.id.linebfrog);
         Vlblbfrog = (TextView) findViewById(R.id.Vlblbfrog);
         rdogrpbfrog = (RadioGroup) findViewById(R.id.rdogrpbfrog);
         
         rdobfrog1 = (RadioButton) findViewById(R.id.rdobfrog1);
         rdobfrog2 = (RadioButton) findViewById(R.id.rdobfrog2);
         rdobfrog3 = (RadioButton) findViewById(R.id.rdobfrog3);
         secbcheek=(LinearLayout)findViewById(R.id.secbcheek);
         linebcheek=(View)findViewById(R.id.linebcheek);
         Vlblbcheek = (TextView) findViewById(R.id.Vlblbcheek);
         rdogrpbcheek = (RadioGroup) findViewById(R.id.rdogrpbcheek);
         
         rdobcheek1 = (RadioButton) findViewById(R.id.rdobcheek1);
         rdobcheek2 = (RadioButton) findViewById(R.id.rdobcheek2);
         rdobcheek3 = (RadioButton) findViewById(R.id.rdobcheek3);
         secbnap=(LinearLayout)findViewById(R.id.secbnap);
         linebnap=(View)findViewById(R.id.linebnap);
         Vlblbnap = (TextView) findViewById(R.id.Vlblbnap);
         rdogrpbnap = (RadioGroup) findViewById(R.id.rdogrpbnap);
         
         rdobnap1 = (RadioButton) findViewById(R.id.rdobnap1);
         rdobnap2 = (RadioButton) findViewById(R.id.rdobnap2);
         rdobnap3 = (RadioButton) findViewById(R.id.rdobnap3);
         secbfixed=(LinearLayout)findViewById(R.id.secbfixed);
         linebfixed=(View)findViewById(R.id.linebfixed);
         Vlblbfixed = (TextView) findViewById(R.id.Vlblbfixed);
         rdogrpbfixed = (RadioGroup) findViewById(R.id.rdogrpbfixed);
         
         rdobfixed1 = (RadioButton) findViewById(R.id.rdobfixed1);
         rdobfixed2 = (RadioButton) findViewById(R.id.rdobfixed2);
         rdobfixed3 = (RadioButton) findViewById(R.id.rdobfixed3);
         rdogrpbfixed.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpbfixed = new String[] {"1","2","3"};
             for (int i = 0; i < rdogrpbfixed.getChildCount(); i++)
             {
                 rb = (RadioButton)rdogrpbfixed.getChildAt(i);
                 if (rb.isChecked()) rbData = d_rdogrpbfixed[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                 secbfixedOth.setVisibility(View.GONE);
                 linebfixedOth.setVisibility(View.GONE);
                 txtbfixedOth.setText("");
             }
             else if(rbData.equalsIgnoreCase("2"))
             {
                 secbfixedOth.setVisibility(View.GONE);
                 linebfixedOth.setVisibility(View.GONE);
                 txtbfixedOth.setText("");
             }
             else
             {
                 secbfixedOth.setVisibility(View.VISIBLE);
                 linebfixedOth.setVisibility(View.VISIBLE);
             }
         }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
         }
     });


         rdogrpkmcinit.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
             @Override
             public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
                if(rdokmcinit1.isChecked()){
                    secinitDate.setVisibility(View.VISIBLE);
                    secinitTime.setVisibility(View.VISIBLE);
                    seckmced.setVisibility(View.VISIBLE);
                    seckmcpos1.setVisibility(View.VISIBLE);
                    secbhat.setVisibility(View.VISIBLE);
                    secbvertcl.setVisibility(View.VISIBLE);
                    secbnakchest.setVisibility(View.VISIBLE);
                    secbfrog.setVisibility(View.VISIBLE);
                    secbcheek.setVisibility(View.VISIBLE);
                    secbnap.setVisibility(View.VISIBLE);
                    secbfixed.setVisibility(View.VISIBLE);
                    //secbfixedOth.setVisibility(View.VISIBLE);

                }else if(rdokmcinit2.isChecked() | rdokmcinit3.isChecked()){
                    secinitDate.setVisibility(View.GONE);
                    dtpinitDate.setText("");

                    secinitTime.setVisibility(View.GONE);
                    txtinitTime.setText("");

                    seckmced.setVisibility(View.GONE);
                    rdogrpkmced.clearCheck();

                    seckmcpos1.setVisibility(View.GONE);
                    rdogrpkmcpos1.clearCheck();

                    secbhat.setVisibility(View.GONE);
                    rdogrpbhat.clearCheck();

                    secbvertcl.setVisibility(View.GONE);
                    rdogrpbvertcl.clearCheck();

                    secbnakchest.setVisibility(View.GONE);
                    rdogrpbnakchest.clearCheck();

                    secbfrog.setVisibility(View.GONE);
                    rdogrpbfrog.clearCheck();

                    secbcheek.setVisibility(View.GONE);
                    rdogrpbcheek.clearCheck();

                    secbnap.setVisibility(View.GONE);
                    rdogrpbnap.clearCheck();

                    secbfixed.setVisibility(View.GONE);
                    rdogrpbfixed.clearCheck();

                    secbfixedOth.setVisibility(View.GONE);
                    txtbfixedOth.setText("");
                }
             }
             public void onNothingSelected(AdapterView<?> adapterView) {
                 return;
             }
         });


         secbfixedOth=(LinearLayout)findViewById(R.id.secbfixedOth);
         linebfixedOth=(View)findViewById(R.id.linebfixedOth);
         VlblbfixedOth=(TextView) findViewById(R.id.VlblbfixedOth);
         txtbfixedOth=(EditText) findViewById(R.id.txtbfixedOth);


         dtpinitDate.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpinitDate.getRight() - dtpinitDate.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btninitDate"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });


         txtinitTime.setOnTouchListener(new View.OnTouchListener() {
         @Override
         public boolean onTouch(View v, MotionEvent event) {
             final int DRAWABLE_RIGHT = 2;
             if(event.getAction() == MotionEvent.ACTION_UP) {
                 if(event.getRawX() >= (txtinitTime.getRight() - txtinitTime.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                     VariableID = "btninitTime"; showDialog(TIME_DIALOG);
                  return true;
                 }
             }
             return false;
           }
         });

         //Hide all skip variables
         secbfixedOth.setVisibility(View.GONE);
         linebfixedOth.setVisibility(View.GONE);
         secbfixedOth.setVisibility(View.GONE);
         linebfixedOth.setVisibility(View.GONE);

         secinitDate.setVisibility(View.GONE);
         secinitTime.setVisibility(View.GONE);
         seckmced.setVisibility(View.GONE);
         seckmcpos1.setVisibility(View.GONE);
         secbhat.setVisibility(View.GONE);
         secbvertcl.setVisibility(View.GONE);
         secbnakchest.setVisibility(View.GONE);
         secbfrog.setVisibility(View.GONE);
         secbcheek.setVisibility(View.GONE);
         secbnap.setVisibility(View.GONE);
         secbfixed.setVisibility(View.GONE);
         secbfixedOth.setVisibility(View.GONE);

        DataSearch(COUNTRYCODE, FACICODE, DATAID);
        Button cmdSave = (Button) findViewById(R.id.cmdSave);
        cmdSave.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) { 
            DataSave();
        }});
     }
     catch(Exception  e)
     {
         Connection.MessageBox(KMC_Init.this, e.getMessage());
         return;
     }
 }

public void ClearForm(){
    rdogrpkmced.clearCheck();
    rdogrpkmcpos1.clearCheck();
    rdogrpbhat.clearCheck();
    rdogrpbvertcl.clearCheck();
    rdogrpbnakchest.clearCheck();
    rdogrpbfrog.clearCheck();
    rdogrpbcheek.clearCheck();
    rdogrpbnap.clearCheck();
    rdogrpbfixed.clearCheck();
    txtbfixedOth.setText("");
}

 private void DataSave()
 {
   try
     {
 
         String DV="";

         if(txtCountryCode.getText().toString().length()==0 & secCountryCode.isShown())
           {
             Connection.MessageBox(KMC_Init.this, "Required field: CountryCode.");
             txtCountryCode.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtCountryCode.getText().toString().length()==0 ? "1" : txtCountryCode.getText().toString()) < 1 || Integer.valueOf(txtCountryCode.getText().toString().length()==0 ? "3" : txtCountryCode.getText().toString()) > 3)
           {
             Connection.MessageBox(KMC_Init.this, "Value should be between 1 and 3(CountryCode).");
             txtCountryCode.requestFocus(); 
             return;	
           }
         else if(txtFaciCode.getText().toString().length()==0 & secFaciCode.isShown())
           {
             Connection.MessageBox(KMC_Init.this, "Required field: Facility.");
             txtFaciCode.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtFaciCode.getText().toString().length()==0 ? "1" : txtFaciCode.getText().toString()) < 1 || Integer.valueOf(txtFaciCode.getText().toString().length()==0 ? "9" : txtFaciCode.getText().toString()) > 9)
           {
             Connection.MessageBox(KMC_Init.this, "Value should be between 1 and 9(Facility).");
             txtFaciCode.requestFocus(); 
             return;	
           }
         else if(txtDataID.getText().toString().length()==0 & secDataID.isShown())
           {
             Connection.MessageBox(KMC_Init.this, "Required field: Data ID.");
             txtDataID.requestFocus(); 
             return;	
           }
         else if(txtStudyID.getText().toString().length()==0 & secStudyID.isShown())
           {
             Connection.MessageBox(KMC_Init.this, "Required field: Participant ID.");
             txtStudyID.requestFocus(); 
             return;	
           }
         else if(!rdokmcinit1.isChecked() & !rdokmcinit2.isChecked() & !rdokmcinit2.isChecked()){
             Connection.MessageBox(KMC_Init.this, "Required field: KMC initiation start.");
             rdokmcinit1.requestFocus();
             return;
         }

         DV = Global.DateValidate(dtpinitDate.getText().toString());
         if(DV.length()!=0 & secinitDate.isShown())
           {
             Connection.MessageBox(KMC_Init.this, DV);
             dtpinitDate.requestFocus(); 
             return;	
           }
         else if(txtinitTime.getText().length()==0 & secinitTime.isShown())
           {
             Connection.MessageBox(KMC_Init.this, "Required field: Time of initiation of KMC.");
             txtinitTime.requestFocus(); 
             return;	
           }
         
         else if(!rdokmced1.isChecked() & !rdokmced2.isChecked() & !rdokmced3.isChecked() & seckmced.isShown())
           {
              Connection.MessageBox(KMC_Init.this, "Select anyone options from (Health worker initiates conversation about KMC with mother).");
              rdokmced1.requestFocus();
              return;
           }
         
         else if(!rdokmcpos11.isChecked() & !rdokmcpos12.isChecked() & !rdokmcpos13.isChecked() & seckmcpos1.isShown())
           {
              Connection.MessageBox(KMC_Init.this, "Select anyone options from (Baby in KMC position).");
              rdokmcpos11.requestFocus();
              return;
           }
         
         else if(!rdobhat1.isChecked() & !rdobhat2.isChecked() & !rdobhat3.isChecked() & secbhat.isShown())
           {
              Connection.MessageBox(KMC_Init.this, "Select anyone options from (Baby is wearing a hat).");
              rdobhat1.requestFocus();
              return;
           }
         
         else if(!rdobvertcl1.isChecked() & !rdobvertcl2.isChecked() & !rdobvertcl3.isChecked() & secbvertcl.isShown())
           {
              Connection.MessageBox(KMC_Init.this, "Select anyone options from (Baby id vertical).");
              rdobvertcl1.requestFocus();
              return;
           }
         
         else if(!rdobnakchest1.isChecked() & !rdobnakchest2.isChecked() & !rdobnakchest3.isChecked() & secbnakchest .isShown())
           {
              Connection.MessageBox(KMC_Init.this, "Select anyone options from (Baby in direct skin to skin contact on mothers chest ).");
              rdobnakchest1.requestFocus();
              return;
           }
         
         else if(!rdobfrog1.isChecked() & !rdobfrog2.isChecked() & !rdobfrog3.isChecked() & secbfrog.isShown())
           {
              Connection.MessageBox(KMC_Init.this, "Select anyone options from (Legs are flexed in frog position).");
              rdobfrog1.requestFocus();
              return;
           }
         
         else if(!rdobcheek1.isChecked() & !rdobcheek2.isChecked() & !rdobcheek3.isChecked() & secbcheek.isShown())
           {
              Connection.MessageBox(KMC_Init.this, "Select anyone options from (Cheek of the baby in contact with the mothers chest).");
              rdobcheek1.requestFocus();
              return;
           }
         
         else if(!rdobnap1.isChecked() & !rdobnap2.isChecked() & !rdobnap3.isChecked() & secbnap.isShown())
           {
              Connection.MessageBox(KMC_Init.this, "Select anyone options from (The baby is wearing a nappy/diaper).");
              rdobnap1.requestFocus();
              return;
           }
         
         else if(!rdobfixed1.isChecked() & !rdobfixed2.isChecked() & !rdobfixed3.isChecked() & secbfixed.isShown())
           {
              Connection.MessageBox(KMC_Init.this, "Select anyone options from (The baby is fixed with a:).");
              rdobfixed1.requestFocus();
              return;
           }
         else if(txtbfixedOth.getText().toString().length()==0 & secbfixedOth.isShown())
           {
             Connection.MessageBox(KMC_Init.this, "Required field: Othes (specify).");
             txtbfixedOth.requestFocus(); 
             return;	
           }
 
         String SQL = "";
         RadioButton rb;

         KMC_Init_DataModel objSave = new KMC_Init_DataModel();
         objSave.setCountryCode(txtCountryCode.getText().toString());
         objSave.setFaciCode(txtFaciCode.getText().toString());
         objSave.setDataID(txtDataID.getText().toString());
         objSave.setStudyID(txtStudyID.getText().toString());
         if(rdokmcinit1.isChecked()) objSave.setkmcinit("1");
         else if(rdokmcinit2.isChecked()) objSave.setkmcinit("2");
         else if(rdokmcinit3.isChecked()) objSave.setkmcinit("3");

         objSave.setinitDate(dtpinitDate.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpinitDate.getText().toString()) : dtpinitDate.getText().toString());
         objSave.setinitTime(txtinitTime.getText().toString());
         String[] d_rdogrpkmced = new String[] {"1","2","3"};
         objSave.setkmced("");
         for (int i = 0; i < rdogrpkmced.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpkmced.getChildAt(i);
             if (rb.isChecked()) objSave.setkmced(d_rdogrpkmced[i]);
         }

         String[] d_rdogrpkmcpos1 = new String[] {"1","2","3"};
         objSave.setkmcpos1("");
         for (int i = 0; i < rdogrpkmcpos1.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpkmcpos1.getChildAt(i);
             if (rb.isChecked()) objSave.setkmcpos1(d_rdogrpkmcpos1[i]);
         }

         String[] d_rdogrpbhat = new String[] {"1","2","3"};
         objSave.setbhat("");
         for (int i = 0; i < rdogrpbhat.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpbhat.getChildAt(i);
             if (rb.isChecked()) objSave.setbhat(d_rdogrpbhat[i]);
         }

         String[] d_rdogrpbvertcl = new String[] {"1","2","3"};
         objSave.setbvertcl("");
         for (int i = 0; i < rdogrpbvertcl.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpbvertcl.getChildAt(i);
             if (rb.isChecked()) objSave.setbvertcl(d_rdogrpbvertcl[i]);
         }

         String[] d_rdogrpbnakchest = new String[] {"1","2","3"};
         objSave.setbnakchest("");
         for (int i = 0; i < rdogrpbnakchest.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpbnakchest.getChildAt(i);
             if (rb.isChecked()) objSave.setbnakchest(d_rdogrpbnakchest[i]);
         }

         String[] d_rdogrpbfrog = new String[] {"1","2","3"};
         objSave.setbfrog("");
         for (int i = 0; i < rdogrpbfrog.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpbfrog.getChildAt(i);
             if (rb.isChecked()) objSave.setbfrog(d_rdogrpbfrog[i]);
         }

         String[] d_rdogrpbcheek = new String[] {"1","2","3"};
         objSave.setbcheek("");
         for (int i = 0; i < rdogrpbcheek.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpbcheek.getChildAt(i);
             if (rb.isChecked()) objSave.setbcheek(d_rdogrpbcheek[i]);
         }

         String[] d_rdogrpbnap = new String[] {"1","2","3"};
         objSave.setbnap("");
         for (int i = 0; i < rdogrpbnap.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpbnap.getChildAt(i);
             if (rb.isChecked()) objSave.setbnap(d_rdogrpbnap[i]);
         }

         String[] d_rdogrpbfixed = new String[] {"1","2","3"};
         objSave.setbfixed("");
         for (int i = 0; i < rdogrpbfixed.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpbfixed.getChildAt(i);
             if (rb.isChecked()) objSave.setbfixed(d_rdogrpbfixed[i]);
         }

         objSave.setbfixedOth(txtbfixedOth.getText().toString());
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

             Connection.MessageBoxNotClose(KMC_Init.this, "Saved Successfully");
         }
         else{
             Connection.MessageBox(KMC_Init.this, status);
             return;
         }
     }
     catch(Exception  e)
     {
         Connection.MessageBox(KMC_Init.this, e.getMessage());
         return;
     }
 }

 public void DataSearch(String CountryCode, String FaciCode, String DataID)
     {
       try
        {
           RadioButton rb;
           KMC_Init_DataModel d = new KMC_Init_DataModel();
           String SQL = "Select * from "+ TableName +"  Where CountryCode='"+ CountryCode +"' and FaciCode='"+ FaciCode +"' and DataID='"+ DataID +"'";
           List<KMC_Init_DataModel> data = d.SelectAll(this, SQL);
           for(KMC_Init_DataModel item : data){
             txtCountryCode.setText(item.getCountryCode());
             txtFaciCode.setText(item.getFaciCode());
             txtDataID.setText(item.getDataID());
             txtStudyID.setText(item.getStudyID());

             if(item.getkmcinit().equals("1"))      rdokmcinit1.setChecked(true);
             else if(item.getkmcinit().equals("2")) rdokmcinit2.setChecked(true);
             else if(item.getkmcinit().equals("3")) rdokmcinit3.setChecked(true);

             dtpinitDate.setText(item.getinitDate().toString().length()==0 ? "" : Global.DateConvertDMY(item.getinitDate()));
             txtinitTime.setText(item.getinitTime());
             String[] d_rdogrpkmced = new String[] {"1","2","3"};
             for (int i = 0; i < d_rdogrpkmced.length; i++)
             {
                 if (item.getkmced().equals(String.valueOf(d_rdogrpkmced[i])))
                 {
                     rb = (RadioButton)rdogrpkmced.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpkmcpos1 = new String[] {"1","2","3"};
             for (int i = 0; i < d_rdogrpkmcpos1.length; i++)
             {
                 if (item.getkmcpos1().equals(String.valueOf(d_rdogrpkmcpos1[i])))
                 {
                     rb = (RadioButton)rdogrpkmcpos1.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpbhat = new String[] {"1","2","3"};
             for (int i = 0; i < d_rdogrpbhat.length; i++)
             {
                 if (item.getbhat().equals(String.valueOf(d_rdogrpbhat[i])))
                 {
                     rb = (RadioButton)rdogrpbhat.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpbvertcl = new String[] {"1","2","3"};
             for (int i = 0; i < d_rdogrpbvertcl.length; i++)
             {
                 if (item.getbvertcl().equals(String.valueOf(d_rdogrpbvertcl[i])))
                 {
                     rb = (RadioButton)rdogrpbvertcl.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpbnakchest = new String[] {"1","2","3"};
             for (int i = 0; i < d_rdogrpbnakchest.length; i++)
             {
                 if (item.getbnakchest().equals(String.valueOf(d_rdogrpbnakchest[i])))
                 {
                     rb = (RadioButton)rdogrpbnakchest.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpbfrog = new String[] {"1","2","3"};
             for (int i = 0; i < d_rdogrpbfrog.length; i++)
             {
                 if (item.getbfrog().equals(String.valueOf(d_rdogrpbfrog[i])))
                 {
                     rb = (RadioButton)rdogrpbfrog.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpbcheek = new String[] {"1","2","3"};
             for (int i = 0; i < d_rdogrpbcheek.length; i++)
             {
                 if (item.getbcheek().equals(String.valueOf(d_rdogrpbcheek[i])))
                 {
                     rb = (RadioButton)rdogrpbcheek.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpbnap = new String[] {"1","2","3"};
             for (int i = 0; i < d_rdogrpbnap.length; i++)
             {
                 if (item.getbnap().equals(String.valueOf(d_rdogrpbnap[i])))
                 {
                     rb = (RadioButton)rdogrpbnap.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpbfixed = new String[] {"1","2","3"};
             for (int i = 0; i < d_rdogrpbfixed.length; i++)
             {
                 if (item.getbfixed().equals(String.valueOf(d_rdogrpbfixed[i])))
                 {
                     rb = (RadioButton)rdogrpbfixed.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtbfixedOth.setText(item.getbfixedOth());
           }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(KMC_Init.this, e.getMessage());
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


              dtpDate = (EditText)findViewById(R.id.dtpinitDate);
             if (VariableID.equals("btninitDate"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpinitDate);
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


              tpTime = (EditText)findViewById(R.id.txtinitTime);
             if (VariableID.equals("btninitTime"))
              {
                  tpTime = (EditText)findViewById(R.id.txtinitTime);
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