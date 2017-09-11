package org.hanzhdy.manager.pay.controller.params;

import org.hanzhdy.web.bean.DatatableParams;

/**
 * @description 支付应用账号信息 查询条件
 * @author wangchengzhi
 * @createtime 2017年9月9日
 */
public class AppInfoParams extends DatatableParams {
    /** 序列化号 */
    private static final long serialVersionUID = -5446839768415224796L;

    private String appId;

    private String apikey;

    private String appName;

    private String whiteList;

    private String status;

    private String oldAppId;

    public String getOldAppId() {
        return oldAppId;
    }

    public void setOldAppId(String oldAppId) {
        this.oldAppId = oldAppId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getWhiteList() {
        return whiteList;
    }

    public void setWhiteList(String whiteList) {
        this.whiteList = whiteList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
