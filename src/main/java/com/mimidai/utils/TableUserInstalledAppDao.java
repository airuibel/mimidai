package com.mimidai.utils;


import com.mimidai.entity.TableUserInstalledApp;

import java.util.List;

/**
 * UserInstalledApp 用户安装APP由 mysql 全量传递增量装入tablestore Created by 孟庆艺 on 2017-07-12.
 */
//后端传入List<UserInstalledApp>
public interface TableUserInstalledAppDao {
    //自带判断 新增全量还是增量插入
    void insert(Long userId, String imei, String imsi, List<TableUserInstalledApp> tableUserInstalledAppList);

    //全量新增插入
    void putRow(Long userId, String imei, String imsi, List<TableUserInstalledApp> tableUserInstalledAppList);

    //增量插入
    void updateRow(Long userId, String imei, String imsi, List<TableUserInstalledApp> tableUserInstalledAppList);

    //查询
    List<TableUserInstalledApp> query(Long userId, String imei);
}
