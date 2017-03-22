package org.icddrb.enap;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Common.Connection;
import Common.Global;
import Common.ProjectSetting;
import Utility.MySharedPreferences;

/**
 * Created by thossain on 06/03/2017.
 */

public class PatientList extends AppCompatActivity {
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

    //private List<PatientList.Movie> movieList = new ArrayList<>();
    private List<Patient> patientList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PatientList.MoviesAdapter mAdapter;
    LinearLayout secDateSearch;
    EditText dtpFDate;
    EditText dtpTDate;

    static String DEVICEID  = "";
    static String ENTRYUSER = "";
    static String COUNTRYCODE = "";
    static String FACICODE = "";
    static String LOCATIONID = "";
    MySharedPreferences sp;
    TextView lblCountPatient;
    LinearLayout secStatusSearch;
    Spinner spnStatusSearch;
    EditText txtSearch;
    Bundle IDbundle;
    static String LOCATION = "";
    static String ROLE     = "";

    LinearLayout secRegisType;
    LinearLayout secTitle;
    TextView lblTitle;
    Global g;

    //-------------------------
    static String JOBTYPE     = "";
    static String JOBLOCATION = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_list);
        g = Global.getInstance();

        DEVICEID    = sp.getValue(this, "deviceid");
        ENTRYUSER   = sp.getValue(this, "userid");
        COUNTRYCODE = sp.getValue(this, "countrycode");
        FACICODE    = sp.getValue(this, "facicode");

        JOBTYPE     = sp.getValue(this, "jobtype");
        JOBLOCATION = sp.getValue(this, "jobloc");

        IDbundle = getIntent().getExtras();
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

        secRegisType = (LinearLayout)findViewById(R.id.secRegisType);

        secTitle = (LinearLayout)findViewById(R.id.secTitle);
        lblTitle = (TextView)findViewById(R.id.lblTitle);

        lblCountPatient = (TextView)findViewById(R.id.lblCountPatient);
        txtSearch = (EditText)findViewById(R.id.txtSearch);
        secDateSearch = (LinearLayout)findViewById(R.id.secDateSearch) ;
        secStatusSearch=(LinearLayout)findViewById(R.id.secStatusSearch) ;
        spnStatusSearch=(Spinner)findViewById(R.id.spnStatusSearch) ;



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new MoviesAdapter(patientList);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new PatientList.DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        /*
        recyclerView.addOnItemTouchListener(new PatientList.RecyclerTouchListener(getApplicationContext(), recyclerView, new PatientList.RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Patient patient = patientList.get(position);
                Toast.makeText(getApplicationContext(), patient.getpatName() + " is selected!", Toast.LENGTH_SHORT).show();

                Bundle IDbundle = new Bundle();
                IDbundle.putString("locationid", patient.getLocation());
                IDbundle.putString("dataid", patient.getDataID());
                Intent intent = new Intent(getApplicationContext(), Registration.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtras(IDbundle);
                getApplicationContext().startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));*/

        ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
        cmdBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder adb = new AlertDialog.Builder(PatientList.this);
                adb.setTitle("Close");
                adb.setMessage("Do you want to close this form[Yes/No]?");
                adb.setNegativeButton("No", null);
                adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }});
                adb.show();
            }});

        Button cmdLD = (Button) findViewById(R.id.cmdLD);
        cmdLD.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Bundle IDbundle = new Bundle();
                IDbundle.putString("locationid", ProjectSetting.LABOR_AND_DELIVERY_ID);
                IDbundle.putString("dataid", "");
                Intent intent = new Intent(getApplicationContext(), Registration.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtras(IDbundle);
                getApplicationContext().startActivity(intent);
            }
        });

        Button cmdKMC = (Button) findViewById(R.id.cmdKMC);
        cmdKMC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Bundle IDbundle = new Bundle();
                IDbundle.putString("locationid", ProjectSetting.KMC_ID);
                IDbundle.putString("dataid", "");
                Intent intent = new Intent(getApplicationContext(), Registration.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtras(IDbundle);
                getApplicationContext().startActivity(intent);
            }
        });

        Button cmdSepsis = (Button) findViewById(R.id.cmdSepsis);
        cmdSepsis.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Bundle IDbundle = new Bundle();
                IDbundle.putString("locationid", ProjectSetting.SEPSIS_ID);
                IDbundle.putString("dataid", "");
                Intent intent = new Intent(getApplicationContext(), Registration.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtras(IDbundle);
                getApplicationContext().startActivity(intent);
            }
        });


        Button btnSearch = (Button) findViewById(R.id.btnSearch);
        final ImageButton dateSearch = (ImageButton) findViewById(R.id.dateSearch);
        secDateSearch = (LinearLayout) findViewById(R.id.secDateSearch);
        dateSearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (secDateSearch.isShown()) {
                    secDateSearch.setVisibility(View.GONE);
                    dateSearch.setImageResource(R.drawable.plus);

                    secStatusSearch.setVisibility(View.GONE);
                    spnStatusSearch.setSelection(0);
                    //DataSearch(LOCATIONTYPE);
                } else {
                    secDateSearch.setVisibility(View.VISIBLE);
                    dateSearch.setImageResource(R.drawable.minus);
                    dtpFDate.setText(Global.DateNowDMY());
                    dtpTDate.setText(Global.DateNowDMY());

                    secStatusSearch.setVisibility(View.VISIBLE);
                    //DataSearch(LOCATIONTYPE);
                }
            }
        });

        dtpFDate = (EditText) findViewById(R.id.dtpFDate);
        dtpTDate = (EditText) findViewById(R.id.dtpTDate);


        dtpFDate.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_RIGHT  = 2;
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    if(event.getRawX() >= (dtpFDate.getRight() - dtpFDate.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        VariableID = "dtpFDate"; showDialog(DATE_DIALOG);
                        return true;
                    }
                }
                return false;
            }
        });


        dtpTDate.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_RIGHT  = 2;
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    if(event.getRawX() >= (dtpTDate.getRight() - dtpTDate.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        VariableID = "dtpTDate"; showDialog(DATE_DIALOG);
                        return true;
                    }
                }
                return false;
            }
        });


        btnSearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                preparePatientList();
            }
        });
        secDateSearch.setVisibility(View.GONE);

        //DataSearch(LOCATIONTYPE);

        final ProgressDialog progDailog = ProgressDialog.show(PatientList.this, "", "Please Wait . . .", true);

        new Thread() {
            public void run() {
                try {
                    //lstData = (ListView) findViewById(R.id.lstData);
                    //setListViewAdapter();
                    //getDataFromUrl(url_page1);
                    //DataSearch(LOCATIONTYPE);
                        /*lstData.setOnScrollListener(onScrollListener());
                        lstData.setOnTouchListener(new View.OnTouchListener() {
                            @Override
                            public boolean onTouch(View v, MotionEvent event) {
                                Global.hideSoftKeyboard(Screening_list1.this);
                                return false;
                            }
                        });

                        lstData.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long arg3) {
                                view.setSelected(true);

                            }
                        });*/
                } catch (Exception e) {

                }
                progDailog.dismiss();
            }
        }.start();


        List<String> listStatusSearch = new ArrayList<String>();
        listStatusSearch.add("");
        listStatusSearch.add("1-All Patient");
        listStatusSearch.add("2-Completed");
        listStatusSearch.add("3-Incomplete");

        if(LOCATION.equals(ProjectSetting.REGISTRATION_ID)){
            secRegisType.setVisibility(View.VISIBLE);
            secTitle.setVisibility(View.GONE);

            listStatusSearch.add("4-Labour and Delivery Patient");
            listStatusSearch.add("5-KMC Patient");
            listStatusSearch.add("6-Infection Patient");
        }else if(LOCATION.equals(ProjectSetting.LABOR_AND_DELIVERY_ID)){
            secRegisType.setVisibility(View.GONE);
            secTitle.setVisibility(View.VISIBLE);

            listStatusSearch.add("4-Labour and Delivery Patient");
            lblTitle.setText(ProjectSetting.LABOR_AND_DELIVERY_NAME);
        }else if(LOCATION.equals(ProjectSetting.KMC_ID)){
            secRegisType.setVisibility(View.GONE);
            secTitle.setVisibility(View.VISIBLE);
            lblTitle.setText(ProjectSetting.KMC_NAME);

            listStatusSearch.add("5-KMC Patient");
        }else if(LOCATION.equals(ProjectSetting.SEPSIS_ID)){
            secRegisType.setVisibility(View.GONE);
            secTitle.setVisibility(View.VISIBLE);
            lblTitle.setText(ProjectSetting.SEPSIS_NAME);

            listStatusSearch.add("6-Infection Patient");
        }else if(LOCATION.equals(ProjectSetting.ACS_ID)){
            secRegisType.setVisibility(View.GONE);
            secTitle.setVisibility(View.VISIBLE);
            lblTitle.setText(ProjectSetting.ACS_NAME);
        }

        ArrayAdapter<String> adptrMotReligion= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listStatusSearch);
        spnStatusSearch.setAdapter(adptrMotReligion);

        secDateSearch.setVisibility(View.GONE);
        secStatusSearch.setVisibility(View.GONE);

        preparePatientList();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_CANCELED) {
            //Write your code if there's no result
        } else {
            preparePatientList();
        }
    }

    private void preparePatientList() {
        /*for(int i=0;i<=100000;i++){
            PatientList.Movie movie = new PatientList.Movie(String.valueOf(i) + "- Mad Max: Fury Road", "Action & Adventure", "2015");
            movieList.add(movie);
        }*/

        Registration_DataModel d = new Registration_DataModel();
        String param = "";
        String SQL = "Select  r.CountryCode,r.FaciCode,r.RegisType,r.DataID,r.RegDate,r.RegTime,r.HospID,r.Consent,r.StudyID,r.MotRegis,r.MotStudyID,r.MotStudyIDReType,r.MotHospID,r.MotName,r.MotDOB,r.MotDOBDK,r.MotAge,r.MotEthnicity,r.MotReligion,r.Address1,r.Address2,r.Address3,r.Address4,r.AddressDetail,r.MotContact,r.AltContact,r.NameNewBorn,r.DOBNewborn,r.AgeNewborn,r.AgeNewbornDMY,r.Sex,r.FatherName,r.CompleteAdd,(case when o.LD is null or o.LD=0 then '2' else '1' end)Observe";
        SQL += " from Registration r";
        SQL += " left outer join (Select CountryCode,FaciCode,DataID,sum(case when TableId='1' then 1 else 0 end)LD from Observation group by CountryCode,FaciCode,DataID)o on r.CountryCode=o.CountryCode and r.FaciCode=o.FaciCode and r.DataID=o.DataID";
        SQL += " Where r.CountryCode='"+ COUNTRYCODE +"' and r.FaciCode='"+ FACICODE +"' and r.Consent='1'";

        if(secStatusSearch.isShown() & spnStatusSearch.getSelectedItemPosition()>0) {
            String[] p = spnStatusSearch.getSelectedItem().toString().split("-");
            param = p[0];
            if(JOBTYPE.equals(ProjectSetting.JT_REGISTRATION)){
                if (param.equals("4")) {
                    SQL += " and r.RegisType = '2'";
                } else if (param.equals("5")) {
                    SQL += " and r.RegisType = '3'";
                } else if (param.equals("6")) {
                    SQL += " and r.RegisType = '4'";
                }
            }else {
                if(LOCATION.equals(ProjectSetting.LABOR_AND_DELIVERY_ID) & param.equals("1")){
                    SQL += " and r.RegisType = '2'";
                }else if(LOCATION.equals(ProjectSetting.KMC_ID) & param.equals("1")){
                    SQL += " and r.RegisType = '3'";
                }else if(LOCATION.equals(ProjectSetting.SEPSIS_ID) & param.equals("1")){
                    SQL += " and r.RegisType = '4'";
                }else if (param.equals("4")) {
                    SQL += " and r.RegisType = '2'";
                }else if (param.equals("5")) {
                    SQL += " and r.RegisType = '3'";
                }else if (param.equals("6")) {
                    SQL += " and r.RegisType = '4'";
                }
            }
        }else{
            if(!LOCATION.equals(ProjectSetting.REGISTRATION_ID))
                SQL += " and r.RegisType like('"+ LOCATION +"')";
        }

        if(txtSearch.getText().toString().length()>0) {
            SQL += " and (";
            SQL += " r.StudyID like('%"+ txtSearch.getText().toString() +"%')";
            SQL += " or r.MotName like('%"+ txtSearch.getText().toString() +"%')";
            SQL += " or r.NameNewBorn like('%"+ txtSearch.getText().toString() +"%')";
            SQL += " or r.MotContact like('%"+ txtSearch.getText().toString() +"%')";
            SQL += " or r.AltContact like('%"+ txtSearch.getText().toString() +"%')";
            SQL += " or r.HospID like('%"+ txtSearch.getText().toString() +"%')";
            SQL += " )";
        }

        if(secDateSearch.isShown()){
            SQL += " and (date(r.RegDate) between '"+ Global.DateConvertYMD(dtpFDate.getText().toString()) +"' and '"+ Global.DateConvertYMD(dtpTDate.getText().toString()) +"')";
        }


        SQL += " Order by r.EnDt desc,r.RegisType asc";

        List<Registration_DataModel> data = d.SelectPatientList(this, SQL);

        patientList.clear();
        int count = 0;
        for(Registration_DataModel item : data){
            //Movie movie = new Movie(String.valueOf(count)+": "+ item.getpatName(), item.getPatAge(), item.getDataID());
            //movieList.add(movie);

            Patient p = new Patient();
            p.setLocation(item.getRegisType());
            p.setDataID(item.getDataID());
            p.setHospitalID(item.getHospID());
            p.setStudyID(item.getStudyID());
            p.setpatName(item.getRegisType().equals(ProjectSetting.LABOR_AND_DELIVERY_ID)?item.getMotName():item.getNameNewBorn());

            p.setPatAge("Age: "+ (item.getRegisType().equals(ProjectSetting.LABOR_AND_DELIVERY_ID)? item.getMotAge()+ " years" : item.getAgeNewborn()+" "+ (item.getAgeNewbornDMY().equals("1")?"days":(item.getAgeNewbornDMY().equals("2")?"month":"years"))));

            p.setPatAgeDMY(item.getAgeNewbornDMY());
            p.setPatSex(item.getRegisType().equals(ProjectSetting.LABOR_AND_DELIVERY_ID)?"": item.getSex().equals("1")?"Male":(item.getSex().equals("1")?"Female":"Ambiguous"));
            p.setPatDOB(item.getRegisType().equals(ProjectSetting.LABOR_AND_DELIVERY_ID)?item.getMotDOB():item.getDOBNewborn());
            p.setRegDate(item.getRegDate());
            p.setRegTime(item.getRegTime());
            p.setMainAddress(item.getCompleteAdd());
            //p.setMainAddress(item.getAddress1());
            p.setPhone1(item.getMotContact());
            p.setPhone2(item.getAltContact());
            p.setObserve(item.getObserve());
            p.setSerial(String.valueOf(count));

            count +=1;

            patientList.add(p);
        }

        lblCountPatient.setText("(Total: "+ String.valueOf(count) +")");
        mAdapter.notifyDataSetChanged();
    }

    public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

        private List<Patient> patientList;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            //public TextView title, year, genre;
            public TextView studyId,hospitalId,patientName,patientAge,patientAddress,location;
            public Button cmdObj,cmdRS,cmdDE;
            public RelativeLayout secRow;
            public ImageView imgPatient;

            public MyViewHolder(View view) {
                super(view);
                secRow = (RelativeLayout) view.findViewById(R.id.secRow);
                studyId = (TextView) view.findViewById(R.id.txtStudyID);
                hospitalId = (TextView) view.findViewById(R.id.txtHospID);
                patientName = (TextView) view.findViewById(R.id.txtName);
                patientAge = (TextView) view.findViewById(R.id.txtAge);
                patientAddress = (TextView) view.findViewById(R.id.txtAddress);
                location = (TextView) view.findViewById(R.id.lblType);
                imgPatient = (ImageView) view.findViewById(R.id.imgPatient);
                cmdObj = (Button)view.findViewById(R.id.cmdObj);
                cmdRS = (Button)view.findViewById(R.id.cmdRS);
                cmdDE = (Button)view.findViewById(R.id.cmdDE);

                /*title = (TextView) view.findViewById(R.id.title);
                genre = (TextView) view.findViewById(R.id.genre);
                year = (TextView) view.findViewById(R.id.year);*/
            }
        }


        public MoviesAdapter(List<Patient> patientlist) {
            this.patientList = patientlist;
        }

        @Override
        public PatientList.MoviesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.patient_list_row1, parent, false);

            return new PatientList.MoviesAdapter.MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(PatientList.MoviesAdapter.MyViewHolder holder, int position) {
            final Patient patient = patientList.get(position);
            holder.studyId.setText(patient.getStudyID());
            holder.hospitalId.setText(patient.getHospitalID());

            holder.patientName.setText(patient.getpatName());
            holder.patientAge.setText(patient.getPatAge() + (patient.getLocation().equals(ProjectSetting.LABOR_AND_DELIVERY_ID)?"": "   "+ patient.getPatSex()));
            holder.patientAddress.setText(patient.getMainAddress());

            if(patient.getLocation().equals(ProjectSetting.LABOR_AND_DELIVERY_ID)) {
                holder.location.setText(ProjectSetting.LABOR_AND_DELIVERY_SHORT_NAME);
                //holder.imgPatient.setBackgroundResource(R.drawable.ic_action_person);
            }
            else if(patient.getLocation().equals(ProjectSetting.KMC_ID)) {
                holder.location.setText(ProjectSetting.KMC_SHORT_NAME);
                //holder.imgPatient.setBackgroundResource(R.drawable.ic_action_group);
            }
            else if(patient.getLocation().equals(ProjectSetting.SEPSIS_ID)) {
                holder.location.setText(ProjectSetting.SEPSIS_SHORT_NAME);
                //holder.imgPatient.setBackgroundResource(R.drawable.ic_action_group);
            }

            if(Integer.valueOf(patient.getSerial())%2==0){
                holder.secRow.setBackgroundColor(Color.parseColor("#FFFFFF"));
            }else
            {
                holder.secRow.setBackgroundColor(Color.parseColor("#F3F3F3"));
            }

            String[] jobloc = JOBLOCATION.split(",");
            holder.cmdObj.setEnabled(false);
            holder.cmdRS.setEnabled(false);
            holder.cmdDE.setEnabled(false);

            if(patient.getObserve().equals("1")){
                holder.cmdObj.setBackgroundResource(R.drawable.button_style_green);
            }else{
                holder.cmdObj.setBackgroundResource(R.drawable.button_style_red);
            }

            for(int i=0; i<jobloc.length;i++){

                //Location: L & D, KMC, PSBI
                //Job Type : Mutually exclusive
                if(patient.getLocation().equals(jobloc[i]) & JOBTYPE.equals(ProjectSetting.JT_REGISTRATION)){

                }
                if(patient.getLocation().equals(jobloc[i]) & JOBTYPE.equals(ProjectSetting.JT_OBSERVATION)){
                    holder.cmdObj.setEnabled(true);
                }
                if(patient.getLocation().equals(jobloc[i]) & JOBTYPE.equals(ProjectSetting.JT_EXIT_INTERVIEW)){
                    holder.cmdRS.setEnabled(true);
                    holder.cmdDE.setEnabled(true);
                }
                if(patient.getLocation().equals(jobloc[i]) & JOBTYPE.equals(ProjectSetting.JT_DATA_EXTRACTION)){
                    holder.cmdRS.setEnabled(true);
                    holder.cmdDE.setEnabled(true);
                }
            }

            holder.cmdObj.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Bundle IDbundle = new Bundle();
                    String TABLEID = "";
                    if(patient.getLocation().equals(ProjectSetting.LABOR_AND_DELIVERY_ID)) TABLEID = "1";
                    else if(patient.getLocation().equals(ProjectSetting.KMC_ID)) TABLEID = "6";

                    IDbundle.putString("location", patient.getLocation());
                    IDbundle.putString("dataid", patient.getDataID());
                    IDbundle.putString("tableid", TABLEID);
                    IDbundle.putString("studyid", patient.getStudyID());
                    IDbundle.putString("hospitalid", patient.getHospitalID());
                    IDbundle.putString("name",patient.getpatName());
                    IDbundle.putString("address",patient.getMainAddress());
                    IDbundle.putString("age", patient.getPatAge() + (patient.getLocation().equals(ProjectSetting.LABOR_AND_DELIVERY_ID)?"": "   "+ patient.getPatSex()));

                    IDbundle.putString("ob", patient.getObserve());
                    IDbundle.putString("mrs", patient.getObserve());
                    IDbundle.putString("de", patient.getObserve());
                    Intent intent = new Intent(getApplicationContext(), Observation.class);
                    //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtras(IDbundle);
                    startActivity(intent);
                    //getApplicationContext().startActivity(intent);
                }
            });


            holder.secRow.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    //Write your code here
                    Bundle IDbundle = new Bundle();
                    IDbundle.putString("locationid", patient.getLocation());
                    IDbundle.putString("dataid", patient.getDataID());
                    Intent intent = new Intent(getApplicationContext(), Registration.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtras(IDbundle);
                    getApplicationContext().startActivity(intent);
                }
            });

        }

        @Override
        public int getItemCount() {
            return patientList.size();
        }
    }


    public class Movie {
        private String title, genre, year;

        public Movie() {
        }

        public Movie(String title, String genre, String year) {
            this.title = title;
            this.genre = genre;
            this.year = year;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String name) {
            this.title = name;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }
    }


    public class Patient {
        private String _Serial = "";
        public String getSerial(){
            return _Serial;
        }
        public void setSerial(String newValue){
            _Serial = newValue;
        }

        private String _Location = "";
        public String getLocation(){
            return _Location;
        }
        public void setLocation(String newValue){
            _Location = newValue;
        }
        private String _DataID = "";
        public String getDataID(){
            return _DataID;
        }
        public void setDataID(String newValue){
            _DataID = newValue;
        }
        private String _HospitalID = "";
        public String getHospitalID(){
            return _HospitalID;
        }
        public void setHospitalID(String newValue){
            _HospitalID = newValue;
        }

        private String _RegDate = "";
        public String getRegDate(){
            return _RegDate;
        }
        public void setRegDate(String newValue){
            _RegDate = newValue;
        }
        private String _RegTime = "";
        public String getRegTime(){
            return _RegTime;
        }
        public void setRegTime(String newValue){
            _RegTime = newValue;
        }
        private String _patName = "";
        public String getpatName(){
            return _patName;
        }
        public void setpatName(String newValue){
            _patName = newValue;
        }
        private String _PatAge = "";
        public String getPatAge(){
            return _PatAge;
        }
        public void setPatAge(String newValue){
            _PatAge = newValue;
        }
        private String _PatSex = "";
        public String getPatSex(){
            return _PatSex;
        }
        public void setPatSex(String newValue){
            _PatSex = newValue;
        }

        private String _PatAgeDMY = "";
        public String getPatAgeDMY(){
            return _PatAgeDMY;
        }
        public void setPatAgeDMY(String newValue){
            _PatAgeDMY = newValue;
        }
        private String _PatDOB = "";
        public String getPatDOB(){
            return _PatDOB;
        }
        public void setPatDOB(String newValue){
            _PatDOB = newValue;
        }
        private String _MainAddress = "";
        public String getMainAddress(){
            return _MainAddress;
        }
        public void setMainAddress(String newValue){
            _MainAddress = newValue;
        }
        private String _StudyID = "";
        public String getStudyID(){
            return _StudyID;
        }
        public void setStudyID(String newValue){
            _StudyID = newValue;
        }
        private String _Phone1 = "";
        public String getPhone1(){
            return _Phone1;
        }
        public void setPhone1(String newValue){
            _Phone1 = newValue;
        }
        private String _Phone2 = "";
        public String getPhone2(){
            return _Phone2;
        }
        public void setPhone2(String newValue){
            _Phone2 = newValue;
        }

        private String _Observe = "";
        public String getObserve(){
            return _Observe;
        }
        public void setObserve(String newValue){
            _Observe = newValue;
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
                drawVertical(c, parent);
            } else {
                drawHorizontal(c, parent);
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
        private PatientList.RecyclerTouchListener.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final PatientList.RecyclerTouchListener.ClickListener clickListener) {
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



    protected Dialog onCreateDialog(int id) {
        final Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);
        switch (id) {
            case DATE_DIALOG:
                return new DatePickerDialog(this, mDateSetListener,g.mYear,g.mMonth-1,g.mDay);

        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mYear = year; mMonth = monthOfYear+1; mDay = dayOfMonth;
            EditText dtpDate;


            dtpDate = (EditText)findViewById(R.id.dtpFDate);
            if (VariableID.equals("btnFDate"))
            {
                dtpDate = (EditText)findViewById(R.id.dtpFDate);
            }
            else if (VariableID.equals("btnTDate"))
            {
                dtpDate = (EditText)findViewById(R.id.dtpTDate);
            }
            dtpDate.setText(new StringBuilder()
                    .append(Global.Right("00"+mDay,2)).append("/")
                    .append(Global.Right("00"+mMonth,2)).append("/")
                    .append(mYear));
        }
    };

}
