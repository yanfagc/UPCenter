package com.postbox.service;

import com.postbox.controller.params.RepairRecordParams;
import com.postbox.enums.RepairStatus;
import com.postbox.mapper.RepairRecordMapperExt;
import com.postbox.model.RepairRecord;
import com.postbox.model.RepairStep;
import org.apache.commons.lang3.StringUtils;
import org.hanzhdy.manager.support.service.AbstractUpcService;
import org.hanzhdy.web.bean.DatatableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by H.CAAHN on 2017/8/3.
 */
@Service
public class RepairRecordService extends AbstractUpcService {
    @Autowired
    private RepairRecordMapperExt repairRecordMapperExt;
    
    @Autowired
    private RepairStepService     repairStepService;
    
    /**
     * 根据条件查询保修信息，并返回符合jquery.datatable数据格式要求的对象
     * @param params
     * @return
     */
    public DatatableResult queryAsDatatableResult(RepairRecordParams params) {
        Map<String, Object> search = new HashMap<>();
        search.put("page", params.createPage());
        if (StringUtils.isNotBlank(params.getBoxUniqueCode())) {
            search.put("boxUniqueCode", params.getBoxUniqueCode());
        }
        if (StringUtils.isNotBlank(params.getCountry())) {
            search.put("country", params.getCountry());
        }
        if (StringUtils.isNotBlank(params.getProvince())) {
            search.put("province", params.getProvince());
        }
        if (StringUtils.isNotBlank(params.getCity())) {
            search.put("city", params.getCity());
        }
        if (params.getStatus() != null) {
            search.put("status", params.getStatus());
        }
        if (params.getStatusArray() != null && params.getStatusArray().length > 0) {
            if (params.getStatusArray().length == 0) {
                search.put("status", params.getStatusArray()[0]);
            }
            else {
                search.put("statusArray", params.getStatusArray());
            }
        }
        if (params.getBeginApplytime() != null) {
            search.put("beginApplytime", params.getBeginApplytime());
        }
        if (params.getEndApplytime() != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            search.put("endApplytime", calendar.getTime());
        }
        
        DatatableResult result = new DatatableResult();
        return result;
    }
    
    public RepairRecord queryById(Long id) {
        return this.repairRecordMapperExt.selectByPrimaryKey(id);
    }
    
    public boolean updateStatus(RepairRecord record, String username, String nickname, String remark) {
        Date nowtime = new Date();
        
        // 维修步骤记录
        RepairStep step = new RepairStep();
        step.setOptime(nowtime);
        step.setOpstaffcode(username);
        step.setOpstaffname(nickname);
        if (StringUtils.isNotBlank(remark)) {
            step.setRemark(remark);
        }
    
        // 维修记录
        RepairRecord data = new RepairRecord();
        data.setRepairerInfoId(record.getRepairerInfoId());
        data.setStatus(record.getStatus());
        
        // 状态变更为待处理
        if (record.getStatus() == RepairStatus.PENDING) {
            if (remark == null) {
                step.setRemark("已审核");
            }
            data.setAudittime(nowtime);
        }
        // 状态变更为修理中
        else if (record.getStatus() == RepairStatus.REPAIRING) {
            if (remark == null) {
                step.setRemark("已确认");
            }
            data.setRepairtime(nowtime);
        }
        // 状态变更为修理完成
        else if (record.getStatus() == RepairStatus.COMPLETE) {
            if (remark == null) {
                step.setRemark("已完成");
            }
            data.setCompletetime(nowtime);
        }
        // 状态变更为取消
        else if (record.getStatus() == RepairStatus.CANCEL) {
            if (remark == null) {
                step.setRemark("已取消");
            }
            data.setCanceltime(nowtime);
        }
        
        // 插入维修步骤信息
        this.repairStepService.insert(step);
        
        // 更新状态
        int count = this.repairRecordMapperExt.updateByPrimaryKeySelective(data);
        return count > 0;
    }
}
