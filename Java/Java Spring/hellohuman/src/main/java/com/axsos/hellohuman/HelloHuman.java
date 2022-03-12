package com.axsos.hellohuman;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloHuman {
	@RequestMapping("/")
	public String human(@RequestParam(value="q",required=false) String query) {
		if (query==null) {
			return "Hello Human";
		}
		else {
			return "Hello "+ query;
		}
		
	}
}
	


