package com.example.demo.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author {曹炳全}
 * @Description
 * @date 2021/1/14 17:59
 */
@Data
public class User {
    private int id;
    private BigDecimal price;
    private Long age;
    private String name;
    private String pass;
    private String school;
    private String school2;
    private List<Demo> demos;

}
