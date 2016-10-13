package com.maven.project.tools.utils;

import java.util.ArrayList;

public class UrlVerification {
	/**
     * 被忽略的url
     */
	public static ArrayList<String> urlList = new ArrayList<String>();
    
    static{
    	urlList.add("/index.jsp");
    	urlList.add("/user/login.json");
    	urlList.add("/user/jsonp.json");
    }
}
