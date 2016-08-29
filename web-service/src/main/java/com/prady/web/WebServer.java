package com.prady.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(useDefaultFilters=false)  // Disable component scanner
public class WebServer {
	public static final String USER_SERVICE_URL = "http://USER-SERVICE";

    public static void main(String[] args) {
        // Will configure using web-server.yml
        System.setProperty("spring.config.name", "web-server");
        SpringApplication.run(WebServer.class, args);
    }

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
    @Bean
	public WebService userService() {
		return new WebService(USER_SERVICE_URL);
	}
    
    @Bean
	public WebController userController() {
		return new WebController(userService());
	}

//    @Bean
//    public WebController accountsController() {
//         // 1. Value should not be hard-coded, just to keep things simple
//         //        in this example.
//         // 2. Case insensitive: could also use: http://accounts-service
//         return new WebController
//                       ("http://USER-SERVICE");  // serviceUrl
//    }
}