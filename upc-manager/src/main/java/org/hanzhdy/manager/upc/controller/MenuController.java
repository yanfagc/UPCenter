package org.hanzhdy.manager.upc.controller;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.hanzhdy.manager.support.bean.SessionUser;
import org.hanzhdy.manager.support.constants.resp.RespResult;
import org.hanzhdy.manager.support.controller.ApplicationController;
import org.hanzhdy.manager.support.enums.MenuIcon;
import org.hanzhdy.manager.upc.controller.params.MenuParams;
import org.hanzhdy.manager.upc.model.AccessSystem;
import org.hanzhdy.manager.upc.model.Menu;
import org.hanzhdy.manager.upc.service.AccessSystemService;
import org.hanzhdy.manager.upc.service.MenuItemService;
import org.hanzhdy.manager.upc.service.MenuService;
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

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @description 菜单资源管理Controller
 * @author H.CAAHN
 * @createtime 2016年1月12日 下午10:47:26
 */
@Controller
@RequestMapping("/basic/menu")
public class MenuController extends ApplicationController {
    @Autowired
    private MenuService         menuService;
    
    @Autowired
    private MenuItemService     menuItemService;
    
    @Autowired
    private AccessSystemService accessSystemService;
    
    /** 日志对象 */
    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
    
    /**
     * 转到菜单资源列表页面
     * @return
     */
    @RequiresPermissions("basic:menu:list")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String toList(Model model, @RequestParam("systemid") Long systemid) {
        try {
            AccessSystem system = this.accessSystemService.queryById(systemid);
            List<ZTreeNode> nodeList = this.menuService.queryMenuAsZTreeNode(0l, systemid);
            ZTreeNode treeNode = new ZTreeNode();
            treeNode.setpId("0");
            treeNode.setId("sys-" + system.getId());
            treeNode.setName(system.getSysname());
            treeNode.setIsParent(true);
            treeNode.setChildren(nodeList);
            treeNode.setOpen(true);
            model.addAttribute("nodeList", treeNode);
            model.addAttribute("systemid", systemid);
            model.addAttribute("system", system);
            return "/basic/menu/menu-list";
        }
        catch (BizException ex) {
            logger.error("转到菜单资源列表页面失败！错误信息：[{}, {}]", ex.getCode(), ex.getMsg());
            throw ex;
        }
        catch (Exception ex) {
            logger.error("转到菜单资源列表页面失败！", ex);
            throw ex;
        }
    }
    
    /**
     * 获取ZTree数据
     * @param pid
     * @return
     */
    @RequiresPermissions("basic:menu:list")
    @RequestMapping(value = "zTreeData", method = RequestMethod.POST)
    @ResponseBody
    public Object zTreeData(String pid, @RequestParam("systemid") Long systemid) {
        try {
            Long parentId = 0l;
            if (StringUtils.isNotBlank(pid) && !pid.startsWith("sys-")) {
                try {
                    parentId = Long.valueOf(pid);
                }
                catch (Exception ex) {
                    logger.warn("获取ZTree数据，pid不能转换为数字：{}", pid);
                }
            }
            List<ZTreeNode> nodeList = this.menuService.queryMenuAsZTreeNode(parentId, systemid);
            return nodeList;
        }
        catch (Exception ex) {
            logger.error("获取ZTree数据失败，父菜单ID：" + pid, ex);
            return "[]";
        }
    }
    
