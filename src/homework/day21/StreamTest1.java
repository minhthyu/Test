package homework.day21;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * 第一题：现在有两个ArrayList集合存储多个成员姓名，例如
 * 	List<String> one = new ArrayList<>();
 * 		one.add(迪丽热巴");
 *         one.add("宋远桥");
 *         one.add("苏星河");
 *         one.add("老子");
 *         one.add("庄子");
 *         one.add("孙子");
 *         one.add("洪七公");
 *     List<String> two = new ArrayList<>();
 *         two.add("古力娜扎");
 *         two.add("张无忌");
 *         two.add("张三丰");
 *         two.add("赵丽颖");
 *         two.add("张二狗");
 *         two.add("张天爱");
 *         two.add("张三")
 *
 *     完成如下要求：
 * 		1). 第一个队伍只要名字为3个字的成员姓名；
 * 		2). 第一个队伍筛选之后只要前3个人；
 * 		3). 第二个队伍只要姓张的成员姓名；
 * 		4). 第二个队伍筛选之后不要前2个人；
 * 		5). 将两个队伍合并为一个队伍；
 * 		6). 根据姓名创建Person 对象；
 * 		7). 打印整个队伍的Person对象信息。
 */
public class StreamTest1 {
    public static void main(String[] args) {
        List<String> one = new ArrayList<>();
        one.add("迪丽热巴");
        one.add("宋远桥");
        one.add("苏星河");
        one.add("老子");
        one.add("庄子");
        one.add("孙子");
        one.add("洪七公");
        List<String> two = new ArrayList<>();
        two.add("古力娜扎");
        two.add("张无忌");
        two.add("张三丰");
        two.add("赵丽颖");
        two.add("张二狗");
        two.add("张天爱");
        two.add("张三");

        Stream<String> stream1 = one.stream().filter(elem -> elem.length() == 3).limit(3);
//        stream1.forEach(System.out::println);
//        System.out.println("========");
        Stream<String> stream2 = two.stream().filter(elem -> elem.startsWith("张")).skip(2);
//        stream2.forEach(System.out::println);
//        System.out.println("========");
        Stream<String> concatStream = Stream.concat(stream1, stream2);
//        concatStream.forEach(System.out::println);
//        ArrayList<String> collect1 = stream1.collect(ArrayList<String>::new,
//                (list, e) -> list.add(e),
//                (list1, list2) -> list1.addAll(list2));
//        ArrayList<String> collect2 = stream2.collect(ArrayList<String>::new,
//                (list, e) -> list.add(e),
//                (list1, list2) -> list1.addAll(list2));
//        collect1.addAll(collect2);
//        collect1.forEach(System.out::println);
        Demo01 demo = Person::new;
        Stream<Person> personStream = concatStream.map(elem -> demo.createObject(elem));
        personStream.forEach(System.out::println);
    }

//    /**
//     * 第一个队伍只要名字为3个字的成员姓名；
//     * @param one
//     */
//    public static void test1(List<String> one){
//        System.out.println("-- 第一个队伍只要名字为3个字的成员姓名 --");
//        one.stream().filter(elem -> elem.length() == 3).forEach(System.out::println);
//    }
//
//    /**
//     * 第一个队伍筛选之后只要前3个人；
//     * @param one
//     */
//    public static void test2(List<String> one){
//        System.out.println("-- 第一个队伍筛选之后只要前3个人 --");
//        one.stream().limit(3).forEach(System.out::println);
//    }
//
//    /**
//     * 第二个队伍只要姓张的成员姓名；
//     * @param two
//     */
//    public static void test3(List<String> two){
//        System.out.println("-- 第二个队伍只要姓张的成员姓名 --");
//        two.stream().filter(elem -> elem.startsWith("张")).forEach(System.out::println);
//    }
//
//    /**
//     * 第二个队伍筛选之后不要前2个人；
//     * @param two
//     */
//    public static void test4(List<String> two){
//        System.out.println("-- 第二个队伍筛选之后不要前2个人 --");
//        two.stream().skip(2).forEach(System.out::println);
//    }
//
//    /**
//     * 将两个队伍合并为一个队伍；
//     * @param one
//     * @param two
//     */
//    public static void test5(List<String> one,List<String> two){
//        System.out.println("-- 将两个队伍合并为一个队伍 --");
//
//    }
//
//    public static void test6(){}
}

@FunctionalInterface
interface Demo01{
    Person createObject(String name);
}

class Person{
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
