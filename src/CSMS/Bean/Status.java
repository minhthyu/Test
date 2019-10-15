package CSMS.Bean;

public enum Status {
    可用(1), 借出(-1), 维修(0);
    private int statusid;

    Status(int statusid) {
        this.statusid = statusid;
    }

    public int getStatusid() {
        return statusid;
    }

    public void setStatusid(int statusid) {
        this.statusid = statusid;
    }
}
