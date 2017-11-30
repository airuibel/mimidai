package com.mimidai.entity.opdReportSjmh;

import java.util.List;

/**
 * @author GY
 * 2017年8月1日
 * 数据魔盒 报告具体数据 (指标数据) 实体类
 */
public class SjmhReportResultData {
    
    //报告信息
    private ReportInfo report_info;
    //数据完整性
    private ReportDataCompleteness data_completeness;
    //用户信息
    private ReportUserInfo user_info;
    //手机信息
    private ReportMobileInfo mobile_info;
    //信息匹配
    private ReportInfoMatch info_match;
    //信息检测
    private ReportInfoCheck info_check;
    //行为分析
    private ReportBehaviorAnalysis behavior_analysis;
    //紧急联系人1明细
    private ReportEmergencyContact1Detail emergency_contact1_detail;
    //紧急联系人2明细
    private ReportEmergencyContact1Detail emergency_contact2_detail;
    //紧急联系人3明细
    private ReportEmergencyContact1Detail emergency_contact3_detail;
    //紧急联系人4明细
    private ReportEmergencyContact1Detail emergency_contact4_detail;
    //紧急联系人5明细
    private ReportEmergencyContact1Detail emergency_contact5_detail;
    //家庭号码明细
    private ReportHomeTelDetail home_tel_detail;
    //工作号码明细
    private ReportWorkTelDetail work_tel_detail;
    //全部联系人明细
    private List<ReportAllContactDetail> all_contact_detail;
    //全部联系人统计
    private ReportAllContactStats all_contact_stats;
    //每个月联系人统计
    private List<ReportAllContactStatsPerMonth> all_contact_stats_per_month;
    //风险联系人统计
    private List<ReportRiskContactStats> risk_contact_stats;
    //风险联系人明细
    private List<ReportRiskContactDetail> risk_contact_detail;
    //金融机构联系人统计
    private List<ReportFinanceContactStats> finance_contact_stats;
    //金融机构联系人明细
    private List<ReportFinanceContactDetail> finance_contact_detail;
    //联系人归属地统计(城市)
    private List<ReportContactAreaStatsPerCity> contact_area_stats_per_city;
    //运营商消费统计
    private ReportCarrierConsumptionStats carrier_consumption_stats;
    //每个月运营商消费统计
    private List<ReportCarrierConsumptionStatsPerMonth> carrier_consumption_stats_per_month;
    //通话地区统计(城市)
    private List<ReportCallAreaStatsPerCity> call_area_stats_per_city;
    //静默活跃统计
    private ReportActiveSilenceStats active_silence_stats;
    //各时间段通话统计（每2小时）
    private ReportCallDurationStats2hour call_duration_stats_2hour;
    //出行记录分析(城市)
    private List<ReportTravelTrackAnalysisPerCity> travel_track_analysis_per_city;
    
    
    
