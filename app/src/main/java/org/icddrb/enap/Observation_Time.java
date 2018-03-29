package org.icddrb.enap;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.Html;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Common.Connection;
import Common.Global;
import Common.ProjectSetting;
import Utility.MySharedPreferences;

/**
 * Created by TanvirHossain on 05/12/2016.
 */

public class Observation_Time extends AppCompatActivity {
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

    private List<VariableList_DataModel> variableList = new ArrayList<>();
    private RecyclerView recyclerView;
    private VariableListAdapter mAdapter;

    static String DEVICEID  = "";
    static String ENTRYUSER = "";
    static String COUNTRYCODE = "";
    static String FACICODE = "";

    MySharedPreferences sp;
    TextView lblCountVariable;
    LinearLayout secStatusSearch;
    Spinner spnStatusSearch;
    EditText txtSearch;
    Bundle IDbundle;
    static String LOCATION = "";
    static String ROLE     = "";

    LinearLayout secRegisType;
    LinearLayout secTitle;
    TextView lblTitle;


    static String TABLEID = "";
    static String DATAID  = "";
    static String VARIABLENAME = "";
    static String WOMAN_CHILD = "";

    Global g;
    Connection C;
    private Boolean spinnerTouched = false;
    GridLayoutManager manager;
    LinearLayout secChildSl;
    public Spinner spnChildSl;
    RadioGroup rdogrpChildSl;
    RadioButton rdoChildSl1;
    RadioButton rdoChildSl2;
    RadioButton rdoChildSl3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.observation_time);
        g = Global.getInstance();
        C = new Connection(this);

        DEVICEID    = sp.getValue(this, "deviceid");
        ENTRYUSER   = sp.getValue(this, "userid");
        COUNTRYCODE = sp.getValue(this, "countrycode");
        FACICODE    = sp.getValue(this, "facicode");

        IDbundle    = getIntent().getExtras();
        TABLEID     = IDbundle.getString("tableid");;
        DATAID      = IDbundle.getString("dataid");
        WOMAN_CHILD = "w";//IDbundle.getString("womanchild");

        VARIABLENAME = "";
        /*
            1: Registration
            2: Labour and Delivery
            3: KMC
            4: Sepsis
            5: ACS
         */
        LOCATION  = IDbundle.getString("location");

        /*
        1-Registration
        2-Observation
        3-Exit Interview
        4-Data Extraction
        5-Verification
         */
        ROLE      = IDbundle.getString("role");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new VariableListAdapter(variableList);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                try {
                    VariableList_DataModel variable = variableList.get(position);
                }catch(Exception ex){

                }
                //Toast.makeText(getApplicationContext(), variable.getDescription() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }

        }));

        manager = new GridLayoutManager(this, 4);
        //dynamically changing the total number of column
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                //Labour and Delivery
                if(TABLEID.equals("1")) {
                    if (position == 16) {
                        return 2;
                    } else if (position == 17) {
                        return 2;
                    }else {
                        return 1;
                    }
                }
                //Newborn
                else if(TABLEID.equals("2")) {
                    return 1;
                }
                //Resus
                else if(TABLEID.equals("3")) {
                    if (position == 2|position == 3|position == 4|position == 5|position == 6) {
                        return 2;
                    }else {
                        return 1;
                    }
                }
                //PPHx
                else if(TABLEID.equals("4")) {
                    if (position == 0|position == 17|position == 20|position == 31) {
                        return 2;
                    }else {
                        return 1;
                    }
                }else {
                    return 1;
                }

            }
        });
        recyclerView.setLayoutManager(manager);

        secChildSl = (LinearLayout)findViewById(R.id.secChildSl);
        spnChildSl = (Spinner)findViewById(R.id.spnChildSl);
        List<String> listChild = new ArrayList<String>();
        listChild.add("1");
        listChild.add("2");
        listChild.add("3");
        ArrayAdapter<String> adptrchild= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listChild);
        spnChildSl.setAdapter(adptrchild);

        rdogrpChildSl=(RadioGroup)findViewById(R.id.rdogrpChildSl);
        rdoChildSl1=(RadioButton)findViewById(R.id.rdoChildSl1);
        rdoChildSl2=(RadioButton)findViewById(R.id.rdoChildSl2);
        rdoChildSl3=(RadioButton)findViewById(R.id.rdoChildSl3);
        rdogrpChildSl.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch(checkedId)
                {
                    case R.id.rdoChildSl1:
                        prepareVariableListData(TABLEID, DATAID, WOMAN_CHILD, "1");
                        mAdapter.notifyDataSetChanged();
                        break;
                    case R.id.rdoChildSl2:
                        prepareVariableListData(TABLEID, DATAID, WOMAN_CHILD, "2");
                        mAdapter.notifyDataSetChanged();
                        break;
                    case R.id.rdoChildSl3:
                        prepareVariableListData(TABLEID, DATAID, WOMAN_CHILD, "3");
                        mAdapter.notifyDataSetChanged();
                        break;
                }
            }
        });

        /*spnChildSl.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if(WOMAN_CHILD.equals("c")) {
                    String CSL = spnChildSl.getSelectedItem().toString();
                    //prepareVariableListData(TABLEID, DATAID, WOMAN_CHILD, CSL);
                    mAdapter.notifyDataSetChanged();
                }else if(WOMAN_CHILD.equals("r")) {
                    String CSL = spnChildSl.getSelectedItem().toString();
                    //prepareVariableListData(TABLEID, DATAID, WOMAN_CHILD, CSL);
                    mAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });*/

        if(WOMAN_CHILD.equals("w"))
            secChildSl.setVisibility(View.GONE);
        else if(WOMAN_CHILD.equals("c"))
            secChildSl.setVisibility(View.VISIBLE);
        else if(WOMAN_CHILD.equals("r"))
            secChildSl.setVisibility(View.VISIBLE);

        //prepareVariableListData(TABLEID, DATAID, WOMAN_CHILD,"");
    }

    public void refreshAdapter(){
        mAdapter.notifyDataSetChanged();
    }

    public void prepareVariableListData(String TableId, String DataId ,String WomanChild, String ChildSL) {
        TABLEID = TableId;
        DATAID  = DataId;
        String SQL = "";
        WOMAN_CHILD = WomanChild;
        List<String> listChild = new ArrayList<String>();
        Integer totalChild = 1;
        if(WOMAN_CHILD.equals("w"))
            secChildSl.setVisibility(View.GONE);
        else if(WOMAN_CHILD.equals("c")) {
            secChildSl.setVisibility(View.VISIBLE);
            /*if(C.Existence("Select VarData from Observation where DataId='"+ DATAID +"' and VarName='Numbirth'")){
                String CH = C.ReturnSingleValue("Select VarData from Observation where DataId='"+ DATAID +"' and VarName='Numbirth'");
                totalChild = Integer.parseInt(CH.length()==0?"1":CH);
            }*/
            String CH = C.ReturnSingleValue("Select VarData from Observation where DataId='"+ DATAID +"' and VarName='Numbirth'");
            totalChild = Integer.parseInt(CH.length()==0?"1":CH);

            if(totalChild==1){
                rdoChildSl1.setVisibility(View.VISIBLE);
                rdoChildSl2.setVisibility(View.GONE);
                rdoChildSl3.setVisibility(View.GONE);
            }else if(totalChild==2){
                rdoChildSl1.setVisibility(View.VISIBLE);
                rdoChildSl2.setVisibility(View.VISIBLE);
                rdoChildSl3.setVisibility(View.GONE);
            }else if(totalChild==3){
                rdoChildSl1.setVisibility(View.VISIBLE);
                rdoChildSl2.setVisibility(View.VISIBLE);
                rdoChildSl3.setVisibility(View.VISIBLE);
            }

            /*for(int i=1;i<=totalChild;i++)
                listChild.add(String.valueOf(i));

            ArrayAdapter<String> adptrchild= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listChild);
            spnChildSl.setAdapter(adptrchild);*/

        }
        else if(WOMAN_CHILD.equals("r")) {
            secChildSl.setVisibility(View.VISIBLE);
            String CH = C.ReturnSingleValue("Select VarData from Observation where DataId='"+ DATAID +"' and VarName='Numbirth'");
            totalChild = Integer.parseInt(CH.length()==0?"1":CH);

            /*if(C.Existence("Select VarData from Observation where DataId='"+ DATAID +"' and VarName='Numbirth'")){
                totalChild = Integer.parseInt(C.ReturnSingleValue("Select VarData from Observation where DataId='"+ DATAID +"' and VarName='Numbirth'"));
            }*/
            if(totalChild==1){
                rdoChildSl1.setVisibility(View.VISIBLE);
                rdoChildSl2.setVisibility(View.GONE);
                rdoChildSl3.setVisibility(View.GONE);
            }else if(totalChild==2){
                rdoChildSl1.setVisibility(View.VISIBLE);
                rdoChildSl2.setVisibility(View.VISIBLE);
                rdoChildSl3.setVisibility(View.GONE);
            }else if(totalChild==3){
                rdoChildSl1.setVisibility(View.VISIBLE);
                rdoChildSl2.setVisibility(View.VISIBLE);
                rdoChildSl3.setVisibility(View.VISIBLE);
            }
        }

        ChildSL = ChildSL.length()==0?"1":ChildSL;
        //Table:1
        SQL = "Insert into Observation(CountryCode,FaciCode,TableId,DataID,VarName,SL,Observ,VarData,ObservDT,FirstTm,FinalTm,EnDt,DeviceId,EntryUser,Upload,modifyDate,Active)";
        SQL += " Select '" + COUNTRYCODE + "' CountryCode,'" + FACICODE + "' FaciCode, '1' TableId,'" + DataId + "' DataID, VarName,'','N'Observ,'' VarData,''ObservDT,''FirstTm,''FinalTm,''EnDt,'" + DEVICEID + "' DeviceId,'" + ENTRYUSER + "' EntryUser,'2'Upload,'" + Global.DateTimeNowYMDHMS() + "' modifyDate,v.Active from ObjVarList v";
        SQL += " where TableId='1' and not exists(select CountryCode from Observation where CountryCode='" + COUNTRYCODE + "' and FaciCode='" + FACICODE + "' and TableId='1' and DataId='" + DataId + "' and VarName=v.VarName and SL='')";
        C.SaveDT(SQL);

        //Table:2
        SQL = "Insert into Observation(CountryCode,FaciCode,TableId,DataID,VarName,SL,Observ,VarData,ObservDT,FirstTm,FinalTm,EnDt,DeviceId,EntryUser,Upload,modifyDate,Active)";
        SQL += " Select '" + COUNTRYCODE + "' CountryCode,'" + FACICODE + "' FaciCode, '2' TableId,'" + DataId + "' DataID, VarName,'" + ChildSL + "','N'Observ,'' VarData,''ObservDT,''FirstTm,''FinalTm,''EnDt,'" + DEVICEID + "' DeviceId,'" + ENTRYUSER + "' EntryUser,'2'Upload,'" + Global.DateTimeNowYMDHMS() + "' modifyDate,v.Active from ObjVarList v";
        SQL += " where TableId='2' and not exists(select CountryCode from Observation where CountryCode='" + COUNTRYCODE + "' and FaciCode='" + FACICODE + "' and TableId='2' and DataId='" + DataId + "' and VarName=v.VarName and SL='" + ChildSL + "')";
        C.SaveDT(SQL);

        //Table:3
        SQL = "Insert into Observation(CountryCode,FaciCode,TableId,DataID,VarName,SL,Observ,VarData,ObservDT,FirstTm,FinalTm,EnDt,DeviceId,EntryUser,Upload,modifyDate,Active)";
        SQL += " Select '" + COUNTRYCODE + "' CountryCode,'" + FACICODE + "' FaciCode, '3' TableId,'" + DataId + "' DataID, VarName,'" + ChildSL + "','N'Observ,'' VarData,''ObservDT,''FirstTm,''FinalTm,''EnDt,'" + DEVICEID + "' DeviceId,'" + ENTRYUSER + "' EntryUser,'2'Upload,'" + Global.DateTimeNowYMDHMS() + "' modifyDate,v.Active from ObjVarList v";
        SQL += " where TableId='3' and not exists(select CountryCode from Observation where CountryCode='" + COUNTRYCODE + "' and FaciCode='" + FACICODE + "' and TableId='3' and DataId='" + DataId + "' and VarName=v.VarName and SL='" + ChildSL + "')";
        C.SaveDT(SQL);

        //Table:4
        SQL = "Insert into Observation(CountryCode,FaciCode,TableId,DataID,VarName,SL,Observ,VarData,ObservDT,FirstTm,FinalTm,EnDt,DeviceId,EntryUser,Upload,modifyDate,Active)";
        SQL += " Select '" + COUNTRYCODE + "' CountryCode,'" + FACICODE + "' FaciCode, '4' TableId,'" + DataId + "' DataID, VarName,'','N'Observ,'' VarData,''ObservDT,''FirstTm,''FinalTm,''EnDt,'" + DEVICEID + "' DeviceId,'" + ENTRYUSER + "' EntryUser,'2'Upload,'" + Global.DateTimeNowYMDHMS() + "' modifyDate,v.Active from ObjVarList v";
        SQL += " where TableId='4' and not exists(select CountryCode from Observation where CountryCode='" + COUNTRYCODE + "' and FaciCode='" + FACICODE + "' and TableId='4' and DataId='" + DataId + "' and VarName=v.VarName and SL='')";
        C.SaveDT(SQL);


        if(WomanChild.equals("w")) {
            if(TableId.equals("1")) {
                SQL = "Insert into Observation(CountryCode,FaciCode,TableId,DataID,VarName,SL,Observ,VarData,ObservDT,FirstTm,FinalTm,EnDt,DeviceId,EntryUser,Upload,modifyDate,Active)";
                SQL += " Select '" + COUNTRYCODE + "' CountryCode,'" + FACICODE + "' FaciCode, '" + TableId + "' TableId,'" + DataId + "' DataID, VarName,'','N'Observ,'' VarData,''ObservDT,''FirstTm,''FinalTm,''EnDt,'" + DEVICEID + "' DeviceId,'" + ENTRYUSER + "' EntryUser,'2'Upload,'" + Global.DateTimeNowYMDHMS() + "' modifyDate,v.Active from ObjVarList v";
                SQL += " where TableId='" + TableId + "' and not exists(select CountryCode from Observation where CountryCode='" + COUNTRYCODE + "' and FaciCode='" + FACICODE + "' and TableId='" + TableId + "' and DataId='" + DataId + "' and VarName=v.VarName)";
                C.SaveDT(SQL);
            }
            SQL = " Select v.TableId, v.VarName, (case when o.sl is null then '' else o.sl end)SL, v.Description, v.ObjSeq1, v.ObjSeq2, (case when o.Observ is null then '' else o.Observ end) Status,";
            SQL += " VarData,";
            SQL += " ControlType,";
            SQL += " VarOption,";
            SQL += " VarLength, VarDataType, Color, (case when length(o.Active)=0 or o.Active is null then v.Active else o.Active end)Active, Important, ForceVar";
            SQL += " from ObjVarList v";
            SQL += " left outer join Observation o on v.TableId=o.TableId and v.VarName=o.VarName";
            SQL += " and o.CountryCode='" + COUNTRYCODE + "' and o.FaciCode='" + FACICODE + "'";
            SQL += " and o.TableId='" + TableId + "'";
            SQL += " and o.DataID='" + DataId + "'";
            SQL += " Where v.TableId='" + TableId + "'";
            SQL += " order by ObjSeq1";
        }
        else if(WomanChild.equals("c") & TableId.equals("2")) {
            /*if(TableId.equals("2")) {
                SQL = "Insert into Observation(CountryCode,FaciCode,TableId,DataID,VarName,SL,Observ,VarData,ObservDT,FirstTm,FinalTm,EnDt,DeviceId,EntryUser,Upload,modifyDate)";
                SQL += " Select '" + COUNTRYCODE + "' CountryCode,'" + FACICODE + "' FaciCode, '" + TableId + "' TableId,'" + DataId + "' DataID, VarName,'" + ChildSL + "','N'Observ,'' VarData,''ObservDT,''FirstTm,''FinalTm,''EnDt,'" + DEVICEID + "' DeviceId,'" + ENTRYUSER + "' EntryUser,'2'Upload,'" + Global.DateTimeNowYMDHMS() + "' modifyDate from ObjVarList v";
                SQL += " where TableId='" + TableId + "' and not exists(select CountryCode from Observation where CountryCode='" + COUNTRYCODE + "' and FaciCode='" + FACICODE + "' and TableId='" + TableId + "' and DataId='" + DataId + "' and VarName=v.VarName and SL='" + ChildSL + "')";
                C.SaveDT(SQL);
            }*/

            SQL = " Select v.TableId, v.VarName, (case when o.sl is null then '' else o.sl end)SL, v.Description, v.ObjSeq1, v.ObjSeq2, (case when o.Observ is null then '' else o.Observ end) Status,";
            SQL += " VarData,";
            SQL += " ControlType,";
            SQL += " VarOption,";
            SQL += " VarLength, VarDataType, Color, (case when length(o.Active)=0 or o.Active is null then v.Active else o.Active end)Active, Important, ForceVar";
            SQL += " from ObjVarList v";
            SQL += " left outer join Observation o on v.TableId=o.TableId and v.VarName=o.VarName";
            SQL += " and o.CountryCode='" + COUNTRYCODE + "' and o.FaciCode='" + FACICODE + "'";
            SQL += " and o.TableId='" + TableId + "'";
            SQL += " and o.DataID='" + DataId + "' and ifnull(o.SL,'')='"+ ChildSL +"'";
            SQL += " Where v.TableId='" + TableId + "'";
            SQL += " order by ObjSeq1";
        }
        else if(WomanChild.equals("r") & TableId.equals("3")) {
            ChildSL = ChildSL.length()==0?"1":ChildSL;
            if(TableId.equals("3")) {
                SQL = "Insert into Observation(CountryCode,FaciCode,TableId,DataID,VarName,SL,Observ,VarData,ObservDT,FirstTm,FinalTm,EnDt,DeviceId,EntryUser,Upload,modifyDate,Active)";
                SQL += " Select '" + COUNTRYCODE + "' CountryCode,'" + FACICODE + "' FaciCode, '" + TableId + "' TableId,'" + DataId + "' DataID, VarName,'" + ChildSL + "','N'Observ,'' VarData,''ObservDT,''FirstTm,''FinalTm,''EnDt,'" + DEVICEID + "' DeviceId,'" + ENTRYUSER + "' EntryUser,'2'Upload,'" + Global.DateTimeNowYMDHMS() + "' modifyDate,v.Active from ObjVarList v";
                SQL += " where TableId='" + TableId + "' and not exists(select CountryCode from Observation where CountryCode='" + COUNTRYCODE + "' and FaciCode='" + FACICODE + "' and TableId='" + TableId + "' and DataId='" + DataId + "' and VarName=v.VarName and SL='" + ChildSL + "')";
                C.SaveDT(SQL);
            }

            SQL = " Select v.TableId, v.VarName, (case when o.sl is null then '' else o.sl end)SL, v.Description, v.ObjSeq1, v.ObjSeq2, (case when o.Observ is null then '' else o.Observ end) Status,";
            SQL += " VarData,";
            SQL += " ControlType,";
            SQL += " VarOption,";
            SQL += " VarLength, VarDataType, Color, (case when length(o.Active)=0 or o.Active is null then v.Active else o.Active end)Active, Important, ForceVar";
            SQL += " from ObjVarList v";
            SQL += " left outer join Observation o on v.TableId=o.TableId and v.VarName=o.VarName";
            SQL += " and o.CountryCode='" + COUNTRYCODE + "' and o.FaciCode='" + FACICODE + "'";
            SQL += " and o.TableId='" + TableId + "'";
            SQL += " and o.DataID='" + DataId + "' and ifnull(o.SL,'')='"+ ChildSL +"'";
            SQL += " Where v.TableId='" + TableId + "'";
            SQL += " order by ObjSeq1";
        }else if(WomanChild.equals("w") & TableId.equals("4")) {
            if(TableId.equals("4")) {
                SQL = "Insert into Observation(CountryCode,FaciCode,TableId,DataID,VarName,SL,Observ,VarData,ObservDT,FirstTm,FinalTm,EnDt,DeviceId,EntryUser,Upload,modifyDate,Active)";
                SQL += " Select '" + COUNTRYCODE + "' CountryCode,'" + FACICODE + "' FaciCode, '" + TableId + "' TableId,'" + DataId + "' DataID, VarName,'','N'Observ,'' VarData,''ObservDT,''FirstTm,''FinalTm,''EnDt,'" + DEVICEID + "' DeviceId,'" + ENTRYUSER + "' EntryUser,'2'Upload,'" + Global.DateTimeNowYMDHMS() + "' modifyDate,v.Active from ObjVarList v";
                SQL += " where TableId='" + TableId + "' and not exists(select CountryCode from Observation where CountryCode='" + COUNTRYCODE + "' and FaciCode='" + FACICODE + "' and TableId='" + TableId + "' and DataId='" + DataId + "' and VarName=v.VarName)";
                C.SaveDT(SQL);
            }

            SQL = " Select v.TableId, v.VarName, (case when o.sl is null then '' else o.sl end)SL, v.Description, v.ObjSeq1, v.ObjSeq2, (case when o.Observ is null then '' else o.Observ end) Status,";
            SQL += " VarData,";
            SQL += " ControlType,";
            SQL += " VarOption,";
            SQL += " VarLength, VarDataType, Color, (case when length(o.Active)=0 or o.Active is null then v.Active else o.Active end)Active, Important, ForceVar";
            SQL += " from ObjVarList v";
            SQL += " left outer join Observation o on v.TableId=o.TableId and v.VarName=o.VarName";
            SQL += " and o.CountryCode='" + COUNTRYCODE + "' and o.FaciCode='" + FACICODE + "'";
            SQL += " and o.TableId='" + TableId + "'";
            SQL += " and o.DataID='" + DataId + "'";
            SQL += " Where v.TableId='" + TableId + "'";
            SQL += " order by ObjSeq1";
        }
        Observation_VarList_DataModel d = new Observation_VarList_DataModel();
        List<Observation_VarList_DataModel> data = d.ObservationList(this, SQL);

        variableList.clear();
        int count = 0;
        for(Observation_VarList_DataModel item : data){

            VariableList_DataModel p = new VariableList_DataModel();
            p.setTableId(item.getTableId());
            p.setVarName(item.getVarName());
            p.setSL(item.getSL());
            p.setDescription(item.getDescription());
            p.setObjSeq1(item.getObjSeq1());
            p.setObjSeq2(item.getObjSeq2());
            p.setStatus(item.getStatus());

            p.setVarData(item.getVarData()==null?"":item.getVarData());
            p.setControlType(item.getControlType());
            p.setVarOption(item.getVarOption());

            p.setVarLength(item.getVarLength());
            p.setVarDataType(item.getVarDataType());
            p.setColor(item.getColor());
            p.setActive(item.getActive());
            p.setColor(item.getColor());
            p.setImportant(item.getImportant());
            p.setForceVar(item.getForceVar());

            count +=1;
            variableList.add(p);
        }

        //lblCountVariable.setText("(Total: "+ String.valueOf(count) +")");
        //mAdapter.notifyDataSetChanged();
        //refreshAdapter();
    }

    public class VariableListAdapter extends RecyclerView.Adapter<VariableListAdapter.MyViewHolder> {
        private List<VariableList_DataModel> variableList;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView objDescription, dataDescription;
            public LinearLayout objCheckList;
            public Spinner spnDataList;
            public EditText txtData;
            public ImageButton btnData;
            public View lineImportant;
            public MyViewHolder(View view) {
                super(view);
                objDescription = (TextView) view.findViewById(R.id.objDescription);
                objCheckList = (LinearLayout) view.findViewById(R.id.objCheckList);

                dataDescription = (TextView) view.findViewById(R.id.dataDescription);
                spnDataList = (Spinner) view.findViewById(R.id.spnDataList);
                txtData = (EditText) view.findViewById(R.id.txtData);
                btnData = (ImageButton) view.findViewById(R.id.btnData);
                txtData.setInputType(InputType.TYPE_CLASS_NUMBER);
                txtData.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
                lineImportant = (View) view.findViewById(R.id.lineImportant);
            }
        }


        public VariableListAdapter(List<VariableList_DataModel> varList) {
            this.variableList = varList;
        }

        @Override
        public VariableListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.observation_grid_item, parent, false);

            return new VariableListAdapter.MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final VariableListAdapter.MyViewHolder holder, final int position) {
            final VariableList_DataModel varlist = variableList.get(position);
            //holder.objDescription.setText(varlist.getDescription());
            //holder.objDescription.setText(Html.fromHtml("<font color=\"#FF0000\">*</font>"+ varlist.getDescription()));

            if(varlist.getImportant().equals("1"))
                holder.objDescription.setText(Html.fromHtml("<font color=\"#FF0000\">*</font>"+ varlist.getDescription()));
            else
                holder.objDescription.setText(varlist.getDescription());

            manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    //Labour and Delivery
                    if(TABLEID.equals("1")) {
                        if (position == 16) {
                            return 2;
                        } else if (position == 17) {
                            return 2;
                        }else {
                            return 1;
                        }
                    }
                    //Newborn
                    else if(TABLEID.equals("2")) {
                        return 1;
                    }
                    //Resus
                    else if(TABLEID.equals("3")) {
                        if (position == 2|position == 3|position == 4|position == 5|position == 6) {
                            return 2;
                        }else {
                            return 1;
                        }
                    }
                    //PPH
                    else if(TABLEID.equals("4")) {
                        if (position == 0|position == 17|position == 20|position == 31) {
                            return 2;
                        }else {
                            return 1;
                        }
                    }else {
                        return 1;
                    }

                }
            });
            recyclerView.setLayoutManager(manager);

            holder.objDescription.setVisibility(View.GONE);
            holder.dataDescription.setVisibility(View.GONE);
            holder.spnDataList.setVisibility(View.GONE);
            holder.txtData.setVisibility(View.GONE);
            holder.btnData.setVisibility(View.GONE);
            //**************************************************************************************
            try {
                //Command Button
                if (varlist.getControlType().equals("1")) {
                    holder.objDescription.setVisibility(View.VISIBLE);
                    holder.dataDescription.setVisibility(View.GONE);
                    holder.spnDataList.setVisibility(View.GONE);

                    //Active
                    if (varlist.getActive().equals("1")) {
                        //holder.objCheckList.setVisibility(View.VISIBLE);
                        holder.objCheckList.setEnabled(true);
                        holder.txtData.setEnabled(true);
                        holder.btnData.setEnabled(true);
                        holder.objCheckList.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        //holder.objCheckList.setBackgroundColor(Color.parseColor("#69CB3F"));

                        if (varlist.getStatus().equals("Y")) {
                            holder.objCheckList.setBackgroundColor(Color.parseColor("#69CB3F"));
                        } else if (varlist.getStatus().equals("C")) {
                            holder.objCheckList.setBackgroundColor(Color.parseColor("#FF0000"));
                        } else if (varlist.getStatus().equals("N")) {
                            holder.objCheckList.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        } else {
                            holder.objCheckList.setBackgroundColor(Color.parseColor("#D7D7D7"));
                        }
                    } else {
                        //holder.objCheckList.setVisibility(View.INVISIBLE);
                        holder.objCheckList.setEnabled(false);
                        holder.txtData.setEnabled(false);
                        holder.btnData.setEnabled(false);
                        holder.objCheckList.setBackgroundColor(Color.parseColor("#D7D7D7"));
                    }

                    holder.objCheckList.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            Observation_DataModel obj = new Observation_DataModel();
                            obj.setCountryCode(COUNTRYCODE);
                            obj.setFaciCode(FACICODE);
                            obj.setTableId(TABLEID);
                            obj.setDataID(DATAID);
                            obj.setVarName(varlist.getVarName());

                            if (WOMAN_CHILD.equals("c") | WOMAN_CHILD.equals("r"))
                                obj.setSL(varlist.getSL());

                            if (varlist.getStatus().equals("Y")) {
                                obj.setObserv("C");
                                varlist.setStatus("C");
                                mAdapter.variableList.set(position, varlist);
                            } else if (varlist.getStatus().equals("C")) {
                                obj.setObserv("N");
                                varlist.setStatus("N");
                                mAdapter.variableList.set(position, varlist);
                            } else if (varlist.getStatus().equals("N")) {
                                obj.setObserv("Y");
                                varlist.setStatus("Y");
                                mAdapter.variableList.set(position, varlist);
                            } else {
                                obj.setObserv("N");
                                varlist.setStatus("N");
                                mAdapter.variableList.set(position, varlist);
                            }

                            obj.setVarData("");
                            obj.setObservDT(Global.DateNowYMD());
                            obj.setFirstTm(g.CurrentTime24());
                            obj.setFinalTm(g.CurrentTime24());
                            obj.setEnDt(Global.DateTimeNowYMDHMS());
                            obj.setDeviceID(DEVICEID);
                            obj.setEntryUser(ENTRYUSER);
                            obj.SaveUpdateData(Observation_Time.this);

                            //Skip Rule

                            //Table: L&D 1st and 2nd Stage
                            //-----------------------------------------------------------------------------------------------------
                            //Observation Start
                            if(varlist.getVarName().equalsIgnoreCase("ObjStart") & varlist.getStatus().equals("Y")){
                                for(int i=1; i<=26; i++) {
                                    VariableList_DataModel varlist1 = variableList.get(position + i);
                                    if(!varlist1.getVarName().equalsIgnoreCase("LiqTyp") & !varlist1.getVarName().equalsIgnoreCase("LiqSmlTyp") & !varlist1.getVarName().equalsIgnoreCase("ObjPlaceOth")) {
                                        varlist1.setActive("1");
                                        C.SaveDT("Update Observation set Active='1' where DataID='" + obj.getDataID() + "' and VarName='" + varlist1.getVarName() + "'");
                                    }else{
                                        varlist1.setActive("2");
                                        varlist1.setStatus("N");
                                        varlist1.setVarData("");
                                        C.SaveDT("Update Observation set VarData='',Observ='N', ObservDT='', FirstTm='', FInalTm='', Active='2' where DataID='"+ obj.getDataID() +"' and VarName='"+ varlist1.getVarName() +"'");
                                    }
                                }
                            }else if(varlist.getVarName().equalsIgnoreCase("ObjStart") & !varlist.getStatus().equals("Y")){
                                for(int i=1; i<=26; i++) {
                                    VariableList_DataModel varlist1 = variableList.get(position + i);
                                    varlist1.setActive("2");
                                    varlist1.setStatus("N");
                                    varlist1.setVarData("");
                                    C.SaveDT("Update Observation set VarData='',Observ='N', ObservDT='', FirstTm='', FInalTm='', Active='2' where DataID='"+ obj.getDataID() +"' and VarName='"+ varlist1.getVarName() +"'");
                                }
                            }

                            //Liquor Check
                            if(varlist.getVarName().equalsIgnoreCase("LiqChk") & varlist.getStatus().equals("Y")){
                                for(int i=1; i<=2; i++) {
                                    VariableList_DataModel varlist1 = variableList.get(position + i);
                                    varlist1.setActive("1");
                                    C.SaveDT("Update Observation set Active='1' where DataID='"+ obj.getDataID() +"' and VarName='"+ varlist1.getVarName() +"'");
                                }
                            }else if(varlist.getVarName().equalsIgnoreCase("LiqChk") & !varlist.getStatus().equals("Y")){
                                for(int i=1; i<=2; i++) {
                                    VariableList_DataModel varlist1 = variableList.get(position + i);
                                    varlist1.setActive("2");
                                    varlist1.setStatus("N");
                                    varlist1.setVarData("");
                                    C.SaveDT("Update Observation set VarData='',Observ='N', ObservDT='', FirstTm='', FInalTm='', Active='2' where DataID='"+ obj.getDataID() +"' and VarName='"+ varlist1.getVarName() +"'");
                                }
                            }


                            //Table: Newborn
                            //-----------------------------------------------------------------------------------------------------
                            String CSL = varlist.getSL();
                            //if(rdoChildSl1.isChecked()) CSL = "1"; else if(rdoChildSl2.isChecked()) CSL = "2"; else if(rdoChildSl3.isChecked()) CSL = "3";
                            if(varlist.getVarName().equalsIgnoreCase("BabyDel") & varlist.getStatus().equals("Y")){
                                for(int i=1; i<=22; i++) {
                                    VariableList_DataModel varlist1 = variableList.get(position + i);
                                    if(!varlist1.getVarName().equalsIgnoreCase("DelPlaceOth") & !varlist1.getVarName().equalsIgnoreCase("CordApTypOth") & !varlist1.getVarName().equalsIgnoreCase("CordApTyp") & !varlist1.getVarName().equalsIgnoreCase("BabyWrpTyp")) {
                                        varlist1.setActive("1");
                                        C.SaveDT("Update Observation set Active='1' where DataID='" + obj.getDataID() + "' and SL='"+ CSL +"' and VarName='" + varlist1.getVarName() + "'");
                                    }else{
                                        varlist1.setActive("2");
                                        varlist1.setStatus("N");
                                        varlist1.setVarData("");
                                        C.SaveDT("Update Observation set VarData='',Observ='N', ObservDT='', FirstTm='', FInalTm='', Active='2' where DataID='"+ obj.getDataID() +"' and SL='"+ CSL +"' and VarName='"+ varlist1.getVarName() +"'");
                                    }
                                }
                            }else if(varlist.getVarName().equalsIgnoreCase("BabyDel") & !varlist.getStatus().equals("Y")){
                                for(int i=1; i<=22; i++) {
                                    VariableList_DataModel varlist1 = variableList.get(position + i);
                                    varlist1.setActive("2");
                                    varlist1.setStatus("N");
                                    varlist1.setVarData("");
                                    C.SaveDT("Update Observation set VarData='',Observ='N', ObservDT='', FirstTm='', FInalTm='', Active='2' where DataID='"+ obj.getDataID() +"' and SL='"+ CSL +"' and VarName='"+ varlist1.getVarName() +"'");
                                }
                            }

                            //Cord Apply
                            if(varlist.getVarName().equalsIgnoreCase("CordAppl") & varlist.getStatus().equals("Y")){
                                for(int i=1; i<=1; i++) {
                                    VariableList_DataModel varlist1 = variableList.get(position + i);
                                    varlist1.setActive("1");
                                    C.SaveDT("Update Observation set Active='1' where DataID='"+ obj.getDataID() +"' and SL='"+ CSL +"' and VarName='"+ varlist1.getVarName() +"'");
                                }
                            }else if(varlist.getVarName().equalsIgnoreCase("CordAppl") & !varlist.getStatus().equals("Y")){
                                for(int i=1; i<=1; i++) {
                                    VariableList_DataModel varlist1 = variableList.get(position + i);
                                    varlist1.setActive("2");
                                    varlist1.setStatus("N");
                                    varlist1.setVarData("");
                                    C.SaveDT("Update Observation set VarData='',Observ='N', ObservDT='', FirstTm='', FInalTm='', Active='2' where DataID='"+ obj.getDataID() +"' and SL='"+ CSL +"' and VarName='"+ varlist1.getVarName() +"'");
                                }
                            }

                            //Baby Wrap
                            if(varlist.getVarName().equalsIgnoreCase("BabyWrp") & varlist.getStatus().equals("Y")){
                                VariableList_DataModel varlist1 = variableList.get(position + 1);
                                varlist1.setActive("2");
                                varlist1.setStatus("N");
                                varlist1.setVarData("");
                                C.SaveDT("Update Observation set VarData='',Observ='N', ObservDT='', FirstTm='', FInalTm='', Active='2' where DataID='"+ obj.getDataID() +"' and SL='"+ CSL +"' and VarName='"+ varlist1.getVarName() +"'");

                                VariableList_DataModel varlist2 = variableList.get(position + 2);
                                varlist2.setActive("1");
                                C.SaveDT("Update Observation set Active='1' where DataID='"+ obj.getDataID() +"' and VarName='"+ varlist2.getVarName() +"'");

                            }else if(varlist.getVarName().equalsIgnoreCase("BabyWrp") & !varlist.getStatus().equals("Y")){
                                VariableList_DataModel varlist1 = variableList.get(position + 2);
                                varlist1.setActive("2");
                                varlist1.setStatus("N");
                                varlist1.setVarData("");
                                C.SaveDT("Update Observation set VarData='',Observ='N', ObservDT='', FirstTm='', FInalTm='', Active='2' where DataID='"+ obj.getDataID() +"' and SL='"+ CSL +"' and VarName='"+ varlist1.getVarName() +"'");

                                VariableList_DataModel varlist2 = variableList.get(position + 1);
                                varlist2.setActive("1");
                                C.SaveDT("Update Observation set Active='1' where DataID='"+ obj.getDataID() +"' and SL='"+ CSL +"' and VarName='"+ varlist2.getVarName() +"'");
                            }

                            //Birth Weight
                            if(varlist.getVarName().equalsIgnoreCase("BabyWt") & varlist.getStatus().equals("Y")){
                                for(int i=1; i<=2; i++) {
                                    VariableList_DataModel varlist1 = variableList.get(position + i);
                                    varlist1.setActive("1");
                                    C.SaveDT("Update Observation set Active='1' where DataID='"+ obj.getDataID() +"' and SL='"+ CSL +"' and VarName='"+ varlist1.getVarName() +"'");
                                }
                            }else if(varlist.getVarName().equalsIgnoreCase("BabyWt") & !varlist.getStatus().equals("Y")){
                                for(int i=1; i<=2; i++) {
                                    VariableList_DataModel varlist1 = variableList.get(position + i);
                                    varlist1.setActive("2");
                                    varlist1.setStatus("N");
                                    varlist1.setVarData("");
                                    C.SaveDT("Update Observation set VarData='',Observ='N', ObservDT='', FirstTm='', FInalTm='', Active='2' where DataID='"+ obj.getDataID() +"' and SL='"+ CSL +"' and VarName='"+ varlist1.getVarName() +"'");
                                }
                            }


                            //Table: Resus
                            //-----------------------------------------------------------------------------------------------------
                            if(varlist.getVarName().equalsIgnoreCase("BirthAsp") & varlist.getStatus().equals("Y")){
                                for(int i=1; i<=34; i++) {
                                    VariableList_DataModel varlist1 = variableList.get(position + i);
                                    if(!varlist1.getVarName().equalsIgnoreCase("StimOut") & !varlist1.getVarName().equalsIgnoreCase("MNOut")
                                            & !varlist1.getVarName().equalsIgnoreCase("SucType")
                                            & !varlist1.getVarName().equalsIgnoreCase("SucOut")

                                            & !varlist1.getVarName().equalsIgnoreCase("MaskPos")
                                            & !varlist1.getVarName().equalsIgnoreCase("MaskSize")
                                            & !varlist1.getVarName().equalsIgnoreCase("HeadPos")
                                            & !varlist1.getVarName().equalsIgnoreCase("BgMskInfSt")
                                            & !varlist1.getVarName().equalsIgnoreCase("BgMskInfEn")
                                            & !varlist1.getVarName().equalsIgnoreCase("EofTCycle")
                                            & !varlist1.getVarName().equalsIgnoreCase("BreathMin")
                                            & !varlist1.getVarName().equalsIgnoreCase("BreathMinAuto")
                                            & !varlist1.getVarName().equalsIgnoreCase("ChkChtMov")
                                            & !varlist1.getVarName().equalsIgnoreCase("ReposHead")
                                            & !varlist1.getVarName().equalsIgnoreCase("ChkHeartSou")
                                            & !varlist1.getVarName().equalsIgnoreCase("ChkHeartSouOut")

                                            & !varlist1.getVarName().equalsIgnoreCase("ChtCompType1")
                                            & !varlist1.getVarName().equalsIgnoreCase("ChtCompType2")
                                            ) {
                                        varlist1.setActive("1");
                                        C.SaveDT("Update Observation set Active='1' where DataID='" + obj.getDataID() + "' and SL='"+ CSL +"' and VarName='" + varlist1.getVarName() + "'");
                                    }else{
                                        varlist1.setActive("2");
                                        varlist1.setStatus("N");
                                        varlist1.setVarData("");
                                        C.SaveDT("Update Observation set VarData='',Observ='N', ObservDT='', FirstTm='', FInalTm='', Active='2' where DataID='"+ obj.getDataID() +"' and SL='"+ CSL +"' and VarName='"+ varlist1.getVarName() +"'");
                                    }
                                }
                            }else if(varlist.getVarName().equalsIgnoreCase("BirthAsp") & !varlist.getStatus().equals("Y")){
                                for(int i=1; i<=34; i++) {
                                    VariableList_DataModel varlist1 = variableList.get(position + i);
                                    varlist1.setActive("2");
                                    varlist1.setStatus("N");
                                    varlist1.setVarData("");
                                    C.SaveDT("Update Observation set VarData='',Observ='N', ObservDT='', FirstTm='', FInalTm='', Active='2' where DataID='"+ obj.getDataID() +"' and SL='"+ CSL +"' and VarName='"+ varlist1.getVarName() +"'");
                                }
                            }

                            //Stimulation
                            if(varlist.getVarName().equalsIgnoreCase("StimDone") & varlist.getStatus().equals("Y")){
                                for(int i=1; i<=1; i++) {
                                    VariableList_DataModel varlist1 = variableList.get(position + i);
                                    varlist1.setActive("1");
                                    C.SaveDT("Update Observation set Active='1' where DataID='"+ obj.getDataID() +"' and SL='"+ CSL +"' and VarName='"+ varlist1.getVarName() +"'");
                                }
                            }else if(varlist.getVarName().equalsIgnoreCase("StimDone") & !varlist.getStatus().equals("Y")){
                                for(int i=1; i<=1; i++) {
                                    VariableList_DataModel varlist1 = variableList.get(position + i);
                                    varlist1.setActive("2");
                                    varlist1.setStatus("N");
                                    varlist1.setVarData("");
                                    C.SaveDT("Update Observation set VarData='',Observ='N', ObservDT='', FirstTm='', FInalTm='', Active='2' where DataID='"+ obj.getDataID() +"' and SL='"+ CSL +"' and VarName='"+ varlist1.getVarName() +"'");
                                }
                            }
                            //Mouth Throat
                            if(varlist.getVarName().equalsIgnoreCase("MNChk") & varlist.getStatus().equals("Y")){
                                for(int i=1; i<=1; i++) {
                                    VariableList_DataModel varlist1 = variableList.get(position + i);
                                    varlist1.setActive("1");
                                    C.SaveDT("Update Observation set Active='1' where DataID='"+ obj.getDataID() +"' and SL='"+ CSL +"' and VarName='"+ varlist1.getVarName() +"'");
                                }
                            }else if(varlist.getVarName().equalsIgnoreCase("MNChk") & !varlist.getStatus().equals("Y")){
                                for(int i=1; i<=1; i++) {
                                    VariableList_DataModel varlist1 = variableList.get(position + i);
                                    varlist1.setActive("2");
                                    varlist1.setStatus("N");
                                    varlist1.setVarData("");
                                    C.SaveDT("Update Observation set VarData='',Observ='N', ObservDT='', FirstTm='', FInalTm='', Active='2' where DataID='"+ obj.getDataID() +"' and SL='"+ CSL +"' and VarName='"+ varlist1.getVarName() +"'");
                                }
                            }
                            //Suction
                            if(varlist.getVarName().equalsIgnoreCase("SucDone") & varlist.getStatus().equals("Y")){
                                for(int i=1; i<=2; i++) {
                                    VariableList_DataModel varlist1 = variableList.get(position + i);
                                    varlist1.setActive("1");
                                    C.SaveDT("Update Observation set Active='1' where DataID='"+ obj.getDataID() +"' and VarName='"+ varlist1.getVarName() +"'");
                                }
                            }else if(varlist.getVarName().equalsIgnoreCase("SucDone") & !varlist.getStatus().equals("Y")){
                                for(int i=1; i<=2; i++) {
                                    VariableList_DataModel varlist1 = variableList.get(position + i);
                                    varlist1.setActive("2");
                                    varlist1.setStatus("N");
                                    varlist1.setVarData("");
                                    C.SaveDT("Update Observation set VarData='',Observ='N', ObservDT='', FirstTm='', FInalTm='', Active='2' where DataID='"+ obj.getDataID() +"' and SL='"+ CSL +"' and VarName='"+ varlist1.getVarName() +"'");
                                }
                            }
                            //Bag and Mask
                            if(varlist.getVarName().equalsIgnoreCase("BagMask") & varlist.getStatus().equals("Y")){
                                for(int i=1; i<=12; i++) {
                                    VariableList_DataModel varlist1 = variableList.get(position + i);
                                    varlist1.setActive("1");
                                    C.SaveDT("Update Observation set Active='1' where DataID='"+ obj.getDataID() +"' and SL='"+ CSL +"' and VarName='"+ varlist1.getVarName() +"'");
                                }
                            }else if(varlist.getVarName().equalsIgnoreCase("BagMask") & !varlist.getStatus().equals("Y")){
                                for(int i=1; i<=12; i++) {
                                    VariableList_DataModel varlist1 = variableList.get(position + i);
                                    varlist1.setActive("2");
                                    varlist1.setStatus("N");
                                    varlist1.setVarData("");
                                    C.SaveDT("Update Observation set VarData='',Observ='N', ObservDT='', FirstTm='', FInalTm='', Active='2' where DataID='"+ obj.getDataID() +"' and SL='"+ CSL +"' and VarName='"+ varlist1.getVarName() +"'");
                                }
                            }
                            //Drug1
                            if(varlist.getVarName().equalsIgnoreCase("ChtCompDrug1") & varlist.getStatus().equals("Y")){
                                for(int i=1; i<=1; i++) {
                                    VariableList_DataModel varlist1 = variableList.get(position + i);
                                    varlist1.setActive("1");
                                    C.SaveDT("Update Observation set Active='1' where DataID='"+ obj.getDataID() +"' and SL='"+ CSL +"' and VarName='"+ varlist1.getVarName() +"'");
                                }
                            }else if(varlist.getVarName().equalsIgnoreCase("ChtCompDrug1") & !varlist.getStatus().equals("Y")){
                                for(int i=1; i<=1; i++) {
                                    VariableList_DataModel varlist1 = variableList.get(position + i);
                                    varlist1.setActive("2");
                                    varlist1.setStatus("N");
                                    varlist1.setVarData("");
                                    C.SaveDT("Update Observation set VarData='',Observ='N', ObservDT='', FirstTm='', FInalTm='', Active='2' where DataID='"+ obj.getDataID() +"' and SL='"+ CSL +"' and VarName='"+ varlist1.getVarName() +"'");
                                }
                            }
                            //Drug2
                            if(varlist.getVarName().equalsIgnoreCase("ChtCompDrug2") & varlist.getStatus().equals("Y")){
                                for(int i=1; i<=1; i++) {
                                    VariableList_DataModel varlist1 = variableList.get(position + i);
                                    varlist1.setActive("1");
                                    C.SaveDT("Update Observation set Active='1' where DataID='"+ obj.getDataID() +"' and VarName='"+ varlist1.getVarName() +"'");
                                }
                            }else if(varlist.getVarName().equalsIgnoreCase("ChtCompDrug2") & !varlist.getStatus().equals("Y")){
                                for(int i=1; i<=1; i++) {
                                    VariableList_DataModel varlist1 = variableList.get(position + i);
                                    varlist1.setActive("2");
                                    varlist1.setStatus("N");
                                    varlist1.setVarData("");
                                    C.SaveDT("Update Observation set VarData='',Observ='N', ObservDT='', FirstTm='', FInalTm='', Active='2' where DataID='"+ obj.getDataID() +"' and VarName='"+ varlist1.getVarName() +"'");
                                }
                            }


                            //Table: 3rd Stage & PPH
                            //-----------------------------------------------------------------------------------------------------
                            //Uterotonic given after delivery
                            if(varlist.getVarName().equalsIgnoreCase("Utero") & varlist.getStatus().equals("Y")){
                                for(int i=1; i<=4; i++) {
                                    VariableList_DataModel varlist1 = variableList.get(position + i);
                                    varlist1.setActive("1");
                                    C.SaveDT("Update Observation set Active='1' where DataID='"+ obj.getDataID() +"' and VarName='"+ varlist1.getVarName() +"'");
                                }
                            }else if(varlist.getVarName().equalsIgnoreCase("Utero") & !varlist.getStatus().equals("Y")){
                                for(int i=1; i<=4; i++) {
                                    VariableList_DataModel varlist1 = variableList.get(position + i);
                                    varlist1.setActive("2");
                                    varlist1.setStatus("N");
                                    varlist1.setVarData("");
                                    C.SaveDT("Update Observation set VarData='',Observ='N', ObservDT='', FirstTm='', FInalTm='', Active='2' where DataID='"+ obj.getDataID() +"' and VarName='"+ varlist1.getVarName() +"'");
                                }
                            }

                            //Uterotonic given after PPH
                            if(varlist.getVarName().equalsIgnoreCase("UtePPH") & varlist.getStatus().equals("Y")){
                                for(int i=1; i<=2; i++) {
                                    VariableList_DataModel varlist1 = variableList.get(position + i);
                                    varlist1.setActive("1");
                                    C.SaveDT("Update Observation set Active='1' where DataID='"+ obj.getDataID() +"' and VarName='"+ varlist1.getVarName() +"'");
                                }
                            }else if(varlist.getVarName().equalsIgnoreCase("UtePPH") & !varlist.getStatus().equals("Y")){
                                for(int i=1; i<=2; i++) {
                                    VariableList_DataModel varlist1 = variableList.get(position + i);
                                    varlist1.setActive("2");
                                    varlist1.setStatus("N");
                                    varlist1.setVarData("");
                                    C.SaveDT("Update Observation set VarData='',Observ='N', ObservDT='', FirstTm='', FInalTm='', Active='2' where DataID='"+ obj.getDataID() +"' and VarName='"+ varlist1.getVarName() +"'");
                                }
                            }

                            //Antibiotic given
                            if(varlist.getVarName().equalsIgnoreCase("AntGiv") & varlist.getStatus().equals("Y")){
                                VariableList_DataModel varlist1 = variableList.get(position + 1);
                                varlist1.setActive("1");
                                C.SaveDT("Update Observation set Active='1' where DataID='"+ obj.getDataID() +"' and VarName='"+ varlist1.getVarName() +"'");

                                VariableList_DataModel varlist2 = variableList.get(position + 3);
                                varlist2.setActive("1");
                                C.SaveDT("Update Observation set Active='1' where DataID='"+ obj.getDataID() +"' and VarName='"+ varlist2.getVarName() +"'");

                            }else if(varlist.getVarName().equalsIgnoreCase("AntGiv") & !varlist.getStatus().equals("Y")){
                                for(int i=1; i<=4; i++) {
                                    VariableList_DataModel varlist1 = variableList.get(position + i);
                                    varlist1.setActive("2");
                                    varlist1.setStatus("N");
                                    varlist1.setVarData("");
                                    C.SaveDT("Update Observation set VarData='',Observ='N', ObservDT='', FirstTm='', FInalTm='', Active='2' where DataID='"+ obj.getDataID() +"' and VarName='"+ varlist1.getVarName() +"'");
                                }
                            }

                            //Analgesia Given
                            if(varlist.getVarName().equalsIgnoreCase("AnalGiv") & varlist.getStatus().equals("Y")){
                                VariableList_DataModel varlist1 = variableList.get(position + 1);
                                varlist1.setActive("1");
                                C.SaveDT("Update Observation set Active='1' where DataID='"+ obj.getDataID() +"' and VarName='"+ varlist1.getVarName() +"'");

                                VariableList_DataModel varlist2 = variableList.get(position + 3);
                                varlist2.setActive("1");
                                C.SaveDT("Update Observation set Active='1' where DataID='"+ obj.getDataID() +"' and VarName='"+ varlist2.getVarName() +"'");

                            }else if(varlist.getVarName().equalsIgnoreCase("AnalGiv") & !varlist.getStatus().equals("Y")){
                                for(int i=1; i<=4; i++) {
                                    VariableList_DataModel varlist1 = variableList.get(position + i);
                                    varlist1.setActive("2");
                                    varlist1.setStatus("N");
                                    varlist1.setVarData("");
                                    C.SaveDT("Update Observation set VarData='',Observ='N', ObservDT='', FirstTm='', FInalTm='', Active='2' where DataID='"+ obj.getDataID() +"' and VarName='"+ varlist1.getVarName() +"'");
                                }
                            }

                            //Manual Removal of Placenta (MRP)
                            if(varlist.getVarName().equalsIgnoreCase("MRPlacen") & varlist.getStatus().equals("Y")){
                                for(int i=1; i<=2; i++) {
                                    VariableList_DataModel varlist1 = variableList.get(position + i);
                                    varlist1.setActive("1");
                                    C.SaveDT("Update Observation set Active='1' where DataID='"+ obj.getDataID() +"' and VarName='"+ varlist1.getVarName() +"'");
                                }
                            }else if(varlist.getVarName().equalsIgnoreCase("MRPlacen") & !varlist.getStatus().equals("Y")){
                                for(int i=1; i<=2; i++) {
                                    VariableList_DataModel varlist1 = variableList.get(position + i);
                                    varlist1.setActive("2");
                                    varlist1.setStatus("N");
                                    varlist1.setVarData("");
                                    C.SaveDT("Update Observation set VarData='',Observ='N', ObservDT='', FirstTm='', FInalTm='', Active='2' where DataID='"+ obj.getDataID() +"' and VarName='"+ varlist1.getVarName() +"'");
                                }
                            }


                            mAdapter.variableList.set(position, varlist);
                            //recyclerView.invalidate();
                            //mAdapter.notifyItemChanged(position);
                            mAdapter.notifyDataSetChanged();
                        }
                    });
                }


                //TextBox
                else if (varlist.getControlType().equals("2")) {
                    holder.objDescription.setVisibility(View.VISIBLE);
                    holder.txtData.setVisibility(View.VISIBLE);
                    holder.btnData.setVisibility(View.VISIBLE);
                    holder.dataDescription.setVisibility(View.GONE);
                    holder.spnDataList.setVisibility(View.GONE);
                    holder.txtData.setText(varlist.getVarData());

                    //Length
                    if (varlist.getVarLength().length() != 0)
                        holder.txtData.setFilters(new InputFilter[]{new InputFilter.LengthFilter(Integer.valueOf(varlist.getVarLength()))});

                    //Data Type
                    if (varlist.getVarDataType().equals("1"))
                        holder.txtData.setInputType(InputType.TYPE_CLASS_TEXT);
                    else if (varlist.getVarDataType().equals("2"))
                        holder.txtData.setInputType(InputType.TYPE_CLASS_NUMBER);
                    else holder.txtData.setInputType(InputType.TYPE_CLASS_TEXT);


                    //Active
                    if (varlist.getActive().equals("1")) {
                        holder.objCheckList.setEnabled(true);
                        holder.txtData.setEnabled(true);
                        holder.btnData.setEnabled(true);
                        holder.objCheckList.setBackgroundColor(Color.parseColor("#FFFFFF"));

                        if (varlist.getStatus().equals("Y")) {
                            holder.objCheckList.setBackgroundColor(Color.parseColor("#69CB3F"));
                        } else if (varlist.getStatus().equals("C")) {
                            holder.objCheckList.setBackgroundColor(Color.parseColor("#FF0000"));
                        } else if (varlist.getStatus().equals("N")) {
                            holder.objCheckList.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        } else {
                            holder.objCheckList.setBackgroundColor(Color.parseColor("#D7D7D7"));
                        }
                    } else {
                        holder.objCheckList.setEnabled(false);
                        holder.txtData.setEnabled(false);
                        holder.btnData.setEnabled(false);
                        holder.objCheckList.setBackgroundColor(Color.parseColor("#D7D7D7"));
                    }


                    holder.btnData.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {

                            if (holder.txtData.getText().length() == 0) return;

                            Observation_DataModel obj = new Observation_DataModel();
                            obj.setCountryCode(COUNTRYCODE);
                            obj.setFaciCode(FACICODE);
                            obj.setTableId(TABLEID);
                            obj.setDataID(DATAID);
                            obj.setVarName(varlist.getVarName());
                            if (WOMAN_CHILD.equals("c") | WOMAN_CHILD.equals("r"))
                                obj.setSL(varlist.getSL());

                            if (varlist.getStatus().equals("Y")) {
                                obj.setObserv("C");
                                varlist.setStatus("C");
                                mAdapter.variableList.set(position, varlist);
                            } else if (varlist.getStatus().equals("C")) {
                                obj.setObserv("N");
                                varlist.setStatus("N");
                                mAdapter.variableList.set(position, varlist);
                            } else if (varlist.getStatus().equals("N")) {
                                obj.setObserv("Y");
                                varlist.setStatus("Y");
                                mAdapter.variableList.set(position, varlist);
                            } else {
                                obj.setObserv("N");
                                varlist.setStatus("N");
                                mAdapter.variableList.set(position, varlist);
                            }

                            obj.setVarData(holder.txtData.getText().toString());
                            obj.setObserv("Y");
                            varlist.setStatus("Y");
                            varlist.setVarData(holder.txtData.getText().toString());

                            obj.setObservDT(Global.DateNowYMD());
                            obj.setFirstTm(g.CurrentTime24());
                            obj.setFinalTm(g.CurrentTime24());
                            obj.setEnDt(Global.DateTimeNowYMDHMS());
                            obj.setDeviceID(DEVICEID);
                            obj.setEntryUser(ENTRYUSER);
                            obj.SaveUpdateData(Observation_Time.this);

                            //recyclerView.invalidate();
                            //mAdapter.notifyItemChanged(position);
                            holder.txtData.requestFocus();
                            mAdapter.notifyDataSetChanged();
                        }
                    });
                }


                //Dropdown List
                else if (varlist.getControlType().equals("3")) {
                    int pos = 0;

                    holder.objDescription.setVisibility(View.GONE);
                    holder.dataDescription.setText(varlist.getDescription());
                    holder.dataDescription.setVisibility(View.VISIBLE);
                    holder.spnDataList.setVisibility(View.VISIBLE);

                    //Active
                    if (varlist.getActive().equals("1")) {
                        holder.objCheckList.setEnabled(true);
                        holder.txtData.setEnabled(true);
                        holder.btnData.setEnabled(true);
                        holder.spnDataList.setVisibility(View.VISIBLE);
                        holder.objCheckList.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        //holder.objCheckList.setBackgroundColor(Color.parseColor("#69CB3F"));

                        if (varlist.getStatus().equals("Y")) {
                            holder.objCheckList.setBackgroundColor(Color.parseColor("#69CB3F"));
                        } else if (varlist.getStatus().equals("C")) {
                            holder.objCheckList.setBackgroundColor(Color.parseColor("#FF0000"));
                        } else if (varlist.getStatus().equals("N")) {
                            holder.objCheckList.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        } else {
                            holder.objCheckList.setBackgroundColor(Color.parseColor("#D7D7D7"));
                        }
                    } else {
                        //holder.objCheckList.setVisibility(View.INVISIBLE);
                        holder.objCheckList.setEnabled(false);
                        holder.txtData.setEnabled(false);
                        holder.btnData.setEnabled(false);
                        holder.spnDataList.setVisibility(View.GONE);
                        holder.objCheckList.setBackgroundColor(Color.parseColor("#D7D7D7"));
                    }


                    String[] Opn = varlist.getVarOption().split(",");
                    List<String> listSpinnerItem = new ArrayList<String>();
                    listSpinnerItem.add("");

                    if(COUNTRYCODE.equals(ProjectSetting.NEPAL) & varlist.getVarName().equalsIgnoreCase("objplace")){
                        listSpinnerItem.add("Labour Room");
                        listSpinnerItem.add("Other");
                        //listSpinnerItem.add("MNSC");
                    }else if(COUNTRYCODE.equals(ProjectSetting.NEPAL) & (varlist.getVarName().equalsIgnoreCase("deltypsta")|varlist.getVarName().equalsIgnoreCase("deltypfnl"))){
                        listSpinnerItem.add("Vaginal");
                        listSpinnerItem.add("Vaginal Breech");
                        listSpinnerItem.add("Forcep");
                        listSpinnerItem.add("Vacuum");
                        listSpinnerItem.add("Emergency CS");
                    }else if(COUNTRYCODE.equals(ProjectSetting.NEPAL) & varlist.getVarName().equalsIgnoreCase("DelPlace")) {
                        listSpinnerItem.add("Labour Room");
                        listSpinnerItem.add("Other");
                    }else if(!COUNTRYCODE.equals(ProjectSetting.NEPAL) & varlist.getVarName().equalsIgnoreCase("DelPlace")) {
                        listSpinnerItem.add("Labour Room");
                        listSpinnerItem.add("Admission Room");
                        listSpinnerItem.add("Labour Room");
                        listSpinnerItem.add("Operation Theatre");
                        listSpinnerItem.add("Other");
                    }
                    else {
                        for (int i = 0; i < Opn.length; i++) {
                            listSpinnerItem.add(Opn[i].toString().trim());
                        }
                    }

                    ArrayAdapter<String> adptrMotEthnicity = new ArrayAdapter<String>(Observation_Time.this, android.R.layout.simple_spinner_item, listSpinnerItem);

                    holder.spnDataList.setAdapter(adptrMotEthnicity);

                    if (varlist.getVarData().length() > 0) {
                        for (int i = 0; i < holder.spnDataList.getCount(); i++) {
                            if ((holder.spnDataList.getItemAtPosition(i).equals(varlist.getVarData()))) {
                                pos = i;
                            }
                        }

                        holder.spnDataList.setSelection(pos);
                    }

                    holder.spnDataList.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            spinnerTouched = true;
                            return false;
                        }
                    });

                    holder.spnDataList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int p, long id) {
                            if (spinnerTouched == true) {
                                //View v = spinner.getSelectedView();
                                //((TextView)selectedItemView).setTextColor(Color.RED);
                                //((TextView)selectedItemView).setTextSize(12);

                                Observation_DataModel obj = new Observation_DataModel();
                                obj.setCountryCode(COUNTRYCODE);
                                obj.setFaciCode(FACICODE);
                                obj.setTableId(TABLEID);
                                obj.setDataID(DATAID);
                                obj.setVarName(varlist.getVarName());
                                if (WOMAN_CHILD.equals("c") | WOMAN_CHILD.equals("r"))
                                    obj.setSL(varlist.getSL());

                                obj.setVarData(holder.spnDataList.getSelectedItemPosition() > 0 ? holder.spnDataList.getSelectedItem().toString() : "");
                                if(holder.spnDataList.getSelectedItemPosition()==0) {
                                    obj.setObserv("N");
                                    varlist.setStatus("N");
                                }else{
                                    obj.setObserv("Y");
                                    varlist.setStatus("Y");
                                }

                                varlist.setVarData(holder.spnDataList.getSelectedItemPosition() > 0 ? holder.spnDataList.getSelectedItem().toString() : "");

                                obj.setObservDT(Global.DateNowYMD());
                                obj.setFirstTm(g.CurrentTime24());
                                obj.setFinalTm(g.CurrentTime24());
                                obj.setEnDt(Global.DateTimeNowYMDHMS());
                                obj.setDeviceID(DEVICEID);
                                obj.setEntryUser(ENTRYUSER);
                                obj.SaveUpdateData(Observation_Time.this);

                                //Skip Rule

                                //Table: L&D 1st and 2nd Stage
                                //Observation Place: Other
                                if(varlist.getVarName().equalsIgnoreCase("ObjPlace") & holder.spnDataList.getSelectedItem().toString().equalsIgnoreCase("other")){
                                    VariableList_DataModel varlist1 = variableList.get(position+1);
                                    varlist1.setActive("1");
                                    C.SaveDT("Update Observation set Active='1' where DataID='"+ obj.getDataID() +"' and VarName='"+ varlist1.getVarName() +"'");
                                }else if(varlist.getVarName().equalsIgnoreCase("ObjPlace") & !holder.spnDataList.getSelectedItem().toString().equalsIgnoreCase("other")) {
                                    VariableList_DataModel varlist1 = variableList.get(position + 1);
                                    varlist1.setActive("2");
                                    varlist1.setStatus("N");
                                    varlist1.setVarData("");
                                    C.SaveDT("Update Observation set VarData='',Observ='N', ObservDT='', FirstTm='', FInalTm='', Active='2' where DataID='"+ obj.getDataID() +"' and VarName='"+ varlist1.getVarName() +"'");
                                }

                                //Table: Newborn
                                //Place of Birth: Other
                                if(varlist.getVarName().equalsIgnoreCase("DelPlace") & holder.spnDataList.getSelectedItem().toString().equalsIgnoreCase("other")){
                                    VariableList_DataModel varlist1 = variableList.get(position+1);
                                    varlist1.setActive("1");
                                    C.SaveDT("Update Observation set Active='1' where DataID='"+ obj.getDataID() +"' and VarName='"+ varlist1.getVarName() +"'");
                                }else if(varlist.getVarName().equalsIgnoreCase("DelPlace") & !holder.spnDataList.getSelectedItem().toString().equalsIgnoreCase("other")) {
                                    VariableList_DataModel varlist1 = variableList.get(position + 1);
                                    varlist1.setActive("2");
                                    varlist1.setStatus("N");
                                    varlist1.setVarData("");
                                    C.SaveDT("Update Observation set VarData='',Observ='N', ObservDT='', FirstTm='', FInalTm='', Active='2' where DataID='"+ obj.getDataID() +"' and VarName='"+ varlist1.getVarName() +"'");
                                }

                                //Cord apply type
                                if(varlist.getVarName().equalsIgnoreCase("CordApTyp") & holder.spnDataList.getSelectedItem().toString().equalsIgnoreCase("other")){
                                    VariableList_DataModel varlist1 = variableList.get(position+1);
                                    varlist1.setActive("1");
                                    C.SaveDT("Update Observation set Active='1' where DataID='"+ obj.getDataID() +"' and VarName='"+ varlist1.getVarName() +"'");
                                }else if(varlist.getVarName().equalsIgnoreCase("CordApTyp") & !holder.spnDataList.getSelectedItem().toString().equalsIgnoreCase("other")){
                                    VariableList_DataModel varlist1 = variableList.get(position + 1);
                                    varlist1.setActive("2");
                                    varlist1.setStatus("N");
                                    varlist1.setVarData("");
                                    C.SaveDT("Update Observation set VarData='',Observ='N', ObservDT='', FirstTm='', FInalTm='', Active='2' where DataID='"+ obj.getDataID() +"' and VarName='"+ varlist1.getVarName() +"'");
                                }


                                //Bleeding after delivery
                                //stop on 02 oct 2017
                                //if(varlist.getVarName().equalsIgnoreCase("PPH") & !holder.spnDataList.getSelectedItem().toString().equalsIgnoreCase("normal")){
                                //update on: 02 oct 2017
                                if(varlist.getVarName().equalsIgnoreCase("PPH")){
                                    for(int i=1; i<=35; i++) {
                                        VariableList_DataModel varlist1 = variableList.get(position + i);
                                        if(!varlist1.getVarName().equalsIgnoreCase("UtePPHTyp") & !varlist1.getVarName().equalsIgnoreCase("UtePPHRoute")
                                                & !varlist1.getVarName().equalsIgnoreCase("AntGivTyp")
                                                & !varlist1.getVarName().equalsIgnoreCase("AntiGivTypOth")
                                                & !varlist1.getVarName().equalsIgnoreCase("AntGivRout")
                                                & !varlist1.getVarName().equalsIgnoreCase("AntiGivRoutOth")

                                                & !varlist1.getVarName().equalsIgnoreCase("AnalGivTyp")
                                                & !varlist1.getVarName().equalsIgnoreCase("AnalGivTypOth")
                                                & !varlist1.getVarName().equalsIgnoreCase("AnalGivRout")
                                                & !varlist1.getVarName().equalsIgnoreCase("AnalGivRoutOth")

                                                & !varlist1.getVarName().equalsIgnoreCase("HWashMRP")
                                                & !varlist1.getVarName().equalsIgnoreCase("SGlovMRP")
                                                ) {
                                            varlist1.setActive("1");
                                            C.SaveDT("Update Observation set Active='1' where DataID='" + obj.getDataID() + "' and VarName='" + varlist1.getVarName() + "'");
                                        }else{
                                            varlist1.setActive("2");
                                            varlist1.setStatus("N");
                                            varlist1.setVarData("");
                                            C.SaveDT("Update Observation set VarData='',Observ='N', ObservDT='', FirstTm='', FInalTm='', Active='2' where DataID='"+ obj.getDataID() +"' and VarName='"+ varlist1.getVarName() +"'");
                                        }
                                    }
                                }
                                //stop on 02 oct 2017
                                /*else if(varlist.getVarName().equalsIgnoreCase("PPH") & holder.spnDataList.getSelectedItem().toString().equalsIgnoreCase("normal")){
                                    for(int i=1; i<=35; i++) {
                                        VariableList_DataModel varlist1 = variableList.get(position + i);

                                        if(varlist1.getVarName().equalsIgnoreCase("MRPlacen") | varlist1.getVarName().equalsIgnoreCase("AntGiv") | varlist1.getVarName().equalsIgnoreCase("AnalGiv")) {
                                            varlist1.setActive("1");
                                            C.SaveDT("Update Observation set Active='1' where DataID='" + obj.getDataID() + "' and VarName='" + varlist1.getVarName() + "'");
                                        }else {
                                            varlist1.setActive("2");
                                            varlist1.setStatus("N");
                                            varlist1.setVarData("");
                                            C.SaveDT("Update Observation set VarData='',Observ='N', ObservDT='', FirstTm='', FInalTm='', Active='2' where DataID='" + obj.getDataID() + "' and VarName='" + varlist1.getVarName() + "'");
                                        }
                                    }
                                }*/


                                //Antibiotic Type
                                if(varlist.getVarName().equalsIgnoreCase("AntGivTyp") & holder.spnDataList.getSelectedItem().toString().equalsIgnoreCase("others")){
                                    VariableList_DataModel varlist1 = variableList.get(position+1);
                                    varlist1.setActive("1");
                                    C.SaveDT("Update Observation set Active='1' where DataID='"+ obj.getDataID() +"' and VarName='"+ varlist1.getVarName() +"'");
                                }else if(varlist.getVarName().equalsIgnoreCase("AntGivTyp") & !holder.spnDataList.getSelectedItem().toString().equalsIgnoreCase("others")){
                                    VariableList_DataModel varlist1 = variableList.get(position + 1);
                                    varlist1.setActive("2");
                                    varlist1.setStatus("N");
                                    varlist1.setVarData("");
                                    C.SaveDT("Update Observation set VarData='',Observ='N', ObservDT='', FirstTm='', FInalTm='', Active='2' where DataID='"+ obj.getDataID() +"' and VarName='"+ varlist1.getVarName() +"'");
                                }

                                //Antibiotic Route
                                if(varlist.getVarName().equalsIgnoreCase("AntGivRout") & holder.spnDataList.getSelectedItem().toString().equalsIgnoreCase("others")){
                                    VariableList_DataModel varlist1 = variableList.get(position+1);
                                    varlist1.setActive("1");
                                    C.SaveDT("Update Observation set Active='1' where DataID='"+ obj.getDataID() +"' and VarName='"+ varlist1.getVarName() +"'");
                                }else if(varlist.getVarName().equalsIgnoreCase("AntGivRout") & !holder.spnDataList.getSelectedItem().toString().equalsIgnoreCase("others")){
                                    VariableList_DataModel varlist1 = variableList.get(position + 1);
                                    varlist1.setActive("2");
                                    varlist1.setStatus("N");
                                    varlist1.setVarData("");
                                    C.SaveDT("Update Observation set VarData='',Observ='N', ObservDT='', FirstTm='', FInalTm='', Active='2' where DataID='"+ obj.getDataID() +"' and VarName='"+ varlist1.getVarName() +"'");
                                }

                                //Analgesia Type
                                if(varlist.getVarName().equalsIgnoreCase("AnalGivTyp") & holder.spnDataList.getSelectedItem().toString().equalsIgnoreCase("others")){
                                    VariableList_DataModel varlist1 = variableList.get(position+1);
                                    varlist1.setActive("1");
                                    C.SaveDT("Update Observation set Active='1' where DataID='"+ obj.getDataID() +"' and VarName='"+ varlist1.getVarName() +"'");
                                }else if(varlist.getVarName().equalsIgnoreCase("AnalGivTyp") & !holder.spnDataList.getSelectedItem().toString().equalsIgnoreCase("other")){
                                    VariableList_DataModel varlist1 = variableList.get(position + 1);
                                    varlist1.setActive("2");
                                    varlist1.setStatus("N");
                                    varlist1.setVarData("");
                                    C.SaveDT("Update Observation set VarData='',Observ='N', ObservDT='', FirstTm='', FInalTm='', Active='2' where DataID='"+ obj.getDataID() +"' and VarName='"+ varlist1.getVarName() +"'");
                                }

                                //Analgesia Route
                                if(varlist.getVarName().equalsIgnoreCase("AnalGivRout") & holder.spnDataList.getSelectedItem().toString().equalsIgnoreCase("others")){
                                    VariableList_DataModel varlist1 = variableList.get(position+1);
                                    varlist1.setActive("1");
                                    C.SaveDT("Update Observation set Active='1' where DataID='"+ obj.getDataID() +"' and VarName='"+ varlist1.getVarName() +"'");
                                }else if(varlist.getVarName().equalsIgnoreCase("AnalGivRout") & !holder.spnDataList.getSelectedItem().toString().equalsIgnoreCase("other")){
                                    VariableList_DataModel varlist1 = variableList.get(position + 1);
                                    varlist1.setActive("2");
                                    varlist1.setStatus("N");
                                    varlist1.setVarData("");
                                    C.SaveDT("Update Observation set VarData='',Observ='N', ObservDT='', FirstTm='', FInalTm='', Active='2' where DataID='"+ obj.getDataID() +"' and VarName='"+ varlist1.getVarName() +"'");
                                }


                                mAdapter.variableList.set(position, varlist);

                                //recyclerView.invalidate();
                                //mAdapter.notifyItemChanged(position);
                                //mAdapter.notifyDataSetChanged();
                                mAdapter.notifyDataSetChanged();
                                spinnerTouched = false;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parentView) {
                            // your code here
                        }

                    });

                }
            }catch(Exception ex)
            {

            }
            //**************************************************************************************


        }

        @Override
        public int getItemCount() {
            return variableList.size();
        }
    }


    public class VariableList_DataModel {
        private String _TableId = "";
        public String getTableId(){
            return _TableId;
        }
        public void setTableId(String newValue){
            _TableId = newValue;
        }

        private String _VarName = "";
        public String getVarName(){
            return _VarName;
        }
        public void setVarName(String newValue){
            _VarName = newValue;
        }

        private String _SL = "";
        public String getSL(){
            return _SL;
        }
        public void setSL(String newValue){
            _SL = newValue;
        }

        private String _Description = "";
        public String getDescription(){
            return _Description;
        }
        public void setDescription(String newValue){
            _Description = newValue;
        }

        private String _ObjSeq1 = "";
        public String getObjSeq1(){
            return _ObjSeq1;
        }
        public void setObjSeq1(String newValue){
            _ObjSeq1 = newValue;
        }

        private String _ObjSeq2 = "";
        public String getObjSeq2(){
            return _ObjSeq2;
        }
        public void setObjSeq2(String newValue){
            _ObjSeq2 = newValue;
        }

        private String _Status = "";
        public String getStatus(){
            return _Status;
        }
        public void setStatus(String newValue){
            _Status = newValue;
        }

        private String _VarData = "";
        public String getVarData(){
            return _VarData;
        }
        public void setVarData(String newValue){
            _VarData = newValue;
        }

        private String _ControlType = "";
        public String getControlType(){
            return _ControlType;
        }
        public void setControlType(String newValue){
            _ControlType = newValue;
        }

        private String _VarOption = "";
        public String getVarOption(){
            return _VarOption;
        }
        public void setVarOption(String newValue){
            _VarOption = newValue;
        }

        private String _VarLength = "";
        public String getVarLength(){
            return _VarLength;
        }
        public void setVarLength(String newValue){
            _VarLength = newValue;
        }

        private String _VarDataType = "";
        public String getVarDataType(){
            return _VarDataType;
        }
        public void setVarDataType(String newValue){
            _VarDataType = newValue;
        }

        private String _Color = "";
        public String getColor(){
            return _Color;
        }
        public void setColor(String newValue){
            _Color = newValue;
        }

        private String _Active = "";
        public String getActive(){
            return _Active;
        }
        public void setActive(String newValue){
            _Active = newValue;
        }

        private String _Important = "";
        public String getImportant(){
            return _Important;
        }
        public void setImportant(String newValue){
            _Important = newValue;
        }

        private String _ForceVar = "";
        public String getForceVar(){
            return _ForceVar;
        }
        public void setForceVar(String newValue){
            _ForceVar = newValue;
        }
    }


    public class DividerItemDecoration extends RecyclerView.ItemDecoration {
        private final int[] ATTRS = new int[]{
                android.R.attr.listDivider
        };

        public static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;

        public static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;

        private Drawable mDivider;

        private int mOrientation;

        public DividerItemDecoration(Context context, int orientation) {
            final TypedArray a = context.obtainStyledAttributes(ATTRS);
            mDivider = a.getDrawable(0);
            a.recycle();
            setOrientation(orientation);
        }

        public void setOrientation(int orientation) {
            if (orientation != HORIZONTAL_LIST && orientation != VERTICAL_LIST) {
                throw new IllegalArgumentException("invalid orientation");
            }
            mOrientation = orientation;
        }

        @Override
        public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
            if (mOrientation == VERTICAL_LIST) {
                //drawVertical(c, parent);
            } else {
                //drawHorizontal(c, parent);
            }
        }

        public void drawVertical(Canvas c, RecyclerView parent) {
            final int left = parent.getPaddingLeft();
            final int right = parent.getWidth() - parent.getPaddingRight();

            final int childCount = parent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                final View child = parent.getChildAt(i);
                final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                        .getLayoutParams();
                final int top = child.getBottom() + params.bottomMargin;
                final int bottom = top + mDivider.getIntrinsicHeight();
                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(c);
            }
        }

        public void drawHorizontal(Canvas c, RecyclerView parent) {
            final int top = parent.getPaddingTop();
            final int bottom = parent.getHeight() - parent.getPaddingBottom();

            final int childCount = parent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                final View child = parent.getChildAt(i);
                final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                        .getLayoutParams();
                final int left = child.getRight() + params.rightMargin;
                final int right = left + mDivider.getIntrinsicHeight();
                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(c);
            }
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            if (mOrientation == VERTICAL_LIST) {
                outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
            } else {
                outRect.set(0, 0, mDivider.getIntrinsicWidth(), 0);
            }
        }
    }



    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {
        private GestureDetector gestureDetector;
        private RecyclerTouchListener.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final RecyclerTouchListener.ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {

                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            try {
                View child = rv.findChildViewUnder(e.getX(), e.getY());
                if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                    clickListener.onClick(child, rv.getChildPosition(child));
                }
            }
            catch(Exception ex){

            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }

        interface ClickListener {
            void onClick(View view, int position);
            void onLongClick(View view, int position);
        }
    }
}
