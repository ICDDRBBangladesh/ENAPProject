package org.icddrb.enap;

import android.content.Context;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;
 public class KMC_Outcome_DataModel{

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
        private String _DataID = "";
        public String getDataID(){
              return _DataID;
         }
        public void setDataID(String newValue){
              _DataID = newValue;
         }
        private String _babycond = "";
        public String getbabycond(){
              return _babycond;
         }
        public void setbabycond(String newValue){
              _babycond = newValue;
         }
        private String _deathdt = "";
        public String getdeathdt(){
              return _deathdt;
         }
        public void setdeathdt(String newValue){
              _deathdt = newValue;
         }
        private String _deathtm = "";
        public String getdeathtm(){
              return _deathtm;
         }
        public void setdeathtm(String newValue){
              _deathtm = newValue;
         }
        private String _deathtmdk = "";
        public String getdeathtmdk(){
              return _deathtmdk;
         }
        public void setdeathtmdk(String newValue){
              _deathtmdk = newValue;
         }
        private String _discdt = "";
        public String getdiscdt(){
              return _discdt;
         }
        public void setdiscdt(String newValue){
              _discdt = newValue;
         }
        private String _disctm = "";
        public String getdisctm(){
              return _disctm;
         }
        public void setdisctm(String newValue){
              _disctm = newValue;
         }
        private String _disctmdk = "";
        public String getdisctmdk(){
              return _disctmdk;
         }
        public void setdisctmdk(String newValue){
              _disctmdk = newValue;
         }
        private String _discweight = "";
        public String getdiscweight(){
              return _discweight;
         }
        public void setdiscweight(String newValue){
              _discweight = newValue;
         }
        private String _discweightdk = "";
        public String getdiscweightdk(){
              return _discweightdk;
         }
        public void setdiscweightdk(String newValue){
              _discweightdk = newValue;
         }
        private String _discto = "";
        public String getdiscto(){
              return _discto;
         }
        public void setdiscto(String newValue){
              _discto = newValue;
         }
        private String _disctooth = "";
        public String getdisctooth(){
              return _disctooth;
         }
        public void setdisctooth(String newValue){
              _disctooth = newValue;
         }
        private String _motcond = "";
        public String getmotcond(){
              return _motcond;
         }
        public void setmotcond(String newValue){
              _motcond = newValue;
         }
        private String _motdiscto = "";
        public String getmotdiscto(){
              return _motdiscto;
         }
        public void setmotdiscto(String newValue){
              _motdiscto = newValue;
         }
        private String _motdisctooth = "";
        public String getmotdisctooth(){
              return _motdisctooth;
         }
        public void setmotdisctooth(String newValue){
              _motdisctooth = newValue;
         }
        private String _objstatus = "";
        public String getobjstatus(){
              return _objstatus;
         }
        public void setobjstatus(String newValue){
              _objstatus = newValue;
         }
        private String _whyincom = "";
        public String getwhyincom(){
              return _whyincom;
         }
        public void setwhyincom(String newValue){
              _whyincom = newValue;
         }
        private String _reason = "";
        public String getreason(){
              return _reason;
         }
        public void setreason(String newValue){
              _reason = newValue;
         }
        private String _incirep = "";
        public String getincirep(){
              return _incirep;
         }
        public void setincirep(String newValue){
              _incirep = newValue;
         }
        private String _incident = "";
        public String getincident(){
              return _incident;
         }
        public void setincident(String newValue){
              _incident = newValue;
         }
        private String _inciformsl = "";
        public String getinciformsl(){
              return _inciformsl;
         }
        public void setinciformsl(String newValue){
              _inciformsl = newValue;
         }
        private String _StartTime = "";
        public void setStartTime(String newValue){
              _StartTime = newValue;
         }
        private String _EndTime = "";
        public void setEndTime(String newValue){
              _EndTime = newValue;
         }
        private String _DeviceID = "";
        public void setDeviceID(String newValue){
              _DeviceID = newValue;
         }
        private String _EntryUser = "";
        public void setEntryUser(String newValue){
              _EntryUser = newValue;
         }
        private String _Lat = "";
        public void setLat(String newValue){
              _Lat = newValue;
         }
        private String _Lon = "";
        public void setLon(String newValue){
              _Lon = newValue;
         }
        private String _EnDt = "";
        public void setEnDt(String newValue){
              _EnDt = newValue;
         }
        private String _Upload = "2";
        private String _modifyDate = "";
        public void setmodifyDate(String newValue){
        _modifyDate = newValue;
        }

        String TableName = "KMC_Outcome";

        public String SaveUpdateData(Context context)
        {
            String response = "";
            C = new Connection(context);
            String SQL = "";
            try
            {
                 if(C.Existence("Select * from "+ TableName +"  Where CountryCode='"+ _CountryCode +"' and FaciCode='"+ _FaciCode +"' and DataID='"+ _DataID +"' "))
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
                 SQL = "Insert into "+ TableName +" (CountryCode,FaciCode,DataID,babycond,deathdt,deathtm,deathtmdk,discdt,disctm,disctmdk,discweight,discweightdk,discto,disctooth,motcond,motdiscto,motdisctooth,objstatus,whyincom,reason,incirep,incident,inciformsl,StartTime,EndTime,DeviceID,EntryUser,Lat,Lon,EnDt,Upload,modifyDate)Values('"+ _CountryCode +"', '"+ _FaciCode +"', '"+ _DataID +"', '"+ _babycond +"', '"+ _deathdt +"', '"+ _deathtm +"', '"+ _deathtmdk +"', '"+ _discdt +"', '"+ _disctm +"', '"+ _disctmdk +"', '"+ _discweight +"', '"+ _discweightdk +"', '"+ _discto +"', '"+ _disctooth +"', '"+ _motcond +"', '"+ _motdiscto +"', '"+ _motdisctooth +"', '"+ _objstatus +"', '"+ _whyincom +"', '"+ _reason +"', '"+ _incirep +"', '"+ _incident +"', '"+ _inciformsl +"', '"+ _StartTime +"', '"+ _EndTime +"', '"+ _DeviceID +"', '"+ _EntryUser +"', '"+ _Lat +"', '"+ _Lon +"', '"+ _EnDt +"', '"+ _Upload +"', '"+ _modifyDate +"')";
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
                 SQL = "Update "+ TableName +" Set Upload='2',modifyDate='" + _modifyDate + "' ,CountryCode = '"+ _CountryCode +"',FaciCode = '"+ _FaciCode +"',DataID = '"+ _DataID +"',babycond = '"+ _babycond +"',deathdt = '"+ _deathdt +"',deathtm = '"+ _deathtm +"',deathtmdk = '"+ _deathtmdk +"',discdt = '"+ _discdt +"',disctm = '"+ _disctm +"',disctmdk = '"+ _disctmdk +"',discweight = '"+ _discweight +"',discweightdk = '"+ _discweightdk +"',discto = '"+ _discto +"',disctooth = '"+ _disctooth +"',motcond = '"+ _motcond +"',motdiscto = '"+ _motdiscto +"',motdisctooth = '"+ _motdisctooth +"',objstatus = '"+ _objstatus +"',whyincom = '"+ _whyincom +"',reason = '"+ _reason +"',incirep = '"+ _incirep +"',incident = '"+ _incident +"',inciformsl = '"+ _inciformsl +"'  Where CountryCode='"+ _CountryCode +"' and FaciCode='"+ _FaciCode +"' and DataID='"+ _DataID +"'";
                 C.Save(SQL);
                 C.close();
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }


        public List<KMC_Outcome_DataModel> SelectAll(Context context, String SQL)
        {
            Connection C = new Connection(context);
            List<KMC_Outcome_DataModel> data = new ArrayList<KMC_Outcome_DataModel>();
            KMC_Outcome_DataModel d = new KMC_Outcome_DataModel();
            Cursor cur = C.ReadData(SQL);

            cur.moveToFirst();
            while(!cur.isAfterLast())
            {
                d = new KMC_Outcome_DataModel();
                d._CountryCode = cur.getString(cur.getColumnIndex("CountryCode"));
                d._FaciCode = cur.getString(cur.getColumnIndex("FaciCode"));
                d._DataID = cur.getString(cur.getColumnIndex("DataID"));
                d._babycond = cur.getString(cur.getColumnIndex("babycond"));
                d._deathdt = cur.getString(cur.getColumnIndex("deathdt"));
                d._deathtm = cur.getString(cur.getColumnIndex("deathtm"));
                d._deathtmdk = cur.getString(cur.getColumnIndex("deathtmdk"));
                d._discdt = cur.getString(cur.getColumnIndex("discdt"));
                d._disctm = cur.getString(cur.getColumnIndex("disctm"));
                d._disctmdk = cur.getString(cur.getColumnIndex("disctmdk"));
                d._discweight = cur.getString(cur.getColumnIndex("discweight"));
                d._discweightdk = cur.getString(cur.getColumnIndex("discweightdk"));
                d._discto = cur.getString(cur.getColumnIndex("discto"));
                d._disctooth = cur.getString(cur.getColumnIndex("disctooth"));
                d._motcond = cur.getString(cur.getColumnIndex("motcond"));
                d._motdiscto = cur.getString(cur.getColumnIndex("motdiscto"));
                d._motdisctooth = cur.getString(cur.getColumnIndex("motdisctooth"));
                d._objstatus = cur.getString(cur.getColumnIndex("objstatus"));
                d._whyincom = cur.getString(cur.getColumnIndex("whyincom"));
                d._reason = cur.getString(cur.getColumnIndex("reason"));
                d._incirep = cur.getString(cur.getColumnIndex("incirep"));
                d._incident = cur.getString(cur.getColumnIndex("incident"));
                d._inciformsl = cur.getString(cur.getColumnIndex("inciformsl"));
                data.add(d);

                cur.moveToNext();
            }
            cur.close();
          return data;
        }
 }