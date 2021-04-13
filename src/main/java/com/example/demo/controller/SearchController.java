package com.example.demo.controller;

import java.util.*;

import cn.hutool.core.text.csv.CsvData;
import cn.hutool.core.text.csv.CsvReader;
import cn.hutool.core.text.csv.CsvRow;
import cn.hutool.core.text.csv.CsvUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSONArray;
import com.example.demo.form.IndexItemForm;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.hutool.core.io.FileUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

import com.alibaba.fastjson.JSON;

/**
 * @author {曹炳全}
 * @Description
 * @date 2021/2/19 17:42
 */
@Slf4j
@RestController
public class SearchController {
    /**
     * deleteId
     */
    @GetMapping("/deleteIdEXCEL")
    public Object aa() {
        ExcelReader reader = ExcelUtil.getReader(FileUtil.file("C:\\Users\\binquan.cao\\Desktop\\物料id.xlsx"));
        List<List<Object>> read = reader.read();
        List<String> ids = new ArrayList<>();
        for (List<Object> a : read) {
            String id = (String) a.get(0);
            ids.add(id);
        }
        String body = "[{\"cmd\":\"delete\",\"fields\":{\"id\":\"{keyId}\"},\"timestamp\":1616478686527}]";
    
        for (String id : ids) {
            String reBody = body.replace("{keyId}", id);

            /*String v3response = HttpRequest.post("https://search-api.amway.com.cn/dataport/v3/index/content")
                    .header("Authorization", "APPCODE d07419f91fed48c192592bd6792adb98").body(reBody).execute().body();
            log.info("v3:id:{},response:{}", id, v3response);
            String v1response = HttpRequest
                    .post("https://asc.amwaynet.com.cn/amway-search/v1/index/searchcenter_article/articles?sync=true")
                    .header("Authorization", "APPCODE d5f43e14c6a94705a16ad03ea1a0713c").header("token", "eyJhbGciOiJSUzI1NiIsImtpZCI6InNlYXJjaF9rZXkifQ.eyJqdGkiOiJjSHJuUExyb1dSQV9MYzNYWEZld0RBIiwiaWF0IjoxNjE3MzM0NDYzLCJleHAiOjE2MjA5MzQ0NjMsIm5iZiI6MTYxNzMzNDQwMywic3ViIjoic2VhcmNoIiwiaXNzIjoiYW13YXktc2VhcmNoIiwiYXVkIjoiYW13YXkiLCJhdWRQcm9qZWN0IjoiYWVtIiwiYXVkU2VydmljZSI6InNlYXJjaCIsImF1ZEVudmlyb25tZW50IjoicHJvZCIsImF1ZE9yZ2FuaXphdGlvbiI6IkFtd2F5In0.cm9jASEHcrV335XYkvPYvI4nf45m1N-XE7S9pz1Fv43zdfBuCa22JjfjDbzReQ5eFhGl2NVuUUB361KF5FSdm29rRzQYLJwK1_3E9FPAsdBMGCIc_80dxov43VTNb81qOeKXxSzBSsHpYJ4KyQms9xPq8iWFElbR4Ob86-4Jx4ErxMzUfiTOI6EMON9OPq_j8PXmCj2PyDYgFBROxGqgJ9hcavWJYl1ceQwOJoKK2h3GhVZ5VwW62c3KgdX9L2Tn2cXjgmR9pItmNG0jVyFsE5DvZT-0GROJiQDr34MIgeavfmgNtmOpKStQ4lrjDap-2ORdQFDwESAvcaJNlxQVzg")
                    .body(reBody).execute().body();
            log.info("v1:id:{},response:{}", id, v1response);*/
        }
        System.out.println("over");
        return "over";
    }

