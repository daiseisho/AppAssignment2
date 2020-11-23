package ie.assignment2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexControllers {
	
	@GetMapping("/")
	// localhost:8080?myname=Cliona
	public String loadIndexGet(@RequestParam(name = "myname", required = false, defaultValue = "") String name, Model model) {
		model.addAttribute("name", name);
		return "index";
	}
	
	@GetMapping("/{myname}")
	// localhost:8080?myname=Cliona
	public String loadIndexGetPath(@PathVariable("myname") String name, Model model) {
		model.addAttribute("name", name);
		return "index";
	}
	
	@PostMapping("/")
	public String loadIndexPost() {
		return "index";
	}
}
