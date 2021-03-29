package com.example.demo.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author {曹炳全}
 * @Description
 * @date 2021/2/19 17:42
 */
@Slf4j
@RestController
public class Cbq1Controller {
    /**
     * 同义词
     */
    @GetMapping("/synonym")
    public Object aa() {
        ExcelReader reader = ExcelUtil.getReader(FileUtil.file("C:\\Users\\binquan.cao\\Desktop\\同义词.xlsx"));
        List<List<Object>> read = reader.read();
        List<Object> synonyms = new ArrayList<>();
        for (List<Object> a : read) {
            List<String> words = Arrays.asList(((String) a.get(0)).split(",|，|;"));
            words.forEach(s -> {
                List<String> words1 = new ArrayList<>(words);
                words1.remove(s);
                Map<String, Object> synonym = new HashMap<>();
                synonym.put("cmd", "add");
                synonym.put("word", s);
                synonym.put("alias", words1);
                synonym.put("antiAlias", new ArrayList<>());
                synonyms.add(synonym);
            });
        }
        System.out.println(JSON.toJSONString(synonyms));
        return synonyms;
    }

    /**
     * 纠错词
     */
    @GetMapping("/correction")
    public Object bb() {
        ExcelReader reader = ExcelUtil.getReader(FileUtil.file("C:\\Users\\binquan.cao\\Desktop\\纠错词.xlsx"));
        List<List<Object>> read = reader.read();
        List<Object> corrections = new ArrayList<>();
        for (List<Object> a : read) {
            String queryWord = a.get(0).toString();
            String correctWord = a.get(1).toString();
            Map<String, Object> correction = new HashMap<>();
            correction.put("cmd", "add");
            correction.put("word", queryWord);
            correction.put("correction", correctWord);
            correction.put("enabled", true);
            corrections.add(correction);
        }
        System.out.println(JSON.toJSONString(corrections));
        return corrections;
    }
}
