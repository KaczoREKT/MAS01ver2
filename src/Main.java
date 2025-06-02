import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String file = "extents.bin";
        List<Class<?>> extentClasses = Arrays.asList(
                Student.class, Professor.class, Course.class, Department.class
        );

        boolean shouldSave = false;

        // Próbujemy wczytać ekstensje z pliku
        File extFile = new File(file);
        if (extFile.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                ObjectPlus.readExtents(in);
                System.out.println("[INFO] Wczytano ekstensje z pliku " + file + ".");
            } catch (Exception e) {
                System.out.println("[WARN] Nie udało się wczytać ekstensji z pliku, utworzę nowe dane.");
                addSampleData();
                shouldSave = true;
            }
        } else {
            // Pliku nie ma, więc tworzymy przykładowe dane i zapisujemy
            System.out.println("[INFO] Tworzę przykładowe dane do pliku " + file + ".");
            addSampleData();
            shouldSave = true;
        }

        // Pokazujemy ekstensje dla wszystkich klas
        System.out.println("\n=== EKSTENSJE WSZYSTKICH KLAS ===");
        for (Class<?> clazz : extentClasses) {
            try {
                ObjectPlus.showExtent(clazz);
            } catch (Exception e) {
                System.out.println("[INFO] Brak ekstensji dla klasy " + clazz.getSimpleName());
            }
            System.out.println("--------------------------------");
        }

        // Zapisujemy tylko jeśli generowaliśmy nowe dane (czyli nie było pliku lub był uszkodzony)
        if (shouldSave) {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
                ObjectPlus.writeExtents(out);
                System.out.println("[INFO] Zapisano ekstensje do pliku.");
            }
        }
    }

    private static boolean isExtentEmpty(Class<?> clazz) {
        try {
            Iterable<?> extent = ObjectPlus.getExtent(clazz);
            return !extent.iterator().hasNext();
        } catch (Exception e) {
            return true;
        }
    }

    private static void addSampleData() {
        Address ad1 = new Address("ul. Polna 5", "Warszawa");
        Address ad2 = new Address("ul. Polna 12", "Warszawa");
        Department d1 = new Department("Informatyka");
        Department d2 = new Department("Matematyka");
        Professor p1 = new Professor("Michał", "Tomaszewski", "dr hab.", ad1);
        Professor p2 = new Professor("Adam", "Szmigielski", "dr hab.", ad2);
        Course c1 = new Course("PPJ", 6, "Podstawy programowania w języku Java");
        Course c2 = new Course("AM", 5, "Analiza Matematyczna");
        c1.addProfessor(p1);
        c2.addProfessor(p2);
        Student s1 = new Student("Jeremiasz", "Surma", "Maria", ad1);
        Student s2 = new Student("Zarin", "Modreycak", ad2);
        s1.addEmail("s28876@pjwstk.edu.pl");
        s1.addGrade(c1, 5.0);
        s2.addEmail("s23462@pjwstk.edu.pl");
        s2.addGrade(c2, 4.0);
    }
}
