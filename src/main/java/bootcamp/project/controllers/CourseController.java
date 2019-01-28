package bootcamp.project.controllers;

import bootcamp.project.courses.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import bootcamp.project.repo.CourseRepo;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CourseController {
    @Autowired
    CourseRepo courseRepo;

    //-----------------------------------COURSE OUTPUT TEST------------------------------//
    /*
    @GetMapping(value = "/course")
    public String courses(Model model) {

        System.out.println("logging info");

        Course c1 = new Course("thisIsTitle", "thisIsDesc", 2, "C123", "thisIsEval", 9,
                "thisIsPrereq", "thisIsObjective", "thisIsoutcome", "thisIsContent");
        Course c2 = new Course("thisIsTitle2", "thisIsDesc2", 3, "C155", "thisIsEval2", 8,
                "thisIsPrereq2", "thisIsObjective2", "thisIsoutcome2", "thisIsContent2");
        courseRepo.save(c1);
        courseRepo.save(c2);

        System.out.println("testtesttesttest");

        Iterable<Course> courseFromDB = courseRepo.findAll();
        model.addAttribute("courseTests", courseFromDB);
        System.out.println("1231231231231");
        return "courseTest";

    }
*///------------------------SHOW ALL COURSES---------------------------------------//

    @GetMapping(value = "/showAllCourses")
    public String showAllCoursesToView(Model model) {
        model.addAttribute("allCourses", courseRepo.findAll());
        courseRepo.findAll().forEach(course -> System.out.println(course));

        return "showAllCourses";
    }

    //----------------------------------------------------------------------//
    //---------------------------COURSE INPUT--------------------------//

    @GetMapping(value = "/insertNewCourse")
    public String insertCourseView(Course course) {
        return "courseInput";
    }

    @PostMapping(value = "/insertNewCourse")
    public String getCourseFromView(@Valid Course course, BindingResult result) {
        if (result.hasErrors()) {
            return "courseInput";
        }
        System.out.println(
                         course.getTitle() + " "
                        + course.getDescription() + " "
                        + course.getProfessor() + " "
                        + course.getCourseCode() + " "
                        + course.getEvaluation() + " "
                        + course.getCP() + " "
                        + course.getPrereq() + " "
                        + course.getObjective() + " "
                        + course.getOutcome() + " "
                        + course.getContent()
        );
        courseRepo.save(course);
        System.out.println("Tests tests tests");
        return "redirect:/showAllCourses";
    }
}



