package com.postbox.service;

import com.postbox.mapper.RepairStepMapperExt;
import com.postbox.model.RepairStep;
import com.postbox.model.RepairStepExample;
import org.hanzhdy.manager.support.service.AbstractUpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by H.CAAHN on 2017/8/3.
 */
@Service
public class RepairStepService extends AbstractUpcService {
    @Autowired
    private RepairStepMapperExt repairStepMapperExt;
    
    /**
     * 根据报修记录ID查询报修的处理步骤信息
     * @param repairRecordId
     * @return
     */
    public List<RepairStep> queryByRepairRecordId(Long repairRecordId) {
        RepairStepExample example = new RepairStepExample();
        example.createCriteria().andRepairRecordIdEqualTo(repairRecordId);
        return this.repairStepMapperExt.selectByExample(example);
    }
    
    /**
     * 插入报修处理步骤
     * @param record
     * @return
     */
    public boolean insert(RepairStep record) {
        record.setOptime(new Date());
        int count = this.repairStepMapperExt.insert(record);
        return count > 0;
    }
}
