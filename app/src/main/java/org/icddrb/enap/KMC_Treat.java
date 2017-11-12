
 package org.icddrb.enap;


 //Android Manifest Code
 //<activity android:name=".KMC_Treat" android:label="KMC_Treat" />
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

 public class KMC_Treat extends Activity {
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
         LinearLayout seclbl1;
         View linelbl1;
         LinearLayout secsupcare;
         View linesupcare;
         TextView Vlblsupcare;
         RadioGroup rdogrpsupcare;
         
         RadioButton rdosupcare1;
         RadioButton rdosupcare2;
         LinearLayout secbanti;
         View linebanti;
         TextView Vlblbanti;
         RadioGroup rdogrpbanti;
         
         RadioButton rdobanti1;
         RadioButton rdobanti2;
         LinearLayout secanti1;
         View lineanti1;
         TextView Vlblanti1;
         EditText txtanti1;
         LinearLayout secanti2;
         View lineanti2;
         TextView Vlblanti2;
         EditText txtanti2;
         LinearLayout secanti3;
         View lineanti3;
         TextView Vlblanti3;
         EditText txtanti3;
         LinearLayout secanti4;
         View lineanti4;
         TextView Vlblanti4;
         EditText txtanti4;
         LinearLayout secanti5;
         View lineanti5;
         TextView Vlblanti5;
         EditText txtanti5;
         LinearLayout secanti6;
         View lineanti6;
         TextView Vlblanti6;
         EditText txtanti6;
         LinearLayout secanti7;
         View lineanti7;
         TextView Vlblanti7;
         EditText txtanti7;
         LinearLayout secanti8;
         View lineanti8;
         TextView Vlblanti8;
         EditText txtanti8;
         LinearLayout secotherttmnt;
         View lineotherttmnt;
         TextView Vlblotherttmnt;
         RadioGroup rdogrpotherttmnt;
         
         RadioButton rdootherttmnt1;
         RadioButton rdootherttmnt2;
         LinearLayout secotherttmntname;
         View lineotherttmntname;
         TextView Vlblotherttmntname;
         RadioGroup rdogrpotherttmntname;
         
         RadioButton rdootherttmntname1;
         RadioButton rdootherttmntname2;
         LinearLayout secothtreat1;
         View lineothtreat1;
         TextView Vlblothtreat1;
         EditText txtothtreat1;
         LinearLayout secothtreat2;
         View lineothtreat2;
         TextView Vlblothtreat2;
         EditText txtothtreat2;
         LinearLayout secothtreat3;
         View lineothtreat3;
         TextView Vlblothtreat3;
         EditText txtothtreat3;
         LinearLayout secothtreat4;
         View lineothtreat4;
         TextView Vlblothtreat4;
         EditText txtothtreat4;
         LinearLayout secothtreat5;
         View lineothtreat5;
         TextView Vlblothtreat5;
         EditText txtothtreat5;
         LinearLayout secothtreat6;
         View lineothtreat6;
         TextView Vlblothtreat6;
         EditText txtothtreat6;
         LinearLayout secothtreat7;
         View lineothtreat7;
         TextView Vlblothtreat7;
         EditText txtothtreat7;
         LinearLayout secothtreat8;
         View lineothtreat8;
         TextView Vlblothtreat8;
         EditText txtothtreat8;
         LinearLayout secoxygen;
         View lineoxygen;
         TextView Vlbloxygen;
         RadioGroup rdogrpoxygen;
         
         RadioButton rdooxygen1;
         RadioButton rdooxygen2;

    static String TableName;

    static String STARTTIME = "";
    static String DEVICEID  = "";
    static String ENTRYUSER = "";
    MySharedPreferences sp;

    Bundle IDbundle;
    static String COUNTRYCODE = "";
    static String FACICODE = "";
    static String DATAID = "";

     ImageButton btnRemAnti2;
     ImageButton btnRemAnti3;
     ImageButton btnRemAnti4;
     ImageButton btnRemAnti5;
     ImageButton btnRemAnti6;
     ImageButton btnRemAnti7;
     ImageButton btnRemAnti8;
     ImageButton btnAddAnti1;

     ImageButton btnRemTre2;
     ImageButton btnRemTre3;
     ImageButton btnRemTre4;
     ImageButton btnRemTre5;
     ImageButton btnRemTre6;
     ImageButton btnRemTre7;
     ImageButton btnRemTre8;
     ImageButton btnAddTre1;

 public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
   try
     {
         setContentView(R.layout.kmc_treat);
         C = new Connection(this);
         g = Global.getInstance();

         STARTTIME = g.CurrentTime24();
         DEVICEID    = sp.getValue(this, "deviceid");
         ENTRYUSER   = sp.getValue(this, "userid");
         COUNTRYCODE = sp.getValue(this, "countrycode");
         FACICODE    = sp.getValue(this, "facicode");

         IDbundle = getIntent().getExtras();
         DATAID = IDbundle.getString("dataid");

         TableName = "KMC_Treat";

         //turnGPSOn();

         //GPS Location
         //FindLocation();
         // Double.toString(currentLatitude);
         // Double.toString(currentLongitude);
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(KMC_Treat.this);
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
         seclbl1=(LinearLayout)findViewById(R.id.seclbl1);
         linelbl1=(View)findViewById(R.id.linelbl1);
         secsupcare=(LinearLayout)findViewById(R.id.secsupcare);
         linesupcare=(View)findViewById(R.id.linesupcare);
         Vlblsupcare = (TextView) findViewById(R.id.Vlblsupcare);
         rdogrpsupcare = (RadioGroup) findViewById(R.id.rdogrpsupcare);
         
         rdosupcare1 = (RadioButton) findViewById(R.id.rdosupcare1);
         rdosupcare2 = (RadioButton) findViewById(R.id.rdosupcare2);
         rdogrpsupcare.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpsupcare = new String[] {"1","2"};
             for (int i = 0; i < rdogrpsupcare.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpsupcare.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpsupcare[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secbanti.setVisibility(View.GONE);
                    linebanti.setVisibility(View.GONE);
                    rdogrpbanti.clearCheck();
                    secanti1.setVisibility(View.GONE);
                    lineanti1.setVisibility(View.GONE);
                    txtanti1.setText("");
                    secanti2.setVisibility(View.GONE);
                    lineanti2.setVisibility(View.GONE);
                    txtanti2.setText("");
                    secanti3.setVisibility(View.GONE);
                    lineanti3.setVisibility(View.GONE);
                    txtanti3.setText("");
                    secanti4.setVisibility(View.GONE);
                    lineanti4.setVisibility(View.GONE);
                    txtanti4.setText("");
                    secanti5.setVisibility(View.GONE);
                    lineanti5.setVisibility(View.GONE);
                    txtanti5.setText("");
                    secanti6.setVisibility(View.GONE);
                    lineanti6.setVisibility(View.GONE);
                    txtanti6.setText("");
                    secanti7.setVisibility(View.GONE);
                    lineanti7.setVisibility(View.GONE);
                    txtanti7.setText("");
                    secanti8.setVisibility(View.GONE);
                    lineanti8.setVisibility(View.GONE);
                    txtanti8.setText("");
                    secotherttmnt.setVisibility(View.GONE);
                    lineotherttmnt.setVisibility(View.GONE);
                    rdogrpotherttmnt.clearCheck();
                    secotherttmntname.setVisibility(View.GONE);
                    lineotherttmntname.setVisibility(View.GONE);
                    rdogrpotherttmntname.clearCheck();
                    secothtreat1.setVisibility(View.GONE);
                    lineothtreat1.setVisibility(View.GONE);
                    txtothtreat1.setText("");
                    secothtreat2.setVisibility(View.GONE);
                    lineothtreat2.setVisibility(View.GONE);
                    txtothtreat2.setText("");
                    secothtreat3.setVisibility(View.GONE);
                    lineothtreat3.setVisibility(View.GONE);
                    txtothtreat3.setText("");
                    secothtreat4.setVisibility(View.GONE);
                    lineothtreat4.setVisibility(View.GONE);
                    txtothtreat4.setText("");
                    secothtreat5.setVisibility(View.GONE);
                    lineothtreat5.setVisibility(View.GONE);
                    txtothtreat5.setText("");
                    secothtreat6.setVisibility(View.GONE);
                    lineothtreat6.setVisibility(View.GONE);
                    txtothtreat6.setText("");
                    secothtreat7.setVisibility(View.GONE);
                    lineothtreat7.setVisibility(View.GONE);
                    txtothtreat7.setText("");
                    secothtreat8.setVisibility(View.GONE);
                    lineothtreat8.setVisibility(View.GONE);
                    txtothtreat8.setText("");
                    secoxygen.setVisibility(View.GONE);
                    lineoxygen.setVisibility(View.GONE);
                    rdogrpoxygen.clearCheck();
             }
             else
             {
                    secbanti.setVisibility(View.VISIBLE);
                    linebanti.setVisibility(View.VISIBLE);
                    /*secanti1.setVisibility(View.VISIBLE);
                    lineanti1.setVisibility(View.VISIBLE);
                    secanti2.setVisibility(View.VISIBLE);
                    lineanti2.setVisibility(View.VISIBLE);
                    secanti3.setVisibility(View.VISIBLE);
                    lineanti3.setVisibility(View.VISIBLE);
                    secanti4.setVisibility(View.VISIBLE);
                    lineanti4.setVisibility(View.VISIBLE);
                    secanti5.setVisibility(View.VISIBLE);
                    lineanti5.setVisibility(View.VISIBLE);
                    secanti6.setVisibility(View.VISIBLE);
                    lineanti6.setVisibility(View.VISIBLE);
                    secanti7.setVisibility(View.VISIBLE);
                    lineanti7.setVisibility(View.VISIBLE);
                    secanti8.setVisibility(View.VISIBLE);
                    lineanti8.setVisibility(View.VISIBLE);*/
                    secotherttmnt.setVisibility(View.VISIBLE);
                    lineotherttmnt.setVisibility(View.VISIBLE);
                    //secotherttmntname.setVisibility(View.VISIBLE);
                    //lineotherttmntname.setVisibility(View.VISIBLE);
                    secoxygen.setVisibility(View.VISIBLE);
                    lineoxygen.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secbanti=(LinearLayout)findViewById(R.id.secbanti);
         linebanti=(View)findViewById(R.id.linebanti);
         Vlblbanti = (TextView) findViewById(R.id.Vlblbanti);
         rdogrpbanti = (RadioGroup) findViewById(R.id.rdogrpbanti);
         
         rdobanti1 = (RadioButton) findViewById(R.id.rdobanti1);
         rdobanti2 = (RadioButton) findViewById(R.id.rdobanti2);
         rdogrpbanti.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpbanti = new String[] {"1","2"};
             for (int i = 0; i < rdogrpbanti.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpbanti.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpbanti[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secanti1.setVisibility(View.GONE);
                    lineanti1.setVisibility(View.GONE);
                    txtanti1.setText("");
                    secanti2.setVisibility(View.GONE);
                    lineanti2.setVisibility(View.GONE);
                    txtanti2.setText("");
                    secanti3.setVisibility(View.GONE);
                    lineanti3.setVisibility(View.GONE);
                    txtanti3.setText("");
                    secanti4.setVisibility(View.GONE);
                    lineanti4.setVisibility(View.GONE);
                    txtanti4.setText("");
                    secanti5.setVisibility(View.GONE);
                    lineanti5.setVisibility(View.GONE);
                    txtanti5.setText("");
                    secanti6.setVisibility(View.GONE);
                    lineanti6.setVisibility(View.GONE);
                    txtanti6.setText("");
                    secanti7.setVisibility(View.GONE);
                    lineanti7.setVisibility(View.GONE);
                    txtanti7.setText("");
                    secanti8.setVisibility(View.GONE);
                    lineanti8.setVisibility(View.GONE);
                    txtanti8.setText("");
             }
             else
             {
                    secanti1.setVisibility(View.VISIBLE);
                    lineanti1.setVisibility(View.VISIBLE);
                    /*secanti2.setVisibility(View.VISIBLE);
                    lineanti2.setVisibility(View.VISIBLE);
                    secanti3.setVisibility(View.VISIBLE);
                    lineanti3.setVisibility(View.VISIBLE);
                    secanti4.setVisibility(View.VISIBLE);
                    lineanti4.setVisibility(View.VISIBLE);
                    secanti5.setVisibility(View.VISIBLE);
                    lineanti5.setVisibility(View.VISIBLE);
                    secanti6.setVisibility(View.VISIBLE);
                    lineanti6.setVisibility(View.VISIBLE);
                    secanti7.setVisibility(View.VISIBLE);
                    lineanti7.setVisibility(View.VISIBLE);
                    secanti8.setVisibility(View.VISIBLE);
                    lineanti8.setVisibility(View.VISIBLE);*/
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secanti1=(LinearLayout)findViewById(R.id.secanti1);
         lineanti1=(View)findViewById(R.id.lineanti1);
         Vlblanti1=(TextView) findViewById(R.id.Vlblanti1);
         txtanti1=(EditText) findViewById(R.id.txtanti1);
         secanti2=(LinearLayout)findViewById(R.id.secanti2);
         lineanti2=(View)findViewById(R.id.lineanti2);
         Vlblanti2=(TextView) findViewById(R.id.Vlblanti2);
         txtanti2=(EditText) findViewById(R.id.txtanti2);
         secanti3=(LinearLayout)findViewById(R.id.secanti3);
         lineanti3=(View)findViewById(R.id.lineanti3);
         Vlblanti3=(TextView) findViewById(R.id.Vlblanti3);
         txtanti3=(EditText) findViewById(R.id.txtanti3);
         secanti4=(LinearLayout)findViewById(R.id.secanti4);
         lineanti4=(View)findViewById(R.id.lineanti4);
         Vlblanti4=(TextView) findViewById(R.id.Vlblanti4);
         txtanti4=(EditText) findViewById(R.id.txtanti4);
         secanti5=(LinearLayout)findViewById(R.id.secanti5);
         lineanti5=(View)findViewById(R.id.lineanti5);
         Vlblanti5=(TextView) findViewById(R.id.Vlblanti5);
         txtanti5=(EditText) findViewById(R.id.txtanti5);
         secanti6=(LinearLayout)findViewById(R.id.secanti6);
         lineanti6=(View)findViewById(R.id.lineanti6);
         Vlblanti6=(TextView) findViewById(R.id.Vlblanti6);
         txtanti6=(EditText) findViewById(R.id.txtanti6);
         secanti7=(LinearLayout)findViewById(R.id.secanti7);
         lineanti7=(View)findViewById(R.id.lineanti7);
         Vlblanti7=(TextView) findViewById(R.id.Vlblanti7);
         txtanti7=(EditText) findViewById(R.id.txtanti7);
         secanti8=(LinearLayout)findViewById(R.id.secanti8);
         lineanti8=(View)findViewById(R.id.lineanti8);
         Vlblanti8=(TextView) findViewById(R.id.Vlblanti8);
         txtanti8=(EditText) findViewById(R.id.txtanti8);
         secotherttmnt=(LinearLayout)findViewById(R.id.secotherttmnt);
         lineotherttmnt=(View)findViewById(R.id.lineotherttmnt);
         Vlblotherttmnt = (TextView) findViewById(R.id.Vlblotherttmnt);
         rdogrpotherttmnt = (RadioGroup) findViewById(R.id.rdogrpotherttmnt);
         
         rdootherttmnt1 = (RadioButton) findViewById(R.id.rdootherttmnt1);
         rdootherttmnt2 = (RadioButton) findViewById(R.id.rdootherttmnt2);
         rdogrpotherttmnt.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpotherttmnt = new String[] {"1","2"};
             for (int i = 0; i < rdogrpotherttmnt.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpotherttmnt.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpotherttmnt[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secotherttmntname.setVisibility(View.GONE);
                    lineotherttmntname.setVisibility(View.GONE);
                    rdogrpotherttmntname.clearCheck();
                    secothtreat1.setVisibility(View.GONE);
                    lineothtreat1.setVisibility(View.GONE);
                    txtothtreat1.setText("");
                    secothtreat2.setVisibility(View.GONE);
                    lineothtreat2.setVisibility(View.GONE);
                    txtothtreat2.setText("");
                    secothtreat3.setVisibility(View.GONE);
                    lineothtreat3.setVisibility(View.GONE);
                    txtothtreat3.setText("");
                    secothtreat4.setVisibility(View.GONE);
                    lineothtreat4.setVisibility(View.GONE);
                    txtothtreat4.setText("");
                    secothtreat5.setVisibility(View.GONE);
                    lineothtreat5.setVisibility(View.GONE);
                    txtothtreat5.setText("");
                    secothtreat6.setVisibility(View.GONE);
                    lineothtreat6.setVisibility(View.GONE);
                    txtothtreat6.setText("");
                    secothtreat7.setVisibility(View.GONE);
                    lineothtreat7.setVisibility(View.GONE);
                    txtothtreat7.setText("");
                    secothtreat8.setVisibility(View.GONE);
                    lineothtreat8.setVisibility(View.GONE);
                    txtothtreat8.setText("");
             }
             else
             {
                    secotherttmntname.setVisibility(View.VISIBLE);
                    lineotherttmntname.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secotherttmntname=(LinearLayout)findViewById(R.id.secotherttmntname);
         lineotherttmntname=(View)findViewById(R.id.lineotherttmntname);
         Vlblotherttmntname = (TextView) findViewById(R.id.Vlblotherttmntname);
         rdogrpotherttmntname = (RadioGroup) findViewById(R.id.rdogrpotherttmntname);
         
         rdootherttmntname1 = (RadioButton) findViewById(R.id.rdootherttmntname1);
         rdootherttmntname2 = (RadioButton) findViewById(R.id.rdootherttmntname2);
         rdogrpotherttmntname.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpotherttmntname = new String[] {"1","2"};
             for (int i = 0; i < rdogrpotherttmntname.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpotherttmntname.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpotherttmntname[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                    secothtreat1.setVisibility(View.GONE);
                    lineothtreat1.setVisibility(View.GONE);
                    txtothtreat1.setText("");
                    secothtreat2.setVisibility(View.GONE);
                    lineothtreat2.setVisibility(View.GONE);
                    txtothtreat2.setText("");
                    secothtreat3.setVisibility(View.GONE);
                    lineothtreat3.setVisibility(View.GONE);
                    txtothtreat3.setText("");
                    secothtreat4.setVisibility(View.GONE);
                    lineothtreat4.setVisibility(View.GONE);
                    txtothtreat4.setText("");
                    secothtreat5.setVisibility(View.GONE);
                    lineothtreat5.setVisibility(View.GONE);
                    txtothtreat5.setText("");
                    secothtreat6.setVisibility(View.GONE);
                    lineothtreat6.setVisibility(View.GONE);
                    txtothtreat6.setText("");
                    secothtreat7.setVisibility(View.GONE);
                    lineothtreat7.setVisibility(View.GONE);
                    txtothtreat7.setText("");
                    secothtreat8.setVisibility(View.GONE);
                    lineothtreat8.setVisibility(View.GONE);
                    txtothtreat8.setText("");
             }
             else
             {
                    secothtreat1.setVisibility(View.VISIBLE);
                    lineothtreat1.setVisibility(View.VISIBLE);
                    /*secothtreat2.setVisibility(View.VISIBLE);
                    lineothtreat2.setVisibility(View.VISIBLE);
                    secothtreat3.setVisibility(View.VISIBLE);
                    lineothtreat3.setVisibility(View.VISIBLE);
                    secothtreat4.setVisibility(View.VISIBLE);
                    lineothtreat4.setVisibility(View.VISIBLE);
                    secothtreat5.setVisibility(View.VISIBLE);
                    lineothtreat5.setVisibility(View.VISIBLE);
                    secothtreat6.setVisibility(View.VISIBLE);
                    lineothtreat6.setVisibility(View.VISIBLE);
                    secothtreat7.setVisibility(View.VISIBLE);
                    lineothtreat7.setVisibility(View.VISIBLE);
                    secothtreat8.setVisibility(View.VISIBLE);
                    lineothtreat8.setVisibility(View.VISIBLE);*/
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secothtreat1=(LinearLayout)findViewById(R.id.secothtreat1);
         lineothtreat1=(View)findViewById(R.id.lineothtreat1);
         Vlblothtreat1=(TextView) findViewById(R.id.Vlblothtreat1);
         txtothtreat1=(EditText) findViewById(R.id.txtothtreat1);
         secothtreat2=(LinearLayout)findViewById(R.id.secothtreat2);
         lineothtreat2=(View)findViewById(R.id.lineothtreat2);
         Vlblothtreat2=(TextView) findViewById(R.id.Vlblothtreat2);
         txtothtreat2=(EditText) findViewById(R.id.txtothtreat2);
         secothtreat3=(LinearLayout)findViewById(R.id.secothtreat3);
         lineothtreat3=(View)findViewById(R.id.lineothtreat3);
         Vlblothtreat3=(TextView) findViewById(R.id.Vlblothtreat3);
         txtothtreat3=(EditText) findViewById(R.id.txtothtreat3);
         secothtreat4=(LinearLayout)findViewById(R.id.secothtreat4);
         lineothtreat4=(View)findViewById(R.id.lineothtreat4);
         Vlblothtreat4=(TextView) findViewById(R.id.Vlblothtreat4);
         txtothtreat4=(EditText) findViewById(R.id.txtothtreat4);
         secothtreat5=(LinearLayout)findViewById(R.id.secothtreat5);
         lineothtreat5=(View)findViewById(R.id.lineothtreat5);
         Vlblothtreat5=(TextView) findViewById(R.id.Vlblothtreat5);
         txtothtreat5=(EditText) findViewById(R.id.txtothtreat5);
         secothtreat6=(LinearLayout)findViewById(R.id.secothtreat6);
         lineothtreat6=(View)findViewById(R.id.lineothtreat6);
         Vlblothtreat6=(TextView) findViewById(R.id.Vlblothtreat6);
         txtothtreat6=(EditText) findViewById(R.id.txtothtreat6);
         secothtreat7=(LinearLayout)findViewById(R.id.secothtreat7);
         lineothtreat7=(View)findViewById(R.id.lineothtreat7);
         Vlblothtreat7=(TextView) findViewById(R.id.Vlblothtreat7);
         txtothtreat7=(EditText) findViewById(R.id.txtothtreat7);
         secothtreat8=(LinearLayout)findViewById(R.id.secothtreat8);
         lineothtreat8=(View)findViewById(R.id.lineothtreat8);
         Vlblothtreat8=(TextView) findViewById(R.id.Vlblothtreat8);
         txtothtreat8=(EditText) findViewById(R.id.txtothtreat8);
         secoxygen=(LinearLayout)findViewById(R.id.secoxygen);
         lineoxygen=(View)findViewById(R.id.lineoxygen);
         Vlbloxygen = (TextView) findViewById(R.id.Vlbloxygen);
         rdogrpoxygen = (RadioGroup) findViewById(R.id.rdogrpoxygen);
         
         rdooxygen1 = (RadioButton) findViewById(R.id.rdooxygen1);
         rdooxygen2 = (RadioButton) findViewById(R.id.rdooxygen2);





         //Hide all skip variables
         secbanti.setVisibility(View.GONE);
         linebanti.setVisibility(View.GONE);
         secanti1.setVisibility(View.GONE);
         lineanti1.setVisibility(View.GONE);
         secanti2.setVisibility(View.GONE);
         lineanti2.setVisibility(View.GONE);
         secanti3.setVisibility(View.GONE);
         lineanti3.setVisibility(View.GONE);
         secanti4.setVisibility(View.GONE);
         lineanti4.setVisibility(View.GONE);
         secanti5.setVisibility(View.GONE);
         lineanti5.setVisibility(View.GONE);
         secanti6.setVisibility(View.GONE);
         lineanti6.setVisibility(View.GONE);
         secanti7.setVisibility(View.GONE);
         lineanti7.setVisibility(View.GONE);
         secanti8.setVisibility(View.GONE);
         lineanti8.setVisibility(View.GONE);
         secotherttmnt.setVisibility(View.GONE);
         lineotherttmnt.setVisibility(View.GONE);
         secotherttmntname.setVisibility(View.GONE);
         lineotherttmntname.setVisibility(View.GONE);
         secothtreat1.setVisibility(View.GONE);
         lineothtreat1.setVisibility(View.GONE);
         secothtreat2.setVisibility(View.GONE);
         lineothtreat2.setVisibility(View.GONE);
         secothtreat3.setVisibility(View.GONE);
         lineothtreat3.setVisibility(View.GONE);
         secothtreat4.setVisibility(View.GONE);
         lineothtreat4.setVisibility(View.GONE);
         secothtreat5.setVisibility(View.GONE);
         lineothtreat5.setVisibility(View.GONE);
         secothtreat6.setVisibility(View.GONE);
         lineothtreat6.setVisibility(View.GONE);
         secothtreat7.setVisibility(View.GONE);
         lineothtreat7.setVisibility(View.GONE);
         secothtreat8.setVisibility(View.GONE);
         lineothtreat8.setVisibility(View.GONE);
         secoxygen.setVisibility(View.GONE);
         lineoxygen.setVisibility(View.GONE);
         secanti1.setVisibility(View.GONE);
         lineanti1.setVisibility(View.GONE);
         secanti2.setVisibility(View.GONE);
         lineanti2.setVisibility(View.GONE);
         secanti3.setVisibility(View.GONE);
         lineanti3.setVisibility(View.GONE);
         secanti4.setVisibility(View.GONE);
         lineanti4.setVisibility(View.GONE);
         secanti5.setVisibility(View.GONE);
         lineanti5.setVisibility(View.GONE);
         secanti6.setVisibility(View.GONE);
         lineanti6.setVisibility(View.GONE);
         secanti7.setVisibility(View.GONE);
         lineanti7.setVisibility(View.GONE);
         secanti8.setVisibility(View.GONE);
         lineanti8.setVisibility(View.GONE);
         secotherttmntname.setVisibility(View.GONE);
         lineotherttmntname.setVisibility(View.GONE);
         secothtreat1.setVisibility(View.GONE);
         lineothtreat1.setVisibility(View.GONE);
         secothtreat2.setVisibility(View.GONE);
         lineothtreat2.setVisibility(View.GONE);
         secothtreat3.setVisibility(View.GONE);
         lineothtreat3.setVisibility(View.GONE);
         secothtreat4.setVisibility(View.GONE);
         lineothtreat4.setVisibility(View.GONE);
         secothtreat5.setVisibility(View.GONE);
         lineothtreat5.setVisibility(View.GONE);
         secothtreat6.setVisibility(View.GONE);
         lineothtreat6.setVisibility(View.GONE);
         secothtreat7.setVisibility(View.GONE);
         lineothtreat7.setVisibility(View.GONE);
         secothtreat8.setVisibility(View.GONE);
         lineothtreat8.setVisibility(View.GONE);
         secothtreat1.setVisibility(View.GONE);
         lineothtreat1.setVisibility(View.GONE);
         secothtreat2.setVisibility(View.GONE);
         lineothtreat2.setVisibility(View.GONE);
         secothtreat3.setVisibility(View.GONE);
         lineothtreat3.setVisibility(View.GONE);
         secothtreat4.setVisibility(View.GONE);
         lineothtreat4.setVisibility(View.GONE);
         secothtreat5.setVisibility(View.GONE);
         lineothtreat5.setVisibility(View.GONE);
         secothtreat6.setVisibility(View.GONE);
         lineothtreat6.setVisibility(View.GONE);
         secothtreat7.setVisibility(View.GONE);
         lineothtreat7.setVisibility(View.GONE);
         secothtreat8.setVisibility(View.GONE);
         lineothtreat8.setVisibility(View.GONE);




         btnRemAnti2 = (ImageButton) findViewById(R.id.btnRemAnti2);
         btnRemAnti2.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 secanti2.setVisibility(View.GONE);
                 txtanti2.setText("");
             }});
         btnRemAnti3 = (ImageButton) findViewById(R.id.btnRemAnti3);
         btnRemAnti3.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 secanti3.setVisibility(View.GONE);
                 txtanti3.setText("");
                 btnRemAnti2.setVisibility(View.VISIBLE);
             }});
         btnRemAnti4 = (ImageButton) findViewById(R.id.btnRemAnti4);
         btnRemAnti4.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 secanti4.setVisibility(View.GONE);
                 txtanti4.setText("");
                 btnRemAnti3.setVisibility(View.VISIBLE);
             }});
         btnRemAnti5 = (ImageButton) findViewById(R.id.btnRemAnti5);
         btnRemAnti5.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 secanti5.setVisibility(View.GONE);
                 txtanti5.setText("");
                 btnRemAnti4.setVisibility(View.VISIBLE);
             }});
         btnRemAnti6 = (ImageButton) findViewById(R.id.btnRemAnti6);
         btnRemAnti6.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 secanti6.setVisibility(View.GONE);
                 txtanti6.setText("");
                 btnRemAnti5.setVisibility(View.VISIBLE);
             }});
         btnRemAnti7 = (ImageButton) findViewById(R.id.btnRemAnti7);
         btnRemAnti7.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 secanti7.setVisibility(View.GONE);
                 txtanti7.setText("");
                 btnRemAnti6.setVisibility(View.VISIBLE);
             }});
         btnRemAnti8 = (ImageButton) findViewById(R.id.btnRemAnti8);
         btnRemAnti8.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 secanti8.setVisibility(View.GONE);
                 txtanti8.setText("");
                 btnRemAnti7.setVisibility(View.VISIBLE);
             }});

         ImageButton btnAddAnti1 = (ImageButton) findViewById(R.id.btnAddAnti1);
         btnAddAnti1.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 if(!secanti2.isShown()) secanti2.setVisibility(View.VISIBLE);
                 else if(!secanti3.isShown()) {secanti3.setVisibility(View.VISIBLE); btnRemAnti2.setVisibility(View.GONE);}
                 else if(!secanti4.isShown()) {secanti4.setVisibility(View.VISIBLE); btnRemAnti3.setVisibility(View.GONE);}
                 else if(!secanti5.isShown()) {secanti5.setVisibility(View.VISIBLE); btnRemAnti4.setVisibility(View.GONE);}
                 else if(!secanti6.isShown()) {secanti6.setVisibility(View.VISIBLE); btnRemAnti5.setVisibility(View.GONE);}
                 else if(!secanti7.isShown()) {secanti7.setVisibility(View.VISIBLE); btnRemAnti6.setVisibility(View.GONE);}
                 else if(!secanti8.isShown()) {secanti8.setVisibility(View.VISIBLE); btnRemAnti7.setVisibility(View.GONE);}
             }});


         btnRemTre2 = (ImageButton) findViewById(R.id.btnRemTre2);
         btnRemTre2.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 secothtreat2.setVisibility(View.GONE);
                 txtothtreat2.setText("");
             }});

         btnRemTre3 = (ImageButton) findViewById(R.id.btnRemTre3);
         btnRemTre3.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 secothtreat3.setVisibility(View.GONE);
                 txtothtreat3.setText("");
                 btnRemTre2.setVisibility(View.VISIBLE);
             }});

         btnRemTre4 = (ImageButton) findViewById(R.id.btnRemTre4);
         btnRemTre4.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 secothtreat4.setVisibility(View.GONE);
                 txtothtreat4.setText("");
                 btnRemTre3.setVisibility(View.VISIBLE);
             }});

         btnRemTre5 = (ImageButton) findViewById(R.id.btnRemTre5);
         btnRemTre5.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 secothtreat5.setVisibility(View.GONE);
                 txtothtreat5.setText("");
                 btnRemTre4.setVisibility(View.VISIBLE);
             }});

         btnRemTre6 = (ImageButton) findViewById(R.id.btnRemTre6);
         btnRemTre6.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 secothtreat6.setVisibility(View.GONE);
                 txtothtreat6.setText("");
                 btnRemTre5.setVisibility(View.VISIBLE);
             }});

         btnRemTre7 = (ImageButton) findViewById(R.id.btnRemTre7);
         btnRemTre7.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 secothtreat7.setVisibility(View.GONE);
                 txtothtreat7.setText("");
                 btnRemTre6.setVisibility(View.VISIBLE);
             }});

         btnRemTre8 = (ImageButton) findViewById(R.id.btnRemTre8);
         btnRemTre8.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 secothtreat8.setVisibility(View.GONE);
                 txtothtreat8.setText("");
                 btnRemTre7.setVisibility(View.VISIBLE);
             }});

         ImageButton btnAddTre1 = (ImageButton) findViewById(R.id.btnAddTre1);
         btnAddTre1.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 if(!secothtreat2.isShown()) secothtreat2.setVisibility(View.VISIBLE);
                 else if(!secothtreat3.isShown()) {secothtreat3.setVisibility(View.VISIBLE); btnRemTre2.setVisibility(View.GONE);}
                 else if(!secothtreat4.isShown()) {secothtreat4.setVisibility(View.VISIBLE); btnRemTre3.setVisibility(View.GONE);}
                 else if(!secothtreat5.isShown()) {secothtreat5.setVisibility(View.VISIBLE); btnRemTre4.setVisibility(View.GONE);}
                 else if(!secothtreat6.isShown()) {secothtreat6.setVisibility(View.VISIBLE); btnRemTre5.setVisibility(View.GONE);}
                 else if(!secothtreat7.isShown()) {secothtreat7.setVisibility(View.VISIBLE); btnRemTre6.setVisibility(View.GONE);}
                 else if(!secothtreat8.isShown()) {secothtreat8.setVisibility(View.VISIBLE); btnRemTre7.setVisibility(View.GONE);}
             }});


        DataSearch(COUNTRYCODE,FACICODE,DATAID);
        Button cmdSave = (Button) findViewById(R.id.cmdSave);
        cmdSave.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) { 
            DataSave();
        }});
     }
     catch(Exception  e)
     {
         Connection.MessageBox(KMC_Treat.this, e.getMessage());
         return;
     }
 }

 public void ClearForm(){
    rdogrpsupcare.clearCheck();
     rdogrpbanti.clearCheck();
     txtanti1.setText("");
     txtanti2.setText("");
     txtanti3.setText("");
     txtanti4.setText("");
     txtanti5.setText("");
     txtanti6.setText("");
     txtanti7.setText("");
     txtanti8.setText("");


     rdogrpotherttmnt.clearCheck();
     rdogrpotherttmntname.clearCheck();
     txtothtreat1.setText("");
     txtothtreat2.setText("");
     txtothtreat3.setText("");
     txtothtreat4.setText("");
     txtothtreat5.setText("");
     txtothtreat6.setText("");
     txtothtreat7.setText("");
     txtothtreat8.setText("");

     rdogrpoxygen.clearCheck();
 }


 private void DataSave()
 {
   try
     {
 
         String DV="";

         if(txtCountryCode.getText().toString().length()==0 & secCountryCode.isShown())
           {
             Connection.MessageBox(KMC_Treat.this, "Required field: Country Code.");
             txtCountryCode.requestFocus(); 
             return;	
           }
         else if(txtFaciCode.getText().toString().length()==0 & secFaciCode.isShown())
           {
             Connection.MessageBox(KMC_Treat.this, "Required field: Faci Code.");
             txtFaciCode.requestFocus(); 
             return;	
           }
         else if(txtDataID.getText().toString().length()==0 & secDataID.isShown())
           {
             Connection.MessageBox(KMC_Treat.this, "Required field: Data ID.");
             txtDataID.requestFocus(); 
             return;	
           }
         
         else if(!rdosupcare1.isChecked() & !rdosupcare2.isChecked() & secsupcare.isShown())
           {
              Connection.MessageBox(KMC_Treat.this, "Select anyone options from (Is other supportive care being given?).");
              rdosupcare1.requestFocus();
              return;
           }
         
         else if(!rdobanti1.isChecked() & !rdobanti2.isChecked() & secbanti.isShown())
           {
              Connection.MessageBox(KMC_Treat.this, "Select anyone options from (Are antibiotics being given).");
              rdobanti1.requestFocus();
              return;
           }
         else if(txtanti1.getText().toString().length()==0 & secanti1.isShown())
           {
             Connection.MessageBox(KMC_Treat.this, "Required field: 1) Antibiotic - 1.");
             txtanti1.requestFocus(); 
             return;	
           }
         else if(txtanti2.getText().toString().length()==0 & secanti2.isShown())
           {
             Connection.MessageBox(KMC_Treat.this, "Required field: 2) Antibiotic - 2.");
             txtanti2.requestFocus(); 
             return;	
           }
         else if(txtanti3.getText().toString().length()==0 & secanti3.isShown())
           {
             Connection.MessageBox(KMC_Treat.this, "Required field: 3) Antibiotic - 3.");
             txtanti3.requestFocus(); 
             return;	
           }
         else if(txtanti4.getText().toString().length()==0 & secanti4.isShown())
           {
             Connection.MessageBox(KMC_Treat.this, "Required field: 4) Antibiotic - 4.");
             txtanti4.requestFocus(); 
             return;	
           }
         else if(txtanti5.getText().toString().length()==0 & secanti5.isShown())
           {
             Connection.MessageBox(KMC_Treat.this, "Required field: 5) Antibiotic - 5.");
             txtanti5.requestFocus(); 
             return;	
           }
         else if(txtanti6.getText().toString().length()==0 & secanti6.isShown())
           {
             Connection.MessageBox(KMC_Treat.this, "Required field: 6) Antibiotic - 6.");
             txtanti6.requestFocus(); 
             return;	
           }
         else if(txtanti7.getText().toString().length()==0 & secanti7.isShown())
           {
             Connection.MessageBox(KMC_Treat.this, "Required field: 7) Antibiotic - 7.");
             txtanti7.requestFocus(); 
             return;	
           }
         else if(txtanti8.getText().toString().length()==0 & secanti8.isShown())
           {
             Connection.MessageBox(KMC_Treat.this, "Required field: 8) Antibiotic - 8.");
             txtanti8.requestFocus(); 
             return;	
           }
         
         else if(!rdootherttmnt1.isChecked() & !rdootherttmnt2.isChecked() & secotherttmnt.isShown())
           {
              Connection.MessageBox(KMC_Treat.this, "Select anyone options from (Other treatments being given?).");
              rdootherttmnt1.requestFocus();
              return;
           }
         
         else if(!rdootherttmntname1.isChecked() & !rdootherttmntname2.isChecked() & secotherttmntname.isShown())
           {
              Connection.MessageBox(KMC_Treat.this, "Select anyone options from (Treatments being given?).");
              rdootherttmntname1.requestFocus();
              return;
           }
         else if(txtothtreat1.getText().toString().length()==0 & secothtreat1.isShown())
           {
             Connection.MessageBox(KMC_Treat.this, "Required field: 1) Treatment - 1.");
             txtothtreat1.requestFocus(); 
             return;	
           }
         else if(txtothtreat2.getText().toString().length()==0 & secothtreat2.isShown())
           {
             Connection.MessageBox(KMC_Treat.this, "Required field: 2) Treatment - 2.");
             txtothtreat2.requestFocus(); 
             return;	
           }
         else if(txtothtreat3.getText().toString().length()==0 & secothtreat3.isShown())
           {
             Connection.MessageBox(KMC_Treat.this, "Required field: 3) Treatment - 3.");
             txtothtreat3.requestFocus(); 
             return;	
           }
         else if(txtothtreat4.getText().toString().length()==0 & secothtreat4.isShown())
           {
             Connection.MessageBox(KMC_Treat.this, "Required field: 4) Treatment - 4.");
             txtothtreat4.requestFocus(); 
             return;	
           }
         else if(txtothtreat5.getText().toString().length()==0 & secothtreat5.isShown())
           {
             Connection.MessageBox(KMC_Treat.this, "Required field: 5) Treatment - 5.");
             txtothtreat5.requestFocus(); 
             return;	
           }
         else if(txtothtreat6.getText().toString().length()==0 & secothtreat6.isShown())
           {
             Connection.MessageBox(KMC_Treat.this, "Required field: 6) Treatment - 6.");
             txtothtreat6.requestFocus(); 
             return;	
           }
         else if(txtothtreat7.getText().toString().length()==0 & secothtreat7.isShown())
           {
             Connection.MessageBox(KMC_Treat.this, "Required field: 7) Treatment - 7.");
             txtothtreat7.requestFocus(); 
             return;	
           }
         else if(txtothtreat8.getText().toString().length()==0 & secothtreat8.isShown())
           {
             Connection.MessageBox(KMC_Treat.this, "Required field: 8) Treatment - 8.");
             txtothtreat8.requestFocus(); 
             return;	
           }
         
         else if(!rdooxygen1.isChecked() & !rdooxygen2.isChecked() & secoxygen.isShown())
           {
              Connection.MessageBox(KMC_Treat.this, "Select anyone options from (Is oxygen being given? ).");
              rdooxygen1.requestFocus();
              return;
           }
 
         String SQL = "";
         RadioButton rb;

         KMC_Treat_DataModel objSave = new KMC_Treat_DataModel();
         objSave.setCountryCode(txtCountryCode.getText().toString());
         objSave.setFaciCode(txtFaciCode.getText().toString());
         objSave.setDataID(txtDataID.getText().toString());
         String[] d_rdogrpsupcare = new String[] {"1","2"};
         objSave.setsupcare("");
         for (int i = 0; i < rdogrpsupcare.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpsupcare.getChildAt(i);
             if (rb.isChecked()) objSave.setsupcare(d_rdogrpsupcare[i]);
         }

         String[] d_rdogrpbanti = new String[] {"1","2"};
         objSave.setbanti("");
         for (int i = 0; i < rdogrpbanti.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpbanti.getChildAt(i);
             if (rb.isChecked()) objSave.setbanti(d_rdogrpbanti[i]);
         }

         objSave.setanti1(txtanti1.getText().toString());
         objSave.setanti2(txtanti2.getText().toString());
         objSave.setanti3(txtanti3.getText().toString());
         objSave.setanti4(txtanti4.getText().toString());
         objSave.setanti5(txtanti5.getText().toString());
         objSave.setanti6(txtanti6.getText().toString());
         objSave.setanti7(txtanti7.getText().toString());
         objSave.setanti8(txtanti8.getText().toString());
         String[] d_rdogrpotherttmnt = new String[] {"1","2"};
         objSave.setotherttmnt("");
         for (int i = 0; i < rdogrpotherttmnt.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpotherttmnt.getChildAt(i);
             if (rb.isChecked()) objSave.setotherttmnt(d_rdogrpotherttmnt[i]);
         }

         String[] d_rdogrpotherttmntname = new String[] {"1","2"};
         objSave.setotherttmntname("");
         for (int i = 0; i < rdogrpotherttmntname.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpotherttmntname.getChildAt(i);
             if (rb.isChecked()) objSave.setotherttmntname(d_rdogrpotherttmntname[i]);
         }

         objSave.setothtreat1(txtothtreat1.getText().toString());
         objSave.setothtreat2(txtothtreat2.getText().toString());
         objSave.setothtreat3(txtothtreat3.getText().toString());
         objSave.setothtreat4(txtothtreat4.getText().toString());
         objSave.setothtreat5(txtothtreat5.getText().toString());
         objSave.setothtreat6(txtothtreat6.getText().toString());
         objSave.setothtreat7(txtothtreat7.getText().toString());
         objSave.setothtreat8(txtothtreat8.getText().toString());


         String[] d_rdogrpoxygen = new String[] {"1","2"};
         objSave.setoxygen("");
         for (int i = 0; i < rdogrpoxygen.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpoxygen.getChildAt(i);
             if (rb.isChecked()) objSave.setoxygen(d_rdogrpoxygen[i]);
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
             /*Intent returnIntent = new Intent();
             returnIntent.putExtra("res", "");
             setResult(Activity.RESULT_OK, returnIntent);*/

             Connection.MessageBoxNotClose(KMC_Treat.this, "Saved Successfully");
         }
         else{
             Connection.MessageBox(KMC_Treat.this, status);
             return;
         }
     }
     catch(Exception  e)
     {
         Connection.MessageBox(KMC_Treat.this, e.getMessage());
         return;
     }
 }

 public void DataSearch(String CountryCode, String FaciCode, String DataID)
     {
       try
        {
     
           RadioButton rb;
           KMC_Treat_DataModel d = new KMC_Treat_DataModel();
           String SQL = "Select * from "+ TableName +"  Where CountryCode='"+ CountryCode +"' and FaciCode='"+ FaciCode +"' and DataID='"+ DataID +"'";
           List<KMC_Treat_DataModel> data = d.SelectAll(this, SQL);
           for(KMC_Treat_DataModel item : data){
             txtCountryCode.setText(item.getCountryCode());
             txtFaciCode.setText(item.getFaciCode());
             txtDataID.setText(item.getDataID());
             String[] d_rdogrpsupcare = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpsupcare.length; i++)
             {
                 if (item.getsupcare().equals(String.valueOf(d_rdogrpsupcare[i])))
                 {
                     rb = (RadioButton)rdogrpsupcare.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpbanti = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpbanti.length; i++)
             {
                 if (item.getbanti().equals(String.valueOf(d_rdogrpbanti[i])))
                 {
                     rb = (RadioButton)rdogrpbanti.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtanti1.setText(item.getanti1());
             txtanti2.setText(item.getanti2());
             txtanti3.setText(item.getanti3());
             txtanti4.setText(item.getanti4());
             txtanti5.setText(item.getanti5());
             txtanti6.setText(item.getanti6());
             txtanti7.setText(item.getanti7());
             txtanti8.setText(item.getanti8());

               if(item.getanti2().toString().length()>0) {secanti2.setVisibility(View.VISIBLE);}
               if(item.getanti3().toString().length()>0) {secanti3.setVisibility(View.VISIBLE);btnRemAnti2.setVisibility(View.GONE);}
               if(item.getanti4().toString().length()>0) {secanti4.setVisibility(View.VISIBLE);btnRemAnti3.setVisibility(View.GONE);}
               if(item.getanti5().toString().length()>0) {secanti5.setVisibility(View.VISIBLE);btnRemAnti4.setVisibility(View.GONE);}
               if(item.getanti6().toString().length()>0) {secanti6.setVisibility(View.VISIBLE);btnRemAnti5.setVisibility(View.GONE);}
               if(item.getanti7().toString().length()>0) {secanti7.setVisibility(View.VISIBLE);btnRemAnti6.setVisibility(View.GONE);}
               if(item.getanti8().toString().length()>0) {secanti8.setVisibility(View.VISIBLE);btnRemAnti7.setVisibility(View.GONE);}

             String[] d_rdogrpotherttmnt = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpotherttmnt.length; i++)
             {
                 if (item.getotherttmnt().equals(String.valueOf(d_rdogrpotherttmnt[i])))
                 {
                     rb = (RadioButton)rdogrpotherttmnt.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpotherttmntname = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpotherttmntname.length; i++)
             {
                 if (item.getotherttmntname().equals(String.valueOf(d_rdogrpotherttmntname[i])))
                 {
                     rb = (RadioButton)rdogrpotherttmntname.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtothtreat1.setText(item.getothtreat1());
             txtothtreat2.setText(item.getothtreat2());
             txtothtreat3.setText(item.getothtreat3());
             txtothtreat4.setText(item.getothtreat4());
             txtothtreat5.setText(item.getothtreat5());
             txtothtreat6.setText(item.getothtreat6());
             txtothtreat7.setText(item.getothtreat7());
             txtothtreat8.setText(item.getothtreat8());

               if(item.getothtreat2().toString().length()>0) {secothtreat2.setVisibility(View.VISIBLE);}
               if(item.getothtreat3().toString().length()>0) {secothtreat3.setVisibility(View.VISIBLE);btnRemTre2.setVisibility(View.GONE);}
               if(item.getothtreat4().toString().length()>0) {secothtreat4.setVisibility(View.VISIBLE);btnRemTre3.setVisibility(View.GONE);}
               if(item.getothtreat5().toString().length()>0) {secothtreat5.setVisibility(View.VISIBLE);btnRemTre4.setVisibility(View.GONE);}
               if(item.getothtreat6().toString().length()>0) {secothtreat6.setVisibility(View.VISIBLE);btnRemTre5.setVisibility(View.GONE);}
               if(item.getothtreat7().toString().length()>0) {secothtreat7.setVisibility(View.VISIBLE);btnRemTre6.setVisibility(View.GONE);}
               if(item.getothtreat8().toString().length()>0) {secothtreat8.setVisibility(View.VISIBLE);btnRemTre7.setVisibility(View.GONE);}

             String[] d_rdogrpoxygen = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpoxygen.length; i++)
             {
                 if (item.getoxygen().equals(String.valueOf(d_rdogrpoxygen[i])))
                 {
                     rb = (RadioButton)rdogrpoxygen.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
           }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(KMC_Treat.this, e.getMessage());
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


     /* dtpDate.setText(new StringBuilder()
      .append(Global.Right("00"+mDay,2)).append("/")
      .append(Global.Right("00"+mMonth,2)).append("/")
      .append(mYear));*/
      }
  };

 private TimePickerDialog.OnTimeSetListener timePickerListener = new TimePickerDialog.OnTimeSetListener() {
    public void onTimeSet(TimePicker view, int selectedHour, int selectedMinute) {
       hour = selectedHour; minute = selectedMinute;
       EditText tpTime;


         // tpTime.setText(new StringBuilder().append(Global.Right("00"+hour,2)).append(":").append(Global.Right("00"+minute,2)));

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