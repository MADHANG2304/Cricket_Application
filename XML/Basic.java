import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Basic{

    private final int id;
    private final int id1 = 10;

    public Basic(int id){
        this.id = id;
    }

    public int getID(){
        return id;
    }
    public int getId1(){
        return id1;
    }

    public static void main(String[] args) throws Exception {
        Student s = new Student("Madhan", 21, "CSE");

        System.out.println(Student.class.isAssignableFrom(Basic.class)); // Will be true if Basic extends Student or else false.

        Class<?> cls = s.getClass();
        System.out.println("Class Name " + cls);
        System.out.println();
        
        Field[] f = cls.getDeclaredFields();

        System.out.println("\nBefore Updation:");
        for(Field i : f){
            i.setAccessible(true);
            System.out.println(i.get(s));
        }
        
        System.out.println();
        for(Field i : f){
            System.out.println("Field Name: " + i.getName());
            i.setAccessible(true);
            
            if(i.getName().equals("name")){
                i.set(s , "Madhan Ganesan");
                System.out.println("Name Updated Successfully");
            }
            
            // Even if the field is final we can change the value.
            if(i.getName().equals("dept")){
                i.set(s, "Computer Scence And Engineering");
                System.out.println("Department Updated Successfully");
            }
        }
        
        System.out.println("\nAfter Updation:");
        for(Field i : f){
            i.setAccessible(true);
            System.out.println(i.get(s));
        }
        
        System.out.println();
        Constructor[] c = cls.getConstructors();
        for(Constructor i : c){
            System.out.println("Contructor Name: " + i.getName());
        }

        System.out.println();
        Method[] m = cls.getDeclaredMethods();
        for(Method i : m){
            System.out.println("Method Declaration: " + i);
            System.out.println("Method name: " + i.getName());
        }
        System.out.println();

        System.out.println("Field Annotation:");
        for(Field i : f){
            Annotation[] ann = i.getAnnotations();
            for(Annotation j : ann){
                System.out.println(j);
            }
        }
        
        // This only returns the class annotation not the field annotaitons
        // Annotation[] ann = i.getAnnotations();
        // for(Annotation i : ann){
        //     System.out.println(i);
        // }


        Basic b = new Basic(1);

        Field f1 = Basic.class.getDeclaredField("id");
        f1.setAccessible(true);
        System.out.println("\nBefore Setting:");
        System.out.println("Through Getter:");
        System.out.println(b.getID()); // 1
        System.out.println("Through Reflection Getter:");
        System.out.println(f1.get(b)); // 1
        f1.set(b, 100);
        
        Field f2 = Basic.class.getDeclaredField("id1");
        f2.setAccessible(true);
        System.out.println("Through Getter:");
        System.out.println(f2.get(b)); // 10
        System.out.println("Through Reflection Getter:");
        System.out.println(b.getId1()); // 10
        f2.set(b, 200);
        
        System.out.println("\nAfter Setting:");
        System.out.println("Through Getter:");
        System.out.println(b.getID());
        System.out.println(b.getId1());
        System.out.println("Through Reflection Get:");
        System.out.println(f1.get(b)); // 100
        System.out.println(f2.get(b)); // May still print 10
    }
}
