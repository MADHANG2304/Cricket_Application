
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ObjectWriter {
    static int count = 0;

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

            if (line.startsWith("<") && !line.startsWith("</") && !line.contains("</")) {
                String tag = line.substring(1, line.indexOf(">"));

                tagStack.push(tag);

                Object parent = objStack.peek();

                Field field = getField(parent, tag);

                if (field != null) {

                    field.setAccessible(true);

                    Class<?> type = field.getType();

                    if (List.class.isAssignableFrom(type)) {
                        continue;
                    }

                    if (!isNormal(type)) {
                        Object child = type.getDeclaredConstructor().newInstance();
                        objStack.push(child);
                    }
                }

                else {
                    for (Field f : parent.getClass().getDeclaredFields()) {
                        if (List.class.isAssignableFrom(f.getType())) {
                            ParameterizedType pType = (ParameterizedType) f.getGenericType();
                            Class<?> listType = (Class<?>) pType.getActualTypeArguments()[0];

                            if (listType.getSimpleName().equalsIgnoreCase(tag)) {
                                Object child = listType.getDeclaredConstructor().newInstance();
                                objStack.push(child);
                                break;
                            }
                        }
                    }
                }
            }

            else if (line.startsWith("</")) {
                String tag = line.substring(2, line.indexOf(">"));

                tagStack.pop();

                if (objStack.size() > 1) {
                    Object child = objStack.peek();
                    Object parent = objStack.get(objStack.size() - 2);

                    if (child.getClass().getSimpleName().equalsIgnoreCase(tag)) {

                        objStack.pop();

                        Field field = getField(parent, tag);

                        if (field != null && !List.class.isAssignableFrom(field.getType())) {
                            field.setAccessible(true);
                            field.set(parent, child);
                        }

                        else {

                            for (Field f : parent.getClass().getDeclaredFields()) {
                                if (List.class.isAssignableFrom(f.getType())) {
                                    ParameterizedType pType = (ParameterizedType) f.getGenericType();
                                    Class<?> listType = (Class<?>) pType.getActualTypeArguments()[0];

                                    if (listType.getSimpleName().equalsIgnoreCase(tag)) {
                                        f.setAccessible(true);

                                        @SuppressWarnings("unchecked")
                                        List<Object> list = (List<Object>) f.get(parent);

                                        if (list == null) {
                                            list = new ArrayList<>();
                                            f.set(parent, list);
                                        }

                                        list.add(child);
                                        break;
                                    }
                                }
                            }
                        }

                    }
                }
            }

            else {
                String content = line;

                String tag = tagStack.peek();

                Object curr = objStack.peek();

                Field field = getField(curr, tag);

                if (field != null) {
                    field.setAccessible(true);
                    setValue(field, curr, content);
                }
            }
        }

        br.close();
        return rootObject;
    }

    public static boolean isNormal(Class<?> type) {
        return (type.isPrimitive() || type == String.class || Number.class.isAssignableFrom(type));
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

    }

    public static void main(String[] args) throws Exception {
        Student s = (Student) parseToObject("output.xml", Student.class);

        System.out.println("Name: " + s.getName());
        System.out.println("Age: " + s.getAge());
        System.out.println("Dept: " + s.getDept());

        System.out.println("\nCity: " + s.address.city);
        System.out.println("State: " + s.address.state);
        System.out.println("Country: " + s.address.country);
        
        for (Subject sub : s.subjects) {
            System.out.println("\nSubject Name: " + sub.getSubjectName());
            System.out.println("Staff Name: " + sub.getStaffName());
            System.out.println("Marks: " + sub.getMarks());
            System.out.println("Grade: " + sub.getGrade());
        }
    }
}
