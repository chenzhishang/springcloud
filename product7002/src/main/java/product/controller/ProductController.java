package product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import product.service.ProductService;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
public class ProductController {
    @Resource
    private ProductService productService;

    @GetMapping("eurekaTest")
    public String eurekaTest(){
        return productService.eurekaTest();
    }


    @GetMapping("getMessage")
    public String getMessage(){
//        try {
//            TimeUnit.SECONDS.sleep(5);//停顿
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return productService.getMessage();
    }
}
