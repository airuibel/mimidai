package com.mimidai.entity;

/**
 * Created by 苦苦奋斗的渣渣 on 2017/5/18.
 */
public class UserInfo {
    private Long userId;
    private String loanId;
    private String loanType;
    private String isOverdue;
    private String isRepay;

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getIsOverdue() {
        return isOverdue;
    }

    public void setIsOverdue(String isOverdue) {
        this.isOverdue = isOverdue;
    }

    public String getIsRepay() {
        return isRepay;
    }

    public void setIsRepay(String isRepay) {
        this.isRepay = isRepay;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


}
