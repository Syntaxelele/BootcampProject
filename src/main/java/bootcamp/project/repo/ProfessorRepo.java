package bootcamp.project.repo;

import bootcamp.project.users.Professor;
import org.springframework.data.repository.CrudRepository;

public interface ProfessorRepo extends CrudRepository<Professor, Long> {

    Iterable<Professor> findByName(String username);

    Professor findByNameAndLastname(String name, String lastname);

    Professor findByUsernameAndPassword(String username, String password);

    Professor findByUsername(String username);

    Professor findByEmail(String email);

}
