package homework.day16;

import java.io.*;
import java.util.ArrayList;

/**
 * 1.将文本反转,第一行到最后一行,最后一行到第一行
 *   参考思路：字符流逐行读取文件到集合中，倒序遍历集合；
 */
public class IOTest01 {
    public static void main(String[] args) {
        IOTest01 ioTest01 = new IOTest01();
        ioTest01.reverseFile("file.txt", "file.txt.bat");
    }


    /**
     * 文本反转 (利用Buffered高级流)
     * @param sourceFileName 原文件
     * @param targetFileName 目标文件
     */
    public static void reverseFile(String sourceFileName, String targetFileName){
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            fileReader = new FileReader(sourceFileName);
            fileWriter = new FileWriter(targetFileName);
            bufferedReader = new BufferedReader(fileReader);
            bufferedWriter = new BufferedWriter(fileWriter);
//            int i = -1;
//            char[] chars = new char[50];
            while (bufferedReader.ready()){
                arrayList.add(bufferedReader.readLine());
            }

            arrayList.forEach(System.out::println);


            for (int i = arrayList.size() - 1; i >= 0; i--) {
                bufferedWriter.write(arrayList.get(i), 0, arrayList.get(i).length());
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null)
                    fileReader.close();
                if (fileWriter != null)
                    fileWriter.close();
                if (bufferedReader != null)
                    bufferedReader.close();
                if (bufferedWriter != null)
                    bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
