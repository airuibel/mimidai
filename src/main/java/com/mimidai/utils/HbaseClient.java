package com.mimidai.utils;

import com.mimidai.entity.ExtraDetailsSimple;
import com.mimidai.entity.PhoneContacts;
import com.mimidai.entity.PhoneTon;
import com.mimidai.entity.UserLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhangyu on 2017/8/17.
 */
@Repository
public class HbaseClient {

    @Autowired
    @Qualifier("phoenixJdbcTemplateForQuery")
    private JdbcTemplate jdbcTemplateForquery;

    private Logger logger = LoggerFactory.getLogger(HbaseClient.class);


    private List<PhoneContacts> queryHbasePhoneContacts(int userId) {
        String sql = " select userId,phone,otherPhone,firstCall,lastCall,inTimes,outTimes,inDuration,outDuration,inFee,outFee,allTimes,callLocation,commType from contacts where userId = " + userId;
        List<PhoneContacts> phoneContactsList = null;
        try {
            phoneContactsList = jdbcTemplateForquery.query(sql,
                    new BeanPropertyRowMapper<PhoneContacts>(PhoneContacts.class));
            logger.info("【hBaseQuery】执行查询运营商数据（完整数据）成功：" + phoneContactsList.size());
        } catch (Exception e) {
            logger.error("【hBaseQuery】执行查询（完整数据）失败，sql:" + sql + "，失败原因:" + e.toString());
        }
        return phoneContactsList;
    }

    private List<ExtraDetailsSimple> queryHbaseExtraDetailsSimple(int userId) {
        String sql = " select userId,phone,otherPhone,firstCall,lastCall,inTimes,outTimes,inDuration,outDuration,inFee,outFee,allTimes,callLocation,type,platform,commType from extralDetails where userId = " + userId;
        //缺少数据的hbase
        List<ExtraDetailsSimple> extraDetailsSimpleListPart = null;
        try {
            extraDetailsSimpleListPart = jdbcTemplateForquery.query(sql,
                    new BeanPropertyRowMapper<ExtraDetailsSimple>(ExtraDetailsSimple.class));
            logger.info("【hBaseQuery】执行查询敏感电话成功：" + extraDetailsSimpleListPart.size());
        } catch (Exception e) {
            logger.error("【hBaseQuery】执行查询（缺少数据的hbase）失败，sql:" + sql + "，失败原因:" + e.toString());
        }
        return extraDetailsSimpleListPart;
    }

        private List<PhoneTon> queryHbasePhoneTon(int userId) {
        String sql = " select userId,imei,imsi,phone,name,callTimes,lastCall from phoneContacts where userId = " + userId;
        //缺少数据的hbase
        List<PhoneTon> phoneTonListPart = null;
        try {
            phoneTonListPart = jdbcTemplateForquery.query(sql,
                    new BeanPropertyRowMapper<PhoneTon>(PhoneTon.class));
            logger.info("【hBaseQuery】执行查询通信录（缺少数据的hbase）成功：" + phoneTonListPart.size());
        } catch (Exception e) {
            logger.error("【hBaseQuery】执行查询（缺少数据的hbase）失败，sql:" + sql + "，失败原因:" + e.toString());
        }
        return phoneTonListPart;
    }

        private List<UserLocation> queryHbaseUserLocation(int userId) {
        String sql = " select userId,address,lng,lat,createTime from userlocation where userId = " + userId;
        //缺少数据的hbase
        List<UserLocation> userLocationListPart = null;
        try {
            userLocationListPart = jdbcTemplateForquery.query(sql,
                    new BeanPropertyRowMapper<UserLocation>(UserLocation.class));
            logger.info("【hBaseQuery】执行查询userLocation（数据缺失）成功：" + userLocationListPart.size());
        } catch (Exception e) {
            logger.error("【hBaseQuery】执行查询（缺少数据的hbase）失败，sql:" + sql + "，失败原因:" + e.toString());
        }
        return userLocationListPart;
    }
}
