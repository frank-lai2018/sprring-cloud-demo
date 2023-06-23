package com.frank.springcloud.cfgbeans;
 
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
 
@Configuration
public class ConfigBean
{
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate()
    {
         return new RestTemplate();
    }
    
    //設置附載均衡機制算法
    @Bean
    public IRule myRule() {
//    	return new RandomRule();//達到的目的，用我們重新選擇的隨機算法替代默認的輪巡
    	return new RoundRobinRule();//達到的目的，用我們重新選擇的隨機算法替代默認的輪巡
    }
}

