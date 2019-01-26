package bootcamp.project.repo;

import org.springframework.data.repository.CrudRepository;

import bootcamp.project.users.User;

public interface UserRepo extends CrudRepository<User, Long>{
	Iterable<User> findByName(String username);
	User findByUsernameAndPassword(String username, String password);
}
