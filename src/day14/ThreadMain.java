package day14;

public class ThreadMain {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getId() + ":" + thread.getName());
        Thread1 thread1 = new Thread1();
        thread1.start();
        System.out.println("====");
        Runnable1 runnable1 = new Runnable1();
        Thread thread2 = new Thread(runnable1);
        thread2.start();
    }
}
