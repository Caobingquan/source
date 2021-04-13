package com.example.demo.form;

import java.util.Map;

import lombok.Data;

/**
 * @author 吴宏昌
 * @Description
 * @date 19-7-29
 */
@Data
public class IndexItemForm {
    private String cmd;
    private Long timestamp;
    private Map<String, Object> fields;
}
