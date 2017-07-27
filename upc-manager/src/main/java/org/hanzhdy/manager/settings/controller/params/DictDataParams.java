package org.hanzhdy.manager.settings.controller.params;

import org.hanzhdy.web.bean.DatatableParams;

/**
 * @description 数据字典查询参数
 * @author H.CAAHN
 * @createtime 2016年10月8日 下午10:08:01
 */
public class DictDataParams extends DatatableParams {
    /** 序列化号 */
    private static final long serialVersionUID = -4586394298225402110L;
    
    /** 数据编码 */
    private String            datacode;
    
    /** 数据名称 */
    private String            dataname;
    
    /** 数据类型 */
    private Long              typeId;
    
    /** 状态 */
    private String            status;
    
    public String getDatacode() {
        return datacode;
    }
    
    public void setDatacode(String datacode) {
        this.datacode = datacode;
    }
    
    public String getDataname() {
        return dataname;
    }
    
    public void setDataname(String dataname) {
        this.dataname = dataname;
    }
    
    public Long getTypeId() {
        return typeId;
    }
    
    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
}
