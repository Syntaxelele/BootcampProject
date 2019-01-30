package bootcamp.project.repo;

import org.springframework.data.repository.CrudRepository;

import bootcamp.project.courses.Grade;
import bootcamp.project.users.Student;

public interface StudentRepo extends CrudRepository<Student, Long>{
	public Iterable<Student> findByName(String username);
	//public Iterable<Student> findAll(String lastname);
	public Student findByUsernameAndPassword(String username, String password);
	Student findByGrades(Grade grade);
	//just for example
	/*@Query("SELECT ....")
	Student findByMyQuery(String name);*/
}