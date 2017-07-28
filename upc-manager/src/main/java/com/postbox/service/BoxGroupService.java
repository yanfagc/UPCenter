package com.postbox.service;

import com.postbox.controller.params.BoxGroupParams;
import com.postbox.enums.BoxGroupStatus;
import com.postbox.mapper.BoxGroupMapperExt;
import com.postbox.model.BoxGroup;
import com.postbox.model.BoxGroupExample;
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
public class BoxGroupService extends AbstractUpcService {
    @Autowired
    private BoxGroupMapperExt boxGroupMapperExt;
    
    /**
     * 根据条件分页查询箱子组数据，并返回符合前端datatable数据格式要求的对象
     * @param params
     * @return
     */
    public DatatableResult queryAsDatatableResult(BoxGroupParams params) {
        BoxGroupExample example = new BoxGroupExample();
        BoxGroupExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(params.getGroupName())) {
            criteria.andGroupNameLike("%" + params.getGroupName() + "%");
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
        if (params.getCompanyInfoId() != null) {
            criteria.andCompanyInfoIdEqualTo(params.getCompanyInfoId());
        }
        if (params.getRepairerInfoId() != null) {
            criteria.andRepairerInfoIdEqualTo(params.getRepairerInfoId());
        }
        if (params.getStatus() != null) {
            criteria.andStatusEqualTo(params.getStatus());
        }
        
        int total = this.boxGroupMapperExt.countByExample(example);
        List<BoxGroup> data = this.boxGroupMapperExt.selectByExample(example);
        DatatableResult result = new DatatableResult();
        result.setTotal(total);
        result.setAaData(data);
        return result;
    }
    
    /**
     * 根据ID号查询箱子组数据
     * @param id
     * @return
     */
    public BoxGroup queryById(Long id) {
        return this.boxGroupMapperExt.selectByPrimaryKey(id);
    }
    
    /**
     * 插入一个新的箱子组数据
     * @param record
     * @return
     */
    public boolean insert(BoxGroup record) {
        if (record.getStatus() == null) {
            record.setStatus(BoxGroupStatus.NORMAL);
        }
        record.setCreatetime(new Date());
        int count = this.boxGroupMapperExt.insertSelective(record);
        return count > 0;
    }
    
    /**
     * 更新箱子组信息
     * @param record
     * @return
     */
    public boolean update(BoxGroup record) {
        int count = this.boxGroupMapperExt.updateByPrimaryKeySelective(record);
        return count > 0;
    }
    
    /**
     * 更新箱子组状态
     * @param record
     * @return
     */
    public boolean updateStatus(BoxGroup record) {
        BoxGroup data = new BoxGroup();
        data.setBoxGroupId(record.getBoxGroupId());
        data.setStatus(record.getStatus());
        int count = this.boxGroupMapperExt.updateByPrimaryKeySelective(data);
        return count > 0;
    }
}
