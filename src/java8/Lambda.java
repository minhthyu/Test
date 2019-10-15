package java8;

abstract class Peason{
    public static void eat(){
        System.out.println("用嘴吃");
    }
    public abstract void sleep();
}

class WY extends Peason{

    @Override
    public void sleep() {
        Peason.eat();
    }

    public static void main(String[] args) {
        new WY().sleep();
    }
}

interface Eatable{
    void taste();
}

interface Flyable{
    void fly(String weather);
}

interface Addable{
    int add(int a, int b);
}

public class Lambda {
    public void eat(Eatable e){
        System.out.println(e);
        e.taste();
    }
    public void drive(Flyable f){
        System.out.println("我正在驾驶：" + f);
        f.fly("【碧空如洗的晴日】");
    }
    public void test(Addable add){
        System.out.println("5 和 3的和为：" + add.add(5, 3));
    }

    public static void main(String[] args) {
        Lambda lambda = new Lambda();
        lambda.eat(() -> System.out.println("苹果的味道不错"));
        lambda.drive(weather -> {
            System.out.println("今天天气是：" + weather);
            System.out.println("直升机飞行平稳");
        });
        lambda.test((a, b) -> a + b);
    }
}
