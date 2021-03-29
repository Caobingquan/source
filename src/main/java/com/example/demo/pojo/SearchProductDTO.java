package com.example.demo.pojo;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;
import lombok.ToString;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * 搜索输出DTO类：商品<br>
 * 〈功能详细描述〉
 * 
 * @author David.Dong
 */
@Data
@ToString
public class SearchProductDTO {

    /**
     * skuCode
     */
    private String skuCode;

    /**
     * sku名称
     */
    private String skuName;

    /**
     * 商品编码
     */
    private String productCode;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 图片地址
     */
    private String picture;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 销量
     */
    private Long saleCnt;

    /**
     * 标题
     */
    private String title;

    /**
     * 简介
     */
    private String summary;

    /**
     * 描述
     */
    private String description;

    /**
     * 文案
     */
    private String content;

    /**
     * 跳转链接
     */
    private String jumpUrl;

    /**
     * 佣金(json)
     */
    private String brokerages;

    /**
     * 标签list(json)
     */
    private String tagList;

    /**
     * Label(20210207添加)
     */
    private String[] labels;

    /**是否微购商品，微购专区过滤使用*/
    private Boolean isMicroBuy;

    /**
     * channelList
     */
    @JsonIgnore
    private String channelList;

    /**
     * 是否可购channels
     */
    @JsonIgnore
    private String orderAbleChannels;

    /**
     * 是否可购
     */
    private Boolean orderable;

    /**
     * 产品即将销售配置时间
     */
    private Long exactOnlineDate;

    /**
     * 商品是否即将销售
     */
    private Boolean onTimeSale;

    public void setLabels(String label) {
        this.labels = StringUtils.split(label,'\t');
    }
}
