package com.mimidai.entity;

/**
 * Created by zhangyu on 2017/7/14.
 */
public class TpTsp {
    //最近6个月贷款申请：申请中笔数
    private Integer applyingCount;
    //apply_reject_count
    private Integer applyRejectCount;

    public Integer getApplyingCount() {
        return applyingCount;
    }

    public void setApplyingCount(Integer applyingCount) {
        this.applyingCount = applyingCount;
    }

    public Integer getApplyRejectCount() {
        return applyRejectCount;
    }

    public void setApplyRejectCount(Integer applyRejectCount) {
        this.applyRejectCount = applyRejectCount;
    }
}
