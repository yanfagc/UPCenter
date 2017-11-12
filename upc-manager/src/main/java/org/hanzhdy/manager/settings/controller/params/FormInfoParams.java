package org.hanzhdy.manager.settings.controller.params;

import org.hanzhdy.manager.support.enums.CommonStatus;
import org.hanzhdy.web.bean.DatatableParams;

/**
 * @description FormInfo查询条件
 * @author H.CAAHN
 * @createtime 2015年12月10日 下午10:41:38
 */
public class FormInfoParams extends DatatableParams {
    /** 序列化号 */
    private static final long serialVersionUID = -5231948054569949123L;
    
    private String            formcode;
    
    private String            formname;
    
    private CommonStatus      status;
    
    public String getFormcode() {
        return formcode;
    }
    
    public void setFormcode(String formcode) {
        this.formcode = formcode;
    }
    
    public String getFormname() {
        return formname;
    }
    
    public void setFormname(String formname) {
        this.formname = formname;
    }
    
    public CommonStatus getStatus() {
        return status;
    }
    
    public void setStatus(CommonStatus status) {
        this.status = status;
    }
}
