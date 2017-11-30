package com.mimidai.entity;

import java.util.Date;

import org.apache.solr.client.solrj.beans.Field;

/**
 * 用户通讯录
 * Created by 苦苦奋斗的渣渣 on 2017/5/26.
 */
public class PhoneTon {
    @Field
    private String id;
    @Field
    private Long userId;
    @Field
    private String imei;
    @Field
    private String imsi;
    @Field
    private String phone;
    @Field
    private String name;
    @Field
    private Long callTimes;
    @Field
    private String lastCall;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

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

    public Long getCallTimes() {
        return callTimes;
    }

    public void setCallTimes(Long callTimes) {
        this.callTimes = callTimes;
    }

    public String getLastCall() {
        return lastCall;
    }

    public void setLastCall(String lastCall) {
        this.lastCall = lastCall;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PhoneTon)) {
            return false;
        }
        PhoneTon other = (PhoneTon) obj;
        if (this.getUserId().equals(other.getUserId())
                && this.getPhone().equals(other.getPhone())
                && this.getName().equals(other.getName())) {
            return true;
        }
        return false;
    }
}
