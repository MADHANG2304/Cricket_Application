import annotations.StudentAge;
import annotations.StudentDept;
import annotations.StudentName;
import java.util.List;

public class Student {

    @StudentName
    private String name;

    @StudentAge
    private int age;

    @StudentDept
    private String dept;

    private List<Subject> subjects;

    public Address address;

    public Student(String name, int age, String dept) {
        this.name = name;
        this.age = age;
        this.dept = dept;
    }

    public Student() {}

    public void print() {
    }

    public void prints() {
    }

    public void display() {
    }


    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setDept(String dept){
        this.dept = dept;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setSubject(List<Subject> subjects){
        this.subjects = subjects;
    }

    @StudentName
    public String getName(){
        return name;
    }

    @StudentAge
    public int getAge(){
        return age;
    }

    @StudentDept
    public String getDept(){
        return dept;
    }

    public Address getAddress(){
        return address;
    }

    public List<Subject> getSubjects(){
        return subjects;
    }
}
