package comparable;

import java.util.*;

public class Implementation {
    public static void main(String[] args) {
         Name nameArray[] = {
            new Name("John", "Smith"),
            new Name("Karl", "Ng"),
            new Name("Jeff", "Smith"),
            new Name("Tom", "Rich")
        };

        List<Name> list = Arrays.asList(nameArray); 
        Collections.sort(list);
        
        System.out.println("Equals of " + list.get(0) + " and " +  list.get(1) + " is " +  list.get(0).equals(list.get(1)));

        System.out.println("All List Names");
        for(Name i : list){
            System.out.println(i.toString());
        }

        System.out.println(list);
    }
}
