package homework.day18;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 写一个文件, 写入26个小写字母，再打开这个文件, 把前10个换成大写字母,后10个替换为数字字符.
 * 这里主要是用RandomAccessFile随机访问流来处理这个问题：
 * abcdefghijklmnopqrstuvwxyz
 */
public class RandomAccessFileTest2 {
    public static void main(String[] args) {
        System.out.println('1' - 1);
        process("src/homework/day18/CharNum.txt", 10, 10);
    }
    public static void process(String fileName, int firstNum, int endNum){
        StringBuilder builder1 = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();
        int flag = -1;
        long index = -1;
        try(RandomAccessFile raf = new RandomAccessFile(
                fileName, "rw"
        )) {
            for (int i = 0; i < firstNum; i++)
                builder1.append((char)raf.read());
            String s = builder1.toString().toUpperCase();
            while ((flag = raf.read()) != -1){
                builder2.append((char) flag);
            }
            System.out.println(builder1);
            System.out.println(builder2);
            raf.seek(0);
            raf.write(builder1.toString().toUpperCase().getBytes());
            raf.write(builder2.toString().getBytes());
            raf.seek(raf.length() - endNum);
            for (int i = 0; i < endNum; i++) {
                raf.write((char)(i+48));
            }

//            while ((flag = raf.read()) != -1) {
////                System.out.print((char)flag);
//            }
//            for (int i = 0; i < firstNum; i++) {
//                builder.append(raf.readChar());
//            }
//            String replaceString = builder.toString().toUpperCase();
//            for (int i = firstNum; i < raf.length(); i++)
//                builder.replace(0, builder.length(), "").append(raf.readChar());
//            raf.seek(0);
//            raf.write(replaceString.getBytes("ISO-8859-1"));
//            raf.write(builder.toString().getBytes("ISO-8859-1"));
//            raf.seek(raf.length() - endNum);
//            builder.replace(0, builder.length(), "").append("0123456789");
//            raf.write(builder.toString().getBytes("ISO-8859-1"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
