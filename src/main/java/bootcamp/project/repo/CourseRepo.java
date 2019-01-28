package bootcamp.project.repo;

import org.springframework.data.repository.CrudRepository;

import bootcamp.project.courses.Course;

public interface CourseRepo extends CrudRepository<Course, Long> {
	Course findByTitle(String title);
}
