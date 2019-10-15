package day19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerSocketThread implements Runnable {
    private Socket socket;
    public ServerSocketThread(Socket socket) throws IOException {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        PrintStream ps = null;
        try {
            br = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            System.out.println(socket.getLocalAddress() + " : " + br.readLine());
            ps = new PrintStream(socket.getOutputStream());
            ps.println("收到了");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                ps.close();
                br.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

