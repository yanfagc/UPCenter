package org.hanzhdy.manager.settings.service;

import org.apache.commons.lang3.StringUtils;
import org.hanzhdy.manager.settings.controller.params.FieldInfoParams;
import org.hanzhdy.manager.settings.mapper.FieldInfoMapperExt;
import org.hanzhdy.manager.settings.mapper.FieldItemMapperExt;
import org.hanzhdy.manager.settings.model.FieldInfo;
import org.hanzhdy.manager.settings.model.FieldInfoExample;
import org.hanzhdy.manager.settings.model.FieldItem;
import org.hanzhdy.manager.settings.model.FieldItemExample;
import org.hanzhdy.manager.settings.vo.FieldInfoVo;
import org.hanzhdy.manager.settings.vo.FormFieldVo;
import org.hanzhdy.manager.support.enums.CommonStatus;
import org.hanzhdy.manager.support.service.AbstractUpcService;
import org.hanzhdy.web.bean.DatatableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description 表单字段Service
 * @author H.CAAHN
 * @createtime 2015年12月1日 下午11:35:02
 */
@Service
public class FieldInfoService extends AbstractUpcService {
    @Autowired
    private FieldInfoMapperExt fieldInfoMapperExt;
    
    @Autowired
    private FieldItemMapperExt fieldItemMapperExt;
    
    /**
     * 分页查询表单字段信息，并按条件返回符合datatable数据格式的数据信息
     * @param params
     * @return
     */
    public DatatableResult queryAsDatatableResult(FieldInfoParams params) {
        // 构造查询条件
        FieldInfoExample example = new FieldInfoExample();
        FieldInfoExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(params.getFieldcode())) {
            criteria.andFieldcodeLike("%" + params.getFieldcode() + "%");
        }
        if (StringUtils.isNotBlank(params.getFieldname())) { 
            criteria.andFieldnameLike("%" + params.getFieldname() + "%");
        }
        if (params.getFieldtype() != null) {
            criteria.andFieldtypeEqualTo(params.getFieldtype());
        }
                
        // 查询数据
        int total = this.fieldInfoMapperExt.countByExample(example);
        List<FieldInfo> data = this.fieldInfoMapperExt.selectByExample(example);
        if (data != null && !data.isEmpty()) {
            this.settingShowtext(data);
        }
        
