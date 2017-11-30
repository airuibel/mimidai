package com.mimidai.entity;

import lombok.Data;

/**
 * Created by zhangyu on 2017/7/14.
 */

@Data
public class TpSquron {

    private String phoneProvince;
    private String idcardValidate;
    private String idcardProvince;
    private String idcardCity;
    private String idcardRegion;
    private String lastIdcard;
    private String lastPhone;
    private Integer idcardDays;
    private Integer phoneDays;
    private Integer idcardCnt;
    private Integer phoneCnt;
    private Integer directContacts;
    private Integer directBad;
    private Integer directGood;
    private Integer indirectBad;
    private Long userId;
    private Integer overdue;
    private Integer recordidcard;
    private Integer recordphone;
    private String lastAppearIdcard;
    private String lastAppearPhone;
    private Integer usedIdcards;
    private Integer usedPhone;
    private Integer snScore;
    private Integer contacts;
    private Integer blackC;
    private Integer blackC2;
    private Integer blackCount;
    private Double blackRatio;
    private Integer online;
    private Integer offline;
    private Integer credit;
    private Integer payday;
    private Integer offlineCash;
    private Integer search;
    private Integer search7;
    private Integer search14;
    private Integer search30;
    private Integer search60;
    private Integer search90;
    private Integer search180;
    private Integer org;
    private Integer recent7;
    private Integer recent14;
    private Integer recent30;
    private Integer recent60;
    private Integer recent90;
    private Integer recent180;
    private Integer creditCash;
    private Integer payCash;
    private Integer onlineCash;

}
