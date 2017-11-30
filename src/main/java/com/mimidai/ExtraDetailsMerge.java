//package com.mimidai;
//
//import com.mimidai.entity.ExtraDetailsSimple;
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
// * 用户敏感电话hbase数据补全
// * Created by zhangyu on 2017/8/15.
// */
//@SpringBootApplication
//@Component
//public class ExtraDetailsMerge implements InitializingBean {
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
//    private Logger logger = LoggerFactory.getLogger(ExtraDetailsMerge.class);
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
//        SpringApplication.run(ExtraDetailsMerge.class, args);
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
//        List<ExtraDetailsSimple> allExtraDetailsSimpleList = queryHbaseUserLocation(userId);
//        List<ExtraDetailsSimple> extraDetailsSimpleListPart = updateHbaseUserLocation(userId);
//        for (ExtraDetailsSimple extraDetailsSimple : allExtraDetailsSimpleList) {
//            if (extraDetailsSimpleListPart.contains(extraDetailsSimple)) {
//                continue;
//            } else {
//                try {
//                    String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 16);
//                    jdbcTemplateForUpdate
//                            .execute(
//                                    "upsert into extralDetails VALUES ('" + extraDetailsSimple.getId() + "',"
//                                            + extraDetailsSimple.getUserId()
//                                            + ",'"
//                                            + extraDetailsSimple.getPhone()
//                                            + "','"
//                                            + extraDetailsSimple.getOtherPhone()
//                                            + "','"
//                                            + extraDetailsSimple.getFirstCall()
//                                            + "','"
//                                            + extraDetailsSimple.getLastCall()
//                                            + "',"
//                                            + extraDetailsSimple.getInTimes()
//                                            + ","
//                                            + extraDetailsSimple.getOutTimes()
//                                            + ","
//                                            + extraDetailsSimple.getInDuration()
//                                            + ","
//                                            + extraDetailsSimple.getOutDuration()
//                                            + ","
//                                            + extraDetailsSimple.getInFee()
//                                            + ","
//                                            + extraDetailsSimple.getOutFee()
//                                            + ","
//                                            + extraDetailsSimple.getAllTimes()
//                                            + ",'"
//                                            + extraDetailsSimple.getCallLocation()
//                                            + "','"
//                                            + extraDetailsSimple.getType()
//                                            + "','"
//                                            + extraDetailsSimple.getPlatform()
//                                            + "','"
//                                            + extraDetailsSimple.getCommType()
//                                            + "'"
//                                            +
//                                            ")"
//                            );
//
//                } catch (Exception e) {
//                    logger.error("插入hbase报错", e);
//                }
//                logger.info("合并后数据保存到hbase成功该记录的userId,otherPhone为：" + extraDetailsSimple.getUserId() + "," + extraDetailsSimple.getOtherPhone());
//            }
//        }
//    }
//
//    private List<ExtraDetailsSimple> updateHbaseUserLocation(int userId) {
//        String sql = " select id,userId,phone,otherPhone,firstCall,lastCall,inTimes,outTimes,inDuration,outDuration,inFee,outFee,allTimes,callLocation,type,platform,commType from extralDetails where userId = " + userId;
//        //缺少数据的hbase
//        List<ExtraDetailsSimple> extraDetailsSimpleListPart = null;
//        try {
//            extraDetailsSimpleListPart = jdbcTemplateForUpdate.query(sql,
//                    new BeanPropertyRowMapper<ExtraDetailsSimple>(ExtraDetailsSimple.class));
//            logger.info("【hBaseQuery】执行查询敏感电话成功：" + extraDetailsSimpleListPart.size());
//        } catch (Exception e) {
//            logger.error("【hBaseQuery】执行查询（缺少数据的hbase）失败，sql:" + sql + "，失败原因:" + e.toString());
//        }
//        return extraDetailsSimpleListPart;
//    }
//
//    private List<ExtraDetailsSimple> queryHbaseUserLocation(int userId) {
//        String sql = " select id,userId,phone,otherPhone,firstCall,lastCall,inTimes,outTimes,inDuration,outDuration,inFee,outFee,allTimes,callLocation,type,platform,commType from extralDetails where userId = " + userId;
//        List<ExtraDetailsSimple> extraDetailsSimpleList = null;
//        try {
//            extraDetailsSimpleList = jdbcTemplateforQuery.query(sql,
//                    new BeanPropertyRowMapper<ExtraDetailsSimple>(ExtraDetailsSimple.class));
//            logger.info("【hBaseQuery】执行查询敏感电话(完整数据hbase)成功：" + extraDetailsSimpleList.size());
//        } catch (Exception e) {
//            logger.error("【hBaseQuery】执行查询（完整数据）失败，sql:" + sql + "，失败原因:" + e.toString());
//        }
//        return extraDetailsSimpleList;
//    }
//}
