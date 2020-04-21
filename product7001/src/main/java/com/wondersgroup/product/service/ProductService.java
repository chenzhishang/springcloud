package com.wondersgroup.product.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.concurrent.TimeUnit;

@Service
public class ProductService {
    @Value("${server.port}")
    private  String serverPort;

    public String eurekaTest(){
      return "eureka测试：我是生产者"+serverPort;
    }

    public String feignTest(){
      return "feign测试：我是生产者"+serverPort;
    }

    public String openFeignTest(){
      return "openFeign测试：我是生产者"+serverPort;
    }

    public String hystrixTest(){
      return "hystrix测试：我是生产者"+serverPort;
    }

    public String zuulTest(){
      return "zuul测试：我是生产者"+serverPort;
    }
    /**
     * 服务熔断配置默认类 com.netflix.hystrix.HystrixCommandProperties
     */
    @HystrixCommand(fallbackMethod = "error",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value="true"), //是否开启熔断
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="10"),//请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="20000"),//时间范围 20秒内失败率60%  10次中失败6次则服务熔断
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="60")//失败率 %
    })
    public String getMessage(){
        int age=10/0;
        try {
           TimeUnit.SECONDS.sleep(3);//停顿
       } catch (InterruptedException e) {
           e.printStackTrace();
        }
        return "我是生产者"+serverPort;
    }

    /**
     *   服务降级
     */
    public String error(){
        return "生产者"+serverPort+"服务繁忙!!!";
    }
}
