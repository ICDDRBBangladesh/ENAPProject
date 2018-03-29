package org.icddrb.enap;

import android.content.Context;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;
 public class RecallSurvS3_DataModel{

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
        private String _bneoward = "";
        public String getbneoward(){
              return _bneoward;
         }
        public void setbneoward(String newValue){
              _bneoward = newValue;
         }
        private String _bprobknow = "";
        public String getbprobknow(){
              return _bprobknow;
         }
        public void setbprobknow(String newValue){
              _bprobknow = newValue;
         }
        private String _bprob = "";
        public String getbprob(){
              return _bprob;
         }
        public void setbprob(String newValue){
              _bprob = newValue;
         }
        private String _bprobOth = "";
        public String getbprobOth(){
              return _bprobOth;
         }
        public void setbprobOth(String newValue){
              _bprobOth = newValue;
         }
        private String _binfxn = "";
        public String getbinfxn(){
              return _binfxn;
         }
        public void setbinfxn(String newValue){
              _binfxn = newValue;
         }
        private String _binfxnOth = "";
        public String getbinfxnOth(){
              return _binfxnOth;
         }
        public void setbinfxnOth(String newValue){
              _binfxnOth = newValue;
         }
        private String _knowadwgtni = "";
        public String getknowadwgtni(){
              return _knowadwgtni;
         }
        public void setknowadwgtni(String newValue){
              _knowadwgtni = newValue;
         }
        private String _adwgtni = "";
        public String getadwgtni(){
              return _adwgtni;
         }
        public void setadwgtni(String newValue){
              _adwgtni = newValue;
         }
        private String _adwgtniDK = "";
        public String getadwgtniDK(){
              return _adwgtniDK;
         }
        public void setadwgtniDK(String newValue){
              _adwgtniDK = newValue;
         }
        private String _bseiz = "";
        public String getbseiz(){
              return _bseiz;
         }
        public void setbseiz(String newValue){
              _bseiz = newValue;
         }
        private String _bseizdays = "";
        public String getbseizdays(){
              return _bseizdays;
         }
        public void setbseizdays(String newValue){
              _bseizdays = newValue;
         }
        private String _bseizdaysDK = "";
        public String getbseizdaysDK(){
              return _bseizdaysDK;
         }
        public void setbseizdaysDK(String newValue){
              _bseizdaysDK = newValue;
         }
        private String _bantiknow = "";
        public String getbantiknow(){
              return _bantiknow;
         }
        public void setbantiknow(String newValue){
              _bantiknow = newValue;
         }
        private String _bantiname1 = "";
        public String getbantiname1(){
              return _bantiname1;
         }
        public void setbantiname1(String newValue){
              _bantiname1 = newValue;
         }
        private String _bantiname2 = "";
        public String getbantiname2(){
              return _bantiname2;
         }
        public void setbantiname2(String newValue){
              _bantiname2 = newValue;
         }
        private String _bantiname3 = "";
        public String getbantiname3(){
              return _bantiname3;
         }
        public void setbantiname3(String newValue){
              _bantiname3 = newValue;
         }
        private String _bantinameDK = "";
        public String getbantinameDK(){
              return _bantinameDK;
         }
        public void setbantinameDK(String newValue){
              _bantinameDK = newValue;
         }
        private String _bantitime = "";
        public String getbantitime(){
              return _bantitime;
         }
        public void setbantitime(String newValue){
              _bantitime = newValue;
         }
        private String _bantitimeDur = "";
        public String getbantitimeDur(){
              return _bantitimeDur;
         }
        public void setbantitimeDur(String newValue){
              _bantitimeDur = newValue;
         }
        private String _bantihome = "";
        public String getbantihome(){
              return _bantihome;
         }
        public void setbantihome(String newValue){
              _bantihome = newValue;
         }
        private String _boxy = "";
        public String getboxy(){
              return _boxy;
         }
        public void setboxy(String newValue){
              _boxy = newValue;
         }
        private String _bdiagtestknow = "";
        public String getbdiagtestknow(){
              return _bdiagtestknow;
         }
        public void setbdiagtestknow(String newValue){
              _bdiagtestknow = newValue;
         }
        private String _bdiagtestA = "";
        public String getbdiagtestA(){
              return _bdiagtestA;
         }
        public void setbdiagtestA(String newValue){
              _bdiagtestA = newValue;
         }
        private String _bdiagtestB = "";
        public String getbdiagtestB(){
              return _bdiagtestB;
         }
        public void setbdiagtestB(String newValue){
              _bdiagtestB = newValue;
         }
        private String _bdiagtestC = "";
        public String getbdiagtestC(){
              return _bdiagtestC;
         }
        public void setbdiagtestC(String newValue){
              _bdiagtestC = newValue;
         }
        private String _bdiagtestD = "";
        public String getbdiagtestD(){
              return _bdiagtestD;
         }
        public void setbdiagtestD(String newValue){
              _bdiagtestD = newValue;
         }
        private String _bdiagtestDOth = "";
        public String getbdiagtestDOth(){
              return _bdiagtestDOth;
         }
        public void setbdiagtestDOth(String newValue){
              _bdiagtestDOth = newValue;
         }
        private String _bdiagtestE = "";
        public String getbdiagtestE(){
              return _bdiagtestE;
         }
        public void setbdiagtestE(String newValue){
              _bdiagtestE = newValue;
         }
        private String _bfsupA = "";
        public String getbfsupA(){
              return _bfsupA;
         }
        public void setbfsupA(String newValue){
              _bfsupA = newValue;
         }
        private String _bfsupB = "";
        public String getbfsupB(){
              return _bfsupB;
         }
        public void setbfsupB(String newValue){
              _bfsupB = newValue;
         }
        private String _bfsupC = "";
        public String getbfsupC(){
              return _bfsupC;
         }
        public void setbfsupC(String newValue){
              _bfsupC = newValue;
         }
        private String _bfsupD = "";
        public String getbfsupD(){
              return _bfsupD;
         }
        public void setbfsupD(String newValue){
              _bfsupD = newValue;
         }
        private String _bfsupE = "";
        public String getbfsupE(){
              return _bfsupE;
         }
        public void setbfsupE(String newValue){
              _bfsupE = newValue;
         }
        private String _bphoto = "";
        public String getbphoto(){
              return _bphoto;
         }
        public void setbphoto(String newValue){
              _bphoto = newValue;
         }
        private String _blos = "";
        public String getblos(){
              return _blos;
         }
        public void setblos(String newValue){
              _blos = newValue;
         }
        private String _blosDK = "";
        public String getblosDK(){
              return _blosDK;
         }
        public void setblosDK(String newValue){
              _blosDK = newValue;
         }
        private String _bref = "";
        public String getbref(){
              return _bref;
         }
        public void setbref(String newValue){
              _bref = newValue;
         }
        private String _knowdiswgtni = "";
        public String getknowdiswgtni(){
              return _knowdiswgtni;
         }
        public void setknowdiswgtni(String newValue){
              _knowdiswgtni = newValue;
         }
        private String _diswgtni = "";
        public String getdiswgtni(){
              return _diswgtni;
         }
        public void setdiswgtni(String newValue){
              _diswgtni = newValue;
         }
        private String _diswgtniDK = "";
        public String getdiswgtniDK(){
              return _diswgtniDK;
         }
        public void setdiswgtniDK(String newValue){
              _diswgtniDK = newValue;
         }

     private String _Comments = "";
     public String getComments(){
         return _Comments;
     }
     public void setComments(String newValue){
         _Comments = newValue;
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

        String TableName = "RecallSurvS3";

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
                 SQL = "Insert into "+ TableName +" (CountryCode,FaciCode,DataID,StudyID,bneoward,bprobknow,bprob,bprobOth,binfxn,binfxnOth,knowadwgtni,adwgtni,adwgtniDK,bseiz,bseizdays,bseizdaysDK,bantiknow,bantiname1,bantiname2,bantiname3,bantinameDK,bantitime,bantitimeDur,bantihome,boxy,bdiagtestknow,bdiagtestA,bdiagtestB,bdiagtestC,bdiagtestD,bdiagtestDOth,bdiagtestE,bfsupA,bfsupB,bfsupC,bfsupD,bfsupE,bphoto,blos,blosDK,bref,knowdiswgtni,diswgtni,diswgtniDK,Comments,StartTime,EndTime,DeviceID,EntryUser,Lat,Lon,EnDt,Upload,modifyDate)Values('"+ _CountryCode +"', '"+ _FaciCode +"', '"+ _DataID +"', '"+ _StudyID +"', '"+ _bneoward +"', '"+ _bprobknow +"', '"+ _bprob +"', '"+ _bprobOth +"', '"+ _binfxn +"', '"+ _binfxnOth +"', '"+ _knowadwgtni +"', '"+ _adwgtni +"', '"+ _adwgtniDK +"', '"+ _bseiz +"', '"+ _bseizdays +"', '"+ _bseizdaysDK +"', '"+ _bantiknow +"', '"+ _bantiname1 +"', '"+ _bantiname2 +"', '"+ _bantiname3 +"', '"+ _bantinameDK +"', '"+ _bantitime +"', '"+ _bantitimeDur +"', '"+ _bantihome +"', '"+ _boxy +"', '"+ _bdiagtestknow +"', '"+ _bdiagtestA +"', '"+ _bdiagtestB +"', '"+ _bdiagtestC +"', '"+ _bdiagtestD +"', '"+ _bdiagtestDOth +"', '"+ _bdiagtestE +"', '"+ _bfsupA +"', '"+ _bfsupB +"', '"+ _bfsupC +"', '"+ _bfsupD +"', '"+ _bfsupE +"', '"+ _bphoto +"', '"+ _blos +"', '"+ _blosDK +"', '"+ _bref +"', '"+ _knowdiswgtni +"', '"+ _diswgtni +"', '"+ _diswgtniDK +"','"+ _Comments +"', '"+ _StartTime +"', '"+ _EndTime +"', '"+ _DeviceID +"', '"+ _EntryUser +"', '"+ _Lat +"', '"+ _Lon +"', '"+ _EnDt +"', '"+ _Upload +"', '"+ _modifyDate +"')";
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
                 SQL = "Update "+ TableName +" Set Upload='2',modifyDate='" + _modifyDate + "' ,CountryCode = '"+ _CountryCode +"',FaciCode = '"+ _FaciCode +"',DataID = '"+ _DataID +"',StudyID = '"+ _StudyID +"',bneoward = '"+ _bneoward +"',bprobknow = '"+ _bprobknow +"',bprob = '"+ _bprob +"',bprobOth = '"+ _bprobOth +"',binfxn = '"+ _binfxn +"',binfxnOth = '"+ _binfxnOth +"',knowadwgtni = '"+ _knowadwgtni +"',adwgtni = '"+ _adwgtni +"',adwgtniDK = '"+ _adwgtniDK +"',bseiz = '"+ _bseiz +"',bseizdays = '"+ _bseizdays +"',bseizdaysDK = '"+ _bseizdaysDK +"',bantiknow = '"+ _bantiknow +"',bantiname1 = '"+ _bantiname1 +"',bantiname2 = '"+ _bantiname2 +"',bantiname3 = '"+ _bantiname3 +"',bantinameDK = '"+ _bantinameDK +"',bantitime = '"+ _bantitime +"',bantitimeDur = '"+ _bantitimeDur +"',bantihome = '"+ _bantihome +"',boxy = '"+ _boxy +"',bdiagtestknow = '"+ _bdiagtestknow +"',bdiagtestA = '"+ _bdiagtestA +"',bdiagtestB = '"+ _bdiagtestB +"',bdiagtestC = '"+ _bdiagtestC +"',bdiagtestD = '"+ _bdiagtestD +"',bdiagtestDOth = '"+ _bdiagtestDOth +"',bdiagtestE = '"+ _bdiagtestE +"',bfsupA = '"+ _bfsupA +"',bfsupB = '"+ _bfsupB +"',bfsupC = '"+ _bfsupC +"',bfsupD = '"+ _bfsupD +"',bfsupE = '"+ _bfsupE +"',bphoto = '"+ _bphoto +"',blos = '"+ _blos +"',blosDK = '"+ _blosDK +"',bref = '"+ _bref +"',knowdiswgtni = '"+ _knowdiswgtni +"',diswgtni = '"+ _diswgtni +"',diswgtniDK = '"+ _diswgtniDK +"',Comments='"+ _Comments +"'  Where CountryCode='"+ _CountryCode +"' and FaciCode='"+ _FaciCode +"' and DataID='"+ _DataID +"'";
                 response = C.SaveData(SQL);
                 C.close();
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }


        public List<RecallSurvS3_DataModel> SelectAll(Context context, String SQL)
        {
            Connection C = new Connection(context);
            List<RecallSurvS3_DataModel> data = new ArrayList<RecallSurvS3_DataModel>();
            RecallSurvS3_DataModel d = new RecallSurvS3_DataModel();
            Cursor cur = C.ReadData(SQL);

            cur.moveToFirst();
            while(!cur.isAfterLast())
            {
                d = new RecallSurvS3_DataModel();
                d._CountryCode = cur.getString(cur.getColumnIndex("CountryCode"));
                d._FaciCode = cur.getString(cur.getColumnIndex("FaciCode"));
                d._DataID = cur.getString(cur.getColumnIndex("DataID"));
                d._StudyID = cur.getString(cur.getColumnIndex("StudyID"));
                d._bneoward = cur.getString(cur.getColumnIndex("bneoward"));
                d._bprobknow = cur.getString(cur.getColumnIndex("bprobknow"));
                d._bprob = cur.getString(cur.getColumnIndex("bprob"));
                d._bprobOth = cur.getString(cur.getColumnIndex("bprobOth"));
                d._binfxn = cur.getString(cur.getColumnIndex("binfxn"));
                d._binfxnOth = cur.getString(cur.getColumnIndex("binfxnOth"));
                d._knowadwgtni = cur.getString(cur.getColumnIndex("knowadwgtni"));
                d._adwgtni = cur.getString(cur.getColumnIndex("adwgtni"));
                d._adwgtniDK = cur.getString(cur.getColumnIndex("adwgtniDK"));
                d._bseiz = cur.getString(cur.getColumnIndex("bseiz"));
                d._bseizdays = cur.getString(cur.getColumnIndex("bseizdays"));
                d._bseizdaysDK = cur.getString(cur.getColumnIndex("bseizdaysDK"));
                d._bantiknow = cur.getString(cur.getColumnIndex("bantiknow"));
                d._bantiname1 = cur.getString(cur.getColumnIndex("bantiname1"));
                d._bantiname2 = cur.getString(cur.getColumnIndex("bantiname2"));
                d._bantiname3 = cur.getString(cur.getColumnIndex("bantiname3"));
                d._bantinameDK = cur.getString(cur.getColumnIndex("bantinameDK"));
                d._bantitime = cur.getString(cur.getColumnIndex("bantitime"));
                d._bantitimeDur = cur.getString(cur.getColumnIndex("bantitimeDur"));
                d._bantihome = cur.getString(cur.getColumnIndex("bantihome"));
                d._boxy = cur.getString(cur.getColumnIndex("boxy"));
                d._bdiagtestknow = cur.getString(cur.getColumnIndex("bdiagtestknow"));
                d._bdiagtestA = cur.getString(cur.getColumnIndex("bdiagtestA"));
                d._bdiagtestB = cur.getString(cur.getColumnIndex("bdiagtestB"));
                d._bdiagtestC = cur.getString(cur.getColumnIndex("bdiagtestC"));
                d._bdiagtestD = cur.getString(cur.getColumnIndex("bdiagtestD"));
                d._bdiagtestDOth = cur.getString(cur.getColumnIndex("bdiagtestDOth"));
                d._bdiagtestE = cur.getString(cur.getColumnIndex("bdiagtestE"));
                d._bfsupA = cur.getString(cur.getColumnIndex("bfsupA"));
                d._bfsupB = cur.getString(cur.getColumnIndex("bfsupB"));
                d._bfsupC = cur.getString(cur.getColumnIndex("bfsupC"));
                d._bfsupD = cur.getString(cur.getColumnIndex("bfsupD"));
                d._bfsupE = cur.getString(cur.getColumnIndex("bfsupE"));
                d._bphoto = cur.getString(cur.getColumnIndex("bphoto"));
                d._blos = cur.getString(cur.getColumnIndex("blos"));
                d._blosDK = cur.getString(cur.getColumnIndex("blosDK"));
                d._bref = cur.getString(cur.getColumnIndex("bref"));
                d._knowdiswgtni = cur.getString(cur.getColumnIndex("knowdiswgtni"));
                d._diswgtni = cur.getString(cur.getColumnIndex("diswgtni"));
                d._diswgtniDK = cur.getString(cur.getColumnIndex("diswgtniDK"));
                d._Comments = cur.getString(cur.getColumnIndex("Comments"));

                data.add(d);

                cur.moveToNext();
            }
            cur.close();
          return data;
        }
 }