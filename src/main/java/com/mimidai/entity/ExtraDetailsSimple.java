package com.mimidai.entity;

/**
 * 敏感电话
 * Created by zhangyu on 2017/8/15.
 */
public class ExtraDetailsSimple {
    private String id;
    private Long userId;
    private String phone;
    private String otherPhone;
    private String firstCall;
    private String lastCall;
    private Integer inTimes;
    private Integer outTimes;
    private Long inDuration;
    private Long outDuration;
    private Integer inFee;
    private Integer outFee;
    private Integer allTimes;
    private String callLocation;
    private String type;
    private String platform;
    private String commType;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
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
        if (!(obj instanceof ExtraDetailsSimple)) {
            return false;
        }
        ExtraDetailsSimple other = (ExtraDetailsSimple) obj;
        if (this.getUserId().equals(other.getUserId())
                && this.getOtherPhone().equals(other.getOtherPhone())) {
            return true;
        }
        return false;
    }
}
