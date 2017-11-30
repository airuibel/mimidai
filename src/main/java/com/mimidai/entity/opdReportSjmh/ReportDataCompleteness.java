package com.mimidai.entity.opdReportSjmh;

import java.util.List;

/**
 * @author GY
 * 2017年8月2日
 * 数据完整性 实体类
 */
public class ReportDataCompleteness {
    
    private String is_call_data_complete_1month;
    private String is_call_data_complete_3month;
    private String is_call_data_complete_6month;
    private String is_msg_data_complete_1month;
    private String is_msg_data_complete_3month;
    private String is_msg_data_complete_6month;
    private String is_consume_data_complete_1month;
    private String is_consume_data_complete_3month;
    private String is_consume_data_complete_6month;
    /**
     * 每个月数据完整性
     */
    private List<ReportDataCompletenessPerMonth> data_completeness_per_month;
    
    public String getIs_call_data_complete_1month() {
        return is_call_data_complete_1month;
    }
    public void setIs_call_data_complete_1month(String is_call_data_complete_1month) {
        this.is_call_data_complete_1month = is_call_data_complete_1month;
    }
    public String getIs_call_data_complete_3month() {
        return is_call_data_complete_3month;
    }
    public void setIs_call_data_complete_3month(String is_call_data_complete_3month) {
        this.is_call_data_complete_3month = is_call_data_complete_3month;
    }
    public String getIs_call_data_complete_6month() {
        return is_call_data_complete_6month;
    }
    public void setIs_call_data_complete_6month(String is_call_data_complete_6month) {
        this.is_call_data_complete_6month = is_call_data_complete_6month;
    }
    public String getIs_msg_data_complete_1month() {
        return is_msg_data_complete_1month;
    }
    public void setIs_msg_data_complete_1month(String is_msg_data_complete_1month) {
        this.is_msg_data_complete_1month = is_msg_data_complete_1month;
    }
    public String getIs_msg_data_complete_3month() {
        return is_msg_data_complete_3month;
    }
    public void setIs_msg_data_complete_3month(String is_msg_data_complete_3month) {
        this.is_msg_data_complete_3month = is_msg_data_complete_3month;
    }
    public String getIs_msg_data_complete_6month() {
        return is_msg_data_complete_6month;
    }
    public void setIs_msg_data_complete_6month(String is_msg_data_complete_6month) {
        this.is_msg_data_complete_6month = is_msg_data_complete_6month;
    }
    public String getIs_consume_data_complete_1month() {
        return is_consume_data_complete_1month;
    }
    public void setIs_consume_data_complete_1month(String is_consume_data_complete_1month) {
        this.is_consume_data_complete_1month = is_consume_data_complete_1month;
    }
    public String getIs_consume_data_complete_3month() {
        return is_consume_data_complete_3month;
    }
    public void setIs_consume_data_complete_3month(String is_consume_data_complete_3month) {
        this.is_consume_data_complete_3month = is_consume_data_complete_3month;
    }
    public String getIs_consume_data_complete_6month() {
        return is_consume_data_complete_6month;
    }
    public void setIs_consume_data_complete_6month(String is_consume_data_complete_6month) {
        this.is_consume_data_complete_6month = is_consume_data_complete_6month;
    }
    public List<ReportDataCompletenessPerMonth> getData_completeness_per_month() {
        return data_completeness_per_month;
    }
    public void setData_completeness_per_month(
            List<ReportDataCompletenessPerMonth> data_completeness_per_month) {
        this.data_completeness_per_month = data_completeness_per_month;
    }
    @Override
    public String toString() {
        return " ," + is_call_data_complete_1month + ", " + is_call_data_complete_3month + ", "
                + is_call_data_complete_6month + ", " + is_msg_data_complete_1month + ", "
                + is_msg_data_complete_3month + ", " + is_msg_data_complete_6month + ", "
                + is_consume_data_complete_1month + ", " + is_consume_data_complete_3month + ", "
                + is_consume_data_complete_6month + ", " + data_completeness_per_month.get(0)+","
                + data_completeness_per_month.get(1);
    }
    
    
    
}
