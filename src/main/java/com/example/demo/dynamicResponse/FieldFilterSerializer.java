package com.example.demo.dynamicResponse;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * 动态返回字段
 */
public class FieldFilterSerializer {

    /**
     * 想要保留的字段标识
     */
    private static final String DYNC_INCLUDE="DYNC_INCLUDE";
    /**
     * 想要过滤的字段标识
     */
    private static final String DYNC_EXCLUDE="DYNC_EXCLUDE";
    /**
     * jackson核心类 过滤属性全部由这个类完成
     */
    private ObjectMapper mapper = new ObjectMapper();

    @JsonFilter(DYNC_EXCLUDE)
    interface DynamicExclude{}

    @JsonFilter(DYNC_INCLUDE)
    interface DynamicInclude{}

    /**
     * 过滤字段
     *
     * @param clazz     需要过滤的class
     * @param include   需要保留的字段
     * @param exclude   需要过滤的字段
     */
    public void filter(Class<?> clazz, String include, String exclude){
        if (StringUtils.isNotEmpty(include)){
            mapper.setFilterProvider(new SimpleFilterProvider().
                    addFilter(DYNC_INCLUDE, SimpleBeanPropertyFilter.filterOutAllExcept(include.split(","))));
            mapper.addMixIn(clazz, DynamicInclude.class);
        }else if (StringUtils.isNotEmpty(exclude)){
            mapper.setFilterProvider(new SimpleFilterProvider().
                    addFilter(DYNC_EXCLUDE, SimpleBeanPropertyFilter.filterOutAllExcept(exclude.split(","))));
            mapper.addMixIn(clazz, DynamicExclude.class);
        }
    }

    /**
     * 返回过滤后的json格式的字符串
     *
     * @param object
     * @return
     * @throws JsonProcessingException
     */
    public String toJSONString(Object object) throws JsonProcessingException {
        //解决Jackson2无法反序列化LocalDateTime的问题
        //这里要注意时间属性上要加入@JsonFormat注解，否则无法正常解析
        mapper.registerModule(new JavaTimeModule());
        //将类转换成json字符串返回
        return mapper.writeValueAsString(object);
    }
}
