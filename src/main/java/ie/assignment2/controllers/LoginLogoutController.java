package ie.assignment2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginLogoutController {

		@GetMapping("/403")
		public String notAuthorised() {
			return "403";
		}
//		@GetMapping("/login")
//		public String login() {
//			return "login";
//		}
}
