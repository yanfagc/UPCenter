package org.hanzhdy.upc.api.client;

import org.hanzhdy.upc.api.client.bean.UPCConfigure;
import org.hanzhdy.upc.api.client.server.DefaultUPCServer;

/**
 * Created by H.CAAHN on 2017/7/5.
 */
public class UPCServerFactory {
    private volatile static UPCServer upcServer;
    
    public static UPCServer getUPCServer(UPCConfigure  configure) {
        if (upcServer == null) {
            synchronized (UPCServerFactory.class) {
                if (upcServer == null) {
                    upcServer = new DefaultUPCServer(configure);
                }
            }
        }
        
        return upcServer;
    }
}
