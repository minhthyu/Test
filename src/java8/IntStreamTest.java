package java8;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class IntStreamTest {
    public static void main(String[] args) {
        IntStream intStream = IntStream.builder()
                .add(20)
                .add(13)
                .add(-2)
                .add(18)
                .build();
        IntStream intStream1 = IntStream.builder()
                .add(100)
                .add(200)
                .add(200)
                .build();
//        System.out.println("intStream所有元素的最大值：" + intStream.max().getAsInt());
//        System.out.println("intStream所有元素的最小值：" + intStream.min().getAsInt());
//        System.out.println("intStream所有元素的总和：" + intStream.sum());
//        System.out.println("intStream所有元素的总数：" + intStream.count());
//        System.out.println("intStream所有元素的平均值：" + intStream.average().getAsDouble());
//        System.out.println("intStream所有元素的平方是否都大于20："
//                + intStream.allMatch(ele -> ele * ele > 20));
//        System.out.println("intStream是否包含任何元素的平方大于20："
//                + intStream.anyMatch(ele -> ele * ele > 20));
//        IntStream newIntStream = intStream.map(ele -> ele * 2 + 1);
//        newIntStream.forEachOrdered(ele -> System.out.print(ele + "  "));
//        IntStream newIntStream1 = intStream.filter(ele -> ele > 13);
//        newIntStream1.forEach(ele -> System.out.print(ele + "  "));
//        DoubleStream doubleStream = intStream.mapToDouble(ele -> ele * Math.PI);
//        doubleStream.forEach(ele -> System.out.print(ele + "  "));
//        IntStream distinct = intStream.distinct();
//        distinct.forEach(ele -> System.out.print(ele + "  "));
//        IntStream sorted = intStream.sorted();
//        sorted.forEach(ele -> System.out.print(ele + "  "));
//        int reduce = intStream.reduce(1, (o1, o2) -> o1 + o2);
//        System.out.println("reduce：" + reduce);
    }
}
