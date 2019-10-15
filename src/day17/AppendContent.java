package day17;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AppendContent {
    public static void main(String[] args) {
        try(RandomAccessFile raf = new RandomAccessFile("src/day17/out2.txt", "rw")) {
            raf.seek(raf.length());
            raf.write("追加的内容！\n".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
