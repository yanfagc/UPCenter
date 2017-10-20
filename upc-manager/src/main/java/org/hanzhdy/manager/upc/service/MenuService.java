package org.hanzhdy.manager.upc.service;

import org.apache.commons.lang3.StringUtils;
import org.hanzhdy.manager.support.enums.CommonStatus;
import org.hanzhdy.manager.support.service.AbstractUpcService;
import org.hanzhdy.manager.upc.controller.params.MenuParams;
import org.hanzhdy.manager.upc.mapper.MenuMapperExt;
import org.hanzhdy.manager.upc.mapper.RoleMenuMapperExt;
import org.hanzhdy.manager.upc.model.Menu;
import org.hanzhdy.manager.upc.model.MenuExample;
import org.hanzhdy.manager.upc.model.MenuExample.Criteria;
import org.hanzhdy.manager.upc.model.MenuItem;
import org.hanzhdy.manager.upc.vo.MenuVo;
import org.hanzhdy.manager.upc.vo.Resource;
import org.hanzhdy.web.bean.DatatableResult;
import org.hanzhdy.web.bean.ZTreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @description 菜单Service
 * @author H.CAAHN
 * @createtime 2016年1月12日 下午10:49:22
 */
@Service
public class MenuService extends AbstractUpcService {
    @Autowired
    private MenuMapperExt     menuMapperExt;
    
    @Autowired
    private RoleMenuMapperExt roleMenuMapperExt;
    
    @Autowired
    private MenuItemService   menuItemService;
    
    public DatatableResult queryAsDatatableResult(MenuParams params) {
        Map<String, Object> search = new HashMap<String, Object>();
        search.put("page", params.createPage());
        search.put("systemid", params.getSystemid());
        if (params.getParentid() != null) {
            search.put("parentid", params.getParentid());
        }
        else {
            search.put("parentid", "0");
        }
        if (StringUtils.isNotBlank(params.getUrltype())) {
            search.put("urltype", params.getUrltype());
        }
        if (StringUtils.isNotBlank(params.getSearchkey())) {
            search.put("searchkey", "%" + params.getSearchkey() + "%");
        }
        if (StringUtils.isNotBlank(params.getStatus())) {
            search.put("status", "%" + params.getStatus() + "%");
        }
        
        int count = this.menuMapperExt.countAsList(search);
        List<MenuVo> data = this.menuMapperExt.selectAsList(search);
        
        DatatableResult result = new DatatableResult();
        result.setTotal(count);
        result.setAaData(data);
        return result;
    }
    
    /**
     * 根据上级菜单编码ID，查询菜单数据，并按ZTreeNode要求格式返回数据
     * @param parentId
     * @return
     */
    public List<ZTreeNode> queryMenuAsZTreeNode(Long parentId, Long systemid) {
        MenuExample example = new MenuExample();
        Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        criteria.andSystemIdEqualTo(systemid);
        criteria.andStatusEqualTo(CommonStatus.N);
        example.setOrderByClause(" SORT ASC ");
        List<Menu> menuList = this.menuMapperExt.selectByExample(example);
        
        List<ZTreeNode> resultList = new ArrayList<ZTreeNode>();
        if (menuList != null && !menuList.isEmpty()) {
            for (Menu menu : menuList) {
                ZTreeNode node = new ZTreeNode();
                node.setId(String.valueOf(menu.getId()));
                node.setName(menu.getMenuname());
                node.setpId(String.valueOf(menu.getParentId()));
                node.setParent(true);
                resultList.add(node);
            }
        }
        return resultList;
    }
    
    /**
     * 根据用户和系统ID查询菜单信息
     * @param userid
     * @param systemid
     * @return
     */
    public List<Resource> queryMenuResourceByUserAndSysid(Long userid, Long systemid) {
        List<Resource> dataList = this.menuMapperExt.selectByUserAndSystemid(userid, systemid);
        if (dataList == null || dataList.isEmpty()) {
            return dataList;
        }
        
        Map<Long, Resource> map = new HashMap<>((int)(dataList.size() * 1.5));
        List<Resource> resultList = new ArrayList<Resource>();
        for (Resource data : dataList) {
            map.put(data.getId(), data);
            if (data.getParentid() == null || data.getParentid() == 0) {
                resultList.add(data);
            }
        }
        
        for (Resource data : dataList) {
            if (data.getParentid() != null && data.getParentid() != 0) {
                Resource parent = map.get(data.getParentid());
                if (parent != null) {
                    parent.addChild(data);
                }
            }
        }
        return resultList;
    }
    
    /**
     * 根据菜单ID查询菜单信息
     * @param id
     * @return
     */
    public Menu queryMenuById(Long id) {
        return this.menuMapperExt.selectByPrimaryKey(id);
    }
    
    /**
     * 根据系统ID查询该系统下所有的菜单信息
     * @param systemid
     * @return
     */
    public List<Menu> queryBySystemid(Long systemid) {
        MenuExample example = new MenuExample();
        example.createCriteria().andSystemIdEqualTo(systemid);
        return this.menuMapperExt.selectByExample(example);
    }
    
    /**
     * 插入菜单数据
     * @param record
     * @return
     */
    public boolean insert(Menu record) {
        if (record.getParentId() != null && record.getParentId() > 0) {
            Menu parent = this.menuMapperExt.selectByPrimaryKey(record.getParentId());
            record.setMenucode(parent.getMenucode() + "-" + record.getMenucode());
        }
        
        record.setCreatetime(new Date());
        record.setUpdatetime(record.getCreatetime());
        int count = this.menuMapperExt.insert(record);
        return count > 0;
    }
    
    /**
     * 更新菜单数据
     * @param record
     * @return
     */
    public boolean update(Menu record) {
        if (record.getParentId() != null && record.getParentId() > 0) {
            Menu parent = this.menuMapperExt.selectByPrimaryKey(record.getParentId());
            record.setMenucode(parent.getMenucode() + "-" + record.getMenucode());
        }
        
        record.setUpdatetime(new Date());
        int count = this.menuMapperExt.updateByPrimaryKeySelective(record);
        return count > 0;
    }
    
    /**
     * 更新菜单数据状态
     * @param record
     * @return
     */
    public boolean updateStatus(Menu record) {
        Menu menu = new Menu();
        menu.setId(record.getId());
        menu.setStatus(record.getStatus());
        int count = this.menuMapperExt.updateByPrimaryKeySelective(menu);
        return count > 1;
    }
    
    /**
     * 删除菜单数据
     * @param menuId
     * @return
     */
    public boolean delete(Long menuId) {
        // 删除关联的菜单项数据
        List<MenuItem> itemList = this.menuItemService.queryByMenuid(menuId);
        if (itemList != null && !itemList.isEmpty()) {
            for (MenuItem item : itemList) {
                this.menuItemService.delete(item.getId());
            }
        }
        
        // 删除菜单权限数据
        this.roleMenuMapperExt.deleteByMenuid(menuId);
        
        // 删除菜单数据
        this.menuMapperExt.deleteByPrimaryKey(menuId);
        return true;
    }
}
