package com.mimidai.service;

import java.util.List;
import java.util.Map;

import com.mimidai.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mimidai.dao.UserInfoDao;

/**
 * Created by 苦苦奋斗的渣渣 on 2017/5/18.
 */
@Service
public class UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

//    public List<UserIdcard> queryUserInfo() {
//        return userInfoDao.queryUserInfo();
//    }
//
//    public TpTsp queryTpTspApplying(int resultId){
//        return userInfoDao.queryTpTspApplying(resultId);
//    }
//    public Integer queryTpBlack(Long userId){
//        return userInfoDao.queryTpBlack(userId);
//    }
//    public TpSquron queryTpSauron( Long userId){
//        return  userInfoDao.queryTpSauron(userId);
//    }
//
//    public Integer queryResultId(Long userId){
//        return userInfoDao.queryResultId(userId);
//    }
//    public TPTsm queryTp(int resultId){
//        return userInfoDao.queryTp(resultId);
//    }
//
//    public List<UserIdcard> queryUserId(){
//        return userInfoDao.queryUserId();
//    }
//    public List<TpSquron> findUserInfo(){
//        return userInfoDao.findUserInfo();
//    }
////    public UserInstalledAppCategory getAppTypeByUserId(Long userId){
////        return userInfoDao.getAppTypeByUserId(userId);
////    }
//
//    public List<UserIdcard> queryMobile(){
//        return userInfoDao.queryMobile();
//    }
//
//   public List<Map> findAllByPhones(@Param("phones")String phones){
//        return userInfoDao.findAllByPhones(phones);
//   }

//    public List<Map> findAllNearByUserIds(String userIds) {
//        return userInfoDao.findAllNearByUserIds(userIds);
//    }
}
