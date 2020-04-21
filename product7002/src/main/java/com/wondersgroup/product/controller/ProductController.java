package com.wondersgroup.product.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wondersgroup.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/eureka")
    public String eureka() {
        return productService.eureka();
    }
    @GetMapping("/openFeign")
    public String openFeign() {
        return productService.openFeign();
    }

    @GetMapping("/hystrixDowngrade1")
    public String hystrixDowngrade1() {
        return productService.hystrixDowngrade1();
    }

    @GetMapping("/hystrixDowngrade2")
    public String hystrixDowngrade2() {
        return productService.hystrixDowngrade2();
    }

    @GetMapping("/hystrixFuse1")
    public String hystrixFuse1() {
        return productService.hystrixFuse1();
    }

    @GetMapping("/hystrixFuse2")
    public String hystrixFuse2() {
        return productService.hystrixFuse2();
    }


}
