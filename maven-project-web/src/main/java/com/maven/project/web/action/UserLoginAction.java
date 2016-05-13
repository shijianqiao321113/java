package com.maven.project.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maven.project.services.UserOperServices;

@Controller
@RequestMapping("/user")
public class UserLoginAction {

	@Autowired
	private UserOperServices userOperServices;
	
	/**
	* @Title: login 
	* @Description: 用户登录 
	* @author shi_jianqiao   
	* @date 2016年5月11日 下午4:07:50 
	* @param request
	* @param response
	* void
	 */
	@RequestMapping("/login")
	public void login(HttpServletRequest request,HttpServletResponse response){
		userOperServices.login(request, response);
	}
}
