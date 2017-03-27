
 package org.icddrb.enap;


 //Android Manifest Code
 //<activity android:name=".RecallSurvS4" android:label="RecallSurvS4" />
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

 public class RecallSurvS4 extends Activity {
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
         LinearLayout secDataId;
         View lineDataId;
         TextView VlblDataId;
         EditText txtDataId;
         LinearLayout secStudyID;
         View lineStudyID;
         TextView VlblStudyID;
         EditText txtStudyID;
         LinearLayout seclblSectionIV;
         View linelblSectionIV;
         LinearLayout secknowadwgtkmc;
         View lineknowadwgtkmc;
         TextView Vlblknowadwgtkmc;
         RadioGroup rdogrpknowadwgtkmc;
         
         RadioButton rdoknowadwgtkmc1;
         RadioButton rdoknowadwgtkmc2;
         RadioButton rdoknowadwgtkmc3;
         LinearLayout secadwgtkmc;
         View lineadwgtkmc;
         TextView Vlbladwgtkmc;
         EditText txtadwgtkmc;
         LinearLayout secadwgtkmcDK;
         View lineadwgtkmcDK;
         TextView VlbladwgtkmcDK;
         CheckBox chkadwgtkmcDK;
         LinearLayout sechelpkmc;
         View linehelpkmc;
         TextView Vlblhelpkmc;
         RadioGroup rdogrphelpkmc;
         
         RadioButton rdohelpkmc1;
         RadioButton rdohelpkmc2;
         RadioButton rdohelpkmc3;
         LinearLayout secknowkmc;
         View lineknowkmc;
         TextView Vlblknowkmc;
         RadioGroup rdogrpknowkmc;
         
         RadioButton rdoknowkmc1;
         RadioButton rdoknowkmc2;
         RadioButton rdoknowkmc3;
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
         Spinner spnkmcwho;
         LinearLayout seckmcwhoOth;
         View linekmcwhoOth;
         TextView VlblkmcwhoOth;
         EditText txtkmcwhoOth;
         LinearLayout seclbl06;
         View linelbl06;
         LinearLayout seckmcreasA;
         View linekmcreasA;
         TextView VlblkmcreasA;
         CheckBox chkkmcreasA;
         LinearLayout seckmcreasB;
         View linekmcreasB;
         TextView VlblkmcreasB;
         CheckBox chkkmcreasB;
         LinearLayout seckmcreasC;
         View linekmcreasC;
         TextView VlblkmcreasC;
         CheckBox chkkmcreasC;
         LinearLayout seckmcreasD;
         View linekmcreasD;
         TextView VlblkmcreasD;
         CheckBox chkkmcreasD;
         LinearLayout seckmcreasE;
         View linekmcreasE;
         TextView VlblkmcreasE;
         CheckBox chkkmcreasE;
         LinearLayout seckmcreasF;
         View linekmcreasF;
         TextView VlblkmcreasF;
         CheckBox chkkmcreasF;
         LinearLayout seckmcreasOth;
         View linekmcreasOth;
         TextView VlblkmcreasOth;
         EditText txtkmcreasOth;
         LinearLayout seckmcreasG;
         View linekmcreasG;
         TextView VlblkmcreasG;
         CheckBox chkkmcreasG;
         LinearLayout seclbl07;
         View linelbl07;
         LinearLayout seckmcposA;
         View linekmcposA;
         TextView VlblkmcposA;
         CheckBox chkkmcposA;
         LinearLayout seckmcposB;
         View linekmcposB;
         TextView VlblkmcposB;
         CheckBox chkkmcposB;
         LinearLayout seckmcposC;
         View linekmcposC;
         TextView VlblkmcposC;
         CheckBox chkkmcposC;
         LinearLayout seckmcposD;
         View linekmcposD;
         TextView VlblkmcposD;
         CheckBox chkkmcposD;
         LinearLayout seckmcposE;
         View linekmcposE;
         TextView VlblkmcposE;
         CheckBox chkkmcposE;
         LinearLayout seckmcposF;
         View linekmcposF;
         TextView VlblkmcposF;
         CheckBox chkkmcposF;
         LinearLayout seckmcposG;
         View linekmcposG;
         TextView VlblkmcposG;
         CheckBox chkkmcposG;
         LinearLayout seckmcposH;
         View linekmcposH;
         TextView VlblkmcposH;
         CheckBox chkkmcposH;
         LinearLayout seckmcposI;
         View linekmcposI;
         TextView VlblkmcposI;
         CheckBox chkkmcposI;
         LinearLayout seclbl08;
         View linelbl08;
         LinearLayout seckmcedA;
         View linekmcedA;
         TextView VlblkmcedA;
         CheckBox chkkmcedA;
         LinearLayout seckmcedB;
         View linekmcedB;
         TextView VlblkmcedB;
         CheckBox chkkmcedB;
         LinearLayout seckmcedC;
         View linekmcedC;
         TextView VlblkmcedC;
         CheckBox chkkmcedC;
         LinearLayout seckmcedD;
         View linekmcedD;
         TextView VlblkmcedD;
         CheckBox chkkmcedD;
         LinearLayout seckmcedE;
         View linekmcedE;
         TextView VlblkmcedE;
         CheckBox chkkmcedE;
         LinearLayout seckmcedF;
         View linekmcedF;
         TextView VlblkmcedF;
         CheckBox chkkmcedF;
         LinearLayout seckmcedG;
         View linekmcedG;
         TextView VlblkmcedG;
         CheckBox chkkmcedG;
         LinearLayout seckmcedH;
         View linekmcedH;
         TextView VlblkmcedH;
         CheckBox chkkmcedH;
         LinearLayout seckmctime;
         View linekmctime;
         TextView Vlblkmctime;
         EditText txtkmctime;
         LinearLayout seckmctimeDK;
         View linekmctimeDK;
         TextView VlblkmctimeDK;
         CheckBox chkkmctimeDK;
         LinearLayout secreasnokmc;
         View linereasnokmc;
         TextView Vlblreasnokmc;
         Spinner spnreasnokmc;
         LinearLayout secreasnokmcOth;
         View linereasnokmcOth;
         TextView VlblreasnokmcOth;
         EditText txtreasnokmcOth;
         LinearLayout secbfmeth;
         View linebfmeth;
         TextView Vlblbfmeth;
         Spinner spnbfmeth;
         LinearLayout secbfmethDur;
         View linebfmethDur;
         TextView VlblbfmethDur;
         EditText txtbfmethDur;
         LinearLayout secknowunwellsigns;
         View lineknowunwellsigns;
         TextView Vlblknowunwellsigns;
         Spinner spnknowunwellsigns;
         LinearLayout seclbl13;
         View linelbl13;
         LinearLayout secunwellsignsA;
         View lineunwellsignsA;
         TextView VlblunwellsignsA;
         CheckBox chkunwellsignsA;
         LinearLayout secunwellsignsB;
         View lineunwellsignsB;
         TextView VlblunwellsignsB;
         CheckBox chkunwellsignsB;
         LinearLayout secunwellsignsC;
         View lineunwellsignsC;
         TextView VlblunwellsignsC;
         CheckBox chkunwellsignsC;
         LinearLayout secunwellsignsD;
         View lineunwellsignsD;
         TextView VlblunwellsignsD;
         CheckBox chkunwellsignsD;
         LinearLayout secunwellsignsE;
         View lineunwellsignsE;
         TextView VlblunwellsignsE;
         CheckBox chkunwellsignsE;
         LinearLayout secunwellsignsF;
         View lineunwellsignsF;
         TextView VlblunwellsignsF;
         CheckBox chkunwellsignsF;
         LinearLayout secunwellsignsFOth;
         View lineunwellsignsFOth;
         TextView VlblunwellsignsFOth;
         EditText txtunwellsignsFOth;
         LinearLayout secunwellsignsG;
         View lineunwellsignsG;
         TextView VlblunwellsignsG;
         CheckBox chkunwellsignsG;
         LinearLayout secprediscouns;
         View lineprediscouns;
         TextView Vlblprediscouns;
         Spinner spnprediscouns;
         LinearLayout seclbl14;
         View linelbl14;
         LinearLayout seccounconsA;
         View linecounconsA;
         TextView VlblcounconsA;
         Spinner spncounconsA;
         LinearLayout seccounconsB;
         View linecounconsB;
         TextView VlblcounconsB;
         Spinner spncounconsB;
         LinearLayout seccounconsC;
         View linecounconsC;
         TextView VlblcounconsC;
         Spinner spncounconsC;
         LinearLayout secloskmc;
         View lineloskmc;
         TextView Vlblloskmc;
         EditText txtloskmc;
         LinearLayout secloskmcDK;
         View lineloskmcDK;
         TextView VlblloskmcDK;
         CheckBox chkloskmcDK;
         LinearLayout secknowdiswgt;
         View lineknowdiswgt;
         TextView Vlblknowdiswgt;
         Spinner spnknowdiswgt;
         LinearLayout secdiswgtkmc;
         View linediswgtkmc;
         TextView Vlbldiswgtkmc;
         EditText txtdiswgtkmc;
         LinearLayout secdiswgtkmcDK;
         View linediswgtkmcDK;
         TextView VlbldiswgtkmcDK;
         CheckBox chkdiswgtkmcDK;
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

 public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
   try
     {
         setContentView(R.layout.recallsurvs4);
         C = new Connection(this);
         g = Global.getInstance();

         STARTTIME = g.CurrentTime24();
         DEVICEID  = sp.getValue(this, "deviceid");
         ENTRYUSER = sp.getValue(this, "userid");

         IDbundle = getIntent().getExtras();
         COUNTRYCODE = IDbundle.getString("CountryCode");
         FACICODE = IDbundle.getString("FaciCode");
         DATAID = IDbundle.getString("DataId");

         TableName = "RecallSurvS4";

         //turnGPSOn();

         //GPS Location
         //FindLocation();
         // Double.toString(currentLatitude);
         // Double.toString(currentLongitude);
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(RecallSurvS4.this);
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
         secDataId=(LinearLayout)findViewById(R.id.secDataId);
         lineDataId=(View)findViewById(R.id.lineDataId);
         VlblDataId=(TextView) findViewById(R.id.VlblDataId);
         txtDataId=(EditText) findViewById(R.id.txtDataId);
         secStudyID=(LinearLayout)findViewById(R.id.secStudyID);
         lineStudyID=(View)findViewById(R.id.lineStudyID);
         VlblStudyID=(TextView) findViewById(R.id.VlblStudyID);
         txtStudyID=(EditText) findViewById(R.id.txtStudyID);
         seclblSectionIV=(LinearLayout)findViewById(R.id.seclblSectionIV);
         linelblSectionIV=(View)findViewById(R.id.linelblSectionIV);
         secknowadwgtkmc=(LinearLayout)findViewById(R.id.secknowadwgtkmc);
         lineknowadwgtkmc=(View)findViewById(R.id.lineknowadwgtkmc);
         Vlblknowadwgtkmc = (TextView) findViewById(R.id.Vlblknowadwgtkmc);
         rdogrpknowadwgtkmc = (RadioGroup) findViewById(R.id.rdogrpknowadwgtkmc);
         
         rdoknowadwgtkmc1 = (RadioButton) findViewById(R.id.rdoknowadwgtkmc1);
         rdoknowadwgtkmc2 = (RadioButton) findViewById(R.id.rdoknowadwgtkmc2);
         rdoknowadwgtkmc3 = (RadioButton) findViewById(R.id.rdoknowadwgtkmc3);
         rdogrpknowadwgtkmc.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpknowadwgtkmc = new String[] {"01","02","98"};
             for (int i = 0; i < rdogrpknowadwgtkmc.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpknowadwgtkmc.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpknowadwgtkmc[i];
             }

             if(rbData.equalsIgnoreCase("02"))
             {
                    secadwgtkmc.setVisibility(View.GONE);
                    lineadwgtkmc.setVisibility(View.GONE);
                    txtadwgtkmc.setText("");
                    secadwgtkmcDK.setVisibility(View.GONE);
                    lineadwgtkmcDK.setVisibility(View.GONE);
                    chkadwgtkmcDK.setChecked(false);
             }
             else if(rbData.equalsIgnoreCase("98"))
             {
                    secadwgtkmc.setVisibility(View.GONE);
                    lineadwgtkmc.setVisibility(View.GONE);
                    txtadwgtkmc.setText("");
                    secadwgtkmcDK.setVisibility(View.GONE);
                    lineadwgtkmcDK.setVisibility(View.GONE);
                    chkadwgtkmcDK.setChecked(false);
             }
             else
             {
                    secadwgtkmc.setVisibility(View.VISIBLE);
                    lineadwgtkmc.setVisibility(View.VISIBLE);
                    secadwgtkmcDK.setVisibility(View.VISIBLE);
                    lineadwgtkmcDK.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secadwgtkmc=(LinearLayout)findViewById(R.id.secadwgtkmc);
         lineadwgtkmc=(View)findViewById(R.id.lineadwgtkmc);
         Vlbladwgtkmc=(TextView) findViewById(R.id.Vlbladwgtkmc);
         txtadwgtkmc=(EditText) findViewById(R.id.txtadwgtkmc);
         secadwgtkmcDK=(LinearLayout)findViewById(R.id.secadwgtkmcDK);
         lineadwgtkmcDK=(View)findViewById(R.id.lineadwgtkmcDK);
         VlbladwgtkmcDK=(TextView) findViewById(R.id.VlbladwgtkmcDK);
         chkadwgtkmcDK=(CheckBox) findViewById(R.id.chkadwgtkmcDK);
         sechelpkmc=(LinearLayout)findViewById(R.id.sechelpkmc);
         linehelpkmc=(View)findViewById(R.id.linehelpkmc);
         Vlblhelpkmc = (TextView) findViewById(R.id.Vlblhelpkmc);
         rdogrphelpkmc = (RadioGroup) findViewById(R.id.rdogrphelpkmc);
         
         rdohelpkmc1 = (RadioButton) findViewById(R.id.rdohelpkmc1);
         rdohelpkmc2 = (RadioButton) findViewById(R.id.rdohelpkmc2);
         rdohelpkmc3 = (RadioButton) findViewById(R.id.rdohelpkmc3);
         secknowkmc=(LinearLayout)findViewById(R.id.secknowkmc);
         lineknowkmc=(View)findViewById(R.id.lineknowkmc);
         Vlblknowkmc = (TextView) findViewById(R.id.Vlblknowkmc);
         rdogrpknowkmc = (RadioGroup) findViewById(R.id.rdogrpknowkmc);
         
         rdoknowkmc1 = (RadioButton) findViewById(R.id.rdoknowkmc1);
         rdoknowkmc2 = (RadioButton) findViewById(R.id.rdoknowkmc2);
         rdoknowkmc3 = (RadioButton) findViewById(R.id.rdoknowkmc3);
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
             String[] d_rdogrpkmc = new String[] {"01","02","98"};
             for (int i = 0; i < rdogrpkmc.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpkmc.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpkmc[i];
             }

             if(rbData.equalsIgnoreCase("02"))
             {
                    seckmcwho.setVisibility(View.GONE);
                    linekmcwho.setVisibility(View.GONE);
                    spnkmcwho.setSelection(0);
                    seckmcwhoOth.setVisibility(View.GONE);
                    linekmcwhoOth.setVisibility(View.GONE);
                    txtkmcwhoOth.setText("");
                    seclbl06.setVisibility(View.GONE);
                    linelbl06.setVisibility(View.GONE);
                    seckmcreasA.setVisibility(View.GONE);
                    linekmcreasA.setVisibility(View.GONE);
                    chkkmcreasA.setChecked(false);
                    seckmcreasB.setVisibility(View.GONE);
                    linekmcreasB.setVisibility(View.GONE);
                    chkkmcreasB.setChecked(false);
                    seckmcreasC.setVisibility(View.GONE);
                    linekmcreasC.setVisibility(View.GONE);
                    chkkmcreasC.setChecked(false);
                    seckmcreasD.setVisibility(View.GONE);
                    linekmcreasD.setVisibility(View.GONE);
                    chkkmcreasD.setChecked(false);
                    seckmcreasE.setVisibility(View.GONE);
                    linekmcreasE.setVisibility(View.GONE);
                    chkkmcreasE.setChecked(false);
                    seckmcreasF.setVisibility(View.GONE);
                    linekmcreasF.setVisibility(View.GONE);
                    chkkmcreasF.setChecked(false);
                    seckmcreasOth.setVisibility(View.GONE);
                    linekmcreasOth.setVisibility(View.GONE);
                    txtkmcreasOth.setText("");
                    seckmcreasG.setVisibility(View.GONE);
                    linekmcreasG.setVisibility(View.GONE);
                    chkkmcreasG.setChecked(false);
                    seclbl07.setVisibility(View.GONE);
                    linelbl07.setVisibility(View.GONE);
                    seckmcposA.setVisibility(View.GONE);
                    linekmcposA.setVisibility(View.GONE);
                    chkkmcposA.setChecked(false);
                    seckmcposB.setVisibility(View.GONE);
                    linekmcposB.setVisibility(View.GONE);
                    chkkmcposB.setChecked(false);
                    seckmcposC.setVisibility(View.GONE);
                    linekmcposC.setVisibility(View.GONE);
                    chkkmcposC.setChecked(false);
                    seckmcposD.setVisibility(View.GONE);
                    linekmcposD.setVisibility(View.GONE);
                    chkkmcposD.setChecked(false);
                    seckmcposE.setVisibility(View.GONE);
                    linekmcposE.setVisibility(View.GONE);
                    chkkmcposE.setChecked(false);
                    seckmcposF.setVisibility(View.GONE);
                    linekmcposF.setVisibility(View.GONE);
                    chkkmcposF.setChecked(false);
                    seckmcposG.setVisibility(View.GONE);
                    linekmcposG.setVisibility(View.GONE);
                    chkkmcposG.setChecked(false);
                    seckmcposH.setVisibility(View.GONE);
                    linekmcposH.setVisibility(View.GONE);
                    chkkmcposH.setChecked(false);
                    seckmcposI.setVisibility(View.GONE);
                    linekmcposI.setVisibility(View.GONE);
                    chkkmcposI.setChecked(false);
                    seclbl08.setVisibility(View.GONE);
                    linelbl08.setVisibility(View.GONE);
                    seckmcedA.setVisibility(View.GONE);
                    linekmcedA.setVisibility(View.GONE);
                    chkkmcedA.setChecked(false);
                    seckmcedB.setVisibility(View.GONE);
                    linekmcedB.setVisibility(View.GONE);
                    chkkmcedB.setChecked(false);
                    seckmcedC.setVisibility(View.GONE);
                    linekmcedC.setVisibility(View.GONE);
                    chkkmcedC.setChecked(false);
                    seckmcedD.setVisibility(View.GONE);
                    linekmcedD.setVisibility(View.GONE);
                    chkkmcedD.setChecked(false);
                    seckmcedE.setVisibility(View.GONE);
                    linekmcedE.setVisibility(View.GONE);
                    chkkmcedE.setChecked(false);
                    seckmcedF.setVisibility(View.GONE);
                    linekmcedF.setVisibility(View.GONE);
                    chkkmcedF.setChecked(false);
                    seckmcedG.setVisibility(View.GONE);
                    linekmcedG.setVisibility(View.GONE);
                    chkkmcedG.setChecked(false);
                    seckmcedH.setVisibility(View.GONE);
                    linekmcedH.setVisibility(View.GONE);
                    chkkmcedH.setChecked(false);
                    seckmctime.setVisibility(View.GONE);
                    linekmctime.setVisibility(View.GONE);
                    txtkmctime.setText("");
                    seckmctimeDK.setVisibility(View.GONE);
                    linekmctimeDK.setVisibility(View.GONE);
                    chkkmctimeDK.setChecked(false);
                    secreasnokmc.setVisibility(View.GONE);
                    linereasnokmc.setVisibility(View.GONE);
                    spnreasnokmc.setSelection(0);
                    secreasnokmcOth.setVisibility(View.GONE);
                    linereasnokmcOth.setVisibility(View.GONE);
                    txtreasnokmcOth.setText("");
                    secbfmeth.setVisibility(View.GONE);
                    linebfmeth.setVisibility(View.GONE);
                    spnbfmeth.setSelection(0);
                    secbfmethDur.setVisibility(View.GONE);
                    linebfmethDur.setVisibility(View.GONE);
                    txtbfmethDur.setText("");
                    secknowunwellsigns.setVisibility(View.GONE);
                    lineknowunwellsigns.setVisibility(View.GONE);
                    spnknowunwellsigns.setSelection(0);
                    seclbl13.setVisibility(View.GONE);
                    linelbl13.setVisibility(View.GONE);
                    secunwellsignsA.setVisibility(View.GONE);
                    lineunwellsignsA.setVisibility(View.GONE);
                    chkunwellsignsA.setChecked(false);
                    secunwellsignsB.setVisibility(View.GONE);
                    lineunwellsignsB.setVisibility(View.GONE);
                    chkunwellsignsB.setChecked(false);
                    secunwellsignsC.setVisibility(View.GONE);
                    lineunwellsignsC.setVisibility(View.GONE);
                    chkunwellsignsC.setChecked(false);
                    secunwellsignsD.setVisibility(View.GONE);
                    lineunwellsignsD.setVisibility(View.GONE);
                    chkunwellsignsD.setChecked(false);
                    secunwellsignsE.setVisibility(View.GONE);
                    lineunwellsignsE.setVisibility(View.GONE);
                    chkunwellsignsE.setChecked(false);
                    secunwellsignsF.setVisibility(View.GONE);
                    lineunwellsignsF.setVisibility(View.GONE);
                    chkunwellsignsF.setChecked(false);
                    secunwellsignsFOth.setVisibility(View.GONE);
                    lineunwellsignsFOth.setVisibility(View.GONE);
                    txtunwellsignsFOth.setText("");
                    secunwellsignsG.setVisibility(View.GONE);
                    lineunwellsignsG.setVisibility(View.GONE);
                    chkunwellsignsG.setChecked(false);
                    secprediscouns.setVisibility(View.GONE);
                    lineprediscouns.setVisibility(View.GONE);
                    spnprediscouns.setSelection(0);
                    seclbl14.setVisibility(View.GONE);
                    linelbl14.setVisibility(View.GONE);
                    seccounconsA.setVisibility(View.GONE);
                    linecounconsA.setVisibility(View.GONE);
                    spncounconsA.setSelection(0);
                    seccounconsB.setVisibility(View.GONE);
                    linecounconsB.setVisibility(View.GONE);
                    spncounconsB.setSelection(0);
                    seccounconsC.setVisibility(View.GONE);
                    linecounconsC.setVisibility(View.GONE);
                    spncounconsC.setSelection(0);
                    secloskmc.setVisibility(View.GONE);
                    lineloskmc.setVisibility(View.GONE);
                    txtloskmc.setText("");
                    secloskmcDK.setVisibility(View.GONE);
                    lineloskmcDK.setVisibility(View.GONE);
                    chkloskmcDK.setChecked(false);
                    secknowdiswgt.setVisibility(View.GONE);
                    lineknowdiswgt.setVisibility(View.GONE);
                    spnknowdiswgt.setSelection(0);
                    secdiswgtkmc.setVisibility(View.GONE);
                    linediswgtkmc.setVisibility(View.GONE);
                    txtdiswgtkmc.setText("");
                    secdiswgtkmcDK.setVisibility(View.GONE);
                    linediswgtkmcDK.setVisibility(View.GONE);
                    chkdiswgtkmcDK.setChecked(false);
                    seccomments.setVisibility(View.GONE);
                    linecomments.setVisibility(View.GONE);
                    txtcomments.setText("");
             }
             else if(rbData.equalsIgnoreCase("98"))
             {
                    seckmcwho.setVisibility(View.GONE);
                    linekmcwho.setVisibility(View.GONE);
                    spnkmcwho.setSelection(0);
                    seckmcwhoOth.setVisibility(View.GONE);
                    linekmcwhoOth.setVisibility(View.GONE);
                    txtkmcwhoOth.setText("");
                    seclbl06.setVisibility(View.GONE);
                    linelbl06.setVisibility(View.GONE);
                    seckmcreasA.setVisibility(View.GONE);
                    linekmcreasA.setVisibility(View.GONE);
                    chkkmcreasA.setChecked(false);
                    seckmcreasB.setVisibility(View.GONE);
                    linekmcreasB.setVisibility(View.GONE);
                    chkkmcreasB.setChecked(false);
                    seckmcreasC.setVisibility(View.GONE);
                    linekmcreasC.setVisibility(View.GONE);
                    chkkmcreasC.setChecked(false);
                    seckmcreasD.setVisibility(View.GONE);
                    linekmcreasD.setVisibility(View.GONE);
                    chkkmcreasD.setChecked(false);
                    seckmcreasE.setVisibility(View.GONE);
                    linekmcreasE.setVisibility(View.GONE);
                    chkkmcreasE.setChecked(false);
                    seckmcreasF.setVisibility(View.GONE);
                    linekmcreasF.setVisibility(View.GONE);
                    chkkmcreasF.setChecked(false);
                    seckmcreasOth.setVisibility(View.GONE);
                    linekmcreasOth.setVisibility(View.GONE);
                    txtkmcreasOth.setText("");
                    seckmcreasG.setVisibility(View.GONE);
                    linekmcreasG.setVisibility(View.GONE);
                    chkkmcreasG.setChecked(false);
                    seclbl07.setVisibility(View.GONE);
                    linelbl07.setVisibility(View.GONE);
                    seckmcposA.setVisibility(View.GONE);
                    linekmcposA.setVisibility(View.GONE);
                    chkkmcposA.setChecked(false);
                    seckmcposB.setVisibility(View.GONE);
                    linekmcposB.setVisibility(View.GONE);
                    chkkmcposB.setChecked(false);
                    seckmcposC.setVisibility(View.GONE);
                    linekmcposC.setVisibility(View.GONE);
                    chkkmcposC.setChecked(false);
                    seckmcposD.setVisibility(View.GONE);
                    linekmcposD.setVisibility(View.GONE);
                    chkkmcposD.setChecked(false);
                    seckmcposE.setVisibility(View.GONE);
                    linekmcposE.setVisibility(View.GONE);
                    chkkmcposE.setChecked(false);
                    seckmcposF.setVisibility(View.GONE);
                    linekmcposF.setVisibility(View.GONE);
                    chkkmcposF.setChecked(false);
                    seckmcposG.setVisibility(View.GONE);
                    linekmcposG.setVisibility(View.GONE);
                    chkkmcposG.setChecked(false);
                    seckmcposH.setVisibility(View.GONE);
                    linekmcposH.setVisibility(View.GONE);
                    chkkmcposH.setChecked(false);
                    seckmcposI.setVisibility(View.GONE);
                    linekmcposI.setVisibility(View.GONE);
                    chkkmcposI.setChecked(false);
                    seclbl08.setVisibility(View.GONE);
                    linelbl08.setVisibility(View.GONE);
                    seckmcedA.setVisibility(View.GONE);
                    linekmcedA.setVisibility(View.GONE);
                    chkkmcedA.setChecked(false);
                    seckmcedB.setVisibility(View.GONE);
                    linekmcedB.setVisibility(View.GONE);
                    chkkmcedB.setChecked(false);
                    seckmcedC.setVisibility(View.GONE);
                    linekmcedC.setVisibility(View.GONE);
                    chkkmcedC.setChecked(false);
                    seckmcedD.setVisibility(View.GONE);
                    linekmcedD.setVisibility(View.GONE);
                    chkkmcedD.setChecked(false);
                    seckmcedE.setVisibility(View.GONE);
                    linekmcedE.setVisibility(View.GONE);
                    chkkmcedE.setChecked(false);
                    seckmcedF.setVisibility(View.GONE);
                    linekmcedF.setVisibility(View.GONE);
                    chkkmcedF.setChecked(false);
                    seckmcedG.setVisibility(View.GONE);
                    linekmcedG.setVisibility(View.GONE);
                    chkkmcedG.setChecked(false);
                    seckmcedH.setVisibility(View.GONE);
                    linekmcedH.setVisibility(View.GONE);
                    chkkmcedH.setChecked(false);
                    seckmctime.setVisibility(View.GONE);
                    linekmctime.setVisibility(View.GONE);
                    txtkmctime.setText("");
                    seckmctimeDK.setVisibility(View.GONE);
                    linekmctimeDK.setVisibility(View.GONE);
                    chkkmctimeDK.setChecked(false);
                    secreasnokmc.setVisibility(View.GONE);
                    linereasnokmc.setVisibility(View.GONE);
                    spnreasnokmc.setSelection(0);
                    secreasnokmcOth.setVisibility(View.GONE);
                    linereasnokmcOth.setVisibility(View.GONE);
                    txtreasnokmcOth.setText("");
                    secbfmeth.setVisibility(View.GONE);
                    linebfmeth.setVisibility(View.GONE);
                    spnbfmeth.setSelection(0);
                    secbfmethDur.setVisibility(View.GONE);
                    linebfmethDur.setVisibility(View.GONE);
                    txtbfmethDur.setText("");
                    secknowunwellsigns.setVisibility(View.GONE);
                    lineknowunwellsigns.setVisibility(View.GONE);
                    spnknowunwellsigns.setSelection(0);
                    seclbl13.setVisibility(View.GONE);
                    linelbl13.setVisibility(View.GONE);
                    secunwellsignsA.setVisibility(View.GONE);
                    lineunwellsignsA.setVisibility(View.GONE);
                    chkunwellsignsA.setChecked(false);
                    secunwellsignsB.setVisibility(View.GONE);
                    lineunwellsignsB.setVisibility(View.GONE);
                    chkunwellsignsB.setChecked(false);
                    secunwellsignsC.setVisibility(View.GONE);
                    lineunwellsignsC.setVisibility(View.GONE);
                    chkunwellsignsC.setChecked(false);
                    secunwellsignsD.setVisibility(View.GONE);
                    lineunwellsignsD.setVisibility(View.GONE);
                    chkunwellsignsD.setChecked(false);
                    secunwellsignsE.setVisibility(View.GONE);
                    lineunwellsignsE.setVisibility(View.GONE);
                    chkunwellsignsE.setChecked(false);
                    secunwellsignsF.setVisibility(View.GONE);
                    lineunwellsignsF.setVisibility(View.GONE);
                    chkunwellsignsF.setChecked(false);
                    secunwellsignsFOth.setVisibility(View.GONE);
                    lineunwellsignsFOth.setVisibility(View.GONE);
                    txtunwellsignsFOth.setText("");
                    secunwellsignsG.setVisibility(View.GONE);
                    lineunwellsignsG.setVisibility(View.GONE);
                    chkunwellsignsG.setChecked(false);
                    secprediscouns.setVisibility(View.GONE);
                    lineprediscouns.setVisibility(View.GONE);
                    spnprediscouns.setSelection(0);
                    seclbl14.setVisibility(View.GONE);
                    linelbl14.setVisibility(View.GONE);
                    seccounconsA.setVisibility(View.GONE);
                    linecounconsA.setVisibility(View.GONE);
                    spncounconsA.setSelection(0);
                    seccounconsB.setVisibility(View.GONE);
                    linecounconsB.setVisibility(View.GONE);
                    spncounconsB.setSelection(0);
                    seccounconsC.setVisibility(View.GONE);
                    linecounconsC.setVisibility(View.GONE);
                    spncounconsC.setSelection(0);
                    secloskmc.setVisibility(View.GONE);
                    lineloskmc.setVisibility(View.GONE);
                    txtloskmc.setText("");
                    secloskmcDK.setVisibility(View.GONE);
                    lineloskmcDK.setVisibility(View.GONE);
                    chkloskmcDK.setChecked(false);
                    secknowdiswgt.setVisibility(View.GONE);
                    lineknowdiswgt.setVisibility(View.GONE);
                    spnknowdiswgt.setSelection(0);
                    secdiswgtkmc.setVisibility(View.GONE);
                    linediswgtkmc.setVisibility(View.GONE);
                    txtdiswgtkmc.setText("");
                    secdiswgtkmcDK.setVisibility(View.GONE);
                    linediswgtkmcDK.setVisibility(View.GONE);
                    chkdiswgtkmcDK.setChecked(false);
                    seccomments.setVisibility(View.GONE);
                    linecomments.setVisibility(View.GONE);
                    txtcomments.setText("");
             }
             else
             {
                    seckmcwho.setVisibility(View.VISIBLE);
                    linekmcwho.setVisibility(View.VISIBLE);
                    seckmcwhoOth.setVisibility(View.VISIBLE);
                    linekmcwhoOth.setVisibility(View.VISIBLE);
                    seclbl06.setVisibility(View.VISIBLE);
                    linelbl06.setVisibility(View.VISIBLE);
                    seckmcreasA.setVisibility(View.VISIBLE);
                    linekmcreasA.setVisibility(View.VISIBLE);
                    seckmcreasB.setVisibility(View.VISIBLE);
                    linekmcreasB.setVisibility(View.VISIBLE);
                    seckmcreasC.setVisibility(View.VISIBLE);
                    linekmcreasC.setVisibility(View.VISIBLE);
                    seckmcreasD.setVisibility(View.VISIBLE);
                    linekmcreasD.setVisibility(View.VISIBLE);
                    seckmcreasE.setVisibility(View.VISIBLE);
                    linekmcreasE.setVisibility(View.VISIBLE);
                    seckmcreasF.setVisibility(View.VISIBLE);
                    linekmcreasF.setVisibility(View.VISIBLE);
                    seckmcreasOth.setVisibility(View.VISIBLE);
                    linekmcreasOth.setVisibility(View.VISIBLE);
                    seckmcreasG.setVisibility(View.VISIBLE);
                    linekmcreasG.setVisibility(View.VISIBLE);
                    seclbl07.setVisibility(View.VISIBLE);
                    linelbl07.setVisibility(View.VISIBLE);
                    seckmcposA.setVisibility(View.VISIBLE);
                    linekmcposA.setVisibility(View.VISIBLE);
                    seckmcposB.setVisibility(View.VISIBLE);
                    linekmcposB.setVisibility(View.VISIBLE);
                    seckmcposC.setVisibility(View.VISIBLE);
                    linekmcposC.setVisibility(View.VISIBLE);
                    seckmcposD.setVisibility(View.VISIBLE);
                    linekmcposD.setVisibility(View.VISIBLE);
                    seckmcposE.setVisibility(View.VISIBLE);
                    linekmcposE.setVisibility(View.VISIBLE);
                    seckmcposF.setVisibility(View.VISIBLE);
                    linekmcposF.setVisibility(View.VISIBLE);
                    seckmcposG.setVisibility(View.VISIBLE);
                    linekmcposG.setVisibility(View.VISIBLE);
                    seckmcposH.setVisibility(View.VISIBLE);
                    linekmcposH.setVisibility(View.VISIBLE);
                    seckmcposI.setVisibility(View.VISIBLE);
                    linekmcposI.setVisibility(View.VISIBLE);
                    seclbl08.setVisibility(View.VISIBLE);
                    linelbl08.setVisibility(View.VISIBLE);
                    seckmcedA.setVisibility(View.VISIBLE);
                    linekmcedA.setVisibility(View.VISIBLE);
                    seckmcedB.setVisibility(View.VISIBLE);
                    linekmcedB.setVisibility(View.VISIBLE);
                    seckmcedC.setVisibility(View.VISIBLE);
                    linekmcedC.setVisibility(View.VISIBLE);
                    seckmcedD.setVisibility(View.VISIBLE);
                    linekmcedD.setVisibility(View.VISIBLE);
                    seckmcedE.setVisibility(View.VISIBLE);
                    linekmcedE.setVisibility(View.VISIBLE);
                    seckmcedF.setVisibility(View.VISIBLE);
                    linekmcedF.setVisibility(View.VISIBLE);
                    seckmcedG.setVisibility(View.VISIBLE);
                    linekmcedG.setVisibility(View.VISIBLE);
                    seckmcedH.setVisibility(View.VISIBLE);
                    linekmcedH.setVisibility(View.VISIBLE);
                    seckmctime.setVisibility(View.VISIBLE);
                    linekmctime.setVisibility(View.VISIBLE);
                    seckmctimeDK.setVisibility(View.VISIBLE);
                    linekmctimeDK.setVisibility(View.VISIBLE);
                    secreasnokmc.setVisibility(View.VISIBLE);
                    linereasnokmc.setVisibility(View.VISIBLE);
                    secreasnokmcOth.setVisibility(View.VISIBLE);
                    linereasnokmcOth.setVisibility(View.VISIBLE);
                    secbfmeth.setVisibility(View.VISIBLE);
                    linebfmeth.setVisibility(View.VISIBLE);
                    secbfmethDur.setVisibility(View.VISIBLE);
                    linebfmethDur.setVisibility(View.VISIBLE);
                    secknowunwellsigns.setVisibility(View.VISIBLE);
                    lineknowunwellsigns.setVisibility(View.VISIBLE);
                    seclbl13.setVisibility(View.VISIBLE);
                    linelbl13.setVisibility(View.VISIBLE);
                    secunwellsignsA.setVisibility(View.VISIBLE);
                    lineunwellsignsA.setVisibility(View.VISIBLE);
                    secunwellsignsB.setVisibility(View.VISIBLE);
                    lineunwellsignsB.setVisibility(View.VISIBLE);
                    secunwellsignsC.setVisibility(View.VISIBLE);
                    lineunwellsignsC.setVisibility(View.VISIBLE);
                    secunwellsignsD.setVisibility(View.VISIBLE);
                    lineunwellsignsD.setVisibility(View.VISIBLE);
                    secunwellsignsE.setVisibility(View.VISIBLE);
                    lineunwellsignsE.setVisibility(View.VISIBLE);
                    secunwellsignsF.setVisibility(View.VISIBLE);
                    lineunwellsignsF.setVisibility(View.VISIBLE);
                    secunwellsignsFOth.setVisibility(View.VISIBLE);
                    lineunwellsignsFOth.setVisibility(View.VISIBLE);
                    secunwellsignsG.setVisibility(View.VISIBLE);
                    lineunwellsignsG.setVisibility(View.VISIBLE);
                    secprediscouns.setVisibility(View.VISIBLE);
                    lineprediscouns.setVisibility(View.VISIBLE);
                    seclbl14.setVisibility(View.VISIBLE);
                    linelbl14.setVisibility(View.VISIBLE);
                    seccounconsA.setVisibility(View.VISIBLE);
                    linecounconsA.setVisibility(View.VISIBLE);
                    seccounconsB.setVisibility(View.VISIBLE);
                    linecounconsB.setVisibility(View.VISIBLE);
                    seccounconsC.setVisibility(View.VISIBLE);
                    linecounconsC.setVisibility(View.VISIBLE);
                    secloskmc.setVisibility(View.VISIBLE);
                    lineloskmc.setVisibility(View.VISIBLE);
                    secloskmcDK.setVisibility(View.VISIBLE);
                    lineloskmcDK.setVisibility(View.VISIBLE);
                    secknowdiswgt.setVisibility(View.VISIBLE);
                    lineknowdiswgt.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         seckmcwho=(LinearLayout)findViewById(R.id.seckmcwho);
         linekmcwho=(View)findViewById(R.id.linekmcwho);
         Vlblkmcwho=(TextView) findViewById(R.id.Vlblkmcwho);
         spnkmcwho=(Spinner) findViewById(R.id.spnkmcwho);
         List<String> listkmcwho = new ArrayList<String>();
         
         listkmcwho.add("");
         listkmcwho.add("01-Herself");
         listkmcwho.add("02-Other");
         ArrayAdapter<String> adptrkmcwho= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listkmcwho);
         spnkmcwho.setAdapter(adptrkmcwho);

         spnkmcwho.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             if (spnkmcwho.getSelectedItem().toString().length() == 0) return;
             String spnData = Connection.SelectedSpinnerValue(spnkmcwho.getSelectedItem().toString(),"-");
                 if(spnData.equalsIgnoreCase("01"))
                 {
                    seckmcwhoOth.setVisibility(View.GONE);
                    linekmcwhoOth.setVisibility(View.GONE);
                    txtkmcwhoOth.setText("");
                    seclbl06.setVisibility(View.GONE);
                    linelbl06.setVisibility(View.GONE);
                 }
                 else
                 {
                    seckmcwhoOth.setVisibility(View.VISIBLE);
                    linekmcwhoOth.setVisibility(View.VISIBLE);
                    seclbl06.setVisibility(View.VISIBLE);
                    linelbl06.setVisibility(View.VISIBLE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         seckmcwhoOth=(LinearLayout)findViewById(R.id.seckmcwhoOth);
         linekmcwhoOth=(View)findViewById(R.id.linekmcwhoOth);
         VlblkmcwhoOth=(TextView) findViewById(R.id.VlblkmcwhoOth);
         txtkmcwhoOth=(EditText) findViewById(R.id.txtkmcwhoOth);
         seclbl06=(LinearLayout)findViewById(R.id.seclbl06);
         linelbl06=(View)findViewById(R.id.linelbl06);
         seckmcreasA=(LinearLayout)findViewById(R.id.seckmcreasA);
         linekmcreasA=(View)findViewById(R.id.linekmcreasA);
         VlblkmcreasA=(TextView) findViewById(R.id.VlblkmcreasA);
         chkkmcreasA=(CheckBox) findViewById(R.id.chkkmcreasA);
         seckmcreasB=(LinearLayout)findViewById(R.id.seckmcreasB);
         linekmcreasB=(View)findViewById(R.id.linekmcreasB);
         VlblkmcreasB=(TextView) findViewById(R.id.VlblkmcreasB);
         chkkmcreasB=(CheckBox) findViewById(R.id.chkkmcreasB);
         seckmcreasC=(LinearLayout)findViewById(R.id.seckmcreasC);
         linekmcreasC=(View)findViewById(R.id.linekmcreasC);
         VlblkmcreasC=(TextView) findViewById(R.id.VlblkmcreasC);
         chkkmcreasC=(CheckBox) findViewById(R.id.chkkmcreasC);
         seckmcreasD=(LinearLayout)findViewById(R.id.seckmcreasD);
         linekmcreasD=(View)findViewById(R.id.linekmcreasD);
         VlblkmcreasD=(TextView) findViewById(R.id.VlblkmcreasD);
         chkkmcreasD=(CheckBox) findViewById(R.id.chkkmcreasD);
         seckmcreasE=(LinearLayout)findViewById(R.id.seckmcreasE);
         linekmcreasE=(View)findViewById(R.id.linekmcreasE);
         VlblkmcreasE=(TextView) findViewById(R.id.VlblkmcreasE);
         chkkmcreasE=(CheckBox) findViewById(R.id.chkkmcreasE);
         seckmcreasF=(LinearLayout)findViewById(R.id.seckmcreasF);
         linekmcreasF=(View)findViewById(R.id.linekmcreasF);
         VlblkmcreasF=(TextView) findViewById(R.id.VlblkmcreasF);
         chkkmcreasF=(CheckBox) findViewById(R.id.chkkmcreasF);
         chkkmcreasF.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if (!isChecked) {
                    seckmcreasOth.setVisibility(View.GONE);
                    linekmcreasOth.setVisibility(View.GONE);
                    txtkmcreasOth.setText("");
                 }
                 else
                 {
                    seckmcreasOth.setVisibility(View.VISIBLE);
                    linekmcreasOth.setVisibility(View.VISIBLE);
                 }
                 }
         });
         seckmcreasOth=(LinearLayout)findViewById(R.id.seckmcreasOth);
         linekmcreasOth=(View)findViewById(R.id.linekmcreasOth);
         VlblkmcreasOth=(TextView) findViewById(R.id.VlblkmcreasOth);
         txtkmcreasOth=(EditText) findViewById(R.id.txtkmcreasOth);
         seckmcreasG=(LinearLayout)findViewById(R.id.seckmcreasG);
         linekmcreasG=(View)findViewById(R.id.linekmcreasG);
         VlblkmcreasG=(TextView) findViewById(R.id.VlblkmcreasG);
         chkkmcreasG=(CheckBox) findViewById(R.id.chkkmcreasG);
         seclbl07=(LinearLayout)findViewById(R.id.seclbl07);
         linelbl07=(View)findViewById(R.id.linelbl07);
         seckmcposA=(LinearLayout)findViewById(R.id.seckmcposA);
         linekmcposA=(View)findViewById(R.id.linekmcposA);
         VlblkmcposA=(TextView) findViewById(R.id.VlblkmcposA);
         chkkmcposA=(CheckBox) findViewById(R.id.chkkmcposA);
         seckmcposB=(LinearLayout)findViewById(R.id.seckmcposB);
         linekmcposB=(View)findViewById(R.id.linekmcposB);
         VlblkmcposB=(TextView) findViewById(R.id.VlblkmcposB);
         chkkmcposB=(CheckBox) findViewById(R.id.chkkmcposB);
         seckmcposC=(LinearLayout)findViewById(R.id.seckmcposC);
         linekmcposC=(View)findViewById(R.id.linekmcposC);
         VlblkmcposC=(TextView) findViewById(R.id.VlblkmcposC);
         chkkmcposC=(CheckBox) findViewById(R.id.chkkmcposC);
         seckmcposD=(LinearLayout)findViewById(R.id.seckmcposD);
         linekmcposD=(View)findViewById(R.id.linekmcposD);
         VlblkmcposD=(TextView) findViewById(R.id.VlblkmcposD);
         chkkmcposD=(CheckBox) findViewById(R.id.chkkmcposD);
         seckmcposE=(LinearLayout)findViewById(R.id.seckmcposE);
         linekmcposE=(View)findViewById(R.id.linekmcposE);
         VlblkmcposE=(TextView) findViewById(R.id.VlblkmcposE);
         chkkmcposE=(CheckBox) findViewById(R.id.chkkmcposE);
         seckmcposF=(LinearLayout)findViewById(R.id.seckmcposF);
         linekmcposF=(View)findViewById(R.id.linekmcposF);
         VlblkmcposF=(TextView) findViewById(R.id.VlblkmcposF);
         chkkmcposF=(CheckBox) findViewById(R.id.chkkmcposF);
         seckmcposG=(LinearLayout)findViewById(R.id.seckmcposG);
         linekmcposG=(View)findViewById(R.id.linekmcposG);
         VlblkmcposG=(TextView) findViewById(R.id.VlblkmcposG);
         chkkmcposG=(CheckBox) findViewById(R.id.chkkmcposG);
         seckmcposH=(LinearLayout)findViewById(R.id.seckmcposH);
         linekmcposH=(View)findViewById(R.id.linekmcposH);
         VlblkmcposH=(TextView) findViewById(R.id.VlblkmcposH);
         chkkmcposH=(CheckBox) findViewById(R.id.chkkmcposH);
         seckmcposI=(LinearLayout)findViewById(R.id.seckmcposI);
         linekmcposI=(View)findViewById(R.id.linekmcposI);
         VlblkmcposI=(TextView) findViewById(R.id.VlblkmcposI);
         chkkmcposI=(CheckBox) findViewById(R.id.chkkmcposI);
         seclbl08=(LinearLayout)findViewById(R.id.seclbl08);
         linelbl08=(View)findViewById(R.id.linelbl08);
         seckmcedA=(LinearLayout)findViewById(R.id.seckmcedA);
         linekmcedA=(View)findViewById(R.id.linekmcedA);
         VlblkmcedA=(TextView) findViewById(R.id.VlblkmcedA);
         chkkmcedA=(CheckBox) findViewById(R.id.chkkmcedA);
         seckmcedB=(LinearLayout)findViewById(R.id.seckmcedB);
         linekmcedB=(View)findViewById(R.id.linekmcedB);
         VlblkmcedB=(TextView) findViewById(R.id.VlblkmcedB);
         chkkmcedB=(CheckBox) findViewById(R.id.chkkmcedB);
         seckmcedC=(LinearLayout)findViewById(R.id.seckmcedC);
         linekmcedC=(View)findViewById(R.id.linekmcedC);
         VlblkmcedC=(TextView) findViewById(R.id.VlblkmcedC);
         chkkmcedC=(CheckBox) findViewById(R.id.chkkmcedC);
         seckmcedD=(LinearLayout)findViewById(R.id.seckmcedD);
         linekmcedD=(View)findViewById(R.id.linekmcedD);
         VlblkmcedD=(TextView) findViewById(R.id.VlblkmcedD);
         chkkmcedD=(CheckBox) findViewById(R.id.chkkmcedD);
         seckmcedE=(LinearLayout)findViewById(R.id.seckmcedE);
         linekmcedE=(View)findViewById(R.id.linekmcedE);
         VlblkmcedE=(TextView) findViewById(R.id.VlblkmcedE);
         chkkmcedE=(CheckBox) findViewById(R.id.chkkmcedE);
         seckmcedF=(LinearLayout)findViewById(R.id.seckmcedF);
         linekmcedF=(View)findViewById(R.id.linekmcedF);
         VlblkmcedF=(TextView) findViewById(R.id.VlblkmcedF);
         chkkmcedF=(CheckBox) findViewById(R.id.chkkmcedF);
         seckmcedG=(LinearLayout)findViewById(R.id.seckmcedG);
         linekmcedG=(View)findViewById(R.id.linekmcedG);
         VlblkmcedG=(TextView) findViewById(R.id.VlblkmcedG);
         chkkmcedG=(CheckBox) findViewById(R.id.chkkmcedG);
         seckmcedH=(LinearLayout)findViewById(R.id.seckmcedH);
         linekmcedH=(View)findViewById(R.id.linekmcedH);
         VlblkmcedH=(TextView) findViewById(R.id.VlblkmcedH);
         chkkmcedH=(CheckBox) findViewById(R.id.chkkmcedH);
         seckmctime=(LinearLayout)findViewById(R.id.seckmctime);
         linekmctime=(View)findViewById(R.id.linekmctime);
         Vlblkmctime=(TextView) findViewById(R.id.Vlblkmctime);
         txtkmctime=(EditText) findViewById(R.id.txtkmctime);
         seckmctimeDK=(LinearLayout)findViewById(R.id.seckmctimeDK);
         linekmctimeDK=(View)findViewById(R.id.linekmctimeDK);
         VlblkmctimeDK=(TextView) findViewById(R.id.VlblkmctimeDK);
         chkkmctimeDK=(CheckBox) findViewById(R.id.chkkmctimeDK);
         secreasnokmc=(LinearLayout)findViewById(R.id.secreasnokmc);
         linereasnokmc=(View)findViewById(R.id.linereasnokmc);
         Vlblreasnokmc=(TextView) findViewById(R.id.Vlblreasnokmc);
         spnreasnokmc=(Spinner) findViewById(R.id.spnreasnokmc);
         List<String> listreasnokmc = new ArrayList<String>();
         
         listreasnokmc.add("");
         listreasnokmc.add("01-Going to get washed");
         listreasnokmc.add("02-Going to get food");
         listreasnokmc.add("03-Needed a rest");
         listreasnokmc.add("04-Baby was sick");
         listreasnokmc.add("05-Baby needed to be changed/washed");
         listreasnokmc.add("98-Other");
         ArrayAdapter<String> adptrreasnokmc= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listreasnokmc);
         spnreasnokmc.setAdapter(adptrreasnokmc);

         spnreasnokmc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             if (spnreasnokmc.getSelectedItem().toString().length() == 0) return;
             String spnData = Connection.SelectedSpinnerValue(spnreasnokmc.getSelectedItem().toString(),"-");
                 if(spnData.equalsIgnoreCase("98"))
                 {
                    secreasnokmcOth.setVisibility(View.GONE);
                    linereasnokmcOth.setVisibility(View.GONE);
                    txtreasnokmcOth.setText("");
                 }
                 else
                 {
                    secreasnokmcOth.setVisibility(View.VISIBLE);
                    linereasnokmcOth.setVisibility(View.VISIBLE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secreasnokmcOth=(LinearLayout)findViewById(R.id.secreasnokmcOth);
         linereasnokmcOth=(View)findViewById(R.id.linereasnokmcOth);
         VlblreasnokmcOth=(TextView) findViewById(R.id.VlblreasnokmcOth);
         txtreasnokmcOth=(EditText) findViewById(R.id.txtreasnokmcOth);
         secbfmeth=(LinearLayout)findViewById(R.id.secbfmeth);
         linebfmeth=(View)findViewById(R.id.linebfmeth);
         Vlblbfmeth=(TextView) findViewById(R.id.Vlblbfmeth);
         spnbfmeth=(Spinner) findViewById(R.id.spnbfmeth);
         List<String> listbfmeth = new ArrayList<String>();
         
         listbfmeth.add("");
         listbfmeth.add("01-Breastfeeding");
         listbfmeth.add("02-Cup feeding");
         listbfmeth.add("03-Naso/orogastric feeding");
         listbfmeth.add("98-Don’t know/don’t remember");
         ArrayAdapter<String> adptrbfmeth= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listbfmeth);
         spnbfmeth.setAdapter(adptrbfmeth);

         secbfmethDur=(LinearLayout)findViewById(R.id.secbfmethDur);
         linebfmethDur=(View)findViewById(R.id.linebfmethDur);
         VlblbfmethDur=(TextView) findViewById(R.id.VlblbfmethDur);
         txtbfmethDur=(EditText) findViewById(R.id.txtbfmethDur);
         secknowunwellsigns=(LinearLayout)findViewById(R.id.secknowunwellsigns);
         lineknowunwellsigns=(View)findViewById(R.id.lineknowunwellsigns);
         Vlblknowunwellsigns=(TextView) findViewById(R.id.Vlblknowunwellsigns);
         spnknowunwellsigns=(Spinner) findViewById(R.id.spnknowunwellsigns);
         List<String> listknowunwellsigns = new ArrayList<String>();
         
         listknowunwellsigns.add("");
         listknowunwellsigns.add("01-Yes");
         listknowunwellsigns.add("02-No");
         listknowunwellsigns.add("03-Don’t know/don’t remember");
         ArrayAdapter<String> adptrknowunwellsigns= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listknowunwellsigns);
         spnknowunwellsigns.setAdapter(adptrknowunwellsigns);

         spnknowunwellsigns.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             if (spnknowunwellsigns.getSelectedItem().toString().length() == 0) return;
             String spnData = Connection.SelectedSpinnerValue(spnknowunwellsigns.getSelectedItem().toString(),"-");
                 if(spnData.equalsIgnoreCase("02"))
                 {
                    seclbl13.setVisibility(View.GONE);
                    linelbl13.setVisibility(View.GONE);
                    secunwellsignsA.setVisibility(View.GONE);
                    lineunwellsignsA.setVisibility(View.GONE);
                    chkunwellsignsA.setChecked(false);
                    secunwellsignsB.setVisibility(View.GONE);
                    lineunwellsignsB.setVisibility(View.GONE);
                    chkunwellsignsB.setChecked(false);
                    secunwellsignsC.setVisibility(View.GONE);
                    lineunwellsignsC.setVisibility(View.GONE);
                    chkunwellsignsC.setChecked(false);
                    secunwellsignsD.setVisibility(View.GONE);
                    lineunwellsignsD.setVisibility(View.GONE);
                    chkunwellsignsD.setChecked(false);
                    secunwellsignsE.setVisibility(View.GONE);
                    lineunwellsignsE.setVisibility(View.GONE);
                    chkunwellsignsE.setChecked(false);
                    secunwellsignsF.setVisibility(View.GONE);
                    lineunwellsignsF.setVisibility(View.GONE);
                    chkunwellsignsF.setChecked(false);
                    secunwellsignsFOth.setVisibility(View.GONE);
                    lineunwellsignsFOth.setVisibility(View.GONE);
                    txtunwellsignsFOth.setText("");
                    secunwellsignsG.setVisibility(View.GONE);
                    lineunwellsignsG.setVisibility(View.GONE);
                    chkunwellsignsG.setChecked(false);
                    secprediscouns.setVisibility(View.GONE);
                    lineprediscouns.setVisibility(View.GONE);
                    spnprediscouns.setSelection(0);
                    seclbl14.setVisibility(View.GONE);
                    linelbl14.setVisibility(View.GONE);
                    seccounconsA.setVisibility(View.GONE);
                    linecounconsA.setVisibility(View.GONE);
                    spncounconsA.setSelection(0);
                    seccounconsB.setVisibility(View.GONE);
                    linecounconsB.setVisibility(View.GONE);
                    spncounconsB.setSelection(0);
                    seccounconsC.setVisibility(View.GONE);
                    linecounconsC.setVisibility(View.GONE);
                    spncounconsC.setSelection(0);
                    secloskmc.setVisibility(View.GONE);
                    lineloskmc.setVisibility(View.GONE);
                    txtloskmc.setText("");
                    secloskmcDK.setVisibility(View.GONE);
                    lineloskmcDK.setVisibility(View.GONE);
                    chkloskmcDK.setChecked(false);
                    secknowdiswgt.setVisibility(View.GONE);
                    lineknowdiswgt.setVisibility(View.GONE);
                    spnknowdiswgt.setSelection(0);
                    secdiswgtkmc.setVisibility(View.GONE);
                    linediswgtkmc.setVisibility(View.GONE);
                    txtdiswgtkmc.setText("");
                    secdiswgtkmcDK.setVisibility(View.GONE);
                    linediswgtkmcDK.setVisibility(View.GONE);
                    chkdiswgtkmcDK.setChecked(false);
                    seccomments.setVisibility(View.GONE);
                    linecomments.setVisibility(View.GONE);
                    txtcomments.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("98"))
                 {
                    seclbl13.setVisibility(View.GONE);
                    linelbl13.setVisibility(View.GONE);
                    secunwellsignsA.setVisibility(View.GONE);
                    lineunwellsignsA.setVisibility(View.GONE);
                    chkunwellsignsA.setChecked(false);
                    secunwellsignsB.setVisibility(View.GONE);
                    lineunwellsignsB.setVisibility(View.GONE);
                    chkunwellsignsB.setChecked(false);
                    secunwellsignsC.setVisibility(View.GONE);
                    lineunwellsignsC.setVisibility(View.GONE);
                    chkunwellsignsC.setChecked(false);
                    secunwellsignsD.setVisibility(View.GONE);
                    lineunwellsignsD.setVisibility(View.GONE);
                    chkunwellsignsD.setChecked(false);
                    secunwellsignsE.setVisibility(View.GONE);
                    lineunwellsignsE.setVisibility(View.GONE);
                    chkunwellsignsE.setChecked(false);
                    secunwellsignsF.setVisibility(View.GONE);
                    lineunwellsignsF.setVisibility(View.GONE);
                    chkunwellsignsF.setChecked(false);
                    secunwellsignsFOth.setVisibility(View.GONE);
                    lineunwellsignsFOth.setVisibility(View.GONE);
                    txtunwellsignsFOth.setText("");
                    secunwellsignsG.setVisibility(View.GONE);
                    lineunwellsignsG.setVisibility(View.GONE);
                    chkunwellsignsG.setChecked(false);
                    secprediscouns.setVisibility(View.GONE);
                    lineprediscouns.setVisibility(View.GONE);
                    spnprediscouns.setSelection(0);
                    seclbl14.setVisibility(View.GONE);
                    linelbl14.setVisibility(View.GONE);
                    seccounconsA.setVisibility(View.GONE);
                    linecounconsA.setVisibility(View.GONE);
                    spncounconsA.setSelection(0);
                    seccounconsB.setVisibility(View.GONE);
                    linecounconsB.setVisibility(View.GONE);
                    spncounconsB.setSelection(0);
                    seccounconsC.setVisibility(View.GONE);
                    linecounconsC.setVisibility(View.GONE);
                    spncounconsC.setSelection(0);
                    secloskmc.setVisibility(View.GONE);
                    lineloskmc.setVisibility(View.GONE);
                    txtloskmc.setText("");
                    secloskmcDK.setVisibility(View.GONE);
                    lineloskmcDK.setVisibility(View.GONE);
                    chkloskmcDK.setChecked(false);
                    secknowdiswgt.setVisibility(View.GONE);
                    lineknowdiswgt.setVisibility(View.GONE);
                    spnknowdiswgt.setSelection(0);
                    secdiswgtkmc.setVisibility(View.GONE);
                    linediswgtkmc.setVisibility(View.GONE);
                    txtdiswgtkmc.setText("");
                    secdiswgtkmcDK.setVisibility(View.GONE);
                    linediswgtkmcDK.setVisibility(View.GONE);
                    chkdiswgtkmcDK.setChecked(false);
                    seccomments.setVisibility(View.GONE);
                    linecomments.setVisibility(View.GONE);
                    txtcomments.setText("");
                 }
                 else
                 {
                    seclbl13.setVisibility(View.VISIBLE);
                    linelbl13.setVisibility(View.VISIBLE);
                    secunwellsignsA.setVisibility(View.VISIBLE);
                    lineunwellsignsA.setVisibility(View.VISIBLE);
                    secunwellsignsB.setVisibility(View.VISIBLE);
                    lineunwellsignsB.setVisibility(View.VISIBLE);
                    secunwellsignsC.setVisibility(View.VISIBLE);
                    lineunwellsignsC.setVisibility(View.VISIBLE);
                    secunwellsignsD.setVisibility(View.VISIBLE);
                    lineunwellsignsD.setVisibility(View.VISIBLE);
                    secunwellsignsE.setVisibility(View.VISIBLE);
                    lineunwellsignsE.setVisibility(View.VISIBLE);
                    secunwellsignsF.setVisibility(View.VISIBLE);
                    lineunwellsignsF.setVisibility(View.VISIBLE);
                    secunwellsignsFOth.setVisibility(View.VISIBLE);
                    lineunwellsignsFOth.setVisibility(View.VISIBLE);
                    secunwellsignsG.setVisibility(View.VISIBLE);
                    lineunwellsignsG.setVisibility(View.VISIBLE);
                    secprediscouns.setVisibility(View.VISIBLE);
                    lineprediscouns.setVisibility(View.VISIBLE);
                    seclbl14.setVisibility(View.VISIBLE);
                    linelbl14.setVisibility(View.VISIBLE);
                    seccounconsA.setVisibility(View.VISIBLE);
                    linecounconsA.setVisibility(View.VISIBLE);
                    seccounconsB.setVisibility(View.VISIBLE);
                    linecounconsB.setVisibility(View.VISIBLE);
                    seccounconsC.setVisibility(View.VISIBLE);
                    linecounconsC.setVisibility(View.VISIBLE);
                    secloskmc.setVisibility(View.VISIBLE);
                    lineloskmc.setVisibility(View.VISIBLE);
                    secloskmcDK.setVisibility(View.VISIBLE);
                    lineloskmcDK.setVisibility(View.VISIBLE);
                    secknowdiswgt.setVisibility(View.VISIBLE);
                    lineknowdiswgt.setVisibility(View.VISIBLE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         seclbl13=(LinearLayout)findViewById(R.id.seclbl13);
         linelbl13=(View)findViewById(R.id.linelbl13);
         secunwellsignsA=(LinearLayout)findViewById(R.id.secunwellsignsA);
         lineunwellsignsA=(View)findViewById(R.id.lineunwellsignsA);
         VlblunwellsignsA=(TextView) findViewById(R.id.VlblunwellsignsA);
         chkunwellsignsA=(CheckBox) findViewById(R.id.chkunwellsignsA);
         secunwellsignsB=(LinearLayout)findViewById(R.id.secunwellsignsB);
         lineunwellsignsB=(View)findViewById(R.id.lineunwellsignsB);
         VlblunwellsignsB=(TextView) findViewById(R.id.VlblunwellsignsB);
         chkunwellsignsB=(CheckBox) findViewById(R.id.chkunwellsignsB);
         secunwellsignsC=(LinearLayout)findViewById(R.id.secunwellsignsC);
         lineunwellsignsC=(View)findViewById(R.id.lineunwellsignsC);
         VlblunwellsignsC=(TextView) findViewById(R.id.VlblunwellsignsC);
         chkunwellsignsC=(CheckBox) findViewById(R.id.chkunwellsignsC);
         secunwellsignsD=(LinearLayout)findViewById(R.id.secunwellsignsD);
         lineunwellsignsD=(View)findViewById(R.id.lineunwellsignsD);
         VlblunwellsignsD=(TextView) findViewById(R.id.VlblunwellsignsD);
         chkunwellsignsD=(CheckBox) findViewById(R.id.chkunwellsignsD);
         secunwellsignsE=(LinearLayout)findViewById(R.id.secunwellsignsE);
         lineunwellsignsE=(View)findViewById(R.id.lineunwellsignsE);
         VlblunwellsignsE=(TextView) findViewById(R.id.VlblunwellsignsE);
         chkunwellsignsE=(CheckBox) findViewById(R.id.chkunwellsignsE);
         secunwellsignsF=(LinearLayout)findViewById(R.id.secunwellsignsF);
         lineunwellsignsF=(View)findViewById(R.id.lineunwellsignsF);
         VlblunwellsignsF=(TextView) findViewById(R.id.VlblunwellsignsF);
         chkunwellsignsF=(CheckBox) findViewById(R.id.chkunwellsignsF);
         chkunwellsignsF.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if (!isChecked) {
                    secunwellsignsFOth.setVisibility(View.GONE);
                    lineunwellsignsFOth.setVisibility(View.GONE);
                    txtunwellsignsFOth.setText("");
                 }
                 else
                 {
                    secunwellsignsFOth.setVisibility(View.VISIBLE);
                    lineunwellsignsFOth.setVisibility(View.VISIBLE);
                 }
                 }
         });
         secunwellsignsFOth=(LinearLayout)findViewById(R.id.secunwellsignsFOth);
         lineunwellsignsFOth=(View)findViewById(R.id.lineunwellsignsFOth);
         VlblunwellsignsFOth=(TextView) findViewById(R.id.VlblunwellsignsFOth);
         txtunwellsignsFOth=(EditText) findViewById(R.id.txtunwellsignsFOth);
         secunwellsignsG=(LinearLayout)findViewById(R.id.secunwellsignsG);
         lineunwellsignsG=(View)findViewById(R.id.lineunwellsignsG);
         VlblunwellsignsG=(TextView) findViewById(R.id.VlblunwellsignsG);
         chkunwellsignsG=(CheckBox) findViewById(R.id.chkunwellsignsG);
         secprediscouns=(LinearLayout)findViewById(R.id.secprediscouns);
         lineprediscouns=(View)findViewById(R.id.lineprediscouns);
         Vlblprediscouns=(TextView) findViewById(R.id.Vlblprediscouns);
         spnprediscouns=(Spinner) findViewById(R.id.spnprediscouns);
         List<String> listprediscouns = new ArrayList<String>();
         
         listprediscouns.add("");
         listprediscouns.add("01-Yes");
         listprediscouns.add("02-No");
         listprediscouns.add("98-Don’t know/don’t remember");
         ArrayAdapter<String> adptrprediscouns= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listprediscouns);
         spnprediscouns.setAdapter(adptrprediscouns);

         spnprediscouns.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             if (spnprediscouns.getSelectedItem().toString().length() == 0) return;
             String spnData = Connection.SelectedSpinnerValue(spnprediscouns.getSelectedItem().toString(),"-");
                 if(spnData.equalsIgnoreCase("02"))
                 {
                    seclbl14.setVisibility(View.GONE);
                    linelbl14.setVisibility(View.GONE);
                    seccounconsA.setVisibility(View.GONE);
                    linecounconsA.setVisibility(View.GONE);
                    spncounconsA.setSelection(0);
                    seccounconsB.setVisibility(View.GONE);
                    linecounconsB.setVisibility(View.GONE);
                    spncounconsB.setSelection(0);
                    seccounconsC.setVisibility(View.GONE);
                    linecounconsC.setVisibility(View.GONE);
                    spncounconsC.setSelection(0);
                 }
                 else if(spnData.equalsIgnoreCase("98"))
                 {
                    seclbl14.setVisibility(View.GONE);
                    linelbl14.setVisibility(View.GONE);
                    seccounconsA.setVisibility(View.GONE);
                    linecounconsA.setVisibility(View.GONE);
                    spncounconsA.setSelection(0);
                    seccounconsB.setVisibility(View.GONE);
                    linecounconsB.setVisibility(View.GONE);
                    spncounconsB.setSelection(0);
                    seccounconsC.setVisibility(View.GONE);
                    linecounconsC.setVisibility(View.GONE);
                    spncounconsC.setSelection(0);
                 }
                 else
                 {
                    seclbl14.setVisibility(View.VISIBLE);
                    linelbl14.setVisibility(View.VISIBLE);
                    seccounconsA.setVisibility(View.VISIBLE);
                    linecounconsA.setVisibility(View.VISIBLE);
                    seccounconsB.setVisibility(View.VISIBLE);
                    linecounconsB.setVisibility(View.VISIBLE);
                    seccounconsC.setVisibility(View.VISIBLE);
                    linecounconsC.setVisibility(View.VISIBLE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         seclbl14=(LinearLayout)findViewById(R.id.seclbl14);
         linelbl14=(View)findViewById(R.id.linelbl14);
         seccounconsA=(LinearLayout)findViewById(R.id.seccounconsA);
         linecounconsA=(View)findViewById(R.id.linecounconsA);
         VlblcounconsA=(TextView) findViewById(R.id.VlblcounconsA);
         spncounconsA=(Spinner) findViewById(R.id.spncounconsA);
         List<String> listcounconsA = new ArrayList<String>();
         
         listcounconsA.add("");
         listcounconsA.add("01-Mention unprompted ");
         listcounconsA.add("02-Mentioned when prompted");
         listcounconsA.add("03-Did not mention at all");
         ArrayAdapter<String> adptrcounconsA= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listcounconsA);
         spncounconsA.setAdapter(adptrcounconsA);

         seccounconsB=(LinearLayout)findViewById(R.id.seccounconsB);
         linecounconsB=(View)findViewById(R.id.linecounconsB);
         VlblcounconsB=(TextView) findViewById(R.id.VlblcounconsB);
         spncounconsB=(Spinner) findViewById(R.id.spncounconsB);
         List<String> listcounconsB = new ArrayList<String>();
         
         listcounconsB.add("");
         listcounconsB.add("01-Mention unprompted");
         listcounconsB.add("02-Mentioned when prompted");
         listcounconsB.add("03-Did not mention at all");
         ArrayAdapter<String> adptrcounconsB= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listcounconsB);
         spncounconsB.setAdapter(adptrcounconsB);

         seccounconsC=(LinearLayout)findViewById(R.id.seccounconsC);
         linecounconsC=(View)findViewById(R.id.linecounconsC);
         VlblcounconsC=(TextView) findViewById(R.id.VlblcounconsC);
         spncounconsC=(Spinner) findViewById(R.id.spncounconsC);
         List<String> listcounconsC = new ArrayList<String>();
         
         listcounconsC.add("");
         listcounconsC.add("01-Mention unprompted");
         listcounconsC.add("02-Mentioned when prompted");
         listcounconsC.add("03-Did not mention at all");
         ArrayAdapter<String> adptrcounconsC= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listcounconsC);
         spncounconsC.setAdapter(adptrcounconsC);

         secloskmc=(LinearLayout)findViewById(R.id.secloskmc);
         lineloskmc=(View)findViewById(R.id.lineloskmc);
         Vlblloskmc=(TextView) findViewById(R.id.Vlblloskmc);
         txtloskmc=(EditText) findViewById(R.id.txtloskmc);
         secloskmcDK=(LinearLayout)findViewById(R.id.secloskmcDK);
         lineloskmcDK=(View)findViewById(R.id.lineloskmcDK);
         VlblloskmcDK=(TextView) findViewById(R.id.VlblloskmcDK);
         chkloskmcDK=(CheckBox) findViewById(R.id.chkloskmcDK);
         secknowdiswgt=(LinearLayout)findViewById(R.id.secknowdiswgt);
         lineknowdiswgt=(View)findViewById(R.id.lineknowdiswgt);
         Vlblknowdiswgt=(TextView) findViewById(R.id.Vlblknowdiswgt);
         spnknowdiswgt=(Spinner) findViewById(R.id.spnknowdiswgt);
         List<String> listknowdiswgt = new ArrayList<String>();
         
         listknowdiswgt.add("");
         listknowdiswgt.add("01-Yes");
         listknowdiswgt.add("02-No");
         listknowdiswgt.add("98-Don’t know/don’t remember");
         ArrayAdapter<String> adptrknowdiswgt= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listknowdiswgt);
         spnknowdiswgt.setAdapter(adptrknowdiswgt);

         spnknowdiswgt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             if (spnknowdiswgt.getSelectedItem().toString().length() == 0) return;
             String spnData = Connection.SelectedSpinnerValue(spnknowdiswgt.getSelectedItem().toString(),"-");
                 if(spnData.equalsIgnoreCase("02"))
                 {
                    secdiswgtkmc.setVisibility(View.GONE);
                    linediswgtkmc.setVisibility(View.GONE);
                    txtdiswgtkmc.setText("");
                    secdiswgtkmcDK.setVisibility(View.GONE);
                    linediswgtkmcDK.setVisibility(View.GONE);
                    chkdiswgtkmcDK.setChecked(false);
                    seccomments.setVisibility(View.GONE);
                    linecomments.setVisibility(View.GONE);
                    txtcomments.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("98"))
                 {
                    secdiswgtkmc.setVisibility(View.GONE);
                    linediswgtkmc.setVisibility(View.GONE);
                    txtdiswgtkmc.setText("");
                    secdiswgtkmcDK.setVisibility(View.GONE);
                    linediswgtkmcDK.setVisibility(View.GONE);
                    chkdiswgtkmcDK.setChecked(false);
                    seccomments.setVisibility(View.GONE);
                    linecomments.setVisibility(View.GONE);
                    txtcomments.setText("");
                 }
                 else
                 {
                    secdiswgtkmc.setVisibility(View.VISIBLE);
                    linediswgtkmc.setVisibility(View.VISIBLE);
                    secdiswgtkmcDK.setVisibility(View.VISIBLE);
                    linediswgtkmcDK.setVisibility(View.VISIBLE);
                    seccomments.setVisibility(View.VISIBLE);
                    linecomments.setVisibility(View.VISIBLE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secdiswgtkmc=(LinearLayout)findViewById(R.id.secdiswgtkmc);
         linediswgtkmc=(View)findViewById(R.id.linediswgtkmc);
         Vlbldiswgtkmc=(TextView) findViewById(R.id.Vlbldiswgtkmc);
         txtdiswgtkmc=(EditText) findViewById(R.id.txtdiswgtkmc);
         secdiswgtkmcDK=(LinearLayout)findViewById(R.id.secdiswgtkmcDK);
         linediswgtkmcDK=(View)findViewById(R.id.linediswgtkmcDK);
         VlbldiswgtkmcDK=(TextView) findViewById(R.id.VlbldiswgtkmcDK);
         chkdiswgtkmcDK=(CheckBox) findViewById(R.id.chkdiswgtkmcDK);
         seccomments=(LinearLayout)findViewById(R.id.seccomments);
         linecomments=(View)findViewById(R.id.linecomments);
         Vlblcomments=(TextView) findViewById(R.id.Vlblcomments);
         txtcomments=(EditText) findViewById(R.id.txtcomments);





         //Hide all skip variables
         secadwgtkmc.setVisibility(View.GONE);
         lineadwgtkmc.setVisibility(View.GONE);
         secadwgtkmcDK.setVisibility(View.GONE);
         lineadwgtkmcDK.setVisibility(View.GONE);
         secadwgtkmc.setVisibility(View.GONE);
         lineadwgtkmc.setVisibility(View.GONE);
         secadwgtkmcDK.setVisibility(View.GONE);
         lineadwgtkmcDK.setVisibility(View.GONE);
         seckmcwho.setVisibility(View.GONE);
         linekmcwho.setVisibility(View.GONE);
         seckmcwhoOth.setVisibility(View.GONE);
         linekmcwhoOth.setVisibility(View.GONE);
         seclbl06.setVisibility(View.GONE);
         linelbl06.setVisibility(View.GONE);
         seckmcreasA.setVisibility(View.GONE);
         linekmcreasA.setVisibility(View.GONE);
         seckmcreasB.setVisibility(View.GONE);
         linekmcreasB.setVisibility(View.GONE);
         seckmcreasC.setVisibility(View.GONE);
         linekmcreasC.setVisibility(View.GONE);
         seckmcreasD.setVisibility(View.GONE);
         linekmcreasD.setVisibility(View.GONE);
         seckmcreasE.setVisibility(View.GONE);
         linekmcreasE.setVisibility(View.GONE);
         seckmcreasF.setVisibility(View.GONE);
         linekmcreasF.setVisibility(View.GONE);
         seckmcreasOth.setVisibility(View.GONE);
         linekmcreasOth.setVisibility(View.GONE);
         seckmcreasG.setVisibility(View.GONE);
         linekmcreasG.setVisibility(View.GONE);
         seclbl07.setVisibility(View.GONE);
         linelbl07.setVisibility(View.GONE);
         seckmcposA.setVisibility(View.GONE);
         linekmcposA.setVisibility(View.GONE);
         seckmcposB.setVisibility(View.GONE);
         linekmcposB.setVisibility(View.GONE);
         seckmcposC.setVisibility(View.GONE);
         linekmcposC.setVisibility(View.GONE);
         seckmcposD.setVisibility(View.GONE);
         linekmcposD.setVisibility(View.GONE);
         seckmcposE.setVisibility(View.GONE);
         linekmcposE.setVisibility(View.GONE);
         seckmcposF.setVisibility(View.GONE);
         linekmcposF.setVisibility(View.GONE);
         seckmcposG.setVisibility(View.GONE);
         linekmcposG.setVisibility(View.GONE);
         seckmcposH.setVisibility(View.GONE);
         linekmcposH.setVisibility(View.GONE);
         seckmcposI.setVisibility(View.GONE);
         linekmcposI.setVisibility(View.GONE);
         seclbl08.setVisibility(View.GONE);
         linelbl08.setVisibility(View.GONE);
         seckmcedA.setVisibility(View.GONE);
         linekmcedA.setVisibility(View.GONE);
         seckmcedB.setVisibility(View.GONE);
         linekmcedB.setVisibility(View.GONE);
         seckmcedC.setVisibility(View.GONE);
         linekmcedC.setVisibility(View.GONE);
         seckmcedD.setVisibility(View.GONE);
         linekmcedD.setVisibility(View.GONE);
         seckmcedE.setVisibility(View.GONE);
         linekmcedE.setVisibility(View.GONE);
         seckmcedF.setVisibility(View.GONE);
         linekmcedF.setVisibility(View.GONE);
         seckmcedG.setVisibility(View.GONE);
         linekmcedG.setVisibility(View.GONE);
         seckmcedH.setVisibility(View.GONE);
         linekmcedH.setVisibility(View.GONE);
         seckmctime.setVisibility(View.GONE);
         linekmctime.setVisibility(View.GONE);
         seckmctimeDK.setVisibility(View.GONE);
         linekmctimeDK.setVisibility(View.GONE);
         secreasnokmc.setVisibility(View.GONE);
         linereasnokmc.setVisibility(View.GONE);
         secreasnokmcOth.setVisibility(View.GONE);
         linereasnokmcOth.setVisibility(View.GONE);
         secbfmeth.setVisibility(View.GONE);
         linebfmeth.setVisibility(View.GONE);
         secbfmethDur.setVisibility(View.GONE);
         linebfmethDur.setVisibility(View.GONE);
         secknowunwellsigns.setVisibility(View.GONE);
         lineknowunwellsigns.setVisibility(View.GONE);
         seclbl13.setVisibility(View.GONE);
         linelbl13.setVisibility(View.GONE);
         secunwellsignsA.setVisibility(View.GONE);
         lineunwellsignsA.setVisibility(View.GONE);
         secunwellsignsB.setVisibility(View.GONE);
         lineunwellsignsB.setVisibility(View.GONE);
         secunwellsignsC.setVisibility(View.GONE);
         lineunwellsignsC.setVisibility(View.GONE);
         secunwellsignsD.setVisibility(View.GONE);
         lineunwellsignsD.setVisibility(View.GONE);
         secunwellsignsE.setVisibility(View.GONE);
         lineunwellsignsE.setVisibility(View.GONE);
         secunwellsignsF.setVisibility(View.GONE);
         lineunwellsignsF.setVisibility(View.GONE);
         secunwellsignsFOth.setVisibility(View.GONE);
         lineunwellsignsFOth.setVisibility(View.GONE);
         secunwellsignsG.setVisibility(View.GONE);
         lineunwellsignsG.setVisibility(View.GONE);
         secprediscouns.setVisibility(View.GONE);
         lineprediscouns.setVisibility(View.GONE);
         seclbl14.setVisibility(View.GONE);
         linelbl14.setVisibility(View.GONE);
         seccounconsA.setVisibility(View.GONE);
         linecounconsA.setVisibility(View.GONE);
         seccounconsB.setVisibility(View.GONE);
         linecounconsB.setVisibility(View.GONE);
         seccounconsC.setVisibility(View.GONE);
         linecounconsC.setVisibility(View.GONE);
         secloskmc.setVisibility(View.GONE);
         lineloskmc.setVisibility(View.GONE);
         secloskmcDK.setVisibility(View.GONE);
         lineloskmcDK.setVisibility(View.GONE);
         secknowdiswgt.setVisibility(View.GONE);
         lineknowdiswgt.setVisibility(View.GONE);
         secdiswgtkmc.setVisibility(View.GONE);
         linediswgtkmc.setVisibility(View.GONE);
         secdiswgtkmcDK.setVisibility(View.GONE);
         linediswgtkmcDK.setVisibility(View.GONE);
         seccomments.setVisibility(View.GONE);
         linecomments.setVisibility(View.GONE);
         seckmcwho.setVisibility(View.GONE);
         linekmcwho.setVisibility(View.GONE);
         seckmcwhoOth.setVisibility(View.GONE);
         linekmcwhoOth.setVisibility(View.GONE);
         seclbl06.setVisibility(View.GONE);
         linelbl06.setVisibility(View.GONE);
         seckmcreasA.setVisibility(View.GONE);
         linekmcreasA.setVisibility(View.GONE);
         seckmcreasB.setVisibility(View.GONE);
         linekmcreasB.setVisibility(View.GONE);
         seckmcreasC.setVisibility(View.GONE);
         linekmcreasC.setVisibility(View.GONE);
         seckmcreasD.setVisibility(View.GONE);
         linekmcreasD.setVisibility(View.GONE);
         seckmcreasE.setVisibility(View.GONE);
         linekmcreasE.setVisibility(View.GONE);
         seckmcreasF.setVisibility(View.GONE);
         linekmcreasF.setVisibility(View.GONE);
         seckmcreasOth.setVisibility(View.GONE);
         linekmcreasOth.setVisibility(View.GONE);
         seckmcreasG.setVisibility(View.GONE);
         linekmcreasG.setVisibility(View.GONE);
         seclbl07.setVisibility(View.GONE);
         linelbl07.setVisibility(View.GONE);
         seckmcposA.setVisibility(View.GONE);
         linekmcposA.setVisibility(View.GONE);
         seckmcposB.setVisibility(View.GONE);
         linekmcposB.setVisibility(View.GONE);
         seckmcposC.setVisibility(View.GONE);
         linekmcposC.setVisibility(View.GONE);
         seckmcposD.setVisibility(View.GONE);
         linekmcposD.setVisibility(View.GONE);
         seckmcposE.setVisibility(View.GONE);
         linekmcposE.setVisibility(View.GONE);
         seckmcposF.setVisibility(View.GONE);
         linekmcposF.setVisibility(View.GONE);
         seckmcposG.setVisibility(View.GONE);
         linekmcposG.setVisibility(View.GONE);
         seckmcposH.setVisibility(View.GONE);
         linekmcposH.setVisibility(View.GONE);
         seckmcposI.setVisibility(View.GONE);
         linekmcposI.setVisibility(View.GONE);
         seclbl08.setVisibility(View.GONE);
         linelbl08.setVisibility(View.GONE);
         seckmcedA.setVisibility(View.GONE);
         linekmcedA.setVisibility(View.GONE);
         seckmcedB.setVisibility(View.GONE);
         linekmcedB.setVisibility(View.GONE);
         seckmcedC.setVisibility(View.GONE);
         linekmcedC.setVisibility(View.GONE);
         seckmcedD.setVisibility(View.GONE);
         linekmcedD.setVisibility(View.GONE);
         seckmcedE.setVisibility(View.GONE);
         linekmcedE.setVisibility(View.GONE);
         seckmcedF.setVisibility(View.GONE);
         linekmcedF.setVisibility(View.GONE);
         seckmcedG.setVisibility(View.GONE);
         linekmcedG.setVisibility(View.GONE);
         seckmcedH.setVisibility(View.GONE);
         linekmcedH.setVisibility(View.GONE);
         seckmctime.setVisibility(View.GONE);
         linekmctime.setVisibility(View.GONE);
         seckmctimeDK.setVisibility(View.GONE);
         linekmctimeDK.setVisibility(View.GONE);
         secreasnokmc.setVisibility(View.GONE);
         linereasnokmc.setVisibility(View.GONE);
         secreasnokmcOth.setVisibility(View.GONE);
         linereasnokmcOth.setVisibility(View.GONE);
         secbfmeth.setVisibility(View.GONE);
         linebfmeth.setVisibility(View.GONE);
         secbfmethDur.setVisibility(View.GONE);
         linebfmethDur.setVisibility(View.GONE);
         secknowunwellsigns.setVisibility(View.GONE);
         lineknowunwellsigns.setVisibility(View.GONE);
         seclbl13.setVisibility(View.GONE);
         linelbl13.setVisibility(View.GONE);
         secunwellsignsA.setVisibility(View.GONE);
         lineunwellsignsA.setVisibility(View.GONE);
         secunwellsignsB.setVisibility(View.GONE);
         lineunwellsignsB.setVisibility(View.GONE);
         secunwellsignsC.setVisibility(View.GONE);
         lineunwellsignsC.setVisibility(View.GONE);
         secunwellsignsD.setVisibility(View.GONE);
         lineunwellsignsD.setVisibility(View.GONE);
         secunwellsignsE.setVisibility(View.GONE);
         lineunwellsignsE.setVisibility(View.GONE);
         secunwellsignsF.setVisibility(View.GONE);
         lineunwellsignsF.setVisibility(View.GONE);
         secunwellsignsFOth.setVisibility(View.GONE);
         lineunwellsignsFOth.setVisibility(View.GONE);
         secunwellsignsG.setVisibility(View.GONE);
         lineunwellsignsG.setVisibility(View.GONE);
         secprediscouns.setVisibility(View.GONE);
         lineprediscouns.setVisibility(View.GONE);
         seclbl14.setVisibility(View.GONE);
         linelbl14.setVisibility(View.GONE);
         seccounconsA.setVisibility(View.GONE);
         linecounconsA.setVisibility(View.GONE);
         seccounconsB.setVisibility(View.GONE);
         linecounconsB.setVisibility(View.GONE);
         seccounconsC.setVisibility(View.GONE);
         linecounconsC.setVisibility(View.GONE);
         secloskmc.setVisibility(View.GONE);
         lineloskmc.setVisibility(View.GONE);
         secloskmcDK.setVisibility(View.GONE);
         lineloskmcDK.setVisibility(View.GONE);
         secknowdiswgt.setVisibility(View.GONE);
         lineknowdiswgt.setVisibility(View.GONE);
         secdiswgtkmc.setVisibility(View.GONE);
         linediswgtkmc.setVisibility(View.GONE);
         secdiswgtkmcDK.setVisibility(View.GONE);
         linediswgtkmcDK.setVisibility(View.GONE);
         seccomments.setVisibility(View.GONE);
         linecomments.setVisibility(View.GONE);
         seckmcwhoOth.setVisibility(View.GONE);
         linekmcwhoOth.setVisibility(View.GONE);
         seclbl06.setVisibility(View.GONE);
         linelbl06.setVisibility(View.GONE);
         seckmcreasOth.setVisibility(View.GONE);
         linekmcreasOth.setVisibility(View.GONE);
         secreasnokmcOth.setVisibility(View.GONE);
         linereasnokmcOth.setVisibility(View.GONE);
         seclbl13.setVisibility(View.GONE);
         linelbl13.setVisibility(View.GONE);
         secunwellsignsA.setVisibility(View.GONE);
         lineunwellsignsA.setVisibility(View.GONE);
         secunwellsignsB.setVisibility(View.GONE);
         lineunwellsignsB.setVisibility(View.GONE);
         secunwellsignsC.setVisibility(View.GONE);
         lineunwellsignsC.setVisibility(View.GONE);
         secunwellsignsD.setVisibility(View.GONE);
         lineunwellsignsD.setVisibility(View.GONE);
         secunwellsignsE.setVisibility(View.GONE);
         lineunwellsignsE.setVisibility(View.GONE);
         secunwellsignsF.setVisibility(View.GONE);
         lineunwellsignsF.setVisibility(View.GONE);
         secunwellsignsFOth.setVisibility(View.GONE);
         lineunwellsignsFOth.setVisibility(View.GONE);
         secunwellsignsG.setVisibility(View.GONE);
         lineunwellsignsG.setVisibility(View.GONE);
         secprediscouns.setVisibility(View.GONE);
         lineprediscouns.setVisibility(View.GONE);
         seclbl14.setVisibility(View.GONE);
         linelbl14.setVisibility(View.GONE);
         seccounconsA.setVisibility(View.GONE);
         linecounconsA.setVisibility(View.GONE);
         seccounconsB.setVisibility(View.GONE);
         linecounconsB.setVisibility(View.GONE);
         seccounconsC.setVisibility(View.GONE);
         linecounconsC.setVisibility(View.GONE);
         secloskmc.setVisibility(View.GONE);
         lineloskmc.setVisibility(View.GONE);
         secloskmcDK.setVisibility(View.GONE);
         lineloskmcDK.setVisibility(View.GONE);
         secknowdiswgt.setVisibility(View.GONE);
         lineknowdiswgt.setVisibility(View.GONE);
         secdiswgtkmc.setVisibility(View.GONE);
         linediswgtkmc.setVisibility(View.GONE);
         secdiswgtkmcDK.setVisibility(View.GONE);
         linediswgtkmcDK.setVisibility(View.GONE);
         seccomments.setVisibility(View.GONE);
         linecomments.setVisibility(View.GONE);
         seclbl13.setVisibility(View.GONE);
         linelbl13.setVisibility(View.GONE);
         secunwellsignsA.setVisibility(View.GONE);
         lineunwellsignsA.setVisibility(View.GONE);
         secunwellsignsB.setVisibility(View.GONE);
         lineunwellsignsB.setVisibility(View.GONE);
         secunwellsignsC.setVisibility(View.GONE);
         lineunwellsignsC.setVisibility(View.GONE);
         secunwellsignsD.setVisibility(View.GONE);
         lineunwellsignsD.setVisibility(View.GONE);
         secunwellsignsE.setVisibility(View.GONE);
         lineunwellsignsE.setVisibility(View.GONE);
         secunwellsignsF.setVisibility(View.GONE);
         lineunwellsignsF.setVisibility(View.GONE);
         secunwellsignsFOth.setVisibility(View.GONE);
         lineunwellsignsFOth.setVisibility(View.GONE);
         secunwellsignsG.setVisibility(View.GONE);
         lineunwellsignsG.setVisibility(View.GONE);
         secprediscouns.setVisibility(View.GONE);
         lineprediscouns.setVisibility(View.GONE);
         seclbl14.setVisibility(View.GONE);
         linelbl14.setVisibility(View.GONE);
         seccounconsA.setVisibility(View.GONE);
         linecounconsA.setVisibility(View.GONE);
         seccounconsB.setVisibility(View.GONE);
         linecounconsB.setVisibility(View.GONE);
         seccounconsC.setVisibility(View.GONE);
         linecounconsC.setVisibility(View.GONE);
         secloskmc.setVisibility(View.GONE);
         lineloskmc.setVisibility(View.GONE);
         secloskmcDK.setVisibility(View.GONE);
         lineloskmcDK.setVisibility(View.GONE);
         secknowdiswgt.setVisibility(View.GONE);
         lineknowdiswgt.setVisibility(View.GONE);
         secdiswgtkmc.setVisibility(View.GONE);
         linediswgtkmc.setVisibility(View.GONE);
         secdiswgtkmcDK.setVisibility(View.GONE);
         linediswgtkmcDK.setVisibility(View.GONE);
         seccomments.setVisibility(View.GONE);
         linecomments.setVisibility(View.GONE);
         secunwellsignsFOth.setVisibility(View.GONE);
         lineunwellsignsFOth.setVisibility(View.GONE);
         seclbl14.setVisibility(View.GONE);
         linelbl14.setVisibility(View.GONE);
         seccounconsA.setVisibility(View.GONE);
         linecounconsA.setVisibility(View.GONE);
         seccounconsB.setVisibility(View.GONE);
         linecounconsB.setVisibility(View.GONE);
         seccounconsC.setVisibility(View.GONE);
         linecounconsC.setVisibility(View.GONE);
         seclbl14.setVisibility(View.GONE);
         linelbl14.setVisibility(View.GONE);
         seccounconsA.setVisibility(View.GONE);
         linecounconsA.setVisibility(View.GONE);
         seccounconsB.setVisibility(View.GONE);
         linecounconsB.setVisibility(View.GONE);
         seccounconsC.setVisibility(View.GONE);
         linecounconsC.setVisibility(View.GONE);
         secdiswgtkmc.setVisibility(View.GONE);
         linediswgtkmc.setVisibility(View.GONE);
         secdiswgtkmcDK.setVisibility(View.GONE);
         linediswgtkmcDK.setVisibility(View.GONE);
         seccomments.setVisibility(View.GONE);
         linecomments.setVisibility(View.GONE);
         secdiswgtkmc.setVisibility(View.GONE);
         linediswgtkmc.setVisibility(View.GONE);
         secdiswgtkmcDK.setVisibility(View.GONE);
         linediswgtkmcDK.setVisibility(View.GONE);
         seccomments.setVisibility(View.GONE);
         linecomments.setVisibility(View.GONE);


        Button cmdSave = (Button) findViewById(R.id.cmdSave);
        cmdSave.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) { 
            DataSave();
        }});
     }
     catch(Exception  e)
     {
         Connection.MessageBox(RecallSurvS4.this, e.getMessage());
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
             Connection.MessageBox(RecallSurvS4.this, "Required field: CountryCode.");
             txtCountryCode.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtCountryCode.getText().toString().length()==0 ? "1" : txtCountryCode.getText().toString()) < 1 || Integer.valueOf(txtCountryCode.getText().toString().length()==0 ? "3" : txtCountryCode.getText().toString()) > 3)
           {
             Connection.MessageBox(RecallSurvS4.this, "Value should be between 1 and 3(CountryCode).");
             txtCountryCode.requestFocus(); 
             return;	
           }
         else if(txtFaciCode.getText().toString().length()==0 & secFaciCode.isShown())
           {
             Connection.MessageBox(RecallSurvS4.this, "Required field: FaciCode.");
             txtFaciCode.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtFaciCode.getText().toString().length()==0 ? "1" : txtFaciCode.getText().toString()) < 1 || Integer.valueOf(txtFaciCode.getText().toString().length()==0 ? "9" : txtFaciCode.getText().toString()) > 9)
           {
             Connection.MessageBox(RecallSurvS4.this, "Value should be between 1 and 9(FaciCode).");
             txtFaciCode.requestFocus(); 
             return;	
           }
         else if(txtDataId.getText().toString().length()==0 & secDataId.isShown())
           {
             Connection.MessageBox(RecallSurvS4.this, "Required field: DataId.");
             txtDataId.requestFocus(); 
             return;	
           }
         else if(txtStudyID.getText().toString().length()==0 & secStudyID.isShown())
           {
             Connection.MessageBox(RecallSurvS4.this, "Required field: ParticipantID.");
             txtStudyID.requestFocus(); 
             return;	
           }
         
         else if(!rdoknowadwgtkmc1.isChecked() & !rdoknowadwgtkmc2.isChecked() & !rdoknowadwgtkmc3.isChecked() & secknowadwgtkmc.isShown())
           {
              Connection.MessageBox(RecallSurvS4.this, "Select anyone options from (Do you know your baby’s weight at time of admission to this unit?).");
              rdoknowadwgtkmc1.requestFocus();
              return;
           }
         else if(txtadwgtkmc.getText().toString().length()==0 & secadwgtkmc.isShown())
           {
             Connection.MessageBox(RecallSurvS4.this, "Required field: How much did your baby weigh? (grams).");
             txtadwgtkmc.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtadwgtkmc.getText().toString().length()==0 ? "1" : txtadwgtkmc.getText().toString()) < 1 || Integer.valueOf(txtadwgtkmc.getText().toString().length()==0 ? "9999" : txtadwgtkmc.getText().toString()) > 9999)
           {
             Connection.MessageBox(RecallSurvS4.this, "Value should be between 1 and 9999(How much did your baby weigh? (grams)).");
             txtadwgtkmc.requestFocus(); 
             return;	
           }
         
         else if(!rdohelpkmc1.isChecked() & !rdohelpkmc2.isChecked() & !rdohelpkmc3.isChecked() & sechelpkmc.isShown())
           {
              Connection.MessageBox(RecallSurvS4.this, "Select anyone options from (Were you told about any ways to help your baby because your baby was born too soon or too small?).");
              rdohelpkmc1.requestFocus();
              return;
           }
         
         else if(!rdoknowkmc1.isChecked() & !rdoknowkmc2.isChecked() & !rdoknowkmc3.isChecked() & secknowkmc.isShown())
           {
              Connection.MessageBox(RecallSurvS4.this, "Select anyone options from (Do you remember a health worker talking to you about starting KMC? PROMPT: By KMC I mean that you tied the baby to your front for most of the day for lots of days ).");
              rdoknowkmc1.requestFocus();
              return;
           }
         
         else if(!rdokmc1.isChecked() & !rdokmc2.isChecked() & !rdokmc3.isChecked() & seckmc.isShown())
           {
              Connection.MessageBox(RecallSurvS4.this, "Select anyone options from (Did your baby receive KMC? PROMPT: By KMC I mean that you tied the baby to your front for most of the day for lots of days).");
              rdokmc1.requestFocus();
              return;
           }
         else if(spnkmcwho.getSelectedItemPosition()==0  & seckmcwho.isShown())
           {
             Connection.MessageBox(RecallSurvS4.this, "Required field: Who did KMC with your baby?.");
             spnkmcwho.requestFocus(); 
             return;	
           }
         else if(txtkmcwhoOth.getText().toString().length()==0 & seckmcwhoOth.isShown())
           {
             Connection.MessageBox(RecallSurvS4.this, "Required field: Specify.");
             txtkmcwhoOth.requestFocus(); 
             return;	
           }
         else if(txtkmcreasOth.getText().toString().length()==0 & seckmcreasOth.isShown())
           {
             Connection.MessageBox(RecallSurvS4.this, "Required field: Specify.");
             txtkmcreasOth.requestFocus(); 
             return;	
           }
         else if(txtkmctime.getText().toString().length()==0 & seckmctime.isShown())
           {
             Connection.MessageBox(RecallSurvS4.this, "Required field: In the last 24hrs caring for your baby, how long was your baby in KMC position?.");
             txtkmctime.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtkmctime.getText().toString().length()==0 ? "1" : txtkmctime.getText().toString()) < 1 || Integer.valueOf(txtkmctime.getText().toString().length()==0 ? "99" : txtkmctime.getText().toString()) > 99)
           {
             Connection.MessageBox(RecallSurvS4.this, "Value should be between 1 and 99(In the last 24hrs caring for your baby, how long was your baby in KMC position?).");
             txtkmctime.requestFocus(); 
             return;	
           }
         else if(spnreasnokmc.getSelectedItemPosition()==0  & secreasnokmc.isShown())
           {
             Connection.MessageBox(RecallSurvS4.this, "Required field: If you were not able to keep your baby in the KMC position in the last 24 hours, what reasons prevented you from doing this?.");
             spnreasnokmc.requestFocus(); 
             return;	
           }
         else if(txtreasnokmcOth.getText().toString().length()==0 & secreasnokmcOth.isShown())
           {
             Connection.MessageBox(RecallSurvS4.this, "Required field: Specify.");
             txtreasnokmcOth.requestFocus(); 
             return;	
           }
         else if(spnbfmeth.getSelectedItemPosition()==0  & secbfmeth.isShown())
           {
             Connection.MessageBox(RecallSurvS4.this, "Required field: In the last 24hours, how many times did you feed your baby and what methods did you use? READ ANSWER CHOICES.");
             spnbfmeth.requestFocus(); 
             return;	
           }
         else if(txtbfmethDur.getText().toString().length()==0 & secbfmethDur.isShown())
           {
             Connection.MessageBox(RecallSurvS4.this, "Required field: Number of Time.");
             txtbfmethDur.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtbfmethDur.getText().toString().length()==0 ? "1" : txtbfmethDur.getText().toString()) < 1 || Integer.valueOf(txtbfmethDur.getText().toString().length()==0 ? "999" : txtbfmethDur.getText().toString()) > 999)
           {
             Connection.MessageBox(RecallSurvS4.this, "Value should be between 1 and 999(Number of Time).");
             txtbfmethDur.requestFocus(); 
             return;	
           }
         else if(spnknowunwellsigns.getSelectedItemPosition()==0  & secknowunwellsigns.isShown())
           {
             Connection.MessageBox(RecallSurvS4.this, "Required field: Did a health worker explain to you how to recognise that your baby is seriously unwell?.");
             spnknowunwellsigns.requestFocus(); 
             return;	
           }
         else if(txtunwellsignsFOth.getText().toString().length()==0 & secunwellsignsFOth.isShown())
           {
             Connection.MessageBox(RecallSurvS4.this, "Required field: Specify.");
             txtunwellsignsFOth.requestFocus(); 
             return;	
           }
         else if(spnprediscouns.getSelectedItemPosition()==0  & secprediscouns.isShown())
           {
             Connection.MessageBox(RecallSurvS4.this, "Required field: Did you receive a pre-discharge counselling session on KMC?.");
             spnprediscouns.requestFocus(); 
             return;	
           }
         else if(spncounconsA.getSelectedItemPosition()==0  & seccounconsA.isShown())
           {
             Connection.MessageBox(RecallSurvS4.this, "Required field: a) kangaroo mother care position.");
             spncounconsA.requestFocus(); 
             return;	
           }
         else if(spncounconsB.getSelectedItemPosition()==0  & seccounconsB.isShown())
           {
             Connection.MessageBox(RecallSurvS4.this, "Required field: b) Feeding practices.");
             spncounconsB.requestFocus(); 
             return;	
           }
         else if(spncounconsC.getSelectedItemPosition()==0  & seccounconsC.isShown())
           {
             Connection.MessageBox(RecallSurvS4.this, "Required field: c) Follow up visits at hospital or health centre.");
             spncounconsC.requestFocus(); 
             return;	
           }
         else if(txtloskmc.getText().toString().length()==0 & secloskmc.isShown())
           {
             Connection.MessageBox(RecallSurvS4.this, "Required field: How many days did you stay in the KMC section with your baby?.");
             txtloskmc.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtloskmc.getText().toString().length()==0 ? "1" : txtloskmc.getText().toString()) < 1 || Integer.valueOf(txtloskmc.getText().toString().length()==0 ? "99" : txtloskmc.getText().toString()) > 99)
           {
             Connection.MessageBox(RecallSurvS4.this, "Value should be between 1 and 99(How many days did you stay in the KMC section with your baby?).");
             txtloskmc.requestFocus(); 
             return;	
           }
         else if(spnknowdiswgt.getSelectedItemPosition()==0  & secknowdiswgt.isShown())
           {
             Connection.MessageBox(RecallSurvS4.this, "Required field: Do you know your babys weight at discharge from this unit?.");
             spnknowdiswgt.requestFocus(); 
             return;	
           }
         else if(txtdiswgtkmc.getText().toString().length()==0 & secdiswgtkmc.isShown())
           {
             Connection.MessageBox(RecallSurvS4.this, "Required field: How much does your baby weigh? (grams).");
             txtdiswgtkmc.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtdiswgtkmc.getText().toString().length()==0 ? "1" : txtdiswgtkmc.getText().toString()) < 1 || Integer.valueOf(txtdiswgtkmc.getText().toString().length()==0 ? "9999" : txtdiswgtkmc.getText().toString()) > 9999)
           {
             Connection.MessageBox(RecallSurvS4.this, "Value should be between 1 and 9999(How much does your baby weigh? (grams)).");
             txtdiswgtkmc.requestFocus(); 
             return;	
           }
         else if(txtcomments.getText().toString().length()==0 & seccomments.isShown())
           {
             Connection.MessageBox(RecallSurvS4.this, "Required field: INTERVIEWER COMMENTS.");
             txtcomments.requestFocus(); 
             return;	
           }
 
         String SQL = "";
         RadioButton rb;

         RecallSurvS4_DataModel objSave = new RecallSurvS4_DataModel();
         objSave.setCountryCode(txtCountryCode.getText().toString());
         objSave.setFaciCode(txtFaciCode.getText().toString());
         objSave.setDataId(txtDataId.getText().toString());
         objSave.setStudyID(txtStudyID.getText().toString());
         String[] d_rdogrpknowadwgtkmc = new String[] {"01","02","98"};
         objSave.setknowadwgtkmc("");
         for (int i = 0; i < rdogrpknowadwgtkmc.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpknowadwgtkmc.getChildAt(i);
             if (rb.isChecked()) objSave.setknowadwgtkmc(d_rdogrpknowadwgtkmc[i]);
         }

         objSave.setadwgtkmc(txtadwgtkmc.getText().toString());
         objSave.setadwgtkmcDK((chkadwgtkmcDK.isChecked()?"1":(secadwgtkmcDK.isShown()?"2":"")));
         String[] d_rdogrphelpkmc = new String[] {"01","02","98"};
         objSave.sethelpkmc("");
         for (int i = 0; i < rdogrphelpkmc.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrphelpkmc.getChildAt(i);
             if (rb.isChecked()) objSave.sethelpkmc(d_rdogrphelpkmc[i]);
         }

         String[] d_rdogrpknowkmc = new String[] {"01","02","98"};
         objSave.setknowkmc("");
         for (int i = 0; i < rdogrpknowkmc.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpknowkmc.getChildAt(i);
             if (rb.isChecked()) objSave.setknowkmc(d_rdogrpknowkmc[i]);
         }

         String[] d_rdogrpkmc = new String[] {"01","02","98"};
         objSave.setkmc("");
         for (int i = 0; i < rdogrpkmc.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpkmc.getChildAt(i);
             if (rb.isChecked()) objSave.setkmc(d_rdogrpkmc[i]);
         }

         objSave.setkmcwho((spnkmcwho.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnkmcwho.getSelectedItem().toString(), "-")));
         objSave.setkmcwhoOth(txtkmcwhoOth.getText().toString());
         objSave.setkmcreasA((chkkmcreasA.isChecked()?"1":(seckmcreasA.isShown()?"2":"")));
         objSave.setkmcreasB((chkkmcreasB.isChecked()?"1":(seckmcreasB.isShown()?"2":"")));
         objSave.setkmcreasC((chkkmcreasC.isChecked()?"1":(seckmcreasC.isShown()?"2":"")));
         objSave.setkmcreasD((chkkmcreasD.isChecked()?"1":(seckmcreasD.isShown()?"2":"")));
         objSave.setkmcreasE((chkkmcreasE.isChecked()?"1":(seckmcreasE.isShown()?"2":"")));
         objSave.setkmcreasF((chkkmcreasF.isChecked()?"1":(seckmcreasF.isShown()?"2":"")));
         objSave.setkmcreasOth(txtkmcreasOth.getText().toString());
         objSave.setkmcreasG((chkkmcreasG.isChecked()?"1":(seckmcreasG.isShown()?"2":"")));
         objSave.setkmcposA((chkkmcposA.isChecked()?"1":(seckmcposA.isShown()?"2":"")));
         objSave.setkmcposB((chkkmcposB.isChecked()?"1":(seckmcposB.isShown()?"2":"")));
         objSave.setkmcposC((chkkmcposC.isChecked()?"1":(seckmcposC.isShown()?"2":"")));
         objSave.setkmcposD((chkkmcposD.isChecked()?"1":(seckmcposD.isShown()?"2":"")));
         objSave.setkmcposE((chkkmcposE.isChecked()?"1":(seckmcposE.isShown()?"2":"")));
         objSave.setkmcposF((chkkmcposF.isChecked()?"1":(seckmcposF.isShown()?"2":"")));
         objSave.setkmcposG((chkkmcposG.isChecked()?"1":(seckmcposG.isShown()?"2":"")));
         objSave.setkmcposH((chkkmcposH.isChecked()?"1":(seckmcposH.isShown()?"2":"")));
         objSave.setkmcposI((chkkmcposI.isChecked()?"1":(seckmcposI.isShown()?"2":"")));
         objSave.setkmcedA((chkkmcedA.isChecked()?"1":(seckmcedA.isShown()?"2":"")));
         objSave.setkmcedB((chkkmcedB.isChecked()?"1":(seckmcedB.isShown()?"2":"")));
         objSave.setkmcedC((chkkmcedC.isChecked()?"1":(seckmcedC.isShown()?"2":"")));
         objSave.setkmcedD((chkkmcedD.isChecked()?"1":(seckmcedD.isShown()?"2":"")));
         objSave.setkmcedE((chkkmcedE.isChecked()?"1":(seckmcedE.isShown()?"2":"")));
         objSave.setkmcedF((chkkmcedF.isChecked()?"1":(seckmcedF.isShown()?"2":"")));
         objSave.setkmcedG((chkkmcedG.isChecked()?"1":(seckmcedG.isShown()?"2":"")));
         objSave.setkmcedH((chkkmcedH.isChecked()?"1":(seckmcedH.isShown()?"2":"")));
         objSave.setkmctime(txtkmctime.getText().toString());
         objSave.setkmctimeDK((chkkmctimeDK.isChecked()?"1":(seckmctimeDK.isShown()?"2":"")));
         objSave.setreasnokmc((spnreasnokmc.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnreasnokmc.getSelectedItem().toString(), "-")));
         objSave.setreasnokmcOth(txtreasnokmcOth.getText().toString());
         objSave.setbfmeth((spnbfmeth.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnbfmeth.getSelectedItem().toString(), "-")));
         objSave.setbfmethDur(txtbfmethDur.getText().toString());
         objSave.setknowunwellsigns((spnknowunwellsigns.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnknowunwellsigns.getSelectedItem().toString(), "-")));
         objSave.setunwellsignsA((chkunwellsignsA.isChecked()?"1":(secunwellsignsA.isShown()?"2":"")));
         objSave.setunwellsignsB((chkunwellsignsB.isChecked()?"1":(secunwellsignsB.isShown()?"2":"")));
         objSave.setunwellsignsC((chkunwellsignsC.isChecked()?"1":(secunwellsignsC.isShown()?"2":"")));
         objSave.setunwellsignsD((chkunwellsignsD.isChecked()?"1":(secunwellsignsD.isShown()?"2":"")));
         objSave.setunwellsignsE((chkunwellsignsE.isChecked()?"1":(secunwellsignsE.isShown()?"2":"")));
         objSave.setunwellsignsF((chkunwellsignsF.isChecked()?"1":(secunwellsignsF.isShown()?"2":"")));
         objSave.setunwellsignsFOth(txtunwellsignsFOth.getText().toString());
         objSave.setunwellsignsG((chkunwellsignsG.isChecked()?"1":(secunwellsignsG.isShown()?"2":"")));
         objSave.setprediscouns((spnprediscouns.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnprediscouns.getSelectedItem().toString(), "-")));
         objSave.setcounconsA((spncounconsA.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spncounconsA.getSelectedItem().toString(), "-")));
         objSave.setcounconsB((spncounconsB.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spncounconsB.getSelectedItem().toString(), "-")));
         objSave.setcounconsC((spncounconsC.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spncounconsC.getSelectedItem().toString(), "-")));
         objSave.setloskmc(txtloskmc.getText().toString());
         objSave.setloskmcDK((chkloskmcDK.isChecked()?"1":(secloskmcDK.isShown()?"2":"")));
         objSave.setknowdiswgt((spnknowdiswgt.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnknowdiswgt.getSelectedItem().toString(), "-")));
         objSave.setdiswgtkmc(txtdiswgtkmc.getText().toString());
         objSave.setdiswgtkmcDK((chkdiswgtkmcDK.isChecked()?"1":(secdiswgtkmcDK.isShown()?"2":"")));
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
             Intent returnIntent = new Intent();
             returnIntent.putExtra("res", "");
             setResult(Activity.RESULT_OK, returnIntent);

             Connection.MessageBox(RecallSurvS4.this, "Saved Successfully");
         }
         else{
             Connection.MessageBox(RecallSurvS4.this, status);
             return;
         }
     }
     catch(Exception  e)
     {
         Connection.MessageBox(RecallSurvS4.this, e.getMessage());
         return;
     }
 }

 private void DataSearch(String CountryCode, String FaciCode, String DataId)
     {
       try
        {
     
           RadioButton rb;
           RecallSurvS4_DataModel d = new RecallSurvS4_DataModel();
           String SQL = "Select * from "+ TableName +"  Where CountryCode='"+ CountryCode +"' and FaciCode='"+ FaciCode +"' and DataId='"+ DataId +"'";
           List<RecallSurvS4_DataModel> data = d.SelectAll(this, SQL);
           for(RecallSurvS4_DataModel item : data){
             txtCountryCode.setText(item.getCountryCode());
             txtFaciCode.setText(item.getFaciCode());
             txtDataId.setText(item.getDataId());
             txtStudyID.setText(item.getStudyID());
             String[] d_rdogrpknowadwgtkmc = new String[] {"01","02","98"};
             for (int i = 0; i < d_rdogrpknowadwgtkmc.length; i++)
             {
                 if (item.getknowadwgtkmc().equals(String.valueOf(d_rdogrpknowadwgtkmc[i])))
                 {
                     rb = (RadioButton)rdogrpknowadwgtkmc.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtadwgtkmc.setText(item.getadwgtkmc());
             if(item.getadwgtkmcDK().equals("1"))
             {
                chkadwgtkmcDK.setChecked(true);
             }
             else if(item.getadwgtkmcDK().equals("2"))
             {
                chkadwgtkmcDK.setChecked(false);
             }
             String[] d_rdogrphelpkmc = new String[] {"01","02","98"};
             for (int i = 0; i < d_rdogrphelpkmc.length; i++)
             {
                 if (item.gethelpkmc().equals(String.valueOf(d_rdogrphelpkmc[i])))
                 {
                     rb = (RadioButton)rdogrphelpkmc.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpknowkmc = new String[] {"01","02","98"};
             for (int i = 0; i < d_rdogrpknowkmc.length; i++)
             {
                 if (item.getknowkmc().equals(String.valueOf(d_rdogrpknowkmc[i])))
                 {
                     rb = (RadioButton)rdogrpknowkmc.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpkmc = new String[] {"01","02","98"};
             for (int i = 0; i < d_rdogrpkmc.length; i++)
             {
                 if (item.getkmc().equals(String.valueOf(d_rdogrpkmc[i])))
                 {
                     rb = (RadioButton)rdogrpkmc.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             spnkmcwho.setSelection(Global.SpinnerItemPositionAnyLength(spnkmcwho, item.getkmcwho()));
             txtkmcwhoOth.setText(item.getkmcwhoOth());
             if(item.getkmcreasA().equals("1"))
             {
                chkkmcreasA.setChecked(true);
             }
             else if(item.getkmcreasA().equals("2"))
             {
                chkkmcreasA.setChecked(false);
             }
             if(item.getkmcreasB().equals("1"))
             {
                chkkmcreasB.setChecked(true);
             }
             else if(item.getkmcreasB().equals("2"))
             {
                chkkmcreasB.setChecked(false);
             }
             if(item.getkmcreasC().equals("1"))
             {
                chkkmcreasC.setChecked(true);
             }
             else if(item.getkmcreasC().equals("2"))
             {
                chkkmcreasC.setChecked(false);
             }
             if(item.getkmcreasD().equals("1"))
             {
                chkkmcreasD.setChecked(true);
             }
             else if(item.getkmcreasD().equals("2"))
             {
                chkkmcreasD.setChecked(false);
             }
             if(item.getkmcreasE().equals("1"))
             {
                chkkmcreasE.setChecked(true);
             }
             else if(item.getkmcreasE().equals("2"))
             {
                chkkmcreasE.setChecked(false);
             }
             if(item.getkmcreasF().equals("1"))
             {
                chkkmcreasF.setChecked(true);
             }
             else if(item.getkmcreasF().equals("2"))
             {
                chkkmcreasF.setChecked(false);
             }
             txtkmcreasOth.setText(item.getkmcreasOth());
             if(item.getkmcreasG().equals("1"))
             {
                chkkmcreasG.setChecked(true);
             }
             else if(item.getkmcreasG().equals("2"))
             {
                chkkmcreasG.setChecked(false);
             }
             if(item.getkmcposA().equals("1"))
             {
                chkkmcposA.setChecked(true);
             }
             else if(item.getkmcposA().equals("2"))
             {
                chkkmcposA.setChecked(false);
             }
             if(item.getkmcposB().equals("1"))
             {
                chkkmcposB.setChecked(true);
             }
             else if(item.getkmcposB().equals("2"))
             {
                chkkmcposB.setChecked(false);
             }
             if(item.getkmcposC().equals("1"))
             {
                chkkmcposC.setChecked(true);
             }
             else if(item.getkmcposC().equals("2"))
             {
                chkkmcposC.setChecked(false);
             }
             if(item.getkmcposD().equals("1"))
             {
                chkkmcposD.setChecked(true);
             }
             else if(item.getkmcposD().equals("2"))
             {
                chkkmcposD.setChecked(false);
             }
             if(item.getkmcposE().equals("1"))
             {
                chkkmcposE.setChecked(true);
             }
             else if(item.getkmcposE().equals("2"))
             {
                chkkmcposE.setChecked(false);
             }
             if(item.getkmcposF().equals("1"))
             {
                chkkmcposF.setChecked(true);
             }
             else if(item.getkmcposF().equals("2"))
             {
                chkkmcposF.setChecked(false);
             }
             if(item.getkmcposG().equals("1"))
             {
                chkkmcposG.setChecked(true);
             }
             else if(item.getkmcposG().equals("2"))
             {
                chkkmcposG.setChecked(false);
             }
             if(item.getkmcposH().equals("1"))
             {
                chkkmcposH.setChecked(true);
             }
             else if(item.getkmcposH().equals("2"))
             {
                chkkmcposH.setChecked(false);
             }
             if(item.getkmcposI().equals("1"))
             {
                chkkmcposI.setChecked(true);
             }
             else if(item.getkmcposI().equals("2"))
             {
                chkkmcposI.setChecked(false);
             }
             if(item.getkmcedA().equals("1"))
             {
                chkkmcedA.setChecked(true);
             }
             else if(item.getkmcedA().equals("2"))
             {
                chkkmcedA.setChecked(false);
             }
             if(item.getkmcedB().equals("1"))
             {
                chkkmcedB.setChecked(true);
             }
             else if(item.getkmcedB().equals("2"))
             {
                chkkmcedB.setChecked(false);
             }
             if(item.getkmcedC().equals("1"))
             {
                chkkmcedC.setChecked(true);
             }
             else if(item.getkmcedC().equals("2"))
             {
                chkkmcedC.setChecked(false);
             }
             if(item.getkmcedD().equals("1"))
             {
                chkkmcedD.setChecked(true);
             }
             else if(item.getkmcedD().equals("2"))
             {
                chkkmcedD.setChecked(false);
             }
             if(item.getkmcedE().equals("1"))
             {
                chkkmcedE.setChecked(true);
             }
             else if(item.getkmcedE().equals("2"))
             {
                chkkmcedE.setChecked(false);
             }
             if(item.getkmcedF().equals("1"))
             {
                chkkmcedF.setChecked(true);
             }
             else if(item.getkmcedF().equals("2"))
             {
                chkkmcedF.setChecked(false);
             }
             if(item.getkmcedG().equals("1"))
             {
                chkkmcedG.setChecked(true);
             }
             else if(item.getkmcedG().equals("2"))
             {
                chkkmcedG.setChecked(false);
             }
             if(item.getkmcedH().equals("1"))
             {
                chkkmcedH.setChecked(true);
             }
             else if(item.getkmcedH().equals("2"))
             {
                chkkmcedH.setChecked(false);
             }
             txtkmctime.setText(item.getkmctime());
             if(item.getkmctimeDK().equals("1"))
             {
                chkkmctimeDK.setChecked(true);
             }
             else if(item.getkmctimeDK().equals("2"))
             {
                chkkmctimeDK.setChecked(false);
             }
             spnreasnokmc.setSelection(Global.SpinnerItemPositionAnyLength(spnreasnokmc, item.getreasnokmc()));
             txtreasnokmcOth.setText(item.getreasnokmcOth());
             spnbfmeth.setSelection(Global.SpinnerItemPositionAnyLength(spnbfmeth, item.getbfmeth()));
             txtbfmethDur.setText(item.getbfmethDur());
             spnknowunwellsigns.setSelection(Global.SpinnerItemPositionAnyLength(spnknowunwellsigns, item.getknowunwellsigns()));
             if(item.getunwellsignsA().equals("1"))
             {
                chkunwellsignsA.setChecked(true);
             }
             else if(item.getunwellsignsA().equals("2"))
             {
                chkunwellsignsA.setChecked(false);
             }
             if(item.getunwellsignsB().equals("1"))
             {
                chkunwellsignsB.setChecked(true);
             }
             else if(item.getunwellsignsB().equals("2"))
             {
                chkunwellsignsB.setChecked(false);
             }
             if(item.getunwellsignsC().equals("1"))
             {
                chkunwellsignsC.setChecked(true);
             }
             else if(item.getunwellsignsC().equals("2"))
             {
                chkunwellsignsC.setChecked(false);
             }
             if(item.getunwellsignsD().equals("1"))
             {
                chkunwellsignsD.setChecked(true);
             }
             else if(item.getunwellsignsD().equals("2"))
             {
                chkunwellsignsD.setChecked(false);
             }
             if(item.getunwellsignsE().equals("1"))
             {
                chkunwellsignsE.setChecked(true);
             }
             else if(item.getunwellsignsE().equals("2"))
             {
                chkunwellsignsE.setChecked(false);
             }
             if(item.getunwellsignsF().equals("1"))
             {
                chkunwellsignsF.setChecked(true);
             }
             else if(item.getunwellsignsF().equals("2"))
             {
                chkunwellsignsF.setChecked(false);
             }
             txtunwellsignsFOth.setText(item.getunwellsignsFOth());
             if(item.getunwellsignsG().equals("1"))
             {
                chkunwellsignsG.setChecked(true);
             }
             else if(item.getunwellsignsG().equals("2"))
             {
                chkunwellsignsG.setChecked(false);
             }
             spnprediscouns.setSelection(Global.SpinnerItemPositionAnyLength(spnprediscouns, item.getprediscouns()));
             spncounconsA.setSelection(Global.SpinnerItemPositionAnyLength(spncounconsA, item.getcounconsA()));
             spncounconsB.setSelection(Global.SpinnerItemPositionAnyLength(spncounconsB, item.getcounconsB()));
             spncounconsC.setSelection(Global.SpinnerItemPositionAnyLength(spncounconsC, item.getcounconsC()));
             txtloskmc.setText(item.getloskmc());
             if(item.getloskmcDK().equals("1"))
             {
                chkloskmcDK.setChecked(true);
             }
             else if(item.getloskmcDK().equals("2"))
             {
                chkloskmcDK.setChecked(false);
             }
             spnknowdiswgt.setSelection(Global.SpinnerItemPositionAnyLength(spnknowdiswgt, item.getknowdiswgt()));
             txtdiswgtkmc.setText(item.getdiswgtkmc());
             if(item.getdiswgtkmcDK().equals("1"))
             {
                chkdiswgtkmcDK.setChecked(true);
             }
             else if(item.getdiswgtkmcDK().equals("2"))
             {
                chkdiswgtkmcDK.setChecked(false);
             }
             txtcomments.setText(item.getcomments());
           }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(RecallSurvS4.this, e.getMessage());
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