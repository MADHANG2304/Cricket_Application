package comparable;

public class Name implements Comparable<Name>{
    private String firstName;
    private String lastName;

    public Name(String firstName , String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int compareTo(Name currName){
        int res = lastName.compareTo(currName.lastName);
        // System.out.println(lastName + " " + currName.lastName);
        // System.out.println(lastName + " " + currName.lastName + " => " + res);
        // System.out.println(firstName + " " + currName.firstName + " FirstName => " + (firstName.compareTo(currName.firstName)));
        return (res != 0 ? res : firstName.compareTo(currName.firstName));
    }

    public boolean equals(Object o){
        if(!(o instanceof Name)){
            return false;
        }

        Name currName = (Name) o;
        return currName.firstName.equals(firstName) && currName.lastName.equals(lastName);
    }

    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}

    public String toString(){
        return firstName + " " + lastName;
    }
    
}
