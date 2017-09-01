package org.hanzhdy.manager.upc.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.hanzhdy.manager.support.service.AbstractUpcService;
import org.hanzhdy.manager.upc.controller.params.RoleParams;
import org.hanzhdy.manager.upc.mapper.*;
import org.hanzhdy.manager.upc.model.*;
import org.hanzhdy.manager.upc.vo.Resource;
import org.hanzhdy.manager.upc.vo.RoleVo;
import org.hanzhdy.web.bean.DatatableResult;
import org.hanzhdy.web.bean.ZTreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @description 角色管理Service
 * @author H.CAAHN
 * @createtime 2016年11月15日 下午9:15:31
 */
@Service
public class RoleService extends AbstractUpcService {
    @Autowired
    private MenuMapperExt         menuMapperExt;
    
    @Autowired
    private RoleMapperExt         roleMapperExt;
    
    @Autowired
    private RoleGroupMapperExt    roleGroupMapperExt;
    
    @Autowired
    private RoleMenuMapperExt     roleMenuMapperExt;
    
    @Autowired
    private RoleMenuItemMapperExt roleMenuItemMapperExt;
    
    /**
     * 分页查询角色信息，并按条件返回符合datatable数据格式的信息
     * @param params
     * @return
     */
    public DatatableResult queryAsDatatableResult(RoleParams params) {
        // 构造查询条件
        Map<String, Object> search = new HashMap<String, Object>();
        search.put("page", params.createPage());
        if (StringUtils.isNotBlank(params.getSearchkey())) {
            search.put("searchkey", "%" + params.getSearchkey() + "%");
        }
        if (StringUtils.isNotBlank(params.getRolecode())) {
            search.put("rolecode", "%" + params.getRolecode() + "%");
        }
        if (StringUtils.isNotBlank(params.getRolename())) {
            search.put("rolename", "%" + params.getRolename() + "%");
        }
        if (params.getGroupid() != null) {
            search.put("groupid", params.getGroupid());
        }
        if (params.getSystemId() != null) {
            search.put("sysid", params.getSystemId());
        }
        if (params.getStatus() != null) {
            search.put("status", params.getStatus());
        }
        
        // 查询数据
        int count = this.roleMapperExt.countAsList(search);
        List<RoleVo> data = this.roleMapperExt.selectAsList(search);
        
        // 设置返回结果
        DatatableResult result = new DatatableResult();
        result.setTotal(count);
        result.setAaData(data);
        return result;
    }

    /**
     * 角色管理页面，设置角色菜单功能，查询所有菜单信息
     * @param roleid
     * @param systemid
     * @return
     */
    public List<ZTreeNode> queryRoleMenuById(Long roleid, Long systemid) {
        List<ZTreeNode> dataList = this.menuMapperExt.selectAsZTreeNodeByRoleAndSystemid(roleid, systemid);
        List<ZTreeNode> result = new ArrayList<ZTreeNode>();
        if (dataList != null && !dataList.isEmpty()) {
            Map<String, ZTreeNode> map = new HashMap<String, ZTreeNode>();
            for (ZTreeNode node : dataList) {
                if (node.isParent()) {
                    if (StringUtils.isBlank(node.getpId()) || "0".equals(node.getpId())) {
                        result.add(node);
                    }
                    map.put(node.getId(), node);
                }
            }
            for (ZTreeNode node : dataList) {
                ZTreeNode p = map.get(node.getpId());
                if (p != null) {
                    p.addChild(node);
                }
            }
        }
        
        return result;
    }

