package ie.assignment2.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ie.assignment2.entities.User;
import ie.assignment2.forms.NewUserForm;
import ie.assignment2.service.UserService;

@Controller
public class NewUserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/newuser")
	public String addUser(Model model)
	{
		model.addAttribute("newUserForm", new NewUserForm());
		return "newuser";
	}
	
	@PostMapping("newuser")
	public String addUserPost(@Valid NewUserForm newUserForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) 
	{
		if(bindingResult.hasErrors()) {
			return "newuser";
		}
			
		User user = userService.addUser(
				newUserForm.getFirstName(),
				newUserForm.getLastName(),
				newUserForm.isAdmin(),
				newUserForm.getEmail(),
				newUserForm.getPassword());
		
		return "redirect:/";
	}	

}
