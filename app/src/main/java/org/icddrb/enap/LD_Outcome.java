
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
         LinearLayout secdod;
         View linedod;
         TextView Vlbldod;
         EditText dtpdod;
         LinearLayout sectod;
         View linetod;
         TextView Vlbltod;
         EditText txttod;
         LinearLayout secmatcond;
         View linematcond;
         TextView Vlblmatcond;
         RadioGroup rdogrpmatcond;
         
         RadioButton rdomatcond1;
         RadioButton rdomatcond2;
         LinearLayout secmatdschd;
         View linematdschd;
         TextView Vlblmatdschd;
         Spinner spnmatdschd;
         LinearLayout secmatdschdoth;
         View linematdschdoth;
         TextView Vlblmatdschdoth;
         EditText txtmatdschdoth;
         LinearLayout secbcond;
         View linebcond;
         TextView Vlblbcond;
         Spinner spnbcond;
         LinearLayout secbcondDT;
         View linebcondDT;
         TextView VlblbcondDT;
         EditText dtpbcondDT;
         LinearLayout secbcondTM;
         View linebcondTM;
         TextView VlblbcondTM;
         EditText txtbcondTM;
         LinearLayout secbdschd;
         View linebdschd;
         TextView Vlblbdschd;
         Spinner spnbdschd;
         LinearLayout secbdschdOth;
         View linebdschdOth;
         TextView VlblbdschdOth;
         EditText txtbdschdOth;

    static String TableName;

    static String STARTTIME = "";
    static String DEVICEID  = "";
    static String ENTRYUSER = "";
    MySharedPreferences sp;

    Bundle IDbundle;
    public String COUNTRYCODE = "";
    public String FACICODE = "";
    public String DATAID = "";

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
         secdod=(LinearLayout)findViewById(R.id.secdod);
         linedod=(View)findViewById(R.id.linedod);
         Vlbldod=(TextView) findViewById(R.id.Vlbldod);
         dtpdod=(EditText) findViewById(R.id.dtpdod);
         sectod=(LinearLayout)findViewById(R.id.sectod);
         linetod=(View)findViewById(R.id.linetod);
         Vlbltod=(TextView) findViewById(R.id.Vlbltod);
         txttod=(EditText) findViewById(R.id.txttod);
         secmatcond=(LinearLayout)findViewById(R.id.secmatcond);
         linematcond=(View)findViewById(R.id.linematcond);
         Vlblmatcond = (TextView) findViewById(R.id.Vlblmatcond);
         rdogrpmatcond = (RadioGroup) findViewById(R.id.rdogrpmatcond);
         
         rdomatcond1 = (RadioButton) findViewById(R.id.rdomatcond1);
         rdomatcond2 = (RadioButton) findViewById(R.id.rdomatcond2);
         rdogrpmatcond.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpmatcond = new String[] {"1","2"};
             for (int i = 0; i < rdogrpmatcond.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpmatcond.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpmatcond[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secmatdschd.setVisibility(View.GONE);
                    linematdschd.setVisibility(View.GONE);
                    spnmatdschd.setSelection(0);
                    secmatdschdoth.setVisibility(View.GONE);
                    linematdschdoth.setVisibility(View.GONE);
                    txtmatdschdoth.setText("");
             }
             else
             {
                    secmatdschd.setVisibility(View.VISIBLE);
                    linematdschd.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secmatdschd=(LinearLayout)findViewById(R.id.secmatdschd);
         linematdschd=(View)findViewById(R.id.linematdschd);
         Vlblmatdschd=(TextView) findViewById(R.id.Vlblmatdschd);
         spnmatdschd=(Spinner) findViewById(R.id.spnmatdschd);
         List<String> listmatdschd = new ArrayList<String>();
         
         listmatdschd.add("");
         listmatdschd.add("1-Home");
         listmatdschd.add("2-Inpatient- postnatal ward");
         listmatdschd.add("3-Inpatient- KMC bed");
         listmatdschd.add("4-Referral to higher level inpatient care in another facility");
         listmatdschd.add("7-Inpatient-Other");
         ArrayAdapter<String> adptrmatdschd= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listmatdschd);
         spnmatdschd.setAdapter(adptrmatdschd);

         spnmatdschd.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             if (spnmatdschd.getSelectedItem().toString().length() == 0) return;
             String spnData = Connection.SelectedSpinnerValue(spnmatdschd.getSelectedItem().toString(),"-");
                 if(spnData.equalsIgnoreCase("1"))
                 {
                    secmatdschdoth.setVisibility(View.GONE);
                    linematdschdoth.setVisibility(View.GONE);
                    txtmatdschdoth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                    secmatdschdoth.setVisibility(View.GONE);
                    linematdschdoth.setVisibility(View.GONE);
                    txtmatdschdoth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("3"))
                 {
                    secmatdschdoth.setVisibility(View.GONE);
                    linematdschdoth.setVisibility(View.GONE);
                    txtmatdschdoth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("4"))
                 {
                    secmatdschdoth.setVisibility(View.GONE);
                    linematdschdoth.setVisibility(View.GONE);
                    txtmatdschdoth.setText("");
                 }
                 else
                 {
                    secmatdschdoth.setVisibility(View.VISIBLE);
                    linematdschdoth.setVisibility(View.VISIBLE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secmatdschdoth=(LinearLayout)findViewById(R.id.secmatdschdoth);
         linematdschdoth=(View)findViewById(R.id.linematdschdoth);
         Vlblmatdschdoth=(TextView) findViewById(R.id.Vlblmatdschdoth);
         txtmatdschdoth=(EditText) findViewById(R.id.txtmatdschdoth);
         secbcond=(LinearLayout)findViewById(R.id.secbcond);
         linebcond=(View)findViewById(R.id.linebcond);
         Vlblbcond=(TextView) findViewById(R.id.Vlblbcond);
         spnbcond=(Spinner) findViewById(R.id.spnbcond);
         List<String> listbcond = new ArrayList<String>();
         
         listbcond.add("");
         listbcond.add("1-Alive");
         listbcond.add("2-Stillbirth- fresh");
         listbcond.add("3-Stillbirth- macerated");
         listbcond.add("4-Neonatal death");
         ArrayAdapter<String> adptrbcond= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listbcond);
         spnbcond.setAdapter(adptrbcond);

         spnbcond.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             if (spnbcond.getSelectedItem().toString().length() == 0) return;
             String spnData = Connection.SelectedSpinnerValue(spnbcond.getSelectedItem().toString(),"-");
                 if(spnData.equalsIgnoreCase("1"))
                 {
                    secbcondDT.setVisibility(View.GONE);
                    linebcondDT.setVisibility(View.GONE);
                    dtpbcondDT.setText("");
                    secbcondTM.setVisibility(View.GONE);
                    linebcondTM.setVisibility(View.GONE);
                    txtbcondTM.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                    secbcondDT.setVisibility(View.GONE);
                    linebcondDT.setVisibility(View.GONE);
                    dtpbcondDT.setText("");
                    secbcondTM.setVisibility(View.GONE);
                    linebcondTM.setVisibility(View.GONE);
                    txtbcondTM.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("3"))
                 {
                    secbcondDT.setVisibility(View.GONE);
                    linebcondDT.setVisibility(View.GONE);
                    dtpbcondDT.setText("");
                    secbcondTM.setVisibility(View.GONE);
                    linebcondTM.setVisibility(View.GONE);
                    txtbcondTM.setText("");
                 }
                 else
                 {
                    secbcondDT.setVisibility(View.VISIBLE);
                    linebcondDT.setVisibility(View.VISIBLE);
                    secbcondTM.setVisibility(View.VISIBLE);
                    linebcondTM.setVisibility(View.VISIBLE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secbcondDT=(LinearLayout)findViewById(R.id.secbcondDT);
         linebcondDT=(View)findViewById(R.id.linebcondDT);
         VlblbcondDT=(TextView) findViewById(R.id.VlblbcondDT);
         dtpbcondDT=(EditText) findViewById(R.id.dtpbcondDT);
         secbcondTM=(LinearLayout)findViewById(R.id.secbcondTM);
         linebcondTM=(View)findViewById(R.id.linebcondTM);
         VlblbcondTM=(TextView) findViewById(R.id.VlblbcondTM);
         txtbcondTM=(EditText) findViewById(R.id.txtbcondTM);
         secbdschd=(LinearLayout)findViewById(R.id.secbdschd);
         linebdschd=(View)findViewById(R.id.linebdschd);
         Vlblbdschd=(TextView) findViewById(R.id.Vlblbdschd);
         spnbdschd=(Spinner) findViewById(R.id.spnbdschd);
         List<String> listbdschd = new ArrayList<String>();
         
         listbdschd.add("");
         listbdschd.add("1-Postnatal ward with mother");
         listbdschd.add("2-Inpatient newborn");
         listbdschd.add("3-Inpatient KMC");
         listbdschd.add("7-Other");
         ArrayAdapter<String> adptrbdschd= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listbdschd);
         spnbdschd.setAdapter(adptrbdschd);

         spnbdschd.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             if (spnbdschd.getSelectedItem().toString().length() == 0) return;
             String spnData = Connection.SelectedSpinnerValue(spnbdschd.getSelectedItem().toString(),"-");
                 if(spnData.equalsIgnoreCase("1"))
                 {
                    secbdschdOth.setVisibility(View.GONE);
                    linebdschdOth.setVisibility(View.GONE);
                    txtbdschdOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                    secbdschdOth.setVisibility(View.GONE);
                    linebdschdOth.setVisibility(View.GONE);
                    txtbdschdOth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("3"))
                 {
                    secbdschdOth.setVisibility(View.GONE);
                    linebdschdOth.setVisibility(View.GONE);
                    txtbdschdOth.setText("");
                 }
                 else
                 {
                    secbdschdOth.setVisibility(View.VISIBLE);
                    linebdschdOth.setVisibility(View.VISIBLE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secbdschdOth=(LinearLayout)findViewById(R.id.secbdschdOth);
         linebdschdOth=(View)findViewById(R.id.linebdschdOth);
         VlblbdschdOth=(TextView) findViewById(R.id.VlblbdschdOth);
         txtbdschdOth=(EditText) findViewById(R.id.txtbdschdOth);


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
         dtpbcondDT.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpbcondDT.getRight() - dtpbcondDT.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnbcondDT"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });


         txttod.setOnTouchListener(new View.OnTouchListener() {
         @Override
         public boolean onTouch(View v, MotionEvent event) {
             final int DRAWABLE_RIGHT = 2;
             if(event.getAction() == MotionEvent.ACTION_UP) {
                 if(event.getRawX() >= (txttod.getRight() - txttod.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                     VariableID = "btntod"; showDialog(TIME_DIALOG);
                  return true;
                 }
             }
             return false;
           }
         });
         txtbcondTM.setOnTouchListener(new View.OnTouchListener() {
         @Override
         public boolean onTouch(View v, MotionEvent event) {
             final int DRAWABLE_RIGHT = 2;
             if(event.getAction() == MotionEvent.ACTION_UP) {
                 if(event.getRawX() >= (txtbcondTM.getRight() - txtbcondTM.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                     VariableID = "btnbcondTM"; showDialog(TIME_DIALOG);
                  return true;
                 }
             }
             return false;
           }
         });

         //Hide all skip variables
         secmatdschd.setVisibility(View.GONE);
         linematdschd.setVisibility(View.GONE);
         secmatdschdoth.setVisibility(View.GONE);
         linematdschdoth.setVisibility(View.GONE);
         secmatdschdoth.setVisibility(View.GONE);
         linematdschdoth.setVisibility(View.GONE);
         secmatdschdoth.setVisibility(View.GONE);
         linematdschdoth.setVisibility(View.GONE);
         secmatdschdoth.setVisibility(View.GONE);
         linematdschdoth.setVisibility(View.GONE);
         secmatdschdoth.setVisibility(View.GONE);
         linematdschdoth.setVisibility(View.GONE);
         secbcondDT.setVisibility(View.GONE);
         linebcondDT.setVisibility(View.GONE);
         secbcondTM.setVisibility(View.GONE);
         linebcondTM.setVisibility(View.GONE);
         secbcondDT.setVisibility(View.GONE);
         linebcondDT.setVisibility(View.GONE);
         secbcondTM.setVisibility(View.GONE);
         linebcondTM.setVisibility(View.GONE);
         secbcondDT.setVisibility(View.GONE);
         linebcondDT.setVisibility(View.GONE);
         secbcondTM.setVisibility(View.GONE);
         linebcondTM.setVisibility(View.GONE);
         secbdschdOth.setVisibility(View.GONE);
         linebdschdOth.setVisibility(View.GONE);
         secbdschdOth.setVisibility(View.GONE);
         linebdschdOth.setVisibility(View.GONE);
         secbdschdOth.setVisibility(View.GONE);
         linebdschdOth.setVisibility(View.GONE);

        DataSearch(COUNTRYCODE, FACICODE, DATAID);
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
     dtpdod.setText("");
     txttod.setText("");
     rdogrpmatcond.clearCheck();
     spnmatdschd.setSelection(0);
     txtmatdschdoth.setText("");
     spnbcond.setSelection(0);
     dtpbcondDT.setText("");
     txtbcondTM.setText("");
     spnbdschd.setSelection(0);
     txtbdschdOth.setText("");
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
         DV = Global.DateValidate(dtpdod.getText().toString());
         if(DV.length()!=0 & secdod.isShown())
           {
             Connection.MessageBox(LD_Outcome.this, DV);
             dtpdod.requestFocus(); 
             return;	
           }
         else if(txttod.getText().length()==0 & sectod.isShown())
           {
             Connection.MessageBox(LD_Outcome.this, "Required field: Time of discharge (24 hrs clock).");
             txttod.requestFocus(); 
             return;	
           }
         
         else if(!rdomatcond1.isChecked() & !rdomatcond2.isChecked() & secmatcond.isShown())
           {
              Connection.MessageBox(LD_Outcome.this, "Select anyone options from (Mother’s condition at discharge from labour ward: ).");
              rdomatcond1.requestFocus();
              return;
           }
         else if(spnmatdschd.getSelectedItemPosition()==0  & secmatdschd.isShown())
           {
             Connection.MessageBox(LD_Outcome.this, "Required field: Mother discharged to:.");
             spnmatdschd.requestFocus(); 
             return;	
           }
         else if(txtmatdschdoth.getText().toString().length()==0 & secmatdschdoth.isShown())
           {
             Connection.MessageBox(LD_Outcome.this, "Required field: Others.");
             txtmatdschdoth.requestFocus(); 
             return;	
           }
         else if(spnbcond.getSelectedItemPosition()==0  & secbcond.isShown())
           {
             Connection.MessageBox(LD_Outcome.this, "Required field: Babys condition at discharge from labour ward:.");
             spnbcond.requestFocus(); 
             return;	
           }
         DV = Global.DateValidate(dtpbcondDT.getText().toString());
         if(DV.length()!=0 & secbcondDT.isShown())
           {
             Connection.MessageBox(LD_Outcome.this, DV);
             dtpbcondDT.requestFocus(); 
             return;	
           }
         else if(txtbcondTM.getText().length()==0 & secbcondTM.isShown())
           {
             Connection.MessageBox(LD_Outcome.this, "Required field: Time of baby death.");
             txtbcondTM.requestFocus(); 
             return;	
           }
         else if(spnbdschd.getSelectedItemPosition()==0  & secbdschd.isShown())
           {
             Connection.MessageBox(LD_Outcome.this, "Required field: Baby discharged/transferred to.");
             spnbdschd.requestFocus(); 
             return;	
           }
         else if(txtbdschdOth.getText().toString().length()==0 & secbdschdOth.isShown())
           {
             Connection.MessageBox(LD_Outcome.this, "Required field: Others.");
             txtbdschdOth.requestFocus(); 
             return;	
           }
 
         String SQL = "";
         RadioButton rb;

         LD_Outcome_DataModel objSave = new LD_Outcome_DataModel();
         objSave.setCountryCode(txtCountryCode.getText().toString());
         objSave.setFaciCode(txtFaciCode.getText().toString());
         objSave.setDataID(txtDataID.getText().toString());
         objSave.setdod(dtpdod.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpdod.getText().toString()) : dtpdod.getText().toString());
         objSave.settod(txttod.getText().toString());
         String[] d_rdogrpmatcond = new String[] {"1","2"};
         objSave.setmatcond("");
         for (int i = 0; i < rdogrpmatcond.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpmatcond.getChildAt(i);
             if (rb.isChecked()) objSave.setmatcond(d_rdogrpmatcond[i]);
         }

         objSave.setmatdschd((spnmatdschd.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnmatdschd.getSelectedItem().toString(), "-")));
         objSave.setmatdschdoth(txtmatdschdoth.getText().toString());
         objSave.setbcond((spnbcond.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnbcond.getSelectedItem().toString(), "-")));
         objSave.setbcondDT(dtpbcondDT.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpbcondDT.getText().toString()) : dtpbcondDT.getText().toString());
         objSave.setbcondTM(txtbcondTM.getText().toString());
         objSave.setbdschd((spnbdschd.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnbdschd.getSelectedItem().toString(), "-")));
         objSave.setbdschdOth(txtbdschdOth.getText().toString());
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

             Connection.MessageBoxNotClose(LD_Outcome.this, "Saved Successfully");
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
             dtpdod.setText(item.getdod().toString().length()==0 ? "" : Global.DateConvertDMY(item.getdod()));
             txttod.setText(item.gettod());
             String[] d_rdogrpmatcond = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpmatcond.length; i++)
             {
                 if (item.getmatcond().equals(String.valueOf(d_rdogrpmatcond[i])))
                 {
                     rb = (RadioButton)rdogrpmatcond.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             spnmatdschd.setSelection(Global.SpinnerItemPositionAnyLength(spnmatdschd, item.getmatdschd()));
             txtmatdschdoth.setText(item.getmatdschdoth());
             spnbcond.setSelection(Global.SpinnerItemPositionAnyLength(spnbcond, item.getbcond()));
             dtpbcondDT.setText(item.getbcondDT().toString().length()==0 ? "" : Global.DateConvertDMY(item.getbcondDT()));
             txtbcondTM.setText(item.getbcondTM());
             spnbdschd.setSelection(Global.SpinnerItemPositionAnyLength(spnbdschd, item.getbdschd()));
             txtbdschdOth.setText(item.getbdschdOth());
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


              dtpDate = (EditText)findViewById(R.id.dtpdod);
             if (VariableID.equals("btndod"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpdod);
              }
             else if (VariableID.equals("btnbcondDT"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpbcondDT);
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


              tpTime = (EditText)findViewById(R.id.txttod);
             if (VariableID.equals("btntod"))
              {
                  tpTime = (EditText)findViewById(R.id.txttod);
              }
             else if (VariableID.equals("btnbcondTM"))
              {
                  tpTime = (EditText)findViewById(R.id.txtbcondTM);
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