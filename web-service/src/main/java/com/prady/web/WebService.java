package com.prady.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.client.RestTemplate;

public class WebService {
	
	@Autowired
	@LoadBalanced
	protected RestTemplate restTemplate;

	protected String serviceUrl;

	protected Logger logger = LoggerFactory.getLogger(WebService.class.getName());

	public WebService(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}
	
	
  public User findByLastName(String lastName){
	  
	  User user = restTemplate.getForObject(serviceUrl + "/user?lastName={lastName}",
				User.class, lastName);
	 
	  return user;

  }
}
