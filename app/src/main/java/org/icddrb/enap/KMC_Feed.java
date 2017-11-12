
 package org.icddrb.enap;


 //Android Manifest Code
 //<activity android:name=".KMC_Feed" android:label="KMC_Feed" />
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

 public class KMC_Feed extends Activity {
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
         LinearLayout seclbl1;
         View linelbl1;
         LinearLayout seccup;
         View linecup;
         TextView Vlblcup;
         RadioGroup rdogrpcup;
         
         RadioButton rdocup1;
         RadioButton rdocup2;
         RadioButton rdocup3;
         LinearLayout seccuptime;
         View linecuptime;
         TextView Vlblcuptime;
         EditText txtcuptime;
         LinearLayout seccupwho;
         View linecupwho;
         TextView Vlblcupwho;
         RadioGroup rdogrpcupwho;
         
         RadioButton rdocupwho1;
         RadioButton rdocupwho2;
         LinearLayout seccupwhooth;
         View linecupwhooth;
         TextView Vlblcupwhooth;
         EditText txtcupwhooth;
         LinearLayout seccuphowmuch;
         View linecuphowmuch;
         TextView Vlblcuphowmuch;
         EditText txtcuphowmuch;
         LinearLayout seclbl2;
         View linelbl2;
         LinearLayout secnaso;
         View linenaso;
         TextView Vlblnaso;
         RadioGroup rdogrpnaso;
         
         RadioButton rdonaso1;
         RadioButton rdonaso2;
         RadioButton rdonaso3;
         LinearLayout secnasotime;
         View linenasotime;
         TextView Vlblnasotime;
         EditText txtnasotime;
         LinearLayout secnasowho;
         View linenasowho;
         TextView Vlblnasowho;
         RadioGroup rdogrpnasowho;
         
         RadioButton rdonasowho1;
         RadioButton rdonasowho2;
         LinearLayout secnasowhooth;
         View linenasowhooth;
         TextView Vlblnasowhooth;
         EditText txtnasowhooth;
         LinearLayout secnasohowmuch;
         View linenasohowmuch;
         TextView Vlblnasohowmuch;
         EditText txtnasohowmuch;
         LinearLayout seclbl3;
         View linelbl3;
         LinearLayout secsuckbst;
         View linesuckbst;
         TextView Vlblsuckbst;
         RadioGroup rdogrpsuckbst;
         
         RadioButton rdosuckbst1;
         RadioButton rdosuckbst2;
         RadioButton rdosuckbst3;

    static String TableName;

    static String STARTTIME = "";
    static String DEVICEID  = "";
    static String ENTRYUSER = "";
    MySharedPreferences sp;

    Bundle IDbundle;
    static String COUNTRYCODE = "";
    static String FACICODE = "";
    static String DATAID = "";
    static String OBJNO = "";

     TextView txtName;
     TextView txtAge;
     static String PATNAME = "";
     static String PATAGESEX = "";

 public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
   try
     {
         setContentView(R.layout.kmc_feed);
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

         TableName = "KMC_Feed";

         //turnGPSOn();

         //GPS Location
         //FindLocation();
         // Double.toString(currentLatitude);
         // Double.toString(currentLongitude);
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(KMC_Feed.this);
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
         seclbl1=(LinearLayout)findViewById(R.id.seclbl1);
         linelbl1=(View)findViewById(R.id.linelbl1);
         seccup=(LinearLayout)findViewById(R.id.seccup);
         linecup=(View)findViewById(R.id.linecup);
         Vlblcup = (TextView) findViewById(R.id.Vlblcup);
         rdogrpcup = (RadioGroup) findViewById(R.id.rdogrpcup);
         
         rdocup1 = (RadioButton) findViewById(R.id.rdocup1);
         rdocup2 = (RadioButton) findViewById(R.id.rdocup2);
         rdocup3 = (RadioButton) findViewById(R.id.rdocup3);
         rdogrpcup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpcup = new String[] {"1","2","3"};
             for (int i = 0; i < rdogrpcup.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpcup.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpcup[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    seccuptime.setVisibility(View.GONE);
                    linecuptime.setVisibility(View.GONE);
                    txtcuptime.setText("");
                    seccupwho.setVisibility(View.GONE);
                    linecupwho.setVisibility(View.GONE);
                    rdogrpcupwho.clearCheck();
                    seccupwhooth.setVisibility(View.GONE);
                    linecupwhooth.setVisibility(View.GONE);
                    txtcupwhooth.setText("");
                    seccuphowmuch.setVisibility(View.GONE);
                    linecuphowmuch.setVisibility(View.GONE);
                    txtcuphowmuch.setText("");
                    //seclbl2.setVisibility(View.GONE);
                    //linelbl2.setVisibility(View.GONE);
             }
             else if(rbData.equalsIgnoreCase("3"))
             {
                    seccuptime.setVisibility(View.GONE);
                    linecuptime.setVisibility(View.GONE);
                    txtcuptime.setText("");
                    seccupwho.setVisibility(View.GONE);
                    linecupwho.setVisibility(View.GONE);
                    rdogrpcupwho.clearCheck();
                    seccupwhooth.setVisibility(View.GONE);
                    linecupwhooth.setVisibility(View.GONE);
                    txtcupwhooth.setText("");
                    seccuphowmuch.setVisibility(View.GONE);
                    linecuphowmuch.setVisibility(View.GONE);
                    txtcuphowmuch.setText("");
                    //seclbl2.setVisibility(View.GONE);
                    //linelbl2.setVisibility(View.GONE);
             }
             else
             {
                    //seccuptime.setVisibility(View.VISIBLE);
                    //linecuptime.setVisibility(View.VISIBLE);
                    seccupwho.setVisibility(View.VISIBLE);
                    linecupwho.setVisibility(View.VISIBLE);
                    seccuphowmuch.setVisibility(View.VISIBLE);
                    linecuphowmuch.setVisibility(View.VISIBLE);
                    //seclbl2.setVisibility(View.VISIBLE);
                    //linelbl2.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         seccuptime=(LinearLayout)findViewById(R.id.seccuptime);
         linecuptime=(View)findViewById(R.id.linecuptime);
         Vlblcuptime=(TextView) findViewById(R.id.Vlblcuptime);
         txtcuptime=(EditText) findViewById(R.id.txtcuptime);
         seccupwho=(LinearLayout)findViewById(R.id.seccupwho);
         linecupwho=(View)findViewById(R.id.linecupwho);
         Vlblcupwho = (TextView) findViewById(R.id.Vlblcupwho);
         rdogrpcupwho = (RadioGroup) findViewById(R.id.rdogrpcupwho);
         
         rdocupwho1 = (RadioButton) findViewById(R.id.rdocupwho1);
         rdocupwho2 = (RadioButton) findViewById(R.id.rdocupwho2);
         rdogrpcupwho.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpcupwho = new String[] {"1","2"};
             for (int i = 0; i < rdogrpcupwho.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpcupwho.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpcupwho[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                    seccupwhooth.setVisibility(View.GONE);
                    linecupwhooth.setVisibility(View.GONE);
                    txtcupwhooth.setText("");
             }
             else
             {
                    seccupwhooth.setVisibility(View.VISIBLE);
                    linecupwhooth.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         seccupwhooth=(LinearLayout)findViewById(R.id.seccupwhooth);
         linecupwhooth=(View)findViewById(R.id.linecupwhooth);
         Vlblcupwhooth=(TextView) findViewById(R.id.Vlblcupwhooth);
         txtcupwhooth=(EditText) findViewById(R.id.txtcupwhooth);
         seccuphowmuch=(LinearLayout)findViewById(R.id.seccuphowmuch);
         linecuphowmuch=(View)findViewById(R.id.linecuphowmuch);
         Vlblcuphowmuch=(TextView) findViewById(R.id.Vlblcuphowmuch);
         txtcuphowmuch=(EditText) findViewById(R.id.txtcuphowmuch);
         seclbl2=(LinearLayout)findViewById(R.id.seclbl2);
         linelbl2=(View)findViewById(R.id.linelbl2);
         secnaso=(LinearLayout)findViewById(R.id.secnaso);
         linenaso=(View)findViewById(R.id.linenaso);
         Vlblnaso = (TextView) findViewById(R.id.Vlblnaso);
         rdogrpnaso = (RadioGroup) findViewById(R.id.rdogrpnaso);
         
         rdonaso1 = (RadioButton) findViewById(R.id.rdonaso1);
         rdonaso2 = (RadioButton) findViewById(R.id.rdonaso2);
         rdonaso3 = (RadioButton) findViewById(R.id.rdonaso3);
         rdogrpnaso.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpnaso = new String[] {"1","2","3"};
             for (int i = 0; i < rdogrpnaso.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpnaso.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpnaso[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secnasotime.setVisibility(View.GONE);
                    linenasotime.setVisibility(View.GONE);
                    txtnasotime.setText("");
                    secnasowho.setVisibility(View.GONE);
                    linenasowho.setVisibility(View.GONE);
                    rdogrpnasowho.clearCheck();
                    secnasowhooth.setVisibility(View.GONE);
                    linenasowhooth.setVisibility(View.GONE);
                    txtnasowhooth.setText("");
                    secnasohowmuch.setVisibility(View.GONE);
                    linenasohowmuch.setVisibility(View.GONE);
                    txtnasohowmuch.setText("");
                    //seclbl3.setVisibility(View.GONE);
                    //linelbl3.setVisibility(View.GONE);
             }
             else if(rbData.equalsIgnoreCase("3"))
             {
                    secnasotime.setVisibility(View.GONE);
                    linenasotime.setVisibility(View.GONE);
                    txtnasotime.setText("");
                    secnasowho.setVisibility(View.GONE);
                    linenasowho.setVisibility(View.GONE);
                    rdogrpnasowho.clearCheck();
                    secnasowhooth.setVisibility(View.GONE);
                    linenasowhooth.setVisibility(View.GONE);
                    txtnasowhooth.setText("");
                    secnasohowmuch.setVisibility(View.GONE);
                    linenasohowmuch.setVisibility(View.GONE);
                    txtnasohowmuch.setText("");
                    //seclbl3.setVisibility(View.GONE);
                    //linelbl3.setVisibility(View.GONE);
             }
             else
             {
                    //secnasotime.setVisibility(View.VISIBLE);
                    //linenasotime.setVisibility(View.VISIBLE);
                    secnasowho.setVisibility(View.VISIBLE);
                    linenasowho.setVisibility(View.VISIBLE);
                    secnasohowmuch.setVisibility(View.VISIBLE);
                    linenasohowmuch.setVisibility(View.VISIBLE);
                    //seclbl3.setVisibility(View.VISIBLE);
                    //linelbl3.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secnasotime=(LinearLayout)findViewById(R.id.secnasotime);
         linenasotime=(View)findViewById(R.id.linenasotime);
         Vlblnasotime=(TextView) findViewById(R.id.Vlblnasotime);
         txtnasotime=(EditText) findViewById(R.id.txtnasotime);
         secnasowho=(LinearLayout)findViewById(R.id.secnasowho);
         linenasowho=(View)findViewById(R.id.linenasowho);
         Vlblnasowho = (TextView) findViewById(R.id.Vlblnasowho);
         rdogrpnasowho = (RadioGroup) findViewById(R.id.rdogrpnasowho);
         
         rdonasowho1 = (RadioButton) findViewById(R.id.rdonasowho1);
         rdonasowho2 = (RadioButton) findViewById(R.id.rdonasowho2);
         rdogrpnasowho.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpnasowho = new String[] {"1","2"};
             for (int i = 0; i < rdogrpnasowho.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpnasowho.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpnasowho[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                    secnasowhooth.setVisibility(View.GONE);
                    linenasowhooth.setVisibility(View.GONE);
                    txtnasowhooth.setText("");
             }
             else
             {
                    secnasowhooth.setVisibility(View.VISIBLE);
                    linenasowhooth.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secnasowhooth=(LinearLayout)findViewById(R.id.secnasowhooth);
         linenasowhooth=(View)findViewById(R.id.linenasowhooth);
         Vlblnasowhooth=(TextView) findViewById(R.id.Vlblnasowhooth);
         txtnasowhooth=(EditText) findViewById(R.id.txtnasowhooth);
         secnasohowmuch=(LinearLayout)findViewById(R.id.secnasohowmuch);
         linenasohowmuch=(View)findViewById(R.id.linenasohowmuch);
         Vlblnasohowmuch=(TextView) findViewById(R.id.Vlblnasohowmuch);
         txtnasohowmuch=(EditText) findViewById(R.id.txtnasohowmuch);
         seclbl3=(LinearLayout)findViewById(R.id.seclbl3);
         linelbl3=(View)findViewById(R.id.linelbl3);
         secsuckbst=(LinearLayout)findViewById(R.id.secsuckbst);
         linesuckbst=(View)findViewById(R.id.linesuckbst);
         Vlblsuckbst = (TextView) findViewById(R.id.Vlblsuckbst);
         rdogrpsuckbst = (RadioGroup) findViewById(R.id.rdogrpsuckbst);
         
         rdosuckbst1 = (RadioButton) findViewById(R.id.rdosuckbst1);
         rdosuckbst2 = (RadioButton) findViewById(R.id.rdosuckbst2);
         rdosuckbst3 = (RadioButton) findViewById(R.id.rdosuckbst3);


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
         txtcuptime.setOnTouchListener(new View.OnTouchListener() {
         @Override
         public boolean onTouch(View v, MotionEvent event) {
             final int DRAWABLE_RIGHT = 2;
             if(event.getAction() == MotionEvent.ACTION_UP) {
                 if(event.getRawX() >= (txtcuptime.getRight() - txtcuptime.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                     VariableID = "btncuptime"; showDialog(TIME_DIALOG);
                  return true;
                 }
             }
             return false;
           }
         });
         txtnasotime.setOnTouchListener(new View.OnTouchListener() {
         @Override
         public boolean onTouch(View v, MotionEvent event) {
             final int DRAWABLE_RIGHT = 2;
             if(event.getAction() == MotionEvent.ACTION_UP) {
                 if(event.getRawX() >= (txtnasotime.getRight() - txtnasotime.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                     VariableID = "btnnasotime"; showDialog(TIME_DIALOG);
                  return true;
                 }
             }
             return false;
           }
         });

         //Hide all skip variables
         seccuptime.setVisibility(View.GONE);
         linecuptime.setVisibility(View.GONE);
         seccupwho.setVisibility(View.GONE);
         linecupwho.setVisibility(View.GONE);
         seccupwhooth.setVisibility(View.GONE);
         linecupwhooth.setVisibility(View.GONE);
         seccuphowmuch.setVisibility(View.GONE);
         linecuphowmuch.setVisibility(View.GONE);
         //seclbl2.setVisibility(View.GONE);
         linelbl2.setVisibility(View.GONE);
         seccuptime.setVisibility(View.GONE);
         linecuptime.setVisibility(View.GONE);
         seccupwho.setVisibility(View.GONE);
         linecupwho.setVisibility(View.GONE);
         seccupwhooth.setVisibility(View.GONE);
         linecupwhooth.setVisibility(View.GONE);
         seccuphowmuch.setVisibility(View.GONE);
         linecuphowmuch.setVisibility(View.GONE);
         //seclbl2.setVisibility(View.GONE);
         linelbl2.setVisibility(View.GONE);
         seccupwhooth.setVisibility(View.GONE);
         linecupwhooth.setVisibility(View.GONE);
         secnasotime.setVisibility(View.GONE);
         linenasotime.setVisibility(View.GONE);
         secnasowho.setVisibility(View.GONE);
         linenasowho.setVisibility(View.GONE);
         secnasowhooth.setVisibility(View.GONE);
         linenasowhooth.setVisibility(View.GONE);
         secnasohowmuch.setVisibility(View.GONE);
         linenasohowmuch.setVisibility(View.GONE);
         //seclbl3.setVisibility(View.GONE);
         linelbl3.setVisibility(View.GONE);
         secnasotime.setVisibility(View.GONE);
         linenasotime.setVisibility(View.GONE);
         secnasowho.setVisibility(View.GONE);
         linenasowho.setVisibility(View.GONE);
         secnasowhooth.setVisibility(View.GONE);
         linenasowhooth.setVisibility(View.GONE);
         secnasohowmuch.setVisibility(View.GONE);
         linenasohowmuch.setVisibility(View.GONE);
         //seclbl3.setVisibility(View.GONE);
         linelbl3.setVisibility(View.GONE);
         secnasowhooth.setVisibility(View.GONE);
         linenasowhooth.setVisibility(View.GONE);


         DataSearch(COUNTRYCODE,FACICODE,DATAID,OBJNO);
        Button cmdSave = (Button) findViewById(R.id.cmdSave);
        cmdSave.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) { 
            DataSave();
        }});
     }
     catch(Exception  e)
     {
         Connection.MessageBox(KMC_Feed.this, e.getMessage());
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
             Connection.MessageBox(KMC_Feed.this, "Required field: CountryCode.");
             txtCountryCode.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtCountryCode.getText().toString().length()==0 ? "1" : txtCountryCode.getText().toString()) < 1 || Integer.valueOf(txtCountryCode.getText().toString().length()==0 ? "3" : txtCountryCode.getText().toString()) > 3)
           {
             Connection.MessageBox(KMC_Feed.this, "Value should be between 1 and 3(CountryCode).");
             txtCountryCode.requestFocus(); 
             return;	
           }
         else if(txtFaciCode.getText().toString().length()==0 & secFaciCode.isShown())
           {
             Connection.MessageBox(KMC_Feed.this, "Required field: Facility.");
             txtFaciCode.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtFaciCode.getText().toString().length()==0 ? "1" : txtFaciCode.getText().toString()) < 1 || Integer.valueOf(txtFaciCode.getText().toString().length()==0 ? "9" : txtFaciCode.getText().toString()) > 9)
           {
             Connection.MessageBox(KMC_Feed.this, "Value should be between 1 and 9(Facility).");
             txtFaciCode.requestFocus(); 
             return;	
           }
         else if(txtDataID.getText().toString().length()==0 & secDataID.isShown())
           {
             Connection.MessageBox(KMC_Feed.this, "Required field: Data ID.");
             txtDataID.requestFocus(); 
             return;	
           }
         else if(txtStudyID.getText().toString().length()==0 & secStudyID.isShown())
           {
             Connection.MessageBox(KMC_Feed.this, "Required field: Participant ID.");
             txtStudyID.requestFocus(); 
             return;	
           }
         else if(txtobjno.getText().toString().length()==0 & secobjno.isShown())
           {
             Connection.MessageBox(KMC_Feed.this, "Required field: Observation number.");
             txtobjno.requestFocus(); 
             return;	
           }
         DV = Global.DateValidate(dtpobjdate.getText().toString());
         if(DV.length()!=0 & secobjdate.isShown())
           {
             Connection.MessageBox(KMC_Feed.this, DV);
             dtpobjdate.requestFocus(); 
             return;	
           }
         else if(txtobjtime.getText().length()==0 & secobjtime.isShown())
           {
             Connection.MessageBox(KMC_Feed.this, "Required field: Time.");
             txtobjtime.requestFocus(); 
             return;	
           }
         
         else if(!rdocup1.isChecked() & !rdocup2.isChecked() & !rdocup3.isChecked() & seccup.isShown())
           {
              Connection.MessageBox(KMC_Feed.this, "Select anyone options from (Baby being cup fed).");
              rdocup1.requestFocus();
              return;
           }
         else if(txtcuptime.getText().length()==0 & seccuptime.isShown())
           {
             Connection.MessageBox(KMC_Feed.this, "Required field: Time of cup feeding.");
             txtcuptime.requestFocus(); 
             return;	
           }
         
         else if(!rdocupwho1.isChecked() & !rdocupwho2.isChecked() & seccupwho.isShown())
           {
              Connection.MessageBox(KMC_Feed.this, "Select anyone options from (By who).");
              rdocupwho1.requestFocus();
              return;
           }
         else if(txtcupwhooth.getText().toString().length()==0 & seccupwhooth.isShown())
           {
             Connection.MessageBox(KMC_Feed.this, "Required field: Other (specify).");
             txtcupwhooth.requestFocus(); 
             return;	
           }
         else if(txtcuphowmuch.getText().toString().length()==0 & seccuphowmuch.isShown())
           {
             Connection.MessageBox(KMC_Feed.this, "Required field: How much.");
             txtcuphowmuch.requestFocus(); 
             return;	
           }
         
         else if(!rdonaso1.isChecked() & !rdonaso2.isChecked() & !rdonaso3.isChecked() & secnaso.isShown())
           {
              Connection.MessageBox(KMC_Feed.this, "Select anyone options from (Baby being nasogastric fed).");
              rdonaso1.requestFocus();
              return;
           }
         else if(txtnasotime.getText().length()==0 & secnasotime.isShown())
           {
             Connection.MessageBox(KMC_Feed.this, "Required field: Time of nasogastric feeding.");
             txtnasotime.requestFocus(); 
             return;	
           }
         
         else if(!rdonasowho1.isChecked() & !rdonasowho2.isChecked() & secnasowho.isShown())
           {
              Connection.MessageBox(KMC_Feed.this, "Select anyone options from (By who).");
              rdonasowho1.requestFocus();
              return;
           }
         else if(txtnasowhooth.getText().toString().length()==0 & secnasowhooth.isShown())
           {
             Connection.MessageBox(KMC_Feed.this, "Required field: Other (specify).");
             txtnasowhooth.requestFocus(); 
             return;	
           }
         else if(txtnasohowmuch.getText().toString().length()==0 & secnasohowmuch.isShown())
           {
             Connection.MessageBox(KMC_Feed.this, "Required field: How much.");
             txtnasohowmuch.requestFocus(); 
             return;	
           }
         
         else if(!rdosuckbst1.isChecked() & !rdosuckbst2.isChecked() & !rdosuckbst3.isChecked() & secsuckbst.isShown())
           {
              Connection.MessageBox(KMC_Feed.this, "Select anyone options from (Baby sucking at breast).");
              rdosuckbst1.requestFocus();
              return;
           }
 
         String SQL = "";
         RadioButton rb;

         KMC_Feed_DataModel objSave = new KMC_Feed_DataModel();
         objSave.setCountryCode(txtCountryCode.getText().toString());
         objSave.setFaciCode(txtFaciCode.getText().toString());
         objSave.setDataID(txtDataID.getText().toString());
         objSave.setStudyID(txtStudyID.getText().toString());
         objSave.setobjno(txtobjno.getText().toString());
         objSave.setobjdate(dtpobjdate.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpobjdate.getText().toString()) : dtpobjdate.getText().toString());
         objSave.setobjtime(txtobjtime.getText().toString());
         String[] d_rdogrpcup = new String[] {"1","2","3"};
         objSave.setcup("");
         for (int i = 0; i < rdogrpcup.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpcup.getChildAt(i);
             if (rb.isChecked()) objSave.setcup(d_rdogrpcup[i]);
         }

         objSave.setcuptime(txtcuptime.getText().toString());
         String[] d_rdogrpcupwho = new String[] {"1","2"};
         objSave.setcupwho("");
         for (int i = 0; i < rdogrpcupwho.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpcupwho.getChildAt(i);
             if (rb.isChecked()) objSave.setcupwho(d_rdogrpcupwho[i]);
         }

         objSave.setcupwhooth(txtcupwhooth.getText().toString());
         objSave.setcuphowmuch(txtcuphowmuch.getText().toString());
         String[] d_rdogrpnaso = new String[] {"1","2","3"};
         objSave.setnaso("");
         for (int i = 0; i < rdogrpnaso.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpnaso.getChildAt(i);
             if (rb.isChecked()) objSave.setnaso(d_rdogrpnaso[i]);
         }

         objSave.setnasotime(txtnasotime.getText().toString());
         String[] d_rdogrpnasowho = new String[] {"1","2"};
         objSave.setnasowho("");
         for (int i = 0; i < rdogrpnasowho.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpnasowho.getChildAt(i);
             if (rb.isChecked()) objSave.setnasowho(d_rdogrpnasowho[i]);
         }

         objSave.setnasowhooth(txtnasowhooth.getText().toString());
         objSave.setnasohowmuch(txtnasohowmuch.getText().toString());
         String[] d_rdogrpsuckbst = new String[] {"1","2","3"};
         objSave.setsuckbst("");
         for (int i = 0; i < rdogrpsuckbst.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpsuckbst.getChildAt(i);
             if (rb.isChecked()) objSave.setsuckbst(d_rdogrpsuckbst[i]);
         }

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

             Connection.MessageBox(KMC_Feed.this, "Saved Successfully");
         }
         else{
             Connection.MessageBox(KMC_Feed.this, status);
             return;
         }
     }
     catch(Exception  e)
     {
         Connection.MessageBox(KMC_Feed.this, e.getMessage());
         return;
     }
 }

 private void DataSearch(String CountryCode, String FaciCode, String DataID, String objno)
     {
       try
        {
     
           RadioButton rb;
           KMC_Feed_DataModel d = new KMC_Feed_DataModel();
           String SQL = "Select * from "+ TableName +"  Where CountryCode='"+ CountryCode +"' and FaciCode='"+ FaciCode +"' and DataID='"+ DataID +"' and objno='"+ objno +"'";
           List<KMC_Feed_DataModel> data = d.SelectAll(this, SQL);
           for(KMC_Feed_DataModel item : data){
             txtCountryCode.setText(item.getCountryCode());
             txtFaciCode.setText(item.getFaciCode());
             txtDataID.setText(item.getDataID());
             txtStudyID.setText(item.getStudyID());
             txtobjno.setText(item.getobjno());
             dtpobjdate.setText(item.getobjdate().toString().length()==0 ? "" : Global.DateConvertDMY(item.getobjdate()));
             txtobjtime.setText(item.getobjtime());
             String[] d_rdogrpcup = new String[] {"1","2","3"};
             for (int i = 0; i < d_rdogrpcup.length; i++)
             {
                 if (item.getcup().equals(String.valueOf(d_rdogrpcup[i])))
                 {
                     rb = (RadioButton)rdogrpcup.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtcuptime.setText(item.getcuptime());
             String[] d_rdogrpcupwho = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpcupwho.length; i++)
             {
                 if (item.getcupwho().equals(String.valueOf(d_rdogrpcupwho[i])))
                 {
                     rb = (RadioButton)rdogrpcupwho.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtcupwhooth.setText(item.getcupwhooth());
             txtcuphowmuch.setText(item.getcuphowmuch());
             String[] d_rdogrpnaso = new String[] {"1","2","3"};
             for (int i = 0; i < d_rdogrpnaso.length; i++)
             {
                 if (item.getnaso().equals(String.valueOf(d_rdogrpnaso[i])))
                 {
                     rb = (RadioButton)rdogrpnaso.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtnasotime.setText(item.getnasotime());
             String[] d_rdogrpnasowho = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpnasowho.length; i++)
             {
                 if (item.getnasowho().equals(String.valueOf(d_rdogrpnasowho[i])))
                 {
                     rb = (RadioButton)rdogrpnasowho.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtnasowhooth.setText(item.getnasowhooth());
             txtnasohowmuch.setText(item.getnasohowmuch());
             String[] d_rdogrpsuckbst = new String[] {"1","2","3"};
             for (int i = 0; i < d_rdogrpsuckbst.length; i++)
             {
                 if (item.getsuckbst().equals(String.valueOf(d_rdogrpsuckbst[i])))
                 {
                     rb = (RadioButton)rdogrpsuckbst.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
           }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(KMC_Feed.this, e.getMessage());
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
             else if (VariableID.equals("btncuptime"))
              {
                  tpTime = (EditText)findViewById(R.id.txtcuptime);
              }
             else if (VariableID.equals("btnnasotime"))
              {
                  tpTime = (EditText)findViewById(R.id.txtnasotime);
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
         String ONo = C.ReturnSingleValue("Select (ifnull(max(cast(objno as numeric(12))),0)+1)MaxNo from KMC_Feed where CountryCode='"+ CountryCode +"' and FaciCode='"+ FaciCode +"' and DataId='"+ DataId +"'");
         return ONo;
     }
}