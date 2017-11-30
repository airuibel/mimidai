package com.mimidai.service;

import com.alicloud.openservices.tablestore.SyncClient;
import com.alicloud.openservices.tablestore.model.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mimidai.entity.TableCallDetails2;
import com.mimidai.entity.opdReportSjmh.SjmhReportResultData;
import com.mimidai.utils.MD5Utils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import static org.apache.hadoop.yarn.webapp.hamlet.HamletSpec.Scope.row;

/**
 * Created by zhangyu on 2017/9/6.
 */

/**
 * 数据魔盒 增改查 Created by 孟庆艺 on 2017-08-04.
 */
@Service
public class SJMHReportService {
    @Autowired
    @Qualifier("createClient")
    private SyncClient client;
    /**
     * 表结构如下 表名:SjmhReportResultData 表中共有12列
     */
    private final String TABLENAME = "SjmhReportResultDatas";
    //private final String TABLENAME = "versiontest";
    private final String ERRORINFO = "当前列该版本无数据返回";
    //日志
    private static final Logger logger = LoggerFactory.getLogger("log.tableStore.TableSjmhReportResultDataDaoImpl");

    /**
     * 2.运营商指标信息热数据:{report_info,data_completeness,mobile_info,info_match,info_check,behavior_analysis,
     * emergency_contact1_detail,emergency_contact2_detail,work_tel_detail,all_contact_stats}
     * 报告信息,数据完整性,手机信息,信息匹配,信息检测,行为分析,紧急联系人1-2明细,工作号码明细,全部联系人统计
     */
    String COLUMN_SJMHREPORTRESULTDATAHOT = "sjmh_report_result_hot";
    String callDetails = "details";
    String extraInfo = "extraInfo";
//    public void insert(Long userId, String phone, SjmhReportResultData sjmhReportResultData, Long timeStamp) {
//        if (userId == null || StringUtils.isBlank(phone)) {
//            logger.warn("【数据魔盒】入参存在空值,不予查询,userId={},phone={}", userId, phone);
//            return;
//        }
//        PrimaryKey primaryKey = createPrimaryKey(userId, phone);
//        RowPutChange rowPutChange = new RowPutChange(TABLENAME, primaryKey);
//        //依次填充列：1.report_info 2.sjmh_report_result_hot 3.sjmh_report_result_cold 4 ...诸多list
//        for (EnumSjmhReportResultData enumSjmhReportResultData : EnumSjmhReportResultData.values()) {
//            rowPutChange.addColumn(enumSjmhReportResultData.getName(), divideSjmhReportResultData
//                    (sjmhReportResultData, enumSjmhReportResultData), timeStamp);
//        }
//        client.putRow(new PutRowRequest(rowPutChange));
//    }
//
//
//    public void update(Long userId, String phone, SjmhReportResultData sjmhReportResultData, Long timeStamp) {
//        if (userId == null || StringUtils.isBlank(phone)) {
//            logger.warn("【数据魔盒】入参存在空值,不予查询,userId={},phone={}", userId, phone);
//            return;
//        }
//        PrimaryKey primaryKey = createPrimaryKey(userId, phone);
//        RowUpdateChange rowUpdateChange = new RowUpdateChange(TABLENAME, primaryKey);
//        //依次填充列：1.report_info 2.sjmh_report_result_hot 3.sjmh_report_result_cold 4 ...诸多list
//        for (EnumSjmhReportResultData enumSjmhReportResultData : EnumSjmhReportResultData.values()) {
//            rowUpdateChange.put(ISjmhColumnName.COLUMN_REPORTINFO, divideSjmhReportResultData(sjmhReportResultData,
//                    enumSjmhReportResultData), timeStamp);
//        }
//        client.updateRow(new UpdateRowRequest(rowUpdateChange));
//    }
//
//
//    public List<SjmhReportResultData> query(Long userId, String phone) {
//        if (userId == null || StringUtils.isBlank(phone)) {
//            logger.warn("【数据魔盒】入参存在空值,不予查询,userId={},phone={}", userId, phone);
//            return null;
//        }
//        Row row = getRow(userId, phone);
//        List<SjmhReportResultData> resultList = new ArrayList<>();
//        for (EnumSjmhReportResultData enumSjmhReportResultData : EnumSjmhReportResultData.values()) {
//            resultList.addAll(getSjmhReportResultData(row, enumSjmhReportResultData));
//        }
//        return resultList;
//    }

