package com.example.demo.test;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
