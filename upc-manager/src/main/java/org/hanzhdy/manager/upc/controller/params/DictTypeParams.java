package org.hanzhdy.manager.upc.controller.params;

import org.hanzhdy.web.bean.DatatableParams;

/**
 * @description 数据类型查询参数
 * @author H.CAAHN
 * @createtime 2016年10月8日 下午10:07:42
 */
public class DictTypeParams extends DatatableParams {
    /** 序列化号 */
    private static final long serialVersionUID = -3635060405681946823L;
    
    /** 类型编码 */
    private String            typecode;
    
    /** 类型名称 */
    private String            typename;
    
    /** 状态 */
    private String            status;
    
    /** 字典值类型 */
    private String            valuetype;
    
    public String getTypecode() {
        return typecode;
    }
    
    public void setTypecode(String typecode) {
        this.typecode = typecode;
    }
    
    public String getTypename() {
        return typename;
    }
    
    public void setTypename(String typename) {
        this.typename = typename;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getValuetype() {
        return valuetype;
    }
    
    public void setValuetype(String valuetype) {
        this.valuetype = valuetype;
    }
}
