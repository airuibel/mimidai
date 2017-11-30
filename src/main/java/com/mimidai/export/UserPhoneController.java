//package com.mimidai.export;
//
//import com.google.common.collect.Lists;
//import com.google.common.collect.Maps;
//import com.google.common.collect.Sets;
//import com.mimidai.entity.UserCore2;
//import com.mimidai.service.MobileService;
//import com.mimidai.service.UserPhoneService;
//import org.apache.solr.client.solrj.SolrClient;
//import org.apache.solr.client.solrj.SolrQuery;
//import org.apache.solr.client.solrj.response.QueryResponse;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.SpringApplication;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.text.DecimalFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.*;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
///**
// * Created by zhangyu on 2017/6/29.
// */
////@SpringBootApplication
//public class UserPhoneController implements InitializingBean {
//
//    @Autowired
//    private UserPhoneService userPhoneService;
//    @Autowired
//    @Qualifier("phoenixJdbcTemplate")
//    private JdbcTemplate jdbcTemplate;
//    @Autowired
//    private MobileService mobileService;
//
//    @Autowired
//    private SolrClient solrClient;
//
//
//    private String path = "/home/zhangyu/";
//    private String fileName = "Export01.csv";
//    private File file = new File(path, fileName);
//    private FileWriter fw = null;
//    private PrintWriter pw = null;
//    private String fileName2 = "Export02.csv";
//    private File file2 = new File(path, fileName2);
//    private String fileName3 = "Export03.csv";
//    private File file3 = new File(path, fileName3);
//    private String fileName4 = "Export04.csv";
//    private File file4 = new File(path, fileName4);
//    private String fileName5 = "Export05.csv";
//    private File file5 = new File(path, fileName5);
//    private String fileName6 = "Export06.csv";
//    private File file6 = new File(path, fileName6);
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
//    private void initWr2() {
//        try {
//            fw = new FileWriter(file2, true);
//            pw = new PrintWriter(fw);
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            System.out.println("文件写出流创建异常！");
//            e.printStackTrace();
//        }
//
//    }
//
//    private void initWr3() {
//        try {
//            fw = new FileWriter(file3, true);
//            pw = new PrintWriter(fw);
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            System.out.println("文件写出流创建异常！");
//            e.printStackTrace();
//        }
//
//    }
//
//    private void initWr4() {
//        try {
//            fw = new FileWriter(file4, true);
//            pw = new PrintWriter(fw);
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            System.out.println("文件写出流创建异常！");
//            e.printStackTrace();
//        }
//
//    }
//
//    private void initWr5() {
//        try {
//            fw = new FileWriter(file5, true);
//            pw = new PrintWriter(fw);
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            System.out.println("文件写出流创建异常！");
//            e.printStackTrace();
//        }
//
//    }
//
//    private void initWr6() {
//        try {
//            fw = new FileWriter(file6, true);
//            pw = new PrintWriter(fw);
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            System.out.println("文件写出流创建异常！");
//            e.printStackTrace();
//        }
//
//
//    }
//
//    // 获取logger
//    private Logger logger = LoggerFactory.getLogger(UserPhoneController.class);
//
//    public static void main1(String[] args) {
//        SpringApplication.run(UserPhoneController.class, args);
//    }
//
//    private ExecutorService executorService = Executors.newFixedThreadPool(10);
//
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        List<String> userPhoneList = userPhoneService.queryPhone();
///*
//        StringBuilder sb = new StringBuilder("排名,地区(手机归属地),联系人数量,联系人占比,主叫时长,被叫时长,主叫次数,被叫次数," +
//                "主叫占总时长比,被叫占总时长比,主叫次数占总次数比,被叫占总次数比");*/
//        StringBuilder sb1 = new StringBuilder("排名,地区(通话地),联系人数量,联系人占比,主叫时长,被叫时长,主叫次数,被叫次数," +
//                "主叫占总时长比,被叫占总时长比,主叫次数占总次数比,被叫占总次数比");
//        StringBuilder sb2 = new StringBuilder("月份,总人数,总时长,主叫次数,被叫次数,主叫时长,被叫时长," +
//                "主叫占总时长比,被叫占总时长比,主叫次数占总次数比,被叫占总次数比");
//        StringBuilder sb3 = new StringBuilder("通话时段(1),通话人数,通话次数,通话时长,主叫次数,被叫次数," +
//                "主叫时长,被叫时长");
//        StringBuilder sb4 = new StringBuilder("通话时段(3),用户id,通话人数,通话次数,通话时长,主叫次数,被叫次数," +
//                "主叫时长,被叫时长");
//        StringBuilder sb5 = new StringBuilder("通话时段(6),用户id,通话人数,通话次数,通话时长,主叫次数,被叫次数," +
//                "主叫时长,被叫时长");
//        for (String phone : userPhoneList) {
//            logger.info("用户的手机号为：" + phone);
//            SolrQuery query = new SolrQuery();
//            String ql = "phone:" + phone;
//            query.setQuery(ql);
//            //查出借款用户的通话记录
//            query.setQuery(ql);
//            query.setStart(0);
//            query.setRows(9999);
//            QueryResponse queryResponse = null;
//            try {
//                queryResponse = solrClient.query(query);
//            } catch (Exception e) {
//                e.printStackTrace();
//                logger.error("solr error info: " + e.toString());
//            }
//            List<UserCore2> beans = queryResponse.getBeans(UserCore2.class);
//         /*  */
//
//            executorService.execute(new Runnable() {
//                @Override
//                public void run() {
//                    countByMonth(beans, sb2);
//                }
//            });
//
//          /*  countByMonth(beans, sb2);
//            queryOnrMonthByHours(beans, sb3);
//            queryThreeMonthByHours(beans, sb4);
//            querySixMonthByHours(beans, sb5);*/
//        }
//
//    }
//
//    //按手机归属地排名统计
//    public void phoneLocationRank(List<UserCore2> beans, StringBuilder sb) {
//        DecimalFormat df = new DecimalFormat("0.00");
//
//        //StringBuilder sb = new StringBuilder("排名,地区,联系人数量,联系人占比,主叫时长,被叫时长,主叫次数,被叫次数," +
//        // "主叫占总时长比,被叫占总时长比,主叫次数占总次数比,被叫占总次数比");
//        initWr();
//    /*    pw.println(sb.toString());
//        pw.flush();
//        try {
//            fw.flush();
//        } catch (IOException e1) {
//            // TODO Auto-generated catch block
//            System.out.println("流写出异常");
//            e1.printStackTrace();
//        }*/
//      /*  userPhoneList.clear();
//        int allOtherPhoneSum = 0;
//        userPhoneList.add("15643788887");*/
//        //一个归属地的联系人数量
//
//        // 出现 异常的userid
//
//
//        double outTimes = 0;
//        //获取被叫次数
//        double inTimes = 0;
//        //获取主叫时长
//        double outDuration = 0;
//        //获取被叫时长
//        double inDuration = 0;
//        //联系人数量
//        double linkCount = 0;
//        //联系人总数
//        double linkSumCount = 0;
//        //联系人归属地
//        String location = null;
//        //按loction分组
//        Map<String, Double> outTimesSortMap = Maps.newHashMap();
//        Map<String, Double> inTimesSortMap = Maps.newHashMap();
//        Map<String, Double> outDurationSortMap = Maps.newHashMap();
//        Map<String, Double> inDurationSortMap = Maps.newHashMap();
//        Map<String, Set<String>> linkCountSortMap = Maps.newHashMap();
//        Set<String> locationSet = Sets.newHashSet();
//        //联系人
//        Set<String> linkSets = Sets.newHashSet();
//        //联系人总数
//        Set<String> otherPhoneSet = Sets.newHashSet();
//        double allLinkedCount = 0;
//        for (UserCore2 contacts : beans) {
//
//            System.out.println(contacts.getOtherPhone());
//            if (contacts.getOtherPhone().length() == 11) {
//                String phoneSub = contacts.getOtherPhone().substring(0, 7);
//                try {
//                    location = mobileService.queryLocation(phoneSub);
//                    if (location == null) {
//                        continue;
//                    }
//
//                } catch (Exception e) {
//                    throw new RuntimeException("获取手机归属地失败手机号是" + contacts.getOtherPhone(), e);
//                }
//             /*   contacts.setCallLocation(location);*/
//                if (contacts.getCallType() == 1) {
//                    if (outTimesSortMap.get(location) != null) {
//                        outTimes = outTimesSortMap.get(location);
//                        outTimesSortMap.put(location, ++outTimes);
//                        locationSet.add(location);
//                    } else {
//                        outTimesSortMap.put(location, ++outTimes);
//                    }
//                }
//                if (contacts.getCallType() == 0) {
//                    if (inTimesSortMap.get(location) != null) {
//                        inTimes = inTimesSortMap.get(location);
//                        inTimesSortMap.put(location, ++inTimes);
//                    } else {
//                        inTimesSortMap.put(location, ++inTimes);
//                    }
//                }
//                if (contacts.getCallType() == 0) {
//                    if (inDurationSortMap.get(location) != null) {
//                        inDuration = inDurationSortMap.get(location);
//                        inDurationSortMap.put(location, inDuration + contacts.getDuration().intValue());
//                    } else {
//                        inDurationSortMap.put(location, (double) contacts.getDuration());
//                    }
//                }
//                if (contacts.getCallType() == 1) {
//                    if (outDurationSortMap.get(location) != null) {
//                        outDuration = outDurationSortMap.get(location);
//                        outDurationSortMap.put(location, outDuration + contacts.getDuration().intValue());
//                    } else {
//                        outDurationSortMap.put(location, (double) contacts.getDuration());
//                    }
//                }
//
//                if (linkCountSortMap.get(location) != null && linkCountSortMap.get(location).size() > 0) {
//                    System.out.println(contacts.getOtherPhone());
//                    System.out.println(location);
//                    linkCountSortMap.get(location).add(contacts.getOtherPhone());
//
//                    linkCountSortMap.put(location, linkCountSortMap.get(location));
//                    System.out.println("联系人：" + linkSets.size());
//
//                } else {
//                    System.out.println(location);
//                    Set linkSets2 = Sets.newHashSet();
//                    linkSets2.add(contacts.getOtherPhone());
//                    linkCountSortMap.put(location, linkSets2);
//                }
//                otherPhoneSet.add(contacts.getOtherPhone());
//            }
//
//        }
//        allLinkedCount = otherPhoneSet.size();
//        locationSet.addAll(inDurationSortMap.keySet());
//        locationSet.addAll(outDurationSortMap.keySet());
//        int i = 1;
//        for (String locationStr : locationSet) {
//
//            double linkRatio = (linkCountSortMap.get(locationStr).size() / allLinkedCount);
//            double inRatio = (inTimesSortMap.get(locationStr) == null ? 0 : inTimesSortMap.get(locationStr)) / ((inTimesSortMap.get(locationStr) == null ? 0 : inTimesSortMap.get(locationStr)) + (outTimesSortMap.get(locationStr) == null ? 0 : outTimesSortMap.get(locationStr)));
//            logger.info("主叫次数：" + (outTimesSortMap.get(locationStr) == null ? 0 : outTimesSortMap.get(locationStr)));
//            logger.info("被叫次数：" + (inTimesSortMap.get(locationStr) == null ? 0 : inTimesSortMap.get(locationStr)));
//            //占被叫次数比
//            double outRatio = (outTimesSortMap.get(locationStr) == null ? 0 : outTimesSortMap.get(locationStr)) / ((inTimesSortMap.get(locationStr) == null ? 0 : inTimesSortMap.get(locationStr)) + (outTimesSortMap.get(locationStr) == null ? 0 : outTimesSortMap.get(locationStr)));
//            //主叫通话时间占比
//            double inCountRatio = (inDurationSortMap.get(locationStr) == null ? 0 : inDurationSortMap.get(locationStr)) / ((inDurationSortMap.get(locationStr) == null ? 0 : inDurationSortMap.get(locationStr)) + (outDurationSortMap.get(locationStr) == null ? 0 : outDurationSortMap.get(locationStr)));
//            System.out.println(inCountRatio);
//            double outCountRatio = (outDurationSortMap.get(locationStr) == null ? 0 : outDurationSortMap.get(locationStr)) / ((inDurationSortMap.get(locationStr) == null ? 0 : inDurationSortMap.get(locationStr)) + (outDurationSortMap.get(locationStr) == null ? 0 : outDurationSortMap.get(locationStr)));
//            sb = sb.delete(0, sb.length());
//            sb.append("" + i + ",");
//            sb.append("" + locationStr + ",");
//           /* sb.append("" + beans.get(0).getUserId() + ",");*/
//            sb.append(("" + linkCountSortMap.get(locationStr).size()).toString() + ",");//联系人数量
//            sb.append(("" + df.format(linkRatio)).toString() + ",");//联系人占比
//            sb.append(("" + inDurationSortMap.get(locationStr)).toString() + ",");//主叫时长
//            sb.append(("" + outDurationSortMap.get(locationStr)).toString() + ",");//被叫时长
//            sb.append(("" + inTimesSortMap.get(locationStr)).toString() + ",");//主叫次数
//            sb.append(("" + outTimesSortMap.get(locationStr)).toString() + ",");//被叫次数
//            sb.append(("" + df.format(inCountRatio)).toString() + ",");//占主叫时间比
//            sb.append(("" + df.format(outCountRatio)).toString() + ",");//被叫时间占比
//            sb.append(("" + df.format(inRatio)).toString() + ",");//主叫次数占比
//            sb.append(("" + df.format(outRatio)).toString() + ",");//被叫次数占比
//            i++;
//            pw.println(sb.toString());
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
//        }
//    }
//    //占被叫次数比
//    //  double outRatio = outTimesSortMap.get(locationStr) / inTimesSortMap.get(locationStr) + outTimesSortMap.get(locationStr);
//    //占总次数比主叫
//    //  double inCountRatio = inDurationSortMap.get(locationStr) / inDurationSortMap.get(locationStr) + outDurationSortMap.get(locationStr);
//    //占总次数比被叫
//    //  double outCountRatio = outDurationSortMap.get(locationStr) / inDurationSortMap.get(locationStr) + outDurationSortMap.get(locationStr);
//    //联系人占比
//    //  double linkRatio = linkCount / contactsList.size();
//
//
//
//          /*  }
//            allOtherPhoneSum = allOtherPhoneSum + contactsL1.size();
//            double otherCountRatio = otherPhoneSum / allOtherPhoneSum;
//*/
//
//    //一个归属地的联系人占比
//
//
//    //按通话地进行朋友圈排行
//
//    public void callLocationRank(List<UserCore2> userPhoneList, StringBuilder sb1) {
//        DecimalFormat df = new DecimalFormat("0.00");
//        initWr2();
//       /* pw.println(sb1.toString());
//         pw.flush();
//         try {
//            fw.flush();
//        } catch (IOException e1) {
//            // TODO Auto-generated catch block
//            System.out.println("流写出异常");
//            e1.printStackTrace();
//        }
//*/
//      /*  userPhoneList.clear();
//        userPhoneList.add("15643788887");*/
//
//        double outTimes = 0;
//        //获取被叫次数
//        double inTimes = 0;
//        //获取主叫时长
//        double outDuration = 0;
//        //获取被叫时长
//        double inDuration = 0;
//        //联系人数量
//        double linkCount = 0;
//        //联系人总数
//        double linkSumCount = 0;
//        //按loction分组
//        Map<String, Double> outTimesSortMap = Maps.newHashMap();
//        Map<String, Double> inTimesSortMap = Maps.newHashMap();
//        Map<String, Double> outDurationSortMap = Maps.newHashMap();
//        Map<String, Double> inDurationSortMap = Maps.newHashMap();
//        Map<String, Set<String>> linkCountSortMap = Maps.newHashMap();
//        Set<String> locationSet = Sets.newHashSet();
//        Set<String> otherPhoneSet = Sets.newHashSet();
//        //用来剔除重复的联系人
//        Set<String> contactSet = Sets.newHashSet();
//
//        double allLinkedCount = 0;
//        for (UserCore2 contacts : userPhoneList) {
//            contactSet.add(contacts.getOtherPhone());
//            String callLocation = contacts.getCallLocation();
//            if (contacts.getCallType() == 1) {
//                if (outTimesSortMap.get(callLocation) != null) {
//                    outTimes = outTimesSortMap.get(callLocation);
//                    outTimesSortMap.put(callLocation, ++outTimes);
//                } else {
//                    outTimesSortMap.put(callLocation, ++outTimes);
//                }
//            }
//            if (contacts.getCallType() == 0) {
//                if (inTimesSortMap.get(callLocation) != null) {
//                    inTimes = inTimesSortMap.get(callLocation);
//                    inTimesSortMap.put(callLocation, ++inTimes);
//                } else {
//                    inTimesSortMap.put(callLocation, ++inTimes);
//                }
//            }
//            if (contacts.getCallType() == 0) {
//                if (inDurationSortMap.get(callLocation) != null) {
//                    inDuration = inDurationSortMap.get(callLocation);
//                    inDurationSortMap.put(callLocation, inDuration + contacts.getDuration().intValue());
//                } else {
//                    inDurationSortMap.put(callLocation, (double) contacts.getDuration());
//                }
//            }
//            if (contacts.getCallType() == 1) {
//                if (outDurationSortMap.get(callLocation) != null) {
//                    outDuration = outDurationSortMap.get(callLocation);
//                    outDurationSortMap.put(callLocation, outDuration + contacts.getDuration().intValue());
//                } else {
//                    outDurationSortMap.put(callLocation, (double) contacts.getDuration());
//                }
//            }
//            if (linkCountSortMap.get(callLocation) != null && linkCountSortMap.get(callLocation).size() > 0) {
//                logger.info("与" + contacts.getOtherPhone() + "通话");
//                linkCountSortMap.get(callLocation).add(contacts.getOtherPhone());
//                linkCountSortMap.put(callLocation, linkCountSortMap.get(callLocation));
//
//            } else {
//                Set<String> linkSets1 = Sets.newHashSet();
//                linkSets1.add(contacts.getOtherPhone());
//                linkCountSortMap.put(callLocation, linkSets1);
//            }
//
//            otherPhoneSet.add(contacts.getOtherPhone());
//        }
//        allLinkedCount = otherPhoneSet.size();
//
//        locationSet.addAll(inDurationSortMap.keySet());
//        locationSet.addAll(outDurationSortMap.keySet());
//          /*  //遍历具有相同归属地的联系人
//            for (Contacts contacts : contactsL1) {
//                outTimes = outTimes + contacts.getOutTimes();
//                inTimes = inTimes + contacts.getInTimes();
//                outDuration = outDuration + contacts.getOutDuration();
//                inDuration = inDuration + contacts.getInDuration();
//                otherPhoneSum = contactsL1.size();*/
//        //占总次数比主叫
//        int i = 1;
//        try {
//            for (String locationStr : locationSet) {
//
//                double linkRatio = (linkCountSortMap.get(locationStr).size() / allLinkedCount);
//                System.out.println("aaa" + linkRatio);
//                double inRatio = (inTimesSortMap.get(locationStr) == null ? 0 : inTimesSortMap.get(locationStr)) / ((inTimesSortMap.get(locationStr) == null ? 0 : inTimesSortMap.get(locationStr)) + (outTimesSortMap.get(locationStr) == null ? 0 : outTimesSortMap.get(locationStr)));
//                System.out.println("主叫次数：" + (outTimesSortMap.get(locationStr) == null ? 0 : outTimesSortMap.get(locationStr)));
//                System.out.println("被叫次数：" + (inTimesSortMap.get(locationStr) == null ? 0 : inTimesSortMap.get(locationStr)));
//                //占被叫次数比
//                double outRatio = (outTimesSortMap.get(locationStr) == null ? 0 : outTimesSortMap.get(locationStr)) / ((inTimesSortMap.get(locationStr) == null ? 0 : inTimesSortMap.get(locationStr)) + (outTimesSortMap.get(locationStr) == null ? 0 : outTimesSortMap.get(locationStr)));
//                //主叫通话时间占比
//                double inCountRatio = (inDurationSortMap.get(locationStr) == null ? 0 : inDurationSortMap.get(locationStr)) / ((inDurationSortMap.get(locationStr) == null ? 0 : inDurationSortMap.get(locationStr)) + (outDurationSortMap.get(locationStr) == null ? 0 : outDurationSortMap.get(locationStr)));
//                System.out.println(inCountRatio);
//                double outCountRatio = (outDurationSortMap.get(locationStr) == null ? 0 : outDurationSortMap.get(locationStr)) / ((inDurationSortMap.get(locationStr) == null ? 0 : inDurationSortMap.get(locationStr)) + (outDurationSortMap.get(locationStr) == null ? 0 : outDurationSortMap.get(locationStr)));
//                sb1 = sb1.delete(0, sb1.length());
//                sb1.append("" + i + ",");
//           /* sb1.append("" + userPhoneList.get(0).getUserId() + ",");*/
//                sb1.append("" + locationStr + ",");
//                sb1.append(("" + linkCountSortMap.get(locationStr).size()).toString() + ",");//联系人数量
//                sb1.append(("" + df.format(linkRatio)).toString() + ",");//联系人占比
//                sb1.append(("" + inDurationSortMap.get(locationStr)).toString() + ",");//主叫时长
//                sb1.append(("" + outDurationSortMap.get(locationStr)).toString() + ",");//被叫时长
//                sb1.append(("" + inTimesSortMap.get(locationStr)).toString() + ",");//主叫次数
//                sb1.append(("" + outTimesSortMap.get(locationStr)).toString() + ",");//被叫次数
//                sb1.append(("" + df.format(inCountRatio)).toString() + ",");//占主叫时间比
//                sb1.append(("" + df.format(outCountRatio)).toString() + ",");//被叫时间占比
//                sb1.append(("" + df.format(inRatio)).toString() + ",");//主叫次数占比
//                sb1.append(("" + df.format(outRatio)).toString() + ",");//被叫次数占比
//                i++;
//                pw.println(sb1.toString());
//                pw.flush();
//                fw.flush();
//            }
//        } catch (IOException e) {
//            logger.info("solr查询异常");
//        } finally
//
//        {
//            if (null != fw && null != pw) {
//                try {
//                    fw.flush();
//                } catch (IOException e) {
//                    // TODO Auto-generated catch block
//                    System.out.println("流关闭异常");
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    //月份通话情况统计
//
//    public void countByMonth(List<UserCore2> userPhoneList, StringBuilder sb2) {
//        logger.info("导出用户月份通话情况开始userId:"+userPhoneList.get(0).getUserId());
//        DecimalFormat df = new DecimalFormat("0.00");//格式化小数
//       /* StringBuilder sb = new StringBuilder("月份,总人数,总时长,主叫次数,被叫次数,主叫时长,被叫时长," +
//                "主叫占总时长比,被叫占总时长比,主叫次数占总次数比,被叫占总次数比");*/
//        initWr3();
////        pw.println(sb2.toString());
////        pw.flush();
////        try {
////            fw.flush();
////        } catch (IOException e1) {
////            // TODO Auto-generated catch block
////            System.out.println("流写出异常");
////            e1.printStackTrace();
////        }
//        //联系人总数
//        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-mm");
//        SimpleDateFormat sdf1 = new SimpleDateFormat("YYYY年mm月");
//
//        double num = 0;
//        //通话总时长
//        double allDuration = 0;
//        double outTimes = 0;
//        //获取被叫次数
//        double inTimes = 0;
//        //获取主叫时长
//        double outDuration = 0;
//        //获取被叫时长
//        double inDuration = 0;
//        //按照相同的otherPhone分组
//        Map<String, Double> inDurationMap = Maps.newHashMap();
//        Map<String, Double> outDurationMap = Maps.newHashMap();
//        Map<String, Double> inTimesMap = Maps.newHashMap();
//        Map<String, Double> outTimesMap = Maps.newHashMap();
//        //按月份统计人数
//        Map<String, Set<String>> linkMap = Maps.newHashMap();
//        //所有的月份
//        Set<String> dateStrSet = Sets.newHashSet();
//        Set<String> linkSet = Sets.newHashSet();
//        for (UserCore2 userCore2 : userPhoneList) {
//            //按通话时间月份分组
//
//
//            Date _date = null;
//            try {
//                if (userCore2.getStartTime().length() == 20) {
//                    String date = userCore2.getStartTime().replace("年", "-").replace("月", "-")
//                            .replace("日", " ").replace("时", ":")
//                            .replace("分", ":").replace("秒", "");
//                    _date = sdf.parse(date);
//                } else {
//                    _date = sdf.parse(userCore2.getStartTime());
//                }
//            } catch (ParseException e) {
//                logger.error("通话时间月份时间格式转换错误", e);
//            }
//            String dateStr = null;
//            if (_date != null) {
//                dateStr = sdf.format(_date);
//                dateStrSet.add(dateStr);
//            }
//                   /* if (durationMap.get(dateStr) != null) {
//                        allDuration = durationMap.get(dateStr);
//                        durationMap.put(dateStr, allDuration + userCore2.getDuration());
//                    } else {
//                        durationMap.put(dateStr, userCore2.getDuration());
//                    }*/
//            if (userCore2.getCallType() == 0) {
//                if (inDurationMap.get(dateStr) != null) {
//                    inDuration = inDurationMap.get(dateStr);
//                    inDurationMap.put(dateStr, inDuration + (double) userCore2.getDuration());
//                } else {
//                    inDurationMap.put(dateStr, (double) userCore2.getDuration());
//                }
//                inTimesMap.put(dateStr, ++inTimes);
//            }
//            if (userCore2.getCallType() == 1) {
//                if (outDurationMap.get(dateStr) != null) {
//                    outDuration = outDurationMap.get(dateStr);
//                    outDurationMap.put(dateStr, outDuration + (double) userCore2.getDuration());
//
//                } else {
//                    outDurationMap.put(dateStr, (double) userCore2.getDuration());
//                }
//                outTimesMap.put(dateStr, ++outTimes);
//            }
//            linkSet.add(userCore2.getOtherPhone());
//            if (linkMap.get(dateStr) != null && linkMap.get(dateStr).size() > 0) {
//                linkMap.get(dateStr).add(userCore2.getOtherPhone());
//                linkMap.put(dateStr, linkMap.get(dateStr));
//            } else {
//                Set<String> linkSets1 = Sets.newHashSet();
//                linkSets1.add(userCore2.getOtherPhone());
//                linkMap.put(dateStr, linkSets1);
//            }
//        }
//        try {
//            for (String month : dateStrSet) {
//                //主叫次数占比
//                System.out.println("月份：" + month);
//                double allTimes = (inTimesMap.get(month) == null ? 0 : inTimesMap.get(month))
//                        + (outTimesMap.get(month) == null ? 0 : outTimesMap.get(month));
//                double alldurations = (inDurationMap.get(month) == null ? 0 : inDurationMap.get(month))
//                        + (outDurationMap.get(month) == null ? 0 : outDurationMap.get(month));
//                System.out.println("全部次数" + allTimes);
//
//                String inTimesRatio = null;
//                if (inTimesMap.get(month) != null) {
//                    inTimesRatio = df.format(inTimesMap.get(month) / allTimes);
//                    System.out.println("主叫次数：" + inTimesMap.get(month));
//                    System.out.println("主叫次数占比:" + inTimesRatio);
//                }
//                //被叫次数占比
//                String outTimesRatio = null;
//                if (outTimesMap.get(month) != null) {
//                    outTimesRatio = df.format(outTimesMap.get(month) / allTimes);
//                    System.out.println("被叫次数：" + outTimesMap.get(month));
//                    System.out.println("被叫次数占比:" + outTimesRatio);
//                }
//
//                //主叫时间占比
//                String inDurationRatio = null;
//                if (inDurationMap.get(month) != null) {
//                    inDurationRatio = df.format((inDurationMap.get(month) / alldurations));
//                    System.out.println("主叫时间占比：" + inDurationRatio);
//                }
//                //被叫时间占比
//                String outDurationRatio = null;
//                if (outDurationMap.get(month) != null) {
//                    outDurationRatio = df.format(outDurationMap.get(month) / alldurations);
//                    System.out.println("被叫时间占比：" + outDurationRatio);
//                }
//                sb2 = sb2.delete(0, sb2.length());
//            /*sb2.append("" + userPhoneList.get(0).getUserId() + ",");*/
//                sb2.append("" + month + ",");//月份“2017-12” "DEC-2017"
//                sb2.append(("" + linkMap.get(month).size()).toString() + ",");
//                sb2.append(("" + df.format((inDurationMap.get(month) == null ? 0 : inDurationMap.get(month)) + (outDurationMap.get(month) == null ? 0 : outDurationMap.get(month)))).toString() + ",");//主叫时长
//                sb2.append(("" + inTimesMap.get(month)).toString() + ",");//主叫次数
//                sb2.append(("" + outTimesMap.get(month)).toString() + ",");//被叫次数
//                sb2.append(("" + inDurationMap.get(month)).toString() + ",");//主叫时间
//                sb2.append(("" + outDurationMap.get(month)).toString() + ",");//被叫时间
//                sb2.append(("" + inTimesRatio).toString() + ",");//占主叫次数比
//                sb2.append(("" + outTimesRatio).toString() + ",");//被叫时间次数
//                sb2.append(("" + inDurationRatio).toString() + ",");//主叫时间占比
//                sb2.append(("" + outDurationRatio).toString() + ",");//被叫时间占比
//                pw.println(sb2.toString());
//                pw.flush();
//                fw.flush();
//            }
//        } catch (IOException e) {
//            logger.info("solr查询异常");
//        } finally {
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
//
//        }
//        logger.info("导出用户月份通话情况结束userId："+userPhoneList.get(0).getUserId());
//
//    }
//
//
//    //通话时间段(近一个月、三个月、六个月)
//    public void queryOnrMonthByHours(List<UserCore2> userPhoneList, StringBuilder sb3) {
//        String time1 = "5:30-9:00";
//        String time2 = "9:00-11:30";
//        String time3 = "11:30-14:00";
//        String time4 = "14:00-17:30";
//        String time5 = "17:00-21:00";
//        String time6 = "21:00-23:30";
//        String time7 = "23:30-5:30";
//        Calendar theCa = Calendar.getInstance();
//        theCa.setTime(new Date());
//        theCa.add(theCa.DATE, -30);
//        Date dateMonth = theCa.getTime();
//        DecimalFormat df = new DecimalFormat("0.00");
//        /*StringBuilder sb3 = new StringBuilder("通话时段,通话人数,通话次数,通话时长,主叫次数,被叫次数," +
//                "主叫时长,被叫时长");*/
//        initWr4();
//        pw.println(sb3.toString());
//        pw.flush();
//        try {
//            fw.flush();
//        } catch (IOException e1) {
//            // TODO Auto-generated catch block
//            System.out.println("流写出异常");
//            e1.printStackTrace();
//        }
//        List<String> dateList = Lists.newArrayList();
//        SimpleDateFormat sf = new SimpleDateFormat("HH:mm");
//        SimpleDateFormat sff = new SimpleDateFormat("yyyy-MM-dd");
//        SimpleDateFormat sff1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//
//        Date oneOne;
//        Date oneTwo;
//        Date oneThree;
//        Date oneFour;
//        Date oneFive;
//        Date oneSix;
//        Date oneSeven;
//        Date oneEight;
//        Date one;
//        try {
//            one = sf.parse("00:01");
//            oneOne = sf.parse("05:30");
//            oneTwo = sf.parse("09:00");
//            oneThree = sf.parse("11:30");
//            oneFour = sf.parse("14:00");
//            oneFive = sf.parse("17:30");
//            oneSix = sf.parse("21:00");
//            oneSeven = sf.parse("23:30");
//            oneEight = sf.parse("05:30");
//
//        } catch (ParseException e) {
//            throw new RuntimeException("时间转换异常", e);
//        }
//        dateList.add(time1);
//        dateList.add(time2);
//        dateList.add(time3);
//        dateList.add(time4);
//        dateList.add(time5);
//        dateList.add(time6);
//        dateList.add(time7);
//
//        //通话人数
//        int callTimes = 0;
//        int callTimes1 = 0;
//        int callTimes2 = 0;
//        int callTimes3 = 0;
//        int callTimes4 = 0;
//        int callTimes5 = 0;
//        int callTimes6 = 0;
//        //通话次数
//        double call = 0;
//        double call1 = 0;
//        double call2 = 0;
//        double call3 = 0;
//        double call4 = 0;
//        double call5 = 0;
//        double call6 = 0;
//        //通话时长
//        double duration = 0;
//
//        //主叫次数
//        double callIn = 0;
//        double callIn1 = 0;
//        double callIn2 = 0;
//        double callIn3 = 0;
//        double callIn4 = 0;
//        double callIn5 = 0;
//        double callIn6 = 0;
//        //被叫次数
//        double callOut = 0;
//        double callOut1 = 0;
//        double callOut2 = 0;
//        double callOut3 = 0;
//        double callOut4 = 0;
//        double callOut5 = 0;
//        double callOut6 = 0;
//        //主叫时长
//        double durationIn = 0;
//
//
//        Map<String, Double> durationMap = Maps.newHashMap();
//        Map<String, Double> inDurationMap = Maps.newHashMap();
//        Map<String, Double> outDurationMap = Maps.newHashMap();
//        Map<String, Double> inTimesMap = Maps.newHashMap();
//        Map<String, Double> outTimesMap = Maps.newHashMap();
//        Set<String> otherPhoneSet = Sets.newHashSet();
//        Set<String> otherPhoneSet1 = Sets.newHashSet();
//        Set<String> otherPhoneSet2 = Sets.newHashSet();
//        Set<String> otherPhoneSet3 = Sets.newHashSet();
//        Set<String> otherPhoneSet4 = Sets.newHashSet();
//        Set<String> otherPhoneSet5 = Sets.newHashSet();
//        Set<String> otherPhoneSet6 = Sets.newHashSet();
//        Map<String, Set<String>> linkMap = Maps.newHashMap();
//        Map<String, Double> contactsMap = Maps.newHashMap();
//
//        for (UserCore2 userCore2 : userPhoneList) {
//            Date callTime = null;
//            String hourAndMinute = null;
//            logger.info("通话时间是:" + userCore2.getStartTime());
//            String[] dateStr = userCore2.getStartTime().split("T");
//            if (dateStr.length == 2) {
//                String date = (dateStr[0] + " " + (dateStr[1] == null ? "00:00" : dateStr[1].split("\\.")[0]));
//                hourAndMinute = dateStr[1] == null ? "00:00" : dateStr[1].split("\\.")[0];
//                System.out.println(date);
//
//                try {
//                    callTime = sff.parse(date);
//                } catch (ParseException e) {
//                    logger.info("日期转换异常");
//                }
//            } else {
//                if (userCore2.getStartTime().length() == 20) {
//                    String date = userCore2.getStartTime().replace("年", "-").replace("月", "-")
//                            .replace("日", " ").replace("时", ":")
//                            .replace("分", ":").replace("秒", "");
//
//                    try {
//                        callTime = sff1.parse(date);
//                        hourAndMinute = date.split(" ")[1];
//                    } catch (ParseException e) {
//                        logger.info("日期转换异常");
//                    }
//                } else {
//                    String[] date2Str = userCore2.getStartTime().split(" ");
//
//                    String date = null;
//                    if (date2Str.length == 2) {
//                        date = (date2Str[0] + date2Str[1]);
//                        hourAndMinute = date2Str[1];
//                    } else {
//                        date = (date2Str[0] + "24:00");
//                        hourAndMinute = "24:00";
//                    }
//                    System.out.println(date);
//                    try {
//                        callTime = sff.parse(date);
//                    } catch (ParseException e) {
//                        logger.error("时间转换异常： " + date);
//                    }
//                }
//            }
//            //30天
//            //一个月5:30-9:00
//            if (dateMonth.getTime() < callTime.getTime()) {
//                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
//
//                Date hourAndMinuteDate = null;
//                try {
//                    hourAndMinuteDate = sdf.parse(hourAndMinute);
//                } catch (ParseException e) {
//                    logger.error("时间格式转换异常", e);
//                }
//                System.out.println(hourAndMinute);
//                if (hourAndMinuteDate.before(oneTwo) && hourAndMinuteDate.after(oneOne)) {
//                    //set剔除重复通话人
//                    System.out.println(oneOne);
//                    System.out.println(oneTwo);
//                    otherPhoneSet.add(userCore2.getOtherPhone());
//                    contactsMap.put(time1, ++call);
//                    linkMap.put(time1, otherPhoneSet);
//                    if (durationMap.get(time1) != null) {
//                        //通话时间
//                        duration = durationMap.get(time1) + (double) userCore2.getDuration();
//                        durationMap.put(time1, duration);
//                    } else {
//                        durationMap.put(time1, (double) userCore2.getDuration());
//                    }
//                    //被叫时长
//                    if (userCore2.getCallType() == 0) {
//                        if (inDurationMap.get(time1) != null) {
//                            durationIn = inDurationMap.get(time1) + (double) userCore2.getDuration();
//                            inDurationMap.put(time1, durationIn);
//
//                        } else {
//                            inDurationMap.put(time1, (double) userCore2.getDuration());
//                        }
//                        inTimesMap.put(time1, ++callIn);
//                    } else {
//                        if (outDurationMap.get(time1) != null) {
//                            durationIn = outDurationMap.get(time1) + (double) userCore2.getDuration();
//                            outDurationMap.put(time1, durationIn);
//
//                        } else {
//                            outDurationMap.put(time1, (double) userCore2.getDuration());
//                        }
//                        outTimesMap.put(time1, ++callOut);
//                    }
//
//                }
//
//                //一个月9:00-11:30
//                if (hourAndMinuteDate.before(oneThree) && hourAndMinuteDate.after(oneTwo)) {
//                    //set剔除重复通话人
//                    System.out.println(oneThree);
//                    System.out.println(oneTwo);
//                    otherPhoneSet1.add(userCore2.getOtherPhone());
//                    contactsMap.put(time2, ++call1);
//                    linkMap.put(time2, otherPhoneSet1);
//                    if (durationMap.get(time2) != null) {
//                        //通话时间
//                        duration = durationMap.get(time2) + (double) userCore2.getDuration();
//                        durationMap.put(time2, duration);
//                    } else {
//                        durationMap.put(time2, (double) userCore2.getDuration());
//                    }
//                    //被叫时长
//                    if (userCore2.getCallType() == 0) {
//                        if (inDurationMap.get(time2) != null) {
//                            durationIn = inDurationMap.get(time2) + (double) userCore2.getDuration();
//                            inDurationMap.put(time2, durationIn);
//
//                        } else {
//                            inDurationMap.put(time2, (double) userCore2.getDuration());
//                        }
//                        inTimesMap.put(time2, ++callIn1);
//                    } else {
//                        if (outDurationMap.get(time2) != null) {
//                            durationIn = outDurationMap.get(time2) + (double) userCore2.getDuration();
//                            outDurationMap.put(time2, durationIn);
//
//                        } else {
//                            outDurationMap.put(time2, (double) userCore2.getDuration());
//                        }
//                        outTimesMap.put(time2, ++callOut1);
//                    }
//
//                }
//                //一个月11:30-14:00
//                if (hourAndMinuteDate.before(oneFour) && hourAndMinuteDate.after(oneThree)) {
//                    //set剔除重复通话人
//                    otherPhoneSet.add(userCore2.getOtherPhone());
//                    contactsMap.put(time3, ++call2);
//                    linkMap.put(time3, otherPhoneSet2);
//                    if (durationMap.get(time3) != null) {
//                        //通话时间
//                        duration = durationMap.get(time3) + (double) userCore2.getDuration();
//                        durationMap.put(time3, duration);
//                    } else {
//                        durationMap.put(time3, (double) userCore2.getDuration());
//                    }
//                    //被叫时长
//                    if (userCore2.getCallType() == 0) {
//                        if (inDurationMap.get(time3) != null) {
//                            durationIn = inDurationMap.get(time3) + (double) userCore2.getDuration();
//                            inDurationMap.put(time3, durationIn);
//
//                        } else {
//                            inDurationMap.put(time3, (double) userCore2.getDuration());
//                        }
//                        inTimesMap.put(time3, ++callIn2);
//                    } else {
//                        if (outDurationMap.get(time3) != null) {
//                            durationIn = outDurationMap.get(time3) + (double) userCore2.getDuration();
//                            outDurationMap.put(time3, durationIn);
//
//                        } else {
//                            outDurationMap.put(time3, (double) userCore2.getDuration());
//                        }
//                        outTimesMap.put(time3, ++callOut2);
//                    }
//
//                }
//                //一个月14:00-17:30
//                if (hourAndMinuteDate.before(oneFive) && hourAndMinuteDate.after(oneFour)) {
//                    //set剔除重复通话人
//                    otherPhoneSet3.add(userCore2.getOtherPhone());
//                    contactsMap.put(time4, ++call3);
//                    linkMap.put(time1, otherPhoneSet3);
//                    if (durationMap.get(time4) != null) {
//                        //通话时间
//                        duration = durationMap.get(time4) + (double) userCore2.getDuration();
//                        durationMap.put(time4, duration);
//                    } else {
//                        durationMap.put(time4, (double) userCore2.getDuration());
//                    }
//                    //被叫时长
//                    if (userCore2.getCallType() == 0) {
//                        if (inDurationMap.get(time4) != null) {
//                            durationIn = inDurationMap.get(time4) + (double) userCore2.getDuration();
//                            inDurationMap.put(time4, durationIn);
//
//                        } else {
//                            inDurationMap.put(time4, (double) userCore2.getDuration());
//                        }
//                        inTimesMap.put(time4, ++callIn3);
//                    } else {
//                        if (outDurationMap.get(time4) != null) {
//                            durationIn = outDurationMap.get(time4) + (double) userCore2.getDuration();
//                            outDurationMap.put(time4, durationIn);
//
//                        } else {
//                            outDurationMap.put(time4, (double) userCore2.getDuration());
//                        }
//                        outTimesMap.put(time4, ++callOut3);
//                    }
//
//
//                }
//                //一个月17:30-21:00
//                if (hourAndMinuteDate.before(oneSix) && hourAndMinuteDate.after(oneFive)) {
//                    //set剔除重复通话人
//                    otherPhoneSet4.add(userCore2.getOtherPhone());
//                    contactsMap.put(time5, ++call4);
//                    linkMap.put(time5, otherPhoneSet4);
//                    if (durationMap.get(time5) != null) {
//                        //通话时间
//                        duration = durationMap.get(time5) + (double) userCore2.getDuration();
//                        durationMap.put(time5, duration);
//                    } else {
//                        durationMap.put(time5, (double) userCore2.getDuration());
//                    }
//                    //被叫时长
//                    if (userCore2.getCallType() == 0) {
//                        if (inDurationMap.get(time5) != null) {
//                            durationIn = inDurationMap.get(time5) + (double) userCore2.getDuration();
//                            inDurationMap.put(time5, durationIn);
//
//                        } else {
//                            inDurationMap.put(time5, (double) userCore2.getDuration());
//                        }
//                        inTimesMap.put(time5, ++callIn4);
//                    } else {
//                        if (outDurationMap.get(time5) != null) {
//                            durationIn = outDurationMap.get(time5) + (double) userCore2.getDuration();
//                            outDurationMap.put(time5, durationIn);
//
//                        } else {
//                            outDurationMap.put(time5, (double) userCore2.getDuration());
//                        }
//                        outTimesMap.put(time5, ++callOut4);
//                    }
//                }
//                //一个月21:00-23:00
//                if (hourAndMinuteDate.before(oneSeven) && hourAndMinuteDate.after(oneSix)) {
//                    //set剔除重复通话人
//                    otherPhoneSet5.add(userCore2.getOtherPhone());
//                    contactsMap.put(time6, ++call5);
//                    linkMap.put(time6, otherPhoneSet5);
//                    if (durationMap.get(time6) != null) {
//                        //通话时间
//                        duration = durationMap.get(time6) + (double) userCore2.getDuration();
//                        durationMap.put(time6, duration);
//                    } else {
//                        durationMap.put(time6, (double) userCore2.getDuration());
//                    }
//                    //被叫时长
//                    if (userCore2.getCallType() == 0) {
//                        if (inDurationMap.get(time6) != null) {
//                            durationIn = inDurationMap.get(time6) + (double) userCore2.getDuration();
//                            inDurationMap.put(time6, durationIn);
//
//                        } else {
//                            inDurationMap.put(time6, (double) userCore2.getDuration());
//                        }
//                        inTimesMap.put(time6, ++callIn5);
//                    } else {
//                        if (outDurationMap.get(time6) != null) {
//                            durationIn = outDurationMap.get(time6) + (double) userCore2.getDuration();
//                            outDurationMap.put(time6, durationIn);
//
//                        } else {
//                            outDurationMap.put(time6, (double) userCore2.getDuration());
//                        }
//                        outTimesMap.put(time6, ++callOut5);
//                    }
//
//                }
//                //一个月23:00-5:30
//                if (hourAndMinuteDate.before(oneEight) && hourAndMinuteDate.after(oneSeven)) {
//                    //set剔除重复通话人
//                    otherPhoneSet6.add(userCore2.getOtherPhone());
//                    contactsMap.put(time7, ++call6);
//                    linkMap.put(time7, otherPhoneSet6);
//                    if (durationMap.get(time7) != null) {
//                        //通话时间
//                        duration = durationMap.get(time7) + (double) userCore2.getDuration();
//                        durationMap.put(time7, duration);
//                    } else {
//                        durationMap.put(time7, (double) userCore2.getDuration());
//                    }
//                    //被叫时长
//                    if (userCore2.getCallType() == 0) {
//                        if (inDurationMap.get(time7) != null) {
//                            durationIn = inDurationMap.get(time7) + (double) userCore2.getDuration();
//                            inDurationMap.put(time7, durationIn);
//
//                        } else {
//                            inDurationMap.put(time7, (double) userCore2.getDuration());
//                        }
//                        inTimesMap.put(time7, ++callIn6);
//                    } else {
//                        if (outDurationMap.get(time7) != null) {
//                            durationIn = outDurationMap.get(time7) + (double) userCore2.getDuration();
//                            outDurationMap.put(time7, durationIn);
//
//                        } else {
//                            outDurationMap.put(time7, (double) userCore2.getDuration());
//                        }
//                        outTimesMap.put(time7, ++callOut6);
//                    }
//                }
//            }
//        }
//        callTimes = otherPhoneSet.size();
//        callTimes1 = otherPhoneSet1.size();
//        callTimes2 = otherPhoneSet2.size();
//        callTimes3 = otherPhoneSet3.size();
//        callTimes4 = otherPhoneSet4.size();
//        callTimes5 = otherPhoneSet5.size();
//        callTimes6 = otherPhoneSet6.size();
//        System.out.println("通话人数" + callTimes + callTimes1 + callTimes2 + callTimes6);
//        try {
//            for (String time : dateList) {
//
//
//                sb3 = sb3.delete(0, sb3.length());
//         /*   sb3.append("" + userPhoneList.get(0).getUserId() + ",");*/
//                sb3.append("" + time + ",");//通话时段
//                sb3.append(("" + (linkMap.get(time) == null ? 0 : linkMap.get(time).size())).toString() + ",");//通话人数
//                sb3.append(("" + (contactsMap.get(time) == null ? 0 : contactsMap.get(time))).toString() + ",");//主叫时长
//                sb3.append(("" + (inTimesMap.get(time) == null ? 0 : inTimesMap.get(time))
//                        + (outTimesMap.get(time) == null ? 0 : outTimesMap.get(time))).toString() + ",");//通话次数
//                sb3.append(("" + (inTimesMap.get(time) == null ? 0 : inTimesMap.get(time))).toString() + ",");//主叫次数
//                sb3.append(("" + (outTimesMap.get(time) == null ? 0 : outTimesMap.get(time))).toString() + ",");//被叫次数
//                sb3.append(("" + (inDurationMap.get(time) == null ? 0 : inDurationMap.get(time))).toString() + ",");//主叫时间
//                sb3.append(("" + (outDurationMap.get(time) == null ? 0 : outDurationMap.get(time))).toString() + ",");//被叫时间
//                pw.println(sb3.toString());
//                pw.flush();
//                fw.flush();
//            }
//        } catch (IOException e) {
//            logger.info("solr查询异常");
//        } finally {
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
//
//        }
//
//    }
//
//
//    public void queryThreeMonthByHours(List<UserCore2> userPhoneList, StringBuilder sb3) {
//        String time1 = "5:30-9:00";
//        String time2 = "9:00-11:30";
//        String time3 = "11:30-14:00";
//        String time4 = "14:00-17:30";
//        String time5 = "17:00-21:00";
//        String time6 = "21:00-23:30";
//        String time7 = "23:30-5:30";
//        Calendar theCa = Calendar.getInstance();
//        theCa.setTime(new Date());
//        theCa.add(theCa.DATE, -90);
//        Date dateMonth = theCa.getTime();
//        DecimalFormat df = new DecimalFormat("0.00");
//        /*StringBuilder sb = new StringBuilder("通话时段,通话人数,通话时长,主叫次数,被叫次数," +
//                "主叫时长,被叫时长");*/
//        initWr5();
//        pw.println(sb3.toString());
//        pw.flush();
//        try {
//            fw.flush();
//        } catch (IOException e1) {
//            // TODO Auto-generated catch block
//            System.out.println("流写出异常");
//            e1.printStackTrace();
//        }
//        List<String> dateList = Lists.newArrayList();
//        SimpleDateFormat sf = new SimpleDateFormat("HH:mm");
//        SimpleDateFormat sff = new SimpleDateFormat("yyyy-MM-dd");
//        SimpleDateFormat sff1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        Date oneOne;
//        Date oneTwo;
//        Date oneThree;
//        Date oneFour;
//        Date oneFive;
//        Date oneSix;
//        Date oneSeven;
//        Date oneEight;
//        Date one;
//        try {
//            one = sf.parse("00:01");
//            oneOne = sf.parse("05:30");
//            oneTwo = sf.parse("09:00");
//            oneThree = sf.parse("11:30");
//            oneFour = sf.parse("14:00");
//            oneFive = sf.parse("17:30");
//            oneSix = sf.parse("21:00");
//            oneSeven = sf.parse("23:30");
//            oneEight = sf.parse("05:30");
//
//        } catch (ParseException e) {
//            throw new RuntimeException("时间转换异常", e);
//        }
//        dateList.add(time1);
//        dateList.add(time2);
//        dateList.add(time3);
//        dateList.add(time4);
//        dateList.add(time5);
//        dateList.add(time6);
//        dateList.add(time7);
//
//        //通话人数
//        int callTimes = 0;
//        int callTimes1 = 0;
//        int callTimes2 = 0;
//        int callTimes3 = 0;
//        int callTimes4 = 0;
//        int callTimes5 = 0;
//        int callTimes6 = 0;
//        //通话次数
//        double call = 0;
//        double call1 = 0;
//        double call2 = 0;
//        double call3 = 0;
//        double call4 = 0;
//        double call5 = 0;
//        double call6 = 0;
//        //通话时长
//        double duration = 0;
//
//        //主叫次数
//        double callIn = 0;
//        double callIn1 = 0;
//        double callIn2 = 0;
//        double callIn3 = 0;
//        double callIn4 = 0;
//        double callIn5 = 0;
//        double callIn6 = 0;
//        //被叫次数
//        double callOut = 0;
//        double callOut1 = 0;
//        double callOut2 = 0;
//        double callOut3 = 0;
//        double callOut4 = 0;
//        double callOut5 = 0;
//        double callOut6 = 0;
//        //主叫时长
//        double durationIn = 0;
//
//
//        Map<String, Double> durationMap = Maps.newHashMap();
//        Map<String, Double> inDurationMap = Maps.newHashMap();
//        Map<String, Double> outDurationMap = Maps.newHashMap();
//        Map<String, Double> inTimesMap = Maps.newHashMap();
//        Map<String, Double> outTimesMap = Maps.newHashMap();
//        Set<String> otherPhoneSet = Sets.newHashSet();
//        Set<String> otherPhoneSet1 = Sets.newHashSet();
//        Set<String> otherPhoneSet2 = Sets.newHashSet();
//        Set<String> otherPhoneSet3 = Sets.newHashSet();
//        Set<String> otherPhoneSet4 = Sets.newHashSet();
//        Set<String> otherPhoneSet5 = Sets.newHashSet();
//        Set<String> otherPhoneSet6 = Sets.newHashSet();
//        Map<String, Set<String>> linkMap = Maps.newHashMap();
//        Map<String, Double> contactsMap = Maps.newHashMap();
//
//        for (UserCore2 userCore2 : userPhoneList) {
//            Date callTime = null;
//            String hourAndMinute = null;
//            String[] dateStr = userCore2.getStartTime().split("T");
//            if (dateStr.length == 2) {
//                String date = (dateStr[0] + " " + (dateStr[1] == null ? "00:00" : dateStr[1].split("\\.")[0]));
//                hourAndMinute = dateStr[1] == null ? "00:00" : dateStr[1].split("\\.")[0];
//                System.out.println(date);
//
//                try {
//                    callTime = sff.parse(date);
//                } catch (ParseException e) {
//                    logger.info("日期转换异常");
//                }
//            } else {
//                if (userCore2.getStartTime().length() == 20) {
//                    String date = userCore2.getStartTime().replace("年", "-").replace("月", "-")
//                            .replace("日", " ").replace("时", ":")
//                            .replace("分", ":").replace("秒", "");
//
//                    try {
//                        callTime = sff1.parse(date);
//                        hourAndMinute = date.split(" ")[1];
//                    } catch (ParseException e) {
//                        logger.info("日期转换异常");
//                    }
//                } else {
//                    String[] date2Str = userCore2.getStartTime().split(" ");
//                    String date = null;
//                    if (date2Str.length == 2) {
//                        date = (date2Str[0] + date2Str[1]);
//                        hourAndMinute = date2Str[1];
//                    } else {
//                        date = (date2Str[0] + "24:00");
//                        hourAndMinute = "24:00";
//                    }
//                    System.out.println(date);
//                    try {
//                        callTime = sff.parse(date);
//                    } catch (ParseException e) {
//                        logger.error("时间转换异常： " + date);
//                    }
//                }
//            }
//            //一个月5:30-9:00
//            if (dateMonth.getTime() < callTime.getTime()) {
//                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
//
//                Date hourAndMinuteDate = null;
//                try {
//                    hourAndMinuteDate = sdf.parse(hourAndMinute);
//                } catch (ParseException e) {
//                    logger.error("时间格式转换异常", e);
//                }
//                System.out.println(hourAndMinute);
//                if (hourAndMinuteDate.before(oneTwo) && hourAndMinuteDate.after(oneOne)) {
//                    //set剔除重复通话人
//                    System.out.println(oneOne);
//                    System.out.println(oneTwo);
//                    otherPhoneSet.add(userCore2.getOtherPhone());
//                    contactsMap.put(time1, ++call);
//                    linkMap.put(time1, otherPhoneSet);
//                    if (durationMap.get(time1) != null) {
//                        //通话时间
//                        duration = durationMap.get(time1) + (double) userCore2.getDuration();
//                        durationMap.put(time1, duration);
//                    } else {
//                        durationMap.put(time1, (double) userCore2.getDuration());
//                    }
//                    //被叫时长
//                    if (userCore2.getCallType() == 0) {
//                        if (inDurationMap.get(time1) != null) {
//                            durationIn = inDurationMap.get(time1) + (double) userCore2.getDuration();
//                            inDurationMap.put(time1, durationIn);
//
//                        } else {
//                            inDurationMap.put(time1, (double) userCore2.getDuration());
//                        }
//                        inTimesMap.put(time1, ++callIn);
//                    } else {
//                        if (outDurationMap.get(time1) != null) {
//                            durationIn = outDurationMap.get(time1) + (double) userCore2.getDuration();
//                            outDurationMap.put(time1, durationIn);
//
//                        } else {
//                            outDurationMap.put(time1, (double) userCore2.getDuration());
//                        }
//                        outTimesMap.put(time1, ++callOut);
//                    }
//
//                }
//
//                //一个月9:00-11:30
//                if (hourAndMinuteDate.before(oneThree) && hourAndMinuteDate.after(oneTwo)) {
//                    //set剔除重复通话人
//                    System.out.println(oneThree);
//                    System.out.println(oneTwo);
//                    otherPhoneSet1.add(userCore2.getOtherPhone());
//                    contactsMap.put(time2, ++call1);
//                    linkMap.put(time2, otherPhoneSet1);
//                    if (durationMap.get(time2) != null) {
//                        //通话时间
//                        duration = durationMap.get(time2) + (double) userCore2.getDuration();
//                        durationMap.put(time2, duration);
//                    } else {
//                        durationMap.put(time2, (double) userCore2.getDuration());
//                    }
//                    //被叫时长
//                    if (userCore2.getCallType() == 0) {
//                        if (inDurationMap.get(time2) != null) {
//                            durationIn = inDurationMap.get(time2) + (double) userCore2.getDuration();
//                            inDurationMap.put(time2, durationIn);
//
//                        } else {
//                            inDurationMap.put(time2, (double) userCore2.getDuration());
//                        }
//                        inTimesMap.put(time2, ++callIn1);
//                    } else {
//                        if (outDurationMap.get(time2) != null) {
//                            durationIn = outDurationMap.get(time2) + (double) userCore2.getDuration();
//                            outDurationMap.put(time2, durationIn);
//
//                        } else {
//                            outDurationMap.put(time2, (double) userCore2.getDuration());
//                        }
//                        outTimesMap.put(time2, ++callOut1);
//                    }
//
//                }
//                //一个月11:30-14:00
//                if (hourAndMinuteDate.before(oneFour) && hourAndMinuteDate.after(oneThree)) {
//                    //set剔除重复通话人
//                    otherPhoneSet.add(userCore2.getOtherPhone());
//                    contactsMap.put(time3, ++call2);
//                    linkMap.put(time3, otherPhoneSet2);
//                    if (durationMap.get(time3) != null) {
//                        //通话时间
//                        duration = durationMap.get(time3) + (double) userCore2.getDuration();
//                        durationMap.put(time3, duration);
//                    } else {
//                        durationMap.put(time3, (double) userCore2.getDuration());
//                    }
//                    //被叫时长
//                    if (userCore2.getCallType() == 0) {
//                        if (inDurationMap.get(time3) != null) {
//                            durationIn = inDurationMap.get(time3) + (double) userCore2.getDuration();
//                            inDurationMap.put(time3, durationIn);
//
//                        } else {
//                            inDurationMap.put(time3, (double) userCore2.getDuration());
//                        }
//                        inTimesMap.put(time3, ++callIn2);
//                    } else {
//                        if (outDurationMap.get(time3) != null) {
//                            durationIn = outDurationMap.get(time3) + (double) userCore2.getDuration();
//                            outDurationMap.put(time3, durationIn);
//
//                        } else {
//                            outDurationMap.put(time3, (double) userCore2.getDuration());
//                        }
//                        outTimesMap.put(time3, ++callOut2);
//                    }
//
//                }
//                //一个月14:00-17:30
//                if (hourAndMinuteDate.before(oneFive) && hourAndMinuteDate.after(oneFour)) {
//                    //set剔除重复通话人
//                    otherPhoneSet3.add(userCore2.getOtherPhone());
//                    contactsMap.put(time4, ++call3);
//                    linkMap.put(time1, otherPhoneSet3);
//                    if (durationMap.get(time4) != null) {
//                        //通话时间
//                        duration = durationMap.get(time4) + (double) userCore2.getDuration();
//                        durationMap.put(time4, duration);
//                    } else {
//                        durationMap.put(time4, (double) userCore2.getDuration());
//                    }
//                    //被叫时长
//                    if (userCore2.getCallType() == 0) {
//                        if (inDurationMap.get(time4) != null) {
//                            durationIn = inDurationMap.get(time4) + (double) userCore2.getDuration();
//                            inDurationMap.put(time4, durationIn);
//
//                        } else {
//                            inDurationMap.put(time4, (double) userCore2.getDuration());
//                        }
//                        inTimesMap.put(time4, ++callIn3);
//                    } else {
//                        if (outDurationMap.get(time4) != null) {
//                            durationIn = outDurationMap.get(time4) + (double) userCore2.getDuration();
//                            outDurationMap.put(time4, durationIn);
//
//                        } else {
//                            outDurationMap.put(time4, (double) userCore2.getDuration());
//                        }
//                        outTimesMap.put(time4, ++callOut3);
//                    }
//
//
//                }
//                //一个月17:30-21:00
//                if (hourAndMinuteDate.before(oneSix) && hourAndMinuteDate.after(oneFive)) {
//                    //set剔除重复通话人
//                    otherPhoneSet4.add(userCore2.getOtherPhone());
//                    contactsMap.put(time5, ++call4);
//                    linkMap.put(time5, otherPhoneSet4);
//                    if (durationMap.get(time5) != null) {
//                        //通话时间
//                        duration = durationMap.get(time5) + (double) userCore2.getDuration();
//                        durationMap.put(time5, duration);
//                    } else {
//                        durationMap.put(time5, (double) userCore2.getDuration());
//                    }
//                    //被叫时长
//                    if (userCore2.getCallType() == 0) {
//                        if (inDurationMap.get(time5) != null) {
//                            durationIn = inDurationMap.get(time5) + (double) userCore2.getDuration();
//                            inDurationMap.put(time5, durationIn);
//
//                        } else {
//                            inDurationMap.put(time5, (double) userCore2.getDuration());
//                        }
//                        inTimesMap.put(time5, ++callIn4);
//                    } else {
//                        if (outDurationMap.get(time5) != null) {
//                            durationIn = outDurationMap.get(time5) + (double) userCore2.getDuration();
//                            outDurationMap.put(time5, durationIn);
//
//                        } else {
//                            outDurationMap.put(time5, (double) userCore2.getDuration());
//                        }
//                        outTimesMap.put(time5, ++callOut4);
//                    }
//                }
//                //一个月21:00-23:00
//                if (hourAndMinuteDate.before(oneSeven) && hourAndMinuteDate.after(oneSix)) {
//                    //set剔除重复通话人
//                    otherPhoneSet5.add(userCore2.getOtherPhone());
//                    contactsMap.put(time6, ++call5);
//                    linkMap.put(time6, otherPhoneSet5);
//                    if (durationMap.get(time6) != null) {
//                        //通话时间
//                        duration = durationMap.get(time6) + (double) userCore2.getDuration();
//                        durationMap.put(time6, duration);
//                    } else {
//                        durationMap.put(time6, (double) userCore2.getDuration());
//                    }
//                    //被叫时长
//                    if (userCore2.getCallType() == 0) {
//                        if (inDurationMap.get(time6) != null) {
//                            durationIn = inDurationMap.get(time6) + (double) userCore2.getDuration();
//                            inDurationMap.put(time6, durationIn);
//
//                        } else {
//                            inDurationMap.put(time6, (double) userCore2.getDuration());
//                        }
//                        inTimesMap.put(time6, ++callIn5);
//                    } else {
//                        if (outDurationMap.get(time6) != null) {
//                            durationIn = outDurationMap.get(time6) + (double) userCore2.getDuration();
//                            outDurationMap.put(time6, durationIn);
//
//                        } else {
//                            outDurationMap.put(time6, (double) userCore2.getDuration());
//                        }
//                        outTimesMap.put(time6, ++callOut5);
//                    }
//
//                }
//                //一个月23:00-5:30
//                if (hourAndMinuteDate.before(oneEight) && hourAndMinuteDate.after(oneSeven)) {
//                    //set剔除重复通话人
//                    otherPhoneSet6.add(userCore2.getOtherPhone());
//                    contactsMap.put(time7, ++call6);
//                    linkMap.put(time7, otherPhoneSet6);
//                    if (durationMap.get(time7) != null) {
//                        //通话时间
//                        duration = durationMap.get(time7) + (double) userCore2.getDuration();
//                        durationMap.put(time7, duration);
//                    } else {
//                        durationMap.put(time7, (double) userCore2.getDuration());
//                    }
//                    //被叫时长
//                    if (userCore2.getCallType() == 0) {
//                        if (inDurationMap.get(time7) != null) {
//                            durationIn = inDurationMap.get(time7) + (double) userCore2.getDuration();
//                            inDurationMap.put(time7, durationIn);
//
//                        } else {
//                            inDurationMap.put(time7, (double) userCore2.getDuration());
//                        }
//                        inTimesMap.put(time7, ++callIn6);
//                    } else {
//                        if (outDurationMap.get(time7) != null) {
//                            durationIn = outDurationMap.get(time7) + (double) userCore2.getDuration();
//                            outDurationMap.put(time7, durationIn);
//
//                        } else {
//                            outDurationMap.put(time7, (double) userCore2.getDuration());
//                        }
//                        outTimesMap.put(time7, ++callOut6);
//                    }
//
//                }
//            }
//        }
//
//        callTimes = otherPhoneSet.size();
//        callTimes1 = otherPhoneSet1.size();
//        callTimes2 = otherPhoneSet2.size();
//        callTimes3 = otherPhoneSet3.size();
//        callTimes4 = otherPhoneSet4.size();
//        callTimes5 = otherPhoneSet5.size();
//        callTimes6 = otherPhoneSet6.size();
//        try {
//            for (String time : dateList) {
//                sb3 = sb3.delete(0, sb3.length());
//         /*   sb3.append("" + userPhoneList.get(0).getUserId() + ",");*/
//                sb3.append("" + time + ",");//通话时段
//                sb3.append(("" + (linkMap.get(time) == null ? 0 : linkMap.get(time).size())).toString() + ",");//通话人数
//                sb3.append(("" + (contactsMap.get(time) == null ? 0 : contactsMap.get(time))).toString() + ",");//主叫时长
//                sb3.append(("" + (inTimesMap.get(time) == null ? 0 : inTimesMap.get(time))
//                        + (outTimesMap.get(time) == null ? 0 : outTimesMap.get(time))).toString() + ",");//通话次数
//                sb3.append(("" + (inTimesMap.get(time) == null ? 0 : inTimesMap.get(time))).toString() + ",");//主叫次数
//                sb3.append(("" + (outTimesMap.get(time) == null ? 0 : outTimesMap.get(time))).toString() + ",");//被叫次数
//                sb3.append(("" + (inDurationMap.get(time) == null ? 0 : inDurationMap.get(time))).toString() + ",");//主叫时间
//                sb3.append(("" + (outDurationMap.get(time) == null ? 0 : outDurationMap.get(time))).toString() + ",");//被叫时间
//                pw.println(sb3.toString());
//                pw.flush();
//                fw.flush();
//            }
//        } catch (IOException e) {
//            logger.info("solr查询异常");
//        } finally {
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
//
//        }
//    }
//
//    public void querySixMonthByHours(List<UserCore2> userPhoneList, StringBuilder sb3) {
//        String time1 = "5:30-9:00";
//        String time2 = "9:00-11:30";
//        String time3 = "11:30-14:00";
//        String time4 = "14:00-17:30";
//        String time5 = "17:00-21:00";
//        String time6 = "21:00-23:30";
//        String time7 = "23:30-5:30";
//        Calendar theCa = Calendar.getInstance();
//        theCa.setTime(new Date());
//        theCa.add(theCa.DATE, -180);
//        Date dateMonth = theCa.getTime();
//        /*StringBuilder sb = new StringBuilder("通话时段,通话人数,通话时长,主叫次数,被叫次数," +
//                "主叫时长,被叫时长");*/
//        initWr6();
//        pw.println(sb3.toString());
//        pw.flush();
//        try {
//            fw.flush();
//        } catch (IOException e1) {
//            // TODO Auto-generated catch block
//            System.out.println("流写出异常");
//            e1.printStackTrace();
//        }
//        List<String> dateList = Lists.newArrayList();
//        SimpleDateFormat sf = new SimpleDateFormat("HH:mm");
//        SimpleDateFormat sff = new SimpleDateFormat("yyyy-MM-dd");
//        SimpleDateFormat sff1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        Date oneOne;
//        Date oneTwo;
//        Date oneThree;
//        Date oneFour;
//        Date oneFive;
//        Date oneSix;
//        Date oneSeven;
//        Date oneEight;
//        Date one;
//        try {
//            one = sf.parse("00:01");
//            oneOne = sf.parse("05:30");
//            oneTwo = sf.parse("09:00");
//            oneThree = sf.parse("11:30");
//            oneFour = sf.parse("14:00");
//            oneFive = sf.parse("17:30");
//            oneSix = sf.parse("21:00");
//            oneSeven = sf.parse("23:30");
//            oneEight = sf.parse("05:30");
//
//        } catch (ParseException e) {
//            throw new RuntimeException("时间转换异常", e);
//        }
//        dateList.add(time1);
//        dateList.add(time2);
//        dateList.add(time3);
//        dateList.add(time4);
//        dateList.add(time5);
//        dateList.add(time6);
//        dateList.add(time7);
//
//        //通话人数
//        int callTimes = 0;
//        int callTimes1 = 0;
//        int callTimes2 = 0;
//        int callTimes3 = 0;
//        int callTimes4 = 0;
//        int callTimes5 = 0;
//        int callTimes6 = 0;
//        //通话次数
//        double call = 0;
//        double call1 = 0;
//        double call2 = 0;
//        double call3 = 0;
//        double call4 = 0;
//        double call5 = 0;
//        double call6 = 0;
//        //通话时长
//        double duration = 0;
//
//        //主叫次数
//        double callIn = 0;
//        double callIn1 = 0;
//        double callIn2 = 0;
//        double callIn3 = 0;
//        double callIn4 = 0;
//        double callIn5 = 0;
//        double callIn6 = 0;
//        //被叫次数
//        double callOut = 0;
//        double callOut1 = 0;
//        double callOut2 = 0;
//        double callOut3 = 0;
//        double callOut4 = 0;
//        double callOut5 = 0;
//        double callOut6 = 0;
//        //主叫时长
//        double durationIn = 0;
//
//
//        Map<String, Double> durationMap = Maps.newHashMap();
//        Map<String, Double> inDurationMap = Maps.newHashMap();
//        Map<String, Double> outDurationMap = Maps.newHashMap();
//        Map<String, Double> inTimesMap = Maps.newHashMap();
//        Map<String, Double> outTimesMap = Maps.newHashMap();
//        Set<String> otherPhoneSet = Sets.newHashSet();
//        Set<String> otherPhoneSet1 = Sets.newHashSet();
//        Set<String> otherPhoneSet2 = Sets.newHashSet();
//        Set<String> otherPhoneSet3 = Sets.newHashSet();
//        Set<String> otherPhoneSet4 = Sets.newHashSet();
//        Set<String> otherPhoneSet5 = Sets.newHashSet();
//        Set<String> otherPhoneSet6 = Sets.newHashSet();
//        Map<String, Set<String>> linkMap = Maps.newHashMap();
//        Map<String, Double> contactsMap = Maps.newHashMap();
//
//        for (UserCore2 userCore2 : userPhoneList) {
//            Date callTime = null;
//            String hourAndMinute = null;
//            String[] dateStr = userCore2.getStartTime().split("T");
//            if (dateStr.length == 2) {
//                String date = (dateStr[0] + " " + (dateStr[1] == null ? "00:00" : dateStr[1].split("\\.")[0]));
//                hourAndMinute = dateStr[1] == null ? "00:00" : dateStr[1].split("\\.")[0];
//                System.out.println(date);
//
//                try {
//                    callTime = sff.parse(date);
//                } catch (ParseException e) {
//                    logger.info("日期转换异常");
//                }
//            } else {
//                if (userCore2.getStartTime().length() == 20) {
//                    String date = userCore2.getStartTime().replace("年", "-").replace("月", "-")
//                            .replace("日", " ").replace("时", ":")
//                            .replace("分", ":").replace("秒", "");
//
//                    try {
//                        callTime = sff1.parse(date);
//                        hourAndMinute = date.split(" ")[1];
//                    } catch (ParseException e) {
//                        logger.info("日期转换异常");
//                    }
//                } else {
//                    String[] date2Str = userCore2.getStartTime().split(" ");
//
//                    String date = null;
//                    if (date2Str.length == 2) {
//                        date = (date2Str[0] + date2Str[1]);
//                        hourAndMinute = date2Str[1];
//                    } else {
//                        date = (date2Str[0] + "24:00");
//                        hourAndMinute = "24:00";
//                    }
//                    System.out.println(date);
//                    try {
//                        callTime = sff.parse(date);
//                    } catch (ParseException e) {
//                        logger.error("时间转换异常： " + date);
//                    }
//                }
//            }
//
//            //一个月5:30-9:00
//            if (dateMonth.getTime() < callTime.getTime()) {
//                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
//
//                Date hourAndMinuteDate = null;
//                try {
//                    hourAndMinuteDate = sdf.parse(hourAndMinute);
//                } catch (ParseException e) {
//                    logger.error("时间格式转换异常", e);
//                }
//                System.out.println(hourAndMinute);
//                if (hourAndMinuteDate.before(oneTwo) && hourAndMinuteDate.after(oneOne)) {
//                    //set剔除重复通话人
//                    System.out.println(oneOne);
//                    System.out.println(oneTwo);
//                    otherPhoneSet.add(userCore2.getOtherPhone());
//                    contactsMap.put(time1, ++call);
//                    linkMap.put(time1, otherPhoneSet);
//                    if (durationMap.get(time1) != null) {
//                        //通话时间
//                        duration = durationMap.get(time1) + (double) userCore2.getDuration();
//                        durationMap.put(time1, duration);
//                    } else {
//                        durationMap.put(time1, (double) userCore2.getDuration());
//                    }
//                    //被叫时长
//                    if (userCore2.getCallType() == 0) {
//                        if (inDurationMap.get(time1) != null) {
//                            durationIn = inDurationMap.get(time1) + (double) userCore2.getDuration();
//                            inDurationMap.put(time1, durationIn);
//
//                        } else {
//                            inDurationMap.put(time1, (double) userCore2.getDuration());
//                        }
//                        inTimesMap.put(time1, ++callIn);
//                    } else {
//                        if (outDurationMap.get(time1) != null) {
//                            durationIn = outDurationMap.get(time1) + (double) userCore2.getDuration();
//                            outDurationMap.put(time1, durationIn);
//
//                        } else {
//                            outDurationMap.put(time1, (double) userCore2.getDuration());
//                        }
//                        outTimesMap.put(time1, ++callOut);
//                    }
//
//                }
//
//                //一个月9:00-11:30
//                if (hourAndMinuteDate.before(oneThree) && hourAndMinuteDate.after(oneTwo)) {
//                    //set剔除重复通话人
//                    System.out.println(oneThree);
//                    System.out.println(oneTwo);
//                    otherPhoneSet1.add(userCore2.getOtherPhone());
//                    contactsMap.put(time2, ++call1);
//                    linkMap.put(time2, otherPhoneSet1);
//                    if (durationMap.get(time2) != null) {
//                        //通话时间
//                        duration = durationMap.get(time2) + (double) userCore2.getDuration();
//                        durationMap.put(time2, duration);
//                    } else {
//                        durationMap.put(time2, (double) userCore2.getDuration());
//                    }
//                    //被叫时长
//                    if (userCore2.getCallType() == 0) {
//                        if (inDurationMap.get(time2) != null) {
//                            durationIn = inDurationMap.get(time2) + (double) userCore2.getDuration();
//                            inDurationMap.put(time2, durationIn);
//
//                        } else {
//                            inDurationMap.put(time2, (double) userCore2.getDuration());
//                        }
//                        inTimesMap.put(time2, ++callIn1);
//                    } else {
//                        if (outDurationMap.get(time2) != null) {
//                            durationIn = outDurationMap.get(time2) + (double) userCore2.getDuration();
//                            outDurationMap.put(time2, durationIn);
//
//                        } else {
//                            outDurationMap.put(time2, (double) userCore2.getDuration());
//                        }
//                        outTimesMap.put(time2, ++callOut1);
//                    }
//
//                }
//                //一个月11:30-14:00
//                if (hourAndMinuteDate.before(oneFour) && hourAndMinuteDate.after(oneThree)) {
//                    //set剔除重复通话人
//                    otherPhoneSet.add(userCore2.getOtherPhone());
//                    contactsMap.put(time3, ++call2);
//                    linkMap.put(time3, otherPhoneSet2);
//                    if (durationMap.get(time3) != null) {
//                        //通话时间
//                        duration = durationMap.get(time3) + (double) userCore2.getDuration();
//                        durationMap.put(time3, duration);
//                    } else {
//                        durationMap.put(time3, (double) userCore2.getDuration());
//                    }
//                    //被叫时长
//                    if (userCore2.getCallType() == 0) {
//                        if (inDurationMap.get(time3) != null) {
//                            durationIn = inDurationMap.get(time3) + (double) userCore2.getDuration();
//                            inDurationMap.put(time3, durationIn);
//
//                        } else {
//                            inDurationMap.put(time3, (double) userCore2.getDuration());
//                        }
//                        inTimesMap.put(time3, ++callIn2);
//                    } else {
//                        if (outDurationMap.get(time3) != null) {
//                            durationIn = outDurationMap.get(time3) + (double) userCore2.getDuration();
//                            outDurationMap.put(time3, durationIn);
//
//                        } else {
//                            outDurationMap.put(time3, (double) userCore2.getDuration());
//                        }
//                        outTimesMap.put(time3, ++callOut2);
//                    }
//
//                }
//                //一个月14:00-17:30
//                if (hourAndMinuteDate.before(oneFive) && hourAndMinuteDate.after(oneFour)) {
//                    //set剔除重复通话人
//                    otherPhoneSet3.add(userCore2.getOtherPhone());
//                    contactsMap.put(time4, ++call3);
//                    linkMap.put(time1, otherPhoneSet3);
//                    if (durationMap.get(time4) != null) {
//                        //通话时间
//                        duration = durationMap.get(time4) + (double) userCore2.getDuration();
//                        durationMap.put(time4, duration);
//                    } else {
//                        durationMap.put(time4, (double) userCore2.getDuration());
//                    }
//                    //被叫时长
//                    if (userCore2.getCallType() == 0) {
//                        if (inDurationMap.get(time4) != null) {
//                            durationIn = inDurationMap.get(time4) + (double) userCore2.getDuration();
//                            inDurationMap.put(time4, durationIn);
//
//                        } else {
//                            inDurationMap.put(time4, (double) userCore2.getDuration());
//                        }
//                        inTimesMap.put(time4, ++callIn3);
//                    } else {
//                        if (outDurationMap.get(time4) != null) {
//                            durationIn = outDurationMap.get(time4) + (double) userCore2.getDuration();
//                            outDurationMap.put(time4, durationIn);
//
//                        } else {
//                            outDurationMap.put(time4, (double) userCore2.getDuration());
//                        }
//                        outTimesMap.put(time4, ++callOut3);
//                    }
//
//
//                }
//                //一个月17:30-21:00
//                if (hourAndMinuteDate.before(oneSix) && hourAndMinuteDate.after(oneFive)) {
//                    //set剔除重复通话人
//                    otherPhoneSet4.add(userCore2.getOtherPhone());
//                    contactsMap.put(time5, ++call4);
//                    linkMap.put(time5, otherPhoneSet4);
//                    if (durationMap.get(time5) != null) {
//                        //通话时间
//                        duration = durationMap.get(time5) + (double) userCore2.getDuration();
//                        durationMap.put(time5, duration);
//                    } else {
//                        durationMap.put(time5, (double) userCore2.getDuration());
//                    }
//                    //被叫时长
//                    if (userCore2.getCallType() == 0) {
//                        if (inDurationMap.get(time5) != null) {
//                            durationIn = inDurationMap.get(time5) + (double) userCore2.getDuration();
//                            inDurationMap.put(time5, durationIn);
//
//                        } else {
//                            inDurationMap.put(time5, (double) userCore2.getDuration());
//                        }
//                        inTimesMap.put(time5, ++callIn4);
//                    } else {
//                        if (outDurationMap.get(time5) != null) {
//                            durationIn = outDurationMap.get(time5) + (double) userCore2.getDuration();
//                            outDurationMap.put(time5, durationIn);
//
//                        } else {
//                            outDurationMap.put(time5, (double) userCore2.getDuration());
//                        }
//                        outTimesMap.put(time5, ++callOut4);
//                    }
//                }
//                //一个月21:00-23:00
//                if (hourAndMinuteDate.before(oneSeven) && hourAndMinuteDate.after(oneSix)) {
//                    //set剔除重复通话人
//                    otherPhoneSet5.add(userCore2.getOtherPhone());
//                    contactsMap.put(time6, ++call5);
//                    linkMap.put(time6, otherPhoneSet5);
//                    if (durationMap.get(time6) != null) {
//                        //通话时间
//                        duration = durationMap.get(time6) + (double) userCore2.getDuration();
//                        durationMap.put(time6, duration);
//                    } else {
//                        durationMap.put(time6, (double) userCore2.getDuration());
//                    }
//                    //被叫时长
//                    if (userCore2.getCallType() == 0) {
//                        if (inDurationMap.get(time6) != null) {
//                            durationIn = inDurationMap.get(time6) + (double) userCore2.getDuration();
//                            inDurationMap.put(time6, durationIn);
//
//                        } else {
//                            inDurationMap.put(time6, (double) userCore2.getDuration());
//                        }
//                        inTimesMap.put(time6, ++callIn5);
//                    } else {
//                        if (outDurationMap.get(time6) != null) {
//                            durationIn = outDurationMap.get(time6) + (double) userCore2.getDuration();
//                            outDurationMap.put(time6, durationIn);
//
//                        } else {
//                            outDurationMap.put(time6, (double) userCore2.getDuration());
//                        }
//                        outTimesMap.put(time6, ++callOut5);
//                    }
//
//                }
//                //一个月23:00-5:30
//                if (hourAndMinuteDate.before(oneEight) && hourAndMinuteDate.after(oneSeven)) {
//                    //set剔除重复通话人
//                    otherPhoneSet6.add(userCore2.getOtherPhone());
//                    contactsMap.put(time7, ++call6);
//                    linkMap.put(time7, otherPhoneSet6);
//                    if (durationMap.get(time7) != null) {
//                        //通话时间
//                        duration = durationMap.get(time7) + (double) userCore2.getDuration();
//                        durationMap.put(time7, duration);
//                    } else {
//                        durationMap.put(time7, (double) userCore2.getDuration());
//                    }
//                    //被叫时长
//                    if (userCore2.getCallType() == 0) {
//                        if (inDurationMap.get(time7) != null) {
//                            durationIn = inDurationMap.get(time7) + (double) userCore2.getDuration();
//                            inDurationMap.put(time7, durationIn);
//
//                        } else {
//                            inDurationMap.put(time7, (double) userCore2.getDuration());
//                        }
//                        inTimesMap.put(time7, ++callIn6);
//                    } else {
//                        if (outDurationMap.get(time7) != null) {
//                            durationIn = outDurationMap.get(time7) + (double) userCore2.getDuration();
//                            outDurationMap.put(time7, durationIn);
//
//                        } else {
//                            outDurationMap.put(time7, (double) userCore2.getDuration());
//                        }
//                        outTimesMap.put(time7, ++callOut6);
//                    }
//                }
//            }
//        }
//
//        callTimes = otherPhoneSet.size();
//        callTimes1 = otherPhoneSet1.size();
//        callTimes2 = otherPhoneSet2.size();
//        callTimes3 = otherPhoneSet3.size();
//        callTimes4 = otherPhoneSet4.size();
//        callTimes5 = otherPhoneSet5.size();
//        callTimes6 = otherPhoneSet6.size();
//        System.out.println("通话人数" + callTimes + callTimes1 + callTimes2 + callTimes6);
//        try {
//            for (String time : dateList) {
//                sb3 = sb3.delete(0, sb3.length());
//         /*   sb3.append("" + userPhoneList.get(0).getUserId() + ",");*/
//                sb3.append("" + time + ",");//通话时段
//                sb3.append(("" + (linkMap.get(time) == null ? 0 : linkMap.get(time).size())).toString() + ",");//通话人数
//                sb3.append(("" + (contactsMap.get(time) == null ? 0 : contactsMap.get(time))).toString() + ",");//主叫时长
//                sb3.append(("" + (inTimesMap.get(time) == null ? 0 : inTimesMap.get(time))
//                        + (outTimesMap.get(time) == null ? 0 : outTimesMap.get(time))).toString() + ",");//通话次数
//                sb3.append(("" + (inTimesMap.get(time) == null ? 0 : inTimesMap.get(time))).toString() + ",");//主叫次数
//                sb3.append(("" + (outTimesMap.get(time) == null ? 0 : outTimesMap.get(time))).toString() + ",");//被叫次数
//                sb3.append(("" + (inDurationMap.get(time) == null ? 0 : inDurationMap.get(time))).toString() + ",");//主叫时间
//                sb3.append(("" + (outDurationMap.get(time) == null ? 0 : outDurationMap.get(time))).toString() + ",");//被叫时间
//                pw.println(sb3.toString());
//                pw.flush();
//                fw.flush();
//            }
//        } catch (IOException e) {
//            logger.info("solr查询异常");
//        } finally {
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
//
//        }
//    }
//}