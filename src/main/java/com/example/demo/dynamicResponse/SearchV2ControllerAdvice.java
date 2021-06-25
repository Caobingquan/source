/*
package com.example.demo.dynamicResponse;

import java.lang.reflect.AnnotatedElement;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;

*/
/**
 * Created by Peiyao.Wang on 2021/3/29
 *
 * @author Peiyao.Wang
 * @date 2021/3/29
 * @Description TODO 动态过滤SearchV2Controller返回给前端字段
 *//*

@ControllerAdvice
@RefreshScope
@Slf4j
public class SearchV2ControllerAdvice implements ResponseBodyAdvice {
    @Value("${amway.search.advice.v2.switch:true}")
    public Boolean adviceV2Switch;

    @Resource
    private OpsFieldsFilterConfig opsFieldsFilterConfig;

    @Override
    public boolean supports(MethodParameter methodParameter, Class converterType) {
        if (!adviceV2Switch) {
            return false;
        }
        AnnotatedElement annotatedElement = methodParameter.getAnnotatedElement();
        FieldFilterV2Annotation annotation = AnnotationUtils.findAnnotation(annotatedElement, FieldFilterV2Annotation.class);
        return annotation != null;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (o instanceof CommonResponse) {
            CommonResponse commonResponse = (CommonResponse) o;
            if (commonResponse.getStatus() != 0) {
                return commonResponse;
            }
            if (commonResponse.getResults() == null) {
                return commonResponse;
            }
            SearchBaseOutputDTO searchBaseOutputDTO = (SearchBaseOutputDTO)commonResponse.getResults();
            List<SearchProductDTO> itemList = searchBaseOutputDTO.getItems();
            if(!CollectionUtils.isEmpty(itemList)){
                if(!(itemList.get(0) instanceof SearchProductDTO)){
                    return commonResponse;
                }

                ServletServerHttpRequest servletServerHttpRequest = (ServletServerHttpRequest) request;
                HttpServletRequest httpServletRequest=   servletServerHttpRequest.getServletRequest();
                String requestURI = httpServletRequest.getRequestURI();
                String[] values = requestURI.split("/");
                String platformValue = values[3];
                log.info("SearchV2ControllerAdvice platformValue={}",platformValue);
                FieldFilterSerializer filterSerializer = new FieldFilterSerializer();
                filterSerializer.filter(SearchProductDTO.class,opsFieldsFilterConfig.getIncludePlatformMap().get(platformValue),null);
                String json = null;
                try{
                    json =  filterSerializer.toJSONString(itemList);
                }catch(JsonProcessingException e){
                    log.error("advice JsonProcessingException line 84 e={}",e.getMessage());
                }
                List<JSONObject> jsonObjects = JSON.parseArray(json, JSONObject.class);

                searchBaseOutputDTO.setItems(jsonObjects);
            }
            return commonResponse;
        }
        return o;
    }
}
*/
