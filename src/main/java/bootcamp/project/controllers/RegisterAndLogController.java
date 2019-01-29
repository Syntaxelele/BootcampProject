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
		return "StudentMenu";
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
        return "RegView";
    }
    @PostMapping("/RegView")
    public String Register(Student student, Professor professor, @RequestParam(name = "Reg") String button) {
    	return"RegView";
    }

	@GetMapping("/showCourses")
	public String createNewStudent2(Student student) {
		return "showAllCourses";
	}
	@PostMapping("/logStud")
	public String ShowCourses(Student student, Professor professor, @RequestParam(name = "ShowCours") String button) {
		return"showAllCourses";
	}
}