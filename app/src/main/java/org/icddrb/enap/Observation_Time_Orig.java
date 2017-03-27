package org.icddrb.enap;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.InputFilter;
import android.text.InputType;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Common.Connection;
import Common.Global;
import Utility.MySharedPreferences;

/**
 * Created by TanvirHossain on 05/12/2016.
 */

public class Observation_Time_Orig extends AppCompatActivity {
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
    Global g;
    Connection C;
    private Boolean spinnerTouched = false;
    GridLayoutManager manager;

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

        IDbundle = getIntent().getExtras();
        TABLEID  = IDbundle.getString("tableid");;
        DATAID   = IDbundle.getString("dataid");

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
                VariableList_DataModel variable = variableList.get(position);
                //Toast.makeText(getApplicationContext(), variable.getDescription() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }

        }));

        manager = new GridLayoutManager(this, 4);
        //dynamically changing the total number of column
        /*manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                //Labour and Delivery
                if(TABLEID.equals("1")) {
                    if (position == 1) {
                        return 2;
                    } else if (position == 2) {
                        return 3;
                    } else if (position == 9) {
                        return 3;
                    } else if (position == 32) {
                        return 3;
                    }else {
                        return 1;
                    }
                }
                //Birth Asphyxia and Resuscitation
                else if(TABLEID.equals("2")) {
                    if (position == 1) {
                        return 2;
                    } else if (position == 3) {
                        return 2;
                    } else if (position == 5) {
                        return 2;
                    } else if (position == 7) {
                        return 1;
                    } else if (position == 9) {
                        return 3;
                    } else if (position == 18) {
                        return 1;
                    }else {
                        return 1;
                    }
                }
                //PPH
                else if(TABLEID.equals("3")) {
                    if (position == 10) {
                        return 2;
                    }else {
                        return 1;
                    }
                }else {
                    return 1;
                }

                //return 2; //(3 - position % 3);
            }
        });*/
        recyclerView.setLayoutManager(manager);

        prepareVariableListData(TABLEID, DATAID, "w","");
    }

    public void refreshAdapter(){
        mAdapter.notifyDataSetChanged();
    }

    public void prepareVariableListData(String TableId, String DataId ,String WomanChild, String ChildSL) {
        TABLEID = TableId;
        DATAID  = DataId;
        String SQL = "";

        if(WomanChild.equals("w")) {
            SQL = "Insert into Observation(CountryCode,FaciCode,TableId,DataID,VarName,Observ,VarData,ObservDT,FirstTm,FinalTm,EnDt,DeviceId,EntryUser,Upload,modifyDate)";
            SQL += " Select '"+ COUNTRYCODE +"' CountryCode,'"+ FACICODE +"' FaciCode, '"+ TableId +"' TableId,'"+ DataId +"' DataID, VarName,'N'Observ,'' VarData,''ObservDT,''FirstTm,''FinalTm,''EnDt,'"+ DEVICEID +"' DeviceId,'"+ ENTRYUSER +"' EntryUser,''Upload,''modifyDate from ObjVarList v";
            SQL += " where not exists(select CountryCode from Observation where CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"' and TableId='"+ TableId +"' and DataId='"+ DataId +"' and VarName=v.VarName)";
            C.Save(SQL);

            SQL = " Select v.TableId, v.VarName, v.Description, v.ObjSeq1, v.ObjSeq2, (case when o.Observ is null then '' else o.Observ end) Status,";
            SQL += " VarData,";
            SQL += " ControlType,";
            SQL += " VarOption,";
            SQL += " Color";
            SQL += " from ObjVarList v";
            SQL += " left outer join Observation o on v.TableId=o.TableId and v.VarName=o.VarName";
            SQL += " and o.CountryCode='" + COUNTRYCODE + "' and o.FaciCode='" + FACICODE + "'";
            SQL += " and o.TableId='" + TableId + "'";
            SQL += " and o.DataID='" + DataId + "'";
            SQL += " Where v.TableId='" + TableId + "'";
            SQL += " order by ObjSeq1";
        }else if(WomanChild.equals("c")) {
            SQL = "Insert into Observation(CountryCode,FaciCode,TableId,DataID,VarName,SL,Observ,VarData,ObservDT,FirstTm,FinalTm,EnDt,DeviceId,EntryUser,Upload,modifyDate)";
            SQL += " Select '"+ COUNTRYCODE +"' CountryCode,'"+ FACICODE +"' FaciCode, '"+ TableId +"' TableId,'"+ DataId +"' DataID, VarName,'"+ ChildSL +"','N'Observ,'' VarData,''ObservDT,''FirstTm,''FinalTm,''EnDt,'"+ DEVICEID +"' DeviceId,'"+ ENTRYUSER +"' EntryUser,''Upload,''modifyDate from ObjVarList v";
            SQL += " where not exists(select CountryCode from Observation where CountryCode='"+ COUNTRYCODE +"' and FaciCode='"+ FACICODE +"' and TableId='"+ TableId +"' and DataId='"+ DataId +"' and VarName=v.VarName and SL=v.SL)";
            C.Save(SQL);

            SQL = " Select v.TableId, v.VarName, v.Description, v.ObjSeq1, v.ObjSeq2, (case when o.Observ is null then '' else o.Observ end) Status,";
            SQL += " VarData,";
            SQL += " ControlType,";
            SQL += " VarOption,";
            SQL += " Color";
            SQL += " from ObjVarList v";
            SQL += " left outer join Observation o on v.TableId=o.TableId and v.VarName=o.VarName";
            SQL += " and o.CountryCode='" + COUNTRYCODE + "' and o.FaciCode='" + FACICODE + "'";
            SQL += " and o.TableId='" + TableId + "'";
            SQL += " and o.DataID='" + DataId + "' and o.SL='"+ ChildSL +"'";
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
            p.setDescription(item.getDescription());
            p.setObjSeq1(item.getObjSeq1());
            p.setObjSeq2(item.getObjSeq2());
            p.setStatus(item.getStatus());

            p.setVarData(item.getVarData()==null?"":item.getVarData());
            p.setControlType(item.getControlType());
            p.setVarOption(item.getVarOption());
            p.setColor(item.getColor());
            count +=1;
            variableList.add(p);
        }

        //lblCountVariable.setText("(Total: "+ String.valueOf(count) +")");
        //mAdapter.notifyDataSetChanged();
    }

    public class VariableListAdapter extends RecyclerView.Adapter<VariableListAdapter.MyViewHolder> {
        private List<VariableList_DataModel> variableList;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView objDescription, dataDescription;
            public LinearLayout objCheckList;
            public Spinner spnDataList;
            public EditText txtData;
            public ImageButton btnData;

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
            holder.objDescription.setText(varlist.getDescription());

            /*manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    //Labour and Delivery
                    if(TABLEID.equals("1")) {
                        if (position == 1) {
                            return 2;
                        } else if (position == 2) {
                            return 3;
                        } else if (position == 9) {
                            return 3;
                        } else if (position == 32) {
                            return 3;
                        }else {
                            return 1;
                        }
                    }
                    //Birth Asphyxia and Resuscitation
                    else if(TABLEID.equals("2")) {
                        if (position == 1) {
                            return 2;
                        } else if (position == 3) {
                            return 2;
                        } else if (position == 5) {
                            return 2;
                        } else if (position == 7) {
                            return 1;
                        } else if (position == 9) {
                            return 3;
                        } else if (position == 18) {
                            return 1;
                        }else {
                            return 1;
                        }
                    }
                    //PPH
                    else if(TABLEID.equals("3")) {
                        if (position == 10) {
                            return 2;
                        }else {
                            return 1;
                        }
                    }else {
                        return 1;
                    }

                    //return 2; //(3 - position % 3);
                }
            });*/
            recyclerView.setLayoutManager(manager);



            holder.objDescription.setVisibility(View.GONE);
            holder.dataDescription.setVisibility(View.GONE);
            holder.spnDataList.setVisibility(View.GONE);
            holder.txtData.setVisibility(View.GONE);
            holder.btnData.setVisibility(View.GONE);

            //Command Button
            if(varlist.getControlType().equals("1")){
                holder.objDescription.setVisibility(View.VISIBLE);
                holder.dataDescription.setVisibility(View.GONE);
                holder.spnDataList.setVisibility(View.GONE);

                if(varlist.getStatus().equals("Y")){
                    holder.objCheckList.setBackgroundColor(Color.parseColor("#69CB3F"));
                }else if(varlist.getStatus().equals("C")){
                    holder.objCheckList.setBackgroundColor(Color.parseColor("#FAAC58"));
                }else if(varlist.getStatus().equals("N")){
                    holder.objCheckList.setBackgroundColor(Color.parseColor("#FFFFFF"));
                }else{
                    holder.objCheckList.setBackgroundColor(Color.parseColor("#FFFFFF"));
                }

                holder.objCheckList.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {

                        Observation_DataModel obj = new Observation_DataModel();
                        obj.setCountryCode(COUNTRYCODE);
                        obj.setFaciCode(FACICODE);
                        obj.setTableId(TABLEID);
                        obj.setDataID(DATAID);
                        obj.setVarName(varlist.getVarName());

                        if(varlist.getStatus().equals("Y")) {
                            obj.setObserv("C");
                            varlist.setStatus("C");
                            mAdapter.variableList.set(position,varlist);
                        }
                        else if(varlist.getStatus().equals("C")) {
                            obj.setObserv("N");
                            varlist.setStatus("N");
                            mAdapter.variableList.set(position,varlist);
                        }
                        else if(varlist.getStatus().equals("N")) {
                            obj.setObserv("Y");
                            varlist.setStatus("Y");
                            mAdapter.variableList.set(position,varlist);
                        }
                        else {
                            obj.setObserv("N");
                            varlist.setStatus("N");
                            mAdapter.variableList.set(position,varlist);
                        }

                        obj.setVarData("");
                        obj.setObservDT(Global.DateNowYMD());
                        obj.setFirstTm(g.CurrentTime24());
                        obj.setFinalTm(g.CurrentTime24());
                        obj.setEnDt(Global.DateTimeNowYMDHMS());
                        obj.setDeviceID(DEVICEID);
                        obj.setEntryUser(ENTRYUSER);
                        obj.SaveUpdateData(Observation_Time_Orig.this);

                        //recyclerView.invalidate();
                        //mAdapter.notifyItemChanged(position);
                        mAdapter.notifyDataSetChanged();
                    }
                });
            }
            //TextBox
            else if(varlist.getControlType().equals("2")){
                holder.objDescription.setVisibility(View.VISIBLE);
                holder.txtData.setVisibility(View.VISIBLE);
                holder.btnData.setVisibility(View.VISIBLE);
                holder.dataDescription.setVisibility(View.GONE);
                holder.spnDataList.setVisibility(View.GONE);
                holder.txtData.setText(varlist.getVarData());

                if(varlist.getStatus().equals("Y")){
                    holder.objCheckList.setBackgroundColor(Color.parseColor("#69CB3F"));
                }else if(varlist.getStatus().equals("C")){
                    holder.objCheckList.setBackgroundColor(Color.parseColor("#FAAC58"));
                }else if(varlist.getStatus().equals("N")){
                    holder.objCheckList.setBackgroundColor(Color.parseColor("#FFFFFF"));
                }else{
                    holder.objCheckList.setBackgroundColor(Color.parseColor("#FFFFFF"));
                }

                holder.btnData.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {

                        if(holder.txtData.getText().length() == 0) return;

                        Observation_DataModel obj = new Observation_DataModel();
                        obj.setCountryCode(COUNTRYCODE);
                        obj.setFaciCode(FACICODE);
                        obj.setTableId(TABLEID);
                        obj.setDataID(DATAID);
                        obj.setVarName(varlist.getVarName());

                        if(varlist.getStatus().equals("Y")) {
                            obj.setObserv("C");
                            varlist.setStatus("C");
                            mAdapter.variableList.set(position,varlist);
                        }
                        else if(varlist.getStatus().equals("C")) {
                            obj.setObserv("N");
                            varlist.setStatus("N");
                            mAdapter.variableList.set(position,varlist);
                        }
                        else if(varlist.getStatus().equals("N")) {
                            obj.setObserv("Y");
                            varlist.setStatus("Y");
                            mAdapter.variableList.set(position,varlist);
                        }
                        else {
                            obj.setObserv("N");
                            varlist.setStatus("N");
                            mAdapter.variableList.set(position,varlist);
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
                        obj.SaveUpdateData(Observation_Time_Orig.this);

                        //recyclerView.invalidate();
                        //mAdapter.notifyItemChanged(position);
                        holder.txtData.requestFocus();
                        mAdapter.notifyDataSetChanged();
                    }
                });

                /*holder.txtData.addTextChangedListener(new TextWatcher() {
                    public void afterTextChanged(Editable s) {
                        if(holder.txtData.getText().length() != 4) return;

                        Observation_DataModel obj = new Observation_DataModel();
                        obj.setCountryCode(COUNTRYCODE);
                        obj.setFaciCode(FACICODE);
                        obj.setTableId(TABLEID);
                        obj.setDataID(DATAID);
                        obj.setVarName(varlist.getVarName());

                        if(varlist.getStatus().equals("Y")) {
                            obj.setObserv("C");
                            varlist.setStatus("C");
                            mAdapter.variableList.set(position,varlist);
                        }
                        else if(varlist.getStatus().equals("C")) {
                            obj.setObserv("N");
                            varlist.setStatus("N");
                            mAdapter.variableList.set(position,varlist);
                        }
                        else if(varlist.getStatus().equals("N")) {
                            obj.setObserv("Y");
                            varlist.setStatus("Y");
                            mAdapter.variableList.set(position,varlist);
                        }
                        else {
                            obj.setObserv("N");
                            varlist.setStatus("N");
                            mAdapter.variableList.set(position,varlist);
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

                    public void beforeTextChanged(CharSequence s, int start,int count, int after) {}

                    public void onTextChanged(CharSequence s, int start,int before, int count) {}
                });*/

            }
            //Dropdown List
            else if(varlist.getControlType().equals("3")){
                int pos = 0;

                holder.objDescription.setVisibility(View.GONE);
                holder.dataDescription.setText(varlist.getDescription());
                holder.dataDescription.setVisibility(View.VISIBLE);
                holder.spnDataList.setVisibility(View.VISIBLE);

                if(varlist.getStatus().equals("Y") & varlist.getVarData().length()!=0){
                    holder.objCheckList.setBackgroundColor(Color.parseColor("#69CB3F"));
                }else if(varlist.getStatus().equals("C") & varlist.getVarData().length()!=0){
                    holder.objCheckList.setBackgroundColor(Color.parseColor("#FAAC58"));
                }else if(varlist.getStatus().equals("N") & varlist.getVarData().length()!=0){
                    holder.objCheckList.setBackgroundColor(Color.parseColor("#FFFFFF"));
                }else{
                    holder.objCheckList.setBackgroundColor(Color.parseColor("#FFFFFF"));
                }

                String[] Opn = varlist.getVarOption().split(",");
                List<String> listSpinnerItem = new ArrayList<String>();
                listSpinnerItem.add("");
                for(int i=0;i<Opn.length;i++){
                    listSpinnerItem.add(Opn[i].toString().trim());
                }
                ArrayAdapter<String> adptrMotEthnicity= new ArrayAdapter<String>(Observation_Time_Orig.this, android.R.layout.simple_spinner_item, listSpinnerItem);

                holder.spnDataList.setAdapter(adptrMotEthnicity);

                if(varlist.getVarData().length()>0) {
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
                        if(spinnerTouched==true) {
                            Observation_DataModel obj = new Observation_DataModel();
                            obj.setCountryCode(COUNTRYCODE);
                            obj.setFaciCode(FACICODE);
                            obj.setTableId(TABLEID);
                            obj.setDataID(DATAID);
                            obj.setVarName(varlist.getVarName());

                            obj.setVarData(holder.spnDataList.getSelectedItemPosition() > 0 ? holder.spnDataList.getSelectedItem().toString() : "");
                            obj.setObserv("Y");
                            varlist.setStatus("Y");
                            varlist.setVarData(holder.spnDataList.getSelectedItemPosition() > 0 ? holder.spnDataList.getSelectedItem().toString() : "");

                            obj.setObservDT(Global.DateNowYMD());
                            obj.setFirstTm(g.CurrentTime24());
                            obj.setFinalTm(g.CurrentTime24());
                            obj.setEnDt(Global.DateTimeNowYMDHMS());
                            obj.setDeviceID(DEVICEID);
                            obj.setEntryUser(ENTRYUSER);
                            obj.SaveUpdateData(Observation_Time_Orig.this);

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





            /*holder.objCheckList.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    Observation_DataModel obj = new Observation_DataModel();
                    obj.setCountryCode(COUNTRYCODE);
                    obj.setFaciCode(FACICODE);
                    obj.setTableId(TABLEID);
                    obj.setDataID(DATAID);
                    obj.setVarName(varlist.getVarName());

                    if(varlist.getStatus().equals("Y")) {
                        obj.setObserv("C");
                        varlist.setStatus("C");
                        mAdapter.variableList.set(position,varlist);
                    }
                    else if(varlist.getStatus().equals("C")) {
                        obj.setObserv("N");
                        varlist.setStatus("N");
                        mAdapter.variableList.set(position,varlist);
                    }
                    else if(varlist.getStatus().equals("N")) {
                        obj.setObserv("Y");
                        varlist.setStatus("Y");
                        mAdapter.variableList.set(position,varlist);
                    }
                    else {
                        obj.setObserv("N");
                        varlist.setStatus("N");
                        mAdapter.variableList.set(position,varlist);
                    }

                    obj.setVarData("");
                    obj.setObservDT(Global.DateNowYMD());
                    obj.setFirstTm(g.CurrentTime24());
                    obj.setFinalTm(g.CurrentTime24());
                    obj.setEnDt(Global.DateTimeNowYMDHMS());
                    obj.setDeviceID(DEVICEID);
                    obj.setEntryUser(ENTRYUSER);
                    obj.SaveUpdateData(Observation_Time.this);

                    //recyclerView.invalidate();
                    //mAdapter.notifyItemChanged(position);
                    mAdapter.notifyDataSetChanged();
                }
            });*/

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

        private String _Color = "";
        public String getColor(){
            return _Color;
        }
        public void setColor(String newValue){
            _Color = newValue;
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

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
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
