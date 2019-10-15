package day01;
import java.util.Scanner;

public class Test {
    /**
     * 程序主方法
     * @param args
     */
    public static void main(String[] args){
        int[] arr = new int[]{66, 78, 34, 99, 12};
        sort1();
        sort2();
        sort3();

        Scanner bj = new Scanner(System.in);
        System.out.print("请输入圆的半径：");
        int r = bj.nextInt() ;//半径
        double R = 2*r;//直径
        for (int i = 0;  i <= R; i += 2) {
            double y;
            if (i <= r) y = r - i ;
            else y = i - r;
            double x = Math.round(Math.sqrt(r * r - y * y));
            //循环输出
            for (int j = 0; j < r - x; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int j = 0; j < 2 * x; j++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }
    }

    /**
     * 选择排序
     */
    public static void sort1(){
        int[] arr = {66, 78, 34, 99, 12};
        int len = arr.length;
        int i,j,min_i,temp;
        for (i = 0; i < len; i++) {
            min_i = i;
            for (j = i + 1; j < len; j++) {
                if (arr[min_i] > arr[j]) {
                    min_i = j;
                }
            }
            if (min_i != i){
                temp = arr[i];
                arr[i] = arr[min_i];
                arr[min_i] = temp;
            }
        }
        printArr(arr);
    }

    /**
     * 冒泡排序
     */
    public static void sort2(){
        int[] arr = new int[]{66, 78, 34, 99, 12};
        int i,j,temp;
        for (i = 0; i < arr.length - 1; i++){
            for (j = i+1; j < arr.length; j++){
                if (arr[i] > arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        printArr(arr);
    }

    /**
     * 插入排序
     */
    public static void sort3(){
        int[] arr = {66, 78, 34, 99, 12};
        int i, j, temp;
        for (i = 1; i < arr.length ; i++){
            j = i;
            while (j-1 >= 0 && arr[j - 1] > arr[j]){
                temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
        printArr(arr);
    }
    /**
     * 打印数组数据
     * @param arr 待打印的数组数据
     */
    public static void printArr(int[] arr){
        int i;
        for (i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}

