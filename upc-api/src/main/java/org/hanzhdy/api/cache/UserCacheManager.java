package org.hanzhdy.api.cache;

/**
 * user cache
 * Created by H.CAAHN on 2017/6/28.
 */
public interface UserCacheManager {
    /**
     * 添加UserCache
     * @param token
     * @param cache
     */
    void addUserCache(String token, UserCache cache);

    /**
     * 移除指定token的UserCache
     * @param token
     */
    void removeUserCache(String token);

    /**
     * 根据token获取UserCache
     * @param token
     * @return
     */
    UserCache getUserCache(String token);
}
