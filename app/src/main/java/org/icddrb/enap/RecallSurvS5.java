
 package org.icddrb.enap;


 //Android Manifest Code
 //<activity android:name=".RecallSurvS5" android:label="RecallSurvS5" />
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

 public class RecallSurvS5 extends Activity {
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
         LinearLayout seclblSecV;
         View linelblSecV;
         LinearLayout seclbl01;
         View linelbl01;
         LinearLayout sechhitemsA;
         View linehhitemsA;
         TextView VlblhhitemsA;
         RadioGroup rdogrphhitemsA;
         
         RadioButton rdohhitemsA1;
         RadioButton rdohhitemsA2;
         LinearLayout sechhitemsB;
         View linehhitemsB;
         TextView VlblhhitemsB;
         RadioGroup rdogrphhitemsB;
         
         RadioButton rdohhitemsB1;
         RadioButton rdohhitemsB2;
         LinearLayout sechhitemsC;
         View linehhitemsC;
         TextView VlblhhitemsC;
         RadioGroup rdogrphhitemsC;
         
         RadioButton rdohhitemsC1;
         RadioButton rdohhitemsC2;
         LinearLayout sechhitemsD;
         View linehhitemsD;
         TextView VlblhhitemsD;
         RadioGroup rdogrphhitemsD;
         
         RadioButton rdohhitemsD1;
         RadioButton rdohhitemsD2;
         LinearLayout sechhitemsE;
         View linehhitemsE;
         TextView VlblhhitemsE;
         RadioGroup rdogrphhitemsE;
         
         RadioButton rdohhitemsE1;
         RadioButton rdohhitemsE2;
         LinearLayout sechhitemsF;
         View linehhitemsF;
         TextView VlblhhitemsF;
         RadioGroup rdogrphhitemsF;
         
         RadioButton rdohhitemsF1;
         RadioButton rdohhitemsF2;
         LinearLayout sechhitemsG;
         View linehhitemsG;
         TextView VlblhhitemsG;
         RadioGroup rdogrphhitemsG;
         
         RadioButton rdohhitemsG1;
         RadioButton rdohhitemsG2;
         LinearLayout sechhitemsH;
         View linehhitemsH;
         TextView VlblhhitemsH;
         RadioGroup rdogrphhitemsH;
         
         RadioButton rdohhitemsH1;
         RadioButton rdohhitemsH2;
         LinearLayout sechhitemsI;
         View linehhitemsI;
         TextView VlblhhitemsI;
         RadioGroup rdogrphhitemsI;
         
         RadioButton rdohhitemsI1;
         RadioButton rdohhitemsI2;
         LinearLayout secTelevisionNo;
         View lineTelevisionNo;
         TextView VlblTelevisionNo;
         EditText txtTelevisionNo;
         LinearLayout seclbl02;
         View linelbl02;
         LinearLayout sechhfuelA;
         View linehhfuelA;
         TextView VlblhhfuelA;
         RadioGroup rdogrphhfuelA;
         
         RadioButton rdohhfuelA1;
         RadioButton rdohhfuelA2;
         LinearLayout sechhfuelB;
         View linehhfuelB;
         TextView VlblhhfuelB;
         RadioGroup rdogrphhfuelB;
         
         RadioButton rdohhfuelB1;
         RadioButton rdohhfuelB2;
         LinearLayout sechhfuelC;
         View linehhfuelC;
         TextView VlblhhfuelC;
         RadioGroup rdogrphhfuelC;
         
         RadioButton rdohhfuelC1;
         RadioButton rdohhfuelC2;
         LinearLayout sechhfuelD;
         View linehhfuelD;
         TextView VlblhhfuelD;
         RadioGroup rdogrphhfuelD;
         
         RadioButton rdohhfuelD1;
         RadioButton rdohhfuelD2;
         LinearLayout sechhfuelE;
         View linehhfuelE;
         TextView VlblhhfuelE;
         RadioGroup rdogrphhfuelE;
         
         RadioButton rdohhfuelE1;
         RadioButton rdohhfuelE2;
         LinearLayout sechhfuelF;
         View linehhfuelF;
         TextView VlblhhfuelF;
         RadioGroup rdogrphhfuelF;
         
         RadioButton rdohhfuelF1;
         RadioButton rdohhfuelF2;
         LinearLayout sechhfuelG;
         View linehhfuelG;
         TextView VlblhhfuelG;
         RadioGroup rdogrphhfuelG;
         
         RadioButton rdohhfuelG1;
         RadioButton rdohhfuelG2;
         LinearLayout sechhfuelH;
         View linehhfuelH;
         TextView VlblhhfuelH;
         RadioGroup rdogrphhfuelH;
         
         RadioButton rdohhfuelH1;
         RadioButton rdohhfuelH2;
         LinearLayout sechhfuelHOth;
         View linehhfuelHOth;
         TextView VlblhhfuelHOth;
         EditText txthhfuelHOth;
         LinearLayout seclbl03;
         View linelbl03;
         LinearLayout sechhflmatA;
         View linehhflmatA;
         TextView VlblhhflmatA;
         RadioGroup rdogrphhflmatA;
         
         RadioButton rdohhflmatA1;
         RadioButton rdohhflmatA2;
         LinearLayout sechhflmatB;
         View linehhflmatB;
         TextView VlblhhflmatB;
         RadioGroup rdogrphhflmatB;
         
         RadioButton rdohhflmatB1;
         RadioButton rdohhflmatB2;
         LinearLayout sechhflmatC;
         View linehhflmatC;
         TextView VlblhhflmatC;
         RadioGroup rdogrphhflmatC;
         
         RadioButton rdohhflmatC1;
         RadioButton rdohhflmatC2;
         LinearLayout sechhflmatD;
         View linehhflmatD;
         TextView VlblhhflmatD;
         RadioGroup rdogrphhflmatD;
         
         RadioButton rdohhflmatD1;
         RadioButton rdohhflmatD2;
         LinearLayout sechhflmatDOth;
         View linehhflmatDOth;
         TextView VlblhhflmatDOth;
         EditText txthhflmatDOth;
         LinearLayout seclbl04;
         View linelbl04;
         LinearLayout sechhWmatA;
         View linehhWmatA;
         TextView VlblhhWmatA;
         RadioGroup rdogrphhWmatA;
         
         RadioButton rdohhWmatA1;
         RadioButton rdohhWmatA2;
         LinearLayout sechhWmatB;
         View linehhWmatB;
         TextView VlblhhWmatB;
         RadioGroup rdogrphhWmatB;
         
         RadioButton rdohhWmatB1;
         RadioButton rdohhWmatB2;
         LinearLayout sechhWmatC;
         View linehhWmatC;
         TextView VlblhhWmatC;
         RadioGroup rdogrphhWmatC;
         
         RadioButton rdohhWmatC1;
         RadioButton rdohhWmatC2;
         LinearLayout sechhWmatD;
         View linehhWmatD;
         TextView VlblhhWmatD;
         RadioGroup rdogrphhWmatD;
         
         RadioButton rdohhWmatD1;
         RadioButton rdohhWmatD2;
         LinearLayout sechhWmatDOth;
         View linehhWmatDOth;
         TextView VlblhhWmatDOth;
         EditText txthhWmatDOth;
         LinearLayout seclbl05;
         View linelbl05;
         LinearLayout sechhrmatA;
         View linehhrmatA;
         TextView VlblhhrmatA;
         RadioGroup rdogrphhrmatA;
         
         RadioButton rdohhrmatA1;
         RadioButton rdohhrmatA2;
         LinearLayout sechhrmatB;
         View linehhrmatB;
         TextView VlblhhrmatB;
         RadioGroup rdogrphhrmatB;
         
         RadioButton rdohhrmatB1;
         RadioButton rdohhrmatB2;
         LinearLayout sechhrmatC;
         View linehhrmatC;
         TextView VlblhhrmatC;
         RadioGroup rdogrphhrmatC;
         
         RadioButton rdohhrmatC1;
         RadioButton rdohhrmatC2;
         LinearLayout sechhrmatD;
         View linehhrmatD;
         TextView VlblhhrmatD;
         RadioGroup rdogrphhrmatD;
         
         RadioButton rdohhrmatD1;
         RadioButton rdohhrmatD2;
         LinearLayout sechhrmatDOth;
         View linehhrmatDOth;
         TextView VlblhhrmatDOth;
         EditText txthhrmatDOth;
         LinearLayout sechhrooms;
         View linehhrooms;
         TextView Vlblhhrooms;
         EditText txthhrooms;
         LinearLayout seclbl07;
         View linelbl07;
         LinearLayout sechhvehA;
         View linehhvehA;
         TextView VlblhhvehA;
         RadioGroup rdogrphhvehA;
         
         RadioButton rdohhvehA1;
         RadioButton rdohhvehA2;
         LinearLayout sechhvehB;
         View linehhvehB;
         TextView VlblhhvehB;
         RadioGroup rdogrphhvehB;
         
         RadioButton rdohhvehB1;
         RadioButton rdohhvehB2;
         LinearLayout sechhvehC;
         View linehhvehC;
         TextView VlblhhvehC;
         RadioGroup rdogrphhvehC;
         
         RadioButton rdohhvehC1;
         RadioButton rdohhvehC2;
         LinearLayout sechhvehD;
         View linehhvehD;
         TextView VlblhhvehD;
         RadioGroup rdogrphhvehD;
         
         RadioButton rdohhvehD1;
         RadioButton rdohhvehD2;
         LinearLayout sechhvehE;
         View linehhvehE;
         TextView VlblhhvehE;
         RadioGroup rdogrphhvehE;
         
         RadioButton rdohhvehE1;
         RadioButton rdohhvehE2;
         LinearLayout sechhaccount;
         View linehhaccount;
         TextView Vlblhhaccount;
         RadioGroup rdogrphhaccount;
         
         RadioButton rdohhaccount1;
         RadioButton rdohhaccount2;
         LinearLayout seccomments;
         View linecomments;
         TextView Vlblcomments;
         EditText txtcomments;

     LinearLayout seccooking;
     LinearLayout seccookingOth;
     Spinner spncooking;
     EditText txtcookingOth;
     LinearLayout secfloor;
     LinearLayout secfloorOth;
     Spinner spnfloor;
     EditText txtfloorOth;
     LinearLayout secwalls;
     LinearLayout secwallsOth;
     Spinner spnwalls;
     EditText txtwallsOth;
     LinearLayout secroof;
     LinearLayout secroofOth;
     Spinner spnroof;
     EditText txtroofOth;

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
             setContentView(R.layout.recallsurvs5);
         }else {
             if (COUNTRYCODE.equals(ProjectSetting.BANGLADESH))
                 setContentView(R.layout.recallsurvs5_bd);
             else if (COUNTRYCODE.equals(ProjectSetting.NEPAL))
                 setContentView(R.layout.recallsurvs5_np);
             else if (COUNTRYCODE.equals(ProjectSetting.TANZANIA))
                 setContentView(R.layout.recallsurvs5_tz);
             else
                 setContentView(R.layout.recallsurvs5);
         }

         C = new Connection(this);
         g = Global.getInstance();

         STARTTIME = g.CurrentTime24();
         DEVICEID  = sp.getValue(this, "deviceid");
         ENTRYUSER = sp.getValue(this, "userid");

         IDbundle = getIntent().getExtras();
         //COUNTRYCODE = sp.getValue(this, "countrycode");
         FACICODE    = sp.getValue(this, "facicode");
         DATAID = IDbundle.getString("dataid");
         STUDYID = IDbundle.getString("studyid");

         /*IDbundle = getIntent().getExtras();
         COUNTRYCODE = IDbundle.getString("CountryCode");
         FACICODE = IDbundle.getString("FaciCode");
         DATAID = IDbundle.getString("DataId");*/

         TableName = "RecallSurvS5";

         //turnGPSOn();

         //GPS Location
         //FindLocation();
         // Double.toString(currentLatitude);
         // Double.toString(currentLongitude);
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(RecallSurvS5.this);
                 adb.setTitle("Close");
                 adb.setMessage("Do you want to close this form[Yes/No]?");
                 adb.setNegativeButton("No", null);
                 adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                     public void onClick(DialogInterface dialog, int which) {
                         finish();
                     }});
                 adb.show();
             }});

         seccooking=(LinearLayout)findViewById(R.id.seccooking) ;
         seccookingOth=(LinearLayout)findViewById(R.id.seccookingOth) ;
         spncooking=(Spinner)findViewById(R.id.spncooking) ;
         List<String> listcooking = new ArrayList<String>();

         listcooking.add("");
         if(COUNTRYCODE.equals(ProjectSetting.BANGLADESH)){
             listcooking.add("01-বিদ্যুৎ");
             listcooking.add("02-গ্যাস");
             listcooking.add("03-কেরোসিন");
             listcooking.add("04-গোবর");
             listcooking.add("05-চারকোল/ কয়লা");
             listcooking.add("06-কাঠ");
             listcooking.add("07-খানায় রান্না হয় না");
             listcooking.add("97-অন্যান্য");
         }else if(COUNTRYCODE.equals(ProjectSetting.NEPAL)){
             listcooking.add("01-बिजुली");
             listcooking.add("02-ग्याँस");
             listcooking.add("03-मट्टीतेल");
             listcooking.add("04-गोबर");
             listcooking.add("05-कोइला");
             listcooking.add("06-काठ");
             listcooking.add("07-घरमा खाना पकाउने गरेको छैन");
             listcooking.add("97-अन्य खुलाउने");
         }else if(COUNTRYCODE.equals(ProjectSetting.TANZANIA)){
             listcooking.add("01-Umeme");
             listcooking.add("02-Gesi");
             listcooking.add("03-Mafuata ya taa");
             listcooking.add("04-Kinyesi cha wanyama");
             listcooking.add("05-Mkaa/Makaa ya mawe");
             listcooking.add("06-Kuni");
             listcooking.add("07-Hakuna chakula kinachipikwa kwenye kaya");
             listcooking.add("97-Nyingine, taja");
         }else {
             listcooking.add("01-Electricity");
             listcooking.add("02-Gas");
             listcooking.add("03-Kerosine");
             listcooking.add("04-Animal dung");
             listcooking.add("05-Charcoal/coal");
             listcooking.add("06-Wood");
             listcooking.add("07-No food cooked in household");
             listcooking.add("97-Other");
         }

         ArrayAdapter<String> adptrcooking= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listcooking);
         spncooking.setAdapter(adptrcooking);

         txtcookingOth=(EditText)findViewById(R.id.txtcookingOth) ;

         secfloor=(LinearLayout)findViewById(R.id.secfloor) ;
         secfloorOth=(LinearLayout)findViewById(R.id.secfloorOth) ;
         spnfloor=(Spinner)findViewById(R.id.spnfloor) ;
         List<String> listfloor = new ArrayList<String>();

         listfloor.add("");
         if(COUNTRYCODE.equals(ProjectSetting.BANGLADESH)){
             listfloor.add("1-কাঁচা মেঝে যেমন কাদামাটি, মাটি, বালু, গোবর");
             listfloor.add("2-প্রাথমিক পর্যায়ের মেঝে যেমন কাঠ, তাল গাছ/বাঁশ");
             listfloor.add("3-পরিপূর্ণ মেঝে যেমন সিমেন্ট, পালিশকৃত কাঠ, ভিনাইল স্ট্রিপ, টাইলস");
             listfloor.add("7-অন্যান্য যেমন কার্পেট");
         }else if(COUNTRYCODE.equals(ProjectSetting.NEPAL)){
             listfloor.add("1-प्राकृतिक भुईं, जस्तै माटोले लिपेको ,गोबरले लिपेको, बालुवा");
             listfloor.add("2-मौलिक भुईजस्तै दाउरा, काठ, बाँस");
             listfloor.add("3-परिस्कृत (पक्का)  भुई जस्तै सिमेन्ट, रङ्गीन काठ, टाइल");
             listfloor.add("7-अन्य खुलाउने जस्तै (कार्पेट)");
         }else if(COUNTRYCODE.equals(ProjectSetting.TANZANIA)){
             listfloor.add("1-पSakafu ya asili, kama ya uchafu, udongo, mchanga, kinyesi");
             listfloor.add("2-Sakafu maalum kama vile, ya mbao, mianzi");
             listfloor.add("3-Sakafu iliyokamilika, kama vile ya simenti, mbao iliyon’garishwa, yenye mistari maalum, vigae");
             listfloor.add("7-Nyingine, taja, kama vile zulia");
         }else {
             listfloor.add("1-Natural floor, such as dirt, earth, sand, dung");
             listfloor.add("2-Rudimentary floor, such as wood, palm/bamboo");
             listfloor.add("3-Finished floor, such as cement, polished wood, vinyl strips, tiles");
             listfloor.add("7-Other, specify, such as carpet");
         }

         ArrayAdapter<String> adptrfloor= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listfloor);
         spnfloor.setAdapter(adptrfloor);

         txtfloorOth=(EditText)findViewById(R.id.txtfloorOth) ;

         secwalls=(LinearLayout)findViewById(R.id.secwalls) ;
         secwallsOth=(LinearLayout)findViewById(R.id.secwallsOth) ;
         spnwalls=(Spinner)findViewById(R.id.spnwalls) ;
         List<String> listwall = new ArrayList<String>();

         listwall.add("");
         if(COUNTRYCODE.equals(ProjectSetting.BANGLADESH)){
             listwall.add("1-স্বাভাবিক দেয়াল যেমন দেয়াল নাই, কাদামাটি, পাটকাঠি/ বেত/ তাল গাছ/ গাছের গুড়ি");
             listwall.add("2-প্রাথমিক পর্যায়ের দেয়াল যেমন মাটিসহ বাঁশ, মাটিসহ পাথর, প্লাই-উড, কার্ডবোর্ড, পুনঃব্যবহৃত কাঠ");
             listwall.add("3-পরিপূর্ণ দেয়াল যেমন সিমেন্ট, সিমেন্টের ব্লক, ইট, কাঠের তক্তা/ মোজাইক পাথর, পালিশকৃত কাঠ");
             listwall.add("7-অন্যান্য");
         }else if(COUNTRYCODE.equals(ProjectSetting.NEPAL)){
             listwall.add("1-प्राकृतिक  भित्ता, भित्ता नभएको, वेत,माटो, छडि, रुखको बोक्रा");
             listwall.add("2-मौलिक भित्ता जस्तै बाँस र माटो , ढुङ्गा र माटो , प्लाइ ऊड , कार्डबोर्ड , पुरानो (पुन: प्रयोगगरेको) काठ");
             listwall.add("3-परिस्कृत (पक्का) भित्ता जस्तै सिमेन्टले बनेको, सीमेन्ट ब्लक, इट्ट्टाले बनेको, रङ्गीन काठ , काठको फल्याक");
             listwall.add("7-अन्य खुलाउने");
         }else if(COUNTRYCODE.equals(ProjectSetting.TANZANIA)){
             listwall.add("1-Kuta halisi, kama vile, kutokuwa na kuta, chafu, miwa/miti/mashina");
             listwall.add("2-Kuta maalum, kama vile za mianzi na udongo, mawe na udongo, kuta za mbao nyepesi, mbao ngumu, mbao zilizotumika");
             listwall.add("3-Kuta zilizotumika, kama vile sementi, vigingi vya simenti, mbao nyembamba, mbao zilizo ng’arishwa");
             listwall.add("7-Nyingine, taja");
         }else {
             listwall.add("1-Natural walls, such as no walls, dirt, cane/palm/trunks");
             listwall.add("2-Rudimentary walls, such as bamboo with mud, stone with mud, plywood, cardboard, reused wood");
             listwall.add("3-Finished walls, such as cement, cement blocks, wood planks/shingles, polished wood");
             listwall.add("7-Other");
         }

         ArrayAdapter<String> adptrwall= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listwall);
         spnwalls.setAdapter(adptrwall);


         txtwallsOth=(EditText)findViewById(R.id.txtwallsOth) ;

         secroof=(LinearLayout)findViewById(R.id.secroof) ;
         secroofOth=(LinearLayout)findViewById(R.id.secroofOth) ;
         spnroof=(Spinner)findViewById(R.id.spnroof) ;
         List<String> listroof = new ArrayList<String>();

         listroof.add("");
         if(COUNTRYCODE.equals(ProjectSetting.BANGLADESH)){
             listroof.add("1-স্বাভাবিক ছাদ যেমন ছাদ নাই, খড়/ছন/তালপাতা, ঘাস");
             listroof.add("2-কাঁচা ছাদ যেমন কাঠ, কার্ডবোর্ড, তাল গাছ/বাঁশ");
             listroof.add("3-পরিপূর্ণ ছাদ যেমন ধাতু, লোহার দন্ড, টালি, টাইলস, সিমেন্ট");
             listroof.add("7-অন্যান্য");
         }else if(COUNTRYCODE.equals(ProjectSetting.NEPAL)){
             listroof.add("1-प्राकृतिक छानो जस्तै छानो नभएको , फुसको ( पराल, छवालि, खर, स्याउला)");
             listroof.add("2-मौलिक छानो जस्तै गुन्द्रि/मान्द्रो , बाँस फल्याक/ काठ");
             listroof.add("3-परिस्कृत (पक्का) छानो जस्तै ढुङ्गा र  सिमेन्ट,  फलाम,  टायल,  ईटा");
             listroof.add("7-अन्य खुलाउने");
         }else if(COUNTRYCODE.equals(ProjectSetting.TANZANIA)){
             listroof.add("1-Paa ya asili, kama vile hakuna paa, paa ya nyasi, udongo");
             listroof.add("2-Paa maalumu, kama vile ya mbao, paa ya kawaida, paa ya mbao laini, paa ya mianzi");
             listroof.add("3-Paa iliyokamilika, kama vile chuma, paa ya mabati, paa ya vigae, paa ya simenti");
             listroof.add("7-Nyingine, taja");
         }else {
             listroof.add("1-Natural roofing, such as no roof, thatch/palm leaf, sod");
             listroof.add("2-Rudimentary roofing, such as wood, rustic mat, cardboard, palm/bamboo");
             listroof.add("3-Finished roofing, such as metal, iron sheets, shingles, tiles, cement");
             listroof.add("7-Other");
         }
         ArrayAdapter<String> adptrroof= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listroof);
         spnroof.setAdapter(adptrroof);


         txtroofOth=(EditText)findViewById(R.id.txtroofOth) ;

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
         secDataId=(LinearLayout)findViewById(R.id.secDataId);
         lineDataId=(View)findViewById(R.id.lineDataId);
         VlblDataId=(TextView) findViewById(R.id.VlblDataId);
         txtDataId=(EditText) findViewById(R.id.txtDataId);
         txtDataId.setText(DATAID);
         secStudyID=(LinearLayout)findViewById(R.id.secStudyID);
         lineStudyID=(View)findViewById(R.id.lineStudyID);
         VlblStudyID=(TextView) findViewById(R.id.VlblStudyID);
         txtStudyID=(EditText) findViewById(R.id.txtStudyID);
         txtStudyID.setText(STUDYID);
         seclblSecV=(LinearLayout)findViewById(R.id.seclblSecV);
         linelblSecV=(View)findViewById(R.id.linelblSecV);
         seclbl01=(LinearLayout)findViewById(R.id.seclbl01);
         linelbl01=(View)findViewById(R.id.linelbl01);
         sechhitemsA=(LinearLayout)findViewById(R.id.sechhitemsA);
         linehhitemsA=(View)findViewById(R.id.linehhitemsA);
         VlblhhitemsA = (TextView) findViewById(R.id.VlblhhitemsA);
         rdogrphhitemsA = (RadioGroup) findViewById(R.id.rdogrphhitemsA);
         
         rdohhitemsA1 = (RadioButton) findViewById(R.id.rdohhitemsA1);
         rdohhitemsA2 = (RadioButton) findViewById(R.id.rdohhitemsA2);
         sechhitemsB=(LinearLayout)findViewById(R.id.sechhitemsB);
         linehhitemsB=(View)findViewById(R.id.linehhitemsB);
         VlblhhitemsB = (TextView) findViewById(R.id.VlblhhitemsB);
         rdogrphhitemsB = (RadioGroup) findViewById(R.id.rdogrphhitemsB);
         
         rdohhitemsB1 = (RadioButton) findViewById(R.id.rdohhitemsB1);
         rdohhitemsB2 = (RadioButton) findViewById(R.id.rdohhitemsB2);
         sechhitemsC=(LinearLayout)findViewById(R.id.sechhitemsC);
         linehhitemsC=(View)findViewById(R.id.linehhitemsC);
         VlblhhitemsC = (TextView) findViewById(R.id.VlblhhitemsC);
         rdogrphhitemsC = (RadioGroup) findViewById(R.id.rdogrphhitemsC);
         
         rdohhitemsC1 = (RadioButton) findViewById(R.id.rdohhitemsC1);
         rdohhitemsC2 = (RadioButton) findViewById(R.id.rdohhitemsC2);
         sechhitemsD=(LinearLayout)findViewById(R.id.sechhitemsD);
         linehhitemsD=(View)findViewById(R.id.linehhitemsD);
         VlblhhitemsD = (TextView) findViewById(R.id.VlblhhitemsD);
         rdogrphhitemsD = (RadioGroup) findViewById(R.id.rdogrphhitemsD);
         
         rdohhitemsD1 = (RadioButton) findViewById(R.id.rdohhitemsD1);
         rdohhitemsD2 = (RadioButton) findViewById(R.id.rdohhitemsD2);
         sechhitemsE=(LinearLayout)findViewById(R.id.sechhitemsE);
         linehhitemsE=(View)findViewById(R.id.linehhitemsE);
         VlblhhitemsE = (TextView) findViewById(R.id.VlblhhitemsE);
         rdogrphhitemsE = (RadioGroup) findViewById(R.id.rdogrphhitemsE);
         
         rdohhitemsE1 = (RadioButton) findViewById(R.id.rdohhitemsE1);
         rdohhitemsE2 = (RadioButton) findViewById(R.id.rdohhitemsE2);
         sechhitemsF=(LinearLayout)findViewById(R.id.sechhitemsF);
         linehhitemsF=(View)findViewById(R.id.linehhitemsF);
         VlblhhitemsF = (TextView) findViewById(R.id.VlblhhitemsF);
         rdogrphhitemsF = (RadioGroup) findViewById(R.id.rdogrphhitemsF);
         
         rdohhitemsF1 = (RadioButton) findViewById(R.id.rdohhitemsF1);
         rdohhitemsF2 = (RadioButton) findViewById(R.id.rdohhitemsF2);
         sechhitemsG=(LinearLayout)findViewById(R.id.sechhitemsG);
         linehhitemsG=(View)findViewById(R.id.linehhitemsG);
         VlblhhitemsG = (TextView) findViewById(R.id.VlblhhitemsG);
         rdogrphhitemsG = (RadioGroup) findViewById(R.id.rdogrphhitemsG);
         
         rdohhitemsG1 = (RadioButton) findViewById(R.id.rdohhitemsG1);
         rdohhitemsG2 = (RadioButton) findViewById(R.id.rdohhitemsG2);
         sechhitemsH=(LinearLayout)findViewById(R.id.sechhitemsH);
         linehhitemsH=(View)findViewById(R.id.linehhitemsH);
         VlblhhitemsH = (TextView) findViewById(R.id.VlblhhitemsH);
         rdogrphhitemsH = (RadioGroup) findViewById(R.id.rdogrphhitemsH);
         
         rdohhitemsH1 = (RadioButton) findViewById(R.id.rdohhitemsH1);
         rdohhitemsH2 = (RadioButton) findViewById(R.id.rdohhitemsH2);
         sechhitemsI=(LinearLayout)findViewById(R.id.sechhitemsI);
         linehhitemsI=(View)findViewById(R.id.linehhitemsI);
         VlblhhitemsI = (TextView) findViewById(R.id.VlblhhitemsI);
         rdogrphhitemsI = (RadioGroup) findViewById(R.id.rdogrphhitemsI);
         
         rdohhitemsI1 = (RadioButton) findViewById(R.id.rdohhitemsI1);
         rdohhitemsI2 = (RadioButton) findViewById(R.id.rdohhitemsI2);
         secTelevisionNo=(LinearLayout)findViewById(R.id.secTelevisionNo);
         lineTelevisionNo=(View)findViewById(R.id.lineTelevisionNo);
         VlblTelevisionNo=(TextView) findViewById(R.id.VlblTelevisionNo);
         txtTelevisionNo=(EditText) findViewById(R.id.txtTelevisionNo);
         seclbl02=(LinearLayout)findViewById(R.id.seclbl02);
         linelbl02=(View)findViewById(R.id.linelbl02);
         sechhfuelA=(LinearLayout)findViewById(R.id.sechhfuelA);
         linehhfuelA=(View)findViewById(R.id.linehhfuelA);
         VlblhhfuelA = (TextView) findViewById(R.id.VlblhhfuelA);
         rdogrphhfuelA = (RadioGroup) findViewById(R.id.rdogrphhfuelA);
         
         rdohhfuelA1 = (RadioButton) findViewById(R.id.rdohhfuelA1);
         rdohhfuelA2 = (RadioButton) findViewById(R.id.rdohhfuelA2);
         sechhfuelB=(LinearLayout)findViewById(R.id.sechhfuelB);
         linehhfuelB=(View)findViewById(R.id.linehhfuelB);
         VlblhhfuelB = (TextView) findViewById(R.id.VlblhhfuelB);
         rdogrphhfuelB = (RadioGroup) findViewById(R.id.rdogrphhfuelB);
         
         rdohhfuelB1 = (RadioButton) findViewById(R.id.rdohhfuelB1);
         rdohhfuelB2 = (RadioButton) findViewById(R.id.rdohhfuelB2);
         sechhfuelC=(LinearLayout)findViewById(R.id.sechhfuelC);
         linehhfuelC=(View)findViewById(R.id.linehhfuelC);
         VlblhhfuelC = (TextView) findViewById(R.id.VlblhhfuelC);
         rdogrphhfuelC = (RadioGroup) findViewById(R.id.rdogrphhfuelC);
         
         rdohhfuelC1 = (RadioButton) findViewById(R.id.rdohhfuelC1);
         rdohhfuelC2 = (RadioButton) findViewById(R.id.rdohhfuelC2);
         sechhfuelD=(LinearLayout)findViewById(R.id.sechhfuelD);
         linehhfuelD=(View)findViewById(R.id.linehhfuelD);
         VlblhhfuelD = (TextView) findViewById(R.id.VlblhhfuelD);
         rdogrphhfuelD = (RadioGroup) findViewById(R.id.rdogrphhfuelD);
         
         rdohhfuelD1 = (RadioButton) findViewById(R.id.rdohhfuelD1);
         rdohhfuelD2 = (RadioButton) findViewById(R.id.rdohhfuelD2);
         sechhfuelE=(LinearLayout)findViewById(R.id.sechhfuelE);
         linehhfuelE=(View)findViewById(R.id.linehhfuelE);
         VlblhhfuelE = (TextView) findViewById(R.id.VlblhhfuelE);
         rdogrphhfuelE = (RadioGroup) findViewById(R.id.rdogrphhfuelE);
         
         rdohhfuelE1 = (RadioButton) findViewById(R.id.rdohhfuelE1);
         rdohhfuelE2 = (RadioButton) findViewById(R.id.rdohhfuelE2);
         sechhfuelF=(LinearLayout)findViewById(R.id.sechhfuelF);
         linehhfuelF=(View)findViewById(R.id.linehhfuelF);
         VlblhhfuelF = (TextView) findViewById(R.id.VlblhhfuelF);
         rdogrphhfuelF = (RadioGroup) findViewById(R.id.rdogrphhfuelF);
         
         rdohhfuelF1 = (RadioButton) findViewById(R.id.rdohhfuelF1);
         rdohhfuelF2 = (RadioButton) findViewById(R.id.rdohhfuelF2);
         sechhfuelG=(LinearLayout)findViewById(R.id.sechhfuelG);
         linehhfuelG=(View)findViewById(R.id.linehhfuelG);
         VlblhhfuelG = (TextView) findViewById(R.id.VlblhhfuelG);
         rdogrphhfuelG = (RadioGroup) findViewById(R.id.rdogrphhfuelG);
         
         rdohhfuelG1 = (RadioButton) findViewById(R.id.rdohhfuelG1);
         rdohhfuelG2 = (RadioButton) findViewById(R.id.rdohhfuelG2);
         sechhfuelH=(LinearLayout)findViewById(R.id.sechhfuelH);
         linehhfuelH=(View)findViewById(R.id.linehhfuelH);
         VlblhhfuelH = (TextView) findViewById(R.id.VlblhhfuelH);
         rdogrphhfuelH = (RadioGroup) findViewById(R.id.rdogrphhfuelH);
         
         rdohhfuelH1 = (RadioButton) findViewById(R.id.rdohhfuelH1);
         rdohhfuelH2 = (RadioButton) findViewById(R.id.rdohhfuelH2);
         rdogrphhfuelH.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrphhfuelH = new String[] {"1","2"};
             for (int i = 0; i < rdogrphhfuelH.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrphhfuelH.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrphhfuelH[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    sechhfuelHOth.setVisibility(View.GONE);
                    linehhfuelHOth.setVisibility(View.GONE);
                    txthhfuelHOth.setText("");
                    //seclbl03.setVisibility(View.GONE);
                    //linelbl03.setVisibility(View.GONE);
             }
             else
             {
                    sechhfuelHOth.setVisibility(View.VISIBLE);
                    linehhfuelHOth.setVisibility(View.VISIBLE);
                    //seclbl03.setVisibility(View.VISIBLE);
                    //linelbl03.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         sechhfuelHOth=(LinearLayout)findViewById(R.id.sechhfuelHOth);
         linehhfuelHOth=(View)findViewById(R.id.linehhfuelHOth);
         VlblhhfuelHOth=(TextView) findViewById(R.id.VlblhhfuelHOth);
         txthhfuelHOth=(EditText) findViewById(R.id.txthhfuelHOth);
         seclbl03=(LinearLayout)findViewById(R.id.seclbl03);
         linelbl03=(View)findViewById(R.id.linelbl03);
         sechhflmatA=(LinearLayout)findViewById(R.id.sechhflmatA);
         linehhflmatA=(View)findViewById(R.id.linehhflmatA);
         VlblhhflmatA = (TextView) findViewById(R.id.VlblhhflmatA);
         rdogrphhflmatA = (RadioGroup) findViewById(R.id.rdogrphhflmatA);
         
         rdohhflmatA1 = (RadioButton) findViewById(R.id.rdohhflmatA1);
         rdohhflmatA2 = (RadioButton) findViewById(R.id.rdohhflmatA2);
         sechhflmatB=(LinearLayout)findViewById(R.id.sechhflmatB);
         linehhflmatB=(View)findViewById(R.id.linehhflmatB);
         VlblhhflmatB = (TextView) findViewById(R.id.VlblhhflmatB);
         rdogrphhflmatB = (RadioGroup) findViewById(R.id.rdogrphhflmatB);
         
         rdohhflmatB1 = (RadioButton) findViewById(R.id.rdohhflmatB1);
         rdohhflmatB2 = (RadioButton) findViewById(R.id.rdohhflmatB2);
         sechhflmatC=(LinearLayout)findViewById(R.id.sechhflmatC);
         linehhflmatC=(View)findViewById(R.id.linehhflmatC);
         VlblhhflmatC = (TextView) findViewById(R.id.VlblhhflmatC);
         rdogrphhflmatC = (RadioGroup) findViewById(R.id.rdogrphhflmatC);
         
         rdohhflmatC1 = (RadioButton) findViewById(R.id.rdohhflmatC1);
         rdohhflmatC2 = (RadioButton) findViewById(R.id.rdohhflmatC2);
         sechhflmatD=(LinearLayout)findViewById(R.id.sechhflmatD);
         linehhflmatD=(View)findViewById(R.id.linehhflmatD);
         VlblhhflmatD = (TextView) findViewById(R.id.VlblhhflmatD);
         rdogrphhflmatD = (RadioGroup) findViewById(R.id.rdogrphhflmatD);
         
         rdohhflmatD1 = (RadioButton) findViewById(R.id.rdohhflmatD1);
         rdohhflmatD2 = (RadioButton) findViewById(R.id.rdohhflmatD2);
         rdogrphhflmatD.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrphhflmatD = new String[] {"1","2"};
             for (int i = 0; i < rdogrphhflmatD.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrphhflmatD.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrphhflmatD[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    sechhflmatDOth.setVisibility(View.GONE);
                    linehhflmatDOth.setVisibility(View.GONE);
                    txthhflmatDOth.setText("");
                    //seclbl04.setVisibility(View.GONE);
                    //linelbl04.setVisibility(View.GONE);
             }
             else
             {
                    sechhflmatDOth.setVisibility(View.VISIBLE);
                    linehhflmatDOth.setVisibility(View.VISIBLE);
                    //seclbl04.setVisibility(View.VISIBLE);
                    //linelbl04.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         sechhflmatDOth=(LinearLayout)findViewById(R.id.sechhflmatDOth);
         linehhflmatDOth=(View)findViewById(R.id.linehhflmatDOth);
         VlblhhflmatDOth=(TextView) findViewById(R.id.VlblhhflmatDOth);
         txthhflmatDOth=(EditText) findViewById(R.id.txthhflmatDOth);
         seclbl04=(LinearLayout)findViewById(R.id.seclbl04);
         linelbl04=(View)findViewById(R.id.linelbl04);
         sechhWmatA=(LinearLayout)findViewById(R.id.sechhWmatA);
         linehhWmatA=(View)findViewById(R.id.linehhWmatA);
         VlblhhWmatA = (TextView) findViewById(R.id.VlblhhWmatA);
         rdogrphhWmatA = (RadioGroup) findViewById(R.id.rdogrphhWmatA);
         
         rdohhWmatA1 = (RadioButton) findViewById(R.id.rdohhWmatA1);
         rdohhWmatA2 = (RadioButton) findViewById(R.id.rdohhWmatA2);
         sechhWmatB=(LinearLayout)findViewById(R.id.sechhWmatB);
         linehhWmatB=(View)findViewById(R.id.linehhWmatB);
         VlblhhWmatB = (TextView) findViewById(R.id.VlblhhWmatB);
         rdogrphhWmatB = (RadioGroup) findViewById(R.id.rdogrphhWmatB);
         
         rdohhWmatB1 = (RadioButton) findViewById(R.id.rdohhWmatB1);
         rdohhWmatB2 = (RadioButton) findViewById(R.id.rdohhWmatB2);
         sechhWmatC=(LinearLayout)findViewById(R.id.sechhWmatC);
         linehhWmatC=(View)findViewById(R.id.linehhWmatC);
         VlblhhWmatC = (TextView) findViewById(R.id.VlblhhWmatC);
         rdogrphhWmatC = (RadioGroup) findViewById(R.id.rdogrphhWmatC);
         
         rdohhWmatC1 = (RadioButton) findViewById(R.id.rdohhWmatC1);
         rdohhWmatC2 = (RadioButton) findViewById(R.id.rdohhWmatC2);
         sechhWmatD=(LinearLayout)findViewById(R.id.sechhWmatD);
         linehhWmatD=(View)findViewById(R.id.linehhWmatD);
         VlblhhWmatD = (TextView) findViewById(R.id.VlblhhWmatD);
         rdogrphhWmatD = (RadioGroup) findViewById(R.id.rdogrphhWmatD);
         
         rdohhWmatD1 = (RadioButton) findViewById(R.id.rdohhWmatD1);
         rdohhWmatD2 = (RadioButton) findViewById(R.id.rdohhWmatD2);
         rdogrphhWmatD.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrphhWmatD = new String[] {"1","2"};
             for (int i = 0; i < rdogrphhWmatD.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrphhWmatD.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrphhWmatD[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    sechhWmatDOth.setVisibility(View.GONE);
                    linehhWmatDOth.setVisibility(View.GONE);
                    txthhWmatDOth.setText("");
                    //seclbl05.setVisibility(View.GONE);
                    //linelbl05.setVisibility(View.GONE);
             }
             else
             {
                    sechhWmatDOth.setVisibility(View.VISIBLE);
                    linehhWmatDOth.setVisibility(View.VISIBLE);
                    //seclbl05.setVisibility(View.VISIBLE);
                    //linelbl05.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         sechhWmatDOth=(LinearLayout)findViewById(R.id.sechhWmatDOth);
         linehhWmatDOth=(View)findViewById(R.id.linehhWmatDOth);
         VlblhhWmatDOth=(TextView) findViewById(R.id.VlblhhWmatDOth);
         txthhWmatDOth=(EditText) findViewById(R.id.txthhWmatDOth);
         seclbl05=(LinearLayout)findViewById(R.id.seclbl05);
         linelbl05=(View)findViewById(R.id.linelbl05);
         sechhrmatA=(LinearLayout)findViewById(R.id.sechhrmatA);
         linehhrmatA=(View)findViewById(R.id.linehhrmatA);
         VlblhhrmatA = (TextView) findViewById(R.id.VlblhhrmatA);
         rdogrphhrmatA = (RadioGroup) findViewById(R.id.rdogrphhrmatA);
         
         rdohhrmatA1 = (RadioButton) findViewById(R.id.rdohhrmatA1);
         rdohhrmatA2 = (RadioButton) findViewById(R.id.rdohhrmatA2);
         sechhrmatB=(LinearLayout)findViewById(R.id.sechhrmatB);
         linehhrmatB=(View)findViewById(R.id.linehhrmatB);
         VlblhhrmatB = (TextView) findViewById(R.id.VlblhhrmatB);
         rdogrphhrmatB = (RadioGroup) findViewById(R.id.rdogrphhrmatB);
         
         rdohhrmatB1 = (RadioButton) findViewById(R.id.rdohhrmatB1);
         rdohhrmatB2 = (RadioButton) findViewById(R.id.rdohhrmatB2);
         sechhrmatC=(LinearLayout)findViewById(R.id.sechhrmatC);
         linehhrmatC=(View)findViewById(R.id.linehhrmatC);
         VlblhhrmatC = (TextView) findViewById(R.id.VlblhhrmatC);
         rdogrphhrmatC = (RadioGroup) findViewById(R.id.rdogrphhrmatC);
         
         rdohhrmatC1 = (RadioButton) findViewById(R.id.rdohhrmatC1);
         rdohhrmatC2 = (RadioButton) findViewById(R.id.rdohhrmatC2);
         sechhrmatD=(LinearLayout)findViewById(R.id.sechhrmatD);
         linehhrmatD=(View)findViewById(R.id.linehhrmatD);
         VlblhhrmatD = (TextView) findViewById(R.id.VlblhhrmatD);
         rdogrphhrmatD = (RadioGroup) findViewById(R.id.rdogrphhrmatD);
         
         rdohhrmatD1 = (RadioButton) findViewById(R.id.rdohhrmatD1);
         rdohhrmatD2 = (RadioButton) findViewById(R.id.rdohhrmatD2);
         rdogrphhrmatD.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrphhrmatD = new String[] {"1","2"};
             for (int i = 0; i < rdogrphhrmatD.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrphhrmatD.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrphhrmatD[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    sechhrmatDOth.setVisibility(View.GONE);
                    //linehhrmatDOth.setVisibility(View.GONE);
                    txthhrmatDOth.setText("");
             }
             else
             {
                    sechhrmatDOth.setVisibility(View.VISIBLE);
                    linehhrmatDOth.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         sechhrmatDOth=(LinearLayout)findViewById(R.id.sechhrmatDOth);
         linehhrmatDOth=(View)findViewById(R.id.linehhrmatDOth);
         VlblhhrmatDOth=(TextView) findViewById(R.id.VlblhhrmatDOth);
         txthhrmatDOth=(EditText) findViewById(R.id.txthhrmatDOth);
         sechhrooms=(LinearLayout)findViewById(R.id.sechhrooms);
         linehhrooms=(View)findViewById(R.id.linehhrooms);
         Vlblhhrooms=(TextView) findViewById(R.id.Vlblhhrooms);
         txthhrooms=(EditText) findViewById(R.id.txthhrooms);
         seclbl07=(LinearLayout)findViewById(R.id.seclbl07);
         linelbl07=(View)findViewById(R.id.linelbl07);
         sechhvehA=(LinearLayout)findViewById(R.id.sechhvehA);
         linehhvehA=(View)findViewById(R.id.linehhvehA);
         VlblhhvehA = (TextView) findViewById(R.id.VlblhhvehA);
         rdogrphhvehA = (RadioGroup) findViewById(R.id.rdogrphhvehA);
         
         rdohhvehA1 = (RadioButton) findViewById(R.id.rdohhvehA1);
         rdohhvehA2 = (RadioButton) findViewById(R.id.rdohhvehA2);
         sechhvehB=(LinearLayout)findViewById(R.id.sechhvehB);
         linehhvehB=(View)findViewById(R.id.linehhvehB);
         VlblhhvehB = (TextView) findViewById(R.id.VlblhhvehB);
         rdogrphhvehB = (RadioGroup) findViewById(R.id.rdogrphhvehB);
         
         rdohhvehB1 = (RadioButton) findViewById(R.id.rdohhvehB1);
         rdohhvehB2 = (RadioButton) findViewById(R.id.rdohhvehB2);
         sechhvehC=(LinearLayout)findViewById(R.id.sechhvehC);
         linehhvehC=(View)findViewById(R.id.linehhvehC);
         VlblhhvehC = (TextView) findViewById(R.id.VlblhhvehC);
         rdogrphhvehC = (RadioGroup) findViewById(R.id.rdogrphhvehC);
         
         rdohhvehC1 = (RadioButton) findViewById(R.id.rdohhvehC1);
         rdohhvehC2 = (RadioButton) findViewById(R.id.rdohhvehC2);
         sechhvehD=(LinearLayout)findViewById(R.id.sechhvehD);
         linehhvehD=(View)findViewById(R.id.linehhvehD);
         VlblhhvehD = (TextView) findViewById(R.id.VlblhhvehD);
         rdogrphhvehD = (RadioGroup) findViewById(R.id.rdogrphhvehD);
         
         rdohhvehD1 = (RadioButton) findViewById(R.id.rdohhvehD1);
         rdohhvehD2 = (RadioButton) findViewById(R.id.rdohhvehD2);
         sechhvehE=(LinearLayout)findViewById(R.id.sechhvehE);
         linehhvehE=(View)findViewById(R.id.linehhvehE);
         VlblhhvehE = (TextView) findViewById(R.id.VlblhhvehE);
         rdogrphhvehE = (RadioGroup) findViewById(R.id.rdogrphhvehE);
         
         rdohhvehE1 = (RadioButton) findViewById(R.id.rdohhvehE1);
         rdohhvehE2 = (RadioButton) findViewById(R.id.rdohhvehE2);
         sechhaccount=(LinearLayout)findViewById(R.id.sechhaccount);
         linehhaccount=(View)findViewById(R.id.linehhaccount);
         Vlblhhaccount = (TextView) findViewById(R.id.Vlblhhaccount);
         rdogrphhaccount = (RadioGroup) findViewById(R.id.rdogrphhaccount);
         
         rdohhaccount1 = (RadioButton) findViewById(R.id.rdohhaccount1);
         rdohhaccount2 = (RadioButton) findViewById(R.id.rdohhaccount2);
         seccomments=(LinearLayout)findViewById(R.id.seccomments);
         linecomments=(View)findViewById(R.id.linecomments);
         Vlblcomments=(TextView) findViewById(R.id.Vlblcomments);
         txtcomments=(EditText) findViewById(R.id.txtcomments);


         rdogrphhitemsD.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
             @Override
             public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
                 if(rdohhitemsD1.isChecked()){
                     secTelevisionNo.setVisibility(View.VISIBLE);
                 }else{
                     secTelevisionNo.setVisibility(View.GONE);
                     txtTelevisionNo.setText("");
                 }
             }
             public void onNothingSelected(AdapterView<?> adapterView) {
                 return;
             }
         });

         spncooking.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
         @Override
         public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
             if(spncooking.getSelectedItemPosition()==0) return;
             if(spncooking.getSelectedItem().toString().split("-")[0].equals("97")){
                 seccookingOth.setVisibility(View.VISIBLE);
             }else{
                 seccookingOth.setVisibility(View.GONE);
                 txtcookingOth.setText("");
             }
         }

         @Override
         public void onNothingSelected(AdapterView<?> parentView) {
             // your code here
         }

        });

         spnfloor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                 if(spnfloor.getSelectedItemPosition()==0) return;
                 if(spnfloor.getSelectedItem().toString().split("-")[0].equals("7")){
                     secfloorOth.setVisibility(View.VISIBLE);
                 }else{
                     secfloorOth.setVisibility(View.GONE);
                     txtfloorOth.setText("");
                 }
             }

             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
                 // your code here
             }

         });
         spnwalls.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                 if(spnwalls.getSelectedItemPosition()==0) return;
                 if(spnwalls.getSelectedItem().toString().split("-")[0].equals("7")){
                     secwallsOth.setVisibility(View.VISIBLE);
                 }else{
                     secwallsOth.setVisibility(View.GONE);
                     txtwallsOth.setText("");
                 }
             }

             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
                 // your code here
             }

         });

         spnroof.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                 if(spnroof.getSelectedItemPosition()==0) return;
                 if(spnroof.getSelectedItem().toString().split("-")[0].equals("7")){
                     secroofOth.setVisibility(View.VISIBLE);
                 }else{
                     secroofOth.setVisibility(View.GONE);
                     txtroofOth.setText("");
                 }
             }

             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
                 // your code here
             }

         });


         //Hide all skip variables
         sechhfuelHOth.setVisibility(View.GONE);
         linehhfuelHOth.setVisibility(View.GONE);
         //seclbl03.setVisibility(View.GONE);
         //linelbl03.setVisibility(View.GONE);
         sechhflmatDOth.setVisibility(View.GONE);
         linehhflmatDOth.setVisibility(View.GONE);
         //seclbl04.setVisibility(View.GONE);
         linelbl04.setVisibility(View.GONE);
         sechhWmatDOth.setVisibility(View.GONE);
         linehhWmatDOth.setVisibility(View.GONE);
         //seclbl05.setVisibility(View.GONE);
         //linelbl05.setVisibility(View.GONE);
         sechhrmatDOth.setVisibility(View.GONE);
         //linehhrmatDOth.setVisibility(View.GONE);
         secTelevisionNo.setVisibility(View.GONE);

         seccookingOth.setVisibility(View.GONE);
         secfloorOth.setVisibility(View.GONE);
         secwallsOth.setVisibility(View.GONE);
         secroofOth.setVisibility(View.GONE);

         DataSearch(COUNTRYCODE,FACICODE,DATAID);
        Button cmdSave = (Button) findViewById(R.id.cmdSave);
        cmdSave.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) { 
            DataSave();
        }});
     }
     catch(Exception  e)
     {
         Connection.MessageBox(RecallSurvS5.this, e.getMessage());
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
             Connection.MessageBox(RecallSurvS5.this, "Required field: CountryCode.");
             txtCountryCode.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtCountryCode.getText().toString().length()==0 ? "1" : txtCountryCode.getText().toString()) < 1 || Integer.valueOf(txtCountryCode.getText().toString().length()==0 ? "3" : txtCountryCode.getText().toString()) > 3)
           {
             Connection.MessageBox(RecallSurvS5.this, "Value should be between 1 and 3(CountryCode).");
             txtCountryCode.requestFocus(); 
             return;	
           }
         else if(txtFaciCode.getText().toString().length()==0 & secFaciCode.isShown())
           {
             Connection.MessageBox(RecallSurvS5.this, "Required field: FaciCode.");
             txtFaciCode.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtFaciCode.getText().toString().length()==0 ? "1" : txtFaciCode.getText().toString()) < 1 || Integer.valueOf(txtFaciCode.getText().toString().length()==0 ? "9" : txtFaciCode.getText().toString()) > 9)
           {
             Connection.MessageBox(RecallSurvS5.this, "Value should be between 1 and 9(FaciCode).");
             txtFaciCode.requestFocus(); 
             return;	
           }
         else if(txtDataId.getText().toString().length()==0 & secDataId.isShown())
           {
             Connection.MessageBox(RecallSurvS5.this, "Required field: DataId.");
             txtDataId.requestFocus(); 
             return;	
           }
         else if(txtStudyID.getText().toString().length()==0 & secStudyID.isShown())
           {
             Connection.MessageBox(RecallSurvS5.this, "Required field: ParticipantID.");
             txtStudyID.requestFocus(); 
             return;	
           }
         
         else if(!rdohhitemsA1.isChecked() & !rdohhitemsA2.isChecked() & sechhitemsA.isShown())
           {
              Connection.MessageBox(RecallSurvS5.this, "Select anyone options from (a) Electricity).");
              rdohhitemsA1.requestFocus();
              return;
           }
         
         else if(!rdohhitemsB1.isChecked() & !rdohhitemsB2.isChecked() & sechhitemsB.isShown())
           {
              Connection.MessageBox(RecallSurvS5.this, "Select anyone options from (b) Refrigerator).");
              rdohhitemsB1.requestFocus();
              return;
           }
         
         else if(!rdohhitemsC1.isChecked() & !rdohhitemsC2.isChecked() & sechhitemsC.isShown())
           {
              Connection.MessageBox(RecallSurvS5.this, "Select anyone options from (c) Radio).");
              rdohhitemsC1.requestFocus();
              return;
           }
         
         else if(!rdohhitemsD1.isChecked() & !rdohhitemsD2.isChecked() & sechhitemsD.isShown())
           {
              Connection.MessageBox(RecallSurvS5.this, "Select anyone options from (d) Television).");
              rdohhitemsD1.requestFocus();
              return;
           }
         
         else if(!rdohhitemsE1.isChecked() & !rdohhitemsE2.isChecked() & sechhitemsE.isShown())
           {
              Connection.MessageBox(RecallSurvS5.this, "Select anyone options from (e) Table).");
              rdohhitemsE1.requestFocus();
              return;
           }
         
         else if(!rdohhitemsF1.isChecked() & !rdohhitemsF2.isChecked() & sechhitemsF.isShown())
           {
              Connection.MessageBox(RecallSurvS5.this, "Select anyone options from (f) Chair).");
              rdohhitemsF1.requestFocus();
              return;
           }
         
         else if(!rdohhitemsG1.isChecked() & !rdohhitemsG2.isChecked() & sechhitemsG.isShown())
           {
              Connection.MessageBox(RecallSurvS5.this, "Select anyone options from (g) Bed).");
              rdohhitemsG1.requestFocus();
              return;
           }
         
         else if(!rdohhitemsH1.isChecked() & !rdohhitemsH2.isChecked() & sechhitemsH.isShown())
           {
              Connection.MessageBox(RecallSurvS5.this, "Select anyone options from (h) Computer).");
              rdohhitemsH1.requestFocus();
              return;
           }
         
         else if(!rdohhitemsI1.isChecked() & !rdohhitemsI2.isChecked() & sechhitemsI.isShown())
           {
              Connection.MessageBox(RecallSurvS5.this, "Select anyone options from (i) Mobile phone).");
              rdohhitemsI1.requestFocus();
              return;
           }
         else if(txtTelevisionNo.getText().toString().length()==0 & secTelevisionNo.isShown())
           {
             Connection.MessageBox(RecallSurvS5.this, "Required field: How many televisions do you own?.");
             txtTelevisionNo.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtTelevisionNo.getText().toString().length()==0 ? "1" : txtTelevisionNo.getText().toString()) < 1 || Integer.valueOf(txtTelevisionNo.getText().toString().length()==0 ? "9" : txtTelevisionNo.getText().toString()) > 9)
           {
             Connection.MessageBox(RecallSurvS5.this, "Value should be between 1 and 9(How many televisions do you own?).");
             txtTelevisionNo.requestFocus(); 
             return;	
           }
         
         else if(!rdohhfuelA1.isChecked() & !rdohhfuelA2.isChecked() & sechhfuelA.isShown())
           {
              Connection.MessageBox(RecallSurvS5.this, "Select anyone options from (Electricity).");
              rdohhfuelA1.requestFocus();
              return;
           }
         
         else if(!rdohhfuelB1.isChecked() & !rdohhfuelB2.isChecked() & sechhfuelB.isShown())
           {
              Connection.MessageBox(RecallSurvS5.this, "Select anyone options from (Gas).");
              rdohhfuelB1.requestFocus();
              return;
           }
         
         else if(!rdohhfuelC1.isChecked() & !rdohhfuelC2.isChecked() & sechhfuelC.isShown())
           {
              Connection.MessageBox(RecallSurvS5.this, "Select anyone options from (Kerosene ).");
              rdohhfuelC1.requestFocus();
              return;
           }
         
         else if(!rdohhfuelD1.isChecked() & !rdohhfuelD2.isChecked() & sechhfuelD.isShown())
           {
              Connection.MessageBox(RecallSurvS5.this, "Select anyone options from (Animal dung).");
              rdohhfuelD1.requestFocus();
              return;
           }
         
         else if(!rdohhfuelE1.isChecked() & !rdohhfuelE2.isChecked() & sechhfuelE.isShown())
           {
              Connection.MessageBox(RecallSurvS5.this, "Select anyone options from (Charcoal/coal).");
              rdohhfuelE1.requestFocus();
              return;
           }
         
         else if(!rdohhfuelF1.isChecked() & !rdohhfuelF2.isChecked() & sechhfuelF.isShown())
           {
              Connection.MessageBox(RecallSurvS5.this, "Select anyone options from (Wood).");
              rdohhfuelF1.requestFocus();
              return;
           }
         
         else if(!rdohhfuelG1.isChecked() & !rdohhfuelG2.isChecked() & sechhfuelG.isShown())
           {
              Connection.MessageBox(RecallSurvS5.this, "Select anyone options from (No food cooked in household).");
              rdohhfuelG1.requestFocus();
              return;
           }
         
         else if(!rdohhfuelH1.isChecked() & !rdohhfuelH2.isChecked() & sechhfuelH.isShown())
           {
              Connection.MessageBox(RecallSurvS5.this, "Select anyone options from (Other).");
              rdohhfuelH1.requestFocus();
              return;
           }
         else if(txthhfuelHOth.getText().toString().length()==0 & sechhfuelHOth.isShown())
           {
             Connection.MessageBox(RecallSurvS5.this, "Required field: Specify.");
             txthhfuelHOth.requestFocus(); 
             return;	
           }
         
         else if(!rdohhflmatA1.isChecked() & !rdohhflmatA2.isChecked() & sechhflmatA.isShown())
           {
              Connection.MessageBox(RecallSurvS5.this, "Select anyone options from (Natural floor, such as dirt, earth, sand, dung).");
              rdohhflmatA1.requestFocus();
              return;
           }
         
         else if(!rdohhflmatB1.isChecked() & !rdohhflmatB2.isChecked() & sechhflmatB.isShown())
           {
              Connection.MessageBox(RecallSurvS5.this, "Select anyone options from (Rudimentary floor, such as wood, palm/bamboo).");
              rdohhflmatB1.requestFocus();
              return;
           }
         
         else if(!rdohhflmatC1.isChecked() & !rdohhflmatC2.isChecked() & sechhflmatC.isShown())
           {
              Connection.MessageBox(RecallSurvS5.this, "Select anyone options from (Finished floor, such as cement, polished wood, vinyl strips, tiles,).");
              rdohhflmatC1.requestFocus();
              return;
           }
         
         else if(!rdohhflmatD1.isChecked() & !rdohhflmatD2.isChecked() & sechhflmatD.isShown())
           {
              Connection.MessageBox(RecallSurvS5.this, "Select anyone options from (Other, specify, such as carpet:).");
              rdohhflmatD1.requestFocus();
              return;
           }
         else if(txthhflmatDOth.getText().toString().length()==0 & sechhflmatDOth.isShown())
           {
             Connection.MessageBox(RecallSurvS5.this, "Required field: Specify.");
             txthhflmatDOth.requestFocus(); 
             return;	
           }
         
         else if(!rdohhWmatA1.isChecked() & !rdohhWmatA2.isChecked() & sechhWmatA.isShown())
           {
              Connection.MessageBox(RecallSurvS5.this, "Select anyone options from (Natural walls, such as no walls, dirt, cane/palm/trunks).");
              rdohhWmatA1.requestFocus();
              return;
           }
         
         else if(!rdohhWmatB1.isChecked() & !rdohhWmatB2.isChecked() & sechhWmatB.isShown())
           {
              Connection.MessageBox(RecallSurvS5.this, "Select anyone options from (Rudimentary walls, such as bamboo with mud, stone with mud, plywood, cardboard, reused wood).");
              rdohhWmatB1.requestFocus();
              return;
           }
         
         else if(!rdohhWmatC1.isChecked() & !rdohhWmatC2.isChecked() & sechhWmatC.isShown())
           {
              Connection.MessageBox(RecallSurvS5.this, "Select anyone options from (Finished walls, such as cement, cement blocks, bricks, wood planks/shingles, polished wood, ).");
              rdohhWmatC1.requestFocus();
              return;
           }
         
         else if(!rdohhWmatD1.isChecked() & !rdohhWmatD2.isChecked() & sechhWmatD.isShown())
           {
              Connection.MessageBox(RecallSurvS5.this, "Select anyone options from (Other).");
              rdohhWmatD1.requestFocus();
              return;
           }
         else if(txthhWmatDOth.getText().toString().length()==0 & sechhWmatDOth.isShown())
           {
             Connection.MessageBox(RecallSurvS5.this, "Required field: Specify.");
             txthhWmatDOth.requestFocus(); 
             return;	
           }
         
         else if(!rdohhrmatA1.isChecked() & !rdohhrmatA2.isChecked() & sechhrmatA.isShown())
           {
              Connection.MessageBox(RecallSurvS5.this, "Select anyone options from (Natural roofing, such as no roof, thatch/palm leaf, sod).");
              rdohhrmatA1.requestFocus();
              return;
           }
         
         else if(!rdohhrmatB1.isChecked() & !rdohhrmatB2.isChecked() & sechhrmatB.isShown())
           {
              Connection.MessageBox(RecallSurvS5.this, "Select anyone options from (Rudimentary roofing, such as wood, rustic mat, cardboard, palm/bamboo).");
              rdohhrmatB1.requestFocus();
              return;
           }
         
         else if(!rdohhrmatC1.isChecked() & !rdohhrmatC2.isChecked() & sechhrmatC.isShown())
           {
              Connection.MessageBox(RecallSurvS5.this, "Select anyone options from (Finished roofing, such as metal, iron sheets, shingles, tiles, cement).");
              rdohhrmatC1.requestFocus();
              return;
           }
         
         else if(!rdohhrmatD1.isChecked() & !rdohhrmatD2.isChecked() & sechhrmatD.isShown())
           {
              Connection.MessageBox(RecallSurvS5.this, "Select anyone options from (Other).");
              rdohhrmatD1.requestFocus();
              return;
           }
         else if(txthhrmatDOth.getText().toString().length()==0 & sechhrmatDOth.isShown())
           {
             Connection.MessageBox(RecallSurvS5.this, "Required field: Specify.");
             txthhrmatDOth.requestFocus(); 
             return;	
           }
         else if(txthhrooms.getText().toString().length()==0 & sechhrooms.isShown())
           {
             Connection.MessageBox(RecallSurvS5.this, "Required field: How many rooms in this household are used for sleeping?.");
             txthhrooms.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txthhrooms.getText().toString().length()==0 ? "1" : txthhrooms.getText().toString()) < 1 || Integer.valueOf(txthhrooms.getText().toString().length()==0 ? "99" : txthhrooms.getText().toString()) > 99)
           {
             Connection.MessageBox(RecallSurvS5.this, "Value should be between 1 and 99(How many rooms in this household are used for sleeping?).");
             txthhrooms.requestFocus(); 
             return;	
           }
         
         else if(!rdohhvehA1.isChecked() & !rdohhvehA2.isChecked() & sechhvehA.isShown())
           {
              Connection.MessageBox(RecallSurvS5.this, "Select anyone options from (A bicycle/rickshaw?).");
              rdohhvehA1.requestFocus();
              return;
           }
         
         else if(!rdohhvehB1.isChecked() & !rdohhvehB2.isChecked() & sechhvehB.isShown())
           {
              Connection.MessageBox(RecallSurvS5.this, "Select anyone options from (A motorcycle or motor scooter?).");
              rdohhvehB1.requestFocus();
              return;
           }
         
         else if(!rdohhvehC1.isChecked() & !rdohhvehC2.isChecked() & sechhvehC.isShown())
           {
              Connection.MessageBox(RecallSurvS5.this, "Select anyone options from (An animal-drawn cart?).");
              rdohhvehC1.requestFocus();
              return;
           }
         
         else if(!rdohhvehD1.isChecked() & !rdohhvehD2.isChecked() & sechhvehD.isShown())
           {
              Connection.MessageBox(RecallSurvS5.this, "Select anyone options from (A car or truck?).");
              rdohhvehD1.requestFocus();
              return;
           }
         
         else if(!rdohhvehE1.isChecked() & !rdohhvehE2.isChecked() & sechhvehE.isShown())
           {
              Connection.MessageBox(RecallSurvS5.this, "Select anyone options from (A boat with motor).");
              rdohhvehE1.requestFocus();
              return;
           }
         
         else if(!rdohhaccount1.isChecked() & !rdohhaccount2.isChecked() & sechhaccount.isShown())
           {
              Connection.MessageBox(RecallSurvS5.this, "Select anyone options from (Does any member of this household have a bank /cooperative/or other savings account?).");
              rdohhaccount1.requestFocus();
              return;
           }
         /*else if(txtcomments.getText().toString().length()==0 & seccomments.isShown())
           {
             Connection.MessageBox(RecallSurvS5.this, "Required field: INTERVIEWER COMMENTS.");
             txtcomments.requestFocus(); 
             return;	
           }*/
 
         String SQL = "";
         RadioButton rb;

         RecallSurvS5_DataModel objSave = new RecallSurvS5_DataModel();
         objSave.setCountryCode(txtCountryCode.getText().toString());
         objSave.setFaciCode(txtFaciCode.getText().toString());
         objSave.setDataId(txtDataId.getText().toString());
         objSave.setStudyID(txtStudyID.getText().toString());
         String[] d_rdogrphhitemsA = new String[] {"1","2"};
         objSave.sethhitemsA("");
         for (int i = 0; i < rdogrphhitemsA.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrphhitemsA.getChildAt(i);
             if (rb.isChecked()) objSave.sethhitemsA(d_rdogrphhitemsA[i]);
         }

         String[] d_rdogrphhitemsB = new String[] {"1","2"};
         objSave.sethhitemsB("");
         for (int i = 0; i < rdogrphhitemsB.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrphhitemsB.getChildAt(i);
             if (rb.isChecked()) objSave.sethhitemsB(d_rdogrphhitemsB[i]);
         }

         String[] d_rdogrphhitemsC = new String[] {"1","2"};
         objSave.sethhitemsC("");
         for (int i = 0; i < rdogrphhitemsC.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrphhitemsC.getChildAt(i);
             if (rb.isChecked()) objSave.sethhitemsC(d_rdogrphhitemsC[i]);
         }

         String[] d_rdogrphhitemsD = new String[] {"1","2"};
         objSave.sethhitemsD("");
         for (int i = 0; i < rdogrphhitemsD.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrphhitemsD.getChildAt(i);
             if (rb.isChecked()) objSave.sethhitemsD(d_rdogrphhitemsD[i]);
         }

         String[] d_rdogrphhitemsE = new String[] {"1","2"};
         objSave.sethhitemsE("");
         for (int i = 0; i < rdogrphhitemsE.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrphhitemsE.getChildAt(i);
             if (rb.isChecked()) objSave.sethhitemsE(d_rdogrphhitemsE[i]);
         }

         String[] d_rdogrphhitemsF = new String[] {"1","2"};
         objSave.sethhitemsF("");
         for (int i = 0; i < rdogrphhitemsF.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrphhitemsF.getChildAt(i);
             if (rb.isChecked()) objSave.sethhitemsF(d_rdogrphhitemsF[i]);
         }

         String[] d_rdogrphhitemsG = new String[] {"1","2"};
         objSave.sethhitemsG("");
         for (int i = 0; i < rdogrphhitemsG.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrphhitemsG.getChildAt(i);
             if (rb.isChecked()) objSave.sethhitemsG(d_rdogrphhitemsG[i]);
         }

         String[] d_rdogrphhitemsH = new String[] {"1","2"};
         objSave.sethhitemsH("");
         for (int i = 0; i < rdogrphhitemsH.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrphhitemsH.getChildAt(i);
             if (rb.isChecked()) objSave.sethhitemsH(d_rdogrphhitemsH[i]);
         }

         String[] d_rdogrphhitemsI = new String[] {"1","2"};
         objSave.sethhitemsI("");
         for (int i = 0; i < rdogrphhitemsI.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrphhitemsI.getChildAt(i);
             if (rb.isChecked()) objSave.sethhitemsI(d_rdogrphhitemsI[i]);
         }

         objSave.setTelevisionNo(txtTelevisionNo.getText().toString());
         objSave.setcooking((spncooking.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spncooking.getSelectedItem().toString(), "-")));
         objSave.setcookingOth(txtcookingOth.getText().toString());
         objSave.setfloor((spnfloor.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnfloor.getSelectedItem().toString(), "-")));
         objSave.setfloorOth(txtfloorOth.getText().toString());
         objSave.setwalls((spnwalls.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnwalls.getSelectedItem().toString(), "-")));
         objSave.setwallsOth(txtwallsOth.getText().toString());
         objSave.setroof((spnroof.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnroof.getSelectedItem().toString(), "-")));
         objSave.setroofOth(txtroofOth.getText().toString());

         String[] d_rdogrphhfuelA = new String[] {"1","2"};
         objSave.sethhfuelA("");
         for (int i = 0; i < rdogrphhfuelA.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrphhfuelA.getChildAt(i);
             if (rb.isChecked()) objSave.sethhfuelA(d_rdogrphhfuelA[i]);
         }

         String[] d_rdogrphhfuelB = new String[] {"1","2"};
         objSave.sethhfuelB("");
         for (int i = 0; i < rdogrphhfuelB.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrphhfuelB.getChildAt(i);
             if (rb.isChecked()) objSave.sethhfuelB(d_rdogrphhfuelB[i]);
         }

         String[] d_rdogrphhfuelC = new String[] {"1","2"};
         objSave.sethhfuelC("");
         for (int i = 0; i < rdogrphhfuelC.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrphhfuelC.getChildAt(i);
             if (rb.isChecked()) objSave.sethhfuelC(d_rdogrphhfuelC[i]);
         }

         String[] d_rdogrphhfuelD = new String[] {"1","2"};
         objSave.sethhfuelD("");
         for (int i = 0; i < rdogrphhfuelD.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrphhfuelD.getChildAt(i);
             if (rb.isChecked()) objSave.sethhfuelD(d_rdogrphhfuelD[i]);
         }

         String[] d_rdogrphhfuelE = new String[] {"1","2"};
         objSave.sethhfuelE("");
         for (int i = 0; i < rdogrphhfuelE.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrphhfuelE.getChildAt(i);
             if (rb.isChecked()) objSave.sethhfuelE(d_rdogrphhfuelE[i]);
         }

         String[] d_rdogrphhfuelF = new String[] {"1","2"};
         objSave.sethhfuelF("");
         for (int i = 0; i < rdogrphhfuelF.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrphhfuelF.getChildAt(i);
             if (rb.isChecked()) objSave.sethhfuelF(d_rdogrphhfuelF[i]);
         }

         String[] d_rdogrphhfuelG = new String[] {"1","2"};
         objSave.sethhfuelG("");
         for (int i = 0; i < rdogrphhfuelG.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrphhfuelG.getChildAt(i);
             if (rb.isChecked()) objSave.sethhfuelG(d_rdogrphhfuelG[i]);
         }

         String[] d_rdogrphhfuelH = new String[] {"1","2"};
         objSave.sethhfuelH("");
         for (int i = 0; i < rdogrphhfuelH.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrphhfuelH.getChildAt(i);
             if (rb.isChecked()) objSave.sethhfuelH(d_rdogrphhfuelH[i]);
         }

         objSave.sethhfuelHOth(txthhfuelHOth.getText().toString());
         String[] d_rdogrphhflmatA = new String[] {"1","2"};
         objSave.sethhflmatA("");
         for (int i = 0; i < rdogrphhflmatA.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrphhflmatA.getChildAt(i);
             if (rb.isChecked()) objSave.sethhflmatA(d_rdogrphhflmatA[i]);
         }

         String[] d_rdogrphhflmatB = new String[] {"1","2"};
         objSave.sethhflmatB("");
         for (int i = 0; i < rdogrphhflmatB.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrphhflmatB.getChildAt(i);
             if (rb.isChecked()) objSave.sethhflmatB(d_rdogrphhflmatB[i]);
         }

         String[] d_rdogrphhflmatC = new String[] {"1","2"};
         objSave.sethhflmatC("");
         for (int i = 0; i < rdogrphhflmatC.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrphhflmatC.getChildAt(i);
             if (rb.isChecked()) objSave.sethhflmatC(d_rdogrphhflmatC[i]);
         }

         String[] d_rdogrphhflmatD = new String[] {"1","2"};
         objSave.sethhflmatD("");
         for (int i = 0; i < rdogrphhflmatD.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrphhflmatD.getChildAt(i);
             if (rb.isChecked()) objSave.sethhflmatD(d_rdogrphhflmatD[i]);
         }

         objSave.sethhflmatDOth(txthhflmatDOth.getText().toString());
         String[] d_rdogrphhWmatA = new String[] {"1","2"};
         objSave.sethhWmatA("");
         for (int i = 0; i < rdogrphhWmatA.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrphhWmatA.getChildAt(i);
             if (rb.isChecked()) objSave.sethhWmatA(d_rdogrphhWmatA[i]);
         }

         String[] d_rdogrphhWmatB = new String[] {"1","2"};
         objSave.sethhWmatB("");
         for (int i = 0; i < rdogrphhWmatB.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrphhWmatB.getChildAt(i);
             if (rb.isChecked()) objSave.sethhWmatB(d_rdogrphhWmatB[i]);
         }

         String[] d_rdogrphhWmatC = new String[] {"1","2"};
         objSave.sethhWmatC("");
         for (int i = 0; i < rdogrphhWmatC.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrphhWmatC.getChildAt(i);
             if (rb.isChecked()) objSave.sethhWmatC(d_rdogrphhWmatC[i]);
         }

         String[] d_rdogrphhWmatD = new String[] {"1","2"};
         objSave.sethhWmatD("");
         for (int i = 0; i < rdogrphhWmatD.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrphhWmatD.getChildAt(i);
             if (rb.isChecked()) objSave.sethhWmatD(d_rdogrphhWmatD[i]);
         }

         objSave.sethhWmatDOth(txthhWmatDOth.getText().toString());
         String[] d_rdogrphhrmatA = new String[] {"1","2"};
         objSave.sethhrmatA("");
         for (int i = 0; i < rdogrphhrmatA.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrphhrmatA.getChildAt(i);
             if (rb.isChecked()) objSave.sethhrmatA(d_rdogrphhrmatA[i]);
         }

         String[] d_rdogrphhrmatB = new String[] {"1","2"};
         objSave.sethhrmatB("");
         for (int i = 0; i < rdogrphhrmatB.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrphhrmatB.getChildAt(i);
             if (rb.isChecked()) objSave.sethhrmatB(d_rdogrphhrmatB[i]);
         }

         String[] d_rdogrphhrmatC = new String[] {"1","2"};
         objSave.sethhrmatC("");
         for (int i = 0; i < rdogrphhrmatC.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrphhrmatC.getChildAt(i);
             if (rb.isChecked()) objSave.sethhrmatC(d_rdogrphhrmatC[i]);
         }

         String[] d_rdogrphhrmatD = new String[] {"1","2"};
         objSave.sethhrmatD("");
         for (int i = 0; i < rdogrphhrmatD.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrphhrmatD.getChildAt(i);
             if (rb.isChecked()) objSave.sethhrmatD(d_rdogrphhrmatD[i]);
         }

         objSave.sethhrmatDOth(txthhrmatDOth.getText().toString());
         objSave.sethhrooms(txthhrooms.getText().toString());
         String[] d_rdogrphhvehA = new String[] {"1","2"};
         objSave.sethhvehA("");
         for (int i = 0; i < rdogrphhvehA.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrphhvehA.getChildAt(i);
             if (rb.isChecked()) objSave.sethhvehA(d_rdogrphhvehA[i]);
         }

         String[] d_rdogrphhvehB = new String[] {"1","2"};
         objSave.sethhvehB("");
         for (int i = 0; i < rdogrphhvehB.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrphhvehB.getChildAt(i);
             if (rb.isChecked()) objSave.sethhvehB(d_rdogrphhvehB[i]);
         }

         String[] d_rdogrphhvehC = new String[] {"1","2"};
         objSave.sethhvehC("");
         for (int i = 0; i < rdogrphhvehC.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrphhvehC.getChildAt(i);
             if (rb.isChecked()) objSave.sethhvehC(d_rdogrphhvehC[i]);
         }

         String[] d_rdogrphhvehD = new String[] {"1","2"};
         objSave.sethhvehD("");
         for (int i = 0; i < rdogrphhvehD.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrphhvehD.getChildAt(i);
             if (rb.isChecked()) objSave.sethhvehD(d_rdogrphhvehD[i]);
         }

         String[] d_rdogrphhvehE = new String[] {"1","2"};
         objSave.sethhvehE("");
         for (int i = 0; i < rdogrphhvehE.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrphhvehE.getChildAt(i);
             if (rb.isChecked()) objSave.sethhvehE(d_rdogrphhvehE[i]);
         }

         String[] d_rdogrphhaccount = new String[] {"1","2"};
         objSave.sethhaccount("");
         for (int i = 0; i < rdogrphhaccount.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrphhaccount.getChildAt(i);
             if (rb.isChecked()) objSave.sethhaccount(d_rdogrphhaccount[i]);
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

             Connection.MessageBoxNotClose(RecallSurvS5.this, "Saved Successfully");
         }
         else{
             Connection.MessageBox(RecallSurvS5.this, status);
             return;
         }
     }
     catch(Exception  e)
     {
         Connection.MessageBox(RecallSurvS5.this, e.getMessage());
         return;
     }
 }

 private void DataSearch(String CountryCode, String FaciCode, String DataId)
     {
       try
        {
     
           RadioButton rb;
           RecallSurvS5_DataModel d = new RecallSurvS5_DataModel();
           String SQL = "Select * from "+ TableName +"  Where CountryCode='"+ CountryCode +"' and FaciCode='"+ FaciCode +"' and DataId='"+ DataId +"'";
           List<RecallSurvS5_DataModel> data = d.SelectAll(this, SQL);
           for(RecallSurvS5_DataModel item : data){
             txtCountryCode.setText(item.getCountryCode());
             txtFaciCode.setText(item.getFaciCode());
             txtDataId.setText(item.getDataId());
             txtStudyID.setText(item.getStudyID());
             String[] d_rdogrphhitemsA = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrphhitemsA.length; i++)
             {
                 if (item.gethhitemsA().equals(String.valueOf(d_rdogrphhitemsA[i])))
                 {
                     rb = (RadioButton)rdogrphhitemsA.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrphhitemsB = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrphhitemsB.length; i++)
             {
                 if (item.gethhitemsB().equals(String.valueOf(d_rdogrphhitemsB[i])))
                 {
                     rb = (RadioButton)rdogrphhitemsB.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrphhitemsC = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrphhitemsC.length; i++)
             {
                 if (item.gethhitemsC().equals(String.valueOf(d_rdogrphhitemsC[i])))
                 {
                     rb = (RadioButton)rdogrphhitemsC.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrphhitemsD = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrphhitemsD.length; i++)
             {
                 if (item.gethhitemsD().equals(String.valueOf(d_rdogrphhitemsD[i])))
                 {
                     rb = (RadioButton)rdogrphhitemsD.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrphhitemsE = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrphhitemsE.length; i++)
             {
                 if (item.gethhitemsE().equals(String.valueOf(d_rdogrphhitemsE[i])))
                 {
                     rb = (RadioButton)rdogrphhitemsE.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrphhitemsF = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrphhitemsF.length; i++)
             {
                 if (item.gethhitemsF().equals(String.valueOf(d_rdogrphhitemsF[i])))
                 {
                     rb = (RadioButton)rdogrphhitemsF.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrphhitemsG = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrphhitemsG.length; i++)
             {
                 if (item.gethhitemsG().equals(String.valueOf(d_rdogrphhitemsG[i])))
                 {
                     rb = (RadioButton)rdogrphhitemsG.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrphhitemsH = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrphhitemsH.length; i++)
             {
                 if (item.gethhitemsH().equals(String.valueOf(d_rdogrphhitemsH[i])))
                 {
                     rb = (RadioButton)rdogrphhitemsH.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrphhitemsI = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrphhitemsI.length; i++)
             {
                 if (item.gethhitemsI().equals(String.valueOf(d_rdogrphhitemsI[i])))
                 {
                     rb = (RadioButton)rdogrphhitemsI.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtTelevisionNo.setText(item.getTelevisionNo());
               spncooking.setSelection(Global.SpinnerItemPositionAnyLength(spncooking, item.getcooking()));
               txtcookingOth.setText(item.getcookingOth());
               spnfloor.setSelection(Global.SpinnerItemPositionAnyLength(spnfloor, item.getfloor()));
               txtfloorOth.setText(item.getfloorOth());
               spnwalls.setSelection(Global.SpinnerItemPositionAnyLength(spnwalls, item.getwalls()));
               txtwallsOth.setText(item.getwallsOth());
               spnroof.setSelection(Global.SpinnerItemPositionAnyLength(spnroof, item.getroof()));
                txtroofOth.setText(item.getroofOth());


               String[] d_rdogrphhfuelA = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrphhfuelA.length; i++)
             {
                 if (item.gethhfuelA().equals(String.valueOf(d_rdogrphhfuelA[i])))
                 {
                     rb = (RadioButton)rdogrphhfuelA.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrphhfuelB = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrphhfuelB.length; i++)
             {
                 if (item.gethhfuelB().equals(String.valueOf(d_rdogrphhfuelB[i])))
                 {
                     rb = (RadioButton)rdogrphhfuelB.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrphhfuelC = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrphhfuelC.length; i++)
             {
                 if (item.gethhfuelC().equals(String.valueOf(d_rdogrphhfuelC[i])))
                 {
                     rb = (RadioButton)rdogrphhfuelC.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrphhfuelD = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrphhfuelD.length; i++)
             {
                 if (item.gethhfuelD().equals(String.valueOf(d_rdogrphhfuelD[i])))
                 {
                     rb = (RadioButton)rdogrphhfuelD.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrphhfuelE = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrphhfuelE.length; i++)
             {
                 if (item.gethhfuelE().equals(String.valueOf(d_rdogrphhfuelE[i])))
                 {
                     rb = (RadioButton)rdogrphhfuelE.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrphhfuelF = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrphhfuelF.length; i++)
             {
                 if (item.gethhfuelF().equals(String.valueOf(d_rdogrphhfuelF[i])))
                 {
                     rb = (RadioButton)rdogrphhfuelF.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrphhfuelG = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrphhfuelG.length; i++)
             {
                 if (item.gethhfuelG().equals(String.valueOf(d_rdogrphhfuelG[i])))
                 {
                     rb = (RadioButton)rdogrphhfuelG.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrphhfuelH = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrphhfuelH.length; i++)
             {
                 if (item.gethhfuelH().equals(String.valueOf(d_rdogrphhfuelH[i])))
                 {
                     rb = (RadioButton)rdogrphhfuelH.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txthhfuelHOth.setText(item.gethhfuelHOth());
             String[] d_rdogrphhflmatA = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrphhflmatA.length; i++)
             {
                 if (item.gethhflmatA().equals(String.valueOf(d_rdogrphhflmatA[i])))
                 {
                     rb = (RadioButton)rdogrphhflmatA.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrphhflmatB = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrphhflmatB.length; i++)
             {
                 if (item.gethhflmatB().equals(String.valueOf(d_rdogrphhflmatB[i])))
                 {
                     rb = (RadioButton)rdogrphhflmatB.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrphhflmatC = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrphhflmatC.length; i++)
             {
                 if (item.gethhflmatC().equals(String.valueOf(d_rdogrphhflmatC[i])))
                 {
                     rb = (RadioButton)rdogrphhflmatC.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrphhflmatD = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrphhflmatD.length; i++)
             {
                 if (item.gethhflmatD().equals(String.valueOf(d_rdogrphhflmatD[i])))
                 {
                     rb = (RadioButton)rdogrphhflmatD.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txthhflmatDOth.setText(item.gethhflmatDOth());
             String[] d_rdogrphhWmatA = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrphhWmatA.length; i++)
             {
                 if (item.gethhWmatA().equals(String.valueOf(d_rdogrphhWmatA[i])))
                 {
                     rb = (RadioButton)rdogrphhWmatA.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrphhWmatB = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrphhWmatB.length; i++)
             {
                 if (item.gethhWmatB().equals(String.valueOf(d_rdogrphhWmatB[i])))
                 {
                     rb = (RadioButton)rdogrphhWmatB.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrphhWmatC = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrphhWmatC.length; i++)
             {
                 if (item.gethhWmatC().equals(String.valueOf(d_rdogrphhWmatC[i])))
                 {
                     rb = (RadioButton)rdogrphhWmatC.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrphhWmatD = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrphhWmatD.length; i++)
             {
                 if (item.gethhWmatD().equals(String.valueOf(d_rdogrphhWmatD[i])))
                 {
                     rb = (RadioButton)rdogrphhWmatD.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txthhWmatDOth.setText(item.gethhWmatDOth());
             String[] d_rdogrphhrmatA = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrphhrmatA.length; i++)
             {
                 if (item.gethhrmatA().equals(String.valueOf(d_rdogrphhrmatA[i])))
                 {
                     rb = (RadioButton)rdogrphhrmatA.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrphhrmatB = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrphhrmatB.length; i++)
             {
                 if (item.gethhrmatB().equals(String.valueOf(d_rdogrphhrmatB[i])))
                 {
                     rb = (RadioButton)rdogrphhrmatB.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrphhrmatC = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrphhrmatC.length; i++)
             {
                 if (item.gethhrmatC().equals(String.valueOf(d_rdogrphhrmatC[i])))
                 {
                     rb = (RadioButton)rdogrphhrmatC.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrphhrmatD = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrphhrmatD.length; i++)
             {
                 if (item.gethhrmatD().equals(String.valueOf(d_rdogrphhrmatD[i])))
                 {
                     rb = (RadioButton)rdogrphhrmatD.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txthhrmatDOth.setText(item.gethhrmatDOth());
             txthhrooms.setText(item.gethhrooms());
             String[] d_rdogrphhvehA = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrphhvehA.length; i++)
             {
                 if (item.gethhvehA().equals(String.valueOf(d_rdogrphhvehA[i])))
                 {
                     rb = (RadioButton)rdogrphhvehA.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrphhvehB = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrphhvehB.length; i++)
             {
                 if (item.gethhvehB().equals(String.valueOf(d_rdogrphhvehB[i])))
                 {
                     rb = (RadioButton)rdogrphhvehB.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrphhvehC = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrphhvehC.length; i++)
             {
                 if (item.gethhvehC().equals(String.valueOf(d_rdogrphhvehC[i])))
                 {
                     rb = (RadioButton)rdogrphhvehC.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrphhvehD = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrphhvehD.length; i++)
             {
                 if (item.gethhvehD().equals(String.valueOf(d_rdogrphhvehD[i])))
                 {
                     rb = (RadioButton)rdogrphhvehD.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrphhvehE = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrphhvehE.length; i++)
             {
                 if (item.gethhvehE().equals(String.valueOf(d_rdogrphhvehE[i])))
                 {
                     rb = (RadioButton)rdogrphhvehE.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrphhaccount = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrphhaccount.length; i++)
             {
                 if (item.gethhaccount().equals(String.valueOf(d_rdogrphhaccount[i])))
                 {
                     rb = (RadioButton)rdogrphhaccount.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtcomments.setText(item.getcomments());
           }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(RecallSurvS5.this, e.getMessage());
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