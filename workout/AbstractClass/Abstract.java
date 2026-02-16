package abstractClass;

public class Abstract extends Demo1{
    static int i = 20;
    void print(){
        System.out.println("Extended Method");
    }
    
    void print(String s){
        System.out.println("Extended Method with string " + s);
    }
    
    public static void main(String[] args) {
        Demo1 d = new Abstract();
        Abstract a = new Abstract();
        
        System.out.println(i); // Output : 20

        System.out.println(a.i); // Output : 20
        
        System.out.println(d.i); // Output : 10

        d.print("Hello......"); // Output : Exteneded Method with String Hello , Because variable -> reference based, method -> object based
        
        a.print(); // Output : Extended Method
        
        a.print("Hello......"); // Output : Exteneded Method with String Hello

        d.prints(); // Calls parent method prints but using object

        Demo1.prints(); // Calls parent method prints
        
        Demo.prints(); // Calls parent method prints
    }
}