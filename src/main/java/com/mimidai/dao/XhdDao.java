package com.mimidai.dao;

import com.mimidai.entity.UserInfo;
import com.mimidai.entity.XhdUseInfo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangyu on 2017/7/18.
 */
@Component
public interface XhdDao {

    List<XhdUseInfo> query();

    List<UserInfo> queryUser();

    List<Map<String, String>> findSensitive();
 }
