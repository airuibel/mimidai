package com.mimidai.dao;

import com.mimidai.entity.Sauron;
import com.mimidai.entity.TpSquron;
import com.mimidai.entity.UserBsPayBehavior;
import com.mimidai.entity.WeekReport;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangyu on 2017/8/21.
 */
@Repository
public interface WeekReportDao {

    List<Map<String, Object>> queryx();

    //
//    WeekReport queryIsXHD(Long userId);
//
//   List<String> queryContacts(Long userId);
////
////    List<WeekReport> queryBlack();
//
//    WeekReport findNewTPByUserId(Long userId);
//
////    String findBRByUserId(Long userId);
////
//    Map<String, Integer> findAppInstall(@Param("userId") Long userId, @Param("applyTime") String applyTime);
////
////   String findUserIp(Long userId);
////
////    List<WeekReport> findSensitive();
//
//    String findBankInfo(Long userId);
//
//    String findUserJob(Long userId);
//
//    WeekReport findLastLoanInfo(Long userId);
//
////   Integer findOverdueTime(Long userId);
//
////   WeekReport findInTimeRepay(Long userId);
//
   Integer findLoanTime(int userId);
//
//    Integer findOverdueTime(Map map);
//    Integer findMaxOverdue(Map map);
//    Integer findSumOverdue(Map map);
//    String  findJobName(Long userId);
//    Integer findAllByPhones(@Param("phones") String phone);
//
//
//    WeekReport  findBanInfo(Long userId);
//
//
//
//  TpSquron queryTpSauron(@Param("userId") Long userId, @Param("applyTime") String applyTime);
//
//    WeekReport queryZhima(Long userId);
//
//   String  findRemark(String key);
//   UserBsPayBehavior findBsBehavior(Long userId);
//
//   List<String> queryLoanThreeTime();
//
//
//    String queryFirstLoanDs(String good);
//    String queryRemark(Integer loanId);
//
//    String queryValue(String remarkLabel);

    Long queryGoodOrBadByUserId(Long userId);

    Integer queryUserDevice(int userId);

    List<Long> query();
    List<Long> queryLoanApply();
    List<Long> queryMonth();
    List<Map<String, Object>> queryAny(Long userId);
    Map<String, Object> queryAdvance(@Param("userId") int userId,@Param("id") int id);




}
