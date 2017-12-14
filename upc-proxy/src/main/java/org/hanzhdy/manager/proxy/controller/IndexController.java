package org.hanzhdy.manager.proxy.controller;

import org.hanzhdy.manager.proxy.common.ApiResult;
import org.hanzhdy.manager.proxy.common.UserSession;
import org.hanzhdy.manager.proxy.common.UserSessionFactory;
import org.hanzhdy.proxy.request.GetTokenRequest;
import org.hanzhdy.proxy.response.GetTokenResponse;
import org.hanzhdy.utils.GeneralUtils;
import org.hanzhdy.web.controller.AbstractController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by H.CAAHN on 2017/12/8.
 */
@RestController
@RequestMapping("/api")
public class IndexController extends AbstractController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    
    private static final boolean isDebugEnabled = logger.isDebugEnabled();
    
    /**
     * 客户端获取token请求
     * @param params
     * @param request
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public Object getToken(@RequestBody GetTokenRequest params, HttpServletRequest request) {
        try {
            if (isDebugEnabled) {
                logger.debug("客户端获取token请求...");
            }
            
            String token = GeneralUtils.getRandomId();
            UserSession userSession = new UserSession(token);
            UserSessionFactory.add(userSession);
            
            GetTokenResponse response = new GetTokenResponse();
            response.setToken(token);
            return ApiResult.SUCCESS.appendBody(response);
        }
        catch (Exception ex) {
            logger.error("客户端获取token请求失败");
            return ApiResult.EXCEPTION;
        }
    }
}
