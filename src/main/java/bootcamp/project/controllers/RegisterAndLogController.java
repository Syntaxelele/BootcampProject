package bootcamp.project.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bootcamp.project.courses.Course;
import bootcamp.project.repo.ProfessorRepo;
import bootcamp.project.repo.StudentRepo;
import bootcamp.project.users.Professor;
import bootcamp.project.users.Student;
import bootcamp.project.users.User;

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

	// SHOW USER BY NAME
	/*
	 * @GetMapping("/showUserByName") public String showUserByName(
	 * 
	 * @RequestParam(name = "username", defaultValue = "Janis", required = false)
	 * String username, Model model) { //Iterable<User> userResult =
	 * userRepo.findByName(username); // model.addAttribute("allUsers", userResult);
	 * return "showAllUsers"; }
	 */

	@GetMapping("/logStud")
	public String doorsStudent(Student student) {
		return "StudentMenu";
	}

	@PostMapping("/logStud")
	public String ShowCourses(Student student, Professor professor, @RequestParam(name = "ShowCours") String button) {
		return "showAllCourses";
	}

	@GetMapping("/logProf")
	public String doorsProfessor(Professor professor) {
		return "professorMenu";

	}

	/*
	 * @PostMapping("/") public String registerOrLogin(User user) {
	 * 
	 * }
	 */
	// new controller
	@GetMapping("/RegView")
	public String Registerer(Student student, Professor professor) {
		return "RegView";
	}

	@PostMapping("/RegView")
	//public String Register(Student student, Professor professor, @RequestParam(name = "Reg") String button) {
    public String Register(Student student, BindingResult result) {
        System.out.println(
                student.getName() + " "
                        + student.getLastname() + " "
                        + student.getUsername() + " "
                        + student.getEmail() + " "
                        + student.getRole()
        );
        studentRepo.save(student);
        return "StudentMenu";
		//return "RegView";
	}

	@GetMapping("/showCourses")
	public String createNewStudent2(Student student) {
		return "showAllCourses";
	}

	@PostMapping("/logProf")
	public String doorsForProf(Professor professor, @RequestParam(name = "choice") String button) {
		if (button.equals("ShowCours")) {
			return "redirect:/showAllCourses";
		} 
		else {
			return "redirect:/insertNewCourse";
		}
	}


}