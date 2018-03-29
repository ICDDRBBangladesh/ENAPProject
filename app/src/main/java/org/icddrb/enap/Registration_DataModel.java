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
     private String _HospIDReTyp = "";
     public String getHospIDReTyp(){
         return _HospIDReTyp;
     }
     public void setHospIDReTyp(String newValue){
         _HospIDReTyp = newValue;
     }


        private String _Consent = "";
        public String getConsent(){
              return _Consent;
         }
        public void setConsent(String newValue){
              _Consent = newValue;
         }

     private String _ConReason = "";
     public String getConReason(){
         return _ConReason;
     }
     public void setConReason(String newValue){
         _ConReason = newValue;
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

     private String _MotDataID = "";
     public String getMotDataID(){
         return _MotDataID;
     }
     public void setMotDataID(String newValue){
         _MotDataID = newValue;
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


     private String _MotEdu = "";
     public String getMotEdu(){
         return _MotEdu;
     }
     public void setMotEdu(String newValue){
         _MotEdu = newValue;
     }
     private String _MotEduDK = "";
     public String getMotEduDK(){
         return _MotEduDK;
     }
     public void setMotEduDK(String newValue){
         _MotEduDK = newValue;
     }

     private String _Parity = "";
     public String getParity(){
         return _Parity;
     }
     public void setParity(String newValue){
         _Parity = newValue;
     }

        private String _MotEthnicity = "";
        public String getMotEthnicity(){
              return _MotEthnicity;
         }
        public void setMotEthnicity(String newValue){
              _MotEthnicity = newValue;
         }
     private String _MotEthnicityOth = "";
     public String getMotEthnicityOth(){
         return _MotEthnicityOth;
     }
     public void setMotEthnicityOth(String newValue){
         _MotEthnicityOth = newValue;
     }

        private String _MotReligion = "";
        public String getMotReligion(){
              return _MotReligion;
         }
        public void setMotReligion(String newValue){
              _MotReligion = newValue;
         }
     private String _MotReligionOth = "";
     public String getMotReligionOth(){
         return _MotReligionOth;
     }
     public void setMotReligionOth(String newValue){
         _MotReligionOth = newValue;
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

     private String _DOBNewbornDK = "";
     public String getDOBNewbornDK(){
         return _DOBNewbornDK;
     }
     public void setDOBNewbornDK(String newValue){
         _DOBNewbornDK = newValue;
     }


     private String _TOBNewborn = "";
     public String getTOBNewborn(){
         return _TOBNewborn;
     }
     public void setTOBNewborn(String newValue){
         _TOBNewborn = newValue;
     }

     private String _TOBNewbornDK = "";
     public String getTOBNewbornDK(){
         return _TOBNewbornDK;
     }
     public void setTOBNewbornDK(String newValue){
         _TOBNewbornDK = newValue;
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
                 SQL = "Insert into "+ TableName +" (CountryCode,FaciCode,RegisType,DataID,RegDate,RegTime,HospID,HospIDReTyp,Consent,ConReason,StudyID,MotRegis,MotDataID,MotStudyID,MotStudyIDReType,MotHospID,MotName,MotDOB,MotDOBDK,MotAge,MotEdu,MotEduDK,Parity,MotEthnicity,MotEthnicityOth,MotReligion,MotReligionOth,Address1,Address2,Address3,Address4,AddressDetail,MotContact,AltContact,NameNewBorn,DOBNewborn,DOBNewbornDK,TOBNewborn,TOBNewbornDK,AgeNewborn,AgeNewbornDMY,Sex,FatherName,CompleteAdd,StartTime,EndTime,DeviceID,EntryUser,Lat,Lon,EnDt,Upload)Values('"+ _CountryCode +"', '"+ _FaciCode +"', '"+ _RegisType +"', '"+ _DataID +"', '"+ _RegDate +"', '"+ _RegTime +"', '"+ _HospID +"','"+ _HospIDReTyp +"', '"+ _Consent +"','"+ _ConReason +"', '"+ _StudyID +"', '"+ _MotRegis +"','"+ _MotDataID +"', '"+ _MotStudyID +"','"+ _MotStudyIDReType +"', '"+ _MotHospID +"', '"+ _MotName +"', '"+ _MotDOB +"', '"+ _MotDOBDK +"', '"+ _MotAge +"','"+ _MotEdu +"','"+ _MotEduDK +"','"+ _Parity +"', '"+ _MotEthnicity +"','"+ _MotEthnicityOth +"', '"+ _MotReligion +"','"+ _MotReligionOth +"', '"+ _Address1 +"', '"+ _Address2 +"', '"+ _Address3 +"', '"+ _Address4 +"', '"+ _AddressDetail +"', '"+ _MotContact +"', '"+ _AltContact +"', '"+ _NameNewBorn +"', '"+ _DOBNewborn +"','"+ _DOBNewbornDK +"','"+ _TOBNewborn +"','"+ _TOBNewbornDK +"', '"+ _AgeNewborn +"', '"+ _AgeNewbornDMY +"','"+ _Sex +"','"+ _FatherName +"','"+ _CompleteAdd +"', '"+ _StartTime +"', '"+ _EndTime +"', '"+ _DeviceID +"', '"+ _EntryUser +"', '"+ _Lat +"', '"+ _Lon +"', '"+ _EnDt +"', '"+ _Upload +"')";
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
                 SQL = "Update "+ TableName +" Set Upload='2',modifyDate='"+ _modifyDate +"',CountryCode = '"+ _CountryCode +"',FaciCode = '"+ _FaciCode +"',RegisType = '"+ _RegisType +"',DataID = '"+ _DataID +"',RegDate = '"+ _RegDate +"',RegTime = '"+ _RegTime +"',HospID = '"+ _HospID +"',HospIDReTyp='"+ _HospIDReTyp +"',Consent = '"+ _Consent +"',ConReason='"+ _ConReason +"',StudyID = '"+ _StudyID +"',MotRegis = '"+ _MotRegis +"',MotDataID='"+ _MotDataID +"',MotStudyID = '"+ _MotStudyID +"',MotStudyIDReType='"+ _MotStudyIDReType +"',MotHospID = '"+ _MotHospID +"',MotName = '"+ _MotName +"',MotDOB = '"+ _MotDOB +"',MotDOBDK = '"+ _MotDOBDK +"',MotAge = '"+ _MotAge +"',MotEdu='"+ _MotEdu +"',MotEduDK='"+ _MotEduDK +"',Parity='"+ _Parity +"',MotEthnicity = '"+ _MotEthnicity +"',MotEthnicityOth = '"+ _MotEthnicityOth +"',MotReligion = '"+ _MotReligion +"',MotReligionOth = '"+ _MotReligionOth +"',Address1 = '"+ _Address1 +"',Address2 = '"+ _Address2 +"',Address3 = '"+ _Address3 +"',Address4 = '"+ _Address4 +"',AddressDetail = '"+ _AddressDetail +"',MotContact = '"+ _MotContact +"',AltContact = '"+ _AltContact +"',NameNewBorn = '"+ _NameNewBorn +"',DOBNewborn = '"+ _DOBNewborn +"',DOBNewbornDK='"+ _DOBNewbornDK +"',TOBNewborn='"+ _TOBNewborn +"',TOBNewbornDK='"+ _TOBNewbornDK +"',AgeNewborn = '"+ _AgeNewborn +"',AgeNewbornDMY = '"+ _AgeNewbornDMY +"',Sex='"+ _Sex +"',FatherName='"+ _FatherName +"',CompleteAdd='"+ _CompleteAdd +"'  Where CountryCode='"+ _CountryCode +"' and FaciCode='"+ _FaciCode +"' and DataID='"+ _DataID +"'";
                 response = C.SaveData(SQL);
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
                d._HospIDReTyp = cur.getString(cur.getColumnIndex("HospIDReTyp"));
                d._Consent = cur.getString(cur.getColumnIndex("Consent"));
                d._ConReason = cur.getString(cur.getColumnIndex("ConReason"));

                d._StudyID = cur.getString(cur.getColumnIndex("StudyID"));
                d._MotRegis = cur.getString(cur.getColumnIndex("MotRegis"));

                d._MotDataID = cur.getString(cur.getColumnIndex("MotDataID"));
                d._MotStudyID = cur.getString(cur.getColumnIndex("MotStudyID"));
                d._MotStudyIDReType = cur.getString(cur.getColumnIndex("MotStudyIDReType"));
                d._MotHospID = cur.getString(cur.getColumnIndex("MotHospID"));
                d._MotName = cur.getString(cur.getColumnIndex("MotName"));
                d._MotDOB = cur.getString(cur.getColumnIndex("MotDOB"));
                d._MotDOBDK = cur.getString(cur.getColumnIndex("MotDOBDK"));
                d._MotAge = cur.getString(cur.getColumnIndex("MotAge"));
                d._MotEdu = cur.getString(cur.getColumnIndex("MotEdu"));
                d._MotEduDK = cur.getString(cur.getColumnIndex("MotEduDK"));

                d._Parity = cur.getString(cur.getColumnIndex("Parity"));
                d._MotEthnicity = cur.getString(cur.getColumnIndex("MotEthnicity"));
                d._MotEthnicityOth = cur.getString(cur.getColumnIndex("MotEthnicityOth"));

                d._MotReligion = cur.getString(cur.getColumnIndex("MotReligion"));
                d._MotReligionOth = cur.getString(cur.getColumnIndex("MotReligionOth"));

                d._Address1 = cur.getString(cur.getColumnIndex("Address1"));
                d._Address2 = cur.getString(cur.getColumnIndex("Address2"));
                d._Address3 = cur.getString(cur.getColumnIndex("Address3"));
                d._Address4 = cur.getString(cur.getColumnIndex("Address4"));
                d._AddressDetail = cur.getString(cur.getColumnIndex("AddressDetail"));
                d._MotContact = cur.getString(cur.getColumnIndex("MotContact"));
                d._AltContact = cur.getString(cur.getColumnIndex("AltContact"));
                d._NameNewBorn = cur.getString(cur.getColumnIndex("NameNewBorn"));
                d._DOBNewborn = cur.getString(cur.getColumnIndex("DOBNewborn"));
                d._DOBNewbornDK = cur.getString(cur.getColumnIndex("DOBNewbornDK"));

                d._TOBNewborn = cur.getString(cur.getColumnIndex("TOBNewborn"));
                d._TOBNewbornDK = cur.getString(cur.getColumnIndex("TOBNewbornDK"));

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

     private String _gaadmi = "";
     public String getgaadmi(){
         return _gaadmi;
     }
     public void setgaadmi(String newValue){
         _gaadmi = newValue;
     }

     private String _gaadmiDK = "";
     public String getgaadmiDK(){
         return _gaadmiDK;
     }
     public void setgaadmiDK(String newValue){
         _gaadmiDK = newValue;
     }

     public List<Registration_DataModel> SelectAll_Mother(Context context, String SQL)
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
             d._MotEdu = cur.getString(cur.getColumnIndex("MotEdu"));
             d._MotEduDK = cur.getString(cur.getColumnIndex("MotEduDK"));

             d._MotEthnicity = cur.getString(cur.getColumnIndex("MotEthnicity"));
             d._MotEthnicityOth = cur.getString(cur.getColumnIndex("MotEthnicityOth"));

             d._MotReligion = cur.getString(cur.getColumnIndex("MotReligion"));
             d._MotReligionOth = cur.getString(cur.getColumnIndex("MotReligionOth"));

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
             d._gaadmi = cur.getString(cur.getColumnIndex("gaadmi"));
             d._gaadmiDK = cur.getString(cur.getColumnIndex("gaadmDK"));

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

     private String _RS = "";
     public String getRS(){
         return _RS;
     }
     public void setRS(String newValue){
         _RS = newValue;
     }

     private String _DE = "";
     public String getDE(){
         return _DE;
     }
     public void setDE(String newValue){
         _DE = newValue;
     }

     private String _ACSStatus = "";
     public String getACSStatus(){
         return _ACSStatus;
     }
     public void setACSStatus(String newValue){
         _ACSStatus = newValue;
     }

     private String _INFXNStatus = "";
     public String getINFXNStatus(){
         return _INFXNStatus;
     }
     public void setINFXNStatus(String newValue){
         _INFXNStatus = newValue;
     }

     private String _ACS = "";
     public String getACS(){
         return _ACS;
     }
     public void setACS(String newValue){
         _ACS = newValue;
     }

     //------------------------------------------------------------------------------------------
     private String _anybcompadmd = "";
     public String getanybcompadmd(){ return _anybcompadmd;}
     public void setanybcompadmd(String newValue){
         _anybcompadmd = newValue;
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
             d._RS = cur.getString(cur.getColumnIndex("RS"));
             d._DE = cur.getString(cur.getColumnIndex("DE"));
             d._ACSStatus = cur.getString(cur.getColumnIndex("ACSStatus"));
             d._INFXNStatus = cur.getString(cur.getColumnIndex("INFXNStatus"));

             d._ACS = cur.getString(cur.getColumnIndex("ACS"));

             d._anybcompadmd = cur.getString(cur.getColumnIndex("preterm"));

             data.add(d);

             cur.moveToNext();
         }
         cur.close();
         return data;
     }


     private String _ObserverName = "";
     public String getObserverName(){
         return _ObserverName;
     }
     private String _SelectPat = "";
     public String getSelectPat(){
         return _SelectPat;
     }

     private String _deldt = "";
     public String getdelDt(){
         return _deldt;
     }

     public List<Registration_DataModel> SelectAll_Assign(Context context, String SQL)
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
             d._MotEthnicityOth = cur.getString(cur.getColumnIndex("MotEthnicityOth"));

             d._MotReligion = cur.getString(cur.getColumnIndex("MotReligion"));
             d._MotReligionOth = cur.getString(cur.getColumnIndex("MotReligionOth"));

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

             d._ObserverName= cur.getString(cur.getColumnIndex("UserName"));
             d._SelectPat= cur.getString(cur.getColumnIndex("SelectPat"));

             d._deldt= cur.getString(cur.getColumnIndex("deldt"));
             data.add(d);

             cur.moveToNext();
         }
         cur.close();
         return data;
     }
 }