package com.charan.displaydate.controllers;

import java.util.Date;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class DisplayDateController {
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String datePage(Model model) {
		Date date = new Date();
		
		SimpleDateFormat formatDay = new SimpleDateFormat("EEEE");
		SimpleDateFormat formatDate = new SimpleDateFormat("d");
		SimpleDateFormat formatMonth = new SimpleDateFormat("MMMM");
		SimpleDateFormat formatYear = new SimpleDateFormat("Y");
		
		String formattedDay = formatDay.format(date);
		String formattedDate = formatDate.format(date);
		if(formattedDate.length() > 1) {
			if(formattedDate.charAt(1) == '1') {
				formattedDate += "st";
			} else if(formattedDate.charAt(1) == '2') {
				formattedDate += "nd";
			} else if(formattedDate.charAt(1) == '3') {
				formattedDate += "rd";
			} else {
				formattedDate += "th";
			}
		} else {
			if(formattedDate.charAt(0) == '1') {
				formattedDate += "st";
			} else if(formattedDate.charAt(0) == '2') {
				formattedDate += "nd";
			} else if(formattedDate.charAt(0) == '3') {
				formattedDate += "rd";
			} else {
				formattedDate += "th";
			}
		}
		String formattedMonth = formatMonth.format(date);
		String formattedYear = formatYear.format(date);
		
		
		String displayString = formattedDay + ", " + formattedDate + " of " + formattedMonth + ", " + formattedYear;
		
		model.addAttribute("displayString", displayString);
		
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String timePage(Model model) {
		SimpleDateFormat formattedTime = new SimpleDateFormat("h:mm a");
		Date date = new Date();
		
		String time = formattedTime.format(date);
		model.addAttribute("time", time);
		
		return "time.jsp";
	}
}
