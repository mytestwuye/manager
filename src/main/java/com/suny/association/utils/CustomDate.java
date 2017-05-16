package com.suny.association.utils;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Comments:   时间日期类工具类
 * Author:   孙建荣
 * Create Date: 2017/03/19 13:57
 */
public class CustomDate {

    public static List<Object> getLastYearAndThisYears() {
        List<Object> yearList = new ArrayList<>();
        LocalDate localDate = LocalDate.now();
        int thisYear = localDate.getYear();
        int lastYear = thisYear - 1;
        yearList.add(0, thisYear);
        yearList.add(1, lastYear);
        return yearList;
    }


    public static Date getCurrentDateTime() {
        Date date = new Date();
        return new Timestamp(date.getTime());
    }

    public static Long formatStamp(Long stampTime) {
        Instant instant = Instant.ofEpochSecond(stampTime);
        Date date = Date.from(instant);
        return date.getTime();
    }
}




















