package com.mimidai.service;

import com.mimidai.dao.UserDeviceDao;
import com.mimidai.entity.UserDevice;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * 类文件注释(Class file)
 *
 * @author focus
 * @classDescription 用过同一个手机设备
 * @create 2017-11-21 11:38
 **/
@Repository
public class UserDeviceService {

    @Autowired
    private UserDeviceDao userDeviceDao;

    public List<Map> findAllSameDeviceByUserId(Long userId) {
        //用户的设备
        UserDevice ud = new UserDevice();
        ud.setUserId(userId);
        List<UserDevice> myDevices = userDeviceDao.findAll(ud);
        List<UserDevice> otherDevices = new ArrayList<UserDevice>();
        for (UserDevice userDevice : myDevices) {
            if (StringUtils.isNotBlank(userDevice.getImei()) && !"null".equals(userDevice.getImei())) {
                userDevice.setUserId(null);
                otherDevices.addAll(userDeviceDao.findAll(userDevice));
            }

        }

        Set<Long> userIds = new HashSet<Long>();
        for (UserDevice userDevice : otherDevices) {
            if (0 != Long.compare(userId, userDevice.getUserId())) {
                userIds.add(userDevice.getUserId());
            }
        }
        if (userIds.size() > 0) {
            List<Map> resultMaps = new ArrayList<Map>();
            if (userIds.size() > 0) {
                resultMaps = userDeviceDao.findAllSameDeviceByUserIds(userIds.toString().replaceAll("\\[", "").replaceAll("]", ""));
            }
            if (userIds.size() > 100) {
            }
            return resultMaps;
        } else {
            return new ArrayList<Map>();
        }

    }

}
