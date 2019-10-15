import java.io.IOException;
import java.util.*;

public class day05 {
    public static void main(String[] args) {
//        System.out.println("Test1:");
//        test1();
//        System.out.println("Test2:");
//        test2();
//        System.out.println("Test3:");
//        test3();
//        System.out.println("Test4:");
//        test4();
//        System.out.println("Test5:");
//        test5();
//        System.out.println("Test6:");
//        System.out.println(test6(8));
//        System.out.println("Test7:");
//        test7();
//        System.out.println("Test8:");
//        test8();
//        System.out.println("Test9:");
//        test9();
//        System.out.println("Test10:");
//        test10();
//        System.out.println("Test11:");
//        test11();
        new innerClass().test();
    }

    /**
     * 【程序 1】 题目：有 1、2、3、4 个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
     * 1.程序分析：可填在百位、十位、个位的数字都是 1、2、3、4。组成所有的排列后再去掉不满足条件的排列。
     * 2.程序源代码：
     */
    public static void test1() {
        int[] nums = new int[]{1, 2, 3, 4};
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == nums[i])
                    continue;
                for (int m = 0; m < nums.length; m++) {
                    if (nums[m] == nums[j] || nums[m] == nums[i])
                        continue;
                    for (int n = 0; n < nums.length; n++) {
                        if (nums[n] == nums[m] || nums[n] == nums[j] || nums[n] == nums[i])
                            continue;
                        int result = nums[i] * 1000 + nums[j] * 100 + nums[m] * 10 + nums[n];
                        results.add(result);
                    }
                }
            }
        }

        System.out.print("All(总计" + results.size() + ") -> ");
        for (Integer result : results) {
            System.out.print((int) result + " ");
        }
        System.out.println();
    }

    /**
     * 【程序 2】 题目：一个整数，它加上 100 后是一个完全平方数，再加上 268 又是一个完全平方数，请问 该数是多少？
     * 1.程序分析：在 10 万以内判断，先将该数加上 100 后再开方，再将该数加上 268 后再开方，
     * 如果开方后的结果满足如下条件，即是结果。请看具体分析：
     */
    public static void test2() {
        System.out.print("0-100000有：");
        for (int i = 0; i < 100000; i++) {
            int unit = i % 10;  //先求出数字的个位数
            if (unit != 0 && unit != 1
                    && unit != 4 && unit != 5
                    && unit != 6 && unit != 9) {      //平方数的个位数字只能是 0， 1，4，5，6，9 。
                continue;
            }
            double sqrt1 = Math.sqrt(i + 100);
            double sqrt2 = Math.sqrt(i + 268);
            if (sqrt1 == (int) sqrt1 && sqrt2 == (int) sqrt2)
                System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * 【程序 3】 题目：输入某年某月某日，判断这一天是这一年的第几天？
     * 1.程序分析：以 3 月 5 日为例，应该先把前两个月的加起来，然后再加上 5 天即本年的第几 天，特殊情况，
     * 闰年且输入月份大于 3 时需考虑多加一天。
     */
    public static void test3() {
        int[] total = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
        Scanner scanner = new Scanner(System.in);
        String s;
        System.out.print("请输入日期：");
        while (true) {
            s = scanner.nextLine();
            try {
                int year = Integer.valueOf(s.split("年")[0].trim());
                int month = Integer.valueOf(s.split("年")[1].trim()
                        .split("月")[0].trim());
                int day = Integer.valueOf(s.split("年")[1].trim()
                        .split("月")[1].trim()
                        .split("日")[0].trim());
//                System.out.println(year + "年" + month + "月" + day + "日");
                int days = 0;
                if (isLeapYear(year))
                    days++;
                System.out.println(year + "年" + month + "月" + day + "日 是这一年的第 "
                        + (days + total[month - 1] + day) + "天");
                break;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.print("请输入正确的日期（例如：1997年9月20日）：");
            }
        }
    }

    /**
     * 工具类 -> 判断是否为闰年
     *
     * @param year 年份
     * @return true - 是
     */
    private static boolean isLeapYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400) == 0;
    }

    /**
     * 【程序 4】 题目：输入三个整数 x,y,z，请把这三个数由小到大输出。
     */
    public static void test4() {
        System.out.print("请输入三个数字（如1,2,3）：");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] splitResult = s.split(",");
        int a, b, c;
        try {
            a = Integer.valueOf(splitResult[0]);
            b = Integer.valueOf(splitResult[1]);
            c = Integer.valueOf(splitResult[2]);
            int[] ints = {a, b, c};
//            System.out.println(a > b && a > c ? a: b > c ? b : c);   //求最大值
            for (int i = 0; i < ints.length; i++) {
                int max_i = i;
                for (int i1 = i + 1; i1 < ints.length; i1++) {
                    if (ints[max_i] < ints[i1])
                        max_i = i1;
                }
                if (max_i != i) {
                    ints[i] ^= ints[max_i];
                    ints[max_i] ^= ints[i];
                    ints[i] ^= ints[max_i];
                }
            }
            System.out.println("从大到小排序后为：");
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        } catch (Exception e) {
        }
    }

    /**
     * 【程序 5】 题目：输出 9*9 口诀。 1.程序分析：分行与列考虑，共 9 行 9 列，i 控制行，j 控制列。
     */
    public static void test5() {
        for (int i = 1; i < 10; i++) {
            for (int i1 = 1; i1 <= i; i1++) {
                System.out.print(i + "×" + i1 + " = " + i * i1);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    /**
     * 【程序 6】题目：古典问题：有一对兔子，从出生后第 3 个月起每个月都生一对兔子，小兔子长到第三个月后
     * 每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？
     * 1.程序分析： 兔子的规律为数列 1,1,2,3,5,8,13,21....
     *
     * @param i 首月的兔子的对数
     * @return 当月的兔子对数
     */
    public static int test6(int i) {
        if (i == 1) return 1;
        if (i == 2) return 1;
        return test6(i - 2) + test6(i - 1);   //递归解决
    }

    /**
     * 【程序 7】 题目：判断 101-200 之间有多少个素数，并输出所有素数。
     * 1.程序分析：判断素数的方法：用一个数分别去除 2 到 sqrt(这个数)，如果能被整除，
     * 则表明此数不是素数，反之是素数。
     */
    public static void test7() {
        System.out.print("101-200 之间的素数 >");
        for (int i = 101; i < 200; i++) {
            boolean flag = false;
            for (int i1 = 2; i1 < Math.sqrt(i); i1++) {
                if (i % i1 == 0)
                    flag = true;
            }
            if (!flag)
                System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * 【程序 8】 题目：打印出所有的“水仙花数”，所谓“水仙花数”是指一个三位数，其各位数字立方和 等于该数本身。
     * 例如：153 是一个“水仙花数”，因为 153=1 的三次方＋5 的三次方＋3 的三次 方。
     * 1.程序分析：利用 for 循环控制 100-999 个数，每个数分解出个位，十位，百位。
     */
    public static void test8() {
        System.out.print("100-999 的水仙花数有 > ");
        for (int i = 100; i <= 999; i++) {
            int unit = i % 10;            //个位
            int decade = (i % 100) / 10;  //十位
            int hundred = i / 100;        //百位
            if ((Math.pow(unit, 3) + Math.pow(decade, 3) + Math.pow(hundred, 3)) == i)
                System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * 【程序 9】 题目：利用条件运算符的嵌套来完成此题：学习成绩>=90 分的同学用 A 表示，60-89 分之间 的用 B 表示，
     * 60 分以下的用 C 表示。 1.程序分析：(a>b)?a:b 这是条件运算符的基本例子。
     */
    public static void test9() {
        System.out.print("请输入学生成绩：");
        Scanner scanner = new Scanner(System.in);
        try {
            int score = scanner.nextInt();
            if (score > 100 || score < 0) {
                System.out.println("请输入0-100之间的整数");
                return;
            }
            System.out.println("学生成绩等级：" + (score >= 90 ? 'A' : score < 60 ? 'C' : 'B'));
        } catch (Exception e) {
            System.out.println("请输入0-100之间的整数");
            return;
        }
    }

    /**
     * 【程序 10】 题目：输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。
     * 1.程序分析：利用 while 语句,条件为输入的字符不为'\n'.
     */
    public static void test10() {
        char i;
        int abcCount = 0;
        int numCount = 0;
        int spaceCount = 0;
        int otherCount = 0;
        System.out.print("请输入一行字符:");
        try {
            while ('\n' != (i = (char) System.in.read())) {
                if (Character.isLetter(i))            //判断是否为英文字符
                    abcCount++;
                else if (Character.isDigit(i))        //判断是否为数字字符
                    numCount++;
                else if (Character.isSpaceChar(i))    //判断是否为空格字符
                    spaceCount++;
                else                                  //其他字符
                    otherCount++;
            }
            System.out.println("英文字母个数:" + abcCount + ",数字字符个数:"
                    + numCount + ",空格个数:" + spaceCount + ",其他字符个数:" + otherCount);
        } catch (IOException e) {
            System.out.println("IO异常");
        }

    }

    /**
     * 【程序 11】题目：求 s=a+aa+aaa+aaaa+aa...a 的值，其中 a 是一个数字。例如 2+22+222+2222+22222
     * (此时共有 5 个数相加)，几个数相加有键盘控制。 1.程序分析：关键是计算出每一项的值。
     */
    public static void test11() {
        System.out.print("请输入一个值：");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        System.out.print("请输入次数：");
        int b = scanner.nextInt();
        int sum = 0, item = 0;
        String s = "";
        for (int i = 0; i < b; i++) {
            item = item * 10 + a;
            s += item + "+";
//            System.out.print(item);
//            if (i != b-1)
//                System.out.print("+");
//            else
//                System.out.print("=");
            sum += item;
        }
        System.out.print(s.substring(0, s.length() - 1));
        System.out.println("=" + sum);

    }

    static class innerClass extends Object{
        public native void h1();
        public void test(){
            System.out.println(this.getClass());
        }
    }
}

class SuperClass{
//    public SuperClass() {
//        System.out.println("super0");
//    }
    public String name = "father";

    public SuperClass() {
    }

    public SuperClass(int i) {
        System.out.println("super1");
    }
}

class SonClass extends SuperClass{

    public String name = "son";

    public SonClass() {
    }

    public void change(){
        super.name = "newFather";
        System.out.println(super.name);
    }

    public SonClass(int i) {
        super(i);
    }

    public static void main(String[] args) {
//        new SonClass(10);
        SuperClass superClass = new SuperClass();
        SonClass sonClass = new SonClass();
        System.out.println(sonClass.name);
        sonClass.change();
//        System.out.println();
    }
}
