package org.hanzhdy.manager.pay.controller;

import com.alibaba.fastjson.JSON;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.hanzhdy.manager.pay.controller.params.AppInfoParams;
import org.hanzhdy.manager.pay.model.AppInfo;
import org.hanzhdy.manager.pay.service.PayService;
import org.hanzhdy.manager.support.bean.SessionUser;
import org.hanzhdy.manager.support.constants.resp.RespResult;
import org.hanzhdy.manager.support.controller.ApplicationController;
import org.hanzhdy.manager.support.enums.CommonStatus;
import org.hanzhdy.manager.upc.controller.RoleController;
import org.hanzhdy.manager.upc.model.AccessSystem;
import org.hanzhdy.manager.upc.model.RoleGroup;
import org.hanzhdy.manager.upc.service.AccessSystemService;
import org.hanzhdy.manager.upc.service.RoleGroupService;
import org.hanzhdy.web.bean.DatatableResult;
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
 * @author wangchengzhi
 * @description 商户支付信息管理
 * @createtime 2017年9月8日
 */
@Controller
@RequestMapping("/pay/appInfo")
public class PayController extends ApplicationController {

    @Autowired
    private PayService payService;

    @Autowired
    private RoleGroupService roleGroupService;

    @Autowired
    private AccessSystemService accessSystemService;

    /**
     * 日志对象
     */
    private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

    /**
     * 转到支付应用账号信息管理列表页面
     *
     * @return
     */
    @RequiresPermissions("pay:appInfo:list")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String toList(Model model) {
        try {
//            List<AccessSystem> sysList = accessSystemService.queryNormalList();
//            List<RoleGroup> groupList = roleGroupService.queryAllList();
//            model.addAttribute("sysList", sysList);
//            model.addAttribute("groupList", groupList);
            model.addAttribute("statusList", CommonStatus.values());
        } catch (Exception ex) {
            logger.error("转到角色管理列表页面失败", ex);
        }

        return "pay/appInfo/appInfo-list";
    }

    /**
     * 请求获取支付应用账号信息列表数据
     *
     * @param params
     * @param request
     * @return
     */
    @RequiresPermissions("pay:appInfo:list")
    @RequestMapping(value = "dataList", method = RequestMethod.POST)
    @ResponseBody
    public Object dataList(AppInfoParams params, HttpServletRequest request) {
        DatatableResult dataResult = null;
        try {
            dataResult = payService.queryAsDatatableResult(params);
        } catch (BizException ex) {
            dataResult = super.getEmptyDatatableResult();
            logger.error("查询支付应用账号信息数据失败，查询参数：{}, 错误信息：[{}, {}]", JSON.toJSONString(params), ex.getCode(), ex.getMsg());
        } catch (Exception ex) {
            dataResult = super.getEmptyDatatableResult();
            logger.error("查询支付应用账号信息数据失败，查询参数：" + JSON.toJSONString(params), ex);
        }
        return JSON.toJSONString(dataResult);
    }

    /**
     * 跳转到编辑页面
     *
     * @param appId
     * @param model
     * @param request
     * @return
     */
    @RequiresPermissions("pay:appInfo:edit")
    @RequestMapping(value = "toEdit", method = RequestMethod.GET)
    public String toEdit(String appId, Model model, HttpServletRequest request) {
        // 查询接入系统以及角色分组信息
        List<AccessSystem> sysList = accessSystemService.queryNormalList();
        List<RoleGroup> groupList = roleGroupService.queryAllList();
        model.addAttribute("sysList", sysList);
        model.addAttribute("groupList", groupList);
        model.addAttribute("statusList", CommonStatus.values());

        // 查询支付应用账号信息
        if (appId != null && appId != "") {
            AppInfo record = payService.queryById(appId);
            if (record != null) {
                model.addAttribute("record", record);
                return "pay/appInfo/appInfo-edit";
            }
            return redirect(REDIRECT_404);
        }
        return "pay/appInfo/appInfo-edit";
    }

    /**
     * 处理保存支付应用账号信息请求
     *
     * @param record
     * @param request
     * @return
     */
    @RequiresPermissions("pay:appInfo:edit")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public Object saveUser(AppInfo record, @RequestParam(value="oldAppId", required=false) String oldAppId, HttpServletRequest request) {
        try {
            // 执行新增或更新操作
            boolean result = false;
            if (oldAppId == null || oldAppId == "") {
                result = this.payService.insert(record);
            }else {
                result = this.payService.updateAppId(record, oldAppId);
            }

            // 处理返回结果
            return RespResult.create(result ? respCode.SUCCESS : respCode.SAVE_NORECORD);
        } catch (BizException ex) {
            logger.error("保存支付应用账号信息失败，数据参数：{}, 错误信息：[{}, {}]", JSON.toJSONString(record), ex.getCode(), ex.getMsg());
            return RespResult.create(ex.getCode(), ex.getMsg());
        } catch (Exception ex) {
            logger.error("保存支付应用账号信息失败，数据参数：" + JSON.toJSONString(record), ex);
            return RespResult.create(respCode.ERROR_EXCEPTION);
        }
    }

    /**
     * 处理更新支付应用账号状态请求
     * @param record
     * @param request
     * @return
     */
    @RequiresPermissions("pay:appInfo:edit")
    @RequestMapping(value = "updateStatus", method = RequestMethod.POST)
    @ResponseBody
    public Object updateStatus(AppInfo record, HttpServletRequest request) {
        try {
            this.payService.updateStatus(record);
            return RespResult.create(respCode.SUCCESS);
        }
        catch (BizException ex) {
            logger.error("更新支付应用账号状态失败，数据参数：{}, 错误信息：[{}, {}]", JSON.toJSONString(record), ex.getCode(), ex.getMsg());
            return RespResult.create(ex.getCode(), ex.getMsg());
        }
        catch (Exception ex) {
            logger.error("更新支付应用账号状态失败，数据参数：" + JSON.toJSONString(record), ex);
            return RespResult.create(respCode.ERROR_EXCEPTION);
        }
    }

}
