package hashcode;

import java.util.HashMap;

public class Main {
    int id;
    String name;

    public Main(int id, String name){
        this.id = id;
        this.name = name;
    }

    public boolean equals(Main m){
        return id == m.id && name.equals(m.name);
    }

    public int hashCode(){
        return id;
    }
    public static void main(String[] args) {
        // String s2 = new String("Madhan");
        String s1 = "Madhan";
        String s2 = "Madhan";
        Main m1 = new Main(1 , "Madhan");
        Main m2 = new Main(2 , "Rahul");
        Main m3 = m1;
        Main m4 = m2;

        HashMap<Main , String> map = new HashMap<>();
        map.put(m1 , "Madhan");
        map.put(m2 , "Rahul");

        System.out.println("Size of Map is " + map.size());
        System.out.println(map.get(m1));
        System.out.println(map.get(m2));
        
        System.out.println("");
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        System.out.println("");
        System.out.println(m1.hashCode());
        System.out.println(m2.hashCode());

        System.out.println("\nm1 & m2 are equal? " + m1.equals(m2));
        System.out.println("m3 & m4 are equal? " + m3.equals(m4));

        System.out.println("\nm1 & m3 are equal? " + m1.equals(m3));
        System.out.println("m2 & m4 are equal? " + m2.equals(m4));
    }
}
