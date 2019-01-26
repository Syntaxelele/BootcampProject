package bootcamp.project.courses;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "courseTable")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "courseID")
    private int courseID;

    @NotNull
    @Column(name = "courseTitle")
    private String title;

    @NotNull
    @Column(name = "courseDesc")
    private String description;

    @NotNull
    @Column(name = "courseProfessor")
    private int professor;

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

    public Course() {
        title = "";
        description = "";
        professor = 0;
        courseCode = "";
        evaluation = "";
        CP = 0;
        prereq = "";
        objective = "";
        outcome = "";
        content = "";
    }
    public Course
            (String tit, String desc, int prof, String code,
             String eval, int cp, String prer, String obj, String outc, String cont) {

        setTitle(tit);
        setDescription(desc);
        setProfessor(prof);
        setCourseCode(code);
        setEvaluation(eval);
        setCP(cp);
        setPrereq(prer);
        setObjective(obj);
        setOutcome(outc);
        setContent(cont);

    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getTitle() {
        return title;
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

    public int getProfessor() {
        return professor;
    }

    public void setProfessor(int professor) {
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

    @Override
    public String toString() {
        return "Course{" +
                "courseID=" + courseID +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", professor=" + professor +
                ", courseCode='" + courseCode + '\'' +
                ", evaluation='" + evaluation + '\'' +
                ", CP=" + CP +
                ", prereq='" + prereq + '\'' +
                ", objective='" + objective + '\'' +
                ", outcome='" + outcome + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}