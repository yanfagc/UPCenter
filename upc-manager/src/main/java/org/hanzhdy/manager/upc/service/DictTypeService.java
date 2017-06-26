package org.hanzhdy.manager.upc.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hanzhdy.manager.support.enums.CommonStatus;
import org.hanzhdy.manager.support.service.AbstractUpcService;
import org.hanzhdy.manager.upc.controller.params.DictTypeParams;
import org.hanzhdy.manager.upc.mapper.DictTypeMapperExt;
import org.hanzhdy.manager.upc.model.DictType;
import org.hanzhdy.manager.upc.model.DictTypeExample;
import org.hanzhdy.web.bean.DatatableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description 字典类型Service
 * @author H.CAAHN
 * @createtime 2016年10月8日 下午9:59:41
 */
@Service
public class DictTypeService extends AbstractUpcService {
    @Autowired
    private DictTypeMapperExt dictTypeMapperExt;
    
    /**
     * 查询字典类型表，并返回符合datatable要求的格式的数据
     * @param params
     * @return
     */
    public DatatableResult queryAsDatatableResult(DictTypeParams params) {
        // 构造查询条件
        Map<String, Object> search = new HashMap<String, Object>();
        search.put("page", params.getPage());
        if (StringUtils.isNotBlank(params.getSearchkey())) {
            search.put("searchkey", "%" + params.getSearchkey() + "%");
        }
        if (StringUtils.isNotBlank(params.getStatus())) {
            search.put("status", params.getStatus());
        }
        if (StringUtils.isNotBlank(params.getValuetype())) {
            search.put("valuetype", params.getValuetype());
        }
        
        // 查询数据
        int count = this.dictTypeMapperExt.countAsList(search);
        List<DictType> data = this.dictTypeMapperExt.selectAsList(search);
        
        // 设置返回结果
        DatatableResult result = new DatatableResult();
        result.setTotal(count);
        result.setAaData(data);
        return result;
    }
    
    /**
     * 查询所有状态正常的字典类型数据
     * @return
     */
    public List<DictType> queryAsList() {
        DictTypeExample example = new DictTypeExample();
        example.createCriteria().andStatusEqualTo(CommonStatus.N);
        return this.dictTypeMapperExt.selectByExample(example);
    }
    
    /**
     * 根据字典类型ID查询字典类型信息
     * @param id
     * @return
     */
    public DictType queryById(Long id) {
        return this.dictTypeMapperExt.selectByPrimaryKey(id);
    }
    
    /**
     * 插入字典类型信息
     * @param record
     * @return
     */
    public boolean insert(DictType record) {
        record.setCreatetime(new Date());
        record.setUpdatetime(record.getCreatetime());
        int count = this.dictTypeMapperExt.insert(record);
        return count > 0;
    }
    
    /**
     * 更新字典类型信息
     * @param record
     * @return
     */
    public boolean update(DictType record) {
        record.setUpdatetime(new Date());
        int count = this.dictTypeMapperExt.updateByPrimaryKeySelective(record);
        return count > 0;
    }
    
    /**
     * 更新字典类型状态
     * @param record
     * @return
     */
    public boolean updateStatus(DictType record) {
        DictType type = new DictType();
        type.setId(record.getId());
        type.setStatus(record.getStatus());
        type.setUpdatetime(new Date());
        int count = this.dictTypeMapperExt.updateByPrimaryKeySelective(type);
        return count > 0;
    }
    
    /**
     * 删除字典类型
     * @param id
     * @return
     */
    public boolean delete(Long id) {
        int count = this.dictTypeMapperExt.deleteByPrimaryKey(id);
        return count > 0;
    }
}
