package org.icddrb.enap;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import Common.Connection;

public class Acs_Veri1_DataModel {

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
       private String _ParticipantID = "";
       public String getParticipantID(){
             return _ParticipantID;
        }
       public void setParticipantID(String newValue){
             _ParticipantID = newValue;
        }
       private String _matobsv = "";
       public String getmatobsv(){
             return _matobsv;
        }
       public void setmatobsv(String newValue){
             _matobsv = newValue;
        }
    private String _matname = "";
    public String getmatname(){
        return _matname;
    }
    public void setmatname(String newValue){
        _matname = newValue;
    }

    private String _crform = "";
    public String getcrform(){
        return _crform;
    }
    public void setcrform(String newValue){
        _crform = newValue;
    }


    private String _MoAge = "";
       public String getMoAge(){
             return _MoAge;
        }
       public void setMoAge(String newValue){
             _MoAge = newValue;
        }

    private String _MoAgeNot = "";
    public String getMoAgeNot(){
        return _MoAgeNot;
    }
    public void setMoAgeNot(String newValue){
        _MoAgeNot = newValue;
    }

       private String _matbdate = "";
       public String getmatbdate(){
             return _matbdate;
        }
       public void setmatbdate(String newValue){
             _matbdate = newValue;
        }

    private String _matbdateNot = "";
    public String getmatbdateNot(){
        return _matbdateNot;
    }
    public void setmatbdateNot(String newValue){
        _matbdateNot = newValue;
    }


       private String _gafirstds = "";
       public String getgafirstds(){
             return _gafirstds;
        }
       public void setgafirstds(String newValue){
             _gafirstds = newValue;
        }
       private String _matcondpremA = "";
       public String getmatcondpremA(){
             return _matcondpremA;
        }
       public void setmatcondpremA(String newValue){
             _matcondpremA = newValue;
        }

       private String _dtdgnmatcondA = "";
       public String getdtdgnmatcondA(){
             return _dtdgnmatcondA;
        }
       public void setdtdgnmatcondA(String newValue){
             _dtdgnmatcondA = newValue;
        }
        private String _dtdgnmatcondANot = "";
        public String getdtdgnmatcondANot(){
            return _dtdgnmatcondANot;
        }
        public void setdtdgnmatcondANot(String newValue){
            _dtdgnmatcondANot = newValue;
        }


       private String _tmdgnmatcondA = "";
       public String gettmdgnmatcondA(){
             return _tmdgnmatcondA;
        }
       public void settmdgnmatcondA(String newValue){
             _tmdgnmatcondA = newValue;
        }
    private String _tmdgnmatcondANot = "";
    public String gettmdgnmatcondANot(){
        return _tmdgnmatcondANot;
    }
    public void settmdgnmatcondANot(String newValue){
        _tmdgnmatcondANot = newValue;
    }

       private String _matcondpremB = "";
       public String getmatcondpremB(){
             return _matcondpremB;
        }
       public void setmatcondpremB(String newValue){
             _matcondpremB = newValue;
        }
       private String _dtdgnmatcondB = "";
       public String getdtdgnmatcondB(){
             return _dtdgnmatcondB;
        }
       public void setdtdgnmatcondB(String newValue){
             _dtdgnmatcondB = newValue;
        }

    private String _dtdgnmatcondBNot = "";
    public String getdtdgnmatcondBNot(){
        return _dtdgnmatcondBNot;
    }
    public void setdtdgnmatcondBNot(String newValue){
        _dtdgnmatcondBNot = newValue;
    }


    private String _tmdgnmatcondB = "";
       public String gettmdgnmatcondB(){
             return _tmdgnmatcondB;
        }
       public void settmdgnmatcondB(String newValue){
             _tmdgnmatcondB = newValue;
        }

    private String _tmdgnmatcondBNot = "";
    public String gettmdgnmatcondBNot(){
        return _tmdgnmatcondBNot;
    }
    public void settmdgnmatcondBNot(String newValue){
        _tmdgnmatcondBNot = newValue;
    }

    private String _matcondpremC = "";
       public String getmatcondpremC(){
             return _matcondpremC;
        }
       public void setmatcondpremC(String newValue){
             _matcondpremC = newValue;
        }
       private String _dtdgnmatcondC = "";
       public String getdtdgnmatcondC(){
             return _dtdgnmatcondC;
        }
       public void setdtdgnmatcondC(String newValue){
             _dtdgnmatcondC = newValue;
        }

    private String _dtdgnmatcondCNot = "";
    public String getdtdgnmatcondCNot(){
        return _dtdgnmatcondCNot;
    }
    public void setdtdgnmatcondCNot(String newValue){
        _dtdgnmatcondCNot = newValue;
    }


    private String _tmdgnmatcondC = "";
       public String gettmdgnmatcondC(){
             return _tmdgnmatcondC;
        }
       public void settmdgnmatcondC(String newValue){
             _tmdgnmatcondC = newValue;
        }

    private String _tmdgnmatcondCNot = "";
    public String gettmdgnmatcondCNot(){
        return _tmdgnmatcondCNot;
    }
    public void settmdgnmatcondCNot(String newValue){
        _tmdgnmatcondCNot = newValue;
    }

    private String _matcondpremD = "";
       public String getmatcondpremD(){
             return _matcondpremD;
        }
       public void setmatcondpremD(String newValue){
             _matcondpremD = newValue;
        }
       private String _dtdgnmatcondD = "";
       public String getdtdgnmatcondD(){
             return _dtdgnmatcondD;
        }
       public void setdtdgnmatcondD(String newValue){
             _dtdgnmatcondD = newValue;
        }
    private String _dtdgnmatcondDNot = "";
    public String getdtdgnmatcondDNot(){
        return _dtdgnmatcondDNot;
    }
    public void setdtdgnmatcondDNot(String newValue){
        _dtdgnmatcondDNot = newValue;
    }


       private String _tmdgnmatcondD = "";
       public String gettmdgnmatcondD(){
             return _tmdgnmatcondD;
        }
       public void settmdgnmatcondD(String newValue){
             _tmdgnmatcondD = newValue;
        }
    private String _tmdgnmatcondDNot = "";
    public String gettmdgnmatcondDNot(){
        return _tmdgnmatcondDNot;
    }
    public void settmdgnmatcondDNot(String newValue){
        _tmdgnmatcondDNot = newValue;
    }


