package com.postbox.controller;

import com.alibaba.fastjson.JSON;
import com.postbox.controller.params.BoxGroupParams;
import com.postbox.enums.ActiveStatus;
import com.postbox.model.BoxGroup;
import com.postbox.model.CompanyInfo;
import com.postbox.service.BoxGroupService;
import com.postbox.service.CompanyInfoService;
import org.apache.commons.lang3.StringUtils;
import org.hanzhdy.manager.settings.model.Area;
import org.hanzhdy.manager.settings.service.AreaService;
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
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 箱子组管理
 * Created by H.CAAHN on 2017/7/28.
 */
@Controller
@RequestMapping("/postbox/boxgroup")
public class BoxGroupController extends ApplicationController {
    @Resource
    private BoxGroupService     boxGroupService;
    
    @Resource
    private CompanyInfoService  companyInfoService;
    
    @Resource
    private AreaService         areaService;
    
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
        List<Area> provinceList = this.areaService.queryByParent(0l);
        model.addAttribute("provinceList", provinceList);
        model.addAttribute("statusList", ActiveStatus.values());
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
        List<Area> provinceList = this.areaService.queryByParent(0l);
        List<CompanyInfo> companyInfoList = this.companyInfoService.queryAsList();
        model.addAttribute("companyList", companyInfoList);
        model.addAttribute("statusList", ActiveStatus.values());
        model.addAttribute("provinceList", provinceList);
        if (id != null) {
            BoxGroup record = this.boxGroupService.queryById(id);
            if (record != null) {
                if (record.getProvince() != null) {
                    model.addAttribute("cityList", this.areaService.queryByParentName(record.getProvince()));
                }
                
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
     * 查找箱子组信息（一般用于ajax查找，最多返回20条）
     * @param params
     * @param response
     * @return
     */
    @RequestMapping(value = "ajaxFind", method = RequestMethod.POST)
    @ResponseBody
    public Object ajaxFind(BoxGroupParams params, HttpServletResponse response) {
        try {
            List<BoxGroup> dataList = this.boxGroupService.queryForAjax(params, ActiveStatus.NORMAL, ActiveStatus.NOACTIVE);
            // 处理返回结果
            return RespResult.create(respCode.SUCCESS, dataList);
        }
        catch (Exception ex) {
            logger.error("根据区域查询箱子组人员失败，查询参数：" + JSON.toJSONString(params), ex);
            return RespResult.create(respCode.ERROR_EXCEPTION);
        }
    }
    
    /**
     * 弹出框-查找箱子组
     * @param model
     * @param province
     * @param city
     * @param request
     * @return
     */
    @RequestMapping(value = "dialogfind", method = RequestMethod.GET)
    public Object dialogfind(Model model, String province, String city, Long id, HttpServletRequest request) {
        List<Area> provinceList = this.areaService.queryByParent(0l);
        model.addAttribute("provinceList", provinceList);
        if (StringUtils.isNotBlank(province)) {
            List<Area> cityList = this.areaService.queryByParentName(province);
            model.addAttribute("cityList", cityList);
        }
        model.addAttribute("statusList", ActiveStatus.values());
        model.addAttribute("province", province);
        model.addAttribute("city", city);
        model.addAttribute("checkedId", id);
        return "/postbox/boxgroup/boxgroup-dialog";
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
