package com.mimidai.service;

import com.mimidai.dao.MspResultDao;
import com.mimidai.entity.MspApplyDetails;
import com.mimidai.entity.MspQuery;
import com.mimidai.entity.MspResult;
import com.mimidai.entity.MspTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangyu on 2017/7/17.
 */
@Service
public class MspService {

    @Autowired
    private MspResultDao mspResultDao;
    public MspQuery findNewQueryByUserIdAndType(Long userId, String type) {
        return mspResultDao.findNewByUserIdAndType(userId, type);
    }
    public MspResult findResultByQueryId(Long queryId) {
        return mspResultDao.findByQueryId(queryId);
    }

    public MspTitle findTitleByResultId(Long resultId) {
        MspTitle mspTitle = new MspTitle();
        mspTitle.setResultId(resultId);
        return mspResultDao.findAll(mspTitle);
    }

    public List<MspApplyDetails> findDetails(Integer resultId){
        return  mspResultDao.findDetails(resultId);
    }

}
