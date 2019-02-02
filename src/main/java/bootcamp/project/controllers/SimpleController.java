package bootcamp.project.controllers;

import bootcamp.project.courses.Course;
import bootcamp.project.courses.Grade;
import bootcamp.project.repo.CourseRepo;
import bootcamp.project.repo.GradeRepo;
import bootcamp.project.repo.ProfessorRepo;
import bootcamp.project.repo.StudentRepo;
import bootcamp.project.users.Professor;
import bootcamp.project.users.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class SimpleController {

    @Autowired
    StudentRepo studentRepo;
    @Autowired
    ProfessorRepo professorRepo;
    @Autowired
    CourseRepo courseRepo;
    @Autowired
    GradeRepo gradeRepo;

    Logger logger = LoggerFactory.getLogger(RegisterAndLogController.class);

    @GetMapping("hellotests")
    public String testDBModel() {

        Student s1 = new Student("Janis", "Berzins", "niks", "parole", 2, "deivids.polakovs@gmail.com");
        studentRepo.save(s1);
        Student s2 = new Student("Juris", "Liepa", "liga", "parole", 2, "rents6@inbox.lv");
        studentRepo.save(s2);
        Student s3 = new Student("Roberts", "Ziema", "roberts", "parole", 2, "armands.smans@gmail.com");
        studentRepo.save(s3);
        Student s4 = new Student("Anna", "Panna", "anna", "parole", 2, "s8_apina_m@venta.lv");
        studentRepo.save(s4);
        // -----------------------------------------------------------------------------------------------------------//
        Professor pr1 = new Professor("Baiba", "Jauka", "baiba", "parole", 1, "emails@email.lv");
        professorRepo.save(pr1);
        Professor pr2 = new Professor("Zigis", "Kalns", "zigis", "parolee", 1, "epasts@epasts.lv");
        professorRepo.save(pr2);
        /*Professor pr3 = new Professor("Raimonds", "Jaukums", "raimis", "parole", 1, "emails@emails.lv");
        professorRepo.save(pr3);
        Professor pr4 = new Professor("Ilze", "Kalna", "ilze", "parolee", 1, "epastss@epastss.com");
        professorRepo.save(pr4);*/
        // --------------------------------------------------------------------------------------------------------//
        Course c1 = new Course("Math",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                pr1, "Exam", "2",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer enim justo, hendrerit eget justo gravida, imperdiet dictum est. Cras fermentum nibh eu leo facilisis ultrices quis nec erat.",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam molestie nulla sit amet metus vulputate iaculis. Praesent ligula enim, ullamcorper in lectus sed, rutrum mattis erat.",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur sit amet ante lorem. Suspendisse placerat sapien vel orci iaculis, at sollicitudin quam consequat. Suspendisse potenti.",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur sit amet ante lorem. Suspendisse placerat sapien vel orci iaculis, at sollicitudin quam consequat. Suspendisse potenti.");
        courseRepo.save(c1);
        Course c2 = new Course("C++", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", pr2, "Test", "4",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer enim justo, hendrerit eget justo gravida, imperdiet dictum est. Cras fermentum nibh eu leo facilisis ultrices quis nec erat.",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam molestie nulla sit amet metus vulputate iaculis. Praesent ligula enim, ullamcorper in lectus sed, rutrum mattis erat.",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur sit amet ante lorem. Suspendisse placerat sapien vel orci iaculis, at sollicitudin quam consequat. Suspendisse potenti.",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur sit amet ante lorem. Suspendisse placerat sapien vel orci iaculis, at sollicitudin quam consequat. Suspendisse potenti.");
        courseRepo.save(c2);
       /* Course c3 = new Course("Python", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", pr3, "Exam", "2",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer enim justo, hendrerit eget justo gravida, imperdiet dictum est. Cras fermentum nibh eu leo facilisis ultrices quis nec erat.",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam molestie nulla sit amet metus vulputate iaculis. Praesent ligula enim, ullamcorper in lectus sed, rutrum mattis erat.",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur sit amet ante lorem. Suspendisse placerat sapien vel orci iaculis, at sollicitudin quam consequat. Suspendisse potenti.",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur sit amet ante lorem. Suspendisse placerat sapien vel orci iaculis, at sollicitudin quam consequat. Suspendisse potenti.");
        courseRepo.save(c3);
        Course c4 = new Course("Science", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", pr4, "Test", "6",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer enim justo, hendrerit eget justo gravida, imperdiet dictum est. Cras fermentum nibh eu leo facilisis ultrices quis nec erat.",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam molestie nulla sit amet metus vulputate iaculis. Praesent ligula enim, ullamcorper in lectus sed, rutrum mattis erat.",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur sit amet ante lorem. Suspendisse placerat sapien vel orci iaculis, at sollicitudin quam consequat. Suspendisse potenti.",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur sit amet ante lorem. Suspendisse placerat sapien vel orci iaculis, at sollicitudin quam consequat. Suspendisse potenti.");
        courseRepo.save(c4);*/
        // --------------------------------------------------------------------------------------------------------//
        Grade g1 = new Grade(1, c1, s1);
        Grade g2 = new Grade(9, c1, s2);
        Grade g3 = new Grade(4, c2, s3);
        Grade g4 = new Grade(5, c2, s2);
        /*Grade g5 = new Grade(5, c4, s1);
        Grade g6 = new Grade(6, c3, s4);
        Grade g7 = new Grade(8, c4, s3);
        Grade g8 = new Grade(4, c3, s2);*/

        gradeRepo.save(g1);
        gradeRepo.save(g2);
        gradeRepo.save(g3);
        gradeRepo.save(g4);
        /*gradeRepo.save(g5);
        gradeRepo.save(g6);
        gradeRepo.save(g7);
        gradeRepo.save(g8);*/

        ArrayList<Grade> gradesForJanis = new ArrayList<Grade>();
        gradesForJanis.add(g1);
        gradesForJanis.add(g3);
        ArrayList<Grade> gradesForLiga = new ArrayList<Grade>();
        gradesForLiga.add(g2);
        gradesForLiga.add(g4);
        ArrayList<Grade> gradesForRoberts = new ArrayList<Grade>();
        gradesForRoberts.add(g2);
        // --------------------------------------------------------------------------------------------------------//
        logger.info("MySQL: Dummy data has been created.");
        return "redirect:/start";
    }
}
