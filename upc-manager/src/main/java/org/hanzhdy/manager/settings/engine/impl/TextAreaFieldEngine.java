package org.hanzhdy.manager.settings.engine.impl;

import org.hanzhdy.manager.settings.engine.EngineContext;
import org.hanzhdy.manager.settings.engine.attribute.FieldAttribute;
import org.hanzhdy.manager.settings.engine.attribute.TextAreaAttribute;
import org.hanzhdy.manager.settings.engine.attribute.item.Option;
import org.hanzhdy.manager.settings.engine.utils.FieldHtmlFormat;
import org.hanzhdy.manager.settings.model.FieldInfo;
import org.hanzhdy.manager.settings.model.FieldItem;
import org.hanzhdy.manager.support.enums.FieldType;

/**
 * @description textarea Field Engine
 * @author H.CAAHN
 * @createtime 2016年1月1日 下午10:51:32
 */
public class TextAreaFieldEngine extends AbstractFieldEngine {
    @Override
    public String getHtml(FieldAttribute attribute, EngineContext context) {
        String key = "field.engine.textarea.template";
        String templateHtml = FieldHtmlFormat.getTemplate(key);
        String fieldHtml = FieldHtmlFormat.parseHTML(templateHtml, attribute);
        
        return super.createCompleteHtml(attribute, fieldHtml, context);
    }
    
    @Override
    public FieldType getType() {
        return FieldType.TEXTAREA;
    }
    
    @Override
    protected FieldAttribute createAttribute(FieldInfo fieldInfo, EngineContext context) {
        return new TextAreaAttribute();
    }
    
    @Override
    protected Option createOption(FieldInfo field, FieldItem item, EngineContext context) {
        return null;
    }
    
}
