package com.axsos.authentication.LoginReg.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.axsos.authentication.LoginReg.models.LoginUser;
import com.axsos.authentication.LoginReg.models.User;
import com.axsos.authentication.LoginReg.services.UserService;



@Controller
public class HomeController {
@Autowired
private UserService userServ;
@GetMapping("/")
public String index(Model model) {
model.addAttribute("newUser", new User());
model.addAttribute("newLogin", new LoginUser());
return "show.jsp";
}
@PostMapping("/register")
public String register(@Valid @ModelAttribute("newUser") User newUser,
BindingResult result, Model model, HttpSession session) {
userServ.register(newUser, result);
if(result.hasErrors()) {
model.addAttribute("newLogin", new LoginUser());
return "show.jsp";
}
session.setAttribute("user_id", newUser.getId());
return "home.jsp";
}
@PostMapping("/login")
public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin,
BindingResult result, Model model, HttpSession session) {
User user = userServ.login(newLogin, result);
if(result.hasErrors()) {
model.addAttribute("newUser", new User());
return "show.jsp";
}
session.setAttribute("user_id", user.getId());
return "home.jsp";
}

@RequestMapping("/logout")
public String logout(HttpSession session) {
    
	session.invalidate();
	return "redirect:/";
}
}
