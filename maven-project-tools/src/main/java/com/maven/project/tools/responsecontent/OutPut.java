package com.maven.project.tools.responsecontent;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;

public class OutPut {
	
	public static void outJsonCode(HttpServletResponse response,JSONObject result){
		try {
			response.setHeader("ContentType", "text/json;charset=UTF-8");
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			PrintWriter pw = response.getWriter();

			if(!StringUtils.isEmpty(result)){
				pw.write(result.toJSONString());
			}else {
				return ;
			}
			pw.flush();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
