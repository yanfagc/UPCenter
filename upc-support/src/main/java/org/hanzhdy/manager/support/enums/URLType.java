package org.hanzhdy.manager.support.enums;

/**
 * @description 菜单路径类型
 * @author H.CAAHN
 * @createtime 2017年4月11日 下午7:38:17
 */
public enum URLType {
    M("菜单目录"),
    
    R("相对地址"),
    
    A("绝对地址");
    
    private String remark;
    
    private URLType(String remark) {
        this.remark = remark;
    }
    
    public String getRemark() {
        return this.remark;
    }
}
