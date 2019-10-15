package day11;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectTest {
    public static void main(String[] args) throws Exception {
//        System.out.println("====");
//        Class<?> aClass = Class.forName("day11.A");
//        Object o = aClass.newInstance();
////        System.out.println(o);
//        Method method = aClass.getMethod("toString1");
//        System.out.println(method.invoke(o));
//        //getMethods(aClass, "toString");
        Class<?> aClass = Class.forName("day11.A");
//        getMethods(aClass, "setF2", Integer.valueOf(20));
        getConstructor(aClass, "wy", 23);
    }
    public static void getMethods(Class<?> aClass, String methodName, Object ... prams) throws Exception{
        Object o = aClass.newInstance();
        Method method = aClass.getMethod(methodName, int.class);
        method.invoke(o, prams);
//        Method method1 = aClass.getMethod("setF1", String.class);
//        method1.invoke(o, "wy");
        System.out.println(o);
    }

    public static void getConstructor(Class<?> aClass, Object ... parms) throws Exception{
        Constructor<?> constructor = aClass.getConstructor(String.class, int.class);
        Object o = constructor.newInstance(parms);
        System.out.println(o);
    }
}

class A{
    private String f1;
    private int f2;
    public A() {
    }

    public A(String f1, int f2) {
        this.f1 = f1;
        this.f2 = f2;
    }

    public String getF1() {
        return f1;
    }

    public void setF1(String f1) {
        this.f1 = f1;
    }

    public int getF2() {
        return f2;
    }

    public void setF2(int f2) {
        this.f2 = f2;
    }


    public String toString1() {
        System.out.println("A{}");
        return " = ";
    }

    @Override
    public String toString() {
        return "A{" +
                "f1='" + f1 + '\'' +
                ", f2=" + f2 +
                '}';
    }
}
