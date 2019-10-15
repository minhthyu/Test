package day19;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketTest2 {
    private static boolean isStop = false;
    public static void main(String[] args) throws IOException {
        int port = 9999;
        ServerSocket serverSocket = new ServerSocket(port);
        while (!isStop) {
            Socket socket = serverSocket.accept();
            new Thread(new ServerSocketThread(socket)).start();
        }
        serverSocket.close();
    }

    public static void stop(){
        isStop = true;
    }
}
