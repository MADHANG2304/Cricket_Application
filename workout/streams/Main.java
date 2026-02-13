package streams;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<List<String>> names = Arrays.asList(
            Arrays.asList("Madhan" , "Rahul" , "Ranjith"),
            Arrays.asList("Naveen", "Kishore", "Lokesh")
        );

        List<String> flatMapResult = names.stream().flatMap(List::stream).toList();
        System.out.println("\nFlatMap Result: " + flatMapResult);
        
        List<String> res = flatMapResult.stream().flatMap(ele -> Arrays.stream(ele.split(""))).toList();
        System.out.println("\nFlatMap Result after splitting: " + res);
        
        System.out.println();
        flatMapResult.stream().forEach(System.out::print);
        
        System.out.print("\nPeek Result: ");
        flatMapResult.stream().peek(ele -> System.out.print(ele + ", ")).collect(Collectors.toList());
        
        List<String> name = Arrays.asList("Madhan" , "Rahul" , "Ranjith");
        
        List<String> filterResult = name.stream().filter(ele -> ele.startsWith("R")).toList();
        System.out.println("\n\nFilter Result: " + filterResult);
        
        List<String> mapResult = filterResult.stream().map(String::toUpperCase).toList(); 
        System.out.println("\nMap Result: " + mapResult);
        mapResult = flatMapResult.stream().map(String::toUpperCase).toList();
        System.out.println("\nMap Result: " + mapResult);
        
        List<String> list = Arrays.asList("Naveen" , "Kishore" , "Lokesh" , "Naveen" , "Rahul" , "Kishore");
        List<String> distinctResult = list.stream().distinct().toList();
        System.out.println("\nDistinct Result: " + distinctResult);
    }
}