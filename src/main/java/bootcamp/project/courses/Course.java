package bootcamp.project.courses;

import bootcamp.project.users.Professor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "courseTable")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "courseID", unique = true, nullable = false)
    private long courseID;

    @Column(name = "courseTitle")
    private String title;

    @Column(name = "courseDesc", columnDefinition = "varchar(1000)")
    private String description;

    @OneToOne(targetEntity = Professor.class)
    private Professor professor;

    @Column(name = "courseEvaluation")
    private String evaluation;

    @Column(name = "coursePoints")
    private String CP;

    @Column(name = "coursePrereq", columnDefinition = "varchar(1000)")
    private String prereq;

    @Column(name = "courseObjective", columnDefinition = "varchar(1000)")
    private String objective;

    @Column(name = "courseOutcome", columnDefinition = "varchar(1000)")
    private String outcome;

    @Column(name = "courseContent", columnDefinition = "varchar(1000)")
    private String content;

    @OneToMany
    @JoinColumn(name = "id_g")
    private Collection<Grade> gradesInCourse;

    public Course() {
        title = "";
        description = "";
        professor = null;
        evaluation = "";
        CP = "";
        prereq = "";
        objective = "";
        outcome = "";
        content = "";
        gradesInCourse = null;
    }

    public Course(String title, String description, Professor professor, String evaluation, String cP, String prereq, String objective, String outcome, String content) {
        super();
        this.title = title;
        this.description = description;
        this.professor = professor;
        this.evaluation = evaluation;
        this.CP = cP;
        this.prereq = prereq;
        this.objective = objective;
        this.outcome = outcome;
        this.content = content;
    }

    public Course(String title, String description, Professor professor, String courseCode, String evaluation, String cP, String prereq, String objective, String outcome, String content,
                  Collection<Grade> gradesInCourse) {
        super();
        this.title = title;
        this.description = description;
        this.professor = professor;
        this.evaluation = evaluation;
        this.CP = cP;
        this.prereq = prereq;
        this.objective = objective;
        this.outcome = outcome;
        this.content = content;
        this.gradesInCourse = gradesInCourse;
    }

    public Course(String title, Professor professor) {
        super();
        this.title = title;
        this.professor = professor;
    }

    public Course(String title, Professor professor, Collection<Grade> gradesInCourse) {
        super();
        this.title = title;
        this.professor = professor;
        this.gradesInCourse = gradesInCourse;
    }

    public long getCourseID() {
        return courseID;
    }

    public String getTitle() {
        return title;
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

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public String getCP() {
        return CP;
    }

    public void setCP(String CP) {
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

    @Override
    public String toString() {
        return "Course [title=" + title
                + ", description=" + description
                + ", professor=" + professor
                + ", evaluation=" + evaluation
                + ", CP=" + CP
                + ", prereq=" + prereq
                + ", objective=" + objective
                + ", outcome=" + outcome
                + ", content=" + content + "]";
    }
}