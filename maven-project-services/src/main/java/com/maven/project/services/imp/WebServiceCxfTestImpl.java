package com.maven.project.services.imp;

import javax.jws.WebService;

import com.maven.project.services.WebServiceCxfTest;

@WebService(serviceName="WebServiceCxfTestImpl",endpointInterface="com.maven.project.services.WebServiceCxfTest")
public class WebServiceCxfTestImpl implements WebServiceCxfTest {

	@Override
	public String abc(String aa, String bb) {
		return Math.random()+"_"+aa+"_"+bb;
	}

}
