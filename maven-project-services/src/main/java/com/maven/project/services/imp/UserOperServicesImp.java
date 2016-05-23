package com.maven.project.services.imp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.maven.project.services.UserOperServices;
import com.maven.project.tools.utils.OutPut;

@Service
public class UserOperServicesImp implements UserOperServices {

	public void login(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("=====================login================");
		
		JSONObject result=new JSONObject();
		result.put("resultCode","00000");
		result.put("resultContent","登录成功");
		
		OutPut.outJsonCode(response,result);
		return;
	}

}
