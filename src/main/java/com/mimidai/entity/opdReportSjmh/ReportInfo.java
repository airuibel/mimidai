package com.mimidai.entity.opdReportSjmh;

/**
 * @author GY
 * 2017年8月2日
 * 报告信息
 */
public class ReportInfo {
    
    private String report_id;
    private String report_version;
    private String report_update_time;
    private String task_id;
    private String task_time;
    
    public String getReport_id() {
        return report_id;
    }
    public void setReport_id(String report_id) {
        this.report_id = report_id;
    }
    public String getReport_version() {
        return report_version;
    }
    public void setReport_version(String report_version) {
        this.report_version = report_version;
    }
    public String getReport_update_time() {
        return report_update_time;
    }
    public void setReport_update_time(String report_update_time) {
        this.report_update_time = report_update_time;
    }
    public String getTask_id() {
        return task_id;
    }
    public void setTask_id(String task_id) {
        this.task_id = task_id;
    }
    public String getTask_time() {
        return task_time;
    }
    public void setTask_time(String task_time) {
        this.task_time = task_time;
    }
    
    @Override
    public String toString() {
        return  report_id + ", " + report_version + ", " + report_update_time + ", "
                + task_id + ", " + task_time;
    }
    
}
