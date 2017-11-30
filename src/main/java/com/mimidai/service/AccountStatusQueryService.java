package com.mimidai.service;
/**
 * This file created by mengqingyi on 2017-11-13.
 */

import com.alicloud.openservices.tablestore.SyncClient;
import com.alicloud.openservices.tablestore.model.*;
import com.mimidai.utils.MD5Utils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * 类文件注释(Class file)
 *
 * @author mengqingyi
 * @classDescription 数据魔盒手机信息手机号状态信息查询
 * @create 2017-11-13 11:59
 **/
@Service
public class AccountStatusQueryService {
    @Autowired
    @Qualifier("createClient")
    private SyncClient client;
    /**
     * 表结构如下 表名:SjmhReportResultData 表中共有12列
     */
    private final String TABLENAME = "SjmhReportResultDatas";
    private final String COLUMNNAME = "sjmh_report_result_hot";

    /**
     * 构造主键
     *
     * @param userId 用户ID
     * @param phone  注意：电话为该用户申请运营商认证的电话(user_phone_check)
     */
    private PrimaryKey createPrimaryKey(Long userId, String phone) {
        // 首先对入参进行判断 若为空直接返回 不再查询
        if (userId == null || phone == null) {
            return null;
        }
        // userId 散裂化
        String md5UserId = MD5Utils.md5Hex(userId + "");
        // 构造主键
        PrimaryKeyBuilder primaryKeyBuilder = PrimaryKeyBuilder.createPrimaryKeyBuilder();
        primaryKeyBuilder.addPrimaryKeyColumn("userId", PrimaryKeyValue.fromString(md5UserId));
        primaryKeyBuilder.addPrimaryKeyColumn("phone", PrimaryKeyValue.fromString(phone));
        return primaryKeyBuilder.build();
    }

    public String getAccountStatus(Long userId, String phone) {
        if (userId == null || StringUtils.isBlank(phone)) {
            return null;
        }
        PrimaryKey primaryKey = createPrimaryKey(userId, phone);
        // 读取短信表 该用户-电话对应的该行数据
        SingleRowQueryCriteria criteria = new SingleRowQueryCriteria(TABLENAME, primaryKey);
        // 设置读取最新版本 选择 需要 读取的版本数
        criteria.setMaxVersions(1);
        String result = "未查询到";
        try {
            // 根据条件建立请求
            GetRowRequest getRowRequest = new GetRowRequest(criteria);
            // 返回请求数据
            GetRowResponse getRowResponse = client.getRow(getRowRequest);
            Row row = getRowResponse.getRow();
            if (row != null) {
                // String rowResult = row.getColumn(COLUMNNAME).get(0).getValue().asString();
                // String s = rowResult.split("\"account_status\":")[1];
                // result = s.substring(0, s.indexOf(",")).replace("\"", "");
                result = row.getColumn(COLUMNNAME).get(0).getValue().asString();
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }
    }
}
