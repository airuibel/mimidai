//package com.mimidai;
//
//import com.mimidai.entity.PhoneTon;
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
// * 用户通讯录hbase数据补全
// * Created by zhangyu on 2017/8/15.
// */
//
//@SpringBootApplication
//@Component
//public class PhoneTonMerge implements InitializingBean {
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
//    private Logger logger = LoggerFactory.getLogger(PhoneTonMerge.class);
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
//        SpringApplication.run(PhoneTonMerge.class, args);
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
//                    mergeHbasePhoneTonMerge(a);
//                }
//            });
//        }
//    }
//
//
//    private void mergeHbasePhoneTonMerge(int userId) {
//        List<PhoneTon> allphoneTonList = queryHbaseUserLocation(userId);
//        List<PhoneTon> phoneTonListPart = updateHbaseUserLocation(userId);
//        try {
//            for (PhoneTon phoneTon : allphoneTonList) {
//                if (phoneTonListPart.contains(phoneTon)) {
//                    continue;
//                } else {
//                    String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 16);
//                    jdbcTemplateForUpdate
//                            .execute(
//                                    "upsert into phoneContacts VALUES ('" + phoneTon.getId() + "',"
//                                            + phoneTon.getUserId()
//                                            + ",'"
//                                            + phoneTon.getImei()
//                                            + "','"
//                                            + phoneTon.getImsi()
//                                            + "','"
//                                            + phoneTon.getPhone()
//                                            + "','"
//                                            + phoneTon.getName()
//                                            + "',"
//                                            + phoneTon.getCallTimes()
//                                            + ",'"
//                                            + phoneTon.getLastCall()
//                                            + "'"
//                                            +
//                                            ")"
//                            );
//
//                }
//            logger.info("合并后数据保存到hbase成功该记录的userId,phone为：" + phoneTon.getUserId() + "," + phoneTon.getPhone());
//            }
//        } catch (Exception e) {
//            logger.error("插入hbase报错", e);
//            e.printStackTrace();
//        }
//    }
//
//    private List<PhoneTon> updateHbaseUserLocation(int userId) {
//        String sql = " select id,userId,imei,imsi,phone,name,callTimes,lastCall from phoneContacts where userId = " + userId;
//        //缺少数据的hbase
//        List<PhoneTon> phoneTonListPart = null;
//        try {
//            phoneTonListPart = jdbcTemplateForUpdate.query(sql,
//                    new BeanPropertyRowMapper<PhoneTon>(PhoneTon.class));
//            logger.info("【hBaseQuery】执行查询通信录（缺少数据的hbase）成功：" + phoneTonListPart.size());
//        } catch (Exception e) {
//            logger.error("【hBaseQuery】执行查询（缺少数据的hbase）失败，sql:" + sql + "，失败原因:" + e.toString());
//        }
//        return phoneTonListPart;
//    }
//
//    private List<PhoneTon> queryHbaseUserLocation(int userId) {
//        String sql = " select id,userId,imei,imsi,phone,name,callTimes,lastCall from phonecontacts where userId = " + userId;
//        List<PhoneTon> phoneTonList = null;
//        try {
//            phoneTonList = jdbcTemplateforQuery.query(sql,
//                    new BeanPropertyRowMapper<PhoneTon>(PhoneTon.class));
//            logger.info("【hBaseQuery】执行查询通讯录（完整数据）成功：" + phoneTonList.size());
//        } catch (Exception e) {
//            logger.error("【hBaseQuery】执行查询通讯录（完整数据）失败，sql:" + sql + "，失败原因:" + e.toString());
//        }
//        return phoneTonList;
//    }
//
//
//}
