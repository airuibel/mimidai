package com.mimidai.entity.opdReportSjmh;

/**
 * @author GY
 * 2017年8月2日
 * 信息匹配
 */
public class ReportInfoMatch {

    //姓名是否与运营商数据匹配
    private String real_name_check_yys;
    //身份证号码是否与运营商数据匹配
    private String identity_code_check_yys;
    //家庭地址是否与运营商数据匹配
    private String home_addr_check_yys;
    //邮箱是否与运营商数据匹配
    private String email_check_yys;
    
    public String getReal_name_check_yys() {
        return real_name_check_yys;
    }
    public void setReal_name_check_yys(String real_name_check_yys) {
        this.real_name_check_yys = real_name_check_yys;
    }
    public String getIdentity_code_check_yys() {
        return identity_code_check_yys;
    }
    public void setIdentity_code_check_yys(String identity_code_check_yys) {
        this.identity_code_check_yys = identity_code_check_yys;
    }
    public String getHome_addr_check_yys() {
        return home_addr_check_yys;
    }
    public void setHome_addr_check_yys(String home_addr_check_yys) {
        this.home_addr_check_yys = home_addr_check_yys;
    }
    public String getEmail_check_yys() {
        return email_check_yys;
    }
    public void setEmail_check_yys(String email_check_yys) {
        this.email_check_yys = email_check_yys;
    }
    @Override
    public String toString() {
        return " ," + real_name_check_yys + ", " + identity_code_check_yys + ", "
                + home_addr_check_yys + ", " + email_check_yys;
    }
    
}
