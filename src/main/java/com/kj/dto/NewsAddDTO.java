package com.kj.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
public class NewsAddDTO {

    private MultipartFile pictureFile;

    private String picturePath;

    private String title;

    private Date releaseTime;

    private String content;

    private Integer newsCategoryId;
    //author和source为后加
    private String author;

    private String sources;
}
