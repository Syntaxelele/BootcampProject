package bootcamp.project.courses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import bootcamp.project.users.Student;

@Entity
@Table(name = "gradeTable")
public class Grade {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_g", unique = true, nullable = false)
	private long id_g;

	@Column(name = "grade")
	@Min(0)
	@Max(10)
	private int grade;

	@ManyToOne(targetEntity = Course.class)
	private Course course;

	@ManyToOne(targetEntity = Student.class)
	private Student student;

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Grade(@NotNull int grade, Course course, Student student) {
		super();
		this.grade = grade;
		this.course = course;
		this.student = student;
	}

	public Grade(@NotNull int grade, Course course) {
		super();
		this.grade = grade;
		this.course = course;
	}

	public Grade() {
	}

	@Override
	public String toString() {
		return "Grade [id_g=" + id_g + ", grade=" + grade + ", course=" + course + ", student=" + student + "]";
	}

}
