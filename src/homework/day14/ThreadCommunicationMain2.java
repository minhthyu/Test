package homework.day14;

/**
 * 线程1,2对变量i加一.
 * 线程3,4对变量i减一.
 * 四个线程顺序执行, 每个线程每次只执行一次.i的初始值为0， 打印结果 1 2 1 0 1 2 1 0 1 2...
 */
public class ThreadCommunicationMain2 {
    static int i = 0;
    static int flag = 1;   // 1 - 线程1  2 - 线程2  3 - 线程3  4 - 线程4

    public static void main(String[] args) throws InterruptedException {
        ThreadCommunication21 run1 = new ThreadCommunication21();
        ThreadCommunication22 run2 = new ThreadCommunication22();
        Thread thread01 = new Thread(run1);
        Thread thread02 = new Thread(run1);
        Thread thread03 = new Thread(run2);
        Thread thread04 = new Thread(run2);
        thread01.start();
        thread02.start();
        thread03.start();
        thread04.start();
//        thread01.start();
//        thread01.join();
//        thread02.start();
//        thread02.join();
//        thread03.start();
//        thread03.join();
//        thread04.start();
//        thread04.join();
    }
}

class ThreadCommunication21 implements Runnable {

    @Override
    public void run() {
        while (true){
            synchronized (ThreadCommunicationMain2.class) {
                while (ThreadCommunicationMain2.flag == 3 || ThreadCommunicationMain2.flag == 4){
                    try {
                        ThreadCommunicationMain2.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                ThreadCommunicationMain2.i++;
                ThreadCommunicationMain2.flag++;
                System.out.print(ThreadCommunicationMain2.i + " ");
                ThreadCommunicationMain2.class.notifyAll();
//                try {
//                    ThreadCommunicationMain2.class.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }
    }

    private boolean stop(){
        return false;
    }
}

class ThreadCommunication22 implements Runnable {

    @Override
    public void run() {
        while (true){
            synchronized (ThreadCommunicationMain2.class) {
                while (ThreadCommunicationMain2.flag == 1 || ThreadCommunicationMain2.flag == 2){
                    try {
                        ThreadCommunicationMain2.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                    ThreadCommunicationMain2.class.notifyAll();
                }
                ThreadCommunicationMain2.i--;
                if (ThreadCommunicationMain2.flag == 3)
                    ThreadCommunicationMain2.flag = 4;
                else ThreadCommunicationMain2.flag = 1;
                System.out.print(ThreadCommunicationMain2.i + " ");
                ThreadCommunicationMain2.class.notifyAll();
            }
        }
    }

    private boolean stop(){
        return false;
    }
}
