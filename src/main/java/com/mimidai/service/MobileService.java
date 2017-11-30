package com.mimidai.service;

import com.mimidai.dao.MobileLocationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zhangyu on 2017/6/30.
 */
@Component
public class MobileService {
    @Autowired
    private MobileLocationDao mobileLocation;
    public String queryLocation(String phone){
        return mobileLocation.query(phone);
    }
}
