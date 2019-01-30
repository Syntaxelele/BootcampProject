package bootcamp.project.controllers;

import bootcamp.project.courses.Course;
import bootcamp.project.helper.Top;
import bootcamp.project.repo.CourseRepo;
import bootcamp.project.repo.ProfessorRepo;
import bootcamp.project.repo.StudentRepo;
import bootcamp.project.users.Professor;
import bootcamp.project.users.Student;
import javax.validation.Valid;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;

@Controller
public class RegisterAndLogController {

	@Autowired
	StudentRepo studentRepo;
	@Autowired
	CourseRepo courseRepo;
	@Autowired
	ProfessorRepo professorRepo;

	@GetMapping("/showAllUsers")
	//@GetMapping("/showAllStudents")
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
		if (button.equals("showMyCourse")) {
			return "redirect:/showProfessorCourse/" + id;
		} else if (button.equals("exportGrades"))
			return "redirect:/professorMenu/" + id;
		else {
			return "redirect:/insertNewCourse/"+ id;
		}
	}
    //--------------------------------------------------------------------//
    //-----------------------REGISTRATION---------------------------------//
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
    //--------------------------------------------------------------------//
    //-----------------------DOCUMENT IMPORT------------------------------//
	@GetMapping("/DocView")
	public String DocReader(Top top) {
		return "DocReader";

	}

	@PostMapping("/DocView")
	public String DocReaderPost(Top top) {
		System.out.println(top.getDocPath());
		Course hot = new Course();
		Professor P = new Professor("Baiba", "Jauka", "baibaa", "parole", 1, "emails@email.lv");
		professorRepo.save(P);

		/*Course c = new Course("Math", "desc", P, "11",
				"test", 1, "afsafas", "dsadas", "dsadsa", "dsadsadas");*/
		try {
			FileInputStream fis = new FileInputStream(top.getDocPath());

			XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
			Iterator bodyElementIterator = xdoc.getBodyElementsIterator();
			while (bodyElementIterator.hasNext()) {
				IBodyElement element = (IBodyElement) bodyElementIterator.next();

				if ("TABLE".equalsIgnoreCase(element.getElementType().name())) {
					List<XWPFTable> tableList = element.getBody().getTables();
					XWPFTable table = tableList.get(0);
					//for (XWPFTable table : tableList) {
					System.out.println("Total Number of Rows of Table:" + table.getNumberOfRows());
					//for (int i = 0; i < table.getRows().size(); i++) {
					hot.setTitle(table.getRow(0).getCell(1).getText());
					hot.setCourseCode(table.getRow(2).getCell(1).getText());
					hot.setEvaluation(table.getRow(3).getCell(1).getText());
					hot.setProfessor(P);
					hot.setCP(table.getRow(4).getCell(1).getText().charAt(0));
					hot.setPrereq(table.getRow(5).getCell(1).getText());
					hot.setObjective(table.getRow(6).getCell(1).getText());
					hot.setOutcome(table.getRow(7).getCell(1).getText());
					System.out.println(table.getRow(8).getCell(1).getText().length());
					hot.setContent(table.getRow(8).getCell(1).getText());
					//for (int j = 0; j < table.getRow(i).getTableCells().size(); j++) {
							/*	System.out.print(table.getRow(i).getCell(0).getText()+": ");
							System.out.println(table.getRow(i).getCell(1).getText());*/
					//}
				}
				//}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
    
		courseRepo.save(hot);

		return "redirect:/DocReader";
	}


		@GetMapping("/showCourses")
	  public String createNewStudent2(Student student) {
		return "showAllCourses";
	}
}