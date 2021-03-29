package com.example.demo.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * json格式化
 * 
 * @author GONG036
 */
@Slf4j
public class JsonFormat {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String getJsonString(Object o) {
        StringWriter str = new StringWriter();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        ;
        try {
            objectMapper.writeValue(str, o);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return str.toString();
    }

    public static Object getObj(Class c, String jsonString) {
        if (StringUtils.isEmpty(jsonString)){
            return null;
        }
        try {
            return objectMapper.readValue(jsonString, c);
        } catch (Exception e) {
            log.info("jsonString:" + jsonString);
            log.error(e.getMessage());
            return null;
        }
    }

    /**
     * JSON字符串转换为Java泛型对象 例1：String jsonStr =
     * "[{\"id\":\"1234\",\"account\":\"admin\"}]"; List<UserInfo> list =
     * JsonUtil.json2GenericObject(jsonStr, new TypeReference<List<UserInfo>>()
     * {}); 例2：String jsonStr = "[\"1111\",\"2222\",\"3333\"]"; List<String>
     * list = JsonUtil.json2GenericObject(jsonStr, new
     * TypeReference<List<String>>() {});
     * 
     * @param <T>
     *            转换泛型
     * @param jsonString
     *            JSON字符串
     * @param clazz
     *            需要转换的对象类型
     * @return Java泛型对象
     */
    public static <T> List<T> json2GenericObject(String jsonString,
            Class<T> clazz) {
        if (StringUtils.isNotEmpty(jsonString)) {
            JavaType javaType = objectMapper.getTypeFactory()
                    .constructParametricType(ArrayList.class, clazz);
            try {
                return objectMapper.readValue(jsonString, javaType);
            } catch (Exception e) {
                log.error("json2GenericObject error:" + e.getMessage());
            }
        }
        return Collections.emptyList();
    }

}
