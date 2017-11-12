package org.hanzhdy.manager.settings.mapper;

import java.util.List;
import java.util.Map;

import org.hanzhdy.manager.settings.model.FieldItem;

public interface FieldItemMapperExt extends FieldItemMapper {
    /**
     * 根据formid查询出form关联的字段中子列信息
     * @param params
     * @return
     */
    public List<FieldItem> selectFieldItemsByFormid(Map<String, Object> params);
}