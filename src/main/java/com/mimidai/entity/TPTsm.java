package com.mimidai.entity;

/**
 * Created by zhangyu on 2017/7/14.
 */
public class TPTsm {
    /**
     * 最近6个月贷款申请
    **/
    private Integer applyTotalCount;
    //最近2年内查询记录
    private Integer queryCount;
    //异常还款账户
    private Integer etotalCount;
    //正常还款账户
    private Integer totalCount;

    public Integer getApplyTotalCount() {
        return applyTotalCount;
    }

    public void setApplyTotalCount(Integer applyTotalCount) {
        this.applyTotalCount = applyTotalCount;
    }

    public Integer getQueryCount() {
        return queryCount;
    }

    public void setQueryCount(Integer queryCount) {
        this.queryCount = queryCount;
    }

    public Integer getEtotalCount() {
        return etotalCount;
    }

    public void setEtotalCount(Integer etotalCount) {
        this.etotalCount = etotalCount;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
}
