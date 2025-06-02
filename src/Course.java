import java.io.Serializable;
import java.util.*;

public class Course extends ObjectPlus implements Serializable {
    private String courseName;
    private int ects;
    private String description; // atrybut opcjonalny
    private Set<Professor> professors = new HashSet<>(); // powtarzalny

    public Course(String courseName, int ects, String description) {
        super();
        this.courseName = courseName;
        this.ects = ects;
        this.description = description;
    }

    public Course(String courseName, int ects) { // przeciążenie (overloading)
        this(courseName, ects, null);
    }

    public void addProfessor(Professor p) {
        professors.add(p);
    }

    @Override // przesłonięcie
    public String toString() {
        return "Course{" + courseName + ", ects=" + ects +
                (description != null ? ", opis=" + description : "") +
                ", profesorowie=" + professors.size() + "}";
    }
}
