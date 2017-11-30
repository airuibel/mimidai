package com.mimidai.entity.opdReportSjmh;

public class SjmhReportResponseZip {
    /**
     * 返回代码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String message;
    //压缩的字符串数据
    private String data;
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
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    
    
}
