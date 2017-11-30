package com.mimidai.entity;

import org.apache.solr.client.solrj.beans.Field;

import java.util.Date;

/**
 * 通话详单
 *
 * @author liang
 *
 */
public class SolrCallDetailsSimple {
    @Field
    private String id;
    @Field
    private Long userId;
    @Field
    private String phone;
    @Field
    private String otherPhone;
    /**
     * 第一次通话时间
     */
    @Field
    private String firstCall;
    /**
     * 最后一次通话时间
     */
    @Field
    private String lastCall;
    /**
     * 接听断电话次数
     */
    @Field
    private Integer inTimes;
    /**
     * 拨打电话次数
     */
    @Field
    private Integer outTimes;
    /**
     *接听断电话时长
     */
    @Field
    private Long inDuration;
    /**
     *拨打电话时长
     */
    @Field
    private Long outDuration;
    /**
     * 接听电话费用
     */
    @Field
    private Integer inFee;
    /**
     * 拨打电话费用
     */
    @Field
    private Integer outFee;
    /**
     * 通话次数
     */
    @Field
    private Integer allTimes;
    /**
     * 最后一次通话地址
     */
    @Field
    private String callLocation;
    /**
     * 通话类型
     */
    @Field
    private String commType;

    /**
     * 用来判断时间的标志位
     */
    private Date firstCallTime1;

    private Date LastCallTime1;


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

    public Integer getInFee() {
        return inFee;
    }

    public void setInFee(Integer inFee) {
        this.inFee = inFee;
    }

    public Integer getOutFee() {
        return outFee;
    }

    public void setOutFee(Integer outFee) {
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

    public String getFirstCall() {
        return firstCall;
    }

    public Date getFirstCallTime1() {
        return firstCallTime1;
    }

    public void setFirstCallTime1(Date firstCallTime1) {
        this.firstCallTime1 = firstCallTime1;
    }

    public Date getLastCallTime1() {
        return LastCallTime1;
    }

    public void setLastCallTime1(Date lastCallTime1) {
        LastCallTime1 = lastCallTime1;
    }

    public String getCommType() {
        return commType;
    }

    public void setCommType(String commType) {
        this.commType = commType;
    }
}
