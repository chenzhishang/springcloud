package com.wondersgroup.product.controller;

import com.wondersgroup.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("getMessage")
    public String getMessage(){
//        try {
//            TimeUnit.SECONDS.sleep(3);//停顿
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return productService.getMessage();
    }
}
