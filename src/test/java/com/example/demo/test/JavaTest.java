package com.example.demo.test;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import cn.hutool.http.HttpRequest;
import com.example.demo.pojo.SearchProductDTO;
import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;

import com.alibaba.fastjson.JSON;
import com.example.demo.pojo.User;

/**
 * @author {曹炳全}
 * @Description
 * @date 2021/2/18 16:00
 */
@Slf4j
public class JavaTest {
    /**
     * final 修饰是引用不变，对象可以变
     */
    @Test
    void a1() {
        final User user = new User();
        System.out.println(user.toString());
        user.setName("dfd");
        System.out.println(user.toString());

    }
    /**
     * 强转null不报错
     */
    @Test
    void a2() {
        Object ddf = null;
        Long fdfdf = (Long) ddf;
        String ddggg = (String) ddf;
    }
    /**
     * http请求
     */
    @Test
    void a3() {
        String body = HttpRequest
                .get("localhost:8080/v2/search/superapp/superapp-product/product?keyword=纽崔莱&pageNo=1&pageSize=10&startIndex=0&sortProperty=price&sortType=asc&summary=product_name&productChannel=HUB&fromRequestId=161104179116780038898731")
                .execute().body();
        SearchProductDTO searchProductDTO = JSON.parseObject(JSON.toJSONString(JSON.parseObject(body).getJSONObject("results").getJSONArray("items").get(0)), SearchProductDTO.class);
        System.out.println(searchProductDTO.getTagList());
        System.out.println(body);
    }

}
