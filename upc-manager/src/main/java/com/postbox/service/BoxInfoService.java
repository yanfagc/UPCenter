package com.postbox.service;

import com.postbox.controller.params.BoxInfoParams;
import com.postbox.enums.BoxGroupStatus;
import com.postbox.enums.BoxInfoStatus;
import com.postbox.mapper.BoxInfoMapperExt;
import com.postbox.model.BoxInfo;
import com.postbox.model.BoxInfoExample;
import com.postbox.vo.BoxInfoVo;
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
 * 箱子Service
 * Created by H.CAAHN on 2017/7/31.
 */
@Service
public class BoxInfoService extends AbstractUpcService {
    @Autowired
    private BoxInfoMapperExt boxInfoMapperExt;
    
    /**
     * 根据条件分页查询箱子信息，并返回符合jquery.datatable格式要求的对象
     * @param params
     * @return
     */
    public DatatableResult queryAsDatatableResult(BoxInfoParams params) {
        Map<String, Object> search = new HashMap<>();
        search.put("page", params.getPage());
        if (StringUtils.isNotBlank(params.getBoxCode())) {
            search.put("boxCode", "%" + params.getBoxCode() + "%");
        }
        if (StringUtils.isNotBlank(params.getBoxUniqueCode())) {
            search.put("boxUniqueCode", "%" + params.getBoxUniqueCode() + "%");
        }
        if (StringUtils.isNotBlank(params.getProvince())) {
            search.put("province", params.getProvince());
        }
        if (StringUtils.isNotBlank(params.getCity())) {
            search.put("city", params.getCity());
        }
        if (params.getBoxGroupId() != null) {
            search.put("boxGroupId", params.getBoxGroupId());
        }
        if (params.getStatus() != null) {
            search.put("status", params.getStatus());
        }
        
        int total = this.boxInfoMapperExt.countAsList(search);
        List<BoxInfoVo> data = this.boxInfoMapperExt.selectAsList(search);
        DatatableResult result = new DatatableResult();
        result.setTotal(total);
        result.setAaData(data);
        return result;
    }
    
    /**
     * 根据箱子ID查询箱子信息
     * @param id
     * @return
     */
    public BoxInfoVo queryById(Long id) {
        return this.boxInfoMapperExt.selectMoreById(id);
    }
    
    /**
     * 根据箱子的唯一编码，查询箱子信息
     * @param code
     * @return
     */
    public BoxInfo queryByUniqueCode(String code) {
        BoxInfoExample example = new BoxInfoExample();
        example.createCriteria().andBoxUniqueCodeEqualTo(code);
        List<BoxInfo> dataList = this.boxInfoMapperExt.selectByExample(example);
        if (dataList != null && !dataList.isEmpty()) {
            return dataList.get(0);
        }
        return null;
    }
    
    /**
     * 插入新的箱子信息
     * @param record
     * @return
     */
    public boolean insert(BoxInfo record) {
        BoxInfo box = this.queryByUniqueCode(record.getBoxUniqueCode());
        if (box != null) {
            throw new BizException(respCode.SAVE_DUPLICATE);
        }
    
        Date nowtime = new Date();
        switch (record.getStatus()) {
            case NORMAL:
                record.setActivetime(nowtime);
                break;
            case REPAIR:
                record.setRepairtime(nowtime);
                break;
            case DEMISE:
                record.setDemisetime(nowtime);
                break;
            default:
                record.setStatus(BoxInfoStatus.NOACTIVE);
                break;
        }
    
        record.setCreatetime(nowtime);
        
        int count = this.boxInfoMapperExt.insertSelective(record);
        return count > 0;
    }
    
    /**
     * 更新箱子信息
     * @param record
     * @return
     */
    public boolean update(BoxInfo record) {
        BoxInfo box = this.queryByUniqueCode(record.getBoxUniqueCode());
        if (box != null) {
            if (box.getBoxInfoId().longValue() != record.getBoxInfoId()) {
                throw new BizException(respCode.SAVE_DUPLICATE);
            }
        }
        else {
            box = this.boxInfoMapperExt.selectByPrimaryKey(record.getBoxInfoId());
        }
        
        if (box.getStatus() != record.getStatus()) {
            Date nowtime = new Date();
            switch (record.getStatus()) {
                case NORMAL:
                    record.setActivetime(nowtime);
                    break;
                case REPAIR:
                    record.setRepairtime(nowtime);
                    break;
                case DEMISE:
                    record.setDemisetime(nowtime);
                    break;
                default:
                    break;
            }
        }
        
        int count = this.boxInfoMapperExt.updateByPrimaryKeySelective(record);
        return count > 0;
    }
    
    /**
     * 更新箱子状态
     * @param record
     * @return
     */
    public boolean updateStatus(BoxInfo record) {
        BoxInfo box = this.boxInfoMapperExt.selectByPrimaryKey(record.getBoxInfoId());
        if (box == null) {
            throw new BizException(respCode.SAVE_NORECORD);
        }
        
        BoxInfo data = new BoxInfo();
        data.setBoxInfoId(record.getBoxInfoId());
        data.setStatus(record.getStatus());
    
        if (box.getStatus() != record.getStatus()) {
            Date nowtime = new Date();
            switch (record.getStatus()) {
                case NORMAL:
                    record.setActivetime(nowtime);
                    break;
                case REPAIR:
                    record.setRepairtime(nowtime);
                    break;
                case DEMISE:
                    record.setDemisetime(nowtime);
                    break;
                default:
                    break;
            }
        }
    
        int count = this.boxInfoMapperExt.updateByPrimaryKeySelective(record);
        return count > 0;
    }
}
