package bootcamp.project.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import bootcamp.project.courses.Course;
import bootcamp.project.courses.Grade;
import bootcamp.project.users.Student;

public interface GradeRepo extends CrudRepository<Grade, Long> {
    ArrayList<Grade> findByStudent(Student s);

    ArrayList<Grade> findByCourse(Course course);
    
    @Query("Select student from Grade where grade >= 0")
    Grade findByGrade(Student stud);
}
