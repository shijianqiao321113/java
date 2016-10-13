package com.maven.project.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserOperServices {
	
	/**
	* @Title: login 
	* @Description: 用户登录 
	* @author shi_jianqiao   
	* @date 2016年5月11日 下午4:10:36 
	* @param request
	* @param response
	* void
	 */
	public void login(HttpServletRequest request,HttpServletResponse response);
	
	public void aa(String str);
}
