package org.hanzhdy.manager.pay.model;

import java.io.Serializable;

public class AppInfo implements Serializable {
    public static final long serialVersionUID = -1381512285L;

    /**
     * : app_info.APP_ID
     * @author MyBatis Generator
     */
    private String appId;

    /**
     * : app_info.APIKEY
     * @author MyBatis Generator
     */
    private String apikey;

    /**
     * : app_info.APP_NAME
     * @author MyBatis Generator
     */
    private String appName;

    /**
     * : app_info.WHITE_LIST
     * @author MyBatis Generator
     */
    private String whiteList;

    /**
     * : app_info.STATUS
     * @author MyBatis Generator
     */
    private String status;

    /**
     * 获取: app_info.APP_ID
     * @return : app_info.APP_ID
     * @author MyBatis Generator
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置: app_info.APP_ID
     * @param appId 映射数据库字段: app_info.APP_ID
     * @author MyBatis Generator
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * 获取: app_info.APIKEY
     * @return : app_info.APIKEY
     * @author MyBatis Generator
     */
    public String getApikey() {
        return apikey;
    }

    /**
     * 设置: app_info.APIKEY
     * @param apikey 映射数据库字段: app_info.APIKEY
     * @author MyBatis Generator
     */
    public void setApikey(String apikey) {
        this.apikey = apikey == null ? null : apikey.trim();
    }

    /**
     * 获取: app_info.APP_NAME
     * @return : app_info.APP_NAME
     * @author MyBatis Generator
     */
    public String getAppName() {
        return appName;
    }

    /**
     * 设置: app_info.APP_NAME
     * @param appName 映射数据库字段: app_info.APP_NAME
     * @author MyBatis Generator
     */
    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    /**
     * 获取: app_info.WHITE_LIST
     * @return : app_info.WHITE_LIST
     * @author MyBatis Generator
     */
    public String getWhiteList() {
        return whiteList;
    }

    /**
     * 设置: app_info.WHITE_LIST
     * @param whiteList 映射数据库字段: app_info.WHITE_LIST
     * @author MyBatis Generator
     */
    public void setWhiteList(String whiteList) {
        this.whiteList = whiteList == null ? null : whiteList.trim();
    }

    /**
     * 获取: app_info.STATUS
     * @return : app_info.STATUS
     * @author MyBatis Generator
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置: app_info.STATUS
     * @param status 映射数据库字段: app_info.STATUS
     * @author MyBatis Generator
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}