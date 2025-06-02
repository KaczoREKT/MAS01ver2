import java.util.*;

public class Course extends ObjectPlus {
    private String courseName;
    private int ects;
    private String description; // atrybut opcjonalny
    private Department department;
    private List<Professor> professors = new ArrayList<>(); // powtarzalny

    public Course(String courseName, int ects, Department department, String description) {
        this.courseName = courseName;
        this.ects = ects;
        this.department = department;
        this.description = description;
        addExtension(Course.class, this);
    }

    public Course(String courseName, int ects, Department department) {
        this(courseName, ects, department, null);
    }

    public void addProfessor(Professor prof) {
        professors.add(prof);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", ects=" + ects +
                ", department=" + department +
                ", professors=" + professors +
                '}';
    }
}