    //查询一整个实体
    //GY

//    public SjmhReportResultData query2(Long userId, String phone) {
//
//        SjmhReportResultData data = new SjmhReportResultData();
//
//        if (userId == null || StringUtils.isBlank(phone)) {
//            logger.warn("【数据魔盒】入参存在空值,不予查询,userId={},phone={}", userId, phone);
//            return null;
//        }
//        Row row = getRow(userId, phone);
//
//        //遍历所有列名
//        for (EnumSjmhReportResultData enumSjmhReportResultData : EnumSjmhReportResultData.values()) {
//            //获取每一列的 大实体类
//            SjmhReportResultData data1 = getSjmhReportResultData2(row, enumSjmhReportResultData);
//            if (data1 == null) {
//                continue;
//            }
//            //汇总成一个 大实体类
//            if (data.getReport_info() == null && data1.getReport_info() != null) {
//                data.setReport_info(data1.getReport_info());
//            }
//            if (data.getData_completeness() == null && data1.getData_completeness() != null) {
//                data.setData_completeness(data1.getData_completeness());
//            }
//            if (data.getMobile_info() == null && data1.getMobile_info() != null) {
//                data.setMobile_info(data1.getMobile_info());
//            }
//            if (data.getInfo_match() == null && data1.getInfo_match() != null) {
//                data.setInfo_match(data1.getInfo_match());
//            }
//            if (data.getInfo_check() == null && data1.getInfo_check() != null) {
//                data.setInfo_check(data1.getInfo_check());
//            }
//            if (data.getBehavior_analysis() == null && data1.getBehavior_analysis() != null) {
//                data.setBehavior_analysis(data1.getBehavior_analysis());
//            }
//            if (data.getEmergency_contact1_detail() == null && data1.getEmergency_contact1_detail() != null) {
//                data.setEmergency_contact1_detail(data1.getEmergency_contact1_detail());
//            }
//            if (data.getEmergency_contact2_detail() == null && data1.getEmergency_contact2_detail() != null) {
//                data.setEmergency_contact2_detail(data1.getEmergency_contact2_detail());
//            }
//            if (data.getWork_tel_detail() == null && data1.getWork_tel_detail() != null) {
//                data.setWork_tel_detail(data1.getWork_tel_detail());
//            }
//            if (data.getAll_contact_stats() == null && data1.getAll_contact_stats() != null) {
//                data.setAll_contact_stats(data1.getAll_contact_stats());
//            }
//            if (data.getCarrier_consumption_stats() == null && data1.getCarrier_consumption_stats() != null) {
//                data.setCarrier_consumption_stats(data1.getCarrier_consumption_stats());
//            }
//            if (data.getActive_silence_stats() == null && data1.getActive_silence_stats() != null) {
//                data.setActive_silence_stats(data1.getActive_silence_stats());
//            }
//            if (data.getCall_duration_stats_2hour() == null && data1.getCall_duration_stats_2hour() != null) {
//                data.setCall_duration_stats_2hour(data1.getCall_duration_stats_2hour());
//            }
//        }
//
//        return data;
//    }


//    @Override
//    public List<SjmhReportResultData> queryHotData(Long userId, String phone) {
//        if (userId == null || StringUtils.isBlank(phone)) {
//            logger.warn("【数据魔盒】入参存在空值,不予查询,userId={},phone={}", userId, phone);
//            return null;
//        }
//        Row row = getRow(userId, phone);
//        return getSjmhReportResultData(row, EnumSjmhReportResultData.COLUMN_SJMHREPORTRESULTDATAHOT);
//    }

//    @Override
//    public List<SjmhReportResultData> queryColdData(Long userId, String phone) {
//        if (userId == null || StringUtils.isBlank(phone)) {
//            logger.warn("【数据魔盒】入参存在空值,不予查询,userId={},phone={}", userId, phone);
//            return null;
//        }
//        Row row = getRow(userId, phone);
//        return getSjmhReportResultData(row, EnumSjmhReportResultData.COLUMN_SJMHREPORTRESULTDATACOLD);
//    }

//
//    @Override
//    public List<SjmhReportResultData> queryReportInfo(Long userId, String phone) {
//        if (userId == null || StringUtils.isBlank(phone)) {
//            logger.warn("【数据魔盒】入参存在空值,不予查询,userId={},phone={}", userId, phone);
//            return null;
//        }
//        Row row = getRow(userId, phone);
//        // List reportInfoList = row != null ? row.getColumn(ISjmhColumnName.COLUMN_REPORTINFO) : new ArrayList();
//        // return reportInfoList;
//        return getSjmhReportResultData(row, EnumSjmhReportResultData.COLUMN_REPORTINFO);
//
//    }

