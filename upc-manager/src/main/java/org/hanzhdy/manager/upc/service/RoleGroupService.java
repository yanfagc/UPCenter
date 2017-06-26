package org.hanzhdy.manager.upc.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hanzhdy.manager.support.service.AbstractUpcService;
import org.hanzhdy.manager.upc.controller.params.RoleGroupParams;
import org.hanzhdy.manager.upc.mapper.RoleGroupMapperExt;
import org.hanzhdy.manager.upc.mapper.RoleMapperExt;
import org.hanzhdy.manager.upc.model.RoleGroup;
import org.hanzhdy.manager.upc.model.RoleGroupExample;
import org.hanzhdy.web.bean.DatatableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description 角色分组Service
 * @author H.CAAHN
 * @createtime 2016年11月15日 下午9:15:31
 */
@Service
public class RoleGroupService extends AbstractUpcService {
    @Autowired
    private RoleGroupMapperExt roleGroupMapperExt;
    
    @Autowired
    private RoleMapperExt      roleMapperExt;
    
    /**
     * 分页查询角色分组信息，并按条件返回符合datatable数据格式的信息
     * @param params
     * @return
     */
    public DatatableResult queryAsDatatableResult(RoleGroupParams params) {
        // 构造查询条件
        Map<String, Object> search = new HashMap<String, Object>();
        search.put("page", params.createPage());
        if (StringUtils.isNotBlank(params.getSearchkey())) {
            search.put("searchkey", "%" + params.getSearchkey() + "%");
        }
        if (StringUtils.isNotBlank(params.getGroupcode())) {
            search.put("groupcode", "%" + params.getGroupcode() + "%");
        }
        if (StringUtils.isNotBlank(params.getGroupname())) {
            search.put("groupname", "%" + params.getGroupname() + "%");
        }
        
        // 查询数据
        int count = this.roleGroupMapperExt.countAsList(search);
        List<RoleGroup> data = this.roleGroupMapperExt.selectAsList(search);
        
        // 设置返回结果
        DatatableResult result = new DatatableResult();
        result.setTotal(count);
        result.setAaData(data);
        return result;
    }
    
    /**
     * 根据ID号查询角色分组信息
     * @param id
     * @return
     */
    public RoleGroup queryById(Long id) {
        return this.roleGroupMapperExt.selectByPrimaryKey(id);
    }
    
    /**
     * 查询所有角色组信息
     * @return
     */
    public List<RoleGroup> queryAllList() {
        RoleGroupExample example = new RoleGroupExample();
        return this.roleGroupMapperExt.selectByExample(example);
    }
    
    /**
     * 根据角色分组编码查询角色分组信息
     * @param groupcode
     * @return
     */
    public RoleGroup queryByGroupcode(String groupcode) {
        RoleGroupExample example = new RoleGroupExample();
        example.createCriteria().andGroupcodeEqualTo(groupcode);
        List<RoleGroup> resultList = this.roleGroupMapperExt.selectByExample(example);
        if (resultList != null && !resultList.isEmpty()) {
            return resultList.get(0);
        }
        return null;
    }
    
    /**
     * 插入新的角色分组信息
     * @param record
     * @return
     */
    public boolean insert(RoleGroup record) {
        record.setCreatetime(new Date());
        record.setUpdatetime(record.getCreatetime());
        int count = this.roleGroupMapperExt.insert(record);
        return count > 0;
    }
    
    /**
     * 更新角色分组信息
     * @param record
     * @return
     */
    public boolean update(RoleGroup record) {
        record.setUpdatetime(new Date());
        int count = this.roleGroupMapperExt.updateByPrimaryKeySelective(record);
        return count > 0;
    }
    
    /**
     * 根据指定的ID删除角色分组<br>
     * 该角色分组中的所有角色的GroupId值将设置为0
     * @param id
     * @return
     */
    public boolean delete(Long id) {
        this.roleMapperExt.updateGroupId2ZeroByGroupId(id);
        this.roleGroupMapperExt.deleteByPrimaryKey(id);
        return true;
    }
}
