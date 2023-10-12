package com.sabrine.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabrine.savetravels.models.Expense;
import com.sabrine.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	
	@Autowired
	private ExpenseRepository expenseRepo;
	
//	CRUD
//	Read all
	public List<Expense> findAll(){
		return expenseRepo.findAll();
	}

//	Create
	
	public Expense createExpense(Expense newExpense){
		return expenseRepo.save(newExpense);
	}
	
//	Read one
	
	public Expense findExpense(Long id){
		Optional<Expense> maybeExpense = expenseRepo.findById(id);
		if(maybeExpense.isPresent()) {
			return maybeExpense.get();
		}
		else {
			return null;
		}
	}
	
//	Update
	public Expense updateExpense(Expense newExpense) {
		return expenseRepo.save(newExpense);
	}
	
//	Delete
	public void deletExpense(Long id) {
		expenseRepo.deleteById(id);
	}
}
