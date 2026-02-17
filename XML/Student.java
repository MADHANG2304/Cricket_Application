import annotations.StudentAge;
import annotations.StudentDept;
import annotations.StudentName;

public class Student {
    @StudentName
    private String name;

    @StudentAge
    private int age;

    @StudentDept
    final private String dept;

    private Address address;

    public Student(String name , int age , String dept){
        this.name = name;
        this.age = age;
        this.dept = dept;
    }

    public Student(){
        dept = "";
    }

    public void print(){}

    public void prints(){}

    public void display(){}

    public void setAddress(Address address){
        this.address = address;
    }
}
