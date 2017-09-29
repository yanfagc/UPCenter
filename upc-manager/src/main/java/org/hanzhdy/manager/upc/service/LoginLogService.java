package org.hanzhdy.manager.upc.service;

import org.apache.commons.lang3.StringUtils;
import org.hanzhdy.manager.support.bean.SessionUser;
import org.hanzhdy.manager.support.service.AbstractUpcService;
import org.hanzhdy.manager.upc.controller.params.LoginLogParams;
import org.hanzhdy.manager.upc.mapper.LoginLogMapperExt;
import org.hanzhdy.manager.upc.model.LoginLog;
import org.hanzhdy.manager.upc.model.LoginLogExample;
import org.hanzhdy.web.bean.DatatableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by H.CAAHN on 2017/7/19.
 */
@Service
public class LoginLogService extends AbstractUpcService {
    @Autowired
    private LoginLogMapperExt loginLogMapperExt;
    
    public DatatableResult queryAsDatatableResult(LoginLogParams params) {
        LoginLogExample example = new LoginLogExample();
        LoginLogExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(params.getSearchkey())) {
            criteria.andAccountLike("%" + params.getSearchkey() + "%");
        }
        if (params.getBeginLogintime() != null) {
            criteria.andLogintimeGreaterThanOrEqualTo(params.getBeginLogintime());
        }
        if (params.getEndLogintime() != null) {
            criteria.andLogintimeLessThan(params.getEndLogintime());
        }
        
        example.setPage(params.getPage());
        example.setOrderByClause(" ID DESC ");
        int count = this.loginLogMapperExt.countByExample(example);
        List<LoginLog> dataList = this.loginLogMapperExt.selectByExample(example);
    
        // 设置返回结果
        DatatableResult result = new DatatableResult();
        result.setTotal(count);
        result.setAaData(dataList);
        return result;
    }
    
    public void insert(SessionUser user, String ip, String remark) {
        LoginLog record = new LoginLog();
        record.setUserid(user.getId());
        record.setAccount(user.getAccount());
        record.setNickname(user.getNickname());
        record.setLoginip(ip);
        record.setLogintime(new Date());
        record.setRemark(remark);
        this.loginLogMapperExt.insertSelective(record);
    }
}
