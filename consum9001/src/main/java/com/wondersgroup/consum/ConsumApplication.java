package com.wondersgroup.consum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient//注册到注册中心
@EnableFeignClients//开启feign
@RibbonClient(name = "PRODUCT",configuration = com.wondersgroup.config.OpenfeignConfig.class)//自定义负载均衡
@EnableCircuitBreaker//熔断 降级开启注解
public class ConsumApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumApplication.class,args);
    }
}
