import java.util.*;

public class Student extends ObjectPlus{
    private String firstName;
    private String lastName;
    private String middleName; // atrybut opcjonalny
    private List<String> emails = new ArrayList<>(); // powtarzalny
    private Address address; // atrybut złożony
    private Map<Course, Double> grades = new HashMap<>();

    public Student(String firstName, String lastName, Address address) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public Student(String firstName, String lastName, String middleName, Address address) { // przeciążenie
        this(firstName, lastName, address);
        this.middleName = middleName;
    }

    public void addEmail(String email) {
        emails.add(email);
    }

    public void addGrade(Course course, double grade) {
        grades.put(course, grade);
    }

    // atrybut pochodny (wyliczalny)
    public double getAverageGrade() {
        if (grades.isEmpty()) return 0.0;
        double sum = 0;
        for (double g : grades.values()) sum += g;
        return sum / grades.size();
    }

    @Override // przesłonięcie
    public String toString() {
        return "Student{" +
                "imie='" + firstName + '\'' +
                (middleName != null ? ", drugieImie='" + middleName + '\'' : "") +
                ", nazwisko='" + lastName + '\'' +
                ", adres=" + address +
                ", maile=" + emails +
                ", srednia=" + getAverageGrade() +
                '}';
    }
}
