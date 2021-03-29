package generate;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ops_media
 * @author 
 */
@Data
public class OpsMedia implements Serializable {
    /**
     * 主键、url
     */
    private String id;

    /**
     * 二维码在前端显示的位置
     */
    private String alignmentstyle;

    private String host;

    /**
     * 缩略图
     */
    private String interimage;

    /**
     * 缩略图
     */
    private String interimage1280;

    /**
     * 缩略图
     */
    private String interimage140;

    /**
     * 缩略图
     */
    private String interimage319;

    /**
     * 缩略图
     */
    private String interimage48;

    private String isactivated;

    /**
     * 权重
     */
    private String keywords;

    /**
     * 链接类型：
     */
    private String link;

    /**
     * 最近修改时间
     */
    private Long modifieddate;

    /**
     * 图片路径，可多个图片，例如九宫格
     */
    private String photopath;

    /**
     * 图片类型
     */
    private String phototype;

    /**
     * 产品编号
     */
    private String productid;

    /**
     * 产品类型
     */
    private String producttype;

    /**
     * 发布时间
     */
    private Long publishdate;

    /**
     * 去除html tags后的文章内容，用于分词检索
     */
    private String strippedcontent;

    /**
     * 标签(预定义)
     */
    private String tags;

    /**
     * 标签路径
     */
    private String tagspath;

    /**
     * 标题
     */
    private String title;

    /**
     * url
     */
    private String url;

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