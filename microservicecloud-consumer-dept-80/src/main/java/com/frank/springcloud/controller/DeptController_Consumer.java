package com.frank.springcloud.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.frank.springcloud.entities.Dept;
 
 
@RestController
public class DeptController_Consumer
{
//    private static final String REST_URL_PREFIX = "http://localhost:8001";
	
	private static final String REST_URL_PREFIX = "http://microservicecloud-dept";

    
    /**
     * 
     * 使用restTemplate訪問restful接口非常的簡單粗暴無腦。
		(url, requestMap, ResponseBean.class)這三個參數分別代表 
		REST請求地址、請求參數、HTTP響應轉換被轉換成的對像類型。
     * */
    
    @Autowired
    private RestTemplate restTemplate;
    
    @RequestMapping(value="/consumer/dept/add")
    public boolean add(Dept dept)
    {
         return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add", dept, Boolean.class);
    }
    
    @RequestMapping(value="/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id)
    {
         return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id, Dept.class);
    }
    
    @SuppressWarnings("unchecked")
    @RequestMapping(value="/consumer/dept/list")
    public List<Dept> list()
    {
         return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list", List.class);
    }   
}
 

 

