public class Main {
    public static void main(String[] args) {
        Department it = new Department("Informatyka", "Gmach Główny");
        Department math = new Department("Matematyka", "Budynek B");

        Professor prof1 = new Professor("Anna", "Kowalska", "dr hab.");
        Professor prof2 = new Professor("Jan", "Nowak", "prof.");

        Course javaCourse = new Course("Programowanie w Javie", 6, it, "Zajęcia z programowania obiektowego");
        Course algebra = new Course("Algebra", 5, math);

        javaCourse.addProfessor(prof1);
        algebra.addProfessor(prof2);

        Student student1 = new Student("Kasia", "Wiśniewska", "Maria");
        student1.addEmail("kasia@student.edu");
        student1.addEmail("k.wisniewska@edu.uni");

        Student student2 = new Student("Piotr", "Nowicki");
        student2.addEmail("piotr@uni.edu");

        student1.addGrade(javaCourse, 5.0);
        student1.addGrade(algebra, 4.5);

        student2.addGrade(javaCourse, 4);
        student2.addGrade(algebra, 3);

        // Testy ekstensji
        System.out.println("Wszyscy studenci:");
        for (Object o : ObjectPlus.getExtension(Student.class)) {
            System.out.println(o);
        }

        System.out.println("\nWszyscy wykładowcy:");
        for (Object o : ObjectPlus.getExtension(Professor.class)) {
            System.out.println(o);
        }

        System.out.println("\nWszystkie przedmioty:");
        for (Object o : ObjectPlus.getExtension(Course.class)) {
            System.out.println(o);
        }

        System.out.println("\nLiczba wydziałów: " + Department.getNumberOfDepartments());
        System.out.println("Tytuły naukowe: " + Professor.getAllTitles());
    }
}
+