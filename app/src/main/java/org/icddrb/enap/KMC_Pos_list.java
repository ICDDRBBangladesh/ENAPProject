package org.icddrb.enap;
//Android Manifest Code
 //<activity android:name=".KMC_Pos_list" android:label="KMC_Pos: List" />
 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import android.app.*;
 import android.app.AlertDialog;
 import android.content.Context;
 import android.content.DialogInterface;
 import android.content.Intent;
 import android.database.Cursor;
 import android.graphics.Color;
 import android.location.Location;
 import android.view.KeyEvent;
 import android.os.Bundle;
 import android.view.Menu;
 import android.view.MenuInflater;
 import android.view.MenuItem;
 import android.view.View;
 import android.view.MotionEvent;
 import android.view.ViewGroup;
 import android.view.LayoutInflater;
 import android.view.WindowManager;
 import android.widget.LinearLayout;
 import android.widget.ListView;
 import android.widget.SimpleAdapter;
 import android.widget.BaseAdapter;
 import android.widget.TextView;
 import android.widget.Button;
 import android.widget.ImageButton;
 import Common.*;
 import Utility.*;

 public class KMC_Pos_list extends Activity {
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
    static String TableName;

    TextView lblHeading;
    Button btnAdd;
    Button btnRefresh;

     static String STARTTIME = "";
     static String DEVICEID  = "";
     static String ENTRYUSER = "";
     MySharedPreferences sp;

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
         setContentView(R.layout.kmc_pos_list);
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
         PATNAME = IDbundle.getString("patname");
         PATAGESEX    = IDbundle.getString("agesex");

         TableName = "KMC_Pos";
         lblHeading = (TextView)findViewById(R.id.lblHeading);
         lblHeading.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_DOWN) {
                     if(event.getRawX() >= (lblHeading.getRight() - lblHeading.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         AlertDialog.Builder adb = new AlertDialog.Builder(KMC_Pos_list.this);
                         adb.setTitle("Close");
                         adb.setMessage("Do you want to close this form[Yes/No]?");
                         adb.setNegativeButton("No", null);
                         adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                             public void onClick(DialogInterface dialog, int which) {
                                 finish();
                             }});
                         adb.show();
                         return true;
                     }
                 }
                 return false;
             }
         });


         /*btnRefresh = (Button) findViewById(R.id.btnRefresh);
         btnRefresh.setOnClickListener(new View.OnClickListener() {

             public void onClick(View view) {
                   //write your code here
                   DataSearch(COUNTRYCODE, FACICODE, DATAID, OBJNO);

             }});*/

         btnAdd   = (Button) findViewById(R.id.btnAdd);
         btnAdd.setOnClickListener(new View.OnClickListener() {

             public void onClick(View view) {
                         Bundle IDbundle = new Bundle();
                         IDbundle.putString("patname", PATNAME);
                         IDbundle.putString("agesex", PATAGESEX);
                         IDbundle.putString("dataid", DATAID);
                         IDbundle.putString("objno", "");
                         Intent intent = new Intent(getApplicationContext(), KMC_Pos.class);
                         intent.putExtras(IDbundle);
                         startActivityForResult(intent, 1);

             }});


        DataSearch(COUNTRYCODE, FACICODE, DATAID, OBJNO);


     }
     catch(Exception  e)
     {
         Connection.MessageBox(KMC_Pos_list.this, e.getMessage());
         return;
     }
 }
 
 @Override
 protected void onActivityResult(int requestCode, int resultCode, Intent data) {
     super.onActivityResult(requestCode, resultCode, data);
     if (resultCode == Activity.RESULT_CANCELED) {
         //Write your code if there's no result
     } else {
         DataSearch(COUNTRYCODE, FACICODE, DATAID, OBJNO);
     }
 }

 public void DataSearch(String CountryCode, String FaciCode, String DataID, String objno)
     {
       try
        {
     
           KMC_Pos_DataModel d = new KMC_Pos_DataModel();
             String SQL = "Select * from "+ TableName +"  Where CountryCode='"+ CountryCode +"' and FaciCode='"+ FaciCode +"' and DataID='"+ DataID +"'  order by cast(objno as int) desc";
             List<KMC_Pos_DataModel> data = d.SelectAll(this, SQL);
             dataList.clear();

            //dataAdapter.notifyDataSetChanged();
             dataAdapter = null;

             ListView list = (ListView)findViewById(R.id.lstData);
             HashMap<String, String> map;

             Integer i = 0;
             for(KMC_Pos_DataModel item : data){
                 map = new HashMap<String, String>();
                 map.put("CountryCode", item.getCountryCode());
                 map.put("FaciCode", item.getFaciCode());
                 map.put("DataID", item.getDataID());
                 map.put("StudyID", item.getStudyID());
                 map.put("objno", item.getobjno());
                 map.put("objdate", item.getobjdate().toString().length()==0 ? "" : Global.DateConvertDMY(item.getobjdate()));
                 map.put("objtime", item.getobjtime());
                 map.put("kmc", item.getkmc());
                 map.put("kmcwho", item.getkmcwho());
                 map.put("kmcwhooth", item.getkmcwhooth());
                 map.put("kmcpos2a", item.getkmcpos2a());
                 map.put("kmcpos2b", item.getkmcpos2b());
                 map.put("kmcpos2c", item.getkmcpos2c());
                 map.put("kmcpos2d", item.getkmcpos2d());
                 map.put("kmcpos2e", item.getkmcpos2e());
                 map.put("kmcpos2f", item.getkmcpos2f());
                 map.put("kmcpos2g", item.getkmcpos2g());
                 map.put("kmcpos2h", item.getkmcpos2h());
                 map.put("nokmcreas", item.getnokmcreas());
                 map.put("nokmcreasoth", item.getnokmcreasoth());
                 map.put("sl", i.toString());
                 i += 1;

                 dataList.add(map);
             }
             dataAdapter = new SimpleAdapter(KMC_Pos_list.this, dataList, R.layout.kmc_pos_list,new String[] {"rowsec"},
                           new int[] {R.id.secListRow});
             list.setAdapter(new DataListAdapter(this, dataAdapter));
        }
        catch(Exception  e)
        {
            Connection.MessageBox(KMC_Pos_list.this, e.getMessage());
            return;
        }
     }


 public class DataListAdapter extends BaseAdapter 
 {
     private Context context;
     private SimpleAdapter dataAdap;

     public DataListAdapter(Context c, SimpleAdapter da){ context = c;  dataAdap = da; }
     public int getCount() {  return dataAdap.getCount();  }
     public Object getItem(int position) {  return position;  }
     public long getItemId(int position) {  return position;  }
     public View getView(final int position, View convertView, ViewGroup parent) {
         LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
         if (convertView == null) {
 	        convertView = inflater.inflate(R.layout.kmc_pos_row, null); 
 	        }
         LinearLayout   secListRow = (LinearLayout)convertView.findViewById(R.id.secListRow);

         final TextView objno = (TextView)convertView.findViewById(R.id.objno);
         final TextView objdate = (TextView)convertView.findViewById(R.id.objdate);
         final TextView objtime = (TextView)convertView.findViewById(R.id.objtime);


         final HashMap<String, String> o = (HashMap<String, String>) dataAdap.getItem(position);
         objno.setText(o.get("objno"));
         objdate.setText(o.get("objdate"));
         objtime.setText(o.get("objtime"));

         if (Integer.valueOf(o.get("sl")) % 2 == 0)
         {
             secListRow.setBackgroundColor(Color.parseColor("#F3F3F3"));
         }
         else
         {
             secListRow.setBackgroundColor(Color.parseColor("#FFFFFF"));
         }

         secListRow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               //Write your code here
               Bundle IDbundle = new Bundle();
               IDbundle.putString("countrycode", o.get("CountryCode"));
               IDbundle.putString("facicode", o.get("FaciCode"));
               IDbundle.putString("dataid", o.get("DataID"));
               IDbundle.putString("objno", o.get("objno"));
               Intent f1;
               f1 = new Intent(getApplicationContext(), KMC_Pos.class);
               f1.putExtras(IDbundle);
               startActivity(f1);
            }
          });


         return convertView;
       }
 }


}