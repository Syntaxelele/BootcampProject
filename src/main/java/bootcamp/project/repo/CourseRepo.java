package bootcamp.project.repo;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import bootcamp.project.courses.Course;
import bootcamp.project.courses.Grade;
import bootcamp.project.users.Professor;
import bootcamp.project.users.Student;

public interface CourseRepo extends CrudRepository<Course, Long> {
  
	Course findByTitle(String title);
  
	Course findByProfessor(Professor professor);
	
	//Course findByStudent(Student student);
    
	//Course findByStudentId(long id);
	
	//ArrayList<Course>findByStudentId(long id);
	
    //@Query("SELECT courseTitle FROM course_table WHERE professor_id_u = :id")
    //List<Course> findByMyQuery(@Param("id") Long id);
}