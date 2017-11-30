package com.mimidai.utils;

import com.alicloud.openservices.tablestore.SyncClient;
import com.alicloud.openservices.tablestore.model.*;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.mimidai.entity.TableUserInstalledApp;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 孟庆艺 on 2017-07-12.
 */
@Repository
public class TableUserInstalledAppDaoImpl implements TableUserInstalledAppDao {
    @Autowired
    @Qualifier("createClient")
    private SyncClient client;
    private final String TABLENAME = "userInstalledApp";
    private final String COLUMNNAME = "details";
    //日志
    private static final Logger logger = LoggerFactory.getLogger("log.tableStore.TableUserInstalledAppDaoImpl");

    @Override
    public void insert(Long userId, String imei, String imsi, List<TableUserInstalledApp> userInstalledAppList) {
        logger.debug("进入tableStore(core1)添加方法add");
        if (CollectionUtils.isEmpty(userInstalledAppList) || imei == null || userId == null) {
            logger.warn("进入tableStore(core1)添加方法add参数存在空值,直接返回");
            return;
        }
        logger.debug("tableStore(core1)添加方法add调用查询query方法");
        List<TableUserInstalledApp> tableSmsDetailsList = query(userId, imei, imsi, userInstalledAppList);
        if (CollectionUtils.isNotEmpty(tableSmsDetailsList)) {
            long startTime = System.currentTimeMillis();
            List<TableUserInstalledApp> list = compare(userId, imei, tableSmsDetailsList, userInstalledAppList);
            logger.info("tableStore(core1)添加方法add调用更新方法updateRow,查询tableSmsDetailsList={},传参solrSmsDetailses={}," +
                    "去重list={}", tableSmsDetailsList.size(), userInstalledAppList.size(), list.size());
            updateRow(userId, imei, imsi, list);

            long endTime = System.currentTimeMillis();
            float excTime = (float) (endTime - startTime) / 1000;
            logger.info("tableStore(core1)添加方法add调用更新方法updateRow方法执行成功!,excTime={}", excTime, getUserIdAndPhone
                    (userId, imei, list));
        } else {
            long startTime = System.currentTimeMillis();
            logger.debug("tableStore(core1)添加方法add调用新增方法putRow,solrSmsDetailses={}", userInstalledAppList.size());
            List<TableUserInstalledApp> list = compare(userId, imei, userInstalledAppList);
            long endTime = System.currentTimeMillis();
            float excTime = (float) (endTime - startTime) / 1000;
            putRow(userId, imei, imsi, list);
            logger.info("tableStore(core1)添加方法add调用新增方法putRow执行成功!excTime={}", excTime, getUserIdAndPhone(userId,
                    imei, userInstalledAppList));
        }
    }

