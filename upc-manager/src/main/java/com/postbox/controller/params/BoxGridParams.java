package com.postbox.controller.params;

import org.hanzhdy.web.bean.DatatableParams;

/**
 * Created by H.CAAHN on 2017/8/24.
 */
public class BoxGridParams extends DatatableParams {
    private Long boxInfoId;
    
    private String gridCode;
    
    public Long getBoxInfoId() {
        return boxInfoId;
    }
    
    public void setBoxInfoId(Long boxInfoId) {
        this.boxInfoId = boxInfoId;
    }
    
    public String getGridCode() {
        return gridCode;
    }
    
    public void setGridCode(String gridCode) {
        this.gridCode = gridCode;
    }
}
