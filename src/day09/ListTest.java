package day09;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListTest {
    public static void main(String[] args) {
        TimeCounter timeCounter = new TimeCounter("ArrayList") {
            ArrayList<Integer> arrayList = new ArrayList<>();
            {
                for (int i = 0; i < 100000; i++) {
                    arrayList.add(i);
                }
            }
            @Override
            public void doSometing() {
                for (int i = 0; i < 100000; i++) {
                    arrayList.get(i);
                }
            }
        };
        timeCounter.count();

        TimeCounter timeCounter1 = new TimeCounter("LinkedList") {
            LinkedList<Integer> linkedList = new LinkedList<>();
            {
                for (int i = 0; i < 100000; i++) {
                    linkedList.add(i);
                }
            }
            @Override
            public void doSometing() {
                for (int i = 0; i < 100000; i++) {
                    linkedList.get(i);
                }
            }
        };
        timeCounter1.count();
    }
}

abstract class TimeCounter {
    private String name;

    public TimeCounter(String name) {
        this.name = name;
    }

    public void count(){
        long start = System.currentTimeMillis();
        doSometing();
        System.out.println(this.name + " 耗时:" + (System.currentTimeMillis() - start));
    }
    public abstract void doSometing();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
