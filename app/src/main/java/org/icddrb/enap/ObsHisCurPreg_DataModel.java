package org.icddrb.enap;

import android.content.Context;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;
 public class ObsHisCurPreg_DataModel{

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
        private String _card = "";
        public String getcard(){
              return _card;
         }
        public void setcard(String newValue){
              _card = newValue;
         }
        private String _prevpreg = "";
        public String getprevpreg(){
              return _prevpreg;
         }
        public void setprevpreg(String newValue){
              _prevpreg = newValue;
         }
        private String _prevliveb = "";
        public String getprevliveb(){
              return _prevliveb;
         }
        public void setprevliveb(String newValue){
              _prevliveb = newValue;
         }
        private String _prevstillb = "";
        public String getprevstillb(){
              return _prevstillb;
         }
        public void setprevstillb(String newValue){
              _prevstillb = newValue;
         }
        private String _prevab = "";
        public String getprevab(){
              return _prevab;
         }
        public void setprevab(String newValue){
              _prevab = newValue;
         }
        private String _prevcsec = "";
        public String getprevcsec(){
              return _prevcsec;
         }
        public void setprevcsec(String newValue){
              _prevcsec = newValue;
         }
        private String _yrslstbth = "";
        public String getyrslstbth(){
              return _yrslstbth;
         }
        public void setyrslstbth(String newValue){
              _yrslstbth = newValue;
         }
        private String _edd = "";
        public String getedd(){
              return _edd;
         }
        public void setedd(String newValue){
              _edd = newValue;
         }
        private String _eddDK = "";
        public String geteddDK(){
              return _eddDK;
         }
        public void seteddDK(String newValue){
              _eddDK = newValue;
         }
        private String _gaadm = "";
        public String getgaadm(){
              return _gaadm;
         }
        public void setgaadm(String newValue){
              _gaadm = newValue;
         }
        private String _gameth = "";
        public String getgameth(){
              return _gameth;
         }
        public void setgameth(String newValue){
              _gameth = newValue;
         }
        private String _bb4expect = "";
        public String getbb4expect(){
              return _bb4expect;
         }
        public void setbb4expect(String newValue){
              _bb4expect = newValue;
         }
        private String _numbby = "";
        public String getnumbby(){
              return _numbby;
         }
        public void setnumbby(String newValue){
              _numbby = newValue;
         }
        private String _numPreg = "";
        public String getnumPreg(){
              return _numPreg;
         }
        public void setnumPreg(String newValue){
              _numPreg = newValue;
         }
        private String _bheartadm = "";
        public String getbheartadm(){
              return _bheartadm;
         }
        public void setbheartadm(String newValue){
              _bheartadm = newValue;
         }
        private String _bheartrateadm = "";
        public String getbheartrateadm(){
              return _bheartrateadm;
         }
        public void setbheartrateadm(String newValue){
              _bheartrateadm = newValue;
         }
        private String _bheartratenum = "";
        public String getbheartratenum(){
              return _bheartratenum;
         }
        public void setbheartratenum(String newValue){
              _bheartratenum = newValue;
         }
        private String _anybcompadm = "";
        public String getanybcompadm(){
              return _anybcompadm;
         }
        public void setanybcompadm(String newValue){
              _anybcompadm = newValue;
         }
        private String _allocobsv = "";
        public String getallocobsv(){
              return _allocobsv;
         }
        public void setallocobsv(String newValue){
              _allocobsv = newValue;
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

        String TableName = "ObsHisCurPreg";

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
                 SQL = "Insert into "+ TableName +" (CountryCode,FaciCode,DataID,card,prevpreg,prevliveb,prevstillb,prevab,prevcsec,yrslstbth,edd,eddDK,gaadm,gameth,bb4expect,numbby,numPreg,bheartadm,bheartrateadm,bheartratenum,anybcompadm,allocobsv,StartTime,EndTime,DeviceID,EntryUser,Lat,Lon,EnDt,Upload,modifyDate)Values('"+ _CountryCode +"', '"+ _FaciCode +"', '"+ _DataID +"', '"+ _card +"', '"+ _prevpreg +"', '"+ _prevliveb +"', '"+ _prevstillb +"', '"+ _prevab +"', '"+ _prevcsec +"', '"+ _yrslstbth +"', '"+ _edd +"', '"+ _eddDK +"', '"+ _gaadm +"', '"+ _gameth +"', '"+ _bb4expect +"', '"+ _numbby +"', '"+ _numPreg +"', '"+ _bheartadm +"', '"+ _bheartrateadm +"', '"+ _bheartratenum +"', '"+ _anybcompadm +"', '"+ _allocobsv +"', '"+ _StartTime +"', '"+ _EndTime +"', '"+ _DeviceID +"', '"+ _EntryUser +"', '"+ _Lat +"', '"+ _Lon +"', '"+ _EnDt +"', '"+ _Upload +"', '"+ _modifyDate +"')";
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
                 SQL = "Update "+ TableName +" Set Upload='2',modifyDate='" + _modifyDate + "' ,CountryCode = '"+ _CountryCode +"',FaciCode = '"+ _FaciCode +"',DataID = '"+ _DataID +"',card = '"+ _card +"',prevpreg = '"+ _prevpreg +"',prevliveb = '"+ _prevliveb +"',prevstillb = '"+ _prevstillb +"',prevab = '"+ _prevab +"',prevcsec = '"+ _prevcsec +"',yrslstbth = '"+ _yrslstbth +"',edd = '"+ _edd +"',eddDK = '"+ _eddDK +"',gaadm = '"+ _gaadm +"',gameth = '"+ _gameth +"',bb4expect = '"+ _bb4expect +"',numbby = '"+ _numbby +"',numPreg = '"+ _numPreg +"',bheartadm = '"+ _bheartadm +"',bheartrateadm = '"+ _bheartrateadm +"',bheartratenum = '"+ _bheartratenum +"',anybcompadm = '"+ _anybcompadm +"',allocobsv = '"+ _allocobsv +"'  Where CountryCode='"+ _CountryCode +"' and FaciCode='"+ _FaciCode +"' and DataID='"+ _DataID +"'";
                 C.Save(SQL);
                 C.close();
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }


        public List<ObsHisCurPreg_DataModel> SelectAll(Context context, String SQL)
        {
            Connection C = new Connection(context);
            List<ObsHisCurPreg_DataModel> data = new ArrayList<ObsHisCurPreg_DataModel>();
            ObsHisCurPreg_DataModel d = new ObsHisCurPreg_DataModel();
            Cursor cur = C.ReadData(SQL);

            cur.moveToFirst();
            while(!cur.isAfterLast())
            {
                d = new ObsHisCurPreg_DataModel();
                d._CountryCode = cur.getString(cur.getColumnIndex("CountryCode"));
                d._FaciCode = cur.getString(cur.getColumnIndex("FaciCode"));
                d._DataID = cur.getString(cur.getColumnIndex("DataID"));
                d._card = cur.getString(cur.getColumnIndex("card"));
                d._prevpreg = cur.getString(cur.getColumnIndex("prevpreg"));
                d._prevliveb = cur.getString(cur.getColumnIndex("prevliveb"));
                d._prevstillb = cur.getString(cur.getColumnIndex("prevstillb"));
                d._prevab = cur.getString(cur.getColumnIndex("prevab"));
                d._prevcsec = cur.getString(cur.getColumnIndex("prevcsec"));
                d._yrslstbth = cur.getString(cur.getColumnIndex("yrslstbth"));
                d._edd = cur.getString(cur.getColumnIndex("edd"));
                d._eddDK = cur.getString(cur.getColumnIndex("eddDK"));
                d._gaadm = cur.getString(cur.getColumnIndex("gaadm"));
                d._gameth = cur.getString(cur.getColumnIndex("gameth"));
                d._bb4expect = cur.getString(cur.getColumnIndex("bb4expect"));
                d._numbby = cur.getString(cur.getColumnIndex("numbby"));
                d._numPreg = cur.getString(cur.getColumnIndex("numPreg"));
                d._bheartadm = cur.getString(cur.getColumnIndex("bheartadm"));
                d._bheartrateadm = cur.getString(cur.getColumnIndex("bheartrateadm"));
                d._bheartratenum = cur.getString(cur.getColumnIndex("bheartratenum"));
                d._anybcompadm = cur.getString(cur.getColumnIndex("anybcompadm"));
                d._allocobsv = cur.getString(cur.getColumnIndex("allocobsv"));
                data.add(d);

                cur.moveToNext();
            }
            cur.close();
          return data;
        }
 }