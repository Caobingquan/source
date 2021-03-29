package com.example.demo.test;

import com.alibaba.fastjson.JSON;
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
     *
     */
    @Test
    void a1() {
        String a = "aa,gg,cc，dd";
        List<String> strings = Arrays.asList(a.split(",|，|;"));
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

        List<String> strings1 = Arrays.asList(a.split("[,，;]"));
    }
}
