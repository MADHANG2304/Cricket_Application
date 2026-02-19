
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Stack;

public class ObjectWriter {

    public static Object parseToObject(String path, Class<?> rootClass) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(path));

        Object rootObject = rootClass.getDeclaredConstructor().newInstance();

        Stack<Object> objStack = new Stack<>();
        Stack<String> tagStack = new Stack<>();

        objStack.push(rootObject);

        String line;

        while ((line = br.readLine()) != null) {
            line = line.trim();

            if (line.isEmpty() || line.startsWith("<?")) {
                continue;
            }

            if (line.startsWith("<") && !line.startsWith("</")) {
                String tag = line.substring(1, line.indexOf(">"));
                tagStack.push(tag);

                Object parent = objStack.peek();

                Field field = getField(parent, tag);
                if (field != null) {
                    // System.out.println("Field: " + field.getName());
                    field.setAccessible(true);
                    Class<?> type = field.getType();

                    if (isNormal(type)) {
                        continue;
                    }

                    else if (List.class.isAssignableFrom(type)) {
                        ParameterizedType pType = (ParameterizedType) field.getGenericType();

                        Class<?> listClass = (Class<?>) pType.getActualTypeArguments()[0];

                        Object child = listClass.getDeclaredConstructor().newInstance();
                        objStack.push(child);
                    }

                    else {
                        Object child = type.getDeclaredConstructor().newInstance();
                        objStack.push(child);
                    }
                }
                // else{
                // for(Field f : parent.getClass().getDeclaredFields()){
                // System.out.println("Tag & field: " + tag + ", " + f.getName());
                // if(tag.equals(f.getName())){
                // System.out.println("Field Name: " + f.getName());
                // }
                // }
                // }
                // for (Object i : objStack) {
                // System.out.println(i.getClass());
                // }
            }

            else if (line.startsWith("</")) {
                String tag = tagStack.pop();

                if (objStack.size() > 1) {
                    Object child = objStack.pop();
                    Object parent = objStack.peek();
                    // System.out.println("Child : " + child.getClass() + " Parent: " + parent.getClass() + " Tag: " + tag);

                    Field field = getField(child, tag);
                    // System.out.println("Field : " + field.getName());

                    if (field != null) {
                        // System.out.println("Close Field : " + field.getName());
                        field.setAccessible(true);

                        // System.out.println("Type: " + field.getType());
                        if (List.class.isAssignableFrom(field.getType())) {
                            // System.out.println("Type: " + field.getType());
                        } else {
                            field.set(child, field.get(child));
                            // System.out.println("Value: " + field.get(child));
                            // field.set(parent , child);
                        }
                    }
                }
            }

            else {
                String content = line;

                String tag = tagStack.peek();

                Object curr = objStack.peek();
                // System.out.println("Tag & curr: " + curr + " " + tag);
                Field field = getField(curr, tag);
                if (field != null) {
                    field.setAccessible(true);
                    // System.out.println("Field Content Name: " + field.getName());
                    setValue(field, curr, content);
                }
            }

            // for(Object i : objStack){
            // System.out.println(i.getClass());
            // }
        }

        return rootObject;
    }

    public static boolean isNormal(Class<?> type) {
        return (type.isPrimitive()
                || type == String.class
                || Number.class.isAssignableFrom(type));
    }

    public static Field getField(Object parent, String tag) {
        try {
            return parent.getClass().getDeclaredField(tag);
        } catch (Exception e) {
            return null;
        }
    }

    public static void setValue(Field f, Object o, String content)
            throws NumberFormatException, IllegalArgumentException, IllegalAccessException {
        Class<?> type = f.getType();

        if (type == int.class) {
            f.set(o, Integer.parseInt(content));
        } else {
            f.set(o, content);
        }

        // System.out.println("Value is: " + f.get(o));
    }

    public static void main(String[] args) throws Exception {
        // Student s = (Student) parseToObject(
        // "output.xml",
        // Student.class);

        Student s = (Student) parseToObject(
                "output.xml",
                Student.class);

        System.out.println("Name: " + s.getName());
        System.out.println("Age: " + s.getAge());
        System.out.println("Dept: " + s.getDept());

        System.out.println(s.subjects == null);
        System.out.println(s.address == null);

        // for (Subject sub : s.subjects) {
        // System.out.println(
        // sub.subjectName + " - " + sub.mark);
        // }

        // System.out.println(
        // "City: " + s.address.city);
    }
}
