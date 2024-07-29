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
 * @date 2022-01-09 14:01
 *
 * 新闻类型（大标题）
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsTypeDTO {

    private Integer id;

    /**
     * 新闻类型名
     */
    private String name;
}
