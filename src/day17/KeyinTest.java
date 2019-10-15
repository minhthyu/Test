package day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyinTest {
    public static void main(String[] args) {
        try(InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr)) {
            String line = null;
            while ((line = br.readLine()) != null){
                if ("exit".equals(line))
                    System.exit(1);
                System.out.println("输入内容为：" + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
