package com.mimidai.entity;

/**
 * Created by zhangyu on 2017/8/16.
 */
public class Excel {
    private long userId;
    private String phone;
    private String state;
    private String otherPhone;
    private String OtherPhone2;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getOtherPhone() {
        return otherPhone;
    }

    public void setOtherPhone(String otherPhone) {
        this.otherPhone = otherPhone;
    }

    public String getOtherPhone2() {
        return OtherPhone2;
    }

    public void setOtherPhone2(String otherPhone2) {
        OtherPhone2 = otherPhone2;
    }
}
