package com.frank.springcloud;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;

import com.frank.myrule.MySelfRule;


 
@SpringBootApplication(scanBasePackages= {"com.frank.springcloud"})
@EnableEurekaClient
@EnableFeignClients(basePackages= {"com.frank.springcloud"})
@ComponentScan("com.frank.springcloud")
@RibbonClient(name="microservicecloud-dept",configuration=MySelfRule.class)//name需要跟yml裡的spring.application.name 的名子大小寫一致
public class DeptConsumer80_Feign_App
{
  public static void main(String[] args)
  {
   SpringApplication.run(DeptConsumer80_Feign_App.class, args);
  }
}
 
 
 
