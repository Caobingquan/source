package com.example.demo.test;

import com.example.demo.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author {曹炳全}
 * @Description
 * @date 2021/2/18 16:00
 */
@Slf4j
public class CollectionTest {
    /**
     * List删除不能直接操作remove,不然报错
     */
    @Test
    void a1() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        //遍历删除,正确
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if ("2".equals(iterator.next())) {
                iterator.remove();//使用迭代器的删除方法删除
            }
            System.out.println(iterator.next());
        }
        //错误
        for (String item : list) {
            if ("2".equals(item)) {
                list.remove(item);
            }
            System.out.println(item);
        }
    }
    /**
     * List转map
     */
    @Test
    void a2() {
        List<User> users = getUsers();
        users.stream().forEach(user -> user.setName("test"));

        Map<Integer, String> collect1 = users.stream()
                .collect(Collectors.toMap(User::getId, User::getName, (key1, key2) -> key1));
    }

    private List<User> getUsers() {
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setId(4);
        user.setPrice(new BigDecimal(4.53));
        user.setName("111");
        User user1 = new User();
        user1.setId(2);
        user1.setPrice(new BigDecimal(2.53));
        user1.setName("222");
        User user2 = new User();
        user2.setId(1);
        user2.setPrice(new BigDecimal(1.53));
        user2.setName("333");
        User user3 = new User();
        user3.setId(5);
        user3.setPrice(new BigDecimal(5.53));
        user3.setName("444");
        users.add(user);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        return users;
    }
}