    @Override
    public void putRow(Long userId, String imei, String imsi, List<TableUserInstalledApp> userInstalledAppList) {
        logger.debug("进入tableStore(TableUserInstalledApp)新增方法putRow");
        BatchWriteRowRequest batchWriteRowRequest = new BatchWriteRowRequest();
        Gson gson = new Gson();
        // Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        try {
            RowPutChange rowPutChange = new RowPutChange(TABLENAME, createPrimaryKey(userId, imei, imsi,
                    userInstalledAppList));
            rowPutChange.addColumn(new Column(COLUMNNAME, ColumnValue.fromString(gson.toJson(userInstalledAppList))));
            batchWriteRowRequest.addRowChange(rowPutChange);
            logger.debug("开始执行tableStore(TableUserInstalledApp)新增方法putRow", getUserIdAndPhone(userId, imei,
                    userInstalledAppList));
            client.batchWriteRow(batchWriteRowRequest);
            logger.info("tableStore(TableUserInstalledApp)新增方法putRow成功写入", getUserIdAndPhone(userId, imei,
                    userInstalledAppList));
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn("tableStore(TableUserInstalledApp)新增方法putRow写入失败", getUserIdAndPhone(userId, imei,
                    userInstalledAppList));
        }
    }

    @Override
    public void updateRow(Long userId, String imei, String imsi, List<TableUserInstalledApp> userInstalledAppList) {
        logger.debug("进入tableStore(TableUserInstalledApp)更新通用方法updateRow");
        // 构造主键
        PrimaryKey primaryKey = createPrimaryKey(userId, imei, imsi, userInstalledAppList);
        Gson gson = new Gson();
        // Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        try {
            RowUpdateChange rowUpdateChange = new RowUpdateChange(TABLENAME, primaryKey);
            // 删除该列
            // rowUpdateChange.deleteColumns(COLUMNNAME);
            rowUpdateChange.put(COLUMNNAME, ColumnValue.fromString(gson.toJson(userInstalledAppList)));
            logger.debug("开始执行tableStore(TableUserInstalledApp)更新通用方法updateRow");
            client.updateRow(new UpdateRowRequest(rowUpdateChange));
            logger.debug("tableStore(TableUserInstalledApp)更新通用方法updateRow调用成功", getUserIdAndPhone(userId, imei,
                    userInstalledAppList));
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(getUserIdAndPhone(userId, imei, userInstalledAppList), "tableStore(TableUserInstalledApp)" +
                    "更新通用方法updateRow调用失败" + e);
        }

    }

    @Override
    public List<TableUserInstalledApp> query(Long userId, String imei) {
        if (userId == null || imei == null || "".equals(imei)) {
            logger.warn("表格存储(TableUserInstalledApp)查询ListQuery入参存在空值,不予查询");
            return null;
        }
        long startTime = System.currentTimeMillis();
        String md5UserId = MD5Utils.md5Hex(userId + "");
        List<TableUserInstalledApp> resultList = new ArrayList<>();
        PrimaryKey primaryKey = createPrimaryKey(userId, imei);
        // 读取短信表 该用户-电话对应的该行数据
        SingleRowQueryCriteria criteria = new SingleRowQueryCriteria(TABLENAME, primaryKey);
        // 设置读取最新版本
        criteria.setMaxVersions(1);
        Row row;
        try {
            // 根据条件建立请求
            GetRowRequest getRowRequest = new GetRowRequest(criteria);
            // 返回请求数据
            GetRowResponse getRowResponse = client.getRow(getRowRequest);
            row = getRowResponse.getRow();
            logger.info("tableStore(TableUserInstalledApp)查询方法query成功返回row userId={},imei={},md5UserId={}", userId,
                    imei, md5UserId);
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn("tableStore(TableUserInstalledApp)query,userId={},imei={},md5UserId={} 查询异常", userId, imei,
                    md5UserId);
            return null;
        }
        // 获取 details列详细信息
        if (row != null) {
            List<Column> detailsList = row.getColumn(COLUMNNAME);
            // 实际情况应该是detailsList长度为1的List
            for (Column column : detailsList) {
                Gson gson = new Gson();
                // Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
                // 将查询结果转化为List<TableUserInstalledApp>
                List<TableUserInstalledApp> columnList = gson.fromJson(column.getValue().toString(), new
                        TypeToken<List<TableUserInstalledApp>>() {}.getType());
                resultList.addAll(columnList);
            }
        }
        long endTime = System.currentTimeMillis();
        float excTime = (float) (endTime - startTime) / 1000;
        logger.info("tableStore(UserInstalledApp)查询方法query填装List成功,resultList={}是否为空,query方法体执行时间excTime:{}," +
                "userId={},imei={},md5UserId={}", CollectionUtils.isEmpty(resultList), excTime, userId, imei,
                md5UserId);
        return resultList;
    }

    //查询 表格存储
    private List<TableUserInstalledApp> query(Long userId, String imei, String imsi,
            List<TableUserInstalledApp> userInstalledAppList) {
        logger.debug("进入tableStore(TableUserInstalledApp)查询List方法query");
        long startTime = System.currentTimeMillis();
        if (CollectionUtils.isEmpty(userInstalledAppList) || imei == null || userId == null) {
            logger.warn("表格存储(TableUserInstalledApp)查询ListQuery入参存在空值,不予查询");
            return null;
        }
        List<TableUserInstalledApp> resultList = new ArrayList<>();
        PrimaryKey primaryKey = createPrimaryKey(userId, imei, imsi, userInstalledAppList);
        // 读取短信表 该用户-电话对应的该行数据
        SingleRowQueryCriteria criteria = new SingleRowQueryCriteria(TABLENAME, primaryKey);
        // 设置读取最新版本
        criteria.setMaxVersions(1);
        Row row;
        try {
            // 根据条件建立请求
            GetRowRequest getRowRequest = new GetRowRequest(criteria);
            // 返回请求数据
            GetRowResponse getRowResponse = client.getRow(getRowRequest);
            row = getRowResponse.getRow();
            logger.info("tableStore(TableUserInstalledApp)查询方法query成功返回row", getUserIdAndPhone(userId, imei,
                    userInstalledAppList));
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn(getUserIdAndPhone(userId, imei, userInstalledAppList), "tableStore(TableUserInstalledApp)" +
                    "查询异常:" + e);
            return null;
        }
        // 获取 details列详细信息
        if (row != null) {
            List<Column> detailsList = row.getColumn(COLUMNNAME);
            // 实际情况应该是detailsList长度为1的List
            for (Column column : detailsList) {
                Gson gson = new Gson();
                // Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
                // 将查询结果转化为List<TableUserInstalledApp>
                List<TableUserInstalledApp> columnList = gson.fromJson(column.getValue().toString(), new
                        TypeToken<List<TableUserInstalledApp>>() {}.getType());
                resultList.addAll(columnList);
            }
        }
        long endTime = System.currentTimeMillis();
        float excTime = (float) (endTime - startTime) / 1000;
        logger.info("tableStore(UserInstalledApp)查询方法query填装List成功,resultList={}是否为空,query方法体执行时间excTime:",
                CollectionUtils.isEmpty(resultList), excTime, getUserIdAndPhone(userId, imei, userInstalledAppList));
        return resultList;
    }

    //创建主键

    private PrimaryKey createPrimaryKey(Long userIds, String imei, String imsi,
            List<TableUserInstalledApp> userInstalledAppList) {
        logger.debug("进入tableStore(TableUserInstalledApp)生成构造主键通用方法createPrimaryKey");
        // 首先对入参进行判断 若为空直接返回 不再查询
        if (CollectionUtils.isEmpty(userInstalledAppList) || userIds == null || imei == null) {
            logger.warn("表格存储(TableUserInstalledApp)createPrimaryKey入参存在空值,不予查询");
            return null;
        }
        // 获取入参 phone user_id 构造查询主键使用
        String userId = MD5Utils.md5Hex(userIds + "");
        // 构造主键
        PrimaryKeyBuilder primaryKeyBuilder = PrimaryKeyBuilder.createPrimaryKeyBuilder();
        primaryKeyBuilder.addPrimaryKeyColumn("userId", PrimaryKeyValue.fromString(userId));
        primaryKeyBuilder.addPrimaryKeyColumn("imei", PrimaryKeyValue.fromString(imei));
        logger.info("tableStore(TableUserInstalledApp)生成构造主键通用方法createPrimaryKey：phone={},userId={},哈希之前userIds={}",
                imei, userId, userIds);
        return primaryKeyBuilder.build();
    }

    //创建主键

    private PrimaryKey createPrimaryKey(Long userIds, String imei) {
        logger.debug("进入tableStore(TableUserInstalledApp)生成构造主键通用方法createPrimaryKey");
        // 首先对入参进行判断 若为空直接返回 不再查询
        if (userIds == null || imei == null || "".equals(imei)) {
            logger.warn("表格存储(TableUserInstalledApp)createPrimaryKey入参存在空值,不予查询");
            return null;
        }
        // 获取入参 phone user_id 构造查询主键使用
        String userId = MD5Utils.md5Hex(userIds + "");
        // 构造主键
        PrimaryKeyBuilder primaryKeyBuilder = PrimaryKeyBuilder.createPrimaryKeyBuilder();
        primaryKeyBuilder.addPrimaryKeyColumn("userId", PrimaryKeyValue.fromString(userId));
        primaryKeyBuilder.addPrimaryKeyColumn("imei", PrimaryKeyValue.fromString(imei));
        logger.info("tableStore(TableUserInstalledApp)生成构造主键通用方法createPrimaryKey：phone={},userId={},哈希之前userIds={}",
                imei, userId, userIds);
        return primaryKeyBuilder.build();
    }

    /**
     * 将List2,list1比较去重
     */
    private List<TableUserInstalledApp> compare(Long userId, String imei, List<TableUserInstalledApp> listOne,
            List<TableUserInstalledApp> listTwo) {
        logger.debug("tableStore(UserInstalledApp)添加方法add调用更新方法compare1");
        for (TableUserInstalledApp aListTwo : listTwo) {
            if (listOne.contains(aListTwo)) {
                logger.info("当前表格存储已经存在userId={},imei={},pkgName={}", userId, imei, aListTwo.getPkgName(), ",本次不再存储");
            } else {
                //如果不存在，则将当前实体类添加到list集合中
                listOne.add(aListTwo);
            }
        }

        return listOne;
    }

    /**
     * 对传入数据去重
     */
    private List<TableUserInstalledApp> compare(Long userId, String imei, List<TableUserInstalledApp> listOne) {
        logger.debug("tableStore(UserInstalledApp)添加方法add调用更新方法compare2");
        List<TableUserInstalledApp> tableUserInstalledAppList = new ArrayList<>();
        for (int i = 0; i < listOne.size(); i++) {
            if (i == 0) {
                tableUserInstalledAppList.add(listOne.get(i));
            } else if (tableUserInstalledAppList.contains(listOne.get(i))) {
                logger.warn("当前表格存储已经存在userId={},imei={},pkgName={}", userId, imei, listOne.get(i).getPkgName(), ","
                        + "本次不再存储");
            } else {
                tableUserInstalledAppList.add(listOne.get(i));
            }
        }
        return tableUserInstalledAppList;
    }

    //打印日志用
    private String getUserIdAndPhone(Long userId, String imei, List<TableUserInstalledApp> list) {
        if (CollectionUtils.isEmpty(list)) {
            logger.warn("getUserIdAndPhone方法入参List为空");
            return "getUserIdAndPhone方法入参List为空,请注意！！";
        }
        String Md5UserId = MD5Utils.md5Hex(userId + "");
        return " 用户ID= " + userId + " MD5之后userId= " + Md5UserId + " imei " + imei;
    }
}
