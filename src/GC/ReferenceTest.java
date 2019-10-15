package GC;

import java.lang.ref.WeakReference;

public class ReferenceTest {
    public static void main(String[] args) {
        String str = new String("疯狂Java讲义");
        WeakReference wr = new WeakReference(str);
        str = null;
        System.out.println(wr.get());
        System.gc();
        System.runFinalization();
        System.out.println(wr.get());

//        String s = "hello";
//        s += " world";
//        String s1 = "hello world";
//        System.out.println("s == s1" + s == s1);
//
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < 10; i++) {
//            stringBuilder.append(i);
//        }
//        String s2 = "0123456789";
//        System.out.println(stringBuilder);
//        System.out.println("stringBuilder == s2" + s2 == stringBuilder.toString());
    }
}