        // 设置返回结果
        DatatableResult result = new DatatableResult();
        result.setTotal(total);
        result.setAaData(data);
        return result;
    }
    
    /**
     * 根据条件，查询表单字段信息，用于autoComplete
     * @param searchKey
     * @return
     */
    public List<FieldInfo> queryAsAutoComplete(String searchKey) {
        if (StringUtils.isNotBlank(searchKey)) {
            searchKey = "%" + searchKey + "%";
            return this.fieldInfoMapperExt.selectAsAutoComplete(searchKey);
        }
        return null;
    }
    
    /**
     * 根据formid分页查询表单字段信息，并返回符合datatable数据格式的数据信息
     * @param params
     * @return
     */
    public DatatableResult queryByFormidAsDatatableResult(FieldInfoParams params) {
        // 构造查询条件
        Map<String, Object> search = new HashMap<String, Object>();
        search.put("page", params.createPage());
        search.put("formid", params.getFormid());
        
        // 查询数据
        int count = this.fieldInfoMapperExt.countByFormId(search);
        List<FormFieldVo> data = this.fieldInfoMapperExt.selectByFormIdAsPage(search);
        
        // 设置返回结果
        DatatableResult result = new DatatableResult();
        result.setTotal(count);
        result.setAaData(data);
        return result;
    }
    
    /**
     * 查询可添加到指定表单中的字段信息
     * @param params
     * @return
     */
    public DatatableResult queryCanAddFieldAsDTR(FieldInfoParams params) {
        // 构造查询条件
        Map<String, Object> search = new HashMap<String, Object>();
        search.put("page", params.createPage());
        search.put("formid", params.getFormid());
        search.put("fieldcode", "%" + params.getFieldcode() + "%");
        search.put("fieldname", "%" + params.getFieldname() + "%");
        
        // 查询数据
        int count = this.fieldInfoMapperExt.countCanAddField(search);
        List<FieldInfo> data = this.fieldInfoMapperExt.selectCanAddField(search);
        
        // 设置返回结果
        DatatableResult result = new DatatableResult();
        result.setTotal(count);
        result.setAaData(data);
        return result;
    }
    
    /**
     * 根据ID查询表单字段数据
     * @param id
     * @return
     */
    public FieldInfo queryById(Long id) {
        return this.fieldInfoMapperExt.selectByPrimaryKey(id);
    }
    
    /**
     * 根据表单ID查询其包含的字段信息
     * @param id
     * @return
     */
    public List<FieldInfo> queryFieldsByFormId(Long id) {
        return this.fieldInfoMapperExt.selectByFormId(id);
    }
    
    /**
     * 根据FieldInfo表的ID查询出其对应的FieldItem数据
     * @param id
     * @return
     */
    public List<FieldItem> queryItemsByFieldId(Long id) {
        FieldItemExample itemExample = new FieldItemExample();
        itemExample.createCriteria().andFieldidEqualTo(id);
        itemExample.setOrderByClause(" SORT ASC ");
        return this.fieldItemMapperExt.selectByExample(itemExample);
    }
    
    /**
     * 根据表单ID查询
     * @param id
     * @return
     */
    public List<FieldItem> queryItemsByFormId(Long id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("formid", id);
        params.put("status", CommonStatus.N);
        return this.fieldItemMapperExt.selectFieldItemsByFormid(params);
    }
    
    /**
     * 插入新的表单字段数据
     * @param record
     * @return
     */
    public boolean insert(FieldInfo record) {
        // 执行插入动作
        int count = this.fieldInfoMapperExt.insertSelective(record);
        
        // 插入select、radio、checkbox的子选项
        if (count > 0 && record instanceof FieldInfoVo) {
            FieldInfoVo vo = (FieldInfoVo) record;
            if (vo.getItemvalue() != null && vo.getItemvalue().length > 0 && record.getFieldtype().hasItems()) {
                for (int i = 0, s = vo.getItemvalue().length; i < s; i++) {
                    FieldItem item = new FieldItem();
                    item.setFieldid(vo.getId());
                    item.setItemvalue(vo.getItemvalue()[i]);
                    item.setItemname(vo.getItemname()[i]);
                    item.setStatus(CommonStatus.N);
                    item.setSort((short) (i + 1));
                    fieldItemMapperExt.insert(item);
                }
            }
        }
        
        return count > 0;
    }
    
    /**
     * 更新表单字段数据
     * @param record
     * @return
     */
    public boolean update(FieldInfo record) {
        // 执行更新动作
        int count = this.fieldInfoMapperExt.updateByPrimaryKeySelective(record);
        // 插入select、radio、checkbox的子选项
        if (count > 0 && record instanceof FieldInfoVo) {
            FieldInfoVo vo = (FieldInfoVo) record;
            if (vo.getItemvalue() != null && vo.getItemvalue().length > 0 && record.getFieldtype().hasItems()) {
                // 先删除原有的数据
                FieldItemExample itemExample = new FieldItemExample();
                itemExample.createCriteria().andFieldidEqualTo(record.getId());
                this.fieldItemMapperExt.deleteByExample(itemExample);
                
                
                for (int i = 0, s = vo.getItemvalue().length; i < s; i++) {
                    FieldItem item = new FieldItem();
                    item.setFieldid(vo.getId());
                    item.setItemvalue(vo.getItemvalue()[i]);
                    item.setItemname(vo.getItemname()[i]);
                    item.setStatus(CommonStatus.N);
                    item.setSort((short) (i + 1));
                    fieldItemMapperExt.insert(item);
                }
            }
        }
        
        return count > 0;
    }
    
    /**
     * 更新字段规则
     * @param record
     * @return
     */
    public boolean updateRule(FieldInfo record) {
        FieldInfo f = this.fieldInfoMapperExt.selectByPrimaryKey(record.getId());
        f.setRequired(record.getRequired());
        f.setLengthtype(record.getLengthtype());
        f.setMaxlength(record.getMaxlength());
        f.setMinlength(record.getMinlength());
        f.setMaxval(record.getMaxval());
        f.setMinval(record.getMinval());
        f.setMaxlimit(record.getMaxlimit());
        f.setMinlimit(record.getMinlimit());
        f.setLinkage(record.getLinkage());
        f.setRegular(record.getRegular());
        int count = this.fieldInfoMapperExt.updateByPrimaryKey(f);
        return count > 0;
    }
    
    /**
     * 更新表单字段数据状态
     * @param record
     * @return
     */
    public boolean updateStatus(FieldInfo record) {
        // 执行状态更新操作
        FieldInfo info = new FieldInfo();
        info.setId(record.getId());
        info.setStatus(record.getStatus());
        int count = this.fieldInfoMapperExt.updateByPrimaryKeySelective(info);
        return count > 0;
    }
    
    /**
     * 设置defaultvalue的显示值
     * @param data
     */
    private void settingShowtext(List<FieldInfo> data) {
        List<Long> ids = new ArrayList<Long>();
        for (FieldInfo field : data) {
            ids.add(field.getId());
        }
        
        FieldItemExample ie = new FieldItemExample();
        ie.createCriteria().andFieldidIn(ids);
        List<FieldItem> iList = this.fieldItemMapperExt.selectByExample(ie);
        if (iList != null && !iList.isEmpty()) {
            for (FieldInfo field : data) {
                if (field.getDefaultvalue().isEmpty() || !field.getFieldtype().hasItems()) {
                    continue;
                }
                String[] ss = field.getDefaultvalue().split(",");
                StringBuffer buf = new StringBuffer();
                for (FieldItem item : iList) {
                    if (field.getId().intValue() == item.getFieldid().intValue()) {
                        for (String s : ss) {
                            if (item.getItemvalue().equals(s)) {
                                buf.append(buf.length() == 0 ? "" : ", ");
                                buf.append(item.getItemname());
                            }
                        }
                    }
                }
                field.setDefaultvalue(buf.toString());
            }
        }
    }
}
