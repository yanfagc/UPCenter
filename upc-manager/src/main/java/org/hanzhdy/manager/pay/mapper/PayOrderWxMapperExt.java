package org.hanzhdy.manager.pay.mapper;

import org.hanzhdy.manager.pay.controller.params.PayInfoParams;
import org.hanzhdy.manager.pay.vo.PayOrderWxVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PayOrderWxMapperExt extends PayOrderWxMapper {

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
    List<PayOrderWxVo> selectByParamsSelective(Map<String, Object> params);
}