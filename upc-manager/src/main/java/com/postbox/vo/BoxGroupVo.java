package com.postbox.vo;

import com.postbox.enums.DataStatus;
import com.postbox.model.BoxGroup;

/**
 * Created by H.CAAHN on 2017/7/28.
 */
public class BoxGroupVo extends BoxGroup {
    private String repairerName;
    
    private DataStatus repairerStatus;
    
    public String getRepairerName() {
        return repairerName;
    }
    
    public void setRepairerName(String repairerName) {
        this.repairerName = repairerName;
    }
    
    public DataStatus getRepairerStatus() {
        return repairerStatus;
    }
    
    public void setRepairerStatus(DataStatus repairerStatus) {
        this.repairerStatus = repairerStatus;
    }
}
