package com.postbox.service;

import com.postbox.controller.params.ExpressmanInfoParams;
import com.postbox.enums.ActiveStatus;
import com.postbox.mapper.ExpressmanInfoMapperExt;
import com.postbox.model.ExpressmanInfo;
import com.postbox.vo.ExpressmanInfoVo;
import org.apache.commons.lang3.StringUtils;
import org.hanzhdy.manager.support.service.AbstractUpcService;
import org.hanzhdy.web.bean.DatatableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 快递员Service
 * Created by H.CAAHN on 2017/7/21.
 */
@Service
public class ExpressmanInfoService extends AbstractUpcService {
    @Autowired
    private ExpressmanInfoMapperExt expressmanInfoMapperExt;
    
    /**
     * 分页查询快递员信息，并返回符合Datatable格式要求的对象
     * @param params
     * @return
     */
    public DatatableResult queryAsDatatableResult(ExpressmanInfoParams params) {
        Map<String, Object> search = new HashMap<String, Object>();
        search.put("page", params.createPage());
        if (StringUtils.isNotBlank(params.getRealName())) {
            search.put("realName", "%" + params.getRealName() + "%");
        }
        if (StringUtils.isNotBlank(params.getMobilePhone())) {
            search.put("mobilePhone", "%" + params.getMobilePhone() + "%");
        }
        if (params.getStatus() != null) {
            search.put("status", params.getStatus());
        }
        
        int total = this.expressmanInfoMapperExt.countAsList(search);
        List<ExpressmanInfoVo> data = this.expressmanInfoMapperExt.selectAsList(search);
    
        DatatableResult result = new DatatableResult();
        result.setTotal(total);
        result.setAaData(data);
        return result;
    }
    
    public ExpressmanInfo queryById(Long expressmanInfoId) {
        return this.expressmanInfoMapperExt.selectByPrimaryKey(expressmanInfoId);
    }
    
    public boolean updateStatus(ExpressmanInfo record) {
        ExpressmanInfo data = new ExpressmanInfo();
        data.setExpressmanInfoId(record.getExpressmanInfoId());
        data.setStatus(record.getStatus());
        if (record.getStatus() == ActiveStatus.NORMAL) {
            record.setActivetime(new Date());
        }
        int count = this.expressmanInfoMapperExt.updateByPrimaryKeySelective(record);
        return count > 0;
    }
}