       private String _matcondpremE = "";
       public String getmatcondpremE(){
             return _matcondpremE;
        }
       public void setmatcondpremE(String newValue){
             _matcondpremE = newValue;
        }
       private String _dtdgnmatcondE = "";
       public String getdtdgnmatcondE(){
             return _dtdgnmatcondE;
        }
       public void setdtdgnmatcondE(String newValue){
             _dtdgnmatcondE = newValue;
        }
       private String _tmdgnmatcondE = "";
       public String gettmdgnmatcondE(){
             return _tmdgnmatcondE;
        }
       public void settmdgnmatcondE(String newValue){
             _tmdgnmatcondE = newValue;
        }
       private String _matcondpremF = "";
       public String getmatcondpremF(){
             return _matcondpremF;
        }
       public void setmatcondpremF(String newValue){
             _matcondpremF = newValue;
        }
       private String _matcondpremOth = "";
       public String getmatcondpremOth(){
             return _matcondpremOth;
        }
       public void setmatcondpremOth(String newValue){
             _matcondpremOth = newValue;
        }
       private String _dtdgnmatcondF = "";
       public String getdtdgnmatcondF(){
             return _dtdgnmatcondF;
        }
       public void setdtdgnmatcondF(String newValue){
             _dtdgnmatcondF = newValue;
        }
    private String _dtdgnmatcondFNot = "";
    public String getdtdgnmatcondFNot(){
        return _dtdgnmatcondFNot;
    }
    public void setdtdgnmatcondFNot(String newValue){
        _dtdgnmatcondFNot = newValue;
    }


    private String _tmdgnmatcondF = "";
       public String gettmdgnmatcondF(){
             return _tmdgnmatcondF;
        }
       public void settmdgnmatcondF(String newValue){
             _tmdgnmatcondF = newValue;
        }
    private String _tmdgnmatcondFNot = "";
    public String gettmdgnmatcondFNot(){
        return _tmdgnmatcondFNot;
    }
    public void settmdgnmatcondFNot(String newValue){
        _tmdgnmatcondFNot = newValue;
    }


    private String _matcondpremG = "";
       public String getmatcondpremG(){
             return _matcondpremG;
        }
       public void setmatcondpremG(String newValue){
             _matcondpremG = newValue;
        }
       private String _matcondpremH = "";
       public String getmatcondpremH(){
             return _matcondpremH;
        }
       public void setmatcondpremH(String newValue){
             _matcondpremH = newValue;
        }
       private String _matinfA = "";
       public String getmatinfA(){
             return _matinfA;
        }
       public void setmatinfA(String newValue){
             _matinfA = newValue;
        }
       private String _matinfB = "";
       public String getmatinfB(){
             return _matinfB;
        }
       public void setmatinfB(String newValue){
             _matinfB = newValue;
        }
       private String _matinfC = "";
       public String getmatinfC(){
             return _matinfC;
        }
       public void setmatinfC(String newValue){
             _matinfC = newValue;
        }
       private String _matinfD = "";
       public String getmatinfD(){
             return _matinfD;
        }
       public void setmatinfD(String newValue){
             _matinfD = newValue;
        }
       private String _matinfE = "";
       public String getmatinfE(){
             return _matinfE;
        }
       public void setmatinfE(String newValue){
             _matinfE = newValue;
        }
       private String _matinfF = "";
       public String getmatinfF(){
             return _matinfF;
        }
       public void setmatinfF(String newValue){
             _matinfF = newValue;
        }
       private String _matinfG = "";
       public String getmatinfG(){
             return _matinfG;
        }
       public void setmatinfG(String newValue){
             _matinfG = newValue;
        }
       private String _matinfH = "";
       public String getmatinfH(){
             return _matinfH;
        }
       public void setmatinfH(String newValue){
             _matinfH = newValue;
        }
       private String _matinfI = "";
       public String getmatinfI(){
             return _matinfI;
        }
       public void setmatinfI(String newValue){
             _matinfI = newValue;
        }
       private String _matinfJ = "";
       public String getmatinfJ(){
             return _matinfJ;
        }
       public void setmatinfJ(String newValue){
             _matinfJ = newValue;
        }
       private String _matinfOth = "";
       public String getmatinfOth(){
             return _matinfOth;
        }
       public void setmatinfOth(String newValue){
             _matinfOth = newValue;
        }
       private String _dtdgnmatinf = "";
       public String getdtdgnmatinf(){
             return _dtdgnmatinf;
        }
       public void setdtdgnmatinf(String newValue){
             _dtdgnmatinf = newValue;
        }
    private String _dtdgnmatinfNot = "";
    public String getdtdgnmatinfNot(){
        return _dtdgnmatinfNot;
    }
    public void setdtdgnmatinfNot(String newValue){
        _dtdgnmatinfNot = newValue;
    }


    private String _tmdgnmatinf = "";
       public String gettmdgnmatinf(){
             return _tmdgnmatinf;
        }
       public void settmdgnmatinf(String newValue){
             _tmdgnmatinf = newValue;
        }
    private String _tmdgnmatinfNot = "";
    public String gettmdgnmatinfNot(){
        return _tmdgnmatinfNot;
    }
    public void settmdgnmatinfNot(String newValue){
        _tmdgnmatinfNot = newValue;
    }


