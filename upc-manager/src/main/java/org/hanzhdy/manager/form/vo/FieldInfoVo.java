package org.hanzhdy.manager.form.vo;

import org.hanzhdy.manager.form.model.FieldInfo;

/**
 * @description FieldInfo vo
 * @author H.CAAHN
 * @createtime 2015年12月6日 下午8:58:18
 */
public class FieldInfoVo extends FieldInfo {
    /** 序列化号 */
    private static final long serialVersionUID = 3943325068098886648L;
    
    private Long[]            itemid;
    
    private String[]          itemvalue;
    
    private String[]          itemname;
    
    public Long[] getItemid() {
        return itemid;
    }
    
    public void setItemid(Long[] itemid) {
        this.itemid = itemid;
    }
    
    public String[] getItemvalue() {
        return itemvalue;
    }
    
    public void setItemvalue(String[] itemvalue) {
        this.itemvalue = itemvalue;
    }
    
    public String[] getItemname() {
        return itemname;
    }
    
    public void setItemname(String[] itemname) {
        this.itemname = itemname;
    }
    
}
