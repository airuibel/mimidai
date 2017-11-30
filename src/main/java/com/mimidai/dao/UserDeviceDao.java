package com.mimidai.dao;

import com.mimidai.entity.UserDevice;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 用户使用设备信息
 * 
 * @author liang
 *
 */

@SuppressWarnings("rawtypes")
@Repository
public interface UserDeviceDao {

	/**
	 * 根据 用户id 手机唯一码 和 sim卡唯一码 查询数据
	 * 
	 * @param userId
	 * @param imei
	 * @param imsi
	 * @return
	 */
	UserDevice findByUserIdAndImeiAndImsi(@Param("userId") Long userId, @Param("imei") String imei, @Param("imsi") String imsi);

	/**
	 * 添加一条用户设备信息
	 * 
	 * @param userDevice
	 */
	void insert(UserDevice userDevice);

	/**
	 * 更新一条用户设备信息
	 * 
	 * @param userDevice
	 */
	void update(UserDevice userDevice);

	
	List<Map> findAllByUserId(@Param("userId") Long userId);
	
	List<Map> findAllByUserId2(@Param("userId") Long userId);
	
	List<Map> findAllSameDeviceByUserId(@Param("userId") Long userId);
	
	List<Map> findAllSameDeviceByUserIds(@Param("userIds") String userIds);
	/**
	 * 用户使用过多少张sim卡 合计
	 * @param userId
	 * @return
	 */
	Integer findCountSimByUserId(@Param("userId") Long userId);
	
	/**
	 * 用户使用过的设备数量
	 * @param userId
	 * @return
	 */
	Integer findCountDeviceByUserId(@Param("userId") Long userId);
	
	/**
	 * 查询一个设备用过的sim卡储量
	 * @param imei
	 * @return
	 */
	Integer findCountSimByImei(@Param("imei") String imei);
	

	/**
	 * 根据用户id 查询实用的最新设备
	 * @param userId
	 * @return
	 */
	UserDevice findNewByUserId(@Param("userId")Long userId);
	
	/**
	 * 根据用户id查询最初的2个设备
	 * @param userId
	 * @return
	 */
	List<UserDevice> findTwoOldByUserId(@Param("userId")Long userId);
	
	Integer findSumLoginCountByUserIdAndImei(@Param("userId")Long userId,@Param("imei")String imei);
	
	Integer findSumLoginCountByUserId(@Param("userId")Long userId);

	List<UserDevice> findByUserIdAndImei(@Param("userId") Long userId, @Param("imei") String imei);

	void updateContactUpload(@Param("userId") Long userId, @Param("imei") String imei, @Param("state") String state);
	
	/**
	 * 根据userId ，Imeis查询其他用户的id
	 * @param userId
	 * @param imeis
	 * @return
	 */
	List<UserDevice> findAllUserIdByUserIdAndImeis(@Param("userId")Long userId,@Param("imeis")String imeis);
	/**
	 * 根据用户id 查询imei集合
	 * @param userId
	 * @return
	 */
	List<UserDevice> findAllImeisByUserId(@Param("userId")Long userId);
	/**
	 * 查询全部
	 * @param userDevice
	 * @return
	 */
	List<UserDevice> findAll(UserDevice userDevice);

    UserDevice findLastestLoginByUserId(@Param("userId")Long userId);
	
	Integer findCountByUserId(@Param("userId")Long userId);
}
