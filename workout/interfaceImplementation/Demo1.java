package interfaceImplementation;
interface Demo1{
    default void print2(){
        System.out.println("Interface2 Print 2");   
    }

    static void print3(){
        System.out.println("Demo1 Static Method");
    }
}