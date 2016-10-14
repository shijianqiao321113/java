package com.maven.project.services.imp;

import org.springframework.stereotype.Service;

import com.maven.project.services.WebServiceAxisTest;

@Service("webServiceAxisTestImp")
public class WebServiceAxisTestImp implements WebServiceAxisTest {

	@Override
	public String Test(String aa, String bb) {
		return Math.random()+"_"+aa+"_"+bb;
	}

	@Override
	public String getXml(String param) {
		return "xml";
	}

}
