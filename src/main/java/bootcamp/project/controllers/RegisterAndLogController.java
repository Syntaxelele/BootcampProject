package bootcamp.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterAndLogController {
	
	@GetMapping("/index")	// localhost:8080/index
	public String createNewStudent(
			@RequestParam(name = "username", defaultValue = "user", required = false) String name,
			@RequestParam(name = "password", defaultValue = "", required = false) char[] password) {
	
	return "indexView";
}
}
