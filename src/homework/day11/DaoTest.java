package homework.day11;


import java.util.HashMap;

/**
 * 创建一个Dao类的对象，分别调用save、get、update、list、delete方法来操作User对象，实现对某个用户的增删改查功能。
 */
public class DaoTest {
    public static void main(String[] args) {
        HashMap<String, User> hashMap = new HashMap<>();
        User user = new User(1, 20, "张三");
        hashMap.put(String.valueOf(user.getId()), user);
        Dao<User> dao = new Dao(hashMap);
        User user1 = new User(2, 20, "李四");
        dao.save(String.valueOf(user1.getId()), user1);
        System.out.println(dao.get("1"));
        User user2 = new User(3, 20, "王五");
        dao.update("1", user2);
        System.out.println("===============================");
        System.out.println(dao.get("1"));
        System.out.println("===============================");
        dao.list().forEach(System.out::println);
        dao.delete("2");
        System.out.println("===============================");
        dao.list().forEach(System.out::println);
    }
}
