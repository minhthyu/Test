package day16;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class ConsoleTest {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        System.out.println(inputStream.read());

    }

    public static void readFromConsole() {

    }

    public static void test01() throws Exception {
        OutputStream outputStream = System.out;
        outputStream.write("哈哈哈\n".getBytes());
        PrintStream printStream = new PrintStream(System.out);
        printStream.print("哈哈哈哈");
        outputStream.close();
        printStream.close();
    }
}
