package homework.day18;

import java.io.*;
import java.util.Objects;
import java.util.TreeSet;

public class ObjectStreamTest {
    public static void main(String[] args) {
        TreeSet<Student> students = new TreeSet<>();
        students.add(new Student("wy", 23, 99));
        students.add(new Student("wm", 22, 100));
        students.add(new Student("wq", 23, 98));
        students.add(new Student("wy", 23, 88));
        students.add(new Student("wy", 22, 99));
        students.add(new Student("sc", 22, 88));
        boolean flag = writeObjectToFile("src/homework/day18/obj.txt", students);
        if (flag)
            System.out.println("成功序列化保存到文件");
        else System.out.println("序列化保存到文件失败");
        TreeSet<Student> results = readObjectFromFile("src/homework/day18/obj.txt");
        System.out.println("=== 读取对象如下：===");
        results.forEach(System.out::println);
    }


    public static TreeSet<Student> readObjectFromFile(String fileName) {
        try(ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(fileName)
        )) {
            TreeSet<Student> students = (TreeSet<Student>)ois.readObject();
            return students;
        } catch (FileNotFoundException e) {
//            e.printStackTrace();
            System.out.println("文件不存在！");
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println("IO异常！");
        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
            System.out.println("类加载失败！");
        }
        return null;
    }

    public static boolean writeObjectToFile(String fileName, TreeSet<Student> students) {
        try(ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(fileName)
        )) {
            oos.writeObject(students);
            return true;
        } catch (FileNotFoundException e) {
//            e.printStackTrace();
            System.out.println("文件不存在！");
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println("IO异常！");
        }
        return false;
    }
}

class Student implements Comparable, Serializable {
    private String name;
    private int age;
    private int score;

    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                score == student.score &&
                name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, score);
    }

//    @Override
//    public int compare(Object o1, Object o2) {
//        Student stu1 = (Student) o1;
//        Student stu2 = (Student) o2;
//        if (!stu1.getName().equals(stu2.getName()))
//            return stu1.getName().compareTo(stu2.getName());
//        else if (stu1.getAge()!=stu2.getAge())
//            return stu1.getAge() - stu2.getAge();
//        return stu2.getScore() - stu2.getScore();
//    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Student stu = (Student) o;
        if (!this.getName().equals(stu.getName()))
            return this.getName().compareTo(stu.getName());
        else if (this.getAge()!=stu.getAge())
            return this.getAge() - stu.getAge();
        return this.getScore() - stu.getScore();
    }
}
