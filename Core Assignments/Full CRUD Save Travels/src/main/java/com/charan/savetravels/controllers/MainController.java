package com.charan.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.charan.savetravels.models.Expense;
import com.charan.savetravels.services.ExpenseService;

@Controller
public class MainController {
	
	@Autowired
	ExpenseService expenseService;
	
	@GetMapping("/")
	public String index(@ModelAttribute("expense") Expense expense, Model model) {
		
		List<Expense> expenses = expenseService.allExpenses();
		model.addAttribute("expenses", expenses);
		
		return "index.jsp";
	}
	
	@PostMapping("/expenses")
	public String addExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Expense> expenses = expenseService.allExpenses();
			model.addAttribute("expenses", expenses);
			return "index.jsp";
		} else {
			expenseService.createExpense(expense);
			return "redirect:/";
		}
	}
	
	@GetMapping("/expense/{id}")
	public String showExpense(@PathVariable("id") Long id, Model model) {
		Expense thisExpense = expenseService.findExpense(id);
		model.addAttribute("expense", thisExpense);
		
		return "show.jsp";
	}
	
	@GetMapping("/expenses/edit/{id}")
	public String editExpense(@PathVariable("id") Long id, Model model) {
		
		Expense thisExpense = expenseService.findExpense(id);
		model.addAttribute("expense", thisExpense);
		
		return "edit.jsp";
	}
	
	@PostMapping("/change/{id}")
	public String edit(@PathVariable("id") Long id, @Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Expense> expenses = expenseService.allExpenses();
			model.addAttribute("expenses", expenses);
			return "edit.jsp";
		} else {
			expenseService.editExpense(expense);
			return "redirect:/";
		}
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		Expense thisExpense = expenseService.findExpense(id);
//		System.out.println(thisExpense);
		Long idToDelete = thisExpense.getId();
//		System.out.println(idToDelete);
	
		expenseService.deleteExpense(idToDelete);	
		return "redirect:/";
	}
	
}
