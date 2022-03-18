package com.axsos.savetravels.controllers;

import java.awt.print.Book;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
    
    @GetMapping("/expenses/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Expense expenses = expenseService.getExpenseById(id);
		model.addAttribute("expense", expenses);
		return "edit.jsp";
	}
    
//    @RequestMapping(value="/expense/update", method=RequestMethod.PUT)
//	public String update(@Valid @ModelAttribute("expense") Expense expense,
//			BindingResult result) {
//		if (result.hasErrors()) {
//			return "/expenses/edit.jsp";
//		} else {
//			expenseService.updateExpense(expense);
//			return "redirect:/expenses";
//		}
//
//	}
    
    @GetMapping("/expenses/{id}")
   	public String show(@PathVariable(value = "id") long id,Model model){
    	Expense expense = expenseService.getExpenseById(id);
    	model.addAttribute("expense", expense);
   			
   			return "expensedet.jsp";
   		}
    
    @DeleteMapping("/expenses/delete/{id}")
	public String delete(@PathVariable(value = "id") long id){
			
			expenseService.deleteById(id);
			return "redirect:/expenses";
		}

	}



