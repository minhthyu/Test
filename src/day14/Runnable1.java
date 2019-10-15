package day14;

public class Runnable1 implements Runnable {
    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println("runnable" + thread.getId() + ":" + thread.getName());
    }
}
