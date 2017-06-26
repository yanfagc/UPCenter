package org.hanzhdy.manager.upc.model;

import java.io.Serializable;
import java.util.Date;

import org.hanzhdy.manager.support.enums.CommonStatus;
import org.hanzhdy.manager.support.enums.URLType;

public class Menu implements Serializable {
    public static final long serialVersionUID = 1913147563L;

    /**
     * ID号: r_menu.ID
     * @author MyBatis Generator
     */
    private Long id;

    /**
     * 菜单编码: r_menu.MENUCODE
     * @author MyBatis Generator
     */
    private String menucode;

    /**
     * 菜单名称: r_menu.MENUNAME
     * @author MyBatis Generator
     */
    private String menuname;

    /**
     * 上级菜单ID: r_menu.PARENTID
     * @author MyBatis Generator
     */
    private Long parentId;

    /**
     * 系统ID: r_menu.SYSTEMID
     * @author MyBatis Generator
     */
    private Long systemId;

    /**
     * 菜单图标: r_menu.MENUICON
     * @author MyBatis Generator
     */
    private String menuicon;

    /**
     * 地址类型.M菜单目录(无地址),R相对地址,A绝对地址: r_menu.URLTYPE
     * @author MyBatis Generator
     */
    private URLType urltype;

    /**
     * 菜单地址: r_menu.MENUURL
     * @author MyBatis Generator
     */
    private String menuurl;

    /**
     * 排序: r_menu.SORT
     * @author MyBatis Generator
     */
    private Short sort;

    /**
     * 状态.N正常,F冻结,D无效: r_menu.STATUS
     * @author MyBatis Generator
     */
    private CommonStatus status;

    /**
     * 创建时间: r_menu.CREATETIME
     * @author MyBatis Generator
     */
    private Date createtime;

    /**
     * 更新时间: r_menu.UPDATETIME
     * @author MyBatis Generator
     */
    private Date updatetime;

    /**
     * 创建人: r_menu.CREATOR
     * @author MyBatis Generator
     */
    private Long creator;

    /**
     * 更新人: r_menu.UPDATER
     * @author MyBatis Generator
     */
    private Long updater;

    /**
     * 获取ID号: r_menu.ID
     * @return ID号: r_menu.ID
     * @author MyBatis Generator
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置ID号: r_menu.ID
     * @param id 映射数据库字段: r_menu.ID
     * @author MyBatis Generator
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取菜单编码: r_menu.MENUCODE
     * @return 菜单编码: r_menu.MENUCODE
     * @author MyBatis Generator
     */
    public String getMenucode() {
        return menucode;
    }

    /**
     * 设置菜单编码: r_menu.MENUCODE
     * @param menucode 映射数据库字段: r_menu.MENUCODE
     * @author MyBatis Generator
     */
    public void setMenucode(String menucode) {
        this.menucode = menucode == null ? null : menucode.trim();
    }

    /**
     * 获取菜单名称: r_menu.MENUNAME
     * @return 菜单名称: r_menu.MENUNAME
     * @author MyBatis Generator
     */
    public String getMenuname() {
        return menuname;
    }

    /**
     * 设置菜单名称: r_menu.MENUNAME
     * @param menuname 映射数据库字段: r_menu.MENUNAME
     * @author MyBatis Generator
     */
    public void setMenuname(String menuname) {
        this.menuname = menuname == null ? null : menuname.trim();
    }

    /**
     * 获取上级菜单ID: r_menu.PARENTID
     * @return 上级菜单ID: r_menu.PARENTID
     * @author MyBatis Generator
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置上级菜单ID: r_menu.PARENTID
     * @param parentId 映射数据库字段: r_menu.PARENTID
     * @author MyBatis Generator
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取系统ID: r_menu.SYSTEMID
     * @return 系统ID: r_menu.SYSTEMID
     * @author MyBatis Generator
     */
    public Long getSystemId() {
        return systemId;
    }

    /**
     * 设置系统ID: r_menu.SYSTEMID
     * @param systemId 映射数据库字段: r_menu.SYSTEMID
     * @author MyBatis Generator
     */
    public void setSystemId(Long systemId) {
        this.systemId = systemId;
    }

