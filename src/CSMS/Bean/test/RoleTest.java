package CSMS.Bean.test;

import CSMS.Bean.Role;

public class RoleTest {
    public static void main(String[] args) {
        Role role = Role.valueOf("CONSUMER");
        System.out.println(role.getRoleName());
    }
}
