package bootcamp.project.users;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import bootcamp.project.courses.Course;

@Entity
@Table(name="professorTable")
public class Professor extends User {
	
	//@Id
	//@OneToOne
	//@JoinColumn(name="id_u")
	//private long id_p;
	
	@OneToOne
	@JoinColumn(name="courseID")
	private Course course;
	
	//private int role = 1;

	public Professor(@NotNull @Size(min = 2, max = 30) String name, @NotNull @Size(min = 2, max = 30) String lastname,
			@NotNull @Size(min = 2, max = 30) String username, @NotNull @Size(min = 6, max = 30) String password,
			@NotNull @Max(3) @Min(1) int role, @NotNull @Email String email, Course course) {
		super(name, lastname, username, password, role, email);
		this.course = course;
	}
	
	public Professor(@NotNull @Size(min = 2, max = 30) String name, @NotNull @Size(min = 2, max = 30) String lastname,
			@NotNull @Size(min = 2, max = 30) String username, @NotNull @Size(min = 6, max = 30) String password,
			@NotNull @Max(3) @Min(1) int role, @NotNull @Email String email) {
		super(name, lastname, username, password, role, email);
	}

	public Professor() {
	}

	@Override
	public String toString() {
		return "Professor [id_p=" + id_u + ", course=" + course + ", getName()=" + getName() + ", getLastname()="
				+ getLastname() + ", getUsername()=" + getUsername() + ", getRole()=" + getRole() + ", getEmail()="
				+ getEmail() + "]";
	}
	
	
}
