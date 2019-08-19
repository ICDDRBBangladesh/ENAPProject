package Common;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by Tanvir Hossain on 19/07/2016.
*/
public class ProjectSetting {
    public static String ProjectName    = "ENAP";

    public static String NewVersionName  = ProjectName.toLowerCase() +"_update";
    public static String DatabaseFolder  = ProjectName.toUpperCase() +"DB";
    public static String DatabaseName    = ProjectName.toUpperCase() +"Database.db";
    public static String zipDatabaseName = ProjectName.toUpperCase() +"Database.zip";
    public static String Organization    = "ICDDR,B";

    //Country
    public static String BANGLADESH = "1";
    public static String NEPAL      = "2";
    public static String TANZANIA   = "3";

    public static String COUNTRY_NAME_BANGLADESH = "Bangladesh";
    public static String COUNTRY_NAME_Nepal      = "Nepal";
    public static String COUNTRY_NAME_Tanzania   = "Tanzania";

    //Web Services
    //Development
    //**********************************************************************************************
    public static String ProjectTitle   = "";
    public static String apiName        = "enap_dev";
    public static String Namespace      = "http://chu.icddrb.org/";
    public static String Country        = BANGLADESH;
    public static Boolean MRS_Language_English = true;

    /*public static String ProjectTitle   = "QA Interview";
    public static String apiName        = "enap_dev_qa";
    public static String Namespace      = "http://chu.icddrb.org/";
    public static String Country        = BANGLADESH;
    public static Boolean MRS_Language_English = false;*/

    /*public static String ProjectTitle   = "Supervisor Interview";
    public static String apiName        = "enap_dev_sup";
    public static String Namespace      = "http://chu.icddrb.org/";
    public static String Country        = BANGLADESH;
    public static Boolean MRS_Language_English = false;*/

    //Bangladesh: Implemented - 16 May 2017
    //**********************************************************************************************
    /*public static String ProjectTitle   = "";
    public static String apiName        = "enap";
    public static String Namespace      = "http://chu.icddrb.org/";
    public static String Country        = BANGLADESH;
    public static Boolean MRS_Language_English = false;*/

    /*public static String ProjectTitle   = "QA Interview";
    public static String apiName        = "enap_qa";
    public static String Namespace      = "http://chu.icddrb.org/";
    public static String Country        = BANGLADESH;
    public static Boolean MRS_Language_English = false;*/


    /*public static String ProjectTitle   = "Supervisor Interview";
    public static String apiName        = "enap_sup";
    public static String Namespace      = "http://chu.icddrb.org/";
    public static String Country        = BANGLADESH;
    public static Boolean MRS_Language_English = false;*/

    //Nepal: Implemented - 18 May 2017
    //**********************************************************************************************
    /*public static String ProjectTitle   = "";
    public static String apiName        = "enap";
    //public static String Namespace      = "http://202.50.53.25/";
    //public static String Namespace      = "http://202.79.33.7/";
    public static String Namespace      = "http://124.41.211.77/";
    public static String Country        = NEPAL;
    public static Boolean MRS_Language_English = false;*/

    /*public static String ProjectTitle   = "QA Interview";
    public static String apiName        = "enap_qa";
    //public static String Namespace      = "http://202.50.53.25/";
    //public static String Namespace      = "http://202.79.33.7/";
    public static String Namespace      = "http://124.41.211.77/";
    public static String Country        = NEPAL;
    public static Boolean MRS_Language_English = false;*/

    /*public static String ProjectTitle   = "Supervisor Interview";
    public static String apiName        = "enap_sup";
    //public static String Namespace      = "http://202.50.53.25/";
    //public static String Namespace      = "http://202.79.33.7/";
    public static String Namespace      = "http://124.41.211.77/";
    public static String Country        = NEPAL;
    public static Boolean MRS_Language_English = false;*/

    //Tanzania: Implemented - 23 May 2017
    //**********************************************************************************************
    /*public static String ProjectTitle   = "";
    public static String apiName        = "enap";
    public static String Namespace      = "http://50.63.15.13/";
    public static String Country        = TANZANIA;
    public static Boolean MRS_Language_English = false;*/


    /*public static String ProjectTitle   = "QA Interview";
    public static String apiName        = "enap_qa";
    public static String Namespace      = "http://50.63.15.13/";
    public static String Country        = TANZANIA;
    public static Boolean MRS_Language_English = false;*/


    /*public static String ProjectTitle   = "Supervisor Interview";
    public static String apiName        = "enap_sup";
    public static String Namespace      = "http://50.63.15.13/";
    public static String Country        = TANZANIA;
    public static Boolean MRS_Language_English = false;*/

    //**********************************************************************************************
    public static String VersionDate    = "23112018"; //Format: DDMMYYYY
    //**********************************************************************************************

    //Location
    public static String REGISTRATION_ID       = "1";
    public static String LABOR_AND_DELIVERY_ID = "2";
    public static String KMC_ID                = "3";
    public static String SEPSIS_ID             = "4";
    public static String ACS_ID                = "5";
    public static String EXIT_INTERVIEW_ID     = "7";
    public static String DATA_EXTRACTION_ID    = "8";
    public static String SUPERUSER_ID          = "9";

    public static String REGISTRATION_NAME       = "REGISTRATION";
    public static String LABOR_AND_DELIVERY_NAME = "Labour and Delivery";
    public static String KMC_NAME                = "KMC";
    public static String SEPSIS_NAME             = "INFECTION";
    public static String ACS_NAME                = "ACS";
    public static String RECALLSURVEY_NAME       = "Recall Survey";
    public static String DATAEXTRACTION_NAME     = "Data Extraction";


    public static String REGISTRATION_SHORT_NAME       = "REGISTRATION";
    public static String LABOR_AND_DELIVERY_SHORT_NAME = "L & D";
    public static String KMC_SHORT_NAME                = "KMC";
    public static String SEPSIS_SHORT_NAME             = "INFXN";
    public static String ACS_SHORT_NAME                = "ACS";

    //Job Type
    public static String JT_REGISTRATION    = "1";
    public static String JT_OBSERVATION     = "2";
    public static String JT_EXIT_INTERVIEW  = "3";
    public static String JT_DATA_EXTRACTION = "4";
    public static String JT_VERIFICATION    = "5";
    public static String JT_ALL             = "6";
    public static String JT_All_WITHOUT_TRACKING = "7";
    public static String JT_All_WITHOUT_OBSERVATION_AND_TRACKING = "8";


    //Data Sync: Background Service
    //----------------------------------------------------------------------------------------------
    public static List<String> TableList_Upload(){
        List<String> tableList_Upload   = new ArrayList<String>();
        //tableList_Upload.add("");
        return tableList_Upload;
    }

    /*public static List<String> TableList_Download(){
        List<String> tableList_Download   = new ArrayList<String>();
        tableList_Download.add("");
        return tableList_Download;
    }*/
}
