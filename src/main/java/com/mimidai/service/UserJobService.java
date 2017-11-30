package com.mimidai.service;

import com.mimidai.dao.UserJobDao;
import com.mimidai.entity.UserJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@SuppressWarnings("rawtypes")
@Service
public class UserJobService {

    @Autowired
    private UserJobDao userJobDao;


    public UserJob getByUserId(Long userId) {
        return userJobDao.getByUserId(userId);
    }
    public List<UserJob> findOtherJobIds(Long userId, String phone) {
        return userJobDao.findOtherJobIds(userId, phone);
    }

    public List<Map> findAllSameJobByIds(String userIds) {
        return userJobDao.findAllSameJobByIds(userIds);
    }





}
