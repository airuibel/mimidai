package com.mimidai;

import com.alicloud.openservices.tablestore.SyncClient;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.mimidai.dao.ExcludePhoneDao;
import com.mimidai.dao.WeekReportDao;
import com.mimidai.entity.*;
import com.mimidai.service.*;
import com.mimidai.utils.DataUtil;
import com.mimidai.utils.PhoneUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.ParseException;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhangyu on 2017/8/21.
 */
@SpringBootApplication
public class ExportReport implements InitializingBean {
    @Autowired
    private WeekReportService weekReportService;

    @Autowired
    private ExcludePhoneDao excludePhoneDao;

    @Autowired
    private UserJobService userJobService;
//    @Autowired
//    private SJMHReportService sjmhReportService;

    @Autowired
    @Qualifier("createClient")
    private SyncClient client;
    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private SJMHReportService sjmhReportService;

    @Autowired
    private UserDeviceService userDeviceService;
    @Autowired
    private WeekReportDao weekReportDao;
//    @Autowired
//    private TableUserInstalledAppDaoImpl tableUserInstalledAppDao;

//    @Autowired
//    private GraphTraversalSource g;

    @Autowired
    private AccountStatusQueryService accountStatusQueryService;


    private static final Logger logger = LoggerFactory.getLogger("log.tableStore.ExportReport");

    // 使用10个线程执行
    private ExecutorService executorService = Executors.newFixedThreadPool(15);

    @Autowired
    @Qualifier("phoenixJdbcTemplateForQuery")
    private JdbcTemplate jdbcTemplateforQuery;
//
//    @Autowired
//    private SolrClient solrClient;
//
//    @Autowired
//    private TableStoreUtils tableStoreUtils;

    private String path = "/home/zhangyu/0821";
    private String fileName = "Export1111.csv";
    private File file = new File(path, fileName);
    private FileWriter fw = null;
    private PrintWriter pw = null;
    private final static String yidong = "中国移动";
    private final static String liantong = "中国联通";
    private final static String dianxin = "中国电信";


    private void initWr() {
        try {
            fw = new FileWriter(file, true);
            pw = new PrintWriter(fw);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("文件写出流创建异常！");
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        SpringApplication.run(ExportReport.class, args);
    }

    public void queryUserInfo() {
//        List<String> goodMan = weekReportService.queryLoanThreeTime();
//        for (String good : goodMan) {
//            String s = weekReportService.queryFirstLoanDs(good);
//            if ("1".equals(s) || "148".equals(s)) {
//                continue;
//            }
//        List<Map<String, Object>> query = weekReportService.query();
        List<Long> query = weekReportDao.query();
        System.out.println("=============1"+query.size());
        List<Long> list = weekReportDao.queryLoanApply();
        System.out.println("=============2"+list.size());
        List<Long> list1 = weekReportDao.queryMonth();
        System.out.println("=============3"+list1.size());
        HashSet<Object> objects = Sets.newHashSet();
        HashSet<Object> objects2 = Sets.newHashSet();
        for (Long aLong : list1) {
            for (Long aLong1 : list) {
                if(aLong.equals(aLong1)){
                    objects.add(aLong);
                }
            }
        }
        for (Object object : objects) {
            for (Long aLong : query) {
                if(aLong.equals(object)){
                    objects2.add(aLong);
                }
            }
        }
        System.out.println("合并后的结果："+objects2.size());
        for (Object objects3 : objects2) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    Export((long)objects3);
                }
            });

        }
    }
