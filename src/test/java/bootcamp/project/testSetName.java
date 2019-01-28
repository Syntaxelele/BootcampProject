package bootcamp.project;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import bootcamp.project.users.User;

@SpringBootTest
public class testSetName {
	@Test
	public void TestName() {
		User user = new User();
		user.setName("Janis987");
		assertEquals(null, user.getName());
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
		assertEquals(null, user.getUsername());
	}
	
}
