package com.wechat_server.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController {

	@RequestMapping("/")
	public String  login() {
	return "login";	
	}
	
	@RequestMapping("/hello")
	public String  loginHtml() {
	return "login";	
	}
}
