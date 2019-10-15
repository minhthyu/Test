package day17;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessTest {
    public static void main(String[] args) {
        try(RandomAccessFile raf = new RandomAccessFile(
            "src/day17/RandomAccessTest.java", "r"
        )) {
            System.out.println("RandomAccessFile的文件指针的初始位置：" + raf.getFilePointer());
            raf.seek(300);
            byte[] bbuf = new byte[1024];
            int hasRead = -1;
            while ((hasRead = raf.read(bbuf)) != -1) {
                System.out.println(new String(bbuf, 0, hasRead));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
