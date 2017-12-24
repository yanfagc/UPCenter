package org.hanzhdy.proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by H.CAAHN on 2017/12/14.
 */
@SpringBootApplication
//@ServletComponentScan
public class UserProxyApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserProxyApplication.class, args);
    }
}
