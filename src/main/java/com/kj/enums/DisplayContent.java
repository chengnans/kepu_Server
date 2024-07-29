package com.kj.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author 破晓
 * @date 2022-01-09 15:24
 *
 * 小标题下展示的类型
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum DisplayContent {

    NEWS_LIST(0, "新闻列表"),
    NEWS(1, "新闻"),
    LINK(2, "链接");

    @EnumValue
    private Integer key;

    @JsonValue
    private String display;
}
