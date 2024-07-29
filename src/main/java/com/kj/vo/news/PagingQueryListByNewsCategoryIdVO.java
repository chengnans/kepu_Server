package com.kj.vo.news;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 破晓
 * @date 2022-01-11 14:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagingQueryListByNewsCategoryIdVO {

    private Integer newsCategoryId;

    /**
     * 当前页
     */
    private Integer current;

    /**
     * 大小
     */
    private Integer size;
}