    /**
     * deleteId
     */
    @GetMapping("/deleteIdCSV")
    public Object bb() {
        CsvReader reader = CsvUtil.getReader();
        //从文件中读取CSV数据
        CsvData data = reader.read(FileUtil.file("C:\\Users\\binquan.cao\\Desktop\\deleteId.csv"));
        List<CsvRow> rows = data.getRows();
        List<String> ids = new ArrayList<>();
        //遍历行
        for (CsvRow csvRow : rows) {
            String id = csvRow.getRawList().get(1);
            ids.add(id);
        }

        String body = "[{\"cmd\":\"delete\",\"fields\":{\"id\":\"{keyId}\"},\"timestamp\":1616478686527}]";

        for (String id : ids) {
            String reBody = body.replace("{keyId}", id);

            String v3response = HttpRequest.post("https://search-api.amway.com.cn/dataport/v3/index/content")
                    .header("Authorization", "APPCODE d07419f91fed48c192592bd6792adb98").body(reBody).execute().body();
            log.info("v3:id:{},response:{}", id, v3response);
            String v1responseArticle = HttpRequest
                    .post("https://asc.amwaynet.com.cn/amway-search/v1/index/searchcenter_article/articles?sync=true")
                    .header("Authorization", "APPCODE d5f43e14c6a94705a16ad03ea1a0713c").header("token", "eyJhbGciOiJSUzI1NiIsImtpZCI6InNlYXJjaF9rZXkifQ.eyJqdGkiOiJjSHJuUExyb1dSQV9MYzNYWEZld0RBIiwiaWF0IjoxNjE3MzM0NDYzLCJleHAiOjE2MjA5MzQ0NjMsIm5iZiI6MTYxNzMzNDQwMywic3ViIjoic2VhcmNoIiwiaXNzIjoiYW13YXktc2VhcmNoIiwiYXVkIjoiYW13YXkiLCJhdWRQcm9qZWN0IjoiYWVtIiwiYXVkU2VydmljZSI6InNlYXJjaCIsImF1ZEVudmlyb25tZW50IjoicHJvZCIsImF1ZE9yZ2FuaXphdGlvbiI6IkFtd2F5In0.cm9jASEHcrV335XYkvPYvI4nf45m1N-XE7S9pz1Fv43zdfBuCa22JjfjDbzReQ5eFhGl2NVuUUB361KF5FSdm29rRzQYLJwK1_3E9FPAsdBMGCIc_80dxov43VTNb81qOeKXxSzBSsHpYJ4KyQms9xPq8iWFElbR4Ob86-4Jx4ErxMzUfiTOI6EMON9OPq_j8PXmCj2PyDYgFBROxGqgJ9hcavWJYl1ceQwOJoKK2h3GhVZ5VwW62c3KgdX9L2Tn2cXjgmR9pItmNG0jVyFsE5DvZT-0GROJiQDr34MIgeavfmgNtmOpKStQ4lrjDap-2ORdQFDwESAvcaJNlxQVzg")
                    .body(reBody).execute().body();
            log.info("v1:id:{},response:{}", id, v1responseArticle);
            String v1responseMedia = HttpRequest
                    .post("https://asc.amwaynet.com.cn/amway-search/v1/index/searchcenter_media/images?sync=true")
                    .header("Authorization", "APPCODE d5f43e14c6a94705a16ad03ea1a0713c").header("token", "eyJhbGciOiJSUzI1NiIsImtpZCI6InNlYXJjaF9rZXkifQ.eyJqdGkiOiJjSHJuUExyb1dSQV9MYzNYWEZld0RBIiwiaWF0IjoxNjE3MzM0NDYzLCJleHAiOjE2MjA5MzQ0NjMsIm5iZiI6MTYxNzMzNDQwMywic3ViIjoic2VhcmNoIiwiaXNzIjoiYW13YXktc2VhcmNoIiwiYXVkIjoiYW13YXkiLCJhdWRQcm9qZWN0IjoiYWVtIiwiYXVkU2VydmljZSI6InNlYXJjaCIsImF1ZEVudmlyb25tZW50IjoicHJvZCIsImF1ZE9yZ2FuaXphdGlvbiI6IkFtd2F5In0.cm9jASEHcrV335XYkvPYvI4nf45m1N-XE7S9pz1Fv43zdfBuCa22JjfjDbzReQ5eFhGl2NVuUUB361KF5FSdm29rRzQYLJwK1_3E9FPAsdBMGCIc_80dxov43VTNb81qOeKXxSzBSsHpYJ4KyQms9xPq8iWFElbR4Ob86-4Jx4ErxMzUfiTOI6EMON9OPq_j8PXmCj2PyDYgFBROxGqgJ9hcavWJYl1ceQwOJoKK2h3GhVZ5VwW62c3KgdX9L2Tn2cXjgmR9pItmNG0jVyFsE5DvZT-0GROJiQDr34MIgeavfmgNtmOpKStQ4lrjDap-2ORdQFDwESAvcaJNlxQVzg")
                    .body(reBody).execute().body();
            log.info("v1:id:{},response:{}", id, v1responseMedia);
        }
        System.out.println("over");
        return "over";
    }

}
