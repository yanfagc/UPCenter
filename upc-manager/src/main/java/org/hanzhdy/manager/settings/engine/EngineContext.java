package org.hanzhdy.manager.settings.engine;

import javax.servlet.http.HttpServletRequest;

/**
 * @description 表单引擎上下文
 * @author H.CAAHN
 * @createtime 2017年6月13日 上午11:59:51
 */
public class EngineContext {
    private int                maxColumns;
    
    private HttpServletRequest request;
    
    public int getMaxColumns() {
        return maxColumns;
    }
    
    public void setMaxColumns(int maxColumns) {
        this.maxColumns = maxColumns;
    }
    
    public EngineContext(HttpServletRequest request) {
        this.request = request;
    }
    
    public HttpServletRequest getRequest() {
        return this.request;
    }
}
