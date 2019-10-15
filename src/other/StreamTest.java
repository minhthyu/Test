package other;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //获取交易的流对象
        Stream<Transaction> stream = transactions.stream();

        /*
        // 找出2011年发生的所有交易，并按交易额排序（从低到高）
        Stream<Transaction> stream1 = stream
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue));
        stream1.forEach(System.out::println);
        */


        /*
        //交易员都在哪些不同的城市工作过？
        Stream<String> stream2 = stream
                .map(transaction -> transaction.getTrader().getCity())
                .distinct();
        stream2.forEach(System.out::println);
        */


        //查找所有来自于剑桥的交易员，并按姓名排序
        Stream<Trader> stream3 = stream
                .map(transaction -> transaction.getTrader())
                .filter(trader -> "Cambridge".equals(trader.getCity()))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName));
        stream3.forEach(System.out::println);



        /*
        //返回所有交易员的姓名字符串，按字母顺序排序
        Stream<String> stream4 = stream
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted();
        stream4.forEach(System.out::println);
        */


        /*
        //有没有交易员是在米兰工作的？
        boolean flag1 = stream
                .map(transaction -> transaction.getTrader().getCity())
                .anyMatch(name -> "Milan".equals(name));
        System.out.println("有没有交易员是在米兰工作的？ -> " + flag1);
        */


        /*
        //打印生活在剑桥的交易员的所有交易额
        int sum = stream
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(transaction -> transaction.getValue())
                .reduce(0, Integer::sum);
        System.out.println("生活在剑桥的交易员的所有交易额:" + sum);
        */


        /*
        //所有交易中，最高的交易额是多少？
        Optional<Integer> max = stream
                .map(transaction -> transaction.getValue())
                .max(Integer::compareTo);
        System.out.println("所有交易中，最高的交易额是:" + max.orElse(-1));
        */


        /*
        //找到交易额最小的交易
        Optional<Transaction> minTransaction = stream
                .min(Comparator.comparing(Transaction::getValue));
        System.out.println("交易额最小的交易:" + minTransaction.orElse(null));
         */
    }
}

class Trader {
    private final String name;
    private final String city;

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Trader:" +
                this.name + " in " +
                this.city;
    }
}

class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return trader;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                this.trader +
                ", year:" + this.year +
                ", value:" + this.value +
                '}';
    }
}
