
 package org.icddrb.enap;


 //Android Manifest Code
 //<activity android:name=".KMC_DataExt" android:label="KMC_DataExt" />
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
 import Utility.*;
 import Common.*;

 public class KMC_DataExt extends Activity {
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

     LinearLayout secstatus;
     RadioGroup rdogrpstatus;
     RadioButton rdostatus1;
     RadioButton rdostatus2;
     RadioButton rdostatus3;
     LinearLayout secreason;
     RadioGroup rdogrpreason;
     RadioButton rdoreason1;
     RadioButton rdoreason2;
     RadioButton rdoreason3;
     RadioButton rdoreason4;
     LinearLayout secreasmention;
     EditText txtreasmention;

     LinearLayout secrefdelivdatenot;
     RadioGroup rdogrprefdelivdatenot;
     RadioButton rdorefdelivdatenot1;
     RadioButton rdorefdelivdatenot2;

     LinearLayout secrefdelivtimenot;
     RadioGroup rdogrprefdelivtimenot;
     RadioButton rdorefdelivtimenot1;
     RadioButton rdorefdelivtimenot2;

     LinearLayout secrefdoadmkmcnot;
     RadioGroup rdogrprefdoadmkmcnot;
     RadioButton rdorefdoadmkmcnot1;
     RadioButton rdorefdoadmkmcnot2;

     LinearLayout secreftoadmkmcnot;
     RadioGroup rdogrpreftoadmkmcnot;
     RadioButton rdoreftoadmkmcnot1;
     RadioButton rdoreftoadmkmcnot2;

     LinearLayout secrefdodkmcnot;
     RadioGroup rdogrprefdodkmcnot;
     RadioButton rdorefdodkmcnot1;
     RadioButton rdorefdodkmcnot2;


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
         LinearLayout secrefabskmc;
         View linerefabskmc;
         TextView Vlblrefabskmc;
         RadioGroup rdogrprefabskmc;
         
         RadioButton rdorefabskmc1;
         RadioButton rdorefabskmc2;
         RadioButton rdorefabskmc3;
         LinearLayout secrefabskmcOth;
         View linerefabskmcOth;
         TextView VlblrefabskmcOth;
         EditText txtrefabskmcOth;
         LinearLayout secrefmatname;
         View linerefmatname;
         TextView Vlblrefmatname;
         EditText txtrefmatname;
         LinearLayout secrefmatage;
         View linerefmatage;
         TextView Vlblrefmatage;
         EditText txtrefmatage;
         LinearLayout secrefmatid;
         View linerefmatid;
         TextView Vlblrefmatid;
         EditText txtrefmatid;
         LinearLayout secrefbname;
         View linerefbname;
         TextView Vlblrefbname;
         EditText txtrefbname;
         LinearLayout secrefbid;
         View linerefbid;
         TextView Vlblrefbid;
         EditText txtrefbid;
         LinearLayout secrefbsex;
         View linerefbsex;
         TextView Vlblrefbsex;
         RadioGroup rdogrprefbsex;
         
         RadioButton rdorefbsex1;
         RadioButton rdorefbsex2;
         RadioButton rdorefbsex3;
         RadioButton rdorefbsex4;
         RadioButton rdorefbsex5;
         LinearLayout secrefdelivdate;
         View linerefdelivdate;
         TextView Vlblrefdelivdate;
         EditText dtprefdelivdate;
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
         LinearLayout secrefgakmc;
         View linerefgakmc;
         TextView Vlblrefgakmc;
         EditText txtrefgakmc;
         LinearLayout secrefgakmcnot;
         View linerefgakmcnot;
         TextView Vlblrefgakmcnot;
         RadioGroup rdogrprefgakmcnot;
         
         RadioButton rdorefgakmcnot1;
         RadioButton rdorefgakmcnot2;
         LinearLayout secrefbbornloc;
         View linerefbbornloc;
         TextView Vlblrefbbornloc;
         RadioGroup rdogrprefbbornloc;
         
         RadioButton rdorefbbornloc1;
         RadioButton rdorefbbornloc2;
         RadioButton rdorefbbornloc3;
         RadioButton rdorefbbornloc4;
         RadioButton rdorefbbornloc5;
         RadioButton rdorefbbornloc6;
         LinearLayout secrefbbornOth;
         View linerefbbornOth;
         TextView VlblrefbbornOth;
         EditText txtrefbbornOth;
         LinearLayout secrefdelivtime;
         View linerefdelivtime;
         TextView Vlblrefdelivtime;
         EditText txtrefdelivtime;
         LinearLayout secrefdoadmkmc;
         View linerefdoadmkmc;
         TextView Vlblrefdoadmkmc;
         EditText dtprefdoadmkmc;
         LinearLayout secreftoadmkmc;
         View linereftoadmkmc;
         TextView Vlblreftoadmkmc;
         EditText txtreftoadmkmc;
         LinearLayout secrefadwgtkmc;
         View linerefadwgtkmc;
         TextView Vlblrefadwgtkmc;
         EditText txtrefadwgtkmc;
         LinearLayout secrefadwgtkmcnot;
         View linerefadwgtkmcnot;
         TextView Vlblrefadwgtkmcnot;
         RadioGroup rdogrprefadwgtkmcnot;
         
         RadioButton rdorefadwgtkmcnot1;
         RadioButton rdorefadwgtkmcnot2;
         LinearLayout seclblrefbfsup;
         View linelblrefbfsup;
         LinearLayout secrefbfsupA;
         View linerefbfsupA;
         TextView VlblrefbfsupA;
         CheckBox chkrefbfsupA;
         LinearLayout secrefbfsupB;
         View linerefbfsupB;
         TextView VlblrefbfsupB;
         CheckBox chkrefbfsupB;
         LinearLayout secrefbfsupC;
         View linerefbfsupC;
         TextView VlblrefbfsupC;
         CheckBox chkrefbfsupC;
         LinearLayout secrefbfsupD;
         View linerefbfsupD;
         TextView VlblrefbfsupD;
         CheckBox chkrefbfsupD;
         LinearLayout secrefbfsupE;
         View linerefbfsupE;
         TextView VlblrefbfsupE;
         CheckBox chkrefbfsupE;
         LinearLayout secrefbfsupF;
         View linerefbfsupF;
         TextView VlblrefbfsupF;
         CheckBox chkrefbfsupF;
         LinearLayout secrefbfsupFOth;
         View linerefbfsupFOth;
         TextView VlblrefbfsupFOth;
         EditText txtrefbfsupFOth;
         LinearLayout secrefdisoutkmc;
         View linerefdisoutkmc;
         TextView Vlblrefdisoutkmc;
         RadioGroup rdogrprefdisoutkmc;
         
         RadioButton rdorefdisoutkmc1;
         RadioButton rdorefdisoutkmc2;
         RadioButton rdorefdisoutkmc3;
         RadioButton rdorefdisoutkmc4;
         RadioButton rdorefdisoutkmc5;
         RadioButton rdorefdisoutkmc6;
         RadioButton rdorefdisoutkmc7;
         LinearLayout secreftransPlace;
         View linereftransPlace;
         TextView VlblreftransPlace;
         EditText txtreftransPlace;
         LinearLayout secrefdodkmc;
         View linerefdodkmc;
         TextView Vlblrefdodkmc;
         EditText dtprefdodkmc;
         LinearLayout secrefdiswgtkmc;
         View linerefdiswgtkmc;
         TextView Vlblrefdiswgtkmc;
         EditText txtrefdiswgtkmc;
         LinearLayout secregdiswgtkmcnot;
         View lineregdiswgtkmcnot;
         TextView Vlblregdiswgtkmcnot;
         RadioGroup rdogrpregdiswgtkmcnot;
         
         RadioButton rdoregdiswgtkmcnot1;
         RadioButton rdoregdiswgtkmcnot2;

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
         setContentView(R.layout.kmc_dataext);
         C = new Connection(this);
         g = Global.getInstance();

         STARTTIME = g.CurrentTime24();
         DEVICEID  = sp.getValue(this, "deviceid");
         ENTRYUSER = sp.getValue(this, "userid");

         IDbundle = getIntent().getExtras();
         COUNTRYCODE = IDbundle.getString("CountryCode");
         FACICODE = IDbundle.getString("FaciCode");
         DATAID = IDbundle.getString("DataID");

         TableName = "KMC_DataExt";

         //turnGPSOn();

         //GPS Location
         //FindLocation();
         // Double.toString(currentLatitude);
         // Double.toString(currentLongitude);
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(KMC_DataExt.this);
                 adb.setTitle("Close");
                 adb.setMessage("Do you want to close this form[Yes/No]?");
                 adb.setNegativeButton("No", null);
                 adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                     public void onClick(DialogInterface dialog, int which) {
                         finish();
                     }});
                 adb.show();
             }});
         secstatus=(LinearLayout)findViewById(R.id.secstatus) ;
         rdogrpstatus=(RadioGroup)findViewById(R.id.rdogrpstatus) ;
         rdostatus1=(RadioButton)findViewById(R.id.rdostatus1) ;
         rdostatus2=(RadioButton)findViewById(R.id.rdostatus2) ;
         rdostatus3=(RadioButton)findViewById(R.id.rdostatus3) ;
         secreason=(LinearLayout)findViewById(R.id.secreason) ;
         rdogrpreason=(RadioGroup)findViewById(R.id.rdogrpreason) ;
         rdoreason1=(RadioButton)findViewById(R.id.rdoreason1) ;
         rdoreason2=(RadioButton)findViewById(R.id.rdoreason2) ;
         rdoreason3=(RadioButton)findViewById(R.id.rdoreason3) ;
         rdoreason4=(RadioButton)findViewById(R.id.rdoreason4) ;
         secreasmention=(LinearLayout)findViewById(R.id.secreasmention) ;
         txtreasmention=(EditText)findViewById(R.id.txtreasmention) ;


         secrefdelivdatenot=(LinearLayout)findViewById(R.id.secrefdelivdatenot) ;
         rdogrprefdelivdatenot=(RadioGroup)findViewById(R.id.rdogrprefdelivdatenot) ;
         rdorefdelivdatenot1=(RadioButton)findViewById(R.id.rdorefdelivdatenot1) ;
         rdorefdelivdatenot2=(RadioButton)findViewById(R.id.rdorefdelivdatenot2) ;

         secrefdelivtimenot=(LinearLayout)findViewById(R.id.secrefdelivtimenot) ;
         rdogrprefdelivtimenot=(RadioGroup)findViewById(R.id.rdogrprefdelivtimenot) ;
         rdorefdelivtimenot1=(RadioButton)findViewById(R.id.rdorefdelivtimenot1) ;
         rdorefdelivtimenot2=(RadioButton)findViewById(R.id.rdorefdelivtimenot2) ;

         secrefdoadmkmcnot=(LinearLayout)findViewById(R.id.secrefdoadmkmcnot) ;
         rdogrprefdoadmkmcnot=(RadioGroup)findViewById(R.id.rdogrprefdoadmkmcnot) ;
         rdorefdoadmkmcnot1=(RadioButton)findViewById(R.id.rdorefdoadmkmcnot1) ;
         rdorefdoadmkmcnot2=(RadioButton)findViewById(R.id.rdorefdoadmkmcnot2) ;

         secreftoadmkmcnot=(LinearLayout)findViewById(R.id.secreftoadmkmcnot) ;
         rdogrpreftoadmkmcnot=(RadioGroup)findViewById(R.id.rdogrpreftoadmkmcnot) ;
         rdoreftoadmkmcnot1=(RadioButton)findViewById(R.id.rdoreftoadmkmcnot1) ;
         rdoreftoadmkmcnot2=(RadioButton)findViewById(R.id.rdoreftoadmkmcnot2) ;

         secrefdodkmcnot=(LinearLayout)findViewById(R.id.secrefdodkmcnot) ;
         rdogrprefdodkmcnot=(RadioGroup)findViewById(R.id.rdogrprefdodkmcnot) ;
         rdorefdodkmcnot1=(RadioButton)findViewById(R.id.rdorefdodkmcnot1) ;
         rdorefdodkmcnot2=(RadioButton)findViewById(R.id.rdorefdodkmcnot2) ;

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
         secrefabskmc=(LinearLayout)findViewById(R.id.secrefabskmc);
         linerefabskmc=(View)findViewById(R.id.linerefabskmc);
         Vlblrefabskmc = (TextView) findViewById(R.id.Vlblrefabskmc);
         rdogrprefabskmc = (RadioGroup) findViewById(R.id.rdogrprefabskmc);
         
         rdorefabskmc1 = (RadioButton) findViewById(R.id.rdorefabskmc1);
         rdorefabskmc2 = (RadioButton) findViewById(R.id.rdorefabskmc2);
         rdorefabskmc3 = (RadioButton) findViewById(R.id.rdorefabskmc3);
         rdogrprefabskmc.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrprefabskmc = new String[] {"1","2","3"};
             for (int i = 0; i < rdogrprefabskmc.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrprefabskmc.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrprefabskmc[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                    secrefabskmcOth.setVisibility(View.GONE);
                    linerefabskmcOth.setVisibility(View.GONE);
                    txtrefabskmcOth.setText("");
             }
             else if(rbData.equalsIgnoreCase("2"))
             {
                    secrefabskmcOth.setVisibility(View.GONE);
                    linerefabskmcOth.setVisibility(View.GONE);
                    txtrefabskmcOth.setText("");
             }
             else if(rbData.equalsIgnoreCase("3"))
             {
                    secrefabskmcOth.setVisibility(View.VISIBLE);
                    linerefabskmcOth.setVisibility(View.VISIBLE);
             }
             else
             {
                    //sec.setVisibility(View.VISIBLE);
                    //line.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secrefabskmcOth=(LinearLayout)findViewById(R.id.secrefabskmcOth);
         linerefabskmcOth=(View)findViewById(R.id.linerefabskmcOth);
         VlblrefabskmcOth=(TextView) findViewById(R.id.VlblrefabskmcOth);
         txtrefabskmcOth=(EditText) findViewById(R.id.txtrefabskmcOth);
         secrefmatname=(LinearLayout)findViewById(R.id.secrefmatname);
         linerefmatname=(View)findViewById(R.id.linerefmatname);
         Vlblrefmatname=(TextView) findViewById(R.id.Vlblrefmatname);
         txtrefmatname=(EditText) findViewById(R.id.txtrefmatname);
         secrefmatage=(LinearLayout)findViewById(R.id.secrefmatage);
         linerefmatage=(View)findViewById(R.id.linerefmatage);
         Vlblrefmatage=(TextView) findViewById(R.id.Vlblrefmatage);
         txtrefmatage=(EditText) findViewById(R.id.txtrefmatage);
         secrefmatid=(LinearLayout)findViewById(R.id.secrefmatid);
         linerefmatid=(View)findViewById(R.id.linerefmatid);
         Vlblrefmatid=(TextView) findViewById(R.id.Vlblrefmatid);
         txtrefmatid=(EditText) findViewById(R.id.txtrefmatid);
         secrefbname=(LinearLayout)findViewById(R.id.secrefbname);
         linerefbname=(View)findViewById(R.id.linerefbname);
         Vlblrefbname=(TextView) findViewById(R.id.Vlblrefbname);
         txtrefbname=(EditText) findViewById(R.id.txtrefbname);
         secrefbid=(LinearLayout)findViewById(R.id.secrefbid);
         linerefbid=(View)findViewById(R.id.linerefbid);
         Vlblrefbid=(TextView) findViewById(R.id.Vlblrefbid);
         txtrefbid=(EditText) findViewById(R.id.txtrefbid);
         secrefbsex=(LinearLayout)findViewById(R.id.secrefbsex);
         linerefbsex=(View)findViewById(R.id.linerefbsex);
         Vlblrefbsex = (TextView) findViewById(R.id.Vlblrefbsex);
         rdogrprefbsex = (RadioGroup) findViewById(R.id.rdogrprefbsex);
         
         rdorefbsex1 = (RadioButton) findViewById(R.id.rdorefbsex1);
         rdorefbsex2 = (RadioButton) findViewById(R.id.rdorefbsex2);
         rdorefbsex3 = (RadioButton) findViewById(R.id.rdorefbsex3);
         rdorefbsex4 = (RadioButton) findViewById(R.id.rdorefbsex4);
         rdorefbsex5 = (RadioButton) findViewById(R.id.rdorefbsex5);
         secrefdelivdate=(LinearLayout)findViewById(R.id.secrefdelivdate);
         linerefdelivdate=(View)findViewById(R.id.linerefdelivdate);
         Vlblrefdelivdate=(TextView) findViewById(R.id.Vlblrefdelivdate);
         dtprefdelivdate=(EditText) findViewById(R.id.dtprefdelivdate);
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
         secrefgakmc=(LinearLayout)findViewById(R.id.secrefgakmc);
         linerefgakmc=(View)findViewById(R.id.linerefgakmc);
         Vlblrefgakmc=(TextView) findViewById(R.id.Vlblrefgakmc);
         txtrefgakmc=(EditText) findViewById(R.id.txtrefgakmc);
         secrefgakmcnot=(LinearLayout)findViewById(R.id.secrefgakmcnot);
         linerefgakmcnot=(View)findViewById(R.id.linerefgakmcnot);
         Vlblrefgakmcnot = (TextView) findViewById(R.id.Vlblrefgakmcnot);
         rdogrprefgakmcnot = (RadioGroup) findViewById(R.id.rdogrprefgakmcnot);
         
         rdorefgakmcnot1 = (RadioButton) findViewById(R.id.rdorefgakmcnot1);
         rdorefgakmcnot2 = (RadioButton) findViewById(R.id.rdorefgakmcnot2);
         secrefbbornloc=(LinearLayout)findViewById(R.id.secrefbbornloc);
         linerefbbornloc=(View)findViewById(R.id.linerefbbornloc);
         Vlblrefbbornloc = (TextView) findViewById(R.id.Vlblrefbbornloc);
         rdogrprefbbornloc = (RadioGroup) findViewById(R.id.rdogrprefbbornloc);
         
         rdorefbbornloc1 = (RadioButton) findViewById(R.id.rdorefbbornloc1);
         rdorefbbornloc2 = (RadioButton) findViewById(R.id.rdorefbbornloc2);
         rdorefbbornloc3 = (RadioButton) findViewById(R.id.rdorefbbornloc3);
         rdorefbbornloc4 = (RadioButton) findViewById(R.id.rdorefbbornloc4);
         rdorefbbornloc5 = (RadioButton) findViewById(R.id.rdorefbbornloc5);
         rdorefbbornloc6 = (RadioButton) findViewById(R.id.rdorefbbornloc6);
         rdogrprefbbornloc.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrprefbbornloc = new String[] {"1","2","3","4","6","9"};
             for (int i = 0; i < rdogrprefbbornloc.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrprefbbornloc.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrprefbbornloc[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                    secrefbbornOth.setVisibility(View.GONE);
                    linerefbbornOth.setVisibility(View.GONE);
                    txtrefbbornOth.setText("");
             }
             else if(rbData.equalsIgnoreCase("2"))
             {
                    secrefbbornOth.setVisibility(View.GONE);
                    linerefbbornOth.setVisibility(View.GONE);
                    txtrefbbornOth.setText("");
             }
             else if(rbData.equalsIgnoreCase("3"))
             {
                    secrefbbornOth.setVisibility(View.GONE);
                    linerefbbornOth.setVisibility(View.GONE);
                    txtrefbbornOth.setText("");
             }
             else if(rbData.equalsIgnoreCase("6"))
             {
                    secrefbbornOth.setVisibility(View.GONE);
                    linerefbbornOth.setVisibility(View.GONE);
                    txtrefbbornOth.setText("");
             }
             else if(rbData.equalsIgnoreCase("9"))
             {
                    secrefbbornOth.setVisibility(View.GONE);
                    linerefbbornOth.setVisibility(View.GONE);
                    txtrefbbornOth.setText("");
             }
             else
             {
                    secrefbbornOth.setVisibility(View.VISIBLE);
                    linerefbbornOth.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secrefbbornOth=(LinearLayout)findViewById(R.id.secrefbbornOth);
         linerefbbornOth=(View)findViewById(R.id.linerefbbornOth);
         VlblrefbbornOth=(TextView) findViewById(R.id.VlblrefbbornOth);
         txtrefbbornOth=(EditText) findViewById(R.id.txtrefbbornOth);
         secrefdelivtime=(LinearLayout)findViewById(R.id.secrefdelivtime);
         linerefdelivtime=(View)findViewById(R.id.linerefdelivtime);
         Vlblrefdelivtime=(TextView) findViewById(R.id.Vlblrefdelivtime);
         txtrefdelivtime=(EditText) findViewById(R.id.txtrefdelivtime);
         secrefdoadmkmc=(LinearLayout)findViewById(R.id.secrefdoadmkmc);
         linerefdoadmkmc=(View)findViewById(R.id.linerefdoadmkmc);
         Vlblrefdoadmkmc=(TextView) findViewById(R.id.Vlblrefdoadmkmc);
         dtprefdoadmkmc=(EditText) findViewById(R.id.dtprefdoadmkmc);
         secreftoadmkmc=(LinearLayout)findViewById(R.id.secreftoadmkmc);
         linereftoadmkmc=(View)findViewById(R.id.linereftoadmkmc);
         Vlblreftoadmkmc=(TextView) findViewById(R.id.Vlblreftoadmkmc);
         txtreftoadmkmc=(EditText) findViewById(R.id.txtreftoadmkmc);
         secrefadwgtkmc=(LinearLayout)findViewById(R.id.secrefadwgtkmc);
         linerefadwgtkmc=(View)findViewById(R.id.linerefadwgtkmc);
         Vlblrefadwgtkmc=(TextView) findViewById(R.id.Vlblrefadwgtkmc);
         txtrefadwgtkmc=(EditText) findViewById(R.id.txtrefadwgtkmc);
         secrefadwgtkmcnot=(LinearLayout)findViewById(R.id.secrefadwgtkmcnot);
         linerefadwgtkmcnot=(View)findViewById(R.id.linerefadwgtkmcnot);
         Vlblrefadwgtkmcnot = (TextView) findViewById(R.id.Vlblrefadwgtkmcnot);
         rdogrprefadwgtkmcnot = (RadioGroup) findViewById(R.id.rdogrprefadwgtkmcnot);
         
         rdorefadwgtkmcnot1 = (RadioButton) findViewById(R.id.rdorefadwgtkmcnot1);
         rdorefadwgtkmcnot2 = (RadioButton) findViewById(R.id.rdorefadwgtkmcnot2);
         seclblrefbfsup=(LinearLayout)findViewById(R.id.seclblrefbfsup);
         linelblrefbfsup=(View)findViewById(R.id.linelblrefbfsup);
         secrefbfsupA=(LinearLayout)findViewById(R.id.secrefbfsupA);
         linerefbfsupA=(View)findViewById(R.id.linerefbfsupA);
         VlblrefbfsupA=(TextView) findViewById(R.id.VlblrefbfsupA);
         chkrefbfsupA=(CheckBox) findViewById(R.id.chkrefbfsupA);
         secrefbfsupB=(LinearLayout)findViewById(R.id.secrefbfsupB);
         linerefbfsupB=(View)findViewById(R.id.linerefbfsupB);
         VlblrefbfsupB=(TextView) findViewById(R.id.VlblrefbfsupB);
         chkrefbfsupB=(CheckBox) findViewById(R.id.chkrefbfsupB);
         secrefbfsupC=(LinearLayout)findViewById(R.id.secrefbfsupC);
         linerefbfsupC=(View)findViewById(R.id.linerefbfsupC);
         VlblrefbfsupC=(TextView) findViewById(R.id.VlblrefbfsupC);
         chkrefbfsupC=(CheckBox) findViewById(R.id.chkrefbfsupC);
         secrefbfsupD=(LinearLayout)findViewById(R.id.secrefbfsupD);
         linerefbfsupD=(View)findViewById(R.id.linerefbfsupD);
         VlblrefbfsupD=(TextView) findViewById(R.id.VlblrefbfsupD);
         chkrefbfsupD=(CheckBox) findViewById(R.id.chkrefbfsupD);
         secrefbfsupE=(LinearLayout)findViewById(R.id.secrefbfsupE);
         linerefbfsupE=(View)findViewById(R.id.linerefbfsupE);
         VlblrefbfsupE=(TextView) findViewById(R.id.VlblrefbfsupE);
         chkrefbfsupE=(CheckBox) findViewById(R.id.chkrefbfsupE);
         secrefbfsupF=(LinearLayout)findViewById(R.id.secrefbfsupF);
         linerefbfsupF=(View)findViewById(R.id.linerefbfsupF);
         VlblrefbfsupF=(TextView) findViewById(R.id.VlblrefbfsupF);
         chkrefbfsupF=(CheckBox) findViewById(R.id.chkrefbfsupF);
         chkrefbfsupF.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if (!isChecked) {
                    secrefbfsupFOth.setVisibility(View.GONE);
                    linerefbfsupFOth.setVisibility(View.GONE);
                    txtrefbfsupFOth.setText("");
                 }
                 else
                 {
                    secrefbfsupFOth.setVisibility(View.VISIBLE);
                    linerefbfsupFOth.setVisibility(View.VISIBLE);
                 }
                 }
         });
         secrefbfsupFOth=(LinearLayout)findViewById(R.id.secrefbfsupFOth);
         linerefbfsupFOth=(View)findViewById(R.id.linerefbfsupFOth);
         VlblrefbfsupFOth=(TextView) findViewById(R.id.VlblrefbfsupFOth);
         txtrefbfsupFOth=(EditText) findViewById(R.id.txtrefbfsupFOth);
         secrefdisoutkmc=(LinearLayout)findViewById(R.id.secrefdisoutkmc);
         linerefdisoutkmc=(View)findViewById(R.id.linerefdisoutkmc);
         Vlblrefdisoutkmc = (TextView) findViewById(R.id.Vlblrefdisoutkmc);
         rdogrprefdisoutkmc = (RadioGroup) findViewById(R.id.rdogrprefdisoutkmc);
         
         rdorefdisoutkmc1 = (RadioButton) findViewById(R.id.rdorefdisoutkmc1);
         rdorefdisoutkmc2 = (RadioButton) findViewById(R.id.rdorefdisoutkmc2);
         rdorefdisoutkmc3 = (RadioButton) findViewById(R.id.rdorefdisoutkmc3);
         rdorefdisoutkmc4 = (RadioButton) findViewById(R.id.rdorefdisoutkmc4);
         rdorefdisoutkmc5 = (RadioButton) findViewById(R.id.rdorefdisoutkmc5);
         rdorefdisoutkmc6 = (RadioButton) findViewById(R.id.rdorefdisoutkmc6);
         rdorefdisoutkmc7 = (RadioButton) findViewById(R.id.rdorefdisoutkmc7);
         rdogrprefdisoutkmc.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrprefdisoutkmc = new String[] {"1","2","3","4","5","8","9"};
             for (int i = 0; i < rdogrprefdisoutkmc.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrprefdisoutkmc.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrprefdisoutkmc[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                    secreftransPlace.setVisibility(View.GONE);
                    linereftransPlace.setVisibility(View.GONE);
                    txtreftransPlace.setText("");
             }
             else if(rbData.equalsIgnoreCase("2"))
             {
                    secreftransPlace.setVisibility(View.GONE);
                    linereftransPlace.setVisibility(View.GONE);
                    txtreftransPlace.setText("");
             }
             else if(rbData.equalsIgnoreCase("3"))
             {
                    secreftransPlace.setVisibility(View.GONE);
                    linereftransPlace.setVisibility(View.GONE);
                    txtreftransPlace.setText("");
             }
             else if(rbData.equalsIgnoreCase("5"))
             {
                    secreftransPlace.setVisibility(View.GONE);
                    linereftransPlace.setVisibility(View.GONE);
                    txtreftransPlace.setText("");
             }
             else if(rbData.equalsIgnoreCase("8"))
             {
                    secreftransPlace.setVisibility(View.GONE);
                    linereftransPlace.setVisibility(View.GONE);
                    txtreftransPlace.setText("");
             }
             else if(rbData.equalsIgnoreCase("9"))
             {
                    secreftransPlace.setVisibility(View.GONE);
                    linereftransPlace.setVisibility(View.GONE);
                    txtreftransPlace.setText("");
             }
             else
             {
                    secreftransPlace.setVisibility(View.VISIBLE);
                    linereftransPlace.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secreftransPlace=(LinearLayout)findViewById(R.id.secreftransPlace);
         linereftransPlace=(View)findViewById(R.id.linereftransPlace);
         VlblreftransPlace=(TextView) findViewById(R.id.VlblreftransPlace);
         txtreftransPlace=(EditText) findViewById(R.id.txtreftransPlace);
         secrefdodkmc=(LinearLayout)findViewById(R.id.secrefdodkmc);
         linerefdodkmc=(View)findViewById(R.id.linerefdodkmc);
         Vlblrefdodkmc=(TextView) findViewById(R.id.Vlblrefdodkmc);
         dtprefdodkmc=(EditText) findViewById(R.id.dtprefdodkmc);
         secrefdiswgtkmc=(LinearLayout)findViewById(R.id.secrefdiswgtkmc);
         linerefdiswgtkmc=(View)findViewById(R.id.linerefdiswgtkmc);
         Vlblrefdiswgtkmc=(TextView) findViewById(R.id.Vlblrefdiswgtkmc);
         txtrefdiswgtkmc=(EditText) findViewById(R.id.txtrefdiswgtkmc);
         secregdiswgtkmcnot=(LinearLayout)findViewById(R.id.secregdiswgtkmcnot);
         lineregdiswgtkmcnot=(View)findViewById(R.id.lineregdiswgtkmcnot);
         Vlblregdiswgtkmcnot = (TextView) findViewById(R.id.Vlblregdiswgtkmcnot);
         rdogrpregdiswgtkmcnot = (RadioGroup) findViewById(R.id.rdogrpregdiswgtkmcnot);
         
         rdoregdiswgtkmcnot1 = (RadioButton) findViewById(R.id.rdoregdiswgtkmcnot1);
         rdoregdiswgtkmcnot2 = (RadioButton) findViewById(R.id.rdoregdiswgtkmcnot2);


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
         dtprefdoadmkmc.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtprefdoadmkmc.getRight() - dtprefdoadmkmc.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnrefdoadmkmc"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });
         dtprefdodkmc.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtprefdodkmc.getRight() - dtprefdodkmc.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnrefdodkmc"; showDialog(DATE_DIALOG);
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
         txtreftoadmkmc.setOnTouchListener(new View.OnTouchListener() {
         @Override
         public boolean onTouch(View v, MotionEvent event) {
             final int DRAWABLE_RIGHT = 2;
             if(event.getAction() == MotionEvent.ACTION_UP) {
                 if(event.getRawX() >= (txtreftoadmkmc.getRight() - txtreftoadmkmc.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                     VariableID = "btnreftoadmkmc"; showDialog(TIME_DIALOG);
                  return true;
                 }
             }
             return false;
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
                 if(rdorefbwgtnot1.isChecked() | rdorefbwgtnot2.isChecked()) txtrefbwgt.setText("");
             }
         });


         txtrefgakmc.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {
             }

             public void beforeTextChanged(CharSequence s, int start, int count,int after) {
             }
             public void afterTextChanged(Editable s) {
                 if(txtrefgakmc.getText().toString().length()>0) rdogrprefgakmcnot.clearCheck();
             }
         });
         rdogrprefgakmcnot.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(rdorefgakmcnot1.isChecked() | rdorefgakmcnot2.isChecked()) txtrefgakmc.setText("");
             }
         });


         txtrefadwgtkmc.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {
             }

             public void beforeTextChanged(CharSequence s, int start, int count,int after) {
             }
             public void afterTextChanged(Editable s) {
                 if(txtrefadwgtkmc.getText().toString().length()>0) rdogrprefadwgtkmcnot.clearCheck();
             }
         });
         rdogrprefadwgtkmcnot.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(rdorefadwgtkmcnot1.isChecked()|rdorefadwgtkmcnot2.isChecked()) txtrefadwgtkmc.setText("");
             }
         });


         txtrefdiswgtkmc.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {
             }

             public void beforeTextChanged(CharSequence s, int start, int count,int after) {
             }
             public void afterTextChanged(Editable s) {
                 if(txtrefdiswgtkmc.getText().toString().length()>0) rdogrpregdiswgtkmcnot.clearCheck();
             }
         });
         rdogrpregdiswgtkmcnot.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(rdoregdiswgtkmcnot1.isChecked() | rdoregdiswgtkmcnot2.isChecked()) txtrefdiswgtkmc.setText("");
             }
         });

         dtprefdelivdate.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {
             }

             public void beforeTextChanged(CharSequence s, int start, int count,int after) {
             }
             public void afterTextChanged(Editable s) {
                 if(dtprefdelivdate.getText().toString().length()>0) rdogrprefdelivdatenot.clearCheck();
             }
         });
         rdogrprefdelivdatenot.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(rdorefdelivdatenot1.isChecked() | rdorefdelivdatenot2.isChecked()) dtprefdelivdate.setText("");
             }
         });


         //---
         txtrefdelivtime.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {
             }

             public void beforeTextChanged(CharSequence s, int start, int count,int after) {
             }
             public void afterTextChanged(Editable s) {
                 if(txtrefdelivtime.getText().toString().length()>0) rdogrprefdelivtimenot.clearCheck();
             }
         });
         rdogrprefdelivtimenot.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(rdorefdelivtimenot1.isChecked() | rdorefdelivtimenot2.isChecked()) txtrefdelivtime.setText("");
             }
         });
        //----
         dtprefdoadmkmc.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {
             }

             public void beforeTextChanged(CharSequence s, int start, int count,int after) {
             }
             public void afterTextChanged(Editable s) {
                 if(dtprefdoadmkmc.getText().toString().length()>0) rdogrprefdoadmkmcnot.clearCheck();
             }
         });
         rdogrprefdoadmkmcnot.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(rdorefdoadmkmcnot1.isChecked() | rdorefdoadmkmcnot2.isChecked()) dtprefdoadmkmc.setText("");
             }
         });

         //----
         txtreftoadmkmc.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {
             }

             public void beforeTextChanged(CharSequence s, int start, int count,int after) {
             }
             public void afterTextChanged(Editable s) {
                 if(txtreftoadmkmc.getText().toString().length()>0) rdogrpreftoadmkmcnot.clearCheck();
             }
         });
         rdogrpreftoadmkmcnot.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(rdoreftoadmkmcnot1.isChecked() | rdoreftoadmkmcnot2.isChecked()) txtreftoadmkmc.setText("");
             }
         });

         //----
         dtprefdodkmc.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {
             }
             public void beforeTextChanged(CharSequence s, int start, int count,int after) {
             }
             public void afterTextChanged(Editable s) {
                 if(dtprefdodkmc.getText().toString().length()>0) rdogrprefdodkmcnot.clearCheck();
             }
         });
         rdogrprefdodkmcnot.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(rdorefdodkmcnot1.isChecked() | rdorefdodkmcnot2.isChecked()) dtprefdodkmc.setText("");
             }
         });

         rdogrpstatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId)
             {
                 if(rdostatus1.isChecked()){
                     secreason.setVisibility(View.GONE);
                     rdogrpreason.clearCheck();
                     secreasmention.setVisibility(View.GONE);
                     txtreasmention.setText("");
                 }else{
                     secreason.setVisibility(View.VISIBLE);
                     secreasmention.setVisibility(View.VISIBLE);
                 }
             }

         });


         //Hide all skip variables
         secreason.setVisibility(View.GONE);
         secreasmention.setVisibility(View.GONE);

         secrefabskmcOth.setVisibility(View.GONE);
         linerefabskmcOth.setVisibility(View.GONE);
         secrefabskmcOth.setVisibility(View.GONE);
         linerefabskmcOth.setVisibility(View.GONE);
         //sec.setVisibility(View.GONE);
         //line.setVisibility(View.GONE);
         secrefbbornOth.setVisibility(View.GONE);
         linerefbbornOth.setVisibility(View.GONE);
         secrefbbornOth.setVisibility(View.GONE);
         linerefbbornOth.setVisibility(View.GONE);
         secrefbbornOth.setVisibility(View.GONE);
         linerefbbornOth.setVisibility(View.GONE);
         secrefbbornOth.setVisibility(View.GONE);
         linerefbbornOth.setVisibility(View.GONE);
         secrefbbornOth.setVisibility(View.GONE);
         linerefbbornOth.setVisibility(View.GONE);
         secrefbfsupFOth.setVisibility(View.GONE);
         linerefbfsupFOth.setVisibility(View.GONE);
         secreftransPlace.setVisibility(View.GONE);
         linereftransPlace.setVisibility(View.GONE);
         secreftransPlace.setVisibility(View.GONE);
         linereftransPlace.setVisibility(View.GONE);
         secreftransPlace.setVisibility(View.GONE);
         linereftransPlace.setVisibility(View.GONE);
         secreftransPlace.setVisibility(View.GONE);
         linereftransPlace.setVisibility(View.GONE);
         secreftransPlace.setVisibility(View.GONE);
         linereftransPlace.setVisibility(View.GONE);
         secreftransPlace.setVisibility(View.GONE);
         linereftransPlace.setVisibility(View.GONE);


         DataSearch(COUNTRYCODE,FACICODE,DATAID);
        Button cmdSave = (Button) findViewById(R.id.cmdSave);
        cmdSave.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) { 
            DataSave();
        }});
     }
     catch(Exception  e)
     {
         Connection.MessageBox(KMC_DataExt.this, e.getMessage());
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
             Connection.MessageBox(KMC_DataExt.this, "Required field: CountryCode.");
             txtCountryCode.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtCountryCode.getText().toString().length()==0 ? "1" : txtCountryCode.getText().toString()) < 1 || Integer.valueOf(txtCountryCode.getText().toString().length()==0 ? "3" : txtCountryCode.getText().toString()) > 3)
           {
             Connection.MessageBox(KMC_DataExt.this, "Value should be between 1 and 3(CountryCode).");
             txtCountryCode.requestFocus(); 
             return;	
           }
         else if(txtFaciCode.getText().toString().length()==0 & secFaciCode.isShown())
           {
             Connection.MessageBox(KMC_DataExt.this, "Required field: Facility.");
             txtFaciCode.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtFaciCode.getText().toString().length()==0 ? "1" : txtFaciCode.getText().toString()) < 1 || Integer.valueOf(txtFaciCode.getText().toString().length()==0 ? "9" : txtFaciCode.getText().toString()) > 9)
           {
             Connection.MessageBox(KMC_DataExt.this, "Value should be between 1 and 9(Facility).");
             txtFaciCode.requestFocus(); 
             return;	
           }
         else if(txtDataID.getText().toString().length()==0 & secDataID.isShown())
           {
             Connection.MessageBox(KMC_DataExt.this, "Required field: Data ID.");
             txtDataID.requestFocus(); 
             return;	
           }
         DV = Global.DateValidate(dtprefdoe.getText().toString());
         if(DV.length()!=0 & secrefdoe.isShown())
           {
             Connection.MessageBox(KMC_DataExt.this, DV);
             dtprefdoe.requestFocus(); 
             return;	
           }
         
         else if(!rdorefabskmc1.isChecked() & !rdorefabskmc2.isChecked() & !rdorefabskmc3.isChecked() & secrefabskmc.isShown())
           {
              Connection.MessageBox(KMC_DataExt.this, "Select anyone options from (Source of Record).");
              rdorefabskmc1.requestFocus();
              return;
           }
         else if(txtrefabskmcOth.getText().toString().length()==0 & secrefabskmcOth.isShown())
           {
             Connection.MessageBox(KMC_DataExt.this, "Required field: Other Specify.");
             txtrefabskmcOth.requestFocus(); 
             return;	
           }
         else if(txtrefmatname.getText().toString().length()==0 & secrefmatname.isShown())
           {
             Connection.MessageBox(KMC_DataExt.this, "Required field: Mother’s name.");
             txtrefmatname.requestFocus(); 
             return;	
           }
         else if(txtrefmatage.getText().toString().length()==0 & secrefmatage.isShown())
           {
             Connection.MessageBox(KMC_DataExt.this, "Required field: Mother’s age (years).");
             txtrefmatage.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtrefmatage.getText().toString().length()==0 ? "12" : txtrefmatage.getText().toString()) < 12 || Integer.valueOf(txtrefmatage.getText().toString().length()==0 ? "99" : txtrefmatage.getText().toString()) > 99)
           {
             Connection.MessageBox(KMC_DataExt.this, "Value should be between 12 and 99(Mother’s age (years)).");
             txtrefmatage.requestFocus(); 
             return;	
           }
         else if(txtrefmatid.getText().toString().length()==0 & secrefmatid.isShown())
           {
             Connection.MessageBox(KMC_DataExt.this, "Required field: Mother’s ID.");
             txtrefmatid.requestFocus(); 
             return;	
           }

         /*else if(txtrefbname.getText().toString().length()==0 & secrefbname.isShown())
           {
             Connection.MessageBox(KMC_DataExt.this, "Required field: Child’s name, if available.");
             txtrefbname.requestFocus(); 
             return;	
           }
         else if(txtrefbid.getText().toString().length()==0 & secrefbid.isShown())
           {
             Connection.MessageBox(KMC_DataExt.this, "Required field: Child’s ID.");
             txtrefbid.requestFocus(); 
             return;	
           }*/
         
         else if(!rdorefbsex1.isChecked() & !rdorefbsex2.isChecked() & !rdorefbsex3.isChecked() & !rdorefbsex4.isChecked() & !rdorefbsex5.isChecked() & secrefbsex.isShown())
           {
              Connection.MessageBox(KMC_DataExt.this, "Select anyone options from (Sex of Child).");
              rdorefbsex1.requestFocus();
              return;
           }
         DV = Global.DateValidate(dtprefdelivdate.getText().toString());
         if(!rdorefdelivdatenot1.isChecked() & !rdorefdelivdatenot2.isChecked() & DV.length()!=0 & secrefdelivdate.isShown())
           {
             Connection.MessageBox(KMC_DataExt.this, "This is not a valid date of delivery.");
             dtprefdelivdate.requestFocus(); 
             return;	
           }
         else if(!rdorefbwgtnot1.isChecked() & !rdorefbwgtnot2.isChecked() & txtrefbwgt.getText().toString().length()==0 & secrefbwgt.isShown())
           {
             Connection.MessageBox(KMC_DataExt.this, "Required field: Birth weight (grams).");
             txtrefbwgt.requestFocus(); 
             return;	
           }
         else if(!rdorefbwgtnot1.isChecked() & !rdorefbwgtnot2.isChecked() & (Integer.valueOf(txtrefbwgt.getText().toString().length()==0 ? "400" : txtrefbwgt.getText().toString()) < 400 || Integer.valueOf(txtrefbwgt.getText().toString().length()==0 ? "9999" : txtrefbwgt.getText().toString()) > 9999))
           {
             Connection.MessageBox(KMC_DataExt.this, "Value should be between 400 and 9999(Birth weight (grams)).");
             txtrefbwgt.requestFocus(); 
             return;	
           }
         
         /*else if(!rdorefbwgtnot1.isChecked() & !rdorefbwgtnot2.isChecked() & secrefbwgtnot.isShown())
           {
              Connection.MessageBox(KMC_DataExt.this, "Select anyone options from ().");
              rdorefbwgtnot1.requestFocus();
              return;
           }*/
         else if(!rdorefgakmcnot1.isChecked() & !rdorefgakmcnot2.isChecked() & txtrefgakmc.getText().toString().length()==0 & secrefgakmc.isShown())
           {
             Connection.MessageBox(KMC_DataExt.this, "Required field: Gestational age  (completed weeks + days).");
             txtrefgakmc.requestFocus(); 
             return;	
           }
         else if(!rdorefgakmcnot1.isChecked() & !rdorefgakmcnot2.isChecked() & (Integer.valueOf(txtrefgakmc.getText().toString().length()==0 ? "1" : txtrefgakmc.getText().toString()) < 1 || Integer.valueOf(txtrefgakmc.getText().toString().length()==0 ? "99" : txtrefgakmc.getText().toString()) > 99))
           {
             Connection.MessageBox(KMC_DataExt.this, "Value should be between 1 and 99(Gestational age  (completed weeks + days)).");
             txtrefgakmc.requestFocus(); 
             return;	
           }
         
         /*else if(!rdorefgakmcnot1.isChecked() & !rdorefgakmcnot2.isChecked() & secrefgakmcnot.isShown())
           {
              Connection.MessageBox(KMC_DataExt.this, "Select anyone options from ().");
              rdorefgakmcnot1.requestFocus();
              return;
           }*/
         
         else if(!rdorefbbornloc1.isChecked() & !rdorefbbornloc2.isChecked() & !rdorefbbornloc3.isChecked() & !rdorefbbornloc4.isChecked() & !rdorefbbornloc5.isChecked() & !rdorefbbornloc6.isChecked() & secrefbbornloc.isShown())
           {
              Connection.MessageBox(KMC_DataExt.this, "Select anyone options from (Where the child was born?).");
              rdorefbbornloc1.requestFocus();
              return;
           }
         else if(txtrefbbornOth.getText().toString().length()==0 & secrefbbornOth.isShown())
           {
             Connection.MessageBox(KMC_DataExt.this, "Required field: Referred from.");
             txtrefbbornOth.requestFocus(); 
             return;	
           }
         else if(!rdorefdelivtimenot1.isChecked() & !rdorefdelivtimenot2.isChecked() & txtrefdelivtime.getText().length()==0 & secrefdelivtime.isShown())
           {
             Connection.MessageBox(KMC_DataExt.this, "Required field: Time of Delivery.");
             txtrefdelivtime.requestFocus(); 
             return;	
           }
         DV = Global.DateValidate(dtprefdoadmkmc.getText().toString());
         if(!rdorefdoadmkmcnot1.isChecked() & !rdorefdoadmkmcnot2.isChecked() & DV.length()!=0 & secrefdoadmkmc.isShown())
           {
             Connection.MessageBox(KMC_DataExt.this, "11. This is not a valid Date of Admission to KMC");
             dtprefdoadmkmc.requestFocus(); 
             return;	
           }
         else if(!rdoreftoadmkmcnot1.isChecked() & !rdoreftoadmkmcnot2.isChecked() & txtreftoadmkmc.getText().length()==0 & secreftoadmkmc.isShown())
           {
             Connection.MessageBox(KMC_DataExt.this, "Required field: Time of Admission to KMC.");
             txtreftoadmkmc.requestFocus(); 
             return;	
           }
         else if(!rdorefadwgtkmcnot1.isChecked() & !rdorefadwgtkmcnot2.isChecked() & txtrefadwgtkmc.getText().toString().length()==0 & secrefadwgtkmc.isShown())
           {
             Connection.MessageBox(KMC_DataExt.this, "Required field: Weight at admission to KMC (grams).");
             txtrefadwgtkmc.requestFocus(); 
             return;	
           }
         else if(!rdorefadwgtkmcnot1.isChecked() & !rdorefadwgtkmcnot2.isChecked() & (Integer.valueOf(txtrefadwgtkmc.getText().toString().length()==0 ? "400" : txtrefadwgtkmc.getText().toString()) < 400 || Integer.valueOf(txtrefadwgtkmc.getText().toString().length()==0 ? "9999" : txtrefadwgtkmc.getText().toString()) > 9999))
           {
             Connection.MessageBox(KMC_DataExt.this, "Value should be between 400 and 9999(Weight at admission to KMC (grams)).");
             txtrefadwgtkmc.requestFocus(); 
             return;	
           }
         
         /*else if(!rdorefadwgtkmcnot1.isChecked() & !rdorefadwgtkmcnot2.isChecked() & secrefadwgtkmcnot.isShown())
           {
              Connection.MessageBox(KMC_DataExt.this, "Select anyone options from ().");
              rdorefadwgtkmcnot1.requestFocus();
              return;
           }*/
         else if(txtrefbfsupFOth.getText().toString().length()==0 & secrefbfsupFOth.isShown())
           {
             Connection.MessageBox(KMC_DataExt.this, "Required field:     Other Specify.");
             txtrefbfsupFOth.requestFocus(); 
             return;	
           }
         
         else if(!rdorefdisoutkmc1.isChecked() & !rdorefdisoutkmc2.isChecked() & !rdorefdisoutkmc3.isChecked() & !rdorefdisoutkmc4.isChecked() & !rdorefdisoutkmc5.isChecked() & !rdorefdisoutkmc6.isChecked() & !rdorefdisoutkmc7.isChecked() & secrefdisoutkmc.isShown())
           {
              Connection.MessageBox(KMC_DataExt.this, "Select anyone options from (Outcome at discharge).");
              rdorefdisoutkmc1.requestFocus();
              return;
           }
         else if(txtreftransPlace.getText().toString().length()==0 & secreftransPlace.isShown())
           {
             Connection.MessageBox(KMC_DataExt.this, "Required field: Transferred alive where.");
             txtreftransPlace.requestFocus(); 
             return;	
           }
         DV = Global.DateValidate(dtprefdodkmc.getText().toString());
         if(!rdorefdodkmcnot1.isChecked() & !rdorefdodkmcnot2.isChecked() & DV.length()!=0 & secrefdodkmc.isShown())
           {
             Connection.MessageBox(KMC_DataExt.this, "16.This is not a valid Date of discharge from KMC.");
             dtprefdodkmc.requestFocus(); 
             return;	
           }
         else if(!rdoregdiswgtkmcnot1.isChecked() & !rdoregdiswgtkmcnot2.isChecked() & txtrefdiswgtkmc.getText().toString().length()==0 & secrefdiswgtkmc.isShown())
           {
             Connection.MessageBox(KMC_DataExt.this, "Required field: If alive, weight at discharge/transfer from KMC (grams).");
             txtrefdiswgtkmc.requestFocus(); 
             return;	
           }
         else if(!rdoregdiswgtkmcnot1.isChecked() & !rdoregdiswgtkmcnot2.isChecked() & (Integer.valueOf(txtrefdiswgtkmc.getText().toString().length()==0 ? "400" : txtrefdiswgtkmc.getText().toString()) < 400 || Integer.valueOf(txtrefdiswgtkmc.getText().toString().length()==0 ? "9999" : txtrefdiswgtkmc.getText().toString()) > 9999))
           {
             Connection.MessageBox(KMC_DataExt.this, "Value should be between 400 and 9999(If alive, weight at discharge/transfer from KMC (grams)).");
             txtrefdiswgtkmc.requestFocus(); 
             return;	
           }

         else if(!rdostatus1.isChecked() & !rdostatus2.isChecked() & !rdostatus3.isChecked() & secstatus.isShown())
         {
             Connection.MessageBox(KMC_DataExt.this, "Required field: 18. What is the final status of the Recall Survey for this patient");
             rdostatus1.requestFocus();
             return;
         }
         else if(!rdoreason1.isChecked() & !rdoreason2.isChecked() & !rdoreason3.isChecked() & !rdoreason4.isChecked() & secreason.isShown())
         {
             Connection.MessageBox(KMC_DataExt.this, "Required field: 19. Why partially incomplete or totally incomplete?");
             rdoreason1.requestFocus();
             return;
         }


         /*else if(!rdoregdiswgtkmcnot1.isChecked() & !rdoregdiswgtkmcnot2.isChecked() & secregdiswgtkmcnot.isShown())
           {
              Connection.MessageBox(KMC_DataExt.this, "Select anyone options from ().");
              rdoregdiswgtkmcnot1.requestFocus();
              return;
           }*/
 
         String SQL = "";
         RadioButton rb;

         KMC_DataExt_DataModel objSave = new KMC_DataExt_DataModel();
         objSave.setCountryCode(txtCountryCode.getText().toString());
         objSave.setFaciCode(txtFaciCode.getText().toString());
         objSave.setDataID(txtDataID.getText().toString());
         objSave.setrefdoe(dtprefdoe.getText().toString().length() > 0 ? Global.DateConvertYMD(dtprefdoe.getText().toString()) : dtprefdoe.getText().toString());
         String[] d_rdogrprefabskmc = new String[] {"1","2","3"};
         objSave.setrefabskmc("");
         for (int i = 0; i < rdogrprefabskmc.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefabskmc.getChildAt(i);
             if (rb.isChecked()) objSave.setrefabskmc(d_rdogrprefabskmc[i]);
         }

         objSave.setrefabskmcOth(txtrefabskmcOth.getText().toString());
         objSave.setrefmatname(txtrefmatname.getText().toString());
         objSave.setrefmatage(txtrefmatage.getText().toString());
         objSave.setrefmatid(txtrefmatid.getText().toString());
         objSave.setrefbname(txtrefbname.getText().toString());
         objSave.setrefbid(txtrefbid.getText().toString());
         String[] d_rdogrprefbsex = new String[] {"1","2","3","8","9"};
         objSave.setrefbsex("");
         for (int i = 0; i < rdogrprefbsex.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefbsex.getChildAt(i);
             if (rb.isChecked()) objSave.setrefbsex(d_rdogrprefbsex[i]);
         }

         objSave.setrefdelivdate(dtprefdelivdate.getText().toString().length() > 0 ? Global.DateConvertYMD(dtprefdelivdate.getText().toString()) : dtprefdelivdate.getText().toString());
         if(rdorefdelivdatenot1.isChecked()) objSave.setrefdelivdatenot("1");
         else if(rdorefdelivdatenot2.isChecked()) objSave.setrefdelivdatenot("2");
         else objSave.setrefdelivdatenot("");

         objSave.setrefbwgt(txtrefbwgt.getText().toString());
         String[] d_rdogrprefbwgtnot = new String[] {"1","2"};
         objSave.setrefbwgtnot("");
         for (int i = 0; i < rdogrprefbwgtnot.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefbwgtnot.getChildAt(i);
             if (rb.isChecked()) objSave.setrefbwgtnot(d_rdogrprefbwgtnot[i]);
         }

         objSave.setrefgakmc(txtrefgakmc.getText().toString());
         String[] d_rdogrprefgakmcnot = new String[] {"1","2"};
         objSave.setrefgakmcnot("");
         for (int i = 0; i < rdogrprefgakmcnot.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefgakmcnot.getChildAt(i);
             if (rb.isChecked()) objSave.setrefgakmcnot(d_rdogrprefgakmcnot[i]);
         }

         String[] d_rdogrprefbbornloc = new String[] {"1","2","3","4","6","9"};
         objSave.setrefbbornloc("");
         for (int i = 0; i < rdogrprefbbornloc.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefbbornloc.getChildAt(i);
             if (rb.isChecked()) objSave.setrefbbornloc(d_rdogrprefbbornloc[i]);
         }

         objSave.setrefbbornOth(txtrefbbornOth.getText().toString());
         objSave.setrefdelivtime(txtrefdelivtime.getText().toString());
         if(rdorefdelivtimenot1.isChecked()) objSave.setrefdelivtimenot("1");
         else if(rdorefdelivtimenot2.isChecked()) objSave.setrefdelivtimenot("2");
         else objSave.setrefdelivtimenot("");

         objSave.setrefdoadmkmc(dtprefdoadmkmc.getText().toString().length() > 0 ? Global.DateConvertYMD(dtprefdoadmkmc.getText().toString()) : dtprefdoadmkmc.getText().toString());
         if(rdorefdoadmkmcnot1.isChecked()) objSave.setrefdoadmkmcnot("1");
         else if(rdorefdoadmkmcnot2.isChecked()) objSave.setrefdoadmkmcnot("2");
         else objSave.setrefdoadmkmcnot("");

         objSave.setreftoadmkmc(txtreftoadmkmc.getText().toString());

         if(rdoreftoadmkmcnot1.isChecked()) objSave.setreftoadmkmcnot("1");
         else if(rdoreftoadmkmcnot2.isChecked()) objSave.setreftoadmkmcnot("2");
         else objSave.setreftoadmkmcnot("");

         objSave.setrefadwgtkmc(txtrefadwgtkmc.getText().toString());
         String[] d_rdogrprefadwgtkmcnot = new String[] {"1","2"};
         objSave.setrefadwgtkmcnot("");
         for (int i = 0; i < rdogrprefadwgtkmcnot.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefadwgtkmcnot.getChildAt(i);
             if (rb.isChecked()) objSave.setrefadwgtkmcnot(d_rdogrprefadwgtkmcnot[i]);
         }

         objSave.setrefbfsupA((chkrefbfsupA.isChecked()?"1":(secrefbfsupA.isShown()?"2":"")));
         objSave.setrefbfsupB((chkrefbfsupB.isChecked()?"1":(secrefbfsupB.isShown()?"2":"")));
         objSave.setrefbfsupC((chkrefbfsupC.isChecked()?"1":(secrefbfsupC.isShown()?"2":"")));
         objSave.setrefbfsupD((chkrefbfsupD.isChecked()?"1":(secrefbfsupD.isShown()?"2":"")));
         objSave.setrefbfsupE((chkrefbfsupE.isChecked()?"1":(secrefbfsupE.isShown()?"2":"")));
         objSave.setrefbfsupF((chkrefbfsupF.isChecked()?"1":(secrefbfsupF.isShown()?"2":"")));
         objSave.setrefbfsupFOth(txtrefbfsupFOth.getText().toString());
         String[] d_rdogrprefdisoutkmc = new String[] {"1","2","3","4","5","8","9"};
         objSave.setrefdisoutkmc("");
         for (int i = 0; i < rdogrprefdisoutkmc.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrprefdisoutkmc.getChildAt(i);
             if (rb.isChecked()) objSave.setrefdisoutkmc(d_rdogrprefdisoutkmc[i]);
         }

         objSave.setreftransPlace(txtreftransPlace.getText().toString());
         objSave.setrefdodkmc(dtprefdodkmc.getText().toString().length() > 0 ? Global.DateConvertYMD(dtprefdodkmc.getText().toString()) : dtprefdodkmc.getText().toString());
         if(rdorefdodkmcnot1.isChecked()) objSave.setrefdodkmcnot("1");
         else if(rdorefdodkmcnot2.isChecked()) objSave.setrefdodkmcnot("2");
         else objSave.setrefdodkmcnot("");

         objSave.setrefdiswgtkmc(txtrefdiswgtkmc.getText().toString());
         String[] d_rdogrpregdiswgtkmcnot = new String[] {"1","2"};
         objSave.setregdiswgtkmcnot("");
         for (int i = 0; i < rdogrpregdiswgtkmcnot.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpregdiswgtkmcnot.getChildAt(i);
             if (rb.isChecked()) objSave.setregdiswgtkmcnot(d_rdogrpregdiswgtkmcnot[i]);
         }

         //Status
         String[] d_rdogrpstatus = new String[] {"1","2","3"};
         objSave.setStatus("");
         for (int i = 0; i < rdogrpstatus.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpstatus.getChildAt(i);
             if (rb.isChecked()) objSave.setStatus(d_rdogrpstatus[i]);
         }

         String[] d_rdogrpreason = new String[] {"1","2","3","4"};
         objSave.setReason("");
         for (int i = 0; i < rdogrpreason.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpreason.getChildAt(i);
             if (rb.isChecked()) objSave.setReason(d_rdogrpreason[i]);
         }
         objSave.setReasmention(txtreasmention.getText().toString());

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
             C.Save("Update Registration set StatusDE='1',Upload='2',modifyDate='"+ Global.DateTimeNowYMDHMS() +"' where CountryCode='" + COUNTRYCODE + "' and FaciCode='" + FACICODE + "' and DataId='" + DATAID + "'");

             Intent returnIntent = new Intent();
             returnIntent.putExtra("res", "");
             setResult(Activity.RESULT_OK, returnIntent);

             Connection.MessageBox(KMC_DataExt.this, "Saved Successfully");
         }
         else{
             Connection.MessageBox(KMC_DataExt.this, status);
             return;
         }
     }
     catch(Exception  e)
     {
         Connection.MessageBox(KMC_DataExt.this, e.getMessage());
         return;
     }
 }

 private void DataSearch(String CountryCode, String FaciCode, String DataID)
     {
       try
        {
     
           RadioButton rb;
           KMC_DataExt_DataModel d = new KMC_DataExt_DataModel();
           String SQL = "Select * from "+ TableName +"  Where CountryCode='"+ CountryCode +"' and FaciCode='"+ FaciCode +"' and DataID='"+ DataID +"'";
           List<KMC_DataExt_DataModel> data = d.SelectAll(this, SQL);
           for(KMC_DataExt_DataModel item : data){
             txtCountryCode.setText(item.getCountryCode());
             txtFaciCode.setText(item.getFaciCode());
             txtDataID.setText(item.getDataID());
             dtprefdoe.setText(item.getrefdoe().toString().length()==0 ? "" : Global.DateConvertDMY(item.getrefdoe()));
             String[] d_rdogrprefabskmc = new String[] {"1","2","3"};
             for (int i = 0; i < d_rdogrprefabskmc.length; i++)
             {
                 if (item.getrefabskmc().equals(String.valueOf(d_rdogrprefabskmc[i])))
                 {
                     rb = (RadioButton)rdogrprefabskmc.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtrefabskmcOth.setText(item.getrefabskmcOth());
             txtrefmatname.setText(item.getrefmatname());
             txtrefmatage.setText(item.getrefmatage());
             txtrefmatid.setText(item.getrefmatid());
             txtrefbname.setText(item.getrefbname());
             txtrefbid.setText(item.getrefbid());
             String[] d_rdogrprefbsex = new String[] {"1","2","3","8","9"};
             for (int i = 0; i < d_rdogrprefbsex.length; i++)
             {
                 if (item.getrefbsex().equals(String.valueOf(d_rdogrprefbsex[i])))
                 {
                     rb = (RadioButton)rdogrprefbsex.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             dtprefdelivdate.setText(item.getrefdelivdate().toString().length()==0 ? "" : Global.DateConvertDMY(item.getrefdelivdate()));
             if(item.getrefdelivdatenot().equals("1")) rdorefdelivdatenot1.setChecked(true);
               else if(item.getrefdelivdatenot().equals("2")) rdorefdelivdatenot2.setChecked(true);

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
             txtrefgakmc.setText(item.getrefgakmc());
             String[] d_rdogrprefgakmcnot = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrprefgakmcnot.length; i++)
             {
                 if (item.getrefgakmcnot().equals(String.valueOf(d_rdogrprefgakmcnot[i])))
                 {
                     rb = (RadioButton)rdogrprefgakmcnot.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrprefbbornloc = new String[] {"1","2","3","4","6","9"};
             for (int i = 0; i < d_rdogrprefbbornloc.length; i++)
             {
                 if (item.getrefbbornloc().equals(String.valueOf(d_rdogrprefbbornloc[i])))
                 {
                     rb = (RadioButton)rdogrprefbbornloc.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtrefbbornOth.setText(item.getrefbbornOth());
             txtrefdelivtime.setText(item.getrefdelivtime());
               if(item.getrefdelivtimenot().equals("1")) rdorefdelivtimenot1.setChecked(true);
               else if(item.getrefdelivtimenot().equals("2")) rdorefdelivtimenot2.setChecked(true);

             dtprefdoadmkmc.setText(item.getrefdoadmkmc().toString().length()==0 ? "" : Global.DateConvertDMY(item.getrefdoadmkmc()));
             if(item.getrefdoadmkmcnot().equals("1")) rdorefdoadmkmcnot1.setChecked(true);
               else if(item.getrefdoadmkmcnot().equals("2")) rdorefdoadmkmcnot2.setChecked(true);

             txtreftoadmkmc.setText(item.getreftoadmkmc());
             if(item.getreftoadmkmcnot().equals("1")) rdoreftoadmkmcnot1.setChecked(true);
             else if(item.getreftoadmkmcnot().equals("2")) rdoreftoadmkmcnot2.setChecked(true);

             txtrefadwgtkmc.setText(item.getrefadwgtkmc());
             String[] d_rdogrprefadwgtkmcnot = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrprefadwgtkmcnot.length; i++)
             {
                 if (item.getrefadwgtkmcnot().equals(String.valueOf(d_rdogrprefadwgtkmcnot[i])))
                 {
                     rb = (RadioButton)rdogrprefadwgtkmcnot.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             if(item.getrefbfsupA().equals("1"))
             {
                chkrefbfsupA.setChecked(true);
             }
             else if(item.getrefbfsupA().equals("2"))
             {
                chkrefbfsupA.setChecked(false);
             }
             if(item.getrefbfsupB().equals("1"))
             {
                chkrefbfsupB.setChecked(true);
             }
             else if(item.getrefbfsupB().equals("2"))
             {
                chkrefbfsupB.setChecked(false);
             }
             if(item.getrefbfsupC().equals("1"))
             {
                chkrefbfsupC.setChecked(true);
             }
             else if(item.getrefbfsupC().equals("2"))
             {
                chkrefbfsupC.setChecked(false);
             }
             if(item.getrefbfsupD().equals("1"))
             {
                chkrefbfsupD.setChecked(true);
             }
             else if(item.getrefbfsupD().equals("2"))
             {
                chkrefbfsupD.setChecked(false);
             }
             if(item.getrefbfsupE().equals("1"))
             {
                chkrefbfsupE.setChecked(true);
             }
             else if(item.getrefbfsupE().equals("2"))
             {
                chkrefbfsupE.setChecked(false);
             }
             if(item.getrefbfsupF().equals("1"))
             {
                chkrefbfsupF.setChecked(true);
             }
             else if(item.getrefbfsupF().equals("2"))
             {
                chkrefbfsupF.setChecked(false);
             }
             txtrefbfsupFOth.setText(item.getrefbfsupFOth());
             String[] d_rdogrprefdisoutkmc = new String[] {"1","2","3","4","5","8","9"};
             for (int i = 0; i < d_rdogrprefdisoutkmc.length; i++)
             {
                 if (item.getrefdisoutkmc().equals(String.valueOf(d_rdogrprefdisoutkmc[i])))
                 {
                     rb = (RadioButton)rdogrprefdisoutkmc.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtreftransPlace.setText(item.getreftransPlace());
             dtprefdodkmc.setText(item.getrefdodkmc().toString().length()==0 ? "" : Global.DateConvertDMY(item.getrefdodkmc()));
             if(item.getrefdodkmcnot().equals("1")) rdorefdodkmcnot1.setChecked(true);
               else if(item.getrefdodkmcnot().equals("2")) rdorefdodkmcnot2.setChecked(true);

               txtrefdiswgtkmc.setText(item.getrefdiswgtkmc());
             String[] d_rdogrpregdiswgtkmcnot = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpregdiswgtkmcnot.length; i++)
             {
                 if (item.getregdiswgtkmcnot().equals(String.valueOf(d_rdogrpregdiswgtkmcnot[i])))
                 {
                     rb = (RadioButton)rdogrpregdiswgtkmcnot.getChildAt(i);
                     rb.setChecked(true);
                 }
             }

               //Status
               String[] d_rdogrpstatus = new String[] {"1","2","3"};
               for (int i = 0; i < d_rdogrpstatus.length; i++)
               {
                   if (item.getStatus().equals(String.valueOf(d_rdogrpstatus[i])))
                   {
                       rb = (RadioButton)rdogrpstatus.getChildAt(i);
                       rb.setChecked(true);
                   }
               }

               String[] d_rdogrpreason = new String[] {"1","2","3","4"};
               for (int i = 0; i < d_rdogrpreason.length; i++)
               {
                   if (item.getReason().equals(String.valueOf(d_rdogrpreason[i])))
                   {
                       rb = (RadioButton)rdogrpreason.getChildAt(i);
                       rb.setChecked(true);
                   }
               }
               txtreasmention.setText(item.getReasmention());

           }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(KMC_DataExt.this, e.getMessage());
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
             else if (VariableID.equals("btnrefdoadmkmc"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtprefdoadmkmc);
              }
             else if (VariableID.equals("btnrefdodkmc"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtprefdodkmc);
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
             else if (VariableID.equals("btnreftoadmkmc"))
              {
                  tpTime = (EditText)findViewById(R.id.txtreftoadmkmc);
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