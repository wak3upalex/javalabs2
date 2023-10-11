import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)         //указание на то, что аннотация будет применима только к методам
@Retention(RetentionPolicy.RUNTIME) //анотация будет доступна во время выполнения программы
public @interface Repeat {
    int value();                    //параметр повтора
}
