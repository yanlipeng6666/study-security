package com.itheima.distributed.security.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Program Name: distributed‐security
 * Created by yanlp on 2021-01-11
 *
 * @author yanlp
 * @version 1.0
 */
@EnableEurekaServer
@SpringBootApplication
public class DiscoveryServer {
    public static void main(String[] args) {
        SpringApplication.run(DiscoveryServer.class, args);
    }
}
