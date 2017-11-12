package org.hanzhdy.manager.settings.engine.attribute.item;

/**
 * @description 复选框的子选项属性
 * @author H.CAAHN
 * @createtime 2017年6月8日 下午5:25:12
 */
public class CheckboxOption extends Option {
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
