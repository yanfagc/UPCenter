package org.hanzhdy.manager.settings.controller.params;

import org.hanzhdy.web.bean.DatatableParams;

/**
 * 地区管理查询参数
 * Created by H.CAAHN on 2017/11/16.
 */
public class AreaParams extends DatatableParams {
    private String status;
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
}
