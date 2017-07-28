package org.hanzhdy.manager.settings.model;

import java.io.Serializable;
import java.util.Date;

public class Area implements Serializable {
    public static final long serialVersionUID = -1827347300L;

    /**
     * id: t_area.id
     * @author MyBatis Generator
     */
    private Long id;

    /**
     * 省市区ID: t_area.node
     * @author MyBatis Generator
     */
    private Long node;

    /**
     * 父级ID: t_area.parent
     * @author MyBatis Generator
     */
    private Long parent;

    /**
     * 省市区名称: t_area.name
     * @author MyBatis Generator
     */
    private String name;

    /**
     * 省市区缩写: t_area.spell
     * @author MyBatis Generator
     */
    private String spell;

    /**
     * 状态 'N':正常, 'C':'注销': t_area.status
     * @author MyBatis Generator
     */
    private String status;

    /**
     * 创建时间: t_area.createtime
     * @author MyBatis Generator
     */
    private Date createtime;

    /**
     * 注销时间: t_area.canceltime
     * @author MyBatis Generator
     */
    private Date canceltime;

    /**
     * 获取id: t_area.id
     * @return id: t_area.id
     * @author MyBatis Generator
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id: t_area.id
     * @param id 映射数据库字段: t_area.id
     * @author MyBatis Generator
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取省市区ID: t_area.node
     * @return 省市区ID: t_area.node
     * @author MyBatis Generator
     */
    public Long getNode() {
        return node;
    }

    /**
     * 设置省市区ID: t_area.node
     * @param node 映射数据库字段: t_area.node
     * @author MyBatis Generator
     */
    public void setNode(Long node) {
        this.node = node;
    }

    /**
     * 获取父级ID: t_area.parent
     * @return 父级ID: t_area.parent
     * @author MyBatis Generator
     */
    public Long getParent() {
        return parent;
    }

    /**
     * 设置父级ID: t_area.parent
     * @param parent 映射数据库字段: t_area.parent
     * @author MyBatis Generator
     */
    public void setParent(Long parent) {
        this.parent = parent;
    }

    /**
     * 获取省市区名称: t_area.name
     * @return 省市区名称: t_area.name
     * @author MyBatis Generator
     */
    public String getName() {
        return name;
    }

    /**
     * 设置省市区名称: t_area.name
     * @param name 映射数据库字段: t_area.name
     * @author MyBatis Generator
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取省市区缩写: t_area.spell
     * @return 省市区缩写: t_area.spell
     * @author MyBatis Generator
     */
    public String getSpell() {
        return spell;
    }

    /**
     * 设置省市区缩写: t_area.spell
     * @param spell 映射数据库字段: t_area.spell
     * @author MyBatis Generator
     */
    public void setSpell(String spell) {
        this.spell = spell == null ? null : spell.trim();
    }

    /**
     * 获取状态 'N':正常, 'C':'注销': t_area.status
     * @return 状态 'N':正常, 'C':'注销': t_area.status
     * @author MyBatis Generator
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态 'N':正常, 'C':'注销': t_area.status
     * @param status 映射数据库字段: t_area.status
     * @author MyBatis Generator
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取创建时间: t_area.createtime
     * @return 创建时间: t_area.createtime
     * @author MyBatis Generator
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间: t_area.createtime
     * @param createtime 映射数据库字段: t_area.createtime
     * @author MyBatis Generator
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取注销时间: t_area.canceltime
     * @return 注销时间: t_area.canceltime
     * @author MyBatis Generator
     */
    public Date getCanceltime() {
        return canceltime;
    }

    /**
     * 设置注销时间: t_area.canceltime
     * @param canceltime 映射数据库字段: t_area.canceltime
     * @author MyBatis Generator
     */
    public void setCanceltime(Date canceltime) {
        this.canceltime = canceltime;
    }
}