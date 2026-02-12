package annotations;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@interface classDemo{
    String Author();
}

@Retention(RetentionPolicy.RUNTIME)
@interface demo{
    String value();
    int number() default 1;
}