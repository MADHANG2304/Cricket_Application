package immutability;
import java.util.*;

public final class User {
    private final String userName;
    private final List<String> roles;

    public User(String userName , List<String> roles){
        this.userName = userName;
        this.roles = new ArrayList<>(roles);
    }

    public String getUserName(){
        return userName;
    }

    public List<String> getRoles(){
        return Collections.unmodifiableList(roles);
    } 

    public void display(){
        System.out.println("UserName: " + userName + "Roles: " + roles);
    }

    public static void main(String[] args) {
        ArrayList<String> roles = new ArrayList<>();
        roles.add("Admin");
        User u = new User("Madhan", roles);

        System.out.println("Currret Roles: " + roles);

        roles.add("Manager");
        
        System.out.println("UserName: " + u.getUserName());
        System.out.print("Object Roles: ");
        u.display();

        System.out.println("Currret Roles after insertion: " + roles);

        // u.roles;
        // System.out.println("Object Roles after insertion: " + u.getRoles());
    }
}
