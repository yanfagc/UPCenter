package org.hanzhdy.manager.upc.model;

import java.io.Serializable;
import java.util.Date;
import org.hanzhdy.manager.support.enums.CommonStatus;

public class MenuItem implements Serializable {
    public static final long serialVersionUID = 510088327537160798L;

    /**
     * ID号: r_menuitem.ID
     * @author MyBatis Generator
     */
    private Long id;

    /**
     * 菜单项编码: r_menuitem.ITEMCODE
     * @author MyBatis Generator
     */
    private String itemcode;

    /**
     * 菜单项名称: r_menuitem.ITEMNAME
     * @author MyBatis Generator
     */
    private String itemname;

    /**
     * 菜单ID: r_menuitem.MENUID
     * @author MyBatis Generator
     */
    private Long menuId;

    /**
     * 菜单项图标: r_menuitem.ITEMICON
     * @author MyBatis Generator
     */
    private String itemicon;

    /**
     * URL地址: r_menuitem.RESOURCE
     * @author MyBatis Generator
     */
    private String resource;

    /**
     * 排序: r_menuitem.SORT
     * @author MyBatis Generator
     */
    private Short sort;

    /**
     * 状态.N正常,F冻结,D无效: r_menuitem.STATUS
     * @author MyBatis Generator
     */
    private CommonStatus status;

    /**
     * 创建时间: r_menuitem.CREATETIME
     * @author MyBatis Generator
     */
    private Date createtime;

    /**
     * 更新时间: r_menuitem.UPDATETIME
     * @author MyBatis Generator
     */
    private Date updatetime;

    /**
     * 创建人: r_menuitem.CREATOR
     * @author MyBatis Generator
     */
    private Long creator;

    /**
     * 更新人: r_menuitem.UPDATER
     * @author MyBatis Generator
     */
    private Long updater;

    /**
     * 获取ID号: r_menuitem.ID
     * @return ID号: r_menuitem.ID
     * @author MyBatis Generator
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置ID号: r_menuitem.ID
     * @param id 映射数据库字段: r_menuitem.ID
     * @author MyBatis Generator
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取菜单项编码: r_menuitem.ITEMCODE
     * @return 菜单项编码: r_menuitem.ITEMCODE
     * @author MyBatis Generator
     */
    public String getItemcode() {
        return itemcode;
    }

    /**
     * 设置菜单项编码: r_menuitem.ITEMCODE
     * @param itemcode 映射数据库字段: r_menuitem.ITEMCODE
     * @author MyBatis Generator
     */
    public void setItemcode(String itemcode) {
        this.itemcode = itemcode == null ? null : itemcode.trim();
    }

    /**
     * 获取菜单项名称: r_menuitem.ITEMNAME
     * @return 菜单项名称: r_menuitem.ITEMNAME
     * @author MyBatis Generator
     */
    public String getItemname() {
        return itemname;
    }

    /**
     * 设置菜单项名称: r_menuitem.ITEMNAME
     * @param itemname 映射数据库字段: r_menuitem.ITEMNAME
     * @author MyBatis Generator
     */
    public void setItemname(String itemname) {
        this.itemname = itemname == null ? null : itemname.trim();
    }

    /**
     * 获取菜单ID: r_menuitem.MENUID
     * @return 菜单ID: r_menuitem.MENUID
     * @author MyBatis Generator
     */
    public Long getMenuId() {
        return menuId;
    }

    /**
     * 设置菜单ID: r_menuitem.MENUID
     * @param menuId 映射数据库字段: r_menuitem.MENUID
     * @author MyBatis Generator
     */
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    /**
     * 获取菜单项图标: r_menuitem.ITEMICON
     * @return 菜单项图标: r_menuitem.ITEMICON
     * @author MyBatis Generator
     */
    public String getItemicon() {
        return itemicon;
    }

    /**
     * 设置菜单项图标: r_menuitem.ITEMICON
     * @param itemicon 映射数据库字段: r_menuitem.ITEMICON
     * @author MyBatis Generator
     */
    public void setItemicon(String itemicon) {
        this.itemicon = itemicon == null ? null : itemicon.trim();
    }

    /**
     * 获取URL地址: r_menuitem.RESOURCE
     * @return URL地址: r_menuitem.RESOURCE
     * @author MyBatis Generator
     */
    public String getResource() {
        return resource;
    }

    /**
     * 设置URL地址: r_menuitem.RESOURCE
     * @param resource 映射数据库字段: r_menuitem.RESOURCE
     * @author MyBatis Generator
     */
    public void setResource(String resource) {
        this.resource = resource == null ? null : resource.trim();
    }

    /**
     * 获取排序: r_menuitem.SORT
     * @return 排序: r_menuitem.SORT
     * @author MyBatis Generator
     */
    public Short getSort() {
        return sort;
    }

    /**
     * 设置排序: r_menuitem.SORT
     * @param sort 映射数据库字段: r_menuitem.SORT
     * @author MyBatis Generator
     */
    public void setSort(Short sort) {
        this.sort = sort;
    }

    /**
     * 获取状态.N正常,F冻结,D无效: r_menuitem.STATUS
     * @return 状态.N正常,F冻结,D无效: r_menuitem.STATUS
     * @author MyBatis Generator
     */
    public CommonStatus getStatus() {
        return status;
    }

    /**
     * 设置状态.N正常,F冻结,D无效: r_menuitem.STATUS
     * @param status 映射数据库字段: r_menuitem.STATUS
     * @author MyBatis Generator
     */
    public void setStatus(CommonStatus status) {
        this.status = status;
    }

    /**
     * 获取创建时间: r_menuitem.CREATETIME
     * @return 创建时间: r_menuitem.CREATETIME
     * @author MyBatis Generator
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间: r_menuitem.CREATETIME
     * @param createtime 映射数据库字段: r_menuitem.CREATETIME
     * @author MyBatis Generator
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取更新时间: r_menuitem.UPDATETIME
     * @return 更新时间: r_menuitem.UPDATETIME
     * @author MyBatis Generator
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 设置更新时间: r_menuitem.UPDATETIME
     * @param updatetime 映射数据库字段: r_menuitem.UPDATETIME
     * @author MyBatis Generator
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * 获取创建人: r_menuitem.CREATOR
     * @return 创建人: r_menuitem.CREATOR
     * @author MyBatis Generator
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * 设置创建人: r_menuitem.CREATOR
     * @param creator 映射数据库字段: r_menuitem.CREATOR
     * @author MyBatis Generator
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    /**
     * 获取更新人: r_menuitem.UPDATER
     * @return 更新人: r_menuitem.UPDATER
     * @author MyBatis Generator
     */
    public Long getUpdater() {
        return updater;
    }

    /**
     * 设置更新人: r_menuitem.UPDATER
     * @param updater 映射数据库字段: r_menuitem.UPDATER
     * @author MyBatis Generator
     */
    public void setUpdater(Long updater) {
        this.updater = updater;
    }
}