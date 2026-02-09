package Generic;

public class Basic<K, V> implements Interface<K, V>{
    private K key;
    private V value;

    public Basic(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey(){return key;}
    public V getValue(){return value;}

    @Override
    public K getName(){
        // System.out.println("Interface K Object");
        return key;
    }
    @Override
    public V getSurName(){
        // System.out.println("Interface V Object");
        return value;
    }

    public static void main(String[] args){
        Basic<String , Integer> b = new Basic<>("Madhan" , 101);
        
        Parent<String, String> p = new Parent<>("Madhan" , "Ganesan");
        
        Interface <String, String> i = new Basic<>("Madhan" , "G");

        System.out.println("Child Class:");
        System.out.println(b.getKey());
        System.out.println(b.getValue());
        
        System.out.println("Parent Class:");
        System.out.println(p.getKey());
        System.out.println(p.getValue());
        
        System.out.println("Interface:");
        System.out.println(i.getName());
        System.out.println(i.getSurName());
    }
}