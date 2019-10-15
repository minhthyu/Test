package day12;

public class OwnExceptionSource {
    public void a() throws OwnException {
        throw new OwnException("OwnException 异常");
    }
}
