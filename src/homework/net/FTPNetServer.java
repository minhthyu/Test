package homework.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class FTPNetServer {
    private static boolean isStop = false;
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        while (!isStop){
            Socket socket = serverSocket.accept();

            new Thread(() -> {

                try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
                    ) {
                    String fileName = bufferedReader.readLine();
                    File file = new File("src/day19/temp", fileName);
                    if (file.exists())
                        printWriter.println("文件已存在！");
                    else
                        printWriter.println("");
                    int a = -1;
                    byte[] b = new byte[1024];
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    while (true) {
                        if (socket.getInputStream().available()!=-1)
                            while ((a = socket.getInputStream().read(b)) != -1)
                                fileOutputStream.write(b, 0, a);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            },"server").start();
        }
    }
    public static void stop(){
        isStop = true;
    }
}

class FTPNetClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 9999);
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        File file = new File(new Scanner(System.in).nextLine());
        FileInputStream fileInputStream = new FileInputStream(file);
        printWriter.println(file.getName());
        String info = bufferedReader.readLine();
        System.out.println();
        if ("".equals(info)){
            int a;
            byte[] b = new byte[1024];
            while ((a = fileInputStream.read(b)) != -1){
                socket.getOutputStream().write(b, 0, a);
            }
        }
        bufferedReader.close();
        printWriter.close();
        socket.close();
    }
}
