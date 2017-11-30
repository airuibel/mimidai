//
//package com.mimidai;
//
//import com.google.common.collect.Lists;
//import com.mimidai.entity.UserLocation;
//import com.mimidai.service.UserInfoService;
//import org.apache.solr.client.solrj.SolrClient;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//
//import java.text.SimpleDateFormat;
//import java.util.List;
//import java.util.UUID;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//
///**
// * 通话详单汇总 迁移 core0 entity UserLocation
// */
//@SpringBootApplication
//@Component
//public class UserLocation2Hbase implements InitializingBean {
//    // 注入所需beans
//    @Autowired
//    @Qualifier("phoenixJdbcTemplateForQuery")
//    private JdbcTemplate jdbcTemplateforQuery;
//
//    @Autowired
//    @Qualifier("phoenixJdbcTemplateForUpdate")
//    private JdbcTemplate jdbcTemplateForUpdate;
//
//    // 获取logger
//    private Logger logger = LoggerFactory.getLogger(UserLocation2Hbase.class);
//
//    // MySQL读取条数
//
//    /**
//     * MySQL读取条数
//     * value 1
//     */
//
//
//    // 使用10个线程执行
//    private ExecutorService executorService = Executors.newFixedThreadPool(10);
//
//    public static void main(String[] args) {
//        SpringApplication.run(UserLocation2Hbase.class, args);
//    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        // TODO Auto-generated method stub
//        for (int i = 0; i <= 2341607; i++) {
//                    // step3->根据 userID 获取 solr数据并存入 hbase中
//                    mergeHbaseUserLocation(i);
//        }
//    }
//
//
//    private void mergeHbaseUserLocation(int userId) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
//        List<UserLocation> allUserLocationList = queryHbaseUserLocation(userId);
//        List<UserLocation> userLocationPart = updateHbaseUserLocation(userId);
//        for (UserLocation userLocation : allUserLocationList) {
//            if (userLocationPart.contains(userLocation)) {
//                continue;
//            } else {
//                try {
//                    String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 16);
//                    jdbcTemplateForUpdate
//                            .execute(
//                                    "upsert into userlocationtest VALUES ('" + uuid + "',"
//                                            + userLocation.getUserId()
//                                            + ",'"
//                                            + userLocation.getAddress()
//                                            + "',"
//                                            + +userLocation.getLng()
//                                            + ","
//                                            + userLocation.getLat()
//                                            + ",'"
//                                            + userLocation.getCreateTime()
//                                            + "'"
//                                            +
//                                            ")"
//                            );
//
//                } catch (Exception e) {
//                    logger.error("插入hbase报错", e);
//                }
//                logger.info("合并后数据保存到hbase成功该记录的userId,createTime为：" + userLocation.getUserId() + "," + userLocation.getCreateTime());
//            }
//        }
//    }
//
//    private List<UserLocation> updateHbaseUserLocation(int userId) {
//        String sql = " select userId,address,lng,lat,createTime from userlocationtest where userId = " + userId;
//        //缺少数据的hbase
//        List<UserLocation> userLocationListPart = null;
//        try {
//            userLocationListPart = jdbcTemplateForUpdate.query(sql,
//                    new BeanPropertyRowMapper<UserLocation>(UserLocation.class));
////            logger.info("【hBaseQuery】执行查询userLocation成功：" + userLocationList.size());
//        } catch (Exception e) {
//            logger.error("【hBaseQuery】执行查询（缺少数据的hbase）失败，sql:" + sql + "，失败原因:" + e.toString());
//        }
//        return userLocationListPart;
//    }
//
//    private List<UserLocation> queryHbaseUserLocation(int userId) {
//        String sql = " select userId,address,lng,lat,createTime from userlocation where userId = " + userId;
//        List<UserLocation> userLocationList = null;
//        try {
//            userLocationList = jdbcTemplateforQuery.query(sql,
//                    new BeanPropertyRowMapper<UserLocation>(UserLocation.class));
//            logger.info("【hBaseQuery】执行查询userLocation成功：" + userLocationList.size());
//        } catch (Exception e) {
//            logger.error("【hBaseQuery】执行查询（完整数据）失败，sql:" + sql + "，失败原因:" + e.toString());
//        }
//        return userLocationList;
//    }
//
//
////public void lastLogPrint(){
////        logger.warn("***************************迁移结束！*****************************");
////        logger.info("mysql中共有用户总数为:"+totalUserNum);
////        logger.info("从solr到hbase共移植用户总计（包括用户信息在solr为空的用户）："+toHbaseUserNum);
////        logger.info("solr中无相关用户信息的用户总数为："+userNotInSolrNum);
////
////        logger.warn("***************************迁移失败用户！*****************************");
////        logger.error("连接solr库时发生异常，导致用户所有记录转移失败！共计:"+exceptionUserNum+"为用户异常！;");
////        logger.error("连接solr时，发生异常用户的userId分别为："+exceptionUserId.toString());
////
////        logger.warn("***************************迁移的记录数*****************************");
////        logger.info("成功迁移记录数为 ："+successRecordNum);
////        logger.info("已经在hbase中，无需迁移的记录数为："+noNeed2HbaseNum);
////        logger.error("插入hbase时，插入失败记录数为："+exceptionRecordNum);
////        logger.error("插入hbase时，插入失败的solr Id为 ："+exceptionSolrId.toString());
////        }
//
//// 锁 记录
//
////    /**
////     * solr获取记录时出现异常
////     */
////
////    private synchronized void solrException(Long userId) {
////        exceptionUserId.add(userId);
////        exceptionUserNum++;
////    }
////
////
////    /**
////     * 出现异常记录的solr ID
////     */
////
////    private synchronized void insert2HbaeExcepton(String id) {
////        exceptionSolrId.add(id);
////        exceptionRecordNum++;
////    }
////
////
////    /**
////     * 成功插入hbase 的记录
////     */
////
////    private synchronized void insert2HbaeSuccess(String adress) {
////        successSolrId.add(adress);
////        successRecordNum++;
////    }
////
////
////    /**
////     * 对某用户已操作完毕（已经转移用户信息记录数）
////     */
////
////    private synchronized void insert2HbaeFinish(Long userId) {
////        toHbaseUserIds.add(userId);
////        toHbaseUserNum++;
////    }
////
////
////    /**
////     * 用户没有信息在solr中
////     */
////
////    private synchronized void noInfoInSolr(Long userId) {
////        insert2HbaeFinish(userId);
////        userNotInSolrNum++;
////    }
////
////
////    /**
////     * 记录已经在hbase中，不需要迁移
////     */
////
////    private synchronized void NoNeed2Hbase() {
////        noNeed2HbaseNum++;
////    }
//}
//
//
//
