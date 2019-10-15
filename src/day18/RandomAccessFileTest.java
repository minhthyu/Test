package day18;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
    public static void main(String[] args) throws IOException {
//        appendContent("src/day18/raf.txt", "万一");
        replaceContent("src/day18/raf.txt", "wang", "append");
    }
    public static void replaceContent(String fileName,
                                      String sourceContent,
                                      String targetContent) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        File temp = File.createTempFile("temp", null);
        FileOutputStream fos = new FileOutputStream(temp);
        String line = null;
        System.out.println(raf.getFilePointer() - 1);
//        byte[] buf = new byte[6];
        while ((line = raf.readLine())!= null) {
            if (line.contains(sourceContent)){
                System.out.println(line);
                System.out.println(raf.getFilePointer() - line.getBytes().length);
                long index = raf.getFilePointer() - line.getBytes().length;

                line = targetContent;
                raf.write(line.getBytes());
            }
        }
        raf.close();
    }
    public static void appendContent(String fileName, String appendContent) throws IOException {
        File file = new File(fileName);
        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        String s = "ISO-8859-1";
        raf.seek(raf.length());
        raf.write(("\n" + appendContent).getBytes());
        raf.close();
    }
}
