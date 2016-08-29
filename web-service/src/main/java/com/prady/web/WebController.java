package com.prady.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {
	
	@Autowired
	protected WebService userService;

	protected Logger logger = LoggerFactory.getLogger(WebService.class);

	public WebController(WebService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/user/")
    public String defaultPage(Model model) {
        model.addAttribute("user", new User());
        return "searchUser";
    }
	
	@RequestMapping(value="/user/search", method=RequestMethod.POST)
    public String searchSubmit(@ModelAttribute User user, Model model) {
		
        model.addAttribute("user", userService.findByLastName(user.getLastName()));
        return "searchUserResult";
    }

}