       private String _matcoinfA = "";
       public String getmatcoinfA(){
             return _matcoinfA;
        }
       public void setmatcoinfA(String newValue){
             _matcoinfA = newValue;
        }
       private String _matcoinfB = "";
       public String getmatcoinfB(){
             return _matcoinfB;
        }
       public void setmatcoinfB(String newValue){
             _matcoinfB = newValue;
        }
       private String _matcoinfC = "";
       public String getmatcoinfC(){
             return _matcoinfC;
        }
       public void setmatcoinfC(String newValue){
             _matcoinfC = newValue;
        }
       private String _matcoinfD = "";
       public String getmatcoinfD(){
             return _matcoinfD;
        }
       public void setmatcoinfD(String newValue){
             _matcoinfD = newValue;
        }
       private String _matcoinfE = "";
       public String getmatcoinfE(){
             return _matcoinfE;
        }
       public void setmatcoinfE(String newValue){
             _matcoinfE = newValue;
        }
       private String _matcoinfF = "";
       public String getmatcoinfF(){
             return _matcoinfF;
        }
       public void setmatcoinfF(String newValue){
             _matcoinfF = newValue;
        }
       private String _matcoinfOth = "";
       public String getmatcoinfOth(){
             return _matcoinfOth;
        }
       public void setmatcoinfOth(String newValue){
             _matcoinfOth = newValue;
        }
       private String _matcoinftrtmnt = "";
       public String getmatcoinftrtmnt(){
             return _matcoinftrtmnt;
        }
       public void setmatcoinftrtmnt(String newValue){
             _matcoinftrtmnt = newValue;
        }
       private String _fetalaus = "";
       public String getfetalaus(){
             return _fetalaus;
        }
       public void setfetalaus(String newValue){
             _fetalaus = newValue;
        }
       private String _fetalausrate = "";
       public String getfetalausrate(){
             return _fetalausrate;
        }
       public void setfetalausrate(String newValue){
             _fetalausrate = newValue;
        }
       private String _fetalausOth = "";
       public String getfetalausOth(){
             return _fetalausOth;
        }
       public void setfetalausOth(String newValue){
             _fetalausOth = newValue;
        }
       private String _acsadm1 = "";
       public String getacsadm1(){
             return _acsadm1;
        }
       public void setacsadm1(String newValue){
             _acsadm1 = newValue;
        }
       private String _dtacs1 = "";
       public String getdtacs1(){
             return _dtacs1;
        }
       public void setdtacs1(String newValue){
             _dtacs1 = newValue;
        }

    private String _dtacs1Not = "";
    public String getdtacs1Not(){
        return _dtacs1Not;
    }
    public void setdtacs1Not(String newValue){
        _dtacs1Not = newValue;
    }


       private String _tmdtacs1 = "";
       public String gettmdtacs1(){
             return _tmdtacs1;
        }
       public void settmdtacs1(String newValue){
             _tmdtacs1 = newValue;
        }

    private String _tmdtacs1Not = "";
    public String gettmdtacs1Not(){
        return _tmdtacs1Not;
    }
    public void settmdtacs1Not(String newValue){
        _tmdtacs1Not = newValue;
    }

    private String _nameacs1 = "";
       public String getnameacs1(){
             return _nameacs1;
        }
       public void setnameacs1(String newValue){
             _nameacs1 = newValue;
        }
       private String _nameacs1Oth = "";
       public String getnameacs1Oth(){
             return _nameacs1Oth;
        }
       public void setnameacs1Oth(String newValue){
             _nameacs1Oth = newValue;
        }
       private String _acsdose1 = "";
       public String getacsdose1(){
             return _acsdose1;
        }
       public void setacsdose1(String newValue){
             _acsdose1 = newValue;
        }
       private String _acsdose1Oth = "";
       public String getacsdose1Oth(){
             return _acsdose1Oth;
        }
       public void setacsdose1Oth(String newValue){
             _acsdose1Oth = newValue;
        }
       private String _acsadm2 = "";
       public String getacsadm2(){
             return _acsadm2;
        }
       public void setacsadm2(String newValue){
             _acsadm2 = newValue;
        }
       private String _dtacsm2 = "";
       public String getdtacsm2(){
             return _dtacsm2;
        }
       public void setdtacsm2(String newValue){
             _dtacsm2 = newValue;
        }
    private String _dtacsm2Not = "";
    public String getdtacsm2Not(){
        return _dtacsm2Not;
    }
    public void setdtacsm2Not(String newValue){
        _dtacsm2Not = newValue;
    }


       private String _tmacsm2 = "";
       public String gettmacsm2(){
             return _tmacsm2;
        }
       public void settmacsm2(String newValue){
             _tmacsm2 = newValue;
        }
    private String _tmacsm2Not = "";
    public String gettmacsm2Not(){
        return _tmacsm2Not;
    }
    public void settmacsm2Not(String newValue){
        _tmacsm2Not = newValue;
    }


    private String _acsdose2 = "";
       public String getacsdose2(){
             return _acsdose2;
        }
       public void setacsdose2(String newValue){
             _acsdose2 = newValue;
        }
       private String _acsdose2Oth = "";
       public String getacsdose2Oth(){
             return _acsdose2Oth;
        }
       public void setacsdose2Oth(String newValue){
             _acsdose2Oth = newValue;
        }
       private String _acsadm3 = "";
       public String getacsadm3(){
             return _acsadm3;
        }
       public void setacsadm3(String newValue){
             _acsadm3 = newValue;
        }
       private String _dtacsadm3 = "";
       public String getdtacsadm3(){
             return _dtacsadm3;
        }
       public void setdtacsadm3(String newValue){
             _dtacsadm3 = newValue;
        }
    private String _dtacsadm3Not = "";
    public String getdtacsadm3Not(){
        return _dtacsadm3Not;
    }
    public void setdtacsadm3Not(String newValue){
        _dtacsadm3Not = newValue;
    }


        private String _tmacsadm3 = "";
       public String gettmacsadm3(){
             return _tmacsadm3;
        }
       public void settmacsadm3(String newValue){
             _tmacsadm3 = newValue;
        }
    private String _tmacsadm3Not = "";
    public String gettmacsadm3Not(){
        return _tmacsadm3Not;
    }
    public void settmacsadm3Not(String newValue){
        _tmacsadm3Not = newValue;
    }


       private String _acsdose3 = "";
       public String getacsdose3(){
             return _acsdose3;
        }
       public void setacsdose3(String newValue){
             _acsdose3 = newValue;
        }
       private String _acsdose3Oth = "";
       public String getacsdose3Oth(){
             return _acsdose3Oth;
        }
       public void setacsdose3Oth(String newValue){
             _acsdose3Oth = newValue;
        }
       private String _acsadm4 = "";
       public String getacsadm4(){
             return _acsadm4;
        }
       public void setacsadm4(String newValue){
             _acsadm4 = newValue;
        }
       private String _dtacsadm4 = "";
       public String getdtacsadm4(){
             return _dtacsadm4;
        }
       public void setdtacsadm4(String newValue){
             _dtacsadm4 = newValue;
        }
    private String _dtacsadm4Not = "";
    public String getdtacsadm4Not(){
        return _dtacsadm4Not;
    }
    public void setdtacsadm4Not(String newValue){
        _dtacsadm4Not = newValue;
    }


