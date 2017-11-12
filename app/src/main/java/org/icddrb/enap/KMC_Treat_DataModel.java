package org.icddrb.enap;

import android.content.Context;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;
 public class KMC_Treat_DataModel{

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
        private String _supcare = "";
        public String getsupcare(){
              return _supcare;
         }
        public void setsupcare(String newValue){
              _supcare = newValue;
         }
        private String _banti = "";
        public String getbanti(){
              return _banti;
         }
        public void setbanti(String newValue){
              _banti = newValue;
         }
        private String _anti1 = "";
        public String getanti1(){
              return _anti1;
         }
        public void setanti1(String newValue){
              _anti1 = newValue;
         }
        private String _anti2 = "";
        public String getanti2(){
              return _anti2;
         }
        public void setanti2(String newValue){
              _anti2 = newValue;
         }
        private String _anti3 = "";
        public String getanti3(){
              return _anti3;
         }
        public void setanti3(String newValue){
              _anti3 = newValue;
         }
        private String _anti4 = "";
        public String getanti4(){
              return _anti4;
         }
        public void setanti4(String newValue){
              _anti4 = newValue;
         }
        private String _anti5 = "";
        public String getanti5(){
              return _anti5;
         }
        public void setanti5(String newValue){
              _anti5 = newValue;
         }
        private String _anti6 = "";
        public String getanti6(){
              return _anti6;
         }
        public void setanti6(String newValue){
              _anti6 = newValue;
         }
        private String _anti7 = "";
        public String getanti7(){
              return _anti7;
         }
        public void setanti7(String newValue){
              _anti7 = newValue;
         }
        private String _anti8 = "";
        public String getanti8(){
              return _anti8;
         }
        public void setanti8(String newValue){
              _anti8 = newValue;
         }
        private String _otherttmnt = "";
        public String getotherttmnt(){
              return _otherttmnt;
         }
        public void setotherttmnt(String newValue){
              _otherttmnt = newValue;
         }
        private String _otherttmntname = "";
        public String getotherttmntname(){
              return _otherttmntname;
         }
        public void setotherttmntname(String newValue){
              _otherttmntname = newValue;
         }
        private String _othtreat1 = "";
        public String getothtreat1(){
              return _othtreat1;
         }
        public void setothtreat1(String newValue){
              _othtreat1 = newValue;
         }
        private String _othtreat2 = "";
        public String getothtreat2(){
              return _othtreat2;
         }
        public void setothtreat2(String newValue){
              _othtreat2 = newValue;
         }
        private String _othtreat3 = "";
        public String getothtreat3(){
              return _othtreat3;
         }
        public void setothtreat3(String newValue){
              _othtreat3 = newValue;
         }
        private String _othtreat4 = "";
        public String getothtreat4(){
              return _othtreat4;
         }
        public void setothtreat4(String newValue){
              _othtreat4 = newValue;
         }
        private String _othtreat5 = "";
        public String getothtreat5(){
              return _othtreat5;
         }
        public void setothtreat5(String newValue){
              _othtreat5 = newValue;
         }
        private String _othtreat6 = "";
        public String getothtreat6(){
              return _othtreat6;
         }
        public void setothtreat6(String newValue){
              _othtreat6 = newValue;
         }
        private String _othtreat7 = "";
        public String getothtreat7(){
              return _othtreat7;
         }
        public void setothtreat7(String newValue){
              _othtreat7 = newValue;
         }
        private String _othtreat8 = "";
        public String getothtreat8(){
              return _othtreat8;
         }
        public void setothtreat8(String newValue){
              _othtreat8 = newValue;
         }
        private String _oxygen = "";
        public String getoxygen(){
              return _oxygen;
         }
        public void setoxygen(String newValue){
              _oxygen = newValue;
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

        String TableName = "KMC_Treat";

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
                 SQL = "Insert into "+ TableName +" (CountryCode,FaciCode,DataID,supcare,banti,anti1,anti2,anti3,anti4,anti5,anti6,anti7,anti8,otherttmnt,otherttmntname,othtreat1,othtreat2,othtreat3,othtreat4,othtreat5,othtreat6,othtreat7,othtreat8,oxygen,StartTime,EndTime,DeviceID,EntryUser,Lat,Lon,EnDt,Upload,modifyDate)Values('"+ _CountryCode +"', '"+ _FaciCode +"', '"+ _DataID +"', '"+ _supcare +"', '"+ _banti +"', '"+ _anti1 +"', '"+ _anti2 +"', '"+ _anti3 +"', '"+ _anti4 +"', '"+ _anti5 +"', '"+ _anti6 +"', '"+ _anti7 +"', '"+ _anti8 +"', '"+ _otherttmnt +"', '"+ _otherttmntname +"', '"+ _othtreat1 +"', '"+ _othtreat2 +"', '"+ _othtreat3 +"', '"+ _othtreat4 +"', '"+ _othtreat5 +"', '"+ _othtreat6 +"', '"+ _othtreat7 +"', '"+ _othtreat8 +"', '"+ _oxygen +"', '"+ _StartTime +"', '"+ _EndTime +"', '"+ _DeviceID +"', '"+ _EntryUser +"', '"+ _Lat +"', '"+ _Lon +"', '"+ _EnDt +"', '"+ _Upload +"', '"+ _modifyDate +"')";
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
                 SQL = "Update "+ TableName +" Set Upload='2',modifyDate='" + _modifyDate + "' ,CountryCode = '"+ _CountryCode +"',FaciCode = '"+ _FaciCode +"',DataID = '"+ _DataID +"',supcare = '"+ _supcare +"',banti = '"+ _banti +"',anti1 = '"+ _anti1 +"',anti2 = '"+ _anti2 +"',anti3 = '"+ _anti3 +"',anti4 = '"+ _anti4 +"',anti5 = '"+ _anti5 +"',anti6 = '"+ _anti6 +"',anti7 = '"+ _anti7 +"',anti8 = '"+ _anti8 +"',otherttmnt = '"+ _otherttmnt +"',otherttmntname = '"+ _otherttmntname +"',othtreat1 = '"+ _othtreat1 +"',othtreat2 = '"+ _othtreat2 +"',othtreat3 = '"+ _othtreat3 +"',othtreat4 = '"+ _othtreat4 +"',othtreat5 = '"+ _othtreat5 +"',othtreat6 = '"+ _othtreat6 +"',othtreat7 = '"+ _othtreat7 +"',othtreat8 = '"+ _othtreat8 +"',oxygen = '"+ _oxygen +"'  Where CountryCode='"+ _CountryCode +"' and FaciCode='"+ _FaciCode +"' and DataID='"+ _DataID +"'";
                 C.Save(SQL);
                 C.close();
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }


        public List<KMC_Treat_DataModel> SelectAll(Context context, String SQL)
        {
            Connection C = new Connection(context);
            List<KMC_Treat_DataModel> data = new ArrayList<KMC_Treat_DataModel>();
            KMC_Treat_DataModel d = new KMC_Treat_DataModel();
            Cursor cur = C.ReadData(SQL);

            cur.moveToFirst();
            while(!cur.isAfterLast())
            {
                d = new KMC_Treat_DataModel();
                d._CountryCode = cur.getString(cur.getColumnIndex("CountryCode"));
                d._FaciCode = cur.getString(cur.getColumnIndex("FaciCode"));
                d._DataID = cur.getString(cur.getColumnIndex("DataID"));
                d._supcare = cur.getString(cur.getColumnIndex("supcare"));
                d._banti = cur.getString(cur.getColumnIndex("banti"));
                d._anti1 = cur.getString(cur.getColumnIndex("anti1"));
                d._anti2 = cur.getString(cur.getColumnIndex("anti2"));
                d._anti3 = cur.getString(cur.getColumnIndex("anti3"));
                d._anti4 = cur.getString(cur.getColumnIndex("anti4"));
                d._anti5 = cur.getString(cur.getColumnIndex("anti5"));
                d._anti6 = cur.getString(cur.getColumnIndex("anti6"));
                d._anti7 = cur.getString(cur.getColumnIndex("anti7"));
                d._anti8 = cur.getString(cur.getColumnIndex("anti8"));
                d._otherttmnt = cur.getString(cur.getColumnIndex("otherttmnt"));
                d._otherttmntname = cur.getString(cur.getColumnIndex("otherttmntname"));
                d._othtreat1 = cur.getString(cur.getColumnIndex("othtreat1"));
                d._othtreat2 = cur.getString(cur.getColumnIndex("othtreat2"));
                d._othtreat3 = cur.getString(cur.getColumnIndex("othtreat3"));
                d._othtreat4 = cur.getString(cur.getColumnIndex("othtreat4"));
                d._othtreat5 = cur.getString(cur.getColumnIndex("othtreat5"));
                d._othtreat6 = cur.getString(cur.getColumnIndex("othtreat6"));
                d._othtreat7 = cur.getString(cur.getColumnIndex("othtreat7"));
                d._othtreat8 = cur.getString(cur.getColumnIndex("othtreat8"));
                d._oxygen = cur.getString(cur.getColumnIndex("oxygen"));
                data.add(d);

                cur.moveToNext();
            }
            cur.close();
          return data;
        }
 }