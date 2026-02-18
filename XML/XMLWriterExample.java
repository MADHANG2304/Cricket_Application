import java.io.FileWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class XMLWriterExample {
    private static StringBuilder xml = new StringBuilder();

    public static void convertFieldsToXML(Object o) throws Exception {
        Class<?> cls = o.getClass();
        Field[] fields = cls.getDeclaredFields();

        for (Field f : fields) {
            f.setAccessible(true);

            Object value = f.get(o);

            createStartTag(f.getName(), xml);
            xml.append(value);
            createEndTag(f.getName(), xml);
        }
    }

    public static void createStartTag(String name, StringBuilder xml) {
        xml.append("<").append(name).append(">");
    }

    public static void createEndTag(String name, StringBuilder xml) {
        xml.append("</").append(name).append(">");
    }

    public static void convertToXML(Object o) throws Exception {
        Class<?> cls = o.getClass();

        String root = cls.getName();

        if (!xml.toString().startsWith("<?xml")) {
            xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        }

        xml.append("<").append(root).append(">");

        Field[] field = cls.getDeclaredFields();
        Method[] methods = cls.getDeclaredMethods();

        for (Field f : field) {
            f.setAccessible(true);

            Class<?> type = f.getType();
            Object value = f.get(o);

            // boolean isPrivate = Modifier.isPrivate(f.getModifiers());

            // For list :-
            if (List.class.isAssignableFrom(type)) {
                List<?> list = (List<?>) value;

                if (list != null && !list.isEmpty()) {
                    createStartTag(f.getName(), xml);

                    // Method[] methods = cls.getDeclaredMethods();
                    // for(Method m : methods){
                    // if(m.getName().startsWith("get")){
                    // Object val = m.invoke(o);
                    // System.out.println("Method name: " + m.getName() + " Value: " + val);
                    // }
                    // }

                    for (Object item : list) {
                        createStartTag(item.getClass().getSimpleName(), xml);
                        convertFieldsToXML(item);
                        createEndTag(item.getClass().getSimpleName(), xml);
                    }

                    createEndTag(f.getName(), xml);
                }
            }

            // For normal type :-
            else if (isNormal(type)) {

                // Annotation[] currAnn = f.getDeclaredAnnotations();
                // for(Annotation a : currAnn){
                //     Class<?> fieldAnnType = a.annotationType();
                //     for(Method m : methods){
                //         Annotation methodAnn = m.getAnnotation((Class<Annotation>) fieldAnnType);
                //         if(methodAnn != null && a.equals(methodAnn)){
                //             Object currValue = m.invoke(o);
                //             System.out.println(currValue);
                //         }
                //     }
                // }

                createStartTag(f.getName(), xml);
                xml.append(value);
                createEndTag(f.getName(), xml);
            }

            // For nested objects :-
            else if (value != null) {
                createStartTag(f.getName(), xml);
                // convertToXML(value); // Same Class name tag repeats
                convertFieldsToXML(value);
                createEndTag(f.getName(), xml);
            }
        }

        xml.append("</").append(root).append(">");

        try (FileWriter fileWriter = new FileWriter("output.xml")) {
            fileWriter.write(xml.toString());
            System.out.println("XML file created successfully");
        }

    }

    public static boolean isNormal(Class type) {
        return (type.isPrimitive()
                || type == String.class
                || type == Boolean.class
                || type == Character.class
                || type.isEnum()
                || type.isAnnotation()
                || type.getPackageName().startsWith("java."));
    }

    public static void main(String[] args) throws Exception {
        Student s = new Student("Madhan", 21, "CSE");
        Address addr = new Address("Chennai", "TN", "India");
        Subject subject1 = new Subject("OS", "Jasmine", 80, "B+");
        Subject subject2 = new Subject("CN", "Manimegala", 85, "A");
        Subject subject3 = new Subject("DSA", "Sasikala", 90, "A+");
        Subject subject4 = new Subject("CO", "MohanaPriya", 85, "A");
        Subject subject5 = new Subject("DBMS", "Dhivya", 94, "A+");

        List<Subject> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);
        subjects.add(subject3);
        subjects.add(subject4);
        subjects.add(subject5);

        s.setAddress(addr);
        s.setSubject(subjects);

        convertToXML(s);

        System.out.println("\n<-----     The XML File:     ----->");
        System.out.println(xml);
    }
}