package com.postbox.service;

import com.postbox.controller.params.BoxGridParams;
import com.postbox.enums.BoxGridStatus;
import com.postbox.mapper.BoxGridMapperExt;
import com.postbox.model.BoxGrid;
import com.postbox.model.BoxGridExample;
import org.apache.commons.lang3.StringUtils;
import org.hanzhdy.manager.support.service.AbstractUpcService;
import org.hanzhdy.web.bean.DatatableResult;
import org.hanzhdy.web.throwable.BizException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 快递格子管理
 * Created by H.CAAHN on 2017/8/24.
 */
@Service
public class BoxGridService extends AbstractUpcService {
    @Autowired
    private BoxGridMapperExt boxGridMapperExt;
    
    /**
     * 根据条件查询快递格子
     * @param params
     * @return
     */
    public DatatableResult queryAsDatatableResult(BoxGridParams params) {
        BoxGridExample example = new BoxGridExample();
        example.setPage(params.getPage());
        BoxGridExample.Criteria criteria = example.createCriteria();
        if (params.getBoxInfoId() != null) {
            criteria.andBoxInfoIdEqualTo(params.getBoxInfoId());
        }
        if (StringUtils.isNotBlank(params.getGridCode())) {
            criteria.andGridCodeLike("%" + params.getGridCode() + "%");
        }
        
        int total = this.boxGridMapperExt.countByExample(example);
        List<BoxGrid> dataList = this.boxGridMapperExt.selectByExample(example);
        DatatableResult result = new DatatableResult();
        result.setTotal(total);
        result.setAaData(dataList);
        return result;
    }
    
    /**
     * 根据GridCode和boxInfoId查询快递格子数据
     * @param gridCode
     * @param boxInfoId
     * @return
     */
    public BoxGrid queryByCodeAndBoxInfoId(String gridCode, Long boxInfoId) {
        BoxGridExample example = new BoxGridExample();
        BoxGridExample.Criteria criteria = example.createCriteria();
        criteria.andBoxInfoIdEqualTo(boxInfoId);
        criteria.andGridCodeEqualTo(gridCode);
        List<BoxGrid> gridList = this.boxGridMapperExt.selectByExample(example);
        if (gridList != null && !gridList.isEmpty()) {
            return gridList.get(0);
        }
        return null;
    }
    
    /**
     * 根据ID查询BoxGrid数据信息
     * @param id
     * @return
     */
    public BoxGrid queryById(Long id) {
        return this.boxGridMapperExt.selectByPrimaryKey(id);
    }
    
    /**
     * 插入新的快递格子数据
     * @param record
     * @return
     */
    public boolean insert(BoxGrid record) {
        BoxGrid grid = this.queryByCodeAndBoxInfoId(record.getGridCode(), record.getBoxInfoId());
        if (grid != null) {
            throw new BizException(respCode.SAVE_DUPLICATE);
        }
        
        if (record.getStatus() != null) {
            record.setStatus(BoxGridStatus.NOACTIVE);
        }
        
        int count = this.boxGridMapperExt.insert(record);
        return count > 0;
    }
    
    /**
     * 更新快递格子数据
     * @param record
     * @return
     */
    public boolean update(BoxGrid record) {
        BoxGrid grid = this.queryByCodeAndBoxInfoId(record.getGridCode(), record.getBoxInfoId());
        if (grid != null && grid.getBoxGridId().longValue() != record.getBoxGridId()) {
            throw new BizException(respCode.SAVE_DUPLICATE);
        }
        
        int count = this.boxGridMapperExt.updateByPrimaryKeySelective(record);
        return count > 0;
    }
    
    /**
     * 更新快递格子状态
     * @param record
     * @return
     */
    public boolean updateStatus(BoxGrid record) {
        BoxGrid grid = new BoxGrid();
        grid.setBoxGridId(record.getBoxGridId());
        grid.setStatus(record.getStatus());
        int count = this.boxGridMapperExt.updateByPrimaryKeySelective(grid);
        return count > 0;
    }
}
