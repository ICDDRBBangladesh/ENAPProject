package org.icddrb.enap;

import android.content.Context;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;
 public class KMC_DataExt_DataModel{

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
        private String _refabskmc = "";
        public String getrefabskmc(){
              return _refabskmc;
         }
        public void setrefabskmc(String newValue){
              _refabskmc = newValue;
         }
        private String _refabskmcOth = "";
        public String getrefabskmcOth(){
              return _refabskmcOth;
         }
        public void setrefabskmcOth(String newValue){
              _refabskmcOth = newValue;
         }
        private String _refmatname = "";
        public String getrefmatname(){
              return _refmatname;
         }
        public void setrefmatname(String newValue){
              _refmatname = newValue;
         }
        private String _refmatage = "";
        public String getrefmatage(){
              return _refmatage;
         }
        public void setrefmatage(String newValue){
              _refmatage = newValue;
         }
        private String _refmatid = "";
        public String getrefmatid(){
              return _refmatid;
         }
        public void setrefmatid(String newValue){
              _refmatid = newValue;
         }
        private String _refbname = "";
        public String getrefbname(){
              return _refbname;
         }
        public void setrefbname(String newValue){
              _refbname = newValue;
         }
        private String _refbid = "";
        public String getrefbid(){
              return _refbid;
         }
        public void setrefbid(String newValue){
              _refbid = newValue;
         }
        private String _refbsex = "";
        public String getrefbsex(){
              return _refbsex;
         }
        public void setrefbsex(String newValue){
              _refbsex = newValue;
         }
        private String _refdelivdate = "";
        public String getrefdelivdate(){
              return _refdelivdate;
         }
        public void setrefdelivdate(String newValue){
              _refdelivdate = newValue;
         }
     private String _refdelivdatenot = "";
     public String getrefdelivdatenot(){
         return _refdelivdatenot;
     }
     public void setrefdelivdatenot(String newValue){
         _refdelivdatenot = newValue;
     }


     private String _refbwgt = "";
        public String getrefbwgt(){
              return _refbwgt;
         }
        public void setrefbwgt(String newValue){
              _refbwgt = newValue;
         }
        private String _refbwgtnot = "";
        public String getrefbwgtnot(){
              return _refbwgtnot;
         }
        public void setrefbwgtnot(String newValue){
              _refbwgtnot = newValue;
         }
        private String _refgakmc = "";
        public String getrefgakmc(){
              return _refgakmc;
         }
        public void setrefgakmc(String newValue){
              _refgakmc = newValue;
         }
        private String _refgakmcnot = "";
        public String getrefgakmcnot(){
              return _refgakmcnot;
         }
        public void setrefgakmcnot(String newValue){
              _refgakmcnot = newValue;
         }
        private String _refbbornloc = "";
        public String getrefbbornloc(){
              return _refbbornloc;
         }
        public void setrefbbornloc(String newValue){
              _refbbornloc = newValue;
         }
        private String _refbbornOth = "";
        public String getrefbbornOth(){
              return _refbbornOth;
         }
        public void setrefbbornOth(String newValue){
              _refbbornOth = newValue;
         }
        private String _refdelivtime = "";
        public String getrefdelivtime(){
              return _refdelivtime;
         }
        public void setrefdelivtime(String newValue){
              _refdelivtime = newValue;
         }
     private String _refdelivtimenot = "";
     public String getrefdelivtimenot(){
         return _refdelivtimenot;
     }
     public void setrefdelivtimenot(String newValue){
         _refdelivtimenot = newValue;
     }



     private String _refdoadmkmc = "";
        public String getrefdoadmkmc(){
              return _refdoadmkmc;
         }
        public void setrefdoadmkmc(String newValue){
              _refdoadmkmc = newValue;
         }

     private String _refdoadmkmcnot = "";
     public String getrefdoadmkmcnot(){
         return _refdoadmkmcnot;
     }
     public void setrefdoadmkmcnot(String newValue){
         _refdoadmkmcnot = newValue;
     }


        private String _reftoadmkmc = "";
        public String getreftoadmkmc(){
              return _reftoadmkmc;
         }
        public void setreftoadmkmc(String newValue){
              _reftoadmkmc = newValue;
         }

     private String _reftoadmkmcnot = "";
     public String getreftoadmkmcnot(){
         return _reftoadmkmcnot;
     }
     public void setreftoadmkmcnot(String newValue){
         _reftoadmkmcnot = newValue;
     }

        private String _refadwgtkmc = "";
        public String getrefadwgtkmc(){
              return _refadwgtkmc;
         }
        public void setrefadwgtkmc(String newValue){
              _refadwgtkmc = newValue;
         }
        private String _refadwgtkmcnot = "";
        public String getrefadwgtkmcnot(){
              return _refadwgtkmcnot;
         }
        public void setrefadwgtkmcnot(String newValue){
              _refadwgtkmcnot = newValue;
         }
        private String _refbfsupA = "";
        public String getrefbfsupA(){
              return _refbfsupA;
         }
        public void setrefbfsupA(String newValue){
              _refbfsupA = newValue;
         }
        private String _refbfsupB = "";
        public String getrefbfsupB(){
              return _refbfsupB;
         }
        public void setrefbfsupB(String newValue){
              _refbfsupB = newValue;
         }
        private String _refbfsupC = "";
        public String getrefbfsupC(){
              return _refbfsupC;
         }
        public void setrefbfsupC(String newValue){
              _refbfsupC = newValue;
         }
        private String _refbfsupD = "";
        public String getrefbfsupD(){
              return _refbfsupD;
         }
        public void setrefbfsupD(String newValue){
              _refbfsupD = newValue;
         }
        private String _refbfsupE = "";
        public String getrefbfsupE(){
              return _refbfsupE;
         }
        public void setrefbfsupE(String newValue){
              _refbfsupE = newValue;
         }
        private String _refbfsupF = "";
        public String getrefbfsupF(){
              return _refbfsupF;
         }
        public void setrefbfsupF(String newValue){
              _refbfsupF = newValue;
         }
        private String _refbfsupFOth = "";
        public String getrefbfsupFOth(){
              return _refbfsupFOth;
         }
        public void setrefbfsupFOth(String newValue){
              _refbfsupFOth = newValue;
         }
        private String _refdisoutkmc = "";
        public String getrefdisoutkmc(){
              return _refdisoutkmc;
         }
        public void setrefdisoutkmc(String newValue){
              _refdisoutkmc = newValue;
         }
        private String _reftransPlace = "";
        public String getreftransPlace(){
              return _reftransPlace;
         }
        public void setreftransPlace(String newValue){
              _reftransPlace = newValue;
         }
        private String _refdodkmc = "";
        public String getrefdodkmc(){
              return _refdodkmc;
         }
        public void setrefdodkmc(String newValue){
              _refdodkmc = newValue;
         }

     private String _refdodkmcnot = "";
     public String getrefdodkmcnot(){
         return _refdodkmcnot;
     }
     public void setrefdodkmcnot(String newValue){
         _refdodkmcnot = newValue;
     }


        private String _refdiswgtkmc = "";
        public String getrefdiswgtkmc(){
              return _refdiswgtkmc;
         }
        public void setrefdiswgtkmc(String newValue){
              _refdiswgtkmc = newValue;
         }
        private String _regdiswgtkmcnot = "";
        public String getregdiswgtkmcnot(){
              return _regdiswgtkmcnot;
         }
        public void setregdiswgtkmcnot(String newValue){
              _regdiswgtkmcnot = newValue;
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

        String TableName = "KMC_DataExt";

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
                 SQL = "Insert into "+ TableName +" (CountryCode,FaciCode,DataID,refdoe,refabskmc,refabskmcOth,refmatname,refmatage,refmatid,refbname,refbid,refbsex,refdelivdate,refdelivdatenot,refbwgt,refbwgtnot,refgakmc,refgakmcnot,refbbornloc,refbbornOth,refdelivtime,refdelivtimenot,refdoadmkmc,refdoadmkmcnot,reftoadmkmc,reftoadmkmcnot,refadwgtkmc,refadwgtkmcnot,refbfsupA,refbfsupB,refbfsupC,refbfsupD,refbfsupE,refbfsupF,refbfsupFOth,refdisoutkmc,reftransPlace,refdodkmc,refdodkmcnot,refdiswgtkmc,regdiswgtkmcnot,status,reason,reasmention,StartTime,EndTime,DeviceID,EntryUser,Lat,Lon,EnDt,Upload,modifyDate)Values('"+ _CountryCode +"', '"+ _FaciCode +"', '"+ _DataID +"', '"+ _refdoe +"', '"+ _refabskmc +"', '"+ _refabskmcOth +"', '"+ _refmatname +"', '"+ _refmatage +"', '"+ _refmatid +"', '"+ _refbname +"', '"+ _refbid +"', '"+ _refbsex +"', '"+ _refdelivdate +"','"+ _refdelivdatenot +"', '"+ _refbwgt +"', '"+ _refbwgtnot +"', '"+ _refgakmc +"', '"+ _refgakmcnot +"', '"+ _refbbornloc +"', '"+ _refbbornOth +"', '"+ _refdelivtime +"','"+ _refdelivtimenot +"', '"+ _refdoadmkmc +"','"+ _refdoadmkmcnot +"', '"+ _reftoadmkmc +"','"+ _reftoadmkmcnot +"', '"+ _refadwgtkmc +"', '"+ _refadwgtkmcnot +"', '"+ _refbfsupA +"', '"+ _refbfsupB +"', '"+ _refbfsupC +"', '"+ _refbfsupD +"', '"+ _refbfsupE +"', '"+ _refbfsupF +"', '"+ _refbfsupFOth +"', '"+ _refdisoutkmc +"', '"+ _reftransPlace +"', '"+ _refdodkmc +"','"+ _refdodkmcnot +"', '"+ _refdiswgtkmc +"', '"+ _regdiswgtkmcnot +"','"+ _status +"','"+ _reason +"','"+ _reasmention +"', '"+ _StartTime +"', '"+ _EndTime +"', '"+ _DeviceID +"', '"+ _EntryUser +"', '"+ _Lat +"', '"+ _Lon +"', '"+ _EnDt +"', '"+ _Upload +"', '"+ _modifyDate +"')";
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
                 SQL = "Update "+ TableName +" Set Upload='2',modifyDate='" + _modifyDate + "' ,CountryCode = '"+ _CountryCode +"',FaciCode = '"+ _FaciCode +"',DataID = '"+ _DataID +"',refdoe = '"+ _refdoe +"',refabskmc = '"+ _refabskmc +"',refabskmcOth = '"+ _refabskmcOth +"',refmatname = '"+ _refmatname +"',refmatage = '"+ _refmatage +"',refmatid = '"+ _refmatid +"',refbname = '"+ _refbname +"',refbid = '"+ _refbid +"',refbsex = '"+ _refbsex +"',refdelivdate = '"+ _refdelivdate +"',refdelivdatenot='"+ _refdelivdatenot +"',refbwgt = '"+ _refbwgt +"',refbwgtnot = '"+ _refbwgtnot +"',refgakmc = '"+ _refgakmc +"',refgakmcnot = '"+ _refgakmcnot +"',refbbornloc = '"+ _refbbornloc +"',refbbornOth = '"+ _refbbornOth +"',refdelivtime = '"+ _refdelivtime +"',refdelivtimenot='"+ _refdelivtimenot +"',refdoadmkmc = '"+ _refdoadmkmc +"',refdoadmkmcnot='"+ _refdoadmkmcnot +"',reftoadmkmc = '"+ _reftoadmkmc +"',reftoadmkmcnot='"+ _reftoadmkmcnot +"',refadwgtkmc = '"+ _refadwgtkmc +"',refadwgtkmcnot = '"+ _refadwgtkmcnot +"',refbfsupA = '"+ _refbfsupA +"',refbfsupB = '"+ _refbfsupB +"',refbfsupC = '"+ _refbfsupC +"',refbfsupD = '"+ _refbfsupD +"',refbfsupE = '"+ _refbfsupE +"',refbfsupF = '"+ _refbfsupF +"',refbfsupFOth = '"+ _refbfsupFOth +"',refdisoutkmc = '"+ _refdisoutkmc +"',reftransPlace = '"+ _reftransPlace +"',refdodkmc = '"+ _refdodkmc +"',refdodkmcnot='"+ _refdodkmcnot +"',refdiswgtkmc = '"+ _refdiswgtkmc +"',regdiswgtkmcnot = '"+ _regdiswgtkmcnot +"',status='"+ _status +"',reason='"+ _reason +"',reasmention='"+ _reasmention +"'  Where CountryCode='"+ _CountryCode +"' and FaciCode='"+ _FaciCode +"' and DataID='"+ _DataID +"'";
                 C.Save(SQL);
                 C.close();
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }


        public List<KMC_DataExt_DataModel> SelectAll(Context context, String SQL)
        {
            Connection C = new Connection(context);
            List<KMC_DataExt_DataModel> data = new ArrayList<KMC_DataExt_DataModel>();
            KMC_DataExt_DataModel d = new KMC_DataExt_DataModel();
            Cursor cur = C.ReadData(SQL);

            cur.moveToFirst();
            while(!cur.isAfterLast())
            {
                d = new KMC_DataExt_DataModel();
                d._CountryCode = cur.getString(cur.getColumnIndex("CountryCode"));
                d._FaciCode = cur.getString(cur.getColumnIndex("FaciCode"));
                d._DataID = cur.getString(cur.getColumnIndex("DataID"));
                d._refdoe = cur.getString(cur.getColumnIndex("refdoe"));
                d._refabskmc = cur.getString(cur.getColumnIndex("refabskmc"));
                d._refabskmcOth = cur.getString(cur.getColumnIndex("refabskmcOth"));
                d._refmatname = cur.getString(cur.getColumnIndex("refmatname"));
                d._refmatage = cur.getString(cur.getColumnIndex("refmatage"));
                d._refmatid = cur.getString(cur.getColumnIndex("refmatid"));
                d._refbname = cur.getString(cur.getColumnIndex("refbname"));
                d._refbid = cur.getString(cur.getColumnIndex("refbid"));
                d._refbsex = cur.getString(cur.getColumnIndex("refbsex"));
                d._refdelivdate = cur.getString(cur.getColumnIndex("refdelivdate"));
                d._refdelivdatenot = cur.getString(cur.getColumnIndex("refdelivdatenot"));

                d._refbwgt = cur.getString(cur.getColumnIndex("refbwgt"));
                d._refbwgtnot = cur.getString(cur.getColumnIndex("refbwgtnot"));
                d._refgakmc = cur.getString(cur.getColumnIndex("refgakmc"));
                d._refgakmcnot = cur.getString(cur.getColumnIndex("refgakmcnot"));
                d._refbbornloc = cur.getString(cur.getColumnIndex("refbbornloc"));
                d._refbbornOth = cur.getString(cur.getColumnIndex("refbbornOth"));
                d._refdelivtime = cur.getString(cur.getColumnIndex("refdelivtime"));
                d._refdelivtimenot = cur.getString(cur.getColumnIndex("refdelivtimenot"));

                d._refdoadmkmc = cur.getString(cur.getColumnIndex("refdoadmkmc"));
                d._refdoadmkmcnot = cur.getString(cur.getColumnIndex("refdoadmkmcnot"));

                d._reftoadmkmc = cur.getString(cur.getColumnIndex("reftoadmkmc"));
                d._reftoadmkmcnot = cur.getString(cur.getColumnIndex("reftoadmkmcnot"));

                d._refadwgtkmc = cur.getString(cur.getColumnIndex("refadwgtkmc"));
                d._refadwgtkmcnot = cur.getString(cur.getColumnIndex("refadwgtkmcnot"));
                d._refbfsupA = cur.getString(cur.getColumnIndex("refbfsupA"));
                d._refbfsupB = cur.getString(cur.getColumnIndex("refbfsupB"));
                d._refbfsupC = cur.getString(cur.getColumnIndex("refbfsupC"));
                d._refbfsupD = cur.getString(cur.getColumnIndex("refbfsupD"));
                d._refbfsupE = cur.getString(cur.getColumnIndex("refbfsupE"));
                d._refbfsupF = cur.getString(cur.getColumnIndex("refbfsupF"));
                d._refbfsupFOth = cur.getString(cur.getColumnIndex("refbfsupFOth"));
                d._refdisoutkmc = cur.getString(cur.getColumnIndex("refdisoutkmc"));
                d._reftransPlace = cur.getString(cur.getColumnIndex("reftransPlace"));
                d._refdodkmc = cur.getString(cur.getColumnIndex("refdodkmc"));
                d._refdodkmcnot = cur.getString(cur.getColumnIndex("refdodkmcnot"));

                d._refdiswgtkmc = cur.getString(cur.getColumnIndex("refdiswgtkmc"));
                d._regdiswgtkmcnot = cur.getString(cur.getColumnIndex("regdiswgtkmcnot"));

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