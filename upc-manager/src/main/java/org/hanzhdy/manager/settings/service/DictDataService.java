package org.hanzhdy.manager.settings.service;

import org.apache.commons.lang3.StringUtils;
import org.hanzhdy.manager.settings.controller.params.DictDataParams;
import org.hanzhdy.manager.settings.mapper.DictDataMapperExt;
import org.hanzhdy.manager.settings.model.DictData;
import org.hanzhdy.manager.settings.model.DictDataExample;
import org.hanzhdy.manager.support.enums.CommonStatus;
import org.hanzhdy.manager.support.service.AbstractUpcService;
import org.hanzhdy.web.bean.DatatableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description 数据字典表Service
 * @author H.CAAHN
 * @createtime 2016年10月8日 下午9:59:30
 */
@Service
public class DictDataService extends AbstractUpcService {
    @Autowired
    private DictDataMapperExt dictDataMapperExt;
    
    /**
     * 查询字典类型表，并返回符合datatable要求的格式的数据
     * @param params
     * @return
     */
    public DatatableResult queryAsDatatableResult(DictDataParams params) {
        // 构造查询条件
        Map<String, Object> search = new HashMap<String, Object>();
        search.put("page", params.getPage());
        if (StringUtils.isNotBlank(params.getSearchkey())) {
            search.put("searchkey", "%" + params.getSearchkey() + "%");
        }
        if (StringUtils.isNotBlank(params.getStatus())) {
            search.put("status", params.getStatus());
        }
        if (params.getTypeId() != null && params.getTypeId() > 0) {
            search.put("typeid", params.getTypeId());
        }
        
        // 查询数据
        int count = this.dictDataMapperExt.countAsList(search);
        List<DictData> data = this.dictDataMapperExt.selectAsList(search);
        
        // 设置返回结果
        DatatableResult result = new DatatableResult();
        result.setTotal(count);
        result.setAaData(data);
        return result;
    }
    
    /**
     * 根据数据字典ID查询相应的数据字典信息
     * @param id
     * @return
     */
    public DictData queryById(Long id) {
        return this.dictDataMapperExt.selectByPrimaryKey(id);
    }
    
    /**
     * 根据字典类型ID查询数据字典信息（返回status状态值为正常的数据）
     * @param typeid
     * @return
     */
    public List<DictData> queryByTypeid(Long typeid) {
        DictDataExample example = new DictDataExample();
        example.createCriteria().andStatusEqualTo(CommonStatus.N).andTypeIdEqualTo(typeid);
        example.setOrderByClause(" SORT ASC ");
        return this.dictDataMapperExt.selectByExample(example);
    }
    
    /**
     * 根据字典类型编码查询数据字典信息（返回status状态值为正常的数据）
     * @param typecode
     * @return
     */
    public List<DictData> queryByTypecode(String typecode) {
        return this.dictDataMapperExt.selectByTypecode(typecode);
    }
    
    /**
     * 插入数据字典信息
     * @param record
     * @return
     */
    public boolean insert(DictData record) {
        record.setCreatetime(new Date());
        record.setUpdatetime(record.getCreatetime());
        int count = this.dictDataMapperExt.insert(record);
        return count > 0;
    }
    
    /**
     * 更新数据字典信息
     * @param record
     * @return
     */
    public boolean update(DictData record) {
        record.setUpdatetime(new Date());
        int count = this.dictDataMapperExt.updateByPrimaryKeySelective(record);
        return count > 0;
    }
    
    /**
     * 更新数据字典状态
     * @param record
     * @return
     */
    public boolean updateStatus(DictData record) {
        DictData data = new DictData();
        data.setStatus(record.getStatus());
        data.setId(record.getId());
        data.setUpdatetime(new Date());
        int count = this.dictDataMapperExt.updateByPrimaryKeySelective(data);
        return count > 0;
    }
    
    /**
     * 删除数据字典记录
     * @param id
     * @return
     */
    public boolean delete(Long id) {
        int count = this.dictDataMapperExt.deleteByPrimaryKey(id);
        return count > 0;
    }
}
