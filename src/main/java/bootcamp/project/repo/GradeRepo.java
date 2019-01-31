package bootcamp.project.repo;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import bootcamp.project.courses.Course;
import bootcamp.project.courses.Grade;
import bootcamp.project.users.Student;

public interface GradeRepo extends CrudRepository<Grade, Long> {
    ArrayList<Grade> findByStudent(Student s);

    ArrayList<Grade> findByCourse(Course course);
    
    public Grade findStudentByGrade(Collection<Grade> collection);
    
    //@Query("select * from Grade where ")
    //Grade findByGrade(int grade);
}
