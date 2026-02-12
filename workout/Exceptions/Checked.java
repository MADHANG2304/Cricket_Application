package exceptions;
import java.io.*;
import java.util.*;

public class Checked {
    public static void main(String[] args) {
        // public static void main(String[] args) throws IOException{ // Exception in
        // thread "main" java.io.FileNotFoundException: java\Java - Topics.txt (The
        // system cannot find the path specified)
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the Root directory: ");
        String root = scan.nextLine();
        System.out.println("\nRoot: " + root);

        String path = root + "\\Java - Topics.txt";
        System.out.println("Path: " + (path));

        // FileReader file = new FileReader(path); // error: unreported exception
        // FileNotFoundException; must be caught or declared to be thrown

        // BufferedReader br = new BufferedReader(file);

        // for(int i = 0;i < 3; i++){
        // System.out.println(br.readLine()); // error: unreported exception
        // IOException; must be caught or declared to be thrown
        // }

        // file.close(); // error: unreported exception IOException; must be caught or
        // declared to be thrown


        // Try with Resources :-

        // List<Integer> list = new ArrayList<>();
        // try (FileWriter f = new FileWriter("OutFile.txt"); // Try with resource, which automaticaaly closes the PrintWriter and FileWriter
        //         PrintWriter out = new PrintWriter(f)) {
        //     for (int i = 0; i < 10; i++) {
        //         out.println("Value at: " + i + " = " + list.get(i));
        //     }
        // }

        
        try {
            FileReader file = new FileReader(path);

            BufferedReader br = new BufferedReader(file);

            System.out.println("\nLines of the read file:\n");
            for (int i = 0; i < 10; i++) {
                System.out.println(br.readLine());
            }

            file.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("An I/O error: " + e.getMessage());
        }
    }
}
