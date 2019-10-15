package day17;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class RedirectIn {
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("src/day17/RedirectIn.java")) {
            System.setIn(fis);
            Scanner sc = new Scanner(System.in);
            sc.useDelimiter("\n");
            while (sc.hasNext()) {
                System.out.println("键盘输入的内容是：" + sc.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
