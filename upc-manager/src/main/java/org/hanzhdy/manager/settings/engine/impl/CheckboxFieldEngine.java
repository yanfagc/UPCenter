package org.hanzhdy.manager.settings.engine.impl;

import org.apache.commons.lang3.StringUtils;
import org.hanzhdy.manager.settings.engine.EngineContext;
import org.hanzhdy.manager.settings.engine.attribute.CheckboxAttribute;
import org.hanzhdy.manager.settings.engine.attribute.FieldAttribute;
import org.hanzhdy.manager.settings.engine.attribute.item.CheckboxOption;
import org.hanzhdy.manager.settings.engine.attribute.item.Option;
import org.hanzhdy.manager.settings.engine.utils.FieldHtmlFormat;
import org.hanzhdy.manager.settings.model.FieldInfo;
import org.hanzhdy.manager.settings.model.FieldItem;
import org.hanzhdy.manager.settings.model.FormData;
import org.hanzhdy.manager.support.enums.FieldType;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @description checkbox Field Engine
 * @author H.CAAHN
 * @createtime 2016年1月1日 下午10:54:25
 */
public class CheckboxFieldEngine extends AbstractFieldEngine {
    @Override
    public String getHtml(FieldAttribute attribute, EngineContext context) {
        String itemHtmlTemplate = FieldHtmlFormat.getTemplate("field.engine.checkbox.template", "item");
        CheckboxAttribute attr = (CheckboxAttribute) attribute;
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
        CheckboxAttribute attr = (CheckboxAttribute) attribute;
        List<Option> opts = attr.getOptionList();
        for (FormData data : dataList) {
            if (attribute.getId().longValue() == data.getFieldid().longValue()) {
                for (Option opt : opts) {
                    if (StringUtils.equals(opt.getValue(), data.getValue())) {
                        ((CheckboxOption) opt).setChecked(true);
                    }
                }
            }
        }
    }
    
    public void readData(FieldInfo field, HttpServletRequest request, List<FormData> dataList) {
        String code = field.getFieldcode();
        String[] value = request.getParameterValues(code);
        if (value != null && value.length > 0) {
            for (String val : value) {
                FormData data = new FormData();
                data.setFieldid(field.getId());
                data.setValue(val);
                dataList.add(data);
            }
        }
    }

    @Override
    public FieldType getType() {
        return FieldType.CHECKBOX;
    }

    @Override
    protected FieldAttribute createAttribute(FieldInfo fieldInfo, EngineContext context) {
        return new CheckboxAttribute();
    }

    @Override
    protected Option createOption(FieldInfo field, FieldItem item, EngineContext context) {
        CheckboxOption option = new CheckboxOption();
        option.setValue(item.getItemvalue());
        option.setText(item.getItemname());
        option.setFieldcode(field.getFieldcode());
        return option;
    }
}
