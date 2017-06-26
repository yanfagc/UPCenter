package org.hanzhdy.manager.upc.controller.params;

import org.hanzhdy.manager.support.enums.CommonStatus;
import org.hanzhdy.web.bean.DatatableParams;

/**
 * @description Role查询条件
 * @author H.CAAHN
 * @createtime 2017年6月5日 上午11:15:03
 */
public class RoleParams extends DatatableParams {
    /** 序列化号 */
    private static final long serialVersionUID = 1005634560549081104L;
    
    /** 角色编码 */
    private String            rolecode;
    
    /** 角色名称 */
    private String            rolename;
    
    /** 角色组ID */
    private Long              groupid;
    
    /** 接入系统ID */
    private Long              systemId;
    
    /** 状态 */
    private CommonStatus      status;

    public String getRolecode() {
        return rolecode;
    }

    public void setRolecode(String rolecode) {
        this.rolecode = rolecode;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public Long getGroupid() {
        return groupid;
    }

    public void setGroupid(Long groupid) {
        this.groupid = groupid;
    }

    public Long getSystemId() {
        return systemId;
    }

    public void setSystemId(Long systemId) {
        this.systemId = systemId;
    }

    public CommonStatus getStatus() {
        return status;
    }

    public void setStatus(CommonStatus status) {
        this.status = status;
    }
}
