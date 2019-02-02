package bootcamp.project;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringRunner;

import bootcamp.project.repo.GradeRepo;
import bootcamp.project.repo.StudentRepo;
import bootcamp.project.users.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRepos {
	@Autowired
	StudentRepo studentRepo;
	GradeRepo graderepo;

	
	@Test
	public void saveStudentTest() {
		Student student = new Student("Anna", "Egle", "egle", "password", 2, "a_egle@mail.com");
		studentRepo.save(student);
		
		Assert.assertNotNull(studentRepo.findByName("egle"));		
	}

	@Test
	public void testStudentByValue() {

		Student student = new Student("Anna", "Egle", "egle", "password", 2, "a_egle@mail.com");
	    assertThat(student.getEmail()).isEqualTo("a_egle@mail.com");
	    }    
	
	@Test
	public void updateRepoValues() {
		Student s = new Student("Andris", "Berzinjs", "andris2", "password", 2, "inbox22@inbox.lv");
		studentRepo.save(s);
		//System.out.println(s.getName() + " " + s.getLastname() + " " + s.getUsername());
		
		Student student = studentRepo.findByUsername("andris2");
		student.setName("Ainars");
		studentRepo.save(student);
		Student student1 = studentRepo.findByUsername("andris2");
		assertEquals("Ainars", student1.getName());
		
		//System.out.println(student.getName()+ " " + student.getLastname() + " " + student.getUsername());
		//System.out.println(s.getName() + " " + s.getLastname() + s.getUsername());
	}
	
	@Test
	public void testValuesStudentRepo() {
		Student student = new Student("Anna", "Egle", "egle", "password", 2, "a_egle@mail.com");
		assertEquals("Anna", student.getName());
		assertEquals("Egle", student.getLastname());
		assertEquals("egle", student.getUsername());
		assertEquals("password", student.getPassword());
		assertEquals(2, student.getRole());
		assertEquals("a_egle@mail.com", student.getEmail());
	}
	
	
	
	/*@Test
	public void deleteFromRepo2() {
		studentRepo.deleteById((long)3);	
		
		try {
			
			Optional <Student> student = studentRepo.findById((long) 3);
		} 
		catch(EmptyResultDataAccessException e){
			System.out.println(e.getMessage());
			//assertEquals(null, student);
			
		}	
	
	*/
	
}
