public class Implementation{
    public static void main(String[] args) {
        FunctionalInter s = (a , b) -> (a + b);
        System.out.println("Abstract method result: " + s.add(10, 20)); // Functional interface abstract method called.

        FunctionalInter.print(); // Can call the static mehtod using class reference.
        System.out.println("Static Variable Value: " + FunctionalInter.j); // static variable accessed

        
        System.out.println("Variable Value: " + s.i); // Variable is accessed
        s.print1(); // Defualt method of functional interface is called
    }
}
