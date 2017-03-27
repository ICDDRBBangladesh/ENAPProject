package org.icddrb.enap;

import android.content.Context;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;
 public class RecallSurvS2_DataModel{

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
        private String _bb4expect = "";
        public String getbb4expect(){
              return _bb4expect;
         }
        public void setbb4expect(String newValue){
              _bb4expect = newValue;
         }
        private String _redeliv = "";
        public String getredeliv(){
              return _redeliv;
         }
        public void setredeliv(String newValue){
              _redeliv = newValue;
         }
        private String _edeliv = "";
        public String getedeliv(){
              return _edeliv;
         }
        public void setedeliv(String newValue){
              _edeliv = newValue;
         }
        private String _edelivDur = "";
        public String getedelivDur(){
              return _edelivDur;
         }
        public void setedelivDur(String newValue){
              _edelivDur = newValue;
         }
        private String _acsgiven = "";
        public String getacsgiven(){
              return _acsgiven;
         }
        public void setacsgiven(String newValue){
              _acsgiven = newValue;
         }
        private String _acsreason = "";
        public String getacsreason(){
              return _acsreason;
         }
        public void setacsreason(String newValue){
              _acsreason = newValue;
         }
        private String _acsreasonOth = "";
        public String getacsreasonOth(){
              return _acsreasonOth;
         }
        public void setacsreasonOth(String newValue){
              _acsreasonOth = newValue;
         }
        private String _acsname = "";
        public String getacsname(){
              return _acsname;
         }
        public void setacsname(String newValue){
              _acsname = newValue;
         }
        private String _acsnameOth = "";
        public String getacsnameOth(){
              return _acsnameOth;
         }
        public void setacsnameOth(String newValue){
              _acsnameOth = newValue;
         }
        private String _acsroute = "";
        public String getacsroute(){
              return _acsroute;
         }
        public void setacsroute(String newValue){
              _acsroute = newValue;
         }
        private String _acsrouteOth = "";
        public String getacsrouteOth(){
              return _acsrouteOth;
         }
        public void setacsrouteOth(String newValue){
              _acsrouteOth = newValue;
         }
        private String _acsdoses = "";
        public String getacsdoses(){
              return _acsdoses;
         }
        public void setacsdoses(String newValue){
              _acsdoses = newValue;
         }
        private String _acsdosesDK = "";
        public String getacsdosesDK(){
              return _acsdosesDK;
         }
        public void setacsdosesDK(String newValue){
              _acsdosesDK = newValue;
         }
        private String _acstime = "";
        public String getacstime(){
              return _acstime;
         }
        public void setacstime(String newValue){
              _acstime = newValue;
         }
        private String _medadeliv = "";
        public String getmedadeliv(){
              return _medadeliv;
         }
        public void setmedadeliv(String newValue){
              _medadeliv = newValue;
         }
        private String _uteroroute1 = "";
        public String getuteroroute1(){
              return _uteroroute1;
         }
        public void setuteroroute1(String newValue){
              _uteroroute1 = newValue;
         }
        private String _uteroroute2 = "";
        public String getuteroroute2(){
              return _uteroroute2;
         }
        public void setuteroroute2(String newValue){
              _uteroroute2 = newValue;
         }
        private String _uteroroute3 = "";
        public String getuteroroute3(){
              return _uteroroute3;
         }
        public void setuteroroute3(String newValue){
              _uteroroute3 = newValue;
         }
        private String _uteroroute4 = "";
        public String getuteroroute4(){
              return _uteroroute4;
         }
        public void setuteroroute4(String newValue){
              _uteroroute4 = newValue;
         }
        private String _uteroroute5 = "";
        public String getuteroroute5(){
              return _uteroroute5;
         }
        public void setuteroroute5(String newValue){
              _uteroroute5 = newValue;
         }
        private String _uterotime = "";
        public String getuterotime(){
              return _uterotime;
         }
        public void setuterotime(String newValue){
              _uterotime = newValue;
         }
        private String _uterotold = "";
        public String getuterotold(){
              return _uterotold;
         }
        public void setuterotold(String newValue){
              _uterotold = newValue;
         }
        private String _uteroknow = "";
        public String getuteroknow(){
              return _uteroknow;
         }
        public void setuteroknow(String newValue){
              _uteroknow = newValue;
         }
        private String _uteronameA = "";
        public String getuteronameA(){
              return _uteronameA;
         }
        public void setuteronameA(String newValue){
              _uteronameA = newValue;
         }
        private String _uteronameB = "";
        public String getuteronameB(){
              return _uteronameB;
         }
        public void setuteronameB(String newValue){
              _uteronameB = newValue;
         }
        private String _uteronameC = "";
        public String getuteronameC(){
              return _uteronameC;
         }
        public void setuteronameC(String newValue){
              _uteronameC = newValue;
         }
        private String _uteronameD = "";
        public String getuteronameD(){
              return _uteronameD;
         }
        public void setuteronameD(String newValue){
              _uteronameD = newValue;
         }
        private String _uteronameDOth = "";
        public String getuteronameDOth(){
              return _uteronameDOth;
         }
        public void setuteronameDOth(String newValue){
              _uteronameDOth = newValue;
         }
        private String _uteronameE = "";
        public String getuteronameE(){
              return _uteronameE;
         }
        public void setuteronameE(String newValue){
              _uteronameE = newValue;
         }
        private String _tolduteroreas = "";
        public String gettolduteroreas(){
              return _tolduteroreas;
         }
        public void settolduteroreas(String newValue){
              _tolduteroreas = newValue;
         }
        private String _uteroreasA = "";
        public String getuteroreasA(){
              return _uteroreasA;
         }
        public void setuteroreasA(String newValue){
              _uteroreasA = newValue;
         }
        private String _uteroreasB = "";
        public String getuteroreasB(){
              return _uteroreasB;
         }
        public void setuteroreasB(String newValue){
              _uteroreasB = newValue;
         }
        private String _uteroreasOth = "";
        public String getuteroreasOth(){
              return _uteroreasOth;
         }
        public void setuteroreasOth(String newValue){
              _uteroreasOth = newValue;
         }
        private String _uteroreasC = "";
        public String getuteroreasC(){
              return _uteroreasC;
         }
        public void setuteroreasC(String newValue){
              _uteroreasC = newValue;
         }
        private String _bdried = "";
        public String getbdried(){
              return _bdried;
         }
        public void setbdried(String newValue){
              _bdried = newValue;
         }
        private String _bnakchest = "";
        public String getbnakchest(){
              return _bnakchest;
         }
        public void setbnakchest(String newValue){
              _bnakchest = newValue;
         }
        private String _bchesttime = "";
        public String getbchesttime(){
              return _bchesttime;
         }
        public void setbchesttime(String newValue){
              _bchesttime = newValue;
         }
        private String _bchesttimeM = "";
        public String getbchesttimeM(){
              return _bchesttimeM;
         }
        public void setbchesttimeM(String newValue){
              _bchesttimeM = newValue;
         }
        private String _bplaced = "";
        public String getbplaced(){
              return _bplaced;
         }
        public void setbplaced(String newValue){
              _bplaced = newValue;
         }
        private String _bbathtime = "";
        public String getbbathtime(){
              return _bbathtime;
         }
        public void setbbathtime(String newValue){
              _bbathtime = newValue;
         }
        private String _bbathtimeDur = "";
        public String getbbathtimeDur(){
              return _bbathtimeDur;
         }
        public void setbbathtimeDur(String newValue){
              _bbathtimeDur = newValue;
         }
        private String _bbfd = "";
        public String getbbfd(){
              return _bbfd;
         }
        public void setbbfd(String newValue){
              _bbfd = newValue;
         }
        private String _bfdtime = "";
        public String getbfdtime(){
              return _bfdtime;
         }
        public void setbfdtime(String newValue){
              _bfdtime = newValue;
         }
        private String _bfdtimeDur = "";
        public String getbfdtimeDur(){
              return _bfdtimeDur;
         }
        public void setbfdtimeDur(String newValue){
              _bfdtimeDur = newValue;
         }
        private String _supbfd = "";
        public String getsupbfd(){
              return _supbfd;
         }
        public void setsupbfd(String newValue){
              _supbfd = newValue;
         }
        private String _altdrinkA = "";
        public String getaltdrinkA(){
              return _altdrinkA;
         }
        public void setaltdrinkA(String newValue){
              _altdrinkA = newValue;
         }
        private String _altdrinkB = "";
        public String getaltdrinkB(){
              return _altdrinkB;
         }
        public void setaltdrinkB(String newValue){
              _altdrinkB = newValue;
         }
        private String _altdrinkC = "";
        public String getaltdrinkC(){
              return _altdrinkC;
         }
        public void setaltdrinkC(String newValue){
              _altdrinkC = newValue;
         }
        private String _altdrinkD = "";
        public String getaltdrinkD(){
              return _altdrinkD;
         }
        public void setaltdrinkD(String newValue){
              _altdrinkD = newValue;
         }
        private String _altdrinkDOth = "";
        public String getaltdrinkDOth(){
              return _altdrinkDOth;
         }
        public void setaltdrinkDOth(String newValue){
              _altdrinkDOth = newValue;
         }
        private String _altdrinkE = "";
        public String getaltdrinkE(){
              return _altdrinkE;
         }
        public void setaltdrinkE(String newValue){
              _altdrinkE = newValue;
         }
        private String _altdrinkF = "";
        public String getaltdrinkF(){
              return _altdrinkF;
         }
        public void setaltdrinkF(String newValue){
              _altdrinkF = newValue;
         }
        private String _bcry = "";
        public String getbcry(){
              return _bcry;
         }
        public void setbcry(String newValue){
              _bcry = newValue;
         }
        private String _btroubbrth = "";
        public String getbtroubbrth(){
              return _btroubbrth;
         }
        public void setbtroubbrth(String newValue){
              _btroubbrth = newValue;
         }
        private String _helpbbrthA = "";
        public String gethelpbbrthA(){
              return _helpbbrthA;
         }
        public void sethelpbbrthA(String newValue){
              _helpbbrthA = newValue;
         }
        private String _helpbbrthB = "";
        public String gethelpbbrthB(){
              return _helpbbrthB;
         }
        public void sethelpbbrthB(String newValue){
              _helpbbrthB = newValue;
         }
        private String _helpbbrthC = "";
        public String gethelpbbrthC(){
              return _helpbbrthC;
         }
        public void sethelpbbrthC(String newValue){
              _helpbbrthC = newValue;
         }
        private String _helpbbrthD = "";
        public String gethelpbbrthD(){
              return _helpbbrthD;
         }
        public void sethelpbbrthD(String newValue){
              _helpbbrthD = newValue;
         }
        private String _helpbbrthE = "";
        public String gethelpbbrthE(){
              return _helpbbrthE;
         }
        public void sethelpbbrthE(String newValue){
              _helpbbrthE = newValue;
         }
        private String _bstim = "";
        public String getbstim(){
              return _bstim;
         }
        public void setbstim(String newValue){
              _bstim = newValue;
         }
        private String _bplast = "";
        public String getbplast(){
              return _bplast;
         }
        public void setbplast(String newValue){
              _bplast = newValue;
         }
        private String _bresustmin = "";
        public String getbresustmin(){
              return _bresustmin;
         }
        public void setbresustmin(String newValue){
              _bresustmin = newValue;
         }
        private String _bresustminDur = "";
        public String getbresustminDur(){
              return _bresustminDur;
         }
        public void setbresustminDur(String newValue){
              _bresustminDur = newValue;
         }
        private String _bsuc = "";
        public String getbsuc(){
              return _bsuc;
         }
        public void setbsuc(String newValue){
              _bsuc = newValue;
         }
        private String _oresusact = "";
        public String getoresusact(){
              return _oresusact;
         }
        public void setoresusact(String newValue){
              _oresusact = newValue;
         }
        private String _oresusactOth = "";
        public String getoresusactOth(){
              return _oresusactOth;
         }
        public void setoresusactOth(String newValue){
              _oresusactOth = newValue;
         }
        private String _badmward = "";
        public String getbadmward(){
              return _badmward;
         }
        public void setbadmward(String newValue){
              _badmward = newValue;
         }
        private String _toldresusexp = "";
        public String gettoldresusexp(){
              return _toldresusexp;
         }
        public void settoldresusexp(String newValue){
              _toldresusexp = newValue;
         }
        private String _resusexp = "";
        public String getresusexp(){
              return _resusexp;
         }
        public void setresusexp(String newValue){
              _resusexp = newValue;
         }
        private String _resusexpDK = "";
        public String getresusexpDK(){
              return _resusexpDK;
         }
        public void setresusexpDK(String newValue){
              _resusexpDK = newValue;
         }
        private String _appcord = "";
        public String getappcord(){
              return _appcord;
         }
        public void setappcord(String newValue){
              _appcord = newValue;
         }
        private String _medappcord = "";
        public String getmedappcord(){
              return _medappcord;
         }
        public void setmedappcord(String newValue){
              _medappcord = newValue;
         }
        private String _medappcordOth = "";
        public String getmedappcordOth(){
              return _medappcordOth;
         }
        public void setmedappcordOth(String newValue){
              _medappcordOth = newValue;
         }
        private String _timechl = "";
        public String gettimechl(){
              return _timechl;
         }
        public void settimechl(String newValue){
              _timechl = newValue;
         }
        private String _timechlDur = "";
        public String gettimechlDur(){
              return _timechlDur;
         }
        public void settimechlDur(String newValue){
              _timechlDur = newValue;
         }
        private String _whoappchl = "";
        public String getwhoappchl(){
              return _whoappchl;
         }
        public void setwhoappchl(String newValue){
              _whoappchl = newValue;
         }
        private String _whoappchlOth = "";
        public String getwhoappchlOth(){
              return _whoappchlOth;
         }
        public void setwhoappchlOth(String newValue){
              _whoappchlOth = newValue;
         }
        private String _toldchlreas = "";
        public String gettoldchlreas(){
              return _toldchlreas;
         }
        public void settoldchlreas(String newValue){
              _toldchlreas = newValue;
         }
        private String _chlreas = "";
        public String getchlreas(){
              return _chlreas;
         }
        public void setchlreas(String newValue){
              _chlreas = newValue;
         }
        private String _chlreasDK = "";
        public String getchlreasDK(){
              return _chlreasDK;
         }
        public void setchlreasDK(String newValue){
              _chlreasDK = newValue;
         }
        private String _chlhome = "";
        public String getchlhome(){
              return _chlhome;
         }
        public void setchlhome(String newValue){
              _chlhome = newValue;
         }
        private String _comments = "";
        public String getcomments(){
              return _comments;
         }
        public void setcomments(String newValue){
              _comments = newValue;
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

        String TableName = "RecallSurvS2";

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
                 SQL = "Insert into "+ TableName +" (CountryCode,FaciCode,DataID,StudyID,bb4expect,redeliv,edeliv,edelivDur,acsgiven,acsreason,acsreasonOth,acsname,acsnameOth,acsroute,acsrouteOth,acsdoses,acsdosesDK,acstime,medadeliv,uteroroute1,uteroroute2,uteroroute3,uteroroute4,uteroroute5,uterotime,uterotold,uteroknow,uteronameA,uteronameB,uteronameC,uteronameD,uteronameDOth,uteronameE,tolduteroreas,uteroreasA,uteroreasB,uteroreasOth,uteroreasC,bdried,bnakchest,bchesttime,bchesttimeM,bplaced,bbathtime,bbathtimeDur,bbfd,bfdtime,bfdtimeDur,supbfd,altdrinkA,altdrinkB,altdrinkC,altdrinkD,altdrinkDOth,altdrinkE,altdrinkF,bcry,btroubbrth,helpbbrthA,helpbbrthB,helpbbrthC,helpbbrthD,helpbbrthE,bstim,bplast,bresustmin,bresustminDur,bsuc,oresusact,oresusactOth,badmward,toldresusexp,resusexp,resusexpDK,appcord,medappcord,medappcordOth,timechl,timechlDur,whoappchl,whoappchlOth,toldchlreas,chlreas,chlreasDK,chlhome,comments,StartTime,EndTime,DeviceID,EntryUser,Lat,Lon,EnDt,Upload,modifyDate)Values('"+ _CountryCode +"', '"+ _FaciCode +"', '"+ _DataID +"', '"+ _StudyID +"', '"+ _bb4expect +"', '"+ _redeliv +"', '"+ _edeliv +"', '"+ _edelivDur +"', '"+ _acsgiven +"', '"+ _acsreason +"', '"+ _acsreasonOth +"', '"+ _acsname +"', '"+ _acsnameOth +"', '"+ _acsroute +"', '"+ _acsrouteOth +"', '"+ _acsdoses +"', '"+ _acsdosesDK +"', '"+ _acstime +"', '"+ _medadeliv +"', '"+ _uteroroute1 +"', '"+ _uteroroute2 +"', '"+ _uteroroute3 +"', '"+ _uteroroute4 +"', '"+ _uteroroute5 +"', '"+ _uterotime +"', '"+ _uterotold +"', '"+ _uteroknow +"', '"+ _uteronameA +"', '"+ _uteronameB +"', '"+ _uteronameC +"', '"+ _uteronameD +"', '"+ _uteronameDOth +"', '"+ _uteronameE +"', '"+ _tolduteroreas +"', '"+ _uteroreasA +"', '"+ _uteroreasB +"', '"+ _uteroreasOth +"', '"+ _uteroreasC +"', '"+ _bdried +"', '"+ _bnakchest +"', '"+ _bchesttime +"', '"+ _bchesttimeM +"', '"+ _bplaced +"', '"+ _bbathtime +"', '"+ _bbathtimeDur +"', '"+ _bbfd +"', '"+ _bfdtime +"', '"+ _bfdtimeDur +"', '"+ _supbfd +"', '"+ _altdrinkA +"', '"+ _altdrinkB +"', '"+ _altdrinkC +"', '"+ _altdrinkD +"', '"+ _altdrinkDOth +"', '"+ _altdrinkE +"', '"+ _altdrinkF +"', '"+ _bcry +"', '"+ _btroubbrth +"', '"+ _helpbbrthA +"', '"+ _helpbbrthB +"', '"+ _helpbbrthC +"', '"+ _helpbbrthD +"', '"+ _helpbbrthE +"', '"+ _bstim +"', '"+ _bplast +"', '"+ _bresustmin +"', '"+ _bresustminDur +"', '"+ _bsuc +"', '"+ _oresusact +"', '"+ _oresusactOth +"', '"+ _badmward +"', '"+ _toldresusexp +"', '"+ _resusexp +"', '"+ _resusexpDK +"', '"+ _appcord +"', '"+ _medappcord +"', '"+ _medappcordOth +"', '"+ _timechl +"', '"+ _timechlDur +"', '"+ _whoappchl +"', '"+ _whoappchlOth +"', '"+ _toldchlreas +"', '"+ _chlreas +"', '"+ _chlreasDK +"', '"+ _chlhome +"', '"+ _comments +"', '"+ _StartTime +"', '"+ _EndTime +"', '"+ _DeviceID +"', '"+ _EntryUser +"', '"+ _Lat +"', '"+ _Lon +"', '"+ _EnDt +"', '"+ _Upload +"', '"+ _modifyDate +"')";
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
                 SQL = "Update "+ TableName +" Set Upload='2',modifyDate='" + _modifyDate + "' ,CountryCode = '"+ _CountryCode +"',FaciCode = '"+ _FaciCode +"',DataID = '"+ _DataID +"',StudyID = '"+ _StudyID +"',bb4expect = '"+ _bb4expect +"',redeliv = '"+ _redeliv +"',edeliv = '"+ _edeliv +"',edelivDur = '"+ _edelivDur +"',acsgiven = '"+ _acsgiven +"',acsreason = '"+ _acsreason +"',acsreasonOth = '"+ _acsreasonOth +"',acsname = '"+ _acsname +"',acsnameOth = '"+ _acsnameOth +"',acsroute = '"+ _acsroute +"',acsrouteOth = '"+ _acsrouteOth +"',acsdoses = '"+ _acsdoses +"',acsdosesDK = '"+ _acsdosesDK +"',acstime = '"+ _acstime +"',medadeliv = '"+ _medadeliv +"',uteroroute1 = '"+ _uteroroute1 +"',uteroroute2 = '"+ _uteroroute2 +"',uteroroute3 = '"+ _uteroroute3 +"',uteroroute4 = '"+ _uteroroute4 +"',uteroroute5 = '"+ _uteroroute5 +"',uterotime = '"+ _uterotime +"',uterotold = '"+ _uterotold +"',uteroknow = '"+ _uteroknow +"',uteronameA = '"+ _uteronameA +"',uteronameB = '"+ _uteronameB +"',uteronameC = '"+ _uteronameC +"',uteronameD = '"+ _uteronameD +"',uteronameDOth = '"+ _uteronameDOth +"',uteronameE = '"+ _uteronameE +"',tolduteroreas = '"+ _tolduteroreas +"',uteroreasA = '"+ _uteroreasA +"',uteroreasB = '"+ _uteroreasB +"',uteroreasOth = '"+ _uteroreasOth +"',uteroreasC = '"+ _uteroreasC +"',bdried = '"+ _bdried +"',bnakchest = '"+ _bnakchest +"',bchesttime = '"+ _bchesttime +"',bchesttimeM = '"+ _bchesttimeM +"',bplaced = '"+ _bplaced +"',bbathtime = '"+ _bbathtime +"',bbathtimeDur = '"+ _bbathtimeDur +"',bbfd = '"+ _bbfd +"',bfdtime = '"+ _bfdtime +"',bfdtimeDur = '"+ _bfdtimeDur +"',supbfd = '"+ _supbfd +"',altdrinkA = '"+ _altdrinkA +"',altdrinkB = '"+ _altdrinkB +"',altdrinkC = '"+ _altdrinkC +"',altdrinkD = '"+ _altdrinkD +"',altdrinkDOth = '"+ _altdrinkDOth +"',altdrinkE = '"+ _altdrinkE +"',altdrinkF = '"+ _altdrinkF +"',bcry = '"+ _bcry +"',btroubbrth = '"+ _btroubbrth +"',helpbbrthA = '"+ _helpbbrthA +"',helpbbrthB = '"+ _helpbbrthB +"',helpbbrthC = '"+ _helpbbrthC +"',helpbbrthD = '"+ _helpbbrthD +"',helpbbrthE = '"+ _helpbbrthE +"',bstim = '"+ _bstim +"',bplast = '"+ _bplast +"',bresustmin = '"+ _bresustmin +"',bresustminDur = '"+ _bresustminDur +"',bsuc = '"+ _bsuc +"',oresusact = '"+ _oresusact +"',oresusactOth = '"+ _oresusactOth +"',badmward = '"+ _badmward +"',toldresusexp = '"+ _toldresusexp +"',resusexp = '"+ _resusexp +"',resusexpDK = '"+ _resusexpDK +"',appcord = '"+ _appcord +"',medappcord = '"+ _medappcord +"',medappcordOth = '"+ _medappcordOth +"',timechl = '"+ _timechl +"',timechlDur = '"+ _timechlDur +"',whoappchl = '"+ _whoappchl +"',whoappchlOth = '"+ _whoappchlOth +"',toldchlreas = '"+ _toldchlreas +"',chlreas = '"+ _chlreas +"',chlreasDK = '"+ _chlreasDK +"',chlhome = '"+ _chlhome +"',comments = '"+ _comments +"'  Where CountryCode='"+ _CountryCode +"' and FaciCode='"+ _FaciCode +"' and DataID='"+ _DataID +"'";
                 C.Save(SQL);
                 C.close();
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }


        public List<RecallSurvS2_DataModel> SelectAll(Context context, String SQL)
        {
            Connection C = new Connection(context);
            List<RecallSurvS2_DataModel> data = new ArrayList<RecallSurvS2_DataModel>();
            RecallSurvS2_DataModel d = new RecallSurvS2_DataModel();
            Cursor cur = C.ReadData(SQL);

            cur.moveToFirst();
            while(!cur.isAfterLast())
            {
                d = new RecallSurvS2_DataModel();
                d._CountryCode = cur.getString(cur.getColumnIndex("CountryCode"));
                d._FaciCode = cur.getString(cur.getColumnIndex("FaciCode"));
                d._DataID = cur.getString(cur.getColumnIndex("DataID"));
                d._StudyID = cur.getString(cur.getColumnIndex("StudyID"));
                d._bb4expect = cur.getString(cur.getColumnIndex("bb4expect"));
                d._redeliv = cur.getString(cur.getColumnIndex("redeliv"));
                d._edeliv = cur.getString(cur.getColumnIndex("edeliv"));
                d._edelivDur = cur.getString(cur.getColumnIndex("edelivDur"));
                d._acsgiven = cur.getString(cur.getColumnIndex("acsgiven"));
                d._acsreason = cur.getString(cur.getColumnIndex("acsreason"));
                d._acsreasonOth = cur.getString(cur.getColumnIndex("acsreasonOth"));
                d._acsname = cur.getString(cur.getColumnIndex("acsname"));
                d._acsnameOth = cur.getString(cur.getColumnIndex("acsnameOth"));
                d._acsroute = cur.getString(cur.getColumnIndex("acsroute"));
                d._acsrouteOth = cur.getString(cur.getColumnIndex("acsrouteOth"));
                d._acsdoses = cur.getString(cur.getColumnIndex("acsdoses"));
                d._acsdosesDK = cur.getString(cur.getColumnIndex("acsdosesDK"));
                d._acstime = cur.getString(cur.getColumnIndex("acstime"));
                d._medadeliv = cur.getString(cur.getColumnIndex("medadeliv"));
                d._uteroroute1 = cur.getString(cur.getColumnIndex("uteroroute1"));
                d._uteroroute2 = cur.getString(cur.getColumnIndex("uteroroute2"));
                d._uteroroute3 = cur.getString(cur.getColumnIndex("uteroroute3"));
                d._uteroroute4 = cur.getString(cur.getColumnIndex("uteroroute4"));
                d._uteroroute5 = cur.getString(cur.getColumnIndex("uteroroute5"));
                d._uterotime = cur.getString(cur.getColumnIndex("uterotime"));
                d._uterotold = cur.getString(cur.getColumnIndex("uterotold"));
                d._uteroknow = cur.getString(cur.getColumnIndex("uteroknow"));
                d._uteronameA = cur.getString(cur.getColumnIndex("uteronameA"));
                d._uteronameB = cur.getString(cur.getColumnIndex("uteronameB"));
                d._uteronameC = cur.getString(cur.getColumnIndex("uteronameC"));
                d._uteronameD = cur.getString(cur.getColumnIndex("uteronameD"));
                d._uteronameDOth = cur.getString(cur.getColumnIndex("uteronameDOth"));
                d._uteronameE = cur.getString(cur.getColumnIndex("uteronameE"));
                d._tolduteroreas = cur.getString(cur.getColumnIndex("tolduteroreas"));
                d._uteroreasA = cur.getString(cur.getColumnIndex("uteroreasA"));
                d._uteroreasB = cur.getString(cur.getColumnIndex("uteroreasB"));
                d._uteroreasOth = cur.getString(cur.getColumnIndex("uteroreasOth"));
                d._uteroreasC = cur.getString(cur.getColumnIndex("uteroreasC"));
                d._bdried = cur.getString(cur.getColumnIndex("bdried"));
                d._bnakchest = cur.getString(cur.getColumnIndex("bnakchest"));
                d._bchesttime = cur.getString(cur.getColumnIndex("bchesttime"));
                d._bchesttimeM = cur.getString(cur.getColumnIndex("bchesttimeM"));
                d._bplaced = cur.getString(cur.getColumnIndex("bplaced"));
                d._bbathtime = cur.getString(cur.getColumnIndex("bbathtime"));
                d._bbathtimeDur = cur.getString(cur.getColumnIndex("bbathtimeDur"));
                d._bbfd = cur.getString(cur.getColumnIndex("bbfd"));
                d._bfdtime = cur.getString(cur.getColumnIndex("bfdtime"));
                d._bfdtimeDur = cur.getString(cur.getColumnIndex("bfdtimeDur"));
                d._supbfd = cur.getString(cur.getColumnIndex("supbfd"));
                d._altdrinkA = cur.getString(cur.getColumnIndex("altdrinkA"));
                d._altdrinkB = cur.getString(cur.getColumnIndex("altdrinkB"));
                d._altdrinkC = cur.getString(cur.getColumnIndex("altdrinkC"));
                d._altdrinkD = cur.getString(cur.getColumnIndex("altdrinkD"));
                d._altdrinkDOth = cur.getString(cur.getColumnIndex("altdrinkDOth"));
                d._altdrinkE = cur.getString(cur.getColumnIndex("altdrinkE"));
                d._altdrinkF = cur.getString(cur.getColumnIndex("altdrinkF"));
                d._bcry = cur.getString(cur.getColumnIndex("bcry"));
                d._btroubbrth = cur.getString(cur.getColumnIndex("btroubbrth"));
                d._helpbbrthA = cur.getString(cur.getColumnIndex("helpbbrthA"));
                d._helpbbrthB = cur.getString(cur.getColumnIndex("helpbbrthB"));
                d._helpbbrthC = cur.getString(cur.getColumnIndex("helpbbrthC"));
                d._helpbbrthD = cur.getString(cur.getColumnIndex("helpbbrthD"));
                d._helpbbrthE = cur.getString(cur.getColumnIndex("helpbbrthE"));
                d._bstim = cur.getString(cur.getColumnIndex("bstim"));
                d._bplast = cur.getString(cur.getColumnIndex("bplast"));
                d._bresustmin = cur.getString(cur.getColumnIndex("bresustmin"));
                d._bresustminDur = cur.getString(cur.getColumnIndex("bresustminDur"));
                d._bsuc = cur.getString(cur.getColumnIndex("bsuc"));
                d._oresusact = cur.getString(cur.getColumnIndex("oresusact"));
                d._oresusactOth = cur.getString(cur.getColumnIndex("oresusactOth"));
                d._badmward = cur.getString(cur.getColumnIndex("badmward"));
                d._toldresusexp = cur.getString(cur.getColumnIndex("toldresusexp"));
                d._resusexp = cur.getString(cur.getColumnIndex("resusexp"));
                d._resusexpDK = cur.getString(cur.getColumnIndex("resusexpDK"));
                d._appcord = cur.getString(cur.getColumnIndex("appcord"));
                d._medappcord = cur.getString(cur.getColumnIndex("medappcord"));
                d._medappcordOth = cur.getString(cur.getColumnIndex("medappcordOth"));
                d._timechl = cur.getString(cur.getColumnIndex("timechl"));
                d._timechlDur = cur.getString(cur.getColumnIndex("timechlDur"));
                d._whoappchl = cur.getString(cur.getColumnIndex("whoappchl"));
                d._whoappchlOth = cur.getString(cur.getColumnIndex("whoappchlOth"));
                d._toldchlreas = cur.getString(cur.getColumnIndex("toldchlreas"));
                d._chlreas = cur.getString(cur.getColumnIndex("chlreas"));
                d._chlreasDK = cur.getString(cur.getColumnIndex("chlreasDK"));
                d._chlhome = cur.getString(cur.getColumnIndex("chlhome"));
                d._comments = cur.getString(cur.getColumnIndex("comments"));
                data.add(d);

                cur.moveToNext();
            }
            cur.close();
          return data;
        }
 }