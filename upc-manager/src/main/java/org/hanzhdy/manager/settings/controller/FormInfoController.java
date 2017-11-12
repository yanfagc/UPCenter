package org.hanzhdy.manager.settings.controller;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.hanzhdy.manager.settings.controller.params.FieldInfoParams;
import org.hanzhdy.manager.settings.controller.params.FormInfoParams;
import org.hanzhdy.manager.settings.engine.EngineContext;
import org.hanzhdy.manager.settings.engine.FormHtml;
import org.hanzhdy.manager.settings.model.FieldInfo;
import org.hanzhdy.manager.settings.model.FormField;
import org.hanzhdy.manager.settings.model.FormInfo;
import org.hanzhdy.manager.settings.service.FieldInfoService;
import org.hanzhdy.manager.settings.service.FormEngineService;
import org.hanzhdy.manager.settings.service.FormInfoService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @description 表单管理的Controller
 * @author H.CAAHN
 * @createtime 2015年12月10日 下午10:38:26
 */
@Controller
@RequestMapping("/basic/form")
public class FormInfoController extends ApplicationController {
    @Autowired
    private FormInfoService     formInfoService;
    
    @Autowired
    private FieldInfoService    fieldInfoService;
    
    @Autowired
    private FormEngineService   formEngineService;
    
    /** 日志对象 */
    private static final Logger logger = LoggerFactory.getLogger(FormInfoController.class);
    
    /**
     * 转到表单信息维护列表页面
     * @param model
     * @param request
     * @return
     */
    @RequiresPermissions("basic:form:list")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String toList(Model model, HttpServletRequest request) {
        return "/basic/form/form-list";
    }
    
    /**
     * 预览表单
     * @param model
     * @param id
     * @param request
     * @return
     */
    @RequiresPermissions("basic:form:list")
    @RequestMapping(value = "preview", method = RequestMethod.GET)
    public String preview(Model model, @RequestParam("id") Long id, HttpServletRequest request) {
        try {
            EngineContext context = super.getEngineContext(request);
            
            FormInfo formInfo = formInfoService.queryById(id);
            FormHtml record = formEngineService.parseTableHtml(formInfo, null, null, context);
            
            model.addAttribute("formInfo", formInfo);
            model.addAttribute("record", record);
            return "/basic/form/form-preview";
        }
        catch (Exception ex) {
            logger.error("预览表单信息异常，ID：" + id, ex);
            throw ex;
        }
        
    }
    
    /**
     * 根据表单ID，查询该表单中所有的表单字段信息
     * @param id
     * @param model
     * @param request
     * @return
     */
    @RequiresPermissions("basic:form:list")
    @RequestMapping(value = "formFieldList", method = RequestMethod.GET)
    public String toFormFieldList(Long id, Model model, HttpServletRequest request) {
        try {
            FormInfo form = this.formInfoService.queryById(id);
            if (form != null) {
                model.addAttribute("form", form);
                return "/basic/form/formfield-list";
            }
            else {
                return redirect(REDIRECT_404);
            }
        }
        catch (Exception ex) {
            logger.error("查询表单信息异常，ID：" + id, ex);
            throw ex;
        }
    }
    
    /**
     * 进入到添加表单字段关联关系页面
     * @param formid
     * @param model
     * @param request
     * @return
     */
    @RequiresPermissions("basic:form:edit")
    @RequestMapping(value = "addFormField", method = RequestMethod.GET)
    public String toAddFormField(Model model, @RequestParam("formid") Long formid, HttpServletRequest request) {
        model.addAttribute("formid", formid);
        return "/basic/form/formfield-add";
    }
    
    /**
     * 进入到编辑表单字段关联关系页面（主要修改排序与占位符）
     * @param model
     * @param formid
     * @param fieldid
     * @param request
     * @return
     */
    @RequiresPermissions("basic:form:edit")
    @RequestMapping(value = "editFormField", method = RequestMethod.GET)
    public String toEditFormField(Model model, @RequestParam("formid") Long formid,
            @RequestParam("fieldid") Long fieldid, HttpServletRequest request) {
        try {
            FormInfo formInfo = formInfoService.queryById(formid);
            FieldInfo fieldInfo = fieldInfoService.queryById(fieldid);
            FormField record = this.formInfoService.queryFormFieldByPkey(formid, fieldid);
            
            model.addAttribute("formInfo", formInfo);
            model.addAttribute("fieldInfo", fieldInfo);
            model.addAttribute("record", record);
            return "/basic/form/formfield-edit";
        }
        catch (Exception ex) {
            logger.error("查询表单字段关联关系异常，formid: " + formid + ", fieldid: " + fieldid, ex);
            throw ex;
        }
    }
    
