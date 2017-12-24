package org.hanzhdy.proxy.service;

import org.hanzhdy.manager.support.service.AbstractUpcService;
import org.hanzhdy.proxy.request.GetTokenRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * token服务
 * Created by H.CAAHN on 2017/12/9.
 */
//@Service
public class TokenService extends AbstractUpcService {
    public String getToken(GetTokenRequest params, HttpServletRequest request) {
        return null;
    }
}
