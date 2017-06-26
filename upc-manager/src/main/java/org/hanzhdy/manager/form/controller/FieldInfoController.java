package org.hanzhdy.manager.form.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.hanzhdy.manager.engine.constants.FieldType;
import org.hanzhdy.manager.engine.constants.InputMacrosType;
import org.hanzhdy.manager.engine.constants.NormalMacrosType;
import org.hanzhdy.manager.form.controller.params.FieldInfoParams;
import org.hanzhdy.manager.form.model.FieldInfo;
import org.hanzhdy.manager.form.model.FieldItem;
import org.hanzhdy.manager.form.service.FieldInfoService;
import org.hanzhdy.manager.form.vo.FieldInfoVo;
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

import com.alibaba.fastjson.JSON;

/**
 * @description 表单字段管理Controller
 * @author H.CAAHN
 * @createtime 2015年12月1日 下午11:16:37
 */
@Controller
@RequestMapping("/basic/field")
public class FieldInfoController extends ApplicationController {
    @Autowired
    private FieldInfoService    fieldInfoService;
    
    /** 日志对象 */
    private static final Logger logger = LoggerFactory.getLogger(FieldInfoController.class);
    
    /**
     * 转到表单字段列表页面
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String toList(Model model, HttpServletRequest request) {
        return "/basic/field/field-list";
    }
    
    /**
     * 进入到添加表单字段的页面
     * @param model
     * @param type
     * @param request
     * @return
     */
    @RequestMapping(value = "toAdd", method = RequestMethod.GET)
    public String toAdd(Model model, @RequestParam("type") FieldType type, HttpServletRequest request) {
        if (type == FieldType.INPUT) {
            model.addAttribute("macrosList", InputMacrosType.values());
            return "/basic/field/field-editText";
        }
        else if (type == FieldType.TEXTAREA) {
            return "/basic/field/field-editTextarea";
        }
        else if (type == FieldType.SELECT) {
            return "/basic/field/field-editSelect";
        }
        else if (type == FieldType.CHECKBOX) {
            return "/basic/field/field-editCheckbox";
        }
        else if (type == FieldType.RADIO) {
            return "/basic/field/field-editRadio";
        }
        else if (type == FieldType.MACROS) {
            model.addAttribute("macrosList", NormalMacrosType.values());
            return "/basic/field/field-editMacros";
        }
        return redirect(REDIRECT_404);
    }
    
    /**
     * 跳转到编辑页面
     * @param id
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "toEdit", method = RequestMethod.GET)
    public String toEdit(@RequestParam("id") Long id, Model model, HttpServletRequest request) {
        if (id == 0 || id <= 0) {
            return redirect(REDIRECT_404);
        }
        
        try {
            FieldInfo record = this.fieldInfoService.queryById(id);
            if (record == null) {
                return redirect(REDIRECT_404);
            }
            
            model.addAttribute("record", record);
            if (FieldType.TEXTAREA == record.getFieldtype()) {
                return "/basic/field/field-editTextarea";
            }
            else if (FieldType.SELECT == record.getFieldtype()) {
                List<FieldItem> items = this.fieldInfoService.queryItemsByFieldId(id);
                model.addAttribute("items", items);
                return "/basic/field/field-editSelect";
            }
            else if (FieldType.CHECKBOX == record.getFieldtype()) {
                List<FieldItem> items = this.fieldInfoService.queryItemsByFieldId(id);
                if (StringUtils.isNotBlank(record.getDefaultvalue())) {
                    model.addAttribute("checkeditems", record.getDefaultvalue().split(","));
                }
                
                model.addAttribute("items", items);
                return "/basic/field/field-editCheckbox";
            }
            else if (FieldType.RADIO == record.getFieldtype()) {
                List<FieldItem> items = this.fieldInfoService.queryItemsByFieldId(id);
                model.addAttribute("items", items);
                return "/basic/field/field-editRadio";
            }
            else if (FieldType.MACROS == record.getFieldtype()) {
                model.addAttribute("macrosList", NormalMacrosType.values());
                return "/basic/field/field-editMacros";
            }
            else {
                model.addAttribute("macrosList", InputMacrosType.values());
                return "/basic/field/field-editText";
            }
        }
        catch (Exception ex) {
            logger.error("打开到字段编辑页面失败, id: " + id, ex);
            throw ex;
        }
    }
    
    /**
     * 跳转到编辑字段规则的页面
     * @param model
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "toEditRule", method = RequestMethod.GET)
    public String toEditRule(Model model, @RequestParam("id") Long id, HttpServletRequest request) {
        if (id == 0 || id <= 0) {
            return redirect(REDIRECT_404);
        }
        
        try {
            FieldInfo record = this.fieldInfoService.queryById(id);
            if (record == null) {
                return redirect(REDIRECT_404);
            }
            
            // 最小对比字段
            if (record.getMinlimit() != null && record.getMinlimit() > 0) {
                FieldInfo minlimit = this.fieldInfoService.queryById(record.getMinlimit());
                model.addAttribute("minlimit", minlimit);
            }
            // 最大对比字段
            if (record.getMaxlimit() != null && record.getMaxlimit() > 0) {
                FieldInfo maxlimit = this.fieldInfoService.queryById(record.getMaxlimit());
                model.addAttribute("maxlimit", maxlimit);
            }
            
            model.addAttribute("record", record);
            if (FieldType.TEXTAREA == record.getFieldtype()) {
                return "/basic/field/field-editTextareaRule";
            }
            else if (FieldType.SELECT == record.getFieldtype()) {
                List<FieldItem> items = this.fieldInfoService.queryItemsByFieldId(id);
                model.addAttribute("items", items);
                return "/basic/field/field-editSelectRule";
            }
            else if (FieldType.CHECKBOX == record.getFieldtype()) {
                List<FieldItem> items = this.fieldInfoService.queryItemsByFieldId(id);
                if (StringUtils.isNotBlank(record.getDefaultvalue())) {
                    model.addAttribute("checkeditems", record.getDefaultvalue().split(","));
                }
                
                model.addAttribute("items", items);
                return "/basic/field/field-editCheckboxRule";
            }
            else if (FieldType.RADIO == record.getFieldtype()) {
                List<FieldItem> items = this.fieldInfoService.queryItemsByFieldId(id);
                model.addAttribute("items", items);
                return "/basic/field/field-editRadioRule";
            }
            else if (FieldType.MACROS == record.getFieldtype()) {
                model.addAttribute("macrosList", NormalMacrosType.values());
                return "/basic/field/field-editMacrosRule";
            }
            else {
                model.addAttribute("macrosList", InputMacrosType.values());
                return "/basic/field/field-editTextRule";
            }
        }
        catch (Exception ex) {
            logger.error("打开字段规则编辑页面失败, id: " + id, ex);
            throw ex;
        }
    }
    
    /**
     * 请求获取表单字段列表数据
     * @return
     */
    @RequestMapping(value = "dataList", method = RequestMethod.POST)
    @ResponseBody
    public Object dataList(FieldInfoParams params, HttpServletRequest request) {
        try {
            DatatableResult dataResult = fieldInfoService.queryAsDatatableResult(params);
            return JSON.toJSONString(dataResult);
        }
        catch (BizException ex) {
            logger.error("查询表单字段数据失败，查询参数：{}, 错误信息：[{}, {}]", JSON.toJSONString(params), ex.getCode(), ex.getMsg());
        }
        catch (Exception ex) {
            logger.error("查询表单字段数据失败，查询参数：" + JSON.toJSONString(params), ex);
        }
        return null;
    }
    
