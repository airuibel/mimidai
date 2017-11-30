package com.mimidai.entity;

import org.apache.solr.client.solrj.beans.Field;

import java.util.Date;

/**
 * @ClassName: UserPhoneContacts
 * @Description: 用户通讯录表
 * @author 李兴达
 * @date 2015年12月25日 上午10:14:01
 *
 */
public class UserPhoneContacts {
    @Field
    private String id;
    /**
     * @Fields userId :用户id
     */
    @Field
    private Long userId;
    /**
     * @Fields imei : 手机imei号
     */
    @Field
    private String imei;
    /**
     * @Fields imsi : 手机imsi号
     */
    @Field
    private String imsi;
    /**
     * @Fields phone : 联系人电话
     */
    @Field
    private String phone;
    /**
     * @Fields name : 名称
     */
    @Field
    private String name;
    /**
     * @Fields callTimes :通话次数
     */
    @Field
    private Long callTimes;
    /**
     * @Fields lastCall : 最后通话时间
     */
    @Field
    private Date lastCall;
    @Field
    private String version;

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

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCallTimes() {
        return callTimes;
    }

    public void setCallTimes(Long callTimes) {
        this.callTimes = callTimes;
    }

    public Date getLastCall() {
        return lastCall;
    }

    public void setLastCall(Date lastCall) {
        this.lastCall = lastCall;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
