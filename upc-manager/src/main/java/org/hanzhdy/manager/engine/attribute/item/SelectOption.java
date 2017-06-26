package org.hanzhdy.manager.engine.attribute.item;

/**
 * @description Select选项
 * @author H.CAAHN
 * @createtime 2017年6月8日 下午8:13:21
 */
public class SelectOption extends Option {
    protected boolean selected;
    
    public boolean isSelected() {
        return selected;
    }
    
    public String getSelectedAttribute() {
        if (this.selected) {
            return " selected=\"selected\" ";
        }
        return "";
    }
    
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
