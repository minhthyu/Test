package day14;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Callable1 implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "test";
    }

    public static void main(String[] args) {
        Callable callable = new Callable1();
        FutureTask futureTask = new FutureTask(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            String info = (String)futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
