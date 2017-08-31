package org.hanzhdy.manager.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.hanzhdy.manager.support.enums.LoginUserStatus;
import org.hanzhdy.manager.upc.model.AccessSystem;
import org.hanzhdy.manager.upc.service.AccessSystemService;
import org.hanzhdy.manager.upc.service.LoginService;
import org.hanzhdy.manager.upc.service.UserManagerService;
import org.hanzhdy.manager.upc.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.Set;

/**
 * User Realm
 * Created by H.CAAHN on 2017/8/12.
 */
public class ShiroUserRealm extends AuthorizingRealm {
    @Autowired
    private LoginService loginService;
    
    @Autowired
    private UserManagerService userManagerService;
    
    @Autowired
    private AccessSystemService accessSystemService;
    
    @Value("${system.code}")
    private String systemCode;
    
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        String account = (String)principal.getPrimaryPrincipal();
        UserVo user = userManagerService.queryByAccount(account);
        AccessSystem system = accessSystemService.queryBySyscode(systemCode);
        if (user == null || system == null) {
            throw new UnknownAccountException();//没找到帐号或系统数据不存在，均提示帐号异常
        }
        
        Set<String> roleSet = this.loginService.queryUserRoles(user.getId(), system.getId());
        Set<String> resourceSet = this.loginService.queryUserResources(user.getId(), system.getId());
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(roleSet);
        authorizationInfo.setStringPermissions(resourceSet);
        return authorizationInfo;
    }
    
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String account = (String)token.getPrincipal();
        UserVo user = userManagerService.queryByAccount(account);
        if (user == null) {
            throw new UnknownAccountException();
        }
        
        if (LoginUserStatus.L == user.getStatus()) {
            throw new LockedAccountException();
        }
        
        if (LoginUserStatus.F == user.getStatus()) {
            throw new DisabledAccountException("帐号被冻结，禁止访问！");
        }
        
        if (LoginUserStatus.D == user.getStatus()) {
            throw new DisabledAccountException("帐号被注销，禁止访问！");
        }

        if (LoginUserStatus.N != user.getStatus()) {
            throw new DisabledAccountException("帐号状态异常，禁止访问！");
        }
    
//        String password = null;
//        if (token.getCredentials() instanceof String) {
//            password = (String)token.getCredentials();
//        }
//        else {
//            password = new String((char[]) token.getCredentials());
//        }
//
//        String pwdstr = password + "$" + account;
//        String encstr = SecurityUtils.encryptSHA256String(pwdstr);
//        boolean check = StringUtils.equalsIgnoreCase(encstr, user.getPassword());
//
//        if (!check) {
//            throw new UnknownAccountException("用户名或密码错误");
//        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getAccount(), user.getPassword(), getName());
        return authenticationInfo;
    }
}
