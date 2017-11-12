package org.hanzhdy.manager.settings.service;

import org.hanzhdy.manager.settings.mapper.FormDataMapperExt;
import org.hanzhdy.manager.settings.model.FormData;
import org.hanzhdy.manager.settings.model.FormDataExample;
import org.hanzhdy.manager.settings.vo.FormDataVo;
import org.hanzhdy.manager.support.service.AbstractUpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description 表单值Service
 * @author H.CAAHN
 * @createtime 2017年6月9日 下午4:57:16
 */
@Service
public class FormDataService extends AbstractUpcService {
    @Autowired
    private FormDataMapperExt formDataMapperExt;
    
    /**
     * 根据业务数据查询它的扩展属性（单表查询，即查询结果不包括fieldcode）
     * @param datatype
     * @param recordid
     * @return
     */
    public List<FormData> queryFormDataAsList(String datatype, Long recordid) {
        FormDataExample example = new FormDataExample();
        FormDataExample.Criteria criteria = example.createCriteria();
        criteria.andDatatypeEqualTo(datatype);
        criteria.andRecordidEqualTo(recordid);
        return this.formDataMapperExt.selectByExample(example);
    }
    
    /**
     * 根据业务数据查询它的扩展属性（关联f_field_info表查询，查询结果中包含有fieldcode）
     * @param datatype
     * @param recordid
     * @return
     */
    public List<FormDataVo> queryFormDataListByRecord(String datatype, Long recordid) {
        return this.formDataMapperExt.selectFormDataByRecord(datatype, recordid);
    }
    
    /**
     * 根据业务数据查询它的扩展属性（关联f_field_info表查询，查询结果中包含有fieldcode）<br/>
     * 返回的结果为Map数据
     * @param datatype
     * @param recordid
     * @return
     */
    public Map<String, FormDataVo> queryFormDataMapByRecord(String datatype, Long recordid) {
        List<FormDataVo> dataList = this.formDataMapperExt.selectFormDataByRecord(datatype, recordid);
        Map<String, FormDataVo> resultMap = new HashMap<String, FormDataVo>();
        if (dataList != null && !dataList.isEmpty()) {
            for (FormDataVo data : dataList) {
                resultMap.put(data.getFieldcode(), data);
            }
        }
        
        return resultMap;
    }
}
