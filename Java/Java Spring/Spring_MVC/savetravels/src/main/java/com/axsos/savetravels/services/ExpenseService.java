package com.axsos.savetravels.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.boot.autoconfigure.security.ConditionalOnDefaultWebSecurity;
import org.springframework.stereotype.Service;

import com.axsos.savetravels.models.Expense;
import com.axsos.savetravels.repositories.ExpenseRepository;
@Service
public class ExpenseService {
private final ExpenseRepository expenseRepository;
    
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }
    
    public List<Expense> allExpenses() {
        return expenseRepository.findAll();
    }
    // creates a expense
    public Expense createExpense(Expense b) {
        return expenseRepository.save(b);
    }
    // retrieves a expense
    public Expense getExpenseById(long id) {
		Optional<Expense> lanOptional = expenseRepository.findById(id);
		return lanOptional.orElse(null);
    }
    
//    public Expense updateExpense(long id , String name , String vendor,double amount,String descreption) {
//    	
//		Expense expense=getExpenseById(id);
//		if (expense != null) {
//			expense.setName(name);
//			expense.setAmount(amount);
//			expense.setDescription(descreption);
//			expense.setVendor(vendor);
//			expenseRepository.save(expense);
//			
//			return expense;
//		}else {
//			return null;
//		}
//		
//    }
    
    public void deleteById(long id) {
    	expenseRepository.deleteById(id);
    }

	
	

}
