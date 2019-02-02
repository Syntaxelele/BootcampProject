package bootcamp.project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import bootcamp.project.users.User;

@RunWith(SpringRunner.class)
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
		assertEquals("", user.getUsername());
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
		assertEquals(2, user.getRole());
			
	}
	
	/*@Test
	public void testPassNullsToUserConstructor() {
	    try {
	      User user = new User(null, null, null, null, 0, null);
	    } catch (IllegalArgumentException e) {
	    	assertEquals("Error code doesn't match", e.getMessage());
	    }
	  }*/
	
}
