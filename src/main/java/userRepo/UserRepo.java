package userRepo;

import org.springframework.data.repository.CrudRepository;

import bootcamp.project.users.User;

public interface UserRepo extends CrudRepository<User, Long>{
	public Iterable<User> findByName(String username);
}
