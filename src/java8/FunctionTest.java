package java8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class FunctionTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "spark", "hadoop", "hive");
        Stream<String> stream = list.stream();
        stream.filter(elm -> elm.length() < 20)
                .map(elm1 -> elm1.length())
                .forEach(x -> System.out.print(x + " "));
        stream.close();
        System.out.println("\n============");
        new Random()
                .ints(10, 1, 20)
                .collect(
                    HashSet<Integer>::new,
                    (set,x) -> set.add(x),
                    (set1,set2) -> set1.addAll(set2)
                ).forEach(System.out::println);
    }
}
