package org.hanzhdy.manager.upc.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hanzhdy.manager.support.service.AbstractUpcService;
import org.hanzhdy.manager.upc.controller.params.RoleParams;
import org.hanzhdy.manager.upc.mapper.MenuMapperExt;
import org.hanzhdy.manager.upc.mapper.RoleMapperExt;
import org.hanzhdy.manager.upc.mapper.RoleMenuItemMapperExt;
import org.hanzhdy.manager.upc.mapper.RoleMenuMapperExt;
import org.hanzhdy.manager.upc.model.Role;
import org.hanzhdy.manager.upc.model.RoleExample;
import org.hanzhdy.manager.upc.model.RoleMenuExample;
import org.hanzhdy.manager.upc.model.RoleMenuItemExample;
import org.hanzhdy.manager.upc.model.RoleMenuItemKey;
import org.hanzhdy.manager.upc.model.RoleMenuKey;
import org.hanzhdy.manager.upc.vo.RoleVo;
import org.hanzhdy.web.bean.DatatableResult;
import org.hanzhdy.web.bean.ZTreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

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
    
    public List<ZTreeNode> queryRoleResourceById(Long roleid, Long systemid) {
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
     * 根据ID号查询角色信息
     * @param id
     * @return
     */
    public Role queryById(Long id) {
        return this.roleMapperExt.selectByPrimaryKey(id);
    }
    
    /**
     * 根据角色编码查询角色信息
     * @param groupcode
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
            this.deleteRoleResource(record.getId());
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
     * 更新角色菜单、角色菜单项关联信息
     * @param id
     * @param resources
     * @return
     */
    public boolean updateRoleResource(Long id, String resources) {
        this.deleteRoleResource(id);
        JSONArray array = JSON.parseArray(resources);
        if (array != null && !array.isEmpty()) {
            for (int i = 0, s = array.size(); i < s; i++) {
                JSONObject obj = array.getJSONObject(i);
                try {
                    // 菜单
                    if ("m".equalsIgnoreCase(obj.getString("type"))) {
                        Long mid = Long.valueOf(obj.getString("id").substring(2));
                        RoleMenuKey r = new RoleMenuKey();
                        r.setRoleId(id);
                        r.setMenuId(mid);
                        this.roleMenuMapperExt.insert(r);
                    }
                    // 菜单项
                    else {
                        Long mid = Long.valueOf(obj.getString("id").substring(2));
                        RoleMenuItemKey r = new RoleMenuItemKey();
                        r.setRoleId(id);
                        r.setItemId(mid);
                        this.roleMenuItemMapperExt.insert(r);
                    }
                }
                catch (NumberFormatException ex) {
                    
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
        this.deleteRoleResource(id);
        this.roleMapperExt.deleteByPrimaryKey(id);
        return true;
    }
    
    /**
     * 根据指定的角色ID，删除角色资源（角色菜单、角色菜单项信息）
     * @param id
     */
    private void deleteRoleResource(Long id) {
        RoleMenuExample rme = new RoleMenuExample();
        rme.createCriteria().andRoleIdEqualTo(id);
        roleMenuMapperExt.deleteByExample(rme);
        
        RoleMenuItemExample rmie = new RoleMenuItemExample();
        rmie.createCriteria().andRoleIdEqualTo(id);
        roleMenuItemMapperExt.deleteByExample(rmie);
    }
}
