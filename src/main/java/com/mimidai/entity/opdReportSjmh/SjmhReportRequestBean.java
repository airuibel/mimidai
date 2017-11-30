package com.mimidai.entity.opdReportSjmh;

import java.io.Serializable;
import java.util.Date;

/**
 * @author GY
 * 2017年8月1日
 * 运营商 数据魔盒 运营商认证报告 获取 请求 bean
 */
public class SjmhReportRequestBean implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    //报告获取状态
    private String status;
    //开始获取报告时间
    private Long StartDeliverTime;
        
    /**
     * 必填 授权爬取任务的任务编号
     */
    private String task_id;
    //运营商认证用户
    private Long user_id;
    //运营商认证电话
    private String phone;
    //认证成功时间
    private Date doneTime;
    /**
     * 可选 真实姓名
     */
    private String real_name;
    //可选 身份证号码。18位和15位数字，末尾是数字或X
    private String identity_code;
    //邮箱
    private String email;
    //家庭住址
    private String home_addr;
    //家庭手机号
    private String home_tel;
    //工作地址
    private String work_addr;
    //工作电话
    private String work_tel;
    //工作单位
    private String company_name;
    //联系人1姓名
    private String contact1_name;
    //关系
    private String contact1_relation;
    //电话
    private String contact1_mobile;
    private String contact2_name;
    private String contact2_relation;
    private String contact2_mobile;
    private String contact3_name;
    private String contact3_relation;
    private String contact3_mobile;
    private String contact4_name;
    private String contact4_relation;
    private String contact4_mobile;
    private String contact5_name;
    private String contact5_relation;
    private String contact5_mobile;
    
    
    public String getTask_id() {
        return task_id;
    }
    public void setTask_id(String task_id) {
        this.task_id = task_id;
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
    public String getContact1_name() {
        return contact1_name;
    }
    public void setContact1_name(String contact1_name) {
        this.contact1_name = contact1_name;
    }
    public String getContact1_relation() {
        return contact1_relation;
    }
    public void setContact1_relation(String contact1_relation) {
        this.contact1_relation = contact1_relation;
    }
    public String getContact1_mobile() {
        return contact1_mobile;
    }
    public void setContact1_mobile(String contact1_mobile) {
        this.contact1_mobile = contact1_mobile;
    }
    public String getContact2_name() {
        return contact2_name;
    }
    public void setContact2_name(String contact2_name) {
        this.contact2_name = contact2_name;
    }
    public String getContact2_relation() {
        return contact2_relation;
    }
    public void setContact2_relation(String contact2_relation) {
        this.contact2_relation = contact2_relation;
    }
    public String getContact2_mobile() {
        return contact2_mobile;
    }
    public void setContact2_mobile(String contact2_mobile) {
        this.contact2_mobile = contact2_mobile;
    }
    public String getContact3_name() {
        return contact3_name;
    }
    public void setContact3_name(String contact3_name) {
        this.contact3_name = contact3_name;
    }
    public String getContact3_relation() {
        return contact3_relation;
    }
    public void setContact3_relation(String contact3_relation) {
        this.contact3_relation = contact3_relation;
    }
    public String getContact3_mobile() {
        return contact3_mobile;
    }
    public void setContact3_mobile(String contact3_mobile) {
        this.contact3_mobile = contact3_mobile;
    }
    public String getContact4_name() {
        return contact4_name;
    }
    public void setContact4_name(String contact4_name) {
        this.contact4_name = contact4_name;
    }
    public String getContact4_relation() {
        return contact4_relation;
    }
    public void setContact4_relation(String contact4_relation) {
        this.contact4_relation = contact4_relation;
    }
    public String getContact4_mobile() {
        return contact4_mobile;
    }
    public void setContact4_mobile(String contact4_mobile) {
        this.contact4_mobile = contact4_mobile;
    }
    public String getContact5_name() {
        return contact5_name;
    }
    public void setContact5_name(String contact5_name) {
        this.contact5_name = contact5_name;
    }
    public String getContact5_relation() {
        return contact5_relation;
    }
    public void setContact5_relation(String contact5_relation) {
        this.contact5_relation = contact5_relation;
    }
    public String getContact5_mobile() {
        return contact5_mobile;
    }
    public void setContact5_mobile(String contact5_mobile) {
        this.contact5_mobile = contact5_mobile;
    }
    public Long getUser_id() {
        return user_id;
    }
    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Date getDoneTime() {
        return doneTime;
    }
    public void setDoneTime(Date doneTime) {
        this.doneTime = doneTime;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Long getStartDeliverTime() {
        return StartDeliverTime;
    }
    public void setStartDeliverTime(Long startDeliverTime) {
        StartDeliverTime = startDeliverTime;
    }
    
}
