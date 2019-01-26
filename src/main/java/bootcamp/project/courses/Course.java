package bootcamp.project.courses;

public class Course {
    private String name;
    private String description;
    public Course(){
        name = "";
        description = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDesciption(String desc) {
        this.description = desc;
    }
}
