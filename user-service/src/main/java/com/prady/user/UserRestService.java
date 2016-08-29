package com.prady.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@EnableAutoConfiguration
@EnableDiscoveryClient
public class UserRestService {

	@Autowired
	private UserRepository repository;
	
	@RequestMapping(method=RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public User findUser(@RequestParam(value="lastName") String lastName) {
		List<User>  userList = repository.findByLastName(lastName);
		System.out.println( userList);
        return userList.get(0);
    }
//    public List<User> findUser(@RequestParam(value="lastName") String lastName) {
//		List<User>  userList = repository.findByLastName(lastName);
//		System.out.println( userList);
//        return userList;
//    }
}
