package org.hanzhdy.manager.upc.controller.params;

import org.hanzhdy.web.bean.DatatableParams;

/**
 * @description AccessSystem查询条件
 * @author H.CAAHN
 * @createtime 2016年10月7日 上午1:23:32
 */
public class AccessSystemParams extends DatatableParams {
    /** 序列化号 */
    private static final long serialVersionUID = 2166422996146974268L;
    
    /** 系统编码 */
    private String            syscode;
    
    /** 系统名称 */
    private String            sysname;
    
    /** 系统接入地址 */
    private String            sysaddr;
    
    /** 状态 */
    private String            status;
    
    public String getSyscode() {
        return syscode;
    }
    
    public void setSyscode(String syscode) {
        this.syscode = syscode;
    }
    
    public String getSysname() {
        return sysname;
    }
    
    public void setSysname(String sysname) {
        this.sysname = sysname;
    }
    
    public String getSysaddr() {
        return sysaddr;
    }
    
    public void setSysaddr(String sysaddr) {
        this.sysaddr = sysaddr;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
}
