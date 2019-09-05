package com.synechron;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegistrationController {

	@PostMapping("/register")
	public String processForm(@RequestParam("firstname") String firstName, 
			HttpSession session) {
		String message = "Hey " + firstName + " ! You are successfully registered";
		session.setAttribute("message", message);
		return "result";
	}
}
