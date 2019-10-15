package java8;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Testable {

}

class MyTest {
    @Testable
    public static void m1(){}
    public static void m2(){}
    @Testable
    public static void m3(){
        throw new IllegalArgumentException("参数出错了！");
    }
    public static void m4(){}
    @Testable
    public static void m5(){}
    public static void m6(){}
    @Testable
    public static void m7(){
        throw new RuntimeException("程序业务出现异常！");
    }
    public static void m8(){}
}


class ProcessorTest {
    public static void process(String clazz) throws ClassNotFoundException{
        int passed = 0;
        int failed = 0;
        for (Method method : Class.forName(clazz).getMethods()) {
            if (method.isAnnotationPresent(Testable.class)) {
                try {
                    method.invoke(null);
                    passed++;
                } catch (Exception e) {
                    System.out.println("方法" + method.getName() + "运行失败，异常："
                    + e.getCause());
                    failed++;
                }
            }
        }
        System.out.println("共运行了：" + (passed + failed) + "个方法，其中：\n"
                            + "失败了：" + failed + "个，\n"
                            + "成功了：" + passed + "个！");
    }
}

class RunTest{
    public static void main(String[] args) throws ClassNotFoundException {
        ProcessorTest.process("java8.MyTest");
    }
}