       private String _tmacsadm4 = "";
       public String gettmacsadm4(){
             return _tmacsadm4;
        }
       public void settmacsadm4(String newValue){
             _tmacsadm4 = newValue;
        }
    private String _tmacsadm4Not = "";
    public String gettmacsadm4Not(){
        return _tmacsadm4Not;
    }
    public void settmacsadm4Not(String newValue){
        _tmacsadm4Not = newValue;
    }


       private String _acsdose4 = "";
       public String getacsdose4(){
             return _acsdose4;
        }
       public void setacsdose4(String newValue){
             _acsdose4 = newValue;
        }
       private String _acsdose4Oth = "";
       public String getacsdose4Oth(){
             return _acsdose4Oth;
        }
       public void setacsdose4Oth(String newValue){
             _acsdose4Oth = newValue;
        }
       private String _acsfurther = "";
       public String getacsfurther(){
             return _acsfurther;
        }
       public void setacsfurther(String newValue){
             _acsfurther = newValue;
        }
       private String _dtacsfurther = "";
       public String getdtacsfurther(){
             return _dtacsfurther;
        }
       public void setdtacsfurther(String newValue){
             _dtacsfurther = newValue;
        }
    private String _dtacsfurtherNot = "";
    public String getdtacsfurtherNot(){
        return _dtacsfurtherNot;
    }
    public void setdtacsfurtherNot(String newValue){
        _dtacsfurtherNot = newValue;
    }


    private String _tmacsfurther = "";
       public String gettmacsfurther(){
             return _tmacsfurther;
        }
       public void settmacsfurther(String newValue){
             _tmacsfurther = newValue;
        }
    private String _tmacsfurtherNot = "";
    public String gettmacsfurtherNot(){
        return _tmacsfurtherNot;
    }
    public void settmacsfurtherNot(String newValue){
        _tmacsfurtherNot = newValue;
    }


       private String _acsdosefurther = "";
       public String getacsdosefurther(){
             return _acsdosefurther;
        }
       public void setacsdosefurther(String newValue){
             _acsdosefurther = newValue;
        }
       private String _acsdosefurtherOth = "";
       public String getacsdosefurtherOth(){
             return _acsdosefurtherOth;
        }
       public void setacsdosefurtherOth(String newValue){
             _acsdosefurtherOth = newValue;
        }
       private String _ga = "";
       public String getga(){
             return _ga;
        }
       public void setga(String newValue){
             _ga = newValue;
        }
       private String _gar = "";
       public String getgar(){
             return _gar;
        }
       public void setgar(String newValue){
             _gar = newValue;
        }
       private String _gamethod = "";
       public String getgamethod(){
             return _gamethod;
        }
       public void setgamethod(String newValue){
             _gamethod = newValue;
        }
       private String _gamethodr = "";
       public String getgamethodr(){
             return _gamethodr;
        }
       public void setgamethodr(String newValue){
             _gamethodr = newValue;
        }
       private String _bwt = "";
       public String getbwt(){
             return _bwt;
        }
       public void setbwt(String newValue){
             _bwt = newValue;
        }
       private String _bwtr = "";
       public String getbwtr(){
             return _bwtr;
        }
       public void setbwtr(String newValue){
             _bwtr = newValue;
        }
       private String _matcond = "";
       public String getmatcond(){
             return _matcond;
        }
       public void setmatcond(String newValue){
             _matcond = newValue;
        }
       private String _badm = "";
       public String getbadm(){
             return _badm;
        }
       public void setbadm(String newValue){
             _badm = newValue;
        }
       private String _bcond = "";
       public String getbcond(){
             return _bcond;
        }
       public void setbcond(String newValue){
             _bcond = newValue;
        }
       private String _stillbirthSp = "";
       public String getstillbirthSp(){
             return _stillbirthSp;
        }
       public void setstillbirthSp(String newValue){
             _stillbirthSp = newValue;
        }
       private String _dod = "";
       public String getdod(){
             return _dod;
        }
       public void setdod(String newValue){
             _dod = newValue;
        }
    private String _dodNot = "";
    public String getdodNot(){
        return _dodNot;
    }
    public void setdodNot(String newValue){
        _dodNot = newValue;
    }


    private String _deathtime = "";
       public String getdeathtime(){
             return _deathtime;
        }
       public void setdeathtime(String newValue){
             _deathtime = newValue;
        }

    private String _deathtimeNot = "";
    public String getdeathtimeNot(){
        return _deathtimeNot;
    }
    public void setdeathtimeNot(String newValue){
        _deathtimeNot = newValue;
    }

