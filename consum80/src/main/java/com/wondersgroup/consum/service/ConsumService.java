package com.wondersgroup.consum.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;


@Component
@FeignClient(value = "PRODUCT",fallback = ConsumServiceImpl.class)
public interface ConsumService {
    @GetMapping("/getMessage")
    public String getMessage();
}
