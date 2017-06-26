package org.hanzhdy.manager.upc.controller.params;

import org.hanzhdy.web.bean.DatatableParams;

/**
 * @description Menu查询条件
 * @author H.CAAHN
 * @createtime 2016年1月12日 下午10:48:28
 */
public class MenuParams extends DatatableParams {
    /** 序列化号 */
    private static final long serialVersionUID = 8109919804323149055L;
    
    /** 上级编码 */
    private Long              parentid;
    
    /** 系统ID */
    private Long              systemid;
    
    /** 菜单编码 */
    private String            menucode;
    
    /** 菜单名称 */
    private String            menuname;
    
    /** 地址类型 */
    private String            urltype;
    
    /** 菜单状态 */
    private String            status;
    
    /** 显示类型，item表示当前应查询菜单项表，否则查询菜单表 */
    private String            showtype;
    
    public Long getParentid() {
        return parentid;
    }
    
    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }
    
    public Long getSystemid() {
        return systemid;
    }
    
    public void setSystemid(Long systemid) {
        this.systemid = systemid;
    }
    
    public String getMenucode() {
        return menucode;
    }
    
    public void setMenucode(String menucode) {
        this.menucode = menucode;
    }
    
    public String getMenuname() {
        return menuname;
    }
    
    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }
    
    public String getUrltype() {
        return urltype;
    }
    
    public void setUrltype(String urltype) {
        this.urltype = urltype;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getShowtype() {
        return showtype;
    }
    
    public void setShowtype(String showtype) {
        this.showtype = showtype;
    }
}
