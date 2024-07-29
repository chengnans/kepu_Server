package com.kj.dto;

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
 * 查询新闻主体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsQueryDTO {

    private Integer id;

    private String title;

    private Date releaseTime;

    private Integer hits;

    private String content;
    //author和source为后加
    private String author;
    private String sources;
}
