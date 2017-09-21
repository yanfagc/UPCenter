package org.hanzhdy.manager.pay.service;

import org.apache.commons.lang3.StringUtils;
import org.hanzhdy.manager.pay.controller.params.AppInfoParams;
import org.hanzhdy.manager.pay.mapper.AppInfoMapperExt;
import org.hanzhdy.manager.pay.model.AppInfo;
import org.hanzhdy.manager.pay.vo.AppInfoVo;
import org.hanzhdy.web.bean.DatatableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangchengzhi
 * @description 商户支付信息管理Service
 * @createtime 2017年9月8日
 */
@Service
public class AppInfoService {

    @Autowired
    private AppInfoMapperExt appInfoMapperExt;


    /**
     * 根据ID号查询角色信息
     *
     * @param id
     * @return
     */
    public AppInfo queryById(String id) {
        return this.appInfoMapperExt.selectByPrimaryKey(id);
    }

    /**
     * 分页查询角色信息，并按条件返回符合datatable数据格式的信息
     *
     * @param params
     * @return
     */
    public DatatableResult queryAsDatatableResult(AppInfoParams params) {
        // 构造查询条件
        Map<String, Object> search = new HashMap<String, Object>();
        search.put("page", params.createPage());
        if (StringUtils.isNotBlank(params.getSearchkey())) {
            search.put("searchkey", "%" + params.getSearchkey() + "%");
        }
        if (StringUtils.isNotBlank(params.getAppId())) {
            search.put("appId", "%" + params.getAppId() + "%");
        }
        if (StringUtils.isNotBlank(params.getAppName())) {
            search.put("appName", "%" + params.getAppName() + "%");
        }
        if (StringUtils.isNotBlank(params.getApikey())) {
            search.put("apikey", "%" + params.getApikey() + "%");
        }
        if (StringUtils.isNotBlank(params.getWhiteList())) {
            search.put("whiteList", "%" + params.getWhiteList() + "%");
        }
        if (StringUtils.isNotBlank(params.getStatus())) {
            search.put("status", params.getStatus());
        }

        // 查询数据
        int count = this.appInfoMapperExt.countAsList(search);
        List<AppInfoVo> data = this.appInfoMapperExt.selectAsList(search);

        // 设置返回结果
        DatatableResult result = new DatatableResult();
        result.setTotal(count);
        result.setAaData(data);
        return result;
    }

    /**
     * 插入新的支付应用账号信息
     *
     * @param record
     * @return
     */
    public boolean insert(AppInfo record) {
        int count = this.appInfoMapperExt.insertSelectiveExt(record);
        return count > 0;
    }

    /**
     * 更新支付应用账号信息
     *
     * @param record
     * @return
     */
    public boolean update(AppInfo record) {
        int count = this.appInfoMapperExt.updateByPrimaryKeySelective(record);
        return count > 0;
    }

    /**
     * 更新支付应用账号信息（可修改APP_ID）
     *
     * @param record
     * @return
     */
    public boolean updateAppId(AppInfo record,String oldAppId) {
        // 构造更替APP_ID条件
        Map<String, Object> params = new HashMap<String, Object>();
        if (StringUtils.isNotBlank(record.getAppId())) {
            params.put("appId", record.getAppId());
        }
        if (StringUtils.isNotBlank(record.getAppName())) {
            params.put("appName", record.getAppName());
        }
        if (StringUtils.isNotBlank(record.getApikey())) {
            params.put("apikey", record.getApikey());
        }
        if (StringUtils.isNotBlank(record.getWhiteList())) {
            params.put("whiteList", record.getWhiteList());
        }
        if (StringUtils.isNotBlank(record.getStatus())) {
            params.put("status", record.getStatus());
        }
        if (StringUtils.isNotBlank(oldAppId)) {
            params.put("oldAppId", oldAppId);
        }

        int count = this.appInfoMapperExt.updateByOldAppIdSelective(params);
        return count > 0;
    }

    /**
     * 更新支付应用账号状态
     * @param record
     * @return
     */
    public boolean updateStatus(AppInfo record) {
        AppInfo appInfo = new AppInfo();
        appInfo.setAppId(record.getAppId());
        appInfo.setStatus(record.getStatus());
        int count = this.appInfoMapperExt.updateByPrimaryKeySelective(appInfo);
        return count > 0;
    }

}
