package com.mimidai.entity.opdReportSjmh;

/**
 * @author GY
 * 2017年8月2日
 * 每个月联系人统计
 */
public class ReportAllContactStatsPerMonth {
    
    private String month;
    private String contact_count;
    private String contact_count_active;
    private String contact_count_passive;
    private String contact_count_mutual;
    private String contact_count_call_count_over10;
    private String call_count;
    private String call_count_active;
    private String call_count_passive;
    private String call_count_late_night;
    private String call_count_work_time;
    private String call_count_offwork_time;
    private String call_count_call_time_less1min;
    private String call_count_call_time_1min5min;
    private String call_count_call_time_5min10min;
    private String call_count_call_time_over10min;
    private String call_time;
    private String call_time_active;
    private String call_time_passive;
    private String msg_count;
    
    public String getMonth() {
        return month;
    }
    public void setMonth(String month) {
        this.month = month;
    }
    public String getContact_count() {
        return contact_count;
    }
    public void setContact_count(String contact_count) {
        this.contact_count = contact_count;
    }
    public String getContact_count_active() {
        return contact_count_active;
    }
    public void setContact_count_active(String contact_count_active) {
        this.contact_count_active = contact_count_active;
    }
    public String getContact_count_passive() {
        return contact_count_passive;
    }
    public void setContact_count_passive(String contact_count_passive) {
        this.contact_count_passive = contact_count_passive;
    }
    public String getContact_count_mutual() {
        return contact_count_mutual;
    }
    public void setContact_count_mutual(String contact_count_mutual) {
        this.contact_count_mutual = contact_count_mutual;
    }
    public String getContact_count_call_count_over10() {
        return contact_count_call_count_over10;
    }
    public void setContact_count_call_count_over10(String contact_count_call_count_over10) {
        this.contact_count_call_count_over10 = contact_count_call_count_over10;
    }
    public String getCall_count() {
        return call_count;
    }
    public void setCall_count(String call_count) {
        this.call_count = call_count;
    }
    public String getCall_count_active() {
        return call_count_active;
    }
    public void setCall_count_active(String call_count_active) {
        this.call_count_active = call_count_active;
    }
    public String getCall_count_passive() {
        return call_count_passive;
    }
    public void setCall_count_passive(String call_count_passive) {
        this.call_count_passive = call_count_passive;
    }
    public String getCall_count_late_night() {
        return call_count_late_night;
    }
    public void setCall_count_late_night(String call_count_late_night) {
        this.call_count_late_night = call_count_late_night;
    }
    public String getCall_count_work_time() {
        return call_count_work_time;
    }
    public void setCall_count_work_time(String call_count_work_time) {
        this.call_count_work_time = call_count_work_time;
    }
    public String getCall_count_offwork_time() {
        return call_count_offwork_time;
    }
    public void setCall_count_offwork_time(String call_count_offwork_time) {
        this.call_count_offwork_time = call_count_offwork_time;
    }
    public String getCall_count_call_time_less1min() {
        return call_count_call_time_less1min;
    }
    public void setCall_count_call_time_less1min(String call_count_call_time_less1min) {
        this.call_count_call_time_less1min = call_count_call_time_less1min;
    }
    public String getCall_count_call_time_1min5min() {
        return call_count_call_time_1min5min;
    }
    public void setCall_count_call_time_1min5min(String call_count_call_time_1min5min) {
        this.call_count_call_time_1min5min = call_count_call_time_1min5min;
    }
    public String getCall_count_call_time_5min10min() {
        return call_count_call_time_5min10min;
    }
    public void setCall_count_call_time_5min10min(String call_count_call_time_5min10min) {
        this.call_count_call_time_5min10min = call_count_call_time_5min10min;
    }
    public String getCall_count_call_time_over10min() {
        return call_count_call_time_over10min;
    }
    public void setCall_count_call_time_over10min(String call_count_call_time_over10min) {
        this.call_count_call_time_over10min = call_count_call_time_over10min;
    }
    public String getCall_time() {
        return call_time;
    }
    public void setCall_time(String call_time) {
        this.call_time = call_time;
    }
    public String getCall_time_active() {
        return call_time_active;
    }
    public void setCall_time_active(String call_time_active) {
        this.call_time_active = call_time_active;
    }
    public String getCall_time_passive() {
        return call_time_passive;
    }
    public void setCall_time_passive(String call_time_passive) {
        this.call_time_passive = call_time_passive;
    }
    public String getMsg_count() {
        return msg_count;
    }
    public void setMsg_count(String msg_count) {
        this.msg_count = msg_count;
    }
    @Override
    public String toString() {
        return " ," + month + ", " + contact_count + ", " + contact_count_active + ", "
                + contact_count_passive + ", " + contact_count_mutual + ", "
                + contact_count_call_count_over10 + ", " + call_count + ", " + call_count_active
                + ", " + call_count_passive + ", " + call_count_late_night + ", "
                + call_count_work_time + ", " + call_count_offwork_time + ", "
                + call_count_call_time_less1min + ", " + call_count_call_time_1min5min + ", "
                + call_count_call_time_5min10min + ", " + call_count_call_time_over10min + ", "
                + call_time + ", " + call_time_active + ", " + call_time_passive + ", " + msg_count;
    }
    
}
