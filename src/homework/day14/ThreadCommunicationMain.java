package homework.day14;

/**
 * 5.创建两个线程，其中一个输出1-52，另外一个输出A-Z。输出格式要求：12A 34B 56C 78D
 *  提示：循环控制打印数字与字符，线程间通信控制线程的执行顺序
 */
public class ThreadCommunicationMain {
    static String[] num = new String[52];
    static char[] cha = new char[26];
    static {
        for (int i = 0; i < 52; i++) {
            num[i] = "" + (i + 1);
        }
        for (int i = 0; i < 26; i++) {
            cha[i] = (char)('A' + i);
        }
    }

    static int flag = 0; // 输出数字
    static int numIndex = 0;
    static int chaIndex = 0;


    public synchronized void printNum(){
        while (flag != 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.print(num[numIndex++]);
//        System.out.print("===" + numIndex + "====");
        System.out.print(num[numIndex++]);
        flag = 1;
        notify();
    }

    public synchronized void printChar(){
        while (flag != 1){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(cha[chaIndex++]);
        System.out.println();
        flag = 0;
        notify();
    }

    public static void main(String[] args) {
        ThreadCommunicationMain main = new ThreadCommunicationMain();
        new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                main.printNum();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                main.printChar();
            }
        }).start();
    }
}

//abstract class ThreadCommunication implements Runnable {
//
//}
//
//class ThreadCommunication02 implements Runnable {
//
//    @Override
//    public void run() {
//
//    }
//}
