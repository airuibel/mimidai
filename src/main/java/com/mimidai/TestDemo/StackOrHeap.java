package com.mimidai.TestDemo;

import com.mimidai.entity.Mobile;
import com.mimidai.utils.DataUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * Created by zhangyu on 2017/8/14.
 */
public class StackOrHeap {
    public static void main(String[] args) {
        Date endDate = new Date();
        Date startDate = new Date(endDate.getTime() - 30 * 24 * 60 * 60 * 1000);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date tempDate = null;
        try {
            tempDate = sdf.parse("2016-04-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(tempDate);
    }
}
