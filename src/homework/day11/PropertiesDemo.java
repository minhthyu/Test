package homework.day11;

import java.io.*;
import java.net.URL;
import java.util.Properties;

/**
 * 2(扩展题).需用到IO流知识点，可以不做
 * 	(1)写一个Properties格式的配置文件，配置类的完整名称。
 *  (2)写一个程序，读取这个Properties配置文件，获得类的完整名称并加载这个类。
 */
public class PropertiesDemo {
//    public static final Properties PROPERTIES = new Properties();
//    public static final String PATH = Thread.currentThread().getContextClassLoader().getResource("conf.properties").getPath();
//    public static final String PATH = "conf.properties";
    public static void main(String[] args) throws Exception {
        Properties p = new Properties();
        URL url = Thread.currentThread().getContextClassLoader().getResource("homework/day11/conf.properties");
        String path = url.getPath();
        System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
        System.out.println(url);
        try {
            p.load(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Reflect.test(p.getProperty("className"));
    }

}
