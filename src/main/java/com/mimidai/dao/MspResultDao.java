package com.mimidai.dao;

import com.mimidai.entity.MspApplyDetails;
import com.mimidai.entity.MspQuery;
import com.mimidai.entity.MspResult;
import com.mimidai.entity.MspTitle;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MspResultDao {

    MspResult findByQueryId(Long queryId);

    MspQuery findNewByUserIdAndType(@Param("userId") Long userId, @Param("type") String type);

    MspTitle findAll(MspTitle mspTitle);

    List<MspApplyDetails> findDetails(Integer resultId);
}

