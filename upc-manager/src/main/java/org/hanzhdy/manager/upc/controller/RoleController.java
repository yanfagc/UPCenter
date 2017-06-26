package org.hanzhdy.manager.upc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hanzhdy.manager.support.bean.SessionUser;
import org.hanzhdy.manager.support.constants.resp.RespResult;
import org.hanzhdy.manager.support.controller.ApplicationController;
import org.hanzhdy.manager.support.enums.CommonStatus;
import org.hanzhdy.manager.upc.controller.params.RoleParams;
import org.hanzhdy.manager.upc.model.AccessSystem;
import org.hanzhdy.manager.upc.model.Role;
import org.hanzhdy.manager.upc.model.RoleGroup;
import org.hanzhdy.manager.upc.service.AccessSystemService;
import org.hanzhdy.manager.upc.service.RoleGroupService;
import org.hanzhdy.manager.upc.service.RoleService;
import org.hanzhdy.web.bean.DatatableResult;
import org.hanzhdy.web.bean.ZTreeNode;
import org.hanzhdy.web.throwable.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

/**
 * @description 角色管理
 * @author H.CAAHN
 * @createtime 2017年6月5日 下午8:50:05
 */
@Controller
@RequestMapping("/basic/role")
public class RoleController extends ApplicationController {
    @Autowired
    private RoleService         roleService;
    
    @Autowired
    private RoleGroupService    roleGroupService;
    
    @Autowired
    private AccessSystemService accessSystemService;
    
    /** 日志对象 */
    private static final Logger logger = LoggerFactory.getLogger(RoleController.class);
    
    /**
     * 转到接入系统管理列表页面
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String toList(Model model) {
        try {
            List<AccessSystem> sysList = accessSystemService.queryNormalList();
            List<RoleGroup> groupList = roleGroupService.queryAllList();
            model.addAttribute("sysList", sysList);
            model.addAttribute("groupList", groupList);
            model.addAttribute("statusList", CommonStatus.values());
        }
        catch (Exception ex) {
            logger.error("转到角色管理列表页面失败", ex);
        }
        
        return "/basic/role/role-list";
    }
    
    /**
     * 请求获取角色列表数据
     * @param params
     * @param request
     * @return
     */
    @RequestMapping(value = "dataList", method = RequestMethod.POST)
    @ResponseBody
    public Object dataList(RoleParams params, HttpServletRequest request) {
        try {
            DatatableResult dataResult = roleService.queryAsDatatableResult(params);
            return JSON.toJSONString(dataResult);
        }
        catch (BizException ex) {
            logger.error("查询角色数据失败，查询参数：{}, 错误信息：[{}, {}]", JSON.toJSONString(params), ex.getCode(), ex.getMsg());
        }
        catch (Exception ex) {
            logger.error("查询角色数据失败，查询参数：" + JSON.toJSONString(params), ex);
        }
        return null;
    }
    
    /**
     * 跳转到编辑页面
     * @param id
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "toEdit", method = RequestMethod.GET)
    public String toEdit(Long id, Model model, HttpServletRequest request) {
        // 查询接入系统以及角色分组信息
        List<AccessSystem> sysList = accessSystemService.queryNormalList();
        List<RoleGroup> groupList = roleGroupService.queryAllList();
        model.addAttribute("sysList", sysList);
        model.addAttribute("groupList", groupList);
        model.addAttribute("statusList", CommonStatus.values());
        
        // 查询角色信息
        if (id != null && id > 0) {
            Role record = roleService.queryById(id);
            if (record != null) {
                model.addAttribute("record", record);
                return "/basic/role/role-edit";
            }
            return redirect(REDIRECT_404);
        }
        return "/basic/role/role-edit";
    }
    
    /**
     * 处理保存角色信息请求
     * @param record
     * @param request
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public Object saveUser(Role record, HttpServletRequest request) {
        SessionUser user = super.getSessionUser(request);
        try {
            // 执行新增或更新操作
            boolean result = false;
            if (record.getId() == null) {
                record.setCreator(user.getId());
                result = this.roleService.insert(record);
            }
            else {
                record.setUpdater(user.getId());
                result = this.roleService.update(record);
            }
            
            // 处理返回结果
            return RespResult.create(result ? respCode.SUCCESS : respCode.SAVE_NORECORD);
        }
        catch (BizException ex) {
            logger.error("保存角色信息失败，数据参数：{}, 错误信息：[{}, {}]", JSON.toJSONString(record), ex.getCode(), ex.getMsg());
            return RespResult.create(ex.getCode(), ex.getMsg());
        }
        catch (Exception ex) {
            logger.error("保存角色信息失败，数据参数：" + JSON.toJSONString(record), ex);
            return RespResult.create(respCode.ERROR_EXCEPTION);
        }
    }
    
    /**
     * 跳转到设置角色权限的页面
     * @param roleid
     * @param sysid
     * @return
     */
    @RequestMapping(value = "toSettingResources", method = RequestMethod.GET)
    public String toSettingResources(Model model, @RequestParam("roleid") Long roleid,
            @RequestParam("sysid") Long sysid) {
        List<ZTreeNode> nodeList = this.roleService.queryRoleResourceById(roleid, sysid);
        model.addAttribute("nodeList", nodeList);
        return "/basic/role/role-setting";
    }
    
    /**
     * 根据角色权限信息
     * @param roleid
     * @param resources
     * @return
     */
    @RequestMapping(value = "saveResources", method = RequestMethod.POST)
    @ResponseBody
    public Object saveResources(@RequestParam("roleid") Long roleid, @RequestParam("resources") String resources) {
        try {
            this.roleService.updateRoleResource(roleid, resources);
            return RespResult.create(respCode.SUCCESS);
        }
        catch (BizException ex) {
            logger.error("更新角色权限失败，角色ID：{}, 错误信息：[{}, {}]", roleid, ex.getCode(), ex.getMsg());
            return RespResult.create(ex.getCode(), ex.getMsg());
        }
        catch (Exception ex) {
            logger.error("更新角色权限失败，角色ID：" + roleid, ex);
            return RespResult.create(respCode.ERROR_EXCEPTION);
        }
    }
    
    /**
     * 处理更新角色数据状态请求
     * @param record
     * @param request
     * @return
     */
    @RequestMapping(value = "updateStatus", method = RequestMethod.POST)
    @ResponseBody
    public Object updateStatus(Role record, HttpServletRequest request) {
        SessionUser user = super.getSessionUser(request);
        try {
            record.setUpdater(user.getId());
            this.roleService.updateStatus(record);
            return RespResult.create(respCode.SUCCESS);
        }
        catch (BizException ex) {
            logger.error("更新角色数据状态失败，数据参数：{}, 错误信息：[{}, {}]", JSON.toJSONString(record), ex.getCode(), ex.getMsg());
            return RespResult.create(ex.getCode(), ex.getMsg());
        }
        catch (Exception ex) {
            logger.error("更新角色数据状态失败，数据参数：" + JSON.toJSONString(record), ex);
            return RespResult.create(respCode.ERROR_EXCEPTION);
        }
    }
    
    /**
     * 删除角色信息
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public Object delete(@RequestParam("id") Long id, HttpServletRequest request) {
        try {
            this.roleService.delete(id);
            return RespResult.create(respCode.SUCCESS);
        }
        catch (Exception ex) {
            logger.error("删除角色数据失败，ID：" + id, ex);
            return RespResult.create(respCode.ERROR_EXCEPTION);
        }
    }
}
