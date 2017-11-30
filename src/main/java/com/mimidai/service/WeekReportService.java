package com.mimidai.service;

import com.mimidai.dao.WeekReportDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangyu on 2017/8/21.
 */
@Service
public class WeekReportService {

    @Autowired
    private WeekReportDao weekReportDao;

//    public List<Map<String, Object>> query() {
//        return weekReportDao.query();
//
//    }

    public Long queryGoodOrBadByUserId(Long userId){
        return weekReportDao.queryGoodOrBadByUserId(userId);
    }
    public Integer queryUserDevice(int userId){
        return weekReportDao.queryUserDevice(userId);
    }
    //    public List<WeekReport> queryBlack() {
//        return weekReportDao.queryBlack();
//
//    }
//
//    public WeekReport queryIsXHD(Long userId) {
//        return weekReportDao.queryIsXHD(userId);
//    }
//
//    public List<String> queryContacts(Long userId) {
//        return weekReportDao.queryContacts(userId);
//    }
//
//    public WeekReport findNewTPByUserId(Long userId) {
//        return weekReportDao.findNewTPByUserId(userId);
//    }
//
////    public String findBRByUserId(Long userId){
////        return  weekReportDao.findBRByUserId(userId);
////    }
////
////    public Map<String, Integer> findAppInstall(Long userId){
////        return weekReportDao.findAppInstall(userId);
////    }
////    public String findUserIp(Long userId){
////        return weekReportDao.findUserIp(userId);
////    }
////
////    public List<WeekReport> findSensitive(){
////        return weekReportDao.findSensitive();
////    }
//
//    public String findBankInfo(Long userId) {
//        return weekReportDao.findBankInfo(userId);
//    }
//
//    public String findUserJob(Long userId) {
//        return weekReportDao.findUserJob(userId);
//    }
//
//    public WeekReport findLastLoanInfo(Long userId) {
//        return weekReportDao.findLastLoanInfo(userId);
//    }
//
////    public Integer findOverdueTime(Long userId){
////        return weekReportDao.findOverdueTime(userId);
////    }
////    public WeekReport findInTimeRepay(Long userId){
////        return weekReportDao.findInTimeRepay(userId);
////    }
//
    public Integer findLoanTime(int userId) {


        return weekReportDao.findLoanTime(userId);
    }
//
//    public Integer findOverdueTime(Long userId, Date loanTime) {
//        HashMap<String, Object> objectObjectHashMap = Maps.newHashMap();
//        objectObjectHashMap.put("userId", userId);
//        objectObjectHashMap.put("loanTime", loanTime);
//
//        return weekReportDao.findOverdueTime(objectObjectHashMap);
//    }
//
//    public Integer findMaxOverdue(Long userId, Date loanTime) {
//        HashMap<String, Object> objectObjectHashMap = Maps.newHashMap();
//        objectObjectHashMap.put("userId", userId);
//        objectObjectHashMap.put("loanTime", loanTime);
//
//        return weekReportDao.findMaxOverdue(objectObjectHashMap);
//    }
//
//    public Integer findSumOverdue(Long userId, Date loanTime) {
//        HashMap<String, Object> objectObjectHashMap = Maps.newHashMap();
//        objectObjectHashMap.put("userId", userId);
//        objectObjectHashMap.put("loanTime", loanTime);
//
//        return weekReportDao.findSumOverdue(objectObjectHashMap);
//    }
//
//    public String findJobName(Long userId) {
//        return weekReportDao.findJobName(userId);
//    }
//
//    public Integer findAllByPhones(String phone) {
//        return weekReportDao.findAllByPhones(phone);
//    }
//
//
//    public  WeekReport findBanInfo(Long userId){
//        return weekReportDao.findBanInfo(userId);
//    }
//
//    public Map<String, Integer> findAppInstall(Long userId, String applyTime){
//        return weekReportDao.findAppInstall(userId, applyTime);
//    }
//
//    public TpSquron queryTpSauron(long userId, String applyTime){
//        return weekReportDao.queryTpSauron(userId, applyTime);
//    }
//
//
//    public WeekReport queryZhima(Long userId){
//        return weekReportDao.queryZhima(userId);
//    }
//
//    public String findRemark(String key){
//        return weekReportDao.findRemark(key);
//    }
//
//    public UserBsPayBehavior findBsBehavior(Long userId){
//        return weekReportDao.findBsBehavior(userId);
//    }
//
//    public List<String> queryLoanThreeTime(){
//        return weekReportDao.queryLoanThreeTime();
//    }
//
//    public String queryFirstLoanDs(String good) {
//        return weekReportDao.queryFirstLoanDs(good);
//    }
//    public String queryRemark(Integer loanId) {
//        return weekReportDao.queryRemark(loanId);
//    }
//    public String queryValue(String remarkLabel) {
//        return weekReportDao.queryValue(remarkLabel);
//    }
}
