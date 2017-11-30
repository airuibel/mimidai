package com.mimidai.entity.opdReportSjmh;

/**
 * @author GY
 * 2017年8月2日
 * 用户信息
 */
public class ReportUserInfo {

    private String real_name;
    private String identity_code;
    private String age;
    private String gender;
    private String constellation;
    private String hometown;
    private String email;
    private String home_addr;
    private String home_tel;
    private String work_addr;
    private String work_tel;
    private String company_name;
    
    
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
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getConstellation() {
        return constellation;
    }
    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }
    public String getHometown() {
        return hometown;
    }
    public void setHometown(String hometown) {
        this.hometown = hometown;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getHome_addr() {
        return home_addr;
    }
    public void setHome_addr(String home_addr) {
        this.home_addr = home_addr;
    }
    public String getHome_tel() {
        return home_tel;
    }
    public void setHome_tel(String home_tel) {
        this.home_tel = home_tel;
    }
    public String getWork_addr() {
        return work_addr;
    }
    public void setWork_addr(String work_addr) {
        this.work_addr = work_addr;
    }
    public String getWork_tel() {
        return work_tel;
    }
    public void setWork_tel(String work_tel) {
        this.work_tel = work_tel;
    }
    public String getCompany_name() {
        return company_name;
    }
    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }
    @Override
    public String toString() {
        return " ," + real_name + ", " + identity_code + ", " + age + ", " + gender + ", "
                + constellation + ", " + hometown + ", " + email + ", " + home_addr + ", "
                + home_tel + ", " + work_addr + ", " + work_tel + ", " + company_name;
    }
    
    
    
}
