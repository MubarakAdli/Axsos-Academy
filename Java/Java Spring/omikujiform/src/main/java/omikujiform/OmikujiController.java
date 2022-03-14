package omikujiform;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OmikujiController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	
	public String submit(HttpSession session, @RequestParam(value="city") String city, @RequestParam(value="name") String name,
			@RequestParam(value="hoppy") String hoppy,@RequestParam(value="living") String living,
			@RequestParam(value="comment") String comment,@RequestParam(value="number") Integer number){
			session.setAttribute("city", city);
			session.setAttribute("name", name);
			session.setAttribute("hoppy", hoppy);
			session.setAttribute("living", living);
			session.setAttribute("comment", comment);
			session.setAttribute("number", number);
			
			
			return "redirect:/show";
		}
	
@RequestMapping("/show")
public String result(HttpSession session, Model model) {
	
	String city = (String) session.getAttribute("city");
	String person = (String) session.getAttribute("name");
	String hoppy = (String) session.getAttribute("hoppy");
	String living = (String) session.getAttribute("living");
	String comment = (String) session.getAttribute("comment");
	int number = (int) session.getAttribute("number");
	model.addAttribute("city", city);
	model.addAttribute("name", person);
	model.addAttribute("hoppy", hoppy);
	model.addAttribute("living", living);
	model.addAttribute("comment", comment);
	model.addAttribute("number", number);
	
	
	return "show.jsp";
}
}