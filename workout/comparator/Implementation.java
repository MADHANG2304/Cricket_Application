package comparator;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Implementation {
    public static void main(String[] args) {

        List<Employee> list = Arrays.asList(

            new Employee(
                3, "Madhan",
                50000,
                LocalDate.of(2022, 5, 10)
            ),

            new Employee(
                1, "Rahul",
                70000,
                LocalDate.of(2021, 3, 15)
            ),

            new Employee(
                2, "Naveen",
                60000,
                LocalDate.of(2023, 1, 5)
            )
        );

        Collections.sort(list, new SortByID());

        System.out.println("\nSort By ID:");
        list.forEach(System.out::println);


        // Sort by Name
        Collections.sort(list, new SortByName());

        System.out.println("\nSort By Name:");
        list.forEach(System.out::println);


        // Sort by Salary
        Collections.sort(list, new SortBySalary());

        System.out.println("\nSort By Salary:");
        list.forEach(System.out::println);
    }
}
