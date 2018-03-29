package org.icddrb.enap;

import android.content.Context;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;
 public class KmcPreObs_DataModel{

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
        private String _adwghedkmc = "";
        public String getadwghedkmc(){
              return _adwghedkmc;
         }
        public void setadwghedkmc(String newValue){
              _adwghedkmc = newValue;
         }
        private String _adwghtkmc = "";
        public String getadwghtkmc(){
              return _adwghtkmc;
         }
        public void setadwghtkmc(String newValue){
              _adwghtkmc = newValue;
         }
     private String _adwghtkmcdk = "";
     public String getadwghtkmcdk(){
         return _adwghtkmcdk;
     }
     public void setadwghtkmcdk(String newValue){
         _adwghtkmcdk = newValue;
     }

        private String _gaadm = "";
        public String getgaadm(){
              return _gaadm;
         }
        public void setgaadm(String newValue){
              _gaadm = newValue;
         }
     private String _gaadmdk = "";
     public String getgaadmdk(){
         return _gaadmdk;
     }
     public void setgaadmdk(String newValue){
         _gaadmdk = newValue;
     }

        private String _placedeliv = "";
        public String getplacedeliv(){
              return _placedeliv;
         }
        public void setplacedeliv(String newValue){
              _placedeliv = newValue;
         }
        private String _placedelivoth = "";
        public String getplacedelivoth(){
              return _placedelivoth;
         }
        public void setplacedelivoth(String newValue){
              _placedelivoth = newValue;
         }
        private String _facnamedeliv = "";
        public String getfacnamedeliv(){
              return _facnamedeliv;
         }
        public void setfacnamedeliv(String newValue){
              _facnamedeliv = newValue;
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

        String TableName = "KmcPreObs";

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
                 SQL = "Insert into "+ TableName +" (CountryCode,FaciCode,DataID,adwghedkmc,adwghtkmc,adwghtkmcdk,gaadm,gaadmdk,placedeliv,placedelivoth,facnamedeliv,StartTime,EndTime,DeviceID,EntryUser,Lat,Lon,EnDt,Upload,modifyDate)Values('"+ _CountryCode +"', '"+ _FaciCode +"', '"+ _DataID +"', '"+ _adwghedkmc +"', '"+ _adwghtkmc +"','"+ _adwghtkmcdk +"', '"+ _gaadm +"','"+ _gaadmdk +"', '"+ _placedeliv +"', '"+ _placedelivoth +"', '"+ _facnamedeliv +"', '"+ _StartTime +"', '"+ _EndTime +"', '"+ _DeviceID +"', '"+ _EntryUser +"', '"+ _Lat +"', '"+ _Lon +"', '"+ _EnDt +"', '"+ _Upload +"', '"+ _modifyDate +"')";
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
                 SQL = "Update "+ TableName +" Set Upload='2',modifyDate='" + _modifyDate + "' ,CountryCode = '"+ _CountryCode +"',FaciCode = '"+ _FaciCode +"',DataID = '"+ _DataID +"',adwghedkmc = '"+ _adwghedkmc +"',adwghtkmc = '"+ _adwghtkmc +"',adwghtkmcdk = '"+ _adwghtkmcdk +"',gaadm = '"+ _gaadm +"',gaadmdk = '"+ _gaadmdk +"',placedeliv = '"+ _placedeliv +"',placedelivoth = '"+ _placedelivoth +"',facnamedeliv = '"+ _facnamedeliv +"'  Where CountryCode='"+ _CountryCode +"' and FaciCode='"+ _FaciCode +"' and DataID='"+ _DataID +"'";
                 response = C.SaveData(SQL);
                 C.close();
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }


        public List<KmcPreObs_DataModel> SelectAll(Context context, String SQL)
        {
            Connection C = new Connection(context);
            List<KmcPreObs_DataModel> data = new ArrayList<KmcPreObs_DataModel>();
            KmcPreObs_DataModel d = new KmcPreObs_DataModel();
            Cursor cur = C.ReadData(SQL);

            cur.moveToFirst();
            while(!cur.isAfterLast())
            {
                d = new KmcPreObs_DataModel();
                d._CountryCode = cur.getString(cur.getColumnIndex("CountryCode"));
                d._FaciCode = cur.getString(cur.getColumnIndex("FaciCode"));
                d._DataID = cur.getString(cur.getColumnIndex("DataID"));
                d._adwghedkmc = cur.getString(cur.getColumnIndex("adwghedkmc"));
                d._adwghtkmc = cur.getString(cur.getColumnIndex("adwghtkmc"));
                d._adwghtkmcdk = cur.getString(cur.getColumnIndex("adwghtkmcDK"));

                d._gaadm = cur.getString(cur.getColumnIndex("gaadm"));
                d._gaadmdk = cur.getString(cur.getColumnIndex("gaadmDK"));

                d._placedeliv = cur.getString(cur.getColumnIndex("placedeliv"));
                d._placedelivoth = cur.getString(cur.getColumnIndex("placedelivoth"));
                d._facnamedeliv = cur.getString(cur.getColumnIndex("facnamedeliv"));
                data.add(d);

                cur.moveToNext();
            }
            cur.close();
          return data;
        }
 }