    /**
     * 角色管理页面，设置角色资源功能，查询指定角色关联的所有菜单数据
     * @param roleid
     * @param systemid
     * @return
     */
    public List<ZTreeNode> queryRoleMenuByIdForSettingItem(Long roleid, Long systemid) {
        List<ZTreeNode> dataList = this.menuMapperExt.selectAsZTreeNodeByRoleAndSystemidForSettingItem(roleid, systemid);
        List<ZTreeNode> result = new ArrayList<ZTreeNode>();
        if (dataList != null && !dataList.isEmpty()) {
            Map<String, ZTreeNode> map = new HashMap<String, ZTreeNode>();
            for (ZTreeNode node : dataList) {
                if (node.isParent()) {
                    if (StringUtils.isBlank(node.getpId()) || "0".equals(node.getpId())) {
                        result.add(node);
                    }
                    map.put(node.getId(), node);
                }
            }
            for (ZTreeNode node : dataList) {
                ZTreeNode p = map.get(node.getpId());
                if (p != null) {
                    p.addChild(node);
                }
            }
        }

        return result;
    }

    /**
     * 角色管理页面，设置角色资源功能，查询指定角色和菜单关联的权限数据
     * @param roleid
     * @param menuid
     * @return
     */
    public DatatableResult queryRoleResourceForSettingItem(Long roleid, Long menuid) {
        List<Resource> dataList = this.roleMenuItemMapperExt.selectForSettingRoleResource(roleid, menuid);
        DatatableResult result = new DatatableResult();
        result.setTotal(dataList.size());
        result.setAaData(dataList);
        return result;
    }

    /**
     * 用户管理页面，设置用户角色功能，查询所有角色信息
     * @param userid
     * @return
     */
    public List<ZTreeNode> queryRoleForUserSetting(Long userid) {
        List<RoleGroup> groupList = this.roleGroupMapperExt.selectByExample(new RoleGroupExample());
        if (groupList == null || groupList.isEmpty()) {
            return null;
        }
        
        Map<Long, ZTreeNode> map = new HashMap<>((int)(groupList.size() * 1.5));
        List<ZTreeNode> resultList = new ArrayList<>(groupList.size());
        for (RoleGroup group : groupList) {
            ZTreeNode node = new ZTreeNode();
            node.setId("g_" + group.getId());
            node.setName(group.getGroupname());
            node.setParent(true);
            node.setOpen(true);
            resultList.add(node);
            map.put(group.getId(), node);
        }
    
        List<RoleVo> roleList = this.roleMapperExt.selectRolesForUserSetting(userid);
        if (roleList != null && !roleList.isEmpty()) {
            for (RoleVo role : roleList) {
                ZTreeNode parent = map.get(role.getGroupid());
                if (parent == null) {
                    continue;
                }
                ZTreeNode node = new ZTreeNode();
                node.setId(String.valueOf(role.getId()));
                node.setName(role.getRolename());
                node.setChecked(role.isChecked());
                node.setpId("g_" + role.getGroupid());
                parent.addChild(node);
            }
        }
        
        return resultList;
    }
    
    /**
     * 根据ID号查询角色信息
     * @param id
     * @return
     */
    public Role queryById(Long id) {
        return this.roleMapperExt.selectByPrimaryKey(id);
    }
    
    /**
     * 根据角色编码查询角色信息
     * @param rolecode
     * @return
     */
    public Role queryByRolecode(String rolecode) {
        RoleExample example = new RoleExample();
        example.createCriteria().andRolecodeEqualTo(rolecode);
        List<Role> resultList = this.roleMapperExt.selectByExample(example);
        if (resultList != null && !resultList.isEmpty()) {
            return resultList.get(0);
        }
        return null;
    }
    
    /**
     * 根据用户和系统ID查询该用于在系统中所拥有的角色信息
     * @param userid
     * @param systemid
     * @return
     */
    public List<Role> queryByUserAndSysId(Long userid, Long systemid) {
        return this.roleMapperExt.selectByUserAndSysId(userid, systemid);
    }
    
    /**
     * 插入新的角色信息
     * @param record
     * @return
     */
    public boolean insert(Role record) {
        record.setCreatetime(new Date());
        record.setUpdatetime(record.getCreatetime());
        int count = this.roleMapperExt.insert(record);
        return count > 0;
    }
    
