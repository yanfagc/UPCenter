package org.hanzhdy.manager.form.service;

import java.util.List;

import org.hanzhdy.manager.form.mapper.FormDataMapperExt;
import org.hanzhdy.manager.form.model.FormData;
import org.hanzhdy.manager.form.model.FormDataExample;
import org.hanzhdy.manager.support.service.AbstractUpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description 表单值Service
 * @author H.CAAHN
 * @createtime 2017年6月9日 下午4:57:16
 */
@Service
public class FormDataService extends AbstractUpcService {
    @Autowired
    private FormDataMapperExt formDataMapperExt;
    
    public List<FormData> queryFormDataAsList(String datatype, Long recordid) {
        FormDataExample example = new FormDataExample();
        FormDataExample.Criteria criteria = example.createCriteria();
        criteria.andDatatypeEqualTo(datatype);
        criteria.andRecordidEqualTo(recordid);
        return this.formDataMapperExt.selectByExample(example);
    }
}
