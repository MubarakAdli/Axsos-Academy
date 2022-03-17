package com.axsos.savetravels.controllers;

import java.awt.print.Book;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.axsos.savetravels.models.Expense;
import com.axsos.savetravels.services.ExpenseService;

@Controller
public class ExpensesController {
	private final ExpenseService expenseService;
    public ExpensesController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }
    
    @RequestMapping("/expenses")
    public String index(Model model,@ModelAttribute("expense") Expense expense) {
    	List<Expense> expenses=expenseService.allExpenses();
    	model.addAttribute("expenses",expenses);
    	return "index.jsp";
    	
    }
    
    @RequestMapping(value="/expenses",method = RequestMethod.POST)
	public String create(Model model, @Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if (result.hasErrors()) {
			List<Expense> expenses = expenseService.allExpenses();
			model.addAttribute("expenses", expenses);
			return "index.jsp";
		} else {
			expenseService.createExpense(expense);
			return "redirect:/expenses";
		}
    
    }

}
