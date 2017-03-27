package org.icddrb.enap;

import android.content.Context;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;
 public class RecallSurvS1_DataModel{

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
        private String _ConsentMRS = "";
        public String getConsentMRS(){
              return _ConsentMRS;
         }
        public void setConsentMRS(String newValue){
              _ConsentMRS = newValue;
         }
        private String _ConsentFollo = "";
        public String getConsentFollo(){
              return _ConsentFollo;
         }
        public void setConsentFollo(String newValue){
              _ConsentFollo = newValue;
         }
        private String _doi = "";
        public String getdoi(){
              return _doi;
         }
        public void setdoi(String newValue){
              _doi = newValue;
         }
        private String _toi = "";
        public String gettoi(){
              return _toi;
         }
        public void settoi(String newValue){
              _toi = newValue;
         }
        private String _lang = "";
        public String getlang(){
              return _lang;
         }
        public void setlang(String newValue){
              _lang = newValue;
         }
        private String _cconditionb = "";
        public String getcconditionb(){
              return _cconditionb;
         }
        public void setcconditionb(String newValue){
              _cconditionb = newValue;
         }
        private String _matconsent = "";
        public String getmatconsent(){
              return _matconsent;
         }
        public void setmatconsent(String newValue){
              _matconsent = newValue;
         }
        private String _MatbdateM = "";
        public String getMatbdateM(){
              return _MatbdateM;
         }
        public void setMatbdateM(String newValue){
              _MatbdateM = newValue;
         }
        private String _MatbdateY = "";
        public String getMatbdateY(){
              return _MatbdateY;
         }
        public void setMatbdateY(String newValue){
              _MatbdateY = newValue;
         }
        private String _MatbdateDK = "";
        public String getMatbdateDK(){
              return _MatbdateDK;
         }
        public void setMatbdateDK(String newValue){
              _MatbdateDK = newValue;
         }
        private String _Matage = "";
        public String getMatage(){
              return _Matage;
         }
        public void setMatage(String newValue){
              _Matage = newValue;
         }
        private String _MatageDK = "";
        public String getMatageDK(){
              return _MatageDK;
         }
        public void setMatageDK(String newValue){
              _MatageDK = newValue;
         }
        private String _addr1 = "";
        public String getaddr1(){
              return _addr1;
         }
        public void setaddr1(String newValue){
              _addr1 = newValue;
         }
        private String _addr2 = "";
        public String getaddr2(){
              return _addr2;
         }
        public void setaddr2(String newValue){
              _addr2 = newValue;
         }
        private String _addr3 = "";
        public String getaddr3(){
              return _addr3;
         }
        public void setaddr3(String newValue){
              _addr3 = newValue;
         }
        private String _addr4 = "";
        public String getaddr4(){
              return _addr4;
         }
        public void setaddr4(String newValue){
              _addr4 = newValue;
         }
        private String _AddressDetail = "";
        public String getAddressDetail(){
              return _AddressDetail;
         }
        public void setAddressDetail(String newValue){
              _AddressDetail = newValue;
         }
        private String _matmobile = "";
        public String getmatmobile(){
              return _matmobile;
         }
        public void setmatmobile(String newValue){
              _matmobile = newValue;
         }
        private String _Matmobnum = "";
        public String getMatmobnum(){
              return _Matmobnum;
         }
        public void setMatmobnum(String newValue){
              _Matmobnum = newValue;
         }
        private String _MatmobnumDK = "";
        public String getMatmobnumDK(){
              return _MatmobnumDK;
         }
        public void setMatmobnumDK(String newValue){
              _MatmobnumDK = newValue;
         }
        private String _Matmobnum1 = "";
        public String getMatmobnum1(){
              return _Matmobnum1;
         }
        public void setMatmobnum1(String newValue){
              _Matmobnum1 = newValue;
         }
        private String _Matmobnum1DK = "";
        public String getMatmobnum1DK(){
              return _Matmobnum1DK;
         }
        public void setMatmobnum1DK(String newValue){
              _Matmobnum1DK = newValue;
         }
        private String _husmob = "";
        public String gethusmob(){
              return _husmob;
         }
        public void sethusmob(String newValue){
              _husmob = newValue;
         }
        private String _Husmobnum = "";
        public String getHusmobnum(){
              return _Husmobnum;
         }
        public void setHusmobnum(String newValue){
              _Husmobnum = newValue;
         }
        private String _HusmobnumDK = "";
        public String getHusmobnumDK(){
              return _HusmobnumDK;
         }
        public void setHusmobnumDK(String newValue){
              _HusmobnumDK = newValue;
         }
        private String _Husmobnum2 = "";
        public String getHusmobnum2(){
              return _Husmobnum2;
         }
        public void setHusmobnum2(String newValue){
              _Husmobnum2 = newValue;
         }
        private String _Husmobnum2DK = "";
        public String getHusmobnum2DK(){
              return _Husmobnum2DK;
         }
        public void setHusmobnum2DK(String newValue){
              _Husmobnum2DK = newValue;
         }
        private String _contact1 = "";
        public String getcontact1(){
              return _contact1;
         }
        public void setcontact1(String newValue){
              _contact1 = newValue;
         }
        private String _eddknown = "";
        public String geteddknown(){
              return _eddknown;
         }
        public void seteddknown(String newValue){
              _eddknown = newValue;
         }
        private String _Edd = "";
        public String getEdd(){
              return _Edd;
         }
        public void setEdd(String newValue){
              _Edd = newValue;
         }
        private String _EddDK = "";
        public String getEddDK(){
              return _EddDK;
         }
        public void setEddDK(String newValue){
              _EddDK = newValue;
         }
        private String _Gameth = "";
        public String getGameth(){
              return _Gameth;
         }
        public void setGameth(String newValue){
              _Gameth = newValue;
         }
        private String _GamethOth = "";
        public String getGamethOth(){
              return _GamethOth;
         }
        public void setGamethOth(String newValue){
              _GamethOth = newValue;
         }
        private String _ga1anc = "";
        public String getga1anc(){
              return _ga1anc;
         }
        public void setga1anc(String newValue){
              _ga1anc = newValue;
         }
        private String _ga1ancWM = "";
        public String getga1ancWM(){
              return _ga1ancWM;
         }
        public void setga1ancWM(String newValue){
              _ga1ancWM = newValue;
         }
        private String _antcarenum = "";
        public String getantcarenum(){
              return _antcarenum;
         }
        public void setantcarenum(String newValue){
              _antcarenum = newValue;
         }
        private String _ga = "";
        public String getga(){
              return _ga;
         }
        public void setga(String newValue){
              _ga = newValue;
         }
        private String _gaWM = "";
        public String getgaWM(){
              return _gaWM;
         }
        public void setgaWM(String newValue){
              _gaWM = newValue;
         }
        private String _bheart = "";
        public String getbheart(){
              return _bheart;
         }
        public void setbheart(String newValue){
              _bheart = newValue;
         }
        private String _bcondition = "";
        public String getbcondition(){
              return _bcondition;
         }
        public void setbcondition(String newValue){
              _bcondition = newValue;
         }
        private String _placedeliv = "";
        public String getplacedeliv(){
              return _placedeliv;
         }
        public void setplacedeliv(String newValue){
              _placedeliv = newValue;
         }
        private String _placedelivOth = "";
        public String getplacedelivOth(){
              return _placedelivOth;
         }
        public void setplacedelivOth(String newValue){
              _placedelivOth = newValue;
         }
        private String _delivdate = "";
        public String getdelivdate(){
              return _delivdate;
         }
        public void setdelivdate(String newValue){
              _delivdate = newValue;
         }
        private String _delivdateDK = "";
        public String getdelivdateDK(){
              return _delivdateDK;
         }
        public void setdelivdateDK(String newValue){
              _delivdateDK = newValue;
         }
        private String _delivtime = "";
        public String getdelivtime(){
              return _delivtime;
         }
        public void setdelivtime(String newValue){
              _delivtime = newValue;
         }
        private String _delivtimeDK = "";
        public String getdelivtimeDK(){
              return _delivtimeDK;
         }
        public void setdelivtimeDK(String newValue){
              _delivtimeDK = newValue;
         }
        private String _typebirth = "";
        public String gettypebirth(){
              return _typebirth;
         }
        public void settypebirth(String newValue){
              _typebirth = newValue;
         }
        private String _Timecsec = "";
        public String getTimecsec(){
              return _Timecsec;
         }
        public void setTimecsec(String newValue){
              _Timecsec = newValue;
         }
        private String _Toldcsecreas = "";
        public String getToldcsecreas(){
              return _Toldcsecreas;
         }
        public void setToldcsecreas(String newValue){
              _Toldcsecreas = newValue;
         }
        private String _Csecreas = "";
        public String getCsecreas(){
              return _Csecreas;
         }
        public void setCsecreas(String newValue){
              _Csecreas = newValue;
         }
        private String _OthReason = "";
        public String getOthReason(){
              return _OthReason;
         }
        public void setOthReason(String newValue){
              _OthReason = newValue;
         }
        private String _Bwgted = "";
        public String getBwgted(){
              return _Bwgted;
         }
        public void setBwgted(String newValue){
              _Bwgted = newValue;
         }
        private String _Bwgt = "";
        public String getBwgt(){
              return _Bwgt;
         }
        public void setBwgt(String newValue){
              _Bwgt = newValue;
         }
        private String _BwgtDK = "";
        public String getBwgtDK(){
              return _BwgtDK;
         }
        public void setBwgtDK(String newValue){
              _BwgtDK = newValue;
         }
        private String _bwgtmeth = "";
        public String getbwgtmeth(){
              return _bwgtmeth;
         }
        public void setbwgtmeth(String newValue){
              _bwgtmeth = newValue;
         }
        private String _Bsex = "";
        public String getBsex(){
              return _Bsex;
         }
        public void setBsex(String newValue){
              _Bsex = newValue;
         }
        private String _perceivesize = "";
        public String getperceivesize(){
              return _perceivesize;
         }
        public void setperceivesize(String newValue){
              _perceivesize = newValue;
         }
        private String _anybcomp = "";
        public String getanybcomp(){
              return _anybcomp;
         }
        public void setanybcomp(String newValue){
              _anybcomp = newValue;
         }
        private String _bcompA = "";
        public String getbcompA(){
              return _bcompA;
         }
        public void setbcompA(String newValue){
              _bcompA = newValue;
         }
        private String _bcompB = "";
        public String getbcompB(){
              return _bcompB;
         }
        public void setbcompB(String newValue){
              _bcompB = newValue;
         }
        private String _bcompC = "";
        public String getbcompC(){
              return _bcompC;
         }
        public void setbcompC(String newValue){
              _bcompC = newValue;
         }
        private String _bcompD = "";
        public String getbcompD(){
              return _bcompD;
         }
        public void setbcompD(String newValue){
              _bcompD = newValue;
         }
        private String _bcompE = "";
        public String getbcompE(){
              return _bcompE;
         }
        public void setbcompE(String newValue){
              _bcompE = newValue;
         }
        private String _bcompF = "";
        public String getbcompF(){
              return _bcompF;
         }
        public void setbcompF(String newValue){
              _bcompF = newValue;
         }
        private String _bcompG = "";
        public String getbcompG(){
              return _bcompG;
         }
        public void setbcompG(String newValue){
              _bcompG = newValue;
         }
        private String _bcompH = "";
        public String getbcompH(){
              return _bcompH;
         }
        public void setbcompH(String newValue){
              _bcompH = newValue;
         }
        private String _bcompI = "";
        public String getbcompI(){
              return _bcompI;
         }
        public void setbcompI(String newValue){
              _bcompI = newValue;
         }
        private String _bcompIOth = "";
        public String getbcompIOth(){
              return _bcompIOth;
         }
        public void setbcompIOth(String newValue){
              _bcompIOth = newValue;
         }
        private String _bcompJ = "";
        public String getbcompJ(){
              return _bcompJ;
         }
        public void setbcompJ(String newValue){
              _bcompJ = newValue;
         }
        private String _nightsnum = "";
        public String getnightsnum(){
              return _nightsnum;
         }
        public void setnightsnum(String newValue){
              _nightsnum = newValue;
         }
        private String _nightsnumDK = "";
        public String getnightsnumDK(){
              return _nightsnumDK;
         }
        public void setnightsnumDK(String newValue){
              _nightsnumDK = newValue;
         }
        private String _bnotif = "";
        public String getbnotif(){
              return _bnotif;
         }
        public void setbnotif(String newValue){
              _bnotif = newValue;
         }
        private String _bcert = "";
        public String getbcert(){
              return _bcert;
         }
        public void setbcert(String newValue){
              _bcert = newValue;
         }
        private String _bcertknow = "";
        public String getbcertknow(){
              return _bcertknow;
         }
        public void setbcertknow(String newValue){
              _bcertknow = newValue;
         }
        private String _bcerttime = "";
        public String getbcerttime(){
              return _bcerttime;
         }
        public void setbcerttime(String newValue){
              _bcerttime = newValue;
         }
        private String _bcerttimeWM = "";
        public String getbcerttimeWM(){
              return _bcerttimeWM;
         }
        public void setbcerttimeWM(String newValue){
              _bcerttimeWM = newValue;
         }
        private String _anybcertcon = "";
        public String getanybcertcon(){
              return _anybcertcon;
         }
        public void setanybcertcon(String newValue){
              _anybcertcon = newValue;
         }
        private String _bcertcon = "";
        public String getbcertcon(){
              return _bcertcon;
         }
        public void setbcertcon(String newValue){
              _bcertcon = newValue;
         }
        private String _bcertconOth = "";
        public String getbcertconOth(){
              return _bcertconOth;
         }
        public void setbcertconOth(String newValue){
              _bcertconOth = newValue;
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

        String TableName = "RecallSurvS1";

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
                 SQL = "Insert into "+ TableName +" (CountryCode,FaciCode,DataID,StudyID,ConsentMRS,ConsentFollo,doi,toi,lang,cconditionb,matconsent,MatbdateM,MatbdateY,MatbdateDK,Matage,MatageDK,addr1,addr2,addr3,addr4,AddressDetail,matmobile,Matmobnum,MatmobnumDK,Matmobnum1,Matmobnum1DK,husmob,Husmobnum,HusmobnumDK,Husmobnum2,Husmobnum2DK,contact1,eddknown,Edd,EddDK,Gameth,GamethOth,ga1anc,ga1ancWM,antcarenum,ga,gaWM,bheart,bcondition,placedeliv,placedelivOth,delivdate,delivdateDK,delivtime,delivtimeDK,typebirth,Timecsec,Toldcsecreas,Csecreas,OthReason,Bwgted,Bwgt,BwgtDK,bwgtmeth,Bsex,perceivesize,anybcomp,bcompA,bcompB,bcompC,bcompD,bcompE,bcompF,bcompG,bcompH,bcompI,bcompIOth,bcompJ,nightsnum,nightsnumDK,bnotif,bcert,bcertknow,bcerttime,bcerttimeWM,anybcertcon,bcertcon,bcertconOth,StartTime,EndTime,DeviceID,EntryUser,Lat,Lon,EnDt,Upload,modifyDate)Values('"+ _CountryCode +"', '"+ _FaciCode +"', '"+ _DataID +"', '"+ _StudyID +"', '"+ _ConsentMRS +"', '"+ _ConsentFollo +"', '"+ _doi +"', '"+ _toi +"', '"+ _lang +"', '"+ _cconditionb +"', '"+ _matconsent +"', '"+ _MatbdateM +"', '"+ _MatbdateY +"', '"+ _MatbdateDK +"', '"+ _Matage +"', '"+ _MatageDK +"', '"+ _addr1 +"', '"+ _addr2 +"', '"+ _addr3 +"', '"+ _addr4 +"', '"+ _AddressDetail +"', '"+ _matmobile +"', '"+ _Matmobnum +"', '"+ _MatmobnumDK +"', '"+ _Matmobnum1 +"', '"+ _Matmobnum1DK +"', '"+ _husmob +"', '"+ _Husmobnum +"', '"+ _HusmobnumDK +"', '"+ _Husmobnum2 +"', '"+ _Husmobnum2DK +"', '"+ _contact1 +"', '"+ _eddknown +"', '"+ _Edd +"', '"+ _EddDK +"', '"+ _Gameth +"', '"+ _GamethOth +"', '"+ _ga1anc +"', '"+ _ga1ancWM +"', '"+ _antcarenum +"', '"+ _ga +"', '"+ _gaWM +"', '"+ _bheart +"', '"+ _bcondition +"', '"+ _placedeliv +"', '"+ _placedelivOth +"', '"+ _delivdate +"', '"+ _delivdateDK +"', '"+ _delivtime +"', '"+ _delivtimeDK +"', '"+ _typebirth +"', '"+ _Timecsec +"', '"+ _Toldcsecreas +"', '"+ _Csecreas +"', '"+ _OthReason +"', '"+ _Bwgted +"', '"+ _Bwgt +"', '"+ _BwgtDK +"', '"+ _bwgtmeth +"', '"+ _Bsex +"', '"+ _perceivesize +"', '"+ _anybcomp +"', '"+ _bcompA +"', '"+ _bcompB +"', '"+ _bcompC +"', '"+ _bcompD +"', '"+ _bcompE +"', '"+ _bcompF +"', '"+ _bcompG +"', '"+ _bcompH +"', '"+ _bcompI +"', '"+ _bcompIOth +"', '"+ _bcompJ +"', '"+ _nightsnum +"', '"+ _nightsnumDK +"', '"+ _bnotif +"', '"+ _bcert +"', '"+ _bcertknow +"', '"+ _bcerttime +"', '"+ _bcerttimeWM +"', '"+ _anybcertcon +"', '"+ _bcertcon +"', '"+ _bcertconOth +"', '"+ _StartTime +"', '"+ _EndTime +"', '"+ _DeviceID +"', '"+ _EntryUser +"', '"+ _Lat +"', '"+ _Lon +"', '"+ _EnDt +"', '"+ _Upload +"', '"+ _modifyDate +"')";
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
                 SQL = "Update "+ TableName +" Set Upload='2',modifyDate='" + _modifyDate + "' ,CountryCode = '"+ _CountryCode +"',FaciCode = '"+ _FaciCode +"',DataID = '"+ _DataID +"',StudyID = '"+ _StudyID +"',ConsentMRS = '"+ _ConsentMRS +"',ConsentFollo = '"+ _ConsentFollo +"',doi = '"+ _doi +"',toi = '"+ _toi +"',lang = '"+ _lang +"',cconditionb = '"+ _cconditionb +"',matconsent = '"+ _matconsent +"',MatbdateM = '"+ _MatbdateM +"',MatbdateY = '"+ _MatbdateY +"',MatbdateDK = '"+ _MatbdateDK +"',Matage = '"+ _Matage +"',MatageDK = '"+ _MatageDK +"',addr1 = '"+ _addr1 +"',addr2 = '"+ _addr2 +"',addr3 = '"+ _addr3 +"',addr4 = '"+ _addr4 +"',AddressDetail = '"+ _AddressDetail +"',matmobile = '"+ _matmobile +"',Matmobnum = '"+ _Matmobnum +"',MatmobnumDK = '"+ _MatmobnumDK +"',Matmobnum1 = '"+ _Matmobnum1 +"',Matmobnum1DK = '"+ _Matmobnum1DK +"',husmob = '"+ _husmob +"',Husmobnum = '"+ _Husmobnum +"',HusmobnumDK = '"+ _HusmobnumDK +"',Husmobnum2 = '"+ _Husmobnum2 +"',Husmobnum2DK = '"+ _Husmobnum2DK +"',contact1 = '"+ _contact1 +"',eddknown = '"+ _eddknown +"',Edd = '"+ _Edd +"',EddDK = '"+ _EddDK +"',Gameth = '"+ _Gameth +"',GamethOth = '"+ _GamethOth +"',ga1anc = '"+ _ga1anc +"',ga1ancWM = '"+ _ga1ancWM +"',antcarenum = '"+ _antcarenum +"',ga = '"+ _ga +"',gaWM = '"+ _gaWM +"',bheart = '"+ _bheart +"',bcondition = '"+ _bcondition +"',placedeliv = '"+ _placedeliv +"',placedelivOth = '"+ _placedelivOth +"',delivdate = '"+ _delivdate +"',delivdateDK = '"+ _delivdateDK +"',delivtime = '"+ _delivtime +"',delivtimeDK = '"+ _delivtimeDK +"',typebirth = '"+ _typebirth +"',Timecsec = '"+ _Timecsec +"',Toldcsecreas = '"+ _Toldcsecreas +"',Csecreas = '"+ _Csecreas +"',OthReason = '"+ _OthReason +"',Bwgted = '"+ _Bwgted +"',Bwgt = '"+ _Bwgt +"',BwgtDK = '"+ _BwgtDK +"',bwgtmeth = '"+ _bwgtmeth +"',Bsex = '"+ _Bsex +"',perceivesize = '"+ _perceivesize +"',anybcomp = '"+ _anybcomp +"',bcompA = '"+ _bcompA +"',bcompB = '"+ _bcompB +"',bcompC = '"+ _bcompC +"',bcompD = '"+ _bcompD +"',bcompE = '"+ _bcompE +"',bcompF = '"+ _bcompF +"',bcompG = '"+ _bcompG +"',bcompH = '"+ _bcompH +"',bcompI = '"+ _bcompI +"',bcompIOth = '"+ _bcompIOth +"',bcompJ = '"+ _bcompJ +"',nightsnum = '"+ _nightsnum +"',nightsnumDK = '"+ _nightsnumDK +"',bnotif = '"+ _bnotif +"',bcert = '"+ _bcert +"',bcertknow = '"+ _bcertknow +"',bcerttime = '"+ _bcerttime +"',bcerttimeWM = '"+ _bcerttimeWM +"',anybcertcon = '"+ _anybcertcon +"',bcertcon = '"+ _bcertcon +"',bcertconOth = '"+ _bcertconOth +"'  Where CountryCode='"+ _CountryCode +"' and FaciCode='"+ _FaciCode +"' and DataID='"+ _DataID +"'";
                 C.Save(SQL);
                 C.close();
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }


        public List<RecallSurvS1_DataModel> SelectAll(Context context, String SQL)
        {
            Connection C = new Connection(context);
            List<RecallSurvS1_DataModel> data = new ArrayList<RecallSurvS1_DataModel>();
            RecallSurvS1_DataModel d = new RecallSurvS1_DataModel();
            Cursor cur = C.ReadData(SQL);

            cur.moveToFirst();
            while(!cur.isAfterLast())
            {
                d = new RecallSurvS1_DataModel();
                d._CountryCode = cur.getString(cur.getColumnIndex("CountryCode"));
                d._FaciCode = cur.getString(cur.getColumnIndex("FaciCode"));
                d._DataID = cur.getString(cur.getColumnIndex("DataID"));
                d._StudyID = cur.getString(cur.getColumnIndex("StudyID"));
                d._ConsentMRS = cur.getString(cur.getColumnIndex("ConsentMRS"));
                d._ConsentFollo = cur.getString(cur.getColumnIndex("ConsentFollo"));
                d._doi = cur.getString(cur.getColumnIndex("doi"));
                d._toi = cur.getString(cur.getColumnIndex("toi"));
                d._lang = cur.getString(cur.getColumnIndex("lang"));
                d._cconditionb = cur.getString(cur.getColumnIndex("cconditionb"));
                d._matconsent = cur.getString(cur.getColumnIndex("matconsent"));
                d._MatbdateM = cur.getString(cur.getColumnIndex("MatbdateM"));
                d._MatbdateY = cur.getString(cur.getColumnIndex("MatbdateY"));
                d._MatbdateDK = cur.getString(cur.getColumnIndex("MatbdateDK"));
                d._Matage = cur.getString(cur.getColumnIndex("Matage"));
                d._MatageDK = cur.getString(cur.getColumnIndex("MatageDK"));
                d._addr1 = cur.getString(cur.getColumnIndex("addr1"));
                d._addr2 = cur.getString(cur.getColumnIndex("addr2"));
                d._addr3 = cur.getString(cur.getColumnIndex("addr3"));
                d._addr4 = cur.getString(cur.getColumnIndex("addr4"));
                d._AddressDetail = cur.getString(cur.getColumnIndex("AddressDetail"));
                d._matmobile = cur.getString(cur.getColumnIndex("matmobile"));
                d._Matmobnum = cur.getString(cur.getColumnIndex("Matmobnum"));
                d._MatmobnumDK = cur.getString(cur.getColumnIndex("MatmobnumDK"));
                d._Matmobnum1 = cur.getString(cur.getColumnIndex("Matmobnum1"));
                d._Matmobnum1DK = cur.getString(cur.getColumnIndex("Matmobnum1DK"));
                d._husmob = cur.getString(cur.getColumnIndex("husmob"));
                d._Husmobnum = cur.getString(cur.getColumnIndex("Husmobnum"));
                d._HusmobnumDK = cur.getString(cur.getColumnIndex("HusmobnumDK"));
                d._Husmobnum2 = cur.getString(cur.getColumnIndex("Husmobnum2"));
                d._Husmobnum2DK = cur.getString(cur.getColumnIndex("Husmobnum2DK"));
                d._contact1 = cur.getString(cur.getColumnIndex("contact1"));
                d._eddknown = cur.getString(cur.getColumnIndex("eddknown"));
                d._Edd = cur.getString(cur.getColumnIndex("Edd"));
                d._EddDK = cur.getString(cur.getColumnIndex("EddDK"));
                d._Gameth = cur.getString(cur.getColumnIndex("Gameth"));
                d._GamethOth = cur.getString(cur.getColumnIndex("GamethOth"));
                d._ga1anc = cur.getString(cur.getColumnIndex("ga1anc"));
                d._ga1ancWM = cur.getString(cur.getColumnIndex("ga1ancWM"));
                d._antcarenum = cur.getString(cur.getColumnIndex("antcarenum"));
                d._ga = cur.getString(cur.getColumnIndex("ga"));
                d._gaWM = cur.getString(cur.getColumnIndex("gaWM"));
                d._bheart = cur.getString(cur.getColumnIndex("bheart"));
                d._bcondition = cur.getString(cur.getColumnIndex("bcondition"));
                d._placedeliv = cur.getString(cur.getColumnIndex("placedeliv"));
                d._placedelivOth = cur.getString(cur.getColumnIndex("placedelivOth"));
                d._delivdate = cur.getString(cur.getColumnIndex("delivdate"));
                d._delivdateDK = cur.getString(cur.getColumnIndex("delivdateDK"));
                d._delivtime = cur.getString(cur.getColumnIndex("delivtime"));
                d._delivtimeDK = cur.getString(cur.getColumnIndex("delivtimeDK"));
                d._typebirth = cur.getString(cur.getColumnIndex("typebirth"));
                d._Timecsec = cur.getString(cur.getColumnIndex("Timecsec"));
                d._Toldcsecreas = cur.getString(cur.getColumnIndex("Toldcsecreas"));
                d._Csecreas = cur.getString(cur.getColumnIndex("Csecreas"));
                d._OthReason = cur.getString(cur.getColumnIndex("OthReason"));
                d._Bwgted = cur.getString(cur.getColumnIndex("Bwgted"));
                d._Bwgt = cur.getString(cur.getColumnIndex("Bwgt"));
                d._BwgtDK = cur.getString(cur.getColumnIndex("BwgtDK"));
                d._bwgtmeth = cur.getString(cur.getColumnIndex("bwgtmeth"));
                d._Bsex = cur.getString(cur.getColumnIndex("Bsex"));
                d._perceivesize = cur.getString(cur.getColumnIndex("perceivesize"));
                d._anybcomp = cur.getString(cur.getColumnIndex("anybcomp"));
                d._bcompA = cur.getString(cur.getColumnIndex("bcompA"));
                d._bcompB = cur.getString(cur.getColumnIndex("bcompB"));
                d._bcompC = cur.getString(cur.getColumnIndex("bcompC"));
                d._bcompD = cur.getString(cur.getColumnIndex("bcompD"));
                d._bcompE = cur.getString(cur.getColumnIndex("bcompE"));
                d._bcompF = cur.getString(cur.getColumnIndex("bcompF"));
                d._bcompG = cur.getString(cur.getColumnIndex("bcompG"));
                d._bcompH = cur.getString(cur.getColumnIndex("bcompH"));
                d._bcompI = cur.getString(cur.getColumnIndex("bcompI"));
                d._bcompIOth = cur.getString(cur.getColumnIndex("bcompIOth"));
                d._bcompJ = cur.getString(cur.getColumnIndex("bcompJ"));
                d._nightsnum = cur.getString(cur.getColumnIndex("nightsnum"));
                d._nightsnumDK = cur.getString(cur.getColumnIndex("nightsnumDK"));
                d._bnotif = cur.getString(cur.getColumnIndex("bnotif"));
                d._bcert = cur.getString(cur.getColumnIndex("bcert"));
                d._bcertknow = cur.getString(cur.getColumnIndex("bcertknow"));
                d._bcerttime = cur.getString(cur.getColumnIndex("bcerttime"));
                d._bcerttimeWM = cur.getString(cur.getColumnIndex("bcerttimeWM"));
                d._anybcertcon = cur.getString(cur.getColumnIndex("anybcertcon"));
                d._bcertcon = cur.getString(cur.getColumnIndex("bcertcon"));
                d._bcertconOth = cur.getString(cur.getColumnIndex("bcertconOth"));
                data.add(d);

                cur.moveToNext();
            }
            cur.close();
          return data;
        }
 }