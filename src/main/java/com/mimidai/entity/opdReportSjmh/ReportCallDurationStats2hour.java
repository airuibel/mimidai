package com.mimidai.entity.opdReportSjmh;

public class ReportCallDurationStats2hour {

    private ReportCallDuration call_duration_workday_3month;
    private ReportCallDuration call_duration_holiday_3month;
    private ReportCallDuration call_duration_workday_6month;
    private ReportCallDuration call_duration_holiday_6month;
    
    public ReportCallDuration getCall_duration_workday_3month() {
        return call_duration_workday_3month;
    }
    public void setCall_duration_workday_3month(ReportCallDuration call_duration_workday_3month) {
        this.call_duration_workday_3month = call_duration_workday_3month;
    }
    public ReportCallDuration getCall_duration_holiday_3month() {
        return call_duration_holiday_3month;
    }
    public void setCall_duration_holiday_3month(ReportCallDuration call_duration_holiday_3month) {
        this.call_duration_holiday_3month = call_duration_holiday_3month;
    }
    public ReportCallDuration getCall_duration_workday_6month() {
        return call_duration_workday_6month;
    }
    public void setCall_duration_workday_6month(ReportCallDuration call_duration_workday_6month) {
        this.call_duration_workday_6month = call_duration_workday_6month;
    }
    public ReportCallDuration getCall_duration_holiday_6month() {
        return call_duration_holiday_6month;
    }
    public void setCall_duration_holiday_6month(ReportCallDuration call_duration_holiday_6month) {
        this.call_duration_holiday_6month = call_duration_holiday_6month;
    }
    @Override
    public String toString() {
        return " ," + call_duration_workday_3month + ", " + call_duration_holiday_3month + ", "
                + call_duration_workday_6month + ", " + call_duration_holiday_6month;
    }
    
    
}
