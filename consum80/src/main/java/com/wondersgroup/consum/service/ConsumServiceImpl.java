package com.wondersgroup.consum.service;

import org.springframework.stereotype.Component;


@Component
public class ConsumServiceImpl implements ConsumService{
    @Override
    public String getMessage() {
        return "全局处理";
    }
}
