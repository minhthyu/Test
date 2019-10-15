package day16;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class FileCopyTest {
    public static void main(String[] args) throws Exception {
        FileCopyTest fileCopyTest = new FileCopyTest();
//        fileCopyTest.copyFile("file.txt", "file.txt.bat");
        fileCopyTest.uploadImg("01.png", "02.png");
    }

    /**
     * 文件拷贝
     * @param sourceFileName 原文件
     * @param targetFileName 拷贝文件
     * @throws Exception IO异常
     */
    public static void copyFile(String sourceFileName, String targetFileName) throws Exception{
        FileReader fileReader = new FileReader(sourceFileName);
        FileWriter fileWriter = new FileWriter(targetFileName);
        int b = -1;
        char[] chars = new char[1024];
        while ((b = fileReader.read(chars)) != -1) {
            fileWriter.write(chars, 0, b);
        }
        fileReader.close();
        fileWriter.close();
    }

    public static void downloadImg(String sourceFileName, String targetFileName) throws Exception{

    }

    /**
     * 图片上传
     * @param sourceFileName 原图片路径
     * @param targetFileName 上传图片路径
     * @throws Exception
     */
    public static void uploadImg(String sourceFileName, String targetFileName) throws Exception{
        FileInputStream fileInputStream = new FileInputStream(sourceFileName);
        FileOutputStream fileOutputStream = new FileOutputStream(targetFileName);
        int i = -1;
        byte[] bytes = new byte[1024];
        while ((i = fileInputStream.read(bytes)) != -1){
            fileOutputStream.write(bytes);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
