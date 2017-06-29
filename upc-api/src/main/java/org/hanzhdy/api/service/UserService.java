package org.hanzhdy.api.service;

import org.apache.commons.lang3.StringUtils;
import org.hanzhdy.api.vo.UserVo;
import org.hanzhdy.manager.support.service.AbstractUpcService;
import org.hanzhdy.manager.upc.mapper.UserBasicMapperExt;
import org.hanzhdy.manager.upc.model.UserBasic;
import org.hanzhdy.utils.security.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 用户Service
 * Created by H.CAAHN on 2017/6/27.
 */
@Service
public class UserService extends AbstractUpcService {
    @Autowired
    private UserBasicMapperExt userBasicMapperExt;

    public UserVo updateForLogin(String account, String password, String loginip) {
        // 检查用户
        UserVo user = this.userBasicMapperExt.selectByAccount(account);
        if (user == null) {
            return null;
        }

        String pwdstr = password + "$" + account;
        String encstr = SecurityUtils.encryptSHA256String(pwdstr);
        boolean match = StringUtils.equalsIgnoreCase(encstr, user.getPassword());
        if (!match) {
            return null;
        }

        // 更新用户的登录信息
        UserBasic userBasic = new UserBasic();
        userBasic.setPrelogintime(user.getCurrlogintime());
        userBasic.setPreloginip(user.getCurrloginip());
        userBasic.setCurrloginip(loginip);
        userBasic.setCurrlogintime(new Date());
        this.userBasicMapperExt.updateByPrimaryKeySelective(userBasic);

        // 查询用户的扩展属性

        return user;
    }
}
