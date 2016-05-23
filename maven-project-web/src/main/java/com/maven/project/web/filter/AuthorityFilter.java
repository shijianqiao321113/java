package com.maven.project.web.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.maven.project.tools.utils.UrlVerification;

public class AuthorityFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		
		//获取请求地址
        String url = req.getServletPath();
        System.out.println("===========url==========="+url);
        
        @SuppressWarnings("unchecked")
		Map<String, String[]> map=req.getParameterMap();
        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            System.out.println("请求参数===========" + entry.getKey() + " = " + entry.getValue()[0]);
        }
        
        if(UrlVerification.urlList.contains(url)){
        	chain.doFilter(request, response);
			return ;
        }
        
        HttpSession session = req.getSession();
		if(session != null && session.getAttribute("userAccountInfos") != null){
			chain.doFilter(request, response);
			return ;
		}
        
        res.sendRedirect(req.getContextPath()+"/index.jsp");
        return ;
	}

	public void destroy() { }
}
