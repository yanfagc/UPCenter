package org.hanzhdy.manager.settings.engine.attribute.item;

/**
 * @description Radio 子选项
 * @author H.CAAHN
 * @createtime 2017年6月8日 下午8:12:41
 */
public class RadioOption extends Option {
    protected boolean checked;
    
    protected String  fieldcode;
    
    public boolean isChecked() {
        return checked;
    }
    
    public String getCheckedAttribute() {
        if (this.checked) {
            return " checked=\"checked\" ";
        }
        return "";
    }
    
    public void setChecked(boolean checked) {
        this.checked = checked;
    }
    
    public String getFieldcode() {
        return fieldcode;
    }
    
    public void setFieldcode(String fieldcode) {
        this.fieldcode = fieldcode;
    }
}
