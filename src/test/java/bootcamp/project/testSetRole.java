package bootcamp.project;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import bootcamp.project.users.User;
@SpringBootTest
public class testSetRole {

	@Test
	public void testSetRole() {
		User user = new User();
		user.setRole(3);
		assertEquals(3, user.getRole());
			
	}
	@Test
	public void testSetRoleMax() {
		User user = new User();
		user.setRole(4);
		assertEquals(1, user.getRole());
			
	}
	
}