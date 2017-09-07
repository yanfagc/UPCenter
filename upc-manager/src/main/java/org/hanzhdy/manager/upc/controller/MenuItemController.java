package org.hanzhdy.manager.upc.controller;

import com.alibaba.fastjson.JSON;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.hanzhdy.manager.support.bean.SessionUser;
import org.hanzhdy.manager.support.constants.resp.RespResult;
import org.hanzhdy.manager.support.controller.ApplicationController;
import org.hanzhdy.manager.upc.model.Menu;
import org.hanzhdy.manager.upc.model.MenuItem;
import org.hanzhdy.manager.upc.service.MenuItemService;
import org.hanzhdy.manager.upc.service.MenuService;
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
 * @description 菜单项Controller
 * @author H.CAAHN
 * @createtime 2016年6月29日 下午9:20:02
 */
@Controller
@RequestMapping("/basic/menuitem")
public class MenuItemController extends ApplicationController {
    @Autowired
    private MenuItemService     menuItemService;
    
    @Autowired
    private MenuService         menuService;
    
    private static final Logger logger = LoggerFactory.getLogger(MenuItemController.class);
    
    /**
     * 跳转到编辑页面
     * @param id
     * @param model
     * @param request
     * @return
     */
    @RequiresPermissions("basic:menuitem:edit")
    @RequestMapping(value = "toEdit", method = RequestMethod.GET)
    public String toEdit(Long id, @RequestParam("menuid") Long menuid, Model model, HttpServletRequest request) {
        try {
            Menu menu = this.menuService.queryMenuById(menuid);
            if (menu == null) {
                return redirect(REDIRECT_404);
            }
            
            model.addAttribute("menu", menu);
            if (id != null && id > 0) {
                MenuItem record = menuItemService.queryMenuItemById(id);
                if (record.getItemcode().startsWith(menu.getMenucode() + "-")) {
                    record.setItemcode(record.getItemcode().substring(menu.getMenucode().length() + 1));
                }
                model.addAttribute("record", record);
            }
        }
        catch (Exception ex) {
            logger.error("跳转到菜单项编辑页面失败，未找到数据:{}", id);
            throw ex;
        }
        return "/basic/menu/menuitem-edit";
    }
    
    /**
     * 处理保存菜单项信息请求
     * @param record
     * @param request
     * @return
     */
    @RequiresPermissions("basic:menuitem:edit")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public Object save(MenuItem record, HttpServletRequest request) {
        SessionUser user = super.getSessionUser(request);
        try {
            // 执行新增或更新操作
            boolean result = false;
            if (record.getId() == null) {
                record.setCreator(user.getId());
                result = this.menuItemService.insert(record);
            }
            else {
                record.setUpdater(user.getId());
                result = this.menuItemService.update(record);
            }
            
            // 处理返回结果
            return RespResult.create(result ? respCode.SUCCESS : respCode.SAVE_NORECORD);
        }
        catch (Exception ex) {
            logger.error("保存菜单项信息失败，数据参数：" + JSON.toJSONString(record), ex);
            return RespResult.create(respCode.ERROR_EXCEPTION);
        }
    }
    
    /**
     * 处理更新菜单项数据状态请求
     * @param record
     * @param request
     * @return
     */
    @RequiresPermissions("basic:menuitem:edit")
    @RequestMapping(value = "updateStatus", method = RequestMethod.POST)
    @ResponseBody
    public Object updateStatus(MenuItem record, HttpServletRequest request) {
        SessionUser user = super.getSessionUser(request);
        try {
            record.setUpdater(user.getId());
            this.menuItemService.updateStatus(record);
            return RespResult.create(respCode.SUCCESS);
        }
        catch (Exception ex) {
            logger.error("更新菜单项数据状态失败，数据参数：" + JSON.toJSONString(record), ex);
            return RespResult.create(respCode.ERROR_EXCEPTION);
        }
    }
}
