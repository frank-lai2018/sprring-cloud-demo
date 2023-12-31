package com.frank.springcloud;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.frank.myrule.MySelfRule;

 
@SpringBootApplication(scanBasePackages= {"com.frank.springcloud"})
@EnableEurekaClient
@RibbonClient(name="microservicecloud-dept",configuration=MySelfRule.class)//name需要跟yml裡的spring.application.name 的名子大小寫一致
public class DeptConsumer80_App
{
  public static void main(String[] args)
  {
   SpringApplication.run(DeptConsumer80_App.class, args);
  }
}
 
 
 