//        List<UserIdcard> userIdcards = userInfoService.queryMobile();
//        HashMap<String, String> corpMap = Maps.newHashMap();
//        long liantongCount = 0L;
//        long yidongCount = 0L;
//        long dianxinCount = 0L;
//        for (UserIdcard phoneCorp : userIdcards) {
//            corpMap.put(phoneCorp.getPhone(), phoneCorp.getCorp());
//        }


    public void Export(Long userId) {
        System.out.println("ab老孟");
//        initWr();
//        StringBuilder sb0 = new StringBuilder();
        List<Map<String, Object>> maps = weekReportDao.queryAny(userId);
        HashSet<Object> objects = Sets.newHashSet();
        for (Map<String, Object> map : maps) {
            Map<String, Object> maps1 = weekReportDao.queryAdvance((int) map.get("userId"), (int) map.get("id"));
            if("0".equals(maps1.get("overdue"))){
                objects.add(maps1.get("userId"));
            }
        }
        System.out.println("最后结果是"+objects.size());
//        String remarkLabel = weekReportService.queryRemark(weekReport.get("loanId"));
//        List<String> phoneContacts = queryHbasePhoneContacts((int)weekReport.get("userId"));
//        HashSet<String> phoneSets = Sets.newHashSet();
//        phoneSets.addAll(phoneContacts);
////        String value = weekReportService.queryValue(remarkLabel);
//        Map<String, Object> goodAndBad = queryOneByUserId((int) weekReport.get("userId"));
//        Integer userDevice = weekReportService.queryUserDevice((int) weekReport.get("userId"));
//        Integer userId = weekReportService.findLoanTime((int) weekReport.get("userId"));
//
//        sb0 = sb0.delete(0, sb0.length());
//        sb0.append("" + weekReport.get("userId") + ",");//yidong
//        sb0.append("" + userId + ",");//yidong
//
//        sb0.append("" + phoneSets.size() + ",");//yidong
//        sb0.append("" + goodAndBad.get("oneAllCount") + ",");//yidong
//        sb0.append("" + goodAndBad.get("onePersonCount") + ",");//yidong
//        sb0.append("" + goodAndBad.get("oneGoodCount") + ",");//yidong
//        sb0.append("" + goodAndBad.get("oneBadCount") + ",");//yidong
//        sb0.append("" + goodAndBad.get("oneAveCount") + ",");//yidong
//        sb0.append("" + userDevice + ",");//yidong



//
//        pw.println(sb0.toString());
//        logger.info("拼接的字符串是" + sb0.toString());
        pw.flush();
        pw.flush();
        try

        {
            fw.flush();
        } catch (
                IOException e3)

        {
            e3.printStackTrace();
        }

        if (null != fw && null != pw)

        {
            try {
                fw.flush();
                            /*pw.close();
                            fw.close();*/
            } catch (IOException e2) {
                // TODO Auto-generated catch block
                System.out.println("流关闭异常");
                e2.printStackTrace();
            }
        }


    }

    private String userLocationSubStr(String userLocation) {
        if (userLocation.contains("自治区")) {
            userLocation = userLocation.substring(0, userLocation.indexOf("自治区") + 3);
        }
        if (!userLocation.contains("自治区") && !userLocation.contains("省") && userLocation.contains("市")) {
            userLocation = userLocation.substring(0, userLocation.indexOf("市") + 1);
        }
        if (userLocation.contains("省")) {
            userLocation = userLocation.substring(0, userLocation.indexOf("省") + 1);
        }
        if (userLocation.length() > 10) {
            String substring = userLocation.substring(0, 10);
            return substring;
        }
        return userLocation;
    }

    private Map<String, Integer> countMinGan(List<ExtraDetailsSimple> solrExtraDetails) {
        int minGanTimes = 0;
        int minGanInTimes = 0;
        int minGanOutTimes = 0;
        int minGanDuration = 0;
        HashMap<String, Integer> minGanMap = Maps.newHashMap();
        for (ExtraDetailsSimple solrExtraDetail : solrExtraDetails) {
            minGanTimes = minGanTimes + solrExtraDetail.getAllTimes();
            minGanInTimes = minGanInTimes + solrExtraDetail.getInTimes();
            minGanOutTimes = minGanOutTimes + solrExtraDetail.getOutTimes();
            minGanDuration = minGanDuration + (solrExtraDetail.getInDuration().intValue()
                    + solrExtraDetail.getOutDuration().intValue());
        }
        minGanMap.put("minGanTims", minGanTimes);
        minGanMap.put("minGanInTimes", minGanInTimes);
        minGanMap.put("minGanOutTimes", minGanOutTimes);
        minGanMap.put("minGanDuration", minGanDuration);
        return minGanMap;

    }

    private List<ExtraDetailsSimple> queryHbaseMinGanPhone(Long userId) {
        StringBuffer sb = new StringBuffer(
                " select userId,phone,otherPhone,firstCall,lastCall,inTimes,outTimes,inDuration,outDuration,"
                        + "inFee,outFee,allTimes,callLocation,type,platform,commType from extralDetails "
                        + "where userId = ")
                .append(userId);
        String sql = sb.toString();
        List<ExtraDetailsSimple> solrExtraDetailsList = new ArrayList<>();
        try {
            solrExtraDetailsList = jdbcTemplateforQuery.query(sql,
                    new BeanPropertyRowMapper<>(ExtraDetailsSimple.class));
        } catch (Exception e) {
            logger.info("【Hbase】敏感电话查询出错", e.toString());
            e.printStackTrace();
        }
        return solrExtraDetailsList;
    }

    private List<UserLocation> queryHbaseUserLocation(Long userId, Date applyTime) {


        StringBuilder sb = new StringBuilder(
                " select userId,address,createTime from userLocation where userId = "
                        + userId + " and createTime  BETWEEN TO_DATE" + "('" + DataUtil.minusOneday(applyTime) + "')  and TO_DATE('" + DataUtil.addOneday(applyTime) + "')" +
                        " order by createTime limit 1");
        StringBuilder sb1 = new StringBuilder(
                " select userId,address,createTime from userLocation where userId = "
                        + userId + " and createTime  < TO_DATE" + "('" + DataUtil.minusOneday(applyTime) + "')" +
                        " order by createTime desc limit 1");
        String sql2 = sb1.toString();
        String sql = sb.toString();
        System.out.println("执行的sql" + sql);
        List<UserLocation> userLocationList = null;
        try {
            userLocationList = jdbcTemplateforQuery.query(sql,
                    new BeanPropertyRowMapper<>(UserLocation.class));
            if (CollectionUtils.isEmpty(userLocationList)) {
                userLocationList = jdbcTemplateforQuery.query(sql2,
                        new BeanPropertyRowMapper<>(UserLocation.class));
            }
            logger.warn("【HBase】执行分页查询Result（userLocation）成功，sql:" + sql);
        } catch (Exception e) {
            logger.info("【Hbase】查询userLocation失败", e.toString());
        }
        return userLocationList;
    }


    private Map<String, Long> computeDuration(List<WeekReport> phoneList,
                                              List<String> contactPhone) {
        HashMap<String, Long> map = Maps.newHashMap();
        Date date = new Date();
        Long allDuration = 0l;
        Long allTimes = 0l;
        Long contactDuration1 = 0L;
        Long contactDuration2 = 0L;
        Long contactTimes1 = 0L;
        Long contactTimes2 = 0L;
        Date firstDate = stringToDate(phoneList.get(0).getFirstCall());
        Date lastDate = stringToDate(phoneList.get(0).getLastCall());
        Long firstContacts = null;
        Long secondContacts = null;
        for (WeekReport weekReport : phoneList) {
            Date strToDate = stringToDate(weekReport.getLastCall());
            if (strToDate.before(date)) {
                allDuration = allDuration + weekReport.getOutDuration() + weekReport.getInDuration();
                allTimes = allTimes + weekReport.getAllTimes();
            }
            if (firstDate.after(stringToDate(weekReport.getFirstCall()))) {
                firstDate = stringToDate(weekReport.getFirstCall());
            }
            if (lastDate.before(stringToDate(weekReport.getLastCall()))) {
                lastDate = stringToDate(weekReport.getLastCall());
            }
            if (contactPhone.get(0).equals(weekReport.getOtherPhone())) {
                contactDuration1 = weekReport.getOutDuration() + weekReport.getInDuration();
                contactTimes1 = weekReport.getAllTimes().longValue();
                firstContacts = (stringToDate(weekReport.getLastCall()).getTime() - stringToDate(weekReport.getFirstCall()).getTime()) / (1000 * 60 * 60 * 24);
            }
            if (contactPhone.get(1).equals(weekReport.getOtherPhone())) {
                contactDuration2 = weekReport.getOutDuration() + weekReport.getInDuration();
                contactTimes2 = weekReport.getAllTimes().longValue();
                secondContacts = (stringToDate(weekReport.getLastCall()).getTime() - stringToDate(weekReport.getFirstCall()).getTime()) / (1000 * 60 * 60 * 24);
            }
        }
        Long time = lastDate.getTime() - firstDate.getTime();
        map.put("time", time);
        map.put("allDuration", allDuration);
        map.put("allTimes", allTimes);
        map.put("firstContactDiff", firstContacts);
        map.put("secondContactDiff", secondContacts);
        map.put("contactDuration", contactDuration1 + contactDuration2);
        map.put("contactTimes", contactTimes1 + contactTimes2);
        return map;
    }


    private Date stringToDate(String lastCall) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        try {
            return sdf.parse(lastCall);
        } catch (Exception e) {
            logger.info("日期转换出错", e.toString());
        }
        return null;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        queryUserInfo();

    }

    private List<String> queryHbaseContacts(Long userId) {
        String sql = " select otherPhone from contacts where userId = " + userId + "  order by allTimes desc";
//        String sql1 = " select otherPhone,firstCall,lastCall,inDuration,outDuration,allTimes,inTimes,outTimes from contacts where userId = " + userId + "  order by allTimes desc";
        List<String> phoneContactsList = null;
        try {
            phoneContactsList = jdbcTemplateforQuery.queryForList(sql, String.class);
            logger.info("【hBaseQuery】执行查询运营商数据（完整数据）成功：" + phoneContactsList.size());
        } catch (Exception e) {
            logger.error("【hBaseQuery】执行查询（完整数据）失败，sql:" + sql + "，失败原因:" + e.toString());
        }
        return phoneContactsList;
    }

    private List<String> queryHbasePhoneContacts(int userId) {
        String sql = " select phone from phoneContacts where userId = " + userId;
//        String sql = " select imei,imsi,phone,name,callTimes,lastCall from phoneContacts where userId = " + userId;
        List<String> phoneContactsList = null;
        try {
            phoneContactsList = jdbcTemplateforQuery.queryForList(sql,
                    String.class);
            logger.info("【hBaseQuery】执行查询通讯录（完整数据）成功：" + phoneContactsList.size());
        } catch (Exception e) {
            logger.error("【hBaseQuery】执行查询通讯录（完整数据）失败，sql:" + sql + "，失败原因:" + e.toString());
        }
        return phoneContactsList;
    }

    private List<PhoneContacts> queryHbaseInOtherPhone(Long userId) {
        String sql = " select otherPhone from contacts where userId = " + userId + " order by inTimes DESC limit 1 ";
        List<PhoneContacts> phoneContactsList = null;
        try {
            phoneContactsList = jdbcTemplateforQuery.query(sql,
                    new BeanPropertyRowMapper<PhoneContacts>(PhoneContacts.class));
            logger.info("【hBaseQuery】执行查询运营商数据（完整数据）成功：" + phoneContactsList.size());
        } catch (Exception e) {
            logger.error("【hBaseQuery】执行查询（完整数据）失败，sql:" + sql + "，失败原因:" + e.toString());
        }
        return phoneContactsList;
    }

    private List<PhoneContacts> queryHbaseOutOtherPhone(Long userId) {
        String sql = " select otherPhone from contacts where userId = " + userId + " order by outTimes DESC limit 1 ";
        List<PhoneContacts> phoneContactsList = null;
        try {
            phoneContactsList = jdbcTemplateforQuery.query(sql,
                    new BeanPropertyRowMapper<PhoneContacts>(PhoneContacts.class));
            logger.info("【hBaseQuery】执行查询运营商数据（完整数据）成功：" + phoneContactsList.size());
        } catch (Exception e) {
            logger.error("【hBaseQuery】执行查询（完整数据）失败，sql:" + sql + "，失败原因:" + e.toString());
        }
        return phoneContactsList;
    }

    private List<PhoneContacts> queryHbaseAll(Long userId) {
        String sql = "select otherPhone,firstCall,lastCall,inDuration,outDuration,allTimes,inTimes,outTimes from contacts where userId = " + userId + " ORDER  BY  allTimes DESC ";
        List<PhoneContacts> phoneContactsList = null;
        try {
            phoneContactsList = jdbcTemplateforQuery.query(sql,
                    new BeanPropertyRowMapper<PhoneContacts>(PhoneContacts.class));
            logger.info("【hBaseQuery】执行查询运营商数据（完整数据）成功：" + phoneContactsList.size());
        } catch (Exception e) {
            logger.error("【hBaseQuery】执行查询（完整数据）失败，sql:" + sql + "，失败原因:" + e.toString());
        }
        return phoneContactsList;
    }


    private Date convertStrToDate2(String dateStr) {
        SimpleDateFormat sff = new SimpleDateFormat("HH:mm");

        Date callTime = null;
        String hourAndMinute = null;
        //   logger.info("通话时间是:" + userCore2.getStartTime());
        String[] dateStr2 = dateStr.split("T");
        if (dateStr2.length == 2) {
            String date = (dateStr2[0] + " " + (dateStr2[1] == null ? "00:00" : dateStr2[1].split("\\.")[0]));
            hourAndMinute = dateStr2[1] == null ? "00:00" : dateStr2[1].split("\\.")[0];
            System.out.println(date);

            try {
                try {
                    callTime = sff.parse(date);
                } catch (java.text.ParseException e) {
                    e.printStackTrace();
                }
            } catch (ParseException e) {
                logger.info("日期转换异常");
            }
        } else {
            if (dateStr.length() == 20) {
                String date = dateStr.replace("年", "-").replace("月", "-")
                        .replace("日", " ").replace("时", ":")
                        .replace("分", ":").replace("秒", "");

                hourAndMinute = date.split(" ")[1];
                try {
                    callTime = sff.parse(date);
                } catch (ParseException e) {
                    logger.info("日期转换异常");
                } catch (java.text.ParseException e) {
                    e.printStackTrace();
                }
            } else {
                String[] date2Str = dateStr.split(" ");

                String date = null;
                if (date2Str.length == 2) {
                    date = (date2Str[0] + date2Str[1]);
                    hourAndMinute = date2Str[1];
                } else {
                    date = (date2Str[0] + "24:00");
                    hourAndMinute = "00:00";
                }
                System.out.println(date);
                try {
                    try {
                        callTime = sff.parse(date);
                    } catch (java.text.ParseException e) {
                        e.printStackTrace();
                    }
                } catch (ParseException e) {
                    logger.error("时间转换异常： " + date);
                }
            }
        }

        return callTime;
    }

    /**
     * 查询以下 联系人是本平台用户
     *
     * @param userId
     * @return
     */
    public List<Map> findAllAppContactsByUserId(int userId) {
        List<String> hbasePhoneContacts = queryHbasePhoneContacts(userId);
        Set<String> phones = new HashSet<String>();
        if (org.apache.commons.collections.CollectionUtils.isEmpty(hbasePhoneContacts)) {
            return new ArrayList<Map>();
        }
        hbasePhoneContacts.forEach((my) -> {
            if (PhoneUtils.isPhoneOrMobile(my)) {
                phones.add("\'" + my + "\'");
            }
        });
        List<Map> appUsers = new ArrayList<Map>();
//        if (org.apache.commons.collections.CollectionUtils.isNotEmpty(phones)) {
//            appUsers = userInfoService.findAllByPhones(phones.toString().replaceAll("\\[", "").replaceAll("]", ""));
//        }
        return appUsers;
    }


    /**
     * 共同联系人
     * <p>
     * <p>
     * 先查出自己的联系人 mys 如果mys为空则返回新的一个空集合 如果mys不为空 查询和自己有相同联系人的其他人 others
     *
     * @param userId
     * @return
     */
    public int sameContacts(int userId) {
        List<String> mys = queryHbasePhoneContacts(userId);
        if (org.apache.commons.collections.CollectionUtils.isEmpty(mys)) {
            return 0;
        }

        List<String> exList = excludePhoneDao.findAll();
        for (int i = 0; i < mys.size(); i++) {
            if (mys.get(i) == null || mys.get(i) == null || mys.get(i).length() < 7
                    || exList.contains(mys.get(i))) {
                mys.remove(i);
                i--;
            }
        }
        HashSet<Long> userIdSets = Sets.newHashSet();
        List<UserPhoneContacts> allByPhoneList = findAllByPhoneList(userId, mys);
        for (UserPhoneContacts userPhoneContacts : allByPhoneList) {
            userIdSets.add(userPhoneContacts.getUserId());
        }

//        List<Map> userInfos = userInfoService.findAllNearByUserIds(userIdSets.toString().replaceAll("\\[", "").replaceAll("]", ""));

        if (CollectionUtils.isEmpty(allByPhoneList)) {
            return 0;
        }
        return userIdSets.size();
    }


    public List<UserPhoneContacts> querySameContacts(String whereSql) {
        logger.warn("【HBase】进入自带条件查询（core0）方法");
        if (StringUtils.isBlank(whereSql)) {
            logger.error("【HBase】（core0）入参whereSql为NULL");
            return null;
        }
        StringBuffer sb = new StringBuffer(
                " select id,userId,imei,phone,name,callTimes,lastCall as lastCallTwo from phoneContacts ");
        String sql = sb.append(whereSql).toString();
        logger.warn("【HBase】进入自带条件查询（core0）方法，sql={}", sql);
        List<UserPhoneContacts> userPhoneContactsList = null;
        try {
            long startTime = System.currentTimeMillis();
            userPhoneContactsList = jdbcTemplateforQuery.query(sql,
                    new BeanPropertyRowMapper<UserPhoneContacts>(UserPhoneContacts.class));
            long endTime = System.currentTimeMillis();
            float excTime = (float) (endTime - startTime) / 1000;
            logger.warn("【HBase】执行自带条件查询（core0）成功，sql:" + sql + "，耗时：" + excTime);
            return userPhoneContactsList;
        } catch (Exception e) {
            logger.error("【HBase】执行自带条件查询（core0）失败，sql:" + sql + "，失败原因:" + e.toString(), e);
            e.printStackTrace();
        }
        return null;
    }


    public List<UserPhoneContacts> findAllByPhoneList(int userId, List<String> phoneList) {
        StringBuilder str = new StringBuilder();
        for (String c : phoneList) {
            str.append(", '").append(c).append("' ");
        }
        if (str.toString().startsWith(", ")) {
            str = new StringBuilder(" where phone in (" + str.substring(1) + ")" + " and userId <> " + userId);
        }
        List<UserPhoneContacts> list = querySameContacts(str.toString());
        return list;
    }


    public int sameJob(Long userId) {
        logger.info("相同工作单位信息,userId={}", userId);
        UserJob job = userJobService.getByUserId(userId);
        List<UserJob> idList = userJobService.findOtherJobIds(userId, job.getPhone());
        Set<String> ids = new HashSet<String>();
        idList.forEach((id) -> {
            ids.add("\'" + id.getId() + "\'");
        });
        List<Map> sameJobs = new ArrayList<Map>();
        if (ids.size() > 0) {
            if (ids.size() > 1000) {
                logger.warn("相同工作单位数量大于1000，size={}，userId={}", ids.size(), userId);
            }
            sameJobs = userJobService.findAllSameJobByIds(ids.toString().replaceAll("\\[", "").replaceAll("]", ""));
        }
        return sameJobs.size();
    }


    public int near(Long userId) {
        logger.info("距离很近,userId={}", userId);
        List<UserLocation> userLocations = findNearUserIds(userId);
        Set<String> idSet = new HashSet<String>();
        if (org.apache.commons.collections.CollectionUtils.isNotEmpty(userLocations)) {
            for (UserLocation userLocation : userLocations) {
                idSet.add(userLocation.getUserId() + "");
            }
            if (idSet.size() > 100) {
                logger.warn("距离很近用户数量大于100，size={}，userId={}", idSet.size(), userId);
            }
//            List<Map> userInfos = userInfoService.findAllNearByUserIds(idSet.toString().replaceAll("\\[", "").replaceAll("]", ""));
            return idSet.size();
        }
        return 0;
    }

    public List<UserLocation> findNearUserIds(Long userId) {
        /**
         * HBase UserLocation
         */
        logger.info("进入【HBase】findNearUserIds方法查询");
        List<UserLocation> resultList = null;
        String whereSql = " where userId = " + userId + " order by createTime desc ";
        logger.info("方法findNearUserIds 开始从HBase查询userLocation,whereSql={}", whereSql);
        List<UserLocation> userLocationList = queryHbaseUserLocation2(whereSql);
        logger.info("方法findNearUserIds 开始从HBase查询userLocation,whereSql={}", whereSql,
                org.apache.commons.collections.CollectionUtils.isEmpty(userLocationList));
        if (org.apache.commons.collections.CollectionUtils.isNotEmpty(userLocationList)) {
//      StringBuffer queryBuffer = new StringBuffer(" where ");
//      for (int i = 0; i < (userLocationList.size() >= 3 ? 3
//          : userLocationList.size()); i++) {
//        UserLocation userLocation = userLocationList.get(i);
//        if (i == 0) {
//          queryBuffer.append(" userId!= " + userId + " " + "AND (address = " + "'"
//              + userLocation.getAddress() + "'");
//        } else {
//          queryBuffer.append(" " + " OR address= " + "'" + userLocation.getAddress() + "'");
//        }
//      }
//      whereSql = queryBuffer.append(")").toString();
            //修改为 where userId！=userId and address in('a','b','c')
            StringBuffer queryBuffer = new StringBuffer(" where userId !=").append(userId);
            int inNum = userLocationList.size() > 3 ? 3 : userLocationList.size();
            StringBuffer queryParamter = new StringBuffer();
            for (int i = 0; i < inNum; i++) {
                String address = userLocationList.get(i).getAddress();
                //如果地址为空 跳过 避免sql异常
                if (address == null || "".equals(address)) {
                    continue;
                } else {
                    //注意格式'address',
                    address = "'" + address + "',";
                    queryParamter.append(address);
                }
            }
            //如果地理位置信息全为空
            if (queryParamter == null || queryParamter.length() == 0) {
                queryBuffer.append(" and 1=2 ");
                whereSql = queryBuffer.toString();
            } else {
                queryBuffer.append(" and address in(").append(queryParamter);
                whereSql = queryBuffer.toString();
                //去除最后一位的逗号，替换为) 或者将
                whereSql = whereSql.substring(0, whereSql.length() - 1) + ")";
            }
            logger.info("方法findNearUserIds 开始从HBase查询userLocation,whereSql={}", whereSql);
            resultList = queryHbaseUserLocation2(whereSql);
            logger.info("方法findNearUserIds 开始从HBase查询userLocation,whereSql={}", whereSql,
                    org.apache.commons.collections.CollectionUtils.isEmpty(resultList));
        }
        logger.info("方法findNearUserIds 查询结果是否为空:" + org.apache.commons.collections.CollectionUtils.isEmpty(resultList));
        return resultList;
    }

    public List<UserLocation> queryHbaseUserLocation2(String whereSql) {
        logger.warn("【HBase】进入查询（userLocation）方法");
        if (StringUtils.isBlank(whereSql)) {
            return null;
        }
        String sql =
                "select userId,address  from  userLocation "
                        + whereSql;
        sql += " limit 800 ";
        logger.warn("【HBase】进入分页查询（userLocation）方法，sql={}", sql);
        List<UserLocation> userLocationList = getUserLocations(sql);
        if (userLocationList != null) {
            return userLocationList;
        }
        return null;
    }


    private List<UserLocation> getUserLocations(String sql) {
        try {
            long startTime = System.currentTimeMillis();
            logger.info("【HBase】执行查询（userLocation），sql:" + sql);
            List<UserLocation> userLocationList = jdbcTemplateforQuery.query(sql,
                    new BeanPropertyRowMapper<>(UserLocation.class));
            long endTime = System.currentTimeMillis();
            float excTime = (float) (endTime - startTime) / 1000;
            logger.warn("【HBase】执行查询（userLocation）成功，sql:" + sql + "，耗时：" + excTime);
            return userLocationList;
        } catch (Exception e) {
            logger.error("【HBase】执行查询（userLocation）失败，sql:" + sql + "，失败原因:" + e.toString());
            e.printStackTrace();
        }
        return null;
    }

