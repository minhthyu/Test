package CSMS.Bean;

/**
 * 级别（Level）
 * 	编号（levelid）
 * 	级别名称（levelname）
 * 	费用(单价/每小时)（price）
 */
public class Level {
    private int levelid;
    private String levelname;
    private double price;

    public Level() {
    }

    public Level(int levelid, String levelname, double price) {
        this.levelid = levelid;
        this.levelname = levelname;
        this.price = price;
    }

    public int getLevelid() {
        return levelid;
    }

    public void setLevelid(int levelid) {
        this.levelid = levelid;
    }

    public String getLevelname() {
        return levelname;
    }

    public void setLevelname(String levelname) {
        this.levelname = levelname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Level{" +
                "levelid=" + levelid +
                ", levelname='" + levelname + '\'' +
                ", price=" + price +
                '}';
    }
}
