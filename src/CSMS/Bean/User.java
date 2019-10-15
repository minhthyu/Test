package CSMS.Bean;

/**
 * 用户（User）
 * 	编号（userid）
 * 	用户名称（name）
 * 	密码（password）
 * 	角色（role）:普通用户（consumer） 管理员（manager） 维修人员（accendant）
 */
public class User {
    private int userid;
    private String name;
    private String password;
    private Role role;

//    public static void main(String[] args) {
//        User user = new User();
//        user.setRole(Role.valueOf("CONSUMER"));
//        System.out.println(user.getRole().getRoleName());
//    }

    public User() {
    }

    public User(int userid, String name, String password, Role role) {
        this.userid = userid;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
