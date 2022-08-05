package com.charan.daikichipathvariables.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DaikichiPathControllers {
	
	@RequestMapping("/")
	public String index() {
		return "Welcome";
	}
	
	@RequestMapping("/daikichi/travel/{location}")
	public String destination(@PathVariable("location") String location) {
		return "Congratulations! You will soon travel to " + location + "!";
	}
	
	@RequestMapping("/daikichi/lotto/{value}")
	public String lottery(@PathVariable("value") Integer value) {
		if(value % 2 == 0) {
			return "You will take a grand journey in the near future, but be wary of tempting offers";
		} else {			
			return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends ";
		}
	}
}
