package bootcamp.project.repo;

import bootcamp.project.courses.Course;
import bootcamp.project.users.Professor;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepo extends CrudRepository<Course, Long> {

    Course findByTitle(String title);

    Course findByProfessor(Professor professor);
}