package generic;

import java.util.Arrays;
import java.util.List;

public class Wildcards{
    public static int sum(List<? extends Number> list){
        int total = 0;
        for(Number n : list){
            total += (int)(n);
        }
        return total;
    }
    public static void main(String[] args){
        List<Integer> ld = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(sum(ld));
        
        // List<String> lst = Arrays.asList("Madhan" , "Rahul" , "Naveen");
        // System.out.println(sum(lst)); // argument mismatch; List<String> cannot be converted to List<? extends Number>
    }
}


