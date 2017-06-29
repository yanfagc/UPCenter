package org.hanzhdy.api.cache.impl;

import org.hanzhdy.api.cache.UserCache;
import org.hanzhdy.api.cache.UserCacheManager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by H.CAAHN on 2017/6/29.
 */
public class MemoryUserCacheManager implements UserCacheManager {
    protected Map<String, UserCache> cacheMap;

    public MemoryUserCacheManager() {
        this.init();
    }

    protected void init() {
        cacheMap = new ConcurrentHashMap<>();
    }

    @Override
    public void addUserCache(String token, UserCache cache) {
        cacheMap.put(token, cache);
    }

    @Override
    public void removeUserCache(String token) {
        cacheMap.remove(token);
    }

    @Override
    public UserCache getUserCache(String token) {
        return cacheMap.get(token);
    }
}
