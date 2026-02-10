@FunctionalInterface
public interface FunctionalInter {

    int i = 10;
    static int j = 20;

    int add(int a , int b);

    // String name(String x); // Should contains only one abstract method.

    default void print1(){
        System.out.println("default functional interface method");
        pvtFunc();
    }

    static void print(){
        System.out.println("Static functional interface method");
    }
    
    private void pvtFunc(){
        System.out.println("Private functional interface method");
    }
}

