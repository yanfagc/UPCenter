package com.postbox.controller;

import com.alibaba.fastjson.JSON;
import com.postbox.controller.params.BoxGroupParams;
import com.postbox.enums.BoxGroupStatus;
import com.postbox.model.BoxGroup;
import com.postbox.service.BoxGroupService;
import org.hanzhdy.manager.support.constants.resp.RespResult;
import org.hanzhdy.manager.support.controller.ApplicationController;
import org.hanzhdy.web.bean.DatatableResult;
import org.hanzhdy.web.throwable.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 箱子组管理
 * Created by H.CAAHN on 2017/7/28.
 */
@Controller
@RequestMapping("/postbox/boxgroup")
public class BoxGroupController extends ApplicationController {
    @Resource
    private BoxGroupService boxGroupService;
    
    /** 日志对象 */
    private static final Logger logger = LoggerFactory.getLogger(BoxGroupController.class);
    
    /**
     * 打开箱子组管理列表页面
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String toList(Model model, HttpServletRequest request) {
        model.addAttribute("statusList", BoxGroupStatus.values());
        return "/postbox/boxgroup/boxgroup-list";
    }
    
    /**
     * 请求获取箱子组列表数据
     * @param params
     * @param request
     * @return
     */
    @RequestMapping(value = "dataList", method = RequestMethod.POST)
    @ResponseBody
    public Object dataList(BoxGroupParams params, HttpServletRequest request) {
        try {
            DatatableResult dataResult = this.boxGroupService.queryAsDatatableResult(params);
            return JSON.toJSONString(dataResult);
        }
        catch (BizException ex) {
            logger.error("查询箱子组列表数据失败，查询参数：{}, 错误信息：[{}, {}]", JSON.toJSONString(params), ex.getCode(), ex.getMsg());
        }
        catch (Exception ex) {
            logger.error("查询箱子组列表数据失败，查询参数：" + JSON.toJSONString(params), ex);
        }
        return null;
    }
    
    /**
     * 跳转到编辑企业信息的页面
     * @param id
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "toEdit", method = RequestMethod.GET)
    public String toEdit(Long id, Model model, HttpServletRequest request) {
        model.addAttribute("statusList", BoxGroupStatus.values());
        
        if (id != null) {
            BoxGroup record = this.boxGroupService.queryById(id);
            if (record != null) {
                model.addAttribute("record", record);
                return "/postbox/boxgroup/boxgroup-edit";
            }
            return redirect(REDIRECT_404);
        }
        else {
            return "/postbox/boxgroup/boxgroup-edit";
        }
    }
    
    /**
     * 保存箱子组数据
     * @param record
     * @param request
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public Object saveBoxGroup(BoxGroup record, HttpServletRequest request) {
        try {
            // 执行新增或更新操作
            boolean result = false;
            if (record.getBoxGroupId() == null) {
                result = this.boxGroupService.insert(record);
            }
            else {
                result = this.boxGroupService.update(record);
            }
            
            // 处理返回结果
            return RespResult.create(result ? respCode.SUCCESS : respCode.SAVE_NORECORD);
        }
        catch (BizException ex) {
            logger.error("保存箱子组信息失败，数据参数：{}, 错误信息：[{}, {}]", JSON.toJSONString(record), ex.getCode(), ex.getMsg());
            return RespResult.create(ex.getCode(), ex.getMsg());
        }
        catch (Exception ex) {
            logger.error("保存箱子组信息失败，数据参数：" + JSON.toJSONString(record), ex);
            return RespResult.create(respCode.ERROR_EXCEPTION);
        }
    }
    
    /**
     * 处理更新箱子组信息状态请求
     * @param record
     * @param request
     * @return
     */
    @RequestMapping(value = "updateStatus", method = RequestMethod.POST)
    @ResponseBody
    public Object updateStatus(BoxGroup record, HttpServletRequest request) {
        try {
            this.boxGroupService.updateStatus(record);
            return RespResult.create(respCode.SUCCESS);
        }
        catch (BizException ex) {
            logger.error("更新箱子组信息状态失败，数据参数：{}, 错误信息：[{}, {}]", JSON.toJSONString(record), ex.getCode(), ex.getMsg());
            return RespResult.create(ex.getCode(), ex.getMsg());
        }
        catch (Exception ex) {
            logger.error("更新箱子组信息状态失败，数据参数：" + JSON.toJSONString(record), ex);
            return RespResult.create(respCode.ERROR_EXCEPTION);
        }
    }
}
