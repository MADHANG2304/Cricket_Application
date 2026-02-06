interface Demo {
    int i = 10;
    void print();
    abstract void print1();
    
    default void print2(){
        System.out.println("Interface1 Print 2");   
    }
}