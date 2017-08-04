package com.postbox.model;

import com.postbox.enums.BoxExpressStatus;
import com.postbox.enums.BoxInfoStatus;
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
     * 箱子名称,箱子组名+编号: t_box_info.BOX_NAME
     * @author MyBatis Generator
     */
    private String boxName;

    /**
     * 箱子编号: t_box_info.BOX_CODE
     * @author MyBatis Generator
     */
    private String boxCode;

    /**
     * 箱子芯片的唯一代码: t_box_info.BOX_UNIQUE_CODE
     * @author MyBatis Generator
     */
    private String boxUniqueCode;

    /**
     * 箱子组ID: t_box_info.BOX_GROUP_ID
     * @author MyBatis Generator
     */
    private Long boxGroupId;

    /**
     * 加密密钥: t_box_info.SEC_KEY
     * @author MyBatis Generator
     */
    private String secKey;

    /**
     * 基本状态,NOACTIVE未激活,NORMAL正常,REPAIR维修,DEMISE注销: t_box_info.STATUS
     * @author MyBatis Generator
     */
    private BoxInfoStatus status;

    /**
     * 快件状态,EMPTY空,FULL有货物: t_box_info.EXPRESS_STATUS
     * @author MyBatis Generator
     */
    private BoxExpressStatus expressStatus;

    /**
     * 快件隶属手机号: t_box_info.MOBILE_PHONE
     * @author MyBatis Generator
     */
    private String mobilePhone;

    /**
     * 快件代领人ID号: t_box_info.PROXY_CUSTOMER_INFO_ID
     * @author MyBatis Generator
     */
    private String proxyCustomerInfoId;

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
     * 上次开启时间: t_box_info.OPENTIME
     * @author MyBatis Generator
     */
    private Date opentime;

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
     * 维修时间: t_box_info.REPAIRTIME
     * @author MyBatis Generator
     */
    private Date repairtime;

    /**
     * 注销时间: t_box_info.DEMISETIME
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
     * 获取箱子名称,箱子组名+编号: t_box_info.BOX_NAME
     * @return 箱子名称,箱子组名+编号: t_box_info.BOX_NAME
     * @author MyBatis Generator
     */
    public String getBoxName() {
        return boxName;
    }

    /**
     * 设置箱子名称,箱子组名+编号: t_box_info.BOX_NAME
     * @param boxName 映射数据库字段: t_box_info.BOX_NAME
     * @author MyBatis Generator
     */
    public void setBoxName(String boxName) {
        this.boxName = boxName == null ? null : boxName.trim();
    }

    /**
     * 获取箱子编号: t_box_info.BOX_CODE
     * @return 箱子编号: t_box_info.BOX_CODE
     * @author MyBatis Generator
     */
    public String getBoxCode() {
        return boxCode;
    }

    /**
     * 设置箱子编号: t_box_info.BOX_CODE
     * @param boxCode 映射数据库字段: t_box_info.BOX_CODE
     * @author MyBatis Generator
     */
    public void setBoxCode(String boxCode) {
        this.boxCode = boxCode == null ? null : boxCode.trim();
    }

    /**
     * 获取箱子芯片的唯一代码: t_box_info.BOX_UNIQUE_CODE
     * @return 箱子芯片的唯一代码: t_box_info.BOX_UNIQUE_CODE
     * @author MyBatis Generator
     */
    public String getBoxUniqueCode() {
        return boxUniqueCode;
    }

    /**
     * 设置箱子芯片的唯一代码: t_box_info.BOX_UNIQUE_CODE
     * @param boxUniqueCode 映射数据库字段: t_box_info.BOX_UNIQUE_CODE
     * @author MyBatis Generator
     */
    public void setBoxUniqueCode(String boxUniqueCode) {
        this.boxUniqueCode = boxUniqueCode == null ? null : boxUniqueCode.trim();
    }

    /**
     * 获取箱子组ID: t_box_info.BOX_GROUP_ID
     * @return 箱子组ID: t_box_info.BOX_GROUP_ID
     * @author MyBatis Generator
     */
    public Long getBoxGroupId() {
        return boxGroupId;
    }

    /**
     * 设置箱子组ID: t_box_info.BOX_GROUP_ID
     * @param boxGroupId 映射数据库字段: t_box_info.BOX_GROUP_ID
     * @author MyBatis Generator
     */
    public void setBoxGroupId(Long boxGroupId) {
        this.boxGroupId = boxGroupId;
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
     * 获取基本状态,NOACTIVE未激活,NORMAL正常,REPAIR维修,DEMISE注销: t_box_info.STATUS
     * @return 基本状态,NOACTIVE未激活,NORMAL正常,REPAIR维修,DEMISE注销: t_box_info.STATUS
     * @author MyBatis Generator
     */
    public BoxInfoStatus getStatus() {
        return status;
    }

    /**
     * 设置基本状态,NOACTIVE未激活,NORMAL正常,REPAIR维修,DEMISE注销: t_box_info.STATUS
     * @param status 映射数据库字段: t_box_info.STATUS
     * @author MyBatis Generator
     */
    public void setStatus(BoxInfoStatus status) {
        this.status = status;
    }

    /**
     * 获取快件状态,EMPTY空,FULL有货物: t_box_info.EXPRESS_STATUS
     * @return 快件状态,EMPTY空,FULL有货物: t_box_info.EXPRESS_STATUS
     * @author MyBatis Generator
     */
    public BoxExpressStatus getExpressStatus() {
        return expressStatus;
    }

    /**
     * 设置快件状态,EMPTY空,FULL有货物: t_box_info.EXPRESS_STATUS
     * @param expressStatus 映射数据库字段: t_box_info.EXPRESS_STATUS
     * @author MyBatis Generator
     */
    public void setExpressStatus(BoxExpressStatus expressStatus) {
        this.expressStatus = expressStatus;
    }

    /**
     * 获取快件隶属手机号: t_box_info.MOBILE_PHONE
     * @return 快件隶属手机号: t_box_info.MOBILE_PHONE
     * @author MyBatis Generator
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * 设置快件隶属手机号: t_box_info.MOBILE_PHONE
     * @param mobilePhone 映射数据库字段: t_box_info.MOBILE_PHONE
     * @author MyBatis Generator
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    /**
     * 获取快件代领人ID号: t_box_info.PROXY_CUSTOMER_INFO_ID
     * @return 快件代领人ID号: t_box_info.PROXY_CUSTOMER_INFO_ID
     * @author MyBatis Generator
     */
    public String getProxyCustomerInfoId() {
        return proxyCustomerInfoId;
    }

    /**
     * 设置快件代领人ID号: t_box_info.PROXY_CUSTOMER_INFO_ID
     * @param proxyCustomerInfoId 映射数据库字段: t_box_info.PROXY_CUSTOMER_INFO_ID
     * @author MyBatis Generator
     */
    public void setProxyCustomerInfoId(String proxyCustomerInfoId) {
        this.proxyCustomerInfoId = proxyCustomerInfoId == null ? null : proxyCustomerInfoId.trim();
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
     * 获取上次开启时间: t_box_info.OPENTIME
     * @return 上次开启时间: t_box_info.OPENTIME
     * @author MyBatis Generator
     */
    public Date getOpentime() {
        return opentime;
    }

    /**
     * 设置上次开启时间: t_box_info.OPENTIME
     * @param opentime 映射数据库字段: t_box_info.OPENTIME
     * @author MyBatis Generator
     */
    public void setOpentime(Date opentime) {
        this.opentime = opentime;
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
     * 获取维修时间: t_box_info.REPAIRTIME
     * @return 维修时间: t_box_info.REPAIRTIME
     * @author MyBatis Generator
     */
    public Date getRepairtime() {
        return repairtime;
    }

    /**
     * 设置维修时间: t_box_info.REPAIRTIME
     * @param repairtime 映射数据库字段: t_box_info.REPAIRTIME
     * @author MyBatis Generator
     */
    public void setRepairtime(Date repairtime) {
        this.repairtime = repairtime;
    }

    /**
     * 获取注销时间: t_box_info.DEMISETIME
     * @return 注销时间: t_box_info.DEMISETIME
     * @author MyBatis Generator
     */
    public Date getDemisetime() {
        return demisetime;
    }

    /**
     * 设置注销时间: t_box_info.DEMISETIME
     * @param demisetime 映射数据库字段: t_box_info.DEMISETIME
     * @author MyBatis Generator
     */
    public void setDemisetime(Date demisetime) {
        this.demisetime = demisetime;
    }
}