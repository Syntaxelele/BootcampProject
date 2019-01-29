package bootcamp.project.controllers;

import bootcamp.project.repo.ProfessorRepo;
import bootcamp.project.repo.StudentRepo;
import bootcamp.project.users.Professor;
import bootcamp.project.users.Student;
import bootcamp.project.users.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {
	
	@Autowired
	StudentRepo studentRepo; 
	@Autowired
	ProfessorRepo professorRepo;
	
    @GetMapping("/start")
    public String Submit(Student student, Professor professor) {
        return "start";

    }
    @PostMapping("/start")
    public String Doors(Student student, Professor professor, @RequestParam(name = "Auth") String button) {
        if (button.equals("submit")){

    		User findbyNameAndPassw = studentRepo.findByUsernameAndPassword(student.getUsername(), student.getPassword());
    		
    		if(findbyNameAndPassw == null){
    			findbyNameAndPassw = professorRepo.findByUsernameAndPassword(professor.getUsername(), professor.getPassword());
    			if (findbyNameAndPassw == null) {
            		System.out.println("User not found");
        			return "index";
    			} else {
    			System.out.println(findbyNameAndPassw.getUsername());
    			return "ProfessorMenu";
    			}
    		}
    		else
    		{
    			System.out.println(findbyNameAndPassw.getUsername());
    			return "StudentMenu";
    		}
            
        }
        else {
            return "RegView";
        }

    }
}