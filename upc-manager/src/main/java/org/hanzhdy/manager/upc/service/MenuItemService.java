package org.hanzhdy.manager.upc.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hanzhdy.manager.support.service.AbstractUpcService;
import org.hanzhdy.manager.upc.controller.params.MenuParams;
import org.hanzhdy.manager.upc.mapper.MenuItemMapperExt;
import org.hanzhdy.manager.upc.mapper.MenuMapperExt;
import org.hanzhdy.manager.upc.mapper.RoleMenuItemMapperExt;
import org.hanzhdy.manager.upc.model.Menu;
import org.hanzhdy.manager.upc.model.MenuItem;
import org.hanzhdy.manager.upc.model.MenuItemExample;
import org.hanzhdy.manager.upc.vo.MenuVo;
import org.hanzhdy.web.bean.DatatableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description 菜单项Service
 * @author H.CAAHN
 * @createtime 2016年6月29日 下午9:14:09
 */
@Service
public class MenuItemService extends AbstractUpcService {
    @Autowired
    private MenuMapperExt         menuMapperExt;
    
    @Autowired
    private MenuItemMapperExt     menuItemMapperExt;
    
    @Autowired
    private RoleMenuItemMapperExt roleMenuItemMapperExt;
    
    /**
     * 根据条件查询菜单权限信息，并返回符合jQuery.dataTables格式要求的数据
     * @param params
     * @return
     */
    public DatatableResult queryAsDatatableResult(MenuParams params) {
        Map<String, Object> search = new HashMap<String, Object>();
        search.put("page", params.createPage());
        search.put("parentid", params.getParentid());
        
        if (StringUtils.isNotBlank(params.getUrltype())) {
            search.put("urltype", params.getUrltype());
        }
        if (StringUtils.isNotBlank(params.getSearchkey())) {
            search.put("searchkey", "%" + params.getSearchkey() + "%");
        }
        if (StringUtils.isNotBlank(params.getStatus())) {
            search.put("status", "%" + params.getStatus() + "%");
        }
        
        int count = this.menuItemMapperExt.countAsList(search);
        List<MenuVo> data = this.menuItemMapperExt.selectAsList(search);
        
        DatatableResult result = new DatatableResult();
        result.setTotal(count);
        result.setAaData(data);
        return result;
    }
    
    /**
     * 根据ID号查询MenuItem信息
     * @param id
     * @return
     */
    public MenuItem queryMenuItemById(Long id) {
        return this.menuItemMapperExt.selectByPrimaryKey(id);
    }
    
    /**
     * 根据菜单ID查询MenuItem信息
     * @param menuid
     * @return
     */
    public List<MenuItem> queryByMenuid(Long menuid) {
        MenuItemExample example = new MenuItemExample();
        example.createCriteria().andMenuIdEqualTo(menuid);
        return this.menuItemMapperExt.selectByExample(example);
    }
    
    /**
     * 根据用户ID和系统ID查询该用户在系统中所拥有的权限
     * @param userid
     * @param systemid
     * @return
     */
    public List<MenuItem> queryByUserAndSysid(Long userid, Long systemid) {
        return this.menuItemMapperExt.selectByUserAndSysId(userid, systemid);
    }
    
    /**
     * 插入菜单项数据
     * @param record
     * @return
     */
    public boolean insert(MenuItem record) {
        if (record.getMenuId() != null && record.getMenuId() > 0) {
            Menu parent = this.menuMapperExt.selectByPrimaryKey(record.getMenuId());
            record.setItemcode(parent.getMenucode() + "-" + record.getItemcode());
        }
        
        record.setCreatetime(new Date());
        record.setUpdatetime(record.getCreatetime());
        int count = this.menuItemMapperExt.insert(record);
        return count > 0;
    }
    
    /**
     * 更新菜单项数据
     * @param record
     * @return
     */
    public boolean update(MenuItem record) {
        if (record.getMenuId() != null && record.getMenuId() > 0) {
            Menu parent = this.menuMapperExt.selectByPrimaryKey(record.getMenuId());
            record.setItemcode(parent.getMenucode() + "-" + record.getItemcode());
        }
        
        record.setUpdatetime(new Date());
        int count = this.menuItemMapperExt.updateByPrimaryKeySelective(record);
        return count > 0;
    }
    
    /**
     * 更新菜单项数据状态
     * @param record
     * @return
     */
    public boolean updateStatus(MenuItem record) {
        MenuItem menu = new MenuItem();
        menu.setId(record.getId());
        menu.setStatus(record.getStatus());
        menu.setUpdatetime(new Date());
        menu.setUpdater(record.getUpdater());
        int count = this.menuItemMapperExt.updateByPrimaryKeySelective(menu);
        return count > 1;
    }
    
    /**
     * 删除菜单项数据
     * @param itemid
     * @return
     */
    public boolean delete(Long itemid) {
        this.roleMenuItemMapperExt.deleteByItemid(itemid);
        this.menuItemMapperExt.deleteByPrimaryKey(itemid);
        return true;
    }
}
