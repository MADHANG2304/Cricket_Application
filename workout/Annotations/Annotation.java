import java.lang.annotation.*;

@Documented
@interface classDemo{
    String Author();
}

@interface demo{
    String value();
    int number() default 1;
}