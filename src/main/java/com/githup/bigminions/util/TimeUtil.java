package com.githup.bigminions.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by daren on 2017/2/16.
 */
public class TimeUtil {

    private static final String FORMAT = "yyyy-MM-dd hh:mm:ss";
    private static final String STR_FORMAT = "yyMMddhhmmssSSS";
    private static final String YEAR_AND_MONTH = "yyyyMM";

    public static String now() {
        LocalDateTime time = LocalDateTime.now();
        return time.format(DateTimeFormatter.ofPattern(FORMAT));
    }

    public static String nowStr() {
        LocalDateTime time = LocalDateTime.now();
        return time.format(DateTimeFormatter.ofPattern(STR_FORMAT));
    }

    /**
     * @return e.g 201703
     */
    public static String getYearAndMonth() {
        LocalDateTime time = LocalDateTime.now();
        return time.format(DateTimeFormatter.ofPattern(YEAR_AND_MONTH));
    }
}
