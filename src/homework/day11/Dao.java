package homework.day11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 定义一个泛型类Dao<T>，在其中定义一个Map成员变量，Map的键为String类型，值为T类型
 * 分别创建以下方法：
 * @param <T>
 */
public class Dao<T> {
    private Map<String, T> map;

//    {
//        map = new HashMap<>();
//    }

    public Dao() {

    }

    public Dao(Map<String, T> map) {
        this.map = map;
    }

    //保存T类型的对象到Map成员变量中
    public void save(String id,T entity) {
        this.map.put(id, entity);
    }
    //从map中获取id对应的对象
    public T get(String id) {
        return this.map.get(id);
    }
    //替换map中key为id的内容，改为entity对象
    public void update(String id,T entity) {
        this.save(id, entity);
    }
    //返回map中存放的所有T对象
    public List<T> list() {
        List<T> list = new ArrayList<>();
        this.map.forEach((key, value) -> {
            list.add(value);
        });
        return list;
    }
    //删除指定id对象
    public void delete(String id) {
        this.map.remove(id);
    }
}
