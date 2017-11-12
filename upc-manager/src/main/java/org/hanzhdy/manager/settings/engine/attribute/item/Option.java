package org.hanzhdy.manager.settings.engine.attribute.item;

import org.hanzhdy.manager.settings.engine.attribute.HtmlAttribute;

/**
 * @description 子选项属性
 * @author H.CAAHN
 * @createtime 2017年6月8日 下午5:21:36
 */
public class Option implements HtmlAttribute {
    /** 子选项存储值 */
    protected String value;
    
    /** 子选项显示值 */
    protected String text;
    
    public String getValue() {
        return value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
}
