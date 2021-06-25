package com.example.demo.demo;

/**
 * @author {曹炳全}
 * @Description
 * @date 2021/4/21 9:55
 */
public class VegBurger extends Burger {

    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String name() {
        return "Veg Burger";
    }
}