    /**
     * 获取菜单图标: r_menu.MENUICON
     * @return 菜单图标: r_menu.MENUICON
     * @author MyBatis Generator
     */
    public String getMenuicon() {
        return menuicon;
    }

    /**
     * 设置菜单图标: r_menu.MENUICON
     * @param menuicon 映射数据库字段: r_menu.MENUICON
     * @author MyBatis Generator
     */
    public void setMenuicon(String menuicon) {
        this.menuicon = menuicon == null ? null : menuicon.trim();
    }

    /**
     * 获取地址类型.M菜单目录(无地址),R相对地址,A绝对地址: r_menu.URLTYPE
     * @return 地址类型.M菜单目录(无地址),R相对地址,A绝对地址: r_menu.URLTYPE
     * @author MyBatis Generator
     */
    public URLType getUrltype() {
        return urltype;
    }

    /**
     * 设置地址类型.M菜单目录(无地址),R相对地址,A绝对地址: r_menu.URLTYPE
     * @param urltype 映射数据库字段: r_menu.URLTYPE
     * @author MyBatis Generator
     */
    public void setUrltype(URLType urltype) {
        this.urltype = urltype;
    }

    /**
     * 获取菜单地址: r_menu.MENUURL
     * @return 菜单地址: r_menu.MENUURL
     * @author MyBatis Generator
     */
    public String getMenuurl() {
        return menuurl;
    }

    /**
     * 设置菜单地址: r_menu.MENUURL
     * @param menuurl 映射数据库字段: r_menu.MENUURL
     * @author MyBatis Generator
     */
    public void setMenuurl(String menuurl) {
        this.menuurl = menuurl == null ? null : menuurl.trim();
    }

    /**
     * 获取排序: r_menu.SORT
     * @return 排序: r_menu.SORT
     * @author MyBatis Generator
     */
    public Short getSort() {
        return sort;
    }

    /**
     * 设置排序: r_menu.SORT
     * @param sort 映射数据库字段: r_menu.SORT
     * @author MyBatis Generator
     */
    public void setSort(Short sort) {
        this.sort = sort;
    }

    /**
     * 获取状态.N正常,F冻结,D无效: r_menu.STATUS
     * @return 状态.N正常,F冻结,D无效: r_menu.STATUS
     * @author MyBatis Generator
     */
    public CommonStatus getStatus() {
        return status;
    }

    /**
     * 设置状态.N正常,F冻结,D无效: r_menu.STATUS
     * @param status 映射数据库字段: r_menu.STATUS
     * @author MyBatis Generator
     */
    public void setStatus(CommonStatus status) {
        this.status = status;
    }

    /**
     * 获取创建时间: r_menu.CREATETIME
     * @return 创建时间: r_menu.CREATETIME
     * @author MyBatis Generator
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间: r_menu.CREATETIME
     * @param createtime 映射数据库字段: r_menu.CREATETIME
     * @author MyBatis Generator
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取更新时间: r_menu.UPDATETIME
     * @return 更新时间: r_menu.UPDATETIME
     * @author MyBatis Generator
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 设置更新时间: r_menu.UPDATETIME
     * @param updatetime 映射数据库字段: r_menu.UPDATETIME
     * @author MyBatis Generator
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * 获取创建人: r_menu.CREATOR
     * @return 创建人: r_menu.CREATOR
     * @author MyBatis Generator
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * 设置创建人: r_menu.CREATOR
     * @param creator 映射数据库字段: r_menu.CREATOR
     * @author MyBatis Generator
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    /**
     * 获取更新人: r_menu.UPDATER
     * @return 更新人: r_menu.UPDATER
     * @author MyBatis Generator
     */
    public Long getUpdater() {
        return updater;
    }

    /**
     * 设置更新人: r_menu.UPDATER
     * @param updater 映射数据库字段: r_menu.UPDATER
     * @author MyBatis Generator
     */
    public void setUpdater(Long updater) {
        this.updater = updater;
    }
}