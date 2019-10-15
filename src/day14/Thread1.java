package day14;

public class Thread1 extends Thread {
    @Override
    public void run() {
//        super.run();
        //获取当前线程对象
        Thread thread = Thread.currentThread();
        String s = "thread" + thread.getId() + ":" + thread.getName();
        long sum=0l;
        for (long i = 0; i < 10; i++) {
            System.out.println(s + "->" + i);
        }
    }
}
