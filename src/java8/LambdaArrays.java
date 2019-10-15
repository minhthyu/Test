package java8;

import java.util.Arrays;

public class LambdaArrays {
    public static void main(String[] args) {
        String[] arr1 = {"java", "fkava", "fkit", "ios", "android"};
        Arrays.parallelSort(arr1, (o1, o2) -> o1.length() - o2.length());
        System.out.println(Arrays.toString(arr1));
        int[] arr2 = {3, -4, 25, 16, 20, 18};
        Arrays.parallelPrefix(arr2, ((left, right) -> left * right));
        System.out.println(Arrays.toString(arr2));
        long[] arr3 = new long[5];
        Arrays.parallelSetAll(arr3, index -> index * 5);
        System.out.println(Arrays.toString(arr3));
    }
}
