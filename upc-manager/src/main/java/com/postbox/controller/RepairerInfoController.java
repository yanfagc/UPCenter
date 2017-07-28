package com.postbox.controller;

import com.alibaba.fastjson.JSON;
import com.postbox.controller.params.RepairerInfoParams;
import com.postbox.enums.DataStatus;
import com.postbox.model.RepairerInfo;
import com.postbox.service.RepairerInfoService;
import org.apache.commons.lang3.StringUtils;
import org.hanzhdy.manager.settings.model.Area;
import org.hanzhdy.manager.settings.service.AreaService;
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
import java.util.List;

/**
 * Created by H.CAAHN on 2017/7/24.
 */
@Controller
@RequestMapping("/postbox/repairer")
public class RepairerInfoController extends ApplicationController {
    @Autowired
    private RepairerInfoService repairerInfoService;
    
    @Autowired
    private AreaService         areaService;
    
    /** 日志对象 */
    private static final Logger logger = LoggerFactory.getLogger(CompanyInfoController.class);
    
    /**
     * 维修人员列表页面
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String toList(Model model, HttpServletRequest request) {
        List<Area> provinceList = this.areaService.queryByParent(0l);
        model.addAttribute("provinceList", provinceList);
        model.addAttribute("statusList", DataStatus.values());
        return "/postbox/repairer/repairer-list";
    }
    
    /**
     * 请求获取维修人员列表数据
     * @param params
     * @param request
     * @return
     */
    @RequestMapping(value = "dataList", method = RequestMethod.POST)
    @ResponseBody
    public Object dataList(RepairerInfoParams params, HttpServletRequest request) {
        try {
            DatatableResult dataResult = this.repairerInfoService.queryAsDatatableResult(params);
            return JSON.toJSONString(dataResult);
        }
        catch (BizException ex) {
            logger.error("查询维修人员信息失败，查询参数：{}, 错误信息：[{}, {}]", JSON.toJSONString(params), ex.getCode(), ex.getMsg());
        }
        catch (Exception ex) {
            logger.error("查询维修人员信息失败，查询参数：" + JSON.toJSONString(params), ex);
        }
        return null;
    }
    
    /**
     * 跳转到编辑维修人员信息的页面
     * @param id
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "toEdit", method = RequestMethod.GET)
    public String toEdit(Long id, Model model, HttpServletRequest request) {
        List<Area> areaList = this.areaService.queryByParent(0l);
        model.addAttribute("provinceList", areaList);
        model.addAttribute("statusList", DataStatus.values());
        if (id != null) {
            RepairerInfo record = this.repairerInfoService.queryById(id);
            if (record != null) {
                if (StringUtils.isNotBlank(record.getProvince())) {
                    List<Area> cityList = this.areaService.queryByParentName(record.getProvince());
                    model.addAttribute("cityList", cityList);
                }
                
                model.addAttribute("record", record);
                return "/postbox/repairer/repairer-edit";
            }
            return redirect(REDIRECT_404);
        }
        else {
            return "/postbox/repairer/repairer-edit";
        }
    }
    
    /**
     * 保存维修人员信息
     * @param record
     * @param request
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public Object saveRepairerInfo(RepairerInfo record, HttpServletRequest request) {
        try {
            // 执行新增或更新操作
            boolean result = false;
            if (record.getRepairerInfoid() == null) {
                result = this.repairerInfoService.insert(record);
            }
            else {
                result = this.repairerInfoService.update(record);
            }
            
            // 处理返回结果
            return RespResult.create(result ? respCode.SUCCESS : respCode.SAVE_NORECORD);
        }
        catch (BizException ex) {
            logger.error("保存维修人员信息失败，数据参数：{}, 错误信息：[{}, {}]", JSON.toJSONString(record), ex.getCode(), ex.getMsg());
            return RespResult.create(ex.getCode(), ex.getMsg());
        }
        catch (Exception ex) {
            logger.error("保存维修人员信息失败，数据参数：" + JSON.toJSONString(record), ex);
            return RespResult.create(respCode.ERROR_EXCEPTION);
        }
    }
    
    /**
     * 处理更新维修人员状态请求
     * @param record
     * @param request
     * @return
     */
    @RequestMapping(value = "updateStatus", method = RequestMethod.POST)
    @ResponseBody
    public Object updateStatus(RepairerInfo record, HttpServletRequest request) {
        try {
            this.repairerInfoService.updateStatus(record);
            return RespResult.create(respCode.SUCCESS);
        }
        catch (BizException ex) {
            logger.error("更新维修人员状态失败，数据参数：{}, 错误信息：[{}, {}]", JSON.toJSONString(record), ex.getCode(), ex.getMsg());
            return RespResult.create(ex.getCode(), ex.getMsg());
        }
        catch (Exception ex) {
            logger.error("更新维修人员状态失败，数据参数：" + JSON.toJSONString(record), ex);
            return RespResult.create(respCode.ERROR_EXCEPTION);
        }
    }
}
