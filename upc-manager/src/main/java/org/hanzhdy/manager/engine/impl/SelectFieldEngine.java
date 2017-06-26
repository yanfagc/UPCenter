package org.hanzhdy.manager.engine.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hanzhdy.manager.engine.EngineContext;
import org.hanzhdy.manager.engine.attribute.FieldAttribute;
import org.hanzhdy.manager.engine.attribute.SelectAttribute;
import org.hanzhdy.manager.engine.attribute.item.Option;
import org.hanzhdy.manager.engine.attribute.item.SelectOption;
import org.hanzhdy.manager.engine.constants.FieldType;
import org.hanzhdy.manager.engine.utils.FieldHtmlFormat;
import org.hanzhdy.manager.form.model.FieldInfo;
import org.hanzhdy.manager.form.model.FieldItem;
import org.hanzhdy.manager.form.model.FormData;

/**
 * @description Select Field Engine
 * @author H.CAAHN
 * @createtime 2016年1月1日 下午10:53:13
 */
public class SelectFieldEngine extends AbstractFieldEngine {
    @Override
    public String getHtml(FieldAttribute attribute, EngineContext context) {
        String mainHtmlTemplate = FieldHtmlFormat.getTemplate("field.engine.select.template", "select");
        String optsHtmlTemplate = FieldHtmlFormat.getTemplate("field.engine.select.template", "option");
        
        StringBuffer optHtml = new StringBuffer();
        SelectAttribute attr = (SelectAttribute) attribute;
        List<Option> opts = attr.getOptionList();
        if (opts != null && !opts.isEmpty()) {
            for (Option opt : opts) {
                optHtml.append(FieldHtmlFormat.parseHTML(optsHtmlTemplate, opt));
            }
        }
        attr.setOptionHTML(optHtml.toString());
        
        String fieldhtml = FieldHtmlFormat.parseHTML(mainHtmlTemplate, attr);
        return super.createCompleteHtml(attribute, fieldhtml, context);
    }
    
    @Override
    public void settingData(FieldAttribute attribute, List<FormData> dataList, EngineContext context) {
        SelectAttribute attr = (SelectAttribute) attribute;
        List<Option> opts = attr.getOptionList();
        for (FormData data : dataList) {
            if (attribute.getId().longValue() == data.getFieldid().longValue()) {
                for (Option opt : opts) {
                    if (StringUtils.equals(opt.getValue(), data.getValue())) {
                        ((SelectOption) opt).setSelected(true);
                        break;
                    }
                }
                break;
            }
        }
    }
    
    @Override
    public FieldType getType() {
        return FieldType.SELECT;
    }

    @Override
    protected FieldAttribute createAttribute(FieldInfo fieldInfo, EngineContext context) {
        return new SelectAttribute();
    }

    @Override
    protected Option createOption(FieldInfo field, FieldItem item, EngineContext context) {
        Option option = new SelectOption();
        option.setValue(item.getItemvalue());
        option.setText(item.getItemname());
        return option;
    }

}
