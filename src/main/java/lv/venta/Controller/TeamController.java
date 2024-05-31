package lv.venta.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import lv.venta.Service.IFilteringService;
import lv.venta.model.Team;



@Controller

	

@RequestMapping("/team")
public class TeamController {
	

		@Autowired
		private IFilteringService  teamCRUDservice;
		
		@GetMapping("/all") // localhost:8080/team/crud/all
		public String getTeamCrudAll(Model model) { // using model to transfer file from java to html
			try
			{
				ArrayList<Team> result = teamCRUDservice. retrieveAll();
				model.addAttribute("mypackage", result);
				return "show-all-Team-page"; // this will show show-all-Team-page.html on the browser
			}
			catch(Exception e) {
				model.addAttribute("mypackage", e.getMessage());
				return "error-page"; // this will show error-page.html page with exception message
				
				// TOOD : Handle Exception
			}
			
		}
		
		@GetMapping("/all/{id}")// localhost:8080/team/crud/all/1
		public String getTeamCrudById(@PathVariable("id") int id, Model model) {
			try {
				Team result = teamCRUDservice.retrievById(id);
				model.addAttribute("mypackage", result);
				return "show-one-Team-page";
					
			}
			catch (Exception e) {
				model.addAttribute("mypackage", e.getMessage());
				return "error-page"; // this will show error-page.html page with exception message
				
				
			}
			
		}

	
		

		@GetMapping("/one")// localhost:8080/team/crud/one?id=1
		public String getTeamCrudByIdWithQuestionmark(@RequestParam("id") int id, Model model) {
			try {
				Team result = teamCRUDservice.retrievById(id);
				model.addAttribute("mypackage", result);
				return "show-one-Team-page";
			}
			catch (Exception e) {
				model.addAttribute("mypackage", e.getMessage());
				return "error-page"; // this will show error-page.html page with exception message
				
				// TODO: handle exception
			}
			
		}
		//TODO Creating a new Team and save in the database
		@GetMapping("/create") // localhost:8080/team/crud/create
		public String getTeamCRUDECreate(Model model) {
			model.addAttribute("Team", new Team());
			return "create-Team-page";// this will show create-produc-page.html with default Team
		}
		@PostMapping("/create")
		public String postTeamCRUDCreate( @Valid Team Team, BindingResult result, Model model)
		
		{
			if (result.hasErrors())
			{
				return "create-Team-page";// this will show thesame html page
			}
			else
			{
				
			
				try {
					teamCRUDservice.create(Team.getName(), Team.getPoints());
				
					return "redirect:/Team/crud/all";//the endpoint localhost:8080/team/crud/all will be called
					
				} catch (Exception e) {
					model.addAttribute("mypackage", e.getMessage());
					return "error-page";//will show error-page.html page with exception message
				}
			}
		}
		//TODO create update get mapping function and 	 and TODO create update-Team-page.html
		@GetMapping("/update/{id}")// localhost:8080/team/crud/update/1
		public String  getTeamCRUdupdateById(@PathVariable("id") int id, Model model) {
			try {
				Team TeamForUpdating = teamCRUDservice.retrievById(id);
				model.addAttribute("Team", TeamForUpdating);
				model.addAttribute("id", id);
				
				return "update-Team-page"; // will show update-Team-page.html pagw with Team
			}
			catch(Exception e) {
				model.addAttribute("mypackage", e.getMessage());
				return "error-page";//will show error-page.html page with exception message
			}
			
		}

		@PostMapping("/update/{id}")
		public String postTeamCRUDUpdateById(@PathVariable("id") int id,@ Valid Team Team,BindingResult result, Model model)
		{	
			if (result.hasErrors())
			{
				return "update-Team-page";// this will show the same html page
			}
			else
			{
				try {
					teamCRUDservice.updateById(id, Team.getName(), Team.getPoints());
					return "redirect:/Team/crud/all/" + id;
					
				} catch (Exception e) {
					model.addAttribute("mypackage", e.getMessage());
					return "error-page";//will show error-page.html page with exception message
			}
			}
		}
			
		//TODO Get mapping function for deleting
		@GetMapping("/delete/{id}") //localhost:8080/team/crud/delete/1
		public String getTeamCRUDDeleteById(@PathVariable("id") int id, Model model) {
			try
			{
				teamCRUDservice.deleteById(id);
				ArrayList<Team> result = teamCRUDservice.retrieveAll();
				model.addAttribute("mypackage", result);
				return "show-all-Team-page"; // this will show show-all-Team-page.html on the browser
				
			}catch (Exception e) {
				model.addAttribute("mypackage", e.getMessage());
				return "error-page";//will show error-page.html page with exception message
				// TODO: handle exception
			}
		}
		
		

}
