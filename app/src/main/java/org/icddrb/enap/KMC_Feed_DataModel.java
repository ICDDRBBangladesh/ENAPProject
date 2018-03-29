package org.icddrb.enap;

import android.content.Context;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;
 public class KMC_Feed_DataModel{

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
        private String _cup = "";
        public String getcup(){
              return _cup;
         }
        public void setcup(String newValue){
              _cup = newValue;
         }
        private String _cuptime = "";
        public String getcuptime(){
              return _cuptime;
         }
        public void setcuptime(String newValue){
              _cuptime = newValue;
         }
        private String _cupwho = "";
        public String getcupwho(){
              return _cupwho;
         }
        public void setcupwho(String newValue){
              _cupwho = newValue;
         }
        private String _cupwhooth = "";
        public String getcupwhooth(){
              return _cupwhooth;
         }
        public void setcupwhooth(String newValue){
              _cupwhooth = newValue;
         }
        private String _cuphowmuch = "";
        public String getcuphowmuch(){
              return _cuphowmuch;
         }
        public void setcuphowmuch(String newValue){
              _cuphowmuch = newValue;
         }
        private String _naso = "";
        public String getnaso(){
              return _naso;
         }
        public void setnaso(String newValue){
              _naso = newValue;
         }
        private String _nasotime = "";
        public String getnasotime(){
              return _nasotime;
         }
        public void setnasotime(String newValue){
              _nasotime = newValue;
         }
        private String _nasowho = "";
        public String getnasowho(){
              return _nasowho;
         }
        public void setnasowho(String newValue){
              _nasowho = newValue;
         }
        private String _nasowhooth = "";
        public String getnasowhooth(){
              return _nasowhooth;
         }
        public void setnasowhooth(String newValue){
              _nasowhooth = newValue;
         }
        private String _nasohowmuch = "";
        public String getnasohowmuch(){
              return _nasohowmuch;
         }
        public void setnasohowmuch(String newValue){
              _nasohowmuch = newValue;
         }
        private String _suckbst = "";
        public String getsuckbst(){
              return _suckbst;
         }
        public void setsuckbst(String newValue){
              _suckbst = newValue;
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

        String TableName = "KMC_Feed";

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
                 SQL = "Insert into "+ TableName +" (CountryCode,FaciCode,DataID,StudyID,objno,objdate,objtime,cup,cuptime,cupwho,cupwhooth,cuphowmuch,naso,nasotime,nasowho,nasowhooth,nasohowmuch,suckbst,StartTime,EndTime,DeviceID,EntryUser,Lat,Lon,EnDt,Upload,modifyDate)Values('"+ _CountryCode +"', '"+ _FaciCode +"', '"+ _DataID +"', '"+ _StudyID +"', '"+ _objno +"', '"+ _objdate +"', '"+ _objtime +"', '"+ _cup +"', '"+ _cuptime +"', '"+ _cupwho +"', '"+ _cupwhooth +"', '"+ _cuphowmuch +"', '"+ _naso +"', '"+ _nasotime +"', '"+ _nasowho +"', '"+ _nasowhooth +"', '"+ _nasohowmuch +"', '"+ _suckbst +"', '"+ _StartTime +"', '"+ _EndTime +"', '"+ _DeviceID +"', '"+ _EntryUser +"', '"+ _Lat +"', '"+ _Lon +"', '"+ _EnDt +"', '"+ _Upload +"', '"+ _modifyDate +"')";
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
                 SQL = "Update "+ TableName +" Set Upload='2',modifyDate='" + _modifyDate + "' ,CountryCode = '"+ _CountryCode +"',FaciCode = '"+ _FaciCode +"',DataID = '"+ _DataID +"',StudyID = '"+ _StudyID +"',objno = '"+ _objno +"',objdate = '"+ _objdate +"',objtime = '"+ _objtime +"',cup = '"+ _cup +"',cuptime = '"+ _cuptime +"',cupwho = '"+ _cupwho +"',cupwhooth = '"+ _cupwhooth +"',cuphowmuch = '"+ _cuphowmuch +"',naso = '"+ _naso +"',nasotime = '"+ _nasotime +"',nasowho = '"+ _nasowho +"',nasowhooth = '"+ _nasowhooth +"',nasohowmuch = '"+ _nasohowmuch +"',suckbst = '"+ _suckbst +"'  Where CountryCode='"+ _CountryCode +"' and FaciCode='"+ _FaciCode +"' and DataID='"+ _DataID +"' and objno='"+ _objno +"'";
                 response = C.SaveData(SQL);
                 C.close();
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }


        public List<KMC_Feed_DataModel> SelectAll(Context context, String SQL)
        {
            Connection C = new Connection(context);
            List<KMC_Feed_DataModel> data = new ArrayList<KMC_Feed_DataModel>();
            KMC_Feed_DataModel d = new KMC_Feed_DataModel();
            Cursor cur = C.ReadData(SQL);

            cur.moveToFirst();
            while(!cur.isAfterLast())
            {
                d = new KMC_Feed_DataModel();
                d._CountryCode = cur.getString(cur.getColumnIndex("CountryCode"));
                d._FaciCode = cur.getString(cur.getColumnIndex("FaciCode"));
                d._DataID = cur.getString(cur.getColumnIndex("DataID"));
                d._StudyID = cur.getString(cur.getColumnIndex("StudyID"));
                d._objno = cur.getString(cur.getColumnIndex("objno"));
                d._objdate = cur.getString(cur.getColumnIndex("objdate"));
                d._objtime = cur.getString(cur.getColumnIndex("objtime"));
                d._cup = cur.getString(cur.getColumnIndex("cup"));
                d._cuptime = cur.getString(cur.getColumnIndex("cuptime"));
                d._cupwho = cur.getString(cur.getColumnIndex("cupwho"));
                d._cupwhooth = cur.getString(cur.getColumnIndex("cupwhooth"));
                d._cuphowmuch = cur.getString(cur.getColumnIndex("cuphowmuch"));
                d._naso = cur.getString(cur.getColumnIndex("naso"));
                d._nasotime = cur.getString(cur.getColumnIndex("nasotime"));
                d._nasowho = cur.getString(cur.getColumnIndex("nasowho"));
                d._nasowhooth = cur.getString(cur.getColumnIndex("nasowhooth"));
                d._nasohowmuch = cur.getString(cur.getColumnIndex("nasohowmuch"));
                d._suckbst = cur.getString(cur.getColumnIndex("suckbst"));
                data.add(d);

                cur.moveToNext();
            }
            cur.close();
          return data;
        }
 }