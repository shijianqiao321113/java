package com.maven.project.services.imp;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.maven.project.services.UserOperServices;
import com.maven.project.tools.utils.OutPut;

@Service
public class UserOperServicesImp implements UserOperServices {
	
	@Override
	public void login(HttpServletRequest request, HttpServletResponse response) {
		
		JSONObject result=new JSONObject();
		result.put("resultCode","00000");
		result.put("resultContent","登录成功");
		
		OutPut.outJsonCode(response,result);
		return;
	}
	
	@Override
	public void for_10(){
		for(int i=0;i<10;i++){
			try { Thread.sleep(1000); } catch (InterruptedException e) { }
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		}
	}
}
