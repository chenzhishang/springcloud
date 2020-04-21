package com.wondersgroup.consum.controller;

import com.wondersgroup.consum.service.ConsumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumController {
    @Autowired
    private ConsumService consumService;

    @GetMapping("/eureka")
    public String eureka() {
        return consumService.eureka();
    }
    @GetMapping("/openFeign")
    public String openFeign() {
        return consumService.openFeign();
    }

    @GetMapping("/hystrixDowngrade1")
    public String hystrixDowngrade1() {
        return consumService.hystrixDowngrade1();
    }

    @GetMapping("/hystrixDowngrade2")
    public String hystrixDowngrade2() {
        return consumService.hystrixDowngrade2();
    }

    @GetMapping("/hystrixFuse1")
    public String hystrixFuse1() {
        return consumService.hystrixFuse1();
    }

    @GetMapping("/hystrixFuse2")
    public String hystrixFuse2() {
        return consumService.hystrixFuse2();
    }


}
