package bootcamp.project.repo;

import org.springframework.data.repository.CrudRepository;

import bootcamp.project.courses.Grade;
import bootcamp.project.users.Student;

public interface StudentRepo extends CrudRepository<Student, Long> {
	public Iterable<Student> findByName(String username);

	public Student findByUsernameAndPassword(String username, String password);

	public Student findByUsername(String username);

	public Student findByEmail(String email);

	Student findByGrades(Grade grade);
}