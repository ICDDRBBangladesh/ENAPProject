package org.icddrb.enap;

import android.content.Context;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

import Common.Connection;

/**
 * Created by thossain on 11/03/2017.
 */

public class Observation_VarList_DataModel {

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
    private String _ControlType = "";
    public String getControlType(){
        return _ControlType;
    }
    private String _VarOption = "";
    public String getVarOption(){
        return _VarOption;
    }
    private String _Color = "";
    public String getColor(){
        return _Color;
    }

    public List<Observation_VarList_DataModel> ObservationList(Context context, String SQL)
    {
        Connection C = new Connection(context);
        List<Observation_VarList_DataModel> data = new ArrayList<Observation_VarList_DataModel>();
        Observation_VarList_DataModel d = new Observation_VarList_DataModel();
        Cursor cur = C.ReadData(SQL);

        cur.moveToFirst();
        while(!cur.isAfterLast())
        {
            d = new Observation_VarList_DataModel();
            d._TableId = cur.getString(cur.getColumnIndex("TableId"));
            d._VarName = cur.getString(cur.getColumnIndex("VarName"));
            d._Description = cur.getString(cur.getColumnIndex("Description"));
            d._ObjSeq1 = cur.getString(cur.getColumnIndex("ObjSeq1"));
            d._ObjSeq2 = cur.getString(cur.getColumnIndex("ObjSeq2"));
            d._Status = cur.getString(cur.getColumnIndex("Status"));
            d._VarData = cur.getString(cur.getColumnIndex("VarData"));
            d._ControlType = cur.getString(cur.getColumnIndex("ControlType"));
            d._VarOption = cur.getString(cur.getColumnIndex("VarOption"));
            d._Color = cur.getString(cur.getColumnIndex("Color"));

            data.add(d);

            cur.moveToNext();
        }
        cur.close();
        return data;
    }

}

