package com.mystore.utility;

import java.util.logging.Logger;

public class Log {
    public static Logger log = Logger.getLogger(Log.class.getName());
    public static void startTestCase(String sStartTestName){
        log.info("============================" + sStartTestName + " Test Case has been Started =============================================");
    }
    public static void endTestCase(String sEndTestName){
        log.info("============================" + sEndTestName + " Test Case has been Ended =================================================");
    }

    public static void info(String message){
        log.info(message);

    }
    public static void warning(String message){
        log.warning(message);
    }
    public static void error(String message){
        log.warning(message);
    }
    public static void fatal(String message){
        log.warning(message);
    }
    public static void debug(String message){
        log.info(message);
    }
}
