package org.hanzhdy.manager.engine.impl;

import org.apache.commons.lang3.StringUtils;
import org.hanzhdy.manager.engine.EngineContext;
import org.hanzhdy.manager.engine.attribute.FieldAttribute;
import org.hanzhdy.manager.engine.attribute.RadioAttribute;
import org.hanzhdy.manager.engine.attribute.item.Option;
import org.hanzhdy.manager.engine.attribute.item.RadioOption;
import org.hanzhdy.manager.engine.utils.FieldHtmlFormat;
import org.hanzhdy.manager.form.model.FieldInfo;
import org.hanzhdy.manager.form.model.FieldItem;
import org.hanzhdy.manager.form.model.FormData;
import org.hanzhdy.manager.support.enums.FieldType;

import java.util.List;

/**
 * @description radio Field Engine
 * @author H.CAAHN
 * @createtime 2016年1月1日 下午10:55:20
 */
public class RadioFieldEngine extends AbstractFieldEngine {
    @Override
    public String getHtml(FieldAttribute attribute, EngineContext context) {
        String itemHtmlTemplate = FieldHtmlFormat.getTemplate("field.engine.radio.template", "item");
        RadioAttribute attr = (RadioAttribute) attribute;
        List<Option> opts = attr.getOptionList();
        
        StringBuffer itemHtml = new StringBuffer();
        if (opts != null && !opts.isEmpty()) {
            for (Option opt : opts) {
                itemHtml.append(FieldHtmlFormat.parseHTML(itemHtmlTemplate, opt));
            }
        }
        
        return super.createCompleteHtml(attribute, itemHtml.toString(), context);
    }
    
    @Override
    public void settingData(FieldAttribute attribute, List<FormData> dataList, EngineContext context) {
        RadioAttribute attr = (RadioAttribute) attribute;
        List<Option> opts = attr.getOptionList();
        for (FormData data : dataList) {
            if (attribute.getId().longValue() == data.getFieldid().longValue()) {
                for (Option opt : opts) {
                    if (StringUtils.equals(opt.getValue(), data.getValue())) {
                        ((RadioOption) opt).setChecked(true);
                        break;
                    }
                }
                break;
            }
        }
    }
    
    @Override
    public FieldType getType() {
        return FieldType.RADIO;
    }
    
    @Override
    protected FieldAttribute createAttribute(FieldInfo fieldInfo, EngineContext context) {
        return new RadioAttribute();
    }
    
    @Override
    protected Option createOption(FieldInfo field, FieldItem item, EngineContext context) {
        RadioOption option = new RadioOption();
        option.setValue(item.getItemvalue());
        option.setText(item.getItemname());
        option.setFieldcode(field.getFieldcode());
        return option;
    }
    
}
