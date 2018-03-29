package org.icddrb.enap;

import android.content.Context;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;
 public class KMC_Pos_DataModel{

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
        private String _objno = "";
        public String getobjno(){
              return _objno;
         }
        public void setobjno(String newValue){
              _objno = newValue;
         }
        private String _objdate = "";
        public String getobjdate(){
              return _objdate;
         }
        public void setobjdate(String newValue){
              _objdate = newValue;
         }
        private String _objtime = "";
        public String getobjtime(){
              return _objtime;
         }
        public void setobjtime(String newValue){
              _objtime = newValue;
         }
        private String _kmc = "";
        public String getkmc(){
              return _kmc;
         }
        public void setkmc(String newValue){
              _kmc = newValue;
         }
        private String _kmcwho = "";
        public String getkmcwho(){
              return _kmcwho;
         }
        public void setkmcwho(String newValue){
              _kmcwho = newValue;
         }
        private String _kmcwhooth = "";
        public String getkmcwhooth(){
              return _kmcwhooth;
         }
        public void setkmcwhooth(String newValue){
              _kmcwhooth = newValue;
         }
        private String _kmcpos2a = "";
        public String getkmcpos2a(){
              return _kmcpos2a;
         }
        public void setkmcpos2a(String newValue){
              _kmcpos2a = newValue;
         }
        private String _kmcpos2b = "";
        public String getkmcpos2b(){
              return _kmcpos2b;
         }
        public void setkmcpos2b(String newValue){
              _kmcpos2b = newValue;
         }
        private String _kmcpos2c = "";
        public String getkmcpos2c(){
              return _kmcpos2c;
         }
        public void setkmcpos2c(String newValue){
              _kmcpos2c = newValue;
         }
        private String _kmcpos2d = "";
        public String getkmcpos2d(){
              return _kmcpos2d;
         }
        public void setkmcpos2d(String newValue){
              _kmcpos2d = newValue;
         }
        private String _kmcpos2e = "";
        public String getkmcpos2e(){
              return _kmcpos2e;
         }
        public void setkmcpos2e(String newValue){
              _kmcpos2e = newValue;
         }
        private String _kmcpos2f = "";
        public String getkmcpos2f(){
              return _kmcpos2f;
         }
        public void setkmcpos2f(String newValue){
              _kmcpos2f = newValue;
         }
        private String _kmcpos2g = "";
        public String getkmcpos2g(){
              return _kmcpos2g;
         }
        public void setkmcpos2g(String newValue){
              _kmcpos2g = newValue;
         }
        private String _kmcpos2h = "";
        public String getkmcpos2h(){
              return _kmcpos2h;
         }
        public void setkmcpos2h(String newValue){
              _kmcpos2h = newValue;
         }
        private String _nokmcreas = "";
        public String getnokmcreas(){
              return _nokmcreas;
         }
        public void setnokmcreas(String newValue){
              _nokmcreas = newValue;
         }
        private String _nokmcreasoth = "";
        public String getnokmcreasoth(){
              return _nokmcreasoth;
         }
        public void setnokmcreasoth(String newValue){
              _nokmcreasoth = newValue;
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

        String TableName = "KMC_Pos";

        public String SaveUpdateData(Context context)
        {
            String response = "";
            C = new Connection(context);
            String SQL = "";
            try
            {
                 if(C.Existence("Select * from "+ TableName +"  Where CountryCode='"+ _CountryCode +"' and FaciCode='"+ _FaciCode +"' and DataID='"+ _DataID +"' and objno='"+ _objno +"' "))
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
                 SQL = "Insert into "+ TableName +" (CountryCode,FaciCode,DataID,StudyID,objno,objdate,objtime,kmc,kmcwho,kmcwhooth,kmcpos2a,kmcpos2b,kmcpos2c,kmcpos2d,kmcpos2e,kmcpos2f,kmcpos2g,kmcpos2h,nokmcreas,nokmcreasoth,StartTime,EndTime,DeviceID,EntryUser,Lat,Lon,EnDt,Upload,modifyDate)Values('"+ _CountryCode +"', '"+ _FaciCode +"', '"+ _DataID +"', '"+ _StudyID +"', '"+ _objno +"', '"+ _objdate +"', '"+ _objtime +"', '"+ _kmc +"', '"+ _kmcwho +"', '"+ _kmcwhooth +"', '"+ _kmcpos2a +"', '"+ _kmcpos2b +"', '"+ _kmcpos2c +"', '"+ _kmcpos2d +"', '"+ _kmcpos2e +"', '"+ _kmcpos2f +"', '"+ _kmcpos2g +"', '"+ _kmcpos2h +"', '"+ _nokmcreas +"', '"+ _nokmcreasoth +"', '"+ _StartTime +"', '"+ _EndTime +"', '"+ _DeviceID +"', '"+ _EntryUser +"', '"+ _Lat +"', '"+ _Lon +"', '"+ _EnDt +"', '"+ _Upload +"', '"+ _modifyDate +"')";
                 response = C.SaveData(SQL);
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
                 SQL = "Update "+ TableName +" Set Upload='2',modifyDate='" + _modifyDate + "' ,CountryCode = '"+ _CountryCode +"',FaciCode = '"+ _FaciCode +"',DataID = '"+ _DataID +"',StudyID = '"+ _StudyID +"',objno = '"+ _objno +"',objdate = '"+ _objdate +"',objtime = '"+ _objtime +"',kmc = '"+ _kmc +"',kmcwho = '"+ _kmcwho +"',kmcwhooth = '"+ _kmcwhooth +"',kmcpos2a = '"+ _kmcpos2a +"',kmcpos2b = '"+ _kmcpos2b +"',kmcpos2c = '"+ _kmcpos2c +"',kmcpos2d = '"+ _kmcpos2d +"',kmcpos2e = '"+ _kmcpos2e +"',kmcpos2f = '"+ _kmcpos2f +"',kmcpos2g = '"+ _kmcpos2g +"',kmcpos2h = '"+ _kmcpos2h +"',nokmcreas = '"+ _nokmcreas +"',nokmcreasoth = '"+ _nokmcreasoth +"'  Where CountryCode='"+ _CountryCode +"' and FaciCode='"+ _FaciCode +"' and DataID='"+ _DataID +"' and objno='"+ _objno +"'";
                 response = C.SaveData(SQL);
                 C.close();
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }


        public List<KMC_Pos_DataModel> SelectAll(Context context, String SQL)
        {
            Connection C = new Connection(context);
            List<KMC_Pos_DataModel> data = new ArrayList<KMC_Pos_DataModel>();
            KMC_Pos_DataModel d = new KMC_Pos_DataModel();
            Cursor cur = C.ReadData(SQL);

            cur.moveToFirst();
            while(!cur.isAfterLast())
            {
                d = new KMC_Pos_DataModel();
                d._CountryCode = cur.getString(cur.getColumnIndex("CountryCode"));
                d._FaciCode = cur.getString(cur.getColumnIndex("FaciCode"));
                d._DataID = cur.getString(cur.getColumnIndex("DataID"));
                d._StudyID = cur.getString(cur.getColumnIndex("StudyID"));
                d._objno = cur.getString(cur.getColumnIndex("objno"));
                d._objdate = cur.getString(cur.getColumnIndex("objdate"));
                d._objtime = cur.getString(cur.getColumnIndex("objtime"));
                d._kmc = cur.getString(cur.getColumnIndex("kmc"));
                d._kmcwho = cur.getString(cur.getColumnIndex("kmcwho"));
                d._kmcwhooth = cur.getString(cur.getColumnIndex("kmcwhooth"));
                d._kmcpos2a = cur.getString(cur.getColumnIndex("kmcpos2a"));
                d._kmcpos2b = cur.getString(cur.getColumnIndex("kmcpos2b"));
                d._kmcpos2c = cur.getString(cur.getColumnIndex("kmcpos2c"));
                d._kmcpos2d = cur.getString(cur.getColumnIndex("kmcpos2d"));
                d._kmcpos2e = cur.getString(cur.getColumnIndex("kmcpos2e"));
                d._kmcpos2f = cur.getString(cur.getColumnIndex("kmcpos2f"));
                d._kmcpos2g = cur.getString(cur.getColumnIndex("kmcpos2g"));
                d._kmcpos2h = cur.getString(cur.getColumnIndex("kmcpos2h"));
                d._nokmcreas = cur.getString(cur.getColumnIndex("nokmcreas"));
                d._nokmcreasoth = cur.getString(cur.getColumnIndex("nokmcreasoth"));
                data.add(d);

                cur.moveToNext();
            }
            cur.close();
          return data;
        }
 }