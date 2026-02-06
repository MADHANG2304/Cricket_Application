abstract class Demo{
    int i = 10;

    Demo(){
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