    /**
     * 根据条件，查询表单字段信息，用于autoComplete
     * @param key
     * @param request
     * @return
     */
    @RequestMapping(value = "ajaxFieldInfo", method = RequestMethod.GET)
    @ResponseBody
    public Object ajaxFieldInfo(String key, HttpServletRequest request) {
        try {
            List<FieldInfo> dataList = this.fieldInfoService.queryAsAutoComplete(key);
            return dataList;
        }
        catch (Exception ex) {
            logger.error("查询表单字段信息失败，查询参数：" + key, ex);
        }
        return "[]";
    }
    
    /**
     * 处理保存表单字段信息请求
     * @param record
     * @param request
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public Object saveFieldInfo(FieldInfoVo record, HttpServletRequest request) {
        try {
            // 执行新增或更新操作
            boolean result = false;
            if (record.getId() == null) {
                result = this.fieldInfoService.insert(record);
            }
            else {
                result = this.fieldInfoService.update(record);
            }
            
            // 处理返回结果
            return RespResult.create(result ? respCode.SUCCESS : respCode.SAVE_NORECORD);
        }
        catch (BizException ex) {
            logger.error("保存表单字段失败，数据参数：{}, 错误信息：[{}, {}]", JSON.toJSONString(record), ex.getCode(), ex.getMsg());
            return RespResult.create(ex.getCode(), ex.getMsg());
        }
        catch (Exception ex) {
            logger.error("保存表单字段失败，数据参数：" + JSON.toJSONString(record), ex);
            return RespResult.create(respCode.ERROR_EXCEPTION);
        }
    }
    
    /**
     * 更新表单字段规则
     * @param record
     * @param request
     * @return
     */
    @RequestMapping(value = "saveFieldRule", method = RequestMethod.POST)
    @ResponseBody
    public Object saveFieldRule(FieldInfo record, HttpServletRequest request) {
        try {
            // 执行更新表单字段规则
            boolean result = this.fieldInfoService.updateRule(record);
            // 处理返回结果
            return RespResult.create(result ? respCode.SUCCESS : respCode.SAVE_NORECORD);
        }
        catch (Exception ex) {
            logger.error("保存表单字段规则失败，数据参数：" + JSON.toJSONString(record), ex);
            return RespResult.create(respCode.ERROR_EXCEPTION);
        }
    }
    
    /**
     * 处理更新表单字段状态请求
     * @param record
     * @param request
     * @return
     */
    @RequestMapping(value = "updateStatus", method = RequestMethod.POST)
    @ResponseBody
    public Object updateStatus(FieldInfo record, HttpServletRequest request) {
        try {
            this.fieldInfoService.updateStatus(record);
            return RespResult.create(respCode.SUCCESS);
        }
        catch (BizException ex) {
            logger.error("更新表单字段状态失败，数据参数：{}, 错误信息：[{}, {}]", JSON.toJSONString(record), ex.getCode(), ex.getMsg());
            return RespResult.create(ex.getCode(), ex.getMsg());
        }
        catch (Exception ex) {
            logger.error("更新表单字段状态失败，数据参数：" + JSON.toJSONString(record), ex);
            return RespResult.create(respCode.ERROR_EXCEPTION);
        }
    }
}
