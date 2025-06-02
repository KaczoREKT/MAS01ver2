import java.util.*;

public class Professor extends ObjectPlus {
    private String firstName;
    private String lastName;
    private String title;
    private static List<String> allTitles = new ArrayList<>(); // klasowy

    public Professor(String firstName, String lastName, String title) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        if(!allTitles.contains(title)) allTitles.add(title);
        addExtension(Professor.class, this);
    }

    public static List<String> getAllTitles() {
        return allTitles;
    }

    @Override
    public String toString() {
        return title + " " + firstName + " " + lastName;
    }
}
