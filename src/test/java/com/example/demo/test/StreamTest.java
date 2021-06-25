package com.example.demo.test;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;

import com.example.demo.pojo.User;

/**
 * @author {曹炳全}
 * @Description
 * @date 2021/2/18 16:00
 */
@Slf4j
public class StreamTest {

    /**
     * stream, 排序
     */
    @Test
    void a1() {

        List<Integer> collect1 = Arrays.asList(3, 2, 1, 4, 5, 8, 6).stream().sorted().collect(Collectors.toList());
        System.out.println(collect1);

        List<User> users = getUsers();

        users.stream().forEach(user -> user.setName("test"));

        List<User> collect2 = users.stream().sorted((x, y) -> x.getPrice().compareTo(y.getPrice()))
                .collect(Collectors.toList());
        System.out.println(collect2);

        System.out.println("end");
    }

    /**
     * stream, list转map,去重
     */
    @Test
    void a2() {
        List<User> users = getUsers();
        users.stream().forEach(user -> user.setName("test"));

        Map<Integer, String> collect1 = users.stream()
                .collect(Collectors.toMap(User::getId, User::getName, (key1, key2) -> key1));
        Map<Integer, String> collec2 = users.stream()
                .collect(Collectors.toMap(User::getId, User::getName));

        System.out.println("end");
    }
    /**
     * stream, 算法
     */
    @Test
    void a3() {
        Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(20)
                .map(n -> n[0])
                .forEach(x -> System.out.println(x));
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
