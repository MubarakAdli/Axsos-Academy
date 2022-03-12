package com.axsos.date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DisplayDate {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String displayDate(Model model) {
		
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy");
		String formattedDate = myDateObj.format(myFormatObj); 
		model.addAttribute("date", formattedDate);
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String displayTime(Model model) {
		LocalDateTime myDateObj = LocalDateTime.now(); 
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern(" HH:mm"); 
		String formattedDate = myDateObj.format(myFormatObj);
		model.addAttribute("time", formattedDate);
//		LocalDateTime myDateObj = LocalDateTime.now(); 
//		model.addAttribute("time", myDateObj);
		return "time.jsp";
	}
}
