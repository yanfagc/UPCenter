package com.postbox.service;

import com.postbox.controller.params.CompanyInfoParams;
import com.postbox.enums.DataStatus;
import com.postbox.mapper.CompanyInfoMapperExt;
import com.postbox.model.CompanyInfo;
import com.postbox.model.CompanyInfoExample;
import org.apache.commons.lang3.StringUtils;
import org.hanzhdy.manager.support.enums.CommonStatus;
import org.hanzhdy.manager.support.service.AbstractUpcService;
import org.hanzhdy.web.bean.DatatableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by H.CAAHN on 2017/7/20.
 */
@Service
public class CompanyInfoService extends AbstractUpcService {
    @Autowired
    private CompanyInfoMapperExt companyInfoMapperExt;
    
    public DatatableResult queryAsDatatableResult(CompanyInfoParams params) {
        // 构造查询条件
        CompanyInfoExample example = new CompanyInfoExample();
        example.setPage(params.getPage());
        CompanyInfoExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(params.getCompanyName())) {
            criteria.andCompanyNameLike("%" + params.getCompanyName() + "%");
        }
        if (StringUtils.isNotBlank(params.getContactName())) {
            criteria.andContactNameLike("%" + params.getContactName() + "%");
        }
        if (StringUtils.isNotBlank(params.getContactPhone())) {
            criteria.andContactPhoneLike("%" + params.getContactPhone() + "%");
        }
        if (StringUtils.isNotBlank(params.getLegalPersonName())) {
            criteria.andLegalPersonNameLike("%" + params.getLegalPersonName() + "%");
        }
        if (params.getStatus() != null) {
            criteria.andStatusEqualTo(params.getStatus());
        }
    
        // 设置返回结果
        int total = this.companyInfoMapperExt.countByExample(example);
        List<CompanyInfo> data = this.companyInfoMapperExt.selectByExample(example);
        
        DatatableResult result = new DatatableResult();
        result.setTotal(total);
        result.setAaData(data);
        return result;
    }
    
    /**
     * 根据企业名称以及状态模糊查询企业信息，并返回符合条件的列表
     * @param name
     * @param status
     * @return
     */
    public List<CompanyInfo> queryByName(String name, DataStatus status) {
        CompanyInfoExample example = new CompanyInfoExample();
        CompanyInfoExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(name)) {
            criteria.andCompanyNameLike("%" + name + "%");
        }
        if (status != null) {
            criteria.andStatusEqualTo(status);
        }
        return this.companyInfoMapperExt.selectByExample(example);
    }
    
    /**
     * 根据企业ID号，查询企业信息
     * @param companyInfoId
     * @return
     */
    public CompanyInfo queryById(Long companyInfoId) {
        return this.companyInfoMapperExt.selectByPrimaryKey(companyInfoId);
    }
    
    /**
     * 插入企业信息，并生产鉴权数据
     * @param record
     * @return
     */
    public boolean insert(CompanyInfo record) {
        if (record.getStatus() == null) {
            record.setStatus(DataStatus.NORMAL);
        }
        record.setCreatetime(new Date());
        record.setAuth(UUID.randomUUID().toString().replace("-", ""));
        int count = this.companyInfoMapperExt.insertSelective(record);
        return count > 0;
    }
    
    /**
     * 更新企业信息，其中鉴权数据不做更新
     * @param record
     * @return
     */
    public boolean update(CompanyInfo record) {
        // 禁止修改鉴权信息
        record.setAuth(null);
        int count = this.companyInfoMapperExt.updateByPrimaryKeySelective(record);
        return count > 0;
    }
    
    /**
     * 更新企业信息状态
     * @param record
     * @return
     */
    public boolean updateStatus(CompanyInfo record) {
        CompanyInfo data = new CompanyInfo();
        data.setCompanyInfoId(record.getCompanyInfoId());
        data.setStatus(record.getStatus());
        int count = this.companyInfoMapperExt.updateByPrimaryKeySelective(data);
        return count > 0;
    }
    
    /**
     * 刷新企业鉴权数据
     * @param companyInfoId
     * @return
     */
    public boolean updateRefreshAuth(Long companyInfoId) {
        CompanyInfo record = new CompanyInfo();
        record.setCompanyInfoId(companyInfoId);
        record.setAuth(UUID.randomUUID().toString().replace("-", ""));
        int count = this.companyInfoMapperExt.updateByPrimaryKeySelective(record);
        return count > 0;
    }
}
