package org.hanzhdy.manager.settings.controller;

import com.alibaba.fastjson.JSON;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.hanzhdy.manager.settings.controller.params.AreaParams;
import org.hanzhdy.manager.settings.model.Area;
import org.hanzhdy.manager.settings.service.AreaService;
import org.hanzhdy.manager.support.constants.resp.ApiResult;
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
 * Area Controller - 地区管理
 * Created by H.CAAHN on 2017/7/28.
 */
@Controller
@RequestMapping("/basic/area")
public class AreaController extends ApplicationController {
    @Resource
    private AreaService areaService;
    
    /** 日志对象 */
    private static final Logger logger = LoggerFactory.getLogger(AreaController.class);
    
    /**
     * 打开地区管理列表页面
     * @param model
     * @param request
     * @return
     */
    @RequiresPermissions("basic:area:list")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model, HttpServletRequest request) {
        return "/basic/area/area-list";
    }
    
    /**
     * 查询地区列表数据
     * @param params
     * @param request
     * @return
     */
    @RequiresPermissions("basic:area:list")
    @RequestMapping(value = "dataList", method = RequestMethod.POST)
    @ResponseBody
    public Object dataList(AreaParams params, HttpServletRequest request) {
        DatatableResult dataResult;
        try {
            dataResult = this.areaService.queryAsDatatableResult(params);
        }
        catch (BizException ex) {
            logger.error("查询地区列表数据失败，查询参数：{}, 错误信息：[{}, {}]", JSON.toJSONString(params), ex.getCode(), ex.getBizMessage());
            dataResult = super.getEmptyDatatableResult();
        }
        catch (Exception ex) {
            logger.error("查询地区列表数据失败，查询参数：" + JSON.toJSONString(params), ex);
            dataResult = super.getEmptyDatatableResult();
        }
        return JSON.toJSONString(dataResult);
    }
    
    /**
     * 根据parent id查询区域信息
     * @param parent
     * @param response
     * @return
     */
    @RequiresPermissions("basic:area:find")
    @RequestMapping("findByParent")
    @ResponseBody
    public Object findByParent(Long parent, HttpServletResponse response) {
        try {
            List<Area> areaList = this.areaService.queryByParent(parent);
            // 处理返回结果
            return ApiResult.create(ApiResult.SUCCESS, areaList);
        }
        catch (Exception ex) {
            logger.error("根据parent查询区域信息失败，parent：" + parent, ex);
            return ApiResult.ERROR_EXCEPTION;
        }
    }
}
