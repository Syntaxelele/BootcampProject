package bootcamp.project.users;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "professorTable")
public class Professor extends User {

	public Professor(@NotNull @Size(min = 2, max = 30) String name, @NotNull @Size(min = 2, max = 30) String lastname,
			@NotNull @Size(min = 2, max = 30) String username, @NotNull @Size(min = 6, max = 30) String password,
			@NotNull @Max(3) @Min(1) int role, @NotNull @Email String email) {
		super(name, lastname, username, password, role, email);
	}

	public Professor() {
	}

	@Override
	public String toString() {
		return " " + getName() + " " + getLastname() + ", " + getEmail();
	}
}