package generic;

public class GenericMethod<T> {

    private T t;

    public static <K , V> boolean comapre(Parent< K , V> p1 , Parent<K, V> p2){
        return (p1.getKey().equals(p2.getKey())) && (p1.getValue().equals(p2.getValue()));
    }

    public static <K , V> boolean comapareKey(Parent< K , V> p1 , Parent<K, V> p2){
        return (p1.getKey().equals(p2.getKey()));
    }

    public static <T extends Number> boolean find(T t){
        System.out.println("T's value is " + t);
        return true;
    }

    public static <T> int count(T[] arr , T ele){
        int counter = 0;

        // for(T i : arr){
        //     if(i > ele){
        //         count++;
        //     }
        // } // This will not work because > operator is used  only for primitive data types

        // for(T i : arr){
        //     if(i.compareTo(ele) > 0){
        //         counter++;
        //     }
        // } // We can overrride the compareTo method for comparison and handle this

        return counter;
    } 

    public void set(T t){
        this.t = t;
    } 

    public static void main(String[] args) {
        Parent<String, String> p1 = new Parent<>("Madhan" , "Ganesan");
        Parent<String, String> p2 = new Parent<>("Madhan" , "Ganesan");

        boolean ans = comapre(p1, p2); // Compare using the Generic type parameter.
        System.out.println("This is the compare method result: " + ans);

        System.out.println("This is compareKey Method result: " + comapareKey(p1, p2));

        GenericMethod<Integer> gm = new GenericMethod<>();
        gm.set(10);
        System.out.println("This is bounding type parameter setter " + gm.t);
        System.out.println("This is bounding type parameter working status " + find(10));

        // System.out.println("This is bournding type parameter " + find("Madhan")); // error: method find in class GenericMethod<T#2> cannot be applied to given types.
        // System.out.println("This is bournding type parameter " + find(new String("Madhan"))); This cannot be done because the method extended Number.
    }
}