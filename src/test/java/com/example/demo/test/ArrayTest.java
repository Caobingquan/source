package com.example.demo.test;

import com.alibaba.fastjson.JSON;
import com.example.demo.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author {曹炳全}
 * @Description
 * @date 2021/2/18 16:00
 */
@Slf4j
public class ArrayTest {
    /**
     * stream只是给了地址，没有新建
     */
    @Test
    void a1() {
        String dfdf = "[{\"approvalStatus\":\"APPROVED\",\"channelCode\":\"INT\",\"name\":\"易联网\",\"orderable\":true,\"searchable\":true,\"shopCode\":\"\"},{\"approvalStatus\":\"APPROVED\",\"channelCode\":\"HUB\",\"name\":\"数码港\",\"orderable\":true,\"searchable\":true,\"shopCode\":\"\"}]";
        List<Map> maps = JSON.parseArray(dfdf, Map.class);
        Object ddf = null;
        Long fdfdf = (Long) ddf;
        String ddggg = (String) ddf;

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        for (String item : list) {
            if ("2".equals(item)) {
                list.remove(item);
            }
            System.out.println(item);
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("b", "b");
        map.put("c", "c");
        String dgdf = map.get("dgdf");
    }

    /**
     * stream, 分组
     */
    @Test
    void a2() {
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setId(1);
        user.setName("111");
        User user1 = new User();
        user1.setId(2);
        user1.setName("222");
        User user2 = new User();
        user2.setId(2);
        user2.setName("333");
        User user3 = new User();
        user3.setId(2);
        user3.setName("444");
        users.add(user);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        Map<Integer, String> collect2 = users.stream()
                .collect(Collectors.toMap(User::getId, User::getName, (key1, key2) -> key1));
        Map<Integer, String> collect = users.stream()
                .collect(Collectors.toMap(User::getId, User::getName));

        System.out.println("11");
    }
    @Test
    void a3() {
        List<String> a = new ArrayList<>();
        JSON.toJSONString(a);
        System.out.println("11");
    }
}
