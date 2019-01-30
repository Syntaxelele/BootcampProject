package bootcamp.project.controllers;

import bootcamp.project.repo.ProfessorRepo;
import bootcamp.project.repo.StudentRepo;
import bootcamp.project.users.Professor;
import bootcamp.project.users.Student;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterAndLogController {

	@Autowired
	StudentRepo studentRepo;
	@Autowired
	ProfessorRepo professorRepo;


	@GetMapping("/showAllStudents")
	public String showAllStudentsToView(Model model) {
		Iterable<Student> userFromDB = studentRepo.findAll();
		model.addAttribute("allUsers", userFromDB);
		return "showAllUsers";
	}

	
	@GetMapping("/showAllProfessors")
	public String showAllSProfessorsToView(Model model) {
		Iterable<Professor> userFromDB2 = professorRepo.findAll();
		model.addAttribute("allUsers", userFromDB2);
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
    //--------------------------------------------------------------------//
    //-----------------------STUDENT--------------------------------------//
	@GetMapping("/StudentMenu/{id}")
	public String doorsStudent(Student student, @PathVariable(name = "id") long id) {
		return "StudentMenu";
	}

	@PostMapping("/StudentMenu/{id}")
	public String showStudentMenu(Student student, @PathVariable(name = "id") long id, @RequestParam(name = "studButton") String button) {
		if (button.equals("regToCourse"))
			return "redirect:/registerToCourse/" + id;
		else if (button.equals("ShowMyCours"))
			return "redirect:/showStudentCourses/" + id;
		else
			return "redirect:/ShowGrades/" + id;
	}
    //--------------------------------------------------------------------//
    //-----------------------PROFESSOR------------------------------------//
	@GetMapping("/professorMenu/{id}")
	public String doorsProfessor(Professor professor,@PathVariable(name = "id") long id) {
		return "professorMenu";
	}
	@PostMapping("/professorMenu/{id}")
	public String showProfessorMenu(Professor professor, @PathVariable(name = "id") long id, @RequestParam(name = "profButton") String button) {
		if (button.equals("ShowCours")) {
			return "showMyCourse"; // + id
		} else if (button.equals("exportGrades"))
			return "redirect:/uploadExcelFile/" + id;
		else {
			return "redirect:/insertNewCourse";
		}
	}

	@GetMapping("/RegView")
	public String Registerer(Student student, Professor professor) {
		return "RegView";
	}

	@PostMapping("/RegView")
	public String Register(@Valid Student student, Professor professor, BindingResult result) {
        if (result.hasErrors()) {
            return "RegView";
        }
			if (student.getRole() == 2) {
				System.out.println(
						student.getName() + " "
								+ student.getLastname() + " "
								+ student.getUsername() + " "
								+ student.getEmail() + " "
								+ student.getRole()
				);
				studentRepo.save(student);
				return "StudentMenu";
			} else {
				System.out.println(
						professor.getName() + " "
								+ professor.getLastname() + " "
								+ professor.getUsername() + " "
								+ professor.getEmail() + " "
								+ professor.getRole()
				);
				professorRepo.save(professor);
				return "professorMenu";
		}
	}

	@GetMapping("/showCourses")
	public String createNewStudent2(Student student) {
		return "showAllCourses";
	}
}