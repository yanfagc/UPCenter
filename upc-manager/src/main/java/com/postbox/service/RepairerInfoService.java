package com.postbox.service;

import com.postbox.controller.params.RepairerInfoParams;
import com.postbox.enums.DataStatus;
import com.postbox.mapper.RepairerInfoMapperExt;
import com.postbox.model.RepairerInfo;
import com.postbox.model.RepairerInfoExample;
import org.apache.commons.lang3.StringUtils;
import org.hanzhdy.manager.support.service.AbstractUpcService;
import org.hanzhdy.web.bean.DatatableResult;
import org.hanzhdy.web.throwable.BizException;
import org.hanzhdy.web.throwable.BizStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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
        if (StringUtils.isNotBlank(params.getRepairerNo())) {
            criteria.andRepairerNoLike("%" + params.getRepairerNo() + "%");
        }
        if (StringUtils.isNotBlank(params.getRealname())) {
            criteria.andRealnameLike("%" + params.getRealname() + "%");
        }
        if (StringUtils.isNotBlank(params.getCountry())) {
            criteria.andCountryEqualTo(params.getCountry());
        }
        if (StringUtils.isNotBlank(params.getProvince())) {
            criteria.andProvinceEqualTo(params.getProvince());
        }
        if (StringUtils.isNotBlank(params.getCity())) {
            criteria.andCityEqualTo(params.getCity());
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
    
    public RepairerInfo queryByNo(String no, DataStatus... status) {
        RepairerInfoExample example = new RepairerInfoExample();
        RepairerInfoExample.Criteria criteria = example.createCriteria();
        criteria.andRepairerNoEqualTo(no);
        if (status != null && status.length > 0) {
            if (status.length == 0) {
                criteria.andStatusEqualTo(status[0]);
            }
            else {
                criteria.andStatusIn(Arrays.asList(status));
            }
        }
        List<RepairerInfo> dataList = this.repairerInfoMapperExt.selectByExample(example);
        return dataList != null && !dataList.isEmpty() ? dataList.get(0) : null;
    }
    
    public List<RepairerInfo> queryByArea(String province, String city, DataStatus... status) {
        RepairerInfoExample example = new RepairerInfoExample();
        RepairerInfoExample.Criteria criteria = example.createCriteria();
        criteria.andProvinceEqualTo(province);
        criteria.andCityEqualTo(city);
        if (status != null && status.length > 0) {
            if (status.length == 0) {
                criteria.andStatusEqualTo(status[0]);
            }
            else {
                criteria.andStatusIn(Arrays.asList(status));
            }
        }
        return this.repairerInfoMapperExt.selectByExample(example);
    }
    
    public boolean insert(RepairerInfo record) {
        RepairerInfo info = this.queryByNo(record.getRepairerNo());
        if (info != null) {
            throw new BizException(respCode.SAVE_DUPLICATE);
        }
        
        record.setCreatetime(new Date());
        if (record.getStatus() == null) {
            record.setStatus(DataStatus.NORMAL);
        }
        int count = this.repairerInfoMapperExt.insertSelective(record);
        return count > 0;
    }
    
    public boolean update(RepairerInfo record) {
        RepairerInfo info = this.queryByNo(record.getRepairerNo());
        if (info != null && record.getRepairerInfoid().longValue() != info.getRepairerInfoid().longValue()) {
            throw new BizException(respCode.SAVE_DUPLICATE);
        }
        
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
