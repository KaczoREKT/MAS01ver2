import java.io.Serializable;

public class Department extends ObjectPlus implements Serializable {
    private String name;
    private static int numberOfDepartments = 0; // atrybut klasowy

    public Department(String name) {
        super();
        this.name = name;
        numberOfDepartments++;
    }

    public static int getNumberOfDepartments() {
        return numberOfDepartments;
    }

    @Override
    public String toString() {
        return "Department{" + "name='" + name + '\'' + '}';
    }
}
