package bootcamp.project.repo;

import org.springframework.data.repository.CrudRepository;

import bootcamp.project.users.Professor;

public interface ProfessorRepo extends CrudRepository<Professor, Long> {
    public Iterable<Professor> findByName(String username);

    public Professor findByUsernameAndPassword(String username, String password);
}
