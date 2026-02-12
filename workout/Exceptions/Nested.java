package exceptions;
public class Nested {
    public static void main(String[] args) {
        try {
            int[] a = new int[3]; // This execute first, once the exception occurs then the nested try-catch will not execute.
            a[5] = 10;
            try {
                int ans = 10 / 0;
            } catch (ArithmeticException e) {
                System.out.println("Arithmetic Exception occured " + e.toString());
                // throw e; This line throw the exception outside catch(Arithmetic Exception).
            }

            // int[] a = new int[3]; // This will execute after the nested try-catch executed.
            // a[5] = 10;
        
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndeOutOfBound Exception occured " + e.toString());
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception occured " + e.toString());
        }
    }
}
