package lab2;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) {
        TestMethods test = new TestMethods();                       //obj of Class with methods
        Method[] methods = TestMethods.class.getDeclaredMethods();  //array for methods

        for (Method method : methods){
            if (method.isAnnotationPresent(Repeat.class)) {
                int rep = method.getAnnotation(Repeat.class).value();
                method.setAccessible(true);
                int modifier = method.getModifiers();
                if (Modifier.isPrivate(modifier) || Modifier.isProtected(modifier)){
                    for (int i = 1; i<=rep; i++){
                        try {
                            method.invoke(test, i);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}