
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class XMLReaderExample{
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(
                new FileReader("C:/Users/Mathan/Desktop/Java/Cricket_Application/XML/output.xml")
            );

            String line;

            while((line = br.readLine() )!= null){
                System.out.println(line);
            }
            
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
        catch (IOException e) {
            System.out.println("IO Exception");
        }

    }
}