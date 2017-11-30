package com.mimidai.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhangyu on 2017/6/29.
 */
@Repository
public interface UserPhoneDao {
     List<String> queryUserPhone();
}
