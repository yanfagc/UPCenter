package org.hanzhdy.manager.form.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.hanzhdy.manager.engine.EngineContext;
import org.hanzhdy.manager.engine.FormEngine;
import org.hanzhdy.manager.engine.FormHtml;
import org.hanzhdy.manager.form.model.FieldInfo;
import org.hanzhdy.manager.form.model.FieldItem;
import org.hanzhdy.manager.form.model.FormData;
import org.hanzhdy.manager.form.model.FormInfo;
import org.hanzhdy.manager.support.service.AbstractUpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description Form Engine Service
 * @author H.CAAHN
 * @createtime 2015年12月20日 下午11:20:59
 */
@Service
public class FormEngineService extends AbstractUpcService {
    @Autowired
    private FieldInfoService fieldInfoService;
    
    @Autowired
    private FormDataService  formDataService;
    
    /**
     * 解析成HTML代码
     * @param formInfo
     * @return
     */
    public FormHtml parseTableHtml(FormInfo formInfo, Long tabvid, String type, EngineContext context) {
        FormHtml result = new FormHtml(context);
        List<FieldInfo> fieldList = this.fieldInfoService.queryFieldsByFormId(formInfo.getId());
        List<FieldItem> itemList = this.fieldInfoService.queryItemsByFormId(formInfo.getId());
        
        result.setItemList(itemList);
        result.setFormInfo(formInfo);
        result.setFieldList(fieldList);
        if (tabvid != null && StringUtils.isNotBlank(type)) {
            List<FormData> dataList = this.formDataService.queryFormDataAsList(type, tabvid);
            result.setDataList(dataList);
        }
        
        // 预处理
        result.prepareHandle();
        return result;
    }
    
    /**
     * 从request中读取数据
     * @param formid
     * @param request
     * @return
     */
    public List<FormData> getFormData(Long formid, HttpServletRequest request) {
        List<FieldInfo> fieldList = this.fieldInfoService.queryFieldsByFormId(formid);
        
        List<FormData> dataList = FormEngine.getFormData(fieldList, request);
        return dataList;
    }
}
