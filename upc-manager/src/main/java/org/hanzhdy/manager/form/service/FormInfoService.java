package org.hanzhdy.manager.form.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hanzhdy.manager.form.controller.params.FormInfoParams;
import org.hanzhdy.manager.form.mapper.FormFieldMapperExt;
import org.hanzhdy.manager.form.mapper.FormInfoMapperExt;
import org.hanzhdy.manager.form.model.FormField;
import org.hanzhdy.manager.form.model.FormFieldKey;
import org.hanzhdy.manager.form.model.FormInfo;
import org.hanzhdy.manager.form.model.FormInfoExample;
import org.hanzhdy.manager.form.model.FormInfoExample.Criteria;
import org.hanzhdy.manager.support.enums.CommonStatus;
import org.hanzhdy.manager.support.service.AbstractUpcService;
import org.hanzhdy.web.bean.DatatableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description 表单管理的Service
 * @author H.CAAHN
 * @createtime 2015年12月10日 下午10:39:55
 */
@Service
public class FormInfoService extends AbstractUpcService {
    @Autowired
    private FormInfoMapperExt  formInfoMapperExt;
    
    @Autowired
    private FormFieldMapperExt formFieldMapperExt;
    
    /**
     * 分页查询表单基本信息，并按条件返回符合datatable数据格式的数据信息
     * @param params
     * @return
     */
    public DatatableResult queryAsDatatableResult(FormInfoParams params) {
        // 构造查询条件
        FormInfoExample example = new FormInfoExample();
        example.setPage(params.createPage());
        Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(params.getFormcode())) {
            criteria.andFormcodeLike("%" + params.getFormcode() + "%");
        }
        if (StringUtils.isNotBlank(params.getFormname())) {
            criteria.andFormnameLike("%" + params.getFormname() + "%");
        }
        if (params.getStatus() != null) {
            criteria.andStatusEqualTo(params.getStatus());
        }
        
        // 查询数据
        int total = this.formInfoMapperExt.countByExample(example);
        List<FormInfo> data = this.formInfoMapperExt.selectByExample(example);
        
        // 设置返回结果
        DatatableResult result = new DatatableResult();
        result.setTotal(total);
        result.setAaData(data);
        return result;
    }
    
    /**
     * 根据ID查询表单基本信息
     * @param id
     * @return
     */
    public FormInfo queryById(Long id) {
        return this.formInfoMapperExt.selectByPrimaryKey(id);
    }
    
    /**
     * 查询所有状态正常的表单信息
     * @return
     */
    public List<FormInfo> queryFormInfoAsList() {
        FormInfoExample example = new FormInfoExample();
        example.createCriteria().andStatusEqualTo(CommonStatus.N);
        return this.formInfoMapperExt.selectByExample(example);
    }
    
    /**
     * 根据formid和fieldid查询关联关系数据
     * @param formid
     * @param fieldid
     * @return
     */
    public FormField queryFormFieldByPkey(Long formid, Long fieldid) {
        FormFieldKey key = new FormFieldKey();
        key.setFormId(formid);
        key.setFieldId(fieldid);
        return this.formFieldMapperExt.selectByPrimaryKey(key);
    }
    
    /**
     * 插入新的表单数据
     * @param record
     * @return
     */
    public boolean insert(FormInfo record) {
        // 执行插入动作
        record.setCreatetime(new Date());
        record.setUpdater(record.getCreator());
        record.setUpdatetime(record.getCreatetime());
        int count = this.formInfoMapperExt.insertSelective(record);
        return count > 0;
    }
    
    /**
     * 更新表单数据
     * @param record
     * @return
     */
    public boolean update(FormInfo record) {
        // 执行更新动作
        record.setUpdatetime(new Date());
        int count = this.formInfoMapperExt.updateByPrimaryKeySelective(record);
        
        return count > 0;
    }
    
    /**
     * 更新表单数据状态
     * @param record
     * @return
     */
    public boolean updateStatus(FormInfo record) {
        FormInfo info = new FormInfo();
        info.setId(record.getId());
        info.setStatus(record.getStatus());
        info.setUpdater(record.getUpdater());
        info.setUpdatetime(new Date());
        int count = this.formInfoMapperExt.updateByPrimaryKeySelective(info);
        return count > 0;
    }
    
    /**
     * 根据表单和字段ID的字符串数组，添加该关联关系
     * @param formid
     * @param fieldid
     * @return
     */
    public boolean insertFormField(Long formid, String fieldid, String colspan) {
        String[] ids = fieldid.split(",");
        String[] cls = colspan.split(",");
        for (int i = 0; i < ids.length; i++) {
            Long fid = null;
            Integer col = null;
            try {
                fid = Long.valueOf(ids[i]);
                col = Integer.valueOf(cls[i]);
            }
            catch (NumberFormatException ex) {
                continue;
            }
            
            FormField ff = new FormField();
            ff.setFormId(formid);
            ff.setFieldId(fid);
            ff.setColspan(col);
            ff.setSort((short)(i + 1));
            this.formFieldMapperExt.insert(ff);
        }
        return true;
    }
    
    /**
     * 更新表单字段关联关系
     * @param record
     * @return
     */
    public boolean updateFormField(FormField record) {
        int count = this.formFieldMapperExt.updateByPrimaryKeySelective(record);
        return count > 0;
    }
    
    /**
     * 根据表单和字段ID，删除该关联关系
     * @param formid
     * @param fieldid
     * @return
     */
    public boolean deleteFormField(Long formid, Long fieldid) {
        FormFieldKey key = new FormFieldKey();
        key.setFormId(formid);
        key.setFieldId(fieldid);
        this.formFieldMapperExt.deleteByPrimaryKey(key);
        return true;
    }
}
