package org.hanzhdy.manager.upc.controller.params;

import org.hanzhdy.web.bean.DatatableParams;

/**
 * @description 角色分组查询条件
 * @author H.CAAHN
 * @createtime 2016年11月15日 下午9:18:03
 */
public class RoleGroupParams extends DatatableParams {
    /** 序列化号 */
    private static final long serialVersionUID = 3052535866225406917L;
    
    private String            groupcode;
    
    private String            groupname;
    
    public String getGroupcode() {
        return groupcode;
    }
    
    public void setGroupcode(String groupcode) {
        this.groupcode = groupcode;
    }
    
    public String getGroupname() {
        return groupname;
    }
    
    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }
}
