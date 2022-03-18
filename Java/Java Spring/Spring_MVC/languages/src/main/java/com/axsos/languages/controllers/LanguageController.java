package com.axsos.languages.controllers;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.axsos.languages.models.Language;
import com.axsos.languages.services.LanguageService;

@Controller
public class LanguageController {

	private final LanguageService languageService;

	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}

	@RequestMapping("/languages")

	public String index(Model model, @ModelAttribute("language") Language language) {
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		return "index.jsp";
	}

	@PostMapping("/languages")
	public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if (result.hasErrors()) {
			return "/languages";
		} else {
			languageService.createLanguage(language);
			return "redirect:/languages";
		}
	}

	@RequestMapping("/languages/{id}")

	public String show(@PathVariable(value = "id") long id, Model model) {
		Language language = languageService.getLanguageById(id);
		model.addAttribute("language", language);
		return "language.jsp";
	}
	
	@RequestMapping("/languages/edit/{id}")
	public String edit(Model model, @PathVariable(value = "id") long id) {
		
		 Language language = languageService.getLanguageById(id);
		model.addAttribute("language", language);
		return "edit.jsp";
	}
	
	@PutMapping("/languages/edit/{id}")
	public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if (result.hasErrors()) {
			return "/languages/edit/{id}";
		} else {
			languageService.createLanguage(language);
			return "redirect:/languages";
		}
	}
	
	@DeleteMapping("/languages/{id}")
	public String delete(@PathVariable(value = "id") long id) {
		
			languageService.deleteLanguage(id);
			return "redirect:/languages";
		}
	
	}

	


