package com.example.demo.test;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.util.StringUtils;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import org.apache.poi.ss.formula.functions.T;
import org.junit.jupiter.api.Test;

import com.example.demo.pojo.User;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author {曹炳全}
 * @Description
 * @date 2021/2/18 16:00
 */
@Slf4j
public class fileTest {
    /**
     * 生成文件
     */
    @Test
    void a1() {
        String url = "C:\\Users\\binquan.cao\\Desktop\\";
        String slash = "/";
        String path = "aa";
        String writePath = path  + slash+ "dataCountList";
        //获取表头
        List<List<String>> headList = new ArrayList<>();
        List<String> st = new ArrayList<>();
        st.add("test");
        st.add("aa");
        List<String> st1 = new ArrayList<>();
        st1.add("test");
        st1.add("bb");
        headList.add(st);
        headList.add(st1);
        List<List<String>> dataValueList2 = new ArrayList<>();
        List<String> st2 = new ArrayList<>();
        st2.add("11");
        st2.add("222");
        List<String> st3 = new ArrayList<>();
        st3.add("33");
        st3.add("44");
        dataValueList2.add(st2);
        dataValueList2.add(st3);
        List<User> dataValueList = new ArrayList<>();
        User user = new User();
        user.setName("aa");
        user.setPass("aaaaaa");
        dataValueList.add(user);
        String fileName =  "as.csv";
        String fileUrlAndName = url + slash + "dataCountList" + slash + fileName;

        writeFileForExcel(writePath, fileName, "Sheet", headList, dataValueList);

    }

    public static void writeFileForExcel(String filePathName, String fileName, String sheetName, List<List<String>> headNameList, List dataValueList) {
        String slash = "/";
        File file = new File(filePathName);
        if (!file.exists()) {
            file.mkdirs();
        }

        String filePathAndName = filePathName + slash + fileName;
        if (StringUtils.isEmpty(sheetName)) {
            sheetName = "sheet";
        }

        EasyExcelFactory.write(filePathAndName, String.class).head(User.class).sheet(sheetName).doWrite(dataValueList);
    }

}
