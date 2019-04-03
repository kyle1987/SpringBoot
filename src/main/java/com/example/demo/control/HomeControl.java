package com.example.demo.control;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;

@RestController
public class HomeControl {
	
	@RequestMapping("/hello")
	public User home(@RequestBody User user) {
		System.out.println(user.getUserName()+"~~~~~~``");
		System.out.println(user.getPassword()+"~~~~~~``");
		System.out.println(user.getBirthday()+"~~~~~~``");
		return user;
	}
	
	@RequestMapping("/hello2")
	public String home2(User user) {
		System.out.println("hello2..........");
		System.out.println(user.getUserName()+"~~~~~~``");
		System.out.println(user.getPassword()+"~~~~~~``");
		System.out.println(user.getBirthday()+"~~~~~~``");
		return "hello world";
	}
}
