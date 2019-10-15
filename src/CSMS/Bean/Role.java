package CSMS.Bean;

/**
 * 角色（role）:普通用户（consumer） 管理员（manager） 维修人员（accendant）
 */
public enum Role {
    CONSUMER("普通用户"), MANAGER("管理员"), ACCENDANT("维修人员");
    private String roleName;

    Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
