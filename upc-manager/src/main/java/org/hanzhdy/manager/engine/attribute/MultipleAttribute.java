package org.hanzhdy.manager.engine.attribute;

import java.util.ArrayList;
import java.util.List;

import org.hanzhdy.manager.engine.attribute.item.Option;

/**
 * @description 下拉框、复选框、单选框等包含有子选项的输入框
 * @author H.CAAHN
 * @createtime 2017年6月8日 下午5:13:18
 */
public abstract class MultipleAttribute extends FieldAttribute {
    /** 子选项列表 */
    private List<Option> optionList;
    
    private String       optionHTML;
    
    public void addOption(Option item) {
        if (optionList == null) {
            optionList = new ArrayList<Option>();
        }
        optionList.add(item);
    }
    
    public List<Option> getOptionList() {
        return optionList;
    }
    
    public void setOptionList(List<Option> optionList) {
        this.optionList = optionList;
    }
    
    public String getOptionHTML() {
        return optionHTML;
    }
    
    public void setOptionHTML(String optionHTML) {
        this.optionHTML = optionHTML;
    }
}
