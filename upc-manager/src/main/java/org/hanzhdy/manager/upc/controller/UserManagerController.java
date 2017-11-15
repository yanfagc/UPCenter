package org.hanzhdy.manager.upc.controller;

import com.alibaba.fastjson.JSON;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.hanzhdy.manager.settings.engine.EngineContext;
import org.hanzhdy.manager.settings.engine.FormHtml;
import org.hanzhdy.manager.settings.model.FormInfo;
import org.hanzhdy.manager.settings.service.FormEngineService;
import org.hanzhdy.manager.settings.service.FormInfoService;
import org.hanzhdy.manager.support.bean.SessionUser;
import org.hanzhdy.manager.support.constants.DBConstants;
import org.hanzhdy.manager.support.constants.resp.RespResult;
import org.hanzhdy.manager.support.controller.ApplicationController;
import org.hanzhdy.manager.support.enums.LoginUserStatus;
import org.hanzhdy.manager.upc.controller.params.UserParams;
import org.hanzhdy.manager.upc.model.UserStatus;
import org.hanzhdy.manager.upc.service.RoleService;
import org.hanzhdy.manager.upc.service.UserManagerService;
import org.hanzhdy.manager.upc.vo.UserVo;
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
 * @description 用户管理Controller
 * @author H.CAAHN
 * @createtime 2015年7月15日 下午10:34:57
 */
@Controller
@RequestMapping("/basic/user")
public class UserManagerController extends ApplicationController {
    @Autowired
    private UserManagerService  userManagerService;
    
    @Autowired
    private FormInfoService     formInfoService;
    
    @Autowired
    private FormEngineService   formEngineService;
    
    @Autowired
    private RoleService         roleService;
    
    /** 日志对象 */
    private static final Logger logger = LoggerFactory.getLogger(UserManagerController.class);
    
    /**
     * 转到用户管理列表页面
     * @return
     */
    @RequiresPermissions("basic:user:list")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String toList(Model model) {
        model.addAttribute("userStatus", LoginUserStatus.values());
        return "/basic/user/user-list";
    }
    
    /**
     * 跳转到编辑页面
     * @param id
     * @param model
     * @param request
     * @return
     */
    @RequiresPermissions("basic:user:edit")
    @RequestMapping(value = "toEdit", method = RequestMethod.GET)
    public String toEdit(Long id, Model model, HttpServletRequest request) {
        try {
            model.addAttribute("userStatus", LoginUserStatus.values());
            
            // 查询用户信息
            if (id != null && id > 0) {
                UserVo record = userManagerService.queryById(id);
                if (record != null) {
                    model.addAttribute("record", record);
                    return "/basic/user/user-edit";
                }
                return redirect("/error/404");
            }
            return "/basic/user/user-edit";
        }
        catch (Exception ex) {
            return redirect("/error/500");
        }
    }
    
    /**
     * 请求获取用户列表数据
     * @param params
     * @param request
     * @return
     */
    @RequiresPermissions("basic:user:list")
    @RequestMapping(value = "dataList", method = RequestMethod.POST)
    @ResponseBody
    public Object dataList(UserParams params, HttpServletRequest request) {
        DatatableResult dataResult;
        try {
            dataResult = userManagerService.queryAsDatatableResult(params);
        }
        catch (Exception ex) {
            logger.error("查询用户数据失败，查询参数：" + JSON.toJSONString(params), ex);
            dataResult = super.getEmptyDatatableResult();
        }
        return JSON.toJSONString(dataResult);
    }
    
    /**
     * 用户扩展属性
     * @param model
     * @param userid
     * @param formid
     * @param request
     * @return
     */
    @RequiresPermissions("basic:user:edit")
    @RequestMapping(value = "toUserProps", method = RequestMethod.GET)
    public String toUserProps(Model model, @RequestParam("userid") Long userid, Long formid,
            HttpServletRequest request) {
        UserVo record = userManagerService.queryById(userid);
        if (record == null) {
            return redirect("/error/404");
        }
        if (formid == null) {
            formid = record.getFormid();
        }
        
        EngineContext context = super.getEngineContext(request);
        FormInfo formInfo = null;
        List<FormInfo> formList = this.formInfoService.queryFormInfoAsList();
        if (formid != null && formid > 0 && formList != null && !formList.isEmpty()) {
            for (FormInfo form : formList) {
                if (formid.longValue() == form.getId().longValue()) {
                    formInfo = form;
                    break;
                }
            }
        }
        if (formInfo != null) {
            FormHtml formHtml = formEngineService.parseTableHtml(formInfo, record.getId(),
                    DBConstants.FORM_DATA_TYPE_USER, context);
            model.addAttribute("formHtml", formHtml);
            model.addAttribute("formInfo", formInfo);
        }
        
        model.addAttribute("record", record);
        model.addAttribute("formInfo", formInfo);
        model.addAttribute("formList", formList);
        return "/basic/user/user-props";
    }
    
    /**
     * 跳转到角色设置页面
     * @param model
     * @param userid
     * @return
     */
    @RequiresPermissions("basic:user:role")
    @RequestMapping(value = "toEditRole", method = RequestMethod.GET)
    public String toEditRole(Model model, @RequestParam("userid") Long userid) {
        UserVo record = userManagerService.queryById(userid);
        List<ZTreeNode> nodes = this.roleService.queryRoleForUserSetting(userid);
        model.addAttribute("record", record);
        model.addAttribute("nodes", JSON.toJSONString(nodes));
        return "/basic/user/user-role";
    }
    