    public ReportCallDurationStats2hour getCall_duration_stats_2hour() {
        return call_duration_stats_2hour;
    }
    public void setCall_duration_stats_2hour(ReportCallDurationStats2hour call_duration_stats_2hour) {
        this.call_duration_stats_2hour = call_duration_stats_2hour;
    }
    public ReportInfo getReport_info() {
        return report_info;
    }
    public void setReport_info(ReportInfo report_info) {
        this.report_info = report_info;
    }
    public ReportDataCompleteness getData_completeness() {
        return data_completeness;
    }
    public void setData_completeness(ReportDataCompleteness data_completeness) {
        this.data_completeness = data_completeness;
    }
    public ReportUserInfo getUser_info() {
        return user_info;
    }
    public void setUser_info(ReportUserInfo user_info) {
        this.user_info = user_info;
    }
    public ReportMobileInfo getMobile_info() {
        return mobile_info;
    }
    public void setMobile_info(ReportMobileInfo mobile_info) {
        this.mobile_info = mobile_info;
    }
    public ReportInfoMatch getInfo_match() {
        return info_match;
    }
    public void setInfo_match(ReportInfoMatch info_match) {
        this.info_match = info_match;
    }
    public ReportInfoCheck getInfo_check() {
        return info_check;
    }
    public void setInfo_check(ReportInfoCheck info_check) {
        this.info_check = info_check;
    }
    public ReportBehaviorAnalysis getBehavior_analysis() {
        return behavior_analysis;
    }
    public void setBehavior_analysis(ReportBehaviorAnalysis behavior_analysis) {
        this.behavior_analysis = behavior_analysis;
    }
    public ReportEmergencyContact1Detail getEmergency_contact1_detail() {
        return emergency_contact1_detail;
    }
    public void setEmergency_contact1_detail(ReportEmergencyContact1Detail emergency_contact1_detail) {
        this.emergency_contact1_detail = emergency_contact1_detail;
    }
    public ReportEmergencyContact1Detail getEmergency_contact2_detail() {
        return emergency_contact2_detail;
    }
    public void setEmergency_contact2_detail(ReportEmergencyContact1Detail emergency_contact2_detail) {
        this.emergency_contact2_detail = emergency_contact2_detail;
    }
    public ReportEmergencyContact1Detail getEmergency_contact3_detail() {
        return emergency_contact3_detail;
    }
    public void setEmergency_contact3_detail(ReportEmergencyContact1Detail emergency_contact3_detail) {
        this.emergency_contact3_detail = emergency_contact3_detail;
    }
    public ReportEmergencyContact1Detail getEmergency_contact4_detail() {
        return emergency_contact4_detail;
    }
    public void setEmergency_contact4_detail(ReportEmergencyContact1Detail emergency_contact4_detail) {
        this.emergency_contact4_detail = emergency_contact4_detail;
    }
    public ReportEmergencyContact1Detail getEmergency_contact5_detail() {
        return emergency_contact5_detail;
    }
    public void setEmergency_contact5_detail(ReportEmergencyContact1Detail emergency_contact5_detail) {
        this.emergency_contact5_detail = emergency_contact5_detail;
    }
    public ReportHomeTelDetail getHome_tel_detail() {
        return home_tel_detail;
    }
    public void setHome_tel_detail(ReportHomeTelDetail home_tel_detail) {
        this.home_tel_detail = home_tel_detail;
    }
    public ReportWorkTelDetail getWork_tel_detail() {
        return work_tel_detail;
    }
    public void setWork_tel_detail(ReportWorkTelDetail work_tel_detail) {
        this.work_tel_detail = work_tel_detail;
    }
    public List<ReportAllContactDetail> getAll_contact_detail() {
        return all_contact_detail;
    }
    public void setAll_contact_detail(List<ReportAllContactDetail> all_contact_detail) {
        this.all_contact_detail = all_contact_detail;
    }
    public ReportAllContactStats getAll_contact_stats() {
        return all_contact_stats;
    }
    public void setAll_contact_stats(ReportAllContactStats all_contact_stats) {
        this.all_contact_stats = all_contact_stats;
    }
    public List<ReportAllContactStatsPerMonth> getAll_contact_stats_per_month() {
        return all_contact_stats_per_month;
    }
    public void setAll_contact_stats_per_month(
            List<ReportAllContactStatsPerMonth> all_contact_stats_per_month) {
        this.all_contact_stats_per_month = all_contact_stats_per_month;
    }
    public List<ReportRiskContactStats> getRisk_contact_stats() {
        return risk_contact_stats;
    }
    public void setRisk_contact_stats(List<ReportRiskContactStats> risk_contact_stats) {
        this.risk_contact_stats = risk_contact_stats;
    }
    public List<ReportRiskContactDetail> getRisk_contact_detail() {
        return risk_contact_detail;
    }
    public void setRisk_contact_detail(List<ReportRiskContactDetail> risk_contact_detail) {
        this.risk_contact_detail = risk_contact_detail;
    }
    public List<ReportFinanceContactStats> getFinance_contact_stats() {
        return finance_contact_stats;
    }
    public void setFinance_contact_stats(List<ReportFinanceContactStats> finance_contact_stats) {
        this.finance_contact_stats = finance_contact_stats;
    }
    public List<ReportFinanceContactDetail> getFinance_contact_detail() {
        return finance_contact_detail;
    }
    public void setFinance_contact_detail(List<ReportFinanceContactDetail> finance_contact_detail) {
        this.finance_contact_detail = finance_contact_detail;
    }
    public List<ReportContactAreaStatsPerCity> getContact_area_stats_per_city() {
        return contact_area_stats_per_city;
    }
    public void setContact_area_stats_per_city(
            List<ReportContactAreaStatsPerCity> contact_area_stats_per_city) {
        this.contact_area_stats_per_city = contact_area_stats_per_city;
    }
    public ReportCarrierConsumptionStats getCarrier_consumption_stats() {
        return carrier_consumption_stats;
    }
    public void setCarrier_consumption_stats(ReportCarrierConsumptionStats carrier_consumption_stats) {
        this.carrier_consumption_stats = carrier_consumption_stats;
    }
    public List<ReportCarrierConsumptionStatsPerMonth> getCarrier_consumption_stats_per_month() {
        return carrier_consumption_stats_per_month;
    }
    public void setCarrier_consumption_stats_per_month(
            List<ReportCarrierConsumptionStatsPerMonth> carrier_consumption_stats_per_month) {
        this.carrier_consumption_stats_per_month = carrier_consumption_stats_per_month;
    }
    public List<ReportCallAreaStatsPerCity> getCall_area_stats_per_city() {
        return call_area_stats_per_city;
    }
    public void setCall_area_stats_per_city(List<ReportCallAreaStatsPerCity> call_area_stats_per_city) {
        this.call_area_stats_per_city = call_area_stats_per_city;
    }
    public ReportActiveSilenceStats getActive_silence_stats() {
        return active_silence_stats;
    }
    public void setActive_silence_stats(ReportActiveSilenceStats active_silence_stats) {
        this.active_silence_stats = active_silence_stats;
    }
    public List<ReportTravelTrackAnalysisPerCity> getTravel_track_analysis_per_city() {
        return travel_track_analysis_per_city;
    }
    public void setTravel_track_analysis_per_city(
            List<ReportTravelTrackAnalysisPerCity> travel_track_analysis_per_city) {
        this.travel_track_analysis_per_city = travel_track_analysis_per_city;
    }
    @Override
    public String toString() {
        return  report_info + ", " + data_completeness + ", " + user_info + ", "
                + mobile_info + ", " + info_match + ", " + info_check + ", " + behavior_analysis
                + ", " + emergency_contact1_detail + ", " + emergency_contact2_detail + ", "
                + emergency_contact3_detail + ", " + emergency_contact4_detail + ", "
                + emergency_contact5_detail + ", " + home_tel_detail + ", " + work_tel_detail
                //+ ", " + all_contact_detail.get(0)+", "+all_contact_detail.get(1) + ", "
                + all_contact_stats + ", "
                //+ all_contact_stats_per_month.get(0)+","+all_contact_stats_per_month.get(1) + ", " 
                //+ risk_contact_stats.get(0)+","+risk_contact_stats.get(1) + ", "
                //+ risk_contact_detail.get(0)+","+ risk_contact_detail.get(1)+ ", " 
                //+ finance_contact_stats.get(0)+","+finance_contact_stats.get(1) + ", "
                //+ finance_contact_detail.get(0)+","+ finance_contact_detail.get(1)+ ", " 
                //+ contact_area_stats_per_city.get(0)+","+contact_area_stats_per_city.get(1) + ", "
                + carrier_consumption_stats + ", " 
                //+ carrier_consumption_stats_per_month.get(0)+","
                //+ carrier_consumption_stats_per_month.get(1) + ", "
                //+ call_area_stats_per_city.get(0)+","+carrier_consumption_stats_per_month.get(1) + ", " 
                + active_silence_stats + ", "
                + call_duration_stats_2hour+ ","
                //+ travel_track_analysis_per_city.get(0)+","+travel_track_analysis_per_city.get(1)
                ;
    }


    
    
}
