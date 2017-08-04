package com.postbox.controller;

import com.alibaba.fastjson.JSON;
import com.postbox.controller.params.RepairRecordParams;
import com.postbox.enums.RepairStatus;
import com.postbox.model.BoxGroup;
import com.postbox.model.BoxInfo;
import com.postbox.model.RepairRecord;
import com.postbox.model.RepairStep;
import com.postbox.service.BoxGroupService;
import com.postbox.service.BoxInfoService;
import com.postbox.service.RepairRecordService;
import com.postbox.service.RepairStepService;
import org.hanzhdy.manager.settings.model.Area;
import org.hanzhdy.manager.settings.service.AreaService;
import org.hanzhdy.manager.support.bean.SessionUser;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 待维修，维修中的记录Controller
 * Created by H.CAAHN on 2017/8/3.
 */
@Controller
@RequestMapping("/postbox/repair")
public class RepairRecordController extends ApplicationController {
    @Resource
    private RepairRecordService repairRecordService;
    
    @Resource
    private BoxInfoService boxInfoService;
    
    @Resource
    private BoxGroupService boxGroupService;
    
    @Resource
    private RepairStepService repairStepService;
    
    @Resource
    private AreaService areaService;
    
    private static final Logger logger = LoggerFactory.getLogger(RepairRecordController.class);
    
    /**
     * 待维修、维修中列表页面
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String toList(Model model, HttpServletRequest request) {
        List<Area> provinceList = this.areaService.queryByParent(0l);
        model.addAttribute("provinceList", provinceList);
        model.addAttribute("statusList", new RepairStatus[] {RepairStatus.CHECKING, RepairStatus.PENDING, RepairStatus.REPAIRING});
        return "/postbox/repair/repairRecord-list";
    }
    
    /**
     * 维修完成、取消的列表页面
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "historyList", method = RequestMethod.GET)
    public String toHistoryList(Model model, HttpServletRequest request) {
        model.addAttribute("statusList", new RepairStatus[] {RepairStatus.COMPLETE, RepairStatus.CANCEL});
        return "/postbox/repair/repairHistory-list";
    }
    
    /**
     * 请求获取维修记录列表数据
     * @param params
     * @param request
     * @return
     */
    @RequestMapping(value = "dataList", method = RequestMethod.POST)
    @ResponseBody
    public Object dataList(RepairRecordParams params, HttpServletRequest request) {
        try {
            // 判断是否要查询历史维修记录
            if (params.getHistory() > 0) {
                params.setStatusArray(new RepairStatus[] {RepairStatus.COMPLETE, RepairStatus.CANCEL});
            }
            else {
                params.setStatusArray(new RepairStatus[] {RepairStatus.CHECKING, RepairStatus.PENDING, RepairStatus.REPAIRING});
            }
            DatatableResult dataResult = this.repairRecordService.queryAsDatatableResult(params);
            return JSON.toJSONString(dataResult);
        }
        catch (BizException ex) {
            logger.error("查询维修记录信息失败，查询参数：{}, 错误信息：[{}, {}]", JSON.toJSONString(params), ex.getCode(), ex.getMsg());
        }
        catch (Exception ex) {
            logger.error("查询维修记录信息失败，查询参数：" + JSON.toJSONString(params), ex);
        }
        return null;
    }
    
    /**
     * 跳转到审核记录报修记录的页面
     * @param id
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "toAudit", method = RequestMethod.GET)
    public String toAudit(@RequestParam("id") Long id, Model model, HttpServletRequest request) {
        model.addAttribute("statusList", RepairStatus.values());
        RepairRecord record = this.repairRecordService.queryById(id);
        if (record != null) {
            BoxInfo boxInfo = this.boxInfoService.queryById(record.getBoxInfoId());
            BoxGroup group = this.boxGroupService.queryById(boxInfo.getBoxGroupId());
            List<RepairStep> stepList = this.repairStepService.queryByRepairRecordId(id);
            
            model.addAttribute("steopList", stepList);
            model.addAttribute("record", record);
            model.addAttribute("boxInfo", boxInfo);
            model.addAttribute("group", group);
            return "/postbox/repair/repairRecord-audit";
        }
        return redirect(REDIRECT_404);
    }
    
    /**
     * 查看维修记录详情
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "viewDetail", method = RequestMethod.GET)
    public String viewDetail(Model model, @RequestParam("id") Long id) {
        model.addAttribute("statusList", RepairStatus.values());
        RepairRecord record = this.repairRecordService.queryById(id);
        if (record != null) {
            BoxInfo boxInfo = this.boxInfoService.queryById(record.getBoxInfoId());
            BoxGroup group = this.boxGroupService.queryById(boxInfo.getBoxGroupId());
            List<RepairStep> stepList = this.repairStepService.queryByRepairRecordId(id);
    
            model.addAttribute("steopList", stepList);
            model.addAttribute("record", record);
            model.addAttribute("boxInfo", boxInfo);
            model.addAttribute("group", group);
            return "/postbox/repair/repairRecord-detail";
        }
        return redirect(REDIRECT_404);
    }
    
    /**
     * 处理更新维修记录状态请求
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "updateStatus", method = RequestMethod.POST)
    @ResponseBody
    public Object updateStatus(@RequestParam("id") Long id, @RequestParam("status") RepairStatus status, String remark, HttpServletRequest request) {
        SessionUser user = super.getSessionUser(request);
        RepairRecord record = new RepairRecord();
        record.setRepairRecordId(id);
        record.setStatus(status);
        
        try {
            this.repairRecordService.updateStatus(record, user.getAccount(), user.getNickname(), remark);
            return RespResult.create(respCode.SUCCESS);
        }
        catch (BizException ex) {
            logger.error("更新维修记录状态失败，数据参数：{}, 错误信息：[{}, {}]", JSON.toJSONString(record), ex.getCode(), ex.getMsg());
            return RespResult.create(ex.getCode(), ex.getMsg());
        }
        catch (Exception ex) {
            logger.error("更新维修记录状态失败，数据参数：" + JSON.toJSONString(record), ex);
            return RespResult.create(respCode.ERROR_EXCEPTION);
        }
    }
}
