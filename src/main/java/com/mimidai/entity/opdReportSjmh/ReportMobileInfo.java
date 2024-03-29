package com.mimidai.entity.opdReportSjmh;

/**
 * @author GY
 * 2017年8月2日
 * 手机信息
 */
public class ReportMobileInfo {
    
    private String user_mobile;
    private String mobile_net_addr;
    private String mobile_carrier;
    private String real_name;
    private String identity_code;
    private String account_status;
    private String account_balance;
    private String mobile_net_time;
    private String mobile_net_age;
    private String email;
    private String contact_addr;
    
    public String getUser_mobile() {
        return user_mobile;
    }
    public void setUser_mobile(String user_mobile) {
        this.user_mobile = user_mobile;
    }
    public String getMobile_net_addr() {
        return mobile_net_addr;
    }
    public void setMobile_net_addr(String mobile_net_addr) {
        this.mobile_net_addr = mobile_net_addr;
    }
    public String getMobile_carrier() {
        return mobile_carrier;
    }
    public void setMobile_carrier(String mobile_carrier) {
        this.mobile_carrier = mobile_carrier;
    }
    public String getReal_name() {
        return real_name;
    }
    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }
    public String getIdentity_code() {
        return identity_code;
    }
    public void setIdentity_code(String identity_code) {
        this.identity_code = identity_code;
    }
    public String getAccount_status() {
        return account_status;
    }
    public void setAccount_status(String account_status) {
        this.account_status = account_status;
    }
    public String getAccount_balance() {
        return account_balance;
    }
    public void setAccount_balance(String account_balance) {
        this.account_balance = account_balance;
    }
    public String getMobile_net_time() {
        return mobile_net_time;
    }
    public void setMobile_net_time(String mobile_net_time) {
        this.mobile_net_time = mobile_net_time;
    }
    public String getMobile_net_age() {
        return mobile_net_age;
    }
    public void setMobile_net_age(String mobile_net_age) {
        this.mobile_net_age = mobile_net_age;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getContact_addr() {
        return contact_addr;
    }
    public void setContact_addr(String contact_addr) {
        this.contact_addr = contact_addr;
    }
    @Override
    public String toString() {
        return " ," + user_mobile + ", " + mobile_net_addr + ", " + mobile_carrier + ", "
                + real_name + ", " + identity_code + ", " + account_status + ", " + account_balance
                + ", " + mobile_net_time + ", " + mobile_net_age + ", " + email + ", "
                + contact_addr;
    }
    
    
}
