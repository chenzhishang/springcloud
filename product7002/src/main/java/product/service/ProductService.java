package product.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class ProductService {
    @Value("${server.port}")
    private  String serverPort;

  public String feignTest(){
    return "feign测试：我是生产者"+serverPort;
  }

  public String openFeignTest(){
    return "openFeign测试：我是生产者"+serverPort;
  }

  public String hystrixTest(){
    return "hystrix测试：我是生产者"+serverPort;
  }

  public String zuulTest(){
    return "zuul测试：我是生产者"+serverPort;
  }
    @HystrixCommand(fallbackMethod = "error")
    public String getMessage(){
        try {
            TimeUnit.SECONDS.sleep(4);//停顿
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "我是生产者"+serverPort;
    }

    public String error(){
        return "生产者"+serverPort+"服务繁忙!!!";
    }
}
