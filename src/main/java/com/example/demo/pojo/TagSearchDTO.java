/**
 * @author: Alen Cao
 * @description:
 * @time: 2020/9/28 14:15
 */

package com.example.demo.pojo;

import java.util.List;

import lombok.Data;

@Data
public class TagSearchDTO
{
   /**
    * 业务编号
    */
   private String code;
   /**
    * 标签名称
    */
   private String name;
   /**
    * 标签类型
    */
   private String type;
   /**
    * 渠道
    */
   private String channelCode;
   /**
    * 角色
    */
   private String role;
   /**
    * 标签图标
    */
   private String icon;
   /**
    * 优先级
    */
   private Integer priority;
   /**
    * 可见页面
    */
   private List<String> visiblePages;
}
