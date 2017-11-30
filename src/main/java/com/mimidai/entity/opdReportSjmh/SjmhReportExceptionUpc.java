package com.mimidai.entity.opdReportSjmh;

import java.util.Date;

/**
 * @author GY
 * 2017年8月16日
 * 数据魔盒运营商报告获取异常单
 */
public class SjmhReportExceptionUpc {
    
    private Long id;
    private Long userId;
    private String phone;
    private String tid;
    private String handStatus;
    private Date updateTime;
    private Date createTime;
    
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getTid() {
        return tid;
    }
    public void setTid(String tid) {
        this.tid = tid;
    }
    public String getHandStatus() {
        return handStatus;
    }
    public void setHandStatus(String handStatus) {
        this.handStatus = handStatus;
    }
    public Date getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    
    
}
