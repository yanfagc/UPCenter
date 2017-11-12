package org.hanzhdy.manager.settings.engine.impl;

import org.hanzhdy.manager.settings.engine.EngineContext;
import org.hanzhdy.manager.settings.engine.attribute.FieldAttribute;
import org.hanzhdy.manager.settings.engine.attribute.MacrosAttribute;
import org.hanzhdy.manager.settings.engine.attribute.item.Option;
import org.hanzhdy.manager.settings.engine.constants.NormalMacrosType;
import org.hanzhdy.manager.settings.engine.utils.FieldHtmlFormat;
import org.hanzhdy.manager.settings.model.FieldInfo;
import org.hanzhdy.manager.settings.model.FieldItem;
import org.hanzhdy.manager.settings.model.FormData;
import org.hanzhdy.manager.support.enums.FieldType;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
