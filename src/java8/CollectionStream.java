package java8;

import java.util.Collection;
import java.util.HashSet;

public class CollectionStream {
    public static void main(String[] args) {
        Collection<String> books = new HashSet<>();
        books.add("轻量级Java EE企业应用实战");
        books.add("疯狂Java讲义");
        books.add("疯狂iOS讲义");
        books.add("疯狂Ajax讲义");
        books.add("疯狂Android讲义");
        System.out.println("含有\"疯狂\"的书名的数量为：" + books.stream()
            .filter(ele -> ((String)ele).contains("疯狂"))
            .count());
        System.out.println("含有\"Java\"的书名的数量为：" + books.stream()
            .filter(ele -> ((String)ele).contains("Java"))
            .count());
        System.out.println("书名长度大于10的数量为：" + books.stream()
                .filter(ele -> ((String)ele).length() > 10)
                .count());
        books.stream().mapToInt(ele -> ((String)ele).length())
                .forEach(ele -> System.out.print(ele + "  "));
    }
}
