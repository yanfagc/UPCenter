package com.postbox.model;

import com.postbox.enums.BoxExpressStatus;
import com.postbox.enums.BoxGridStatus;
import com.postbox.enums.GridSize;
import java.io.Serializable;
import java.util.Date;

public class BoxGrid implements Serializable {
    public static final long serialVersionUID = -13794916L;

    /**
     * 快递格子ID: t_box_grid.BOX_GRID_ID
     * @author MyBatis Generator
     */
    private Long boxGridId;

    /**
     * 箱子ID: t_box_grid.BOX_INFO_ID
     * @author MyBatis Generator
     */
    private Long boxInfoId;

    /**
     * 箱子编号: t_box_grid.GRID_CODE
     * @author MyBatis Generator
     */
    private String gridCode;

    /**
     * 基本状态,NOACTIVE未激活,NORMAL正常,REPAIR维修,DEMISE注销: t_box_grid.STATUS
     * @author MyBatis Generator
     */
    private BoxGridStatus status;

    /**
     * 快件状态,EMPTY空,FULL有货物: t_box_grid.EXPRESS_STATUS
     * @author MyBatis Generator
     */
    private BoxExpressStatus expressStatus;

    /**
     * 快件隶属手机号: t_box_grid.MOBILE_PHONE
     * @author MyBatis Generator
     */
    private String mobilePhone;

    /**
     * 快件代领人ID号: t_box_grid.PROXY_CUSTOMER_INFO_ID
     * @author MyBatis Generator
     */
    private String proxyCustomerInfoId;

    /**
     * 快递格子大小型号: t_box_grid.GRID_SIZE
     * @author MyBatis Generator
     */
    private GridSize gridSize;

    /**
     * 排序值: t_box_grid.SORT
     * @author MyBatis Generator
     */
    private Integer sort;

    /**
     * 上次开启时间: t_box_grid.OPENTIME
     * @author MyBatis Generator
     */
    private Date opentime;

    /**
     * 获取快递格子ID: t_box_grid.BOX_GRID_ID
     * @return 快递格子ID: t_box_grid.BOX_GRID_ID
     * @author MyBatis Generator
     */
    public Long getBoxGridId() {
        return boxGridId;
    }

    /**
     * 设置快递格子ID: t_box_grid.BOX_GRID_ID
     * @param boxGridId 映射数据库字段: t_box_grid.BOX_GRID_ID
     * @author MyBatis Generator
     */
    public void setBoxGridId(Long boxGridId) {
        this.boxGridId = boxGridId;
    }

    /**
     * 获取箱子ID: t_box_grid.BOX_INFO_ID
     * @return 箱子ID: t_box_grid.BOX_INFO_ID
     * @author MyBatis Generator
     */
    public Long getBoxInfoId() {
        return boxInfoId;
    }

    /**
     * 设置箱子ID: t_box_grid.BOX_INFO_ID
     * @param boxInfoId 映射数据库字段: t_box_grid.BOX_INFO_ID
     * @author MyBatis Generator
     */
    public void setBoxInfoId(Long boxInfoId) {
        this.boxInfoId = boxInfoId;
    }

    /**
     * 获取箱子编号: t_box_grid.GRID_CODE
     * @return 箱子编号: t_box_grid.GRID_CODE
     * @author MyBatis Generator
     */
    public String getGridCode() {
        return gridCode;
    }

    /**
     * 设置箱子编号: t_box_grid.GRID_CODE
     * @param gridCode 映射数据库字段: t_box_grid.GRID_CODE
     * @author MyBatis Generator
     */
    public void setGridCode(String gridCode) {
        this.gridCode = gridCode == null ? null : gridCode.trim();
    }

    /**
     * 获取基本状态,NOACTIVE未激活,NORMAL正常,REPAIR维修,DEMISE注销: t_box_grid.STATUS
     * @return 基本状态,NOACTIVE未激活,NORMAL正常,REPAIR维修,DEMISE注销: t_box_grid.STATUS
     * @author MyBatis Generator
     */
    public BoxGridStatus getStatus() {
        return status;
    }

    /**
     * 设置基本状态,NOACTIVE未激活,NORMAL正常,REPAIR维修,DEMISE注销: t_box_grid.STATUS
     * @param status 映射数据库字段: t_box_grid.STATUS
     * @author MyBatis Generator
     */
    public void setStatus(BoxGridStatus status) {
        this.status = status;
    }

    /**
     * 获取快件状态,EMPTY空,FULL有货物: t_box_grid.EXPRESS_STATUS
     * @return 快件状态,EMPTY空,FULL有货物: t_box_grid.EXPRESS_STATUS
     * @author MyBatis Generator
     */
    public BoxExpressStatus getExpressStatus() {
        return expressStatus;
    }

    /**
     * 设置快件状态,EMPTY空,FULL有货物: t_box_grid.EXPRESS_STATUS
     * @param expressStatus 映射数据库字段: t_box_grid.EXPRESS_STATUS
     * @author MyBatis Generator
     */
    public void setExpressStatus(BoxExpressStatus expressStatus) {
        this.expressStatus = expressStatus;
    }

    /**
     * 获取快件隶属手机号: t_box_grid.MOBILE_PHONE
     * @return 快件隶属手机号: t_box_grid.MOBILE_PHONE
     * @author MyBatis Generator
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * 设置快件隶属手机号: t_box_grid.MOBILE_PHONE
     * @param mobilePhone 映射数据库字段: t_box_grid.MOBILE_PHONE
     * @author MyBatis Generator
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    /**
     * 获取快件代领人ID号: t_box_grid.PROXY_CUSTOMER_INFO_ID
     * @return 快件代领人ID号: t_box_grid.PROXY_CUSTOMER_INFO_ID
     * @author MyBatis Generator
     */
    public String getProxyCustomerInfoId() {
        return proxyCustomerInfoId;
    }

    /**
     * 设置快件代领人ID号: t_box_grid.PROXY_CUSTOMER_INFO_ID
     * @param proxyCustomerInfoId 映射数据库字段: t_box_grid.PROXY_CUSTOMER_INFO_ID
     * @author MyBatis Generator
     */
    public void setProxyCustomerInfoId(String proxyCustomerInfoId) {
        this.proxyCustomerInfoId = proxyCustomerInfoId == null ? null : proxyCustomerInfoId.trim();
    }

    /**
     * 获取快递格子大小型号: t_box_grid.GRID_SIZE
     * @return 快递格子大小型号: t_box_grid.GRID_SIZE
     * @author MyBatis Generator
     */
    public GridSize getGridSize() {
        return gridSize;
    }

    /**
     * 设置快递格子大小型号: t_box_grid.GRID_SIZE
     * @param gridSize 映射数据库字段: t_box_grid.GRID_SIZE
     * @author MyBatis Generator
     */
    public void setGridSize(GridSize gridSize) {
        this.gridSize = gridSize;
    }

    /**
     * 获取排序值: t_box_grid.SORT
     * @return 排序值: t_box_grid.SORT
     * @author MyBatis Generator
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序值: t_box_grid.SORT
     * @param sort 映射数据库字段: t_box_grid.SORT
     * @author MyBatis Generator
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取上次开启时间: t_box_grid.OPENTIME
     * @return 上次开启时间: t_box_grid.OPENTIME
     * @author MyBatis Generator
     */
    public Date getOpentime() {
        return opentime;
    }

    /**
     * 设置上次开启时间: t_box_grid.OPENTIME
     * @param opentime 映射数据库字段: t_box_grid.OPENTIME
     * @author MyBatis Generator
     */
    public void setOpentime(Date opentime) {
        this.opentime = opentime;
    }
}