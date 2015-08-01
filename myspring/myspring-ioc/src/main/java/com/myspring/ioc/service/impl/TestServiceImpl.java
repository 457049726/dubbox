package com.myspring.ioc.service.impl;

import com.myspring.ioc.service.TestService;

public class TestServiceImpl implements TestService {
	
	private String name;
	private int age;
	
	public void test(){
		System.out.println("test,name:"+name+",age:"+age+"..................");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
