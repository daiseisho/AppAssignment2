package ie.assignment2.controllers;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ie.assignment2.entities.MyUser;
import ie.assignment2.forms.NewUserForm;
import ie.assignment2.service.UserService;

@Controller
public class NewUserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@GetMapping("/newuser")
	public String addUser(Model model)
	{
		model.addAttribute("newUserForm", new NewUserForm());
		
		List<String> roleType=Arrays.asList("USER","ADMIN");
		model.addAttribute("roleType",roleType);
		return "newuser";
	}
	
	@PostMapping("newuser")
	public String addUserPost(@Valid NewUserForm newUserForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) 
	{
		if(bindingResult.hasErrors()) {
			List<String> roleType=Arrays.asList("USER","ADMIN");
			return "newuser";
		}
		

		
		
		MyUser myUser = userService.addUser(
				newUserForm.getUserEmail(),
				passwordEncoder.encode(newUserForm.getUserPassword()),
				newUserForm.getFirstName(),
				newUserForm.getLastName(),
				newUserForm.getRole());
		
		userService.save(myUser);
		
		return "redirect:/";
	}	

}
