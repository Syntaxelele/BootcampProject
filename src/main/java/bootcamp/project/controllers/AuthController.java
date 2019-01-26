package bootcamp.project.controllers;

import bootcamp.project.repo.UserRepo;
import bootcamp.project.users.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {
	
	@Autowired
	UserRepo userRepo;
	
    @GetMapping("/start")
    public String Submit(User user) {
        return "start";

    }
    @PostMapping("/start")
    public String Doors(User user, @RequestParam(name = "Auth") String button) {
        if (button.equals("submit")){

    		User findbyNameAndPassw = userRepo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    		
    		if(findbyNameAndPassw == null)
    		{
    			System.out.println("User not found");
    			return "index";
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
