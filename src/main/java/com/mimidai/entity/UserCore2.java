
package com.mimidai.entity;

import org.apache.solr.client.solrj.beans.Field;

import java.util.Date;


/**
 * Created by zhangyu on 2017/6/30.
 */

public class UserCore2 {
    @Field
    private String id;
    @Field
    private Long userId;
    @Field
    private String phone;
    @Field
    private String otherPhone;
    @Field
    private int callType;
    @Field
    private String startTime;

/**
     *拨打电话时长
     */

    @Field
    private Long duration;


    @Field
    private Integer fee;

    @Field
    private String commType;

    @Field
    private String callLocation;

/**
     * 通话类型
     */



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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOtherPhone() {
        return otherPhone;
    }

    public void setOtherPhone(String otherPhone) {
        this.otherPhone = otherPhone;
    }

    public int getCallType() {
        return callType;
    }

    public void setCallType(int callType) {
        this.callType = callType;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }

    public String getCallLocation() {
        return callLocation;
    }

    public void setCallLocation(String callLocation) {
        this.callLocation = callLocation;
    }

    public String getCommType() {
        return commType;
    }

    public void setCommType(String commType) {
        this.commType = commType;
    }
}

