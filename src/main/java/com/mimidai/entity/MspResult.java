package com.mimidai.entity;

import java.util.Date;


/**
 * 安融请求返回实体类
 * @author haidong
 */
public class MspResult {
    protected Long id;
    private Long queryId;
    private Long applyUserId;
    private Long applyId;
    private Date createTime;


    private int abnormalCreditDetailsNum;
    private int applyDetailsNum;
    private int blackDatasNum;
    private int contactReportNum;
    private int diffReportNum;
    private int normalCreditDetailsNum;
    private int queryDetailsNum;
    private int titleNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQueryId() {
        return queryId;
    }

    public void setQueryId(Long queryId) {
        this.queryId = queryId;
    }

    public Long getApplyUserId() {
        return applyUserId;
    }

    public void setApplyUserId(Long applyUserId) {
        this.applyUserId = applyUserId;
    }

    public Long getApplyId() {
        return applyId;
    }

    public void setApplyId(Long applyId) {
        this.applyId = applyId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public int getAbnormalCreditDetailsNum() {
        return abnormalCreditDetailsNum;
    }

    public void setAbnormalCreditDetailsNum(int abnormalCreditDetailsNum) {
        this.abnormalCreditDetailsNum = abnormalCreditDetailsNum;
    }

    public int getApplyDetailsNum() {
        return applyDetailsNum;
    }

    public void setApplyDetailsNum(int applyDetailsNum) {
        this.applyDetailsNum = applyDetailsNum;
    }

    public int getBlackDatasNum() {
        return blackDatasNum;
    }

    public void setBlackDatasNum(int blackDatasNum) {
        this.blackDatasNum = blackDatasNum;
    }

    public int getContactReportNum() {
        return contactReportNum;
    }

    public void setContactReportNum(int contactReportNum) {
        this.contactReportNum = contactReportNum;
    }

    public int getDiffReportNum() {
        return diffReportNum;
    }

    public void setDiffReportNum(int diffReportNum) {
        this.diffReportNum = diffReportNum;
    }

    public int getNormalCreditDetailsNum() {
        return normalCreditDetailsNum;
    }

    public void setNormalCreditDetailsNum(int normalCreditDetailsNum) {
        this.normalCreditDetailsNum = normalCreditDetailsNum;
    }

    public int getQueryDetailsNum() {
        return queryDetailsNum;
    }

    public void setQueryDetailsNum(int queryDetailsNum) {
        this.queryDetailsNum = queryDetailsNum;
    }

    public int getTitleNum() {
        return titleNum;
    }

    public void setTitleNum(int titleNum) {
        this.titleNum = titleNum;
    }
}
