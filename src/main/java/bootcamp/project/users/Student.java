package bootcamp.project.users;

import java.util.Collection;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import bootcamp.project.courses.Course;
import bootcamp.project.courses.Grade;

@Entity
@Table(name = "studentTable")
public class Student extends User {

	@OneToMany
	@JoinColumn(name = "id_g")
	private Collection<Grade> grades;

	public Student() {
	}

	public Student(@NotNull @Size(min = 2, max = 30) String name, @NotNull @Size(min = 2, max = 30) String lastname,
			@NotNull @Size(min = 2, max = 30) String username, @NotNull @Size(min = 6, max = 30) String password,
			@NotNull @Max(3) @Min(1) int role, @NotNull @Email String email) {
		super(name, lastname, username, password, role, email);
	}

	public Collection<Grade> getGrades() {
		return grades;
	}

	public void setGrades(Collection<Grade> grades) {
		this.grades = grades;
	}

	public Student(@NotNull @Size(min = 2, max = 30) String name, @NotNull @Size(min = 2, max = 30) String lastname,
			@NotNull @Size(min = 2, max = 30) String username, @NotNull @Size(min = 6, max = 30) String password,
			@NotNull @Max(3) @Min(1) int role, @NotNull @Email String email, Collection<Grade> grades) {
		super(name, lastname, username, password, role, email);
		this.grades = grades;
	}

	@Override
	public String toString() {
		return "Student [grades=" + grades + ", getId_u()=" + getId_u() + ", getName()=" + getName()
				+ ", getLastname()=" + getLastname() + ", getUsername()=" + getUsername() + ", getEmail()=" + getEmail()
				+ "]";
	}
}