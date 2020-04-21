package com.wondersgroup.consum.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value = "PRODUCT")
public interface ConsumService {
  @GetMapping("/eureka")
  public String eureka();

  @GetMapping("/openFeign")
  public String openFeign();

  @GetMapping("/hystrixDowngrade1")
  public String hystrixDowngrade1();

  @GetMapping("/hystrixDowngrade2")
  public String hystrixDowngrade2();

  @GetMapping("/hystrixFuse1")
  public String hystrixFuse1();

  @GetMapping("/hystrixFuse2")
  public String hystrixFuse2();


}
