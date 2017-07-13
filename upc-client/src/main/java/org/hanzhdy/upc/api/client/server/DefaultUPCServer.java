package org.hanzhdy.upc.api.client.server;

import org.hanzhdy.upc.api.client.UPCServer;
import org.hanzhdy.upc.api.client.bean.UPCConfigure;

/**
 * 默认的UPCServer
 * Created by H.CAAHN on 2017/7/5.
 */
public class DefaultUPCServer implements UPCServer {
    private UPCConfigure configure;
    
    public DefaultUPCServer(UPCConfigure configure) {
        this.configure = configure;
    }
    
    public void doSignin(String account, String password, String ip) {
    
    }
}
