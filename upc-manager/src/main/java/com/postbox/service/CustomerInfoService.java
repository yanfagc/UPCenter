package com.postbox.service;

import com.postbox.controller.params.CustomerInfoParams;
import com.postbox.mapper.CustomerInfoMapperExt;
import com.postbox.model.CustomerInfo;
import com.postbox.model.CustomerInfoExample;
import org.apache.commons.lang3.StringUtils;
import org.hanzhdy.manager.support.service.AbstractUpcService;
import org.hanzhdy.web.bean.DatatableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 客户管理
 * Created by H.CAAHN on 2017/7/21.
 */
@Service
public class CustomerInfoService extends AbstractUpcService {
    @Autowired
    private CustomerInfoMapperExt customerInfoMapperExt;
    
    /**
     * 分页查询客户列表信息
     * @param params
     * @return
     */
    public DatatableResult queryAsDatatableResult(CustomerInfoParams params) {
        CustomerInfoExample example = new CustomerInfoExample();
        example.setPage(params.getPage());
        CustomerInfoExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(params.getRealName())) {
            criteria.andRealnameLike("%" + params.getRealName() + "%");
        }
        if (StringUtils.isNotBlank(params.getMobilePhone())) {
            criteria.andMobilePhoneLike("%" + params.getMobilePhone() + "%");
        }
        if (params.getStatus() != null) {
            criteria.andStatusEqualTo(params.getStatus());
        }
    
        // 设置返回结果
        int total = this.customerInfoMapperExt.countByExample(example);
        List<CustomerInfo> data = this.customerInfoMapperExt.selectByExample(example);
    
        DatatableResult result = new DatatableResult();
        result.setTotal(total);
        result.setAaData(data);
        return result;
    }
    
    /**
     * 根据ID查询客户信息
     * @param id
     * @return
     */
    public CustomerInfo queryById(Long id) {
        return this.customerInfoMapperExt.selectByPrimaryKey(id);
    }
    
    /**
     * 更新用户状态
     * @param record
     * @return
     */
    public boolean updateStatus(CustomerInfo record) {
        CustomerInfo data = new CustomerInfo();
        data.setCustomerInfoId(record.getCustomerInfoId());
        data.setStatus(record.getStatus());
        int count = this.customerInfoMapperExt.updateByPrimaryKeySelective(data);
        return count > 0;
    }
}