//    public Map<String, Object> queryOneByUserId(int userId) {
//        GraphTraversal<Vertex, Vertex> graphTraversalOne = g.V().has("userId", userId).repeat(__.both(GraphProperties.PHONECONTACTS)).times(1).simplePath().dedup();
//        Long allCount = graphTraversalOne.count().next();
//        Long good = 0L;
//        Long bad = 0L;
//        Long ave = 0L;
//        Long personCount = 0L;
//        graphTraversalOne = g.V().has("userId", userId).repeat(__.both(GraphProperties.PHONECONTACTS)).times(1).simplePath().dedup();
//        List<Object> userIdList = graphTraversalOne.values(GraphProperties.USERID).toList();
//        if (org.apache.commons.collections.CollectionUtils.isNotEmpty(userIdList)){
//            personCount = (long) userIdList.size();
//            for (Object o : userIdList) {
//                Long gUserId = (Long)o;
//                Long maxOverdue = weekReportService.queryGoodOrBadByUserId(gUserId);
//                if (maxOverdue != null && maxOverdue > 30){
//                    bad++;
//                }
//                if (maxOverdue != null && maxOverdue > 0 && maxOverdue< 30){
//                    ave++;
//                }
//                if (maxOverdue == null){
//                    good++;
//                }
//            }
//        }
//        HashMap<String, Object> resMap = Maps.newHashMap();
//        resMap.put("oneAllCount",allCount);
//        resMap.put("onePersonCount",personCount);
//        resMap.put("oneGoodCount",good);
//        resMap.put("oneBadCount",bad);
//        resMap.put("oneAveCount",ave);
//        return resMap;
//    }

//    public Integer findAllAppContactsByUserId(List<PhoneTon> mys) {
//        Set<String> phones = new HashSet<String>();
//        Integer a = 0;
//        mys.forEach((my) -> {
//            if (PhoneUtils.isPhoneOrMobile(my.getPhone())) {
//                phones.add("\'" + my.getPhone() + "\'");
//            }
//        });
//        if (org.apache.commons.collections.CollectionUtils.isNotEmpty(phones)) {
//            if (phones.size() > 30) {
//                logger.warn("平台用户数量大于30，size={}，userId={}", phones.size());
//            }
//            a = weekReportService.findAllByPhones(phones.toString().replaceAll("\\[", "").replaceAll("]", ""));
//        }
//        return a;
//    }
}

