package java8;

import javax.swing.*;
import java.util.function.Predicate;

public class LoveForJava8 {

    public static void main(String[] args) {
        System.out.println(loveCharge("结婚一辈子", info -> "结婚一辈子".equals(info)));
    }

    public static String loveCharge(String s, Predicate<String> predicate){
        if (predicate.test(s)){
            return "您好，只需要7元";
        }
        return "您好，需要100万元";
    }
}


@FunctionalInterface
interface Love{
    void showLove();
}
