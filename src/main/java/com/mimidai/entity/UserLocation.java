package com.mimidai.entity;

import org.apache.solr.client.solrj.beans.Field;

import java.util.Date;

/**
 * Created by 苦苦奋斗的渣渣 on 2017/5/12.
 */
public class UserLocation {

    private String id;
    @Field
    private Long userId;
    @Field
    private String address;
    @Field
    private Double lng;
    @Field
    private Double lat;
    @Field
    private String  createTime;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }


    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return  true;
        }
        if (!(obj instanceof UserLocation)) {
            return  false;
        }
        UserLocation other=(UserLocation)obj;
        if (this.getUserId().equals(other.getUserId())
                && this.getAddress().equals(other.getAddress())
                && this.getLng().equals(other.getLng())
                && this.getLat().equals(other.getLat())
                && this.getCreateTime().equals(other.getCreateTime())
                ){
            return true;
        }
        return false;
    }
}
