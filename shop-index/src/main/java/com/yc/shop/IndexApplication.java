package com.yc.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @program: shop-index
 * @description:
 * @author: 作者
 * @create: 2021-05-09 09:23
 */
@EnableEurekaClient
//注册服务客户端注解
@SpringBootApplication
//开启Feign远程房屋调用
@EnableFeignClients

//@EnableHystrix

public class IndexApplication {
    public static void main(String[] args) {
        SpringApplication.run(IndexApplication.class, args);

    }

    /**
     * jdbctemple
     * <p>
     * RestTemple  手动远程服务调用
     */
    @LoadBalanced//负载均衡
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
