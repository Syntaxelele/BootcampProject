package bootcamp.project;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import bootcamp.project.users.User;

@SpringBootTest
public class TestUser {
	@Test
	public void TestName() {
		User user = new User();
		user.setName("Janis987");
		assertEquals("", user.getName());
	}

	@Test
	public void testSetLastName() {
		User user = new User();
		user.setLastname("Liepa");
		assertEquals("Liepa", user.getLastname());
	}
	
	@Test
	public void testIfUsernameEquals() {
		User user = new User();
		user.setUsername("noob123");
		assertEquals("noob123", user.getUsername());
	}
	@Test
	public void testIfUsernameIsWrong() {
		User user = new User();
		user.setUsername("noob^%@");
		assertEquals("none", user.getUsername());
	}
	
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
