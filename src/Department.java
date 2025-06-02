import java.util.*;

public class Department extends ObjectPlus {
    private String name;
    private String building; // atrybut złożony: można zamienić na Address
    private static int numberOfDepartments = 0; // atrybut klasowy

    public Department(String name, String building) {
        this.name = name;
        this.building = building;
        numberOfDepartments++;
        addExtension(Department.class, this);
    }

    public static int getNumberOfDepartments() {
        return numberOfDepartments;
    }

    @Override
    public String toString() {
        return "Department{" + "name='" + name + '\'' + ", building='" + building + '\'' + '}';
    }
}
