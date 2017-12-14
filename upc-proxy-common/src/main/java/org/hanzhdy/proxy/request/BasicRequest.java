package org.hanzhdy.proxy.request;

import java.io.Serializable;

/**
 * 基础Request
 * Created by H.CAAHN on 2017/12/8.
 */
public class BasicRequest implements Serializable {
    protected String token;
    
    public String getToken() {
        return token;
    }
    
    public void setToken(String token) {
        this.token = token;
    }
}
