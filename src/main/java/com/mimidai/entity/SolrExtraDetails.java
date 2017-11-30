package com.mimidai.entity;

import org.apache.solr.client.solrj.beans.Field;

import java.util.Date;

/**
 * 敏感通话详单
 * SolrExtraDetails
 * @author liang
 *
 */
public class SolrExtraDetails {

    private Long userId;
    private String otherPhone;
    private Integer allTimes;

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
}
