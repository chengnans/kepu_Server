package com.kj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 破晓
 * @date 2022-01-09 15:36
 *
 * 新闻主体
 */
@TableName("news")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class News {

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 展示图片路径
     */
    private String picturePath;

    /**
     * 标题
     */
    private String title;

    /**
     * 发布时间
     */
    private Date releaseTime;

    /**
     * 点击率
     */
    private Integer hits;

    /**
     * 内容
     */
    private String content;


    //作者和来源为后加，需实现
    /**
     * 作者
     */
    private String author;

    /**
     * 来源
     */
    private String sources;

    /**
     * 文章所属类别id
     */
    private Integer newsCategoryId;

    private Date createTime;

    private Date updateTime;
}
