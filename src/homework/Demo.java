package homework;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
    }

    public static void test1(){
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            double item = Math.random() * 19 + 1;
            while (true){
                if (!arrayList.contains(item)){
                    arrayList.add(item);
                    break;
                }
            }
        }
        System.out.println("生成的列表如下：");
        arrayList.forEach(System.out::println);
    }

    public static void test2(){
        Scanner scanner = new Scanner(System.in);
        ArrayList arrayList = new ArrayList();
        while (scanner.hasNextDouble()){
            double item = scanner.nextDouble();
            if (item == 0.0) break;
            arrayList.add(item);
        }
        Double[] results = (Double[]) arrayList.toArray(new Double[arrayList.size()]);
        Arrays.parallelSort(results, (o1, o2) -> o1 > o2 ? -1 : 1);
        System.out.println("Max is:" + results[0]);
    }

    public static void test3(){
        ArrayList<Student> students = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        students.add(new Student("zhangsan","1904",59));
        students.add(new Student("lisi","1904",58));
        students.add(new Student("wangwu","1903",49));
        students.add(new Student("zhaoliu","1904",50));
        students.add(new Student("tom","1903",100));
        students.add(new Student("lily","1904",99));
        students.add(new Student("bob","1903",79));
        students.forEach(stu -> {
            if (map.containsKey(stu.getClassName())){
                int score = Integer.valueOf(map.get(stu.getClassName()).split(" ")[0]) + stu.getScore();
                int sum = Integer.valueOf(map.get(stu.getClassName()).split(" ")[1]) + 1;
                map.put(stu.getClassName(), score + " " + sum);
            }
            else
                map.put(stu.getClassName(),stu.getScore() + " " + 1);
        });
        map.forEach((cn, info) -> {
            System.out.println(cn + "班级 -> 均分：" +
                    Integer.valueOf(info.split(" ")[0]) * 1.0 / Integer.valueOf(info.split(" ")[1]) +
                    "，总分：" +
                    Integer.valueOf(info.split(" ")[0]) * 1.0 *  Integer.valueOf(info.split(" ")[1]));
        });
    }

    public static void test4(){
        String[] str = {"aaa", "bbb", "ccc", "abc", "ddd", "aaa", "aaa", "abc", "gh", "sudo"};
        ArrayList<String> arrayList = new ArrayList<>();
        for (String s : str) {
            arrayList.add(s);
        }
        System.out.print("排序前：");
        arrayList.forEach(s -> System.out.print(s + " "));
        TreeSet<String> treeSet = new TreeSet<>((o1, o2) -> {
            return o1.compareTo(o2) == 0 ? 1 : o1.compareTo(o2);
        });
//        arrayList.forEach(treeSet::add);
        treeSet.addAll(arrayList);
        System.out.print("\n排序后：");
        treeSet.forEach(s -> System.out.print(s + " "));
    }

    public static void test5(){
        Set<String> redSet = new TreeSet<>();  //1—33  6
        Set<String> blueSet = new TreeSet<>(); //1-16  1
        while (true){
            String s = String.valueOf((int)(Math.random() * 33 + 1));
            String s1 = String.valueOf((int)(Math.random() * 15 + 1));
            redSet.add(s);
            if (blueSet.size() == 0)
                blueSet.add(s1);
            if (redSet.size() == 6)
                break;
        }
        System.out.println("Red:");
        redSet.forEach(a -> System.out.print(a + " "));
        System.out.println("\nBlue:");
        blueSet.forEach(a -> System.out.print(a + " "));
    }

    public static void test6(){
        Map<Integer,String> map = new HashMap<Integer, String>();
        map.put(1, "张三丰");
        map.put(2, "周芷若");
        map.put(3, "阿牛哥");
        map.put(4, "灭绝师太");

        map.forEach((key, value) -> System.out.println(key + " --> " + value));

        map.put(5, "李晓红");
        System.out.println("=============");
        map.forEach((key, value) -> System.out.println(key + " --> " + value));
        map.remove(1);
        System.out.println("=============");
        map.forEach((key, value) -> System.out.println(key + " --> " + value));
        map.put(2, "赵敏");
        System.out.println("=============");
        map.forEach((key, value) -> System.out.println(key + " --> " + value));

    }

    public static void test7(){
        HashMap<Integer, String> stationMap = new HashMap<>();
        String[] stationName = {"浦东软件园","中创软件", "创业大厦", "托普学院",
                                "阳澄湖庄", "湖滨路大禹路", "文豪花园", "蟹市场",
                                "湖滨路迎宾路", "玫瑰园", "城北西路湖亭路", "葡萄研究所",
                                "望河桥", "黄泥山村", "登云学院", "马鞍山路思常路",
                                "森林公园", "森林半岛", "马鞍山路鹿城路", "长虹大桥"};
        for (int i = 1; i <= 20; i++) {
            stationMap.put(i, stationName[i-1]);
        }
        System.out.print("请输入上车站:");
        Scanner scanner = new Scanner(System.in);
        String start = scanner.nextLine();
        System.out.print("请输入到达站:");
        String end = scanner.nextLine();
        if (!stationMap.containsValue(start) || !stationMap.containsValue(end))
            System.out.println("您上错车了！");
        System.out.print("从"+start + "到" + end);
        int startId = 0;
        int endId = 0;
//        stationMap.forEach((key, value) -> {
//            if (value == start)
//                startId = key;
//        });
        for (Integer integer : stationMap.keySet()) {
            if (stationMap.get(integer).equals(start))
                startId = integer;
            if (stationMap.get(integer).equals(end))
                endId = integer;
        }
        int stationCounts = endId - startId;
        int account = 0;
        if (stationCounts <= 0)
            System.out.println("上车站和到达站有问题！");
        else {
            System.out.print("共经过" + stationCounts + "站，");
            if (stationCounts <= 4)
                account = 1;
            else if (stationCounts <= 8)
                account = 2;
            else if (stationCounts <= 12)
                account = 3;
            else if (stationCounts <= 16)
                account = 4;
            else
                account = 4 + (stationCounts - 16);
            System.out.println("收费" + account + "元");
        }
    }

    public static void test8(){
        ArrayList<String> arrayList = new ArrayList<>();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        arrayList.add("abc");
        arrayList.add("bcd");
        arrayList.forEach((obj) -> {
            char[] chars = obj.toCharArray();
            for (char aChar : chars) {
                if (hashMap.containsKey(aChar)) {
                    hashMap.put(aChar, hashMap.get(aChar) + 1);
                }else
                    hashMap.put(aChar, 1);
            }
        });
        hashMap.forEach((key, value) -> System.out.println(key + " --> " + value));
    }

    @Override
    public String toString() {
        return "Demo{}";
    }
}

class Student {
    private String name;
    private String className;
    private int score;

    public Student() {
    }

    public Student(String name, String className, int score) {
        this.name = name;
        this.className = className;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", className='" + className + '\'' +
                ", score=" + score +
                '}';
    }
}
