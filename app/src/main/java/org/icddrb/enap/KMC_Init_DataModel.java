package org.icddrb.enap;

import android.content.Context;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;
 public class KMC_Init_DataModel{

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
        private String _StudyID = "";
        public String getStudyID(){
              return _StudyID;
         }
        public void setStudyID(String newValue){
              _StudyID = newValue;
         }

     private String _kmcinit = "";
     public String getkmcinit(){
         return _kmcinit;
     }
     public void setkmcinit(String newValue){
         _kmcinit = newValue;
     }

        private String _initDate = "";
        public String getinitDate(){
              return _initDate;
         }
        public void setinitDate(String newValue){
              _initDate = newValue;
         }
        private String _initTime = "";
        public String getinitTime(){
              return _initTime;
         }
        public void setinitTime(String newValue){
              _initTime = newValue;
         }
        private String _kmced = "";
        public String getkmced(){
              return _kmced;
         }
        public void setkmced(String newValue){
              _kmced = newValue;
         }
        private String _kmcpos1 = "";
        public String getkmcpos1(){
              return _kmcpos1;
         }
        public void setkmcpos1(String newValue){
              _kmcpos1 = newValue;
         }
        private String _bhat = "";
        public String getbhat(){
              return _bhat;
         }
        public void setbhat(String newValue){
              _bhat = newValue;
         }
        private String _bvertcl = "";
        public String getbvertcl(){
              return _bvertcl;
         }
        public void setbvertcl(String newValue){
              _bvertcl = newValue;
         }
        private String _bnakchest = "";
        public String getbnakchest(){
              return _bnakchest;
         }
        public void setbnakchest(String newValue){
              _bnakchest = newValue;
         }
        private String _bfrog = "";
        public String getbfrog(){
              return _bfrog;
         }
        public void setbfrog(String newValue){
              _bfrog = newValue;
         }
        private String _bcheek = "";
        public String getbcheek(){
              return _bcheek;
         }
        public void setbcheek(String newValue){
              _bcheek = newValue;
         }
        private String _bnap = "";
        public String getbnap(){
              return _bnap;
         }
        public void setbnap(String newValue){
              _bnap = newValue;
         }
        private String _bfixed = "";
        public String getbfixed(){
              return _bfixed;
         }
        public void setbfixed(String newValue){
              _bfixed = newValue;
         }
        private String _bfixedOth = "";
        public String getbfixedOth(){
              return _bfixedOth;
         }
        public void setbfixedOth(String newValue){
              _bfixedOth = newValue;
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

        String TableName = "KMC_Init";

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
                 SQL = "Insert into "+ TableName +" (CountryCode,FaciCode,DataID,StudyID,kmcinit,initDate,initTime,kmced,kmcpos1,bhat,bvertcl,bnakchest,bfrog,bcheek,bnap,bfixed,bfixedOth,StartTime,EndTime,DeviceID,EntryUser,Lat,Lon,EnDt,Upload,modifyDate)Values('"+ _CountryCode +"', '"+ _FaciCode +"', '"+ _DataID +"', '"+ _StudyID +"','"+ _kmcinit +"', '"+ _initDate +"', '"+ _initTime +"', '"+ _kmced +"', '"+ _kmcpos1 +"', '"+ _bhat +"', '"+ _bvertcl +"', '"+ _bnakchest +"', '"+ _bfrog +"', '"+ _bcheek +"', '"+ _bnap +"', '"+ _bfixed +"', '"+ _bfixedOth +"', '"+ _StartTime +"', '"+ _EndTime +"', '"+ _DeviceID +"', '"+ _EntryUser +"', '"+ _Lat +"', '"+ _Lon +"', '"+ _EnDt +"', '"+ _Upload +"', '"+ _modifyDate +"')";
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
                 SQL = "Update "+ TableName +" Set Upload='2',modifyDate='" + _modifyDate + "' ,CountryCode = '"+ _CountryCode +"',FaciCode = '"+ _FaciCode +"',DataID = '"+ _DataID +"',StudyID = '"+ _StudyID +"',kmcinit='"+ _kmcinit +"',initDate = '"+ _initDate +"',initTime = '"+ _initTime +"',kmced = '"+ _kmced +"',kmcpos1 = '"+ _kmcpos1 +"',bhat = '"+ _bhat +"',bvertcl = '"+ _bvertcl +"',bnakchest = '"+ _bnakchest +"',bfrog = '"+ _bfrog +"',bcheek = '"+ _bcheek +"',bnap = '"+ _bnap +"',bfixed = '"+ _bfixed +"',bfixedOth = '"+ _bfixedOth +"'  Where CountryCode='"+ _CountryCode +"' and FaciCode='"+ _FaciCode +"' and DataID='"+ _DataID +"'";
                 C.Save(SQL);
                 C.close();
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }


        public List<KMC_Init_DataModel> SelectAll(Context context, String SQL)
        {
            Connection C = new Connection(context);
            List<KMC_Init_DataModel> data = new ArrayList<KMC_Init_DataModel>();
            KMC_Init_DataModel d = new KMC_Init_DataModel();
            Cursor cur = C.ReadData(SQL);

            cur.moveToFirst();
            while(!cur.isAfterLast())
            {
                d = new KMC_Init_DataModel();
                d._CountryCode = cur.getString(cur.getColumnIndex("CountryCode"));
                d._FaciCode = cur.getString(cur.getColumnIndex("FaciCode"));
                d._DataID = cur.getString(cur.getColumnIndex("DataID"));
                d._StudyID = cur.getString(cur.getColumnIndex("StudyID"));
                d._kmcinit = cur.getString(cur.getColumnIndex("kmcinit"));
                d._initDate = cur.getString(cur.getColumnIndex("initDate"));
                d._initTime = cur.getString(cur.getColumnIndex("initTime"));
                d._kmced = cur.getString(cur.getColumnIndex("kmced"));
                d._kmcpos1 = cur.getString(cur.getColumnIndex("kmcpos1"));
                d._bhat = cur.getString(cur.getColumnIndex("bhat"));
                d._bvertcl = cur.getString(cur.getColumnIndex("bvertcl"));
                d._bnakchest = cur.getString(cur.getColumnIndex("bnakchest"));
                d._bfrog = cur.getString(cur.getColumnIndex("bfrog"));
                d._bcheek = cur.getString(cur.getColumnIndex("bcheek"));
                d._bnap = cur.getString(cur.getColumnIndex("bnap"));
                d._bfixed = cur.getString(cur.getColumnIndex("bfixed"));
                d._bfixedOth = cur.getString(cur.getColumnIndex("bfixedOth"));
                data.add(d);

                cur.moveToNext();
            }
            cur.close();
          return data;
        }
 }