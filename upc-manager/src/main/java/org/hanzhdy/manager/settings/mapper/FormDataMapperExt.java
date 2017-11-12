package org.hanzhdy.manager.settings.mapper;

import org.apache.ibatis.annotations.Param;
import org.hanzhdy.manager.settings.vo.FormDataVo;

import java.util.List;

public interface FormDataMapperExt extends FormDataMapper {
    /**
     * 根据业务数据查询它的扩展属性（datatype与recordid）
     * @param datatype
     * @param recordid
     * @return
     */
    List<FormDataVo> selectFormDataByRecord(@Param("datatype") String datatype, @Param("recordid") Long recordid);
}