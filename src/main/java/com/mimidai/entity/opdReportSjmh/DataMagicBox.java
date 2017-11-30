package com.mimidai.entity.opdReportSjmh;

import java.util.Date;

/**
 * @author GY
 * 2017年8月22日
 * 规则需要的 数据魔盒报告中的 相关字段
 */
public class DataMagicBox {
    
    private Long id;
    /**
     * 用户id
     */
    private Long user_id;
    /**
     * 入网时长
     */
    private String mobile_net_age;
    /**
     * 近3月深夜通话次数
     */
    private String call_count_late_night_3month;
    /**
     * 近6个月手机静默情况:0,频繁静默;1,正常静默;2,偶尔静默;3,从未静默;4,无数据
     */
    private String mobile_silence_analysis_6month;
    /**
     * 行状态:1,有效;0,无效
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date create_time;
    /**
     * 更新时间
     */
    private Date update_time;
    /**
     * 操作人
     */
    private String operator;
    
    
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getUser_id() {
        return user_id;
    }
    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
    public String getMobile_net_age() {
        return mobile_net_age;
    }
    public void setMobile_net_age(String mobile_net_age) {
        this.mobile_net_age = mobile_net_age;
    }
    public String getCall_count_late_night_3month() {
        return call_count_late_night_3month;
    }
    public void setCall_count_late_night_3month(String call_count_late_night_3month) {
        this.call_count_late_night_3month = call_count_late_night_3month;
    }
    public String getMobile_silence_analysis_6month() {
        return mobile_silence_analysis_6month;
    }
    public void setMobile_silence_analysis_6month(String mobile_silence_analysis_6month) {
        this.mobile_silence_analysis_6month = mobile_silence_analysis_6month;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public Date getCreate_time() {
        return create_time;
    }
    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
    public Date getUpdate_time() {
        return update_time;
    }
    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
    public String getOperator() {
        return operator;
    }
    public void setOperator(String operator) {
        this.operator = operator;
    }
    
    
    
}
