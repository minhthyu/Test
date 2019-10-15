package homework.day16;

import java.io.*;

/**
 * 3.当我们下载一个试用版软件,没有购买正版的时候,每执行一次就会提醒我们还有多少次使用机会
 *   用学过的IO流知识,模拟试用版软件,试用10次机会,执行一次就提示一次您还有几次机会,如果次数到了提示请购买正版
 *   配置文件config.txt  第一次启动读到 10，减1重新写到配置文件中，判断条件=0时，显示购买正版
 */
public class IOTest03 {
    public static void main(String[] args) {
        IOTest03 ioTest03 = new IOTest03();
        ioTest03.alertNum("config.txt");
    }


    /**
     * 试用版软件提示模拟
     * @param sourceFileName 配置文件
     */
    public static void alertNum(String sourceFileName){
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        String info;
        int num;
        try {
            fileReader = new FileReader(sourceFileName);
            bufferedReader = new BufferedReader(fileReader);
            if (!"".equals(info = bufferedReader.readLine())){
                num = Integer.valueOf(info.split("=")[1]);
                bufferedReader.close();
                fileReader.close();
                fileWriter = new FileWriter(sourceFileName);
                bufferedWriter = new BufferedWriter(fileWriter);
                if (num >= 1) {
                    num--;
                    System.out.println("您还有" + num + "次机会");
                    bufferedWriter.write("availNum=" + num);
                }
                else {
                    System.out.println("请购买正版");
                    bufferedWriter.write("availNum=" + 0);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
                try {
//                    if (fileReader != null)
//                        fileReader.close();
//                    if (fileWriter != null)
//                        fileWriter.close();
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
