import java.io.FileWriter;
import java.lang.reflect.Field;

public class XMLWriterExample {
    private static StringBuilder xml = new StringBuilder();

    public static void createStartTag(Field f, StringBuilder xml) {
        xml.append("<").append(f.getName()).append(">");
    }

    public static void createEndTag(Field f, StringBuilder xml) {
        xml.append("</").append(f.getName()).append(">");
    }

    public static void convertToXML(Object o) throws Exception {
        Class<?> cls = o.getClass();

        String root = cls.getName();

        xml.append("<").append(root).append(">");

        Field[] field = cls.getDeclaredFields();

        for (Field f : field) {
            System.out.println(f.getName());
            f.setAccessible(true);

            Class<?> type = f.getType();

            Object value = f.get(o);

            createStartTag(f, xml);
            xml.append(value);
            createEndTag(f, xml);
        }

        xml.append("</").append(root).append(">");

        FileWriter fileWriter = new FileWriter("output.xml");
        fileWriter.write(xml.toString());
        fileWriter.close();

        System.out.println("XML file created successfully");
    }

    public static void main(String[] args) throws Exception {
        Student s = new Student("Madhan", 21, "CSE");
        Address addr = new Address("Chennai", "TN", "India");
        s.setAddress(addr);

        convertToXML(s);
    }
}