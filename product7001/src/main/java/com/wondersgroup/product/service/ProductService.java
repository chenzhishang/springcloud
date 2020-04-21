package com.wondersgroup.product.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class ProductService {

  @Value("${server.port}")
  private String serverPort;

  public String eureka() {
    return "eureka测试:" + serverPort + "服务调用成功!!!";
  }

  public String openFeign() {
    return "openFeign测试：" + serverPort + "服务调用成功!!!";
  }

  @HystrixCommand(fallbackMethod = "hystrixFallbackMethod")
  public String hystrixDowngrade1() {
    int age = 10 / 0;
    return "hystrix降级测试:" + serverPort + "服务调用成功!!!";
  }

  @HystrixCommand(fallbackMethod = "hystrixFallbackMethod")
  public String hystrixDowngrade2() {
    try {
      TimeUnit.SECONDS.sleep(3);//停顿
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "hystrix降级测试:" + serverPort + "服务调用成功!!!";
  }

  /**
   * 服务熔断配置默认类 com.netflix.hystrix.HystrixCommandProperties
   */
  @HystrixCommand(fallbackMethod = "hystrixFallbackMethod", commandProperties = {
          @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //是否开启熔断
          @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//请求次数
          @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "20000"),//时间范围 20秒内失败率60%  10次中失败6次则服务熔断
          @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")//失败率 %
  })
  public String hystrixFuse1() {
    return "hystrix熔断测试" + serverPort + "服务调用成功!!!";
  }

  /**
   * 服务熔断配置默认类 com.netflix.hystrix.HystrixCommandProperties
   */
  @HystrixCommand(fallbackMethod = "hystrixFallbackMethod", commandProperties = {
          @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //是否开启熔断
          @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//请求次数
          @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "20000"),//时间范围 20秒内失败率60%  10次中失败6次则服务熔断
          @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")//失败率 %
  })
  public String hystrixFuse2() {
    return "hystrix熔断测试" + serverPort + "服务调用成功!!!";
  }

  /**
   * 服务降级方法
   */
  public String hystrixFallbackMethod() {
    return serverPort + ":hystrix降级 服务繁忙!!!";
  }


}
