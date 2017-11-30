//
//package com.mimidai;
//
//import com.mimidai.entity.UserLocation;
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
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//
///**
// * 用户地理位置hbase数据补全 UserLocation
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
//
//        for (int i = 0; i <= 2341607; i++) {
//            int a = i;
//            executorService.execute(new Runnable() {
//                @Override
//                public void run() {
//                    mergeHbaseUserLocation(a);
//                }
//            });
//        }
//    }
//
//
//    private void mergeHbaseUserLocation(int userId) {
//        List<UserLocation> allUserLocationList = queryHbaseUserLocation(userId);
//        List<UserLocation> userLocationPart = updateHbaseUserLocation(userId);
//        for (UserLocation userLocation : allUserLocationList) {
//            if (userLocationPart.contains(userLocation)) {
//                continue;
//            } else {
//                try {
//                  //  String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 16);
//                    jdbcTemplateForUpdate
//                            .execute(
//                                    "upsert into userlocation VALUES ('" + userLocation.getId() + "',"
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
//        String sql = " select id,userId,address,lng,lat,createTime from userlocation where userId = " + userId;
//        //缺少数据的hbase
//        List<UserLocation> userLocationListPart = null;
//        try {
//            userLocationListPart = jdbcTemplateForUpdate.query(sql,
//                    new BeanPropertyRowMapper<UserLocation>(UserLocation.class));
//            logger.info("【hBaseQuery】执行查询userLocation（数据缺失）成功：" + userLocationListPart.size());
//        } catch (Exception e) {
//            logger.error("【hBaseQuery】执行查询（缺少数据的hbase）失败，sql:" + sql + "，失败原因:" + e.toString());
//        }
//        return userLocationListPart;
//    }
//
//    private List<UserLocation> queryHbaseUserLocation(int userId) {
//        String sql = " select id,userId,address,lng,lat,createTime from userlocation where userId = " + userId;
//        List<UserLocation> userLocationList = null;
//        try {
//            userLocationList = jdbcTemplateforQuery.query(sql,
//                    new BeanPropertyRowMapper<UserLocation>(UserLocation.class));
//            logger.info("【hBaseQuery】执行查询userLocation（完整数据）成功：" + userLocationList.size());
//        } catch (Exception e) {
//            logger.error("【hBaseQuery】执行查询（完整数据）失败，sql:" + sql + "，失败原因:" + e.toString());
//        }
//        return userLocationList;
//    }
//
//}
//
//
//
