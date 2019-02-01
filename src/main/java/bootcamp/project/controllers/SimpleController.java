package bootcamp.project.controllers;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import bootcamp.project.users.Professor;
import bootcamp.project.users.Student;
import bootcamp.project.courses.Course;
import bootcamp.project.courses.Grade;
import bootcamp.project.repo.CourseRepo;
import bootcamp.project.repo.GradeRepo;
import bootcamp.project.repo.ProfessorRepo;
import bootcamp.project.repo.StudentRepo;

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

		Student s1 = new Student("Janis", "Berzins", "niks", "passwords", 2, "rents6@inbox.lv");
		Student s2 = new Student("Líga", "Liepa", "nickname", "passworasdds", 2, "syntaxlv112@gmail.com");
		Student s3 = new Student("Roberts", "Ziema", "dsafa", "passwdsadasords", 2, "armands.smans@gmail.com");
		Student s4 = new Student("Anna", "Panna", "dsafas", "passwdsadasords", 2, "s8_apina_m@venta.lv");

		studentRepo.save(s1);
		studentRepo.save(s2);
		studentRepo.save(s3);
		studentRepo.save(s4);

		Professor pr1 = new Professor("Baiba", "Jauka", "baibaa", "parole", 1, "emails@email.lv");
		professorRepo.save(pr1);
		Professor pr2 = new Professor("Zigis", "Kalns", "zigiiis", "parolee", 1, "epasts@epasts.lv");
		professorRepo.save(pr2);
		// -----------------------------------------------------------------------------------------------------------//
		Professor pr3 = new Professor("Zigiiitis", "Jaukums", "ziguciitis", "parole", 1, "emails@emails.lv");
		professorRepo.save(pr3);
		Professor pr4 = new Professor("Ilze", "Kalna", "ilzhuks", "parolee", 1, "epastss@epastss.com");
		professorRepo.save(pr4);
		// --------------------------------------------------------------------------------------------------------//
		Course c1 = new Course("Math",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce eget massa posuere, mollis odio sit amet, varius nibh. Proin ut justo velit. Nullam non pulvinar turpis, eget viverra mi. Donec et tristique enim, a luctus felis. Sed tincidunt maximus vehicula. Aliquam tincidunt velit sapien, sit amet.",
				pr1, "11", "test", 1,
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer enim justo, hendrerit eget justo gravida, imperdiet dictum est. Cras fermentum nibh eu leo facilisis ultrices quis nec erat. Sed sit amet nunc fermentum, feugiat quam a, dignissim leo. Duis tristique dignissim luctus. Morbi in nullam.",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam molestie nulla sit amet metus vulputate iaculis. Praesent ligula enim, ullamcorper in lectus sed, rutrum mattis erat. Nunc in ex et purus dapibus faucibus. Cras ipsum lectus, lacinia eget porttitor vel, lacinia vel sapien. In posuere.",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur sit amet ante lorem. Suspendisse placerat sapien vel orci iaculis, at sollicitudin quam consequat. Suspendisse potenti. Aenean eu euismod enim. Nullam quis nibh in tellus iaculis lobortis sit amet ac turpis. Integer vitae ipsum sed.",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur sit amet ante lorem. Suspendisse placerat sapien vel orci iaculis, at sollicitudin quam consequat. Suspendisse potenti. Aenean eu euismod enim. Nullam quis nibh in tellus iaculis lobortis sit amet ac turpis. Integer vitae ipsum sed.");
		courseRepo.save(c1);
		Course c2 = new Course("Java", "desc", pr2, "22", "test", 2, "afsafas", "dsadas", "dsadsa", "dsadsadas");
		courseRepo.save(c2);

		// ---------------------------------------------------------------------------------------------------------//
		Course c3 = new Course("Python", "desc", pr3, "33", "test", 2, "afsafas", "dsadas", "dsadsa", "dsadsadas");
		courseRepo.save(c3);
		Course c4 = new Course("Science", "desc", pr4, "44", "test", 2, "afsafas", "dsadas", "dsadsa", "dsadsadas");
		courseRepo.save(c4);

		Grade g1 = new Grade(1, c1, s1);
		Grade g2 = new Grade(9, c1, s2);
		Grade g3 = new Grade(4, c2, s3);
		Grade g4 = new Grade(5, c2, s2);
		Grade g5 = new Grade(5, c4, s1);
		Grade g6 = new Grade(6, c3, s4);
		Grade g7 = new Grade(8, c4, s3);
		Grade g8 = new Grade(4, c3, s2);

		gradeRepo.save(g1);
		gradeRepo.save(g2);
		gradeRepo.save(g3);
		gradeRepo.save(g4);
		gradeRepo.save(g5);
		gradeRepo.save(g6);
		gradeRepo.save(g7);
		gradeRepo.save(g8);

		ArrayList<Grade> gradesForJanis = new ArrayList<Grade>();
		gradesForJanis.add(g1);
		gradesForJanis.add(g3);
		ArrayList<Grade> gradesForLiga = new ArrayList<Grade>();
		gradesForLiga.add(g2);
		gradesForLiga.add(g4);
		ArrayList<Grade> gradesForRoberts = new ArrayList<Grade>();
		gradesForRoberts.add(g5);

		/*
		 * for (Student s : studentRepo.findAll()) System.out.println(s);
		 * 
		 * Course courseJava = courseRepo.findByTitle("JAVA"); ArrayList<Grade>
		 * gradesInJava = gradeRepo.findByCourse(courseJava); float sumJavaGrades =
		 * 0.0f; for (Grade g : gradesInJava) sumJavaGrades += g.getGrade();
		 * 
		 * System.out.println("JAVA avg grade: " + sumJavaGrades / gradesInJava.size());
		 * // get all students in JAVA System.out.println("Students in JAVA"); for
		 * (Grade g : gradesInJava) { Student stJava = studentRepo.findByGrades(g);
		 * System.out.println(stJava.getName() + " " + stJava.getLastname() + " " +
		 * g.getGrade()); } System.out.println("----------------------");
		 * 
		 * Course courseMath = courseRepo.findByTitle("Math"); ArrayList<Grade>
		 * gradesInMath = gradeRepo.findByCourse(courseMath); float sumMathGrades =
		 * 0.0f; for (Grade g : gradesInMath) sumMathGrades += g.getGrade();
		 * 
		 * System.out.println("Math avg grade: " + sumMathGrades / gradesInMath.size());
		 * // get all students in Math System.out.println("Students in Math"); for
		 * (Grade g : gradesInMath) { Student stMath = studentRepo.findByGrades(g);
		 * System.out.println(stMath.getName() + " " + stMath.getLastname() + " " +
		 * g.getGrade()); }
		 * 
		 * 
		 * System.out.println("Show all courses");
		 * courseRepo.findAll().forEach(course->System.out.println(course.getTitle()));
		 */
		logger.info("MySQL: Dummy data has been created.");
		return "redirect:/start";
	}
}
