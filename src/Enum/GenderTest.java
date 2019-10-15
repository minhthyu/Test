package Enum;

public class GenderTest {
    public static void main(String[] args) {
        Gender gender = Gender.valueOf("FEMALE");
        System.out.println(gender + "代表:" + gender.getName());
        gender.info();
        Gender gender1 = Gender.valueOf("MALE");
        System.out.println(gender1 + "代表:" + gender1.getName());
        gender1.info();
    }
}
