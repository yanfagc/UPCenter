package org.hanzhdy.manager.upc.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.hanzhdy.manager.support.bean.SessionUser;
import org.hanzhdy.manager.support.service.AbstractUpcService;
import org.hanzhdy.manager.upc.model.MenuItem;
import org.hanzhdy.manager.upc.model.Role;
import org.hanzhdy.manager.upc.vo.UserVo;
import org.hanzhdy.utils.HttpUtils;
import org.hanzhdy.utils.HttpUtils.HttpResult;
import org.hanzhdy.web.throwable.LocalBizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * @description 手机验证码
 * @author H.CAAHN
 * @createtime 2015年12月21日 下午10:12:27
 */
@Service
public class LoginService extends AbstractUpcService {
    private String              tokenurl = "http://221.226.98.138:18013/jmetoken/tokenapi/verifyToken";
    
    private Map<String, String> headers;
    
    @Autowired
    private RoleService         roleService;
    
    @Autowired
    private UserManagerService  userManagerService;
    
    @Autowired
    private MenuItemService     menuItemService;
    
    @Autowired
    private AccessSystemService accessSystemService;
    
    private static final Logger logger   = LoggerFactory.getLogger(LoginService.class);
    
    @PostConstruct
    public void init() {
        headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");
    }
    
    public SessionUser insertByCheckLogin(String account, String password, String token) {
        UserVo user = userManagerService.queryByAccount(account);
        if (user == null) {
            throw new LocalBizException(respCode.LOGIN_ILLEGAL_USER_PWD);
        }
        
        if (StringUtils.isBlank(user.getMobileno())) {
            throw new LocalBizException(respCode.LOGIN_ILLEGAL_MOBILETOKEN);
        }
        
//        boolean rst = this.checkToken(user.getMobileno(), token);
//        if (!rst) {
//            throw new IllegalTokenException();
//        }
        
        // 开始校验密码
        boolean rst = this.userManagerService.checkPwd(account, password, user.getPassword());
        if (!rst) {
            throw new LocalBizException(respCode.LOGIN_ILLEGAL_USER_PWD);
        }
        
        SessionUser su = new SessionUser();
        su.setAccount(user.getAccount());
        su.setId(user.getId());
        su.setNickname(user.getNickname());
        su.setStatus(user.getStatus());
        return su;
    }
    
    public SessionUser getSessionUserByAccount(String account) {
        UserVo user = userManagerService.queryByAccount(account);
        if (user == null) {
            throw new LocalBizException(respCode.LOGIN_ILLEGAL_USER_PWD);
        }
        SessionUser su = new SessionUser();
        su.setAccount(user.getAccount());
        su.setId(user.getId());
        su.setNickname(user.getNickname());
        su.setStatus(user.getStatus());
        su.setImgurl(user.getImgurl());
        return su;
    }
    
    /**
     * 查询指定帐号所拥有的角色集合
     * @param userid
     * @param systemid
     * @return
     */
    public Set<String> queryUserRoles(Long userid, Long systemid) {
        Set<String> result = new HashSet<>();
        if (userid == null || systemid == null) {
            return result;
        }
        
        List<Role> roleList = roleService.queryByUserAndSysId(userid, systemid);
        if (roleList != null && !roleList.isEmpty()) {
            for (Role role : roleList) {
                result.add(role.getRolecode());
            }
        }
        
        return result;
    }
    
    /**
     * 查询指定帐号所拥有的权限信息
     * @param userid
     * @param systemid
     * @return
     */
    public Set<String> queryUserResources(Long userid, Long systemid) {
        Set<String> result = new HashSet<>();
        if (userid == null || systemid == null) {
            return result;
        }
        
        List<MenuItem> itemList = this.menuItemService.queryByUserAndSysid(userid, systemid);
        if (itemList != null && !itemList.isEmpty()) {
            for (MenuItem item : itemList) {
                if (StringUtils.isNotBlank(item.getResource())) {
                    result.add(item.getResource());
                }
            }
        }
    
        return result;
    }
    
    /**
     * 校验手机号码和验证码是否匹配
     * @param mobileno
     * @param token
     * @return
     */
    public boolean checkToken(String mobileno, String token) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("mobile", mobileno);
        params.put("code", token);
        HttpResult result = HttpUtils.post(tokenurl, headers, JSON.toJSONString(params), "UTF-8");
        if (result.getStatus() == HttpStatus.SC_OK) {
            String data = result.getString();
            try {
                JSONObject obj = JSON.parseObject(data);
                int rcode = (int) obj.get("result");
                if (rcode != 200) {
                    logger.warn("校验失败");
                    return false;
                }
                else {
                    return true;
                }
            }
            catch (JSONException ex) {
                logger.error("不能将字符串转换为JSON对象：{}", data);
            }
        }
        return false;
    }
}
