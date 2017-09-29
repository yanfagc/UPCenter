package org.hanzhdy.manager.settings.controller;

import com.alibaba.fastjson.JSON;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.hanzhdy.manager.settings.controller.params.DictTypeParams;
import org.hanzhdy.manager.settings.model.DictType;
import org.hanzhdy.manager.settings.service.DictTypeService;
import org.hanzhdy.manager.support.bean.SessionUser;
import org.hanzhdy.manager.support.constants.resp.RespResult;
import org.hanzhdy.manager.support.controller.ApplicationController;
import org.hanzhdy.web.bean.DatatableResult;
import org.hanzhdy.web.throwable.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @description 字典类型管理Controller
 * @author H.CAAHN
 * @createtime 2016年10月9日 上午12:09:18
 */
@Controller
@RequestMapping("/basic/dicttype")
public class DictTypeController extends ApplicationController {
    @Autowired
    private DictTypeService     dictTypeService;
    
    /** 日志对象 */
    private static final Logger logger = LoggerFactory.getLogger(DictTypeController.class);
    
    /**
     * 转到字典类型管理列表页面
     * @return
     */
    @RequiresPermissions("basic:dicttype:list")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String toList() {
        return "/basic/dicttype/dicttype-list";
    }
    
    /**
     * 请求获取字典类型列表数据
     * @param params
     * @param request
     * @return
     */
    @RequiresPermissions("basic:dicttype:list")
    @RequestMapping(value = "dataList", method = RequestMethod.POST)
    @ResponseBody
    public Object dataList(DictTypeParams params, HttpServletRequest request) {
        try {
            DatatableResult dataResult = dictTypeService.queryAsDatatableResult(params);
            return JSON.toJSONString(dataResult);
        }
        catch (BizException ex) {
            logger.error("查询字典类型数据失败，查询参数：{}, 错误信息：[{}, {}]", JSON.toJSONString(params), ex.getCode(), ex.getMsg());
        }
        catch (Exception ex) {
            logger.error("查询字典类型数据失败，查询参数：" + JSON.toJSONString(params), ex);
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
    @RequiresPermissions("basic:dicttype:edit")
    @RequestMapping(value = "toEdit", method = RequestMethod.GET)
    public String toEdit(Long id, Model model, HttpServletRequest request) {
        // 查询字典类型信息
        if (id != null && id > 0) {
            DictType record = dictTypeService.queryById(id);
            if (record != null) {
                model.addAttribute("record", record);
                return "/basic/dicttype/dicttype-edit";
            }
            return redirect(REDIRECT_404);
        }
        return "/basic/dicttype/dicttype-edit";
    }
    
    /**
     * 处理保存字典类型信息请求
     * @param record
     * @param request
     * @return
     */
    @RequiresPermissions("basic:dicttype:edit")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public Object saveUser(DictType record, HttpServletRequest request) {
        SessionUser user = super.getSessionUser(request);
        try {
            // 执行新增或更新操作
            boolean result = false;
            if (record.getId() == null) {
                record.setCreator(user.getId());
                result = this.dictTypeService.insert(record);
            }
            else {
                record.setUpdater(user.getId());
                result = this.dictTypeService.update(record);
            }
            
            // 处理返回结果
            return RespResult.create(result ? respCode.SUCCESS : respCode.SAVE_NORECORD);
        }
        catch (BizException ex) {
            logger.error("保存字典类型信息失败，数据参数：{}, 错误信息：[{}, {}]", JSON.toJSONString(record), ex.getCode(), ex.getMsg());
            return RespResult.create(ex.getCode(), ex.getMsg());
        }
        catch (Exception ex) {
            logger.error("保存字典类型信息失败，数据参数：" + JSON.toJSONString(record), ex);
            return RespResult.create(respCode.ERROR_EXCEPTION);
        }
    }
    
    /**
     * 处理更新字典类型数据状态请求
     * @param record
     * @param request
     * @return
     */
    @RequiresPermissions("basic:dicttype:edit")
    @RequestMapping(value = "updateStatus", method = RequestMethod.POST)
    @ResponseBody
    public Object updateStatus(DictType record, HttpServletRequest request) {
        SessionUser user = super.getSessionUser(request);
        try {
            record.setUpdater(user.getId());
            this.dictTypeService.updateStatus(record);
            return RespResult.create(respCode.SUCCESS);
        }
        catch (BizException ex) {
            logger.error("更新数据字典数据状态失败，数据参数：{}, 错误信息：[{}, {}]", JSON.toJSONString(record), ex.getCode(), ex.getMsg());
            return RespResult.create(ex.getCode(), ex.getMsg());
        }
        catch (Exception ex) {
            logger.error("更新字典类型数据状态失败，数据参数：" + JSON.toJSONString(record), ex);
            return RespResult.create(respCode.ERROR_EXCEPTION);
        }
    }
}
