package com.mimidai.service;

import com.mimidai.dao.UserPhoneDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangyu on 2017/6/29.
 */
@Service
public class UserPhoneService {

    @Autowired
    private UserPhoneDao userPhoneDao;

    public List<String> queryPhone(){
        return userPhoneDao.queryUserPhone();
    }
}
