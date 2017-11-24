package org.hanzhdy.manager.settings.vo;

import org.hanzhdy.manager.settings.model.Area;

/**
 * Created by H.CAAHN on 2017/11/17.
 */
public class AreaVo extends Area {
    private String parentName;
    
    public String getParentName() {
        return parentName;
    }
    
    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}
