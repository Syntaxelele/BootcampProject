package bootcamp.project.repo;

import bootcamp.project.courses.Grade;
import bootcamp.project.users.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends CrudRepository<Student, Long> {

    Iterable<Student> findByName(String username);

    Student findByUsernameAndPassword(String username, String password);

    Student findByUsername(String username);

    Student findByEmail(String email);

    Student findByGrades(Grade grade);
}