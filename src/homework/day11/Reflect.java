package homework.day11;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflect {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        test("homework.day11.Person");
    }

    public static void test(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> aClass = Class.forName(className);
        Constructor<?> constructor = aClass.getConstructor(String.class, int.class);
        Object o = constructor.newInstance("wy", 20);
        Person person = (Person)o;
        System.out.println(person);
        System.out.println("=========================");
        Method method = aClass.getMethod("setName", String.class);
//        aClass.newInstance();
        method.invoke(o, "wm");
        System.out.println(person);
//        Method method = aClass.getMethod(constructor.getName());
//        method.invoke(o);
    }
}
