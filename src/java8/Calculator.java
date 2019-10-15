package java8;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.function.BinaryOperator;

public class Calculator {
    public Calculator(){
        initCalculator();
    }
    public void initCalculator(){
        Map<String, BinaryOperator<Double>> map = new HashMap<>();
        map.put("+", Calculator::add);
        map.put("-", Calculator::sub);
        map.put("*", Calculator::mul);
        map.put("/", Calculator::div);
        startCalculator(map);
    }
    public void startCalculator(Map<String, BinaryOperator<Double>> operatorMap){
        Set<String> ops = operatorMap.keySet();
        System.out.println("模拟计算器程序启动，请按照固定格式输入：num1 op num2 目前op只支持" + ops + " 操作。");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String input = scanner.nextLine();
            String[] arrs = input.split(" ");
            if (arrs.length == 3){
                String op = arrs[1];
                double num1 = Double.valueOf(arrs[0]);
                double num2 = Double.valueOf(arrs[2]);
                BinaryOperator<Double> operator = operatorMap.get(op);
                if (operator != null){
                    double result = operator.apply(num1, num2);
                    System.out.println("=" + result);
                }else {
                    System.out.println(op + "操作暂不支持！");
                }
            }else
                if (arrs.length == 1 && ":q".equals(arrs[0])){
                    System.out.println("退出计算器！");
                    break;
                }
                System.out.println("请按照计算格式（num1 op num2）输出。例如：1 + 2");
        }
    }
    public static double add(double a, double b){return a+b;}
    public static double sub(double a, double b){return a-b;}
    public static double mul(double a, double b){return a*b;}
    public static double div(double a, double b){return a/b;}
    public static double mod(double a, double b){return a%b;}
//    public static int rightShift(int a, int b){return a>>b;}
}
