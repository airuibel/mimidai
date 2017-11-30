//package com.mimidai;
//
//import com.alicloud.openservices.tablestore.ClientConfiguration;
//import com.alicloud.openservices.tablestore.SyncClient;
//import com.alicloud.openservices.tablestore.model.*;
//import com.google.common.collect.Lists;
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
//import com.mimidai.entity.TableCallDetails;
//import com.mimidai.entity.TableCallDetails2;
//import com.mimidai.entity.UserIdAndPhone;
//import com.mimidai.service.UserIdAndPhoneService;
//import com.mimidai.utils.MD5Utils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.stereotype.Component;
//import org.springframework.util.CollectionUtils;
//
//import java.util.List;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
////@SpringBootApplication
//@Component
//public class TableStoreUtils implements InitializingBean {
//
//    private static final Logger logger = LoggerFactory.getLogger("log.tableStore.TableStoreUtils");
//    @Autowired
//    private UserIdAndPhoneService userIdAndPhoneService;
//
//    private static SyncClient client;
//    private static String endPoint = "http://192.168.3.17:80/";
//    private static String accessId = "LTAIpWvk9Q74F7lw";
//    private static String accessKey = "n7KTus6rgJSxQga6MxWuKANKfrdGUx";
//    private static String instanceName = "mimidai-archival";//contacts
//
//    //  测试 环境 start
////    private static SyncClient client;
////    private static String endPoint = "http://mimidai-test.cn-beijing.ots.aliyuncs.com";
////    private static String accessId = "LTAIpWvk9Q74F7lw";
////    private static String accessKey = "n7KTus6rgJSxQga6MxWuKANKfrdGUx";
////    private static String instanceName = "mimidai-test";
//
//    static {
//        // ClientConfiguration提供了很多配置项，以下只列举部分。
//        ClientConfiguration clientConfiguration = new ClientConfiguration();
//        // 设置建立连接的超时时间。
//        clientConfiguration.setConnectionTimeoutInMillisecond(5000);
//        // 设置socket超时时间。
//        clientConfiguration.setSocketTimeoutInMillisecond(5000);
//        // 设置重试策略，若不设置，采用默认的重试策略。
//        clientConfiguration.setRetryStrategy(new AlwaysRetryStrategy());
//        client = new SyncClient(endPoint, accessId, accessKey, instanceName, clientConfiguration);
//    }
//
//    //
////    //zhangyude
//    private String tableName = "callDetails";
//    private String column = "details";
//    private ExecutorService executorService = Executors.newFixedThreadPool(10);
//
//
//    /**
//     * @param @param  client
//     * @param @param  phone
//     * @param @param  userId
//     * @param @return 设定文件
//     * @return List<SolrExtraInfo>    返回类型
//     * @throws
//     * @Title: getRow
//     * @Description: TODO(查询)
//     */
//
//
//    public static void main(String[] args) {
//        SpringApplication.run(TableStoreUtils.class, args);
//    }
///*    //callDetailsToTable
//
//
//
//    //更新表格数据
//    /*public void updateRow(List<TableCallDetails> contactsList) {
//        // 构造主键
//        long startTime = System.currentTimeMillis();
//        RowUpdateChange rowUpdateChange = new RowUpdateChange(tableName, pk1Builder(contactsList));
//        logger.info("[主键构建成功],phone:{},userId{}", contactsList.get(0).getPhone() +
//                "," + contactsList.get(0).getUserId());
//        Gson gson = new Gson();
//        Column columns = null;
//        try {
//            columns = new Column("details", ColumnValue.fromString(gson.toJson(contactsList)));//gson.fromJson(gson.toJson(contactsList),  new TypeToken<List<SolrCallDetails>>(){}.getType())
//            logger.info("【表格列创建成功】", columns.getName());
//        } catch (Exception e) {
//            logger.info("【表格列创建失败】", e);
//        }
//        try {
//
//            rowUpdateChange.deleteColumns(column);
//            long endTime = System.currentTimeMillis();
//            long time = endTime - startTime;
//            logger.info("【删除数据列成功,用户id为{},手机号为{}：】"
//                    + contactsList.get(0).getUserId() + "," + contactsList.get(0).getPhone()
//                    + "删除耗时：" + time);
//        } catch (Exception e) {
//            logger.info("【删除数据列失败,用户id为{},手机号为{}：】" +
//                    contactsList.get(0).getUserId() + "," + contactsList.get(0).getPhone());
//        }
//        rowUpdateChange.put(columns);
//        try {
//            client.updateRow(new UpdateRowRequest(rowUpdateChange));
//            long endTime = System.currentTimeMillis();
//            long time = endTime - startTime;
//            logger.info("【更新数据列成功,用户id为{},手机号为{}：】"
//                    + contactsList.get(0).getUserId() + "," + contactsList.get(0).getPhone()
//                    + "更新耗时：" + time);
//        } catch (Exception e) {
//            logger.info("【更新数据列失败,用户id为{},手机号为{}：】"
//                    + contactsList.get(0).getUserId() + "," + contactsList.get(0).getPhone()
//            );
//        }
//    }*/
//
//    //查询表单数据
//    public void getDateRow(UserIdAndPhone userIdAndPhone) {
//        Gson gson = new Gson();
//        String phone = userIdAndPhone.getPhone();
//        long userId = userIdAndPhone.getUserId();
//        logger.info("用户的Id为：" + userId + "用户的phone为:" + phone);
//        PrimaryKey primaryKey = pk1Builder(userId, phone);
//        SingleRowQueryCriteria criteria = new SingleRowQueryCriteria(tableName, primaryKey);
//        criteria.addColumnsToGet("details");
//        // 设置读取最新版本
//        criteria.setMaxVersions(1);
//        GetRowResponse getRowResponse = null;
//        try {
//            getRowResponse = client.getRow(new GetRowRequest(criteria));
//
//        } catch (Exception e) {
//            logger.error("【查询表格数据失败,userId{},phone{}】:");
//        }
//        if (getRowResponse != null) {
//            Row row = getRowResponse.getRow();
//            if (row != null) {
//                List<Column> details = row.getColumn("details");
//                logger.info("【查询表格数据成功,userId{},phone{}】:");
//                String json = details.get(0).getValue().toString();
//                List<TableCallDetails> list = gson.fromJson(json, new TypeToken<List<TableCallDetails>>() {
//                }.getType());
//                List<TableCallDetails2> convertList = Lists.newArrayList();
//                for (TableCallDetails tableCallDetails : list) {
//                    if (tableCallDetails.getUserId().length() > 7) {
//                        TableCallDetails2 tableCallDetails2 = new TableCallDetails2();
//                        tableCallDetails2.setUserId(userId);
//                        tableCallDetails2.setCallLocation(tableCallDetails.getCallLocation());
//                        tableCallDetails2.setCallType(tableCallDetails.getCallType());
//                        tableCallDetails2.setDuration(tableCallDetails.getDuration());
//                        tableCallDetails2.setFee(tableCallDetails.getFee());
//                        tableCallDetails2.setOtherPhone(tableCallDetails.getOtherPhone());
//                        tableCallDetails2.setPhone(tableCallDetails.getPhone());
//                        tableCallDetails2.setStartTime(tableCallDetails.getStartTime());
//                        logger.info("转化的用户userId:" + tableCallDetails2.getUserId());
//                        logger.info("转化的用户phone:" + tableCallDetails.getPhone());
//                        logger.info("转化后的hash-userId:" + tableCallDetails.getUserId());
//                        convertList.add(tableCallDetails2);
//                    }
//                }
//                callDetailsToTable(convertList);
//            }
//        }
//    }
//
//
//    //生成主键
//    public PrimaryKey pk1Builder(Long userId, String phone) {
//        PrimaryKeyBuilder pk1Builder = PrimaryKeyBuilder.createPrimaryKeyBuilder();
//        if (userId != null && phone != null && phone.length() > 0) {
//            pk1Builder.addPrimaryKeyColumn("userId", PrimaryKeyValue.fromString(MD5Utils.md5Hex(userId + "")));
//            pk1Builder.addPrimaryKeyColumn("phone", PrimaryKeyValue.fromString(phone));
//            return pk1Builder.build();
//
//        }
//        return null;
//
//    }
//
//    public void callDetailsToTable(List<TableCallDetails2> tableList) {
//        BatchWriteRowRequest batchWriteRowRequest = new BatchWriteRowRequest();
//        BatchWriteRowResponse response = null;
//        if (tableList != null && tableList.size() > 0) {
//            Long userId = tableList.get(0).getUserId();
//            String phone = tableList.get(0).getPhone();
//            RowPutChange rowPutChange = new RowPutChange(tableName, pk1Builder(userId, phone));
//            Gson gson = new Gson();
//            rowPutChange.addColumn(
//                    new Column(column, ColumnValue.fromString(gson.toJson(tableList))));
//            batchWriteRowRequest.addRowChange(rowPutChange);
//            response = client.batchWriteRow(batchWriteRowRequest);
//            logger.info("表格数据更新成功userId:" + userId + ",phone:" + phone);
//        }
//
//
//    }
//
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        List<UserIdAndPhone> userIdAndPhoneList = userIdAndPhoneService.query();
//        logger.info("user_phone_check共有用户数：" + userIdAndPhoneList.size());
//        for (UserIdAndPhone userIdAndPhone : userIdAndPhoneList) {
////            executorService.execute(new Runnable() {
////                @Override
////                public void run() {
//                    getDateRow(userIdAndPhone);
////                }
////            });
//
//        }
//    }
//}
//
