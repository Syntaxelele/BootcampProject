package bootcamp.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import bootcamp.project.courses.Course;
import bootcamp.project.courses.Grade;
import bootcamp.project.users.Student;


public interface StudentRepo extends CrudRepository<Student, Long> {
    public Iterable<Student> findByName(String username);
	//public Iterable<Student> findAll(String lastname);
    public Student findByUsernameAndPassword(String username, String password);

    Student findByGrades(Grade grade);

    @Query("SELECT student FROM Grade WHERE grade >= 0")
    Student findByMyQuery(String name);
	
    @Query("SELECT course FROM Grade where student = :id AND grade >=0") 
    List<Course> findByGrade(@Param("id") Long id);
}