    /**
     * 跳转到编辑页面
     * @param id
     * @param model
     * @param request
     * @return
     */
    @RequiresPermissions("basic:form:edit")
    @RequestMapping(value = "toEdit", method = RequestMethod.GET)
    public String toEdit(Long id, Model model, HttpServletRequest request) {
        if (id != null) {
            FormInfo record = this.formInfoService.queryById(id);
            if (record != null) {
                model.addAttribute("record", record);
                return "/basic/form/form-edit";
            }
            return redirect(REDIRECT_404);
        }
        else {
            return "/basic/form/form-edit";
        }
    }
    
    /**
     * 请求获取表单列表数据
     * @param params
     * @param request
     * @return
     */
    @RequiresPermissions("basic:form:list")
    @RequestMapping(value = "dataList", method = RequestMethod.POST)
    @ResponseBody
    public Object dataList(FormInfoParams params, HttpServletRequest request) {
        DatatableResult dataResult;
        try {
            dataResult = formInfoService.queryAsDatatableResult(params);
        }
        catch (BizException ex) {
            logger.error("查询表单数据失败，查询参数：{}, 错误信息：[{}, {}]", JSON.toJSONString(params), ex.getCode(), ex.getMsg());
            dataResult = super.getEmptyDatatableResult();
        }
        catch (Exception ex) {
            logger.error("查询表单数据失败，查询参数：" + JSON.toJSONString(params), ex);
            dataResult = super.getEmptyDatatableResult();
        }
        return JSON.toJSONString(dataResult);
    }
    
    /**
     * 根据表单ID，分页请求获取表单字段列表数据
     * @param params
     * @param request
     * @return
     */
    @RequiresPermissions("basic:form:list")
    @RequestMapping(value = "formFieldList", method = RequestMethod.POST)
    @ResponseBody
    public Object formFieldList(FieldInfoParams params, HttpServletRequest request) {
        DatatableResult dataResult;
        try {
            dataResult = fieldInfoService.queryByFormidAsDatatableResult(params);
        }
        catch (BizException ex) {
            logger.error("查询表单字段失败，查询参数：{}, 错误信息：[{}, {}]", JSON.toJSONString(params), ex.getCode(), ex.getMsg());
            dataResult = super.getEmptyDatatableResult();
        }
        catch (Exception ex) {
            logger.error("查询表单字段失败，查询参数：" + JSON.toJSONString(params), ex);
            dataResult = super.getEmptyDatatableResult();
        }
        return JSON.toJSONString(dataResult);
    }
    
    /**
     * 查询可添加到指定表单中的字段数据
     * @param params
     * @param request
     * @return
     */
    @RequiresPermissions("basic:form:list")
    @RequestMapping(value = "canAddList", method = RequestMethod.POST)
    @ResponseBody
    public Object canAddList(FieldInfoParams params, HttpServletRequest request) {
        DatatableResult dataResult;
        try {
            dataResult = fieldInfoService.queryCanAddFieldAsDTR(params);
        }
        catch (BizException ex) {
            logger.error("查询可添加到指定表单中的字段数据，查询参数：{}, 错误信息：[{}, {}]", JSON.toJSONString(params), ex.getCode(),
                    ex.getMsg());
            dataResult = super.getEmptyDatatableResult();
        }
        catch (Exception ex) {
            logger.error("查询可添加到指定表单中的字段数据，查询参数：" + JSON.toJSONString(params), ex);
            dataResult = super.getEmptyDatatableResult();
        }
        return JSON.toJSONString(dataResult);
    }
    
    /**
     * 处理保存表单信息请求
     * @param record
     * @param request
     * @return
     */
    @RequiresPermissions("basic:form:edit")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public Object saveFormInfo(FormInfo record, HttpServletRequest request) {
        SessionUser user = super.getSessionUser(request);
        try {
            // 执行新增或更新操作
            boolean result = false;
            if (record.getId() == null) {
                record.setCreator(user.getId());
                result = this.formInfoService.insert(record);
            }
            else {
                record.setUpdater(user.getId());
                result = this.formInfoService.update(record);
            }
            
            // 处理返回结果
            return RespResult.create(result ? respCode.SUCCESS : respCode.SAVE_NORECORD);
        }
        catch (BizException ex) {
            logger.error("保存表单信息失败，数据参数：{}, 错误信息：[{}, {}]", JSON.toJSONString(record), ex.getCode(), ex.getMsg());
            return RespResult.create(ex.getCode(), ex.getMsg());
        }
        catch (Exception ex) {
            logger.error("保存表单信息失败，数据参数：" + JSON.toJSONString(record), ex);
            return RespResult.create(respCode.ERROR_EXCEPTION);
        }
    }
    
