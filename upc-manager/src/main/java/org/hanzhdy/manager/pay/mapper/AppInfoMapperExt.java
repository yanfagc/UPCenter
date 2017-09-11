package org.hanzhdy.manager.pay.mapper;

import org.hanzhdy.manager.pay.model.AppInfo;
import org.hanzhdy.manager.pay.vo.AppInfoVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AppInfoMapperExt extends AppInfoMapper {

    /**
     * 查询角色信息总数
     * @param params
     * @return
     */
    int countAsList(Map<String, Object> params);

    /**
     * 分页查询角色信息
     * @param params
     * @return
     */
    List<AppInfoVo> selectAsList(Map<String, Object> params);


    /**
     * 插入新的支付应用账号信息
     * @param record
     * @return
     */
    int insertSelectiveExt(AppInfo record);

    /**
     * 更新支付应用账号信息（可修改APP_ID）
     * @param params
     * @return
     */
    int updateByOldAppIdSelective(Map<String, Object> params);

}