package com.mimidai.entity.opdReportSjmh;

public class ReportCarrierConsumptionStatsPerMonth {
    private String month;
    private String consume_amount;
    private String consume_amount_call;
    private String consume_amount_data;
    private String consume_amount_msg;
    private String consume_amount_extra;
    private String consume_amount_other;
    private String recharge_count;
    private String recharge_amount;
    private String data_package;
    private String data_usage;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getConsume_amount() {
        return consume_amount;
    }

    public void setConsume_amount(String consume_amount) {
        this.consume_amount = consume_amount;
    }

    public String getConsume_amount_call() {
        return consume_amount_call;
    }

    public void setConsume_amount_call(String consume_amount_call) {
        this.consume_amount_call = consume_amount_call;
    }

    public String getConsume_amount_data() {
        return consume_amount_data;
    }

    public void setConsume_amount_data(String consume_amount_data) {
        this.consume_amount_data = consume_amount_data;
    }

    public String getConsume_amount_msg() {
        return consume_amount_msg;
    }

    public void setConsume_amount_msg(String consume_amount_msg) {
        this.consume_amount_msg = consume_amount_msg;
    }

    public String getConsume_amount_extra() {
        return consume_amount_extra;
    }

    public void setConsume_amount_extra(String consume_amount_extra) {
        this.consume_amount_extra = consume_amount_extra;
    }

    public String getConsume_amount_other() {
        return consume_amount_other;
    }

    public void setConsume_amount_other(String consume_amount_other) {
        this.consume_amount_other = consume_amount_other;
    }

    public String getRecharge_count() {
        return recharge_count;
    }

    public void setRecharge_count(String recharge_count) {
        this.recharge_count = recharge_count;
    }

    public String getRecharge_amount() {
        return recharge_amount;
    }

    public void setRecharge_amount(String recharge_amount) {
        this.recharge_amount = recharge_amount;
    }

    public String getData_package() {
        return data_package;
    }

    public void setData_package(String data_package) {
        this.data_package = data_package;
    }

    public String getData_usage() {
        return data_usage;
    }

    public void setData_usage(String data_usage) {
        this.data_usage = data_usage;
    }

    @Override
    public String toString() {
        return " ," + month + ", " + consume_amount + ", " + consume_amount_call + ", "
                + consume_amount_data + ", " + consume_amount_msg + ", " + consume_amount_extra
                + ", " + consume_amount_other + ", " + recharge_count + ", " + recharge_amount
                + ", " + data_package + ", " + data_usage;
    }
    
    
}
