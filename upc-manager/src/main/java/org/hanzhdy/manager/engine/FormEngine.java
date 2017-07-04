package org.hanzhdy.manager.engine;

import org.hanzhdy.manager.engine.attribute.FieldAttribute;
import org.hanzhdy.manager.engine.build.LineBuilder;
import org.hanzhdy.manager.engine.impl.*;
import org.hanzhdy.manager.engine.utils.SortableUtils;
import org.hanzhdy.manager.form.model.FieldInfo;
import org.hanzhdy.manager.form.model.FieldItem;
import org.hanzhdy.manager.form.model.FormData;
import org.hanzhdy.manager.form.model.FormInfo;
import org.hanzhdy.manager.support.enums.FieldType;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description Form Engine
 * @author H.CAAHN
 * @createtime 2015年12月20日 下午11:21:57
 */
public class FormEngine {
    private static Map<FieldType, FieldEngine> fieldEngineMap;
    
    static {
        fieldEngineMap = new HashMap<FieldType, FieldEngine>();
        fieldEngineMap.put(FieldType.INPUT, new InputFieldEngine());
        fieldEngineMap.put(FieldType.TEXTAREA, new TextAreaFieldEngine());
        fieldEngineMap.put(FieldType.SELECT, new SelectFieldEngine());
        fieldEngineMap.put(FieldType.CHECKBOX, new CheckboxFieldEngine());
        fieldEngineMap.put(FieldType.RADIO, new RadioFieldEngine());
        fieldEngineMap.put(FieldType.MACROS, new MacrosFieldEngine());
    }
    
    /**
     * 获取HTML
     * @param attrList
     * @return
     */
    protected static String getHtml(FormInfo formInfo, List<FieldAttribute> attrList, EngineContext context) {
        StringBuffer html = new StringBuffer();
        
        int maxColumns = context.getMaxColumns();
        SortableUtils.sort(attrList, maxColumns);
        LineBuilder line = new LineBuilder();
        line.initBuilder(maxColumns);
        
        for (int i = 0, s = attrList.size(); i < s; i++) {
            FieldAttribute attr = attrList.get(i);
            FieldEngine engine = fieldEngineMap.get(attr.getFieldtype());
            String content = engine.getHtml(attr, context);
            
            if (line.testAppend(attr.getColspan())) {
                line.append(content, attr.getColspan());
            }
            else {
                html.append(line.getHtml());
                line.clear();
                line.append(content, attr.getColspan());
            }
        }
        html.append(line.getHtml());
        
        return html.toString();
    }
    
    /**
     * 将FieldInfo列表和FieldItem列表组装成FieldAttribute列表
     * @param fList
     * @param iList
     * @return
     */
    protected static List<FieldAttribute> settingFieldAttributes(List<FieldInfo> fList, List<FieldItem> iList,
            EngineContext context) {
        if (fList == null || fList.isEmpty()) {
            return null;
        }
        
        List<FieldAttribute> resultList = new ArrayList<FieldAttribute>(fList.size());
        for (FieldInfo field : fList) {
            FieldEngine fieldEngine = fieldEngineMap.get(field.getFieldtype());
            FieldAttribute attribute = fieldEngine.settingAttribute(field, iList, context);
            resultList.add(attribute);
        }
        return resultList;
    }
    
    /**
     * 设置表单值
     * @param attrList
     * @param dataList
     */
    protected static void settingData(List<FieldAttribute> attrList, List<FormData> dataList, EngineContext context) {
        if (attrList == null || attrList.isEmpty() || dataList == null || dataList.isEmpty()) {
            return;
        }
        
        for (FieldAttribute attribute : attrList) {
            FieldEngine fieldEngine = fieldEngineMap.get(attribute.getFieldtype());
            fieldEngine.settingData(attribute, dataList, context);
        }
    }
    
    /**
     * 获取并组装FieldData数据
     * @param fieldList
     * @param dataMap
     * @return
     */
    public static List<FormData> getFormData(List<FieldInfo> fieldList, HttpServletRequest request) {
        if (fieldList == null || fieldList.isEmpty()) {
            return null;
        }
        
        List<FormData> dataList = new ArrayList<FormData>();
        for (FieldInfo field : fieldList) {
            FieldEngine engine = fieldEngineMap.get(field.getFieldtype());
            engine.readData(field, request, dataList);
        }
        return dataList;
    }
}
