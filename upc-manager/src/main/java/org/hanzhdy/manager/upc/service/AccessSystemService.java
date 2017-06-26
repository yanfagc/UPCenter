package org.hanzhdy.manager.upc.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hanzhdy.manager.support.enums.CommonStatus;
import org.hanzhdy.manager.support.service.AbstractUpcService;
import org.hanzhdy.manager.upc.controller.params.AccessSystemParams;
import org.hanzhdy.manager.upc.mapper.AccessSystemMapperExt;
import org.hanzhdy.manager.upc.model.AccessSystem;
import org.hanzhdy.manager.upc.model.AccessSystemExample;
import org.hanzhdy.manager.upc.model.Menu;
import org.hanzhdy.web.bean.DatatableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description 接入系统管理Service
 * @author H.CAAHN
 * @createtime 2016年10月7日 上午12:43:09
 */
@Service
public class AccessSystemService extends AbstractUpcService {
    @Autowired
    private AccessSystemMapperExt accessSystemMapperExt;
    
    @Autowired
    private MenuService           menuService;
    
    /**
     * 分页查询接入系统信息，并按条件返回符合datatable数据格式的信息
     * @param params
     * @return
     */
    public DatatableResult queryAsDatatableResult(AccessSystemParams params) {
        // 构造查询条件
        Map<String, Object> search = new HashMap<String, Object>();
        search.put("page", params.createPage());
        if (StringUtils.isNotBlank(params.getSearchkey())) {
            search.put("searchkey", "%" + params.getSearchkey() + "%");
        }
        if (StringUtils.isNotBlank(params.getSyscode())) {
            search.put("syscode", "%" + params.getSyscode() + "%");
        }
        if (StringUtils.isNotBlank(params.getSysname())) {
            search.put("sysname", "%" + params.getSysname() + "%");
        }
        if (StringUtils.isNotBlank(params.getStatus())) {
            search.put("status", params.getStatus());
        }
        
        // 查询数据
        int count = this.accessSystemMapperExt.countAsList(search);
        List<AccessSystem> data = this.accessSystemMapperExt.selectAsList(search);
        
        // 设置返回结果
        DatatableResult result = new DatatableResult();
        result.setTotal(count);
        result.setAaData(data);
        return result;
    }
    
    /**
     * 查询所有状态正常的第三方接入系统信息
     * @return
     */
    public List<AccessSystem> queryNormalList() {
        AccessSystemExample example = new AccessSystemExample();
        example.createCriteria().andStatusEqualTo(CommonStatus.N);
        return this.accessSystemMapperExt.selectByExample(example);
    }
    
    /**
     * 根据ID号查询接入系统信息
     * @param id
     * @return
     */
    public AccessSystem queryById(Long id) {
        return this.accessSystemMapperExt.selectByPrimaryKey(id);
    }
    
    /**
     * 根据接入系统的编码查询对应的接入系统信息
     * @param syscode
     * @return
     */
    public AccessSystem queryBySyscode(String syscode) {
        AccessSystemExample example = new AccessSystemExample();
        example.createCriteria().andSyscodeEqualTo(syscode).andStatusEqualTo(CommonStatus.N);
        List<AccessSystem> aList = this.accessSystemMapperExt.selectByExample(example);
        if (aList != null && !aList.isEmpty()) {
            return aList.get(0);
        }
        return null;
    }
    
    /**
     * 插入新的接入系统信息
     * @param record
     * @return
     */
    public boolean insert(AccessSystem record) {
        record.setCreatetime(new Date());
        record.setUpdatetime(record.getCreatetime());
        int count = this.accessSystemMapperExt.insert(record);
        return count > 0;
    }
    
    /**
     * 更新接入系统信息
     * @param record
     * @return
     */
    public boolean update(AccessSystem record) {
        record.setUpdatetime(new Date());
        int count = this.accessSystemMapperExt.updateByPrimaryKeySelective(record);
        return count > 0;
    }
    
    /**
     * 更新接入系统的数据状态
     * @param record
     * @return
     */
    public boolean updateStatus(AccessSystem record) {
        AccessSystem sys = new AccessSystem();
        sys.setId(record.getId());
        sys.setStatus(record.getStatus());
        sys.setUpdatetime(new Date());
        sys.setUpdater(record.getUpdater());
        int count = this.accessSystemMapperExt.updateByPrimaryKeySelective(sys);
        return count > 0;
    }
    
    /**
     * 删除接入系统数据，包括删除相应的菜单、权限数据
     * @param id
     * @return
     */
    public boolean delete(Long id) {
        List<Menu> menuList = this.menuService.queryBySystemid(id);
        for (Menu menu : menuList) {
            this.menuService.delete(menu.getId());
        }
        this.accessSystemMapperExt.deleteByPrimaryKey(id);
        return true;
    }
}
