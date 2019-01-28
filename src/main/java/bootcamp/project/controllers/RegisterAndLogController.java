package bootcamp.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bootcamp.project.repo.ProfessorRepo;
import bootcamp.project.repo.StudentRepo;
import bootcamp.project.users.Professor;
import bootcamp.project.users.Student;

@Controller
public class RegisterAndLogController {
	
	@Autowired
	StudentRepo studentRepo; 
	@Autowired
	ProfessorRepo professorRepo;

	@GetMapping("/showAllUsers")
	public String showAllStudentsToView(Model model) {
		//User u1 = new User("Janis", "Berzins", "Janis", "password", 2, "janis@somewhere.com");
		//User u2 = new User("Marta", "Apina", "marta", "123", 2, "marta@somewhere.com");
		//userRepo.save(u1);
		//userRepo.save(u2);
		
		Iterable<Student> userFromDB = studentRepo.findAll();
		model.addAttribute("allUsers", userFromDB);
		return "showAllUsers";

	}
	
	//SHOW USER BY NAME
/*	@GetMapping("/showUserByName")
	public String showUserByName(
			@RequestParam(name = "username", defaultValue = "Janis", required = false) String username, Model model) {
		//Iterable<User> userResult = userRepo.findByName(username);
	//	model.addAttribute("allUsers", userResult);
		return "showAllUsers";
	}
*/
	
	@GetMapping("/logStud")
	public String createNewStudent(Student student) {

		return "indexView";
	}	
	@GetMapping("/logProf")
	public String createNewProfessor(Professor professor) {

		return "indexView";
	}
	/*@PostMapping("/")
	public String registerOrLogin(User user) {
		
	}*/
	//new controller
    @GetMapping("/RegView")
    public String Registerer(Student student, Professor professor) {
        return "start";

    }
    @PostMapping("/RegView")
    public String Register(Student student, Professor professor, @RequestParam(name = "Reg") String button) {

    	return"start";
    }
}
