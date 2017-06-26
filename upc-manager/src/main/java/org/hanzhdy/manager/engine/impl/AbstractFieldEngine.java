package org.hanzhdy.manager.engine.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hanzhdy.manager.engine.EngineContext;
import org.hanzhdy.manager.engine.FieldEngine;
import org.hanzhdy.manager.engine.attribute.FieldAttribute;
import org.hanzhdy.manager.engine.attribute.MultipleAttribute;
import org.hanzhdy.manager.engine.attribute.item.Option;
import org.hanzhdy.manager.engine.utils.FieldHtmlFormat;
import org.hanzhdy.manager.form.model.FieldInfo;
import org.hanzhdy.manager.form.model.FieldItem;
import org.hanzhdy.manager.form.model.FormData;

/**
 * @description 抽象的Field Engine
 * @author H.CAAHN
 * @createtime 2016年1月1日 下午10:48:16
 */
public abstract class AbstractFieldEngine implements FieldEngine {
    public FieldAttribute settingAttribute(FieldInfo field, List<FieldItem> itemList, EngineContext context) {
        FieldAttribute attribute = this.createAttribute(field, context);
        attribute.setId(field.getId());
        // 乘2原因：一个表单项占用一个label + 一个input，一般情况下总共占table的2个td
        // 如果某个表单项的colspan值为2，那么它实际上占用了table的4个td
        int colspan = field.getColspan() * 2;
        attribute.setColspan(colspan > context.getMaxColumns() ? context.getMaxColumns() : colspan);
        
        attribute.setFieldcode(field.getFieldcode());
        attribute.setFieldtips(field.getFieldname());
        attribute.setFieldname(field.getFieldname());
        attribute.setValue(field.getDefaultvalue());
        attribute.setFieldtype(field.getFieldtype());
        
        if (attribute instanceof MultipleAttribute && itemList != null && !itemList.isEmpty()) {
            MultipleAttribute attr = (MultipleAttribute) attribute;
            for (FieldItem item : itemList) {
                if (item.getFieldid().equals(field.getId())) {
                    Option option = this.createOption(field, item, context);
                    attr.addOption(option);
                }
            }
        }
        return attribute;
    }
    
    public void settingData(FieldAttribute attribute, List<FormData> dataList, EngineContext context) {
        for (FormData data : dataList) {
            if (attribute.getId().longValue() == data.getFieldid().longValue()) {
                attribute.setValue(data.getValue());
                break;
            }
        }
    }
    
    public void readData(FieldInfo field, HttpServletRequest request, List<FormData> dataList) {
        String code = field.getFieldcode();
        String value = request.getParameter(code);
        if (value != null && value.length() > 0) {
            FormData data = new FormData();
            data.setFieldid(field.getId());
            data.setValue(value);
            dataList.add(data);
        }
    }
    
    /**
     * 创建FieldAttribute
     * @param context
     * @return
     */
    protected abstract FieldAttribute createAttribute(FieldInfo fieldInfo, EngineContext context);
    
    /**
     * 创建子选项，如select、radio、checkbox均需要子选项
     * @param item
     * @param context
     * @return
     */
    protected abstract Option createOption(FieldInfo field, FieldItem item, EngineContext context);
    
    protected String createCompleteHtml(FieldAttribute attribute, String fieldhtml, EngineContext context) {
        String key = "field.engine.table.template";
        String labelHtml = FieldHtmlFormat.getTemplate(key, "td.label");
        String inputHtml = FieldHtmlFormat.getTemplate(key, "td.input");
        
        String labelTd = FieldHtmlFormat.parseHTML(labelHtml, attribute.getFieldname());
        
        String colspan = "";
        if (attribute.getColspan() > 2) {
            colspan = " colspan=\"" + (attribute.getColspan() - 1) + "\" ";
        }
        
        String inputTd = FieldHtmlFormat.parseHTML(inputHtml, new String[] {colspan, fieldhtml});
        return labelTd + inputTd;
    }
    
}
