package Enum;

public class EnumTest {
    public void judge(SeasonEnum seasonEnum){
        switch (seasonEnum){
            case SPRING:
                System.out.println("春暖花开，正好踏青");
                break;
            case SUMMR:
                System.out.println("夏日炎炎，适合游泳");
                break;
            case FALL:
                System.out.println("秋高气爽，进补及时");
                break;
            case WINTER:
                System.out.println("冬日雪飘，围炉赏雪");
                break;
        }
    }

    public static void main(String[] args) {
        for (SeasonEnum value : SeasonEnum.values()) {
            System.out.println(value);
        }
        new EnumTest().judge(SeasonEnum.WINTER);
        System.out.println(SeasonEnum.WINTER.toString());
    }
}
