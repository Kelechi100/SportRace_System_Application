package lv.venta.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.Service.ISportCRUDService;
import lv.venta.model.Race;
import lv.venta.model.Runner;
import lv.venta.model.Team;


@Controller
@RequestMapping("/sport")
public class SportController {
	@Autowired
	private ISportCRUDService  sportService;
	
	
	
	@GetMapping("/runner/points")
	public String getRunnerswithmorethan100Points( Model model) {
		try
		{
			 ArrayList<Team> sports= sportService.getAllTeamwithPointMorethan100(100);
			 model.addAttribute("mypackage", sports);
			 return "show-all-grades"; 
		}
		catch(Exception e) {
			
		model.addAttribute("mypackage", e.getMessage());
		return "error-page"; // this will show error-page.html page with exception message
		
		// TOOD : Handle Exception
	}
		

		 
	}
	
	
	
	@GetMapping("/runner/points")
	public String getRaceswithcountlessthan30000( Model model) {
		try
		{
			 ArrayList<Race> sports= sportService.getAllRaceswithMaxCount(30000);
			 model.addAttribute("mypackage", sports);
			 return "show-all-grades"; 
		}
		catch(Exception e) {
			
		model.addAttribute("mypackage", e.getMessage());
		return "error-page"; // this will show error-page.html page with exception message
		
		// TOOD : Handle Exception
	}
		

		 
	}
	
	public String getRunnersInAteam( Model model) {
		try
		{
			 ArrayList<Runner> sports= sportService.getAllRunnerInATeam();
			 model.addAttribute("mypackage", sports);
			 return "show-all-grades"; 
		}
		catch(Exception e) {
			
		model.addAttribute("mypackage", e.getMessage());
		return "error-page"; // this will show error-page.html page with exception message
		
		// TOOD : Handle Exception
	}
		

		 
	}
	
	

}
