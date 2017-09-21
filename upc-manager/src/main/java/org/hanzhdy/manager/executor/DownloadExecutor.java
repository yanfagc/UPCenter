package org.hanzhdy.manager.executor;


import org.hanzhdy.manager.executor.download.DownloadProcessThread;
import org.hanzhdy.manager.executor.download.PayInfoDownloadThread;
import org.hanzhdy.manager.pay.controller.params.PayInfoParams;
import org.hanzhdy.manager.support.constants.DownloadConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 处理下载
 * Created by H.CAAHN on 2017/6/27.
 */
public class DownloadExecutor {
    private ExecutorService cachedThreadPool;

    private static final Logger logger = LoggerFactory.getLogger(DownloadExecutor.class);

    public DownloadExecutor() {

    }

    public void init() {
        cachedThreadPool = new ThreadPoolExecutor(5, 10, 90, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
    }

    public void distory() {
        cachedThreadPool.shutdown();
    }

    public ThreadPoolExecutor addTask(Object params, String modeleType) {
        Runnable task;
        switch (modeleType) {
            case DownloadConstants.TYPE_PAY_ORDER_WX:
                task = new PayInfoDownloadThread((PayInfoParams) params);
                break;
            default:
                task = new DownloadProcessThread();
                break;
        }
       ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 90, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        executor.execute(task);
        return executor;
    }

    public void addTask(Runnable runnable) {
        cachedThreadPool.execute(runnable);
    }
}
