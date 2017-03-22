package org.icddrb.enap;

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
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Common.Connection;
import Common.Global;
import Utility.MySharedPreferences;

public class MainActivity1 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Connection C;
    MySharedPreferences sp;
    private List<Menu_DataModel> variableList = new ArrayList<>();
    private RecyclerView recyclerView;
    private Menu_Adapter mAdapter;

    static String DEVICEID  = "";
    static String ENTRYUSER = "";
    static String COUNTRYCODE = "";
    static String FACICODE = "";
    static String LOCATIONID = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        C = new Connection(this);
        DEVICEID    = sp.getValue(this, "deviceid");
        ENTRYUSER   = sp.getValue(this, "userid");
        COUNTRYCODE = sp.getValue(this, "countrycode");
        FACICODE    = sp.getValue(this, "facilitycode");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);





        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new Menu_Adapter(variableList);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Menu_DataModel variable = variableList.get(position);
                //Toast.makeText(getApplicationContext(), variable.getDescription() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        GridLayoutManager manager = new GridLayoutManager(this, 3);
        //dynamically changing the total number of column
        /*manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return (3 - position % 3);
            }
        });*/
        recyclerView.setLayoutManager(manager);



        prepareVariableListData("1");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_DataSync) {
            // Handle the camera action
        } else if (id == R.id.nav_Exit) {

        }

        /*else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {
        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }








    private void prepareVariableListData(String TableId) {

        Observation_VarList_DataModel d = new Observation_VarList_DataModel();
        String param = "";
        /*String SQL = "";
        SQL  = " Select v.TableId, v.VarName, v.Description, v.ObjSeq1, v.ObjSeq2, (case when o.Observ is null then '' else o.Observ end) Status";
        SQL += " from ObjVarList v";
        SQL += " left outer join Observation o on v.TableId=o.TableId and v.VarName=o.VarName";
        SQL += " Where v.TableId='"+ TableId +"'";
        SQL += " order by ObjSeq1";

        List<Observation_VarList_DataModel> data = d.ObservationList(this, SQL);*/
        String[] menuList = new String[5];
        menuList[0]="Registration and Tracking";
        menuList[1]="Labour and Delivery";
        menuList[2]="KMC";
        menuList[3]="Maternal Recall Survey";
        menuList[4]="PSBI";
        variableList.clear();
        int count = 0;
        for(int i=0; i< menuList.length; i++){

            Menu_DataModel p = new Menu_DataModel();
            p.setMenuId(String.valueOf(i));
            p.setMenuName(menuList[i]);
            count +=1;
            variableList.add(p);
        }

        //lblCountVariable.setText("(Total: "+ String.valueOf(count) +")");
        //mAdapter.notifyDataSetChanged();
    }

    public class Menu_Adapter extends RecyclerView.Adapter<Menu_Adapter.MyViewHolder> {
        private List<Menu_DataModel> variableList;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public Button objDescription;
            public RelativeLayout objCheckList;

            public MyViewHolder(View view) {
                super(view);
                objDescription = (Button) view.findViewById(R.id.objDescription);
                objCheckList = (RelativeLayout) view.findViewById(R.id.objCheckList);
            }
        }


        public Menu_Adapter(List<Menu_DataModel> varList) {
            this.variableList = varList;
        }

        @Override
        public Menu_Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.menu_grid_item, parent, false);

            return new Menu_Adapter.MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final Menu_Adapter.MyViewHolder holder, final int position) {
            final Menu_DataModel varlist = variableList.get(position);
            holder.objDescription.setText(varlist.getMenuName());

            holder.objCheckList.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                }
            });

        }

        @Override
        public int getItemCount() {
            return variableList.size();
        }
    }


    public class Menu_DataModel {
        private String _MenuId = "";
        public String getMenuId(){
            return _MenuId;
        }
        public void setMenuId(String newValue){
            _MenuId = newValue;
        }

        private String _MenuName = "";
        public String getMenuName(){
            return _MenuName;
        }
        public void setMenuName(String newValue){
            _MenuName = newValue;
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
