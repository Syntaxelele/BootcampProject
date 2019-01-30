package bootcamp.project.courses;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import bootcamp.project.users.Professor;
import bootcamp.project.users.Student;

@Entity
@Table(name = "courseTable")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "courseID")
    private long courseID;

    @Column(name = "courseTitle")
    private String title;

    @Column(name = "courseDesc", columnDefinition="varchar(1000)")
    private String description;

    @OneToOne(targetEntity = Professor.class)
    private Professor professor;

    //@OneToOne(targetEntity=Student.class)
    //private Student student;

    @Column(name = "courseCode")
    private String courseCode;

    @Column(name = "courseEvaluation")
    private String evaluation;

    @Column(name = "coursePoints")
    private int CP;

    @Column(name = "coursePrereq", columnDefinition="varchar(1000)")
    private String prereq;

    @Column(name = "courseObjective", columnDefinition="varchar(1000)")
    private String objective;

    @Column(name = "courseOutcome", columnDefinition="varchar(1000)")
    private String outcome;

    @Column(name = "courseContent", columnDefinition="varchar(1000)")
    private String content;

    @OneToMany
    @JoinColumn(name = "id_g")
    private Collection<Grade> gradesInCourse;


    public Course() {
        title = "";
        description = "";
        professor = null;
        courseCode = "";
        evaluation = "";
        CP = 0;
        prereq = "";
        objective = "";
        outcome = "";
        content = "";
        gradesInCourse = null;
    }

    public Course(@NotNull String title, @NotNull String description, @NotNull Professor professor,
                  @NotNull String courseCode, @NotNull String evaluation, @NotNull int cP, @NotNull String prereq,
                  @NotNull String objective, @NotNull String outcome, @NotNull String content) {
        super();
        this.title = title;
        this.description = description;
        this.professor = professor;
        this.courseCode = courseCode;
        this.evaluation = evaluation;
        this.CP = cP;
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

    public Course(@NotNull String title, @NotNull String description, @NotNull Professor professor,
                  @NotNull String courseCode, @NotNull String evaluation, @NotNull int cP, @NotNull String prereq,
                  @NotNull String objective, @NotNull String outcome, @NotNull String content,
                  Collection<Grade> gradesInCourse) {
        super();
        this.title = title;
        this.description = description;
        this.professor = professor;
        this.courseCode = courseCode;
        this.evaluation = evaluation;
        this.CP = cP;
        this.prereq = prereq;
        this.objective = objective;
        this.outcome = outcome;
        this.content = content;
        this.gradesInCourse = gradesInCourse;
    }

    public Course(@NotNull String title, @NotNull Professor professor) {
        super();
        this.title = title;
        this.professor = professor;
    }

    public Course(@NotNull String title, @NotNull Professor professor, Collection<Grade> gradesInCourse) {
        super();
        this.title = title;
        this.professor = professor;
        this.gradesInCourse = gradesInCourse;
    }

    public void setCourseID(long courseID) {
        this.courseID = courseID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
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

    public Collection<Grade> getGradesInCourse() {
        return gradesInCourse;
    }

    public void setGradesInCourse(Collection<Grade> gradesInCourse) {
        this.gradesInCourse = gradesInCourse;
    }

    /*
        public Student getStudent() {
            return student;
        }

        public void setStudent(Student student) {
            this.student = student;
        }
    */
    @Override
    public String toString() {
        return "Course [courseID=" + courseID + ", title=" + title + ", description=" + description
                + ", professor=" + professor + ", courseCode=" + courseCode + ", evaluation=" + evaluation
                + ", CP=" + CP + ", prereq=" + prereq + ", objective=" + objective + ", outcome=" + outcome
                + ", content=" + content + "]";
    }
}