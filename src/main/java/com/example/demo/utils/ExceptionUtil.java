package com.example.demo.utils;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author {曹炳全}
 * @Description
 * @date 2020/7/29 14:09
 */
public class ExceptionUtil {
    public static int handleException(int i, BlockException be) {
        be.printStackTrace();
        return 111111111;
    }
}
