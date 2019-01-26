package bootcamp.project.users;

import org.springframework.beans.factory.annotation.Autowired;

import bootcamp.project.courses.Course;
import bootcamp.project.repo.CourseRepo;

public class Professor extends User {
   @Autowired
   CourseRepo courseRepo;
	public String[] getCourse(int courseID) {
		//Iterable<Course> courseFromDB = courseRepo.findById(courseID);
		return null;
	}
	public String[] getStudent() {
		return null;
	}
	public String[] getGrades() {
		return null;
	}
	public void setCourse() {
        Course c1 = new Course();
        courseRepo.save(c1);
	}
	public void setGrade(int courseID, int id_u) {
		
		
	}

}
