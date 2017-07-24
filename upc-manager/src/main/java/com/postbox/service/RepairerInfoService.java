package com.postbox.service;

import com.postbox.controller.params.RepairerInfoParams;
import com.postbox.enums.DataStatus;
import com.postbox.mapper.RepairerInfoMapperExt;
import com.postbox.model.RepairerInfo;
import com.postbox.model.RepairerInfoExample;
import org.apache.commons.lang3.StringUtils;
import org.hanzhdy.manager.support.service.AbstractUpcService;
import org.hanzhdy.web.bean.DatatableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by H.CAAHN on 2017/7/24.
 */
@Service
public class RepairerInfoService extends AbstractUpcService {
    @Autowired
    private RepairerInfoMapperExt repairerInfoMapperExt;
    
    public DatatableResult queryAsDatatableResult(RepairerInfoParams params) {
        RepairerInfoExample example = new RepairerInfoExample();
        RepairerInfoExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(params.getRealname())) {
            criteria.andRealnameLike("%" + params.getRealname() + "%");
        }
        if (StringUtils.isNotBlank(params.getMobilePhone())) {
            criteria.andMobilePhoneLike("%" + params.getMobilePhone() + "%");
        }
        if (params.getStatus() != null) {
            criteria.andStatusEqualTo(params.getStatus());
        }
        
        int total = this.repairerInfoMapperExt.countByExample(example);
        List<RepairerInfo> data = this.repairerInfoMapperExt.selectByExample(example);
        DatatableResult result = new DatatableResult();
        result.setTotal(total);
        result.setAaData(data);
        return result;
    }
    
    public RepairerInfo queryById(Long id) {
        return this.repairerInfoMapperExt.selectByPrimaryKey(id);
    }
    
    public boolean insert(RepairerInfo record) {
        record.setCreatetime(new Date());
        if (record.getStatus() == null) {
            record.setStatus(DataStatus.NORMAL);
        }
        int count = this.repairerInfoMapperExt.insertSelective(record);
        return count > 0;
    }
    
    public boolean update(RepairerInfo record) {
        int count = this.repairerInfoMapperExt.updateByPrimaryKeySelective(record);
        return count > 0;
    }
    
    public boolean updateStatus(RepairerInfo record) {
        RepairerInfo data = new RepairerInfo();
        data.setRepairerInfoid(record.getRepairerInfoid());
        data.setStatus(record.getStatus());
        int count = this.repairerInfoMapperExt.updateByPrimaryKeySelective(record);
        return count > 0;
    }
}
