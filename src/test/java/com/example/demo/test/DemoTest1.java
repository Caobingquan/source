package com.example.demo.test;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.script.ScriptUtil;
import com.alibaba.fastjson.JSON;
import com.example.demo.pojo.SearchProductDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author {曹炳全}
 * @Description
 * @date 2021/2/20 16:52
 */
@Slf4j
public class DemoTest1 {
    @Test
    void a1() {
        Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(20)
                .map(n -> n[0])
                .forEach(x -> System.out.println(x));
    }
    @Test
    void a2() {
        String body = HttpRequest
                .get("localhost:8080/v2/search/superapp/superapp-product/product?keyword=纽崔莱&pageNo=1&pageSize=10&startIndex=0&sortProperty=price&sortType=asc&summary=product_name&productChannel=HUB&fromRequestId=161104179116780038898731")
                .execute().body();
        SearchProductDTO searchProductDTO = JSON.parseObject(JSON.toJSONString(JSON.parseObject(body).getJSONObject("results").getJSONArray("items").get(0)), SearchProductDTO.class);
        System.out.println(searchProductDTO.getTagList());
        System.out.println(body);
    }
    @Test
    void a3() {
        String inddex = "query=default:'纽崔莱' AND tags:'纽崔莱'";
        System.out.println(URLUtil.encode(inddex));
        System.out.println(encodeURIComponent(inddex));
        System.out.println(encodeURL(inddex,"UTF-8"));
        System.out.println(ScriptUtil.eval("encodeURIComponent('query=default:\\'纽崔莱\\' AND tags:\\'纽崔莱\\'');"));

    }

    /**
     * 将URL编码
     */
    public static String encodeURL(String source, String coding) {
        String target;
        try {
            target = URLEncoder.encode(source, coding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return target;
    }

    /**
     * 将URL解码
     */
    public static String decodeURL(String source, String coding) {
        String target;
        try {
            target = URLDecoder.decode(source, coding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return target;
    }

    public static String decodeURIComponent(String s) {
        if (s == null) {
            return null;
        }

        String result = null;

        try {
            result = URLDecoder.decode(s, "UTF-8");
        }

        // This exception should never occur.
        catch (UnsupportedEncodingException e) {
            result = s;
        }

        return result;
    }

    /**
     * Encodes the passed String as UTF-8 using an algorithm that's compatible
     * with JavaScript's <code>encodeURIComponent</code> function. Returns
     * <code>null</code> if the String is <code>null</code>.
     *
     * @param s The String to be encoded
     * @return the encoded String
     */
    public static String encodeURIComponent(String s) {
        String result = null;

        try {
            result = URLEncoder.encode(s, "UTF-8")
                    .replaceAll("\\+", "%20")
                    .replaceAll("\\%21", "!")
                    .replaceAll("\\%27", "'")
                    .replaceAll("\\%28", "(")
                    .replaceAll("\\%29", ")")
                    .replaceAll("\\%7E", "~");
        }

        // This exception should never occur.
        catch (UnsupportedEncodingException e) {
            result = s;
        }

        return result;
    }
}
