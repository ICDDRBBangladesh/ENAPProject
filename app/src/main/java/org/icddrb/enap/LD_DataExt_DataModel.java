package org.icddrb.enap;

import android.content.Context;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;
 public class LD_DataExt_DataModel{

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
        private String _refdoe = "";
        public String getrefdoe(){
              return _refdoe;
         }
        public void setrefdoe(String newValue){
              _refdoe = newValue;
         }
        private String _refgald = "";
        public String getrefgald(){
              return _refgald;
         }
        public void setrefgald(String newValue){
              _refgald = newValue;
         }
        private String _refgaldnot = "";
        public String getrefgaldnot(){
              return _refgaldnot;
         }
        public void setrefgaldnot(String newValue){
              _refgaldnot = newValue;
         }
        private String _refacsgiven = "";
        public String getrefacsgiven(){
              return _refacsgiven;
         }
        public void setrefacsgiven(String newValue){
              _refacsgiven = newValue;
         }
        private String _refgacalc = "";
        public String getrefgacalc(){
              return _refgacalc;
         }
        public void setrefgacalc(String newValue){
              _refgacalc = newValue;
         }
        private String _refgacalcnot = "";
        public String getrefgacalcnot(){
              return _refgacalcnot;
         }
        public void setrefgacalcnot(String newValue){
              _refgacalcnot = newValue;
         }
        private String _refmedadeliv = "";
        public String getrefmedadeliv(){
              return _refmedadeliv;
         }
        public void setrefmedadeliv(String newValue){
              _refmedadeliv = newValue;
         }
        private String _numofbirth = "";
        public String getnumofbirth(){
              return _numofbirth;
         }
        public void setnumofbirth(String newValue){
              _numofbirth = newValue;
         }
        private String _reftypebirth1 = "";
        public String getreftypebirth1(){
              return _reftypebirth1;
         }
        public void setreftypebirth1(String newValue){
              _reftypebirth1 = newValue;
         }

        private String _refdelivdate1 = "";
        public String getrefdelivdate1(){
              return _refdelivdate1;
         }
        public void setrefdelivdate1(String newValue){
              _refdelivdate1 = newValue;
         }

         private String _refdelivdate1not = "";
     public String getrefdelivdate1not(){
         return _refdelivdate1not;
     }
     public void setrefdelivdate1not(String newValue){
         _refdelivdate1not = newValue;
     }


        private String _refdelivtime1 = "";
        public String getrefdelivtime1(){
              return _refdelivtime1;
         }
        public void setrefdelivtime1(String newValue){
              _refdelivtime1 = newValue;
         }
     private String _refdelivtime1not = "";
     public String getrefdelivtime1not(){
         return _refdelivtime1not;
     }
     public void setrefdelivtime1not(String newValue){
         _refdelivtime1not = newValue;
     }

        private String _refbStatus1 = "";
        public String getrefbStatus1(){
              return _refbStatus1;
         }
        public void setrefbStatus1(String newValue){
              _refbStatus1 = newValue;
         }
        private String _Refsbtype1 = "";
        public String getRefsbtype1(){
              return _Refsbtype1;
         }
        public void setRefsbtype1(String newValue){
              _Refsbtype1 = newValue;
         }
        private String _refbsex1 = "";
        public String getrefbsex1(){
              return _refbsex1;
         }
        public void setrefbsex1(String newValue){
              _refbsex1 = newValue;
         }
        private String _refbwgt1 = "";
        public String getrefbwgt1(){
              return _refbwgt1;
         }
        public void setrefbwgt1(String newValue){
              _refbwgt1 = newValue;
         }
        private String _refbwgtnot1 = "";
        public String getrefbwgtnot1(){
              return _refbwgtnot1;
         }
        public void setrefbwgtnot1(String newValue){
              _refbwgtnot1 = newValue;
         }
        private String _refbstim1 = "";
        public String getrefbstim1(){
              return _refbstim1;
         }
        public void setrefbstim1(String newValue){
              _refbstim1 = newValue;
         }
        private String _refbplast1 = "";
        public String getrefbplast1(){
              return _refbplast1;
         }
        public void setrefbplast1(String newValue){
              _refbplast1 = newValue;
         }
        private String _refappcord1 = "";
        public String getrefappcord1(){
              return _refappcord1;
         }
        public void setrefappcord1(String newValue){
              _refappcord1 = newValue;
         }
        private String _refbbfd1 = "";
        public String getrefbbfd1(){
              return _refbbfd1;
         }
        public void setrefbbfd1(String newValue){
              _refbbfd1 = newValue;
         }
        private String _refbcond1 = "";
        public String getrefbcond1(){
              return _refbcond1;
         }
        public void setrefbcond1(String newValue){
              _refbcond1 = newValue;
         }
        private String _refdisoutld1 = "";
        public String getrefdisoutld1(){
              return _refdisoutld1;
         }
        public void setrefdisoutld1(String newValue){
              _refdisoutld1 = newValue;
         }
        private String _refTransPlace1 = "";
        public String getrefTransPlace1(){
              return _refTransPlace1;
         }
        public void setrefTransPlace1(String newValue){
              _refTransPlace1 = newValue;
         }
        private String _reftypebirth2 = "";
        public String getreftypebirth2(){
              return _reftypebirth2;
         }
        public void setreftypebirth2(String newValue){
              _reftypebirth2 = newValue;
         }

         private String _refdelivdate2 = "";
        public String getrefdelivdate2(){
              return _refdelivdate2;
         }
        public void setrefdelivdate2(String newValue){
              _refdelivdate2 = newValue;
         }

     private String _refdelivdate2not = "";
     public String getrefdelivdate2not(){
         return _refdelivdate2not;
     }
     public void setrefdelivdate2not(String newValue){
         _refdelivdate2not = newValue;
     }



        private String _refdelivtime2 = "";
        public String getrefdelivtime2(){
              return _refdelivtime2;
         }
        public void setrefdelivtime2(String newValue){
              _refdelivtime2 = newValue;
         }

     private String _refdelivtime2not = "";
     public String getrefdelivtime2not(){
         return _refdelivtime2not;
     }
     public void setrefdelivtime2not(String newValue){
         _refdelivtime2not = newValue;
     }



     private String _refbStatus2 = "";
        public String getrefbStatus2(){
              return _refbStatus2;
         }
        public void setrefbStatus2(String newValue){
              _refbStatus2 = newValue;
         }
        private String _Refsbtype2 = "";
        public String getRefsbtype2(){
              return _Refsbtype2;
         }
        public void setRefsbtype2(String newValue){
              _Refsbtype2 = newValue;
         }
        private String _refbsex2 = "";
        public String getrefbsex2(){
              return _refbsex2;
         }
        public void setrefbsex2(String newValue){
              _refbsex2 = newValue;
         }
        private String _refbwgt2 = "";
        public String getrefbwgt2(){
              return _refbwgt2;
         }
        public void setrefbwgt2(String newValue){
              _refbwgt2 = newValue;
         }
        private String _refbwgtnot2 = "";
        public String getrefbwgtnot2(){
              return _refbwgtnot2;
         }
        public void setrefbwgtnot2(String newValue){
              _refbwgtnot2 = newValue;
         }
        private String _refbstim2 = "";
        public String getrefbstim2(){
              return _refbstim2;
         }
        public void setrefbstim2(String newValue){
              _refbstim2 = newValue;
         }
        private String _refbplast2 = "";
        public String getrefbplast2(){
              return _refbplast2;
         }
        public void setrefbplast2(String newValue){
              _refbplast2 = newValue;
         }
        private String _refappcord2 = "";
        public String getrefappcord2(){
              return _refappcord2;
         }
        public void setrefappcord2(String newValue){
              _refappcord2 = newValue;
         }
        private String _refbbfd2 = "";
        public String getrefbbfd2(){
              return _refbbfd2;
         }
        public void setrefbbfd2(String newValue){
              _refbbfd2 = newValue;
         }
        private String _refbcond2 = "";
        public String getrefbcond2(){
              return _refbcond2;
         }
        public void setrefbcond2(String newValue){
              _refbcond2 = newValue;
         }
        private String _refdisoutld2 = "";
        public String getrefdisoutld2(){
              return _refdisoutld2;
         }
        public void setrefdisoutld2(String newValue){
              _refdisoutld2 = newValue;
         }
        private String _refTransPlace2 = "";
        public String getrefTransPlace2(){
              return _refTransPlace2;
         }
        public void setrefTransPlace2(String newValue){
              _refTransPlace2 = newValue;
         }
        private String _reftypebirth3 = "";
        public String getreftypebirth3(){
              return _reftypebirth3;
         }
        public void setreftypebirth3(String newValue){
              _reftypebirth3 = newValue;
         }

        private String _refdelivdate3 = "";
        public String getrefdelivdate3(){
              return _refdelivdate3;
         }
        public void setrefdelivdate3(String newValue){
              _refdelivdate3 = newValue;
         }
     private String _refdelivdate3not = "";
     public String getrefdelivdate3not(){
         return _refdelivdate3not;
     }
     public void setrefdelivdate3not(String newValue){
         _refdelivdate3not = newValue;
     }

        private String _refdelivtime3 = "";
        public String getrefdelivtime3(){
              return _refdelivtime3;
         }
        public void setrefdelivtime3(String newValue){
              _refdelivtime3 = newValue;
         }
     private String _refdelivtime3not = "";
     public String getrefdelivtime3not(){
         return _refdelivtime3not;
     }
     public void setrefdelivtime3not(String newValue){
         _refdelivtime3not = newValue;
     }

        private String _refbStatus3 = "";
        public String getrefbStatus3(){
              return _refbStatus3;
         }
        public void setrefbStatus3(String newValue){
              _refbStatus3 = newValue;
         }
        private String _Refsbtype3 = "";
        public String getRefsbtype3(){
              return _Refsbtype3;
         }
        public void setRefsbtype3(String newValue){
              _Refsbtype3 = newValue;
         }
        private String _refbsex3 = "";
        public String getrefbsex3(){
              return _refbsex3;
         }
        public void setrefbsex3(String newValue){
              _refbsex3 = newValue;
         }
        private String _refbwgt3 = "";
        public String getrefbwgt3(){
              return _refbwgt3;
         }
        public void setrefbwgt3(String newValue){
              _refbwgt3 = newValue;
         }
        private String _refbwgtnot3 = "";
        public String getrefbwgtnot3(){
              return _refbwgtnot3;
         }
        public void setrefbwgtnot3(String newValue){
              _refbwgtnot3 = newValue;
         }
        private String _refbstim3 = "";
        public String getrefbstim3(){
              return _refbstim3;
         }
        public void setrefbstim3(String newValue){
              _refbstim3 = newValue;
         }
        private String _refbplast3 = "";
        public String getrefbplast3(){
              return _refbplast3;
         }
        public void setrefbplast3(String newValue){
              _refbplast3 = newValue;
         }
        private String _refappcord3 = "";
        public String getrefappcord3(){
              return _refappcord3;
         }
        public void setrefappcord3(String newValue){
              _refappcord3 = newValue;
         }
        private String _refbbfd3 = "";
        public String getrefbbfd3(){
              return _refbbfd3;
         }
        public void setrefbbfd3(String newValue){
              _refbbfd3 = newValue;
         }
        private String _refbcond3 = "";
        public String getrefbcond3(){
              return _refbcond3;
         }
        public void setrefbcond3(String newValue){
              _refbcond3 = newValue;
         }
        private String _refdisoutld3 = "";
        public String getrefdisoutld3(){
              return _refdisoutld3;
         }
        public void setrefdisoutld3(String newValue){
              _refdisoutld3 = newValue;
         }
        private String _refTransPlace3 = "";
        public String getrefTransPlace3(){
              return _refTransPlace3;
         }
        public void setrefTransPlace3(String newValue){
              _refTransPlace3 = newValue;
         }
        private String _refpph = "";
        public String getrefpph(){
              return _refpph;
         }
        public void setrefpph(String newValue){
              _refpph = newValue;
         }
        private String _refpphnot = "";
        public String getrefpphnot(){
              return _refpphnot;
         }
        public void setrefpphnot(String newValue){
              _refpphnot = newValue;
         }
        private String _refretainplac = "";
        public String getrefretainplac(){
              return _refretainplac;
         }
        public void setrefretainplac(String newValue){
              _refretainplac = newValue;
         }
        private String _refdodld = "";
        public String getrefdodld(){
              return _refdodld;
         }
        public void setrefdodld(String newValue){
              _refdodld = newValue;
         }
     private String _refdodldnot = "";
     public String getrefdodldnot(){
         return _refdodldnot;
     }
     public void setrefdodldnot(String newValue){
         _refdodldnot = newValue;
     }


     private String _reftodld = "";
        public String getreftodld(){
              return _reftodld;
         }
        public void setreftodld(String newValue){
              _reftodld = newValue;
         }
     private String _reftodldnot = "";
     public String getreftodldnot(){
         return _reftodldnot;
     }
     public void setreftodldnot(String newValue){
         _reftodldnot = newValue;
     }


     private String _refmatcond = "";
        public String getrefmatcond(){
              return _refmatcond;
         }
        public void setrefmatcond(String newValue){
              _refmatcond = newValue;
         }
        private String _refTransPlaceM = "";
        public String getrefTransPlaceM(){
              return _refTransPlaceM;
         }
        public void setrefTransPlaceM(String newValue){
              _refTransPlaceM = newValue;
         }

     private String _status = "";
     public String getStatus(){
         return _status;
     }
     public void setStatus(String newValue){
         _status = newValue;
     }

     private String _reason = "";
     public String getReason(){
         return _reason;
     }
     public void setReason(String newValue){
         _reason = newValue;
     }

     private String _reasmention = "";
     public String getReasmention(){
         return _reasmention;
     }
     public void setReasmention(String newValue){
         _reasmention = newValue;
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

        String TableName = "LD_DataExt";

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
                 SQL = "Insert into "+ TableName +" (CountryCode,FaciCode,DataID,refdoe,refgald,refgaldnot,refacsgiven,refgacalc,refgacalcnot,refmedadeliv,numofbirth,reftypebirth1,refdelivdate1,refdelivdate1not,refdelivtime1,refdelivtime1not,refbStatus1,Refsbtype1,refbsex1,refbwgt1,refbwgtnot1,refbstim1,refbplast1,refappcord1,refbbfd1,refbcond1,refdisoutld1,refTransPlace1,reftypebirth2,refdelivdate2,refdelivdate2not,refdelivtime2,refdelivtime2not,refbStatus2,Refsbtype2,refbsex2,refbwgt2,refbwgtnot2,refbstim2,refbplast2,refappcord2,refbbfd2,refbcond2,refdisoutld2,refTransPlace2,reftypebirth3,refdelivdate3,refdelivdate3not,refdelivtime3,refdelivtime3not,refbStatus3,Refsbtype3,refbsex3,refbwgt3,refbwgtnot3,refbstim3,refbplast3,refappcord3,refbbfd3,refbcond3,refdisoutld3,refTransPlace3,refpph,refpphnot,refretainplac,refdodld,refdodldnot,reftodld,reftodldnot,refmatcond,refTransPlaceM,status,reason,reasmention,StartTime,EndTime,DeviceID,EntryUser,Lat,Lon,EnDt,Upload,modifyDate)Values('"+ _CountryCode +"', '"+ _FaciCode +"', '"+ _DataID +"', '"+ _refdoe +"', '"+ _refgald +"', '"+ _refgaldnot +"', '"+ _refacsgiven +"', '"+ _refgacalc +"', '"+ _refgacalcnot +"', '"+ _refmedadeliv +"', '"+ _numofbirth +"', '"+ _reftypebirth1 +"', '"+ _refdelivdate1 +"','"+ _refdelivdate1not +"', '"+ _refdelivtime1 +"','"+ _refdelivtime1not +"', '"+ _refbStatus1 +"', '"+ _Refsbtype1 +"', '"+ _refbsex1 +"', '"+ _refbwgt1 +"', '"+ _refbwgtnot1 +"', '"+ _refbstim1 +"', '"+ _refbplast1 +"', '"+ _refappcord1 +"', '"+ _refbbfd1 +"', '"+ _refbcond1 +"', '"+ _refdisoutld1 +"', '"+ _refTransPlace1 +"', '"+ _reftypebirth2 +"', '"+ _refdelivdate2 +"','"+ _refdelivdate2not +"', '"+ _refdelivtime2 +"','"+ _refdelivtime2not +"', '"+ _refbStatus2 +"', '"+ _Refsbtype2 +"', '"+ _refbsex2 +"', '"+ _refbwgt2 +"', '"+ _refbwgtnot2 +"', '"+ _refbstim2 +"', '"+ _refbplast2 +"', '"+ _refappcord2 +"', '"+ _refbbfd2 +"', '"+ _refbcond2 +"', '"+ _refdisoutld2 +"', '"+ _refTransPlace2 +"', '"+ _reftypebirth3 +"', '"+ _refdelivdate3 +"','"+ _refdelivdate3not +"', '"+ _refdelivtime3 +"','"+ _refdelivtime3not +"', '"+ _refbStatus3 +"', '"+ _Refsbtype3 +"', '"+ _refbsex3 +"', '"+ _refbwgt3 +"', '"+ _refbwgtnot3 +"', '"+ _refbstim3 +"', '"+ _refbplast3 +"', '"+ _refappcord3 +"', '"+ _refbbfd3 +"', '"+ _refbcond3 +"', '"+ _refdisoutld3 +"', '"+ _refTransPlace3 +"', '"+ _refpph +"', '"+ _refpphnot +"', '"+ _refretainplac +"', '"+ _refdodld +"','"+ _refdodldnot +"', '"+ _reftodld +"','"+ _reftodldnot +"', '"+ _refmatcond +"', '"+ _refTransPlaceM +"','"+ _status +"','"+ _reason +"','"+ _reasmention +"', '"+ _StartTime +"', '"+ _EndTime +"', '"+ _DeviceID +"', '"+ _EntryUser +"', '"+ _Lat +"', '"+ _Lon +"', '"+ _EnDt +"', '"+ _Upload +"', '"+ _modifyDate +"')";
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
                 SQL = "Update "+ TableName +" Set Upload='2',modifyDate='" + _modifyDate + "' ,CountryCode = '"+ _CountryCode +"',FaciCode = '"+ _FaciCode +"',DataID = '"+ _DataID +"',refdoe = '"+ _refdoe +"',refgald = '"+ _refgald +"',refgaldnot = '"+ _refgaldnot +"',refacsgiven = '"+ _refacsgiven +"',refgacalc = '"+ _refgacalc +"',refgacalcnot = '"+ _refgacalcnot +"',refmedadeliv = '"+ _refmedadeliv +"',numofbirth = '"+ _numofbirth +"',reftypebirth1 = '"+ _reftypebirth1 +"',refdelivdate1 = '"+ _refdelivdate1 +"',refdelivdate1not='"+ _refdelivdate1not +"',refdelivtime1 = '"+ _refdelivtime1 +"',refdelivtime1not='"+ _refdelivtime1not +"',refbStatus1 = '"+ _refbStatus1 +"',Refsbtype1 = '"+ _Refsbtype1 +"',refbsex1 = '"+ _refbsex1 +"',refbwgt1 = '"+ _refbwgt1 +"',refbwgtnot1 = '"+ _refbwgtnot1 +"',refbstim1 = '"+ _refbstim1 +"',refbplast1 = '"+ _refbplast1 +"',refappcord1 = '"+ _refappcord1 +"',refbbfd1 = '"+ _refbbfd1 +"',refbcond1 = '"+ _refbcond1 +"',refdisoutld1 = '"+ _refdisoutld1 +"',refTransPlace1 = '"+ _refTransPlace1 +"',reftypebirth2 = '"+ _reftypebirth2 +"',refdelivdate2 = '"+ _refdelivdate2 +"',refdelivdate2not='"+ _refdelivdate2not +"',refdelivtime2 = '"+ _refdelivtime2 +"',refdelivtime2not='"+ _refdelivtime2not +"',refbStatus2 = '"+ _refbStatus2 +"',Refsbtype2 = '"+ _Refsbtype2 +"',refbsex2 = '"+ _refbsex2 +"',refbwgt2 = '"+ _refbwgt2 +"',refbwgtnot2 = '"+ _refbwgtnot2 +"',refbstim2 = '"+ _refbstim2 +"',refbplast2 = '"+ _refbplast2 +"',refappcord2 = '"+ _refappcord2 +"',refbbfd2 = '"+ _refbbfd2 +"',refbcond2 = '"+ _refbcond2 +"',refdisoutld2 = '"+ _refdisoutld2 +"',refTransPlace2 = '"+ _refTransPlace2 +"',reftypebirth3 = '"+ _reftypebirth3 +"',refdelivdate3 = '"+ _refdelivdate3 +"',refdelivdate3not='"+ _refdelivdate3not +"',refdelivtime3 = '"+ _refdelivtime3 +"',refdelivtime3not='"+ _refdelivtime3not +"',refbStatus3 = '"+ _refbStatus3 +"',Refsbtype3 = '"+ _Refsbtype3 +"',refbsex3 = '"+ _refbsex3 +"',refbwgt3 = '"+ _refbwgt3 +"',refbwgtnot3 = '"+ _refbwgtnot3 +"',refbstim3 = '"+ _refbstim3 +"',refbplast3 = '"+ _refbplast3 +"',refappcord3 = '"+ _refappcord3 +"',refbbfd3 = '"+ _refbbfd3 +"',refbcond3 = '"+ _refbcond3 +"',refdisoutld3 = '"+ _refdisoutld3 +"',refTransPlace3 = '"+ _refTransPlace3 +"',refpph = '"+ _refpph +"',refpphnot = '"+ _refpphnot +"',refretainplac = '"+ _refretainplac +"',refdodld = '"+ _refdodld +"',refdodldnot='"+ _refdodldnot +"',reftodld = '"+ _reftodld +"',reftodldnot='"+ _reftodldnot +"',refmatcond = '"+ _refmatcond +"',refTransPlaceM = '"+ _refTransPlaceM +"',status='"+ _status +"',reason='"+ _reason +"',reasmention='"+ _reasmention +"'  Where CountryCode='"+ _CountryCode +"' and FaciCode='"+ _FaciCode +"' and DataID='"+ _DataID +"'";
                 response = C.SaveData(SQL);
                 C.close();
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }

        public List<LD_DataExt_DataModel> SelectAll(Context context, String SQL)
        {
            Connection C = new Connection(context);
            List<LD_DataExt_DataModel> data = new ArrayList<LD_DataExt_DataModel>();
            LD_DataExt_DataModel d = new LD_DataExt_DataModel();
            Cursor cur = C.ReadData(SQL);

            cur.moveToFirst();
            while(!cur.isAfterLast())
            {
                d = new LD_DataExt_DataModel();
                d._CountryCode = cur.getString(cur.getColumnIndex("CountryCode"));
                d._FaciCode = cur.getString(cur.getColumnIndex("FaciCode"));
                d._DataID = cur.getString(cur.getColumnIndex("DataID"));
                d._refdoe = cur.getString(cur.getColumnIndex("refdoe"));
                d._refgald = cur.getString(cur.getColumnIndex("refgald"));
                d._refgaldnot = cur.getString(cur.getColumnIndex("refgaldnot"));
                d._refacsgiven = cur.getString(cur.getColumnIndex("refacsgiven"));
                d._refgacalc = cur.getString(cur.getColumnIndex("refgacalc"));
                d._refgacalcnot = cur.getString(cur.getColumnIndex("refgacalcnot"));
                d._refmedadeliv = cur.getString(cur.getColumnIndex("refmedadeliv"));
                d._numofbirth = cur.getString(cur.getColumnIndex("numofbirth"));
                d._reftypebirth1 = cur.getString(cur.getColumnIndex("reftypebirth1"));
                d._refdelivdate1 = cur.getString(cur.getColumnIndex("refdelivdate1"));
                d._refdelivdate1not = cur.getString(cur.getColumnIndex("refdelivdate1not"));

                d._refdelivtime1 = cur.getString(cur.getColumnIndex("refdelivtime1"));
                d._refdelivtime1not = cur.getString(cur.getColumnIndex("refdelivtime1not"));

                d._refbStatus1 = cur.getString(cur.getColumnIndex("refbStatus1"));
                d._Refsbtype1 = cur.getString(cur.getColumnIndex("Refsbtype1"));
                d._refbsex1 = cur.getString(cur.getColumnIndex("refbsex1"));
                d._refbwgt1 = cur.getString(cur.getColumnIndex("refbwgt1"));
                d._refbwgtnot1 = cur.getString(cur.getColumnIndex("refbwgtnot1"));
                d._refbstim1 = cur.getString(cur.getColumnIndex("refbstim1"));
                d._refbplast1 = cur.getString(cur.getColumnIndex("refbplast1"));
                d._refappcord1 = cur.getString(cur.getColumnIndex("refappcord1"));
                d._refbbfd1 = cur.getString(cur.getColumnIndex("refbbfd1"));
                d._refbcond1 = cur.getString(cur.getColumnIndex("refbcond1"));
                d._refdisoutld1 = cur.getString(cur.getColumnIndex("refdisoutld1"));
                d._refTransPlace1 = cur.getString(cur.getColumnIndex("refTransPlace1"));
                d._reftypebirth2 = cur.getString(cur.getColumnIndex("reftypebirth2"));

                d._refdelivdate2 = cur.getString(cur.getColumnIndex("refdelivdate2"));
                d._refdelivdate2not = cur.getString(cur.getColumnIndex("refdelivdate2not"));

                d._refdelivtime2 = cur.getString(cur.getColumnIndex("refdelivtime2"));
                d._refdelivtime2not = cur.getString(cur.getColumnIndex("refdelivtime2not"));

                d._refbStatus2 = cur.getString(cur.getColumnIndex("refbStatus2"));
                d._Refsbtype2 = cur.getString(cur.getColumnIndex("Refsbtype2"));
                d._refbsex2 = cur.getString(cur.getColumnIndex("refbsex2"));
                d._refbwgt2 = cur.getString(cur.getColumnIndex("refbwgt2"));
                d._refbwgtnot2 = cur.getString(cur.getColumnIndex("refbwgtnot2"));
                d._refbstim2 = cur.getString(cur.getColumnIndex("refbstim2"));
                d._refbplast2 = cur.getString(cur.getColumnIndex("refbplast2"));
                d._refappcord2 = cur.getString(cur.getColumnIndex("refappcord2"));
                d._refbbfd2 = cur.getString(cur.getColumnIndex("refbbfd2"));
                d._refbcond2 = cur.getString(cur.getColumnIndex("refbcond2"));
                d._refdisoutld2 = cur.getString(cur.getColumnIndex("refdisoutld2"));
                d._refTransPlace2 = cur.getString(cur.getColumnIndex("refTransPlace2"));
                d._reftypebirth3 = cur.getString(cur.getColumnIndex("reftypebirth3"));
                d._refdelivdate3 = cur.getString(cur.getColumnIndex("refdelivdate3"));
                d._refdelivdate3not = cur.getString(cur.getColumnIndex("refdelivdate3not"));

                d._refdelivtime3 = cur.getString(cur.getColumnIndex("refdelivtime3"));
                d._refdelivtime3not = cur.getString(cur.getColumnIndex("refdelivtime3not"));

                d._refbStatus3 = cur.getString(cur.getColumnIndex("refbStatus3"));
                d._Refsbtype3 = cur.getString(cur.getColumnIndex("Refsbtype3"));
                d._refbsex3 = cur.getString(cur.getColumnIndex("refbsex3"));
                d._refbwgt3 = cur.getString(cur.getColumnIndex("refbwgt3"));
                d._refbwgtnot3 = cur.getString(cur.getColumnIndex("refbwgtnot3"));
                d._refbstim3 = cur.getString(cur.getColumnIndex("refbstim3"));
                d._refbplast3 = cur.getString(cur.getColumnIndex("refbplast3"));
                d._refappcord3 = cur.getString(cur.getColumnIndex("refappcord3"));
                d._refbbfd3 = cur.getString(cur.getColumnIndex("refbbfd3"));
                d._refbcond3 = cur.getString(cur.getColumnIndex("refbcond3"));
                d._refdisoutld3 = cur.getString(cur.getColumnIndex("refdisoutld3"));
                d._refTransPlace3 = cur.getString(cur.getColumnIndex("refTransPlace3"));
                d._refpph = cur.getString(cur.getColumnIndex("refpph"));
                d._refpphnot = cur.getString(cur.getColumnIndex("refpphnot"));
                d._refretainplac = cur.getString(cur.getColumnIndex("refretainplac"));
                d._refdodld = cur.getString(cur.getColumnIndex("refdodld"));
                d._refdodldnot = cur.getString(cur.getColumnIndex("refdodldnot"));

                d._reftodld = cur.getString(cur.getColumnIndex("reftodld"));
                d._reftodldnot = cur.getString(cur.getColumnIndex("reftodldnot"));

                d._refmatcond = cur.getString(cur.getColumnIndex("refmatcond"));
                d._refTransPlaceM = cur.getString(cur.getColumnIndex("refTransPlaceM"));

                d._status = cur.getString(cur.getColumnIndex("status"));
                d._reason = cur.getString(cur.getColumnIndex("reason"));
                d._reasmention = cur.getString(cur.getColumnIndex("reasmention"));

                data.add(d);

                cur.moveToNext();
            }
            cur.close();
          return data;
        }
 }