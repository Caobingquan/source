package com.example.demo.test;

import cn.hutool.core.lang.hash.Hash64;
import cn.hutool.core.util.HashUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.*;

/**
 * @author {曹炳全}
 * @Description
 * @date 2021/2/20 16:09
 */
@Slf4j
public class StringTest {
    /**
     * String变list
     */
    @Test
    void a1() {
        String a = "aa,gg,cc，dd";
        List<String> strings = Arrays.asList(a.split(",|，|;"));
//        List<String> strings = Arrays.asList(a.split("[,，;]"));
        List<Object> synonyms = new ArrayList<>();
        strings.forEach(s -> {
            List<String> strings1 = new ArrayList<>(strings);
            strings1.remove(s);
            Map<String,Object> synonym = new HashMap<>();
            synonym.put("cmd","add");
            synonym.put("word",s);
            synonym.put("alias",strings1);
            synonym.put("antiAlias",new ArrayList<>());
            synonyms.add(synonym);
        });
        System.out.println(JSON.toJSONString(synonyms));
        System.out.println(strings.toString());

    }

    /**
     * String转hash
     */
    @Test
    void a2() {
        String addfdff= "fdgsgrshlfigsdlfdflsajlsaf";
        String dfdsfdfgrg= "fdgsgrshlfigsdlfdflsajlsaf";
        int i = HashUtil.fnvHash(addfdff);
        String vv = "fdgsgrshlfigsdlfdflsajlsa";
        int cdccvv = HashUtil.fnvHash(vv);
        System.out.println(cdccvv);
        System.out.println(i);
        System.out.println(HashUtil.fnvHash(dfdsfdfgrg));

    }
    /**
     * String转对象
     */
    @Test
    void a3() {
        Map<String,Object> map = new HashMap<>();
        map.put("ddd","dd");
        List<String> list= new ArrayList<>();
        list.add("asdsa");
        map.put("rr",list);

        String dd= "aa";
        User user = new User();
        user.setName("aa");
        String s = JSON.toJSONString(user);
        String a = JSON.toJSONString(map);
        String b = JSON.toJSONString(list);
        String gg = JSON.toJSONString(dd);

        User user1 = JSON.parseObject(s, User.class);
        User user2 = JSONObject.parseObject(s, User.class);
        User user3 = JSONObject.parseObject(a, User.class);
        User user4 = JSONObject.parseObject(gg, User.class);

    }
    /**
     * String转list
     */
    @Test
    void a4() {
        String dfdf = "[{\"approvalStatus\":\"APPROVED\",\"channelCode\":\"INT\",\"name\":\"易联网\",\"orderable\":true,\"searchable\":true,\"shopCode\":\"\"},{\"approvalStatus\":\"APPROVED\",\"channelCode\":\"HUB\",\"name\":\"数码港\",\"orderable\":true,\"searchable\":true,\"shopCode\":\"\"}]";
        List<Map> maps = JSON.parseArray(dfdf, Map.class);
    }
}
