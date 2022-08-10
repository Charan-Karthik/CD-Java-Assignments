package com.charan.savetravels.services;

import java.util.List;
import java.util.Optional;

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
	
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepo.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		} else {
			return null;
		}
	}
	
	public void deleteExpense(Long id) {
		expenseRepo.deleteById(id);
	}
	
	public Expense editExpense(Expense expense) {
		return expenseRepo.save(expense);
	}
}
