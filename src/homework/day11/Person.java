package homework.day11;

/**
 * 1.定义一个标准的Person类，包含属性name、age
 * 	(0)键盘录入一个字符串，该字符串为类的全包名
 * 	(1)使用反射的方式创建一个实例、调用构造函数初始化name、age
 * 	(2)使用反射方式调用setName方法对名称进行设置
 *
 */
public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
