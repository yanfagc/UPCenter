package org.hanzhdy.manager.settings.engine;

import java.util.List;

import org.hanzhdy.manager.settings.engine.attribute.FieldAttribute;
import org.hanzhdy.manager.settings.model.FieldInfo;
import org.hanzhdy.manager.settings.model.FieldItem;
import org.hanzhdy.manager.settings.model.FormData;
import org.hanzhdy.manager.settings.model.FormInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description
 * @author H.CAAHN
 * @createtime 2017年6月9日 下午4:05:47
 */
public class FormHtml {
    private EngineContext        context;
    
    private FormInfo             formInfo;
    
    private List<FieldInfo>      fieldList;
    
    private List<FieldItem>      itemList;
    
    private List<FormData>       dataList;
    
    private List<FieldAttribute> attrList;
    
    private static final Logger  logger = LoggerFactory.getLogger(FormHtml.class);
    
    public FormHtml(EngineContext context) {
        this.context = context;
    }
    
    public void prepareHandle() {
        context.setMaxColumns(formInfo.getColcounts() * 2);
        attrList = FormEngine.settingFieldAttributes(fieldList, itemList, context);
        FormEngine.settingData(attrList, dataList, context);
    }
    
    public String getHtml() {
        try {
            return FormEngine.getHtml(formInfo, attrList, context);
        }
        catch (Exception ex) {
            logger.error("获取HTML失败", ex);
            return "";
        }
    }
    
    public String getValidateJs() {
        return "";
    }
    
    public List<FieldInfo> getFieldList() {
        return fieldList;
    }
    
    public void setFieldList(List<FieldInfo> fieldList) {
        this.fieldList = fieldList;
    }
    
    public List<FieldItem> getItemList() {
        return itemList;
    }
    
    public void setItemList(List<FieldItem> itemList) {
        this.itemList = itemList;
    }
    
    public FormInfo getFormInfo() {
        return formInfo;
    }
    
    public void setFormInfo(FormInfo formInfo) {
        this.formInfo = formInfo;
    }
    
    public List<FormData> getDataList() {
        return dataList;
    }
    
    public void setDataList(List<FormData> dataList) {
        this.dataList = dataList;
    }
}
