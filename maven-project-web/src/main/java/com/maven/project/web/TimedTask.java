package com.maven.project.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
public class TimedTask {
	
	@Value("${jms_url}")
	private String url ;

	/** 每分钟执行一次 */
	@Scheduled(cron = "0 0/1 * * * ?")
	public void task(){
		System.out.println("=====@Scheduled(cron = \"0 0/1 * * * ?\")======="+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}
	
	/** 每10秒执行一次，，，系统启动后隔10秒执行第一次*/
	@Scheduled(fixedDelay=10000)
	public void t2(){
		System.out.println("====@Scheduled(fixedDelay=10000)========"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		System.out.println(this.url);
	}
	
	/** 延迟2秒，每10秒执行一次,,系统启动2秒后，就执行第一次*/
	@Scheduled(initialDelay=2000, fixedRate=10000)
	public void t3(){
		System.out.println("====@Scheduled(initialDelay=2000, fixedRate=10000)========"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}
}
