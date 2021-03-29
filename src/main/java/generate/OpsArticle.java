package generate;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ops_article
 * @author 
 */
@Data
public class OpsArticle implements Serializable {
    /**
     * 主键、url
     */
    private String id;

    /**
     * 是否仅供ABO查阅
     */
    private Integer aboreadonly;

    /**
     * AEM搜索的关键词
     */
    private String aemtags;

    private String aemtagspath;

    /**
     * 允许查阅的职级
     */
    private String allowidentities;

    /**
     * 是否可分享
     */
    private Integer allowshare;

    /**
     * 文章附件地址
     */
    private String attachments;

    private String author;

    private String baseid;

    private String brands;

    private String category;

    private String channel;

    private String classes;

    /**
     * 类目预测
     */
    private String contenttag;

    private String customcategory;

    /**
     * 简介
     */
    private String description;

    /**
     * 前端是否显示发布时间
     */
    private Long displaypublishtime;

    private String favoritetags;

    /**
     * 域名
     */
    private String host;

    private String imagearraypath;

    private String jcrtitle;

    /**
     * 下拉提示和权重配置
     */
    private String keywords;

    private String labels;

    /**
     * 最近修改时间
     */
    private Long modifieddate;

    private String module;

    private String name;

    /**
     * 是否可被搜索
     */
    private Integer nosearch;

    private String originalimgpath;

    private String people;

    /**
     * 是否推广文章
     */
    private Long promotion;

    /**
     * 发布时间
     */
    private Long publishdate;

    private String searchtype;

    private String sentiments;

    /**
     * 源数据
     */
    private String source;

    /**
     * 去除html tags后的文章内容，用于分词检索
     */
    private String strippedcontent;

    /**
     * 标签(预定义)
     */
    private String tags;

    private String tagspath;

    private String textdescription;

    /**
     * 缩略图url
     */
    private String thumbnail;

    private String thumbnailbig;

    /**
     * Content APP专用封面图字段
     */
    private String thumbnailcontentapp;

    private String thumbnailthree;

    /**
     * 缩略图类型
     */
    private String thumbnailtype;

    /**
     * 标题
     */
    private String title;

    /**
     * url
     */
    private String url;

    /**
     * 超清视频地址
     */
    private String videoFhd;

    /**
     * 高清视频地址
     */
    private String videoHd;

    private String videoHeight;

    private String videoLow;

    /**
     * 标清视频地址
     */
    private String videoSd;

    private String videoSuper;

    private String videoid;

    private String videoimgsurl;

    /**
     * 视频时长
     */
    private Integer videolen;

    /**
     * 视频地址
     */
    private String videopath;

    /**
     * 视频封面图
     */
    private String videoposter;

    private String videotitle;

    /**
     * 热度
     */
    private Integer views;

    /**
     * 状态（1表示上传到ops,0表示不上传ops）
     */
    private Integer status;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;
}