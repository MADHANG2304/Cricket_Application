package comparator;

import java.util.Comparator;

public class SortBySalary
        implements Comparator<Employee> {

    @Override
    public int compare(Employee e1,
                       Employee e2) {

        return Double.compare(
            e2.salary,
            e1.salary
        );
    }
}

