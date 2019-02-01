package bootcamp.project.repo;

import bootcamp.project.courses.Course;
import bootcamp.project.courses.Grade;
import bootcamp.project.users.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface GradeRepo extends CrudRepository<Grade, Long> {

    ArrayList<Grade> findByStudent(Student s);

    ArrayList<Grade> findByCourse(Course course);
}
