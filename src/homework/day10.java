package homework;

import java.lang.reflect.Modifier;
import java.util.*;

public class day10 {
    public static void main(String[] args) {
//        System.out.println("\u0041\\\\");
//        System.out.println("\\?\\[");
//        test2();
//        test3();
//        tett4();
        HashMap<Integer, String> hashMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            hashMap.put(i, String.valueOf(i));
        }
        foreachMap(hashMap);
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add(String.valueOf(i));
        }
//        foreachCollection(arrayList);
    }

    public static <T,K> void foreachMap(Map<T, K> map){
        Set<Map.Entry<T, K>> entries = map.entrySet();
        for (Map.Entry<T, K> entry : entries) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    public static void foreachCollection(Collection<? extends A> collection){
        for (A a : collection) {

        }
        collection.forEach(o -> System.out.print(o + " "));
    }

    public static void foreachCollection2(Collection<? super B> collection){
        for (Object o : collection) {
            
        }
    }

    public static void test2(){
        Integer a = 100;
        Integer b = 100;
        System.out.println("a == b : " + (a == b));
        Integer a1 = 200;
        Integer b1 = 200;
        System.out.println("a1 == b1 : " + (a1 == b1));
    }

    /**
     * 用增强的for循环来遍历Map,打印其中的key  value   以及entrySet(MapTest.java)
     */
    public static void test3(){
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.put(4, "d");
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("====");
        map.forEach((key, value) -> System.out.println(key + ":" + value));
    }

    /**
     * 写一个类Student类，有id、name、score属性，
     * 把学生对象放到集合中排序，先按照id，再按照name，
     * 最后score（名字叫tom的学生特殊照顾一下，无论多少分都要排在第一名）
     */
    public static void tett4(){
        TreeSet<Student> students = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if ("tom".equals(o1.getName()))
                    return -1;
                if (o1.getId() != o2.getId())
                    return o1.getId() - o2.getId();
                else if (!(o1.getName().equals(o2.getName())))
                    return o1.getName().compareTo(o2.getName());
                else
                    return o2.getScore() -o1.getScore();
            }
        });

        students.add(new Student(2, "a", 90));
        students.add(new Student(1, "b", 90));
        students.add(new Student(1, "a", 90));
        students.add(new Student(1, "a", 100));
        students.add(new Student(2, "a", 50));
        students.add(new Student(3, "tom", 88));

        students.forEach(System.out::println);
    }

    static class Student {
        private int id;
        private String name;
        private int score;

        public Student() {
        }

        public Student(int id, String name, int score) {
            this.id = id;
            this.name = name;
            this.score = score;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", score=" + score +
                    '}';
        }
    }
}

class A{

}
class B extends A{

}

