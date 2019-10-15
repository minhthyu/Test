package day16;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StreamTest {
    public static void main(String[] args) {
        StreamTest streamTest = new StreamTest();
        streamTest.readFormConsole();
    }

    public static void readFormConsole(){
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("file.txt");
            int i;
            while ((i = fileInputStream.read())!=-1){
                System.out.print(i + " ");
            }

            System.out.println(i);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
