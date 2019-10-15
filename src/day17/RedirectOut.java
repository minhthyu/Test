package day17;

import java.io.*;

public class RedirectOut {
    public static void main(String[] args) {
        try(PrintStream ps = new PrintStream(new FileOutputStream("src/day17/out.txt"))) {
            System.setOut(ps);
            System.out.println("普通字符串");
            System.out.println(new RedirectOut());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