    /**
     * 请求获取菜单列表数据
     * @param params
     * @param request
     * @return
     */
    @RequiresPermissions("basic:menu:list")
    @RequestMapping(value = "dataList", method = RequestMethod.POST)
    @ResponseBody
    public Object dataList(MenuParams params, HttpServletRequest request) {
        DatatableResult dataResult;
        try {
            if ("item".equalsIgnoreCase(params.getShowtype())) {
                dataResult = this.menuItemService.queryAsDatatableResult(params);
            }
            else {
                dataResult = this.menuService.queryAsDatatableResult(params);
            }
        }
        catch (BizException ex) {
            logger.error("查询菜单数据失败，查询参数：{}, 错误信息：[{}, {}]", JSON.toJSONString(params), ex.getCode(), ex.getMsg());
            dataResult = super.getEmptyDatatableResult();
        }
        catch (Exception ex) {
            logger.error("查询菜单数据失败，查询参数：" + JSON.toJSONString(params), ex);
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
    @RequiresPermissions("basic:menu:edit")
    @RequestMapping(value = "toEdit", method = RequestMethod.GET)
    public String toEdit(Long id, Long parentid, @RequestParam("systemid") Long systemid, Model model,
            HttpServletRequest request) {
        try {
            AccessSystem system = accessSystemService.queryById(systemid);
            model.addAttribute("system", system);
            model.addAttribute("iconList", MenuIcon.values());
            
            if (id != null && id > 0) {
                Menu record = menuService.queryMenuById(id);
                Menu parent = null;
                if (parentid == null) {
                    if (record.getParentId() != null && record.getParentId() > 0) {
                        parent = menuService.queryMenuById(record.getParentId());
                    }
                }
                else if (record.getParentId() != null && record.getParentId().longValue() == parentid.longValue()) {
                    parent = menuService.queryMenuById(record.getParentId());
                }
                else {
                    return redirect(REDIRECT_404);
                }
                
                if (parent != null && record.getMenucode().indexOf(parent.getMenucode() + "-") == 0) {
                    record.setMenucode(record.getMenucode().substring(parent.getMenucode().length() + 1));
                }
                model.addAttribute("parent", parent);
                model.addAttribute("record", record);
            }
            else if (parentid != null && parentid > 0) {
                Menu parent = menuService.queryMenuById(parentid);
                model.addAttribute("parent", parent);
            }
        }
        catch (Exception ex) {
            logger.error("跳转到菜单编辑页面失败，未找到数据:{}", id);
            throw ex;
        }
        
        model.addAttribute("systemid", systemid);
        return "/basic/menu/menu-edit";
    }
    
    /**
     * 处理保存菜单信息请求
     * @param record
     * @param request
     * @return
     */
    @RequiresPermissions("basic:menu:edit")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public Object save(Menu record, HttpServletRequest request) {
        SessionUser user = super.getSessionUser(request);
        try {
            // 执行新增或更新操作
            boolean result = false;
            if (record.getId() == null) {
                record.setCreator(user.getId());
                result = this.menuService.insert(record);
            }
            else {
                record.setUpdater(user.getId());
                result = this.menuService.update(record);
            }
            
            // 处理返回结果
            return RespResult.create(result ? respCode.SUCCESS : respCode.SAVE_NORECORD);
        }
        catch (BizException ex) {
            logger.error("保存菜单信息失败，数据参数：{}, 错误信息：[{}, {}]", JSON.toJSONString(record), ex.getCode(), ex.getMsg());
            return RespResult.create(ex.getCode(), ex.getMsg());
        }
        catch (Exception ex) {
            logger.error("保存菜单信息失败，数据参数：" + JSON.toJSONString(record), ex);
            return RespResult.create(respCode.ERROR_EXCEPTION);
        }
    }
    
    /**
     * 处理更新菜单数据状态请求
     * @param record
     * @param request
     * @return
     */
    @RequiresPermissions("basic:menu:edit")
    @RequestMapping(value = "updateStatus", method = RequestMethod.POST)
    @ResponseBody
    public Object updateStatus(Menu record, HttpServletRequest request) {
        SessionUser user = super.getSessionUser(request);
        try {
            record.setUpdater(user.getId());
            this.menuService.updateStatus(record);
            return RespResult.create(respCode.SUCCESS);
        }
        catch (Exception ex) {
            logger.error("更新菜单数据状态失败，数据参数：" + JSON.toJSONString(record), ex);
            return RespResult.create(respCode.ERROR_EXCEPTION);
        }
    }
}
