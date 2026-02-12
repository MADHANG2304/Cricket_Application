package interfaceImplementation;
abstract class Abstract implements Demo{
    // This class was not forced to implement interface methods.
} 

// class demo2 implements demo{
    // This class is forced to implement interface methods.
// }

public class Interface implements Demo , Demo1{
    int i = 20;
    public void print(){
        System.out.println("Class Implementation");
    }
    public void print1(){
        System.out.println("Class Print 1");
    }
    
    public void print2(){ // Multiple Inheritance
        System.out.println("Class Print 2"); // This will not work, when this method is not overriden
    }

    public static void main(String[] args) {
        Interface obj1 = new Interface();
        Demo obj2 = new Interface();
        Demo1 obj3 = new Interface();

        System.out.println(obj1.i); // Output: 20
        System.out.println(obj2.i); // Output: 10
        System.out.println(Demo.i); // Output: 10 

        obj1.print(); // Output: Class Implementation
        obj2.print(); // Output: Class Implementation

        obj1.print1(); // Output: Class Print 1
        obj2.print1(); // Output: Class Print 1

        obj1.print2(); // Output: Class Print 2
        obj2.print2(); // Output: Class Print 2
        obj3.print2(); // Output: Class Print 2

        // obj3.print3(); // This results in error because of static declaration
        Demo1.print3(); // This will work because of call via object
        
    }
}