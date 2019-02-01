package bootcamp.project.controllers;

import bootcamp.project.courses.Course;
import bootcamp.project.courses.Grade;
import bootcamp.project.helper.CheckBoxList;
import bootcamp.project.repo.CourseRepo;
import bootcamp.project.repo.GradeRepo;
import bootcamp.project.repo.ProfessorRepo;
import bootcamp.project.repo.StudentRepo;
import bootcamp.project.users.Professor;
import bootcamp.project.users.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class CourseController {
    @Autowired
    CourseRepo courseRepo;

    @Autowired
    ProfessorRepo professorRepo;

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    GradeRepo gradeRepo;

//------------------------SHOW COURSES---------------------------------------//

    @GetMapping("/oneCourse/{id}")
    public String showOneCourse(@PathVariable(required = false, name = "id") int id, Model model) {
        //model.addAttribute("course", courseList.get(id));
        Long idL = (long) id;
        Optional<Course> courseFromDB = courseRepo.findById(idL);
        model.addAttribute("course", courseFromDB.get());
        return "showMyCourse";
    }

    @GetMapping(value = "/showAllCourses/{id}")
    public String showAllCoursesToView(Model model, @PathVariable(required = false, name = "id") long id) {
        model.addAttribute("allCourses", courseRepo.findAll());
        courseRepo.findAll().forEach(course -> System.out.println(course));
        return "showAllCourses";
    }

    @GetMapping(value = "/showProfessorCourse/{id}")
    public String showProfessorCourseToView(@PathVariable(required = false, name = "id") int id, Model model) {
        //model.addAttribute("allCourses", courseRepo.findAll());
        //courseRepo.findAll().forEach(course -> System.out.println(course));
        Long idL = (long) id;
        Optional<Course> courseFromDB = courseRepo.findById(idL);
        model.addAttribute("course", courseFromDB.get());
        return "showMyCourse";
    }

    //----------------------------------------------------------------------//
    //---------------------------COURSE INPUT--------------------------//

    @GetMapping("/insertNewCourse/{id}")
    public String insertCourseView(@PathVariable(required = false, name = "id") long id, Course course) {
        return "courseInput";
    }

    @PostMapping("/insertNewCourse/{id}")
    public String getCourseFromView(@PathVariable(required = false, name = "id") long id,
                                    @Valid Course course, BindingResult result) {
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
        Optional<Professor> ProfFromDB = professorRepo.findById(id);
        course.setProfessor(ProfFromDB.get());
        courseRepo.save(course);
        return "redirect:/showProfessorCourse/" + id;
    }

    //--------------------------------------------------------------------//
    //-----------------------REGISTER TO COURSES--------------------------//


    @GetMapping(value = "/registerToCourse/{id}")
    public String registerToCourseView(Model model, @PathVariable(name = "id") long id,
                                       @RequestParam(name = "courseButtonID", defaultValue = "none",
                                               required = false) String courseButtonID) {
        //System.out.println(courseButtonID);
        Iterable<Course> courseFromDB = courseRepo.findAll();
        CheckBoxList checkBoxList = new CheckBoxList();
        for (Course i : courseFromDB) {
            checkBoxList.addCheck(false);
        }

        model.addAttribute("regToCourse", courseFromDB);
        model.addAttribute("listOfCheck", checkBoxList);

        return "registerToCourse";
    }

    @PostMapping(value = "/registerToCourse/{id}")
    public String registerToCourseViewPost(@PathVariable(name = "id") long id, CheckBoxList checkBoxList) {
        Student student1 = studentRepo.findById(id).get();
        ArrayList<Course> courses1 = (ArrayList<Course>) courseRepo.findAll();
        int coursesindex = 0;
        for (Boolean i : checkBoxList.getListOfCheck()) {
            System.out.println(i);
            if (i != null) {
                Grade g1 = new Grade(0, courses1.get(coursesindex), student1);
                gradeRepo.save(g1);
            }
            coursesindex++;
        }
        return "redirect:/showStudentCourses/" + id;
    }


}