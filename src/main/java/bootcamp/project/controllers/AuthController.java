package bootcamp.project.controllers;

import bootcamp.project.users.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @GetMapping("/index")
    public String Submit(User user) {
        return "/index";

    }
    @PostMapping("/index")
    public String Register(User user, @RequestParam(name = "Auth") String button) {
        if (button.equals("submit")){
            return "StudentMenu";
        }
        else {
            return "RegView";
        }

    }

}
