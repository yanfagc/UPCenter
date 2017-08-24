package com.postbox.model;

import com.postbox.enums.ActiveStatus;
import java.io.Serializable;
import java.util.Date;

public class BoxInfo implements Serializable {
    public static final long serialVersionUID = -13739260L;

    /**
     * 箱子ID: t_box_info.BOX_INFO_ID
     * @author MyBatis Generator
     */
    private Long boxInfoId;

    /**
     * 加密密钥: t_box_info.SEC_KEY
     * @author MyBatis Generator
     */
    private String secKey;

    /**
     * 所属箱子组: t_box_info.BOX_GROUP_ID
     * @author MyBatis Generator
     */
    private Long boxGroupId;

    /**
     * 经度: t_box_info.LONGITUDE
     * @author MyBatis Generator
     */
    private String longitude;

    /**
     * 纬度: t_box_info.LATITUDE
     * @author MyBatis Generator
     */
    private String latitude;

    /**
     * 状态: t_box_info.STATUS
     * @author MyBatis Generator
     */
    private ActiveStatus status;

    /**
     * 详细地址: t_box_info.ADDRESS
     * @author MyBatis Generator
     */
    private String address;

    /**
     * 校验数值,用于客户端传递的值必须大于服务器保存的值,默认值为0: t_box_info.CHECKNUM
     * @author MyBatis Generator
     */
    private Integer checknum;

    /**
     * 创建时间: t_box_info.CREATETIME
     * @author MyBatis Generator
     */
    private Date createtime;

    /**
     * 激活时间: t_box_info.ACTIVETIME
     * @author MyBatis Generator
     */
    private Date activetime;

    /**
     * 注销时间: t_box_info.FROZENTIME
     * @author MyBatis Generator
     */
    private Date frozentime;

    /**
     * 冻结时间: t_box_info.DEMISETIME
     * @author MyBatis Generator
     */
    private Date demisetime;

    /**
     * 获取箱子ID: t_box_info.BOX_INFO_ID
     * @return 箱子ID: t_box_info.BOX_INFO_ID
     * @author MyBatis Generator
     */
    public Long getBoxInfoId() {
        return boxInfoId;
    }

    /**
     * 设置箱子ID: t_box_info.BOX_INFO_ID
     * @param boxInfoId 映射数据库字段: t_box_info.BOX_INFO_ID
     * @author MyBatis Generator
     */
    public void setBoxInfoId(Long boxInfoId) {
        this.boxInfoId = boxInfoId;
    }

    /**
     * 获取加密密钥: t_box_info.SEC_KEY
     * @return 加密密钥: t_box_info.SEC_KEY
     * @author MyBatis Generator
     */
    public String getSecKey() {
        return secKey;
    }

    /**
     * 设置加密密钥: t_box_info.SEC_KEY
     * @param secKey 映射数据库字段: t_box_info.SEC_KEY
     * @author MyBatis Generator
     */
    public void setSecKey(String secKey) {
        this.secKey = secKey == null ? null : secKey.trim();
    }

    /**
     * 获取所属箱子组: t_box_info.BOX_GROUP_ID
     * @return 所属箱子组: t_box_info.BOX_GROUP_ID
     * @author MyBatis Generator
     */
    public Long getBoxGroupId() {
        return boxGroupId;
    }

    /**
     * 设置所属箱子组: t_box_info.BOX_GROUP_ID
     * @param boxGroupId 映射数据库字段: t_box_info.BOX_GROUP_ID
     * @author MyBatis Generator
     */
    public void setBoxGroupId(Long boxGroupId) {
        this.boxGroupId = boxGroupId;
    }

    /**
     * 获取经度: t_box_info.LONGITUDE
     * @return 经度: t_box_info.LONGITUDE
     * @author MyBatis Generator
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * 设置经度: t_box_info.LONGITUDE
     * @param longitude 映射数据库字段: t_box_info.LONGITUDE
     * @author MyBatis Generator
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    /**
     * 获取纬度: t_box_info.LATITUDE
     * @return 纬度: t_box_info.LATITUDE
     * @author MyBatis Generator
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * 设置纬度: t_box_info.LATITUDE
     * @param latitude 映射数据库字段: t_box_info.LATITUDE
     * @author MyBatis Generator
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    /**
     * 获取状态: t_box_info.STATUS
     * @return 状态: t_box_info.STATUS
     * @author MyBatis Generator
     */
    public ActiveStatus getStatus() {
        return status;
    }

    /**
     * 设置状态: t_box_info.STATUS
     * @param status 映射数据库字段: t_box_info.STATUS
     * @author MyBatis Generator
     */
    public void setStatus(ActiveStatus status) {
        this.status = status;
    }

    /**
     * 获取详细地址: t_box_info.ADDRESS
     * @return 详细地址: t_box_info.ADDRESS
     * @author MyBatis Generator
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置详细地址: t_box_info.ADDRESS
     * @param address 映射数据库字段: t_box_info.ADDRESS
     * @author MyBatis Generator
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取校验数值,用于客户端传递的值必须大于服务器保存的值,默认值为0: t_box_info.CHECKNUM
     * @return 校验数值,用于客户端传递的值必须大于服务器保存的值,默认值为0: t_box_info.CHECKNUM
     * @author MyBatis Generator
     */
    public Integer getChecknum() {
        return checknum;
    }

    /**
     * 设置校验数值,用于客户端传递的值必须大于服务器保存的值,默认值为0: t_box_info.CHECKNUM
     * @param checknum 映射数据库字段: t_box_info.CHECKNUM
     * @author MyBatis Generator
     */
    public void setChecknum(Integer checknum) {
        this.checknum = checknum;
    }

    /**
     * 获取创建时间: t_box_info.CREATETIME
     * @return 创建时间: t_box_info.CREATETIME
     * @author MyBatis Generator
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间: t_box_info.CREATETIME
     * @param createtime 映射数据库字段: t_box_info.CREATETIME
     * @author MyBatis Generator
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取激活时间: t_box_info.ACTIVETIME
     * @return 激活时间: t_box_info.ACTIVETIME
     * @author MyBatis Generator
     */
    public Date getActivetime() {
        return activetime;
    }

    /**
     * 设置激活时间: t_box_info.ACTIVETIME
     * @param activetime 映射数据库字段: t_box_info.ACTIVETIME
     * @author MyBatis Generator
     */
    public void setActivetime(Date activetime) {
        this.activetime = activetime;
    }

    /**
     * 获取注销时间: t_box_info.FROZENTIME
     * @return 注销时间: t_box_info.FROZENTIME
     * @author MyBatis Generator
     */
    public Date getFrozentime() {
        return frozentime;
    }

    /**
     * 设置注销时间: t_box_info.FROZENTIME
     * @param frozentime 映射数据库字段: t_box_info.FROZENTIME
     * @author MyBatis Generator
     */
    public void setFrozentime(Date frozentime) {
        this.frozentime = frozentime;
    }

    /**
     * 获取冻结时间: t_box_info.DEMISETIME
     * @return 冻结时间: t_box_info.DEMISETIME
     * @author MyBatis Generator
     */
    public Date getDemisetime() {
        return demisetime;
    }

    /**
     * 设置冻结时间: t_box_info.DEMISETIME
     * @param demisetime 映射数据库字段: t_box_info.DEMISETIME
     * @author MyBatis Generator
     */
    public void setDemisetime(Date demisetime) {
        this.demisetime = demisetime;
    }
}