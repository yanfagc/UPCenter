package org.hanzhdy.upc.api.client.bean;

/**
 * 配置信息
 * Created by H.CAAHN on 2017/7/5.
 */
public class UPCConfigure {
    /** 客户端本地缓存时间，单位：分钟，小于等于0时，代表不缓存 */
    private int cachetime;
    
    /** 服务器根路径 */
    private String serverContextPath;
    
    /** 登录地址 */
    private String loginPath;
    
    private static final String _loginPath = "api/login";
    
    public int getCachetime() {
        return cachetime;
    }
    
    public void setCachetime(int cachetime) {
        this.cachetime = cachetime;
    }
    
    public String getServerContextPath() {
        return serverContextPath;
    }
    
    public void setServerContextPath(String serverContextPath) {
        this.serverContextPath = serverContextPath;
        if (this.serverContextPath != null) {
            if (this.serverContextPath.endsWith("/") || this.serverContextPath.endsWith("\\")) {
                this.serverContextPath += "/";
            }
            this.loginPath = this.serverContextPath + _loginPath;
        }
    }
    
    public String getLoginPath() {
        return loginPath;
    }
    
    public void setLoginPath(String loginPath) {
        this.loginPath = loginPath;
    }
}