    /**
     * 更新角色信息
     * @param record
     * @return
     */
    public boolean update(Role record) {
        Role old = this.roleMapperExt.selectByPrimaryKey(record.getId());
        // 一个角色只能关联一个接入系统中的菜单
        if (old.getSystemId() != null && old.getSystemId().longValue() != record.getSystemId()) {
            this.deleteRoleMenus(record.getId());
            this.deleteRoleMenuItems(record.getId(), null);
        }
        
        record.setUpdatetime(new Date());
        int count = this.roleMapperExt.updateByPrimaryKeySelective(record);
        return count > 0;
    }
    
    /**
     * 更新角色状态
     * @param record
     * @return
     */
    public boolean updateStatus(Role record) {
        Role role = new Role();
        role.setId(record.getId());
        role.setStatus(record.getStatus());
        int count = this.roleMapperExt.updateByPrimaryKeySelective(role);
        return count > 0;
    }
    
    /**
     * 更新角色菜单关联信息
     * @param id
     * @param menus
     * @return
     */
    public boolean updateRoleMenu(Long id, String menus) {
        this.deleteRoleMenus(id);
        if (StringUtils.isNotBlank(menus)) {
            List<String> array = JSON.parseArray(menus, String.class);
            if (array != null && !array.isEmpty()) {
                for (String _menuid : array) {
                    try {
                        RoleMenuKey r = new RoleMenuKey();
                        r.setRoleId(id);
                        r.setMenuId(Long.valueOf(_menuid.substring(2)));
                        this.roleMenuMapperExt.insert(r);
                    }
                    catch (NumberFormatException ex) {

                    }
                }
            }
        }

        return true;
    }

    /**
     * 更新角色菜单项关联信息
     * @param id
     * @param menuid
     * @param items
     * @return
     */
    public boolean updateRoleItem(Long id, Long menuid, String items) {
        this.deleteRoleMenuItems(id, menuid);
        if (StringUtils.isNotBlank(items)) {
            List<String> array = JSON.parseArray(items, String.class);
            if (array != null && !array.isEmpty()) {
                for (String _itemid : array) {
                    try {
                        RoleMenuItemKey key = new RoleMenuItemKey();
                        key.setRoleId(id);
                        key.setItemId(Long.valueOf(_itemid.substring(3)));
                        this.roleMenuItemMapperExt.insert(key);
                    }
                    catch (NumberFormatException ex) {

                    }
                }
            }
        }
        return true;
    }
    
    /**
     * 根据指定的ID删除角色<br>
     * @param id
     * @return
     */
    public boolean delete(Long id) {
        this.deleteRoleMenus(id);
        this.deleteRoleMenuItems(id, null);
        this.roleMapperExt.deleteByPrimaryKey(id);
        return true;
    }
    
    /**
     * 根据指定的角色ID，删除其绑定的菜单数据
     * @param id
     */
    private void deleteRoleMenus(Long id) {
        RoleMenuExample rme = new RoleMenuExample();
        rme.createCriteria().andRoleIdEqualTo(id);
        roleMenuMapperExt.deleteByExample(rme);
    }

    /**
     * 根据指定的角色ID，删除其绑定的菜单项数据<br/>
     * 如果菜单ID不为空，则只删除属于该菜单的菜单项数据<br/>
     * 反之则删除该角色绑定的所有菜单项信息
     * @param id
     * @param menuid
     */
    private void deleteRoleMenuItems(Long id, Long menuid) {
        if (menuid != null) {
            this.roleMenuItemMapperExt.deleteByRoleAndMenuid(id, menuid);
        }
        else {
            RoleMenuItemExample rmie = new RoleMenuItemExample();
            rmie.createCriteria().andRoleIdEqualTo(id);
            this.roleMenuItemMapperExt.deleteByExample(rmie);
        }
    }
}
