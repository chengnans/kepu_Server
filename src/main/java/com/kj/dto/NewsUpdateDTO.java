package com.kj.dto;

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
public class NewsUpdateDTO {

    private MultipartFile pictureFile;

    private String picturePath;

    private Integer id;

    private String title;

    private Date releaseTime;

    private Integer hits;

    private String content;

    private Integer newsCategoryId;

    //author和source为后加
    private String author;

    private String sources;
}
