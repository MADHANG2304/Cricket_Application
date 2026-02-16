package comparator;

import java.util.Arrays;
import java.util.List;

public class Basic {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 2, 8, 1);

        list.sort((a, b) -> a - b);
        System.out.println("Ascending Order: " + list);

        list.sort((a, b) -> b - a);
        System.out.println("Descending Order: " + list);

        List<String> names = Arrays.asList("Sam", "Alexander", "John");

        names.sort((a, b) -> a.length() - b.length());

        System.out.println("Sorting by length: " + names);

    }
}
