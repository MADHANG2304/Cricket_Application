package comparator;

import java.time.LocalDate;

public class Employee {
    int id;
    String name;
    double salary;
    LocalDate joiningDate;

    public Employee(int id, String name, double salary, LocalDate joiningDate) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.joiningDate = joiningDate;
    }

    @Override
    public String toString() {
        return id + " " + name + " "
             + salary + " " + joiningDate;
    }
}
