package org.hanzhdy.manager.upc.controller;

import com.alibaba.fastjson.JSON;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.hanzhdy.manager.support.bean.SessionUser;
import org.hanzhdy.manager.support.constants.resp.ApiResult;
import org.hanzhdy.manager.support.controller.ApplicationController;
import org.hanzhdy.manager.upc.controller.params.RoleGroupParams;
import org.hanzhdy.manager.upc.model.RoleGroup;
import org.hanzhdy.manager.upc.service.RoleGroupService;
import org.hanzhdy.web.bean.DatatableResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @description 角色类型控制器
 * @author H.CAAHN
 * @createtime 2016年10月19日 下午10:57:31
 */
@Controller
@RequestMapping("/basic/group")
public class RoleGroupController extends ApplicationController {
    /** 日志对象 */
    private static final Logger logger = LoggerFactory.getLogger(RoleGroupController.class);
    
    @Autowired
    private RoleGroupService    roleGroupService;
    
    /**
     * 转到角色分组管理列表页面
     * @return
     */
    @RequiresPermissions("basic:group:list")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String toList() {
        return "/basic/rolegroup/rolegroup-list";
    }
    
    /**
     * 请求获取角色分组列表数据
     * @param params
     * @param request
     * @return
     */
    @RequiresPermissions("basic:group:list")
    @RequestMapping(value = "dataList", method = RequestMethod.POST)
    @ResponseBody
    public Object dataList(RoleGroupParams params, HttpServletRequest request) {
        DatatableResult dataResult;
        try {
            dataResult = roleGroupService.queryAsDatatableResult(params);
        }
        catch (Exception ex) {
            logger.error("查询角色分组数据失败，查询参数：" + JSON.toJSONString(params), ex);
            dataResult = super.getEmptyDatatableResult();
        }
        return JSON.toJSONString(dataResult);
    }
    
    /**
     * 跳转到编辑页面
     * @param id
     * @param model
     * @param request
     * @return
     */
    @RequiresPermissions("basic:group:edit")
    @RequestMapping(value = "toEdit", method = RequestMethod.GET)
    public String toEdit(Long id, Model model, HttpServletRequest request) {
        // 查询角色分组信息
        if (id != null && id > 0) {
            RoleGroup record = roleGroupService.queryById(id);
            if (record != null) {
                model.addAttribute("record", record);
                return "/basic/rolegroup/rolegroup-edit";
            }
            return redirect(REDIRECT_404);
        }
        return "/basic/rolegroup/rolegroup-edit";
    }
    
    /**
     * 处理保存角色分组信息请求
     * @param record
     * @param request
     * @return
     */
    @RequiresPermissions("basic:group:edit")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public Object saveUser(RoleGroup record, HttpServletRequest request) {
        SessionUser user = super.getSessionUser(request);
        try {
            RoleGroup old = this.roleGroupService.queryByGroupcode(record.getGroupcode());
            
            // 执行新增或更新操作
            boolean result = false;
            if (record.getId() == null) {
                if (old != null) {
                    return ApiResult.SAVE_DUPLICATE;
                }
                record.setCreator(user.getId());
                result = this.roleGroupService.insert(record);
            }
            else {
                if (old != null && old.getId().longValue() != record.getId().longValue()) {
                    return ApiResult.SAVE_DUPLICATE;
                }
                record.setUpdater(user.getId());
                result = this.roleGroupService.update(record);
            }
            
            // 处理返回结果
            return result ? ApiResult.SUCCESS : ApiResult.SAVE_NORECORD;
        }
        catch (Exception ex) {
            logger.error("保存角色分组信息失败，数据参数：" + JSON.toJSONString(record), ex);
            return ApiResult.ERROR_EXCEPTION;
        }
    }
    
    /**
     * 处理删除角色分组数据请求
     * @param id
     * @param request
     * @return
     */
    @RequiresPermissions("basic:group:delete")
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public Object delete(@RequestParam("id") Long id, HttpServletRequest request) {
        try {
            this.roleGroupService.delete(id);
            return ApiResult.SUCCESS;
        }
        catch (Exception ex) {
            logger.error("删除角色分组数据失败，ID：" + id, ex);
            return ApiResult.ERROR_EXCEPTION;
        }
    }
}
