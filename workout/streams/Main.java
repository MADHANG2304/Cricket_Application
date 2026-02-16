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
        
        List<String> res = flatMapResult.stream().flatMap(ele -> Arrays.stream(ele.split(""))).toList(); // Immutable list
        System.out.println("\nFlatMap Result after splitting: " + res);
        // flatMapResult.add("Ranjan"); // Cannnot added because list is immutable
        
        System.out.println();
        flatMapResult.stream().forEach(System.out::print);
        
        System.out.print("\nPeek Result: ");
        List<String> newFlatMapResult = flatMapResult.stream().peek(ele -> System.out.print(ele + ", ")).collect(Collectors.toList()); // Mutable list
        newFlatMapResult.add("Ranjan");
        System.out.println("\nPeek FlatMap Result: " + newFlatMapResult);
        
        
        List<String> name = Arrays.asList("Madhan" , "Rahul" , "Ranjith");
        
        List<String> filterResult = name.stream().filter(ele -> ele.startsWith("R")).toList();
        List<String> filterResult1 = name.stream().filter(ele -> ele.startsWith("R")).collect(Collectors.toList());
        System.out.println("\n\nFilter Result: " + filterResult);
        System.out.println("\n\nFilter Result using Collectors: " + filterResult1);
        
        List<String> mapResult = filterResult.stream().map(String::toUpperCase).toList(); 
        System.out.println("\nMap Result: " + mapResult);
        mapResult = flatMapResult.stream().map(String::toUpperCase).toList();
        System.out.println("\nMap Result: " + mapResult);
        
        List<String> list = Arrays.asList("Naveen" , "Kishore" , "Lokesh" , "Naveen" , "Rahul" , "Kishore");
        List<String> distinctResult = list.stream().distinct().toList();
        System.out.println("\nDistinct Result: " + distinctResult);
        
        Map<String, String> m = list.stream().distinct().collect(Collectors.toMap(x -> x, x -> "New " + x));
        System.out.println("\nMap: " + m);
        

        List<String> friends = Arrays.asList("Naveen" , "Kishore" , "Lokesh" , "Madhan" , "Ranjith" , "Rahul");
        long count = friends.stream().count();
        System.out.println("\nNumber of elemets int list is " + count);

        System.out.println("\nLimit Function: ");
        friends.stream().limit(3).forEach(System.out::println);
        
        System.out.println("\nSkip Function: ");
        friends.stream().skip(3).forEach(System.out::println);

        boolean result = friends.stream().anyMatch(x -> x.contains("a"));
        System.out.println("\nAnyMatch " + result);
        
        result = friends.stream().allMatch(x -> x.contains("a"));
        System.out.println("\nAllMatch Method " + result);
        
        result = friends.stream().noneMatch(x -> x.contains("z"));
        System.out.println("\nNoneMatch Method " + result);
    }
}