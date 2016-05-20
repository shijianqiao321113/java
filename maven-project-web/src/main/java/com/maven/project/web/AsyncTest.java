package com.maven.project.web;

import javax.annotation.PostConstruct;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;

@Controller
public class AsyncTest{
	
	@PostConstruct
	public void init(){
		System.out.println("==========PostConstruct========");
	}
	
	@Async
	public void initAsync(){
		while(true){
			try {Thread.sleep(10*1000);} catch (Exception e) {}
			System.out.println("**********************");
		}
	}
}