    public List<TableCallDetails2> queryObject(Long userId, String phone,String tableName, String columnName) {
      //  List<SjmhReportResultData> sjmhReportResultDataList = new ArrayList<>();
        List<TableCallDetails2> objectList = new ArrayList<>();
        Row row = getRow(userId, phone,tableName);
        if (row != null) {
            List<Column> columnsList = row.getColumn(columnName);
            Gson gson = new Gson();
            for (Column column : columnsList) {
                //如果该列不为空
                if (!ERRORINFO.equals(column.getValue().toString())) {
                    //转实体类时使用
                    // SjmhReportResultData sjmhReportResultData = gson.fromJson(column.getValue().toString(),
                    //         SjmhReportResultData.class);
                    // sjmhReportResultDataList.add(sjmhReportResultData);

                    //转list时使用
                    List<TableCallDetails2> columnList = gson.fromJson(column.getValue().toString(), new
                            TypeToken<List<TableCallDetails2>>() {}.getType());
//                    List list = gson.fromJson(column.getValue().toString(), List.class);
                    objectList.addAll(columnList);
                }
            }
        }
        return objectList;
    }

//
//    public Boolean isExist(Long userId, String phone) {
//        if (userId == null || StringUtils.isBlank(phone)) {
//            logger.warn("【数据魔盒】入参存在空值,不予查询,userId={},phone={}", userId, phone);
//            return null;
//        }
//        Row row = getRow(userId, phone);
//        return row != null;
//    }
//
//
//    public void insertOrUpdate(Long userId, String phone, SjmhReportResultData sjmhReportResultData, Long timeStamp) {
//        if (isExist(userId, phone)) {
//            update(userId, phone, sjmhReportResultData, timeStamp);
//        } else {
//            insert(userId, phone, sjmhReportResultData, timeStamp);
//        }
//    }


    /**
     * 构造主键
     *
     * @param userId 用户ID
     * @param phone  注意：电话为该用户申请运营商认证的电话(user_phone_check)
     */
    private PrimaryKey createPrimaryKey(Long userId, String phone) {
        logger.debug("进入tableStore(core1)生成构造主键通用方法createPrimaryKey");
        // 首先对入参进行判断 若为空直接返回 不再查询
        if (userId == null || phone == null) {
            logger.info("【数据魔盒】表格存储数据魔盒createPrimaryKey入参存在空值,不予查询");
            return null;
        }
        // userId 散裂化
        String md5UserId = MD5Utils.md5Hex(userId + "");
        // 构造主键
        PrimaryKeyBuilder primaryKeyBuilder = PrimaryKeyBuilder.createPrimaryKeyBuilder();
        primaryKeyBuilder.addPrimaryKeyColumn("userId", PrimaryKeyValue.fromString(md5UserId));
        primaryKeyBuilder.addPrimaryKeyColumn("phone", PrimaryKeyValue.fromString(phone));
        logger.debug("【数据魔盒】tableStore生成构造主键通用方法createPrimaryKey：phone={},userId={},哈希之前userIds={}", phone,
                md5UserId, userId);
        return primaryKeyBuilder.build();
    }

    /**
     * list转换为json
     */
    private ColumnValue listToColumnValue(List list) {
        if (CollectionUtils.isEmpty(list)) {
            logger.warn("【数据魔盒】list为空,转换空字符串");
            return ColumnValue.fromString(ERRORINFO);
        }
        Gson gson = new Gson();
        return ColumnValue.fromString(gson.toJson(list));
    }