    private String _status = "";
       public String getstatus(){
             return _status;
        }
       public void setstatus(String newValue){
             _status = newValue;
        }
       private String _reason = "";
       public String getreason(){
             return _reason;
        }
       public void setreason(String newValue){
             _reason = newValue;
        }
       private String _reasmention = "";
       public String getreasmention(){
             return _reasmention;
        }
       public void setreasmention(String newValue){
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

       String TableName = "Acs_Veri";

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
                SQL = "Insert into "+ TableName +" (CountryCode,FaciCode,DataID,ParticipantID,matobsv,matname,crform,MoAge,MoAgeNot,matbdate,matbdateNot,gafirstds,matcondpremA,dtdgnmatcondA,dtdgnmatcondANot,tmdgnmatcondA,tmdgnmatcondANot,matcondpremB,dtdgnmatcondB,dtdgnmatcondBNot,tmdgnmatcondB,tmdgnmatcondBNot,matcondpremC,dtdgnmatcondC,dtdgnmatcondCNot,tmdgnmatcondC,tmdgnmatcondCNot,matcondpremD,dtdgnmatcondD,dtdgnmatcondDNot,tmdgnmatcondD,tmdgnmatcondDNot,matcondpremE,dtdgnmatcondE,tmdgnmatcondE,matcondpremF,matcondpremOth,dtdgnmatcondF,dtdgnmatcondFNot,tmdgnmatcondF,tmdgnmatcondFNot,matcondpremG,matcondpremH,matinfA,matinfB,matinfC,matinfD,matinfE,matinfF,matinfG,matinfH,matinfI,matinfJ,matinfOth,dtdgnmatinf,dtdgnmatinfNot,tmdgnmatinf,tmdgnmatinfNot,matcoinfA,matcoinfB,matcoinfC,matcoinfD,matcoinfE,matcoinfF,matcoinfOth,matcoinftrtmnt,fetalaus,fetalausrate,fetalausOth,acsadm1,dtacs1,dtacs1Not,tmdtacs1,tmdtacs1Not,nameacs1,nameacs1Oth,acsdose1,acsdose1Oth,acsadm2,dtacsm2,dtacsm2Not,tmacsm2,tmacsm2Not,acsdose2,acsdose2Oth,acsadm3,dtacsadm3,dtacsadm3Not,tmacsadm3,tmacsadm3Not,acsdose3,acsdose3Oth,acsadm4,dtacsadm4,dtacsadm4Not,tmacsadm4,tmacsadm4Not,acsdose4,acsdose4Oth,acsfurther,dtacsfurther,dtacsfurtherNot,tmacsfurther,tmacsfurtherNot,acsdosefurther,acsdosefurtherOth,ga,gar,gamethod,gamethodr,bwt,bwtr,matcond,badm,bcond,stillbirthSp,dod,dodNot,deathtime,deathtimeNot,status,reason,reasmention,StartTime,EndTime,DeviceID,EntryUser,Lat,Lon,EnDt,Upload,modifyDate)Values('"+ _CountryCode +"', '"+ _FaciCode +"', '"+ _DataID +"', '"+ _ParticipantID +"', '"+ _matobsv +"', '"+ _matname +"','"+ _crform +"', '"+ _MoAge +"','"+ _MoAgeNot +"', '"+ _matbdate +"','"+ _matbdateNot +"', '"+ _gafirstds +"', '"+ _matcondpremA +"', '"+ _dtdgnmatcondA +"','"+ _dtdgnmatcondANot +"', '"+ _tmdgnmatcondA +"','"+ _tmdgnmatcondANot +"', '"+ _matcondpremB +"', '"+ _dtdgnmatcondB +"','"+ _dtdgnmatcondBNot +"', '"+ _tmdgnmatcondB +"','"+ _tmdgnmatcondBNot +"', '"+ _matcondpremC +"', '"+ _dtdgnmatcondC +"','"+ _dtdgnmatcondCNot +"', '"+ _tmdgnmatcondC +"','"+ _tmdgnmatcondCNot +"', '"+ _matcondpremD +"', '"+ _dtdgnmatcondD +"','"+ _dtdgnmatcondDNot +"', '"+ _tmdgnmatcondD +"','"+ _tmdgnmatcondDNot +"', '"+ _matcondpremE +"', '"+ _dtdgnmatcondE +"', '"+ _tmdgnmatcondE +"', '"+ _matcondpremF +"', '"+ _matcondpremOth +"', '"+ _dtdgnmatcondF +"','"+ _dtdgnmatcondFNot +"', '"+ _tmdgnmatcondF +"','"+ _tmdgnmatcondFNot +"', '"+ _matcondpremG +"', '"+ _matcondpremH +"', '"+ _matinfA +"', '"+ _matinfB +"', '"+ _matinfC +"', '"+ _matinfD +"', '"+ _matinfE +"', '"+ _matinfF +"', '"+ _matinfG +"', '"+ _matinfH +"', '"+ _matinfI +"', '"+ _matinfJ +"', '"+ _matinfOth +"', '"+ _dtdgnmatinf +"','"+ _dtdgnmatinfNot +"', '"+ _tmdgnmatinf +"','"+ _tmdgnmatinfNot +"', '"+ _matcoinfA +"', '"+ _matcoinfB +"', '"+ _matcoinfC +"', '"+ _matcoinfD +"', '"+ _matcoinfE +"', '"+ _matcoinfF +"', '"+ _matcoinfOth +"', '"+ _matcoinftrtmnt +"', '"+ _fetalaus +"', '"+ _fetalausrate +"', '"+ _fetalausOth +"', '"+ _acsadm1 +"', '"+ _dtacs1 +"','"+ _dtacs1Not +"', '"+ _tmdtacs1 +"','"+ _tmdtacs1Not +"', '"+ _nameacs1 +"', '"+ _nameacs1Oth +"', '"+ _acsdose1 +"', '"+ _acsdose1Oth +"', '"+ _acsadm2 +"', '"+ _dtacsm2 +"','"+ _dtacsm2Not +"', '"+ _tmacsm2 +"','"+ _tmacsm2Not +"', '"+ _acsdose2 +"', '"+ _acsdose2Oth +"', '"+ _acsadm3 +"', '"+ _dtacsadm3 +"','"+ _dtacsadm3Not +"', '"+ _tmacsadm3 +"','"+ _tmacsadm3Not +"', '"+ _acsdose3 +"', '"+ _acsdose3Oth +"', '"+ _acsadm4 +"', '"+ _dtacsadm4 +"','"+ _dtacsadm4Not +"', '"+ _tmacsadm4 +"','"+ _tmacsadm4Not +"', '"+ _acsdose4 +"', '"+ _acsdose4Oth +"', '"+ _acsfurther +"', '"+ _dtacsfurther +"','"+ _dtacsfurtherNot +"', '"+ _tmacsfurther +"','"+ _tmacsfurtherNot +"', '"+ _acsdosefurther +"', '"+ _acsdosefurtherOth +"', '"+ _ga +"', '"+ _gar +"', '"+ _gamethod +"', '"+ _gamethodr +"', '"+ _bwt +"', '"+ _bwtr +"', '"+ _matcond +"', '"+ _badm +"', '"+ _bcond +"', '"+ _stillbirthSp +"', '"+ _dod +"','"+ _dodNot +"', '"+ _deathtime +"','"+ _deathtimeNot +"', '"+ _status +"', '"+ _reason +"', '"+ _reasmention +"', '"+ _StartTime +"', '"+ _EndTime +"', '"+ _DeviceID +"', '"+ _EntryUser +"', '"+ _Lat +"', '"+ _Lon +"', '"+ _EnDt +"', '"+ _Upload +"', '"+ _modifyDate +"')";
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
                SQL = "Update "+ TableName +" Set Upload='2',modifyDate='" + _modifyDate + "' ,CountryCode = '"+ _CountryCode +"',FaciCode = '"+ _FaciCode +"',DataID = '"+ _DataID +"',ParticipantID = '"+ _ParticipantID +"',matobsv = '"+ _matobsv +"',matname = '"+ _matname +"',crform='"+ _crform +"',MoAge = '"+ _MoAge +"',MoAgeNot='"+ _MoAgeNot +"',matbdate = '"+ _matbdate +"',matbdateNot='"+ _matbdateNot +"',gafirstds = '"+ _gafirstds +"',matcondpremA = '"+ _matcondpremA +"',dtdgnmatcondA = '"+ _dtdgnmatcondA +"',dtdgnmatcondANot='"+ _dtdgnmatcondANot +"',tmdgnmatcondA = '"+ _tmdgnmatcondA +"',tmdgnmatcondANot='"+ _tmdgnmatcondANot +"',matcondpremB = '"+ _matcondpremB +"',dtdgnmatcondB = '"+ _dtdgnmatcondB +"',dtdgnmatcondBNot='"+ _dtdgnmatcondBNot +"',tmdgnmatcondB = '"+ _tmdgnmatcondB +"',tmdgnmatcondBNot='"+ _tmdgnmatcondBNot +"',matcondpremC = '"+ _matcondpremC +"',dtdgnmatcondC = '"+ _dtdgnmatcondC +"',dtdgnmatcondCNot='"+ _dtdgnmatcondCNot +"',tmdgnmatcondC = '"+ _tmdgnmatcondC +"',tmdgnmatcondCNot='"+ _tmdgnmatcondCNot +"',matcondpremD = '"+ _matcondpremD +"',dtdgnmatcondD = '"+ _dtdgnmatcondD +"',dtdgnmatcondDNot='"+ _dtdgnmatcondDNot +"',tmdgnmatcondD = '"+ _tmdgnmatcondD +"',tmdgnmatcondDNot='"+ _tmdgnmatcondDNot +"',matcondpremE = '"+ _matcondpremE +"',dtdgnmatcondE = '"+ _dtdgnmatcondE +"',tmdgnmatcondE = '"+ _tmdgnmatcondE +"',matcondpremF = '"+ _matcondpremF +"',matcondpremOth = '"+ _matcondpremOth +"',dtdgnmatcondF = '"+ _dtdgnmatcondF +"',dtdgnmatcondFNot='"+ _dtdgnmatcondFNot +"',tmdgnmatcondF = '"+ _tmdgnmatcondF +"',tmdgnmatcondFNot='"+ _tmdgnmatcondFNot +"',matcondpremG = '"+ _matcondpremG +"',matcondpremH = '"+ _matcondpremH +"',matinfA = '"+ _matinfA +"',matinfB = '"+ _matinfB +"',matinfC = '"+ _matinfC +"',matinfD = '"+ _matinfD +"',matinfE = '"+ _matinfE +"',matinfF = '"+ _matinfF +"',matinfG = '"+ _matinfG +"',matinfH = '"+ _matinfH +"',matinfI = '"+ _matinfI +"',matinfJ = '"+ _matinfJ +"',matinfOth = '"+ _matinfOth +"',dtdgnmatinf = '"+ _dtdgnmatinf +"',dtdgnmatinfNot='"+ _dtdgnmatinfNot +"',tmdgnmatinf = '"+ _tmdgnmatinf +"',tmdgnmatinfNot='"+ _tmdgnmatinfNot +"',matcoinfA = '"+ _matcoinfA +"',matcoinfB = '"+ _matcoinfB +"',matcoinfC = '"+ _matcoinfC +"',matcoinfD = '"+ _matcoinfD +"',matcoinfE = '"+ _matcoinfE +"',matcoinfF = '"+ _matcoinfF +"',matcoinfOth = '"+ _matcoinfOth +"',matcoinftrtmnt = '"+ _matcoinftrtmnt +"',fetalaus = '"+ _fetalaus +"',fetalausrate = '"+ _fetalausrate +"',fetalausOth = '"+ _fetalausOth +"',acsadm1 = '"+ _acsadm1 +"',dtacs1 = '"+ _dtacs1 +"',dtacs1Not='"+ _dtacs1Not +"',tmdtacs1 = '"+ _tmdtacs1 +"',tmdtacs1Not='"+ _tmdtacs1Not +"',nameacs1 = '"+ _nameacs1 +"',nameacs1Oth = '"+ _nameacs1Oth +"',acsdose1 = '"+ _acsdose1 +"',acsdose1Oth = '"+ _acsdose1Oth +"',acsadm2 = '"+ _acsadm2 +"',dtacsm2 = '"+ _dtacsm2 +"',dtacsm2Not='"+ _dtacsm2Not +"',tmacsm2 = '"+ _tmacsm2 +"',tmacsm2Not='"+ _tmacsm2Not +"',acsdose2 = '"+ _acsdose2 +"',acsdose2Oth = '"+ _acsdose2Oth +"',acsadm3 = '"+ _acsadm3 +"',dtacsadm3 = '"+ _dtacsadm3 +"',dtacsadm3Not='"+ _dtacsadm3Not +"',tmacsadm3 = '"+ _tmacsadm3 +"',tmacsadm3Not='"+ _tmacsadm3Not +"',acsdose3 = '"+ _acsdose3 +"',acsdose3Oth = '"+ _acsdose3Oth +"',acsadm4 = '"+ _acsadm4 +"',dtacsadm4 = '"+ _dtacsadm4 +"',dtacsadm4Not='"+ _dtacsadm4Not +"',tmacsadm4 = '"+ _tmacsadm4 +"',tmacsadm4Not='"+ _tmacsadm4Not +"',acsdose4 = '"+ _acsdose4 +"',acsdose4Oth = '"+ _acsdose4Oth +"',acsfurther = '"+ _acsfurther +"',dtacsfurther = '"+ _dtacsfurther +"',dtacsfurtherNot='"+ _dtacsfurtherNot +"',tmacsfurther = '"+ _tmacsfurther +"',tmacsfurtherNot='"+ _tmacsfurtherNot +"',acsdosefurther = '"+ _acsdosefurther +"',acsdosefurtherOth = '"+ _acsdosefurtherOth +"',ga = '"+ _ga +"',gar = '"+ _gar +"',gamethod = '"+ _gamethod +"',gamethodr = '"+ _gamethodr +"',bwt = '"+ _bwt +"',bwtr = '"+ _bwtr +"',matcond = '"+ _matcond +"',badm = '"+ _badm +"',bcond = '"+ _bcond +"',stillbirthSp = '"+ _stillbirthSp +"',dod = '"+ _dod +"',dodNot='"+ _dodNot +"',deathtime = '"+ _deathtime +"',deathtimeNot='"+ _deathtimeNot +"',status = '"+ _status +"',reason = '"+ _reason +"',reasmention = '"+ _reasmention +"'  Where CountryCode='"+ _CountryCode +"' and FaciCode='"+ _FaciCode +"' and DataID='"+ _DataID +"'";
                 response = C.SaveData(SQL);
                C.close();
             }
             catch(Exception  e)
             {
                response = e.getMessage();
             }
          return response;
       }


       public List<Acs_Veri1_DataModel> SelectAll(Context context, String SQL)
       {
           Connection C = new Connection(context);
           List<Acs_Veri1_DataModel> data = new ArrayList<Acs_Veri1_DataModel>();
           Acs_Veri1_DataModel d = new Acs_Veri1_DataModel();
           Cursor cur = C.ReadData(SQL);

           cur.moveToFirst();
           while(!cur.isAfterLast())
           {
               d = new Acs_Veri1_DataModel();
               d._CountryCode = cur.getString(cur.getColumnIndex("CountryCode"));
               d._FaciCode = cur.getString(cur.getColumnIndex("FaciCode"));
               d._DataID = cur.getString(cur.getColumnIndex("DataID"));
               d._ParticipantID = cur.getString(cur.getColumnIndex("ParticipantID"));
               d._matobsv = cur.getString(cur.getColumnIndex("matobsv"));
               d._matname = cur.getString(cur.getColumnIndex("matname"));
               d._crform = cur.getString(cur.getColumnIndex("crform"));


               d._MoAge = cur.getString(cur.getColumnIndex("MoAge"));
               d._MoAgeNot = cur.getString(cur.getColumnIndex("MoAgeNot"));

               d._matbdate = cur.getString(cur.getColumnIndex("matbdate"));
               d._matbdateNot = cur.getString(cur.getColumnIndex("matbdateNot"));

               d._gafirstds = cur.getString(cur.getColumnIndex("gafirstds"));
               d._matcondpremA = cur.getString(cur.getColumnIndex("matcondpremA"));
               d._dtdgnmatcondA = cur.getString(cur.getColumnIndex("dtdgnmatcondA"));
               d._dtdgnmatcondANot = cur.getString(cur.getColumnIndex("dtdgnmatcondANot"));

               d._tmdgnmatcondA = cur.getString(cur.getColumnIndex("tmdgnmatcondA"));
               d._tmdgnmatcondANot = cur.getString(cur.getColumnIndex("tmdgnmatcondANot"));

               d._matcondpremB = cur.getString(cur.getColumnIndex("matcondpremB"));
               d._dtdgnmatcondB = cur.getString(cur.getColumnIndex("dtdgnmatcondB"));
               d._dtdgnmatcondBNot = cur.getString(cur.getColumnIndex("dtdgnmatcondBNot"));

               d._tmdgnmatcondB = cur.getString(cur.getColumnIndex("tmdgnmatcondB"));
               d._tmdgnmatcondBNot = cur.getString(cur.getColumnIndex("tmdgnmatcondBNot"));

               d._matcondpremC = cur.getString(cur.getColumnIndex("matcondpremC"));
               d._dtdgnmatcondC = cur.getString(cur.getColumnIndex("dtdgnmatcondC"));
               d._dtdgnmatcondCNot = cur.getString(cur.getColumnIndex("dtdgnmatcondCNot"));

               d._tmdgnmatcondC = cur.getString(cur.getColumnIndex("tmdgnmatcondC"));
               d._tmdgnmatcondCNot = cur.getString(cur.getColumnIndex("tmdgnmatcondCNot"));

               d._matcondpremD = cur.getString(cur.getColumnIndex("matcondpremD"));
               d._dtdgnmatcondD = cur.getString(cur.getColumnIndex("dtdgnmatcondD"));
               d._dtdgnmatcondDNot = cur.getString(cur.getColumnIndex("dtdgnmatcondDNot"));

               d._tmdgnmatcondD = cur.getString(cur.getColumnIndex("tmdgnmatcondD"));
               d._tmdgnmatcondDNot = cur.getString(cur.getColumnIndex("tmdgnmatcondDNot"));

               d._matcondpremE = cur.getString(cur.getColumnIndex("matcondpremE"));
               d._dtdgnmatcondE = cur.getString(cur.getColumnIndex("dtdgnmatcondE"));
               d._tmdgnmatcondE = cur.getString(cur.getColumnIndex("tmdgnmatcondE"));
               d._matcondpremF = cur.getString(cur.getColumnIndex("matcondpremF"));
               d._matcondpremOth = cur.getString(cur.getColumnIndex("matcondpremOth"));
               d._dtdgnmatcondF = cur.getString(cur.getColumnIndex("dtdgnmatcondF"));
               d._dtdgnmatcondFNot = cur.getString(cur.getColumnIndex("dtdgnmatcondFNot"));

               d._tmdgnmatcondF = cur.getString(cur.getColumnIndex("tmdgnmatcondF"));
               d._tmdgnmatcondFNot = cur.getString(cur.getColumnIndex("tmdgnmatcondFNot"));

               d._matcondpremG = cur.getString(cur.getColumnIndex("matcondpremG"));
               d._matcondpremH = cur.getString(cur.getColumnIndex("matcondpremH"));
               d._matinfA = cur.getString(cur.getColumnIndex("matinfA"));
               d._matinfB = cur.getString(cur.getColumnIndex("matinfB"));
               d._matinfC = cur.getString(cur.getColumnIndex("matinfC"));
               d._matinfD = cur.getString(cur.getColumnIndex("matinfD"));
               d._matinfE = cur.getString(cur.getColumnIndex("matinfE"));
               d._matinfF = cur.getString(cur.getColumnIndex("matinfF"));
               d._matinfG = cur.getString(cur.getColumnIndex("matinfG"));
               d._matinfH = cur.getString(cur.getColumnIndex("matinfH"));
               d._matinfI = cur.getString(cur.getColumnIndex("matinfI"));
               d._matinfJ = cur.getString(cur.getColumnIndex("matinfJ"));
               d._matinfOth = cur.getString(cur.getColumnIndex("matinfOth"));
               d._dtdgnmatinf = cur.getString(cur.getColumnIndex("dtdgnmatinf"));
               d._dtdgnmatinfNot = cur.getString(cur.getColumnIndex("dtdgnmatinfNot"));

               d._tmdgnmatinf = cur.getString(cur.getColumnIndex("tmdgnmatinf"));
               d._tmdgnmatinfNot = cur.getString(cur.getColumnIndex("tmdgnmatinfNot"));

               d._matcoinfA = cur.getString(cur.getColumnIndex("matcoinfA"));
               d._matcoinfB = cur.getString(cur.getColumnIndex("matcoinfB"));
               d._matcoinfC = cur.getString(cur.getColumnIndex("matcoinfC"));
               d._matcoinfD = cur.getString(cur.getColumnIndex("matcoinfD"));
               d._matcoinfE = cur.getString(cur.getColumnIndex("matcoinfE"));
               d._matcoinfF = cur.getString(cur.getColumnIndex("matcoinfF"));
               d._matcoinfOth = cur.getString(cur.getColumnIndex("matcoinfOth"));
               d._matcoinftrtmnt = cur.getString(cur.getColumnIndex("matcoinftrtmnt"));
               d._fetalaus = cur.getString(cur.getColumnIndex("fetalaus"));
               d._fetalausrate = cur.getString(cur.getColumnIndex("fetalausrate"));
               d._fetalausOth = cur.getString(cur.getColumnIndex("fetalausOth"));
               d._acsadm1 = cur.getString(cur.getColumnIndex("acsadm1"));
               d._dtacs1 = cur.getString(cur.getColumnIndex("dtacs1"));
               d._dtacs1Not = cur.getString(cur.getColumnIndex("dtacs1Not"));

               d._tmdtacs1 = cur.getString(cur.getColumnIndex("tmdtacs1"));
               d._tmdtacs1Not = cur.getString(cur.getColumnIndex("tmdtacs1Not"));

               d._nameacs1 = cur.getString(cur.getColumnIndex("nameacs1"));
               d._nameacs1Oth = cur.getString(cur.getColumnIndex("nameacs1Oth"));
               d._acsdose1 = cur.getString(cur.getColumnIndex("acsdose1"));
               d._acsdose1Oth = cur.getString(cur.getColumnIndex("acsdose1Oth"));
               d._acsadm2 = cur.getString(cur.getColumnIndex("acsadm2"));
               d._dtacsm2 = cur.getString(cur.getColumnIndex("dtacsm2"));
               d._dtacsm2Not = cur.getString(cur.getColumnIndex("dtacsm2Not"));

               d._tmacsm2 = cur.getString(cur.getColumnIndex("tmacsm2"));
               d._tmacsm2Not = cur.getString(cur.getColumnIndex("tmacsm2Not"));

               d._acsdose2 = cur.getString(cur.getColumnIndex("acsdose2"));
               d._acsdose2Oth = cur.getString(cur.getColumnIndex("acsdose2Oth"));
               d._acsadm3 = cur.getString(cur.getColumnIndex("acsadm3"));
               d._dtacsadm3 = cur.getString(cur.getColumnIndex("dtacsadm3"));
               d._dtacsadm3Not = cur.getString(cur.getColumnIndex("dtacsadm3Not"));

               d._tmacsadm3 = cur.getString(cur.getColumnIndex("tmacsadm3"));
               d._tmacsadm3Not = cur.getString(cur.getColumnIndex("tmacsadm3Not"));

               d._acsdose3 = cur.getString(cur.getColumnIndex("acsdose3"));
               d._acsdose3Oth = cur.getString(cur.getColumnIndex("acsdose3Oth"));
               d._acsadm4 = cur.getString(cur.getColumnIndex("acsadm4"));
               d._dtacsadm4 = cur.getString(cur.getColumnIndex("dtacsadm4"));
               d._dtacsadm4Not = cur.getString(cur.getColumnIndex("dtacsadm4Not"));

               d._tmacsadm4 = cur.getString(cur.getColumnIndex("tmacsadm4"));
               d._tmacsadm4Not = cur.getString(cur.getColumnIndex("tmacsadm4Not"));

               d._acsdose4 = cur.getString(cur.getColumnIndex("acsdose4"));
               d._acsdose4Oth = cur.getString(cur.getColumnIndex("acsdose4Oth"));
               d._acsfurther = cur.getString(cur.getColumnIndex("acsfurther"));
               d._dtacsfurther = cur.getString(cur.getColumnIndex("dtacsfurther"));
               d._dtacsfurtherNot = cur.getString(cur.getColumnIndex("dtacsfurtherNot"));

               d._tmacsfurther = cur.getString(cur.getColumnIndex("tmacsfurther"));
               d._tmacsfurtherNot = cur.getString(cur.getColumnIndex("tmacsfurtherNot"));

               d._acsdosefurther = cur.getString(cur.getColumnIndex("acsdosefurther"));
               d._acsdosefurtherOth = cur.getString(cur.getColumnIndex("acsdosefurtherOth"));
               d._ga = cur.getString(cur.getColumnIndex("ga"));
               d._gar = cur.getString(cur.getColumnIndex("gar"));
               d._gamethod = cur.getString(cur.getColumnIndex("gamethod"));
               d._gamethodr = cur.getString(cur.getColumnIndex("gamethodr"));
               d._bwt = cur.getString(cur.getColumnIndex("bwt"));
               d._bwtr = cur.getString(cur.getColumnIndex("bwtr"));
               d._matcond = cur.getString(cur.getColumnIndex("matcond"));
               d._badm = cur.getString(cur.getColumnIndex("badm"));
               d._bcond = cur.getString(cur.getColumnIndex("bcond"));
               d._stillbirthSp = cur.getString(cur.getColumnIndex("stillbirthSp"));
               d._dod = cur.getString(cur.getColumnIndex("dod"));
               d._dodNot = cur.getString(cur.getColumnIndex("dodNot"));

               d._deathtime = cur.getString(cur.getColumnIndex("deathtime"));
               d._deathtimeNot = cur.getString(cur.getColumnIndex("deathtimeNot"));

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