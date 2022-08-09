package com.charan.ninjagold.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GoldController {
	
	@RequestMapping("/")
	public String gold(HttpSession session, Model model) {
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
			ArrayList<String> activities = new ArrayList<String>();
			session.setAttribute("activities", activities);
		}
		
		Integer currentGold = (Integer) session.getAttribute("gold");
		model.addAttribute("gold", currentGold);
		
		return "gold.jsp";
	}
	
	@RequestMapping("/activities")
	public String activities(HttpSession session) {
		@SuppressWarnings("unchecked")
		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
		
		return "activities.jsp";
	}
	
	@RequestMapping("/changegold")
	public String changeGold(HttpSession session, 
			Model model,
			@RequestParam(value="farmButton", required=false) String farm,
			@RequestParam(value="caveButton", required=false) String cave,
			@RequestParam(value="houseButton", required=false) String house,
			@RequestParam(value="questButton", required=false) String quest,
			@RequestParam(value="spaButton", required=false) String spa,
			@RequestParam(value="resetButton", required=false) String reset,
			@RequestParam(value="playAgainButton", required=false) String playAgain
			) {
		SimpleDateFormat formatDate = new SimpleDateFormat("MMMM d Y h:mm a");
		
		@SuppressWarnings("unchecked")
		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
		Integer currentGold = (Integer) session.getAttribute("gold");
		Random randomMethods = new Random();
		int randomAmount = 0;
		
		if(farm != null) {
			randomAmount += randomMethods.nextInt(11) + 10;
			currentGold += randomAmount;
			activities.add("<p class='px-4 text-success'>You did some farming and earned " + randomAmount + " gold." + " (" + formatDate.format(new Date()) + ")</p>");
		} else if(cave != null) {
			randomAmount += randomMethods.nextInt(6) + 5;
			currentGold += randomAmount;
			activities.add("<p class='px-4 text-success'>You found " + randomAmount + " gold in a cave." + " (" + formatDate.format(new Date()) + ")</p>");
		} else if(house != null) {
			randomAmount += randomMethods.nextInt(4) + 2;
			currentGold += randomAmount;
			activities.add("<p class='px-4 text-success'>You found " + randomAmount + " gold in your house." + " (" + formatDate.format(new Date()) + ")</p>");
		} else if(quest != null) {
			randomAmount += randomMethods.nextInt(51);
			int randomNumber = randomMethods.nextInt(2);
			
			if(randomNumber == 0) {
				currentGold += randomAmount;
				activities.add("<p class='px-4 text-success'>You bravely conquered your quest and earned " + randomAmount + " gold." + " (" + formatDate.format(new Date()) + ")</p>");
			} else {
				currentGold -= randomAmount;	
				activities.add("<p class='px-4 text-danger'>Your quest didn't go so well and you lost " + randomAmount + " gold." + " (" + formatDate.format(new Date()) + ")</p>");
			}
		} else if(spa != null) {
			randomAmount += randomMethods.nextInt(16) + 5;
			currentGold -= randomAmount;
			activities.add("<p class='px-4 text-danger'>You took a day off and spent " + randomAmount + " gold at the spa." + " (" + formatDate.format(new Date()) + ")</p>");
		} else if(reset != null) {
			currentGold = 0;
			activities.clear();
		} else if(playAgain != null) {
			currentGold = 0;
			activities.clear();
		}
		
		session.setAttribute("gold", currentGold);
		if(currentGold < -100) {
			return "jail.jsp";
		}
		
//		System.out.println(activities);
		return "redirect:/";
	}
	
}