    /**
     * 实体类转json 为统一 需要将实体类装到list中
     */
    private ColumnValue objectToJson(Object object) {
        List list = new ArrayList();
        list.add(object);
        return listToColumnValue(list);
    }
//
//        private ColumnValue divideSjmhReportResultData(SjmhReportResultData sjmhReportResultData,
//                                                       EnumSjmhReportResultData column) {
//            ColumnValue columnValue = null;
//            switch (column) {
//                case COLUMN_REPORTINFO:
//                    columnValue = objectToJson(sjmhReportResultData.getReport_info());
//                    break;
//                case COLUMN_SJMHREPORTRESULTDATAHOT:
//                    columnValue = objectToJson(setHotData(sjmhReportResultData));
//                    break;
//                case COLUMN_SJMHREPORTRESULTDATACOLD:
//                    columnValue = objectToJson(setColdData(sjmhReportResultData));
//                    break;
//                case COLUMN_ALLCONTACTDETAIL:
//                    columnValue = listToColumnValue(sjmhReportResultData.getAll_contact_detail());
//                    break;
//                case COLUMN_ALLCONTACTSTATSPERMONTH:
//                    columnValue = listToColumnValue(sjmhReportResultData.getAll_contact_stats_per_month());
//                    break;
//                case COLUMN_RISKCONTACTSTATS:
//                    columnValue = listToColumnValue(sjmhReportResultData.getRisk_contact_stats());
//                    break;
//                case COLUMN_RISKCONTACTDETAIL:
//                    columnValue = listToColumnValue(sjmhReportResultData.getRisk_contact_detail());
//                    break;
//                case COLUMN_FINANCECONTACTSTATS:
//                    columnValue = listToColumnValue(sjmhReportResultData.getFinance_contact_stats());
//                    break;
//                case COLUMN_FINANCECONTACTDETAIL:
//                    columnValue = listToColumnValue(sjmhReportResultData.getFinance_contact_detail());
//                    break;
//                case COLUMN_CONTACTAREASTATSPERCITY:
//                    columnValue = listToColumnValue(sjmhReportResultData.getContact_area_stats_per_city());
//                    break;
//                case COLUMN_CARRIERCONSUMPTIONSTATSPERMONTH:
//                    columnValue = listToColumnValue(sjmhReportResultData.getCarrier_consumption_stats_per_month());
//                    break;
//                case COLUMN_CALLAREASTATSPERCITY:
//                    columnValue = listToColumnValue(sjmhReportResultData.getCall_area_stats_per_city());
//                    break;
//                case COLUMN_TRAVELTRACKANALYSISPERCITY:
//                    columnValue = listToColumnValue(sjmhReportResultData.getTravel_track_analysis_per_city());
//                    break;
//                default:
//                    break;
//            }
//            return columnValue;
//        }

    /**
     * 切割热数据
     * <p>
     * 运营商指标信息热数据:{report_info,data_completeness,mobile_info,info_match,info_check,behavior_analysis,
     * emergency_contact1_detail,emergency_contact2_detail,work_tel_detail,all_contact_stats}
     * 报告信息,数据完整性,手机信息,信息匹配,信息检测,行为分析,紧急联系人1-2明细,工作号码明细,全部联系人统计
     */
    private SjmhReportResultData setHotData(SjmhReportResultData sjmhReportResultData) {
        SjmhReportResultData hotSjmhReportResultData = new SjmhReportResultData();
        hotSjmhReportResultData.setReport_info(sjmhReportResultData.getReport_info());
        hotSjmhReportResultData.setData_completeness(sjmhReportResultData.getData_completeness());
        hotSjmhReportResultData.setMobile_info(sjmhReportResultData.getMobile_info());
        hotSjmhReportResultData.setInfo_match(sjmhReportResultData.getInfo_match());
        hotSjmhReportResultData.setInfo_check(sjmhReportResultData.getInfo_check());
        hotSjmhReportResultData.setBehavior_analysis(sjmhReportResultData.getBehavior_analysis());
        hotSjmhReportResultData.setEmergency_contact1_detail(sjmhReportResultData.getEmergency_contact1_detail());
        hotSjmhReportResultData.setEmergency_contact2_detail(sjmhReportResultData.getEmergency_contact2_detail());
        hotSjmhReportResultData.setWork_tel_detail(sjmhReportResultData.getWork_tel_detail());
        hotSjmhReportResultData.setAll_contact_stats(sjmhReportResultData.getAll_contact_stats());
        hotSjmhReportResultData.setCall_duration_stats_2hour(sjmhReportResultData.getCall_duration_stats_2hour());
        return hotSjmhReportResultData;
    }

    /**
     * 切割冷数据
     * <p>
     * 运营商指标信息冷数据:{user_info,carrier_consumption_stats,active_silence_stats,home_tel_detail,emergency_contact3_detail,
     * emergency_contact4_detail,emergency_contact5_detail} 用户信息,运营商消费统计,静默活跃统计,家庭号码明细,紧急联系人3-5明细
     */

