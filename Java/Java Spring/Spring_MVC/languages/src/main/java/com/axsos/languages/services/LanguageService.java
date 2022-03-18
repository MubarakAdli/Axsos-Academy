package com.axsos.languages.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.languages.models.Language;
import com.axsos.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository languageRepository;

	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	public List<Language> allLanguages() {
		return languageRepository.findAll();
	}
	
	public Language createLanguage(Language newLanguage) {
		return languageRepository.save(newLanguage);
	}
	
	public Language getLanguageById(long id) {
		Optional<Language> lanOptional = languageRepository.findById(id);
		return lanOptional.orElse(null);
				
	}
	public void deleteLanguage(long id) {
		languageRepository.deleteById(id);
	}
}
