package com.kj.vo.news.category;

import com.kj.enums.DisplayContent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 破晓
 * @date 2022-01-10 13:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsCategoryUpdateVO {

    private Integer id;

    private String name;

    private Integer newsTypeId;

    private DisplayContent displayContent;
}
