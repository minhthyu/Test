package CSMS.Bean;

/**
 * 品牌（Brand）
 * 	编号（brandid）
 * 	品牌名称（brandname）
 * 	级别（level）
 */
public class Brand {
    private int brandid;
    private String brandname;
    private Level level;

    public Brand() {
    }

    public Brand(int brandid, String brandname, Level level) {
        this.brandid = brandid;
        this.brandname = brandname;
        this.level = level;
    }

    public int getBrandid() {
        return brandid;
    }

    public void setBrandid(int brandid) {
        this.brandid = brandid;
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brandid=" + brandid +
                ", brandname='" + brandname + '\'' +
                ", level=" + level +
                '}';
    }
}
