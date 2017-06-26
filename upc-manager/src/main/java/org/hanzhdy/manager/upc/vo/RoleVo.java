package org.hanzhdy.manager.upc.vo;

import org.hanzhdy.manager.upc.model.Role;

/**
 * @description 角色vo
 * @author H.CAAHN
 * @createtime 2017年6月5日 下午1:57:40
 */
public class RoleVo extends Role {
    /** 序列化号 */
    private static final long serialVersionUID = -973315009495278733L;

    private String groupname;
    
    private String systemname;
    
    public String getGroupname() {
        return groupname;
    }
    
    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }
    
    public String getSystemname() {
        return systemname;
    }
    
    public void setSystemname(String systemname) {
        this.systemname = systemname;
    }
    
}
