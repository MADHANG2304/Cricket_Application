public class Implementation{
    public static void main(String[] args) {
        FunctionalInter s = (a , b) -> (a + b);
        System.out.println(s.add(10, 20)); // Functional interface abstract method called.

        FunctionalInter.print(); // Can call the static mehtod using class reference.
        System.out.println(FunctionalInter.j); // Variable is accessed

        
        System.out.println(s.i); // Variable is accessed
        s.print1(); // Defualt method of functional interface is called
        
    }
}
