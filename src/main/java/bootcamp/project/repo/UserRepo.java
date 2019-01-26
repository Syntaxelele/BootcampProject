package bootcamp.project.repo;

import org.springframework.data.repository.CrudRepository;

import bootcamp.project.users.User;

public interface UserRepo extends CrudRepository<User, Long>{
	public Iterable<User> findByName(String username);
	public User findByUsernameAndPassword(String username, String password);
}
//aa
