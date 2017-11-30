//package com.mimidai;
//
//import com.mimidai.entity.PhoneContacts;
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
//import java.util.List;
//import java.util.UUID;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
///**
// *
// * 用户运营商详单汇总hbase数据补全
// * Created by zhangyu on 2017/8/15.
// */
//
//
//@SpringBootApplication
//@Component
//public class PhoneContactsMerge implements InitializingBean {
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
//    private Logger logger = LoggerFactory.getLogger(PhoneContactsMerge.class);
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
//        SpringApplication.run(PhoneContactsMerge.class, args);
//    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        // TODO Auto-generated method stub
//        for (int i = 0; i <= 2341607; i++) {
//            int a = i;
//            executorService.execute(new Runnable() {
//                @Override
//                public void run() {
//                    mergeHbasePhoneContacts(a);
//                }
//            });
//        }
//
//    }
//
//
//    private void mergeHbasePhoneContacts(int userId) {
//        List<PhoneContacts> allPhoneContactsList = queryHbaseUserLocation(userId);
//        List<PhoneContacts> phoneContactsListPart = updateHbaseUserLocation(userId);
//        for (PhoneContacts phoneContacts : allPhoneContactsList) {
//            if (phoneContactsListPart.contains(phoneContacts)) {
//                continue;
//            } else {
//                try {
//                   // String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 16);
//                    jdbcTemplateForUpdate
//                            .execute(
//                                    "upsert into contacts VALUES ('" + phoneContacts.getId() + "',"
//                                            + phoneContacts.getUserId()
//                                            + ",'"
//                                            + phoneContacts.getPhone()
//                                            + "','"
//                                            + phoneContacts.getOtherPhone()
//                                            + "','"
//                                            + phoneContacts.getFirstCall()
//                                            + "','"
//                                            + phoneContacts.getLastCall()
//                                            + "',"
//                                            + phoneContacts.getInTimes()
//                                            + ","
//                                            + phoneContacts.getOutTimes()
//                                            + ","
//                                            + phoneContacts.getInDuration()
//                                            + ","
//                                            + phoneContacts.getOutDuration()
//                                            + ","
//                                            + phoneContacts.getInFee()
//                                            + ","
//                                            + phoneContacts.getOutFee()
//                                            + ","
//                                            + phoneContacts.getAllTimes()
//                                            + ",'"
//                                            + phoneContacts.getCallLocation()
//                                            + "','"
//                                            + phoneContacts.getCommType()
//                                            + "'"
//                                            +
//                                            ")"
//                            );
//
//                } catch (Exception e) {
//                    logger.error("插入hbase报错", e);
//                }
//                logger.info("合并后数据保存到hbase成功该记录的userId,otherphone为：" + phoneContacts.getUserId() + "," + phoneContacts.getOtherPhone());
//            }
//        }
//    }
//
//    private List<PhoneContacts> updateHbaseUserLocation(int userId) {
//        String sql = " select id,userId,phone,otherPhone,firstCall,lastCall,inTimes,outTimes,inDuration,outDuration,inFee,outFee,allTimes,callLocation,commType from contacts  where userId = " + userId;
//        //缺少数据的hbase
//        List<PhoneContacts> phoneContactsListPart = null;
//        try {
//            phoneContactsListPart = jdbcTemplateForUpdate.query(sql,
//                    new BeanPropertyRowMapper<PhoneContacts>(PhoneContacts.class));
//            logger.info("【hBaseQuery】执行查询运营商数据（缺失数据）成功：" + phoneContactsListPart.size());
//        } catch (Exception e) {
//            logger.error("【hBaseQuery】执行查询（缺少数据的hbase）失败，sql:" + sql + "，失败原因:" + e.toString());
//        }
//        return phoneContactsListPart;
//    }
//
//    private List<PhoneContacts> queryHbaseUserLocation(int userId) {
//        String sql = " select id,userId,phone,otherPhone,firstCall,lastCall,inTimes,outTimes,inDuration,outDuration,inFee,outFee,allTimes,callLocation,commType from contacts where userId = " + userId;
//        List<PhoneContacts> phoneContactsList = null;
//        try {
//            phoneContactsList = jdbcTemplateforQuery.query(sql,
//                    new BeanPropertyRowMapper<PhoneContacts>(PhoneContacts.class));
//                      logger.info("【hBaseQuery】执行查询运营商数据（完整数据）成功：" + phoneContactsList.size());
//        } catch (Exception e) {
//            logger.error("【hBaseQuery】执行查询（完整数据）失败，sql:" + sql + "，失败原因:" + e.toString());
//        }
//        return phoneContactsList;
//    }
//
//}
//
