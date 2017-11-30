package com.mimidai.dao;

import com.mimidai.entity.UserJob;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@SuppressWarnings("rawtypes")
public interface UserJobDao {


    UserJob getByUserId(Long userId);

    List<UserJob> findOtherJobIds(@Param("userId") Long userId, @Param("phone") String phone);

    List<Map> findAllSameJobByIds(@Param("userIds") String userIds);

}
