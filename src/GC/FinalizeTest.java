package GC;

import java.util.ArrayList;

public class FinalizeTest {
    private static FinalizeTest ft = null;
    public void info(){
        System.out.println("测试资源清理的finalize方法");
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("王琪");
        list.add("孙超");
        list.forEach(System.out::println);
        new FinalizeTest();
        System.gc();
        Runtime.getRuntime().runFinalization();
        System.runFinalization();
        ft.info();
    }

    public void finalize(){
        ft = this;
    }
}
