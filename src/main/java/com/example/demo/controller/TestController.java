package com.example.demo.controller;

import com.alibaba.csp.ahas.shaded.com.alibaba.fastjson.JSON;
import com.alibaba.csp.ahas.shaded.com.alibaba.fastjson.JSONObject;
import com.example.demo.service.FlowControlService;
import com.example.demo.pojo.aa;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author {曹炳全}
 * @Description
 * @date 2020/7/28 17:42
 */
@RestController
public class TestController {


    @Autowired FlowControlService flowControlService;
    @GetMapping("/flowControl")
    public int flowControl() {
        for(int i=0;i<10;i++){
            flowControlService.clusterFlowControlTest(1);
        }
        int a= flowControlService.clusterFlowControlTest(11);
        System.out.println(a);
        return a;
    }
    @GetMapping("/flow2Control")
    public int flowControl2() {
        for(int i=0;i<10;i++){
            flowControlService.clusterFlowControlTest2(2);
        }
        int a= flowControlService.clusterFlowControlTest2(22);
        System.out.println(a);
        return a;
    }
    @GetMapping("/flow3Control")
    public int flowControl3() {
        for(int i=0;i<10;i++){
            flowControlService.clusterFlowControlTest3(3);
        }
        int a= flowControlService.clusterFlowControlTest3(33);
        System.out.println(a);
        return a;
    }
    @GetMapping("/flow4Control")
    public int flowControl4() {
        for(int i=0;i<10;i++){
            flowControlService.clusterFlowControlTest4(4);
        }
        int a= flowControlService.clusterFlowControlTest4(44);
        System.out.println(a);
        return a;
    }
    @GetMapping("/flow34Control")
    public int flowControl5() {
        int a = 0,b = 0;
        for(int i=0;i<10;i++){
            a=flowControlService.clusterFlowControlTest3(3);
            b=flowControlService.clusterFlowControlTest4(4);
            System.out.println("a:"+a+",b:"+b);
        }
        return a;
    }
    @GetMapping("/a")
    public void a() {
        System.out.println();


        for (int i = 0; i<10; i++){
            JSONObject aaa = JSON.parseObject("{\n" +
                    "        \"status\": \"OK\",\n" +
                    "        \"request_id\": \"159660823319733946411632\",\n" +
                    "        \"result\": {\n" +
                    "            \"searchtime\": 0.064594,\n" +
                    "            \"total\": 1,\n" +
                    "            \"num\": 1,\n" +
                    "            \"viewtotal\": 1,\n" +
                    "            \"compute_cost\": [\n" +
                    "                {\n" +
                    "                    \"index_name\": \"t_content\",\n" +
                    "                    \"value\": 0.334\n" +
                    "                }\n" +
                    "            ],\n" +
                    "            \"items\": [],\n" +
                    "            \"facet\": []\n" +
                    "        },\n" +
                    "        \"errors\": [],\n" +
                    "        \"tracer\": \"\",\n" +
                    "        \"ops_request_misc\": \"%7B%22request%5Fid%22%3A%22159660823319733946411632%22%2C%22scm%22%3A%2220140713.190013569..%22%7D\",\n" +
                    "        \"topContent\": []\n" +
                    "    }");
            Set<Map.Entry<String, Object>> dfdfdfd = aaa.entrySet();
            JSONObject results = aaa.getJSONObject("results");
//            String result = aaa.getJSONObject("results")==null?null:
//                    aaa.getJSONObject("results").getJSONArray("items").getJSONObject(0)==null?null:
//                            aaa.getJSONObject("results").getJSONArray("items").getJSONObject(0).getJSONObject("fields")==null?null:
//                                    aaa.getJSONObject("results").getJSONArray("items").getJSONObject(0).getJSONObject("fields").getString("modifieddate");
            JSONObject result = aaa.getJSONObject("result");
            if (result == null){
                continue;
            }
            JSONObject items = result.getJSONArray("items").getJSONObject(0);
            if (items == null){
                continue;
            }
            JSONObject fields = items.getJSONObject("fields");
            if (fields == null){
                continue;
            }
            String modifieddate = fields.getString("modifieddate");
                Set<String> strings = aaa.keySet();
            System.out.println("aa");
        }



    }
}
