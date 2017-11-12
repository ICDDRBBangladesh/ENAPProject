package org.icddrb.enap;

import android.content.Context;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;
 public class LD_DataExt_DataModel_old {

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
        private String _reftypebirth = "";
        public String getreftypebirth(){
              return _reftypebirth;
         }
        public void setreftypebirth(String newValue){
              _reftypebirth = newValue;
         }
        private String _refdelivdate = "";
        public String getrefdelivdate(){
              return _refdelivdate;
         }
        public void setrefdelivdate(String newValue){
              _refdelivdate = newValue;
         }
        private String _refdelivtime = "";
        public String getrefdelivtime(){
              return _refdelivtime;
         }
        public void setrefdelivtime(String newValue){
              _refdelivtime = newValue;
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
        private String _refbStatus = "";
        public String getrefbStatus(){
              return _refbStatus;
         }
        public void setrefbStatus(String newValue){
              _refbStatus = newValue;
         }
        private String _Refsbtype = "";
        public String getRefsbtype(){
              return _Refsbtype;
         }
        public void setRefsbtype(String newValue){
              _Refsbtype = newValue;
         }
        private String _refbsex = "";
        public String getrefbsex(){
              return _refbsex;
         }
        public void setrefbsex(String newValue){
              _refbsex = newValue;
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
        private String _refbstim = "";
        public String getrefbstim(){
              return _refbstim;
         }
        public void setrefbstim(String newValue){
              _refbstim = newValue;
         }
        private String _refbplast = "";
        public String getrefbplast(){
              return _refbplast;
         }
        public void setrefbplast(String newValue){
              _refbplast = newValue;
         }
        private String _refappcord = "";
        public String getrefappcord(){
              return _refappcord;
         }
        public void setrefappcord(String newValue){
              _refappcord = newValue;
         }
        private String _refbbfd = "";
        public String getrefbbfd(){
              return _refbbfd;
         }
        public void setrefbbfd(String newValue){
              _refbbfd = newValue;
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
        private String _refbcond = "";
        public String getrefbcond(){
              return _refbcond;
         }
        public void setrefbcond(String newValue){
              _refbcond = newValue;
         }
        private String _refdodld = "";
        public String getrefdodld(){
              return _refdodld;
         }
        public void setrefdodld(String newValue){
              _refdodld = newValue;
         }
        private String _reftodld = "";
        public String getreftodld(){
              return _reftodld;
         }
        public void setreftodld(String newValue){
              _reftodld = newValue;
         }
        private String _refdisoutld = "";
        public String getrefdisoutld(){
              return _refdisoutld;
         }
        public void setrefdisoutld(String newValue){
              _refdisoutld = newValue;
         }
        private String _refTransPlace = "";
        public String getrefTransPlace(){
              return _refTransPlace;
         }
        public void setrefTransPlace(String newValue){
              _refTransPlace = newValue;
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

        String TableName = "LD_DataExt_old";

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
                 SQL = "Insert into "+ TableName +" (CountryCode,FaciCode,DataID,refdoe,refgald,refgaldnot,refacsgiven,reftypebirth,refdelivdate,refdelivtime,refgacalc,refgacalcnot,refmedadeliv,refbStatus,Refsbtype,refbsex,refbwgt,refbwgtnot,refbstim,refbplast,refappcord,refbbfd,refpph,refpphnot,refretainplac,refbcond,refdodld,reftodld,refdisoutld,refTransPlace,refmatcond,refTransPlaceM,StartTime,EndTime,DeviceID,EntryUser,Lat,Lon,EnDt,Upload,modifyDate)Values('"+ _CountryCode +"', '"+ _FaciCode +"', '"+ _DataID +"', '"+ _refdoe +"', '"+ _refgald +"', '"+ _refgaldnot +"', '"+ _refacsgiven +"', '"+ _reftypebirth +"', '"+ _refdelivdate +"', '"+ _refdelivtime +"', '"+ _refgacalc +"', '"+ _refgacalcnot +"', '"+ _refmedadeliv +"', '"+ _refbStatus +"', '"+ _Refsbtype +"', '"+ _refbsex +"', '"+ _refbwgt +"', '"+ _refbwgtnot +"', '"+ _refbstim +"', '"+ _refbplast +"', '"+ _refappcord +"', '"+ _refbbfd +"', '"+ _refpph +"', '"+ _refpphnot +"', '"+ _refretainplac +"', '"+ _refbcond +"', '"+ _refdodld +"', '"+ _reftodld +"', '"+ _refdisoutld +"', '"+ _refTransPlace +"', '"+ _refmatcond +"', '"+ _refTransPlaceM +"', '"+ _StartTime +"', '"+ _EndTime +"', '"+ _DeviceID +"', '"+ _EntryUser +"', '"+ _Lat +"', '"+ _Lon +"', '"+ _EnDt +"', '"+ _Upload +"', '"+ _modifyDate +"')";
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
                 SQL = "Update "+ TableName +" Set Upload='2',modifyDate='" + _modifyDate + "' ,CountryCode = '"+ _CountryCode +"',FaciCode = '"+ _FaciCode +"',DataID = '"+ _DataID +"',refdoe = '"+ _refdoe +"',refgald = '"+ _refgald +"',refgaldnot = '"+ _refgaldnot +"',refacsgiven = '"+ _refacsgiven +"',reftypebirth = '"+ _reftypebirth +"',refdelivdate = '"+ _refdelivdate +"',refdelivtime = '"+ _refdelivtime +"',refgacalc = '"+ _refgacalc +"',refgacalcnot = '"+ _refgacalcnot +"',refmedadeliv = '"+ _refmedadeliv +"',refbStatus = '"+ _refbStatus +"',Refsbtype = '"+ _Refsbtype +"',refbsex = '"+ _refbsex +"',refbwgt = '"+ _refbwgt +"',refbwgtnot = '"+ _refbwgtnot +"',refbstim = '"+ _refbstim +"',refbplast = '"+ _refbplast +"',refappcord = '"+ _refappcord +"',refbbfd = '"+ _refbbfd +"',refpph = '"+ _refpph +"',refpphnot = '"+ _refpphnot +"',refretainplac = '"+ _refretainplac +"',refbcond = '"+ _refbcond +"',refdodld = '"+ _refdodld +"',reftodld = '"+ _reftodld +"',refdisoutld = '"+ _refdisoutld +"',refTransPlace = '"+ _refTransPlace +"',refmatcond = '"+ _refmatcond +"',refTransPlaceM = '"+ _refTransPlaceM +"'  Where CountryCode='"+ _CountryCode +"' and FaciCode='"+ _FaciCode +"' and DataID='"+ _DataID +"'";
                 C.Save(SQL);
                 C.close();
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }


        public List<LD_DataExt_DataModel_old> SelectAll(Context context, String SQL)
        {
            Connection C = new Connection(context);
            List<LD_DataExt_DataModel_old> data = new ArrayList<LD_DataExt_DataModel_old>();
            LD_DataExt_DataModel_old d = new LD_DataExt_DataModel_old();
            Cursor cur = C.ReadData(SQL);

            cur.moveToFirst();
            while(!cur.isAfterLast())
            {
                d = new LD_DataExt_DataModel_old();
                d._CountryCode = cur.getString(cur.getColumnIndex("CountryCode"));
                d._FaciCode = cur.getString(cur.getColumnIndex("FaciCode"));
                d._DataID = cur.getString(cur.getColumnIndex("DataID"));
                d._refdoe = cur.getString(cur.getColumnIndex("refdoe"));
                d._refgald = cur.getString(cur.getColumnIndex("refgald"));
                d._refgaldnot = cur.getString(cur.getColumnIndex("refgaldnot"));
                d._refacsgiven = cur.getString(cur.getColumnIndex("refacsgiven"));
                d._reftypebirth = cur.getString(cur.getColumnIndex("reftypebirth"));
                d._refdelivdate = cur.getString(cur.getColumnIndex("refdelivdate"));
                d._refdelivtime = cur.getString(cur.getColumnIndex("refdelivtime"));
                d._refgacalc = cur.getString(cur.getColumnIndex("refgacalc"));
                d._refgacalcnot = cur.getString(cur.getColumnIndex("refgacalcnot"));
                d._refmedadeliv = cur.getString(cur.getColumnIndex("refmedadeliv"));
                d._refbStatus = cur.getString(cur.getColumnIndex("refbStatus"));
                d._Refsbtype = cur.getString(cur.getColumnIndex("Refsbtype"));
                d._refbsex = cur.getString(cur.getColumnIndex("refbsex"));
                d._refbwgt = cur.getString(cur.getColumnIndex("refbwgt"));
                d._refbwgtnot = cur.getString(cur.getColumnIndex("refbwgtnot"));
                d._refbstim = cur.getString(cur.getColumnIndex("refbstim"));
                d._refbplast = cur.getString(cur.getColumnIndex("refbplast"));
                d._refappcord = cur.getString(cur.getColumnIndex("refappcord"));
                d._refbbfd = cur.getString(cur.getColumnIndex("refbbfd"));
                d._refpph = cur.getString(cur.getColumnIndex("refpph"));
                d._refpphnot = cur.getString(cur.getColumnIndex("refpphnot"));
                d._refretainplac = cur.getString(cur.getColumnIndex("refretainplac"));
                d._refbcond = cur.getString(cur.getColumnIndex("refbcond"));
                d._refdodld = cur.getString(cur.getColumnIndex("refdodld"));
                d._reftodld = cur.getString(cur.getColumnIndex("reftodld"));
                d._refdisoutld = cur.getString(cur.getColumnIndex("refdisoutld"));
                d._refTransPlace = cur.getString(cur.getColumnIndex("refTransPlace"));
                d._refmatcond = cur.getString(cur.getColumnIndex("refmatcond"));
                d._refTransPlaceM = cur.getString(cur.getColumnIndex("refTransPlaceM"));
                data.add(d);

                cur.moveToNext();
            }
            cur.close();
          return data;
        }
 }