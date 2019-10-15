package homework.day14;

/**
 * 4.完成一个java application应用程序，
 *  此应用程序公共类有一个double型类属性（变量）x，初始值为0；
 *  在应用程序主进程中新开两个线程，这两个线程都进行死循环；
 *  第1个线程每隔300ms激活一次，令类属性x自加1.0并输出显示；
 *  第2个线程每隔400ms激活一次，令类属性x自加0.1并输出显示。
 */
public class ThreadMain {
    static double x = 0;
    public static void main(String[] args) {
        Thread01 thread01 = new Thread01(300, 1);
        Thread01 thread02 = new Thread01(400, 0.1);
//        Thread thread = new Thread(thread01);
//        Thread thread1 = new Thread(thread02);

        thread01.start();
        thread02.start();
    }
}

class Thread01 extends Thread {

    double add = 0d;
    int t = 0;

    public Thread01(int t, double add) {
        this.add = add;
        this.t = t;
    }

    @Override
    public void run() {
        while (true) {
            ThreadMain.x += add;
            System.out.println(t + " -> " + ThreadMain.x);
            try {
                sleep(t);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
