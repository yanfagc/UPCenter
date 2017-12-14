package org.hanzhdy.manager.proxy.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by H.CAAHN on 2017/12/14.
 */
public class UserSession {
    private String token;
    
    private Map<String, Object> map;
    
    public UserSession(String token) {
        this.token = token;
        map = new HashMap<String, Object>();
    }
    
    public void addAttribute(String key, Object value) {
        this.map.put(key, value);
    }
    
    public Object getAttribute(String key) {
        return this.map.get(key);
    }
    
    public String getToken() {
        return token;
    }
}
