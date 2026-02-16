package generic;
import java.util.*;

public class Map<K , V> implements MapInterface<K, V>{
    private HashMap<K , V> map = new HashMap<>();

    public void set(K key , V value){
        map.put(key , value);
    }

    public V getValue(K key){
        return map.get(key);
    }

    public void display(){
        for(HashMap.Entry<K , V> i : map.entrySet()){
            System.out.println("Key: " + i.getKey() + ", Value: " + i.getValue());
        }
    }

    public static void main(String[] args) {
        Map<Integer, String> m = new Map<>();
        
        m.set(1, "Madhan");
        m.set(2, "Rahul");
        m.set(3, "Kishore");

        // m.set("Madhan" , 1); // Type mismatch for <Integer, String>  
        
        System.out.println(m.getValue(1));

        System.out.println("All Data of <Integer , String>:");
        m.display();
        
        Map<String , Double> m2 = new Map<>();
        
        m2.set("HP", 65000.920);
        m2.set("LENOVO", 55000.00);
        m2.set("DELL", 45000.00);
        
        System.out.println("\nAll Data <String , Double>:");
        m2.display();
    }
}