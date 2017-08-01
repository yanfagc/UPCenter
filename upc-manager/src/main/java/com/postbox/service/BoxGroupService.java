package com.postbox.service;

import com.postbox.controller.params.BoxGroupParams;
import com.postbox.enums.BoxGroupStatus;
import com.postbox.mapper.BoxGroupMapperExt;
import com.postbox.model.BoxGroup;
import com.postbox.model.BoxGroupExample;
import com.postbox.vo.BoxGroupVo;
import org.apache.commons.lang3.StringUtils;
import org.hanzhdy.manager.support.service.AbstractUpcService;
import org.hanzhdy.web.bean.DatatableResult;
import org.hanzhdy.web.throwable.BizException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<String, Object> search = new HashMap<>();
        search.put("page", params.getPage());
        if (StringUtils.isNotBlank(params.getGroupName())) {
            search.put("groupName", "%" + params.getGroupName() + "%");
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
        if (params.getCompanyInfoId() != null) {
            search.put("companyInfoId", params.getCompanyInfoId());
        }
        if (params.getRepairerInfoId() != null) {
            search.put("repairerInfoId", params.getRepairerInfoId());
        }
        if (params.getStatus() != null) {
            search.put("status", params.getStatus());
        }
        
        int total = this.boxGroupMapperExt.countAsList(search);
        List<BoxGroupVo> data = this.boxGroupMapperExt.selectAsList(search);
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
    public BoxGroupVo queryById(Long id) {
        return this.boxGroupMapperExt.selectByGroupId(id);
    }
    
    /**
     * 根据箱子组编号查询箱子
     * @param code
     * @return
     */
    public BoxGroup queryByCode(String code) {
        BoxGroupExample example = new BoxGroupExample();
        example.createCriteria().andGroupCodeEqualTo(code);
        List<BoxGroup> dataList = this.boxGroupMapperExt.selectByExample(example);
        return dataList != null && !dataList.isEmpty() ? dataList.get(0) : null;
    }
    
    public List<BoxGroup> queryForAjax(BoxGroupParams params, BoxGroupStatus... status) {
        Map<String, Object> search = new HashMap<String, Object>();
        if (params.getProvince() != null) {
            search.put("province", params.getProvince());
        }
        if (params.getCity() != null) {
            search.put("city", params.getCity());
        }
        if (StringUtils.isNotBlank(params.getSearchkey())) {
            search.put("searchkey", params.getSearchkey() + "%");
        }
        if (status != null) {
            if (status.length == 1) {
                search.put("status", status[0]);
            }
            else if (status.length > 1) {
                search.put("statusList", status);
            }
        }
        
        search.put("limitSize", 20);
        
        return this.boxGroupMapperExt.selectForAjaxSearch(search);
    }
    
    /**
     * 插入一个新的箱子组数据
     * @param record
     * @return
     */
    public boolean insert(BoxGroup record) {
        BoxGroup group = this.queryByCode(record.getGroupCode());
        if (group != null) {
            throw new BizException(respCode.SAVE_DUPLICATE);
        }
        
        Date nowtime = new Date();
        switch (record.getStatus()) {
            case NORMAL:
                record.setActivetime(nowtime);
                break;
            case FROZEN :
                record.setFrozentime(nowtime);
                break;
            case DEMISE :
                record.setDemisetime(nowtime);
                break;
            default:
                record.setStatus(BoxGroupStatus.NOACTIVE);
                break;
        }
        
        record.setCreatetime(nowtime);
        int count = this.boxGroupMapperExt.insertSelective(record);
        return count > 0;
    }
    
    /**
     * 更新箱子组信息
     * @param record
     * @return
     */
    public boolean update(BoxGroup record) {
        BoxGroup group = this.queryByCode(record.getGroupCode());
        if (group != null) {
            if (group.getBoxGroupId().longValue() != record.getBoxGroupId()) {
                throw new BizException(respCode.SAVE_DUPLICATE);
            }
        }
        else {
            group = this.boxGroupMapperExt.selectByPrimaryKey(record.getBoxGroupId());
        }
        
        if (group.getStatus() != record.getStatus()) {
            Date nowtime = new Date();
            switch (record.getStatus()) {
                case NORMAL:
                    record.setActivetime(nowtime);
                    break;
                case FROZEN :
                    record.setFrozentime(nowtime);
                    break;
                case DEMISE :
                    record.setDemisetime(nowtime);
                    break;
                default:
                    break;
            }
        }
        
        int count = this.boxGroupMapperExt.updateByPrimaryKeySelective(record);
        return count > 0;
    }
    
    /**
     * 更新箱子组状态
     * @param record
     * @return
     */
    public boolean updateStatus(BoxGroup record) {
        BoxGroup group = this.boxGroupMapperExt.selectByPrimaryKey(record.getBoxGroupId());
        if (group == null) {
            throw new BizException(respCode.SAVE_NORECORD);
        }
        
        BoxGroup data = new BoxGroup();
        data.setBoxGroupId(record.getBoxGroupId());
        data.setStatus(record.getStatus());
        if (data.getStatus() != group.getStatus()) {
            Date nowtime = new Date();
            switch (data.getStatus()) {
                case NORMAL:
                    data.setActivetime(nowtime);
                    break;
                case FROZEN:
                    data.setFrozentime(nowtime);
                    break;
                case DEMISE:
                    data.setDemisetime(nowtime);
                    break;
                default:
                    break;
            }
        }
        
        int count = this.boxGroupMapperExt.updateByPrimaryKeySelective(data);
        return count > 0;
    }
}
