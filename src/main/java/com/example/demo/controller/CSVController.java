package com.example.demo.controller;

import com.example.demo.utils.CSVUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
/**
 * @author {曹炳全}
 * @Description
 * @date 2021/6/23 15:30
 */

@Slf4j
@RestController
public class CSVController {

    /**
     * @param response
     * @return
     * @Description 下载CSV
     **/
    @GetMapping("/downloadAll")
    public String downloadAllUserRoleCSV(HttpServletResponse response) {
        String[] head = null;
        List<String[]> values = null;
        String fileName = "fileMame";

        File file = null;
        try {
            file = CSVUtils.makeTempCSV(fileName, head, values);
        } catch (IOException e) {
            e.printStackTrace();
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName +".csv");
        CSVUtils.downloadFile(response, file);
        return null;
    }

    /**
     * @return
     * @Description 上传CSV
     * @Param file
     **/
    @PostMapping(value = "/upload")
    public String upload(@RequestParam("file") MultipartFile multipartFile) {
        try {
            //上传内容不能为空
            if (multipartFile.isEmpty()) {
                return "500";
            }
            File file = CSVUtils.uploadFile(multipartFile);
            List<List<String>> userRoleLists = CSVUtils.readCSV(file.getPath(), 2);
//            service.doSth(userRoleLists);
            file.delete();
            return "200";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "500";
    }
}

