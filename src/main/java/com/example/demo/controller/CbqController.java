package com.example.demo.controller;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import lombok.Data;
import lombok.Getter;
import org.apache.commons.lang3.ArchUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author {曹炳全}
 * @Description
 * @date 2021/2/4 9:50
 */
@RestController
public class CbqController {

    /**
     * 搜索对比
     */
    @GetMapping("/searchCompare")
    public void aa() {
        ExcelReader reader = ExcelUtil.getReader(FileUtil.file("C:\\Users\\binquan.cao\\Desktop\\对比汇总020300.xlsx"),
                "Sheet4");
        List<List<Object>> read = reader.read();
        List<List<String>> adfdf = new ArrayList<>();
        for (List<Object> a : read) {
            List<String> aaa = JSONArray.parseArray((String) a.get(1), SearchCompareValue.class).stream()
                    .map(SearchCompareValue::getSkuCode).collect(Collectors.toList());
            List<String> bbb = JSONArray.parseArray((String) a.get(2), SearchCompareValue.class).stream()
                    .map(SearchCompareValue::getSkuCode).collect(Collectors.toList());
            List<String> add = new ArrayList<>(aaa);
            List<String> lose = new ArrayList<>(bbb);
            add.removeAll(bbb);
            lose.removeAll(aaa);
            System.out.println(a.get(0).toString());
            System.out.println("add:" + StringUtils.join(add, ","));
            System.out.println("lose:" + StringUtils.join(lose, ","));
            List<String> write = new ArrayList<>();
            write.add(a.get(0).toString());
            write.add(StringUtils.join(add, ","));
            write.add(StringUtils.join(lose, ","));
            adfdf.add(write);
            // rdd rddf = new rdd();
            // rddf.setAdd(StringUtils.join(add, ","));
            // rddf.setLose(StringUtils.join(lose, ","));
        }
        ExcelWriter writer = ExcelUtil.getWriter("C:/Users/binquan.cao/Desktop/对比汇总020300.xlsx", "sheet5");
        // 一次性写出内容，强制输出标题
        writer.write(adfdf);
        // 关闭writer，释放内存
        writer.close();
    }

    @Data
    public static class SearchCompare {
        private List<SearchCompareValue> ad;
        private List<SearchCompareValue> bd;
        private String adc;
    }

    @Data
    public static class SearchCompareValue {
        private String skuCode;
        private String productName;
    }

    @Data
    public static class rdd {
        private String add;
        private String lose;
    }
}
