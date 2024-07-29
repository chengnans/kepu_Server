package com.kj.vo.news;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * @author 破晓
 * @date 2022-01-09 15:36
 *
 * 新闻主体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsAddVO {

    private String title;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date releaseTime;

    private String content;

    //author与source为后加
    private String author;

    private String sources;

    private Integer newsCategoryId;
}
