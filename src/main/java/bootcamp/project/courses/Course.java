package bootcamp.project.courses;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import bootcamp.project.users.Professor;

@Entity
@Table(name = "courseTable")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "courseID")
    private long courseID;

    @NotNull
    @Column(name = "courseTitle")
    private String title;

    @NotNull
    @Column(name = "courseDesc")
    private String description;

	@NotNull
	@OneToOne(mappedBy="course")
	private Professor courseProfessor;

    @NotNull
    @Column(name = "courseCode")
    private String courseCode;

    @NotNull
    @Column(name = "courseEvaluation")
    private String evaluation;

    @NotNull
    @Column(name = "coursePoints")
    private int CP;

    @NotNull
    @Column(name = "coursePrereq")
    private String prereq;

    @NotNull
    @Column(name = "courseObjective")
    private String objective;

    @NotNull
    @Column(name = "courseOutcome")
    private String outcome;

    @NotNull
    @Column(name = "courseContent")
    private String content;

    @OneToMany
	@JoinColumn(name="id_g")
	private Collection<Grade> gradesInCourse;
    

	public Course() {
        title = "";
        description = "";
        courseProfessor = null;
        courseCode = "";
        evaluation = "";
        CP = 0;
        prereq = "";
        objective = "";
        outcome = "";
        content = "";
        gradesInCourse = null;
    }

 public Course(@NotNull String title, @NotNull String description, @NotNull Professor courseProfessor,
			@NotNull String courseCode, @NotNull String evaluation, @NotNull int cP, @NotNull String prereq,
			@NotNull String objective, @NotNull String outcome, @NotNull String content) {
		super();
		this.title = title;
		this.description = description;
		this.courseProfessor = courseProfessor;
		this.courseCode = courseCode;
		this.evaluation = evaluation;
		CP = cP;
		this.prereq = prereq;
		this.objective = objective;
		this.outcome = outcome;
		this.content = content;
	}

    public long getCourseID() {
        return courseID;
    }
    
    public String getTitle() {
		return title;
	}

    public Course(@NotNull String title, @NotNull String description, @NotNull Professor courseProfessor,
			@NotNull String courseCode, @NotNull String evaluation, @NotNull int cP, @NotNull String prereq,
			@NotNull String objective, @NotNull String outcome, @NotNull String content,
			Collection<Grade> gradesInCourse) {
		super();
		this.title = title;
		this.description = description;
		this.courseProfessor = courseProfessor;
		this.courseCode = courseCode;
		this.evaluation = evaluation;
		CP = cP;
		this.prereq = prereq;
		this.objective = objective;
		this.outcome = outcome;
		this.content = content;
		this.gradesInCourse = gradesInCourse;
	}
    
	public Course(@NotNull String title, @NotNull Professor courseProfessor) {
		super();
		this.title = title;
		this.courseProfessor = courseProfessor;
	}

	public Course(@NotNull String title, @NotNull Professor courseProfessor, Collection<Grade> gradesInCourse) {
		super();
		this.title = title;
		this.courseProfessor = courseProfessor;
		this.gradesInCourse = gradesInCourse;
	}
/*	public String getTitle() {
        return title;
    }*/
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Professor getCourseProfessor() {
		return courseProfessor;
	}
	public void setCourseProfessor(Professor courseProfessor) {
		this.courseProfessor = courseProfessor;
	}
	
	public Collection<Grade> getGradesInCourse() {
		return gradesInCourse;
	}
	public void setGradesInCourse(Collection<Grade> gradesInCourse) {
		this.gradesInCourse = gradesInCourse;
	}
	
	public String getCourseCode() {
        return courseCode;
    }
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getEvaluation() {
        return evaluation;
    }
    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public int getCP() {
        return CP;
    }
    public void setCP(int CP) {
        this.CP = CP;
    }

    public String getPrereq() {
        return prereq;
    }
    public void setPrereq(String prereq) {
        this.prereq = prereq;
    }

    public String getObjective() {
        return objective;
    }
    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getOutcome() {
        return outcome;
    }
    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    @Override
	public String toString() {
		return "Course [courseID=" + courseID + ", title=" + title + ", description=" + description
				+ ", courseProfessor=" + courseProfessor + ", courseCode=" + courseCode + ", evaluation=" + evaluation
				+ ", CP=" + CP + ", prereq=" + prereq + ", objective=" + objective + ", outcome=" + outcome
				+ ", content=" + content + "]";
	}
}