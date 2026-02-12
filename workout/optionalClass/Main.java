package optionalClass;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        Optional emp = Optional.empty();
        Optional a = Optional.of(1);
        // Optional aa = Optional.of(null); // Optional.of() doesn't accept null value , throw exception
        Optional b = Optional.ofNullable(10); 
        Optional c = Optional.ofNullable(emp); // Optional.ofNullable() accept null value and don't throw any error
        
        System.out.println("<--- Empty Value --->");
        System.out.println(emp);
        // System.out.println(aa);
        
        System.out.println("\n<--- Getting Value --->");
        System.out.println(a.get());
        // System.out.println(aa.get());
        System.out.println(b.get());
        System.out.println(c.get());
       
        System.out.println("\n<--- Checking isEmpty Value --->");
        System.out.println(b.isEmpty());
        
        System.out.println("\n<--- Checking isPresent Value --->");
        System.out.println(b.isPresent());
        System.out.println(c.isPresent());

        Optional<String> lst1 = Optional.of("Red");
        Optional<String> lst2 = Optional.empty();

        System.out.println("\nOptional.value: " + lst1 + "  value: " + lst1.get());
        System.out.println(lst2.orElse("\nNo item found"));
        lst1.ifPresent(ele -> System.out.println("\nIt's not empty and it's value is " + ele));
        
        String upperCase = lst1.map(String::toUpperCase).orElse("NONE");
        System.out.println("\nConvert to UpperCase: " + upperCase);

        
        Optional<String> mem1 = Optional.of("Madhan");
        Optional<String> mem2 = Optional.of("Madhan");
        Optional<String> mem3 = Optional.empty();
        
        mem1.filter(name -> name.startsWith("M"))
        .ifPresent(name -> System.out.println("\nFilter passed: " + name));

        mem2.ifPresentOrElse(
        val -> System.out.println("\nFound: " + val + " at mem2"),
        () -> System.out.println("\nValue was missing in mem2")
        );
        mem3.ifPresentOrElse(
        val -> System.out.println("\nFound: " + val + " at mem2"),
        () -> System.out.println("\nValue was missing in mem3")
        );
        
        String temp = mem3.orElseGet(() -> "\nThis is orElseGet Output");
        System.out.println(temp);

        System.out.println("\n<--- Checking equals --->");
        System.out.println(mem1.get() + " and " + mem2.get() + " are equal? " + mem1.equals(mem2));
        System.out.println("\nHashCode: " + mem1.hashCode());

        try {
            System.out.println("\nMem1 will throw error? " + mem1.orElseThrow());
            mem3.orElseThrow();
        } catch (Exception e) {
            System.out.println("\nMem3 Error: " + e);
        }
    }
}
