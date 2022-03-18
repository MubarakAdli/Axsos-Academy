package com.axsos.languages.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.axsos.languages.models.Language;

public interface LanguageRepository extends CrudRepository<Language, Long> {
	List<Language>findAll();
	Optional<Language> findById(long id);
//	
//    // this method counts how many titles contain a certain string
//    Long countByTitleContaining(String search);
//    
    // this method deletes a book that starts with a specific title
//    Long deleteByTitleStartingWith(String search);

}
