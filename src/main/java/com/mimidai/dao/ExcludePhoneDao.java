package com.mimidai.dao;

import com.mimidai.entity.ExcludePhone;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName:ExcludePhoneDao
 * @Dscrription:需要排除的电话号码数据库操作类
 * @author:	haidong
 * @date: 2016年3月28日 下午3:40:27 
 */
@Repository
public interface ExcludePhoneDao {
	/**
	 * 根据id获取一条需要排除的电话号码
	 * @param id
	 * @return
	 * @author:	haidong
	 * @date: 2016年3月28日 下午3:39:18 
	 */
	ExcludePhone findById(Long id);
	/**
	 * 查询所有需要排除的电话号码
	 * @return
	 * @author:	haidong
	 * @date: 2016年3月28日 下午3:39:44 
	 */
	List<String> findAll();
	/**
	 * 根据条件查询所有需要排除的电话号码
	 * @param excludePhone
	 * @return
	 * @author:	haidong
	 * @date: 2016年3月28日 下午3:40:00 
	 */
	List<ExcludePhone> findAllByCondition(Map<String, Object> condition);
	/**
	 * 保存一条需要排除的电话号码
	 * @param excludePhone
	 * @return
	 * @author:	haidong
	 * @date: 2016年3月28日 下午3:40:38
	 */
	int save(ExcludePhone excludePhone);
	/**
	 * 更新一条需要排除的电话号码
	 * @param excludePhone
	 * @return
	 * @author:	haidong
	 * @date: 2016年3月28日 下午3:40:49
	 */
	int update(ExcludePhone excludePhone);
	/**
	 * 删除一条需要排除的电话号码
	 * @param id
	 * @return
	 * @author:	haidong
	 * @date: 2016年3月28日 下午3:40:58
	 */
	int delete(@Param("id") Long id, @Param("updateTime") Date updateTime, @Param("managerId") Long managerId);
}
