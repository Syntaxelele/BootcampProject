package bootcamp.project.controllers;

import bootcamp.project.courses.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import bootcamp.project.repo.CourseRepo;

@Controller
public class CourseController {
   @Autowired
   CourseRepo courseRepo;
//-----------------------------------COURSE OUTPUT------------------------------//
    @GetMapping(value = "/hello")
    public String courseTesting(Model model){

        System.out.println("logging info");

        Course c1 = new Course("thisIsTitle","thisIsDesc",2,"C123","thisIsEval",9,
                "thisIsPrereq","thisIsObjective","thisIsoutcome", "thisIsContent");
        Course c2 = new Course("thisIsTitle2","thisIsDesc2",3,"C155","thisIsEval2",8,
                "thisIsPrereq2","thisIsObjective2","thisIsoutcome2", "thisIsContent2");
        courseRepo.save(c1);
        courseRepo.save(c2);

        System.out.println("testtesttesttest");

        Iterable<Course> courseFromDB = courseRepo.findAll();
        model.addAttribute("courseTests", courseFromDB);
        System.out.println("1231231231231");
        return  "courseTest";

    }
    @GetMapping(value = "/showAllCourses")
    public String showAllCoursesToView(Model model) {
        model.addAttribute("allCourses", courseRepo.findAll());
        courseRepo.findAll().forEach(course -> System.out.println(course));

        return "showAllCourses";
    }
    //----------------------------------------------------------------------//
    //---------------------------COURSE INPUT--------------------------//




}
