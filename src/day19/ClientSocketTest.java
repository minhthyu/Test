package day19;

import java.io.*;
import java.net.Socket;

public class ClientSocketTest {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 9999);
        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
        for (int i = 0; i < 10; i++) {
            pw.println("hello server!");
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(br.readLine());
        br.close();
        pw.close();
        socket.close();
    }
}

class ClientSocketTest2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("127.0.0.1", 9999);
        PrintStream pw = new PrintStream(socket.getOutputStream());
        pw.println("hello server2!");
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(br.readLine());
        br.close();
        pw.close();
        socket.close();
    }
}