    private SjmhReportResultData setColdData(SjmhReportResultData sjmhReportResultData) {
        SjmhReportResultData coldSjmhReportResultData = new SjmhReportResultData();
        coldSjmhReportResultData.setUser_info(sjmhReportResultData.getUser_info());
        coldSjmhReportResultData.setCarrier_consumption_stats(sjmhReportResultData.getCarrier_consumption_stats());
        coldSjmhReportResultData.setActive_silence_stats(sjmhReportResultData.getActive_silence_stats());
        coldSjmhReportResultData.setHome_tel_detail(sjmhReportResultData.getHome_tel_detail());
        coldSjmhReportResultData.setEmergency_contact3_detail(sjmhReportResultData.getEmergency_contact3_detail());
        coldSjmhReportResultData.setEmergency_contact4_detail(sjmhReportResultData.getEmergency_contact4_detail());
        coldSjmhReportResultData.setEmergency_contact5_detail(sjmhReportResultData.getEmergency_contact5_detail());
        return coldSjmhReportResultData;
    }

    /**
     * 获取 返回 row
     */
    private Row getRow(Long userId, String phone, String tableName) {
        if (userId == null || StringUtils.isBlank(phone)) {
            logger.warn("【数据魔盒】入参存在空值,不予查询,userId={},phone={}", userId, phone);
            return null;
        }
        PrimaryKey primaryKey = createPrimaryKey(userId, phone);
        // 读取短信表 该用户-电话对应的该行数据
        SingleRowQueryCriteria criteria = new SingleRowQueryCriteria(tableName, primaryKey);
        // 设置读取最新版本
        criteria.setMaxVersions(1);
        try {
            // 根据条件建立请求
            GetRowRequest getRowRequest = new GetRowRequest(criteria);
            // 返回请求数据
            GetRowResponse getRowResponse = client.getRow(getRowRequest);
            return getRowResponse.getRow();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据列名 读取实体类
     */
//        private List<SjmhReportResultData> getSjmhReportResultData(Row row, EnumSjmhReportResultData ColumnName) {
//            List<SjmhReportResultData> sjmhReportResultDataList = new ArrayList<>();
//            if (row != null) {
//                List<Column> columnsList = row.getColumn(ColumnName.getName());
//                Gson gson = new Gson();
//                for (Column column : columnsList) {
//                    //如果该列不为空
//                    if (!ERRORINFO.equals(column.getValue().toString())) {
//                        //转实体类时使用
//                        // SjmhReportResultData sjmhReportResultData = gson.fromJson(column.getValue().toString(),
//                        //         SjmhReportResultData.class);
//                        // sjmhReportResultDataList.add(sjmhReportResultData);
//
//                        //转list时使用
//                        List<SjmhReportResultData> columnList = gson.fromJson(column.getValue().toString(), new
//                                TypeToken<List<SjmhReportResultData>>() {}.getType());
//                        sjmhReportResultDataList.addAll(columnList);
//                    }
//                }
//            }
//            return sjmhReportResultDataList;
//        }


    /**
     * @param row
     * @param ColumnName
     * @return
     * GY
     * 2017年8月11日
     * 读取一列返回一个 大实体类
     */
//        private SjmhReportResultData getSjmhReportResultData2(Row row, EnumSjmhReportResultData ColumnName) {
//            SjmhReportResultData data = null;
//            if (row != null) {
//                List<Column> columnsList = row.getColumn(ColumnName.getName());
//                Gson gson = new Gson();
//                //获取最新一个版本
//                Column c1 = columnsList.get(0);
//                //如果该列不为空
//                if (!ERRORINFO.equals(c1.getValue().toString())) {
//                    //转list时使用
//                /*List<SjmhReportResultData> columnList = gson.fromJson(c1.getValue().toString(), new
//                        TypeToken<List<SjmhReportResultData>>() {}.getType());*/
//                    String s;
//                    if("sjmh_report_result_hot".equals(c1.getName()) ||
//                            "sjmh_report_result_cold".equals(c1.getName())){
//                        s = c1.getValue().toString().substring(1, c1.getValue().toString().length()-1);
//                    }else if("report_info".equals(c1.getName())){
//                        s = "{\""+c1.getName()+"\""+":"+c1.getValue().toString().substring(1, c1.getValue().toString().length()-1)+"}";
//                    }else{
//                        s = "{\""+c1.getName()+"\""+":"+c1.getValue().toString()+"}";
//                    }
//                    SjmhReportResultData columnData = gson.fromJson(
//                            //c1.getName()+":"+c1.getValue().toString().substring(1, c1.getValue().toString().length()-1),
//                            s,
//                            SjmhReportResultData.class);
//                    //data = columnList.get(0);
//                    data = columnData;
//                }
//            }
//            return data;
//        }

}


