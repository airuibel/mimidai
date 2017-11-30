package com.mimidai.entity.opdReportSjmh;

/**
 * @author GY
 * 2017年8月2日
 * 每个月各类数据的完整性 实体类
 */
public class ReportDataCompletenessPerMonth {
    
    private String month;
    private String is_call_data_complete;
    private String is_msg_data_complete;
    private String is_consume_data_complete;
    
    public String getMonth() {
        return month;
    }
    public void setMonth(String month) {
        this.month = month;
    }
    public String getIs_call_data_complete() {
        return is_call_data_complete;
    }
    public void setIs_call_data_complete(String is_call_data_complete) {
        this.is_call_data_complete = is_call_data_complete;
    }
    public String getIs_msg_data_complete() {
        return is_msg_data_complete;
    }
    public void setIs_msg_data_complete(String is_msg_data_complete) {
        this.is_msg_data_complete = is_msg_data_complete;
    }
    public String getIs_consume_data_complete() {
        return is_consume_data_complete;
    }
    public void setIs_consume_data_complete(String is_consume_data_complete) {
        this.is_consume_data_complete = is_consume_data_complete;
    }
    @Override
    public String toString() {
        return " ," + month + ", " + is_call_data_complete + ", " + is_msg_data_complete + ", "
                + is_consume_data_complete;
    }
    
    
}
