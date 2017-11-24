package org.hanzhdy.manager.settings.service;

import org.apache.commons.lang3.StringUtils;
import org.hanzhdy.manager.settings.controller.params.AreaParams;
import org.hanzhdy.manager.settings.mapper.AreaMapperExt;
import org.hanzhdy.manager.settings.model.Area;
import org.hanzhdy.manager.settings.model.AreaExample;
import org.hanzhdy.manager.settings.vo.AreaVo;
import org.hanzhdy.manager.support.service.AbstractUpcService;
import org.hanzhdy.web.bean.DatatableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by H.CAAHN on 2017/7/28.
 */
@Service
public class AreaService extends AbstractUpcService {
    @Autowired
    private AreaMapperExt areaMapperExt;
    
    /**
     * 查询地区信息表，并返回符合datatable要求的格式的数据
     * @param params
     * @return
     */
    public DatatableResult queryAsDatatableResult(AreaParams params) {
        // 构造查询条件
        Map<String, Object> search = new HashMap<String, Object>();
        search.put("page", params.getPage());
        if (StringUtils.isNotBlank(params.getSearchkey())) {
            search.put("searchkey", "%" + params.getSearchkey() + "%");
        }
        if (StringUtils.isNotBlank(params.getStatus())) {
            search.put("status", params.getStatus());
        }
    
        // 查询数据
        int count = this.areaMapperExt.countAsList(search);
        List<AreaVo> data = this.areaMapperExt.selectAsList(search);
        
        // 设置返回结果
        DatatableResult result = new DatatableResult();
        result.setTotal(count);
        result.setAaData(data);
        return result;
    }
    
    /**
     * 根据ID查询地区信息
     * @param id
     * @return
     */
    public Area queryById(Long id) {
        return this.areaMapperExt.selectByPrimaryKey(id);
    }
    
    /**
     * 根据上级区域ID查询子区域列表，不包括再次级区域
     * @param parent
     * @return
     */
    public List<Area> queryByParent(Long parent) {
        AreaExample example = new AreaExample();
        example.createCriteria().andParentEqualTo(parent);
        return this.areaMapperExt.selectByExample(example);
    }
    
    /**
     * 根据上级区域名称查询子区域列表，不包括再次级区域
     * @param parentName
     * @return
     */
    public List<Area> queryByParentName(String parentName) {
        return this.areaMapperExt.selectByParentName(parentName);
    }
}
