package com.mimidai.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * Created by zhangyu on 2017/8/21.
 */
public class DataUtil {
    public LocalDateTime dateDiff30(){
        LocalDateTime now = LocalDateTime.now();
        now = now.minus(30, ChronoUnit.DAYS);
        return now;
    }
    public static String minusOneday(Date today){
        SimpleDateFormat f =  new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try   {
            Date  d  =  new Date(today.getTime()-24*3600*1000);
            return  f.format(d);
        }
        catch(Exception ex) {
            return   "输入格式错误";
        }
    }
    public static String addOneday(Date today){
        SimpleDateFormat f =  new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try   {
            Date  d  =  new Date(today.getTime()+24*3600*1000);
            return  f.format(d);
        }
        catch(Exception ex) {
            return   "输入格式错误";
        }
    }
}
