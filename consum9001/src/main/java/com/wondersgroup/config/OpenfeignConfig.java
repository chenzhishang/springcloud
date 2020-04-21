package com.wondersgroup.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenfeignConfig {
    /**
     * openFeign 负载均衡规则
     * @return
     */
    @Bean
    public IRule getIRule(){
        return new RandomRule();
    }

}
