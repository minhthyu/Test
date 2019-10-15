package other;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class FileStreamTest {
    public static void main(String[] args) {
//        Stream.iterate(0, x -> x + 2).limit(100).forEach(System.out::println);
        Stream.generate(() -> Math.random()).limit(10).forEach(System.out::println);
        try(Stream<String> lines = Files.lines(Paths.get("a.txt"))) {
            long uniqueWords = lines
                    .flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
            System.out.println("有" + uniqueWords + "个不同的单词");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
