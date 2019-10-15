package day12;

public class OwnExceptionHandler {
    public static void main(String[] args){
        OwnExceptionSource ownExceptionSource = new OwnExceptionSource();
        try {
            ownExceptionSource.a();
        } catch (OwnException e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
