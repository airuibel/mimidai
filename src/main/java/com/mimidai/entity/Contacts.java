package com.mimidai.entity;

/**
 * 运营商通话详单
 * Created by zhangyu on 2017/6/29.
 */
public class Contacts implements Comparable {
    private String id;
    private int userId;
    private String phone;
    private String otherPhone;
    private String firstCall;
    private String lastCall;
    private int inTimes;
    private int outTimes;
    private int inDuration;
    private int outDuration;
    private int inFee;
    private int outFee;
    private int allTimes;
    private String callLocation;
    private String commType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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

    public int getInTimes() {
        return inTimes;
    }

    public void setInTimes(int inTimes) {
        this.inTimes = inTimes;
    }

    public int getOutTimes() {
        return outTimes;
    }

    public void setOutTimes(int outTimes) {
        this.outTimes = outTimes;
    }

    public int getInDuration() {
        return inDuration;
    }

    public void setInDuration(int inDuration) {
        this.inDuration = inDuration;
    }

    public int getOutDuration() {
        return outDuration;
    }

    public void setOutDuration(int outDuration) {
        this.outDuration = outDuration;
    }

    public int getInFee() {
        return inFee;
    }

    public void setInFee(int inFee) {
        this.inFee = inFee;
    }

    public int getOutFee() {
        return outFee;
    }

    public void setOutFee(int outFee) {
        this.outFee = outFee;
    }

    public int getAllTimes() {
        return allTimes;
    }

    public void setAllTimes(int allTimes) {
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
    public int compareTo(Object o) {
        if (o instanceof Contacts) {
            return this.getAllTimes() - ((Contacts) o).getAllTimes();
        }
        return -1;
    }
}
