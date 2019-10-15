package day17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class BufferedTest {
    public static void main(String[] args) throws IOException {
//        readFile("src/day17/db.properties");
        readProperties("src/day17/db.properties");
    }

    public static void readFile(String fileName) throws IOException {
        ArrayList<String> strings = new ArrayList<>();
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            strings.add(line);
        }
        bufferedReader.close();
        strings.forEach(ele -> {
            System.out.println(ele.split("=")[1].trim());
        });
    }

    public static void readProperties(String fileName){
        Properties properties = new Properties();
        try(FileReader fileReader = new FileReader(fileName)) {
            properties.load(fileReader);
            String username = properties.getProperty("username");
            System.out.println("用户名:" + username);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
