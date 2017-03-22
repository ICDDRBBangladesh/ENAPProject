package org.icddrb.enap;

import android.content.Context;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;
 public class Registration_DataModel{

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
        private String _RegisType = "";
        public String getRegisType(){
              return _RegisType;
         }
        public void setRegisType(String newValue){
              _RegisType = newValue;
         }
        private String _DataID = "";
        public String getDataID(){
              return _DataID;
         }
        public void setDataID(String newValue){
              _DataID = newValue;
         }
        private String _RegDate = "";
        public String getRegDate(){
              return _RegDate;
         }
        public void setRegDate(String newValue){
              _RegDate = newValue;
         }
        private String _RegTime = "";
        public String getRegTime(){
              return _RegTime;
         }
        public void setRegTime(String newValue){
              _RegTime = newValue;
         }
        private String _HospID = "";
        public String getHospID(){
              return _HospID;
         }
        public void setHospID(String newValue){
              _HospID = newValue;
         }
        private String _Consent = "";
        public String getConsent(){
              return _Consent;
         }
        public void setConsent(String newValue){
              _Consent = newValue;
         }
        private String _StudyID = "";
        public String getStudyID(){
              return _StudyID;
         }
        public void setStudyID(String newValue){
              _StudyID = newValue;
         }
        private String _MotRegis = "";
        public String getMotRegis(){
              return _MotRegis;
         }
        public void setMotRegis(String newValue){
              _MotRegis = newValue;
         }
        private String _MotStudyID = "";
        public String getMotStudyID(){
              return _MotStudyID;
         }
        public void setMotStudyID(String newValue){
              _MotStudyID = newValue;
         }

         private String _MotStudyIDReType = "";
         public String getMotStudyIDReType(){
             return _MotStudyIDReType;
         }
         public void setMotStudyIDReType(String newValue){
             _MotStudyIDReType = newValue;
         }


        private String _MotHospID = "";
        public String getMotHospID(){
              return _MotHospID;
         }
        public void setMotHospID(String newValue){
              _MotHospID = newValue;
         }
        private String _MotName = "";
        public String getMotName(){
              return _MotName;
         }
        public void setMotName(String newValue){
              _MotName = newValue;
         }
        private String _MotDOB = "";
        public String getMotDOB(){
              return _MotDOB;
         }
        public void setMotDOB(String newValue){
              _MotDOB = newValue;
         }
        private String _MotDOBDK = "";
        public String getMotDOBDK(){
              return _MotDOBDK;
         }
        public void setMotDOBDK(String newValue){
              _MotDOBDK = newValue;
         }
        private String _MotAge = "";
        public String getMotAge(){
              return _MotAge;
         }
        public void setMotAge(String newValue){
              _MotAge = newValue;
         }
        private String _MotEthnicity = "";
        public String getMotEthnicity(){
              return _MotEthnicity;
         }
        public void setMotEthnicity(String newValue){
              _MotEthnicity = newValue;
         }
        private String _MotReligion = "";
        public String getMotReligion(){
              return _MotReligion;
         }
        public void setMotReligion(String newValue){
              _MotReligion = newValue;
         }
        private String _Address1 = "";
        public String getAddress1(){
              return _Address1;
         }
        public void setAddress1(String newValue){
              _Address1 = newValue;
         }
        private String _Address2 = "";
        public String getAddress2(){
              return _Address2;
         }
        public void setAddress2(String newValue){
              _Address2 = newValue;
         }
        private String _Address3 = "";
        public String getAddress3(){
              return _Address3;
         }
        public void setAddress3(String newValue){
              _Address3 = newValue;
         }
        private String _Address4 = "";
        public String getAddress4(){
              return _Address4;
         }
        public void setAddress4(String newValue){
              _Address4 = newValue;
         }
        private String _AddressDetail = "";
        public String getAddressDetail(){
              return _AddressDetail;
         }
        public void setAddressDetail(String newValue){
              _AddressDetail = newValue;
         }
        private String _MotContact = "";
        public String getMotContact(){
              return _MotContact;
         }
        public void setMotContact(String newValue){
              _MotContact = newValue;
         }
        private String _AltContact = "";
        public String getAltContact(){
              return _AltContact;
         }
        public void setAltContact(String newValue){
              _AltContact = newValue;
         }
        private String _NameNewBorn = "";
        public String getNameNewBorn(){
              return _NameNewBorn;
         }
        public void setNameNewBorn(String newValue){
              _NameNewBorn = newValue;
         }
        private String _DOBNewborn = "";
        public String getDOBNewborn(){
              return _DOBNewborn;
         }
        public void setDOBNewborn(String newValue){
              _DOBNewborn = newValue;
         }
        private String _AgeNewborn = "";
        public String getAgeNewborn(){
              return _AgeNewborn;
         }
        public void setAgeNewborn(String newValue){
              _AgeNewborn = newValue;
         }

        private String _AgeNewbornDMY = "";
        public String getAgeNewbornDMY(){
              return _AgeNewbornDMY;
         }
        public void setAgeNewbornDMY(String newValue){
              _AgeNewbornDMY = newValue;
         }


     private String _Sex = "";
     public String getSex(){
         return _Sex;
     }
     public void setSex(String newValue){
         _Sex = newValue;
     }


     private String _FatherName = "";
     public String getFatherName(){
         return _FatherName;
     }
     public void setFatherName(String newValue){
         _FatherName = newValue;
     }

     private String _CompleteAdd = "";
     public String getCompleteAdd(){
         return _CompleteAdd;
     }
     public void setCompleteAdd(String newValue){
         _CompleteAdd = newValue;
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

        String TableName = "Registration";

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
                 SQL = "Insert into "+ TableName +" (CountryCode,FaciCode,RegisType,DataID,RegDate,RegTime,HospID,Consent,StudyID,MotRegis,MotStudyID,MotStudyIDReType,MotHospID,MotName,MotDOB,MotDOBDK,MotAge,MotEthnicity,MotReligion,Address1,Address2,Address3,Address4,AddressDetail,MotContact,AltContact,NameNewBorn,DOBNewborn,AgeNewborn,AgeNewbornDMY,Sex,FatherName,CompleteAdd,StartTime,EndTime,DeviceID,EntryUser,Lat,Lon,EnDt,Upload)Values('"+ _CountryCode +"', '"+ _FaciCode +"', '"+ _RegisType +"', '"+ _DataID +"', '"+ _RegDate +"', '"+ _RegTime +"', '"+ _HospID +"', '"+ _Consent +"', '"+ _StudyID +"', '"+ _MotRegis +"', '"+ _MotStudyID +"','"+ _MotStudyIDReType +"', '"+ _MotHospID +"', '"+ _MotName +"', '"+ _MotDOB +"', '"+ _MotDOBDK +"', '"+ _MotAge +"', '"+ _MotEthnicity +"', '"+ _MotReligion +"', '"+ _Address1 +"', '"+ _Address2 +"', '"+ _Address3 +"', '"+ _Address4 +"', '"+ _AddressDetail +"', '"+ _MotContact +"', '"+ _AltContact +"', '"+ _NameNewBorn +"', '"+ _DOBNewborn +"', '"+ _AgeNewborn +"', '"+ _AgeNewbornDMY +"','"+ _Sex +"','"+ _FatherName +"','"+ _CompleteAdd +"', '"+ _StartTime +"', '"+ _EndTime +"', '"+ _DeviceID +"', '"+ _EntryUser +"', '"+ _Lat +"', '"+ _Lon +"', '"+ _EnDt +"', '"+ _Upload +"')";
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
                 SQL = "Update "+ TableName +" Set Upload='2',modifyDate='"+ _modifyDate +"',CountryCode = '"+ _CountryCode +"',FaciCode = '"+ _FaciCode +"',RegisType = '"+ _RegisType +"',DataID = '"+ _DataID +"',RegDate = '"+ _RegDate +"',RegTime = '"+ _RegTime +"',HospID = '"+ _HospID +"',Consent = '"+ _Consent +"',StudyID = '"+ _StudyID +"',MotRegis = '"+ _MotRegis +"',MotStudyID = '"+ _MotStudyID +"',MotStudyIDReType='"+ _MotStudyIDReType +"',MotHospID = '"+ _MotHospID +"',MotName = '"+ _MotName +"',MotDOB = '"+ _MotDOB +"',MotDOBDK = '"+ _MotDOBDK +"',MotAge = '"+ _MotAge +"',MotEthnicity = '"+ _MotEthnicity +"',MotReligion = '"+ _MotReligion +"',Address1 = '"+ _Address1 +"',Address2 = '"+ _Address2 +"',Address3 = '"+ _Address3 +"',Address4 = '"+ _Address4 +"',AddressDetail = '"+ _AddressDetail +"',MotContact = '"+ _MotContact +"',AltContact = '"+ _AltContact +"',NameNewBorn = '"+ _NameNewBorn +"',DOBNewborn = '"+ _DOBNewborn +"',AgeNewborn = '"+ _AgeNewborn +"',AgeNewbornDMY = '"+ _AgeNewbornDMY +"',Sex='"+ _Sex +"',FatherName='"+ _FatherName +"',CompleteAdd='"+ _CompleteAdd +"'  Where CountryCode='"+ _CountryCode +"' and FaciCode='"+ _FaciCode +"' and DataID='"+ _DataID +"'";
                 C.Save(SQL);
                 C.close();
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }


        public List<Registration_DataModel> SelectAll(Context context, String SQL)
        {
            Connection C = new Connection(context);
            List<Registration_DataModel> data = new ArrayList<Registration_DataModel>();
            Registration_DataModel d = new Registration_DataModel();
            Cursor cur = C.ReadData(SQL);

            cur.moveToFirst();
            while(!cur.isAfterLast())
            {
                d = new Registration_DataModel();
                d._CountryCode = cur.getString(cur.getColumnIndex("CountryCode"));
                d._FaciCode = cur.getString(cur.getColumnIndex("FaciCode"));
                d._RegisType = cur.getString(cur.getColumnIndex("RegisType"));
                d._DataID = cur.getString(cur.getColumnIndex("DataID"));
                d._RegDate = cur.getString(cur.getColumnIndex("RegDate"));
                d._RegTime = cur.getString(cur.getColumnIndex("RegTime"));
                d._HospID = cur.getString(cur.getColumnIndex("HospID"));
                d._Consent = cur.getString(cur.getColumnIndex("Consent"));
                d._StudyID = cur.getString(cur.getColumnIndex("StudyID"));
                d._MotRegis = cur.getString(cur.getColumnIndex("MotRegis"));
                d._MotStudyID = cur.getString(cur.getColumnIndex("MotStudyID"));
                d._MotStudyIDReType = cur.getString(cur.getColumnIndex("MotStudyIDReType"));
                d._MotHospID = cur.getString(cur.getColumnIndex("MotHospID"));
                d._MotName = cur.getString(cur.getColumnIndex("MotName"));
                d._MotDOB = cur.getString(cur.getColumnIndex("MotDOB"));
                d._MotDOBDK = cur.getString(cur.getColumnIndex("MotDOBDK"));
                d._MotAge = cur.getString(cur.getColumnIndex("MotAge"));
                d._MotEthnicity = cur.getString(cur.getColumnIndex("MotEthnicity"));
                d._MotReligion = cur.getString(cur.getColumnIndex("MotReligion"));
                d._Address1 = cur.getString(cur.getColumnIndex("Address1"));
                d._Address2 = cur.getString(cur.getColumnIndex("Address2"));
                d._Address3 = cur.getString(cur.getColumnIndex("Address3"));
                d._Address4 = cur.getString(cur.getColumnIndex("Address4"));
                d._AddressDetail = cur.getString(cur.getColumnIndex("AddressDetail"));
                d._MotContact = cur.getString(cur.getColumnIndex("MotContact"));
                d._AltContact = cur.getString(cur.getColumnIndex("AltContact"));
                d._NameNewBorn = cur.getString(cur.getColumnIndex("NameNewBorn"));
                d._DOBNewborn = cur.getString(cur.getColumnIndex("DOBNewborn"));
                d._AgeNewborn = cur.getString(cur.getColumnIndex("AgeNewborn"));
                d._AgeNewbornDMY = cur.getString(cur.getColumnIndex("AgeNewbornDMY"));
                d._Sex = cur.getString(cur.getColumnIndex("Sex"));
                d._FatherName = cur.getString(cur.getColumnIndex("FatherName"));
                d._CompleteAdd = cur.getString(cur.getColumnIndex("CompleteAdd"));
                data.add(d);

                cur.moveToNext();
            }
            cur.close();
          return data;
        }


     private String _Observe = "";
     public String getObserve(){
         return _Observe;
     }
     public void setObserve(String newValue){
         _Observe = newValue;
     }
     public List<Registration_DataModel> SelectPatientList(Context context, String SQL)
     {
         Connection C = new Connection(context);
         List<Registration_DataModel> data = new ArrayList<Registration_DataModel>();
         Registration_DataModel d = new Registration_DataModel();
         Cursor cur = C.ReadData(SQL);

         cur.moveToFirst();
         while(!cur.isAfterLast())
         {
             d = new Registration_DataModel();
             d._CountryCode = cur.getString(cur.getColumnIndex("CountryCode"));
             d._FaciCode = cur.getString(cur.getColumnIndex("FaciCode"));
             d._RegisType = cur.getString(cur.getColumnIndex("RegisType"));
             d._DataID = cur.getString(cur.getColumnIndex("DataID"));
             d._RegDate = cur.getString(cur.getColumnIndex("RegDate"));
             d._RegTime = cur.getString(cur.getColumnIndex("RegTime"));
             d._HospID = cur.getString(cur.getColumnIndex("HospID"));
             d._Consent = cur.getString(cur.getColumnIndex("Consent"));
             d._StudyID = cur.getString(cur.getColumnIndex("StudyID"));
             d._MotRegis = cur.getString(cur.getColumnIndex("MotRegis"));
             d._MotStudyID = cur.getString(cur.getColumnIndex("MotStudyID"));
             d._MotStudyIDReType = cur.getString(cur.getColumnIndex("MotStudyIDReType"));
             d._MotHospID = cur.getString(cur.getColumnIndex("MotHospID"));
             d._MotName = cur.getString(cur.getColumnIndex("MotName"));
             d._MotDOB = cur.getString(cur.getColumnIndex("MotDOB"));
             d._MotDOBDK = cur.getString(cur.getColumnIndex("MotDOBDK"));
             d._MotAge = cur.getString(cur.getColumnIndex("MotAge"));
             d._MotEthnicity = cur.getString(cur.getColumnIndex("MotEthnicity"));
             d._MotReligion = cur.getString(cur.getColumnIndex("MotReligion"));
             d._Address1 = cur.getString(cur.getColumnIndex("Address1"));
             d._Address2 = cur.getString(cur.getColumnIndex("Address2"));
             d._Address3 = cur.getString(cur.getColumnIndex("Address3"));
             d._Address4 = cur.getString(cur.getColumnIndex("Address4"));
             d._AddressDetail = cur.getString(cur.getColumnIndex("AddressDetail"));
             d._MotContact = cur.getString(cur.getColumnIndex("MotContact"));
             d._AltContact = cur.getString(cur.getColumnIndex("AltContact"));
             d._NameNewBorn = cur.getString(cur.getColumnIndex("NameNewBorn"));
             d._DOBNewborn = cur.getString(cur.getColumnIndex("DOBNewborn"));
             d._AgeNewborn = cur.getString(cur.getColumnIndex("AgeNewborn"));
             d._AgeNewbornDMY = cur.getString(cur.getColumnIndex("AgeNewbornDMY"));
             d._Sex = cur.getString(cur.getColumnIndex("Sex"));
             d._FatherName = cur.getString(cur.getColumnIndex("FatherName"));
             d._CompleteAdd = cur.getString(cur.getColumnIndex("CompleteAdd"));
             d._Observe = cur.getString(cur.getColumnIndex("Observe"));

             data.add(d);

             cur.moveToNext();
         }
         cur.close();
         return data;
     }
 }