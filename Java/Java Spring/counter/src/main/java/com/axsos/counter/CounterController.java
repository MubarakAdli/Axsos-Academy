package com.axsos.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
@RequestMapping("/your_server")
public class CounterController {
	
	@RequestMapping("")
	public String index(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
			}
			else {
				Integer currentCount = (Integer) session.getAttribute("count");
				session.setAttribute("count", currentCount+1);
			}
        
		return "server1.jsp";
	}
	
	@RequestMapping("/2")
	public String server2(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
			}
			else {
				Integer currentCount = (Integer) session.getAttribute("count");
				session.setAttribute("count", currentCount+2);
			}
        
		return "server2.jsp";
	}
	
	@RequestMapping("/delete")
	public String deleteCount(HttpSession session, Model model) {
		session.setAttribute("count", 0);
		Integer currentCount = (Integer) session.getAttribute("count");
		model.addAttribute("countToShow", currentCount);
		return "counter.jsp";
	}
	
	@RequestMapping("/counter")
	public String showCount(HttpSession session, Model model) {
		Integer currentCount = (Integer) session.getAttribute("count");
		model.addAttribute("countToShow", currentCount);
		return "counter.jsp";
	}
	
	
}
