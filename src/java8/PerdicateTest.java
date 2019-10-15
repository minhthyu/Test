package java8;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;

public class PerdicateTest {
    public static void main(String[] args) {
        Collection<String> books = new HashSet<>();
        books.add("轻量级Java EE企业应用实战");
        books.add("疯狂Java讲义");
        books.add("疯狂iOS讲义");
        books.add("疯狂Ajax讲义");
        books.add("疯狂Android讲义");
//        books.removeIf(ele ->((String)ele).length() < 10);
//        books.forEach(ele -> System.out.println(ele + "  "));
        System.out.println("含有\"疯狂\"的书名的数量为：" + calAll(books, ele -> ((String)ele).contains("疯狂")));
        System.out.println("含有\"Java\"的书名的数量为：" + calAll(books, ele -> ((String)ele).contains("Java")));
    }

    public static <T> int calAll(Collection<T> books, Predicate<T> p){
        int total = 0;
        for (T book : books) {
            if (p.test(book)) total++;
        }
        return total;
    }
}
