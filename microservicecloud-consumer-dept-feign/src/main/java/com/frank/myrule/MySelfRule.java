package com.frank.myrule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;

@Configuration
public class MySelfRule  {
    @Bean
    public IRule myRule() {
//    	return new RandomRule();//達到的目的，用我們重新選擇的隨機算法替代默認的輪巡
    	return new RandomRule_FR();//達到的目的，用我們重新選擇的隨機算法替代默認的輪巡
    }

}
