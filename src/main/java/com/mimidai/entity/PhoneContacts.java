package com.mimidai.entity;


import org.apache.solr.client.solrj.beans.Field;

/**
 * 通话详单
 * Created by 苦苦奋斗的渣渣 on 2017/5/26.
 */
public class PhoneContacts {
    @Field
    private long id;
    @Field
    private Long userId;
    @Field
    private String phone;
    @Field
    private String otherPhone;
    @Field
    private String firstCall;
    @Field
    private String lastCall;
    @Field
    private Integer inTimes;
    @Field
    private Integer outTimes;
    @Field
    private Long inDuration;
    @Field
    private Long outDuration;
    @Field
    private Float inFee;
    @Field
    private Float outFee;
    @Field
    private Integer allTimes;
    @Field
    private String callLocation;
    @Field
    private String commType;


    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getFirstCall() {
        return firstCall;
    }

    public void setFirstCall(String firstCall) {
        this.firstCall = firstCall;
    }

    public String getLastCall() {
        return lastCall;
    }

    public void setLastCall(String lastCall) {
        this.lastCall = lastCall;
    }

    public Integer getInTimes() {
        return inTimes;
    }

    public void setInTimes(Integer inTimes) {
        this.inTimes = inTimes;
    }

    public Integer getOutTimes() {
        return outTimes;
    }

    public void setOutTimes(Integer outTimes) {
        this.outTimes = outTimes;
    }

    public Long getInDuration() {
        return inDuration;
    }

    public void setInDuration(Long inDuration) {
        this.inDuration = inDuration;
    }

    public Long getOutDuration() {
        return outDuration;
    }

    public void setOutDuration(Long outDuration) {
        this.outDuration = outDuration;
    }

    public Float getInFee() {
        return inFee;
    }

    public void setInFee(Float inFee) {
        this.inFee = inFee;
    }

    public Float getOutFee() {
        return outFee;
    }

    public void setOutFee(Float outFee) {
        this.outFee = outFee;
    }

    public Integer getAllTimes() {
        return allTimes;
    }

    public void setAllTimes(Integer allTimes) {
        this.allTimes = allTimes;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PhoneContacts)) {
            return false;
        }
        PhoneContacts other = (PhoneContacts) obj;
        if (this.getUserId().equals(other.getUserId())
                && this.getOtherPhone().equals(other.getOtherPhone())) {
            return true;
        }
        return false;
    }
}
