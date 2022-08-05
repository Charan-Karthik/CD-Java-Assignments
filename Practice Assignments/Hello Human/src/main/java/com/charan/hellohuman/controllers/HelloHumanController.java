package com.charan.hellohuman.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHumanController {
	
	@RequestMapping("/")
	public String hello(@RequestParam(value="name", required=false) String name,
			@RequestParam(value="last_name", required=false) String last_name,
			@RequestParam(value="times", required=false) Integer times) {
		if(times == null || times == 0) {
			if(name != null && last_name != null) {
				return "Hello " + name + " " + last_name;
			} else if(name !=null) {
				return "Hello " + name;
			} else {
				return "Hello Human";
			}
		} else {
			String greeting = "";
			for(int i=0; i<times; i++) {
				greeting += "Hello " + name + " ";
			}
			return greeting;
		}		
	}
}
