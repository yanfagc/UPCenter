package com.postbox.model;

import com.postbox.enums.BoxGroupStatus;
import java.io.Serializable;
import java.util.Date;

public class TBoxGroup implements Serializable {
    public static final long serialVersionUID = -1992674509L;

    /**
     * 箱子组ID: t_box_group.BOX_GROUP_ID
     * @author MyBatis Generator
     */
    private Long boxGroupId;

    /**
     * 名称: t_box_group.BOX_NAME
     * @author MyBatis Generator
     */
    private String boxName;

    /**
     * 详细地址: t_box_group.ADDRESS
     * @author MyBatis Generator
     */
    private String address;

    /**
     * 维修人员ID: t_box_group.REPAIRER_INFO_ID
     * @author MyBatis Generator
     */
    private Long repairerInfoId;

    /**
     * 状态,NOACTIVE未激活,NORMAL正常,FROZEN冻结,DEMISE销户: t_box_group.STATUS
     * @author MyBatis Generator
     */
    private BoxGroupStatus status;

    /**
     * 创建时间: t_box_group.CREATETIME
     * @author MyBatis Generator
     */
    private Date createtime;

    /**
     * 获取箱子组ID: t_box_group.BOX_GROUP_ID
     * @return 箱子组ID: t_box_group.BOX_GROUP_ID
     * @author MyBatis Generator
     */
    public Long getBoxGroupId() {
        return boxGroupId;
    }

    /**
     * 设置箱子组ID: t_box_group.BOX_GROUP_ID
     * @param boxGroupId 映射数据库字段: t_box_group.BOX_GROUP_ID
     * @author MyBatis Generator
     */
    public void setBoxGroupId(Long boxGroupId) {
        this.boxGroupId = boxGroupId;
    }

    /**
     * 获取名称: t_box_group.BOX_NAME
     * @return 名称: t_box_group.BOX_NAME
     * @author MyBatis Generator
     */
    public String getBoxName() {
        return boxName;
    }

    /**
     * 设置名称: t_box_group.BOX_NAME
     * @param boxName 映射数据库字段: t_box_group.BOX_NAME
     * @author MyBatis Generator
     */
    public void setBoxName(String boxName) {
        this.boxName = boxName == null ? null : boxName.trim();
    }

    /**
     * 获取详细地址: t_box_group.ADDRESS
     * @return 详细地址: t_box_group.ADDRESS
     * @author MyBatis Generator
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置详细地址: t_box_group.ADDRESS
     * @param address 映射数据库字段: t_box_group.ADDRESS
     * @author MyBatis Generator
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取维修人员ID: t_box_group.REPAIRER_INFO_ID
     * @return 维修人员ID: t_box_group.REPAIRER_INFO_ID
     * @author MyBatis Generator
     */
    public Long getRepairerInfoId() {
        return repairerInfoId;
    }

    /**
     * 设置维修人员ID: t_box_group.REPAIRER_INFO_ID
     * @param repairerInfoId 映射数据库字段: t_box_group.REPAIRER_INFO_ID
     * @author MyBatis Generator
     */
    public void setRepairerInfoId(Long repairerInfoId) {
        this.repairerInfoId = repairerInfoId;
    }

    /**
     * 获取状态,NOACTIVE未激活,NORMAL正常,FROZEN冻结,DEMISE销户: t_box_group.STATUS
     * @return 状态,NOACTIVE未激活,NORMAL正常,FROZEN冻结,DEMISE销户: t_box_group.STATUS
     * @author MyBatis Generator
     */
    public BoxGroupStatus getStatus() {
        return status;
    }

    /**
     * 设置状态,NOACTIVE未激活,NORMAL正常,FROZEN冻结,DEMISE销户: t_box_group.STATUS
     * @param status 映射数据库字段: t_box_group.STATUS
     * @author MyBatis Generator
     */
    public void setStatus(BoxGroupStatus status) {
        this.status = status;
    }

    /**
     * 获取创建时间: t_box_group.CREATETIME
     * @return 创建时间: t_box_group.CREATETIME
     * @author MyBatis Generator
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间: t_box_group.CREATETIME
     * @param createtime 映射数据库字段: t_box_group.CREATETIME
     * @author MyBatis Generator
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}