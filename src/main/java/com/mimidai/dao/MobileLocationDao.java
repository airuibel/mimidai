package com.mimidai.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by zhangyu on 2017/6/30.
 */
@Repository
public interface MobileLocationDao {
     String query(String phone);
}
