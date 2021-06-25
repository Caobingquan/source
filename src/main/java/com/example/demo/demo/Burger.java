package com.example.demo.demo;

/**
 * @author {曹炳全}
 * @Description
 * @date 2021/4/21 9:55
 */
public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
