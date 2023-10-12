package com.sabrine.savetravels.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.service.annotation.PutExchange;

import com.sabrine.savetravels.models.Expense;
import com.sabrine.savetravels.services.ExpenseService;

import jakarta.validation.Valid;

@Controller
public class ExpenseController {
@Autowired
private ExpenseService expenseService;

@GetMapping("/expenses")
public String allExpense(Model model, @ModelAttribute("expense") Expense expense) {
	List<Expense> allExpense = expenseService.findAll();
	model.addAttribute("listOfExpenses", allExpense);
//	Expense expense = new Expense();
//	model.addAttribute("book", book);
	return "index.jsp";
}

@PostMapping("/expenses")
public String createExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
if (result.hasErrors()) {
	List<Expense> allExpense = expenseService.findAll();
	model.addAttribute("listOfExpenses", allExpense);
	return "index.jsp";
}
else {
	expenseService.createExpense(expense);
	return "redirect:/expenses";
}
}
@GetMapping("/expenses/edit/{id}")
public String editExpense(@PathVariable("id") Long id, Model model) {
	Expense thisExpense=expenseService.findExpense(id);
	model.addAttribute("expense", thisExpense);
	
	return"edit.jsp";
}
@PutMapping("/expenses/edit/{id}")
public String updateExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
	if (result.hasErrors()) {
		return "edit.jsp";
	}
	else {
		expenseService.updateExpense(expense);
	return "redirect:/expenses";
	}
}
@GetMapping("/expenses/{id}")
public String showOneExpense(@PathVariable("id") Long id, Model model ) {
	Expense thisExpense=expenseService.findExpense(id);
	model.addAttribute("expense", thisExpense);
	return"showOne.jsp";
}

@DeleteMapping("/expenses/{id}")
public String deleteExpense(@PathVariable("id") Long id) {
	expenseService.deletExpense(id);
	return "redirect:/expenses";
}
}
