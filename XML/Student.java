import annotations.StudentAnnotation;
import java.util.List;

public class Student {

    @StudentAnnotation(StudentAnnotation.Type.NAME) String name;
    
    @StudentAnnotation(StudentAnnotation.Type.AGE) int age;
    
    @StudentAnnotation(StudentAnnotation.Type.DEPARTMENT) String dept;

    public List<Subject> subjects;

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


    @StudentAnnotation(StudentAnnotation.Type.NAME)
    public String getName(){
        return name;
    }
    
    @StudentAnnotation(StudentAnnotation.Type.AGE)
    public int getAge(){
        return age;
    }
    
    @StudentAnnotation(StudentAnnotation.Type.DEPARTMENT)
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
