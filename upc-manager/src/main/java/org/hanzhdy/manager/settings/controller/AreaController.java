package org.hanzhdy.manager.settings.controller;

import org.hanzhdy.manager.settings.model.Area;
import org.hanzhdy.manager.settings.service.AreaService;
import org.hanzhdy.manager.support.constants.resp.RespResult;
import org.hanzhdy.manager.support.controller.ApplicationController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
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
     * 根据parent id查询区域信息
     * @param parent
     * @param response
     * @return
     */
    @RequestMapping("findByParent")
    public Object findByParent(Long parent, HttpServletResponse response) {
        try {
            List<Area> areaList = this.areaService.queryByParent(parent);
            // 处理返回结果
            return RespResult.create(respCode.SUCCESS, areaList);
        }
        catch (Exception ex) {
            logger.error("根据parent查询区域信息失败，parent：" + parent, ex);
            return RespResult.create(respCode.ERROR_EXCEPTION);
        }
    }
}
