package com.mimidai.service;

import com.mimidai.dao.UserIdAndPhoneDao;
import com.mimidai.entity.UserIdAndPhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 苦苦奋斗的渣渣 on 2017/5/18.
 */
@Service
public class UserIdAndPhoneService {

    @Autowired
    private UserIdAndPhoneDao userIdAndPhoneDao;

    public List<UserIdAndPhone> query() {
      return   userIdAndPhoneDao.query();
    }
}

