abstract class demo{
    int i = 10;

    demo(){
        System.out.println("Constructor"); // Printed when we create object for the child class
    }

    abstract void print();

    void print(String s){
        System.out.println("Print statement with print " + s);
    }

    static void prints()
    {
        // Create static method inside the body
    }
} 

abstract class demo1 extends demo{
    // No implementation required for not method
}

public class Abstract extends demo1{
    static int i = 20;
    void print(){
        System.out.println("Extended Method");
    }
    
    void print(String s){
        System.out.println("Extended Method with string " + s);
    }
    
    public static void main(String[] args) {
        demo1 d = new Abstract();
        Abstract a = new Abstract();
        
        System.out.println(i); // Output : 20

        System.out.println(a.i); // Output : 20
        
        System.out.println(d.i); // Output : 10

        d.print("Hello......"); // Output : Exteneded Method with String Hello , Because variable -> reference based, method -> object based
        
        a.print(); // Output : Extended Method
        
        a.print("Hello......"); // Output : Exteneded Method with String Hello
    }
}