package com.axsos.ninjagold;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GoldController {
	
	LocalDateTime myDateObj = LocalDateTime.now();    
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");  
    
    String formattedDate = myDateObj.format(myFormatObj);  
     ArrayList<String> activities= new ArrayList<String>();
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("gold")== null) {
			session.setAttribute("gold", 0);
			session.setAttribute("activities", activities);
		}
		return "index.jsp";
}
	@RequestMapping(value="/process_money", method=RequestMethod.POST)
	public String findGold(HttpSession session, @RequestParam(value="which_form") String place) {
			if(place.equals("farm")) {

				 Random random = new Random();
				 Integer value = 10 + random.nextInt(20);
				Integer myGold = (Integer) session.getAttribute("gold");
				session.setAttribute("gold", myGold+value);
				String farmResult="You entered the farm and earned "+ (value)+"  "+ "gold"+" "+(formattedDate);
				activities.add(farmResult);
				return "redirect:/";
			}
			else if(place.equals("cave")) {

				Random randomCave = new Random();
				 Integer cave = 10 + randomCave.nextInt(20);
				 Integer caveGold = (Integer) session.getAttribute("gold");
				
				
				
				session.setAttribute("gold", caveGold+cave);
				String caveResult="You entered the cave and earned "+ (cave)+"  "+ "gold"+" "+(formattedDate);
				activities.add(caveResult);
				
			}
			else if(place.equals("house")) {

				Random randomHouse = new Random();
				 Integer cave = 10 + randomHouse.nextInt(20);
				 Integer houseGold = (Integer) session.getAttribute("gold");
				session.setAttribute("gold", houseGold+cave);
				String houseResult="You entered the house and earned "+ (houseGold)+"  "+ "gold"+" "+(formattedDate);
				activities.add(houseResult);
				
				
			}
			else {

				Random randomCasino = new Random();
				Integer low=-50;
				Integer high=50;
				 Integer casino = randomCasino.nextInt(high-low)+low;
				 Integer casinoGold = (Integer) session.getAttribute("gold");
				session.setAttribute("gold", casinoGold+casino);
				if(casino<0) {
					String casinoResult="You failed quest  and lost "+ (casino)+" " +"gold.Ouch"+" "+(formattedDate);
					activities.add(casinoResult);
				}
				else {
				String casinoResult="You entered the casino and earned "+ (casino)+"  "+ "gold"+" "+(formattedDate);
				activities.add(casinoResult);
			}
			
	}
	
			return "redirect:/";
}
}


	
