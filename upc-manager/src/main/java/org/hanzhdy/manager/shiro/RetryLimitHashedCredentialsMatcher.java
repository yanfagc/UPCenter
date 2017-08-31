package org.hanzhdy.manager.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.hanzhdy.manager.upc.service.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by H.CAAHN on 2017/8/13.
 */
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {
    @Autowired
    private UserManagerService userManagerService;
    
    public RetryLimitHashedCredentialsMatcher() {
    
    }
    
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String account = (String)token.getPrincipal();
        String password = null;
        if (token.getCredentials() instanceof String) {
            password = (String)token.getCredentials();
        }
        else {
            password = new String((char[]) token.getCredentials());
        }
        boolean matches = this.userManagerService.checkPwd(account, password, (String)info.getCredentials());
        return matches;
    }
}
