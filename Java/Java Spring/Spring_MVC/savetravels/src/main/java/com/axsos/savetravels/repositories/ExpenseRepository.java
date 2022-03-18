package com.axsos.savetravels.repositories;
import org.springframework.stereotype.Repository;
import com.axsos.savetravels.models.Expense;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long> {
	List<Expense> findAll();
//	List<Expense> findByDescriptionContaining(String search);
	Optional<Expense> findById(long id);
	
	
}
