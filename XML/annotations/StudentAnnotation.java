package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD , ElementType.METHOD})


public @interface StudentAnnotation {
    Type value();

    public enum Type {
        NAME,
        AGE,
        DEPARTMENT
    }
}
