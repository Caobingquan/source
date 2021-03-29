package com.example.demo.service;

import com.alibaba.csp.sentinel.EntryType;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.demo.utils.ExceptionUtil;
import org.springframework.stereotype.Service;

/**
 * @author {曹炳全}
 * @Description
 * @date 2020/7/28 17:33
 */
@Service
public class FlowControlService {

    @SentinelResource(entryType = EntryType.IN,value = "clusterFlowControl",blockHandler = "handleException",blockHandlerClass = {
            ExceptionUtil.class})
    public int clusterFlowControlTest(int i) {
        return i;
    }
    @SentinelResource(entryType = EntryType.IN,value = "clusterFlowControl2",blockHandler = "handleException2")
    public int clusterFlowControlTest2(int i) {
        return i;
    }
    @SentinelResource(entryType = EntryType.IN,value = "clusterFlowControl3",blockHandler = "handleException3")
    public int clusterFlowControlTest3(int i) {
        return i;
    }
    @SentinelResource(entryType = EntryType.IN,value = "clusterFlowControl3",blockHandler = "handleException4")
    public int clusterFlowControlTest4(int i) {
        return i;
    }
    public int handleException2(int i, BlockException ex) {
        ex.printStackTrace();
        return 22222222;
    }
    public int handleException3(int i, BlockException ex) {
        ex.printStackTrace();
        return 33333333;
    }
    public int handleException4(int i, BlockException ex) {
        ex.printStackTrace();
        return 44444444;
    }
}

