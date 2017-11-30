package com.mimidai.entity;

/**
 * Created by zhangyu on 2017/7/26.
 */
public class TwoMonthContacts {
    private Integer allTimes;
    private Integer inTimes;
    private Integer outTimes;
    private String startTime;
    private Long userId;
    private String otherPhone;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOtherPhone() {
        return otherPhone;
    }

    public void setOtherPhone(String otherPhone) {
        this.otherPhone = otherPhone;
    }

    public Integer getAllTimes() {
        return allTimes;
    }

    public void setAllTimes(Integer allTimes) {
        this.allTimes = allTimes;
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
}
