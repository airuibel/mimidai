package com.mimidai.entity.opdReportSjmh;

/**
 * @author GY
 * 2017年8月2日
 * 行为分析
 */
public class ReportBehaviorAnalysis {

    //近6个月110通话情况
    private String call_110_analysis_6month;
    //近6个月120通话情况
    private String call_120_analysis_6month;
    //近6个月澳门电话通话情况
    private String call_macau_analysis_6month;
    //近6个月律师号码通话情况
    private String call_lawyer_analysis_6month;
    //近6个月法院号码通话情况
    private String call_court_analysis_6month;
    //近6个月小贷号码联系情况
    private String loan_contact_analysis_6month;
    //近6个月催收号码联系情况
    private String collection_contact_analysis_6month;
    //号码入网时间
    private String mobile_net_age_analysis;
    //近6个月互通号码数量
    private String mutual_number_analysis_6month;
    //近6个月深夜活动情况
    private String late_night_analysis_6month;
    //近6个月手机静默情况
    private String mobile_silence_analysis_6month;
    //近6个月紧急联系人1通话情况
    private String emergency_contact1_analysis_6month;
    //近6个月紧急联系人2通话情况
    private String emergency_contact2_analysis_6month;
    //近6个月紧急联系人3通话情况
    private String emergency_contact3_analysis_6month;
    //近6个月紧急联系人4通话情况
    private String emergency_contact4_analysis_6month;
    //近6个月紧急联系人5通话情况
    private String emergency_contact5_analysis_6month;
    
    
    public String getCall_110_analysis_6month() {
        return call_110_analysis_6month;
    }
    public void setCall_110_analysis_6month(String call_110_analysis_6month) {
        this.call_110_analysis_6month = call_110_analysis_6month;
    }
    public String getCall_120_analysis_6month() {
        return call_120_analysis_6month;
    }
    public void setCall_120_analysis_6month(String call_120_analysis_6month) {
        this.call_120_analysis_6month = call_120_analysis_6month;
    }
    public String getCall_macau_analysis_6month() {
        return call_macau_analysis_6month;
    }
    public void setCall_macau_analysis_6month(String call_macau_analysis_6month) {
        this.call_macau_analysis_6month = call_macau_analysis_6month;
    }
    public String getCall_lawyer_analysis_6month() {
        return call_lawyer_analysis_6month;
    }
    public void setCall_lawyer_analysis_6month(String call_lawyer_analysis_6month) {
        this.call_lawyer_analysis_6month = call_lawyer_analysis_6month;
    }
    public String getCall_court_analysis_6month() {
        return call_court_analysis_6month;
    }
    public void setCall_court_analysis_6month(String call_court_analysis_6month) {
        this.call_court_analysis_6month = call_court_analysis_6month;
    }
    public String getLoan_contact_analysis_6month() {
        return loan_contact_analysis_6month;
    }
    public void setLoan_contact_analysis_6month(String loan_contact_analysis_6month) {
        this.loan_contact_analysis_6month = loan_contact_analysis_6month;
    }
    public String getCollection_contact_analysis_6month() {
        return collection_contact_analysis_6month;
    }
    public void setCollection_contact_analysis_6month(String collection_contact_analysis_6month) {
        this.collection_contact_analysis_6month = collection_contact_analysis_6month;
    }
    public String getMobile_net_age_analysis() {
        return mobile_net_age_analysis;
    }
    public void setMobile_net_age_analysis(String mobile_net_age_analysis) {
        this.mobile_net_age_analysis = mobile_net_age_analysis;
    }
    public String getMutual_number_analysis_6month() {
        return mutual_number_analysis_6month;
    }
    public void setMutual_number_analysis_6month(String mutual_number_analysis_6month) {
        this.mutual_number_analysis_6month = mutual_number_analysis_6month;
    }
    public String getLate_night_analysis_6month() {
        return late_night_analysis_6month;
    }
    public void setLate_night_analysis_6month(String late_night_analysis_6month) {
        this.late_night_analysis_6month = late_night_analysis_6month;
    }
    public String getMobile_silence_analysis_6month() {
        return mobile_silence_analysis_6month;
    }
    public void setMobile_silence_analysis_6month(String mobile_silence_analysis_6month) {
        this.mobile_silence_analysis_6month = mobile_silence_analysis_6month;
    }
    public String getEmergency_contact1_analysis_6month() {
        return emergency_contact1_analysis_6month;
    }
    public void setEmergency_contact1_analysis_6month(String emergency_contact1_analysis_6month) {
        this.emergency_contact1_analysis_6month = emergency_contact1_analysis_6month;
    }
    public String getEmergency_contact2_analysis_6month() {
        return emergency_contact2_analysis_6month;
    }
    public void setEmergency_contact2_analysis_6month(String emergency_contact2_analysis_6month) {
        this.emergency_contact2_analysis_6month = emergency_contact2_analysis_6month;
    }
    public String getEmergency_contact3_analysis_6month() {
        return emergency_contact3_analysis_6month;
    }
    public void setEmergency_contact3_analysis_6month(String emergency_contact3_analysis_6month) {
        this.emergency_contact3_analysis_6month = emergency_contact3_analysis_6month;
    }
    public String getEmergency_contact4_analysis_6month() {
        return emergency_contact4_analysis_6month;
    }
    public void setEmergency_contact4_analysis_6month(String emergency_contact4_analysis_6month) {
        this.emergency_contact4_analysis_6month = emergency_contact4_analysis_6month;
    }
    public String getEmergency_contact5_analysis_6month() {
        return emergency_contact5_analysis_6month;
    }
    public void setEmergency_contact5_analysis_6month(String emergency_contact5_analysis_6month) {
        this.emergency_contact5_analysis_6month = emergency_contact5_analysis_6month;
    }
    @Override
    public String toString() {
        return " ," + call_110_analysis_6month + ", " + call_120_analysis_6month + ", "
                + call_macau_analysis_6month + ", " + call_lawyer_analysis_6month + ", "
                + call_court_analysis_6month + ", " + loan_contact_analysis_6month + ", "
                + collection_contact_analysis_6month + ", " + mobile_net_age_analysis + ", "
                + mutual_number_analysis_6month + ", " + late_night_analysis_6month + ", "
                + mobile_silence_analysis_6month + ", " + emergency_contact1_analysis_6month + ", "
                + emergency_contact2_analysis_6month + ", " + emergency_contact3_analysis_6month
                + ", " + emergency_contact4_analysis_6month + ", "
                + emergency_contact5_analysis_6month;
    }
    
    
    
}
