package homework.day16;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 2.统计文本中字符出现的次数,将结果写在count.txt中（对于空格，回车等也需要统计）
 *   参考思路：字符流读取文本，存入Map集合
 */
public class IOTest02 {
    public static void main(String[] args) {
        IOTest02 ioTest02 = new IOTest02();
        ioTest02.wordsCount("file.txt", "results.txt");
    }

    /**
     * 统计文本中字符出现的次数
     * @param resourceFileName  需要统计的文件路径
     * @param resultFileName    结果文件路径
     */
    public static void wordsCount(String resourceFileName, String resultFileName){
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        HashMap<Character, Integer> results = new HashMap<>();
//        StringBuilder builder = new StringBuilder();
        try {
            fileReader = new FileReader(resourceFileName);
            fileWriter = new FileWriter(resultFileName);
            int i = -1;
            char[] chars = new char[1024];
            while ((i = fileReader.read(chars)) != -1){
                for (int i1 = 0; i1 < i; i1++) {
                    if (!results.containsKey(chars[i1]))
                        results.put(chars[i1], 1);
                    else
                        results.replace(chars[i1], results.get(chars[i1]) + 1);
                }
            }
//            results.forEach((key, value) -> System.out.println(key + ":" + value));
            for (Map.Entry<Character, Integer> characterIntegerEntry : results.entrySet()) {
                fileWriter.write(characterIntegerEntry.getKey() + ":"
                        + characterIntegerEntry.getValue() + "\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fileReader != null)
                    fileReader.close();
                if (fileWriter != null)
                    fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
