package org.icddrb.enap;

import android.content.Context;
import android.database.Cursor;
import Common.Connection;
import Common.Global;

import java.util.ArrayList;
import java.util.List;

public class Observation_DataModel{
    private String _CountryCode = "";
    public String getCountryCode(){
        return _CountryCode;
    }
    public void setCountryCode(String newValue){
        _CountryCode = newValue;
    }

    private String _FaciCode = "";
    public String getFaciCode(){
        return _FaciCode;
    }
    public void setFaciCode(String newValue){
        _FaciCode = newValue;
    }

    private String _TableId = "";
    public String getTableId(){
        return _TableId;
    }
    public void setTableId(String newValue){
        _TableId = newValue;
    }
    private String _DataID = "";
    public String getDataID(){
        return _DataID;
    }
    public void setDataID(String newValue){
        _DataID = newValue;
    }
    private String _VarName = "";
    public String getVarName(){
        return _VarName;
    }
    public void setVarName(String newValue){
        _VarName = newValue;
    }

    private String _VarData = "";
    public String getVarData(){
        return _VarData;
    }
    public void setVarData(String newValue){
        _VarData = newValue;
    }

    private String _Observ = "";
    public String getObserv(){
        return _Observ;
    }
    public void setObserv(String newValue){
        _Observ = newValue;
    }
    private String _ObservDT = "";
    public String getObservDT(){
        return _ObservDT;
    }
    public void setObservDT(String newValue){
        _ObservDT = newValue;
    }
    private String _FirstTm = "";
    public String getFirstTm(){
        return _FirstTm;
    }
    public void setFirstTm(String newValue){
        _FirstTm = newValue;
    }
    private String _FinalTm = "";
    public String getFinalTm(){
        return _FinalTm;
    }
    public void setFinalTm(String newValue){
        _FinalTm = newValue;
    }

    private String _DeviceID = "";
    public void setDeviceID(String newValue){
        _DeviceID = newValue;
    }
    private String _EntryUser = "";
    public void setEntryUser(String newValue){
        _EntryUser = newValue;
    }

    private String _EnDt = "";
    public void setEnDt(String newValue){
        _EnDt = newValue;
    }
    private String _Upload = "2";

    String TableName = "Observation";

    public String SaveUpdateData(Context context)
    {
        String response = "";
        C = new Connection(context);
        String SQL = "";
        try
        {
            if(C.Existence("Select * from "+ TableName +"  Where CountryCode='"+ _CountryCode +"' and FaciCode='"+ _FaciCode +"' and TableId='"+ _TableId +"' and DataID='"+ _DataID +"' and VarName='"+ _VarName +"' "))
                response = UpdateData(context);
            else
                response = SaveData(context);
        }
        catch(Exception  e)
        {
            response = e.getMessage();
        }
        return response;
    }
    Connection C;

    private String SaveData(Context context)
    {
        String response = "";
        C = new Connection(context);
        String SQL = "";
        try
        {
            SQL = "Insert into "+ TableName +" (CountryCode,FaciCode,TableId,DataID,VarName,Observ,ObservDT,FirstTm,FinalTm,DeviceID,EntryUser,EnDt,Upload,VarData)Values('"+ _CountryCode +"','"+ _FaciCode +"','"+ _TableId +"', '"+ _DataID +"', '"+ _VarName +"', '"+ _Observ +"', '"+ _ObservDT +"', '"+ _FirstTm +"', '"+ _FinalTm +"', '"+ _DeviceID +"', '"+ _EntryUser +"', '"+ _EnDt +"', '"+ _Upload +"','"+ _VarData +"')";
            C.Save(SQL);
            C.close();
        }
        catch(Exception  e)
        {
            response = e.getMessage();
        }
        return response;
    }

    private String UpdateData(Context context)
    {
        String response = "";
        C = new Connection(context);
        String SQL = "";
        try
        {
            SQL = "Update "+ TableName +" Set Upload='2',varData='"+ _VarData +"',modifyDate='"+ Global.DateTimeNowYMDHMS() +"',Observ = '"+ _Observ +"',ObservDT = '"+ _ObservDT +"',FirstTm=(case when length(FirstTm)=0 then '"+ _FirstTm +"' else FirstTm end),FinalTm = '"+ _FinalTm +"',EnDt=(case when length(EnDt)=0 then '"+ Global.DateTimeNowYMDHMS() +"' else EnDt end)  Where CountryCode='"+ _CountryCode +"' and FaciCode='"+ _FaciCode +"' and TableId='"+ _TableId +"' and DataID='"+ _DataID +"' and VarName='"+ _VarName +"'";
            C.Save(SQL);
            C.close();
        }
        catch(Exception  e)
        {
            response = e.getMessage();
        }
        return response;
    }


    public List<Observation_DataModel> SelectAll(Context context, String SQL)
    {
        Connection C = new Connection(context);
        List<Observation_DataModel> data = new ArrayList<Observation_DataModel>();
        Observation_DataModel d = new Observation_DataModel();
        Cursor cur = C.ReadData(SQL);

        cur.moveToFirst();
        while(!cur.isAfterLast())
        {
            d = new Observation_DataModel();
            d._TableId = cur.getString(cur.getColumnIndex("TableId"));
            d._DataID = cur.getString(cur.getColumnIndex("DataID"));
            d._VarName = cur.getString(cur.getColumnIndex("VarName"));
            d._VarData = cur.getString(cur.getColumnIndex("VarData"));
            d._Observ = cur.getString(cur.getColumnIndex("Observ"));
            d._ObservDT = cur.getString(cur.getColumnIndex("ObservDT"));
            d._FirstTm = cur.getString(cur.getColumnIndex("FirstTm"));
            d._FinalTm = cur.getString(cur.getColumnIndex("FinalTm"));

            data.add(d);

            cur.moveToNext();
        }
        cur.close();
        return data;
    }
}