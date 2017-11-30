package com.mimidai.entity.opdReportSjmh;

public class ReportTravelTrackAnalysisPerCity {
    private String leave_city;
    private String leave_day;
    private String leave_day_type;
    private String arrive_city;
    private String arrive_day;
    private String arrive_day_type;

    public String getLeave_city() {
        return leave_city;
    }

    public void setLeave_city(String leave_city) {
        this.leave_city = leave_city;
    }

    public String getLeave_day() {
        return leave_day;
    }

    public void setLeave_day(String leave_day) {
        this.leave_day = leave_day;
    }

    public String getLeave_day_type() {
        return leave_day_type;
    }

    public void setLeave_day_type(String leave_day_type) {
        this.leave_day_type = leave_day_type;
    }

    public String getArrive_city() {
        return arrive_city;
    }

    public void setArrive_city(String arrive_city) {
        this.arrive_city = arrive_city;
    }

    public String getArrive_day() {
        return arrive_day;
    }

    public void setArrive_day(String arrive_day) {
        this.arrive_day = arrive_day;
    }

    public String getArrive_day_type() {
        return arrive_day_type;
    }

    public void setArrive_day_type(String arrive_day_type) {
        this.arrive_day_type = arrive_day_type;
    }

    @Override
    public String toString() {
        return " ," + leave_city + ", " + leave_day + ", " + leave_day_type + ", " + arrive_city
                + ", " + arrive_day + ", " + arrive_day_type;
    }
    
    
}
