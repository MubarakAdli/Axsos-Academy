package com.axsos.dojosninjas.conroller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.axsos.dojosninjas.models.Dojo;
import com.axsos.dojosninjas.models.Ninja;
import com.axsos.dojosninjas.services.DojoService;
import com.axsos.dojosninjas.services.NinjaService;

@Controller
public class MainController {
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	public MainController(DojoService dojoService, NinjaService ninjaService) {
		this.ninjaService=ninjaService;
		this.dojoService=dojoService;
	}
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "dojo.jsp";
	}
	@PostMapping("/dojos/new")
	public String createDojo(@ModelAttribute("dojo")Dojo dojo) {
		dojoService.createDojo(dojo);
		return "redirect:/dojos/new";
	}
	
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja")Ninja ninja, Model model) {
		List<Dojo> allDojos = dojoService.getAllDojos();
		model.addAttribute("dojos", allDojos);
		return "ninja.jsp";
	}
	
	@PostMapping(value="/ninjas/new")
	public String createNinja(@ModelAttribute("ninja")Ninja ninja) {
		ninjaService.create(ninja);
		return "redirect:/ninjas/new";
	}
	@GetMapping("dojos/{id}")
	public String findAll(Model model,@PathVariable("id")Long id) {
		Dojo ninjaForDojo = dojoService.findDojoById(id);
		model.addAttribute("dojo",ninjaForDojo);
		model.addAttribute("ninjas", ninjaForDojo.getNinjas());
		return "allninjas.jsp";
	}
}
