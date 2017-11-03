package com.rtc.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtils {
    private static Logger logger;
    public static void info(String s){
        logger=LoggerFactory.getLogger(LogUtils.class);
        logger.info(s);
    }
}
