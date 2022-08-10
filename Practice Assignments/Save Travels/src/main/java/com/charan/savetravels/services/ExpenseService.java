package com.charan.savetravels.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.charan.savetravels.models.Expense;
import com.charan.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepo;
	
	public ExpenseService(ExpenseRepository expenseRepo) {
		this.expenseRepo = expenseRepo;
	}
	
	public List<Expense> allExpenses(){
		return expenseRepo.findAll();
	}
	
	public Expense createExpense(Expense expense) {
		return expenseRepo.save(expense);
	}
	
}
