package bootcamp.project.users;

import bootcamp.project.courses.Grade;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.*;
import java.util.Collection;

@Entity
@Table(name = "studentTable")
public class Student extends User {

    @OneToMany
    @JoinColumn(name = "id_g")
    private Collection<Grade> grades;

    public Collection<Grade> getGrades() {
        return grades;
    }

    public void setGrades(Collection<Grade> grades) {
        this.grades = grades;
    }

    public Student() {
    }

    public Student(@NotNull @Size(min = 2, max = 30) String name, @NotNull @Size(min = 2, max = 30) String lastname,
                   @NotNull @Size(min = 2, max = 30) String username, @NotNull @Size(min = 6, max = 30) String password,
                   @NotNull @Max(3) @Min(1) int role, @NotNull @Email String email) {
        super(name, lastname, username, password, role, email);
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