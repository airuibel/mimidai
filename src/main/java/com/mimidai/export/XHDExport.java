//package com.mimidai;
//
//import com.google.common.collect.Lists;
//import com.google.common.collect.Maps;
//import com.google.gson.Gson;
//import com.mimidai.entity.*;
//import com.mimidai.service.MspService;
//import com.mimidai.service.UserInfoService;
//import com.mimidai.service.XhdService;
//import com.mimidai.utils.TableStoreUtils;
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
//import org.springframework.util.CollectionUtils;
//
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.*;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
///**
// * Created by zhangyu on 2017/7/17.
// */
////@SpringBootApplication
//@Component
//public class XHDExport implements InitializingBean {
//
//    private static final Logger logger = LoggerFactory.getLogger("log.tableStore.TableStoreUtils");
//
//    // 使用10个线程执行
//    private ExecutorService executorService = Executors.newFixedThreadPool(10);
//
//    @Autowired
//    @Qualifier("phoenixJdbcTemplate")
//    private JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    private XhdService xhdService;
////    @Autowired
////    private MspService mspService;
//    @Autowired
//    private UserInfoService userInfoService;
////
////    @Autowired
////    private SolrClient solrClient;
////
////    @Autowired
////    private TableStoreUtils tableStoreUtils;
//
//    private String path = "/home/zhangyu/0808";
//    private String fileName = "Export0808.csv";
//    private File file = new File(path, fileName);
//    private FileWriter fw = null;
//    private PrintWriter pw = null;
//
//
//    private void initWr() {
//        try {
//            fw = new FileWriter(file, true);
//            pw = new PrintWriter(fw);
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            System.out.println("文件写出流创建异常！");
//            e.printStackTrace();
//        }
//
//    }
//
//
//    public static void main1(String[] args) {
//        SpringApplication.run(com.mimidai.XHDExport.class, args);
//    }
//
//    public void queryUserInfo() {
//        List<UserInfo> XhdUserInfoList = xhdService.queryUser();
//        logger.info("用户数为：" + XhdUserInfoList.size());
//        for (UserInfo userIdcard : XhdUserInfoList) {
//            logger.info("userId：" + userIdcard.getUserId());
//            StringBuilder sb0 = new StringBuilder("姓名,userId,身份证,是否逾期,通话详情总次数,总通话次数第一名通话次数,1呼入次数,1呼入时长,1呼出次数,1呼出时长,总通话次数第二名通话次数,2呼入次数,2呼入时长,2呼出次数,2呼出时长,总通话次数第三名通话次数,3呼入次数,3呼入时长,3呼出次数,3呼出时长,总通话次数第四名通话次数,4呼入次数,4呼入时长,4呼出次数,4呼出时长,总通话次数第五名通话次数,5呼入次数,5呼入时长,5呼出次数,5呼出时长,敏感电话总次数,敏感电话一个月内次数,敏感电话两个月内次数,敏感电话三个月内次数,运营商通讯录总人数,贷后帮查询结果-认识间接黑人的直接联系人个数" +
//                    ",贷后帮查询结果-间接联系人在黑名单中数量(间接黑人)）,贷后帮查询结果-身份证号记录天数,贷后帮查询结果-手机号记录天数,贷后帮查询结果 -最近60天查询次数,贷后帮查询结果-身份证最近出现时间,贷后帮查询结果-手机最近出现时间,安融查询结果-异常还款记录,安融查询结果-6个月贷款申请记录,安融查询结果-行业不良记录,安融查询结果-正常还款账户,安融查询结果-2年内查询记录,安融查询结果-债权信息统计,安融查询结果-债权信息统计-最近6个月贷款申请：申请中笔数" +
//                    ",安融查询结果-债权信息统计-最近6个月贷款申请：拒绝笔数");
//            executorService.execute(new Runnable() {
//                @Override
//                public void run() {
//                    query(userIdcard, sb0);
//                }
//            });
//        }
//    }
////
////       /* List<Long> mockList = Lists.newArrayList();
////        mockList.add(455680l);
////        mockList.add(455437l);
////        mockList.add(454753l);
////        mockList.add(454748l);
////        mockList.add(454889l);
////        mockList.add(455702l);
////        mockList.add(454960l);
////        mockList.add(370922l);
////        for (Long user : mockList) {
////            query(user);
////        }*/
////
////        }
////        Long userId = 289130L;
////        StringBuilder sb0 = new StringBuilder("姓名,userId,身份证,是否逾期,通话详情总次数,总通话次数第一名通话次数,1呼入次数,1呼入时长,1呼出次数,1呼出时长,总通话次数第二名通话次数,2呼入次数,2呼入时长,2呼出次数,2呼出时长,总通话次数第三名通话次数,3呼入次数,3呼入时长,3呼出次数,3呼出时长,总通话次数第四名通话次数,4呼入次数,4呼入时长,4呼出次数,4呼出时长,总通话次数第五名通话次数,5呼入次数,5呼入时长,5呼出次数,5呼出时长,敏感电话总次数,敏感电话一个月内次数,敏感电话两个月内次数,敏感电话三个月内次数,运营商通讯录总人数,贷后帮查询结果-认识间接黑人的直接联系人个数" +
////                   ",贷后帮查询结果-间接联系人在黑名单中数量(间接黑人)）,贷后帮查询结果-身份证号记录天数,贷后帮查询结果-手机号记录天数,贷后帮查询结果 -最近60天查询次数,贷后帮查询结果-身份证最近出现时间,贷后帮查询结果-手机最近出现时间,安融查询结果-异常还款记录,安融查询结果-6个月贷款申请记录,安融查询结果-行业不良记录,安融查询结果-正常还款账户,安融查询结果-2年内查询记录,安融查询结果-债权信息统计,安融查询结果-债权信息统计-最近6个月贷款申请：申请中笔数" +
////                    ",安融查询结果-债权信息统计-最近6个月贷款申请：拒绝笔数");
////        query(userId, sb0);
////
////    }
//
//
//    public void query(UserInfo userInfo, StringBuilder sb0) {
//
//        Gson gson = new Gson();
//        initWr();
////        Long userId = userInfo.getUserId();
////        String phone = userInfo.getPhone();
////        MspQuery mspQuery = mspService.findNewQueryByUserIdAndType(userId, "1");
////        MspResult mspResult = null;
////        if (mspQuery != null) {
////            mspResult = mspService.findResultByQueryId(mspQuery.getId());
////        }
////        //MspResult mspResult = mspService.findResultByQueryId(userId);
////        List<MspApplyDetails> mspApplyDetails = null;
////        TpTsp tsp = null;
////        if (mspResult != null && mspResult.getId() != null) {
////            mspApplyDetails = mspService.findDetails(mspResult.getId().intValue());
////            tsp = userInfoService.queryTpTspApplying(mspResult.getId().intValue());
////        }
//        //安融查询结果-行业不良记录
////        Integer black = userInfoService.queryTpBlack(userId);
////        logger.info("安融查询结果-行业不良记录:" + black,"userId:"+userId);
//        //安融查询结果-债权信息统计-最近6个月贷款申请：申请中笔数,拒绝笔数
//
//        // logger.info("安融查询结果-债权信息统计-最近6个月贷款申请：申请中笔数,拒绝笔数,userId", tsp.getApplyingCount(), tsp.getApplyRejectCount(), userId);
////        //安融查询结果-异常还款记录,6个月贷款申请记录,正常还款账户,2年内查询记录
////        TPTsm  tsm = userInfoService.queryTp(resultId);
//        // logger.info("安融查询结果-异常还款记录,6个月贷款申请记录,正常还款账户,2年内查询记录,userId:" ,tsm.getEtotalCount(),tsm.getApplyTotalCount(),tsm.getTotalCount(),tsm.getQueryCount(),userId);
//
////
////        logger.warn("【HBase】进入查询（core5）方法===>");
////
////        StringBuffer sb1 = new StringBuffer(
////                " select id from EXTRAlDETAILS where userId =  " + userId);
////
////        StringBuffer sb2 = new StringBuffer(
////                " select id from phonecontacts where userId =  " + userId);
//        Long userId = userInfo.getUserId();
//        StringBuffer sb = new StringBuffer(
//                " select userId,otherPhone,alltimes from contacts where  userId =  " + userId );
//
////        sb.append(" order by alltimes desc");
////        sb.append(" limit  5");
////        sb1.append(" order by alltimes desc");
//        String sql = sb.toString();
////        String sql1 = sb1.toString();
////        String sql2 = sb2.toString();
//        logger.warn("【HBase】进入查询（core5）方法，sql={}", sql);
//       // List<Contacts> contactsList = null;
//        int allCount = 0;
//        List<SolrExtraDetails> contactsList1 = null;
//        try {
//            long startTime = System.currentTimeMillis();
//            contactsList1 = jdbcTemplate.query(sql,
//                    new BeanPropertyRowMapper<SolrExtraDetails>(SolrExtraDetails.class));
//            long endTime = System.currentTimeMillis();
//            float excTime = (float) (endTime - startTime) / 1000;
//            logger.info("【HBase】执行查询（core5）成功，sql:" + sql + "，耗时：" + excTime + "查询通话详单数据：" + contactsList1.size());
//            for (SolrExtraDetails solrExtraDetails : contactsList1) {
//                if(solrExtraDetails.getOtherPhone().equals("02131338933")||
//                        solrExtraDetails.getOtherPhone().equals("4007571310")||
//                        solrExtraDetails.getOtherPhone().equals("02110101058")||
//                        solrExtraDetails.getOtherPhone().equals("02180203636")||
//                        solrExtraDetails.getOtherPhone().equals("40099871010")||
//                        solrExtraDetails.getOtherPhone().equals("4008200588")||
//                        solrExtraDetails.getOtherPhone().equals("02180349136")||
//                        solrExtraDetails.getOtherPhone().equals("4008205555")||
//                        solrExtraDetails.getOtherPhone().equals("4000268888")||
//                        solrExtraDetails.getOtherPhone().equals("4008208788")||
//                        solrExtraDetails.getOtherPhone().equals("125909888601")||
//                        solrExtraDetails.getOtherPhone().equals("4006695599")||
//                        solrExtraDetails.getOtherPhone().equals("02110100000")||
//                        solrExtraDetails.getOtherPhone().equals("4001848888")||
//                        solrExtraDetails.getOtherPhone().equals("4008895558")||
//                        solrExtraDetails.getOtherPhone().equals("10101058")||
//                        solrExtraDetails.getOtherPhone().equals("075533987194")||
//                        solrExtraDetails.getOtherPhone().equals("4008623400")||
//                        solrExtraDetails.getOtherPhone().equals("4006695568")||
//                        solrExtraDetails.getOtherPhone().equals("02180203375")||
//                        solrExtraDetails.getOtherPhone().equals("4008009888")||
//                        solrExtraDetails.getOtherPhone().equals("4007888888")||
//                        solrExtraDetails.getOtherPhone().equals("95017")){
//                    allCount = ++allCount ;
//                }
//            }
////            long startTime2 = System.currentTimeMillis();
////            contactsList1 = jdbcTemplate.query(sql1,
////                    new BeanPropertyRowMapper<SolrExtraDetails>(SolrExtraDetails.class));
////            long endTime2 = System.currentTimeMillis();
////            float excTime2 = (float) (endTime2 - startTime2) / 1000;
////            logger.info("【HBase】执行查询（core6）成功，sql:" + sql1 + "，耗时：" + excTime2 +
////                    "查询到敏感电话：" + contactsList1.size());
////            List<Contacts> contactsList2 = Lists.newArrayList();
////            List<Contacts> contactsList3 = Lists.newArrayList();
////            List<Contacts> contactsList4 = Lists.newArrayList();
////            List<Contacts> contactsList5 = Lists.newArrayList();
////            List<Contacts> contactsList6 = Lists.newArrayList();
////            List<Contacts> contactsList7 = Lists.newArrayList();
////            for (Contacts contacts : contactsList) {
////                if (contacts.getLastCall().substring(0, 7).equals("2017年04")) {
////                    contactsList2.add(contacts);
////                }
////                if (contacts.getLastCall().substring(0, 7).equals("2017年03")) {
////                    contactsList3.add(contacts);
////                }
////                if (contacts.getLastCall().substring(0, 7).equals("2017年02")) {
////                    contactsList4.add(contacts);
////                }
////                if (contacts.getLastCall().substring(0, 7).equals("2017年01")) {
////                    contactsList5.add(contacts);
////                }
////                if (contacts.getLastCall().substring(0, 7).equals("2016年12")) {
////                    contactsList6.add(contacts);
////                }
////                if (contacts.getLastCall().substring(0, 7).equals("2016年11")) {
////                    contactsList7.add(contacts);
////                }
////
////            }
////            Collections.sort(contactsList2);
////            Collections.sort(contactsList3);
////            Collections.sort(contactsList4);
////            Collections.sort(contactsList5);
////            Collections.sort(contactsList6);
////            Collections.sort(contactsList7);
//
//
////        List<TableCallDetails> tableCallDetails1List = null;
////        try {
////            Row row = tableStoreUtils.getDateRow(userInfo.getUserId(), userInfo.getPhone());
////            if (row != null) {
////                List<Column> details = row.getColumn("details");
////                String json = details.get(0).getValue().toString();
////                tableCallDetails1List = gson.fromJson(json, new TypeToken<List<TableCallDetails>>() {
////                }.getType());
////                logger.info("从表格存储里面查询到" + tableCallDetails1List.size() + "条数据");
////            }
////        } catch (Exception e) {
////            logger.info("查询表格存储失败,userId,phone{}:" + userInfo.getUserId(), userInfo.getPhone());
////        }
//
//        //业务逻辑处理
//     //   dataGroup(tableCallDetails1List);
////        Row row = tableStoreUtils.getDateRow(userId, phone);
////        List<tableCallDetails1> tableList = null;
////        if (row != null) {
////            List<Column> details = row.getColumn("details");
////            String json = details.get(0).getValue().toString();
////            tableList = gson.fromJson(json, new TypeToken<List<tableCallDetails1>>() {
////            }.getType());
////            logger.info("从表格存储里面查询到" + tableList.size() + "条数据");
////        }
////        if(CollectionUtils.isEmpty(tableList)){
////            return;
////        }
////        }
//
//
//
////            Map<Integer, String> firstCallMap = Maps.newHashMap();
////            Map<Integer, String> lastCallMap = Maps.newHashMap();
////            for (int i = 0; i < 6; i++) {
////                if (list.size() >= i + 1) {
////                    if (list.get(i) != null && list.get(i).getValue() != null && list.get(i).getValue().getOtherPhone() != null) {
////                        String otherPhone = list.get(i).getValue().getOtherPhone();
////                        StringBuffer sb = new StringBuffer(
////                                " select userId,alltimes,intimes,outtimes,firstCall,lastCall from contacts where  userId =  " + userId + "  and  otherPhone = " + "'" + otherPhone + "'");
////
////
////                        String sql = sb.toString();
////
////                        List<Contacts> contactsList = null;
////                        try {
////                            long startTime = System.currentTimeMillis();
////                            contactsList = jdbcTemplate.query(sql,
////                                    new BeanPropertyRowMapper<Contacts>(Contacts.class));
////                            long endTime = System.currentTimeMillis();
////                            float excTime = (float) (endTime - startTime) / 1000;
////                            logger.info("【HBase】执行查询（core5）成功，sql:" + sql + "，耗时：" + excTime + "查询通话详单数据：" + contactsList.size());
////                        } catch (Exception e) {
////                            e.printStackTrace();
////                            logger.error("【HBase】执行查询（core5）失败，sql:" + sql);
////                        }
////
////                        if (contactsList != null && contactsList.size() > 0) {
////                            String firstCall = contactsList.get(0).getFirstCall();
////                            String lastCall = contactsList.get(0).getLastCall();
////                            firstCallMap.put(i, firstCall);
////                            lastCallMap.put(i, lastCall);
////                        }
////                    }
////                }
////            }
////
////
////            Map<Integer, String> firstCallMap1 = Maps.newHashMap();
////            Map<Integer, String> lastCallMap1 = Maps.newHashMap();
////            for (int i = 0; i < 5; i++) {
////                if (list1.size() >= i + 1) {
////                    if (list1.get(i) != null && list1.get(i).getValue() != null && list1.get(i).getValue().getOtherPhone() != null) {
////                        String otherPhone = list1.get(i).getValue().getOtherPhone();
////                        StringBuffer sb = new StringBuffer(
////                                " select userId,alltimes,intimes,outtimes,firstCall,lastCall from contacts where  userId =  " + userId + "  and  otherPhone = " + "'" + otherPhone + "'");
////                        String sql = sb.toString();
////
////                        List<Contacts> contactsList = null;
////                        try {
////                            long startTime = System.currentTimeMillis();
////                            contactsList = jdbcTemplate.query(sql,
////                                    new BeanPropertyRowMapper<Contacts>(Contacts.class));
////                            long endTime = System.currentTimeMillis();
////                            float excTime = (float) (endTime - startTime) / 1000;
////                            logger.info("【HBase】执行查询（core5）成功，sql:" + sql + "，耗时：" + excTime + "查询通话详单数据：" + contactsList.size());
////                        } catch (Exception e) {
////                            e.printStackTrace();
////                            logger.error("【HBase】执行查询（core5）失败，sql:" + sql);
////                        }
////
////
////                        if (contactsList != null && contactsList.size() > 0) {
////                            String firstCall = contactsList.get(0).getFirstCall();
////                            String lastCall = contactsList.get(0).getLastCall();
////                            firstCallMap1.put(i, firstCall);
////                            lastCallMap1.put(i, lastCall);
////                        }
////                    }
////                }
////            }
////            Map<Integer, String> firstCallMap2 = Maps.newHashMap();
////            Map<Integer, String> lastCallMap2 = Maps.newHashMap();
////            for (int i = 0; i < 5; i++) {
////                if (list2.size() >= i + 1) {
////                    if (list2.get(i) != null && list2.get(i).getValue() != null && list2.get(i).getValue().getOtherPhone() != null) {
////                        String otherPhone = list2.get(i).getValue().getOtherPhone();
////                        StringBuffer sb = new StringBuffer(
////                                " select userId,alltimes,intimes,outtimes,firstCall,lastCall from contacts where  userId =  " + userId + "  and  otherPhone = " + "'" + otherPhone + "'");
////
////                        sb.append(" order by alltimes desc");
////                        sb.append(" limit  5");
////
////                        String sql = sb.toString();
////
////                        List<Contacts> contactsList = null;
////                        try {
////                            long startTime = System.currentTimeMillis();
////                            contactsList = jdbcTemplate.query(sql,
////                                    new BeanPropertyRowMapper<Contacts>(Contacts.class));
////                            long endTime = System.currentTimeMillis();
////                            float excTime = (float) (endTime - startTime) / 1000;
////                            logger.info("【HBase】执行查询（core5）成功，sql:" + sql + "，耗时：" + excTime + "查询通话详单数据：" + contactsList.size());
////                        } catch (Exception e) {
////                            e.printStackTrace();
////                            logger.error("【HBase】执行查询（core5）失败，sql:" + sql);
////                        }
////
////
////                        if (contactsList != null && contactsList.size() > 0) {
////                            String firstCall = contactsList.get(0).getFirstCall();
////                            String lastCall = contactsList.get(0).getLastCall();
////                            firstCallMap2.put(i, firstCall);
////                            lastCallMap2.put(i, lastCall);
////                        }
////                    }
////                }
////            }
////
////            Map<Integer, String> firstCallMap3 = Maps.newHashMap();
////            Map<Integer, String> lastCallMap3 = Maps.newHashMap();
////            for (int i = 0; i < 5; i++) {
////                if (list3.size() >= i + 1) {
////                    if (list3.get(i) != null && list3.get(i).getValue() != null && list3.get(i).getValue().getOtherPhone() != null) {
////                        String otherPhone = list3.get(i).getValue().getOtherPhone();
////                        StringBuffer sb = new StringBuffer(
////                                " select userId,alltimes,intimes,outtimes,firstCall,lastCall from contacts where  userId =  " + userId + "  and  otherPhone = " + "'" + otherPhone + "'");
////
////                        sb.append(" order by alltimes desc");
////                        sb.append(" limit  5");
////
////                        String sql = sb.toString();
////
////                        List<Contacts> contactsList = null;
////                        try {
////                            long startTime = System.currentTimeMillis();
////                            contactsList = jdbcTemplate.query(sql,
////                                    new BeanPropertyRowMapper<Contacts>(Contacts.class));
////                            long endTime = System.currentTimeMillis();
////                            float excTime = (float) (endTime - startTime) / 1000;
////                            logger.info("【HBase】执行查询（core5）成功，sql:" + sql + "，耗时：" + excTime + "查询通话详单数据：" + contactsList.size());
////                        } catch (Exception e) {
////                            e.printStackTrace();
////                            logger.error("【HBase】执行查询（core5）失败，sql:" + sql);
////                        }
////
////
////                        if (contactsList != null && contactsList.size() > 0) {
////                            String firstCall = contactsList.get(0).getFirstCall();
////                            String lastCall = contactsList.get(0).getLastCall();
////                            firstCallMap3.put(i, firstCall);
////                            lastCallMap3.put(i, lastCall);
////                        }
////                    }
////                }
////            }
////            Map<Integer, String> firstCallMap4 = Maps.newHashMap();
////            Map<Integer, String> lastCallMap4 = Maps.newHashMap();
////            for (int i = 0; i < 5; i++) {
////                if (list4.size() >= i + 1) {
////                    if (list4.get(i) != null && list4.get(i).getValue() != null && list4.get(i).getValue().getOtherPhone() != null) {
////                        String otherPhone = list4.get(i).getValue().getOtherPhone();
////                        StringBuffer sb = new StringBuffer(
////                                " select userId,alltimes,intimes,outtimes,firstCall,lastCall from contacts where  userId =  " + userId + " and  otherPhone = " + "'" + otherPhone + "'");
////
////                        sb.append(" order by alltimes desc");
////                        sb.append(" limit  5");
////
////                        String sql = sb.toString();
////
////                        List<Contacts> contactsList = null;
////                        try {
////                            long startTime = System.currentTimeMillis();
////                            contactsList = jdbcTemplate.query(sql,
////                                    new BeanPropertyRowMapper<Contacts>(Contacts.class));
////                            long endTime = System.currentTimeMillis();
////                            float excTime = (float) (endTime - startTime) / 1000;
////                            logger.info("【HBase】执行查询（core5）成功，sql:" + sql + "，耗时：" + excTime + "查询通话详单数据：" + contactsList.size());
////                        } catch (Exception e) {
////                            e.printStackTrace();
////                            logger.error("【HBase】执行查询（core5）失败，sql:" + sql);
////                        }
////
////
////                        if (contactsList != null && contactsList.size() > 0) {
////                            String firstCall = contactsList.get(0).getFirstCall();
////                            String lastCall = contactsList.get(0).getLastCall();
////                            firstCallMap4.put(i, firstCall);
////                            lastCallMap4.put(i, lastCall);
////                        }
////                    }
////                }
////            }
////            Map<Integer, String> firstCallMap5 = Maps.newHashMap();
////            Map<Integer, String> lastCallMap5 = Maps.newHashMap();
////            for (int i = 0; i < 5; i++) {
////                if (list5.size() >= i + 1) {
////                    if (list5.get(i) != null && list5.get(i).getValue() != null && list5.get(i).getValue().getOtherPhone() != null) {
////                        String otherPhone = list5.get(i).getValue().getOtherPhone();
////                        StringBuffer sb = new StringBuffer(
////                                " select userId,alltimes,intimes,outtimes,firstCall,lastCall from contacts where  userId =  " + userId + " and  otherPhone = " + "'" + otherPhone + "'");
////
////
////                        String sql = sb.toString();
////
////                        List<Contacts> contactsList = null;
////                        try {
////                            long startTime = System.currentTimeMillis();
////                            contactsList = jdbcTemplate.query(sql,
////                                    new BeanPropertyRowMapper<Contacts>(Contacts.class));
////                            long endTime = System.currentTimeMillis();
////                            float excTime = (float) (endTime - startTime) / 1000;
////                            logger.info("【HBase】执行查询（core5）成功，sql:" + sql + "，耗时：" + excTime + "查询通话详单数据：" + contactsList.size());
////                        } catch (Exception e) {
////                            e.printStackTrace();
////                            logger.error("【HBase】执行查询（core5）失败，sql:" + sql);
////                        }
////
////
////                        if (contactsList != null && contactsList.size() > 0) {
////                            String firstCall = contactsList.get(0).getFirstCall();
////                            String lastCall = contactsList.get(0).getLastCall();
////                            firstCallMap5.put(i, firstCall);
////                            lastCallMap5.put(i, lastCall);
////                        }
////                    }
////                }
////            }
////
////         /*  */
////            //运营商通讯录总人数
////            int phoneContactCount = 0;
////
////            long startTime3 = System.currentTimeMillis();
////            List<UserPhoneContacts> contactsList11 = jdbcTemplate.query(sql2,
////                    new BeanPropertyRowMapper<UserPhoneContacts>(UserPhoneContacts.class));
////            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-mm");
////            SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy年mm");
////            List<UserPhoneContacts> userPhoneContactsList = Lists.newArrayList();
////            for (UserPhoneContacts userPhoneContacts : contactsList11) {
////                if (userPhoneContacts.getLastCall() != null) {
////                    logger.info("通讯录最后通话时间：" + userPhoneContacts.getLastCall());
////                    String phoneStr = null;
////                    try {
////                        phoneStr = sdf2.format(userPhoneContacts.getLastCall());
////                    } catch (Exception e) {
////                        e.printStackTrace();
////                        phoneStr = sdf3.format(userPhoneContacts.getLastCall());
////                    }
////                    if (phoneStr.equals("2017年04") || phoneStr.equals("2017-04")) {
////                        userPhoneContactsList.add(userPhoneContacts);
////                    }
////                }
////            }
////            logger.info("最近一个月通讯录个数"+userPhoneContactsList.size());
////
////            long endTime3 = System.currentTimeMillis();
////            float excTime3 = (float) (endTime3 - startTime3) / 1000;
////            logger.info("【HBase】执行查询（用户通讯录）成功，sql:" + sql2 + "，耗时：" + excTime3 + "查询到用户通讯录数据" + contactsList3.size());
////            phoneContactCount = contactsList3.size();
//        sb0 = sb0.delete(0, sb0.length());
//        sb0.append("" + userInfo.getUserId() + ",");
//         sb0.append("" + userInfo.getLoanId() + ",");//姓名
//         sb0.append("" + userInfo.getLoanType() + ",");//姓名
//         sb0.append("" + userInfo.getIsOverdue() + ",");//姓名
//         sb0.append("" + userInfo.getIsRepay() + ",");//姓名
//         sb0.append("" + allCount + ",");//姓名
//
//            sb0.append("" + userInfoInfo.getIsOverdue() + ",");//是否逾期
//            sb0.append("" + userInfoInfo.getOverdue() + ",");//逾期天数
//            sb0.append("" + userInfoInfo.getRegistTime() + ",");//注册时间
//            sb0.append("" + userInfoInfo.getFirstAppTime() + ",");//注册时间
//            sb0.append("" + userInfoInfo.getSecondAppTime() + ",");//借款金额
//            sb0.append("" + userInfoInfo.getSecondSucLoanTime() + ",");//借款金额
//            sb0.append("" + userInfo.getSecondAmount() + ",");//借款金额
//        sb0.append("" + userInfo.getThirdSucAmount() + ",");//借款金额
//            sb0.append("" + userInfo.getOneApplyTime() + ",");//借款金额
//            sb0.append("" + userInfo.getThreeApplyTime() + ",");//借款金额
//            sb0.append("" + userInfo.getOneRejectDrools() + ",");//借款金额
//            sb0.append("" + userInfo.getOneRejectManager() + ",");//借款金额
//            sb0.append("" + userInfo.getThreeRejectDrools() + ",");//借款金额
//            sb0.append("" + userInfo.getThreeRejectUser() + ",");//借款金额
//            sb0.append("" + userInfo.getFirstPlayDate() + ",");//借款金额
//            sb0.append("" + userInfo.getSecondPlayDate() + ",");//借款金额
//            sb0.append("" + userInfo.getThirdPlayDate() + ",");//借款金额
//            sb0.append("" + userInfo.getFirstRepayDate() + ",");//借款金额
//            sb0.append("" + userInfo.getSecondRepayDate() + ",");//借款金额
//            sb0.append("" + userInfo.getThirdRepayDate() + ",");//借款金额
//            sb0.append("" + (list.size() < 1 ? 0 : (list.get(0) == null ? 0 : (list.get(0).getValue() == null ? 0 : (list.get(0).getValue().getOtherPhone())))) + ",");//借款金额
//            sb0.append("" + (list.size() < 1 ? 0 : (list.get(0) == null ? 0 : (list.get(0).getValue() == null ? 0 : (list.get(0).getValue().getAllTimes() == null ? 0 : list.get(0).getValue().getAllTimes())))) + ",");//借款金额
//            sb0.append("" + (list.size() < 1 ? 0 : (list.get(0) == null ? 0 : (list.get(0).getValue() == null ? 0 : (list.get(0).getValue().getOutTimes() == null ? 0 : list.get(0).getValue().getOutTimes())))) + ",");//借款金额
//            sb0.append("" + (list.size() < 1 ? 0 : (list.get(0) == null ? 0 : (list.get(0).getValue() == null ? 0 : (list.get(0).getValue().getInTimes() == null ? 0 : list.get(0).getValue().getInTimes())))) + ",");//借款金额
//            sb0.append("" + (firstCallMap.size() < 1 ? 0 : (firstCallMap.get(0) == null ? 0 : firstCallMap.get(0))) + ",");//借款金额
//            sb0.append("" + (lastCallMap.size() < 1 ? 0 : (lastCallMap.get(0) == null ? 0 : lastCallMap.get(0))) + ",");//借款金额
//            sb0.append("" + (list.size() < 2 ? 0 : (list.get(1) == null ? 0 : (list.get(1).getValue() == null ? 0 : (list.get(1).getValue().getOtherPhone())))) + ",");//借款金额
//            sb0.append("" + (list.size() < 2 ? 0 : (list.get(1) == null ? 0 : (list.get(1).getValue() == null ? 0 : (list.get(1).getValue().getAllTimes() == null ? 0 : list.get(1).getValue().getAllTimes())))) + ",");//借款金额
//            sb0.append("" + (list.size() < 2 ? 0 : (list.get(1) == null ? 0 : (list.get(1).getValue() == null ? 0 : (list.get(1).getValue().getOutTimes() == null ? 0 : list.get(1).getValue().getOutTimes())))) + ",");//借款金额
//            sb0.append("" + (list.size() < 2 ? 0 : (list.get(1) == null ? 0 : (list.get(1).getValue() == null ? 0 : (list.get(1).getValue().getInTimes() == null ? 0 : list.get(1).getValue().getInTimes())))) + ",");//借款金额
//            sb0.append("" + (firstCallMap.size() < 2 ? 0 : (firstCallMap.get(1) == null ? 0 : firstCallMap.get(1))) + ",");//借款金额
//            sb0.append("" + (lastCallMap.size() < 2 ? 0 : (lastCallMap.get(1) == null ? 0 : lastCallMap.get(1))) + ",");//借款金额
//            sb0.append("" + (list.size() < 3 ? 0 : (list.get(2) == null ? 0 : (list.get(2).getValue() == null ? 0 : (list.get(2).getValue().getOtherPhone())))) + ",");
//            sb0.append("" + (list.size() < 3 ? 0 : (list.get(2) == null ? 0 : (list.get(2).getValue() == null ? 0 : (list.get(2).getValue().getAllTimes() == null ? 0 : list.get(2).getValue().getAllTimes())))) + ",");//借款金额
//            sb0.append("" + (list.size() < 3 ? 0 : (list.get(2) == null ? 0 : (list.get(2).getValue() == null ? 0 : (list.get(2).getValue().getOutTimes() == null ? 0 : list.get(2).getValue().getOutTimes())))) + ",");//借款金额
//            sb0.append("" + (list.size() < 3 ? 0 : (list.get(2) == null ? 0 : (list.get(2).getValue() == null ? 0 : (list.get(2).getValue().getInTimes() == null ? 0 : list.get(2).getValue().getInTimes())))) + ",");//借款金额
//            sb0.append("" + (firstCallMap.size() < 3 ? 0 : (firstCallMap.get(2) == null ? 0 : firstCallMap.get(2))) + ",");//借款金额
//            sb0.append("" + (lastCallMap.size() < 3 ? 0 : (lastCallMap.get(2) == null ? 0 : lastCallMap.get(2))) + ",");//借款金额
//            sb0.append("" + (list.size() < 4 ? 0 : (list.get(3) == null ? 0 : (list.get(3).getValue() == null ? 0 : (list.get(3).getValue().getOtherPhone())))) + ",");//借款金额
//            sb0.append("" + (list.size() < 4 ? 0 : (list.get(3) == null ? 0 : (list.get(3).getValue() == null ? 0 : (list.get(3).getValue().getAllTimes() == null ? 0 : list.get(3).getValue().getAllTimes())))) + ",");//借款金额
//            sb0.append("" + (list.size() < 4 ? 0 : (list.get(3) == null ? 0 : (list.get(3).getValue() == null ? 0 : (list.get(3).getValue().getOutTimes() == null ? 0 : list.get(3).getValue().getOutTimes())))) + ",");//借款金额
//            sb0.append("" + (list.size() < 4 ? 0 : (list.get(3) == null ? 0 : (list.get(3).getValue() == null ? 0 : (list.get(3).getValue().getInTimes() == null ? 0 : list.get(3).getValue().getInTimes())))) + ",");//借款金额
//            sb0.append("" + (firstCallMap.size() < 4 ? 0 : (firstCallMap.get(3) == null ? 0 : firstCallMap.get(3))) + ",");//借款金额
//            sb0.append("" + (lastCallMap.size() < 4 ? 0 : (lastCallMap.get(3) == null ? 0 : lastCallMap.get(3))) + ",");//借款金额
//            sb0.append("" + (list.size() < 5 ? 0 : (list.get(4) == null ? 0 : (list.get(4).getValue() == null ? 0 : (list.get(4).getValue().getOtherPhone())))) + ",");//借款金额
//            sb0.append("" + (list.size() < 5 ? 0 : (list.get(4) == null ? 0 : (list.get(4).getValue() == null ? 0 : (list.get(4).getValue().getAllTimes() == null ? 0 : list.get(4).getValue().getAllTimes())))) + ",");//借款金额
//            sb0.append("" + (list.size() < 5 ? 0 : (list.get(4) == null ? 0 : (list.get(4).getValue() == null ? 0 : (list.get(4).getValue().getOutTimes() == null ? 0 : list.get(4).getValue().getOutTimes())))) + ",");//借款金额
//            sb0.append("" + (list.size() < 5 ? 0 : (list.get(4) == null ? 0 : (list.get(4).getValue() == null ? 0 : (list.get(4).getValue().getInTimes() == null ? 0 : list.get(4).getValue().getInTimes())))) + ",");//借款金额
//            sb0.append("" + (firstCallMap.size() < 5 ? 0 : (firstCallMap.get(4) == null ? 0 : firstCallMap.get(4))) + ",");//借款金额
//            sb0.append("" + (lastCallMap.size() < 5 ? 0 : (lastCallMap.get(4) == null ? 0 : lastCallMap.get(4))) + ",");//借款金额
//
//
//            sb0.append("" + (list1.size() < 1 ? 0 : (list1.get(0) == null ? 0 : (list1.get(0).getValue() == null ? 0 : (list1.get(0).getValue().getOtherPhone())))) + ",");//借款金额
//            sb0.append("" + (list1.size() < 1 ? 0 : (list1.get(0) == null ? 0 : (list1.get(0).getValue() == null ? 0 : (list1.get(0).getValue().getAllTimes() == null ? 0 : list1.get(0).getValue().getAllTimes())))) + ",");//借款金额
//            sb0.append("" + (list1.size() < 1 ? 0 : (list1.get(0) == null ? 0 : (list1.get(0).getValue() == null ? 0 : (list1.get(0).getValue().getOutTimes() == null ? 0 : list1.get(0).getValue().getOutTimes())))) + ",");//借款金额
//            sb0.append("" + (list1.size() < 1 ? 0 : (list1.get(0) == null ? 0 : (list1.get(0).getValue() == null ? 0 : (list1.get(0).getValue().getInTimes() == null ? 0 : list1.get(0).getValue().getInTimes())))) + ",");//借款金额
//            sb0.append("" + (firstCallMap1.size() < 1 ? 0 : (firstCallMap1.get(0) == null ? 0 : firstCallMap1.get(0))) + ",");//借款金额
//            sb0.append("" + (lastCallMap1.size() < 1 ? 0 : (lastCallMap1.get(0) == null ? 0 : lastCallMap1.get(0))) + ",");//借款金额
//            sb0.append("" + (list1.size() < 2 ? 0 : (list1.get(1) == null ? 0 : (list1.get(1).getValue() == null ? 0 : (list1.get(1).getValue().getOtherPhone())))) + ",");//借款金额
//            sb0.append("" + (list1.size() < 2 ? 0 : (list1.get(1) == null ? 0 : (list1.get(1).getValue() == null ? 0 : (list1.get(1).getValue().getAllTimes() == null ? 0 : list1.get(1).getValue().getAllTimes())))) + ",");//借款金额
//            sb0.append("" + (list1.size() < 2 ? 0 : (list1.get(1) == null ? 0 : (list1.get(1).getValue() == null ? 0 : (list1.get(1).getValue().getOutTimes() == null ? 0 : list1.get(1).getValue().getOutTimes())))) + ",");//借款金额
//            sb0.append("" + (list1.size() < 2 ? 0 : (list1.get(1) == null ? 0 : (list1.get(1).getValue() == null ? 0 : (list1.get(1).getValue().getInTimes() == null ? 0 : list1.get(1).getValue().getInTimes())))) + ",");//借款金额
//            sb0.append("" + (firstCallMap1.size() < 2 ? 0 : (firstCallMap1.get(1) == null ? 0 : firstCallMap1.get(1))) + ",");//借款金额
//            sb0.append("" + (lastCallMap1.size() < 2 ? 0 : (lastCallMap1.get(1) == null ? 0 : lastCallMap1.get(1))) + ",");//借款金额
//            sb0.append("" + (list1.size() < 3 ? 0 : (list1.get(2) == null ? 0 : (list1.get(2).getValue() == null ? 0 : (list1.get(2).getValue().getOtherPhone())))) + ",");//借款金额
//            sb0.append("" + (list1.size() < 3 ? 0 : (list1.get(2) == null ? 0 : (list1.get(2).getValue() == null ? 0 : (list1.get(2).getValue().getAllTimes() == null ? 0 : list1.get(2).getValue().getAllTimes())))) + ",");//借款金额
//            sb0.append("" + (list1.size() < 3 ? 0 : (list1.get(2) == null ? 0 : (list1.get(2).getValue() == null ? 0 : (list1.get(2).getValue().getOutTimes() == null ? 0 : list1.get(2).getValue().getOutTimes())))) + ",");//借款金额
//            sb0.append("" + (list1.size() < 3 ? 0 : (list1.get(2) == null ? 0 : (list1.get(2).getValue() == null ? 0 : (list1.get(2).getValue().getInTimes() == null ? 0 : list1.get(2).getValue().getInTimes())))) + ",");//借款金额
//            sb0.append("" + (firstCallMap1.size() < 3 ? 0 : (firstCallMap1.get(2) == null ? 0 : firstCallMap1.get(2))) + ",");//借款金额)
//            sb0.append("" + (lastCallMap1.size() < 3 ? 0 : (lastCallMap1.get(2) == null ? 0 : lastCallMap1.get(2))) + ",");//借款金额
//            sb0.append("" + (list1.size() < 4 ? 0 : (list1.get(3) == null ? 0 : (list1.get(3).getValue() == null ? 0 : (list1.get(3).getValue().getOtherPhone())))) + ",");//借款金额
//            sb0.append("" + (list1.size() < 4 ? 0 : (list1.get(3) == null ? 0 : (list1.get(3).getValue() == null ? 0 : (list1.get(3).getValue().getAllTimes() == null ? 0 : list1.get(3).getValue().getAllTimes())))) + ",");
//            sb0.append("" + (list1.size() < 4 ? 0 : (list1.get(3) == null ? 0 : (list1.get(3).getValue() == null ? 0 : (list1.get(3).getValue().getOutTimes() == null ? 0 : list1.get(3).getValue().getOutTimes())))) + ",");//借款金额
//            sb0.append("" + (list1.size() < 4 ? 0 : (list1.get(3) == null ? 0 : (list1.get(3).getValue() == null ? 0 : (list1.get(3).getValue().getInTimes() == null ? 0 : list1.get(3).getValue().getInTimes())))) + ",");//借款金额
//            sb0.append("" + (firstCallMap1.size() < 4 ? 0 : (firstCallMap1.get(3) == null ? 0 : firstCallMap1.get(3))) + ",");//借款金额
//            sb0.append("" + (lastCallMap1.size() < 4 ? 0 : (lastCallMap1.get(3) == null ? 0 : lastCallMap1.get(3))) + ",");//借款金额
//            sb0.append("" + (list1.size() < 5 ? 0 : (list1.get(4) == null ? 0 : (list1.get(4).getValue() == null ? 0 : (list1.get(4).getValue().getOtherPhone())))) + ",");//借款金额
//            sb0.append("" + (list1.size() < 5 ? 0 : (list1.get(4) == null ? 0 : (list1.get(4).getValue() == null ? 0 : (list1.get(4).getValue().getAllTimes() == null ? 0 : list1.get(4).getValue().getAllTimes())))) + ",");
//            sb0.append("" + (list1.size() < 5 ? 0 : (list1.get(4) == null ? 0 : (list1.get(4).getValue() == null ? 0 : (list1.get(4).getValue().getOutTimes() == null ? 0 : list1.get(4).getValue().getOutTimes())))) + ",");//借款金额
//            sb0.append("" + (list1.size() < 5 ? 0 : (list1.get(4) == null ? 0 : (list1.get(4).getValue() == null ? 0 : (list1.get(4).getValue().getInTimes() == null ? 0 : list1.get(4).getValue().getInTimes())))) + ",");//借款金额
//            sb0.append("" + (firstCallMap1.size() < 5 ? 0 : (firstCallMap1.get(4) == null ? 0 : firstCallMap1.get(4))) + ",");//借款金额
//            sb0.append("" + (lastCallMap1.size() < 5 ? 0 : (lastCallMap1.get(4) == null ? 0 : lastCallMap1.get(4))) + ",");//借款金额
//
//
//            sb0.append("" + (list2.size() < 1 ? 0 : (list2.get(0) == null ? 0 : (list2.get(0).getValue() == null ? 0 : list2.get(0).getValue().getOtherPhone()))) + ",");//借款金额
//            sb0.append("" + (list2.size() < 1 ? 0 : (list2.get(0) == null ? 0 : (list2.get(0).getValue() == null ? 0 : list2.get(0).getValue().getAllTimes()))) + ",");//借款金额
//            sb0.append("" + (list2.size() < 1 ? 0 : (list2.get(0) == null ? 0 : (list2.get(0).getValue() == null ? 0 : (list2.get(0).getValue().getOutTimes() == null ? 0 : list2.get(0).getValue().getOutTimes())))) + ",");//借款金额
//            sb0.append("" + (list2.size() < 1 ? 0 : (list2.get(0) == null ? 0 : (list2.get(0).getValue() == null ? 0 : (list2.get(0).getValue().getInTimes() == null ? 0 : list2.get(0).getValue().getInTimes())))) + ",");//借款金额
//            sb0.append("" + (firstCallMap2.size() < 1 ? 0 : (firstCallMap2.get(0) == null ? 0 : firstCallMap2.get(0))) + ",");//借款金额
//            sb0.append("" + (lastCallMap2.size() < 1 ? 0 : (lastCallMap2.get(0) == null ? 0 : lastCallMap2.get(0))) + ",");//借款金额
//            sb0.append("" + (list2.size() < 2 ? 0 : (list2.get(1) == null ? 0 : (list2.get(1).getValue() == null ? 0 : (list2.get(1).getValue().getOtherPhone())))) + ",");//借款金额
//            sb0.append("" + (list2.size() < 2 ? 0 : (list2.get(1) == null ? 0 : (list2.get(1).getValue() == null ? 0 : (list2.get(1).getValue().getAllTimes() == null ? 0 : list2.get(1).getValue().getAllTimes())))) + ",");//借款金额
//            sb0.append("" + (list2.size() < 2 ? 0 : (list2.get(1) == null ? 0 : (list2.get(1).getValue() == null ? 0 : (list2.get(1).getValue().getOutTimes() == null ? 0 : list2.get(1).getValue().getOutTimes())))) + ",");//借款金额
//            sb0.append("" + (list2.size() < 2 ? 0 : (list2.get(1) == null ? 0 : (list2.get(1).getValue() == null ? 0 : (list2.get(1).getValue().getInTimes() == null ? 0 : list2.get(1).getValue().getInTimes())))) + ",");//借款金额
//            sb0.append("" + (firstCallMap2.size() < 2 ? 0 : (firstCallMap2.get(1) == null ? 0 : firstCallMap2.get(1))) + ",");//借款金额
//            sb0.append("" + (lastCallMap2.size() < 2 ? 0 : (lastCallMap2.get(1) == null ? 0 : lastCallMap2.get(1))) + ",");//借款金额
//            sb0.append("" + (list2.size() < 3 ? 0 : (list2.get(2) == null ? 0 : (list2.get(2).getValue() == null ? 0 : (list2.get(2).getValue().getOtherPhone())))) + ",");//借款金额
//            sb0.append("" + (list2.size() < 3 ? 0 : (list2.get(2) == null ? 0 : (list2.get(2).getValue() == null ? 0 : (list2.get(2).getValue().getAllTimes() == null ? 0 : list2.get(2).getValue().getAllTimes())))) + ",");//借款金额
//            sb0.append("" + (list2.size() < 3 ? 0 : (list2.get(2) == null ? 0 : (list2.get(2).getValue() == null ? 0 : (list2.get(2).getValue().getOutTimes() == null ? 0 : list2.get(2).getValue().getOutTimes())))) + ",");//借款金额
//            sb0.append("" + (list2.size() < 3 ? 0 : (list2.get(2) == null ? 0 : (list2.get(2).getValue() == null ? 0 : (list2.get(2).getValue().getInTimes() == null ? 0 : list2.get(2).getValue().getInTimes())))) + ",");//借款金额
//            sb0.append("" + (firstCallMap2.size() < 3 ? 0 : (firstCallMap2.get(2) == null ? 0 : firstCallMap2.get(2))) + ",");//借款金额
//            sb0.append("" + (lastCallMap2.size() < 3 ? 0 : (lastCallMap2.get(2) == null ? 0 : lastCallMap2.get(2))) + ",");//借款金额
//            sb0.append("" + (list2.size() < 4 ? 0 : (list2.get(3) == null ? 0 : (list2.get(3).getValue() == null ? 0 : (list2.get(3).getValue().getOtherPhone())))) + ",");//借款金额
//            sb0.append("" + (list2.size() < 4 ? 0 : (list2.get(3) == null ? 0 : (list2.get(3).getValue() == null ? 0 : (list2.get(3).getValue().getAllTimes() == null ? 0 : list2.get(3).getValue().getAllTimes())))) + ",");//借款金额
//            sb0.append("" + (list2.size() < 4 ? 0 : (list2.get(3) == null ? 0 : (list2.get(3).getValue() == null ? 0 : (list2.get(3).getValue().getOutTimes() == null ? 0 : list2.get(3).getValue().getOutTimes())))) + ",");//借款金额
//            sb0.append("" + (list2.size() < 4 ? 0 : (list2.get(3) == null ? 0 : (list2.get(3).getValue() == null ? 0 : (list2.get(3).getValue().getInTimes() == null ? 0 : list2.get(3).getValue().getInTimes())))) + ",");//借款金额
//            sb0.append("" + (firstCallMap2.size() < 4 ? 0 : (firstCallMap2.get(3) == null ? 0 : firstCallMap2.get(3))) + ",");//借款金额
//            sb0.append("" + (lastCallMap2.size() < 4 ? 0 : (lastCallMap2.get(3) == null ? 0 : lastCallMap2.get(3))) + ",");//借款金额
//            sb0.append("" + (list2.size() < 5 ? 0 : (list2.get(4) == null ? 0 : (list2.get(4).getValue() == null ? 0 : (list2.get(4).getValue().getOtherPhone())))) + ",");//借款金额
//            sb0.append("" + (list2.size() < 5 ? 0 : (list2.get(4) == null ? 0 : (list2.get(4).getValue() == null ? 0 : (list2.get(4).getValue().getAllTimes() == null ? 0 : list2.get(4).getValue().getAllTimes())))) + ",");//借款金额
//            sb0.append("" + (list2.size() < 5 ? 0 : (list2.get(4) == null ? 0 : (list2.get(4).getValue() == null ? 0 : (list2.get(4).getValue().getOutTimes() == null ? 0 : list2.get(4).getValue().getOutTimes())))) + ",");//借款金额
//            sb0.append("" + (list2.size() < 5 ? 0 : (list2.get(4) == null ? 0 : (list2.get(4).getValue() == null ? 0 : (list2.get(4).getValue().getInTimes() == null ? 0 : list2.get(4).getValue().getInTimes())))) + ",");//借款金额
//            sb0.append("" + (firstCallMap2.size() < 5 ? 0 : (firstCallMap2.get(4) == null ? 0 : firstCallMap2.get(4))) + ",");//借款金额
//            sb0.append("" + (lastCallMap2.size() < 5 ? 0 : (lastCallMap2.get(4) == null ? 0 : lastCallMap2.get(4))) + ",");//借款金额
//
//
//            sb0.append("" + (list3.size() < 1 ? 0 : (list3.get(0) == null ? 0 : (list3.get(0).getValue() == null ? 0 : (list3.get(0).getValue().getOtherPhone())))) + ",");//借款金额
//            sb0.append("" + (list3.size() < 1 ? 0 : (list3.get(0) == null ? 0 : (list3.get(0).getValue() == null ? 0 : (list3.get(0).getValue().getAllTimes() == null ? 0 : list3.get(0).getValue().getAllTimes())))) + ",");//借款金额
//            sb0.append("" + (list3.size() < 1 ? 0 : (list3.get(0) == null ? 0 : (list3.get(0).getValue() == null ? 0 : (list3.get(0).getValue().getOutTimes() == null ? 0 : list3.get(0).getValue().getOutTimes())))) + ",");//借款金额
//            sb0.append("" + (list3.size() < 1 ? 0 : (list3.get(0) == null ? 0 : (list3.get(0).getValue() == null ? 0 : (list3.get(0).getValue().getInTimes() == null ? 0 : list3.get(0).getValue().getInTimes())))) + ",");//借款金额
//            sb0.append("" + (firstCallMap3.size() < 1 ? 0 : (firstCallMap3.get(0) == null ? 0 : firstCallMap3.get(0))) + ",");//借款金额
//            sb0.append("" + (lastCallMap3.size() < 1 ? 0 : (lastCallMap3.get(0) == null ? 0 : lastCallMap3.get(0))) + ",");//借款金额
//            sb0.append("" + (list3.size() < 2 ? 0 : (list3.get(1) == null ? 0 : (list3.get(1).getValue() == null ? 0 : (list3.get(1).getValue().getOtherPhone())))) + ",");//借款金额
//            sb0.append("" + (list3.size() < 2 ? 0 : (list3.get(1) == null ? 0 : (list3.get(1).getValue() == null ? 0 : (list3.get(1).getValue().getAllTimes() == null ? 0 : list3.get(1).getValue().getAllTimes())))) + ",");//借款金额
//            sb0.append("" + (list3.size() < 2 ? 0 : (list3.get(1) == null ? 0 : (list3.get(1).getValue() == null ? 0 : (list3.get(1).getValue().getOutTimes() == null ? 0 : list3.get(1).getValue().getOutTimes())))) + ",");//借款金额
//            sb0.append("" + (list3.size() < 2 ? 0 : (list3.get(1) == null ? 0 : (list3.get(1).getValue() == null ? 0 : (list3.get(1).getValue().getInTimes() == null ? 0 : list3.get(1).getValue().getInTimes())))) + ",");//借款金额
//            sb0.append("" + (firstCallMap3.size() < 2 ? 0 : (firstCallMap3.get(1) == null ? 0 : firstCallMap3.get(1))) + ",");//借款金额
//            sb0.append("" + (lastCallMap3.size() < 2 ? 0 : (lastCallMap3.get(1) == null ? 0 : lastCallMap3.get(1))) + ",");//借款金额
//            sb0.append("" + (list3.size() < 3 ? 0 : (list3.get(2) == null ? 0 : (list3.get(2).getValue() == null ? 0 : (list3.get(2).getValue().getOtherPhone())))) + ",");//借款金额
//            sb0.append("" + (list3.size() < 3 ? 0 : (list3.get(2) == null ? 0 : (list3.get(2).getValue() == null ? 0 : (list3.get(2).getValue().getAllTimes() == null ? 0 : list3.get(2).getValue().getAllTimes())))) + ",");//借款金额
//            sb0.append("" + (list3.size() < 3 ? 0 : (list3.get(2) == null ? 0 : (list3.get(2).getValue() == null ? 0 : (list3.get(2).getValue().getOutTimes() == null ? 0 : list3.get(2).getValue().getOutTimes())))) + ",");//借款金额
//            sb0.append("" + (list3.size() < 3 ? 0 : (list3.get(2) == null ? 0 : (list3.get(2).getValue() == null ? 0 : (list3.get(2).getValue().getInTimes() == null ? 0 : list3.get(2).getValue().getInTimes())))) + ",");//借款金额
//            sb0.append("" + (firstCallMap3.size() < 3 ? 0 : (firstCallMap3.get(2) == null ? 0 : firstCallMap3.get(2))) + ",");//借款金额
//            sb0.append("" + (lastCallMap3.size() < 3 ? 0 : (lastCallMap3.get(2) == null ? 0 : lastCallMap3.get(2))) + ",");//借款金额
//            sb0.append("" + (list3.size() < 4 ? 0 : (list3.get(3) == null ? 0 : (list3.get(3).getValue() == null ? 0 : (list3.get(3).getValue().getOtherPhone())))) + ",");//借款金额
//            sb0.append("" + (list3.size() < 4 ? 0 : (list3.get(3) == null ? 0 : (list3.get(3).getValue() == null ? 0 : (list3.get(3).getValue().getAllTimes() == null ? 0 : list3.get(3).getValue().getAllTimes())))) + ",");//借款金额
//            sb0.append("" + (list3.size() < 4 ? 0 : (list3.get(3) == null ? 0 : (list3.get(3).getValue() == null ? 0 : (list3.get(3).getValue().getOutTimes() == null ? 0 : list3.get(3).getValue().getOutTimes())))) + ",");//借款金额
//            sb0.append("" + (list3.size() < 4 ? 0 : (list3.get(3) == null ? 0 : (list3.get(3).getValue() == null ? 0 : (list3.get(3).getValue().getInTimes() == null ? 0 : list3.get(3).getValue().getInTimes())))) + ",");//借款金额
//            sb0.append("" + (firstCallMap3.size() < 4 ? 0 : (firstCallMap3.get(3) == null ? 0 : firstCallMap3.get(3))) + ",");//借款金额
//            sb0.append("" + (lastCallMap3.size() < 4 ? 0 : (lastCallMap3.get(3) == null ? 0 : lastCallMap3.get(3))) + ",");//借款金额
//            sb0.append("" + (list3.size() < 5 ? 0 : (list3.get(4) == null ? 0 : (list3.get(4).getValue() == null ? 0 : (list3.get(4).getValue().getOtherPhone())))) + ",");//借款金额
//            sb0.append("" + (list3.size() < 5 ? 0 : (list3.get(4) == null ? 0 : (list3.get(4).getValue() == null ? 0 : (list3.get(4).getValue().getAllTimes() == null ? 0 : list3.get(4).getValue().getAllTimes())))) + ",");//借款金额
//            sb0.append("" + (list3.size() < 5 ? 0 : (list3.get(4) == null ? 0 : (list3.get(4).getValue() == null ? 0 : (list3.get(4).getValue().getOutTimes() == null ? 0 : list3.get(4).getValue().getOutTimes())))) + ",");//借款金额
//            sb0.append("" + (list3.size() < 5 ? 0 : (list3.get(4) == null ? 0 : (list3.get(4).getValue() == null ? 0 : (list3.get(4).getValue().getInTimes() == null ? 0 : list3.get(4).getValue().getInTimes())))) + ",");//借款金额
//            sb0.append("" + (firstCallMap3.size() < 5 ? 0 : (firstCallMap3.get(4) == null ? 0 : firstCallMap3.get(4))) + ",");//借款金额
//            sb0.append("" + (lastCallMap3.size() < 5 ? 0 : (lastCallMap3.get(4) == null ? 0 : lastCallMap3.get(4))) + ",");//借款金额
//
//
//            sb0.append("" + (list4.size() < 1 ? 0 : (list4.get(0) == null ? 0 : (list4.get(0).getValue() == null ? 0 : (list4.get(0).getValue().getOtherPhone())))) + ",");//借款金额
//            sb0.append("" + (list4.size() < 1 ? 0 : (list4.get(0) == null ? 0 : (list4.get(0).getValue() == null ? 0 : (list4.get(0).getValue().getAllTimes() == null ? 0 : list4.get(0).getValue().getAllTimes())))) + ",");//借款金额
//            sb0.append("" + (list4.size() < 1 ? 0 : (list4.get(0) == null ? 0 : (list4.get(0).getValue() == null ? 0 : (list4.get(0).getValue().getOutTimes() == null ? 0 : list4.get(0).getValue().getOutTimes())))) + ",");//借款金额
//            sb0.append("" + (list4.size() < 1 ? 0 : (list4.get(0) == null ? 0 : (list4.get(0).getValue() == null ? 0 : (list4.get(0).getValue().getInTimes() == null ? 0 : list4.get(0).getValue().getInTimes())))) + ",");//借款金额
//            sb0.append("" + (firstCallMap4.size() < 1 ? 0 : (firstCallMap4.get(0) == null ? 0 : firstCallMap4.get(0))) + ",");//借款金额
//            sb0.append("" + (lastCallMap4.size() < 1 ? 0 : (lastCallMap4.get(0) == null ? 0 : lastCallMap4.get(0))) + ",");//借款金额
//            sb0.append("" + (list4.size() < 2 ? 0 : (list4.get(1) == null ? 0 : (list4.get(1).getValue() == null ? 0 : (list4.get(1).getValue().getOtherPhone())))) + ",");//借款金额
//            sb0.append("" + (list4.size() < 2 ? 0 : (list4.get(1) == null ? 0 : (list4.get(1).getValue() == null ? 0 : (list4.get(1).getValue().getAllTimes() == null ? 0 : list4.get(1).getValue().getAllTimes())))) + ",");//借款金额
//            sb0.append("" + (list4.size() < 2 ? 0 : (list4.get(1) == null ? 0 : (list4.get(1).getValue() == null ? 0 : (list4.get(1).getValue().getOutTimes() == null ? 0 : list4.get(1).getValue().getOutTimes())))) + ",");//借款金额
//            sb0.append("" + (list4.size() < 2 ? 0 : (list4.get(1) == null ? 0 : (list4.get(1).getValue() == null ? 0 : (list4.get(1).getValue().getInTimes() == null ? 0 : list4.get(1).getValue().getInTimes())))) + ",");//借款金额
//            sb0.append("" + (firstCallMap4.size() < 2 ? 0 : (firstCallMap4.get(1) == null ? 0 : firstCallMap4.get(1))) + ",");//借款金额
//            sb0.append("" + (lastCallMap4.size() < 2 ? 0 : (lastCallMap4.get(1) == null ? 0 : lastCallMap4.get(1))) + ",");//借款金额
//            sb0.append("" + (list4.size() < 3 ? 0 : (list4.get(2) == null ? 0 : (list4.get(2).getValue() == null ? 0 : (list4.get(2).getValue().getOtherPhone())))) + ",");//借款金额
//            sb0.append("" + (list4.size() < 3 ? 0 : (list4.get(2) == null ? 0 : (list4.get(2).getValue() == null ? 0 : (list4.get(2).getValue().getAllTimes() == null ? 0 : list4.get(2).getValue().getAllTimes())))) + ",");//借款金额
//            sb0.append("" + (list4.size() < 3 ? 0 : (list4.get(2) == null ? 0 : (list4.get(2).getValue() == null ? 0 : (list4.get(2).getValue().getOutTimes() == null ? 0 : list4.get(2).getValue().getOutTimes())))) + ",");//借款金额
//            sb0.append("" + (list4.size() < 3 ? 0 : (list4.get(2) == null ? 0 : (list4.get(2).getValue() == null ? 0 : (list4.get(2).getValue().getInTimes() == null ? 0 : list4.get(2).getValue().getInTimes())))) + ",");//借款金额
//            sb0.append("" + (firstCallMap4.size() < 3 ? 0 : (firstCallMap4.get(2) == null ? 0 : firstCallMap4.get(2))) + ",");//借款金额
//            sb0.append("" + (lastCallMap4.size() < 3 ? 0 : (lastCallMap4.get(2) == null ? 0 : lastCallMap4.get(2))) + ",");//借款金额
//            sb0.append("" + (list4.size() < 4 ? 0 : (list4.get(3) == null ? 0 : (list4.get(3).getValue() == null ? 0 : (list4.get(3).getValue().getOtherPhone())))) + ",");//借款金额
//            sb0.append("" + (list4.size() < 4 ? 0 : (list4.get(3) == null ? 0 : (list4.get(3).getValue() == null ? 0 : (list4.get(3).getValue().getAllTimes() == null ? 0 : list4.get(3).getValue().getAllTimes())))) + ",");//借款金额
//            sb0.append("" + (list4.size() < 4 ? 0 : (list4.get(3) == null ? 0 : (list4.get(3).getValue() == null ? 0 : (list4.get(3).getValue().getOutTimes() == null ? 0 : list4.get(3).getValue().getOutTimes())))) + ",");//借款金额
//            sb0.append("" + (list4.size() < 4 ? 0 : (list4.get(3) == null ? 0 : (list4.get(3).getValue() == null ? 0 : (list4.get(3).getValue().getInTimes() == null ? 0 : list4.get(3).getValue().getInTimes())))) + ",");//借款金额
//            sb0.append("" + (firstCallMap4.size() < 4 ? 0 : (firstCallMap4.get(3) == null ? 0 : firstCallMap4.get(3))) + ",");//借款金额
//            sb0.append("" + (lastCallMap4.size() < 4 ? 0 : (lastCallMap4.get(3) == null ? 0 : lastCallMap4.get(3))) + ",");//借款金额
//            sb0.append("" + (list4.size() < 5 ? 0 : (list4.get(4) == null ? 0 : (list4.get(4).getValue() == null ? 0 : (list4.get(4).getValue().getOtherPhone())))) + ",");//借款金额
//            sb0.append("" + (list4.size() < 5 ? 0 : (list4.get(4) == null ? 0 : (list4.get(4).getValue() == null ? 0 : (list4.get(4).getValue().getAllTimes() == null ? 0 : list4.get(4).getValue().getAllTimes())))) + ",");//借款金额
//            sb0.append("" + (list4.size() < 5 ? 0 : (list4.get(4) == null ? 0 : (list4.get(4).getValue() == null ? 0 : (list4.get(4).getValue().getOutTimes() == null ? 0 : list4.get(4).getValue().getOutTimes())))) + ",");//借款金额
//            sb0.append("" + (list4.size() < 5 ? 0 : (list4.get(4) == null ? 0 : (list4.get(4).getValue() == null ? 0 : (list4.get(4).getValue().getInTimes() == null ? 0 : list4.get(4).getValue().getInTimes())))) + ",");//借款金额
//            sb0.append("" + (firstCallMap4.size() < 5 ? 0 : (firstCallMap4.get(4) == null ? 0 : firstCallMap4.get(4))) + ",");//借款金额
//            sb0.append("" + (lastCallMap4.size() < 5 ? 0 : (lastCallMap4.get(4) == null ? 0 : lastCallMap4.get(4))) + ",");//借款金额
//
//
//            sb0.append("" + (list5.size() < 1 ? 0 : (list5.get(0) == null ? 0 : (list5.get(0).getValue() == null ? 0 : (list5.get(0).getValue().getOtherPhone())))) + ",");//借款金额
//            sb0.append("" + (list5.size() < 1 ? 0 : (list5.get(0) == null ? 0 : (list5.get(0).getValue() == null ? 0 : (list5.get(0).getValue().getAllTimes() == null ? 0 : list5.get(0).getValue().getAllTimes())))) + ",");//借款金额
//            sb0.append("" + (list5.size() < 1 ? 0 : (list5.get(0) == null ? 0 : (list5.get(0).getValue() == null ? 0 : (list5.get(0).getValue().getOutTimes() == null ? 0 : list5.get(0).getValue().getOutTimes())))) + ",");//借款金额
//            sb0.append("" + (list5.size() < 1 ? 0 : (list5.get(0) == null ? 0 : (list5.get(0).getValue() == null ? 0 : (list5.get(0).getValue().getInTimes() == null ? 0 : list5.get(0).getValue().getInTimes())))) + ",");//借款金额
//            sb0.append("" + (firstCallMap5.size() < 1 ? 0 : (firstCallMap5.get(0) == null ? 0 : firstCallMap5.get(0))) + ",");//借款金额
//            sb0.append("" + (lastCallMap5.size() < 1 ? 0 : (lastCallMap5.get(0) == null ? 0 : lastCallMap5.get(0))) + ",");//借款金额
//            sb0.append("" + (list5.size() < 2 ? 0 : (list5.get(1) == null ? 0 : (list5.get(1).getValue() == null ? 0 : (list5.get(1).getValue().getOtherPhone())))) + ",");//借款金额
//            sb0.append("" + (list5.size() < 2 ? 0 : (list5.get(1) == null ? 0 : (list5.get(1).getValue() == null ? 0 : (list5.get(1).getValue().getAllTimes() == null ? 0 : list5.get(1).getValue().getAllTimes())))) + ",");//借款金额
//            sb0.append("" + (list5.size() < 2 ? 0 : (list5.get(1) == null ? 0 : (list5.get(1).getValue() == null ? 0 : (list5.get(1).getValue().getOutTimes() == null ? 0 : list5.get(1).getValue().getOutTimes())))) + ",");//借款金额
//            sb0.append("" + (list5.size() < 2 ? 0 : (list5.get(1) == null ? 0 : (list5.get(1).getValue() == null ? 0 : (list5.get(1).getValue().getInTimes() == null ? 0 : list5.get(1).getValue().getInTimes())))) + ",");//借款金额
//            sb0.append("" + (firstCallMap5.size() < 2 ? 0 : (firstCallMap5.get(1) == null ? 0 : firstCallMap5.get(1))) + ",");//借款金额
//            sb0.append("" + (lastCallMap5.size() < 2 ? 0 : (lastCallMap5.get(1) == null ? 0 : lastCallMap5.get(1))) + ",");//借款金额
//            sb0.append("" + (list5.size() < 3 ? 0 : (list5.get(2) == null ? 0 : (list5.get(2).getValue() == null ? 0 : (list5.get(2).getValue().getOtherPhone())))) + ",");//借款金额
//            sb0.append("" + (list5.size() < 3 ? 0 : (list5.get(2) == null ? 0 : (list5.get(2).getValue() == null ? 0 : (list5.get(2).getValue().getAllTimes() == null ? 0 : list5.get(2).getValue().getAllTimes())))) + ",");//借款金额
//            sb0.append("" + (list5.size() < 3 ? 0 : (list5.get(2) == null ? 0 : (list5.get(2).getValue() == null ? 0 : (list5.get(2).getValue().getOutTimes() == null ? 0 : list5.get(2).getValue().getOutTimes())))) + ",");//借款金额
//            sb0.append("" + (list5.size() < 3 ? 0 : (list5.get(2) == null ? 0 : (list5.get(2).getValue() == null ? 0 : (list5.get(2).getValue().getInTimes() == null ? 0 : list5.get(2).getValue().getInTimes())))) + ",");//借款金额
//            sb0.append("" + (firstCallMap5.size() < 3 ? 0 : (firstCallMap5.get(2) == null ? 0 : firstCallMap5.get(2))) + ",");//借款金额
//            sb0.append("" + (lastCallMap5.size() < 3 ? 0 : (lastCallMap5.get(2) == null ? 0 : lastCallMap5.get(2))) + ",");//借款金额
//            sb0.append("" + (list5.size() < 4 ? 0 : (list5.get(3) == null ? 0 : (list5.get(3).getValue() == null ? 0 : (list5.get(3).getValue().getOtherPhone())))) + ",");//借款金额
//            sb0.append("" + (list5.size() < 4 ? 0 : (list5.get(3) == null ? 0 : (list5.get(3).getValue() == null ? 0 : (list5.get(3).getValue().getAllTimes() == null ? 0 : list5.get(3).getValue().getAllTimes())))) + ",");//借款金额
//            sb0.append("" + (list5.size() < 4 ? 0 : (list5.get(3) == null ? 0 : (list5.get(3).getValue() == null ? 0 : (list5.get(3).getValue().getOutTimes() == null ? 0 : list5.get(3).getValue().getOutTimes())))) + ",");//借款金额
//            sb0.append("" + (list5.size() < 4 ? 0 : (list5.get(3) == null ? 0 : (list5.get(3).getValue() == null ? 0 : (list5.get(3).getValue().getInTimes() == null ? 0 : list5.get(3).getValue().getInTimes())))) + ",");//借款金额
//            sb0.append("" + (firstCallMap5.size() < 4 ? 0 : (firstCallMap5.get(3) == null ? 0 : firstCallMap5.get(3))) + ",");//借款金额
//            sb0.append("" + (lastCallMap5.size() < 4 ? 0 : (lastCallMap5.get(3) == null ? 0 : lastCallMap5.get(3))) + ",");//借款金额
//            sb0.append("" + (list5.size() < 5 ? 0 : (list5.get(4) == null ? 0 : (list5.get(4).getValue() == null ? 0 : (list5.get(4).getValue().getOtherPhone())))) + ",");//借款金额
//            sb0.append("" + (list5.size() < 5 ? 0 : (list5.get(4) == null ? 0 : (list5.get(4).getValue() == null ? 0 : (list5.get(4).getValue().getAllTimes() == null ? 0 : list5.get(4).getValue().getAllTimes())))) + ",");//借款金额
//            sb0.append("" + (list5.size() < 5 ? 0 : (list5.get(4) == null ? 0 : (list5.get(4).getValue() == null ? 0 : (list5.get(4).getValue().getOutTimes() == null ? 0 : list5.get(4).getValue().getOutTimes())))) + ",");//借款金额
//            sb0.append("" + (list5.size() < 5 ? 0 : (list5.get(4) == null ? 0 : (list5.get(4).getValue() == null ? 0 : (list5.get(4).getValue().getInTimes() == null ? 0 : list5.get(4).getValue().getInTimes())))) + ",");//借款金额
//            sb0.append("" + (firstCallMap5.size() < 5 ? 0 : (firstCallMap5.get(4) == null ? 0 : firstCallMap5.get(4))) + ",");//借款金额
//            sb0.append("" + (lastCallMap5.size() < 5 ? 0 : (lastCallMap5.get(4) == null ? 0 : lastCallMap5.get(4))) + ",");//借款金额
//
//
//            sb0.append("" + userInfo.getIdardProvince() + ",");//借款金额
//            sb0.append("" + userInfo.getPhoneProvince() + ",");//借款金额
//            sb0.append("" + (mspApplyDetails.size() < 1 ? 0 : (mspApplyDetails.get(0) == null ? 0 : mspApplyDetails.get(0).getApplyDate())) + ",");//借款金额
//            sb0.append("" + (mspApplyDetails.size() < 2 ? 0 : (mspApplyDetails.get(1) == null ? 0 : mspApplyDetails.get(1).getApplyDate())) + ",");//借款金额
//            sb0.append("" + (mspApplyDetails.size() < 3 ? 0 : (mspApplyDetails.get(2) == null ? 0 : mspApplyDetails.get(2).getApplyDate())) + ",");//借款金额
//
//            sb0.append("" + (tsp == null ? 0 : tsp.getApplyingCount()) + ",");//借款金额
//
//            sb0.append("" + (tsp == null ? 0 : tsp.getApplyRejectCount()) + ",");//借款金额
//            sb0.append("" + contactsList11.size() + ",");//借款金额
//            sb0.append("" + oneMonthList.size() + ",");//借款金额
//
//            private String idardProvince;
//            private String phoneProvince;
//
//
//
////                sb0.append("" + userInfo.getApplyTime() + ",");//申请借款时间
//            sb0.append("" + userInfo.getLoanTime() + ",");//借款时间
//            sb0.append("" + userInfo.getLoanCount() + ",");//借款次数
//            sb0.append("" + userInfo.getApplyReject() + ",");//借款申请被取消次数
//            sb0.append("" + userInfo.getApplyRejectMoney() + ",");//借款申请被取消金额
//            sb0.append("" + userInfo.getPlayDate() + ",");//上一次应还款时间
//            sb0.append("" + userInfo.getIdardAppear() + ",");//身份证最近出现时间
//            sb0.append("" + userInfo.getPhoneAppear() + ",");//手机最近出现时间
//            sb0.append("" + userInfo.getZhimaScore() + ",");//芝麻信用反欺诈结果（得分）
//            sb0.append("" + contactsList1.size() + ",");//敏感电话总次数
//            sb0.append("" + contactsList.get(0) == null ? 0 : contactsList.get(0).getAllTimes() + ",");//通话详情第一名总通话次数
//            sb0.append("" + contactsList.get(0) == null ? 0 : contactsList.get(0).getInTimes() + ",");//1呼入次数
//            sb0.append("" + contactsList.get(0) == null ? 0 : contactsList.get(0).getOutTimes() + ",");//1呼出次数
//            sb0.append("" + contactsList.get(0) == null ? 0 : contactsList.get(0).getFirstCall() + ",");//第一次通话时间1
//            sb0.append("" + contactsList.get(0) == null ? 0 : contactsList.get(0).getLastCall() + ",");//最后一次通话时间1
//            sb0.append("" + contactsList.get(1) == null ? 0 : contactsList.get(1).getAllTimes() + ",");//通话详情第一名总通话次数
//            sb0.append("" + contactsList.get(1) == null ? 0 : contactsList.get(1).getInTimes() + ",");//1呼入次数
//            sb0.append("" + contactsList.get(1) == null ? 0 : contactsList.get(1).getOutTimes() + ",");//1呼出次数
//            sb0.append("" + contactsList.get(1) == null ? 0 : contactsList.get(1).getFirstCall() + ",");//第一次通话时间1
//            sb0.append("" + contactsList.get(1) == null ? 0 : contactsList.get(1).getLastCall() + ",");//最后一次通话时间1
//            sb0.append("" + contactsList.get(2) == null ? 0 : contactsList.get(2).getAllTimes() + ",");//通话详情第一名总通话次数
//            sb0.append("" + contactsList.get(2) == null ? 0 : contactsList.get(2).getInTimes() + ",");//1呼入次数
//            sb0.append("" + contactsList.get(2) == null ? 0 : contactsList.get(2).getOutTimes() + ",");//1呼出次数
//            sb0.append("" + contactsList.get(2) == null ? 0 : contactsList.get(2).getFirstCall() + ",");//第一次通话时间1
//            sb0.append("" + contactsList.get(2) == null ? 0 : contactsList.get(2).getLastCall() + ",");//最后一次通话时间1
//            sb0.append("" + contactsList.get(3) == null ? 0 : contactsList.get(3).getAllTimes() + ",");//通话详情第一名总通话次数
//            sb0.append("" + contactsList.get(3) == null ? 0 : contactsList.get(3).getInTimes() + ",");//1呼入次数
//            sb0.append("" + contactsList.get(3) == null ? 0 : contactsList.get(3).getOutTimes() + ",");//1呼出次数
//            sb0.append("" + contactsList.get(3) == null ? 0 : contactsList.get(3).getFirstCall() + ",");//第一次通话时间1
//            sb0.append("" + contactsList.get(3) == null ? 0 : contactsList.get(3).getLastCall() + ",");//最后一次通话时间1
//            sb0.append("" + contactsList.get(4) == null ? 0 : contactsList.get(4).getAllTimes() + ",");//通话详情第一名总通话次数
//            sb0.append("" + contactsList.get(4) == null ? 0 : contactsList.get(4).getInTimes() + ",");//1呼入次数
//            sb0.append("" + contactsList.get(4) == null ? 0 : contactsList.get(4).getOutTimes() + ",");//1呼出次数
//            sb0.append("" + contactsList.get(4) == null ? 0 : contactsList.get(4).getFirstCall() + ",");//第一次通话时间1
//            sb0.append("" + contactsList.get(4) == null ? 0 : contactsList.get(4).getLastCall() + ",");//最后一次通话时间1
//            sb0.append("" + phoneContactCount + ",");//通讯录记录量
//            sb0.append("" + userInfo.getApplyScore() + ",");//申请评分
//            sb0.append("" + userInfo.getScore() + ",");//系统评分
//
//
//            pw.println(sb0.toString());
//            logger.info("拼接的字符串是" + sb0.toString());
//            pw.flush();
//            pw.flush();
//            try {
//                fw.flush();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            if (null != fw && null != pw) {
//                try {
//                    fw.flush();
//                            /*pw.close();
//                            fw.close();*/
//                } catch (IOException e) {
//                    // TODO Auto-generated catch block
//                    System.out.println("流关闭异常");
//                    e.printStackTrace();
//                }
//            }
//    }catch (Exception e){
//        logger.warn("数据导出错误",e);
//        e.printStackTrace();
//        }
//    }
//
////    public void dataGroup(List<TableCallDetails> tableCallDetails) {
////        //6个list分别放的是近一个月到近六个月的通话通话详单，用来给通话详单按照月份分组
////        List<TableCallDetails> oneMonthList = Lists.newArrayList();
////        List<TableCallDetails> twoMonthList = Lists.newArrayList();
////        List<TableCallDetails> threeMonthList = Lists.newArrayList();
////        List<TableCallDetails> fourMonthList = Lists.newArrayList();
////        List<TableCallDetails> fiveMonthList = Lists.newArrayList();
////        List<TableCallDetails> sixMonthList = Lists.newArrayList();
////        //6个map分别放置的是近一个月到6个月用户的通话详单汇总，key是otherPhone,value是汇总
////        Map<String, OneMonthContacts> oneMonthMap = Maps.newTreeMap();
////        Map<String, TwoMonthContacts> twoMonthMap = Maps.newTreeMap();
////        Map<String, ThreeMonthContacts> threeMonthMap = Maps.newTreeMap();
////        Map<String, FourMonthContacts> fourMonthMap = Maps.newTreeMap();
////        Map<String, FiveMonthContacts> fiveMonthMap = Maps.newTreeMap();
////        Map<String, SixMonthContacts> sixMonthMap = Maps.newTreeMap();
////        try {
////            for (TableCallDetails bean : tableCallDetails) {
////                if (bean != null) {
////                    if (bean.getStartTime().substring(0, 7).equals("2017年03") ||
////                            bean.getStartTime().substring(0, 7).equals("2017-03")) {
////                        oneMonthList.add(bean);
////                    }
////
////                    if (bean.getStartTime().substring(0, 7).equals("2017年04") ||
////                            bean.getStartTime().substring(0, 7).equals("2017-04")) {
////                        twoMonthList.add(bean);
////                    }
////                    if (bean.getStartTime().substring(0, 7).equals("2017年03") ||
////                            bean.getStartTime().substring(0, 7).equals("2017-03")) {
////                        threeMonthList.add(bean);
////                    }
////                    if (bean.getStartTime().substring(0, 7).equals("2017年02") ||
////                            bean.getStartTime().substring(0, 7).equals("2017-02")) {
////                        fourMonthList.add(bean);
////                    }
////                    if (bean.getStartTime().substring(0, 7).equals("2017年01") ||
////                            bean.getStartTime().substring(0, 7).equals("2017-01")) {
////                        fiveMonthList.add(bean);
////                    }
////                    if (bean.getStartTime().substring(0, 7).equals("2016年12") ||
////                            bean.getStartTime().substring(0, 7).equals("2016-12")) {
////                        sixMonthList.add(bean);
////                    }
////                }
////            }
////
////            logger.warn("最近1,2,3,4,5,6,个月的通话记录: " + oneMonthList.size() + "," + twoMonthList.size() + "," + threeMonthList.size()
////                    + "," + fourMonthList.size() + "," + fiveMonthList.size() + "," + sixMonthList.size());
////            for (TableCallDetails tableCallDetails1 : oneMonthList) {
////                OneMonthContacts oneMonthContacts = oneMonthMap.get(tableCallDetails1.getOtherPhone());
////                if (oneMonthContacts != null) {
////                    oneMonthContacts.setAllTimes(oneMonthContacts.getAllTimes() + 1);
////                    if (tableCallDetails1.getCallType() == 0) {
////                        //tableCallDetails1.getCallType() == 0说明是主叫
////                        if (oneMonthContacts.getOutTimes() != null) {
////                            //如果oneMonthContacts.getOutTimes() != null说明map里面有与此otherPhone通话汇总，只需要把主叫通话+1
////                            oneMonthContacts.setOutTimes(oneMonthContacts.getOutTimes() + 1);
////                        } else {
////                            oneMonthContacts.setOutTimes(1);
////                        }
////                    } else {
////                        if (oneMonthContacts.getInTimes() != null) {
////                            oneMonthContacts.setInTimes(oneMonthContacts.getInTimes() + 1);
////                        } else {
////                            oneMonthContacts.setInTimes(1);
////                        }
////                    }
////                    oneMonthMap.put(tableCallDetails1.getOtherPhone(), oneMonthContacts);
////
////                } else {
////                    OneMonthContacts oneMonthContacts1 = new OneMonthContacts();
////                    oneMonthContacts1.setAllTimes(1);
////                    oneMonthContacts1.setUserId(Long.parseLong(tableCallDetails1.getUserId()));
////                    oneMonthContacts1.setOtherPhone(tableCallDetails1.getOtherPhone());
////                    if (tableCallDetails1.getCallType() == 0) {
////                        oneMonthContacts1.setOutTimes(1);
////                    } else {
////                        oneMonthContacts1.setInTimes(1);
////                    }
////                    oneMonthMap.put(tableCallDetails1.getOtherPhone(), oneMonthContacts1);
////                }
////            }
////            logger.warn("最近1一个月通话人数分组：" + oneMonthMap.size());
////            //转化第二个月逻辑和第一个月一样
////            for (TableCallDetails tableCallDetails1 : twoMonthList) {
////                TwoMonthContacts twoMonthContacts = twoMonthMap.get(tableCallDetails1.getOtherPhone());
////                if (twoMonthContacts != null) {
////                    twoMonthContacts.setAllTimes(twoMonthMap.get(tableCallDetails1.getOtherPhone()).getAllTimes() + 1);
////                    if (tableCallDetails1.getCallType() == 0) {
////                        if (twoMonthContacts.getOutTimes() != null) {
////                            twoMonthContacts.setOutTimes(twoMonthMap.get(tableCallDetails1.getOtherPhone()).getOutTimes() + 1);
////                        } else {
////                            twoMonthContacts.setOutTimes(1);
////                        }
////                    } else {
////                        if (twoMonthContacts.getInTimes() != null) {
////                            twoMonthContacts.setInTimes(twoMonthMap.get(tableCallDetails1.getOtherPhone()).getInTimes() + 1);
////                        } else {
////                            twoMonthContacts.setInTimes(1);
////                        }
////                    }
////                    twoMonthMap.put(tableCallDetails1.getOtherPhone(), twoMonthContacts);
////
////                } else {
////                    TwoMonthContacts twoMonthContacts1 = new TwoMonthContacts();
////                    twoMonthContacts1.setAllTimes(1);
////                    twoMonthContacts1.setUserId(Long.parseLong(tableCallDetails1.getUserId()));
////                    twoMonthContacts1.setOtherPhone(tableCallDetails1.getOtherPhone());
////                    if (tableCallDetails1.getCallType() == 0) {
////                        twoMonthContacts1.setOutTimes(1);
////                    } else {
////                        twoMonthContacts1.setInTimes(1);
////                    }
////                    twoMonthMap.put(tableCallDetails1.getOtherPhone(), twoMonthContacts1);
////                }
////            }
////            logger.warn("最近2个月通话人数分组：" + twoMonthMap.size());
////
////            //对map分别进行排序取出来排名前2名的通话汇总
////
////            List<Map.Entry<String, OneMonthContacts>> list = new ArrayList<Map.Entry<String, OneMonthContacts>>(oneMonthMap.entrySet());
////
////            Collections.sort(list, new Comparator<Map.Entry<String, OneMonthContacts>>() {
////                //降序排序
////                public int compare(Map.Entry<String, OneMonthContacts> o1, Map.Entry<String, OneMonthContacts> o2) {
////                    return o2.getValue().getAllTimes().compareTo(o1.getValue().getAllTimes());
////                }
////            });
////            List<Map.Entry<String, TwoMonthContacts>> list1 = new ArrayList<Map.Entry<String, TwoMonthContacts>>(twoMonthMap.entrySet());
////
////            Collections.sort(list1, new Comparator<Map.Entry<String, TwoMonthContacts>>() {
////                //降序排序
////                public int compare(Map.Entry<String, TwoMonthContacts> o1, Map.Entry<String, TwoMonthContacts> o2) {
////                    return o2.getValue().getAllTimes().compareTo(o1.getValue().getAllTimes());
////                }
////            });
////            System.out.println(list.get(0).getValue().getAllTimes());
////
////
////        } catch (Exception e) {
////            if (!CollectionUtils.isEmpty(tableCallDetails) && tableCallDetails.get(0).getUserId() != null && tableCallDetails.get(0).getOtherPhone() != null) {
////                logger.info("数据转换错误,userId,otherPhone:" + tableCallDetails.get(0).getUserId(), tableCallDetails.get(0).getOtherPhone());
////            }
////        }
////    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        queryUserInfo();
//
//    }
//}
//
//
//