    /**
     * 处理更新表单数据状态请求
     * @param record
     * @param request
     * @return
     */
    @RequiresPermissions("basic:form:edit")
    @RequestMapping(value = "updateStatus", method = RequestMethod.POST)
    @ResponseBody
    public Object updateStatus(FormInfo record, HttpServletRequest request) {
        SessionUser user = super.getSessionUser(request);
        try {
            record.setUpdater(user.getId());
            this.formInfoService.updateStatus(record);
            return RespResult.create(respCode.SUCCESS);
        }
        catch (BizException ex) {
            logger.error("更新表单数据状态失败，数据参数：{}, 错误信息：[{}, {}]", JSON.toJSONString(record), ex.getCode(), ex.getMsg());
            return RespResult.create(ex.getCode(), ex.getMsg());
        }
        catch (Exception ex) {
            logger.error("更新表单数据状态失败，数据参数：" + JSON.toJSONString(record), ex);
            return RespResult.create(respCode.ERROR_EXCEPTION);
        }
    }
    
    /**
     * 处理添加表单字段关联关系请求
     * @param formid
     * @param fieldid
     * @param reqeust
     * @return
     */
    @RequiresPermissions("basic:form:edit")
    @RequestMapping(value = "addFormField", method = RequestMethod.POST)
    @ResponseBody
    public Object addFormField(Long formid, String fieldid, String colspan, HttpServletRequest reqeust) {
        try {
            if (formid == null || formid <= 0 || StringUtils.isBlank(fieldid) || StringUtils.isBlank(colspan)) {
                logger.error("添加表单字段关联关系，异常数据请求formid:[{}], fieldid:[{}]", formid, fieldid);
                return RespResult.create(respCode.ERROR_DATA_FORMAT);
            }
            
            this.formInfoService.insertFormField(formid, fieldid, colspan);
            return RespResult.create(respCode.SUCCESS);
        }
        catch (BizException ex) {
            logger.error("添加表单字段关联关系失败，关联ID：[{}, {}], 错误信息：[{}, {}]", formid, fieldid, ex.getCode(), ex.getMsg());
            return RespResult.create(ex.getCode(), ex.getMsg());
        }
        catch (Exception ex) {
            logger.error("添加表单字段关联关系失败，关联ID：" + formid + ", " + fieldid, ex);
            return RespResult.create(respCode.ERROR_EXCEPTION);
        }
    }

    /**
     * 更新表单字段关联关系信息
     * @param record
     * @param request
     * @return
     */
    @RequiresPermissions("basic:form:edit")
    @RequestMapping(value = "saveFormField", method = RequestMethod.POST)
    @ResponseBody
    public Object saveFormField(FormField record, HttpServletRequest request) {
        try {
            if (record.getFieldId() == null || record.getFormId() == null) {
                logger.error("更新表单字段关联关系，异常数据请求:[{}], fieldid:[{}]", JSON.toJSONString(record));
                return RespResult.create(respCode.ERROR_DATA_FORMAT);
            }
            
            this.formInfoService.updateFormField(record);
            return RespResult.create(respCode.SUCCESS);
        }
        catch (BizException ex) {
            logger.error("添加表单字段关联关系失败，请求数据：[{}], 错误信息：[{}, {}]", JSON.toJSONString(record), ex.getCode(), ex.getMsg());
            return RespResult.create(ex.getCode(), ex.getMsg());
        }
        catch (Exception ex) {
            logger.error("添加表单字段关联关系失败，请求数据：[{}]", JSON.toJSONString(record), ex);
            return RespResult.create(respCode.ERROR_EXCEPTION);
        }
    }
    
    /**
     * 处理删除表单字段关联关系请求
     * @param formid
     * @param fieldid
     * @param request
     * @return
     */
    @RequiresPermissions("basic:form:delete")
    @RequestMapping(value = "deleteFormField", method = RequestMethod.POST)
    @ResponseBody
    public Object deleteFormField(Long formid, Long fieldid, HttpServletRequest request) {
        try {
            if (formid == null || formid <= 0 || fieldid == null || fieldid <= 0) {
                logger.error("删除表单字段关联关系，异常数据请求formid:[{}], fieldid:[{}]", formid, fieldid);
                return RespResult.create(respCode.ERROR_DATA_FORMAT);
            }
            
            this.formInfoService.deleteFormField(formid, fieldid);
            return RespResult.create(respCode.SUCCESS);
        }
        catch (BizException ex) {
            logger.error("删除表单字段关联关系失败，关联ID：[{}, {}], 错误信息：[{}, {}]", formid, fieldid, ex.getCode(), ex.getMsg());
            return RespResult.create(ex.getCode(), ex.getMsg());
        }
        catch (Exception ex) {
            logger.error("删除表单字段关联关系失败，关联ID：" + formid + ", " + fieldid, ex);
            return RespResult.create(respCode.ERROR_EXCEPTION);
        }
    }
}
