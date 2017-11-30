package com.mimidai.entity;

import lombok.Data;

import java.util.Date;

/**
 * 类文件注释(Class file)
 *
 * @author focus
 * @classDescription 用户工作信息
 * @create 2017-11-21 14:53
 **/

@Data
@SuppressWarnings("serial")
public class UserJob {

    private Integer id;
    /**
     * @Fields userId : 用户id
     */
    private Long userId;
    /**
     * @Fields job : 职业
     */
    private String job;
    /**
     * @Fields jobName ：职业的value值 不存数据库
     * @author liang 2016-01-25
     */
    private String jobName;
    /**
     * @Fields company : 公司名称
     */
    private String company;
    /**
     * @Fields province : 所在省
     */
    private String province;
    /**
     * @Fields city : 所在市
     */
    private String city;
    /**
     * @Fields area : 所在区
     */

    private String area;
    /**
     * @Fields address : 地址
     */
    private String address;
    /**
     * @Fields phone : 联系电话
     */
    private String phone;
    /**
     * @Fields checkState : 审核状态
     */
    private String checkState;
    /**
     * @Fields checkUser : 审核人
     */
    private Integer checkUserId;
    /**
     * @Fields checkTime : 审核时间
     */
    private Date checkTime;
    /**
     * @Fields remark : 备注
     */
    private String remark;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 行业
     */
    private String profession;
    /**
     * 子行业
     */
    private String childProfession;
    /**
     * 是否和用户上传的地理位置信息匹配
     */
    private Integer matchStatus;
    /*
     * 是否包含公司名 敏感词汇
     */
    private String containSensitive;




}

