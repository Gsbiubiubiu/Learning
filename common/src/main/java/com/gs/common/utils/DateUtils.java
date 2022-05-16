package com.gs.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @User远
 * @Date2022/5/9
 */
public class DateUtils {
    public static boolean judgmentDate(String tableTime, Integer hour) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d HH:mm:ss");
        Date start = sdf.parse(tableTime);//业务时间
//        Date end = sdf.parse(currentTime);//当前时间
        Date end = new Date(System.currentTimeMillis());//当前时间
        long cha = end.getTime() - start.getTime();
        if (cha < 0) {
            return false;
        }
        double result = cha * 1.0 / (1000 * 60 * 60);
        if (result <= 24) {
            return true;//是小于等于 hour 小时
        } else {
            return false;
        }

    }

}
