package com.wondersgroup.consum.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wondersgroup.consum.service.ConsumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "error",commandProperties = {
        @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="10000")//超时配置
})
public class ConsumController {
    @Autowired
    private ConsumService consumService;

/*
    @GetMapping("/consum/getMessage")
    @HystrixCommand(fallbackMethod = "error",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")//超时配置
    })
    public String getMessage(){
        log.info("80消费者调用");
        return consumService.getMessage();
    }
*/

    @GetMapping("/consum/getMessage")
    @HystrixCommand
    public String getMessage(){
        log.info("80消费者调用");
        return consumService.getMessage();
    }

    public String error(){
        return "消费者服务繁忙!!!";
    }

}
