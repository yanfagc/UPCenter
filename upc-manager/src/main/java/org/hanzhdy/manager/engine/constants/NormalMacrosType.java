package org.hanzhdy.manager.engine.constants;

/**
 * @description 
 * @author H.CAAHN
 * @createtime 2017年6月13日 上午9:46:48
 */
public enum NormalMacrosType {
    DATE("日期格式(yyyy-MM-dd)"),
    
    TIME("时间格式(HH:mm:ss)"),

    DATETIME("日期时间(yyyy-MM-dd HH:mm:ss)"),
    
    FILE("普通文件"),
    
    IMAGE("图片格式"),
    
    ONEHR("人力资源[单选]"),
    
    MOREHR("人力资源[多选]");
    
    private String remark;
    
    NormalMacrosType(String remark) {
        this.remark = remark;
    }
    
    public String getName() {
        return this.name();
    }
    
    public String getRemark() {
        return this.remark;
    }
}
