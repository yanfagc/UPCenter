package org.hanzhdy.manager.engine;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hanzhdy.manager.engine.attribute.FieldAttribute;
import org.hanzhdy.manager.engine.constants.FieldType;
import org.hanzhdy.manager.form.model.FieldInfo;
import org.hanzhdy.manager.form.model.FieldItem;
import org.hanzhdy.manager.form.model.FormData;

/**
 * @description Field Engine
 * @author H.CAAHN
 * @createtime 2016年1月1日 下午10:39:11
 */
public interface FieldEngine {
    /**
     * 获取FieldAttribute
     * @param field
     * @param itemList
     * @param context
     * @return
     */
    FieldAttribute settingAttribute(FieldInfo field, List<FieldItem> itemList, EngineContext context);
    
    /**
     * 设置表单值
     * @param attribute
     * @param dataList
     * @param context
     */
    void settingData(FieldAttribute attribute, List<FormData> dataList, EngineContext context);
    
    /**
     * 根据FieldAttribute对象获取html
     * @param attribute
     * @param context
     * @return
     */
    String getHtml(FieldAttribute attribute, EngineContext context);
    
    /**
     * 从dataMap中读取数据，并添加到dataList中
     * @param field
     * @param request
     * @param dataList
     */
    void readData(FieldInfo field, HttpServletRequest request, List<FormData> dataList);
    
    /**
     * FieldEngine的类型
     * @return
     */
    FieldType getType();
}
