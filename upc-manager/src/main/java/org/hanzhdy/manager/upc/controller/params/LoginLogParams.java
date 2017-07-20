package org.hanzhdy.manager.upc.controller.params;

import org.hanzhdy.web.bean.DatatableParams;

import java.util.Date;

/**
 * Created by H.CAAHN on 2017/7/19.
 */
public class LoginLogParams extends DatatableParams {
    private Date beginLogintime;
    
    private Date endLogintime;
    
    public Date getBeginLogintime() {
        return beginLogintime;
    }
    
    public void setBeginLogintime(Date beginLogintime) {
        this.beginLogintime = beginLogintime;
    }
    
    public Date getEndLogintime() {
        return endLogintime;
    }
    
    public void setEndLogintime(Date endLogintime) {
        this.endLogintime = endLogintime;
    }
}
