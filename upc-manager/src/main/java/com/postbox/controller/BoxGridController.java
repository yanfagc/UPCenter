package com.postbox.controller;

import com.alibaba.fastjson.JSON;
import com.postbox.controller.params.BoxGridParams;
import com.postbox.enums.BoxGridStatus;
import com.postbox.model.BoxGrid;
import com.postbox.service.BoxGridService;
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
 * 快递格子管理
 * Created by H.CAAHN on 2017/8/25.
 */
@Controller
@RequestMapping("/postbox/boxgrid")
public class BoxGridController extends ApplicationController {
    @Autowired
    private BoxGridService boxGridService;
    
    /** 日志对象 */
    private static final Logger logger = LoggerFactory.getLogger(BoxGridController.class);
    
    /**
     * 打开快递格子管理列表页面
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String toList(Model model, HttpServletRequest request) {
        model.addAttribute("statusList", BoxGridStatus.values());
        return "/postbox/boxgroup/boxgroup-list";
    }
    
    /**
     * 请求获取快递格子列表数据
     * @param params
     * @param request
     * @return
     */
    @RequestMapping(value = "dataList", method = RequestMethod.POST)
    @ResponseBody
    public Object dataList(BoxGridParams params, HttpServletRequest request) {
        try {
            DatatableResult dataResult = this.boxGridService.queryAsDatatableResult(params);
            return JSON.toJSONString(dataResult);
        }
        catch (BizException ex) {
            logger.error("查询快递格子列表数据失败，查询参数：{}, 错误信息：[{}, {}]", JSON.toJSONString(params), ex.getCode(), ex.getMsg());
        }
        catch (Exception ex) {
            logger.error("查询快递格子列表数据失败，查询参数：" + JSON.toJSONString(params), ex);
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
        model.addAttribute("statusList", BoxGridStatus.values());
        if (id != null) {
            BoxGrid record = this.boxGridService.queryById(id);
            if (record != null) {
                model.addAttribute("record", record);
                return "/postbox/boxgrid/boxgrid-edit";
            }
            return redirect(REDIRECT_404);
        }
        else {
            return "/postbox/boxgrid/boxgrid-edit";
        }
    }
    
    /**
     * 保存快递格子数据
     * @param record
     * @param request
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public Object saveBoxGroup(BoxGrid record, HttpServletRequest request) {
        try {
            // 执行新增或更新操作
            boolean result = false;
            if (record.getBoxGridId() == null) {
                result = this.boxGridService.insert(record);
            }
            else {
                result = this.boxGridService.update(record);
            }
            
            // 处理返回结果
            return RespResult.create(result ? respCode.SUCCESS : respCode.SAVE_NORECORD);
        }
        catch (BizException ex) {
            logger.error("保存箱快递格子信息失败，数据参数：{}, 错误信息：[{}, {}]", JSON.toJSONString(record), ex.getCode(), ex.getMsg());
            return RespResult.create(ex.getCode(), ex.getMsg());
        }
        catch (Exception ex) {
            logger.error("保存快递格子信息失败，数据参数：" + JSON.toJSONString(record), ex);
            return RespResult.create(respCode.ERROR_EXCEPTION);
        }
    }
    
    /**
     * 处理更新快递格子信息状态请求
     * @param record
     * @param request
     * @return
     */
    @RequestMapping(value = "updateStatus", method = RequestMethod.POST)
    @ResponseBody
    public Object updateStatus(BoxGrid record, HttpServletRequest request) {
        try {
            this.boxGridService.updateStatus(record);
            return RespResult.create(respCode.SUCCESS);
        }
        catch (BizException ex) {
            logger.error("更新快递格子信息状态失败，数据参数：{}, 错误信息：[{}, {}]", JSON.toJSONString(record), ex.getCode(), ex.getMsg());
            return RespResult.create(ex.getCode(), ex.getMsg());
        }
        catch (Exception ex) {
            logger.error("更新快递格子信息状态失败，数据参数：" + JSON.toJSONString(record), ex);
            return RespResult.create(respCode.ERROR_EXCEPTION);
        }
    }
}
