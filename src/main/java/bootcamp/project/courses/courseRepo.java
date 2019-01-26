package bootcamp.project.courses;

import org.springframework.data.repository.CrudRepository;

public interface courseRepo extends CrudRepository<Course, String> {
}
