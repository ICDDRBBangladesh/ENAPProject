
 package org.icddrb.enap;


 //Android Manifest Code
 //<activity android:name=".KMC_Pos" android:label="KMC_Pos" />
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

 public class KMC_Pos extends Activity {
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
         LinearLayout secobjno;
         View lineobjno;
         TextView Vlblobjno;
         EditText txtobjno;
         LinearLayout secobjdate;
         View lineobjdate;
         TextView Vlblobjdate;
         EditText dtpobjdate;
         LinearLayout secobjtime;
         View lineobjtime;
         TextView Vlblobjtime;
         EditText txtobjtime;
         LinearLayout seckmc;
         View linekmc;
         TextView Vlblkmc;
         RadioGroup rdogrpkmc;
         
         RadioButton rdokmc1;
         RadioButton rdokmc2;
         RadioButton rdokmc3;
         LinearLayout seckmcwho;
         View linekmcwho;
         TextView Vlblkmcwho;
         RadioGroup rdogrpkmcwho;
         
         RadioButton rdokmcwho1;
         RadioButton rdokmcwho2;
         LinearLayout seckmcwhooth;
         View linekmcwhooth;
         TextView Vlblkmcwhooth;
         EditText txtkmcwhooth;
         LinearLayout seclbl1;
         View linelbl1;
         LinearLayout seckmcpos2a;
         View linekmcpos2a;
         TextView Vlblkmcpos2a;
         CheckBox chkkmcpos2a;
         LinearLayout seckmcpos2b;
         View linekmcpos2b;
         TextView Vlblkmcpos2b;
         CheckBox chkkmcpos2b;
         LinearLayout seckmcpos2c;
         View linekmcpos2c;
         TextView Vlblkmcpos2c;
         CheckBox chkkmcpos2c;
         LinearLayout seckmcpos2d;
         View linekmcpos2d;
         TextView Vlblkmcpos2d;
         CheckBox chkkmcpos2d;
         LinearLayout seckmcpos2e;
         View linekmcpos2e;
         TextView Vlblkmcpos2e;
         CheckBox chkkmcpos2e;
         LinearLayout seckmcpos2f;
         View linekmcpos2f;
         TextView Vlblkmcpos2f;
         CheckBox chkkmcpos2f;
         LinearLayout seckmcpos2g;
         View linekmcpos2g;
         TextView Vlblkmcpos2g;
         CheckBox chkkmcpos2g;
         LinearLayout seckmcpos2h;
         View linekmcpos2h;
         TextView Vlblkmcpos2h;
         CheckBox chkkmcpos2h;
         LinearLayout secnokmcreas;
         View linenokmcreas;
         TextView Vlblnokmcreas;
         RadioGroup rdogrpnokmcreas;
         
         RadioButton rdonokmcreas1;
         RadioButton rdonokmcreas2;
         RadioButton rdonokmcreas3;
         LinearLayout secnokmcreasoth;
         View linenokmcreasoth;
         TextView Vlblnokmcreasoth;
         EditText txtnokmcreasoth;

    static String TableName;

    static String STARTTIME = "";
    static String DEVICEID  = "";
    static String ENTRYUSER = "";
    MySharedPreferences sp;

     TextView txtName;
     TextView txtAge;

    Bundle IDbundle;
    static String COUNTRYCODE = "";
    static String FACICODE = "";
    static String DATAID = "";
    static String OBJNO = "";
     static String PATNAME = "";
     static String PATAGESEX = "";
 public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
   try
     {
         setContentView(R.layout.kmc_pos);
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
         OBJNO = IDbundle.getString("objno");
         PATNAME = IDbundle.getString("patname");
         PATAGESEX    = IDbundle.getString("agesex");
         TableName = "KMC_Pos";

         //turnGPSOn();

         //GPS Location
         //FindLocation();
         // Double.toString(currentLatitude);
         // Double.toString(currentLongitude);
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(KMC_Pos.this);
                 adb.setTitle("Close");
                 adb.setMessage("Do you want to close this form[Yes/No]?");
                 adb.setNegativeButton("No", null);
                 adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                     public void onClick(DialogInterface dialog, int which) {
                         finish();
                     }});
                 adb.show();
             }});

         txtName=(TextView)findViewById(R.id.txtName);
         txtAge=(TextView)findViewById(R.id.txtAge);
         txtName.setText(PATNAME);
         txtAge.setText(PATAGESEX);

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
         secobjno=(LinearLayout)findViewById(R.id.secobjno);
         lineobjno=(View)findViewById(R.id.lineobjno);
         Vlblobjno=(TextView) findViewById(R.id.Vlblobjno);
         txtobjno=(EditText) findViewById(R.id.txtobjno);
         if(OBJNO.length()==0)
             txtobjno.setText(ObservationNo(COUNTRYCODE, FACICODE, DATAID));
         else
             txtobjno.setText(OBJNO);

         secobjdate=(LinearLayout)findViewById(R.id.secobjdate);
         lineobjdate=(View)findViewById(R.id.lineobjdate);
         Vlblobjdate=(TextView) findViewById(R.id.Vlblobjdate);
         dtpobjdate=(EditText) findViewById(R.id.dtpobjdate);
         dtpobjdate.setText(Global.DateNowDMY());
         secobjtime=(LinearLayout)findViewById(R.id.secobjtime);
         lineobjtime=(View)findViewById(R.id.lineobjtime);
         Vlblobjtime=(TextView) findViewById(R.id.Vlblobjtime);
         txtobjtime=(EditText) findViewById(R.id.txtobjtime);
         txtobjtime.setText(g.CurrentTime24());
         seckmc=(LinearLayout)findViewById(R.id.seckmc);
         linekmc=(View)findViewById(R.id.linekmc);
         Vlblkmc = (TextView) findViewById(R.id.Vlblkmc);
         rdogrpkmc = (RadioGroup) findViewById(R.id.rdogrpkmc);

         rdokmc1 = (RadioButton) findViewById(R.id.rdokmc1);
         rdokmc2 = (RadioButton) findViewById(R.id.rdokmc2);
         rdokmc3 = (RadioButton) findViewById(R.id.rdokmc3);
         rdogrpkmc.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
             @Override
             public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
                 String rbData = "";
                 RadioButton rb;
                 String[] d_rdogrpkmc = new String[] {"1","2","3"};
                 for (int i = 0; i < rdogrpkmc.getChildCount(); i++)
                 {
                     rb = (RadioButton)rdogrpkmc.getChildAt(i);
                     if (rb.isChecked()) rbData = d_rdogrpkmc[i];
                 }

                 if(rbData.equalsIgnoreCase("2"))
                 {
                     seckmcwho.setVisibility(View.GONE);
                     linekmcwho.setVisibility(View.GONE);
                     rdogrpkmcwho.clearCheck();
                     seckmcwhooth.setVisibility(View.GONE);
                     linekmcwhooth.setVisibility(View.GONE);
                     txtkmcwhooth.setText("");
                     seclbl1.setVisibility(View.GONE);
                     linelbl1.setVisibility(View.GONE);
                     seckmcpos2a.setVisibility(View.GONE);
                     linekmcpos2a.setVisibility(View.GONE);
                     chkkmcpos2a.setChecked(false);
                     seckmcpos2b.setVisibility(View.GONE);
                     linekmcpos2b.setVisibility(View.GONE);
                     chkkmcpos2b.setChecked(false);
                     seckmcpos2c.setVisibility(View.GONE);
                     linekmcpos2c.setVisibility(View.GONE);
                     chkkmcpos2c.setChecked(false);
                     seckmcpos2d.setVisibility(View.GONE);
                     linekmcpos2d.setVisibility(View.GONE);
                     chkkmcpos2d.setChecked(false);
                     seckmcpos2e.setVisibility(View.GONE);
                     linekmcpos2e.setVisibility(View.GONE);
                     chkkmcpos2e.setChecked(false);
                     seckmcpos2f.setVisibility(View.GONE);
                     linekmcpos2f.setVisibility(View.GONE);
                     chkkmcpos2f.setChecked(false);
                     seckmcpos2g.setVisibility(View.GONE);
                     linekmcpos2g.setVisibility(View.GONE);
                     chkkmcpos2g.setChecked(false);
                     seckmcpos2h.setVisibility(View.GONE);
                     linekmcpos2h.setVisibility(View.GONE);
                     chkkmcpos2h.setChecked(false);
                     secnokmcreas.setVisibility(View.VISIBLE);
                     linenokmcreas.setVisibility(View.VISIBLE);
                     //rdogrpnokmcreas.clearCheck();
                     secnokmcreasoth.setVisibility(View.GONE);
                     linenokmcreasoth.setVisibility(View.GONE);
                     txtnokmcreasoth.setText("");
                 }
                 else if(rbData.equalsIgnoreCase("3"))
                 {
                     seckmcwho.setVisibility(View.GONE);
                     linekmcwho.setVisibility(View.GONE);
                     rdogrpkmcwho.clearCheck();
                     seckmcwhooth.setVisibility(View.GONE);
                     linekmcwhooth.setVisibility(View.GONE);
                     txtkmcwhooth.setText("");
                     seclbl1.setVisibility(View.GONE);
                     linelbl1.setVisibility(View.GONE);
                     seckmcpos2a.setVisibility(View.GONE);
                     linekmcpos2a.setVisibility(View.GONE);
                     chkkmcpos2a.setChecked(false);
                     seckmcpos2b.setVisibility(View.GONE);
                     linekmcpos2b.setVisibility(View.GONE);
                     chkkmcpos2b.setChecked(false);
                     seckmcpos2c.setVisibility(View.GONE);
                     linekmcpos2c.setVisibility(View.GONE);
                     chkkmcpos2c.setChecked(false);
                     seckmcpos2d.setVisibility(View.GONE);
                     linekmcpos2d.setVisibility(View.GONE);
                     chkkmcpos2d.setChecked(false);
                     seckmcpos2e.setVisibility(View.GONE);
                     linekmcpos2e.setVisibility(View.GONE);
                     chkkmcpos2e.setChecked(false);
                     seckmcpos2f.setVisibility(View.GONE);
                     linekmcpos2f.setVisibility(View.GONE);
                     chkkmcpos2f.setChecked(false);
                     seckmcpos2g.setVisibility(View.GONE);
                     linekmcpos2g.setVisibility(View.GONE);
                     chkkmcpos2g.setChecked(false);
                     seckmcpos2h.setVisibility(View.GONE);
                     linekmcpos2h.setVisibility(View.GONE);
                     chkkmcpos2h.setChecked(false);
                     secnokmcreas.setVisibility(View.GONE);
                     linenokmcreas.setVisibility(View.GONE);
                     rdogrpnokmcreas.clearCheck();
                     secnokmcreasoth.setVisibility(View.GONE);
                     linenokmcreasoth.setVisibility(View.GONE);
                     txtnokmcreasoth.setText("");
                 }
                 else
                 {
                     seckmcwho.setVisibility(View.VISIBLE);
                     linekmcwho.setVisibility(View.VISIBLE);
                     //seckmcwhooth.setVisibility(View.VISIBLE);
                     linekmcwhooth.setVisibility(View.VISIBLE);
                     seclbl1.setVisibility(View.VISIBLE);
                     linelbl1.setVisibility(View.VISIBLE);
                     seckmcpos2a.setVisibility(View.VISIBLE);
                     linekmcpos2a.setVisibility(View.VISIBLE);
                     seckmcpos2b.setVisibility(View.VISIBLE);
                     linekmcpos2b.setVisibility(View.VISIBLE);
                     seckmcpos2c.setVisibility(View.VISIBLE);
                     linekmcpos2c.setVisibility(View.VISIBLE);
                     seckmcpos2d.setVisibility(View.VISIBLE);
                     linekmcpos2d.setVisibility(View.VISIBLE);
                     seckmcpos2e.setVisibility(View.VISIBLE);
                     linekmcpos2e.setVisibility(View.VISIBLE);
                     seckmcpos2f.setVisibility(View.VISIBLE);
                     linekmcpos2f.setVisibility(View.VISIBLE);
                     seckmcpos2g.setVisibility(View.VISIBLE);
                     linekmcpos2g.setVisibility(View.VISIBLE);
                     seckmcpos2h.setVisibility(View.VISIBLE);
                     linekmcpos2h.setVisibility(View.VISIBLE);
                     secnokmcreas.setVisibility(View.GONE);
                     linenokmcreas.setVisibility(View.GONE);
                     rdogrpnokmcreas.clearCheck();
                     secnokmcreasoth.setVisibility(View.GONE);
                     linenokmcreasoth.setVisibility(View.GONE);
                     txtnokmcreasoth.setText("");
                 }
             }
             public void onNothingSelected(AdapterView<?> adapterView) {
                 return;
             }
         });
         seckmcwho=(LinearLayout)findViewById(R.id.seckmcwho);
         linekmcwho=(View)findViewById(R.id.linekmcwho);
         Vlblkmcwho = (TextView) findViewById(R.id.Vlblkmcwho);
         rdogrpkmcwho = (RadioGroup) findViewById(R.id.rdogrpkmcwho);

         rdokmcwho1 = (RadioButton) findViewById(R.id.rdokmcwho1);
         rdokmcwho2 = (RadioButton) findViewById(R.id.rdokmcwho2);
         rdogrpkmcwho.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
             @Override
             public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
                 String rbData = "";
                 RadioButton rb;
                 String[] d_rdogrpkmcwho = new String[] {"1","2"};
                 for (int i = 0; i < rdogrpkmcwho.getChildCount(); i++)
                 {
                     rb = (RadioButton)rdogrpkmcwho.getChildAt(i);
                     if (rb.isChecked()) rbData = d_rdogrpkmcwho[i];
                 }

                 if(rbData.equalsIgnoreCase("1"))
                 {
                     seckmcwhooth.setVisibility(View.GONE);
                     linekmcwhooth.setVisibility(View.GONE);
                     txtkmcwhooth.setText("");
                 }
                 else
                 {
                     seckmcwhooth.setVisibility(View.VISIBLE);
                     linekmcwhooth.setVisibility(View.VISIBLE);
                 }
             }
             public void onNothingSelected(AdapterView<?> adapterView) {
                 return;
             }
         });
         seckmcwhooth=(LinearLayout)findViewById(R.id.seckmcwhooth);
         linekmcwhooth=(View)findViewById(R.id.linekmcwhooth);
         Vlblkmcwhooth=(TextView) findViewById(R.id.Vlblkmcwhooth);
         txtkmcwhooth=(EditText) findViewById(R.id.txtkmcwhooth);
         seclbl1=(LinearLayout)findViewById(R.id.seclbl1);
         linelbl1=(View)findViewById(R.id.linelbl1);
         seckmcpos2a=(LinearLayout)findViewById(R.id.seckmcpos2a);
         linekmcpos2a=(View)findViewById(R.id.linekmcpos2a);
         Vlblkmcpos2a=(TextView) findViewById(R.id.Vlblkmcpos2a);
         chkkmcpos2a=(CheckBox) findViewById(R.id.chkkmcpos2a);
         seckmcpos2b=(LinearLayout)findViewById(R.id.seckmcpos2b);
         linekmcpos2b=(View)findViewById(R.id.linekmcpos2b);
         Vlblkmcpos2b=(TextView) findViewById(R.id.Vlblkmcpos2b);
         chkkmcpos2b=(CheckBox) findViewById(R.id.chkkmcpos2b);
         seckmcpos2c=(LinearLayout)findViewById(R.id.seckmcpos2c);
         linekmcpos2c=(View)findViewById(R.id.linekmcpos2c);
         Vlblkmcpos2c=(TextView) findViewById(R.id.Vlblkmcpos2c);
         chkkmcpos2c=(CheckBox) findViewById(R.id.chkkmcpos2c);
         seckmcpos2d=(LinearLayout)findViewById(R.id.seckmcpos2d);
         linekmcpos2d=(View)findViewById(R.id.linekmcpos2d);
         Vlblkmcpos2d=(TextView) findViewById(R.id.Vlblkmcpos2d);
         chkkmcpos2d=(CheckBox) findViewById(R.id.chkkmcpos2d);
         seckmcpos2e=(LinearLayout)findViewById(R.id.seckmcpos2e);
         linekmcpos2e=(View)findViewById(R.id.linekmcpos2e);
         Vlblkmcpos2e=(TextView) findViewById(R.id.Vlblkmcpos2e);
         chkkmcpos2e=(CheckBox) findViewById(R.id.chkkmcpos2e);
         seckmcpos2f=(LinearLayout)findViewById(R.id.seckmcpos2f);
         linekmcpos2f=(View)findViewById(R.id.linekmcpos2f);
         Vlblkmcpos2f=(TextView) findViewById(R.id.Vlblkmcpos2f);
         chkkmcpos2f=(CheckBox) findViewById(R.id.chkkmcpos2f);
         seckmcpos2g=(LinearLayout)findViewById(R.id.seckmcpos2g);
         linekmcpos2g=(View)findViewById(R.id.linekmcpos2g);
         Vlblkmcpos2g=(TextView) findViewById(R.id.Vlblkmcpos2g);
         chkkmcpos2g=(CheckBox) findViewById(R.id.chkkmcpos2g);
         seckmcpos2h=(LinearLayout)findViewById(R.id.seckmcpos2h);
         linekmcpos2h=(View)findViewById(R.id.linekmcpos2h);
         Vlblkmcpos2h=(TextView) findViewById(R.id.Vlblkmcpos2h);
         chkkmcpos2h=(CheckBox) findViewById(R.id.chkkmcpos2h);
         secnokmcreas=(LinearLayout)findViewById(R.id.secnokmcreas);
         linenokmcreas=(View)findViewById(R.id.linenokmcreas);
         Vlblnokmcreas = (TextView) findViewById(R.id.Vlblnokmcreas);
         rdogrpnokmcreas = (RadioGroup) findViewById(R.id.rdogrpnokmcreas);

         rdonokmcreas1 = (RadioButton) findViewById(R.id.rdonokmcreas1);
         rdonokmcreas2 = (RadioButton) findViewById(R.id.rdonokmcreas2);
         rdonokmcreas3 = (RadioButton) findViewById(R.id.rdonokmcreas3);
         rdogrpnokmcreas.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
             @Override
             public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
                 String rbData = "";
                 RadioButton rb;
                 String[] d_rdogrpnokmcreas = new String[] {"1","2","3"};
                 for (int i = 0; i < rdogrpnokmcreas.getChildCount(); i++)
                 {
                     rb = (RadioButton)rdogrpnokmcreas.getChildAt(i);
                     if (rb.isChecked()) rbData = d_rdogrpnokmcreas[i];
                 }

                 if(rbData.equalsIgnoreCase("1"))
                 {
                     secnokmcreasoth.setVisibility(View.GONE);
                     linenokmcreasoth.setVisibility(View.GONE);
                     txtnokmcreasoth.setText("");
                 }
                 else if(rbData.equalsIgnoreCase("2"))
                 {
                     secnokmcreasoth.setVisibility(View.GONE);
                     linenokmcreasoth.setVisibility(View.GONE);
                     txtnokmcreasoth.setText("");
                 }
                 else
                 {
                     secnokmcreasoth.setVisibility(View.VISIBLE);
                     linenokmcreasoth.setVisibility(View.VISIBLE);
                 }
             }
             public void onNothingSelected(AdapterView<?> adapterView) {
                 return;
             }
         });
         secnokmcreasoth=(LinearLayout)findViewById(R.id.secnokmcreasoth);
         linenokmcreasoth=(View)findViewById(R.id.linenokmcreasoth);
         Vlblnokmcreasoth=(TextView) findViewById(R.id.Vlblnokmcreasoth);
         txtnokmcreasoth=(EditText) findViewById(R.id.txtnokmcreasoth);


         dtpobjdate.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpobjdate.getRight() - dtpobjdate.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnobjdate"; showDialog(DATE_DIALOG);
                         return true;
                     }
                 }
                 return false;
             }
         });


         txtobjtime.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (txtobjtime.getRight() - txtobjtime.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnobjtime"; showDialog(TIME_DIALOG);
                         return true;
                     }
                 }
                 return false;
             }
         });

         //Hide all skip variables
         seckmcwho.setVisibility(View.GONE);
         linekmcwho.setVisibility(View.GONE);
         seckmcwhooth.setVisibility(View.GONE);
         linekmcwhooth.setVisibility(View.GONE);
         seclbl1.setVisibility(View.GONE);
         linelbl1.setVisibility(View.GONE);
         seckmcpos2a.setVisibility(View.GONE);
         linekmcpos2a.setVisibility(View.GONE);
         seckmcpos2b.setVisibility(View.GONE);
         linekmcpos2b.setVisibility(View.GONE);
         seckmcpos2c.setVisibility(View.GONE);
         linekmcpos2c.setVisibility(View.GONE);
         seckmcpos2d.setVisibility(View.GONE);
         linekmcpos2d.setVisibility(View.GONE);
         seckmcpos2e.setVisibility(View.GONE);
         linekmcpos2e.setVisibility(View.GONE);
         seckmcpos2f.setVisibility(View.GONE);
         linekmcpos2f.setVisibility(View.GONE);
         seckmcpos2g.setVisibility(View.GONE);
         linekmcpos2g.setVisibility(View.GONE);
         seckmcpos2h.setVisibility(View.GONE);
         linekmcpos2h.setVisibility(View.GONE);
         secnokmcreas.setVisibility(View.GONE);
         linenokmcreas.setVisibility(View.GONE);
         secnokmcreasoth.setVisibility(View.GONE);
         linenokmcreasoth.setVisibility(View.GONE);
         seckmcwho.setVisibility(View.GONE);
         linekmcwho.setVisibility(View.GONE);
         seckmcwhooth.setVisibility(View.GONE);
         linekmcwhooth.setVisibility(View.GONE);
         seclbl1.setVisibility(View.GONE);
         linelbl1.setVisibility(View.GONE);
         seckmcpos2a.setVisibility(View.GONE);
         linekmcpos2a.setVisibility(View.GONE);
         seckmcpos2b.setVisibility(View.GONE);
         linekmcpos2b.setVisibility(View.GONE);
         seckmcpos2c.setVisibility(View.GONE);
         linekmcpos2c.setVisibility(View.GONE);
         seckmcpos2d.setVisibility(View.GONE);
         linekmcpos2d.setVisibility(View.GONE);
         seckmcpos2e.setVisibility(View.GONE);
         linekmcpos2e.setVisibility(View.GONE);
         seckmcpos2f.setVisibility(View.GONE);
         linekmcpos2f.setVisibility(View.GONE);
         seckmcpos2g.setVisibility(View.GONE);
         linekmcpos2g.setVisibility(View.GONE);
         seckmcpos2h.setVisibility(View.GONE);
         linekmcpos2h.setVisibility(View.GONE);
         secnokmcreas.setVisibility(View.GONE);
         linenokmcreas.setVisibility(View.GONE);
         secnokmcreasoth.setVisibility(View.GONE);
         linenokmcreasoth.setVisibility(View.GONE);
         seckmcwhooth.setVisibility(View.GONE);
         linekmcwhooth.setVisibility(View.GONE);
         secnokmcreasoth.setVisibility(View.GONE);
         linenokmcreasoth.setVisibility(View.GONE);
         secnokmcreasoth.setVisibility(View.GONE);
         linenokmcreasoth.setVisibility(View.GONE);
         seckmcwhooth.setVisibility(View.GONE);

         DataSearch(COUNTRYCODE, FACICODE,DATAID,OBJNO);
         Button cmdSave = (Button) findViewById(R.id.cmdSave);
         cmdSave.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 DataSave();
             }});
     }
   catch(Exception  e)
   {
       Connection.MessageBox(KMC_Pos.this, e.getMessage());
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
                 Connection.MessageBox(KMC_Pos.this, "Required field: CountryCode.");
                 txtCountryCode.requestFocus();
                 return;
             }
             else if(Integer.valueOf(txtCountryCode.getText().toString().length()==0 ? "1" : txtCountryCode.getText().toString()) < 1 || Integer.valueOf(txtCountryCode.getText().toString().length()==0 ? "3" : txtCountryCode.getText().toString()) > 3)
             {
                 Connection.MessageBox(KMC_Pos.this, "Value should be between 1 and 3(CountryCode).");
                 txtCountryCode.requestFocus();
                 return;
             }
             else if(txtFaciCode.getText().toString().length()==0 & secFaciCode.isShown())
             {
                 Connection.MessageBox(KMC_Pos.this, "Required field: Facility.");
                 txtFaciCode.requestFocus();
                 return;
             }
             else if(Integer.valueOf(txtFaciCode.getText().toString().length()==0 ? "1" : txtFaciCode.getText().toString()) < 1 || Integer.valueOf(txtFaciCode.getText().toString().length()==0 ? "9" : txtFaciCode.getText().toString()) > 9)
             {
                 Connection.MessageBox(KMC_Pos.this, "Value should be between 1 and 9(Facility).");
                 txtFaciCode.requestFocus();
                 return;
             }
             else if(txtDataID.getText().toString().length()==0 & secDataID.isShown())
             {
                 Connection.MessageBox(KMC_Pos.this, "Required field: Data ID.");
                 txtDataID.requestFocus();
                 return;
             }
             else if(txtStudyID.getText().toString().length()==0 & secStudyID.isShown())
             {
                 Connection.MessageBox(KMC_Pos.this, "Required field: Participant ID.");
                 txtStudyID.requestFocus();
                 return;
             }
             else if(txtobjno.getText().toString().length()==0 & secobjno.isShown())
             {
                 Connection.MessageBox(KMC_Pos.this, "Required field: Observation number.");
                 txtobjno.requestFocus();
                 return;
             }
             DV = Global.DateValidate(dtpobjdate.getText().toString());
             if(DV.length()!=0 & secobjdate.isShown())
             {
                 Connection.MessageBox(KMC_Pos.this, DV);
                 dtpobjdate.requestFocus();
                 return;
             }
             else if(txtobjtime.getText().length()==0 & secobjtime.isShown())
             {
                 Connection.MessageBox(KMC_Pos.this, "Required field: Time of observation.");
                 txtobjtime.requestFocus();
                 return;
             }

             else if(!rdokmc1.isChecked() & !rdokmc2.isChecked() & !rdokmc3.isChecked() & seckmc.isShown())
             {
                 Connection.MessageBox(KMC_Pos.this, "Select anyone options from (Baby is in KMC).");
                 rdokmc1.requestFocus();
                 return;
             }

             else if(!rdokmcwho1.isChecked() & !rdokmcwho2.isChecked() & seckmcwho.isShown())
             {
                 Connection.MessageBox(KMC_Pos.this, "Select anyone options from (KMC done by).");
                 rdokmcwho1.requestFocus();
                 return;
             }
             else if(txtkmcwhooth.getText().toString().length()==0 & seckmcwhooth.isShown())
             {
                 Connection.MessageBox(KMC_Pos.this, "Required field: KMC done by other (specify).");
                 txtkmcwhooth.requestFocus();
                 return;
             }

             else if(!rdonokmcreas1.isChecked() & !rdonokmcreas2.isChecked() & !rdonokmcreas3.isChecked() & secnokmcreas.isShown())
             {
                 Connection.MessageBox(KMC_Pos.this, "Select anyone options from (If no- why not?).");
                 rdonokmcreas1.requestFocus();
                 return;
             }
             else if(txtnokmcreasoth.getText().toString().length()==0 & secnokmcreasoth.isShown())
             {
                 Connection.MessageBox(KMC_Pos.this, "Required field: Other (specify).");
                 txtnokmcreasoth.requestFocus();
                 return;
             }

             String SQL = "";
             RadioButton rb;

             KMC_Pos_DataModel objSave = new KMC_Pos_DataModel();
             objSave.setCountryCode(txtCountryCode.getText().toString());
             objSave.setFaciCode(txtFaciCode.getText().toString());
             objSave.setDataID(txtDataID.getText().toString());
             objSave.setStudyID(txtStudyID.getText().toString());
             objSave.setobjno(txtobjno.getText().toString());
             objSave.setobjdate(dtpobjdate.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpobjdate.getText().toString()) : dtpobjdate.getText().toString());
             objSave.setobjtime(txtobjtime.getText().toString());
             String[] d_rdogrpkmc = new String[] {"1","2","3"};
             objSave.setkmc("");
             for (int i = 0; i < rdogrpkmc.getChildCount(); i++)
             {
                 rb = (RadioButton)rdogrpkmc.getChildAt(i);
                 if (rb.isChecked()) objSave.setkmc(d_rdogrpkmc[i]);
             }

             String[] d_rdogrpkmcwho = new String[] {"1","2"};
             objSave.setkmcwho("");
             for (int i = 0; i < rdogrpkmcwho.getChildCount(); i++)
             {
                 rb = (RadioButton)rdogrpkmcwho.getChildAt(i);
                 if (rb.isChecked()) objSave.setkmcwho(d_rdogrpkmcwho[i]);
             }

             objSave.setkmcwhooth(txtkmcwhooth.getText().toString());
             objSave.setkmcpos2a((chkkmcpos2a.isChecked()?"1":(seckmcpos2a.isShown()?"2":"")));
             objSave.setkmcpos2b((chkkmcpos2b.isChecked()?"1":(seckmcpos2b.isShown()?"2":"")));
             objSave.setkmcpos2c((chkkmcpos2c.isChecked()?"1":(seckmcpos2c.isShown()?"2":"")));
             objSave.setkmcpos2d((chkkmcpos2d.isChecked()?"1":(seckmcpos2d.isShown()?"2":"")));
             objSave.setkmcpos2e((chkkmcpos2e.isChecked()?"1":(seckmcpos2e.isShown()?"2":"")));
             objSave.setkmcpos2f((chkkmcpos2f.isChecked()?"1":(seckmcpos2f.isShown()?"2":"")));
             objSave.setkmcpos2g((chkkmcpos2g.isChecked()?"1":(seckmcpos2g.isShown()?"2":"")));
             objSave.setkmcpos2h((chkkmcpos2h.isChecked()?"1":(seckmcpos2h.isShown()?"2":"")));
             String[] d_rdogrpnokmcreas = new String[] {"1","2","3"};
             objSave.setnokmcreas("");
             for (int i = 0; i < rdogrpnokmcreas.getChildCount(); i++)
             {
                 rb = (RadioButton)rdogrpnokmcreas.getChildAt(i);
                 if (rb.isChecked()) objSave.setnokmcreas(d_rdogrpnokmcreas[i]);
             }

             objSave.setnokmcreasoth(txtnokmcreasoth.getText().toString());
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

                 Connection.MessageBox(KMC_Pos.this, "Saved Successfully");
             }
             else{
                 Connection.MessageBox(KMC_Pos.this, status);
                 return;
             }
         }
         catch(Exception  e)
         {
             Connection.MessageBox(KMC_Pos.this, e.getMessage());
             return;
         }
     }

     private void DataSearch(String CountryCode, String FaciCode, String DataID, String objno)
     {
         try
         {

             RadioButton rb;
             KMC_Pos_DataModel d = new KMC_Pos_DataModel();
             String SQL = "Select * from "+ TableName +"  Where CountryCode='"+ CountryCode +"' and FaciCode='"+ FaciCode +"' and DataID='"+ DataID +"' and objno='"+ objno +"'";
             List<KMC_Pos_DataModel> data = d.SelectAll(this, SQL);
             for(KMC_Pos_DataModel item : data){
                 txtCountryCode.setText(item.getCountryCode());
                 txtFaciCode.setText(item.getFaciCode());
                 txtDataID.setText(item.getDataID());
                 txtStudyID.setText(item.getStudyID());
                 txtobjno.setText(item.getobjno());
                 dtpobjdate.setText(item.getobjdate().toString().length()==0 ? "" : Global.DateConvertDMY(item.getobjdate()));
                 txtobjtime.setText(item.getobjtime());
                 String[] d_rdogrpkmc = new String[] {"1","2","3"};
                 for (int i = 0; i < d_rdogrpkmc.length; i++)
                 {
                     if (item.getkmc().equals(String.valueOf(d_rdogrpkmc[i])))
                     {
                         rb = (RadioButton)rdogrpkmc.getChildAt(i);
                         rb.setChecked(true);
                     }
                 }
                 String[] d_rdogrpkmcwho = new String[] {"1","2"};
                 for (int i = 0; i < d_rdogrpkmcwho.length; i++)
                 {
                     if (item.getkmcwho().equals(String.valueOf(d_rdogrpkmcwho[i])))
                     {
                         rb = (RadioButton)rdogrpkmcwho.getChildAt(i);
                         rb.setChecked(true);
                     }
                 }
                 txtkmcwhooth.setText(item.getkmcwhooth());
                 if(item.getkmcpos2a().equals("1"))
                 {
                     chkkmcpos2a.setChecked(true);
                 }
                 else if(item.getkmcpos2a().equals("2"))
                 {
                     chkkmcpos2a.setChecked(false);
                 }
                 if(item.getkmcpos2b().equals("1"))
                 {
                     chkkmcpos2b.setChecked(true);
                 }
                 else if(item.getkmcpos2b().equals("2"))
                 {
                     chkkmcpos2b.setChecked(false);
                 }
                 if(item.getkmcpos2c().equals("1"))
                 {
                     chkkmcpos2c.setChecked(true);
                 }
                 else if(item.getkmcpos2c().equals("2"))
                 {
                     chkkmcpos2c.setChecked(false);
                 }
                 if(item.getkmcpos2d().equals("1"))
                 {
                     chkkmcpos2d.setChecked(true);
                 }
                 else if(item.getkmcpos2d().equals("2"))
                 {
                     chkkmcpos2d.setChecked(false);
                 }
                 if(item.getkmcpos2e().equals("1"))
                 {
                     chkkmcpos2e.setChecked(true);
                 }
                 else if(item.getkmcpos2e().equals("2"))
                 {
                     chkkmcpos2e.setChecked(false);
                 }
                 if(item.getkmcpos2f().equals("1"))
                 {
                     chkkmcpos2f.setChecked(true);
                 }
                 else if(item.getkmcpos2f().equals("2"))
                 {
                     chkkmcpos2f.setChecked(false);
                 }
                 if(item.getkmcpos2g().equals("1"))
                 {
                     chkkmcpos2g.setChecked(true);
                 }
                 else if(item.getkmcpos2g().equals("2"))
                 {
                     chkkmcpos2g.setChecked(false);
                 }
                 if(item.getkmcpos2h().equals("1"))
                 {
                     chkkmcpos2h.setChecked(true);
                 }
                 else if(item.getkmcpos2h().equals("2"))
                 {
                     chkkmcpos2h.setChecked(false);
                 }
                 String[] d_rdogrpnokmcreas = new String[] {"1","2","3"};
                 for (int i = 0; i < d_rdogrpnokmcreas.length; i++)
                 {
                     if (item.getnokmcreas().equals(String.valueOf(d_rdogrpnokmcreas[i])))
                     {
                         rb = (RadioButton)rdogrpnokmcreas.getChildAt(i);
                         rb.setChecked(true);
                     }
                 }
                 txtnokmcreasoth.setText(item.getnokmcreasoth());
             }
         }
         catch(Exception  e)
         {
             Connection.MessageBox(KMC_Pos.this, e.getMessage());
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


             dtpDate = (EditText)findViewById(R.id.dtpobjdate);
             if (VariableID.equals("btnobjdate"))
             {
                 dtpDate = (EditText)findViewById(R.id.dtpobjdate);
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


             tpTime = (EditText)findViewById(R.id.txtobjtime);
             if (VariableID.equals("btnobjtime"))
             {
                 tpTime = (EditText)findViewById(R.id.txtobjtime);
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

     private String ObservationNo(String CountryCode, String FaciCode, String DataId)
     {
         String ONo = C.ReturnSingleValue("Select (ifnull(max(cast(objno as numeric(12))),0)+1)MaxNo from KMC_Pos where CountryCode='"+ CountryCode +"' and FaciCode='"+ FaciCode +"' and DataId='"+ DataId +"'");
         return ONo;
     }
 }