import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String file = "extents.bin";
        boolean fromFile = false;

        // Próbujemy wczytać ekstensję z pliku
        File extFile = new File(file);
        if (extFile.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                ObjectPlus.readExtents(in);
                fromFile = true;
                System.out.println("[INFO] Wczytano ekstensje z pliku.");
            } catch (Exception e) {
                System.out.println("[WARN] Nie udało się wczytać ekstensji z pliku, utworzę nowe dane.");
            }
        }

        // Jeśli ekstensje są puste, to tworzymy przykładowe dane
        if (isExtentEmpty(Student.class) || isExtentEmpty(Course.class)) {
            System.out.println("[INFO] Tworzę przykładowe dane...");
            addSampleData();
        }

        // Wyświetl ekstensje
        ObjectPlus.showExtent(Student.class);
        ObjectPlus.showExtent(Course.class);
        System.out.println("Liczba wydziałów: " + Department.getNumberOfDepartments());

        // Na koniec - zapisujemy ekstensje do pliku
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            ObjectPlus.writeExtents(out);
            System.out.println("[INFO] Zapisano ekstensje do pliku.");
        }
    }

    // Funkcja sprawdzająca czy ekstensja danej klasy jest pusta
    private static boolean isExtentEmpty(Class<?> clas) {
        try {
            Iterable<?> extent = ObjectPlus.getExtent(clas);
            return !extent.iterator().hasNext();
        } catch (Exception e) {
            return true;
        }
    }

    // Funkcja dodająca przykładowe dane
    private static void addSampleData() {
        Address ad1 = new Address("ul. Polna 5", "Warszawa");
        Department d1 = new Department("Informatyka");
        Professor p1 = new Professor("Anna", "Kowalska", "dr hab.", ad1);
        Course c1 = new Course("Programowanie Java", 6, "Programowanie obiektowe");
        c1.addProfessor(p1);
        Student s1 = new Student("Kasia", "Wiśniewska", "Maria", ad1);
        s1.addEmail("kasia@student.edu");
        s1.addGrade(c1, 5.0);
    }
}
