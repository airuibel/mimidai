package com.mimidai.entity.opdReportSjmh;

/**
 * Created by 孟庆艺 on 2017-08-09.
 */
public class HotDataSjmo {
    private ReportInfo report_info;
    private ReportDataCompleteness data_completeness;
    private ReportMobileInfo mobile_info;
    private ReportInfoMatch info_match;
    private ReportInfoCheck info_check;
    private ReportBehaviorAnalysis behavior_analysis;
    private ReportEmergencyContact1Detail emergency_contact1_detail;
    private ReportEmergencyContact1Detail emergency_contact2_detail;
    private ReportWorkTelDetail work_tel_detail;
    private ReportAllContactStats all_contact_stats;

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

    public ReportWorkTelDetail getWork_tel_detail() {
        return work_tel_detail;
    }

    public void setWork_tel_detail(ReportWorkTelDetail work_tel_detail) {
        this.work_tel_detail = work_tel_detail;
    }

    public ReportAllContactStats getAll_contact_stats() {
        return all_contact_stats;
    }

    public void setAll_contact_stats(ReportAllContactStats all_contact_stats) {
        this.all_contact_stats = all_contact_stats;
    }
}
