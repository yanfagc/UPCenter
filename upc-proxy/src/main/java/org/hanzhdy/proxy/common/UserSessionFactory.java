package org.hanzhdy.proxy.common;

import org.hanzhdy.web.cache.CachePolicy;
import org.hanzhdy.web.cache.storage.memory.MemoryTemplate;

import java.util.concurrent.TimeUnit;

/**
 * Created by H.CAAHN on 2017/12/14.
 */
public class UserSessionFactory {
    private static MemoryTemplate<String, UserSession> template = new MemoryTemplate<>();

    public static void add(UserSession userSession) {
        template.put(userSession.getToken(), userSession, 30, TimeUnit.MINUTES, CachePolicy.TTI);
    }

    public static void get(String key) {
        template.get(key);
    }
}
