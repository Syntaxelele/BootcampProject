package bootcamp.project.controllers;

import java.util.ArrayList;

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

	@GetMapping("hellotests")
	public void testDBModel() {
		Student s1 = new Student("Janis", "Berzins", "niks", "passwords", 2, "inbox@inbox.lv");
		Student s2 = new Student("Líga", "Liepa", "nickname", "passworasdds", 2, "inboax@inbox.lv");
		Student s3 = new Student("Roberts", "Ziema", "dsafas", "passwdsadasords", 2, "inbaaox@inbox.lv");
		studentRepo.save(s1);
		studentRepo.save(s2);
		studentRepo.save(s3);
		Professor pr1 = new Professor("Baiba", "Jauká", "baibaa",
				"parole", 1, "emails@email.lv");
		professorRepo.save(pr1);
		Professor pr2 = new Professor("Zigis", "Kalns", "zigiiis",
				"parolee", 1, "epasts@epasts.lv");
		professorRepo.save(pr2);
		Course c1 = new Course("math", "desc", pr1, "1",
				"test", 1, "afsafas", "dsadas", "dsadsa", "dsadsadas");
		courseRepo.save(c1);
		Course c2 = new Course("java", "desc", pr2, "1",
				"test", 2, "afsafas", "dsadas", "dsadsa", "dsadsadas");
		courseRepo.save(c2);
		
		pr1.setCourse(c2);
		pr2.setCourse(c1);

		Grade g1 = new Grade(1, c1, s1);
		Grade g2 = new Grade(9, c1, s2);
		Grade g3 = new Grade(4, c2, s3);
		Grade g4 = new Grade(5, c2, s2);
		Grade g5 = new Grade(5, c1, s1);
		gradeRepo.save(g1);
		gradeRepo.save(g2);
		gradeRepo.save(g3);
		gradeRepo.save(g4);
		gradeRepo.save(g5);

		ArrayList<Grade> gradesForJanis = new ArrayList<Grade>();
		gradesForJanis.add(g1);
		gradesForJanis.add(g3);
		ArrayList<Grade> gradesForLiga = new ArrayList<Grade>();
		gradesForLiga.add(g2);
		gradesForLiga.add(g4);
		ArrayList<Grade> gradesForRoberts = new ArrayList<Grade>();
		gradesForRoberts.add(g5);

		/*
		for (Student s : studentRepo.findAll())
			System.out.println(s);

		Course courseJava = courseRepo.findByTitle("JAVA");
		ArrayList<Grade> gradesInJava = gradeRepo.findByCourse(courseJava);
		float sumJavaGrades = 0.0f;
		for (Grade g : gradesInJava)
			sumJavaGrades += g.getGrade();

		System.out.println("JAVA avg grade: " + sumJavaGrades / gradesInJava.size());
		// get all students in JAVA
		System.out.println("Students in JAVA");
		for (Grade g : gradesInJava) {
			Student stJava = studentRepo.findByGrades(g);
			System.out.println(stJava.getName() + " " + stJava.getLastname() + " " + g.getGrade());
		}
		System.out.println("----------------------");

		Course courseMath = courseRepo.findByTitle("Math");
		ArrayList<Grade> gradesInMath = gradeRepo.findByCourse(courseMath);
		float sumMathGrades = 0.0f;
		for (Grade g : gradesInMath)
			sumMathGrades += g.getGrade();

		System.out.println("Math avg grade: " + sumMathGrades / gradesInMath.size());
		// get all students in Math
		System.out.println("Students in Math");
		for (Grade g : gradesInMath) {
			Student stMath = studentRepo.findByGrades(g);
			System.out.println(stMath.getName() + " " + stMath.getLastname() + " " + g.getGrade());
		} 

		
		System.out.println("Show all courses");
		courseRepo.findAll().forEach(course->System.out.println(course.getTitle()));
		*/
	}

}