import java.util.*;

public class Student extends ObjectPlus {
    private String firstName;
    private String lastName;
    private List<String> emails = new ArrayList<>(); // powtarzalny
    private Map<Course, Double> grades = new HashMap<>(); // atrybut złożony

    // atrybut opcjonalny
    private String middleName;

    public Student(String firstName, String lastName, String middleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        addExtension(Student.class, this);
    }

    public Student(String firstName, String lastName) {
        this(firstName, lastName, null);
    }

    public void addEmail(String email) {
        emails.add(email);
    }

    public void addGrade(Course course, double grade) {
        grades.put(course, grade);
    }

    // Atrybut pochodny: średnia ocen
    public double getAverageGrade() {
        if(grades.isEmpty()) return 0.0;
        double sum = 0;
        for(Double g : grades.values()) sum += g;
        return sum / grades.size();
    }

    // Przeciążenie metody (dodanie oceny)
    public void addGrade(Course course, int grade) {
        addGrade(course, (double) grade);
    }

    // Przesłonięcie
    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                (middleName != null ? ", middleName='" + middleName + '\'' : "") +
                ", lastName='" + lastName + '\'' +
                ", emails=" + emails +
                ", averageGrade=" + getAverageGrade() +
                '}';
    }
}
