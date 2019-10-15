package CSMS.Bean;


/**
 * 汽车（Car）
 * 	编号（carid）
 * 	品牌（brand）
 * 	状态(status):可用（1） 借出（-1） 维修（0）
 */
public class Car {
    private int carid;
    private String brand;
    public Status status;

    public int getCarid() {
        return carid;
    }

    public void setCarid(int carid) {
        this.carid = carid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carid=" + carid +
                ", brand='" + brand + '\'' +
                ", status=" + status +
                '}';
    }
    //    public static void main(String[] args) {
//        Car car = new Car();
//        car.setStatus(Status.借出);
//        System.out.println(car.getStatus().getStatusid());
//    }
}
