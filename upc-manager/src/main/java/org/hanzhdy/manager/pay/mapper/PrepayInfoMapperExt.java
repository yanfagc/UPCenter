package org.hanzhdy.manager.pay.mapper;

import org.hanzhdy.manager.pay.vo.AppInfoVo;
import org.hanzhdy.manager.pay.vo.PayInfoVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PrepayInfoMapperExt extends PrepayInfoMapper {

    /**
     * 查询支付信息总数
     * @param params
     * @return
     */
    int countAsList(Map<String, Object> params);

    /**
     * 分页查询支付信息
     * @param params
     * @return
     */
    List<PayInfoVo> selectAsList(Map<String, Object> params);
}