package com.mimidai.entity.opdReportSjmh;

/**
 * Created by 孟庆艺 on 2017-08-03.
 */
public class ReportContinueSilenceDayOverCallMonthDetail {
    private String startDate;
    private String endDate;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return " ," + startDate + ", " + endDate;
    }
    
    
}
