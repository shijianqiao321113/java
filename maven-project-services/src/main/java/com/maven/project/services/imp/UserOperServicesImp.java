package com.maven.project.services.imp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.maven.project.services.UserOperServices;
import com.maven.project.tools.utils.OutPut;

@Service
public class UserOperServicesImp implements UserOperServices {
	
	@Value("${jms_url}")
	private String url;

	public void login(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("=====================login================url"+url);
		
		JSONObject result=new JSONObject();
		result.put("resultCode","00000");
		result.put("resultContent","登录成功");
		
		OutPut.outJsonCode(response,result);
		return;
	}

	@Override
	public void aa(String str) {
		System.out.println("==============="+str);
		
	}

}
