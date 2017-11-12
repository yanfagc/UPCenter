package org.hanzhdy.manager.settings.engine.impl;

import org.hanzhdy.manager.settings.engine.EngineContext;
import org.hanzhdy.manager.settings.engine.attribute.FieldAttribute;
import org.hanzhdy.manager.settings.engine.attribute.InputAttribute;
import org.hanzhdy.manager.settings.engine.attribute.item.Option;
import org.hanzhdy.manager.settings.engine.constants.InputMacrosType;
import org.hanzhdy.manager.settings.engine.utils.FieldHtmlFormat;
import org.hanzhdy.manager.settings.model.FieldInfo;
import org.hanzhdy.manager.settings.model.FieldItem;
import org.hanzhdy.manager.support.enums.FieldType;

/**
 * @description text Field Engine
 * @author H.CAAHN
 * @createtime 2016年1月1日 下午10:39:57
 */
public class InputFieldEngine extends AbstractFieldEngine {
    public String getHtml(FieldAttribute attribute, EngineContext context) {
        String key = "field.engine.input.template";
        String templateHtml = FieldHtmlFormat.getTemplate(key);
        String fieldhtml = FieldHtmlFormat.parseHTML(templateHtml, attribute);
        
        return super.createCompleteHtml(attribute, fieldhtml, context);
    }
    
    @Override
    public FieldType getType() {
        return FieldType.INPUT;
    }
    
    @Override
    protected FieldAttribute createAttribute(FieldInfo fieldInfo, EngineContext context) {
        InputAttribute attribute = new InputAttribute();
        
        InputMacrosType[] types = InputMacrosType.values();
        for (InputMacrosType type : types) {
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
