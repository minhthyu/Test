package day09;

import java.util.Collection;
import java.util.HashSet;

public class CollectionTest {
    public static void main(String[] args) {
        String str1 = "Java 高级编程";
        String str2 = "XML";
        String str3 = "Mysql";
        Collection<String> collection = new HashSet<>();
        collection.add(str1);
        collection.add(str2);
        collection.add(str3);
        int length = collection.size();
        System.out.println(length);
        collection.forEach(System.out::println);
        collection.remove(str2);
        collection.forEach(System.out::println);
    }
}
