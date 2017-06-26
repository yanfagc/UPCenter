package org.hanzhdy.manager.engine.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hanzhdy.manager.engine.EngineContext;
import org.hanzhdy.manager.engine.attribute.FieldAttribute;
import org.hanzhdy.manager.engine.attribute.MacrosAttribute;
import org.hanzhdy.manager.engine.attribute.item.Option;
import org.hanzhdy.manager.engine.constants.FieldType;
import org.hanzhdy.manager.engine.constants.NormalMacrosType;
import org.hanzhdy.manager.engine.utils.FieldHtmlFormat;
import org.hanzhdy.manager.form.model.FieldInfo;
import org.hanzhdy.manager.form.model.FieldItem;
import org.hanzhdy.manager.form.model.FormData;

/**
 * @description
 * @author H.CAAHN
 * @createtime 2016年1月1日 下午10:56:13
 */
public class MacrosFieldEngine extends AbstractFieldEngine {
    @Override
    public String getHtml(FieldAttribute attribute, EngineContext context) {
        MacrosAttribute attr = (MacrosAttribute) attribute;
        String templateHtml = FieldHtmlFormat.getTemplate("field.engine.macros.template", attr.getMacrostype().name());
        String fieldhtml = FieldHtmlFormat.parseHTML(templateHtml, attr);
        
        return super.createCompleteHtml(attribute, fieldhtml, context);
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
        return FieldType.MACROS;
    }
    
    @Override
    protected FieldAttribute createAttribute(FieldInfo fieldInfo, EngineContext context) {
        MacrosAttribute attribute = new MacrosAttribute();
        NormalMacrosType[] types = NormalMacrosType.values();
        for (NormalMacrosType type : types) {
            if (type.name().equalsIgnoreCase(fieldInfo.getMacrotype())) {
                attribute.setMacrostype(type);
            }
        }
        
        return attribute;
    }
    
    @Override
    protected Option createOption(FieldInfo field, FieldItem item, EngineContext context) {
        return null;
    }
}
