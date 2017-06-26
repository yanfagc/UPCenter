package org.hanzhdy.manager.form.mapper;

import java.util.List;
import java.util.Map;

import org.hanzhdy.manager.form.model.FieldInfo;
import org.hanzhdy.manager.form.vo.FormFieldVo;

public interface FieldInfoMapperExt extends FieldInfoMapper {
    /**
     * 根据表单ID查询其关联的字段信息
     * @param formid
     * @return
     */
    List<FieldInfo> selectByFormId(Long formid);
    
    /**
     * 根据表单ID和其他查询条件，查询表单关联的字段信息
     * @param params
     * @return
     */
    List<FieldInfo> selectByFormIdAndConds(Map<String, Object> params);
    
    /**
     * 根据表单ID，查询表单关联的字段信息总数
     * @param params
     * @return
     */
    int countByFormId(Map<String, Object> params);
    
    /**
     * 根据表单ID，分页查询表单关联的字段信息
     * @param params
     * @return
     */
    List<FormFieldVo> selectByFormIdAsPage(Map<String, Object> params);
    
    /**
     * 查询可添加到指定表单中的字段总数
     * @param params
     * @return
     */
    int countCanAddField(Map<String, Object> params);
    
    /**
     * 查询可添加到指定表单中的字段列表
     * @param params
     * @return
     */
    List<FieldInfo> selectCanAddField(Map<String, Object> params);
    
    /**
     * 根据条件，查询表单字段信息，用于autoComplete
     * @param searchKey
     * @return
     */
    List<FieldInfo> selectAsAutoComplete(String searchKey);
}