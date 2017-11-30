package com.mimidai.entity;

import java.util.Date;

import lombok.Data;

/**
 * 用户设备表
 * 
 * @author liang
 *
 */
@Data
public class UserDevice {

	private int id;
	private Long userId;
	private String imei;
	private String imsi;
	private String model;
	private String brand;
	private String idfa;
	private Date createTime;
	private Long loginCount;
	private Date updateTime;
	

}
