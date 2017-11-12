package org.icddrb.enap;

import android.content.Context;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;
 public class LD_Outcome_DataModel{

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
        private String _motcond = "";
        public String getmotcond(){
              return _motcond;
         }
        public void setmotcond(String newValue){
              _motcond = newValue;
         }
        private String _discdt = "";
        public String getdiscdt(){
              return _discdt;
         }
        public void setdiscdt(String newValue){
              _discdt = newValue;
         }
        private String _disctm = "";
        public String getdisctm(){
              return _disctm;
         }
        public void setdisctm(String newValue){
              _disctm = newValue;
         }
        private String _disctmdk = "";
        public String getdisctmdk(){
              return _disctmdk;
         }
        public void setdisctmdk(String newValue){
              _disctmdk = newValue;
         }
        private String _discto = "";
        public String getdiscto(){
              return _discto;
         }
        public void setdiscto(String newValue){
              _discto = newValue;
         }
        private String _disctooth = "";
        public String getdisctooth(){
              return _disctooth;
         }
        public void setdisctooth(String newValue){
              _disctooth = newValue;
         }
        private String _c1cond = "";
        public String getc1cond(){
              return _c1cond;
         }
        public void setc1cond(String newValue){
              _c1cond = newValue;
         }
        private String _c1deathdt = "";
        public String getc1deathdt(){
              return _c1deathdt;
         }
        public void setc1deathdt(String newValue){
              _c1deathdt = newValue;
         }
        private String _c1deathtm = "";
        public String getc1deathtm(){
              return _c1deathtm;
         }
        public void setc1deathtm(String newValue){
              _c1deathtm = newValue;
         }
        private String _c1deathdk = "";
        public String getc1deathdk(){
              return _c1deathdk;
         }
        public void setc1deathdk(String newValue){
              _c1deathdk = newValue;
         }
        private String _c1transto = "";
        public String getc1transto(){
              return _c1transto;
         }
        public void setc1transto(String newValue){
              _c1transto = newValue;
         }
        private String _c1transtooth = "";
        public String getc1transtooth(){
              return _c1transtooth;
         }
        public void setc1transtooth(String newValue){
              _c1transtooth = newValue;
         }
        private String _c1hospregno = "";
        public String getc1hospregno(){
              return _c1hospregno;
         }
        public void setc1hospregno(String newValue){
              _c1hospregno = newValue;
         }
        private String _c2cond = "";
        public String getc2cond(){
              return _c2cond;
         }
        public void setc2cond(String newValue){
              _c2cond = newValue;
         }
        private String _c2deathdt = "";
        public String getc2deathdt(){
              return _c2deathdt;
         }
        public void setc2deathdt(String newValue){
              _c2deathdt = newValue;
         }
        private String _c2deathtm = "";
        public String getc2deathtm(){
              return _c2deathtm;
         }
        public void setc2deathtm(String newValue){
              _c2deathtm = newValue;
         }
        private String _c2deathdk = "";
        public String getc2deathdk(){
              return _c2deathdk;
         }
        public void setc2deathdk(String newValue){
              _c2deathdk = newValue;
         }
        private String _c2transto = "";
        public String getc2transto(){
              return _c2transto;
         }
        public void setc2transto(String newValue){
              _c2transto = newValue;
         }
        private String _c2transtooth = "";
        public String getc2transtooth(){
              return _c2transtooth;
         }
        public void setc2transtooth(String newValue){
              _c2transtooth = newValue;
         }
        private String _c2hospregno = "";
        public String getc2hospregno(){
              return _c2hospregno;
         }
        public void setc2hospregno(String newValue){
              _c2hospregno = newValue;
         }
        private String _c3cond = "";
        public String getc3cond(){
              return _c3cond;
         }
        public void setc3cond(String newValue){
              _c3cond = newValue;
         }
        private String _c3deathdt = "";
        public String getc3deathdt(){
              return _c3deathdt;
         }
        public void setc3deathdt(String newValue){
              _c3deathdt = newValue;
         }
        private String _c3deathtm = "";
        public String getc3deathtm(){
              return _c3deathtm;
         }
        public void setc3deathtm(String newValue){
              _c3deathtm = newValue;
         }
        private String _c3deathdk = "";
        public String getc3deathdk(){
              return _c3deathdk;
         }
        public void setc3deathdk(String newValue){
              _c3deathdk = newValue;
         }
        private String _c3transto = "";
        public String getc3transto(){
              return _c3transto;
         }
        public void setc3transto(String newValue){
              _c3transto = newValue;
         }
        private String _c3transtooth = "";
        public String getc3transtooth(){
              return _c3transtooth;
         }
        public void setc3transtooth(String newValue){
              _c3transtooth = newValue;
         }
        private String _c3hospregno = "";
        public String getc3hospregno(){
              return _c3hospregno;
         }
        public void setc3hospregno(String newValue){
              _c3hospregno = newValue;
         }
        private String _objstatus = "";
        public String getobjstatus(){
              return _objstatus;
         }
        public void setobjstatus(String newValue){
              _objstatus = newValue;
         }
        private String _whyincom = "";
        public String getwhyincom(){
              return _whyincom;
         }
        public void setwhyincom(String newValue){
              _whyincom = newValue;
         }
        private String _reason = "";
        public String getreason(){
              return _reason;
         }
        public void setreason(String newValue){
              _reason = newValue;
         }
        private String _incirep = "";
        public String getincirep(){
              return _incirep;
         }
        public void setincirep(String newValue){
              _incirep = newValue;
         }
        private String _incident = "";
        public String getincident(){
              return _incident;
         }
        public void setincident(String newValue){
              _incident = newValue;
         }
        private String _inciformsl = "";
        public String getinciformsl(){
              return _inciformsl;
         }
        public void setinciformsl(String newValue){
              _inciformsl = newValue;
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

        String TableName = "LD_Outcome";

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
                 SQL = "Insert into "+ TableName +" (CountryCode,FaciCode,DataID,motcond,discdt,disctm,disctmdk,discto,disctooth,c1cond,c1deathdt,c1deathtm,c1deathdk,c1transto,c1transtooth,c1hospregno,c2cond,c2deathdt,c2deathtm,c2deathdk,c2transto,c2transtooth,c2hospregno,c3cond,c3deathdt,c3deathtm,c3deathdk,c3transto,c3transtooth,c3hospregno,objstatus,whyincom,reason,incirep,incident,inciformsl,StartTime,EndTime,DeviceID,EntryUser,Lat,Lon,EnDt,Upload,modifyDate)Values('"+ _CountryCode +"', '"+ _FaciCode +"', '"+ _DataID +"', '"+ _motcond +"', '"+ _discdt +"', '"+ _disctm +"', '"+ _disctmdk +"', '"+ _discto +"', '"+ _disctooth +"', '"+ _c1cond +"', '"+ _c1deathdt +"', '"+ _c1deathtm +"', '"+ _c1deathdk +"', '"+ _c1transto +"', '"+ _c1transtooth +"', '"+ _c1hospregno +"', '"+ _c2cond +"', '"+ _c2deathdt +"', '"+ _c2deathtm +"', '"+ _c2deathdk +"', '"+ _c2transto +"', '"+ _c2transtooth +"', '"+ _c2hospregno +"', '"+ _c3cond +"', '"+ _c3deathdt +"', '"+ _c3deathtm +"', '"+ _c3deathdk +"', '"+ _c3transto +"', '"+ _c3transtooth +"', '"+ _c3hospregno +"', '"+ _objstatus +"', '"+ _whyincom +"', '"+ _reason +"', '"+ _incirep +"', '"+ _incident +"', '"+ _inciformsl +"', '"+ _StartTime +"', '"+ _EndTime +"', '"+ _DeviceID +"', '"+ _EntryUser +"', '"+ _Lat +"', '"+ _Lon +"', '"+ _EnDt +"', '"+ _Upload +"', '"+ _modifyDate +"')";
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
                 SQL = "Update "+ TableName +" Set Upload='2',modifyDate='" + _modifyDate + "' ,CountryCode = '"+ _CountryCode +"',FaciCode = '"+ _FaciCode +"',DataID = '"+ _DataID +"',motcond = '"+ _motcond +"',discdt = '"+ _discdt +"',disctm = '"+ _disctm +"',disctmdk = '"+ _disctmdk +"',discto = '"+ _discto +"',disctooth = '"+ _disctooth +"',c1cond = '"+ _c1cond +"',c1deathdt = '"+ _c1deathdt +"',c1deathtm = '"+ _c1deathtm +"',c1deathdk = '"+ _c1deathdk +"',c1transto = '"+ _c1transto +"',c1transtooth = '"+ _c1transtooth +"',c1hospregno = '"+ _c1hospregno +"',c2cond = '"+ _c2cond +"',c2deathdt = '"+ _c2deathdt +"',c2deathtm = '"+ _c2deathtm +"',c2deathdk = '"+ _c2deathdk +"',c2transto = '"+ _c2transto +"',c2transtooth = '"+ _c2transtooth +"',c2hospregno = '"+ _c2hospregno +"',c3cond = '"+ _c3cond +"',c3deathdt = '"+ _c3deathdt +"',c3deathtm = '"+ _c3deathtm +"',c3deathdk = '"+ _c3deathdk +"',c3transto = '"+ _c3transto +"',c3transtooth = '"+ _c3transtooth +"',c3hospregno = '"+ _c3hospregno +"',objstatus = '"+ _objstatus +"',whyincom = '"+ _whyincom +"',reason = '"+ _reason +"',incirep = '"+ _incirep +"',incident = '"+ _incident +"',inciformsl = '"+ _inciformsl +"'  Where CountryCode='"+ _CountryCode +"' and FaciCode='"+ _FaciCode +"' and DataID='"+ _DataID +"'";
                 C.Save(SQL);
                 C.close();
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }


        public List<LD_Outcome_DataModel> SelectAll(Context context, String SQL)
        {
            Connection C = new Connection(context);
            List<LD_Outcome_DataModel> data = new ArrayList<LD_Outcome_DataModel>();
            LD_Outcome_DataModel d = new LD_Outcome_DataModel();
            Cursor cur = C.ReadData(SQL);

            cur.moveToFirst();
            while(!cur.isAfterLast())
            {
                d = new LD_Outcome_DataModel();
                d._CountryCode = cur.getString(cur.getColumnIndex("CountryCode"));
                d._FaciCode = cur.getString(cur.getColumnIndex("FaciCode"));
                d._DataID = cur.getString(cur.getColumnIndex("DataID"));
                d._motcond = cur.getString(cur.getColumnIndex("motcond"));
                d._discdt = cur.getString(cur.getColumnIndex("discdt"));
                d._disctm = cur.getString(cur.getColumnIndex("disctm"));
                d._disctmdk = cur.getString(cur.getColumnIndex("disctmdk"));
                d._discto = cur.getString(cur.getColumnIndex("discto"));
                d._disctooth = cur.getString(cur.getColumnIndex("disctooth"));
                d._c1cond = cur.getString(cur.getColumnIndex("c1cond"));
                d._c1deathdt = cur.getString(cur.getColumnIndex("c1deathdt"));
                d._c1deathtm = cur.getString(cur.getColumnIndex("c1deathtm"));
                d._c1deathdk = cur.getString(cur.getColumnIndex("c1deathdk"));
                d._c1transto = cur.getString(cur.getColumnIndex("c1transto"));
                d._c1transtooth = cur.getString(cur.getColumnIndex("c1transtooth"));
                d._c1hospregno = cur.getString(cur.getColumnIndex("c1hospregno"));
                d._c2cond = cur.getString(cur.getColumnIndex("c2cond"));
                d._c2deathdt = cur.getString(cur.getColumnIndex("c2deathdt"));
                d._c2deathtm = cur.getString(cur.getColumnIndex("c2deathtm"));
                d._c2deathdk = cur.getString(cur.getColumnIndex("c2deathdk"));
                d._c2transto = cur.getString(cur.getColumnIndex("c2transto"));
                d._c2transtooth = cur.getString(cur.getColumnIndex("c2transtooth"));
                d._c2hospregno = cur.getString(cur.getColumnIndex("c2hospregno"));
                d._c3cond = cur.getString(cur.getColumnIndex("c3cond"));
                d._c3deathdt = cur.getString(cur.getColumnIndex("c3deathdt"));
                d._c3deathtm = cur.getString(cur.getColumnIndex("c3deathtm"));
                d._c3deathdk = cur.getString(cur.getColumnIndex("c3deathdk"));
                d._c3transto = cur.getString(cur.getColumnIndex("c3transto"));
                d._c3transtooth = cur.getString(cur.getColumnIndex("c3transtooth"));
                d._c3hospregno = cur.getString(cur.getColumnIndex("c3hospregno"));
                d._objstatus = cur.getString(cur.getColumnIndex("objstatus"));
                d._whyincom = cur.getString(cur.getColumnIndex("whyincom"));
                d._reason = cur.getString(cur.getColumnIndex("reason"));
                d._incirep = cur.getString(cur.getColumnIndex("incirep"));
                d._incident = cur.getString(cur.getColumnIndex("incident"));
                d._inciformsl = cur.getString(cur.getColumnIndex("inciformsl"));
                data.add(d);

                cur.moveToNext();
            }
            cur.close();
          return data;
        }
 }