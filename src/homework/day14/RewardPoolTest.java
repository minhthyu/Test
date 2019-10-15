package homework.day14;

import java.math.BigDecimal;

/**
 * 知识点：线程同步
 * 7..有一个抽奖池,该抽奖池中存放了奖励的金额,该抽奖池用一个数组int[] arr = {10,5,20,50,100,200,500,800,2,80,300};
 *   创建两个抽奖箱(线程)设置线程名称分别为“抽奖箱1”，“抽奖箱2”，随机从arr数组中获取奖项元素并打印在控制台上s
 */
public class RewardPoolTest {
    static int[] arr = {10,5,20,50,100,200,500,800,2,80,300};
    public static void main(String[] args) {
        new Thread(new RewardPool(), "抽奖箱1").start();
        new Thread(new RewardPool(), "抽奖箱2").start();
    }
}

class RewardPool implements Runnable {

    @Override
    public void run() {
        Object o = new Object();
        synchronized (o) {
            for (int i = 0; i < 7; i++) {
                System.out.println(
                        Thread.currentThread().getName()
                                + " -> "
                                + RewardPoolTest.arr[(int)(Math.random() * 11)]);
            }
        }
    }
}

//class Test{
//    static BigDecimal i = new BigDecimal("0");
//    public static void main(String[] args) {
//        new Thread(() -> {
//            while (true){
//                try {
//                    Thread.sleep(300);
//                    i = i.add(new BigDecimal("1"));
//                    System.out.println(i);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//        new Thread(() -> {
//            while (true) {
//                try {
//                    Thread.sleep(400);
//                    i = i.add(new BigDecimal("0.1"));
//                    System.out.println(i);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//    }
//}

class Test {
    public static void main(String[] args) {
        new Thread(() -> {

        },"").start();
        new Thread(() -> {

        }).start();
    }
}
