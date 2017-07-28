package org.hanzhdy.manager.settings.service;

import org.hanzhdy.manager.settings.mapper.AreaMapperExt;
import org.hanzhdy.manager.settings.model.Area;
import org.hanzhdy.manager.settings.model.AreaExample;
import org.hanzhdy.manager.support.service.AbstractUpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by H.CAAHN on 2017/7/28.
 */
@Service
public class AreaService extends AbstractUpcService {
    @Autowired
    private AreaMapperExt areaMapperExt;
    
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
