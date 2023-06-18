package com.frank.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // Eureka Server服務器端啟動類,接收其他微服務註冊進來
public class EurekaServer7003_App {
	public static void main(String[] args) {
		SpringApplication.run(EurekaServer7003_App.class, args);
	}
}
