package bootcamp.project.controllers;

import bootcamp.project.users.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @GetMapping("/start")
    public String Submit(User user) {
        return "start";

    }
    @PostMapping("/start")
    public String Doors(User user, @RequestParam(name = "Auth") String button) {
        if (button.equals("submit")){


            //parbauda, vai eksiste
            return "StudentMenu";
        }
        else {
            return "RegView";
        }

    }

}
