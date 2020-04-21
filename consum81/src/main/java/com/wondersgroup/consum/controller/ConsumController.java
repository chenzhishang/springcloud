package com.wondersgroup.consum.controller;

import com.wondersgroup.consum.service.ConsumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumController {
    @Autowired
    private ConsumService consumService;

    @GetMapping("/consum/getMessage")
    public String getMessage(){
        return consumService.getMessage();
    }
}
