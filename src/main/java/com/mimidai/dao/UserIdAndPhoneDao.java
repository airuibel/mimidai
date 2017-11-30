package com.mimidai.dao;

import com.mimidai.entity.UserIdAndPhone;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhangyu on 2017/6/30.
 */
@Repository
public interface UserIdAndPhoneDao {
     List<UserIdAndPhone> query();
}