    /**
     * 处理保存用户信息请求
     * @param record
     * @param request
     * @return
     */
    @RequiresPermissions("basic:user:edit")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public Object saveUser(UserVo record, HttpServletRequest request) {
        SessionUser user = super.getSessionUser(request);
        try {
            // 执行新增或更新操作
            boolean result = false;
            if (record.getId() == null) {
                record.setCreator(user.getId());
                result = this.userManagerService.insert(record, request);
            }
            else {
                record.setUpdater(user.getId());
                result = this.userManagerService.update(record, request);
            }
            
            // 处理返回结果
            return RespResult.create(result ? respCode.SUCCESS : respCode.SAVE_NORECORD);
        }
        catch (BizException ex) {
            logger.warn("保存用户信息失败，错误码：{}，描述：{}", ex.getCode(), ex.getMsg());
            return RespResult.create(ex.getStatus());
        }
        catch (Exception ex) {
            logger.error("保存用户信息失败，数据参数：" + JSON.toJSONString(record), ex);
            return RespResult.create(respCode.ERROR_EXCEPTION);
        }
    }

    /**
     * 更新用户扩展数据
     * @param id
     * @param formid
     * @param request
     * @return
     */
    @RequiresPermissions("basic:user:edit")
    @RequestMapping(value = "saveExtendUserData", method = RequestMethod.POST)
    @ResponseBody
    public Object saveExtendUserData(@RequestParam("id") Long id, Long formid,
            HttpServletRequest request) {
        try {
            this.userManagerService.insertExtendData(id, formid, request);
            return RespResult.create(respCode.SUCCESS);
        }
        catch (Exception ex) {
            logger.error("更新用户扩展数据失败，用户ID：" + id, ex);
            return RespResult.create(respCode.ERROR_EXCEPTION);
        }
    }
    
    /**
     * 保存用户角色信息
     * @param userid
     * @param roles
     * @return
     */
    @RequiresPermissions("basic:user:role")
    @RequestMapping(value = "saveUserRole", method = RequestMethod.POST)
    @ResponseBody
    public Object saveUserRole(@RequestParam("userid") Long userid, @RequestParam("roles") String roles) {
        try {
            this.userManagerService.updateUserRole(userid, roles);
            return RespResult.create(respCode.SUCCESS);
        }
        catch (BizException ex) {
            logger.error("保存用户角色信息失败，用户ID：" + userid, ex);
            return RespResult.create(ex.getStatus());
        }
        catch (Exception ex) {
            logger.error("保存用户角色信息失败，用户ID：" + userid, ex);
            return RespResult.create(respCode.ERROR_EXCEPTION);
        }
    }
    
    /**
     * 处理更新用户数据状态请求
     * @param record
     * @param request
     * @return
     */
    @RequiresPermissions("basic:user:edit")
    @RequestMapping(value = "updateStatus", method = RequestMethod.POST)
    @ResponseBody
    public Object updateStatus(UserStatus record, HttpServletRequest request) {
        SessionUser user = super.getSessionUser(request);
        try {
            record.setUpdater(user.getId());
            this.userManagerService.updateStatus(record);
            return RespResult.create(respCode.SUCCESS);
        }
        catch (Exception ex) {
            logger.error("更新用户数据状态失败，数据参数：" + JSON.toJSONString(record), ex);
            return RespResult.create(respCode.ERROR_EXCEPTION);
        }
    }
    
    /**
     * 打开修改用户密码的页面
     * @param account
     * @param userid
     * @return
     */
    @RequiresPermissions("basic:user:edit")
    @RequestMapping(value = "updatePassword", method = RequestMethod.GET)
    public String updatePassword(Model model, @RequestParam("account") String account, @RequestParam("userid") Long userid) {
        model.addAttribute("account", account);
        model.addAttribute("userid", userid);
        return "basic/user/user-modifyPw";
    }
    
    /**
     * 处理修改用户密码的请求
     * @param account
     * @param userid
     * @param adminPassword
     * @param newPassword
     * @param request
     * @return
     */
    @RequiresPermissions("basic:user:edit")
    @RequestMapping(value = "updatePassword", method = RequestMethod.POST)
    @ResponseBody
    public Object modifyPw(@RequestParam("account") String account, @RequestParam("userid") Long userid,
                           @RequestParam("adminPassword") String adminPassword, @RequestParam("newPassword") String newPassword,
                           HttpServletRequest request) {
        SessionUser user = super.getSessionUser(request);
        try {
            boolean result = this.userManagerService.updateUserPw(user, userid, account, adminPassword, newPassword);
            return RespResult.create(result ? respCode.SUCCESS : respCode.UPDATE_PW_NORECORD);
        }
        catch (BizException ex) {
            logger.warn("修改用户[" + user.getAccount() + "]密码失败，错误原因：" + JSON.toJSONString(ex.getStatus()));
            return RespResult.create(ex.getStatus());
        }
        catch (Exception ex) {
            logger.error("修改用户[" + user.getAccount() + "]密码失败，服务器出现异常", ex);
            return RespResult.create(respCode.ERROR_EXCEPTION);
        }
    }
}
