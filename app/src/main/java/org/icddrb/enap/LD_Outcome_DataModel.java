package org.icddrb.enap;

import android.content.Context;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;
 public class LD_Outcome_DataModel{

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
        private String _dod = "";
        public String getdod(){
              return _dod;
         }
        public void setdod(String newValue){
              _dod = newValue;
         }
        private String _tod = "";
        public String gettod(){
              return _tod;
         }
        public void settod(String newValue){
              _tod = newValue;
         }
        private String _matcond = "";
        public String getmatcond(){
              return _matcond;
         }
        public void setmatcond(String newValue){
              _matcond = newValue;
         }
        private String _matdschd = "";
        public String getmatdschd(){
              return _matdschd;
         }
        public void setmatdschd(String newValue){
              _matdschd = newValue;
         }
        private String _matdschdoth = "";
        public String getmatdschdoth(){
              return _matdschdoth;
         }
        public void setmatdschdoth(String newValue){
              _matdschdoth = newValue;
         }
        private String _bcond = "";
        public String getbcond(){
              return _bcond;
         }
        public void setbcond(String newValue){
              _bcond = newValue;
         }
        private String _bcondDT = "";
        public String getbcondDT(){
              return _bcondDT;
         }
        public void setbcondDT(String newValue){
              _bcondDT = newValue;
         }
        private String _bcondTM = "";
        public String getbcondTM(){
              return _bcondTM;
         }
        public void setbcondTM(String newValue){
              _bcondTM = newValue;
         }
        private String _bdschd = "";
        public String getbdschd(){
              return _bdschd;
         }
        public void setbdschd(String newValue){
              _bdschd = newValue;
         }
        private String _bdschdOth = "";
        public String getbdschdOth(){
              return _bdschdOth;
         }
        public void setbdschdOth(String newValue){
              _bdschdOth = newValue;
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

        String TableName = "LD_Outcome";

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
                 SQL = "Insert into "+ TableName +" (CountryCode,FaciCode,DataID,dod,tod,matcond,matdschd,matdschdoth,bcond,bcondDT,bcondTM,bdschd,bdschdOth,StartTime,EndTime,DeviceID,EntryUser,Lat,Lon,EnDt,Upload,modifyDate)Values('"+ _CountryCode +"', '"+ _FaciCode +"', '"+ _DataID +"', '"+ _dod +"', '"+ _tod +"', '"+ _matcond +"', '"+ _matdschd +"', '"+ _matdschdoth +"', '"+ _bcond +"', '"+ _bcondDT +"', '"+ _bcondTM +"', '"+ _bdschd +"', '"+ _bdschdOth +"', '"+ _StartTime +"', '"+ _EndTime +"', '"+ _DeviceID +"', '"+ _EntryUser +"', '"+ _Lat +"', '"+ _Lon +"', '"+ _EnDt +"', '"+ _Upload +"', '"+ _modifyDate +"')";
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
                 SQL = "Update "+ TableName +" Set Upload='2',modifyDate='" + _modifyDate + "' ,CountryCode = '"+ _CountryCode +"',FaciCode = '"+ _FaciCode +"',DataID = '"+ _DataID +"',dod = '"+ _dod +"',tod = '"+ _tod +"',matcond = '"+ _matcond +"',matdschd = '"+ _matdschd +"',matdschdoth = '"+ _matdschdoth +"',bcond = '"+ _bcond +"',bcondDT = '"+ _bcondDT +"',bcondTM = '"+ _bcondTM +"',bdschd = '"+ _bdschd +"',bdschdOth = '"+ _bdschdOth +"'  Where CountryCode='"+ _CountryCode +"' and FaciCode='"+ _FaciCode +"' and DataID='"+ _DataID +"'";
                 C.Save(SQL);
                 C.close();
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }


        public List<LD_Outcome_DataModel> SelectAll(Context context, String SQL)
        {
            Connection C = new Connection(context);
            List<LD_Outcome_DataModel> data = new ArrayList<LD_Outcome_DataModel>();
            LD_Outcome_DataModel d = new LD_Outcome_DataModel();
            Cursor cur = C.ReadData(SQL);

            cur.moveToFirst();
            while(!cur.isAfterLast())
            {
                d = new LD_Outcome_DataModel();
                d._CountryCode = cur.getString(cur.getColumnIndex("CountryCode"));
                d._FaciCode = cur.getString(cur.getColumnIndex("FaciCode"));
                d._DataID = cur.getString(cur.getColumnIndex("DataID"));
                d._dod = cur.getString(cur.getColumnIndex("dod"));
                d._tod = cur.getString(cur.getColumnIndex("tod"));
                d._matcond = cur.getString(cur.getColumnIndex("matcond"));
                d._matdschd = cur.getString(cur.getColumnIndex("matdschd"));
                d._matdschdoth = cur.getString(cur.getColumnIndex("matdschdoth"));
                d._bcond = cur.getString(cur.getColumnIndex("bcond"));
                d._bcondDT = cur.getString(cur.getColumnIndex("bcondDT"));
                d._bcondTM = cur.getString(cur.getColumnIndex("bcondTM"));
                d._bdschd = cur.getString(cur.getColumnIndex("bdschd"));
                d._bdschdOth = cur.getString(cur.getColumnIndex("bdschdOth"));
                data.add(d);

                cur.moveToNext();
            }
            cur.close();
          return data;
        }
 }