package homework.day21;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 1).给定一个数字列表, 如何返回每个数字的平方列表？例如, 给定 [1、2、3、4、5], 返回 [1、4、9、16、25]。
 * 2).给定两个数字列表, 如何返回所有对数字？例如, 给定一个列表 [1, 2, 3] 和一个列表 [3, 4]
 * 你应该返回 [(1, 3), (1, 4), (2, 3), (2, 4), (3，3), (3, 4)]。为了简单起见,
 * 可以将一对作为具有两个元素的数组表示。
 * 3).（扩展）如何扩展前面的示例以返回其总和可被3整除的对？例如, (2、4) 和 (3、3) 是有效的。
 */
public class StreamTest2 {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        nums.stream().map(elem -> elem * elem).forEach(elem -> System.out.print(elem + " "));
        System.out.println();
        List<Integer> nums2 = Arrays.asList(1, 2, 3);
        List<Integer> nums3 = Arrays.asList(3, 4);
//        nums2.stream().reduce(new ArrayList<>,
//                (map, elem) -> map.put(0, 0),
//                (list1, list2) -> list1.;
//        );

        Stream<ArrayList<Integer[]>> arrayListStream = nums2.stream().map(elem1 ->
                        nums3.stream().map(elem2 -> {
//                System.out.println("(" + elem1 + ", " + elem2 + ")");
                            return new Integer[]{elem1, elem2};
                        }).collect(ArrayList<Integer[]>::new,
                                (list, obj) -> list.add(obj),
                                (list1, list2) -> list1.addAll(list2))
        );

//        arrayListStream.forEach(obj -> obj.forEach(obj1 -> {
//            System.out.println("(" + obj1[0] + ", " + obj1[1] + ")");
//        }));

        Stream<Integer[]> filterStream = arrayListStream.flatMap(
                list -> list.stream()).filter(
                        elem -> (elem[0] + elem[1]) % 3 == 0 ? true : false);
        filterStream.forEach(obj1 -> {
            System.out.println("(" + obj1[0] + ", " + obj1[1] + ")");
        });

//        nums3.stream().map(elem -> new HashMap(elem, 1)).forEach(obj -> obj.forEach((key, value) -> System.out.println(key + ":" + value)));

//        nums2.stream().forEach(elem1 ->
//                nums3.stream().forEach(elem2 -> {
//                            System.out.print("(" + elem1 + ", " + elem2 + ")  ");
//                        }
//                ));

//        mapArrayList.forEach(elem ->
//            elem.forEach((key, value) -> {
//                System.out.print("(" + key + ", " + value + ")  ");
//            })
//        );
        Stream<Integer> stream = Stream.of(1,2,3,4);
        Integer[] integers = stream.toArray(Integer[]::new);
        for (int i = 0; i < integers.length; i++) {
            System.out.println(integers[i]);
        }

    }
}
