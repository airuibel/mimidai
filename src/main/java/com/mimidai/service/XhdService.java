package com.mimidai.service;

import com.mimidai.dao.XhdDao;
import com.mimidai.entity.UserInfo;
import com.mimidai.entity.XhdUseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangyu on 2017/7/18.
 */
@Service
public class XhdService {

    @Autowired
    private XhdDao xhdDao;


    public List<XhdUseInfo> query(){
        return xhdDao.query();
    }
    public  List<UserInfo> queryUser(){
        return xhdDao.queryUser();
    }
}
