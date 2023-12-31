package com.frank.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.frank.springcloud.entities.Dept;
import com.frank.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class DeptController {
	@Autowired
	private DeptService service;

	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(@RequestBody Dept dept) {
		return service.add(dept);
	}

	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "processHystrix_Get")
	public Dept get(@PathVariable("id") Long id) {
		Dept dept = this.service.get(id);
		if (null == dept) {
			throw new RuntimeException("该ID：" + id + "沒有對應的信息");
		}
		return dept;
	}

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list() {
		return service.list();
	}

	private Dept processHystrix_Get(@PathVariable("id") Long id) {
		Dept dept = new Dept();
		dept.setDeptno(id);
		dept.setDname("该ID：" + id + "沒有對應的信息,null--@HystrixCommand");
		dept.setDb_source("no this database in MySQL");

		return dept;
	}

}
