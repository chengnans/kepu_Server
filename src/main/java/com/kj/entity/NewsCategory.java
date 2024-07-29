package com.kj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.kj.enums.DisplayContent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 破晓
 * @date 2022-01-09 15:11
 *
 * 新闻类别（小标题）
 */
@TableName("news_category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsCategory {

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 新闻类别名
     */
    private String name;

    /**
     * 所属的新闻类型id
     */
    private Integer newsTypeId;

    /**
     * 展示的类型
     */
    private DisplayContent displayContent;

    private Date createTime;

    private Date updateTime;
}
