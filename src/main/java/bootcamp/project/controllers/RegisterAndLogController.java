package bootcamp.project.controllers;

import bootcamp.project.users.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterAndLogController {


    @GetMapping("/RegView")
    public String Registerer(User user) {
        return "start";

    }
    @PostMapping("/RegView")
    public String Register(User user, @RequestParam(name = "Reg") String button) {

return"start";
}
}
