package day17;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;

public class PushbackTest {
    public static void main(String[] args) {
        try(PushbackReader pr = new PushbackReader(new FileReader("src/day17/PushbackTest.java"), 64)) {
            char[] buf = new char[32];
            String lastContent = "";
            int hasRead = -1;
            while ((hasRead = pr.read(buf)) != -1) {
                String content = new String(buf, 0, hasRead);
                int targetIndex = 0;
                if ((targetIndex = (lastContent + content).indexOf("new PushbackReader")) > 0){
                    pr.unread((lastContent + content).toCharArray());
                    if (targetIndex > 32)
                        buf = new char[targetIndex];
                    pr.read(buf, 0, targetIndex);
                    System.out.println(new String(buf, 0, targetIndex));
                    System.exit(0);
                }else {
                    System.out.println(lastContent);
                    lastContent = content;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
