package com.examples.Log;

import java.util.logging.Logger;

public class Log4j {
    private static Logger logger = Logger.getLogger(String.valueOf(Log4j.class));

    public static Logger getLogger() {
        return logger;
    }

}


