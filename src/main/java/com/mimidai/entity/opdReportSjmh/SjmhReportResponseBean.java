package com.mimidai.entity.opdReportSjmh;


/**
 * @author GY
 * 2017年8月1日
 * 数据魔盒运营商认证报告返回最外层结构
 */
public class SjmhReportResponseBean {
    
    /**
     * 返回代码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String message;
    /**
     * 运营商认证任务id
     */
    private String task_id;
    /**
     * 报告具体数据 (指标数据)
     */
    private SjmhReportResultData data;
    
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getTask_id() {
        return task_id;
    }
    public void setTask_id(String task_id) {
        this.task_id = task_id;
    }
    public SjmhReportResultData getData() {
        return data;
    }
    public void setData(SjmhReportResultData data) {
        this.data = data;
    }
    
    
    
}
