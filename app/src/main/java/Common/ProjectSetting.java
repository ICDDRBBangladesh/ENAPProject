package Common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TanvirHossain on 19/07/2016.
 */
public class ProjectSetting {
    public static String ProjectName    = "ENAP";
    public static String Namespace      = "http://chu.icddrb.org/";

    public static String apiName        = ProjectName.toLowerCase();
    public static String NewVersionName = ProjectName.toLowerCase() +"_update";
    public static String DatabaseFolder = ProjectName.toUpperCase() +"DB";
    public static String DatabaseName   = ProjectName.toUpperCase() +"Database.db";
    public static String zipDatabaseName= ProjectName.toUpperCase() +"Database.zip";
    public static String Organization   = "ICDDR,B";

    //Country
    public static String BANGLADESH = "1";
    public static String NEPAL      = "2";
    public static String TANZANIA   = "3";


    //**********************************************************************************************
    public static String Country        = BANGLADESH;
    public static String VersionDate    = "27032017"; //Format: DDMMYYYY
    //**********************************************************************************************

    //Location
    public static String REGISTRATION_ID       = "1";
    public static String LABOR_AND_DELIVERY_ID = "2";
    public static String KMC_ID                = "3";
    public static String SEPSIS_ID             = "4";
    public static String ACS_ID                = "5";


    public static String REGISTRATION_NAME       = "REGISTRATION";
    public static String LABOR_AND_DELIVERY_NAME = "Labour and Delivery";
    public static String KMC_NAME                = "KMC";
    public static String SEPSIS_NAME             = "INFECTION";
    public static String ACS_NAME                = "ACS";

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
