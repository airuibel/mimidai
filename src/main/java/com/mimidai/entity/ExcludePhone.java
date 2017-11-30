package com.mimidai.entity;

import org.apache.catalina.Manager;

import java.util.Date;

@SuppressWarnings("serial")
public class ExcludePhone  {
    private String phone;
    private String name;
    private Long creatId;
    private Date creatTime;
    private String remark;
    private Date updateTime;
    private String state;

    public String getRemark() {
        return remark;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Long getCreatId() {
        return creatId;
    }

    public void setCreatId(Long creatId) {
        this.creatId = creatId;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    private Manager manager;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
